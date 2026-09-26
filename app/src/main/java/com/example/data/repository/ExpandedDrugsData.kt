package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug
import com.example.data.model.DrugInteraction
import com.example.data.model.InteractionSeverity

object ExpandedDrugsData {

    val expandedDrugs: List<Drug> = listOf(
        // d61: Tofacitinib Citrate (User specifically searched for this)
        Drug(
            id = "d61",
            genericName = "Tofacitinib Citrate",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Targeted Synthetic DMARD (Oral Janus Kinase / JAK1 & JAK3 Inhibitor)",
            blackBoxWarning = "SERIOUS INFECTIONS, MORTALITY, MALIGNANCY, MAJOR ADVERSE CARDIOVASCULAR EVENTS (MACE) & THROMBOSIS: Patients treated with tofacitinib are at increased risk of serious bacterial, mycobacterial (tuberculosis), fungal, and viral infections leading to hospitalization or death. Perform TB screening (PPD/IGRA) before initiating. Higher rates of all-cause mortality and MACE (MI, stroke) observed in patients ≥50 years with at least one cardiovascular risk factor.",
            indications = "Moderate to severely active Rheumatoid Arthritis (RA) with inadequate response or intolerance to methotrexate; Psoriatic Arthritis (PsA); Active Ankylosing Spondylitis (AS); Moderate to severely active Ulcerative Colitis (UC); Polyarticular Course Juvenile Idiopathic Arthritis (pcJIA).",
            doses = "Rheumatoid Arthritis / Psoriatic Arthritis / Ankylosing Spondylitis: 5 mg PO BID or 11 mg (extended-release) PO once daily.\nUlcerative Colitis: Induction: 10 mg PO BID for 8-16 weeks; Maintenance: 5 mg PO BID (or 10 mg PO BID if loss of response).\npcJIA (≥10 kg to <20 kg): 3.2 mg PO BID; (20 kg to <40 kg): 4 mg PO BID; (≥40 kg): 5 mg PO BID.",
            administration = "Oral administration with or without food. Swallow extended-release tablets whole; do not crush, split, or chew.",
            timing = "Regularly spaced twice daily (q12h) or once daily morning (for XR).",
            specialInstructions = "MANDATORY PRE-TREATMENT SCREENING: Screen for latent Tuberculosis (Chest X-ray, Mantoux/Quantiferon Gold), Hepatitis B and C serology prior to starting. Check baseline CBC (Absolute Neutrophil Count >1,000/mm³, Absolute Lymphocyte Count >500/mm³, Hb >9 g/dL) and lipid profile at 4-8 weeks. Interrupt therapy if severe active infection develops. Avoid live attenuated vaccines during treatment.",
            pkPd = "Selectively and reversibly inhibits Janus kinases (primarily JAK1 and JAK3), blocking signal transduction of pro-inflammatory cytokines (IL-2, IL-4, IL-7, IL-9, IL-15, IL-21 and Type I/II interferons) via the STAT pathway. Rapid oral absorption with peak concentrations at 0.5-1 hour. Terminal half-life ~3 hours. Hepatic clearance (~70% via CYP3A4, minor CYP2C19) and renal excretion (~30% unchanged).",
            renalAdj = "CrCl ≥50 mL/min: No adjustment required.\nCrCl 30-49 mL/min (Moderate): Reduce dose to 5 mg PO once daily (or 5 mg PO BID if induction for UC).\nCrCl <30 mL/min or ESRD on Hemodialysis: 5 mg PO once daily (administer dose after hemodialysis on dialysis days).",
            hepaticAdj = "Mild impairment (Child-Pugh A): No adjustment required.\nModerate impairment (Child-Pugh B): Reduce dose to 5 mg PO once daily (or 5 mg PO BID in UC induction).\nSevere impairment (Child-Pugh C): CONTRAINDICATED (not recommended).",
            pregnancy = "Category D / Pregnancy Risk: Contraindicated. Teratogenicity, embryolethality, and skeletal malformations demonstrated in animal studies. Effective contraception required in females of reproductive potential during treatment and for at least 4-6 weeks after cessation.",
            lactation = "Breastfeeding is not recommended during tofacitinib therapy and for at least 18 hours (36 hours for XR) after the last dose.",
            sideEffects = "Upper respiratory tract infections, nasopharyngitis, headache, diarrhea, herpes zoster reactivation (shingles), hyperlipidemia (elevated LDL/HDL), elevated liver transaminases (ALT/AST), neutropenia, lymphopenia, deep vein thrombosis (DVT), pulmonary embolism (PE).",
            priceNpr = "NPR 1,800.00 - 3,200.00 per strip of 10 tablets (5mg)",
            priceInr = "INR 850.00 - 1,650.00 per strip of 10 tablets (5mg)",
            brandsNepal = listOf(
                BrandInfo("Tofajak", "Cipla (Nepal Division)", "Film-coated Tab", "5 mg / 11 mg XR"),
                BrandInfo("Jakvin", "Sun Pharma Nepal", "Tablet", "5 mg"),
                BrandInfo("Tofanib", "Lupin / Medisales Nepal", "Tablet", "5 mg / 11 mg XR"),
                BrandInfo("Tofa-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Jakvin", "Sun Pharmaceutical Industries", "Tablet", "5 mg / 11 mg XR"),
                BrandInfo("Tofajak", "Cipla Ltd.", "Film-coated Tab", "5 mg / 11 mg ER"),
                BrandInfo("Tofanib", "Lupin Ltd.", "Tablet", "5 mg / 11 mg XR"),
                BrandInfo("Tofadoz", "Dr. Reddy's Laboratories", "Tablet", "5 mg"),
                BrandInfo("Tofa", "Alkem Laboratories", "Tablet", "5 mg"),
                BrandInfo("Xeljanz", "Pfizer India", "Tablet", "5 mg / 11 mg XR")
            ),
            pediatricDosePerKg = 0.1,
            pediatricInterval = "mg/kg BID (pcJIA weight-tiered: 3.2mg to 5mg BID)",
            adultDose = "5 mg PO BID or 11 mg XR once daily",
            childDose = "pcJIA: ≥10 to <20kg: 3.2 mg BID; 20 to <40kg: 4 mg BID; ≥40kg: 5 mg BID",
            contraindications = "Severe hepatic impairment (Child-Pugh C); active serious infections; active tuberculosis; absolute neutrophil count <1000/mm³; lymphocyte count <500/mm³; hemoglobin <9 g/dL; pregnancy.",
            modeOfAction = "JAK1 and JAK3 kinase inhibitor interrupting cytokine-mediated gene expression in immune cells via JAK-STAT pathway.",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole, Clarithromycin) increase levels (reduce tofacitinib dose by 50%). Strong inducers (Rifampicin, Carbamazepine) decrease efficacy. Avoid combining with biologic DMARDs or potent immunosuppressants (Azathioprine, Cyclosporine).",
            packSize = "Strip of 10 or 30 tablets",
            counselingNepali = "यो औषधि जोर्नी दुख्ने, बाथ रोग र अल्सर भएको आन्द्राको लागि खाइन्छ। दिनको २ पटक खानुहोस्। छातीको टीबी जचाएर मात्र यो सुरु गर्नुपर्छ। ज्वरो आएमा तुरुन्त डाक्टरलाई देखाउनुहोस्।",
            counselingEnglish = "Take with or without food twice daily. TB testing and liver/blood tests are mandatory prior to initiation. Report fever, persistent cough, or signs of infection immediately."
        ),

        // d62: Methotrexate
        Drug(
            id = "d62",
            genericName = "Methotrexate",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Antimetabolite / Antifolate Conventional Synthetic DMARD (csDMARD)",
            blackBoxWarning = "FATAL DOSING ERRORS & MULTI-ORGAN TOXICITY: Methotrexate for rheumatoid arthritis and psoriasis MUST BE ADMINISTERED ONCE WEEKLY, NOT DAILY. Daily administration has resulted in fatal bone marrow suppression and gastrointestinal toxicity. Hepatotoxicity, lung disease (pneumonitis), severe opportunistic infections, and embryo-fetal death or congenital anomalies.",
            indications = "First-line conventional synthetic DMARD for Rheumatoid Arthritis (RA); Severe recalcitrant Plaque Psoriasis; Psoriatic Arthritis; Systemic Lupus Erythematosus (SLE); Juvenile Idiopathic Arthritis (JIA); Crohn's Disease; Acute Lymphoblastic Leukemia; Ectopic pregnancy (medical management).",
            doses = "Rheumatoid Arthritis & Psoriasis: 7.5 to 15 mg ONCE WEEKLY PO or SubQ (single day each week). Titrate by 2.5-5 mg/week to target 15-25 mg ONCE WEEKLY.\nFolic Acid Co-prescription: 5 mg PO once weekly (taken 24-48 hours after methotrexate) or 1 mg PO daily (except on methotrexate day) to reduce nausea, stomatitis, and cytopenias.\nEctopic Pregnancy: 50 mg/m² IM single dose (or Day 1, 3, 5, 7 alternating with leucovorin).",
            administration = "Oral on an empty stomach with a full glass of water, or subcutaneous / intramuscular injection. STRICTLY ONCE PER WEEK.",
            timing = "Designate one specific day of the week (e.g. Every Sunday).",
            specialInstructions = "MANDATORY ONCE-WEEKLY COUNSELING: Emphasize to patient that this medication is taken ONCE PER WEEK, NOT EVERY DAY. Monitor CBC, LFT, and Renal function every 2-4 weeks during titration, then every 8-12 weeks. Abstain from alcohol (compounds hepatotoxicity).",
            pkPd = "Competitively inhibits dihydrofolate reductase (DHFR), impairing thymidylate, purine, and DNA synthesis. In rheumatoid arthritis, anti-inflammatory effect is mediated by accumulation of adenosine at inflamed synovial tissue. Renal excretion 80-90% unchanged. Half-life 3-10 hours.",
            renalAdj = "CrCl 60-80 mL/min: Reduce dose to 75% of normal.\nCrCl 30-59 mL/min: Reduce dose to 50% of normal.\nCrCl <30 mL/min: CONTRAINDICATED (high risk of lethal marrow suppression).",
            hepaticAdj = "Contraindicated in chronic liver disease, cirrhosis, alcoholic liver disease, or baseline transaminases >2x ULN.",
            pregnancy = "Category X / Absolute Contraindication: Teratogenic, abortifacient, and causes severe cranial/skeletal malformations. Discontinue at least 3 months prior to planned conception in both men and women.",
            lactation = "Contraindicated during breastfeeding due to accumulation in breast milk and high toxicity.",
            sideEffects = "Ulcerative stomatitis, nausea, dyspepsia, fatigue, elevated transaminases, pancytopenia, alopecia, hypersensitivity pneumonitis (dry cough, dyspnea), acute renal failure with high doses.",
            priceNpr = "NPR 120.00 - 280.00 per strip of 10 tablets (10mg / 15mg)",
            priceInr = "INR 70.00 - 180.00 per strip of 10 tablets (10mg / 15mg)",
            brandsNepal = listOf(
                BrandInfo("Folitrax", "Ipca Laboratories (Nepal)", "Tablet", "5 mg / 7.5 mg / 10 mg / 15 mg"),
                BrandInfo("Neotrexate", "Nepal Pharmaceuticals Lab", "Tablet", "2.5 mg / 10 mg / 15 mg"),
                BrandInfo("Imutrex", "Cipla Nepal", "Tablet", "7.5 mg / 10 mg / 15 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Folitrax", "Ipca Laboratories Ltd.", "Tab / Inj", "5 mg / 7.5 mg / 10 mg / 15 mg / 25 mg"),
                BrandInfo("Imutrex", "Cipla Ltd.", "Tablet", "7.5 mg / 10 mg / 15 mg"),
                BrandInfo("Mexate", "Zydus Healthcare", "Tablet / Inj", "2.5 mg / 10 mg / 50 mg Inj"),
                BrandInfo("Trexall", "Pfizer", "Tablet", "5 mg / 10 mg")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "mg/kg once weekly (JIA: 10-15 mg/m² once weekly)",
            adultDose = "7.5 to 25 mg ONCE WEEKLY (never daily) + Folic acid",
            childDose = "JIA: 10-15 mg/m² once weekly PO or SubQ",
            contraindications = "Pregnancy (Category X), breastfeeding, chronic liver disease, severe renal impairment (CrCl <30 mL/min), pre-existing blood dyscrasias, active tuberculosis or untreated serious infection.",
            modeOfAction = "Inhibits dihydrofolate reductase and promotes adenosine release, suppressing synovial T-cell and B-cell proliferation.",
            interactions = "NSAIDs, Penicillins, and Proton Pump Inhibitors reduce renal methotrexate clearance (risk of severe toxicity). Trimethoprim-Sulfamethoxazole synergistically depletes folates causing fatal aplastic anemia (AVOID combination). Alcohol increases cirrhosis risk.",
            packSize = "Strip of 10 tablets"
        ),

        // d63: Hydroxychloroquine Sulfate
        Drug(
            id = "d63",
            genericName = "Hydroxychloroquine Sulfate",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Disease-Modifying Antirheumatic Drug / 4-Aminoquinoline",
            blackBoxWarning = null,
            indications = "Systemic Lupus Erythematosus (SLE - cornerstone therapy for survival and flare prevention); Rheumatoid Arthritis; Discoid Lupus; Juvenile Idiopathic Arthritis; Sjogren's Syndrome; Q-fever; Prophylaxis of Malaria (in chloroquine-sensitive regions).",
            doses = "SLE & Rheumatoid Arthritis: 200 mg to 400 mg PO once daily (or divided BID) with meals.\nMaximum Safe Daily Dose: MUST NOT EXCEED 5.0 mg/kg actual body weight/day to prevent irreversible retinal toxicity.\nMalaria Prophylaxis: 400 mg (310 mg base) PO once weekly on the same day each week.",
            administration = "Oral with milk or food to minimize gastrointestinal discomfort.",
            timing = "Once daily with the largest meal.",
            specialInstructions = "OPHTHALMOLOGIC SCREENING: Baseline dilated retinal exam, visual fields (Humphrey 10-2), and spectral domain optical coherence tomography (SD-OCT) within the first year of therapy. Annual screening is mandatory after 5 years of use (or earlier if high risk: dose >5 mg/kg, CKD, or tamoxifen co-use). Bull's-eye retinopathy is irreversible.",
            pkPd = "Accumulates in intracellular lysosomes, raising intralysosomal pH and interfering with antigen processing and toll-like receptor (TLR-7, TLR-9) signaling. Very large volume of distribution. Slowly excreted by kidneys (15-25% unchanged). Extremely long terminal elimination half-life (~40-50 days).",
            renalAdj = "CrCl <30 mL/min: Reduce dose by 25-50% or monitor for toxicity due to prolonged clearance.",
            hepaticAdj = "Use caution; extensively concentrated in liver tissue.",
            pregnancy = "Compatible / Strongly Recommended in Lupus Pregnancy: Hydroxychloroquine reduces disease flares, preeclampsia risk, and neonatal congenital heart block. Do NOT discontinue during pregnancy in SLE.",
            lactation = "Present in breast milk in low concentrations; considered compatible with breastfeeding by American College of Rheumatology (ACR).",
            sideEffects = "Nausea, epigastric distress, diarrhea, macular pigmentation / retinopathy (bull's-eye), skin hyperpigmentation (blue-gray discoloration), QTc prolongation, hypoglycemia in diabetics, hemolytic anemia in G6PD deficiency.",
            priceNpr = "NPR 140.00 - 240.00 per strip of 10 tablets (200mg)",
            priceInr = "INR 80.00 - 160.00 per strip of 10 tablets (200mg)",
            brandsNepal = listOf(
                BrandInfo("HCQS", "Ipca Laboratories (Nepal)", "Tablet", "200 mg / 300 mg / 400 mg"),
                BrandInfo("Hydroquin", "Nepal Pharmaceuticals Lab", "Tablet", "200 mg"),
                BrandInfo("Zy-Q", "Zydus Healthcare Nepal", "Tablet", "200 mg / 300 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("HCQS", "Ipca Laboratories Ltd.", "Tablet", "200 mg / 300 mg / 400 mg"),
                BrandInfo("Plaquenil", "Sanofi India", "Tablet", "200 mg"),
                BrandInfo("Zy-Q", "Zydus Healthcare", "Tablet", "200 mg / 300 mg"),
                BrandInfo("Hqtor", "Torrent Pharmaceuticals", "Tablet", "200 mg / 400 mg")
            ),
            pediatricDosePerKg = 3.0,
            pediatricInterval = "mg/kg/day PO (max 5 mg/kg/day, up to 400 mg)",
            adultDose = "200-400 mg PO daily (max 5 mg/kg/day actual weight)",
            childDose = "3-5 mg/kg/day PO (max 400 mg/day)",
            contraindications = "Pre-existing maculopathy or retinal disease; hypersensitivity to 4-aminoquinoline derivatives.",
            modeOfAction = "Raises lysosomal pH in antigen-presenting cells, blocking MHC-peptide loading and inhibiting TLR-7 and TLR-9 immune activation.",
            interactions = "Co-administration with other QT-prolonging drugs (Azithromycin, Haloperidol, Moxifloxacin) increases Torsades de Pointes risk. Enhances hypoglycemic effect of Insulin and Sulfonylureas. Increases serum Digoxin levels.",
            packSize = "Strip of 10 tablets"
        ),

        // d64: Sulfasalazine
        Drug(
            id = "d64",
            genericName = "Sulfasalazine",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "5-Aminosalicylate (5-ASA) + Sulfapyridine Conjugate / Conventional DMARD",
            blackBoxWarning = null,
            indications = "Ulcerative Colitis (induction and maintenance of remission); Crohn's Disease (mild colonic disease); Rheumatoid Arthritis (as part of triple DMARD therapy); Psoriatic Arthritis; Ankylosing Spondylitis and Seronegative Spondyloarthropathies.",
            doses = "Ulcerative Colitis: Initial 1 g PO TID-QID with meals. Titrate up to 3-4 g/day in divided doses. Maintenance: 2 g/day divided BID-TID.\nRheumatoid Arthritis (Enteric-coated): Initial 500 mg PO daily with food for week 1; increase by 500 mg/day each week up to maintenance of 1 g PO BID (2 g/day).\nPediatrics (≥6 yrs): 30-50 mg/kg/day in 3-4 divided doses.",
            administration = "Oral with or immediately after meals and a full glass of water. Swallow enteric-coated tablets whole; do not break.",
            timing = "Divided doses with breakfast, lunch, and dinner.",
            specialInstructions = "HIGH FLUID INTAKE: Maintain generous hydration (at least 2-3 liters of fluids daily) to prevent crystalluria and kidney stone formation. Urine and skin may turn an orange-yellow color (harmless, advise patient). Co-prescribe Folic Acid 1 mg daily as sulfasalazine inhibits intestinal folate absorption.",
            pkPd = "Cleaved by bacterial azoreductases in the colon into 5-aminosalicylic acid (mesalamine - local anti-inflammatory) and sulfapyridine (absorbed systemically and responsible for DMARD activity and most adverse effects). Hepatic acetylation (slow vs fast acetylators). Half-life ~6-8 hours.",
            renalAdj = "CrCl 30-50 mL/min: Administer every 12 hours.\nCrCl <30 mL/min: Avoid use or reduce dose by 50% with strict hydration.",
            hepaticAdj = "Use caution; severe liver disease increases risk of sulfapyridine accumulation.",
            pregnancy = "Category B (Compatible): Safe in pregnancy with supplemental Folic Acid (2-5 mg/day) to prevent neural tube defects.",
            lactation = "Sulfapyridine is excreted into breast milk; use caution if infant is premature or hyperbilirubinemic.",
            sideEffects = "Nausea, anorexia, dyspepsia, headache, reversible male oligospermia/infertility (resolves 2-3 months after cessation), orange-yellow discoloration of urine and soft contact lenses, rash, leukopenia, hemolytic anemia in G6PD deficiency, Stevens-Johnson syndrome.",
            priceNpr = "NPR 180.00 - 320.00 per strip of 10 tablets (500mg)",
            priceInr = "INR 95.00 - 210.00 per strip of 10 tablets (500mg)",
            brandsNepal = listOf(
                BrandInfo("Saaz", "Ipca Laboratories (Nepal)", "Enteric-coated Tab", "500 mg / 1000 mg"),
                BrandInfo("Salazopyrin", "Pfizer Nepal", "Enteric-coated Tab", "500 mg"),
                BrandInfo("Sulfasal", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Saaz", "Ipca Laboratories Ltd.", "Enteric-coated Tab", "500 mg / 1000 mg"),
                BrandInfo("Salazopyrin", "Pfizer India", "Enteric-coated Tab", "500 mg"),
                BrandInfo("Sazo", "Wallace Pharmaceuticals", "Enteric-coated Tab", "500 mg / 1000 mg"),
                BrandInfo("Salfaz", "Sun Pharma", "Tablet", "500 mg")
            ),
            pediatricDosePerKg = 40.0,
            pediatricInterval = "mg/kg/day in 3-4 divided doses (max 2 g/day)",
            adultDose = "UC: 1-2g PO TID-QID; RA: 1g PO BID (titrated) with meals",
            childDose = "30-50 mg/kg/day divided q8h (max 2g/day)",
            contraindications = "Hypersensitivity to sulfonamides or salicylates; intestinal or urinary obstruction; porphyria; severe renal or hepatic failure.",
            modeOfAction = "Colonic release of 5-ASA inhibits lipoxygenase and cyclooxygenase pathways; sulfapyridine suppresses leukocyte migration and cytokine synthesis.",
            interactions = "Inhibits intestinal absorption of Folic Acid and Digoxin. Enhances oral hypoglycemic effects of sulfonylureas. Avoid combining with nephrotoxic drugs.",
            packSize = "Strip of 10 or bottle of 100 tablets"
        ),

        // d65: Baricitinib
        Drug(
            id = "d65",
            genericName = "Baricitinib",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Targeted Synthetic DMARD (Janus Kinase / JAK1 & JAK2 Inhibitor)",
            blackBoxWarning = "SERIOUS INFECTIONS, MORTALITY, MALIGNANCY, MACE & THROMBOSIS: Higher rates of all-cause mortality, cardiovascular death, myocardial infarction, stroke, and deep vein thrombosis / pulmonary embolism observed with JAK inhibitors in patients ≥50 years with cardiovascular risks. Screen for TB before initiation.",
            indications = "Moderate to severely active Rheumatoid Arthritis (RA) in adults with inadequate response to TNF antagonists; Severe Alopecia Areata; Moderate to severe Atopic Dermatitis; Hospitalized COVID-19 patients requiring supplemental oxygen, mechanical ventilation, or ECMO (in combination with remdesivir/dexamethasone).",
            doses = "Rheumatoid Arthritis & Atopic Dermatitis: 2 mg to 4 mg PO once daily.\nAlopecia Areata: 2 mg PO once daily; may increase to 4 mg once daily if response is inadequate.\nCOVID-19 (Hospitalized): 4 mg PO once daily for 14 days (or until discharge).",
            administration = "Oral once daily, with or without food. Can be administered via nasogastric (NG) tube after dispersing in water if necessary.",
            timing = "Once daily at the same time each morning.",
            specialInstructions = "Screen for latent TB, Hepatitis B, and Hepatitis C prior to starting. Check baseline ANC (>1,000/mm³), ALC (>500/mm³), and Hb (>8 g/dL). Avoid co-administration with strong OAT3 inhibitors (Probenecid).",
            pkPd = "Reversible and selective inhibitor of JAK1 and JAK2 enzymes, preventing downstream phosphorylation of STAT proteins. Rapid absorption with ~80% bioavailability. Excreted primarily unchanged by kidneys (~75%) via OAT3 transporter. Terminal half-life ~12 hours.",
            renalAdj = "eGFR 60-89 mL/min: 4 mg once daily.\neGFR 30-59 mL/min: 2 mg once daily (reduce dose by 50%).\neGFR 15-29 mL/min: 1 mg once daily (or 2 mg every other day).\neGFR <15 mL/min: NOT RECOMMENDED.",
            hepaticAdj = "Mild to moderate hepatic impairment: No adjustment needed.\nSevere hepatic impairment: Not recommended.",
            pregnancy = "Category D / Pregnancy Risk: Contraindicated. Fetal skeletal abnormalities demonstrated in preclinical animal studies.",
            lactation = "Breastfeeding is not recommended during therapy and for at least 48 hours after discontinuation.",
            sideEffects = "Upper respiratory tract infections, herpes simplex and zoster reactivation, nausea, elevated LDL and HDL cholesterol, elevated CPK and liver enzymes, venous thromboembolism (VTE).",
            priceNpr = "NPR 1,500.00 - 2,800.00 per strip of 7 tablets (4mg)",
            priceInr = "INR 800.00 - 1,500.00 per strip of 7 tablets (4mg)",
            brandsNepal = listOf(
                BrandInfo("Barinat", "Natco / Medisales Nepal", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Barilup", "Lupin Nepal", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Olumiant", "Eli Lilly Nepal Import", "Tablet", "2 mg / 4 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Barinat", "Natco Pharma", "Tablet", "1 mg / 2 mg / 4 mg"),
                BrandInfo("Barilup", "Lupin Ltd.", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Olumiant", "Eli Lilly India", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Baricip", "Cipla Ltd.", "Tablet", "2 mg / 4 mg")
            ),
            adultDose = "2 mg to 4 mg PO once daily",
            contraindications = "Active tuberculosis; absolute neutrophil count <1000/mm³; lymphocyte count <500/mm³; hemoglobin <8 g/dL; severe hepatic impairment; pregnancy.",
            modeOfAction = "JAK1 and JAK2 kinase inhibitor blocking signal transduction of interleukins, interferons, and GM-CSF.",
            interactions = "Probenecid significantly increases baricitinib exposure (reduce baricitinib dose by 50% to 2mg or 1mg daily). Avoid combining with other JAK inhibitors or biologic DMARDs.",
            packSize = "Strip of 7 or 14 tablets"
        ),

        // d66: Leflunomide
        Drug(
            id = "d66",
            genericName = "Leflunomide",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Pyrimidine Synthesis Inhibitor / Conventional Synthetic DMARD",
            blackBoxWarning = "EMBRYO-FETAL TOXICITY & SEVERE HEPATOTOXICITY: Absolute contraindication in pregnancy (Category X). Exclude pregnancy before initiation. Severe, potentially fatal liver injury and acute hepatic necrosis reported. Avoid in patients with pre-existing hepatic disease or ALT >2x ULN.",
            indications = "Active Rheumatoid Arthritis (reduces signs, symptoms, and retards structural joint damage); Psoriatic Arthritis; Refractory Cytomegalovirus (CMV) infection in renal transplant patients (off-label).",
            doses = "Rheumatoid Arthritis: Loading dose: 100 mg PO once daily for 3 days (often omitted in clinical practice due to gastrointestinal intolerance and diarrhea).\nMaintenance: 10 mg to 20 mg PO once daily.",
            administration = "Oral with or without food. Swallow tablets whole.",
            timing = "Once daily morning.",
            specialInstructions = "LONG HALF-LIFE & CHOLESTYRAMINE WASHOUT: Active metabolite (teriflunomide) has an elimination half-life of ~2 weeks and can persist in plasma for up to 2 years after discontinuation. If pregnancy is planned or severe toxicity occurs, perform accelerated drug elimination: Cholestyramine 8 g PO TID for 11 days (verify plasma level <0.02 mg/L). Monitor ALT/AST and blood pressure monthly.",
            pkPd = "Isoxazole prodrug rapidly converted in bowel wall and liver to active metabolite A77 1726 (teriflunomide). Inhibits mitochondrial enzyme dihydroorotate dehydrogenase (DHODH), blocking de novo pyrimidine synthesis in activated T-lymphocytes. Enterohepatic recirculation. Half-life 14-18 days.",
            renalAdj = "Use with caution in mild-moderate impairment. Avoid in severe renal impairment.",
            hepaticAdj = "Contraindicated in pre-existing liver disease, hepatitis B/C, or baseline ALT/AST >2x ULN. If ALT rises 2-3x ULN, reduce dose to 10 mg daily; if >3x ULN, discontinue and initiate cholestyramine washout.",
            pregnancy = "Category X / Absolute Contraindication: Teratogenic. Verified washout protocol mandatory prior to planned pregnancy in both female and male patients.",
            lactation = "Contraindicated during breastfeeding due to potential serious adverse reactions in nursing infants.",
            sideEffects = "Diarrhea, nausea, dyspepsia, reversible alopecia, hypertension, elevated transaminases, leukopenia, peripheral neuropathy, interstitial lung disease.",
            priceNpr = "NPR 160.00 - 290.00 per strip of 10 tablets (10mg / 20mg)",
            priceInr = "INR 85.00 - 180.00 per strip of 10 tablets (10mg / 20mg)",
            brandsNepal = listOf(
                BrandInfo("Lefumide", "Ipca Laboratories (Nepal)", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Lefno", "Zydus Healthcare Nepal", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Arava", "Sanofi Nepal", "Tablet", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lefumide", "Ipca Laboratories Ltd.", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Lefno", "Zydus Healthcare", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Arava", "Sanofi India", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Lefra", "Torrent Pharmaceuticals", "Tablet", "10 mg / 20 mg")
            ),
            adultDose = "10 mg to 20 mg PO once daily (loading 100mg x 3d optional)",
            contraindications = "Pregnancy (Category X), severe hepatic impairment, pre-existing liver disease, severe immunodeficiency, bone marrow dysplasia.",
            modeOfAction = "Inhibits dihydroorotate dehydrogenase (DHODH), arresting de novo pyrimidine ribonucleotide synthesis in proliferative G1-phase lymphocytes.",
            interactions = "Co-administration with Methotrexate increases hepatotoxicity risk (requires bi-weekly liver monitoring). Cholestyramine and activated charcoal rapidly accelerate leflunomide elimination.",
            packSize = "Strip of 10 or 30 tablets"
        ),

        // d67: Colchicine
        Drug(
            id = "d67",
            genericName = "Colchicine",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Antimitotic Alkaloid / Tubulin Polymerization Inhibitor",
            blackBoxWarning = "FATAL OVERDOSE & CYP3A4 / P-GLYCOPROTEIN INTERACTIONS: Life-threatening and fatal colchicine toxicity reported with standard doses in patients with renal or hepatic impairment who are co-prescribed potent CYP3A4 inhibitors (Clarithromycin, Ketoconazole) or P-gp inhibitors (Cyclosporine). Avoid combination.",
            indications = "Acute Gout Flare (first-line within 12-24 hours of symptom onset); Prophylaxis of Gout flares during initiation of urate-lowering therapy (Allopurinol / Febuxostat); Familial Mediterranean Fever (FMF); Acute and recurrent Pericarditis; Coronary artery disease / Secondary prevention (low-dose 0.5 mg daily per LoDoCo2 trial).",
            doses = "Acute Gout Flare (Modern ACR Low-Dose Regimen): 1.0 mg (or 1.2 mg) PO stat at first sign of flare, followed 1 hour later by 0.5 mg (or 0.6 mg). Total dose: 1.5 mg in 1 hour. Do NOT exceed 1.5 mg in 24 hours. (Wait at least 3 days before repeating course).\nGout Prophylaxis: 0.5 mg PO once or twice daily (for up to 3-6 months while titrating allopurinol).\nPericarditis: 0.5 mg PO BID (<70 kg: 0.5 mg PO once daily) for 3 months.\nFamilial Mediterranean Fever: 1.0 to 2.0 mg PO daily in divided doses.",
            administration = "Oral with or without food. Take at the very first sign of joint pain or swelling.",
            timing = "Morning and/or evening with a glass of water.",
            specialInstructions = "AVOID OLD 'DOSE TO DIARRHEA' PROTOCOLS: Historic regimens (0.5mg every hour until vomiting/diarrhea) are toxic and obsolete. The low-dose regimen (1mg + 0.5mg 1h later) has equal efficacy with markedly superior safety. Co-administration with Clarithromycin or Erythromycin is strictly CONTRAINDICATED in renal/hepatic disease.",
            pkPd = "Binds to tubulin dimers, disrupting microtubule assembly and polymerisation. Inhibits leukocyte chemotaxis, adhesion, phagocytosis, and NLRP3 inflammasome activation in response to monosodium urate crystals. Peak levels in 0.5-2 hours. Metabolized by CYP3A4 and cleared by P-glycoprotein. Elimination half-life 20-40 hours.",
            renalAdj = "CrCl 30-50 mL/min: No change for acute flare; reduce prophylaxis to 0.5 mg once daily.\nCrCl 15-29 mL/min: Acute flare: 0.5 mg stat; repeat no sooner than 14 days. Prophylaxis: 0.5 mg every other day.\nCrCl <15 mL/min or Dialysis: CONTRAINDICATED with CYP3A4/P-gp inhibitors; otherwise 0.5 mg single dose only.",
            hepaticAdj = "Avoid use in patients with severe hepatic impairment who are also taking P-gp or CYP3A4 inhibitors.",
            pregnancy = "Category C (Caution): Crosses placenta. Use only if clinical benefit justifies potential fetal risk. FMF patients should continue under maternal-fetal medicine supervision.",
            lactation = "Present in breast milk in low concentrations; considered compatible with monitoring infant for diarrhea.",
            sideEffects = "Diarrhea, abdominal cramping, nausea, vomiting (cardinal signs of toxicity), peripheral neuropathy, myopathy / rhabdomyolysis (potentiated by statins), bone marrow suppression, alopecia.",
            priceNpr = "NPR 60.00 - 120.00 per strip of 10 tablets (0.5mg)",
            priceInr = "INR 35.00 - 75.00 per strip of 10 tablets (0.5mg)",
            brandsNepal = listOf(
                BrandInfo("Goutnil", "Taj Pharmaceuticals / Nepal Import", "Tablet", "0.5 mg"),
                BrandInfo("Colchicine-N", "Nepal Pharmaceuticals Lab", "Tablet", "0.5 mg"),
                BrandInfo("Colchicindo", "Indoco Remedies Nepal", "Tablet", "0.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Goutnil", "Inga Laboratories", "Tablet", "0.5 mg"),
                BrandInfo("Colchicindo", "Indoco Remedies Ltd.", "Tablet", "0.5 mg"),
                BrandInfo("Zycolchin", "Zydus Healthcare", "Tablet", "0.5 mg"),
                BrandInfo("Colchimax", "Samarth Life Sciences", "Tablet", "0.5 mg")
            ),
            adultDose = "Acute Gout: 1.0 mg stat + 0.5 mg 1 hr later (Max 1.5mg/24h); Prophylaxis: 0.5 mg OD-BID",
            childDose = "FMF: 4-11 yrs: 0.5-1.0 mg/day; ≥12 yrs: 1.0-1.5 mg/day",
            contraindications = "Severe renal (CrCl <15 mL/min) or severe hepatic impairment in patients taking CYP3A4 or P-glycoprotein inhibitors; bone marrow suppression.",
            modeOfAction = "Binds to tubulin, inhibiting microtubule polymerization, neutrophil migration, and NLRP3 inflammasome activation.",
            interactions = "Strong CYP3A4 inhibitors (Clarithromycin, Ketoconazole, Itraconazole) and P-gp inhibitors (Cyclosporine, Verapamil) cause lethal colchicine toxicity. Co-administration with Statins or Fibrates increases rhabdomyolysis risk.",
            packSize = "Strip of 10 tablets"
        ),

        // d68: Febuxostat
        Drug(
            id = "d68",
            genericName = "Febuxostat",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Potent Non-Purine Selective Xanthine Oxidase Inhibitor (XOI)",
            blackBoxWarning = "CARDIOVASCULAR DEATH WARNING: Increased risk of cardiovascular death observed in clinical trials (CARES trial) compared with allopurinol in patients with established cardiovascular disease. Reserve febuxostat for patients who have an inadequate response or intolerance to allopurinol.",
            indications = "Chronic management of Hyperuricemia in adult patients with Gout (subcutaneous tophi, gouty arthritis, uric acid nephrolithiasis); Prophylaxis and treatment of Hyperuricemia associated with chemotherapy (Tumor Lysis Syndrome).",
            doses = "Chronic Gout: Initial 40 mg PO once daily. Check serum uric acid level at 2-4 weeks; if serum urate is not <6.0 mg/dL (<360 mcmol/L), increase dose to 80 mg PO once daily.\nSevere tophaceous gout: Up to 120 mg PO once daily under specialist monitoring.\nGout Flare Prophylaxis: Concurrently prescribe Colchicine (0.5 mg OD-BID) or an NSAID for at least 3-6 months during initiation.",
            administration = "Oral once daily, with or without food. Antacids do not affect absorption.",
            timing = "Once daily morning.",
            specialInstructions = "DO NOT INITIATE DURING AN ACUTE GOUT ATTACK: Wait until the acute flare has fully resolved before starting urate-lowering therapy. However, if patient is already established on febuxostat and suffers a flare, DO NOT STOP it; manage flare with colchicine/NSAIDs. Target serum uric acid is <6.0 mg/dL (<5.0 mg/dL in severe tophaceous gout). Safe in moderate renal impairment without dose adjustment.",
            pkPd = "Selectively inhibits both the oxidized and reduced forms of xanthine oxidase enzyme, blocking conversion of hypoxanthine to xanthine, and xanthine to uric acid. Rapidly absorbed (85%). Hepatic metabolism (glucuronidation via UGT enzymes and CYP oxidation). Terminal half-life ~5-8 hours.",
            renalAdj = "Mild to moderate renal impairment (eGFR 30-89 mL/min): NO DOSE ADJUSTMENT REQUIRED (major advantage over allopurinol).\nSevere renal impairment (eGFR <30 mL/min): Max dose 40 mg once daily due to limited safety data.",
            hepaticAdj = "Mild to moderate hepatic impairment: No adjustment needed. Check baseline LFTs.",
            pregnancy = "Category C: Limited data. Use only if potential benefit outweighs risk.",
            lactation = "Excreted in milk in animal studies; avoid during breastfeeding or use allopurinol.",
            sideEffects = "Liver function test abnormalities (ALT elevation), nausea, arthralgias, gout flares (during initiation), rash, cardiovascular events, dizziness.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 tablets (40mg / 80mg)",
            priceInr = "INR 65.00 - 140.00 per strip of 10 tablets (40mg / 80mg)",
            brandsNepal = listOf(
                BrandInfo("Febutaz", "Sun Pharma Nepal", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Febuxor", "Nepal Pharmaceuticals Lab", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Foxstat", "Deurali-Janta Pharmaceuticals", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Zurig", "Zydus Healthcare Nepal", "Tablet", "40 mg / 80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Febutaz", "Sun Pharmaceutical Industries", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Zurig", "Zydus Healthcare", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Feburic", "Ajanta Pharma", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Febucip", "Cipla Ltd.", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Urikind-EB", "Mankind Pharma", "Tablet", "40 mg / 80 mg")
            ),
            adultDose = "40 mg to 80 mg PO once daily (Target serum urate <6 mg/dL)",
            contraindications = "Concurrent treatment with Azathioprine or Mercaptopurine (POTENTIALLY FATAL toxicity due to blocked metabolism); hypersensitivity to febuxostat.",
            modeOfAction = "Non-purine selective inhibitor of xanthine oxidase, suppressing uric acid synthesis.",
            interactions = "STRICTLY CONTRAINDICATED with Azathioprine and 6-Mercaptopurine: Xanthine oxidase metabolizes thiopurines; inhibition causes massive thiopurine accumulation and fatal bone marrow suppression. Theophylline levels may increase.",
            packSize = "Strip of 10 tablets"
        ),

        // d69: Allopurinol
        Drug(
            id = "d69",
            genericName = "Allopurinol",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Purine Analogue Xanthine Oxidase Inhibitor (XOI)",
            blackBoxWarning = "SEVERE CUTANEOUS ADVERSE REACTIONS (SCAR / STEVENS-JOHNSON SYNDROME / DRESS): Discontinue allopurinol immediately at the first sign of skin rash or allergic reaction. Screening for the HLA-B*58:01 allele is strongly recommended in patients of Asian descent (Han Chinese, Korean, Thai) as carriers have a markedly elevated risk of fatal SCAR.",
            indications = "First-line primary urate-lowering therapy for Chronic Gouty Arthritis and Tophaceous Gout; Recurrent Uric Acid Nephrolithiasis; Prevention of Tumor Lysis Syndrome and hyperuricemic nephropathy in cancer chemotherapy.",
            doses = "Chronic Gout: Initial 100 mg PO once daily (50 mg/day in CKD stage 3-5). Titrate upwards by 100 mg every 2-4 weeks to achieve target serum urate <6.0 mg/dL (<5.0 mg/dL for tophi). Maintenance 200-300 mg/day (max 800 mg/day in divided doses).\nTumor Lysis Syndrome: 300 to 600 mg PO daily in divided doses (pediatrics: 10 mg/kg/day divided q8h).\nFlare Prophylaxis: Co-prescribe Colchicine (0.5 mg OD) for 3-6 months.",
            administration = "Oral immediately after meals with plenty of fluid to minimize gastric irritation and prevent xanthine stone formation.",
            timing = "Single daily dose after breakfast (doses >300 mg divided BID).",
            specialInstructions = "START LOW, TITRATE SLOW: Starting with 100 mg (or 50 mg in CKD) drastically minimizes the risk of SCAR and severe initiation flares. Discontinue immediately if any skin rash, fever, or pruritus develops. Check renal function and serum uric acid periodically.",
            pkPd = "Competitive substrate and inhibitor of xanthine oxidase. Metabolized by xanthine oxidase to active metabolite oxypurinol (alloxanthine), which acts as a noncompetitive inhibitor with a long half-life (~15-25 hours). Oxypurinol is eliminated renally.",
            renalAdj = "CrCl >50 mL/min: Initial 100 mg daily; titrate cautiously.\nCrCl 30-50 mL/min: Initial 50-100 mg daily; max 200 mg/day.\nCrCl 10-29 mL/min: Initial 50 mg daily; max 100 mg/day.\nCrCl <10 mL/min / Hemodialysis: 50 mg every other day or 50 mg post-dialysis.",
            hepaticAdj = "Reduce dose and monitor liver enzymes in hepatic impairment.",
            pregnancy = "Category C: Use only when clearly needed and alternatives are unacceptable.",
            lactation = "Allopurinol and oxypurinol are excreted in human milk; use caution.",
            sideEffects = "Maculopapular rash, pruritus, allopurinol hypersensitivity syndrome (fever, rash, eosinophilia, hepatitis, renal failure), diarrhea, nausea, transient transaminase elevation.",
            priceNpr = "NPR 45.00 - 95.00 per strip of 10 tablets (100mg / 300mg)",
            priceInr = "INR 25.00 - 65.00 per strip of 10 tablets (100mg / 300mg)",
            brandsNepal = listOf(
                BrandInfo("Zyloric", "GlaxoSmithKline Nepal", "Tablet", "100 mg / 300 mg"),
                BrandInfo("Puricont", "Nepal Pharmaceuticals Lab", "Tablet", "100 mg / 300 mg"),
                BrandInfo("Ciploric", "Cipla Nepal", "Tablet", "100 mg / 300 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Zyloric", "GlaxoSmithKline Pharmaceuticals", "Tablet", "100 mg / 300 mg"),
                BrandInfo("Ciploric", "Cipla Ltd.", "Tablet", "100 mg / 300 mg"),
                BrandInfo("Allo-Best", "Mankind Pharma", "Tablet", "100 mg"),
                BrandInfo("Zyrik", "Zydus Healthcare", "Tablet", "100 mg / 300 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg/kg/day PO divided q8h (max 400 mg/day for malignancy)",
            adultDose = "100 mg to 300 mg PO daily (titrated up to 800 mg/day based on urate)",
            childDose = "10 mg/kg/day divided TID (max 400 mg/day) in pediatric oncology",
            contraindications = "Known hypersensitivity or previous severe cutaneous adverse reaction (SCAR) to allopurinol; HLA-B*58:01 positivity.",
            modeOfAction = "Purine structural analogue converted to oxypurinol, which inhibits xanthine oxidase, preventing uric acid synthesis.",
            interactions = "STRICTLY CONTRAINDICATED with Azathioprine and 6-Mercaptopurine: Reduces their catabolism, escalating toxicity 4-fold (if mandatory, reduce thiopurine dose by 75%). Increases Ampicillin/Amoxicillin rash incidence. Prolongs Warfarin half-life.",
            packSize = "Strip of 10 tablets"
        ),

        // d70: Mycophenolate Mofetil (MMF)
        Drug(
            id = "d70",
            genericName = "Mycophenolate Mofetil",
            system = "Renal & Genitourinary",
            drugClass = "Inosine Monophosphate Dehydrogenase (IMPDH) Inhibitor / Immunosuppressant",
            blackBoxWarning = "EMBRYO-FETAL TOXICITY, MALIGNANCY & SERIOUS INFECTIONS: Use during pregnancy is associated with increased risk of first-trimester pregnancy loss and congenital malformations (facial clefts, microotia). Increased susceptibility to opportunistic bacterial, viral (CMV, BK virus nephropathy), and fungal infections and lymphoma.",
            indications = "Prophylaxis of organ rejection in patients receiving allogeneic renal, hepatic, or cardiac transplants (with cyclosporine/tacrolimus and corticosteroids); Induction and maintenance therapy for Lupus Nephritis (ISN/RPS Class III, IV, and V per KDIGO / ACR guidelines); Refractory Autoimmune Hemolytic Anemia; Myasthenia Gravis; Inflammatory Myopathies.",
            doses = "Lupus Nephritis Induction: 1.0 g PO BID (total 2.0 g/day); may increase to 1.5 g PO BID (3.0 g/day) in high-risk patients for 6 months. Maintenance: 1.0 to 2.0 g/day in divided doses.\nRenal Transplantation: 1.0 g PO BID.\nHepatic / Cardiac Transplantation: 1.5 g PO BID.\nPediatrics: 600 mg/m² PO BID (max 2 g/day).",
            administration = "Oral on an empty stomach (1 hour before or 2 hours after meals). Swallow capsules/tablets whole; do not open or crush.",
            timing = "Every 12 hours (morning and evening).",
            specialInstructions = "STRICT CONTRACEPTION & REMS: Females of childbearing potential must use two reliable forms of contraception simultaneously before initiating, during, and for at least 6 weeks post-discontinuation. Monitor CBC with differential weekly during month 1, bi-weekly during months 2-3, then monthly. If severe neutropenia (ANC <1,300/mm³) occurs, interrupt or reduce dose.",
            pkPd = "Prodrug rapidly and extensively hydrolyzed to active metabolite mycophenolic acid (MPA). MPA is a potent, noncompetitive, reversible inhibitor of inosine monophosphate dehydrogenase (IMPDH), selectively blocking de novo guanosine nucleotide synthesis upon which T and B lymphocytes critically depend. Glucuronidated in liver to MPAG (inactive). Enterohepatic recirculation. Half-life ~18 hours.",
            renalAdj = "Chronic severe renal impairment (eGFR <25 mL/min outside transplant): Avoid doses >1 g BID and monitor closely.\nPost-transplant graft delayed function: No initial adjustment needed; observe CBC.",
            hepaticAdj = "No adjustment needed for hepatic parenchymal disease.",
            pregnancy = "Category D / High Teratogenic Risk: Contraindicated. Associated with microtia, auditory canal atresia, cleft lip/palate, and congenital heart anomalies.",
            lactation = "Breastfeeding is not recommended due to serious adverse effects in nursing infants.",
            sideEffects = "Diarrhea, nausea, vomiting, abdominal cramping, leukopenia / neutropenia, anemia, thrombocytopenia, opportunistic infections (CMV, Herpes zoster, BK virus), elevated liver enzymes.",
            priceNpr = "NPR 450.00 - 850.00 per strip of 10 tablets (500mg)",
            priceInr = "INR 280.00 - 550.00 per strip of 10 tablets (500mg)",
            brandsNepal = listOf(
                BrandInfo("CellCept", "Roche Nepal", "Tablet", "500 mg / 250 mg Cap"),
                BrandInfo("Mycept", "Panacea Biotec / Nepal Import", "Tablet", "500 mg / 250 mg"),
                BrandInfo("MMF-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("CellCept", "Roche Products India", "Tablet", "500 mg / 250 mg"),
                BrandInfo("Mycept", "Panacea Biotec Ltd.", "Tablet", "500 mg / 250 mg"),
                BrandInfo("Mofilet", "Sun Pharma", "Tablet", "500 mg"),
                BrandInfo("Myfortic", "Novartis India (Enteric Sodium)", "Tablet", "180 mg / 360 mg")
            ),
            pediatricDosePerKg = 30.0,
            pediatricInterval = "mg/kg/day divided BID (600 mg/m² BID, max 2g/day)",
            adultDose = "1.0 g to 1.5 g PO BID on empty stomach (Total 2-3 g/day)",
            childDose = "600 mg/m²/dose PO BID (max 1000 mg BID)",
            contraindications = "Hypersensitivity to mycophenolate mofetil or mycophenolic acid; pregnancy; breastfeeding; active severe gastrointestinal disease.",
            modeOfAction = "Selective non-competitive inhibitor of inosine monophosphate dehydrogenase (IMPDH), blocking lymphocyte purine synthesis.",
            interactions = "Antacids (aluminum and magnesium hydroxides) and Proton Pump Inhibitors decrease MPA absorption. Cholestyramine severely impairs enterohepatic recirculation. Co-administration with Ganciclovir increases levels of both drugs in renal impairment.",
            packSize = "Strip of 10 tablets"
        ),

        // d71: Azathioprine
        Drug(
            id = "d71",
            genericName = "Azathioprine",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Purine Antimetabolite / Thiopurine Immunosuppressant",
            blackBoxWarning = "MALIGNANCY & MUTAGENIC RISK: Chronic immunosuppression with azathioprine increases risk of malignancies, particularly lymphomas (including hepatosplenic T-cell lymphoma in IBD) and non-melanoma skin cancer. Severe leukopenia, thrombocytopenia, and bone marrow suppression.",
            indications = "Maintenance of remission in Inflammatory Bowel Disease (Ulcerative Colitis, Crohn's Disease); Systemic Lupus Erythematosus (SLE - maintenance of lupus nephritis); Autoimmune Hepatitis; Myasthenia Gravis; Severe Rheumatoid Arthritis; Prophylaxis of renal allograft rejection.",
            doses = "IBD / SLE / Autoimmune Hepatitis: 1.5 mg to 2.5 mg/kg PO once daily (or divided BID).\nRenal Allograft Rejection Prophylaxis: Initial 3 to 5 mg/kg/day PO or IV on day of transplant; maintenance 1 to 3 mg/kg/day.\nTPMT Guidance: If TPMT (thiopurine methyltransferase) intermediate metabolizer: Reduce dose by 50%; if TPMT deficient: AVOID use (extreme fatal pancytopenia risk).",
            administration = "Oral with or after meals to reduce nausea. Can be taken as a single daily dose or divided BID.",
            timing = "Regularly with food.",
            specialInstructions = "TPMT / NUDT15 SCREENING: Thiopurine S-methyltransferase (TPMT) and NUDT15 genetic screening is recommended prior to therapy. Monitor CBC weekly during month 1, bi-weekly during months 2-3, and monthly thereafter. Patients must report any sore throat, fever, or unexplained bruising immediately.",
            pkPd = "Prodrug non-enzymatically and enzymatically cleaved to 6-mercaptopurine (6-MP). 6-MP is converted by hypoxanthine-guanine phosphoribosyltransferase (HGPRT) to active thioguanine nucleotides (6-TGN), which incorporate into replicating DNA, arresting cell cycle. Catabolized by TPMT and xanthine oxidase. Half-life ~5 hours (tissue 6-TGN half-life 3-5 days).",
            renalAdj = "CrCl 10-50 mL/min: Administer 75% of normal dose.\nCrCl <10 mL/min: Administer 50% of normal dose.\nHemodialysis: Give 50% of normal dose post-dialysis.",
            hepaticAdj = "Use with caution and reduce dose; cleared extensively by hepatic enzymes.",
            pregnancy = "Category D: Crosses placenta. However, internationally accepted by gastroenterologists and rheumatologists as compatible for maintaining remission in high-risk IBD/SLE pregnancy where disease flare risks outweigh medication risks.",
            lactation = "Active metabolites present in breast milk in negligible amounts; considered compatible by specialist consensus with 4-hour delay post-dose.",
            sideEffects = "Bone marrow suppression (leukopenia, anemia, thrombocytopenia), pancreatitis (idiosyncratic, acute epigastric pain), hepatotoxicity / cholestasis, nausea, vomiting, opportunistic infections, skin cancer.",
            priceNpr = "NPR 130.00 - 260.00 per strip of 10 tablets (50mg)",
            priceInr = "INR 75.00 - 160.00 per strip of 10 tablets (50mg)",
            brandsNepal = listOf(
                BrandInfo("Imuran", "GlaxoSmithKline Nepal", "Tablet", "50 mg"),
                BrandInfo("Azoran", "RPG Life Sciences Nepal", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Azaprine", "Nepal Pharmaceuticals Lab", "Tablet", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Imuran", "GlaxoSmithKline Pharmaceuticals", "Tablet", "50 mg"),
                BrandInfo("Azoran", "RPG Life Sciences", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Thioprine", "Cipla Ltd.", "Tablet", "50 mg"),
                BrandInfo("Azapure", "Zydus Healthcare", "Tablet", "50 mg")
            ),
            pediatricDosePerKg = 2.0,
            pediatricInterval = "mg/kg/day PO (usual range 1-2.5 mg/kg/day)",
            adultDose = "1.5 to 2.5 mg/kg PO daily with food (target 100-150 mg/day)",
            childDose = "1 to 2.5 mg/kg PO daily with meals",
            contraindications = "Hypersensitivity to azathioprine; pregnancy (relative in non-IBD); known complete TPMT or NUDT15 deficiency.",
            modeOfAction = "Converted to 6-thioguanine nucleotides that incorporate into cellular DNA and RNA, arresting lymphocyte replication.",
            interactions = "FATAL COMBINATION: Allopurinol and Febuxostat block xanthine oxidase, diverting 6-MP into massive 6-TGN levels causing lethal pancytopenia. If allopurinol must be co-prescribed, REDUCE AZATHIOPRINE DOSE BY 75% (to 25% of standard) and monitor CBC weekly. Aminosalicylates (sulfasalazine/mesalamine) inhibit TPMT, increasing 6-TGN.",
            packSize = "Strip of 10 tablets"
        ),

        // d72: Tacrolimus
        Drug(
            id = "d72",
            genericName = "Tacrolimus",
            system = "Renal & Genitourinary",
            drugClass = "Macrolide Calcineurin Inhibitor (CNI) Immunosuppressant",
            blackBoxWarning = "MALIGNANCIES, SERIOUS INFECTIONS & MORTALITY: Increased susceptibility to opportunistic infections and development of lymphoma. Monitor whole blood trough concentrations; toxicity correlates with elevated trough levels.",
            indications = "Prophylaxis of organ rejection in kidney, liver, and heart allogeneic transplants (cornerstone maintenance immunosuppressant); Severe steroid-refractory Ulcerative Colitis; Refractory Myasthenia Gravis; Lupus Nephritis (multitarget therapy with MMF); Moderate-to-severe Atopic Dermatitis (topical ointment).",
            doses = "Oral Kidney Transplantation: Initial 0.10 to 0.20 mg/kg/day PO in 2 divided doses (q12h). Titrate to target whole blood trough: 8-12 ng/mL (months 1-3), then 5-8 ng/mL.\nLiver Transplantation: 0.10 to 0.15 mg/kg/day PO in 2 divided doses. Target trough: 6-10 ng/mL.\nMyasthenia Gravis / Lupus Nephritis: 2 mg to 4 mg PO daily in divided doses (target trough 4-8 ng/mL).\nTopical (Ointment): Apply 0.03% (pediatric ≥2 yrs) or 0.1% (adult) to affected skin BID.",
            administration = "Oral on an empty stomach (1 hour before or 2 hours after meals) at consistent 12-hour intervals. Do NOT drink grapefruit juice.",
            timing = "Strictly q12h (e.g., 8:00 AM and 8:00 PM).",
            specialInstructions = "THERAPEUTIC DRUG MONITORING (TDM) MANDATORY: Measure whole blood 12-hour trough level (C0) using EDTA purple-top tube drawn immediately before the morning dose. Trough levels >15-20 ng/mL produce severe nephrotoxicity and neurotoxicity. Monitor blood glucose, serum potassium, magnesium, and blood pressure.",
            pkPd = "Binds to intracellular immunophilin FKBP-12, forming a complex that competitively inhibits calcineurin phosphatase. This prevents dephosphorylation and nuclear translocation of NF-AT, blocking IL-2 transcription and T-lymphocyte activation. Variable oral bioavailability (15-25%). Extensively metabolized by CYP3A4 and P-glycoprotein. Elimination half-life ~12-15 hours.",
            renalAdj = "Tacrolimus is inherently nephrotoxic (afferent arteriolar vasoconstriction). In acute kidney injury or chronic renal impairment, use lowest effective dose targeting lower trough levels (4-6 ng/mL).",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh C): Reduce starting dose by 50% or more due to impaired CYP3A4 clearance.",
            pregnancy = "Category C: Crosses placenta. Associated with maternal hypertension, gestational diabetes, and transient neonatal hyperkalemia/renal dysfunction. Use when transplant maintenance is vital.",
            lactation = "Excreted in low levels in breast milk; considered acceptable with infant monitoring.",
            sideEffects = "Nephrotoxicity (elevated creatinine, oliguria), tremors, headache, hypertension, new-onset diabetes after transplantation (NODAT / post-transplant diabetes), hyperkalemia, hypomagnesemia, alopecia, peripheral edema.",
            priceNpr = "NPR 350.00 - 750.00 per strip of 10 capsules (0.5mg / 1mg / 2mg)",
            priceInr = "INR 200.00 - 450.00 per strip of 10 capsules (0.5mg / 1mg / 2mg)",
            brandsNepal = listOf(
                BrandInfo("Pangraf", "Panacea Biotec / Nepal Import", "Capsule", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Tacrol", "Nepal Pharmaceuticals Lab", "Capsule", "0.5 mg / 1 mg"),
                BrandInfo("Prograf", "Astellas / Nepal Specialized", "Capsule", "0.5 mg / 1 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pangraf", "Panacea Biotec Ltd.", "Capsule", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Prograf", "Astellas Pharma India", "Capsule / Inj", "0.5 mg / 1 mg / 5 mg"),
                BrandInfo("Tacromus", "Zydus Healthcare", "Capsule", "0.5 mg / 1 mg"),
                BrandInfo("Tacrograf", "Biocon Ltd.", "Capsule", "0.5 mg / 1 mg")
            ),
            pediatricDosePerKg = 0.15,
            pediatricInterval = "mg/kg/day PO divided q12h (titrated to blood trough level)",
            adultDose = "0.10 to 0.20 mg/kg/day PO divided q12h on empty stomach (TDM guided)",
            childDose = "0.15 to 0.20 mg/kg/day PO divided q12h (children require higher mg/kg)",
            contraindications = "Hypersensitivity to tacrolimus or polyoxyl 60 hydrogenated castor oil (in IV formulation).",
            modeOfAction = "Complexes with FKBP-12 to inhibit calcineurin phosphatase, suppressing interleukin-2 (IL-2) gene transcription in T-lymphocytes.",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole, Voriconazole, Clarithromycin, Diltiazem, Grapefruit juice) drastically escalate tacrolimus levels causing acute renal failure (requires 50-75% dose reduction). CYP3A4 inducers (Rifampicin, Carbamazepine, St. John's wort) plummet levels triggering acute graft rejection. Synergistic nephrotoxicity with NSAIDs and Aminoglycosides.",
            packSize = "Strip of 10 capsules"
        ),

        // d73: Mesalamine (Mesalazine / 5-ASA)
        Drug(
            id = "d73",
            genericName = "Mesalamine (Mesalazine / 5-ASA)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Locally-Acting 5-Aminosalicylate (5-ASA) Anti-Inflammatory",
            blackBoxWarning = null,
            indications = "Induction and maintenance of clinical and endoscopic remission in Ulcerative Colitis (mild to moderate); Proctitis and Proctosigmoiditis (suppository/enema formulations); Crohn's ileocolitis (mild).",
            doses = "Ulcerative Colitis (Oral): Induction: 2.4 g to 4.8 g PO daily in divided doses (e.g. 1.2 g TID or 2.4 g BID; MMX formulation: 2.4 g - 4.8 g once daily with meals). Maintenance: 1.6 g to 2.4 g PO daily.\nUlcerative Proctitis (Rectal Suppository): 1.0 g PR once daily at bedtime.\nDistal Colitis (Rectal Enema): 4.0 g / 60 mL PR once daily at bedtime, retained for at least 8 hours.",
            administration = "Oral tablets should be swallowed whole with meals; do not chew or crush. Rectal suppository/enema administered at bedtime after bowel evacuation.",
            timing = "Regularly with meals; single daily dosing available with MMX multi-matrix tablets.",
            specialInstructions = "MUCOSAL TOPICAL ACTION: Mesalamine exerts its therapeutic effect by direct mucosal contact, not systemic absorption. Formulations have specific release profiles (e.g. delayed-release pH >6.0 vs MMX colon-targeted). Check baseline serum creatinine and periodically thereafter (rare idiosyncratic interstitial nephritis). Intact tablet cores may rarely appear in stool.",
            pkPd = "Topically inhibits cyclooxygenase and lipoxygenase enzymes, reducing synthesis of inflammatory prostaglandins (PGE2) and leukotrienes (LTB4) in colonic mucosa; scavenges free radicals and inhibits NF-kappaB. Systemic absorption is low (20-30%). Metabolized in intestinal wall and liver to N-acetyl-5-ASA. Eliminated renally.",
            renalAdj = "CrCl 30-50 mL/min: Use with caution; monitor renal function.\nCrCl <30 mL/min: Not recommended due to risk of nephrotoxicity.",
            hepaticAdj = "Use caution in severe hepatic impairment.",
            pregnancy = "Category B: Safe and widely used to maintain remission throughout pregnancy.",
            lactation = "Excreted in low levels in breast milk; compatible (monitor infant for loose stools/diarrhea).",
            sideEffects = "Headache, nausea, abdominal pain, flatulence, diarrhea, rash, acute intolerance syndrome (cramping, bloody diarrhea resembling colitis flare - discontinue immediately), rare interstitial nephritis, pancreatitis.",
            priceNpr = "NPR 180.00 - 360.00 per strip of 10 tablets (800mg / 1200mg)",
            priceInr = "INR 110.00 - 240.00 per strip of 10 tablets (800mg / 1200mg)",
            brandsNepal = listOf(
                BrandInfo("Mesacol", "Sun Pharma Nepal", "Delayed Release Tab", "400 mg / 800 mg / 1200 mg"),
                BrandInfo("Asacol", "Tillotts / Nepal Import", "Enteric-coated Tab", "400 mg / 800 mg"),
                BrandInfo("Salofalk", "Dr. Falk / Nepal Specialist", "Granules / Tab / Supp", "500 mg / 1000 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Mesacol", "Sun Pharmaceutical Industries", "Tab / Suppository", "400 mg / 800 mg / 1.2 g MMX"),
                BrandInfo("Asacol", "Zydus Healthcare", "Tablet", "400 mg / 800 mg"),
                BrandInfo("Pentasa", "Ferring Pharmaceuticals", "Extended Release Tab", "500 mg / 1 g"),
                BrandInfo("Mesalo", "Cipla Ltd.", "Tablet", "500 mg / 1 g")
            ),
            pediatricDosePerKg = 40.0,
            pediatricInterval = "mg/kg/day PO divided BID-TID (max 2.4-4.8 g/day)",
            adultDose = "Induction: 2.4g - 4.8g daily; Maintenance: 1.6g - 2.4g daily with meals",
            childDose = "30-60 mg/kg/day divided BID-TID (max 4.8 g/day)",
            contraindications = "Hypersensitivity to salicylates or aminosalicylates; severe renal impairment (CrCl <30 mL/min).",
            modeOfAction = "Locally inhibits mucosal production of arachidonic acid metabolites (LTB4, 5-HETE), PAF, and suppresses NF-kappaB activation.",
            interactions = "Co-administration with NSAIDs increases nephrotoxicity. May increase bone marrow suppressive effects of Azathioprine and 6-Mercaptopurine (inhibits TPMT enzyme).",
            packSize = "Strip of 10 tablets or pack of 5 suppositories"
        ),

        // d74: Levetiracetam
        Drug(
            id = "d74",
            genericName = "Levetiracetam",
            system = "Central Nervous System (CNS)",
            drugClass = "Second-Generation Broad-Spectrum Antiepileptic (SV2A Ligand)",
            blackBoxWarning = null,
            indications = "Monotherapy and adjunctive therapy for Focal (Partial-Onset) Seizures with or without secondary generalization; Generalized Tonic-Clonic Seizures; Myoclonic Seizures (Juvenile Myoclonic Epilepsy - JME); Second-line status epilepticus (IV formulation per ESETT trial).",
            doses = "Adults & Adolescents (≥16 yrs): Initial 500 mg PO or IV BID (1,000 mg/day). Increase by 1,000 mg/day every 2 weeks to target 1,000 to 1,500 mg PO BID (2,000-3,000 mg/day).\nStatus Epilepticus: 60 mg/kg IV (max 4,500 mg) infused over 10-15 minutes.\nPediatrics (1 month to <16 yrs): Initial 10 mg/kg PO BID (20 mg/kg/day); titrate by 10 mg/kg/day every 2 weeks to 30 mg/kg PO BID (60 mg/kg/day).",
            administration = "Oral with or without food. IV formulation administered as an infusion over 15 minutes diluted in 100 mL Normal Saline or D5W.",
            timing = "Every 12 hours regularly spaced.",
            specialInstructions = "MINIMAL DRUG INTERACTIONS & MOOD CHANGES: Levetiracetam does not induce or inhibit hepatic CYP450 enzymes, making it ideal for polypharmacy, elderly, and ICU patients. Warn patients and caregivers regarding behavioral/psychiatric side effects: irritability, agitation, depression, aggression, or suicidal ideation.",
            pkPd = "Selectively binds to synaptic vesicle protein SV2A in presynaptic terminals, inhibiting presynaptic vesicle exocytosis and reducing neurotransmitter release during high-frequency epileptiform activity. Rapid and complete oral absorption (>95%). Low plasma protein binding (<10%). Renally excreted (66% unchanged, 24% inactive enzymatic metabolite). Terminal half-life 6-8 hours.",
            renalAdj = "CrCl 50-80 mL/min: 500 to 1,000 mg PO q12h.\nCrCl 30-49 mL/min: 250 to 750 mg PO q12h.\nCrCl <30 mL/min: 250 to 500 mg PO q12h.\nEnd-Stage Renal Disease on Hemodialysis: 500 to 1,000 mg once daily (administer 250-500 mg supplemental dose post-dialysis).",
            hepaticAdj = "No adjustment needed for mild to moderate hepatic impairment. In severe cirrhosis with CrCl <60 mL/min, reduce maintenance dose by 50%.",
            pregnancy = "Category C (Preferred in Pregnancy): Favorable safety profile with very low major congenital malformation rates compared to valproate. Plasma levels decline during 2nd and 3rd trimesters; monitor clinical symptoms and adjust dose.",
            lactation = "Excreted in breast milk in significant amounts; compatible with monitoring infant for sedation and poor feeding.",
            sideEffects = "Somnolence, dizziness, fatigue, irritability, behavioral changes (aggression, depression, psychosis), nasopharyngitis, ataxia, rare thrombocytopenia.",
            priceNpr = "NPR 110.00 - 240.00 per strip of 10 tablets (500mg / 750mg / 1000mg)",
            priceInr = "INR 65.00 - 150.00 per strip of 10 tablets (500mg / 750mg / 1000mg)",
            brandsNepal = listOf(
                BrandInfo("Levipil", "Sun Pharma Nepal", "Tablet / Syrup / Inj", "250 mg / 500 mg / 750 mg / 1000 mg"),
                BrandInfo("Levesam", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg / 750 mg"),
                BrandInfo("Epilive", "Asian Pharmaceuticals", "Tablet", "500 mg / 750 mg"),
                BrandInfo("Keppra", "UCB / Nepal Specialized", "Tablet / Inj", "500 mg / 1000 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Levipil", "Sun Pharmaceutical Industries", "Tab / Inj / Syrup", "250 mg / 500 mg / 750 mg / 1 g"),
                BrandInfo("Keppra", "Dr. Reddy's / UCB", "Tablet / Inj", "250 mg / 500 mg / 1 g"),
                BrandInfo("Levepsy", "Cipla Ltd.", "Tablet / Inj", "250 mg / 500 mg / 750 mg / 1 g"),
                BrandInfo("Torleva", "Torrent Pharmaceuticals", "Tablet", "500 mg / 750 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "mg/kg/day PO divided BID (titrated up to 60 mg/kg/day)",
            adultDose = "500 mg to 1,500 mg PO BID (1,000 - 3,000 mg/day)",
            childDose = "Initial 20 mg/kg/day divided BID; titrate to 40-60 mg/kg/day",
            contraindications = "Hypersensitivity to levetiracetam or pyrrolidone derivatives.",
            modeOfAction = "Stereoselective binding to synaptic vesicle protein 2A (SV2A) in the brain, inhibiting vesicular presynaptic exocytosis.",
            interactions = "No clinically significant CYP450 drug interactions. Clearance may be slightly increased by enzyme-inducing antiepileptics (Carbamazepine, Phenytoin).",
            packSize = "Strip of 10 tablets or 100 mL bottle"
        ),

        // d75: Sodium Valproate / Divalproex Sodium
        Drug(
            id = "d75",
            genericName = "Sodium Valproate / Divalproex",
            system = "Central Nervous System (CNS)",
            drugClass = "Broad-Spectrum Antiepileptic & Mood Stabilizer",
            blackBoxWarning = "FATAL HEPATOTOXICITY, PANCREATITIS & TERATOGENICITY: Fatal hepatic failure has occurred, usually in children under 2 years with mitochondrial disorders (POLG mutation). Life-threatening hemorrhagic pancreatitis. Major congenital malformations (neural tube defects / spina bifida in 1-2%) and impaired cognitive development (10-point drop in child IQ) if taken during pregnancy.",
            indications = "Broad-spectrum coverage for Generalized Tonic-Clonic Seizures, Absence Seizures, Myoclonic Seizures (first-line in males for JME), Focal Seizures, Status Epilepticus (second-line IV); Acute Manic Episodes of Bipolar Disorder; Migraine Headache Prophylaxis.",
            doses = "Epilepsy (Adults): Initial 500 mg PO daily in divided doses (or single daily dose with Chrono/CR). Titrate by 250-500 mg every 3-7 days to therapeutic level (usual 1,000 - 2,000 mg/day; max 60 mg/kg/day).\nTarget Therapeutic Serum Level: 50 to 100 mcg/mL.\nBipolar Mania: Initial 750 mg PO daily in divided doses; titrate rapidly to therapeutic serum level.\nMigraine Prophylaxis: 500 mg PO once daily (or 250 mg BID).\nPediatrics: 15-20 mg/kg/day PO divided BID-TID; titrate to 20-40 mg/kg/day.",
            administration = "Oral with or immediately after food to prevent gastric irritation. Swallow Chrono / CR controlled-release tablets whole; do not crush or chew.",
            timing = "Divided BID or once daily with controlled-release formulations.",
            specialInstructions = "STRICT PREGNANCY CONTRAINDICATION IN WOMEN OF CHILDBEARING AGE: Never prescribe valproate to female patients of childbearing potential unless all other antiepileptic treatments have failed and strict pregnancy prevention measures are in place. Monitor baseline LFTs, CBC, and serum ammonia (hyperammonemic encephalopathy can occur with normal LFTs). Carnitine is the antidote for valproate toxicity.",
            pkPd = "Increases brain concentrations of inhibitory neurotransmitter gamma-aminobutyric acid (GABA) by inhibiting GABA transaminase and succinic semialdehyde dehydrogenase; prolongs recovery of voltage-gated sodium channels and inhibits T-type calcium currents. Extensive hepatic metabolism via glucuronidation and beta-oxidation. Highly protein bound (90%). Half-life 9-16 hours.",
            renalAdj = "Protein binding is reduced in renal failure (higher free unbound fraction); evaluate free valproic acid levels rather than total levels.",
            hepaticAdj = "CONTRAINDICATED in active hepatic disease, significant hepatic dysfunction, or family history of fatal hepatic dysfunction.",
            pregnancy = "Category X / Absolute Avoidance: High incidence of neural tube defects (spina bifida), craniofacial defects, cardiovascular anomalies, and severe autism spectrum/IQ reduction.",
            lactation = "Excreted in low levels in breast milk; considered compatible by AAP with infant monitoring for thrombocytopenia and liver function.",
            sideEffects = "Weight gain, tremor, hair thinning/alopecia, nausea, hyperammonemia (confusion without elevated transaminases), thrombocytopenia, elevated transaminases, pancreatitis, menstrual irregularities/polycystic ovarian morphology.",
            priceNpr = "NPR 90.00 - 210.00 per strip of 10 tablets (200mg / 300mg / 500mg CR)",
            priceInr = "INR 50.00 - 140.00 per strip of 10 tablets (200mg / 300mg / 500mg CR)",
            brandsNepal = listOf(
                BrandInfo("Encorate Chrono", "Sun Pharma Nepal", "Controlled Release Tab", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Epival", "Abbott Nepal", "Enteric-coated Tab", "250 mg / 500 mg"),
                BrandInfo("Valparin Chrono", "Sanofi Nepal", "Controlled Release Tab", "300 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Encorate Chrono", "Sun Pharmaceutical Industries", "CR Tab / Syrup / Inj", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Depakote", "Sanofi India", "Extended Release Tab", "250 mg / 500 mg"),
                BrandInfo("Valparin Chrono", "Sanofi India", "CR Tab / Syrup", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Epitec", "Cipla Ltd.", "Tablet", "200 mg / 500 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "mg/kg/day PO divided BID-TID (titrate to 20-40 mg/kg/day)",
            adultDose = "500 mg to 1,500 mg/day PO in divided doses or CR OD (TDM 50-100 mcg/mL)",
            childDose = "15-20 mg/kg/day divided BID-TID; titrate up to 40 mg/kg/day",
            contraindications = "Pregnancy in females of childbearing potential; hepatic disease or severe liver dysfunction; known mitochondrial disorders caused by mutations in nuclear gene encoding mitochondrial DNA polymerase gamma (POLG); urea cycle disorders.",
            modeOfAction = "Potentiates GABAergic inhibitory neurotransmission, blocks voltage-sensitive sodium channels, and inhibits T-type calcium channels.",
            interactions = "STRICTLY CONTRAINDICATED with Carbapenem Antibiotics (Meropenem, Imipenem): Plummets serum valproate by 60-90% within 24 hours, triggering breakthrough status epilepticus. Inhibits Lamotrigine glucuronidation (doubles lamotrigine half-life, drastically increasing Stevens-Johnson syndrome risk; reduce lamotrigine by 50%). Inhibits Phenobarbital metabolism.",
            packSize = "Strip of 10 tablets"
        ),

        // d76: Dapagliflozin
        Drug(
            id = "d76",
            genericName = "Dapagliflozin",
            system = "Endocrine & Metabolic System",
            drugClass = "Sodium-Glucose Cotransporter 2 (SGLT2) Inhibitor",
            blackBoxWarning = null,
            indications = "Type 2 Diabetes Mellitus (glycemic control); Heart Failure with Reduced Ejection Fraction (HFrEF - NYHA II-IV, per DAPA-HF trial) to reduce risk of cardiovascular death and hospitalization; Heart Failure with Preserved Ejection Fraction (HFpEF per DELIVER trial); Chronic Kidney Disease (CKD per DAPA-CKD trial) to reduce risk of sustained eGFR decline, end-stage kidney disease, and CV death.",
            doses = "Standard Dose (Type 2 Diabetes, Heart Failure, Chronic Kidney Disease): 10 mg PO once daily in the morning.\nInitial dose in mild volume depletion: 5 mg PO once daily.",
            administration = "Oral once daily in the morning, with or without food.",
            timing = "Morning with a glass of water.",
            specialInstructions = "EUGLYCEMIC DKA & HYDRATION: Patients should maintain good hydration and genital hygiene. Withhold 3 days prior to major surgery or acute severe illness to prevent Euglycemic Diabetic Ketoacidosis (euDKA - ketoacidosis occurring with normal or near-normal blood glucose <250 mg/dL). If acute volume depletion or sepsis occurs, suspend temporarily.",
            pkPd = "Competitively inhibits SGLT2 transporters in the S1 segment of the proximal renal tubule, reducing renal glucose and sodium reabsorption, promoting glucosuria (eliminating 60-80g glucose/day ~280-320 kcal) and osmotic natriuresis. Reduces intraglomerular pressure, halting CKD progression. Extensively metabolized by UGT1A9 to inactive glucuronide. Terminal half-life ~13 hours.",
            renalAdj = "Heart Failure & CKD (Cardiorenal Protection): Initiated and continued down to eGFR ≥25 mL/min (10 mg once daily).\nGlycemic Control in T2DM: Not recommended for glucose lowering if eGFR <45 mL/min (glucosuric efficacy is blunted, though cardiorenal benefits persist down to eGFR 25 mL/min).\neGFR <25 mL/min: Initiation not recommended, but may be continued until dialysis.",
            hepaticAdj = "No adjustment needed for mild to moderate hepatic impairment. In severe hepatic impairment (Child-Pugh C), starting dose of 5 mg is recommended.",
            pregnancy = "Category D / Avoid in 2nd and 3rd trimesters: Potential risk for adverse renal development in the fetus.",
            lactation = "Breastfeeding is not recommended due to potential risk for developing human kidney.",
            sideEffects = "Genital mycotic infections (candidal vulvovaginitis, balanitis), urinary tract infections, volume depletion / orthostatic hypotension, polyuria, euglycemic diabetic ketoacidosis, rare Fournier's gangrene (necrotizing fasciitis of perineum).",
            priceNpr = "NPR 140.00 - 280.00 per strip of 10 tablets (10mg)",
            priceInr = "INR 80.00 - 180.00 per strip of 10 tablets (10mg)",
            brandsNepal = listOf(
                BrandInfo("Forxiga", "AstraZeneca Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Oxra", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapaone", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg"),
                BrandInfo("Dapaglyn", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Forxiga", "AstraZeneca India", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Oxra", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapavel", "Cipla Ltd.", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Justoza", "Torrent Pharmaceuticals", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapa-M", "Mankind Pharma", "Tablet", "10 mg")
            ),
            adultDose = "10 mg PO once daily morning with or without food",
            contraindications = "Dialysis or end-stage renal disease; history of serious hypersensitivity reaction to dapagliflozin.",
            modeOfAction = "Inhibits SGLT2 cotransporter in proximal renal tubules, inducing glucosuria, natriuresis, and decreasing glomerular hyperfiltration.",
            interactions = "Co-administration with Insulin and Insulin Secretagogues (Sulfonylureas) increases hypoglycemia risk (consider lowering insulin/glimepiride dose). Increases diuretic effect of loop diuretics (Furosemide).",
            packSize = "Strip of 10 or 14 tablets"
        ),

        // d77: Sacubitril + Valsartan (ARNI)
        Drug(
            id = "d77",
            genericName = "Sacubitril + Valsartan",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin Receptor-Neprilysin Inhibitor (ARNI)",
            blackBoxWarning = "FETAL TOXICITY: Drugs that act directly on the renin-angiotensin system can cause injury and death to the developing fetus (oligohydramnios, skull hypoplasia, fetal renal failure). Discontinue immediately as soon as pregnancy is detected.",
            indications = "Heart Failure with Reduced Ejection Fraction (HFrEF - NYHA Class II-IV, LVEF ≤40% per PARADIGM-HF trial) to reduce risk of cardiovascular death and hospitalization (first-line foundational GDMT therapy); Heart Failure with Preserved Ejection Fraction (HFpEF per PARAGON-HF trial); Pediatric Heart Failure (≥1 yr).",
            doses = "Adult HFrEF: Target Maintenance Dose: 97/103 mg (often labeled 200 mg) PO BID.\nPatients switching from ACE Inhibitor: MUST OBSERVE A STRICT 36-HOUR WASHOUT PERIOD after last ACEi dose before initiating ARNI.\nStarting Dose (previously on standard ACEi/ARB): 49/51 mg (labeled 100 mg) PO BID. Double dose every 2-4 weeks to target 97/103 mg PO BID as tolerated.\nStarting Dose (ACEi naive, low-dose ACEi, or eGFR <30 mL/min, or SBP 100-110 mmHg): 24/26 mg (labeled 50 mg) PO BID.",
            administration = "Oral twice daily, with or without food.",
            timing = "Morning and evening (q12h).",
            specialInstructions = "MANDATORY 36-HOUR WASHOUT FROM ACE INHIBITORS: Never administer concomitantly with an ACE inhibitor. Co-administration dramatically increases the risk of life-threatening angioedema. Monitor baseline BP, serum potassium, and renal function. Note that BNP levels will be artificially elevated due to neprilysin inhibition; use NT-proBNP instead to monitor clinical heart failure status.",
            pkPd = "Sacubitril is a prodrug rapidly hydrolyzed to active neprilysin inhibitor LBQ657, which inhibits neprilysin degradation of natriuretic peptides (ANP, BNP, CNP, bradykinin), promoting vasodilation, natriuresis, and reversing cardiac remodeling. Valsartan selectively blocks AT1 angiotensin II receptors, inhibiting aldosterone and vasoconstriction without causing cough. Terminal half-life ~11-15 hours.",
            renalAdj = "eGFR ≥30 mL/min: Standard starting dose (49/51 mg BID).\neGFR <30 mL/min: Starting dose 24/26 mg PO BID; titrate cautiously to target.",
            hepaticAdj = "Mild impairment (Child-Pugh A): No adjustment needed.\nModerate impairment (Child-Pugh B): Starting dose 24/26 mg PO BID.\nSevere impairment (Child-Pugh C): Not recommended.",
            pregnancy = "Category D / Absolute Contraindication: Renin-angiotensin blockade produces fatal oligohydramnios and fetal death.",
            lactation = "Breastfeeding is not recommended due to risk of serious adverse effects in the infant.",
            sideEffects = "Hypotension (most common, especially with loop diuretics), hyperkalemia, elevated serum creatinine / worsening renal function, angioedema (more frequent in Black patients), cough, dizziness.",
            priceNpr = "NPR 450.00 - 890.00 per strip of 14 tablets (50mg / 100mg / 200mg)",
            priceInr = "INR 280.00 - 580.00 per strip of 14 tablets (50mg / 100mg / 200mg)",
            brandsNepal = listOf(
                BrandInfo("Vymada", "Novartis Nepal", "Film-coated Tab", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Cidmus", "Lupin Nepal", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Azmarda", "Cipla Nepal", "Tablet", "50 mg / 100 mg / 200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Entresto", "Novartis India", "Tablet", "50 mg (24/26) / 100 mg (49/51) / 200 mg (97/103)"),
                BrandInfo("Vymada", "Novartis India", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Cidmus", "Lupin Ltd.", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Azmarda", "Cipla Ltd.", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Valazest", "Sun Pharma", "Tablet", "50 mg / 100 mg / 200 mg")
            ),
            adultDose = "Initial 49/51 mg BID; titrate every 2-4 wks to target 97/103 mg (200mg) PO BID",
            contraindications = "Concomitant use with ACE inhibitors (mandatory 36h washout); history of angioedema related to previous ACEi/ARB therapy; pregnancy; concurrent Aliskiren in diabetics.",
            modeOfAction = "Dual action: Neprilysin inhibition augments natriuretic peptides, while AT1 receptor antagonism suppresses the RAAS axis.",
            interactions = "STRICTLY CONTRAINDICATED with ACE inhibitors (Enalapril, Ramipril) - 36h gap required. Potassium-sparing diuretics (Spironolactone) and potassium supplements increase hyperkalemia risk. NSAIDs diminish antihypertensive and cardioprotective efficacy and worsen renal function.",
            packSize = "Strip of 14 tablets"
        ),

        // d78: Apixaban
        Drug(
            id = "d78",
            genericName = "Apixaban",
            system = "Cardiovascular System (CVS)",
            drugClass = "Direct Oral Anticoagulant (DOAC) / Direct Factor Xa Inhibitor",
            blackBoxWarning = "PREMATURE DISCONTINUATION INCREASES RISK OF THROMBOTIC EVENTS & SPINAL/EPIDURAL HEMATOMA: Premature discontinuation of any oral anticoagulant in non-valvular AFib increases risk of stroke. When neuraxial anesthesia or spinal puncture is employed, patients are at risk of developing epidural or spinal hematoma causing long-term or permanent paralysis.",
            indications = "Prevention of Stroke and Systemic Embolism in Non-Valvular Atrial Fibrillation (NVAF); Treatment of Deep Vein Thrombosis (DVT) and Pulmonary Embolism (PE); Reduction in risk of recurrent DVT and PE; Prophylaxis of DVT following elective hip or knee replacement surgery.",
            doses = "Non-Valvular AFib: Standard Dose: 5 mg PO BID.\nReduced Dose (2.5 mg PO BID): Indicated if patient has AT LEAST TWO of the following criteria: Age ≥80 years, Body weight ≤60 kg, Serum Creatinine ≥1.5 mg/dL (133 mcmol/L).\nDVT / PE Acute Treatment: 10 mg PO BID for the first 7 days, followed by 5 mg PO BID for at least 3-6 months.\nRecurrent DVT/PE Prevention: 2.5 mg PO BID after at least 6 months of initial treatment.",
            administration = "Oral twice daily, with or without food. Tablets may be crushed and suspended in water, D5W, or apple juice/puree.",
            timing = "Regularly spaced every 12 hours (morning and evening).",
            specialInstructions = "NO ROUTINE INR MONITORING REQUIRED: Unlike warfarin, routine coagulation monitoring is unnecessary. Superior safety profile with significantly lower risk of intracranial hemorrhage and fatal bleeding compared to warfarin (ARISTOTLE trial). Reversal agent is Andexanet alfa; 4-Factor Prothrombin Complex Concentrate (4F-PCC) 50 units/kg used if unavailable.",
            pkPd = "Direct, selective, and reversible inhibitor of free and clot-bound Factor Xa and prothrombinase activity, interrupting the intrinsic and extrinsic coagulation cascades. Bioavailability ~50%. Eliminated via multiple pathways: ~27% renal excretion, remainder fecal/biliary and CYP3A4 metabolism. Half-life ~12 hours.",
            renalAdj = "Non-Valvular AFib: 2.5 mg BID if Serum Creatinine ≥1.5 mg/dL AND (Age ≥80 OR Weight ≤60 kg). In ESRD on hemodialysis: 5 mg BID (2.5 mg BID if age ≥80 or weight ≤60 kg).\nDVT/PE Treatment: No dose reduction recommended solely based on CrCl; use with caution if CrCl <15 mL/min.",
            hepaticAdj = "Mild impairment (Child-Pugh A): No adjustment.\nModerate impairment (Child-Pugh B): Use with caution.\nSevere impairment (Child-Pugh C): CONTRAINDICATED (due to intrinsic coagulopathy).",
            pregnancy = "Category B / Not Recommended: DOACs cross placenta; Low-Molecular-Weight Heparin (Enoxaparin) is preferred in pregnancy.",
            lactation = "Breastfeeding is not recommended.",
            sideEffects = "Hemorrhage (epistaxis, hematuria, GI bleeding, hematoma), anemia, elevated liver transaminases, nausea.",
            priceNpr = "NPR 320.00 - 650.00 per strip of 10 tablets (2.5mg / 5mg)",
            priceInr = "INR 180.00 - 390.00 per strip of 10 tablets (2.5mg / 5mg)",
            brandsNepal = listOf(
                BrandInfo("Eliquis", "Pfizer Nepal", "Film-coated Tab", "2.5 mg / 5 mg"),
                BrandInfo("Apigat", "Natco / Medisales Nepal", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("AbFlo", "Lupin Nepal", "Tablet", "2.5 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Eliquis", "Pfizer India", "Film-coated Tab", "2.5 mg / 5 mg"),
                BrandInfo("Apigat", "Natco Pharma", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Afadx", "Sun Pharma", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Apixa", "Torrent Pharmaceuticals", "Tablet", "2.5 mg / 5 mg")
            ),
            adultDose = "AFib: 5 mg PO BID (2.5 mg BID if 2 of: age≥80, wt≤60kg, Cr≥1.5); DVT: 10 mg BID x 7d then 5 mg BID",
            contraindications = "Active pathological bleeding; severe hepatic disease with coagulopathy; mechanical prosthetic heart valves; antiphospholipid syndrome with triple positivity.",
            modeOfAction = "Selectively and reversibly inhibits free and clot-bound Factor Xa, suppressing thrombin generation.",
            interactions = "Strong dual inhibitors of CYP3A4 and P-glycoprotein (Ketoconazole, Itraconazole, Ritonavir) double apixaban exposure (reduce dose by 50% or avoid). Strong dual inducers (Rifampicin, Carbamazepine, Phenytoin) decrease levels by 50% (avoid combination). Co-administration with NSAIDs, Aspirin, or SSRIs increases bleeding risk.",
            packSize = "Strip of 10 or 14 tablets"
        ),

        // d79: Tranexamic Acid (TXA)
        Drug(
            id = "d79",
            genericName = "Tranexamic Acid (TXA)",
            system = "Emergency & Critical Care",
            drugClass = "Synthetic Lysine Analogue Antifibrinolytic Hemostatic Agent",
            blackBoxWarning = null,
            indications = "Severe Trauma Hemorrhage (CRASH-2 trial: administered within 3 hours of injury); Post-Partum Hemorrhage (PPH per WHO / WOMAN trial); Major Surgical Bleeding (orthopedic, cardiac); Heavy Menstrual Bleeding (menorrhagia); Dental extraction in hemophilia; Recurrent epistaxis; Hereditary angioedema.",
            doses = "Trauma Hemorrhage (CRASH-2): 1.0 g IV over 10 minutes (loading dose within 3h of trauma), followed by 1.0 g continuous IV infusion over 8 hours.\nPostpartum Hemorrhage (WOMAN trial): 1.0 g IV over 10 minutes given as soon as PPH is diagnosed (within 3h of birth). If bleeding continues after 30 min, a second 1.0 g dose may be given.\nHeavy Menstrual Bleeding (Oral): 1,300 mg (two 650 mg or 500 mg tablets) PO TID with meals during heavy flow days (max 3,900 mg/day for up to 5 days per cycle).\nTooth Extraction / Epistaxis: 10 mL of 5% solution (or 500 mg crushed in saline) used as mouthwash/swab for local hemostasis.",
            administration = "Slow IV injection/infusion (not exceeding 100 mg/min; rapid IV push can cause profound hypotension). Oral tablets swallowed whole with water.",
            timing = "Immediately at onset of hemorrhage (CRASH-2: MUST be given within 3 hours of trauma; effectiveness drops significantly and mortality may increase if given after 3 hours).",
            specialInstructions = "GIVE EARLY IN TRAUMA & PPH: Evidence proves greatest mortality reduction when administered within 1-3 hours of bleeding onset. Adjust dose carefully in renal impairment. Do not administer into neuraxial space (neurotoxic, causes intractable seizures). Contraindicated in active subarachnoid hemorrhage or upper urinary tract hematuria (ureteral clot colic).",
            pkPd = "Synthetic lysine analogue that competitively binds to the lysine-binding sites of plasminogen and plasmin, preventing plasminogen from binding to fibrin. This halts fibrin degradation and stabilizes blood clots. Oral bioavailability ~35-50%. Rapid distribution into tissues. Excreted >95% unchanged in urine by glomerular filtration. Terminal half-life ~2-3 hours.",
            renalAdj = "Serum Creatinine 1.4-2.8 mg/dL: Give 10 mg/kg IV q12h (or 15 mg/kg PO BID).\nSerum Creatinine 2.8-5.7 mg/dL: Give 10 mg/kg IV q24h (or 15 mg/kg PO once daily).\nSerum Creatinine >5.7 mg/dL: Give 5 mg/kg IV q24h (or 10 mg/kg PO every 48h).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B: Safely and life-savingly used in obstetric post-partum hemorrhage (PPH) per WHO recommendations.",
            lactation = "Present in breast milk in negligible amounts (~1%); considered safe during nursing.",
            sideEffects = "Nausea, vomiting, diarrhea, orthostatic hypotension (with rapid IV push), color vision disturbances, deep vein thrombosis, pulmonary embolism (rare when used for acute trauma/PPH).",
            priceNpr = "NPR 120.00 - 240.00 per ampoule (500mg/5ml); NPR 150.00 - 280.00 per strip of 10 tablets (500mg)",
            priceInr = "INR 65.00 - 140.00 per ampoule (500mg/5ml); INR 80.00 - 180.00 per strip of 10 tablets (500mg)",
            brandsNepal = listOf(
                BrandInfo("Pause", "Emcure / Nepal Import", "Inj / Tab", "500 mg / 5 ml Inj / 500 mg Tab"),
                BrandInfo("Trapic", "Sun Pharma Nepal", "Inj / Tab", "500 mg Inj / 500 mg Tab"),
                BrandInfo("Tranostat", "Nepal Pharmaceuticals Lab", "Inj / Tab", "500 mg Inj / 500 mg Tab")
            ),
            brandsIndia = listOf(
                BrandInfo("Pause", "Emcure Pharmaceuticals", "Inj / Tab", "500 mg / 5 ml Inj / 500 mg Tab"),
                BrandInfo("Trapic", "Sun Pharmaceutical Industries", "Inj / Tab", "500 mg / 5 ml Inj / 500 mg / 650 mg Tab"),
                BrandInfo("Texakind", "Mankind Pharma", "Inj / Tab", "500 mg Inj / 500 mg Tab"),
                BrandInfo("Cyklokapron", "Pfizer India", "Inj / Tab", "500 mg Inj / 500 mg Tab")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg/kg IV loading over 10 min, then 5-10 mg/kg/hr infusion",
            adultDose = "Trauma: 1g IV over 10 min, then 1g over 8h; PPH: 1g IV over 10 min stat",
            childDose = "10 to 15 mg/kg IV or PO (max 1000 mg/dose)",
            contraindications = "Active intravascular clotting or disseminated intravascular coagulation (DIC); history of venous or arterial thromboembolism; subarachnoid hemorrhage; severe renal failure.",
            modeOfAction = "Competitively blocks lysine-binding sites on plasminogen, preventing plasmin formation and fibrin clot dissolution.",
            interactions = "Concomitant use with Combined Oral Contraceptives, HRT, or Factor IX Complex concentrates significantly escalates thrombotic risk.",
            packSize = "Pack of 5 ampoules (5ml) or Strip of 10 tablets"
        ),

        // d80: Budesonide + Formoterol Fumarate
        Drug(
            id = "d80",
            genericName = "Budesonide + Formoterol",
            system = "Respiratory System (RS)",
            drugClass = "Inhaled Corticosteroid (ICS) + Long-Acting Beta-2 Agonist (LABA)",
            blackBoxWarning = null,
            indications = "Maintenance and Reliever Therapy (SMART / MART per GINA Guidelines) for Moderate to Severe Asthma (preferred first-line strategy across GINA Track 1); Maintenance therapy for Severe Chronic Obstructive Pulmonary Disease (COPD) with frequent exacerbations.",
            doses = "Asthma SMART / MART Strategy (GINA Track 1): Maintenance: 1 to 2 inhalations (160/4.5 mcg or 200/6 mcg) PO inhalation BID (morning and evening).\nReliever / PRN: Inhale 1 additional puff as needed for acute asthma symptoms. (Maximum total daily dose: 12 inhalations / 72 mcg formoterol in 24 hours).\nAsthma Fixed Maintenance (GINA Track 2): 200/6 mcg or 400/12 mcg BID + SABA (Salbutamol) PRN.\nCOPD: 160/4.5 mcg or 200/6 mcg: 2 inhalations BID.",
            administration = "Oral inhalation via dry powder inhaler (DPI - Turbuhaler / Rotahaler) or metered-dose inhaler (MDI with spacer). Rinse mouth thoroughly with water and spit out after each use.",
            timing = "Regularly every 12 hours + PRN for symptom relief in SMART regimen.",
            specialInstructions = "RINSE AND SPIT: Always rinse mouth with water and spit out after inhalation to prevent oral candidiasis (thrush) and dysphonia. Formoterol has a rapid onset of bronchodilation (1-3 minutes) like salbutamol, but lasts 12 hours, making this combination uniquely suited as both daily controller AND acute rescue reliever.",
            pkPd = "Budesonide is an anti-inflammatory glucocorticoid with high topical affinity for airway glucocorticoid receptors, suppressing cytokines, chemokines, and eosinophilic airway inflammation. Formoterol is a potent, long-acting, selective beta-2 adrenergic receptor agonist that relaxes bronchial smooth muscle. Rapid onset (1-3 min). Duration >12 hours. Cleared by CYP3A4.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Severe hepatic impairment may increase systemic budesonide exposure; use with standard monitoring.",
            pregnancy = "Category B / First-Line in Pregnancy: Budesonide is the most studied and preferred inhaled corticosteroid in pregnancy; maintaining asthma control is vital to prevent fetal hypoxia.",
            lactation = "Compatible with breastfeeding; minimal systemic absorption into milk.",
            sideEffects = "Oral candidiasis (thrush), dysphonia (hoarseness), throat irritation, tremor, palpitations, headache, tachycardia, hypokalemia in overdose, paradoxical bronchospasm.",
            priceNpr = "NPR 380.00 - 750.00 per inhaler / rotacap pack (100/6 / 200/6 / 400/6 mcg)",
            priceInr = "INR 220.00 - 450.00 per inhaler / rotacap pack (100/6 / 200/6 / 400/6 mcg)",
            brandsNepal = listOf(
                BrandInfo("Foracort", "Cipla Nepal", "Inhaler / Rotacaps", "100 mcg / 200 mcg / 400 mcg"),
                BrandInfo("Budamate", "Lupin Nepal", "Transhaler / Caps", "100 mcg / 200 mcg / 400 mcg"),
                BrandInfo("Symbicort", "AstraZeneca Nepal", "Turbuhaler", "160/4.5 mcg / 320/9 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Foracort", "Cipla Ltd.", "Inhaler / Rotacaps / Autohaler", "100 / 200 / 400 mcg"),
                BrandInfo("Budamate", "Lupin Ltd.", "Inhaler / Transcaps", "100 / 200 / 400 mcg"),
                BrandInfo("Symbicort", "AstraZeneca India", "Turbuhaler", "80/4.5 / 160/4.5 / 320/9 mcg"),
                BrandInfo("Formonide", "Zydus Healthcare", "Respicaps / Inhaler", "100 / 200 / 400 mcg")
            ),
            pediatricDosePerKg = null,
            pediatricInterval = "Children ≥6 yrs: 80/4.5 or 100/6 mcg 1-2 puffs BID",
            adultDose = "1-2 puffs (160/4.5 or 200/6 mcg) BID maintenance + 1 puff PRN for relief",
            childDose = "≥6 yrs: 100/6 mcg 1 puff BID (max 4-8 puffs/day in SMART)",
            contraindications = "Primary treatment of status asthmaticus or acute episodes of asthma where intensive measures are required; hypersensitivity to budesonide or formoterol.",
            modeOfAction = "Budesonide suppresses airway mucosal inflammation; Formoterol stimulates intracellular adenyl cyclase, causing bronchial smooth muscle relaxation.",
            interactions = "Strong CYP3A4 inhibitors (Ketoconazole, Itraconazole, Clarithromycin) increase systemic budesonide exposure. Non-selective beta-blockers (Propranolol) antagonize formoterol and induce severe bronchospasm (contraindicated in asthma).",
            packSize = "Inhaler (120 actuations) or bottle of 30 rotacaps"
        )
    )

    val expandedInteractions: List<DrugInteraction> = listOf(
        DrugInteraction(
            drug1Generic = "Tofacitinib Citrate",
            drug2Generic = "Ketoconazole",
            severity = InteractionSeverity.SERIOUS,
            effect = "Markedly increased tofacitinib systemic exposure (AUC increased by 103%) and increased risk of serious infections, bone marrow suppression, and DVT.",
            mechanism = "Ketoconazole is a potent CYP3A4 and moderate CYP2C19 inhibitor, significantly reducing hepatic metabolism and clearance of tofacitinib.",
            clinicalAction = "Reduce tofacitinib dose by 50% (e.g. from 5 mg BID to 5 mg once daily, or from 10 mg BID to 5 mg BID in ulcerative colitis). Monitor closely for cytopenias and signs of infection.",
            sourceDatabase = "FDA Drug Label / Lexicomp",
            documentationLevel = "Established (Class A)",
            riskCategory = "Metabolism / CYP3A4 Inhibition"
        ),
        DrugInteraction(
            drug1Generic = "Tofacitinib Citrate",
            drug2Generic = "Methotrexate",
            severity = InteractionSeverity.MODERATE,
            effect = "Additive immunosuppressive effect and increased risk of serious bacterial, fungal, or viral infections (including herpes zoster).",
            mechanism = "Pharmacodynamic synergy: dual inhibition of intracellular signaling (JAK inhibition by tofacitinib + DHFR/adenosine modulation by methotrexate).",
            clinicalAction = "Commonly co-prescribed in severe rheumatoid arthritis under specialist rheumatology supervision. Monitor CBC and liver enzymes monthly; withhold if active infection or ALC <500/mm³.",
            sourceDatabase = "American College of Rheumatology (ACR) Guidelines",
            documentationLevel = "Established (Class A)",
            riskCategory = "Immunosuppression / Infection Risk"
        ),
        DrugInteraction(
            drug1Generic = "Allopurinol",
            drug2Generic = "Azathioprine",
            severity = InteractionSeverity.CONTRAINDICATED,
            effect = "Severe, life-threatening bone marrow suppression and fatal pancytopenia / aplastic anemia.",
            mechanism = "Allopurinol inhibits xanthine oxidase, the primary enzyme responsible for catabolizing 6-mercaptopurine (the active metabolite of azathioprine). This causes a 4- to 5-fold surge in active 6-thioguanine nucleotide levels.",
            clinicalAction = "Avoid combination whenever possible. If co-administration is clinically mandatory (e.g., in refractory IBD under specialist protocol), REDUCE AZATHIOPRINE DOSE BY 75% (to 25% of standard dose) and monitor CBC weekly.",
            sourceDatabase = "British National Formulary (BNF) / UpToDate",
            documentationLevel = "Established (Class A)",
            riskCategory = "Bone Marrow Suppression / Fatal Toxicity"
        ),
        DrugInteraction(
            drug1Generic = "Methotrexate",
            drug2Generic = "Diclofenac Sodium",
            severity = InteractionSeverity.SERIOUS,
            effect = "Elevated methotrexate serum concentrations resulting in severe bone marrow suppression, ulcerative stomatitis, nephrotoxicity, and gastrointestinal hemorrhage.",
            mechanism = "NSAIDs reduce renal prostaglandins and competitively inhibit renal tubular secretion of methotrexate via OAT1/OAT3 transporters.",
            clinicalAction = "Use caution when co-administering NSAIDs with weekly methotrexate. Ensure regular CBC and renal function monitoring. Strictly avoid high-dose NSAIDs with high-dose oncologic methotrexate.",
            sourceDatabase = "UpToDate / Lexicomp",
            documentationLevel = "Established (Class A)",
            riskCategory = "Nephrotoxicity / Clearance"
        ),
        DrugInteraction(
            drug1Generic = "Colchicine",
            drug2Generic = "Clarithromycin",
            severity = InteractionSeverity.CONTRAINDICATED,
            effect = "Fatal colchicine toxicity with acute multiorgan failure, rhabdomyolysis, and cardiogenic shock.",
            mechanism = "Clarithromycin is a potent inhibitor of both CYP3A4 and P-glycoprotein, completely blocking the dual primary elimination pathways of colchicine.",
            clinicalAction = "STRICTLY CONTRAINDICATED in patients with renal or hepatic impairment. In patients with normal renal/hepatic function, avoid combination or interrupt colchicine during macrolide therapy. Use azithromycin instead.",
            sourceDatabase = "FDA Drug Safety Warning / CredibleMeds",
            documentationLevel = "Established (Class A)",
            riskCategory = "Fatal Toxicity / P-gp & CYP3A4"
        ),
        DrugInteraction(
            drug1Generic = "Sacubitril + Valsartan",
            drug2Generic = "Ramipril",
            severity = InteractionSeverity.CONTRAINDICATED,
            effect = "Extremely high risk of life-threatening angioedema with airway compromise and severe hypotension.",
            mechanism = "Dual inhibition of neprilysin (which degrades bradykinin) and angiotensin-converting enzyme (which also degrades bradykinin) leads to massive, synergistic bradykinin accumulation in respiratory and facial tissues.",
            clinicalAction = "CONTRAINDICATED. A STRICT 36-HOUR WASHOUT PERIOD is mandatory between stopping an ACE inhibitor (Ramipril, Enalapril, Lisinopril) and initiating sacubitril/valsartan.",
            sourceDatabase = "PARADIGM-HF / ACC-AHA-HFSA Guidelines",
            documentationLevel = "Established (Class A)",
            riskCategory = "Angioedema / Airway Compromise"
        ),
        DrugInteraction(
            drug1Generic = "Apixaban",
            drug2Generic = "Ketoconazole",
            severity = InteractionSeverity.SERIOUS,
            effect = "Significant increase in apixaban exposure (AUC increased by 100%) and markedly elevated risk of major gastrointestinal and intracranial bleeding.",
            mechanism = "Ketoconazole strongly inhibits both CYP3A4 and P-glycoprotein, the primary pathways of apixaban clearance.",
            clinicalAction = "Reduce apixaban dose by 50% (e.g. from 5 mg BID to 2.5 mg BID). If patient is already taking 2.5 mg BID, avoid co-administration of strong dual CYP3A4/P-gp inhibitors.",
            sourceDatabase = "FDA Drug Label / European Heart Journal",
            documentationLevel = "Established (Class A)",
            riskCategory = "Hemorrhage / Coagulation"
        )
    )
}
