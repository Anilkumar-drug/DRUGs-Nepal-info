package com.example.data.repository

import com.example.data.model.DiseaseProtocol

object HepatologyPancreasProtocolsData {

    val protocols: List<DiseaseProtocol> = listOf(
        // 1. Chronic Hepatitis B (CHB)
        DiseaseProtocol(
            id = "hp_chb",
            name = "Chronic Hepatitis B (CHB)",
            category = "Hepatology & Pancreas",
            icd10 = "B18.1",
            diagnosticCriteria = "Persistence of HBsAg for >6 months. Evaluation includes HBeAg/anti-HBe status, serum HBV DNA (IU/mL by real-time PCR), serum ALT (upper limit of normal: 35 U/L for men, 25 U/L for women), and non-invasive liver fibrosis assessment (Transient Elastography / FibroScan LSM >8.0 kPa or APRI >1.0, FIB-4 >1.45).",
            firstLine = "POTENT NUCLEOS(T)IDE ANALOGUES WITH HIGH GENETIC BARRIER TO RESISTANCE:\n" +
                    "• Entecavir (ETV): 0.5 mg PO once daily on an empty stomach (2 hours before or after meals). Dose 1.0 mg PO once daily if decompensated cirrhosis or prior lamivudine resistance.\n" +
                    "• Tenofovir Disoproxil Fumarate (TDF): 300 mg PO once daily with food. (First-line in pregnancy and all trimesters).\n" +
                    "• Tenofovir Alafenamide (TAF): 25 mg PO once daily with food. PREFERRED over TDF in patients aged >60 years, pre-existing bone disease (osteopenia/osteoporosis), or renal impairment (eGFR 30-60 mL/min or proteinuria).",
            secondLine = "PEGylated Interferon alfa-2a (PEG-IFN):\n" +
                    "• 180 mcg SC once weekly for 48 weeks. Considered only in young patients with mild-to-moderate fibrosis, high baseline ALT (>3x ULN), low HBV DNA (<2 million IU/mL), and HBeAg-positive status who desire finite therapy.\n" +
                    "• STRICT CONTRAINDICATION: Decompensated cirrhosis, severe cytopenias, autoimmune diseases, or uncontrolled psychiatric illness.",
            inpatient = "CRITICAL MANAGEMENT & IMMUNOSUPPRESSION PROPHYLAXIS:\n" +
                    "• Prophylaxis against HBV Reactivation: Any HBsAg-positive or anti-HBc positive patient undergoing B-cell depleting therapy (Rituximab), chemotherapy, or high-dose corticosteroids (>20 mg/day prednisone equivalent for >4 weeks) MUST receive prophylactic Entecavir or TAF starting 2 weeks prior to therapy and continuing for 12-18 months post-chemotherapy.\n" +
                    "• Prevention of Mother-to-Child Transmission (PMTCT - WHO 2024 / AASLD):\n" +
                    "  Pregnant women with HBV DNA >200,000 IU/mL (or HBeAg positive if DNA unavailable): Start TDF 300 mg daily at week 24-28 of gestation until at least delivery/12 weeks postpartum. Administer Hepatitis B Vaccine + Hepatitis B Immune Globulin (HBIG 100-200 IU IM) to neonate within 12 hours of birth.",
            guidelines = "AASLD 2024 Practice Guidance on Prevention, Diagnosis, and Treatment of Chronic Hepatitis B, EASL 2023, APASL 2022 & WHO 2024 Guidelines for the Prevention, Diagnosis and Treatment of Chronic Hepatitis B.",
            keyDrugs = listOf("Tenofovir Disoproxil", "Entecavir", "Tenofovir Alafenamide"),
            supportiveCare = "Lifelong surveillance for Hepatocellular Carcinoma (HCC): Abdominal ultrasound with or without serum alpha-fetoprotein (AFP) every 6 months for all cirrhotic patients, Asian men >40y, Asian women >50y, or family history of HCC. Avoid alcohol and hepatotoxic medications. Screen and vaccinate for Hepatitis A if non-immune.",
            redFlags = "Decompensation signs (jaundice with bilirubin >3 mg/dL, ascites, encephalopathy, coagulopathy with INR >1.5), sudden acute flare with ALT >10x ULN, or new focal liver lesion on ultrasound.",
            references = listOf(
                "AASLD Practice Guidance on the Management of Chronic Hepatitis B (2024 Update)",
                "EASL Clinical Practice Guidelines on the management of hepatitis B virus infection (2023)",
                "APASL Hepatitis B Guidelines (2022)",
                "WHO Guidelines for the prevention, diagnosis and treatment of chronic hepatitis B infection (2024)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 344"
            )
        ),

        // 2. Chronic Hepatitis C (CHC)
        DiseaseProtocol(
            id = "hp_chc",
            name = "Chronic Hepatitis C (CHC)",
            category = "Hepatology & Pancreas",
            icd10 = "B18.2",
            diagnosticCriteria = "Positive anti-HCV antibody confirmed by detectable qualitative or quantitative serum HCV RNA (>15 IU/mL) or HCV core antigen. Non-invasive staging for cirrhosis (FibroScan LSM >12.5 kPa, FIB-4 >3.25, APRI >2.0). Genotyping is optional with modern pan-genotypic regimens.",
            firstLine = "PAN-GENOTYPIC DIRECT-ACTING ANTIVIRAL (DAA) REGIMENS (>98% CURE RATE / SVR12):\n" +
                    "1. Sofosbuvir (400 mg) + Velpatasvir (100 mg) (Fixed-Dose Combination):\n" +
                    "   • Non-Cirrhotic or Compensated Cirrhosis (Child-Pugh A): 1 tablet PO once daily for 12 WEEKS.\n" +
                    "   • Decompensated Cirrhosis (Child-Pugh B or C): Sofosbuvir-Velpatasvir 1 tablet daily + Weight-Based Ribavirin (1000 mg/day if <75 kg, 1200 mg/day if ≥75 kg) for 12 WEEKS (or 24 weeks without Ribavirin if ribavirin-ineligible).\n" +
                    "2. Glecaprevir (300 mg) + Pibrentasvir (120 mg):\n" +
                    "   • Non-Cirrhotic (Treatment-Naive): 3 tablets PO once daily with food for 8 WEEKS.\n" +
                    "   • Compensated Cirrhosis (Child-Pugh A): 3 tablets PO once daily with food for 12 WEEKS.",
            secondLine = "Sofosbuvir (400 mg) + Velpatasvir (100 mg) + Voxilaprevir (100 mg) (Vosevi):\n" +
                    "• 1 tablet PO once daily with food for 12 WEEKS.\n" +
                    "• Indicated for patients who failed prior NS5A inhibitor-containing DAA therapy (salvage therapy).",
            inpatient = "CRITICAL DRUG-DRUG INTERACTIONS & COMPENSATED CHECKS:\n" +
                    "• Proton Pump Inhibitors (PPIs): Velpatasvir requires gastric acidity. Avoid omeprazole doses >20 mg; take omeprazole 4 hours AFTER Sofosbuvir-Velpatasvir with food.\n" +
                    "• Amiodarone CONTRAINDICATION: Sofosbuvir co-administration causes fatal bradycardia and cardiac arrest. Strictly contraindicated.\n" +
                    "• Protease Inhibitor Warning: Glecaprevir and Voxilaprevir are STRICTLY CONTRAINDICATED in Child-Pugh B or C decompensated cirrhosis due to risk of hepatotoxicity and liver failure.",
            guidelines = "AASLD-IDSA HCV Guidance 2024, EASL Recommendations on Treatment of Hepatitis C 2023 & WHO Guidelines for the care and treatment of persons diagnosed with chronic hepatitis C.",
            keyDrugs = listOf("Sofosbuvir", "Velpatasvir", "Ribavirin"),
            supportiveCare = "Test for Sustained Virologic Response (SVR12) with quantitative HCV RNA at 12 weeks post-treatment completion (defines clinical cure). Cirrhotic patients who achieve SVR still require lifelong HCC surveillance every 6 months via ultrasound.",
            redFlags = "Severe drug interactions with statins (myopathy), carbamazepine/rifampin (loss of DAA efficacy), or decompensation onset during therapy.",
            references = listOf(
                "AASLD-IDSA HCV Guidance: Recommendations for Testing, Managing, and Treating Hepatitis C (2024)",
                "EASL Clinical Practice Guidelines: Recommendations on treatment of hepatitis C (2023)",
                "WHO Guidelines for the care and treatment of persons diagnosed with chronic hepatitis C (2024)",
                "UpToDate: Patient evaluation and treatment of chronic hepatitis C (2024)"
            )
        ),

        // 3. Portal Hypertension (Portal HTN)
        DiseaseProtocol(
            id = "hp_portal_htn",
            name = "Portal Hypertension (Portal HTN) & Baveno VII",
            category = "Hepatology & Pancreas",
            icd10 = "K76.6",
            diagnosticCriteria = "Hepatic Venous Pressure Gradient (HVPG) >5 mmHg defines portal hypertension; HVPG ≥10 mmHg defines Clinically Significant Portal Hypertension (CSPH) at risk for varices, ascites, and decompensation. Non-invasive Baveno VII criteria: Liver stiffness measurement (LSM) ≥25 kPa confirms CSPH; LSM <20 kPa and platelet count >150,000/mcL rules out CSPH (safely avoids screening endoscopy).",
            firstLine = "NON-SELECTIVE BETA-BLOCKERS (NSBB) FOR PRIMARY PROPHYLAXIS OF DECOMPENSATION:\n" +
                    "• Carvedilol (PREFERRED - Dual beta-1, beta-2, and alpha-1 adrenergic antagonist):\n" +
                    "  Initial: 3.125 mg to 6.25 mg PO once daily (or 3.125 mg BID). Titrate every 3-7 days to target of 6.25 mg to 12.5 mg PO BID (or 12.5 mg PO daily). More potent HVPG reduction than propranolol.\n" +
                    "  Target: Resting heart rate 55-60 bpm, systolic BP ≥90 mmHg.\n" +
                    "• Traditional NSBB Alternative: Propranolol 20-40 mg PO BID, titrate up to 80-160 mg BID or Nadolol 20-40 mg PO OD.",
            secondLine = "Endoscopic Variceal Ligation (EVBL):\n" +
                    "• Indicated for primary prophylaxis in patients with high-risk medium/large varices who have contraindications or intolerance to NSBBs (severe asthma, severe symptomatic bradycardia, SBP <90 mmHg).\n" +
                    "• Repeat band ligation every 2 to 4 weeks until eradication of all variceal cords.",
            inpatient = "REFRACTORY PORTAL HYPERTENSION & DECOMPENSATION ESCALATION:\n" +
                    "• Transjugular Intrahepatic Portosystemic Shunt (TIPS):\n" +
                    "  Covered PTFE stent placement between hepatic vein and intrahepatic portal vein. Indications: recurrent refractory variceal bleeding despite EVBL+NSBB, or refractory ascites.\n" +
                    "• Window Hypothesis for NSBB: In end-stage refractory ascites, SBP, or severe HRS with SBP <90 mmHg or MAP <65 mmHg, reduce dose or temporarily withhold NSBB to avoid uncoupling renal perfusion.",
            guidelines = "Baveno VII Consensus Workshop on Personalized Care in Portal Hypertension 2022 & AASLD Portal Hypertension Practice Guidance 2023.",
            keyDrugs = listOf("Carvedilol", "Propranolol", "Spironolactone"),
            supportiveCare = "Strict avoidance of NSAIDs (precipitates acute renal failure and variceal bleeding), sodium restriction (<2 g/day), abstinence from alcohol, and screening for gastroesophageal varices according to Baveno VII elastography thresholds.",
            redFlags = "Sudden drop in arterial blood pressure (MAP <65 mmHg), hematemesis, melena, lightheadedness, or acute onset of oliguria/AKI in a patient on beta-blockers.",
            references = listOf(
                "Baveno VII - Renewing consensus in portal hypertension: Report of the Baveno VII consensus workshop (2022)",
                "AASLD Practice Guidance on Portal Hypertension Bleeding in Cirrhosis (2023)",
                "EASL Clinical Practice Guidelines for the management of patients with decompensated cirrhosis (2023)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 347"
            )
        ),

        // 4. Spontaneous Bacterial Peritonitis (SBP)
        DiseaseProtocol(
            id = "hp_sbp",
            name = "Spontaneous Bacterial Peritonitis (SBP)",
            category = "Hepatology & Pancreas",
            icd10 = "K65.2",
            diagnosticCriteria = "Diagnostic paracentesis MUST be performed in ANY cirrhotic patient with ascites hospitalized emergently, or with fever, abdominal pain, encephalopathy, shock, or unexplained worsening renal/hepatic function. Positive criteria: Ascitic fluid polymorphonuclear (PMN) neutrophil count ≥250 cells/mm³ (≥0.25 × 10⁹/L), regardless of ascites culture result.",
            firstLine = "EMPIRIC INTRAVENOUS ANTIMICROBIAL THERAPY (Immediate within 1 hour):\n" +
                    "• Third-Generation Cephalosporin: Cefotaxime 2 g IV every 8 hours OR Ceftriaxone 2 g IV every 24 hours for 5 to 7 days.\n" +
                    "• Hospital-Acquired / Nosocomial SBP (or recent cephalosporin exposure): High risk of ESBL and multidrug-resistant organisms. Use Piperacillin-Tazobactam 4.5 g IV q6h OR Meropenem 1 g IV q8h (+/- Vancomycin or Daptomycin if high MRSA prevalence).\n" +
                    "\nINTRAVENOUS ALBUMIN PROTOCOL (MANDATORY TO PREVENT HEPATORENAL SYNDROME):\n" +
                    "• 1.5 g/kg IV at the time of SBP diagnosis (Day 1, within 6 hours) PLUS\n" +
                    "• 1.0 g/kg IV on Day 3.\n" +
                    "• Reduces incidence of hepatorenal syndrome from 33% to 10% and hospital mortality from 29% to 10% (Sort et al. NEJM landmark trial).",
            secondLine = "SECONDARY SBP PROPHYLAXIS (LIFELONG UNTIL TRANSPLANTATION):\n" +
                    "• Following resolution of the acute episode, recurrence rate is ~70% within 1 year without prophylaxis.\n" +
                    "• Norfloxacin 400 mg PO once daily OR Ciprofloxacin 500 mg PO once daily (or Cotrimoxazole Double Strength 1 tab daily if quinolone-intolerant).\n" +
                    "• Primary Prophylaxis Criteria: Cirrhosis with ascitic fluid total protein <1.5 g/dL AND either severe liver disease (Child-Pugh ≥9 with bilirubin ≥3 mg/dL) or renal dysfunction (serum Cr ≥1.2 mg/dL, BUN ≥25 mg/dL, or Na ≤130 mEq/L).",
            inpatient = "PARACENTESIS RESPONSE MONITORING:\n" +
                    "• Repeat diagnostic paracentesis at 48 hours is mandatory if clinical worsening or nosocomial SBP: PMN count should decrease by at least 25% from baseline. If PMNs do not decrease, consider secondary peritonitis (gut perforation: marked by multiple organisms, protein >1 g/dL, glucose <50 mg/dL, LDH >upper limit of normal).\n" +
                    "• Beta-blocker withholding: NSBBs (Propranolol, Carvedilol) should be temporarily stopped during acute SBP due to increased risk of hemodynamic instability, sepsis-induced hypotension, and hepatorenal syndrome.",
            guidelines = "AASLD Management of Adult Patients with Ascites Due to Cirrhosis & EASL Guidelines on Decompensated Cirrhosis.",
            keyDrugs = listOf("Ceftriaxone", "Cefotaxime", "Human Albumin", "Norfloxacin"),
            supportiveCare = "Strict fluid intake and output monitoring, daily weights, avoidance of aminoglycosides and NSAIDs, continuous monitoring of serum creatinine and urine output.",
            redFlags = "Rapid rise in serum creatinine (development of HRS-AKI), refractory encephalopathy, septic shock with hypotension, or lack of PMN decline at 48 hours.",
            references = listOf(
                "AASLD Practice Guidance on Diagnosis, Evaluation, and Management of Ascites, SBP, and Hepatorenal Syndrome (2023)",
                "Sort P, et al. Effect of intravenous albumin on renal impairment and mortality in patients with cirrhosis and spontaneous bacterial peritonitis. N Engl J Med. 1999;341(6):403-409",
                "EASL Clinical Practice Guidelines for the management of patients with decompensated cirrhosis (2023)",
                "UpToDate: Spontaneous bacterial peritonitis in adults: Treatment and prophylaxis (2024)"
            )
        ),

        // 5. Chronic Liver Disease & Cirrhosis Complications (CLD)
        DiseaseProtocol(
            id = "hp_cld",
            name = "Chronic Liver Disease (CLD): Ascites, HRS & Hepatic Encephalopathy",
            category = "Hepatology & Pancreas",
            icd10 = "K74.6",
            diagnosticCriteria = "End-stage chronic liver injury characterized by architectural distortion, regenerative nodules, and portal hypertension. Stratified via Child-Pugh Score (A, B, C) and MELD-Na score. Common complications: Ascites, Hepatorenal Syndrome (HRS-AKI), and Hepatic Encephalopathy (HE).",
            firstLine = "1. CIRRHOTIC ASCITES MANAGEMENT:\n" +
                    "• Dietary Sodium Restriction: Limit sodium to 2000 mg/day (88 mmol/day or <5g table salt). Fluid restriction (<1-1.5 L/day) is ONLY required if serum sodium is <125 mEq/L.\n" +
                    "• Dual Diuretic Regimen (100:40 Ratio maintains normokalemia):\n" +
                    "  Spironolactone 100 mg PO once daily in morning PLUS Furosemide 40 mg PO once daily.\n" +
                    "  Titrate every 3-5 days in 100:40 ratio to max Spironolactone 400 mg + Furosemide 160 mg daily.\n" +
                    "  Goal weight loss: 0.5 kg/day without peripheral edema; 1.0 kg/day if edema present.\n" +
                    "\n2. HEPATIC ENCEPHALOPATHY (HE):\n" +
                    "• Lactulose: 20 to 30 mL (15-30 g) orally 2 to 4 times daily, titrated to achieve 2 to 3 soft bowel movements per day. In acute crisis, administer via retention enema (300 mL lactulose in 700 mL tap water).\n" +
                    "• Rifaximin 550 mg PO BID: Add to lactulose after a single recurrence to reduce hospitalizations by 58% and prevent SBP.",
            secondLine = "REFRACTORY ASCITES & LARGE-VOLUME PARACENTESIS (LVP):\n" +
                    "• LVP with Post-Paracentesis Albumin Infusion:\n" +
                    "  Administer 20% or 25% Human Albumin at 8 grams per liter of ascites removed when >5 Liters are removed (prevents paracentesis-induced circulatory dysfunction - PICD, hyponatremia, and renal impairment).\n" +
                    "• Midodrine 5 to 10 mg PO TID or Clonidine can be added to improve systemic hemodynamics in refractory ascites.",
            inpatient = "HEPATORENAL SYNDROME - ACUTE KIDNEY INJURY (HRS-AKI) ICU PROTOCOL:\n" +
                    "• Diagnostic confirmation: Cirrhosis with ascites, acute doubling of serum Cr or Cr ≥1.5 mg/dL, no improvement after 48 hours of diuretic withdrawal and volume expansion with Albumin (1 g/kg/day, max 100 g/day), absence of shock, nephrotoxic agents, or intrinsic structural renal disease (proteinuria <500 mg/day, microhematuria <50 RBCs/hpf).\n" +
                    "• SPECIFIC PHARMACOTHERAPY (Start Immediately):\n" +
                    "  1. Intravenous Albumin: 20-40 grams IV daily continuous.\n" +
                    "  2. Terlipressin (First-Line): 1 to 2 mg IV bolus every 4 to 6 hours (or continuous IV infusion 2 to 4 mg/day). Titrate up to 12 mg/day until serum Cr decreases by ≥30% towards baseline. (CONFIRM trial: reverses HRS in ~32% vs 17% placebo).\n" +
                    "  Alternative in non-ICU/US: Norepinephrine 0.5-3 mg/hr IV infusion targeting MAP increase of ≥10 mmHg, OR Midodrine 7.5-12.5 mg PO TID + Octreotide 100-200 mcg SC TID.\n" +
                    "• Definitive Therapy: Urgent evaluation for Orthotopic Liver Transplantation.",
            guidelines = "AASLD Practice Guidance on Decompensated Cirrhosis 2023, EASL Guidelines on the Management of Hepatorenal Syndrome & Baveno VII.",
            keyDrugs = listOf("Spironolactone", "Furosemide", "Lactulose", "Rifaximin", "Human Albumin", "Terlipressin"),
            supportiveCare = "Nutritional support: High-protein diet (1.2-1.5 g/kg/day of actual weight) - NEVER protein-restrict encephalopathy patients. Frequent small meals + late evening carbohydrate snack (reduces nocturnal muscle proteolysis). Strict avoidance of benzodiazepines, sedatives, and aminoglycosides.",
            redFlags = "Oliguria with urine output <0.5 mL/kg/h, serum creatinine doubling within 48h, Grade III/IV hepatic encephalopathy (stupor/coma), profound hyponatremia (Na <120 mEq/L).",
            references = listOf(
                "AASLD Practice Guidance on Diagnosis, Evaluation, and Management of Ascites, SBP, and Hepatorenal Syndrome (2023)",
                "Wong F, et al. Terlipressin plus Albumin for the Treatment of Type 1 Hepatorenal Syndrome (CONFIRM Trial). N Engl J Med. 2021;384:818-827",
                "EASL Clinical Practice Guidelines for the management of patients with decompensated cirrhosis (2023)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 347"
            )
        ),

        // 6. Acute Esophageal Variceal Bleeding (EV Bleeding)
        DiseaseProtocol(
            id = "hp_ev_bleeding",
            name = "Acute Esophageal Variceal Bleeding (EV Bleeding)",
            category = "Hepatology & Pancreas",
            icd10 = "I85.01",
            diagnosticCriteria = "Upper GI hemorrhage (hematemesis, coffee-ground emesis, melena) in a patient with portal hypertension or cirrhosis. Confirmed on emergency upper endoscopy showing active bleeding from an esophageal/gastric varix, a 'white nipple' clot sign, or presence of large varices with blood in the stomach without another identifiable bleeding source.",
            firstLine = "EMERGENCY RESUSCITATION & MEDICAL COCKTAIL (BEFORE ENDOSCOPY):\n" +
                    "1. Hemodynamic Resuscitation & Restrictive Transfusion:\n" +
                    "   • Maintain 2 large-bore peripheral IV lines (16-18G).\n" +
                    "   • RESTRICTIVE RED CELL TRANSFUSION STRATEGY (Villanueva et al. NEJM trial): Target Hemoglobin 7.0 to 8.0 g/dL. (Liberal transfusion >9 g/dL increases portal pressure, induces rebound variceal rupture, and significantly increases mortality).\n" +
                    "2. Immediate Vasoactive Therapy (Start at first presentation before endoscopy):\n" +
                    "   • Terlipressin: 2 mg IV bolus every 4 hours for the first 48 hours, then 1 mg IV every 4 hours. Continue for a total of 3 to 5 days OR\n" +
                    "   • Octreotide: 50 mcg IV bolus, followed immediately by continuous IV infusion of 50 mcg/hour for 3 to 5 days.\n" +
                    "3. Mandatory Antibiotic Prophylaxis (Immediate):\n" +
                    "   • Ceftriaxone 1 g IV once daily for 7 days (reduces bacteremia, SBP, early rebleeding, and improves 6-week survival).",
            secondLine = "EMERGENT ENDOSCOPIC INTERVENTION (Within 12 Hours of Admission):\n" +
                    "• Endoscopic Variceal Ligation (EVBL): First-line endoscopic therapy for esophageal varices. Band ligation of all columns starting at gastroesophageal junction and working upward.\n" +
                    "• Erythromycin 250 mg IV infused 30-60 minutes prior to endoscopy to clear blood and clots from the gastric lumen and improve mucosal visualization.\n" +
                    "• Gastric Varices (GOV2 / IGV1): Endoscopic Cyanoacrylate tissue glue injection or TIPS.",
            inpatient = "REFRACTORY MASSIVE HEMORRHAGE & BALLOON TAMPONADE:\n" +
                    "• Sengstaken-Blakemore or Minnesota Tube:\n" +
                    "  Temporary bridge therapy (maximum 24 hours) for uncontrollable exsanguinating bleeding. Inflate gastric balloon with 250-300 mL air; apply 0.5-1 kg traction. Protect airway with endotracheal intubation before placement.\n" +
                    "• Early Pre-emptive TIPS (Within 24-72 hours):\n" +
                    "  Indicated for high-risk patients: Child-Pugh C (<14 points) or Child-Pugh B (>7 points) with active bleeding on endoscopy. Reduces 1-year mortality from 39% to 14%.\n" +
                    "• Secondary Prophylaxis (After Hemostasis):\n" +
                    "  Combination Therapy is MANDATORY: Serial EVBL every 2-4 weeks until variceal obliteration PLUS Carvedilol 6.25-12.5 mg/day (or Propranolol titrate to HR 55-60 bpm).",
            guidelines = "Baveno VII Consensus Workshop Guidelines 2022 & AASLD Portal Hypertension Practice Guidance 2023.",
            keyDrugs = listOf("Terlipressin", "Octreotide", "Ceftriaxone", "Carvedilol", "Propranolol"),
            supportiveCare = "Elective endotracheal intubation prior to endoscopy in patients with encephalopathy (Grade III/IV) or ongoing massive hematemesis to prevent fatal pulmonary aspiration of blood. Withhold oral intake for 48 hours post-banding.",
            redFlags = "Recurrent hematemesis post-banding, refractory hypotension despite blood products, aspiration pneumonia, or sudden onset of anuria (HRS-AKI).",
            references = listOf(
                "Baveno VII - Renewing consensus in portal hypertension (2022)",
                "Villanueva C, et al. Transfusion strategies for acute upper gastrointestinal bleeding. N Engl J Med. 2013;368:11-21",
                "AASLD Practice Guidance on Portal Hypertension Bleeding in Cirrhosis (2023)",
                "UpToDate: Methods to achieve hemostasis in patients with acute variceal hemorrhage (2024)"
            )
        ),

        // 7. Wilson Disease (Hepatolenticular Degeneration)
        DiseaseProtocol(
            id = "hp_wilson",
            name = "Wilson Disease (Hepatolenticular Degeneration)",
            category = "Hepatology & Pancreas",
            icd10 = "E83.01",
            diagnosticCriteria = "Autosomal recessive mutation in ATP7B copper transporter gene causing toxic copper accumulation in liver, brain, and cornea. Diagnostic findings: Kayser-Fleischer (KF) rings on slit-lamp exam, low serum ceruloplasmin (<20 mg/dL), 24-hour urinary copper excretion >100 mcg (>1.6 mcmol/day) in symptomatic patients (or >40 mcg in asymptomatic), and Leipzig diagnostic score ≥4.",
            firstLine = "CHELATION THERAPY (INITIAL DE-COPPERING PHASE):\n" +
                    "• D-Penicillamine:\n" +
                    "  Adult: 250 to 500 mg PO QID taken on an empty stomach (1 hour before or 2 hours after meals). Titrate up to 1000 to 1500 mg/day divided BID or TID.\n" +
                    "  Co-prescribe Pyridoxine (Vitamin B6) 25 to 50 mg PO daily (penicillamine is a pyridoxine antagonist).\n" +
                    "• Trientine Hydrochloride (Alternative chelator, preferred if penicillamine adverse effects or neurologic symptoms):\n" +
                    "  Adult: 750 to 1500 mg PO daily divided BID or TID on an empty stomach. Fewer hypersensitivity reactions and lower risk of early neurological worsening.",
            secondLine = "MAINTENANCE & ASYMPTOMATIC THERAPY (ZINC SALTS):\n" +
                    "• Zinc Acetate / Zinc Sulfate:\n" +
                    "  Adult: 50 mg of elemental zinc PO TID taken strictly on an empty stomach (at least 1 hour before or 2 hours after meals).\n" +
                    "  Mechanism: Induces intestinal epithelial metallothionein, which selectively binds dietary copper and excretes it harmlessly in feces.\n" +
                    "  Used as maintenance therapy once decopering is achieved (after 1-5 years of chelators) or as first-line in presymptomatic siblings.",
            inpatient = "ACUTE FULMINANT WILSONIAN LIVER FAILURE (CRITICAL EMERGENCY):\n" +
                    "• Classic presentation: Coombs-negative hemolytic anemia with acute jaundice, acute renal failure, disproportionately low alkaline phosphatase (ALP/Total Bilirubin ratio <4), and AST:ALT ratio >2.2.\n" +
                    "• Chelators are INEFFECTIVE in fulminant disease.\n" +
                    "• EMERGENCY ORTHOTOPIC LIVER TRANSPLANTATION is the only definitive curative therapy (Sternlieb / Revised King's score ≥11 indicates 100% mortality without transplant).\n" +
                    "• Therapeutic Plasma Exchange (TPE) or continuous renal replacement therapy (CRRT) as a critical bridge to remove circulating free copper and prevent renal tubular necrosis.",
            guidelines = "AASLD Practice Guidance on Wilson Disease 2023 & EASL Clinical Practice Guidelines: Wilson's disease 2022.",
            keyDrugs = listOf("D-Penicillamine", "Zinc Sulfate / Zinc Acetate", "Pyridoxine (Vitamin B6)"),
            supportiveCare = "Low-copper diet: Strictly avoid organ meats (liver, kidneys), shellfish (oysters, crab), mushrooms, chocolate, cocoa, and nuts during the initial de-coppering phase. Test drinking water for copper pipes. Screen all first-degree relatives with genetic testing and slit-lamp exam.",
            redFlags = "Paradoxical worsening of neurologic symptoms (tremor, dysarthria, dystonia) during the first 4 weeks of penicillamine initiation, leukopenia/thrombocytopenia from drug-induced bone marrow suppression, proteinuria/nephrotic syndrome, or Coombs-negative hemolytic crisis.",
            references = listOf(
                "AASLD Practice Guidance on Wilson Disease (2023)",
                "EASL Clinical Practice Guidelines: Wilson's disease (2022)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 418",
                "UpToDate: Treatment of Wilson disease (2024)"
            )
        ),

        // 8. Hereditary Hemochromatosis (HH)
        DiseaseProtocol(
            id = "hp_hemochromatosis",
            name = "Hereditary Hemochromatosis (HH)",
            category = "Hepatology & Pancreas",
            icd10 = "E83.110",
            diagnosticCriteria = "Autosomal recessive disorder of iron metabolism (most commonly homozygous C282Y mutation in HFE gene). Biochemical screen: Fasting Transferrin Saturation >45% and elevated Serum Ferritin (>200 ng/mL in premenopausal women, >300 ng/mL in men and postmenopausal women). Genetic testing confirms C282Y homozygosity or C282Y/H63D compound heterozygosity.",
            firstLine = "THERAPEUTIC PHLEBOTOMY (VENESECTION - GOLD STANDARD):\n" +
                    "• Induction Phase (De-ironing):\n" +
                    "  Remove 1 unit of blood (500 mL, equivalent to ~200-250 mg elemental iron) weekly or every 2 weeks.\n" +
                    "  Check hemoglobin prior to each session; withhold if Hb <11.0 g/dL.\n" +
                    "  Endpoint of Induction: Serum Ferritin reaches 50 to 100 ng/mL and transferrin saturation <50%.\n" +
                    "• Maintenance Phase (Lifelong):\n" +
                    "  Phlebotomy 1 unit every 2 to 4 months (typically 2-4 sessions per year for men, 1-2 for women) to maintain serum ferritin between 50 and 100 ng/mL.",
            secondLine = "IRON CHELATION THERAPY (For Phlebotomy-Ineligible Patients):\n" +
                    "• Indicated only when therapeutic phlebotomy is contraindicated (severe anemia, severe congestive heart failure, severe hemodynamic instability, poor venous access):\n" +
                    "  1. Deferasirox (Oral): 14 to 28 mg/kg PO once daily on an empty stomach.\n" +
                    "  2. Deferoxamine (SC/IV): 20 to 40 mg/kg/day continuous subcutaneous infusion over 8-12 hours via portable pump.",
            inpatient = "ORGAN DYSFUNCTION & ENDOCRINE COMPLICATIONS:\n" +
                    "• Bronze Diabetes: Secondary diabetes from pancreatic islet iron deposition. Treat with insulin or metformin.\n" +
                    "• Cardiac Hemochromatosis: Iron-induced cardiomyopathy (dilated or restrictive) with arrhythmias or refractory heart failure. Requires aggressive combination of phlebotomy and continuous IV deferoxamine.\n" +
                    "• Arthropathy: Symmetrical arthritis of 2nd and 3rd metacarpophalangeal (MCP) joints with chondrocalcinosis (often does not regress with phlebotomy; manage with NSAIDs or colchicine).",
            guidelines = "AASLD Practice Guidance on the Management of Hereditary Hemochromatosis 2023 & EASL Clinical Practice Guidelines: Hemochromatosis.",
            keyDrugs = listOf("Therapeutic Phlebotomy", "Deferasirox", "Deferoxamine"),
            supportiveCare = "Strict avoidance of medicinal iron, iron-fortified cereals, and Vitamin C supplements (vitamin C accelerates intestinal iron absorption and can provoke fatal cardiac arrhythmias in severe iron overload). Avoid raw or undercooked shellfish (high risk of fatal septicemia from Vibrio vulnificus and Yersinia enterocolitica, which thrive in iron-rich environments).",
            redFlags = "Serum ferritin >1000 ng/mL at diagnosis (carries high risk of established cirrhosis and requires liver biopsy or elastography; if cirrhotic, lifelong 6-monthly HCC ultrasound screening is mandatory).",
            references = listOf(
                "AASLD Practice Guidance on Hereditary Hemochromatosis (2023)",
                "EASL Clinical Practice Guidelines on Hemochromatosis (2022 Update)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 417",
                "UpToDate: Treatment of hereditary hemochromatosis (2024)"
            )
        ),

        // 9. Autoimmune Hepatitis (AIH)
        DiseaseProtocol(
            id = "hp_aih",
            name = "Autoimmune Hepatitis (AIH)",
            category = "Hepatology & Pancreas",
            icd10 = "K75.4",
            diagnosticCriteria = "Autoimmune necroinflammatory liver disease characterized by hypergammaglobulinemia (elevated IgG >1.1x ULN), positive circulating autoantibodies: Type 1 AIH (ANA, ASMA / anti-smooth muscle) or Type 2 AIH (anti-LKM1, anti-LC1), exclusion of viral hepatitis (HAV, HBV, HCV), and typical histology on liver biopsy (interface hepatitis with dense lymphoplasmacytic infiltrate, rosetting of hepatocytes, and emperipolesis).",
            firstLine = "INDUCTION OF REMISSION (COMBINATION THERAPY - AASLD 2020):\n" +
                    "• Prednisolone PLUS Azathioprine (PREFERRED to minimize steroid side effects):\n" +
                    "  Prednisolone: Initial 30 mg PO once daily for 1 week, then 20 mg daily for 1 week, then 15 mg daily for 2 weeks, then 10 mg daily maintenance.\n" +
                    "  Azathioprine (AZA): Add 50 mg PO once daily (titrate to 1 to 2 mg/kg/day after checking TPMT enzyme activity).\n" +
                    "• Prednisolone Monotherapy (Alternative if AZA contraindicated or pregnant):\n" +
                    "  Initial 60 mg PO daily, tapered by 10 mg weekly down to 20 mg, then tapered to lowest maintenance dose (10-15 mg/day) that sustains normal ALT/AST.\n" +
                    "• Budesonide 9 mg PO daily (Alternative for non-cirrhotic AIH only; 90% first-pass hepatic metabolism reduces systemic corticosteroid toxicity).",
            secondLine = "SECOND-LINE & REFRACTORY AGENTS:\n" +
                    "• Mycophenolate Mofetil (MMF):\n" +
                    "  Dose: 1000 mg PO BID. Preferred second-line therapy for patients failing azathioprine or developing azathioprine-induced pancreatitis or myelosuppression.\n" +
                    "• Calcineurin Inhibitors (Tacrolimus 1-3 mg PO BID or Cyclosporine): Reserved for severe refractory AIH.\n" +
                    "• Infliximab or Rituximab for rescue therapy in expert centers.",
            inpatient = "ACUTE SEVERE AUTOIMMUNE HEPATITIS / FULMINANT AIH:\n" +
                    "• Presenting with acute jaundice, encephalopathy, and coagulopathy (INR ≥1.5):\n" +
                    "  Administer Methylprednisolone 1 mg/kg/day IV.\n" +
                    "  STRICT 7-DAY STOPPING RULE: Re-assess at Day 7. If total bilirubin and INR do not improve within 7 days, steroids will NOT work and risk fatal fungal/bacterial sepsis. Discontinue steroids and list immediately for Emergency Liver Transplantation.",
            guidelines = "AASLD Practice Guidance on Autoimmune Hepatitis 2020 & EASL Clinical Practice Guidelines: Autoimmune hepatitis.",
            keyDrugs = listOf("Prednisolone", "Azathioprine", "Budesonide", "Mycophenolate Mofetil"),
            supportiveCare = "Biochemical remission is defined as COMPLETE NORMALIZATION of both serum transaminases (ALT and AST) AND serum IgG. Maintenance therapy must be continued for AT LEAST 2 to 3 years before any cautious withdrawal attempt. Bone protection: Calcium 1000-1200 mg daily + Vitamin D 800-1000 IU daily while on corticosteroids; baseline DEXA scan.",
            redFlags = "Steroid resistance after 2 weeks of full-dose therapy, development of severe cytopenias on azathioprine (check TPMT/NUDT15 genotype), or acute decompensation.",
            references = listOf(
                "AASLD Practice Guidance on Autoimmune Hepatitis (2020)",
                "EASL Clinical Practice Guidelines: Autoimmune hepatitis (2015/2021 Update)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 345",
                "UpToDate: Treatment of autoimmune hepatitis (2024)"
            )
        ),

        // 10. Drug-Induced Liver Injury (DILI)
        DiseaseProtocol(
            id = "hp_dili",
            name = "Drug-Induced Liver Injury (DILI) & Hy's Law",
            category = "Hepatology & Pancreas",
            icd10 = "K71.9",
            diagnosticCriteria = "Liver injury caused by prescription medications, OTC drugs, herbal/Ayurvedic preparations, or dietary supplements. Calculation of the R-value is MANDATORY at presentation:\n" +
                    "R = (ALT / ALT ULN) / (ALP / ALP ULN)\n" +
                    "• R ≥ 5.0: Hepatocellular Pattern (e.g. Paracetamol, Isoniazid, Valproate)\n" +
                    "• 2.0 < R < 5.0: Mixed Pattern (e.g. Amoxicillin-Clavulanate, Phenytoin)\n" +
                    "• R ≤ 2.0: Cholestatic Pattern (e.g. Amoxicillin-Clavulanate, Anabolic steroids, Co-trimoxazole, Chlorpromazine)\n" +
                    "HY'S LAW CRITERIA (Predicts severe DILI with ~10% mortality):\n" +
                    "1. Serum ALT or AST >3x ULN\n" +
                    "2. Serum Total Bilirubin >2x ULN (without initial cholestasis, ALP <2x ULN)\n" +
                    "3. Absence of other causes (viral hepatitis, biliary obstruction, ischemia).",
            firstLine = "IMMEDIATE CESSATION OF SUSPECTED OFFENDING AGENT:\n" +
                    "• Prompt discontinuation of the culprit drug is the single most critical intervention.\n" +
                    "• Common culprits in South Asia/Nepal: Anti-Tuberculosis therapy (Isoniazid, Rifampicin, Pyrazinamide - ATT DILI), Amoxicillin-Clavulanate, Ketoconazole, Herbal/Ayurvedic concoctions (Guggulu, Ashwagandha), and NSAIDs.\n" +
                    "• Specific Antidotes:\n" +
                    "  - Paracetamol: N-Acetylcysteine (NAC) IV 300 mg/kg over 21 hours.\n" +
                    "  - Valproic Acid Hyperammonemic Encephalopathy: L-Carnitine 50-100 mg/kg/day IV.\n" +
                    "  - Methotrexate toxicity: Leucovorin (Folinic Acid) 100 mg/m² IV.",
            secondLine = "N-ACETYLCYSTEINE (NAC) FOR NON-ACETAMINOPHEN INDUCED ACUTE LIVER INJURY:\n" +
                    "• Early-stage non-paracetamol DILI with impending acute liver failure (INR >1.5 and encephalopathy): IV NAC (150 mg/kg loading, 50 mg/kg over 4h, 100 mg/kg over 16h) improves transplant-free survival (Lee et al. Gastroenterology trial).\n" +
                    "• Systemic Corticosteroids: Reserved for DILI with prominent systemic hypersensitivity / DRESS syndrome (fever, rash, eosinophilia) or drug-induced autoimmune hepatitis-like phenotype (e.g. Minocycline, Nitrofurantoin, Infliximab, Checkpoint Inhibitors). Prednisolone 40-60 mg/day tapered over 4-8 weeks.\n" +
                    "• Cholestatic Pruritus: Ursodeoxycholic Acid (UDCA) 13-15 mg/kg/day + Cholestyramine 4 g PO BID.",
            inpatient = "ACUTE LIVER FAILURE & TRANSPLANT TRIAGE:\n" +
                    "• King's College Criteria for Non-Paracetamol Induced Acute Liver Failure:\n" +
                    "  INR >6.5 (PT >100s) regardless of encephalopathy OR any 3 of the following 5 variables:\n" +
                    "  1. Age <10 or >40 years\n" +
                    "  2. Etiology: idiosyncratic drug reaction or seronegative hepatitis\n" +
                    "  3. Jaundice to encephalopathy interval >7 days\n" +
                    "  4. INR >3.5 (PT >50s)\n" +
                    "  5. Serum Bilirubin >17.5 mg/dL (300 mcmol/L).\n" +
                    "• Presence of criteria indicates >80% mortality without emergency liver transplantation.",
            guidelines = "ACG Clinical Practice Guideline: Drug-Induced Liver Injury 2021 & EASL Clinical Practice Guidelines: Drug-induced liver injury 2019.",
            keyDrugs = listOf("N-Acetylcysteine (NAC)", "Ursodeoxycholic Acid", "Prednisolone"),
            supportiveCare = "Strict avoidance of rechallenge with the implicated medication (rechallenge can be rapidly fatal). Monitor liver biochemistries twice weekly until definite downward trajectory established. Supportive intensive care: correct hypoglycemia, monitor brain edema, avoid sedatives.",
            redFlags = "Hy's Law fulfillment, coagulopathy (INR >1.5), altered sensorium or flapping tremors (asterixis), metabolic acidosis (lactate >3.0 mmol/L), or rapidly shrinking liver span on examination.",
            references = listOf(
                "ACG Clinical Practice Guideline: Drug-Induced Liver Injury (Am J Gastroenterol 2021;116:878-898)",
                "EASL Clinical Practice Guidelines: Drug-induced liver injury (J Hepatol 2019;70:1222-1261)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 342",
                "LiverTox: Clinical and Research Information on Drug-Induced Liver Injury (NIH Database)"
            )
        ),

        // 11. Acute Alcoholic Hepatitis (AAH)
        DiseaseProtocol(
            id = "hp_aah",
            name = "Acute Alcoholic Hepatitis (AAH) & Maddrey's DF",
            category = "Hepatology & Pancreas",
            icd10 = "K70.1",
            diagnosticCriteria = "Rapid development or worsening of jaundice (Total Bilirubin >3.0 mg/dL) in a patient with ongoing heavy alcohol consumption (>40-60 g/day for women, >60-80 g/day for men) for >6 months, with less than 60 days of abstinence before onset. Characteristic lab profile: AST:ALT ratio >2.0 (with AST typically >50 U/L but <400 U/L; ALT usually <200 U/L), leukocytosis with neutrophil predominance, elevated INR.\n" +
                    "MADDREY'S DISCRIMINANT FUNCTION (DF):\n" +
                    "DF = 4.6 × [Patient PT (sec) - Control PT (sec)] + Serum Total Bilirubin (mg/dL)\n" +
                    "• Severe AAH defined as Maddrey's DF ≥ 32 OR MELD score > 20 (carries 30-day mortality of 30-50% without treatment).",
            firstLine = "CORTICOSTEROID THERAPY (FOR SEVERE AAH: DF ≥32):\n" +
                    "• Prednisolone: 40 mg PO once daily (or IV Methylprednisolone 32 mg/day if unable to swallow) for 28 CONSECUTIVE DAYS.\n" +
                    "• MANDATORY PRE-STEROID SCREENING: Exclude active infection (CXR, blood cultures, diagnostic paracentesis to rule out SBP), active gastrointestinal bleeding, and severe renal failure.\n" +
                    "\nLILLE MODEL RESPONSE ASSESSMENT AT DAY 7 (MANDATORY STOPPING RULE):\n" +
                    "• Calculate Lille Score at Day 7 using age, baseline renal function, albumin, PT, and Day 0 vs Day 7 bilirubin.\n" +
                    "• Lille Score < 0.45: RESPONDER -> Complete full 28-day course of Prednisolone, then taper over 2 to 4 weeks (e.g. 20 mg/day for 1 wk, 10 mg/day for 1 wk, then stop).\n" +
                    "• Lille Score ≥ 0.45: NON-RESPONDER -> STOP PREDNISOLONE IMMEDIATELY. Continuing steroids in non-responders provides zero survival benefit and drastically increases fatal fungal and bacterial infections.",
            secondLine = "NUTRITIONAL THERAPY (UNIVERSAL CORNERSTONE OF THERAPY):\n" +
                    "• Severe protein-calorie malnutrition is present in nearly 100% of AAH patients and directly correlates with mortality.\n" +
                    "• Nutritional Goal: Caloric intake of 35 to 40 kcal/kg/day and Protein intake of 1.2 to 1.5 g/kg/day.\n" +
                    "• Enteral tube feeding (nasogastric) if voluntary oral intake is inadequate.\n" +
                    "• Pentoxifylline 400 mg PO TID (historical alternative; STOPAH trial showed no mortality benefit; used only if corticosteroids strictly contraindicated).",
            inpatient = "CRITICAL INFECTION SURVEILLANCE & ICU ESCALATION:\n" +
                    "• Infection is the leading cause of death in AAH. Low threshold for empiric broad-spectrum antibiotics if fever, worsening encephalopathy, or rising WBC count.\n" +
                    "• Thiamine (Vitamin B1): 100 to 500 mg IV TID for at least 3-5 days before any carbohydrate or dextrose administration to prevent irreversible Wernicke-Korsakoff encephalopathy.\n" +
                    "• Early Liver Transplantation: Highly selected severe AAH non-responders with first presentation, strong social support, and strict commitment to abstinence may be candidates for early liver transplantation in specialized centers.",
            guidelines = "AASLD Practice Guidance on Alcohol-Associated Liver Disease 2020 & EASL Clinical Practice Guidelines: Management of alcohol-related liver disease 2018.",
            keyDrugs = listOf("Prednisolone", "Thiamine (Vitamin B1)", "Human Albumin"),
            supportiveCare = "Lifelong alcohol abstinence is the single most important predictor of long-term survival. Co-manage with addiction medicine (Baclofen 5-10 mg TID is safe in liver disease for craving reduction). Multivitamin supplementation (Folic acid 5 mg daily, Zinc 50 mg daily).",
            redFlags = "Lille score ≥0.45 on Day 7, acute onset of severe sepsis / septic shock, acute kidney injury / HRS, Grade III/IV hepatic encephalopathy, or pulmonary infiltrates.",
            references = listOf(
                "AASLD Practice Guidance on Alcohol-Associated Liver Disease (Hepatology 2020;71:306-333)",
                "Mathurin P, et al. Corticosteroids improve short-term survival in patients with severe alcoholic hepatitis: individual data analysis of the last three randomized placebo-controlled trials. Gut 2011;60:255-260",
                "EASL Clinical Practice Guidelines: Management of alcohol-related liver disease (J Hepatol 2018;69:154-181)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 346"
            )
        ),

        // 12. Treatment of Acute Pancreatitis
        DiseaseProtocol(
            id = "hp_acute_pancreatitis",
            name = "Acute Pancreatitis (Atlanta & IAP/APA)",
            category = "Hepatology & Pancreas",
            icd10 = "K85.9",
            diagnosticCriteria = "Diagnosis requires AT LEAST 2 of the following 3 criteria (Revised Atlanta Classification):\n" +
                    "1. Severe epigastric abdominal pain radiating to the back\n" +
                    "2. Serum amylase or lipase ≥ 3x upper limit of normal (Lipase is more sensitive and specific, remains elevated longer)\n" +
                    "3. Characteristic imaging findings on contrast-enhanced CT (CECT), MRI, or transabdominal ultrasound.\n" +
                    "Severity Stratification: Mild (no organ failure, no local/systemic complications); Moderately Severe (transient organ failure <48h or local complications); Severe (persistent organ failure >48h involving respiratory, cardiovascular, or renal systems).",
            firstLine = "GOAL-DIRECTED FLUID RESUSCITATION & PAIN MANAGEMENT:\n" +
                    "• Fluid of Choice: LACTATED RINGER'S (RL) SOLUTION is superior to 0.9% Normal Saline (RL reduces systemic inflammation / SIRS and avoids hyperchloremic metabolic acidosis).\n" +
                    "• Rate: 5 to 10 mL/kg/hour (200-500 mL/hr) for the first 12-24 hours. (WATERFALL trial: Avoid aggressive hypervolemic fluid loading >10 mL/kg/h which causes pulmonary edema and abdominal compartment syndrome).\n" +
                    "• Resuscitation Endpoints: Heart rate <120 bpm, MAP 65-85 mmHg, urine output >0.5-1.0 mL/kg/hour, hematocrit 35-44%, and declining BUN.\n" +
                    "• Analgesia: Intravenous Opioids (Fentanyl 25-50 mcg IV or Hydromorphone 0.5-1 mg IV or Buprenorphine). Adequate pain control reduces sympathetic drive and splanchnic vasoconstriction.",
            secondLine = "EARLY ENTERAL NUTRITION (REPLACES PROLONGED NPO):\n" +
                    "• Mild Pancreatitis: Initiate oral feeding with low-fat solid or liquid diet as soon as abdominal pain is improving and ileus has resolved (NPO is no longer recommended).\n" +
                    "• Severe Pancreatitis: Early enteral tube feeding (nasogastric or nasojejunal) initiated within 24 to 72 hours. Enteral feeding maintains the gut mucosal barrier, prevents bacterial translocation, and significantly reduces infectious complications and mortality compared to total parenteral nutrition (TPN).\n" +
                    "\nANTIBIOTIC STEWARDSHIP (CRITICAL EVIDENCE-BASED RULE):\n" +
                    "• PROPHYLACTIC ANTIBIOTICS ARE NOT RECOMMENDED in acute pancreatitis, regardless of severity or presence of sterile necrosis.\n" +
                    "• Antibiotics are indicated ONLY for confirmed infected pancreatic necrosis (gas in collection on CT, or positive FNA) or extrapancreatic infections (cholangitis, bacteremia, pneumonia, UTI). Regimen: Meropenem 1 g IV q8h or Ciprofloxacin 400 mg IV q12h + Metronidazole 500 mg IV q8h.",
            inpatient = "BILIARY PANCREATITIS & STEP-UP INTERVENTION:\n" +
                    "• Urgent ERCP (Within 24 Hours): Indicated ONLY in patients with acute biliary pancreatitis who have concurrent acute cholangitis (fever, jaundice, sepsis) or persistent biliary obstruction.\n" +
                    "• Step-Up Approach for Infected Pancreatic Necrosis:\n" +
                    "  Delay intervention for at least 4 weeks if possible to allow collection to become 'walled-off' (WOPN).\n" +
                    "  Step 1: Percutaneous catheter drainage (PCD) or endoscopic transmural drainage.\n" +
                    "  Step 2: Video-Assisted Retroperitoneal Debridement (VARD) or endoscopic necrosectomy only if drainage fails.\n" +
                    "• Cholecystectomy: Same-admission cholecystectomy for mild gallstone pancreatitis prior to hospital discharge prevents recurrent life-threatening attacks.",
            guidelines = "American College of Gastroenterology (ACG) Guidelines: Management of Acute Pancreatitis 2024 & IAP/APA Evidence-Based Guidelines.",
            keyDrugs = listOf("Ringer's Lactate (RL)", "Fentanyl", "Meropenem", "Pantoprazole"),
            supportiveCare = "Continuous pulse oximetry, strict hourly urine output, monitoring for hypocalcemia (Chvostek/Trousseau signs), and blood glucose control. Discontinue potential drug causes (azathioprine, thiazides, valproate, GLP-1 agonists).",
            redFlags = "Persistent SIRS score ≥2 at 48 hours (Temp >38°C, HR >90, RR >20, WBC >12,000), hemoconcentration with hematocrit >44%, rising BUN >20 mg/dL, or PaO2 <60 mmHg (ARDS).",
            references = listOf(
                "Tenner S, et al. American College of Gastroenterology Guidelines: Management of Acute Pancreatitis. Am J Gastroenterol. 2024;119:419-437",
                "de-Madaria E, et al. Aggressive or Moderate Fluid Resuscitation in Acute Pancreatitis (WATERFALL Trial). N Engl J Med. 2022;387:989-1000",
                "IAP/APA evidence-based guidelines for the management of acute pancreatitis. Pancreatology 2013;13:e1-e15",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 348"
            )
        ),

        // 13. Chronic Pancreatitis & PERT
        DiseaseProtocol(
            id = "hp_chronic_pancreatitis",
            name = "Chronic Pancreatitis & PERT Protocol",
            category = "Hepatology & Pancreas",
            icd10 = "K86.1",
            diagnosticCriteria = "Chronic, irreversible fibro-inflammatory disease leading to destruction of pancreatic parenchyma, ductal strictures, intraductal calculi, and progressive loss of exocrine and endocrine function. Hallmark triad: Epigastric abdominal pain, Steatorrhea (foul-smelling, bulky, floating stools), and Pancreatogenic Diabetes (Type 3c). Diagnosis: Low Fecal Elastase-1 (<200 mcg/g stool confirms exocrine insufficiency; <100 mcg/g indicates severe), and ductal calcifications on CT, MRCP, or EUS.",
            firstLine = "PANCREATIC ENZYME REPLACEMENT THERAPY (PERT - CREON / PANCREATIN):\n" +
                    "• Formulation: Enteric-coated microtablets/microspheres (protects lipase from gastric acid degradation until duodenum pH >5.5).\n" +
                    "• Dosing Guidelines (HaPanEU & ACG):\n" +
                    "  - Main Meals: 40,000 to 50,000 USP/Ph.Eur. units of Lipase taken WITH every main meal (breakfast, lunch, dinner).\n" +
                    "  - Snacks: 20,000 to 25,000 units of Lipase with in-between snacks.\n" +
                    "  - Administration: Swallow capsules whole during the meal (halfway through food ingestion). Do NOT crush or chew.\n" +
                    "• Adjuvant PPI Therapy: Add Pantoprazole 40 mg PO once daily before breakfast if incomplete response (suppresses gastric acid to optimize duodenal enzyme release).",
            secondLine = "STEPWISE ANALGESIC PROTOCOL (WHO PAIN LADDER):\n" +
                    "• Step 1: Paracetamol 1000 mg PO TID + Tramadol 50 mg PO BID.\n" +
                    "• Step 2: Neuropathic agents: Pregabalin 75 mg PO BID (or Gabapentin 300 mg TID) - significantly reduces central sensitization in chronic visceral pain.\n" +
                    "• Antioxidants: Co-administration of Vitamin C, Vitamin E, Selenium, and Methionine can reduce oxidative stress and pain.\n" +
                    "• Celiac Plexus Block: EUS-guided celiac plexus neurolysis/block for refractory severe intractable pain (short-to-medium term relief for 3-6 months).",
            inpatient = "ENDOSCOPIC & SURGICAL INTERVENTION:\n" +
                    "• Extracorporeal Shock Wave Lithotripsy (ESWL) + Endoscopy: Fragment and extract obstructing main pancreatic duct calculi (≥5 mm) in the pancreatic head + pancreatic duct stenting.\n" +
                    "• Surgical Decompression (Frey Procedure or Puestow / Lateral Pancreaticojejunostomy):\n" +
                    "  Indicated for dilated main pancreatic duct (≥5 mm) with refractory pain. Offers superior long-term pain relief compared to repeated endoscopic stenting.\n" +
                    "• Management of Pancreatogenic Diabetes (Type 3c DM):\n" +
                    "  Characterized by loss of both Insulin (beta cells) AND Glucagon (alpha cells). High risk of severe hypoglycemia. Metformin is first-line; if insulin needed, use low physiological doses with frequent glucose monitoring.",
            guidelines = "ACG Clinical Guideline: Chronic Pancreatitis 2020 & United European Gastroenterology (HaPanEU) Guidelines.",
            keyDrugs = listOf("Pancreatin (Creon)", "Pantoprazole", "Pregabalin", "Vitamin ADEK"),
            supportiveCare = "Absolute cessation of alcohol and tobacco (smoking accelerates disease progression and increases pancreatic cancer risk by 10-fold). Fat-soluble vitamin supplementation (Vitamins A, D, E, K); monitor 25-OH Vitamin D and bone mineral density (high osteomalacia/osteoporosis risk). Small, frequent meals rich in MCT fats.",
            redFlags = "Rapid unexpected weight loss, worsening constant back pain, new-onset obstructive jaundice, or new onset of diabetes in patient >50y (rule out Pancreatic Ductal Adenocarcinoma).",
            references = listOf(
                "Gardner TB, et al. ACG Clinical Guideline: Chronic Pancreatitis. Am J Gastroenterol. 2020;115:322-339",
                "HaPanEU: United European Gastroenterology evidence-based guidelines for the diagnosis and therapy of chronic pancreatitis. United European Gastroenterol J. 2017;5:153-199",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 349",
                "UpToDate: Treatment of chronic pancreatitis (2024)"
            )
        ),

        // 14. Primary Biliary Cholangitis (PBC)
        DiseaseProtocol(
            id = "hp_pbc",
            name = "Primary Biliary Cholangitis (PBC)",
            category = "Hepatology & Pancreas",
            icd10 = "K74.3",
            diagnosticCriteria = "Chronic cholestatic autoimmune liver disease affecting interlobular bile ducts (predominantly females aged 40-60). Diagnosis established if AT LEAST 2 of the following 3 criteria are met:\n" +
                    "1. Biochemical evidence of cholestasis with alkaline phosphatase (ALP) ≥ 1.5x ULN\n" +
                    "2. Presence of Anti-Mitochondrial Antibodies (AMA titer ≥ 1:40) or specific ANA (anti-sp100, anti-gp210)\n" +
                    "3. Histopathological evidence of chronic nonsuppurative destructive cholangitis on liver biopsy (florid duct lesion).",
            firstLine = "URSODEOXYCHOLIC ACID (UDCA - LIFELONG FIRST-LINE):\n" +
                    "• Exact Weight-Based Dose: 13 to 15 mg/kg/day PO (administered once daily at bedtime or divided BID with meals).\n" +
                    "• Mechanism: Replaces toxic hydrophobic bile acids with hydrophilic UDCA, stimulates hepatobiliary secretion, and inhibits cholangiocyte apoptosis.\n" +
                    "• Efficacy: Delays histological progression, prevents portal hypertension, prolongs transplant-free survival, and normalizes life expectancy when initiated early.\n" +
                    "• Assess Response at 12 Months: Evaluate treatment response using Paris II or Toronto criteria (ALP <1.67x ULN with normal bilirubin).",
            secondLine = "SECOND-LINE ADJUVANT THERAPY (FOR INADEQUATE RESPONSE OR INTOLERANCE):\n" +
                    "• Obeticholic Acid (OCA - Farnesoid X Receptor Agonist):\n" +
                    "  Initial: 5 mg PO once daily. Titrate to 10 mg daily at 6 months if tolerated and ALP remains elevated.\n" +
                    "  CRITICAL BLACK BOX WARNING: CONTRAINDICATED in decompensated cirrhosis (Child-Pugh B or C) due to risk of fatal hepatic decompensation.\n" +
                    "• Bezafibrate (PPAR Agonist - 400 mg PO daily) OR Fenofibrate (145-200 mg PO daily):\n" +
                    "  Potent reduction in ALP, total bilirubin, and dramatic relief of refractory pruritus (BEZURSO trial).",
            inpatient = "PRURITUS MANAGEMENT & BONE METABOLISM:\n" +
                    "• Stepwise Pruritus Ladder:\n" +
                    "  1. Cholestyramine: 4 g PO taken 20 minutes before meals (separate from UDCA by at least 4 hours to avoid binding).\n" +
                    "  2. Rifampicin: 150 mg PO daily, titrate to 300 mg BID (monitor LFTs for hepatotoxicity).\n" +
                    "  3. Naltrexone: 25 to 50 mg PO daily (opiate antagonist).\n" +
                    "  4. Sertraline: 50 to 100 mg PO daily.\n" +
                    "• Osteoporosis Prevention: Calcium 1200 mg + Vitamin D3 1000 IU daily; Bisphosphonates (Alendronate 70 mg weekly) if T-score <-2.5.",
            guidelines = "AASLD Practice Guidance: Primary Biliary Cholangitis 2022 & EASL Clinical Practice Guidelines: The diagnosis and management of patients with primary biliary cholangitis 2023.",
            keyDrugs = listOf("Ursodeoxycholic Acid (UDCA)", "Cholestyramine", "Bezafibrate", "Rifampicin"),
            supportiveCare = "Lifelong UDCA therapy even if LFTs normalize completely. Annual ultrasound and AFP for HCC if advanced fibrosis or cirrhosis. Screen for concurrent autoimmune disorders (Hashimoto thyroiditis, Sjogren syndrome, Celiac disease).",
            redFlags = "Rising total bilirubin (>2.0 mg/dL while on UDCA is the strongest single predictor of liver failure), onset of ascites, variceal bleeding, or severe unremitting pruritus refractory to medical therapy.",
            references = listOf(
                "Lindor KD, et al. Primary Biliary Cholangitis: 2021 Practice Guidance Update from the AASLD. Hepatology 2022;75:1012-1033",
                "EASL Clinical Practice Guidelines: The diagnosis and management of patients with primary biliary cholangitis (J Hepatol 2023)",
                "Corpechot C, et al. A Placebo-Controlled Trial of Bezafibrate in Primary Biliary Cholangitis (BEZURSO). N Engl J Med. 2018;378:2171-2181",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 345"
            )
        ),

        // 15. Primary Sclerosing Cholangitis (PSC)
        DiseaseProtocol(
            id = "hp_psc",
            name = "Primary Sclerosing Cholangitis (PSC)",
            category = "Hepatology & Pancreas",
            icd10 = "K83.01",
            diagnosticCriteria = "Chronic, progressive cholestatic syndrome characterized by obliterative fibrosis and stricturing of intrahepatic and extrahepatic bile ducts. Strongly associated with Inflammatory Bowel Disease (Ulcerative Colitis in 70-80%).\n" +
                    "Diagnostic Standard: Magnetic Resonance Cholangiopancreatography (MRCP) demonstrating multifocal annular strictures and saccular dilations ('beads-on-a-string' appearance). Liver biopsy is only required if small-duct PSC is suspected (normal MRCP with high ALP) or overlap syndrome with AIH.",
            firstLine = "MEDICAL & CHOLESTATIC MANAGEMENT:\n" +
                    "• Ursodeoxycholic Acid (UDCA):\n" +
                    "  Moderate Dose: 13 to 15 mg/kg/day PO. Improves serum liver biochemistries (ALP, GGT) and pruritus.\n" +
                    "  CRITICAL CONTRAINDICATION (AASLD & EASL): HIGH-DOSE UDCA (28-30 mg/kg/day) is HARMFUL and STRICTLY CONTRAINDICATED (associated with higher rates of death, liver transplantation, and varices in randomized clinical trials).\n" +
                    "• Pruritus Treatment: Cholestyramine 4 g PO BID-QID (separated from other drugs), Rifampicin 150-300 mg daily, Naltrexone.",
            secondLine = "ENDOSCOPIC MANAGEMENT OF DOMINANT STRICTURES:\n" +
                    "• Dominant Stricture Definition: Stenosis <1.5 mm in common bile duct or <1.0 mm in hepatic ducts, presenting with worsening jaundice, cholangitis, or rapid ALP elevation.\n" +
                    "• Endoscopic Retrograde Cholangiopancreatography (ERCP):\n" +
                    "  1. Balloon dilatation of the stricture (preferred over permanent stenting to avoid stent occlusion and bacterial cholangitis).\n" +
                    "  2. Mandatory brush cytology and fluorescence in situ hybridization (FISH) to exclude Cholangiocarcinoma (CCA).",
            inpatient = "ANNUAL CANCER SURVEILLANCE PROTOCOLS (LIFE-SAVING):\n" +
                    "• Cholangiocarcinoma (CCA) Surveillance:\n" +
                    "  Annual MRCP with contrast PLUS serum CA 19-9 every 6 to 12 months. (PSC carries a 400-fold increased risk of CCA, lifetime risk 10-20%).\n" +
                    "• Colorectal Cancer (CRC) Surveillance in IBD-PSC:\n" +
                    "  MANDATORY Annual Colonoscopy with high-definition chromoendoscopy and random biopsies starting from the time of PSC diagnosis, regardless of IBD activity or age.\n" +
                    "• Gallbladder Cancer Surveillance: Annual ultrasound; cholecystectomy recommended for any gallbladder polyp >8 mm or growing.\n" +
                    "• Definitive Therapy: Orthotopic Liver Transplantation for end-stage cirrhosis, recurrent bacterial cholangitis, or early-stage CCA under strict transplant protocols.",
            guidelines = "AASLD Practice Guidance on Primary Sclerosing Cholangitis 2023 & EASL Clinical Practice Guidelines on sclerosing cholangiopathies.",
            keyDrugs = listOf("Ursodeoxycholic Acid (UDCA)", "Ciprofloxacin", "Ceftriaxone", "Cholestyramine"),
            supportiveCare = "Bacterial Cholangitis Treatment: Prompt broad-spectrum antibiotics (Ciprofloxacin 500 mg BID PO or Ceftriaxone 2 g IV) at first onset of fever/rigors. Fat-soluble vitamin supplementation (A, D, E, K); routine DEXA scans for metabolic bone disease.",
            redFlags = "Sudden onset of jaundice with rapid rise in CA 19-9 (>100 U/mL), recurrent acute bacterial cholangitis, rapid unremitting weight loss, or high-grade dysplasia on surveillance colonoscopy.",
            references = listOf(
                "Bowlus CL, et al. AASLD Practice Guidance on Primary Sclerosing Cholangitis and Cholangiocarcinoma. Hepatology 2023;77:659-702",
                "EASL Clinical Practice Guidelines on sclerosing cholangiopathies (J Hepatol 2022)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 345",
                "UpToDate: Primary sclerosing cholangitis in adults: Management (2024)"
            )
        ),

        // 16. Pancreatic Pseudocyst
        DiseaseProtocol(
            id = "hp_pancreatic_pseudocyst",
            name = "Pancreatic Pseudocyst Management",
            category = "Hepatology & Pancreas",
            icd10 = "K86.3",
            diagnosticCriteria = "Well-circumscribed, round or oval peripancreatic fluid collection enclosed by a fibrous, non-epithelial wall of granulation tissue, developing >4 WEEKS after the onset of acute interstitial edematous pancreatitis, chronic pancreatitis, or pancreatic trauma. Confirmed on contrast-enhanced CT or MRI showing homogenous low-attenuation fluid without solid debris (differentiates from Walled-Off Pancreatic Necrosis - WOPN).",
            firstLine = "CONSERVATIVE OBSERVATION (FOR ASYMPTOMATIC PSEUDOCYSTS):\n" +
                    "• Size < 6 cm, Asymptomatic, No ductal obstruction:\n" +
                    "  Strict clinical observation and repeat cross-sectional imaging (CT or MRI) in 6 to 12 weeks.\n" +
                    "  Spontaneous resolution occurs in up to 50% of acute pseudocysts without invasive intervention.\n" +
                    "• Routine prophylactic antibiotics or aspiration are NOT indicated for sterile asymptomatic cysts.",
            secondLine = "ENDOSCOPIC TRANSMURAL DRAINAGE (TREATMENT OF CHOICE):\n" +
                    "• Indications for Intervention:\n" +
                    "  1. Persistent abdominal pain or gastric outlet obstruction (nausea, vomiting)\n" +
                    "  2. Biliary compression causing obstructive jaundice\n" +
                    "  3. Infection / Pancreatic abscess (fever, leukocytosis, gas bubbles within cyst)\n" +
                    "  4. Rapid cyst enlargement (>6 cm) causing compression of major portal/splenic vessels.\n" +
                    "• Endoscopic Ultrasound (EUS)-Guided Cystogastrostomy / Cystoduodenostomy:\n" +
                    "  Preferred approach over surgery or percutaneous drainage (ESGE & ACG).\n" +
                    "  Deployment of Lumen-Apposing Metal Stents (LAMS) or multiple double-pigtail plastic stents under EUS guidance creates a direct internal fistulous tract into the stomach/duodenum.",
            inpatient = "PERCUTANEOUS & SURGICAL ESCALATION:\n" +
                    "• Percutaneous Catheter Drainage (PCD):\n" +
                    "  Reserved for infected pseudocysts in critically ill, hemodynamically unstable patients who cannot tolerate endoscopy or anesthesia. Caveat: Risk of chronic external pancreaticocutaneous fistula if the pancreatic duct communicates with the cyst.\n" +
                    "• Surgical Drainage (Cystogastrostomy, Roux-en-Y Cystojejunostomy):\n" +
                    "  Indicated when endoscopic drainage is anatomically infeasible, suspicion of cystic neoplasm, or concurrent chronic pancreatitis requiring ductal drainage (Frey/Puestow).\n" +
                    "• COMPLICATION MANAGEMENT:\n" +
                    "  - Pseudoaneurysm Rupture: Splenic or gastroduodenal artery pseudoaneurysm can rupture into the cyst causing massive gastrointestinal hemorrhage. Immediate emergency transcatheter arterial embolization (TAE) by interventional radiology.",
            guidelines = "American College of Gastroenterology (ACG) Pancreatic Pseudocyst Guidelines & European Society of Gastrointestinal Endoscopy (ESGE) Guideline.",
            keyDrugs = listOf("Pantoprazole", "Ciprofloxacin", "Metronidazole"),
            supportiveCare = "PPI therapy (Pantoprazole 40 mg IV/PO daily) to suppress gastric secretions and optimize internal cystogastrostomy tract healing. Discontinue oral intake during acute gastric outlet obstruction with enteral nutrition beyond the obstruction.",
            redFlags = "Sudden drop in hemoglobin/hematocrit with abdominal distension (suggests pseudoaneurysm rupture into cyst), fever and purulent fluid, or acute peritoneal signs indicating free rupture into the peritoneal cavity.",
            references = listOf(
                "Arvanitakis M, et al. Endoscopic management of acute necrotizing pancreatitis: European Society of Gastrointestinal Endoscopy (ESGE) evidence-based multidisciplinary guidelines. Endoscopy 2018;50:524-546",
                "ACG Guidelines for the Management of Pancreatitis (2024 Update)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 348",
                "UpToDate: Approach to the patient with a pancreatic cystic lesion (2024)"
            )
        ),

        // 17. Pancreatic Cancer (Pancreatic Ductal Adenocarcinoma - PDAC)
        DiseaseProtocol(
            id = "hp_pancreatic_cancer",
            name = "Pancreatic Cancer (PDAC): Surgical & Chemotherapy Protocol",
            category = "Hepatology & Pancreas",
            icd10 = "C25.9",
            diagnosticCriteria = "Pancreatic Ductal Adenocarcinoma (PDAC). Clinical presentation: Painless obstructive jaundice (head of pancreas), unexplained weight loss, deep epigastric pain radiating to back, new-onset diabetes in patient >50 years, or migratory superficial thrombophlebitis (Trousseau sign). Diagnostic staging protocol:\n" +
                    "1. Dual-phase Pancreatic Protocol Multi-detector CT (MDCT) with IV contrast\n" +
                    "2. Serum CA 19-9 tumor marker (baseline and therapeutic monitoring)\n" +
                    "3. EUS with Fine-Needle Biopsy (FNB) for definitive histological confirmation\n" +
                    "4. Anatomical Staging: Resectable, Borderline Resectable (venous involvement without arterial encasement), Locally Advanced Unresectable, or Metastatic.",
            firstLine = "SURGICAL RESECTION & ADJUVANT CHEMOTHERAPY (CURATIVE INTENT):\n" +
                    "• Surgical Resection (Only Potential Cure - ~15-20% of patients at diagnosis):\n" +
                    "  - Head / Uncinate Process Lesions: Pancreaticoduodenectomy (Whipple Procedure) with regional lymphadenectomy.\n" +
                    "  - Body / Tail Lesions: Distal Pancreatectomy with Splenectomy.\n" +
                    "• Adjuvant Chemotherapy (MANDATORY Post-Resection for 6 Months - NCCN / ASCO):\n" +
                    "  1. Modified FOLFIRINOX (mFOLFIRINOX - GOLD STANDARD in fit patients ECOG 0-1):\n" +
                    "     Oxaliplatin 85 mg/m² IV + Leucovorin 400 mg/m² IV + Irinotecan 150 mg/m² IV + 5-Fluorouracil (5-FU) 2400 mg/m² continuous IV infusion over 46 hours, repeated every 14 days for 12 cycles. (PRODIGE 24 trial: Median overall survival 54.4 months vs 35 months with gemcitabine).\n" +
                    "  2. Gemcitabine + Capecitabine (Alternative if borderline fitness/elderly):\n" +
                    "     Gemcitabine 1000 mg/m² IV Days 1, 8, 15 q28 days + Capecitabine 1660 mg/m²/day PO for 6 months (ESPAC-4 trial).",
            secondLine = "NEOADJUVANT & METASTATIC FIRST-LINE CHEMOTHERAPY:\n" +
                    "• Borderline Resectable & Locally Advanced Disease:\n" +
                    "  Neoadjuvant mFOLFIRINOX or Gemcitabine + Nab-paclitaxel for 4-6 cycles, followed by restaging CT to downstage and achieve R0 resection.\n" +
                    "• Metastatic First-Line Regimens:\n" +
                    "  1. mFOLFIRINOX every 2 weeks (preferred for ECOG PS 0-1) OR\n" +
                    "  2. Gemcitabine (1000 mg/m² IV) + Nab-Paclitaxel (125 mg/m² IV) on Days 1, 8, 15 every 28 days.\n" +
                    "• BRCA1/2 or PALB2 Mutation Positive: Maintenance Olaparib (PARP inhibitor 300 mg PO BID) post-platinum.",
            inpatient = "PALLIATIVE CARE & ENDOSCOPIC BILIARY DECOMPRESSION:\n" +
                    "• Malignant Biliary Obstruction:\n" +
                    "  Endoscopic retrograde placement of Self-Expanding Metal Stents (SEMS) is preferred over plastic stents (longer patency, lower re-intervention rate).\n" +
                    "• Duodenal / Gastric Outlet Obstruction:\n" +
                    "  Endoscopic duodenal self-expanding metal stent (SEMS) or laparoscopic gastrojejunostomy.\n" +
                    "• Intractable Cancer Pain: EUS-guided Celiac Plexus Neurolysis (CPN) with absolute alcohol or CT-guided splanchnicectomy reduces opioid consumption and constipation.\n" +
                    "• Exocrine Insufficiency: Universal PERT (Creon 50,000 units with meals) to prevent profound weight loss and malabsorption cachexia.",
            guidelines = "NCCN Clinical Practice Guidelines in Oncology: Pancreatic Adenocarcinoma (Version 2.2024) & ASCO Clinical Practice Guideline on Metastatic Pancreatic Cancer.",
            keyDrugs = listOf("Pancreatin (Creon)", "Gemcitabine", "Capecitabine", "Folfirinox Regimen"),
            supportiveCare = "Early palliative care integration alongside active oncologic therapy. Prophylaxis against thromboembolism: Low Molecular Weight Heparin (Enoxaparin) or DOACs for cancer-associated thrombosis (pancreatic cancer has the highest VTE rate among solid tumors). Aggressive nutritional support.",
            redFlags = "Cholangitis from biliary stent occlusion (fever, rigors, worsening jaundice), acute pulmonary embolism, massive upper GI bleeding from tumor erosion into duodenum, or acute bowel obstruction.",
            references = listOf(
                "NCCN Clinical Practice Guidelines in Oncology: Pancreatic Adenocarcinoma (Version 2.2024)",
                "Conroy T, et al. Unselected FOLFIRINOX for Pancreatic Cancer (PRODIGE 24/CCTG PA.6). N Engl J Med. 2018;379:2395-2404",
                "Neoptolemos JP, et al. Comparison of adjuvant gemcitabine and capecitabine with gemcitabine monotherapy in patients with resected pancreatic cancer (ESPAC-4). Lancet. 2017;389:1011-1024",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 80"
            )
        )
    )
}
