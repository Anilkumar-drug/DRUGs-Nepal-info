package com.example.data.repository

data class RenalAdjustmentEntry(
    val drugName: String,
    val standardDose: String,
    val normalDose: String, // CrCl > 50 mL/min
    val mildDose: String,   // CrCl 30 - 50 mL/min
    val moderateDose: String, // CrCl 15 - 29 mL/min
    val severeDose: String, // CrCl < 15 mL/min / Hemodialysis
    val keyWarning: String,
    val isNarrowTherapeutic: Boolean = false
) {
    fun getAdjustmentForCrCl(crCl: Double): Pair<String, String> {
        return when {
            crCl >= 50.0 -> "Standard Dose" to normalDose
            crCl >= 30.0 -> "Mild Reduction (CrCl 30-50)" to mildDose
            crCl >= 15.0 -> "Moderate Reduction (CrCl 15-29)" to moderateDose
            else -> "Severe Reduction / HD (CrCl <15)" to severeDose
        }
    }
}

object RenalDrugAdjustmentData {

    val entries: List<RenalAdjustmentEntry> = listOf(
        RenalAdjustmentEntry(
            drugName = "Enoxaparin (Clexane)",
            standardDose = "Therapeutic: 1 mg/kg SC q12h or 1.5 mg/kg SC OD. Prophylaxis: 40 mg SC OD.",
            normalDose = "100% of standard dose (1 mg/kg SC q12h).",
            mildDose = "Standard therapeutic dose (1 mg/kg q12h); monitor for bleeding.",
            moderateDose = "Reduce therapeutic dose to 1 mg/kg SC ONCE daily (q24h). Prophylaxis: Reduce to 20 mg SC ONCE daily.",
            severeDose = "1 mg/kg SC q24h with anti-Xa monitoring, or switch to Unfractionated Heparin (UFH) with aPTT titration.",
            keyWarning = "Enoxaparin is cleared 80% renally. Failure to reduce dose when CrCl <30 mL/min causes massive drug accumulation and fatal retroperitoneal or intracranial hemorrhage.",
            isNarrowTherapeutic = true
        ),
        RenalAdjustmentEntry(
            drugName = "Meropenem",
            standardDose = "1 g IV q8h (Meningitis / severe sepsis: 2 g IV q8h)",
            normalDose = "1 g IV every 8 hours.",
            mildDose = "1 g IV every 12 hours (CrCl 26-50 mL/min).",
            moderateDose = "500 mg IV every 12 hours (CrCl 10-25 mL/min).",
            severeDose = "500 mg IV every 24 hours. On Hemodialysis: Give dose post-HD session.",
            keyWarning = "High accumulation in renal failure lowers seizure threshold, precipitating myoclonic jerks and generalized tonic-clonic seizures."
        ),
        RenalAdjustmentEntry(
            drugName = "Colistin (Colistimethate Sodium CMS)",
            standardDose = "Loading: 9 million IU (300 mg CBA) IV, then 4.5 million IU q12h",
            normalDose = "Loading 9 mIU, then 4.5 mIU q12h.",
            mildDose = "CrCl 30-50: Loading 9 mIU, then 3 to 3.5 mIU q12h.",
            moderateDose = "CrCl 15-29: Loading 9 mIU, then 2 to 2.5 mIU q12h.",
            severeDose = "CrCl <15: Loading 9 mIU, then 1.5 to 2 mIU q24h. Intermittent HD: 1.5 mIU q24h with supplemental 1.5 mIU post-HD.",
            keyWarning = "Direct proximal tubular nephrotoxin. Monitor daily serum creatinine and avoid concomitant aminoglycosides or NSAIDs.",
            isNarrowTherapeutic = true
        ),
        RenalAdjustmentEntry(
            drugName = "Vancomycin",
            standardDose = "Loading: 25-30 mg/kg IV over 2 hours. Maintenance: 15-20 mg/kg q8-12h",
            normalDose = "15-20 mg/kg IV every 8 to 12 hours (target trough 15-20 mcg/mL).",
            mildDose = "15-20 mg/kg IV every 24 hours.",
            moderateDose = "15-20 mg/kg IV every 48 hours or pulse-dosed per trough level.",
            severeDose = "Loading dose only (20-25 mg/kg), then re-dose ONLY when serum trough level drops <15-20 mcg/mL (often every 4-7 days in ESRD/HD).",
            keyWarning = "Trough monitoring mandatory. Co-administration with Piperacillin-Tazobactam increases acute kidney injury incidence 3-fold.",
            isNarrowTherapeutic = true
        ),
        RenalAdjustmentEntry(
            drugName = "Apixaban (Eliquis)",
            standardDose = "5 mg PO BID (Non-valvular AF)",
            normalDose = "5 mg PO twice daily.",
            mildDose = "5 mg PO twice daily.",
            moderateDose = "Reduce to 2.5 mg PO BID IF patient meets at least TWO of: Age ≥80y, Body Weight ≤60kg, or Serum Creatinine ≥1.5 mg/dL.",
            severeDose = "CrCl <15 mL/min: Limited data; 2.5 mg BID may be used in select dialysis patients with extreme caution, but Warfarin is often preferred.",
            keyWarning = "Has the lowest renal excretion (27%) among DOACs, making it the safest DOAC in mild-to-moderate renal impairment."
        ),
        RenalAdjustmentEntry(
            drugName = "Rivaroxaban (Xarelto)",
            standardDose = "20 mg PO OD with evening meal (AF stroke prevention)",
            normalDose = "20 mg PO once daily.",
            mildDose = "15 mg PO once daily with evening meal (CrCl 15-50 mL/min).",
            moderateDose = "15 mg PO once daily (CrCl 15-29 mL/min).",
            severeDose = "CrCl <15 mL/min: AVOID USE. Significant drug accumulation and fatal bleeding risk.",
            keyWarning = "36% excreted as active drug renally. Contraindicated if CrCl <15 mL/min."
        ),
        RenalAdjustmentEntry(
            drugName = "Metformin",
            standardDose = "500 mg to 1000 mg PO BID with meals (Max 2550 mg/day)",
            normalDose = "eGFR ≥60 mL/min: Standard dose (up to 2000-2550 mg/day).",
            mildDose = "eGFR 45-59 mL/min: Max 1500-2000 mg/day. Monitor renal function every 3-6 months.",
            moderateDose = "eGFR 30-44 mL/min: Maximum 1000 mg/day. Do NOT initiate new therapy; if already on it, halve dose.",
            severeDose = "eGFR <30 mL/min: STRICTLY CONTRAINDICATED. Discontinue immediately due to high risk of fatal Metformin-Associated Lactic Acidosis (MALA).",
            keyWarning = "Withhold 48 hours prior to iodinated radiocontrast procedures and resume only after confirming renal function stability."
        ),
        RenalAdjustmentEntry(
            drugName = "Allopurinol",
            standardDose = "100 mg to 300 mg PO OD after meals",
            normalDose = "Start 100 mg/day, titrate up to 300-600 mg/day targeting serum urate <6 mg/dL.",
            mildDose = "CrCl 30-50: Max 200 mg/day.",
            moderateDose = "CrCl 10-29: Max 100 mg/day.",
            severeDose = "CrCl <10: 50 mg/day or 100 mg every 2-3 days. Hemodialysis: 50 mg post-dialysis.",
            keyWarning = "Active metabolite oxypurinol accumulates renally. Failure to adjust dose dramatically increases Allopurinol Hypersensitivity Syndrome (AHS / DRESS)."
        ),
        RenalAdjustmentEntry(
            drugName = "Ciprofloxacin",
            standardDose = "500 mg to 750 mg PO BID or 400 mg IV q12h",
            normalDose = "Standard dose: 500-750 mg PO q12h or 400 mg IV q12h.",
            mildDose = "CrCl 30-50: 250-500 mg PO q12h or 200-400 mg IV q12h.",
            moderateDose = "CrCl <30: 250-500 mg PO q18-24h or 200-400 mg IV q18-24h.",
            severeDose = "CrCl <15 / HD: 250-500 mg PO q24h given after hemodialysis.",
            keyWarning = "Excreted renally and hepatically. Adjust interval to prevent neurotoxicity (confusion, hallucinations, seizures)."
        ),
        RenalAdjustmentEntry(
            drugName = "Digoxin",
            standardDose = "0.125 mg to 0.25 mg PO OD",
            normalDose = "0.125 mg to 0.25 mg once daily (target level 0.5-0.9 ng/mL).",
            mildDose = "Reduce daily dose by 25-50% (e.g., 0.125 mg daily or every other day).",
            moderateDose = "Reduce dose by 50% (0.0625 mg daily or 0.125 mg every 48 hours).",
            severeDose = "0.0625 mg every 48 to 72 hours. Not cleared by hemodialysis. Monitor serum levels closely.",
            keyWarning = "Extremely narrow therapeutic window. Renal failure impairs tubular excretion; hypokalemia further potentiates life-threatening cardiac arrhythmias.",
            isNarrowTherapeutic = true
        ),
        RenalAdjustmentEntry(
            drugName = "Piperacillin + Tazobactam",
            standardDose = "4.5 g IV q6h or q8h (extended 4-hour infusion)",
            normalDose = "4.5 g IV every 6 hours or 8 hours.",
            mildDose = "CrCl 20-50: 3.375 g IV every 6 hours.",
            moderateDose = "CrCl <20: 2.25 g IV every 6 hours (or 3.375 g q8h).",
            severeDose = "Hemodialysis: 2.25 g IV every 8 hours with an additional 0.75 g post-dialysis booster.",
            keyWarning = "Monitor for bone marrow suppression and neurotoxicity with high cumulative doses."
        ),
        RenalAdjustmentEntry(
            drugName = "Pregabalin",
            standardDose = "75 mg to 150 mg PO BID (Max 600 mg/day)",
            normalDose = "150 to 600 mg/day divided BID or TID.",
            mildDose = "CrCl 30-60: Max 300 mg/day divided BID or TID (50% reduction).",
            moderateDose = "CrCl 15-30: Max 150 mg/day divided OD or BID (75% reduction).",
            severeDose = "CrCl <15: Max 75 mg/day single dose. Hemodialysis: Supplemental 25-100 mg post-HD.",
            keyWarning = "Cleared >90% unchanged by the kidneys. Overdose in renal impairment causes severe lethargy, myoclonus, and coma."
        )
    )
}
