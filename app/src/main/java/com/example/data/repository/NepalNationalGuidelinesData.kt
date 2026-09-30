package com.example.data.repository

import com.example.data.model.DiseaseProtocol

object NepalNationalGuidelinesData {

    val nationalProtocols: List<DiseaseProtocol> = listOf(
        // 1. Nepal Rabies PEP Protocol (EDCD / WHO)
        DiseaseProtocol(
            id = "proto_nepal_rabies",
            name = "Nepal Rabies Post-Exposure Prophylaxis (PEP) Protocol",
            category = "Infectious Diseases",
            icd10 = "A82.9",
            diagnosticCriteria = "History of animal bite, scratch, or saliva exposure to broken skin or mucous membranes (dogs, bats, monkeys, jackals, cats, mongoose). Classification per Nepal EDCD & WHO:\n• Category I: Touching or feeding animals, licks on intact skin (No risk; no PEP).\n• Category II: Nibbling of uncovered skin, minor scratches or abrasions without bleeding (Moderate risk; immediate vaccine PEP required).\n• Category III: Single or multiple transdermal bites or scratches, licks on broken skin, contamination of mucous membranes with saliva, or any bat exposure (High risk; immediate vaccine PEP PLUS Rabies Immunoglobulin [RIG] infiltration mandatory).",
            firstLine = "Nepal National Standard Intradermal (ID) Regimen (2-Site ID Schedule):\n• 0.1 mL of reconstituted cell-culture rabies vaccine (PVRV or PCECV) administered INTRADERMALLY at 2 SEPARATE ANATOMICAL SITES (both left and right deltoids) on Days 0, 3, and 7.\n• Highly cost-effective (uses only 0.6 mL total vaccine over 3 clinic visits vs 4-5 full vials in IM schedules).\n\nAlternative Intramuscular (IM) Essen Regimen (if ID trained staff unavailable):\n• 1 full vial (0.5 mL or 1.0 mL) IM into anterolateral thigh (infants) or deltoid (older children/adults) on Days 0, 3, 7, 14, and 28 (5 doses). (Never inject in gluteal region).",
            secondLine = "Rabies Immunoglobulin (RIG) Administration (MANDATORY FOR ALL CATEGORY III BITES):\n• Equine Rabies Immunoglobulin (eRIG): 40 IU/kg body weight OR\n• Human Rabies Immunoglobulin (hRIG): 20 IU/kg body weight.\n• Infiltration Technique: Infiltrate as much of the calculated dose as anatomically feasible DEEPLY INTO AND AROUND ALL WOUND EDGES. Any remaining volume should be injected IM at an anatomical site distant from the vaccine site (e.g. anterolateral thigh).\n• Timing: Administer on Day 0 together with the first vaccine dose. Can be given up to Day 7 after the first vaccine dose (not indicated beyond Day 7 as vaccine antibodies begin appearing).",
            inpatient = "Wound Management (IMMEDIATE Bedside Action):\n• Vigorously scrub and wash all bite wounds, scratches, and surrounding skin immediately with SOAP AND RUNNING WATER for at least 15 continuous minutes.\n• Follow with 70% alcohol or povidone-iodine solution.\n• STRICT SURGICAL RULE: DO NOT SUTURE bite wounds primarily. If suturing is unavoidable for hemostasis, infiltrate RIG locally first and place loose, interrupted sutures after 2-3 hours.",
            guidelines = "Epidemiology and Disease Control Division (EDCD) Ministry of Health and Population Nepal & WHO Rabies Vaccine Position Paper 2018.",
            keyDrugs = listOf("Rabies Vaccine (PVRV / PCECV)", "Equine Rabies Immunoglobulin (eRIG)", "Human Rabies Immunoglobulin (hRIG)", "Povidone Iodine", "Tetanus Toxoid"),
            supportiveCare = "Tetanus prophylaxis: Administer Tetanus Toxoid (TT 0.5 mL IM) or Td if not vaccinated within last 5-10 years. Empirical oral antibiotics for dog/cat bite wound infection prophylaxis: Amoxicillin-Clavulanate 625 mg PO TID for 3-5 days. Pain management: Paracetamol 500-1000 mg PO PRN.",
            redFlags = "Category III bites to highly innervated areas (face, head, neck, hands, fingers, genitalia); Deep puncture wounds; Bites by wild carnivores (jackals, wolves, bats); Immunocompromised patients (HIV, malnutrition) who require 1 full additional vaccine dose on Day 28.",
            references = listOf(
                "EDCD Nepal National Guideline for Rabies Post-Exposure Prophylaxis (2020)",
                "WHO Expert Consultation on Rabies (Third Report, WHO TRS 1012, 2018)",
                "CDC: Rabies Post-Exposure Prophylaxis Guidelines",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 203"
            )
        ),

        // 2. Nepal Snakebite Envenomation Management Protocol
        DiseaseProtocol(
            id = "proto_nepal_snakebite",
            name = "Nepal Snakebite Envenomation Management Protocol",
            category = "Emergency & Toxicology",
            icd10 = "T63.0",
            diagnosticCriteria = "History of snakebite (Terai and hill belts of Nepal). Rapid syndromic classification:\n• Neurotoxic Envenomation (Elapidae: Common Krait [Bungarus caeruleus], King Cobra, Monocled Cobra): Progressive descending symmetrical bilateral ptosis, external ophthalmoplegia, dysphagia, pooling of saliva, broken neck sign (neck muscle weakness), dyspnea, and respiratory muscle paralysis. (Note: Krait bites occur at night indoors and frequently lack local bite marks or local pain).\n• Hemotoxic Envenomation (Viperidae: Russell's Viper [Daboia russelii], Pit Vipers): Rapid severe local swelling, bruising, blistering, spontaneous systemic bleeding (gingival bleeding, epistaxis, hematuria, hemoptysis, bite site non-clotting oozing), and abnormal 20-minute Whole Blood Clotting Test (20WBCT).\n• 20-Minute Whole Blood Clotting Test (20WBCT): Place 2 mL of fresh un-anticoagulated venous blood in a clean dry glass tube; leave undisturbed at ambient temperature for 20 minutes; gently tilt tube. If blood remains liquid (unclotted), envenomation is confirmed.",
            firstLine = "Polyvalent Anti-Snake Venom Serum (ASVS) Infusion Protocol:\n• Initial Dose: 10 VIALS of Polyvalent Anti-Snake Venom (lyophilized equine globulins active against Russell's viper, Common krait, Saw-scaled viper, and Indian cobra).\n• Reconstitution: Dissolve each vial in 10 mL sterile water. Dilute all 10 vials in 200-250 mL of Normal Saline (or 5% Dextrose).\n• Infusion Rate: Start slowly at 1-2 mL/min for first 10-15 minutes while observing closely for early anaphylaxis; if no adverse reactions, infuse the remainder over 60 minutes.\n• Pediatric Dosing: EXACT SAME DOSE (10 Vials) is administered to children, as snakes inject the same absolute quantity of venom into children as adults.",
            secondLine = "Neostigmine + Atropine 'Challenge Test' (FOR NEUROTOXIC BITES):\n• Pre-treat with Atropine 0.6 mg IV (children 0.05 mg/kg) to prevent cholinergic bradycardia.\n• Administer Neostigmine Methylsulfate 1.5 mg to 2.5 mg IV/IM (children 0.04 mg/kg).\n• Closely observe ptosis and respiratory effort every 10 minutes for 30-60 minutes.\n• If ptosis improves and tidal volume increases ('Positive Test'): Continue Neostigmine 0.5 mg to 1.0 mg IV/IM every 30 minutes with Atropine PRN until full neurological recovery.\n• If no improvement ('Negative Test', typical for Krait pre-synaptic beta-bungarotoxins): Prepare for early endotracheal intubation and mechanical ventilation (ASVS and mechanical ventilation are life-saving).",
            inpatient = "Management of ASVS Anaphylactoid Reactions:\n• At first sign of urticaria, wheezing, hypotension, or angioedema: STOP ASVS INFUSION IMMEDIATELY.\n• Administer Adrenaline (Epinephrine) 0.5 mg IM (1:1000 solution) into anterolateral mid-thigh (children 0.01 mg/kg, max 0.3 mg).\n• Administer IV Hydrocortisone 100-200 mg and IV Chlorpheniramine 10 mg.\n• Once stable, RESUME ASVS infusion at a slower rate.\n\nCriteria for Repeat ASVS (10 More Vials):\n• Hemotoxic: 20WBCT remains non-clotting 6 hours after completion of initial ASVS, or active spontaneous systemic bleeding continues after 1-2 hours.\n• Neurotoxic: Deteriorating neurological / bulbar paralysis 1-2 hours after initial ASVS.",
            guidelines = "Nepal Ministry of Health and Population / EDCD National Guidelines for Management of Snakebite in Nepal (Updated Edition) & WHO Snake Antivenoms Guidelines.",
            keyDrugs = listOf("Polyvalent Anti-Snake Venom (ASVS)", "Adrenaline (Epinephrine 1:1000)", "Atropine Sulfate", "Neostigmine Methylsulfate", "Hydrocortisone"),
            supportiveCare = "Strict bed rest; keep bitten limb immobilized with a splint at heart level. DO NOT apply tourniquets, incisions, suction, or herbal pastes. Maintain airway; suction secretions. Continuous pulse oximetry, cardiac monitoring, and urine output monitoring (risk of acute kidney injury from rhabdomyolysis / hemoglobinuria in Russell's viper bites).",
            redFlags = "Descending paralysis with 'broken neck sign' and inability to swallow saliva (impending respiratory arrest); Incoagulable blood (positive 20WBCT); Oliguria or dark brown/cola-colored urine (AKI); Compartment syndrome in bitten extremity.",
            references = listOf(
                "National Guideline for Snakebite Management in Nepal, MoHP / EDCD (2019/2023)",
                "WHO Guidelines for the Management of Snakebites in the South-East Asia Region",
                "Alirol et al., Snake Bite in South Asia: A Review, PLoS Negl Trop Dis (2010)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 458"
            )
        ),

        // 3. Nepal National Tuberculosis Control Programme Protocol (NTP / DOTS)
        DiseaseProtocol(
            id = "proto_nepal_tb_dots",
            name = "Nepal National Tuberculosis Programme (NTP / DOTS) Protocol",
            category = "Respiratory & Infectious",
            icd10 = "A15.0",
            diagnosticCriteria = "Presumptive TB: Cough lasting >2 weeks, fever, night sweats, unexplained weight loss, hemoptysis, chest pain, or loss of appetite. Microbiological confirmation via GeneXpert MTB/RIF (rapid molecular assay testing MTB and Rifampicin resistance), sputum smear microscopy for Acid-Fast Bacilli (AFB via Ziehl-Neelsen or auramine fluorescence), and chest radiography.",
            firstLine = "Standard 6-Month First-Line Fixed-Dose Combination (FDC) Regimen:\n• Intensive Phase (2 Months: 2HRZE):\n  - Daily Fixed-Dose Combination Tablet (4-FDC: Rifampicin 150 mg + Isoniazid 75 mg + Pyrazinamide 400 mg + Ethambutol 275 mg).\n  - DOSING BY WEIGHT BAND:\n    * 30 to 37 kg: 2 tablets PO once daily\n    * 38 to 54 kg: 3 tablets PO once daily\n    * 55 to 70 kg: 4 tablets PO once daily\n    * >70 kg: 5 tablets PO once daily\n• Continuation Phase (4 Months: 4HR):\n  - Daily Fixed-Dose Combination Tablet (2-FDC: Rifampicin 150 mg + Isoniazid 75 mg).\n  - Weight bands: 30-37kg: 2 tabs; 38-54kg: 3 tabs; 55-70kg: 4 tabs; >70kg: 5 tabs PO daily.\n\nMandatory Co-Prescription:\n• Pyridoxine (Vitamin B6) 20 mg to 50 mg PO once daily for all patients to prevent Isoniazid-induced peripheral neuropathy (especially in diabetes, pregnancy, alcoholism, and malnutrition).",
            secondLine = "MDR/RR-TB Short All-Oral Regimen (BPaL / BPaLM Regimen):\n• Bedaquiline (BDQ) 400 mg daily for 2 weeks, then 200 mg 3 times weekly for 24 weeks.\n• Pretomanid (Pa) 200 mg PO daily for 24 weeks.\n• Linezolid (LZD) 600 mg PO daily for 16-24 weeks.\n• Moxifloxacin (Mfx) 400 mg daily (added for BPaLM if fluoroquinolone-susceptible).\n• Duration: 6 months total treatment at dedicated NTP MDR-TB centers.",
            inpatient = "Monitoring and Adverse Drug Reaction (ADR) Protocols:\n• Drug-Induced Liver Injury (DILI): Stop HRZE immediately if serum transaminases (ALT/AST) >5x ULN without symptoms, or >3x ULN with jaundice/nausea. Reintroduce sequentially once transaminases normalize: Ethambutol -> Isoniazid -> Rifampicin.\n• Ethambutol Retrobulbar Neuritis: Baseline and periodic visual acuity and red-green color discrimination testing; discontinue immediately if visual loss occurs.\n• Hyperuricemia / Arthralgia from Pyrazinamide: Treat symptomatically with NSAIDs; do not stop Pyrazinamide unless gouty arthritis develops.",
            guidelines = "National Tuberculosis Control Programme (NTCP / National Tuberculosis Center NTC Nepal) Clinical Management Guidelines & WHO Operational Handbook on Tuberculosis (Module 4, 2022).",
            keyDrugs = listOf("4-FDC (HRZE)", "2-FDC (HR)", "Pyridoxine (Vitamin B6)", "Bedaquiline", "Linezolid"),
            supportiveCare = "Directly Observed Therapy (DOTS); nutritional support (high-protein diet, micronutrients); contact tracing and screening of all household contacts under 5 years for Tuberculosis Preventive Treatment (TPT: 3HP weekly Isoniazid-Rifapentine or 6H daily Isoniazid). Strict infection control (well-ventilated rooms, cough etiquette).",
            redFlags = "Rifampicin resistance detected on GeneXpert (immediate referral for MDR-TB evaluation); Jaundice, dark urine, or persistent vomiting (severe DILI); Visual blurring or loss of color vision (Ethambutol toxicity); Peripheral neuropathy tingling in feet.",
            references = listOf(
                "National Tuberculosis Program Guidelines, National Tuberculosis Center (NTC), Thimi, Nepal",
                "WHO Consolidated Guidelines on Tuberculosis (Module 4: Treatment, 2022)",
                "Nepal National Strategic Plan for Tuberculosis (2021-2026)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 173"
            )
        ),

        // 4. Nepal National Malaria Treatment Protocol (EDCD / WHO)
        DiseaseProtocol(
            id = "proto_nepal_malaria",
            name = "Nepal National Malaria Treatment Protocol",
            category = "Infectious Diseases",
            icd10 = "B54",
            diagnosticCriteria = "Acute febrile illness in resident of or traveler returning from malaria-endemic Terai/inner Terai districts of Nepal. Triad of paroxysmal chills, high fever, and drenching sweats, with splenomegaly and anemia. Parasitological confirmation via Rapid Diagnostic Test (RDT detecting HRP2 for P. falciparum and pLDH for P. vivax) and microscopic examination of Giemsa-stained thick and thin blood films.",
            firstLine = "Uncomplicated Plasmodium falciparum Malaria:\n• Artemether-Lumefantrine (Coartem: 20 mg Artemether + 120 mg Lumefantrine):\n  - 6-Dose Regimen given over 3 days (taken with milk or fatty meal to ensure absorption):\n    * Dose 1: Stat at diagnosis (Hour 0)\n    * Dose 2: Exactly 8 hours later\n    * Doses 3 & 4: Morning and evening of Day 2 (Hour 24 and 36)\n    * Doses 5 & 6: Morning and evening of Day 3 (Hour 48 and 60)\n  - DOSING BY WEIGHT:\n    * 5 to 14 kg: 1 tablet per dose (6 tabs total)\n    * 15 to 24 kg: 2 tablets per dose (12 tabs total)\n    * 25 to 34 kg: 3 tablets per dose (18 tabs total)\n    * ≥35 kg & Adults: 4 tablets per dose (24 tabs total)\n• Plus Single-Dose Primaquine: 0.25 mg/kg PO on Day 1 as a gametocytocide to prevent transmission.\n\nUncomplicated Plasmodium vivax Malaria:\n• Chloroquine 25 mg base/kg PO over 3 days (10 mg/kg Day 1, 10 mg/kg Day 2, 5 mg/kg Day 3) OR Coartem for 3 days PLUS\n• Radical Cure for Relapse Prevention (Anti-hypnozoite therapy):\n  - Primaquine Phosphate 0.25 mg base/kg PO ONCE DAILY WITH FOOD FOR 14 CONSECUTIVE DAYS.\n  - G6PD CAUTION: Screen for G6PD deficiency before starting 14-day primaquine (causes severe acute hemolytic anemia and hemoglobinuria in G6PD-deficient individuals).",
            secondLine = "Severe / Cerebral Malaria (Medical Emergency - P. falciparum with hyperparasitemia >2%, impaired consciousness, seizures, pulmonary edema, severe anemia, acute kidney injury, or jaundice):\n• Artesunate IV/IM:\n  - Loading Dose: 2.4 mg/kg IV stat (children <20 kg: 3.0 mg/kg IV stat).\n  - Maintenance Doses: 2.4 mg/kg IV at 12 hours and 24 hours, then 2.4 mg/kg IV ONCE DAILY.\n  - Minimum of 3 parenteral doses (24 hours). Once patient can tolerate oral medications, switch to a complete 3-day course of oral Artemether-Lumefantrine (Coartem).",
            inpatient = "Management of Complications:\n• Hypoglycemia: Frequent bedside blood glucose monitoring; treat with 10% or 25% Dextrose IV bolus.\n• Acute Kidney Injury: Careful fluid resuscitation avoiding volume overload (pulmonary edema risk).\n• Convulsions: IV Midazolam or Diazepam; rule out hypoglycemia.",
            guidelines = "Epidemiology and Disease Control Division (EDCD), Department of Health Services, Ministry of Health and Population Nepal & WHO Guidelines for Malaria (2023).",
            keyDrugs = listOf("Artemether + Lumefantrine (Coartem)", "Artesunate IV", "Primaquine Phosphate", "Chloroquine Phosphate", "Glucose / Dextrose 10%"),
            supportiveCare = "Prompt antipyretic therapy with Paracetamol (avoid NSAIDs). Strict intake/output fluid chart. Long-Lasting Insecticidal Nets (LLINs) and indoor residual spraying (IRS). Monitor for delayed post-artesunate hemolytic anemia (PAHA) 1-3 weeks following IV artesunate.",
            redFlags = "Impaired consciousness / GCS <11 (cerebral malaria); SpO2 <90% or pulmonary rales; Serum bilirubin >3 mg/dL with parasite count >100,000/mcL; Dark red/black urine (blackwater fever / severe intravascular hemolysis); Blood glucose <40 mg/dL.",
            references = listOf(
                "National Malaria Treatment Protocol, EDCD / MoHP, Kathmandu, Nepal (2020/2023)",
                "WHO Guidelines for Malaria (2023)",
                "Nepal Malaria Strategic Plan for Elimination (2014-2025)",
                "Harrison's Principles of Internal Medicine, 21st Edition, Chapter 219"
            )
        )
    )
}
