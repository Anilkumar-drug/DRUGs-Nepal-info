package com.example.data.repository

import com.example.data.model.StandardLabTest

object ComprehensiveStandardLabPanelsData {

    val standardLabTests: List<StandardLabTest> = listOf(
        // ==========================================
        // 1. COMPLETE BLOOD COUNT (CBC)
        // ==========================================
        StandardLabTest(
            id = "lab_hemoglobin",
            name = "Hemoglobin (Hb)",
            panel = "Complete Blood Count (CBC)",
            standardRange = "Male: 13.5 - 17.5 • Female: 12.0 - 15.5",
            conventionalUnits = "g/dL",
            siUnits = "g/L",
            siRange = "Male: 135 - 175 • Female: 120 - 155",
            highSignificance = "Polycythemia vera, chronic hypoxemia (COPD, cyanotic congenital heart disease), high altitude living, dehydration (hemoconcentration).",
            lowSignificance = "Anemia (iron deficiency, chronic disease, hemolysis, B12/folate deficiency), acute hemorrhage, bone marrow suppression, hemodilution.",
            clinicalPearls = "Rule of 3: Hemoglobin x 3 ≈ Hematocrit (e.g. Hb 10 g/dL corresponds to Hct ~30%). Restrictive transfusion threshold for stable inpatients is Hb <7.0 g/dL (target 7-8 g/dL).",
            sampleTube = "Lavender Top (K2/K3 EDTA Tube)"
        ),

        StandardLabTest(
            id = "lab_hematocrit",
            name = "Hematocrit (Hct / PCV)",
            panel = "Complete Blood Count (CBC)",
            standardRange = "Male: 41 - 50% • Female: 36 - 44%",
            conventionalUnits = "%",
            siUnits = "L/L",
            siRange = "Male: 0.41 - 0.50 • Female: 0.36 - 0.44",
            highSignificance = "Severe hemoconcentration in Dengue hemorrhagic fever (Hct rise ≥20% indicates vascular plasma leak), polycythemia, burn shock.",
            lowSignificance = "Acute/chronic blood loss, hemolysis, hemodilution from aggressive crystalloid resuscitation, bone marrow failure.",
            clinicalPearls = "In acute Dengue fever monitoring, a rising hematocrit accompanied by declining platelets is the hallmark of plasma leakage requiring crystalloid volume support.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_wbc",
            name = "Total Leukocyte Count (WBC)",
            panel = "Complete Blood Count (CBC)",
            standardRange = "4,000 - 11,000",
            conventionalUnits = "/uL",
            siUnits = "x 10^9/L",
            siRange = "4.0 - 11.0",
            highSignificance = "Bacterial infections, tissue necrosis (myocardial infarction), severe physiological stress, corticosteroids, leukemoid reaction, leukemia.",
            lowSignificance = "Viral infections (dengue, influenza, hepatitis), severe sepsis / septic shock (poor prognostic sign), drug-induced marrow suppression, aplastic anemia.",
            clinicalPearls = "A 'left shift' (presence of >10% immature band forms) indicates acute bacterial infection or severe systemic inflammation even if total WBC count is within normal limits.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_anc",
            name = "Absolute Neutrophil Count (ANC)",
            panel = "Complete Blood Count (CBC)",
            standardRange = "1,500 - 8,000 (50 - 70% of WBC)",
            conventionalUnits = "/uL",
            siUnits = "x 10^9/L",
            siRange = "1.5 - 8.0",
            highSignificance = "Acute bacterial infections, neutrophilic leukocytosis, appendicitis, sepsis, high-dose corticosteroid administration (demargination).",
            lowSignificance = "Febrile neutropenia (ANC <500/uL), agranulocytosis (clozapine, methimazole), chemotherapy, post-viral bone marrow suppression.",
            clinicalPearls = "Formula: ANC = WBC x (% segmented neutrophils + % band forms) / 100. Any temperature ≥38.0°C with ANC <500 requires IV antipseudomonal monotherapy within 60 minutes.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_platelets",
            name = "Platelet Count",
            panel = "Complete Blood Count (CBC)",
            standardRange = "150,000 - 450,000",
            conventionalUnits = "/uL",
            siUnits = "x 10^9/L",
            siRange = "150 - 450",
            highSignificance = "Essential thrombocythemia, reactive thrombocytosis (iron deficiency, infection, malignancy, post-splenectomy, chronic inflammation).",
            lowSignificance = "Thrombocytopenia: ITP, Dengue, sepsis/DIC, splenic sequestration, liver cirrhosis (hypersplenism), TTP, HIT, marrow hypoplasia.",
            clinicalPearls = "Rule out pseudothrombocytopenia (platelet clumping due to EDTA) by examining a peripheral blood smear or repeating collection in a sodium citrate (blue top) tube.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_mcv",
            name = "Mean Corpuscular Volume (MCV)",
            panel = "Complete Blood Count (CBC)",
            standardRange = "80 - 100",
            conventionalUnits = "fL",
            siUnits = "fL",
            siRange = "80 - 100",
            highSignificance = "Macrocytosis (MCV >100 fL): Vitamin B12 deficiency, Folate deficiency, Alcohol misuse, Hypothyroidism, Hydroxyurea, Myelodysplastic syndrome (MDS).",
            lowSignificance = "Microcytosis (MCV <80 fL): Iron deficiency anemia, Thalassemia trait, Anemia of chronic disease, Sideroblastic anemia, Lead poisoning.",
            clinicalPearls = "Mentzer Index = MCV / RBC count. If <13, strongly suggests Thalassemia Trait; if >13, strongly suggests Iron Deficiency Anemia.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_reticulocytes",
            name = "Reticulocyte Count & Index (RPI)",
            panel = "Complete Blood Count (CBC)",
            standardRange = "0.5 - 2.5% (Absolute: 25,000 - 100,000 /uL)",
            conventionalUnits = "%",
            siUnits = "x 10^9/L",
            siRange = "25 - 100",
            highSignificance = "Hyperproliferative marrow response: Acute hemolysis (sickle cell, AIHA, G6PD), acute blood loss recovery, response to iron or B12 replacement.",
            lowSignificance = "Hypoproliferative bone marrow failure: Aplastic anemia, untreated iron/B12 deficiency, chronic kidney disease (erythropoietin deficiency), myelosuppression.",
            clinicalPearls = "Always calculate Reticulocyte Production Index (RPI): Corrected Retic % / Maturation Correction Factor. RPI >2-3 indicates adequate bone marrow response to anemia.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        // ==========================================
        // 2. RENAL FUNCTION & ELECTROLYTES (RFT / BMP)
        // ==========================================
        StandardLabTest(
            id = "lab_creatinine",
            name = "Serum Creatinine",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "Male: 0.7 - 1.3 • Female: 0.5 - 1.1",
            conventionalUnits = "mg/dL",
            siUnits = "umol/L",
            siRange = "Male: 62 - 115 • Female: 44 - 97",
            highSignificance = "Acute Kidney Injury (KDIGO criteria: ≥0.3 mg/dL rise within 48h or ≥1.5x baseline), Chronic Kidney Disease, rhabdomyolysis, urinary obstruction.",
            lowSignificance = "Decreased muscle mass, severe malnutrition, advanced liver cirrhosis (due to impaired hepatic creatine synthesis and cachexia), pregnancy.",
            clinicalPearls = "Creatinine is a lagging indicator of renal dysfunction; GFR may drop by >50% before serum creatinine rises above the 'normal' reference range in frail elderly patients.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_bun",
            name = "Blood Urea Nitrogen (BUN / Serum Urea)",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "BUN: 7 - 20 mg/dL (Serum Urea: 15 - 45 mg/dL)",
            conventionalUnits = "mg/dL",
            siUnits = "mmol/L",
            siRange = "Urea: 2.5 - 7.5",
            highSignificance = "Renal failure, prerenal azotemia (dehydration, heart failure), upper gastrointestinal bleeding (digestion of blood proteins), high-protein diet, corticosteroids.",
            lowSignificance = "Severe liver failure/cirrhosis (impaired urea cycle), severe malnutrition, low-protein diet, syndrome of inappropriate ADH (SIADH).",
            clinicalPearls = "Conversion formula: Blood Urea Nitrogen (BUN) x 2.14 = Serum Urea (mg/dL). BUN/Creatinine ratio >20:1 strongly indicates prerenal azotemia or upper GI bleed.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_sodium",
            name = "Serum Sodium (Na+)",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "135 - 145",
            conventionalUnits = "mEq/L",
            siUnits = "mmol/L",
            siRange = "135 - 145",
            highSignificance = "Hypernatremia: Dehydration, diabetes insipidus (central/nephrogenic), osmotic diuresis (HHS), unreplaced perspiration losses in elderly/comatose.",
            lowSignificance = "Hyponatremia: SIADH, thiazide diuretics, congestive heart failure, liver cirrhosis, Addison's disease, psychogenic polydipsia.",
            clinicalPearls = "Always correct for hyperglycemia: Add 1.6 to 2.0 mEq/L to measured sodium for every 100 mg/dL rise in blood glucose above 100 mg/dL.",
            sampleTube = "Gold / Red / Green Top (Heparin or Serum)"
        ),

        StandardLabTest(
            id = "lab_potassium",
            name = "Serum Potassium (K+)",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "3.5 - 5.0",
            conventionalUnits = "mEq/L",
            siUnits = "mmol/L",
            siRange = "3.5 - 5.0",
            highSignificance = "Hyperkalemia: Acute/chronic renal failure, potassium-sparing diuretics, ACEIs/ARBs, rhabdomyolysis, acidosis, Addison's disease, tumor lysis.",
            lowSignificance = "Hypokalemia: GI losses (vomiting, diarrhea), loop/thiazide diuretics, hyperaldosteronism, refeeding syndrome, insulin therapy, alkalosis.",
            clinicalPearls = "Hypokalemia cannot be corrected until concomitant hypomagnesemia is identified and corrected (magnesium is mandatory for renal potassium conservation).",
            sampleTube = "Gold / Red / Green Top (Heparin or Serum)"
        ),

        StandardLabTest(
            id = "lab_calcium_total",
            name = "Serum Calcium (Total)",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "8.5 - 10.5",
            conventionalUnits = "mg/dL",
            siUnits = "mmol/L",
            siRange = "2.15 - 2.55",
            highSignificance = "Hypercalcemia: Malignancy (PTHrP / bone metastases), Primary Hyperparathyroidism, Vitamin D toxicity, Sarcoidosis, Milk-alkali, Thiazides.",
            lowSignificance = "Hypocalcemia: Hypoalbuminemia (pseudohypocalcemia), hypoparathyroidism, acute pancreatitis, severe Vitamin D deficiency, chronic kidney disease.",
            clinicalPearls = "Albumin-Corrected Calcium = Measured Total Ca + 0.8 x (4.0 - Albumin g/dL). Alternatively, measure direct ionized calcium on blood gas analyzer.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_magnesium",
            name = "Serum Magnesium (Mg2+)",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "1.7 - 2.2",
            conventionalUnits = "mg/dL",
            siUnits = "mmol/L",
            siRange = "0.70 - 1.05",
            highSignificance = "Hypermagnesemia: Renal failure with magnesium intake (laxatives/antacids), iatrogenic MgSO4 infusion in eclampsia/preeclampsia.",
            lowSignificance = "Hypomagnesemia: Chronic alcoholism, prolonged PPI therapy, diarrhea/malabsorption, loop/thiazide diuretics, aminoglycosides, refeeding.",
            clinicalPearls = "Hypomagnesemia causes refractory hypokalemia and secondary hypocalcemia (impairs parathyroid hormone release and creates peripheral PTH resistance).",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_phosphorus",
            name = "Serum Phosphate / Phosphorus (PO4)",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "2.5 - 4.5",
            conventionalUnits = "mg/dL",
            siUnits = "mmol/L",
            siRange = "0.81 - 1.45",
            highSignificance = "Hyperphosphatemia: Chronic kidney disease / ESRD, Tumor Lysis Syndrome, Rhabdomyolysis, Hypoparathyroidism, Acidosis.",
            lowSignificance = "Hypophosphatemia: Refeeding syndrome, DKA recovery, Primary Hyperparathyroidism, severe respiratory alkalosis, Vitamin D deficiency.",
            clinicalPearls = "Severe hypophosphatemia (<1.0 mg/dL) depletes 2,3-DPG and ATP, causing acute diaphragmatic muscle weakness and failure to wean from mechanical ventilation.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_uric_acid",
            name = "Serum Uric Acid",
            panel = "Renal & Electrolytes (RFT)",
            standardRange = "Male: 3.5 - 7.2 • Female: 2.6 - 6.0",
            conventionalUnits = "mg/dL",
            siUnits = "umol/L",
            siRange = "Male: 208 - 428 • Female: 155 - 357",
            highSignificance = "Hyperuricemia: Acute gout, Tumor Lysis Syndrome, chronic kidney disease, metabolic syndrome, thiazide/loop diuretics, pre-eclampsia.",
            lowSignificance = "Hypouricemia: Allopurinol/febuxostat therapy, SIADH, Fanconi syndrome, severe liver disease, low-purine diet.",
            clinicalPearls = "During an acute acute gout flare, serum uric acid can be normal or low in up to 30% of patients due to systemic stress-induced renal uricosuria; check synovial fluid crystals.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        // ==========================================
        // 3. LIVER FUNCTION TESTS (LFT)
        // ==========================================
        StandardLabTest(
            id = "lab_bilirubin_total",
            name = "Total Bilirubin",
            panel = "Liver Function Tests (LFT)",
            standardRange = "0.3 - 1.2",
            conventionalUnits = "mg/dL",
            siUnits = "umol/L",
            siRange = "5.1 - 20.5",
            highSignificance = "Jaundice (>2.5-3.0 mg/dL): Hemolysis, Gilbert syndrome, acute viral/toxic hepatitis, cirrhosis, biliary obstruction (gallstones, pancreatic cancer).",
            lowSignificance = "No clinical significance.",
            clinicalPearls = "Clinical icterus (yellow sclera) becomes visible when total bilirubin exceeds 2.5 to 3.0 mg/dL. Differentiate unconjugated vs conjugated via direct fraction.",
            sampleTube = "Gold / Red Top (Protect from direct light)"
        ),

        StandardLabTest(
            id = "lab_bilirubin_direct",
            name = "Direct (Conjugated) Bilirubin",
            panel = "Liver Function Tests (LFT)",
            standardRange = "0.0 - 0.3",
            conventionalUnits = "mg/dL",
            siUnits = "umol/L",
            siRange = "0.0 - 5.1",
            highSignificance = "Biliary tract obstruction (choledocholithiasis, cholangiocarcinoma, head of pancreas cancer), Dubin-Johnson and Rotor syndrome, intrahepatic cholestasis.",
            lowSignificance = "No clinical significance.",
            clinicalPearls = "If direct bilirubin is >50% of total bilirubin, the hyperbilirubinemia is predominantly conjugated (hepatobiliary parenchymal or obstructive cholestasis).",
            sampleTube = "Gold / Red Top (Protect from light)"
        ),

        StandardLabTest(
            id = "lab_alt",
            name = "Alanine Aminotransferase (ALT / SGPT)",
            panel = "Liver Function Tests (LFT)",
            standardRange = "Male: 10 - 40 • Female: 7 - 35",
            conventionalUnits = "U/L",
            siUnits = "U/L",
            siRange = "7 - 40",
            highSignificance = "Hepatocellular injury: Viral hepatitis (Hep A, B, C, E), ischemic hepatitis ('shock liver' >1000 U/L), paracetamol overdose, NAFLD/MASH, autoimmune hepatitis.",
            lowSignificance = "No clinical significance.",
            clinicalPearls = "ALT is more liver-specific than AST. In viral and fatty liver disease, ALT is typically higher than AST (AST/ALT ratio <1.0).",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_ast",
            name = "Aspartate Aminotransferase (AST / SGOT)",
            panel = "Liver Function Tests (LFT)",
            standardRange = "10 - 40",
            conventionalUnits = "U/L",
            siUnits = "U/L",
            siRange = "10 - 40",
            highSignificance = "Hepatocellular injury, alcoholic hepatitis (De Ritis ratio AST/ALT >2.0), rhabdomyolysis, acute myocardial infarction, severe hemolysis.",
            lowSignificance = "No clinical significance.",
            clinicalPearls = "AST is found in liver, heart, skeletal muscle, and red blood cells; AST/ALT ratio >2.0 strongly suggests alcoholic etiology or established cirrhosis.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_alp",
            name = "Alkaline Phosphatase (ALP)",
            panel = "Liver Function Tests (LFT)",
            standardRange = "44 - 147",
            conventionalUnits = "U/L",
            siUnits = "U/L",
            siRange = "44 - 147",
            highSignificance = "Cholestatic liver disease (biliary obstruction, primary biliary cholangitis), Bone disease (Paget's, osteomalacia, osteoblastic bone metastases), pregnancy (placental ALP).",
            lowSignificance = "Hypophosphatasia, severe zinc deficiency, malnutrition.",
            clinicalPearls = "To confirm liver vs bone origin of elevated ALP: Check Gamma-Glutamyl Transferase (GGT). If GGT is high, source is hepatobiliary; if GGT is normal, source is bone.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_ggt",
            name = "Gamma-Glutamyl Transferase (GGT)",
            panel = "Liver Function Tests (LFT)",
            standardRange = "Male: 10 - 70 • Female: 6 - 42",
            conventionalUnits = "U/L",
            siUnits = "U/L",
            siRange = "6 - 70",
            highSignificance = "Biliary tract disease / cholestasis, chronic heavy alcohol consumption (enzyme induction), enzyme-inducing drugs (phenytoin, carbamazepine), NAFLD.",
            lowSignificance = "No clinical significance.",
            clinicalPearls = "GGT is highly sensitive for hepatobiliary origin and does NOT rise in bone diseases or normal pregnancy, making it the definitive confirmatory test for isolated high ALP.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_albumin",
            name = "Serum Albumin",
            panel = "Liver Function Tests (LFT)",
            standardRange = "3.5 - 5.0",
            conventionalUnits = "g/dL",
            siUnits = "g/L",
            siRange = "35 - 50",
            highSignificance = "Dehydration (hemoconcentration).",
            lowSignificance = "Impaired hepatic synthesis (cirrhosis, liver failure), renal loss (nephrotic syndrome), protein-losing enteropathy, severe malnutrition/kwashiorkor, critical illness SIRS.",
            clinicalPearls = "Albumin has a long half-life (~20 days); normal albumin in acute liver failure indicates acute hyperacute insult rather than chronic underlying cirrhosis.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        // ==========================================
        // 4. CARDIAC & COAGULATION
        // ==========================================
        StandardLabTest(
            id = "lab_troponin_i",
            name = "High-Sensitivity Cardiac Troponin I (hs-cTnI)",
            panel = "Cardiac & Coagulation",
            standardRange = "< 26 ng/L (Male) • < 16 ng/L (Female)",
            conventionalUnits = "ng/L (pg/mL)",
            siUnits = "ug/L",
            siRange = "< 0.026",
            highSignificance = "Acute myocardial infarction (STEMI/NSTEMI), myocarditis, pulmonary embolism, Takotsubo cardiomyopathy, acute heart failure, sepsis demand ischemia, severe CKD.",
            lowSignificance = "Normal / rules out acute myocardial necrosis when serial testing shows no dynamic delta.",
            clinicalPearls = "Diagnosis of Type 1 Acute MI requires a dynamic delta rise or fall (>20% or >5 ng/L change on 0h and 1-3h algorithm) in the appropriate clinical/ECG context.",
            sampleTube = "Green Top (Heparin) or Gold Top (Serum)"
        ),

        StandardLabTest(
            id = "lab_bnp",
            name = "B-Type Natriuretic Peptide (BNP / NT-proBNP)",
            panel = "Cardiac & Coagulation",
            standardRange = "BNP < 100 pg/mL • NT-proBNP < 125 pg/mL (<75y) / < 450 (≥75y)",
            conventionalUnits = "pg/mL",
            siUnits = "pmol/L",
            siRange = "BNP < 29 • NT-proBNP < 15",
            highSignificance = "Congestive Heart Failure (ventricular wall stress/stretch), acute decompensated heart failure, pulmonary embolism (RV strain), renal failure, advanced age.",
            lowSignificance = "High negative predictive value (>98%): Safely rules out heart failure as the cause of acute dyspnea.",
            clinicalPearls = "Sacubitril/Valsartan (Entresto) inhibits neprilysin and elevates BNP; therefore, NT-proBNP MUST be used to monitor heart failure in patients taking ARNI therapy.",
            sampleTube = "Lavender Top (EDTA) or Green Top (Heparin)"
        ),

        StandardLabTest(
            id = "lab_d_dimer",
            name = "D-Dimer (Fibrin Degradation Product)",
            panel = "Cardiac & Coagulation",
            standardRange = "< 500 ug/L FEU (or Age x 10 ug/L if age >50)",
            conventionalUnits = "ug/L FEU",
            siUnits = "mg/L FEU",
            siRange = "< 0.50",
            highSignificance = "Venous Thromboembolism (DVT, Pulmonary Embolism), Disseminated Intravascular Coagulation (DIC), aortic dissection, sepsis, malignancy, pregnancy, surgery.",
            lowSignificance = "Extremely high negative predictive value (>99%): Safely rules out PE and DVT in patients with low or intermediate Wells clinical pretest probability.",
            clinicalPearls = "Never order D-dimer in high-probability patients (proceed directly to CT pulmonary angiography). Use Age-Adjusted Cutoff (Age x 10 ug/L for patients >50 years).",
            sampleTube = "Light Blue Top (3.2% Sodium Citrate)"
        ),

        StandardLabTest(
            id = "lab_pt_inr",
            name = "Prothrombin Time / INR",
            panel = "Cardiac & Coagulation",
            standardRange = "PT: 11 - 13.5 sec • INR: 0.8 - 1.2 (Therapeutic: 2.0 - 3.0)",
            conventionalUnits = "INR ratio",
            siUnits = "Ratio",
            siRange = "0.8 - 1.2",
            highSignificance = "Warfarin anticoagulation, Vitamin K deficiency, Acute Liver Failure / Cirrhosis, DIC, factor VII deficiency, dilution coagulopathy.",
            lowSignificance = "Hypercoagulable state (minimal clinical utility).",
            clinicalPearls = "Evaluates the Extrinsic and Common coagulation pathways (Factors II, VII, IX, X). Factor VII has the shortest half-life (~6 hours); PT/INR is the earliest marker of acute liver failure.",
            sampleTube = "Light Blue Top (Sodium Citrate - must be filled exactly to indicator line!)"
        ),

        StandardLabTest(
            id = "lab_aptt",
            name = "Activated Partial Thromboplastin Time (aPTT)",
            panel = "Cardiac & Coagulation",
            standardRange = "25 - 35",
            conventionalUnits = "seconds",
            siUnits = "seconds",
            siRange = "25 - 35",
            highSignificance = "Unfractionated Heparin therapy (target 1.5-2.5x control, 60-85s), Hemophilia A (Factor VIII) or B (Factor IX), von Willebrand disease, Lupus Anticoagulant, DIC.",
            lowSignificance = "Early acute phase reaction (elevated Factor VIII), hypercoagulability.",
            clinicalPearls = "Evaluates the Intrinsic and Common pathways (Factors XII, XI, IX, VIII, X, V, II, I). Paradoxically, Lupus Anticoagulant prolongs aPTT in vitro but causes thrombosis in vivo!",
            sampleTube = "Light Blue Top (Sodium Citrate)"
        ),

        StandardLabTest(
            id = "lab_fibrinogen",
            name = "Fibrinogen (Factor I)",
            panel = "Cardiac & Coagulation",
            standardRange = "200 - 400",
            conventionalUnits = "mg/dL",
            siUnits = "g/L",
            siRange = "2.0 - 4.0",
            highSignificance = "Acute phase reactant: Severe infection, trauma, inflammation, acute coronary syndrome, normal pregnancy (400-600 mg/dL).",
            lowSignificance = "Consumptive coagulopathy in DIC, severe Postpartum Hemorrhage (PPH <200 mg/dL), thrombolytic therapy, congenital afibrinogenemia.",
            clinicalPearls = "In severe obstetric hemorrhage, fibrinogen <200 mg/dL is an independent predictor of massive bleeding and indicates urgent Cryoprecipitate (10 units).",
            sampleTube = "Light Blue Top (Sodium Citrate)"
        ),

        // ==========================================
        // 5. DIABETES & ENDOCRINE / THYROID
        // ==========================================
        StandardLabTest(
            id = "lab_glucose_fasting",
            name = "Fasting Plasma Glucose (FPG)",
            panel = "Diabetes & Endocrine",
            standardRange = "Normal: 70 - 99 mg/dL (Prediabetes: 100 - 125 • Diabetes: ≥ 126)",
            conventionalUnits = "mg/dL",
            siUnits = "mmol/L",
            siRange = "Normal: 3.9 - 5.5 • Diabetes: ≥ 7.0",
            highSignificance = "Diabetes mellitus, impaired fasting glucose, Cushing's syndrome, acromegaly, acute pancreatitis, severe stress response, corticosteroids.",
            lowSignificance = "Hypoglycemia (<54-70 mg/dL): Excess insulin/sulfonylurea, insulinoma, Addison's disease, severe hepatic failure, sepsis, starvation.",
            clinicalPearls = "Diabetes diagnostic threshold: Fasting glucose ≥126 mg/dL (≥7.0 mmol/L) confirmed on two separate occasions in asymptomatic individuals.",
            sampleTube = "Grey Top (Sodium Fluoride / Potassium Oxalate prevents in vitro glycolysis)"
        ),

        StandardLabTest(
            id = "lab_hba1c",
            name = "Glycated Hemoglobin (HbA1c)",
            panel = "Diabetes & Endocrine",
            standardRange = "Normal: < 5.7% (Prediabetes: 5.7 - 6.4% • Diabetes: ≥ 6.5%)",
            conventionalUnits = "%",
            siUnits = "mmol/mol",
            siRange = "Normal: < 39 • Diabetes: ≥ 48",
            highSignificance = "Diabetes mellitus, poor glycemic control (increases risk of diabetic retinopathy, nephropathy, and neuropathy). Standard adult treatment goal is <7.0%.",
            lowSignificance = "Falsely low in conditions with accelerated red blood cell turnover: Hemolytic anemia, blood transfusion, chronic hemodialysis, pregnancy, hemoglobinopathies.",
            clinicalPearls = "Reflects weighted mean glycemic control over preceding 2-3 months (8-12 weeks). Every 1% drop in HbA1c reduces microvascular complications by ~25-35%.",
            sampleTube = "Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_tsh",
            name = "Thyroid Stimulating Hormone (TSH)",
            panel = "Diabetes & Endocrine",
            standardRange = "0.4 - 4.5",
            conventionalUnits = "uIU/mL (mIU/L)",
            siUnits = "mIU/L",
            siRange = "0.4 - 4.5",
            highSignificance = "Primary Hypothyroidism (Hashimoto's), subclinical hypothyroidism (TSH high, free T4 normal), TSH-secreting pituitary adenoma (rare).",
            lowSignificance = "Primary Hyperthyroidism (Graves' disease, toxic nodular goiter), subclinical hyperthyroidism, central (secondary) hypothyroidism, euthyroid sick syndrome.",
            clinicalPearls = "TSH is the most sensitive screening test for thyroid dysfunction. In pregnancy, reference ranges are lower: 1st trimester <2.5 mIU/L, 2nd/3rd trimester <3.0 mIU/L.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_free_t4",
            name = "Free Thyroxine (Free T4)",
            panel = "Diabetes & Endocrine",
            standardRange = "0.8 - 1.8",
            conventionalUnits = "ng/dL",
            siUnits = "pmol/L",
            siRange = "10.3 - 23.2",
            highSignificance = "Hyperthyroidism / Thyrotoxicosis (Thyroid Storm when accompanied by fever and tachyarrhythmias), excessive levothyroxine replacement.",
            lowSignificance = "Overt Hypothyroidism (Myxedema Coma if hypothermic and stuporous), central hypothyroidism (pituitary/hypothalamic disease).",
            clinicalPearls = "Free T4 measures biologically active unbound hormone and is unaffected by alterations in thyroid-binding globulin (TBG) caused by pregnancy or oral contraceptives.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        // ==========================================
        // 6. INFLAMMATORY & SEPSIS MARKERS
        // ==========================================
        StandardLabTest(
            id = "lab_crp",
            name = "C-Reactive Protein (CRP)",
            panel = "Inflammatory & Sepsis Markers",
            standardRange = "< 5.0 (High-Sensitivity hs-CRP for CVD risk: < 1.0 mg/L)",
            conventionalUnits = "mg/L",
            siUnits = "mg/L",
            siRange = "< 5.0",
            highSignificance = "Bacterial infections, sepsis, acute pancreatitis severity, autoimmune flares (rheumatoid arthritis, lupus), post-surgical inflammation, tissue infarction.",
            lowSignificance = "Normal / rules out significant systemic inflammatory processes.",
            clinicalPearls = "Synthesized in liver under IL-6 stimulation; levels rise within 6-8 hours and peak at 48 hours. Serial CRP decline reflects clinical response to antimicrobials.",
            sampleTube = "Gold / Red Top (Serum Separator SST)"
        ),

        StandardLabTest(
            id = "lab_procalcitonin",
            name = "Procalcitonin (PCT)",
            panel = "Inflammatory & Sepsis Markers",
            standardRange = "< 0.10 ug/L (Bacterial Sepsis likely: > 0.50 • Severe Septic Shock: > 2.0)",
            conventionalUnits = "ug/L (ng/mL)",
            siUnits = "ug/L",
            siRange = "< 0.10",
            highSignificance = "Systemic invasive bacterial infections, bacteremia, septic shock, bacterial pneumonia, bacterial meningitis.",
            lowSignificance = "Viral infections (interferon-gamma inhibits procalcitonin production), localized non-invasive bacterial infections, safe antibiotic de-escalation.",
            clinicalPearls = "Antibiotic Stewardship Protocol: In lower respiratory tract infections, PCT <0.25 ug/L strongly discourages antibiotics; de-escalate/stop when PCT drops by >80%.",
            sampleTube = "Gold / Red / Green Top (Serum or Heparin)"
        ),

        StandardLabTest(
            id = "lab_esr",
            name = "Erythrocyte Sedimentation Rate (ESR)",
            panel = "Inflammatory & Sepsis Markers",
            standardRange = "Male: 0 - 15 • Female: 0 - 20 (Age-adjusted: Age / 2 for men; [Age + 10] / 2 for women)",
            conventionalUnits = "mm/hr",
            siUnits = "mm/hr",
            siRange = "0 - 20",
            highSignificance = "Extreme elevation (>100 mm/hr): Temporal Arteritis / Giant Cell Arteritis, Polymyalgia Rheumatica, Multiple Myeloma, Osteomyelitis, severe tuberculosis.",
            lowSignificance = "Polycythemia vera, sickle cell anemia, severe hypofibrinogenemia, congestive heart failure (altered RBC rouleaux formation).",
            clinicalPearls = "In suspected Temporal Arteritis (new headache in patient >50y with jaw claudication), an ESR >50-100 mm/hr mandates IMMEDIATE high-dose steroids before biopsy!",
            sampleTube = "Black Top (Sodium Citrate) or Lavender Top (EDTA)"
        ),

        StandardLabTest(
            id = "lab_lactate_std",
            name = "Serum / Arterial Lactate",
            panel = "Inflammatory & Sepsis Markers",
            standardRange = "0.5 - 2.0",
            conventionalUnits = "mmol/L",
            siUnits = "mmol/L",
            siRange = "0.5 - 2.0",
            highSignificance = "Type A (Tissue hypoperfusion): Septic shock, hemorrhagic shock, cardiogenic shock, mesenteric ischemia. Type B (Metabolic): Liver failure, MALA, DKA, seizure, epinephrine.",
            lowSignificance = "Normal tissue perfusion and aerobic metabolism.",
            clinicalPearls = "In septic shock resuscitation, target >20% clearance of lactate every 2 hours over the initial 6 hours (lactate-guided resuscitation significantly reduces mortality).",
            sampleTube = "Grey Top (Sodium Fluoride on ice) or Heparinized Blood Gas Syringe"
        ),

        // ==========================================
        // 7. ARTERIAL BLOOD GAS (ABG)
        // ==========================================
        StandardLabTest(
            id = "lab_abg_pao2",
            name = "Arterial Oxygen Tension (PaO2)",
            panel = "Arterial Blood Gas (ABG)",
            standardRange = "80 - 100 (at sea level room air)",
            conventionalUnits = "mmHg",
            siUnits = "kPa",
            siRange = "10.6 - 13.3",
            highSignificance = "Hyperoxia from excessive supplemental FiO2 (generates reactive oxygen species; target normoxia 80-100 mmHg in post-cardiac arrest and stroke).",
            lowSignificance = "Hypoxemia (PaO2 <60 mmHg = SpO2 <90%): ARDS, pulmonary embolism, pneumonia, COPD exacerbation, alveolar hypoventilation, shunting.",
            clinicalPearls = "P/F Ratio = PaO2 / FiO2. Normal P/F is 400-500. A P/F ratio ≤300 defines ARDS under Berlin Criteria with PEEP ≥5 cmH2O.",
            sampleTube = "Heparinized Blood Gas Syringe (Aspirate anaerobically on ice)"
        ),

        StandardLabTest(
            id = "lab_abg_paco2",
            name = "Arterial Carbon Dioxide Tension (PaCO2)",
            panel = "Arterial Blood Gas (ABG)",
            standardRange = "35 - 45",
            conventionalUnits = "mmHg",
            siUnits = "kPa",
            siRange = "4.7 - 6.0",
            highSignificance = "Respiratory Acidosis / Hypercapnia: Alveolar hypoventilation, COPD exacerbation, opioid overdose, myasthenia gravis / Guillain-Barre, severe obesity hypoventilation.",
            lowSignificance = "Respiratory Alkalosis / Hypocapnia: Hyperventilation (panic attack, pulmonary embolism, asthma exacerbation early, salicylate toxicity early, sepsis, pregnancy).",
            clinicalPearls = "In acute severe asthma, a 'normalizing' or rising PaCO2 (>42 mmHg) is a sign of impending respiratory muscle exhaustion requiring immediate ICU and intubation preparation!",
            sampleTube = "Heparinized Blood Gas Syringe"
        ),

        StandardLabTest(
            id = "lab_abg_hco3",
            name = "Standard Bicarbonate (HCO3-)",
            panel = "Arterial Blood Gas (ABG)",
            standardRange = "22 - 26",
            conventionalUnits = "mEq/L",
            siUnits = "mmol/L",
            siRange = "22 - 26",
            highSignificance = "Metabolic Alkalosis (vomiting, nasogastric suction, diuretics, hyperaldosteronism) or chronic compensated respiratory acidosis (COPD retainer).",
            lowSignificance = "Metabolic Acidosis: High Anion Gap (DKA, lactic acidosis, renal failure, toxins) or Normal Anion Gap (diarrhea, renal tubular acidosis RTA).",
            clinicalPearls = "Winter's Formula for respiratory compensation in metabolic acidosis: Expected PaCO2 = (1.5 x HCO3) + 8 ± 2. If measured PaCO2 differs, mixed disorder is present.",
            sampleTube = "Heparinized Blood Gas Syringe"
        ),

        // ==========================================
        // 8. CEREBROSPINAL FLUID (CSF) & SEROLOGY
        // ==========================================
        StandardLabTest(
            id = "lab_csf_protein",
            name = "CSF Total Protein",
            panel = "CSF & Fluid Analysis",
            standardRange = "15 - 45 (Lumbar puncture)",
            conventionalUnits = "mg/dL",
            siUnits = "g/L",
            siRange = "0.15 - 0.45",
            highSignificance = "Bacterial meningitis (>100-500 mg/dL), Tuberculous meningitis (>100-500 mg/dL), Guillain-Barré Syndrome (albuminocytological dissociation), spinal block (Froin's syndrome).",
            lowSignificance = "CSF rhinorrhea/otorrhea (CSF leak), water intoxication, removal of large CSF volumes.",
            clinicalPearls = "Albuminocytological dissociation in Guillain-Barré syndrome: Markedly elevated CSF protein with normal white blood cell count (<10/uL).",
            sampleTube = "Sterile Conical CSF Tube #2 or #3"
        ),

        StandardLabTest(
            id = "lab_csf_glucose",
            name = "CSF Glucose & Ratio",
            panel = "CSF & Fluid Analysis",
            standardRange = "50 - 80 mg/dL (or > 60% of concurrent blood glucose)",
            conventionalUnits = "mg/dL",
            siUnits = "mmol/L",
            siRange = "2.8 - 4.4",
            highSignificance = "Hyperglycemia (CSF glucose equilibrates to ~60-70% of serum levels within 2-4 hours).",
            lowSignificance = "Hypoglycorrhachia (CSF/serum ratio <0.40): Acute bacterial meningitis, Tuberculous meningitis, Fungal/Cryptococcal meningitis, subarachnoid hemorrhage.",
            clinicalPearls = "In viral/aseptic meningitis, CSF glucose is characteristically normal (ratio >0.60). Always draw a simultaneous peripheral blood glucose with lumbar puncture.",
            sampleTube = "Sterile Conical CSF Tube"
        ),

        // ==========================================
        // 9. URINALYSIS & SPOT RATIOS
        // ==========================================
        StandardLabTest(
            id = "lab_urine_sp_gravity",
            name = "Urine Specific Gravity",
            panel = "Urinalysis",
            standardRange = "1.005 - 1.030",
            conventionalUnits = "g/mL",
            siUnits = "Ratio",
            siRange = "1.005 - 1.030",
            highSignificance = "Dehydration / volume depletion (>1.025), SIADH, glycosuria, proteinuria, radiographic IV contrast media.",
            lowSignificance = "Diabetes insipidus (<1.005, hyposthenuria), psychogenic polydipsia, acute tubular necrosis (isosthenuria fixed at 1.010), diuretic phase of AKI.",
            clinicalPearls = "Fixed urine specific gravity at 1.010 (isosthenuria) indicates loss of the kidney's ability to concentrate or dilute urine, classic for Acute Tubular Necrosis (ATN).",
            sampleTube = "Clean Catch Sterile Urine Container"
        ),

        StandardLabTest(
            id = "lab_uacr",
            name = "Urine Albumin-to-Creatinine Ratio (UACR)",
            panel = "Urinalysis",
            standardRange = "Normal: < 30 mg/g (Microalbuminuria: 30 - 300 • Macroalbuminuria: > 300)",
            conventionalUnits = "mg/g creatinine",
            siUnits = "mg/mmol",
            siRange = "Normal: < 3.0 • Micro: 3.0 - 30.0",
            highSignificance = "Diabetic kidney disease, hypertensive nephrosclerosis, glomerular diseases, cardiovascular risk factor.",
            lowSignificance = "Normal renal glomerular permeability.",
            clinicalPearls = "ADA Guideline: Screen all Type 2 diabetics annually with spot morning UACR; initiation of SGLT-2 inhibitors and ACEIs/ARBs preserves eGFR and slows progression.",
            sampleTube = "Early Morning Clean Catch Urine Container"
        ),

        // ==========================================
        // 10. THERAPEUTIC DRUG MONITORING (TDM)
        // ==========================================
        StandardLabTest(
            id = "lab_tdm_digoxin",
            name = "Serum Digoxin Trough Level",
            panel = "Therapeutic Drug Monitoring (TDM)",
            standardRange = "Heart Failure: 0.5 - 0.9 • Atrial Fibrillation: 0.8 - 1.5",
            conventionalUnits = "ng/mL",
            siUnits = "nmol/L",
            siRange = "0.6 - 1.9",
            highSignificance = "Toxicity (>2.0 ng/mL): Ventricular arrhythmias (bidirectional VT), heart block, nausea, vomiting, xanthopsia (yellow-green visual halos), hyperkalemia.",
            lowSignificance = "Subtherapeutic rate control in atrial fibrillation.",
            clinicalPearls = "Draw blood at least 6 to 8 hours post-dose (trough level) to allow complete tissue distribution; earlier levels are falsely elevated.",
            sampleTube = "Red / Gold Top (No gel separator interference)"
        ),

        StandardLabTest(
            id = "lab_tdm_lithium",
            name = "Serum Lithium Level (12-Hour Trough)",
            panel = "Therapeutic Drug Monitoring (TDM)",
            standardRange = "Acute Mania: 0.8 - 1.2 • Maintenance: 0.6 - 0.8",
            conventionalUnits = "mEq/L (mmol/L)",
            siUnits = "mmol/L",
            siRange = "0.6 - 1.2",
            highSignificance = "Toxicity (>1.5 mEq/L): Coarse tremor, ataxia, dysarthria, hyperreflexia, seizures, coma. >2.5 mEq/L requires urgent hemodialysis.",
            lowSignificance = "Subtherapeutic: Risk of manic or depressive relapse.",
            clinicalPearls = "Strictly draw blood 12 hours after the evening dose. Check BUN, creatinine, and thyroid function (TSH) every 6 months during chronic maintenance.",
            sampleTube = "Red Top (Plain Glass) or Gold Top - NEVER use Green Top (contains Lithium Heparin!)"
        ),

        StandardLabTest(
            id = "lab_tdm_phenytoin",
            name = "Total & Free Phenytoin (Dilantin)",
            panel = "Therapeutic Drug Monitoring (TDM)",
            standardRange = "Total: 10 - 20 mcg/mL (Free Unbound: 1 - 2 mcg/mL)",
            conventionalUnits = "mcg/mL (mg/L)",
            siUnits = "umol/L",
            siRange = "Total: 40 - 79",
            highSignificance = "Toxicity (>20 mcg/mL: Nystagmus; >30: Ataxia, slurred speech; >40: Lethargy, coma, paradoxical seizure aggravation).",
            lowSignificance = "Breakthrough seizures.",
            clinicalPearls = "Sheiner-Tozer equation for hypoalbuminemia or ESRD: Adjusted Phenytoin = Measured Total / [(0.2 x Albumin) + 0.1]. Phenytoin exhibits zero-order non-linear kinetics.",
            sampleTube = "Red / Gold Top (Serum)"
        ),

        StandardLabTest(
            id = "lab_tdm_valproate",
            name = "Serum Valproic Acid / Valproate",
            panel = "Therapeutic Drug Monitoring (TDM)",
            standardRange = "50 - 100",
            conventionalUnits = "mcg/mL (mg/L)",
            siUnits = "umol/L",
            siRange = "350 - 700",
            highSignificance = "Toxicity (>100-150 mcg/mL): CNS depression, tremor, thrombocytopenia, hyperammonemic encephalopathy without LFT rise, pancreatitis, hepatotoxicity.",
            lowSignificance = "Subtherapeutic seizure control or bipolar mood instability.",
            clinicalPearls = "Valproate can cause severe hyperammonemic encephalopathy with normal liver transaminases; check serum ammonia in any valproate patient presenting with acute confusion.",
            sampleTube = "Red / Gold Top (Serum)"
        )
    )
}
