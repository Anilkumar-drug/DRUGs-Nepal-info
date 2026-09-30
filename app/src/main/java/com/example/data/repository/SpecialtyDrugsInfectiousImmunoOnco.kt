package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object SpecialtyDrugsInfectiousImmunoOnco {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // 8. ANTI HELMINTHES (ANTHELMINTIC AGENTS)
        // ==========================================

        // --- OLDER / CLASSICAL ANTHELMINTICS ---
        Drug(
            id = "d_hel_piperazine",
            genericName = "Piperazine Citrate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Classical Anthelmintic (GABA Receptor Agonist)",
            era = "Older / Classical",
            therapeuticClassTag = "Anti helminthes",
            researchNotes = "Classical anthelmintic introduced in the 1950s. Acts as a GABA-mimetic agonist at neuromuscular junctions of nematodes, inducing flaccid paralysis allowing live worms to be expelled by normal intestinal peristalsis; superseded by albendazole.",
            indications = "Ascariasis (roundworm infection) and Enterobiasis (pinworm / threadworm infection).",
            doses = "Ascariasis: Adults: 3.5 g PO once daily for 2 consecutive days. Children: 75 mg/kg/day (max 3.5 g) for 2 days. Enterobiasis: 65 mg/kg/day (max 2.5 g) for 7 days.",
            adultDose = "3.5 g PO single daily dose for 2 days",
            childDose = "75 mg/kg/day (max 3.5 g) for 2 consecutive days",
            administration = "Take orally with or without food. Can be mixed with syrups or fruit juices.",
            timing = "Single daily dose for 2 consecutive days.",
            specialInstructions = "DO NOT COMBINE WITH PYRANTEL PAMOATE: Pyrantel induces spastic paralysis while piperazine induces flaccid paralysis; the two mechanisms antagonize each other.",
            pkPd = "GABA receptor agonist on nematode somatic muscle cells, increasing chloride ion permeability and causing hyperpolarization and flaccid neuromuscular paralysis. Rapid oral absorption; excreted renally. Half-life ~7-14h.",
            renalAdj = "CONTRAINDICATED in severe renal impairment (causes neurotoxicity, ataxia, seizures).",
            hepaticAdj = "CONTRAINDICATED in hepatic impairment.",
            pregnancy = "Category B (Avoid in 1st trimester; albendazole preferred in 2nd/3rd trimester).",
            lactation = "Use with caution.",
            sideEffects = "Nausea, vomiting, abdominal colic, transient neurological symptoms (ataxia, tremors, nystagmus, seizures in renal failure), urticaria.",
            priceNpr = "NPR 35.00 - 65.00 per bottle (30mL syrup)",
            priceInr = "INR 20.00 - 45.00 per bottle (30mL syrup)",
            brandsNepal = listOf(
                BrandInfo("Antepar", "GSK Nepal / Classical", "Elixir / Syrup", "500 mg / 5 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Antepar", "GlaxoSmithKline India", "Syrup", "500 mg / 5 mL"),
                BrandInfo("Piperazine Citrate", "Bengal Chemicals", "Syrup", "750 mg / 5 mL")
            ),
            pediatricDosePerKg = 75.0,
            pediatricInterval = "mg/kg daily for 2 days in ascariasis",
            contraindications = "Severe renal or hepatic impairment, history of epilepsy or neurological disorders, concomitant pyrantel pamoate.",
            modeOfAction = "Mimics GABA at nematode neuromuscular junctions, hyperpolarizing muscle membranes and causing reversible flaccid paralysis.",
            interactions = "Pyrantel pamoate (antagonistic mode of action; never combine), Chlorpromazine (increases seizure risk).",
            packSize = "Bottle of 30 mL syrup (500 mg/5 mL)",
            counselingNepali = "यो जुका परेको बेला खुवाइने पुरानो औषधि हो। यसले जुकालाई लठ्ठ बनाएर दिसाबाट बाहिर निकाल्छ। काम्ने बिरामी वा मृगौलाको समस्या भएकाहरूले खानुहुँदैन।",
            counselingEnglish = "Classical roundworm treatment. Do not use with pyrantel. Contraindicated in kidney disease or epilepsy."
        ),

        // --- NEWER / MODERN STANDARDS ANTHELMINTICS ---
        Drug(
            id = "d_hel_albendazole",
            genericName = "Albendazole",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Broad-Spectrum Benzimidazole Anthelmintic",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti helminthes",
            researchNotes = "Modern broad-spectrum benzimidazole gold standard. Highly effective against intestinal roundworms, hookworms, whipworms, and pinworms with a single 400 mg dose; prolonged high-dose therapy with steroids is the global standard for neurocysticercosis and hydatid disease.",
            blackBoxWarning = "BONE MARROW SUPPRESSION & EMBRYOTOXICITY: High-dose chronic therapy (neurocysticercosis/hydatid) can cause fatal pancytopenia and hepatotoxicity. Check CBC and LFTs every 2 weeks. Contraindicated in pregnancy.",
            indications = "Parenchymal neurocysticercosis (Taenia solium larvae), cystic echinococcosis (hydatid disease), enterobiasis, ascariasis, ancylostomiasis / hookworm, strongyloidiasis, cutaneous larva migrans.",
            doses = "Intestinal nematodes: 400 mg PO single dose (chewed). Neurocysticercosis: 15 mg/kg/day PO divided BID with fatty meals for 8-30 days (max 800 mg/day) with concurrent corticosteroid. Hydatid: 15 mg/kg/day in 28-day cycles.",
            adultDose = "400 mg PO chewed single dose (Tissue/CNS: 15 mg/kg/day divided BID with fatty meal)",
            childDose = "Children ≥2 years: 400 mg PO single dose. Children 1-2 years: 200 mg single dose.",
            administration = "CHEW TABLET THOROUGHLY. For intestinal worms: take on an empty stomach. For systemic tissue infections (neurocysticercosis/hydatid): TAKE WITH A HIGH-FAT MEAL to increase systemic absorption 5- to 8-fold!",
            timing = "Single dose for intestinal worms; BID with meals for tissue cysts.",
            specialInstructions = "Always co-prescribe dexamethasone or prednisolone in neurocysticercosis to suppress severe inflammatory edema triggered by dying cysticerci in brain parenchyma.",
            pkPd = "Inhibits beta-tubulin polymerization in helminth cells, disrupting microtubule assembly and glucose uptake. Hepatically metabolized to active metabolite albendazole sulfoxide, which crosses blood-brain barrier. Half-life: 8-12 hours.",
            renalAdj = "No dosage adjustment required.",
            hepaticAdj = "Discontinue if liver enzymes increase >2x upper limit of normal during chronic therapy.",
            pregnancy = "Category C / Contraindicated in pregnancy (teratogenic in animals; verify negative pregnancy test before starting 28-day courses).",
            lactation = "Compatible with breastfeeding for single doses; exercise caution during chronic therapy.",
            sideEffects = "Mild abdominal cramps, headache, elevated transaminases (16% during prolonged therapy), reversible leukopenia, alopecia (prolonged therapy).",
            priceNpr = "NPR 10.00 - 22.00 per tab (400mg) / FREE at Government Health Posts",
            priceInr = "INR 7.00 - 15.00 per tab (400mg)",
            brandsNepal = listOf(
                BrandInfo("Zentel", "GlaxoSmithKline Nepal", "Chewable Tab", "400 mg"),
                BrandInfo("Alminth", "Nepal Pharmaceuticals Lab", "Chewable Tab", "400 mg"),
                BrandInfo("Noworm", "Alkem Nepal", "Chewable Tab", "400 mg"),
                BrandInfo("Bandikind", "Mankind Nepal", "Chewable Tab / Syr", "400 mg / 200mg/5mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Zentel", "GSK India", "Chewable Tab / Suspension", "400 mg / 200mg/5mL"),
                BrandInfo("Bandikind", "Mankind Pharma", "Chewable Tab", "400 mg"),
                BrandInfo("Noworm", "Alkem Laboratories", "Chewable Tab", "400 mg"),
                BrandInfo("Albez", "Sun Pharma", "Chewable Tab", "400 mg")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "mg/kg/day divided BID for neurocysticercosis in children",
            contraindications = "Pregnancy, known hypersensitivity to benzimidazoles.",
            modeOfAction = "Binds to colchicine-sensitive site of tubulin, inhibiting microtubule polymerization and blocking glucose uptake, depleting glycogen stores and killing the parasite.",
            interactions = "Dexamethasone, Cimetidine, Praziquantel (increase plasma levels of active albendazole sulfoxide by ~50%).",
            packSize = "Single-tablet blister pack (400 mg)",
            counselingNepali = "यो जुकाको सबैभन्दा भरपर्दो चपाएर खाने चक्की हो। साधारण जुकाका लागि एक चक्की चपाएर खाए पुग्छ। दिमागमा जुकाको अण्डा परेको (Neurocysticercosis) छ भने चिल्लो खानासँग डाक्टरको कडा निगरानीमा खानुपर्छ।",
            counselingEnglish = "Chew tablet thoroughly. Single dose for intestinal worms. Take with fatty foods and steroids when treating brain tapeworm cysts."
        ),

        // --- UNDER RESEARCH / PIPELINE ANTHELMINTICS ---
        Drug(
            id = "d_hel_emodepside",
            genericName = "Emodepside",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Investigational Cyclodepsipeptide Anthelmintic (Latrophilin Receptor Agonist)",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti helminthes",
            researchNotes = "BREAKTHROUGH PIPELINE ANTHELMINTIC: Novel semi-synthetic cyclodepsipeptide fermentation product from Mycelia sterilia. DNDi (Drugs for Neglected Diseases initiative) and Bayer have advanced emodepside into Phase II/III human trials for onchocerciasis (river blindness) and soil-transmitted helminths. Completely novel mechanism of action: activates latrophilin-like G-protein-coupled receptors (LAT-1 and LAT-2) and opens calcium-activated SLO-1 potassium channels, causing flaccid paralysis in nematodes that are resistant to all benzimidazoles and ivermectin!",
            indications = "Under Phase II/III investigation for Onchocerca volvulus (macrofilaricidal cure for river blindness), Trichuris trichiura (whipworm), and hookworm infections.",
            doses = "Phase II/III Clinical Trial Regimen: Single oral doses of 5 mg, 10 mg, or 15 mg administered with or without fatty meals.",
            adultDose = "Investigational: 5 mg - 15 mg PO single dose (DNDi Phase II/III Trials)",
            childDose = "Under clinical evaluation.",
            administration = "Take orally as directed in clinical trial protocols.",
            timing = "Single oral administration.",
            specialInstructions = "Phase II trial in Ghana demonstrated potent macrofilaricidal activity against adult Onchocerca volvulus worms, potentially enabling eradication of river blindness.",
            pkPd = "Binds presynaptic latrophilin-like G-protein coupled receptors, stimulating phospholipase C and DAG, releasing acetylcholine and activating SLO-1 potassium channels in nematode pharyngeal and somatic musculature, producing paralysis and death.",
            renalAdj = "Under evaluation.",
            hepaticAdj = "Under evaluation.",
            pregnancy = "Contraindicated during clinical trials.",
            lactation = "Contraindicated.",
            sideEffects = "Transient Mazzotti-like inflammatory reactions in onchocerciasis (fever, pruritus, lymphadenopathy due to dying microfilariae), mild dizziness, nausea.",
            priceNpr = "Under Research / Phase II/III Trial",
            priceInr = "Under Research / Phase II/III Trial",
            brandsNepal = listOf(
                BrandInfo("Emodepside (Investigational)", "DNDi / Bayer Pipeline", "Oral Tablet", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("BAY 44-4400 (Trial)", "DNDi Clinical Studies", "Tablet", "5 mg / 10 mg")
            ),
            contraindications = "Hypersensitivity to cyclodepside peptides, pregnancy.",
            modeOfAction = "Selective activation of nematode latrophilin-like receptors (LAT-1) and BK channels (SLO-1), hyperpolarizing somatic muscle and inhibiting pharyngeal pumping.",
            interactions = "Under investigation.",
            packSize = "Investigational blister of 4 tablets",
            counselingNepali = "यो हात्तीपाइले र अन्धोपन गराउने जटिल जुकाहरूका लागि अनुसन्धान भइरहेको नयाँ वर्गको औषधि हो। यसले पुराना औषधिलाई टेर्न छाडेका जुकालाई पनि मार्छ।",
            counselingEnglish = "Phase II/III breakthrough cyclodepsipeptide anthelmintic with a novel receptor mechanism overcoming all traditional drug resistance."
        ),

        // ==========================================
        // 9. ANTI PARASITIC (ANTIPROTOZOAL & ANTIMALARIAL)
        // ==========================================

        // --- OLDER / CLASSICAL ANTIPARASITIC ---
        Drug(
            id = "d_par_chloroquine",
            genericName = "Chloroquine Phosphate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Classical 4-Aminoquinoline Antimalarial & Amoebicide",
            era = "Older / Classical",
            therapeuticClassTag = "Anti parasitic",
            researchNotes = "Classical antimalarial introduced in 1934. Widespread resistance in Plasmodium falciparum has eliminated its use for falciparum malaria; however, it remains first-line for sensitive Plasmodium vivax / ovale and amoebic liver abscess.",
            blackBoxWarning = "CARDIOTOXICITY & IRREVERSIBLE RETINOPATHY: Overdosage causes fatal cardiogenic shock, conduction block, and ventricular arrhythmias. Chronic therapy causes irreversible retinal pigmentary retinopathy ('bull's eye' maculopathy).",
            indications = "Treatment of sensitive Plasmodium vivax, P. malariae, and P. ovale malaria; extraintestinal amoebiasis (amoebic liver abscess); rheumatoid arthritis and lupus (historical).",
            doses = "Malaria Treatment (Adults): Initial 600 mg base (1000 mg salt) PO stat, then 300 mg base at 6h, 24h, and 48h (total 1500 mg base over 3 days). Amoebic liver abscess: 600 mg base/day for 2 days, then 300 mg base/day for 2-3 weeks.",
            adultDose = "600 mg base stat -> 300 mg at 6h, 24h, 48h (Total 1.5 g base)",
            childDose = "Initial 10 mg base/kg stat, then 5 mg base/kg at 6h, 24h, 48h.",
            administration = "Take orally with meals to reduce nausea, vomiting, and abdominal distress.",
            timing = "Strictly per multi-day schedule with food.",
            specialInstructions = "Always follow with Primaquine (0.25-0.5 mg/kg/day for 14 days) in P. vivax to eradicate dormant hypnozoites in liver and achieve radical cure (check G6PD first).",
            pkPd = "Concentrates in acidic food vacuoles of intraerythrocytic Plasmodium, capping hemozoin crystals and causing accumulation of toxic free heme, which lyses parasite membranes. Half-life: 20-60 days due to massive tissue binding.",
            renalAdj = "CrCl 10-50 mL/min: Administer 50% of dose. CrCl <10: Administer 25% of dose.",
            hepaticAdj = "Use with caution; heavily concentrated in hepatic parenchymal tissue.",
            pregnancy = "Category C (Safe and recommended for chloroquine-sensitive malaria in pregnancy).",
            lactation = "Compatible with breastfeeding.",
            sideEffects = "Severe pruritus (especially in dark-skinned individuals: 50%), nausea, headache, visual blurring, QT prolongation, hemolysis in G6PD deficiency (rare).",
            priceNpr = "NPR 4.00 - 8.00 per tab (250mg)",
            priceInr = "INR 2.50 - 5.50 per tab (250mg)",
            brandsNepal = listOf(
                BrandInfo("Lariago", "IPCA Nepal", "Tablet / Inj", "250 mg / 64.5 mg/mL"),
                BrandInfo("Resochin", "Bayer Nepal", "Tablet", "250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lariago", "IPCA Laboratories", "Tablet / DS / Inj", "250 mg / 500 mg / 64.5mg/mL"),
                BrandInfo("Resochin", "Bayer India", "Tablet", "250 mg"),
                BrandInfo("Nivaquine-P", "Sanofi India", "Tablet", "250 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg base/kg stat, then 5 mg base/kg at 6h, 24h, 48h",
            contraindications = "Retinopathy or visual field changes, known hypersensitivity, co-administration with amiodarone or halofantrine (fatal arrhythmias).",
            modeOfAction = "Prevents biocrystallization of toxic ferriprotoporphyrin IX (heme) into inert hemozoin inside parasite food vacuoles, causing oxidative membrane lysis.",
            interactions = "Amiodarone, Halofantrine, Moxifloxacin (severe QT prolongation), Antacids (decrease chloroquine absorption; separate by 4 hours).",
            packSize = "Strip of 5 or 10 tablets",
            counselingNepali = "यो मलेरिया (औलो) र कलेजोमा पिप जमेको (Amoebic Liver Abscess) को पुरानो औषधि हो। खाना खाएपछि खानुहोस्। शरीरमा अलि चिलाउने समस्या हुन सक्छ।",
            counselingEnglish = "Take with meals. Indicated for sensitive vivax malaria and amoebic liver abscess. May cause temporary skin itching."
        ),

        // --- NEWER / MODERN STANDARDS ANTIPARASITIC ---
        Drug(
            id = "d_par_artemether_lumefantrine",
            genericName = "Artemether + Lumefantrine (Coartem)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Artemisinin-Based Combination Therapy (ACT)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti parasitic",
            researchNotes = "WHO Gold Standard first-line Artemisinin Combination Therapy (ACT) for acute uncomplicated Plasmodium falciparum malaria. Artemether provides ultra-rapid biomass clearance within 24-48 hours, while lumefantrine provides sustained elimination of residual parasites, preventing recrudescence and resistance.",
            indications = "First-line treatment of acute uncomplicated malaria caused by Plasmodium falciparum or mixed infections including chloroquine-resistant strains.",
            doses = "Standard 6-dose regimen over 3 days (each tablet contains 20 mg Artemether + 120 mg Lumefantrine). Adult (≥35 kg): 4 tablets at 0h, 8h, 24h, 36h, 48h, and 60h (total 24 tablets).",
            adultDose = "4 tablets stat at 0h, 8h, 24h, 36h, 48h, 60h (Total 24 tablets over 3 days)",
            childDose = "Weight-tiered 6-dose regimen: 5-<15kg: 1 tab/dose; 15-<25kg: 2 tabs/dose; 25-<35kg: 3 tabs/dose.",
            administration = "TAKE WITH FAT-CONTAINING FOOD OR MILK: Lumefantrine absorption is highly fat-dependent (fatty food/milk increases bioavailability by 16-fold!). If vomited within 1 hour, repeat dose.",
            timing = "Strict 60-hour schedule at 0h, 8h, 24h, 36h, 48h, and 60h.",
            specialInstructions = "Always ensure completion of all 6 doses even after fever resolves. Single low-dose primaquine (0.25 mg/kg) added on day 1 to kill gametocytes and halt transmission.",
            pkPd = "Artemether endoperoxide bridge is cleaved by intraparasitic iron, generating toxic carbon-centered free radicals that damage parasite organelles. Lumefantrine inhibits hemozoin formation. Half-life: Artemether ~2h; Lumefantrine ~3-6 days.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "Caution in severe hepatic impairment; monitor ECG.",
            pregnancy = "Category C (WHO recommends ACT in 2nd and 3rd trimesters; in 1st trimester use ACT if no alternative).",
            lactation = "Compatible with breastfeeding; present in minimal amounts.",
            sideEffects = "Headache, dizziness, anorexia, palpitations, abdominal pain, nausea, transient prolongation of QTc interval (lumefantrine).",
            priceNpr = "NPR 180.00 - 320.00 per blister pack of 24 tablets / FREE at Gov. Health Posts",
            priceInr = "INR 110.00 - 210.00 per pack of 24 tablets",
            brandsNepal = listOf(
                BrandInfo("Coartem", "Novartis Nepal", "Tablet", "20 mg / 120 mg"),
                BrandInfo("Lumether", "Cipla Nepal", "Tablet", "20 mg / 120 mg"),
                BrandInfo("Falcirid", "IPCA Nepal", "Tablet", "20 mg / 120 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Coartem", "Novartis India", "Tablet", "20 mg / 120 mg"),
                BrandInfo("Lumerax", "IPCA Laboratories", "Tablet / DT", "20/120 mg / 40/240 mg / 80/480 mg"),
                BrandInfo("Falcomax", "Macleods Pharmaceuticals", "Tablet", "20 mg / 120 mg"),
                BrandInfo("Arte Plus", "Sun Pharma", "Tablet", "20 mg / 120 mg")
            ),
            contraindications = "First trimester of pregnancy (relative; benefit may outweigh risk), known QT prolongation, family history of sudden cardiac death.",
            modeOfAction = "Dual action: Artemether endoperoxide free radical release destroys parasite protein machinery rapidly, while lumefantrine blocks beta-hematin crystallization.",
            interactions = "Strong CYP3A4 inducers (Rifampin, Carbamazepine - markedly reduce artemether and lumefantrine levels), QT-prolonging antiarrhythmics.",
            packSize = "Blister pack of 24 tablets (complete adult 3-day course)",
            counselingNepali = "यो खतरनाक औलो (फाल्सिप्यारम मलेरिया) निको पार्ने विश्व स्वास्थ्य संगठन (WHO) को मुख्य औषधि हो। चिल्लो खाना वा दूधसँग खानुपर्छ। ज्वरो घटे पनि ३ दिनको पूरै २४ चक्की पूरा खानुपर्छ।",
            counselingEnglish = "WHO gold standard ACT for malaria. Must take with milk or fatty meal to absorb. Complete all 6 doses over 3 days without stopping."
        ),

        // --- UNDER RESEARCH / PIPELINE ANTIPARASITIC ---
        Drug(
            id = "d_par_ganaplacide",
            genericName = "Ganaplacide (KAF156)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Investigational Imidazolopiperazine Antimalarial",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti parasitic",
            researchNotes = "NEXT-GENERATION PIPELINE ANTIMALARIAL: First-in-class imidazolopiperazine antimalarial being developed by Novartis and Medicines for Malaria Venture (MMV). Phase III trials in fixed-dose combination with Lumefantrine (SDA formulation). Active against blood-stage, liver-stage (sporozoites), and sexual gametocyte stages of Plasmodium falciparum and vivax, including multidrug-resistant strains with artemisinin K13 mutations!",
            indications = "Under Phase III investigation for acute uncomplicated Plasmodium falciparum and P. vivax malaria, including artemisinin-resistant strains.",
            doses = "Phase III Clinical Trial Regimen: Once-daily oral fixed-dose combination with lumefantrine for 1 to 3 days.",
            adultDose = "Investigational: Once-daily oral combination regimen (Phase III Studies)",
            childDose = "Under pediatric formulation development.",
            administration = "Take orally once daily with food or milk.",
            timing = "Once daily for 1 to 3 days.",
            specialInstructions = "Phase IIb trial published in NEJM demonstrated cure rates >96% in African and Asian adults and children, completely clearing artemisinin-resistant parasites.",
            pkPd = "Novel target: interacts with the endoplasmic reticulum and cyclic amine resistance locus (CARL) and acetyl-CoA transporter of Plasmodium, disrupting protein folding and secretory pathways. Half-life ~40-60 hours.",
            renalAdj = "Under evaluation in Phase III trials.",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated during trials.",
            lactation = "Contraindicated.",
            sideEffects = "Mild nausea, transient sinus bradycardia (asymptomatic), mild vomiting, transient transaminase elevation.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Ganaplacide (Investigational)", "Novartis / MMV Pipeline", "Tablet", "Clinical Trial Regimen")
            ),
            brandsIndia = listOf(
                BrandInfo("KAF156 (Trial)", "Novartis Clinical Studies", "Tablet", "Phase III")
            ),
            contraindications = "Hypersensitivity to imidazolopiperazines.",
            modeOfAction = "Targets Plasmodium endoplasmic reticulum protein machinery and cyclic amine resistance locus, triggering parasite stress and apoptosis across all developmental stages.",
            interactions = "Under study.",
            packSize = "Investigational blister of tablets",
            counselingNepali = "यो कुनै पनि औषधिले नछोएको कडा मलेरियाका लागि अनुसन्धानमा रहेको विश्वकै सबैभन्दा नयाँ औषधि हो। यसले औलोका कीटाणुलाई सबै अवस्थामा मार्न सक्छ।",
            counselingEnglish = "Phase III breakthrough antimalarial active against artemisinin-resistant strains with broad multi-stage parasite clearance."
        ),

        // ==========================================
        // 10. ANTI CANCER (ONCOLOGY & TARGETED THERAPY)
        // ==========================================

        // --- OLDER / CLASSICAL CYTOTOXIC CHEMOTHERAPY ---
        Drug(
            id = "d_onco_cisplatin",
            genericName = "Cisplatin",
            system = "Cardiovascular System (CVS)", // Classified under Antineoplastic
            drugClass = "Classical Platinum-Based Alkylating Antineoplastic Agent",
            era = "Older / Classical",
            therapeuticClassTag = "Anti cancer",
            researchNotes = "Classical heavy-metal platinum coordination complex discovered in 1965. Landmark curative treatment for testicular cancer (Einstein-Einhorn regimen >90% cure) and backbone of concurrent chemoradiation in head & neck, lung, bladder, cervical, and ovarian carcinomas.",
            blackBoxWarning = "SEVERE NEPHROTOXICITY, OTOTOXICITY & BONE MARROW SUPPRESSION: Highly emetogenic (near 100% without modern antiemetics). Dose-limiting cumulative renal tubular damage (pre- and post-hydration mandatory) and irreversible high-frequency bilateral sensorineural hearing loss.",
            indications = "Testicular cancer (curative), ovarian cancer, advanced bladder carcinoma, non-small cell lung cancer, squamous cell carcinoma of the head and neck, cervical cancer (chemoradiation).",
            doses = "IV Infusion: 50 mg/m² to 100 mg/m² IV every 3 to 4 weeks, or 20 mg/m² IV daily for 5 consecutive days every 3 weeks. Mandatory pre-hydration with 1-2 L NS + mannitol.",
            adultDose = "50 - 100 mg/m² IV every 3-4 weeks (with vigorous IV hydration)",
            childDose = "Pediatric solid tumors: 60-100 mg/m² IV every 3-4 weeks under oncology specialist protocol.",
            administration = "Intravenous infusion over 1-2 hours preceded and followed by vigorous hydration (1 to 2 liters of normal saline with potassium chloride and mannitol). Never use aluminum-containing needles/sets.",
            timing = "Cycle repeated every 3-4 weeks.",
            specialInstructions = "MANDATORY HIGH-RISK ANTIEMETIC PROTOCOL: 4-drug prophylactic antiemetic regimen (NK-1 antagonist: Aprepitant + 5-HT3 antagonist: Ondansetron + Dexamethasone + Olanzapine). Perform baseline audiogram.",
            pkPd = "Enters cells where low chloride concentration causes aquation, generating reactive platinum species that cross-link DNA (intrastrand guanine-guanine adducts), halting DNA replication and triggering p53-mediated apoptosis. Renal excretion ~90%. Half-life: 24-72h.",
            renalAdj = "CrCl 10-50 mL/min: Administer 50% of dose. CrCl <10 mL/min: CONTRAINDICATED.",
            hepaticAdj = "No dose adjustment required.",
            pregnancy = "Category D / Contraindicated in pregnancy (severe teratogenicity and embryolethality).",
            lactation = "Contraindicated; excreted in breast milk.",
            sideEffects = "Severe acute and delayed nausea/vomiting (near 100%), acute tubular necrosis / renal failure, bilateral sensorineural ototoxicity / tinnitus (30%), peripheral sensory neuropathy ('glove and stocking'), myelosuppression.",
            priceNpr = "NPR 1,200.00 - 2,500.00 per vial (50mg/50mL)",
            priceInr = "INR 650.00 - 1,450.00 per vial (50mg/50mL)",
            brandsNepal = listOf(
                BrandInfo("Cisplatin-Fresenius", "Fresenius Kabi Nepal", "IV Infusion", "50 mg / 50 mL"),
                BrandInfo("Cisplat", "Cipla Nepal", "IV Vial", "10 mg / 50 mg"),
                BrandInfo("Kemoplat", "Fresenius Kabi", "IV Vial", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Kemoplat", "Fresenius Kabi India", "IV Infusion", "10 mg / 50 mg"),
                BrandInfo("Cisplat", "Cipla Ltd.", "IV Infusion", "10 mg / 50 mg"),
                BrandInfo("Platin", "Cadila Pharmaceuticals", "IV Vial", "50 mg"),
                BrandInfo("Cisgen", "Alkem Laboratories", "IV Vial", "50 mg")
            ),
            pediatricDosePerKg = 2.0,
            pediatricInterval = "mg/kg IV (specialist oncology dosing)",
            contraindications = "Pre-existing severe renal impairment (CrCl <50), pre-existing hearing impairment, severe bone marrow depression.",
            modeOfAction = "Forms intrastrand and interstrand DNA cross-links at 1,2-intrastrand d(GpG) sites, inducing DNA bending, blocking transcription and replication, and triggering apoptosis.",
            interactions = "Aminoglycosides, Vancomycin, Amphotericin B (synergistic nephrotoxicity and ototoxicity; avoid combination), Loop diuretics (potentiates ototoxicity).",
            packSize = "Glass vial of 50 mg / 50 mL solution for infusion",
            counselingNepali = "यो क्यान्सरको मुख्य र शक्तिशाली केमोथेरापी औषधि हो। यसले बान्ता गराउन र मृगौलालाई असर गर्न सक्ने भएकाले औषधि दिनुअघि र पछि धेरै स्लाइन पानी दिइन्छ। कान बज्ने वा कम सुनेमा तुरुन्त खबर गर्नुहोस्।",
            counselingEnglish = "Classical platinum chemotherapy. Aggressive IV saline hydration mandatory before and after. Report ringing in the ears or decreased urination."
        ),

        // --- NEWER / MODERN TARGETED ONCOLOGY & CHECKPOINT INHIBITORS ---
        Drug(
            id = "d_onco_pembrolizumab",
            genericName = "Pembrolizumab",
            system = "Central Nervous System (CNS)", // Classified under Antineoplastic / Oncology
            drugClass = "Immune Checkpoint Inhibitor (Humanized Monoclonal Antibody Against PD-1)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti cancer",
            researchNotes = "NOBEL PRIZE-WINNING IMMUNOTHERAPY (Keytruda): Humanized IgG4 kappa monoclonal antibody blocking Programmed Death-1 (PD-1). Revolutionized oncology across melanoma, non-small cell lung cancer (KEYNOTE-024/042), MSI-H pan-cancer, head & neck, and renal carcinomas by unleashing the host's own cytotoxic T-cells against malignant tumors.",
            blackBoxWarning = "SEVERE IMMUNE-RELATED ADVERSE EVENTS (irAEs): Can trigger autoimmune destruction of ANY organ system: pneumonitis, colitis, hepatitis, endocrinopathies (hypophysitis, thyroiditis, adrenal crisis), nephritis, myocarditis. Requires prompt high-dose systemic corticosteroids (prednisone 1-2 mg/kg/day).",
            indications = "Non-small cell lung cancer (NSCLC with PD-L1 expression ≥1%), malignant melanoma, microsatellite instability-high (MSI-H) solid tumors, renal cell carcinoma, triple-negative breast cancer, classical Hodgkin lymphoma, urothelial carcinoma.",
            doses = "200 mg IV infusion over 30 minutes every 3 weeks, OR 400 mg IV infusion over 30 minutes every 6 weeks until disease progression or unacceptable toxicity (up to 24 months).",
            adultDose = "200 mg IV every 3 weeks (or 400 mg IV every 6 weeks)",
            childDose = "Pediatric MSI-H or cHL: 2 mg/kg IV (max 200 mg) every 3 weeks.",
            administration = "Intravenous infusion administered over 30 minutes through an intravenous line containing a sterile, non-pyrogenic, low-protein-binding 0.2-to-5 micron in-line filter.",
            timing = "Every 3 weeks (200 mg) or every 6 weeks (400 mg).",
            specialInstructions = "MONITOR FOR IMMUNE REACTIONS: Check baseline and routine thyroid panel (TSH, free T4), liver enzymes, creatinine, and screen for new dry cough/dyspnea (pneumonitis). Treat Grade ≥2 irAEs with high-dose steroids immediately.",
            pkPd = "High-affinity humanized IgG4 antibody that binds the PD-1 receptor on T-cells, blocking interaction with its ligands PD-L1 and PD-L2, releasing PD-1 pathway-mediated immune tolerance and allowing T-cells to attack tumor cells. Half-life: 22 days.",
            renalAdj = "No dose adjustment required across mild, moderate, or severe renal impairment.",
            hepaticAdj = "Mild to moderate: No adjustment. Severe (total bilirubin >3x ULN): Not studied.",
            pregnancy = "Contraindicated; causes immune-mediated fetal demise and spontaneous abortion.",
            lactation = "Discontinue nursing during treatment and for at least 4 months after final dose.",
            sideEffects = "Fatigue (20%), immune-mediated pneumonitis (3-5%), immune colitis/diarrhea (10%), thyroiditis / hypothyroidism (10%), autoimmune hepatitis, rash/pruritus, arthralgias.",
            priceNpr = "NPR 380,000.00 - 450,000.00 per vial (100mg/4mL)",
            priceInr = "INR 220,000.00 - 280,000.00 per vial (100mg/4mL)",
            brandsNepal = listOf(
                BrandInfo("Keytruda", "MSD Nepal", "IV Injection", "100 mg / 4 mL vial")
            ),
            brandsIndia = listOf(
                BrandInfo("Keytruda", "MSD India", "IV Injection", "100 mg / 4 mL vial"),
                BrandInfo("Pembrolizumab-Import", "Named Patient Oncology Access", "Vial", "100 mg")
            ),
            contraindications = "Hypersensitivity to pembrolizumab, severe active autoimmune disease requiring systemic immunosuppression.",
            modeOfAction = "Selectively blocks PD-1 receptor on cytotoxic T-lymphocytes, preventing PD-L1/PD-L2 mediated T-cell inactivation and revitalizing the antitumor immune response.",
            interactions = "Systemic corticosteroids or immunosuppressants prior to initiation may diminish efficacy (avoid except for treating life-threatening irAEs).",
            packSize = "Single-dose vial of 100 mg / 4 mL sterile liquid solution",
            counselingNepali = "यो बिरामीको आफ्नै रोग प्रतिरोधात्मक क्षमता (T-cells) लाई सक्रिय बनाएर क्यान्सरका कोष मार्ने नोबेल पुरस्कार प्राप्त आधुनिक इम्युनोथेरापी (Immunotherapy) हो। सास फेर्न गाह्रो भएमा वा धेरै पखाला लागेमा तुरुन्त डाक्टरलाई खबर गर्नुहोस्।",
            counselingEnglish = "Nobel Prize-winning checkpoint inhibitor immunotherapy. Administered IV every 3 or 6 weeks. Promptly report persistent cough, diarrhea, or unusual fatigue."
        ),

        // --- UNDER RESEARCH / PIPELINE ONCOLOGY ---
        Drug(
            id = "d_onco_mrtx1133",
            genericName = "MRTX1133",
            system = "Central Nervous System (CNS)", // Classified under Antineoplastic
            drugClass = "Investigational Selective Non-Covalent KRAS G12D Inhibitor",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti cancer",
            researchNotes = "THE UNDRUGGABLE TARGET CRACKED: KRAS G12D is the single most prevalent oncogenic driver mutation in pancreatic ductal adenocarcinoma (PDAC: ~36-45%) and colorectal cancer (~12-15%), historically deemed 'undruggable' because the aspartate mutation lacks the reactive cysteine used by sotorasib/adagrasib. MRTX1133 (Mirati/BMS) is the first potent, selective, non-covalent small-molecule inhibitor of both the active (GTP-bound) and inactive (GDP-bound) states of KRAS G12D! Phase I/II clinical trials demonstrated remarkable tumor regressions in refractory pancreatic and colon cancers.",
            indications = "Under Phase I/II clinical investigation for advanced solid tumors harboring the KRAS G12D mutation, particularly pancreatic ductal adenocarcinoma, colorectal cancer, and non-small cell lung cancer.",
            doses = "Phase I/II Clinical Trial Protocol: Oral dosing cohorts evaluating 150 mg, 200 mg, and 300 mg orally twice daily.",
            adultDose = "Investigational: 150 mg - 300 mg PO BID (Phase I/II Clinical Trials)",
            childDose = "Not studied in children.",
            administration = "Take orally twice daily with or without food at 12-hour intervals.",
            timing = "Twice daily, morning and evening.",
            specialInstructions = "Phase I/II trial (NCT05737706). Requires genetic next-generation sequencing (NGS) confirmation of KRAS G12D mutation in tumor tissue or circulating tumor DNA (ctDNA).",
            pkPd = "Binds with picomolar affinity to the switch II pocket of both GDP- and GTP-bound KRAS G12D mutant protein, locked via an engineered salt bridge with Asp12, shutting down RAF-MEK-ERK signaling. Half-life ~10-14 hours.",
            renalAdj = "Under evaluation in clinical trials.",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated; severe embryofetal toxicity.",
            lactation = "Contraindicated.",
            sideEffects = "Fatigue, diarrhea, nausea, vomiting, skin rash, mild transaminase elevation.",
            priceNpr = "Under Research / Phase I/II Clinical Trial",
            priceInr = "Under Research / Phase I/II Clinical Trial",
            brandsNepal = listOf(
                BrandInfo("MRTX1133 (Investigational)", "Mirati / BMS Pipeline", "Oral Tablet", "150 mg / 200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("MRTX1133 (Trial)", "Bristol Myers Squibb Studies", "Tablet", "150 mg")
            ),
            contraindications = "Known hypersensitivity, absence of KRAS G12D mutation.",
            modeOfAction = "Selectively and non-covalently binds both active GTP-bound and inactive GDP-bound conformations of KRAS G12D, inhibiting downstream MAPK/ERK kinase pathway signaling.",
            interactions = "Under investigation.",
            packSize = "Investigational blister of 30 tablets",
            counselingNepali = "यो क्यान्सरको इतिहासमै सबैभन्दा जटिल मानिएको 'KRAS G12D' म्युटेसन भएको आन्द्रा र प्याङ्क्रियाजको क्यान्सर मार्न बनेको विश्वकै पहिलो विशेष औषधि हो। यसको अनुसन्धान तीव्र गतिमा चलिरहेको छ।",
            counselingEnglish = "First-in-class targeted KRAS G12D inhibitor in Phase I/II trials, overcoming the historically 'undruggable' mutation in pancreatic and colon cancers."
        ),

        // ==========================================
        // 11. IMMUNO SUPRESSOR (IMMUNOSUPPRESSIVE AGENTS)
        // ==========================================

        // --- OLDER / CLASSICAL IMMUNOSUPPRESSIVE AGENTS ---
        Drug(
            id = "d_imm_azathioprine",
            genericName = "Azathioprine",
            system = "Musculoskeletal & Analgesics", // Classified under Immunomodulators
            drugClass = "Classical Purine Antimetabolite Immunosuppressant (6-Mercaptopurine Prodrug)",
            era = "Older / Classical",
            therapeuticClassTag = "Immuno supressor",
            researchNotes = "Classical purine antimetabolite introduced in 1961 (Nobel Prize to Elion & Hitchings). Prodrug converted to 6-mercaptopurine; foundational immunosuppressant in kidney transplantation and autoimmune diseases. MANDATORY TPMT and NUDT15 pharmacogenetic testing to avoid fatal myelosuppression.",
            blackBoxWarning = "MALIGNANCY & SEVERE MYELOSUPPRESSION: Chronic immunosuppression increases risk of lymphoma, skin cancers, and severe life-threatening bone marrow suppression. Extreme toxicity in patients with TPMT or NUDT15 deficiency.",
            indications = "Renal allograft rejection prophylaxis; severe active Rheumatoid Arthritis; systemic lupus erythematosus (SLE); Inflammatory Bowel Disease (Crohn's disease, Ulcerative Colitis); autoimmune hepatitis.",
            doses = "Transplantation: Initial 3-5 mg/kg/day PO/IV on day of transplant; maintenance 1-3 mg/kg/day. Autoimmune / RA / IBD: Initial 1 mg/kg/day PO; titrate after 6-8 weeks by 0.5 mg/kg/day to target 2-2.5 mg/kg/day.",
            adultDose = "1.5 - 2.5 mg/kg/day PO once daily or divided BID",
            childDose = "1-2.5 mg/kg/day PO for pediatric IBD and autoimmune conditions.",
            administration = "Take orally with or after meals to minimize nausea and gastric irritation.",
            timing = "Once daily or divided BID with food.",
            specialInstructions = "GENETIC TESTING MANDATORY: Test for Thiopurine S-methyltransferase (TPMT) and NUDT15 (especially in Asian populations) before initiation. IF ON ALLOPURINOL: REDUCE AZATHIOPRINE DOSE BY 75% (allopurinol blocks xanthine oxidase, leading to fatal azathioprine toxicity).",
            pkPd = "Prodrug converted non-enzymatically to 6-mercaptopurine (6-MP), which is metabolized into 6-thioguanine nucleotides (6-TGN). 6-TGN incorporates into cellular DNA and RNA, blocking de novo purine synthesis and arresting lymphocyte clonal expansion. Half-life: 3-5 hours.",
            renalAdj = "CrCl 10-50 mL/min: Administer 75% of normal dose. CrCl <10 mL/min: Administer 50% of normal dose.",
            hepaticAdj = "Reduce dose; monitor LFTs closely (risk of veno-occlusive disease / nodular regenerative hyperplasia).",
            pregnancy = "Category D (Extensively used in pregnancy for kidney transplant, SLE, and IBD when benefits outweigh risks; does not cross into fetal circulation in active form).",
            lactation = "Compatible with breastfeeding; tiny amounts of 6-MP excreted in milk (AAP approved).",
            sideEffects = "Bone marrow suppression (leukopenia, thrombocytopenia, anemia), acute pancreatitis (3-5%), cholestatic jaundice / hepatotoxicity, severe nausea/vomiting, opportunistic infections.",
            priceNpr = "NPR 12.00 - 24.00 per tab (50mg)",
            priceInr = "INR 8.00 - 16.00 per tab (50mg)",
            brandsNepal = listOf(
                BrandInfo("Imuran", "GSK Nepal", "Tablet", "50 mg"),
                BrandInfo("Azapure", "Sun Pharma Nepal", "Tablet", "50 mg"),
                BrandInfo("Azoran", "RPG Life Sciences Nepal", "Tablet", "25 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Imuran", "GlaxoSmithKline India", "Tablet", "50 mg"),
                BrandInfo("Azoran", "RPG Life Sciences", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Azapure", "Sun Pharma", "Tablet", "50 mg"),
                BrandInfo("Transimune", "Alkem Laboratories", "Tablet", "50 mg")
            ),
            pediatricDosePerKg = 1.5,
            pediatricInterval = "mg/kg daily with meals",
            contraindications = "Hypersensitivity to azathioprine or 6-mercaptopurine, severe untreated bone marrow suppression, complete TPMT or NUDT15 deficiency.",
            modeOfAction = "Generates 6-thioguanine nucleotides that incorporate into cellular DNA and RNA, arresting the S-phase of the cell cycle and preventing lymphocyte proliferation.",
            interactions = "Allopurinol / Febuxostat (MASSIVE FATAL TOXICITY RISK: reduce azathioprine dose to 25% of standard dose), Warfarin (inhibits anticoagulant effect), ACE inhibitors (severe leukopenia).",
            packSize = "Strip of 10 or 30 tablets",
            counselingNepali = "यो रोग प्रतिरोधात्मक शक्तिलाई सन्तुलनमा राख्ने (Immunosuppressant) पुरानो भरपर्दो औषधि हो। खानासँग खानुहोस्। युरिक एसिडको औषधि (Allopurinol) सँग यो औषधि कदापि मिसाएर खानुहुँदैन, नत्र रगतका कोष पूरै सुकेर खतरा हुन सक्छ।",
            counselingEnglish = "Take with food. Never take with allopurinol gout pills without severe dose reduction. Regular complete blood counts (CBC) mandatory."
        ),

        // --- NEWER / MODERN STANDARD IMMUNOSUPPRESSIVE AGENTS ---
        Drug(
            id = "d_imm_tacrolimus",
            genericName = "Tacrolimus (FK506)",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Calcineurin Inhibitor (Macrolide Immunosuppressant)",
            era = "Newer / Modern",
            therapeuticClassTag = "Immuno supressor",
            researchNotes = "Modern cornerstone of solid organ transplantation (100 times more potent than cyclosporine). Binds to intracellular immunophilin FKBP-12, blocking calcineurin-dependent IL-2 transcription. Standard maintenance therapy for kidney, liver, heart, and lung transplants.",
            blackBoxWarning = "MALIGNANCIES, SERIOUS INFECTIONS & MORTALITY: Immunosuppression increases susceptibility to opportunistic infections and lymphoma. Dose-dependent nephrotoxicity and neurotoxicity. Therapeutic drug monitoring mandatory.",
            indications = "Prophylaxis of organ rejection in kidney, liver, heart, and lung allograft recipients; treatment of refractory allograft rejection; steroid-resistant nephrotic syndrome; atopic dermatitis (topical).",
            doses = "Oral: Initial 0.10 to 0.20 mg/kg/day PO divided q12h (capsules). Target 12-hour trough blood levels: 8-12 ng/mL in months 1-3 post-transplant, then 5-8 ng/mL maintenance. Available also as once-daily extended-release.",
            adultDose = "0.10 - 0.20 mg/kg/day PO divided q12h (Titrated to target trough blood level 5-10 ng/mL)",
            childDose = "Pediatric transplant: 0.15-0.30 mg/kg/day divided q12h (children require higher doses per kg).",
            administration = "Take on an empty stomach at least 1 hour before or 2 hours after meals (food, especially fatty meals, reduces absorption by 30-40%). Swallow capsules whole.",
            timing = "Strictly every 12 hours on an empty stomach (or once daily morning for extended-release).",
            specialInstructions = "THERAPEUTIC DRUG MONITORING (TDM) MANDATORY: Draw whole-blood trough levels 12 hours after previous dose immediately before morning dose. Avoid grapefruit and Seville oranges.",
            pkPd = "Binds intracellular immunophilin FKBP-12; the complex inhibits calcineurin phosphatase, preventing dephosphorylation and nuclear translocation of NF-AT, shutting down Interleukin-2 (IL-2) gene transcription. Half-life ~12h (wide variability).",
            renalAdj = "Causes afferent arteriolar vasoconstriction; dose-dependent nephrotoxicity. Use lower doses; closely monitor creatinine and trough levels.",
            hepaticAdj = "Severe hepatic impairment: Reduce starting dose by 50% and titrate based on trough levels.",
            pregnancy = "Category C (Crosses placenta; causes prematurity and low birth weight; preferred over MMF for transplant recipients wanting pregnancy).",
            lactation = "Contraindicated; excreted in breast milk.",
            sideEffects = "Nephrotoxicity, tremors, headache, post-transplant diabetes mellitus (PTDM: 20-30%), hypertension, hyperkalemia, hypomagnesemia, alopecia.",
            priceNpr = "NPR 35.00 - 75.00 per cap (1mg)",
            priceInr = "INR 22.00 - 48.00 per cap (1mg)",
            brandsNepal = listOf(
                BrandInfo("Prograf", "Astellas Nepal", "Capsule", "0.5 mg / 1 mg / 5 mg"),
                BrandInfo("Tacrolin", "Cipla Nepal", "Capsule", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Pangraf", "Panacea / Nepal", "Capsule", "0.5 mg / 1 mg / 2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Prograf", "Astellas India", "Capsule", "0.5 mg / 1 mg / 5 mg"),
                BrandInfo("Pangraf", "Panacea Biotec", "Capsule", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Tacrograf", "Biocon", "Capsule", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Tacrolin", "Cipla Ltd.", "Capsule", "0.5 mg / 1 mg / 2 mg")
            ),
            pediatricDosePerKg = 0.15,
            pediatricInterval = "mg/kg/day divided q12h",
            contraindications = "Known hypersensitivity to tacrolimus or polyoxyl 60 hydrogenated castor oil (in IV formulation).",
            modeOfAction = "Complexes with FKBP-12 to inhibit calcineurin, preventing NF-AT nuclear translocation and blocking transcription of IL-2 and other T-cell activation cytokines.",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole, Voriconazole, Diltiazem - drastically spike tacrolimus levels causing acute renal failure); Strong inducers (Rifampin - plunges levels causing acute rejection).",
            packSize = "Strip of 10 or 30 capsules in protective foil",
            counselingNepali = "यो मृगौला, कलेजो वा मुटु प्रत्यारोपण (Transplant) गरेका बिरामीहरूले नयाँ अंग जोगाउन जीवनभर खाने मुख्य औषधि हो। खाली पेटमा ठिक १२/१२ घण्टाको फरकमा खानुहोस्। रगतमा औषधिको मात्रा (Trough Level) नियमित जचाउनुहोस्।",
            counselingEnglish = "Primary transplant anti-rejection drug. Take exactly 12 hours apart on an empty stomach. Routine whole-blood trough levels required."
        ),

        // --- UNDER RESEARCH / PIPELINE IMMUNOSUPPRESSION ---
        Drug(
            id = "d_imm_voclosporin",
            genericName = "Voclosporin (Lupkynis)",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Next-Generation Semi-Synthetic Calcineurin Inhibitor",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Immuno supressor",
            researchNotes = "NOVEL CALCINEURIN INHIBITOR INNOVATION: First FDA-approved oral calcineurin inhibitor specifically for active lupus nephritis (AURORA Phase III trial published in The Lancet). Possesses a single carbon extension on the functional group that locks the molecule in its active conformation, increasing calcineurin-binding potency by 4-fold with predictable pharmacokinetics that ELIMINATES THE NEED FOR ROUTINE THERAPEUTIC DRUG MONITORING (TDM)!",
            blackBoxWarning = "SERIOUS INFECTIONS & MALIGNANCIES: Increased risk of fatal bacterial, viral, and fungal infections, and lymphomas. Do not administer with cyclophosphamide.",
            indications = "Active Lupus Nephritis (Class III, IV, or V) in adult patients in combination with background immunosuppressive therapy (Mycophenolate Mofetil and systemic corticosteroids).",
            doses = "23.7 mg (three 7.9 mg capsules) orally twice daily with a consistent meal schedule. Swallow capsules whole.",
            adultDose = "23.7 mg PO twice daily (in combination with MMF and steroids)",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Take orally twice daily on an empty stomach consistently or with food consistently. Swallow capsules whole; do not open, crush, or dissolve.",
            timing = "Twice daily, morning and evening, exactly 12 hours apart.",
            specialInstructions = "Check baseline eGFR. Do not initiate if baseline eGFR ≤45 mL/min/1.73m² unless benefit outweighs risk. Recheck eGFR at 2 and 4 weeks; if eGFR drops >20-30%, reduce dose.",
            pkPd = "Semi-synthetic analogue of cyclosporine A with a modification of the amino acid-1 residue, enhancing calcineurin inhibition and stabilizing podocyte actin cytoskeleton. Highly bound to erythrocytes and plasma proteins. Half-life ~30 hours.",
            renalAdj = "Baseline eGFR ≤45 mL/min: Not recommended unless benefits outweigh risks. During therapy, modify dose based on eGFR decrements.",
            hepaticAdj = "Mild to moderate (Child-Pugh A or B): Reduce dose to 15.8 mg BID. Severe (Child-Pugh C): Contraindicated.",
            pregnancy = "Avoid; use only if potential benefit justifies potential fetal risk.",
            lactation = "Breastfeeding not recommended during treatment and for 7 days after final dose.",
            sideEffects = "Decreased glomerular filtration rate (26%), hypertension (19%), diarrhea, headache, anemia, cough, urinary tract infection, alopecia.",
            priceNpr = "Under Global Specialty Access (~$7,500/month)",
            priceInr = "Under Global Specialty Access (Specialty Import)",
            brandsNepal = listOf(
                BrandInfo("Lupkynis (Voclosporin)", "Aurinia / Otsuka Pipeline", "Capsule", "7.9 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lupkynis", "Aurinia Pharmaceuticals", "Capsule", "7.9 mg")
            ),
            contraindications = "Concomitant administration with strong CYP3A4 inhibitors (Ketoconazole, Itraconazole, Clarithromycin), hypersensitivity to voclosporin.",
            modeOfAction = "Inhibits calcineurin, blocking NF-AT nuclear translocation and IL-2 transcription in T-cells, and directly stabilizes synaptopodin phosphorylation in renal podocytes to stop proteinuria.",
            interactions = "Strong CYP3A4 inhibitors (contraindicated), Moderate CYP3A4 inhibitors (reduce dose to 15.8 mg AM and 7.9 mg PM), Strong inducers (avoid).",
            packSize = "Cold-formed blister packs containing 60 or 180 capsules (7.9 mg)",
            counselingNepali = "यो लुपस बाथ रोगले मृगौला बिगारेको (Lupus Nephritis) बिरामीहरूका लागि प्रमाणित भएको नयाँ पुस्ताको औषधि हो। यसलाई रगतमा मात्रा नापिरहनु पर्दैन। बिहान र बेलुका १२ घण्टाको फरकमा खानुहोस्।",
            counselingEnglish = "Approved 2021 next-generation calcineurin inhibitor for active lupus nephritis. Taken twice daily with MMF. Does not require routine drug level tests."
        ),

        // ==========================================
        // 12. RA (RHEUMATOID ARTHRITIS / DMARDs)
        // ==========================================

        // --- OLDER / CONVENTIONAL SYNTHETIC DMARDs (csDMARDs) ---
        Drug(
            id = "d_ra_hydroxychloroquine",
            genericName = "Hydroxychloroquine Sulfate",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Conventional Synthetic DMARD (Antimalarial Immunomodulator)",
            era = "Older / Classical",
            therapeuticClassTag = "RA",
            researchNotes = "Classical anchor csDMARD introduced in 1955. Preferred csDMARD for mild Rheumatoid Arthritis and systemic lupus erythematosus (SLE) due to excellent safety profile, preservation of bone density, antithrombotic benefits, and exceptional safety throughout pregnancy and lactation.",
            blackBoxWarning = "IRREVERSIBLE RETINOPATHY: Retinal toxicity and irreversible macular damage ('bull's eye' maculopathy) can develop with cumulative doses >1000g or daily doses >5.0 mg/kg actual body weight. Mandatory baseline and annual ophthalmological screening.",
            indications = "Rheumatoid Arthritis (monotherapy or combination therapy), Systemic Lupus Erythematosus (SLE - mandatory baseline therapy improving survival), Discoid Lupus, juvenile idiopathic arthritis.",
            doses = "Rheumatoid Arthritis: Initial 400 mg PO daily (single or divided BID) for 4-12 weeks; maintenance 200 mg to 400 mg PO daily (strict maximum: ≤5.0 mg/kg/day actual body weight).",
            adultDose = "200 - 400 mg PO once daily with food (Max ≤5.0 mg/kg/day)",
            childDose = "Pediatric SLE / JIA: 3-5 mg/kg/day PO (max 400 mg/day).",
            administration = "Take orally with food or milk to minimize gastrointestinal symptoms.",
            timing = "Once daily with meals.",
            specialInstructions = "DOSE MUST NOT EXCEED 5.0 mg/kg ACTUAL BODY WEIGHT: Prescribing based on actual weight prevents cumulative retinal maculopathy. Baseline dilated eye exam and optical coherence tomography (SD-OCT) within 1 year of starting, then annually after 5 years.",
            pkPd = "Concentrates in intracellular lysosomes, raising intralysosomal pH and interfering with antigen processing and presentation on MHC class II molecules; inhibits Toll-like receptor (TLR-7 and TLR-9) signaling. Half-life: 40-50 days.",
            renalAdj = "eGFR <30 mL/min: Reduce dose by 25-50% to prevent cumulative retinal toxicity.",
            hepaticAdj = "Use with caution in severe hepatic dysfunction.",
            pregnancy = "Category C (SAFE AND RECOMMENDED THROUGHOUT PREGNANCY in SLE and RA; prevents maternal lupus flares and congenital fetal heart block).",
            lactation = "Compatible with breastfeeding (AAP approved).",
            sideEffects = "Retinal maculopathy (long-term), nausea, abdominal cramps, diarrhea, skin hyperpigmentation (blue-gray pigmentation of shins/palate), QT prolongation (rare).",
            priceNpr = "NPR 12.00 - 24.00 per tab (200mg)",
            priceInr = "INR 8.00 - 16.00 per tab (200mg)",
            brandsNepal = listOf(
                BrandInfo("HCQS", "IPCA Nepal", "Tablet", "200 mg / 300 mg / 400 mg"),
                BrandInfo("Plaquenil", "Sanofi Nepal", "Tablet", "200 mg"),
                BrandInfo("Zy-Q", "Zydus Nepal", "Tablet", "200 mg / 300 mg / 400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("HCQS", "IPCA Laboratories", "Tablet", "200 mg / 300 mg / 400 mg"),
                BrandInfo("Plaquenil", "Sanofi India", "Tablet", "200 mg"),
                BrandInfo("Zy-Q", "Zydus Cadila", "Tablet", "200 mg / 300 mg / 400 mg"),
                BrandInfo("Rhq", "Cipla Ltd.", "Tablet", "200 mg / 400 mg")
            ),
            pediatricDosePerKg = 3.0,
            pediatricInterval = "mg/kg daily with food",
            contraindications = "Pre-existing retinopathy or maculopathy, known hypersensitivity to 4-aminoquinolines.",
            modeOfAction = "Raises endosomal and lysosomal pH in antigen-presenting cells, disrupting antigen processing, inhibiting toll-like receptors 7 and 9, and dampening interferon-alpha production.",
            interactions = "Digoxin (increases digoxin levels), QT-prolonging drugs, Antacids (decrease absorption; separate by 4 hours).",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो बाथ रोग (Rheumatoid Arthritis) र लुपसको धेरै सुरक्षित पुरानो औषधि हो। खानासँग खानुहोस्। गर्भावस्थामा पनि यो सुरक्षित मानिन्छ। वर्षको एक पटक आँखाको पर्दा (Retina) अनिवार्य जचाउनुहोस्।",
            counselingEnglish = "Take with meals. Safest DMARD in pregnancy. Mandatory annual eye examinations to monitor the retina."
        ),

        // --- NEWER / MODERN TARGETED tsDMARDs & BIOLOGICS ---
        Drug(
            id = "d_ra_upadacitinib",
            genericName = "Upadacitinib (Rinvoq)",
            system = "Musculoskeletal & Analgesics",
            drugClass = "2nd-Generation Selective Janus Kinase-1 (JAK1) Inhibitor",
            era = "Newer / Modern",
            therapeuticClassTag = "RA",
            researchNotes = "Modern 2nd-generation selective oral JAK1 inhibitor. Landmark SELECT-COMPARE trial published in Arthritis & Rheumatology demonstrated statistical superiority over adalimumab (Humira) in clinical remission (DAS28-CRP <2.6) and ACR50 response in methotrexate-refractory active rheumatoid arthritis.",
            blackBoxWarning = "SERIOUS INFECTIONS, MORTALITY, MALIGNANCY, MAJOR ADVERSE CARDIOVASCULAR EVENTS (MACE) & THROMBOSIS: High risk of TB, invasive fungal infections, and herpes zoster. Higher rates of all-cause mortality, MI, stroke, and pulmonary embolism in patients ≥50 years with cardiovascular risk factors.",
            indications = "Moderate to severely active Rheumatoid Arthritis with inadequate response or intolerance to methotrexate; Psoriatic Arthritis; Ankylosing Spondylitis; Atopic Dermatitis; Ulcerative Colitis; Crohn's disease.",
            doses = "15 mg orally once daily extended-release tablet with or without food. Can be used as monotherapy or in combination with methotrexate.",
            adultDose = "15 mg PO once daily extended-release tablet",
            childDose = "Pediatric JIA (≥2 years): Weight-based oral solution or 15 mg tablet for ≥30 kg.",
            administration = "Take orally once daily with or without food. Swallow extended-release tablet whole; do not split, crush, or chew.",
            timing = "Once daily, morning or evening.",
            specialInstructions = "MANDATORY PRE-SCREENING: Screen for latent tuberculosis (PPD/Quantiferon), Hepatitis B/C serology, and complete blood count. Avoid initiating if absolute neutrophil count <1000/mm³, lymphocyte count <500/mm³, or hemoglobin <8 g/dL. Administer recombinant shingles vaccine (Shingrix) prior to therapy.",
            pkPd = "Engineered for high selectivity toward JAK1 (approximately 50- to 70-fold more selective for JAK1 over JAK2, and >100-fold over JAK3 and TYK2), minimizing anemia (JAK2-mediated) while potently inhibiting pro-inflammatory cytokines. Half-life: 9-14 hours.",
            renalAdj = "Mild to moderate: 15 mg once daily. Severe (eGFR 15-29 mL/min): Reduce to 15 mg once daily for indications with higher doses. ESRD: Not recommended.",
            hepaticAdj = "Mild to moderate (Child-Pugh A or B): 15 mg once daily. Severe (Child-Pugh C): Contraindicated.",
            pregnancy = "Contraindicated; teratogenic in animal studies. Females must use effective contraception during treatment and for 4 weeks after stopping.",
            lactation = "Contraindicated during treatment and for 6 days after the last dose.",
            sideEffects = "Upper respiratory infections (13%), herpes zoster reactivation (shingles: 3-5%), elevated liver enzymes, elevated CPK, neutropenia, hypercholesterolemia (elevated LDL/HDL), deep vein thrombosis (DVT/PE).",
            priceNpr = "NPR 120.00 - 220.00 per tab (15mg)",
            priceInr = "INR 75.00 - 140.00 per tab (15mg)",
            brandsNepal = listOf(
                BrandInfo("Rinvoq", "AbbVie Nepal", "Extended-Release Tab", "15 mg / 30 mg"),
                BrandInfo("Upada", "Sun Pharma Nepal", "ER Tablet", "15 mg"),
                BrandInfo("U-Jak", "Cipla Nepal", "ER Tablet", "15 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Rinvoq", "AbbVie India", "Extended-Release Tab", "15 mg / 30 mg"),
                BrandInfo("Upada", "Sun Pharma", "ER Tablet", "15 mg"),
                BrandInfo("U-Jak", "Cipla Ltd.", "ER Tablet", "15 mg"),
                BrandInfo("Upacit", "Dr. Reddy's Laboratories", "ER Tablet", "15 mg")
            ),
            contraindications = "Active serious infection, active tuberculosis, severe hepatic impairment, pregnancy.",
            modeOfAction = "Selectively and reversibly inhibits Janus kinase-1 (JAK1), blocking phosphorylation of STAT transcription factors and inhibiting pro-inflammatory cytokine signaling (IL-6, IFN-gamma).",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole - increases upadacitinib exposure); Strong inducers (Rifampin - avoid; decreases efficacy).",
            packSize = "Bottle or blister of 30 extended-release tablets",
            counselingNepali = "यो मेथोट्रेक्सेटले काम नगरेको कडा बाथ रोग (Rheumatoid Arthritis) का लागि दिनको एक पटक खाने आधुनिक र निकै प्रभावकारी चक्की हो। चक्की नटुक्र्याई निल्नुहोस्। सुरु गर्नुअघि टीबी जचाउनुपर्छ। ज्वरो आएमा तुरुन्त डाक्टरलाई देखाउनुहोस्।",
            counselingEnglish = "Advanced selective oral JAK1 inhibitor taken once daily. Superior to injectables in trials. Must screen for TB and take shingles vaccine."
        ),

        // --- UNDER RESEARCH / PIPELINE RA ---
        Drug(
            id = "d_ra_remibrutinib",
            genericName = "Remibrutinib (LOU064)",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Investigational Highly Selective Oral Covalent Bruton's Tyrosine Kinase (BTK) Inhibitor",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "RA",
            researchNotes = "NOVEL AUTOIMMUNE MECHANISM: Highly selective, covalent, oral Bruton's Tyrosine Kinase (BTK) inhibitor being developed by Novartis. Phase IIb/III trials evaluate remibrutinib in autoimmune diseases (Rheumatoid Arthritis, Chronic Spontaneous Urticaria, and Multiple Sclerosis). Selectively shuts down autoantibody-driven B-cell receptor signaling and Fc-receptor activation in macrophages and mast cells without the off-target bleeding or cardiac toxicities seen with early oncology BTK inhibitors!",
            indications = "Under Phase II/III clinical investigation for moderate-to-severe active Rheumatoid Arthritis (inadequate response to methotrexate), Chronic Spontaneous Urticaria (CSU), and Sjogren's syndrome.",
            doses = "Phase IIb/III Clinical Trial Dosing: 25 mg or 100 mg orally twice daily.",
            adultDose = "Investigational: 25 mg - 100 mg PO twice daily (Phase III Clinical Trials)",
            childDose = "Not evaluated in pediatric patients.",
            administration = "Take orally twice daily with or without food.",
            timing = "Twice daily, morning and evening.",
            specialInstructions = "Phase II trial in RA demonstrated significant reduction in disease activity score (DAS28-CRP) within 4 weeks with negligible off-target kinase inhibition.",
            pkPd = "Forms a covalent bond with Cysteine 481 in the ATP-binding pocket of BTK. Rapidly cleared from systemic circulation (half-life ~1-2 hours) while maintaining near 100% target occupancy in target B-cells for >24 hours due to covalent binding.",
            renalAdj = "Under evaluation in Phase III trials.",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated.",
            lactation = "Contraindicated.",
            sideEffects = "Mild petechiae, headache, upper respiratory tract infections, mild transient transaminase elevation.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Remibrutinib (Investigational)", "Novartis Pipeline", "Oral Tablet", "25 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("LOU064 (Trial)", "Novartis Clinical Studies", "Tablet", "25 mg / 100 mg")
            ),
            contraindications = "Hypersensitivity to BTK inhibitors, active life-threatening infection.",
            modeOfAction = "Selectively and covalently inhibits Bruton's tyrosine kinase (BTK), silencing B-cell receptor-mediated autoantibody synthesis and Fc-gamma receptor activation in myeloid inflammatory cells.",
            interactions = "Under study.",
            packSize = "Investigational blister of 28 tablets",
            counselingNepali = "यो बाथ रोग (RA) को लागि अनुसन्धानमा रहेको नयाँ प्रविधिको (BTK inhibitor) चक्की हो। यसले शरीरका हानिकारक एन्टिबडी बनाउने कोषहरूलाई मात्र छानी-छानी रोक्छ।",
            counselingEnglish = "Phase II/III selective covalent BTK inhibitor targeting autoantibody-driven B-cell pathways in rheumatoid arthritis."
        )
    )
}
