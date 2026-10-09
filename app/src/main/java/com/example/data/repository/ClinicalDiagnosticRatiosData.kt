package com.example.data.repository

import com.example.data.model.DiagnosticRatioGuide

object ClinicalDiagnosticRatiosData {

    val diagnosticRatios: List<DiagnosticRatioGuide> = listOf(
        DiagnosticRatioGuide(
            id = "ratio_saag",
            title = "Serum-Ascites Albumin Gradient (SAAG)",
            formula = "SAAG = Serum Albumin (g/dL) - Ascitic Fluid Albumin (g/dL)",
            cutoffThreshold = "1.1 g/dL",
            interpretationHigh = "HIGH SAAG (≥ 1.1 g/dL): PORTAL HYPERTENSION (Accuracy >97%).\nEtiologies: Cirrhosis, Alcoholic Hepatitis, Heart Failure (cardiac ascites), Budd-Chiari Syndrome, Portal Vein Thrombosis, Sinusoidal Obstruction Syndrome.",
            interpretationLow = "LOW SAAG (< 1.1 g/dL): NORMAL PORTAL PRESSURE (Peritoneal Pathology / Hypoalbuminemia).\nEtiologies: Peritoneal Carcinomatosis, Tuberculous (TB) Peritonitis, Pancreatic Ascites, Biliary Leak, Nephrotic Syndrome, Serositis (Connective Tissue Disease).",
            clinicalUtility = "Superior to the outdated transudate/exudate classification for ascites. Distinguishes portal hypertensive etiologies from peritoneal carcinomatosis and TB peritonitis.",
            nextDiagnosticSteps = "If High SAAG: Check ascitic fluid total protein (<2.5 g/dL indicates Cirrhosis; ≥2.5 g/dL indicates Cardiac Ascites or Early Budd-Chiari). Also send cell count for SBP (PMN ≥250/mm3). If Low SAAG: Send ascitic fluid cytology, Adenosine Deaminase (ADA), GeneXpert MTB, and amylase."
        ),

        DiagnosticRatioGuide(
            id = "ratio_lights_criteria",
            title = "Light's Criteria for Pleural Effusion",
            formula = "Exudate if ANY ONE of the following 3 criteria is met:\n1. Pleural fluid protein / Serum protein ratio > 0.5\n2. Pleural fluid LDH / Serum LDH ratio > 0.6\n3. Pleural fluid LDH > 2/3 the upper limit of normal serum LDH",
            cutoffThreshold = "Meets ≥ 1 criterion = Exudate; Meets 0 criteria = Transudate",
            interpretationHigh = "EXUDATIVE EFFUSION: Local inflammation, infection, or malignancy altering capillary permeability.\nEtiologies: Parapneumonic effusion / Empyema, Malignancy (lung, breast, lymphoma), Tuberculosis pleurisy, Pulmonary embolism, Pancreatitis, Rheumatoid arthritis.",
            interpretationLow = "TRANSUDATIVE EFFUSION: Systemic hydrostatic or oncotic pressure imbalances.\nEtiologies: Congestive Heart Failure, Liver Cirrhosis (hepatic hydrothorax), Nephrotic Syndrome, Severe Hypoalbuminemia, Peritoneal Dialysis.",
            clinicalUtility = "The gold-standard diagnostic algorithm for categorizing pleural fluid with 98% sensitivity for exudates.",
            nextDiagnosticSteps = "If Exudate: Check pleural fluid glucose (<60 mg/dL = empyema, TB, RA, malignancy), pH (<7.20 = complicated parapneumonic requiring chest tube drainage), ADA & GeneXpert for TB, and cytology. If on diuretics with false-positive exudate: Check serum-pleural albumin gradient (>1.2 g/dL indicates true transudate)."
        ),

        DiagnosticRatioGuide(
            id = "ratio_fena",
            title = "Fractional Excretion of Sodium (FeNa)",
            formula = "FeNa (%) = [(Urine Na x Serum Creatinine) / (Serum Na x Urine Creatinine)] x 100",
            cutoffThreshold = "1.0 %",
            interpretationHigh = "FeNa > 2.0 %: INTRINSIC ACUTE KIDNEY INJURY (Acute Tubular Necrosis - ATN).\nTubular epithelial cell damage impairs sodium reabsorption, resulting in excessive sodium wasting in the urine.",
            interpretationLow = "FeNa < 1.0 %: PRERENAL AZOTEMIA (Renal Hypoperfusion).\nIntact, healthy renal tubules avidly reabsorb sodium to conserve circulating intravascular volume.",
            clinicalUtility = "Differentiates prerenal azotemia (reversible with IV fluid hydration) from established Acute Tubular Necrosis (ATN) in oliguric acute kidney injury.",
            nextDiagnosticSteps = "CAUTION WITH DIURETICS: If patient has received loop diuretics within 24-48 hours, FeNa is falsely elevated. Calculate Fractional Excretion of Urea (FeUrea): FeUrea < 35% indicates Prerenal Azotemia; FeUrea > 50% indicates ATN."
        ),

        DiagnosticRatioGuide(
            id = "ratio_feurea",
            title = "Fractional Excretion of Urea (FeUrea)",
            formula = "FeUrea (%) = [(Urine Urea x Serum Creatinine) / (Blood Urea Nitrogen x Urine Creatinine)] x 100",
            cutoffThreshold = "35.0 %",
            interpretationHigh = "FeUrea > 50 %: INTRINSIC RENAL FAILURE (Acute Tubular Necrosis - ATN).\nDamaged proximal and collecting tubule epithelial cells lose their ability to reabsorb urea, resulting in fractional urea wasting.",
            interpretationLow = "FeUrea < 35 %: PRERENAL AZOTEMIA (Hypoperfusion / Volume Depletion).\nUrea reabsorption in the proximal tubule is preserved and enhanced under the influence of neurohormonal activation (angiotensin II).",
            clinicalUtility = "THE PREFERRED TEST WHEN PATIENT HAS RECEIVED DIURETICS. Unlike sodium, urea reabsorption is largely independent of loop and thiazide diuretics, making FeUrea accurate even after furosemide.",
            nextDiagnosticSteps = "If FeUrea <35%: Initiate fluid resuscitation (crystalloid challenge) and hold antihypertensive/nephrotoxic medications. If FeUrea >50%: Avoid excessive fluid boluses to prevent volume overload/pulmonary edema; adjust medication dosing for renal failure."
        ),

        DiagnosticRatioGuide(
            id = "ratio_bun_cr",
            title = "BUN / Serum Creatinine Ratio",
            formula = "BUN / Cr Ratio = Blood Urea Nitrogen (mg/dL) / Serum Creatinine (mg/dL)",
            cutoffThreshold = "20 : 1",
            interpretationHigh = "BUN/Cr > 20:1: PRERENAL AZOTEMIA OR UPPER GI BLEEDING.\nSluggish renal tubular flow allows passive reabsorption of urea into blood while creatinine is filtered. Also seen in massive upper GI blood breakdown and catabolic states/steroids.",
            interpretationLow = "BUN/Cr < 10-15:1: INTRINSIC RENAL PARENCHYMAL DISEASE (ATN, Glomerulonephritis, Acute Interstitial Nephritis).\nTubular epithelial cell damage prevents urea reabsorption, keeping BUN and creatinine filtration proportionally impaired.",
            clinicalUtility = "Rapid bedside screening metric to assess intravascular volume depletion and occult upper gastrointestinal bleeding in acute inpatient admissions.",
            nextDiagnosticSteps = "If BUN/Cr >20:1 with severe drop in hemoglobin or melena: Urgent upper endoscopy to rule out bleeding peptic ulcer or varices. In isolated dehydration, BUN normalizes rapidly with crystalloid rehydration."
        ),

        DiagnosticRatioGuide(
            id = "ratio_anion_gap_delta",
            title = "Anion Gap & Delta-Delta (Δ-Δ) Ratio",
            formula = "Anion Gap = Na - (Cl + HCO3) [Normal: 8-12 mEq/L]\nDelta Ratio = (Anion Gap - 12) / (24 - Measured HCO3)",
            cutoffThreshold = "Normal AG = 8-12 mEq/L; Delta Ratio 1.0 - 2.0",
            interpretationHigh = "Delta Ratio > 2.0: Concurrent HIGH ANION GAP METABOLIC ACIDOSIS + METABOLIC ALKALOSIS (or chronic compensated respiratory acidosis).\nDelta Ratio 1.0 to 2.0: PURE High Anion Gap Metabolic Acidosis (e.g. uncomplicated DKA or lactic acidosis).",
            interpretationLow = "Delta Ratio < 1.0 (specifically <0.4 - 0.8): MIXED High Anion Gap + NORMAL ANION GAP (Hyperchloremic) Metabolic Acidosis (e.g. DKA plus severe diarrhea, or DKA during saline resuscitation).",
            clinicalUtility = "Uncovers hidden, co-existing complex acid-base disorders that are masked on basic electrolyte panels.",
            nextDiagnosticSteps = "If Anion Gap >12: Screen for GOLDMARK etiologies (Glycols, Oxoproline, L-Lactate, D-Lactate, Methanol, Aspirin, Renal failure, Ketoacidosis). Check serum osmolar gap and serum lactate."
        ),

        DiagnosticRatioGuide(
            id = "ratio_osmolar_gap",
            title = "Serum Osmolar Gap",
            formula = "Calculated Osmolality = 2 x Na + (Glucose mg/dL / 18) + (BUN mg/dL / 2.8)\nOsmolar Gap = Measured Osmolality (Freezing Point) - Calculated Osmolality",
            cutoffThreshold = "10 mOsm/kg",
            interpretationHigh = "HIGH OSMOLAR GAP (> 10 mOsm/kg): Presence of unmeasured low-molecular-weight exogenous osmotically active toxins.\nEtiologies: Toxic Alcohols (Methanol, Ethylene Glycol, Isopropanol), Acetone, Propylene glycol, Mannitol, Severe alcoholic ketoacidosis.",
            interpretationLow = "NORMAL OSMOLAR GAP (≤ 10 mOsm/kg): Rules out significant acute toxic alcohol ingestion (note: as toxic alcohols are metabolized into toxic acid metabolites, the osmolar gap closes while the anion gap widens).",
            clinicalUtility = "Critical emergency toxicology test for suspected adulterated homemade alcohol / industrial solvent poisoning.",
            nextDiagnosticSteps = "If High Osmolar Gap + High Anion Gap Acidosis: Suspect Methanol (formic acid causes optic papillitis & blindness) or Ethylene Glycol (glycolic/oxalic acid causes acute tubular necrosis & calcium oxalate envelope crystals in urine). Administer Fomepizole or Ethanol IV/PO + hemodialysis."
        ),

        DiagnosticRatioGuide(
            id = "ratio_de_ritis",
            title = "De Ritis Ratio (AST / ALT Ratio)",
            formula = "De Ritis Ratio = Serum AST (U/L) / Serum ALT (U/L)",
            cutoffThreshold = "2.0",
            interpretationHigh = "AST/ALT > 2.0: Highly suggestive of ALCOHOLIC LIVER DISEASE (Cirrhosis, alcoholic hepatitis; sensitivity ~90% when AST <300 U/L) or Wilson's Disease. Also seen in advanced established cirrhosis of any etiology and ischemic hepatitis.",
            interpretationLow = "AST/ALT < 1.0: Typical of CHRONIC VIRAL HEPATITIS (Hepatitis B, Hepatitis C), Non-Alcoholic Fatty Liver Disease (NAFLD / MASH), and acute non-alcoholic toxic injury (ALT exceeds AST due to longer half-life).",
            clinicalUtility = "Non-invasive biochemical differentiation of alcoholic versus metabolic/viral hepatic pathology.",
            nextDiagnosticSteps = "In alcoholic hepatitis: Absolute AST levels rarely exceed 300-500 U/L. If AST/ALT >1000 U/L, consider ischemic hepatitis ('shock liver'), paracetamol toxicity, or acute viral hepatitis."
        ),

        DiagnosticRatioGuide(
            id = "ratio_ca_corr",
            title = "Albumin-Corrected Calcium Formula",
            formula = "Corrected Calcium (mg/dL) = Measured Total Calcium (mg/dL) + 0.8 x [4.0 - Serum Albumin (g/dL)]",
            cutoffThreshold = "Normal: 8.5 - 10.5 mg/dL",
            interpretationHigh = "CORRECTED CALCIUM > 10.5 mg/dL: True underlying hypercalcemia that was artificially masked by severe hypoalbuminemia (common in ICU, sepsis, malnutrition, and malignancy).",
            interpretationLow = "CORRECTED CALCIUM < 8.5 mg/dL: True underlying hypocalcemia requiring diagnostic workup (PTH, 25-OH Vitamin D, Magnesium) and replacement therapy.",
            clinicalUtility = "Since ~40-45% of serum calcium is bound to albumin, hypoalbuminemia falsely lowers total calcium measurements even when physiologically active ionized calcium is normal.",
            nextDiagnosticSteps = "Whenever possible, measure DIRECT IONIZED CALCIUM (normal 1.15 - 1.33 mmol/L or 4.6 - 5.3 mg/dL) using a blood gas analyzer to confirm true calcium status in critically ill patients."
        ),

        DiagnosticRatioGuide(
            id = "ratio_na_glucose",
            title = "Corrected Sodium for Hyperglycemia (Katz & Hillier Formula)",
            formula = "Corrected Na = Measured Sodium + 0.016 x (Blood Glucose mg/dL - 100)\n[Alternative / Severe: add 2.0 mEq/L per 100 mg/dL rise if glucose >400]",
            cutoffThreshold = "Normal: 135 - 145 mEq/L",
            interpretationHigh = "CORRECTED SODIUM > 145 mEq/L in DKA/HHS: Indicates severe underlying total body water deficit and profound hypertonicity (use 0.45% half-normal saline rather than 0.9% saline).",
            interpretationLow = "CORRECTED SODIUM < 135 mEq/L: True pseudohyponatremia / hypertonic hyponatremia driven by osmotic water shifting from intracellular to extracellular space.",
            clinicalUtility = "Essential calculation in Diabetic Ketoacidosis (DKA) and Hyperglycemic Hyperosmolar State (HHS) to determine true osmolar status and choose appropriate IV resuscitation fluids.",
            nextDiagnosticSteps = "Calculate Effective Serum Osmolality = 2 x Na + (Glucose / 18). If corrected Na is high or normal, switch initial 0.9% Normal Saline to 0.45% Saline (half-normal) after the first 1-2 liters."
        ),

        DiagnosticRatioGuide(
            id = "ratio_age_ddimer",
            title = "Age-Adjusted D-Dimer Cutoff for PE / DVT",
            formula = "For Patients Aged > 50 Years:\nAge-Adjusted Cutoff = Patient's Age x 10 ug/L (or Age x 0.01 mg/L FEU)",
            cutoffThreshold = "Standard: 500 ug/L; If Age >50: Age x 10 ug/L",
            interpretationHigh = "D-DIMER > AGE-ADJUSTED CUTOFF: Test is POSITIVE. Cannot exclude venous thromboembolism; proceeding to imaging (CT Pulmonary Angiogram or Venous Duplex Ultrasound) is indicated.",
            interpretationLow = "D-DIMER ≤ AGE-ADJUSTED CUTOFF: Test is NEGATIVE. Safely excludes pulmonary embolism and deep vein thrombosis in patients with low or intermediate clinical pretest probability (Wells Score).",
            clinicalUtility = "Safely increases diagnostic specificity and eliminates up to 30% of unnecessary, radiation-heavy CT scans in elderly emergency department patients without compromising safety (ADJUST-PE Trial).",
            nextDiagnosticSteps = "Apply strictly ONLY in patients with Low or Moderate Wells score (or PERC negative). Never use D-Dimer in high clinical pretest probability patients (proceed directly to CT angiography)."
        ),

        DiagnosticRatioGuide(
            id = "ratio_upcr",
            title = "Spot Urine Protein-to-Creatinine Ratio (UPCR & UACR)",
            formula = "UPCR (mg/mg) = Urine Protein (mg/dL) / Urine Creatinine (mg/dL)\nUACR (mg/g) = Urine Albumin (mg/dL) / Urine Creatinine (g/dL)",
            cutoffThreshold = "UPCR < 0.2 normal; 0.2 - 3.0 sub-nephrotic; > 3.0 - 3.5 nephrotic range",
            interpretationHigh = "UPCR > 3.0 - 3.5 mg/mg: NEPHROTIC RANGE PROTEINURIA (Equivalent to >3.5 g/24hr on 24-hour collection).\nEtiologies: Membranous Nephropathy, Focal Segmental Glomerulosclerosis (FSGS), Minimal Change Disease, Diabetic Nephropathy, Amyloidosis.",
            interpretationLow = "UPCR 0.2 to 3.0 mg/mg: SUB-NEPHROTIC PROTEINURIA (Tubulointerstitial disease, mild glomerulonephritis, hypertensive nephrosclerosis, early diabetic nephropathy).",
            clinicalUtility = "Accurate, rapid outpatient surrogate that eliminates the burden and collection errors of cumbersome 24-hour urine collections (1 mg/mg UPCR closely approximates 1 gram of protein/24hr).",
            nextDiagnosticSteps = "In diabetic patients: Monitor UACR (normal <30 mg/g; microalbuminuria 30-300 mg/g; macroalbuminuria >300 mg/g). If microalbuminuria present, initiate ACE inhibitor / ARB and SGLT-2 inhibitor for nephroprotection."
        ),

        DiagnosticRatioGuide(
            id = "ratio_csf_glucose",
            title = "CSF-to-Serum Glucose Ratio",
            formula = "CSF / Serum Glucose Ratio = CSF Glucose (mg/dL) / Concurrent Serum Glucose (mg/dL)",
            cutoffThreshold = "0.60 (Normal: > 0.60)",
            interpretationHigh = "CSF / SERUM RATIO > 0.60: Normal or typical of VIRAL / ASEPTIC MENINGITIS (enterovirus, HSV, VZV) and encephalitis.",
            interpretationLow = "CSF / SERUM RATIO < 0.40 (Critical Panic < 0.20-0.30): Strongly indicative of ACUTE BACTERIAL MENINGITIS, TUBERCULOUS (TB) MENINGITIS, or FUNGAL MENINGITIS (Cryptococcus).\nBacteria and inflamed leukocytes consume glucose and impair facilitative hexose transport across the blood-brain barrier.",
            clinicalUtility = "The single most specific CSF biochemical marker for differentiating bacterial and tuberculous meningitis from uncomplicated viral meningitis.",
            nextDiagnosticSteps = "Must draw concurrent peripheral blood glucose simultaneously with lumbar puncture. If ratio <0.4: Immediate IV Ceftriaxone 2 g q12h + Vancomycin 15-20 mg/kg q12h + Dexamethasone 10 mg IV (plus Ampicillin if neonate or >50 years for Listeria)."
        ),

        DiagnosticRatioGuide(
            id = "ratio_pf_ratio",
            title = "PaO2 / FiO2 Ratio (Horowitz Index & Berlin ARDS Criteria)",
            formula = "P/F Ratio = Arterial PaO2 (mmHg) / Fraction of Inspired Oxygen (FiO2 as decimal, e.g. 0.40 for 40% O2)",
            cutoffThreshold = "Normal: 400 - 500 mmHg; ARDS: ≤ 300 mmHg with PEEP ≥ 5 cmH2O",
            interpretationHigh = "P/F Ratio 200 - 300 mmHg: MILD ARDS (27% ICU mortality).\nP/F Ratio 100 - 200 mmHg: MODERATE ARDS (32% ICU mortality).",
            interpretationLow = "P/F Ratio < 100 mmHg: SEVERE ARDS (45% ICU mortality).\nRefractory hypoxemic alveolar capillary membrane failure requiring advanced rescue therapy.",
            clinicalUtility = "The international consensus definition (Berlin Criteria) for grading the severity of Acute Respiratory Distress Syndrome (ARDS) and guiding lung-protective mechanical ventilation.",
            nextDiagnosticSteps = "If P/F <150 with PEEP ≥10: Implement PRONE POSITIONING for at least 16 consecutive hours/day (PROSEVA trial demonstrated significant mortality reduction). If P/F <80: Consider neuromuscular blockade (cisatracurium) and ECMO evaluation."
        ),

        DiagnosticRatioGuide(
            id = "ratio_tsat",
            title = "Transferrin Saturation (TSAT) & Ferritin Ratio",
            formula = "TSAT (%) = [Serum Iron (ug/dL) / Total Iron-Binding Capacity TIBC (ug/dL)] x 100",
            cutoffThreshold = "20.0 %",
            interpretationHigh = "TSAT > 45 - 50 %: HEREDITARY HEMOCHROMATOSIS OR IRON OVERLOAD (Ferritin typically >500-1000 ng/mL).\nRisk of hepatic cirrhosis, bronze diabetes, cardiomyopathy, and arthropathy; send HFE gene testing.",
            interpretationLow = "TSAT < 20 %: IRON DEFICIENCY.\n• Absolute Iron Deficiency: TSAT <20% + Ferritin <30 ng/mL.\n• Functional / Inflammatory Iron Deficiency (CKD / Heart Failure / IBD): TSAT <20% despite 'normal' or elevated Ferritin (100-300 ng/mL) due to hepcidin blocking iron release from macrophages.",
            clinicalUtility = "Differentiates true absolute iron deficiency from anemia of chronic disease / inflammation and guides intravenous iron replacement in heart failure and chronic kidney disease.",
            nextDiagnosticSteps = "In Heart Failure with reduced ejection fraction: TSAT <20% or Ferritin <100 ng/mL is an indication for IV Ferric Carboxymaltose (improves symptoms, exercise capacity, and reduces hospitalizations per ESC/AHA guidelines)."
        ),

        DiagnosticRatioGuide(
            id = "ratio_apri",
            title = "AST-to-Platelet Ratio Index (APRI)",
            formula = "APRI = [(AST / Upper Limit of Normal AST, e.g. 40 U/L) / Platelet Count (10^9/L)] x 100",
            cutoffThreshold = "0.50 (Fibrosis) and 1.50 - 2.0 (Cirrhosis)",
            interpretationHigh = "APRI > 1.5 - 2.0: HIGH PROBABILITY OF CIRRHOSIS (Metavir F4).\nPredicts advanced liver fibrosis and cirrhosis with high diagnostic accuracy without requiring invasive liver biopsy.",
            interpretationLow = "APRI < 0.50: RULES OUT SIGNIFICANT FIBROSIS (Metavir F0-F1).\nHigh negative predictive value (>90%) for significant hepatic fibrosis.",
            clinicalUtility = "WHO-recommended simple, non-invasive biomarker using routine, low-cost laboratory tests (AST and CBC platelets) for monitoring chronic Hepatitis B and C in resource-limited countries.",
            nextDiagnosticSteps = "If APRI >1.5: Screen for esophageal varices (screening EGD) and hepatocellular carcinoma (liver ultrasound + alpha-fetoprotein every 6 months)."
        )
    )
}
