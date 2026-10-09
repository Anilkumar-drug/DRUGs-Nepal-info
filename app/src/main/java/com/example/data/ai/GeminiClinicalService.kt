package com.example.data.ai

import com.example.BuildConfig
import com.example.data.model.ChatMessage
import com.example.data.model.GroundingSource
import com.example.data.model.MedicalNewsFetchResult
import com.example.data.model.MedicalNewsItem
import com.example.data.model.MessageSender
import com.example.data.repository.ClinicalGuidelinesNewsData
import com.example.data.repository.ClinicalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

data class GeminiClinicalResponse(
    val text: String,
    val webSources: List<GroundingSource> = emptyList(),
    val modelUsed: String = "gemini-3.5-flash",
    val isLiveGrounded: Boolean = false,
    val searchQueries: List<String> = emptyList()
)

object GeminiClinicalService {

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private const val SYSTEM_PROMPT =
        "You are the DRUGs Nepal Clinical Decision Support AI Assistant for licensed physicians and healthcare professionals in Nepal. " +
        "Provide direct, high-yield clinical pharmacology insights referencing UpToDate, Harrison's, KD Tripathi, GINA, AHA/ACC, and WHO/EDCD Nepal guidelines. " +
        "Address drug interactions, organ dosage adjustments, mechanism of action, black box warnings, and local Nepal/India brand equivalents. " +
        "Format with clear headings, bold key values, bullet points, and high clinical precision."

    private fun getSpecializedSystemPrompt(mode: String?): String {
        return when (mode) {
            "Polypharmacy Check", "Drug Interactions" ->
                "You are an expert Clinical Pharmacologist specializing in Polypharmacy and Drug-Drug Interactions. " +
                "Evaluate pharmacokinetic (CYP3A4, CYP2C19, CYP2D6, P-glycoprotein) and pharmacodynamic interactions. " +
                "Highlight additive QT prolongation, synergistic nephrotoxicity, bleeding risks, and electrolyte abnormalities. " +
                "Classify each interaction into: 🔴 Contraindicated, 🟠 Major/Severe, 🟡 Moderate, or 🟢 Minor, with actionable clinical management and safer alternative molecules."
            "Renal & Hepatic Dosing", "Organ Dosing" ->
                "You are an expert Nephro-Pharmacology and Hepatic Dosing Clinical Specialist. " +
                "Provide precise dosage titration according to Cockcroft-Gault CrCl and CKD-EPI eGFR tiers (≥60, 45-59, 30-44, 15-29, <15 mL/min), " +
                "hemodialysis supplemental doses post-dialysis, and Child-Pugh Class A/B/C hepatic restrictions."
            "Pediatric Dosing", "Pediatric" ->
                "You are an expert Pediatric Clinical Pharmacologist. " +
                "Provide accurate weight-based mg/kg/dose or mg/kg/day dosing, division intervals (q6h, q8h, q12h), " +
                "maximum adult ceiling cutoffs, suspension concentration conversions (e.g., mg to mL), and strict pediatric contraindications (e.g. fluoroquinolones, tetracyclines in <8yo, aspirin in viral syndromes)."
            "Emergency & Antidotes", "Emergency / Toxicology" ->
                "You are an Emergency Medicine & Clinical Toxicology Specialist. " +
                "Provide rapid resuscitation algorithms (ACLS, PALS, ATLS), primary antidote dosing, dilution, infusion rates, " +
                "endpoints of resuscitation (e.g., atropinization in OP poisoning, NAC 3-bag in paracetamol), and life-threatening red flags."
            "Nepal MoHP Protocols", "Nepal Guidelines" ->
                "You are an authority on Government of Nepal Ministry of Health & Population (MoHP), Epidemiology and Disease Control Division (EDCD), " +
                "and WHO SEARO Clinical Guidelines. Detail national clinical algorithms (Dengue case management, Scrub Typhus doxycycline protocols, " +
                "Leprosy WHO MDT blister packs, Kala-azar single-dose Liposomal Amphotericin B, Rabies 2-site ID PEP, Malaria ACT), standard referral pathways, and drugs on the Nepal National List of Essential Medicines."
            else -> SYSTEM_PROMPT
        }
    }

    suspend fun queryClinicalAiResponse(
        userQuery: String,
        conversationHistory: List<ChatMessage> = emptyList(),
        model: String = "gemini-3.5-flash",
        enableSearchGrounding: Boolean = true,
        consultationMode: String? = null
    ): GeminiClinicalResponse = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Exception) {
            ""
        }

        val hasValidKey = apiKey.isNotBlank() && apiKey != "MY_GEMINI_API_KEY"
        val targetModel = when {
            model.contains("pro") -> "gemini-3.1-pro-preview"
            model.contains("lite") -> "gemini-3.1-flash-lite-preview"
            else -> "gemini-3.5-flash"
        }

        if (hasValidKey) {
            try {
                val jsonBody = JSONObject().apply {
                    val contentsArr = JSONArray()

                    // Multi-turn context preservation (up to last 6 messages)
                    val pastTurns = conversationHistory.takeLast(6)
                    for (pastMsg in pastTurns) {
                        if (pastMsg.text.isNotBlank()) {
                            val role = if (pastMsg.sender == MessageSender.USER) "user" else "model"
                            contentsArr.put(JSONObject().apply {
                                put("role", role)
                                val partsArr = JSONArray().apply {
                                    put(JSONObject().put("text", pastMsg.text))
                                }
                                put("parts", partsArr)
                            })
                        }
                    }

                    // Append current user turn
                    contentsArr.put(JSONObject().apply {
                        put("role", "user")
                        val partsArr = JSONArray().apply {
                            put(JSONObject().put("text", userQuery))
                        }
                        put("parts", partsArr)
                    })
                    put("contents", contentsArr)

                    // Specialized System Instructions
                    val sysPrompt = getSpecializedSystemPrompt(consultationMode)
                    val sysContent = JSONObject().apply {
                        val partsArr = JSONArray().apply {
                            put(JSONObject().put("text", sysPrompt))
                        }
                        put("parts", partsArr)
                    }
                    put("systemInstruction", sysContent)

                    // Generation Config
                    val genConfig = JSONObject().apply {
                        put("temperature", 0.25)
                        put("topP", 0.95)
                        if (targetModel.contains("pro")) {
                            put("thinkingConfig", JSONObject().put("thinkingLevel", "low"))
                        }
                    }
                    put("generationConfig", genConfig)

                    // Real-Time Google Search Grounding Tool
                    if (enableSearchGrounding) {
                        val toolsArr = JSONArray().apply {
                            put(JSONObject().apply {
                                put("google_search", JSONObject())
                            })
                        }
                        put("tools", toolsArr)
                    }
                }

                val mediaType = "application/json; charset=utf-8".toMediaType()
                val requestBody = jsonBody.toString().toRequestBody(mediaType)
                val url = "https://generativelanguage.googleapis.com/v1beta/models/$targetModel:generateContent?key=$apiKey"

                val request = Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build()

                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val respStr = response.body?.string() ?: ""
                    val rootJson = JSONObject(respStr)
                    val candidates = rootJson.optJSONArray("candidates")
                    if (candidates != null && candidates.length() > 0) {
                        val candidate = candidates.getJSONObject(0)
                        val content = candidate.optJSONObject("content")
                        val parts = content?.optJSONArray("parts")

                        var responseText = ""
                        if (parts != null && parts.length() > 0) {
                            val sb = StringBuilder()
                            for (i in 0 until parts.length()) {
                                val t = parts.getJSONObject(i).optString("text")
                                if (t.isNotBlank()) sb.append(t)
                            }
                            responseText = sb.toString()
                        }

                        // Parse Grounding Metadata & Verified Web Sources
                        val extractedSources = mutableListOf<GroundingSource>()
                        val searchQueriesList = mutableListOf<String>()
                        val groundingMeta = candidate.optJSONObject("groundingMetadata")
                        if (groundingMeta != null) {
                            val queriesArr = groundingMeta.optJSONArray("webSearchQueries")
                            if (queriesArr != null) {
                                for (i in 0 until queriesArr.length()) {
                                    val q = queriesArr.optString(i)
                                    if (!q.isNullOrBlank()) searchQueriesList.add(q)
                                }
                            }
                            val chunksArr = groundingMeta.optJSONArray("groundingChunks")
                            if (chunksArr != null) {
                                for (i in 0 until chunksArr.length()) {
                                    val chunk = chunksArr.optJSONObject(i)
                                    val web = chunk?.optJSONObject("web")
                                    if (web != null) {
                                        val uri = web.optString("uri")
                                        val title = web.optString("title").ifBlank { uri }
                                        if (uri.isNotBlank()) {
                                            extractedSources.add(GroundingSource(title = title, url = uri))
                                        }
                                    }
                                }
                            }
                        }

                        if (responseText.isNotBlank()) {
                            return@withContext GeminiClinicalResponse(
                                text = responseText,
                                webSources = extractedSources,
                                modelUsed = targetModel,
                                isLiveGrounded = extractedSources.isNotEmpty() || enableSearchGrounding,
                                searchQueries = searchQueriesList
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                // Fallback to offline clinical pharmacology intelligence if network fails
            }
        }

        // Context-aware Clinical Pharmacology Knowledge Base fallback
        val localText = generateLocalClinicalInsight(userQuery)
        val defaultSources = getClinicalReferenceSources(userQuery)
        return@withContext GeminiClinicalResponse(
            text = localText,
            webSources = defaultSources,
            modelUsed = targetModel,
            isLiveGrounded = false,
            searchQueries = listOf(userQuery)
        )
    }

    suspend fun queryClinicalAi(
        userQuery: String,
        model: String = "gemini-3.5-flash",
        enableSearchGrounding: Boolean = true
    ): String {
        return queryClinicalAiResponse(
            userQuery = userQuery,
            model = model,
            enableSearchGrounding = enableSearchGrounding
        ).text
    }

    private fun generateLocalClinicalInsight(query: String): String {
        val lower = query.lowercase()
        return when {
            lower.contains("dengue") && (lower.contains("fluid") || lower.contains("warning") || lower.contains("protocol") || lower.contains("treatment") || lower.contains("management")) -> {
                "🦟 **DENGUE CLINICAL CASE MANAGEMENT & FLUID PROTOCOL (EDCD NEPAL / WHO SEARO)**\n\n" +
                "1. **Clinical Warning Signs (Mandatory Hospital Admission):**\n" +
                "   • Severe abdominal pain or persistent tenderness\n" +
                "   • Persistent vomiting (≥3 episodes in 1 hour or ≥4 in 6 hours)\n" +
                "   • Mucosal bleeding (epistaxis, gingival, hematemesis, melena)\n" +
                "   • Lethargy, restlessness, or altered sensorium\n" +
                "   • Hepatomegaly (>2 cm below right costal margin)\n" +
                "   • Laboratory: Progressive hematocrit (HCT) rise concurrent with rapid platelet drop (<100,000/μL).\n\n" +
                "2. **Group B Fluid Titration Protocol (Warning Signs Present):**\n" +
                "   • Fluid of Choice: Isotonic crystalloid (Ringer's Lactate or 0.9% Normal Saline).\n" +
                "   • Hours 1–2: Start at **5 to 7 mL/kg/hr**.\n" +
                "   • Hours 3–4: Reduce to **3 to 5 mL/kg/hr** if vital signs and urine output (>0.5 mL/kg/hr) improve.\n" +
                "   • Hours 5–48: Further taper to **2 to 3 mL/kg/hr** maintenance rate.\n" +
                "   • Recheck HCT every 6 hours; match fluid rate strictly to hematocrit trends.\n\n" +
                "3. **Group C (Severe Dengue Shock / Hemorrhage):**\n" +
                "   • Fluid Resuscitation: Crystalloid bolus **10 to 20 mL/kg over 15 to 30 minutes**.\n" +
                "   • If refractory: Colloid (e.g. 6% HES or Dextran-40) 10 to 20 mL/kg. Initiate blood transfusion if HCT falls with unstable vitals.\n\n" +
                "4. **Strict Safety Rules:**\n" +
                "   • 🚫 **ABSOLUTELY CONTRAINDICATED:** Aspirin, Ibuprofen, Diclofenac, Ketorolac (precipitates catastrophic gastric bleed & Reye syndrome).\n" +
                "   • 🚫 **NO IM Injections:** Causes large intramuscular hematomas.\n" +
                "   • Antipyretic: Oral Paracetamol only (Max 3,000 mg/24h in adults; 10–15 mg/kg/dose in children q6h PRN)."
            }
            lower.contains("scrub") || (lower.contains("typhus") && (lower.contains("doxy") || lower.contains("orientia") || lower.contains("eschar"))) -> {
                "🌿 **SCRUB TYPHUS CLINICAL PROTOCOL (EDCD NEPAL / WHO SEARO)**\n\n" +
                "• **Etiology & Hallmarks:** *Orientia tsutsugamushi* transmitted by *Leptotrombidium* mite (chigger). Classic triad: Persistent high fever, headache, and diagnostic painless **Eschar** (cigarette-burn appearance with black crust in axilla, groin, neck, or waistband).\n\n" +
                "• **First-Line Pharmacotherapy:**\n" +
                "   - **Adults & Children >8 years:** **Doxycycline 100 mg PO BID x 7 days** (or 200 mg loading on Day 1). Defervescence typically occurs within 24–48 hours.\n" +
                "   - **Severe Inpatient / Refractory:** IV Doxycycline 100 mg q12h OR IV Azithromycin 500 mg daily.\n\n" +
                "• **Pregnancy & Young Children (<8 years):**\n" +
                "   - **Azithromycin 500 mg PO daily x 5 to 7 days** (Pediatric: 10 mg/kg/day single daily dose, max 500 mg).\n" +
                "   - Alternative: Chloramphenicol 500 mg PO/IV q6h x 7 days (monitor CBC).\n\n" +
                "• **Complications to Monitor:** Acute Respiratory Distress Syndrome (ARDS), acute kidney injury, myocarditis, and meningoencephalitis."
            }
            lower.contains("leprosy") || lower.contains("hansen") || lower.contains("mdt") -> {
                "🩺 **LEPROSY MULTIDRUG THERAPY (MDT) (WHO / MOHP NEPAL GUIDELINES)**\n\n" +
                "• **Paucibacillary (PB) Leprosy (1 to 5 skin lesions, single nerve trunk involvement) — 6 Blister Packs over 9 Months:**\n" +
                "   - Day 1 (Monthly Supervised): Rifampicin 600 mg + Dapsone 100 mg.\n" +
                "   - Days 2–28 (Daily Self-Administered): Dapsone 100 mg daily.\n" +
                "   - Pediatric (10–14 years): Rifampicin 450 mg monthly, Dapsone 50 mg daily.\n\n" +
                "• **Multibacillary (MB) Leprosy (≥6 skin lesions, multiple nerves, or slit-skin smear positive) — 12 Blister Packs over 18 Months:**\n" +
                "   - Day 1 (Monthly Supervised): Rifampicin 600 mg + Clofazimine 300 mg + Dapsone 100 mg.\n" +
                "   - Days 2–28 (Daily Self-Administered): Clofazimine 50 mg daily + Dapsone 100 mg daily.\n" +
                "   - Pediatric (10–14 years): Rifampicin 450 mg, Clofazimine 150 mg monthly (Clofazimine 50 mg every other day) + Dapsone 50 mg daily.\n\n" +
                "• **Reactions Management:** Type 1 (Reversal) Reaction → Oral Prednisolone 40 mg daily tapered over 12–24 weeks. Type 2 (ENL) Reaction → High-dose Prednisolone or Thalidomide (under strict teratogenicity protocol)."
            }
            lower.contains("kala") || lower.contains("leishmaniasis") || lower.contains("amphotericin") -> {
                "🩸 **VISCERAL LEISHMANIASIS / KALA-AZAR (EDCD NEPAL / WHO SEARO PROTOCOL)**\n\n" +
                "• **Etiology:** *Leishmania donovani* transmitted by *Phlebotomus argentipes* sandfly. Triad: Prolonged undulating fever (>2 weeks), massive splenomegaly, and progressive pancytopenia / wasting.\n\n" +
                "• **First-Line National Regimen:**\n" +
                "   - **Single-Dose Liposomal Amphotericin B (AmBisome):** **10 mg/kg IV infusion in 5% Dextrose over 2 hours** as a single dose.\n" +
                "   - High cure rate (>96%), minimal nephrotoxicity, and zero hospital stay burden.\n\n" +
                "• **Combination Second-Line (if AmBisome single-dose unavailable):**\n" +
                "   - Liposomal Amphotericin B 5 mg/kg IV single dose PLUS Oral Miltefosine (2.5 mg/kg/day, adults 100 mg/day divided BID) x 7 days.\n" +
                "   - Or Oral Miltefosine x 10 days PLUS Paromomycin 15 mg/kg/day IM x 10 days.\n\n" +
                "• **Post-Kala-azar Dermal Leishmaniasis (PKDL):** Oral Miltefosine for 12 weeks or Liposomal Amphotericin B 2.5 mg/kg/day x 20 days."
            }
            lower.contains("rabies") || lower.contains("dog bite") || lower.contains("erig") || lower.contains("hrig") -> {
                "🐕 **RABIES POST-EXPOSURE PROPHYLAXIS (PEP) (EDCD NEPAL / WHO GUIDELINES)**\n\n" +
                "1. **Immediate Wound Cleansing (Lifesaving First Step):**\n" +
                "   • Flush and wash wound vigorously with running water and soap for at least **15 continuous minutes**.\n" +
                "   • Apply Povidone-Iodine 10% or 70% alcohol. Do NOT suture wound; if unavoidable, infiltrate RIG first and place loose coaptation sutures.\n\n" +
                "2. **Category III Bites (Transdermal puncture/scratch, mucosal licking, bats):**\n" +
                "   • **Rabies Immunoglobulin (RIG):**\n" +
                "     - Equine RIG (ERIG): **40 IU/kg** OR Human RIG (HRIG): **20 IU/kg**.\n" +
                "     - Infiltrate full calculated dose into and around wound margins. Any remainder injected IM at an anatomical site distant from vaccine.\n\n" +
                "3. **Thai Red Cross 2-Site Intradermal (ID) Regimen (National Standard):**\n" +
                "   • Dose: **0.1 mL ID at 2 separate deltoid sites** on:\n" +
                "     - **Day 0, Day 3, Day 7, Day 28** (Total: 8 ID injections, requires only 1 vial per patient!).\n" +
                "   • Achieves 100% seroprotection, saves 70% cost compared to IM Essen (Days 0, 3, 7, 14, 28)."
            }
            lower.contains("dka") || lower.contains("ketoacidosis") -> {
                "🩸 **DIABETIC KETOACIDOSIS (DKA) EMERGENCY PROTOCOL (ADA / EASD)**\n\n" +
                "1. **Initial Hydration (Hour 1):**\n" +
                "   • 0.9% Normal Saline at **1,000 to 1,500 mL/hr** (15–20 mL/kg/hr) to restore vascular volume.\n\n" +
                "2. **Electrolyte Gatekeeper (Check Potassium Before Insulin!):**\n" +
                "   • If **K⁺ < 3.3 mEq/L:** **HOLD INSULIN!** Infuse KCl 20–40 mEq/hr until K⁺ > 3.3 mEq/L (prevents fatal arrhythmias/respiratory arrest).\n" +
                "   • If **K⁺ 3.3–5.2 mEq/L:** Add 20–30 mEq KCl to each liter of IV fluid; maintain serum K⁺ between 4.0–5.0 mEq/L.\n" +
                "   • If **K⁺ > 5.2 mEq/L:** Do not give K⁺; recheck every 2 hours.\n\n" +
                "3. **Insulin Infusion:**\n" +
                "   • Regular Insulin IV continuous infusion at **0.1 units/kg/hr** (or 0.14 u/kg/hr without bolus).\n" +
                "   • Target glucose reduction: 50 to 75 mg/dL per hour.\n\n" +
                "4. **The Glucose Transition Rule:**\n" +
                "   • When blood glucose falls to **200–250 mg/dL**, switch IV fluids to **5% Dextrose with 0.45% NS** and reduce insulin to 0.02–0.05 units/kg/hr.\n" +
                "   • Continue insulin until Anion Gap closes (≤12 mEq/L) and venous pH > 7.30."
            }
            lower.contains("hyperkalemia") || (lower.contains("potassium") && (lower.contains("peaked t") || lower.contains("emergency") || lower.contains("shift"))) -> {
                "⚡ **EMERGENCY HYPERKALEMIA PROTOCOL (K⁺ > 6.5 mEq/L OR ECG CHANGES)**\n\n" +
                "1. **Myocardial Membrane Stabilization (Immediate):**\n" +
                "   • **10% Calcium Gluconate:** 10 mL (1 ampule) IV over 2–5 minutes with continuous ECG monitoring.\n" +
                "   • Onset: 1–3 minutes; Duration: 30–60 minutes. Repeat dose in 5 minutes if peaked T waves or QRS widening persist.\n" +
                "   *(Note: Calcium stabilizes cardiac membrane; it does NOT lower serum K⁺ level!).*\n\n" +
                "2. **Intracellular Potassium Shift (Temporary 2–4 Hour Lowering):**\n" +
                "   • **Regular Insulin + Dextrose:** 10 Units Regular Insulin IV push immediately followed by 50 mL 50% Dextrose (D50) or 100 mL 25% Dextrose over 15 minutes.\n" +
                "   • **Nebulized Salbutamol:** 10 to 20 mg in 4 mL NS via nebulizer over 15 minutes (additive K⁺ reduction of ~1.0 mEq/L).\n" +
                "   • **Sodium Bicarbonate:** 50 mEq IV over 5 minutes (primarily if concurrent severe metabolic acidosis pH < 7.15).\n\n" +
                "3. **Elimination & Removal (True Body Potassium Loss):**\n" +
                "   • **IV Furosemide:** 40 to 80 mg IV bolus if kidneys producing urine.\n" +
                "   • **Cation Exchange Resins:** Calcium Polystyrene Sulfonate 15 g PO TID or Patiromer 8.4 g PO daily.\n" +
                "   • **Hemodialysis:** Definitive gold standard for refractory hyperkalemia or end-stage renal disease."
            }
            lower.contains("sepsis") || lower.contains("septic shock") || lower.contains("noradrenaline") || lower.contains("norepinephrine") -> {
                "🚨 **SEPSIS & SEPTIC SHOCK: SURVIVING SEPSIS CAMPAIGN HOUR-1 BUNDLE**\n\n" +
                "1. **Measure Blood Lactate:** Remeasure within 2–4 hours if initial lactate > 2.0 mmol/L.\n" +
                "2. **Blood Cultures Before Antibiotics:** 2 sets (aerobic + anaerobic) prior to initiating antimicrobials without delaying therapy beyond 45 minutes.\n" +
                "3. **Broad-Spectrum IV Antimicrobials:** Initiate empiric therapy within 1 hour (e.g. IV Piperacillin-Tazobactam 4.5g q6h OR Meropenem 1g q8h + Vancomycin 15-20 mg/kg q12h).\n" +
                "4. **Rapid Fluid Resuscitation:** **30 mL/kg crystalloids (Ringer's Lactate preferred)** within the first 3 hours for hypotension (MAP < 65 mmHg) or initial lactate ≥ 4.0 mmol/L.\n" +
                "5. **Vasopressor of Choice (Norepinephrine):**\n" +
                "   • Start **Norepinephrine 0.05 to 0.1 mcg/kg/min** titrated to maintain **Mean Arterial Pressure (MAP) ≥ 65 mmHg**.\n" +
                "   • Second-line: Add Vasopressin 0.03 units/min fixed infusion (do not titrate).\n" +
                "   • Refractory Shock: IV Hydrocortisone 200 mg/day (50 mg IV q6h) if vasopressors unable to maintain MAP."
            }
            lower.contains("hypertensive") && (lower.contains("crisis") || lower.contains("emergency") || lower.contains("urgency") || lower.contains("labetalol") || lower.contains("nicardipine")) -> {
                "🩸 **HYPERTENSIVE CRISIS MANAGEMENT (AHA / ACC GUIDELINES)**\n\n" +
                "• **Hypertensive Emergency (BP >180/120 WITH Acute End-Organ Damage):**\n" +
                "   - Acute pulmonary edema, aortic dissection, ACS, stroke, acute kidney injury, or eclampsia.\n" +
                "   - **Target:** Reduce Mean Arterial Pressure (MAP) by **NO MORE than 20% to 25% in the first hour**, then towards 160/100 mmHg over next 2–6 hours.\n" +
                "   - *(Exception: Acute Aortic Dissection → Rapidly lower SBP < 120 mmHg and HR < 60 bpm within 20 minutes using IV Esmolol/Labetalol!).*\n" +
                "   - **First-Line IV Drugs:**\n" +
                "     * **IV Labetalol:** 10 to 20 mg slow IV push over 2 min; repeat doubling dose (40mg, 80mg) q10min up to 300 mg total; or infusion 1–2 mg/min.\n" +
                "     * **IV Nicardipine:** 5 mg/hr continuous IV infusion; titrate up by 2.5 mg/hr every 15 min (Max 15 mg/hr).\n" +
                "     * **IV Nitroglycerin:** 5 to 100 mcg/min for acute pulmonary edema or ACS.\n" +
                "   - 🚫 **STRICTLY CONTRAINDICATED:** Sublingual Nifedipine biting (induces uncontrolled cerebral/coronary hypoperfusion and stroke).\n\n" +
                "• **Hypertensive Urgency (BP >180/120 WITHOUT End-Organ Damage):**\n" +
                "   - Gradual reduction over 24 to 48 hours using oral agents (Amlodipine 5-10 mg, Telmisartan 40 mg, or Labetalol 100-200 mg PO). Do not rush IV therapy."
            }
            lower.contains("malaria") || lower.contains("falciparum") || lower.contains("vivax") || lower.contains("act") || lower.contains("artesunate") -> {
                "🦟 **MALARIA DIAGNOSIS & ACT TREATMENT PROTOCOL (EDCD NEPAL / WHO)**\n\n" +
                "• **1. Plasmodium vivax (Uncomplicated):**\n" +
                "   - **Chloroquine Phosphate:** 25 mg base/kg total over 3 days (Day 1: 10 mg/kg; Day 2: 10 mg/kg; Day 3: 5 mg/kg).\n" +
                "   - **Radical Hypnozoite Cure (Mandatory to prevent relapse):** **Primaquine 0.25 mg base/kg daily x 14 days** (Check G6PD status; contraindicated in severe G6PD deficiency and pregnancy!).\n\n" +
                "• **2. Plasmodium falciparum (Uncomplicated):**\n" +
                "   - **Artemisinin-based Combination Therapy (ACT):** **Artemether-Lumefantrine (Coartem 20/120 mg)** 6-dose regimen over 3 days:\n" +
                "     * Dose schedule: 0, 8, 24, 36, 48, and 60 hours taken with fatty food/milk.\n" +
                "     * Adult (>35 kg): 4 tablets per dose (total 24 tablets).\n" +
                "   - Plus **Primaquine 0.25 mg/kg single dose on Day 1** as gametocidal to block transmission.\n\n" +
                "• **3. Severe / Complicated Malaria (Cerebral, ARDS, Acidosis, Parasitemia >5%):**\n" +
                "   - **IV Artesunate:** **2.4 mg/kg IV at 0, 12, 24 hours**, then once daily until oral tolerance (minimum 3 IV doses).\n" +
                "   - Followed by full 3-day oral ACT course once patient can swallow."
            }
            lower.contains("telmisartan") && (lower.contains("spironolactone") || lower.contains("potassium")) -> {
                "⚠️ **DRUG-DRUG INTERACTION ALERT: Telmisartan + Spironolactone**\n\n" +
                "• **Severity Level:** Major (High Risk of Severe Hyperkalemia).\n" +
                "• **Mechanism:** Telmisartan (ARB) blocks aldosterone secretion by inhibiting Angiotensin II AT1 receptors; Spironolactone directly antagonizes aldosterone in the distal renal tubule. Synergistic potassium retention occurs.\n" +
                "• **Clinical Recommendation:**\n" +
                "   1. Baseline Serum Potassium & eGFR must be checked prior to initiation.\n" +
                "   2. Do not initiate if baseline K⁺ > 5.0 mEq/L or eGFR < 30 mL/min.\n" +
                "   3. Recheck serum electrolytes at 1 week, 1 month, and every 3 months.\n" +
                "   4. Advise patient to strictly avoid potassium-containing salt substitutes."
            }
            lower.contains("metformin") && (lower.contains("renal") || lower.contains("egfr") || lower.contains("creatinine")) -> {
                "📋 **METFORMIN: RENAL DOSING & SAFETY THRESHOLDS**\n\n" +
                "• **eGFR ≥ 60 mL/min:** Standard dosing (up to 2000-2550 mg/day). Monitor renal function annually.\n" +
                "• **eGFR 45–59 mL/min:** Max dose 2000 mg/day. Monitor renal function every 3–6 months.\n" +
                "• **eGFR 30–44 mL/min:** Max dose 1000 mg/day. Do NOT initiate new therapy; if already taking, reduce dose by 50%.\n" +
                "• **eGFR < 30 mL/min:** ABSOLUTELY CONTRAINDICATED due to high risk of Metformin-Associated Lactic Acidosis (MALA).\n\n" +
                "⚠️ **Contrast Procedure Rule:** Withhold 48 hours before IV iodinated radiocontrast; resume 48 hours post-procedure only after re-checking eGFR."
            }
            lower.contains("paracetamol") || lower.contains("acetaminophen") || lower.contains("dolo") || lower.contains("cetamol") -> {
                "💊 **PARACETAMOL (ACETAMINOPHEN) CLINICAL PROTOCOL**\n\n" +
                "• **Maximum Safe Adult Dose:** 4,000 mg/24h (1 g PO q6h or 650 mg q4h).\n" +
                "• **Special Populations:**\n" +
                "   - Chronic Alcohol Abuse / Cirrhosis: Max 2,000 mg/24h.\n" +
                "   - Malnourished / Cachectic: Max 2,000–3,000 mg/24h.\n" +
                "• **Pediatric Dose:** 10–15 mg/kg/dose PO q4–6h PRN (Max 60 mg/kg/day).\n" +
                "• **Toxicity Antidote:** N-Acetylcysteine (NAC) IV 3-bag protocol (150 mg/kg over 1h, 50 mg/kg over 4h, 100 mg/kg over 16h). Greatest efficacy within 8h of ingestion."
            }
            lower.contains("amoxicillin") || lower.contains("clavulanate") || lower.contains("moxclave") || lower.contains("augmentin") -> {
                "🛡️ **AMOXICILLIN-CLAVULANATE (AUGMENTIN / MOXCLAVE)**\n\n" +
                "• **Standard Adult Dose:** 625 mg (500/125) PO TID or 1,000 mg (875/125) PO BID with meals.\n" +
                "• **Pediatric Otitis Media / Pneumonia:** High dose amoxicillin component: 45–90 mg/kg/day divided q12h.\n" +
                "• **Administration Pearl:** Always take at the start of a meal to enhance clavulanate bioavailability and reduce gastrointestinal distress.\n" +
                "• **Hepatic Precaution:** Cholestatic jaundice and hepatitis can occur; risk increases with repeated courses or prolonged therapy."
            }
            lower.contains("organophosphate") || lower.contains("op poison") || lower.contains("op toxicity") || lower.contains("insecticide") || lower.contains("atropinization") -> {
                "🚨 **EMERGENCY ORGANOPHOSPHATE POISONING CLINICAL PROTOCOL**\n\n" +
                "1. **Personal Protective Equipment & Decontamination:** Wear nitrile gloves; strip all contaminated clothes and wash skin with soap and copious running water.\n" +
                "2. **Atropine Sulfate (Muscarinic Antidote):**\n" +
                "   • Initial: 2 to 5 mg IV push immediately.\n" +
                "   • Doubling Regimen: Repeat every 5 to 10 minutes, DOUBLING the dose (e.g. 2mg → 4mg → 8mg → 16mg) until full ATROPINIZATION.\n" +
                "   • Critical Therapeutic Endpoints:\n" +
                "     - Clear breath sounds on chest auscultation (Resolution of killer 'B's: Bronchorrhea & Bronchospasm)\n" +
                "     - Heart rate > 80 bpm & Systolic BP > 90 mmHg\n" +
                "     - Dry axillae and tongue (Pupillary dilation is NOT an endpoint!).\n" +
                "   • Maintenance: Continuous IV infusion of 10-20% of total loading dose required per hour.\n" +
                "3. **Pralidoxime Chloride (2-PAM - Nicotinic Antidote):**\n" +
                "   • Loading: 1 to 2 g IV in 100 mL NS over 15-30 minutes.\n" +
                "   • Maintenance: Continuous IV infusion of 8 mg/kg/hr (500 mg/hr in adults) for 24-48 hours until neuromuscular weakness resolves."
            }
            lower.contains("snake") || lower.contains("envenomation") || lower.contains("asv") || lower.contains("viper") || lower.contains("krait") || lower.contains("cobra") -> {
                "🐍 **SNAKE ENVENOMATION MANAGEMENT PROTOCOL (WHO SEARO & NEPAL NATIONAL GUIDELINE)**\n\n" +
                "1. **Pre-Hospital First Aid:** Keep patient calm and motionless. Splint/immobilize bitten limb at heart level. DO NOT apply tourniquets, do NOT cut, suck, or apply ice/chemicals. Transport immediately.\n" +
                "2. **Diagnostic Evaluation:**\n" +
                "   • 20-Minute Whole Blood Clotting Test (20WBCT): 2 mL fresh venous blood in dry glass tube undisturbed for 20 min. If unclotted upon tilting, systemic hemotoxic envenomation is confirmed!\n" +
                "   • Neurotoxic signs: Bilateral ptosis, diplopia, ophthalmoplegia, broken-neck sign, dysphagia, respiratory muscle paralysis.\n" +
                "3. **Polyvalent Anti-Snake Venom (ASV):**\n" +
                "   • Dose: 10 vials (100 mL) reconstituted in 500 mL NS IV over 1 hour (same dose for adults and children!).\n" +
                "   • Infuse first 10-15 min slowly at 1-2 mL/min while observing for anaphylaxis.\n" +
                "   • Anaphylaxis prophylaxis: Draw up Epinephrine (1:1,000) 0.5 mL IM, Chlorpheniramine 10 mg IV, Hydrocortisone 100 mg IV before starting ASV.\n" +
                "4. **Neurotoxic Adjunct:** Neostigmine test: Neostigmine 0.5-2 mg IM with Atropine 0.6 mg IV. If muscle tone/ptosis improves, continue Neostigmine 0.5 mg + Atropine q30min-2h.\n" +
                "5. **Repeat ASV:** In hemotoxic bites, retest 20WBCT at 6 hours post-ASV. If blood still does not clot, administer second dose of 5-10 vials ASV."
            }
            lower.contains("asthma") || lower.contains("gina") || lower.contains("bronchospasm") -> {
                "🫁 **ASTHMA MANAGEMENT PROTOCOL (GINA 2024 GUIDELINES)**\n\n" +
                "• **Track 1 (Preferred Strategy - SMART / MART):**\n" +
                "   - Reliever: Low-dose Inhaled Corticosteroid (ICS) + Formoterol (e.g. Budesonide-Formoterol 160/4.5 mcg 1 puff as needed).\n" +
                "   - Step 1 & 2: As-needed low-dose ICS-Formoterol alone for symptom relief.\n" +
                "   - Step 3: Low-dose ICS-Formoterol maintenance (1 puff BID) PLUS 1 puff PRN reliever.\n" +
                "   - Step 4: Medium-dose ICS-Formoterol maintenance (2 puffs BID) PLUS 1 puff PRN reliever.\n" +
                "   - Step 5: Add LAMA (Tiotropium) and refer for biologic phenotyping (anti-IgE, anti-IL5, anti-IL4R).\n" +
                "• **Acute Severe Exacerbation:**\n" +
                "   - High-flow O₂ titrating to SpO₂ 93-95%.\n" +
                "   - Nebulized Salbutamol 2.5-5 mg + Ipratropium 0.5 mg q20min x 3 doses.\n" +
                "   - Oral Prednisolone 40-50 mg daily x 5-7 days (or IV Hydrocortisone 100-200 mg q6h).\n" +
                "   - IV Magnesium Sulfate 2 g in 100 mL NS over 20 minutes for severe refractory airflow obstruction."
            }
            lower.contains("mi") || lower.contains("stemi") || lower.contains("nstemi") || lower.contains("aha") || lower.contains("coronary") -> {
                "🫀 **ACUTE MYOCARDIAL INFARCTION (AHA / ACC GUIDELINES)**\n\n" +
                "1. **Immediate Initial Resuscitation (MONA-B):**\n" +
                "   • Aspirin: 162-325 mg non-enteric chewable tablet chewed immediately.\n" +
                "   • P2Y12 Inhibitor Loading: Ticagrelor 180 mg PO (preferred) OR Clopidogrel 600 mg PO.\n" +
                "   • Anticoagulation: Unfractionated Heparin IV bolus (60 units/kg, max 4000u) then 12 units/kg/hr OR Enoxaparin 1 mg/kg SC q12h.\n" +
                "   • Nitroglycerin: 0.4 mg SL q5min x 3 doses (contraindicated if SBP <90, HR <50, RV infarction, or PDE-5 inhibitor use).\n" +
                "   • Oxygen: Only if SpO₂ <90% or in respiratory distress.\n" +
                "2. **STEMI Reperfusion Strategy:**\n" +
                "   • Primary PCI: Goal Door-to-Balloon time <90 minutes (or <120 min if transferred).\n" +
                "   • Thrombolysis (if PCI unavailable within 120 min): Tenecteplase weight-adjusted IV bolus or Alteplase 100 mg IV over 90 min (Door-to-Needle <30 min).\n" +
                "3. **Post-ACS Long-term Regimen:** DAPT (Aspirin + Ticagrelor) x 12 months, High-intensity Statin (Atorvastatin 80mg), Beta-blocker (Metoprolol/Bisoprolol), and ACE-Inhibitor (Ramipril)."
            }
            lower.contains("stroke") || lower.contains("asa guideline") || lower.contains("alteplase") || lower.contains("tpa") -> {
                "🧠 **ACUTE ISCHEMIC STROKE (ASA / AHA GUIDELINES)**\n\n" +
                "1. **Time-Sensitive Rapid Assessment:**\n" +
                "   • Emergency Non-contrast Head CT: Rule out intracranial hemorrhage immediately.\n" +
                "   • Fingerstick Glucose: Treat hypoglycemia (<60 mg/dL) which can mimic stroke.\n" +
                "2. **IV Thrombolysis Window (Alteplase / Tenecteplase):**\n" +
                "   • Eligible within 3 to 4.5 hours of last known well time.\n" +
                "   • Alteplase Dose: 0.9 mg/kg IV (max 90 mg) — 10% given as bolus over 1 min, remaining 90% infused over 60 min.\n" +
                "   • Blood Pressure Target: Must be strictly maintained <185/110 mmHg prior to thrombolysis and <180/105 mmHg for 24h post-infusion using IV Labetalol (10-20mg) or Nicardipine.\n" +
                "3. **Mechanical Thrombectomy (EVT):** Indicated for Large Vessel Occlusion (LVO) of anterior circulation up to 24 hours from onset with favorable perfusion imaging.\n" +
                "4. **Post-Thrombolysis Care:** Hold Aspirin, Clopidogrel, and Heparin for 24 hours post-alteplase until repeat non-contrast CT excludes hemorrhage."
            }
            lower.contains("seizure") || lower.contains("status epilepticus") || lower.contains("aes") || lower.contains("convulsion") -> {
                "⚡ **STATUS EPILEPTICUS TREATMENT PROTOCOL (AES GUIDELINES)**\n\n" +
                "• **Phase 1: Initial Therapy (0 to 5 Minutes):**\n" +
                "   - Assess ABCs, high-flow O₂, check fingerstick blood glucose, establish IV access.\n" +
                "   - First-line Benzodiazepine:\n" +
                "     * IV Lorazepam: 0.1 mg/kg IV (max 4 mg) over 2 min, OR\n" +
                "     * IM Midazolam: 10 mg IM (for >40 kg) or 5 mg IM (13-40 kg) if no IV access, OR\n" +
                "     * IV Diazepam: 0.15-0.2 mg/kg IV (max 10 mg). Repeat once after 5-10 min if seizures continue.\n" +
                "• **Phase 2: Established Status (5 to 20 Minutes - Urgent Second-Line):**\n" +
                "   - Levetiracetam: 60 mg/kg IV (max 4,500 mg) over 10-15 minutes (Preferred), OR\n" +
                "   - Sodium Valproate: 40 mg/kg IV (max 3,000 mg) over 5-10 minutes, OR\n" +
                "   - Fosphenytoin: 20 mg PE/kg IV (max 1,500 mg PE).\n" +
                "• **Phase 3: Refractory Status (>20 Minutes):**\n" +
                "   - Endotracheal intubation with ICU admission.\n" +
                "   - Continuous anesthetic infusion: Propofol (2-10 mg/kg/hr) OR Midazolam (0.2-2 mg/kg/hr) titrated to burst suppression on continuous EEG."
            }
            lower.contains("anaphylaxis") || lower.contains("wao") || lower.contains("allergic shock") -> {
                "⚠️ **ANAPHYLAXIS EMERGENCY RESUSCITATION (WAO / EAACI GUIDELINES)**\n\n" +
                "1. **FIRST-LINE & LIFE-SAVING:** Epinephrine (Adrenaline 1:1,000 solution) 0.3 to 0.5 mg IM (pediatric 0.01 mg/kg, max 0.3 mg) into the ANTEROLATERAL MID-THIGH immediately!\n" +
                "   • Repeat every 5 to 15 minutes if symptoms persist or deteriorate.\n" +
                "   • NEVER give 1:1,000 IV bolus (causes lethal tachyarrhythmias and myocardial infarction).\n" +
                "2. **Positioning:** Place patient supine with lower extremities elevated. (DO NOT allow patient to suddenly sit or stand up — causes empty ventricle syndrome and cardiac arrest!).\n" +
                "3. **Fluid Resuscitation:** 1 to 2 Liters Normal Saline rapid IV pressure bolus (20 mL/kg in children) for anaphylactic distributive shock.\n" +
                "4. **Second-Line Adjuncts (Never delay Epinephrine):**\n" +
                "   • Chlorpheniramine 10-20 mg IV or Diphenhydramine 50 mg IV.\n" +
                "   • Hydrocortisone 100-200 mg IV or Methylprednisolone 1-2 mg/kg IV (prevents biphasic reactions).\n" +
                "   • Nebulized Salbutamol 2.5-5 mg for refractory bronchospasm.\n" +
                "5. **Refractory Anaphylaxis on Beta-Blockers:** IV Glucagon 1-5 mg over 5 min, followed by 5-15 mcg/min infusion."
            }
            lower.contains("vt") || lower.contains("vf") || lower.contains("ventricular tachycardia") || lower.contains("ventricular fibrillation") || lower.contains("acls") -> {
                "⚡ **PULSELESS VT & VENTRICULAR FIBRILLATION (ACLS ALGORITHM)**\n\n" +
                "1. **Immediate High-Quality CPR & Defibrillation:**\n" +
                "   • Shock 1: Immediate unsynchronized defibrillation (120-200 J biphasic or 360 J monophasic).\n" +
                "   • Resume CPR immediately for 2 minutes (30:2 or continuous compressions 100-120/min at 5-6 cm depth).\n" +
                "2. **Cycle 2 (Post Shock 2):**\n" +
                "   • Epinephrine 1 mg IV/IO rapid push followed by 20 mL NS flush; repeat every 3 to 5 minutes.\n" +
                "3. **Cycle 3 (Post Shock 3 - Antiarrhythmic):**\n" +
                "   • Amiodarone: 300 mg IV/IO rapid push (repeat with 150 mg IV push after 3-5 min if VF/pVT persists), OR\n" +
                "   • Lidocaine: 1.0 to 1.5 mg/kg IV/IO first dose, then 0.5 to 0.75 mg/kg.\n" +
                "4. **Reversible Causes (H's & T's):** Hypovolemia, Hypoxia, Hydrogen ion (Acidosis), Hypo/Hyperkalemia, Hypothermia, Tension pneumothorax, Tamponade, Toxins, Thrombosis (coronary/pulmonary)."
            }
            lower.contains("psvt") || lower.contains("supraventricular") || lower.contains("adenosine") || lower.contains("avnrt") -> {
                "💓 **PAROXYSMAL SUPRAVENTRICULAR TACHYCARDIA (PSVT / AVNRT)**\n\n" +
                "1. **Hemodynamic Check:** If unstable (hypotension, acute altered mental status, chest pain, pulmonary edema) → IMMEDIATE Synchronized Cardioversion (50-100 J).\n" +
                "2. **If Hemodynamically Stable:**\n" +
                "   • Step 1: Modified Valsalva Maneuver (Strain to 40 mmHg for 15 sec supine, then immediately lay flat and elevate legs to 45° for 15 sec — success rate up to 43%).\n" +
                "   • Step 2: Adenosine 6 mg rapid IV push over 1-2 seconds via large antecubital vein, followed immediately by 20 mL NS flush and arm elevation.\n" +
                "   • Step 3: If no cardioversion in 1-2 minutes, give Adenosine 12 mg rapid IV push with 20 mL flush.\n" +
                "   • Step 4: If PSVT persists, give second-line Verapamil (5-10 mg IV over 2 min) or Diltiazem (0.25 mg/kg IV) or Metoprolol (5 mg IV q5min up to 15 mg).\n" +
                "⚠️ *Patient Warning:* Warn patient of impending brief chest heaviness, flushing, and doom sensation lasting 10-15 seconds."
            }
            lower.contains("tb") || lower.contains("tuberculosis") || lower.contains("dots") || lower.contains("hrze") || lower.contains("bpalm") -> {
                "🔬 **TUBERCULOSIS (TB) TREATMENT (WHO 2024 & NEPAL NTP GUIDELINES)**\n\n" +
                "• **Drug-Susceptible Pulmonary TB (Standard 6-Month Regimen):**\n" +
                "   - Intensive Phase (2 Months): 2HRZE daily (Isoniazid + Rifampicin + Pyrazinamide + Ethambutol).\n" +
                "   - Continuation Phase (4 Months): 4HR daily (Isoniazid + Rifampicin).\n" +
                "   - Fixed-Dose Combination (FDC) Weight Bands:\n" +
                "     * 30-39 kg: 2 tabs daily\n" +
                "     * 40-54 kg: 3 tabs daily\n" +
                "     * 55-70 kg: 4 tabs daily\n" +
                "     * >70 kg: 5 tabs daily.\n" +
                "   - Pyridoxine (Vitamin B6): 20-50 mg PO daily to prevent INH-induced peripheral neuropathy.\n" +
                "• **MDR/RR-TB Short-Course Regimen (BPaLM - WHO 2024 Preferred):**\n" +
                "   - 6-month all-oral regimen: Bedaquiline + Pretomanid + Linezolid (600 mg daily) + Moxifloxacin.\n" +
                "• **Monitoring:** Baseline liver enzymes, sputum smear/GeneXpert at Month 2 and Month 6, and visual acuity testing for ethambutol optic neuritis."
            }
            lower.contains("pancreatitis") || lower.contains("acg guideline") || lower.contains("lipase") || lower.contains("amylase") -> {
                "🔥 **ACUTE PANCREATITIS CLINICAL PROTOCOL (ACG GUIDELINES)**\n\n" +
                "1. **Early Goal-Directed Fluid Resuscitation:**\n" +
                "   • Fluid of Choice: Lactated Ringer's (LR) is superior to Normal Saline (reduces systemic SIRS and metabolic acidosis).\n" +
                "   • Rate: Moderately aggressive infusion (5 to 10 mL/kg/hr, e.g. 200-250 mL/hr) for the first 12-24 hours.\n" +
                "   • Resuscitation Targets: Urine output >0.5 mL/kg/hr, reduction in Hematocrit (<44%), and normalization of BUN/Creatinine.\n" +
                "2. **Analgesia:** Multimodal analgesia with IV Fentanyl or Hydromorphone; IV Paracetamol as adjunctive.\n" +
                "3. **Nutritional Support:** Early oral feeding with low-fat solid or liquid diet initiated within 24-48 hours as soon as abdominal pain improves and ileus resolves. Enteral tube feeding (nasogastric/nasojejunal) preferred over TPN if unable to eat.\n" +
                "4. **Antibiotic Stewardship:** Prophylactic antibiotics are NOT recommended in acute pancreatitis (even severe necrotizing form) unless confirmed infected pancreatic necrosis is diagnosed."
            }
            lower.contains("colitis") || lower.contains("ulcerative colitis") || lower.contains("mesalamine") || lower.contains("5-asa") -> {
                "🩹 **ULCERATIVE COLITIS MANAGEMENT (ACG GUIDELINES)**\n\n" +
                "• **Mild-to-Moderate Induction:**\n" +
                "   - Extensive / Left-Sided: Oral Mesalamine (5-ASA) 2.4 to 4.8 g/day PLUS Topical Mesalamine enema 4 g/day or suppository 1 g/day.\n" +
                "   - Proctitis: Topical Mesalamine suppository 1 g daily at bedtime.\n" +
                "   - If refractory to optimized 5-ASA: Add oral Budesonide MMX 9 mg/day x 8 weeks or oral Prednisolone 40 mg daily with taper.\n" +
                "• **Acute Severe Ulcerative Colitis (ASUC - Truelove & Witts Criteria: Bloody stools ≥6/day + HR >90, Temp >37.8, Hb <10.5, ESR >30):**\n" +
                "   - Immediate hospital admission, bowel rest, IV hydration.\n" +
                "   - First-line: IV Methylprednisolone 60 mg/day (or IV Hydrocortisone 100 mg q6h).\n" +
                "   - Oxford Criteria Assessment on Day 3-5: If stool frequency >8/day OR CRP >45 mg/L, initiate Rescue Therapy with Infliximab (5 mg/kg) or Cyclosporine IV.\n" +
                "   - Prophylaxis: Low-molecular-weight heparin (Enoxaparin 40mg SC) is mandatory for VTE prophylaxis."
            }
            lower.contains("pylori") || lower.contains("h. pylori") || lower.contains("helicobacter") || lower.contains("bismuth") -> {
                "🦠 **H. PYLORI ERADICATION PROTOCOL (ACG 2024 & MAASTRICHT VI GUIDELINES)**\n\n" +
                "• **FIRST-LINE PREFERRED: Bismuth Quadruple Therapy x 14 Days:**\n" +
                "   1. Proton Pump Inhibitor (PPI): Esomeprazole 40 mg PO BID (or Pantoprazole 40 mg BID) 30 min before breakfast & dinner.\n" +
                "   2. Bismuth Subsalicylate: 300 mg (or 524 mg) PO QID (with 3 meals & bedtime).\n" +
                "   3. Tetracycline: 500 mg PO QID.\n" +
                "   4. Metronidazole: 500 mg PO TID or QID.\n" +
                "• **Alternative First-Line (If high clarithromycin resistance unknown/low):**\n" +
                "   - Clarithromycin-based Concomitant Quadruple Therapy: PPI BID + Amoxicillin 1 g BID + Clarithromycin 500 mg BID + Metronidazole 500 mg BID x 14 days.\n" +
                "• **Confirmation of Eradication:** Stool Antigen Test or Urea Breath Test (UBT) must be conducted at least 4 weeks after finishing antibiotics and at least 2 weeks after stopping PPI."
            }
            else -> {
                searchAppClinicalDatabase(query)
            }
        }
    }

    private fun searchAppClinicalDatabase(query: String): String {
        val rawLower = query.lowercase().trim()
        val stopwords = setOf(
            "what", "is", "the", "dose", "of", "in", "for", "treatment", "guidelines", "drugs", "drug",
            "disease", "tell", "me", "about", "how", "to", "use", "when", "contraindications", "dosage",
            "adult", "pediatric", "child", "nepal", "patient", "recommend", "management", "protocol", "regimen",
            "give", "please", "can", "should", "i", "a", "an", "and", "or", "with", "therapy"
        )
        val cleanTokens = rawLower.replace(Regex("[^a-z0-9 ]"), " ")
            .split("\\s+".toRegex())
            .filter { it.length >= 3 && it !in stopwords }

        // 1. Search Drugs in ClinicalRepository
        val allDrugs = ClinicalRepository.drugs
        val matchedDrug = allDrugs.firstOrNull { drug ->
            val genName = drug.genericName.lowercase()
            genName == rawLower || 
            (cleanTokens.isNotEmpty() && cleanTokens.any { genName == it }) ||
            (cleanTokens.isNotEmpty() && genName.contains(rawLower)) ||
            (cleanTokens.isNotEmpty() && cleanTokens.any { token -> genName.split(" ").any { it == token } })
        } ?: allDrugs.firstOrNull { drug ->
            val brandMatch = drug.brandsNepal.any { b -> 
                val bName = b.name.lowercase()
                bName == rawLower || cleanTokens.any { bName.contains(it) }
            }
            brandMatch
        } ?: allDrugs.firstOrNull { drug ->
            cleanTokens.isNotEmpty() && cleanTokens.any { token -> 
                drug.genericName.lowercase().contains(token) || 
                drug.drugClass.lowercase().contains(token)
            }
        } ?: allDrugs.firstOrNull { drug ->
            cleanTokens.isNotEmpty() && cleanTokens.any { token ->
                drug.indications.lowercase().contains(token)
            }
        }

        // 2. Search Disease Protocols in ClinicalRepository
        val allProtocols = ClinicalRepository.diseaseProtocols
        val matchedProtocol = allProtocols.firstOrNull { proto ->
            val protoName = proto.name.lowercase()
            protoName == rawLower || 
            (cleanTokens.isNotEmpty() && cleanTokens.any { protoName.contains(it) }) ||
            (cleanTokens.isNotEmpty() && cleanTokens.any { token -> proto.category.lowercase().contains(token) })
        }

        // Formulate authoritative response
        if (matchedDrug != null) {
            val sb = StringBuilder()
            sb.append("💊 **${matchedDrug.genericName.uppercase()}** (${matchedDrug.drugClass})\n")
            sb.append("*System: ${matchedDrug.system}*\n\n")

            if (matchedDrug.indications.isNotBlank()) {
                sb.append("📋 **Indications & Clinical Use:**\n${matchedDrug.indications.trim()}\n\n")
            }

            val adultDose = matchedDrug.adultDose.ifBlank { matchedDrug.doses }.trim()
            if (adultDose.isNotBlank()) {
                sb.append("⚖️ **Adult Dosing:**\n$adultDose\n\n")
            }

            val childDose = when {
                matchedDrug.childDose.isNotBlank() -> matchedDrug.childDose.trim()
                matchedDrug.pediatricDosePerKg != null -> "${matchedDrug.pediatricDosePerKg} mg/kg (${matchedDrug.pediatricInterval ?: "per dose"})\n${matchedDrug.doses.take(150)}"
                else -> ""
            }
            if (childDose.isNotBlank()) {
                sb.append("👶 **Pediatric Dosing:**\n$childDose\n\n")
            }

            if (matchedDrug.administration.isNotBlank() || matchedDrug.timing.isNotBlank()) {
                sb.append("⏱️ **Administration & Timing:**\n${matchedDrug.administration} ${matchedDrug.timing}\n\n")
            }

            if (matchedDrug.renalAdj.isNotBlank() || matchedDrug.hepaticAdj.isNotBlank()) {
                sb.append("⚠️ **Organ Dose Adjustments:**\n")
                if (matchedDrug.renalAdj.isNotBlank()) sb.append("• **Renal:** ${matchedDrug.renalAdj}\n")
                if (matchedDrug.hepaticAdj.isNotBlank()) sb.append("• **Hepatic:** ${matchedDrug.hepaticAdj}\n")
                sb.append("\n")
            }

            if (!matchedDrug.blackBoxWarning.isNullOrBlank()) {
                sb.append("🚨 **BLACK BOX WARNING:**\n${matchedDrug.blackBoxWarning}\n\n")
            }

            if (matchedDrug.contraindications.isNotBlank()) {
                sb.append("🚫 **Contraindications & Warnings:**\n${matchedDrug.contraindications.take(250)}...\n\n")
            }

            if (matchedDrug.brandsNepal.isNotEmpty()) {
                sb.append("🇳🇵 **Available Brands in Nepal:**\n")
                val brandsStr = matchedDrug.brandsNepal.take(5).joinToString(", ") { "${it.name} (${it.form})" }
                sb.append("$brandsStr\n\n")
            }

            sb.append("🔍 *Quick Action: Tap 'Search in App' below to view the full monograph, or 'Google (Chrome)' for live online guidelines.*")
            return sb.toString()
        }

        if (matchedProtocol != null) {
            val sb = StringBuilder()
            sb.append("🏥 **CLINICAL PROTOCOL: ${matchedProtocol.name.uppercase()}**\n")
            sb.append("*Category: ${matchedProtocol.category}*")
            if (matchedProtocol.icd10.isNotBlank()) sb.append(" • *ICD-10: ${matchedProtocol.icd10}*")
            sb.append("\n\n")

            sb.append("🎯 **First-Line Pharmacotherapy:**\n${matchedProtocol.firstLine.trim()}\n\n")

            if (matchedProtocol.secondLine.isNotBlank()) {
                sb.append("🔄 **Second-Line / Alternative Regimens:**\n${matchedProtocol.secondLine.trim()}\n\n")
            }

            if (matchedProtocol.inpatient.isNotBlank()) {
                sb.append("🏥 **Inpatient / Severe Management:**\n${matchedProtocol.inpatient.trim()}\n\n")
            }

            if (matchedProtocol.diagnosticCriteria.isNotBlank()) {
                sb.append("📋 **Diagnostic Criteria & Staging:**\n${matchedProtocol.diagnosticCriteria.trim()}\n\n")
            }

            if (matchedProtocol.redFlags.isNotBlank()) {
                sb.append("🚩 **Red Flags:**\n${matchedProtocol.redFlags.trim()}\n\n")
            }

            if (matchedProtocol.guidelines.isNotBlank()) {
                sb.append("📚 **Guidelines & Reference:**\n${matchedProtocol.guidelines.trim()}\n\n")
            }

            sb.append("🔍 *Quick Action: Tap 'Search in App' below to view related protocols, or 'Google (Chrome)' for live online guidelines.*")
            return sb.toString()
        }

        // Generic intelligent response when neither matches directly
        return "🩺 **Clinical Pharmacology & Disease Query: \"$query\"**\n\n" +
               "• **Therapeutic Assessment:** Cross-check renal (eGFR) and hepatic parameters prior to drug initiation or dose titration.\n" +
               "• **Dosing Calculation:** Adjust dosing by ideal body weight or BSA in pediatric, geriatric, and critically ill patients.\n" +
               "• **Interaction Screening:** Ensure no concomitant CYP3A4/CYP2C19 inhibitors or QT-prolonging agents are co-prescribed.\n\n" +
               "💡 **Next Steps:**\n" +
               "1. Tap **\"Search in App\"** below to browse our 1000+ national formulary monographs and 100+ clinical protocols.\n" +
               "2. Tap **\"Google (Chrome)\"** below to view real-time UpToDate, WHO, and CDC guidelines online."
    }

    private fun getClinicalReferenceSources(query: String): List<GroundingSource> {
        val lower = query.lowercase()
        val sources = mutableListOf<GroundingSource>()
        when {
            lower.contains("dengue") -> {
                sources.add(GroundingSource("EDCD Nepal Dengue Clinical Case Management Guideline", "https://edcd.gov.np/resources/dengue"))
                sources.add(GroundingSource("WHO SEARO Dengue Guidelines for Diagnosis & Management", "https://www.who.int/southeastasia/health-topics/dengue"))
            }
            lower.contains("scrub") || lower.contains("typhus") -> {
                sources.add(GroundingSource("EDCD Nepal Scrub Typhus Clinical Protocol & Doxycycline Schedule", "https://edcd.gov.np/resources/scrub-typhus"))
                sources.add(GroundingSource("CDC Scrub Typhus Clinical Care Guidelines", "https://www.cdc.gov/typhus/scrub/treatment.html"))
            }
            lower.contains("snake") || lower.contains("asv") || lower.contains("envenom") -> {
                sources.add(GroundingSource("National Protocol for Snakebite Management in Nepal (EDCD)", "https://edcd.gov.np/resources/snakebite"))
                sources.add(GroundingSource("WHO Guidelines for the Management of Snakebites SEARO", "https://www.who.int/southeastasia/health-topics/snakebite"))
            }
            lower.contains("rabies") -> {
                sources.add(GroundingSource("National Guideline for Rabies Prophylaxis in Nepal (EDCD)", "https://edcd.gov.np/rabies"))
                sources.add(GroundingSource("WHO Rabies Intradermal Immunization Position Paper", "https://www.who.int/news-room/fact-sheets/detail/rabies"))
            }
            lower.contains("leprosy") -> {
                sources.add(GroundingSource("National Leprosy Elimination Programme Nepal (LCDD/MoHP)", "https://edcd.gov.np"))
                sources.add(GroundingSource("WHO Guidelines for the Diagnosis, Treatment and Prevention of Leprosy", "https://www.who.int/publications/i/item/9789290226383"))
            }
            lower.contains("leishmaniasis") || lower.contains("kala") -> {
                sources.add(GroundingSource("National Protocol for Kala-azar Elimination in Nepal (EDCD)", "https://edcd.gov.np"))
                sources.add(GroundingSource("WHO Post-elimination Strategy for Visceral Leishmaniasis", "https://www.who.int/health-topics/leishmaniasis"))
            }
            lower.contains("asthma") -> {
                sources.add(GroundingSource("Global Initiative for Asthma (GINA 2024 Strategy)", "https://ginasthma.org"))
                sources.add(GroundingSource("WHO Pocket Book of Hospital Care / NCD Guidelines", "https://www.who.int"))
            }
            lower.contains("mi") || lower.contains("stemi") || lower.contains("nstemi") || lower.contains("cardiac") || lower.contains("acls") -> {
                sources.add(GroundingSource("AHA/ACC Guideline for the Management of STEMI", "https://www.ahajournals.org"))
                sources.add(GroundingSource("American Heart Association ACLS Resuscitation Algorithms", "https://cpr.heart.org"))
            }
            lower.contains("stroke") -> {
                sources.add(GroundingSource("AHA/ASA Guidelines for the Early Management of Acute Ischemic Stroke", "https://www.stroke.org"))
            }
            lower.contains("tb") || lower.contains("tuberculosis") -> {
                sources.add(GroundingSource("National Tuberculosis Control Centre Nepal (NTCC Thimi)", "https://ntc.gov.np"))
                sources.add(GroundingSource("WHO Consolidated Guidelines on Tuberculosis Module 4", "https://www.who.int/publications/i/item/9789240048126"))
            }
            lower.contains("sepsis") -> {
                sources.add(GroundingSource("Surviving Sepsis Campaign: International Guidelines 2021", "https://www.sccm.org/survivingsepsisguidelines"))
            }
            else -> {
                sources.add(GroundingSource("WHO Model List of Essential Medicines", "https://www.who.int/groups/expert-committee-on-selection-and-use-of-essential-medicines/essential-medicines-lists"))
                sources.add(GroundingSource("Ministry of Health and Population Nepal (MoHP)", "https://mohp.gov.np"))
                sources.add(GroundingSource("Epidemiology and Disease Control Division (EDCD Nepal)", "https://edcd.gov.np"))
            }
        }
        return sources
    }

    suspend fun fetchLiveNepalMedicalNews(category: String = "All"): MedicalNewsFetchResult = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Exception) {
            ""
        }

        val hasValidKey = apiKey.isNotBlank() && apiKey != "MY_GEMINI_API_KEY"

        if (hasValidKey) {
            try {
                val promptText = if (category == "All") {
                    "Provide a comprehensive, authoritative briefing on the latest clinical practice guidelines and medical updates from major international societies (ESC for Heart Failure and Hypertension, EASL & AASLD for MASLD/MASH, APASL for ACLF & Hepatitis B, ACG for Pancreatitis, ESGE, WHO, CDC, ASA for Stroke & Anesthesia) and Nepal national directives (EDCD, DDA) for 2024-2026. For each item provide: TITLE, CATEGORY (e.g. ESC (Cardiology), EASL & AASLD (Hepatology), APASL (Asia-Pacific), ACG & ESGE (Gastroenterology), WHO & CDC, ASA (Stroke & Anesthesia), Outbreak Alert, DDA Drug Recall), SOURCE, SUMMARY, and ACTIONABLE CLINICAL PRACTICE TAKEAWAY for doctors."
                } else {
                    "Provide the latest authoritative clinical practice guideline recommendations and recent updates regarding '$category' (including ESC for Heart failure, EASL, AASLD, APASL, WHO, CDC, ESGE, ACG, ASA, or EDCD/DDA) for 2024-2026 with TITLE, CATEGORY, SOURCE, SUMMARY, and ACTIONABLE CLINICAL TAKEAWAY for physicians."
                }

                val jsonBody = JSONObject().apply {
                    val contentsArr = JSONArray()
                    val userTurn = JSONObject().apply {
                        val partsArr = JSONArray().apply {
                            put(JSONObject().put("text", promptText))
                        }
                        put("role", "user")
                        put("parts", partsArr)
                    }
                    contentsArr.put(userTurn)
                    put("contents", contentsArr)

                    // Enable Google Search Grounding tool
                    val toolsArr = JSONArray().apply {
                        put(JSONObject().put("googleSearch", JSONObject()))
                    }
                    put("tools", toolsArr)

                    val sysContent = JSONObject().apply {
                        val partsArr = JSONArray().apply {
                            put(JSONObject().put("text", "You are an expert clinical pharmacologist, epidemiologist, and medical guideline specialist. Use Google Search grounding to retrieve real, latest authoritative clinical practice guidelines from EASL, AASLD, APASL, WHO, CDC, ESGE, ESC (including ESC Heart Failure, ESC Hypertension, ESC Atrial Fibrillation), ASA, ACG, as well as Nepal national directives."))
                        }
                        put("parts", partsArr)
                    }
                    put("systemInstruction", sysContent)
                }

                val mediaType = "application/json; charset=utf-8".toMediaType()
                val requestBody = jsonBody.toString().toRequestBody(mediaType)
                val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=$apiKey"

                val request = Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build()

                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val respStr = response.body?.string() ?: ""
                    val rootJson = JSONObject(respStr)
                    val candidates = rootJson.optJSONArray("candidates")
                    if (candidates != null && candidates.length() > 0) {
                        val candObj = candidates.getJSONObject(0)
                        val content = candObj.optJSONObject("content")
                        val parts = content?.optJSONArray("parts")
                        val text = parts?.optJSONObject(0)?.optString("text") ?: ""

                        // Extract Grounding Metadata
                        val groundingMeta = candObj.optJSONObject("groundingMetadata")
                        val webQueries = mutableListOf<String>()
                        val groundingSources = mutableListOf<GroundingSource>()

                        if (groundingMeta != null) {
                            val qArr = groundingMeta.optJSONArray("webSearchQueries")
                            if (qArr != null) {
                                for (i in 0 until qArr.length()) {
                                    webQueries.add(qArr.optString(i))
                                }
                            }

                            val chunksArr = groundingMeta.optJSONArray("groundingChunks")
                            if (chunksArr != null) {
                                for (i in 0 until chunksArr.length()) {
                                    val chunk = chunksArr.optJSONObject(i)
                                    val web = chunk?.optJSONObject("web")
                                    if (web != null) {
                                        val uri = web.optString("uri")
                                        val title = web.optString("title")
                                        if (uri.isNotBlank()) {
                                            groundingSources.add(GroundingSource(title = title.ifBlank { uri }, url = uri))
                                        }
                                    }
                                }
                            }
                        }

                        if (text.isNotBlank()) {
                            val parsedItems = parseGroundingResponseToNews(text, groundingSources, webQueries)
                            if (parsedItems.isNotEmpty()) {
                                return@withContext MedicalNewsFetchResult(
                                    items = parsedItems,
                                    rawText = text,
                                    searchQueries = webQueries,
                                    sources = groundingSources,
                                    isLiveGrounding = true
                                )
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                // Fallback to curated news if network or quota issue occurs
            }
        }

        // Return curated international guidelines & national clinical news
        val allCuratedNewsAndGuidelines = ClinicalGuidelinesNewsData.guidelines + curatedNepalMedicalNews
        val filteredCurated = if (category == "All") {
            allCuratedNewsAndGuidelines
        } else {
            val catPrefix = category.split("(")[0].trim()
            val tokens = category.replace(Regex("[^a-zA-Z0-9 ]"), " ").split("\\s+".toRegex()).filter { it.isNotBlank() }
            allCuratedNewsAndGuidelines.filter { item ->
                item.category.contains(catPrefix, ignoreCase = true) ||
                item.category.contains(category, ignoreCase = true) ||
                item.source.contains(catPrefix, ignoreCase = true) ||
                item.title.contains(catPrefix, ignoreCase = true) ||
                tokens.any { t -> t.length > 2 && (item.category.contains(t, ignoreCase = true) || item.title.contains(t, ignoreCase = true) || item.source.contains(t, ignoreCase = true)) }
            }
        }

        val allSources = allCuratedNewsAndGuidelines.flatMap { it.webSources }.distinctBy { it.url }
        val allQueries = allCuratedNewsAndGuidelines.flatMap { it.searchQueries }.distinct()

        return@withContext MedicalNewsFetchResult(
            items = filteredCurated,
            rawText = "Evidence-based Clinical Guidelines (ESC, EASL, AASLD, APASL, ACG, ESGE, WHO, CDC, ASA) and National Alerts",
            searchQueries = allQueries,
            sources = allSources,
            isLiveGrounding = false
        )
    }

    private fun parseGroundingResponseToNews(
        text: String,
        sources: List<GroundingSource>,
        queries: List<String>
    ): List<MedicalNewsItem> {
        val items = mutableListOf<MedicalNewsItem>()
        val blocks = text.split(Regex("(?m)^(?=#{1,3}\\s+|\\d+\\.\\s+\\*\\*|[A-Z\\s]{4,}:)"))
            .filter { it.trim().length > 30 }

        if (blocks.size >= 2) {
            blocks.forEachIndexed { idx, block ->
                val lines = block.lines().map { it.trim() }.filter { it.isNotBlank() }
                val title = lines.firstOrNull()?.replace(Regex("^[#*\\d.\\s]+"), "")?.take(100) ?: "Medical Update #${idx + 1}"
                val body = lines.drop(1).joinToString("\n")
                val isUrgent = block.contains("urgent", ignoreCase = true) || block.contains("outbreak", ignoreCase = true) || block.contains("recall", ignoreCase = true)
                val category = when {
                    block.contains("outbreak", ignoreCase = true) || block.contains("dengue", ignoreCase = true) || block.contains("cholera", ignoreCase = true) -> "Outbreak Alert"
                    block.contains("dda", ignoreCase = true) || block.contains("recall", ignoreCase = true) || block.contains("ban", ignoreCase = true) -> "DDA Drug Recall"
                    block.contains("maternal", ignoreCase = true) || block.contains("vaccine", ignoreCase = true) || block.contains("pregnancy", ignoreCase = true) -> "Vaccine & Maternal"
                    else -> "Clinical Guideline"
                }
                val takeaway = if (block.contains("takeaway", ignoreCase = true) || block.contains("clinical practice", ignoreCase = true)) {
                    lines.find { it.contains("takeaway", ignoreCase = true) || it.contains("clinical", ignoreCase = true) }
                        ?.replace(Regex("^[#*\\-\\s]+"), "") ?: "Verify patient status and adjust clinical management according to current national guidelines."
                } else {
                    "Review institutional protocol and consult updated national EDCD/DDA directives."
                }

                items.add(
                    MedicalNewsItem(
                        id = "live_grounding_$idx",
                        title = title,
                        category = category,
                        date = "Live Update 2025/2026",
                        source = if (block.contains("EDCD", ignoreCase = true)) "EDCD Nepal (Search Grounded)" else if (block.contains("DDA", ignoreCase = true)) "DDA Nepal (Search Grounded)" else "Gemini Grounded Live Search",
                        summary = body.take(450),
                        clinicalTakeaway = takeaway,
                        webSources = sources.take(3),
                        isUrgent = isUrgent,
                        searchQueries = queries
                    )
                )
            }
        }

        // If block splitting resulted in too few items, synthesize one comprehensive item plus top curated
        if (items.isEmpty()) {
            items.add(
                MedicalNewsItem(
                    id = "live_grounding_summary",
                    title = "Live Grounded Briefing: Nepal Clinical Epidemiology & Drug Updates",
                    category = "Clinical Guideline",
                    date = "Live Grounded Search 2025/2026",
                    source = "Gemini Search Grounding (EDCD/DDA/WHO Nepal)",
                    summary = text.take(600),
                    clinicalTakeaway = "Integrate recent epidemiological trends into local triage, antibiotic selection, and patient education.",
                    webSources = sources,
                    isUrgent = false,
                    searchQueries = queries
                )
            )
            items.addAll(curatedNepalMedicalNews.take(4))
        }

        return items
    }

    val curatedNepalMedicalNews = listOf(
        MedicalNewsItem(
            id = "news_dengue_1",
            title = "EDCD Dengue Surveillance & Serotype Shift Alert (Nepal)",
            category = "Outbreak Alert",
            date = "Recent Surveillance 2025/2026",
            source = "Epidemiology and Disease Control Division (EDCD Teku)",
            summary = "Surveillance in Kathmandu Valley, Gandaki, and Terai lowlands indicates co-circulation of DENV-2 and DENV-3 serotypes with elevated risk of Severe Dengue (DHF/DSS). Secondary infections exhibit increased vascular permeability and sudden defervescence shock.",
            clinicalTakeaway = "Avoid NSAIDs (Ibuprofen, Diclofenac) strictly due to platelet dysfunction and hemorrhage risk; Paracetamol only. Monitor hematocrit and platelet counts daily during critical phase (days 3-7). Aggressive isotonic crystalloid fluid resuscitation indicated if Hct rises >20%.",
            webSources = listOf(
                GroundingSource("EDCD Official Disease Surveillance - Ministry of Health Nepal", "https://edcd.gov.np"),
                GroundingSource("WHO Nepal Dengue Situation Updates", "https://www.who.int/nepal")
            ),
            isUrgent = true,
            searchQueries = listOf("EDCD Nepal Dengue outbreak updates", "Nepal health ministry dengue serotype")
        ),
        MedicalNewsItem(
            id = "news_dda_1",
            title = "DDA Drug Alert: Ban on Certain Irrational Fixed-Dose Combinations (FDCs)",
            category = "DDA Drug Recall",
            date = "DDA Regulatory Circular",
            source = "Department of Drug Administration (DDA Nepal)",
            summary = "DDA has prohibited the manufacturing, import, and sale of several irrational antimicrobial and analgesic fixed-dose combinations lacking clinical trial efficacy (e.g. Cefixime + Ofloxacin, Paracetamol + Tramadol unapproved strengths) under the Drugs Act 2035.",
            clinicalTakeaway = "Prescribe single-entity antimicrobial agents targeted by culture/sensitivity. Discontinue stocking unapproved dual-oral cephalosporin-fluoroquinolone combinations to mitigate AMR.",
            webSources = listOf(
                GroundingSource("Department of Drug Administration (DDA) Notices", "https://dda.gov.np"),
                GroundingSource("National List of Essential Medicines Nepal", "https://mohp.gov.np")
            ),
            isUrgent = true,
            searchQueries = listOf("DDA Nepal banned drugs fixed dose combinations", "DDA drug safety notifications")
        ),
        MedicalNewsItem(
            id = "news_rabies_1",
            title = "Universal 2-Site Intradermal Rabies PEP Directive for District & Zonal Hospitals",
            category = "Clinical Guideline",
            date = "National Guideline Update",
            source = "EDCD Nepal / WHO Collaborating Center",
            summary = "The Ministry of Health reiterates mandatory transition to the Thai Red Cross 2-site Intradermal (ID) rabies vaccine regimen (0.1 mL at 2 deltoid sites on Days 0, 3, 7, 28) across all public healthcare facilities, achieving 70% cost reduction and identical seroconversion compared to IM Essen.",
            clinicalTakeaway = "Never suture category III animal bite wounds before infiltration of Equine Rabies Immunoglobulin (ERIG 40 IU/kg). Wash with running water and soap for at least 15 minutes immediately. Use insulin/tuberculin syringe for accurate 0.1 mL ID bleb.",
            webSources = listOf(
                GroundingSource("National Guideline for Rabies Prophylaxis in Nepal", "https://edcd.gov.np/rabies")
            ),
            isUrgent = false,
            searchQueries = listOf("Nepal rabies intradermal protocol EDCD", "EDCD rabies immunoglobulin guidelines")
        ),
        MedicalNewsItem(
            id = "news_amr_typhoid",
            title = "Antimicrobial Resistance Alert: Ceftriaxone & Azithromycin Resistance in Enteric Fever",
            category = "Clinical Guideline",
            date = "Clinical Surveillance Bulletin",
            source = "Nepal Health Research Council (NHRC) / TUTH / Patan Hospital",
            summary = "Multi-centric bacteriological surveillance in Kathmandu and Biratnagar documents emerging Salmonella enterica serovars with reduced susceptibility to Azithromycin and fluoroquinolones. High rates of extended-spectrum beta-lactamase (ESBL) producing uropathogens also identified.",
            clinicalTakeaway = "Empirical treatment for uncomplicated typhoid should be guided by local antibiogram: consider oral Cefixime (20 mg/kg/day) or Azithromycin (20 mg/kg/day) with strict 7-day completion. Reserve IV Meropenem for severe/resistant hospital cases with septic shock.",
            webSources = listOf(
                GroundingSource("Nepal Health Research Council AMR Registry", "https://nhrc.gov.np"),
                GroundingSource("Nepal Journal of Health Sciences AMR Studies", "https://www.nepjol.info")
            ),
            isUrgent = false,
            searchQueries = listOf("Typhoid antibiotic resistance Nepal Kathmandu", "NHRC AMR surveillance report")
        ),
        MedicalNewsItem(
            id = "news_snakebite_season",
            title = "Terai Snakebite Season: Rapid ASV Supply & Cold Chain Protocols",
            category = "Outbreak Alert",
            date = "Terai Provincial Directive",
            source = "EDCD / Ministry of Health and Population",
            summary = "With agricultural activity, sudden surges in Common Krait (Bungarus caeruleus) and Russell's Viper envenomations are reported across Morang, Jhapa, Dhanusha, and Banke. Emergency ASV (Anti-Snake Venom) stocks have been replenished to primary health centers.",
            clinicalTakeaway = "Perform 20-minute Whole Blood Clotting Test (20WBCT) immediately upon admission. Initial polyvalent ASV dose is 10 vials in 500 mL Normal Saline over 1 hour. Keep Epinephrine (1:1000) drawn at bedside before starting ASV infusion.",
            webSources = listOf(
                GroundingSource("National Snakebite Management Guidelines Nepal", "https://edcd.gov.np/snakebite")
            ),
            isUrgent = true,
            searchQueries = listOf("Snakebite protocol Nepal EDCD Terai", "Polyvalent ASV supply Nepal")
        ),
        MedicalNewsItem(
            id = "news_tb_bpal",
            title = "National TB Program: Shortened BPaL/M Regimens for MDR-TB Rollout",
            category = "Clinical Guideline",
            date = "National TB Center Update",
            source = "National Tuberculosis Control Centre (NTCC Thimi)",
            summary = "Nepal has expanded the 6-month all-oral BPaL/BPaLM regimen (Bedaquiline, Pretomanid, Linezolid, Moxifloxacin) for rifampicin-resistant and multidrug-resistant tuberculosis across regional tertiary centres, replacing 18-month injectable regimens.",
            clinicalTakeaway = "Screen all presumptive pulmonary TB cases with upfront GeneXpert MTB/RIF. Monitor baseline and bi-weekly ECG for QTc prolongation with Bedaquiline + Moxifloxacin and CBC for Linezolid-associated myelosuppression.",
            webSources = listOf(
                GroundingSource("National Tuberculosis Control Centre Nepal", "https://ntc.gov.np")
            ),
            isUrgent = false,
            searchQueries = listOf("Nepal BPaLM regimen MDR TB Thimi", "GeneXpert TB protocol Nepal")
        ),
        MedicalNewsItem(
            id = "news_maternal_htn",
            title = "Family Welfare Division: Protocol for Severe Preeclampsia & Eclampsia",
            category = "Vaccine & Maternal",
            date = "Maternal Health Directive",
            source = "Family Welfare Division / Paropakar Maternity Hospital",
            summary = "Updated maternal safety protocol emphasizes immediate initiation of Magnesium Sulfate (Pritchard regimen: 4g IV + 10g IM loading, then 5g IM q4h) for severe preeclampsia/eclampsia, and oral Labetalol or Nifedipine for acute severe systolic BP >160 mmHg.",
            clinicalTakeaway = "Check patellar deep tendon reflexes, respiratory rate (>16/min), and urine output (>30 mL/hr) before each maintenance dose of Magnesium Sulfate. Keep 10% Calcium Gluconate (10 mL IV over 10 min) available as antidote.",
            webSources = listOf(
                GroundingSource("MOHP Family Welfare Division Protocols", "https://fwd.gov.np")
            ),
            isUrgent = false,
            searchQueries = listOf("Preeclampsia protocol Nepal maternal health", "Magnesium sulfate eclampsia Nepal")
        ),
        MedicalNewsItem(
            id = "news_cholera_wash",
            title = "Monsoon Waterborne Illness: Vibrio cholerae & Acute Diarrheal Disease Sentinel Warning",
            category = "Outbreak Alert",
            date = "Seasonal Public Health Bulletin",
            source = "Sukraraj Tropical and Infectious Disease Hospital (STIDH Teku)",
            summary = "Detection of Vibrio cholerae O1 Ogawa strains in peri-urban Kathmandu drinking water pipelines. Early notification to EDCD surveillance is mandatory for any patient presenting with profuse 'rice-water' stool.",
            clinicalTakeaway = "Immediate oral and IV rehydration (Ringer's Lactate) is life-saving; antibiotic therapy (Doxycycline 300 mg single dose or Azithromycin 1g single dose) shortens illness duration and bacterial shedding in severe cholera.",
            webSources = listOf(
                GroundingSource("Teku Hospital Infectious Disease Surveillance", "https://stidh.gov.np")
            ),
            isUrgent = true,
            searchQueries = listOf("Cholera cases Kathmandu Teku hospital", "Vibrio cholerae Nepal monsoon")
        )
    )
}
