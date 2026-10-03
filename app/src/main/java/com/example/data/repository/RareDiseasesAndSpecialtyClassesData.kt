package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object RareDiseasesAndSpecialtyClassesData {

    val rareDiseaseAndSpecialtyDrugs: List<Drug> = listOf(
        // ==========================================
        // RARE DISEASES & ORPHAN DRUGS
        // ==========================================

        // 1. Trientine Tetrahydrochloride (Wilson Disease)
        Drug(
            id = "d_rare_trientine",
            genericName = "Trientine Tetrahydrochloride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Copper Chelating Agent (Orphan Drug)",
            blackBoxWarning = null,
            indications = "Wilson Disease (hepatolenticular degeneration) in patients intolerant or allergic to penicillamine, or presenting with acute hepatic decompensation; Leipzig diagnostic score >=4.",
            doses = "Adults & Adolescents: 750 to 1500 mg PO daily in divided doses BID or TID (given as 250mg capsules). Max 2000 mg/day.\nPediatrics (<=12 yr): 500 to 1000 mg PO daily divided BID or TID.",
            administration = "Take on an empty stomach at least 1 hour before meals or 2 hours after meals, with cold water. Keep capsules refrigerated (2°C-8°C).",
            timing = "Empty stomach (1h before meals).",
            specialInstructions = "Separate from iron supplements, mineral multivitamins, or antacids by at least 2 hours to avoid chelation complex formation. Monitor 24-hour urinary copper excretion (target 200-500 mcg/24h on treatment).",
            pkPd = "Poorly absorbed orally (<10%). Excreted in urine as trientine and acetyltrientine chelated with cupric ions. Mobilizes systemic copper stores and promotes cupriuresis without the immunogenic sulfhydryl moiety of penicillamine.",
            renalAdj = "No specific dosage adjustment; monitor for proteinuria and renal function.",
            hepaticAdj = "No initial dosage adjustment required. Gold standard for hepatic Wilson disease with penicillamine intolerance.",
            pregnancy = "Category C (Teratogenic in animal models; however, untreated Wilson disease carries high maternal/fetal mortality; continue lowest effective dose with close fetal surveillance).",
            lactation = "Excretion in breast milk unknown; use caution or consider formula feeding.",
            sideEffects = "Iron deficiency anemia (chelation of iron), nausea, skin rash, heartburn, rare systemic lupus erythematosus-like reaction, muscular spasms.",
            priceNpr = "NPR 350.00 - 650.00 per cap (250mg)",
            priceInr = "INR 220.00 - 450.00 per cap (250mg)",
            brandsNepal = listOf(
                BrandInfo("Cuprior", "Orphan Europe / Global Import", "Capsule", "250 mg / 150 mg"),
                BrandInfo("Trienter", "Sun Pharma Special Access", "Capsule", "250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Syprine", "Bausch Health / Import", "Capsule", "250 mg"),
                BrandInfo("Trientine-Cipla", "Cipla Rare Therapeutics", "Capsule", "250 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "divided q8h to q12h",
            adultDose = "750-1500 mg/day divided BID-TID",
            childDose = "500-1000 mg/day divided BID-TID",
            contraindications = "Hypersensitivity to trientine or any component of formulation.",
            modeOfAction = "Binds and forms a stable soluble tetradentate copper complex that is readily eliminated via renal glomerular filtration.",
            interactions = "Iron salts, oral zinc, magnesium/aluminum antacids (diminished chelation efficacy).",
            nemlCategory = "WHO & DDA Specialized Orphan Drug Register",
            ddaSchedule = "Schedule Ka (Supervised Specialist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "EASL 2024 Wilson Disease Clinical Practice Guidelines establish trientine as first-line chelator alongside penicillamine."
        ),

        // 2. D-Penicillamine (Wilson Disease & Cystinuria)
        Drug(
            id = "d_rare_penicillamine",
            genericName = "D-Penicillamine",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Heavy Metal Chelating Agent (Thiol / Sulfhydryl)",
            blackBoxWarning = "SEVERE TOXICITY MONITORING: Penicillamine should only be administered by physicians experienced with Wilson disease or cystinuria. Severe adverse effects include aplastic anemia, agranulocytosis, thrombocytopenia, Goodpasture syndrome, and myasthenia gravis. Complete blood count, urinalysis, and LFTs are mandatory every 2 weeks for the first 6 months.",
            indications = "Wilson disease (initial de-coppering and maintenance), Severe active rheumatoid arthritis refractory to conventional DMARDs, Cystinuria with recurrent nephrolithiasis.",
            doses = "Adult: 750 to 1500 mg PO daily in 3 to 4 divided doses. Start low (250-500 mg/day) and titrate upward weekly. Co-prescribe Pyridoxine (Vitamin B6) 25-50 mg daily.\nPediatrics: 20 mg/kg/day divided BID or TID.",
            administration = "Administer on an empty stomach at least 1 hour before or 2 hours after meals, and at least 1 hour apart from any other drug, food, or milk.",
            timing = "Empty stomach (1h pre-meal).",
            specialInstructions = "Always administer concurrent Pyridoxine (Vitamin B6) because penicillamine is a pyridoxine antagonist. Stop immediately if proteinuria, hematuria, or leukopenia (<3500/mm³) occurs.",
            pkPd = "Oral absorption 40-70%. Hepatic metabolism to disulfides; predominantly renal excretion. Half-life ~2-3 hours. Cleaves copper-protein bonds and promotes cupriuresis.",
            renalAdj = "CrCl 10-50 mL/min: Administer 50% of normal dose. CrCl <10 mL/min: Avoid use.",
            hepaticAdj = "Dose with caution; baseline monitoring required.",
            pregnancy = "Category D (Associated with cutis laxa and connective tissue defects in infants; reduce to lowest dose 250-500 mg/day in pregnancy if Wilson disease requires continuation).",
            lactation = "Contraindicated during breastfeeding.",
            sideEffects = "Marrow suppression (thrombocytopenia, leukopenia), proteinuria, membranous nephropathy, dysgeusia (loss of taste), elastosis perforans serpiginosa, pemphigus, drug fever.",
            priceNpr = "NPR 45.00 - 85.00 per cap (250mg)",
            priceInr = "INR 28.00 - 55.00 per cap (250mg)",
            brandsNepal = listOf(
                BrandInfo("Artamin", "Biochem Pharmaceuticals", "Capsule", "150 mg / 250 mg"),
                BrandInfo("Penamine", "Nepal Specialized Supplies", "Capsule", "250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Artamin", "Biochem / Zydus", "Capsule", "250 mg"),
                BrandInfo("Cuprimine", "Bausch Health", "Capsule", "250 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "divided q8h",
            adultDose = "750-1500 mg daily divided TID-QID",
            childDose = "20 mg/kg/day divided TID",
            contraindications = "History of penicillamine-related aplastic anemia, agranulocytosis, severe renal insufficiency, concurrent gold salts or immunosuppressants.",
            modeOfAction = "Sulfhydryl group (-SH) binds ionic copper (Cu2+) creating a soluble chelate readily excreted by the kidney.",
            interactions = "Iron salts, antacids, zinc (decreases absorption); gold salts, phenylbutazone, antimalarials (increased risk of hematologic toxicity).",
            nemlCategory = "National Essential Medicines List (Specialist Formulary)",
            ddaSchedule = "Schedule Ka (Supervised Specialist Prescription)",
            era = "Older / Classical",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Classical de-coppering agent; EASL guidelines recommend stepping down to zinc maintenance after initial 1-2 years of clinical stabilization."
        ),

        // 3. Riluzole (Amyotrophic Lateral Sclerosis - ALS)
        Drug(
            id = "d_rare_riluzole",
            genericName = "Riluzole",
            system = "Central Nervous System (CNS)",
            drugClass = "Glutamate Release Inhibitor / Neuroprotective Agent",
            blackBoxWarning = null,
            indications = "Amyotrophic Lateral Sclerosis (ALS / Lou Gehrig Disease) to extend survival and time to tracheostomy or mechanical ventilation.",
            doses = "Adult: 50 mg PO twice daily (every 12 hours) on an empty stomach. Available as oral tablets or oral suspension (50mg/10mL).",
            administration = "Take on an empty stomach (at least 1 hour before or 2 hours after a meal) to optimize bioavailability. High-fat meals reduce AUC by 20%.",
            timing = "q12h on empty stomach.",
            specialInstructions = "Monitor serum transaminases (ALT/AST) monthly for the first 3 months, every 3 months for the remainder of the first year, and periodically thereafter. Discontinue if ALT exceeds 5x ULN.",
            pkPd = "Bioavailability ~60%. Highly protein bound (96%). Hepatic metabolism primarily by CYP1A2; elimination half-life ~12 hours. Inhibits voltage-gated sodium channels and presynaptic glutamate exocytosis.",
            renalAdj = "No adjustment needed for mild to moderate renal impairment; avoid in severe renal disease.",
            hepaticAdj = "Contraindicated in baseline transaminases >3x ULN or active hepatic disease.",
            pregnancy = "Category C (Use only if maternal benefit clearly outweighs fetal neurodevelopmental risk).",
            lactation = "Excreted in animal milk; breastfeeding not recommended.",
            sideEffects = "Fatigue, nausea, dizziness, circumoral paresthesia, somnolence, elevated ALT/AST, neutropenia (rare; check CBC if febrile).",
            priceNpr = "NPR 140.00 - 220.00 per tab (50mg)",
            priceInr = "INR 85.00 - 150.00 per tab (50mg)",
            brandsNepal = listOf(
                BrandInfo("Rilutek", "Sanofi Aventis Global", "Tablet", "50 mg"),
                BrandInfo("Rilutor", "Sun Pharma Special Access", "Tablet", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Rilutek", "Sanofi India", "Tablet", "50 mg"),
                BrandInfo("Rilutor", "Sun Pharma", "Tablet", "50 mg"),
                BrandInfo("Riluzole-Cipla", "Cipla Ltd.", "Tablet", "50 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "50 mg PO BID",
            childDose = "Not established in pediatric populations",
            contraindications = "Severe hepatic disease or transaminases >3x ULN.",
            modeOfAction = "Inactivates voltage-dependent sodium channels, stimulates glutamate uptake, and blocks postsynaptic NMDA/kainate receptor transmission.",
            interactions = "CYP1A2 inhibitors (Ciprofloxacin, Fluvoxamine - increases riluzole levels); CYP1A2 inducers (Rifampin, Omeprazole, smoking - decreases levels).",
            nemlCategory = "Specialized Neuromuscular Orphan Formulary",
            ddaSchedule = "Schedule Kha (Neurologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Randomized controlled trials confirm extension of tracheostomy-free survival by 2 to 3 months in definite ALS."
        ),

        // 4. Edaravone (ALS & Acute Ischemic Stroke)
        Drug(
            id = "d_rare_edaravone",
            genericName = "Edaravone",
            system = "Central Nervous System (CNS)",
            drugClass = "Free Radical Scavenger / Neuroprotective Antioxidant",
            blackBoxWarning = "HYPERSENSITIVITY & SULFITE ALLERGY: Contains sodium bisulfite, which may cause life-threatening anaphylactic reactions or severe asthmatic episodes in susceptible individuals. Monitor during and after infusion.",
            indications = "Amyotrophic Lateral Sclerosis (ALS) to slow decline of physical functioning (ALSFRS-R score decline), Acute ischemic stroke within 24 hours of symptom onset.",
            doses = "ALS Initial Cycle: 60 mg IV infusion over 60 minutes once daily for 14 days, followed by 14-day drug-free interval. Subsequent Cycles: 60 mg IV once daily for 10 out of 14 days, followed by 14-day drug-free interval. (Also available as oral suspension 105mg OD).",
            administration = "Administer IV over 60 minutes via peripheral or central line. Do not mix with other intravenous medications.",
            timing = "Infuse over 60 minutes daily.",
            specialInstructions = "Check baseline renal function (BUN/creatinine) and allergy history to sulfites. Protect infusion bags from light.",
            pkPd = "Volume of distribution ~12 L. Primarily glucuronidated and sulfated in liver; renal excretion >70% as metabolites. Half-life ~4.5 to 6 hours. Scavenges peroxyl and hydroxyl radicals.",
            renalAdj = "Severe renal impairment (eGFR <30 mL/min): Contraindicated (high risk of acute renal failure).",
            hepaticAdj = "No specific adjustment in mild impairment; monitor in severe hepatic dysfunction.",
            pregnancy = "Category C (Limited human data; use only if potential benefit justifies potential fetal risk).",
            lactation = "Present in animal milk; discontinue nursing or avoid medication.",
            sideEffects = "Contusion, gait disturbance, headache, dyspnea, dermatitis, glycosuria, acute kidney injury.",
            priceNpr = "NPR 1800.00 - 2800.00 per ampoule/vial (30mg)",
            priceInr = "INR 1100.00 - 1800.00 per vial (30mg)",
            brandsNepal = listOf(
                BrandInfo("Radicava", "Mitsubishi Tanabe Pharma Import", "IV Vial", "30 mg / 100 mL"),
                BrandInfo("Edarac", "Sun Pharma Special Access", "IV Vial", "30 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Radicava", "Mitsubishi Tanabe / RPG", "IV Vial", "30 mg / 100 mL"),
                BrandInfo("Edarac", "Sun Pharma", "IV Inj", "30 mg"),
                BrandInfo("Edarvon", "Torrent Pharmaceuticals", "IV Inj", "30 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "60 mg IV OD in cycles of 14d on / 14d off",
            childDose = "Safety and efficacy not established in children",
            contraindications = "Severe renal impairment, hypersensitivity to edaravone or sodium bisulfite.",
            modeOfAction = "Eliminates lipid peroxides and hydroxyl radicals, attenuating neuronal oxidative damage, mitochondrial dysfunction, and motor neuron apoptosis.",
            interactions = "Potentiates nephrotoxicity when co-administered with Cefazolin or other nephrotoxic cephalosporins/aminoglycosides.",
            nemlCategory = "Specialized Neuromuscular Orphan Formulary",
            ddaSchedule = "Schedule Kha (Neurologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "MCI-186 ALS Study demonstrated a 33% reduction in the rate of decline of ALSFRS-R functional score over 24 weeks."
        ),

        // 5. Risdiplam (Spinal Muscular Atrophy - SMA)
        Drug(
            id = "d_rare_risdiplam",
            genericName = "Risdiplam",
            system = "Central Nervous System (CNS)",
            drugClass = "Survival Motor Neuron 2 (SMN2) Splicing Modifier (Orphan Drug)",
            blackBoxWarning = null,
            indications = "Spinal Muscular Atrophy (SMA) due to mutations in chromosome 5q in pediatric and adult patients (Type 1, 2, and 3 SMA).",
            doses = "Adults & Children >=2 yr (weight >=20 kg): 5 mg PO once daily.\nChildren >=2 yr (weight <20 kg): 0.25 mg/kg PO once daily.\nInfants 2 months to <2 yr: 0.20 mg/kg PO once daily.\nNeonates <2 months: 0.15 mg/kg PO once daily.",
            administration = "Administer orally once daily after a meal using the provided oral syringe. Administer immediately after reconstitution or within 64 days of reconstitution if kept refrigerated (2°C-8°C).",
            timing = "Once daily after meals (consistent time).",
            specialInstructions = "Reconstitute with purified water only by pharmacist. Must be protected from light and kept refrigerated. Do not mix with milk or formula.",
            pkPd = "Oral bioavailability ~100%. Volume of distribution ~6.3 L/kg. Extensively metabolized by FMO1, FMO3, and CYP3A. Elimination half-life ~50 hours. Passes blood-brain barrier readily.",
            renalAdj = "No dosage adjustment required for mild to moderate renal impairment.",
            hepaticAdj = "No adjustment for mild to moderate hepatic impairment; not studied in severe hepatic impairment.",
            pregnancy = "Contraindicated / Teratogenic (Causes embryofetal lethality and structural malformations; strict contraception required in females and males during and for 4 months post-therapy).",
            lactation = "Breastfeeding not recommended due to potential severe adverse effects on infant development.",
            sideEffects = "Fever (pyrexia), diarrhea, rash, upper respiratory tract infection, aphthous ulcers, arthralgia, reversible retinal toxicity (rare, monitored).",
            priceNpr = "NPR 180000.00 - 320000.00 per bottle (60mg/80mL)",
            priceInr = "INR 120000.00 - 240000.00 per bottle (60mg)",
            brandsNepal = listOf(
                BrandInfo("Evrysdi", "Roche Pharmaceuticals Global Access", "Oral Solution", "0.75 mg/mL (60mg vial)")
            ),
            brandsIndia = listOf(
                BrandInfo("Evrysdi", "Roche India / Patient Access Program", "Oral Solution", "0.75 mg/mL (60mg/80mL)")
            ),
            pediatricDosePerKg = 0.20,
            pediatricInterval = "once daily",
            adultDose = "5 mg PO once daily",
            childDose = "0.20 - 0.25 mg/kg PO once daily per age/weight tier",
            contraindications = "Hypersensitivity to risdiplam, pregnancy.",
            modeOfAction = "Binds SMN2 pre-mRNA to promote inclusion of exon 7, resulting in full-length functional SMN protein across both central and peripheral motor neuron systems.",
            interactions = "Substrates of MATE1/MATE2-K (e.g. Metformin - risdiplam may increase metformin exposure).",
            nemlCategory = "WHO Essential Medicines for Rare Neuromuscular Diseases",
            ddaSchedule = "Schedule Ka (Specialist Geneticist/Pediatric Neurologist)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "FIREFISH and SUNFISH clinical trials demonstrated significant improvement in motor milestones and survival free of permanent ventilation."
        ),

        // 6. Imiglucerase (Gaucher Disease Type 1)
        Drug(
            id = "d_rare_imiglucerase",
            genericName = "Imiglucerase",
            system = "Endocrine & Metabolic System",
            drugClass = "Recombinant Human beta-Glucocerebrosidase (Enzyme Replacement Therapy - ERT)",
            blackBoxWarning = "ANAPHYLAXIS & INFUSION REACTIONS: Life-threatening hypersensitivity and anaphylaxis can occur. Antihistamines, corticosteroids, and epinephrine must be immediately available during IV administration. Monitor for IgG anti-imiglucerase antibody formation.",
            indications = "Type 1 Gaucher Disease with anemia, thrombocytopenia, hepatosplenomegaly, or bone disease (osteopenia, avascular necrosis, bone crises).",
            doses = "Initial Dose: 60 units/kg IV infusion every 2 weeks. Maintenance Dose: 15 to 30 units/kg IV every 2 weeks once hematologic and visceral goals are achieved. Infuse over 1 to 2 hours.",
            administration = "Administer as IV infusion over 1-2 hours using an in-line low-protein-binding filter (0.2 or 0.22 micron). Premedicate with antihistamines/paracetamol in patients with history of mild infusion reactions.",
            timing = "q2 weeks IV infusion.",
            specialInstructions = "Reconstitute with sterile water for injection; do not shake vigorously. Store unopened vials refrigerated at 2°C to 8°C.",
            pkPd = "Rapidly targeted to macrophage mannose receptors on Kupffer cells and splenic macrophages. Steady-state elimination half-life ~3.6 to 10.4 minutes. Cleaves toxic glucocerebroside into glucose and ceramide.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No dose adjustment required (reverses Gaucher hepatosplenomegaly).",
            pregnancy = "Category B (Safe; continuing ERT prevents clinical relapses, bone crises, and severe gestational thrombocytopenia).",
            lactation = "Compatible with breastfeeding (protein molecule degraded in infant GI tract).",
            sideEffects = "Infusion-site reaction, fever, chills, pruritus, urticaria, headache, nausea, abdominal cramps, transient hypertension.",
            priceNpr = "NPR 95000.00 - 150000.00 per vial (400 Units)",
            priceInr = "INR 65000.00 - 110000.00 per vial (400 Units)",
            brandsNepal = listOf(
                BrandInfo("Cerezyme", "Sanofi Genzyme International Access", "IV Vial", "400 Units lyophilized")
            ),
            brandsIndia = listOf(
                BrandInfo("Cerezyme", "Sanofi Genzyme India", "IV Vial", "200 U / 400 U")
            ),
            pediatricDosePerKg = 60.0,
            pediatricInterval = "every 2 weeks IV",
            adultDose = "60 Units/kg IV every 2 weeks",
            childDose = "60 Units/kg IV every 2 weeks",
            contraindications = "Severe life-threatening anaphylactic reaction to imiglucerase.",
            modeOfAction = "Supplements deficient endogenous beta-glucocerebrosidase, hydrolyzing glucosylceramide accumulated inside reticuloendothelial macrophages (Gaucher cells).",
            interactions = "No clinically significant pharmacokinetic interactions reported.",
            nemlCategory = "WHO Model List of Essential Medicines (Rare Inborn Errors of Metabolism)",
            ddaSchedule = "Schedule Ka (Specialist Hematologist/Metabolic Physician)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "First-in-class ERT reversing hepatosplenomegaly and hematologic cytopenias while preventing irreversible osteonecrosis."
        ),

        // 7. Agalsidase Beta (Fabry Disease)
        Drug(
            id = "d_rare_agalsidase_beta",
            genericName = "Agalsidase Beta",
            system = "Endocrine & Metabolic System",
            drugClass = "Recombinant Human alpha-Galactosidase A (Enzyme Replacement Therapy - ERT)",
            blackBoxWarning = "SEVERE INFUSION-ASSOCIATED REACTIONS: Life-threatening anaphylaxis and severe infusion reactions occur in up to 50% of patients. Pretreatment with paracetamol, antihistamines, and/or oral corticosteroids is mandatory prior to every infusion.",
            indications = "Fabry Disease (X-linked alpha-galactosidase A deficiency) to reduce globotriaosylceramide (GL-3) accumulation in vascular endothelium of kidney, heart, and skin.",
            doses = "Adults & Pediatrics >=2 yr: 1.0 mg/kg IV infusion every 2 weeks. Initial infusion rate <=0.25 mg/min (15 mg/h); may be gradually accelerated in subsequent infusions as tolerated.",
            administration = "Administer IV over 2 to 4 hours with an in-line 0.2 micron low-protein-binding filter. Do not infuse with other medications.",
            timing = "q2 weeks IV infusion.",
            specialInstructions = "Always administer prophylactic paracetamol 500-1000mg + antihistamine (Cetirizine 10mg) 30-60 minutes prior to infusion. Monitor for proteinuria and cardiac MRI / LFTs.",
            pkPd = "Elimination half-life ~45 to 102 minutes. Mannose-6-phosphate residues direct the enzyme to lysosomal compartments of endothelial and parenchymal cells. Cleaves terminal alpha-galactosyl residues.",
            renalAdj = "No dose adjustment required. Slows progression of Fabry nephropathy and proteinuria.",
            hepaticAdj = "No dose adjustment needed.",
            pregnancy = "Category B (Continue therapy if indicated; active Fabry disease during pregnancy carries severe microvascular and pre-eclampsia risks).",
            lactation = "Excretion in human milk unknown; use with caution.",
            sideEffects = "Infusion reactions (rigors, fever, diaphoresis, dyspnea), hypertension, paresthesias, nausea, abdominal pain, neutralizing IgG antibodies.",
            priceNpr = "NPR 140000.00 - 240000.00 per vial (35mg)",
            priceInr = "INR 95000.00 - 160000.00 per vial (35mg)",
            brandsNepal = listOf(
                BrandInfo("Fabrazyme", "Sanofi Genzyme International", "IV Vial", "35 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Fabrazyme", "Sanofi India Rare Disease Division", "IV Vial", "35 mg")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "every 2 weeks IV",
            adultDose = "1 mg/kg IV every 2 weeks",
            childDose = "1 mg/kg IV every 2 weeks",
            contraindications = "History of life-threatening hypersensitivity to agalsidase beta.",
            modeOfAction = "Enzymatically clears globotriaosylceramide (GL-3) deposits from renal podocytes, vascular endothelial cells, and myocardial lysosomes.",
            interactions = "Avoid chloroquine, amiodarone, monensin, and gentamicin (inhibits intracellular lysosomal alpha-galactosidase activity).",
            nemlCategory = "WHO Specialized Orphan Formulary",
            ddaSchedule = "Schedule Ka (Specialist Nephrologist/Geneticist)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Randomized trials demonstrate complete clearance of GL-3 from renal capillary endothelium in 69% of patients."
        ),

        // 8. Eculizumab (Paroxysmal Nocturnal Hemoglobinuria & Atypical HUS)
        Drug(
            id = "d_rare_eculizumab",
            genericName = "Eculizumab",
            system = "Central Nervous System (CNS)",
            drugClass = "Recombinant Humanized Monoclonal Antibody (Terminal Complement C5 Inhibitor)",
            blackBoxWarning = "SERIOUS MENINGOCOCCAL INFECTIONS: Eculizumab increases the risk of life-threatening and fatal meningococcal infections (Neisseria meningitidis) by 1,000 to 2,000-fold. Vaccinate with meningococcal conjugate (MenACWY) and serogroup B (MenB) vaccines at least 2 weeks prior to initiating therapy. If urgent therapy is required before 2 weeks, initiate antibacterial prophylaxis (Ciprofloxacin or Penicillin V) immediately.",
            indications = "Paroxysmal Nocturnal Hemoglobinuria (PNH) with active hemolysis, Atypical Hemolytic Uremic Syndrome (aHUS) to inhibit complement-mediated thrombotic microangiopathy, Generalized Myasthenia Gravis (gMG) in anti-AChR antibody-positive patients, Neuromyelitis Optica Spectrum Disorder (NMOSD) in anti-AQP4 positive patients.",
            doses = "PNH Dosing: Induction 600 mg IV weekly for 4 weeks, followed by 900 mg for the 5th week, then 900 mg IV every 2 weeks maintenance.\naHUS / gMG Dosing: Induction 900 mg IV weekly for 4 weeks, followed by 1200 mg for 5th week, then 1200 mg IV every 2 weeks maintenance.",
            administration = "Administer as IV infusion over 35 minutes via peripheral or central line. Dilute in 0.9% NaCl to a final concentration of 5 mg/mL.",
            timing = "q2 weeks IV maintenance.",
            specialInstructions = "Verify patient possesses a Patient Safety Card. Advise to immediately report fever >=38°C, stiff neck, headache, or petechial rash. Give antimicrobial prophylaxis if vaccines pending.",
            pkPd = "Volume of distribution ~5 to 8 L. Clearance ~0.31 mL/h/kg; elimination half-life ~11 days. Binds specifically to complement protein C5 with high affinity, preventing cleavage into C5a and C5b.",
            renalAdj = "No dose adjustment required. Reverses renal failure in aHUS.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category C (Human pregnancy registries demonstrate maternal and fetal survival without embryofetal toxicities; untreated PNH carries massive maternal mortality from hepatic vein thrombosis).",
            lactation = "Negligible transfer into breast milk; considered compatible with breastfeeding.",
            sideEffects = "Headache, nasopharyngitis, back pain, nausea, hypertension, meningococcal sepsis, upper respiratory infections.",
            priceNpr = "NPR 380000.00 - 620000.00 per vial (300mg/30mL)",
            priceInr = "INR 250000.00 - 450000.00 per vial (300mg)",
            brandsNepal = listOf(
                BrandInfo("Soliris", "Alexion Pharmaceuticals Import", "IV Vial", "300 mg / 30 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Soliris", "Alexion / AstraZeneca India", "IV Vial", "300 mg / 30 mL")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = "Dosed according to weight-tiered protocol",
            adultDose = "Induction 600-900 mg weekly x 4, then 900-1200 mg q2w",
            childDose = "Weight-tiered dosing protocol per package insert",
            contraindications = "Unresolved Neisseria meningitidis infection, patients not currently vaccinated against meningococcal disease unless prophylactic antibiotics are administered.",
            modeOfAction = "Blocks cleavage of C5 into proinflammatory anaphylatoxin C5a and C5b, stopping membrane attack complex (MAC / C5b-9) assembly and terminal intravascular hemolysis.",
            interactions = "No documented cytochrome P450 interactions. Plasma exchange or IVIG can decrease eculizumab circulating levels; supplementary dose required.",
            nemlCategory = "WHO Model List of Specialized Rare Disease Medicines",
            ddaSchedule = "Schedule Ka (Specialist Hematologist / Nephrologist)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Transformed PNH and aHUS from fatal thrombotic diseases to manageable chronic conditions with normal life expectancy."
        ),

        // 9. C1-Esterase Inhibitor [Human] (Hereditary Angioedema - HAE)
        Drug(
            id = "d_rare_c1_inh",
            genericName = "C1-Esterase Inhibitor [Human]",
            system = "Respiratory System (RS)",
            drugClass = "Plasma-Derived C1-Inhibitor (Serine Protease Inhibitor - Serpin)",
            blackBoxWarning = null,
            indications = "Treatment of acute abdominal, facial, or laryngeal angioedema attacks in adult and pediatric patients with Hereditary Angioedema (HAE Type I and Type II); Routine prophylaxis against HAE attacks.",
            doses = "Acute Attack Treatment (Berinert): 20 International Units/kg IV push slowly over 5 minutes.\nRoutine Prophylaxis (Cinryze): 1000 Units IV twice weekly (every 3 or 4 days).",
            administration = "Administer intravenously by slow injection over approximately 5 to 10 minutes at an infusion rate of 4 mL/minute. Reconstitute using the provided mix2vial transfer device.",
            timing = "Immediately at onset of acute HAE attack.",
            specialInstructions = "For laryngeal attacks, administer immediately and secure airway; seek emergency medical care. Self-administration training is recommended for patients.",
            pkPd = "Volume of distribution ~3 to 4 L. Terminal elimination half-life ~30 to 56 hours. Restores functional levels of C1-INH to suppress bradykinin generation via plasma kallikrein and Factor XIIa.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category C (First-line choice for acute HAE attacks during pregnancy and labor; excellent safety record).",
            lactation = "Compatible with breastfeeding.",
            sideEffects = "Dysgeusia, headache, nausea, diarrhea, abdominal pain, hypersensitivity, thrombotic events (rare, with supratherapeutic dosing).",
            priceNpr = "NPR 85000.00 - 145000.00 per vial (500 Units)",
            priceInr = "INR 55000.00 - 95000.00 per vial (500 Units)",
            brandsNepal = listOf(
                BrandInfo("Berinert", "CSL Behring Global Import", "IV Injection", "500 Units / 1500 Units"),
                BrandInfo("Cinryze", "Takeda Rare Disease", "IV Injection", "500 Units")
            ),
            brandsIndia = listOf(
                BrandInfo("Berinert", "CSL Behring India", "IV Inj", "500 Units"),
                BrandInfo("Cinryze", "Shire / Takeda India", "IV Inj", "500 Units")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "single IV push at attack onset",
            adultDose = "20 IU/kg IV slow push for acute attacks",
            childDose = "20 IU/kg IV slow push for acute attacks",
            contraindications = "Life-threatening hypersensitivity to C1-INH preparations.",
            modeOfAction = "Inactivates Factor XIIa, kallikrein, and C1r/C1s, preventing high-molecular-weight kininogen (HMWK) cleavage into vasoactive bradykinin.",
            interactions = "No clinically significant drug interactions.",
            nemlCategory = "WHO Essential Medicines (Emergency Orphan Formulary)",
            ddaSchedule = "Schedule Ka (Specialist Immunologist / Emergency Medicine)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Relieves severe asphyxiating laryngeal edema within 30 minutes; standard-of-care across global WAO/EAACI guidelines."
        ),

        // 10. Bosentan (Pulmonary Arterial Hypertension - PAH)
        Drug(
            id = "d_rare_bosentan",
            genericName = "Bosentan",
            system = "Cardiovascular System (CVS)",
            drugClass = "Dual Endothelin Receptor Antagonist (ERA: ETA and ETB)",
            blackBoxWarning = "HEPATOTOXICITY & EMBRYO-FETAL TOXICITY: Bosentan causes severe liver injury (transaminases >=3x ULN in 11% of patients). Measure liver transaminases (ALT/AST) prior to initiation and monthly thereafter. Major teratogen: strictly contraindicated in pregnancy; monthly pregnancy testing is mandatory in females of reproductive potential.",
            indications = "Pulmonary Arterial Hypertension (PAH; WHO Group 1) to improve exercise ability and decrease rate of clinical worsening (NYHA/WHO functional class II, III, and IV).",
            doses = "Adult: Initial 62.5 mg PO twice daily for 4 weeks; if tolerated and LFTs normal, titrate to maintenance dose of 125 mg PO twice daily.\nPediatrics: Weight-adjusted dosing (10-20 kg: 31.25 mg BID; 20-40 kg: 62.5 mg BID).",
            administration = "Take orally morning and evening, with or without food. Swallow tablets with water.",
            timing = "Morning and evening (q12h).",
            specialInstructions = "Check baseline LFTs and hemoglobin. If transaminases rise 3-5x ULN, reduce dose or interrupt therapy and re-check biweekly.",
            pkPd = "Oral bioavailability ~50%. Highly protein-bound (>98%). Extensively metabolized in liver by CYP2C9 and CYP3A4 into three metabolites; auto-induces its own metabolism. Half-life ~5 hours.",
            renalAdj = "No dose adjustment required in mild to severe renal impairment or hemodialysis.",
            hepaticAdj = "Moderate to severe hepatic impairment (Child-Pugh B or C): Contraindicated.",
            pregnancy = "Category X (Strictly contraindicated; teratogenic in all animal studies with craniofacial and cardiovascular malformations).",
            lactation = "Excreted in milk; breastfeeding contraindicated.",
            sideEffects = "Elevated ALT/AST, peripheral edema, fluid retention, headache, nasopharyngitis, flushing, anemia (decreased hemoglobin), syncope.",
            priceNpr = "NPR 110.00 - 180.00 per tab (62.5mg / 125mg)",
            priceInr = "INR 70.00 - 120.00 per tab (62.5mg / 125mg)",
            brandsNepal = listOf(
                BrandInfo("Bosentas", "Deurali-Janta Pharmaceuticals", "Tablet", "62.5 mg / 125 mg"),
                BrandInfo("Lupibose", "Lupin Special Access", "Tablet", "62.5 mg / 125 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tracleer", "Actelion / Janssen", "Tablet", "62.5 mg / 125 mg"),
                BrandInfo("Bosentas", "Cipla Ltd.", "Tablet", "62.5 mg / 125 mg"),
                BrandInfo("Lupibose", "Lupin Ltd.", "Tablet", "62.5 mg / 125 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = "Weight-tiered BID dosing",
            adultDose = "62.5 mg BID x 4 weeks, then 125 mg BID",
            childDose = "Weight-tiered dosing for PAH",
            contraindications = "Pregnancy, moderate-severe hepatic impairment, concomitant Cyclosporine A or Glyburide.",
            modeOfAction = "Competitive antagonist at endothelin-A (ETA) and endothelin-B (ETB) receptors in pulmonary vascular smooth muscle, reversing pulmonary vasoconstriction and vascular remodeling.",
            interactions = "Cyclosporine A (increases bosentan level 3-4x; contraindicated); Glyburide (increased hepatotoxicity; contraindicated); Ketoconazole, hormonal contraceptives (reduced contraceptive efficacy).",
            nemlCategory = "Specialized Cardiology & Pulmonary Orphan Drug",
            ddaSchedule = "Schedule Kha (Cardiologist / Pulmonologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Pivotal BREATHE-1 trial proved significant improvement in 6-minute walk distance and prolonged time to clinical worsening in PAH."
        ),

        // 11. Tafamidis Meglumine (Transthyretin Amyloidosis - ATTR-CM & ATTR-PN)
        Drug(
            id = "d_rare_tafamidis",
            genericName = "Tafamidis Meglumine",
            system = "Cardiovascular System (CVS)",
            drugClass = "Transthyretin (TTR) Kinetic Stabilizer (Orphan Drug)",
            blackBoxWarning = null,
            indications = "Transthyretin-mediated Amyloidosis Cardiomyopathy (ATTR-CM, wild-type or hereditary) to reduce cardiovascular mortality and cardiovascular-related hospitalization; Familial Amyloid Polyneuropathy (ATTR-PN stage 1).",
            doses = "ATTR-CM: 61 mg PO once daily (Tafamidis free acid / Vyndamax) OR 80 mg PO once daily (Tafamidis meglumine 4 x 20mg capsules / Vyndaqel).\nATTR-PN: 20 mg PO once daily.",
            administration = "Swallow capsules whole with or without food. Do not crush, cut, or chew.",
            timing = "Once daily (morning).",
            specialInstructions = "Perform baseline echocardiography (longitudinal strain apical sparing), serum cardiac biomarkers (NT-proBNP, Troponin T), and 99mTc-PYP scintigraphy to confirm ATTR amyloidosis.",
            pkPd = "Oral bioavailability high. Highly bound to plasma proteins (>99%). Elimination half-life ~49 hours. Negligible renal excretion; primarily eliminated via biliary/fecal route.",
            renalAdj = "No dosage adjustment needed for renal impairment or hemodialysis.",
            hepaticAdj = "No dosage adjustment in mild to moderate hepatic impairment; not studied in severe impairment.",
            pregnancy = "Category C (Based on animal data, may cause fetal harm; effective contraception recommended).",
            lactation = "Present in animal milk; discontinue nursing or avoid medication.",
            sideEffects = "Diarrhea, urinary tract infection, abdominal pain, headache, peripheral edema, asthenia (overall remarkably well tolerated compared to older options).",
            priceNpr = "NPR 18000.00 - 32000.00 per strip of 30 caps (20mg)",
            priceInr = "INR 12000.00 - 22000.00 per strip (20mg)",
            brandsNepal = listOf(
                BrandInfo("Vyndamax", "Pfizer Rare Disease Global Access", "Capsule", "61 mg"),
                BrandInfo("Vyndaqel", "Pfizer Global Access", "Capsule", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Vyndamax", "Pfizer India Rare Disease", "Capsule", "61 mg"),
                BrandInfo("Vyndaqel", "Pfizer India", "Capsule", "20 mg"),
                BrandInfo("Tafacard", "Cipla Rare Therapeutics", "Capsule", "20 mg / 61 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "61 mg PO OD (Vyndamax) or 80 mg PO OD (Vyndaqel)",
            childDose = "Safety and efficacy not established in pediatric patients",
            contraindications = "Hypersensitivity to tafamidis or any excipients.",
            modeOfAction = "Selectively binds to the two thyroxine-binding sites on the native tetrameric transthyretin (TTR) protein, preventing its dissociation into amyloidogenic monomers.",
            interactions = "Substrates of BCRP (e.g. Rosuvastatin, Methotrexate - tafamidis may increase plasma exposure).",
            nemlCategory = "WHO Model List of Essential Medicines (Specialized Amyloidosis)",
            ddaSchedule = "Schedule Ka (Specialist Cardiologist / Neurologist)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "ATTR-ACT clinical trial demonstrated a 30% reduction in all-cause mortality and 32% reduction in cardiovascular hospitalizations."
        ),

        // 12. Pirfenidone (Idiopathic Pulmonary Fibrosis - IPF)
        Drug(
            id = "d_rare_pirfenidone",
            genericName = "Pirfenidone",
            system = "Respiratory System (RS)",
            drugClass = "Antifibrotic & Anti-Inflammatory Pyridone Agent",
            blackBoxWarning = null,
            indications = "Idiopathic Pulmonary Fibrosis (IPF) to reduce the decline in forced vital capacity (FVC) and slow disease progression.",
            doses = "Adult Titration: Days 1-7: 267 mg PO TID (801 mg/day) with food. Days 8-14: 534 mg PO TID (1602 mg/day). Days 15 onwards (Maintenance): 801 mg PO TID (2403 mg/day) with meals.",
            administration = "Take orally with meals to reduce nausea, dyspepsia, and dizziness. Do not take with grapefruit juice.",
            timing = "TID with breakfast, lunch, and dinner.",
            specialInstructions = "Photosensitivity warning: Avoid direct sun exposure; apply SPF 50+ sunscreen and wear protective clothing daily. Monitor liver enzymes (ALT/AST, bilirubin) prior to initiation, monthly for 6 months, and every 3 months thereafter.",
            pkPd = "Bioavailability ~80%. Moderately protein-bound (~58%). Extensively metabolized in liver primarily by CYP1A2 (>48%). Renal excretion of metabolites (~80%). Elimination half-life ~3 hours.",
            renalAdj = "Mild to moderate (CrCl 30-80 mL/min): Use caution. Severe renal impairment (CrCl <30 mL/min) or ESRD: Contraindicated.",
            hepaticAdj = "Mild to moderate hepatic impairment (Child-Pugh A or B): Monitor closely. Severe hepatic impairment (Child-Pugh C): Contraindicated.",
            pregnancy = "Category C (Limited human data; weigh maternal benefit vs fetal growth risks).",
            lactation = "Present in animal milk; not recommended during lactation.",
            sideEffects = "Nausea, dyspepsia, anorexia, weight loss, skin photosensitivity / rash, fatigue, insomnia, elevated transaminases.",
            priceNpr = "NPR 45.00 - 85.00 per tab (200mg / 400mg)",
            priceInr = "INR 28.00 - 55.00 per tab (200mg / 400mg)",
            brandsNepal = listOf(
                BrandInfo("Pirfenex", "Cipla Nepal", "Tablet", "200 mg / 400 mg"),
                BrandInfo("Fibrodone", "Deurali-Janta Pharmaceuticals", "Tablet", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pirfenex", "Cipla Ltd.", "Tablet", "200 mg / 400 mg / 800 mg"),
                BrandInfo("Esbriet", "Genentech / Roche", "Tablet", "267 mg / 801 mg"),
                BrandInfo("Pulmopirf", "Sun Pharma", "Tablet", "200 mg / 400 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "Titrate to 801 mg PO TID (2403 mg/day) with food",
            childDose = "Safety and efficacy not established in children",
            contraindications = "Severe hepatic impairment, end-stage renal disease (CrCl <30 mL/min), concomitant Fluvoxamine.",
            modeOfAction = "Inhibits TGF-beta synthesis and downstream Smad signaling, suppressing collagen synthesis and extracellular matrix deposition in pulmonary fibroblasts.",
            interactions = "Strong CYP1A2 inhibitors (Fluvoxamine - increases pirfenidone 6-fold; strictly contraindicated); Ciprofloxacin (increases pirfenidone; reduce dose); smoking (induces CYP1A2, reduces efficacy).",
            nemlCategory = "Specialized Respiratory Formulary",
            ddaSchedule = "Schedule Kha (Pulmonologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "CAPACITY and ASCEND clinical trials showed significant reduction in 1-year FVC decline and 48% reduction in risk of death."
        ),

        // 13. Nintedanib (IPF & Systemic Sclerosis-ILD)
        Drug(
            id = "d_rare_nintedanib",
            genericName = "Nintedanib",
            system = "Respiratory System (RS)",
            drugClass = "Triple Intracellular Tyrosine Kinase Inhibitor (VEGFR, FGFR, PDGFR)",
            blackBoxWarning = "EMBRYO-FETAL TOXICITY & ARTERIAL THROMBOEMBOLISM: Nintedanib causes fetal harm and loss of pregnancy; effective contraception is mandatory during and for 3 months post-therapy. Increased risk of arterial thromboembolism (myocardial infarction) and gastrointestinal perforation.",
            indications = "Idiopathic Pulmonary Fibrosis (IPF), Chronic progressive fibrosing Interstitial Lung Diseases (PPF-ILD), Systemic Sclerosis-associated Interstitial Lung Disease (SSc-ILD).",
            doses = "Adult: 150 mg PO twice daily (every 12 hours) with food. If not tolerated due to diarrhea or elevated transaminases, reduce to 100 mg PO twice daily or temporarily interrupt.",
            administration = "Take orally with food approximately 12 hours apart. Swallow capsules whole with liquid; do not open, crush, or chew.",
            timing = "q12h with meals (breakfast & dinner).",
            specialInstructions = "Manage diarrhea aggressively at first onset with hydration and Loperamide. Check baseline liver tests (ALT, AST, bilirubin) prior to initiation, monthly for 3 months, and periodically thereafter.",
            pkPd = "Bioavailability ~4.7%. Extensively metabolized by intracellular esterases followed by glucuronidation (UGT1A1); minor CYP3A4 pathway. Primary elimination via biliary/fecal route (93%). Half-life ~9.5 hours.",
            renalAdj = "No adjustment in mild to moderate renal impairment; not studied in severe impairment.",
            hepaticAdj = "Mild impairment (Child-Pugh A): Reduce dose to 100 mg PO BID. Moderate to severe (Child-Pugh B or C): Contraindicated.",
            pregnancy = "Category D / Black Box (Major teratogen; strict contraception required).",
            lactation = "Excreted in animal milk; discontinue nursing.",
            sideEffects = "Diarrhea (up to 62%), nausea, vomiting, abdominal pain, weight loss, elevated transaminases, arterial thromboembolic events, GI perforation.",
            priceNpr = "NPR 180.00 - 320.00 per soft cap (100mg / 150mg)",
            priceInr = "INR 110.00 - 190.00 per soft cap (100mg / 150mg)",
            brandsNepal = listOf(
                BrandInfo("Cyndat", "Cipla Nepal", "Soft Capsule", "100 mg / 150 mg"),
                BrandInfo("Nindanib", "Sun Pharma Special Access", "Soft Capsule", "150 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ofev", "Boehringer Ingelheim", "Soft Capsule", "100 mg / 150 mg"),
                BrandInfo("Cyndat", "Cipla Ltd.", "Soft Capsule", "100 mg / 150 mg"),
                BrandInfo("Nindanib", "Glenmark Pharmaceuticals", "Soft Capsule", "100 mg / 150 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "150 mg PO BID with food (or 100 mg BID for intolerance)",
            childDose = "Safety and efficacy not established in pediatric patients",
            contraindications = "Pregnancy, moderate-severe hepatic impairment (Child-Pugh B/C), active arterial bleeding.",
            modeOfAction = "Competitively binds the ATP-binding pocket of vascular endothelial growth factor receptors (VEGFR 1-3), fibroblast growth factor receptors (FGFR 1-3), and platelet-derived growth factor receptors (PDGFR alpha/beta), blocking downstream fibrotic cascades.",
            interactions = "P-gp and CYP3A4 inhibitors (Ketoconazole - increases nintedanib); P-gp inducers (Rifampin, St. John's Wort - decreases nintedanib); Anticoagulants (increased bleeding risk).",
            nemlCategory = "Specialized Respiratory Orphan Drug",
            ddaSchedule = "Schedule Kha (Pulmonologist / Rheumatologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "INPULSIS and SENSCIS trials proved a 50% relative reduction in the annual rate of decline in FVC in IPF and SSc-ILD."
        ),

        // 14. Elexacaftor + Tezacaftor + Ivacaftor (Trikafta - Cystic Fibrosis)
        Drug(
            id = "d_rare_trikafta",
            genericName = "Elexacaftor + Tezacaftor + Ivacaftor",
            system = "Respiratory System (RS)",
            drugClass = "Next-Generation CFTR Correctors + Potentiator (Triple Combination Orphan Drug)",
            blackBoxWarning = null,
            indications = "Cystic Fibrosis (CF) in patients aged 2 years and older who have at least one F508del mutation in the CFTR gene (or a responsive mutation).",
            doses = "Adults & Adolescents (>=12 yr): Morning: 2 fixed-dose combination tablets (each containing Elexacaftor 100mg + Tezacaftor 50mg + Ivacaftor 75mg). Evening (approximately 12h later): 1 Ivacaftor 150mg tablet with fat-containing food.\nPediatrics 6 to <12 yr (weight >=30 kg): Same as adult.\nPediatrics 2 to <6 yr: Oral granules packet protocol.",
            administration = "Take with a fat-containing meal or snack (e.g. whole milk, butter, cheese, eggs, peanut butter, yogurt) to ensure adequate oral absorption.",
            timing = "Morning (Triple combo) & Evening (Ivacaftor alone) with fat-containing meals.",
            specialInstructions = "Assess baseline ALT, AST, and bilirubin prior to initiation, every 3 months during the first year, and annually thereafter. Baseline and follow-up ophthalmological examinations for pediatric cataracts.",
            pkPd = "Absorption substantially enhanced by fat. Extensively metabolized by CYP3A4/5. Elimination half-life: Elexacaftor ~24h, Tezacaftor ~25h, Ivacaftor ~15h. Primary fecal excretion.",
            renalAdj = "No dosage adjustment needed for mild to moderate renal impairment.",
            hepaticAdj = "Moderate impairment (Child-Pugh B): Reduce frequency (alternate day morning dose). Severe impairment (Child-Pugh C): Contraindicated or use only if benefit outweighs risk.",
            pregnancy = "Category B (Data in CF pregnancy show safety and improved maternal lung function and neonatal birth weights).",
            lactation = "Excreted into breast milk in trace amounts; weigh benefit/risk.",
            sideEffects = "Headache, upper respiratory tract infection, nasal congestion, abdominal pain, diarrhea, elevated transaminases, rash, increased blood creatine phosphokinase.",
            priceNpr = "NPR 350000.00 - 580000.00 per 28-day box",
            priceInr = "INR 220000.00 - 390000.00 per 28-day box",
            brandsNepal = listOf(
                BrandInfo("Trikafta", "Vertex Pharmaceuticals Global Access", "Tablets Co-pack", "100/50/75mg + 150mg"),
                BrandInfo("Kaftrio", "Vertex Europe / Named Patient", "Tablets", "100/50/75mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Trikafta", "Vertex / Compassionate Access", "Tablets Co-pack", "100/50/75mg + 150mg"),
                BrandInfo("Tricaf", "Cipla Rare Disease Access", "Tablets", "100/50/75mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = "Tiered dosing based on age and weight",
            adultDose = "Morning: 2 combo tabs; Evening: 1 Ivacaftor tab with fat meal",
            childDose = "Age/weight-tiered dosing with fat meal",
            contraindications = "Concomitant strong CYP3A inducers (Rifampin, Carbamazepine, St. John's Wort).",
            modeOfAction = "Elexacaftor and Tezacaftor bind different sites on mutant CFTR protein to facilitate cellular processing and trafficking to cell membrane; Ivacaftor increases channel open probability (gating) for chloride/bicarbonate transport.",
            interactions = "Strong CYP3A inhibitors (Ketoconazole, Itraconazole, Clarithromycin - reduce Trikafta dose to twice weekly); Moderate CYP3A inhibitors (Fluconazole, Erythromycin - reduce to alternate days).",
            nemlCategory = "WHO Specialized Cystic Fibrosis Orphan Register",
            ddaSchedule = "Schedule Ka (Pulmonologist / CF Specialist)",
            era = "Newer / Modern",
            therapeuticClassTag = "Rare Diseases",
            researchNotes = "Groundbreaking therapeutic improving ppFEV1 by +14.3 percentage points, reducing pulmonary exacerbations by 63%, and reducing sweat chloride below the diagnostic threshold for CF."
        ),

        // ==========================================
        // SPECIFIC NOVEL DRUG CLASSES
        // ==========================================

        // 15. Tirzepatide (Dual GIP & GLP-1 Receptor Agonist)
        Drug(
            id = "d_class_tirzepatide",
            genericName = "Tirzepatide",
            system = "Endocrine & Metabolic System",
            drugClass = "Dual Glucose-Dependent Insulinotropic Polypeptide (GIP) & GLP-1 Receptor Agonist (Twincretin)",
            blackBoxWarning = "RISK OF THYROID C-CELL TUMORS: Tirzepatide causes dose-dependent thyroid C-cell tumors (including medullary thyroid carcinoma [MTC]) in rodents. Contraindicated in patients with a personal or family history of MTC or Multiple Endocrine Neoplasia syndrome type 2 (MEN 2). Counsel patients regarding symptoms of thyroid tumors (neck mass, dysphagia, hoarseness).",
            indications = "Type 2 Diabetes Mellitus as an adjunct to diet and exercise to improve glycemic control (Mounjaro), Chronic Weight Management in adults with obesity (BMI >=30 kg/m²) or overweight (BMI >=27 kg/m²) with at least one weight-related comorbid condition (Zepbound), Obstructive Sleep Apnea in obese adults.",
            doses = "Initiate at 2.5 mg SC once weekly for 4 weeks. Increase to 5 mg SC once weekly. If additional glycemic control or weight reduction is needed, increase in 2.5 mg increments after at least 4 weeks on current dose. Maximum dose: 15 mg SC once weekly.",
            administration = "Administer subcutaneously once weekly into abdomen, thigh, or upper arm, any time of day, with or without food. Rotate injection sites weekly.",
            timing = "Once weekly on same day each week.",
            specialInstructions = "Delayed gastric emptying may impact oral medication absorption (e.g. switch oral contraceptives to non-oral barrier method during initiation and 4 weeks post-dose escalation). Monitor for pancreatitis.",
            pkPd = "Bioavailability ~80%. Elimination half-life ~5 days (enabling once-weekly dosing). Degraded by proteolytic cleavage and beta-oxidation without significant CYP450 metabolism. Stimulates insulin secretion in glucose-dependent manner and reduces glucagon secretion.",
            renalAdj = "No dosage adjustment required for renal impairment or end-stage renal disease. Monitor hydration status.",
            hepaticAdj = "No dosage adjustment required for hepatic impairment.",
            pregnancy = "Discontinue at least 1 month prior to planned pregnancy (causes decreased fetal weight and skeletal ossification delays in animal models).",
            lactation = "Excreted in animal milk; evaluate maternal clinical benefit against infant risk.",
            sideEffects = "Nausea, diarrhea, decreased appetite, vomiting, constipation, dyspepsia, abdominal pain, hypoglycemia (when used with insulin/sulfonylurea), cholelithiasis, acute pancreatitis (rare).",
            priceNpr = "NPR 14000.00 - 24000.00 per autoinjector pen (5mg / 10mg)",
            priceInr = "INR 8500.00 - 15000.00 per pen",
            brandsNepal = listOf(
                BrandInfo("Mounjaro", "Eli Lilly Global Access", "Single-Dose Autoinjector Pen", "2.5mg / 5mg / 10mg / 15mg"),
                BrandInfo("Zepbound", "Eli Lilly Global Access", "Single-Dose Autoinjector Pen", "2.5mg / 5mg / 10mg / 15mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Mounjaro", "Eli Lilly India", "Autoinjector Pen", "2.5mg / 5mg / 7.5mg / 10mg / 15mg"),
                BrandInfo("Tirzepatide-Lilly", "Eli Lilly India", "Vial / Pen", "5 mg / 10 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "Initial 2.5 mg SC weekly x 4w, maintenance 5-15 mg SC weekly",
            childDose = "Safety and efficacy not established in pediatric patients under 18 years",
            contraindications = "Personal or family history of medullary thyroid carcinoma (MTC), Multiple Endocrine Neoplasia syndrome type 2 (MEN 2), serious hypersensitivity to tirzepatide.",
            modeOfAction = "First-in-class dual biased agonist at both GIP and GLP-1 receptors; synergistic activation enhances pancreatic beta-cell sensitivity, increases energy expenditure, and suppresses central appetite centers in the hypothalamus.",
            interactions = "Delayed gastric emptying can transiently slow absorption of oral medications (oral contraceptives, Warfarin, Levothyroxine).",
            nemlCategory = "Specialized Incretin / Cardiometabolic Formulary",
            ddaSchedule = "Schedule Kha (Endocrinologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "OHA",
            researchNotes = "SURPASS and SURMOUNT clinical trials demonstrated up to 2.4% HbA1c reduction and unprecedented 22.5% body weight reduction (average 24 kg)."
        ),

        // 16. Finerenone (Non-Steroidal Mineralocorticoid Receptor Antagonist - MRA)
        Drug(
            id = "d_class_finerenone",
            genericName = "Finerenone",
            system = "Renal & Genitourinary",
            drugClass = "Selective Non-Steroidal Mineralocorticoid Receptor Antagonist (MRA)",
            blackBoxWarning = null,
            indications = "To reduce the risk of sustained eGFR decline, end-stage kidney disease, cardiovascular death, non-fatal myocardial infarction, and hospitalization for heart failure in adult patients with Chronic Kidney Disease (CKD) associated with Type 2 Diabetes Mellitus; Heart failure with mildly reduced or preserved ejection fraction (HFmrEF / HFpEF).",
            doses = "Initial Dose (based on baseline eGFR and serum potassium):\neGFR >=60 mL/min/1.73m²: 20 mg PO once daily.\neGFR 25 to <60 mL/min/1.73m²: 10 mg PO once daily.\nSerum Potassium threshold: Do not initiate if serum K+ >5.0 mEq/L.\nTitration: Increase from 10 mg to 20 mg OD after 4 weeks if serum K+ <=4.8 mEq/L.",
            administration = "Take orally once daily with or without food. Swallow tablets whole with water.",
            timing = "Once daily (morning or evening).",
            specialInstructions = "Check serum potassium and eGFR 4 weeks after initiation or dose escalation. Withhold if serum K+ exceeds 5.5 mEq/L and restart at 10 mg OD when K+ <=5.0 mEq/L. Avoid grapefruit or grapefruit juice.",
            pkPd = "Oral bioavailability ~44%. Rapid peak plasma concentrations within 0.5 to 1.25 hours. Highly bound to plasma albumin (~92%). Extensively metabolized in liver primarily by CYP3A4 (90%) and CYP2C8 (10%). Elimination half-life ~2 to 3 hours.",
            renalAdj = "eGFR 25-59 mL/min: Start 10 mg PO OD. eGFR <25 mL/min: Initiation not recommended; continue established therapy unless K+ >5.5 mEq/L.",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh C): Avoid use. Mild to moderate: No dosage adjustment.",
            pregnancy = "Category C (Animal studies show embryofetal toxicity; avoid in pregnancy).",
            lactation = "Present in animal milk; breastfeeding not recommended during treatment and for 1 day post-dose.",
            sideEffects = "Hyperkalemia (8.8% to 14%), hypotension, hyponatremia, mild transient eGFR reduction (hemodynamic, reversible). Virtually zero incidence of gynecomastia or mastodynia compared to Spironolactone.",
            priceNpr = "NPR 65.00 - 110.00 per tab (10mg / 20mg)",
            priceInr = "INR 38.00 - 70.00 per tab (10mg / 20mg)",
            brandsNepal = listOf(
                BrandInfo("Kerendia", "Bayer Healthcare Global", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Fineren", "Quest Pharmaceuticals", "Tablet", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Kerendia", "Bayer India", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Fineren", "Sun Pharma", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Firone", "Cipla Ltd.", "Tablet", "10 mg / 20 mg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "10 to 20 mg PO once daily based on eGFR and potassium",
            childDose = "Safety and efficacy not established in pediatric patients",
            contraindications = "Concomitant strong CYP3A4 inhibitors (Itraconazole, Ketoconazole, Clarithromycin), Addison disease, serum potassium >5.0 mEq/L at baseline.",
            modeOfAction = "Non-steroidal bulky antagonist that binds mineralocorticoid receptors with high affinity and selectivity, preventing receptor nuclear translocation and blocking aldosterone-mediated renal and vascular fibrosis/inflammation without androgenic/progestogenic side effects.",
            interactions = "Strong CYP3A4 inhibitors (contraindicated; increases finerenone 500%); Moderate CYP3A4 inhibitors (Erythromycin, Diltiazem - monitor potassium); Potassium-sparing diuretics, potassium supplements (additive hyperkalemia risk).",
            nemlCategory = "Specialized Nephrology & Cardiology Formulary",
            ddaSchedule = "Schedule Kha (Nephrologist / Cardiologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "FIDELIO-DKD and FIGARO-DKD landmark clinical trials proved significant reduction in renal disease progression (composite renal endpoint by 18%) and cardiovascular events by 14%."
        ),

        // 17. Inclisiran (Synthetic siRNA PCSK9 Inhibitor)
        Drug(
            id = "d_class_inclisiran",
            genericName = "Inclisiran",
            system = "Cardiovascular System (CVS)",
            drugClass = "Small Interfering RNA (siRNA) PCSK9 Inhibitor",
            blackBoxWarning = null,
            indications = "Primary Hyperlipidemia (including Heterozygous Familial Hypercholesterolemia [HeFH]) and Clinical Atherosclerotic Cardiovascular Disease (ASCVD) requiring additional lowering of LDL-C as an adjunct to diet and maximally tolerated statin therapy.",
            doses = "Adult: 284 mg SC injection initially, again at 3 months, and then every 6 months thereafter (twice a year maintenance).",
            administration = "Administered by a healthcare professional as a subcutaneous injection into the abdomen, upper arm, or thigh. Do not inject into active skin disease or injury.",
            timing = "Day 1, Month 3, then q6 months SC.",
            specialInstructions = "Ensure patient receives regular 6-month reminder appointments. Can be co-administered with statins and Ezetimibe. Check lipid panel 4 to 8 weeks post-injection.",
            pkPd = "Targeted specifically to hepatocytes via triantennary N-acetylgalactosamine (GalNAc) carbohydrates binding asialoglycoprotein receptors (ASGPR). Rapidly cleared from plasma (half-life ~9 hours), but intracellular duration in hepatocyte RNA-induced silencing complex (RISC) persists >6 months. Primary renal excretion of short oligonucleotide fragments.",
            renalAdj = "No dose adjustment required for mild, moderate, or severe renal impairment, or end-stage renal disease on hemodialysis.",
            hepaticAdj = "No dosage adjustment needed for mild to moderate hepatic impairment (Child-Pugh A or B).",
            pregnancy = "Discontinue when pregnancy is recognized (cholesterol and cholesterol derivatives are essential for fetal development).",
            lactation = "Excretion in human milk unknown; weigh clinical necessity vs infant safety.",
            sideEffects = "Injection-site reaction (pain, erythema, rash in 8%), arthralgia, urinary tract infection, diarrhea, bronchitis, pain in extremity, dyspnea.",
            priceNpr = "NPR 180000.00 - 320000.00 per pre-filled syringe (284mg/1.5mL)",
            priceInr = "INR 120000.00 - 240000.00 per syringe (284mg)",
            brandsNepal = listOf(
                BrandInfo("Leqvio", "Novartis Healthcare Global", "Pre-filled Syringe", "284 mg / 1.5 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Leqvio", "Novartis India", "Pre-filled Syringe", "284 mg / 1.5 mL")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = "284 mg SC at Day 1, Month 3, then every 6 months",
            childDose = "Safety and efficacy not established in pediatric patients",
            contraindications = "Hypersensitivity to inclisiran or any excipients.",
            modeOfAction = "Double-stranded siRNA conjugated to GalNAc; once inside hepatocytes, incorporates into the RNA-Induced Silencing Complex (RISC) and cleaves PCSK9 mRNA, preventing PCSK9 protein translation, upregulating LDL receptors, and lowering circulating LDL-C by >50%.",
            interactions = "Not a substrate, inhibitor, or inducer of CYP450 or common drug transporters; zero significant pharmacokinetic drug interactions.",
            nemlCategory = "Specialized Preventive Cardiology Formulary",
            ddaSchedule = "Schedule Kha (Cardiologist Prescription)",
            era = "Newer / Modern",
            therapeuticClassTag = "Statins",
            researchNotes = "ORION-9, ORION-10, and ORION-11 phase 3 trials confirmed durable LDL-C reduction of 50-52% with sustained twice-yearly administration."
        )
    )
}
