package com.example.data.repository

import com.example.data.model.CriticalPanicLabValue

object EmergencyPanicLabValuesData {

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

        CriticalPanicLabValue(
            id = "panic_ca_high",
            testName = "Serum Calcium (Ca2+) - Severe Hypercalcemic Crisis",
            category = "Electrolytes & Renal",
            normalRange = "8.5 - 10.5",
            criticalLowValue = null,
            criticalHighValue = "> 13.0 - 14.0 mg/dL (or Ionized Ca > 3.0 mmol/L)",
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "Shortened QT interval, ventricular arrhythmias, acute renal failure, encephalopathy ('stones, bones, groans, psychiatric moans'), and coma.",
            immediateClinicalInterventions = listOf(
                "1. VIGOROUS FLUID RESUSCITATION: Normal Saline (0.9% NaCl) 200-500 mL/hr (target 2-4 Liters in 24 hours) to restore intravascular volume and promote renal calcium excretion.",
                "2. CALCITONIN: Salmon Calcitonin 4-8 IU/kg IM/SC q12h (rapid onset in 2-4 hours, lowers calcium by 1-2 mg/dL; tachyphylaxis develops after 48h).",
                "3. BISPHOSPHONATES: Zoledronic Acid 4 mg IV infusion over 15 min OR Pamidronate 60-90 mg IV over 2-4 hours (onset in 48-72 hours; peak efficacy at 4-7 days).",
                "4. GLUCOCORTICOIDS: Hydrocortisone 100 mg IV q8h or Prednisone 40-60 mg PO daily for lymphoma, granulomatous disease (sarcoidosis, TB), or vitamin D toxicity.",
                "5. URGENT HEMODIALYSIS: Low-calcium or zero-calcium dialysate if oliguric renal failure, severe heart failure, or refractory Ca >18 mg/dL."
            ),
            commonEtiologies = "Malignancy (PTHrP production in squamous cell lung/head-neck carcinoma; bone osteolysis in breast cancer/multiple myeloma), Primary Hyperparathyroidism (adenoma), Vitamin D toxicity, Sarcoidosis, Milk-Alkali Syndrome, Thiazide diuretics.",
            diagnosticPitfalls = "ALWAYS calculate Albumin-Corrected Calcium: Corrected Ca (mg/dL) = Measured Total Ca + 0.8 x (4.0 - Serum Albumin g/dL). Avoid loop diuretics (furosemide) until intravascular volume is fully repleted."
        ),

        CriticalPanicLabValue(
            id = "panic_ca_low",
            testName = "Serum Calcium (Ca2+) - Severe Acute Hypocalcemia",
            category = "Electrolytes & Renal",
            normalRange = "8.5 - 10.5",
            criticalLowValue = "< 6.5 mg/dL (or Ionized Ca < 0.8 mmol/L)",
            criticalHighValue = null,
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "Laryngeal stridor/spasm, carpopedal spasm, tetany, grand mal seizures, prolonged QT interval, and Torsades de Pointes.",
            immediateClinicalInterventions = listOf(
                "1. IMMEDIATE IV CALCIUM: Calcium Gluconate 10% 10-20 mL (1-2 g) diluted in 50-100 mL D5W infused IV over 10-20 minutes with continuous ECG monitoring.",
                "2. CONTINUOUS CALCIUM INFUSION: If symptoms recur, infuse 10 ampoules (100 mL) Calcium Gluconate in 1000 mL D5W at 50-100 mL/hr (0.5-1.5 mg elemental Ca/kg/hr).",
                "3. CHECK & CORRECT MAGNESIUM: Hypocalcemia is refractory to calcium therapy if concurrent hypomagnesemia is present (give Magnesium Sulfate 2 g IV).",
                "4. TRANSITION TO ORAL: Calcitriol (active 1,25-OH Vitamin D) 0.5-2 mcg/day + Calcium Carbonate 1-2 g elemental Ca TID once acute symptoms resolve."
            ),
            commonEtiologies = "Post-thyroidectomy or post-parathyroidectomy hypoparathyroidism, severe acute pancreatitis (fat saponification), severe sepsis, massive citrated blood transfusion, hungry bone syndrome, severe Vitamin D deficiency, tumor lysis syndrome (hyperphosphatemia binds calcium).",
            diagnosticPitfalls = "Check Chvostek's sign (facial twitching tapping facial nerve) and Trousseau's sign (carpal spasm inflating BP cuff >systolic for 3 min). Never infuse calcium in bicarbonate-containing solutions (precipitates as insoluble chalk!)."
        ),

        CriticalPanicLabValue(
            id = "panic_mg_low",
            testName = "Serum Magnesium (Mg2+) - Severe Hypomagnesemia",
            category = "Electrolytes & Renal",
            normalRange = "1.7 - 2.2",
            criticalLowValue = "< 1.0 mg/dL (< 0.4 mmol/L)",
            criticalHighValue = null,
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "Intractable ventricular arrhythmias (Torsades de Pointes), refractory hypokalemia, neuromuscular hyperexcitability, tetany, and seizures.",
            immediateClinicalInterventions = listOf(
                "Symptomatic or Torsades de Pointes: Administer Magnesium Sulfate 2 g IV push in 10 mL D5W/Saline over 1 to 2 minutes.",
                "Non-emergent severe replacement: Magnesium Sulfate 2 to 4 g IV diluted in 100 mL Normal Saline or D5W infused over 1 to 2 hours, followed by 4-8 g over 24 hours.",
                "Recognize that only 1% of total body magnesium is in serum; total body intracellular deficit is typically massive (several grams); replace over 3-5 days.",
                "Concurrently replace Potassium and Calcium, which fail to correct without magnesium."
            ),
            commonEtiologies = "Chronic alcohol use disorder, chronic diarrhea/malabsorption, loop or thiazide diuretics, prolonged Proton Pump Inhibitor (PPI) therapy, aminoglycosides/amphotericin B, refeeding syndrome, uncontrolled DKA.",
            diagnosticPitfalls = "Magnesium is an essential cofactor for Na+/K+-ATPase and PTH release; unexplained refractory hypokalemia or hypocalcemia is almost always secondary to occult hypomagnesemia."
        ),

        CriticalPanicLabValue(
            id = "panic_mg_high",
            testName = "Serum Magnesium (Mg2+) - Severe Hypermagnesemia",
            category = "Electrolytes & Renal",
            normalRange = "1.7 - 2.2",
            criticalLowValue = null,
            criticalHighValue = "> 4.5 - 5.0 mg/dL (> 2.0 mmol/L)",
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "Loss of deep tendon reflexes (>5 mg/dL), hypotension, respiratory depression/paralysis (>10 mg/dL), complete heart block, and asystole (>15 mg/dL).",
            immediateClinicalInterventions = listOf(
                "1. STOP ALL MAGNESIUM INTAKE: Immediately halt Magnesium Sulfate infusions, antacids, or laxatives.",
                "2. PHYSIOLOGIC ANTAGONIST: Calcium Gluconate 10% 10-20 mL (1-2 g) IV slowly over 3-5 minutes (reverses neuromuscular and cardiac depression immediately).",
                "3. FORCED DIURESIS: Normal Saline IV infusion + Furosemide 20-40 mg IV if renal function is intact.",
                "4. URGENT HEMODIALYSIS: Dialysis with magnesium-free dialysate is the definitive treatment in patients with renal failure or severe cardiac/respiratory toxicity."
            ),
            commonEtiologies = "Iatrogenic overdose during eclampsia therapy (MgSO4), magnesium-containing antacids/laxatives (Milk of Magnesia) in patients with chronic kidney disease, tumor lysis syndrome, adrenal insufficiency.",
            diagnosticPitfalls = "Loss of patellar deep tendon reflexes is the earliest clinical sign of magnesium toxicity; always check knee-jerk reflexes before each maintenance dose of magnesium sulfate."
        ),

        CriticalPanicLabValue(
            id = "panic_po4_low",
            testName = "Serum Phosphate - Severe Hypophosphatemia",
            category = "Electrolytes & Renal",
            normalRange = "2.5 - 4.5",
            criticalLowValue = "< 1.0 mg/dL (< 0.3 mmol/L)",
            criticalHighValue = null,
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "ATP depletion causing respiratory muscle failure (failure to wean from mechanical ventilation), acute rhabdomyolysis, impaired cardiac contractility, and hemolysis.",
            immediateClinicalInterventions = listOf(
                "1. IV PHOSPHATE REPLACEMENT: Sodium Phosphate or Potassium Phosphate 0.25 to 0.50 mmol/kg IV infused slowly over 4 to 6 hours.",
                "Do NOT infuse IV phosphate rapidly (precipitates with calcium, causing metastatic soft-tissue calcification and severe hypocalcemia).",
                "Monitor serum Calcium, Potassium, and Phosphate every 6 hours during parenteral replacement.",
                "Switch to oral sodium/potassium phosphate supplements (500-1000 mg elemental phosphorus PO TID) once serum levels rise >1.5 mg/dL."
            ),
            commonEtiologies = "Refeeding Syndrome (rapid carbohydrate intake in malnourished/alcoholic patients stimulates insulin, driving phosphate into cells to form ATP), Diabetic Ketoacidosis treatment, severe respiratory alkalosis, phosphate binders, severe burns.",
            diagnosticPitfalls = "In refeeding syndrome and DKA, initial serum phosphate may be normal; profound hypophosphatemia develops precipitously 12-48 hours after starting nutrition or insulin."
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

        CriticalPanicLabValue(
            id = "panic_anc_low",
            testName = "Absolute Neutrophil Count (ANC) - Critical Agranulocytosis / Febrile Neutropenia",
            category = "Hematology",
            normalRange = "1,500 - 8,000",
            criticalLowValue = "< 500 /uL (Severe) / < 100 /uL (Agranulocytosis)",
            criticalHighValue = null,
            unit = "/uL (cells/mcL)",
            panicThresholdDescription = "Catastrophic risk of rapid, overwhelming pseudomonal, enteric Gram-negative, or fungal bacteremia and septic shock with minimal inflammatory signs.",
            immediateClinicalInterventions = listOf(
                "1. DOOR-TO-ANTIBIOTIC TIME < 60 MINUTES: If temperature ≥38.0°C (100.4°F) or hypothermia with ANC <500, initiate empirical antipseudomonal monotherapy immediately.",
                "2. FIRST-LINE ANTIMICROBIAL: Piperacillin-Tazobactam 4.5 g IV q6h OR Cefepime 2 g IV q8h OR Meropenem 1 g IV q8h.",
                "3. ADD VANCOMYCIN 15-20 mg/kg IV if hemodynamic instability, suspected catheter-related infection, skin/soft tissue infection, or MRSA colonization.",
                "4. G-CSF: Administer Filgrastim 5 mcg/kg SC daily in high-risk septic patients to stimulate myeloid recovery.",
                "5. Strict reverse protective isolation: Hand hygiene, private room, avoid rectal temperatures or rectal exams."
            ),
            commonEtiologies = "Cytotoxic chemotherapy, Clozapine, Antithyroid drugs (Methimazole, Carbimazole, Propylthiouracil), Aplastic anemia, Acute leukemia, Cotrimoxazole, Severe viral infections (HIV, EBV).",
            diagnosticPitfalls = "Neutropenic patients cannot mount an adequate pyogenic response; erythema, pus, or pulmonary infiltrates on CXR may be completely absent. Unexplained fever or subtle tachycardia is an emergency!"
        ),

        CriticalPanicLabValue(
            id = "panic_wbc_high",
            testName = "White Blood Cell Count (WBC) - Hyperleukocytosis & Blast Crisis",
            category = "Hematology",
            normalRange = "4,000 - 11,000",
            criticalLowValue = null,
            criticalHighValue = "> 100,000 /uL (> 100 x 10^9/L)",
            unit = "/uL (cells/mcL)",
            panicThresholdDescription = "Leukostasis syndrome with microvascular occlusion, pulmonary failure/hypoxemia, intracranial hemorrhage, and acute renal failure.",
            immediateClinicalInterventions = listOf(
                "1. AGGRESSIVE HYDRATION: Normal Saline 200-300 mL/hr to maintain high renal perfusion and prevent acute uric acid nephropathy.",
                "2. TUMOR LYSIS PROPHYLAXIS: Rasburicase 0.2 mg/kg IV (or Allopurinol 300 mg PO) + monitor potassium, uric acid, phosphorus, and calcium every 6 hours.",
                "3. CYTOREDUCTION: Hydroxyurea 50-100 mg/kg/day PO OR urgent induction chemotherapy under hematologist guidance.",
                "4. EMERGENCY LEUKAPHERESIS: If acute CNS symptoms (confusion, stupor, visual loss) or respiratory failure occurs in acute myeloid leukemia (AML).",
                "AVOID PRBC TRANSFUSION: Transfusing red blood cells drastically increases whole blood viscosity, precipitating fatal leukostasis occlusion!"
            ),
            commonEtiologies = "Acute Myeloid Leukemia (AML - blasts have high rigidity and adhesiveness), Chronic Myelogenous Leukemia in blast crisis (CML), Acute Lymphoblastic Leukemia (ALL), Severe leukemoid reaction.",
            diagnosticPitfalls = "Leukemic blasts consume oxygen in vitro; pulse oximetry reflects true arterial oxygenation better than arterial blood gas PaO2 (which may show spurious pseudo-hypoxemia)."
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
            id = "panic_pao2_low",
            testName = "Arterial Blood Gas PaO2 - Severe Hypoxemic Respiratory Failure",
            category = "Blood Gas & Acid-Base",
            normalRange = "80 - 100",
            criticalLowValue = "< 50 mmHg (or SpO2 < 80%)",
            criticalHighValue = null,
            unit = "mmHg",
            panicThresholdDescription = "Imminent anoxic brain injury, cardiac arrest, and multi-organ ischemic failure.",
            immediateClinicalInterventions = listOf(
                "1. IMMEDIATE HIGH-FLOW OXYGEN: Apply Non-Rebreather Mask (NRBM) at 15 L/min or High-Flow Nasal Cannula (HFNC) at 40-60 L/min with FiO2 1.0.",
                "2. NON-INVASIVE VENTILATION (NIV / BiPAP / CPAP): Indicated for acute cardiogenic pulmonary edema or COPD exacerbation (unless patient is comatose, vomiting, or exhausted).",
                "3. ENDOTRACHEAL INTUBATION: Initiate rapid sequence intubation (RSI) if refractory hypoxemia (P/F ratio <100), exhaustion, severe altered mental status, or hemodynamic instability.",
                "4. LUNG-PROTECTIVE VENTILATION (ARDS): Low tidal volume (6 mL/kg predicted body weight), PEEP titration, permissive hypercapnia, and prone positioning for 16h/day if P/F <150."
            ),
            commonEtiologies = "Acute Respiratory Distress Syndrome (ARDS), severe pneumonia (viral/bacterial), acute pulmonary embolism, acute cardiogenic pulmonary edema, pneumothorax, flail chest, foreign body aspiration.",
            diagnosticPitfalls = "In chronic hypercapnic COPD patients with hypoxic respiratory drive, titrate oxygen carefully to target SpO2 88-92% (not 100%) to avoid blunting respiratory drive and worsening hypercapnic coma."
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
        // CARDIAC & BIOMARKERS
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

        // ==========================================
        // COAGULATION
        // ==========================================
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

        CriticalPanicLabValue(
            id = "panic_fibrinogen_low",
            testName = "Fibrinogen - Critical Hypofibrinogenemia / Consumptive Coagulopathy",
            category = "Coagulation",
            normalRange = "200 - 400",
            criticalLowValue = "< 100 mg/dL (< 1.0 g/L) / Obstetric Panic < 150-200",
            criticalHighValue = null,
            unit = "mg/dL (g/L)",
            panicThresholdDescription = "Inability to form stable fibrin clot, catastrophic postpartum hemorrhage, and microvascular oozing in Disseminated Intravascular Coagulation (DIC).",
            immediateClinicalInterventions = listOf(
                "1. CRYOPRECIPITATE: Administer 10 units of Cryoprecipitate IV immediately (each 10-pack provides ~2-2.5 g fibrinogen and raises plasma fibrinogen by ~50-70 mg/dL).",
                "Alternative: Fibrinogen Concentrate (Riastap) 2 to 4 g IV infused over 5-10 minutes.",
                "2. OBSTETRIC PPH TARGET: In acute postpartum hemorrhage / placental abruption, target fibrinogen ≥200 mg/dL (fibrinogen <200 is an independent predictor of severe PPH needing hysterectomy).",
                "3. TRANEXAMIC ACID (TXA): Administer 1 g IV over 10 minutes within 3 hours of bleeding onset.",
                "4. TREAT UNDERLYING TRIGGER: Evacuate uterine contents, deliver fetus/placenta, achieve surgical hemostasis, treat underlying sepsis/DIC."
            ),
            commonEtiologies = "Disseminated Intravascular Coagulation (DIC from sepsis, trauma, amniotic fluid embolism), Placental abruption, severe Postpartum Hemorrhage (PPH), massive transfusion dilutional coagulopathy, acute liver failure, thrombolytic therapy (tPA/tenecteplase).",
            diagnosticPitfalls = "Fibrinogen is an acute phase reactant; in early sepsis or normal pregnancy, levels are physiologically elevated (400-600 mg/dL). Therefore, a 'normal' level of 200 mg/dL during severe sepsis or labor may represent early consumptive DIC!"
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
            criticalHighValue = null,
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
        ),

        CriticalPanicLabValue(
            id = "panic_glucose_high",
            testName = "Blood Glucose - Severe Hyperglycemic Crisis (DKA / HHS)",
            category = "Endocrine & Metabolic",
            normalRange = "70 - 140",
            criticalLowValue = null,
            criticalHighValue = "> 400 - 600 mg/dL (or Serum Osmolality > 320 mOsm/kg)",
            unit = "mg/dL (mmol/L)",
            panicThresholdDescription = "Severe hypovolemic shock, hyperosmolar coma, deep venous thrombosis, and cerebral edema.",
            immediateClinicalInterventions = listOf(
                "1. FLUID RESUSCITATION: 0.9% Normal Saline 1000-1500 mL IV in first hour, then 250-500 mL/hr based on hydration status.",
                "2. CHECK POTASSIUM BEFORE INSULIN: If K+ <3.3 mEq/L, HOLD insulin and give IV KCl 20-30 mEq/hr until K+ >3.3 (insulin drives potassium into cells, causing fatal cardiac arrest).",
                "3. INSULIN PROTOCOL: If K+ ≥3.3, start Regular Insulin 0.1 Units/kg/hr IV infusion (target glucose drop 50-75 mg/dL/hr).",
                "4. ADD DEXTROSE WHEN GLUCOSE <200-250: Switch IV fluids to D5W + 0.45% Saline while continuing insulin infusion to clear ketoacidosis without causing hypoglycemia.",
                "5. MONITOR HOURLY: Hourly fingerstick glucose, BMP/venous blood gas every 2-4 hours to monitor anion gap closure."
            ),
            commonEtiologies = "Non-compliance with insulin, acute infection (pneumonia, UTI, sepsis), acute myocardial infarction, cerebrovascular accident, acute pancreatitis, corticosteroids, SGLT-2 inhibitors (euglycemic DKA!).",
            diagnosticPitfalls = "Beware of Euglycemic DKA with SGLT-2 inhibitors (Empagliflozin, Dapagliflozin): Blood glucose may be <250 mg/dL despite severe high-anion-gap ketoacidosis!"
        ),

        // ==========================================
        // GASTROINTESTINAL & TOXICOLOGY
        // ==========================================
        CriticalPanicLabValue(
            id = "panic_lipase_high",
            testName = "Serum Lipase - Acute Severe Pancreatitis",
            category = "Endocrine & Metabolic",
            normalRange = "10 - 60",
            criticalLowValue = null,
            criticalHighValue = "≥ 3x ULN (> 180 - 200 U/L)",
            unit = "U/L",
            panicThresholdDescription = "Enzymatic autodigestion of pancreatic parenchyma, systemic inflammatory response syndrome (SIRS), pancreatic necrosis, and multi-organ failure.",
            immediateClinicalInterventions = listOf(
                "1. GOAL-DIRECTED FLUID RESUSCITATION: Ringer's Lactate (preferred over Normal Saline) 200-250 mL/hr (target urine output >0.5-1.0 mL/kg/hr, hematocrit reduction, and normal BUN).",
                "2. ANALGESIA: Multimodal analgesia with IV opioids (Fentanyl or Morphine/Hydromorphone).",
                "3. EARLY ENTERAL NUTRITION: Initiate oral feeding with low-fat solid or liquid diet within 24-48 hours once nausea/pain improves (superior to bowel rest and parenteral nutrition).",
                "4. ETIOLOGY WORKUP: Right upper quadrant ultrasound to rule out choledocholithiasis (gallstone pancreatitis); urgent ERCP within 24 hours if concurrent acute cholangitis.",
                "DO NOT GIVE ROUTINE PROPHYLACTIC ANTIBIOTICS in non-infected acute pancreatitis (reserve antibiotics for proven infected necrotizing pancreatitis after 7-14 days)."
            ),
            commonEtiologies = "Gallstones (40%), Alcohol misuse (30%), Hypertriglyceridemia (triglycerides >1000 mg/dL), Post-ERCP, Medications (azathioprine, valproate, thiazides), Hypercalcemia, Trauma.",
            diagnosticPitfalls = "Lipase levels do NOT correlate with the clinical severity or prognosis of acute pancreatitis; use clinical scoring systems (BISAP score, Apache II) and contrast CT at 72 hours for necrosis."
        ),

        CriticalPanicLabValue(
            id = "panic_ammonia_high",
            testName = "Serum Ammonia - Severe Hyperammonemia",
            category = "Cardiac & Biomarkers",
            normalRange = "15 - 45",
            criticalLowValue = null,
            criticalHighValue = "> 100 - 150 umol/L",
            unit = "umol/L",
            panicThresholdDescription = "Astrocyte swelling, severe cerebral edema, acute hepatic encephalopathy (Grade 3/4 coma), and brain herniation.",
            immediateClinicalInterventions = listOf(
                "1. LACTULOSE: 30 mL PO/NG every 1-2 hours until bowel evacuation occurs (titrate to 2-3 soft acidic stools/day); for coma, administer retention enema (300 mL lactulose in 700 mL water).",
                "2. RIFAXIMIN: Add Rifaximin 550 mg PO BID to lactulose for synergistic reduction of colonic ammonia-producing bacteria.",
                "3. LOLA (L-Ornithine L-Aspartate): 20-30 g/day IV infusion stimulates urea synthesis and glutamine synthesis in residual liver and muscle.",
                "4. IDENTIFY PRECIPITATING FACTOR: GI bleeding (endoscopy), spontaneous bacterial peritonitis (diagnostic paracentesis), constipation, hypokalemia, sedatives.",
                "5. URGENT HEMODIALYSIS: If due to inborn errors of metabolism / urea cycle disorders with ammonia >400 umol/L."
            ),
            commonEtiologies = "Cirrhosis with decompensation and portosystemic shunts, Acute Liver Failure, Valproic acid-induced hyperammonemic encephalopathy, Urea cycle defects, Transjugular intrahepatic portosystemic shunt (TIPS).",
            diagnosticPitfalls = "Blood must be drawn on ice and transported immediately to the lab without a tourniquet; venous stasis and room temperature cause in vitro deamination, creating false elevations."
        ),

        CriticalPanicLabValue(
            id = "panic_lithium_high",
            testName = "Serum Lithium - Critical Lithium Toxicity",
            category = "Cardiac & Biomarkers",
            normalRange = "0.6 - 1.2",
            criticalLowValue = null,
            criticalHighValue = "> 1.5 - 2.0 mEq/L (Severe Toxicity > 2.5)",
            unit = "mEq/L (mmol/L)",
            panicThresholdDescription = "Severe cerebellar ataxia, coarse tremor, delirium, seizures, non-convulsive status epilepticus, and permanent neurological sequelae (SILENT syndrome).",
            immediateClinicalInterventions = listOf(
                "1. STOP LITHIUM IMMEDIATELY: Discontinue all lithium dosing and offending drug interactions (NSAIDs, ACE inhibitors, thiazide diuretics).",
                "2. VOLUME RESUSCITATION: 0.9% Normal Saline IV at 150-200 mL/hr to restore GFR and facilitate renal lithium clearance.",
                "3. INDICATIONS FOR EMERGENCY HEMODIALYSIS: Serum Lithium >4.0 mEq/L regardless of symptoms; Serum Lithium >2.5 mEq/L with severe neurologic symptoms or renal impairment.",
                "4. Note: Activated charcoal does NOT adsorb lithium; for massive acute ingestions of sustained-release lithium, Whole Bowel Irrigation with PEG-ELS may be considered."
            ),
            commonEtiologies = "Dehydration, intercurrent viral illness with diarrhea/vomiting, drug interactions with NSAIDs (ibuprofen, diclofenac), ACEIs/ARBs, and thiazides (which decrease lithium clearance by 30-50%), acute deliberate overdose.",
            diagnosticPitfalls = "Serum levels may rebound several hours after hemodialysis due to slow redistribution from intracellular compartments; repeat serum lithium levels every 4-6 hours post-dialysis."
        ),

        CriticalPanicLabValue(
            id = "panic_digoxin_high",
            testName = "Serum Digoxin - Critical Digoxin Toxicity",
            category = "Cardiac & Biomarkers",
            normalRange = "0.5 - 0.9 (Heart Failure) / 0.8 - 2.0 (Afib)",
            criticalLowValue = null,
            criticalHighValue = "> 2.0 - 2.5 ng/mL",
            unit = "ng/mL (nmol/L)",
            panicThresholdDescription = "Life-threatening ventricular arrhythmias (bidirectional VT, PVCs), severe junctional bradycardia, high-grade AV block, and hyperkalemia.",
            immediateClinicalInterventions = listOf(
                "1. DEFINITIVE ANTIDOTE: Digoxin-Specific Antibody Fragments (DigiFab / Digibind) IV.\n• Acute Ingestion: 10-20 vials IV if dose/level unknown.\n• Chronic Toxicity: Dose (vials) = [Serum Digoxin (ng/mL) x Weight (kg)] / 100.",
                "2. SEVERE HYPERKALEMIA IN DIGOXIN TOXICITY: Treat with Insulin/Dextrose; DO NOT GIVE CALCIUM GLUCONATE ('stone heart' theoretical risk of irreversible systolic arrest).",
                "3. BRADYARRHYTHMIAS: Atropine 0.5-1.0 mg IV; prepare transcutaneous/transvenous pacing if refractory to DigiFab.",
                "4. TACHYARRHYTHMIAS: Magnesium Sulfate 2 g IV over 10 min and Lidocaine or Phenytoin."
            ),
            commonEtiologies = "Acute kidney injury in elderly patients, drug interactions (amiodarone, verapamil, quinidine, clarithromycin displace digoxin and double levels), hypokalemia/hypomagnesemia (sensitizes myocardium to digitalis toxicity).",
            diagnosticPitfalls = "After DigiFab administration, total serum digoxin measurements are falsely elevated (measuring inactive antibody-bound drug); do NOT use post-treatment digoxin levels to guide clinical care."
        )
    )
}
