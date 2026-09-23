package com.example.data.repository

import com.example.data.model.PharmacologyGuide
import com.example.data.model.PharmacologySection

object PharmacologyReviewData {

    val guides: List<PharmacologyGuide> = listOf(
        // 1. INSULIN PREPARATIONS & DIABETES PHARMACOLOGY
        PharmacologyGuide(
            id = "pg_insulin",
            title = "Insulin Preparations & Anti-Diabetic Agents",
            category = "Endocrinology",
            subtitle = "Pharmacokinetics, onset/duration, mixing rules & anti-hyperglycemic classes",
            tags = listOf("Insulin", "Diabetes", "Endocrine", "Glargine", "Metformin", "SGLT-2", "DPP-4"),
            clinicalPearls = listOf(
                "CRITICAL RULE: Only Regular (crystalline zinc) insulin can be administered intravenously (IV).",
                "Glargine is formulated at acidic pH 4.0; it precipitates at physiological pH forming a depot. NEVER mix Glargine with any other insulin in the same syringe.",
                "Lispro exists as monomers (does not self-associate into hexamers), granting ultra-rapid absorption within 15-20 min.",
                "Subcutaneous injection sites: Abdomen (fastest absorption, avoid 2 inches around umbilicus), anterior thigh, buttocks, and upper outer arm. Rotate sites to prevent lipodystrophy."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Insulin Formulations: Onset, Duration & Clinical Pearls",
                    text = "Conventional insulins are bovine/porcine; modern recombinant human insulins and analogs provide predictable physiological basal-bolus coverage.",
                    tableHeaders = listOf("Type & Analog", "Onset", "Duration", "Clinical Comments"),
                    tableRows = listOf(
                        listOf("Rapid Acting: Lispro", "15–20 min", "3–4 hours", "Formulated as monomer; mealtime bolus 15 min prior to food"),
                        listOf("Rapid Acting: Aspart", "15–20 min", "3–4 hours", "Proline replaced with aspartic acid; most rapidly acting analog"),
                        listOf("Rapid Acting: Glulisine", "15–20 min", "3–4 hours", "Fast mealtime postprandial glucose control"),
                        listOf("Short Acting: Regular (Crystalline)", "30–60 min", "5–8 hours", "ONLY insulin given IV (DKA/HHS protocol); given 30 min before meals"),
                        listOf("Intermediate: NPH / Isophane", "1–2 hours", "16–18 hours", "Neutral Protamine Hagedorn; cloudy suspension, twice-daily basal"),
                        listOf("Intermediate: Lente", "1–2 hours", "16–20 hours", "Zinc-suspension; intermediate peak"),
                        listOf("Long Acting: Glargine (U-100/U-300)", "4–6 hours", "20–24 hours", "Supplied at pH 4.0; peakless basal; NEVER mix in syringe"),
                        listOf("Long Acting: Detemir", "2–4 hours", "20–24 hours", "Fatty acid chain binds albumin; once or twice daily basal"),
                        listOf("Ultra-Long Acting: Degludec", "2–4 hours", "24–40 hours", "Forms multi-hexamer chains in SC tissue; flexible daily dosing")
                    )
                ),
                PharmacologySection(
                    heading = "Oral Anti-Hyperglycemic Agents Master Classification",
                    text = "1. Insulin Secretagogues: Sulfonylureas (1st gen: Chlorpropamide, Tolbutamide; 2nd gen: Glimepiride, Gliclazide, Glipizide) & Meglitinides (Repaglinide, Nateglinide - rapid pre-meal secretagogues).\n" +
                            "2. Biguanides: Metformin (AMPK activator, suppresses hepatic gluconeogenesis; 1st line T2DM; withhold if eGFR < 30 mL/min to prevent lactic acidosis).\n" +
                            "3. Thiazolidinediones (TZDs): Pioglitazone, Rosiglitazone (PPAR-gamma agonists; improve peripheral insulin sensitivity; risk of fluid retention, contraindicated in NYHA Class III/IV CHF).\n" +
                            "4. SGLT-2 Inhibitors: Dapagliflozin, Empagliflozin, Canagliflozin (block renal proximal tubular glucose reabsorption; cardiorenal protection in CKD/HFrEF; watch for euglycemic DKA & mycotic infections).\n" +
                            "5. DPP-4 Inhibitors (Gliptins): Sitagliptin, Vildagliptin, Linagliptin, Saxagliptin (inhibit incretin breakdown; weight neutral; Linagliptin requires no renal dose adjustment).\n" +
                            "6. GLP-1 Receptor Agonists: Liraglutide, Semaglutide, Dulaglutide (potent weight loss, cardiovascular risk reduction, slow gastric emptying; C/I in MEN-2 or medullary thyroid carcinoma).\n" +
                            "7. Alpha-Glucosidase Inhibitors: Acarbose, Miglitol (inhibit intestinal brush-border oligosaccharide digestion; reduce postprandial glucose surges)."
                )
            )
        ),

        // 2. CORTICOSTEROIDS & STERIOD PHARMACOLOGY
        PharmacologyGuide(
            id = "pg_corticosteroids",
            title = "Corticosteroids & Synthesis Inhibitors",
            category = "Endocrinology",
            subtitle = "Potency spectrum, mineralocorticoid ratios, GLUCOCORTICOIDS mnemonic & inhibitors",
            tags = listOf("Steroids", "Dexamethasone", "Hydrocortisone", "Prednisolone", "Cushing", "Addison"),
            mnemonic = "GLUCOCORTICOIDS (Adverse Effects & Contraindications):\n" +
                    "• G - Glaucoma (topical ocular use)\n" +
                    "• L - Limb muscle atrophy (steroid myopathy)\n" +
                    "• U - Ulcer (peptic ulceration, especially with NSAIDs)\n" +
                    "• C - Cushing's syndrome (moon facies, buffalo hump, central adiposity)\n" +
                    "• O - Osteoporosis & vertebral compression fractures\n" +
                    "• C - Cataract (posterior subcapsular from systemic use)\n" +
                    "• O - Osteonecrosis (avascular necrosis of the femoral head)\n" +
                    "• R - C/I in Renal failure\n" +
                    "• T - C/I in active Tuberculosis (ileo-caecal, unless covered by ATT)\n" +
                    "• I - Impair wound healing & collagen synthesis\n" +
                    "• C - C/I in Congestive Heart Failure (due to sodium/fluid retention)\n" +
                    "• O - Oedema (mineralocorticoid sodium reabsorption)\n" +
                    "• I - Infections (suppresses CMI > humoral immunity, masking fever/signs)\n" +
                    "• D - Diabetes mellitus (steroid-induced hyperglycemia)\n" +
                    "• S - Suppression of Hypothalamic-Pituitary-Adrenal (HPA) axis (never abrupt stop!)",
            clinicalPearls = listOf(
                "Acute Adrenal Crisis is a life-threatening medical emergency: immediately administer IV Hydrocortisone 100 mg stat followed by 100 mg q8h + isotonic saline resuscitation.",
                "Dexamethasone has ZERO mineralocorticoid activity with maximal glucocorticoid potency, making it the agent of choice for cerebral edema and COVID-19/ARDS.",
                "Hydrocortisone has the highest mineralocorticoid activity among standard glucocorticoids (1:1 Glucocorticoid to Mineralocorticoid ratio).",
                "Chronic Addison's Disease requires physiological oral Hydrocortisone (15-25 mg/day in divided doses) combined with oral Fludrocortisone (0.05-0.1 mg/day) for aldosterone replacement."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Glucocorticoid & Mineralocorticoid Potency Spectrum",
                    text = "Relative anti-inflammatory vs salt-retaining potencies calibrated against Hydrocortisone (1.0).",
                    tableHeaders = listOf("Drug", "Duration of Action", "Anti-inflammatory Potency", "Mineralocorticoid Potency"),
                    tableRows = listOf(
                        listOf("Hydrocortisone (Cortisol)", "Short (8–12 hours)", "1.0 (Standard)", "1.0 (Highest among G)"),
                        listOf("Cortisone", "Short (8–12 hours)", "0.8 (Least potent G)", "0.8"),
                        listOf("Prednisone (Prodrug)", "Intermediate (12–36 hours)", "4.0", "0.8"),
                        listOf("Prednisolone", "Intermediate (12–36 hours)", "4.0", "0.8"),
                        listOf("Methylprednisolone", "Intermediate (12–36 hours)", "5.0", "0.5"),
                        listOf("Triamcinolone", "Intermediate (12–36 hours)", "5.0", "0.0 (Zero salt retention)"),
                        listOf("Dexamethasone", "Long (36–72 hours)", "25–30 (Maximum G)", "0.0 (Zero salt retention)"),
                        listOf("Betamethasone", "Long (36–72 hours)", "25–30 (Maximum G)", "0.0 (Zero salt retention)"),
                        listOf("Fludrocortisone", "Intermediate (12–36 hours)", "10.0", "125–250 (Potent M)"),
                        listOf("Aldosterone", "Short", "0.3", "3000 (Maximum M)")
                    )
                ),
                PharmacologySection(
                    heading = "Steroid Synthesis Inhibitors & Receptor Blockers",
                    text = "1. Metyrapone: Inhibits 11-beta-hydroxylase (prevents cortisol synthesis, shifts to 11-deoxycortisol; used in diagnostic evaluation and medical Cushing's control).\n" +
                            "2. Ketoconazole & Abiraterone: Inhibit 17-alpha-hydroxylase & 17,20-lyase (Cushing's and metastatic prostate carcinoma).\n" +
                            "3. Mitotane: Direct cytotoxic action on adrenal cortical mitochondria; medical adrenalectomy for adrenal carcinoma.\n" +
                            "4. Mifepristone (RU-486): Progesterone and glucocorticoid receptor antagonist; used for medical abortion and severe hypercortisolemia in inoperable Cushing's.\n" +
                            "5. Spironolactone & Eplerenone: Aldosterone receptor antagonists (potassium-sparing diuretics; reduce mortality in HFrEF)."
                )
            )
        ),

        // 3. PROGESTINS, AROMATASE INHIBITORS & ANDROGENS
        PharmacologyGuide(
            id = "pg_repro_hormones",
            title = "Progestins, Aromatase Inhibitors & Androgen Antagonists",
            category = "Endocrinology",
            subtitle = "Generations of synthetic progestins, Letrozole vs Exemestane & Finasteride pathways",
            tags = listOf("Progestins", "Letrozole", "Finasteride", "Drospirenone", "PCOS", "Breast Cancer"),
            clinicalPearls = listOf(
                "Drospirenone (4th generation) possesses antimineralocorticoid (aldosterone receptor antagonist) and antiandrogenic properties, making it ideal for women with PCOS and fluid retention.",
                "Letrozole & Anastrozole are Type II non-steroidal reversible aromatase inhibitors; first-line therapy for postmenopausal hormone receptor-positive breast cancer.",
                "Finasteride & Dutasteride inhibit 5-alpha-reductase, blocking conversion of Testosterone to Dihydrotestosterone (DHT) for BPH and male androgenic alopecia.",
                "Cyproterone acetate has marked progestational activity that inhibits pituitary feedback of LH and FSH; used in hirsutism and severe acne."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Progestin Generations & Clinical Properties",
                    text = "Synthetic progestins vary significantly in their androgenic, glucocorticoid, and mineralocorticoid receptor affinity.",
                    tableHeaders = listOf("Generation", "Compounds", "Key Pharmacological Profile"),
                    tableRows = listOf(
                        listOf("1st Generation (Estranes)", "Norethindrone, Norethynodrel, Lynestrenol", "Weak estrogenic, androgenic, and anabolic activity; potent anti-ovulatory"),
                        listOf("2nd Generation (Gonanes)", "Levonorgestrel, Norgestrel", "More potent than 1st gen; higher androgenic activity (acne, weight gain)"),
                        listOf("3rd Generation", "Desogestrel, Norgestimate, Gestodene", "Very potent anti-ovulatory; significantly reduced androgenic effects (less acne/hirsutism)"),
                        listOf("4th Generation", "Nomegestrol, Drospirenone", "Anti-androgenic; Drospirenone blocks aldosterone receptors (beneficial in fluid retention & PCOS)")
                    )
                ),
                PharmacologySection(
                    heading = "Aromatase Inhibitors Classification",
                    text = "• Type I (Steroidal, Irreversible suicide inhibitors): Exemestane, Formestane.\n" +
                            "• Type II (Non-steroidal, Reversible competitive inhibitors): Letrozole, Anastrozole, Fadrozole, Vorozole."
                )
            )
        ),

        // 4. ANTIEPILEPTIC DRUGS & MOA
        PharmacologyGuide(
            id = "pg_aeds",
            title = "Antiepileptic Drugs (AEDs) Mechanism Matrix",
            category = "Neurology",
            subtitle = "Exact molecular synaptic targets: Na+, K+, GABA, T-type Ca2+, SV2A, and AMPA",
            tags = listOf("Epilepsy", "Seizures", "Phenytoin", "Valproate", "Levetiracetam", "Ethosuximide"),
            clinicalPearls = listOf(
                "Ethosuximide is the drug of choice for pure Absence Seizures (petit mal) by selectively blocking T-type Ca2+ channels in thalamic relay neurons.",
                "Sodium Valproate is a broad-spectrum AED acting via multiple mechanisms: prolongs Na+ channel inactivation, increases brain GABA, and blocks T-type Ca2+ channels.",
                "Levetiracetam & Brivaracetam selectively bind to Synaptic Vesicle Glycoprotein 2A (SV2A) to inhibit exocytosis of excitatory neurotransmitters.",
                "Gabapentin & Pregabalin bind to the alpha-2-delta subunit of presynaptic voltage-gated Ca2+ channels to attenuate glutamate release."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Comprehensive Mechanism of Action Classification",
                    text = "AEDs act by decreasing excitatory transmission (Na+, Ca2+, Glutamate) or augmenting inhibitory tone (GABA, K+ channels).",
                    tableHeaders = listOf("Mechanism Target", "Antiepileptic Agents", "Clinical Utility"),
                    tableRows = listOf(
                        listOf("1. Prolong Inactivated Na+ Channels", "Phenytoin, Fosphenytoin, Carbamazepine, Oxcarbazepine, Valproate, Lamotrigine, Lacosamide, Zonisamide, Rufinamide", "Focal & generalized tonic-clonic seizures; Lacosamide selectively enhances slow inactivation"),
                        listOf("2. K+ Channel Openers", "Retigabine (Ezogabine), Topiramate", "Hyperpolarizes neuronal membranes via KCNQ channels"),
                        listOf("3. Decrease Glutamate / AMPA Activity", "Perampanel (AMPA antagonist), Lamotrigine, Topiramate, Felbamate", "Refractory focal seizures; black box warning for homicidal ideation/aggression with Perampanel"),
                        listOf("4. Augment GABAergic Activity", "Valproate (inhibits GABA-T), Tiagabine (GAT-1 inhibitor), Barbiturates (Phenobarbitone), Benzodiazepines (Diazepam, Lorazepam, Clobazam)", "Status epilepticus (Lorazepam IV first-line), juvenile myoclonic epilepsy, neonatal seizures"),
                        listOf("5. T-Type Ca2+ Channel Blockers", "Ethosuximide, Valproate, Zonisamide", "Absence seizures (3 Hz spike-and-wave discharges)"),
                        listOf("6. SV2A Vesicular Protein Binding", "Levetiracetam, Brivaracetam", "Broad-spectrum; excellent tolerability, minimal drug-drug interactions, high therapeutic index"),
                        listOf("7. Alpha-2-Delta Ca2+ Subunit", "Gabapentin, Pregabalin", "Neuropathic pain (diabetic neuropathy, post-herpetic neuralgia) and focal seizures")
                    )
                )
            )
        ),

        // 5. MULTIPLE SCLEROSIS DRUGS
        PharmacologyGuide(
            id = "pg_multiple_sclerosis",
            title = "Multiple Sclerosis Disease-Modifying Drugs",
            category = "Neurology",
            subtitle = "Route, dosing schedule, fatal adverse effects, PML & safety monitoring",
            tags = listOf("Multiple Sclerosis", "Natalizumab", "Fingolimod", "PML", "Interferon", "Neurology"),
            clinicalPearls = listOf(
                "Natalizumab (alpha-4 integrin antagonist) carries a major risk of Progressive Multifocal Leukoencephalopathy (PML) caused by JC virus reactivation; test JC virus antibody prior to and during therapy.",
                "Fingolimod (S1P receptor modulator) causes transient bradycardia and 1st-degree heart block; mandatory 6-hour continuous ECG observation after the first dose.",
                "Mitoxantrone has the broadest indication in MS (RRMS, SPMS, PRMS), but is strictly limited by cumulative lifetime dose due to irreversible cardiotoxicity and acute leukemia risk.",
                "Dalfampridine is a potassium (K+) channel blocker approved specifically to improve walking speed in MS patients; contraindicated in patients with seizure history."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Disease Modifying Therapies (DMTs) in Multiple Sclerosis",
                    text = "DMTs prevent clinical relapses and delay disability progression in relapsing-remitting multiple sclerosis (RRMS).",
                    tableHeaders = listOf("Drug", "Route", "Frequency", "Major Adverse Effects & Black Box Warnings"),
                    tableRows = listOf(
                        listOf("Interferon-beta 1a", "IM / SC", "Weekly or 3x/week", "Flu-like symptoms, neutralizing antibodies, depression"),
                        listOf("Interferon-beta 1b", "SC", "Alternate days", "Injection site necrosis, flu-like symptoms"),
                        listOf("Glatiramer Acetate", "SC", "3x/week or daily", "Lipoatrophy, post-injection flushing and chest tightness"),
                        listOf("Natalizumab", "IV Infusion", "Once every 4 weeks", "PML (JC virus reactivation), especially if used > 2 years; neutralizing antibodies"),
                        listOf("Fingolimod", "Oral", "Once daily", "First-degree AV block, bradycardia, macular edema, herpes zoster"),
                        listOf("Mitoxantrone", "IV Infusion", "Once in 3 months", "Cardiotoxicity (dilated cardiomyopathy, check LVEF), secondary acute leukemia"),
                        listOf("Dimethyl Fumarate", "Oral", "Twice daily", "PML, flushing, abdominal pain, lymphopenia"),
                        listOf("Teriflunomide", "Oral", "Once daily", "Severe hepatotoxicity, teratogenicity (requires cholestyramine washout)"),
                        listOf("Alemtuzumab (anti-CD52)", "IV Infusion", "Daily for 5 days (yr 1), 3 days (yr 2)", "Secondary autoimmunity (Graves disease, ITP, Goodpasture syndrome), herpes zoster"),
                        listOf("Dalfampridine (4-Aminopyridine)", "Oral", "Once daily", "Seizures, urinary tract infections, insomnia")
                    )
                )
            )
        ),

        // 6. ANTIPSYCHOTICS, ANTIDEPRESSANTS & PARKINSON'S
        PharmacologyGuide(
            id = "pg_psychiatry_neuro",
            title = "Antipsychotics, Antidepressants & Anti-Parkinson Drugs",
            category = "Psychiatry",
            subtitle = "Typical vs Atypical, EPS risk, Clozapine ANC monitoring, SSRIs/TCAs & Levodopa/COMT",
            tags = listOf("Antipsychotics", "Clozapine", "Haloperidol", "SSRIs", "Parkinson", "Levodopa"),
            clinicalPearls = listOf(
                "Clozapine is the most effective drug for treatment-resistant schizophrenia and prevents suicide, but carries life-threatening agranulocytosis (1%) and myocarditis; weekly ANC monitoring is mandatory.",
                "Olanzapine and Clozapine carry the highest risk of metabolic syndrome, extreme weight gain, and new-onset diabetes among atypicals.",
                "Tricyclic Antidepressant (TCA) overdose causes life-threatening ventricular arrhythmias via fast sodium-channel blockade; the specific antidote is IV Sodium Bicarbonate (NaHCO3).",
                "Carbidopa does not cross the blood-brain barrier; it inhibits peripheral DOPA decarboxylase, increasing Levodopa delivery to the brain from 1-3% up to 10% and minimizing nausea and postural hypotension."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Antipsychotics: Typical vs Atypical Comparison",
                    text = "• Typical Neuroleptics (High D2 affinity, high EPS, hyperprolactinemia):\n" +
                            "  - Phenothiazines: Chlorpromazine, Thioridazine (retinal pigmentation, QT prolongation), Trifluoperazine, Fluphenazine.\n" +
                            "  - Butyrophenones: Haloperidol (severe acute dystonia, parkinsonism), Droperidol.\n" +
                            "  - Thioxanthenes: Flupenthixol, Thiothixene.\n" +
                            "• Atypical Antipsychotics (High 5-HT2A / moderate D2 affinity, low EPS, high metabolic risk):\n" +
                            "  - Clozapine (agranulocytosis, seizures, sialorrhea; zero EPS)\n" +
                            "  - Olanzapine (pronounced weight gain and dyslipidemia)\n" +
                            "  - Risperidone & Paliperidone (highest prolactin elevation among atypicals)\n" +
                            "  - Quetiapine (sedating, preferred in Parkinson's disease psychosis)\n" +
                            "  - Aripiprazole (D2 partial agonist; lowest metabolic impact and weight neutral)\n" +
                            "  - Ziprasidone (significant QT prolongation; take with food)\n" +
                            "  - Lurasidone & Cariprazine (favorable metabolic profile; approved for bipolar depression)"
                ),
                PharmacologySection(
                    heading = "Antidepressant Master Classification",
                    text = "1. SSRIs (1st Line): Escitalopram, Sertraline, Fluoxetine, Paroxetine, Fluvoxamine, Citalopram.\n" +
                            "2. SNRIs: Venlafaxine, Duloxetine (DOC in diabetic neuropathic pain + depression), Milnacipran.\n" +
                            "3. TCAs: Amitriptyline, Imipramine, Clomipramine, Nortriptyline (anticholinergic side effects, fatal in cardiac overdose).\n" +
                            "4. MAO Inhibitors: Non-selective (Tranylcypromine, Phenelzine); Selective MAO-A (Moclobemide - cheese reaction absent).\n" +
                            "5. Atypical Agents: Mirtazapine (presynaptic alpha-2 antagonist; causes sedation and appetite increase), Bupropion (NDRI; no sexual dysfunction; C/I in epilepsy/eating disorders), Trazodone (5-HT2 antagonist, causes priapism), Vortioxetine (multimodal 5-HT modulator)."
                ),
                PharmacologySection(
                    heading = "Anti-Parkinsonian Drugs Site of Action",
                    text = "• Levodopa: Crosses BBB via L-neutral amino acid transporter; converted to Dopamine centrally.\n" +
                            "• Carbidopa & Benserazide: Inhibit peripheral DOPA decarboxylase to maximize central Levodopa delivery.\n" +
                            "• COMT Inhibitors: Entacapone (acts only in periphery); Tolcapone (acts both centrally & peripherally, but causes fulminant hepatotoxicity).\n" +
                            "• MAO-B Inhibitors: Selegiline, Rasagiline (inhibit central dopamine degradation into DOPAC; neuroprotective potential).\n" +
                            "• Dopamine Receptor Agonists: Pramipexole, Ropinirole (non-ergot; causes impulse control disorders like gambling), Bromocriptine (ergot).\n" +
                            "• Anticholinergics: Trihexyphenidyl, Benztropine (restore dopamine-acetylcholine balance; preferred for tremor)."
                )
            )
        ),

        // 7. ANTICOAGULANTS & ANTIPLATELETS
        PharmacologyGuide(
            id = "pg_anticoagulants",
            title = "Anticoagulants, Antiplatelets & Reversal Antidotes",
            category = "Hematology",
            subtitle = "VKORC1, Factor Xa, Direct Thrombin Inhibitors, P2Y12 agents & specific reversal",
            tags = listOf("Warfarin", "Heparin", "NOAC", "DOAC", "Aspirin", "Clopidogrel", "Apixaban"),
            clinicalPearls = listOf(
                "Warfarin inhibits VKORC1, blocking gamma-carboxylation of clotting factors II, VII, IX, X and regulatory proteins C and S. Reversal: 4-Factor PCC + IV Vitamin K1.",
                "Dabigatran is the only oral Direct Thrombin (Factor IIa) Inhibitor; its specific humanized Fab antidote is Idarucizumab (Praxbind 5 g IV).",
                "Factor Xa inhibitors (Apixaban, Rivaroxaban) are reversed by recombinant decoy protein Andexanet alfa.",
                "Clopidogrel is an irreversible prodrug requiring hepatic CYP2C19 activation; PPIs like Omeprazole competitively inhibit CYP2C19, diminishing its antiplatelet efficacy (prefer Pantoprazole)."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Anticoagulants: Target, Route & Antidote Registry",
                    text = "Distinguish oral direct vs indirect parenterals and their immediate clinical reversal agents.",
                    tableHeaders = listOf("Drug Class", "Examples", "Target Mechanism", "Specific Antidote / Reversal"),
                    tableRows = listOf(
                        listOf("Vitamin K Antagonists", "Warfarin, Acenocoumarol, Dicumarol", "Inhibits VKORC1 (Factors II, VII, IX, X)", "4-Factor PCC + IV Vitamin K1 (Phytomenadione)"),
                        listOf("Oral Direct Thrombin Inhibitor", "Dabigatran etexilate", "Direct competitive Factor IIa inhibitor", "Idarucizumab (Praxbind 5 g IV)"),
                        listOf("Parenteral Direct Thrombin Inhibitors", "Bivalirudin, Argatroban, Lepirudin", "Direct IIa inhibition; DOC in HIT (Heparin Induced Thrombocytopenia)", "No direct antidote; short half-life"),
                        listOf("Oral Factor Xa Inhibitors", "Rivaroxaban, Apixaban, Edoxaban", "Direct Factor Xa active site blocker", "Andexanet alfa; 4-Factor PCC"),
                        listOf("Unfractionated Heparin (UFH)", "Heparin sodium", "Potentiates Antithrombin III against IIa & Xa (1:1 ratio)", "Protamine Sulfate (1 mg neutralizes 100 U Heparin)"),
                        listOf("LMWH", "Enoxaparin, Dalteparin, Tinzaparin", "Predominantly anti-Factor Xa (ratio 3:1 to 4:1)", "Protamine Sulfate (partially neutralizes ~60%)"),
                        listOf("Synthetic Pentasaccharide", "Fondaparinux, Idraparinux", "Selective Antithrombin-mediated Xa inhibition", "None; Andexanet alfa off-label")
                    )
                ),
                PharmacologySection(
                    heading = "Antiplatelet Drugs Classification",
                    text = "• COX-1 Inhibitor: Aspirin (irreversible acetylation of Ser529 in COX-1, halting TXA2 production for the 7–10 day platelet lifespan).\n" +
                            "• ADP (P2Y12) Receptor Antagonists:\n" +
                            "  - Irreversible: Clopidogrel (CYP2C19 prodrug), Prasugrel (more potent, rapid; C/I in prior stroke/TIA), Ticlopidine (severe neutropenia risk).\n" +
                            "  - Reversible: Ticagrelor (allosteric oral antagonist; causes dyspnea and ventricular pauses), Cangrelor (ultra-rapid IV).\n" +
                            "• Glycoprotein IIb/IIIa Antagonists: Abciximab (monoclonal antibody), Tirofiban (peptidomimetic), Eptifibatide (cyclic heptapeptide).\n" +
                            "• Phosphodiesterase (PDE) Inhibitors: Dipyridamole (inhibits PDE and adenosine reuptake), Cilostazol (PDE3 inhibitor for intermittent claudication).\n" +
                            "• PAR-1 Thrombin Receptor Antagonist: Vorapaxar, Atopaxar."
                )
            )
        ),

        // 8. ANTIMICROBIAL MASTERCLASS & CEPHALOSPORINS
        PharmacologyGuide(
            id = "pg_antimicrobials",
            title = "Antimicrobials, Cephalosporin Generations & Mechanisms",
            category = "Infectious Disease",
            subtitle = "Cephalosporin 1st–5th gen mnemonics, 30S/50S ribosomal targets & G6PD hemolysis drugs",
            tags = listOf("Antibiotics", "Cephalosporins", "Penicillins", "G6PD", "MRSA", "Pseudomonas"),
            mnemonic = "Cephalosporin Generation Mnemonics:\n" +
                    "• 1st Gen: 'A' after Cef = 1st Gen (e.g., CefAlexin, CefAdroxil, CefAzolin, CefAclor is 2nd exception).\n" +
                    "• 2nd Gen with Anaerobic Activity: Cefoxitin and Cefotetan are active against Bacteroides fragilis.\n" +
                    "• 4th Gen: Drugs with 'PI' in the name (CefePIme, CefPIrome).\n" +
                    "• 5th Gen: Drugs with 'ROL' in the name (CeftaROLine, CeftobipROLe) - Active against MRSA!",
            clinicalPearls = listOf(
                "Ceftriaxone is excreted mainly via bile (40%) and kidneys (60%); no dosage adjustment is required in moderate renal impairment.",
                "Aminoglycosides (Gentamicin, Amikacin) bind irreversibly to the 30S ribosomal subunit to cause misreading of mRNA and freeze translation initiation; they are bactericidal.",
                "Linezolid binds to the 23S rRNA of the 50S subunit; active against MRSA and VRE. It is a weak reversible MAO inhibitor, risking Serotonin Syndrome with SSRIs/SNRIs.",
                "G6PD Deficiency Hemolysis Culprits: Primaquine, Chloroquine, Dapsone, Nitrofurantoin, Sulfamethoxazole, Rasburicase, Nalidixic acid."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Cephalosporin Generations Spectrum & Route Matrix",
                    text = "Progresses from predominantly Gram-positive coverage (1st gen) to broad Gram-negative, Pseudomonas, and MRSA coverage.",
                    tableHeaders = listOf("Generation", "Oral Agents", "Parenteral Agents", "Clinical Spectrum"),
                    tableRows = listOf(
                        listOf("1st Generation", "Cephalexin, Cefadroxil, Cephradine", "Cefazolin", "Gram-positive cocci (MSSA, Strep); Cefazolin is DOC for surgical prophylaxis"),
                        listOf("2nd Generation", "Cefuroxime axetil, Cefaclor, Cefprozil, Loracarbef", "Cefuroxime, Cefoxitin, Cefotetan, Cefmetazole", "Expanded Gram-negative (E. coli, Klebsiella, H. influenzae); Cefoxitin/Cefotetan cover anaerobes (B. fragilis)"),
                        listOf("3rd Generation", "Cefixime, Cefpodoxime, Ceftibuten, Cefdinir, Cefditoren", "Ceftriaxone, Cefotaxime, Ceftazidime, Cefoperazone", "Crosses BBB (Meningitis: Ceftriaxone/Cefotaxime); Ceftazidime & Cefoperazone cover Pseudomonas"),
                        listOf("4th Generation", "None (Parenteral only)", "Cefepime, Cefpirome", "Broadest spectrum: covers Pseudomonas aeruginosa AND Gram-positive cocci"),
                        listOf("5th Generation", "None (Parenteral only)", "Ceftaroline fosamil, Ceftobiprole", "Only cephalosporins active against MRSA (binds PBP-2a) & penicillin-resistant Strep")
                    )
                ),
                PharmacologySection(
                    heading = "Ribosomal Protein Synthesis Inhibitors (30S vs 50S)",
                    text = "• 30S Ribosomal Subunit Targets:\n" +
                            "  - Aminoglycosides (Gentamicin, Amikacin, Tobramycin, Streptomycin): Freeze initiation complex, cause misreading of mRNA. Bactericidal, concentration-dependent killing, nephro/ototoxicity.\n" +
                            "  - Tetracyclines & Glycylcyclines (Doxycycline, Minocycline, Tigecycline): Block aminoacyl-tRNA attachment to the ribosomal A site. Bacteriostatic.\n" +
                            "• 50S Ribosomal Subunit Targets:\n" +
                            "  - Chloramphenicol: Inhibits peptidyl transferase (inhibits peptide bond formation). Aplastic anemia, Gray Baby syndrome.\n" +
                            "  - Macrolides (Azithromycin, Clarithromycin, Erythromycin) & Lincosamides (Clindamycin): Inhibit translocation of peptide chain from A to P site.\n" +
                            "  - Streptogramins (Quinupristin/Dalfopristin): Sequential inhibition of protein elongation.\n" +
                            "  - Oxazolidinones (Linezolid): Binds 23S fraction of 50S, halts 70S initiation complex assembly. Active against MRSA & VRE."
                ),
                PharmacologySection(
                    heading = "Beta-Lactamase Classification Summary",
                    text = "• Group 1 (Class C): Cephalosporinases (AmpC); not inhibited by clavulanate or tazobactam; inducible by cefoxitin/carbapenems.\n" +
                            "• Group 2 (Class A & D): Serine beta-lactamases, Penicillinases, ESBLs (Extended Spectrum Beta-Lactamases); inhibited by Clavulanate and Tazobactam.\n" +
                            "• Group 3 (Class B): Metallo-beta-lactamases (NDM-1, VIM, IMP); contain zinc ion; hydrolyze all carbapenems and beta-lactams EXCEPT Aztreonam; inhibited by EDTA."
                )
            )
        ),

        // 9. ANTI-TUBERCULOSIS DRUGS & WHO REGIMENS
        PharmacologyGuide(
            id = "pg_antitb",
            title = "Anti-Tubercular (TB) Regimens & WHO MDR-TB Grouping",
            category = "Infectious Disease",
            subtitle = "First-line HRZE molecular targets, toxicities & WHO Groups A, B, C, D MDR-TB drugs",
            tags = listOf("Tuberculosis", "Isoniazid", "Rifampicin", "Pyrazinamide", "Ethambutol", "MDR-TB"),
            clinicalPearls = listOf(
                "Isoniazid (H) is a prodrug activated by mycobacterial KatG catalase-peroxidase; active forms inhibit InhA (enoyl-ACP reductase) to block mycolic acid cell wall synthesis. Co-prescribe Pyridoxine 10-25 mg/day to prevent peripheral neuropathy.",
                "Rifampicin (R) binds the beta-subunit of bacterial DNA-dependent RNA polymerase; it is a profound CYP3A4 inducer and causes harmless orange-red discoloration of body fluids.",
                "Pyrazinamide (Z) is bactericidal only in the acidic environment of necrotic caseous granulomas; it frequently causes hyperuricemia and arthralgias.",
                "Ethambutol (E) inhibits arabinosyl transferase (embB); causes retrobulbar optic neuritis with decreased visual acuity and red-green dyschromatopsia; the ONLY bacteriostatic first-line agent."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "First-Line Anti-Tubercular Drugs Master Profile",
                    text = "Standard short-course therapy: 2 months HRZE (Intensive phase) followed by 4 months HR (Continuation phase).",
                    tableHeaders = listOf("Drug (Abbr)", "Mechanism of Action", "Activity & Penetration", "Major Toxicities & Pearls"),
                    tableRows = listOf(
                        listOf("Isoniazid (H)", "Activated by KatG; inhibits InhA to block mycolic acid", "Bactericidal against rapid multipliers (intra & extra)", "Hepatotoxicity, peripheral neuritis (prevent with Pyridoxine / Vit B6), lupus-like syndrome"),
                        listOf("Rifampicin (R)", "Inhibits DNA-dependent RNA polymerase", "Bactericidal against slow/intermittent spurters", "Hepatotoxicity, potent CYP3A4 inducer, orange discoloration of urine/tears, flu syndrome"),
                        listOf("Pyrazinamide (Z)", "Converted to pyrazinoic acid; lowers intracellular pH", "Bactericidal in acidic caseous macrophage environment", "Hepatotoxicity (highest risk), hyperuricemia, arthralgia, sideroblastic anemia"),
                        listOf("Ethambutol (E)", "Inhibits arabinosyl transferase (embB gene)", "Bacteriostatic; prevents emergence of resistance", "Retrobulbar optic neuritis (loss of red-green vision), contraindicated in children < 5 years"),
                        listOf("Streptomycin (S)", "Binds 30S ribosomal subunit; aminoglycoside", "Bactericidal against extracellular cavity organisms", "Ototoxicity (vestibular/cochlear), nephrotoxicity, contraindicated in pregnancy")
                    )
                ),
                PharmacologySection(
                    heading = "WHO Classification for MDR-TB Drugs",
                    text = "• Group A (Fluoroquinolones): Levofloxacin, Moxifloxacin, Gatifloxacin (include in all MDR regimens unless resistant).\n" +
                            "• Group B (Second-Line Injectables): Amikacin, Capreomycin, Kanamycin, Streptomycin.\n" +
                            "• Group C (Core Second-Line Agents): Ethionamide / Prothionamide, Cycloserine / Terizidone, Linezolid, Clofazimine.\n" +
                            "• Group D (Add-on Agents):\n" +
                            "  - D1: Pyrazinamide, Ethambutol, High-dose Isoniazid.\n" +
                            "  - D2: Bedaquiline (inhibits mycobacterial ATP synthase), Delamanid (inhibits methoxy-mycolic and keto-mycolic acid)."
                )
            )
        ),

        // 10. TOXICOLOGY, CHELATING AGENTS & ANTIDOTES
        PharmacologyGuide(
            id = "pg_toxicology_antidotes",
            title = "Toxicology, Chelating Agents & Antidotes",
            category = "Toxicology",
            subtitle = "Heavy metal chelation (BAL, DMSA, Penicillamine, Deferasirox) & specific poison antidotes",
            tags = listOf("Antidote", "Chelation", "Poisoning", "Paracetamol", "Lead", "Arsenic", "Iron"),
            clinicalPearls = listOf(
                "BAL (Dimercaprol) is formulated in peanut oil (check peanut allergy); CONTRAINDICATED in Iron and Cadmium poisoning because BAL-metal complexes are more nephrotoxic than the free metal.",
                "D-Penicillamine is the oral chelator for Wilson's disease (Copper) and cystinuria; if intolerant, switch to Trientine.",
                "For acute Acetaminophen (Paracetamol) overdose, IV N-acetylcysteine (NAC) restores hepatic glutathione; most effective when initiated within 8 hours of ingestion.",
                "Scorpion stings cause autonomic storm and massive catecholamine surge leading to pulmonary edema; Prazosin (alpha-1 blocker) is the physiological antidote of choice."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Heavy Metal Chelating Agents Table",
                    text = "Chelators bind heavy metal cations with high affinity to form stable, water-soluble, nontoxic ring complexes for urinary excretion.",
                    tableHeaders = listOf("Chelating Agent", "Route", "Heavy Metal Poisons Treated", "Contraindications / Clinical Pearls"),
                    tableRows = listOf(
                        listOf("Dimercaprol (BAL)", "IM (in peanut oil)", "Arsenic, Lead (with EDTA), Mercury, Gold", "CONTRAINDICATED in Iron and Cadmium; causes hypertension and tachycardia"),
                        listOf("Succimer (DMSA)", "Oral", "Lead (pediatric), Arsenic, Cadmium, Mercury", "Water-soluble analog of BAL; well-tolerated orally without lipid formulation"),
                        listOf("Unithiol (DMPS)", "IV / Oral", "Mercury, Arsenic, Lead", "Water-soluble parenteral alternative to BAL"),
                        listOf("Calcium Disodium EDTA", "IV Infusion", "Lead (plumbism), Zinc, Cadmium, Manganese, Iron", "MUST use calcium disodium salt to prevent fatal acute hypocalcemia"),
                        listOf("D-Penicillamine", "Oral", "Copper (Wilson's disease), Lead, Mercury, Cystinuria", "Risk of aplastic anemia, nephrotic syndrome, drug-induced myasthenia"),
                        listOf("Trientine (TETA)", "Oral", "Copper (Wilson's disease)", "Preferred in patients intolerant to D-penicillamine"),
                        listOf("Desferrioxamine (Deferoxamine)", "IV / SC Infusion", "Acute Iron toxicity, transfusion hemochromatosis", "Chelates free ferric iron; turns urine vin-rose (red-orange) color"),
                        listOf("Deferiprone & Deferasirox", "Oral", "Chronic Iron overload (Thalassemia major)", "Convenient oral iron chelators; Deferasirox once daily"),
                        listOf("Dicobalt EDTA", "IV", "Severe Cyanide poisoning", "Rapid cyanide binder; toxic if given without cyanide"),
                        listOf("DTPA (Ca/Zn-DTPA)", "IV / Inhalation", "Uranium, Plutonium, Americium, Curium", "Transuranic radionuclide internal decontamination")
                    )
                ),
                PharmacologySection(
                    heading = "Specific Clinical Antidotes Master List",
                    text = "• Isoniazid (INH) overdose: Pyridoxine (Vitamin B6) 1 g IV per gram of INH ingested (halts refractory seizures).\n" +
                            "• Acetaminophen (Paracetamol): N-acetylcysteine (NAC - replenishes glutathione reserves).\n" +
                            "• Opioids: Naloxone (0.4–2 mg IV/IM, repeat q2-3 min; pure competitive mu antagonist).\n" +
                            "• Lithium toxicity: Hemodialysis (antidote of choice for severe toxicity > 2.5–4.0 mEq/L).\n" +
                            "• Serotonin Syndrome: Cyproheptadine (5-HT2A antagonist) + supportive cooling.\n" +
                            "• Scorpion Sting: Prazosin (alpha-1 blocker counteracts alpha-receptor-mediated vasoconstriction).\n" +
                            "• Atropine / Anticholinergics: Physostigmine (tertiary carbamate, crosses BBB into CNS).\n" +
                            "• Calcium Channel Blockers: Calcium Gluconate 10% IV + High-Dose Insulin Euglycemia Therapy (HIET).\n" +
                            "• Beta-Blockers: Glucagon IV (activates myocardial adenylyl cyclase bypassing beta receptors).\n" +
                            "• Theophylline / Caffeine toxicity: Esmolol (ultra-short acting beta-blocker).\n" +
                            "• Methanol / Ethylene Glycol: Fomepizole (alcohol dehydrogenase inhibitor) or IV Ethanol.\n" +
                            "• Benzodiazepines: Flumazenil (GABAA competitive antagonist; caution: precipitates withdrawal seizures in chronic users)."
                ),
                PharmacologySection(
                    heading = "Street Slang Names of Drugs of Abuse",
                    text = "• GHB (Gamma Hydroxybutyrate): Liquid Ecstasy, Grievous Bodily Harm.\n" +
                            "• Phencyclidine (PCP) & Ketamine: Angel Dust, Hog, Special K.\n" +
                            "• Cocaine: Crack (vaporized form), Rush, Coke, Snow, Blow, Peruvian Marching Powder.\n" +
                            "• MDMA: Ecstasy, Molly, XTC.\n" +
                            "• LSD (Lysergic Acid Diethylamide): Acid, Windowpane, Twenty-Five, Blotter."
                )
            )
        ),

        // 11. HUMAN TERATOGENS IN PREGNANCY
        PharmacologyGuide(
            id = "pg_teratogens",
            title = "Human Teratogenic Drugs & Congenital Anomalies",
            category = "Obstetrics & Teratology",
            subtitle = "Complete registry of fetal malformations caused by drugs in human pregnancy",
            tags = listOf("Teratogen", "Pregnancy", "Valproate", "Lithium", "Ebstein", "Isotretinoin", "Thalidomide"),
            clinicalPearls = listOf(
                "Sodium Valproate carries the highest rate of major congenital malformations (~10%) and neural tube defects (1-2%); strictly avoid in women of childbearing potential unless no alternative exists.",
                "Lithium use during the 1st trimester is classically associated with Ebstein's Anomaly (apical displacement of the tricuspid valve leaflets with atrialization of the right ventricle).",
                "Isotretinoin is one of the most potent human teratogens known; requires two negative pregnancy tests and two effective contraception methods under strict risk management programs.",
                "ACE inhibitors & ARBs administered in the 2nd and 3rd trimesters impair fetal renal perfusion, leading to oligohydramnios, hypocalvaria, pulmonary hypoplasia, and neonatal renal failure."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Registry of Proven Human Teratogenic Drugs",
                    text = "Susceptibility to teratogens is highest during organogenesis (weeks 3 to 8 post-conception).",
                    tableHeaders = listOf("Drug / Chemical", "Congenital Anomalies & Syndromes Produced"),
                    tableRows = listOf(
                        listOf("ACE Inhibitors & ARBs", "IUGR, oligohydramnios, hypocalvaria (calvarial skull defects), PDA, renal dysgenesis, neonatal anuria"),
                        listOf("Alcohol", "Fetal Alcohol Syndrome (FAS): IUGR, microcephaly, smooth/flat philtrum, thin vermilion border, ASD/VSD, mental retardation"),
                        listOf("Antithyroid Drugs (Carbimazole, Methimazole)", "Fetal hypothyroidism, congenital goiter, Aplasia Cutis Congenita (scalp skin defects), choanal atresia (use PTU in 1st trimester)"),
                        listOf("Androgens", "Virilization of female fetus, ambiguous external genitalia, limb/cardiac defects"),
                        listOf("Carbamazepine", "Neural tube defects (spina bifida), fingernail hypoplasia, craniofacial defects similar to fetal hydantoin syndrome"),
                        listOf("Diethylstilbestrol (DES)", "Clear cell adenocarcinoma of the vagina/cervix in female offspring, T-shaped uterine cavity, hypospadias in males"),
                        listOf("Isotretinoin (Retinoids)", "Craniofacial dysmorphism, microtia (absent/small ears), thymic hypoplasia, aortic arch and conotruncal cardiac malformations, hydrocephalus"),
                        listOf("Lithium", "Ebstein's anomaly (downward apical displacement of tricuspid valve into right ventricle, severe tricuspid regurgitation)"),
                        listOf("Misoprostol", "Moebius syndrome (congenital bilateral cranial nerve VI and VII palsies leading to facial paralysis), terminal limb reduction defects"),
                        listOf("Methotrexate", "Cranial ossification defects, hydrocephalus, meningomyelocele, cleft palate, limb and external ear hypoplasia"),
                        listOf("Phenytoin", "Fetal Hydantoin Syndrome: Microcephaly, cleft lip and palate, hypoplastic distal phalanges and nails, developmental delay"),
                        listOf("Tetracyclines & Doxycycline", "Permanent yellow-brown discoloration of deciduous and permanent teeth, enamel hypoplasia, inhibition of fetal fibular bone growth"),
                        listOf("Thalidomide", "Phocomelia (seal-like flipper limbs), amelia (complete absence of limbs), external ear and heart defects"),
                        listOf("Sodium Valproate", "Neural tube defects (lumbosacral spina bifida 1-2%), trigonocephaly, facial dysmorphism, autism spectrum disorder, cognitive impairment"),
                        listOf("Warfarin", "Fetal Warfarin Syndrome: Chondrodysplasia punctata (stippled epiphyses on X-ray), nasal hypoplasia, optic atrophy, mental retardation")
                    )
                )
            )
        ),

        // 12. ANTICANCER DRUGS & CELL CYCLE SPECIFICITY
        PharmacologyGuide(
            id = "pg_anticancer",
            title = "Anticancer Chemotherapy: Cell Cycle Specificity",
            category = "Oncology",
            subtitle = "CCS vs CCNS classification, S-phase antimetabolites, M-phase vinca/taxanes & organ toxicities",
            tags = listOf("Oncology", "Chemotherapy", "Methotrexate", "Cisplatin", "Doxorubicin", "Bleomycin"),
            clinicalPearls = listOf(
                "Doxorubicin and Daunorubicin cause cumulative dose-dependent dilated cardiomyopathy via iron-mediated free radical generation; cardioprotect with Dexrazoxane.",
                "Cyclophosphamide and Ifosfamide produce acrolein in the urine, causing severe hemorrhagic cystitis; prevent with high-dose hydration and Mesna (mercaptoethane sulfonate).",
                "Bleomycin acts in the G2 phase to break DNA strands; it is notably bone-marrow sparing but causes dose-limiting pulmonary fibrosis.",
                "Cisplatin causes intense nephrotoxicity, ototoxicity, and severe emesis; require aggressive IV pre-hydration with normal saline."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Cell Cycle Specific (CCS) vs Non-Specific (CCNS) Agents",
                    text = "CCS drugs kill cells actively dividing during specific cell-cycle checkpoints; CCNS kill cells regardless of division stage.",
                    tableHeaders = listOf("Cell Cycle Phase", "Anticancer Drug Class", "Representative Agents", "Mechanism & Specific Toxicity"),
                    tableRows = listOf(
                        listOf("S Phase (DNA Synthesis)", "Antimetabolites", "Methotrexate, 5-FU, Capecitabine, 6-MP, Gemcitabine, Cytarabine", "Inhibit dihydrofolate reductase / thymidylate synthase; myelosuppression, mucositis"),
                        listOf("G1 Phase", "Topoisomerase II inhibitor", "Etoposide", "Inhibits DNA religation; secondary leukemia risk"),
                        listOf("G2 Phase", "Antitumor antibiotic", "Bleomycin", "Generates free radicals; causes pulmonary fibrosis (zero myelosuppression)"),
                        listOf("M Phase (Mitosis)", "Vinca Alkaloids", "Vincristine, Vinblastine, Vinorelbine", "Inhibit tubulin polymerization into microtubules; Vincristine = peripheral neuropathy & ileus; Vinblastine = marrow suppression"),
                        listOf("M Phase (Mitosis)", "Taxanes & Epothilones", "Paclitaxel, Docetaxel, Cabazitaxel, Ixabepilone", "Hyper-stabilize polymerized microtubules; peripheral neuropathy, neutropenia"),
                        listOf("CCNS (Non-Specific)", "Alkylating Agents", "Cyclophosphamide, Ifosfamide, Melphalan, Nitrosoureas", "Cross-link DNA guanine N-7; hemorrhagic cystitis (Mesna preventive)"),
                        listOf("CCNS (Non-Specific)", "Platinum Compounds", "Cisplatin, Carboplatin, Oxaliplatin", "Form intrastrand DNA adducts; Cisplatin = severe nephrotoxicity and ototoxicity; Oxaliplatin = acute cold neuropathy"),
                        listOf("CCNS (Non-Specific)", "Anthracyclines", "Doxorubicin, Daunorubicin, Epirubicin", "Intercalate DNA + Topo II; dilated cardiomyopathy (Dexrazoxane preventive)")
                    )
                )
            )
        ),

        // 13. LAXATIVES & BOWEL PREPARATION
        PharmacologyGuide(
            id = "pg_laxatives",
            title = "Laxatives, Purgatives & Bowel Evacuants",
            category = "Gastroenterology",
            subtitle = "Bulk-forming, osmotic, stimulant purgatives, prokinetics and novel secretagogues",
            tags = listOf("Laxatives", "Constipation", "Lactulose", "PEG", "Bisacodyl", "Prucalopride"),
            clinicalPearls = listOf(
                "Lactulose is non-absorbable disaccharide broken down by colonic flora into lactic and acetic acids, trapping ammonia as unabsorbable ammonium (NH4+); cornerstone therapy for hepatic encephalopathy.",
                "Polyethylene Glycol (PEG / Macrogol) is the gold standard osmotic agent for colonoscopy bowel preparation; causes minimal electrolyte flux compared to sodium phosphate.",
                "Prucalopride is a selective high-affinity 5-HT4 receptor agonist that stimulates colonic mass movements for chronic idiopathic constipation.",
                "Methylnaltrexone & Alvimopan are peripherally acting mu-opioid receptor antagonists (PAMORAs) that relieve opioid-induced constipation without crossing the blood-brain barrier."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Classification of Laxatives & Purgatives",
                    text = "• Luminally Active Agents:\n" +
                            "  - Bulk-forming: Psyllium (Isabgol husk), Methylcellulose, Dietary bran (absorb water and expand; require adequate fluid intake).\n" +
                            "  - Stool Softeners / Surfactants: Docusate sodium, Liquid paraffin (emulsify stool; liquid paraffin can cause lipid pneumonia if aspirated).\n" +
                            "  - Osmotics: Lactulose (hepatic encephalopathy), Polyethylene Glycol (PEG - colonoscopy prep), Magnesium Hydroxide (Milk of Magnesia), Sorbitol.\n" +
                            "• Stimulant / Irritant Purgatives:\n" +
                            "  - Diphenylmethanes: Bisacodyl, Sodium picosulfate (stimulate mucosal plexus; take on empty stomach).\n" +
                            "  - Anthraquinones: Senna, Cascara (cause harmless Melanosis Coli with prolonged use).\n" +
                            "  - Castor Oil: Hydrolyzed to ricinoleic acid in small intestine.\n" +
                            "• Prokinetics:\n" +
                            "  - 5-HT4 Agonists: Prucalopride (high selectivity, zero cardiac HERG channel toxicity).\n" +
                            "  - D2 Receptor Antagonists: Metoclopramide, Domperidone (upper GI prokinetic & antiemetic).\n" +
                            "• Secretory & Novel Agents:\n" +
                            "  - Lubiprostone: Activates apical type-2 chloride channels (ClC-2), stimulating chloride and fluid secretion into lumen.\n" +
                            "  - Linaclotide & Plecanatide: Guanylate cyclase-C agonists that elevate cGMP and induce CFTR chloride secretion.\n" +
                            "  - PAMORAs: Methylnaltrexone, Alvimopan, Naloxegol (for refractory opioid-induced bowel dysfunction)."
                )
            )
        ),

        // 14. RESPIRATORY PHARMACOLOGY & ASTHMA
        PharmacologyGuide(
            id = "pg_respiratory",
            title = "Respiratory Pharmacology: Asthma & COPD",
            category = "Pulmonology",
            subtitle = "Bronchodilators, inhaled corticosteroids, leukotriene inhibitors & biologics",
            tags = listOf("Asthma", "COPD", "Salbutamol", "Budesonide", "Montelukast", "Omalizumab"),
            clinicalPearls = listOf(
                "Only Bronchodilators (SABA like Salbutamol, anticholinergics like Ipratropium) terminate acute severe attacks of bronchial asthma.",
                "Inhaled Corticosteroids (Budesonide, Fluticasone) are the foundation of long-term asthma control by suppressing eosinophilic and Th2 cytokine airway inflammation.",
                "Leukotriene Receptor Antagonists (Montelukast, Zafirlukast) are orally effective, especially beneficial in aspirin-exacerbated respiratory disease (AERD) and exercise-induced bronchospasm.",
                "Omalizumab is a recombinant humanized monoclonal antibody directed against circulating IgE, preventing its binding to high-affinity Fc-epsilon-RI receptors on mast cells."
            ),
            sections = listOf(
                PharmacologySection(
                    heading = "Bronchodilators vs Anti-Inflammatory Pathways",
                    text = "• 1. Bronchodilators (Acute Attack Relievers):\n" +
                            "  - Sympathomimetics (Beta-2 Agonists): SABA (Salbutamol, Levosalbutamol, Terbutaline - onset < 5 min, duration 4–6 h); LABA (Salmeterol, Formoterol - duration 12 h); Ultra-LABA (Indacaterol, Vilanterol - 24 h once daily).\n" +
                            "  - Parasympatholytics (Muscarinic Antagonists): SAMA (Ipratropium bromide); LAMA (Tiotropium, Glycopyrronium, Umeclidinium - DOC in COPD).\n" +
                            "  - Methylxanthines: Theophylline, Doxofylline (non-selective PDE inhibitor and adenosine receptor antagonist; narrow therapeutic window).\n" +
                            "• 2. Anti-Inflammatory Agents (Controllers):\n" +
                            "  - Inhaled Corticosteroids (ICS): Budesonide, Fluticasone propionate, Beclomethasone, Ciclesonide (prodrug activated in airway).\n" +
                            "  - Mast Cell Stabilizers: Sodium Cromoglycate, Nedocromil, Ketotifen (inhibit degranulation upon antigen exposure; prophylactic only).\n" +
                            "  - Leukotriene Modifiers: LT-Receptor Antagonists (Montelukast, Zafirlukast); 5-Lipoxygenase Inhibitor (Zileuton).\n" +
                            "  - Targeted Monoclonals: Omalizumab (anti-IgE), Mepolizumab / Benralizumab (anti-IL-5 for severe eosinophilic asthma), Dupilumab (anti-IL-4/IL-13)."
                )
            )
        )
    )
}
