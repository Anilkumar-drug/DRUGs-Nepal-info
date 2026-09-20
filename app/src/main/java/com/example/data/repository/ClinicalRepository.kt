package com.example.data.repository

import com.example.data.model.Antidote
import com.example.data.model.BrandInfo
import com.example.data.model.DiseaseProtocol
import com.example.data.model.Drug

object ClinicalRepository {

    val organSystems = listOf(
        "All Systems",
        "Anti-Infectives & Antimicrobials",
        "Cardiovascular System (CVS)",
        "Endocrine & Metabolic System",
        "Gastrointestinal & Hepatobiliary",
        "Respiratory System (RS)",
        "Central Nervous System (CNS)",
        "Musculoskeletal & Analgesics",
        "Renal & Genitourinary",
        "Dermatology",
        "Emergency & Critical Care"
    )

    val drugs: List<Drug> = listOf(
        Drug(
            id = "d1",
            genericName = "Amoxicillin + Potassium Clavulanate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Beta-lactam Antibiotic + Beta-lactamase Inhibitor",
            blackBoxWarning = null,
            indications = "Community-acquired pneumonia (CAP), Acute bacterial sinusitis, Acute otitis media, Severe UTI, Skin and soft tissue infections, Bite wounds.",
            doses = "Adult: 625 mg PO TID or 1000 mg PO BID with meals. Severe: 1.2 g IV q8h.\nPediatric: 25-45 mg/kg/day divided q12h (or q8h).",
            administration = "Take orally at the start of a meal to enhance absorption of clavulanate and minimize GI intolerance.",
            timing = "With meals / early during mealtime.",
            specialInstructions = "Do not chew or crush sustained-release tablets. Complete prescribed course even if asymptomatic to prevent resistant strains.",
            pkPd = "Bioavailability ~70%. Peak plasma: 1-2.5h. Protein binding 18-25%. Excreted primarily unchanged in urine via glomerular filtration. Half-life: 1-1.3 hours. Bactericidal cell wall synthesis inhibitor.",
            renalAdj = "CrCl 10-30 mL/min: 250-500 mg PO q12h. CrCl <10 mL/min: 250-500 mg PO q24h. Hemodialysis: 500 mg PO q24h + supplementary dose post-dialysis.",
            hepaticAdj = "Use with caution. Monitor LFTs at baseline and weekly in prolonged therapy. Contraindicated in patients with history of amoxicillin/clavulanate-associated cholestatic jaundice.",
            pregnancy = "Category B (Safe, widely used)",
            lactation = "Excreted into breast milk in trace amounts; compatible with breastfeeding. Monitor infant for diarrhea or oral candidiasis.",
            sideEffects = "Diarrhea, nausea, vomiting, oral/vaginal candidiasis, cholestatic jaundice, elevated ALT/AST, urticaria, maculopapular rash.",
            priceNpr = "NPR 22.00 - 36.00 per tab (625mg)",
            priceInr = "INR 15.00 - 24.00 per tab (625mg)",
            brandsNepal = listOf(
                BrandInfo("Moxclave", "Deurali-Janta Pharmaceuticals", "Tab / Dry Syr", "625 mg / 228.5mg"),
                BrandInfo("Clavam-NPL", "Nepal Pharmaceuticals Lab", "Tab", "625 mg"),
                BrandInfo("Asian-Clav", "Asian Pharmaceuticals", "Dry Syr", "228.5mg / 457mg"),
                BrandInfo("Enclave", "Curex Pharmaceuticals", "Tab", "625 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Augmentin", "GlaxoSmithKline India", "Tab / Inj", "625 mg / 1g / 1.2g"),
                BrandInfo("Moxikind-CV", "Mankind Pharma", "Tab", "625 mg"),
                BrandInfo("Clavam", "Alkem Laboratories", "Inj / Tab", "1.2g Inj / 625mg"),
                BrandInfo("Ciplamox-CV", "Cipla Ltd.", "Tab", "625 mg")
            ),
            pediatricDosePerKg = 35.0,
            pediatricInterval = "divided q12h"
        ),
        Drug(
            id = "d2",
            genericName = "Telmisartan",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin II Receptor Blocker (ARB)",
            blackBoxWarning = "FETOTOXICITY: When pregnancy is detected, discontinue Telmisartan as soon as possible. Drugs that act directly on the renin-angiotensin system can cause injury and death to the developing fetus during the 2nd and 3rd trimesters.",
            indications = "Essential Hypertension, Diabetic Nephropathy, Cardiovascular Risk Reduction in patients aged ≥55 unable to tolerate ACE inhibitors.",
            doses = "Adult: 20-80 mg PO once daily. Usual starting dose: 40 mg OD.",
            administration = "Take orally once daily with or without food.",
            timing = "Morning or evening (consistent time daily).",
            specialInstructions = "Check baseline serum potassium and creatinine. Warn patient regarding lightheadedness on standing (orthostatic hypotension).",
            pkPd = "Bioavailability 42-58%. Highly protein bound (>99.5%). Hepatic metabolism via glucuronidation; biliary/fecal excretion >97%. Terminal elimination half-life ~24 hours.",
            renalAdj = "No initial dose adjustment required in mild-to-severe renal impairment or hemodialysis. Monitor serum potassium and creatinine closely.",
            hepaticAdj = "Mild to moderate hepatic impairment: Max 40 mg PO OD. Severe hepatic impairment or biliary obstructive disorders: Contraindicated.",
            pregnancy = "Category D (Contraindicated in 2nd and 3rd trimesters)",
            lactation = "Excreted in animal milk; not recommended during breastfeeding due to potential adverse renal effects in neonates.",
            sideEffects = "Hyperkalemia, dizziness, orthostatic hypotension, back pain, sinus congestion, elevated serum creatinine, rare angioedema.",
            priceNpr = "NPR 8.00 - 16.00 per tab (40mg)",
            priceInr = "INR 6.00 - 12.00 per tab (40mg)",
            brandsNepal = listOf(
                BrandInfo("Teltan", "Deurali-Janta Pharmaceuticals", "Tab", "40 mg / 80 mg"),
                BrandInfo("Telmisat", "Quest Pharmaceuticals", "Tab", "40 mg / 80 mg"),
                BrandInfo("Telma-NPL", "Nepal Pharmaceuticals Lab", "Tab", "40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Telma", "Glenmark Pharmaceuticals", "Tab", "20 / 40 / 80 mg"),
                BrandInfo("Telmikind", "Mankind Pharma", "Tab", "40 mg"),
                BrandInfo("Tazloc", "Torrent Pharmaceuticals", "Tab", "40 mg / 80 mg"),
                BrandInfo("Telpres", "Sun Pharma", "Tab", "40 mg")
            )
        ),
        Drug(
            id = "d3",
            genericName = "Metformin Hydrochloride",
            system = "Endocrine & Metabolic System",
            drugClass = "Biguanide Antidiabetic Agent",
            blackBoxWarning = "LACTIC ACIDOSIS: Post-marketing cases of metformin-associated lactic acidosis have resulted in death, hypothermia, hypotension, and resistant bradyarrhythmias. Risk factors include renal impairment, concomitant nephrotoxic drugs, age ≥65, IV contrast studies, surgery, and hepatic failure.",
            indications = "Type 2 Diabetes Mellitus (First-line monotherapy or combination), Polycystic Ovary Syndrome (PCOS), Gestational diabetes (specialist).",
            doses = "Initial: 500 mg PO BID or 850 mg OD with meals. Titrate weekly by 500 mg to maximum 2550 mg/day (or 2000 mg Extended Release once daily with evening meal).",
            administration = "Administer with or after meals to minimize gastrointestinal discomfort.",
            timing = "With breakfast and dinner.",
            specialInstructions = "Withhold 48 hours prior to iodinated contrast procedures and major surgeries. Resume only after 48h if renal function is re-evaluated and confirmed stable.",
            pkPd = "Bioavailability 50-60%. Negligible protein binding. Excreted unchanged in urine via tubular secretion. Elimination half-life ~6.2 hours. Activates AMP-kinase, suppresses hepatic glucose output.",
            renalAdj = "eGFR 45-59 mL/min: Max 2000 mg/day. eGFR 30-44 mL/min: Max 1000 mg/day (Do not initiate new therapy). eGFR <30 mL/min: Absolutely Contraindicated.",
            hepaticAdj = "Avoid use in patients with clinical or laboratory evidence of hepatic disease due to impaired lactate clearance.",
            pregnancy = "Category B (Acceptable, often used under endocrinologist guidance)",
            lactation = "Excreted into human breast milk in low concentrations; compatible with nursing.",
            sideEffects = "Diarrhea, nausea, abdominal cramping, flatulence, metallic taste, Vitamin B12 deficiency (long-term), lactic acidosis (rare).",
            priceNpr = "NPR 2.50 - 5.50 per tab (500mg)",
            priceInr = "INR 1.80 - 4.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Metphage", "Deurali-Janta Pharmaceuticals", "Tab", "500 mg / 850 mg"),
                BrandInfo("Glycimet", "Quest Pharmaceuticals", "SR Tab", "500 mg / 1000 mg"),
                BrandInfo("Diabeto", "Asian Pharmaceuticals", "Tab", "500 mg"),
                BrandInfo("Metformin-NPL", "Nepal Pharmaceuticals Lab", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Glycomet", "USV Pvt. Ltd.", "SR Tab", "500 / 850 / 1000 mg"),
                BrandInfo("Obimet", "Abbott India", "Tab", "500 mg"),
                BrandInfo("Glycinorm-M", "Ipca Laboratories", "Combo Tab", "500 mg Combo"),
                BrandInfo("Glucophage", "Merck Specialities", "Tab", "500 mg / 850 mg")
            )
        ),
        Drug(
            id = "d4",
            genericName = "Paracetamol (Acetaminophen)",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Non-opioid Analgesic & Antipyretic",
            blackBoxWarning = "HEPATOTOXICITY: Paracetamol has been associated with cases of acute liver failure, at times resulting in liver transplant and death. Most cases are associated with doses exceeding 4,000 mg per day or co-administration of multiple paracetamol-containing products.",
            indications = "Fever, mild-to-moderate pain, osteoarthritis, acute headache, post-vaccination febrile episodes.",
            doses = "Adult: 500-1000 mg PO/IV q4-6h PRN (Max 4000 mg/24h). In chronic alcoholics/malnourished: Max 2000-3000 mg/day.\nPediatric: 10-15 mg/kg/dose PO q4-6h PRN (Max 60 mg/kg/day).",
            administration = "Oral, rectal suppository, or intravenous infusion over 15 minutes.",
            timing = "As needed with minimum 4-hour spacing between doses.",
            specialInstructions = "Always check combination cough/cold or pain syrups to prevent accidental cumulative overdose.",
            pkPd = "Bioavailability ~88%. Rapid GI absorption. Hepatic metabolism via glucuronidation and sulfation (~90%); 5-10% CYP2E1 oxidation to toxic metabolite NAPQI, detoxified by glutathione. Half-life ~2 hours.",
            renalAdj = "CrCl 10-50 mL/min: Increase interval to q6h. CrCl <10 mL/min: Increase interval to q8h.",
            hepaticAdj = "Use with extreme caution. In severe hepatic impairment or cirrhosis: Max 2000 mg/day. Contraindicated in acute active hepatic failure.",
            pregnancy = "Category B (Drug of choice for fever and pain in pregnancy)",
            lactation = "Compatible with breastfeeding (AAP approved).",
            sideEffects = "Hepatotoxicity (dose-dependent), allergic rash, urticaria, rare thrombocytopenia or neutropenia.",
            priceNpr = "NPR 1.00 - 2.50 per tab (500mg)",
            priceInr = "INR 0.80 - 2.20 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Cetamol", "Nepal Aushadhi Limited", "Tab / Syr", "500 mg / 125mg/5ml"),
                BrandInfo("Pyrex", "Lomus Pharmaceuticals", "Tab", "650 mg"),
                BrandInfo("Paracip-N", "National Healthcare", "Syr", "125mg/5ml"),
                BrandInfo("Paragesic", "Quest Pharmaceuticals", "Tab", "500 mg / 650 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Dolo 650", "Micro Labs Ltd.", "Tab", "650 mg"),
                BrandInfo("Calpol", "GlaxoSmithKline India", "Tab / Syr", "500 mg / 650 mg / 250mg"),
                BrandInfo("Crocin", "Haleon India", "Tab", "650 mg"),
                BrandInfo("Pacimol", "Ipca Laboratories", "Infusion", "1000mg/100ml IV")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "PO q4-6h PRN"
        ),
        Drug(
            id = "d5",
            genericName = "Azithromycin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Macrolide Antibiotic (Azalide)",
            blackBoxWarning = null,
            indications = "Community-acquired pneumonia (CAP), Acute bacterial exacerbation of COPD, Pharyngitis/Tonsillitis, Enteric fever (Typhoid), Chlamydia trachomatis urethritis/cervicitis, Skin and soft tissue infections.",
            doses = "Adult: 500 mg PO Day 1, then 250 mg PO OD Days 2-5 (or 500 mg PO OD for 3-5 days). Typhoid fever: 1 g PO OD for 5-7 days.\nPediatric: 10 mg/kg PO Day 1, then 5 mg/kg PO OD Days 2-5.",
            administration = "Can be taken with or without food. Tablets may be taken with food to reduce GI upset; oral suspension preferred on empty stomach.",
            timing = "Once daily at the same time.",
            specialInstructions = "Avoid co-administration with aluminum or magnesium antacids (delays absorption). Caution in patients with pre-existing QT prolongation or uncorrected hypokalemia.",
            pkPd = "Bioavailability ~37%. Massive tissue distribution (volume of distribution ~31 L/kg). Concentrates inside macrophages. Biliary elimination. Terminal half-life 68 hours.",
            renalAdj = "No dose adjustment required in mild to moderate renal impairment (CrCl ≥10 mL/min). Exercise caution with severe renal impairment (CrCl <10 mL/min).",
            hepaticAdj = "Caution in patients with severe hepatic impairment; excreted primarily via biliary system. Monitor LFTs.",
            pregnancy = "Category B (Safe when clearly indicated; no evidence of fetal harm)",
            lactation = "Present in breast milk in small amounts; safe for use during breastfeeding. Observe infant for gastrointestinal effects.",
            sideEffects = "Nausea, abdominal cramps, diarrhea, vomiting, flatulence, headache, dizziness, QT prolongation, rare cholestatic jaundice.",
            priceNpr = "NPR 35.00 per tab (500mg)",
            priceInr = "INR 22.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Azi Mx", "Doctor Tims Pharmaceuticals Ltd.", "Tablet", "500 mg"),
                BrandInfo("Azi Mx", "Doctor Tims Pharmaceuticals Ltd.", "Powder for Suspension", "200 mg/5 ml"),
                BrandInfo("Azith", "Deurali-Janta Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Zithro", "Lomus Pharmaceuticals", "Tablet / Syr", "500 mg / 200mg/5ml"),
                BrandInfo("Azithral-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Azee", "Cipla Ltd.", "Tablet / Suspension", "250 / 500 mg"),
                BrandInfo("Azithral", "Alembic Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Zady", "Mankind Pharma", "Tablet", "500 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "Day 1 (then 5mg/kg OD Days 2-5)",
            adultDose = "• Standard respiratory / skin infections: 500 mg PO on Day 1, followed by 250 mg PO once daily on Days 2–5 (or 500 mg PO once daily for 3 days).\n• Typhoid fever: 1 g PO once daily for 5–7 days.\n• Chlamydia trachomatis genital infections: 1 g PO as a single dose.\n• Severe community-acquired pneumonia: 500 mg IV once daily for at least 2 days, then switched to 500 mg PO once daily to complete a 7–10 day course.",
            childDose = "• Pediatric patients (≥6 months):\n  - Day 1: 10 mg/kg PO once daily (Max: 500 mg/day)\n  - Days 2–5: 5 mg/kg PO once daily (Max: 250 mg/day)\n• Acute otitis media: 30 mg/kg as single dose, or 10 mg/kg once daily for 3 days.\n• Pharyngitis/Tonsillitis: 12 mg/kg PO once daily for 5 days.",
            contraindications = "• Known hypersensitivity to azithromycin, erythromycin, or any macrolide/ketolide antibiotic.\n• History of cholestatic jaundice or hepatic dysfunction associated with prior azithromycin use.\n• Co-administration with pimozide, ergotamine, or dihydroergotamine.",
            modeOfAction = "Binds reversibly to the 23S rRNA of the 50S ribosomal subunit of susceptible microorganisms, inhibiting transpeptidation and protein synthesis. Concentrates within lysosomal compartments of phagocytes and fibroblasts, providing sustained intracellular concentrations at infection sites.",
            interactions = "• Antacids containing aluminum or magnesium: Reduce Cmax by 24% (space by ≥2 hours).\n• QT-prolonging drugs (amiodarone, sotalol, fluoroquinolones): Increased risk of torsades de pointes.\n• Warfarin / oral anticoagulants: May potentiate anticoagulation effect; monitor INR.\n• Digoxin: May increase serum digoxin levels by inhibiting P-glycoprotein.",
            packSize = "Blister pack of 3 / 6 tablets (500mg); 15ml / 30ml bottle (200mg/5ml suspension)",
            precautions = "• QT prolongation and risk of ventricular arrhythmia / torsades de pointes.\n• Hepatotoxicity: Abnormal liver function tests, hepatitis, and rare fulminant hepatic necrosis.\n• Clostridioides difficile-associated diarrhea (CDAD) ranging from mild diarrhea to fatal colitis.\n• Exacerbation of muscle weakness in myasthenia gravis."
        ),
        Drug(
            id = "d6",
            genericName = "Pantoprazole",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Proton Pump Inhibitor (PPI)",
            blackBoxWarning = null,
            indications = "GERD, Erosive Esophagitis, Peptic Ulcer Disease (Gastric & Duodenal), NSAID-induced ulcer prophylaxis, Zollinger-Ellison syndrome, Upper GI bleed.",
            doses = "Adult: 40 mg PO OD in morning 30-60 min before breakfast. Zollinger-Ellison: 80-160 mg/day.\nUpper GI Bleed: 80 mg IV bolus, then 8 mg/hour continuous infusion for 72h.",
            administration = "Take orally 30-60 minutes before breakfast. Swallow whole; do not split, chew, or crush enteric-coated tablets.",
            timing = "Early morning on an empty stomach.",
            specialInstructions = "Long-term therapy (>1 year) increases risk of hypomagnesemia, Clostridioides difficile colitis, and osteoporotic fractures.",
            pkPd = "Bioavailability ~77%. Protein binding 98%. Hepatic metabolism via CYP2C19 & CYP3A4. Excreted in urine (~80%) and feces. Elimination half-life ~1 hour, but irreversibly inhibits H+/K+ ATPase for >24 hours.",
            renalAdj = "No dose adjustment required in renal impairment or hemodialysis.",
            hepaticAdj = "Mild-to-moderate: No adjustment. Severe cirrhosis: Max 40 mg every other day or 20 mg daily.",
            pregnancy = "Category B (Preferred PPI in pregnancy)",
            lactation = "Excreted in low levels; considered safe.",
            sideEffects = "Headache, diarrhea, nausea, flatulence, abdominal pain, hypomagnesemia (chronic), B12 deficiency (long-term).",
            priceNpr = "NPR 6.00 - 12.00 per tab (40mg)",
            priceInr = "INR 4.50 - 9.00 per tab (40mg)",
            brandsNepal = listOf(
                BrandInfo("Pantop-NPL", "Nepal Pharmaceuticals Lab", "Tab / Inj", "40 mg"),
                BrandInfo("Pantocid-N", "Deurali-Janta Pharmaceuticals", "Tab", "40 mg"),
                BrandInfo("Pan-D (Combo)", "Alkem Nepal", "Tab", "40 mg + 30mg Dom")
            ),
            brandsIndia = listOf(
                BrandInfo("Pan-40", "Alkem Laboratories", "Tab / Inj", "40 mg"),
                BrandInfo("Pantocid", "Sun Pharma", "Tab", "40 mg"),
                BrandInfo("Pantodac", "Zydus Healthcare", "Tab", "40 mg")
            )
        ),
        Drug(
            id = "d7",
            genericName = "Atorvastatin",
            system = "Cardiovascular System (CVS)",
            drugClass = "HMG-CoA Reductase Inhibitor (Statin)",
            blackBoxWarning = null,
            indications = "Primary Hypercholesterolemia, Mixed Dyslipidemia, Prevention of Cardiovascular Disease in high-risk patients, Post-ACS / Post-MI secondary prevention.",
            doses = "Adult: 10-80 mg PO once daily at night. High-intensity statin therapy: 40-80 mg OD. Moderate-intensity: 10-20 mg OD.",
            administration = "Take orally once daily with or without food, preferred at bedtime.",
            timing = "Evening / Bedtime.",
            specialInstructions = "Advise patient to promptly report unexplained muscle pain, tenderness, or weakness (rhabdomyolysis risk). Check baseline LFTs.",
            pkPd = "Extensive first-pass hepatic extraction. Bioavailability 14%. Bound to plasma proteins ≥98%. Metabolized by CYP3A4 to active ortho- and parahydroxylated metabolites. Biliary elimination >98%. Half-life 14h.",
            renalAdj = "No dose adjustment required in renal impairment.",
            hepaticAdj = "Contraindicated in active liver disease or unexplained persistent elevations of hepatic transaminases.",
            pregnancy = "Category X (Strictly Contraindicated)",
            lactation = "Contraindicated in nursing mothers due to potential disruption of infant lipid synthesis.",
            sideEffects = "Myalgia, arthralgia, elevated ALT/AST, dyspepsia, insomnia, rarely rhabdomyolysis, slight elevation of HbA1c.",
            priceNpr = "NPR 10.00 - 22.00 per tab (20mg)",
            priceInr = "INR 8.00 - 18.00 per tab (20mg)",
            brandsNepal = listOf(
                BrandInfo("Atorlip", "Deurali-Janta Pharmaceuticals", "Tab", "10 / 20 / 40 mg"),
                BrandInfo("Storvas-N", "Ranbaxy Nepal", "Tab", "10 / 20 mg"),
                BrandInfo("Atorest", "Quest Pharmaceuticals", "Tab", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Atorva", "Zydus Cadila", "Tab", "10 / 20 / 40 / 80 mg"),
                BrandInfo("Lipitor", "Pfizer India", "Tab", "10 / 20 / 40 mg"),
                BrandInfo("Tonact", "Lupin Ltd.", "Tab", "10 / 20 / 40 mg"),
                BrandInfo("Atocor", "Dr. Reddy's Laboratories", "Tab", "20 mg")
            )
        ),
        Drug(
            id = "d8",
            genericName = "Amlodipine Besylate",
            system = "Cardiovascular System (CVS)",
            drugClass = "Dihydropyridine Calcium Channel Blocker (CCB)",
            blackBoxWarning = null,
            indications = "Essential Hypertension, Chronic Stable Angina, Vasospastic (Prinzmetal) Angina.",
            doses = "Adult: 2.5 - 10 mg PO once daily. Usual starting dose: 5 mg PO OD. Elderly or fragile: 2.5 mg OD.",
            administration = "Oral tablet once daily with or without food.",
            timing = "Consistent time daily, morning or bedtime.",
            specialInstructions = "Warn patient about dose-dependent pedal/ankle edema. Not related to fluid overload, caused by selective precapillary arteriolar vasodilation.",
            pkPd = "Bioavailability 64-90%. Protein binding ~97.5%. Hepatically metabolized via CYP3A4 to inactive metabolites. Elimination half-life 30-50 hours.",
            renalAdj = "No dose adjustment required in renal dysfunction or dialysis.",
            hepaticAdj = "Initiate at 2.5 mg PO OD due to extended clearance and slower hepatic metabolism.",
            pregnancy = "Category C (Use only if potential benefit justifies potential risk to fetus)",
            lactation = "Excreted into breast milk; usually well-tolerated, but monitor infant for hypotension.",
            sideEffects = "Peripheral edema (ankle swelling), flushing, headache, dizziness, palpitations, gingival hyperplasia (rare).",
            priceNpr = "NPR 3.50 - 7.50 per tab (5mg)",
            priceInr = "INR 2.50 - 6.00 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Amlopin", "Nepal Pharmaceuticals Lab", "Tab", "5 mg / 10 mg"),
                BrandInfo("Amcard", "Deurali-Janta Pharmaceuticals", "Tab", "5 mg"),
                BrandInfo("Amlopress-N", "Asian Pharmaceuticals", "Tab", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Stamlo", "Dr. Reddy's Laboratories", "Tab", "2.5 / 5 / 10 mg"),
                BrandInfo("Amlong", "Micro Labs Ltd.", "Tab", "5 mg"),
                BrandInfo("Amlopres", "Cipla Ltd.", "Tab", "5 mg / 10 mg")
            )
        ),
        Drug(
            id = "d9",
            genericName = "Salbutamol (Albuterol)",
            system = "Respiratory System (RS)",
            drugClass = "Short-Acting Beta-2 Adrenergic Agonist (SABA)",
            blackBoxWarning = null,
            indications = "Acute bronchospasm in bronchial asthma, COPD exacerbation, Exercise-induced bronchospasm prophylaxis, Acute hyperkalemia (high dose nebulization).",
            doses = "MDI Inhaler: 1-2 puffs (100-200 mcg) q4-6h PRN.\nNebulization: 2.5 - 5 mg in 3 mL normal saline q20min x 3 doses in acute severe asthma.\nPediatric: 0.15 mg/kg nebulized (minimum 1.25 mg).",
            administration = "Inhaled via metered dose inhaler (MDI) with spacer or air-driven nebulizer.",
            timing = "PRN for acute breathlessness or 15 minutes before exercise.",
            specialInstructions = "Use a spacer chamber for MDIs to dramatically increase pulmonary drug deposition and decrease oropharyngeal impaction.",
            pkPd = "Onset of action within 5 minutes. Peak effect 1-2 hours. Duration 4-6 hours. Sulfoconjugated in liver and tissues. Half-life 3.8-5 hours.",
            renalAdj = "No dose adjustment required for inhaled routes.",
            hepaticAdj = "No dose adjustment required for inhaled routes.",
            pregnancy = "Category C (Preferred rescue bronchodilator during pregnancy)",
            lactation = "Compatible with breastfeeding due to low systemic absorption via inhaler.",
            sideEffects = "Fine skeletal muscle tremor (especially hands), tachycardia, palpitations, nervousness, transient hypokalemia, headache.",
            priceNpr = "NPR 250.00 - 350.00 per MDI canister (200 doses)",
            priceInr = "INR 120.00 - 200.00 per MDI canister",
            brandsNepal = listOf(
                BrandInfo("Asthalin-N", "Deurali-Janta Pharmaceuticals", "Inhaler / Respule", "100 mcg / 2.5mg"),
                BrandInfo("Salbutol", "Nepal Pharmaceuticals Lab", "Inhaler", "100 mcg"),
                BrandInfo("Ventorlin", "Lomus Pharmaceuticals", "Inhaler", "100 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Asthalin", "Cipla Ltd.", "Inhaler / Respules", "100 mcg / 2.5mg / 5mg"),
                BrandInfo("Aerolin", "GlaxoSmithKline India", "Inhaler", "100 mcg"),
                BrandInfo("Derihaler", "Zydus Healthcare", "Inhaler", "100 mcg")
            ),
            pediatricDosePerKg = 0.15,
            pediatricInterval = "mg/kg nebulized"
        ),
        Drug(
            id = "d10",
            genericName = "Ciprofloxacin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Second-Generation Fluoroquinolone",
            blackBoxWarning = "SERIOUS ADVERSE REACTIONS: Tendinitis and tendon rupture (most commonly Achilles tendon), peripheral neuropathy, and CNS toxicities (hallucinations, seizures, suicidal thoughts). Avoid in patients with myasthenia gravis.",
            indications = "Complicated UTI, Acute pyelonephritis, Infectious diarrhea (Shigellosis, Campylobacter), Typhoid fever, Prostatitis, Hospital-acquired pneumonia.",
            doses = "Adult: 500-750 mg PO q12h OR 400 mg IV q12h. Uncomplicated UTI: 250-500 mg PO q12h x 3 days.",
            administration = "Oral tablets taken with water. Take at least 2 hours before or 6 hours after dairy, calcium, iron, magnesium antacids.",
            timing = "Every 12 hours.",
            specialInstructions = "Ensure adequate patient hydration to avoid crystalluria. Discontinue immediately if pain, swelling, or inflammation of a tendon occurs.",
            pkPd = "Bioavailability ~70%. High tissue and urinary penetration. Inhibits DNA gyrase and topoisomerase IV. Renally excreted (40-50% unchanged). Half-life ~4 hours.",
            renalAdj = "CrCl 30-50 mL/min: 250-500 mg PO q12h. CrCl <30 mL/min: 250-500 mg PO q18-24h. Hemodialysis: 250-500 mg q24h post-dialysis.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category C (Avoid in pregnancy due to cartilage damage in juvenile animal studies)",
            lactation = "Excreted in human milk; avoid or withhold breastfeeding during therapy.",
            sideEffects = "Nausea, diarrhea, tendon rupture, QT prolongation, dizziness, phototoxicity, pseudomembranous colitis.",
            priceNpr = "NPR 8.00 - 16.00 per tab (500mg)",
            priceInr = "INR 5.00 - 12.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Ciprolet-N", "Deurali-Janta Pharmaceuticals", "Tab / Eye Drop", "500 mg / 0.3%"),
                BrandInfo("Cifran-NPL", "Nepal Pharmaceuticals Lab", "Tab", "500 mg"),
                BrandInfo("Neocip", "Quest Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ciplox", "Cipla Ltd.", "Tab / IV", "500 mg / 200mg IV"),
                BrandInfo("Cifran", "Sun Pharma", "Tab", "250 / 500 mg"),
                BrandInfo("Ciprobid", "Zydus Cadila", "Tab", "500 mg")
            )
        ),
        Drug(
            id = "d11",
            genericName = "Ceftriaxone Sodium",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Third-Generation Cephalosporin",
            blackBoxWarning = null,
            indications = "Bacterial meningitis, Community-acquired pneumonia (inpatient), Pyelonephritis, Intra-abdominal sepsis, Typhoid fever, Gonorrhea.",
            doses = "Adult: 1 - 2 g IV/IM once daily (q24h). Meningitis: 2 g IV q12h.\nPediatric: 50-75 mg/kg/day IV/IM OD (Meningitis: 100 mg/kg/day divided q12h).",
            administration = "IV infusion over 30 minutes or deep IM injection reconstituted with 1% lidocaine to minimize injection pain.",
            timing = "Once daily (or q12h in meningitis).",
            specialInstructions = "CONTRAINDICATION: Never co-administer or flush with calcium-containing IV solutions (e.g., Ringer's Lactate) due to risk of fatal ceftriaxone-calcium salt precipitation in lungs and kidneys.",
            pkPd = "Elimination half-life 6-9 hours (permits once daily dosing). Protein binding 85-95%. Dual elimination: 60% renal and 40% biliary/fecal excretion.",
            renalAdj = "No dose adjustment necessary if hepatic function is normal. Max 2g/day in severe combined renal and hepatic dysfunction.",
            hepaticAdj = "No dose adjustment necessary if renal function is normal.",
            pregnancy = "Category B (Safe and widely used)",
            lactation = "Excreted into breast milk in low concentrations; compatible with breastfeeding.",
            sideEffects = "Diarrhea, biliary sludging (pseudolithiasis, reversible), elevated ALT/AST, injection site phlebitis, eosinophilia.",
            priceNpr = "NPR 120.00 - 220.00 per vial (1g Inj)",
            priceInr = "INR 60.00 - 130.00 per vial (1g Inj)",
            brandsNepal = listOf(
                BrandInfo("Powercef", "Deurali-Janta Pharmaceuticals", "Vial Inj", "1 g / 2 g"),
                BrandInfo("C-Tri", "Nepal Pharmaceuticals Lab", "Vial Inj", "1 g"),
                BrandInfo("Cefrone", "Quest Pharmaceuticals", "Vial Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Monocef", "Aristo Pharmaceuticals", "Vial Inj", "500mg / 1g / 2g"),
                BrandInfo("Oframax", "Sun Pharma", "Vial Inj", "1 g"),
                BrandInfo("Xone", "Alkem Laboratories", "Vial Inj", "1 g")
            ),
            pediatricDosePerKg = 75.0,
            pediatricInterval = "mg/kg/day IV/IM OD"
        ),
        Drug(
            id = "d12",
            genericName = "Tramadol Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Centrally Acting Synthetic Opioid Analgesic",
            blackBoxWarning = "ADDICTION, ABUSE, AND MISUSE: Tramadol exposes patients to risks of opioid addiction and overdose. Accidental ingestion, especially by children, can result in fatal respiratory depression. Concomitant use with benzodiazepines or CNS depressants causes profound sedation, coma, or death.",
            indications = "Moderate to moderately severe acute and chronic pain (post-operative pain, trauma, orthopedic pain).",
            doses = "Adult: 50-100 mg PO/IV/IM q4-6h PRN (Maximum 400 mg/day). Elderly >75 yrs: Max 300 mg/day.",
            administration = "Oral, slow IV injection over 2-3 minutes, or IM injection.",
            timing = "As needed with minimum 4-6 hour intervals.",
            specialInstructions = "High risk of Serotonin Syndrome when combined with SSRIs, SNRIs, or MAOIs. Lower seizure threshold in epilepsy patients.",
            pkPd = "Dual mechanism: Mu-opioid receptor agonist and weak inhibitor of norepinephrine and serotonin reuptake. Metabolized via CYP2D6 to active metabolite M1. Half-life ~6 hours.",
            renalAdj = "CrCl <30 mL/min: Increase interval to q12h (Max 200 mg/day). Dialysis patients: Max 100 mg/day on dialysis days.",
            hepaticAdj = "Cirrhosis: 50 mg PO q12h (decreased clearance). Severe hepatic impairment: Contraindicated.",
            pregnancy = "Category C (Opioid withdrawal symptoms in neonate upon prolonged maternal use)",
            lactation = "Avoid during breastfeeding due to risk of serious infant respiratory depression.",
            sideEffects = "Dizziness, nausea, vomiting, constipation, somnolence, sweating, seizure risk, respiratory depression at toxic doses.",
            priceNpr = "NPR 6.00 - 14.00 per cap/tab (50mg)",
            priceInr = "INR 4.00 - 10.00 per tab (50mg)",
            brandsNepal = listOf(
                BrandInfo("Tramacip-N", "Deurali-Janta Pharmaceuticals", "Cap / Inj", "50 mg / 100mg/2ml"),
                BrandInfo("Dolotram", "Nepal Pharmaceuticals Lab", "Cap", "50 mg"),
                BrandInfo("Trapex", "Quest Pharmaceuticals", "Tab", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tramazac", "Zydus Cadila", "Cap / Inj", "50 mg / 100mg"),
                BrandInfo("Ultracet (Combo)", "Johnson & Johnson India", "Tab", "37.5mg Tramadol + 325mg Paracetamol"),
                BrandInfo("Contramal", "Abbott India", "Tab / Inj", "50 mg / 100mg")
            )
        )
    )

    val diseaseProtocols: List<DiseaseProtocol> = listOf(
        DiseaseProtocol(
            id = "dp1",
            name = "Community-Acquired Pneumonia (CAP)",
            category = "Respiratory & Infectious",
            firstLine = "Outpatient (No comorbidities): Amoxicillin 1 g PO TID x 5-7 days OR Azithromycin 500 mg PO Day 1 then 250 mg OD x 4 days.",
            secondLine = "Outpatient (With comorbidities/smoker/elderly): Amoxicillin-Clavulanate 625 mg PO TID + Azithromycin 500 mg PO OD x 5-7 days OR Levofloxacin 750 mg PO OD.",
            inpatient = "Non-severe Inpatient: Ceftriaxone 1-2 g IV OD + Azithromycin 500 mg IV/PO OD.\nSevere ICU Admission: Ceftriaxone 2 g IV OD + Azithromycin 500 mg IV OD + consideration of Piperacillin-Tazobactam if pseudomonas risk.",
            guidelines = "ATS/IDSA Guidelines 2019, WHO Essential Medicine Protocols & Harrison's 21st Edition."
        ),
        DiseaseProtocol(
            id = "dp2",
            name = "Essential Hypertension",
            category = "Cardiovascular",
            firstLine = "Stage 1 (BP 130-139 / 80-89 mmHg): Lifestyle modification x 3 months. If unresolved or Stage 2 (≥140/90 mmHg): Telmisartan 40 mg PO OD OR Amlodipine 5 mg PO OD.",
            secondLine = "Dual Combination Therapy: Telmisartan 40 mg + Amlodipine 5 mg FDC PO OD. If uncontrolled: Add Chlorthalidone 12.5 mg OD.",
            inpatient = "Hypertensive Emergency (BP >180/120 with target organ damage): Labetalol IV infusion (20 mg bolus, then 40-80 mg q10min or 1-2 mg/min infusion) OR Nicardipine IV. Goal: Reduce MAP by no more than 25% over the first hour.",
            guidelines = "ACC/AHA 2017 & ESC/ESH 2023 Guidelines for the Management of Arterial Hypertension."
        ),
        DiseaseProtocol(
            id = "dp3",
            name = "Acute Paracetamol Toxicity",
            category = "Emergency Toxicology",
            firstLine = "N-Acetylcysteine (NAC) IV 3-bag protocol: 150 mg/kg IV over 60 min, then 50 mg/kg over 4 hours, then 100 mg/kg over 16 hours. Or Oral NAC 140 mg/kg load then 70 mg/kg q4h x 17 doses.",
            secondLine = "Activated Charcoal 1 g/kg (max 50 g) orally if presentation is within 1-2 hours of ingestion and airway is secure.",
            inpatient = "Assess Rumack-Matthew nomogram at 4h post-ingestion. Monitor LFTs, INR, Serum Creatinine, Blood Gas (Lactate), and arterial pH every 12 hours. Consult Liver Transplant team if King's College Criteria are met (pH <7.30 or INR >6.5 + Cr >3.4 mg/dL + encephalopathy).",
            guidelines = "WHO Toxicology Protocols & Rumack-Matthew Nomogram."
        ),
        DiseaseProtocol(
            id = "dp4",
            name = "Type 2 Diabetes Mellitus",
            category = "Endocrine & Metabolic",
            firstLine = "Metformin 500 mg PO BID with meals, titrate weekly up to 1000 mg BID. Target HbA1c <7.0% (<53 mmol/mol). Lifestyle: 150 min/wk moderate exercise + dietary control.",
            secondLine = "If HbA1c remains >7.0% after 3 months: Add SGLT2 inhibitor (Dapagliflozin 10 mg OD) or DPP-4 inhibitor (Sitagliptin 100 mg OD). If ASCVD or CKD present: prioritize SGLT2i or GLP-1 RA.",
            inpatient = "Diabetic Ketoacidosis (DKA) / HHS: Normal Saline IV fluid resuscitation (1-1.5 L in 1st hour) + Regular Insulin IV infusion at 0.1 units/kg/hour once potassium is ≥3.3 mEq/L. Maintain blood glucose 150-200 mg/dL with 5% Dextrose infusion once glucose drops <250 mg/dL.",
            guidelines = "American Diabetes Association (ADA) Standards of Care 2024 & WHO Package of Essential NCD Interventions."
        ),
        DiseaseProtocol(
            id = "dp5",
            name = "Acute Exacerbation of COPD",
            category = "Respiratory",
            firstLine = "Nebulized Salbutamol 2.5-5 mg + Ipratropium 500 mcg q20-30 min x 3 doses, then q2-4h PRN. Controlled oxygen via Venturi mask (target SpO2 88-92% to prevent hypercapnic respiratory arrest).",
            secondLine = "Oral Prednisolone 40 mg PO once daily for 5 days. Add Antibiotics (Amoxicillin-Clavulanate 625 mg TID or Azithromycin 500 mg OD x 5 days) if Anthonisen criteria met (increased dyspnea, sputum volume, sputum purulence).",
            inpatient = "Non-invasive positive pressure ventilation (BiPAP/NIV) for acute hypercapnic respiratory acidosis (pH <7.35, PaCO2 >45 mmHg). Intubate if NIV fails or GCS deteriorates.",
            guidelines = "GOLD 2024 Global Strategy for Prevention, Diagnosis and Management of COPD."
        ),
        DiseaseProtocol(
            id = "dp6",
            name = "Uncomplicated Urinary Tract Infection (Acute Cystitis)",
            category = "Renal & Genitourinary",
            firstLine = "Nitrofurantoin Monohydrate/Macrocrystals 100 mg PO BID with meals x 5 days OR Fosfomycin Trometamol 3 g PO single dose.",
            secondLine = "Amoxicillin-Clavulanate 625 mg PO BID x 5-7 days OR Ciprofloxacin 500 mg PO BID x 3 days (reserve fluoroquinolones for complicated cases).",
            inpatient = "Acute Pyelonephritis (Inpatient): Ceftriaxone 1 g IV OD for 10-14 days or Ciprofloxacin 400 mg IV q12h. Switch to oral antibiotics once afebrile for 48 hours.",
            guidelines = "IDSA Guidelines for Treatment of Uncomplicated Cystitis and Pyelonephritis."
        ),
        DiseaseProtocol(
            id = "dp7",
            name = "Organophosphate / Carbamate Poisoning",
            category = "Emergency Toxicology",
            firstLine = "Airway de-escalation & decontamination (remove contaminated clothing, copious skin washing). Atropine Sulfate 2 to 5 mg IV push immediately; repeat doubling dose every 5-10 minutes until ATROPINIZATION achieved: clear chest on auscultation (no crackles/bronchorrhea), HR >80 bpm, systolic BP >90 mmHg, dry axillae.",
            secondLine = "Pralidoxime (2-PAM) 1 to 2 g IV in 100 mL NS over 30 minutes, followed by continuous infusion of 500 mg/hour until recovery (effective only if given within 24-48h before oxime aging occurs).",
            inpatient = "Maintain intensive atropine infusion. Watch for Intermediate Syndrome (cranial nerve palsies, neck flexion weakness, diaphragmatic failure 24-96h post-ingestion) requiring mechanical ventilation.",
            guidelines = "WHO Inter-Regional Clinical Toxicology & Critical Care Management Protocols."
        )
    )

    val antidotes: List<Antidote> = listOf(
        Antidote(
            id = "a1",
            poison = "Paracetamol (Acetaminophen)",
            antidote = "N-Acetylcysteine (NAC)",
            dosing = "IV Loading: 150 mg/kg in 200 mL D5W over 60 min, then 50 mg/kg in 500 mL D5W over 4 hours, then 100 mg/kg in 1000 mL D5W over 16 hours. (Total 300 mg/kg over 21 hours).",
            notes = "Maximum efficacy when started within 8 hours of ingestion, but beneficial at any time until clinical recovery. Replenishes hepatic glutathione stores to neutralize toxic NAPQI.",
            urgency = "CRITICAL (<8 Hours)"
        ),
        Antidote(
            id = "a2",
            poison = "Opioids (Morphine, Heroin, Tramadol, Fentanyl)",
            antidote = "Naloxone Hydrochloride",
            dosing = "0.4 mg to 2.0 mg IV / IM / SC / Intranasal. Repeat every 2-3 minutes up to 10 mg until spontaneous ventilation returns.",
            notes = "Target is return of spontaneous respiratory effort (>10-12 breaths/min), not full alertness. Naloxone half-life (30-90 min) is shorter than most opioids; monitor for recurrence of respiratory depression.",
            urgency = "IMMEDIATE (Emergency)"
        ),
        Antidote(
            id = "a3",
            poison = "Organophosphates & Carbamates (Insecticides)",
            antidote = "Atropine Sulfate + Pralidoxime (2-PAM)",
            dosing = "Atropine: 2-5 mg IV bolus; repeat every 5-10 min doubling dose until lungs are clear. 2-PAM: 1-2 g IV infusion over 30 min, then 8 mg/kg/hr infusion.",
            notes = "Prioritize atropine (reverses life-threatening killer 'B's: Bronchorrhea, Bronchospasm, Bradycardia). Dilated pupils are NOT a sign of atropinization; clear chest and dry secretions are primary endpoints.",
            urgency = "IMMEDIATE (Emergency)"
        ),
        Antidote(
            id = "a4",
            poison = "Benzodiazepines (Diazepam, Alprazolam, Midazolam)",
            antidote = "Flumazenil",
            dosing = "0.2 mg IV over 30 seconds. Wait 1 minute. If no response, give 0.3 mg IV over 30s. Further doses of 0.5 mg up to max 3 mg.",
            notes = "CONTRAINDICATION: Do NOT administer in known chronic benzodiazepine users or co-ingestion of tricyclic antidepressants (TCA); precipitates intractable withdrawal status epilepticus and fatal arrhythmias.",
            urgency = "HIGH (Caution with Seizures)"
        ),
        Antidote(
            id = "a5",
            poison = "Digoxin & Cardiac Glycosides",
            antidote = "Digoxin Immune Fab (DigiFab / Digibind)",
            dosing = "Empiric acute unknown toxicity: 10-20 vials IV over 30 min. Chronic toxicity: 3-6 vials IV based on serum digoxin level and patient weight.",
            notes = "Indicated in digoxin-induced life-threatening ventricular dysrhythmias or severe hyperkalemia (>5.0 mEq/L). Total digoxin levels will read falsely elevated post-administration.",
            urgency = "CRITICAL"
        ),
        Antidote(
            id = "a6",
            poison = "Snake Envenomation (Viper, Cobra, Krait)",
            antidote = "Polyvalent Anti-Snake Venom (ASV)",
            dosing = "Initial dose: 10 vials (100 mL) reconstituted in 500 mL Normal Saline IV infused over 1 hour. Repeat 5-10 vials if coagulopathy persists at 6 hours (20-minute whole blood clotting test 20WBCT).",
            notes = "Keep Epinephrine (1:1000), Chlorpheniramine, and Hydrocortisone drawn up at bedside to treat immediate anaphylactic reactions.",
            urgency = "IMMEDIATE (Life-Threatening)"
        ),
        Antidote(
            id = "a7",
            poison = "Beta-Blocker Overdose (Propranolol, Atenolol, Metoprolol)",
            antidote = "Glucagon IV + High-Dose Insulin Euglycemia (HIET)",
            dosing = "Glucagon: 5 to 10 mg IV push over 1-2 min, followed by continuous infusion of 2-5 mg/hour. HIET: Regular Insulin 1 unit/kg IV bolus + 1 unit/kg/hr infusion with 10-25% Dextrose titration.",
            notes = "Glucagon activates myocardial adenylate cyclase bypassing blocked beta-1 receptors. HIET provides inotropic support by improving myocardial carbohydrate substrate uptake.",
            urgency = "HIGH"
        ),
        Antidote(
            id = "a8",
            poison = "Calcium Channel Blocker Overdose (Amlodipine, Verapamil, Diltiazem)",
            antidote = "Calcium Gluconate 10% + High-Dose Insulin (HIET)",
            dosing = "10% Calcium Gluconate 30-60 mL IV over 10-15 minutes (or 10% Calcium Chloride 10-20 mL via central line). High-Dose Insulin 1 unit/kg bolus then 1 unit/kg/hour with glucose maintenance.",
            notes = "Maintain blood glucose between 150-250 mg/dL and monitor serum potassium every 1 hour during HIET.",
            urgency = "HIGH"
        ),
        Antidote(
            id = "a9",
            poison = "Unfractionated Heparin Overdose",
            antidote = "Protamine Sulfate",
            dosing = "1 mg Protamine neutralizes approximately 100 units of Heparin given in the last 2 hours. Max single dose 50 mg IV slow infusion over 10 min.",
            notes = "Administer slowly to avoid severe hypotension, anaphylactoid shock, and pulmonary hypertension.",
            urgency = "HIGH"
        ),
        Antidote(
            id = "a10",
            poison = "Methanol & Ethylene Glycol (Toxic Alcohols)",
            antidote = "Fomepizole or Ethanol IV",
            dosing = "Fomepizole: 15 mg/kg IV loading over 30 min, then 10 mg/kg q12h x 4 doses. Ethanol: 10% solution in D5W loading 8 mL/kg over 60 min, maintenance 1-2 mL/kg/hr.",
            notes = "Inhibits alcohol dehydrogenase (ADH) preventing conversion to toxic formic acid or oxalic acid. Hemodialysis indicated if severe acidosis (pH <7.25) or visual impairment.",
            urgency = "CRITICAL"
        )
    )

    val interactions: List<com.example.data.model.DrugInteraction> = listOf(
        com.example.data.model.DrugInteraction(
            drug1Generic = "Amoxicillin + Potassium Clavulanate",
            drug2Generic = "Warfarin",
            severity = com.example.data.model.InteractionSeverity.SERIOUS,
            effect = "Significantly increased INR and risk of severe or fatal hemorrhage.",
            mechanism = "Eradication of vitamin K-producing normal gut microbiota by broad-spectrum penicillin enhances the anticoagulant effect of warfarin.",
            clinicalAction = "Monitor INR within 3-5 days of initiating antibiotic. Empirically reduce warfarin dose by 10-20% if prolonged therapy is required."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Amlodipine Besylate",
            drug2Generic = "Atorvastatin Calcium",
            severity = com.example.data.model.InteractionSeverity.MODERATE,
            effect = "Increased systemic exposure of statin; heightened risk of myopathy or rhabdomyolysis.",
            mechanism = "Weak inhibition of CYP3A4-mediated hepatic metabolism of statins by amlodipine.",
            clinicalAction = "Clinical monitoring for muscle pain, tenderness, or weakness. Limit concurrent simvastatin to 20 mg/day; monitor CPK if symptomatic."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Metformin Hydrochloride",
            drug2Generic = "Iodinated Radiocontrast",
            severity = com.example.data.model.InteractionSeverity.CONTRAINDICATED,
            effect = "Acute renal impairment leading to severe lactic acidosis.",
            mechanism = "Contrast-induced acute kidney injury (CI-AKI) impairs renal excretion of metformin, promoting toxic systemic accumulation.",
            clinicalAction = "Discontinue metformin 48 hours prior to or at time of procedure. Re-evaluate eGFR 48 hours post-procedure before resuming."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Ciprofloxacin Hydrochloride",
            drug2Generic = "Theophylline",
            severity = com.example.data.model.InteractionSeverity.CONTRAINDICATED,
            effect = "Theophylline toxicity, intractable cardiac arrhythmias, and life-threatening seizures.",
            mechanism = "Potent inhibition of hepatic cytochrome CYP1A2 by ciprofloxacin increases serum theophylline concentrations by 100-300%.",
            clinicalAction = "Avoid concurrent use. If mandatory, reduce theophylline dose by 50% and perform daily serum theophylline level monitoring."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Pantoprazole Sodium",
            drug2Generic = "Clopidogrel",
            severity = com.example.data.model.InteractionSeverity.MODERATE,
            effect = "Possible reduction in antiplatelet efficacy of clopidogrel.",
            mechanism = "CYP2C19 competitive inhibition. Note: Pantoprazole has the lowest CYP2C19 affinity among PPIs and is clinically preferred over Omeprazole.",
            clinicalAction = "Pantoprazole is preferred over omeprazole in patients on dual antiplatelet therapy (DAPT). Dose spacing by 12 hours may be utilized."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Paracetamol (Acetaminophen)",
            drug2Generic = "Chronic Alcohol / Isoniazid",
            severity = com.example.data.model.InteractionSeverity.SERIOUS,
            effect = "Accelerated hepatotoxicity at lower or therapeutic doses of paracetamol.",
            mechanism = "Induction of cytochrome CYP2E1 increases toxic NAPQI metabolite production while chronic malnutrition/alcohol depletes hepatic glutathione.",
            clinicalAction = "Cap maximum paracetamol daily dose to 2.0 grams (2000 mg) per 24 hours in chronic alcohol use or concurrent INH therapy."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Azithromycin Dihydrate",
            drug2Generic = "Ciprofloxacin Hydrochloride",
            severity = com.example.data.model.InteractionSeverity.SERIOUS,
            effect = "Additive QT interval prolongation and elevated risk of Torsades de Pointes (TdP) ventricular tachycardia.",
            mechanism = "Synergistic cardiac hERG potassium channel blockade delaying myocardial repolarization.",
            clinicalAction = "Avoid dual QT-prolonging regimen if possible. Perform baseline ECG (QTc) and correct serum potassium/magnesium before initiation."
        ),
        com.example.data.model.DrugInteraction(
            drug1Generic = "Amlodipine Besylate",
            drug2Generic = "Ciprofloxacin Hydrochloride",
            severity = com.example.data.model.InteractionSeverity.MODERATE,
            effect = "Exaggerated hypotension, bradycardia, and peripheral edema.",
            mechanism = "CYP3A4 inhibition by fluoroquinolones elevates serum amlodipine bioavailability.",
            clinicalAction = "Monitor blood pressure and heart rate closely during antibiotic course."
        )
    )

    fun findInteractions(selectedDrugIds: Set<String>): List<com.example.data.model.DrugInteraction> {
        if (selectedDrugIds.size < 2) return emptyList()
        val selectedDrugs = drugs.filter { selectedDrugIds.contains(it.id) }
        val results = mutableListOf<com.example.data.model.DrugInteraction>()

        for (i in 0 until selectedDrugs.size) {
            for (j in i + 1 until selectedDrugs.size) {
                val d1 = selectedDrugs[i]
                val d2 = selectedDrugs[j]

                val match = interactions.find {
                    (it.drug1Generic.contains(d1.genericName.split(" ").first(), ignoreCase = true) &&
                     it.drug2Generic.contains(d2.genericName.split(" ").first(), ignoreCase = true)) ||
                    (it.drug1Generic.contains(d2.genericName.split(" ").first(), ignoreCase = true) &&
                     it.drug2Generic.contains(d1.genericName.split(" ").first(), ignoreCase = true))
                }

                if (match != null) {
                    results.add(match)
                } else {
                    // Check for class-level interactions
                    if (d1.drugClass.contains("Beta-lactam") && d2.drugClass.contains("Macrolide") ||
                        d2.drugClass.contains("Beta-lactam") && d1.drugClass.contains("Macrolide")) {
                        results.add(
                            com.example.data.model.DrugInteraction(
                                drug1Generic = d1.genericName,
                                drug2Generic = d2.genericName,
                                severity = com.example.data.model.InteractionSeverity.MODERATE,
                                effect = "Potential bacteriostatic antagonism of bactericidal cell wall synthesis.",
                                mechanism = "Macrolides inhibit protein synthesis (bacteriostatic) which may blunt beta-lactam bactericidal action on actively dividing cells.",
                                clinicalAction = "Acceptable in severe atypical pneumonia (e.g. CAP guidelines), but monitor clinical response."
                            )
                        )
                    }
                }
            }
        }
        return results
    }

    fun getAllCompanies(): List<com.example.data.model.CompanyProfile> {
        val map = mutableMapOf<String, MutableList<com.example.data.model.CompanyDrugBrand>>()
        drugs.forEach { drug ->
            drug.brandsNepal.forEach { b ->
                if (b.company.isNotBlank()) {
                    map.getOrPut(b.company) { mutableListOf() }.add(
                        com.example.data.model.CompanyDrugBrand(drug, b, true)
                    )
                }
            }
            drug.brandsIndia.forEach { b ->
                if (b.company.isNotBlank()) {
                    map.getOrPut(b.company) { mutableListOf() }.add(
                        com.example.data.model.CompanyDrugBrand(drug, b, false)
                    )
                }
            }
        }
        return map.map { (compName, products) ->
            val hasNepal = products.any { it.isNepal }
            val hasIndia = products.any { !it.isNepal }
            val country = when {
                hasNepal && hasIndia -> "Nepal & India"
                hasNepal -> "Nepal 🇳🇵"
                else -> "India 🇮🇳"
            }
            com.example.data.model.CompanyProfile(compName, country, products)
        }.sortedBy { it.name }
    }
}
