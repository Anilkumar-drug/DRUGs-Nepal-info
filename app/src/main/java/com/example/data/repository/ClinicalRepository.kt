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

    private val baseDrugs: List<Drug> = listOf(
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
        ),
        Drug(
            id = "d13",
            genericName = "Telmisartan",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin II Receptor Blocker (ARB)",
            blackBoxWarning = "FETAL TOXICITY: When pregnancy is detected, discontinue Telmisartan as soon as possible. Drugs that act directly on the renin-angiotensin system can cause injury and death to the developing fetus.",
            indications = "Essential Hypertension, Cardiovascular Risk Reduction in patients unable to take ACE inhibitors.",
            doses = "Adult: 40-80 mg PO OD in the morning. Initial dose 40 mg OD; may titrate to 80 mg OD after 2-4 weeks.",
            administration = "Take orally once daily with or without food. Consistent timing preferred.",
            timing = "Morning, once daily.",
            specialInstructions = "Check baseline serum potassium and serum creatinine. Risk of hyperkalemia when combined with spironolactone or potassium supplements.",
            pkPd = "Oral bioavailability ~42-58%. Protein binding >99.5%. Long elimination half-life ~24 hours allowing true once-daily dosing. Excreted almost entirely via bile/feces (>98%).",
            renalAdj = "No initial dosage adjustment required in mild-to-moderate renal impairment. In severe impairment or hemodialysis: start at 20 mg OD.",
            hepaticAdj = "Use with caution in biliary obstructive disorders or hepatic insufficiency. Maximum dose 40 mg once daily.",
            pregnancy = "Category D (Strictly contraindicated in 2nd & 3rd trimesters)",
            lactation = "Not recommended; consider alternative antihypertensive agents (e.g. methyldopa, labetalol, nifedipine).",
            sideEffects = "Dizziness, lightheadedness, hyperkalemia, hypotension, sinusitis, back pain, diarrhea.",
            priceNpr = "NPR 12.00 - 24.00 per tab (40mg)",
            priceInr = "INR 8.00 - 18.00 per tab (40mg)",
            brandsNepal = listOf(
                BrandInfo("Telma-N", "Nepal Pharmaceuticals Lab", "Tab", "40 / 80 mg"),
                BrandInfo("Telpres", "Asian Pharmaceuticals", "Tab", "40 / 80 mg"),
                BrandInfo("Telsar", "Deurali-Janta Pharmaceuticals", "Tab", "40 mg"),
                BrandInfo("Telvas-NPL", "Quest Pharmaceuticals", "Tab", "40 mg"),
                BrandInfo("Telmi-Cure", "Curex Pharmaceuticals", "Tab", "40 / 80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Telma", "Glenmark Pharmaceuticals", "Tab", "40 / 80 mg"),
                BrandInfo("Telvas", "Aristo Pharmaceuticals", "Tab", "40 / 80 mg"),
                BrandInfo("Micardis", "Boehringer Ingelheim", "Tab", "40 / 80 mg"),
                BrandInfo("Telsartan", "Dr. Reddy's Laboratories", "Tab", "40 / 80 mg")
            ),
            adultDose = "40 mg to 80 mg PO once daily in morning.",
            childDose = "Safety and efficacy not established in pediatric patients.",
            contraindications = "Hypersensitivity to telmisartan. Concomitant use with aliskiren in patients with diabetes mellitus. 2nd & 3rd trimester of pregnancy.",
            modeOfAction = "Selectively blocks the binding of angiotensin II to the AT1 receptor in vascular smooth muscle and adrenal gland, blocking vasoconstriction and aldosterone secretion.",
            interactions = "NSAIDs: Blunted antihypertensive effect, increased acute kidney injury risk. Potassium-sparing diuretics/supplements: Hyperkalemia risk. Lithium: Increased serum lithium levels.",
            packSize = "Strip of 10 / 14 tablets (40mg / 80mg)",
            precautions = "Monitor serum potassium and renal function within 1-2 weeks of initiation. Caution in bilateral renal artery stenosis."
        ),
        Drug(
            id = "d14",
            genericName = "Metformin Hydrochloride",
            system = "Endocrine & Metabolic System",
            drugClass = "Biguanide Oral Antihyperglycemic",
            blackBoxWarning = "LACTIC ACIDOSIS: Rare but life-threatening complication characterized by elevated blood lactate levels, metabolic acidosis, hypothermia, hypotension, and resistant bradyarrhythmias. Risk increases with renal impairment, sepsis, and alcohol abuse.",
            indications = "Type 2 Diabetes Mellitus (First-line pharmacotherapy), Polycystic Ovary Syndrome (PCOS), Prediabetes prevention.",
            doses = "Adult: 500 mg PO BID or 850 mg PO OD with meals. Titrate by 500 mg weekly up to max 2000-2550 mg/day in divided doses. Extended Release (ER): 500-2000 mg PO OD with evening meal.",
            administration = "Take with or immediately after meals to minimize gastrointestinal disturbances.",
            timing = "With meals (morning and evening for IR; evening for ER).",
            specialInstructions = "Discontinue before iodinated contrast procedures and withhold for 48 hours post-procedure until eGFR is verified stable. Check B12 levels annually.",
            pkPd = "Slow and incomplete oral absorption (~50-60%). Not metabolized by liver; excreted unchanged in urine via tubular secretion and glomerular filtration. Elimination half-life ~6.2 hours.",
            renalAdj = "eGFR ≥60 mL/min: No adjustment. eGFR 45-59: Max 1000 mg/day. eGFR 30-44: Max 500-1000 mg/day; do not initiate. eGFR <30: Strictly contraindicated.",
            hepaticAdj = "Avoid in active hepatic disease due to impaired lactate clearance and heightened lactic acidosis risk.",
            pregnancy = "Category B (Commonly used in Gestational Diabetes under specialist supervision)",
            lactation = "Excreted in small amounts in breast milk; generally compatible with monitoring of infant blood glucose.",
            sideEffects = "Diarrhea, nausea, vomiting, metallic taste, abdominal bloating, flatulence, Vitamin B12 deficiency (long-term).",
            priceNpr = "NPR 4.00 - 10.00 per tab (500mg)",
            priceInr = "INR 2.50 - 7.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Glucomin", "Deurali-Janta Pharmaceuticals", "Tab", "500 / 850 / 1000 mg"),
                BrandInfo("Formin", "Nepal Pharmaceuticals Lab", "Tab", "500 / 850 mg"),
                BrandInfo("Metfo-Asian", "Asian Pharmaceuticals", "Tab", "500 mg"),
                BrandInfo("Biguan", "Omnica Laboratories Nepal", "Tab", "500 / 1000 mg ER"),
                BrandInfo("Zomet", "Time Pharmaceuticals Nepal", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Glycomet", "USV Private Limited", "Tab", "500 / 850 / 1000 mg"),
                BrandInfo("Glucophage", "Merck Ltd.", "Tab", "500 / 850 / 1000 mg"),
                BrandInfo("Obimet", "Abbott India", "Tab", "500 / 1000 mg SR"),
                BrandInfo("Cetapin", "Sanofi India", "Tab", "500 / 1000 mg XR")
            ),
            adultDose = "500 mg PO BID with meals, titrating to 1000 mg BID (max 2550 mg/day).",
            childDose = "Children ≥10 years: 500 mg PO OD/BID with meals, max 2000 mg/day.",
            contraindications = "eGFR <30 mL/min/1.73m², acute or chronic metabolic acidosis / DKA, severe hypoxia, shock, severe acute heart failure.",
            modeOfAction = "Inhibits hepatic gluconeogenesis via mitochondrial glycerol-3-phosphate dehydrogenase (mGPD) & AMPK activation; increases peripheral insulin sensitivity in skeletal muscle.",
            interactions = "Iodinated contrast: CI-AKI leading to lactic acidosis (hold 48h). Cimetidine/Dolicetavir: Decreased renal excretion of metformin via OCT2 inhibition.",
            packSize = "Blister pack of 10 / 15 / 30 tablets (500mg, 850mg, 1000mg)",
            precautions = "Withhold in dehydration, severe sepsis, or hypoxemic respiratory states. Periodic Vitamin B12 and eGFR testing."
        ),
        Drug(
            id = "d15",
            genericName = "Ondansetron Hydrochloride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "5-HT3 Serotonin Receptor Antagonist (Antiemetic)",
            blackBoxWarning = null,
            indications = "Prevention and treatment of nausea and vomiting (chemotherapy-induced, radiotherapy-induced, post-operative, acute gastroenteritis in emergency).",
            doses = "Adult: 4-8 mg PO/IV/IM q8h PRN. Chemotherapy: 8-16 mg IV 30 min prior to chemotherapy, then 8 mg PO q8h x 1-2 days. Post-op PONV: 4 mg IV single dose.",
            administration = "Slow IV injection over 2-5 minutes, deep IM injection, or oral (tablets / orally disintegrating tablets ODT / syrup).",
            timing = "30 minutes prior to chemotherapy or operation, or at onset of acute emetic episodes.",
            specialInstructions = "Administer IV slowly; rapid IV push can cause transient blindness or syncope. Caution in congenital long QT syndrome.",
            pkPd = "Well absorbed orally (~60% bioavailability due to first-pass). Extensively metabolized by hepatic CYP1A2, CYP2D6, CYP3A4. Half-life ~3-4 hours. Excreted in urine and feces.",
            renalAdj = "No dosage adjustment required in mild, moderate, or severe renal failure.",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh Class C): Total daily dose must not exceed 8 mg.",
            pregnancy = "Category B (Widely prescribed for severe hyperemesis gravidarum under clinical monitoring).",
            lactation = "Excreted into animal milk; caution advised in nursing mothers.",
            sideEffects = "Headache, constipation, sensation of warmth or flushing, transient asymptomatic transaminase elevation, fatigue, QT prolongation.",
            priceNpr = "NPR 5.00 - 12.00 per tab (4mg); NPR 15.00 - 30.00 per ampoule",
            priceInr = "INR 3.50 - 8.00 per tab (4mg); INR 10.00 - 22.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Emeset-NPL", "Nepal Pharmaceuticals Lab", "Tab / Inj", "4 mg / 2mg/ml"),
                BrandInfo("Ondem-DJ", "Deurali-Janta Pharmaceuticals", "Tab / Syr", "4 mg / 2mg/5ml"),
                BrandInfo("Vomiset", "Asian Pharmaceuticals", "Tab", "4 / 8 mg"),
                BrandInfo("Ondakind-N", "Quest Pharmaceuticals", "Tab / Inj", "4 mg"),
                BrandInfo("Vomitron", "Lomus Pharmaceuticals", "Tab / Inj", "4 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Emeset", "Cipla Ltd.", "Tab / Inj / Syr", "4 mg / 8 mg / 2mg/ml"),
                BrandInfo("Ondem", "Alkem Laboratories", "Tab / Inj / MD", "4 mg / 8 mg / 2mg/ml"),
                BrandInfo("Zofran", "Novartis / GSK", "Tab / Inj", "4 mg / 8 mg"),
                BrandInfo("Periset", "IPCA Laboratories", "Tab / Inj", "4 mg / 2mg/ml")
            ),
            pediatricDosePerKg = 0.15,
            pediatricInterval = "mg/kg IV/PO q8h (Max 4mg)",
            adultDose = "4 mg to 8 mg PO/IV q8h PRN (Max 16 mg/day; Max 8 mg/day in severe hepatic impairment).",
            childDose = "Pediatric (≥6 months): 0.15 mg/kg IV or PO (Single dose max: 4 mg) q8h PRN.",
            contraindications = "Concomitant use of apomorphine (profound hypotension and loss of consciousness reported). Congenital long QT syndrome.",
            modeOfAction = "Selectively antagonizes 5-HT3 receptors in both peripheral vagal nerve terminals in the gut and central chemoreceptor trigger zone (CTZ) in the area postrema.",
            interactions = "Apomorphine: Profound hypotension (Strictly contraindicated). Tramadol: Blunted analgesic efficacy of tramadol. QT-prolonging drugs: Additive cardiac electrophysiological toxicity.",
            packSize = "Strip of 10 tablets (4mg/8mg); Box of 5 ampoules (2ml)",
            precautions = "ECG monitoring in hypokalemia, hypomagnesemia, congestive heart failure, or concurrent arrhythmogenic medication use."
        ),
        Drug(
            id = "d16",
            genericName = "Ceftriaxone Sodium",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Third-Generation Cephalosporin Antibiotic",
            blackBoxWarning = "NEONATAL HYPERBILIRUBINEMIA & CALCIUM CELESTIAL CEFTRIAXONE PRECIPITATION: Ceftriaxone is contraindicated in neonates (≤28 days) if they require (or are expected to require) calcium-containing IV solutions (e.g., parenteral nutrition) because of the risk of precipitation of ceftriaxone-calcium in lungs and kidneys.",
            indications = "Meningitis, Community-Acquired & Nosocomial Pneumonia, Typhoid / Enteric Fever (Salmonella enterica), Sepsis, Intra-abdominal infections, Complicated Pyelonephritis, Gonococcal infections.",
            doses = "Adult: 1-2 g IV/IM OD (or divided q12h in severe infection). Bacterial Meningitis: 2 g IV q12h. Typhoid: 2 g IV OD x 7-10 days.\nPediatric: 50-75 mg/kg/day IV/IM OD or divided q12h (Max 2 g/day; Meningitis: 100 mg/kg/day max 4 g/day).",
            administration = "Slow IV injection over 2-4 minutes, IV infusion over 30 minutes, or deep IM injection reconstituted with 1% Lidocaine (never give lidocaine mixture IV).",
            timing = "Once daily (or every 12 hours in severe central nervous system infections).",
            specialInstructions = "NEVER co-administer or flush IV lines with calcium-containing solutions (e.g. Ringer's Lactate / Hartmann's solution) due to lethal crystalline precipitates.",
            pkPd = "High protein binding (85-95%). Excellent CSF penetration across inflamed meninges. Dual elimination: Biliary (~40%) and renal (~60%). Unusually long half-life of 6-9 hours allowing once-daily dosing.",
            renalAdj = "No adjustment necessary unless combined severe renal AND severe hepatic impairment coexist (cap at 2 g/day).",
            hepaticAdj = "No adjustment needed unless combined severe renal failure is present.",
            pregnancy = "Category B (Safe; gold-standard inpatient cephalosporin in pregnancy)",
            lactation = "Excreted into breast milk in low concentrations; compatible with breastfeeding. Watch infant for diarrhea.",
            sideEffects = "Diarrhea, injection site pain/induration, eosinophilia, thrombocytosis, biliary pseudolithiasis (sludge) reversible on discontinuation, hypersensitivity.",
            priceNpr = "NPR 95.00 - 180.00 per vial (1g Inj)",
            priceInr = "INR 55.00 - 120.00 per vial (1g Inj)",
            brandsNepal = listOf(
                BrandInfo("C-Zone", "Deurali-Janta Pharmaceuticals", "Vial Inj", "250mg / 500mg / 1g / 2g"),
                BrandInfo("Ceftril-NPL", "Nepal Pharmaceuticals Lab", "Vial Inj", "1g / 2g"),
                BrandInfo("Xone-Asian", "Asian Pharmaceuticals", "Vial Inj", "1g"),
                BrandInfo("Trixon", "Quest Pharmaceuticals", "Vial Inj", "1g"),
                BrandInfo("Oframax-N", "Ranbaxy Nepal", "Vial Inj", "1g")
            ),
            brandsIndia = listOf(
                BrandInfo("Monocef", "Aristo Pharmaceuticals", "Vial Inj", "250mg / 500mg / 1g / 2g"),
                BrandInfo("Cefbact", "Cipla Ltd.", "Vial Inj", "1g / 2g"),
                BrandInfo("Oframax", "Sun Pharma", "Vial Inj", "1g"),
                BrandInfo("Taxim-O (Ceftriaxone Inj)", "Alkem Laboratories", "Vial Inj", "1g")
            ),
            pediatricDosePerKg = 60.0,
            pediatricInterval = "mg/kg/day IV OD (Max 2g)",
            adultDose = "1 g to 2 g IV/IM once daily (Meningitis: 2 g IV q12h; Gonorrhea: 500 mg IM single dose).",
            childDose = "Pediatric (≥1 month): 50-75 mg/kg/day IV/IM once daily or divided q12h (Meningitis: 100 mg/kg/day divided q12h, max 4g).",
            contraindications = "Hyperbilirubinemic neonates (especially prematures) due to risk of kernicterus (displaces bilirubin from albumin). Concomitant IV calcium in neonates ≤28 days. Severe cephalosporin/penicillin anaphylaxis.",
            modeOfAction = "Inhibits bacterial cell wall synthesis by binding to one or more penicillin-binding proteins (PBPs), leading to bacterial cell wall lysis and autolytic enzyme activation.",
            interactions = "IV Calcium solutions (Ringer Lactate, Hartmann's): Life-threatening microvascular precipitation in lungs and kidneys. Oral anticoagulants / Warfarin: Potentiated hypoprothrombinemic effect.",
            packSize = "Glass vial with sterile water for injection (250mg, 500mg, 1g, 2g)",
            precautions = "Perform skin sensitivity test (AST) before administration. Monitor CBC and LFTs in courses extending beyond 10 days."
        ),
        Drug(
            id = "d17",
            genericName = "Salbutamol (Albuterol)",
            system = "Respiratory System (RS)",
            drugClass = "Short-Acting Beta-2 Adrenergic Agonist (SABA Bronchodilator)",
            blackBoxWarning = null,
            indications = "Acute Bronchospasm, Asthma Exacerbation, Chronic Obstructive Pulmonary Disease (COPD), Exercise-induced bronchospasm, Emergency Hyperkalemia management.",
            doses = "MDI Inhaler: 1-2 puffs (100-200 mcg) q4-6h PRN. Acute Severe Asthma: 4-10 puffs via spacer every 20 minutes for first hour.\nNebulization: 2.5-5 mg (0.5-1 mL of 5mg/mL solution in 3 mL normal saline) q20min x 3 doses then q1-4h PRN.\nHyperkalemia: 10-20 mg nebulized over 15 min.",
            administration = "Inhalation via pressurized metered-dose inhaler (pMDI with spacer preferred) or jet nebulizer.",
            timing = "As needed during acute dyspnea, or 15 minutes before physical exertion.",
            specialInstructions = "Always shake inhaler well before use. Rinse mouth with water after use. Over-reliance (>1 canister/month) signals poorly controlled asthma.",
            pkPd = "Rapid onset within 5-15 minutes after inhalation. Peak bronchodilation at 0.5-2 hours. Duration of action: 3-6 hours. Small systemic absorption undergoes hepatic sulfation; excreted in urine.",
            renalAdj = "No adjustment needed for inhaled routes.",
            hepaticAdj = "No adjustment needed for inhaled routes.",
            pregnancy = "Category C (Preferred rescue bronchodilator in pregnant asthmatics; essential to prevent maternal and fetal hypoxia).",
            lactation = "Insignificant systemic absorption into breast milk; safe during breastfeeding.",
            sideEffects = "Fine muscle tremor (especially hands), tachycardia, palpitations, headache, hypokalemia (at high doses), peripheral vasodilation.",
            priceNpr = "NPR 180.00 - 280.00 per MDI canister (200 doses); NPR 8.00 - 15.00 per respule",
            priceInr = "INR 110.00 - 190.00 per MDI canister; INR 5.00 - 10.00 per respule",
            brandsNepal = listOf(
                BrandInfo("Asthalin-N", "Deurali-Janta Pharmaceuticals", "Inhaler / Respule", "100 mcg / 2.5mg/2.5ml"),
                BrandInfo("Salbut-NPL", "Nepal Pharmaceuticals Lab", "Inhaler / Syr", "100 mcg / 2mg/5ml"),
                BrandInfo("Vent-Asian", "Asian Pharmaceuticals", "Inhaler", "100 mcg"),
                BrandInfo("Bronchocure", "Curex Pharmaceuticals", "Respules", "2.5 mg / 2.5ml"),
                BrandInfo("Salbutol", "National Healthcare Nepal", "Syrup", "2mg/5ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Asthalin", "Cipla Ltd.", "pMDI / Respules / Tab", "100 mcg / 2.5mg / 4mg"),
                BrandInfo("Ventorlin", "GlaxoSmithKline India", "Inhaler / Respule", "100 mcg / 2.5mg"),
                BrandInfo("Derihaler", "Zydus Cadila", "Inhaler", "100 mcg"),
                BrandInfo("Macbery-S", "Mankind Pharma", "Syrup / Respules", "2.5 mg")
            ),
            adultDose = "Inhaled: 100-200 mcg (1-2 puffs) q4-6h PRN (acute exacerbation: 4-10 puffs q20min with spacer). Nebulized: 2.5-5 mg q20min x 3 doses.",
            childDose = "Inhaled: 100 mcg (1 puff) q4-6h PRN (acute asthma: 2-6 puffs q20min with spacer). Nebulized: 0.15 mg/kg (min 1.25 mg, max 2.5-5 mg) q20min.",
            contraindications = "Hypersensitivity to salbutamol. Non-IV formulations must not be used to arrest uncomplicated premature labor or threatened abortion.",
            modeOfAction = "Selectively stimulates beta-2 adrenergic receptors in bronchial smooth muscle, activating adenylate cyclase, increasing intracellular cAMP, causing bronchodilation and inhibiting inflammatory mast cell mediator release.",
            interactions = "Non-selective Beta-blockers (Propranolol): Antagonize bronchodilator effect and may precipitate severe fatal bronchospasm. Potassium-depleting diuretics: Additive hypokalemia.",
            packSize = "Pressurized MDI 200 actuations (100mcg/puff); Pack of 5/20 Respules (2.5mg/2.5ml)",
            precautions = "Use with caution in cardiovascular disorders (arrhythmias, hypertension, CAD), hyperthyroidism, diabetes mellitus (risk of ketoacidosis with high IV/nebulized doses)."
        ),
        Drug(
            id = "d18",
            genericName = "Epinephrine (Adrenaline)",
            system = "Emergency & Resuscitation (ACLS)",
            drugClass = "Non-Selective Alpha & Beta Adrenergic Agonist (Sympathomimetic)",
            blackBoxWarning = null,
            indications = "Anaphylaxis / Severe Systemic Allergic Reactions, Cardiac Arrest (VF, pVT, Asystole, PEA), Severe Stridor / Croup (racemic/nebulized), Septic Shock with refractory hypotension.",
            doses = "Anaphylaxis: 0.3 - 0.5 mg (0.3 - 0.5 mL of 1:1,000 solution) IM anterolateral mid-thigh; repeat q5-15 min PRN.\nCardiac Arrest (ACLS): 1 mg (10 mL of 1:10,000 solution) IV/IO rapid push q3-5 minutes followed by 20 mL NS flush.",
            administration = "IM (anterolateral mid-thigh for anaphylaxis - NEVER give 1:1,000 IV bolus!), IV/IO (1:10,000 in arrest), or continuous IV infusion via infusion pump (0.05-0.5 mcg/kg/min).",
            timing = "Immediately upon clinical recognition of systemic anaphylaxis or pulseless arrest.",
            specialInstructions = "DO NOT delay epinephrine in anaphylaxis. Intramuscular injection into the anterolateral mid-thigh produces peak plasma levels significantly faster than deltoid or subcutaneous routes.",
            pkPd = "Rapid onset: IM 3-5 minutes, IV immediate. Duration of action 10-30 minutes. Rapidly metabolized by MAO and COMT in liver and peripheral tissues. Potent alpha-1 vasoconstriction, beta-1 positive inotrope/chronotrope, beta-2 bronchodilation.",
            renalAdj = "No dosage adjustment required in renal failure.",
            hepaticAdj = "No dosage adjustment required in acute emergency.",
            pregnancy = "Category C (Emergency life-saving drug: maternal resuscitation takes absolute priority over fetal considerations).",
            lactation = "Insignificant oral bioavailability for nursing infant; compatible in emergencies.",
            sideEffects = "Tachycardia, palpitations, anxiety, tremors, headache, diaphoresis, hypertension, angina, ventricular dysrhythmias.",
            priceNpr = "NPR 25.00 - 45.00 per ampoule (1mg/mL)",
            priceInr = "INR 15.00 - 30.00 per ampoule (1mg/mL)",
            brandsNepal = listOf(
                BrandInfo("Adrenaline-NPL", "Nepal Pharmaceuticals Lab", "Inj Ampoule", "1 mg/ml (1:1000)"),
                BrandInfo("Vasocon-DJ", "Deurali-Janta Pharmaceuticals", "Inj Ampoule", "1 mg/ml (1:1000)"),
                BrandInfo("Adren-Asian", "Asian Pharmaceuticals", "Inj Ampoule", "1 mg/ml (1:1000)")
            ),
            brandsIndia = listOf(
                BrandInfo("Adrenalin", "Harson Laboratories", "Inj Ampoule", "1 mg/ml"),
                BrandInfo("EpiPen (Autoinjector)", "Mylan / Viatris", "Autoinjector", "0.3 mg (Adult) / 0.15 mg (Jr)"),
                BrandInfo("Vasocon", "Neon Laboratories", "Inj", "1 mg/ml")
            ),
            pediatricDosePerKg = 0.01,
            pediatricInterval = "mg/kg IM (1:1000, max 0.3mg single dose) for anaphylaxis",
            adultDose = "Anaphylaxis: 0.3-0.5 mg IM (1:1000); Arrest: 1 mg IV (1:10,000) q3-5min.",
            childDose = "Anaphylaxis: 0.01 mg/kg IM (max 0.3 mg). Arrest: 0.01 mg/kg IV (0.1 mL/kg of 1:10,000).",
            contraindications = "There are NO absolute contraindications to epinephrine in life-threatening anaphylaxis or cardiac arrest.",
            modeOfAction = "Direct-acting agonist at alpha-1 (vasoconstriction, reverses mucosal edema and hypotension), beta-1 (inotropic and chronotropic cardiac output boost), and beta-2 receptors (bronchial smooth muscle dilation and mast cell stabilizer).",
            interactions = "Non-cardioselective beta-blockers: Risk of severe refractory hypertension and reflex bradycardia (use IV Glucagon if anaphylaxis refractory to epinephrine). MAO inhibitors: Potentiated sympathomimetic crisis.",
            packSize = "Box of 10 glass ampoules (1 mL, 1 mg/mL)",
            precautions = "Continuous cardiac telemetry, pulse oximetry, and blood pressure monitoring. Exercise extreme care with dilution (1:1,000 vs 1:10,000)."
        ),
        Drug(
            id = "d19",
            genericName = "Aspirin (Acetylsalicylic Acid)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Non-Steroidal Anti-Inflammatory / Antiplatelet Agent (COX-1 Inhibitor)",
            blackBoxWarning = "REYE'S SYNDROME: Aspirin is contraindicated in pediatric patients (<19 years) suffering from viral infections (influenza, varicella) due to fatal hepatic microvesicular steatosis and cerebral edema.",
            indications = "Acute Coronary Syndrome (STEMI / NSTEMI / Unstable Angina), Secondary Prevention of Atherosclerotic Cardiovascular Disease (ASCVD), Acute Ischemic Stroke / TIA secondary prevention.",
            doses = "Acute MI Loading: 162-325 mg PO non-enteric coated tablet chewed immediately.\nMaintenance / Chronic Prophylaxis: 75-100 mg PO once daily.",
            administration = "Orally. In acute ACS, non-enteric coated chewable tablets must be chewed for rapid buccal and gastric absorption within 20 minutes.",
            timing = "Immediate loading in suspected MI; maintenance dose once daily with morning or midday meal.",
            specialInstructions = "Always advise patient to chew (not swallow whole) the initial 162-325 mg loading dose in suspected acute myocardial infarction.",
            pkPd = "Rapid oral absorption. Rapidly deacetylated to salicylic acid (half-life 15-20 min; salicylate half-life 2-3h low-dose, 15-30h toxic). Irreversibly acetylates platelet COX-1, disabling thromboxane A2 production for the entire platelet lifespan (7-10 days).",
            renalAdj = "CrCl <10 mL/min: Avoid chronic use due to blunted renal prostaglandin synthesis.",
            hepaticAdj = "Avoid in severe hepatic insufficiency due to coagulopathy and platelet dysfunction.",
            pregnancy = "Category D in 3rd trimester (premature closure of fetal ductus arteriosus, intracranial hemorrhage). Low-dose 81-150 mg/day safe for preeclampsia prevention starting at 12-16 weeks.",
            lactation = "Excreted in low levels in breast milk; low-dose 75-100 mg daily compatible, but high anti-inflammatory doses should be avoided.",
            sideEffects = "Dyspepsia, epigastric distress, peptic ulceration, gastrointestinal hemorrhage, tinnitus (salicylate toxicity), prolonged bleeding time, bronchospasm in aspirin-exacerbated respiratory disease (AERD).",
            priceNpr = "NPR 1.50 - 3.50 per tab (75mg/150mg)",
            priceInr = "INR 1.00 - 2.50 per tab (75mg/150mg)",
            brandsNepal = listOf(
                BrandInfo("ASA-NPL", "Nepal Pharmaceuticals Lab", "Tab", "75 mg / 150 mg"),
                BrandInfo("Disprin-Nepal", "Reckitt Benckiser Nepal", "Soluble Tab", "350 mg"),
                BrandInfo("Loprin", "Asian Pharmaceuticals", "Enteric-Coated Tab", "75 mg / 150 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ecosprin", "USV Private Limited", "EC Tab", "75 mg / 150 mg / 325 mg"),
                BrandInfo("Disprin", "Reckitt Benckiser India", "Soluble Tab", "325 mg"),
                BrandInfo("Delisprin", "Aristo Pharmaceuticals", "Tab", "75 mg / 150 mg")
            ),
            adultDose = "ACS Loading: 162-325 mg chewed immediately; Maintenance: 75-100 mg PO OD.",
            childDose = "Generally contraindicated in children <19 years (Reye's syndrome risk). Kawasaki Disease: 30-50 mg/kg/day divided q6h until afebrile, then 3-5 mg/kg OD x 6-8 weeks.",
            contraindications = "Aspirin-induced asthma / triad (AERD), active gastrointestinal ulcer bleeding, severe bleeding diathesis, pediatric viral illnesses.",
            modeOfAction = "Irreversibly inhibits cyclooxygenase-1 (COX-1) through covalent acetylation of Ser-529, permanently halting thromboxane A2 (TXA2) synthesis in platelets.",
            interactions = "Ibuprofen / Naproxen: May competitively block aspirin's active site on COX-1 if taken beforehand; take aspirin at least 30 minutes before or 8 hours after other NSAIDs. Anticoagulants (Warfarin/DOACs): Marked synergistic major bleeding risk.",
            packSize = "Strips of 14 or 30 enteric-coated / chewable tablets",
            precautions = "Co-prescribe Proton Pump Inhibitor (e.g. Pantoprazole 40mg) in patients with elevated GI bleeding risk."
        ),
        Drug(
            id = "d20",
            genericName = "Ticagrelor",
            system = "Cardiovascular System (CVS)",
            drugClass = "Direct-Acting P2Y12 Platelet Inhibitor (Cyclopentyltriazolopyrimidine)",
            blackBoxWarning = "BLEEDING RISK & ASPIRIN DOSE LIMIT: Ticagrelor increases risk of fatal bleeding. Maintenance doses of Aspirin above 100 mg/day decrease the clinical effectiveness of Ticagrelor and must be avoided.",
            indications = "Acute Coronary Syndrome (STEMI, NSTEMI, Unstable Angina) undergoing Percutaneous Coronary Intervention (PCI) or medical management; Secondary prevention of atherothrombotic events.",
            doses = "Loading Dose: 180 mg (two 90 mg tablets) PO single dose.\nMaintenance Dose: 90 mg PO BID with or without food for 12 months, co-administered with low-dose Aspirin (75-100 mg OD).",
            administration = "Oral, with or without food. Tablets can be crushed and suspended in water for nasogastric tube administration in unconscious patients.",
            timing = "Twice daily, approximately 12 hours apart.",
            specialInstructions = "Do not prescribe with Aspirin maintenance doses exceeding 100 mg/day. Warn patient about potential transient, self-limiting dyspnea (usually peaks in first 3-5 days).",
            pkPd = "Rapid oral absorption (~36% bioavailability). Reversibly binds P2Y12 receptor (does NOT require hepatic bioactivation unlike Clopidogrel). Elimination half-life ~7-9 hours (active metabolite ~8-12 hours). Platelet function returns to baseline 4-5 days after discontinuation.",
            renalAdj = "No dose adjustment required in renal impairment, including ESRD / hemodialysis.",
            hepaticAdj = "Mild hepatic impairment: No adjustment. Moderate-to-severe hepatic impairment: Contraindicated due to coagulopathy risk.",
            pregnancy = "Category C (Use only if potential benefit outweighs risk in acute coronary syndromes).",
            lactation = "Unknown excretion in human milk; avoid during breastfeeding or discontinue nursing.",
            sideEffects = "Dyspnea (up to 15%, adenosine reuptake inhibition), bleeding / bruising, ventricular pauses / bradyarrhythmias, elevated serum uric acid, hypercreatininemia.",
            priceNpr = "NPR 35.00 - 65.00 per tab (90mg)",
            priceInr = "INR 22.00 - 45.00 per tab (90mg)",
            brandsNepal = listOf(
                BrandInfo("Tigrx-DJ", "Deurali-Janta Pharmaceuticals", "Tab", "90 mg"),
                BrandInfo("Ticagrel-NPL", "Nepal Pharmaceuticals Lab", "Tab", "90 mg"),
                BrandInfo("Ticarel", "Quest Pharmaceuticals", "Tab", "90 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Brilinta", "AstraZeneca India", "Tab", "60 mg / 90 mg"),
                BrandInfo("Axcer", "Sun Pharma", "Tab", "90 mg"),
                BrandInfo("Ticasave", "Ipca Laboratories", "Tab", "90 mg"),
                BrandInfo("Ticagrel", "Mankind Pharma", "Tab", "90 mg")
            ),
            adultDose = "180 mg PO loading dose, followed by 90 mg PO BID x 12 months with low-dose aspirin.",
            childDose = "Safety and efficacy not established in pediatric populations.",
            contraindications = "Active pathological bleeding, history of intracranial hemorrhage (ICH), severe hepatic impairment, concomitant strong CYP3A4 inhibitors/inducers.",
            modeOfAction = "Reversible, allosteric antagonist of the platelet P2Y12 ADP receptor, inhibiting ADP-mediated activation of the GPIIb/IIIa receptor complex and platelet aggregation.",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole, Clarithromycin): Dramatically increase ticagrelor exposure. Strong CYP3A4 inducers (Rifampin, Carbamazepine): Drastically reduce ticagrelor efficacy. Aspirin >100 mg/day: Reduces ticagrelor clinical efficacy.",
            packSize = "Blister pack of 14 tablets (90mg)",
            precautions = "Discontinue at least 5 days prior to elective CABG or major surgery to minimize perioperative bleeding."
        ),
        Drug(
            id = "d21",
            genericName = "Alteplase (rt-PA / Recombinant Tissue Plasminogen Activator)",
            system = "Emergency & Critical Care / Neurology",
            drugClass = "Thrombolytic / Fibrinolytic Enzyme",
            blackBoxWarning = "INTRACRANIAL HEMORRHAGE RISK: Thrombolytic therapy in acute ischemic stroke increases the risk of fatal intracranial hemorrhage. Strict adherence to the 4.5-hour time window, blood pressure limits (<185/110 mmHg), and exclusion criteria is mandatory.",
            indications = "Acute Ischemic Stroke (within 3 to 4.5 hours of last known normal), Acute Massive Pulmonary Embolism (PE) with hemodynamic instability, Acute STEMI when primary PCI unavailable within 120 minutes.",
            doses = "Acute Ischemic Stroke: 0.9 mg/kg IV (Maximum 90 mg). Infuse 10% of total dose as an IV bolus over 1 minute; infuse the remaining 90% over 60 minutes.\nMassive PE: 100 mg IV infusion over 2 hours.",
            administration = "Intravenous infusion only. Dedicated IV line; do NOT add other medications to infusion solution.",
            timing = "Stroke window: MUST be initiated within 4.5 hours of symptom onset (time patient last seen normal).",
            specialInstructions = "Confirm non-contrast head CT is negative for hemorrhage prior to starting. Maintain BP <180/105 mmHg for at least 24 hours post-infusion. Hold antithrombotics and antiplatelets for 24h.",
            pkPd = "Rapidly cleared from plasma primarily by the liver. Initial half-life <5 minutes; terminal elimination half-life ~30 minutes. Converts clot-bound plasminogen to active plasmin, causing fibrinolysis.",
            renalAdj = "No dosage adjustments required in renal impairment.",
            hepaticAdj = "Severe hepatic dysfunction with baseline coagulopathy / INR >1.7: Contraindicated.",
            pregnancy = "Category C (Life-threatening indications: may be used after rigorous risk-benefit discussion).",
            lactation = "Unknown excretion; unlikely to be absorbed intact by infant.",
            sideEffects = "Symptomatic intracranial hemorrhage (sICH ~6%), systemic hemorrhage, orolingual angioedema (especially with ACE inhibitors), hypotension.",
            priceNpr = "NPR 45,000 - 65,000 per 50mg vial",
            priceInr = "INR 30,000 - 45,000 per 50mg vial",
            brandsNepal = listOf(
                BrandInfo("Actilyse-Nepal", "Boehringer Ingelheim / Importer", "Vial Inj", "50 mg Lyophilized Powder")
            ),
            brandsIndia = listOf(
                BrandInfo("Actilyse", "Boehringer Ingelheim India", "Vial Inj", "50 mg"),
                BrandInfo("Altepase", "Cipla Ltd.", "Vial Inj", "50 mg")
            ),
            adultDose = "Stroke: 0.9 mg/kg IV (10% bolus over 1 min, 90% over 60 min, max 90 mg). Massive PE: 100 mg IV over 2 hours.",
            childDose = "Safety and efficacy not established in pediatric stroke guidelines.",
            contraindications = "Active internal bleeding, history of intracranial hemorrhage, intracranial neoplasm / AVM / aneurysm, recent intracranial / intraspinal surgery within 3 months, BP >185/110 mmHg unresponsive to antihypertensive, platelets <100,000, INR >1.7.",
            modeOfAction = "Recombinant human tissue-type plasminogen activator that selectively binds to fibrin in a thrombus and converts trapped plasminogen to active plasmin, leading to local clot dissolution.",
            interactions = "Anticoagulants (Heparin, Warfarin, DOACs): Synergistic major hemorrhagic risk. ACE Inhibitors: Significantly increased risk of orolingual angioedema.",
            packSize = "Single-use glass vial containing 50 mg alteplase powder with sterile water for reconstitution",
            precautions = "Neurological checks and blood pressure monitoring every 15 min for 2 hours, every 30 min for 6 hours, then hourly for 16 hours. Stop immediately if severe headache, hypertension, or nausea develops."
        ),
        Drug(
            id = "d22",
            genericName = "Levetiracetam",
            system = "Central Nervous System (CNS)",
            drugClass = "Antiepileptic Agent (Synaptic Vesicle Protein SV2A Ligand)",
            blackBoxWarning = null,
            indications = "Status Epilepticus (Second-line agent post-benzodiazepines per AES Guidelines), Focal / Partial Seizures, Generalized Tonic-Clonic Seizures, Myoclonic Seizures in Juvenile Myoclonic Epilepsy (JME).",
            doses = "Status Epilepticus: 60 mg/kg IV (Max 4,500 mg) infused over 10-15 minutes.\nMaintenance: 500 mg PO/IV BID, titrating every 2 weeks up to 1,500 mg BID (Max 3,000 mg/day).",
            administration = "Oral tablets / oral solution, or IV infusion diluted in 100 mL NS / D5W infused over 15 minutes.",
            timing = "Twice daily, evenly spaced 12 hours apart.",
            specialInstructions = "1:1 oral to IV dose conversion. Do not abruptly discontinue; taper gradually to prevent rebound seizure exacerbation.",
            pkPd = "Rapid and almost complete oral absorption (bioavailability ~100%). Negligible protein binding (<10%). Enzymatic hydrolysis in blood independent of CYP450. Excreted unchanged in urine (66%). Elimination half-life 6-8 hours.",
            renalAdj = "CrCl 50-79 mL/min: 500-1000 mg q12h. CrCl 30-49 mL/min: 250-750 mg q12h. CrCl <30 mL/min: 250-500 mg q12h. Hemodialysis: 500-1000 mg q24h + 250-500 mg supplemental post-dialysis.",
            hepaticAdj = "No adjustment needed in mild-to-moderate impairment. In severe hepatic impairment (Child-Pugh C) with CrCl <60 mL/min: reduce dose by 50%.",
            pregnancy = "Category C (One of the safest antiepileptics during pregnancy with lowest teratogenic risk compared to Valproate; therapeutic drug monitoring advised).",
            lactation = "Excreted into breast milk; compatible with breastfeeding under infant sedation monitoring.",
            sideEffects = "Somnolence, dizziness, fatigue, asthenia, behavioral / neuropsychiatric changes (irritability, agitation, depression, psychosis in 10-13%), nasopharyngitis.",
            priceNpr = "NPR 12.00 - 24.00 per tab (500mg); NPR 150.00 - 250.00 per 5mL IV vial",
            priceInr = "INR 8.00 - 18.00 per tab (500mg); INR 90.00 - 180.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Levro-DJ", "Deurali-Janta Pharmaceuticals", "Tab / Inj", "250 / 500 / 750 mg"),
                BrandInfo("Levitam-NPL", "Nepal Pharmaceuticals Lab", "Tab", "500 mg / 1000 mg"),
                BrandInfo("Epilep", "Asian Pharmaceuticals", "Tab", "500 mg"),
                BrandInfo("Torleva-N", "Torrent Nepal", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Keppra", "UCB India", "Tab / Inj / Syr", "250 / 500 / 1000 mg"),
                BrandInfo("Levipil", "Sun Pharma", "Tab / Inj", "250 / 500 / 750 / 1000 mg"),
                BrandInfo("Torleva", "Torrent Pharmaceuticals", "Tab / Inj", "500 mg / 750 mg"),
                BrandInfo("Levera", "Intas Pharmaceuticals", "Tab / Inj", "500 mg / 1000 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "mg/kg/day divided q12h, titrating to 60 mg/kg/day",
            adultDose = "Status: 60 mg/kg IV over 10 min (max 4.5g). Maintenance: 500-1500 mg PO/IV BID.",
            childDose = "Children ≥1 month: 10 mg/kg BID, titrate by 10 mg/kg q2w up to 30 mg/kg BID (max 60 mg/kg/day).",
            contraindications = "Hypersensitivity to levetiracetam or other pyrrolidone derivatives.",
            modeOfAction = "Selectively binds to synaptic vesicle protein 2A (SV2A) in presynaptic terminals, modulating exocytosis and inhibiting burst firing and hypersynchronous neuronal discharge without affecting normal neurotransmission.",
            interactions = "Minimal pharmacokinetic drug-drug interactions (does not induce or inhibit cytochrome P450 enzymes). Sedatives / Benzodiazepines: Additive CNS somnolence.",
            packSize = "Strips of 10 tablets (250mg, 500mg, 750mg, 1000mg); Vial 500mg/5ml",
            precautions = "Screen for psychiatric history (depression, anxiety, psychosis). Monitor for emergence of suicidal ideation or worsening mood."
        ),
        Drug(
            id = "d23",
            genericName = "Amiodarone Hydrochloride",
            system = "Cardiovascular & ACLS Resuscitation",
            drugClass = "Class III Antiarrhythmic Agent (Multichannel Blocker)",
            blackBoxWarning = "FATAL TOXICITIES: Amiodarone causes pulmonary toxicity (alveolitis/pulmonary fibrosis in up to 10-17%), fatal exacerbation of arrhythmias, and severe hepatic injury. Initiate only in life-threatening arrhythmias under specialist monitoring.",
            indications = "ACLS Pulseless VT / Ventricular Fibrillation (VF) unresponsive to CPR and defibrillation, Hemodynamically Stable Monomorphic VT, Atrial Fibrillation rate and rhythm control in Heart Failure.",
            doses = "ACLS Cardiac Arrest (Shock-refractory VF/pVT): 300 mg IV push rapid bolus diluted in 20 mL D5W; repeat with 150 mg IV push in 3-5 minutes if VF/VT recurs.\nStable VT / AF: 150 mg IV over 10 min in 100 mL D5W, then 1 mg/min (360 mg) over 6 hours, then 0.5 mg/min (540 mg) over 18 hours.\nOral Loading: 800-1600 mg/day divided x 1-3 weeks, maintenance 200 mg PO OD.",
            administration = "IV bolus in cardiac arrest; continuous IV infusion via volumetric infusion pump using in-line filter. Oral tablets taken with meals to reduce GI upset.",
            timing = "Cardiac arrest: Immediately after 3rd shock; maintenance: once daily with meals.",
            specialInstructions = "Always dilute in 5% Dextrose in Water (D5W) — precipitates in Normal Saline during prolonged infusions! Use central line whenever possible (peripheral IV causes chemical phlebitis).",
            pkPd = "Extremely lipid soluble. Massive volume of distribution (~60 L/kg). Highly protein bound (>96%). Extensive hepatic metabolism by CYP3A4 to active desethylamiodarone. Extremely long terminal elimination half-life of 26-107 days (mean ~58 days).",
            renalAdj = "No dose adjustment needed in renal failure or hemodialysis (negligible renal excretion).",
            hepaticAdj = "Use with extreme caution. Discontinue if transaminases rise >3x normal.",
            pregnancy = "Category D (Crosses placenta, causes fetal congenital goiter, hypothyroidism, and neurodevelopmental impairment).",
            lactation = "Contraindicated during breastfeeding (concentrates significantly in breast milk).",
            sideEffects = "Pulmonary fibrosis, thyroid dysfunction (hypo- or hyper-thyroidism due to high iodine content), corneal microdeposits, blue-gray skin discoloration, bradycardia, QT prolongation, Torsades de Pointes.",
            priceNpr = "NPR 15.00 - 30.00 per tab (200mg); NPR 85.00 - 150.00 per ampoule (150mg/3ml)",
            priceInr = "INR 10.00 - 20.00 per tab (200mg); INR 50.00 - 95.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Amio-NPL", "Nepal Pharmaceuticals Lab", "Tab / Inj", "100 / 200 mg / 150mg/3ml"),
                BrandInfo("Cordaron-DJ", "Deurali-Janta Pharmaceuticals", "Tab", "200 mg"),
                BrandInfo("Eurythmic", "Asian Pharmaceuticals", "Tab", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cordarone", "Sanofi India", "Tab / Inj", "100 / 200 mg / 150mg/3ml"),
                BrandInfo("Pacitane-Amio", "Cipla Ltd.", "Inj", "150 mg/3ml"),
                BrandInfo("Amipace", "Torrent Pharmaceuticals", "Tab", "100 / 200 mg")
            ),
            adultDose = "ACLS Arrest: 300 mg IV push, then 150 mg IV push. Stable: 150 mg IV over 10 min, then 1 mg/min x 6h, then 0.5 mg/min x 18h. Oral: 200 mg OD.",
            childDose = "Pediatric ACLS: 5 mg/kg IV/IO rapid bolus in pulseless VT/VF (max 300 mg); repeat up to 15 mg/kg total.",
            contraindications = "Severe sinus-node dysfunction, second- or third-degree AV block without pacemaker, cardiogenic shock, known iodine hypersensitivity.",
            modeOfAction = "Class III action: Blocks delayed rectifier potassium channels prolonging cardiac action potential duration and effective refractory period. Also exhibits Class I (sodium channel block), Class II (antiadrenergic), and Class IV (calcium channel block) properties.",
            interactions = "Digoxin: Doubles serum digoxin levels (empirically cut digoxin dose by 50%). Warfarin: Potentiates INR elevation (reduce warfarin dose by 33-50%). QT-prolonging drugs: Heightened risk of Torsades de Pointes.",
            packSize = "Strips of 10 tablets (200mg); Ampoules of 150mg/3ml (Box of 5)",
            precautions = "Baseline and 6-monthly monitoring of Chest X-ray, Pulmonary Function Tests (DLCO), Thyroid Profile (TSH/T3/T4), and Liver Enzymes (ALT/AST)."
        ),
        Drug(
            id = "d24",
            genericName = "Adenosine",
            system = "Cardiovascular & ACLS Emergency",
            drugClass = "Purinergic P1 Receptor Agonist (AV Nodal Conduction Blocker)",
            blackBoxWarning = null,
            indications = "Acute termination of Paroxysmal Supraventricular Tachycardia (PSVT / AVNRT / AVRT) involving AV nodal reentry; Diagnostic aid in wide-complex tachycardia of uncertain origin.",
            doses = "First Dose: 6 mg rapid IV push over 1-2 seconds via large antecubital vein, immediately followed by 20 mL Normal Saline flush and limb elevation.\nSecond Dose: If no conversion within 1-2 minutes, administer 12 mg rapid IV push with 20 mL NS flush.\nThird Dose: A second 12 mg dose may be given once if needed.",
            administration = "RAPID IV PUSH ONLY over 1-2 seconds using a stopcock technique, followed instantly by a rapid 20 mL saline flush and immediate arm elevation. Must NOT be given through small peripheral hand veins.",
            timing = "Administered under continuous 12-lead ECG monitoring at the moment of stable PSVT diagnosis.",
            specialInstructions = "WARN THE PATIENT before injection: They will experience brief, intense flushing, chest tightness, dyspnea, and a terrifying sensation of 'impending doom' lasting 10-20 seconds.",
            pkPd = "Ultrarapid cellular uptake by erythrocytes and vascular endothelial cells; rapidly metabolized by intracellular adenosine deaminase. Elimination half-life <10 seconds!",
            renalAdj = "No adjustment needed (cleared within seconds in blood cells).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Drug of choice for terminating acute SVT during all trimesters of pregnancy due to ultrashort half-life and absence of fetal exposure).",
            lactation = "Completely metabolized before reaching breast tissue; safe in breastfeeding.",
            sideEffects = "Facial flushing (18%), transient dyspnea / bronchospasm (12%), chest pressure / angina (7%), brief asystole / sinus pause (usually <5 seconds), nausea, lightheadedness.",
            priceNpr = "NPR 180.00 - 320.00 per vial (6mg/2ml)",
            priceInr = "INR 110.00 - 220.00 per vial (6mg/2ml)",
            brandsNepal = listOf(
                BrandInfo("Adeno-NPL", "Nepal Pharmaceuticals Lab", "Vial Inj", "6 mg / 2 ml"),
                BrandInfo("Cardiosine", "Deurali-Janta Pharmaceuticals", "Vial Inj", "6 mg / 2 ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Adenocor", "Sanofi India", "Vial Inj", "6 mg / 2 ml"),
                BrandInfo("Adenoject", "Neon Laboratories", "Vial Inj", "6 mg / 2 ml"),
                BrandInfo("Adneon", "Neon Labs", "Vial Inj", "6 mg / 2 ml")
            ),
            pediatricDosePerKg = 0.1,
            pediatricInterval = "mg/kg rapid IV bolus (max 6 mg), second dose 0.2 mg/kg (max 12 mg)",
            adultDose = "6 mg rapid IV push, then 12 mg rapid IV push after 1-2 min if no conversion.",
            childDose = "0.1 mg/kg rapid IV push (max 6 mg), followed by 0.2 mg/kg (max 12 mg) with immediate flush.",
            contraindications = "Second- or third-degree AV block (without functioning pacemaker), Sick Sinus Syndrome, Bronchospastic lung disease / Severe Asthma (risk of lethal bronchoconstriction).",
            modeOfAction = "Stimulates cardiac purinergic A1 receptors, activating outward potassium channels and inhibiting calcium influx. This produces profound transient hyperpolarization and conduction block in the AV node, terminating reentrant circuits.",
            interactions = "Theophylline / Caffeine / Methylxanthines: Competitive adenosine receptor antagonists; require higher adenosine doses. Dipyridamole / Carbamazepine: Block adenosine uptake and potentate action; initial adenosine dose should be reduced to 3 mg (50% reduction).",
            packSize = "Box of 2 / 5 glass vials (6 mg/2 mL)",
            precautions = "Continuous 12-lead ECG rhythm strip running during injection. Resuscitation equipment, bag-valve-mask, and defibrillator at bedside."
        ),
        Drug(
            id = "d25",
            genericName = "Budesonide + Formoterol Fumarate",
            system = "Respiratory System (RS)",
            drugClass = "Inhaled Corticosteroid (ICS) + Long-Acting Beta-2 Agonist (LABA)",
            blackBoxWarning = null,
            indications = "Asthma (Preferred Track 1 Controller and Reliever / SMART regimen per GINA 2024 Guidelines), Moderate-to-Severe Chronic Obstructive Pulmonary Disease (COPD) maintenance.",
            doses = "Asthma Maintenance & Reliever (SMART / MART):\n• Maintenance: 1-2 inhalations (160/4.5 mcg or 200/6 mcg) twice daily (morning & night).\n• Reliever: 1 inhalation as needed for acute symptoms. (Maximum recommended total in a single day: 8-12 inhalations).\nGINA Track 1 Steps 1-2: 1 inhalation (160/4.5 mcg) as-needed only for symptom relief.",
            administration = "Oral inhalation via dry powder inhaler (DPI / Turbuhaler) or pressurized metered-dose inhaler (pMDI).",
            timing = "Regular morning and evening dosing, plus additional single puffs as needed for sudden symptom onset.",
            specialInstructions = "MANDATORY: Rinse mouth thoroughly with water and spit it out after every inhalation to prevent oral candidiasis (thrush) and dysphonia.",
            pkPd = "Budesonide has high topical glucocorticoid potency with high first-pass hepatic clearance (~90%). Formoterol has rapid onset of bronchodilation within 1-3 minutes (comparable to salbutamol) with long 12-hour duration of action.",
            renalAdj = "No dosage adjustments required in renal impairment.",
            hepaticAdj = "No routine adjustment needed; monitor in severe hepatic impairment due to decreased steroid clearance.",
            pregnancy = "Category B / C (Budesonide is the most studied and preferred inhaled corticosteroid in pregnancy; maintaining asthma control is vital for fetal oxygenation).",
            lactation = "Excreted into breast milk in minute amounts; safe and compatible with breastfeeding.",
            sideEffects = "Oral candidiasis (thrush), dysphonia (hoarseness), cough, throat irritation, fine skeletal muscle tremor, palpitations, headache.",
            priceNpr = "NPR 450.00 - 750.00 per DPI / Inhaler (120 doses)",
            priceInr = "INR 280.00 - 480.00 per DPI / Inhaler",
            brandsNepal = listOf(
                BrandInfo("Budetrol-DJ", "Deurali-Janta Pharmaceuticals", "Inhaler / DPI", "200/6 mcg / 400/6 mcg"),
                BrandInfo("Formonide-NPL", "Nepal Pharmaceuticals Lab", "Inhaler / Rotacaps", "100/6 mcg / 200/6 mcg"),
                BrandInfo("Budez-Asian", "Asian Pharmaceuticals", "Inhaler", "200/6 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Symbicort", "AstraZeneca India", "Turbuhaler", "160/4.5 mcg / 320/9 mcg"),
                BrandInfo("Foracort", "Cipla Ltd.", "Inhaler / Rotacaps / Autohaler", "100 / 200 / 400 mcg"),
                BrandInfo("Budamate", "Lupin Pharmaceuticals", "Transhaler", "100 / 200 / 400 mcg")
            ),
            adultDose = "SMART therapy: 1-2 puffs (160/4.5 or 200/6) BID + 1 puff PRN reliever (max 12 puffs/day).",
            childDose = "Adolescents ≥12 years: Same as adult SMART regimen. Children 6-11 years: 80/4.5 mcg BID.",
            contraindications = "Hypersensitivity to budesonide, formoterol, or milk proteins (in lactose-containing DPI formulations).",
            modeOfAction = "Budesonide suppresses airway mucosal inflammation, cytokine cascade, and eosinophil infiltration; Formoterol relaxes bronchial smooth muscle via long-acting beta-2 adrenergic stimulation with rapid onset.",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole, Itraconazole): May increase systemic budesonide exposure. Non-selective beta-blockers: Antagonize formoterol bronchodilation.",
            packSize = "Inhaler canister (120 actuations); Rotacaps pack of 30 with Rotahaler device",
            precautions = "Assess inhaler technique regularly. Taper slowly when stepped-down after ≥3 months of stable control."
        ),
        Drug(
            id = "d26",
            genericName = "Mesalamine (5-ASA / Mesalazine)",
            system = "Gastrointestinal System (GIT)",
            drugClass = "Aminosalicylate Anti-Inflammatory Agent",
            blackBoxWarning = null,
            indications = "Ulcerative Colitis (First-line induction and maintenance of remission per ACG Guidelines), Mild-to-Moderate Crohn's Colitis (adjunctive).",
            doses = "Induction of Remission in UC:\n• Extensive / Left-Sided Colitis: 2.4 g to 4.8 g PO daily in divided doses (e.g., 1.2 g TID or 2.4 g BID or 4.8 g OD extended release) PLUS Topical Mesalamine enema (4 g/day) or suppository (1 g/day).\n• Proctitis: 1 g rectally (suppository) once daily at bedtime.\nMaintenance of Remission: 2.4 g PO once daily indefinitely.",
            administration = "Oral delayed-release / extended-release tablets (swallow whole, do NOT crush or chew) or rectal suppositories / enemas at bedtime.",
            timing = "With or without meals; rectal formulations immediately prior to sleep after emptying rectum.",
            specialInstructions = "Retain rectal enema for at least 8 hours overnight. Do not break or chew delayed-release tablets as the pH-dependent coating prevents premature gastric dissolution.",
            pkPd = "Locally acting topically on colonic mucosal epithelium. Minimal systemic absorption (~20-30% depending on formulation); absorbed drug undergoes rapid N-acetylation in intestinal mucosal cells and liver to N-acetyl-5-ASA; excreted primarily in feces and urine.",
            renalAdj = "Mild-to-moderate renal impairment: Use with caution; monitor serum creatinine at baseline, 3 months, and yearly. Severe renal impairment (CrCl <30 mL/min): Avoid use.",
            hepaticAdj = "Caution in severe hepatic failure.",
            pregnancy = "Category B (Safe throughout pregnancy and lactation; maintaining UC remission prevents adverse pregnancy outcomes).",
            lactation = "Excreted into breast milk in low concentrations; compatible with breastfeeding (monitor infant for loose stools).",
            sideEffects = "Headache, nausea, abdominal pain, flatulence, diarrhea, acute intolerance syndrome (cramping, fever, bloody diarrhea mimicking UC flare), interstitial nephritis (rare), pancreatitis.",
            priceNpr = "NPR 18.00 - 35.00 per tab (500mg/1200mg)",
            priceInr = "INR 12.00 - 25.00 per tab (500mg/1200mg)",
            brandsNepal = listOf(
                BrandInfo("Mesacol-DJ", "Deurali-Janta Pharmaceuticals", "DR Tab", "500 mg / 800 mg"),
                BrandInfo("Asacol-Nepal", "Nepal Pharmaceuticals Lab", "Tab", "400 mg / 800 mg"),
                BrandInfo("Salocare", "Asian Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Mesacol", "Sun Pharma", "DR Tab / Suppository / Enema", "400 / 800 / 1200 mg / 1g Supp"),
                BrandInfo("Asacol", "Zydus Cadila", "Tab / Suppository", "400 mg / 800 mg"),
                BrandInfo("Pentasa", "Ferring Pharmaceuticals", "PR Granules / Tab", "500 mg / 1g"),
                BrandInfo("Salofalk", "Dr. Falk Pharma India", "Granules / Tab", "500 mg / 1000 mg")
            ),
            adultDose = "Induction: 2.4-4.8 g PO daily + 1 g rectal suppository OD. Maintenance: 2.4 g PO OD.",
            childDose = "Pediatric UC: 40-70 mg/kg/day PO divided q12h (max 4.8 g/day).",
            contraindications = "Hypersensitivity to salicylates (aspirin allergy) or mesalamine formulations.",
            modeOfAction = "Exerts topical anti-inflammatory action on intestinal mucosal lining by inhibiting cyclooxygenase (COX) and lipoxygenase (5-LOX), suppressing prostaglandin and leukotriene synthesis, scavenging free radicals, and activating PPAR-gamma receptors.",
            interactions = "Nephrotoxic drugs (NSAIDs, Aminoglycosides): Heightened risk of nephrotoxicity. Azathioprine / 6-Mercaptopurine: Mesalamine inhibits TPMT enzyme, increasing risk of severe bone marrow suppression / leukopenia.",
            packSize = "Strips of 10 delayed-release tablets; Boxes of 5/10 rectal suppositories",
            precautions = "Baseline and periodic renal function (BUN/Creatinine) and urinalysis testing every 6-12 months."
        ),
        Drug(
            id = "d27",
            genericName = "Bismuth Subsalicylate / Subcitrate",
            system = "Gastrointestinal System (GIT)",
            drugClass = "Gastroprotective & Antisecretory / Antibacterial Heavy Metal Compound",
            blackBoxWarning = null,
            indications = "Helicobacter Pylori Eradication (Core component of First-Line Bismuth Quadruple Therapy per ACG 2024 / Maastricht VI Guidelines), Traveler's Diarrhea, Dyspepsia / Pyrosis.",
            doses = "H. Pylori Quadruple Therapy:\n• Bismuth Subsalicylate: 300 mg (or 524 mg) PO QID (with meals & bedtime) for 14 days, co-prescribed with PPI BID, Tetracycline 500 mg QID, and Metronidazole 500 mg QID/TID.\n• Or Bismuth Subcitrate: 120 mg to 300 mg PO QID x 14 days.",
            administration = "Oral chewable tablets (must be chewed completely) or swallowable tablets/capsules taken with meals and at bedtime.",
            timing = "Four times daily: with breakfast, lunch, dinner, and at bedtime.",
            specialInstructions = "REASSURE THE PATIENT: Bismuth routinely causes harmless dark, blackish discoloration of the tongue and stool (caused by bismuth sulfide formation). Do NOT mistake for melena!",
            pkPd = "Undergoes chemical cleavage in the stomach. Bismuth is poorly absorbed (<1%) and acts locally in the gastric mucosa; salicylate component is >80% absorbed systemically and excreted renally.",
            renalAdj = "Contraindicated in severe renal failure (risk of neurotoxic bismuth accumulation).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C/D (Avoid in pregnancy due to systemic salicylate absorption and risk of premature ductus arteriosus closure).",
            lactation = "Avoid during breastfeeding due to potential salicylate transmission and Reye's syndrome risk.",
            sideEffects = "Black-colored stools, temporary darkening of the tongue, constipation, mild nausea, salicylate toxicity / tinnitus (at high doses).",
            priceNpr = "NPR 8.00 - 15.00 per tab (300mg)",
            priceInr = "INR 5.00 - 10.00 per tab (300mg)",
            brandsNepal = listOf(
                BrandInfo("Pylokit-Bismuth", "Deurali-Janta Pharmaceuticals", "Combo Pack", "Kit"),
                BrandInfo("Bismu-NPL", "Nepal Pharmaceuticals Lab", "Tab", "300 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Trymo", "West-Coast Pharmaceutical", "Tab", "120 mg / 300 mg"),
                BrandInfo("Pepto-Bismol", "Procter & Gamble", "Chewable Tab / Liquid", "262 mg"),
                BrandInfo("Pylosafe", "Torrent Pharmaceuticals", "Tab", "300 mg")
            ),
            adultDose = "H. Pylori Quadruple Therapy: 300 mg (or 524 mg) PO QID x 14 days with meals and bedtime.",
            childDose = "Not recommended in children <12 years recovering from viral illnesses (Reye's syndrome risk from salicylate).",
            contraindications = "Aspirin/salicylate allergy, severe renal impairment, bleeding ulcer with active massive hemorrhage, children recovering from chickenpox or influenza.",
            modeOfAction = "Exerts direct bactericidal action against H. pylori by lysing bacterial cell walls, inhibiting bacterial ATP synthesis and urease activity, and preventing bacterial mucosal adherence. Also forms a protective bismuth-protein protective coating over ulcer craters.",
            interactions = "Tetracyclines: Bismuth binds and reduces tetracycline absorption; separate administration by at least 1-2 hours or follow specific quadruple dosing. Aspirin / Anticoagulants: Additive salicylate toxicity.",
            packSize = "Strips of 10 or 14 tablets; specialized H. pylori eradication blister kits",
            precautions = "Do not exceed 14 days of continuous high-dose quadruple therapy to prevent bismuth encephalopathy."
        ),
        Drug(
            id = "d28",
            genericName = "Atropine Sulfate",
            system = "Emergency Toxicology & Critical Care",
            drugClass = "Antimuscarinic / Anticholinergic Parasympatholytic Agent",
            blackBoxWarning = null,
            indications = "Organophosphate / Carbamate Insecticide Poisoning (Specific Antidote), Symptomatic Sinus Bradycardia (ACLS First-Line), Preoperative Reduction of Salivary and Bronchial Secretions, Antidote for Muscarinic Mushroom Poisoning (Inocybe, Clitocybe).",
            doses = "Organophosphate Toxicity (Atropinization Protocol):\n• Initial: 2 to 5 mg IV bolus immediately.\n• Repeat: Double the dose every 5 to 10 minutes until ATROPINIZATION achieved (clear chest on auscultation, HR >80, SBP >90, dry axillae). Hundreds of milligrams may be required in severe OP poisoning!\nACLS Bradycardia: 1 mg IV rapid push q3-5 minutes (Maximum total dose: 3 mg).",
            administration = "Intravenous injection bolus, IO, or IM. In OP poisoning, give IV push directly; once atropinized, maintain continuous IV infusion (10-20% of total loading dose required per hour).",
            timing = "Immediately upon clinical recognition of severe cholinergic toxidrome or symptomatic bradycardia.",
            specialInstructions = "ATROPINIZATION ENDPOINTS: Clear lungs on auscultation (cessation of bronchorrhea and bronchospasm) is the SINGLE MOST CRITICAL therapeutic endpoint. Pupillary dilatation is NOT an adequate indicator of atropinization!",
            pkPd = "Rapid onset within 1-2 minutes IV. Peak effect 2-4 minutes. Elimination half-life ~2-4 hours. Rapidly distributed throughout body tissues; crosses blood-brain barrier. Extensively hydrolyzed in liver and excreted in urine.",
            renalAdj = "No adjustment needed in emergency toxicology.",
            hepaticAdj = "No adjustment needed in acute poisoning.",
            pregnancy = "Category C (Life-saving emergency antidote; cross-placenta anticholinergic effects are secondary to maternal survival).",
            lactation = "Compatible in emergency life-saving resuscitation.",
            sideEffects = "Tachycardia, palpitations, dry mouth, urinary retention, blurred vision, photophobia, cycloplegia, delirium / hallucinations (atropine toxicity), flushing, hyperthermia.",
            priceNpr = "NPR 12.00 - 25.00 per ampoule (0.6mg/mL)",
            priceInr = "INR 8.00 - 18.00 per ampoule (0.6mg/mL)",
            brandsNepal = listOf(
                BrandInfo("Tropine-NPL", "Nepal Pharmaceuticals Lab", "Inj Ampoule", "0.6 mg/ml"),
                BrandInfo("Atro-DJ", "Deurali-Janta Pharmaceuticals", "Inj Ampoule", "0.6 mg/ml"),
                BrandInfo("Atrosun", "Sun Pharma Nepal", "Inj Ampoule", "0.6 mg/ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Atropine Injection", "Neon Laboratories", "Inj Ampoule", "0.6 mg/ml / 1 mg/ml"),
                BrandInfo("Atrofit", "Bharat Serums & Vaccines", "Inj Ampoule", "0.6 mg/ml"),
                BrandInfo("Tropine", "Harson Laboratories", "Inj", "0.6 mg/ml")
            ),
            pediatricDosePerKg = 0.02,
            pediatricInterval = "mg/kg IV/IM (Min 0.1 mg, max 0.5 mg single dose) in bradycardia",
            adultDose = "OP Poisoning: 2-5 mg IV q5-10min doubling until atropinized. Bradycardia: 1 mg IV q3-5min (max 3mg).",
            childDose = "OP Poisoning: 0.05 mg/kg IV q5-10min until lungs clear. Bradycardia: 0.02 mg/kg IV (min 0.1 mg, max 0.5 mg).",
            contraindications = "There are NO absolute contraindications to atropine in life-threatening organophosphate poisoning or extreme hemodynamic collapse.",
            modeOfAction = "Competitively antagonizes acetylcholine at postganglionic muscarinic acetylcholine receptors (M1, M2, M3), reversing excessive cholinergic hyperstimulation (killer 'B's: Bronchorrhea, Bronchospasm, Bradycardia).",
            interactions = "Other anticholinergic agents (Antihistamines, TCAs, Phenothiazines): Additive anticholinergic delirium and hyperthermia. Pralidoxime (2-PAM): Synergistic antidote reversal in OP poisoning.",
            packSize = "Box of 10 / 25 glass ampoules (0.6 mg/mL, 1 mL)",
            precautions = "Beware of Atropine Toxicity: Hyperthermia, delirium, agitation, completely dry skin. If toxic, withhold atropine temporarily until signs abate."
        ),
        Drug(
            id = "d29",
            genericName = "Polyvalent Anti-Snake Venom (ASV)",
            system = "Emergency Toxicology & Critical Care",
            drugClass = "Purified Equine Immunoglobulin Fragments (F(ab')2 Antivenom)",
            blackBoxWarning = "ANAPHYLACTIC SHOCK HAZARD: Equine-derived heterologous serum carries a 10-30% risk of acute anaphylaxis and late serum sickness. Epinephrine (1:1,000) 0.5 mg IM, IV Hydrocortisone, and Chlorpheniramine must be drawn up at the bedside before starting infusion.",
            indications = "Systemic Envenomation from Poisonous Snakebites (Vipers: Russell's Viper, Saw-scaled Viper; Elapids: Common Krait, Indian Cobra, King Cobra) per WHO SEARO and Nepal National Guidelines.",
            doses = "Initial Loading Dose: 10 vials (100 mL) reconstituted in 500 mL Normal Saline or 5% Dextrose, infused IV over 1 hour.\nFirst 10-15 minutes: Infuse very slowly (1-2 mL/min or 20-30 drops/min) while observing closely for anaphylactoid reactions.\nRepeat Dosing: In hemotoxic bites, if 20-minute Whole Blood Clotting Test (20WBCT) remains non-clotting at 6 hours post-ASV, repeat 5 to 10 vials.",
            administration = "INTRAVENOUS INFUSION ONLY. Reconstitute each lyophilized vial with 10 mL sterile water. Dilute in 500 mL NS (or 5-10 mL/kg in children) and infuse over 1 hour. NEVER inject locally at bite site!",
            timing = "Immediately once systemic or severe local envenomation is clinically or laboratory verified.",
            specialInstructions = "20-MINUTE WHOLE BLOOD CLOTTING TEST (20WBCT): Place 2 mL freshly drawn venous blood into a new, dry glass tube; leave undisturbed at ambient temperature for 20 minutes. Tilt tube gently: if blood runs freely (fails to clot), systemic hemotoxic envenomation is established!",
            pkPd = "Equine F(ab')2 fragments rapidly bind and neutralize circulating free snake venom antigens in intravascular and interstitial compartments. Terminal elimination half-life ~48-72 hours.",
            renalAdj = "Full dose indicated regardless of acute kidney injury (AKI is common in Russell's viper envenomation; early ASV protects renal microvasculature).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Indicated immediately: snake venom causes placental abruption, fetal demise, and maternal hemorrhage; antivenom saves both mother and fetus).",
            lactation = "Safe and indicated in life-threatening envenomation.",
            sideEffects = "Early anaphylactoid reactions (urticaria, wheezing, hypotension, angioedema in 10-25%), pyrogenic fever and rigors, late Serum Sickness (fever, arthralgias, proteinuria 7-14 days post-infusion).",
            priceNpr = "NPR 1,200 - 2,200 per vial (Govt subsidized in Nepal emergency health posts)",
            priceInr = "INR 650.00 - 1,200.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Bharat ASV (Polyvalent)", "Bharat Serums & Vaccines (Nepal Supply)", "Lyophilized Vial", "Polyvalent 10ml"),
                BrandInfo("Vins ASV", "Vins Bioproducts (Nepal Health Ministry)", "Lyophilized Vial", "Polyvalent 10ml"),
                BrandInfo("Haffkine ASV", "Haffkine Bio-Pharmaceutical (Govt)", "Lyophilized Vial", "Polyvalent 10ml")
            ),
            brandsIndia = listOf(
                BrandInfo("Snake Venom Antiserum", "Bharat Serums & Vaccines", "Vial Inj", "10 ml Lyophilized"),
                BrandInfo("Polyvalent Snake Antivenin", "Vins Bioproducts", "Vial Inj", "10 ml Lyophilized"),
                BrandInfo("Haffkine Antivenom", "Haffkine Institute", "Vial Inj", "10 ml Lyophilized")
            ),
            adultDose = "10 vials (100 mL) reconstituted in 500 mL NS IV over 1h; repeat 5-10 vials if 20WBCT abnormal at 6h.",
            childDose = "Same as adult dose (10 vials) — snakes inject the same volume of venom regardless of patient body weight!",
            contraindications = "There are NO absolute contraindications to antivenom in systemic envenomation. Treat any concurrent anaphylactic reaction with IM Epinephrine and resume ASV.",
            modeOfAction = "Polyvalent equine F(ab')2 antibodies specifically bind, sequester, and neutralize the diverse neurotoxic, hemotoxic, cardiotoxic, and myotoxic enzyme components of Big Four snake venoms.",
            interactions = "No adverse pharmacological drug interactions. Co-administer Neostigmine + Atropine in neurotoxic elapid envenomation for neuromuscular junction recovery.",
            packSize = "Individual lyophilized vial with 10 mL sterile water for injection diluent",
            precautions = "Keep Epinephrine (1:1,000) 0.5 mL IM drawn up. If anaphylaxis occurs: stop ASV, give Epinephrine 0.5 mg IM, IV Chlorpheniramine 10mg, IV Hydrocortisone 100mg. Once resolved, restart ASV slowly."
        ),
        Drug(
            id = "d30",
            genericName = "Pralidoxime Chloride (2-PAM)",
            system = "Emergency Toxicology & Critical Care",
            drugClass = "Cholinesterase Reactivator (Oxime)",
            blackBoxWarning = null,
            indications = "Organophosphate Insecticide Toxicity / Cholinesterase Inhibitor Poisoning (Co-administered with Atropine Sulfate).",
            doses = "Loading Dose: 1 to 2 g IV in 100 mL Normal Saline infused over 15 to 30 minutes.\nMaintenance Infusion: Continuous IV infusion of 8 mg/kg/hour (or 500 mg/hour in adults) for 24-48 hours until muscle weakness resolves and patient remains stable after atropine tapering.\nIntermittent Alternative: 1-2 g IV slow infusion repeated every 4 to 6 hours.",
            administration = "Intravenous infusion only. Rapid IV injection can cause neuromuscular blockade, laryngospasm, hypertension, and cardiac arrest; must infuse over at least 15-30 minutes.",
            timing = "Give as early as possible after initiating Atropine. Most effective if given within the first 24-48 hours before irreversible 'aging' of the phosphorylated enzyme occurs.",
            specialInstructions = "NEVER ADMINISTER PRALIDOXIME WITHOUT ATROPINE: Atropine must always be administered first or simultaneously to protect central and peripheral muscarinic receptor overload.",
            pkPd = "Distributed throughout extracellular water; poorly crosses blood-brain barrier (primarily active at peripheral neuromuscular junctions). Rapidly excreted unchanged in urine (80-90%). Elimination half-life ~1-2 hours.",
            renalAdj = "Reduce infusion rate by 50% in renal impairment (CrCl <50 mL/min).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Indicated in severe maternal OP poisoning; atropinization and maternal oxygenation take priority).",
            lactation = "Compatible in emergency life-saving toxicology management.",
            sideEffects = "Dizziness, blurred vision, diplopia, headache, nausea, tachycardia, hypertension, muscle rigidity, transient hyperventilation.",
            priceNpr = "NPR 180.00 - 320.00 per vial (1g/20ml)",
            priceInr = "INR 120.00 - 240.00 per vial (1g/20ml)",
            brandsNepal = listOf(
                BrandInfo("PAM-NPL", "Nepal Pharmaceuticals Lab", "Vial Inj", "1 g / 20 ml"),
                BrandInfo("Aldopam", "Deurali-Janta Pharmaceuticals", "Vial Inj", "1 g"),
                BrandInfo("Neopam", "Asian Pharmaceuticals", "Vial Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Neopam", "Neon Laboratories", "Vial Inj", "1 g / 20 ml"),
                BrandInfo("Pam Injection", "Bharat Serums & Vaccines", "Vial Inj", "1 g"),
                BrandInfo("Pralidoxime Chloride", "Samarth Life Sciences", "Vial Inj", "1 g")
            ),
            pediatricDosePerKg = 25.0,
            pediatricInterval = "mg/kg IV loading over 30 min (max 1g), then 10-20 mg/kg/hr infusion",
            adultDose = "1-2 g IV in 100 mL NS over 30 min, then continuous infusion 8 mg/kg/hr (500 mg/hr).",
            childDose = "25-50 mg/kg IV over 30 min, then continuous infusion 10-20 mg/kg/hr.",
            contraindications = "Known hypersensitivity to pralidoxime; relatively ineffective in pure carbamate poisoning (spontaneous decarbamylation occurs).",
            modeOfAction = "Nucleophilic attack on the organophosphate-inactivated acetylcholinesterase enzyme, removing the phosphate group and reactivating acetylcholinesterase, specifically relieving skeletal muscle nicotinic paralysis.",
            interactions = "Succinylcholine, Morphine, Theophylline, Reserpine, and Phenothiazine tranquilizers should be strictly avoided in OP poisoning.",
            packSize = "Glass vial of 1 g lyophilized powder with 20 mL sterile water diluent",
            precautions = "Monitor ECG, blood pressure, and renal function. Avoid rapid infusion to prevent iatrogenic hypertensive crisis and neuromuscular weakness."
        )
    )

    val drugs: List<Drug> = baseDrugs + AdditionalDrugsData.additionalDrugs

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
        ),
        DiseaseProtocol(
            id = "dp8",
            name = "Bronchial Asthma (GINA 2024 Guidelines)",
            category = "Respiratory & Allergy",
            firstLine = "Track 1 (Preferred Controller & Reliever): Low-dose Inhaled Corticosteroid (ICS)-Formoterol (e.g., Budesonide 160 mcg / Formoterol 4.5 mcg) 1-2 puffs PRN as needed for symptoms (Steps 1-2), or 1 puff BID plus PRN (Step 3).\nTrack 2 (Alternative): Regular daily low-dose ICS + SABA (Salbutamol 100-200 mcg) PRN for reliever.",
            secondLine = "Step 4: Medium-dose ICS-Formoterol maintenance and reliever (SMART therapy) or add LAMA (Tiotropium Respimat 5 mcg OD).\nStep 5: High-dose ICS-LABA + add LAMA + evaluate phenotype (IgE, Blood Eosinophils) for Biologics (Omalizumab, Mepolizumab, Dupilumab).",
            inpatient = "Acute Severe Exacerbation: High-flow O2 (target SpO2 93-95% adults, 94-98% children). Continuous/frequent Nebulized Salbutamol 5 mg + Ipratropium 500 mcg q20min x 3 doses. IV/Oral Systemic Corticosteroids: Prednisolone 40-50 mg PO OD x 5-7 days or Hydrocortisone 100 mg IV q6h. Severe refractoriness: IV Magnesium Sulfate 2 g in 100 mL NS over 20 min.",
            guidelines = "Global Initiative for Asthma (GINA) 2024 Strategy Report & British Thoracic Society (BTS/SIGN)."
        ),
        DiseaseProtocol(
            id = "dp9",
            name = "Acute Myocardial Infarction - STEMI & NSTEMI (AHA/ACC Guidelines)",
            category = "Cardiovascular & Critical Care",
            firstLine = "Initial Emergency Therapy (MONA-B): Aspirin 300-325 mg non-enteric chewable PO immediately. Sublingual Nitroglycerin 0.4 mg SL q5min up to 3 doses (contraindicated if SBP <90, HR <50 or >100, RV infarction, or PDE-5 inhibitors in past 24-48h). Supplemental O2 only if SpO2 <90%. Morphine 2-4 mg IV only if pain refractory.",
            secondLine = "Dual Antiplatelet Therapy (DAPT): Add P2Y12 inhibitor (Ticagrelor 180 mg loading then 90 mg BID, or Prasugrel 60 mg load then 10 mg OD, or Clopidogrel 600 mg load then 75 mg OD). Anticoagulation: Unfractionated Heparin (UFH 60 units/kg IV bolus max 4000 units, then 12 units/kg/hr) or Enoxaparin 1 mg/kg SC q12h. High-intensity Statin: Atorvastatin 80 mg PO immediately.",
            inpatient = "STEMI Reperfusion Strategy: Primary PCI within 90 minutes of first medical contact (door-to-balloon <90 min). If PCI unavailable within 120 minutes, administer Fibrinolysis (Tenecteplase weight-based IV bolus over 5-10 sec, or Alteplase/Streptokinase 1.5 million units IV over 60 min) within 30 min (door-to-needle <30 min). Post-MI: Early oral Beta-blocker (Metoprolol 25-50 mg BID within 24h if hemodynamically stable, no heart block or acute heart failure) + ACE-I/ARB + Aldosterone antagonist if LVEF ≤40%.",
            guidelines = "2023 ACC/AHA & ESC Guidelines for the Management of Acute Coronary Syndromes."
        ),
        DiseaseProtocol(
            id = "dp10",
            name = "Acute Ischemic Stroke (AHA/ASA Guidelines)",
            category = "Central Nervous System & Emergency",
            firstLine = "Rapid Triage & Neuroimaging (Non-contrast Brain CT/MRI within 20 min of arrival). Airway & Oxygenation (target SpO2 >94%). Blood Glucose correction (target 140-180 mg/dL, treat hypoglycemia immediately). Blood Pressure control: If candidate for IV thrombolysis, lower BP to <185/110 mmHg with Labetalol 10-20 mg IV over 1-2 min or Nicardipine IV infusion.",
            secondLine = "IV Thrombolysis: IV Alteplase (0.9 mg/kg, max 90 mg; 10% as bolus over 1 min, remaining 90% infused over 60 min) or Tenecteplase (0.25 mg/kg IV single bolus, max 25 mg) administered within 4.5 hours of symptom onset / last known well. Mechanical Thrombectomy: Indicated for Large Vessel Occlusion (LVO) of anterior circulation within 6 to 24 hours (DAWN/DEFUSE-3 criteria).",
            inpatient = "Post-Thrombolysis Management: ICU monitoring, strict BP control maintaining <180/105 mmHg for at least 24 hours. Hold all antiplatelets and anticoagulants for 24 hours until repeat CT/MRI excludes intracranial hemorrhage. At 24 hours post-tPA: Aspirin 160-300 mg PO daily + Clopidogrel 75 mg (DAPT x 21 days for minor stroke NIHSS ≤3 or high-risk TIA ABCD2 ≥4) + High-intensity Atorvastatin 80 mg PO OD.",
            guidelines = "AHA/ASA Guidelines for the Early Management of Patients with Acute Ischemic Stroke (2019/2023 Update)."
        ),
        DiseaseProtocol(
            id = "dp11",
            name = "Status Epilepticus & Acute Seizure (AES / Neurocritical Care Guidelines)",
            category = "Central Nervous System & Critical Care",
            firstLine = "Phase 1 (0–5 minutes): ABCDE, high-flow O2, check fingerstick glucose (if <60 mg/dL, give 50 mL 50% Dextrose + Thiamine 100 mg IV). IV access.\nPhase 2 Emergent Initial Therapy (5–20 minutes): First-line Benzodiazepine: Lorazepam 4 mg IV slow push (0.1 mg/kg) over 2 min (repeat once if seizures continue at 5-10 min) OR Midazolam 10 mg IM (if no IV access) OR Diazepam 10 mg IV (0.2 mg/kg) at 2-5 mg/min.",
            secondLine = "Phase 3 Urgent Control Therapy (20–40 minutes): Second-line IV Antiseizure Medication: Levetiracetam (Keppra) 60 mg/kg IV (max 4500 mg) over 10 min OR Fosphenytoin 20 mg PE/kg IV (max 1500 mg PE) at 150 mg PE/min with cardiac monitoring OR Sodium Valproate 40 mg/kg IV (max 3000 mg) over 5-10 min.",
            inpatient = "Phase 4 Refractory Status Epilepticus (>40 minutes): Continuous General Anesthesia & Endotracheal Intubation with continuous EEG monitoring. Propofol (2 mg/kg IV bolus then 2-10 mg/kg/hr) OR Midazolam infusion (0.2 mg/kg bolus then 0.05-2 mg/kg/hr) OR Ketamine (1-2 mg/kg load then 1-5 mg/kg/hr). Titrate to burst suppression on EEG for 24-48 hours.",
            guidelines = "American Epilepsy Society (AES) Guidelines & Neurocritical Care Society Status Epilepticus Protocol."
        ),
        DiseaseProtocol(
            id = "dp12",
            name = "Anaphylaxis & Severe Hypersensitivity (WAO / EAACI Guidelines)",
            category = "Emergency & Critical Care",
            firstLine = "IMMEDIATE FIRST-LINE: Epinephrine (Adrenaline) 1:1000 (1 mg/mL) given Intramuscularly (IM) into mid-anterolateral thigh. Adult Dose: 0.5 mg (0.5 mL) IM. Pediatric Dose: 0.01 mg/kg IM (max 0.3 mg). Repeat every 5 to 15 minutes if symptoms persist or deteriorate. Place patient supine with legs elevated (do NOT allow patient to sit up or stand suddenly, risk of empty ventricle syndrome).",
            secondLine = "High-flow Oxygen (10-15 L/min via non-rebreather mask). Rapid IV Fluid Resuscitation: Crystalloids (Normal Saline or Ringer's Lactate) 1-2 L rapid bolus in adults (20 mL/kg in children) for anaphylactic shock/hypotension. Inhaled Salbutamol 2.5-5 mg nebulized for refractory bronchospasm.",
            inpatient = "Secondary Adjunctive Medications (Never delay epinephrine): Chlorpheniramine 10 mg IV/IM or Diphenhydramine 25-50 mg IV (H1 antihistamine) + Ranitidine/Famotidine 20 mg IV (H2 antagonist) + Hydrocortisone 200 mg IV (prevents biphasic reaction). Epinephrine Refractory Shock: Start continuous Epinephrine IV infusion (0.1-1 mcg/kg/min). If patient taking beta-blockers: Glucagon 1-5 mg IV over 5 min followed by infusion 5-15 mcg/min. Monitor in hospital for at least 6-12 hours (risk of late biphasic anaphylaxis in up to 20% of patients).",
            guidelines = "World Allergy Organization (WAO) Anaphylaxis Guidelines 2020 & Resuscitation Council UK."
        ),
        DiseaseProtocol(
            id = "dp13",
            name = "Ventricular Tachycardia (VT) - Monomorphic & Polymorphic (AHA/ACLS Guidelines)",
            category = "Cardiology & Emergency ACLS",
            firstLine = "Assessment: Check Pulses & Hemodynamic Stability.\nUnstable VT (Hypotension, altered mental status, signs of shock, ischemic chest discomfort, acute heart failure): IMMEDIATE Synchronized Cardioversion: Monophasic/Biphasic synchronized shock starting at 100 J (escalate to 200 J, 300 J, 360 J if unsuccessful). Administer conscious sedation (Etomidate 0.15 mg/kg or Midazolam 2-5 mg IV) if patient conscious.",
            secondLine = "Stable Monomorphic VT with Pulse: Amiodarone 150 mg IV over 10 minutes (repeat 150 mg if VT recurs; follow with maintenance infusion of 1 mg/min for 6 hours, then 0.5 mg/min for 18 hours, max 2.2 g/24h) OR Procainamide 20-50 mg/min IV (max 17 mg/kg) until arrhythmia suppressed or QRS widens >50% OR Lidocaine 1-1.5 mg/kg IV bolus.",
            inpatient = "Polymorphic VT / Torsades de Pointes (Prolonged QT): IV Magnesium Sulfate 2 g diluted in 100 mL D5W infused over 5-10 minutes (repeat in 15 min if needed). Overdrive transvenous pacing or Isoproterenol infusion (target HR >100 bpm). Correct hypokalemia (target K+ >4.5 mEq/L) and hypomagnesemia (target Mg2+ >2.5 mg/dL). Discontinue all QT-prolonging drugs.",
            guidelines = "AHA/ACC/HRS Guidelines for Management of Patients with Ventricular Arrhythmias & ACLS Protocols."
        ),
        DiseaseProtocol(
            id = "dp14",
            name = "Ventricular Fibrillation (VF) & Pulseless VT (AHA/ACLS Guidelines)",
            category = "Emergency Resuscitation (ACLS)",
            firstLine = "IMMEDIATE DEFIBRILLATION (Shockable Rhythm): High-quality CPR immediately while charging defibrillator. Defibrillate with unsynchronized high-energy shock: Biphasic 120-200 J (manufacturer recommendation, or max dose e.g., 200 J) or Monophasic 360 J. Immediately resume CPR for 2 full minutes without pausing to check pulse.",
            secondLine = "Vascular Access & Vasopressors: Obtain IV or IO access. Administer Epinephrine 1 mg IV/IO push after second shock; repeat every 3 to 5 minutes. Advanced Airway (Endotracheal tube or Supraglottic device) with continuous capnography (ETCO2 target >10-20 mmHg indicating effective chest compressions).",
            inpatient = "Refractory VF / Pulseless VT (persisting after 3rd shock): Administer Amiodarone 300 mg IV/IO bolus push (repeat second dose 150 mg IV/IO once after subsequent shock) OR Lidocaine 1 to 1.5 mg/kg first dose, then 0.5 to 0.75 mg/kg. Reversible Causes (H's and T's): Hypovolemia, Hypoxia, Hydrogen ion (acidosis), Hypo/Hyperkalemia, Hypothermia, Tension pneumothorax, Tamponade (cardiac), Toxins, Thrombosis (pulmonary PE or coronary MI). Post-Cardiac Arrest Care: Targeted Temperature Management (TTM 32-36°C for 24h), emergent coronary angiography if STEMI.",
            guidelines = "AHA ACLS Cardiac Arrest Algorithm 2020/2023 Update & ILCOR Consensus on CPR."
        ),
        DiseaseProtocol(
            id = "dp15",
            name = "Paroxysmal Supraventricular Tachycardia (PSVT / AVNRT / AVRT) (AHA/ACC/HRS)",
            category = "Cardiology & Emergency ACLS",
            firstLine = "Hemodynamically Stable: 1. Vagal Maneuvers: Modified Valsalva Maneuver (strain against closed glottis at 40 mmHg for 15 seconds, followed immediately by supine positioning with passive leg raise to 45 degrees for 15 seconds; converts up to 43% of SVT). 2. Carotid Sinus Massage (unilateral, 5-10 seconds; check for bruits first).",
            secondLine = "Pharmacologic Conversion: Adenosine Rapid IV Push: First dose 6 mg IV rapid push via large antecubital vein over 1-2 seconds, immediately followed by 20 mL Normal Saline flush and arm elevation. If SVT does not terminate within 1-2 minutes: Second dose 12 mg IV rapid push with 20 mL saline flush. Warn patient of transient impending doom, flushing, and brief sinus arrest.",
            inpatient = "Refractory PSVT or Adenosine Contraindicated (Asthma / severe bronchospasm): IV Non-dihydropyridine Calcium Channel Blocker: Diltiazem 0.25 mg/kg IV over 2 min (e.g., 20 mg), may repeat 0.35 mg/kg (25 mg) after 15 min, or Verapamil 2.5-5 mg IV over 2 min (repeat 5-10 mg after 15-30 min) OR IV Beta-blocker (Metoprolol 5 mg IV q5min up to 15 mg). Unstable PSVT (hypotension, pulmonary edema, chest pain): Immediate Synchronized Cardioversion at 50-100 J biphasic. Long-term: Catheter RF Ablation (curative in >95% cases) or oral Diltiazem/Verapamil/Beta-blocker prophylaxis.",
            guidelines = "ACC/AHA/HRS Guideline for the Management of Adult Patients with Supraventricular Tachycardia."
        ),
        DiseaseProtocol(
            id = "dp16",
            name = "Tuberculosis - Pulmonary & Extrapulmonary (WHO Guidelines 2024)",
            category = "Infectious Diseases & Pulmonary",
            firstLine = "Drug-Susceptible TB (Standard 6-Month 2HRZE / 4HR Regimen):\n• Intensive Phase (First 2 Months): Daily Fixed-Dose Combination (FDC) of 4 drugs: Isoniazid (H, 5 mg/kg, max 300 mg) + Rifampicin (R, 10 mg/kg, max 600 mg) + Pyrazinamide (Z, 25 mg/kg, max 2000 mg) + Ethambutol (E, 15 mg/kg, max 1600 mg).\n• Continuation Phase (Next 4 Months): Daily 2 drugs: Isoniazid (H) + Rifampicin (R) for 4 months.",
            secondLine = "Adjuncts: Pyridoxine (Vitamin B6) 20-50 mg PO daily co-administered with Isoniazid to prevent peripheral neuropathy (mandatory in pregnancy, diabetes, alcoholism, malnutrition, HIV, CKD). Meningeal or Pericardial TB: Add oral Dexamethasone (0.4 mg/kg/day tapered over 6-8 weeks) or Prednisolone (60 mg/day tapered over 6-8 weeks) to reduce mortality and constriction.",
            inpatient = "Drug-Resistant TB (MDR-TB / RR-TB): GeneXpert MTB/RIF at baseline. WHO 6-Month BPaLM/BPaL All-Oral Regimen: Bedaquiline (400 mg OD x 2 wks, then 200 mg 3x/wk x 24 wks) + Pretomanid (200 mg OD x 26 wks) + Linezolid (600 mg OD x 16-26 wks) + Moxifloxacin (400 mg OD x 26 wks). Monitoring: Sputum smear/culture at months 2, 5, and 6; baseline & monthly LFTs (ALT/AST, bilirubin), serum creatinine, visual acuity (Ethambutol optic neuritis), and audiometry.",
            guidelines = "WHO Consolidated Guidelines on Tuberculosis: Module 4 Treatment 2024 & National Tuberculosis Program (NTP Nepal / NTEP India)."
        ),
        DiseaseProtocol(
            id = "dp17",
            name = "Acute Pancreatitis (ACG & Atlanta Classification Guidelines)",
            category = "Gastrointestinal & Critical Care",
            firstLine = "Aggressive Early Goal-Directed IV Fluid Resuscitation: Lactated Ringer's solution preferred over Normal Saline (lower incidence of hyperchloremic acidosis and SIRS). Initial infusion: 200-500 mL/hr (or 5-10 mL/kg/hr for first 12-24h) unless cardiac/renal disease present. Targets: HR <120 bpm, MAP 65-85 mmHg, Urine Output >0.5-1 mL/kg/hr, hematocrit reduction towards 35-44%.",
            secondLine = "Pain Management & Early Enteral Nutrition: Multi-modal analgesia using IV Hydromorphone, Fentanyl, or Buprenorphine (or PCA). NSAIDs and Paracetamol IV as adjuncts. Early Oral Feeding: In mild pancreatitis, start low-fat solid or liquid oral diet as soon as nausea/vomiting resolves and ileus absent. In severe pancreatitis, start enteral tube feeding (nasogastric or nasojejunal) within 48-72 hours; avoid total parenteral nutrition (TPN) unless enteral route fails.",
            inpatient = "Severe Acute Pancreatitis (Persistent Organ Failure >48h / Infected Necrosis): Prophylactic antibiotics are NOT recommended for sterile necrosis. If infected necrotizing pancreatitis suspected/confirmed (fever, leukocytosis, gas on CT after 7-14 days): Carbapenem (Meropenem 1 g IV q8h) or Piperacillin-Tazobactam 4.5 g IV q6h or Ciprofloxacin + Metronidazole (good pancreatic parenchymal penetration). Gallstone Pancreatitis: Emergent ERCP within 24 hours if concurrent acute cholangitis present; elective index-admission cholecystectomy prior to hospital discharge to prevent recurrent biliary events.",
            guidelines = "American College of Gastroenterology (ACG) Guidelines: Management of Acute Pancreatitis 2024 & Revised Atlanta Classification."
        ),
        DiseaseProtocol(
            id = "dp18",
            name = "Ulcerative Colitis - Induction & Maintenance (ACG Guidelines)",
            category = "Gastrointestinal & Immunology",
            firstLine = "Mild-to-Moderate Distal / Extensive UC:\n• Proctitis: Mesalamine 1 g rectally (suppository) once daily at bedtime.\n• Left-Sided / Extensive Colitis: Combined Oral Mesalamine (2.4 g to 4.8 g/day PO) + Topical Mesalamine enema 1-4 g/day (combined oral + topical therapy is superior to oral alone).\n• Remission Maintenance: Oral Mesalamine 2.4 g/day PO indefinite maintenance.",
            secondLine = "Moderate-to-Severe Flare Unresponsive to 5-ASA: Oral Corticosteroids: Prednisone 40-60 mg PO daily with gradual taper over 8-12 weeks, OR Budesonide MMX 9 mg PO daily for 8 weeks (less systemic glucocorticoid toxicity). Note: Systemic steroids are for INDUCTION only, never for maintenance.",
            inpatient = "Acute Severe Ulcerative Colitis (ASUC) / Truelove and Witts Criteria (Bloody stools ≥6/day + tachycardia, fever, anemia, or ESR >30): Hospital admission, bowel rest, VTE prophylaxis with LMWH (high risk of thromboembolism). High-Dose IV Corticosteroids: Methylprednisolone 60 mg IV OD (or Hydrocortisone 100 mg IV q6h). Assess response on Day 3 (Oxford criteria: stool frequency >8/day or CRP >45 mg/L). If failing IV steroids: Second-line Rescue Biologic / Immunomodulator therapy: Infliximab (Anti-TNF) 5 mg/kg IV (or 10 mg/kg accelerated induction) OR Cyclosporine IV 2 mg/kg/day continuous infusion. Emergent Colectomy if toxic megacolon, bowel perforation, or massive bleeding.",
            guidelines = "ACG Clinical Guideline: Ulcerative Colitis in Adults 2019/2024 Update & ECCO Consensus Guidelines."
        ),
        DiseaseProtocol(
            id = "dp19",
            name = "Helicobacter Pylori Eradication (ACG 2024 / Maastricht VI Guidelines)",
            category = "Gastrointestinal & Infectious",
            firstLine = "First-Line Preferred Regimen: Bismuth Quadruple Therapy for 14 Days:\n1. Bismuth Subsalicylate 300 mg (or Bismuth Subcitrate 120-300 mg) PO QID (with meals & bedtime).\n2. Metronidazole 500 mg PO TID or QID (or 250 mg QID).\n3. Tetracycline 500 mg PO QID (do not substitute with doxycycline unless unavailable).\n4. Standard-to-Double Dose Proton Pump Inhibitor (PPI): e.g., Esomeprazole 40 mg PO BID, Rabeprazole 20 mg PO BID, or Pantoprazole 40 mg PO BID 30-60 min before breakfast and dinner.",
            secondLine = "Alternative First-Line (Only in regions with known Clarithromycin resistance <15%): Clarithromycin Triple Therapy x 14 Days: PPI double-dose BID + Clarithromycin 500 mg PO BID + Amoxicillin 1000 mg PO BID (or Metronidazole 500 mg TID if penicillin allergic).\nNon-Bismuth Concomitant Quadruple Therapy: PPI BID + Amoxicillin 1 g BID + Clarithromycin 500 mg BID + Metronidazole 500 mg BID for 14 days.",
            inpatient = "Refractory / Salvage Regimens (After failed 1st line): Levofloxacin Triple Therapy for 14 days: PPI BID + Amoxicillin 1000 mg BID + Levofloxacin 500 mg PO once daily. Vonoprazan-based therapies: Potassium-competitive acid blocker (P-CAB) Vonoprazan 20 mg BID + Amoxicillin 1000 mg TID x 14 days. Confirmation of Eradication: Mandatory post-treatment Urea Breath Test (13C/14C-UBT) or Stool Antigen Test performed at least 4 weeks after antibiotic completion and at least 2 weeks after stopping PPI therapy.",
            guidelines = "ACG Clinical Guideline: Treatment of Helicobacter pylori Infection 2024 Update & Maastricht VI/Florence Consensus Report."
        ),
        DiseaseProtocol(
            id = "dp20",
            name = "Snake Envenomation (Viper, Cobra, Krait - WHO & National Protocols)",
            category = "Emergency Toxicology & Critical Care",
            firstLine = "Immediate First Aid & Pre-Hospital Protocol: Reassure patient (calm reduces venom dissemination). Immobilize bitten limb with splint/bandage at heart level. Do NOT apply arterial tourniquets, do NOT cut or suction bite wound, do NOT apply chemicals or electric shocks. Remove rings, watches, tight clothing before swelling develops. Rapid transport to health facility equipped with ASV.",
            secondLine = "Clinical Assessment & Envenomation Signs:\n• Hemotoxic (Russell's Viper, Saw-scaled Viper, Green Pit Viper): Local extensive swelling/blistering, spontaneous systemic bleeding (gingival bleeding, hematuria, hemoptysis), coagulopathy identified by 20-Minute Whole Blood Clotting Test (20WBCT: unclotted blood at 20 min = systemic envenomation).\n• Neurotoxic (Common Krait, Indian Cobra, King Cobra): Bilateral ptosis, external ophthalmoplegia, facial weakness, dysphagia, dysarthria, pooling of saliva, descending flaccid paralysis, respiratory arrest.",
            inpatient = "Antivenom Administration (Anti-Snake Venom - ASV Polyvalent):\n• Initial Dose: 10 vials (100 mL) reconstituted in 500 mL Normal Saline infused IV over 1 hour (first 10 min slow at 1-2 mL/min to monitor for anaphylactoid reaction).\n• Bedside Preparedness: Always have Epinephrine (1:1000) 0.5 mL IM, Chlorpheniramine 10 mg IV, and Hydrocortisone 100 mg IV drawn up.\n• Neurotoxic Envenomation Adjunct: Neostigmine test: Neostigmine 0.5-2.0 mg IM/IV with Atropine 0.6 mg IV (prevents muscarinic side effects). If ptosis/muscle power improves, continue Neostigmine 0.5 mg + Atropine q30min-2h.\n• Repeat ASV Dosing: In hemotoxic bites, repeat 20WBCT at 6 hours post-ASV. If blood fails to clot, administer additional 5-10 vials ASV. Support ventilation with early endotracheal intubation and mechanical ventilator if diaphragmatic failure develops.",
            guidelines = "WHO Guidelines for the Management of Snakebites in South-East Asia (2nd Edition) & Nepal National Protocol for Snakebite Management."
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
        ),
        Antidote(
            id = "a11",
            poison = "Cyanide Poisoning (Smoke Inhalation, Industrial, Sodium Nitroprusside)",
            antidote = "Hydroxocobalamin (Cyanokit) OR Sodium Nitrite + Sodium Thiosulfate",
            dosing = "Hydroxocobalamin: 5 g IV infusion over 15 minutes (pediatric 70 mg/kg up to 5g); repeat a second 5g dose if comatose or refractory shock. Alternative: 3% Sodium Nitrite 10 mL IV over 5 min, followed by 25% Sodium Thiosulfate 50 mL IV.",
            notes = "Hydroxocobalamin binds cyanide directly to form non-toxic cyanocobalamin (Vitamin B12) excreted in urine. Causes benign dark red discoloration of skin and urine. Safe in smoke inhalation (does not induce methemoglobinemia).",
            urgency = "IMMEDIATE (Life-Threatening)"
        ),
        Antidote(
            id = "a12",
            poison = "Acute Iron Poisoning (Ferrous Sulfate Ingestion in Children)",
            antidote = "Deferoxamine Mesylate (Desferrioxamine)",
            dosing = "IV Infusion: 15 mg/kg/hour continuous infusion (max 6 g/day or 80 mg/kg/day). Continue until serum iron <350 mcg/dL and urine 'vin rosé' color clears.",
            notes = "Indicated for peak serum iron >500 mcg/dL, systemic toxicity, metabolic acidosis, or lethargy. Chelates ferric iron to form stable, water-soluble ferrioxamine which is excreted in urine giving classic 'vin rosé' (red-orange) urine.",
            urgency = "HIGH (Urgent Chelation)"
        ),
        Antidote(
            id = "a13",
            poison = "Lead, Arsenic, Gold & Inorganic Mercury Poisoning",
            antidote = "Dimercaprol (BAL / British Anti-Lewisite) + Succimer (DMSA)",
            dosing = "Severe Encephalopathy: BAL 4 mg/kg (or 75 mg/m²) deep IM q4h x 2 days, then q6h x 2 days, then q12h x 7 days co-administered with CaNa2-EDTA. Oral Chelation: Succimer (DMSA) 10 mg/kg (350 mg/m²) PO TID x 5 days, then BID x 14 days.",
            notes = "Formulates stable chelate rings with heavy metals. In lead encephalopathy, always administer first dose of BAL at least 4 hours before CaNa2-EDTA to avoid redistributing lead into brain tissue.",
            urgency = "HIGH"
        ),
        Antidote(
            id = "a14",
            poison = "Isoniazid (INH) Poisoning & Gyromitra Mushroom Toxicity",
            antidote = "Pyridoxine (Vitamin B6 IV)",
            dosing = "Gram-for-gram dose equal to ingested INH dose (if amount known) given as 5-10% solution in D5W over 5-10 minutes. If unknown: Empiric 5 g IV over 10 minutes (pediatric 70 mg/kg up to 5g); repeat q5-15min if seizures persist.",
            notes = "Specific antidote for INH-induced refractory status epilepticus and severe lactic acidosis. INH inhibits pyridoxine phosphokinase, depleting GABA in brain; IV Pyridoxine directly restores GABA synthesis and terminates intractable seizures.",
            urgency = "CRITICAL (Status Epilepticus)"
        ),
        Antidote(
            id = "a15",
            poison = "Local Anesthetic Systemic Toxicity - LAST (Bupivacaine, Lidocaine)",
            antidote = "20% Lipid Emulsion (Intralipid 20%)",
            dosing = "Initial IV Bolus: 1.5 mL/kg 20% Lipid Emulsion over 1-2 minutes. Immediately start continuous infusion of 0.25 mL/kg/min. Repeat bolus once or twice for persistent cardiovascular collapse; can increase infusion to 0.5 mL/kg/min (Max total 12 mL/kg over 30 min).",
            notes = "Lipid Sink Mechanism: Creates an expanded intravascular lipid phase that sequesters lipophilic local anesthetics from myocardial and brain tissue, restoring mitochondrial fatty acid metabolism and cardiac electrical conduction.",
            urgency = "IMMEDIATE (Cardiac Arrest)"
        ),
        Antidote(
            id = "a16",
            poison = "Sulfonylurea Poisoning (Glimepiride, Glibenclamide, Glipizide Overdose)",
            antidote = "Octreotide (Somatostatin Analogue) + Dextrose",
            dosing = "Adult: 50 to 100 mcg SC or slow IV injection q6-12h for 24-48 hours. Pediatric: 1 to 1.5 mcg/kg (max 50 mcg) SC/IV q8-12h.",
            notes = "Specific antidote for refractory sulfonylurea-induced hypoglycemia. Dextrose alone stimulates rebound endogenous insulin release; Octreotide directly suppresses pancreatic beta-cell insulin secretion, breaking the cycle of recurrent hypoglycemia.",
            urgency = "HIGH"
        ),
        Antidote(
            id = "a17",
            poison = "Tricyclic Antidepressant Overdose (Amitriptyline Cardiotoxicity)",
            antidote = "Sodium Bicarbonate 8.4% IV",
            dosing = "1 to 2 mEq/kg (1-2 mL/kg of 8.4% NaHCO3) IV push over 2-3 minutes. Repeat until QRS duration narrows to <100 msec and systolic BP normalizes. Maintain infusion (150 mEq NaHCO3 in 1 L D5W at 150-250 mL/hr) targeting arterial pH 7.50-7.55.",
            notes = "Indicated for QRS prolongation >100 msec, right-axis deviation (terminal R wave in aVR >3 mm), ventricular dysrhythmias, or hypotension. Provides sodium load to overcome fast sodium channel blockade and alkalinizes serum to unbind TCA from receptors.",
            urgency = "IMMEDIATE (Cardiotoxic)"
        ),
        Antidote(
            id = "a18",
            poison = "Anticholinergic Toxidrome / Datura Poisoning (Atropa belladonna)",
            antidote = "Physostigmine Salicylate",
            dosing = "Adult: 0.5 to 2.0 mg slow IV push over 5 minutes (pediatric 0.02 mg/kg, max 0.5 mg). May repeat every 10-15 minutes if severe delirium or agitation persists, up to max 4 mg.",
            notes = "Tertiary amine that crosses the blood-brain barrier to reverse central and peripheral anticholinergic delirium ('blind as a bat, mad as a hatter, red as a beet, hot as a hare, dry as a bone'). Contraindicated if TCA co-ingestion or wide QRS!",
            urgency = "HIGH (Central Delirium)"
        )
    )

    private val baseInteractions: List<com.example.data.model.DrugInteraction> = listOf(
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

    val interactions: List<com.example.data.model.DrugInteraction> = baseInteractions + AdditionalDrugsData.additionalInteractions

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
