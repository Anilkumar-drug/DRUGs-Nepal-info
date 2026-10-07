package com.example.data.calculator

import kotlin.math.ln
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

object ExtendedCalculators {

    // 1. CKD-EPI 2021 Equation for GFR (Race-free KDIGO standard)
    data class CkdEpiResult(
        val egfr: Double,
        val stage: String,
        val interpretation: String
    )

    fun calculateCkdEpi(age: Int, serumCr: Double, isFemale: Boolean): CkdEpiResult {
        if (age <= 0 || serumCr <= 0) {
            return CkdEpiResult(0.0, "Invalid Inputs", "Enter valid age and serum creatinine.")
        }
        val kappa = if (isFemale) 0.7 else 0.9
        val alpha = if (isFemale) -0.241 else -0.302
        val genderFactor = if (isFemale) 1.012 else 1.0

        val crRatio = serumCr / kappa
        val minPart = min(crRatio, 1.0).pow(alpha)
        val maxPart = max(crRatio, 1.0).pow(-1.200)
        val agePart = 0.9938.pow(age.toDouble())

        val egfr = 142.0 * minPart * maxPart * agePart * genderFactor
        val rounded = (egfr * 10.0).toInt() / 10.0

        val (stage, note) = when {
            rounded >= 90.0 -> "G1: Normal or High (>90 mL/min/1.73m²)" to "Normal kidney function. Routine monitoring."
            rounded >= 60.0 -> "G2: Mildly Decreased (60-89 mL/min/1.73m²)" to "Monitor annual eGFR and urine albumin-to-creatinine ratio (ACR)."
            rounded >= 45.0 -> "G3a: Mild-to-Moderate (45-59 mL/min/1.73m²)" to "Evaluate CKD progression, dose adjust renally cleared medications (e.g. Metformin)."
            rounded >= 30.0 -> "G3b: Moderate-to-Severe (30-44 mL/min/1.73m²)" to "Nephrology consultation recommended; avoid NSAIDs and nephrotoxins."
            rounded >= 15.0 -> "G4: Severely Decreased (15-29 mL/min/1.73m²)" to "Prepare for renal replacement therapy; strict organ dose titration."
            else -> "G5: Kidney Failure (<15 mL/min/1.73m²)" to "End-stage renal disease; dialysis or renal transplant evaluation."
        }
        return CkdEpiResult(rounded, stage, note)
    }

    // 2. FENa - Fractional Excretion of Sodium
    data class FenaResult(
        val fenaPercent: Double,
        val etiology: String,
        val clinicalAction: String
    )

    fun calculateFena(urineNa: Double, serumNa: Double, urineCr: Double, serumCr: Double): FenaResult {
        if (serumNa <= 0 || urineCr <= 0 || urineNa < 0 || serumCr <= 0) {
            return FenaResult(0.0, "Invalid Inputs", "Enter valid positive values for electrolytes and creatinine.")
        }
        val fena = ((urineNa * serumCr) / (serumNa * urineCr)) * 100.0
        val rounded = (fena * 100.0).toInt() / 100.0

        val (etiology, action) = when {
            rounded < 1.0 -> "Prerenal Azotemia (< 1.0%)" to "Intact tubular sodium reabsorption. Highly suggestive of volume depletion, sepsis, or heart failure. Responsive to fluid resuscitation (unless volume overloaded)."
            rounded in 1.0..2.0 -> "Indeterminate Zone (1.0 - 2.0%)" to "May represent early ATN, acute glomerulonephritis, or diuretic effect (use FEUrea if on loop diuretics)."
            else -> "Intrinsic AKI / Acute Tubular Necrosis (> 2.0%)" to "Impaired tubular reabsorption. Suggestive of ATN (ischemic or nephrotoxic), acute interstitial nephritis, or post-renal obstruction."
        }
        return FenaResult(rounded, etiology, action)
    }

    // 3. Free Water Deficit in Hypernatremia
    data class FreeWaterResult(
        val deficitLiters: Double,
        val correctionRateGuidance: String
    )

    fun calculateFreeWaterDeficit(serumNa: Double, weightKg: Double, isFemale: Boolean, isElderly: Boolean): FreeWaterResult {
        if (serumNa <= 140.0 || weightKg <= 0) {
            return FreeWaterResult(0.0, "Serum sodium is normal or low (<= 140 mEq/L). Free water deficit not present.")
        }
        val tbwFactor = when {
            isElderly && isFemale -> 0.45
            isElderly && !isFemale -> 0.50
            isFemale -> 0.50
            else -> 0.60
        }
        val tbw = weightKg * tbwFactor
        val deficit = tbw * ((serumNa / 140.0) - 1.0)
        val rounded = (deficit * 10.0).toInt() / 10.0

        val guidance = "Replace deficit over 48 to 72 hours using 5% Dextrose (D5W) or 0.45% Saline. " +
                "Maximum safe correction rate is 0.5 mEq/L/hour (max 10-12 mEq/L per 24 hours) to prevent fatal cerebral edema."
        return FreeWaterResult(rounded, guidance)
    }

    // 4. Maintenance Fluids (Holliday-Segar 4-2-1 Rule)
    data class MaintenanceFluidsResult(
        val hourlyRateMl: Double,
        val dailyRateMl: Double,
        val guidance: String
    )

    fun calculateMaintenanceFluids(weightKg: Double): MaintenanceFluidsResult {
        if (weightKg <= 0) return MaintenanceFluidsResult(0.0, 0.0, "Enter valid weight.")
        val hourly = when {
            weightKg <= 10.0 -> weightKg * 4.0
            weightKg <= 20.0 -> 40.0 + ((weightKg - 10.0) * 2.0)
            else -> 60.0 + ((weightKg - 20.0) * 1.0)
        }
        val daily = hourly * 24.0
        val guidance = "Standard maintenance: D5 0.45% NaCl + 20 mEq KCl/L. Adjust for active fluid losses (vomiting, diarrhea, stoma) or oliguria/heart failure."
        return MaintenanceFluidsResult(hourly, daily, guidance)
    }

    // 5. Sodium Correction for Hyperglycemia
    data class SodiumCorrResult(
        val correctedNa: Double,
        val diff: Double,
        val guidance: String
    )

    fun calculateSodiumCorrection(measuredNa: Double, glucoseMgDl: Double): SodiumCorrResult {
        if (measuredNa <= 0 || glucoseMgDl <= 0) return SodiumCorrResult(0.0, 0.0, "Enter valid values.")
        val excessGlucose = max(0.0, glucoseMgDl - 100.0)
        val corr = measuredNa + (0.016 * excessGlucose) // Katz formula
        val rounded = (corr * 10.0).toInt() / 10.0
        val diff = (rounded - measuredNa)

        val note = if (glucoseMgDl > 400.0) {
            "Severe hyperglycemia (>400 mg/dL). True serum sodium is $rounded mEq/L. Guide fluid selection (Normal Saline vs 0.45% NaCl in DKA) based on corrected sodium."
        } else {
            "Corrected sodium reflects osmotic fluid shifting. Use corrected Na ($rounded mEq/L) to evaluate true body sodium stores."
        }
        return SodiumCorrResult(rounded, diff, note)
    }

    // 6. Calcium Correction for Albumin (Payne formula)
    data class CalciumCorrResult(
        val correctedCa: Double,
        val category: String,
        val guidance: String
    )

    fun calculateCalciumCorrection(measuredCa: Double, albuminGDl: Double): CalciumCorrResult {
        if (measuredCa <= 0 || albuminGDl <= 0) return CalciumCorrResult(0.0, "Invalid Inputs", "Enter valid calcium and albumin.")
        val corr = measuredCa + (0.8 * (4.0 - albuminGDl))
        val rounded = (corr * 10.0).toInt() / 10.0

        val (cat, note) = when {
            rounded < 8.5 -> "Hypocalcemia (< 8.5 mg/dL)" to "Check ionized calcium, magnesium, and PTH. Evaluate for Chvostek / Trousseau signs. Give Calcium Gluconate IV if symptomatic."
            rounded in 8.5..10.5 -> "Normal Calcium (8.5 - 10.5 mg/dL)" to "True total calcium is within normal physiological limits."
            rounded in 10.6..12.0 -> "Mild Hypercalcemia (10.6 - 12.0 mg/dL)" to "Hydration with 0.9% Normal Saline. Check PTH and 25-OH Vitamin D."
            rounded in 12.1..14.0 -> "Moderate Hypercalcemia (12.1 - 14.0 mg/dL)" to "IV fluid resuscitation (200-300 mL/hr) + consider IV bisphosphonates (Zoledronic Acid 4mg)."
            else -> "Hypercalcemic Crisis (> 14.0 mg/dL)" to "MEDICAL EMERGENCY. Urgent aggressive IV hydration, Calcitonin, IV bisphosphonate, and hemodialysis if refractory."
        }
        return CalciumCorrResult(rounded, cat, note)
    }

    // 7. MELD-Na Score (UNOS / OPTN)
    data class MeldNaResult(
        val score: Int,
        val ninetyDayMortality: String,
        val guidance: String
    )

    fun calculateMeldNa(bilirubinMgDl: Double, inrVal: Double, crMgDl: Double, naVal: Double, onDialysis: Boolean): MeldNaResult {
        if (bilirubinMgDl <= 0 || inrVal <= 0 || crMgDl <= 0) return MeldNaResult(0, "Invalid", "Enter valid laboratory values.")
        val bili = max(1.0, bilirubinMgDl)
        val inr = max(1.0, inrVal)
        val cr = if (onDialysis) 4.0 else max(1.0, min(4.0, crMgDl))
        val na = max(125.0, min(137.0, naVal))

        val meldRaw = (9.57 * ln(cr)) + (3.78 * ln(bili)) + (11.2 * ln(inr)) + 6.43
        val meldInitial = (meldRaw * 10.0).toInt() / 10.0

        val meldNa = if (meldInitial > 11.0) {
            meldInitial + 1.32 * (137.0 - na) - (0.033 * meldInitial * (137.0 - na))
        } else {
            meldInitial
        }
        val finalScore = meldNa.toInt().coerceIn(6, 40)

        val (mortality, guide) = when {
            finalScore < 10 -> "1.9% 90-day mortality" to "Low mortality risk. Continue routine hepatology outpatient monitoring."
            finalScore in 10..19 -> "6.0% 90-day mortality" to "Moderate severity. Evaluate for transplant listing and monitor for varices and ascites."
            finalScore in 20..29 -> "19.6% 90-day mortality" to "High risk. Active liver transplant candidate; monitor for SBP and hepatorenal syndrome."
            finalScore in 30..39 -> "52.6% 90-day mortality" to "Very high risk. Urgent inpatient transplant prioritization; ICU readiness."
            else -> "71.3% 90-day mortality" to "Critical decompensation. Immediate liver transplantation or intensive organ support."
        }
        return MeldNaResult(finalScore, mortality, guide)
    }

    // 8. FIB-4 Index for Liver Fibrosis
    data class Fib4Result(
        val score: Double,
        val fibrosisStage: String,
        val recommendation: String
    )

    fun calculateFib4(age: Int, ast: Double, alt: Double, platelets: Double): Fib4Result {
        if (age <= 0 || ast <= 0 || alt <= 0 || platelets <= 0) return Fib4Result(0.0, "Invalid", "Enter valid parameters.")
        val fib4 = (age * ast) / (platelets * sqrt(alt))
        val rounded = (fib4 * 100.0).toInt() / 100.0

        val (stage, rec) = when {
            rounded < 1.30 -> "F0 - F1 (Low Risk / Advanced Fibrosis Excluded)" to "Negative predictive value > 90%. Annual primary care follow-up; lifestyle and weight management."
            rounded in 1.30..2.67 -> "Indeterminate / Intermediate Risk" to "Secondary testing indicated: Transient elastography (FibroScan) or ELF test."
            else -> "F3 - F4 (High Risk / Advanced Fibrosis or Cirrhosis Likely)" to "Hepatology referral indicated. Screen for gastroesophageal varices and HCC surveillance (ultrasound q6m)."
        }
        return Fib4Result(rounded, stage, rec)
    }

    // 9. APRI (AST to Platelet Ratio Index)
    data class ApriResult(
        val apriScore: Double,
        val interpretation: String
    )

    fun calculateApri(ast: Double, astUln: Double, platelets: Double): ApriResult {
        if (ast <= 0 || astUln <= 0 || platelets <= 0) return ApriResult(0.0, "Enter valid AST and platelet count.")
        val apri = ((ast / astUln) * 100.0) / platelets
        val rounded = (apri * 100.0).toInt() / 100.0
        val note = when {
            rounded < 0.5 -> "APRI < 0.5: Significant fibrosis and cirrhosis are unlikely (NPV ~85%)."
            rounded in 0.5..1.5 -> "APRI 0.5 - 1.5: Indeterminate. Consider elastography or liver biopsy."
            else -> "APRI > 1.5: High probability of significant fibrosis (F2-F4) or cirrhosis (PPV ~80%). Hepatology consult."
        }
        return ApriResult(rounded, note)
    }

    // 10. R Factor for Liver Injury (DILI)
    data class RFactorResult(
        val rScore: Double,
        val pattern: String,
        val typicalOffenders: String
    )

    fun calculateRFactor(alt: Double, altUln: Double, alp: Double, alpUln: Double): RFactorResult {
        if (alt <= 0 || altUln <= 0 || alp <= 0 || alpUln <= 0) return RFactorResult(0.0, "Invalid", "Enter valid transaminases and ULN.")
        val altRatio = alt / altUln
        val alpRatio = alp / alpUln
        val r = altRatio / alpRatio
        val rounded = (r * 10.0).toInt() / 10.0

        val (pattern, offenders) = when {
            rounded >= 5.0 -> "Hepatocellular Liver Injury (R >= 5.0)" to "Common agents: Paracetamol, Isoniazid, Rifampicin, NSAIDs, Statins, Allopurinol. High transaminase elevations."
            rounded in 2.0..5.0 -> "Mixed Liver Injury (R = 2.0 - 5.0)" to "Common agents: Amoxicillin-Clavulanate, Phenytoin, Sulfasalazine, Carbamazepine."
            else -> "Cholestatic Liver Injury (R <= 2.0)" to "Common agents: Amoxicillin-Clavulanate (delayed onset), Erythromycin, Anabolic steroids, OCPs, Chlorpromazine."
        }
        return RFactorResult(rounded, pattern, offenders)
    }

    // 11. Maddrey's Discriminant Function (Alcoholic Hepatitis)
    data class MaddreyResult(
        val score: Double,
        val isSevere: Boolean,
        val therapyRecommendation: String
    )

    fun calculateMaddrey(patientPt: Double, controlPt: Double, totalBilirubin: Double): MaddreyResult {
        if (patientPt <= 0 || controlPt <= 0 || totalBilirubin <= 0) return MaddreyResult(0.0, false, "Enter valid PT and Bilirubin.")
        val df = (4.6 * (patientPt - controlPt)) + totalBilirubin
        val rounded = (df * 10.0).toInt() / 10.0
        val isSevere = rounded >= 32.0

        val rec = if (isSevere) {
            "SEVERE Alcoholic Hepatitis (DF >= 32): 1-month mortality ~35-50%. Corticosteroid therapy indicated (Prednisolone 40 mg/day for 28 days) if no active infection/GI bleed. Assess Lille score at Day 7."
        } else {
            "MILD-TO-MODERATE Alcoholic Hepatitis (DF < 32): Corticosteroids NOT indicated. Provide nutritional support (protein 1.5 g/kg/day), Thiamine 100mg IV, and strict alcohol cessation counseling."
        }
        return MaddreyResult(rounded, isSevere, rec)
    }

    // 12. BISAP Score for Acute Pancreatitis
    data class BisapResult(
        val score: Int,
        val mortalityPercent: Double,
        val riskStratum: String
    )

    fun calculateBisap(bunOver25: Boolean, impairedMental: Boolean, sirs: Boolean, ageOver60: Boolean, pleuralEffusion: Boolean): BisapResult {
        var score = 0
        if (bunOver25) score++
        if (impairedMental) score++
        if (sirs) score++
        if (ageOver60) score++
        if (pleuralEffusion) score++

        val (mortality, stratum) = when (score) {
            0 -> 0.1 to "Low Risk (Score 0): Inpatient ward observation with targeted IV fluid resuscitation."
            1 -> 0.4 to "Low Risk (Score 1): Standard ward care. Monitor vitals and urinary output."
            2 -> 1.6 to "Intermediate Risk (Score 2): Close monitoring. Consider Step-down/HDU."
            3 -> 3.6 to "High Risk (Score 3): Substantial risk of organ failure. HDU/ICU evaluation."
            4 -> 9.5 to "Very High Risk (Score 4): High mortality. Intensive care admission recommended."
            else -> 18.2 to "Critical Risk (Score 5): Extreme mortality. Urgent ICU admission & aggressive resuscitation."
        }
        return BisapResult(score, mortality, stratum)
    }

    // 13. Mean Arterial Pressure (MAP)
    data class MapResult(
        val map: Double,
        val interpretation: String
    )

    fun calculateMap(sbp: Double, dbp: Double): MapResult {
        if (sbp <= 0 || dbp <= 0 || sbp <= dbp) return MapResult(0.0, "Enter valid systolic and diastolic pressures (SBP > DBP).")
        val map = dbp + ((sbp - dbp) / 3.0)
        val rounded = (map * 10.0).toInt() / 10.0

        val interp = when {
            rounded < 65.0 -> "MAP < 65 mmHg: Inadequate tissue perfusion. Critical shock territory. Initiate IV fluid resuscitation and vasopressors (e.g. Noradrenaline) to target MAP >= 65 mmHg."
            rounded in 65.0..105.0 -> "MAP 65 - 105 mmHg: Normal perfusion pressure. Adequate renal and vital organ perfusion."
            else -> "MAP > 105 mmHg: Elevated perfusion pressure. Hypertensive urgency/emergency evaluation if end-organ symptoms present."
        }
        return MapResult(rounded, interp)
    }

    // 14. Corrected QT (QTc) Interval
    data class QtcResult(
        val bazettMs: Double,
        val fridericiaMs: Double,
        val riskWarning: String
    )

    fun calculateQtc(qtMs: Double, hrBpm: Double): QtcResult {
        if (qtMs <= 0 || hrBpm <= 0) return QtcResult(0.0, 0.0, "Enter valid QT interval (msec) and heart rate (bpm).")
        val rrSec = 60.0 / hrBpm
        val bazett = qtMs / sqrt(rrSec)
        val fridericia = qtMs / rrSec.pow(1.0 / 3.0)

        val bRounded = (bazett * 10.0).toInt() / 10.0
        val fRounded = (fridericia * 10.0).toInt() / 10.0

        val warn = when {
            bRounded >= 500.0 -> "CRITICAL (QTc >= 500 ms): High risk of Torsades de Pointes and ventricular tachycardia. Immediately stop QT-prolonging drugs (Azithromycin, Haloperidol, Ondansetron), check K+ and Mg2+."
            bRounded >= 450.0 -> "PROLONGED (QTc 450 - 499 ms): Borderline to prolonged. Exercise caution with combination QT-prolonging antimicrobials or antiarrhythmics."
            else -> "NORMAL (QTc < 450 ms): Normal repolarization interval."
        }
        return QtcResult(bRounded, fRounded, warn)
    }

    // 15. Ganzoni Equation for Iron Deficit
    data class GanzoniResult(
        val totalIronDeficitMg: Double,
        val ampoulesIronSucrose: Int,
        val guidance: String
    )

    fun calculateGanzoni(weightKg: Double, targetHbGDl: Double, actualHbGDl: Double, depotIronMg: Double = 500.0): GanzoniResult {
        if (weightKg <= 0 || targetHbGDl <= 0 || actualHbGDl <= 0) return GanzoniResult(0.0, 0, "Enter valid weight and hemoglobin values.")
        val deficit = (weightKg * (targetHbGDl - actualHbGDl) * 2.4) + depotIronMg
        val totalMg = max(0.0, (deficit * 10.0).toInt() / 10.0)
        val ampoules = (totalMg / 100.0).toInt() // Standard 100mg/5mL Iron Sucrose ampoule

        val note = "Total elemental iron needed: $totalMg mg (~$ampoules ampoules of 100 mg Iron Sucrose). " +
                "Administer maximum 200 mg per session diluted in 100-200 mL 0.9% Normal Saline over 30 minutes, 2-3 times weekly."
        return GanzoniResult(totalMg, ampoules, note)
    }

    // 16. Mentzer Index (Thalassemia vs Iron Deficiency)
    data class MentzerResult(
        val index: Double,
        val diagnosis: String,
        val confirmatoryTest: String
    )

    fun calculateMentzer(mcvFl: Double, rbcMillion: Double): MentzerResult {
        if (mcvFl <= 0 || rbcMillion <= 0) return MentzerResult(0.0, "Invalid", "Enter valid MCV and RBC count.")
        val idx = mcvFl / rbcMillion
        val rounded = (idx * 10.0).toInt() / 10.0

        val (diag, test) = if (rounded < 13.0) {
            "Mentzer Index < 13: High suspicion for BETA THALASSEMIA TRAIT (microcytosis with high/normal RBC count)." to "Order Hemoglobin Electrophoresis / HPLC (HbA2 quantification)."
        } else {
            "Mentzer Index >= 13: High suspicion for IRON DEFICIENCY ANEMIA (microcytosis with reduced RBC count)." to "Order Serum Ferritin, Iron, and Total Iron Binding Capacity (TIBC)."
        }
        return MentzerResult(rounded, diag, test)
    }

    // 17. HAS-BLED Score for Bleeding Risk
    data class HasBledResult(
        val score: Int,
        val riskCategory: String,
        val recommendation: String
    )

    fun calculateHasBled(htn: Boolean, renal: Boolean, liver: Boolean, stroke: Boolean, bleeding: Boolean, labileInr: Boolean, elderly: Boolean, drugs: Boolean, alcohol: Boolean): HasBledResult {
        var score = 0
        if (htn) score++
        if (renal) score++
        if (liver) score++
        if (stroke) score++
        if (bleeding) score++
        if (labileInr) score++
        if (elderly) score++
        if (drugs) score++
        if (alcohol) score++

        val (cat, rec) = when {
            score == 0 -> "Low Bleeding Risk (Score 0)" to "Annual bleed risk ~1.1%. Standard oral anticoagulation."
            score in 1..2 -> "Moderate Bleeding Risk (Score 1-2)" to "Annual bleed risk 1.0 - 1.9%. Oral anticoagulation reasonable; address reversible risk factors."
            else -> "High Bleeding Risk (Score >= 3)" to "Annual bleed risk >= 3.7%. HAS-BLED >= 3 is NOT a reason to withhold anticoagulation, but warrants close follow-up and modifying reversible factors (BP control, discontinue NSAIDs/antiplatelets, alcohol cessation)."
        }
        return HasBledResult(score, cat, rec)
    }

    // 18. Wells' Score for DVT
    data class WellsDvtResult(
        val score: Int,
        val probability: String,
        val clinicalPathway: String
    )

    fun calculateWellsDvt(
        activeCancer: Boolean,
        paralysis: Boolean,
        bedridden: Boolean,
        tenderness: Boolean,
        legSwelling: Boolean,
        calfSwelling: Boolean,
        pittingEdema: Boolean,
        collatVeins: Boolean,
        altDiagnosis: Boolean
    ): WellsDvtResult {
        var score = 0
        if (activeCancer) score += 1
        if (paralysis) score += 1
        if (bedridden) score += 1
        if (tenderness) score += 1
        if (legSwelling) score += 1
        if (calfSwelling) score += 1
        if (pittingEdema) score += 1
        if (collatVeins) score += 1
        if (altDiagnosis) score -= 2

        val (prob, path) = when {
            score <= 0 -> "Low Probability (DVT unlikely: ~5%)" to "Order high-sensitivity D-Dimer. If negative, DVT is ruled out without compression ultrasound."
            score in 1..2 -> "Moderate Probability (DVT ~17%)" to "Order high-sensitivity D-Dimer. If positive, proceed to proximal compression ultrasound."
            else -> "High Probability (DVT likely: ~50-85%)" to "Proceed directly to proximal compression venous ultrasound. If positive, initiate therapeutic anticoagulation."
        }
        return WellsDvtResult(score, prob, path)
    }

    // 19. Wells' Score for Pulmonary Embolism (PE)
    data class WellsPeResult(
        val score: Double,
        val probability: String,
        val diagnosticAction: String
    )

    fun calculateWellsPe(
        dvtSigns: Boolean, // 3 pts
        peLikely: Boolean, // 3 pts
        hrOver100: Boolean, // 1.5 pts
        surgery: Boolean, // 1.5 pts
        priorDvtPe: Boolean, // 1.5 pts
        hemoptysis: Boolean, // 1 pt
        cancer: Boolean // 1 pt
    ): WellsPeResult {
        var score = 0.0
        if (dvtSigns) score += 3.0
        if (peLikely) score += 3.0
        if (hrOver100) score += 1.5
        if (surgery) score += 1.5
        if (priorDvtPe) score += 1.5
        if (hemoptysis) score += 1.0
        if (cancer) score += 1.0

        val (prob, action) = when {
            score <= 1.5 -> "Low Risk / PE Unlikely (< 10%)" to "Perform PERC rule or high-sensitivity D-Dimer. If negative, PE is ruled out without CTPA."
            score in 2.0..6.0 -> "Moderate Risk (PE ~30%)" to "High-sensitivity D-Dimer. If positive, CT Pulmonary Angiography (CTPA) indicated."
            else -> "High Risk / PE Likely (> 65%)" to "Proceed directly to CT Pulmonary Angiography (CTPA). Consider empiric therapeutic anticoagulation while awaiting imaging if no contraindication."
        }
        return WellsPeResult(score, prob, action)
    }

    // 20. Steroid Conversion
    data class SteroidResult(
        val steroidName: String,
        val doseMg: Double,
        val hydrocortisoneEquiv: Double,
        val prednisoloneEquiv: Double,
        val dexamethasoneEquiv: Double
    )

    fun calculateSteroid(steroidName: String, doseMg: Double): SteroidResult {
        // Base: Hydrocortisone 20mg = Prednisone/Prednisolone 5mg = Methylprednisolone 4mg = Triamcinolone 4mg = Dexamethasone 0.75mg
        val factorToHydrocortisone = when (steroidName.lowercase()) {
            "prednisolone", "prednisone" -> 4.0 // 5mg pred = 20mg hydro
            "methylprednisolone" -> 5.0        // 4mg methyl = 20mg hydro
            "dexamethasone" -> 26.67           // 0.75mg dexa = 20mg hydro
            "triamcinolone" -> 5.0             // 4mg triam = 20mg hydro
            "betamethasone" -> 33.33           // 0.6mg beta = 20mg hydro
            else -> 1.0                        // Hydrocortisone
        }
        val hydro = doseMg * factorToHydrocortisone
        val pred = hydro / 4.0
        val dexa = hydro / 26.67

        return SteroidResult(
            steroidName = steroidName,
            doseMg = doseMg,
            hydrocortisoneEquiv = (hydro * 10.0).toInt() / 10.0,
            prednisoloneEquiv = (pred * 10.0).toInt() / 10.0,
            dexamethasoneEquiv = (dexa * 100.0).toInt() / 100.0
        )
    }

    // 21. STOP-BANG for Obstructive Sleep Apnea
    data class StopBangResult(
        val score: Int,
        val riskCategory: String,
        val management: String
    )

    fun calculateStopBang(snoring: Boolean, tired: Boolean, observed: Boolean, pressure: Boolean, bmiHigh: Boolean, ageHigh: Boolean, neckWide: Boolean, genderMale: Boolean): StopBangResult {
        var score = 0
        if (snoring) score++
        if (tired) score++
        if (observed) score++
        if (pressure) score++
        if (bmiHigh) score++
        if (ageHigh) score++
        if (neckWide) score++
        if (genderMale) score++

        val (cat, mgmt) = when {
            score in 0..2 -> "Low Risk of OSA" to "Polysomnography not routinely indicated unless high clinical suspicion."
            score in 3..4 -> "Intermediate Risk of OSA" to "Diagnostic sleep study (Polysomnography) recommended."
            else -> "High Risk of Moderate-to-Severe OSA (Score >= 5)" to "High probability of severe OSA. Comprehensive sleep medicine consultation, polysomnography, and perioperative airway precautions."
        }
        return StopBangResult(score, cat, mgmt)
    }

    // 22. Centor Score (Modified/McIsaac) for Strep Pharyngitis
    data class CentorResult(
        val score: Int,
        val probability: String,
        val treatmentGuidance: String
    )

    fun calculateCentor(tonsillarExudate: Boolean, tenderNodes: Boolean, feverHistory: Boolean, absenceOfCough: Boolean, ageGroup: Int): CentorResult {
        var score = 0
        if (tonsillarExudate) score++
        if (tenderNodes) score++
        if (feverHistory) score++
        if (absenceOfCough) score++
        // Age: 3-14 (+1), 15-44 (0), >=45 (-1)
        when (ageGroup) {
            0 -> score += 1
            2 -> score -= 1
        }
        val safeScore = score.coerceIn(0, 4)

        val (prob, guide) = when (safeScore) {
            0 -> "< 2.5% GAS Probability" to "No antibiotic or throat swab indicated. Symptomatic treatment (Paracetamol / NSAIDs)."
            1 -> "6 - 7% GAS Probability" to "No antibiotic or swab indicated. Supportive symptomatic care."
            2 -> "15% GAS Probability" to "Perform throat culture or Rapid Antigen Detection Test (RADT). Treat only if positive."
            3 -> "30 - 35% GAS Probability" to "Perform RADT / culture and consider empiric Amoxicillin 500mg TID if severe symptoms."
            else -> "50 - 55% High Probability" to "Empiric antibiotic therapy indicated: Oral Amoxicillin 500mg-1g BID/TID or Penicillin V for 10 days."
        }
        return CentorResult(safeScore, prob, guide)
    }

    // 23. PHQ-9 Depression Severity
    data class Phq9Result(
        val totalScore: Int,
        val severity: String,
        val treatmentRecommendation: String
    )

    fun calculatePhq9(answers: List<Int>): Phq9Result {
        val total = answers.sum().coerceIn(0, 27)
        val (sev, rec) = when {
            total in 0..4 -> "Minimal or None (0 - 4)" to "Patient does not require active depression pharmacotherapy."
            total in 5..9 -> "Mild Depression (5 - 9)" to "Supportive counseling, watchful waiting, and repeat PHQ-9 in 1 month."
            total in 10..14 -> "Moderate Depression (10 - 14)" to "Initiate psychotherapy (CBT) and/or SSRI pharmacotherapy (e.g. Escitalopram 10mg or Sertraline 50mg)."
            total in 15..19 -> "Moderately Severe Depression (15 - 19)" to "Active pharmacotherapy with SSRI/SNRI and structured psychotherapy. Monitor for suicidal ideation."
            else -> "Severe Depression (20 - 27)" to "Immediate initiation of antidepressant pharmacotherapy + psychiatric consult. Urgent suicide risk assessment."
        }
        return Phq9Result(total, sev, rec)
    }

    // 24. HEART Score for ED Chest Pain
    data class HeartResult(
        val score: Int,
        val sixWeekMacePercent: Double,
        val riskStratum: String,
        val management: String
    )

    fun calculateHeart(history: Int, ecg: Int, age: Int, riskFactors: Int, troponin: Int): HeartResult {
        val total = history.coerceIn(0, 2) + ecg.coerceIn(0, 2) + age.coerceIn(0, 2) + riskFactors.coerceIn(0, 2) + troponin.coerceIn(0, 2)
        val (mace, strat, mgmt) = when {
            total in 0..3 -> Triple(1.7, "Low Risk (Score 0-3)", "Candidate for early safe discharge from emergency department with outpatient stress testing / cardiology follow-up.")
            total in 4..6 -> Triple(16.6, "Intermediate Risk (Score 4-6)", "Admit to observation unit / telemetry ward. Serial troponins and non-invasive ischemia testing.")
            else -> Triple(50.1, "High Risk (Score 7-10)", "Urgent cardiology admission. Immediate coronary angiography / invasive cardiac intervention indicated.")
        }
        return HeartResult(total, mace, strat, mgmt)
    }

    // 25. Oakland Score for Acute Lower GI Bleeding (BSG 2019 Guidelines)
    data class OaklandResult(
        val score: Int,
        val riskTier: String,
        val isSafeDischarge: Boolean,
        val recommendation: String
    )

    fun calculateOaklandScore(
        age: Int,
        isMale: Boolean,
        prevLgibAdmission: Boolean,
        dreBloodPresent: Boolean,
        heartRateBpm: Int,
        systolicBpMmHg: Int,
        hemoglobinGdL: Double
    ): OaklandResult {
        var score = 0

        // 1. Age
        score += when {
            age < 40 -> 0
            age in 40..69 -> 1
            else -> 2
        }

        // 2. Sex
        if (isMale) score += 1

        // 3. Previous LGIB admission
        if (prevLgibAdmission) score += 1

        // 4. Digital rectal exam blood
        if (dreBloodPresent) score += 1

        // 5. Heart Rate
        score += when {
            heartRateBpm < 70 -> 0
            heartRateBpm in 70..89 -> 1
            heartRateBpm in 90..109 -> 2
            else -> 3
        }

        // 6. Systolic BP
        score += when {
            systolicBpMmHg >= 160 -> 0
            systolicBpMmHg in 130..159 -> 2
            systolicBpMmHg in 120..129 -> 3
            systolicBpMmHg in 90..119 -> 4
            else -> 5
        }

        // 7. Hemoglobin (g/dL)
        score += if (isMale) {
            when {
                hemoglobinGdL >= 16.0 -> 0
                hemoglobinGdL >= 13.0 -> 4
                hemoglobinGdL >= 11.0 -> 8
                hemoglobinGdL >= 9.0 -> 13
                hemoglobinGdL >= 7.0 -> 17
                else -> 22
            }
        } else {
            when {
                hemoglobinGdL >= 13.0 -> 0
                hemoglobinGdL >= 11.0 -> 4
                hemoglobinGdL >= 9.0 -> 8
                hemoglobinGdL >= 7.0 -> 13
                else -> 17
            }
        }

        val safe = score <= 8
        val (tier, rec) = if (safe) {
            "Low Risk / Safe Outpatient Discharge (Score $score <= 8)" to
                "BSG Guidelines: Patient has a >=95% probability of safe discharge without blood transfusion, therapeutic intervention, or in-hospital death. Outpatient colonoscopy/investigation recommended."
        } else {
            "High Risk / Inpatient Admission (Score $score > 8)" to
                "BSG Guidelines: Inpatient admission warranted for hemodynamic stabilization, blood typing/cross-matching, and urgent diagnostic colonoscopy or CT mesenteric angiography."
        }

        return OaklandResult(score, tier, safe, rec)
    }

    // 26. Rockall Score for Upper GI Bleeding (NICE / BSG Guidelines)
    data class RockallResult(
        val score: Int,
        val isComplete: Boolean,
        val riskTier: String,
        val mortalityRisk: String,
        val rebleedRisk: String,
        val clinicalGuidance: String
    )

    fun calculateRockallScore(
        age: Int,
        systolicBp: Int,
        heartRate: Int,
        comorbidityLevel: Int, // 0: None, 2: IHD/Heart failure/major, 3: Renal/Liver failure/Malignancy
        isComplete: Boolean,
        endoscopicDiagnosis: Int = 1, // 0: Mallory-Weiss/normal, 1: Other (ulcer/erosion), 2: Upper GI malignancy
        stigmataHemorrhage: Int = 0 // 0: None/dark spot, 2: Blood in lumen/adherent clot/visible or spurting vessel
    ): RockallResult {
        var score = 0
        // Age
        score += when {
            age < 60 -> 0
            age in 60..79 -> 1
            else -> 2
        }
        // Shock
        score += when {
            systolicBp < 100 -> 2
            heartRate >= 100 -> 1
            else -> 0
        }
        // Comorbidities
        score += comorbidityLevel.coerceIn(0, 3)

        if (isComplete) {
            score += endoscopicDiagnosis.coerceIn(0, 2)
            score += stigmataHemorrhage.coerceIn(0, 2)
        }

        val (tier, mort, rebleed, guide) = if (!isComplete) {
            when {
                score <= 1 -> Quadruple(
                    "Low Risk (Pre-Endoscopy Score $score)",
                    "< 2% Mortality",
                    "Low rebleed risk",
                    "Early planned endoscopy during routine daytime list. Hemodynamically stable."
                )
                score in 2..3 -> Quadruple(
                    "Moderate Risk (Pre-Endoscopy Score $score)",
                    "~5 - 10% Mortality",
                    "Moderate rebleed risk",
                    "Urgent fluid resuscitation, IV access, and endoscopy within 24 hours of presentation."
                )
                else -> Quadruple(
                    "High Risk (Pre-Endoscopy Score $score)",
                    "> 20 - 40% High Mortality",
                    "Very high early rebleed risk",
                    "Aggressive resuscitation with blood products, IV high-dose PPI bolus, emergency endoscopy within 12 hours, ICU alert."
                )
            }
        } else {
            when {
                score <= 2 -> Quadruple(
                    "Low Risk (Complete Score $score)",
                    "0.1 - 2% Mortality",
                    "4.3% Rebleed Risk",
                    "Safe for early hospital discharge and outpatient oral PPI therapy."
                )
                score in 3..4 -> Quadruple(
                    "Moderate Risk (Complete Score $score)",
                    "3 - 10% Mortality",
                    "14% Rebleed Risk",
                    "Inpatient ward monitoring for at least 48 hours with standard PPI therapy."
                )
                else -> Quadruple(
                    "High Risk (Complete Score $score >= 5)",
                    "17 - 40% High Mortality",
                    "25 - 40% Rebleed Risk",
                    "High-dose continuous IV PPI infusion (80mg bolus + 8mg/hr for 72h). Close monitoring in HDU/ICU. Surgical/interventional radiology standby."
                )
            }
        }

        return RockallResult(score, isComplete, tier, mort, rebleed, guide)
    }

    // 27. Royal College of Physicians (RCP) NEWS2 Score
    data class News2Result(
        val totalScore: Int,
        val riskCategory: String,
        val responseLevel: String,
        val monitoringFrequency: String,
        val hasRedScore: Boolean
    )

    fun calculateNews2(
        respirationRate: Int,
        spo2Percent: Int,
        onOxygen: Boolean,
        systolicBp: Int,
        heartRateBpm: Int,
        isAlert: Boolean,
        temperatureCelsius: Double
    ): News2Result {
        var score = 0
        var hasRed = false

        // 1. Respiration Rate
        val rrPoints = when {
            respirationRate <= 8 || respirationRate >= 25 -> 3
            respirationRate in 21..24 -> 2
            respirationRate in 9..11 -> 1
            else -> 0
        }
        if (rrPoints == 3) hasRed = true
        score += rrPoints

        // 2. SpO2
        val spo2Points = when {
            spo2Percent <= 91 -> 3
            spo2Percent in 92..93 -> 2
            spo2Percent in 94..95 -> 1
            else -> 0
        }
        if (spo2Points == 3) hasRed = true
        score += spo2Points

        // 3. Supplemental Oxygen
        if (onOxygen) score += 2

        // 4. Systolic Blood Pressure
        val sbpPoints = when {
            systolicBp <= 90 || systolicBp >= 220 -> 3
            systolicBp in 91..100 -> 2
            systolicBp in 101..110 -> 1
            else -> 0
        }
        if (sbpPoints == 3) hasRed = true
        score += sbpPoints

        // 5. Pulse / Heart Rate
        val hrPoints = when {
            heartRateBpm <= 40 || heartRateBpm >= 131 -> 3
            heartRateBpm in 111..130 -> 2
            heartRateBpm in 41..50 || heartRateBpm in 91..110 -> 1
            else -> 0
        }
        if (hrPoints == 3) hasRed = true
        score += hrPoints

        // 6. Consciousness (AVPU)
        if (!isAlert) {
            score += 3
            hasRed = true
        }

        // 7. Temperature
        val tempPoints = when {
            temperatureCelsius <= 35.0 -> 3
            temperatureCelsius in 35.1..36.0 || temperatureCelsius in 38.1..39.0 -> 1
            temperatureCelsius >= 39.1 -> 2
            else -> 0
        }
        if (tempPoints == 3) hasRed = true
        score += tempPoints

        val (cat, resp, freq) = when {
            score >= 7 -> Triple(
                "High Clinical Risk (Total Score >= 7)",
                "EMERGENCY RESPONSE: Immediate urgent clinical assessment by Medical Emergency Team (MET) / Intensive Care Team. Continuous vital signs monitoring and transfer to HDU/ICU.",
                "Continuous monitoring of vital signs"
            )
            score in 5..6 || hasRed -> Triple(
                if (hasRed) "Medium Clinical Risk (Single parameter = 3 RED)" else "Medium Clinical Risk (Score 5 - 6)",
                "URGENT RESPONSE: Urgent review by attending medical officer or rapid response team within 30 minutes. Evaluate escalation to critical care.",
                "Minimum hourly monitoring"
            )
            score in 1..4 -> Triple(
                "Low Clinical Risk (Score 1 - 4)",
                "WARD RESPONSE: Inform registered nurse for clinical assessment. Review pain relief, fluids, and medications.",
                "Minimum 4 to 6-hourly monitoring"
            )
            else -> Triple(
                "Low Clinical Risk (Score 0)",
                "ROUTINE CARE: Standard ward observation and continuous clinical care.",
                "Minimum 12-hourly monitoring"
            )
        }

        return News2Result(score, cat, resp, freq, hasRed)
    }

    // 25. VOCAL-Penn Score for Cirrhosis Surgical Risk (Hepatology & Surgery)
    data class VocalPennResult(
        val thirtyDayMortalityPercent: Double,
        val ninetyDayMortalityPercent: Double,
        val riskCategory: String,
        val riskColorHex: Long,
        val recommendations: String,
        val surgicalOptimization: String
    )

    fun calculateVocalPennScore(
        age: Int,
        albumin: Double, // g/dL
        bilirubin: Double, // mg/dL
        platelets: Double, // x10^3/uL
        bmi: Double, // kg/m^2
        asaClass: Int, // 1 to 5
        surgicalCategory: String, // "Abdominal Wall / Hernia", "Cholecystectomy", "Major Abdominal / Colorectal", "Orthopedic", "Vascular", "Cardiac", "Other Minor"
        isEmergency: Boolean
    ): VocalPennResult {
        val safeAge = max(18, min(age, 95))
        val safeAlb = max(1.0, min(albumin, 5.5))
        val safeBili = max(0.2, min(bilirubin, 30.0))
        val safePlt = max(10.0, min(platelets, 800.0))
        val safeBmi = max(15.0, min(bmi, 60.0))

        // Logistic regression modeling based on Mahmud et al. (Hepatology 2021; VOCAL-Penn derivation)
        // Predictors: Age, Albumin (-), Bilirubin (+), Platelets (-), BMI, ASA status, Procedure category, Emergency
        var logit30 = -4.85
        logit30 += (safeAge - 55) * 0.038
        logit30 -= (safeAlb - 3.5) * 0.72
        logit30 += ln(max(1.0, safeBili)) * 0.48
        logit30 -= ln(max(20.0, safePlt) / 100.0) * 0.35
        if (safeBmi >= 30.0) logit30 += 0.22 else if (safeBmi < 18.5) logit30 += 0.35

        when (asaClass) {
            in 1..2 -> logit30 -= 0.60
            3 -> logit30 += 0.20
            4 -> logit30 += 0.95
            else -> logit30 += 1.60
        }

        when (surgicalCategory) {
            "Abdominal Wall / Hernia" -> logit30 += 0.10
            "Cholecystectomy" -> logit30 += 0.35
            "Major Abdominal / Colorectal" -> logit30 += 0.90
            "Orthopedic" -> logit30 += 0.30
            "Vascular" -> logit30 += 1.10
            "Cardiac" -> logit30 += 1.45
            else -> logit30 -= 0.30
        }

        if (isEmergency) {
            logit30 += 0.98 // ~2.6x odds ratio for emergency surgery
        }

        val prob30 = (1.0 / (1.0 + kotlin.math.exp(-logit30))) * 100.0
        val clamped30 = (min(95.0, max(0.8, prob30)) * 10.0).toInt() / 10.0

        // 90-day mortality typically 1.35x - 1.6x 30-day mortality in decompensated cirrhosis
        val prob90 = min(98.0, clamped30 * 1.45)
        val clamped90 = (prob90 * 10.0).toInt() / 10.0

        val (cat, color, recs, opt) = when {
            clamped30 >= 30.0 -> Quadruple(
                "Prohibitive / Very High Risk (>=30%)",
                0xFFEF4444, // Red
                "PROHIBITIVE POST-OP MORTALITY RISK: Elective surgical procedures are strongly contraindicated. If non-emergent, postpone surgery immediately and consider non-operative medical management. For emergency life-threatening surgery, intensive multidisciplinary ICU care and liver transplant center consultation are mandatory.",
                "1. Multidisciplinary hepatology & critical care evaluation.\n2. Screen for portal hypertension and treat ascites / varices.\n3. Consider pre-operative TIPS if severe ascites/portal HTN.\n4. Avoid intra-abdominal drains and minimize fluid overload."
            )
            clamped30 >= 15.0 -> Quadruple(
                "High Risk (15% - 30%)",
                0xFFF97316, // Orange
                "HIGH SURGICAL RISK: Significant probability of post-operative hepatic decompensation, acute-on-chronic liver failure (ACLF), and mortality. Surgery should only proceed if strictly medically necessary after comprehensive hepatology optimization.",
                "1. Pre-operative IV Albumin infusion for hypoalbuminemia.\n2. Platelet transfusion or Avatrombopag if platelets < 50k before invasive cuts.\n3. Prefer laparoscopic / minimally invasive over open laparotomy.\n4. Meticulous hemostasis; monitor renal function and avoid nephrotoxins."
            )
            clamped30 >= 5.0 -> Quadruple(
                "Intermediate Risk (5% - 15%)",
                0xFFFBBF24, // Amber
                "INTERMEDIATE SURGICAL RISK: Moderate perioperative risk. Procedure can proceed with standard cirrhosis precautions, cautious fluid management, and vigilant post-operative monitoring for infection, SBP, or encephalopathy.",
                "1. Correct coagulopathy and maintain normal serum electrolytes.\n2. Monitor for post-operative ascites leak or secondary wound infection.\n3. Lactulose prophylaxis if history of hepatic encephalopathy.\n4. Early mobilization and enhanced recovery protocol."
            )
            else -> Quadruple(
                "Low Surgical Risk (<5%)",
                0xFF10B981, // Emerald Green
                "LOW SURGICAL RISK: Favorable perioperative profile. Proceed with planned surgical intervention adhering to standard surgical protocols for compensated cirrhosis.",
                "1. Routine pre-operative fasting and standard anesthesia.\n2. Maintain hemodynamic stability and avoid prolonged hypotension.\n3. Routine surgical follow-up."
            )
        }

        return VocalPennResult(clamped30, clamped90, cat, color, recs, opt)
    }

    private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)

    // =========================================================================
    // 14. Alvarado Score for Acute Appendicitis (MANTRELS)
    // =========================================================================
    data class AlvaradoResult(
        val totalScore: Int,
        val riskTier: String,
        val probability: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateAlvarado(
        migrationOfPain: Boolean,
        anorexia: Boolean,
        nauseaOrVomiting: Boolean,
        rlqTenderness: Boolean,
        reboundPain: Boolean,
        elevatedTemp: Boolean,
        leukocytosis: Boolean,
        neutrophilShift: Boolean
    ): AlvaradoResult {
        var score = 0
        if (migrationOfPain) score += 1
        if (anorexia) score += 1
        if (nauseaOrVomiting) score += 1
        if (rlqTenderness) score += 2
        if (reboundPain) score += 1
        if (elevatedTemp) score += 1
        if (leukocytosis) score += 2
        if (neutrophilShift) score += 1

        val (tier, prob, interp, steps) = when {
            score <= 4 -> Quadruple(
                "Low Risk (Score $score / 10)",
                "< 5% probability of appendicitis",
                "Acute appendicitis is unlikely. Safe for outpatient discharge with clear return instructions if clinical condition remains stable.",
                listOf(
                    "Step 1 (Disposition): Safe for discharge home provided patient has reliable observation and tolerance of oral intake.",
                    "Step 2 (Red Flags): Educate on immediate emergency return precautions: worsening localized RLQ pain, spiking fever (>38°C), or persistent vomiting.",
                    "Step 3 (Re-evaluation): Recommend scheduled follow-up abdominal examination in 12–24 hours if mild abdominal discomfort persists.",
                    "Step 4 (Medication): Prescribe oral Acetaminophen (Paracetamol) for analgesia; avoid strong opiates or NSAIDs that may mask evolving peritonitis."
                )
            )
            score in 5..6 -> Quadruple(
                "Equivocal / Moderate Risk (Score $score / 10)",
                "30% - 50% probability of appendicitis",
                "Compatible with acute appendicitis, but not diagnostic. Patient warrants observation, active surgical consultation, and diagnostic imaging.",
                listOf(
                    "Step 1 (Surgical Triage): Request urgent General Surgery consultation for clinical observation and inpatient admission.",
                    "Step 2 (Patient Fasting): Strict NPO (Nil Per Os) status; initiate IV isotonic hydration (Ringer's Lactate or Normal Saline at 100–125 mL/hr).",
                    "Step 3 (Diagnostic Imaging): Perform Abdominal Ultrasound (preferred first-line in pediatric and pregnant patients) or Contrast-Enhanced Abdominal CT (high sensitivity in adults).",
                    "Step 4 (Monitoring): Perform serial abdominal examinations every 2 to 4 hours by the same clinical surgical team."
                )
            )
            score in 7..8 -> Quadruple(
                "High Probability (Score $score / 10)",
                "70% - 80% probability of appendicitis",
                "Probable acute appendicitis. Operative management is strongly indicated; proceed directly with surgical preparation.",
                listOf(
                    "Step 1 (Urgent Surgical Consult): Immediate General Surgery consultation for emergency appendectomy (laparoscopic preferred).",
                    "Step 2 (Pre-operative Care): Strict NPO; secure large-bore IV access and infuse balanced crystalloids for volume repletion.",
                    "Step 3 (Antimicrobial Prophylaxis): Administer pre-operative IV antibiotics within 60 minutes prior to surgical incision: Cefoxitin 2g IV OR Ceftriaxone 1g + Metronidazole 500mg IV.",
                    "Step 4 (Pre-op Workup): Stat Type & Screen, PT/INR, CBC, electrolytes, and urinalysis (to exclude nephrolithiasis / severe UTI)."
                )
            )
            else -> Quadruple(
                "Almost Definite (Score $score / 10)",
                "> 90% probability of appendicitis",
                "Definite acute appendicitis. High risk of perforation, gangrene, or localized abscess. Immediate surgical intervention required.",
                listOf(
                    "Step 1 (Immediate OR Transfer): Expedite operating room transfer for emergency appendectomy without unnecessary imaging delays.",
                    "Step 2 (Broad-Spectrum IV Antibiotics): Initiate therapeutic IV Ceftriaxone 1g-2g + Metronidazole 500mg IV (or Piperacillin-Tazobactam 4.5g IV if septic shock / perforation suspected).",
                    "Step 3 (Resuscitation & Analgesia): Infuse IV fluids to restore perfusion; provide parenteral analgesia (IV Fentanyl or Morphine titrations; analgesia does NOT delay diagnosis).",
                    "Step 4 (Anesthesia Notification): Alert anesthesiology for rapid sequence induction and airway management in a potentially full-stomach emergency."
                )
            )
        }

        return AlvaradoResult(score, tier, prob, interp, steps)
    }

    // =========================================================================
    // 15. 4Ts Score for Heparin-Induced Thrombocytopenia (HIT)
    // =========================================================================
    data class FourTsResult(
        val totalScore: Int,
        val riskTier: String,
        val probability: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateFourTs(
        thrombocytopeniaPts: Int, // 0, 1, 2
        timingPts: Int,           // 0, 1, 2
        thrombosisPts: Int,       // 0, 1, 2
        otherCausesPts: Int       // 0, 1, 2
    ): FourTsResult {
        val score = (thrombocytopeniaPts.coerceIn(0, 2) +
                timingPts.coerceIn(0, 2) +
                thrombosisPts.coerceIn(0, 2) +
                otherCausesPts.coerceIn(0, 2))

        val (tier, prob, interp, steps) = when {
            score <= 3 -> Quadruple(
                "Low Probability (Score $score / 8)",
                "≤ 5% probability of HIT",
                "Heparin-induced thrombocytopenia is highly unlikely. Negative predictive value > 99%.",
                listOf(
                    "Step 1 (Heparin Status): Continue heparin therapy if clinically indicated; routine cessation is NOT required.",
                    "Step 2 (Testing Rule): DO NOT send HIT antibody testing (anti-PF4 ELISA); testing in low-probability patients yields high false-positive rates.",
                    "Step 3 (Surveillance): Continue routine platelet monitoring every 2 to 3 days if unfractionated heparin is continued.",
                    "Step 4 (Alternative Causes): Evaluate other common etiologies of mild thrombocytopenia: post-op hemodilution, sepsis, medications, or EDTA clumping."
                )
            )
            score in 4..5 -> Quadruple(
                "Intermediate Probability (Score $score / 8)",
                "~14% probability of HIT",
                "Moderate pre-test probability of HIT. Immediate cessation of all heparin and transition to non-heparin anticoagulation required.",
                listOf(
                    "Step 1 (STOP ALL HEPARIN): Immediately discontinue all unfractionated heparin, LMWH (Enoxaparin), heparin flushes, and heparin-coated central catheters.",
                    "Step 2 (Alternative Anticoagulation): Start alternative therapeutic non-heparin anticoagulant: Argatroban IV infusion (titrate to aPTT 1.5–3x baseline) OR Fondaparinux (7.5 mg SC daily).",
                    "Step 3 (Laboratory Workup): Send urgent anti-PF4/heparin immunoassay (ELISA); confirm with functional Serotonin Release Assay (SRA) if positive.",
                    "Step 4 (Crucial Contraindications): DO NOT give platelet transfusions (triggers arterial thrombosis) and DO NOT initiate Warfarin (triggers venous limb gangrene and skin necrosis).",
                    "Step 5 (Screening Ultrasound): Perform bilateral lower extremity venous duplex ultrasound to screen for occult deep vein thrombosis."
                )
            )
            else -> Quadruple(
                "High Probability (Score $score / 8)",
                "~64% probability of HIT",
                "High pre-test probability of HIT. Immediate cessation of heparin and full therapeutic alternative anticoagulation mandatory.",
                listOf(
                    "Step 1 (EMERGENCY HEPARIN CESSATION): Cease all heparin products immediately; flag patient medical chart with prominent 'HEPARIN ALLERGY / HIT ALERT'.",
                    "Step 2 (Therapeutic Anticoagulation): Initiate full-dose non-heparin anticoagulation: Argatroban (0.5–2 mcg/kg/min IV, adjust for liver disease) OR Fondaparinux OR Bivalirudin.",
                    "Step 3 (Diagnostic Confirmation): Order STAT PF4/heparin ELISA and functional 14C-Serotonin Release Assay (SRA); consult Hematology.",
                    "Step 4 (Vascular Screening): Mandatory bilateral lower extremity venous Doppler ultrasound to detect silent thrombosis; monitor limb perfusion.",
                    "Step 5 (Warfarin Reversal): If patient was already on Warfarin, give oral/IV Vitamin K to reverse it, because Warfarin-induced Protein C depletion causes catastrophic limb necrosis."
                )
            )
        }

        return FourTsResult(score, tier, prob, interp, steps)
    }

    // =========================================================================
    // 16. Serum Anion Gap & Delta-Delta Ratio (Delta Gap)
    // =========================================================================
    data class AnionDeltaGapResult(
        val anionGap: Double,
        val correctedAnionGap: Double,
        val deltaGap: Double,
        val deltaRatio: Double,
        val acidBaseCategory: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateAnionDeltaGap(
        sodium: Double,
        chloride: Double,
        bicarbonate: Double,
        albumin: Double = 4.0
    ): AnionDeltaGapResult {
        if (sodium <= 0 || chloride <= 0 || bicarbonate <= 0) {
            return AnionDeltaGapResult(0.0, 0.0, 0.0, 0.0, "Invalid Inputs", "Enter valid positive electrolyte values.", emptyList())
        }

        val uncorrectedAG = sodium - (chloride + bicarbonate)
        val alb = if (albumin > 0) albumin else 4.0
        val correctedAG = uncorrectedAG + 2.5 * (4.0 - alb)
        val roundedAG = (correctedAG * 10.0).roundToInt() / 10.0

        val deltaGap = roundedAG - 12.0
        val bicarbDeficit = 24.0 - bicarbonate
        val deltaRatio = if (bicarbDeficit > 0.5) {
            (deltaGap / bicarbDeficit * 100.0).roundToInt() / 100.0
        } else {
            0.0
        }

        val (cat, interp, steps) = when {
            roundedAG <= 12.0 -> {
                if (bicarbonate < 22.0) {
                    Triple(
                        "Normal Anion Gap Metabolic Acidosis (NAGMA)",
                        "Non-anion gap (hyperchloremic) metabolic acidosis. Primary bicarbonate loss without unmeasured organic anions.",
                        listOf(
                            "Step 1 (Etiology Screen): Differentiate GI bicarbonate loss (severe diarrhea, enterocutaneous fistula) from Renal Tubular Acidosis (RTA).",
                            "Step 2 (Urine Anion Gap): Calculate Urine AG = (Urine Na + Urine K) - Urine Cl. Negative result (<0) confirms GI diarrhea; positive result (>0) confirms impaired renal H+ excretion (RTA).",
                            "Step 3 (Fluid Selection): Avoid excessive 0.9% Normal Saline (causes dilutional hyperchloremic acidosis); switch to balanced crystalloid (Plasmalyte or Ringer's Lactate).",
                            "Step 4 (Therapy): Treat underlying diarrhea; consider oral Sodium Bicarbonate supplementation only if serum HCO3 < 15 mEq/L or pH < 7.20."
                        )
                    )
                } else {
                    Triple(
                        "Normal Anion Gap (Normal Acid-Base)",
                        "Normal serum anion gap (≤ 12 mEq/L). No high anion gap metabolic acidosis present.",
                        listOf(
                            "Step 1 (Clinical Correlation): Correlate with patient's arterial blood gas (ABG) and clinical presentation.",
                            "Step 2 (Routine Monitoring): Repeat electrolyte panel as clinically indicated during acute illness."
                        )
                    )
                }
            }
            deltaRatio < 0.4 -> Triple(
                "Mixed High AG Acidosis + Normal AG Acidosis (NAGMA)",
                "High Anion Gap Acidosis combined with severe hyperchloremic non-gap acidosis (Delta Ratio < 0.4). Bicarbonate drop exceeds the anion gap rise.",
                listOf(
                    "Step 1 (Dual Etiology Workup): Screen for concurrent cause of high AG acidosis (e.g. DKA or lactic acidosis) PLUS cause of non-gap acidosis (diarrhea or saline overload).",
                    "Step 2 (Fluid Strategy): Immediately stop 0.9% Normal Saline infusions; switch to balanced crystalloids (Ringer's Lactate or Plasmalyte).",
                    "Step 3 (Diagnostic Labs): Order Serum Lactate, Serum Ketones (Beta-hydroxybutyrate), BUN/Creatinine, and Urine Anion Gap.",
                    "Step 4 (Targeted Treatment): Treat the primary organic acidosis driver (insulin for DKA, perfusion for sepsis); monitor electrolytes every 2–4 hours."
                )
            )
            deltaRatio >= 0.4 && deltaRatio <= 0.8 -> Triple(
                "Mixed HAGMA + Concomitant Non-Gap Acidosis",
                "High Anion Gap Acidosis with secondary hyperchloremic non-gap acidosis component (Delta Ratio 0.4–0.8).",
                listOf(
                    "Step 1 (Screen GOLDMARK): Screen for Glycols, Oxoproline, L-Lactate, D-Lactate, Methanol, Aspirin, Uremia, and Ketoacidosis.",
                    "Step 2 (Evaluate Saline Loading): Determine if recent large-volume 0.9% Normal Saline resuscitation contributed to hyperchloremia.",
                    "Step 3 (Balanced Hydration): Transition fluids to Ringer's Lactate or D5W with bicarbonate if severe acidosis.",
                    "Step 4 (Frequent Checks): Re-evaluate basic metabolic panel and venous/arterial blood gas in 2 to 4 hours."
                )
            )
            deltaRatio >= 0.8 && deltaRatio <= 2.0 -> Triple(
                "Pure High Anion Gap Metabolic Acidosis (HAGMA)",
                "Uncomplicated High Anion Gap Metabolic Acidosis (Delta Ratio 0.8–2.0). 1:1 stoichiometric rise in anion gap matches the decline in bicarbonate.",
                listOf(
                    "Step 1 (GOLDMARK Differential): Investigate standard causes: Diabetic Ketoacidosis (DKA), L-Lactic Acidosis (sepsis/hypoperfusion), Alcoholic/Starvation Ketoacidosis, Uremia, or Toxic Ingestions.",
                    "Step 2 (Critical Diagnostics): Stat Serum Lactate, Beta-hydroxybutyrate, BUN/Creatinine, and Serum Osmolality (to check Osmolar Gap).",
                    "Step 3 (Etiology-Directed Care): DKA -> IV fluid hydration + IV Insulin infusion (0.1 U/kg/hr); Sepsis -> Broad-spectrum antibiotics + fluid resuscitation; Uremia -> Nephrology consult.",
                    "Step 4 (Bicarbonate Warning): Routine sodium bicarbonate infusion is generally NOT recommended in pure HAGMA unless arterial pH < 7.10 or severe refractory shock."
                )
            )
            else -> Triple(
                "Mixed HAGMA + Metabolic Alkalosis (or Chronic Resp Acidosis)",
                "High Anion Gap Acidosis with concurrent Metabolic Alkalosis (Delta Ratio > 2.0). Bicarbonate is higher than expected for the degree of anion gap elevation.",
                listOf(
                    "Step 1 (Identify Alkalosis Source): Evaluate for concurrent severe vomiting, nasogastric tube suction, or prior loop/thiazide diuretic therapy.",
                    "Step 2 (Screen COPD / Hypercapnia): Check if patient has underlying severe COPD with chronic compensatory renal bicarbonate retention.",
                    "Step 3 (Electrolyte Replacement): Check serum potassium and magnesium; hypokalemia frequently perpetuates metabolic alkalosis. Administer IV/oral Potassium Chloride.",
                    "Step 4 (Volume Resuscitation): Administer isotonic IV fluids with Potassium Chloride if hypovolemic and chloride-responsive; treat primary high AG source."
                )
            )
        }

        return AnionDeltaGapResult(uncorrectedAG, roundedAG, deltaGap, deltaRatio, cat, interp, steps)
    }

    // =========================================================================
    // 17. Serum Osmolality & Osmolar Gap
    // =========================================================================
    data class OsmolarGapResult(
        val calculatedOsmolality: Double,
        val measuredOsmolality: Double,
        val osmolarGap: Double,
        val riskTier: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateOsmolarGap(
        measuredOsm: Double,
        sodium: Double,
        glucoseMgDl: Double,
        bunMgDl: Double,
        ethanolMgDl: Double = 0.0
    ): OsmolarGapResult {
        if (measuredOsm <= 0 || sodium <= 0) {
            return OsmolarGapResult(0.0, 0.0, 0.0, "Invalid Inputs", "Enter valid positive measured osmolality and sodium.", emptyList())
        }

        val calculated = (2.0 * sodium) + (glucoseMgDl / 18.0) + (bunMgDl / 2.8) + (ethanolMgDl / 4.6)
        val roundedCalc = (calculated * 10.0).roundToInt() / 10.0
        val gap = ((measuredOsm - calculated) * 10.0).roundToInt() / 10.0

        val (tier, interp, steps) = when {
            gap > 10.0 -> Triple(
                "Elevated Osmolar Gap (> 10 mOsm/kg)",
                "High Osmolar Gap ($gap mOsm/kg). Indicates the presence of unmeasured low-molecular-weight osmotically active toxins: Toxic Alcohols (Methanol, Ethylene Glycol, Isopropanol), Propylene Glycol, or Acetone.",
                listOf(
                    "Step 1 (Antidote Initiation): Start Fomepizole loading dose immediately (15 mg/kg IV in 100 mL D5W over 30 min) OR IV Ethanol 10% infusion if Fomepizole is unavailable.",
                    "Step 2 (Methanol Specific Adjunct): If visual disturbance or optic disc hyperemia: administer Folinic Acid (Leucovorin) 50 mg IV q4h to promote formic acid conversion to CO2.",
                    "Step 3 (Ethylene Glycol Specific Adjunct): If flank pain or urine calcium oxalate envelope crystals: administer Pyridoxine 100 mg IV + Thiamine 100 mg IV q6h.",
                    "Step 4 (Emergent Hemodialysis): Request STAT Nephrology consult for urgent Hemodialysis if: Osmolar Gap > 20 mOsm/kg, severe metabolic acidosis (pH < 7.25), visual deficit, or AKI.",
                    "Step 5 (Toxicology & Poison Control): Contact Regional Poison Center; check arterial blood gas, serum lactate, and repeat osmolar gap every 2 to 4 hours."
                )
            )
            else -> Triple(
                "Normal Osmolar Gap (≤ 10 mOsm/kg)",
                "Normal Osmolar Gap ($gap mOsm/kg). Significant acute toxic alcohol ingestion is unlikely at this time.",
                listOf(
                    "Step 1 (Clinical Correlation): Note that in late-presenting toxic alcohol ingestions (>24–48h), the parent alcohol has converted into acid metabolites, closing the osmolar gap while widening the anion gap.",
                    "Step 2 (Alternative Differential): If severe metabolic acidosis is present without osmolar gap, investigate DKA, lactic acidosis, starvation ketosis, or salicylate toxicity.",
                    "Step 3 (Monitoring): Repeat basic metabolic panel and vital signs monitoring."
                )
            )
        }

        return OsmolarGapResult(roundedCalc, measuredOsm, gap, tier, interp, steps)
    }

    // =========================================================================
    // 18. ROX Index (High-Flow Nasal Cannula Failure Predictor)
    // =========================================================================
    data class RoxIndexResult(
        val roxScore: Double,
        val riskTier: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateRoxIndex(
        spo2Percent: Double,
        fio2Percent: Double, // 21 to 100%
        respiratoryRate: Double
    ): RoxIndexResult {
        if (spo2Percent <= 0 || fio2Percent <= 0 || respiratoryRate <= 0) {
            return RoxIndexResult(0.0, "Invalid Inputs", "Enter valid positive values for SpO2, FiO2, and RR.", emptyList())
        }
        val fio2Fraction = fio2Percent / 100.0
        val rox = (spo2Percent / fio2Fraction) / respiratoryRate
        val rounded = (rox * 100.0).roundToInt() / 100.0

        val (tier, interp, steps) = when {
            rounded >= 4.88 -> Triple(
                "Low Risk of Failure (Score $rounded)",
                "ROX Index ≥ 4.88. High likelihood of successful High-Flow Nasal Cannula (HFNC) therapy. Low risk of progression to mechanical ventilation.",
                listOf(
                    "Step 1 (Maintain Therapy): Continue High-Flow Nasal Cannula; titrate flow (30–60 L/min) and FiO2 to maintain SpO2 92–96% (88–92% in hypercapnic COPD).",
                    "Step 2 (Awake Proning): Encourage awake prone positioning (proning sessions 4–8 hours daily) to improve ventilation-perfusion matching.",
                    "Step 3 (Reassessment Schedule): Re-evaluate ROX index strictly at 2 hours, 6 hours, and 12 hours post-initiation.",
                    "Step 4 (Weaning Protocol): Once stabilized with ROX > 5.0 and RR < 25, gradually wean FiO2 first below 40%, then taper flow rate."
                )
            )
            rounded >= 3.85 && rounded <= 4.87 -> Triple(
                "Intermediate / Warning Zone (Score $rounded)",
                "ROX Index between 3.85 and 4.87. Indeterminate response to HFNC. High vigilance required.",
                listOf(
                    "Step 1 (Optimize Settings): Increase HFNC flow rate up to maximum tolerance (e.g. 50–60 L/min) to optimize alveolar recruitment and reduce dead space.",
                    "Step 2 (Clinical Assessment): Actively evaluate work of breathing: check for sternocleidomastoid accessory muscle usage, suprasternal retraction, and thoracoabdominal asynchrony.",
                    "Step 3 (Stat Repeat): Repeat ROX index strictly within 1 to 2 hours; alert the ICU / Critical Care outreach team.",
                    "Step 4 (Pre-intubation Planning): Ensure functional bag-valve mask, suction, endotracheal intubation tray, and video laryngoscope are ready at bedside."
                )
            )
            else -> Triple(
                "High Risk of HFNC Failure (Score $rounded)",
                "ROX Index < 3.85. Very high failure rate of High-Flow Nasal Cannula (mortality hazard increases significantly if intubation is delayed).",
                listOf(
                    "Step 1 (STAT ICU Notification): Immediately alert Intensive Care Unit / Anesthesia team for urgent endotracheal intubation.",
                    "Step 2 (Do NOT Delay Intubation): Avoid prolonging non-invasive trials in a failing patient; delayed emergency crash intubations carry increased cardiopulmonary arrest rates.",
                    "Step 3 (Pre-oxygenation): Provide optimal pre-oxygenation with 100% FiO2 on HFNC + non-rebreather mask; minimize patient desaturation during induction.",
                    "Step 4 (RSI Medication Preparation): Prepare Rapid Sequence Induction medications: hemodynamically stable induction agent (Ketamine 1.5–2 mg/kg or Etomidate 0.3 mg/kg) + Rocuronium (1.2 mg/kg IV)."
                )
            )
        }

        return RoxIndexResult(rounded, tier, interp, steps)
    }

    // =========================================================================
    // 19. Simplified PESI (sPESI) for Pulmonary Embolism
    // =========================================================================
    data class SpesiResult(
        val totalScore: Int,
        val riskTier: String,
        val thirtyDayMortality: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateSpesi(
        ageOver80: Boolean,
        historyOfCancer: Boolean,
        chronicCardiopulmonaryDisease: Boolean,
        heartRateOver110: Boolean,
        sbpUnder100: Boolean,
        spo2Under90: Boolean
    ): SpesiResult {
        var score = 0
        if (ageOver80) score += 1
        if (historyOfCancer) score += 1
        if (chronicCardiopulmonaryDisease) score += 1
        if (heartRateOver110) score += 1
        if (sbpUnder100) score += 1
        if (spo2Under90) score += 1

        val (tier, mort, interp, steps) = when (score) {
            0 -> Quadruple(
                "Low Risk (Score 0)",
                "1.1% 30-day mortality",
                "Low risk of 30-day all-cause mortality. Patient is a candidate for early discharge or outpatient anticoagulation management if home criteria are met.",
                listOf(
                    "Step 1 (Outpatient Candidacy): Screen for outpatient home therapy eligibility (Hestia criteria): confirmed hemodynamic stability, absence of severe pain, adequate social support.",
                    "Step 2 (First-Line Anticoagulation): Initiate oral Direct Oral Anticoagulant (DOAC): Apixaban (10 mg PO BID for 7 days, then 5 mg PO BID) OR Rivaroxaban (15 mg PO BID with food for 21 days, then 20 mg PO daily).",
                    "Step 3 (Patient Counseling): Educate on bleeding precautions (signs of GI bleed, intracranial hemorrhage), compliance importance, and avoid concurrent NSAIDs.",
                    "Step 4 (Follow-up): Schedule mandatory outpatient clinical review within 5 to 7 days."
                )
            )
            else -> Quadruple(
                "High Risk (Score ≥ 1 [Score: $score])",
                "8.9% - 10.9% 30-day mortality",
                "High risk of 30-day adverse outcomes. Hospital inpatient admission is mandatory; requires active hemodynamic and RV strain monitoring.",
                listOf(
                    "Step 1 (Hospital Admission): Inpatient admission required; continuous telemetry and pulse oximetry monitoring.",
                    "Step 2 (Right Ventricle Evaluation): Order urgent Transthoracic Echocardiogram (TTE) to check for RV enlargement, hypokinesis, and McConnell's sign; check CT PA for RV/LV diameter ratio > 1.0.",
                    "Step 3 (Cardiac Biomarkers): Stat Cardiac Troponin I/T and NT-proBNP/BNP to detect right ventricular myocardial strain.",
                    "Step 4 (Anticoagulation Choice): Initiate Low-Molecular-Weight Heparin (Enoxaparin 1 mg/kg SC q12h) or IV Unfractionated Heparin infusion (if impending hemodynamic collapse or severe renal failure).",
                    "Step 5 (Advanced Reperfusion): If sustained hypotension (SBP < 90 mmHg) or cardiac arrest develops: Activate Pulmonary Embolism Response Team (PERT) for Systemic Thrombolysis (Alteplase 100 mg IV over 2h) or catheter-directed embolectomy."
                )
            )
        }

        return SpesiResult(score, tier, mort, interp, steps)
    }

    // =========================================================================
    // 20. Fractional Excretion of Urea (FEUrea) for AKI
    // =========================================================================
    data class FeUreaResult(
        val feUreaPercent: Double,
        val etiology: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateFeUrea(
        serumUreaBun: Double,
        urineUrea: Double,
        serumCr: Double,
        urineCr: Double
    ): FeUreaResult {
        if (serumUreaBun <= 0 || serumCr <= 0 || urineCr <= 0 || urineUrea <= 0) {
            return FeUreaResult(0.0, "Invalid Inputs", "Enter valid positive urea and creatinine values.", emptyList())
        }

        val feUrea = ((urineUrea * serumCr) / (serumUreaBun * urineCr)) * 100.0
        val rounded = (feUrea * 10.0).roundToInt() / 10.0

        val (etio, interp, steps) = when {
            rounded < 35.0 -> Triple(
                "Prerenal Azotemia (< 35%)",
                "FEUrea < 35% indicates intact tubular urea reabsorption. Diagnostic of Prerenal Azotemia even if the patient has received loop diuretics (which falsely elevate FENa).",
                listOf(
                    "Step 1 (Fluid Resuscitation): Volume depletion is the most common cause; administer an isotonic fluid challenge (500–1000 mL crystalloid over 1–2 hours) unless overt pulmonary edema or severe heart failure.",
                    "Step 2 (Hold Diuretics & Nephrotoxins): Temporarily discontinue loop diuretics, ACE inhibitors, ARBs, and NSAIDs.",
                    "Step 3 (Assess Perfusion): Evaluate effective circulating volume (cardiorenal syndrome, hepatorenal syndrome, or severe sepsis-induced vasodilation).",
                    "Step 4 (Serial Monitoring): Track hourly urine output via Foley catheter (target > 0.5 mL/kg/hr); repeat serum BUN and Creatinine at 12 and 24 hours."
                )
            )
            rounded >= 35.0 && rounded <= 50.0 -> Triple(
                "Indeterminate Zone (35% - 50%)",
                "FEUrea in indeterminate range. May represent evolving acute tubular injury, acute interstitial nephritis, or mixed prerenal and intrinsic insult.",
                listOf(
                    "Step 1 (Comprehensive Review): Review medication chart for recent aminoglycosides, vancomycin, IV radiocontrast, or calcineurin inhibitors.",
                    "Step 2 (Urine Microscopy): Perform spun urine microscopy to inspect for 'muddy brown' granular casts (diagnostic of ATN) or WBC casts (interstitial nephritis).",
                    "Step 3 (Conservative Hydration): Give gentle isotonic fluids while closely monitoring volume status; avoid fluid overloading an oligo-anuric patient.",
                    "Step 4 (Renal Ultrasound): Perform renal ultrasound to rule out post-renal hydronephrosis/obstruction."
                )
            )
            else -> Triple(
                "Intrinsic AKI / Acute Tubular Necrosis (> 50%)",
                "FEUrea > 50% indicates damaged tubular reabsorptive capacity. Consistent with Intrinsic Renal Injury (Acute Tubular Necrosis / ATN).",
                listOf(
                    "Step 1 (Fluid Restriction): Restrict maintenance IV fluids to insensible losses (~500 mL/day) plus measured urine output; aggressive fluid loading in established ATN causes lethal pulmonary edema.",
                    "Step 2 (Strict Medication Dose Adjustments): Dose-adjust all renally eliminated medications (beta-lactams, fluoroquinolones, enoxaparin, digoxin, gabapentin) to current eGFR.",
                    "Step 3 (Electrolyte Vigilance): Monitor and aggressively treat hyperkalemia (calcium gluconate, insulin/glucose, Lokelma/Kayexalate) and severe metabolic acidosis.",
                    "Step 4 (Nephrology Consultation): Involve Nephrology early for hemodialysis planning if refractory volume overload, intractable hyperkalemia, or uremic pericarditis/encephalopathy occurs."
                )
            )
        }

        return FeUreaResult(rounded, etio, interp, steps)
    }

    // =========================================================================
    // 21. BAP-65 Score for Acute Exacerbation of COPD
    // =========================================================================
    data class Bap65Result(
        val totalScore: Int,
        val riskClass: String,
        val inHospitalMortality: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateBap65(
        bunOver25: Boolean,
        alteredMentalStatus: Boolean,
        pulseOver109: Boolean,
        ageOver65: Boolean
    ): Bap65Result {
        var score = 0
        if (bunOver25) score += 1
        if (alteredMentalStatus) score += 1
        if (pulseOver109) score += 1
        if (ageOver65) score += 1

        val (cls, mort, interp, steps) = when (score) {
            0 -> Quadruple(
                "Class I (Low Risk)",
                "0.3% in-hospital mortality",
                "Low risk of in-hospital death and need for mechanical ventilation. Suitable for outpatient management or brief observation.",
                listOf(
                    "Step 1 (Bronchodilator Therapy): Inhaled Short-Acting Beta-Agonist (Salbutamol 2.5–5 mg) + Anticholinergic (Ipratropium 0.5 mg) nebulized every 4 to 6 hours.",
                    "Step 2 (Systemic Corticosteroids): Oral Prednisolone 40 mg once daily for 5 days (shorter courses are as effective as prolonged tapers).",
                    "Step 3 (Antibiotic Coverage): Oral Amoxicillin-Clavulanate (875/125 mg BID) OR Azithromycin (500 mg day 1, then 250 mg daily for 4 days) if purulent sputum is present.",
                    "Step 4 (Discharge Planning): Ensure proper inhaler technique; arrange outpatient follow-up within 7 to 14 days."
                )
            )
            1 -> Quadruple(
                "Class II (Low-to-Intermediate Risk)",
                "1.0% in-hospital mortality",
                "Mildly elevated mortality risk. Inpatient medical ward admission or observation unit recommended.",
                listOf(
                    "Step 1 (Inpatient Admission): Admit to general medicine / respiratory ward for close observation and scheduled nebulizers.",
                    "Step 2 (Controlled Oxygen Therapy): Titrate supplemental oxygen targeting SpO2 88–92% using a 28% Venturi mask (avoid hyperoxia that worsens CO2 retention).",
                    "Step 3 (Medical Optimization): Regular nebulized bronchodilators + systemic steroids (Prednisolone 40 mg PO daily) + appropriate antibiotics.",
                    "Step 4 (Arterial Blood Gas): Obtain baseline ABG to check for hypercapnia and respiratory acidosis."
                )
            )
            2 -> Quadruple(
                "Class III (Moderate-High Risk)",
                "6.0% in-hospital mortality",
                "Significant risk of treatment failure and clinical deterioration. Hospital admission with high-dependency care capability required.",
                listOf(
                    "Step 1 (High-Dependency Admission): Admit to step-down / High Dependency Unit with continuous cardiorespiratory monitoring.",
                    "Step 2 (Arterial Blood Gas Evaluation): If pH < 7.35 and PaCO2 > 45 mmHg despite medical therapy: Initiate Non-Invasive Ventilation (BiPAP: IPAP 10–12 cmH2O, EPAP 4–5 cmH2O).",
                    "Step 3 (IV Therapeutics): Administer IV Methylprednisolone 40–60 mg q12h; consider IV Magnesium Sulfate 2g infusion over 20 min for severe bronchospasm.",
                    "Step 4 (Pseudomonas Screening): If frequent exacerbations or FEV1 < 30%: send sputum culture and use antipseudomonal antibiotic (Piperacillin-Tazobactam or Cefepime)."
                )
            )
            3 -> Quadruple(
                "Class IV (Severe Risk)",
                "14.1% in-hospital mortality",
                "Severe exacerbation with high mortality risk. Intensive Care Unit (ICU) admission and early ventilatory support indicated.",
                listOf(
                    "Step 1 (Urgent ICU Admission): Transfer immediately to the Intensive Care Unit.",
                    "Step 2 (Early NIV / BiPAP Trial): Immediate trial of BiPAP unless patient is severely obtunded, vomiting, or hemodynamically unstable.",
                    "Step 3 (Intubation Readiness): Prepare for endotracheal intubation if patient fails to improve on BiPAP within 1–2 hours (persistent acidosis pH < 7.25 or worsening lethargy).",
                    "Step 4 (Continuous Hemodynamic Line): Place arterial catheter for continuous blood pressure monitoring and frequent ABG draws."
                )
            )
            else -> Quadruple(
                "Class V (Extreme Critical Risk)",
                "> 25.0% in-hospital mortality",
                "Extreme risk of mortality and immediate respiratory arrest. Emergent invasive mechanical ventilation and critical care resuscitation required.",
                listOf(
                    "Step 1 (Immediate Critical Care Transfer): Emergent ICU resuscitation; notify on-duty critical care intensivist.",
                    "Step 2 (Invasive Mechanical Ventilation): Urgent endotracheal intubation and lung-protective mechanical ventilation with permissive hypercapnia (prolonged expiratory time to avoid auto-PEEP / dynamic hyperinflation).",
                    "Step 3 (Broad-Spectrum IV Therapy): IV Broad-spectrum antibiotics + IV Corticosteroids + continuous nebulized bronchodilators.",
                    "Step 4 (Central Line & Vasopressors): Secure central venous access; initiate Norepinephrine if post-intubation hypotension develops due to hyperinflation and decreased venous return."
                )
            )
        }

        return Bap65Result(score, cls, mort, interp, steps)
    }

    // =========================================================================
    // 22. NIH Stroke Scale (NIHSS) Screening
    // =========================================================================
    data class NihssResult(
        val totalScore: Int,
        val strokeSeverity: String,
        val thrombolysisCandidate: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateNihss(totalPoints: Int): NihssResult {
        val score = totalPoints.coerceIn(0, 42)

        val (sev, candidate, interp, steps) = when {
            score == 0 -> Quadruple(
                "No Stroke Symptoms (Score 0)",
                "Not indicated",
                "No focal neurological deficits detected on NIHSS.",
                listOf(
                    "Step 1 (Transient Ischemic Attack Evaluation): If transient focal deficits resolved completely: calculate ABCD2 score for TIA risk stratification.",
                    "Step 2 (Vascular Imaging): Order MRI Brain with DWI or CT Angiography of head and neck to rule out minor infarction or high-grade carotid stenosis.",
                    "Step 3 (Cardiac Workup): 12-lead ECG and echocardiogram to exclude cardioembolic sources (Atrial Fibrillation, mural thrombus).",
                    "Step 4 (Secondary Prevention): Start antiplatelet therapy (Aspirin 81–100 mg daily) and high-intensity Statin (Atorvastatin 80 mg daily)."
                )
            )
            score in 1..4 -> Quadruple(
                "Minor Stroke (Score $score / 42)",
                "Evaluate for disabling deficits",
                "Minor acute ischemic stroke. Consider IV thrombolysis if disabling deficit present (e.g. hemianopia, severe aphasia, or hand weakness).",
                listOf(
                    "Step 1 (Disabling Deficit Assessment): Determine if the minor deficit is clinically disabling for the patient's occupation/life; if disabling and within 4.5 hours: consider IV Thrombolysis (Tenecteplase 0.25 mg/kg or Alteplase 0.9 mg/kg).",
                    "Step 2 (Stat Non-Contrast CT): Immediate Non-contrast Head CT to exclude intracranial hemorrhage.",
                    "Step 3 (Dual Antiplatelet Therapy): If thrombolysis is NOT administered: start DAPT (Aspirin 100 mg + Clopidogrel 75 mg with 300 mg loading dose) for 21 days (POINT/CHANCE protocol).",
                    "Step 4 (Stroke Unit Care): Admit to certified Stroke Unit; monitor NIHSS every 4 hours to detect early neurological deterioration."
                )
            )
            score in 5..15 -> Quadruple(
                "Moderate Stroke (Score $score / 42)",
                "Prime Thrombolysis / Thrombectomy Candidate",
                "Moderate acute neurological deficit. High benefit from acute reperfusion therapy if within time windows.",
                listOf(
                    "Step 1 (EMERGENCY CODE STROKE): Immediate Code Stroke activation; target door-to-needle time < 45 minutes.",
                    "Step 2 (Stat CT & CT Angiography): STAT Non-contrast CT Head to exclude hemorrhage + CT Angiography (CTA) of Head and Neck to detect Large Vessel Occlusion (LVO).",
                    "Step 3 (IV Thrombolysis Window < 4.5h): If symptom onset < 4.5 hours and no contraindications: administer IV Tenecteplase 0.25 mg/kg IV bolus (max 25 mg) OR Alteplase 0.9 mg/kg IV (max 90 mg; 10% bolus, 90% over 60 min). Blood pressure must be < 185/110 mmHg (use IV Labetalol or Nicardipine).",
                    "Step 4 (Endovascular Thrombectomy Window < 24h): If CTA shows proximal anterior circulation occlusion (ICA, M1 segment of MCA): transfer immediately to Interventional Radiology for Endovascular Thrombectomy (EVT).",
                    "Step 5 (Dysphagia & Vitals): Strict NPO until bedside swallow screen; continuous cardiac telemetry and blood pressure monitoring in Neuro-ICU."
                )
            )
            score in 16..20 -> Quadruple(
                "Moderate-to-Severe Stroke (Score $score / 42)",
                "Urgent EVT & Thrombolysis Candidate",
                "Moderate-to-severe stroke. Very high likelihood of major arterial occlusion (ICA or proximal MCA).",
                listOf(
                    "Step 1 (Immediate Reperfusion Protocol): Expedited multi-modal neuroimaging (CT/CTA/CT Perfusion); urgent Thrombectomy suite activation.",
                    "Step 2 (IV Thrombolysis): Infuse IV Thrombolytic immediately if within 4.5h window; do not delay mechanical thrombectomy while waiting for thrombolytic infusion to complete.",
                    "Step 3 (Airway Protection): Closely evaluate bulbar reflexes and airway stability; prepare for intubation if GCS drops or aspiration risk is high.",
                    "Step 4 (Blood Pressure Targets): Maintain SBP < 180/105 mmHg for at least 24 hours post-thrombolysis; avoid hypotension (MAP > 85 mmHg) to preserve collateral penumbra.",
                    "Step 5 (Intensive Care Admission): Mandatory Neuro-ICU admission; serial NIHSS evaluations every 15 minutes during and 1 hour post-infusion."
                )
            )
            else -> Quadruple(
                "Severe Stroke (Score $score / 42)",
                "High Risk / Critical Thrombectomy Triage",
                "Severe stroke with massive hemispheric or basilar artery infarction. Significant risk of cerebral edema, herniation, and hemorrhagic transformation.",
                listOf(
                    "Step 1 (Stat CTA / Basilar Occlusion Check): Screen for Basilar Artery Occlusion (locked-in syndrome / coma) or complete ICA/M1 occlusion.",
                    "Step 2 (Mechanical Thrombectomy Triage): Proceed with emergent endovascular thrombectomy if penumbral tissue salvageable on perfusion imaging.",
                    "Step 3 (Airway & Hemodynamics): Secure endotracheal airway for coma or severe loss of consciousness; avoid hypoxemia and hyperthermia (target temp < 37.5°C).",
                    "Step 4 (Malignant Edema Surveillance): Monitor closely for midline shift; alert Neurosurgery early for potential decompressive hemicraniectomy within 48 hours for malignant MCA infarction.",
                    "Step 5 (Strict Post-Stroke Precautions): Postpone anticoagulation for at least 14 days; use intermittent pneumatic compression for DVT prophylaxis."
                )
            )
        }

        return NihssResult(score, sev, candidate, interp, steps)
    }

    // =========================================================================
    // 23. San Francisco Syncope Rule (SFSR)
    // =========================================================================
    data class SanFranciscoSyncopeResult(
        val hasAnyHighRiskFactor: Boolean,
        val riskTier: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateSanFranciscoSyncope(
        congestiveHeartFailure: Boolean,
        hematocritUnder30: Boolean,
        abnormalEcg: Boolean,
        shortnessOfBreath: Boolean,
        sbpUnder90: Boolean
    ): SanFranciscoSyncopeResult {
        val isHighRisk = congestiveHeartFailure || hematocritUnder30 || abnormalEcg || shortnessOfBreath || sbpUnder90

        val (tier, interp, steps) = if (!isHighRisk) {
            Triple(
                "Low Risk (0 CHESS Criteria)",
                "Low risk of 30-day serious cardiac outcomes or death. Highly sensitive for excluding immediate life-threatening syncope.",
                listOf(
                    "Step 1 (Exclude Vasovagal/Orthostatic): Confirm typical situational or orthostatic triggers (postural drop >20 mmHg SBP on standing).",
                    "Step 2 (Safe Outpatient Discharge): Discharge with reassurance and adequate hydration education provided patient is hemodynamically stable and ambulatory.",
                    "Step 3 (Outpatient Holter / Cardiology): Arrange outpatient 24–48 hour Holter monitoring or primary care review if recurrent episodes.",
                    "Step 4 (Precaution Instructions): Instruct patient to avoid sudden position changes, maintain fluid/salt intake, and return immediately if syncope recurs during exertion."
                )
            )
        } else {
            Triple(
                "High Risk (≥ 1 CHESS Criteria Present)",
                "High risk of serious adverse outcomes (arrhythmia, myocardial infarction, severe hemorrhage, structural heart disease, or sudden death) within 30 days.",
                listOf(
                    "Step 1 (Hospital Telemetry Admission): Admit patient to hospital for continuous cardiac telemetry monitoring.",
                    "Step 2 (12-Lead ECG Analysis): Thoroughly analyze 12-lead ECG for non-sinus rhythm, conduction disease (bifascicular block, Mobitz II), prolonged QTc, Brugada pattern, or ischemic ST-T changes.",
                    "Step 3 (Transthoracic Echocardiogram): Order urgent echocardiogram to evaluate Left Ventricular Ejection Fraction (LVEF), severe aortic stenosis, hypertrophic cardiomyopathy, or pericardial effusion.",
                    "Step 4 (Laboratory Diagnostics): Stat Serial Troponins (to rule out acute coronary syndrome) and Complete Blood Count (to rule out occult gastrointestinal hemorrhage if Hct < 30%).",
                    "Step 5 (Cardiology Consultation): Urgent Cardiology consultation for consideration of electrophysiology study (EPS) or permanent pacemaker / ICD placement."
                )
            )
        }

        return SanFranciscoSyncopeResult(isHighRisk, tier, interp, steps)
    }

    // =========================================================================
    // 24. Corrected Sodium for Hyperglycemia
    // =========================================================================
    data class CorrectedSodiumResult(
        val measuredSodium: Double,
        val glucoseMgDl: Double,
        val katzCorrectedNa: Double,
        val hillierCorrectedNa: Double,
        val fluidSelection: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateCorrectedSodium(
        measuredNa: Double,
        glucoseMgDl: Double
    ): CorrectedSodiumResult {
        if (measuredNa <= 0 || glucoseMgDl <= 0) {
            return CorrectedSodiumResult(0.0, 0.0, 0.0, 0.0, "Invalid Inputs", "Enter valid positive sodium and glucose.", emptyList())
        }

        val excessGlucose = max(0.0, glucoseMgDl - 100.0)
        val katzNa = measuredNa + (0.016 * excessGlucose)
        val hillierNa = measuredNa + (0.024 * excessGlucose)

        val roundedKatz = (katzNa * 10.0).roundToInt() / 10.0
        val roundedHillier = (hillierNa * 10.0).roundToInt() / 10.0

        val fluidRec = when {
            roundedHillier >= 145.0 -> "0.45% Saline (Half-Normal Saline) - Severe Hypertonicity"
            roundedHillier >= 135.0 && roundedHillier <= 144.9 -> "0.45% Saline (Half-Normal Saline) - Euvolemic Maintenance"
            else -> "0.9% Normal Saline - True Hyponatremia"
        }

        val interp = "In marked hyperglycemia, osmotic fluid shift from intracellular to extracellular space dilutes serum sodium. Corrected sodium reflects the patient's true effective intravascular osmolar status."

        val steps = listOf(
            "Step 1 (Initial Fluid Resuscitation): Regardless of corrected sodium, infuse 0.9% Normal Saline at 1000–1500 mL/hr during the first 1 to 2 hours for acute hypovolemic restoration.",
            "Step 2 (Fluid Choice Post-Initial Resuscitation): Evaluate Corrected Sodium: If Corrected Na is NORMAL or HIGH (≥ 135 mEq/L), switch to 0.45% Half-Normal Saline (250–500 mL/hr) to replace free water deficit; if Corrected Na remains LOW (< 135 mEq/L), continue 0.9% Normal Saline.",
            "Step 3 (Potassium Check Before Insulin): DO NOT start IV Insulin if serum K+ < 3.3 mEq/L! Replete potassium first to avoid fatal arrhythmias; start insulin (0.1 U/kg/hr) once K+ ≥ 3.3 mEq/L.",
            "Step 4 (Add Dextrose when Glucose drops): When blood glucose reaches 200–250 mg/dL in DKA (or 250–300 mg/dL in HHS), immediately add 5% Dextrose (D5W with 0.45% Saline) to maintain euglycemia while continuing insulin until ketoacidosis resolution."
        )

        return CorrectedSodiumResult(measuredNa, glucoseMgDl, roundedKatz, roundedHillier, fluidRec, interp, steps)
    }

    // =========================================================================
    // 25. Berlin Criteria for ARDS (P/F Ratio & Lung-Protective Ventilation)
    // =========================================================================
    data class BerlinArdsResult(
        val pfRatio: Double,
        val ardsSeverity: String,
        val estimatedMortality: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateBerlinArds(
        pao2MmHg: Double,
        fio2Percent: Double,
        peepCmH2o: Double
    ): BerlinArdsResult {
        if (pao2MmHg <= 0 || fio2Percent <= 0) {
            return BerlinArdsResult(0.0, "Invalid Inputs", "N/A", "Enter valid positive PaO2 and FiO2 values.", emptyList())
        }

        val fio2Fraction = fio2Percent / 100.0
        val ratio = (pao2MmHg / fio2Fraction)
        val roundedPf = (ratio * 10.0).roundToInt() / 10.0

        val (sev, mort, interp, steps) = when {
            peepCmH2o < 5.0 -> Quadruple(
                "Non-Diagnostic for ARDS (PEEP < 5 cmH2O)",
                "Variable",
                "Berlin definition requires a minimum PEEP of ≥ 5 cmH2O (invasive or non-invasive CPAP). Current P/F is $roundedPf, but PEEP criterion is not met.",
                listOf(
                    "Step 1 (Optimize PEEP): Increase PEEP to at least 5 cmH2O on mechanical ventilation or CPAP mask to assess true physiological shunt.",
                    "Step 2 (Clinical Context): Verify that acute hypoxemia occurred within 1 week of a known clinical insult (sepsis, pneumonia, aspiration, pancreatitis, trauma).",
                    "Step 3 (Exclude Cardiogenic Edema): Perform bedside echocardiogram to ensure pulmonary edema is not solely explained by cardiac failure or volume overload."
                )
            )
            roundedPf > 300.0 -> Quadruple(
                "No ARDS (Normal / Mild Hypoxemia)",
                "< 15% mortality",
                "P/F ratio is > 300 mmHg. Does not meet Berlin definition for Acute Respiratory Distress Syndrome.",
                listOf(
                    "Step 1 (Maintain Therapy): Continue current oxygen delivery / ventilator settings; wean supplemental FiO2 as tolerated.",
                    "Step 2 (Surveillance): Monitor serial blood gases and pulmonary compliance if patient remains at high risk for secondary lung injury."
                )
            )
            roundedPf > 200.0 && roundedPf <= 300.0 -> Quadruple(
                "Mild ARDS (200 < P/F ≤ 300 mmHg)",
                "~27% ICU mortality",
                "Mild ARDS according to Berlin consensus definition (PEEP ≥ 5 cmH2O). High risk of progression if lung injury is not mitigated.",
                listOf(
                    "Step 1 (Lung-Protective Ventilation): Set tidal volume strictly to 6 mL/kg of Predicted Body Weight (PBW); limit plateau pressure (Pplat) < 30 cmH2O and driving pressure < 14 cmH2O.",
                    "Step 2 (PEEP Titration): Apply moderate PEEP (5–10 cmH2O) according to ARDSNet lower PEEP/higher FiO2 protocol; target SpO2 88–95% (PaO2 55–80 mmHg).",
                    "Step 3 (Conservative Fluid Management): Implement conservative fluid strategy (FACTS protocol: neutral to negative daily fluid balance) once hemodynamic shock has resolved.",
                    "Step 4 (Etiology Treatment): Aggressively treat underlying cause (source-control antibiotics for pneumonia/sepsis, drainage of intra-abdominal sepsis)."
                )
            )
            roundedPf > 100.0 && roundedPf <= 200.0 -> Quadruple(
                "Moderate ARDS (100 < P/F ≤ 200 mmHg)",
                "~32% ICU mortality",
                "Moderate ARDS. Substantial alveolar collapse and ventilation-perfusion mismatch. Escalation of respiratory support required.",
                listOf(
                    "Step 1 (Strict Low Tidal Volume): Maintain 6 mL/kg PBW (titrate down to 4 mL/kg if Pplat > 30 cmH2O); tolerate permissive hypercapnia (target arterial pH ≥ 7.20).",
                    "Step 2 (Higher PEEP Strategy): Titrate higher PEEP (10–14 cmH2O) using ARDSNet higher PEEP table; assess alveolar recruitability.",
                    "Step 3 (Early Prone Positioning): If P/F remains < 150 mmHg despite PEEP optimization: initiate prone positioning immediately for at least 16 consecutive hours daily (PROSEVA trial: 16% absolute mortality reduction).",
                    "Step 4 (Sedation & Synchrony): Optimize analgesia and sedation to eliminate patient-ventilator dyssynchrony and coughing against the ventilator."
                )
            )
            else -> Quadruple(
                "Severe ARDS (P/F ≤ 100 mmHg)",
                "~45% ICU mortality",
                "Severe ARDS. Critical refractory hypoxemia with high risk of right ventricular failure (cor pulmonale) and death. Emergent multimodality rescue indicated.",
                listOf(
                    "Step 1 (Immediate Prone Positioning): Mandatory prone ventilation for ≥ 16 hours daily; do not delay prone positioning in severe ARDS.",
                    "Step 2 (Neuromuscular Blockade): Initiate continuous infusion of Cisatracurium for up to 48 hours to abolish ventilator dyssynchrony and decrease oxygen consumption.",
                    "Step 3 (Recruitment & PEEP): High PEEP (14–18 cmH2O); monitor right heart function on bedside echo (prevent PEEP-induced RV failure / septal shifting).",
                    "Step 4 (Inhaled Pulmonary Vasodilators): Consider Inhaled Epoprostenol (Prostacyclin) or Inhaled Nitric Oxide (iNO 10–20 ppm) as rescue bridge to improve V/Q matching.",
                    "Step 5 (VV-ECMO Evaluation): Evaluate immediately for Venovenous Extracorporeal Membrane Oxygenation (VV-ECMO) if P/F < 80 for > 6h or pH < 7.15 despite lung-protective measures (EOLIA criteria)."
                )
            )
        }

        return BerlinArdsResult(roundedPf, sev, mort, interp, steps)
    }

    // =========================================================================
    // 26. Lactate Clearance in Sepsis & Septic Shock
    // =========================================================================
    data class LactateClearanceResult(
        val initialLactate: Double,
        val repeatLactate: Double,
        val clearancePercent: Double,
        val resuscitationStatus: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateLactateClearance(
        initialLactateMmol: Double,
        repeatLactateMmol: Double,
        hoursInterval: Double = 2.0
    ): LactateClearanceResult {
        if (initialLactateMmol <= 0) {
            return LactateClearanceResult(0.0, 0.0, 0.0, "Invalid", "Enter a positive baseline lactate value.", emptyList())
        }

        val clearance = ((initialLactateMmol - repeatLactateMmol) / initialLactateMmol) * 100.0
        val rounded = (clearance * 10.0).roundToInt() / 10.0

        val (status, interp, steps) = when {
            rounded >= 20.0 -> Triple(
                "Excellent Resuscitation (Clearance ≥ 20%)",
                "Lactate cleared by $rounded% over ~$hoursInterval hours. Indicates robust tissue reperfusion, restoration of microvascular flow, and favorable response to resuscitation.",
                listOf(
                    "Step 1 (Consolidate Resuscitation): Continue targeted resuscitation strategy; maintain MAP ≥ 65 mmHg.",
                    "Step 2 (Wean Vasopressors): Gradually de-escalate vasopressor support as perfusion indicators (capillary refill, urine output) remain normal.",
                    "Step 3 (Surveillance): Repeat serum lactate every 4 hours until completely normalized (< 2.0 mmol/L)."
                )
            )
            rounded >= 10.0 && rounded < 20.0 -> Triple(
                "Adequate Resuscitation (Clearance 10%–20%)",
                "Lactate cleared by $rounded% over ~$hoursInterval hours. Meets Surviving Sepsis Campaign minimum clearance target of ≥ 10% every 2 hours.",
                listOf(
                    "Step 1 (Maintain Perfusion): Maintain MAP ≥ 65 mmHg; track hourly urine output (target > 0.5 mL/kg/hr).",
                    "Step 2 (Assess Dynamic Fluid Responsiveness): Check passive leg raise or pulse pressure variation before infusing additional crystalloids to avoid fluid overload.",
                    "Step 3 (Repeat Interval): Repeat serum lactate in 2 to 4 hours to verify sustained clearance towards normal."
                )
            )
            rounded > 0.0 && rounded < 10.0 -> Triple(
                "Suboptimal Clearance (< 10%)",
                "Lactate cleared by only $rounded%. Indicates persistent occult tissue hypoperfusion, ongoing cellular dysoxia, or delayed source control.",
                listOf(
                    "Step 1 (Hemodynamic Re-evaluation): Check central venous oxygen saturation (ScvO2 > 70%) or bedside cardiac ultrasound (VTI, ejection fraction).",
                    "Step 2 (Inotropic Support): Consider adding Dobutamine infusion (2.5–20 mcg/kg/min) if septic myocardial dysfunction is present.",
                    "Step 3 (Urgent Source Control Review): Screen for missed deep abscess, empyema, infected prosthetic device, or bowel ischemia requiring surgical laparotomy.",
                    "Step 4 (Repeat Stat): Re-check arterial/venous lactate strictly within 2 hours."
                )
            )
            else -> Triple(
                "Lactate Accumulation / Rising Lactate (Clearance: $rounded%)",
                "Serum lactate increased from $initialLactateMmol to $repeatLactateMmol mmol/L. Severe indicator of ongoing shock, anaerobic metabolism, and impending multiorgan failure.",
                listOf(
                    "Step 1 (EMERGENCY CRITICAL CARE REVIEW): Immediate intensivist bedside evaluation and arterial line placement.",
                    "Step 2 (Second-Line Vasopressor): Add Vasopressin infusion (0.03 U/min fixed dose) to Norepinephrine; consider stress-dose IV Hydrocortisone (200 mg/day).",
                    "Step 3 (Blood Product Transfusion): Transfuse packed red blood cells if hemoglobin < 7.0 g/dL to optimize systemic oxygen delivery.",
                    "Step 4 (Comprehensive Diagnostic CT): STAT Contrast-Enhanced CT of abdomen/chest to search for catastrophic surgical catastrophe (e.g. mesenteric ischemia, perforated hollow viscus)."
                )
            )
        }

        return LactateClearanceResult(initialLactateMmol, repeatLactateMmol, rounded, status, interp, steps)
    }

    // =========================================================================
    // 27. Ottawa Ankle & Foot Rules
    // =========================================================================
    data class OttawaAnkleResult(
        val ankleXrayIndicated: Boolean,
        val footXrayIndicated: Boolean,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateOttawaAnkle(
        inabilityToBearWeight: Boolean,
        lateralMalleolusTenderness: Boolean,
        medialMalleolusTenderness: Boolean,
        fifthMetatarsalTenderness: Boolean,
        navicularTenderness: Boolean
    ): OttawaAnkleResult {
        val ankleIndicated = inabilityToBearWeight || lateralMalleolusTenderness || medialMalleolusTenderness
        val footIndicated = inabilityToBearWeight || fifthMetatarsalTenderness || navicularTenderness

        val interp = buildString {
            if (!ankleIndicated && !footIndicated) {
                append("Neither Ankle nor Foot X-ray is required. Ottawa Ankle Rules are negative with > 98.5% sensitivity for ruling out clinically significant fractures.")
            } else {
                append("Plain radiography IS indicated: ")
                if (ankleIndicated && footIndicated) append("Both Ankle series and Foot series radiographs required.")
                else if (ankleIndicated) append("Ankle series radiographs (AP, Lateral, Mortise views) required.")
                else append("Foot series radiographs (AP, Lateral, Oblique views) required.")
            }
        }

        val steps = if (!ankleIndicated && !footIndicated) {
            listOf(
                "Step 1 (No X-ray Needed): Plain radiographs are not indicated; reassure patient regarding absence of bone fracture.",
                "Step 2 (Conservative PRICE Protocol): Protection (semi-rigid brace or elastic bandage), Rest, Ice packs for 15–20 min every 2–3 hours, Compression, and Elevation above heart level.",
                "Step 3 (Analgesia): Prescribe oral Paracetamol (Acetaminophen) and short-course NSAID (Ibuprofen 400 mg TID or Naproxen 500 mg BID) with food.",
                "Step 4 (Weight Bearing): Encourage early functional weight-bearing as tolerated to accelerate ligamentous recovery.",
                "Step 5 (Re-evaluation): Instruct patient to return for repeat clinical examination if unable to bear weight after 5 to 7 days."
            )
        } else {
            listOf(
                "Step 1 (Radiographic Order): Obtain designated X-ray views: Ankle (AP, Lateral, Mortise) and/or Foot (AP, Lateral, Oblique).",
                "Step 2 (Splinting & Immobilization): Apply posterior U-slab / stirrup splint in neutral 90° dorsiflexion while awaiting X-ray results.",
                "Step 3 (Neurovascular Check): Verify distal dorsal and posterior tibial pulses, capillary refill (<2s), and peroneal/tibial nerve sensation.",
                "Step 4 (Orthopedic Triage): If fracture is identified: evaluate for mortise widening / syndesmotic injury (Maisonneuve fracture) and consult Orthopedics."
            )
        }

        return OttawaAnkleResult(ankleIndicated, footIndicated, interp, steps)
    }

    // =========================================================================
    // 28. Ottawa Knee Rule
    // =========================================================================
    data class OttawaKneeResult(
        val xrayIndicated: Boolean,
        val positiveCriteriaCount: Int,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateOttawaKnee(
        age55OrOlder: Boolean,
        isolatedPatellaTenderness: Boolean,
        fibulaHeadTenderness: Boolean,
        inabilityToFlex90: Boolean,
        inabilityToBearWeight: Boolean
    ): OttawaKneeResult {
        var count = 0
        if (age55OrOlder) count++
        if (isolatedPatellaTenderness) count++
        if (fibulaHeadTenderness) count++
        if (inabilityToFlex90) count++
        if (inabilityToBearWeight) count++

        val indicated = count > 0

        val (interp, steps) = if (!indicated) {
            Pair(
                "Knee X-ray is NOT indicated. Ottawa Knee Rule is negative (100% sensitivity for detecting acute knee fractures in clinical trials).",
                listOf(
                    "Step 1 (Avoid Radiation): Reassure patient; plain knee radiography is safely omitted.",
                    "Step 2 (Symptomatic Care): Apply knee compression support sleeve, ice therapy, and elevation.",
                    "Step 3 (Analgesia): Prescribe oral analgesics (Acetaminophen or topical/oral NSAID).",
                    "Step 4 (Mobilization): Ambulate with assistance as tolerated; avoid vigorous pivoting or sports.",
                    "Step 5 (Follow-up): Arrange outpatient review in 7 days if joint effusion or persistent pain prevents normal walking."
                )
            )
        } else {
            Pair(
                "Knee X-ray IS indicated ($count high-risk criteria present). Plain radiographs required to exclude acute knee fracture.",
                listOf(
                    "Step 1 (Radiographic Views): Order standard Knee Radiograph Series (AP, Lateral, and Skyline/Sunrise views for patella).",
                    "Step 2 (Knee Immobilization): Apply straight knee brace / immobilizer to prevent displacement of occult patellar or tibial plateau fracture.",
                    "Step 3 (Non-Weight Bearing): Instruct strict non-weight bearing with crutches until X-rays are reviewed.",
                    "Step 4 (Ligamentous Assessment): If fracture is ruled out on X-ray but joint hemarthrosis is present: evaluate for ACL rupture or meniscal tear; arrange outpatient MRI."
                )
            )
        }

        return OttawaKneeResult(indicated, count, interp, steps)
    }

    // =========================================================================
    // 29. Caprini Score for Venous Thromboembolism (Surgical VTE Prophylaxis)
    // =========================================================================
    data class CapriniResult(
        val totalScore: Int,
        val riskTier: String,
        val baselineVteRisk: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateCaprini(totalPoints: Int): CapriniResult {
        val score = totalPoints.coerceAtLeast(0)

        val (tier, risk, interp, steps) = when (score) {
            0 -> Quadruple(
                "Lowest Risk (Score 0)",
                "< 0.5% VTE risk without prophylaxis",
                "Lowest risk for post-operative venous thromboembolism. Routine pharmacologic thromboprophylaxis is not indicated.",
                listOf(
                    "Step 1 (Early Ambulation): Emphasize early, aggressive, and frequent post-operative ambulation.",
                    "Step 2 (Hydration): Ensure adequate oral or IV hydration.",
                    "Step 3 (Medication): No pharmacologic anticoagulant prophylaxis needed."
                )
            )
            in 1..2 -> Quadruple(
                "Low Risk (Score 1–2)",
                "~1.5% VTE risk without prophylaxis",
                "Low post-operative VTE risk. Mechanical prophylaxis is preferred.",
                listOf(
                    "Step 1 (Mechanical Prophylaxis): Intermittent Pneumatic Compression (IPC) devices or graduated compression stockings during hospital stay.",
                    "Step 2 (Ambulation): Mobilize out of bed on post-operative day 0–1.",
                    "Step 3 (Anticoagulation): Pharmacologic prophylaxis not routinely recommended unless mechanical devices are contraindicated."
                )
            )
            in 3..4 -> Quadruple(
                "Moderate Risk (Score 3–4)",
                "~3.0% VTE risk without prophylaxis",
                "Moderate VTE risk. Combined mechanical prophylaxis or pharmacologic anticoagulation indicated.",
                listOf(
                    "Step 1 (Pharmacologic Prophylaxis): Initiate Low-Molecular-Weight Heparin (LMWH: Enoxaparin 40 mg SC once daily) OR Unfractionated Heparin (5,000 units SC q12h).",
                    "Step 2 (Mechanical Adjunct): Utilize continuous Intermittent Pneumatic Compression (IPC) while in bed.",
                    "Step 3 (Duration): Continue prophylaxis until fully ambulatory and discharged from hospital."
                )
            )
            in 5..8 -> Quadruple(
                "High Risk (Score 5–8)",
                "~6.0% VTE risk without prophylaxis",
                "High VTE risk. Dual prophylaxis (pharmacologic + mechanical) strongly recommended.",
                listOf(
                    "Step 1 (Dual Prophylaxis): Both pharmacologic anticoagulation (Enoxaparin 40 mg SC daily or 30 mg SC q12h) AND Intermittent Pneumatic Compression (IPC).",
                    "Step 2 (Timing): First dose 12 hours pre-operatively or 12–24 hours post-operatively once surgical hemostasis is confirmed.",
                    "Step 3 (Extended Duration): For major abdominal or pelvic cancer resection: continue extended-duration LMWH for 28 days post-operatively.",
                    "Step 4 (Bleeding Vigilance): Monitor surgical drains and hemoglobin levels."
                )
            )
            else -> Quadruple(
                "Highest Risk (Score ≥ 9 [Score: $score])",
                "> 11.0% VTE risk without prophylaxis",
                "Highest VTE risk. Aggressive dual prophylaxis and extended post-discharge treatment mandatory.",
                listOf(
                    "Step 1 (Mandatory Dual Modality): LMWH (Enoxaparin 40 mg SC daily adjusted for renal function) PLUS sequential Intermittent Pneumatic Compression (IPC).",
                    "Step 2 (Extended 4-Week Prophylaxis): Prescribe outpatient LMWH or Direct Oral Anticoagulant (DOAC) for 28 to 35 days post-discharge.",
                    "Step 3 (Mechanical Precaution): If active bleeding precludes anticoagulation: apply continuous bilateral IPC; initiate pharmacologic anticoagulation as soon as bleeding ceases.",
                    "Step 4 (Vascular Surveillance): Maintain low threshold for venous duplex ultrasound if unexplained tachycardia or unilateral leg edema occurs."
                )
            )
        }

        return CapriniResult(score, tier, risk, interp, steps)
    }

    // =========================================================================
    // 30. CRUSADE Bleeding Score in Acute Coronary Syndrome
    // =========================================================================
    data class CrusadeResult(
        val totalScore: Int,
        val riskTier: String,
        val inHospitalMajorBleedRate: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateCrusade(totalPoints: Int): CrusadeResult {
        val score = totalPoints.coerceIn(0, 100)

        val (tier, rate, interp, steps) = when {
            score <= 20 -> Quadruple(
                "Very Low Risk (Score ≤ 20)",
                "3.1% major bleeding rate",
                "Very low probability of in-hospital major bleeding during ACS management.",
                listOf(
                    "Step 1 (Standard DAPT): Proceed with guideline-directed Dual Antiplatelet Therapy (Aspirin + Ticagrelor 90 mg BID or Prasugrel 10 mg daily).",
                    "Step 2 (Anticoagulation): Standard procedural anticoagulation (Unfractionated Heparin or Enoxaparin).",
                    "Step 3 (Routine Monitoring): Check baseline CBC and renal function."
                )
            )
            score in 21..30 -> Quadruple(
                "Low Risk (Score 21–30)",
                "5.5% major bleeding rate",
                "Low bleeding risk. Standard antithrombotic therapy well tolerated.",
                listOf(
                    "Step 1 (Standard ACS Care): Proceed with standard antiplatelet and anticoagulant regimens.",
                    "Step 2 (Vascular Access): Prefer radial artery access for percutaneous coronary intervention (reduces vascular access site bleeding).",
                    "Step 3 (Gastric Protection): Co-prescribe Proton Pump Inhibitor (Pantoprazole 40 mg daily) if age ≥ 65 or history of peptic ulcer."
                )
            )
            score in 31..40 -> Quadruple(
                "Moderate Risk (Score 31–40)",
                "8.6% major bleeding rate",
                "Moderate bleeding risk. Meticulous dosing of antithrombotics required.",
                listOf(
                    "Step 1 (Radial First Strategy): Mandatory radial artery access over femoral approach for coronary angiography.",
                    "Step 2 (Renal Dose Adjustments): Strictly adjust Enoxaparin, Bivalirudin, and Fondaparinux doses to baseline creatinine clearance.",
                    "Step 3 (PPI Prophylaxis): Routine Proton Pump Inhibitor co-prescription with DAPT.",
                    "Step 4 (Monitoring): Daily complete blood counts to detect occult drop in hemoglobin."
                )
            )
            score in 41..50 -> Quadruple(
                "High Risk (Score 41–50)",
                "11.9% major bleeding rate",
                "High bleeding risk. Consider safer antithrombotic strategies and shorter DAPT duration.",
                listOf(
                    "Step 1 (P2Y12 Inhibitor Choice): Consider Clopidogrel (75 mg daily) over more potent Ticagrelor/Prasugrel to reduce major bleeding hazard.",
                    "Step 2 (Anticoagulation Choice): Prefer Bivalirudin over Heparin + GPIIb/IIIa inhibitors during catheterization.",
                    "Step 3 (Shortened DAPT): Plan for shortened DAPT duration (e.g. 1–3 months followed by P2Y12 or Aspirin monotherapy).",
                    "Step 4 (Avoid Triple Therapy): If patient has Atrial Fibrillation: DO NOT use Triple Therapy (Aspirin + P2Y12 + DOAC); use Dual Therapy (DOAC + Clopidogrel without Aspirin)."
                )
            )
            else -> Quadruple(
                "Very High Risk (Score > 50 [Score: $score])",
                "19.5% major bleeding rate",
                "Very high bleeding risk (~1 in 5 patients suffers major bleed). Extreme caution with antithrombotic regimens.",
                listOf(
                    "Step 1 (Minimize Antithrombotic Intensity): Clopidogrel 75 mg daily preferred; avoid glycoprotein IIb/IIIa inhibitors completely.",
                    "Step 2 (Radial Access & Hemostasis): Radial access mandatory; use closure devices if femoral puncture unavoidable.",
                    "Step 3 (Proton Pump Inhibitor): High-dose PPI therapy (Pantoprazole 40 mg BID).",
                    "Step 4 (Ultra-Short DAPT): Limit DAPT to 1 month post-DES, then switch to single antiplatelet monotherapy (MASTER-DAPT trial).",
                    "Step 5 (Transfusion Protocol): Maintain restrictive transfusion threshold (transfuse only if Hb < 7–8 g/dL or active hemodynamic instability)."
                )
            )
        }

        return CrusadeResult(score, tier, rate, interp, steps)
    }

    // =========================================================================
    // 31. APGAR Score & Neonatal Resuscitation Guide
    // =========================================================================
    data class ApgarResult(
        val totalScore: Int,
        val clinicalStatus: String,
        val resuscitationTier: String,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculateApgar(
        appearancePts: Int,
        pulsePts: Int,
        grimacePts: Int,
        activityPts: Int,
        respirationPts: Int
    ): ApgarResult {
        val score = (appearancePts.coerceIn(0, 2) +
                pulsePts.coerceIn(0, 2) +
                grimacePts.coerceIn(0, 2) +
                activityPts.coerceIn(0, 2) +
                respirationPts.coerceIn(0, 2))

        val (status, tier, interp, steps) = when {
            score >= 7 -> Quadruple(
                "Normal / Vigorous Newborn (Score $score / 10)",
                "Routine Postnatal Care",
                "Reassuring transition to extrauterine life. Infant is vigorous with stable cardiorespiratory drive.",
                listOf(
                    "Step 1 (Thermal Care): Dry infant thoroughly, discard wet towels, maintain warm room temperature (23–25°C).",
                    "Step 2 (Skin-to-Skin): Place newborn in skin-to-skin contact with mother; cover with dry warm blanket and cap.",
                    "Step 3 (Airway): Do not perform routine suctioning if infant is breathing comfortably and crying.",
                    "Step 4 (Breastfeeding): Initiate early breastfeeding within the first hour of birth.",
                    "Step 5 (Repeat Assessment): Calculate 5-minute APGAR score (and 10-minute if 5-minute score < 7)."
                )
            )
            score in 4..6 -> Quadruple(
                "Moderately Depressed Newborn (Score $score / 10)",
                "Active Neonatal Resuscitation Required",
                "Mild-to-moderate cardiorespiratory depression. Requires immediate intervention under Neonatal Resuscitation Program (NRP) guidelines.",
                listOf(
                    "Step 1 (Clear Airway & Stimulate): Position head in 'sniffing' position; suction mouth then nose gently with bulb syringe; rub back or flick soles.",
                    "Step 2 (Positive Pressure Ventilation - PPV): If apnea, gasping, or HR < 100 bpm despite 30 seconds of stimulation: initiate Positive Pressure Ventilation (PPV) immediately at 40–60 breaths/min using bag-valve-mask or T-piece resuscitator.",
                    "Step 3 (Oxygen Concentration): Start PPV with room air (21% O2 for term infants; 21–30% for preterm <35 weeks); attach pulse oximeter probe to right wrist (pre-ductal).",
                    "Step 4 (Evaluate Heart Rate): Check HR after 15 seconds of PPV; if chest not moving: implement MR. SOPA ventilation corrective steps (Mask adjustment, Reposition airway, Suction, Open mouth, Pressure increase, Alternative airway).",
                    "Step 5 (Repeat APGAR): Recalculate APGAR strictly at 5 and 10 minutes."
                )
            )
            else -> Quadruple(
                "Severely Depressed Newborn (Score $score / 10)",
                "EMERGENCY ADVANCED LIFE SUPPORT (NRP)",
                "Critical neonatal depression. High risk of severe asphyxia, hypoxic-ischemic encephalopathy (HIE), and mortality. Immediate advanced resuscitation mandatory.",
                listOf(
                    "Step 1 (EMERGENCY CODE CALL): Call immediate Neonatal Intensive Care / Pediatric resuscitation team to delivery room.",
                    "Step 2 (Immediate Effective PPV): Begin Positive Pressure Ventilation (PPV) within 60 seconds of birth ('The Golden Minute'); monitor bilateral chest rise.",
                    "Step 3 (Chest Compressions if HR < 60): If heart rate remains < 60 bpm despite 30 seconds of effective PPV that moves the chest: initiate 3:1 Chest Compressions (90 compressions + 30 breaths per minute) using two-thumb encircling-hands technique; increase oxygen to 100% FiO2.",
                    "Step 4 (Endotracheal Intubation): Intubate trachea with appropriate sized endotracheal tube (size 3.0 for term, 2.5 for preterm) without interrupting resuscitation.",
                    "Step 5 (Emergency Epinephrine & Line Access): Place emergency Umbilical Venous Catheter (UVC); administer IV Epinephrine (0.02 mg/kg [0.2 mL/kg of 1:10,000 solution]); consider normal saline bolus (10 mL/kg over 10 min) if hypovolemic shock / blood loss.",
                    "Step 6 (Therapeutic Hypothermia): If term newborn with signs of moderate-severe encephalopathy: screen for Therapeutic Hypothermia protocol (target core temp 33.5°C within 6 hours of birth)."
                )
            )
        }

        return ApgarResult(score, status, tier, interp, steps)
    }

    // =========================================================================
    // 32. Potassium Deficit & Safe Replacement Calculator
    // =========================================================================
    data class PotassiumDeficitResult(
        val serumK: Double,
        val estimatedDeficitMeq: Double,
        val severity: String,
        val maxPeripheralRateMeqHr: Double,
        val interpretation: String,
        val nextSteps: List<String>
    )

    fun calculatePotassiumDeficit(
        weightKg: Double,
        serumKMeqL: Double
    ): PotassiumDeficitResult {
        if (weightKg <= 0 || serumKMeqL <= 0) {
            return PotassiumDeficitResult(0.0, 0.0, "Invalid", 10.0, "Enter valid weight and potassium values.", emptyList())
        }

        // Physiological rule: For each 0.1 mEq/L drop below 4.0 mEq/L, total body deficit is approx 30-35 mEq in 70kg adult (~0.45 mEq/kg per 0.1 drop)
        val dropBelowNormal = max(0.0, 4.0 - serumKMeqL)
        val deficit = (dropBelowNormal * 10.0) * (weightKg * 0.45)
        val roundedDeficit = (deficit * 10.0).roundToInt() / 10.0

        val (sev, maxRate, interp, steps) = when {
            serumKMeqL >= 3.5 -> Quadruple(
                "Normal Potassium (≥ 3.5 mEq/L)",
                10.0,
                "Serum potassium is within normal reference range (3.5–5.0 mEq/L). Total body deficit: $roundedDeficit mEq.",
                listOf(
                    "Step 1 (Maintain Intake): Ensure normal dietary potassium intake (~40–80 mEq/day) or standard maintenance IV fluids with 20 mEq KCl/L.",
                    "Step 2 (Monitoring): Routine electrolyte monitoring if patient is receiving loop/thiazide diuretics or insulin."
                )
            )
            serumKMeqL in 3.0..3.4 -> Quadruple(
                "Mild Hypokalemia (3.0–3.4 mEq/L)",
                10.0,
                "Mild potassium deficit of approximately $roundedDeficit mEq. Oral replacement is preferred, safest, and most effective.",
                listOf(
                    "Step 1 (Oral Potassium Preferred): Prescribe oral Potassium Chloride (KCl) 20–40 mEq PO 2 to 3 times daily with meals (oral route avoids severe chemical phlebitis and accidental hyperkalemia).",
                    "Step 2 (Check Serum Magnesium): Check Serum Magnesium immediately! Hypomagnesemia impairs renal Na+/K+-ATPase and causes refractory urinary potassium wasting; replete Magnesium (oral or 2g IV MgSO4) if Mg < 2.0 mg/dL.",
                    "Step 3 (Identify Trigger): Review medication list for loop diuretics, thiazides, corticosteroids, or high-dose beta-agonists; consider potassium-sparing diuretic (Spironolactone) if chronic diuretic use.",
                    "Step 4 (Follow-up): Repeat serum potassium level in 24 to 48 hours."
                )
            )
            serumKMeqL in 2.5..2.9 -> Quadruple(
                "Moderate Hypokalemia (2.5–2.9 mEq/L)",
                10.0,
                "Moderate potassium deficit of approximately $roundedDeficit mEq. Significant risk of cardiac arrhythmias, muscle weakness, and ileus.",
                listOf(
                    "Step 1 (Combined Oral & IV Route): Administer oral KCl (40 mEq PO q4–6h) PLUS IV infusion of KCl (10–20 mEq/hr).",
                    "Step 2 (Infusion Rate Limits): Peripheral line max rate: 10 mEq/hr (concentration max 40 mEq/L to prevent severe burning and venous sclerosis); Central line max rate: 20 mEq/hr.",
                    "Step 3 (Mandatory ECG & Cardiac Telemetry): Obtain 12-lead ECG to screen for flattened T waves, ST depression, prominent U waves, or prolonged QTc; place on continuous cardiac telemetry.",
                    "Step 4 (Stat Magnesium Repletion): Administer IV Magnesium Sulfate 2g in 100 mL D5W over 1 hour.",
                    "Step 5 (Repeat Interval): Repeat serum potassium strictly 2 to 4 hours post-infusion."
                )
            )
            else -> Quadruple(
                "Severe / Critical Hypokalemia (< 2.5 mEq/L)",
                20.0,
                "Severe life-threatening hypokalemia. Total body deficit exceeds $roundedDeficit mEq. High risk of fatal ventricular arrhythmias (Torsades de pointes, VFib), paralysis, and respiratory arrest.",
                listOf(
                    "Step 1 (EMERGENCY ICU / TELEMETRY ADMISSION): Immediate transfer to High Dependency or Intensive Care Unit; continuous ECG telemetry.",
                    "Step 2 (High-Concentration Central IV Infusion): Infuse IV KCl via Central Venous Catheter at 20 mEq/hr (using dedicated infusion pump); do NOT infuse through peripheral line at this rate.",
                    "Step 3 (Concurrent Oral Potassium): Give oral KCl liquid or effervescent tablets (40 mEq PO q4h) concurrently if patient is conscious and has functioning GI tract.",
                    "Step 4 (Stat IV Magnesium): Give IV Magnesium Sulfate 2g to 4g immediately.",
                    "Step 5 (Frequent Blood Draws): Check repeat serum potassium strictly every 2 to 3 hours until K+ > 3.0 mEq/L, then every 4 to 6 hours.",
                    "Step 6 (Avoid Glucose-Only Fluids): DO NOT infuse Potassium in plain Dextrose fluids (D5W triggers endogenous insulin secretion, which shifts potassium intracellularly and causes paradoxically worsening hypokalemia); infuse in 0.9% Normal Saline."
                )
            )
        }

        return PotassiumDeficitResult(serumKMeqL, roundedDeficit, sev, maxRate, interp, steps)
    }
}
