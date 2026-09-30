package com.example.data.calculator

import kotlin.math.ln
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
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
}
