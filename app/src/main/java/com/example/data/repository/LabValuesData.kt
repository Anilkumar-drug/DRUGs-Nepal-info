package com.example.data.repository

import com.example.data.model.CriticalPanicLabValue
import com.example.data.model.DiagnosticRatioGuide

object LabValuesData {

    val panicValues: List<CriticalPanicLabValue> = listOf(
        // ==========================================
        // ELECTROLYTES & RENAL
        // ==========================================
        CriticalPanicLabValue(
            id = "panic_k_high",
            testName = "Serum Potassium (K+) - Severe Hyperkalemia",
            category = "Electrolytes & Renal",
            normalRange = "3.5 - 5.0",
            criticalLowValue = null,
            criticalHighValue = "> 6.0 (or > 6.5 mEq/L)",
            unit = "mEq/L (mmol/L)",
            panicThresholdDescription = "Imminent risk of sinusoidal bradycardia, ventricular fibrillation, and asystolic cardiac arrest.",
            immediateClinicalInterventions = listOf(
                "Immediate 12-lead ECG: Look for tall peaked T waves, prolonged PR, flattened P, widened QRS, sine-wave pattern.",
                "1. MEMBRANE STABILIZATION: Calcium Gluconate 10% 10-20 mL (1-2 ampoules) IV over 2-5 min (onset 1-3 min, duration 30-60 min). Repeat in 5 min if ECG unchanged.",
                "2. SHIFT POTASSIUM INTRACELLULARLY: Regular Insulin 10 Units IV + 50 mL 50% Dextrose (or 100 mL 25% Dextrose) over 15-30 min (lowers K+ by 0.5-1.0 mEq/L within 30-60 min).",
                "3. BETA-2 AGONIST: Salbutamol (Albuterol) 10-20 mg nebulized over 15 min (synergistic with insulin).",
                "4. SODIUM BICARBONATE: 50-100 mEq IV over 10-15 min ONLY if severe concurrent metabolic acidosis (pH <7.15).",
                "5. ELIMINATION: Furosemide 40-80 mg IV (if kidneys functional) + Calcium Polystyrene Sulfonate (K-Bind 15-30 g PO) or Sodium Zirconium Cyclosilicate (Lokelma 10 g).",
                "6. PREPARE URGENT HEMODIALYSIS: If anuric, refractory to medical therapy, or sine-wave on ECG."
            ),
            commonEtiologies = "Acute kidney injury, end-stage renal disease, missed hemodialysis, potassium-sparing diuretics (spironolactone), ACE inhibitors/ARBs, rhabdomyolysis, tumor lysis syndrome, massive blood transfusion, pseudohyperkalemia (hemolyzed sample/fist clenching).",
            diagnosticPitfalls = "Always rule out pseudohyperkalemia due to in vitro hemolysis before aggressive interventions if the patient has normal renal function and normal ECG."
        ),

        CriticalPanicLabValue(
            id = "panic_k_low",
            testName = "Serum Potassium (K+) - Severe Hypokalemia",
            category = "Electrolytes & Renal",
            normalRange = "3.5 - 5.0",
            criticalLowValue = "< 2.5 mEq/L",
            criticalHighValue = null,
            unit = "mEq/L (mmol/L)",
            panicThresholdDescription = "Risk of Torsades de Pointes, ventricular tachycardia, diaphragmatic paralysis, and rhabdomyolysis.",
            immediateClinicalInterventions = listOf(
                "Continuous cardiac monitoring and 12-lead ECG: Look for ST depression, T wave flattening/inversion, prominent U waves, prolonged QTc.",
                "ALWAYS CHECK & CORRECT SERUM MAGNESIUM: Hypokalemia is refractory to replacement until Mg2+ is >2.0 mg/dL (administer Magnesium Sulfate 2 g IV).",
                "Intravenous Potassium Chloride: Infuse via central line up to 20 mEq/hr (or peripheral line up to 10 mEq/hr in 0.9% NaCl, NOT in dextrose which shifts K+ into cells).",
                "Concurrent oral KCl: 20-40 mEq PO (Potclor syrup 15-30 mL) every 4-6 hours if patient can swallow.",
                "Recheck serum potassium every 2 to 4 hours during active IV replacement."
            ),
            commonEtiologies = "Gastrointestinal losses (severe vomiting, cholera/diarrhea), loop or thiazide diuretics, DKA treatment without potassium, refeeding syndrome, hyperaldosteronism, renal tubular acidosis.",
            diagnosticPitfalls = "Giving potassium in dextrose-containing IV solutions triggers endogenous insulin release, driving potassium further into cells and worsening hypokalemia."
        ),

        CriticalPanicLabValue(
            id = "panic_na_low",
            testName = "Serum Sodium (Na+) - Severe Acute Hyponatremia",
            category = "Electrolytes & Renal",
            normalRange = "135 - 145",
            criticalLowValue = "< 120 mEq/L (or symptomatic < 125)",
            criticalHighValue = null,
            unit = "mEq/L (mmol/L)",
            panicThresholdDescription = "Acute cerebral edema, seizures, coma, respiratory arrest, and tentorial herniation.",
            immediateClinicalInterventions = listOf(
                "If symptomatic with seizures, coma, or altered mental status: Administer Hypertonic Saline 3% NaCl 100 mL IV bolus over 10 minutes.",
                "Repeat 100 mL bolus up to 2 additional times at 10-minute intervals until seizures stop or serum sodium rises by 4-6 mEq/L.",
                "CRITICAL OVERCORRECTION LIMIT: Do NOT increase serum sodium by more than 8-10 mEq/L in the first 24 hours (and <18 mEq/L in 48 hours) to prevent Osmotic Demyelination Syndrome (Central Pontine Myelinolysis).",
                "Check serum sodium every 2 hours during hypertonic saline therapy.",
                "If rapid overcorrection occurs: Stop active fluids, give D5W IV or Desmopressin (DDAVP 1-2 mcg IV) to halt water diuresis."
            ),
            commonEtiologies = "SIADH, thiazide diuretics, psychogenic polydipsia, beer potomania, severe heart failure, liver cirrhosis with ascites, adrenal crisis (Addison's), MDMA (ecstasy) use.",
            diagnosticPitfalls = "Correct for hyperglycemia: For every 100 mg/dL rise in blood glucose above 100 mg/dL, add 1.6 to 2.0 mEq/L to measured sodium."
        ),

        CriticalPanicLabValue(
            id = "panic_na_high",
            testName = "Serum Sodium (Na+) - Severe Hypernatremia",
            category = "Electrolytes & Renal",
            normalRange = "135 - 145",
            criticalLowValue = null,
            criticalHighValue = "> 160 mEq/L",
            unit = "mEq/L (mmol/L)",
            panicThresholdDescription = "Intracellular cerebral dehydration, brain shrinkage, subdural hematoma, and coma.",
            immediateClinicalInterventions = listOf(
                "Calculate Free Water Deficit: Deficit (L) = Total Body Water (0.6 x weight kg in men; 0.5 in women) x [(Serum Na / 140) - 1].",
                "Correct SLOWLY: Maximum correction rate is 8-10 mEq/L per 24 hours to prevent cerebral edema and seizures.",
                "Administer free water enterally (via nasogastric tube with tap water) or intravenously as 5% Dextrose in Water (D5W).",
                "If patient is hemodynamically unstable/hypovolemic: Resuscitate with 0.9% Normal Saline first until blood pressure stabilizes, then switch to hypotonic fluids."
            ),
            commonEtiologies = "Unreplaced water loss in elderly/debilitated patients, central or nephrogenic diabetes insipidus, osmotic diuresis (hyperglycemic hyperosmolar state), severe burns, heat stroke.",
            diagnosticPitfalls = "Rapid reduction of chronic hypernatremia causes acute cerebral edema and herniation because brain cells synthesize idiogenic osmoles that draw water inward."
        ),

        // ==========================================
        // HEMATOLOGY
        // ==========================================
        CriticalPanicLabValue(
            id = "panic_platelets",
            testName = "Platelet Count - Severe Thrombocytopenia",
            category = "Hematology",
            normalRange = "150,000 - 450,000",
            criticalLowValue = "< 20,000 /uL (or < 10,000 asymptomatic)",
            criticalHighValue = "> 1,000,000 /uL (Thrombocytosis)",
            unit = "/uL (cells/mcL)",
            panicThresholdDescription = "Spontaneous life-threatening intracranial hemorrhage, gastrointestinal bleeding, and pulmonary alveolar hemorrhage.",
            immediateClinicalInterventions = listOf(
                "Platelet count <10,000: Transfuse 1 adult therapeutic dose of platelets (1 single-donor apheresis unit or 4-6 random-donor units) immediately, even if asymptomatic.",
                "Platelet count <50,000 with active bleeding, lumbar puncture, or major surgery: Transfuse platelets immediately to target >50,000 (target >100,000 for neurosurgery/ophthalmic).",
                "EXCEPTIONS (DO NOT TRANSFUSE): Thrombotic Thrombocytopenic Purpura (TTP) and Heparin-Induced Thrombocytopenia (HIT) - transfusion 'fuels the fire' of microvascular thrombosis.",
                "Immune Thrombocytopenia (ITP): First-line is IV Methylprednisolone 1 g daily x 3 days + IVIG 1 g/kg x 1-2 days (platelet transfusion only for life-threatening bleeding).",
                "Strict bleeding precautions: Avoid IM injections, avoid NSAIDs/antiplatelets, soft toothbrush, fall prevention."
            ),
            commonEtiologies = "Immune thrombocytopenia (ITP), Dengue with shock, hematologic malignancies (leukemia, aplastic anemia), sepsis-induced DIC, chemotherapeutic bone marrow suppression, TTP, HIT, hypersplenism.",
            diagnosticPitfalls = "Check peripheral blood smear to rule out pseudothrombocytopenia due to EDTA-induced platelet clumping (re-collect in sodium citrate / green-top heparin tube)."
        ),

        CriticalPanicLabValue(
            id = "panic_hemoglobin",
            testName = "Hemoglobin (Hb) - Severe Critical Anemia",
            category = "Hematology",
            normalRange = "12.0 - 17.5",
            criticalLowValue = "< 6.0 g/dL (or < 7.0 g/dL symptomatic)",
            criticalHighValue = "> 20.0 g/dL (Hyperviscosity risk)",
            unit = "g/dL",
            panicThresholdDescription = "Myocardial infarction, acute high-output heart failure, tissue hypoxia, and cerebral ischemia.",
            immediateClinicalInterventions = listOf(
                "Immediate type and crossmatch for Packed Red Blood Cells (PRBCs).",
                "Transfuse 1-2 units PRBCs (restrictive transfusion target is Hb 7-8 g/dL for stable inpatients, target 8-10 g/dL for acute coronary syndrome / active myocardial ischemia).",
                "Administer high-flow supplemental oxygen.",
                "Assess for active bleeding: Digital rectal exam, nasogastric lavage if upper GI bleed, abdominal ultrasound (FAST exam).",
                "In severe chronic anemia, infuse each unit slowly over 3-4 hours with IV Furosemide 20 mg between units to prevent transfusion-associated circulatory overload (TACO)."
            ),
            commonEtiologies = "Acute gastrointestinal hemorrhage (varices, peptic ulcer), trauma, post-partum hemorrhage (PPH), ruptured ectopic pregnancy, severe nutritional deficiency (iron/B12), autoimmune hemolytic anemia, bone marrow failure.",
            diagnosticPitfalls = "In hyperacute massive blood loss (e.g. ruptured aneurysm/trauma), the initial Hb may be falsely normal because both red cells and plasma are lost equally before crystalloid fluid shifts occur."
        ),

        // ==========================================
        // BLOOD GAS & ACID-BASE
        // ==========================================
        CriticalPanicLabValue(
            id = "panic_ph_acidosis",
            testName = "Arterial Blood Gas pH - Severe Acidemia",
            category = "Blood Gas & Acid-Base",
            normalRange = "7.35 - 7.45",
            criticalLowValue = "< 7.20 (Severe) / < 7.10 (Life-threatening)",
            criticalHighValue = "> 7.60 (Severe Alkalemia)",
            unit = "pH units",
            panicThresholdDescription = "Impaired myocardial contractility, peripheral vasodilation, refractory hypotension, resistance to catecholamines/vasopressors, and hyperkalemic arrhythmias.",
            immediateClinicalInterventions = listOf(
                "Determine etiology: Calculate Anion Gap = Na - (Cl + HCO3). High anion gap (>12) indicates GOLDMARK: Glycols, Oxoproline, L-lactate, D-lactate, Methanol, Aspirin, Renal failure, Ketoacidosis.",
                "DKA: IV Regular Insulin infusion + IV 0.9% Normal Saline; do NOT give routine bicarbonate unless pH <6.9.",
                "Severe Sepsis / Lactic Acidosis: Rapid IV fluid resuscitation (30 mL/kg crystalloids) + source control + broad-spectrum antimicrobials + Norepinephrine.",
                "Sodium Bicarbonate 8.4%: Reserve strictly for severe metabolic acidosis with pH <7.10, HCO3 <6, and hemodynamic instability (give 50-100 mEq slow IV infusion), or severe TCA/salicylate poisoning.",
                "If respiratory acidosis (high PaCO2): Optimize mechanical ventilation (increase minute ventilation, clear secretions, reverse opioid/sedative)."
            ),
            commonEtiologies = "Diabetic ketoacidosis (DKA), septic shock with lactic acidosis, cardiac arrest, toxic alcohol ingestion (methanol, ethylene glycol), uremic acute renal failure, severe diarrhea, respiratory failure.",
            diagnosticPitfalls = "Rapid boluses of Sodium Bicarbonate increase PaCO2 (which diffuses into cells faster than bicarbonate, worsening paradoxical intracellular cerebral acidosis) and shift potassium into cells, triggering hypokalemia."
        ),

        CriticalPanicLabValue(
            id = "panic_lactate",
            testName = "Serum / Arterial Lactate - Severe Lactic Acidosis",
            category = "Blood Gas & Acid-Base",
            normalRange = "0.5 - 2.0",
            criticalLowValue = null,
            criticalHighValue = "> 4.0 mmol/L (Severe Sepsis / Hypoperfusion)",
            unit = "mmol/L",
            panicThresholdDescription = "Profound anaerobic tissue hypoperfusion, severe septic shock, mesenteric ischemia, and multi-organ failure with high short-term mortality (>40%).",
            immediateClinicalInterventions = listOf(
                "Surviving Sepsis Bundle: Initiate within 1 hour: Measure lactate, obtain blood cultures, start broad-spectrum IV antimicrobials, administer 30 mL/kg crystalloid fluid bolus for hypotension or lactate ≥4.",
                "Apply vasopressors (Norepinephrine first-line) during or after fluid resuscitation to maintain MAP ≥65 mmHg.",
                "Re-measure lactate every 2 to 4 hours to guide resuscitation (target >20% clearance every 2 hours).",
                "Rule out surgical emergencies: Acute mesenteric ischemia, necrotizing fasciitis, gangrenous bowel, ruptured viscera."
            ),
            commonEtiologies = "Septic shock, cardiogenic shock, hypovolemic/hemorrhagic shock, acute mesenteric ischemia, carbon monoxide poisoning, metformin-associated lactic acidosis (MALA), status epilepticus, severe hepatic failure.",
            diagnosticPitfalls = "Type B lactic acidosis can occur without tissue hypoxia (e.g. high-dose epinephrine or salbutamol stimulation, liver failure, thiamine deficiency, linezolid toxicity, or severe diabetic ketoacidosis)."
        ),

        // ==========================================
        // CARDIAC & COAGULATION
        // ==========================================
        CriticalPanicLabValue(
            id = "panic_troponin",
            testName = "High-Sensitivity Cardiac Troponin (hs-cTnI / hs-cTnT)",
            category = "Cardiac & Biomarkers",
            normalRange = "< 14 ng/L (cTnT) or < 26 ng/L (cTnI)",
            criticalLowValue = null,
            criticalHighValue = "> 99th percentile with dynamic delta rise/fall",
            unit = "ng/L or pg/mL",
            panicThresholdDescription = "Acute myocardial injury and myocardial infarction (NSTEMI / STEMI).",
            immediateClinicalInterventions = listOf(
                "Immediate 12-lead ECG: Check for ST elevations (STEMI criteria: activate catheterization lab / administer Tenecteplase if PCI not available within 120 min).",
                "If ST-elevation absent: Serial high-sensitivity troponin at 0 and 1-3 hours to establish dynamic delta rise/fall (>5 ng/L change or >20% rise).",
                "Loading dose Antiplatelet therapy: Aspirin 300 mg chewed + Clopidogrel 300-600 mg (or Ticagrelor 180 mg) + therapeutic anticoagulation (Enoxaparin 1 mg/kg SC BID or UFH).",
                "Sublingual Nitroglycerin 0.4 mg every 5 min (max 3 doses) for ischemic chest pain (contraindicated if SBP <90, HR <50, or recent PDE5 inhibitor).",
                "Admit to Coronary Care Unit (CCU) for continuous telemetry monitoring and risk stratification (GRACE / TIMI score)."
            ),
            commonEtiologies = "Type 1 Myocardial Infarction (plaque rupture), Type 2 MI (demand ischemia in sepsis, tachyarrhythmia, severe anemia), acute pulmonary embolism, acute aortic dissection, myocarditis, Takotsubo cardiomyopathy, acute heart failure, end-stage renal disease.",
            diagnosticPitfalls = "Troponin indicates myocardial injury, NOT necessarily plaque rupture; always evaluate clinical history, ECG changes, and dynamic delta kinetics."
        ),

        CriticalPanicLabValue(
            id = "panic_inr",
            testName = "Prothrombin Time / INR - Critical Coagulopathy",
            category = "Coagulation",
            normalRange = "0.8 - 1.2 (Therapeutic 2.0 - 3.0)",
            criticalLowValue = null,
            criticalHighValue = "> 5.0 (without bleed) or > 9.0 (extreme)",
            unit = "INR ratio",
            panicThresholdDescription = "High risk of spontaneous intracranial hemorrhage, fatal retroperitoneal hematoma, and GI bleeding.",
            immediateClinicalInterventions = listOf(
                "MAJOR BLEEDING (Any INR): Stop warfarin/anticoagulant + 4-Factor PCC 25-50 IU/kg IV (or FFP 15 mL/kg if PCC unavailable) + Vitamin K1 5-10 mg slow IV in 50 mL saline over 30 min.",
                "NO BLEEDING, INR >9.0: Withhold warfarin + Vitamin K1 2.5-5.0 mg PO. Check INR in 24 hours.",
                "NO BLEEDING, INR 4.5 - 10.0: Withhold next 1-2 doses of warfarin, monitor, resume at lower dose when INR therapeutic.",
                "Strict avoidance of invasive procedures, intramuscular injections, and antiplatelets/NSAIDs."
            ),
            commonEtiologies = "Warfarin or Acenocoumarol overdose, drug interactions (metronidazole, fluconazole, amiodarone, ciprofloxacin), acute liver failure, disseminated intravascular coagulation (DIC), severe Vitamin K deficiency.",
            diagnosticPitfalls = "Oral Vitamin K is safer and more predictable than IV Vitamin K for non-bleeding patients and avoids IV anaphylactoid reactions."
        ),

        // ==========================================
        // ENDOCRINE & METABOLIC
        // ==========================================
        CriticalPanicLabValue(
            id = "panic_glucose_low",
            testName = "Blood Glucose - Severe Hypoglycemia",
            category = "Endocrine & Metabolic",
            normalRange = "70 - 140",
            criticalLowValue = "< 54 mg/dL (< 3.0 mmol/L) / Panic < 40",
            criticalHighValue = "> 400 mg/dL with ketones (DKA/HHS risk)",
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "Hypoglycemic coma, irreversible neuronal necrosis, status epilepticus, and cardiac arrhythmias.",
            immediateClinicalInterventions = listOf(
                "Conscious patient (Rule of 15): 15-20 g of rapid-acting simple oral carbohydrates (4 glucose tablets, half cup fruit juice, or 3 teaspoons sugar). Recheck blood glucose in 15 minutes.",
                "Unconscious / IV access available: 50 mL of 50% Dextrose (D50W) or 100 mL of 25% Dextrose (D25W) IV push over 2-3 minutes.",
                "No IV access: Glucagon 1 mg IM or SC (or 3 mg nasal powder).",
                "Follow-up: Once conscious, provide complex carbohydrate snack/meal (bread/rice/milk). Maintain D10W infusion if due to long-acting sulfonylureas or basal insulin.",
                "Refractory sulfonylurea hypoglycemia: Administer Octreotide 50-100 mcg SC/IV every 8 hours."
            ),
            commonEtiologies = "Excess insulin or sulfonylurea dosing, skipped meals, strenuous exercise, acute alcohol intoxication, severe sepsis, end-stage liver disease, adrenal insufficiency (Addisonian crisis), insulinoma.",
            diagnosticPitfalls = "Beta-blockers mask classic adrenergic warning signs (tremors, palpitations, anxiety); diaphoresis (sweating) is typically the only preserved symptom."
        )
    )

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
        )
    )
}
