package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug
import com.example.data.model.DrugInteraction
import com.example.data.model.InteractionSeverity

object AdditionalDrugsData {

    val additionalDrugs: List<Drug> = listOf(
        Drug(
            id = "d31",
            genericName = "Piperacillin + Tazobactam",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Antipseudomonal Penicillin + Beta-Lactamase Inhibitor",
            blackBoxWarning = null,
            indications = "Hospital-acquired pneumonia (HAP/VAP), intra-abdominal sepsis, complicated skin and soft tissue infections, neutropenic fever, pseudomonal bacteremia.",
            doses = "Adult: 4.5 g (4g/0.5g) IV q6h (or 3.375 g IV q6h). Extended infusion: 3.375 g IV over 4 hours q8h.\nPeds (>2 mos): 80-100 mg/kg/dose IV q6-8h.",
            administration = "Intravenous infusion over 30 minutes (standard) or 4 hours (extended infusion for severe sepsis).",
            timing = "Every 6 to 8 hours depending on CrCl.",
            specialInstructions = "Check baseline renal function. Not active against MRSA or ESBL-producing strains.",
            pkPd = "Bactericidal cell wall synthesis inhibitor. Tazobactam protects piperacillin from beta-lactamase degradation. Renal elimination ~70% unchanged.",
            renalAdj = "CrCl 20-40 mL/min: 3.375 g q6h. CrCl <20 mL/min: 2.25 g q6h. Hemodialysis: 2.25 g q8h + 0.75 g post-dialysis.",
            hepaticAdj = "No initial adjustment needed; use with caution in severe cirrhosis.",
            pregnancy = "Category B (Safe, widely used in obstetric sepsis)",
            lactation = "Compatible with breastfeeding in low concentrations.",
            sideEffects = "Diarrhea, nausea, C. difficile colitis, rash, elevated transaminases, hypokalemia, acute interstitial nephritis.",
            priceNpr = "NPR 350.00 - 580.00 per vial (4.5g)",
            priceInr = "INR 220.00 - 450.00 per vial (4.5g)",
            brandsNepal = listOf(
                BrandInfo("Pipra-T", "Deurali-Janta Pharmaceuticals", "Vial Inj", "4.5 g / 2.25 g"),
                BrandInfo("Piptaz", "Nepal Pharmaceuticals Lab", "Vial Inj", "4.5 g"),
                BrandInfo("Tazobac-N", "Asian Pharmaceuticals", "Vial Inj", "4.5 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Tazomac", "Macleods Pharmaceuticals", "Vial Inj", "4.5 g / 2.25 g"),
                BrandInfo("Zosyn", "Pfizer India", "Vial Inj", "4.5 g"),
                BrandInfo("Pipzo", "Mankind Pharma", "Vial Inj", "4.5 g"),
                BrandInfo("Piptaz", "Cipla Ltd.", "Vial Inj", "4.5 g")
            ),
            pediatricDosePerKg = 80.0,
            pediatricInterval = "IV q6-8h"
        ),
        Drug(
            id = "d32",
            genericName = "Meropenem",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Carbapenem Antibiotic",
            blackBoxWarning = null,
            indications = "Severe intra-abdominal infections, bacterial meningitis, febrile neutropenia, complicated UTI, septic shock, ESBL-producing Enterobacteriaceae.",
            doses = "Adult: 1 g IV q8h over 30 min (or 3h extended infusion). Meningitis: 2 g IV q8h.\nPeds: 20 mg/kg IV q8h; meningitis 40 mg/kg IV q8h (max 2g).",
            administration = "IV bolus over 3-5 min or IV infusion over 15-30 minutes / 3 hours.",
            timing = "q8h regularly spaced.",
            specialInstructions = "STRICT CONTRAINDICATION: Do NOT co-administer with Sodium Valproate (drastic reduction in valproate levels causes status epilepticus).",
            pkPd = "Bactericidal cell wall synthesis inhibitor. Minimal CSF penetration unless meninges inflamed. Renally excreted (70% unchanged). Half-life ~1h.",
            renalAdj = "CrCl 26-50 mL/min: 1 g q12h. CrCl 10-25 mL/min: 500 mg q12h. CrCl <10 mL/min: 500 mg q24h. Hemodialysis: 500 mg post-dialysis.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category B (Safe, used for severe sepsis)",
            lactation = "Present in breast milk in very low concentrations; compatible.",
            sideEffects = "Diarrhea, nausea, vomiting, headache, rash, C. difficile colitis, seizures (rare compared to imipenem).",
            priceNpr = "NPR 650.00 - 1,200.00 per vial (1g)",
            priceInr = "INR 450.00 - 950.00 per vial (1g)",
            brandsNepal = listOf(
                BrandInfo("Meronem-NPL", "Nepal Pharmaceuticals Lab", "Vial Inj", "1 g / 500 mg"),
                BrandInfo("Merocid", "Quest Pharmaceuticals", "Vial Inj", "1 g"),
                BrandInfo("Meropen", "Deurali-Janta Pharmaceuticals", "Vial Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Meronem", "Pfizer India", "Vial Inj", "1 g / 500 mg"),
                BrandInfo("Merocrit", "Cipla Ltd.", "Vial Inj", "1 g"),
                BrandInfo("Penem", "Alkem Laboratories", "Vial Inj", "1 g"),
                BrandInfo("Meromac", "Macleods Pharmaceuticals", "Vial Inj", "1 g")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "IV q8h"
        ),
        Drug(
            id = "d33",
            genericName = "Vancomycin Hydrochloride",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Glycopeptide Antibiotic",
            blackBoxWarning = null,
            indications = "MRSA infections, infective endocarditis, osteomyelitis, hospital-acquired pneumonia, severe C. difficile colitis (oral formulation only).",
            doses = "IV: 15-20 mg/kg (actual weight) IV q8-12h (max single dose 2g). Target trough 15-20 mcg/mL in severe infections.\nOral (C. diff only): 125 mg PO QID x 10 days.",
            administration = "Slow IV infusion: dilute in at least 200 mL and infuse at ≤10 mg/min (minimum 60-120 minutes) to prevent Red Man Syndrome.",
            timing = "q8-12h based on trough level and CrCl.",
            specialInstructions = "Red Man Syndrome is histamine-mediated, not a true allergy; slow infusion rate and pre-treat with antihistamines. Monitor serum creatinine and trough levels.",
            pkPd = "Inhibits cell wall peptidoglycan synthesis. Poor oral absorption (oral acts only in GI lumen). Excreted 80-90% unchanged by glomerular filtration.",
            renalAdj = "CrCl 50-80 mL/min: 15 mg/kg q12-24h. CrCl 20-49 mL/min: 15 mg/kg q24-48h. CrCl <20 mL/min / Hemodialysis: 15-20 mg/kg load then dose by trough level (<15 mcg/mL).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Oral: B). Use IV when benefit clearly outweighs risk.",
            lactation = "Excreted in low levels in milk; compatible.",
            sideEffects = "Nephrotoxicity (synergistic with aminoglycosides/pip-tazo), ototoxicity, Red Man Syndrome, neutropenia, phlebitis.",
            priceNpr = "NPR 450.00 - 750.00 per vial (1g)",
            priceInr = "INR 300.00 - 580.00 per vial (1g)",
            brandsNepal = listOf(
                BrandInfo("Vancotab", "Nepal Pharmaceuticals Lab", "Vial Inj", "1 g / 500 mg"),
                BrandInfo("Vancogen", "Asian Pharmaceuticals", "Vial Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Vancocin", "Eli Lilly / Abbott India", "Vial Inj", "500 mg / 1 g"),
                BrandInfo("Vantox", "Neon Laboratories", "Vial Inj", "1 g"),
                BrandInfo("Vancoled", "Cipla Ltd.", "Vial Inj", "1 g")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "IV q6-8h"
        ),
        Drug(
            id = "d34",
            genericName = "Cefixime",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Third-Generation Cephalosporin (Oral)",
            blackBoxWarning = null,
            indications = "Enteric fever (Typhoid), uncomplicated UTI, acute otitis media, acute exacerbation of chronic bronchitis, uncomplicated gonorrhea.",
            doses = "Adult: 200 mg PO BID or 400 mg PO OD for 7-14 days. Typhoid: 20 mg/kg/day divided BID x 14 days.\nPediatric: 8 mg/kg/day PO divided q12h.",
            administration = "Oral, with or without food. Suspension must be shaken well.",
            timing = "q12h or q24h.",
            specialInstructions = "High biliary excretion makes it effective in Salmonella enteric carrier states. Not active against Pseudomonas or Enterococci.",
            pkPd = "Oral bioavailability 40-50%. Long half-life ~3-4 hours allowing once or twice daily dosing. Renal elimination ~50% unchanged.",
            renalAdj = "CrCl 20-60 mL/min: 300 mg/day. CrCl <20 mL/min: 200 mg/day. Hemodialysis: 200 mg/day post-dialysis.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category B (Safe, widely prescribed in pregnancy)",
            lactation = "Compatible with nursing; monitor infant for loose stools.",
            sideEffects = "Diarrhea (frequent), dyspepsia, abdominal pain, flatulence, nausea, maculopapular rash, elevated transaminases.",
            priceNpr = "NPR 18.00 - 32.00 per tab (200mg)",
            priceInr = "INR 12.00 - 24.00 per tab (200mg)",
            brandsNepal = listOf(
                BrandInfo("Cefi", "Deurali-Janta Pharmaceuticals", "Tab / Dry Syr", "200 mg / 100mg/5ml"),
                BrandInfo("Cefix", "Asian Pharmaceuticals", "Tab", "200 mg"),
                BrandInfo("Xime", "Lomus Pharmaceuticals", "Tab", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Taxim-O", "Alkem Laboratories", "Tab / Syr", "200 mg / 100mg/5ml"),
                BrandInfo("Zifi", "FDC Ltd.", "Tab", "200 mg / 400 mg"),
                BrandInfo("Cefolac", "Macleods Pharmaceuticals", "Tab", "200 mg"),
                BrandInfo("Mahacef", "Mankind Pharma", "Tab", "200 mg")
            ),
            pediatricDosePerKg = 8.0,
            pediatricInterval = "divided q12h"
        ),
        Drug(
            id = "d35",
            genericName = "Enoxaparin Sodium",
            system = "Cardiovascular System (CVS)",
            drugClass = "Low Molecular Weight Heparin (LMWH)",
            blackBoxWarning = "SPINAL / EPIDURAL HEMATOMA: When neuraxial anesthesia (epidural/spinal) or spinal puncture is employed, patients receiving anticoagulation with enoxaparin are at risk of developing an epidural or spinal hematoma, which can result in long-term or permanent paralysis.",
            indications = "Prophylaxis of deep vein thrombosis (DVT), treatment of acute DVT/PE, non-ST elevation ACS (unstable angina/NSTEMI), acute STEMI undergoing PCI.",
            doses = "DVT Prophylaxis: 40 mg SC OD (or 30 mg SC BID in high-risk surgery).\nDVT/PE Treatment: 1 mg/kg SC q12h or 1.5 mg/kg SC OD.\nSTEMI: 30 mg IV bolus + 1 mg/kg SC q12h.",
            administration = "Subcutaneous injection into anterolateral or posterolateral abdominal wall; do not rub injection site.",
            timing = "q12h or q24h at the same time each day.",
            specialInstructions = "Do not expel air bubble from prefilled syringe before injection. Hold at least 12 hours before spinal/epidural puncture and 4 hours after catheter removal.",
            pkPd = "Anti-Xa to Anti-IIa ratio 3.8:1. High bioavailability ~100% SC. Renal elimination. Elimination half-life ~4.5-7 hours.",
            renalAdj = "CrCl <30 mL/min: Treatment: 1 mg/kg SC OD. Prophylaxis: 30 mg SC OD. Monitor anti-Factor Xa levels if available.",
            hepaticAdj = "Use with caution in hepatic cirrhosis due to coagulopathy.",
            pregnancy = "Category B (Anticoagulant of choice during pregnancy, does not cross placenta)",
            lactation = "Compatible with breastfeeding (large molecular weight, poorly absorbed orally by infant).",
            sideEffects = "Bleeding, injection site hematoma, heparin-induced thrombocytopenia (HIT, lower risk than UFH), elevated liver enzymes.",
            priceNpr = "NPR 380.00 - 620.00 per prefilled syringe (40mg/0.4ml)",
            priceInr = "INR 280.00 - 480.00 per prefilled syringe (40mg/0.4ml)",
            brandsNepal = listOf(
                BrandInfo("Lonopin-N", "Nepal Pharmaceuticals Lab", "PFS Inj", "40 mg / 60 mg"),
                BrandInfo("Enox-N", "Quest Pharmaceuticals", "PFS Inj", "40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Clexane", "Sanofi India", "PFS Inj", "40 mg / 60 mg / 80 mg"),
                BrandInfo("Lonopin", "Bharat Serums & Vaccines", "PFS Inj", "40 mg / 60 mg"),
                BrandInfo("Lovenox", "Sanofi", "PFS Inj", "40 mg")
            )
        ),
        Drug(
            id = "d36",
            genericName = "Warfarin Sodium",
            system = "Cardiovascular System (CVS)",
            drugClass = "Vitamin K Antagonist (Oral Anticoagulant)",
            blackBoxWarning = "MAJOR BLEEDING: Warfarin can cause major or fatal bleeding. Perform regular monitoring of INR in all treated patients. Numerous drugs, dietary changes, and herbal products alter INR levels.",
            indications = "Prophylaxis and treatment of venous thromboembolism (DVT/PE), prevention of systemic embolism in atrial fibrillation, mechanical heart valve replacement.",
            doses = "Initial: 2 to 5 mg PO once daily. Titrate according to INR: Target INR 2.0-3.0 for AF, DVT, bioprosthetic valves; Target INR 2.5-3.5 for mechanical mitral valves.",
            administration = "Take orally once daily in the evening at the same time.",
            timing = "Evening (consistent time daily).",
            specialInstructions = "Consistent dietary intake of Vitamin K (green leafy vegetables). Check INR frequently. Antidote: Vitamin K1 (Phytomenadione) + Prothrombin Complex Concentrate (PCC).",
            pkPd = "Inhibits Vitamin K epoxide reductase complex 1 (VKORC1), blocking carboxylation of clotting factors II, VII, IX, X and proteins C and S. Half-life ~40 hours.",
            renalAdj = "No dose adjustment required, but monitor INR closely.",
            hepaticAdj = "Avoid in severe liver dysfunction (impaired clotting factor synthesis).",
            pregnancy = "Category X (ABSOLUTELY CONTRAINDICATED in pregnancy; causes fetal warfarin syndrome, nasal hypoplasia, and CNS abnormalities).",
            lactation = "Compatible with breastfeeding (not detected in human milk).",
            sideEffects = "Hemorrhage, purple toe syndrome, warfarin-induced skin necrosis (due to rapid protein C depletion), alopecia.",
            priceNpr = "NPR 3.50 - 7.00 per tab (5mg)",
            priceInr = "INR 2.50 - 5.50 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Uniwarf", "Nepal Pharmaceuticals Lab", "Tab", "1 mg / 2 mg / 5 mg"),
                BrandInfo("Warf-N", "Deurali-Janta Pharmaceuticals", "Tab", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Warf", "Cipla Ltd.", "Tab", "1 mg / 2 mg / 3 mg / 5 mg"),
                BrandInfo("Coumadin", "Abbott India", "Tab", "5 mg"),
                BrandInfo("Uniwarf", "Unichem Laboratories", "Tab", "5 mg")
            )
        ),
        Drug(
            id = "d37",
            genericName = "Apixaban",
            system = "Cardiovascular System (CVS)",
            drugClass = "Direct Factor Xa Inhibitor (DOAC)",
            blackBoxWarning = "PREMATURE DISCONTINUATION INCREASES RISK OF THROMBOTIC EVENTS; SPINAL/EPIDURAL HEMATOMA with neuraxial anesthesia.",
            indications = "Non-valvular atrial fibrillation (stroke prevention), DVT/PE treatment and secondary prophylaxis, VTE thromboprophylaxis post-hip/knee replacement.",
            doses = "Atrial Fibrillation: 5 mg PO BID.\nReduce to 2.5 mg PO BID if patient has ≥2 of: Age ≥80 years, Weight ≤60 kg, Serum Creatinine ≥1.5 mg/dL.\nVTE Treatment: 10 mg PO BID x 7 days, then 5 mg PO BID.",
            administration = "Oral, with or without food.",
            timing = "q12h consistently morning and night.",
            specialInstructions = "Routine coagulation monitoring (INR/aPTT) NOT required. Antidote: Andexanet alfa or 4-factor PCC in life-threatening bleeding.",
            pkPd = "Selective reversible Factor Xa inhibitor. Bioavailability ~50%. Dual elimination: 27% renal, remainder biliary/fecal. Half-life ~12 hours.",
            renalAdj = "CrCl 15-29 mL/min: Use with caution. If patient has 25% dose reduction criteria met in AF, reduce to 2.5 mg BID. CrCl <15 mL/min: Not recommended.",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh C): Contraindicated. Child-Pugh B: Use with caution.",
            pregnancy = "Category B/C (Avoid in pregnancy due to bleeding risk; LMWH preferred).",
            lactation = "Not recommended during breastfeeding.",
            sideEffects = "Bleeding (epistaxis, GI bleeding, hematuria), anemia, bruising, elevated AST/ALT.",
            priceNpr = "NPR 45.00 - 75.00 per tab (5mg)",
            priceInr = "INR 30.00 - 55.00 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Apigat", "Deurali-Janta Pharmaceuticals", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Apix", "Quest Pharmaceuticals", "Tab", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Eliquis", "Pfizer / BMS India", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Apigat", "Natco Pharma", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Eliq", "Cipla Ltd.", "Tab", "5 mg")
            )
        ),
        Drug(
            id = "d38",
            genericName = "Bisoprolol Fumarate",
            system = "Cardiovascular System (CVS)",
            drugClass = "Cardioselective Beta-1 Adrenergic Blocker",
            blackBoxWarning = "AVOID ABRUPT CESSATION: Severe exacerbation of angina, myocardial infarction, and ventricular dysrhythmias have occurred following sudden withdrawal of beta-blockers.",
            indications = "Chronic Heart Failure with reduced ejection fraction (HFrEF - guideline-directed medical therapy), Essential Hypertension, Angina Pectoris.",
            doses = "Heart Failure: Initial 1.25 mg PO once daily; titrate weekly/bi-weekly to 2.5 mg, 3.75 mg, 5 mg, 7.5 mg, up to target 10 mg OD.\nHypertension/Angina: 5-10 mg PO OD.",
            administration = "Oral once daily in the morning with or without food.",
            timing = "Morning with breakfast.",
            specialInstructions = "Check baseline resting heart rate and blood pressure (hold if HR <50 bpm or SBP <90 mmHg). In heart failure, patient must be clinically euvolemic before initiating.",
            pkPd = "Highly selective Beta-1 blocker (14-fold higher affinity than beta-2). Bioavailability ~90%. Balanced 50% renal / 50% hepatic elimination. Half-life ~10-12 hours.",
            renalAdj = "CrCl <20 mL/min: Max dose 10 mg/day.",
            hepaticAdj = "Severe hepatic impairment: Max dose 10 mg/day.",
            pregnancy = "Category C (May cause fetal bradycardia and IUGR; Labetalol preferred in pregnancy).",
            lactation = "Excreted in low amounts; monitor infant for bradycardia and hypoglycemia.",
            sideEffects = "Bradycardia, hypotension, fatigue, dizziness, cold extremities, bronchospasm (rare at low doses), masking of hypoglycemia.",
            priceNpr = "NPR 6.00 - 14.00 per tab (5mg)",
            priceInr = "INR 4.50 - 11.00 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Bisotab", "Deurali-Janta Pharmaceuticals", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Corbis-N", "Quest Pharmaceuticals", "Tab", "5 mg"),
                BrandInfo("Bisomed", "Asian Pharmaceuticals", "Tab", "2.5 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Concor", "Merck Specialities India", "Tab", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Corbis", "Unichem Laboratories", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Bisotab", "Micro Labs Ltd.", "Tab", "5 mg")
            )
        ),
        Drug(
            id = "d39",
            genericName = "Ramipril",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin-Converting Enzyme (ACE) Inhibitor",
            blackBoxWarning = "FETOTOXICITY: Discontinue immediately if pregnancy detected; causes oligohydramnios, fetal renal failure, craniofacial deformities, and neonatal death.",
            indications = "Hypertension, Heart Failure post-MI, Diabetic and non-diabetic Nephropathy, cardiovascular risk reduction in high-risk patients (HOPE trial).",
            doses = "Hypertension: Initial 2.5 mg PO OD; titrate to 5-10 mg OD.\nPost-MI Heart Failure: Initial 2.5 mg BID; titrate to target 5 mg BID.\nCV Risk Reduction: 2.5 mg OD x 1 wk, 5 mg OD x 3 wks, then target 10 mg OD.",
            administration = "Oral, once or twice daily with or without food.",
            timing = "Morning (or evening).",
            specialInstructions = "Check baseline renal function and potassium; expect up to 30% rise in creatinine which stabilizes. Dry cough is bradykinin-mediated; switch to ARB if intolerable.",
            pkPd = "Prodrug converted by hepatic esterases to active metabolite ramiprilat. Half-life ~13-17 hours. Excreted renally (60%) and feces (40%).",
            renalAdj = "CrCl <40 mL/min: Initial 1.25 mg OD; max 5 mg/day. Monitor serum potassium closely.",
            hepaticAdj = "Severe impairment: Impaired conversion to ramiprilat; monitor clinical response.",
            pregnancy = "Category D (ABSOLUTELY CONTRAINDICATED in 2nd and 3rd trimesters).",
            lactation = "Excreted in breast milk in small amounts; use caution.",
            sideEffects = "Persistent dry cough (10-15%), hyperkalemia, hypotension, dizziness, angioedema (rare, life-threatening), acute renal impairment in bilateral renal artery stenosis.",
            priceNpr = "NPR 5.00 - 12.00 per tab (5mg)",
            priceInr = "INR 3.50 - 9.00 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Ramace", "Deurali-Janta Pharmaceuticals", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Ramistar-N", "Nepal Pharmaceuticals Lab", "Tab", "5 mg"),
                BrandInfo("Cardace-N", "Asian Pharmaceuticals", "Tab", "2.5 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cardace", "Sanofi India", "Tab", "1.25 / 2.5 / 5 / 10 mg"),
                BrandInfo("Ramistar", "Lupin Ltd.", "Tab", "2.5 mg / 5 mg"),
                BrandInfo("Hopace", "Micro Labs Ltd.", "Tab", "5 mg")
            )
        ),
        Drug(
            id = "d40",
            genericName = "Spironolactone",
            system = "Cardiovascular System (CVS)",
            drugClass = "Mineralocorticoid / Aldosterone Receptor Antagonist (K-sparing Diuretic)",
            blackBoxWarning = "TUMORIGENICITY: Shown to be tumorigenic in chronic toxicity animal studies; avoid unnecessary use.",
            indications = "Heart failure with reduced ejection fraction (NYHA II-IV, RALES trial), Resistant Hypertension, Hepatic Cirrhosis with Ascites, Primary Hyperaldosteronism.",
            doses = "Heart Failure: Initial 12.5-25 mg PO OD; titrate to max 50 mg OD.\nResistant HTN: 25-50 mg PO OD.\nCirrhotic Ascites: 100 mg PO OD (titrate up to 400 mg/day; maintain 100:40 Spironolactone to Furosemide ratio).",
            administration = "Oral, once daily with food (enhances bioavailability).",
            timing = "Morning with breakfast (prevents nocturia).",
            specialInstructions = "Check serum potassium and creatinine at baseline, week 1, week 4, and q3-6 months. Do not start if baseline K+ >5.0 mEq/L or eGFR <30 mL/min.",
            pkPd = "Competitive antagonist of aldosterone at distal renal tubules. Hepatically metabolized to active canrenone. Half-life of canrenone ~16 hours.",
            renalAdj = "eGFR 30-50 mL/min: Initial 12.5 mg every other day; max 25 mg OD. eGFR <30 mL/min: Contraindicated.",
            hepaticAdj = "Dose with caution; effective in reversing secondary hyperaldosteronism in cirrhosis.",
            pregnancy = "Category C (Anti-androgenic effect; avoid unless essential).",
            lactation = "Canrenone excreted in milk in low quantities; compatible.",
            sideEffects = "Hyperkalemia, painful gynecomastia in men (due to non-selective anti-androgen action), menstrual irregularities, impotence, dizziness, hyponatremia.",
            priceNpr = "NPR 4.50 - 9.50 per tab (25mg)",
            priceInr = "INR 3.00 - 7.50 per tab (25mg)",
            brandsNepal = listOf(
                BrandInfo("Spirotone", "Deurali-Janta Pharmaceuticals", "Tab", "25 mg / 50 mg"),
                BrandInfo("Aldoct-N", "Quest Pharmaceuticals", "Tab", "25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Aldactone", "RPG Life Sciences", "Tab", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Spiromide", "RPG Life Sciences", "Combo Tab", "Spirono + Furosemide"),
                BrandInfo("Aldostix", "Cipla Ltd.", "Tab", "25 mg")
            )
        ),
        Drug(
            id = "d41",
            genericName = "Chlorthalidone",
            system = "Cardiovascular System (CVS)",
            drugClass = "Thiazide-like Diuretic",
            blackBoxWarning = null,
            indications = "Essential Hypertension (preferred thiazide-like diuretic in ACC/AHA guidelines), edema associated with CHF and renal disease.",
            doses = "Hypertension: Initial 12.5 mg PO once daily in morning; titrate to 25 mg OD if needed (max 50 mg/day, but doses >25 mg increase hypokalemia with little extra BP reduction).",
            administration = "Oral, once daily in the morning with food.",
            timing = "Morning with breakfast.",
            specialInstructions = "Long duration of action (48-72 hours) provides superior 24-hour BP control compared to hydrochlorothiazide. Monitor serum potassium, sodium, and uric acid.",
            pkPd = "Inhibits Na+/Cl- cotransporter in distal convoluted tubule. Half-life 40-60 hours (extremely long). Excreted predominantly unchanged in urine.",
            renalAdj = "CrCl <30 mL/min: Ineffective as monotherapy; loop diuretics (furosemide) preferred.",
            hepaticAdj = "Use caution in severe hepatic impairment (electrolyte shifts may precipitate hepatic encephalopathy).",
            pregnancy = "Category B (Generally avoided in gestational hypertension due to decreased placental perfusion).",
            lactation = "Excreted in breast milk; may suppress lactation.",
            sideEffects = "Hypokalemia, hyponatremia, hyperuricemia (may trigger acute gout), hyperglycemia, hypercalcemia, erectile dysfunction.",
            priceNpr = "NPR 4.00 - 8.50 per tab (12.5mg)",
            priceInr = "INR 3.00 - 6.50 per tab (12.5mg)",
            brandsNepal = listOf(
                BrandInfo("Thalizide", "Deurali-Janta Pharmaceuticals", "Tab", "12.5 mg / 25 mg"),
                BrandInfo("Chlorthal-N", "Quest Pharmaceuticals", "Tab", "12.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Hythalton", "Abbott India", "Tab", "12.5 mg / 25 mg"),
                BrandInfo("CTD", "Ipca Laboratories", "Tab", "6.25 mg / 12.5 mg"),
                BrandInfo("Thalizide", "Sun Pharma", "Tab", "12.5 mg")
            )
        ),
        Drug(
            id = "d42",
            genericName = "Sitagliptin Phosphate",
            system = "Endocrine & Metabolic System",
            drugClass = "Dipeptidyl Peptidase-4 (DPP-4) Inhibitor (Gliptin)",
            blackBoxWarning = null,
            indications = "Type 2 Diabetes Mellitus as monotherapy or combination with Metformin, Sulfonylureas, or SGLT2 inhibitors.",
            doses = "Adult: 100 mg PO once daily with or without food.",
            administration = "Oral once daily.",
            timing = "Morning with or without meals.",
            specialInstructions = "Weight-neutral antidiabetic with minimal hypoglycemia risk when used without sulfonylureas. Warn patient of acute pancreatitis symptoms (severe persistent epigastric pain radiating to back).",
            pkPd = "Slows inactivation of incretin hormones (GLP-1 and GIP), stimulating glucose-dependent insulin release and lowering glucagon. Bioavailability ~87%. Excreted 79% unchanged in urine.",
            renalAdj = "eGFR 30-44 mL/min: 50 mg PO once daily. eGFR <30 mL/min or ESRD: 25 mg PO once daily (administered without regard to hemodialysis timing).",
            hepaticAdj = "No adjustment in mild-to-moderate impairment.",
            pregnancy = "Category B (Insulin is standard of care in pregnancy).",
            lactation = "Unknown if excreted into human milk; use alternative.",
            sideEffects = "Nasopharyngitis, upper respiratory infection, headache, joint pain (arthralgias), rare pancreatitis, hypersensitivity reactions.",
            priceNpr = "NPR 18.00 - 32.00 per tab (100mg)",
            priceInr = "INR 12.00 - 24.00 per tab (100mg)",
            brandsNepal = listOf(
                BrandInfo("Sita", "Deurali-Janta Pharmaceuticals", "Tab", "50 mg / 100 mg"),
                BrandInfo("Sitamed", "Quest Pharmaceuticals", "Tab", "100 mg"),
                BrandInfo("Janumed", "Asian Pharmaceuticals", "Tab", "50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Januvia", "MSD Pharmaceuticals India", "Tab", "50 mg / 100 mg"),
                BrandInfo("Sitara", "Sun Pharma", "Tab", "100 mg"),
                BrandInfo("Zita", "Glenmark Pharmaceuticals", "Tab", "100 mg"),
                BrandInfo("Istavel", "Sun Pharma", "Tab", "50 mg / 100 mg")
            )
        ),
        Drug(
            id = "d43",
            genericName = "Glimepiride",
            system = "Endocrine & Metabolic System",
            drugClass = "Second-Generation Sulfonylurea",
            blackBoxWarning = "INCREASED RISK OF CARDIOVASCULAR MORTALITY: Sulfonylureas reported to be associated with increased cardiovascular mortality compared to diet alone or insulin.",
            indications = "Type 2 Diabetes Mellitus as adjunct to diet and exercise or combination with metformin.",
            doses = "Initial: 1 to 2 mg PO once daily with breakfast. Titrate by 1-2 mg every 1-2 weeks based on blood glucose; Usual maintenance 1-4 mg/day (Max 8 mg/day).",
            administration = "Oral once daily immediately before or with breakfast.",
            timing = "First main meal of the day.",
            specialInstructions = "Always ensure meals are not skipped to prevent severe prolonged hypoglycemia. Educate patient on hypoglycemia signs (shakiness, diaphoresis, palpitations).",
            pkPd = "Stimulates insulin release from pancreatic beta cells by closing ATP-sensitive potassium channels. Completely absorbed orally. Hepatically metabolized by CYP2C9. Half-life ~5-9 hours.",
            renalAdj = "CrCl <60 mL/min: Start with 1 mg PO once daily; titrate conservatively due to risk of prolonged hypoglycemia.",
            hepaticAdj = "Use with caution; avoid in severe liver impairment.",
            pregnancy = "Category C (Discontinue at least 2 weeks before delivery; insulin preferred).",
            lactation = "Contraindicated during breastfeeding due to potential neonatal hypoglycemia.",
            sideEffects = "Hypoglycemia (prolonged), weight gain, nausea, epigastric fullness, allergic skin reactions, rare thrombocytopenia.",
            priceNpr = "NPR 3.00 - 8.00 per tab (2mg)",
            priceInr = "INR 2.00 - 6.00 per tab (2mg)",
            brandsNepal = listOf(
                BrandInfo("Glimisun", "Deurali-Janta Pharmaceuticals", "Tab", "1 mg / 2 mg / 3 mg"),
                BrandInfo("Diapride-N", "Nepal Pharmaceuticals Lab", "Tab", "1 mg / 2 mg"),
                BrandInfo("Glim", "Asian Pharmaceuticals", "Tab", "2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Amaryl", "Sanofi India", "Tab", "1 mg / 2 mg / 3 mg / 4 mg"),
                BrandInfo("Glimestar", "Mankind Pharma", "Tab", "1 mg / 2 mg"),
                BrandInfo("Glypride", "Sun Pharma", "Tab", "1 mg / 2 mg"),
                BrandInfo("Zoryl", "Intas Pharmaceuticals", "Tab", "2 mg")
            )
        ),
        Drug(
            id = "d44",
            genericName = "Insulin Glargine",
            system = "Endocrine & Metabolic System",
            drugClass = "Long-Acting Basal Insulin Analogue (rDNA origin)",
            blackBoxWarning = null,
            indications = "Type 1 Diabetes Mellitus (in combination with prandial insulin), Type 2 Diabetes Mellitus requiring basal insulin control.",
            doses = "Type 2 DM: Initial 0.1-0.2 units/kg (or 10 units) SC once daily at bedtime; titrate by 2 units every 3 days targeting fasting glucose 80-130 mg/dL.\nType 1 DM: Individualized as ~40-50% of total daily insulin requirements.",
            administration = "Subcutaneous injection into abdomen, thigh, or upper arm. Rotate injection sites. NEVER administer IV or IM.",
            timing = "Once daily at the same time every day (e.g., bedtime).",
            specialInstructions = "Clear, colorless solution. DO NOT DILUTE OR MIX WITH ANY OTHER INSULIN OR SOLUTION (acidic pH 4 precipitates if mixed). Store unopened vials in refrigerator (2-8°C); in-use vial stable at room temperature for 28 days.",
            pkPd = "Micro-precipitates in subcutaneous tissue after injection, slowly releasing insulin over 24 hours with NO pronounced peak (peakless basal profile). Duration 24 hours.",
            renalAdj = "Renal impairment decreases insulin clearance; reduce dose and monitor glucose frequently.",
            hepaticAdj = "Decreased gluconeogenesis in severe cirrhosis; reduce dose.",
            pregnancy = "Category C (Widely used in pregnancy under endocrinologist guidance; does not cross placenta).",
            lactation = "Compatible with breastfeeding (insulin destroyed in infant GI tract).",
            sideEffects = "Hypoglycemia, injection site lipodystrophy/lipohypertrophy, peripheral edema, weight gain, rare allergic reactions.",
            priceNpr = "NPR 650.00 - 1,150.00 per 10ml vial (100 IU/ml)",
            priceInr = "INR 450.00 - 850.00 per 10ml vial (100 IU/ml)",
            brandsNepal = listOf(
                BrandInfo("Basalog", "Biocon (Nepal Supply)", "Vial / Cartridge", "100 IU/ml"),
                BrandInfo("Glaritus-N", "Wockhardt (Nepal Supply)", "Vial", "100 IU/ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Lantus", "Sanofi India", "Vial / Solostar Pen", "100 IU/ml"),
                BrandInfo("Basalog", "Biocon", "Vial / Pen", "100 IU/ml"),
                BrandInfo("Toujeo", "Sanofi India", "Solostar Pen", "300 IU/ml"),
                BrandInfo("Glaritus", "Wockhardt", "Vial / Cartridge", "100 IU/ml")
            )
        ),
        Drug(
            id = "d45",
            genericName = "Insulin Regular (Human Soluble Insulin)",
            system = "Endocrine & Metabolic System",
            drugClass = "Short-Acting Human Insulin (rDNA origin)",
            blackBoxWarning = null,
            indications = "Type 1 and Type 2 Diabetes Mellitus, Diabetic Ketoacidosis (DKA), Hyperosmolar Hyperglycemic State (HHS), Severe Hyperkalemia management (with Dextrose).",
            doses = "Subcutaneous: 0.5 to 1.0 unit/kg/day total insulin (30-50% as regular insulin divided before meals).\nDKA Protocol: 0.1 units/kg IV bolus, then 0.1 units/kg/hour continuous IV infusion (titrate to lower blood glucose by 50-75 mg/dL/hour).\nHyperkalemia: 10 units IV Regular Insulin + 50 mL 50% Dextrose over 15-30 min.",
            administration = "SC: 30 minutes before meals. IV: In DKA or hyperkalemia via infusion pump.",
            timing = "30 minutes prior to meals.",
            specialInstructions = "Only regular insulin is safe for intravenous (IV) administration. In DKA, verify serum potassium is ≥3.3 mEq/L before starting insulin infusion to prevent fatal arrhythmias.",
            pkPd = "Onset SC: 30-60 min; Peak: 2-4 hours; Duration: 6-8 hours. Onset IV: immediate; Duration IV: 30-60 min.",
            renalAdj = "Reduce dose by 25-50% in severe CKD due to reduced renal catabolism of insulin.",
            hepaticAdj = "Requires careful titration; reduced insulin clearance in liver disease.",
            pregnancy = "Category B (Drug of choice for gestational and pre-existing diabetes in pregnancy).",
            lactation = "Safe and compatible with breastfeeding.",
            sideEffects = "Hypoglycemia, hypokalemia, injection site lipodystrophy, weight gain.",
            priceNpr = "NPR 280.00 - 450.00 per 10ml vial (100 IU/ml)",
            priceInr = "INR 160.00 - 320.00 per 10ml vial (100 IU/ml)",
            brandsNepal = listOf(
                BrandInfo("Huminsulin R", "Eli Lilly (Nepal Supply)", "Vial", "100 IU/ml"),
                BrandInfo("Actrapid HM", "Novo Nordisk (Nepal)", "Vial", "100 IU/ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Actrapid", "Novo Nordisk India", "Vial / Penfill", "100 IU/ml"),
                BrandInfo("Huminsulin R", "Eli Lilly India", "Vial", "100 IU/ml"),
                BrandInfo("Wosulin-R", "Wockhardt", "Vial / Cartridge", "100 IU/ml")
            )
        ),
        Drug(
            id = "d46",
            genericName = "Levothyroxine Sodium (T4)",
            system = "Endocrine & Metabolic System",
            drugClass = "Thyroid Hormone",
            blackBoxWarning = "NOT FOR OBESITY OR WEIGHT LOSS: Thyroid hormones should not be used either alone or in combination with other therapeutic agents for the treatment of obesity or for weight loss.",
            indications = "Primary, secondary, or tertiary hypothyroidism, TSH suppression in thyroid cancer, euthyroid goiter.",
            doses = "Full Replacement Dose: ~1.6 mcg/kg/day PO (e.g. 75-125 mcg OD).\nElderly or patients with Coronary Artery Disease: Start with 12.5 to 25 mcg PO OD; titrate every 6-8 weeks by 12.5-25 mcg based on serum TSH.\nSubclinical Hypothyroidism: 25-50 mcg PO OD.",
            administration = "Oral, once daily with a full glass of water on an empty stomach at least 30 to 60 minutes before breakfast.",
            timing = "Early morning on empty stomach (or 3-4 hours after evening meal at bedtime).",
            specialInstructions = "Separate by at least 4 hours from calcium, iron, antacids, or sucralfate (impair absorption). Re-evaluate TSH every 6-8 weeks after dose change until euthyroid.",
            pkPd = "Synthetic T4 converted peripherally to active T3 by 5'-deiodinase. Bioavailability 70-80%. Highly protein bound (>99% to TBG). Half-life 6-7 days (requires 5-6 weeks to reach steady state).",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No initial adjustment; monitor TSH.",
            pregnancy = "Category A (Essential in pregnancy; maternal hypothyroidism impairs fetal neurocognitive development. Dose requirement increases by 30-50% during pregnancy).",
            lactation = "Excreted in low levels in milk; safe and compatible.",
            sideEffects = "Palpitations, tachycardia, arrhythmias, tremors, nervousness, insomnia, weight loss, heat intolerance, diaphoresis (signs of over-replacement).",
            priceNpr = "NPR 1.80 - 4.50 per tab (100mcg)",
            priceInr = "INR 1.20 - 3.50 per tab (100mcg)",
            brandsNepal = listOf(
                BrandInfo("Thyro-N", "Deurali-Janta Pharmaceuticals", "Tab", "25 / 50 / 75 / 100 mcg"),
                BrandInfo("Eltrox", "Quest Pharmaceuticals", "Tab", "50 / 100 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Thyronorm", "Abbott India", "Tab", "25 / 50 / 75 / 88 / 100 / 125 mcg"),
                BrandInfo("Eltroxin", "GlaxoSmithKline India", "Tab", "25 / 50 / 100 mcg"),
                BrandInfo("Thyrox", "Macleods Pharmaceuticals", "Tab", "50 / 100 mcg")
            )
        ),
        Drug(
            id = "d47",
            genericName = "Omeprazole",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Proton Pump Inhibitor (PPI)",
            blackBoxWarning = null,
            indications = "Gastroesophageal Reflux Disease (GERD), Peptic Ulcer Disease (Gastric & Duodenal), H. pylori eradication (triple therapy), Zollinger-Ellison syndrome, stress ulcer prophylaxis.",
            doses = "GERD / Healing of Erosive Esophagitis: 20-40 mg PO once daily for 4-8 weeks.\nDuodenal Ulcer: 20 mg PO OD for 4 weeks.\nH. pylori Triple Therapy: Omeprazole 20 mg PO BID + Amoxicillin 1 g BID + Clarithromycin 500 mg BID x 14 days.",
            administration = "Oral capsule/tablet swallowed whole; take 30-60 minutes before breakfast on an empty stomach.",
            timing = "30-60 minutes before morning meal.",
            specialInstructions = "Do not crush or chew delayed-release capsules. Long-term use (>1 year) associated with hypomagnesemia, Vitamin B12 deficiency, bone fractures, and C. difficile infections. Avoid co-administration with Clopidogrel (CYP2C19 competition blunts antiplatelet effect; use Pantoprazole instead).",
            pkPd = "Irreversibly inhibits H+/K+ ATPase pump in gastric parietal cells. Bioavailability 30-40%. Metabolized extensively by CYP2C19 and CYP3A4. Half-life ~0.5-1 hour, but duration of acid suppression lasts 24-72 hours due to covalent binding.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "Severe hepatic impairment: Max 20 mg/day.",
            pregnancy = "Category C (Category B for pantoprazole/esomeprazole; widely used).",
            lactation = "Excreted into breast milk in low levels; compatible.",
            sideEffects = "Headache, diarrhea, abdominal pain, flatulence, nausea, Vitamin B12 deficiency (chronic), acute interstitial nephritis, C. diff diarrhea.",
            priceNpr = "NPR 3.50 - 7.50 per cap (20mg)",
            priceInr = "INR 2.50 - 5.50 per cap (20mg)",
            brandsNepal = listOf(
                BrandInfo("Ocid-N", "Nepal Pharmaceuticals Lab", "Cap", "20 mg / 40 mg"),
                BrandInfo("Omerox", "Deurali-Janta Pharmaceuticals", "Cap", "20 mg"),
                BrandInfo("Omez-NPL", "Asian Pharmaceuticals", "Cap", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Omez", "Dr. Reddy's Laboratories", "Cap", "20 mg / 40 mg"),
                BrandInfo("Ocid", "Zydus Healthcare", "Cap", "20 mg"),
                BrandInfo("Propran-O", "Cipla Ltd.", "Cap", "20 mg")
            )
        ),
        Drug(
            id = "d48",
            genericName = "Sucralfate",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Gastric Mucosal Protectant",
            blackBoxWarning = null,
            indications = "Active duodenal ulcer, gastric mucosal erosion, radiation proctitis/stomatitis, stress ulcer prophylaxis in ICU.",
            doses = "Active Ulcer: 1 g PO QID (1 hour before meals and at bedtime) or 2 g PO BID on empty stomach for 4-8 weeks.\nMaintenance: 1 g PO BID.",
            administration = "Oral suspension or tablet crushed in water; take on an empty stomach at least 1 hour before meals.",
            timing = "1 hour before meals and bedtime.",
            specialInstructions = "Binds to proteins in ulcer craters, forming a protective barrier against acid and pepsin. Impairs absorption of fluoroquinolones, digoxin, phenytoin, and levothyroxine; separate by at least 2 hours.",
            pkPd = "Acts locally; minimally absorbed (<5%). Excreted primarily in feces unchanged. Minimal systemic bioavailability.",
            renalAdj = "Use with caution in chronic kidney disease (aluminum component may accumulate, leading to aluminum toxicity).",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category B (Safe due to minimal systemic absorption).",
            lactation = "Compatible with breastfeeding.",
            sideEffects = "Constipation (most common ~2%), dry mouth, bezoar formation (rare in patients with gastroparesis), nausea.",
            priceNpr = "NPR 120.00 - 220.00 per 100ml syrup (1g/5ml)",
            priceInr = "INR 85.00 - 160.00 per 100ml syrup (1g/5ml)",
            brandsNepal = listOf(
                BrandInfo("Sucracid", "Deurali-Janta Pharmaceuticals", "Suspension", "1 g / 5 ml"),
                BrandInfo("Pegfate-N", "Asian Pharmaceuticals", "Suspension", "1 g / 5 ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Sucrafil", "Fourrts Laboratories", "Suspension", "1 g / 5 ml"),
                BrandInfo("Pegfate", "Alkem Laboratories", "Suspension", "1 g / 5 ml"),
                BrandInfo("Sucrate", "Pfizer India", "Suspension", "1 g / 5 ml")
            )
        ),
        Drug(
            id = "d49",
            genericName = "Budesonide + Formoterol Fumarate",
            system = "Respiratory System (RS)",
            drugClass = "Inhaled Corticosteroid (ICS) + Long-Acting Beta-2 Agonist (LABA)",
            blackBoxWarning = "LABA MONOTHERAPY RISK: Long-acting beta2-adrenergic agonists as monotherapy without an inhaled corticosteroid increase the risk of asthma-related death. Must always be used in combination.",
            indications = "Asthma maintenance and reliever therapy (GINA SMART Strategy), Chronic Obstructive Pulmonary Disease (COPD) maintenance.",
            doses = "Asthma GINA SMART Track 1: 160/4.5 mcg or 200/6 mcg: 1-2 inhalations BID maintenance PLUS 1 inhalation PRN for acute symptoms (Max 8-12 inhalations/day).\nCOPD: 320/9 mcg (or 400/12 mcg) 1 inhalation BID.",
            administration = "Dry powder inhaler (DPI) or metered-dose inhaler (MDI) with spacer.",
            timing = "Morning and evening; plus PRN as reliever.",
            specialInstructions = "RINSE MOUTH AND SPIT OUT WATER AFTER EACH USE to prevent oral candidiasis (thrush) and dysphonia. Rapid onset of formoterol (~1-3 minutes) makes it suitable as a rescue bronchodilator.",
            pkPd = "Budesonide: potent local anti-inflammatory glucocorticoid with high first-pass hepatic metabolism (90%). Formoterol: long-acting selective beta-2 agonist with rapid onset (1-3 min) and 12-hour duration.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "Severe liver disease increases systemic budesonide exposure; use caution.",
            pregnancy = "Category C (Budesonide is the most studied and preferred ICS in pregnancy).",
            lactation = "Compatible with breastfeeding in therapeutic doses.",
            sideEffects = "Oral candidiasis, dysphonia, throat irritation, tremor, palpitations, tachycardia, headache, hypokalemia.",
            priceNpr = "NPR 550.00 - 850.00 per inhaler (120 doses)",
            priceInr = "INR 350.00 - 620.00 per inhaler (120 doses)",
            brandsNepal = listOf(
                BrandInfo("Foracort-N", "Cipla (Nepal Supply)", "Inhaler / Rotacaps", "100 / 200 / 400 mcg"),
                BrandInfo("Budetrol", "Deurali-Janta Pharmaceuticals", "Inhaler", "200/6 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Foracort", "Cipla Ltd.", "Inhaler / Autohaler", "100 / 200 / 400 mcg"),
                BrandInfo("Symbicort", "AstraZeneca India", "Turbuhaler", "80/4.5, 160/4.5 mcg"),
                BrandInfo("Budamate", "Lupin Ltd.", "Transhaler", "200 / 400 mcg")
            )
        ),
        Drug(
            id = "d50",
            genericName = "Tiotropium Bromide",
            system = "Respiratory System (RS)",
            drugClass = "Long-Acting Muscarinic Antagonist (LAMA / Anticholinergic)",
            blackBoxWarning = null,
            indications = "Maintenance treatment of Chronic Obstructive Pulmonary Disease (COPD) including chronic bronchitis and emphysema; add-on maintenance in severe persistent asthma (Step 4/5).",
            doses = "COPD (DPI HandiHaler): 18 mcg inhalation powder (1 capsule) once daily.\nCOPD/Asthma (Respimat SMI): 2 inhalations (2.5 mcg/puff = 5 mcg total) once daily.",
            administration = "Oral inhalation ONLY via dedicated inhaler device. Capsules must NEVER be swallowed orally.",
            timing = "Once daily at the same time each day.",
            specialInstructions = "Instruct patient: capsule goes into chamber of inhaler, pierce button, inhale deeply. DO NOT SWALLOW CAPSULE! Use caution in narrow-angle glaucoma or urinary retention (BPH).",
            pkPd = "Non-selective muscarinic receptor antagonist, but dissociates very slowly from M1 and M3 receptors, providing prolonged bronchodilation for >24 hours. Minimal systemic absorption (<20%).",
            renalAdj = "CrCl ≤50 mL/min: Monitor closely for anticholinergic side effects.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category C (Safety not established; weigh risk/benefit).",
            lactation = "Compatible with nursing due to negligible systemic absorption.",
            sideEffects = "Dry mouth (most common), pharyngitis, cough, urinary retention, constipation, blurred vision, acute narrow-angle glaucoma.",
            priceNpr = "NPR 450.00 - 780.00 per rotacap pack (30 caps + device)",
            priceInr = "INR 280.00 - 550.00 per rotacap pack (30 caps + device)",
            brandsNepal = listOf(
                BrandInfo("Tiova-N", "Cipla (Nepal Supply)", "Rotacaps / Inhaler", "18 mcg"),
                BrandInfo("Spiripuff", "Lupin (Nepal Supply)", "Inhaler", "9 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Spiriva", "Boehringer Ingelheim India", "HandiHaler / Respimat", "18 mcg / 2.5 mcg"),
                BrandInfo("Tiova", "Cipla Ltd.", "Rotacaps / Inhaler", "18 mcg"),
                BrandInfo("Airtec-T", "Glenmark Pharmaceuticals", "Inhaler", "18 mcg")
            )
        ),
        Drug(
            id = "d51",
            genericName = "Levetiracetam",
            system = "Central Nervous System (CNS)",
            drugClass = "Broad-Spectrum Anticonvulsant (SV2A Ligand)",
            blackBoxWarning = null,
            indications = "Focal/partial-onset seizures, generalized tonic-clonic seizures, myoclonic seizures in juvenile myoclonic epilepsy, status epilepticus (second-line IV).",
            doses = "Adult Oral/IV: Initial 500 mg BID; titrate by 1000 mg/day every 2 weeks to max 3000 mg/day (1500 mg BID).\nStatus Epilepticus IV: 60 mg/kg (max 4500 mg) infused over 10-15 minutes.\nPediatric: 10 mg/kg BID; titrate by 20 mg/kg/day to max 60 mg/kg/day.",
            administration = "Oral tablet/solution or IV infusion diluted in 100 mL NS/D5W over 15 minutes.",
            timing = "q12h with or without meals.",
            specialInstructions = "Zero CYP450 enzyme interactions (drug of choice in patients on polypharmacy, anticoagulants, or chemotherapy). Monitor for behavioral changes, depression, or psychosis.",
            pkPd = "Binds to synaptic vesicle protein SV2A, inhibiting neurotransmitter release. Rapid 100% oral absorption. Minimal protein binding (<10%). Renally eliminated (66% unchanged). Half-life 6-8 hours.",
            renalAdj = "CrCl 50-80 mL/min: 500-1000 mg q12h. CrCl 30-49 mL/min: 250-750 mg q12h. CrCl <30 mL/min: 250-500 mg q12h. Hemodialysis: 500-1000 mg q24h + 250-500 mg post-dialysis.",
            hepaticAdj = "No adjustment in mild-to-moderate impairment. In severe cirrhosis with CrCl <50, reduce dose by 50%.",
            pregnancy = "Category C (One of the safest antiepileptics in pregnancy; lowest teratogenicity risk compared to valproate).",
            lactation = "Excreted into breast milk; compatible under infant monitoring for somnolence.",
            sideEffects = "Somnolence, dizziness, fatigue, asthenia, irritability, aggression, behavioral mood changes, depression.",
            priceNpr = "NPR 14.00 - 26.00 per tab (500mg)",
            priceInr = "INR 9.00 - 18.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Levipil-N", "Nepal Pharmaceuticals Lab", "Tab", "250 / 500 / 750 mg"),
                BrandInfo("Levesam-N", "Deurali-Janta Pharmaceuticals", "Tab", "500 mg"),
                BrandInfo("Keppra-N", "Asian Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Keppra", "UCB / Dr. Reddy's", "Tab / Inj", "500 mg / 1000 mg"),
                BrandInfo("Levipil", "Sun Pharma", "Tab / Inj", "250 / 500 / 750 / 1000 mg"),
                BrandInfo("Levesam", "Alkem Laboratories", "Tab", "500 mg"),
                BrandInfo("Torleva", "Torrent Pharmaceuticals", "Tab", "500 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "PO BID (titrate to 30 mg/kg BID)"
        ),
        Drug(
            id = "d52",
            genericName = "Sodium Valproate / Valproic Acid",
            system = "Central Nervous System (CNS)",
            drugClass = "Broad-Spectrum Anticonvulsant & Mood Stabilizer",
            blackBoxWarning = "HEPATOTOXICITY, FETAL TERATOGENICITY (Neural Tube Defects / IQ reduction), PANCREATITIS: Fatal hepatic failure has occurred in patients under 2 years of age and those with mitochondrial disorders (POLG mutations). High teratogenic risk in pregnancy.",
            indications = "Absence seizures, tonic-clonic seizures, juvenile myoclonic epilepsy, status epilepticus, acute mania in Bipolar Disorder, migraine prophylaxis.",
            doses = "Epilepsy: Initial 10-15 mg/kg/day PO divided BID/TID; titrate by 5-10 mg/kg/week to therapeutic serum trough level of 50-100 mcg/mL (Max 60 mg/kg/day).\nStatus Epilepticus IV: 40 mg/kg IV over 5-10 minutes.",
            administration = "Oral with or after food to decrease GI irritation, or IV infusion.",
            timing = "With meals, divided BID or TID.",
            specialInstructions = "STRICTLY CONTRAINDICATED IN WOMEN OF CHILDBEARING AGE UNLESS EFFECTIVE CONTRACEPTION PREVENT PROGRAM IN PLACE. Baseline & periodic LFTs, CBC with platelets, and lipase. Carbapenems (Meropenem) cause drastic drop in valproate levels!",
            pkPd = "Increases brain GABA levels and blocks voltage-gated Na+ channels and T-type Ca2+ channels. Bioavailability ~100%. Highly protein bound (90%). Hepatic metabolism (CYP2C9/2C19/glucuronidation). Half-life 9-16 hours.",
            renalAdj = "Protein binding altered in uremia; dose adjustment based on free valproate level.",
            hepaticAdj = "Contraindicated in severe hepatic impairment or acute liver disease.",
            pregnancy = "Category X (Major congenital malformations, spina bifida, autistim spectrum disorders).",
            lactation = "Excreted in low amounts in milk; compatible under infant monitoring.",
            sideEffects = "Weight gain, hair loss (alopecia), fine hand tremor, nausea, thrombocytopenia, hyperammonemia, hepatic dysfunction, pancreatitis.",
            priceNpr = "NPR 6.50 - 15.00 per tab (300mg CR)",
            priceInr = "INR 4.50 - 11.00 per tab (300mg CR)",
            brandsNepal = listOf(
                BrandInfo("Valpro-N", "Deurali-Janta Pharmaceuticals", "CR Tab", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Encor-N", "Nepal Pharmaceuticals Lab", "CR Tab", "300 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Epilim", "Sanofi India", "Chrono Tab", "200 / 300 / 500 mg"),
                BrandInfo("Encorate", "Sun Pharma", "Chrono Tab / Inj", "200 / 300 / 500 mg"),
                BrandInfo("Valparin", "Sanofi", "Alkalets Tab", "200 / 500 mg"),
                BrandInfo("Depakote", "Abbott India", "Tab", "250 / 500 mg")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "divided BID/TID"
        ),
        Drug(
            id = "d53",
            genericName = "Phenytoin Sodium",
            system = "Central Nervous System (CNS)",
            drugClass = "Hydantoin Anticonvulsant (Sodium Channel Blocker)",
            blackBoxWarning = "CARDIOVASCULAR COLLAPSE WITH RAPID IV INFUSION: Rapid IV administration can cause severe hypotension and cardiac arrhythmias. Infusion rate should not exceed 50 mg/minute in adults (1-3 mg/kg/min in children).",
            indications = "Generalized tonic-clonic seizures, focal seizures, prevention of seizures post-neurosurgery/TBI, status epilepticus (after benzodiazepines).",
            doses = "Status Epilepticus Loading IV: 15-20 mg/kg IV infused at ≤50 mg/min with continuous ECG and BP monitoring.\nOral Maintenance: 300-400 mg/day PO (or 4-7 mg/kg/day) divided BID or TID. Target therapeutic serum level: 10-20 mcg/mL.",
            administration = "Oral with food. IV must be administered into a large vein through an in-line filter with 0.9% NS ONLY (precipitates in Dextrose).",
            timing = "Consistent daily schedule with meals.",
            specialInstructions = "Exhibits non-linear Michaelis-Menten kinetics: small dose increases can lead to disproportionate serum level spikes and toxicity! Purple Glove Syndrome risk with extravasation.",
            pkPd = "Voltage-dependent block of neuronal sodium channels. Bioavailability ~70-90%. 90% protein bound (albumin). Hepatic metabolism via CYP2C9/2C19 (saturated at therapeutic doses). Half-life 12-36 hours.",
            renalAdj = "Dosing based on total phenytoin level misleading in hypoalbuminemia/uremia; calculate corrected phenytoin level: Total / ((0.2 x Albumin) + 0.1).",
            hepaticAdj = "Metabolism impaired; titrate carefully with therapeutic drug monitoring.",
            pregnancy = "Category D (Fetal Hydantoin Syndrome: cleft lip/palate, microcephaly, hypoplastic nails).",
            lactation = "Excreted into breast milk; compatible under infant monitoring.",
            sideEffects = "Nystagmus, ataxia, slurred speech (toxicity >20 mcg/mL), gingival hyperplasia, hirsutism, peripheral neuropathy, megaloblastic anemia (folate deficiency), osteomalacia.",
            priceNpr = "NPR 3.00 - 6.50 per tab (100mg)",
            priceInr = "INR 2.00 - 4.50 per tab (100mg)",
            brandsNepal = listOf(
                BrandInfo("Eptoin-N", "Nepal Pharmaceuticals Lab", "Tab / Inj", "100 mg / 100mg/2ml"),
                BrandInfo("Dilantin-N", "Pfizer (Nepal Supply)", "Tab", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Eptoin", "Abbott India", "Tab / Inj", "50 / 100 mg / 100mg/2ml"),
                BrandInfo("Dilantin", "Pfizer India", "Cap", "100 mg"),
                BrandInfo("Epsolin", "Cadila Pharmaceuticals", "Inj", "100mg/2ml")
            ),
            pediatricDosePerKg = 5.0,
            pediatricInterval = "divided BID/TID"
        ),
        Drug(
            id = "d54",
            genericName = "Gabapentin",
            system = "Central Nervous System (CNS)",
            drugClass = "Gabapentinoid / Alpha-2-Delta Ligand",
            blackBoxWarning = "RESPIRATORY DEPRESSION RISK: Serious, life-threatening, or fatal respiratory depression may occur when used with opioids or other CNS depressants, or in patients with underlying COPD/respiratory impairment.",
            indications = "Postherpetic neuralgia, painful diabetic peripheral neuropathy, fibromyalgia, focal seizures (adjunct), restless legs syndrome.",
            doses = "Adult: Day 1: 300 mg PO OD at bedtime; Day 2: 300 mg BID; Day 3: 300 mg TID. Titrate by 300 mg/day every 3 days up to usual maintenance 1800-2400 mg/day divided TID (Max 3600 mg/day).",
            administration = "Oral, with or without food. Divide TID so maximum interval between doses does not exceed 12 hours.",
            timing = "TID with breakfast, lunch, and bedtime.",
            specialInstructions = "Dose must be adjusted strictly based on CrCl. Zero hepatic metabolism or drug-drug interactions. Avoid abrupt cessation (taper over at least 1 week).",
            pkPd = "Binds to alpha-2-delta auxiliary subunit of voltage-gated calcium channels in CNS, reducing glutamate and substance P release. Saturable L-amino acid gut transport (bioavailability drops from 60% at 300mg to 35% at 1600mg). 100% renal excretion. Half-life 5-7 hours.",
            renalAdj = "CrCl 30-59 mL/min: 200-700 mg BID. CrCl 15-29 mL/min: 200-700 mg OD. CrCl <15 mL/min: 100-300 mg OD. Hemodialysis: Post-dialysis supplemental dose 125-350 mg.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category C (Use only if potential benefit justifies potential fetal risk).",
            lactation = "Excreted in human milk; compatible under infant monitoring for sedation.",
            sideEffects = "Somnolence, dizziness, peripheral edema, ataxia, fatigue, weight gain, blurred vision, tremors.",
            priceNpr = "NPR 10.00 - 18.00 per tab (300mg)",
            priceInr = "INR 7.00 - 14.00 per tab (300mg)",
            brandsNepal = listOf(
                BrandInfo("Gabapin-N", "Nepal Pharmaceuticals Lab", "Cap", "100 / 300 mg"),
                BrandInfo("Neuropen", "Deurali-Janta Pharmaceuticals", "Cap", "300 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Gabapin", "Intas Pharmaceuticals", "Cap / Tab", "100 / 300 / 400 mg"),
                BrandInfo("Neurontin", "Pfizer India", "Cap", "300 mg / 400 mg"),
                BrandInfo("Gabator", "Torrent Pharmaceuticals", "Tab", "300 mg")
            )
        ),
        Drug(
            id = "d55",
            genericName = "Diclofenac Sodium",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Non-Steroidal Anti-Inflammatory Drug (NSAID - Phenylacetic Acid)",
            blackBoxWarning = "CARDIOVASCULAR THROMBOTIC EVENTS & GASTROINTESTINAL BLEEDING: NSAIDs cause an increased risk of serious cardiovascular thrombotic events, myocardial infarction, and stroke. Serious GI bleeding, ulceration, and perforation can occur at any time without warning.",
            indications = "Osteoarthritis, rheumatoid arthritis, ankylosing spondylitis, acute musculoskeletal trauma, acute renal colic (IM), post-operative pain.",
            doses = "Oral: 50 mg PO BID or TID, or 75 mg PO BID (Max 150 mg/day).\nDeep IM Injection: 75 mg deep intragluteal injection once or twice daily for max 2 days.",
            administration = "Oral with or after meals with plenty of water. Deep IM only.",
            timing = "With or immediately after meals.",
            specialInstructions = "Highest cardiovascular risk among non-selective NSAIDs (similar to celecoxib); avoid in patients with established ischemic heart disease or heart failure. Co-prescribe PPI in elderly or high GI risk.",
            pkPd = "Non-selective COX-1 and COX-2 inhibitor. Rapid oral absorption; extensive first-pass metabolism (bioavailability ~50%). Protein binding >99%. Half-life 1-2 hours, but concentrates in synovial fluid for up to 11 hours.",
            renalAdj = "Avoid in severe renal impairment (CrCl <30 mL/min). Causes renal vasoconstriction via prostaglandin inhibition.",
            hepaticAdj = "Use lowest effective dose; rare cases of severe drug-induced hepatotoxicity reported (monitor LFTs).",
            pregnancy = "Category D in 3rd trimester (Premature closure of fetal ductus arteriosus, oligohydramnios). Category C in 1st/2nd trimester.",
            lactation = "Excreted in breast milk in negligible amounts; compatible.",
            sideEffects = "Dyspepsia, epigastric pain, peptic ulceration, elevated AST/ALT, fluid retention, hypertension, acute kidney injury, skin rash.",
            priceNpr = "NPR 2.50 - 5.50 per tab (50mg)",
            priceInr = "INR 1.80 - 4.00 per tab (50mg)",
            brandsNepal = listOf(
                BrandInfo("Vover-N", "Nepal Pharmaceuticals Lab", "Tab / Inj", "50 mg / 75mg/3ml"),
                BrandInfo("Diclogesic", "Deurali-Janta Pharmaceuticals", "Tab", "50 mg"),
                BrandInfo("Nac", "Lomus Pharmaceuticals", "Tab", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Voveran", "Novartis / Abbott India", "Tab / Inj", "50 mg / SR 75 mg / 75mg/1ml"),
                BrandInfo("Dynapar", "Troikaa Pharmaceuticals", "Inj (AQ) / Tab", "75 mg / 75mg/1ml"),
                BrandInfo("Jonac", "Zydus Healthcare", "Tab / Inj", "50 mg / 75 mg")
            )
        ),
        Drug(
            id = "d56",
            genericName = "Ketorolac Tromethamine",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Potent Injectable NSAID (Pyrrolo-pyrrole Derivative)",
            blackBoxWarning = "SHORT-TERM USE ONLY (MAX 5 DAYS COMBINED IV/IM/PO): High risk of peptic ulcer, GI bleeding, and perforation. Contraindicated in advanced renal impairment, volume depletion, perioperative CABG pain, labor/delivery, and active intracranial bleeding.",
            indications = "Short-term management of acute moderate-to-severe post-operative pain, acute renal colic, refractory migraine.",
            doses = "IV/IM: 30 mg IV/IM q6h PRN (max 120 mg/day).\nPatients ≥65 years, weight <50 kg, or moderately elevated serum Cr: 15 mg IV/IM q6h (max 60 mg/day).\nOral: 10 mg q4-6h (only as continuation of IV/IM; total combined therapy MUST NOT EXCEED 5 DAYS).",
            administration = "Slow IV bolus over at least 15 seconds, or deep IM injection.",
            timing = "q6h PRN as needed for acute severe pain.",
            specialInstructions = "MANDATORY MAX 5 DAYS DURATION: Risk of severe GI hemorrhage and acute renal failure escalates drastically after 5 days. Ensure adequate hydration before administration.",
            pkPd = "Potent cyclooxygenase inhibitor (higher analgesic than anti-inflammatory potency, comparable to low-dose opioids without respiratory depression). Bioavailability ~100%. Half-life ~5-6 hours.",
            renalAdj = "Advanced renal impairment (CrCl <30 mL/min): CONTRAINDICATED. Moderate impairment: halve dose (max 60 mg/day).",
            hepaticAdj = "Use caution in severe hepatic impairment.",
            pregnancy = "Category D (ABSOLUTELY CONTRAINDICATED in 3rd trimester and labor/delivery).",
            lactation = "Compatible with nursing for short-term postpartum analgesia.",
            sideEffects = "Gastrointestinal bleeding/perforation, acute kidney injury, injection site pain, nausea, dizziness, headache, hypertension, platelet dysfunction.",
            priceNpr = "NPR 18.00 - 32.00 per ampoule (30mg/1ml)",
            priceInr = "INR 12.00 - 24.00 per ampoule (30mg/1ml)",
            brandsNepal = listOf(
                BrandInfo("Toradol-N", "Nepal Pharmaceuticals Lab", "Inj / Tab", "30mg/ml / 10mg"),
                BrandInfo("Ketanov-N", "Asian Pharmaceuticals", "Inj", "30mg/ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Ketorol", "Dr. Reddy's Laboratories", "Inj / Tab", "30mg/1ml / 10mg"),
                BrandInfo("Ketanov", "Ranbaxy / Sun Pharma", "Inj / Tab", "30mg/ml / 10mg"),
                BrandInfo("Toradol", "Roche / Piramal", "Inj", "30mg/ml")
            )
        ),
        Drug(
            id = "d57",
            genericName = "Hydrocortisone Sodium Succinate",
            system = "Emergency & Critical Care",
            drugClass = "Short-Acting Systemic Glucocorticoid (Natural Cortisol)",
            blackBoxWarning = null,
            indications = "Septic shock refractory to vasopressors (Surviving Sepsis Campaign), Acute Adrenal Crisis (Addisonian Crisis), Severe Anaphylaxis (secondary prevention of biphasic reaction), Status Asthmaticus.",
            doses = "Septic Shock: 200 mg/day IV given as 50 mg IV q6h or continuous infusion of 200 mg/24h.\nAcute Adrenal Crisis: 100 mg IV stat bolus, followed by 100-200 mg/24h continuous infusion or 50 mg IV q6h.\nSevere Anaphylaxis / Asthma: 100 to 200 mg IV q6h.",
            administration = "Slow IV injection over 3-5 minutes, or continuous IV infusion.",
            timing = "q6h or continuous infusion.",
            specialInstructions = "Has equivalent glucocorticoid and mineralocorticoid activity (causes sodium/water retention and potassium excretion). In septic shock, taper once vasopressors are successfully weaned.",
            pkPd = "Binds to intracellular glucocorticoid receptors, modulating gene transcription. Rapid onset IV (1-2 hours). Half-life ~1.5-2 hours, biological duration of action 8-12 hours. Hepatic clearance.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "Use caution in severe cirrhosis; monitor fluid retention and electrolytes.",
            pregnancy = "Category C (Hydrocortisone is metabolized by placental 11-beta-HSD2; drug of choice for maternal adrenal crisis).",
            lactation = "Compatible with breastfeeding in replacement and short-term stress doses.",
            sideEffects = "Hyperglycemia, sodium retention, hypokalemia, hypertension, peptic ulceration, secondary infection, insomnia, psychosis.",
            priceNpr = "NPR 60.00 - 110.00 per vial (100mg)",
            priceInr = "INR 40.00 - 80.00 per vial (100mg)",
            brandsNepal = listOf(
                BrandInfo("Primacort", "Deurali-Janta Pharmaceuticals", "Vial Inj", "100 mg / 200 mg"),
                BrandInfo("Efcorlin-N", "Nepal Pharmaceuticals Lab", "Vial Inj", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Solu-Cortef", "Pfizer India", "Vial Inj", "100 mg / 200 mg / 500 mg"),
                BrandInfo("Primacort", "Macleods Pharmaceuticals", "Vial Inj", "100 mg / 200 mg"),
                BrandInfo("Efcorlin", "GlaxoSmithKline India", "Vial Inj", "100 mg")
            ),
            pediatricDosePerKg = 2.0,
            pediatricInterval = "IV q6h"
        ),
        Drug(
            id = "d58",
            genericName = "Dexamethasone Sodium Phosphate",
            system = "Emergency & Critical Care",
            drugClass = "Long-Acting Synthetic Glucocorticoid (Zero Mineralocorticoid Activity)",
            blackBoxWarning = null,
            indications = "Cerebral edema associated with brain tumors/abscesses, acute bacterial meningitis (adjuvant therapy), acute croup (laryngotracheobronchitis), severe COVID-19 with hypoxemia (RECOVERY trial), antiemetic in chemotherapy.",
            doses = "Cerebral Edema: 10 mg IV loading bolus, then 4 mg IV q6h; taper over 5-7 days.\nBacterial Meningitis: 10 mg IV q6h given with or 15-20 min before the first dose of antibiotics x 4 days.\nCroup: 0.15 - 0.6 mg/kg PO/IM/IV single dose.\nCOVID-19 ARDS: 6 mg PO/IV once daily for up to 10 days.",
            administration = "IV bolus over 1-3 minutes, IM, or oral.",
            timing = "q6h in cerebral edema; once daily in COVID-19.",
            specialInstructions = "High potency (25-30 times more potent than hydrocortisone) with ZERO mineralocorticoid activity (no sodium or fluid retention, making it ideal for cerebral edema). In bacterial meningitis, gives highest benefit in S. pneumoniae.",
            pkPd = "Rapid distribution. Biological half-life 36 to 54 hours (long-acting). Extensively metabolized by liver.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No dose adjustment; monitor blood glucose.",
            pregnancy = "Category C (Crosses placenta readily; indicated to accelerate fetal lung maturity in threatened preterm delivery 24-34 weeks).",
            lactation = "Compatible for short-term use.",
            sideEffects = "Hyperglycemia, acute delirium/psychosis, insomnia, gastric irritation, leukocytosis, immunosuppression, hiccups.",
            priceNpr = "NPR 12.00 - 22.00 per ampoule (4mg/1ml)",
            priceInr = "INR 8.00 - 16.00 per ampoule (4mg/1ml)",
            brandsNepal = listOf(
                BrandInfo("Dexona-N", "Nepal Pharmaceuticals Lab", "Inj / Tab", "4mg/ml / 0.5mg"),
                BrandInfo("Demisone", "Deurali-Janta Pharmaceuticals", "Inj", "4mg/ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Dexona", "Zydus Healthcare", "Inj / Tab", "4mg/1ml / 0.5mg"),
                BrandInfo("Decadron", "Wockhardt", "Inj", "4mg/1ml / 8mg/2ml"),
                BrandInfo("Demisone", "Cadila Pharmaceuticals", "Inj", "4mg/ml")
            ),
            pediatricDosePerKg = 0.15,
            pediatricInterval = "mg/kg single dose (Croup)"
        ),
        Drug(
            id = "d59",
            genericName = "Epinephrine (Adrenaline)",
            system = "Emergency & Critical Care",
            drugClass = "Direct-Acting Sympathomimetic (Alpha-1, Alpha-2, Beta-1, Beta-2 Agonist)",
            blackBoxWarning = null,
            indications = "Anaphylaxis / Severe allergic angioedema (DRUG OF CHOICE), Cardiac Arrest (VF, Pulseless VT, Asystole, PEA), Severe Refractory Croup (nebulized L-epinephrine), Septic Shock (second-line vasopressor).",
            doses = "Anaphylaxis (IM ONLY): Adult: 0.5 mg (0.5 mL of 1:1,000 [1 mg/mL]) IM into mid-anterolateral thigh. Repeat every 5-15 min PRN.\nPeds: 0.01 mg/kg (0.01 mL/kg of 1:1,000) IM (max 0.3 mg).\nCardiac Arrest (IV/IO): 1 mg IV/IO (10 mL of 1:10,000 [0.1 mg/mL]) q3-5 min.\nContinuous IV Infusion: 0.05 - 0.5 mcg/kg/min titrated to MAP.",
            administration = "ANAPHYLAXIS MUST BE INTRAMUSCULAR (IM) in anterolateral thigh. IV push is RESTRICTED to cardiac arrest or peri-arrest under ICU/cardiac monitoring.",
            timing = "Immediate stat in anaphylaxis; repeat q5-15min.",
            specialInstructions = "NEVER DELAY EPINEPHRINE IN ANAPHYLAXIS. Antihistamines and corticosteroids are second-line adjunctive and must never replace or delay epinephrine! 1:1,000 is for IM; 1:10,000 is for IV push in arrest.",
            pkPd = "Alpha-1 vasoconstriction reverses peripheral vasodilation and mucosal edema. Beta-1 inotropic and chronotropic stimulation increases cardiac output. Beta-2 bronchodilation relieves bronchospasm and inhibits mast cell mediator release. Onset IM: 3-8 minutes. Half-life <5 minutes.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Indicated IMMEDIATELY in anaphylaxis; maternal hypoxia and hypotension pose fatal risk to fetus).",
            lactation = "Compatible with nursing in life-saving emergencies.",
            sideEffects = "Palpitations, tachycardia, tremors, anxiety, pallor, hypertension, headache, ventricular arrhythmias, myocardial ischemia in elderly/CAD.",
            priceNpr = "NPR 25.00 - 45.00 per ampoule (1mg/1ml 1:1000)",
            priceInr = "INR 18.00 - 35.00 per ampoule (1mg/1ml 1:1000)",
            brandsNepal = listOf(
                BrandInfo("Adrenaline-N", "Nepal Aushadhi Limited", "Ampoule", "1 mg / 1 ml (1:1000)"),
                BrandInfo("Adren-NPL", "Nepal Pharmaceuticals Lab", "Ampoule", "1 mg / 1 ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Adrenaline Tartrate", "Neon Laboratories", "Ampoule", "1 mg / 1 ml (1:1000)"),
                BrandInfo("Vasocon", "Harson Laboratories", "Ampoule", "1 mg / 1 ml")
            ),
            pediatricDosePerKg = 0.01,
            pediatricInterval = "mg/kg IM in anterolateral thigh (max 0.3 mg)"
        ),
        Drug(
            id = "d60",
            genericName = "Norepinephrine Bitartrate (Noradrenaline)",
            system = "Emergency & Critical Care",
            drugClass = "Potent Alpha-1 Vasopressor with Mild Beta-1 Activity",
            blackBoxWarning = "EXTRAVASATION / TISSUE NECROSIS: To prevent tissue sloughing and necrosis in areas in which extravasation occurs, the site should be infused as soon as possible with 10-15 mL of saline containing 5-10 mg of phentolamine (alpha-adrenergic blocker).",
            indications = "Septic Shock (First-line vasopressor per Surviving Sepsis Campaign), Cardiogenic Shock (with inotropes), Neurogenic Shock, severe hypotension refractory to fluid resuscitation.",
            doses = "Continuous IV Infusion: Initial 0.02 to 0.2 mcg/kg/min (or 2-8 mcg/min). Rapidly titrate every 2-5 minutes to target Mean Arterial Pressure (MAP) ≥65 mmHg. Usual maintenance 0.05 - 0.5 mcg/kg/min (refractory shock may require >1 mcg/kg/min).",
            administration = "Continuous IV infusion ONLY via central venous catheter (CVC) using a calibrated infusion pump. Dilute 4 mg in 250 mL D5W or D5NS (16 mcg/mL).",
            timing = "Continuous titration by invasive arterial blood pressure.",
            specialInstructions = "Always administer in a central line whenever possible. Never administer in sodium bicarbonate solutions (inactivated by alkaline pH). Ensure adequate intravascular fluid resuscitation first.",
            pkPd = "Potent stimulation of vascular alpha-1 receptors causing intense arterial and venous vasoconstriction, increasing systemic vascular resistance (SVR) and MAP with minimal increase in heart rate. Onset immediate (1-2 min). Half-life 1-2 minutes.",
            renalAdj = "Restores renal perfusion pressure in vasodilatory shock, improving urine output.",
            hepaticAdj = "Metabolized by COMT and MAO in liver and sympathetic nervous tissue.",
            pregnancy = "Category C (Used for maternal septic shock; maintaining maternal MAP is vital for uteroplacental perfusion).",
            lactation = "Destroyed in GI tract if ingested; safe in maternal critical care.",
            sideEffects = "Severe peripheral vasoconstriction (digital gangrene in high doses), bradycardia (reflex), ventricular arrhythmias, extravasation necrosis, anxiety.",
            priceNpr = "NPR 120.00 - 210.00 per ampoule (4mg/2ml)",
            priceInr = "INR 75.00 - 150.00 per ampoule (4mg/2ml)",
            brandsNepal = listOf(
                BrandInfo("Norad-N", "Nepal Pharmaceuticals Lab", "Ampoule", "4 mg / 2 ml"),
                BrandInfo("Levonor", "Deurali-Janta Pharmaceuticals", "Ampoule", "4 mg / 2 ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Norad", "Neon Laboratories", "Ampoule", "4 mg / 2 ml"),
                BrandInfo("Levophed", "Pfizer India", "Ampoule", "4 mg / 2 ml"),
                BrandInfo("Adrenor", "Samarth Life Sciences", "Ampoule", "4 mg / 2 ml")
            )
        )
    )

    val additionalInteractions: List<DrugInteraction> = listOf(
        DrugInteraction(
            drug1Generic = "Meropenem",
            drug2Generic = "Sodium Valproate",
            severity = InteractionSeverity.CONTRAINDICATED,
            effect = "Precipitous, rapid 60-80% decline in serum valproate concentration within 24 hours, leading to breakthrough status epilepticus and coma.",
            mechanism = "Carbapenems inhibit acylpeptide hydrolase and prevent glucuronide hydrolysis of valproate, drastically accelerating systemic valproate clearance.",
            clinicalAction = "Strictly contraindicated combination. Switch carbapenem to alternative antibiotic or switch valproate to levetiracetam before initiating meropenem."
        ),
        DrugInteraction(
            drug1Generic = "Warfarin Sodium",
            drug2Generic = "Diclofenac Sodium",
            severity = InteractionSeverity.SERIOUS,
            effect = "Markedly increased risk of major gastrointestinal hemorrhage and bleeding events.",
            mechanism = "Pharmacodynamic synergy: NSAID platelet inhibition and gastric mucosal injury combined with Warfarin coagulation factor suppression.",
            clinicalAction = "Avoid concomitant use. If analgesia is required, use paracetamol (up to 2g/day) or topical therapy."
        ),
        DrugInteraction(
            drug1Generic = "Spironolactone",
            drug2Generic = "Ramipril",
            severity = InteractionSeverity.SERIOUS,
            effect = "Severe life-threatening hyperkalemia, cardiac conduction abnormalities, and ventricular arrhythmias.",
            mechanism = "Dual blockade of renin-angiotensin-aldosterone axis suppresses renal potassium excretion.",
            clinicalAction = "Monitor serum potassium and creatinine at baseline, day 3, day 7, and monthly. Discontinue spironolactone if K+ >5.5 mEq/L."
        ),
        DrugInteraction(
            drug1Generic = "Vancomycin Hydrochloride",
            drug2Generic = "Piperacillin + Tazobactam",
            severity = InteractionSeverity.SERIOUS,
            effect = "Synergistic nephrotoxicity and significantly increased incidence of acute kidney injury (AKI).",
            mechanism = "Combined tubular toxicity and interstitial inflammation; documented 3-fold higher AKI rate compared to Vancomycin + Cefepime.",
            clinicalAction = "Monitor daily serum creatinine and vancomycin trough levels. Switch to Cefepime or Meropenem if prolonged therapy is required."
        ),
        DrugInteraction(
            drug1Generic = "Phenytoin Sodium",
            drug2Generic = "Omeprazole",
            severity = InteractionSeverity.MODERATE,
            effect = "Elevated serum phenytoin levels and potential hydantoin toxicity (ataxia, nystagmus, lethargy).",
            mechanism = "Omeprazole competitively inhibits CYP2C19, impairing hepatic phenytoin clearance.",
            clinicalAction = "Monitor serum phenytoin level upon initiating or stopping omeprazole. Consider switching to pantoprazole."
        )
    )
}
