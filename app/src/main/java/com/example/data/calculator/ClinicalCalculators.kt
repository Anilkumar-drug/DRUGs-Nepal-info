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
}
