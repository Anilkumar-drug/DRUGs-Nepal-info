package com.example.data.repository

import com.example.data.model.DiseaseProtocol

object DiseaseProtocolsData {

    val allProtocols: List<DiseaseProtocol> = listOf(
        DiseaseProtocol(
            id = "dp1",
            name = "Community-Acquired Pneumonia (CAP)",
            category = "Respiratory & Infectious",
            icd10 = "J18.9",
            diagnosticCriteria = "Acute onset of cough, fever (>38°C), dyspnea, pleuritic chest pain, tachypnea (RR >24/min), focal crackles or bronchial breath sounds on auscultation, and demonstration of a new infiltrate or consolidation on chest radiography (CXR) or CT. CURB-65 score used for outpatient vs hospital risk stratification.",
            firstLine = "Outpatient (No significant comorbidities or risk factors for resistant pathogens):\n• High-Dose Amoxicillin 1000 mg PO TID for 5-7 days OR\n• Doxycycline 100 mg PO BID for 5-7 days OR\n• Azithromycin 500 mg PO Day 1, then 250 mg PO once daily for Days 2-5 (only in regions with pneumococcal macrolide resistance <25%).",
            secondLine = "Outpatient (With comorbidities: chronic heart/lung/liver/renal disease, diabetes, alcoholism, malignancy, asplenia, age >65, or recent antibiotic use within 90 days):\n• Combination Therapy: Amoxicillin-Clavulanate 625 mg PO TID (or 1000 mg PO BID) PLUS Azithromycin 500 mg PO once daily for 5-7 days (or Doxycycline 100 mg BID) OR\n• Respiratory Fluoroquinolone Monotherapy: Levofloxacin 750 mg PO once daily for 5 days OR Moxifloxacin 400 mg PO once daily for 5-7 days.",
            inpatient = "Inpatient Non-Severe (General Medical Ward):\n• Ceftriaxone 1 to 2 g IV once daily PLUS Azithromycin 500 mg IV/PO once daily for 5-7 days OR\n• Ampicillin-Sulbactam 1.5 to 3 g IV q6h PLUS Azithromycin 500 mg IV/PO daily.\n\nInpatient Severe (ICU Admission / Septic Shock / Mechanical Ventilation):\n• Ceftriaxone 2 g IV once daily PLUS Azithromycin 500 mg IV once daily (or Levofloxacin 750 mg IV daily).\n• If MRSA risk (prior isolation, post-influenza): Add Vancomycin 15-20 mg/kg IV q8-12h (trough target 15-20 mcg/mL) or Linezolid 600 mg IV q12h.\n• If Pseudomonas aeruginosa risk (bronchiectasis, structural lung disease): Piperacillin-Tazobactam 4.5 g IV q6h PLUS Ciprofloxacin 400 mg IV q8h.",
            guidelines = "ATS/IDSA CAP Clinical Practice Guidelines 2019/2023, WHO Model Formulary & Harrison's 21st Edition.",
            keyDrugs = listOf("Amoxicillin + Potassium Clavulanate", "Azithromycin", "Ceftriaxone", "Levofloxacin", "Doxycycline"),
            supportiveCare = "Supplemental oxygen titrated to target SpO2 92-96% (88-92% if chronic hypercapnic respiratory failure/COPD). Early oral hydration, chest physiotherapy, early mobilization within 24 hours of hospital admission. Antipyretics: Paracetamol 500-1000 mg PO q6h PRN (max 4 g/day).",
            redFlags = "CURB-65 score ≥3: Confusion (new disorientation), Blood Urea >19 mg/dL (7 mmol/L), Respiratory rate ≥30/min, SBP <90 mmHg or DBP ≤60 mmHg, Age ≥65. Other red flags: SpO2 <90% on room air, arterial pH <7.35, multilobar infiltrates on CXR.",
            references = listOf(
                "UpToDate: Treatment of community-acquired pneumonia in adults (2024)",
                "Medscape: Community-Acquired Pneumonia Empirical Therapy",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 121",
                "IDSA/ATS Consensus Guidelines on the Management of Community-Acquired Pneumonia in Adults",
                "WHO Model List of Essential Medicines (23rd List, 2023)"
            )
        ),
        DiseaseProtocol(
            id = "dp2",
            name = "Essential Systemic Hypertension",
            category = "Cardiovascular",
            icd10 = "I10",
            diagnosticCriteria = "Persistent systolic BP ≥130 mmHg or diastolic BP ≥80 mmHg (ACC/AHA) or ≥140/90 mmHg (ESC/ESH & WHO) documented on at least 2 office visits separated by 1-4 weeks, or 24-hour ambulatory blood pressure monitoring (ABPM daytime mean ≥130/80 mmHg).",
            firstLine = "Stage 1 Hypertension (BP 130-139 / 80-89 mmHg):\n• Initial lifestyle modification for 3-6 months if 10-year ASCVD risk <10% (DASH diet, dietary sodium <2 g/day, aerobic exercise 150 min/wk, weight loss, alcohol moderation).\n• If ASCVD risk ≥10% or BP remains elevated: First-line monotherapy with ARB (Telmisartan 40 mg PO OD) OR Calcium Channel Blocker (Amlodipine 5 mg PO OD) OR Thiazide-like diuretic (Chlorthalidone 12.5-25 mg PO OD).",
            secondLine = "Stage 2 Hypertension (BP ≥140/90 mmHg or >20/10 mmHg above goal):\n• Initiate Dual Fixed-Dose Combination (FDC) therapy immediately:\n  1. Telmisartan 40 mg + Amlodipine 5 mg PO once daily OR\n  2. Telmisartan 40 mg + Hydrochlorothiazide 12.5 mg PO once daily.\n• Triple Combination Therapy (If uncontrolled after 4 weeks at target doses):\n  Telmisartan 80 mg + Amlodipine 10 mg + Chlorthalidone 25 mg PO once daily.\n• Resistant Hypertension (uncontrolled on 3 drugs including diuretic): Add Spironolactone 25-50 mg PO once daily (monitor serum potassium and eGFR).",
            inpatient = "Hypertensive Emergency (BP >180/120 mmHg with acute target organ damage: encephalopathy, ACS, acute pulmonary edema, aortic dissection, eclampsia, acute renal failure):\n• Immediate admission to ICU for continuous arterial line monitoring.\n• IV Labetalol: 20 mg IV slow bolus over 2 min, followed by 40-80 mg q10min (or continuous IV infusion at 1-2 mg/min, max 300 mg) OR\n• IV Nicardipine: 5 mg/hr continuous infusion, titrate by 2.5 mg/hr every 5-15 min to max 15 mg/hr.\n• Blood Pressure Reduction Target: Lower Mean Arterial Pressure (MAP) by no more than 20-25% in the first hour; then towards 160/100 mmHg over the next 2-6 hours (rapid over-reduction risks cerebral/myocardial hypoperfusion and infarction). Exception: Acute aortic dissection requires rapid SBP reduction <120 mmHg and HR <60 bpm within 20 minutes.",
            guidelines = "2017 ACC/AHA & 2023 ESC/ESH Guidelines for Arterial Hypertension, WHO Pharmacological Treatment of Hypertension 2021 & Harrison's 21st Ed.",
            keyDrugs = listOf("Telmisartan", "Amlodipine", "Hydrochlorothiazide", "Metoprolol", "Spironolactone"),
            supportiveCare = "DASH dietary pattern rich in potassium (fruits, vegetables, low-fat dairy). Sodium restriction (<2000 mg/day or <5g salt). Structured aerobic exercise 30-45 minutes daily. Discontinue NSAIDs, oral decongestants, and excessive licorice which elevate BP.",
            redFlags = "Hypertensive urgency/emergency signs: Sudden severe headache, visual blurring, scotoma, chest tightness, dyspnea, confusion, focal neurological deficit, hematuria, acute oliguria, papilledema on fundoscopy.",
            references = listOf(
                "UpToDate: Overview of hypertension in adults (2024)",
                "Medscape: Hypertension Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 271",
                "2023 ESC/ESH Guidelines for the management of arterial hypertension",
                "WHO Guideline for the pharmacological treatment of hypertension in adults (2021)"
            )
        ),
        DiseaseProtocol(
            id = "dp3",
            name = "Acute Paracetamol (Acetaminophen) Toxicity",
            category = "Emergency Toxicology",
            icd10 = "T39.1X1A",
            diagnosticCriteria = "Acute toxic ingestion of >150 mg/kg or >7.5 g Paracetamol within a single 8-hour period. Clinical phases: Phase 1 (0-24h): asymptomatic or anorexia, nausea, vomiting; Phase 2 (24-72h): RUQ tenderness, AST/ALT rise, PT/INR elevation; Phase 3 (72-96h): fulminant hepatic necrosis, jaundice, coagulopathy, encephalopathy, hypoglycemia, renal tubular necrosis.",
            firstLine = "Intravenous N-Acetylcysteine (NAC) 3-Bag Protocol (100% effective in preventing hepatotoxicity if started within 8 hours of ingestion):\n1. Bag 1 (Loading): 150 mg/kg NAC in 200 mL 5% Dextrose (D5W) infused IV over 60 minutes.\n2. Bag 2 (Maintenance 1): 50 mg/kg NAC in 500 mL D5W infused IV over 4 hours.\n3. Bag 3 (Maintenance 2): 100 mg/kg NAC in 1000 mL D5W infused IV over 16 hours.\n• Total IV NAC Dose: 300 mg/kg infused over 21 hours.\n• Oral NAC Regimen (Alternative): 140 mg/kg loading dose PO, then 70 mg/kg PO every 4 hours for a total of 17 maintenance doses (total 72-hour course).",
            secondLine = "Gastric Decontamination:\n• Activated Charcoal 1 g/kg (max 50 g in adults) administered orally or via NG tube if presentation is within 1 to 2 hours of ingestion and patient's airway is protected and intact. (Do not delay NAC administration to give charcoal).",
            inpatient = "Diagnostic & Hospital Escalation:\n• Measure 4-hour post-ingestion serum Paracetamol concentration and plot onto Rumack-Matthew Nomogram to determine hepatotoxicity risk line (threshold: 150 mcg/mL at 4 hours).\n• Serial Labs: Baseline and every 12 hours: AST, ALT, Total Bilirubin, INR/PT, Serum Creatinine, Blood Gas (Arterial Lactate and pH), Blood Glucose.\n• Extending NAC Therapy: If AST/ALT remain elevated or Paracetamol is still detectable at the end of the 21-hour infusion, continue Bag 3 (100 mg/kg over 16 hours) until ALT is declining and INR <2.0.\n• King's College Hospital Criteria for Liver Transplantation in Paracetamol Overdose:\n  Arterial pH <7.30 after fluid resuscitation (regardless of grade of encephalopathy) OR\n  All three of: Grade III/IV hepatic encephalopathy + Serum Creatinine >3.4 mg/dL (300 mcmol/L) + INR >6.5 (PT >100 seconds).",
            guidelines = "WHO Toxicology Protocols, Rumack-Matthew Nomogram, Harrison's 21st Edition & King's College Criteria.",
            keyDrugs = listOf("N-Acetylcysteine (NAC)", "Activated Charcoal"),
            supportiveCare = "Strict fluid balance and IV 10% Dextrose infusion to prevent hypoglycemia. Avoid all sedatives and nephrotoxic/hepatotoxic agents. Coagulopathy: do not give prophylactic FFP unless active hemorrhage or prior to invasive procedures as FFP obscures INR monitoring.",
            redFlags = "Metabolic acidosis with arterial pH <7.30, hyperlactatemia >3.5 mmol/L, serum creatinine >3.4 mg/dL, rapidly rising INR >3.0, encephalopathy (confusion, asterixis, somnolence).",
            references = listOf(
                "UpToDate: Acetaminophen (paracetamol) poisoning in adults: Treatment (2024)",
                "Medscape: Acetaminophen Toxicity Clinical Reference",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 446",
                "WHO Clinical Management of Acute Poisoning Protocols"
            )
        ),
        DiseaseProtocol(
            id = "dp4",
            name = "Type 2 Diabetes Mellitus",
            category = "Endocrine & Metabolic",
            icd10 = "E11.9",
            diagnosticCriteria = "Fasting plasma glucose (FPG) ≥126 mg/dL (7.0 mmol/L) after an 8-hour fast OR 2-hour plasma glucose ≥200 mg/dL (11.1 mmol/L) during a 75-g oral glucose tolerance test (OGTT) OR Glycated Hemoglobin (HbA1c) ≥6.5% (48 mmol/mol) OR Random plasma glucose ≥200 mg/dL in a patient with classic symptoms of hyperglycemia (polyuria, polydipsia, unexplained weight loss).",
            firstLine = "First-Line Pharmacological Monotherapy:\n• Metformin Hydrochloride: Initial 500 mg PO twice daily with meals or 850 mg PO once daily. Titrate by 500 mg weekly up to target dose of 1000 mg PO BID (or 2000 mg Extended Release once daily with evening meal).\n• Concomitant Comprehensive Lifestyle Intervention: Structured diabetes self-management education, 150 minutes/week moderate aerobic exercise + resistance training 2-3x/week, hypocaloric Mediterranean or plant-based diet, weight loss goal ≥5-10% of body weight.",
            secondLine = "Cardiorenal Risk-Directed Second-Line Add-on Therapy (Initiate independent of baseline HbA1c):\n1. Heart Failure (HFrEF/HFpEF) or Chronic Kidney Disease (eGFR 20-60 mL/min or UACR >30 mg/g):\n   • Add SGLT2 Inhibitor: Dapagliflozin 10 mg PO once daily OR Empagliflozin 10 mg PO once daily.\n2. Established Atherosclerotic Cardiovascular Disease (ASCVD) or High Risk:\n   • Add GLP-1 Receptor Agonist: Semaglutide 0.25 mg SC weekly x 4 wks, then 0.5-1.0 mg SC weekly OR SGLT2i.\n3. General Glycemic Escalation (Without high cardiorenal risk, if HbA1c remains >7.0%):\n   • Add DPP-4 Inhibitor: Sitagliptin 100 mg PO once daily (or Linagliptin 5 mg OD) OR\n   • Add Low-Risk Sulfonylurea: Glimepiride 1 to 2 mg PO once daily with breakfast (max 4-6 mg OD).",
            inpatient = "Severe Hyperglycemia / Inpatient Insulin Initiation:\n• Symptomatic Hyperglycemia (HbA1c >10%, blood glucose >300 mg/dL, or catabolic features: weight loss, ketonuria):\n  Initiate Basal Insulin: Insulin Glargine or Degludec 10 units SC once daily at bedtime (or 0.1-0.2 units/kg/day). Titrate dose by 2 units every 3 days until fasting blood glucose is 80-130 mg/dL.\n• Inpatient Hyperglycemia Management (Non-critical ward):\n  Basal-bolus insulin regimen (Basal 50% + Nutritional prandial Rapid-acting 50% divided TID before meals). Discontinue oral sulfonylureas and SGLT2i during acute hospitalization.",
            guidelines = "American Diabetes Association (ADA) Standards of Care in Diabetes 2024, WHO Package of Essential NCD Interventions & Harrison's 21st Edition.",
            keyDrugs = listOf("Metformin Hydrochloride", "Dapagliflozin", "Sitagliptin", "Glimepiride", "Insulin Glargine"),
            supportiveCare = "Self-monitoring of blood glucose (SMBG). Annual screening: dilated retinal exam, 10-g monofilament foot sensory testing, spot urine albumin-to-creatinine ratio (UACR), serum creatinine/eGFR, and lipid panel. Blood pressure goal <130/80 mmHg; Statin therapy (Atorvastatin 20-40 mg OD) recommended for all diabetes patients aged 40-75.",
            redFlags = "Hyperglycemic crises: Nausea, persistent vomiting, Kussmaul deep breathing, fruity acetone breath odor (DKA), profound dehydration, lethargy, obtundation (HHS). Hypoglycemic episodes (glucose <70 mg/dL): diaphoresis, palpitations, tremors, neuroglycopenia.",
            references = listOf(
                "UpToDate: Overview of general medical care in adults with diabetes mellitus (2024)",
                "Medscape: Type 2 Diabetes Mellitus Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 396",
                "American Diabetes Association (ADA) Standards of Care in Diabetes (2024)",
                "WHO Package of Essential Noncommunicable Disease Interventions (PEN)"
            )
        ),
        DiseaseProtocol(
            id = "dp5",
            name = "Acute Exacerbation of COPD (AECOPD)",
            category = "Respiratory",
            icd10 = "J44.1",
            diagnosticCriteria = "Acute worsening of patient's baseline respiratory symptoms that results in additional therapy. Characterized by the classic Anthonisen triad: increase in dyspnea, increase in sputum volume, and increase in sputum purulence.",
            firstLine = "Inhaled Short-Acting Bronchodilators:\n• Nebulized Salbutamol 2.5 to 5 mg PLUS Ipratropium Bromide 500 mcg every 20-30 minutes for 3 doses, then every 2 to 4 hours as clinically indicated.\n• Controlled Oxygen Therapy: Deliver controlled oxygen via Venturi mask (target SpO2 88-92%). Crucial: Avoid excessive high-flow oxygen, which blunts hypoxic respiratory drive and induces severe V/Q mismatch and fatal hypercapnic respiratory acidosis.",
            secondLine = "Systemic Corticosteroids:\n• Oral Prednisolone 40 mg PO once daily for 5 days (GOLD 2024 guidelines confirm 5 days is non-inferior to 14 days and minimizes corticosteroid toxicity). Switch to IV Methylprednisolone 40 mg IV q12h if unable to swallow.\n\nAntibiotic Therapy (Indicated if sputum purulence present + dyspnea or volume increase, or requiring mechanical ventilation):\n• Amoxicillin-Clavulanate 625 mg PO TID for 5 days OR\n• Azithromycin 500 mg PO Day 1, then 250 mg PO once daily for Days 2-5 OR\n• Doxycycline 100 mg PO BID for 5 days.",
            inpatient = "Hospital & Intensive Care Escalation:\n• Non-Invasive Positive Pressure Ventilation (NIV / BiPAP):\n  First-line ventilatory support in acute hypercapnic respiratory failure (pH <7.35 and PaCO2 >45 mmHg). Initial settings: IPAP 10-12 cm H2O, EPAP 4-5 cm H2O; titrate to reduce work of breathing. Reduces intubation rate by 60% and hospital mortality by 50%.\n• Invasive Mechanical Ventilation Criteria: Inability to tolerate NIV, worsening encephalopathy (GCS <10), hemodynamic instability, severe refractory hypoxemia (PaO2 <45 mmHg despite supplemental O2), or severe respiratory acidosis (pH <7.25).",
            guidelines = "GOLD 2024 Global Strategy for the Diagnosis, Management and Prevention of COPD, Harrison's 21st Ed & WHO.",
            keyDrugs = listOf("Salbutamol", "Ipratropium", "Prednisolone", "Amoxicillin + Potassium Clavulanate", "Azithromycin"),
            supportiveCare = "Early chest physiotherapy, controlled breathing techniques (pursed-lip breathing), hydration to assist mucus clearance. Sputum culture if frequent exacerbations or pseudomonas risk. Thromboprophylaxis with Enoxaparin 40 mg SC OD during hospitalization.",
            redFlags = "Severe tachypnea RR >30/min, use of accessory respiratory muscles, paradoxical abdominal wall motion, new cyanosis, confusion, asterixis (flapping tremor indicating severe CO2 retention), arterial pH <7.26.",
            references = listOf(
                "UpToDate: COPD exacerbations: Management (2024)",
                "Medscape: Chronic Obstructive Pulmonary Disease Exacerbation Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 286",
                "Global Initiative for Chronic Obstructive Lung Disease (GOLD) 2024 Report"
            )
        ),
        DiseaseProtocol(
            id = "dp6",
            name = "Uncomplicated & Complicated Urinary Tract Infection (Acute Cystitis & Pyelonephritis)",
            category = "Renal & Genitourinary",
            icd10 = "N39.0 / N10",
            diagnosticCriteria = "Acute Cystitis: Dysuria, frequency, urgency, suprapubic tenderness without fever, chills, or flank pain. Urinalysis: Pyuria (≥10 WBC/mcL), positive leukocyte esterase, positive nitrite. Acute Pyelonephritis: Fever (>38°C), chills, flank pain, costovertebral angle (CVA) tenderness, nausea, vomiting, with or without cystitis symptoms. Urine culture positive (≥10^4-10^5 CFU/mL).",
            firstLine = "Acute Uncomplicated Cystitis (Non-pregnant Premenopausal Women):\n1. Nitrofurantoin Monohydrate/Macrocrystals: 100 mg PO BID with meals for 5 days (contraindicated if eGFR <30 mL/min) OR\n2. Fosfomycin Trometamol: 3 g PO single-dose dissolved in 100 mL water OR\n3. Trimethoprim-Sulfamethoxazole (TMP-SMX): 160/800 mg (1 Double Strength tab) PO BID for 3 days (only in communities with known E. coli resistance <20%).",
            secondLine = "Alternative Cystitis Regimens / Penicillin & Fluoroquinolone Options:\n• Amoxicillin-Clavulanate 625 mg PO BID for 5-7 days OR\n• Cefpodoxime Proxetil 100 mg PO BID for 5-7 days OR\n• Ciprofloxacin 250-500 mg PO BID for 3 days (reserve fluoroquinolones strictly for when other first-line options cannot be used, due to risk of tendon rupture and resistance).",
            inpatient = "Acute Pyelonephritis Management:\n• Outpatient Mild Pyelonephritis: Ciprofloxacin 500 mg PO BID for 7 days OR Levofloxacin 750 mg PO once daily for 5 days OR Ceftriaxone 1 g IV single dose followed by oral Cefpodoxime 200 mg BID for 10 days.\n• Inpatient Severe Pyelonephritis (Systemic signs, vomiting, sepsis, pregnancy, urinary obstruction):\n  Ceftriaxone 1 to 2 g IV once daily for 10-14 days OR Piperacillin-Tazobactam 3.375 g IV q6h. Switch to targeted oral therapy once afebrile for 48 hours.\n• Urological Emergency: Urgent renal ultrasound or CT to rule out obstructing nephrolithiasis or perinephric abscess if fever persists after 72 hours of appropriate IV antibiotics.",
            guidelines = "IDSA Guidelines for Treatment of Uncomplicated Cystitis and Pyelonephritis, CDC & Harrison's 21st Edition.",
            keyDrugs = listOf("Nitrofurantoin", "Amoxicillin + Potassium Clavulanate", "Ceftriaxone", "Ciprofloxacin", "Azithromycin"),
            supportiveCare = "High oral fluid intake (2-3 L/day). Urinary analgesic for severe dysuria: Phenazopyridine 100-200 mg PO TID for maximum 2 days (warn patient of harmless orange/red urine discoloration). Voiding after intercourse and avoiding spermicides.",
            redFlags = "High-spiking fevers, rigors, persistent vomiting, severe flank pain, oliguria, hypotension, septic shock, lack of clinical improvement after 48-72 hours of antibiotic therapy.",
            references = listOf(
                "UpToDate: Acute simple cystitis in adult and adolescent females (2024)",
                "Medscape: Urinary Tract Infection (UTI) and Cystitis Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 136",
                "IDSA International Clinical Practice Guidelines for Uncomplicated Cystitis and Pyelonephritis"
            )
        ),
        DiseaseProtocol(
            id = "dp7",
            name = "Organophosphate & Carbamate Poisoning",
            category = "Emergency Toxicology",
            icd10 = "T60.0X1A",
            diagnosticCriteria = "History of pesticide ingestion, dermal exposure, or inhalation. Presentation with classic Acute Cholinergic Toxidrome (SLUDGEM / Killer B's): Salivation, Lacrimation, Urination, Defecation, GI cramping, Emesis, Miosis (pinpoint pupils), Bronchorrhea, Bronchospasm, Bradycardia, fasciculations. In carbamate toxicity, cholinesterase inhibition is spontaneously reversible within 24-48 hours.",
            firstLine = "Decontamination & Immediate Resuscitation:\n• Rescuer Protection: Wear nitrile gloves and gown. Immediately strip all contaminated clothing and place in sealed biohazard bags. Copiously wash patient's skin and hair with soap and water.\n• Airway & High-Flow Oxygen: Suction copious tracheobronchial secretions. Pre-oxygenate before atropine administration (atropine in hypoxic myocardium can trigger ventricular arrhythmias).\n\nFirst-Line Antidote - Atropine Sulfate (Antimuscarinic):\n• Initial Bolus: 2 to 5 mg IV push immediately (pediatric 0.05 mg/kg).\n• Escalation: Double the dose every 5 to 10 minutes (e.g., 2 mg, 4 mg, 8 mg, 16 mg) until full ATROPINIZATION is achieved.\n• Definitive Endpoints of Atropinization (The 5 Signs):\n  1. Lungs clear on auscultation (complete resolution of bronchorrhea & bronchospasm)\n  2. Heart rate >80 bpm\n  3. Systolic BP >90 mmHg\n  4. Dry axillae and warm, flushed dry skin\n  5. Pupillary dilation (Note: Miosis can persist even after lungs are clear; NEVER titrate atropine solely to pupil size).\n• Maintenance Atropine Infusion: Once atropinized, start continuous IV infusion of 10-20% of the total cumulative dose required to achieve atropinization per hour, tapering over 24-48 hours.",
            secondLine = "Second-Line Oxime Therapy - Pralidoxime (2-PAM) (Cholinesterase Reactivator):\n• Indicated for moderate-to-severe organophosphate toxicity with muscle weakness/fasciculations (effective only if given within 24-48 hours before irreversible biochemical enzyme aging occurs; not indicated in pure carbamate poisoning):\n• Pralidoxime Dosing: 1 to 2 g IV in 100 mL Normal Saline infused over 30 minutes, followed by a continuous IV maintenance infusion of 500 mg/hour (8 mg/kg/hr in children) until recovery or for at least 24 hours.",
            inpatient = "ICU Monitoring & Intermediate Syndrome:\n• Benzodiazepines for Seizures & Agitation: Diazepam 10 mg IV (or Lorazepam 4 mg IV) titrated to prevent seizures and reduce central nervous system excitability.\n• Intermediate Syndrome Surveillance: Occurs 24-96 hours after ingestion; characterized by sudden weakness of proximal neck flexor muscles, cranial nerve palsies, and diaphragmatic weakness leading to acute respiratory arrest. Requires immediate elective endotracheal intubation and mechanical ventilation.\n• Delayed Polyneuropathy (OPIDN): Bilateral lower extremity sensory loss and flaccid weakness developing 1-3 weeks post-exposure.",
            guidelines = "WHO Clinical Management of Acute Poisoning Protocols, Harrison's 21st Edition & Inter-Regional Toxicology Guidelines.",
            keyDrugs = listOf("Atropine Sulfate", "Pralidoxime (2-PAM)", "Diazepam"),
            supportiveCare = "Intensive suctioning, continuous pulse oximetry and ECG monitoring. Foley catheter to monitor urine output. Avoid succinylcholine for intubation (metabolized by plasma cholinesterase, will result in prolonged paralysis lasting hours); use Rocuronium or Vecuronium.",
            redFlags = "Sudden drop in oxygen saturation, re-accumulation of bronchopulmonary secretions, neck flexion weakness (cannot lift head off pillow - harbinger of respiratory arrest), refractory bradycardia.",
            references = listOf(
                "UpToDate: Organophosphate and carbamate poisoning: Treatment (2024)",
                "Medscape: Organophosphate Toxicity Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 446",
                "WHO Clinical Management of Acute Poisoning: Organophosphorus Pesticides"
            )
        ),
        DiseaseProtocol(
            id = "dp8",
            name = "Bronchial Asthma (Stepwise Management & Acute Exacerbation)",
            category = "Respiratory & Allergy",
            icd10 = "J45.901",
            diagnosticCriteria = "History of variable respiratory symptoms (wheeze, shortness of breath, chest tightness, cough) that vary over time and in intensity, triggered by exercise, allergens, cold air, or viral infections. Objective evidence of variable expiratory airflow limitation: post-bronchodilator increase in FEV1 >12% and >200 mL, or average daily diurnal PEF variability >10%.",
            firstLine = "Maintenance & Reliever Therapy (GINA 2024 Track 1 - Preferred Strategy Across All Steps):\n• Steps 1-2 (Mild Asthma): Low-dose Inhaled Corticosteroid (ICS) - Formoterol combination (e.g., Budesonide 160 mcg / Formoterol 4.5 mcg) 1 puff as needed (PRN) for symptom relief (no daily maintenance needed).\n• Step 3 (Moderate Asthma): Regular low-dose ICS-Formoterol 1 puff PO BID plus 1-2 puffs PRN for reliever.\n• Step 4: Medium-dose ICS-Formoterol 2 puffs PO BID plus PRN.\n• Step 5 (Severe Asthma): High-dose ICS-Formoterol + add LAMA (Tiotropium Respimat 5 mcg daily) + evaluate for biologic phenotype therapy (Anti-IgE Omalizumab, Anti-IL5 Mepolizumab, Anti-IL4R Dupilumab).",
            secondLine = "Alternative Strategy (GINA Track 2 - Daily Maintenance ICS + SABA Reliever):\n• Regular daily low-dose Inhaled Corticosteroid (e.g., Fluticasone Propionate 100-250 mcg BID or Budesonide 200-400 mcg BID) PLUS Salbutamol 100-200 mcg 2 puffs PRN as reliever.\n• Step-up add-on options: Leukotriene Receptor Antagonist (Montelukast 10 mg PO once daily in the evening) or Inhaled LABA (Salmeterol 50 mcg BID).",
            inpatient = "Acute Severe Asthma Exacerbation Protocol:\n• High-Flow Oxygen: Titrate to target SpO2 93-95% in adults (94-98% in children).\n• Inhaled Bronchodilators: Continuous or frequent Nebulized Salbutamol 5 mg PLUS Ipratropium Bromide 500 mcg every 20 minutes for 3 doses, then every 1 to 2 hours.\n• Systemic Corticosteroids: Oral Prednisolone 40-50 mg PO once daily for 5-7 days OR IV Hydrocortisone 100-200 mg q6h (oral is as effective as IV if patient can swallow).\n• IV Magnesium Sulfate: 2 g in 100 mL Normal Saline infused IV over 20 minutes (indicated for severe exacerbations not responding to initial bronchodilators, PEF <50%, or persistent hypoxia).\n• Impending Respiratory Failure: Silent chest, drowsiness, PaCO2 >45 mmHg, exhaustion; prepare for immediate ketamine-assisted endotracheal intubation.",
            guidelines = "Global Initiative for Asthma (GINA) 2024 Strategy Report, British Thoracic Society (BTS/SIGN) & Harrison's 21st Ed.",
            keyDrugs = listOf("Salbutamol", "Budesonide", "Prednisolone", "Ipratropium", "Montelukast"),
            supportiveCare = "Written Asthma Action Plan for every patient. Inhaler technique verification at every visit (use of spacer device with MDI). Allergen avoidance (dust mites, pet dander, tobacco smoke cessation). Annual influenza and pneumococcal vaccination.",
            redFlags = "Silent chest on auscultation (loss of wheeze due to critical airflow reduction), altered consciousness, pulsus paradoxus >25 mmHg, PEF <33% of predicted, cyanosis, normal or elevated PaCO2 in the setting of tachypnea (indicates impending respiratory arrest).",
            references = listOf(
                "UpToDate: Acute asthma exacerbations in adults: Treatment (2024)",
                "Medscape: Asthma Treatment Protocols and GINA Updates",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 281",
                "Global Initiative for Asthma (GINA) 2024 Strategy Report",
                "WHO Essential Noncommunicable Disease Interventions"
            )
        ),
        DiseaseProtocol(
            id = "dp9",
            name = "Acute Myocardial Infarction (STEMI & NSTEMI / ACS)",
            category = "Cardiovascular & Critical Care",
            icd10 = "I21.9",
            diagnosticCriteria = "Ischemic chest pain/pressure lasting >20 minutes radiating to neck, jaw, or left arm, accompanied by diaphoresis, nausea, or dyspnea. STEMI: Persistent ST elevation ≥1 mm in ≥2 contiguous leads (or new LBBB, or ≥2 mm in leads V2-V3). NSTEMI: Ischemic ST depression, T wave inversion, or normal ECG with elevated high-sensitivity Cardiac Troponin I/T above the 99th percentile URL with rising/falling kinetics.",
            firstLine = "Immediate Initial Emergency Resuscitation (MONA-B Protocol):\n• Aspirin: 300 to 325 mg non-enteric chewable tablet orally immediately upon medical contact.\n• Sublingual Nitroglycerin: 0.4 mg SL tablet or spray every 5 minutes up to 3 doses for ischemic chest pain. (CONTRAINDICATED if SBP <90 mmHg, HR <50 or >100 bpm, right ventricular infarction, or phosphodiesterase-5 inhibitor use within past 24-48h).\n• Supplemental Oxygen: Only if SpO2 <90% or patient in respiratory distress (routine hyperoxia induces coronary vasoconstriction and increases infarct size).\n• Analgesia: IV Morphine 2 to 4 mg IV only for severe refractory ischemic discomfort.",
            secondLine = "Dual Antiplatelet Therapy (DAPT) & Anticoagulation:\n• P2Y12 Inhibitor Loading Dose:\n  1. Ticagrelor: 180 mg PO loading dose, followed by 90 mg PO BID maintenance OR\n  2. Prasugrel: 60 mg PO loading dose, followed by 10 mg PO once daily (only if PCI planned; avoid if prior stroke/TIA or age >75) OR\n  3. Clopidogrel: 600 mg PO loading dose, followed by 75 mg PO once daily (if ticagrelor/prasugrel unavailable or patient on oral anticoagulation).\n• Parenteral Anticoagulation: Unfractionated Heparin (UFH 60 units/kg IV bolus, max 4000 units, then 12 units/kg/hr infusion) OR Enoxaparin 1 mg/kg SC q12h OR Bivalirudin (for PCI).\n• High-Intensity Statin Therapy: Atorvastatin 80 mg PO once daily immediately (regardless of baseline cholesterol).",
            inpatient = "STEMI Reperfusion Strategy:\n• Primary Percutaneous Coronary Intervention (PCI): The preferred reperfusion strategy if first medical contact to device time is <90 minutes (or <120 minutes if transferred).\n• Fibrinolytic Therapy: If primary PCI cannot be performed within 120 minutes of STEMI diagnosis, administer IV Fibrinolysis within 30 minutes of arrival (door-to-needle <30 min):\n  Tenecteplase (TNK-tPA) weight-based IV bolus over 5-10 seconds (30 mg for <60 kg, escalating up to 50 mg for ≥90 kg; halve dose in patients ≥75 years) OR Alteplase (t-PA) 100 mg accelerated IV infusion over 90 minutes.\n• Post-Infarction Secondary Medical Prophylaxis:\n  1. Oral Beta-Blocker: Metoprolol Tartrate 25-50 mg PO BID (initiated within 24h if no signs of heart failure, low-output state, or heart block)\n  2. ACE Inhibitor / ARB: Ramipril 2.5-10 mg OD or Telmisartan 40-80 mg OD\n  3. Mineralocorticoid Receptor Antagonist: Eplerenone 25-50 mg OD or Spironolactone 25 mg OD if LVEF ≤40% and clinical heart failure.",
            guidelines = "2023 ACC/AHA & ESC Guidelines for Management of Acute Coronary Syndromes, Harrison's 21st Ed.",
            keyDrugs = listOf("Aspirin", "Clopidogrel", "Atorvastatin", "Metoprolol", "Telmisartan"),
            supportiveCare = "Bed rest with continuous cardiac telemetry monitoring for at least 24-48 hours. Daily monitoring of cardiac biomarkers, 12-lead ECG, and baseline transthoracic echocardiogram to assess left ventricular function, mechanical complications, and regional wall motion abnormalities.",
            redFlags = "Killip Class III/IV cardiogenic shock (SBP <90 mmHg, cold clammy extremities, oliguria), acute pulmonary edema, new systolic murmur (ventricular septal rupture or acute mitral regurgitation due to papillary muscle rupture), malignant ventricular arrhythmias (VT/VF), third-degree AV block.",
            references = listOf(
                "UpToDate: Initial evaluation and management of suspected acute coronary syndrome (2024)",
                "Medscape: Acute Coronary Syndrome Clinical Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapters 268 & 269",
                "2023 ESC Guidelines for the management of acute coronary syndromes",
                "ACC/AHA Guideline for the Management of Patients With STEMI"
            )
        ),
        DiseaseProtocol(
            id = "dp10",
            name = "Acute Ischemic Stroke",
            category = "Central Nervous System & Emergency",
            icd10 = "I63.9",
            diagnosticCriteria = "Sudden onset of focal neurological deficit characterized by FAST (Face drooping, Arm weakness, Speech difficulty, Time of onset). Rapid evaluation using National Institutes of Health Stroke Scale (NIHSS). Immediate non-contrast head CT or brain MRI within 20 minutes of hospital arrival to definitively rule out intracranial hemorrhage prior to reperfusion therapy.",
            firstLine = "Emergency Stabilization & Triage:\n• Airway, Breathing, Circulation: Maintain SpO2 >94% with supplemental oxygen.\n• Fingerstick Glucose: Treat hypoglycemia (<60 mg/dL) immediately with 50 mL 50% Dextrose IV; target glucose 140-180 mg/dL.\n• Blood Pressure Management Prior to Thrombolysis: If candidate for IV thrombolysis, blood pressure MUST be lowered to <185/110 mmHg:\n  Labetalol 10 to 20 mg IV slow push over 1-2 minutes; may repeat once OR\n  Nicardipine IV infusion 5 mg/hr, titrating up by 2.5 mg/hr every 5-15 minutes (max 15 mg/hr).",
            secondLine = "Intravenous Thrombolysis (Window ≤4.5 hours from last known normal / symptom onset):\n• IV Alteplase (rt-PA): 0.9 mg/kg (maximum dose 90 mg). Administer 10% of total dose as an immediate IV bolus over 1 minute; infuse the remaining 90% continuously over 60 minutes OR\n• IV Tenecteplase: 0.25 mg/kg IV single bolus over 5 seconds (maximum 25 mg).\n\nEndovascular Mechanical Thrombectomy (EVT):\n• Indicated for Large Vessel Occlusion (LVO) of the anterior circulation (Internal Carotid Artery or Proximal Middle Cerebral Artery M1 segment) within 6 hours of symptom onset (and up to 24 hours under DAWN / DEFUSE-3 neuroimaging perfusion criteria).",
            inpatient = "Post-Reperfusion & Secondary Inpatient Management:\n• Strict BP Control Post-Thrombolysis: Maintain blood pressure <180/105 mmHg for at least the first 24 hours post-thrombolytic therapy.\n• Antithrombotic Timing (CRITICAL): Withhold ALL antiplatelet agents (aspirin, clopidogrel) and anticoagulants for 24 hours post-thrombolysis until a repeat head CT or MRI confirms absence of hemorrhagic transformation.\n• Secondary Prevention at 24 Hours:\n  1. Dual Antiplatelet Therapy (DAPT): Aspirin 160-300 mg PO loading then 100 mg OD PLUS Clopidogrel 300 mg loading then 75 mg OD for 21 days for minor ischemic stroke (NIHSS ≤3) or high-risk TIA (ABCD2 score ≥4), followed by single antiplatelet therapy.\n  2. High-Intensity Statin Therapy: Atorvastatin 80 mg PO once daily (target LDL <55 mg/dL).\n  3. Atrial Fibrillation / Cardioembolic Stroke: Initiate oral anticoagulation (DOAC: Apixaban 5 mg BID or Rivaroxaban 20 mg OD) after 3-14 days based on infarct size.",
            guidelines = "AHA/ASA Guidelines for the Early Management of Patients with Acute Ischemic Stroke 2019/2023 Update & Harrison's 21st Edition.",
            keyDrugs = listOf("Aspirin", "Clopidogrel", "Atorvastatin", "Telmisartan", "Labetalol"),
            supportiveCare = "Immediate formal dysphagia / swallowing screen prior to any oral intake to prevent fatal aspiration pneumonia. Early mobilization within 24-48 hours. Normothermia maintenance (treat fever >37.5°C aggressively with paracetamol as hyperthermia accelerates cerebral ischemic injury). VTE prophylaxis with pneumatic compression devices.",
            redFlags = "Signs of hemorrhagic transformation or malignant middle cerebral artery syndrome: Sudden neurological deterioration, severe headache, acute vomiting, acute hypertension, pupillary asymmetry, decreased consciousness. Emergent non-contrast head CT and neurosurgical consultation required.",
            references = listOf(
                "UpToDate: Initial assessment and management of acute stroke (2024)",
                "Medscape: Ischemic Stroke Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 423",
                "2019/2023 AHA/ASA Guidelines for the Early Management of Patients With Acute Ischemic Stroke"
            )
        ),
        DiseaseProtocol(
            id = "dp11",
            name = "Status Epilepticus & Generalized Convulsive Seizures",
            category = "Central Nervous System & Critical Care",
            icd10 = "G40.901",
            diagnosticCriteria = "Continuous, unremitting convulsive seizure activity lasting ≥5 minutes OR two or more discrete seizures between which there is incomplete recovery of consciousness. (Status epilepticus is a medical emergency requiring aggressive step-by-step treatment to prevent permanent neuronal injury).",
            firstLine = "Phase 1: Emergent Initial Assessment (0–5 Minutes):\n• Airway, Breathing, Circulation: Position patient in lateral recovery position; administer high-flow oxygen via non-rebreather mask; obtain immediate fingerstick blood glucose.\n• If Hypoglycemic (<60 mg/dL): Administer 50 mL 50% Dextrose (D50W) IV PLUS Thiamine 100 mg IV (in adults to prevent Wernicke encephalopathy).\n\nPhase 2: Emergent Initial Antiseizure Therapy (5–20 Minutes - First-Line Benzodiazepine):\n• Lorazepam: 4 mg IV slow push (0.1 mg/kg) over 2 minutes. If seizures persist at 5-10 minutes, repeat the 4 mg IV dose once OR\n• Midazolam: 10 mg Intramuscular (IM) (for patients >40 kg; 5 mg for 13-40 kg) - preferred if IV access has not yet been established OR\n• Diazepam: 10 mg IV push (0.2 mg/kg) administered at 2-5 mg/minute; may repeat once in 5-10 minutes.",
            secondLine = "Phase 3: Urgent Control Therapy (20–40 Minutes - Second-Line Non-Sedating Antiseizure Medication):\n• Levetiracetam (Keppra): 60 mg/kg IV (maximum 4500 mg) infused over 10 minutes (preferred first-line second-step due to rapid infusion and absence of cardiac toxicity) OR\n• Fosphenytoin: 20 mg PE/kg IV (maximum 1500 mg PE) infused at 150 mg PE/min with continuous ECG and blood pressure monitoring OR\n• Sodium Valproate: 40 mg/kg IV (maximum 3000 mg) infused over 5-10 minutes.",
            inpatient = "Phase 4: Refractory Status Epilepticus (>40 Minutes - General Anesthesia Infusion):\n• Immediate Endotracheal Intubation, mechanical ventilation, and transfer to ICU with continuous electroencephalography (cEEG) monitoring.\n• Propofol: 2 mg/kg IV bolus over 5 minutes, followed by continuous maintenance infusion of 2 to 10 mg/kg/hour OR\n• Midazolam Infusion: 0.2 mg/kg IV loading bolus over 2 minutes, followed by 0.05 to 2.0 mg/kg/hour continuous infusion OR\n• Ketamine: 1 to 2 mg/kg IV loading bolus followed by 1 to 5 mg/kg/hour infusion.\n• Treatment Endpoint: Titrate continuous anesthetic to achieve complete electrographic seizure cessation or burst suppression on EEG for 24 to 48 hours before gradual tapering.",
            guidelines = "American Epilepsy Society (AES) Guidelines for Status Epilepticus & Neurocritical Care Society Protocols.",
            keyDrugs = listOf("Lorazepam", "Levetiracetam", "Diazepam", "Midazolam", "Sodium Valproate"),
            supportiveCare = "Continuous core body temperature monitoring (treat hyperthermia with cooling blankets). Continuous pulse oximetry, capnography, and invasive arterial pressure line. Correct electrolyte derangements (hypocalcemia, hypomagnesemia, hyponatremia).",
            redFlags = "Convulsive status epilepticus progressing to non-convulsive status epilepticus (subtle rhythmic twitches of eyelid/fingers with profound coma), profound hyperthermia (>40°C), rhabdomyolysis with dark brown urine and acute renal failure, persistent refractory status epilepticus beyond 60 minutes.",
            references = listOf(
                "UpToDate: Management of status epilepticus in adults (2024)",
                "Medscape: Status Epilepticus Emergency Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 420",
                "American Epilepsy Society (AES) Evidence-Based Guideline: Treatment of Convulsive Status Epilepticus in Children and Adults"
            )
        ),
        DiseaseProtocol(
            id = "dp12",
            name = "Anaphylaxis & Severe Allergic Shock",
            category = "Emergency & Critical Care",
            icd10 = "T78.2",
            diagnosticCriteria = "Acute onset (minutes to hours) of illness involving skin/mucosal tissue (generalized hives, pruritus, flushing, swollen lips/tongue/uvula) PLUS at least one of: 1. Respiratory compromise (dyspnea, wheeze, stridor, hypoxemia); 2. Reduced blood pressure or signs of end-organ hypoperfusion (hypotonia, syncope, incontinence); OR acute hypotension (SBP <90 mmHg or >30% drop from baseline) immediately following exposure to a known allergen.",
            firstLine = "IMMEDIATE FIRST-LINE THERAPY (DO NOT DELAY FOR ANY REASON):\n• Intramuscular Epinephrine (Adrenaline) 1:1000 (1 mg/mL) injected into the anterolateral mid-thigh (vastus lateralis):\n  Adult Dose: 0.5 mg (0.5 mL) IM.\n  Pediatric Dose: 0.01 mg/kg IM (maximum 0.3 mg).\n• Repeat Dose: Repeat every 5 to 15 minutes if symptoms fail to resolve or if patient deteriorates.\n• Patient Positioning (CRITICAL): Keep patient recumbent with legs elevated (Trendelenburg) to promote venous return. NEVER allow patient to stand up or sit up suddenly (risk of fatal 'empty ventricle syndrome' and sudden cardiac arrest).",
            secondLine = "Oxygen & Aggressive Fluid Resuscitation:\n• High-Flow Oxygen: 10 to 15 L/min via non-rebreather face mask to maintain SpO2 >95%.\n• Rapid IV Crystalloid Resuscitation: Massive vasodilation and capillary leakage causes up to 35% intravascular volume loss within 10 minutes:\n  Adults: Normal Saline or Ringer's Lactate 1 to 2 Liters rapid IV pressure infusion (20-30 mL/kg in first 10-20 min).\n  Children: 20 mL/kg rapid bolus.\n• Inhaled Bronchodilator: Salbutamol 2.5-5 mg nebulized for persistent wheezing/bronchospasm.",
            inpatient = "Secondary Adjunctive Medications & Refractory Shock Management:\n(Note: Antihistamines and steroids are SECONDARY; they NEVER replace or take precedence over epinephrine):\n• H1 Antihistamine: Chlorpheniramine 10 mg IV/IM OR Diphenhydramine 25-50 mg IV.\n• H2 Antihistamine: Famotidine 20 mg IV (or Ranitidine 50 mg IV).\n• Systemic Corticosteroid: Hydrocortisone 200 mg IV (or Methylprednisolone 1-2 mg/kg IV) to help prevent late-phase biphasic anaphylactic reactions.\n• Epinephrine-Refractory Anaphylactic Shock:\n  Continuous Epinephrine IV Infusion: Start at 0.1 to 1.0 mcg/kg/min (titrate rapidly to maintain SBP >90 mmHg).\n• Patients on Beta-Blockers (Resistant to Epinephrine):\n  Glucagon: 1 to 5 mg IV slow bolus over 5 minutes, followed by a continuous infusion of 5 to 15 mcg/min (activates cardiac adenylate cyclase independently of beta-adrenergic receptors).\n• Hospital Observation: Monitor in hospital for at least 6 to 12 hours (up to 20% of patients experience a late biphasic reaction hours after apparent recovery).",
            guidelines = "World Allergy Organization (WAO) Anaphylaxis Guidelines 2020, Resuscitation Council UK & Harrison's 21st Edition.",
            keyDrugs = listOf("Epinephrine (Adrenaline)", "Hydrocortisone", "Salbutamol", "Chlorpheniramine", "Famotidine"),
            supportiveCare = "Prescribe Epinephrine Auto-Injector (EpiPen 0.3 mg) on discharge with comprehensive training. Written Anaphylaxis Emergency Action Plan. Refer to allergy specialist for allergen identification and desensitization.",
            redFlags = "Laryngeal edema with stridor and voice hoarseness (prepare for immediate surgical cricothyroidotomy if endotracheal intubation fails due to massive airway swelling), refractory hypotension despite 3 doses of IM epinephrine, severe chest pain (Kounis syndrome: allergic myocardial infarction).",
            references = listOf(
                "UpToDate: Anaphylaxis: Emergency treatment (2024)",
                "Medscape: Anaphylaxis Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 348",
                "World Allergy Organization (WAO) Anaphylaxis Guidelines: 2020",
                "Resuscitation Council UK Emergency Treatment of Anaphylaxis"
            )
        ),
        DiseaseProtocol(
            id = "dp13",
            name = "Peptic Ulcer Disease & Helicobacter Pylori Eradication",
            category = "Gastrointestinal & Infectious",
            icd10 = "K27.9 / B98.0",
            diagnosticCriteria = "Epigastric gnawing or burning pain (typically relieved by food/antacids in duodenal ulcers; worsened by food in gastric ulcers), dyspepsia, early satiety, nausea, confirmed by upper endoscopy showing mucosal break ≥5 mm. Confirmation of H. pylori by endoscopic biopsy (rapid urease test/histology) or non-invasive stool antigen test / urea breath test.",
            firstLine = "First-Line Preferred Regimen - Bismuth Quadruple Therapy for 14 Days (Highest eradication rate >90% even in regions with high clarithromycin resistance):\n1. Bismuth Subsalicylate 300 mg (or Bismuth Subcitrate 120-300 mg) PO QID (with meals & bedtime)\n2. Metronidazole 500 mg PO TID or QID (or 250 mg QID)\n3. Tetracycline Hydrochloride 500 mg PO QID\n4. Standard-to-Double Dose Proton Pump Inhibitor (PPI): Esomeprazole 40 mg PO BID OR Pantoprazole 40 mg PO BID OR Rabeprazole 20 mg PO BID taken 30-60 minutes before breakfast and dinner.",
            secondLine = "Alternative First-Line Regimens:\n• Clarithromycin Triple Therapy x 14 Days (ONLY in regions where local Clarithromycin resistance is documented to be <15%):\n  PPI standard dose BID + Clarithromycin 500 mg PO BID + Amoxicillin 1000 mg PO BID for 14 days.\n• Non-Bismuth Concomitant Quadruple Therapy x 14 Days:\n  PPI standard dose BID + Amoxicillin 1000 mg BID + Clarithromycin 500 mg BID + Metronidazole 500 mg BID.\n• NSAID-Induced Ulcer (H. pylori negative):\n  Discontinue offending NSAID immediately. Pantoprazole 40 mg PO once daily (or Omeprazole 40 mg OD) for 8 weeks.",
            inpatient = "Acute Peptic Ulcer Hemorrhage (Hematemesis / Melena):\n• Hemodynamic Resuscitation: Two large-bore (16-18G) IV lines, crystalloid resuscitation, restrictive blood transfusion (target Hemoglobin 7-8 g/dL).\n• High-Dose IV PPI Therapy:\n  Pantoprazole or Esomeprazole 80 mg IV bolus over 30 minutes, followed by continuous IV infusion of 8 mg/hour for 72 hours (maintains intragastric pH >6 to stabilize platelet clots and prevent fibrinolysis).\n• Urgent Upper Endoscopy: Perform within 24 hours of presentation. Dual endoscopic hemostasis (injection of Epinephrine 1:10,000 PLUS thermal coagulation or mechanical hemoclips) for high-risk stigmata (active spurting bleeding Forrest Ia, oozing Ib, non-bleeding visible vessel IIa).\n• Confirmation of Eradication (MANDATORY):\n  Perform 13C/14C Urea Breath Test or Stool Antigen Test at least 4 weeks after antibiotic completion and at least 2 weeks after stopping PPI.",
            guidelines = "ACG Clinical Guideline: Treatment of H. pylori Infection 2024 Update, Maastricht VI Consensus Report & Harrison's 21st Edition.",
            keyDrugs = listOf("Pantoprazole", "Esomeprazole", "Amoxicillin + Potassium Clavulanate", "Metronidazole", "Ciprofloxacin"),
            supportiveCare = "Complete cessation of NSAIDs, aspirin, and non-prescribed OTC analgesics. Smoking and alcohol cessation (both delay ulcer healing and increase perforation risk). Paracetamol preferred for mild musculoskeletal pain.",
            redFlags = "Perforated ulcer: Sudden onset severe generalized peritonitis ('board-like' rigid abdomen, free air under diaphragm on erect CXR). Hemodynamic collapse from massive upper GI bleeding (hematochezia, hypotension, syncope, tachycardia). Gastric outlet obstruction (projectile non-bilious vomiting, succussion splash).",
            references = listOf(
                "UpToDate: Treatment regimens for Helicobacter pylori (2024)",
                "Medscape: Peptic Ulcer Disease Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 317",
                "ACG Clinical Guideline: Treatment of Helicobacter pylori Infection (2024)",
                "Maastricht VI/Florence Consensus Report on Management of Helicobacter pylori"
            )
        ),
        DiseaseProtocol(
            id = "dp14",
            name = "Acute Infectious Diarrhea, Cholera & Severe Dehydration",
            category = "Gastrointestinal & Infectious",
            icd10 = "A09 / A00.9",
            diagnosticCriteria = "Acute passage of ≥3 loose or liquid stools per day lasting <14 days. Cholera: Sudden onset of painless, profuse, watery diarrhea with classic 'rice-water' appearance, vomiting, and rapid dehydration leading to hypovolemic shock within hours. Assessment of dehydration using WHO classification: No dehydration, Some dehydration, Severe dehydration.",
            firstLine = "WHO Rehydration Strategy (The Cornerstone of Therapy):\n• Mild-to-Moderate Dehydration (WHO Plan B):\n  WHO Reduced-Osmolarity Oral Rehydration Salts (ORS): 75 mL/kg administered orally over 4 hours. Ongoing losses: 10-20 mL/kg (or 1 cup ORS) for each loose stool.\n• Zinc Supplementation (MANDATORY IN PEDIATRICS):\n  Elemental Zinc 20 mg PO once daily for 14 days (10 mg/day for infants <6 months) - regenerates intestinal mucosal brush border, reduces duration by 25%, and prevents recurrent episodes for 3 months.",
            secondLine = "Severe Dehydration / Hypovolemic Shock (WHO Plan C - IV Resuscitation):\n• Immediate IV infusion of Ringer's Lactate (or Normal Saline if LR unavailable):\n  Total Volume: 100 mL/kg divided into two phases:\n  • Adults & Children ≥1 year:\n    Phase 1: 30 mL/kg rapid IV over 30 minutes.\n    Phase 2: 70 mL/kg IV over 2.5 hours.\n  • Infants <1 year:\n    Phase 1: 30 mL/kg IV over 1 hour.\n    Phase 2: 70 mL/kg IV over 5 hours.\n• Reassess pulse, skin turgor, and mental status continuously; offer ORS as soon as patient can drink.",
            inpatient = "Antimicrobial Therapy (Indicated for Severe Cholera, Dysentery with Bloody Stools, Sepsis, or Immunocompromise):\n• Severe Cholera:\n  1. Doxycycline: 300 mg PO single dose (first-line in adults) OR\n  2. Azithromycin: 1000 mg (20 mg/kg) PO single dose (preferred in children and pregnancy) OR\n  3. Ciprofloxacin: 1000 mg PO single dose.\n• Shigella / Invasive Dysentery (Bloody Mucoid Stools + High Fever):\n  Azithromycin 500 mg PO once daily for 3 days OR Ciprofloxacin 500 mg PO BID for 3 days.\n• Anti-Motility Warning (CRITICAL):\n  Loperamide and Diphenoxylate are STRICTLY CONTRAINDICATED in bloody diarrhea, inflammatory dysentery, or suspected C. difficile (risk of toxic megacolon and prolonged mucosal invasion).",
            guidelines = "WHO Guidelines for the Treatment of Diarrhoea, CDC & Harrison's Principles of Internal Medicine 21st Edition.",
            keyDrugs = listOf("Azithromycin", "Ciprofloxacin", "Doxycycline", "Metronidazole"),
            supportiveCare = "Continue feeding and frequent breastfeeding throughout illness (starvation diets cause gut mucosal atrophy). Boiled drinking water, hand hygiene with soap, proper sanitation. Clean water and food safety counseling.",
            redFlags = "Severe dehydration signs: Lethargy or unconsciousness, sunken eyes, inability to drink or drinking poorly, skin pinch returns very slowly (>2 seconds), absent radial pulse, anuria, severe muscle cramps (hypokalemia), acidotic deep breathing.",
            references = listOf(
                "UpToDate: Approach to the adult with acute diarrhea in resource-rich and resource-limited settings (2024)",
                "Medscape: Acute Diarrhea Clinical Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 132",
                "WHO The Treatment of Diarrhoea: A manual for physicians and other senior health workers",
                "CDC Guidelines for the Management of Acute Diarrhea"
            )
        ),
        DiseaseProtocol(
            id = "dp15",
            name = "Enteric (Typhoid & Paratyphoid) Fever",
            category = "Infectious Diseases",
            icd10 = "A01.0",
            diagnosticCriteria = "Step-ladder remittent fever persisting >3-5 days, headache, malaise, abdominal pain, relative bradycardia (Faget's sign: pulse rate slower than expected for degree of fever), hepatosplenomegaly, coated tongue, faint salmon-colored maculopapular 'rose spots' on trunk. Definitive diagnosis by Blood Culture (positive in 60-80% during first week) or Bone Marrow Culture (90% sensitive).",
            firstLine = "Empiric Antimicrobial Therapy (Tailored for Regions with Multidrug-Resistant / Fluoroquinolone-Resistant Salmonella enterica serovars Typhi & Paratyphi):\n• Inpatient / Severe:\n  Ceftriaxone 2 g IV once daily (pediatric 75-100 mg/kg/day IV divided q12-24h) for 10 to 14 days OR\n• Outpatient / Mild-to-Moderate:\n  Azithromycin 1000 mg PO on Day 1, then 500 mg PO once daily (pediatric 20 mg/kg/day, max 1000 mg/day) for 7 to 10 days (Azithromycin achieves high intracellular biliary and macrophage concentrations).",
            secondLine = "Documented Fluoroquinolone-Susceptible Strains (Low-Resistance Areas):\n• Ciprofloxacin 500 mg PO BID for 10-14 days OR Ofloxacin 400 mg PO BID for 10-14 days.\n\nExtensively Drug-Resistant (XDR) Typhoid (Resistant to Chloramphenicol, Ampicillin, TMP-SMX, Fluoroquinolones, and 3rd Generation Cephalosporins):\n• Meropenem 1 g IV q8h for 10-14 days PLUS Azithromycin 1000 mg PO daily.",
            inpatient = "Severe Typhoid Fever with Neuropsychiatric Complications / Delirium:\n• Typhoid Encephalopathy (Delirium, stupor, coma, shock):\n  High-Dose Corticosteroid Adjunct: Dexamethasone 3 mg/kg IV initial loading dose infused over 30 minutes, followed by 1 mg/kg IV every 6 hours for 8 doses (total 48 hours). (Significantly reduces mortality from 55% to 10% in severe typhoid encephalopathy).\n• Intestinal Perforation Surveillance: Most common during week 3 of illness; marked by sudden acute abdominal pain, tachycardia, and board-like rigidity. Requires emergent laparotomy, primary repair/resection, and broad-spectrum anaerobic antibiotic coverage (Metronidazole 500 mg IV q8h).",
            guidelines = "WHO Guidelines on Typhoid Fever 2023, CDC Yellow Book & Harrison's Principles of Internal Medicine 21st Edition.",
            keyDrugs = listOf("Ceftriaxone", "Azithromycin", "Ciprofloxacin", "Dexamethasone", "Metronidazole"),
            supportiveCare = "High-calorie bland soft diet, adequate IV and oral fluid hydration. Antipyretic: Paracetamol 500-1000 mg PO q6h PRN (avoid NSAIDs to prevent intestinal bleeding). Stool cultures post-treatment to detect chronic asymptomatic gallbladder carriers.",
            redFlags = "Sudden drop in temperature with acute hypotension and tachycardia (sign of occult intestinal hemorrhage or perforation), peritonitis, delirium, obtundation, shock, melena.",
            references = listOf(
                "UpToDate: Treatment and prevention of enteric (typhoid and paratyphoid) fever (2024)",
                "Medscape: Typhoid Fever Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 162",
                "WHO Guidelines on the Management of Typhoid Fever",
                "CDC Typhoid and Paratyphoid Fever Guidance"
            )
        ),
        DiseaseProtocol(
            id = "dp16",
            name = "Pulmonary & Extrapulmonary Tuberculosis (TB)",
            category = "Infectious Diseases & Pulmonary",
            icd10 = "A15.0",
            diagnosticCriteria = "Chronic cough lasting >2 weeks, hemoptysis, low-grade evening fevers, night sweats, anorexia, weight loss. Microbiological confirmation via Sputum GeneXpert MTB/RIF (rapid molecular detection of M. tuberculosis and rifampicin resistance within 2 hours), sputum acid-fast bacilli (AFB) smear microscopy, and mycobacterial culture (LJ or MGIT). Chest X-ray showing upper lobe infiltrates or cavitation.",
            firstLine = "Standard 6-Month First-Line Regimen for Drug-Susceptible TB (2HRZE / 4HR):\n• Intensive Phase (First 2 Months - 4 Drugs Daily):\n  Daily Fixed-Dose Combination (FDC) tablets based on patient body weight containing:\n  1. Isoniazid (H): 5 mg/kg (typical adult 300 mg/day)\n  2. Rifampicin (R): 10 mg/kg (typical adult 600 mg/day)\n  3. Pyrazinamide (Z): 25 mg/kg (typical adult 1500-2000 mg/day)\n  4. Ethambutol (E): 15 mg/kg (typical adult 1200-1600 mg/day).\n• Continuation Phase (Next 4 Months - 2 Drugs Daily):\n  Daily 2 drugs: Isoniazid (H) + Rifampicin (R) for 4 months (total 6 months of treatment).",
            secondLine = "Essential Nutritional & Neuropathy Prophylaxis Adjunct:\n• Pyridoxine (Vitamin B6): 20 to 50 mg PO once daily co-administered with Isoniazid to prevent peripheral neuropathy (MANDATORY in pregnancy, malnutrition, diabetes, chronic kidney disease, alcoholism, and HIV infection).\n\nAdjunctive Corticosteroid Therapy (MANDATORY FOR SPECIFIC EXTRAPULMONARY SITES):\n• TB Meningitis: Dexamethasone 0.4 mg/kg/day IV tapered over 6-8 weeks (significantly reduces mortality and neurological sequelae).\n• TB Pericarditis: Oral Prednisolone 60 mg/day tapered over 6 weeks (reduces constrictive pericarditis).",
            inpatient = "Multidrug-Resistant TB (MDR-TB / RR-TB) - WHO 6-Month BPaLM Regimen:\n• If GeneXpert detects Rifampicin resistance, initiate the WHO 6-Month All-Oral BPaLM Regimen:\n  1. Bedaquiline: 400 mg PO daily for 2 weeks, then 200 mg 3 times weekly for 24 weeks\n  2. Pretomanid: 200 mg PO once daily for 26 weeks\n  3. Linezolid: 600 mg PO once daily for 16-26 weeks\n  4. Moxifloxacin: 400 mg PO once daily for 26 weeks.\n• Monitoring Schedule: Baseline and monthly LFTs (AST/ALT, Bilirubin), Serum Creatinine, visual acuity and color vision testing (Ethambutol optic neuritis), and baseline audiometry.",
            guidelines = "WHO Consolidated Guidelines on Tuberculosis: Module 4 Treatment 2024, National Tuberculosis Protocols & Harrison's 21st Edition.",
            keyDrugs = listOf("Isoniazid", "Rifampicin", "Pyrazinamide", "Ethambutol", "Pyridoxine (Vitamin B6)"),
            supportiveCare = "Directly Observed Therapy (DOTS) to ensure 100% adherence and prevent drug resistance. Nutritional support (high protein/calorie diet). Infection control: well-ventilated rooms, surgical masks for patients during initial 2 weeks of intensive phase.",
            redFlags = "Drug-induced liver injury (DILI): Stop HRZE immediately if ALT/AST >5x upper limit of normal or >3x ULN with jaundice/nausea. Severe skin rash (DRESS syndrome). Sudden loss of green-red color perception (Ethambutol optic neuritis).",
            references = listOf(
                "UpToDate: Treatment of drug-susceptible pulmonary tuberculosis in nonpregnant adults without HIV infection (2024)",
                "Medscape: Tuberculosis Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 173",
                "WHO Consolidated Guidelines on Tuberculosis: Module 4 Treatment (2024 Update)",
                "CDC Guidelines for the Treatment of Tuberculosis"
            )
        ),
        DiseaseProtocol(
            id = "dp17",
            name = "Snake Envenomation (Viper, Cobra & Krait Bites)",
            category = "Emergency Toxicology & Critical Care",
            icd10 = "T63.0X1A",
            diagnosticCriteria = "History of snakebite with physical fang puncture marks. Hemotoxic Envenomation (Russell's Viper, Saw-scaled Viper, Green Pit Viper): Local pain, progressive swelling, blistering, systemic spontaneous bleeding (gingival, hematuria, hemoptysis, venipuncture oozing), and coagulopathy confirmed by 20-Minute Whole Blood Clotting Test (20WBCT: unclotted blood at 20 min = positive). Neurotoxic Envenomation (Common Krait, Indian Cobra): Bilateral ptosis, diplopia, ophthalmoplegia, facial weakness, dysarthria, dysphagia, pooling of saliva, descending flaccid paralysis, diaphragmatic paralysis.",
            firstLine = "Immediate First Aid & Pre-Hospital Protocol:\n• Reassure patient (calm slows lymphatic venom dissemination). Immobilize bitten limb with a broad splint/bandage at heart level. Remove all rings, bracelets, and tight clothing before edema develops.\n• STRICTLY FORBIDDEN PRACTICES (Harmful & Ineffective):\n  DO NOT apply arterial tourniquets (causes limb ischemia and massive gangrene).\n  DO NOT cut, excise, suck, or apply suction devices to bite wound.\n  DO NOT apply chemicals, potassium permanganate, or electric shock.\n• Rapid Transport: Transfer immediately to nearest hospital equipped with Anti-Snake Venom (ASV) and ventilator support.",
            secondLine = "Definitive Antivenom Administration - Polyvalent Anti-Snake Venom (ASV):\n• Absolute Indications for ASV:\n  1. Systemic envenomation: Incoagulable blood on 20WBCT, spontaneous bleeding, neurotoxicity (ptosis, paralysis), shock, acute kidney injury.\n  2. Severe local envenomation: Swelling involving >half bitten limb within 48h, or rapid extension across a major joint.\n• Initial ASV Dose: 10 Vials (100 mL) reconstituted in 500 mL Normal Saline infused IV over 1 hour (first 10-15 min slow at 1-2 mL/min to monitor for anaphylaxis).\n• Bedside Preparedness (MANDATORY BEFORE ASV):\n  Epinephrine (1:1000) 0.5 mL IM, Chlorpheniramine 10 mg IV, and Hydrocortisone 100 mg IV drawn up at bedside.\n• Repeat ASV Dosing in Hemotoxic Bites: Perform repeat 20WBCT at 6 hours post-ASV; if blood remains incoagulable, administer additional 5 to 10 vials ASV.",
            inpatient = "Neurotoxic Envenomation & Respiratory Paralysis:\n• Neostigmine 'Tensilon-like' Trial (Reversible post-synaptic curare-like cobra toxin):\n  Administer Atropine 0.6 mg IV (prevents muscarinic side effects) followed immediately by Neostigmine 0.5 to 2.0 mg IM/IV. Assess ptosis and single-breath count after 30 minutes. If dramatic improvement, continue Neostigmine 0.5 mg + Atropine q30min-2h.\n• Mechanical Ventilation (CRITICAL FOR KRAIT BITES):\n  Common Krait alpha/beta-bungarotoxins cause irreversible pre-synaptic nerve terminal destruction that is NOT reversed by antivenom or neostigmine. Immediate endotracheal intubation and mechanical ventilation for 48 to 96 hours until spontaneous synaptic regeneration occurs.\n• Acute Kidney Injury (Viper Bites): Monitor hourly urine output; manage acute tubular necrosis / cortical necrosis with hemodialysis if oliguric.",
            guidelines = "WHO Guidelines for the Management of Snakebites in South-East Asia (2nd Ed), National Snakebite Protocols & Harrison's 21st Edition.",
            keyDrugs = listOf("Polyvalent Anti-Snake Venom (ASV)", "Atropine Sulfate", "Neostigmine", "Epinephrine (Adrenaline)", "Hydrocortisone"),
            supportiveCare = "Strict limb elevation once antivenom started. Tetanus toxoid booster. Broad-spectrum antibiotics (Amoxicillin-Clavulanate) ONLY if gross wound contamination or local necrosis.",
            redFlags = "Sudden difficulty swallowing secretions, inability to count past 10 in a single breath, paradoxical abdominal breathing (imminent respiratory arrest), persistent anuria (<0.5 mL/kg/hr for 6 hours), severe hypotension/shock.",
            references = listOf(
                "UpToDate: Snake envenomation in the developing world (2024)",
                "Medscape: Snake Envenomation Clinical Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 447",
                "WHO Guidelines for the Management of Snakebites in South-East Asia (2nd Edition)",
                "Nepal National Protocol for Snakebite Management"
            )
        ),
        DiseaseProtocol(
            id = "dp18",
            name = "Sepsis & Septic Shock (Surviving Sepsis Campaign)",
            category = "Emergency & Critical Care",
            icd10 = "A41.9 / R65.21",
            diagnosticCriteria = "Sepsis: Life-threatening organ dysfunction caused by a dysregulated host response to infection (identified by an acute increase in SOFA score ≥2 points; bedside qSOFA: RR ≥22/min, altered mental status, SBP ≤100 mmHg). Septic Shock: Sepsis with persisting hypotension requiring vasopressors to maintain MAP ≥65 mmHg AND serum lactate >2 mmol/L (18 mg/dL) despite adequate volume resuscitation.",
            firstLine = "Surviving Sepsis Campaign 1-Hour Bundle (EXECUTE WITHIN 60 MINUTES):\n1. Measure Blood Lactate immediately; remeasure within 2-4 hours if initial lactate >2 mmol/L.\n2. Obtain Blood Cultures (at least 2 sets: aerobic and anaerobic) PRIOR to initiating antimicrobials (do not delay antibiotics >45 min if cultures difficult).\n3. Administer Broad-Spectrum Empiric IV Antimicrobials within 1 hour of sepsis recognition:\n   • Piperacillin-Tazobactam 4.5 g IV q6h OR Meropenem 1 g IV q8h PLUS\n   • Vancomycin 15-20 mg/kg IV q8-12h (if MRSA risk) OR Cefepime 2 g IV q8h.\n4. Rapid IV Fluid Resuscitation:\n   Administer 30 mL/kg of IV balanced crystalloids (Ringer's Lactate preferred over Normal Saline) within the first 3 hours for hypotension or lactate ≥4 mmol/L.",
            secondLine = "Vasopressor Therapy for Septic Shock:\n• Target Mean Arterial Pressure (MAP) ≥65 mmHg:\n  1. First-Line Vasopressor: Norepinephrine continuous IV infusion starting at 0.05-0.2 mcg/kg/min (titrate every 2-5 minutes to maintain MAP ≥65 mmHg).\n  2. Second-Line Vasopressor: Add Vasopressin 0.03 units/minute continuous fixed-dose infusion (do not titrate) to reduce norepinephrine requirement.\n  3. Inotrope for Myocardial Dysfunction: Add Epinephrine 0.05-0.3 mcg/kg/min or Dobutamine 2.5-20 mcg/kg/min if persistent hypoperfusion despite adequate volume and MAP.\n• Refractory Vasodilatory Septic Shock:\n  IV Hydrocortisone 200 mg/day (given as 50 mg IV q6h or continuous infusion) for patients requiring ongoing high-dose vasopressor therapy.",
            inpatient = "Advanced Hemodynamic & ICU Monitoring:\n• Dynamic Measures of Fluid Responsiveness: Use passive leg raise test, stroke volume variation, or pulse pressure variation rather than static central venous pressure (CVP) to avoid harmful fluid overload.\n• Arterial Line Placement: Place indwelling radial arterial line as soon as practical for continuous accurate blood pressure measurement.\n• Source Control (CRITICAL): Identify and remediate anatomical source of infection within 6 to 12 hours (abscess drainage, debridement of infected necrotic tissue, removal of infected central lines, nephrostomy for obstructed pyelonephritis).",
            guidelines = "Surviving Sepsis Campaign: International Guidelines for Management of Sepsis and Septic Shock 2021/2023 Update & Harrison's 21st Ed.",
            keyDrugs = listOf("Norepinephrine", "Piperacillin-Tazobactam", "Meropenem", "Hydrocortisone", "Vancomycin"),
            supportiveCare = "Target blood glucose 140-180 mg/dL using regular insulin infusion. Pharmacological VTE prophylaxis (Enoxaparin 40 mg SC daily). Stress ulcer prophylaxis with Pantoprazole 40 mg IV daily for patients with mechanical ventilation >48h or coagulopathy.",
            redFlags = "Serum lactate rising >4 mmol/L, refractory hypotension requiring escalating norepinephrine doses >0.5 mcg/kg/min, acute respiratory distress syndrome (PaO2/FiO2 ratio <200), acute oliguria <0.3 mL/kg/hr, disseminated intravascular coagulation (DIC).",
            references = listOf(
                "UpToDate: Evaluation and management of suspected sepsis and septic shock in adults (2024)",
                "Medscape: Sepsis Treatment Protocols and SSC Guidelines",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 304",
                "Surviving Sepsis Campaign: International Guidelines for Management of Sepsis and Septic Shock 2021"
            )
        ),
        DiseaseProtocol(
            id = "dp19",
            name = "Acute Gouty Arthritis & Chronic Hyperuricemia",
            category = "Musculoskeletal & Rheum",
            icd10 = "M10.9",
            diagnosticCriteria = "Rapid onset of excruciating joint pain, swelling, erythema, and warmth peaking within 12 to 24 hours, classically involving the first metatarsophalangeal joint ('podagra' in >50% of initial attacks), midfoot, ankle, or knee. Definitive diagnosis by arthrocentesis: identification of intracellular, needle-shaped, negatively birefringent monosodium urate (MSU) crystals under polarizing light microscopy.",
            firstLine = "Acute Flare Pharmacotherapy (Initiate immediately within 24 hours of symptom onset):\n1. Colchicine Low-Dose Regimen (Preferred if started within 36 hours):\n   • Loading Dose: 1.2 mg PO stat, followed by 0.6 mg PO 1 hour later (Total 1.8 mg on Day 1).\n   • Ongoing Dose: 0.6 mg PO once or twice daily starting 12 hours later until flare resolves.\n   (High-dose colchicine is obsolete; low-dose is equally effective with far fewer GI side effects).\n2. Nonsteroidal Anti-inflammatory Drugs (NSAIDs):\n   Naproxen 500 mg PO BID OR Indomethacin 50 mg PO TID OR Celecoxib 200 mg PO BID for 5-7 days.\n3. Oral Corticosteroids (Preferred if renal impairment, heart failure, or anticoagulation where NSAIDs/colchicine contraindicated):\n   Prednisolone 30 to 35 mg PO once daily for 5 days (no tapering required).",
            secondLine = "Long-Term Urate-Lowering Therapy (ULT):\n• Indications for ULT: ≥1 subcutaneous tophi, radiographic damage, or ≥2 gout flares per year, or first flare in CKD stage ≥3, serum urate >9 mg/dL, or urolithiasis.\n• First-Line Urate-Lowering Drug: Allopurinol (Xanthine Oxidase Inhibitor):\n  Starting Dose: 100 mg PO once daily (start lower at 50 mg in CKD stage ≥3).\n  Titration: Titrate upward every 2-4 weeks by 100 mg to achieve target Serum Urate <6.0 mg/dL (<360 mcmol/L) (or <5.0 mg/dL if tophi present). Can safely titrate above 300 mg/day with monitoring.\n• Mandatory Flare Prophylaxis During ULT Initiation:\n  Co-prescribe Low-Dose Colchicine 0.5-0.6 mg PO once daily (or low-dose Naproxen 250 mg BID) for at least 3 to 6 months to prevent paradoxical mobilization flares.",
            inpatient = "Polyarticular Severe Gout / Inpatient Flare:\n• Intra-articular Corticosteroid Injection: Triamcinolone Acetonide 20 to 40 mg (large joints: knee) or 10-20 mg (small joints) provides rapid local relief with zero systemic toxicity after septic arthritis is definitively excluded.\n• Refractory Chronic Tophaceous Gout: Febuxostat 40-80 mg PO once daily OR Pegloticase (recombinant uricase) IV infusion every 2 weeks.",
            guidelines = "2020 American College of Rheumatology (ACR) Guideline for the Management of Gout & Harrison's Principles of Internal Medicine 21st Edition.",
            keyDrugs = listOf("Colchicine", "Allopurinol", "Naproxen", "Prednisolone"),
            supportiveCare = "Ice packs applied to affected joint for 20 minutes QID. Dietary moderation: avoid high-fructose corn syrup, beer, distilled liquor, organ meats, shellfish. Weight loss, hydration (>2 L/day). Note: Continue existing allopurinol during acute flare; do NOT discontinue.",
            redFlags = "Septic arthritis must always be excluded before corticosteroid injection (synovial fluid gram stain and culture mandatory if fever, chills, or single warm joint). Allopurinol Hypersensitivity Syndrome (fever, eosinophilia, toxic epidermal necrolysis, renal/hepatic dysfunction - screen HLA-B*5801 in high-risk Han Chinese, Korean, Thai, African descent).",
            references = listOf(
                "UpToDate: Treatment of gout flares (2024)",
                "Medscape: Gout Clinical Practice Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 372",
                "2020 American College of Rheumatology (ACR) Guideline for the Management of Gout"
            )
        ),
        DiseaseProtocol(
            id = "dp20",
            name = "Congestive Heart Failure with Reduced Ejection Fraction (HFrEF)",
            category = "Cardiovascular",
            icd10 = "I50.2",
            diagnosticCriteria = "Symptoms of heart failure (dyspnea on exertion, orthopnea, paroxysmal nocturnal dyspnea, fatigue, peripheral edema) and physical signs (elevated JVP, hepatojugular reflux, third heart sound S3 gallop, pulmonary rales, displaced apical impulse), with objective transthoracic echocardiogram demonstrating Left Ventricular Ejection Fraction (LVEF) ≤40% and elevated serum NT-proBNP (>300 pg/mL) or BNP (>100 pg/mL).",
            firstLine = "Quadruple Guideline-Directed Medical Therapy (GDMT - The 4 Foundational Pillars):\n1. ARNI (Angiotensin Receptor-Neprilysin Inhibitor):\n   Sacubitril-Valsartan: Initial 24/26 mg or 49/51 mg PO BID; titrate every 2-4 weeks to target dose 97/103 mg PO BID. (Crucial: Mandatory 36-hour washout period if switching from an ACE inhibitor to prevent angioedema) OR Enalapril 2.5-10 mg BID.\n2. Evidence-Based Beta-Blocker (Initiate in clinically euvolemic patients):\n   Metoprolol Succinate ER: 25 mg PO OD (titrate to 200 mg OD) OR Carvedilol: 3.125 mg PO BID (titrate to 25-50 mg BID) OR Bisoprolol: 1.25 mg PO OD (titrate to 10 mg OD).\n3. SGLT2 Inhibitor (Reduces CV death and HF hospitalizations independent of diabetes):\n   Dapagliflozin 10 mg PO once daily OR Empagliflozin 10 mg PO once daily.\n4. Mineralocorticoid Receptor Antagonist (MRA):\n   Spironolactone: 25 mg PO once daily (titrate to 50 mg OD; monitor serum K+ and eGFR).",
            secondLine = "Decongestive Therapy & Second-Line Add-ons:\n• Loop Diuretics for Congestion / Fluid Overload:\n  Furosemide: 20 to 80 mg PO/IV once or twice daily (or Torsemide 10-20 mg PO OD) titrated to eliminate clinical congestion and maintain euvolemic 'dry weight'.\n• Resting Heart Rate ≥70 bpm in Sinus Rhythm despite target Beta-Blocker:\n  Add Ivabradine 5 mg PO BID (titrate to 7.5 mg BID).\n• Soluble Guanylate Cyclase (sGC) Stimulator: Vericiguat 2.5-10 mg PO OD for worsening HF despite GDMT.\n• African-American Patients (NYHA Class III-IV):\n  Add Hydralazine 37.5 mg + Isosorbide Dinitrate 20 mg PO TID.",
            inpatient = "Acute Decompensated Heart Failure (ADHF) / Wet-Warm Presentation:\n• High-Dose IV Loop Diuretics: Administer IV Furosemide at 2 to 2.5 times the patient's prior total oral daily dose as an IV bolus (e.g., 80-160 mg IV). Target urine output >100-150 mL/hr in first 6 hours.\n• Vasodilators for Acute Pulmonary Edema with SBP >110 mmHg:\n  IV Nitroglycerin infusion starting at 20-50 mcg/min, titrating upward by 10-20 mcg/min every 5 minutes (reduces LV preload and pulmonary capillary wedge pressure).\n• Inotropes for Cardiogenic Shock (Wet-Cold with SBP <90 mmHg and hypoperfusion):\n  Dobutamine infusion 2.5-10 mcg/kg/min or Milrinone 0.25-0.5 mcg/kg/min. Bridge to mechanical circulatory support (Impella / LVAD).",
            guidelines = "2022 AHA/ACC/HFSA & 2023 ESC Guidelines for the Management of Heart Failure & Harrison's 21st Edition.",
            keyDrugs = listOf("Telmisartan", "Metoprolol", "Dapagliflozin", "Spironolactone", "Furosemide"),
            supportiveCare = "Daily morning weight monitoring (report gain >2 kg over 3 days). Dietary sodium restriction (<2 g/day) and fluid restriction (1.5-2 L/day in severe hyponatremia). Cardiac rehabilitation exercise program. ICD/CRT-D evaluation if LVEF ≤35% despite 3 months of optimal GDMT.",
            redFlags = "Acute pulmonary edema with pink frothy sputum, cardiogenic shock (cold clammy extremities, systolic BP <85 mmHg, oliguria, confusion), worsening renal function (doubling of serum creatinine), refractory hyperkalemia (>5.5 mEq/L) requiring GDMT adjustment.",
            references = listOf(
                "UpToDate: Overview of the management of heart failure with reduced ejection fraction in adults (2024)",
                "Medscape: Heart Failure Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 252",
                "2022 AHA/ACC/HFSA Guideline for the Management of Heart Failure",
                "2023 ESC Focused Update on Heart Failure Guidelines"
            )
        ),
        DiseaseProtocol(
            id = "dp21",
            name = "Acute Otitis Media & Acute Bacterial Sinusitis",
            category = "Infectious Diseases",
            icd10 = "H66.90 / J01.90",
            diagnosticCriteria = "AOM: Moderate-to-severe bulging of tympanic membrane, acute ear pain (otalgia), erythema, and middle ear effusion. Sinusitis: Persistent purulent nasal discharge, nasal obstruction, facial pain/pressure lasting ≥10 days without clinical improvement, or acute onset of severe symptoms (fever >39°C + purulence x 3 days), or 'double sickening' (worsening after initial viral improvement).",
            firstLine = "First-Line Oral Antimicrobial Regimens:\n• Acute Bacterial Rhinosinusitis (Adults):\n  Amoxicillin-Clavulanate 875/125 mg PO BID (or 1000 mg BID) for 5 to 7 days.\n• Acute Otitis Media (Pediatrics & Adults):\n  High-Dose Amoxicillin-Clavulanate: Pediatric 90 mg/kg/day amoxicillin with 6.4 mg/kg/day clavulanate PO divided BID for 10 days (5-7 days for children ≥6 years) OR Amoxicillin 90 mg/kg/day divided BID.",
            secondLine = "Penicillin-Allergic Patients & Alternatives:\n• Adults (Sinusitis): Doxycycline 100 mg PO BID for 5-7 days OR Levofloxacin 500 mg PO OD for 5 days OR Cefpodoxime 200 mg BID.\n• Pediatrics (AOM with non-type 1 penicillin allergy): Cefdinir 14 mg/kg/day in 1 or 2 doses OR Cefuroxime Axetil 30 mg/kg/day divided BID OR Ceftriaxone 50 mg/kg IM single dose (up to 3 daily doses for severe failure).",
            inpatient = "Complicated Infection (Intracranial or Orbital Extension):\n• Orbital cellulitis, periorbital abscess, subperiosteal abscess, cavernous sinus thrombosis, mastoiditis, or meningitis:\n  Immediate hospital admission, contrast-enhanced CT of brain and paranasal sinuses/orbits, urgent ENT/Ophthalmology surgical drainage, and IV Ceftriaxone 2 g IV q12h PLUS Vancomycin 15-20 mg/kg IV q12h.",
            guidelines = "AAP Clinical Practice Guideline for Acute Otitis Media & IDSA Clinical Practice Guideline for Acute Bacterial Rhinosinusitis.",
            keyDrugs = listOf("Amoxicillin + Potassium Clavulanate", "Azithromycin", "Ceftriaxone", "Doxycycline"),
            supportiveCare = "Copious isotonic saline nasal irrigation. Oral analgesics: Paracetamol or Ibuprofen. Intranasal corticosteroid (Fluticasone 1-2 sprays each nostril daily) to reduce ostiomeatal mucosal edema. Avoid prolonged topical nasal decongestants (oxymetazoline max 3-5 days to prevent rebound rhinitis).",
            redFlags = "Periorbital swelling, proptosis, visual impairment, painful eye movements (orbital cellulitis), severe unilateral headache with cranial nerve III/IV/VI palsies (cavernous sinus thrombosis), retroauricular swelling and erythema with forward-pushed ear (acute mastoiditis).",
            references = listOf(
                "UpToDate: Acute otitis media in adults and children: Treatment (2024)",
                "Medscape: Sinusitis and Otitis Media Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 120",
                "AAP Clinical Practice Guideline: Diagnosis and Management of Acute Otitis Media",
                "IDSA Clinical Practice Guideline for Acute Bacterial Rhinosinusitis in Children and Adults"
            )
        ),
        DiseaseProtocol(
            id = "dp22",
            name = "Cellulitis, Erysipelas & Cutaneous Abscess",
            category = "Dermatology & Infectious",
            icd10 = "L03.90 / A46",
            diagnosticCriteria = "Spreading skin erythema, warmth, edema, and tenderness. Cellulitis: Involves deep dermis and subcutaneous tissue with diffuse, ill-defined borders (predominantly Beta-hemolytic Streptococcus and MSSA/MRSA). Erysipelas: Superficial cutaneous involvement with sharply demarcated, elevated borders and prominent lymphatic involvement (almost exclusively Streptococcus pyogenes). Abscess: Fluctuant tender erythematous nodule with collection of pus.",
            firstLine = "Mild Non-Purulent Cellulitis & Erysipelas (Outpatient Oral Regimen):\n• Amoxicillin-Clavulanate: 625 mg PO TID for 5 to 7 days OR\n• Cephalexin: 500 mg PO QID for 5 to 7 days OR\n• Penicillin-Allergic: Clindamycin 300 to 450 mg PO TID for 5-7 days.",
            secondLine = "Purulent Cellulitis / Suspected Community-Acquired MRSA (Risk factors: purulence, open wound, injection drug use, MRSA colonization):\n• Trimethoprim-Sulfamethoxazole (TMP-SMX): 1 to 2 Double Strength tabs (160/800 mg) PO BID for 7 to 10 days OR\n• Doxycycline: 100 mg PO BID for 7 to 10 days.\n(Note: Combine with Cephalexin 500 mg QID if concurrent streptococcal infection is suspected).",
            inpatient = "Severe / Hospitalized Cellulitis with Systemic Signs of Toxicity (SIRS/Fever):\n• Cefazolin 1 to 2 g IV q8h OR Ceftriaxone 1 to 2 g IV once daily PLUS Vancomycin 15-20 mg/kg IV q12h (if MRSA risk present).\n• Cutaneous Abscess Management (CRITICAL):\n  Incision and Drainage (I&D) is the PRIMARY definitive treatment. Antibiotics are adjunctive only if multiple lesions, extensive surrounding cellulitis, systemic signs, or immunocompromise.",
            guidelines = "IDSA Practice Guidelines for the Diagnosis and Management of Skin and Soft Tissue Infections & Harrison's 21st Edition.",
            keyDrugs = listOf("Amoxicillin + Potassium Clavulanate", "Ceftriaxone", "Doxycycline", "Azithromycin"),
            supportiveCare = "Strict elevation of the affected limb above heart level (accelerates resolution by promoting venous and lymphatic drainage). Outline erythema borders with a surgical marking pen to objectively monitor response to therapy. Treat underlying predisposing factors (tinea pedis, venous stasis, lymphedema, xerosis).",
            redFlags = "Necrotizing Fasciitis ('Flesh-Eating' Infection): Pain out of proportion to physical exam findings, rapid progression over hours, skin anesthesia, bullae with violaceous discoloration, gas in soft tissues on palpation (crepitus) or imaging. Requires IMMEDIATE emergent surgical fasciotomy and IV Piperacillin-Tazobactam + Vancomycin + Clindamycin.",
            references = listOf(
                "UpToDate: Cellulitis and erysipelas: Treatment (2024)",
                "Medscape: Skin and Soft Tissue Infections Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 126",
                "IDSA Practice Guidelines for the Diagnosis and Management of Skin and Soft Tissue Infections"
            )
        ),
        DiseaseProtocol(
            id = "dp23",
            name = "Atopic Dermatitis (Eczema) & Allergic Contact Dermatitis",
            category = "Dermatology & Allergy",
            icd10 = "L20.9",
            diagnosticCriteria = "Chronic, relapsing, intensely pruritic inflammatory skin condition characterized by erythema, papules, excoriations, oozing/crusting (acute) and lichenification with skin thickening (chronic). Classic age-specific distribution: flexural surfaces (antecubital and popliteal fossae, neck, wrists) in children and adults; facial and extensor distribution in infants. Personal or family history of atopic triad (eczema, asthma, allergic rhinitis).",
            firstLine = "Foundational Skin Barrier Repair (MANDATORY IN ALL PATIENTS):\n• Frequent and liberal application of fragrance-free, thick Emollients / Ointments (Ceramide creams, White petrolatum) at least twice daily and within 3 minutes immediately after lukewarm bathing ('soak and seal' method to trap hydration).\n\nFirst-Line Topical Corticosteroid (TCS) Therapy for Active Flares:\n• Low Potency TCS (Face, neck, intertriginous flexures, infants): Hydrocortisone 1% cream or ointment applied once or twice daily for up to 1-2 weeks.\n• Moderate to High Potency TCS (Trunk, extremities): Mometasone Furoate 0.1% cream or Betamethasone Dipropionate 0.05% cream applied once daily during flares for 1 to 2 weeks, then tapering to twice-weekly proactive maintenance on recurrent spots.",
            secondLine = "Steroid-Sparing Topical Calcineurin Inhibitors (TCI):\n• Tacrolimus 0.03% (pediatric) or 0.1% (adult) ointment OR Pimecrolimus 1% cream applied BID. Ideal for sensitive anatomical regions (face, eyelids, neck, genitalia) without causing skin atrophy, telangiectasia, or ocular hypertension.\n• Phosphodiesterase-4 (PDE-4) Inhibitor: Crisaborole 2% ointment BID.\n• Pruritus Control: Non-sedating antihistamines (Cetirizine 10 mg daily); sedating antihistamines (Hydroxyzine 25 mg at bedtime) for sleep disruption caused by nocturnal itching.",
            inpatient = "Severe / Refractory Atopic Dermatitis:\n• Targeted Biologic Therapy: Dupilumab (Anti-IL-4Ralpha monoclonal antibody): 600 mg SC loading dose (two 300 mg injections), then 300 mg SC every 2 weeks.\n• Oral Janus Kinase (JAK) Inhibitors: Upadacitinib 15-30 mg PO once daily or Abrocitinib 100-200 mg PO once daily.\n• Eczema Herpeticum (CRITICAL COMPLICATION):\n  Disseminated HSV infection superimposed on atopic skin presenting with monomorphic punched-out umbilicated vesicles and high fever. Requires urgent Oral Acyclovir 400 mg 5x/day (or IV Acyclovir 5-10 mg/kg q8h) to prevent ocular loss and systemic viremia.",
            guidelines = "American Academy of Dermatology (AAD) Guidelines for the Management of Atopic Dermatitis 2024 & Harrison's 21st Ed.",
            keyDrugs = listOf("Hydrocortisone", "Cetirizine", "Amoxicillin + Potassium Clavulanate"),
            supportiveCare = "Lukewarm 10-minute baths with non-soap synthetic detergent cleansers. Avoid harsh wool clothing, fragranced detergents, hot showers, and known contact allergens. Keep fingernails short and clean to minimize excoriation trauma.",
            redFlags = "Sudden eruption of painful punched-out crusted vesicles with high fever (Eczema herpeticum), extensive golden-crusted honey-colored lesions (secondary bacterial impetiginization requiring oral amoxicillin-clavulanate), erythroderma involving >90% of body surface area.",
            references = listOf(
                "UpToDate: Treatment of atopic dermatitis (eczema) (2024)",
                "Medscape: Atopic Dermatitis Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 58",
                "American Academy of Dermatology (AAD) Guidelines of Care for the Management of Atopic Dermatitis"
            )
        ),
        DiseaseProtocol(
            id = "dp24",
            name = "Scabies Infestation",
            category = "Dermatology & Infectious",
            icd10 = "B86",
            diagnosticCriteria = "Intense generalized nocturnal pruritus (itching out of proportion to visible rash, worsening at night under warm bedcovers). Pathognomonic short, serpiginous, elevated cutaneous burrows with a terminal tiny black dot representing Sarcoptes scabiei var. hominis mite. Characteristic predilection sites: interdigital web spaces of hands, flexor wrists, axillary folds, periumbilical area, buttocks, and male genitalia. Dermoscopy demonstrates 'delta-wing jet plane' sign.",
            firstLine = "First-Line Topical Scabicide:\n• Permethrin 5% Dermal Cream:\n  Application Technique (CRITICAL FOR CURE):\n  1. Apply thoroughly to every inch of clean, dry skin from the jawline/neck down to the soles of the feet, paying special attention to finger/toe webs, under nails, axillae, umbilicus, and groin. (In infants and elderly, include face and scalp).\n  2. Leave on for 8 to 14 hours (typically overnight), then thoroughly wash off in a shower or bath.\n  3. MANDATORY SECOND APPLICATION: Repeat the entire procedure exactly 7 to 10 days later to kill newly hatched nymphs before they become fertile adults.",
            secondLine = "First-Line Oral Scabicide (Extensive cases, nursing homes, crusted scabies, or topical treatment failure):\n• Oral Ivermectin: 200 mcg/kg single oral dose taken with food.\n• Mandatory Second Dose: A second dose of 200 mcg/kg MUST be taken 7 to 14 days after the first dose (ivermectin is not ovicidal; second dose catches newly hatched larvae).\n(Contraindicated in pregnant/lactating women and children weighing <15 kg).\n\nAlternative Topical Agents:\n• Precipitated Sulfur 5-10% in petrolatum applied nightly for 3 consecutive nights (safe in pregnancy and neonates) OR\n• Benzyl Benzoate 25% lotion.",
            inpatient = "Environmental Decontamination & Household Protocol (MANDATORY TO PREVENT RE-INFECTION):\n• SIMULTANEOUS CONTACT TREATMENT: Treat ALL household members, family, and sexual contacts simultaneously on the exact same day, even if completely asymptomatic (incubation period is 4-6 weeks in primary infection).\n• Fomite Decontamination: Machine-wash all bed linens, blankets, clothing, and towels used during the 3 days prior to treatment in hot water (≥60°C / 140°F) and dry on hot cycle for ≥30 minutes. Items that cannot be washed should be sealed in airtight plastic bags for at least 72 hours (scabies mites cannot survive off human host >48-72h).\n• Post-Scabetic Itch Management: Pruritus can persist for 2 to 4 weeks after successful mite eradication due to hypersensitivity to dead mite antigens; treat with oral Cetirizine 10 mg daily, calamine lotion, and mild topical hydrocortisone.",
            guidelines = "CDC Guidelines for the Treatment of Scabies, WHO Scabies Control Guidelines & Harrison's 21st Edition.",
            keyDrugs = listOf("Permethrin 5%", "Cetirizine", "Hydrocortisone"),
            supportiveCare = "Keep fingernails trimmed short to prevent skin breakdown from vigorous scratching. Treat secondary bacterial impetigo with oral amoxicillin-clavulanate if excoriations become infected.",
            redFlags = "Crusted (Norwegian) Scabies: Occurs in immunocompromised or elderly patients; marked by millions of mites with thick psoriasiform hyperkeratotic crusts and minimal pruritus. Highly contagious; requires combined daily topical Permethrin 5% PLUS oral Ivermectin (200 mcg/kg on Days 1, 2, 8, 9, 15).",
            references = listOf(
                "UpToDate: Scabies: Management (2024)",
                "Medscape: Scabies Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 448",
                "CDC Guidelines for the Treatment of Scabies",
                "WHO Guidelines for the Diagnosis and Management of Scabies"
            )
        ),
        DiseaseProtocol(
            id = "dp25",
            name = "Acute Migraine Headache & Status Migrainosus",
            category = "Neurology",
            icd10 = "G43.909",
            diagnosticCriteria = "Recurrent headache disorder manifesting in attacks lasting 4 to 72 hours. Typical characteristics: unilateral location, pulsating/throbbing quality, moderate or severe pain intensity, aggravation by routine physical activity, and accompanied by nausea, vomiting, photophobia, and phonophobia. Classic migraine with aura involves fully reversible visual (scintillating scotoma), sensory, or speech symptoms developing over 5-20 minutes and lasting <60 minutes prior to headache.",
            firstLine = "Acute Attack Abortive Therapy (Take immediately at first onset of headache):\n• Mild-to-Moderate Migraine Attacks:\n  1. NSAIDs: Naproxen Sodium 500-550 mg PO stat OR Ibuprofen 400-800 mg PO stat co-administered with Metoclopramide 10 mg PO (antiemetic enhances GI motility and absorption) OR\n  2. Combination Analgesic: Paracetamol 500 mg + Aspirin 500 mg + Caffeine 130 mg PO stat.\n• Moderate-to-Severe Attacks (Migraine-Specific Serotonin 5-HT1B/1D Receptor Agonists - Triptans):\n  Sumatriptan: 50 to 100 mg PO single dose at headache onset; if partial relief or recurrence, may repeat once after 2 hours (maximum 200 mg/24 hours) OR Subcutaneous injection 6 mg SC (onset 10-15 min, max 12 mg/24h) OR\n  Zolmitriptan: 2.5 to 5 mg PO single dose (max 10 mg/24h).\n  (TRIPTAN CONTRAINDICATIONS: Ischemic heart disease, prior MI, coronary vasospasm, peripheral vascular disease, prior stroke/TIA, uncontrolled hypertension).",
            secondLine = "Second-Line Specific Abortives (If triptans contraindicated or ineffective):\n• Calcitonin Gene-Related Peptide (CGRP) Receptor Antagonists ('Gepants'):\n  Rimegepant 75 mg PO ODT single dose OR Ubrogepant 50-100 mg PO stat (zero vasoconstrictor properties; safe in cardiovascular disease).\n• 5-HT1F Receptor Agonist: Lasmiditan 50-100 mg PO stat (warn of sedation, no driving for 8h).",
            inpatient = "Emergency Department / Status Migrainosus (>72 Hours Severe Continuous Pain):\n• Multimodal IV Headache Cocktail (Highly effective, avoids rebound medication overuse):\n  1. IV Crystalloids: Normal Saline 1000 mL bolus\n  2. IV NSAID: Ketorolac 30 mg IV stat\n  3. IV Antiemetic / Dopamine Antagonist: Metoclopramide 10 mg IV slow push OR Prochlorperazine 10 mg IV OR Chlorpromazine 12.5-25 mg IV (pre-treat with diphenhydramine 25 mg IV to prevent akathisia)\n  4. IV Corticosteroid: Dexamethasone 10 mg IV (prevents headache recurrence within 72 hours).\n• Long-Term Preventive Prophylaxis (Indicated if ≥4 headache days/month or severe disability):\n  Propranolol 40-80 mg PO BID OR Topiramate 25-50 mg PO BID OR Amitriptyline 25-50 mg PO at bedtime OR Monthly CGRP monoclonal antibodies (Erenumab 70-140 mg SC monthly).",
            guidelines = "American Headache Society (AHS) Consensus Statement on Migraine Treatment 2024 & Harrison's 21st Edition.",
            keyDrugs = listOf("Sumatriptan", "Naproxen", "Metoclopramide", "Propranolol", "Dexamethasone"),
            supportiveCare = "Rest in a dark, quiet room with cold forehead compresses. Identify and eliminate personal headache triggers (sleep deprivation, skipping meals, aged cheeses, nitrates, sensory overload). Limit abortive medications to <10 days/month to avoid Medication Overuse Headache (MOH).",
            redFlags = "'SNOOP' Red Flags for Secondary Headache: Sudden 'thunderclap' onset (subarachnoid hemorrhage), New onset in patient >50 years (temporal arteritis), Onset with systemic symptoms (fever, neck stiffness: meningitis), Papilledema or focal neurological deficit (intracranial mass, elevated ICP).",
            references = listOf(
                "UpToDate: Acute treatment of migraine in adults (2024)",
                "Medscape: Migraine Headache Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 427",
                "American Headache Society (AHS) Consensus Statement: The American Headache Society on Integrating New Migraine Treatments into Clinical Practice (2024 Update)"
            )
        ),
        DiseaseProtocol(
            id = "dp26",
            name = "Bacterial Meningitis (Community-Acquired)",
            category = "Neurology & Infectious",
            icd10 = "G00.9",
            diagnosticCriteria = "Classic clinical triad: Fever, nuchal rigidity (neck stiffness), and altered mental status (confusion, lethargy, coma). Accompanying signs: severe headache, photophobia, Kernig's sign (pain/resistance on knee extension with flexed hip), Brudzinski's sign (involuntary hip/knee flexion on passive neck flexion), petechial/purpuric rash (Neisseria meningitidis). Definitive diagnosis by Lumbar Puncture (LP): CSF opening pressure >200 mm H2O, turbid CSF, pleocytosis >1000/mcL with >80% neutrophils, elevated protein >100 mg/dL, and marked CSF glucose reduction (<40 mg/dL or CSF:blood glucose ratio <0.4).",
            firstLine = "EMERGENCY ANTIMICROBIAL TIMING (CRITICAL RULE):\n• DO NOT delay antibiotic administration for lumbar puncture or neuroimaging. If head CT is indicated before LP (focal neurological signs, papilledema, immunocompromised, seizure, GCS <10), obtain blood cultures immediately and administer empiric antibiotics + dexamethasone BEFORE sending patient to the CT scanner.\n\nImmediate Adjunctive Corticosteroid Therapy (MANDATORY):\n• Dexamethasone: 10 mg IV administered with or 15 to 20 minutes PRIOR to the first dose of antibiotics, continued at 10 mg IV every 6 hours for 4 days. (Dexamethasone significantly reduces sensorineural hearing loss, neurological complications, and mortality in Streptococcus pneumoniae meningitis). Discontinue after 48h if organism confirmed not S. pneumoniae or H. influenzae.",
            secondLine = "Empiric Intravenous Antimicrobial Regimen:\n• Adults Aged 18 to 50 Years (Covering Streptococcus pneumoniae & Neisseria meningitidis):\n  1. Ceftriaxone 2 g IV every 12 hours (or Cefotaxime 2 g IV q4h) PLUS\n  2. Vancomycin 15 to 20 mg/kg IV every 8 to 12 hours (maintain serum trough target 15-20 mcg/mL to overcome cephalosporin-resistant S. pneumoniae).\n• Adults Aged >50 Years or Immunocompromised (Covering Listeria monocytogenes in addition to pneumococcus/meningococcus):\n  1. Ceftriaxone 2 g IV every 12 hours PLUS\n  2. Vancomycin 15-20 mg/kg IV every 8-12 hours PLUS\n  3. Ampicillin 2 g IV every 4 hours.",
            inpatient = "ICU Management & Close Contact Chemoprophylaxis:\n• Droplet Isolation: Maintain strict respiratory droplet isolation for the first 24 hours of antimicrobial therapy for suspected Neisseria meningitidis.\n• Elevated Intracranial Pressure (ICP) Management: Elevate head of bed 30 degrees; hypertonic 3% saline (250 mL bolus) or IV Mannitol 20% (0.5-1 g/kg over 20 min) for signs of cerebral herniation.\n• Close Contact Chemoprophylaxis for Meningococcal Meningitis (Household, dorm room, or direct exposure to oral secretions):\n  1. Rifampicin 600 mg PO BID for 2 days (4 doses) OR\n  2. Ciprofloxacin 500 mg PO single dose OR\n  3. Ceftriaxone 250 mg IM single dose (preferred in pregnancy).",
            guidelines = "IDSA Practice Guidelines for Healthcare-Associated and Bacterial Meningitis & Harrison's 21st Edition.",
            keyDrugs = listOf("Ceftriaxone", "Dexamethasone", "Vancomycin", "Ampicillin", "Rifampicin"),
            supportiveCare = "Strict fluid balance avoiding both hypovolemia and excessive hypotonic fluids (risk of cerebral edema via SIADH). Continuous neurological checks with Glasgow Coma Scale.",
            redFlags = "Rapidly evolving purpuric/ecchymotic skin rash with hypotension (Waterhouse-Friderichsen syndrome: bilateral adrenal hemorrhage and fulminant meningococcemia), signs of impending uncal herniation (unilateral dilated non-reactive pupil, bradycardia with hypertension - Cushing's triad, decerebrate posturing).",
            references = listOf(
                "UpToDate: Initial therapy and prognosis of bacterial meningitis in adults (2024)",
                "Medscape: Bacterial Meningitis Clinical Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 138",
                "IDSA Practice Guidelines for Healthcare-Associated and Bacterial Meningitis"
            )
        ),
        DiseaseProtocol(
            id = "dp27",
            name = "Deep Vein Thrombosis (DVT) & Acute Pulmonary Embolism (PE)",
            category = "Cardiovascular & Hematology",
            icd10 = "I82.40 / I26.99",
            diagnosticCriteria = "DVT: Unilateral lower extremity pain, swelling, calf circumference discrepancy >3 cm, pitting edema, tenderness along deep venous system. Wells score stratification; D-dimer assay; definitive diagnosis by venous compression duplex ultrasonography demonstrating non-compressible vein segment. PE: Acute dyspnea, pleuritic chest pain, tachypnea (RR >20/min), tachycardia, cough, hemoptysis, syncope, RV strain on ECG (S1Q3T3), confirmed by Computed Tomography Pulmonary Angiography (CTPA) showing intraluminal filling defect or V/Q scan.",
            firstLine = "First-Line Oral Direct Anticoagulants (DOACs - Preferred over Vitamin K Antagonists / Warfarin):\n• Apixaban (Eliquis):\n  Initial Dose: 10 mg PO BID for the first 7 days, followed by maintenance dose of 5 mg PO BID for at least 3 to 6 months (no parenteral heparin lead-in required) OR\n• Rivaroxaban (Xarelto):\n  Initial Dose: 15 mg PO BID taken with food for 21 days, followed by 20 mg PO once daily taken with food for at least 3 to 6 months (no parenteral heparin lead-in required).",
            secondLine = "Alternative Anticoagulation Regimens (Parenteral Lead-In Strategy):\n• Low-Molecular-Weight Heparin (LMWH - Enoxaparin):\n  1 mg/kg Subcutaneously every 12 hours (or 1.5 mg/kg SC once daily) for at least 5 days, followed by transition to:\n  1. Dabigatran 150 mg PO BID (requires ≥5 days of parenteral LMWH lead-in) OR\n  2. Warfarin: Initial 5 mg PO daily overlapping with LMWH for ≥5 days until INR is therapeutic (2.0 to 3.0) on two consecutive days.\n• Cancer-Associated Thrombosis: DOACs (Apixaban/Rivaroxaban) or LMWH (Enoxaparin) preferred over Warfarin.",
            inpatient = "High-Risk / Massive Hemodynamically Unstable Pulmonary Embolism (SBP <90 mmHg or Cardiac Arrest):\n• Systemic Thrombolysis (Fibrinolytic Therapy):\n  IV Alteplase (rt-PA): 100 mg infused IV over 2 hours (or Tenecteplase weight-based bolus) accompanied by Unfractionated Heparin infusion. Rapidly restores RV function and pulmonary perfusion.\n• Catheter-Directed Thrombectomy / Embolectomy: Indicated if high-risk PE and systemic thrombolysis is contraindicated or has failed.\n• Inferior Vena Cava (IVC) Filter: Strictly reserved for acute proximal DVT/PE in patients with absolute contraindications to therapeutic anticoagulation (active massive bleeding).",
            guidelines = "CHEST Guideline and Expert Panel Report: Antithrombotic Therapy for VTE Disease 2021 & 2019 ESC Guidelines on Pulmonary Embolism.",
            keyDrugs = listOf("Apixaban", "Rivaroxaban", "Enoxaparin"),
            supportiveCare = "Graduated knee-high compression stockings (30-40 mmHg) for post-thrombotic syndrome prevention once acute pain subsides. Early ambulation is encouraged as soon as effective anticoagulation is established. Duration of therapy: 3 months for provoked VTE with transient risk factor (surgery); indefinite for unprovoked VTE or active cancer.",
            redFlags = "Hemodynamic instability with hypotension, syncope, acute RV strain (elevated troponin and NT-proBNP with RV dilation on bedside echo), major bleeding on anticoagulation requiring immediate reversal (Andexanet alfa for apixaban/rivaroxaban, Idarucizumab for dabigatran, Protamine for heparin).",
            references = listOf(
                "UpToDate: Treatment, prognosis, and follow-up of acute pulmonary embolism in adults (2024)",
                "Medscape: Venous Thromboembolism Treatment Protocols",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 279",
                "CHEST Guideline and Expert Panel Report: Antithrombotic Therapy for VTE Disease (2021 Update)",
                "2019 ESC Guidelines for the diagnosis and management of acute pulmonary embolism"
            )
        ),
        DiseaseProtocol(
            id = "dp28",
            name = "Nepal National Snakebite Envenomation Protocol",
            category = "Emergency & Toxicology",
            icd10 = "T63.0",
            diagnosticCriteria = "History of snakebite (Terai/Mid-hills of Nepal). Differentiate venomous vs non-venomous:\n• Neurotoxic Envenomation (Common Krait - Bungarus caeruleus, Cobra - Naja naja):\n  Bilateral ptosis (earliest clinical sign), diplopia, ophthalmoplegia, dysarthria, pooling of secretions (broken-wing neck), respiratory muscle paralysis.\n• Hemotoxic Envenomation (Russell's Viper - Daboia russelii, Green Pit Viper):\n  Local swelling extending >half limb within 48h, spontaneous systemic bleeding (hematuria, gum bleed, epistaxis, hematemesis), non-clotting blood on 20-minute Whole Blood Clotting Test (20WBCT).\n• 20WBCT Methodology: 2 mL venous blood in dry glass tube, undisturbed for 20 min, invert gently. Unclotted = Consumption Coagulopathy.",
            firstLine = "EMERGENCY SPECIFIC ANTIVENOM THERAPY (WHO / Ministry of Health Nepal):\n• Polyvalent Anti-Snake Venom (ASV - effective against Indian Cobra, Common Krait, Russell's Viper, Saw-scaled Viper):\n  Initial Dose: 10 Vials reconstituted in 500 mL 0.9% Normal Saline (or 10 mL/kg in children), infused IV over 1 hour.\n  Start infusion at slow rate (2 mL/min) for first 10-15 minutes with continuous observation for anaphylactoid reactions.\n• Anaphylaxis Preparedness (MANDATORY):\n  Draw up Epinephrine (Adrenaline) 1:1000 (0.5 mL IM adult, 0.01 mL/kg child) ready at bedside BEFORE starting ASV.",
            secondLine = "NEOSTIGMINE 'ATROPINE-FIRST' TEST PROTOCOL (For Neurotoxicity):\n• Indicated for Krait/Cobra neurotoxicity with respiratory compromise:\n  1. Pre-medicate with Atropine 0.6 mg IV (children 0.05 mg/kg) to prevent cholinergic bradycardia.\n  2. Administer Neostigmine 1.5 mg IV/IM (children 0.04 mg/kg).\n  3. Assess objective improvement in ptosis, neck flexion, and single breath count at 30 minutes.\n  4. If positive response: Continue Neostigmine 0.5 mg IV with Atropine every 30-60 minutes.",
            inpatient = "CRITICAL CARE & ICU ESCALATION:\n• Respiratory Paralysis: Elective endotracheal intubation and mechanical ventilation (or Ambu-bag ventilation in rural health centers) if single breath count <15 or rising pCO2.\n• Rebound Coagulopathy: Repeat 20WBCT 6 hours post-ASV. If blood remains unclotted, administer second dose of 10 vials ASV.\n• Acute Kidney Injury (AKI): High in Russell's viper envenomation. Maintain strict urine output monitoring (>0.5 mL/kg/h); initiate hemodialysis for refractory hyperkalemia, volume overload, or uremia.",
            guidelines = "Nepal National Snakebite Management Guidelines 2022 (Epidemiology and Disease Control Division - EDCD, MoHP Nepal) & WHO Guidelines for the Management of Snakebites.",
            keyDrugs = listOf("Polyvalent Anti-Snake Venom (ASV)", "Epinephrine (Adrenaline)", "Atropine Sulfate", "Neostigmine"),
            supportiveCare = "DO NOT make incisions, suck venom, apply tourniquets, or electric shocks. Immobilize bitten limb with splint at heart level. Administer Tetanus Toxoid booster. Gentle wound cleansing with normal saline.",
            redFlags = "Rapidly descending paralysis (loss of gag reflex, paradoxical breathing), sudden hypotension, gross hematuria with anuria, and severe early anaphylactic shock to ASV (urticaria, bronchospasm, shock requiring IM adrenaline, IV hydrocortisone, chlorpheniramine).",
            references = listOf(
                "National Guideline for Snakebite Management in Nepal (EDCD, MoHP Nepal 2022)",
                "WHO Guidelines for the Management of Snakebites in the South-East Asia Region",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 474",
                "BMJ: Snake envenoming in Nepal - Diagnosis and management"
            )
        ),
        DiseaseProtocol(
            id = "dp29",
            name = "Rabies Post-Exposure Prophylaxis (PEP) Protocol",
            category = "Infectious Diseases & Emergency",
            icd10 = "A82.9 / Z20.3",
            diagnosticCriteria = "Exposure to suspect or confirmed rabid animal (dog, bat, jackal, monkey) in rabies-endemic regions (Nepal). Categorized by WHO/EDCD:\n• Category I: Touching or feeding animals, licks on intact skin (NO EXPOSURE).\n• Category II: Minor scratches or abrasions without bleeding, nibbling of uncovered skin (MINOR EXPOSURE).\n• Category III: Single or multiple transdermal bites or scratches, licks on broken skin, contamination of mucous membrane with saliva from animal (SEVERE EXPOSURE).",
            firstLine = "IMMEDIATE WOUND CARE (LIFE-SAVING FIRST STEP):\n• Thoroughly flush and scrub all bite wounds and scratches with running water and soap or detergent for AT LEAST 15 MINUTES.\n• Disinfect with Povidone-Iodine 10% solution or 70% alcohol.\n• SUTURING IS STRICTLY CONTRAINDICATED. If primary closure is unavoidable, infiltrate Rabies Immunoglobulin locally first and apply loose apposition sutures after 2 hours.",
            secondLine = "VACCINE REGIMENS (CELL-CULTURE RABIES VACCINE - PCECV/PVRV):\n• Intradermal (Thai Red Cross 2-Site ID Regimen - COST-EFFECTIVE & STANDARD IN NEPAL):\n  0.1 mL injected intradermally at 2 separate sites (Left and Right deltoid) on:\n  DAY 0, DAY 3, DAY 7, and DAY 28.\n• Intramuscular (Essen 5-Dose IM Regimen):\n  1.0 mL IM in deltoid (anterolateral thigh in infants; NEVER gluteal) on:\n  DAY 0, DAY 3, DAY 7, DAY 14, and DAY 28.",
            inpatient = "RABIES IMMUNOGLOBULIN (RIG) INFILTRATION (MANDATORY FOR CATEGORY III):\n• Equine Rabies Immunoglobulin (ERIG - 300 IU/mL): Dose 40 IU/kg body weight OR\n• Human Rabies Immunoglobulin (HRIG - 150 IU/mL): Dose 20 IU/kg body weight.\n• Administration: Infiltrate as much of the calculated dose as anatomically feasible LOCALLY INTO AND AROUND ALL BITE WOUNDS. Administer any remaining volume IM at an anatomical site distant from vaccine injection (e.g. anterolateral thigh).\n• RIG can be administered up to Day 7 after the first dose of rabies vaccine.",
            guidelines = "Nepal National Rabies Prophylaxis Guidelines (EDCD, Ministry of Health and Population Nepal) & WHO Rabies Vaccines Position Paper.",
            keyDrugs = listOf("Rabies Vaccine (PCECV)", "Equine Rabies Immunoglobulin (ERIG)", "Povidone Iodine"),
            supportiveCare = "Assess animal: If domestic dog/cat is healthy and vaccinated, observe for 10 days. If animal remains healthy after 10 days, PEP may be discontinued. In Nepal, initiation of PEP must NEVER be delayed while waiting for animal observation.",
            redFlags = "Signs of furious rabies (hydrophobia, aerophobia, agitation, autonomic instability) or paralytic rabies (ascending paralysis, Guillain-Barré like). Rabies encephalitis has a 100% case fatality rate once clinical symptoms manifest; PEP must be instituted without delay.",
            references = listOf(
                "National Guideline for Rabies Post-Exposure Prophylaxis in Nepal (EDCD, MoHP)",
                "WHO Rabies Vaccines and Immunoglobulins: WHO Position Paper (2018)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 203",
                "UpToDate: Rabies post-exposure prophylaxis"
            )
        )
    )
}
