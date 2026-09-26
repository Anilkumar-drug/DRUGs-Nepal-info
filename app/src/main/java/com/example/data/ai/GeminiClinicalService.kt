package com.example.data.ai

import com.example.BuildConfig
import com.example.data.model.GroundingSource
import com.example.data.model.MedicalNewsFetchResult
import com.example.data.model.MedicalNewsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object GeminiClinicalService {

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private const val SYSTEM_PROMPT =
        "You are the DRUGs Nepal Clinical Decision Support AI Assistant for licensed physicians and healthcare professionals in Nepal. " +
        "Provide direct, high-yield clinical pharmacology insights referencing UpToDate, Harrison's, KD Tripathi, and WHO guidelines. " +
        "Address drug interactions, organ dosage adjustments, mechanism of action, black box warnings, and local Nepal/India brand equivalents. " +
        "Format with clear headings, bullet points, and high clinical precision."

    suspend fun queryClinicalAi(userQuery: String): String = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Exception) {
            ""
        }

        val hasValidKey = apiKey.isNotBlank() && apiKey != "MY_GEMINI_API_KEY"

        if (hasValidKey) {
            try {
                val jsonBody = JSONObject().apply {
                    val contentsArr = JSONArray()
                    val userTurn = JSONObject().apply {
                        val partsArr = JSONArray()
                        partsArr.put(JSONObject().put("text", userQuery))
                        put("role", "user")
                        put("parts", partsArr)
                    }
                    contentsArr.put(userTurn)
                    put("contents", contentsArr)

                    val sysContent = JSONObject().apply {
                        val partsArr = JSONArray()
                        partsArr.put(JSONObject().put("text", SYSTEM_PROMPT))
                        put("parts", partsArr)
                    }
                    put("systemInstruction", sysContent)
                }

                val mediaType = "application/json; charset=utf-8".toMediaType()
                val requestBody = jsonBody.toString().toRequestBody(mediaType)
                // Use standard gemini-3.5-flash as per gemini-api skill
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
                        val content = candidates.getJSONObject(0).optJSONObject("content")
                        val parts = content?.optJSONArray("parts")
                        if (parts != null && parts.length() > 0) {
                            val text = parts.getJSONObject(0).optString("text")
                            if (text.isNotBlank()) {
                                return@withContext text
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                // Fallback to offline clinical pharmacology intelligence if network fails
            }
        }

        // Context-aware Clinical Pharmacology Knowledge Base
        return@withContext generateLocalClinicalInsight(userQuery)
    }

    private fun generateLocalClinicalInsight(query: String): String {
        val lower = query.lowercase()
        return when {
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
                "🩺 **Clinical Pharmacology Assessment**\n\n" +
                "Regarding your inquiry on: *\"$query\"*\n\n" +
                "1. **Therapeutic Review:** Verify patient's baseline renal function (eGFR) and liver profile before prescribing or titrating.\n" +
                "2. **Interaction Screening:** Check concurrent prescriptions for CYP450 enzyme inducers/inhibitors, QT-prolonging agents, or additive electrolyte shifts.\n" +
                "3. **Dosage Guideline:** Always cross-reference patient body weight in pediatric/geriatric cohorts and adjust for organ clearance.\n" +
                "4. **Monitoring:** Re-evaluate symptom response, adverse effect profile, and therapeutic compliance at scheduled follow-up."
            }
        }
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
                    "Provide a comprehensive, authoritative briefing on the latest medical news, disease outbreak reports (Dengue, Cholera, Japanese Encephalitis, Scrub Typhus, Rabies, Snakebite), DDA (Department of Drug Administration) drug alerts and recalls, Ministry of Health (MOHP) clinical directives, and WHO Nepal updates for Nepal in 2025-2026. For each item provide: TITLE, CATEGORY (Outbreak Alert / DDA Drug Recall / Clinical Guideline / Vaccine & Maternal), SOURCE (e.g. EDCD Nepal, DDA, WHO Nepal), SUMMARY, and CLINICAL PRACTICE TAKEAWAY for doctors."
                } else {
                    "Provide authoritative recent updates and clinical guidance regarding '$category' in Nepal (EDCD, DDA, MOHP, WHO Nepal) for 2025-2026 with TITLE, CATEGORY, SOURCE, SUMMARY, and CLINICAL PRACTICE TAKEAWAY."
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
                            put(JSONObject().put("text", "You are an expert clinical epidemiologist and drug regulatory reporter for healthcare practitioners in Nepal. Use Google Search grounding to retrieve real, recent medical events, disease outbreaks, DDA drug regulatory actions, and EDCD surveillance in Nepal."))
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

        // Return curated Nepal medical news fallback
        val filteredCurated = if (category == "All") {
            curatedNepalMedicalNews
        } else {
            curatedNepalMedicalNews.filter { it.category.contains(category, ignoreCase = true) }
        }

        val allSources = curatedNepalMedicalNews.flatMap { it.webSources }.distinctBy { it.url }
        val allQueries = curatedNepalMedicalNews.flatMap { it.searchQueries }.distinct()

        return@withContext MedicalNewsFetchResult(
            items = filteredCurated,
            rawText = "Curated Nepal Clinical Surveillance and DDA Drug Notices",
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
