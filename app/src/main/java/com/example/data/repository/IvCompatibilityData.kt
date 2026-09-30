package com.example.data.repository

import com.example.data.model.IvInfusionGuide

object IvCompatibilityData {

    val infusions: List<IvInfusionGuide> = listOf(
        IvInfusionGuide(
            id = "iv_norepi",
            drugName = "Norepinephrine (Noradrenaline)",
            primaryIndication = "Septic Shock, Cardiogenic Shock, Refractory Vasodilatory Hypotension",
            preferredDiluents = listOf("5% Dextrose (D5W)", "Dextrose-Saline (D5NS)"),
            forbiddenDiluents = listOf("Alkaline solutions (NaHCO3)", "Plain Saline without Dextrose (causes auto-oxidation over >4h)"),
            standardConcentration = "4 mg in 50 mL D5W (80 mcg/mL) via syringe pump or 8 mg in 250 mL D5W (32 mcg/mL)",
            maxPeripheralConcentration = "16 mcg/mL (emergency peripheral run max 2-4 hours until central line secured)",
            centralLineMandatory = true,
            infusionRateGuidelines = "Titrate 0.05 to 0.5 mcg/kg/min (or 2-20 mcg/min) targeting Mean Arterial Pressure (MAP) ≥ 65 mmHg.",
            filterRequired = "Standard IV line",
            lightProtection = true,
            ySiteIncompatibilities = listOf(
                "Sodium Bicarbonate 8.4% (Causes immediate chemical inactivation/oxidation)",
                "Furosemide (Precipitation)",
                "Phenytoin Sodium (Immediate crystallization)",
                "Thiopental Sodium",
                "Insulin Regular (Co-infusion risk unless separate line)"
            ),
            fatalWarnings = "EXTRAVASATION WARNING: Peripheral infiltration causes severe ischemic skin necrosis and gangrene. If extravasation occurs, immediately infiltrate Phentolamine 5-10 mg in 10 mL saline subcutaneously."
        ),
        IvInfusionGuide(
            id = "iv_amiodarone",
            drugName = "Amiodarone Hydrochloride IV",
            primaryIndication = "Ventricular Tachycardia, Ventricular Fibrillation (Cardiac Arrest), Refractory AF Rate Control",
            preferredDiluents = listOf("5% Dextrose (D5W) ONLY"),
            forbiddenDiluents = listOf("0.9% Normal Saline (Causes progressive physical instability and precipitation)", "Ringer's Lactate"),
            standardConcentration = "Cardiac Arrest: 300 mg bolus push in 20-30 mL D5W. Infusion: 900 mg in 500 mL D5W (1.8 mg/mL).",
            maxPeripheralConcentration = "2 mg/mL (Infusions >2 hours must use central line; causes severe thrombophlebitis)",
            centralLineMandatory = false,
            infusionRateGuidelines = "Loading: 150 mg IV over 10 min, then 1 mg/min x 6 hours (360 mg), then 0.5 mg/min x 18 hours (540 mg). Total 1050 mg in 24 hours.",
            filterRequired = "0.22-micron in-line filter mandatory",
            lightProtection = true,
            ySiteIncompatibilities = listOf(
                "Unfractionated Heparin (Forms thick white precipitate)",
                "Sodium Bicarbonate 8.4% (Precipitates)",
                "Ceftriaxone",
                "Piperacillin-Tazobactam",
                "Potassium Chloride (high concentrations)"
            ),
            fatalWarnings = "DILUENT PRECIPITATION: Never mix or flush with Normal Saline! Use non-DEHP/non-PVC IV tubing for continuous infusions >2 hours as amiodarone leaches plasticizers."
        ),
        IvInfusionGuide(
            id = "iv_phenytoin",
            drugName = "Phenytoin Sodium IV (Dilantin)",
            primaryIndication = "Status Epilepticus, Acute Seizure Clusters, Post-Traumatic Brain Injury Seizure Prophylaxis",
            preferredDiluents = listOf("0.9% Normal Saline ONLY"),
            forbiddenDiluents = listOf("5% Dextrose (D5W - Immediate catastrophic precipitation!)", "Ringer's Lactate", "Any acidic solutions"),
            standardConcentration = "Max 10 mg/mL in Normal Saline (e.g., 1000 mg in 100 mL 0.9% NS)",
            maxPeripheralConcentration = "10 mg/mL into a large bore vein (≥20G) in antecubital fossa",
            centralLineMandatory = false,
            infusionRateGuidelines = "Loading: 15-20 mg/kg. Maximum infusion rate: 50 mg/minute (Elderly / cardiac disease: max 25 mg/min).",
            filterRequired = "0.22 to 1.2 micron in-line filter mandatory",
            lightProtection = false,
            ySiteIncompatibilities = listOf(
                "All Dextrose-containing solutions",
                "Morphine Sulfate & Fentanyl",
                "Midazolam",
                "Insulin Regular",
                "Potassium Chloride",
                "Norepinephrine",
                "Heparin"
            ),
            fatalWarnings = "PURPLE GLOVE SYNDROME & ARRHYTHMIA: Rapid infusion (>50 mg/min) causes complete heart block, asystole, and severe hypotension. Extravasation leads to microvascular thrombosis and compartment syndrome (Purple Glove Syndrome)."
        ),
        IvInfusionGuide(
            id = "iv_kcl",
            drugName = "Potassium Chloride (KCl) Concentrated Infusion",
            primaryIndication = "Severe Hypokalemia (<3.0 mEq/L), Diabetic Ketoacidosis (DKA) Potassium Repletion",
            preferredDiluents = listOf("0.9% Normal Saline", "Ringer's Lactate", "D5NS"),
            forbiddenDiluents = listOf("NEVER GIVE AS PURE / UNDILUTED BOLUS!"),
            standardConcentration = "Peripheral IV: 20 to 40 mEq/L in 500-1000 mL NS. Central Line: Max 80 mEq/L (in specialized ICU).",
            maxPeripheralConcentration = "40 mEq/L (Concentrations >40 mEq/L cause intense burning pain and peripheral phlebitis)",
            centralLineMandatory = false,
            infusionRateGuidelines = "Peripheral IV: Maximum 10 mEq/hour. Central line with continuous cardiac ECG monitoring: Maximum 20 mEq/hour in severe life-threatening hypokalemia.",
            filterRequired = "Standard",
            lightProtection = false,
            ySiteIncompatibilities = listOf(
                "Diazepam",
                "Phenytoin",
                "Amphotericin B",
                "Amiodarone (high concentration)"
            ),
            fatalWarnings = "DEADLY INJECTION WARNING: Potassium Chloride must NEVER be administered by direct IV push or bolus under any circumstances. Fatal cardiac arrest in diastole occurs within seconds. Always mix thoroughly in IV bag before hanging."
        ),
        IvInfusionGuide(
            id = "iv_nahco3",
            drugName = "Sodium Bicarbonate 8.4% (1 mEq/mL)",
            primaryIndication = "TCA Overdose (Wide QRS), Severe Metabolic Acidosis (pH <7.1), Hyperkalemic Cardiotoxicity, Urine Alkalinization",
            preferredDiluents = listOf("5% Dextrose (D5W)", "Sterile Water for Injection", "May be given undiluted IV push in cardiac arrest / TCA collapse"),
            forbiddenDiluents = listOf("Ringer's Lactate", "Calcium-containing solutions (Precipitates chalky calcium carbonate)"),
            standardConcentration = "Undiluted 8.4% (1 mEq/mL) for emergency push; or 150 mEq (150 mL) in 850 mL D5W (isotonic infusion)",
            maxPeripheralConcentration = "Undiluted in cardiac arrest; otherwise dilute to isotonic",
            centralLineMandatory = false,
            infusionRateGuidelines = "TCA Toxicity: 1-2 mEq/kg IV push over 2-3 min. Infusion: 100-250 mL/hr titrated to blood pH 7.50-7.55.",
            filterRequired = "Standard",
            lightProtection = false,
            ySiteIncompatibilities = listOf(
                "Calcium Gluconate & Calcium Chloride (Forms insoluble insoluble chalk calcium carbonate!)",
                "Norepinephrine & Epinephrine (Inactivates catecholamines)",
                "Dopamine",
                "Ciprofloxacin",
                "Midazolam",
                "Ondansetron"
            ),
            fatalWarnings = "CALCIUM INCOMPATIBILITY: Never infuse Sodium Bicarbonate through the same IV line as Calcium Gluconate or Calcium Chloride without extensive flushing (at least 20 mL NS). The precipitate can cause pulmonary microembolism."
        ),
        IvInfusionGuide(
            id = "iv_mag_sulfate",
            drugName = "Magnesium Sulfate 50% IV",
            primaryIndication = "Eclampsia / Pre-eclampsia Seizure Prophylaxis, Torsades de Pointes, Severe Refractory Asthma",
            preferredDiluents = listOf("5% Dextrose (D5W)", "0.9% Normal Saline"),
            forbiddenDiluents = listOf("Calcium-containing fluids", "Sodium Bicarbonate"),
            standardConcentration = "Loading: 4 g in 100 mL D5W/NS over 15-20 min. Maintenance: 1-2 g/hr (20 g in 500 mL D5W at 25-50 mL/hr)",
            maxPeripheralConcentration = "20% solution (Dilute 50% ampoule at least 1:1 with saline/dextrose)",
            centralLineMandatory = false,
            infusionRateGuidelines = "Torsades de Pointes: 2 g IV push over 1-2 min. Eclampsia: 4 g IV over 15 min, then 1 g/hr for 24 hours post-delivery.",
            filterRequired = "Standard",
            lightProtection = false,
            ySiteIncompatibilities = listOf(
                "Sodium Bicarbonate",
                "Calcium Chloride / Gluconate",
                "Ciprofloxacin",
                "Clindamycin Phosphate"
            ),
            fatalWarnings = "TOXICITY MONITORING: Regularly check Patellar Reflex (knee jerk), Respiratory Rate (must be ≥12/min), and Urine Output (≥30 mL/hr). If knee jerk is lost, STOP infusion immediately and give Calcium Gluconate 10% 10 mL IV as antidote."
        ),
        IvInfusionGuide(
            id = "iv_pantoprazole",
            drugName = "Pantoprazole IV",
            primaryIndication = "Acute Upper GI Bleeding (Peptic Ulcer / Mallory-Weiss), Severe GERD / Zollinger-Ellison",
            preferredDiluents = listOf("0.9% Normal Saline", "5% Dextrose (D5W)"),
            forbiddenDiluents = listOf("Ringer's Lactate (pH sensitivity)"),
            standardConcentration = "Bolus: 40-80 mg reconstituted in 10 mL NS. Infusion: 80 mg in 100 mL NS or D5W (0.8 mg/mL)",
            maxPeripheralConcentration = "0.8 mg/mL",
            centralLineMandatory = false,
            infusionRateGuidelines = "Acute GI Bleed: 80 mg IV bolus over 15 min, followed by continuous infusion of 8 mg/hour x 72 hours.",
            filterRequired = "Standard",
            lightProtection = false,
            ySiteIncompatibilities = listOf(
                "Midazolam (Immediate clouding / precipitation)",
                "Zinc Sulfate",
                "Ondansetron (at higher concentrations)"
            ),
            fatalWarnings = "Do not co-infuse through the same line with acidic drugs. Ensure reconstitution is completely clear without particle flakes before infusion."
        ),
        IvInfusionGuide(
            id = "iv_furosemide",
            drugName = "Furosemide IV (Lasix)",
            primaryIndication = "Acute Pulmonary Edema, Decompensated Heart Failure, Fluid Overload in AKI/CKD",
            preferredDiluents = listOf("0.9% Normal Saline", "Ringer's Lactate"),
            forbiddenDiluents = listOf("Acidic solutions (pH <5.5 causes furosemide crystal precipitation)"),
            standardConcentration = "Undiluted (10 mg/mL) or 100-200 mg in 100 mL Normal Saline",
            maxPeripheralConcentration = "10 mg/mL",
            centralLineMandatory = false,
            infusionRateGuidelines = "Max IV bolus rate: 4 mg/minute (e.g. 80 mg over at least 20 minutes) to prevent transient or permanent ototoxicity. Continuous infusion: 5-20 mg/hour.",
            filterRequired = "Standard",
            lightProtection = true,
            ySiteIncompatibilities = listOf(
                "Midazolam (Severe precipitation)",
                "Morphine Sulfate",
                "Ondansetron",
                "Dobutamine",
                "Norepinephrine"
            ),
            fatalWarnings = "OTOTOXICITY ALERT: Rapid IV push (>4 mg/min) of high doses causes permanent sensorineural deafness, especially in patients with co-existing renal failure or receiving aminoglycosides."
        )
    )
}
