package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object NeuroPsychInfectiousUroDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // NEUROLOGY & PSYCHIATRY
        // ==========================================
        Drug(
            id = "d_neuro_carbamazepine",
            genericName = "Carbamazepine",
            system = "Central Nervous System (CNS)",
            drugClass = "Iminostilbene Anticonvulsant & Mood Stabilizer",
            blackBoxWarning = "SERIOUS DERMATOLOGIC REACTIONS & APLASTIC ANEMIA: Toxic epidermal necrolysis (TEN) and Stevens-Johnson syndrome (SJS), strongly associated with HLA-B*1502 allele in Asian populations. Aplastic anemia and agranulocytosis risk.",
            indications = "Trigeminal neuralgia (first-line drug of choice), focal seizures with or without secondary generalization, generalized tonic-clonic seizures, bipolar affective disorder mania (acute and prophylaxis).",
            doses = "Trigeminal Neuralgia: Start 100 mg PO BID; titrate by 100-200 mg/day up to 400-800 mg/day divided (max 1200 mg/day). Epilepsy: Start 100-200 mg PO BID; titrate to maintenance 800-1200 mg/day divided TID-QID.",
            administration = "Take orally with or after meals to decrease GI irritation. Swallow controlled-release tablets whole.",
            timing = "Two to four times daily with meals.",
            specialInstructions = "Potent hepatic auto-inducer (induces CYP3A4, speeding up its own metabolism over first 3-5 weeks). Screen for HLA-B*1502 allele in patients of Asian descent. Monitor CBC, LFTs, and serum sodium (risk of SIADH / hyponatremia).",
            pkPd = "Slow and variable oral absorption. 75% protein bound. Converted by CYP3A4 to active carbamazepine-10,11-epoxide. Half-life initially 25-65h, decreasing to 12-17h with auto-induction. Therapeutic serum range: 4-12 mcg/mL.",
            renalAdj = "Use with caution; monitor for water intoxication and hyponatremia.",
            hepaticAdj = "Avoid in severe hepatic impairment; metabolized extensively by liver.",
            pregnancy = "Category D (Major teratogen: neural tube defects, craniofacial defects, fingernail hypoplasia; give high-dose folic acid 5 mg daily).",
            lactation = "Excreted in breast milk (ratio 0.4); monitor infant for jaundice, drowsiness, and poor feeding.",
            sideEffects = "Dizziness, drowsiness, ataxia, diplopia, hyponatremia (SIADH 5-10%), leukopenia, elevated transaminases, morbilliform rash, SJS/TEN.",
            priceNpr = "NPR 35.00 - 80.00 per strip of 10 (200mg / 400mg CR)",
            priceInr = "INR 20.00 - 55.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Tegretol", "Novartis / Medisales Nepal", "Tab / CR", "100 mg / 200 mg / 400 mg CR"),
                BrandInfo("Mazetol", "Abbott Nepal", "Tab", "100 mg / 200 mg / 400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tegretol", "Novartis India", "Tab / CR", "100 / 200 / 400 mg"),
                BrandInfo("Mazetol", "Abbott", "Tab", "200 / 400 mg")
            ),
            adultDose = "200 mg PO BID, titrate to 800-1200 mg/day.",
            childDose = "10-20 mg/kg/day PO divided into 2-3 doses.",
            contraindications = "Bone marrow depression, AV conduction block, acute intermittent porphyria, concomitant MAO inhibitors, history of severe hypersensitivity.",
            modeOfAction = "Binds to and stabilizes voltage-gated sodium channels in the inactive state, limiting repetitive firing of action potentials and decreasing synaptic transmission.",
            therapeuticClassTag = "Antiepileptic / Neuropathic"
        ),

        Drug(
            id = "d_neuro_phenytoin",
            genericName = "Phenytoin Sodium",
            system = "Central Nervous System (CNS)",
            drugClass = "Hydantoin Anticonvulsant",
            blackBoxWarning = "CARDIOVASCULAR RISK WITH RAPID INFUSION: Rapid intravenous administration exceeds 50 mg/min causes severe hypotension, ventricular arrhythmias, and cardiac arrest. Continuous ECG monitoring required.",
            indications = "Status epilepticus (following benzodiazepines), generalized tonic-clonic (grand mal) seizures, focal seizures, prevention of post-traumatic seizures following neurosurgery or head trauma.",
            doses = "Status Epilepticus: IV loading dose 15-20 mg/kg diluted in Normal Saline infused at max rate 50 mg/min (max 25-50 mg/min in elderly). Oral Maintenance: 300-400 mg PO daily in single or 2 divided doses (usual 4-6 mg/kg/day).",
            administration = "IV: Infuse ONLY in 0.9% Normal Saline with a 0.22-micron in-line filter (precipitates instantly in dextrose solutions). Oral: Take with or after food.",
            timing = "Once daily at bedtime or divided BID.",
            specialInstructions = "Zero-order (Michaelis-Menten / non-linear) saturation pharmacokinetics: small dose increases cause disproportionately huge increases in serum levels and severe toxicity. Therapeutic level: 10-20 mcg/mL.",
            pkPd = "Oral bioavailability ~90%. Highly bound to albumin (90%). Extensively metabolized by CYP2C9 and CYP2C19. Half-life 12-36 hours (prolonged at higher concentrations).",
            renalAdj = "In uremia or hypoalbuminemia, total level appears falsely low; calculate Sheiner-Tozer adjusted phenytoin level.",
            hepaticAdj = "Decreased clearance in cirrhosis; monitor free unbound levels closely.",
            pregnancy = "Category D (Fetal hydantoin syndrome: microcephaly, cleft palate, digital hypoplasia, congenital heart defects).",
            lactation = "Excreted into breast milk in low concentrations; monitor infant.",
            sideEffects = "Nystagmus, ataxia, slurred speech, confusion, gingival hyperplasia (20-40%), hirsutism, coarse facial features, peripheral neuropathy, osteomalacia (vitamin D catabolism), Purple Glove Syndrome (IV extravasation).",
            priceNpr = "NPR 30.00 - 75.00 per strip of 10 / NPR 25.00 per 100mg ampoule",
            priceInr = "INR 20.00 - 50.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Eptoin", "Abbott Nepal", "Tab / Inj", "50 mg / 100 mg / 100mg/2mL"),
                BrandInfo("Dilantin", "Pfizer Nepal", "Cap / Inj", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Eptoin", "Abbott India", "Tab / Inj", "50 / 100 mg / 100mg/2mL"),
                BrandInfo("Dilantin", "Pfizer", "Cap", "100 mg")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "mg/kg IV loading (max rate 1-3 mg/kg/min)",
            adultDose = "Loading 15-20 mg/kg IV in NS; maintenance 300 mg PO daily.",
            childDose = "Loading 15-20 mg/kg IV; maintenance 5-8 mg/kg/day PO divided BID.",
            contraindications = "Sinus bradycardia, sinoatrial block, 2nd and 3rd degree AV block, Stokes-Adams syndrome, co-administration with delavirdine.",
            modeOfAction = "Selectively promotes sodium efflux from neurons and stabilizes the inactive conformation of voltage-gated neuronal sodium channels, suppressing sustained high-frequency repetitive firing.",
            therapeuticClassTag = "Antiepileptic / Critical Care"
        ),

        Drug(
            id = "d_neuro_levodopa_carbidopa",
            genericName = "Levodopa + Carbidopa",
            system = "Central Nervous System (CNS)",
            drugClass = "Dopamine Precursor + Dopa-Decarboxylase Inhibitor",
            blackBoxWarning = null,
            indications = "Idiopathic Parkinson's disease, post-encephalitic parkinsonism, symptomatic parkinsonism following carbon monoxide or manganese toxicity.",
            doses = "Starting dose: Levodopa 100 mg + Carbidopa 25 mg (1:4 ratio) PO three times daily. Titrate by 1 tablet every 1-2 days up to 1-2 tablets TID or QID (usual maintenance Levodopa 300-800 mg/day divided).",
            administration = "Take 30-60 minutes before meals or 1-2 hours after meals. Avoid high-protein meals (dietary amino acids compete for gut absorption and blood-brain barrier transport).",
            timing = "Regularly spaced doses throughout the waking day.",
            specialInstructions = "Gold-standard symptomatic therapy for Parkinson's disease. Carbidopa does not cross the blood-brain barrier, preventing peripheral conversion to dopamine and eliminating severe nausea and hypotension.",
            pkPd = "Levodopa rapidly absorbed in small intestine via neutral amino acid transport. Carbidopa increases central levodopa availability by 4-5 fold. Plasma half-life ~1.5 hours.",
            renalAdj = "No formal dose adjustment needed.",
            hepaticAdj = "Use with caution in severe hepatic impairment.",
            pregnancy = "Category C (Safety in pregnancy not established).",
            lactation = "Levodopa inhibits prolactin secretion; avoid in nursing mothers.",
            sideEffects = "Nausea, vomiting, orthostatic hypotension, cardiac arrhythmias, visual hallucinations, confusion, motor fluctuations (on-off phenomena, end-of-dose wearing off), peak-dose choreiform dyskinesias.",
            priceNpr = "NPR 110.00 - 240.00 per strip of 10 (100/25mg / 250/25mg)",
            priceInr = "INR 70.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Syndopa", "Sun Pharma Nepal", "Tab", "110 mg (100/10) / Plus 125 mg (100/25) / 275 mg (250/25)"),
                BrandInfo("Sinemet", "Organon / Medisales Nepal", "Tab", "100/25 mg / 250/25 mg"),
                BrandInfo("Tidomet", "Torrent Pharmaceuticals", "Tab", "100/25 mg / 250/25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Syndopa", "Sun Pharma", "Tab", "110 / Plus 125 / 275 mg"),
                BrandInfo("Sinemet", "Organon", "Tab", "100/25 mg")
            ),
            adultDose = "1 tab (100/25mg) PO TID; titrate to response.",
            contraindications = "Non-selective MAO inhibitors within 14 days, narrow-angle glaucoma, suspicious undiagnosed skin lesions or history of melanoma, acute psychosis.",
            modeOfAction = "Levodopa crosses the blood-brain barrier and is decarboxylated centrally to dopamine, replenishing depleted striatal dopamine; Carbidopa inhibits peripheral DOPA decarboxylase.",
            therapeuticClassTag = "Parkinson's Disease"
        ),

        Drug(
            id = "d_psych_duloxetine",
            genericName = "Duloxetine Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Serotonin-Norepinephrine Reuptake Inhibitor (SNRI)",
            blackBoxWarning = "SUICIDAL THOUGHTS AND BEHAVIORS: Antidepressants increase the risk of suicidal thoughts and behaviors in children, adolescents, and young adults (aged <= 24 years).",
            indications = "Major Depressive Disorder (MDD), Generalized Anxiety Disorder (GAD), Diabetic Peripheral Neuropathic Pain (DPNP), Fibromyalgia, chronic musculoskeletal pain (chronic low back pain, osteoarthritis).",
            doses = "Depression / Anxiety: Start 30 mg PO once daily for 1 week, then 60 mg PO once daily (max 120 mg/day). Diabetic Neuropathy / Fibromyalgia: 60 mg PO once daily.",
            administration = "Swallow delayed-release capsule whole with water with or without food. Do not chew, crush, or open capsules (enteric pellets protected from gastric acid degradation).",
            timing = "Morning with breakfast (or bedtime if causes somnolence).",
            specialInstructions = "Dual reuptake inhibition provides superior efficacy for neuropathic and somatic chronic pain compared to SSRIs. Do not discontinue abruptly (electric-shock sensations / brain zaps).",
            pkPd = "Oral bioavailability ~50%. Highly protein bound (>90%). Extensively metabolized in liver by CYP1A2 and CYP2D6. Elimination half-life ~12 hours.",
            renalAdj = "CrCl >= 30 mL/min: No adjustment needed. CrCl <30 mL/min or ESRD: AVOID use (increases exposure to toxic metabolites).",
            hepaticAdj = "CONTRAINDICATED in patients with substantial alcohol use or chronic liver disease (causes hepatic failure and jaundice).",
            pregnancy = "Category C (Risk of neonatal withdrawal / persistent pulmonary hypertension of newborn PPHN).",
            lactation = "Excreted in low levels in breast milk; monitor infant.",
            sideEffects = "Nausea (>20%), dry mouth, constipation, insomnia, dizziness, somnolence, diaphoresis, sexual dysfunction, mild elevation in blood pressure, hepatotoxicity.",
            priceNpr = "NPR 90.00 - 190.00 per strip of 10 (20mg / 30mg / 60mg)",
            priceInr = "INR 60.00 - 130.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Duzela", "Sun Pharma Nepal", "Cap", "20 mg / 30 mg / 60 mg"),
                BrandInfo("Cymbalta", "Eli Lilly / Nepal Dist.", "Cap", "30 mg / 60 mg"),
                BrandInfo("Dulojoy", "Torrent Pharmaceuticals", "Cap", "30 mg / 60 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Duzela", "Sun Pharma", "Cap", "20 / 30 / 60 mg"),
                BrandInfo("Cymbalta", "Eli Lilly", "Cap", "30 / 60 mg")
            ),
            adultDose = "30-60 mg PO once daily (max 120 mg/day).",
            contraindications = "Concomitant MAO inhibitors, uncontrolled narrow-angle glaucoma, severe renal impairment (CrCl <30 mL/min), chronic liver disease.",
            modeOfAction = "Potent balanced inhibitor of neuronal serotonin (5-HT) and norepinephrine (NE) reuptake, enhancing central serotonergic and noradrenergic descending inhibitory pain pathways.",
            therapeuticClassTag = "Antidepressants / Neuropathic Pain"
        ),

        Drug(
            id = "d_psych_haloperidol",
            genericName = "Haloperidol",
            system = "Central Nervous System (CNS)",
            drugClass = "First-Generation High-Potency Butyrophenone Antipsychotic",
            blackBoxWarning = "INCREASED MORTALITY IN ELDERLY PATIENTS WITH DEMENTIA-RELATED PSYCHOSIS: Elderly patients treated with antipsychotics are at an increased risk of death (cardiovascular or infectious).",
            indications = "Acute psychosis, acute delirium agitation in ICU, schizophrenia, Tourette's syndrome (motor and vocal tics), intractable hiccups, palliative terminal nausea.",
            doses = "Acute Psychosis / Delirium: 2.5-5 mg IM or slow IV; repeat every 30-60 minutes as needed (max 20-30 mg/day). Oral Maintenance: 2-10 mg PO daily in divided doses.",
            administration = "IV / IM or oral. For IV route, ensure baseline QTc measurement and continuous cardiac telemetry (risk of Torsades de Pointes).",
            timing = "STAT for acute agitation or divided daily doses.",
            specialInstructions = "High incidence of Extrapyramidal Symptoms (EPS: acute dystonia, parkinsonism, akathisia). Have IV Promethazine or Diphenhydramine available at bedside. Risk of Neuroleptic Malignant Syndrome (NMS).",
            pkPd = "Oral bioavailability ~60%. Highly protein bound (92%). Hepatic metabolism via CYP3A4 and glucuronidation. Elimination half-life 15-37 hours.",
            renalAdj = "No adjustment needed; monitor for sedation.",
            hepaticAdj = "Use lower starting doses in severe hepatic impairment.",
            pregnancy = "Category C (Extrapyramidal symptoms in neonates if used in 3rd trimester).",
            lactation = "Excreted in breast milk; monitor infant for sedation and developmental milestones.",
            sideEffects = "Acute dystonic reactions, parkinsonian rigidity, akathisia, tardive dyskinesia, hyperprolactinemia (galactorrhea, amenorrhea), QTc prolongation, Torsades de Pointes, Neuroleptic Malignant Syndrome.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 10 / NPR 12.00 per 5mg ampoule",
            priceInr = "INR 10.00 - 25.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Serenace", "RPG Life Sciences Nepal", "Tab / Inj", "1.5 mg / 5 mg / 5mg/mL Inj"),
                BrandInfo("Halopidol", "Cipla Nepal", "Tab / Inj", "5 mg / 5mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Serenace", "RPG", "Tab / Inj", "1.5 / 5 mg / 5mg/mL"),
                BrandInfo("Halidol", "Sun Pharma", "Tab", "5 mg")
            ),
            adultDose = "2.5-5 mg IM/IV stat; 2-10 mg PO daily.",
            contraindications = "Comatose state, severe central nervous system depression, Parkinson's disease, dementia with Lewy bodies, known QTc prolongation.",
            modeOfAction = "High-affinity competitive blockade of postsynaptic dopamine D2 receptors in the mesolimbic pathway of the brain, suppressing hallucinations and delusions.",
            therapeuticClassTag = "Antipsychotics / Delirium"
        ),

        Drug(
            id = "d_psych_quetiapine",
            genericName = "Quetiapine Fumarate",
            system = "Central Nervous System (CNS)",
            drugClass = "Second-Generation Atypical Dibenzothiazepine Antipsychotic",
            blackBoxWarning = "INCREASED MORTALITY IN ELDERLY DEMENTIA PATIENTS & SUICIDALITY: Increased mortality in dementia-related psychosis. Increased risk of suicidal ideation in young adults.",
            indications = "Schizophrenia, Bipolar I Disorder (acute mania, mixed episodes, and bipolar depression), adjunctive treatment of Major Depressive Disorder (MDD), psychosis in Parkinson's disease.",
            doses = "Schizophrenia: Start 25 mg PO BID; titrate to 300-800 mg/day divided. Bipolar Depression: 300 mg PO once daily at bedtime. Insomnia / Low-Dose Sedation (off-label): 25-50 mg PO at bedtime.",
            administration = "Take orally with or without food. Extended-release (XR) tablets must be taken without food or with a light meal; swallow whole without splitting.",
            timing = "Bedtime (especially IR and XR formulations due to strong antihistaminic sedation).",
            specialInstructions = "Antipsychotic of choice in Parkinson's disease-associated psychosis (along with clozapine) because of weak D2 binding and low extrapyramidal symptom liability.",
            pkPd = "Rapid absorption. Metabolized by CYP3A4 to active metabolite norquetiapine (responsible for antidepressant action via NET inhibition). Half-life: quetiapine ~6 hours, norquetiapine ~12 hours.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "Start 25 mg daily; titrate slowly by 25-50 mg/day in hepatic impairment.",
            pregnancy = "Category C (Compatible when benefits outweigh risks).",
            lactation = "Excreted in low levels in breast milk; monitor infant.",
            sideEffects = "Somnolence (>50%), dizziness, dry mouth, weight gain, metabolic syndrome (dyslipidemia, hyperglycemia), orthostatic hypotension, constipation.",
            priceNpr = "NPR 65.00 - 150.00 per strip of 10 (25mg / 50mg / 100mg)",
            priceInr = "INR 45.00 - 105.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Seroquel", "AstraZeneca / Medisales Nepal", "Tab", "25 mg / 100 mg / 200 mg"),
                BrandInfo("Qutan", "Intas Pharmaceuticals", "Tab", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Q-Pin", "Sun Pharma Nepal", "Tab", "25 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Seroquel", "AstraZeneca India", "Tab", "25 / 100 / 200 mg"),
                BrandInfo("Qutan", "Intas", "Tab", "25 / 50 / 100 mg")
            ),
            adultDose = "150-300 mg PO at bedtime (depression/bipolar); 25-50 mg (low-dose sedation).",
            contraindications = "Hypersensitivity to quetiapine; concurrent use with potent CYP3A4 inhibitors (ketoconazole, ritonavir).",
            modeOfAction = "Antagonizes serotonin 5-HT2A receptors and dopamine D2 receptors with rapid dissociation kinetics; active metabolite norquetiapine inhibits norepinephrine transporter (NET) and 5-HT1A receptors.",
            therapeuticClassTag = "Atypical Antipsychotics"
        ),

        Drug(
            id = "d_psych_lithium",
            genericName = "Lithium Carbonate",
            system = "Central Nervous System (CNS)",
            drugClass = "Monovalent Cation Mood Stabilizer",
            blackBoxWarning = "LITHIUM TOXICITY: Toxicity is closely related to serum lithium levels and can occur at doses close to therapeutic levels. Facilities for prompt and accurate serum lithium determinations must be available.",
            indications = "Acute manic episodes of Bipolar I Disorder, maintenance therapy for Bipolar Disorder (proven reduction in suicide mortality), treatment-resistant major depression augmentation.",
            doses = "Acute Mania: 600-900 mg PO daily in divided doses; titrate targeting serum level 0.8-1.2 mEq/L. Maintenance: 300-600 mg PO BID or TID targeting serum level 0.6-0.8 mEq/L.",
            administration = "Take orally with meals or milk to minimize gastric upset. Maintain adequate fluid (2-3 L/day) and constant salt intake.",
            timing = "Divided doses with meals or single daily dose at bedtime (SR).",
            specialInstructions = "NARROW THERAPEUTIC INDEX: Serum levels must be drawn 12 hours post-dose (trough level). Concomitant NSAIDs, ACE inhibitors, ARBs, and thiazide diuretics REDUCE renal lithium clearance and cause severe toxic overdose.",
            pkPd = "Complete oral absorption. Not bound to plasma proteins. Not metabolized. Excreted 95% unchanged in urine via renal tubules (reabsorbed in proximal tubule competing with sodium). Half-life 18-24 hours.",
            renalAdj = "CrCl 10-50 mL/min: Reduce dose by 50-75%. CrCl <10 mL/min: Contraindicated. Hemodialysis is the treatment of choice for severe toxicity (>2.5-4.0 mEq/L).",
            hepaticAdj = "No adjustment needed; not metabolized by liver.",
            pregnancy = "Category D (Ebstein's anomaly - tricuspid valve downward displacement in 1st trimester; neonatal floppy infant syndrome, goiter).",
            lactation = "Contraindicated; high concentrations in breast milk cause infant hypotonia and cyanosis.",
            sideEffects = "Fine hand tremor, polyuria/polydipsia (nephrogenic diabetes insipidus), hypothyroidism and goiter, weight gain, acne, leukocytosis, diarrhea, flattened T-waves.",
            priceNpr = "NPR 45.00 - 95.00 per strip of 10 (300mg / 400mg CR)",
            priceInr = "INR 30.00 - 65.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Licab", "Torrent Pharmaceuticals Nepal", "Tab / XL", "300 mg / 400 mg XL"),
                BrandInfo("Lithosun", "Sun Pharma Nepal", "Tab", "300 mg / 400 mg SR")
            ),
            brandsIndia = listOf(
                BrandInfo("Licab", "Torrent", "Tab", "300 / 400 mg"),
                BrandInfo("Lithosun", "Sun Pharma", "Tab", "300 / 400 mg")
            ),
            adultDose = "300-600 mg PO BID-TID titrated to serum level 0.6-1.0 mEq/L.",
            contraindications = "Severe renal impairment, severe dehydration, sodium depletion, concurrent diuretic therapy without monitoring, cardiovascular disease.",
            modeOfAction = "Inhibits inositol monophosphatase (IMPase) and glycogen synthase kinase-3 beta (GSK-3beta), modulating phosphoinositide and neuroprotective intracellular signaling cascades.",
            therapeuticClassTag = "Mood Stabilizers / Bipolar"
        ),

        // ==========================================
        // ANTIMICROBIALS & ANTI-INFECTIVES
        // ==========================================
        Drug(
            id = "d_antimicro_cefazolin",
            genericName = "Cefazolin Sodium",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "First-Generation Parenteral Cephalosporin",
            blackBoxWarning = null,
            indications = "Surgical antimicrobial prophylaxis across all surgical disciplines (cardiac, orthopedic, general, gynecologic), methicillin-susceptible Staphylococcus aureus (MSSA) bacteremia/endocarditis, skin and soft tissue infections.",
            doses = "Surgical Prophylaxis: 2 g IV infusion administered within 30-60 minutes prior to surgical incision (3 g if patient weight >= 120 kg); redose 1 g IV q4h intra-operatively for prolonged procedures. MSSA Infection: 1 to 2 g IV q8h.",
            administration = "Slow IV bolus over 3-5 minutes or IV piggyback infusion in 50-100 mL NS/D5W over 30 minutes.",
            timing = "30-60 minutes prior to surgical knife-to-skin incision.",
            specialInstructions = "Gold-standard worldwide surgical prophylactic agent due to proven efficacy against staphylococci/streptococci, long half-life, and safety. Well tolerated in patients with non-IgE penicillin allergy.",
            pkPd = "High peak serum levels. 85% protein bound. Excreted almost entirely unchanged in urine via glomerular filtration. Half-life ~1.8 hours (longest among 1st gen cephalosporins).",
            renalAdj = "CrCl 35-54 mL/min: Standard dose q8h. CrCl 11-34 mL/min: 50% of dose q12h. CrCl <10 mL/min: 50% of dose q18-24h. Hemodialysis: 500 mg - 1 g post-dialysis.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category B (Safe and widely used in cesarean section prophylaxis).",
            lactation = "Present in low concentrations in breast milk; compatible with breastfeeding.",
            sideEffects = "Phlebitis, maculopapular rash, diarrhea, elevated transaminases, positive direct Coombs test, rare eosinophilia.",
            priceNpr = "NPR 70.00 - 140.00 per 1 g vial",
            priceInr = "INR 45.00 - 95.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Kefzol", "Lilly / Medisales Nepal", "Inj", "500 mg / 1 g"),
                BrandInfo("Reflin", "Alkem Laboratories Nepal", "Inj", "500 mg / 1 g"),
                BrandInfo("Cefulin", "Nepal Pharmaceuticals Lab", "Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Kefzol", "Eli Lilly India", "Inj", "1 g"),
                BrandInfo("Reflin", "Alkem", "Inj", "1 g")
            ),
            adultDose = "2 g IV stat 30-60 min prior to incision; 1-2 g IV q8h for treatment.",
            childDose = "25-50 mg/kg/day IV divided q8h (prophylaxis: 30 mg/kg IV single dose).",
            contraindications = "Severe immediate hypersensitivity (anaphylaxis, angioedema) to cephalosporin antibiotics.",
            modeOfAction = "Binds to penicillin-binding proteins (PBPs), inhibiting bacterial cell wall peptidoglycan synthesis, triggering bacterial autolytic enzyme activation and bactericidal lysis.",
            therapeuticClassTag = "Cephalosporins / Surgical Prophylaxis"
        ),

        Drug(
            id = "d_antimicro_ceftazidime",
            genericName = "Ceftazidime",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Third-Generation Antipseudomonal Cephalosporin",
            blackBoxWarning = null,
            indications = "Pseudomonas aeruginosa infections, febrile neutropenia, hospital-acquired pneumonia (HAP/VAP), melioidosis (Burkholderia pseudomallei acute phase), complicated UTI, cystic fibrosis pulmonary exacerbation.",
            doses = "Standard: 1 to 2 g IV q8h (infusion over 30 min or continuous infusion). Severe Sepsis / Febrile Neutropenia / Melioidosis: 2 g IV q8h.",
            administration = "IV infusion over 30 minutes. Reconstitution generates carbon dioxide gas (vial becomes pressurized).",
            timing = "Every 8 hours.",
            specialInstructions = "Potent antipseudomonal activity with poor Gram-positive (staphylococcal) coverage. Acute intensive phase for melioidosis requires 2g IV q8h for at least 14 days.",
            pkPd = "Low protein binding (<10%). Excellent penetration into CSF, sputum, peritoneal, and synovial fluid. Excreted 80-90% unchanged via kidneys. Half-life ~1.6-2 hours.",
            renalAdj = "CrCl 31-50 mL/min: 1 g IV q12h. CrCl 16-30 mL/min: 1 g IV q24h. CrCl 6-15 mL/min: 500 mg IV q24h. CrCl <5 mL/min: 500 mg IV q48h. Hemodialysis: 1 g post-dialysis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe when indicated).",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding.",
            sideEffects = "Phlebitis, eosinophilia, diarrhea, elevated transaminases, neurotoxicity (myoclonus, encephalopathy, non-convulsive status epilepticus in unadjusted renal impairment).",
            priceNpr = "NPR 180.00 - 350.00 per 1 g vial",
            priceInr = "INR 120.00 - 240.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Fortum", "GSK Nepal", "Inj", "500 mg / 1 g / 2 g"),
                BrandInfo("Ceftaz", "Alkem Laboratories Nepal", "Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Fortum", "GSK India", "Inj", "1 / 2 g"),
                BrandInfo("Ceftaz", "Alkem", "Inj", "1 g")
            ),
            adultDose = "1-2 g IV q8h.",
            childDose = "100-150 mg/kg/day IV divided q8h (max 6 g/day).",
            contraindications = "Severe immediate hypersensitivity to cephalosporins or beta-lactam antibiotics.",
            modeOfAction = "Inhibits bacterial cell wall synthesis by binding to high-molecular-weight penicillin-binding proteins (PBP3) of Gram-negative pathogens including Pseudomonas aeruginosa.",
            therapeuticClassTag = "Cephalosporins / Antipseudomonal"
        ),

        Drug(
            id = "d_antimicro_clindamycin",
            genericName = "Clindamycin Hydrochloride / Phosphate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Lincosamide Antibacterial Agent",
            blackBoxWarning = "CLOSTRIDIOIDES DIFFICILE-ASSOCIATED DIARRHEA (CDAD): High propensity to cause severe, potentially fatal pseudomembranous colitis and toxic megacolon. Reserve for infections where other antimicrobial agents are inappropriate.",
            indications = "Severe anaerobic infections (intra-abdominal, pelvic, lung abscess), toxic shock syndrome (suppression of staphylococcal and streptococcal exotoxins), necrotizing fasciitis, osteomyelitis, dental abscess, babesiosis.",
            doses = "Oral: 150-450 mg PO q6-8h with full glass of water. IV: 600-900 mg IV infusion over 30-60 min q8h. Toxic Shock / Necrotizing Fasciitis: 900 mg IV q8h combined with penicillin or meropenem.",
            administration = "Oral: Take with a full glass of water and remain upright for 30 min (pill-induced esophagitis). IV: Infuse at rate not exceeding 30 mg/min (rapid bolus causes cardiac arrest). Never administer IV push.",
            timing = "Every 6 to 8 hours.",
            specialInstructions = "POTENT TOXIN SUPPRESSOR: Shuts down ribosomal protein synthesis, halting production of alpha-toxin, Panton-Valentine leukocidin (PVL), and streptococcal pyrogenic exotoxins in necrotizing soft tissue infections.",
            pkPd = "Oral bioavailability ~90%. High volume of distribution with excellent penetration into bone, abscesses, and leukocytes; poor CSF penetration. Hepatic metabolism. Half-life ~2.4-3 hours.",
            renalAdj = "No dosage adjustment necessary in renal failure or hemodialysis.",
            hepaticAdj = "Prolonged half-life in severe liver disease; monitor or extend dosing interval.",
            pregnancy = "Category B (Safe; used for anaerobic pelvic sepsis and bacterial vaginosis in pregnancy).",
            lactation = "Excreted in breast milk; compatible, but monitor infant for bloody diarrhea and candidiasis.",
            sideEffects = "Severe diarrhea, Clostridioides difficile pseudomembranous colitis, nausea, vomiting, metallic taste, maculopapular rash, elevated transaminases, thrombophlebitis.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (300mg) / NPR 120.00 per 600mg ampoule",
            priceInr = "INR 70.00 - 150.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Dalacin C", "Pfizer Nepal", "Cap / Inj", "150 mg / 300 mg / 300mg/2mL / 600mg/4mL"),
                BrandInfo("Clindac-A", "Alkem Nepal", "Cap / Inj", "300 mg / 600 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Dalacin C", "Pfizer", "Cap / Inj", "150 / 300 mg / 600 mg"),
                BrandInfo("Clindatime", "Mankind", "Cap", "300 mg")
            ),
            adultDose = "300-450 mg PO q6h or 600-900 mg IV q8h.",
            childDose = "20-40 mg/kg/day PO/IV divided q6-8h.",
            contraindications = "History of pseudomembranous colitis, ulcerative colitis, regional enteritis, severe hypersensitivity.",
            modeOfAction = "Reversibly binds to the 50S ribosomal subunit of susceptible bacteria, preventing transpeptidation and peptide chain elongation, inhibiting bacterial protein synthesis and toxin expression.",
            therapeuticClassTag = "Lincosamides / Anti-anaerobic"
        ),

        Drug(
            id = "d_antimicro_oseltamivir",
            genericName = "Oseltamivir Phosphate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Neuraminidase Inhibitor Antiviral Agent",
            blackBoxWarning = null,
            indications = "Treatment and post-exposure chemoprophylaxis of acute uncomplicated Influenza A and Influenza B viral infections (H1N1 seasonal and pandemic flu).",
            doses = "Treatment: 75 mg PO twice daily for 5 consecutive days. Prophylaxis: 75 mg PO once daily for at least 10 days post-exposure (up to 6 weeks during outbreak).",
            administration = "Take orally with or after food to significantly reduce nausea and vomiting.",
            timing = "Morning and evening for 5 days.",
            specialInstructions = "EFFICACY DEPENDS ON EARLY START: Treatment must be initiated within 48 hours of symptom onset to produce maximal clinical benefit (reduces illness duration by 1-1.5 days and lowers pneumonia hospitalization risk).",
            pkPd = "Oral prodrug rapidly hydrolyzed by hepatic esterases to active oseltamivir carboxylate (bioavailability ~80%). Active metabolite excreted >99% unchanged via kidneys. Half-life 6-10 hours.",
            renalAdj = "CrCl 30-60 mL/min: 30 mg PO BID x 5 days. CrCl 10-30 mL/min: 30 mg PO once daily x 5 days. ESRD on Hemodialysis: 30 mg post-dialysis.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category C (Recommended by CDC and WHO as antiviral of choice for pregnant women with suspected or confirmed influenza due to high maternal-fetal mortality of untreated flu).",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding.",
            sideEffects = "Nausea (10%), vomiting (8%), headache, abdominal pain, insomnia, rare neuropsychiatric events (hallucinations, delirium, abnormal behavior in adolescents).",
            priceNpr = "NPR 350.00 - 650.00 per strip of 10 (75mg)",
            priceInr = "INR 220.00 - 450.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Antiflu", "Cipla Nepal", "Cap", "75 mg"),
                BrandInfo("Tamiflu", "Roche / Medisales Nepal", "Cap", "75 mg"),
                BrandInfo("Fluvir", "Hetero Healthcare Nepal", "Cap", "75 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tamiflu", "Roche", "Cap", "75 mg"),
                BrandInfo("Antiflu", "Cipla", "Cap", "75 mg"),
                BrandInfo("Fluvir", "Hetero", "Cap", "75 mg")
            ),
            pediatricDosePerKg = 3.0,
            pediatricInterval = "mg/kg PO BID x 5 days (based on weight tiers)",
            adultDose = "75 mg PO BID x 5 days (prophylaxis: 75 mg OD x 10 days).",
            childDose = "Weight <=15kg: 30mg BID; 15-23kg: 45mg BID; 23-40kg: 60mg BID; >40kg: 75mg BID x 5 days.",
            contraindications = "Known hypersensitivity to oseltamivir phosphate.",
            modeOfAction = "Potent, selective inhibitor of influenza viral neuraminidase glycoprotein, preventing cleavage of terminal sialic acid residues and trapping newly formed virions at the host cell surface, halting viral spread.",
            therapeuticClassTag = "Antivirals / Influenza"
        ),

        // ==========================================
        // UROLOGY, RHEUMATOLOGY & OPHTHALMOLOGY
        // ==========================================
        Drug(
            id = "d_uro_silodosin",
            genericName = "Silodosin",
            system = "Renal & Genitourinary",
            drugClass = "Highly Selective Alpha-1A Adrenoceptor Antagonist",
            blackBoxWarning = null,
            indications = "Benign Prostatic Hyperplasia (BPH) lower urinary tract symptoms (LUTS: weak stream, hesitancy, nocturia), medical expulsive therapy for distal ureteral calculi.",
            doses = "Adult: 8 mg PO once daily with a meal (preferably dinner). Patients with moderate renal impairment (CrCl 30-50 mL/min): 4 mg PO once daily.",
            administration = "Take orally once daily with food. Swallow capsule whole.",
            timing = "Evening with dinner.",
            specialInstructions = "HIGHEST UROSELECTIVITY: Has 162-fold higher affinity for alpha-1A receptors (prostate) over alpha-1B receptors (blood vessels), producing lowest incidence of orthostatic hypotension compared to tamsulosin or alfuzosin. High retrograde ejaculation rate (28%).",
            pkPd = "Bioavailability ~32%. Protein binding 97%. Metabolized by UGT2B7 and CYP3A4 to active glucuronide metabolite. Elimination half-life ~13.3 hours.",
            renalAdj = "CrCl 50-80 mL/min: 8 mg OD. CrCl 30-50 mL/min: Reduce to 4 mg OD. CrCl <30 mL/min: CONTRAINDICATED.",
            hepaticAdj = "Severe hepatic impairment: Contraindicated.",
            pregnancy = "Not indicated for women.",
            lactation = "Not indicated for women.",
            sideEffects = "Retrograde ejaculation / anejaculation (28%), dizziness, nasal congestion, diarrhea, orthostatic hypotension, headache.",
            priceNpr = "NPR 120.00 - 240.00 per strip of 10 (4mg / 8mg)",
            priceInr = "INR 80.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Silodal", "Sun Pharma Nepal", "Cap", "4 mg / 8 mg"),
                BrandInfo("Sildoo", "Intas Pharmaceuticals", "Cap", "4 mg / 8 mg"),
                BrandInfo("Rapaflo", "Allergan / Nepal Dist.", "Cap", "8 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Silodal", "Sun Pharma", "Cap", "4 / 8 mg"),
                BrandInfo("Sildoo", "Intas", "Cap", "4 / 8 mg")
            ),
            adultDose = "8 mg PO once daily with dinner (4 mg in CrCl 30-50).",
            childDose = "Not indicated in children.",
            contraindications = "Severe renal impairment (CrCl <30 mL/min), severe hepatic impairment, concomitant strong CYP3A4 inhibitors (ketoconazole, clarithromycin).",
            modeOfAction = "Exerts extreme selective antagonism of alpha-1A adrenergic receptors concentrated in the prostate, prostatic capsule, bladder neck, and prostatic urethra, relaxing smooth muscle and reducing bladder outflow resistance.",
            therapeuticClassTag = "Urological Alpha-blockers"
        ),

        Drug(
            id = "d_uro_dutasteride",
            genericName = "Dutasteride",
            system = "Renal & Genitourinary",
            drugClass = "Dual 5-Alpha Reductase Inhibitor (Type 1 & Type 2)",
            blackBoxWarning = "INCREASED RISK OF HIGH-GRADE PROSTATE CANCER: 5-alpha reductase inhibitors reduce overall prostate cancer incidence but may slightly increase the risk of high-grade prostate cancer.",
            indications = "Benign Prostatic Hyperplasia (BPH) with enlarged prostate gland (>30 mL), prevention of BPH progression and reduction of acute urinary retention (AUR) and surgery risk, male androgenetic alopecia.",
            doses = "0.5 mg PO once daily with or without food. Can be given as monotherapy or combined with Tamsulosin 0.4 mg daily (Combodart).",
            administration = "Swallow soft gelatin capsule whole. Do not open, chew, or crush (contents irritate oropharyngeal mucosa).",
            timing = "Once daily at consistent time.",
            specialInstructions = "DUAL ISOENZYME INHIBITION: Inhibits both Type 1 and Type 2 5-alpha reductase, lowering serum DHT by >90% (vs 70% with finasteride). Reduces prostate volume by ~25%. Lowers baseline PSA by 50% after 6 months (double the measured PSA value when screening for cancer).",
            pkPd = "Bioavailability ~60%. Extremely high protein binding (99.5%). Extensively metabolized by CYP3A4. Extremely long terminal elimination half-life (~5 weeks).",
            renalAdj = "No dosage adjustment necessary in renal failure or hemodialysis.",
            hepaticAdj = "Contraindicated in severe hepatic impairment due to extensive hepatic clearance.",
            pregnancy = "Category X (Women who are or may become pregnant must not touch leaking capsules; absorption causes feminization of external genitalia in male fetus).",
            lactation = "Contraindicated; not indicated for women.",
            sideEffects = "Erectile dysfunction (5-8%), decreased libido, ejaculatory disorders, gynecomastia and breast tenderness (1-2%), depression.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (0.5mg)",
            priceInr = "INR 70.00 - 150.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Dutas", "Dr. Reddy's Nepal", "Cap", "0.5 mg"),
                BrandInfo("Duprost", "Cipla Nepal", "Cap", "0.5 mg"),
                BrandInfo("Combodart", "GSK Nepal", "Cap", "Dutasteride 0.5mg + Tamsulosin 0.4mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Dutas", "Dr. Reddy's", "Cap", "0.5 mg"),
                BrandInfo("Avodart", "GSK", "Cap", "0.5 mg")
            ),
            adultDose = "0.5 mg PO once daily.",
            childDose = "Not indicated in pediatric patients.",
            contraindications = "Pregnancy or women of childbearing potential, pediatric patients, severe hepatic impairment, severe hypersensitivity.",
            modeOfAction = "Inhibits both Type 1 and Type 2 5-alpha reductase enzymes, blocking conversion of testosterone to 5-dihydrotestosterone (DHT) in the prostate gland and hair follicles.",
            therapeuticClassTag = "Urology / 5-Alpha Reductase"
        ),

        Drug(
            id = "d_rheum_hydroxychloroquine",
            genericName = "Hydroxychloroquine Sulfate",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Disease-Modifying Antirheumatic Drug (DMARD) & 4-Aminoquinoline",
            blackBoxWarning = null,
            indications = "Systemic Lupus Erythematosus (SLE - mandatory baseline therapy reducing mortality and organ damage), Rheumatoid Arthritis, Discoid Lupus, primary Sjogren's syndrome, unlabelled use in antiphospholipid syndrome.",
            doses = "SLE / Rheumatoid Arthritis: 200 to 400 mg PO daily (max weight-based dose <= 5.0 mg/kg/day of actual body weight to minimize long-term retinal toxicity).",
            administration = "Take orally with a meal or a glass of milk to minimize gastrointestinal distress.",
            timing = "Once daily with evening meal or divided BID.",
            specialInstructions = "RETINAL SCREENING: Baseline comprehensive ophthalmological examination (fundus, visual field 10-2, spectral-domain OCT) within 1st year, then annually after 5 years of therapy to detect irreversible chloroquine retinopathy (bull's-eye maculopathy).",
            pkPd = "Oral bioavailability ~74%. Huge volume of distribution with extensive tissue binding (melanin-containing structures, liver, spleen). Half-life 40-50 days. Slow onset (takes 6-12 weeks for therapeutic response).",
            renalAdj = "eGFR <30 mL/min: Reduce dose by 25-50% and perform more frequent retinal examinations.",
            hepaticAdj = "Use with caution in hepatic disease.",
            pregnancy = "Category B (Safe throughout pregnancy and lactation; mandatory to CONTINUE in pregnant SLE patients to prevent maternal lupus flare, congenital heart block, and pre-eclampsia).",
            lactation = "Excreted in small amounts in breast milk; compatible with breastfeeding (AAP approved).",
            sideEffects = "Nausea, abdominal cramps, diarrhea, skin hyperpigmentation (bluish-gray patches on shins/palate), headache, irreversible bull's-eye retinopathy, myopathy, QTc prolongation, hypoglycemia.",
            priceNpr = "NPR 90.00 - 180.00 per strip of 10 (200mg / 400mg)",
            priceInr = "INR 60.00 - 120.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("HCQS", "IPCA Laboratories Nepal", "Tab", "200 mg / 300 mg / 400 mg"),
                BrandInfo("Plaquenil", "Sanofi Nepal", "Tab", "200 mg"),
                BrandInfo("Zy-Q", "Zydus Nepal", "Tab", "200 mg / 400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("HCQS", "IPCA", "Tab", "200 / 300 / 400 mg"),
                BrandInfo("Plaquenil", "Sanofi", "Tab", "200 mg")
            ),
            adultDose = "200-400 mg PO daily (max <= 5 mg/kg/day actual weight).",
            childDose = "3-5 mg/kg/day PO (max 400 mg/day).",
            contraindications = "Pre-existing retinopathy of the macula, known hypersensitivity to 4-aminoquinolines, long-term use in children.",
            modeOfAction = "Accumulates in intracellular acidic vacuoles (lysosomes), increasing endosomal pH, inhibiting antigen processing by APCs, blocking Toll-like receptor (TLR-7, TLR-9) signaling, and downregulating pro-inflammatory cytokine production.",
            therapeuticClassTag = "Rheumatoid Arthritis (RA) / DMARD"
        ),

        Drug(
            id = "d_eye_timolol",
            genericName = "Timolol Maleate 0.5% Eye Drops",
            system = "Dermatology",
            drugClass = "Non-Selective Beta-Adrenergic Receptor Antagonist Ophthalmic Solution",
            blackBoxWarning = null,
            indications = "Open-angle glaucoma, ocular hypertension, secondary glaucoma (reduction of elevated intraocular pressure).",
            doses = "Instill 1 drop of 0.25% or 0.5% solution into the affected eye(s) once or twice daily.",
            administration = "Perform nasolacrimal occlusion (compress the lacrimal sac at inner canthus with finger for 2 minutes) immediately following instillation to minimize systemic nasopharyngeal absorption.",
            timing = "Morning or morning and evening.",
            specialInstructions = "SYSTEMIC ABSORPTION CAUSES SEVERE CARDIOPULMONARY SIDE EFFECTS: Eye drops enter nasal mucosa via tear duct and reach systemic circulation directly without first-pass hepatic metabolism. Strictly contraindicated in severe bronchial asthma and bradycardia.",
            pkPd = "Ocular onset within 15-30 minutes; peak IOP reduction at 1-2 hours. Duration of intraocular pressure reduction up to 24 hours.",
            renalAdj = "No adjustment needed for topical eye drops.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Nasolacrimal occlusion essential; alternative like brimonidine preferred in 1st/2nd trimester).",
            lactation = "Concentrates in breast milk; perform punctal occlusion or use alternative.",
            sideEffects = "Ocular stinging/burning, dry eyes, superficial punctate keratitis, systemic bronchospasm in asthmatics, symptomatic bradycardia, hypotension, syncope, fatigue.",
            priceNpr = "NPR 60.00 - 130.00 per 5 mL bottle (0.5%)",
            priceInr = "INR 40.00 - 85.00 per 5 mL bottle",
            brandsNepal = listOf(
                BrandInfo("Glucomol", "Allergan / Medisales Nepal", "Drops", "0.25% / 0.5% (5 mL)"),
                BrandInfo("Timolong", "Sun Pharma Nepal", "Drops", "0.5% (5 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Glucomol", "Allergan", "Drops", "0.5%"),
                BrandInfo("Iotim", "FDC", "Drops", "0.5%")
            ),
            adultDose = "1 drop in affected eye(s) BID (or OD for long-acting gel).",
            childDose = "1 drop in affected eye(s) BID (monitor pulse and respiration).",
            contraindications = "Bronchial asthma or history of severe COPD, severe sinus bradycardia (<50 bpm), second or third degree AV block, overt cardiogenic shock, decompensated heart failure.",
            modeOfAction = "Competitively blocks beta-1 and beta-2 adrenergic receptors in the ciliary body epithelium, reducing cyclic AMP synthesis and decreasing the secretion and formation of aqueous humor by 30-50%.",
            therapeuticClassTag = "Glaucoma & Ophthalmology"
        )
    )
}
