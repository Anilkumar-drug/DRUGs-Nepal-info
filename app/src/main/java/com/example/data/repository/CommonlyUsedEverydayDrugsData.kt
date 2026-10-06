package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object CommonlyUsedEverydayDrugsData {

    val everydayDrugs: List<Drug> = listOf(
        Drug(
            id = "d_everyday_dicyclomine",
            genericName = "Dicyclomine Hydrochloride (Dicycloverine)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Antispasmodic & Anticholinergic Agent",
            blackBoxWarning = null,
            indications = "Functional bowel disorders, Irritable Bowel Syndrome (IBS), acute intestinal colic, biliary colic, dysmenorrhea.",
            doses = "Adults: 10-20 mg PO TID or QID (max 80 mg/day). Severe colic: 20 mg IM.\nChildren >6 months: 5-10 mg PO TID.",
            administration = "Take 30-60 minutes before meals.",
            timing = "Before meals and at bedtime.",
            specialInstructions = "Contraindicated in infants <6 months due to risk of respiratory collapse and seizures.",
            pkPd = "Oral bioavailability ~60%. Elimination half-life ~9-10 hours. Excreted via urine (80%) and feces.",
            renalAdj = "Use with caution in renal impairment.",
            hepaticAdj = "Use with caution in hepatic dysfunction.",
            pregnancy = "Category B (Safe when indicated)",
            lactation = "Contraindicated; passes into breast milk and may cause infant apnea.",
            sideEffects = "Dry mouth, blurred vision, dizziness, urinary retention, tachycardia, constipation.",
            priceNpr = "NPR 40.00 - 80.00 per strip of 10",
            priceInr = "INR 25.00 - 50.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Cyclopam", "Indoco / Nepal Dist.", "Tab / Inj", "20 mg"),
                BrandInfo("Spasmonil", "Ami Lifesciences", "Tab", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cyclopam", "Indoco Remedies", "Tab", "20 mg"),
                BrandInfo("Meftal-Spas", "Blue Cross", "Tab", "Dicyclomine 10mg + Mefenamic 250mg")
            ),
            adultDose = "10-20 mg PO TID 30 min before meals.",
            childDose = "Children >= 2 yr: 10 mg PO TID.",
            contraindications = "Obstructive uropathy, narrow-angle glaucoma, myasthenia gravis, paralytic ileus, infants <6 months.",
            modeOfAction = "Antagonizes muscarinic M1/M3 receptors on smooth muscle and produces direct non-specific spasmolysis.",
            therapeuticClassTag = "Gastrointestinal Spasmolytics"
        ),

        Drug(
            id = "d_everyday_hyoscine",
            genericName = "Hyoscine Butylbromide (Scopolamine Butylbromide)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Quaternary Ammonium Antimuscarinic Antispasmodic",
            blackBoxWarning = null,
            indications = "Acute renal colic, acute biliary colic, severe intestinal spasms, spasmodic dysmenorrhea, diagnostic endoscopy spasm relief.",
            doses = "Adult: 20 mg (1-2 ampoules) IV slow push or IM; repeat after 30 min if needed (max 100 mg/day). Oral: 10-20 mg TID-QID.",
            administration = "Slow IV bolus over 1-2 minutes or deep IM injection.",
            timing = "At onset of acute colic.",
            specialInstructions = "Quaternary structure prevents crossing blood-brain barrier; minimal central anticholinergic sedative effects.",
            pkPd = "Low oral absorption (~8%). High smooth muscle tissue affinity. Half-life ~5 hours.",
            renalAdj = "No formal dose titration needed; use caution in severe renal disease.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Avoid in 1st trimester unless essential).",
            lactation = "Trace amounts excreted; short-term use considered safe.",
            sideEffects = "Transient tachycardia, dry mouth, accommodation paresis, injection site reaction.",
            priceNpr = "NPR 60.00 - 140.00 per ampoule (20mg/mL)",
            priceInr = "INR 35.00 - 80.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Buscopan", "Sanofi Nepal / Medisales", "Tab / Inj", "10 mg Tab / 20 mg Inj"),
                BrandInfo("Hyocimax", "Zydus Healthcare", "Inj", "20 mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Buscopan", "Sanofi India", "Tab / Inj", "10 mg / 20 mg"),
                BrandInfo("Hyocimax", "Zydus", "Inj", "20 mg/mL")
            ),
            adultDose = "20 mg IV/IM slow injection; oral 10-20 mg TID.",
            childDose = "Children 6-12 yr: 10 mg PO TID.",
            contraindications = "Untreated narrow-angle glaucoma, prostatic hypertrophy with urinary retention, mechanical GI stenosis, tachycardia.",
            modeOfAction = "Competitive antagonist of acetylcholine at parasympathetic muscarinic receptors in gastrointestinal and genitourinary smooth muscle.",
            therapeuticClassTag = "Gastrointestinal Spasmolytics"
        ),

        Drug(
            id = "d_everyday_diclofenac",
            genericName = "Diclofenac Sodium / Potassium",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Non-Steroidal Anti-Inflammatory Drug (NSAID - Phenylacetic Acid Derivative)",
            blackBoxWarning = "CARDIOVASCULAR & GI RISK: Increased risk of serious cardiovascular thrombotic events, myocardial infarction, and stroke. Serious GI adverse events including bleeding, ulceration, and perforation of stomach or intestines.",
            indications = "Acute renal colic, post-operative surgical pain, acute gout flare, osteoarthritis, rheumatoid arthritis, ankylosing spondylitis, severe migraine.",
            doses = "Oral: 50 mg PO BID or TID with meals (max 150 mg/day). Deep IM: 75 mg once or twice daily for max 2 days.",
            administration = "Take with or immediately after food. Deep intragluteal injection for IM route.",
            timing = "With meals; avoid taking on an empty stomach.",
            specialInstructions = "Always co-prescribe a proton pump inhibitor (PPI) in patients aged >= 65 years or with peptic ulcer history.",
            pkPd = "100% absorbed orally; ~50% first-pass hepatic metabolism. >99% albumin bound. Elimination half-life 1.2-2 hours.",
            renalAdj = "Contraindicated in severe renal failure (CrCl <30 mL/min). Monitor eGFR and serum potassium.",
            hepaticAdj = "Use minimum effective dose. Discontinue if transaminases rise >3x ULN.",
            pregnancy = "Category D in 3rd trimester (premature closure of fetal ductus arteriosus, oligohydramnios). Avoid from 20 weeks onwards.",
            lactation = "Excreted in low levels; acceptable for short-term use.",
            sideEffects = "Epigastric pain, GI ulceration/bleeding, acute kidney injury, fluid retention, hypertension, elevated AST/ALT.",
            priceNpr = "NPR 30.00 - 80.00 per strip of 10 (50mg)",
            priceInr = "INR 20.00 - 50.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Voveran", "Novartis / Medisales Nepal", "Tab / Inj", "50 mg / 75 mg Inj"),
                BrandInfo("Diclonac", "Nepal Pharmaceuticals Lab", "Tab / Inj", "50 mg / 75 mg"),
                BrandInfo("Dynapar AQ", "Troikaa / Nepal Dist.", "Inj", "75 mg/mL painless")
            ),
            brandsIndia = listOf(
                BrandInfo("Voveran", "Novartis India", "Tab / SR / Inj", "50 mg / 100 mg / 75 mg"),
                BrandInfo("Dynapar AQ", "Troikaa", "Inj", "75 mg/1mL"),
                BrandInfo("Volini", "Sun Pharma", "Gel", "1% w/w")
            ),
            adultDose = "50 mg PO TID or 75 mg deep IM OD-BID.",
            childDose = "Not recommended in children <12 years.",
            contraindications = "Active peptic ulcer or GI bleeding, severe heart failure (NYHA II-IV), ischemic heart disease, severe renal failure, 3rd trimester pregnancy.",
            modeOfAction = "Inhibits cyclooxygenase enzymes COX-1 and COX-2 with preferential COX-2 inhibition, suppressing prostaglandin and thromboxane synthesis.",
            therapeuticClassTag = "NSAIDs / Analgesics"
        ),

        Drug(
            id = "d_everyday_ibuprofen",
            genericName = "Ibuprofen",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Propionic Acid Derivative NSAID",
            blackBoxWarning = "CARDIOVASCULAR & GI RISK: Increased risk of serious cardiovascular thrombotic events and GI ulceration/bleeding.",
            indications = "Mild-to-moderate pain, headache, dental pain, dysmenorrhea, fever reduction, juvenile idiopathic arthritis, patent ductus arteriosus (IV).",
            doses = "Adult: 200-400 mg PO q4-6h prn with food (max 1200 mg OTC, max 2400 mg prescription).\nPediatric: 5-10 mg/kg PO q6-8h (max 40 mg/kg/day).",
            administration = "Take with food, milk, or a full glass of water to reduce GI irritation.",
            timing = "With or immediately after meals.",
            specialInstructions = "Pediatric dosing must be calculated strictly by weight, not age.",
            pkPd = "Rapid absorption; peak plasma concentration within 1-2 hours. Protein binding >99%. Hepatic metabolism via CYP2C9. Half-life ~2 hours.",
            renalAdj = "Avoid in severe renal impairment (CrCl <30 mL/min). Inhibits renal prostaglandins causing acute kidney injury.",
            hepaticAdj = "Use with caution; monitor LFTs in long-term therapy.",
            pregnancy = "Category C (1st/2nd trimester); Category D in 3rd trimester (contraindicated due to premature ductus arteriosus closure).",
            lactation = "Considered the NSAID of choice during breastfeeding due to minimal breast milk transfer.",
            sideEffects = "Dyspepsia, heartburn, nausea, gastric erosions, elevated blood pressure, peripheral edema, reversible platelet inhibition.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 10 (400mg)",
            priceInr = "INR 10.00 - 25.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Brufen", "Abbott Nepal", "Tab / Susp", "200 mg / 400 mg / 100mg/5mL"),
                BrandInfo("Ibugesic", "Cipla Nepal", "Tab / Susp", "400 mg / 100mg/5mL"),
                BrandInfo("Combiflam", "Sanofi Nepal", "Tab", "Ibuprofen 400mg + Paracetamol 325mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Brufen", "Abbott India", "Tab", "200 / 400 / 600 mg"),
                BrandInfo("Combiflam", "Sanofi India", "Tab", "Ibuprofen 400mg + Paracetamol 325mg"),
                BrandInfo("Ibugesic Plus", "Cipla", "Suspension", "Ibuprofen 100mg + Paracetamol 162.5mg/5mL")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "PO q6-8h prn (max 40 mg/kg/day)",
            adultDose = "400 mg PO TID-QID with food.",
            childDose = "5-10 mg/kg PO q6-8h prn.",
            contraindications = "Aspirin-exacerbated respiratory disease (AERD), active gastrointestinal ulcer/bleeding, severe heart failure, 3rd trimester pregnancy.",
            modeOfAction = "Reversible, non-selective competitive inhibition of cyclooxygenase-1 (COX-1) and cyclooxygenase-2 (COX-2) enzymes.",
            therapeuticClassTag = "NSAIDs / Analgesics"
        ),

        Drug(
            id = "d_everyday_naproxen",
            genericName = "Naproxen Sodium",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Propionic Acid NSAID (Long-Acting)",
            blackBoxWarning = "CARDIOVASCULAR & GI RISK: Increased risk of cardiovascular thrombotic events and gastrointestinal ulceration/bleeding.",
            indications = "Acute migraine attack, acute gout flare, ankylosing spondylitis, primary dysmenorrhea, bursitis, tendonitis, osteoarthritis.",
            doses = "Acute Migraine / Dysmenorrhea: 500-550 mg PO stat, then 250-275 mg q6-8h prn (max 1375 mg on day 1, then 1100 mg/day).\nAcute Gout: 750-825 mg PO stat, then 250-275 mg q8h until attack resolves.",
            administration = "Take orally with a full glass of water with food or antacid.",
            timing = "Twice daily with meals.",
            specialInstructions = "Considered to have the lowest cardiovascular thrombotic risk among non-selective NSAIDs due to sustained platelet COX-1 inhibition.",
            pkPd = "Rapid and complete absorption. >99% bound to serum albumin. Half-life 12-17 hours, allowing convenient twice-daily dosing.",
            renalAdj = "Contraindicated in severe renal impairment (CrCl <30 mL/min).",
            hepaticAdj = "Use lower starting dose in severe hepatic impairment.",
            pregnancy = "Contraindicated in 3rd trimester (Category D); avoid from 20 weeks gestational age.",
            lactation = "Excreted in small amounts in breast milk; compatible with breastfeeding for short courses.",
            sideEffects = "Dyspepsia, heartburn, abdominal cramps, headache, dizziness, tinnitus, edema, occult GI blood loss.",
            priceNpr = "NPR 45.00 - 90.00 per strip of 10 (500mg)",
            priceInr = "INR 30.00 - 65.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Naprosyn", "RPG Life Sciences / Nepal", "Tab", "250 mg / 500 mg"),
                BrandInfo("Xenobid", "Intas Pharmaceuticals", "Tab", "275 mg / 550 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Naprosyn", "RPG Life Sciences", "Tab", "250 / 500 mg"),
                BrandInfo("Xenobid", "Intas", "Tab", "550 mg")
            ),
            adultDose = "500 mg PO BID with meals.",
            childDose = "Juvenile arthritis >= 5 yr: 10 mg/kg/day divided BID.",
            contraindications = "Active GI bleeding/ulcer, severe heart failure, CABG peri-operative pain, severe renal failure.",
            modeOfAction = "Reversible inhibition of COX-1 and COX-2 enzymes, suppressing synthesis of inflammatory prostaglandins and prostacyclin.",
            therapeuticClassTag = "NSAIDs / Analgesics"
        ),

        Drug(
            id = "d_everyday_tramadol",
            genericName = "Tramadol Hydrochloride",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Centrally Acting Synthetic Opioid & SNRI Analgesic",
            blackBoxWarning = "ADDICTION, ABUSE, RESPIRATORY DEPRESSION & SEIZURES: Risk of addiction, abuse, and misuse. Serious, life-threatening respiratory depression. Concomitant use with benzodiazepines or CNS depressants may result in profound sedation, coma, and death. Lowers seizure threshold.",
            indications = "Moderate to moderately severe acute and chronic pain, post-operative analgesia, cancer pain, trauma pain.",
            doses = "Adult: 50-100 mg PO q4-6h prn (max 400 mg/day). IV/IM: 50-100 mg slow infusion over 10 min q6-8h.",
            administration = "Take with or without food. Give IV injection slowly over 2-3 minutes or dilute in 100 mL NS over 15-20 min to avoid nausea/vomiting.",
            timing = "Every 6 to 8 hours as needed.",
            specialInstructions = "Always co-prescribe an antiemetic (e.g. Ondansetron) when initiating IV therapy. High risk of serotonin syndrome when combined with SSRIs, SNRIs, or triptans.",
            pkPd = "Hepatic O-demethylation via CYP2D6 to active metabolite M1 (o-desmethyltramadol) which has 300x higher affinity for mu-opioid receptors. Half-life ~6 hours (M1 ~7.4 hours).",
            renalAdj = "CrCl <30 mL/min: 50-100 mg q12h (max 200 mg/day). Hemodialysis: No dose adjustment needed on dialysis days.",
            hepaticAdj = "Severe cirrhosis: 50 mg PO/IV q12h (max 100 mg/day).",
            pregnancy = "Category C (Avoid prolonged use in pregnancy; neonatal opioid withdrawal syndrome).",
            lactation = "FDA black box warning against breastfeeding due to risk of serious infant opioid toxicity and apnea in ultra-rapid CYP2D6 metabolizers.",
            sideEffects = "Nausea, vomiting, dizziness, constipation, sedation, diaphoresis, headache, dry mouth, seizures, serotonin syndrome.",
            priceNpr = "NPR 50.00 - 110.00 per strip of 10 / NPR 35.00 per ampoule",
            priceInr = "INR 30.00 - 75.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Tramazac", "Zydus Nepal", "Cap / Inj", "50 mg / 100 mg Inj"),
                BrandInfo("Supridol", "Neon Laboratories", "Inj", "100 mg/2mL"),
                BrandInfo("Ultracet", "Janssen / Johnson & Johnson", "Tab", "Tramadol 37.5mg + Paracetamol 325mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tramazac", "Zydus", "Cap / Inj", "50 mg / 100 mg"),
                BrandInfo("Ultracet", "Johnson & Johnson", "Tab", "Tramadol 37.5mg + Paracetamol 325mg")
            ),
            adultDose = "50-100 mg PO/IV q6-8h prn (max 400 mg/day).",
            childDose = "Contraindicated in children <12 years.",
            contraindications = "Acute intoxication with alcohol, hypnotics, or psychotropic drugs; patients taking MAO inhibitors within 14 days; uncontrolled epilepsy.",
            modeOfAction = "Dual mechanism: Weak mu-opioid receptor agonist combined with inhibition of neuronal reuptake of norepinephrine and serotonin.",
            therapeuticClassTag = "Opioids / Central Analgesics"
        ),

        Drug(
            id = "d_everyday_metoclopramide",
            genericName = "Metoclopramide Hydrochloride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Dopamine D2 Receptor Antagonist & Upper GI Prokinetic",
            blackBoxWarning = "TARDIVE DYSKINESIA: Can cause tardive dyskinesia, a serious, often irreversible movement disorder. Risk increases with duration of treatment and total cumulative dose. Avoid treatment for longer than 12 weeks.",
            indications = "Diabetic gastroparesis, GERD, prophylaxis and treatment of post-operative and chemotherapy-induced nausea/vomiting, facilitation of small bowel intubation and gastric emptying.",
            doses = "Adult: 10 mg PO/IV/IM TID to QID 30 minutes before meals and at bedtime (max 40 mg/day for max 5 days IV/oral).",
            administration = "Administer slow IV push over 1-2 minutes or IM. Give oral doses 30 minutes before meals.",
            timing = "30 minutes before each meal and at bedtime.",
            specialInstructions = "Rapid IV injection causes intense anxiety, restlessness, and akathisia. Treat acute dystonic reactions immediately with IV Promethazine or Diphenhydramine.",
            pkPd = "Bioavailability ~80%. Crosses blood-brain barrier and placenta. Elimination half-life 4-6 hours.",
            renalAdj = "CrCl 15-60 mL/min: 50% of normal dose. CrCl <15 mL/min: 25-50% of normal dose.",
            hepaticAdj = "Severe hepatic impairment: Reduce dose by 50%.",
            pregnancy = "Category B (Safe; frequently used for hyperemesis gravidarum when first-line fails).",
            lactation = "Excreted in breast milk; stimulates prolactin secretion (galactagogue). Short-term use considered safe.",
            sideEffects = "Extrapyramidal symptoms (acute dystonia, oculogyric crisis, torticollis), akathisia, drowsiness, hyperprolactinemia (galactorrhea, gynecomastia), diarrhea.",
            priceNpr = "NPR 15.00 - 30.00 per strip of 10 / NPR 12.00 per ampoule",
            priceInr = "INR 8.00 - 20.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Perinorm", "IPCA Laboratories Nepal", "Tab / Inj / Syr", "10 mg / 10 mg/2mL / 5mg/5mL"),
                BrandInfo("Reglan", "Sanofi Nepal", "Tab", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Perinorm", "IPCA", "Tab / Inj / Syr", "10 mg / 10 mg/2mL"),
                BrandInfo("Reglan", "Sanofi", "Tab", "10 mg")
            ),
            adultDose = "10 mg PO/IV TID 30 min before meals.",
            childDose = "0.1-0.15 mg/kg/dose PO/IV TID (max 0.5 mg/kg/day).",
            contraindications = "Mechanical gastrointestinal obstruction, perforation, or active hemorrhage; pheochromocytoma; epilepsy; patients receiving drugs causing extrapyramidal symptoms.",
            modeOfAction = "Antagonizes central dopamine D2 receptors in the chemoreceptor trigger zone (CTZ) and peripheral 5-HT4 agonist / D2 antagonist stimulating upper GI motility.",
            therapeuticClassTag = "Prokinetics & Antiemetics"
        ),

        Drug(
            id = "d_everyday_losartan",
            genericName = "Losartan Potassium",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin II Receptor Blocker (ARB)",
            blackBoxWarning = "FETOTOXICITY: Discontinue Losartan immediately upon pregnancy detection. Drugs acting on the renin-angiotensin system can cause serious oligohydramnios, neonatal renal hypoplasia, and death.",
            indications = "Essential Hypertension, Diabetic Nephropathy in Type 2 Diabetes with proteinuria, stroke risk reduction in hypertensive patients with left ventricular hypertrophy (LVH), hyperuricemic hypertension.",
            doses = "Adult: 50 mg PO once daily (range 25-100 mg/day OD or divided BID). Starting dose in volume-depleted or elderly patients: 25 mg OD.",
            administration = "Take orally once daily with or without food at the same time each day.",
            timing = "Morning or evening.",
            specialInstructions = "Possesses a unique uricosuric effect by inhibiting renal URAT1 transporter; highly suitable for hypertensive patients with gout or hyperuricemia.",
            pkPd = "Bioavailability ~33%. Metabolized by CYP2C9 and CYP3A4 to active carboxylic acid metabolite (E-3174) which is 10-40x more potent than parent drug. Half-life: Losartan ~2h, E-3174 ~6-9h.",
            renalAdj = "No initial dosage adjustment necessary. Monitor serum creatinine and potassium closely.",
            hepaticAdj = "Hepatic impairment or cirrhosis: Start with 25 mg PO once daily.",
            pregnancy = "Category D (Contraindicated in 2nd and 3rd trimesters).",
            lactation = "Excreted in animal milk; not recommended during breastfeeding.",
            sideEffects = "Hyperkalemia, dizziness, orthostatic hypotension, fatigue, dry cough (much rarer than ACE inhibitors), upper respiratory infection.",
            priceNpr = "NPR 60.00 - 130.00 per strip of 10 (50mg)",
            priceInr = "INR 40.00 - 85.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Losar", "Unichem / Nepal Dist.", "Tab", "25 mg / 50 mg"),
                BrandInfo("Zaart", "Torrent Pharmaceuticals", "Tab", "25 mg / 50 mg"),
                BrandInfo("Losacar", "Zydus Nepal", "Tab", "25 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Losar", "Unichem Laboratories", "Tab", "25 / 50 mg"),
                BrandInfo("Zaart", "Torrent", "Tab", "50 mg"),
                BrandInfo("Losar-H", "Unichem", "Tab", "Losartan 50mg + HCTZ 12.5mg")
            ),
            adultDose = "50 mg PO once daily (max 100 mg/day).",
            childDose = "Children >= 6 yr: 0.7 mg/kg PO once daily (max 50 mg/day).",
            contraindications = "Concomitant use with aliskiren in patients with diabetes mellitus; severe hepatic impairment; pregnancy.",
            modeOfAction = "Selectively and competitively blocks the angiotensin II type 1 (AT1) receptor, inhibiting angiotensin II-induced vasoconstriction, aldosterone secretion, and sodium retention.",
            therapeuticClassTag = "Anti-HTN"
        ),

        Drug(
            id = "d_everyday_enalapril",
            genericName = "Enalapril Maleate",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin Converting Enzyme (ACE) Inhibitor",
            blackBoxWarning = "FETOTOXICITY: Discontinue immediately upon pregnancy detection. Renin-angiotensin system inhibition causes fetal injury and mortality during 2nd and 3rd trimesters.",
            indications = "Essential and renovascular hypertension, Heart Failure with reduced Ejection Fraction (HFrEF - NYHA II-IV), asymptomatic left ventricular dysfunction (EF <= 35%), diabetic nephropathy.",
            doses = "Hypertension: 5 mg PO OD starting dose; maintenance 10-40 mg/day OD or divided BID.\nHeart Failure: 2.5 mg PO BID starting dose; titrate up to target 10-20 mg PO BID.",
            administration = "Take orally once or twice daily with or without food.",
            timing = "Consistent time daily.",
            specialInstructions = "Check baseline renal function (serum creatinine) and potassium. Re-check at 1-2 weeks. Acceptable creatinine rise up to 30% from baseline.",
            pkPd = "Prodrug; de-esterified in liver to active metabolite Enalaprilat. Peak enalaprilat levels at 3-4 hours. Enalaprilat half-life ~11 hours; excreted primarily via kidneys.",
            renalAdj = "CrCl 30-80 mL/min: Start with 2.5-5 mg/day. CrCl <30 mL/min: Start with 2.5 mg/day (max 40 mg/day). Hemodialysis: 2.5 mg on dialysis days.",
            hepaticAdj = "Prodrug activation may be delayed in severe hepatic impairment, but no dose reduction usually required.",
            pregnancy = "Category D (Strictly contraindicated in pregnancy).",
            lactation = "Present in breast milk in low concentrations; compatible with breastfeeding in full-term infants.",
            sideEffects = "Dry persistent hacking cough (5-20% due to bradykinin/substance P accumulation), hyperkalemia, acute kidney injury, dizziness, angioedema (life-threatening, 0.1-0.5%).",
            priceNpr = "NPR 35.00 - 75.00 per strip of 10 (5mg)",
            priceInr = "INR 20.00 - 50.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Envas", "Cadila Pharmaceuticals Nepal", "Tab", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Nuril", "USV / Nepal Dist.", "Tab", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Envas", "Cadila", "Tab", "2.5 / 5 / 10 mg"),
                BrandInfo("Vasotec", "Merck", "Tab", "5 mg")
            ),
            adultDose = "5-20 mg PO once daily (or divided BID in HF).",
            childDose = "Children >= 1 month: 0.08 mg/kg PO once daily (max 5 mg/day).",
            contraindications = "History of ACE inhibitor-induced or hereditary angioedema, bilateral renal artery stenosis, concomitant sacubitril/valsartan within 36 hours.",
            modeOfAction = "Inhibits angiotensin converting enzyme (ACE), preventing conversion of angiotensin I to the potent vasoconstrictor angiotensin II and decreasing bradykinin breakdown.",
            therapeuticClassTag = "Anti-HTN"
        ),

        Drug(
            id = "d_everyday_metoprolol",
            genericName = "Metoprolol Succinate / Tartrate",
            system = "Cardiovascular System (CVS)",
            drugClass = "Cardioselective Beta-1 Adrenergic Receptor Blocker",
            blackBoxWarning = "ISCHEMIC HEART DISEASE & ABRUPT CESSATION: Do not discontinue abruptly in patients with coronary artery disease. Severe exacerbation of angina, myocardial infarction, and ventricular arrhythmias may occur.",
            indications = "Hypertension, Angina Pectoris, Heart Failure with reduced Ejection Fraction (HFrEF - NYHA II-IV, Succinate ER only), rate control in Atrial Fibrillation, post-Myocardial Infarction secondary prevention, migraine prophylaxis.",
            doses = "Hypertension / Angina: Tartrate 50-100 mg PO BID; Succinate ER 25-100 mg PO once daily.\nHeart Failure (Succinate ER only): Start 12.5-25 mg PO OD; double dose every 2 weeks to target 200 mg OD.",
            administration = "Metoprolol Tartrate: Take with or immediately after meals. Metoprolol Succinate ER: Take once daily in morning with or without food; swallow whole or split along score line without chewing/crushing.",
            timing = "Consistent morning timing.",
            specialInstructions = "Metoprolol Tartrate is immediate-release (BID); Metoprolol Succinate is extended-release (OD). Only Metoprolol Succinate ER is FDA-approved for heart failure mortality reduction (MERIT-HF trial).",
            pkPd = "Oral bioavailability 50% (increases with food). Extensively metabolized by CYP2D6. Tartrate half-life 3-4 hours; Succinate provides smooth 24-hour plasma concentration.",
            renalAdj = "No dosage adjustment necessary in renal impairment or hemodialysis.",
            hepaticAdj = "Extensively metabolized by liver; initiate with lowest recommended dose in severe cirrhosis.",
            pregnancy = "Category C (Can cause fetal growth restriction, neonatal bradycardia and hypoglycemia).",
            lactation = "Excreted in breast milk; monitor infant for bradycardia and poor feeding.",
            sideEffects = "Bradycardia, hypotension, fatigue, dizziness, cold extremities, bronchospasm in asthmatics, erectile dysfunction, depression, masking of hypoglycemic symptoms.",
            priceNpr = "NPR 45.00 - 110.00 per strip of 10 (25mg / 50mg ER)",
            priceInr = "INR 30.00 - 75.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Betaloc", "AstraZeneca / Nepal Dist.", "Tab", "25 mg / 50 mg"),
                BrandInfo("Metolar XR", "Cipla Nepal", "Cap / Tab", "25 mg / 50 mg"),
                BrandInfo("Prolomet XL", "Sun Pharma Nepal", "Tab", "25 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Betaloc", "AstraZeneca India", "Tab", "25 / 50 mg"),
                BrandInfo("Metolar", "Cipla", "Tab", "25 / 50 mg"),
                BrandInfo("Prolomet XL", "Sun Pharma", "Tab", "25 / 50 mg")
            ),
            adultDose = "Succinate ER: 25-100 mg PO once daily. Tartrate: 50-100 mg PO BID.",
            childDose = "Children >= 6 yr: 1 mg/kg PO once daily (max 50 mg/day).",
            contraindications = "Severe bradycardia (<45 bpm), 2nd or 3rd degree AV block, cardiogenic shock, decompensated acute heart failure, severe peripheral arterial disease, severe asthma.",
            modeOfAction = "Competitively and selectively antagonizes beta-1 adrenergic receptors in cardiac tissue, decreasing heart rate, cardiac output, myocardial oxygen demand, and renin release.",
            therapeuticClassTag = "Anti-HTN"
        ),

        Drug(
            id = "d_everyday_prednisolone",
            genericName = "Prednisolone",
            system = "Endocrine & Metabolic System",
            drugClass = "Intermediate-Acting Synthetic Glucocorticoid",
            blackBoxWarning = null,
            indications = "Acute asthma exacerbation, severe allergic reactions, autoimmune diseases (Systemic Lupus Erythematosus, Rheumatoid Arthritis), Nephrotic Syndrome, Bell's palsy, inflammatory bowel disease, idiopathic thrombocytopenic purpura (ITP).",
            doses = "Adult: 5 to 60 mg PO once daily in morning. Acute asthma burst: 40-50 mg PO OD for 5 days without taper.\nPediatric (Asthma flare): 1-2 mg/kg/day PO (max 40-60 mg/day) for 3-5 days.",
            administration = "Take with or immediately after breakfast with milk or food to minimize gastric irritation.",
            timing = "Morning dose (07:00 - 08:00 AM) to mimic natural physiological circadian peak of endogenous cortisol.",
            specialInstructions = "Courses longer than 2-3 weeks must be tapered gradually to prevent acute adrenal crisis from hypothalamic-pituitary-adrenal (HPA) axis suppression.",
            pkPd = "Rapid and near-complete oral absorption (80-90%). Active glucocorticoid (unlike prednisone which requires hepatic conversion). Protein bound to transcortin and albumin. Biologic half-life 18-36 hours.",
            renalAdj = "No dosage adjustment necessary.",
            hepaticAdj = "Preferred over prednisone in hepatic impairment because prednisolone is the biologically active metabolite.",
            pregnancy = "Category C (Extensively metabolized by placental 11-beta-HSD2 to inactive form; preferred steroid for maternal treatment).",
            lactation = "Excreted in low levels in breast milk; wait 3-4 hours after dose before nursing to minimize infant exposure.",
            sideEffects = "Insomnia, euphoria, mood changes, increased appetite, weight gain, hyperglycemia, fluid retention, hypertension, gastric ulcer, cushingoid facies, osteoporosis, osteonecrosis of femoral head.",
            priceNpr = "NPR 15.00 - 45.00 per strip of 10 (5mg / 10mg / 20mg)",
            priceInr = "INR 10.00 - 30.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Omnacortil", "Macleods Nepal", "Tab / Syr", "5 mg / 10 mg / 20 mg / 40 mg"),
                BrandInfo("Wysolone", "Pfizer Nepal", "Tab", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Predone", "Cipla Nepal", "Syr", "5 mg/5mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Omnacortil", "Macleods", "Tab / Syr", "5 / 10 / 20 / 40 mg"),
                BrandInfo("Wysolone", "Pfizer", "Tab", "5 / 10 / 20 mg")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "mg/kg/day PO in morning x 3-5 days",
            adultDose = "20-60 mg PO once daily in morning.",
            childDose = "1-2 mg/kg/day PO in morning divided or single dose.",
            contraindications = "Systemic untreated fungal infections; live or live-attenuated vaccines during immunosuppressive therapy.",
            modeOfAction = "Binds to intracellular glucocorticoid receptors, modulating gene transcription to suppress pro-inflammatory cytokines (IL-1, IL-2, TNF-alpha) and phospholipase A2.",
            therapeuticClassTag = "Immuno-suppressor"
        ),

        Drug(
            id = "d_everyday_carbimazole",
            genericName = "Carbimazole",
            system = "Endocrine & Metabolic System",
            drugClass = "Thionamide Antithyroid Drug (Prodrug of Methimazole)",
            blackBoxWarning = "AGRANULOCYTOSIS & EMBRYOPATHY: Can cause life-threatening agranulocytosis. Instruct patient to report immediately any sore throat, fever, mouth ulcers, or malaise. Causes congenital malformations (aplasia cutis, choanal atresia) if used in 1st trimester of pregnancy.",
            indications = "Hyperthyroidism in Graves' Disease, toxic multinodular goiter, toxic solitary adenoma, preparation for thyroidectomy or radioiodine therapy.",
            doses = "Starting dose: 15-40 mg PO daily in 2-3 divided doses until euthyroid (4-8 weeks). Maintenance: 5-15 mg PO once daily for 12-18 months. Block-and-replace: 40 mg OD co-administered with Levothyroxine 100 mcg OD.",
            administration = "Take orally with or without food. Maintain consistent timing daily.",
            timing = "Morning with breakfast or divided doses.",
            specialInstructions = "Check baseline CBC with differential and LFTs. Routine CBC monitoring does not predict sudden idiosyncratic agranulocytosis; educate patient on fever/sore throat warning signs.",
            pkPd = "Rapidly and completely converted in vivo to active methimazole. Methimazole half-life 4-6 hours; concentrates inside thyroid gland where it acts for >24 hours.",
            renalAdj = "No dosage adjustment necessary in renal failure.",
            hepaticAdj = "Use lower doses and monitor LFTs closely; severe hepatic impairment delays clearance.",
            pregnancy = "Category D. Propylthiouracil (PTU) is preferred in 1st trimester; switch to Carbimazole in 2nd and 3rd trimesters to prevent PTU-induced severe maternal hepatotoxicity.",
            lactation = "Excreted in breast milk in small amounts; safe at doses up to 20 mg daily. Monitor infant thyroid function.",
            sideEffects = "Pruritic maculopapular rash, arthralgias, fever, nausea, agranulocytosis (0.3-0.5%), cholestatic jaundice, acute pancreatitis.",
            priceNpr = "NPR 110.00 - 220.00 per bottle of 100 tablets (5mg)",
            priceInr = "INR 70.00 - 150.00 per bottle of 100",
            brandsNepal = listOf(
                BrandInfo("Neo-Mercazole", "Abbott Nepal", "Tab", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Thyrocab", "Abbott Nepal", "Tab", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Neo-Mercazole", "Abbott India", "Tab", "5 / 10 / 20 mg"),
                BrandInfo("Thyrocab", "Abbott", "Tab", "5 / 10 mg")
            ),
            adultDose = "15-40 mg PO daily divided; maintenance 5-15 mg OD.",
            childDose = "0.75 mg/kg/day PO divided into 2-3 doses.",
            contraindications = "History of serious adverse reactions to thionamides (agranulocytosis, severe hepatotoxicity, acute pancreatitis).",
            modeOfAction = "Inhibits thyroid peroxidase (TPO) enzyme, blocking the iodination of tyrosine residues on thyroglobulin and the coupling of iodotyrosines to form T3 and T4.",
            therapeuticClassTag = "Thyroid disorders"
        ),

        Drug(
            id = "d_everyday_alprazolam",
            genericName = "Alprazolam",
            system = "Central Nervous System (CNS)",
            drugClass = "Short-Acting Triazolobenzodiazepine Anxiolytic",
            blackBoxWarning = "RISKS FROM CONCOMITANT USE WITH OPIOIDS, ABUSE, MISUSE, DEPENDENCE & WITHDRAWAL: Concomitant use with opioids may result in profound sedation, respiratory depression, coma, and death. Physical dependence occurs with prolonged therapy; abrupt cessation can precipitate rebound panic, seizures, and delirium tremens.",
            indications = "Acute panic disorder with or without agoraphobia, severe generalized anxiety disorder (GAD), short-term relief of debilitating situational anxiety.",
            doses = "Anxiety: 0.25 to 0.5 mg PO TID (max 4 mg/day).\nPanic Disorder: 0.5 mg PO TID; titrate slowly by 1 mg/day every 3-4 days (target 3-6 mg/day divided).",
            administration = "Take orally with or without food. Do not chew or crush extended-release formulations.",
            timing = "As prescribed; morning, afternoon, and bedtime.",
            specialInstructions = "Schedule prescription drug (DDA Schedule Ka in Nepal). High risk of tolerance and psychological dependence. Restrict use to shortest duration (<2-4 weeks).",
            pkPd = "Rapid absorption with peak plasma levels in 1-2 hours. Hepatic metabolism via CYP3A4 to alpha-hydroxyalprazolam. Elimination half-life ~11.2 hours.",
            renalAdj = "No formal dose adjustment needed; monitor for excessive sedation.",
            hepaticAdj = "Severe hepatic impairment: Reduce starting dose by 50% (0.25 mg BID-TID).",
            pregnancy = "Category D (Risk of congenital malformations, neonatal flaccidity, respiratory depression, withdrawal symptoms).",
            lactation = "Excreted in breast milk; causes lethargy and weight loss in nursing infants. Avoid during breastfeeding.",
            sideEffects = "Drowsiness, lightheadedness, impaired coordination, memory impairment, retrograde amnesia, ataxia, slurred speech, rebound anxiety.",
            priceNpr = "NPR 25.00 - 60.00 per strip of 10 (0.25mg / 0.5mg)",
            priceInr = "INR 15.00 - 40.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Alprax", "Torrent Pharmaceuticals Nepal", "Tab", "0.25 mg / 0.5 mg"),
                BrandInfo("Restyl", "Cipla Nepal", "Tab", "0.25 mg / 0.5 mg"),
                BrandInfo("Zolax", "Intas Pharmaceuticals", "Tab", "0.25 mg / 0.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Alprax", "Torrent", "Tab", "0.25 / 0.5 / 1 mg"),
                BrandInfo("Restyl", "Cipla", "Tab", "0.25 / 0.5 mg"),
                BrandInfo("Trika", "Unichem", "Tab", "0.25 / 0.5 mg")
            ),
            adultDose = "0.25-0.5 mg PO TID prn (max 4 mg/day).",
            childDose = "Safety and efficacy not established in pediatric patients <18 years.",
            contraindications = "Acute narrow-angle glaucoma, severe respiratory insufficiency, myasthenia gravis, sleep apnea syndrome, co-administration with strong CYP3A4 inhibitors (ketoconazole, itraconazole).",
            modeOfAction = "Enhances the inhibitory effect of gamma-aminobutyric acid (GABA) by allosterically binding to GABAA receptors, increasing chloride ion conductance and hyperpolarizing neuronal membranes.",
            therapeuticClassTag = "Anxiolytics / Sedatives"
        ),

        Drug(
            id = "d_everyday_diazepam",
            genericName = "Diazepam",
            system = "Central Nervous System (CNS)",
            drugClass = "Long-Acting Benzodiazepine Anticonvulsant & Skeletal Muscle Relaxant",
            blackBoxWarning = "CONCOMITANT OPIOID USE, ABUSE, DEPENDENCE & WITHDRAWAL: Concomitant use with opioids causes severe respiratory depression and death. Discontinue only with gradual tapering.",
            indications = "Status epilepticus, acute febrile convulsions, alcohol withdrawal delirium tremens, acute skeletal muscle spasm, pre-operative sedation, severe acute anxiety agitation.",
            doses = "Status Epilepticus: 5-10 mg slow IV (1-2 mL/min); repeat q10-15min prn (max 30 mg). Rectal gel: 0.2-0.5 mg/kg.\nOral Anxiety / Spasm: 2 to 10 mg PO BID to QID.",
            administration = "IV push: Administer slowly directly into large vein (at rate not exceeding 5 mg/min or 1 mL/min). Do not dilute in small volume IV fluids (precipitates in aqueous solutions).",
            timing = "At onset of seizure or divided daily doses.",
            specialInstructions = "Always maintain airway equipment and bag-valve-mask ventilatory support at bedside during IV administration.",
            pkPd = "Rapid absorption orally and IV. Highly lipophilic with rapid brain penetration. Metabolized by CYP2C19 and CYP3A4 to active metabolites (nordiazepam, temazepam, oxazepam). Half-life 20-50 hours (nordiazepam up to 100 hours).",
            renalAdj = "No dose adjustment required; monitor for excessive accumulation of active metabolites.",
            hepaticAdj = "Severe hepatic insufficiency: Reduce dose by 50% or avoid; prolonged clearance precipitating hepatic encephalopathy.",
            pregnancy = "Category D (Contraindicated; neonatal withdrawal and floppy infant syndrome).",
            lactation = "Excreted into breast milk; contraindicated in breastfeeding.",
            sideEffects = "Sedation, respiratory depression, ataxia, muscle weakness, hypotension, confusion, paradoxical excitation in elderly.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 10 / NPR 12.00 per 10mg ampoule",
            priceInr = "INR 10.00 - 25.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Calmpose", "Ranbaxy / Sun Pharma Nepal", "Tab / Inj", "5 mg / 10 mg/2mL"),
                BrandInfo("Valium", "Roche / Medisales Nepal", "Tab / Inj", "5 mg / 10 mg"),
                BrandInfo("Placidox", "Lupin Nepal", "Tab", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Calmpose", "Sun Pharma", "Tab / Inj", "5 mg / 10 mg/2mL"),
                BrandInfo("Valium", "Abbott India", "Tab / Inj", "5 / 10 mg")
            ),
            pediatricDosePerKg = 0.2,
            pediatricInterval = "mg/kg slow IV push over 2 min (max 5 mg in <5 yr, 10 mg in >=5 yr)",
            adultDose = "5-10 mg slow IV push; oral 2-10 mg BID-TID.",
            childDose = "0.2-0.3 mg/kg IV push over 2 min; rectal 0.5 mg/kg.",
            contraindications = "Myasthenia gravis, severe respiratory insufficiency, acute narrow-angle glaucoma, severe hepatic failure, sleep apnea.",
            modeOfAction = "Allosteric modulator of GABAA receptor chloride channels, increasing the frequency of channel opening in response to GABA, producing generalized CNS depression.",
            therapeuticClassTag = "Antiepileptic"
        ),

        Drug(
            id = "d_everyday_tamsulosin",
            genericName = "Tamsulosin Hydrochloride",
            system = "Renal & Genitourinary",
            drugClass = "Uroselective Alpha-1A Adrenergic Receptor Antagonist",
            blackBoxWarning = null,
            indications = "Benign Prostatic Hyperplasia (BPH) lower urinary tract symptoms (LUTS), medical expulsive therapy (MET) for distal ureteral calculi (<= 10 mm).",
            doses = "0.4 mg PO once daily 30 minutes after the same meal each day. May increase to 0.8 mg PO once daily after 2-4 weeks if inadequate response.",
            administration = "Swallow capsule whole with water. Do not crush, chew, or open modified-release capsules.",
            timing = "30 minutes after evening dinner.",
            specialInstructions = "Intraoperative Floppy Iris Syndrome (IFIS) can occur during cataract or glaucoma surgery. Inform ophthalmologist before planned eye surgery.",
            pkPd = "Bioavailability >90% on empty stomach, but administration 30 min after food slows absorption and avoids peak-related orthostasis. Extensively metabolized by CYP3A4 and CYP2D6. Half-life 9-15 hours.",
            renalAdj = "CrCl >= 10 mL/min: No adjustment required. CrCl <10 mL/min: Not studied.",
            hepaticAdj = "Mild-to-moderate impairment: No adjustment needed. Severe impairment: Not recommended.",
            pregnancy = "Category B (Not indicated for females; safe if used off-label for ureteral stones).",
            lactation = "Not indicated for females.",
            sideEffects = "Retrograde ejaculation (anejaculation 8-18%), dizziness, orthostatic hypotension, rhinitis, nasal congestion, asthenia, headache.",
            priceNpr = "NPR 90.00 - 180.00 per strip of 10 (0.4mg)",
            priceInr = "INR 60.00 - 130.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Urimax", "Cipla Nepal", "Cap", "0.4 mg"),
                BrandInfo("Flomaxtra", "Astellas / Nepal Dist.", "PR Tab", "0.4 mg"),
                BrandInfo("Veltam", "Intas Pharmaceuticals", "Cap", "0.4 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Urimax", "Cipla", "Cap", "0.4 mg"),
                BrandInfo("Veltam", "Intas", "Cap", "0.4 mg"),
                BrandInfo("Urimax-D", "Cipla", "Tab", "Tamsulosin 0.4mg + Dutasteride 0.5mg")
            ),
            adultDose = "0.4 mg PO once daily 30 min after dinner.",
            childDose = "Not indicated in children.",
            contraindications = "Known hypersensitivity to tamsulosin or sulfonamides; severe hepatic impairment; co-administration with potent CYP3A4 inhibitors (ketoconazole).",
            modeOfAction = "Selectively blocks alpha-1A adrenoceptors concentrated in the prostate gland, prostatic urethra, and bladder neck, relaxing smooth muscle and reducing urinary outflow resistance.",
            therapeuticClassTag = "Urological Alpha-blockers"
        ),

        Drug(
            id = "d_everyday_doxycycline",
            genericName = "Doxycycline Hyclate / Monohydrate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Broad-Spectrum Tetracycline Antibiotic",
            blackBoxWarning = null,
            indications = "Scrub typhus (Orientia tsutsugamushi - endemic in Nepal), Leptospirosis treatment & prophylaxis, Atypical community-acquired pneumonia (Mycoplasma, Chlamydophila), Cholera, Lyme disease, Chlamydia trachomatis urethritis/cervicitis, severe acne vulgaris, Malaria chemoprophylaxis.",
            doses = "Standard: 100 mg PO BID on day 1, then 100 mg PO once daily (or 100 mg BID for severe infections).\nScrub Typhus: 100 mg PO BID x 7 days.\nLeptospirosis Prophylaxis: 200 mg PO once weekly.",
            administration = "Take with a full glass of water (240 mL) and remain strictly upright (sitting or standing) for at least 30 minutes to prevent pill-induced severe esophageal ulceration.",
            timing = "With meals or glass of water; avoid taking right before bed.",
            specialInstructions = "Avoid concurrent antacids, calcium, iron, or zinc supplements within 2 hours (chelates and blocks absorption). Avoid excessive sun exposure (severe phototoxicity).",
            pkPd = "Excellent oral bioavailability (90-100%), not significantly impaired by food or milk (unlike tetracycline). Highly lipophilic; excellent tissue and intracellular penetration. Half-life 18-22 hours.",
            renalAdj = "No dosage adjustment necessary in renal failure or hemodialysis (excreted via biliary-fecal route as inactive chelate). Safest tetracycline in CKD.",
            hepaticAdj = "Use with caution in severe hepatic impairment.",
            pregnancy = "Category D (Permanent tooth discoloration, enamel hypoplasia, and inhibition of fetal skeletal bone growth after 16 weeks gestation). Use in scrub typhus permitted only if azithromycin unavailable.",
            lactation = "Excreted in breast milk in small amounts; short-term use (<14 days) considered acceptable by AAP as calcium in milk binds drug.",
            sideEffects = "Pill-induced esophagitis/esophageal ulcers, nausea, vomiting, phototoxic dermatitis, Jarisch-Herxheimer reaction in spirochetal/rickettsial infections, benign intracranial hypertension (pseudotumor cerebri).",
            priceNpr = "NPR 30.00 - 65.00 per strip of 10 (100mg)",
            priceInr = "INR 20.00 - 45.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Dox", "Deurali-Janta Pharmaceuticals", "Cap", "100 mg"),
                BrandInfo("Doxy-1", "USV / Nepal Dist.", "Cap", "100 mg"),
                BrandInfo("Microdox", "Micro Labs Nepal", "Cap", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Dox", "DJPL", "Cap", "100 mg"),
                BrandInfo("Doxy-1", "USV", "Cap", "100 mg"),
                BrandInfo("Vibramycin", "Pfizer", "Cap", "100 mg")
            ),
            adultDose = "100 mg PO BID with meals x 7-14 days.",
            childDose = "Children >= 8 yr or severe scrub typhus: 2.2 mg/kg PO BID (max 100 mg BID).",
            contraindications = "Hypersensitivity to tetracyclines; pregnancy 2nd/3rd trimester; children <8 years for non-life-threatening indications.",
            modeOfAction = "Reversibly binds to the 30S ribosomal subunit of susceptible microorganisms, preventing access of aminoacyl-tRNA to the ribosomal acceptor site and halting bacterial protein synthesis.",
            therapeuticClassTag = "Tetracyclines / Antimicrobials"
        ),

        Drug(
            id = "d_everyday_metronidazole",
            genericName = "Metronidazole",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Nitroimidazole Antibacterial & Antiprotozoal Agent",
            blackBoxWarning = "CARCINOGENICITY: Shown to be carcinogenic in mice and rats. Avoid unnecessary use.",
            indications = "Amoebic liver abscess, intestinal amoebiasis (dysentery), Giardiasis, Trichomoniasis, intra-abdominal anaerobic infections (Bacteroides fragilis), Clostridioides difficile colitis, bacterial vaginosis, surgical prophylaxis in colorectal surgery.",
            doses = "Amoebiasis: 400-800 mg PO TID for 7-10 days.\nGiardiasis: 400 mg PO TID or 2g OD for 3 days.\nAnaerobic Infection: 500 mg IV infusion over 30 min q8h.",
            administration = "Take oral tablets with or after food. Infuse IV solution slowly over 30 to 60 minutes.",
            timing = "With meals every 8 hours.",
            specialInstructions = "Strictly avoid alcohol during therapy and for 48 hours after discontinuation (disulfiram-like reaction with flushing, vomiting, tachycardia, diaphoresis).",
            pkPd = "Nearly 100% oral bioavailability. Low protein binding (<20%). Widely distributed across all body fluids and tissues including CSF. Hepatic metabolism via CYP2A6. Half-life ~8 hours.",
            renalAdj = "CrCl <10 mL/min: 50% of normal dose. Hemodialysis removes drug rapidly; administer supplemental dose post-dialysis.",
            hepaticAdj = "Severe hepatic impairment: Reduce daily dose by 50% and monitor for encephalopathy.",
            pregnancy = "Category B (Avoid in 1st trimester for trichomoniasis; safe for amoebic liver abscess and anaerobic sepsis).",
            lactation = "Transfers into breast milk; pump and discard breast milk during therapy and for 24 hours after a single high dose.",
            sideEffects = "Metallic taste, nausea, dark/reddish-brown urine (harmless metabolite), anorexia, peripheral neuropathy (prolonged therapy), disulfiram-like alcohol reaction, furred tongue.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 10 / NPR 25.00 per 100 mL IV bottle",
            priceInr = "INR 10.00 - 25.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Flagyl", "Sanofi Nepal / Medisales", "Tab / Susp / IV", "400 mg / 200mg/5mL / 500mg/100mL"),
                BrandInfo("Metrogyl", "J.B. Chemicals Nepal", "Tab / IV", "400 mg / 500mg/100mL"),
                BrandInfo("Aristogyl", "Nepal Pharmaceuticals Lab", "Tab", "400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Flagyl", "Sanofi India", "Tab", "200 / 400 mg"),
                BrandInfo("Metrogyl", "J.B. Chemicals", "Tab / IV", "400 mg / 500mg/100mL")
            ),
            pediatricDosePerKg = 30.0,
            pediatricInterval = "mg/kg/day divided TID x 7-10 days",
            adultDose = "400-800 mg PO TID or 500 mg IV q8h.",
            childDose = "30-50 mg/kg/day PO/IV divided TID.",
            contraindications = "Hypersensitivity to metronidazole or nitroimidazoles; first trimester of pregnancy in trichomoniasis; alcohol or propylene glycol ingestion within 3 days.",
            modeOfAction = "Selectively reduced in anaerobic microorganisms by ferredoxin to toxic nitro radical intermediates that disrupt helical DNA structure, causing strand breakage and cell death.",
            therapeuticClassTag = "Anti-parasitic / Anaerobic Antimicrobials"
        ),

        Drug(
            id = "d_everyday_ciprofloxacin",
            genericName = "Ciprofloxacin Hydrochloride",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Second-Generation Fluoroquinolone Antibacterial Agent",
            blackBoxWarning = "TENDINITIS, TENDON RUPTURE, PERIPHERAL NEUROPATHY, CNS EFFECTS & AORTIC ANEURYSM: Fluoroquinolones are associated with disabling adverse reactions including Achilles tendinitis and rupture, peripheral neuropathy, seizures, hallucinations, and fatal aortic aneurysm dissection.",
            indications = "Complicated urinary tract infections, acute pyelonephritis, enteric fever (Salmonella typhi), acute infectious diarrhea (Campylobacter, Shigella), Pseudomonas aeruginosa infections, acute bacterial prostatitis, bone and joint infections.",
            doses = "Oral: 500-750 mg PO BID for 7-14 days. IV: 200-400 mg IV infusion over 60 min q12h. Uncomplicated UTI: 250-500 mg PO BID x 3-5 days.",
            administration = "Take oral doses 2 hours before or 6 hours after dairy products, calcium-fortified juice, or antacids. Infuse IV solution slowly over 60 minutes.",
            timing = "Every 12 hours with plenty of water.",
            specialInstructions = "Ensure generous fluid hydration (at least 2-2.5 liters/day) to prevent crystalluria. Discontinue immediately if patient develops heel/tendon pain or swelling.",
            pkPd = "Oral bioavailability ~70-80%. High volume of distribution with excellent penetration into prostate, kidneys, bile, lung, and macrophages. Partial hepatic metabolism. Renal clearance ~70%. Half-life ~4 hours.",
            renalAdj = "CrCl 30-50 mL/min: 250-500 mg PO q12h. CrCl <30 mL/min: 250-500 mg PO q18-24h. Hemodialysis: 250-500 mg PO q24h given post-dialysis.",
            hepaticAdj = "No adjustment needed unless accompanied by severe renal insufficiency.",
            pregnancy = "Category C (Avoid; risk of cartilage and joint toxicity in developing fetus).",
            lactation = "Excreted in breast milk; alternative antibiotic preferred due to risk of infant arthropathy.",
            sideEffects = "Nausea, diarrhea, elevated transaminases, Achilles tendinitis/rupture, QT prolongation, dizziness, insomnia, photosensitivity, Clostridioides difficile colitis.",
            priceNpr = "NPR 35.00 - 80.00 per strip of 10 (500mg) / NPR 45.00 per 100 mL IV",
            priceInr = "INR 25.00 - 60.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Cifran", "Sun Pharma Nepal", "Tab / Eye Drops", "250 mg / 500 mg / 0.3%"),
                BrandInfo("Ciplox", "Cipla Nepal", "Tab / IV / Drops", "500 mg / 200mg/100mL / 0.3%"),
                BrandInfo("Ciprobid", "Cadila Pharmaceuticals Nepal", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ciplox", "Cipla", "Tab / IV", "250 / 500 mg"),
                BrandInfo("Cifran", "Sun Pharma", "Tab", "500 mg")
            ),
            adultDose = "500 mg PO BID or 400 mg IV q12h.",
            childDose = "Contraindicated for routine pediatric infections; approved only for complicated UTI or anthrax (10-20 mg/kg PO BID).",
            contraindications = "Hypersensitivity to fluoroquinolones; concurrent administration with tizanidine; history of quinolone-associated tendon rupture.",
            modeOfAction = "Inhibits bacterial DNA gyrase (topoisomerase II) and topoisomerase IV, preventing DNA replication, transcription, repair, and recombination.",
            therapeuticClassTag = "Fluoroquinolones / Antimicrobials"
        )
    )
}
