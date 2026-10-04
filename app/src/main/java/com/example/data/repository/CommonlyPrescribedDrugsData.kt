package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object CommonlyPrescribedDrugsData {

    val commonDrugs: List<Drug> = listOf(
        // =========================================================================
        // 1. GASTROENTEROLOGY & ACID-PEPTIC DISEASE
        // =========================================================================
        Drug(
            id = "d_com_rabeprazole",
            genericName = "Rabeprazole Sodium",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Proton Pump Inhibitor (PPI)",
            blackBoxWarning = null,
            indications = "Gastroesophageal Reflux Disease (GERD), erosive esophagitis, active duodenal ulcer, benign gastric ulcer, Zollinger-Ellison syndrome, H. pylori eradication quadruple therapy.",
            doses = "Duodenal Ulcer / GERD: 20 mg PO once daily in morning before breakfast for 4-8 weeks.\nZollinger-Ellison: 60 mg PO once daily up to 120 mg/day divided BID.",
            administration = "Swallow tablet whole with a glass of water. Do not chew, crush, or split enteric-coated tablets.",
            timing = "30-60 minutes before morning breakfast.",
            specialInstructions = "Long-term PPI use (>1 yr) associated with hypomagnesemia, subacute cutaneous lupus, microscopic colitis, and C. difficile-associated diarrhea.",
            pkPd = "Rapid gastric acid inhibition with higher pKa (~5.0) allowing faster activation than omeprazole. Non-enzymatic thioether conversion with minor CYP2C19/CYP3A4 metabolism.",
            renalAdj = "No dosage adjustment necessary in renal impairment or hemodialysis.",
            hepaticAdj = "No adjustment in mild-to-moderate cirrhosis; use caution and monitor in severe hepatic impairment.",
            pregnancy = "Category B (Animal studies reveal no fetal harm; use if clinically indicated).",
            lactation = "Excretion into breast milk unknown; use with clinical surveillance.",
            sideEffects = "Headache, diarrhea, nausea, abdominal pain, flatulence, dry mouth, arthralgia, rare peripheral edema.",
            priceNpr = "NPR 120.00 - 240.00 per strip of 10 tablets (20 mg)",
            priceInr = "INR 80.00 - 160.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Razo-20", "Dr. Reddy's / Nepal Dist.", "Tab", "20 mg"),
                BrandInfo("Rablet-20", "Lupin / Medisales Nepal", "Tab", "20 mg"),
                BrandInfo("Rabicip-20", "Cipla Nepal", "Tab", "20 mg"),
                BrandInfo("Happi-20", "Zydus Healthcare", "Tab", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Razo", "Dr. Reddy's", "Tab", "20 mg"),
                BrandInfo("Rablet", "Lupin", "Tab", "20 mg"),
                BrandInfo("Rabicip", "Cipla", "Tab", "20 mg")
            ),
            adultDose = "20 mg PO once daily 30 min before breakfast.",
            childDose = "Adolescents >= 12 yr: 20 mg PO once daily for up to 8 weeks.",
            contraindications = "Known hypersensitivity to rabeprazole or substituted benzimidazoles; concurrent administration with rilpivirine.",
            modeOfAction = "Irreversible inhibition of H+/K+-ATPase enzyme pump system at the secretory surface of the gastric parietal cell, blocking the final step of acid secretion.",
            therapeuticClassTag = "Anti-ulcerants / PPIs"
        ),

        Drug(
            id = "d_com_esomeprazole",
            genericName = "Esomeprazole Magnesium",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Proton Pump Inhibitor (S-isomer of Omeprazole)",
            blackBoxWarning = null,
            indications = "Erosive esophagitis, symptomatic GERD, maintenance of healed esophagitis, NSAID-induced gastric ulcer prophylaxis, H. pylori eradication quadruple regimen.",
            doses = "GERD / Esophagitis: 40 mg PO once daily for 4-8 weeks.\nMaintenance: 20 mg PO once daily.\nH. pylori: 40 mg PO BID with antibiotics x 14 days.",
            administration = "Take on empty stomach. Pellets inside capsules can be opened and mixed into applesauce or administered via nasogastric tube.",
            timing = "30-60 minutes before morning meal.",
            specialInstructions = "Less CYP2C19 dependent metabolism than racemic omeprazole; provides more prolonged intragastric acid suppression (pH > 4 for ~15h/day).",
            pkPd = "Bioavailability increases with repeated doses to ~89%. Extensively metabolized by CYP2C19 and CYP3A4 to inactive hydroxy and carboxy metabolites.",
            renalAdj = "No dosage adjustment needed in renal failure.",
            hepaticAdj = "Mild to moderate: No adjustment needed. Severe hepatic impairment (Child-Pugh C): Maximum 20 mg daily.",
            pregnancy = "Category C (Extensive clinical registry data demonstrates reassuring safety in human pregnancy).",
            lactation = "Present in human milk in low amounts; consider alternative or monitor infant.",
            sideEffects = "Headache, diarrhea, abdominal distension, nausea, hypomagnesemia with prolonged use, increased fracture risk with multi-year high-dose therapy.",
            priceNpr = "NPR 150.00 - 320.00 per strip of 10 tablets (40 mg)",
            priceInr = "INR 95.00 - 210.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Nexpro-40", "Torrent Pharmaceuticals Nepal", "Tab", "40 mg"),
                BrandInfo("Sompraz-40", "Sun Pharma Nepal", "Tab", "40 mg"),
                BrandInfo("Esomac-40", "Cipla Nepal", "Tab", "40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Nexpro", "Torrent", "Tab", "40 mg"),
                BrandInfo("Sompraz", "Sun Pharma", "Tab", "40 mg"),
                BrandInfo("Esomac", "Cipla", "Tab", "40 mg")
            ),
            adultDose = "20 to 40 mg PO once daily.",
            childDose = "Children >= 12 yr (weight >= 30 kg): 20 to 40 mg once daily.",
            contraindications = "Hypersensitivity to omeprazole or esomeprazole; concurrent rilpivirine, atazanavir, or nelfinavir therapy.",
            modeOfAction = "Concentrates in acidic secretory canaliculi of gastric parietal cells, converting to active sulfenamide that covenants with H+/K+-ATPase enzyme.",
            therapeuticClassTag = "Anti-ulcerants / PPIs"
        ),

        Drug(
            id = "d_com_domperidone",
            genericName = "Domperidone",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Peripheral Dopamine D2 Receptor Antagonist / Prokinetic",
            blackBoxWarning = "Risk of cardiac arrhythmias and sudden cardiac death due to QTc prolongation, especially in patients >60 years or daily doses >30 mg.",
            indications = "Symptomatic relief of acute nausea and vomiting, diabetic gastroparesis, post-prandial fullness and bloating in functional dyspepsia, GERD adjunct.",
            doses = "Adults: 10 mg PO up to TID before meals (Maximum dose: 30 mg/day). Use lowest effective dose for shortest duration (typically <= 7 days).",
            administration = "Take strictly before meals. Ingestion after food delays gastrointestinal absorption.",
            timing = "15-30 minutes before meals and at bedtime if needed.",
            specialInstructions = "Check baseline ECG and electrolytes (K+, Mg2+) if patient is elderly or taking concurrent QT-prolonging or CYP3A4-inhibiting drugs.",
            pkPd = "Poor blood-brain barrier penetration minimizes extrapyramidal motor side effects compared to metoclopramide. Rapidly metabolized by hepatic CYP3A4.",
            renalAdj = "Moderate-to-severe renal impairment: Reduce dosing frequency to once or twice daily depending on clinical response.",
            hepaticAdj = "Moderate to severe hepatic impairment (Child-Pugh B or C): CONTRAINDICATED.",
            pregnancy = "Category C (Limited human data; use only if benefit outweighs risk).",
            lactation = "Excreted in breast milk in small amounts; sometimes used off-label as galactagogue with maternal ECG surveillance.",
            sideEffects = "Dry mouth, headache, hyperprolactinemia (galactorrhea, amenorrhea, gynecomastia), mild abdominal cramps, QT interval prolongation.",
            priceNpr = "NPR 45.00 - 90.00 per strip of 10 tablets (10 mg)",
            priceInr = "INR 30.00 - 65.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Domstal-10", "Torrent Pharmaceuticals", "Tab", "10 mg"),
                BrandInfo("Vomistop-10", "Cipla Nepal", "Tab", "10 mg"),
                BrandInfo("Motinorm-10", "Medley Pharmaceuticals", "Tab", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Domstal", "Torrent", "Tab", "10 mg"),
                BrandInfo("Vomistop", "Cipla", "Tab", "10 mg")
            ),
            pediatricDosePerKg = 0.25,
            pediatricInterval = "mg/kg PO TID (max 0.75 mg/kg/day, only in specialized pediatric nausea)",
            adultDose = "10 mg PO TID (max 30 mg/day).",
            childDose = "Not routinely recommended in children < 12 yr or < 35 kg without specialist advice.",
            contraindications = "Severe hepatic impairment, baseline QTc prolongation (>450 ms males, >470 ms females), concurrent CYP3A4 inhibitors (ketoconazole, erythromycin), gastrointestinal hemorrhage, mechanical obstruction, prolactin-releasing pituitary tumor.",
            modeOfAction = "Antagonizes peripheral dopamine D2 receptors in the upper GI tract, enhancing antral contractions, duodenal coordination, and lower esophageal sphincter tone, while blocking D2 receptors in the chemoreceptor trigger zone (CTZ).",
            therapeuticClassTag = "Antiemetics & Prokinetics"
        ),

        Drug(
            id = "d_com_sucralfate",
            genericName = "Sucralfate",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Basic Aluminum Hydroxide Salt of Sucrose Octasulfate / Mucosal Protectant",
            blackBoxWarning = null,
            indications = "Short-term treatment of active duodenal and gastric ulcers, maintenance of healed duodenal ulcer, prevention of NSAID-induced ulcers, radiation proctitis/stomatitis suspension.",
            doses = "Active Ulcer: 1 g (1000 mg) PO 4 times daily on an empty stomach (1 hour before each meal and at bedtime) for 4-8 weeks.\nMaintenance: 1 g PO twice daily.",
            administration = "Take on an empty stomach with a full glass of water. Separate from antacids by at least 30 minutes, and separate from fluoroquinolones, phenytoin, digoxin, or warfarin by at least 2 hours.",
            timing = "1 hour before meals and at bedtime.",
            specialInstructions = "Acts locally and binds to ulcerated mucosal proteins. Aluminum absorption occurs in tiny amounts; monitor in severe chronic kidney disease to prevent aluminum osteomalacia/encephalopathy.",
            pkPd = "Minimal systemic absorption (<3-5%). Binds to positively charged proteins in the exudate of ulcer craters forming a viscous, insoluble protective paste that resists pepsin, acid, and bile salts.",
            renalAdj = "Use with caution in CKD stage 4-5 and hemodialysis due to potential systemic aluminum accumulation.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Negligible systemic absorption; considered safe in pregnancy).",
            lactation = "Safe; virtually unabsorbed into maternal circulation.",
            sideEffects = "Constipation (most common in ~2-4%), bezoar formation in patients with impaired gastric emptying, flatulence, dry mouth.",
            priceNpr = "NPR 180.00 - 320.00 per 200 mL suspension (1 g/5 mL)",
            priceInr = "INR 120.00 - 220.00 per 200 mL bottle",
            brandsNepal = listOf(
                BrandInfo("Sucrafil Suspension", "Fourrts Laboratories Nepal", "Susp", "1000 mg/5 mL"),
                BrandInfo("Pepsigard Liquid", "Sun Pharma Nepal", "Susp", "1000 mg/5 mL"),
                BrandInfo("Sucrace-O", "Mankind Pharma", "Susp", "1000 mg + Oxetacaine")
            ),
            brandsIndia = listOf(
                BrandInfo("Sucrafil", "Fourrts", "Susp", "1g/5mL"),
                BrandInfo("Pepsigard", "Sun Pharma", "Susp", "1g/5mL")
            ),
            adultDose = "1 g PO QID 1 hour before meals and bedtime.",
            childDose = "Children: 40-80 mg/kg/day PO divided every 6 hours (specialist use).",
            contraindications = "Known hypersensitivity to sucralfate or aluminum salts; severe gastrointestinal obstruction or ileus.",
            modeOfAction = "Polymerizes into a viscous paste in acidic stomach environment (pH < 4), forming an adherent protective barrier over ulcer base, stimulating local mucosal prostaglandin and epidermal growth factor synthesis.",
            therapeuticClassTag = "Mucosal Protectants"
        ),

        Drug(
            id = "d_com_drotaverine",
            genericName = "Drotaverine Hydrochloride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Phosphodiesterase-4 (PDE-4) Inhibitor / Smooth Muscle Antispasmodic",
            blackBoxWarning = null,
            indications = "Spastic smooth muscle cramps of gastrointestinal origin (biliary colic, cholecystitis, spastic colitis, irritable bowel syndrome), renal and ureteric colic, primary dysmenorrhea, post-operative abdominal cramps.",
            doses = "Adults: 40 to 80 mg PO TID (Maximum: 240 mg/day).\nAcute severe colic: 40 to 80 mg slow IM or subcutaneous.",
            administration = "Take tablets with water. May be taken with or without food. Avoid rapid IV injection to prevent hypotension or atrioventricular block.",
            timing = "Taken with meals or at onset of spastic abdominal pain.",
            specialInstructions = "Devoid of anticholinergic side effects; safe in patients with glaucoma or benign prostatic hyperplasia (BPH) where dicyclomine is contraindicated.",
            pkPd = "Selectively inhibits phosphodiesterase-4 (PDE4) without inhibiting PDE3 or PDE5. Rapid absorption with onset in 15-30 minutes. Hepatically metabolized.",
            renalAdj = "No specific dosage adjustment; monitor in severe renal disease.",
            hepaticAdj = "Contraindicated in severe hepatic insufficiency.",
            pregnancy = "Category B (Widely prescribed clinically in Europe and Asia for uterine spasm and dysmenorrhea; no teratogenicity demonstrated).",
            lactation = "Excretion in breast milk unknown; use with caution.",
            sideEffects = "Mild nausea, headache, dizziness, vertigo, transient hypotension, rare allergic dermatitis.",
            priceNpr = "NPR 90.00 - 160.00 per strip of 10 tablets (80 mg)",
            priceInr = "INR 60.00 - 110.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Drotin-DS", "Walter Bushnell / Medisales", "Tab", "80 mg"),
                BrandInfo("Drotin-40", "Walter Bushnell", "Tab", "40 mg"),
                BrandInfo("Drotikem-80", "Alkem Laboratories", "Tab", "80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Drotin", "Walter Bushnell", "Tab", "40 mg / 80 mg"),
                BrandInfo("Dotra", "Mankind", "Tab", "80 mg")
            ),
            adultDose = "40 to 80 mg PO TID.",
            childDose = "Children 1-6 yr: 20 mg PO BD-TID; >6 yr: 40 mg PO BD-TID.",
            contraindications = "Severe hepatic, renal, or cardiac failure (low ejection fraction, AV block); known hypersensitivity to isoquinoline derivatives.",
            modeOfAction = "Selectively inhibits PDE4 enzyme in smooth muscle cells, elevating intracellular cAMP, reducing intracellular calcium influx, and producing prompt smooth muscle relaxation without anticholinergic atropinic effects.",
            therapeuticClassTag = "Antispasmodics & GI Smooth Muscle Relaxants"
        ),

        Drug(
            id = "d_com_loperamide",
            genericName = "Loperamide Hydrochloride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Peripheral Opioid Mu-Receptor Agonist / Antidiarrheal",
            blackBoxWarning = "Torsades de pointes, cardiac arrest, and death reported with higher than recommended doses (misuse for opioid withdrawal). Do not exceed 16 mg/day in adults.",
            indications = "Control and symptomatic relief of acute non-specific diarrhea, traveler's diarrhea (mild-to-moderate without fever or bloody stools), chronic diarrhea associated with inflammatory bowel disease, reduction of ileostomy effluent volume.",
            doses = "Acute Diarrhea: Initial 4 mg PO stat, followed by 2 mg after each unformed stool. Maximum recommended dose: 16 mg/day (prescription) or 8 mg/day (OTC).\nChronic diarrhea: Titrate to 4-8 mg/day in divided doses.",
            administration = "Take with fluids. Discontinue if no clinical improvement after 48 hours in acute diarrhea.",
            timing = "After unformed loose stool.",
            specialInstructions = "NEVER use in bacterial enteritis with high fever, dysentery (bloody stools), or acute ulcerative colitis due to high risk of toxic megacolon.",
            pkPd = "High affinity for peripheral enteric mu-opioid receptors in the myenteric plexus. High first-pass metabolism with P-glycoprotein efflux preventing central CNS opioid penetration.",
            renalAdj = "No dose reduction necessary.",
            hepaticAdj = "Use caution in hepatic impairment due to reduced first-pass clearance.",
            pregnancy = "Category C (First-line approach in pregnancy remains aggressive oral rehydration; use only if strictly necessary).",
            lactation = "Small amounts excreted in breast milk; safe for short durations.",
            sideEffects = "Constipation, abdominal cramps, dizziness, nausea, drowsiness, dry mouth, toxic megacolon if used in inflammatory colitis.",
            priceNpr = "NPR 25.00 - 50.00 per strip of 10 capsules (2 mg)",
            priceInr = "INR 15.00 - 35.00 per strip of 10 capsules",
            brandsNepal = listOf(
                BrandInfo("Imodium-2", "Johnson & Johnson / Nepal", "Cap", "2 mg"),
                BrandInfo("Lopamide-2", "Torrent Pharmaceuticals", "Cap", "2 mg"),
                BrandInfo("Eldoper-2", "Micro Labs", "Cap", "2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Imodium", "Janssen", "Cap", "2 mg"),
                BrandInfo("Lopamide", "Torrent", "Cap", "2 mg")
            ),
            adultDose = "4 mg PO initial, then 2 mg after each loose stool (max 16 mg/day).",
            childDose = "Not recommended in children < 2 years. Children 2-5 yr: 1 mg PO TID; 6-8 yr: 2 mg BD; 8-12 yr: 2 mg TID under close medical supervision.",
            contraindications = "Acute dysentery (bloody stools + high fever), acute ulcerative colitis flare, bacterial enterocolitis caused by invasive organisms (Salmonella, Shigella, Campylobacter) or Clostridioides difficile pseudomembranous colitis.",
            modeOfAction = "Binds to mu-opioid receptors in intestinal smooth muscle, decreasing circular and longitudinal muscle peristalsis, increasing intestinal transit time, and enhancing anal sphincter tone.",
            therapeuticClassTag = "Antidiarrheals"
        ),

        Drug(
            id = "d_com_ors_who",
            genericName = "Oral Rehydration Salts (WHO Low-Osmolarity Formula)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Fluid & Electrolyte Replacement / Glucose-Electrolyte Solution",
            blackBoxWarning = null,
            indications = "Prevention and treatment of mild-to-moderate dehydration due to acute diarrhea, gastroenteritis, cholera, viral rotavirus, heat exhaustion, and pediatric fluid loss.",
            doses = "WHO Formula (245 mOsm/L: Sodium 75, Chloride 65, Glucose 75, Potassium 20, Citrate 10 mmol/L).\nMild/Moderate Dehydration: 75 mL/kg PO over 4 hours, then maintenance 10-20 mL/kg after each watery stool.\nAdults: 200-400 mL after each loose motion or 2-4 Liters in 24 hours.",
            administration = "Dissolve entire contents of 1 sachet in exactly 1 Liter (1,000 mL) of clean drinking or boiled and cooled water. Mix thoroughly. Discard unused reconstituted solution after 24 hours.",
            timing = "Sip continuously throughout the day and after each watery stool.",
            specialInstructions = "Do NOT boil the solution after reconstitution. Do NOT mix with milk, fruit juices, or soft drinks. Never dilute with too little or too much water.",
            pkPd = "Glucose stimulates active sodium and water transport across the intestinal brush border membrane via the sodium-glucose cotransporter (SGLT1), which remains intact during cholera and rotavirus toxin-mediated secretory states.",
            renalAdj = "Monitor serum potassium in severe acute kidney injury or anuria.",
            hepaticAdj = "Safe in hepatic disease.",
            pregnancy = "Category A (Gold standard safe rehydration in maternal diarrhea).",
            lactation = "Completely safe in nursing mothers.",
            sideEffects = "Vomiting if administered too quickly (give frequent small sips via spoon), mild hypernatremia if improperly reconstituted with inadequate water.",
            priceNpr = "NPR 12.00 - 25.00 per sachet for 1 Liter (20.5 g powder)",
            priceInr = "INR 8.00 - 18.00 per sachet for 1 Liter",
            brandsNepal = listOf(
                BrandInfo("Jeevan Jal", "Nepal Pharmaceutical Lab / MOHP Nepal", "Sachet", "20.5 g for 1L"),
                BrandInfo("Electral Sachet", "FDC Limited / Nepal", "Sachet", "21.8 g for 1L"),
                BrandInfo("Walyte Low Osmol", "Cipla Nepal", "Sachet", "20.5 g for 1L")
            ),
            brandsIndia = listOf(
                BrandInfo("Electral", "FDC", "Sachet", "21.8 g for 1L"),
                BrandInfo("Walyte", "Cipla", "Sachet", "20.5 g for 1L")
            ),
            adultDose = "200-400 mL PO after each loose motion or 2-4 L daily.",
            childDose = "<2 yr: 50-100 mL after each stool; 2-10 yr: 100-200 mL after each stool; >10 yr: As much as desired.",
            contraindications = "Severe hypovolemic shock (requires immediate IV Ringer Lactate resuscitation), paralytic ileus, intractable persistent vomiting preventing oral intake, bowel perforation.",
            modeOfAction = "Exploits active SGLT1 coupled sodium-glucose cotransport mechanism in intestinal enterocytes, driving osmotic reabsorption of water, chloride, and potassium.",
            therapeuticClassTag = "Fluid & Electrolyte Regimens"
        ),

        // =========================================================================
        // 2. ANALGESICS, NSAIDS & MUSCULOSKELETAL
        // =========================================================================
        Drug(
            id = "d_com_aceclofenac",
            genericName = "Aceclofenac",
            system = "Musculoskeletal & Joint Disorders",
            drugClass = "Phenylacetic Acid Derivative NSAID (Selective COX-2 preferential)",
            blackBoxWarning = "Increased risk of cardiovascular thrombotic events, myocardial infarction, stroke, and gastrointestinal ulceration, bleeding, and perforation.",
            indications = "Relief of pain and inflammation in osteoarthritis, rheumatoid arthritis, ankylosing spondylitis, acute musculoskeletal backache, post-dental extraction pain, episiotomy pain.",
            doses = "Adults: 100 mg PO twice daily (morning and evening with food). Maximum dose: 200 mg/day.",
            administration = "Take tablets with or immediately after food with water to minimize dyspepsia.",
            timing = "Morning and evening with meals.",
            specialInstructions = "Preferentially inhibits COX-2 with lower gastric ulcerogenic potential than diclofenac or indomethacin; stimulates chondrocyte glycosaminoglycan synthesis in articular cartilage.",
            pkPd = "Rapid and complete absorption. 99% plasma protein bound. Metabolized to 4'-hydroxyaceclofenac and diclofenac. Elimination half-life ~4 hours.",
            renalAdj = "Mild-to-moderate CKD: Use lowest effective dose; severe renal impairment (eGFR < 30 mL/min): Avoid.",
            hepaticAdj = "Reduce initial dose to 100 mg once daily in mild-to-moderate hepatic impairment.",
            pregnancy = "Category D in 3rd trimester (premature closure of fetal ductus arteriosus, oligohydramnios); avoid throughout late pregnancy.",
            lactation = "Avoid; excretion in human breast milk possible.",
            sideEffects = "Dyspepsia, epigastric discomfort, nausea, elevated liver enzymes (ALT/AST), diarrhea, mild peripheral edema, dizziness.",
            priceNpr = "NPR 70.00 - 140.00 per strip of 10 tablets (100 mg)",
            priceInr = "INR 45.00 - 95.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Zerodol-100", "Ipca Laboratories Nepal", "Tab", "100 mg"),
                BrandInfo("Hifenac-100", "Intas Pharmaceuticals", "Tab", "100 mg"),
                BrandInfo("Aceclo-100", "Aristo Pharmaceuticals", "Tab", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Zerodol", "Ipca", "Tab", "100 mg"),
                BrandInfo("Hifenac", "Intas", "Tab", "100 mg"),
                BrandInfo("Aceclo", "Aristo", "Tab", "100 mg")
            ),
            adultDose = "100 mg PO BD with food.",
            childDose = "Not recommended in children < 18 years.",
            contraindications = "Active peptic ulcer, GI hemorrhage, severe heart failure (NYHA Class II-IV), ischemic heart disease, peripheral arterial disease, cerebrovascular disease, aspirin-induced triad asthma.",
            modeOfAction = "Inhibits cyclooxygenase (preferentially COX-2) blocking arachidonic acid conversion to inflammatory prostaglandin E2 (PGE2), suppressing cytokine interleukin-1beta and TNF-alpha mediated cartilage degradation.",
            therapeuticClassTag = "NSAIDs & Analgesics"
        ),

        Drug(
            id = "d_com_aceclo_pcm",
            genericName = "Aceclofenac + Paracetamol (Acetaminophen)",
            system = "Musculoskeletal & Joint Disorders",
            drugClass = "Fixed-Dose Combination Analgesic (NSAID + Aniline Analgesic)",
            blackBoxWarning = "Exceeding daily dose of paracetamol (>4g/day) may cause severe liver damage. Cardiovascular and GI ulceration risks of NSAIDs apply.",
            indications = "Acute painful musculoskeletal conditions, acute lumbago, cervical spondylosis, osteoarthritis flares, post-traumatic soft-tissue contusions, dental pain, orthopedic post-op pain.",
            doses = "Adults: 1 tablet (Aceclofenac 100 mg + Paracetamol 325 mg or 500 mg) PO twice daily after meals (Max: 2 tablets/day).",
            administration = "Take whole tablet with water immediately after breakfast and dinner.",
            timing = "Twice daily after meals.",
            specialInstructions = "Do not co-prescribe with other paracetamol-containing cough/cold or pain medications to prevent accidental hepatotoxic paracetamol overdosing.",
            pkPd = "Dual action: Aceclofenac inhibits peripheral inflammatory prostaglandins (PGE2) at injury site; Paracetamol acts primarily on central COX/serotoninergic pain pathways.",
            renalAdj = "Avoid in eGFR < 30 mL/min.",
            hepaticAdj = "Avoid in active liver disease or chronic alcohol abuse due to paracetamol NAPQI accumulation.",
            pregnancy = "Category D in 3rd trimester (Avoid in 3rd trimester).",
            lactation = "Use with clinical caution; short-term use acceptable if clinically indicated.",
            sideEffects = "Epigastric burning, nausea, abdominal discomfort, dizziness, elevated transaminases, skin rash.",
            priceNpr = "NPR 90.00 - 180.00 per strip of 10 tablets",
            priceInr = "INR 60.00 - 120.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Zerodol-P", "Ipca Laboratories Nepal", "Tab", "100 mg + 325 mg"),
                BrandInfo("Hifenac-P", "Intas Pharmaceuticals", "Tab", "100 mg + 325 mg"),
                BrandInfo("Dolokind-P", "Mankind Pharma", "Tab", "100 mg + 325 mg"),
                BrandInfo("Aceclo-Plus", "Aristo Pharmaceuticals", "Tab", "100 mg + 325 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Zerodol-P", "Ipca", "Tab", "100mg + 325mg"),
                BrandInfo("Hifenac-P", "Intas", "Tab", "100mg + 325mg")
            ),
            adultDose = "1 tablet PO BD after meals.",
            childDose = "Not recommended in children < 18 years.",
            contraindications = "Active peptic ulcer, severe hepatic failure, history of GI bleed, aspirin hypersensitivity, severe congestive heart failure.",
            modeOfAction = "Synergistic dual peripheral and central analgesia: Aceclofenac inhibits peripheral COX enzymes suppressing inflammatory exudate and pain, while paracetamol acts on central pain modulation and hypothalamic thermoregulation.",
            therapeuticClassTag = "NSAIDs & Analgesics"
        ),

        Drug(
            id = "d_com_mefenamic_acid",
            genericName = "Mefenamic Acid",
            system = "Obstetrics & Gynecology / Analgesia",
            drugClass = "Fenamate NSAID / Prostaglandin Synthesis & Receptor Inhibitor",
            blackBoxWarning = "Increased risk of cardiovascular thrombotic events and gastrointestinal bleeding/ulceration.",
            indications = "Primary dysmenorrhea, menorrhagia (excessive menstrual blood loss caused by ovulatory dysfunctional bleeding or IUD), mild-to-moderate postoperative pain, headache, dental pain.",
            doses = "Primary Dysmenorrhea & Pain: 500 mg PO initially at pain onset, then 250 mg every 6 hours with food (max: 1000-1500 mg/day for <= 2-3 days).\nMenorrhagia: 500 mg PO TID starting on day 1 of menses and continued for 3-5 days.",
            administration = "Take strictly with meals or milk to reduce gastric irritation.",
            timing = "Take with food at onset of menstrual cramps or heavy bleeding.",
            specialInstructions = "Unique among NSAIDs because it not only inhibits prostaglandin synthesis (COX-1/2) but also directly blocks prostaglandin receptor binding on myometrial smooth muscle.",
            pkPd = "Rapidly absorbed. Metabolized by CYP2C9 to 3-hydroxymethyl and 3-carboxymefenamic acid metabolites. Excreted in urine (~52%) and feces (~20%).",
            renalAdj = "Contraindicated in severe renal impairment (eGFR < 30 mL/min).",
            hepaticAdj = "Use lowest dose; contraindicated in severe hepatic disease.",
            pregnancy = "Category D in 3rd trimester (Avoid in late pregnancy).",
            lactation = "Trace amounts excreted into breast milk; short-term use for dysmenorrhea generally compatible.",
            sideEffects = "Diarrhea (unique dose-limiting fenamate side effect; discontinue if severe), dyspepsia, epigastric pain, dizziness, rare autoimmune hemolytic anemia with prolonged use.",
            priceNpr = "NPR 60.00 - 120.00 per strip of 10 tablets (500 mg)",
            priceInr = "INR 35.00 - 75.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Meftal-500", "Blue Cross Laboratories", "Tab", "500 mg"),
                BrandInfo("Ponstan-500", "Pfizer Nepal", "Tab", "500 mg"),
                BrandInfo("Mefac-500", "Deurali-Janta Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Meftal", "Blue Cross", "Tab", "500 mg"),
                BrandInfo("Ponstan", "Pfizer", "Tab", "500 mg")
            ),
            pediatricDosePerKg = 6.5,
            pediatricInterval = "mg/kg PO TID (Meftal suspension for pediatric fever/pain)",
            adultDose = "500 mg PO initial, then 250 mg q6h or 500 mg TID with food (max 3-5 days).",
            childDose = "Children >= 6 months: 6.5 mg/kg PO TID (max 7 days for fever/pain).",
            contraindications = "Active gastrointestinal ulceration/inflammation, inflammatory bowel disease, severe renal or hepatic failure, coronary artery bypass graft (CABG) surgery.",
            modeOfAction = "Inhibits COX-1 and COX-2 enzymes and competitively antagonizes prostaglandin receptors in uterine myometrium, decreasing uterine hypercontractility and menstrual blood volume.",
            therapeuticClassTag = "NSAIDs & Analgesics"
        ),

        Drug(
            id = "d_com_txa_mef",
            genericName = "Tranexamic Acid + Mefenamic Acid",
            system = "Obstetrics & Gynecology / Hemostasis",
            drugClass = "Antifibrinolytic + Fenamate NSAID Combination",
            blackBoxWarning = "Increased risk of venous thromboembolism (DVT, PE) and arterial thrombosis. Do not use in patients with active thromboembolic disease.",
            indications = "Acute management of heavy menstrual bleeding (menorrhagia), dysfunctional uterine bleeding (DUB), postpartum bleeding adjunct, menorrhagia associated with intrauterine contraceptive devices (IUCD).",
            doses = "Adults: 1 tablet (Tranexamic Acid 500 mg + Mefenamic Acid 250 mg) PO twice or three times daily during heavy menstrual bleeding days (typically days 1 to 4 of menses). Max 3 tablets daily.",
            administration = "Swallow tablet whole with food and water. Do not crush or chew.",
            timing = "Start immediately on day 1 of heavy menstrual flow; continue for 3-5 days.",
            specialInstructions = "Check personal and family history of DVT, pulmonary embolism, stroke, or thrombophilia prior to prescribing. Do not use concurrently with combined oral contraceptive pills (COCs).",
            pkPd = "Tranexamic acid competitively blocks plasminogen lysine binding sites preventing fibrin clot breakdown; Mefenamic acid suppresses uterine prostaglandin F2alpha synthesis reducing cramps and vasodilation.",
            renalAdj = "Tranexamic acid excreted 95% unchanged in urine; reduce dose in renal impairment according to serum creatinine.",
            hepaticAdj = "Use caution; mefenamic acid undergoes hepatic metabolism.",
            pregnancy = "Category B/D (Indicated only in non-pregnant menstruating females).",
            lactation = "Tranexamic acid present in breast milk (~1%); use only if clearly needed.",
            sideEffects = "Nausea, vomiting, diarrhea, abdominal cramps, headache, dizziness, rare visual color disturbances (discontinue if visual changes occur).",
            priceNpr = "NPR 250.00 - 450.00 per strip of 10 tablets",
            priceInr = "INR 180.00 - 320.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Trapic-MF", "Sun Pharma Nepal", "Tab", "500 mg + 250 mg"),
                BrandInfo("Pause-MF", "Emcure Pharmaceuticals", "Tab", "500 mg + 250 mg"),
                BrandInfo("Clip-MF", "FDC Limited", "Tab", "500 mg + 250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Trapic-MF", "Sun Pharma", "Tab", "500mg + 250mg"),
                BrandInfo("Pause-MF", "Emcure", "Tab", "500mg + 250mg")
            ),
            adultDose = "1 tablet PO TID with meals during heavy flow days (max 5 days).",
            childDose = "Post-menarchal adolescent females: 1 tablet PO BD-TID with meals.",
            contraindications = "Active thromboembolic disease (DVT, PE, cerebral thrombosis), history of venous or arterial thromboembolism, intrinsic risk of thrombosis, severe renal impairment, subarachnoid hemorrhage.",
            modeOfAction = "Tranexamic acid inhibits fibrinolysis by blocking plasminogen activation on the uterine endometrium, reducing menstrual blood loss by ~50%; Mefenamic acid inhibits endometrial cyclooxygenase reducing prostaglandins that cause pain and vascular dilatation.",
            therapeuticClassTag = "Hemostatics & Antifibrinolytics"
        ),

        Drug(
            id = "d_com_etoricoxib",
            genericName = "Etoricoxib",
            system = "Musculoskeletal & Joint Disorders",
            drugClass = "Selective Cyclooxygenase-2 (COX-2) Inhibitor",
            blackBoxWarning = "Increased risk of serious cardiovascular thrombotic events, myocardial infarction, and stroke. Contraindicated in uncontrolled hypertension (consistently >140/90 mmHg).",
            indications = "Acute gouty arthritis (flares), relief of pain and signs of osteoarthritis, rheumatoid arthritis, ankylosing spondylitis, acute post-operative dental and orthopedic surgery pain.",
            doses = "Acute Gouty Arthritis: 120 mg PO once daily for maximum 8 days.\nOsteoarthritis: 30 mg or 60 mg PO once daily.\nRheumatoid Arthritis / Ankylosing Spondylitis: 90 mg PO once daily.\nDental Pain: 90 mg PO once daily for max 3 days.",
            administration = "Take once daily with or without food. Onset is faster when taken on an empty stomach.",
            timing = "Once daily at the same time each day.",
            specialInstructions = "Blood pressure must be monitored prior to initiation and within 2 weeks of starting, as etoricoxib can cause pronounced BP elevations and fluid retention.",
            pkPd = "Highest COX-2 selectivity among coxibs (COX-2:COX-1 ratio ~106:1). Rapid absorption with peak plasma in ~1 hour. Terminal half-life ~22 hours enabling once-daily dosing.",
            renalAdj = "Mild-to-moderate CKD: Use lowest dose (30-60 mg); severe renal impairment (CrCl < 30 mL/min): CONTRAINDICATED.",
            hepaticAdj = "Moderate hepatic impairment (Child-Pugh 7-9): Maximum 60 mg every other day or 30 mg once daily. Severe: Contraindicated.",
            pregnancy = "Category C/D (Contraindicated in pregnancy, especially 3rd trimester).",
            lactation = "Excreted in milk of lactating rats; contraindicated during breastfeeding.",
            sideEffects = "Hypertension (dose-dependent), peripheral edema, palpitations, headache, dizziness, gastrointestinal discomfort, elevated liver enzymes.",
            priceNpr = "NPR 140.00 - 280.00 per strip of 10 tablets (90 mg)",
            priceInr = "INR 95.00 - 190.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Nucoxia-90", "Zydus Cadila Nepal", "Tab", "90 mg"),
                BrandInfo("Etoshine-90", "Sun Pharma Nepal", "Tab", "90 mg"),
                BrandInfo("Brutaflam-90", "Mankind Pharma", "Tab", "90 mg"),
                BrandInfo("Etorica-90", "Micro Labs", "Tab", "90 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Nucoxia", "Zydus", "Tab", "90 mg / 120 mg"),
                BrandInfo("Etoshine", "Sun Pharma", "Tab", "90 mg / 120 mg")
            ),
            adultDose = "60 mg to 90 mg PO OD; Gout flares: 120 mg PO OD (max 8 days).",
            childDose = "Contraindicated in children and adolescents < 16 years.",
            contraindications = "Uncontrolled hypertension (>140/90 mmHg), active peptic ulcer or GI bleeding, established ischemic heart disease, peripheral arterial disease, cerebrovascular disease, severe heart failure (NYHA II-IV).",
            modeOfAction = "Selectively and reversibly inhibits cyclooxygenase-2 (COX-2) enzyme with negligible inhibition of COX-1 at therapeutic concentrations, suppressing inflammatory prostaglandin synthesis without disrupting protective gastrointestinal COX-1 prostaglandins.",
            therapeuticClassTag = "NSAIDs & Analgesics"
        ),

        // =========================================================================
        // 3. ANTIMICROBIALS & ANTIPARASITICS
        // =========================================================================
        Drug(
            id = "d_com_cefpodoxime",
            genericName = "Cefpodoxime Proxetil",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Third-Generation Cephalosporin (Oral Prodrug)",
            blackBoxWarning = null,
            indications = "Community-acquired pneumonia (mild-to-moderate), acute bacterial exacerbation of chronic bronchitis, acute maxillary sinusitis, pharyngitis / tonsillitis, uncomplicated skin and skin structure infections, uncomplicated urinary tract infections (cystitis).",
            doses = "Adults: 200 mg PO every 12 hours with meals for 5-10 days.\nUncomplicated Cystitis: 100 mg PO every 12 hours for 7 days.",
            administration = "Take tablets with food to enhance gastrointestinal bioavailability. Oral suspension can be given with or without food.",
            timing = "Every 12 hours (morning and evening) with meals.",
            specialInstructions = "Prodrug de-esterified in intestinal wall to active cefpodoxime. Separate from antacids or H2 blockers by at least 2 hours.",
            pkPd = "Active cefpodoxime has ~50% bioavailability when taken with food. 20-30% protein bound. Excreted primarily unchanged in urine (80%). Half-life 2-3 hours.",
            renalAdj = "CrCl 30-50 mL/min: Standard dose every 24 hours; CrCl < 30 mL/min: Standard dose every 48 hours; Hemodialysis: Administer dose after dialysis.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category B (No evidence of fetal harm; commonly prescribed in antenatal infections).",
            lactation = "Excreted in human milk in low concentrations; compatible with breastfeeding.",
            sideEffects = "Diarrhea (most common ~7%), nausea, loose stools, fungal superinfections (oral/vaginal candidiasis), headache, mild transient ALT/AST elevation.",
            priceNpr = "NPR 180.00 - 360.00 per strip of 10 tablets (200 mg)",
            priceInr = "INR 120.00 - 240.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Cepodem-200", "Ranbaxy / Sun Pharma Nepal", "Tab", "200 mg"),
                BrandInfo("Gudcef-200", "Mankind Pharma", "Tab", "200 mg"),
                BrandInfo("Doxcef-200", "Lupin Limited", "Tab", "200 mg"),
                BrandInfo("Monocef-O 200", "Aristo Pharmaceuticals", "Tab", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cepodem", "Sun Pharma", "Tab", "200 mg"),
                BrandInfo("Gudcef", "Mankind", "Tab", "200 mg"),
                BrandInfo("Monocef-O", "Aristo", "Tab", "200 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg/kg/day PO divided every 12 hours (max 400 mg/day)",
            adultDose = "200 mg PO BD with food x 5-10 days.",
            childDose = "Children 2 months to 12 years: 10 mg/kg/day PO divided BID (max 200 mg/dose).",
            contraindications = "Known hypersensitivity to cephalosporins, penicillins, or other beta-lactam antibiotics.",
            modeOfAction = "Inhibits bacterial cell wall synthesis by binding to penicillin-binding proteins (PBPs), leading to bacterial cell wall lysis and autolysis. Broad spectrum against S. pneumoniae, H. influenzae, M. catarrhalis, and Enterobacteriaceae.",
            therapeuticClassTag = "Cephalosporins"
        ),

        Drug(
            id = "d_com_cefuroxime",
            genericName = "Cefuroxime Axetil",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Second-Generation Cephalosporin (Oral Prodrug)",
            blackBoxWarning = null,
            indications = "Pharyngitis/tonsillitis, acute bacterial otitis media, acute bacterial maxillary sinusitis, acute bacterial exacerbations of chronic bronchitis, uncomplicated skin infections, early Lyme disease (erythema migrans), uncomplicated urinary tract infections.",
            doses = "Adults: 250 mg to 500 mg PO every 12 hours after food for 7-10 days.\nSevere bronchitis / Pneumonia: 500 mg PO BID.\nLyme Disease: 500 mg PO BID x 14 days.",
            administration = "Take tablets after meals. Swallow tablets whole; crushing results in a persistent, strongly bitter taste.",
            timing = "Every 12 hours with or after food.",
            specialInstructions = "Axetil ester group increases lipophilicity and oral absorption; hydrolyzed to active cefuroxime in gastrointestinal mucosa and portal blood.",
            pkPd = "Bioavailability ~50-60% when taken with food. Widely distributed into pleural fluid, synovial fluid, sputum, and aqueous humor. Excreted unchanged in urine (>85%).",
            renalAdj = "CrCl 10-29 mL/min: Standard dose every 24 hours; CrCl < 10 mL/min: Standard dose every 48 hours; Hemodialysis: Administer supplemental dose at end of session.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe; extensively used in obstetric infections).",
            lactation = "Excreted into human breast milk in low concentrations; compatible with nursing.",
            sideEffects = "Diarrhea, nausea, vomiting, abdominal discomfort, Candida overgrowth, transient eosinophilia, elevated AST/ALT.",
            priceNpr = "NPR 350.00 - 650.00 per strip of 10 tablets (500 mg)",
            priceInr = "INR 220.00 - 450.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Ceftum-500", "GlaxoSmithKline (GSK) Nepal", "Tab", "500 mg"),
                BrandInfo("Cetil-500", "Lupin Limited", "Tab", "500 mg"),
                BrandInfo("Zinnat-500", "GSK Nepal", "Tab", "500 mg"),
                BrandInfo("Forcef-500", "Aristo Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ceftum", "GSK", "Tab", "250 mg / 500 mg"),
                BrandInfo("Zinnat", "GSK", "Tab", "500 mg"),
                BrandInfo("Cetil", "Lupin", "Tab", "500 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "mg/kg/day PO divided every 12 hours (max 500 mg/day; Otitis media 30 mg/kg/day)",
            adultDose = "250 to 500 mg PO BD after meals x 7-10 days.",
            childDose = "Children 3 months - 12 yr: 20-30 mg/kg/day PO divided BID (max 500-1000 mg/day).",
            contraindications = "Severe hypersensitivity to cefuroxime or cephalosporin class antibiotics; history of anaphylaxis to penicillins.",
            modeOfAction = "Binds to bacterial PBPs, inhibiting transpeptidation of peptidoglycan synthesis in bacterial cell wall, resulting in osmotic lysis. High stability against beta-lactamases produced by H. influenzae, Moraxella, and S. aureus.",
            therapeuticClassTag = "Cephalosporins"
        ),

        Drug(
            id = "d_com_oflox_ornidazole",
            genericName = "Ofloxacin + Ornidazole",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Fluoroquinolone + Nitroimidazole Fixed-Dose Combination",
            blackBoxWarning = "Fluoroquinolones associated with disabling and potentially irreversible adverse reactions: tendinitis, tendon rupture, peripheral neuropathy, and CNS toxicities.",
            indications = "Mixed bacterial and protozoal diarrhea (bacterial enteritis + amoebiasis/giardiasis), acute infectious gastroenteritis, intra-abdominal infections, pelvic inflammatory disease (PID), mixed dental infections.",
            doses = "Adults: 1 tablet (Ofloxacin 200 mg + Ornidazole 500 mg) PO twice daily with meals for 5 consecutive days.",
            administration = "Take tablets with a full glass of water after food. Maintain generous oral hydration (at least 2-3 liters of fluids daily) to prevent crystalluria.",
            timing = "Morning and evening after meals x 5 days.",
            specialInstructions = "Avoid concurrent dairy, calcium, iron, or antacid intake (separate by 2 hours). Avoid heavy alcohol consumption during and for 3 days post-treatment.",
            pkPd = "Ofloxacin has ~98% bioavailability and concentrates in gut tissue and urine; Ornidazole has longer half-life (~13h) than metoclopramide/metronidazole with superior tissue penetration and lower incidence of metallic taste.",
            renalAdj = "CrCl 20-50 mL/min: 1 tablet once daily; CrCl < 20 mL/min: 1 tablet every 48 hours.",
            hepaticAdj = "Use with caution in severe hepatic impairment due to reduced ornidazole elimination.",
            pregnancy = "Category C (Avoid in 1st trimester; quinolones cause cartilage damage in immature animals).",
            lactation = "Avoid; excreted in breast milk. Discard milk during therapy and for 48 hours after.",
            sideEffects = "Nausea, metallic taste, epigastric discomfort, headache, dizziness, insomnia, photosensitivity, rare tendon pain or Achilles tendinitis.",
            priceNpr = "NPR 120.00 - 240.00 per strip of 10 tablets",
            priceInr = "INR 80.00 - 160.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("O2 Tablets", "Medley Pharmaceuticals Nepal", "Tab", "200 mg + 500 mg"),
                BrandInfo("Zenflox-OZ", "Mankind Pharma", "Tab", "200 mg + 500 mg"),
                BrandInfo("Ornof Tablets", "Aristo Pharmaceuticals", "Tab", "200 mg + 500 mg"),
                BrandInfo("Oflomac-OZ", "Macleods Pharmaceuticals", "Tab", "200 mg + 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("O2", "Medley", "Tab", "200mg + 500mg"),
                BrandInfo("Zenflox-OZ", "Mankind", "Tab", "200mg + 500mg")
            ),
            adultDose = "1 tablet PO BD after meals x 5 days.",
            childDose = "Contraindicated in pediatric patients and growing adolescents due to quinolone arthropathy risk.",
            contraindications = "Hypersensitivity to fluoroquinolones or nitroimidazoles; history of tendon rupture; epilepsy or seizure disorders; QT prolongation; myasthenia gravis; 1st trimester of pregnancy.",
            modeOfAction = "Dual antimicrobial synergy: Ofloxacin inhibits bacterial DNA gyrase (topoisomerase II) and topoisomerase IV preventing DNA replication in aerobic Gram-negative bacilli; Ornidazole is reduced by ferredoxin in anaerobes and protozoa, generating cytotoxic free radicals that break helical DNA strands.",
            therapeuticClassTag = "Quinolones & Antiprotozoals"
        ),

        Drug(
            id = "d_com_albendazole",
            genericName = "Albendazole",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Benzimidazole Anthelmintic / Microtubule Disrupter",
            blackBoxWarning = "Bone marrow suppression (aplastic anemia, agranulocytosis) and hepatic impairment reported with prolonged multi-week high-dose therapy in echinococcosis.",
            indications = "Ascariasis (roundworm), Enterobius vermicularis (pinworm), Ancylostoma duodenale / Necator americanus (hookworm), Trichuris trichiura (whipworm), Strongyloides stercoralis, Neurocysticercosis (Taenia solium larvae), Echinococcosis (hydatid cyst disease), cutaneous larva migrans.",
            doses = "Intestinal Nematodes (Ascariasis, Hookworm, Pinworm): Adults & Children >= 2 yr: 400 mg PO as a single dose (repeat in 2 weeks for pinworm).\nStrongyloides: 400 mg PO once daily for 3 days.\nNeurocysticercosis: 15 mg/kg/day PO in 2 divided doses with fatty meals for 8-30 days (with concurrent dexamethasone).",
            administration = "Tablets should be crushed or chewed thoroughly before swallowing. For tissue parasites (cysticercosis, hydatid), take with high-fat meal to enhance oral absorption by up to 5-fold.",
            timing = "Single dose at bedtime or with evening fatty meal.",
            specialInstructions = "In neurocysticercosis, always pre-treat with oral corticosteroids and anticonvulsants to prevent intracranial hypertensive crisis caused by dying cysticerci inflammation.",
            pkPd = "Poor oral absorption (<5%) when fasted; converted via rapid hepatic first-pass metabolism to active metabolite albendazole sulfoxide, which crosses the blood-brain barrier into CSF.",
            renalAdj = "No adjustment needed for single-dose intestinal worm therapy.",
            hepaticAdj = "Monitor LFTs during prolonged therapy; avoid if transaminases exceed 2x ULN.",
            pregnancy = "Category C (Teratogenic and embryotoxic in animals; CONTRAINDICATED in 1st trimester of pregnancy. Screen females of reproductive potential).",
            lactation = "Excreted into breast milk in low concentrations; compatible with single-dose therapy.",
            sideEffects = "Epigastric discomfort, nausea, vomiting, transient diarrhea, headache, dizziness, elevated transaminases with prolonged therapy.",
            priceNpr = "NPR 15.00 - 30.00 per chewable tablet (400 mg)",
            priceInr = "INR 10.00 - 22.00 per chewable tablet",
            brandsNepal = listOf(
                BrandInfo("Zentel-400", "GlaxoSmithKline (GSK) Nepal", "Tab", "400 mg chewable"),
                BrandInfo("Bandy-400", "Mankind Pharma", "Tab", "400 mg chewable"),
                BrandInfo("Alben-400", "Nepal Pharmaceuticals Lab", "Tab", "400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Zentel", "GSK", "Tab", "400 mg"),
                BrandInfo("Bandy", "Mankind", "Tab", "400 mg")
            ),
            adultDose = "400 mg PO single chewable dose (repeat in 2 weeks for enterobiasis).",
            childDose = "Children 1-2 years: 200 mg single dose; Children >= 2 years: 400 mg single dose.",
            contraindications = "Known hypersensitivity to benzimidazole class anthelmintics; 1st trimester of pregnancy.",
            modeOfAction = "Binds to parasite beta-tubulin, inhibiting microtubule polymerization and blocking glucose uptake in larval and adult helminths, depleting parasite glycogen stores and causing ATP exhaustion and death.",
            therapeuticClassTag = "Anthelmintics & Antiparasitics"
        ),

        // =========================================================================
        // 4. RESPIRATORY, ALLERGY & COUGH
        // =========================================================================
        Drug(
            id = "d_com_levocetirizine",
            genericName = "Levocetirizine Dihydrochloride",
            system = "Respiratory & Allergic Disorders",
            drugClass = "Third-Generation Non-Sedating H1-Receptor Antagonist (R-enantiomer)",
            blackBoxWarning = null,
            indications = "Allergic rhinitis (seasonal and perennial), chronic idiopathic urticaria, allergic rhinoconjunctivitis, pruritus, atopic dermatitis adjunct.",
            doses = "Adults & Adolescents >= 12 yr: 5 mg PO once daily in the evening.\nChildren 6-11 yr: 2.5 mg (half tablet or 5 mL oral solution) once daily in the evening.",
            administration = "Take with or without food. Evening administration preferred due to mild somnolence in ~5% of patients.",
            timing = "Once daily in the evening at bedtime.",
            specialInstructions = "Twice the affinity for human H1 receptors compared to racemic cetirizine, allowing equivalent efficacy at half the dose with reduced sedation.",
            pkPd = "Rapid absorption with peak plasma in ~0.9 hours. Minimal hepatic metabolism (~14%). 85% excreted unchanged in urine via active tubular secretion. Half-life ~8 hours.",
            renalAdj = "eGFR 50-79 mL/min: 2.5 mg once daily; eGFR 30-49 mL/min: 2.5 mg every other day; eGFR 10-29 mL/min: 2.5 mg every 3-4 days; eGFR < 10 mL/min or Dialysis: CONTRAINDICATED.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (No evidence of fetal harm; safe second-line in pregnancy after chlorpheniramine/cetirizine).",
            lactation = "Excreted into breast milk; use lowest effective dose or consider non-sedating alternative.",
            sideEffects = "Somnolence / fatigue (~5-6%), dry mouth, pharyngitis, headache, asthenia.",
            priceNpr = "NPR 60.00 - 120.00 per strip of 10 tablets (5 mg)",
            priceInr = "INR 35.00 - 85.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Vozet-5", "Sun Pharma Nepal", "Tab", "5 mg"),
                BrandInfo("Levorid-5", "Cipla Nepal", "Tab", "5 mg"),
                BrandInfo("Xyzal-5", "Dr. Reddy's Nepal", "Tab", "5 mg"),
                BrandInfo("Teczine-5", "Ranbaxy Nepal", "Tab", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Vozet", "Sun Pharma", "Tab", "5 mg"),
                BrandInfo("Levorid", "Cipla", "Tab", "5 mg"),
                BrandInfo("Xyzal", "Dr. Reddy's", "Tab", "5 mg")
            ),
            adultDose = "5 mg PO once daily at bedtime.",
            childDose = "Children 6 months - 5 yr: 1.25 mg once daily in evening; 6-11 yr: 2.5 mg once daily in evening.",
            contraindications = "Severe renal impairment (CrCl < 10 mL/min) or patients undergoing hemodialysis; children 6 months to 11 years with renal impairment.",
            modeOfAction = "Selective inverse agonist at peripheral H1 receptors, preventing histamine-mediated capillary permeability, wheal and flare reactions, pruritus, and nasal rhinorrhea without central anticholinergic effects.",
            therapeuticClassTag = "Antihistamines"
        ),

        Drug(
            id = "d_com_montelukast_levo",
            genericName = "Montelukast Sodium + Levocetirizine Dihydrochloride",
            system = "Respiratory & Allergic Disorders",
            drugClass = "Leukotriene Receptor Antagonist (LTRA) + H1 Antihistamine Fixed Combination",
            blackBoxWarning = "Montelukast Black Box Warning: Serious neuropsychiatric events reported (agitation, aggression, depression, sleep disturbances, suicidal thoughts). Monitor behavior.",
            indications = "Allergic rhinitis complicated by bronchial asthma, persistent seasonal and perennial allergic rhinitis, chronic allergic rhinobronchitis, nocturnal cough in atopic individuals.",
            doses = "Adults & Adolescents >= 15 yr: 1 tablet (Montelukast 10 mg + Levocetirizine 5 mg) PO once daily at bedtime.",
            administration = "Take once daily in the evening with or without food. Do not chew or crush film-coated tablets.",
            timing = "Nightly at bedtime.",
            specialInstructions = "Counsel patients and families to immediately report any new mood changes, nightmares, insomnia, agitation, or depressive symptoms.",
            pkPd = "Dual anti-inflammatory pathway: Montelukast blocks cysteinyl leukotriene CysLT1 receptors reducing airway edema and bronchoconstriction; Levocetirizine blocks histamine H1 receptors stopping rhinorrhea and sneezing.",
            renalAdj = "Adjust dose based on the levocetirizine component: avoid in CrCl < 10 mL/min.",
            hepaticAdj = "No adjustment in mild-to-moderate cirrhosis; use caution in severe hepatic impairment.",
            pregnancy = "Category B (Widely prescribed in antenatal allergic asthma; weigh neuropsychiatric risks).",
            lactation = "Compatible; small amounts excreted in breast milk.",
            sideEffects = "Headache, drowsiness, fatigue, upper respiratory tract infection, vivid dreams / sleep disturbances, dry mouth, abdominal pain.",
            priceNpr = "NPR 140.00 - 280.00 per strip of 10 tablets (10 mg + 5 mg)",
            priceInr = "INR 95.00 - 190.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Montair-LC", "Cipla Nepal", "Tab", "10 mg + 5 mg"),
                BrandInfo("Telekast-L", "Lupin Limited", "Tab", "10 mg + 5 mg"),
                BrandInfo("Montek-LC", "Sun Pharma Nepal", "Tab", "10 mg + 5 mg"),
                BrandInfo("Romilast-L", "Ranbaxy Nepal", "Tab", "10 mg + 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Montair-LC", "Cipla", "Tab", "10mg + 5mg"),
                BrandInfo("Telekast-L", "Lupin", "Tab", "10mg + 5mg"),
                BrandInfo("Montek-LC", "Sun Pharma", "Tab", "10mg + 5mg")
            ),
            adultDose = "1 tablet PO once daily at bedtime.",
            childDose = "Pediatric chewable formulations (Montelukast 4mg/5mg + Levo 2.5mg) for children 2-14 years.",
            contraindications = "Hypersensitivity to montelukast, levocetirizine, or cetirizine; end-stage renal disease (CrCl < 10 mL/min) or hemodialysis.",
            modeOfAction = "Simultaneously targets the early histamine-mediated allergic response (sneezing, itching, rhinorrhea via H1 antagonism) and the late leukotriene-mediated inflammatory cascade (mucosal congestion, bronchial hyperreactivity via CysLT1 antagonism).",
            therapeuticClassTag = "Antihistamines & Leukotriene Modifiers"
        ),

        Drug(
            id = "d_com_bilastine",
            genericName = "Bilastine",
            system = "Respiratory & Allergic Disorders",
            drugClass = "Second-Generation Non-Sedating H1-Antihistamine",
            blackBoxWarning = null,
            indications = "Symptomatic treatment of allergic rhinoconjunctivitis (seasonal and perennial) and urticaria (hives, wheals, itching) in adults and adolescents.",
            doses = "Adults & Adolescents >= 12 yr: 20 mg PO once daily.",
            administration = "Take on an empty stomach with a full glass of water: 1 hour before or 2 hours after meals or fruit juices. Ingestion with food or grapefruit juice reduces bioavailability by 30-40%.",
            timing = "1 hour before breakfast or 2 hours after evening meal.",
            specialInstructions = "Zero hepatic metabolism (does not interact with CYP450 enzymes). Brain H1-receptor occupancy is near 0%, making it the least sedating antihistamine approved for pilots and drivers.",
            pkPd = "Rapid absorption (Tmax ~1.3h). Not metabolized in the liver; eliminated largely unchanged in feces (~67%) and urine (~33%) via OATP1A2 and P-glycoprotein transport. Elimination half-life ~14.5 hours.",
            renalAdj = "No dosage adjustment required in renal impairment.",
            hepaticAdj = "No dosage adjustment required in hepatic impairment.",
            pregnancy = "Category B (Limited clinical trial data in pregnant humans; avoid unless benefit clearly justifies potential risk).",
            lactation = "Excretion into breast milk has not been studied; use with caution.",
            sideEffects = "Headache, somnolence (comparable to placebo ~1.5%), dizziness, fatigue, abdominal pain.",
            priceNpr = "NPR 180.00 - 320.00 per strip of 10 tablets (20 mg)",
            priceInr = "INR 120.00 - 210.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Bilasure-20", "Sun Pharma Nepal", "Tab", "20 mg"),
                BrandInfo("Bilanext-20", "Zydus Healthcare", "Tab", "20 mg"),
                BrandInfo("Bilacad-20", "Cadila Pharmaceuticals", "Tab", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Bilasure", "Sun Pharma", "Tab", "20 mg"),
                BrandInfo("Bilanext", "Zydus", "Tab", "20 mg")
            ),
            adultDose = "20 mg PO once daily on empty stomach.",
            childDose = "Children 6-11 yr (weight >= 20 kg): 10 mg once daily (orodispersible tablet or oral solution).",
            contraindications = "Known hypersensitivity to bilastine or any excipients; concurrent use of P-glycoprotein inhibitors (ketoconazole, erythromycin) in patients with moderate-to-severe renal impairment.",
            modeOfAction = "Potent and highly selective peripheral H1-receptor antagonist with prolonged duration of action (>24 hours) and lack of affinity for muscarinic, adrenergic, or serotonergic receptors.",
            therapeuticClassTag = "Antihistamines"
        ),

        Drug(
            id = "d_com_xylometazoline",
            genericName = "Xylometazoline Hydrochloride 0.1% (Adult) / 0.05% (Paediatric)",
            system = "Respiratory & Allergic Disorders",
            drugClass = "Topical Imidazoline Alpha-1 & Alpha-2 Adrenergic Agonist / Nasal Decongestant",
            blackBoxWarning = null,
            indications = "Short-term relief of nasal congestion associated with acute viral rhinitis (common cold), acute sinusitis, perennial or seasonal allergic rhinitis, facilitation of rhinoscopy and sinus drainage.",
            doses = "Adults & Children >= 12 yr (0.1% Drops / Spray): 2 to 3 drops or 1 spray into each nostril 2 to 3 times daily as needed (Maximum duration: 3 to 5 consecutive days).\nChildren 2 to 11 yr (0.05% Drops): 1 to 2 drops into each nostril 1 to 2 times daily (Max 3-5 days).",
            administration = "Clear nasal passages by blowing nose gently before use. Administer drops with head tilted back. Clean nozzle after use.",
            timing = "Every 8 to 10 hours as needed; avoid use beyond 5 consecutive days.",
            specialInstructions = "CRITICAL WARNING: Rebound nasal congestion (Rhinitis Medicamentosa) occurs if used for >5-7 consecutive days, leading to chronic mucosal hypertrophy and physical dependence.",
            pkPd = "Rapid onset within 2-5 minutes; vasoconstriction lasts 8-10 hours. Negligible systemic absorption when used correctly at therapeutic doses.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Systemic alpha-adrenergic vasoconstriction may theoretically reduce uteroplacental blood flow; avoid frequent or prolonged use).",
            lactation = "Compatible with caution; systemic absorption is minimal.",
            sideEffects = "Nasal burning, stinging, mucosal dryness, sneezing, headache, rebound congestion (rhinitis medicamentosa) on withdrawal after prolonged use.",
            priceNpr = "NPR 65.00 - 110.00 per 10 mL dropper bottle (0.1%)",
            priceInr = "INR 45.00 - 85.00 per 10 mL bottle",
            brandsNepal = listOf(
                BrandInfo("Otrivin 0.1% Nasal Drops", "GSK Nepal", "Drops", "0.1% w/v (10 mL)"),
                BrandInfo("Otrivin Paediatric 0.05%", "GSK Nepal", "Drops", "0.05% w/v (10 mL)"),
                BrandInfo("Nasivion / Xylomet", "Merck / Medisales", "Drops", "0.1% w/v")
            ),
            brandsIndia = listOf(
                BrandInfo("Otrivin", "GSK", "Drops/Spray", "0.1% / 0.05%"),
                BrandInfo("Nasivion", "Procter & Gamble", "Drops", "0.05% / 0.1%")
            ),
            adultDose = "2-3 drops 0.1% per nostril BD-TID (max 5 days).",
            childDose = "Children 2-11 yr: 1-2 drops 0.05% per nostril BD (max 5 days). Contraindicated in infants < 2 yr.",
            contraindications = "Narrow-angle glaucoma, transsphenoidal hypophysectomy or cranial surgery exposing dura mater, rhinitis sicca (atrophic rhinitis), concurrent monoamine oxidase inhibitors (MAOIs).",
            modeOfAction = "Direct agonist at post-junctional alpha-1 and alpha-2 adrenergic receptors on precapillary arterioles of the nasal mucosa, producing rapid vasoconstriction, decreased mucosal blood flow, reduction of mucosal edema, and opening of nasal airways.",
            therapeuticClassTag = "Nasal Decongestants"
        ),

        // =========================================================================
        // 5. CARDIOVASCULAR & METABOLIC
        // =========================================================================
        Drug(
            id = "d_com_cilnidipine",
            genericName = "Cilnidipine",
            system = "Cardiovascular System (CVS)",
            drugClass = "Dual L-type and N-type Dihydropyridine Calcium Channel Blocker (CCB)",
            blackBoxWarning = null,
            indications = "Essential hypertension, hypertension with microalbuminuria or diabetic kidney disease, hypertension with reflex tachycardia or intolerance to amlodipine pedal edema.",
            doses = "Adults: 5 mg to 10 mg PO once daily in morning. May increase up to 20 mg PO once daily based on blood pressure response.",
            administration = "Take tablets with water in the morning with or after breakfast.",
            timing = "Once daily in the morning.",
            specialInstructions = "Unlike amlodipine (pure L-type CCB), cilnidipine blocks both L-type and N-type calcium channels. N-type blockade at sympathetic nerve endings inhibits norepinephrine release, causing balanced afferent and efferent arteriolar vasodilation, reducing intraglomerular pressure, proteinuria, and pedal edema.",
            pkPd = "Rapid oral absorption. Highly protein bound (98%). Extensively metabolized in liver by CYP3A4. Elimination half-life ~2.5 hours, but vascular receptor dissociation is slow, providing full 24-hour BP reduction.",
            renalAdj = "No dosage adjustment needed. Renoprotective in chronic kidney disease and diabetic nephropathy.",
            hepaticAdj = "Use with caution in moderate to severe hepatic impairment.",
            pregnancy = "Category C (Avoid; dihydropyridines may impair uteroplacental perfusion).",
            lactation = "Excreted in animal milk; avoid breastfeeding during therapy.",
            sideEffects = "Significantly lower incidence of ankle/pedal edema compared to amlodipine (<2% vs ~10%); mild headache, facial flushing, dizziness, mild GI discomfort.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 tablets (10 mg)",
            priceInr = "INR 70.00 - 150.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Cilacar-10", "J.B. Chemicals & Pharmaceuticals", "Tab", "10 mg"),
                BrandInfo("Cilacar-5", "J.B. Chemicals & Pharmaceuticals", "Tab", "5 mg"),
                BrandInfo("Nexvas-10", "Sun Pharma Nepal", "Tab", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cilacar", "J.B. Chemicals", "Tab", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Nexvas", "Sun Pharma", "Tab", "10 mg")
            ),
            adultDose = "5 mg to 10 mg PO once daily (max 20 mg/day).",
            childDose = "Safety and efficacy not established in pediatric patients.",
            contraindications = "Hypersensitivity to dihydropyridine calcium channel blockers; severe hypotension or cardiogenic shock; severe aortic stenosis.",
            modeOfAction = "Blocks L-type calcium channels on vascular smooth muscle causing systemic vasodilation, and blocks N-type calcium channels on sympathetic nerve terminals, attenuating reflex tachycardia, reducing sympathetic overflow, and dilating both renal afferent and efferent arterioles.",
            therapeuticClassTag = "Calcium Channel Blockers & Anti-HTN"
        ),

        Drug(
            id = "d_com_chlorthalidone",
            genericName = "Chlorthalidone",
            system = "Cardiovascular System (CVS)",
            drugClass = "Long-Acting Phthalimidine Thiazide-Like Diuretic",
            blackBoxWarning = null,
            indications = "Essential hypertension (preferred first-line thiazide-like diuretic in ACC/AHA guidelines), edema associated with congestive heart failure, nephrotic syndrome, hepatic cirrhosis with ascites adjunct.",
            doses = "Hypertension: Initial 6.25 mg to 12.5 mg PO once daily in morning; titrate to 25 mg once daily based on blood pressure and electrolytes.\nEdema: 25 to 50 mg PO daily or on alternate days (max 100 mg/day).",
            administration = "Take in the morning with food to minimize nocturnal diuresis and GI upset.",
            timing = "Morning with breakfast.",
            specialInstructions = "Significantly longer half-life (40-60 hours) and proven 24-hour ambulatory blood pressure reduction and cardiovascular event reduction (ALLHAT trial) compared to hydrochlorothiazide. Monitor serum potassium, sodium, and uric acid.",
            pkPd = "Bioavailability ~65%. Highly bound to erythrocyte carbonic anhydrase, resulting in extremely slow release into plasma and elimination half-life of 40-60 hours. Excreted largely unchanged by kidneys.",
            renalAdj = "Ineffective when eGFR < 30 mL/min (switch to loop diuretic like furosemide or torsemide).",
            hepaticAdj = "Use with extreme caution in hepatic cirrhosis; electrolyte shifts can precipitate hepatic encephalopathy.",
            pregnancy = "Category B (Thiazides cross placenta; may decrease placental perfusion; avoid for routine gestational hypertension).",
            lactation = "Excreted in breast milk in small amounts; may suppress lactation.",
            sideEffects = "Hypokalemia, hyponatremia, hyperuricemia (may precipitate acute gout), hyperglycemia (worsens insulin resistance), hypomagnesemia, muscle cramps, erectile dysfunction.",
            priceNpr = "NPR 70.00 - 130.00 per strip of 10 tablets (12.5 mg)",
            priceInr = "INR 45.00 - 85.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Hythalton-12.5", "Torrent Pharmaceuticals Nepal", "Tab", "12.5 mg"),
                BrandInfo("Thalizide-12.5", "Sun Pharma Nepal", "Tab", "12.5 mg"),
                BrandInfo("Chlortan-12.5", "Micro Labs", "Tab", "12.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Hythalton", "Torrent", "Tab", "6.25 mg / 12.5 mg"),
                BrandInfo("Thalizide", "Sun Pharma", "Tab", "12.5 mg")
            ),
            adultDose = "6.25 to 25 mg PO once daily in morning.",
            childDose = "Pediatric dosing: 0.3 mg/kg/day PO (specialist pediatric nephrology use).",
            contraindications = "Anuria; severe renal failure (eGFR < 30 mL/min); refractory hypokalemia or hyponatremia; symptomatic hyperuricemia (gout); Addison disease; hypersensitivity to sulfonamide-derived drugs.",
            modeOfAction = "Inhibits Na+/Cl- cotransporter in the cortical thick ascending limb and early distal convoluted tubule of the nephron, promoting urinary excretion of sodium, chloride, and water, with sustained reduction in peripheral vascular resistance.",
            therapeuticClassTag = "Diuretics & Anti-HTN"
        ),

        // =========================================================================
        // 6. NEUROPSYCHIATRY, VERTIGO & MUSCLE RELAXANTS
        // =========================================================================
        Drug(
            id = "d_com_betahistine",
            genericName = "Betahistine Dihydrochloride",
            system = "Neurology & Psychiatric Disorders",
            drugClass = "Histamine H1-Receptor Agonist & H3-Receptor Antagonist / Antivertigo Agent",
            blackBoxWarning = null,
            indications = "Ménière's disease (triad of vertigo, tinnitus, and hearing loss), peripheral vestibular vertigo, recurrent labyrinthine disorders, benign paroxysmal positional vertigo (BPPV) rehabilitation adjunct.",
            doses = "Adults: 16 mg to 24 mg PO twice daily (or 8 to 16 mg PO TID) with meals. Maintenance typically 24 to 48 mg/day in divided doses for several months.",
            administration = "Take tablets with or immediately after meals to reduce gastrointestinal irritation.",
            timing = "Morning and evening with meals.",
            specialInstructions = "Acts primarily on the microcirculation of the inner ear. Use with caution in patients with bronchial asthma or peptic ulcer disease due to histaminergic receptor stimulation.",
            pkPd = "Rapid and almost complete absorption. Rapidly and almost completely converted to inactive metabolite 2-pyridylacetic acid. Elimination half-life ~3.5 hours.",
            renalAdj = "No dosage adjustment necessary.",
            hepaticAdj = "No dosage adjustment necessary.",
            pregnancy = "Category B (Data in pregnant women are limited; avoid unless clearly required).",
            lactation = "Excretion into breast milk unknown; weigh risk-benefit.",
            sideEffects = "Mild dyspepsia, nausea, abdominal bloating, headache, skin rash, pruritus.",
            priceNpr = "NPR 140.00 - 260.00 per strip of 10 tablets (16 mg)",
            priceInr = "INR 90.00 - 180.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Vertin-16", "Abbott Healthcare Nepal", "Tab", "16 mg"),
                BrandInfo("Vertin-24", "Abbott Healthcare Nepal", "Tab", "24 mg"),
                BrandInfo("Betavert-16", "Sun Pharma Nepal", "Tab", "16 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Vertin", "Abbott", "Tab", "8 mg / 16 mg / 24 mg"),
                BrandInfo("Betavert", "Sun Pharma", "Tab", "16 mg / 24 mg")
            ),
            adultDose = "16 to 24 mg PO BD with meals (max 48 mg/day).",
            childDose = "Not recommended in children < 18 years due to insufficient safety data.",
            contraindications = "Pheochromocytoma (histamine release can trigger severe hypertensive crisis); known hypersensitivity to betahistine; active peptic ulcer disease.",
            modeOfAction = "Acts as a partial agonist at histamine H1 receptors and strong antagonist at presynaptic H3 receptors in the inner ear and brainstem vestibular nuclei, improving microvascular blood flow in the stria vascularis of the labyrinth and reducing endolymphatic hydrops pressure.",
            therapeuticClassTag = "Antivertigo & Vestibular Modulators"
        ),

        Drug(
            id = "d_com_thiocolchicoside",
            genericName = "Thiocolchicoside",
            system = "Musculoskeletal & Joint Disorders",
            drugClass = "Semi-synthetic Colchicoside Derivative / Centrally Acting Muscle Relaxant",
            blackBoxWarning = "Aneuploidy / Chromosomal Damage: Metabolite M2 (SL59.0955) can cause aneuploidy in dividing cells. EMA recommends restricting treatment duration to maximum 7 consecutive days orally (or 5 days IM).",
            indications = "Adjuvant treatment of acute, painful contractures and muscle spasms in spinal pathology (acute lumbago, torticollis, cervical radiculopathy, post-traumatic musculoskeletal spasms).",
            doses = "Adults & Adolescents >= 16 yr: 8 mg PO every 12 hours (16 mg/day maximum) for a maximum of 7 consecutive days.\nIM dose: 4 mg IM every 12 hours for maximum 5 days.",
            administration = "Take tablets with a glass of water after food. Strictly observe the 7-day maximum duration limit.",
            timing = "Morning and evening with meals.",
            specialInstructions = "Strictly contraindicated in pregnancy, lactation, and in females of childbearing potential not using effective contraception due to potential aneuploidy risk.",
            pkPd = "Rapidly converted into glucuro-conjugated metabolite and active aglycone metabolite M2. Selective affinity for GABA-A and glycinergic receptors without sedative anticholinergic or curare-like flaccid paralysis.",
            renalAdj = "Use with caution in renal impairment.",
            hepaticAdj = "Use with caution; discontinue if hepatic transaminases elevate.",
            pregnancy = "Category X (CONTRAINDICATED in pregnancy and in women of childbearing potential not using contraception).",
            lactation = "CONTRAINDICATED during breastfeeding; passes into maternal milk.",
            sideEffects = "Somnolence, nausea, diarrhea, gastralgia, allergic skin reactions; rare seizures in predisposed epileptic patients.",
            priceNpr = "NPR 160.00 - 320.00 per strip of 10 capsules (8 mg)",
            priceInr = "INR 110.00 - 220.00 per strip of 10 capsules",
            brandsNepal = listOf(
                BrandInfo("Myoril-8", "Sanofi Nepal", "Cap", "8 mg"),
                BrandInfo("Thiospas-8", "Torrent Pharmaceuticals", "Cap", "8 mg"),
                BrandInfo("Zerodol-TH", "Ipca Laboratories (Aceclo + Thio)", "Tab", "100 mg + 4 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Myoril", "Sanofi", "Cap", "4 mg / 8 mg"),
                BrandInfo("Thiospas", "Torrent", "Cap", "8 mg")
            ),
            adultDose = "8 mg PO BD for maximum 7 consecutive days.",
            childDose = "Contraindicated in children and adolescents < 16 years.",
            contraindications = "Pregnancy, breastfeeding, women of childbearing potential not using effective contraception, flaccid paralysis, history of seizures/epilepsy.",
            modeOfAction = "Selective agonist at inhibitory GABA-A and strychnine-sensitive glycine receptors on spinal interneurons, suppressing spinal polysynaptic reflex arcs and relieving muscle contracture without reducing voluntary muscle power.",
            therapeuticClassTag = "Muscle Relaxants"
        ),

        // =========================================================================
        // 7. VITAMINS, HEMATOLOGY & MINERALS
        // =========================================================================
        Drug(
            id = "d_com_ferrous_ascorbate",
            genericName = "Ferrous Ascorbate + Folic Acid",
            system = "Hematology & Oncology",
            drugClass = "Hematinic / Elemental Iron & Vitamin B9 Supplement",
            blackBoxWarning = "Accidental overdose of iron-containing products is a leading cause of fatal poisoning in children under 6 years. Keep out of reach of children.",
            indications = "Prevention and treatment of iron deficiency anemia (IDA), nutritional microcytic hypochromic anemia, increased iron requirement during pregnancy and lactation, menorrhagia-associated chronic blood loss.",
            doses = "Adults & Pregnant Women: 1 tablet (Elemental Iron 100 mg + Folic Acid 1.5 mg) PO once daily after meals.\nSevere Anemia: 1 tablet PO twice daily.",
            administration = "Take with water 1-2 hours after food to improve GI tolerability. Do not consume tea, coffee, milk, or calcium supplements within 2 hours of ingestion.",
            timing = "Once daily after meals (preferably evening or mid-day).",
            specialInstructions = "Ascorbate maintains iron in the soluble ferrous (Fe2+) state across the duodenal brush border, providing higher absorption and significantly lower incidence of epigastric pain, nausea, and constipation than ferrous sulfate.",
            pkPd = "Ferrous ascorbate is absorbed predominantly in the duodenum and upper jejunum. Transported by divalent metal transporter 1 (DMT1) and stored as ferritin or transported by transferrin to bone marrow.",
            renalAdj = "Safe; no adjustment needed.",
            hepaticAdj = "Avoid in patients with severe hepatic hemochromatosis or iron overload syndromes.",
            pregnancy = "Category A (Essential national standard of care throughout 2nd and 3rd trimesters of pregnancy).",
            lactation = "Completely safe; supports maternal and infant iron stores.",
            sideEffects = "Dark/black discoloration of feces (harmless; reassure patient), mild constipation or loose stools, metallic taste, nausea.",
            priceNpr = "NPR 120.00 - 240.00 per strip of 10 tablets (100 mg iron)",
            priceInr = "INR 80.00 - 160.00 per strip of 10 tablets",
            brandsNepal = listOf(
                BrandInfo("Orofer-XT", "Emcure Pharmaceuticals Nepal", "Tab", "100 mg + 1.5 mg"),
                BrandInfo("Ferium-XT", "Emcure Pharmaceuticals", "Tab", "100 mg + 1.5 mg"),
                BrandInfo("HB-Set", "Mankind Pharma", "Tab", "100 mg + 1.5 mg"),
                BrandInfo("Fefol-Z", "GSK Nepal", "Cap", "Iron + Folic + Zinc")
            ),
            brandsIndia = listOf(
                BrandInfo("Orofer-XT", "Emcure", "Tab", "100 mg Fe + 1.5 mg FA"),
                BrandInfo("Ferium-XT", "Emcure", "Tab", "100 mg Fe + 1.5 mg FA")
            ),
            adultDose = "1 tablet PO OD after meals x 3-6 months until Hb and ferritin normalize.",
            childDose = "Pediatric iron drops/syrup: 3 to 6 mg elemental iron/kg/day PO in divided doses.",
            contraindications = "Iron overload states (hemochromatosis, hemosiderosis), thalassemia major, sideroblastic anemia, repeated blood transfusions, active peptic ulcer.",
            modeOfAction = "Replenishes depleted systemic iron stores necessary for heme synthesis, erythropoiesis, and myoglobin formation; Folic acid is essential for purine and thymidylate synthesis in rapidly dividing erythroblasts.",
            therapeuticClassTag = "Hematinics & Iron Formulations"
        ),

        Drug(
            id = "d_com_calcium_vit_d3",
            genericName = "Calcium Carbonate + Cholecalciferol (Vitamin D3)",
            system = "Musculoskeletal & Joint Disorders",
            drugClass = "Mineral & Vitamin D Analogue / Bone Health Supplement",
            blackBoxWarning = null,
            indications = "Prevention and management of osteopenia, osteoporosis (senile and postmenopausal), antenatal and lactating calcium supplementation, rickets/osteomalacia adjunct, corticosteroid-induced bone loss prophylaxis.",
            doses = "Adults & Pregnant / Lactating Females: 1 tablet (500 mg Elemental Calcium + 250 to 500 IU Vitamin D3) PO once or twice daily after meals.",
            administration = "Take with or immediately after meals. Calcium carbonate requires gastric acid for optimal dissolution and absorption.",
            timing = "After breakfast and/or dinner.",
            specialInstructions = "Separate from levothyroxine, iron supplements, ciprofloxacin, or tetracycline antibiotics by at least 2 to 4 hours to avoid chelation binding and decreased bioavailability.",
            pkPd = "Absorbed actively in the duodenum via vitamin D-dependent calbindin transport. 99% of body calcium resides in skeletal bone and teeth. Excess excreted in feces (~80%) and urine (~20%).",
            renalAdj = "Monitor serum calcium and phosphate in moderate-to-severe CKD to prevent vascular calcification.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category A (Standard antenatal supplementation starting from 14-16 weeks gestation onwards).",
            lactation = "Safe; vital for maintaining maternal bone mineral density during lactation.",
            sideEffects = "Constipation (most common), flatulence, abdominal bloating, hypercalcemia and milk-alkali syndrome if consumed in massive excess.",
            priceNpr = "NPR 90.00 - 180.00 per strip of 15 tablets (500 mg + 250 IU)",
            priceInr = "INR 65.00 - 130.00 per strip of 15 tablets",
            brandsNepal = listOf(
                BrandInfo("Shelcal-500", "Torrent Pharmaceuticals Nepal", "Tab", "500 mg Ca + 250 IU D3"),
                BrandInfo("Calcicad-500", "Cadila Pharmaceuticals", "Tab", "500 mg + 250 IU"),
                BrandInfo("Cipcal-500", "Cipla Nepal", "Tab", "500 mg + 250 IU")
            ),
            brandsIndia = listOf(
                BrandInfo("Shelcal-500", "Torrent", "Tab", "500 mg + 250 IU"),
                BrandInfo("Cipcal-500", "Cipla", "Tab", "500 mg + 250 IU")
            ),
            adultDose = "1 tablet PO once or twice daily with meals.",
            childDose = "Children: Calcium syrup 250-500 mg daily or pediatric formulations.",
            contraindications = "Hypercalcemia (hyperparathyroidism, sarcoidosis, osteolytic bone metastases), severe hypercalciuria, calcium nephrolithiasis (kidney stones), digoxin toxicity.",
            modeOfAction = "Provides supplemental calcium essential for bone matrix mineralization and osteoblast remodeling; Cholecalciferol is converted to 1,25-dihydroxycholecalciferol (calcitriol), stimulating active intestinal calcium and phosphate absorption.",
            therapeuticClassTag = "Bone Health & Minerals"
        ),

        Drug(
            id = "d_com_cholecalciferol_60k",
            genericName = "Cholecalciferol (Vitamin D3 60,000 IU)",
            system = "Endocrine & Metabolic System",
            drugClass = "Secosteroid Prohormone (High-Dose Oral Vitamin D3)",
            blackBoxWarning = null,
            indications = "Correction of severe Vitamin D deficiency (serum 25(OH)D < 20 ng/mL), osteoporosis adjunct, prevention of secondary hyperparathyroidism, hypocalcemic tetany, osteomalacia.",
            doses = "Deficiency Treatment: 1 capsule or sachet (60,000 IU) PO once weekly with a milk-containing meal for 8 consecutive weeks.\nMaintenance: 60,000 IU PO once monthly or once every 2 months.",
            administration = "Swallow capsule whole with whole milk or fatty meal to maximize lipid micelle absorption.",
            timing = "Once weekly on a fixed day of the week with a meal.",
            specialInstructions = "Check serum 25-hydroxyvitamin D [25(OH)D] after 8-12 weeks of therapy (target level: 30-50 ng/mL). Avoid hypervitaminosis D.",
            pkPd = "Hydroxylated in the liver by 25-hydroxylase (CYP2R1) to 25-hydroxyvitamin D3 [calcifediol], then in the renal proximal tubule by 1-alpha-hydroxylase (CYP27B1) to active calcitriol. Fat-stored with biological half-life ~2 months.",
            renalAdj = "Severe CKD (eGFR < 30 mL/min) cannot convert cholecalciferol to calcitriol; requires active calcitriol or alfacalcidol.",
            hepaticAdj = "No adjustment needed in mild-to-moderate impairment.",
            pregnancy = "Category C/A (Safe within dietary reference intakes; high-dose weekly pulses should be monitored).",
            lactation = "Compatible; small amounts excreted in breast milk.",
            sideEffects = "Well-tolerated at recommended weekly doses. Toxicity (hypercalcemia, polyuria, polydipsia, metastatic calcification, nephrocalcinosis) occurs only with prolonged daily overdosing.",
            priceNpr = "NPR 150.00 - 300.00 per strip of 4 capsules (60,000 IU each)",
            priceInr = "INR 90.00 - 210.00 per strip of 4 capsules",
            brandsNepal = listOf(
                BrandInfo("D-Rise 60K", "USV Limited / Nepal", "Cap", "60,000 IU"),
                BrandInfo("Uprise-D3 60K", "Alkem Laboratories", "Cap", "60,000 IU"),
                BrandInfo("Depura 60K", "Sanofi Nepal", "Liquid/Cap", "60,000 IU"),
                BrandInfo("Lupicheck-D3", "Lupin Limited", "Cap", "60,000 IU")
            ),
            brandsIndia = listOf(
                BrandInfo("D-Rise 60K", "USV", "Cap", "60,000 IU"),
                BrandInfo("Uprise-D3 60K", "Alkem", "Cap/Sachet", "60,000 IU")
            ),
            adultDose = "60,000 IU PO once weekly with milk x 8 weeks, then monthly.",
            childDose = "Children with deficiency: 3,000 to 6,000 IU daily or 60,000 IU every 2-4 weeks under pediatric supervision.",
            contraindications = "Hypervitaminosis D, hypercalcemia, hyperphosphatemia, calcium nephrolithiasis, malabsorption syndrome with active granulomatous disease (sarcoidosis, active TB).",
            modeOfAction = "Acts through the nuclear Vitamin D Receptor (VDR) in enterocytes to upregulate calbindin-D9k, facilitating active transcellular calcium and phosphate absorption from the gastrointestinal tract and suppressing parathyroid hormone (PTH) secretion.",
            therapeuticClassTag = "Vitamins & Nutritional Supplements"
        ),

        // =========================================================================
        // 8. TOPICAL & DERMATOLOGICAL
        // =========================================================================
        Drug(
            id = "d_com_permethrin",
            genericName = "Permethrin 5% w/w Cream / Lotion",
            system = "Dermatological & Skin Disorders",
            drugClass = "Synthetic Pyrethroid Neurotoxic Scabicide & Pediculicide",
            blackBoxWarning = null,
            indications = "First-line eradication of Sarcoptes scabiei (scabies infestation) in adults and children, treatment of cutaneous crusted (Norwegian) scabies (combined with oral ivermectin).",
            doses = "Adults & Children >= 2 months: Apply thoroughly from neck to toes (including finger/toe webs, under nails, waistline, and groin). Leave on for 8 to 14 hours (typically overnight), then wash off thoroughly in shower. Repeat application in 7 days to eradicate newly hatched nymphs.",
            administration = "Apply to clean, dry, cool skin. Re-apply to hands if washed with soap during the 8-14 hour contact period. Treat all household and intimate contacts simultaneously.",
            timing = "Single overnight application (8-14 hours), repeated once 7 days later.",
            specialInstructions = "Pruritus may persist for 2-4 weeks post-treatment due to allergic response to dead mite antigens (post-scabetic itch); does not indicate treatment failure unless new burrows appear.",
            pkPd = "Minimal transdermal absorption (<2%). Rapidly metabolized by skin esterases to inactive metabolites and excreted in urine.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (First-line preferred scabicide in pregnancy due to negligible systemic absorption).",
            lactation = "Safe; wash cream thoroughly from nipples before breastfeeding.",
            sideEffects = "Transient burning, stinging, erythema, mild numbness, temporary exacerbation of pruritus.",
            priceNpr = "NPR 110.00 - 220.00 per 30 g tube (5% w/w)",
            priceInr = "INR 70.00 - 150.00 per 30 g tube",
            brandsNepal = listOf(
                BrandInfo("Scaboma Cream 5%", "Glenmark Pharmaceuticals Nepal", "Cream", "5% w/w (30 g)"),
                BrandInfo("Permite 5% Cream", "Galderma / Medisales", "Cream", "5% w/w (30 g)"),
                BrandInfo("Scabper 5% Lotion", "Torrent Pharmaceuticals", "Lotion", "5% w/v (50 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Scaboma", "Glenmark", "Cream/Lotion", "5% w/w"),
                BrandInfo("Permite", "Galderma", "Cream", "5% w/w")
            ),
            adultDose = "Apply neck to toes, leave 8-14h, wash off; repeat in 7 days.",
            childDose = "Infants >= 2 months & elderly: Include scalp, face, neck, and ears (avoid eyes and mouth).",
            contraindications = "Known hypersensitivity to permethrin, synthetic pyrethroids, or chrysanthemums; infants < 2 months of age.",
            modeOfAction = "Disrupts voltage-gated sodium channel repolarization in parasite nerve cell membranes, delaying channel inactivation, inducing continuous nerve impulses, paralysis, and death of Sarcoptes scabiei mites and their ova.",
            therapeuticClassTag = "Dermatological Anti-parasitics"
        ),

        Drug(
            id = "d_com_mupirocin",
            genericName = "Mupirocin 2% w/w Ointment",
            system = "Dermatological & Skin Disorders",
            drugClass = "Pseudomonic Acid Class Topical Antibiotic",
            blackBoxWarning = null,
            indications = "Impetigo (contagiosa and bullous) caused by Staphylococcus aureus and Streptococcus pyogenes, folliculitis, furunculosis, minor traumatic infected skin lacerations, eradication of nasal MRSA colonization.",
            doses = "Apply a small amount (thin film) to the affected skin area 3 times daily for 5 to 10 days. The treated area may be covered with a sterile gauze dressing if desired.",
            administration = "Wash and dry affected skin before application. Re-evaluate if no clinical improvement within 3 to 5 days.",
            timing = "Three times daily for 5-10 days.",
            specialInstructions = "Ointment contains polyethylene glycol vehicle; avoid application over extensive open burns or deep decubitus ulcers in patients with renal impairment to prevent polyethylene glycol absorption.",
            pkPd = "Negligible systemic absorption through intact skin (<1%). Highly bound to plasma protein (>97%) if absorbed, and rapidly metabolized to inactive monic acid.",
            renalAdj = "Use with caution over extensive denuded body surfaces in moderate-to-severe renal failure.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (No evidence of fetal harm; safe for localized skin infections in pregnancy).",
            lactation = "Safe; thoroughly cleanse nipple area before breastfeeding if applied to breast.",
            sideEffects = "Local burning, stinging, itching, erythema, localized contact dermatitis, dryness.",
            priceNpr = "NPR 120.00 - 240.00 per 5 g / 10 g tube (2% w/w)",
            priceInr = "INR 80.00 - 160.00 per 5 g tube",
            brandsNepal = listOf(
                BrandInfo("T-Bact 2% Ointment", "GSK Nepal", "Oint", "2% w/w (5 g)"),
                BrandInfo("Bactroban 2%", "GSK Nepal", "Oint", "2% w/w (5 g)"),
                BrandInfo("Mupirox 2%", "Torrent Pharmaceuticals", "Oint", "2% w/w (5 g)")
            ),
            brandsIndia = listOf(
                BrandInfo("T-Bact", "GSK", "Oint", "2% w/w"),
                BrandInfo("Bactroban", "GSK", "Oint", "2% w/w")
            ),
            adultDose = "Apply thin layer to affected lesion TID x 5-10 days.",
            childDose = "Children >= 2 months: Apply thin layer TID x 5-10 days.",
            contraindications = "Known hypersensitivity to mupirocin or polyethylene glycol formulation vehicles; ophthalmic or intra-canalicular use.",
            modeOfAction = "Reversibly and specifically binds to bacterial isoleucyl-transfer-RNA (tRNA) synthetase, inhibiting bacterial protein and RNA synthesis. Exhibits no cross-resistance with beta-lactams, macrolides, aminoglycosides, or quinolones.",
            therapeuticClassTag = "Topical Antibiotics"
        )
    )
}
