package com.example.data.calculator

import kotlin.math.pow
import kotlin.math.sqrt

object ClinicalCalculators {

    data class EgfrResult(
        val crcl: Double,
        val stage: String,
        val clinicalImplication: String
    )

    fun calculateEgfr(age: Int, weightKg: Double, serumCrMgDl: Double, isFemale: Boolean): EgfrResult {
        if (age <= 0 || weightKg <= 0 || serumCrMgDl <= 0) {
            return EgfrResult(0.0, "Invalid Inputs", "Enter positive values for age, weight, and creatinine.")
        }
        val factor = if (isFemale) 0.85 else 1.0
        val crcl = ((140 - age) * weightKg * factor) / (72 * serumCrMgDl)

        val (stage, note) = when {
            crcl >= 90.0 -> Pair("Stage 1 (Normal renal function)", "Standard drug dosing. Check renal function annually.")
            crcl >= 60.0 -> Pair("Stage 2 (Mildly reduced GFR)", "Generally normal drug dosing, cautious with high-dose aminoglycosides.")
            crcl >= 45.0 -> Pair("Stage 3a (Mild-to-moderate reduction)", "Metformin max 2000mg/day. Adjust renal antibiotics (e.g., Amox-Clav).")
            crcl >= 30.0 -> Pair("Stage 3b (Moderate-to-severe reduction)", "Metformin max 1000mg/day (no new starts). Adjust fluoroquinolones and beta-lactams.")
            crcl >= 15.0 -> Pair("Stage 4 (Severely reduced GFR)", "Metformin CONTRAINDICATED. Substantial dose reductions required for most antibiotics.")
            else -> Pair("Stage 5 (Kidney Failure / ESRD)", "Dialysis consideration. Strictly titrate post-dialysis supplemental doses.")
        }

        return EgfrResult(crcl, stage, note)
    }

    data class BsaResult(
        val mostellerBsa: Double,
        val duboisBsa: Double,
        val normalComparison: String
    )

    fun calculateBsa(heightCm: Double, weightKg: Double): BsaResult {
        if (heightCm <= 0 || weightKg <= 0) {
            return BsaResult(0.0, 0.0, "Enter valid height and weight.")
        }
        val mosteller = sqrt((heightCm * weightKg) / 3600.0)
        val dubois = 0.007184 * heightCm.pow(0.725) * weightKg.pow(0.425)
        val comp = when {
            mosteller < 1.6 -> "Below average adult BSA (standard average ~1.73 m²)"
            mosteller > 2.0 -> "Above average adult BSA (higher volume of distribution)"
            else -> "Average adult BSA (~1.7 - 1.9 m²)"
        }
        return BsaResult(mosteller, dubois, comp)
    }

    data class ChildPughResult(
        val totalScore: Int,
        val childClass: String,
        val oneYearSurvival: String,
        val drugGuidance: String
    )

    fun calculateChildPugh(
        bilirubinMgDl: Double,
        albuminGDl: Double,
        inr: Double,
        ascitesScore: Int, // 1: None, 2: Slight/controlled, 3: Moderate-Severe
        encephalopathyScore: Int // 1: None, 2: Grade 1-2, 3: Grade 3-4
    ): ChildPughResult {
        var score = 0

        // Bilirubin
        score += when {
            bilirubinMgDl < 2.0 -> 1
            bilirubinMgDl <= 3.0 -> 2
            else -> 3
        }

        // Albumin
        score += when {
            albuminGDl > 3.5 -> 1
            albuminGDl >= 2.8 -> 2
            else -> 3
        }

        // INR
        score += when {
            inr < 1.7 -> 1
            inr <= 2.3 -> 2
            else -> 3
        }

        score += ascitesScore.coerceIn(1, 3)
        score += encephalopathyScore.coerceIn(1, 3)

        val (cls, survival, guidance) = when (score) {
            in 5..6 -> Triple(
                "Class A (Well-compensated disease)",
                "100% 1-year survival / 85% 2-year survival",
                "Standard dosing for most medications; initiate at normal or slightly reduced initial doses with monitoring."
            )
            in 7..9 -> Triple(
                "Class B (Significant functional compromise)",
                "80% 1-year survival / 60% 2-year survival",
                "Reduce initial doses of hepatically cleared drugs by 25-50%. Avoid sedatives and hepatotoxins."
            )
            else -> Triple(
                "Class C (Decompensated liver disease)",
                "45% 1-year survival / 35% 2-year survival",
                "Severe hepatic impairment. Strictly avoid hepatically metabolized drugs unless vital. High risk of encephalopathy."
            )
        }

        return ChildPughResult(score, cls, survival, guidance)
    }

    data class ParacetamolToxicityResult(
        val isToxicityProbable: Boolean,
        val treatmentLineCutoff: Double,
        val action: String
    )

    fun evaluateParacetamolOverdose(hoursPostIngestion: Double, serumLevelUgMl: Double): ParacetamolToxicityResult {
        if (hoursPostIngestion < 4.0) {
            return ParacetamolToxicityResult(
                isToxicityProbable = false,
                treatmentLineCutoff = 150.0,
                action = "Serum levels drawn before 4 hours post-ingestion cannot be interpreted on the Rumack-Matthew nomogram. Repeat level at 4 hours."
            )
        }
        if (hoursPostIngestion > 24.0) {
            return ParacetamolToxicityResult(
                isToxicityProbable = serumLevelUgMl > 5.0,
                treatmentLineCutoff = 4.7,
                action = "Late presentation (>24h). Nomogram not validated. If serum paracetamol detectable or AST/ALT elevated, administer N-Acetylcysteine immediately."
            )
        }

        // Treatment line: 150 µg/mL at 4h, half-life decay of 4h -> line = 150 * 0.5^((hours - 4) / 4)
        val cutoff = 150.0 * 0.5.pow((hoursPostIngestion - 4.0) / 4.0)
        val isToxic = serumLevelUgMl >= cutoff

        val action = if (isToxic) {
            "CRITICAL: Serum level ($serumLevelUgMl µg/mL) is AT OR ABOVE the treatment line ($cutoff µg/mL). Hepatotoxicity is PROBABLE. Start IV N-Acetylcysteine (NAC) 3-bag protocol immediately without waiting for repeat levels."
        } else {
            "SAFE: Serum level ($serumLevelUgMl µg/mL) is BELOW the treatment line ($cutoff µg/mL). Hepatic injury is unlikely. Monitor AST/ALT and repeat in 4-6 hours if sustained-release formulation was ingested."
        }

        return ParacetamolToxicityResult(isToxic, cutoff, action)
    }

    data class PediatricDoseResult(
        val totalDoseMg: Double,
        val volumeMl: Double
    )

    fun calculatePediatricLiquidDose(
        weightKg: Double,
        doseMgPerKg: Double,
        mgInSyrup: Double,
        mlInSyrup: Double
    ): PediatricDoseResult {
        val totalMg = weightKg * doseMgPerKg
        val ml = if (mgInSyrup > 0) (totalMg * mlInSyrup) / mgInSyrup else 0.0
        return PediatricDoseResult(totalMg, ml)
    }

    // --- 6. CHA2DS2-VASc Atrial Fibrillation Stroke Risk Stratification ---
    data class Cha2Ds2VascResult(
        val totalScore: Int,
        val strokeRiskPercentPerYear: Double,
        val riskStratum: String,
        val recommendation: String
    )

    fun calculateCha2Ds2Vasc(
        chf: Boolean,
        hypertension: Boolean,
        ageGroup: Int, // 0: <65 (0 pt), 1: 65-74 (1 pt), 2: >=75 (2 pts)
        diabetes: Boolean,
        strokeTiaThromboembolism: Boolean, // 2 pts
        vascularDisease: Boolean, // MI, PAD, aortic plaque (1 pt)
        isFemale: Boolean // 1 pt (if other risk factors present)
    ): Cha2Ds2VascResult {
        var score = 0
        if (chf) score += 1
        if (hypertension) score += 1
        when (ageGroup) {
            1 -> score += 1
            2 -> score += 2
        }
        if (diabetes) score += 1
        if (strokeTiaThromboembolism) score += 2
        if (vascularDisease) score += 1
        if (isFemale) score += 1

        val annualRisk = when (score) {
            0 -> 0.2
            1 -> 0.6
            2 -> 2.2
            3 -> 3.2
            4 -> 4.8
            5 -> 7.2
            6 -> 9.7
            7 -> 11.2
            8 -> 10.8
            else -> 12.2
        }

        val riskStratum = when {
            score == 0 -> "Low Risk (0 points)"
            score == 1 && isFemale -> "Low Risk (1 pt from sex only)"
            score == 1 -> "Intermediate Risk (1 point)"
            else -> "High Risk ($score points)"
        }

        val recommendation = when {
            score == 0 -> "No antithrombotic therapy required (ESC/AHA Guidelines)."
            score == 1 && !isFemale -> "Oral Anticoagulation (DOAC e.g. Apixaban, Dabigatran, Rivaroxaban) should be considered based on individual bleeding risk."
            score == 1 && isFemale -> "No antithrombotic therapy required if female sex is the solitary risk factor."
            else -> "Oral Anticoagulation (DOAC e.g. Apixaban, Dabigatran, Rivaroxaban or Warfarin INR 2.0-3.0) is strongly recommended unless contraindicated."
        }

        return Cha2Ds2VascResult(score, annualRisk, riskStratum, recommendation)
    }

    // --- 7. CURB-65 Pneumonia Severity Score ---
    data class Curb65Result(
        val totalScore: Int,
        val mortalityRiskPercent: Double,
        val riskGroup: String,
        val managementGuidance: String
    )

    fun calculateCurb65(
        confusion: Boolean, // AMTS <= 8 or new disorientation
        ureaElevated: Boolean, // BUN > 19 mg/dL or Urea > 7 mmol/L
        respRateElevated: Boolean, // RR >= 30 breaths/min
        bloodPressureLow: Boolean, // SBP < 90 mmHg or DBP <= 60 mmHg
        age65OrOlder: Boolean // Age >= 65 years
    ): Curb65Result {
        var score = 0
        if (confusion) score += 1
        if (ureaElevated) score += 1
        if (respRateElevated) score += 1
        if (bloodPressureLow) score += 1
        if (age65OrOlder) score += 1

        val (mortality, riskGroup, guidance) = when (score) {
            0 -> Triple(0.6, "Low Risk (Group 1)", "Outpatient care appropriate. Oral Amoxicillin 500mg-1g TID or Azithromycin/Doxycycline.")
            1 -> Triple(2.7, "Low Risk (Group 1)", "Consider home treatment or brief observation. Oral antibiotics.")
            2 -> Triple(6.8, "Moderate Risk (Group 2)", "Consider short-stay hospital admission or closely monitored outpatient therapy with Amoxicillin-Clavulanate + Macrolide.")
            3 -> Triple(14.0, "High Risk (Group 3 - Severe CAP)", "Urgent hospital admission. IV Ceftriaxone 1-2g OD + Azithromycin 500mg IV OD.")
            4 -> Triple(27.8, "Very High Risk (Group 3 - Critical)", "Urgent hospital admission, immediate ICU / HDU assessment. IV broad spectrum beta-lactam + macrolide.")
            else -> Triple(33.0, "Extreme Risk (Group 3 - Critical)", "Immediate ICU admission with mechanical ventilatory and inotropic support readiness.")
        }

        return Curb65Result(score, mortality, riskGroup, guidance)
    }

    // --- 8. Glasgow Coma Scale (GCS) Assessment ---
    data class GcsResult(
        val eyeScore: Int,
        val verbalScore: Int,
        val motorScore: Int,
        val totalScore: Int,
        val severity: String,
        val clinicalGuidance: String
    )

    fun calculateGcs(
        eye: Int, // 1 to 4
        verbal: Int, // 1 to 5
        motor: Int // 1 to 6
    ): GcsResult {
        val total = eye.coerceIn(1, 4) + verbal.coerceIn(1, 5) + motor.coerceIn(1, 6)
        val severity = when {
            total <= 8 -> "Severe Head Injury / Coma (GCS <= 8)"
            total in 9..12 -> "Moderate Brain Injury (GCS 9-12)"
            else -> "Mild Brain Injury (GCS 13-15)"
        }
        val guidance = when {
            total <= 8 -> "CRITICAL: 'GCS 8, Intubate!' High risk of aspiration and airway compromise. Secure endotracheal airway immediately, urgent NCCT Head, elevate head of bed 30 degrees, neurosurgical consult."
            total in 9..12 -> "Urgent NCCT Head indicated. Close neuro-vitals monitoring q30-60min. Admit to High Dependency Unit (HDU) or Trauma Ward."
            else -> "Monitor neuro-checks q2-4 hours. Check for red flags (recurrent vomiting, worsening headache, amnesia >30min, coagulopathy)."
        }
        return GcsResult(eye, verbal, motor, total, severity, guidance)
    }

    // --- 9. Pediatric Liquid Suspension Auto-Calculator (mg/kg to mL) ---
    data class PediatricSuspensionResult(
        val singleDoseMg: Double,
        val singleDoseMl: Double,
        val totalDailyMg: Double,
        val totalDailyMl: Double,
        val concentrationString: String,
        val intervalText: String,
        val clinicalSafetyNotice: String
    )

    fun calculatePediatricDose(
        weightKg: Double,
        doseMgPerKg: Double,
        concentrationMg: Double, // e.g. 125, 250
        perMl: Double = 5.0, // usually 5 mL
        dosesPerDay: Int = 3 // e.g. 3 for TID, 4 for QID
    ): PediatricSuspensionResult {
        if (weightKg <= 0 || doseMgPerKg <= 0 || concentrationMg <= 0 || perMl <= 0) {
            return PediatricSuspensionResult(0.0, 0.0, 0.0, 0.0, "", "", "Please enter valid weight, dose, and suspension concentration.")
        }
        val singleDoseMg = weightKg * doseMgPerKg
        val singleDoseMl = (singleDoseMg * perMl) / concentrationMg
        val totalDailyMg = singleDoseMg * dosesPerDay
        val totalDailyMl = singleDoseMl * dosesPerDay

        val interval = when (dosesPerDay) {
            1 -> "Once daily (OD)"
            2 -> "Every 12 hours (BD)"
            3 -> "Every 8 hours (TID)"
            4 -> "Every 6 hours (QID)"
            else -> "Divided into $dosesPerDay doses"
        }

        val safety = buildString {
            append("Administer using calibrated oral syringe or measuring cup. ")
            if (singleDoseMl > 15.0) {
                append("⚠️ Single volume is high (>15 mL). Verify suspension concentration or consider higher-strength formulation. ")
            }
            append("Shake suspension thoroughly before each administration.")
        }

        return PediatricSuspensionResult(
            singleDoseMg = singleDoseMg,
            singleDoseMl = singleDoseMl,
            totalDailyMg = totalDailyMg,
            totalDailyMl = totalDailyMl,
            concentrationString = "${concentrationMg.toInt()} mg / ${perMl.toInt()} mL",
            intervalText = interval,
            clinicalSafetyNotice = safety
        )
    }

    // --- 10. IV Infusion & Drop Rate (gtt/min) Calculator ---
    data class IvInfusionResult(
        val concentrationMcgPerMl: Double,
        val pumpRateMlPerHour: Double,
        val standardDripRateGttPerMin: Int, // 20 gtt/mL macro
        val microDripRateGttPerMin: Int,    // 60 gtt/mL pediatric micro
        val diluentCompatibility: String,
        val clinicalCaution: String
    )

    fun calculateIvInfusion(
        drugName: String,
        totalDrugMg: Double,
        bagVolumeMl: Double,
        patientWeightKg: Double,
        doseRateMcgKgMin: Double
    ): IvInfusionResult {
        if (totalDrugMg <= 0 || bagVolumeMl <= 0 || patientWeightKg <= 0 || doseRateMcgKgMin <= 0) {
            return IvInfusionResult(0.0, 0.0, 0, 0, "", "Enter valid drug amount, bag volume, weight, and target infusion rate.")
        }
        // Total drug in mcg
        val totalDrugMcg = totalDrugMg * 1000.0
        val concentrationMcgPerMl = totalDrugMcg / bagVolumeMl

        // Dose required per minute (mcg/min)
        val doseRequiredMcgPerMin = doseRateMcgKgMin * patientWeightKg

        // Rate in mL/min and mL/hr
        val rateMlPerMin = doseRequiredMcgPerMin / concentrationMcgPerMl
        val pumpRateMlPerHour = rateMlPerMin * 60.0

        val standardDrip = (rateMlPerMin * 20.0).toInt().coerceAtLeast(1)
        val microDrip = (rateMlPerMin * 60.0).toInt().coerceAtLeast(1)

        val (compat, caution) = when {
            drugName.contains("Noradrenaline", ignoreCase = true) || drugName.contains("Norepinephrine", ignoreCase = true) -> Pair(
                "Compatible with 5% Dextrose (D5W) or D5NS. (Avoid plain Normal Saline alone without dextrose; unstable at pH > 6).",
                "Infuse strictly via central venous line. Extravasation causes ischemic tissue necrosis (Phentolamine antidote). Titrate to MAP >= 65 mmHg."
            )
            drugName.contains("Dopamine", ignoreCase = true) -> Pair(
                "Compatible with 5% Dextrose, Normal Saline, or Ringer's Lactate. Incompatible with alkaline solutions (Sodium Bicarbonate).",
                "Renal dose (1-3 mcg/kg/min), inotropic (5-10 mcg/kg/min), vasoconstrictor (>10 mcg/kg/min). Central line preferred."
            )
            drugName.contains("Dobutamine", ignoreCase = true) -> Pair(
                "Compatible with D5W and Normal Saline. Avoid alkaline solutions.",
                "Pure inotrope; increases myocardial oxygen demand. Monitor ECG for tachyarrhythmias and maintain SBP."
            )
            drugName.contains("Nitroglycerin", ignoreCase = true) -> Pair(
                "Compatible with D5W or Normal Saline. Requires non-PVC glass/polyethylene infusion tubing to avoid plastic absorption.",
                "Titrate every 5-10 min for ischemic chest pain or pulmonary edema. Contraindicated if SBP < 90 mmHg or recent PDE-5 inhibitors."
            )
            else -> Pair(
                "Compatible with 5% Dextrose and 0.9% Normal Saline.",
                "Verify line patency, infusion rate limits, and hemodynamic vitals frequently."
            )
        }

        return IvInfusionResult(
            concentrationMcgPerMl = concentrationMcgPerMl,
            pumpRateMlPerHour = pumpRateMlPerHour,
            standardDripRateGttPerMin = standardDrip,
            microDripRateGttPerMin = microDrip,
            diluentCompatibility = compat,
            clinicalCaution = caution
        )
    }

    // --- 11. Nepal National Snakebite ASV & Protocol Calculator ---
    data class SnakebiteAsvResult(
        val envenomationType: String,
        val initialAsvDoseVials: Int,
        val diluentGuidance: String,
        val neostigmineTestProtocol: String?,
        val wbct20Guidance: String,
        val adrenalinePrecaution: String
    )

    fun calculateSnakebiteAsv(
        isNeurotoxic: Boolean, // Krait / Cobra (Ptosis, respiratory paralysis)
        isHemotoxic: Boolean,  // Russell's / Pit Viper (Bleeding, 20WBCT uncoagulated)
        wbctUnclotted: Boolean,
        hasSystemicSigns: Boolean
    ): SnakebiteAsvResult {
        val type = when {
            isNeurotoxic && isHemotoxic -> "Mixed Envenomation (Neurotoxic + Hemotoxic)"
            isNeurotoxic -> "Neurotoxic Envenomation (Common Krait / Cobra)"
            isHemotoxic || wbctUnclotted -> "Hemotoxic Envenomation (Russell's Viper / Green Pit Viper)"
            else -> "Dry Bite / Non-Venomous Bite (No systemic envenomation at present)"
        }

        val vials = if (isNeurotoxic || isHemotoxic || wbctUnclotted || hasSystemicSigns) 10 else 0

        val diluent = if (vials > 0) {
            "Reconstitute 10 vials of Polyvalent ASV (anti-snake venom) in 500 mL Normal Saline (or 10 mL/kg in children). Infuse over 1 hour. Start infusion at slow rate (2 mL/min) for first 10-15 minutes while observing for early anaphylactoid reactions."
        } else {
            "No ASV indicated currently. Keep under strict in-hospital observation for at least 24 hours. Repeat 20-minute Whole Blood Clotting Test (20WBCT) every 4 hours."
        }

        val neostigmine = if (isNeurotoxic) {
            "NEOSTIGMINE 'ATROPINE-FIRST' PROTOCOL (For Neurotoxicity/Ptosis):\n" +
            "1. Pre-medicate with Atropine 0.6 mg IV (children 0.05 mg/kg) to block muscarinic side effects.\n" +
            "2. Follow with Neostigmine 1.5 mg IV/IM (children 0.04 mg/kg).\n" +
            "3. Assess objective improvement (single breath count, inter-palpebral fissure height) at 30 minutes.\n" +
            "4. If positive test: Repeat Neostigmine 0.5 mg IV with Atropine every 30 minutes PRN."
        } else null

        val wbct = "20-MINUTE WHOLE BLOOD CLOTTING TEST (20WBCT):\n" +
                   "Place 2 mL venous blood in clean dry glass test tube. Leave undisturbed for 20 minutes. Invert gently. " +
                   "If blood is liquid / unclotted: Evidence of consumption coagulopathy requiring ASV. Re-test 6 hours post-ASV infusion."

        val adrenaline = "EMERGENCY SAFEGUARD: Always have Epinephrine (Adrenaline) 1:1000 (0.5 mL IM for adults, 0.01 mL/kg for children) drawn up and ready at bedside BEFORE starting ASV infusion to treat immediate anaphylaxis."

        return SnakebiteAsvResult(
            envenomationType = type,
            initialAsvDoseVials = vials,
            diluentGuidance = diluent,
            neostigmineTestProtocol = neostigmine,
            wbct20Guidance = wbct,
            adrenalinePrecaution = adrenaline
        )
    }

    // --- 12. Rabies Post-Exposure Prophylaxis (PEP) Calculator (EDCD Nepal / WHO) ---
    data class RabiesPepResult(
        val categoryText: String,
        val vaccineRegimen: String,
        val vaccineDoseText: String,
        val rigIndication: Boolean,
        val rigDoseIU: Double,
        val rigVolumeMl: Double,
        val woundManagementGuidance: String
    )

    fun calculateRabiesPep(
        weightKg: Double,
        category: Int, // 1: Touch/feed, 2: Scratch/minor no bleed, 3: Transdermal bite/mucosa/blood
        isIntradermal: Boolean = true // Thai Red Cross 2-site ID vs Essen IM
    ): RabiesPepResult {
        val (catText, needsVax, needsRig) = when (category) {
            1 -> Triple("Category I: Touching or feeding animals, licks on intact skin", false, false)
            2 -> Triple("Category II: Minor scratches or abrasions without bleeding, nibbling of uncovered skin", true, false)
            else -> Triple("Category III: Single or multiple transdermal bites or scratches, licks on broken skin, contamination of mucous membrane with saliva", true, true)
        }

        val vaxRegimen = if (!needsVax) {
            "No vaccine or RIG required. Wash exposed site."
        } else if (isIntradermal) {
            "Intradermal Thai Red Cross (2-site ID) Regimen: 0.1 mL injected intradermally at 2 separate anatomical sites (left and right deltoid) on Days 0, 3, 7, and 28."
        } else {
            "Intramuscular Essen (IM) Regimen: 1.0 mL (or 0.5 mL depending on brand) injected IM into anterolateral thigh/deltoid on Days 0, 3, 7, 14, and 28. (NEVER in gluteal region)."
        }

        val vaxDose = if (!needsVax) "0 mL" else if (isIntradermal) "0.1 mL per site (2 sites = 0.2 mL total per visit)" else "1.0 mL IM per visit"

        // RIG: Human RIG (HRIG) 20 IU/kg, Equine RIG (ERIG) 40 IU/kg. ERIG (300 IU/mL) widely used in Nepal
        val rigDoseIU = if (needsRig && weightKg > 0) weightKg * 40.0 else 0.0 // Equine RIG 40 IU/kg
        val rigVolumeMl = if (rigDoseIU > 0) rigDoseIU / 300.0 else 0.0

        val woundCare = "IMMEDIATE WOUND CLEANSING:\n" +
                        "1. Flush and wash all bite wounds and scratches thoroughly with running water and soap/detergent for at least 15 minutes.\n" +
                        "2. Apply Povidone-Iodine 10% solution or 70% alcohol.\n" +
                        "3. SUTURING SHOULD BE AVOIDED. If suture is mandatory, infiltrate RIG locally first and place loose sutures after 2 hours."

        return RabiesPepResult(
            categoryText = catText,
            vaccineRegimen = vaxRegimen,
            vaccineDoseText = vaxDose,
            rigIndication = needsRig,
            rigDoseIU = rigDoseIU,
            rigVolumeMl = rigVolumeMl,
            woundManagementGuidance = woundCare
        )
    }
}
