package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object SpecialtyDrugsNeuroHeme {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // 5. ANTIEPILEPTIC (ANTISEIZURE MEDICATIONS - ASMs)
        // ==========================================

        // --- OLDER / 1ST-GENERATION ASMs ---
        Drug(
            id = "d_asm_phenytoin",
            genericName = "Phenytoin Sodium",
            system = "Central Nervous System (CNS)",
            drugClass = "1st-Generation Antiseizure Medication (Voltage-Gated Sodium Channel Blocker)",
            era = "Older / Classical",
            therapeuticClassTag = "Antiepileptic",
            researchNotes = "Classical 1st-generation ASM introduced in 1938. Characterized by zero-order (non-linear saturation) Michaelis-Menten pharmacokinetics, narrow therapeutic index (10-20 mcg/mL), and classic adverse effects (gingival hyperplasia, cerebellar ataxia, hirsutism).",
            blackBoxWarning = "CARDIOVASCULAR COLLAPSE WITH RAPID IV INFUSION: Severe hypotension and cardiac arrhythmias can occur if IV infusion exceeds 50 mg/min in adults. Requires continuous ECG and blood pressure monitoring.",
            indications = "Tonic-clonic (grand mal) seizures, focal (partial) seizures, status epilepticus (IV loading protocol), neurosurgical seizure prophylaxis.",
            doses = "Status Epilepticus: 15-20 mg/kg IV at rate not exceeding 50 mg/min. Maintenance: 300 mg to 400 mg/day PO in single or divided doses (3-5 mg/kg/day).",
            adultDose = "300 - 400 mg PO daily (Status IV loading: 15-20 mg/kg)",
            childDose = "Initial 5 mg/kg/day divided in 2-3 doses; maintenance 4-8 mg/kg/day.",
            administration = "Take with or immediately after meals to reduce GI irritation. Tube feeding must be stopped 2 hours before and after phenytoin administration (enteral feeds bind drug).",
            timing = "Evenly spaced once daily (XR) or divided BID/TID.",
            specialInstructions = "Check therapeutic drug levels (target total phenytoin 10-20 mcg/mL; free phenytoin 1-2 mcg/mL). Maintain meticulous oral dental hygiene to prevent gingival hyperplasia.",
            pkPd = "Prolongs recovery time of voltage-gated sodium channels from inactivated state, blocking repetitive high-frequency neuronal firing. Michaelis-Menten kinetics: small dose increments produce disproportionately large serum concentration jumps. Half-life: 12-36 hours.",
            renalAdj = "Low serum albumin in uremia increases unbound/free fraction. Calculate Sheiner-Tozer adjusted level.",
            hepaticAdj = "Use with extreme caution; clearance is decreased in cirrhosis.",
            pregnancy = "Category D (Fetal Hydantoin Syndrome: cleft lip/palate, microcephaly, congenital heart disease, nail hypoplasia).",
            lactation = "Compatible with breastfeeding; present in low levels in breast milk.",
            sideEffects = "Gingival hypertrophy, nystagmus, ataxia, cerebellar atrophy (chronic toxicity), coarse facial features, peripheral neuropathy, megaloblastic anemia (folate deficiency), DRESS syndrome, Stevens-Johnson syndrome.",
            priceNpr = "NPR 3.50 - 7.00 per tab (100mg)",
            priceInr = "INR 2.00 - 5.00 per tab (100mg)",
            brandsNepal = listOf(
                BrandInfo("Eptoin", "Abbott Nepal", "Tablet / Inj", "100 mg / 100 mg/2mL Inj"),
                BrandInfo("Dilantin", "Pfizer Nepal", "Capsule", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Eptoin", "Abbott Healthcare", "Tablet / Inj", "50 mg / 100 mg / 300 mg ER"),
                BrandInfo("Dilantin", "Pfizer India", "Capsule / Inj", "100 mg / 250 mg/5mL"),
                BrandInfo("Epsolin", "Neon Laboratories", "Inj / Tab", "100 mg / 50 mg/mL")
            ),
            pediatricDosePerKg = 5.0,
            pediatricInterval = "mg/kg/day divided BID or TID",
            contraindications = "Sinus bradycardia, sino-atrial block, second- and third-degree AV block, Stokes-Adams syndrome.",
            modeOfAction = "Selectively binds to the inactive state of neuronal voltage-dependent Na+ channels, slowing channel reactivation and halting paroxysmal seizure discharges.",
            interactions = "Potent CYP3A4, CYP2C9, and P-glycoprotein inducer. Decreases efficacy of oral contraceptives, warfarin, statins, and antiretrovirals. Valproate displaces phenytoin from albumin and inhibits metabolism.",
            packSize = "Bottle of 100 tablets",
            counselingNepali = "यो छारे रोग (काम्ने बिरामी) को पुरानो मुख्य औषधि हो। दाँतको गिजा सुन्निने समस्याबाट बच्न दाँत सधैं राम्ररी माझ्नुहोस्। रगतमा औषधिको मात्रा (Level) नियमित जचाउनुपर्छ।",
            counselingEnglish = "Take consistently with food. Strict dental flossing and brushing needed to prevent gum swelling. Periodic therapeutic blood level monitoring required."
        ),

        Drug(
            id = "d_asm_valproate",
            genericName = "Sodium Valproate / Divalproex Sodium",
            system = "Central Nervous System (CNS)",
            drugClass = "Broad-Spectrum Antiseizure Medication & Mood Stabilizer",
            era = "Older / Classical",
            therapeuticClassTag = "Antiepileptic",
            researchNotes = "Classical broad-spectrum ASM discovered in 1962. Highly effective across all seizure types (focal, generalized tonic-clonic, absence, myoclonic); however, severe teratogenicity (neural tube defects) and pancreatitis/hepatotoxicity mandate strict caution in women of childbearing age.",
            blackBoxWarning = "HEPATOTOXICITY, PANCREATITIS & SEVERE TERATOGENICITY: Fatal hepatic failure (especially in children <2 years or mitochondrial POLG mutations). Life-threatening pancreatitis. High risk of major congenital malformations (neural tube defects: spina bifida, 1-2%) and 30-40% lower cognitive scores/autism in exposed offspring.",
            indications = "Generalized tonic-clonic seizures, absence seizures, myoclonic seizures, focal onset seizures; acute mania in bipolar disorder; migraine prophylaxis.",
            doses = "Epilepsy: Initial 10-15 mg/kg/day PO divided q8-12h; titrate weekly by 5-10 mg/kg/day to target 30-60 mg/kg/day. Target therapeutic serum level: 50-100 mcg/mL.",
            adultDose = "500 - 1500 mg PO daily in divided doses (Max 60 mg/kg/day)",
            childDose = "Initial 10-15 mg/kg/day, titrate up to 30-40 mg/kg/day divided BID.",
            administration = "Take orally with meals to reduce gastrointestinal irritation. Swallow extended-release tablets whole.",
            timing = "Twice daily with meals.",
            specialInstructions = "STRICT PREGNANCY CONTRAINDICATION: Do not prescribe to females of childbearing potential unless completely refractory to all other options and on effective contraception. Co-prescribe high-dose folic acid (5 mg/day) if unavoidable.",
            pkPd = "Multiple mechanisms: increases brain GABA levels via inhibition of GABA transaminase, blocks T-type Ca2+ currents, and inhibits voltage-gated Na+ channels. Bioavailability ~100%. Half-life: 9-16 hours.",
            renalAdj = "No initial adjustment needed. Free fraction is increased in uremia; monitor unbound level.",
            hepaticAdj = "CONTRAINDICATED in severe hepatic dysfunction or active hepatitis.",
            pregnancy = "Category X for migraine; Category D for epilepsy (Contraindicated in women of childbearing potential unless no alternative).",
            lactation = "Compatible with breastfeeding; present in low levels in breast milk.",
            sideEffects = "Significant weight gain, alopecia / hair thinning, tremors, thrombocytopenia, hyperammonemic encephalopathy (with normal LFTs), polycystic ovary syndrome (PCOS), acute pancreatitis.",
            priceNpr = "NPR 10.00 - 24.00 per tab (500mg)",
            priceInr = "INR 7.00 - 18.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Epival", "Abbott Nepal", "Tablet / CR", "250 mg / 500 mg CR"),
                BrandInfo("Encorate", "Sun Pharma Nepal", "Tablet / Chrono", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Valparin", "Sanofi Nepal", "Chrono Tab / Syr", "200 mg / 500 mg Chrono")
            ),
            brandsIndia = listOf(
                BrandInfo("Encorate Chrono", "Sun Pharma", "Controlled Release Tab", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Valparin Chrono", "Sanofi India", "Controlled Release Tab", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Epitein", "Intas Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Divalpro", "Torrent Pharmaceuticals", "ER Tablet", "250 mg / 500 mg / 750 mg")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "mg/kg/day divided BID",
            contraindications = "Hepatic disease, known mitochondrial disorders caused by mutations in nuclear gene encoding mitochondrial DNA polymerase-gamma (POLG), urea cycle disorders, pregnancy for migraine.",
            modeOfAction = "Enhances GABAergic neurotransmission by blocking GABA-transaminase and succinic semialdehyde dehydrogenase; inhibits T-type calcium channels and voltage-gated sodium channels.",
            interactions = "Inhibits metabolism of lamotrigine (causes toxic lamotrigine levels and SJS; cut lamotrigine dose by 50%), Carbapenems (drastically plummet valproate levels within 24h, precipitating status epilepticus).",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो काम्ने र छारे रोगको सबै प्रकारका लागि काम गर्ने औषधि हो। खानासँग खानुहोस्। तौल बढ्न सक्छ। गर्भवती महिलाले यो औषधि खानुहुँदैन, यसले बच्चामा गम्भीर जन्मजात अपाङ्गता गराउँछ।",
            counselingEnglish = "Broad-spectrum ASM. Take with meals. May cause weight gain. Strictly contraindicated in pregnant women due to severe birth defect risks."
        ),

        // --- NEWER / MODERN GENERATION ASMs ---
        Drug(
            id = "d_asm_levetiracetam",
            genericName = "Levetiracetam",
            system = "Central Nervous System (CNS)",
            drugClass = "Synaptic Vesicle Protein 2A (SV2A) Ligand",
            era = "Newer / Modern",
            therapeuticClassTag = "Antiepileptic",
            researchNotes = "Modern 2nd-generation broad-spectrum ASM. Favorable pharmacokinetic profile with near 100% oral bioavailability, zero hepatic CYP450 metabolism, rapid IV/oral titration, and minimal drug-drug interactions. Primary caveat: behavioral irritability/psychiatric adverse effects.",
            indications = "Focal onset seizures, primary generalized tonic-clonic seizures, juvenile myoclonic epilepsy (JME), status epilepticus (IV preferred second-line).",
            doses = "Oral / IV: Initial 500 mg PO/IV BID (1000 mg/day). Titrate every 2 weeks by 500 mg BID to maximum 1500 mg PO/IV BID (3000 mg/day).",
            adultDose = "500 - 1500 mg PO/IV BID (Max 3000 mg/day)",
            childDose = "Pediatric (≥1 month): Initial 10 mg/kg BID, titrate up to 30 mg/kg BID (max 60 mg/kg/day).",
            administration = "Take orally twice daily with or without food. IV formulation given as 15-minute infusion diluted in 100 mL NS.",
            timing = "Twice daily, spaced 12 hours apart.",
            specialInstructions = "Screen for pre-existing depression, anxiety, or aggression. Supplementation with Vitamin B6 (Pyridoxine 50-100 mg/day) can significantly ameliorate levetiracetam-induced behavioral agitation.",
            pkPd = "Binds to synaptic vesicle protein 2A (SV2A) in presynaptic terminals, inhibiting vesicle exocytosis and dampening presynaptic glutamate neurotransmission. Minimal protein binding (<10%). 66% excreted unchanged in urine. Half-life: 6-8 hours.",
            renalAdj = "CrCl 50-80: 500-1000 mg q12h. CrCl 30-49: 250-750 mg q12h. CrCl <30 mL/min: 250-500 mg q12h. Hemodialysis: 500-1000 mg q24h + 250-500 mg post-dialysis.",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh C) with CrCl <50: Reduce dose by 50%.",
            pregnancy = "Category C (EURAP registry shows lowest major congenital malformation rate ~2-3%, making it a preferred ASM in pregnancy).",
            lactation = "Compatible with breastfeeding; monitor infant for drowsiness.",
            sideEffects = "Somnolence, fatigue, behavioral changes (irritability, agitation, mood swings, depression: 10-15%), dizziness, nasopharyngitis.",
            priceNpr = "NPR 18.00 - 36.00 per tab (500mg)",
            priceInr = "INR 12.00 - 24.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Levipil", "Sun Pharma Nepal", "Tablet / Syr / Inj", "250 / 500 / 750 / 1000 mg"),
                BrandInfo("Keppra", "UCB / Regional", "Tablet / Inj", "500 mg / 1000 mg"),
                BrandInfo("Torleva", "Torrent Nepal", "Tablet", "500 mg / 750 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Levipil", "Sun Pharma", "Tablet / Syrup / Inj", "250 / 500 / 750 / 1000 mg / 500mg Inj"),
                BrandInfo("Keppra", "Dr. Reddy's / UCB India", "Tablet / Inj", "250 / 500 / 1000 mg"),
                BrandInfo("Torleva", "Torrent Pharmaceuticals", "Tablet", "250 / 500 / 750 / 1000 mg"),
                BrandInfo("Levera", "Intas Pharmaceuticals", "Tablet / Inj", "500 mg / 750 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg/kg BID (titrate to 30 mg/kg BID)",
            contraindications = "Hypersensitivity to levetiracetam or pyrrolidone derivatives.",
            modeOfAction = "Selectively binds to presynaptic SV2A protein, modulating synaptic vesicle fusion and neurotransmitter release during rapid epileptic bursts.",
            interactions = "Does not inhibit or induce hepatic CYP enzymes. Zero pharmacokinetic drug interactions with oral contraceptives, warfarin, or other ASMs.",
            packSize = "Strip of 10 tablets",
            counselingNepali = "यो छारे रोगको आधुनिक र सुरक्षित औषधि हो। यसले अन्य औषधिसँग रियाक्सन गर्दैन। गर्भावस्थामा पनि यो सुरक्षित मानिन्छ। मनमा धेरै रिस उठ्ने वा चिडचिडाहट भएमा डाक्टरलाई भन्नुहोस्।",
            counselingEnglish = "Take twice daily 12 hours apart. Very safe with minimal drug interactions. Report unusual anger, depression, or mood swings."
        ),

        Drug(
            id = "d_asm_lacosamide",
            genericName = "Lacosamide",
            system = "Central Nervous System (CNS)",
            drugClass = "Functionalized Amino Acid (Selective Enhancer of Slow Sodium Channel Inactivation)",
            era = "Newer / Modern",
            therapeuticClassTag = "Antiepileptic",
            researchNotes = "Modern 3rd-generation ASM. Unique selective mechanism: enhances SLOW inactivation of voltage-gated sodium channels (unlike traditional sodium blockers which only affect fast inactivation), providing potent seizure termination without disrupting physiological baseline neuronal conduction.",
            indications = "Monotherapy and adjunctive therapy in focal onset seizures with or without secondary generalization; primary generalized tonic-clonic seizures in patients ≥4 years.",
            doses = "Initial: 50 mg PO/IV twice daily (100 mg/day). Titrate weekly by 50 mg BID to maintenance dose of 100 mg to 200 mg PO/IV twice daily (200-400 mg/day). Loading dose in urgency: 200 mg IV.",
            adultDose = "100 - 200 mg PO/IV BID (Max 400 mg/day)",
            childDose = "Pediatric (≥4 years): 1-2 mg/kg/day divided BID, titrate up to 6-12 mg/kg/day.",
            administration = "Take orally twice daily with or without food. IV infusion administered over 30-60 minutes.",
            timing = "Twice daily, morning and evening.",
            specialInstructions = "Perform baseline ECG in patients with known cardiac conduction problems (PR interval prolongation risk).",
            pkPd = "Selectively enhances slow inactivation of voltage-gated sodium channels, terminating sustained repetitive firing. Oral bioavailability ~100%. Negligible protein binding (<15%). Excreted renally (40% unchanged). Half-life: 13 hours.",
            renalAdj = "Severe renal impairment (CrCl ≤30 mL/min) or ESRD: Maximum recommended dose is 300 mg/day. Supplemental dose after 4-hour hemodialysis.",
            hepaticAdj = "Mild to moderate: Max dose 300 mg/day. Severe impairment: Not recommended.",
            pregnancy = "Category C (Use only if potential benefit justifies potential fetal risk).",
            lactation = "Present in human breast milk; use with caution.",
            sideEffects = "Dizziness (30%), headache, nausea, diplopia, ataxia, PR-interval prolongation, syncope (rare).",
            priceNpr = "NPR 25.00 - 55.00 per tab (100mg)",
            priceInr = "INR 16.00 - 35.00 per tab (100mg)",
            brandsNepal = listOf(
                BrandInfo("Vimpat", "UCB Nepal", "Tablet / Inj", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Lacoxa", "Sun Pharma Nepal", "Tablet", "50 mg / 100 mg"),
                BrandInfo("Lacoset", "Torrent Nepal", "Tablet", "50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Vimpat", "UCB India", "Tablet / Inj", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Lacoxa", "Sun Pharma", "Tablet / Inj", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Lacoset", "Torrent Pharmaceuticals", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Lacan", "Intas Pharmaceuticals", "Tablet", "50 mg / 100 mg")
            ),
            contraindications = "Second- or third-degree AV block, severe cardiac conduction abnormalities.",
            modeOfAction = "Selectively accelerates and enhances slow inactivation of voltage-gated sodium channels, stabilizing hyperexcitable neuronal membranes.",
            interactions = "Drugs that prolong PR interval (Beta-blockers, Verapamil, Diltiazem - monitor ECG). Strong CYP3A4/2C19 inducers reduce levels.",
            packSize = "Strip of 10 or 14 tablets",
            counselingNepali = "यो नसाको चाललाई स्थिर राखेर छारे रोग नियन्त्रण गर्ने तेस्रो पुस्ताको आधुनिक औषधि हो। बिहान र बेलुका खानुहोस्। टाउको घुम्ने वा रिंगटा लाग्ने हुन सक्छ।",
            counselingEnglish = "Take twice daily. Advanced selective slow sodium channel blocker. Report heart fluttering, fainting, or severe dizziness."
        ),

        // --- UNDER RESEARCH / PIPELINE ASMs ---
        Drug(
            id = "d_asm_cenobamate",
            genericName = "Cenobamate (Xcopri)",
            system = "Central Nervous System (CNS)",
            drugClass = "Novel Dual-Action Antiseizure Medication (Persistent Na+ Blocker & GABA-A Modulator)",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Antiepileptic",
            researchNotes = "REVOLUTIONARY ASM INNOVATION: Demonstrated the highest rates of sustained 100% seizure-freedom (~20-28%) ever documented in clinical trials of highly refractory, drug-resistant focal epilepsy (C017 and C021 trials published in Lancet Neurology). Novel dual mechanism: preferential blockade of non-inactivating persistent sodium currents (INaP) and positive allosteric modulation of GABA-A receptors at a non-benzodiazepine site.",
            blackBoxWarning = "DRESS SYNDROME / MULTIORGAN HYPERSENSITIVITY: Drug Reaction with Eosinophilia and Systemic Symptoms (DRESS) reported, including fatalities, when titrated too rapidly. Strict slow biweekly titration mandatory. Shortens QT interval.",
            indications = "Treatment of partial-onset (focal) seizures in adults with drug-resistant epilepsy; undergoing trials for primary generalized tonic-clonic seizures.",
            doses = "STRICT BIWEEKLY TITRATION SCHEDULE: Weeks 1-2: 12.5 mg PO once daily. Weeks 3-4: 25 mg PO once daily. Weeks 5-6: 50 mg PO once daily. Weeks 7-8: 100 mg PO once daily. Maintenance target: 200 mg to 400 mg PO once daily.",
            adultDose = "Initial 12.5 mg daily -> titrate biweekly to 200 - 400 mg PO once daily",
            childDose = "Safety and efficacy not established in pediatric patients <18 years.",
            administration = "Take orally once daily at any time with or without food. Swallow tablets whole.",
            timing = "Once daily, preferably at bedtime.",
            specialInstructions = "DO NOT ACCELERATE TITRATION: Strict biweekly step-up is mandatory to prevent life-threatening DRESS syndrome. Reduce concomitant phenytoin and clobazam doses (cenobamate inhibits CYP2C19).",
            pkPd = "Dual action: selectively inhibits persistent sodium current (INaP) and acts as a positive allosteric modulator of GABA-A receptors at high-affinity presynaptic sites. Extensive hepatic metabolism via glucuronidation (UGT2B7/2B4) and oxidation (CYP2E1, 2A6, 2B6). Half-life: 50-60 hours.",
            renalAdj = "Mild to moderate: Use with caution. Severe (CrCl <30 mL/min): Max dose 100-200 mg daily. Hemodialysis: Not recommended.",
            hepaticAdj = "Mild to moderate: Max dose 200 mg daily. Severe hepatic impairment: Contraindicated.",
            pregnancy = "Contraindicated; adverse developmental outcomes in animal studies.",
            lactation = "Contraindicated.",
            sideEffects = "Somnolence, dizziness, fatigue, diplopia, balance disorder, QT interval shortening (dose-dependent), DRESS syndrome (with rapid titration).",
            priceNpr = "Under Global Specialty Access (~$1,000/month)",
            priceInr = "Under Global Specialty Access (Specialty Import)",
            brandsNepal = listOf(
                BrandInfo("Xcopri (Cenobamate)", "SK Biopharmaceuticals / Pipeline", "Tablet", "12.5 / 50 / 100 / 200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Xcopri", "SK Life Science / Specialty Import", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Ontozry", "Angelini Pharma Global", "Tablet", "50 mg / 100 mg")
            ),
            contraindications = "Familial short QT syndrome, known hypersensitivity to cenobamate.",
            modeOfAction = "Preferentially blocks persistent voltage-gated sodium currents and positively modulates GABA-A receptor chloride currents at a unique binding site.",
            interactions = "Strong CYP2C19 inhibitor (markedly elevates active clobazam metabolite N-desmethylclobazam and phenytoin; lower doses of co-medications). Induces CYP3A4 (lowers oral contraceptives).",
            packSize = "Titration blister packs (12.5 mg / 25 mg / 50 mg / 100 mg)",
            counselingNepali = "यो कुनै पनि औषधिले निको नभएको कडा छारे रोगका बिरामीहरूका लागि चमत्कारिक सावित भएको नयाँ पुस्ताको औषधि हो। यसको मात्रा डाक्टरले भने अनुसार हरेक २ हप्तामा मात्र बिस्तारै बढाउनुपर्छ।",
            counselingEnglish = "Breakthrough ASM with unprecedented 20%+ seizure-free rates in drug-resistant epilepsy. Strict biweekly slow titration protocol must be followed."
        ),

        // ==========================================
        // 6. ANTI COAGULANT (ANTICOAGULANTS)
        // ==========================================

        // --- OLDER / CLASSICAL ANTICOAGULANTS ---
        Drug(
            id = "d_ac_warfarin",
            genericName = "Warfarin Sodium",
            system = "Cardiovascular System (CVS)",
            drugClass = "Vitamin K Antagonist (Oral Coumarin Anticoagulant)",
            era = "Older / Classical",
            therapeuticClassTag = "Anti coagulant",
            researchNotes = "Classical oral anticoagulant introduced in 1954. Inhibits Vitamin K epoxide reductase (VKORC1), depleting factors II, VII, IX, X, and protein C/S. Retains the essential, mandatory gold-standard indication for MECHANICAL PROSTHETIC HEART VALVES and antiphospholipid syndrome (where DOACs are contraindicated).",
            blackBoxWarning = "MAJOR BLEEDING RISK: Can cause severe, potentially fatal hemorrhage. Regular INR monitoring mandatory. Numerous drugs, dietary Vitamin K foods, and botanical supplements alter anticoagulant response.",
            indications = "Prophylaxis and treatment of venous thromboembolism (DVT/PE), thromboembolic complications associated with atrial fibrillation, mechanical prosthetic heart valves (indispensable drug of choice), antiphospholipid syndrome.",
            doses = "Individualized dosing based on International Normalized Ratio (INR). Initial: 2.5 mg to 5 mg PO once daily for 2 days, then adjust according to INR. Target INR: 2.0-3.0 for AF/DVT/PE; 2.5-3.5 for mechanical mitral valves.",
            adultDose = "2.5 - 5 mg PO once daily, titrated to target INR (2.0-3.0 or 2.5-3.5)",
            childDose = "Initial 0.1-0.2 mg/kg PO daily; titrate to target INR.",
            administration = "Take orally once daily in the evening at the same time each day, with or without food.",
            timing = "Evening (around 6 PM), to allow same-day INR blood draw review and dose adjustment.",
            specialInstructions = "MAINTAIN CONSISTENT DIETARY VITAMIN K INTAKE (green leafy vegetables: spinach, kale, cabbage). Avoid sudden dietary fluctuations. Avoid NSAIDs and IM injections. Antidote: Vitamin K1 (Phytonadione) and 4-factor Prothrombin Complex Concentrate (4F-PCC).",
            pkPd = "Inhibits Vitamin K 2,3-epoxide reductase complex subunit 1 (VKORC1), blocking gamma-carboxylation of glutamic acid residues on factors II, VII, IX, X, and proteins C and S. S-warfarin is 5x more potent than R-warfarin and metabolized by CYP2C9. Half-life: 20-60 hours.",
            renalAdj = "No dosage adjustment required; monitor INR carefully.",
            hepaticAdj = "CONTRAINDICATED in severe hepatic disease (decreased clotting factor synthesis increases bleeding risk).",
            pregnancy = "Category X (Warfarin embryopathy: nasal hypoplasia, stippled epiphyses, CNS abnormalities, fetal hemorrhage). Avoid throughout pregnancy except mechanical valves in high-risk centers.",
            lactation = "Compatible with breastfeeding; does not pass into breast milk (AAP approved).",
            sideEffects = "Hemorrhage (GI, intracranial, hematuria), skin necrosis and gangrene (protein C deficiency during induction), purple toe syndrome (cholesterol microemboli), alopecia, osteoporosis (long-term).",
            priceNpr = "NPR 4.00 - 8.00 per tab (5mg)",
            priceInr = "INR 2.50 - 5.50 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Warf", "Cipla Nepal", "Tablet", "1 mg / 2 mg / 3 mg / 5 mg"),
                BrandInfo("Uniwarf", "Universal Pharma Nepal", "Tablet", "2 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Warf", "Cipla Ltd.", "Tablet", "1 mg / 2 mg / 3 mg / 5 mg"),
                BrandInfo("Coumadin", "Bristol-Myers Squibb India", "Tablet", "2 mg / 5 mg"),
                BrandInfo("Acitrom (Acenocoumarol)", "Abbott Healthcare India", "Tablet", "1 mg / 2 mg / 3 mg / 4 mg")
            ),
            pediatricDosePerKg = 0.1,
            pediatricInterval = "mg/kg daily titrated to target INR",
            contraindications = "Pregnancy, active pathological bleeding, severe bleeding diathesis, open ulcerations of GI tract, malignant hypertension, recent eye/brain/spinal surgery.",
            modeOfAction = "Inactivates hepatic VKORC1 enzyme, depleting reduced vitamin K hydroquinone necessary for post-translational gamma-carboxylation of clotting factors II, VII, IX, and X.",
            interactions = "CYP2C9 inhibitors (Metronidazole, Fluconazole, Amiodarone, Cotrimoxazole - drastically spike INR), Inducers (Rifampin, Carbamazepine - plunge INR), NSAIDs/Aspirin (extreme bleeding risk).",
            packSize = "Strip of 10 or 30 tablets",
            counselingNepali = "यो रगत पातलो बनाउने पुरानो र भरपर्दो औषधि हो (विशेष गरी मुटुको कृत्रिम भल्भ फेरेकाहरूका लागि)। बेलुकाको समयमा खानुहोस्। रगत जचाउने परीक्षण (INR) नियमित गराउनुहोस् र हरियो सागपात सधैं एउटै मात्रामा खानुहोस्।",
            counselingEnglish = "Essential for mechanical heart valves. Take in the evening. Keep dietary greens consistent. Regular INR blood tests mandatory."
        ),

        // --- NEWER / MODERN STANDARDS (DOACs / NOACs) ---
        Drug(
            id = "d_ac_apixaban",
            genericName = "Apixaban",
            system = "Cardiovascular System (CVS)",
            drugClass = "Direct Oral Anticoagulant (Direct Factor Xa Inhibitor - DOAC)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti coagulant",
            researchNotes = "Modern first-line DOAC. Landmark ARISTOTLE trial demonstrated superiority over warfarin in stroke prevention, all-cause mortality, and significantly lower rates of major hemorrhage (including 58% reduction in intracranial hemorrhage). Safest bleeding profile among DOACs in elderly and renal dysfunction.",
            blackBoxWarning = "PREMATURE DISCONTINUATION INCREASES RISK OF THROMBOTIC EVENTS: Stopping apixaban prematurely increases the risk of stroke. SPINAL/EPIDURAL HEMATOMA: Epidural or spinal puncture with indwelling catheters poses risk of paralyzing hematoma.",
            indications = "Non-valvular atrial fibrillation (stroke/systemic embolism prevention), deep vein thrombosis (DVT) and pulmonary embolism (PE) treatment and extended secondary prophylaxis, post-operative VTE prophylaxis following hip/knee arthroplasty.",
            doses = "Atrial Fibrillation: 5 mg PO BID. Reduced dose: 2.5 mg PO BID if patient has at least TWO of: age ≥80 years, body weight ≤60 kg, or serum creatinine ≥1.5 mg/dL. DVT/PE Treatment: 10 mg PO BID for 7 days, then 5 mg PO BID.",
            adultDose = "5 mg PO BID (Reduce to 2.5 mg BID if ≥2 of: age ≥80, weight ≤60kg, Cr ≥1.5mg/dL)",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Take orally twice daily with or without food. Can be crushed and suspended in water, 5% dextrose, or applesauce.",
            timing = "Twice daily, spaced 12 hours apart.",
            specialInstructions = "DOES NOT REQUIRE ROUTINE INR MONITORING. Specific reversal agent: Andexanet alfa (andexa). Discontinue 24-48 hours before elective surgery based on bleeding risk.",
            pkPd = "Direct, selective, reversible inhibitor of both free and clot-bound Factor Xa and prothrombinase activity. Bioavailability ~50%. Dual elimination: 27% renal excretion, 73% biliary/fecal. Half-life: ~12 hours.",
            renalAdj = "CrCl 15-29 mL/min: 5 mg BID (or 2.5 mg BID if age ≥80 or weight ≤60 kg). ESRD on Hemodialysis: 5 mg BID (2.5 mg BID if age ≥80 or weight ≤60 kg).",
            hepaticAdj = "Mild impairment: No adjustment. Moderate (Child-Pugh B): Use with caution. Severe (Child-Pugh C): CONTRAINDICATED.",
            pregnancy = "Avoid; potential for maternal and fetal hemorrhage.",
            lactation = "Discontinue drug or nursing.",
            sideEffects = "Bleeding (epistaxis, hematuria, GI bleeding, menorrhagia), anemia, contusions; dramatically lower intracranial bleed risk than warfarin.",
            priceNpr = "NPR 45.00 - 85.00 per tab (5mg)",
            priceInr = "INR 28.00 - 55.00 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Eliquis", "Pfizer Nepal", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Apigat", "Natco Nepal", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Apixacip", "Cipla Nepal", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Foxaban", "Sun Pharma Nepal", "Tablet", "2.5 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Eliquis", "Pfizer India", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Apigat", "Natco Pharma", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Apixacip", "Cipla Ltd.", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Foxaban", "Sun Pharma", "Tablet", "2.5 mg / 5 mg")
            ),
            contraindications = "Active pathological bleeding, severe hepatic impairment, mechanical prosthetic heart valves, moderate-to-severe mitral stenosis, triple-positive antiphospholipid syndrome.",
            modeOfAction = "Selectively and directly blocks the catalytic active site of Factor Xa, halting thrombin generation without requiring antithrombin III co-factor.",
            interactions = "Strong dual inhibitors of CYP3A4 and P-gp (Ketoconazole, Itraconazole, Ritonavir - reduce dose by 50% to 2.5mg BID); Strong inducers (Rifampin, Carbamazepine - avoid use).",
            packSize = "Blister pack of 10, 14, or 20 tablets",
            counselingNepali = "यो रगत पातलो बनाउने आधुनिक र सुरक्षित औषधि (DOAC) हो। यसको लागि रगत जचाइरहनु पर्दैन र सागपात बार्नु पर्दैन। बिहान र बेलुका १२/१२ घण्टाको फरकमा खानुहोस्।",
            counselingEnglish = "Take twice daily 12 hours apart. No blood tests (INR) or dietary restrictions needed. Superior brain bleed safety compared to warfarin."
        ),

        // --- UNDER RESEARCH / PIPELINE ANTICOAGULANTS ---
        Drug(
            id = "d_ac_milvexian",
            genericName = "Milvexian (BMS-986177)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Investigational Oral Small-Molecule Factor XIa Inhibitor",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti coagulant",
            researchNotes = "HOLY GRAIL OF ANTICOAGULATION: Targets activated Factor XI (FXIa) to uncouple pathological thrombosis from physiological hemostasis! Unlike Factor Xa or thrombin (which are essential for both clotting and wound healing), Factor XI amplifies pathological clot growth inside vessels with minimal role in normal hemostatic plug formation. Phase III Librexia trial program (Librexia STROKE, Librexia ACS, Librexia AF) by BMS/Janssen evaluates complete prevention of ischemic events with near-zero major bleeding hazard!",
            indications = "Under Phase III investigation for secondary stroke prevention in acute ischemic stroke/TIA, secondary prevention post-acute coronary syndrome, and stroke prevention in atrial fibrillation.",
            doses = "Phase III Clinical Trial Dosing: 25 mg, 50 mg, or 100 mg orally twice daily.",
            adultDose = "Investigational: 25 mg - 100 mg PO BID (Phase III Librexia Trials)",
            childDose = "Not studied in children.",
            administration = "Take orally twice daily with or without food.",
            timing = "Twice daily, morning and evening.",
            specialInstructions = "Phase II AXIOMATIC-TKR and AXIOMATIC-SSP trials demonstrated robust antithrombotic efficacy without an increase in clinically relevant non-major or major bleeding.",
            pkPd = "Potent, selective, reversible direct oral small-molecule inhibitor of active Factor XIa. Prolongs aPTT in a concentration-dependent manner without affecting PT/INR. Half-life ~12-14 hours.",
            renalAdj = "Under evaluation in Phase III trials (including renal cohorts).",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated.",
            lactation = "Contraindicated.",
            sideEffects = "Minimal bleeding risk observed in Phase II trials; mild bruising, headache, gastrointestinal discomfort.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Milvexian (Investigational)", "BMS / Janssen Pipeline", "Tablet", "25 mg / 50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("BMS-986177 (Trial)", "Bristol Myers Squibb / J&J Studies", "Tablet", "25 mg / 50 mg / 100 mg")
            ),
            contraindications = "Active major hemorrhage, hypersensitivity to FXIa inhibitors.",
            modeOfAction = "Directly binds to the catalytic domain of Factor XIa, shutting down the contact activation amplification loop of coagulation without disrupting the extrinsic hemostatic pathway.",
            interactions = "Under study in Phase III; safe co-administration with aspirin and clopidogrel demonstrated in AXIOMATIC-SSP.",
            packSize = "Investigational blister of 28 tablets",
            counselingNepali = "यो 'रगत नजम्ने तर रगत बग्ने खतरा पनि नहुने' चिकित्सा विज्ञानको सबैभन्दा नयाँ अनुसन्धान (Factor XIa inhibitor) हो। यसले मस्तिष्कघात (Stroke) रोक्न मद्दत गर्छ।",
            counselingEnglish = "Phase III Factor XIa inhibitor designed to eliminate blood clots without increasing major bleeding risks."
        ),

        // ==========================================
        // 7. ANTIPLATELETS (ANTIPLATELET THERAPY)
        // ==========================================

        // --- OLDER / CLASSICAL ANTIPLATELETS ---
        Drug(
            id = "d_ap_aspirin",
            genericName = "Aspirin (Acetylsalicylic Acid)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Classical Antiplatelet (Irreversible Cyclooxygenase-1 / COX-1 Inhibitor)",
            era = "Older / Classical",
            therapeuticClassTag = "Antiplatelets",
            researchNotes = "Foundational antiplatelet introduced by Bayer in 1899. Irreversibly acetylates platelet COX-1 for the entire 7-10 day lifespan of the platelet; global cornerstone of dual antiplatelet therapy (DAPT) in ACS and PCI.",
            blackBoxWarning = "REYE SYNDROME IN CHILDREN: Do not administer to children or teenagers with viral illnesses (varicella, influenza) due to risk of fatal Reye syndrome (acute encephalopathy and fatty liver).",
            indications = "Acute coronary syndrome (STEMI/NSTEMI/UA: 150-325 mg chewed stat), secondary prevention post-MI, post-PCI stenting, acute ischemic stroke (160-300 mg within 48h), stable angina.",
            doses = "Acute ACS / Stroke Load: 150 mg to 325 mg PO chewed immediately. Chronic secondary prevention: 75 mg to 100 mg PO once daily (low-dose cardioprotective).",
            adultDose = "75 - 100 mg PO once daily (Acute loading: 150-325 mg chewed)",
            childDose = "Antiplatelet in Kawasaki disease: 80-100 mg/kg/day during febrile phase, then 3-5 mg/kg/day.",
            administration = "Take with or after food. Enteric-coated formulations should be swallowed whole for chronic use; CHEW non-coated tablet in acute heart attack.",
            timing = "Once daily with food.",
            specialInstructions = "CHEW AND SWALLOW WITH WATER IMMEDIATELY upon suspicion of acute myocardial infarction. Co-prescribe a PPI (pantoprazole) in patients at high risk of GI bleeding.",
            pkPd = "Irreversibly acetylates Serine 529 of cyclooxygenase-1 (COX-1), blocking conversion of arachidonic acid to prostaglandin H2 and Thromboxane A2 (TXA2). Antiplatelet effect lasts the entire 7-10 day platelet lifespan.",
            renalAdj = "Severe renal impairment (eGFR <10 mL/min): Avoid; increases uremic bleeding and fluid retention.",
            hepaticAdj = "Avoid in severe liver disease (hypoprothrombinemia).",
            pregnancy = "Category D in 3rd trimester (premature closure of ductus arteriosus). Low-dose (75-150 mg/day) SAFE and RECOMMENDED in 2nd/3rd trimester for preeclampsia prevention.",
            lactation = "Avoid high doses; low-dose 75-100 mg daily is generally compatible.",
            sideEffects = "Dyspepsia, gastric erosions, peptic ulcer disease, upper GI bleeding, aspirin-exacerbated respiratory disease (AERD / Samter triad: asthma, nasal polyps, bronchospasm), tinnitus (high doses).",
            priceNpr = "NPR 1.50 - 3.50 per tab (75mg)",
            priceInr = "INR 1.00 - 2.50 per tab (75mg)",
            brandsNepal = listOf(
                BrandInfo("Ecosprin", "USV Nepal", "Enteric-coated Tab", "75 mg / 150 mg"),
                BrandInfo("Disprin", "Reckitt Benckiser Nepal", "Effervescent Tab", "350 mg"),
                BrandInfo("Loprin", "Micro Labs Nepal", "Tablet", "75 mg / 150 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ecosprin", "USV Ltd.", "Enteric-coated Tab", "75 mg / 150 mg / 325 mg"),
                BrandInfo("Disprin", "Reckitt Benckiser India", "Soluble Tab", "350 mg"),
                BrandInfo("Delisprin", "Aristo Pharmaceuticals", "Tablet", "75 mg / 150 mg"),
                BrandInfo("Asa", "Zydus Healthcare", "Tablet", "75 mg / 150 mg")
            ),
            pediatricDosePerKg = 3.0,
            pediatricInterval = "mg/kg daily for antiplatelet in Kawasaki disease",
            contraindications = "Active peptic ulcer bleeding, bleeding diathesis, severe thrombocytopenia, aspirin-induced asthma, viral infection in children/teens (Reye syndrome).",
            modeOfAction = "Permanent covalent acetylation of platelet COX-1, abolishing thromboxane A2 synthesis and blocking platelet activation, shape change, and aggregation.",
            interactions = "Ibuprofen and other NSAIDs (competitively block aspirin from reaching COX-1 active site; take aspirin at least 30 minutes before or 8 hours after ibuprofen), Anticoagulants (elevates major bleed risk).",
            packSize = "Strip of 14, 15, or 30 tablets",
            counselingNepali = "यो मुटुको नसामा रगत जम्न नदिने सबैभन्दा मुख्य औषधि हो। खाना खाएपछि खानुपर्छ। मुटुको अट्याक (छाती दुखेको) शंका लागेमा यसको चक्की तुरुन्त चपाएर निल्नुपर्छ।",
            counselingEnglish = "Take once daily with food. In suspected heart attack, CHEW a 150-325 mg tablet immediately. Report black tarry stools or stomach pain."
        ),

        // --- NEWER / MODERN POTENT ANTIPLATELETS ---
        Drug(
            id = "d_ap_ticagrelor",
            genericName = "Ticagrelor",
            system = "Cardiovascular System (CVS)",
            drugClass = "Reversible Non-Thienopyridine P2Y12 Platelet Inhibitor (Cyclopentyltriazolopyrimidine)",
            era = "Newer / Modern",
            therapeuticClassTag = "Antiplatelets",
            researchNotes = "Modern high-potency reversible P2Y12 antagonist. Landmark PLATO trial proved statistically significant reduction in cardiovascular death (21% reduction) and stent thrombosis compared to clopidogrel in acute coronary syndromes, without metabolic prodrug activation dependence.",
            blackBoxWarning = "BLEEDING RISK & ASPIRIN DOSE LIMITATION: Do not use with maintenance aspirin doses >100 mg daily, as high-dose aspirin significantly decreases ticagrelor's clinical efficacy (PLATO trial US paradox).",
            indications = "Acute coronary syndrome (STEMI, NSTEMI, Unstable Angina) managed medically or with PCI/CABG; secondary prevention of CAD post-MI (PEGASUS-TIMI 54).",
            doses = "ACS Loading Dose: 180 mg PO stat (two 90 mg tablets). Maintenance: 90 mg PO twice daily for 12 months with low-dose aspirin (75-100 mg daily). Extended maintenance (>1 year post-MI): 60 mg PO BID.",
            adultDose = "Loading: 180 mg stat -> Maintenance: 90 mg PO BID (with aspirin ≤100mg)",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Take orally twice daily with or without food. Can be crushed and administered in water.",
            timing = "Twice daily, approximately 12 hours apart.",
            specialInstructions = "DYSPNEA WARNING: ~10-15% of patients develop self-limiting dyspnea (due to adenosine reuptake inhibition). Reassure patient; usually peaks in first 3-5 days and resolves without bronchospasm. Stop 5 days prior to elective CABG.",
            pkPd = "Direct-acting reversible competitive antagonist at the P2Y12 receptor (no metabolic activation required). Inhibits equilibrative nucleoside transporter-1 (ENT1), raising extracellular adenosine levels. Half-life ~7-9 hours.",
            renalAdj = "No dose adjustment required in renal impairment or hemodialysis.",
            hepaticAdj = "Mild impairment: No adjustment. Moderate impairment: Use with caution. Severe (Child-Pugh C): Contraindicated.",
            pregnancy = "Avoid; use only if potential benefit justifies potential fetal risk.",
            lactation = "Breastfeeding not recommended during treatment.",
            sideEffects = "Dyspnea (14%), major and minor bleeding, ventricular pauses / bradyarrhythmias, elevated serum uric acid and creatinine.",
            priceNpr = "NPR 35.00 - 65.00 per tab (90mg)",
            priceInr = "INR 22.00 - 45.00 per tab (90mg)",
            brandsNepal = listOf(
                BrandInfo("Brilinta", "AstraZeneca Nepal", "Tablet", "60 mg / 90 mg"),
                BrandInfo("Ticaspan", "Sun Pharma Nepal", "Tablet", "90 mg"),
                BrandInfo("Axcer", "AstraZeneca / Sun Nepal", "Tablet", "90 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Brilinta", "AstraZeneca India", "Tablet", "60 mg / 90 mg"),
                BrandInfo("Axcer", "Sun Pharma", "Tablet", "90 mg"),
                BrandInfo("Ticasave", "Lupin Ltd.", "Tablet", "90 mg"),
                BrandInfo("Ticaflo", "Cipla Ltd.", "Tablet", "90 mg")
            ),
            contraindications = "History of intracranial hemorrhage, active pathological bleeding, severe hepatic impairment, concomitant strong CYP3A4 inhibitors/inducers.",
            modeOfAction = "Allosterically and reversibly blocks the P2Y12 ADP receptor on platelets, preventing ADP-mediated GP IIb/IIIa complex activation and platelet aggregation.",
            interactions = "Aspirin maintenance doses >100 mg decrease ticagrelor efficacy (maintain aspirin at 75-100 mg OD). Strong CYP3A4 inhibitors (Ketoconazole) increase levels; Inducers (Rifampin) decrease levels.",
            packSize = "Strip of 14 tablets (7-day supply)",
            counselingNepali = "यो मुटुको नलीमा स्टेन्ट (Stent) राखेपछि रगत नजम्नका लागि दिनको २ पटक खाने आधुनिक र शक्तिशाली औषधि हो। सुरुका केही दिन सास फेर्न अलि गाह्रो भएको जस्तो (Dyspnea) हुन सक्छ, जुन बिस्तारै ठीक हुन्छ।",
            counselingEnglish = "Take twice daily 12 hours apart with low-dose aspirin (75-100 mg). Transient shortness of breath may occur initially. Essential for stent protection."
        ),

        // --- UNDER RESEARCH / PIPELINE ANTIPLATELETS ---
        Drug(
            id = "d_ap_selatogrel",
            genericName = "Selatogrel",
            system = "Cardiovascular System (CVS)",
            drugClass = "Investigational Subcutaneous Fast-Acting Reversible P2Y12 Inhibitor",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Antiplatelets",
            researchNotes = "REVOLUTIONARY PATIENT SELF-ADMINISTERED AUTOINJECTOR: Designed for patients with a history of myocardial infarction to self-inject subcutaneously at the very first symptoms of a recurrent acute MI before the ambulance arrives! Phase III SOS-AMI trial evaluates whether rapid self-administration of 16 mg SC achieves >90% platelet inhibition within 15 minutes, aborting coronary occlusion and salvaging myocardium during the critical 'golden hour'.",
            indications = "Under Phase III investigation for self-administration by high-risk post-MI patients immediately upon recognizing acute symptoms of recurrent myocardial infarction.",
            doses = "Phase III Clinical Trial Dosing: Single 16 mg subcutaneous injection via prefilled auto-injector administered at onset of chest pain.",
            adultDose = "Investigational: 16 mg Subcutaneous single auto-injector dose (SOS-AMI Trial)",
            childDose = "Not studied in children.",
            administration = "Subcutaneous injection into the abdomen or thigh using a pre-programmed autoinjector pen upon emergency onset of symptoms.",
            timing = "Emergency single dose at onset of chest pain prior to hospital arrival.",
            specialInstructions = "Phase III SOS-AMI trial. Rapid onset of peak platelet inhibition within 15 minutes, with reversible offset within 8-12 hours, allowing emergency surgical CABG if needed without excess bleeding.",
            pkPd = "Highly potent, selective, reversible non-thienopyridine P2Y12 receptor antagonist. Rapid subcutaneous absorption with peak plasma concentrations within 15-30 minutes. Terminal half-life ~2-4 hours.",
            renalAdj = "Under evaluation in Phase III trials.",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated.",
            lactation = "Contraindicated.",
            sideEffects = "Transient injection site hematoma/bruising, minor bleeding (epistaxis); major bleeding rates under evaluation in SOS-AMI.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Selatogrel (Investigational)", "Idorsia Pipeline", "Autoinjector Pen", "16 mg / 0.8 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("ACT-246475 (Trial)", "Idorsia Clinical Studies", "Autoinjector", "16 mg")
            ),
            contraindications = "Active major pathological bleeding, history of intracranial hemorrhage.",
            modeOfAction = "Rapidly and reversibly binds P2Y12 ADP receptors on circulating platelets, halting acute intracoronary thrombus propagation within 15 minutes of subcutaneous delivery.",
            interactions = "Co-administered with standard emergency aspirin in SOS-AMI protocol.",
            packSize = "Investigational prefilled single-use emergency autoinjector pen",
            counselingNepali = "यो मुटुको अट्याक (Heart Attack) को लक्षण सुरु हुने बित्तिकै बिरामी आफैंले पेट वा तिघ्रामा सुई लगाएर अस्पताल नपुग्दै ज्यान बचाउने अनुसन्धानमा रहेको क्रान्तिकारी पेन-सुई हो।",
            counselingEnglish = "Phase III patient-administered emergency autoinjector delivering peak antiplatelet protection within 15 minutes of heart attack symptoms."
        )
    )
}
