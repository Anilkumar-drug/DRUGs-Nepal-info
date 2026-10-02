package com.example.data.calculator

import kotlin.math.exp
import kotlin.math.ln
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Medical Scoring Engine
 * Comprehensive calculation engine and clinical risk stratification
 * covering Gastroenterology, Hepatology, Critical Care, and General Medicine scoring systems.
 */
object MedicalScoringEngine {

    data class ScoreOutput(
        val scoreName: String,
        val category: String,
        val calculatedValue: String,
        val numericScore: Double?,
        val riskTier: String, // "Low", "Moderate", "Severe / High"
        val interpretation: String,
        val clinicalRecommendation: String,
        val status: String = "COMPLETE",
        val missingInputs: List<String> = emptyList()
    ) {
        fun toJsonString(): String {
            val numOrStr = numericScore?.let { "$it" } ?: if (calculatedValue == "N/A" || calculatedValue.isEmpty()) "null" else "\"$calculatedValue\""
            val missingStr = missingInputs.joinToString(separator = ", ", prefix = "[", postfix = "]") { "\"$it\"" }
            val cleanInterp = interpretation.replace("\"", "\\\"").replace("\n", " ").trim()
            val cleanRec = clinicalRecommendation.replace("\"", "\\\"").replace("\n", " ").trim()
            return """
            {
              "score_name": "$scoreName",
              "category": "$category",
              "calculated_value": $numOrStr,
              "status": "$status",
              "missing_inputs": $missingStr,
              "interpretation": "$cleanInterp",
              "risk_tier": "$riskTier",
              "clinical_recommendation": "$cleanRec"
            }
            """.trimIndent()
        }
    }

    // =========================================================================
    // 1. ALCOHOL-ASSOCIATED HEPATITIS
    // =========================================================================

    /**
     * Maddrey's Discriminant Function (mDF)
     * Formula: 4.6 * (Patient PT - Control PT) + Total Bilirubin (mg/dL)
     * Threshold >= 32 denotes severe alcoholic hepatitis.
     */
    fun calculateMaddrey(patientPt: Double, controlPt: Double, totalBilirubinMgDl: Double): ScoreOutput {
        if (patientPt <= 0 || controlPt <= 0 || totalBilirubinMgDl < 0) {
            return ScoreOutput("Maddrey's Discriminant Function (mDF)", "Hepatology", "N/A", null, "Invalid", "Please enter valid PT and Bilirubin values.", "Verify lab parameters.")
        }
        val ptDiff = max(0.0, patientPt - controlPt)
        val mdf = (4.6 * ptDiff) + totalBilirubinMgDl
        val rounded = (mdf * 10.0).roundToInt() / 10.0

        val (tier, interp, rec) = if (rounded >= 32.0) {
            Triple(
                "Severe / High",
                "Severe Alcohol-Associated Hepatitis (mDF >= 32). Associated with 30-50% 1-month mortality without treatment.",
                "First-line candidate for Corticosteroid therapy (Prednisolone 40 mg PO daily for 28 days) unless active infection/GI bleed is present. Assess Day 7 Lille Model response."
            )
        } else {
            Triple(
                "Low",
                "Mild-to-Moderate Alcohol-Associated Hepatitis (mDF < 32). Low 30-day mortality risk.",
                "Corticosteroids are NOT indicated. Focus on supportive care, alcohol cessation therapy, nutritional support (35-40 kcal/kg/day, 1.2-1.5 g/kg protein), and thiamine/micronutrient repletion."
            )
        }
        return ScoreOutput("Maddrey's Discriminant Function", "Hepatology", "$rounded", rounded, tier, interp, rec)
    }

    /**
     * Lille Model for Day 7 Steroid Response
     * Evaluates response at Day 7 of corticosteroid therapy in severe alcohol-associated hepatitis.
     * Score > 0.45 denotes non-response (stop steroids).
     */
    fun calculateLille(
        age: Int,
        albuminGdL: Double,
        creatinineMgDl: Double,
        biliDay0MgDl: Double,
        biliDay7MgDl: Double,
        ptSeconds: Double
    ): ScoreOutput {
        if (age <= 0 || albuminGdL <= 0 || creatinineMgDl <= 0 || biliDay0MgDl <= 0 || biliDay7MgDl < 0 || ptSeconds <= 0) {
            return ScoreOutput("Lille Model (Day 7)", "Hepatology", "N/A", null, "Invalid", "Enter valid baseline and Day 7 parameters.", "Check input values.")
        }
        // Lille formula R = 3.19 - 0.101*age + 0.147*albumin(g/L) + 0.0165*(bili0-bili7) - 0.206*renal - 0.0065*bili0 - 0.0096*pt
        // Using standard international formula:
        val albuminGL = albuminGdL * 10.0
        val bili0Umol = biliDay0MgDl * 17.1
        val bili7Umol = biliDay7MgDl * 17.1
        val renalInsuff = if (creatinineMgDl >= 1.3) 1.0 else 0.0

        val r = 3.19 - (0.101 * age) + (0.147 * albuminGL) + (0.0165 * (bili0Umol - bili7Umol)) - (0.206 * renalInsuff) - (0.0065 * bili0Umol) - (0.0096 * ptSeconds)
        val lille = exp(-r) / (1.0 + exp(-r))
        val rounded = (lille * 1000.0).roundToInt() / 1000.0

        val (tier, interp, rec) = if (rounded > 0.45) {
            Triple(
                "Severe / High",
                "Non-Responder to Corticosteroids (Lille Score > 0.45). Predicted 6-month survival is < 25%. Continuing steroids increases fatal infection risk.",
                "Discontinue corticosteroid therapy immediately to prevent fatal opportunistic infections. Screen for sepsis, consider early liver transplantation evaluation if criteria met, or palliative/supportive care."
            )
        } else {
            Triple(
                "Low",
                "Responder to Corticosteroids (Lille Score <= 0.45). Predicted 6-month survival is approximately 85%.",
                "Continue Prednisolone 40 mg daily to complete a 28-day course, followed by a 2-4 week tapering regimen. Maintain strict alcohol rehabilitation program."
            )
        }
        return ScoreOutput("Lille Model (Day 7 Steroid Response)", "Hepatology", "$rounded", rounded, tier, interp, rec)
    }

    /**
     * ABIC Score (Age, Bilirubin, INR, Creatinine)
     * Risk stratification in alcoholic hepatitis.
     * Low (<6.71), Intermediate (6.71 - 8.99), High (>8.99)
     */
    fun calculateAbic(age: Int, bilirubinMgDl: Double, inr: Double, creatinineMgDl: Double): ScoreOutput {
        val score = (age * 0.1) + (bilirubinMgDl * 0.08) + (inr * 0.3) + (creatinineMgDl * 0.3)
        val rounded = (score * 100.0).roundToInt() / 100.0
        val (tier, interp, rec) = when {
            rounded < 6.71 -> Triple(
                "Low",
                "ABIC Low Risk (< 6.71). 90-day mortality is 10%.",
                "Favorable prognosis. Supportive medical care, nutritional repletion, and alcohol abstinence counseling."
            )
            rounded in 6.71..8.99 -> Triple(
                "Moderate",
                "ABIC Intermediate Risk (6.71 - 8.99). 90-day mortality is approximately 30%.",
                "Consider corticosteroids if mDF >= 32. Close inpatient monitoring for sepsis, hepatorenal syndrome, and encephalopathy."
            )
            else -> Triple(
                "Severe / High",
                "ABIC High Risk (> 8.99). 90-day mortality is approximately 75%.",
                "High risk of early death. Evaluate for intensive care admission, rapid infection screening, and urgent liver transplant assessment."
            )
        }
        return ScoreOutput("ABIC Score", "Hepatology", "$rounded", rounded, tier, interp, rec)
    }

    /**
     * Glasgow Alcoholic Hepatitis Score (GAHS)
     * Age, WBC, Urea, PT/INR, Bilirubin. Score 5 - 12.
     * Score >= 9 identifies patients with high mortality who benefit from corticosteroids.
     */
    fun calculateGahs(age: Int, wbc: Double, ureaMmolL: Double, ptRatioOrInr: Double, bilirubinMgDl: Double): ScoreOutput {
        var points = 0
        points += if (age < 50) 1 else 2
        points += if (wbc < 15.0) 1 else 2
        points += if (ureaMmolL < 5.0) 1 else 2
        points += when {
            ptRatioOrInr < 1.5 -> 1
            ptRatioOrInr <= 2.0 -> 2
            else -> 3
        }
        val biliUmol = bilirubinMgDl * 17.1
        points += when {
            biliUmol < 125.0 -> 1
            biliUmol <= 250.0 -> 2
            else -> 3
        }
        val (tier, interp, rec) = if (points >= 9) {
            Triple(
                "Severe / High",
                "GAHS Score $points (>= 9). Severe disease with 28-day mortality of 40-50% without treatment.",
                "Statistically proven survival benefit from Corticosteroid therapy (Prednisolone 40 mg/day). Reassess with Lille score at Day 7."
            )
        } else {
            Triple(
                "Low",
                "GAHS Score $points (< 9). 28-day mortality is low (~13%).",
                "Corticosteroids show no proven survival advantage in GAHS < 9. Provide nutritional support and monitor."
            )
        }
        return ScoreOutput("Glasgow Alcoholic Hepatitis Score (GAHS)", "Hepatology", "$points / 12", points.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 2. AUTOIMMUNE HEPATITIS (AIH)
    // =========================================================================

    /**
     * Simplified IAIHG Criteria (2008)
     * Points: Autoantibodies (0-2), IgG (0-2), Histology (0-2), Absence of viral hepatitis (0-2).
     * >= 6: Probable AIH; >= 7: Definite AIH.
     */
    fun evaluateSimplifiedAih(
        anaOrSmaTiter: Int, // 0 = neg, 1 = >=1:40, 2 = >=1:80
        lkm1OrSlaPositive: Boolean,
        iggElevated: Int, // 0 = normal, 1 = >ULN, 2 = >1.10x ULN
        histology: Int, // 0 = atypical, 1 = compatible (lymphoplasmacytic), 2 = typical (interface hepatitis, emperipolesis, rosettes)
        absenceOfViralHepatitis: Boolean
    ): ScoreOutput {
        var autoAbScore = when {
            lkm1OrSlaPositive -> 2
            anaOrSmaTiter >= 2 -> 2
            anaOrSmaTiter == 1 -> 1
            else -> 0
        }
        autoAbScore = min(2, autoAbScore)
        val iggScore = min(2, iggElevated)
        val histScore = min(2, histology)
        val viralScore = if (absenceOfViralHepatitis) 2 else 0

        val total = autoAbScore + iggScore + histScore + viralScore
        val (tier, interp, rec) = when {
            total >= 7 -> Triple(
                "Severe / High",
                "Definite Autoimmune Hepatitis (Score $total >= 7, 97% specificity).",
                "Initiate immunosuppression: Prednisolone (30-60 mg/day) with or without Azathioprine (50 mg/day or 1-2 mg/kg/day) upon normalization of TPMT. Goal is complete biochemical remission (normal ALT and IgG)."
            )
            total == 6 -> Triple(
                "Moderate",
                "Probable Autoimmune Hepatitis (Score 6, 88% specificity).",
                "Consider therapeutic trial of corticosteroids if other etiologies (DILI, Wilson, viral) are excluded. Repeat liver biopsy if indeterminate."
            )
            else -> Triple(
                "Low",
                "Autoimmune Hepatitis Unlikely (Score $total < 6).",
                "Criteria not met for AIH. Evaluate for DILI, NASH/MASH, Wilson disease, alpha-1 antitrypsin deficiency, or viral hepatitis."
            )
        }
        return ScoreOutput("Simplified IAIHG Criteria (AIH)", "Hepatology", "$total / 8", total.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 3. WILSON DISEASE
    // =========================================================================

    /**
     * Leipzig Score for Wilson Disease
     * Score >= 4 = Established diagnosis; 3 = Probable; <= 2 = Unlikely.
     */
    fun calculateLeipzigScore(
        kfRingsPresent: Boolean,
        neuroSymptoms: Int, // 0 = none, 1 = mild, 2 = severe (dystonia, dysarthria, tremor)
        coombsNegHemolyticAnemia: Boolean,
        ceruloplasminCategory: Int, // 0 = normal (>0.2 g/L), 1 = 0.1-0.2 g/L, 2 = <0.1 g/L
        urinaryCopperCategory: Int, // 0 = normal, 1 = 1-2x ULN, 2 = >2x ULN
        liverCopperCategory: Int, // 0 = normal (<50 ug/g), 1 = 50-250 ug/g, 2 = >250 ug/g
        atp7bMutations: Int // 0 = none, 1 = on 1 allele, 4 = on both alleles (homozygous/compound het)
    ): ScoreOutput {
        var score = 0
        if (kfRingsPresent) score += 2
        score += min(2, neuroSymptoms)
        if (coombsNegHemolyticAnemia) score += 1
        score += min(2, ceruloplasminCategory)
        score += min(2, urinaryCopperCategory)
        score += min(2, liverCopperCategory)
        score += when (atp7bMutations) {
            4, 2 -> 4
            1 -> 1
            else -> 0
        }

        val (tier, interp, rec) = when {
            score >= 4 -> Triple(
                "Severe / High",
                "Wilson Disease Established / Confirmed (Leipzig Score $score >= 4).",
                "Promptly start copper chelator therapy (D-Penicillamine 250-500 mg QID or Trientine 250-500 mg TID) with Pyridoxine (B6). Zinc acetate can be used for maintenance/asymptomatic. Screen all first-degree relatives."
            )
            score == 3 -> Triple(
                "Moderate",
                "Wilson Disease Probable (Leipzig Score 3). Diagnosis requires further testing.",
                "Perform penicillamine challenge test, hepatic copper quantitation via biopsy, or complete ATP7B gene sequencing before committing to lifelong therapy."
            )
            else -> Triple(
                "Low",
                "Wilson Disease Unlikely (Leipzig Score $score <= 2).",
                "Criteria not met. Re-evaluate alternative etiologies of liver or neurological disease."
            )
        }
        return ScoreOutput("Leipzig Score for Wilson Disease", "Hepatology", "$score", score.toDouble(), tier, interp, rec)
    }

    /**
     * Dhawan Score (Revised King's College Wilson Disease Score)
     * Bilirubin, AST, WBC, INR, Albumin.
     * Score > 11 predicts mortality without urgent liver transplantation.
     */
    fun calculateDhawan(
        bilirubinMgDl: Double,
        astU_L: Double,
        wbcK_uL: Double,
        inr: Double,
        albuminGdL: Double
    ): ScoreOutput {
        var score = 0
        val biliUmol = bilirubinMgDl * 17.1
        score += when {
            biliUmol < 100 -> 0
            biliUmol <= 150 -> 1
            biliUmol <= 200 -> 2
            biliUmol <= 300 -> 3
            else -> 4
        }
        score += when {
            astU_L < 100 -> 0
            astU_L <= 150 -> 1
            astU_L <= 200 -> 2
            astU_L <= 300 -> 3
            else -> 4
        }
        score += when {
            inr < 1.3 -> 0
            inr <= 1.6 -> 1
            inr <= 1.9 -> 2
            inr <= 2.4 -> 3
            else -> 4
        }
        score += when {
            wbcK_uL < 6.7 -> 0
            wbcK_uL <= 9.1 -> 1
            wbcK_uL <= 11.7 -> 2
            wbcK_uL <= 15.5 -> 3
            else -> 4
        }
        score += when {
            albuminGdL >= 4.5 -> 0
            albuminGdL >= 3.8 -> 1
            albuminGdL >= 3.4 -> 2
            albuminGdL >= 2.9 -> 3
            else -> 4
        }

        val (tier, interp, rec) = if (score > 11) {
            Triple(
                "Severe / High",
                "Dhawan Score $score (> 11). Extremely high mortality without emergency liver transplantation (>95%).",
                "Urgent transfer to Liver Transplant ICU. Medical therapy / chelation alone is ineffective; list for emergency liver transplantation (UNOS Status 1A / Super-urgent)."
            )
        } else {
            Triple(
                "Moderate",
                "Dhawan Score $score (<= 11). Potential response to intensive copper chelation and supportive therapy.",
                "Initiate emergency copper chelation with Trientine or Penicillamine. Monitor coagulation and bilirubin daily. Re-score if clinical deterioration occurs."
            )
        }
        return ScoreOutput("Dhawan Score (Revised King's Wilson)", "Hepatology", "$score", score.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 4. HEMOCHROMATOSIS
    // =========================================================================

    fun evaluateHemochromatosis(
        transferrinSatPercent: Double,
        ferritinNgMl: Double,
        isFemale: Boolean,
        hfeMutation: String // "C282Y_HOMOZYGOTE", "C282Y_H63D", "WILD_TYPE"
    ): ScoreOutput {
        val tsatThreshold = if (isFemale) 45.0 else 50.0
        val ferritinThreshold = if (isFemale) 200.0 else 300.0

        val tsatElevated = transferrinSatPercent >= tsatThreshold
        val ferritinElevated = ferritinNgMl >= ferritinThreshold

        val (tier, interp, rec) = when {
            hfeMutation == "C282Y_HOMOZYGOTE" && (tsatElevated || ferritinElevated) -> Triple(
                "Severe / High",
                "Hereditary Hemochromatosis Confirmed (C282Y homozygous with phenotypic iron overload).",
                "Initiate Therapeutic Phlebotomy (500 mL weekly or biweekly) targeting Serum Ferritin 50-100 ng/mL and TSAT < 50%. Screen for cirrhosis with Elastography / FibroScan and evaluate first-degree family members."
            )
            tsatElevated && ferritinElevated -> Triple(
                "Moderate",
                "Phenotypic Iron Overload (Elevated TSAT $transferrinSatPercent% and Ferritin $ferritinNgMl ng/mL).",
                "Order HFE genetic testing (C282Y, H63D). Rule out secondary causes: chronic alcohol use, repeated transfusions, chronic viral hepatitis, or metabolic dysfunction (MASH)."
            )
            else -> Triple(
                "Low",
                "Normal Iron Parameters (TSAT $transferrinSatPercent%, Ferritin $ferritinNgMl ng/mL).",
                "Hemochromatosis phenotype not identified. No therapeutic phlebotomy indicated."
            )
        }
        return ScoreOutput("Hereditary Hemochromatosis Evaluation", "Hepatology", "${transferrinSatPercent}% TSAT", transferrinSatPercent, tier, interp, rec)
    }

    // =========================================================================
    // 5. CROHN'S DISEASE: HARVEY-BRADSHAW INDEX (HBI)
    // =========================================================================

    fun calculateHbi(
        generalWellbeing: Int, // 0 = very well, 1 = slightly below par, 2 = poor, 3 = very poor, 4 = terrible
        abdominalPain: Int, // 0 = none, 1 = mild, 2 = moderate, 3 = severe
        liquidStoolsPerDay: Int,
        abdominalMass: Int, // 0 = none, 1 = dubious, 2 = definite, 3 = tender
        complicationsCount: Int // Arthralgia, uveitis, erythema nodosum, aphthous ulcers, pyoderma, anal fissure/fistula (1 pt each)
    ): ScoreOutput {
        val total = generalWellbeing + abdominalPain + liquidStoolsPerDay + abdominalMass + complicationsCount
        val (tier, interp, rec) = when {
            total < 5 -> Triple(
                "Low",
                "HBI Score $total (< 5): Clinical Remission.",
                "Continue maintenance medical therapy (Biologics / Immunomodulators). Monitor fecal calprotectin every 3-6 months for mucosal healing."
            )
            total in 5..7 -> Triple(
                "Moderate",
                "HBI Score $total (5-7): Mild Crohn's Flare.",
                "Optimize current maintenance regimen. Check fecal calprotectin, CRP, and drug trough levels / anti-drug antibodies."
            )
            total in 8..16 -> Triple(
                "Moderate",
                "HBI Score $total (8-16): Moderate Crohn's Disease Activity.",
                "Consider oral Budesonide (9 mg/day) or Prednisone course. Escalate or switch biologic therapy (anti-TNF, Vedolizumab, Ustekinumab, Risankizumab)."
            )
            else -> Triple(
                "Severe / High",
                "HBI Score $total (> 16): Severe Crohn's Disease Exacerbation.",
                "Inpatient hospital admission recommended. Rule out intra-abdominal abscess/perforation via CT enterography. Consider IV Corticosteroids (Hydrocortisone 100 mg q6h) and early surgical consultation."
            )
        }
        return ScoreOutput("Harvey-Bradshaw Index (HBI)", "Gastroenterology", "$total", total.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 6. ULCERATIVE COLITIS: MAYO SCORE & PARTIAL MAYO
    // =========================================================================

    fun calculatePartialMayo(
        stoolFrequency: Int, // 0 = normal, 1 = 1-2 stools > normal, 2 = 3-4 stools > normal, 3 = >=5 stools > normal
        rectalBleeding: Int, // 0 = none, 1 = streaks, 2 = obvious blood, 3 = mostly blood
        physicianGlobalAssessment: Int // 0 = normal, 1 = mild, 2 = moderate, 3 = severe
    ): ScoreOutput {
        val score = stoolFrequency + rectalBleeding + physicianGlobalAssessment
        val (tier, interp, rec) = when {
            score <= 1 -> Triple(
                "Low",
                "Partial Mayo Score $score (0-1): Clinical Remission.",
                "Maintain maintenance therapy with 5-ASA (Mesalamine) or biologic/small molecule. Routine monitoring."
            )
            score in 2..4 -> Triple(
                "Moderate",
                "Partial Mayo Score $score (2-4): Mild Active Ulcerative Colitis.",
                "Optimize oral 5-ASA (up to 4.8 g/day) plus topical rectal 5-ASA suppository/enema (1 g/day). Consider oral Budesonide MMX 9 mg/day."
            )
            score in 5..7 -> Triple(
                "Moderate",
                "Partial Mayo Score $score (5-7): Moderate Active Ulcerative Colitis.",
                "Initiate oral Prednisone (40 mg/day). If steroid-refractory or dependent, initiate Biologic (Infliximab, Vedolizumab, Ustekinumab) or JAK inhibitor (Tofacitinib, Upadacitinib)."
            )
            else -> Triple(
                "Severe / High",
                "Partial Mayo Score $score (8-9): Severe Active Ulcerative Colitis.",
                "Urgent hospital admission. Initiate IV Methylprednisolone (60 mg/day). Monitor for toxic megacolon. Assess Day 3 Oxford criteria for rescue therapy (Infliximab vs Cyclosporine vs Colectomy)."
            )
        }
        return ScoreOutput("Partial Mayo Score (UC)", "Gastroenterology", "$score / 9", score.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 7. MASLD / MASH: NAFLD FIBROSIS SCORE (NFS)
    // =========================================================================

    fun calculateNafldFibrosisScore(
        age: Int,
        bmi: Double,
        hasDiabetesOrIfg: Boolean,
        astU_L: Double,
        altU_L: Double,
        plateletsK_uL: Double,
        albuminGdL: Double
    ): ScoreOutput {
        if (altU_L <= 0 || plateletsK_uL <= 0 || albuminGdL <= 0) {
            return ScoreOutput("NAFLD Fibrosis Score", "Hepatology", "N/A", null, "Invalid", "Enter valid lab values.", "Verify AST, ALT, Albumin, Platelets.")
        }
        val diabetesVal = if (hasDiabetesOrIfg) 1.0 else 0.0
        val astAltRatio = astU_L / altU_L
        val nfs = -1.675 + (0.037 * age) + (0.094 * bmi) + (1.13 * diabetesVal) + (0.99 * astAltRatio) - (0.013 * plateletsK_uL) - (0.66 * albuminGdL)
        val rounded = (nfs * 1000.0).roundToInt() / 1000.0

        val (tier, interp, rec) = when {
            rounded < -1.455 -> Triple(
                "Low",
                "NFS $rounded (< -1.455): Low Risk of Advanced Fibrosis (F0-F2 excluded, NPV 93%).",
                "Lifestyle interventions, Mediterranean diet, exercise, weight loss of 7-10%, manage metabolic syndrome. Re-screen in 2-3 years."
            )
            rounded in -1.455..0.675 -> Triple(
                "Moderate",
                "NFS $rounded (-1.455 to 0.675): Indeterminate Risk.",
                "Perform secondary non-invasive testing: Transient Elastography (FibroScan / VCTE) or Enhanced Liver Fibrosis (ELF) score."
            )
            else -> Triple(
                "Severe / High",
                "NFS $rounded (> 0.675): High Risk of Advanced Fibrosis (F3-F4, PPV 90%).",
                "Hepatology referral. Perform FibroScan to confirm cirrhosis. Screen for esophageal varices and initiate 6-monthly ultrasound surveillance for HCC."
            )
        }
        return ScoreOutput("NAFLD Fibrosis Score (NFS)", "Hepatology", "$rounded", rounded, tier, interp, rec)
    }

    // =========================================================================
    // 8. ACUTE-ON-CHRONIC LIVER FAILURE (NACSELD-ACLF)
    // =========================================================================

    fun evaluateNacseldAclf(
        shockRequiringVasopressors: Boolean,
        grade3or4HepaticEncephalopathy: Boolean,
        renalReplacementTherapy: Boolean,
        mechanicalVentilation: Boolean
    ): ScoreOutput {
        var organFailures = 0
        if (shockRequiringVasopressors) organFailures++
        if (grade3or4HepaticEncephalopathy) organFailures++
        if (renalReplacementTherapy) organFailures++
        if (mechanicalVentilation) organFailures++

        val (tier, interp, rec) = when {
            organFailures >= 2 -> Triple(
                "Severe / High",
                "NACSELD-ACLF Present ($organFailures Organ Failures >= 2). 30-day mortality exceeds 50-70%.",
                "Emergency ICU admission. Urgent evaluation for emergency liver transplantation if patient is an active transplant candidate. Discuss goals of care if multi-organ failure progresses."
            )
            organFailures == 1 -> Triple(
                "Moderate",
                "Single Organ Failure Present ($organFailures/4). High risk of progression to ACLF.",
                "Intensive step-down / ICU monitoring. Aggressively identify and treat underlying precipitant (infection/SBP, GI bleed, alcohol relapse, nephrotoxins)."
            )
            else -> Triple(
                "Low",
                "No NACSELD Organ Failures (0/4).",
                "Compensated/Decompensated cirrhosis without ACLF. Standard ward-based management."
            )
        }
        return ScoreOutput("NACSELD-ACLF Score", "Hepatology", "$organFailures / 4 Organ Failures", organFailures.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 9. ACUTE LIVER FAILURE: KING'S COLLEGE CRITERIA (KCC)
    // =========================================================================

    fun evaluateKingsCollege(
        isParacetamolInduced: Boolean,
        arterialPhAfterResuscitation: Double,
        inr: Double,
        creatinineMgDl: Double,
        hepaticEncephalopathyGrade: Int, // 1-4
        age: Int,
        jaundiceToEncephalopathyDays: Int,
        bilirubinMgDl: Double
    ): ScoreOutput {
        val criteriaMet = if (isParacetamolInduced) {
            val phCriteria = arterialPhAfterResuscitation < 7.30
            val triadCriteria = inr > 6.5 && creatinineMgDl > 3.4 && hepaticEncephalopathyGrade >= 3
            phCriteria || triadCriteria
        } else {
            val inrSoleCriteria = inr > 6.5
            var minorCount = 0
            if (age < 10 || age > 40) minorCount++
            if (jaundiceToEncephalopathyDays > 7) minorCount++
            if (bilirubinMgDl > 17.5) minorCount++
            if (inr > 3.5) minorCount++
            inrSoleCriteria || (minorCount >= 3)
        }

        val (tier, interp, rec) = if (criteriaMet) {
            Triple(
                "Severe / High",
                "King's College Criteria MET for Urgent Liver Transplantation (Expected mortality >80-90% without transplant).",
                "Immediate listing for Emergency Liver Transplantation (UNOS Status 1A / UK Super-Urgent). Transfer to specialized Liver Transplant Intensive Care Unit. Initiate N-Acetylcysteine infusion and cerebral edema management."
            )
        } else {
            Triple(
                "Moderate",
                "King's College Criteria NOT Currently Met.",
                "Continue intensive critical care support: IV N-Acetylcysteine, close monitoring of INR, lactate, creatinine, and GCS/pupils every 4-6 hours. Re-evaluate criteria continuously."
            )
        }
        val etiology = if (isParacetamolInduced) "Paracetamol" else "Non-Paracetamol"
        return ScoreOutput("King's College Criteria ($etiology)", "Hepatology", if (criteriaMet) "CRITERIA MET" else "NOT MET", if (criteriaMet) 1.0 else 0.0, tier, interp, rec)
    }

    // =========================================================================
    // 10. ACUTE PANCREATITIS: MODIFIED ATLANTA CLASSIFICATION
    // =========================================================================

    fun evaluateModifiedAtlanta(
        transientOrganFailureUnder48h: Boolean,
        persistentOrganFailureOver48h: Boolean,
        localComplications: Boolean // Pseudocyst, acute necrotic collection, walled-off necrosis
    ): ScoreOutput {
        val (tier, interp, rec) = when {
            persistentOrganFailureOver48h -> Triple(
                "Severe / High",
                "Severe Acute Pancreatitis (Persistent organ failure > 48h; mortality up to 30-50%).",
                "Admit directly to ICU. Goal-directed fluid resuscitation with Ringer's Lactate (monitor hematocrit and BUN). Enteral nutrition via nasojejunal or nasogastric tube within 24-72 hours. Avoid prophylactic antibiotics unless infected necrosis is suspected."
            )
            transientOrganFailureUnder48h || localComplications -> Triple(
                "Moderate",
                "Moderately Severe Acute Pancreatitis (Transient organ failure < 48h or local complications).",
                "Step-down / high-dependency unit care. Serial contrast-enhanced CT after 72-96 hours to assess pancreatic necrosis. Early enteral feeding as tolerated."
            )
            else -> Triple(
                "Low",
                "Mild Acute Pancreatitis (No organ failure, no local or systemic complications; mortality < 1%).",
                "General ward care. Early oral refeeding with low-fat solid or liquid diet as soon as pain resolves. If gallstone etiology, perform index admission laparoscopic cholecystectomy."
            )
        }
        return ScoreOutput("Modified Atlanta Classification", "Gastroenterology", tier, null, tier, interp, rec)
    }

    // =========================================================================
    // 11. ACUTE CHOLANGITIS: TOKYO GUIDELINES 2018 (TG18)
    // =========================================================================

    fun evaluateTokyoTg18(
        hasFeverOrChillsOrWbcCrp: Boolean, // Criteria A: Systemic inflammation
        hasJaundiceOrAbnormalLft: Boolean, // Criteria B: Cholestasis
        hasBiliaryDilatationOrEtiologyOnImaging: Boolean, // Criteria C: Imaging
        hasOrganDysfunction: Boolean, // Severe Grade III: Shock, CNS altered, PaO2/FiO2 < 300, Cr > 2.0, INR > 1.5, Plt < 100k
        hasModerateCriteria: Boolean // Grade II: WBC > 12k or < 4k, Temp >= 39°C, Age >= 75, Bili >= 5, Albumin < 0.7x LLN
    ): ScoreOutput {
        val isDefinite = hasFeverOrChillsOrWbcCrp && hasJaundiceOrAbnormalLft && hasBiliaryDilatationOrEtiologyOnImaging
        val isSuspected = (hasFeverOrChillsOrWbcCrp && hasJaundiceOrAbnormalLft) || (hasFeverOrChillsOrWbcCrp && hasBiliaryDilatationOrEtiologyOnImaging)

        val (tier, interp, rec) = when {
            hasOrganDysfunction && isDefinite -> Triple(
                "Severe / High",
                "TG18 Grade III (Severe Acute Cholangitis) with Organ Dysfunction.",
                "EMERGENCY Biliary Drainage via urgent ERCP (or percutaneous transhepatic drainage if ERCP unavailable) within hours. ICU resuscitation, IV broad-spectrum antibiotics (Piperacillin-Tazobactam or Carbapenem)."
            )
            hasModerateCriteria && isDefinite -> Triple(
                "Moderate",
                "TG18 Grade II (Moderate Acute Cholangitis).",
                "Early biliary decompression via ERCP within 24-48 hours. IV broad-spectrum antibiotics and close monitoring for progression to organ failure."
            )
            isDefinite -> Triple(
                "Low",
                "TG18 Grade I (Mild Acute Cholangitis).",
                "Initial medical management: IV antibiotics and hydration. Elective biliary drainage via ERCP if refractory to 24-48 hours of medical therapy."
            )
            isSuspected -> Triple(
                "Moderate",
                "Suspected Acute Cholangitis (Criteria A + B or C).",
                "Urgent diagnostic confirmation via abdominal ultrasound, CT, or MRCP. Initiate empiric IV antibiotics promptly."
            )
            else -> Triple(
                "Low",
                "Tokyo Guidelines criteria for acute cholangitis not met.",
                "Re-evaluate clinical picture and investigate other causes of fever or abdominal pain."
            )
        }
        return ScoreOutput("Tokyo Guidelines 2018 (TG18)", "Hepatology", if (isDefinite) "Definite Cholangitis" else if (isSuspected) "Suspected" else "Negative", null, tier, interp, rec)
    }

    // =========================================================================
    // 12. UPPER GI BLEEDING: GLASGOW-BLATCHFORD SCORE (GBS)
    // =========================================================================

    fun calculateGlasgowBlatchford(
        bunMgDl: Double,
        hemoglobinGdL: Double,
        isFemale: Boolean,
        systolicBp: Int,
        pulseRate: Int,
        hasMelena: Boolean,
        hasSyncope: Boolean,
        hasHepaticDisease: Boolean,
        hasHeartFailure: Boolean
    ): ScoreOutput {
        var score = 0
        score += when {
            bunMgDl >= 70.0 -> 6
            bunMgDl >= 28.0 -> 4
            bunMgDl >= 22.4 -> 3
            bunMgDl >= 18.2 -> 2
            else -> 0
        }
        if (isFemale) {
            score += when {
                hemoglobinGdL < 10.0 -> 6
                hemoglobinGdL <= 11.9 -> 1
                else -> 0
            }
        } else {
            score += when {
                hemoglobinGdL < 10.0 -> 6
                hemoglobinGdL <= 11.9 -> 3
                hemoglobinGdL <= 12.9 -> 1
                else -> 0
            }
        }
        score += when {
            systolicBp < 90 -> 3
            systolicBp in 90..99 -> 2
            systolicBp in 100..109 -> 1
            else -> 0
        }
        if (pulseRate >= 100) score += 1
        if (hasMelena) score += 1
        if (hasSyncope) score += 2
        if (hasHepaticDisease) score += 2
        if (hasHeartFailure) score += 2

        val (tier, interp, rec) = when {
            score <= 1 -> Triple(
                "Low",
                "Glasgow-Blatchford Score $score (0-1): Extremely Low Risk (< 1% intervention or mortality).",
                "Candidate for safe outpatient management without routine urgent inpatient endoscopy. Oral PPI therapy and outpatient GI follow-up."
            )
            score in 2..5 -> Triple(
                "Moderate",
                "Glasgow-Blatchford Score $score (2-5): Moderate Risk.",
                "Inpatient hospital admission. Initiate IV PPI (Pantoprazole 80 mg bolus + 8 mg/hr). Perform endoscopy within 24 hours of admission."
            )
            else -> Triple(
                "Severe / High",
                "Glasgow-Blatchford Score $score (>= 6): High Risk for transfusion, endoscopic intervention, or rebleeding.",
                "Urgent inpatient admission / ICU triage. Active fluid resuscitation, blood transfusion if Hb < 7-8 g/dL, IV Erythromycin prokinetic 30-60 min prior, and Urgent Endoscopy within 12-24 hours."
            )
        }
        return ScoreOutput("Glasgow-Blatchford Score (GBS)", "Gastroenterology", "$score / 23", score.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 13. UPPER GI BLEEDING: AIMS65 SCORE
    // =========================================================================

    fun calculateAims65(
        albuminGdL: Double,
        inr: Double,
        alteredMentalStatus: Boolean,
        systolicBp: Int,
        age: Int
    ): ScoreOutput {
        var score = 0
        if (albuminGdL < 3.0) score++
        if (inr > 1.5) score++
        if (alteredMentalStatus) score++
        if (systolicBp <= 90) score++
        if (age > 65) score++

        val (tier, interp, rec) = when {
            score >= 3 -> Triple(
                "Severe / High",
                "AIMS65 Score $score (>= 3): High Risk of Inpatient Mortality (>10-25%) and ICU Need.",
                "Admit directly to ICU. Rapid resuscitation, airway protection if altered mental status, and urgent endoscopy once hemodynamically stabilized."
            )
            score in 1..2 -> Triple(
                "Moderate",
                "AIMS65 Score $score: Moderate Risk of In-Hospital Mortality (~3%).",
                "Inpatient admission with telemetry monitoring. IV PPI therapy and early endoscopy within 24 hours."
            )
            else -> Triple(
                "Low",
                "AIMS65 Score 0: Low Mortality Risk (< 0.5%).",
                "Favorable prognosis. Perform standard endoscopy and transition to oral PPI."
            )
        }
        return ScoreOutput("AIMS65 Score", "Gastroenterology", "$score / 5", score.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 14. CRITICAL CARE: qSOFA (Quick Sepsis-Related Organ Failure Assessment)
    // =========================================================================

    fun calculateQsofa(
        respiratoryRateGe22: Boolean,
        alteredMentalStatus: Boolean, // GCS < 15
        systolicBpLe100: Boolean
    ): ScoreOutput {
        var score = 0
        if (respiratoryRateGe22) score++
        if (alteredMentalStatus) score++
        if (systolicBpLe100) score++

        val (tier, interp, rec) = if (score >= 2) {
            Triple(
                "Severe / High",
                "qSOFA Score $score (>= 2): High Risk of In-Hospital Mortality and Prolonged ICU Stay.",
                "Screen for septic shock. Calculate full SOFA score, draw blood cultures, obtain serum lactate, and initiate 1-Hour Sepsis Bundle (30 mL/kg crystalloids, broad-spectrum IV antibiotics)."
            )
        } else {
            Triple(
                "Low",
                "qSOFA Score $score (< 2): Low Immediate Risk.",
                "Monitor vitals closely. Re-evaluate if clinical condition changes or signs of infection progress."
            )
        }
        return ScoreOutput("qSOFA Score", "Critical Care", "$score / 3", score.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 15. MELD 3.0 (Model for End-Stage Liver Disease 3.0)
    // =========================================================================

    fun calculateMeld30(
        isFemale: Boolean,
        bilirubinMgDl: Double,
        inr: Double,
        creatinineMgDl: Double,
        sodiumMeqL: Double,
        albuminGdL: Double
    ): ScoreOutput {
        if (bilirubinMgDl <= 0 || inr <= 0 || creatinineMgDl <= 0 || sodiumMeqL <= 0 || albuminGdL <= 0) {
            return ScoreOutput("MELD 3.0", "Hepatology", "N/A", null, "Invalid", "Enter valid lab parameters.", "Check input values.", "INCOMPLETE_INPUTS", listOf("Bilirubin", "INR", "Creatinine", "Sodium", "Albumin"))
        }
        val bili = min(50.0, max(1.0, bilirubinMgDl))
        val inrVal = max(1.0, inr)
        val cr = min(3.0, max(1.0, creatinineMgDl))
        val na = min(137.0, max(125.0, sodiumMeqL))
        val alb = min(3.5, max(1.0, albuminGdL))
        val sexVal = if (isFemale) 1.33 else 0.0

        val meld3 = 1.33 * sexVal +
                4.56 * ln(bili) +
                0.82 * (137.0 - na) -
                0.24 * (137.0 - na) * ln(bili) +
                9.09 * ln(inrVal) +
                11.14 * ln(cr) +
                1.85 * (3.5 - alb) -
                1.83 * (3.5 - alb) * ln(cr) + 6.0
        val rounded = max(6, min(40, (meld3).roundToInt())).toDouble()

        val (tier, interp, rec) = when {
            rounded >= 25.0 -> Triple(
                "Severe / High",
                "MELD 3.0 Score ${rounded.toInt()}: High 90-day waitlist mortality (>50-70%).",
                "High priority listing for deceased donor liver transplantation. Monitor in ICU/stepdown for SBP, HRS, and hepatic encephalopathy."
            )
            rounded in 15.0..24.0 -> Triple(
                "Moderate",
                "MELD 3.0 Score ${rounded.toInt()}: Moderate 90-day waitlist mortality (10-30%).",
                "Active liver transplant candidate evaluation. Manage ascites (spironolactone + furosemide) and screen for esophageal varices."
            )
            else -> Triple(
                "Low",
                "MELD 3.0 Score ${rounded.toInt()}: Low 90-day mortality (< 5%).",
                "Outpatient hepatology follow-up. Ultrasound and AFP surveillance for hepatocellular carcinoma every 6 months."
            )
        }
        return ScoreOutput("MELD 3.0 Score", "Hepatology", "${rounded.toInt()}", rounded, tier, interp, rec)
    }

    // =========================================================================
    // 16. CROHN'S DISEASE: CDAI (Crohn's Disease Activity Index)
    // =========================================================================

    fun calculateCdai(
        liquidStoolsSum7Days: Int,
        abdominalPainSum7Days: Int, // 0-21
        generalWellbeingSum7Days: Int, // 0-28
        extraintestinalSymptomsCount: Int,
        takingOpiatesForDiarrhea: Boolean,
        abdominalMassScore: Int, // 0 = none, 2 = questionable, 5 = definite
        actualHematocrit: Double,
        isFemale: Boolean,
        weightKg: Double,
        standardWeightKg: Double
    ): ScoreOutput {
        val hctBaseline = if (isFemale) 42.0 else 47.0
        val hctDeficit = max(0.0, hctBaseline - actualHematocrit)
        val weightDeviationPct = max(-10.0, ((standardWeightKg - weightKg) / standardWeightKg) * 100.0)

        val cdai = (liquidStoolsSum7Days * 2) +
                (abdominalPainSum7Days * 5) +
                (generalWellbeingSum7Days * 7) +
                (extraintestinalSymptomsCount * 20) +
                (if (takingOpiatesForDiarrhea) 30 else 0) +
                (abdominalMassScore * 10) +
                (hctDeficit * 6.0) +
                (max(0.0, weightDeviationPct) * 1.0)

        val score = (cdai * 10.0).roundToInt() / 10.0
        val (tier, interp, rec) = when {
            score < 150.0 -> Triple(
                "Low",
                "CDAI $score (< 150): Clinical Remission.",
                "Maintain ongoing biologic or immunomodulator therapy. Monitor mucosal healing with fecal calprotectin."
            )
            score in 150.0..219.0 -> Triple(
                "Moderate",
                "CDAI $score (150-219): Mild Active Crohn's Disease.",
                "Oral budesonide 9 mg/day or evaluate therapeutic drug monitoring (trough levels and antibodies)."
            )
            score in 220.0..450.0 -> Triple(
                "Moderate",
                "CDAI $score (220-450): Moderate to Severe Crohn's Disease.",
                "Oral prednisone (40 mg/day taper) or induction/optimization of anti-TNF / anti-IL12/23 biologic therapy."
            )
            else -> Triple(
                "Severe / High",
                "CDAI $score (> 450): Fulminant / Very Severe Crohn's Disease.",
                "Hospitalization, IV corticosteroids (Hydrocortisone 100 mg q6h), rule out bowel perforation/abscess by imaging, early surgical consult."
            )
        }
        return ScoreOutput("CDAI (Crohn's Disease Activity Index)", "Gastroenterology", "$score", score, tier, interp, rec)
    }

    // =========================================================================
    // 17. CROHN'S DISEASE: SES-CD (Simple Endoscopic Score)
    // =========================================================================

    fun calculateSesCd(
        ulcerSizePoints: Int, // 0-3 in 5 segments (total 0-15)
        ulceratedSurfacePoints: Int, // 0-3 in 5 segments (total 0-15)
        affectedSurfacePoints: Int, // 0-3 in 5 segments (total 0-15)
        stenosisPoints: Int // 0-3 in 5 segments (total 0-15)
    ): ScoreOutput {
        val total = ulcerSizePoints + ulceratedSurfacePoints + affectedSurfacePoints + stenosisPoints
        val (tier, interp, rec) = when {
            total in 0..2 -> Triple("Low", "SES-CD $total (0-2): Endoscopic Remission.", "Deep mucosal healing achieved. Maintain therapy.")
            total in 3..6 -> Triple("Moderate", "SES-CD $total (3-6): Mild Endoscopic Activity.", "Monitor calprotectin; consider drug level optimization.")
            total in 7..15 -> Triple("Moderate", "SES-CD $total (7-15): Moderate Endoscopic Activity.", "Biologic escalation or second-line biologic class switch.")
            else -> Triple("Severe / High", "SES-CD $total (> 15): Severe Endoscopic Ulceration.", "Intensive biologic/small molecule treatment, risk of stricture/fistula.")
        }
        return ScoreOutput("SES-CD Endoscopic Score", "Gastroenterology", "$total / 60", total.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 18. ULCERATIVE COLITIS: TRUELOVE & WITTS & UCEIS
    // =========================================================================

    fun evaluateTrueloveWitts(
        stoolsPerDay: Int,
        grossBloodInStool: Boolean,
        tempC: Double,
        pulseRate: Int,
        hemoglobinGdL: Double,
        esrMmHr: Int
    ): ScoreOutput {
        val isSevere = stoolsPerDay >= 6 && grossBloodInStool && (tempC > 37.8 || pulseRate > 90 || hemoglobinGdL < 10.5 || esrMmHr > 30)
        val isMild = stoolsPerDay < 4 && !grossBloodInStool && tempC <= 37.0 && pulseRate <= 80 && hemoglobinGdL >= 12.0 && esrMmHr <= 20

        val (tier, status, interp, rec) = when {
            isSevere -> Quadruple(
                "Severe / High",
                "Severe Acute Colitis",
                "Truelove and Witts: Severe Acute Ulcerative Colitis (>= 6 bloody stools/day with systemic toxicity).",
                "Emergency hospitalization. IV Methylprednisolone 60 mg/day, stool toxin PCR (C. difficile), daily abdominal X-rays (rule out toxic megacolon). Oxford criteria check on Day 3."
            )
            isMild -> Quadruple(
                "Low",
                "Mild Colitis",
                "Truelove and Witts: Mild Ulcerative Colitis.",
                "Outpatient 5-ASA (oral Mesalamine 2.4-4.8 g/day + rectal suppository/enema)."
            )
            else -> Quadruple(
                "Moderate",
                "Moderate Colitis",
                "Truelove and Witts: Moderate Ulcerative Colitis (4-5 stools/day, intermediate symptoms).",
                "Oral Prednisone 40 mg/day taper or escalation to advanced therapy."
            )
        }
        return ScoreOutput("Truelove & Witts Criteria", "Gastroenterology", status, if (isSevere) 3.0 else if (isMild) 1.0 else 2.0, tier, interp, rec)
    }

    fun calculateUceis(
        vascularPattern: Int, // 0 = normal, 1 = patchy loss, 2 = complete loss
        bleeding: Int, // 0 = none, 1 = mucosal, 2 = luminal luminal fluid, 3 = luminal clots
        erosionsAndUlcers: Int // 0 = none, 1 = erosions, 2 = superficial ulcers, 3 = deep ulcers
    ): ScoreOutput {
        val total = vascularPattern + bleeding + erosionsAndUlcers
        val (tier, interp, rec) = when {
            total <= 1 -> Triple("Low", "UCEIS Score $total (0-1): Endoscopic Remission.", "Maintain maintenance therapy.")
            total in 2..4 -> Triple("Moderate", "UCEIS Score $total (2-4): Mild Endoscopic Activity.", "Optimize 5-ASA or topical therapy.")
            total in 5..6 -> Triple("Moderate", "UCEIS Score $total (5-6): Moderate Endoscopic Activity.", "Systemic corticosteroids or initiate biologics.")
            else -> Triple("Severe / High", "UCEIS Score $total (7-8): Severe Colonic Mucosal Damage.", "High failure rate with corticosteroids; predict need for rescue infliximab/cyclosporine or colectomy.")
        }
        return ScoreOutput("UCEIS Endoscopic Index", "Gastroenterology", "$total / 8", total.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 19. MASLD / MASH: NAS SCORE & FAST SCORE
    // =========================================================================

    fun calculateNasScore(
        steatosisScore: Int, // 0 (<5%), 1 (5-33%), 2 (34-66%), 3 (>66%)
        lobularInflammation: Int, // 0 (none), 1 (<2 foci), 2 (2-4 foci), 3 (>4 foci)
        hepatocyteBallooning: Int // 0 (none), 1 (few balloon cells), 2 (many/prominent)
    ): ScoreOutput {
        val total = steatosisScore + lobularInflammation + hepatocyteBallooning
        val (tier, interp, rec) = when {
            total >= 5 -> Triple(
                "Severe / High",
                "NAS Score $total (>= 5): Diagnostic of Active MASH / NASH.",
                "Confirmed active steatohepatitis. Resmetirom (THR-beta agonist) if non-cirrhotic MASH with fibrosis F2-F3, GLP-1 RA / GIP-GLP1 RA for obesity/T2D, intense lifestyle modification."
            )
            total in 3..4 -> Triple(
                "Moderate",
                "NAS Score $total (3-4): Borderline / Equivocal MASH.",
                "Dietary weight loss, exercise, cardiovascular and metabolic risk management. Repeat staging if progression markers increase."
            )
            else -> Triple(
                "Low",
                "NAS Score $total (< 3): Simple Steatosis (MASLD / NAFL), Not MASH.",
                "Low short-term hepatic risk. Focus on lifestyle intervention, metabolic syndrome treatment."
            )
        }
        return ScoreOutput("NAS (NAFLD Activity Score)", "Hepatology", "$total / 8", total.toDouble(), tier, interp, rec)
    }

    fun calculateFastScore(
        lsmKPa: Double,
        capDbM: Double,
        astUL: Double
    ): ScoreOutput {
        if (lsmKPa <= 0 || capDbM <= 0 || astUL <= 0) {
            return ScoreOutput("FAST Score", "Hepatology", "N/A", null, "Invalid", "Enter valid LSM, CAP, and AST.", "Check parameters.", "INCOMPLETE_INPUTS", listOf("LSM (kPa)", "CAP (dB/m)", "AST (U/L)"))
        }
        // FAST = exp(-1.65 + 1.07*ln(LSM) + 2.66e-8 * CAP^3 - 63.3 * AST^-1) / (1 + exp(...))
        val expTerm = -1.65 + (1.07 * ln(lsmKPa)) + (2.66e-8 * capDbM.pow(3)) - (63.3 / astUL)
        val fast = exp(expTerm) / (1.0 + exp(expTerm))
        val rounded = (fast * 100.0).roundToInt() / 100.0

        val (tier, interp, rec) = when {
            rounded < 0.35 -> Triple("Low", "FAST $rounded (< 0.35): Rule-out zone for at-risk MASH (NAS >=4, Fibrosis >=2).", "Low probability of progressive fibrotic MASH. Maintain lifestyle counseling.")
            rounded > 0.67 -> Triple("Severe / High", "FAST $rounded (> 0.67): Rule-in zone for at-risk progressive MASH.", "High probability of active MASH with significant fibrosis. Evaluate for pharmacotherapy (Resmetirom, GLP-1) and clinical trials.")
            else -> Triple("Moderate", "FAST $rounded (0.35 - 0.67): Indeterminate Gray Zone.", "Secondary non-invasive test: ELF score, MRE, or liver biopsy.")
        }
        return ScoreOutput("FAST Score (FibroScan-AST)", "Hepatology", "$rounded", rounded, tier, interp, rec)
    }

    // =========================================================================
    // 20. ACLF: CLIF-C ACLF & CLIF-SOFA
    // =========================================================================

    fun calculateClifCAclf(
        clifSofaOrganFailuresCount: Int,
        age: Int,
        wbcK_uL: Double
    ): ScoreOutput {
        val wbcVal = max(1.0, wbcK_uL)
        val clifScore = (10.0 * (0.33 * clifSofaOrganFailuresCount + 0.04 * age + 0.63 * ln(wbcVal) - 2.0)) + 30.0
        val rounded = (clifScore * 10.0).roundToInt() / 10.0
        val (tier, interp, rec) = when {
            rounded >= 70.0 -> Triple(
                "Severe / High",
                "CLIF-C ACLF $rounded (>= 70): Extremely High 28-day mortality (>80%).",
                "Urgent multidisciplinary ICU evaluation. Consider palliative discussion or emergency liver transplant evaluation if feasible."
            )
            rounded in 64.0..69.9 -> Triple(
                "Severe / High",
                "CLIF-C ACLF $rounded (64-69): High 28-day mortality (~50-60%).",
                "ICU care, invasive monitoring, targeted treatment of sepsis and organ support."
            )
            rounded in 46.0..63.9 -> Triple(
                "Moderate",
                "CLIF-C ACLF $rounded (46-63): Moderate 28-day mortality (~30%).",
                "Intensive ward/stepdown management, early antimicrobial therapy."
            )
            else -> Triple(
                "Low",
                "CLIF-C ACLF $rounded (<= 45): Low 28-day mortality (< 15%).",
                "Favorable short-term trajectory. Monitor closely for secondary infections."
            )
        }
        return ScoreOutput("CLIF-C ACLF Score", "Hepatology", "$rounded", rounded, tier, interp, rec)
    }

    // =========================================================================
    // 21. ALF: ALFSG & CLICHY CRITERIA
    // =========================================================================

    fun evaluateAlfsgClichy(
        factorVPercent: Double,
        age: Int,
        hepaticEncephalopathyGrade: Int
    ): ScoreOutput {
        // Clichy: Factor V < 20% in patients < 30 years, or Factor V < 30% in patients >= 30 years with confusion/coma
        val meetsClichy = if (age < 30) factorVPercent < 20.0 else (factorVPercent < 30.0 && hepaticEncephalopathyGrade >= 3)
        val (tier, interp, rec) = if (meetsClichy) {
            Triple(
                "Severe / High",
                "Clichy Criteria MET for Acute Liver Failure (Severe factor V depletion).",
                "High probability of non-survival without emergency liver transplantation (>80-90%). Immediately list for super-urgent liver transplant."
            )
        } else {
            Triple(
                "Moderate",
                "Clichy Criteria NOT Met (Factor V $factorVPercent%).",
                "Continue ICU medical support, N-acetylcysteine, continuous venovenous hemodialysis if hyperammonemia > 150 umol/L. Re-evaluate Factor V every 12 hours."
            )
        }
        return ScoreOutput("Clichy Criteria for ALF", "Hepatology", if (meetsClichy) "TRANSPLANT INDICATED" else "NOT MET", if (meetsClichy) 1.0 else 0.0, tier, interp, rec)
    }

    // =========================================================================
    // 22. PANCREATITIS: APACHE II & CTSI (BALTHAZAR)
    // =========================================================================

    fun calculateApacheII(
        acutePhysiologyPoints: Int,
        agePoints: Int,
        chronicHealthPoints: Int
    ): ScoreOutput {
        val total = acutePhysiologyPoints + agePoints + chronicHealthPoints
        val (tier, interp, rec) = when {
            total >= 15 -> Triple("Severe / High", "APACHE II Score $total (>= 15): Severe Pancreatitis (Expected mortality 25-50%).", "Direct ICU admission. Aggressive monitoring for multiple organ dysfunction syndrome.")
            total in 8..14 -> Triple("Moderate", "APACHE II Score $total (8-14): Moderately Severe Pancreatitis.", "High dependency unit admission, goal-directed fluid resuscitation.")
            else -> Triple("Low", "APACHE II Score $total (< 8): Mild Acute Pancreatitis (Mortality < 4%).", "Ward care with early enteral feeding.")
        }
        return ScoreOutput("APACHE II Score", "Critical Care", "$total", total.toDouble(), tier, interp, rec)
    }

    fun calculateCtsiBalthazar(
        balthazarGradePoints: Int, // A=0, B=1, C=2, D=3, E=4
        necrosisPoints: Int // None=0, <30%=2, 30-50%=4, >50%=6
    ): ScoreOutput {
        val total = balthazarGradePoints + necrosisPoints
        val (tier, interp, rec) = when {
            total in 7..10 -> Triple("Severe / High", "CTSI Score $total (7-10): Severe Necrotizing Pancreatitis (Mortality 17%, Complications 92%).", "ICU monitoring. If clinical deterioration with fever/leukocytosis, suspect infected necrosis (step-up approach: antibiotics -> percutaneous drainage -> minimally invasive necrosectomy).")
            total in 4..6 -> Triple("Moderate", "CTSI Score $total (4-6): Moderate Severity Pancreatitis.", "Monitor for peripancreatic fluid collections and pseudocysts.")
            else -> Triple("Low", "CTSI Score $total (0-3): Mild Acute Pancreatitis (Mortality 3%, Complications 8%).", "Supportive care.")
        }
        return ScoreOutput("CTSI (Balthazar CT Severity Index)", "Gastroenterology", "$total / 10", total.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 23. UPPER GI BLEEDING: FORREST CLASSIFICATION
    // =========================================================================

    fun evaluateForrest(grade: String): ScoreOutput {
        val (tier, interp, rec) = when (grade) {
            "Ia" -> Triple("Severe / High", "Forrest Ia: Spurred Arterial Bleeding (Rebleeding risk ~90%).", "Emergency endoscopic dual therapy (Epinephrine injection + Hemoclip / Thermal coagulation) + IV high-dose PPI infusion.")
            "Ib" -> Triple("Severe / High", "Forrest Ib: Oozing Bleeding (Rebleeding risk 60-80%).", "Endoscopic hemostasis (clips, bipolar electrocoagulation, or hemostatic powder) + IV high-dose PPI.")
            "IIa" -> Triple("Severe / High", "Forrest IIa: Non-bleeding Visible Vessel (Rebleeding risk ~50%).", "Endoscopic therapy indicated (Mechanical clips preferred) + IV PPI.")
            "IIb" -> Triple("Moderate", "Forrest IIb: Adherent Clot (Rebleeding risk 25-30%).", "Consider targeted washing to dislodge clot; if removed and underlying stigmata found, treat endoscopically. IV PPI.")
            "IIc" -> Triple("Low", "Forrest IIc: Flat Pigmented Spot (Rebleeding risk 7-10%).", "No endoscopic intervention required. Oral high-dose PPI.")
            else -> Triple("Low", "Forrest III: Clean Base Ulcer (Rebleeding risk < 3-5%).", "No endoscopic therapy indicated. Standard oral PPI, safe for early hospital discharge.")
        }
        return ScoreOutput("Forrest Classification", "Gastroenterology", grade, null, tier, interp, rec)
    }

    // =========================================================================
    // 24. CARDIOLOGY: TIMI & GRACE
    // =========================================================================

    fun calculateTimiScore(criteriaCount: Int): ScoreOutput {
        val score = min(7, max(0, criteriaCount))
        val (tier, interp, rec) = when {
            score >= 5 -> Triple("Severe / High", "TIMI Score $score (5-7): High Risk for 14-day Death, MI, or Severe Recurrent Ischemia (26-41%).", "Early invasive strategy: Urgent diagnostic coronary angiography within 24 hours. Dual antiplatelet therapy (Aspirin + Ticagrelor/Prasugrel) + Therapeutic Anticoagulation (Heparin).")
            score in 3..4 -> Triple("Moderate", "TIMI Score $score (3-4): Intermediate Risk (13-20%).", "Invasive strategy recommended within 24-72 hours. Telemetry monitoring, high-intensity statin.")
            else -> Triple("Low", "TIMI Score $score (0-2): Low Risk (< 5-8%).", "Conservative medical therapy or predischarge non-invasive stress testing if clinically stable.")
        }
        return ScoreOutput("TIMI Risk Score (UA/NSTEMI)", "Cardiology", "$score / 7", score.toDouble(), tier, interp, rec)
    }

    fun calculateGraceScore(scoreValue: Int): ScoreOutput {
        val (tier, interp, rec) = when {
            scoreValue > 140 -> Triple("Severe / High", "GRACE Score $scoreValue (> 140): High In-Hospital Mortality Risk (> 3%).", "Early invasive coronary angiography (< 24 hours). Continuous telemetry and intensive care triage.")
            scoreValue in 109..140 -> Triple("Moderate", "GRACE Score $scoreValue (109-140): Intermediate Mortality Risk (1-3%).", "Invasive evaluation within 72 hours.")
            else -> Triple("Low", "GRACE Score $scoreValue (< 109): Low In-Hospital Mortality Risk (< 1%).", "Selective non-invasive ischemia testing.")
        }
        return ScoreOutput("GRACE Risk Score", "Cardiology", "$scoreValue", scoreValue.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 25. PULMONOLOGY: PSI / PORT & PERC RULE
    // =========================================================================

    fun calculatePsiPort(totalPoints: Int): ScoreOutput {
        val (tier, cl, interp, rec) = when {
            totalPoints <= 70 -> Quadruple("Low", "Class II", "PSI / PORT Score $totalPoints (Class II): Low Mortality (0.6%).", "Outpatient management safe. Oral antibiotics (Amoxicillin/Clavulanate or Azithromycin/Doxycycline).")
            totalPoints in 71..90 -> Quadruple("Moderate", "Class III", "PSI / PORT Score $totalPoints (Class III): Low-to-Moderate Mortality (0.9-2.8%).", "Short-stay inpatient or observation unit.")
            totalPoints in 91..130 -> Quadruple("Severe / High", "Class IV", "PSI / PORT Score $totalPoints (Class IV): High Mortality (8-9%).", "Inpatient hospital admission. IV empiric antibiotics (Ceftriaxone + Macrolide).")
            else -> Quadruple("Severe / High", "Class V", "PSI / PORT Score $totalPoints (Class V): Very High Mortality (up to 30%).", "Direct ICU admission. Mechanical ventilation / vasopressor support if needed.")
        }
        return ScoreOutput("PSI / PORT Pneumonia Score", "Pulmonology", "$cl ($totalPoints pts)", totalPoints.toDouble(), tier, interp, rec)
    }

    fun evaluatePercRule(criteriaCount: Int): ScoreOutput {
        val ruleOut = criteriaCount == 0
        val (tier, interp, rec) = if (ruleOut) {
            Triple(
                "Low",
                "PERC Rule Negative (0 criteria met). Very low risk (< 1.8% PE probability).",
                "Pulmonary embolism is ruled out. No D-dimer or CT Pulmonary Angiogram needed."
            )
        } else {
            Triple(
                "Moderate",
                "PERC Rule Positive ($criteriaCount criteria met). PERC cannot rule out PE.",
                "Proceed with risk stratification: Calculate Wells' PE Score. If low/intermediate risk, check high-sensitivity D-dimer."
            )
        }
        return ScoreOutput("PERC Rule for PE", "Pulmonology", if (ruleOut) "PERC NEGATIVE" else "PERC POSITIVE", criteriaCount.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 26. NEPHROLOGY: KDIGO AKI STAGING
    // =========================================================================

    fun evaluateKdigoAki(
        baselineCr: Double,
        currentCr: Double,
        urineOutputMlKgHr: Double,
        urineOutputHours: Double
    ): ScoreOutput {
        val crRatio = if (baselineCr > 0) currentCr / baselineCr else 1.0
        val crDelta = currentCr - baselineCr

        val stage = when {
            crRatio >= 3.0 || currentCr >= 4.0 || (urineOutputMlKgHr < 0.3 && urineOutputHours >= 24) || (urineOutputHours >= 12 && urineOutputMlKgHr == 0.0) -> 3
            crRatio >= 2.0 || (urineOutputMlKgHr < 0.5 && urineOutputHours >= 12) -> 2
            crRatio >= 1.5 || crDelta >= 0.3 || (urineOutputMlKgHr < 0.5 && urineOutputHours >= 6) -> 1
            else -> 0
        }

        val (tier, interp, rec) = when (stage) {
            3 -> Triple("Severe / High", "KDIGO Stage 3 AKI (Severe acute kidney injury; Cr >= 3x baseline or Cr >= 4.0 mg/dL).", "Urgent Nephrology consult. Discontinue all nephrotoxins (NSAIDs, ACEi/ARBs, Aminoglycosides). Evaluate indications for urgent Renal Replacement Therapy (AEIOU: Acidosis, Electrolytes/K, Ingestion, Overload, Uremia).")
            2 -> Triple("Moderate", "KDIGO Stage 2 AKI (Cr 2.0 - 2.9x baseline).", "Discontinue nephrotoxins, adjust drug dosing based on residual GFR, maintain euvolemia with isotonic fluids.")
            1 -> Triple("Low", "KDIGO Stage 1 AKI (Cr 1.5 - 1.9x baseline or >= 0.3 mg/dL rise).", "Optimize hemodynamic status, review medication list, repeat serum creatinine in 24-48 hours.")
            else -> Triple("Low", "No AKI Criteria Met (KDIGO Stage 0).", "Normal kidney function based on reported parameters.")
        }
        return ScoreOutput("KDIGO AKI Staging", "Nephrology & Dosing", if (stage > 0) "Stage $stage AKI" else "No AKI", stage.toDouble(), tier, interp, rec)
    }

    // =========================================================================
    // 27. CRITICAL CARE: SOFA SCORE
    // =========================================================================

    fun calculateSofaScore(points: Int): ScoreOutput {
        val score = min(24, max(0, points))
        val (tier, interp, rec) = when {
            score >= 12 -> Triple("Severe / High", "SOFA Score $score (>= 12): Severe Multi-Organ Failure (Predicted mortality > 50-80%).", "Intensive care resuscitation. Invasive mechanical ventilation, arterial line, central venous access, broad-spectrum antibiotics and vasopressors.")
            score in 6..11 -> Triple("Severe / High", "SOFA Score $score (6-11): Significant Organ Dysfunction (Mortality 20-40%).", "ICU admission. Identify and treat underlying cause.")
            score in 2..5 -> Triple("Moderate", "SOFA Score $score (2-5): Sepsis Criteria Met (Mortality 5-15%).", "1-Hour Sepsis Bundle: blood cultures, empiric IV antibiotics, crystalloid fluids, monitor lactate.")
            else -> Triple("Low", "SOFA Score $score (< 2): Low Risk of Organ Failure.", "Close observation on acute medical ward.")
        }
        return ScoreOutput("SOFA Score (Sequential Organ Failure)", "Critical Care", "$score / 24", score.toDouble(), tier, interp, rec)
    }
}
private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
