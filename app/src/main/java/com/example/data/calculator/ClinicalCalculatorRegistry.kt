package com.example.data.calculator

import com.example.data.model.CalculatorSummary

object ClinicalCalculatorRegistry {

    val allCalculators: List<CalculatorSummary> = listOf(
        // --- Screenshot 1 (Favorites / GI / Critical Care) ---
        CalculatorSummary(
            id = "news_score",
            title = "NEWS Score",
            category = "Critical Care",
            description = "Severity screening of declining conditions.",
            formulaSummary = "National Early Warning Score based on 6 physiological parameters (RR, SpO2, Temp, SBP, HR, Consciousness).",
            aliases = listOf("NEWS", "NEWS2", "Early Warning", "Deterioration", "Vital Signs", "Critical Care"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "oakland",
            title = "Oakland Score",
            category = "Gastroenterology",
            description = "Lower GI bleed readmission risk.",
            formulaSummary = "Predicts probability of safe discharge without inpatient intervention in lower GI bleeding.",
            aliases = listOf("Oakland", "LGIB", "Lower GI Bleed", "Colorectal Bleed", "Safe Discharge"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "r_factor",
            title = "R Factor",
            category = "Hepatology",
            description = "Cholestatic vs. hepatocellular liver injury.",
            formulaSummary = "R = (ALT / ALT ULN) / (ALP / ALP ULN). R >= 5 Hepatocellular, 2-5 Mixed, <= 2 Cholestatic.",
            aliases = listOf("R Factor", "R Ratio", "Liver Injury", "DILI", "Drug Induced Liver Injury", "Cholestasis"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "ranson",
            title = "Ranson's Criteria",
            category = "Gastroenterology",
            description = "Mortality in pancreatitis.",
            formulaSummary = "11-factor criteria at admission and 48 hours predicting acute pancreatitis mortality.",
            aliases = listOf("Ranson", "Pancreatitis", "Acute Pancreatitis", "Mortality Score"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "psc_model",
            title = "Revised Natural History Model for PSC",
            category = "Hepatology",
            description = "Estimates survival in primary sclerosing cholangitis.",
            formulaSummary = "Calculates risk score based on age, bilirubin, albumin, AST, and history of variceal bleeding.",
            aliases = listOf("PSC", "Primary Sclerosing Cholangitis", "Mayo PSC Model", "Cholangitis Survival"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "aih_revised",
            title = "Revised Original AIH Score",
            category = "Hepatology",
            description = "Revised version of the original scoring system for autoimmune ...",
            formulaSummary = "Comprehensive scoring for autoimmune hepatitis incorporating ANA, SMA, IgG, viral markers, and histology.",
            aliases = listOf("AIH", "Autoimmune Hepatitis", "Revised AIH", "IAHG Score"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "rockall_complete",
            title = "Rockall Score (Complete)",
            category = "Gastroenterology",
            description = "Determines severity of GI bleeding.",
            formulaSummary = "Post-endoscopy assessment calculating mortality and rebleeding risk in acute upper GI hemorrhage.",
            aliases = listOf("Rockall", "Upper GI Bleed", "UGIB", "Endoscopy Score", "Hematemesis"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "rockall_pre",
            title = "Rockall Score (Pre-Endoscopy)",
            category = "Gastroenterology",
            description = "Determines severity of GI bleeding, prior to endoscopy.",
            formulaSummary = "Initial clinical triage using age, shock/BP, and comorbidities prior to endoscopic examination.",
            aliases = listOf("Pre-Rockall", "Clinical Rockall", "UGIB Triage", "Pre-Endoscopy Bleed"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "rome_iii",
            title = "Rome III for IBS",
            category = "Gastroenterology",
            description = "Diagnoses IBS.",
            formulaSummary = "Recurrent abdominal pain >= 3 days/month with stool frequency or form changes.",
            aliases = listOf("Rome", "Rome III", "Rome IV", "IBS", "Irritable Bowel Syndrome"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "simplified_aih",
            title = "Simplified AIH Score",
            category = "Hepatology",
            description = "AIH diagnosis.",
            formulaSummary = "Simplified 4-parameter scoring (Autoantibodies, IgG, Histology, Viral hepatitis exclusion) for autoimmune hepatitis.",
            aliases = listOf("Simplified AIH", "Autoimmune Hepatitis", "AIH Criteria", "Hepatitis Diagnostic"),
            isPopular = false,
            isNew = true
        ),

        // --- Screenshot 2 (GI, Anemia, Transplant, Hematology) ---
        CalculatorSummary(
            id = "galad",
            title = "GALAD Model for HCC",
            category = "Hepatology",
            description = "HCC diagnosis.",
            formulaSummary = "Statistical algorithm using Gender, Age, AFP-L3, AFP, and DCP to estimate hepatocellular carcinoma probability.",
            aliases = listOf("GALAD", "HCC", "Hepatocellular Carcinoma", "Liver Cancer", "AFP-L3", "DCP"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "ganzoni",
            title = "Ganzoni Equation for Anemia",
            category = "Hematology",
            description = "Iron deficit assessment.",
            formulaSummary = "Total Iron Deficit (mg) = [Weight (kg) × (Target Hb - Actual Hb) × 2.4] + Iron Stores Depot (500 mg).",
            aliases = listOf("Ganzoni", "Iron Deficit", "Anemia", "Iron Sucrose", "Ferric Carboxymaltose", "IV Iron Dosing"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "maddrey",
            title = "Maddrey's Discriminant Function",
            category = "Hepatology",
            description = "Alcoholic Hepatitis prognosis & steroid treatment.",
            formulaSummary = "DF = 4.6 × [PT (sec) - Control PT] + Serum Bilirubin (mg/dL). Score >= 32 indicates severe disease and steroid therapy.",
            aliases = listOf("Maddrey", "Discriminant Function", "MDF", "Alcoholic Hepatitis", "Prednisolone Indication"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "manning",
            title = "Manning Criteria",
            category = "Gastroenterology",
            description = "IBS diagnostic criteria.",
            formulaSummary = "6 clinical symptoms assessing probability of irritable bowel syndrome.",
            aliases = listOf("Manning", "IBS Criteria", "Irritable Bowel", "Abdominal Pain"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "mayo_dai",
            title = "Mayo DAI for Ulcerative Colitis",
            category = "Gastroenterology",
            description = "Assesses severity of ulcerative colitis.",
            formulaSummary = "Mayo Disease Activity Index evaluating stool frequency, rectal bleeding, mucosal findings, and physician global assessment.",
            aliases = listOf("Mayo", "Mayo Score", "DAI", "Ulcerative Colitis", "UC Severity", "IBD"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "meld_na",
            title = "MELD Na (UNOS/OPTN)",
            category = "Hepatology",
            description = "Liver transplant planning + Na.",
            formulaSummary = "MELD-Na incorporates Bilirubin, INR, Creatinine, and Serum Sodium for liver transplant organ allocation.",
            aliases = listOf("MELD Na", "UNOS MELD", "OPTN", "Liver Allocation", "Liver Transplant Priority"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "meld_score",
            title = "MELD-Na Score",
            category = "Hepatology",
            description = "MELD + Na: More accurate than MELD.",
            formulaSummary = "Predicts 90-day survival in end-stage liver disease including serum sodium correction.",
            aliases = listOf("MELD-Na", "MELD Score", "Cirrhosis Mortality", "End Stage Liver Disease"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "mentzer",
            title = "Mentzer Index",
            category = "Hematology",
            description = "Beta thalassemia vs. iron deficiency anemia.",
            formulaSummary = "Mentzer Index = MCV (fL) / RBC (million/µL). < 13 suggests Thalassemia Trait; > 13 suggests Iron Deficiency.",
            aliases = listOf("Mentzer", "Thalassemia Trait", "Iron Deficiency", "Microcytic Anemia", "MCV/RBC"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "milan",
            title = "Milan Criteria",
            category = "Hepatology",
            description = "Assess suitability of patients for liver transplant.",
            formulaSummary = "Single tumor <= 5 cm or up to 3 tumors each <= 3 cm, without vascular invasion or metastasis.",
            aliases = listOf("Milan", "HCC Transplant", "Liver Transplant Criteria", "Oncology Triage"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "montreal_ibd",
            title = "Montreal Classification for IBD",
            category = "Gastroenterology",
            description = "Crohn's and ulcerative colitis severity.",
            formulaSummary = "Phenotypic classification of IBD based on age at diagnosis, disease location, and disease behavior.",
            aliases = listOf("Montreal", "IBD Classification", "Crohn's Disease", "Ulcerative Colitis Extent"),
            isPopular = false,
            isNew = true
        ),

        // --- Screenshot 3 (Liver, Nephrology, Electrolytes, Cardiology) ---
        CalculatorSummary(
            id = "apri",
            title = "APRI",
            category = "Hepatology",
            description = "Predicts hepatitis C-related hepatic fibrosis and cirrhosis.",
            formulaSummary = "APRI = [(AST / AST ULN) × 100] / Platelet Count (10^9/L). Cutoff > 1.0 indicates high cirrhosis risk.",
            aliases = listOf("APRI", "AST to Platelet", "Liver Fibrosis", "Cirrhosis Index", "Hepatitis C"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "bclc",
            title = "BCLC Staging Classification",
            category = "Hepatology",
            description = "Determines progression and treatment course in HCC.",
            formulaSummary = "Barcelona Clinic Liver Cancer staging: Stage 0 (Very early) to Stage D (End-stage), guiding resection, TACE, or sorafenib.",
            aliases = listOf("BCLC", "Liver Cancer Staging", "HCC Management", "Barcelona Staging"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "bisap",
            title = "BISAP Score for Pancreatitis",
            category = "Gastroenterology",
            description = "Mortality in pancreatitis.",
            formulaSummary = "BUN > 25, Impaired mental status, SIRS, Age > 60, Pleural effusion within 24 hours of onset.",
            aliases = listOf("BISAP", "Acute Pancreatitis", "Pancreatitis Severity", "ICU Triage"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "bristol_stool",
            title = "Bristol Stool Scale",
            category = "Gastroenterology",
            description = "Stool classification.",
            formulaSummary = "Types 1-7 visual chart categorizing bowel transit time from severe constipation to diarrhea.",
            aliases = listOf("Bristol", "Stool Scale", "Constipation", "Diarrhea", "Bowel Movement"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "ca_correction",
            title = "Ca Correction for Albumin",
            category = "Endocrinology",
            description = "Corrects Ca for hypoalbuminemia or hyperalbuminemia.",
            formulaSummary = "Corrected Calcium (mg/dL) = Measured Total Ca + 0.8 × [4.0 - Serum Albumin (g/dL)].",
            aliases = listOf("Corrected Calcium", "Payne Formula", "Hypocalcemia", "Albumin Correction", "Electrolytes"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "cha2ds2",
            title = "CHA₂DS₂-VA Score",
            category = "Cardiology",
            description = "Stroke risk in atrial fibrillation patients.",
            formulaSummary = "Congestive HF, Hypertension, Age >= 75 (2), Diabetes, Stroke/TIA (2), Vascular disease, Age 65-74.",
            aliases = listOf("CHA2DS2", "CHADS-VASc", "AFib", "Atrial Fibrillation", "Stroke Risk", "Anticoagulation", "DOAC"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "child_pugh",
            title = "Child-Turcotte-Pugh (CTP) Score",
            category = "Hepatology",
            description = "Prognosis in cirrhosis; evaluates encephalopathy, ascites, bilirubin, albumin, and INR.",
            formulaSummary = "Class A (5-6 points), Class B (7-9 points), Class C (10-15 points) assessing 1-2 year mortality & drug titration.",
            aliases = listOf("Child-Turcotte-Pugh", "Child-Pugh", "Child Turcotte Pugh", "CTP", "CTP Score", "Cirrhosis Score", "Hepatic Impairment", "Ascites", "Encephalopathy", "CTP Class A/B/C"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "ckd_epi",
            title = "CKD-EPI Equations for GFR",
            category = "Nephrology & Dosing",
            description = "Estimates GFR.",
            formulaSummary = "2021 race-free CKD-EPI creatinine equation recommended by KDIGO for accurate staging of chronic kidney disease.",
            aliases = listOf("CKD-EPI", "eGFR", "Kidney Function", "Creatinine GFR", "Renal Staging"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "clif_c_aclf",
            title = "CLIF-C ACLF",
            category = "Hepatology",
            description = "Mortality in liver failure.",
            formulaSummary = "Chronic Liver Failure-Consortium score predicting 28-day and 90-day mortality in acute-on-chronic liver failure.",
            aliases = listOf("CLIF-C", "ACLF", "Acute-on-Chronic Liver Failure", "Liver Failure ICU"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "fib4",
            title = "FIB-4 Index",
            category = "Hepatology",
            description = "Noninvasive estimate of liver fibrosis.",
            formulaSummary = "FIB-4 = (Age × AST) / [Platelets × √(ALT)]. Score < 1.3 excludes advanced fibrosis; > 3.25 indicates high risk.",
            aliases = listOf("FIB-4", "Fibrosis-4", "NAFLD", "MASLD", "Liver Stiffness", "NASH"),
            isPopular = true,
            isNew = true
        ),

        // --- Screenshot 4 (Critical Care, Resuscitation, Sepsis, Trauma) ---
        CalculatorSummary(
            id = "free_water_deficit",
            title = "Free Water Deficit in Hypernatremia",
            category = "Nephrology & Dosing",
            description = "Free water deficit in hypernatremia or dehydration.",
            formulaSummary = "Deficit (L) = Total Body Water × [(Serum Na / 140) - 1]. Prevents cerebral edema from rapid correction.",
            aliases = listOf("Water Deficit", "Hypernatremia", "Dehydration", "Free Water", "Electrolyte Correction"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "ascvd_risk",
            title = "ASCVD Risk Algorithm",
            category = "Cardiology",
            description = "10-year heart disease or stroke risk and statin recommendations.",
            formulaSummary = "Pooled Cohort Equations estimating 10-year risk of first atherosclerotic cardiovascular disease event.",
            aliases = listOf("ASCVD", "PCE", "10-Year CVD Risk", "Statin Benefit", "Cardiovascular Prevention"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "sirs_sepsis",
            title = "SIRS & Sepsis Criteria",
            category = "Critical Care",
            description = "Defines severity of sepsis and septic shock.",
            formulaSummary = "Evaluates Temp (<36 or >38°C), HR (>90), RR (>20), and WBC (<4k or >12k) with qSOFA bed screening.",
            aliases = listOf("SIRS", "Sepsis", "qSOFA", "Septic Shock", "Severe Sepsis", "Infection Alert"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "ariscat",
            title = "ARISCAT Score",
            category = "Pulmonology",
            description = "Post-op pulmonary complications.",
            formulaSummary = "Preoperative risk score for postoperative pulmonary complications (PPC) across 7 clinical factors.",
            aliases = listOf("ARISCAT", "Canet", "Postop Pulmonary", "Surgery Risk", "PPC"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "fena",
            title = "FENa",
            category = "Nephrology & Dosing",
            description = "Prerenal or intrinsic kidney failure.",
            formulaSummary = "FENa (%) = [(Urine Na × Serum Cr) / (Serum Na × Urine Cr)] × 100. < 1% Prerenal azotemia; > 2% ATN.",
            aliases = listOf("FENa", "Fractional Excretion of Sodium", "Acute Kidney Injury", "AKI", "Prerenal vs ATN"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "sofa_score",
            title = "SOFA Score",
            category = "Critical Care",
            description = "ICU mortality from lab data.",
            formulaSummary = "Sequential Organ Failure Assessment tracking respiratory (PaO2/FiO2), coagulation, liver, CVS, CNS, and renal systems.",
            aliases = listOf("SOFA", "Organ Failure", "ICU Mortality", "Sepsis-3", "Critical Care Score"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "curb65",
            title = "CURB-65 Score for Pneumonia",
            category = "Pulmonology",
            description = "Mortality in CAP: inpatient vs outpatient disposition.",
            formulaSummary = "Confusion, Urea > 19 mg/dL, RR >= 30, SBP < 90 or DBP <= 60, Age >= 65 predicting pneumonia mortality.",
            aliases = listOf("CURB-65", "CURB65", "CURB 65", "Pneumonia", "CAP", "Pneumonia Admission", "Pneumonia Mortality", "Community Acquired Pneumonia"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "prevent_risk",
            title = "PREVENT",
            category = "Cardiology",
            description = "CVD risk.",
            formulaSummary = "AHA 2023 Predicting Risk of cardiovascular disease EVENTs for 10-year and 30-year total cardiovascular risk.",
            aliases = listOf("PREVENT", "AHA PREVENT", "Cardiovascular Event", "New CVD Risk", "30-Year CVD"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "pecarn_head",
            title = "PECARN Pediatric Head Injury Rule",
            category = "Pediatrics",
            description = "Clears peds head injury without imaging.",
            formulaSummary = "Identifies children at very low risk of clinically important traumatic brain injuries (ciTBI) to safely avoid head CT.",
            aliases = listOf("PECARN", "Pediatric Head Injury", "Head Trauma", "Pediatric CT Rule", "Minor Head Injury"),
            isPopular = true,
            isNew = true
        ),

        // --- Screenshot 5 (Sleep, Psychiatry, Emergency, Fluids, Dosing) ---
        CalculatorSummary(
            id = "stop_bang",
            title = "STOP-BANG",
            category = "Pulmonology",
            description = "Obstructive sleep apnea diagnosis.",
            formulaSummary = "Snoring, Tired, Observed apnea, High BP, BMI > 35, Age > 50, Neck circumference > 40cm, Male gender.",
            aliases = listOf("STOP-BANG", "OSA", "Sleep Apnea", "Snoring Score", "Preop Sleep Risk"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "phq9",
            title = "PHQ-9",
            category = "Psychiatry",
            description = "Degree of depression severity.",
            formulaSummary = "9-question screening and severity tool for major depressive disorder (DSM-5 criteria).",
            aliases = listOf("PHQ-9", "PHQ9", "Depression Screening", "Mental Health", "Depression Severity"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "heart_score",
            title = "HEART Score",
            category = "Cardiology",
            description = "6-week risk of cardiac event.",
            formulaSummary = "History, ECG, Age, Risk factors, and Troponin for chest pain risk stratification in emergency departments.",
            aliases = listOf("HEART Score", "Chest Pain", "MACE", "Acute Coronary Syndrome", "ED Chest Pain"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "wells_dvt",
            title = "Wells' Score for DVT",
            category = "Cardiology",
            description = "Risk of DVT based on clinical criteria.",
            formulaSummary = "Clinical pre-test probability score for Deep Vein Thrombosis directing D-dimer vs venous ultrasound.",
            aliases = listOf("Wells DVT", "Deep Vein Thrombosis", "DVT Risk", "Leg Swelling", "Venous Thromboembolism"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "maintenance_fluids",
            title = "Maintenance Fluids",
            category = "Pediatrics",
            description = "Fluid maintenance.",
            formulaSummary = "Holliday-Segar 4-2-1 Rule: 4 mL/kg/hr for first 10kg + 2 mL/kg/hr for next 10kg + 1 mL/kg/hr thereafter.",
            aliases = listOf("Maintenance Fluids", "Holliday-Segar", "4-2-1 Rule", "IV Fluids", "Daily Fluid Requirement"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "sodium_correction",
            title = "Sodium Correction for Hyperglycemia",
            category = "Endocrinology",
            description = "Calculates Na in hyperglycemia.",
            formulaSummary = "Corrected Na = Measured Na + 0.016 × [Serum Glucose (mg/dL) - 100] (Katz equation).",
            aliases = listOf("Corrected Sodium", "Hyperglycemia Na", "DKA Sodium", "Pseudohyponatremia", "Katz Formula"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "steroid_conversion",
            title = "Steroid Conversion",
            category = "Endocrinology",
            description = "Steroid dosing equivalencies.",
            formulaSummary = "Equivalent glucocorticoid and mineralocorticoid potencies: Hydrocortisone 20mg = Prednisolone 5mg = Dexamethasone 0.75mg.",
            aliases = listOf("Steroid Conversion", "Corticosteroid Equivalent", "Dexamethasone to Prednisolone", "Hydrocortisone"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "centor_score",
            title = "Centor Score (Modified/McIsaac)",
            category = "Infectious Disease",
            description = "Strep throat diagnosis and treatment.",
            formulaSummary = "Fever history, absence of cough, tender anterior cervical lymphadenopathy, tonsillar exudate, age modifier.",
            aliases = listOf("Centor", "McIsaac", "Strep Throat", "Pharyngitis", "Group A Strep", "Amoxicillin Throat"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "has_bled",
            title = "HAS-BLED Score",
            category = "Cardiology",
            description = "Bleeding risk with AFib anticoagulation.",
            formulaSummary = "Hypertension, Abnormal renal/liver function, Stroke, Bleeding history, Labile INR, Elderly (>65), Drugs/alcohol.",
            aliases = listOf("HAS-BLED", "HASBLED", "Bleeding Risk", "Anticoagulant Bleed", "Warfarin Safety"),
            isPopular = true,
            isNew = false
        ),

        // --- Screenshot 6 (Cardiology, Renal, Vitals, Pulmonary) ---
        CalculatorSummary(
            id = "egfr",
            title = "Creatinine Clearance",
            category = "Nephrology & Dosing",
            description = "Estimates creatinine clearance (kidney function).",
            formulaSummary = "Cockcroft-Gault: CrCl = [(140 - Age) × Weight (kg) × (0.85 if female)] / [72 × Serum Cr (mg/dL)].",
            aliases = listOf("Creatinine Clearance", "CrCl", "Cockcroft-Gault", "eGFR", "Renal Dose"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "abg_solver",
            title = "ABG & Electrolyte Disturbance Solver",
            category = "Critical Care",
            description = "Stepwise Acid-Base, Anion Gap, Na/K deficits & 3% Saline.",
            formulaSummary = "Winter's formula: PaCO2 = (1.5 × HCO3) + 8 ± 2. Corrected AG = AG + 2.5(4 - Alb). Delta-Delta ratio, Na deficit & TBW, Adrogué-Madias 3% saline dosing.",
            aliases = listOf("ABG", "Arterial Blood Gas", "Acid-Base", "Anion Gap", "Winter's Formula", "Delta Gap", "Hyponatremia", "Sodium Deficit", "3% Saline", "Hyperkalemia Cocktail", "Electrolytes", "HAGMA", "NAGMA"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "map_calc",
            title = "Mean Arterial Pressure (MAP)",
            category = "Critical Care",
            description = "Calculates MAP.",
            formulaSummary = "MAP = DBP + 1/3 (SBP - DBP) or (SBP + 2 × DBP) / 3. Clinical target >= 65 mmHg in shock.",
            aliases = listOf("MAP", "Mean Arterial Pressure", "Perfusion Pressure", "Shock Vitals", "Blood Pressure"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "bsa",
            title = "BMI & BSA",
            category = "General & Dosing",
            description = "Categorizes obesity, assists some med dosing.",
            formulaSummary = "BMI = Weight (kg) / [Height (m)]². BSA = √[Height (cm) × Weight (kg) / 3600] (Mosteller formula).",
            aliases = listOf("BMI", "BSA", "Body Surface Area", "Body Mass Index", "Chemotherapy Dose", "Obesity Staging"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "ascvd_2013",
            title = "2013 ASCVD Risk Calculator",
            category = "Cardiology",
            description = "10-year heart disease or stroke risk.",
            formulaSummary = "ACC/AHA pooled risk algorithm calculating 10-year primary prevention cardiovascular risk.",
            aliases = listOf("2013 ASCVD", "ACC AHA Risk", "Statin Calculator", "Lipid Guidelines"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "qtc_calc",
            title = "Corrected QT (QTc)",
            category = "Cardiology",
            description = "Corrects QT interval.",
            formulaSummary = "Bazett (QT / √RR) & Fridericia (QT / ∛RR) formulas evaluating drug-induced ventricular arrhythmia risk.",
            aliases = listOf("QTc", "Corrected QT", "Bazett", "Fridericia", "Torsades", "Long QT", "ECG"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "wells_pe",
            title = "Wells' Score for PE",
            category = "Pulmonology",
            description = "Risk of PE.",
            formulaSummary = "Clinical criteria estimating pre-test probability of Pulmonary Embolism directing CTPA vs D-dimer.",
            aliases = listOf("Wells PE", "Pulmonary Embolism", "PE Risk", "CTPA Triage", "Chest Pain Dyspnea"),
            isPopular = true,
            isNew = false
        ),

        // --- Core Toxicology, Trauma, Pediatrics & Nepal Emergency Suite ---
        CalculatorSummary(
            id = "gcs",
            title = "Glasgow Coma Scale (GCS)",
            category = "Neurology",
            description = "Objective neurological consciousness scoring.",
            formulaSummary = "Eye Response (1-4) + Verbal (1-5) + Motor (1-6). Score <= 8 indicates severe brain injury / coma.",
            aliases = listOf("GCS", "Glasgow Coma Scale", "Coma", "Head Injury", "Intubation Criterion"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "rumack",
            title = "Paracetamol Nomogram",
            category = "Toxicology",
            description = "Rumack-Matthew Nomogram for APAP overdose.",
            formulaSummary = "Evaluates single acute acetaminophen overdose level vs hours post-ingestion for N-Acetylcysteine therapy.",
            aliases = listOf("Rumack-Matthew", "Paracetamol Toxicity", "NAC Nomogram", "Acetaminophen Overdose", "Tylenol"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "pediatric",
            title = "Pediatric Liquid Dose",
            category = "Pediatrics",
            description = "Volume (mL) calculation from mg/kg.",
            formulaSummary = "Dose Volume (mL) = [Weight (kg) × Dose (mg/kg)] / Suspension Concentration (mg/mL).",
            aliases = listOf("Pediatric Dose", "Syrup Volume", "Liquid Suspension", "mg/kg to mL", "Child Dosing"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "iv_infusion",
            title = "IV Infusion & Drop Rate",
            category = "Critical Care",
            description = "Drop rate (gtt/min) and pump rate (mL/hr).",
            formulaSummary = "Calculates pump speed and macro/micro drop rates for Noradrenaline, Dopamine, and inotropes.",
            aliases = listOf("IV Infusion", "Drop Rate", "gtt/min", "Pump Rate", "Noradrenaline Infusion", "Dopamine"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "snakebite",
            title = "Nepal Snakebite & ASV",
            category = "Emergency & Nepal",
            description = "National EDCD Nepal Snakebite Protocol.",
            formulaSummary = "20WBCT assessment, initial 10 vials polyvalent ASV in 500 mL NS over 1h, and Neostigmine test protocol.",
            aliases = listOf("Snakebite", "ASV", "Anti-Snake Venom", "Nepal Snakebite", "20WBCT", "Krait", "Viper", "Cobra"),
            isPopular = true,
            isNew = false
        ),
        CalculatorSummary(
            id = "rabies_pep",
            title = "Rabies PEP & Immunoglobulin",
            category = "Emergency & Nepal",
            description = "WHO / EDCD Nepal Rabies Prophylaxis.",
            formulaSummary = "Category I-III wound grading, Thai Red Cross 2-site intradermal vaccine schedule, and ERIG (40 IU/kg) infiltration.",
            aliases = listOf("Rabies", "Rabies PEP", "Dog Bite", "Wound Category", "ERIG", "Immunoglobulin", "Nepal Rabies"),
            isPopular = true,
            isNew = false
        ),
        // --- Medical Scoring Engine: Alcohol-Associated Hepatitis ---
        CalculatorSummary(
            id = "lille_model",
            title = "Lille Model (Day 7 Steroid Response)",
            category = "Hepatology",
            description = "Corticosteroid response at Day 7 in severe alcoholic hepatitis.",
            formulaSummary = "Evaluates baseline & Day 7 Bilirubin, Albumin, Creatinine, PT/INR. Score > 0.45 = non-responder (discontinue steroids).",
            aliases = listOf("Lille", "Lille Score", "Alcoholic Hepatitis", "Steroid Response", "Day 7 Lille", "Hepatology"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "abic_score",
            title = "ABIC Score for Alcoholic Hepatitis",
            category = "Hepatology",
            description = "Stratifies 90-day mortality risk in alcoholic hepatitis.",
            formulaSummary = "ABIC = (Age × 0.1) + (Bilirubin × 0.08) + (INR × 0.3) + (Creatinine × 0.3). Low (<6.71), Int (6.71-8.99), High (>8.99).",
            aliases = listOf("ABIC", "Alcoholic Hepatitis", "ABIC Score", "Liver Mortality"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "gahs_score",
            title = "Glasgow Alcoholic Hepatitis Score (GAHS)",
            category = "Hepatology",
            description = "Identifies alcoholic hepatitis patients benefiting from steroids.",
            formulaSummary = "Evaluates Age, WBC, Urea, PT ratio/INR, and Bilirubin. Score >= 9 indicates high 28-day mortality and steroid benefit.",
            aliases = listOf("GAHS", "Glasgow Alcoholic Hepatitis", "Alcoholic Hepatitis Score"),
            isPopular = false,
            isNew = true
        ),

        // --- Medical Scoring Engine: Autoimmune & Metabolic Liver Disease ---
        CalculatorSummary(
            id = "leipzig_score",
            title = "Leipzig Score for Wilson Disease",
            category = "Hepatology",
            description = "Diagnostic criteria for Wilson Disease.",
            formulaSummary = "KF rings (2), Neuro symptoms (1-2), Hemolysis (1), Ceruloplasmin, 24h Urine Cu, Liver Cu, ATP7B mutations. >=4 confirmed.",
            aliases = listOf("Leipzig", "Wilson Disease", "Wilson", "Copper", "KF Rings", "Ceruloplasmin", "ATP7B"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "dhawan_score",
            title = "Dhawan Score (Revised King's Wilson)",
            category = "Hepatology",
            description = "Emergency liver transplant prognostic score in Wilson disease.",
            formulaSummary = "Bilirubin, AST, WBC, INR, Albumin. Score > 11 predicts extremely high mortality without urgent liver transplantation.",
            aliases = listOf("Dhawan", "Revised Kings Wilson", "Wilson Transplant", "Fulminant Wilson"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "hemochromatosis_eval",
            title = "Hemochromatosis Evaluation",
            category = "Hepatology",
            description = "Transferrin saturation, ferritin, and HFE genotyping criteria.",
            formulaSummary = "TSAT > 45-50%, Serum Ferritin, HFE C282Y / H63D mutations, Hepatic Iron Index (HII >= 1.9) for phlebotomy initiation.",
            aliases = listOf("Hemochromatosis", "Iron Overload", "Transferrin Saturation", "Ferritin", "HFE", "Phlebotomy"),
            isPopular = false,
            isNew = true
        ),

        // --- Medical Scoring Engine: Inflammatory Bowel Disease ---
        CalculatorSummary(
            id = "hbi_crohn",
            title = "Harvey-Bradshaw Index (HBI) for Crohn's",
            category = "Gastroenterology",
            description = "Bedside clinical assessment of Crohn's disease activity.",
            formulaSummary = "Wellbeing (0-4) + Pain (0-3) + Liquid stools/day + Abdominal mass (0-3) + Complications count. <5 remission, >16 severe.",
            aliases = listOf("HBI", "Harvey-Bradshaw", "Crohn's Disease", "IBD Activity", "Crohn Score"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "partial_mayo",
            title = "Partial Mayo Score for Ulcerative Colitis",
            category = "Gastroenterology",
            description = "Non-invasive bedside monitoring of Ulcerative Colitis activity.",
            formulaSummary = "Stool frequency (0-3) + Rectal bleeding (0-3) + Physician's global assessment (0-3). <=1 remission, 8-9 severe flare.",
            aliases = listOf("Partial Mayo", "Mayo Score", "Ulcerative Colitis", "UC Activity", "IBD Flare"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "truelove_witts",
            title = "Truelove and Witts Criteria (UC)",
            category = "Gastroenterology",
            description = "Severity grading of acute severe ulcerative colitis flares.",
            formulaSummary = "Stools/day (>=6), bloody stools, temperature >37.5°C, HR >90, Hb <10.5 g/dL, ESR >30 mm/h. Severe = admission for IV steroids.",
            aliases = listOf("Truelove", "Truelove Witts", "Severe UC", "Colitis Flare", "IV Steroids UC"),
            isPopular = false,
            isNew = true
        ),

        // --- Medical Scoring Engine: MASLD / MASH ---
        CalculatorSummary(
            id = "nfs_mash",
            title = "NAFLD Fibrosis Score (NFS)",
            category = "Hepatology",
            description = "Non-invasive score for advanced fibrosis in MASLD/MASH.",
            formulaSummary = "Age, BMI, Diabetes, AST/ALT, Platelets, Albumin. Score < -1.455 excludes F3-F4 (NPV 93%); > 0.675 rules in F3-F4.",
            aliases = listOf("NFS", "NAFLD Fibrosis Score", "MASH", "MASLD", "Fatty Liver Fibrosis"),
            isPopular = true,
            isNew = true
        ),

        // --- Medical Scoring Engine: ACLF & ALF ---
        CalculatorSummary(
            id = "nacseld_aclf",
            title = "NACSELD-ACLF Score",
            category = "Hepatology",
            description = "Consensus criteria for Acute-on-Chronic Liver Failure.",
            formulaSummary = "Defined by >= 2 organ failures among: Shock (vasopressors), HE grade 3/4, Dialysis/RRT, Mechanical ventilation.",
            aliases = listOf("NACSELD", "ACLF", "Acute on Chronic Liver Failure", "Cirrhosis Organ Failure"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "kings_college_alf",
            title = "King's College Criteria for ALF",
            category = "Hepatology",
            description = "Prognostic criteria for urgent liver transplant in Acute Liver Failure.",
            formulaSummary = "Paracetamol (Arterial pH <7.30 or INR>6.5 + Cr>3.4 + HE III/IV) vs Non-Paracetamol (INR>6.5 or 3 of 5 minor criteria).",
            aliases = listOf("Kings College", "ALF", "Acute Liver Failure", "Liver Transplant Criteria", "Fulminant Hepatic Failure"),
            isPopular = true,
            isNew = true
        ),

        // --- Medical Scoring Engine: Pancreatitis & Cholangitis ---
        CalculatorSummary(
            id = "modified_atlanta",
            title = "Modified Atlanta Classification (Pancreatitis)",
            category = "Gastroenterology",
            description = "International consensus severity staging for acute pancreatitis.",
            formulaSummary = "Mild (no organ failure), Moderately Severe (transient organ failure <48h or local complications), Severe (persistent organ failure >48h).",
            aliases = listOf("Atlanta", "Modified Atlanta", "Pancreatitis Staging", "Severe Pancreatitis"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "tokyo_tg18",
            title = "Tokyo Guidelines 2018 (TG18 Cholangitis)",
            category = "Hepatology",
            description = "Diagnostic criteria & severity grading for acute cholangitis.",
            formulaSummary = "Diagnostic: Inflammation (A) + Cholestasis (B) + Imaging (C). Severity Grade I-III dictating urgent biliary drainage via ERCP.",
            aliases = listOf("Tokyo Guidelines", "Tokyo TG18", "TG18", "TG 18", "Cholangitis", "Acute Cholangitis", "Biliary Drainage", "ERCP Triage"),
            isPopular = true,
            isNew = true
        ),

        // --- Medical Scoring Engine: Upper GI Bleeding ---
        CalculatorSummary(
            id = "glasgow_blatchford",
            title = "Glasgow-Blatchford Score (GBS)",
            category = "Gastroenterology",
            description = "Risk assessment & outpatient triage in acute upper GI bleeding.",
            formulaSummary = "BUN, Hb (by sex), SBP, Pulse >=100, Melena, Syncope, Hepatic/Cardiac disease. Score 0-1 = safe outpatient discharge.",
            aliases = listOf("GBS", "Glasgow Blatchford", "Upper GI Bleed", "UGIB", "Melena", "Hematemesis"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "aims65",
            title = "AIMS65 Score (Upper GI Bleed)",
            category = "Gastroenterology",
            description = "Bedside mortality and ICU prediction in acute upper GI hemorrhage.",
            formulaSummary = "Albumin <3.0, INR >1.5, Mental status altered (GCS<15), SBP <=90, Age >65. Score >=2 = high mortality / ICU need.",
            aliases = listOf("AIMS65", "Upper GI Bleed Mortality", "GI Bleed ICU"),
            isPopular = false,
            isNew = true
        ),

        // --- Medical Scoring Engine: General Medicine & Critical Care ---
        CalculatorSummary(
            id = "qsofa_score",
            title = "qSOFA (Quick Sepsis Score)",
            category = "Critical Care",
            description = "Bedside identification of patients at high risk of sepsis mortality.",
            formulaSummary = "RR >= 22 breaths/min, Altered mental status (GCS < 15), Systolic BP <= 100 mmHg. Score >= 2 = high risk of poor outcome.",
            aliases = listOf("qSOFA", "Quick SOFA", "Sepsis Screen", "Septic Shock"),
            isPopular = true,
            isNew = true
        ),

        // --- Medical Scoring Engine: Expanded Knowledge Base ---
        CalculatorSummary(
            id = "meld_3",
            title = "MELD 3.0 Score",
            category = "Hepatology",
            description = "Updated UNOS/OPTN liver allocation score with female risk correction.",
            formulaSummary = "Incorporates Bilirubin, INR, Creatinine, Sodium, Albumin, and female sex adjustment to predict 90-day waitlist mortality.",
            aliases = listOf("MELD 3.0", "MELD 3", "MELD3", "MELD-3", "MELD", "MELD Score", "UNOS MELD 3.0", "Model for End-Stage Liver Disease 3.0", "Liver Allocation"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "cdai_score",
            title = "CDAI (Crohn's Disease Activity Index)",
            category = "Gastroenterology",
            description = "Standard research and clinical index assessing Crohn's disease severity and remission.",
            formulaSummary = "7-day diary of liquid stools, abdominal pain, wellbeing, extraintestinal symptoms, mass, and hematocrit (<150 remission, >450 severe).",
            aliases = listOf("CDAI", "Crohn's Disease Activity Index", "Crohn", "CD Activity", "IBD Activity"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "ses_cd",
            title = "SES-CD (Simple Endoscopic Score for Crohn's)",
            category = "Gastroenterology",
            description = "Objective endoscopic scoring across 5 bowel segments.",
            formulaSummary = "Evaluates ulcer size, ulcerated surface, affected surface, and luminal stenosis across 5 ileocolonic segments.",
            aliases = listOf("SES-CD", "SES CD", "Simple Endoscopic Score", "Crohn Endoscopy", "Mucosal Healing"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "uceis_score",
            title = "UCEIS (Ulcerative Colitis Endoscopic Index)",
            category = "Gastroenterology",
            description = "Endoscopic index of mucosal severity in ulcerative colitis.",
            formulaSummary = "Vascular pattern (0-2), mucosal bleeding (0-3), and erosions & ulcers (0-3). Score >= 7 denotes severe mucosal damage.",
            aliases = listOf("UCEIS", "Endoscopic Index", "UC Endoscopy", "Mucosal Bleeding", "Colonic Ulcers"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "nas_score",
            title = "NAS (NAFLD / MASH Activity Score)",
            category = "Hepatology",
            description = "Histological grading of steatohepatitis activity.",
            formulaSummary = "Steatosis (0-3), Lobular Inflammation (0-3), and Hepatocyte Ballooning (0-2). NAS >= 5 confirms active MASH/NASH.",
            aliases = listOf("NAS", "NAS Score", "NAFLD Activity Score", "MASH Histology", "NASH CRN", "Steatohepatitis"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "fast_score",
            title = "FAST Score (FibroScan-AST for at-risk MASH)",
            category = "Hepatology",
            description = "Identifies patients with fibrotic nonalcoholic steatohepatitis (NAS >= 4, Fibrosis >= 2).",
            formulaSummary = "Combines Liver Stiffness Measurement (LSM, kPa), Controlled Attenuation Parameter (CAP, dB/m), and AST (U/L).",
            aliases = listOf("FAST", "FAST Score", "FibroScan AST", "LSM CAP AST", "At-risk MASH", "MASH Screening"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "clif_sofa",
            title = "CLIF-SOFA Score (Cirrhosis Organ Failure)",
            category = "Hepatology",
            description = "Quantifies organ failures in acute decompensation of cirrhosis.",
            formulaSummary = "EASL-CLIF sequential organ failure assessment across liver, kidney, brain, coagulation, circulation, and lungs.",
            aliases = listOf("CLIF-SOFA", "CLIF SOFA", "EASL CLIF", "Cirrhosis Organ Failure", "ACLF Score"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "alfsg_clichy",
            title = "ALFSG Index & Clichy Criteria",
            category = "Hepatology",
            description = "Emergency liver transplant indicators in acute liver failure.",
            formulaSummary = "Evaluates Factor V levels (<20-30%), age, and encephalopathy to identify non-acetaminophen ALF needing urgent transplant.",
            aliases = listOf("Clichy", "Clichy Criteria", "ALFSG", "Factor V", "Acute Liver Failure Transplant", "Fulminant Hepatic Failure"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "apache_ii",
            title = "APACHE II Score",
            category = "Critical Care",
            description = "Physiological severity score estimating ICU admission mortality.",
            formulaSummary = "12 acute physiological variables + age + chronic health points predicting in-hospital mortality.",
            aliases = listOf("APACHE", "APACHE II", "APACHE-2", "ICU Mortality", "Physiological Assessment"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "ctsi_balthazar",
            title = "CTSI (Balthazar CT Severity Index)",
            category = "Gastroenterology",
            description = "Radiological staging of acute necrotizing pancreatitis.",
            formulaSummary = "Balthazar grade A-E (0-4 pts) + pancreatic necrosis percentage (0-6 pts). Total >= 7 = severe necrotizing pancreatitis.",
            aliases = listOf("CTSI", "Balthazar", "CT Severity Index", "Pancreatic Necrosis", "Pancreatitis CT"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "forrest_classification",
            title = "Forrest Classification (Peptic Ulcer)",
            category = "Gastroenterology",
            description = "Endoscopic staging of bleeding peptic ulcers and rebleeding risk.",
            formulaSummary = "Ia/Ib (Active spurting/oozing), IIa/IIb/IIc (visible vessel, clot, flat spot), III (clean base). Guides endoscopic clipping.",
            aliases = listOf("Forrest", "Forrest Classification", "Peptic Ulcer Bleed", "Endoscopic Stigmata", "Ulcer Rebleed"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "timi_score",
            title = "TIMI Risk Score (UA / NSTEMI)",
            category = "Cardiology",
            description = "Predicts 14-day mortality, new/recurrent MI, or severe ischemia in ACS.",
            formulaSummary = "7 risk factors: Age >=65, >=3 CAD risk factors, known CAD stenosis >=50%, ASA in 7d, severe angina, elevated cardiac biomarkers, ST deviation.",
            aliases = listOf("TIMI", "TIMI Score", "TIMI NSTEMI", "Acute Coronary Syndrome", "NSTEMI Risk", "Chest Pain Risk"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "grace_score",
            title = "GRACE Risk Score for ACS",
            category = "Cardiology",
            description = "In-hospital and 6-month mortality in acute coronary syndrome.",
            formulaSummary = "Calculates risk from age, heart rate, SBP, creatinine, Killip class, cardiac arrest, ST deviation, and enzymes.",
            aliases = listOf("GRACE", "GRACE Score", "ACS Risk", "Coronary Syndrome", "Killip Class"),
            isPopular = false,
            isNew = true
        ),
        CalculatorSummary(
            id = "psi_port",
            title = "PSI / PORT Pneumonia Severity Index",
            category = "Pulmonology",
            description = "Risk stratifies community-acquired pneumonia to determine outpatient vs inpatient care.",
            formulaSummary = "20 demographic, comorbid, physical, and lab variables stratifying into Risk Classes I-V.",
            aliases = listOf("PSI", "PORT Score", "Pneumonia Severity Index", "PSI Pneumonia", "CAP Triage"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "perc_rule",
            title = "PERC Rule for Pulmonary Embolism",
            category = "Pulmonology",
            description = "Rules out pulmonary embolism in low-risk patients without D-dimer testing.",
            formulaSummary = "8 criteria: Age <50, HR <100, SpO2 >=95%, no leg swelling, no hemoptysis, no recent surgery, no prior PE/DVT, no hormones.",
            aliases = listOf("PERC", "PERC Rule", "Pulmonary Embolism Rule Out", "PE Rule Out", "D-dimer Skip"),
            isPopular = true,
            isNew = true
        ),
        CalculatorSummary(
            id = "kdigo_aki",
            title = "KDIGO AKI Staging Criteria",
            category = "Nephrology & Dosing",
            description = "Defines and stages acute kidney injury by serum creatinine and urine output.",
            formulaSummary = "Stage 1 (Cr 1.5-1.9x or >=0.3 mg/dL rise), Stage 2 (Cr 2.0-2.9x), Stage 3 (Cr >=3x or >=4.0 mg/dL or RRT).",
            aliases = listOf("KDIGO", "KDIGO AKI", "AKI Staging", "Acute Kidney Injury", "Urine Output AKI", "Renal Failure Staging"),
            isPopular = true,
            isNew = true
        )
    )
}
