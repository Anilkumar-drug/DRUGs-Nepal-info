package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object CuttingEdgeClinicalDrugsData {

    val cuttingEdgeDrugs: List<Drug> = listOf(
        // 1. Tolvaptan
        Drug(
            id = "d_cut_1",
            genericName = "Tolvaptan",
            system = "Renal & Genitourinary",
            drugClass = "Selective Vasopressin V2 Receptor Antagonist (Aquaretic)",
            blackBoxWarning = "INITIATE AND RE-INITIATE IN HOSPITAL: Too rapid correction of hyponatremia (e.g. >12 mEq/L/24 hours) can cause Osmotic Demyelination Syndrome (ODS), resulting in dysarthria, mutism, dysphagia, lethargy, affective changes, spastic quadriparesis, seizures, coma, or death. Discontinue if signs of liver injury emerge; limit treatment duration to ≤30 days due to potential hepatotoxicity.",
            indications = "Hypervolemic and euvolemic hyponatremia (SIADH, Heart Failure, Cirrhosis) with serum Na <125 mEq/L or symptomatic hyponatremia resistant to fluid restriction; Autosomal Dominant Polycystic Kidney Disease (ADPKD) to slow progression of cyst development and renal insufficiency.",
            doses = "Hyponatremia: Initial 15 mg PO once daily; titrate to 30 mg OD after ≥24 hours if needed; max 60 mg OD. ADPKD: Split-dose 45 mg in morning + 15 mg 8 hours later (titrate up to 90 mg + 30 mg daily).",
            administration = "Take orally without regard to food. Do not drink grapefruit juice. Ensure patient has unrestricted access to water.",
            timing = "Morning with plenty of water.",
            specialInstructions = "Monitor serum sodium every 4-6 hours during initiation. Do not restrict fluid intake during initial 24 hours of therapy. Avoid concomitant strong CYP3A4 inhibitors (Ketoconazole, Clarithromycin).",
            pkPd = "Oral bioavailability ~56%. Highly protein-bound (~98%). Extensively metabolized by CYP3A4 into inactive metabolites; fecal excretion ~59%, renal ~40%. Elimination half-life ~12 hours. Increases free water clearance (aquaresis) without increasing sodium or potassium excretion.",
            renalAdj = "CrCl <10 mL/min or anuria: Not recommended (drug loses aquaretic efficacy). No adjustment required for CrCl ≥10 mL/min.",
            hepaticAdj = "Severe hepatic impairment: Use with extreme caution; avoid in patients with baseline transaminases >3× ULN. Discontinue permanently if ALT/AST >3× ULN or signs of liver injury appear.",
            pregnancy = "Category C (Avoid unless maternal benefit outweighs fetal risk)",
            lactation = "Present in animal milk; discontinue nursing or avoid drug due to risk of dehydration in neonate.",
            sideEffects = "Excessive thirst (polydipsia), dry mouth, polyuria, pollakiuria, dehydration, hypernatremia, fatigue, dizziness, elevated transaminases.",
            priceNpr = "NPR 120.00 - 180.00 per tab (15mg)",
            priceInr = "INR 80.00 - 120.00 per tab (15mg)",
            brandsNepal = listOf(
                BrandInfo("Tolvat", "Asian Pharmaceuticals", "Tab", "15 mg / 30 mg"),
                BrandInfo("Natrise-NP", "Deurali-Janta Pharmaceuticals", "Tab", "15 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Samsca", "Otsuka Pharmaceutical / Zydus", "Tab", "15 mg / 30 mg"),
                BrandInfo("Tolvat", "MSN Laboratories", "Tab", "15 mg / 30 mg"),
                BrandInfo("Natrise", "Sun Pharma", "Tab", "15 mg / 30 mg"),
                BrandInfo("Resodim", "Lupin Ltd.", "Tab", "15 mg / 30 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety and efficacy not established in pediatric patients under 18 years"
        ),

        // 2. Vonoprazan
        Drug(
            id = "d_cut_2",
            genericName = "Vonoprazan",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Potassium-Competitive Acid Blocker (P-CAB)",
            blackBoxWarning = null,
            indications = "Severe Erosive Esophagitis (healing and maintenance), Refractory Gastroesophageal Reflux Disease (GERD), Helicobacter pylori eradication (in combination with Amoxicillin ± Clarithromycin), Gastric and duodenal ulcer healing and prevention of NSAID-induced ulcers.",
            doses = "Erosive Esophagitis Healing: 20 mg PO once daily for 8 weeks. Maintenance of healed EE: 10 mg PO once daily for up to 6 months. H. pylori Dual Therapy: Vonoprazan 20 mg BID + Amoxicillin 1000 mg TID for 14 days. H. pylori Triple Therapy: Vonoprazan 20 mg BID + Amoxicillin 1000 mg BID + Clarithromycin 500 mg BID for 14 days.",
            administration = "Take orally once or twice daily without regard to food. Swallow tablets whole; do not crush or chew.",
            timing = "Morning or morning and evening (consistent daily).",
            specialInstructions = "Achieves rapid and sustained 24-hour acid suppression from day 1 without requiring acid activation like conventional PPIs. Does not depend on CYP2C19 extensive/poor metabolizer genetics.",
            pkPd = "Bioavailability ~80%. Rapid peak plasma concentration within 1.5-2 hours. Accumulates in gastric parietal cell secretory canaliculi with slow dissociation; elimination half-life ~7-9 hours. Primary metabolism via CYP3A4/5, CYP2B6, CYP2C19, and SULT2A1.",
            renalAdj = "eGFR 15-29 mL/min: Max 10 mg PO daily for maintenance (or 20 mg daily with monitoring). eGFR <15 mL/min or dialysis: Not well studied; use lowest effective dose.",
            hepaticAdj = "Moderate to severe hepatic impairment (Child-Pugh B or C): Max 10 mg PO daily for EE maintenance, monitor closely.",
            pregnancy = "Category B3 / Caution (Limited human data; use only if clinically indicated)",
            lactation = "Excreted in animal milk; weigh clinical benefit to mother against theoretical risk to infant.",
            sideEffects = "Diarrhea, abdominal pain, dyspepsia, headache, nasopharyngitis, benign gastric fundic gland polyps (with long-term suppression).",
            priceNpr = "NPR 35.00 - 55.00 per tab (20mg)",
            priceInr = "INR 22.00 - 38.00 per tab (20mg)",
            brandsNepal = listOf(
                BrandInfo("Vonozap", "Nepal Pharmaceuticals Lab", "Tab", "10 mg / 20 mg"),
                BrandInfo("P-Cab", "Deurali-Janta Pharmaceuticals", "Tab", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Voquezna", "Phathom Pharmaceuticals / Dr. Reddy's", "Tab", "10 mg / 20 mg"),
                BrandInfo("Vonopraz", "Sun Pharma", "Tab", "10 mg / 20 mg"),
                BrandInfo("Lupivon", "Lupin Ltd.", "Tab", "20 mg"),
                BrandInfo("Macpraz", "Macleods Pharmaceuticals", "Tab", "20 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Not established in pediatric patients <18 years"
        ),

        // 3. Baloxavir Marboxil
        Drug(
            id = "d_cut_3",
            genericName = "Baloxavir Marboxil",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Cap-Dependent Endonuclease (CEN) Inhibitor (Antiviral)",
            blackBoxWarning = null,
            indications = "Acute uncomplicated Influenza A and B infection in patients aged ≥5 years who have been symptomatic for no more than 48 hours; Post-exposure prophylaxis of influenza following close contact with an infected individual.",
            doses = "Weight 40 kg to <80 kg: Single oral dose of 40 mg PO once.\nWeight ≥80 kg: Single oral dose of 80 mg PO once.\nPediatric (5 to <12 years, weight 20 kg to <80 kg): Single dose 2 mg/kg up to max 40 mg (or 80 mg if ≥80 kg).",
            administration = "Take as a single dose with or without food. AVOID co-administration with polyvalent cation-containing antacids, laxatives, or oral dairy supplements (calcium, iron, magnesium, selenium, zinc) as they severely impair absorption via chelation.",
            timing = "Stat single dose as early as possible within 48 hours of symptom onset.",
            specialInstructions = "Single-dose convenience significantly improves adherence compared to 5-day Oseltamivir. Does not replace seasonal influenza vaccination.",
            pkPd = "Prodrug rapidly hydrolyzed to active Baloxavir by arylacetamide deacetylase. Peak plasma concentration ~4 hours. Extremely long elimination half-life of ~79 hours, enabling single-dose efficacy. Inhibits mRNA replication of influenza virus.",
            renalAdj = "No dosage adjustment required for CrCl ≥50 mL/min. Not adequately studied in severe renal failure (CrCl <15 mL/min) or hemodialysis.",
            hepaticAdj = "No dosage adjustment needed for mild to moderate hepatic impairment (Child-Pugh A or B).",
            pregnancy = "Category B (Limited human pregnancy data; use if maternal benefit outweighs potential risk)",
            lactation = "Excreted into animal milk; considerations should be given to benefits of breastfeeding and maternal clinical need.",
            sideEffects = "Diarrhea, bronchitis, nausea, nasopharyngitis, headache, rare hypersensitivity reactions (anaphylaxis, angioedema, urticaria).",
            priceNpr = "NPR 1,200.00 - 1,800.00 per single dose pack",
            priceInr = "INR 800.00 - 1,200.00 per single dose pack",
            brandsNepal = listOf(
                BrandInfo("Balovir", "Deurali-Janta Pharmaceuticals", "Tab", "40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Xofluza", "Roche Products India / Shionogi", "Tab", "40 mg / 80 mg"),
                BrandInfo("Baloxa", "Cipla Ltd.", "Tab", "40 mg")
            ),
            pediatricDosePerKg = 2.0,
            pediatricInterval = "Single stat dose (max 40mg for <80kg, 80mg for >=80kg)"
        ),

        // 4. Nirmatrelvir + Ritonavir (Paxlovid)
        Drug(
            id = "d_cut_4",
            genericName = "Nirmatrelvir + Ritonavir",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "SARS-CoV-2 3CL Main Protease (Mpro) Inhibitor + CYP3A4 Pharmacokinetic Booster",
            blackBoxWarning = "SEVERE DRUG-DRUG INTERACTIONS: Co-administration with drugs highly dependent on CYP3A for clearance and for which elevated plasma concentrations are associated with serious and/or life-threatening reactions is contraindicated (e.g. Amiodarone, Simvastatin, Lovastatin, Carbamazepine, Phenobarbital, Phenytoin, Rifampin, St. John's Wort, Sildenafil for PAH). Comprehensive medication reconciliation is mandatory prior to prescribing.",
            indications = "Treatment of mild-to-moderate COVID-19 in adults and pediatric patients (≥12 years weighing ≥40 kg) who are at high risk for progression to severe disease, hospitalization, or death.",
            doses = "Standard Dose (eGFR >60 mL/min): Nirmatrelvir 300 mg (two 150 mg pink tablets) PLUS Ritonavir 100 mg (one 100 mg white tablet) taken together orally twice daily for 5 days.",
            administration = "Take tablets together orally BID with or without food. Swallow whole; do not chew, break, or crush. Initiate within 5 days of COVID-19 symptom onset.",
            timing = "Morning and evening (every 12 hours) for exactly 5 days.",
            specialInstructions = "Always screen current prescription, OTC, and herbal medications using an interaction checker. Do not discontinue Paxlovid prematurely if symptoms improve.",
            pkPd = "Nirmatrelvir inhibits SARS-CoV-2 main protease (3CLpro), blocking viral polyprotein cleavage and replication. Ritonavir acts as a pharmacokinetic booster by irreversibly inhibiting CYP3A4, markedly elevating Nirmatrelvir AUC and Cmax. Nirmatrelvir half-life ~6 hours; eliminated renally.",
            renalAdj = "eGFR 30-59 mL/min (Moderate Impairment): Reduce Nirmatrelvir dose to 150 mg (one tablet) + Ritonavir 100 mg (one tablet) PO BID for 5 days. eGFR <30 mL/min or dialysis: NOT RECOMMENDED.",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh C): Contraindicated. No adjustment needed for mild or moderate hepatic impairment (Child-Pugh A or B).",
            pregnancy = "Category B (Available observational data show no clear increase in major birth defects; benefits usually outweigh risks in high-risk COVID-19)",
            lactation = "Present in breast milk in small amounts; acceptable with infant monitoring.",
            sideEffects = "Dysgeusia (metallic/bitter taste ~6%), diarrhea, hypertension, myalgia, nausea, vomiting, rebound COVID symptoms (mild, in 2-5% of patients).",
            priceNpr = "NPR 4,500.00 - 7,000.00 for complete 5-day treatment course",
            priceInr = "INR 3,000.00 - 4,800.00 for complete 5-day course",
            brandsNepal = listOf(
                BrandInfo("Paxokov", "Deurali-Janta Pharmaceuticals", "Combipack", "150mg + 100mg"),
                BrandInfo("Nirmat-R", "National Healthcare Nepal", "Combipack", "150mg + 100mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Paxlovid", "Pfizer India", "Combipack", "150mg + 100mg"),
                BrandInfo("Paxista", "Hetero Healthcare", "Combipack", "150mg + 100mg"),
                BrandInfo("Primovir", "Astrica Healthcare", "Combipack", "150mg + 100mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Age >=12 years and weight >=40 kg: Same as adult dose"
        ),

        // 5. Mavacamten
        Drug(
            id = "d_cut_5",
            genericName = "Mavacamten",
            system = "Cardiovascular System (CVS)",
            drugClass = "Cardiac Myosin Allosteric Inhibitor (Negative Inotrope)",
            blackBoxWarning = "HEART FAILURE RISK: Mavacamten reduces Left Ventricular Ejection Fraction (LVEF) and can cause heart failure with systolic dysfunction. Echocardiographic assessment of LVEF is required before initiation and regularly during treatment. Do not initiate in patients with LVEF <55%. Withhold treatment if LVEF <50% or if patient experiences heart failure symptoms or worsening clinical status. Concomitant use with strong CYP2C19 or CYP3A4 inhibitors/inducers is contraindicated.",
            indications = "Symptomatic obstructive hypertrophic cardiomyopathy (oHCM, NYHA Class II-III) to improve functional capacity, reduce left ventricular outflow tract (LVOT) gradient, and relieve dyspnea.",
            doses = "Initial dose: 5 mg PO once daily regardless of body weight. Assess clinical status and Valsalva LVOT gradient at 4, 8, and 12 weeks. Titrate up in 2.5-5 mg increments (range 2.5 mg to max 15 mg PO OD).",
            administration = "Take orally once daily with or without food.",
            timing = "Morning with water.",
            specialInstructions = "Requires REMS program in USA/international registries. Confirm baseline LVEF >=55% and perform echocardiogram at week 4, 8, 12, and every 12 weeks thereafter.",
            pkPd = "Selective, reversible cardiac myosin ATPase inhibitor. Reduces actin-myosin cross-bridge formation, shifting myosin heads into an energy-sparing super-relaxed state. Bioavailability ~85%. Elimination half-life ~6-9 days (prolonged in CYP2C19 poor metabolizers).",
            renalAdj = "Mild to moderate renal impairment: No dosage adjustment. Severe renal impairment (eGFR <30 mL/min): Not studied.",
            hepaticAdj = "Mild to moderate hepatic impairment: Max starting dose 2.5 mg PO OD. Severe hepatic impairment (Child-Pugh C): Avoid.",
            pregnancy = "Category D / Teratogenic (Can cause embryo-fetal toxicity; negative pregnancy test required before starting; effective contraception required during and for 4 months post-discontinuation)",
            lactation = "Discontinue breastfeeding during treatment due to potential adverse cardiovascular effects in infant.",
            sideEffects = "Dizziness, syncope, dyspnea, reduction in LVEF, new-onset systolic heart failure.",
            priceNpr = "NPR 1,500.00 - 2,500.00 per capsule",
            priceInr = "INR 950.00 - 1,800.00 per capsule",
            brandsNepal = listOf(
                BrandInfo("Mavacam", "Asian Pharmaceuticals", "Cap", "2.5 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Camzyos", "Bristol Myers Squibb India", "Cap", "2.5 mg / 5 mg / 10 mg / 15 mg"),
                BrandInfo("Mavamten", "Sun Pharma", "Cap", "5 mg / 10 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety and efficacy not established in pediatric patients"
        ),

        // 6. Sotagliflozin
        Drug(
            id = "d_cut_6",
            genericName = "Sotagliflozin",
            system = "Endocrine & Metabolic System",
            drugClass = "Dual SGLT1 and SGLT2 Inhibitor",
            blackBoxWarning = null,
            indications = "Reduction of the risk of cardiovascular death, hospitalization for heart failure, and urgent heart failure visit in adults with Heart Failure (across HFrEF, HFmrEF, and HFpEF); Type 2 Diabetes Mellitus with Chronic Kidney Disease and cardiovascular risk factors.",
            doses = "Initial: 200 mg PO once daily before the first meal of the day. If tolerated, increase after at least 2 weeks to target dose of 400 mg PO once daily.",
            administration = "Take orally once daily within 1 hour before the first meal of the day.",
            timing = "Before breakfast.",
            specialInstructions = "Dual inhibition targets both renal SGLT2 (promoting glucosuria and natriuresis) and intestinal SGLT1 (delaying postprandial glucose absorption in the small intestine). Screen for Euglycemic DKA during acute stress, surgery, or starvation.",
            pkPd = "Peak plasma concentration reached at 1.5-3 hours. Elimination half-life ~21 hours. Metabolized predominantly via glucuronidation (UGT1A9); excreted in feces (~57%) and urine (~37%).",
            renalAdj = "eGFR >=25 mL/min: No dosage adjustment. eGFR <25 mL/min: Not recommended for initiation, but can continue 200 mg OD if already on therapy until dialysis.",
            hepaticAdj = "Moderate hepatic impairment (Child-Pugh B): 200 mg once daily max. Severe hepatic impairment (Child-Pugh C): Not recommended.",
            pregnancy = "Contraindicated in 2nd and 3rd trimesters of pregnancy due to adverse fetal renal development.",
            lactation = "Not recommended during breastfeeding due to potential risk of glucosuria and dehydration in neonate.",
            sideEffects = "Euglycemic diabetic ketoacidosis (euDKA), volume depletion/hypotension, urinary tract infections, genital mycotic infections, diarrhea, hypoglycemia.",
            priceNpr = "NPR 60.00 - 95.00 per tab (200mg)",
            priceInr = "INR 40.00 - 65.00 per tab (200mg)",
            brandsNepal = listOf(
                BrandInfo("Sotaglif", "Deurali-Janta Pharmaceuticals", "Tab", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Inpefa", "Lexicon Pharmaceuticals / Sun Pharma", "Tab", "200 mg / 400 mg"),
                BrandInfo("Zynquista", "Sanofi India", "Tab", "200 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients"
        ),

        // 7. Efgartigimod Alfa
        Drug(
            id = "d_cut_7",
            genericName = "Efgartigimod Alfa",
            system = "Central Nervous System (CNS)",
            drugClass = "Neonatal Fc Receptor (FcRn) Blocker / Human IgG1 Antibody Fragment",
            blackBoxWarning = null,
            indications = "Generalized Myasthenia Gravis (gMG) in adult patients who are anti-acetylcholine receptor (AChR) antibody positive; Immune Thrombocytopenia (ITP) in refractory adult patients.",
            doses = "10 mg/kg administered as an IV infusion over 1 hour once weekly for 4 weeks (one cycle). Subsequent treatment cycles are administered based on clinical symptom recurrence (minimum 50 days from start of previous cycle). Also available as SC injection (Efgartigimod alfa + Vorhyaluronidase-alfc 1008 mg SC weekly x 4 weeks).",
            administration = "Administer IV over 60 minutes using a 0.2-micron in-line filter. Do not administer as an IV push or bolus.",
            timing = "Scheduled weekly infusion during active cycle.",
            specialInstructions = "Blocks FcRn, preventing IgG recycling and accelerating degradation of pathogenic anti-AChR autoantibodies (reduces total IgG by ~75%). Monitor for respiratory infections. Delay treatment in patients with active severe infection.",
            pkPd = "Engineered human IgG1 antibody Fc fragment. Volume of distribution ~15-20 L. Terminal half-life ~3-5 days. Catabolized into amino acids through general protein degradation pathways.",
            renalAdj = "Mild to moderate renal impairment: No adjustment. Severe renal impairment (eGFR <30 mL/min): Limited data; monitor closely.",
            hepaticAdj = "No dosage adjustment needed (not cleared via hepatic CYP pathways).",
            pregnancy = "Category B (Monoclonal antibody fragments cross the placenta; weigh maternal neurological stabilization against potential fetal exposure)",
            lactation = "Endogenous IgG is transferred into colostrum; theoretical transfer of efgartigimod. Weigh clinical benefit against infant risk.",
            sideEffects = "Upper respiratory tract infections, urinary tract infections, headache, paresthesia, transient leukopenia, myalgia.",
            priceNpr = "NPR 180,000.00 - 240,000.00 per vial (400mg)",
            priceInr = "INR 120,000.00 - 160,000.00 per vial (400mg)",
            brandsNepal = listOf(
                BrandInfo("Vyvgart-Import", "Hospital Specialty Supply", "Vial", "400 mg / 20 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Vyvgart", "Argenx / Zydus Lifesciences", "Vial", "400 mg / 20 mL"),
                BrandInfo("Vyvgart Hytrulo", "Argenx", "Subcutaneous Inj", "1008 mg / 5.6 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Not established in pediatric patients"
        ),

        // 8. Risdiplam
        Drug(
            id = "d_cut_8",
            genericName = "Risdiplam",
            system = "Central Nervous System (CNS)",
            drugClass = "Survival Motor Neuron 2 (SMN2) Splicing Modifier",
            blackBoxWarning = null,
            indications = "Spinal Muscular Atrophy (SMA) types 1, 2, and 3 in pediatric and adult patients of all ages (from birth onwards).",
            doses = "Age <2 months: 0.15 mg/kg once daily.\nAge 2 months to <2 years: 0.20 mg/kg once daily.\nAge ≥2 years weighing <20 kg: 0.25 mg/kg once daily.\nAge ≥2 years weighing ≥20 kg: 5 mg once daily (max dose).",
            administration = "Take orally once daily after a meal at approximately the same time each day using the provided calibrated oral syringe. Constituted solution must be refrigerated (2°C-8°C) and discarded after 64 days.",
            timing = "Once daily after food in morning.",
            specialInstructions = "Oral alternative to intrathecal Nusinersen or IV gene therapy Onasemnogene abeparvovec. Promotes inclusion of exon 7 in SMN2 mRNA, producing full-length functional SMN protein systemically.",
            pkPd = "Rapid absorption; peak plasma concentration within 1-4 hours. Crosses the blood-brain barrier effectively. Extensively metabolized by FMO3 and CYP3A4. Terminal elimination half-life ~50 hours.",
            renalAdj = "No dosage adjustment needed for mild to moderate renal impairment. Limited data in severe impairment.",
            hepaticAdj = "No adjustment needed for mild to moderate hepatic impairment.",
            pregnancy = "Contraindicated / Teratogenic (Avoid pregnancy; female patients of reproductive potential must use effective contraception during treatment and for 1 month after the last dose; males for 4 months due to potential sperm damage).",
            lactation = "Weigh benefits of nursing against risk of infant adverse effects; limited human data.",
            sideEffects = "Fever (pyrexia), diarrhea, rash, upper respiratory tract infection, pneumonia, constipation, vomiting, aphthous ulcers.",
            priceNpr = "NPR 110,000.00 - 150,000.00 per bottle (60mg powder for solution)",
            priceInr = "INR 75,000.00 - 95,000.00 per bottle (60mg)",
            brandsNepal = listOf(
                BrandInfo("Evrysdi-Special", "Roche Nepal Named Patient Access", "Oral Soln", "0.75 mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Evrysdi", "Roche Products India", "Oral Soln", "0.75 mg/mL (60mg/bottle)"),
                BrandInfo("Risdism", "Biocon Biologics", "Oral Soln", "0.75 mg/mL")
            ),
            pediatricDosePerKg = 0.2,
            pediatricInterval = "0.15-0.25 mg/kg once daily based on age and weight"
        ),

        // 9. Ravulizumab
        Drug(
            id = "d_cut_9",
            genericName = "Ravulizumab",
            system = "Central Nervous System (CNS)",
            drugClass = "Long-Acting Terminal Complement (C5) Inhibitor Monoclonal Antibody",
            blackBoxWarning = "SERIOUS MENINGOCOCCAL INFECTIONS: Life-threatening and fatal meningococcal infections (Neisseria meningitidis) have occurred in patients treated with terminal complement inhibitors. Vaccinate patients against meningococcal infection (serogroups A, C, W, Y and serogroup B) at least 2 weeks prior to administering the first dose. If urgent therapy is required in an unvaccinated patient, administer prophylactic antibacterial antibiotics immediately and vaccinate as soon as possible.",
            indications = "Paroxysmal Nocturnal Hemoglobinuria (PNH) in adults and pediatric patients aged ≥1 month; Atypical Hemolytic Uremic Syndrome (aHUS) to inhibit complement-mediated thrombotic microangiopathy; Generalized Myasthenia Gravis (gMG) in AChR antibody-positive adults; Neuromyelitis Optica Spectrum Disorder (NMOSD) in AQP4 antibody-positive adults.",
            doses = "Weight-based IV infusion every 8 weeks (following an initial loading dose on Day 1 and maintenance starting on Day 15). Weight 40 to <60 kg: Load 2400 mg IV, then 3000 mg q8w. Weight 60 to <100 kg: Load 2700 mg IV, then 3300 mg q8w. Weight ≥100 kg: Load 3000 mg IV, then 3600 mg q8w.",
            administration = "Administer as IV infusion using a 0.2-micron in-line filter over 1.5 to 3 hours depending on volume. Do not administer IV push or bolus.",
            timing = "Day 1 (Loading), Day 15, then every 8 weeks thereafter.",
            specialInstructions = "Engineered from Eculizumab with 4 amino acid substitutions in the Fc region that increase affinity for FcRn at acidic endosomal pH, extending terminal half-life 4-fold to ~50 days, allowing every 8-week dosing instead of every 2 weeks.",
            pkPd = "Specific binding to complement protein C5, preventing cleavage to C5a (anaphylatoxin) and C5b (preventing terminal membrane attack complex C5b-9 assembly). Terminal elimination half-life ~49.7 days.",
            renalAdj = "No dosage adjustment required across all stages of renal impairment.",
            hepaticAdj = "No dosage adjustment needed (not cleared via hepatic CYP enzymes).",
            pregnancy = "Category B (Human data from registries indicate no major congenital malformations; untreated PNH/aHUS carries severe maternal mortality)",
            lactation = "Present in human milk in negligible amounts; compatible with breastfeeding.",
            sideEffects = "Upper respiratory tract infection, headache, nasopharyngitis, nausea, hypertension, diarrhea, antibody development.",
            priceNpr = "NPR 450,000.00 - 650,000.00 per vial (300mg/30mL)",
            priceInr = "INR 300,000.00 - 450,000.00 per vial (300mg/30mL)",
            brandsNepal = listOf(
                BrandInfo("Ultomiris-Import", "Hospital Tertiary Care Supply", "Vial", "300 mg / 30 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Ultomiris", "AstraZeneca / Alexion Pharmaceuticals India", "Vial", "300 mg / 3 mL (Concentrated) / 300 mg / 30 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Weight-based pediatric dosing table applies"
        ),

        // 10. Ocrelizumab
        Drug(
            id = "d_cut_10",
            genericName = "Ocrelizumab",
            system = "Central Nervous System (CNS)",
            drugClass = "Humanized Anti-CD20 Monoclonal Antibody (B-Cell Depleting Agent)",
            blackBoxWarning = null,
            indications = "Relapsing forms of Multiple Sclerosis (RMS, including clinically isolated syndrome, relapsing-remitting disease, and active secondary progressive disease) in adults; Primary Progressive Multiple Sclerosis (PPMS) in adults.",
            doses = "Initial Dose: 300 mg IV infusion, followed 2 weeks later by a second 300 mg IV infusion. Subsequent Doses: 600 mg IV infusion once every 6 months. Premedicate with Methylprednisolone 100 mg IV + oral antihistamine + paracetamol 30-60 minutes prior to each infusion.",
            administration = "Administer by slow IV infusion via dedicated line with a 0.2-micron in-line filter. Initial rate 30 mL/hr, titrate up to max 180 mL/hr. Observe for infusion-related reactions (IRRs) for at least 1 hour post-infusion.",
            timing = "Every 6 months (24 weeks).",
            specialInstructions = "Screen for Hepatitis B Virus (HBV) surface antigen and core antibody before initiation (risk of fatal HBV reactivation). Check serum immunoglobulins (IgG/IgM) at baseline and periodically.",
            pkPd = "Selectively targets CD20 cell-surface antigen on pre-B and mature B lymphocytes, sparing pro-B cells and plasma cells. Induces rapid B-cell depletion via antibody-dependent cellular cytotoxicity (ADCC) and complement-dependent cytotoxicity (CDC). Elimination half-life ~26 days.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category C (Can cross placenta and cause fetal B-cell lymphopenia; contraception recommended during treatment and for 6 months after the final infusion)",
            lactation = "Excreted into breast milk in trace amounts; monitor infant for infections.",
            sideEffects = "Infusion-related reactions (pruritus, rash, throat irritation, flushing, fever), upper respiratory infections, depression, herpes virus infections, rare Progressive Multifocal Leukoencephalopathy (PML).",
            priceNpr = "NPR 350,000.00 - 500,000.00 per 300mg vial",
            priceInr = "INR 240,000.00 - 350,000.00 per 300mg vial",
            brandsNepal = listOf(
                BrandInfo("Ocrevus-NamedPatient", "Roche Nepal Access Program", "Vial", "300 mg / 10 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Ocrevus", "Roche Products India", "Vial", "300 mg / 10 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety and efficacy not established in pediatric patients"
        ),

        // 11. Tezepelumab
        Drug(
            id = "d_cut_11",
            genericName = "Tezepelumab",
            system = "Respiratory System (RS)",
            drugClass = "Thymic Stromal Lymphopoietin (TSLP) Inhibitor Monoclonal Antibody",
            blackBoxWarning = null,
            indications = "Add-on maintenance treatment of adult and pediatric patients aged ≥12 years with severe asthma (effective regardless of baseline eosinophil count, FeNO, or allergic status).",
            doses = "210 mg administered subcutaneously (SC) once every 4 weeks.",
            administration = "Administer SC in thigh, abdomen, or upper outer arm using a pre-filled pen or syringe. Not for acute bronchospasm or status asthmaticus.",
            timing = "Once every 4 weeks.",
            specialInstructions = "First-in-class upstream biologic targeting TSLP at the top of the inflammatory cascade, reducing both eosinophilic (Type 2 high) and non-eosinophilic (Type 2 low/neutrophilic) asthma exacerbations. Do not stop systemic corticosteroids abruptly upon initiation.",
            pkPd = "Human IgG2 monoclonal antibody binding specifically to TSLP, preventing interaction with the heterodimeric TSLP receptor complex. Peak concentration ~3-10 days. Terminal elimination half-life ~26 days.",
            renalAdj = "No dosage adjustment required.",
            hepaticAdj = "No dosage adjustment required.",
            pregnancy = "Category B (Limited human data; uncontrolled severe asthma in pregnancy carries high hypoxia risk to fetus)",
            lactation = "Endogenous IgG antibodies are secreted in breast milk; systemic absorption by infant is minimal.",
            sideEffects = "Pharyngitis, arthralgia, back pain, injection site reactions (erythema, swelling).",
            priceNpr = "NPR 85,000.00 - 120,000.00 per pre-filled pen (210mg)",
            priceInr = "INR 55,000.00 - 80,000.00 per pen (210mg)",
            brandsNepal = listOf(
                BrandInfo("Tezspire-Import", "Hospital Pulmonary Unit", "PFS", "210 mg / 1.91 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Tezspire", "AstraZeneca / Amgen India", "Autoinjector / PFS", "210 mg / 1.91 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Age >=12 years: 210 mg SC every 4 weeks"
        ),

        // 12. Deucravacitinib
        Drug(
            id = "d_cut_12",
            genericName = "Deucravacitinib",
            system = "Dermatology",
            drugClass = "Selective Allosteric Tyrosine Kinase 2 (TYK2) Inhibitor",
            blackBoxWarning = null,
            indications = "Moderate-to-severe plaque psoriasis in adult patients who are candidates for systemic therapy or phototherapy; Psoriatic Arthritis (under investigation/off-label).",
            doses = "6 mg PO once daily.",
            administration = "Take orally once daily with or without food. Swallow tablet whole; do not crush, cut, or chew.",
            timing = "Morning with water.",
            specialInstructions = "Selectively binds to the regulatory (pseudokinase JH2) domain of TYK2 rather than the ATP-binding catalytic domain, avoiding off-target inhibition of JAK1, JAK2, and JAK3, and avoiding common JAK inhibitor black box warnings (thrombosis, major cardiac events). Screen for latent TB prior to starting.",
            pkPd = "High oral bioavailability. Peak plasma concentration ~2-3 hours. Terminal elimination half-life ~10 hours. Metabolized via multiple pathways including CYP1A2, CYP2B6, CYP2D6, and UGT1A9.",
            renalAdj = "No dosage adjustment required for mild, moderate, or severe renal impairment. Not recommended in ESRD on dialysis.",
            hepaticAdj = "Mild to moderate hepatic impairment (Child-Pugh A or B): No adjustment. Severe hepatic impairment (Child-Pugh C): Not recommended.",
            pregnancy = "Category B3 / Caution (Limited human data; weigh risk/benefit)",
            lactation = "Present in animal milk; not recommended during breastfeeding.",
            sideEffects = "Upper respiratory tract infections, nasopharyngitis, stomatitis, oral herpes, acne, folliculitis, elevated CPK, headache.",
            priceNpr = "NPR 110.00 - 180.00 per tab (6mg)",
            priceInr = "INR 70.00 - 120.00 per tab (6mg)",
            brandsNepal = listOf(
                BrandInfo("Deucra", "Asian Pharmaceuticals", "Tab", "6 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Sotyktu", "Bristol Myers Squibb India", "Tab", "6 mg"),
                BrandInfo("Tykos", "Sun Pharma", "Tab", "6 mg"),
                BrandInfo("Deucta", "Dr. Reddy's Laboratories", "Tab", "6 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients <18 years"
        ),

        // 13. Roxadustat
        Drug(
            id = "d_cut_13",
            genericName = "Roxadustat",
            system = "Renal & Genitourinary",
            drugClass = "Oral Hypoxia-Inducible Factor Prolyl Hydroxylase Inhibitor (HIF-PHI)",
            blackBoxWarning = "THROMBOEMBOLIC EVENTS: Increases risk of serious arterial and venous thrombotic events, including myocardial infarction, stroke, deep vein thrombosis, pulmonary embolism, and vascular access thrombosis in dialysis patients when targeting high hemoglobin levels (>11-12 g/dL).",
            indications = "Anemia of Chronic Kidney Disease (CKD) in adult patients on dialysis (DD-CKD) and non-dialysis dependent (NDD-CKD).",
            doses = "Starting dose based on body weight: Weight 45-70 kg: 70 mg PO 3 times weekly (e.g. Mon, Wed, Fri). Weight >70 kg: 100 mg PO 3 times weekly. Titrate every 4 weeks based on Hb rate of rise (target Hb 10-11 g/dL; do not exceed 12 g/dL). Max single dose 3 mg/kg or 400 mg.",
            administration = "Take orally 3 times weekly on non-consecutive days with or without food. Ingest at least 1 hour before or after phosphate binders containing multivalent cations (calcium, iron, lanthanum, sevelamer).",
            timing = "Three times weekly (e.g., Monday, Wednesday, Friday).",
            specialInstructions = "Stimulates endogenous erythropoietin production and improves iron utilization (downregulates hepcidin, increases transferrin). Monitor hemoglobin every 2-4 weeks until stable.",
            pkPd = "Inhibits HIF prolyl hydroxylase enzymes, preventing degradation of HIF-alpha subunit and promoting gene transcription of EPO and iron transport enzymes. Peak plasma ~2 hours. Half-life ~12-13 hours.",
            renalAdj = "No dosage adjustment required for renal impairment (indicated for CKD stages 3-5 and ESRD).",
            hepaticAdj = "Moderate hepatic impairment (Child-Pugh B): Reduce starting dose by half. Severe hepatic impairment (Child-Pugh C): Not recommended.",
            pregnancy = "Contraindicated / Category X (Embryo-fetal toxicity observed in animal models; effective contraception required)",
            lactation = "Excreted into animal milk; avoid breastfeeding during treatment.",
            sideEffects = "Hypertension, vascular access thrombosis, peripheral edema, hyperkalemia, headache, diarrhea, nausea.",
            priceNpr = "NPR 180.00 - 280.00 per tab (50mg)",
            priceInr = "INR 120.00 - 190.00 per tab (50mg)",
            brandsNepal = listOf(
                BrandInfo("Roxadust", "Deurali-Janta Pharmaceuticals", "Tab", "20 mg / 50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Evrenzo", "Astellas Pharma / FibroGen / AstraZeneca", "Tab", "20 mg / 50 mg / 100 mg"),
                BrandInfo("Roxikind", "Mankind Pharma", "Tab", "50 mg / 100 mg"),
                BrandInfo("Oxemia", "Zydus Lifesciences", "Tab", "50 mg / 100 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Not approved for pediatric patients"
        ),

        // 14. Cabotegravir + Rilpivirine
        Drug(
            id = "d_cut_14",
            genericName = "Cabotegravir + Rilpivirine",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Long-Acting Integrase Strand Transfer Inhibitor (INSTI) + NNRTI",
            blackBoxWarning = null,
            indications = "Complete long-acting regimen for the treatment of HIV-1 infection in virologically suppressed adults and adolescents (viral load <50 copies/mL) with no history of virological failure and no known resistance to cabotegravir or rilpivirine.",
            doses = "Every 2-Month Dosing: Initiation on Month 1 and Month 2 with Cabotegravir 600 mg IM (3 mL) + Rilpivirine 900 mg IM (3 mL). Continue thereafter with Cabotegravir 600 mg IM + Rilpivirine 900 mg IM every 2 months (Month 4, 6, 8...). Optional 1-month oral lead-in with Cabotegravir 30mg OD + Rilpivirine 25mg OD.",
            administration = "Administer as two separate deep intramuscular (IM) gluteal injections by a healthcare provider at the same visit into opposite buttocks.",
            timing = "Every 2 months (within a +/- 7-day window).",
            specialInstructions = "Revolutionizes HIV treatment by eliminating daily pill burden. Adherence to bi-monthly injection visits is mandatory to prevent development of cross-resistance.",
            pkPd = "Extended-release crystal nanoparticle suspension. Slow absorption from gluteal muscle depot. Cabotegravir terminal half-life ~5.6 to 11.5 weeks; Rilpivirine terminal half-life ~13 to 28 weeks.",
            renalAdj = "Mild to moderate renal impairment: No adjustment. Severe renal impairment (CrCl <30 mL/min): Monitor closely.",
            hepaticAdj = "Mild to moderate hepatic impairment (Child-Pugh A or B): No adjustment. Severe impairment: Not studied.",
            pregnancy = "Category B (Limited human data; weigh viral suppression benefits against theoretical risks)",
            lactation = "Breastfeeding is not recommended for HIV-infected mothers to prevent mother-to-child transmission.",
            sideEffects = "Injection site reactions (pain, induration, nodule ~80%, mostly mild), pyrexia, fatigue, headache, insomnia, depression.",
            priceNpr = "NPR 45,000.00 - 65,000.00 per bi-monthly co-pack",
            priceInr = "INR 30,000.00 - 45,000.00 per bi-monthly co-pack",
            brandsNepal = listOf(
                BrandInfo("Cabenuva-Access", "National HIV Care Center Supply", "IM Suspension Kit", "600mg / 900mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cabenuva", "ViiV Healthcare / GSK India", "IM Suspension Co-pack", "600mg + 900mg"),
                BrandInfo("Vocabria + Rekambys", "Janssen / ViiV", "IM Co-pack", "600mg + 900mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Age >=12 years and weight >=35 kg: Same as adult regimen"
        ),

        // 15. Lenacapavir
        Drug(
            id = "d_cut_15",
            genericName = "Lenacapavir",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "First-in-Class HIV-1 Capsid Function Inhibitor",
            blackBoxWarning = null,
            indications = "Multidrug-resistant (MDR) HIV-1 infection in heavily treatment-experienced adults failing their current antiretroviral regimen; Pre-exposure prophylaxis (PrEP) to prevent sexual transmission of HIV-1 (6-monthly injection, Purpose trials).",
            doses = "Treatment Initiation: Day 1: 927 mg SC (two 1.5 mL injections) + 600 mg PO (two 300 mg tablets). Day 2: 600 mg PO. Maintenance: 927 mg SC (two 1.5 mL injections in abdomen) once every 6 months (26 weeks).",
            administration = "Administer SC into the abdomen by a healthcare professional (two separate 1.5 mL injections). Do not administer IV or IM.",
            timing = "Every 6 months (26 weeks).",
            specialInstructions = "Multi-stage capsid inhibitor: blocks capsid nuclear uptake, virus assembly, and core formation. Requires co-administration with an optimized background antiretroviral regimen in MDR HIV.",
            pkPd = "Subcutaneous crystal suspension depot. Sustained plasma concentrations over 6 months; terminal elimination half-life ~8 to 12 weeks. Metabolized primarily by CYP3A and UGT1A1.",
            renalAdj = "No dosage adjustment needed for mild, moderate, or severe renal impairment. Not studied in ESRD on dialysis.",
            hepaticAdj = "No adjustment needed for mild or moderate hepatic impairment (Child-Pugh A or B).",
            pregnancy = "Category B (Data limited; consult maternal-fetal medicine specialist)",
            lactation = "Avoid breastfeeding in HIV infection.",
            sideEffects = "Injection site reactions (nodules, induration, erythema, pain ~65%), nausea, headache, fatigue.",
            priceNpr = "NPR 180,000.00 - 260,000.00 per 6-month injection kit",
            priceInr = "INR 120,000.00 - 180,000.00 per 6-month injection kit",
            brandsNepal = listOf(
                BrandInfo("Sunlenca-Access", "Specialty HIV Referral Center", "SC Inj Kit", "927 mg / 3 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Sunlenca", "Gilead Sciences India", "SC Inj / Tab", "463.5 mg/1.5 mL / 300 mg Tab")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients"
        ),

        // 16. Maribavir
        Drug(
            id = "d_cut_16",
            genericName = "Maribavir",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Cytomegalovirus (CMV) pUL97 Protein Kinase Inhibitor (Oral Antiviral)",
            blackBoxWarning = null,
            indications = "Post-transplant Cytomegalovirus (CMV) infection or disease that is refractory or resistant to Ganciclovir, Valganciclovir, Foscarnet, or Cidofovir in adult and pediatric patients (≥12 years weighing ≥35 kg).",
            doses = "400 mg (two 200 mg tablets) PO twice daily for 8 weeks.",
            administration = "Take orally BID with or without food. Tablets can be swallowed whole or crushed and dispersed in water.",
            timing = "Every 12 hours with or without food.",
            specialInstructions = "DO NOT CO-ADMINISTER WITH GANCICLOVIR OR VALGANCICLOVIR: Maribavir competitively antagonizes the phosphorylation and antiviral activity of ganciclovir. Zero myelosuppression and zero nephrotoxicity compared to conventional CMV agents.",
            pkPd = "Inhibits UL97 viral protein kinase, blocking viral DNA maturation, encapsidation, and nuclear egress. Bioavailability ~30-40%. Highly protein bound (~98%). Elimination half-life ~3-5 hours. Metabolized by CYP3A4.",
            renalAdj = "No dosage adjustment required for any degree of renal impairment or hemodialysis.",
            hepaticAdj = "No dosage adjustment needed for mild to moderate hepatic impairment.",
            pregnancy = "Category C (Limited human data; weigh benefit against risk in life-threatening transplant CMV)",
            lactation = "Excreted into animal milk; avoid breastfeeding.",
            sideEffects = "Taste disturbance (dysgeusia / metallic taste ~46%), nausea, diarrhea, vomiting, fatigue.",
            priceNpr = "NPR 120,000.00 - 180,000.00 per 4-week bottle",
            priceInr = "INR 85,000.00 - 130,000.00 per bottle (56 tabs)",
            brandsNepal = listOf(
                BrandInfo("Livtencity-Named", "Organ Transplant Hospital Supply", "Tab", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Livtencity", "Takeda Pharmaceutical India", "Tab", "200 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Age >=12 years and weight >=35 kg: 400 mg PO BID"
        ),

        // 17. Sulbactam-Durlobactam
        Drug(
            id = "d_cut_17",
            genericName = "Sulbactam + Durlobactam",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Beta-Lactam Antibacterial + Novel Diazabicyclooctane (DBO) Beta-Lactamase Inhibitor",
            blackBoxWarning = null,
            indications = "Hospital-Acquired Bacterial Pneumonia (HABP) and Ventilator-Associated Bacterial Pneumonia (VABP) caused by susceptible isolates of Acinetobacter baumannii-calcoaceticus complex, including multidrug-resistant and carbapenem-resistant strains (CRAB).",
            doses = "Sulbactam 1 g + Durlobactam 1 g IV administered together over 3 hours every 6 hours for 7 to 14 days.",
            administration = "Administer by intravenous infusion over 3 hours through a dedicated line.",
            timing = "Every 6 hours (QID).",
            specialInstructions = "Breakthrough therapy specifically engineered to overcome Class A, C, and D (OXA-23, OXA-24/40, OXA-58) carbapenemase resistance in Acinetobacter. Durlobactam protects Sulbactam, restoring its intrinsic bactericidal PBP1/PBP3 activity.",
            pkPd = "Both agents exhibit low plasma protein binding (<10%). Excreted predominantly unchanged via glomerular filtration and active tubular secretion in urine. Elimination half-life ~1.5-2 hours.",
            renalAdj = "CrCl 45-129 mL/min: 1g/1g q6h. CrCl 30-44 mL/min: 1g/1g q8h. CrCl 15-29 mL/min: 1g/1g q12h. CrCl <15 mL/min / Hemodialysis: 1g/1g q24h on non-HD days, and administer after hemodialysis on HD days.",
            hepaticAdj = "No dosage adjustment needed (renal elimination).",
            pregnancy = "Category B (No evidence of teratogenicity in animal studies)",
            lactation = "Both components excreted in human milk in low amounts; monitor infant for candidiasis or diarrhea.",
            sideEffects = "Elevated liver enzymes (ALT/AST), diarrhea, hypokalemia, anemia, headache, phlebitis at infusion site.",
            priceNpr = "NPR 18,000.00 - 28,000.00 per vial (1g + 1g co-pack)",
            priceInr = "INR 12,000.00 - 19,000.00 per vial (1g + 1g co-pack)",
            brandsNepal = listOf(
                BrandInfo("Xacduro-Access", "Tertiary ICU Antimicrobial Supply", "Vial", "1g + 1g")
            ),
            brandsIndia = listOf(
                BrandInfo("Xacduro", "Entasis Therapeutics / Innoviva / Cipla", "Vial Co-pack", "1g Sulbactam + 1g Durlobactam")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients under 18 years"
        ),

        // 18. Eravacycline
        Drug(
            id = "d_cut_18",
            genericName = "Eravacycline",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Synthetic Fluorocycline Antibacterial (Tetracycline Class)",
            blackBoxWarning = null,
            indications = "Complicated Intra-Abdominal Infections (cIAI) caused by susceptible Gram-negative (ESBL E. coli, Klebsiella), Gram-positive (MRSA, VRE), and anaerobic microorganisms in adults aged ≥18 years.",
            doses = "1 mg/kg IV every 12 hours for 4 to 14 days.",
            administration = "Administer as an IV infusion over 60 minutes. Do not administer as IV bolus. Incompatible with alkaline solutions.",
            timing = "Every 12 hours (BID).",
            specialInstructions = "Engineered fluorocycline that overcomes classic tetracycline efflux pump and ribosomal protection resistance mechanisms. Not indicated for complicated urinary tract infections (cUTI) due to lower renal excretion.",
            pkPd = "Reversibly binds to 30S ribosomal subunit, inhibiting bacterial protein synthesis. Protein binding 79-90%. Metabolized predominantly by CYP3A4 and FMO. Terminal elimination half-life ~20 hours.",
            renalAdj = "No dosage adjustment required for renal impairment or hemodialysis.",
            hepaticAdj = "Mild to moderate hepatic impairment: No adjustment. Severe hepatic impairment (Child-Pugh C): 1 mg/kg IV q12h on Day 1, then reduce to 1 mg/kg IV q24h starting Day 2.",
            pregnancy = "Contraindicated / Teratogenic (Can cause permanent tooth discoloration and enamel hypoplasia during 2nd and 3rd trimesters).",
            lactation = "Avoid during breastfeeding due to potential adverse effects on infant bone and teeth development.",
            sideEffects = "Infusion site reactions, nausea, vomiting, diarrhea, hypotension, dizziness, thrombophlebitis.",
            priceNpr = "NPR 9,500.00 - 15,000.00 per vial (50mg)",
            priceInr = "INR 6,500.00 - 10,000.00 per vial (50mg)",
            brandsNepal = listOf(
                BrandInfo("Xerava-Import", "Hospital Critical Care Pharmacy", "Vial", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Xerava", "Tetraphase Pharmaceuticals / Everest Medicines", "Vial", "50 mg"),
                BrandInfo("Eravacycline", "Glenmark Pharmaceuticals", "Vial", "50 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Contraindicated in children <8 years due to tooth discoloration"
        ),

        // 19. Dalbavancin
        Drug(
            id = "d_cut_19",
            genericName = "Dalbavancin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Semi-Synthetic Second-Generation Lipoglycopeptide Antibacterial",
            blackBoxWarning = null,
            indications = "Acute Bacterial Skin and Skin Structure Infections (ABSSSI) caused by susceptible Gram-positive isolates, including Methicillin-Resistant Staphylococcus aureus (MRSA), Streptococcus pyogenes, and Enterococcus faecalis (vancomycin-susceptible).",
            doses = "Single-Dose Regimen: 1500 mg IV as a single infusion over 30 minutes.\nTwo-Dose Regimen: 1000 mg IV on Day 1, followed 1 week later by 500 mg IV on Day 8.",
            administration = "Administer by IV infusion over 30 minutes. Rapid infusion may cause 'Red Man'-like histamine reactions.",
            timing = "Single infusion or Day 1 and Day 8.",
            specialInstructions = "Ultra-long elimination half-life of 14.4 days allows single-dose outpatient treatment of severe MRSA cellulitis, abscesses, or wound infections, avoiding hospital admission or outpatient PICC line complications.",
            pkPd = "Binds to D-alanyl-D-alanine terminus of cell wall peptidoglycan, inhibiting transglycosylation and transpeptidation. Highly protein bound (~93%). Elimination half-life ~346 hours (14.4 days). Excreted unchanged in urine (~33%) and feces (~20%).",
            renalAdj = "eGFR <30 mL/min not on regular hemodialysis: Reduce single dose to 1125 mg IV (or 750 mg Day 1 + 375 mg Day 8). Regular hemodialysis: No dosage adjustment needed.",
            hepaticAdj = "No dosage adjustment needed for mild to moderate hepatic impairment.",
            pregnancy = "Category C (Limited human data; use only if potential benefit justifies potential risk)",
            lactation = "Excreted into animal milk; considerations should be given to maternal need.",
            sideEffects = "Nausea, headache, diarrhea, rash, pruritus, infusion-related flushing, elevated ALT/AST.",
            priceNpr = "NPR 110,000.00 - 160,000.00 per 500mg vial",
            priceInr = "INR 75,000.00 - 110,000.00 per 500mg vial",
            brandsNepal = listOf(
                BrandInfo("Dalbavancin-Import", "Hospital Tertiary Pharmacy", "Vial", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Dalvance", "AbbVie / Allergan India", "Vial", "500 mg"),
                BrandInfo("Xydalba", "Correvio / Sun Pharma", "Vial", "500 mg")
            ),
            pediatricDosePerKg = 18.0,
            pediatricInterval = "Pediatric weight-based single dose (18-22.5 mg/kg, max 1500mg)"
        ),

        // 20. Rezafungin
        Drug(
            id = "d_cut_20",
            genericName = "Rezafungin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Once-Weekly Next-Generation Echinocandin Antifungal",
            blackBoxWarning = null,
            indications = "Treatment of candidemia and invasive candidiasis in adult patients with limited or no alternative treatment options.",
            doses = "Week 1 (Day 1): 400 mg IV loading dose administered over 1 hour. Week 2 (Day 8): 200 mg IV maintenance dose over 1 hour. Continue 200 mg IV once weekly thereafter for a minimum of 14 days after the last negative blood culture.",
            administration = "Administer by slow intravenous infusion over 60 minutes. Do not administer IV push or bolus.",
            timing = "Once weekly on the same day each week.",
            specialInstructions = "Structurally stabilized echinocandin with an ether bond preventing chemical degradation, granting an extended elimination half-life of ~133 hours. Enables once-weekly dosing, facilitating early hospital discharge for invasive candidiasis.",
            pkPd = "Non-competitive inhibitor of 1,3-beta-D-glucan synthase, disrupting fungal cell wall integrity. Highly protein bound (>97%). Terminal elimination half-life ~133 hours. Minimal renal or CYP metabolism.",
            renalAdj = "No dosage adjustment required for any degree of renal impairment or hemodialysis.",
            hepaticAdj = "No dosage adjustment required for mild, moderate, or severe hepatic impairment.",
            pregnancy = "Category C (Animal studies showed embryo-fetal toxicity; avoid in pregnancy unless benefits outweigh risks)",
            lactation = "Present in animal milk; weigh clinical need against risk to infant.",
            sideEffects = "Hypokalemia, pyrexia, diarrhea, anemia, vomiting, nausea, hypomagnesemia, infusion-related flushing.",
            priceNpr = "NPR 140,000.00 - 190,000.00 per vial (200mg)",
            priceInr = "INR 95,000.00 - 140,000.00 per vial (200mg)",
            brandsNepal = listOf(
                BrandInfo("Rezzayo-Named", "Hospital Critical Care ICU", "Vial", "200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Rezzayo", "Melinta Therapeutics / Cidara / Cipla", "Vial", "200 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients under 18 years"
        ),

        // 21. Icatibant
        Drug(
            id = "d_cut_21",
            genericName = "Icatibant",
            system = "Emergency & Critical Care",
            drugClass = "Synthetic Bradykinin B2 Receptor Antagonist",
            blackBoxWarning = null,
            indications = "Acute attacks of Hereditary Angioedema (HAE) in adult and pediatric patients aged ≥2 years with C1-esterase inhibitor deficiency or dysfunction; ACE-inhibitor-induced angioedema with airway compromise (off-label emergency use).",
            doses = "Adult: 30 mg subcutaneously (SC) injected into the abdominal area. If symptoms persist or recur, additional 30 mg injections may be administered at intervals of at least 6 hours (max 3 injections in 24 hours).\nPediatric (>=2 yr): Weight-based dose: 12-25 kg = 10 mg; 26-40 kg = 15 mg; 41-50 kg = 20 mg; 51-65 kg = 25 mg; >65 kg = 30 mg SC.",
            administration = "Administer by slow subcutaneous injection in the abdominal area. Patients can self-administer after proper training.",
            timing = "Immediately at onset of angioedema attack.",
            specialInstructions = "Blocks binding of excess bradykinin to vascular B2 receptors, rapidly terminating capillary hyperpermeability and laryngeal/subcutaneous swelling. If laryngeal angioedema is present, patient must seek immediate emergency medical care.",
            pkPd = "Synthetic decapeptide with high affinity and selectivity for B2 receptor. Rapid absorption; peak plasma concentration within 30 minutes. Elimination half-life ~1.4 hours. Metabolized by proteolytic enzymes.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category B (Limited human data; in acute life-threatening laryngeal edema, benefit clearly outweighs risk)",
            lactation = "Excreted into animal milk; avoid breastfeeding for 12 hours post-injection.",
            sideEffects = "Injection site reactions (erythema, swelling, burning, pruritus in >95% of patients, resolves in hours), nausea, headache, dizziness.",
            priceNpr = "NPR 75,000.00 - 110,000.00 per pre-filled syringe (30mg/3mL)",
            priceInr = "INR 48,000.00 - 75,000.00 per pre-filled syringe (30mg/3mL)",
            brandsNepal = listOf(
                BrandInfo("Firazyr-Emergency", "National Emergency Angioedema Stock", "PFS", "30 mg / 3 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Firazyr", "Takeda Pharmaceutical India / Shire", "Pre-filled Syringe", "30 mg / 3 mL"),
                BrandInfo("Icatibant", "Cipla Ltd.", "PFS", "30 mg / 3 mL")
            ),
            pediatricDosePerKg = 0.4,
            pediatricInterval = "Weight-based 10-25 mg SC stat for age >=2 years"
        ),

        // 22. Lanadelumab
        Drug(
            id = "d_cut_22",
            genericName = "Lanadelumab",
            system = "Dermatology",
            drugClass = "Fully Human Plasma Kallikrein Inhibitor Monoclonal Antibody",
            blackBoxWarning = null,
            indications = "Routine prophylaxis to prevent attacks of Hereditary Angioedema (HAE) in adult and pediatric patients aged ≥2 years.",
            doses = "Adult and adolescents (≥12 years): 300 mg subcutaneously (SC) once every 2 weeks. If attack-free for >6 months and well controlled, dose reduction to 300 mg SC every 4 weeks may be considered. Pediatric (2 to <6 years): 150 mg SC every 4 weeks. Pediatric (6 to <12 years): 150 mg SC every 2-3 weeks.",
            administration = "Administer by subcutaneous injection into the abdomen, thigh, or upper arm.",
            timing = "Every 2 weeks (or every 4 weeks if well-controlled).",
            specialInstructions = "Long-acting fully human IgG1 kappa antibody that binds and neutralizes active plasma kallikrein, preventing high-molecular-weight kininogen (HMWK) cleavage into bradykinin, achieving >85-90% reduction in HAE attack frequency.",
            pkPd = "Bioavailability ~65-75%. Peak concentration ~4-5 days. Terminal elimination half-life ~14-15 days. Cleared via non-specific catabolic proteolysis.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category B (Data in pregnant women are limited; uncontrolled HAE carries high maternal mortality)",
            lactation = "Present in breast milk in small amounts; compatible with infant monitoring.",
            sideEffects = "Injection site pain and erythema, upper respiratory infection, headache, rash, myalgia, elevated ALT/AST.",
            priceNpr = "NPR 320,000.00 - 450,000.00 per vial (300mg/2mL)",
            priceInr = "INR 220,000.00 - 320,000.00 per vial (300mg/2mL)",
            brandsNepal = listOf(
                BrandInfo("Takhzyro-Import", "Hospital Allergy Immunology Supply", "Vial", "300 mg / 2 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Takhzyro", "Takeda Pharmaceutical India / Shire", "Pre-filled Syringe / Vial", "300 mg / 2 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Age 2-6: 150mg q4w; Age 6-12: 150mg q2-3w; Age >=12: 300mg q2w"
        ),

        // 23. Elexacaftor + Tezacaftor + Ivacaftor (Trikafta)
        Drug(
            id = "d_cut_23",
            genericName = "Elexacaftor + Tezacaftor + Ivacaftor",
            system = "Respiratory System (RS)",
            drugClass = "Cystic Fibrosis Transmembrane Conductance Regulator (CFTR) Potentiator & Correctors",
            blackBoxWarning = null,
            indications = "Cystic Fibrosis (CF) in patients aged ≥2 years who have at least one F508del mutation in the CFTR gene or a mutation that is responsive based on in vitro data.",
            doses = "Adult and pediatric ≥12 years (or weight ≥30 kg): Morning: Two fixed-dose combination tablets (each containing Elexacaftor 100 mg / Tezacaftor 50 mg / Ivacaftor 75 mg). Evening: One Ivacaftor 150 mg tablet (taken approximately 12 hours later with fat-containing food).",
            administration = "Take morning and evening doses approximately 12 hours apart with fat-containing food (e.g. eggs, butter, peanut butter, whole milk, cheese) to maximize oral absorption.",
            timing = "Morning (Triple combo) and Evening (Ivacaftor single).",
            specialInstructions = "Assess baseline LFTs (ALT, AST, Bilirubin) before starting, every 3 months for the first year, and annually thereafter. Requires ophthalmological exam in pediatrics for cataract surveillance.",
            pkPd = "Elexacaftor and Tezacaftor act as CFTR correctors that bind to different sites on CFTR protein, facilitating cellular processing and cell-surface trafficking. Ivacaftor acts as a CFTR potentiator that increases chloride channel gating open probability. Extensively metabolized by CYP3A4.",
            renalAdj = "Mild to moderate renal impairment: No adjustment. Severe renal impairment (eGFR <30 mL/min): Use with caution.",
            hepaticAdj = "Moderate hepatic impairment (Child-Pugh B): Reduce dose (e.g. alternate day morning dosing). Severe hepatic impairment (Child-Pugh C): Not recommended.",
            pregnancy = "Category B (Weigh maternal pulmonary stabilization against limited fetal exposure data)",
            lactation = "Present in breast milk; monitor infant for hepatic transaminases and cataracts.",
            sideEffects = "Headache, upper respiratory tract infection, abdominal pain, diarrhea, elevated transaminases, rash, rhinorrhea.",
            priceNpr = "NPR 350,000.00 - 480,000.00 for 28-day box",
            priceInr = "INR 240,000.00 - 330,000.00 for 28-day box",
            brandsNepal = listOf(
                BrandInfo("Trikafta-Named", "Pediatric Pulmonology Referral Supply", "Box", "Fixed Pack")
            ),
            brandsIndia = listOf(
                BrandInfo("Trikafta", "Vertex Pharmaceuticals / Cipla Named Patient", "Co-packaged Tablets", "100/50/75mg + 150mg"),
                BrandInfo("Trioftor", "Hetero Healthcare", "Tablets", "Triple pack")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Age 2-5: Granules; Age 6-11: Pediatric tab strength; Age >=12: Adult dose"
        ),

        // 24. Luspatercept
        Drug(
            id = "d_cut_24",
            genericName = "Luspatercept",
            system = "Central Nervous System (CNS)",
            drugClass = "Recombinant Fusion Protein Erythroid Maturation Agent (TGF-Beta Ligand Trap)",
            blackBoxWarning = null,
            indications = "Anemia in adult patients with transfusion-dependent Beta-Thalassemia; Anemia associated with Very Low- to Intermediate-Risk Myelodysplastic Syndromes (MDS) with ring sideroblasts (MDS-RS) or with myelodysplastic/myeloproliferative neoplasm with ring sideroblasts and thrombocytosis (MDS/MPN-RS-T) requiring RBC transfusions.",
            doses = "Beta-Thalassemia: Initial 1.0 mg/kg subcutaneously (SC) once every 3 weeks. If transfusion burden is not reduced after >=2 consecutive doses (6 weeks), titrate up to 1.25 mg/kg SC q3w (max dose). MDS: Initial 1.0 mg/kg SC q3w; can titrate to 1.33 mg/kg, then max 1.75 mg/kg SC q3w.",
            administration = "Administer by subcutaneous injection into the upper arm, thigh, or abdomen. Reconstitute with Sterile Water for Injection.",
            timing = "Once every 3 weeks.",
            specialInstructions = "Traps TGF-beta superfamily ligands (GDF-11, activin B), inhibiting Smad2/3 signaling and allowing late-stage erythroblast differentiation, significantly reducing blood transfusion dependency and iron overload in beta-thalassemia and MDS.",
            pkPd = "Peak concentration ~7 days post-SC injection. Mean terminal elimination half-life ~11-13 days. Undergoes general catabolic degradation into amino acids.",
            renalAdj = "Mild to moderate renal impairment: No adjustment. Severe renal impairment: Limited data.",
            hepaticAdj = "No dosage adjustment needed (protein catabolism).",
            pregnancy = "Category D / Teratogenic (Can cause embryo-fetal harm; pregnancy testing required prior to initiation; effective contraception required during and for 3 months post-treatment).",
            lactation = "Discontinue breastfeeding during treatment and for 3 months after the final dose.",
            sideEffects = "Fatigue, headache, musculoskeletal pain, arthralgia, dizziness, hypertension, hyperuricemia, thromboembolic events.",
            priceNpr = "NPR 180,000.00 - 260,000.00 per vial (75mg)",
            priceInr = "INR 125,000.00 - 180,000.00 per vial (75mg)",
            brandsNepal = listOf(
                BrandInfo("Reblozyl-Import", "Hematology Daycare Unit", "Vial", "25 mg / 75 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Reblozyl", "Bristol Myers Squibb / Celgene India", "Vial", "25 mg / 75 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients"
        ),

        // 25. Difelikefalin
        Drug(
            id = "d_cut_25",
            genericName = "Difelikefalin",
            system = "Renal & Genitourinary",
            drugClass = "Peripherally Restricted Selective Kappa-Opioid Receptor (KOR) Agonist",
            blackBoxWarning = null,
            indications = "Moderate-to-severe pruritus (uremic pruritus / chronic kidney disease-associated pruritus [CKD-aP]) in adult patients undergoing hemodialysis.",
            doses = "0.5 mcg/kg of dry body weight administered as an IV bolus into the venous line of the hemodialysis circuit at the end of each hemodialysis treatment (3 times weekly).",
            administration = "Administer as an IV bolus into the venous return line at the conclusion of hemodialysis during rinse-back or after rinse-back.",
            timing = "Three times weekly post-hemodialysis.",
            specialInstructions = "Peripherally restricted D-amino acid synthetic peptide that activates kappa-opioid receptors on peripheral sensory neurons and immune cells with minimal CNS penetration, providing robust antipruritic relief without classical mu-opioid dependence or respiratory depression.",
            pkPd = "Hydrophilic peptide with minimal blood-brain barrier penetration. Highly protein bound (24-32% unbound). Cleared primarily by hemodialysis (~70-80% removed per dialysis session); terminal half-life between dialyses ~23-44 hours.",
            renalAdj = "Indicated specifically for end-stage renal disease (ESRD) patients on regular maintenance hemodialysis.",
            hepaticAdj = "No dosage adjustment needed for mild to moderate hepatic impairment.",
            pregnancy = "Category B (Limited human data; weigh maternal symptom relief against potential fetal risk)",
            lactation = "Present in animal milk; weigh clinical benefit against potential infant exposure.",
            sideEffects = "Somnolence (drowsiness ~7%), dizziness, diarrhea, hyperkalemia, gait disturbance, headache.",
            priceNpr = "NPR 4,500.00 - 7,000.00 per single-use vial (50mcg/mL)",
            priceInr = "INR 3,000.00 - 4,800.00 per vial (50mcg/mL)",
            brandsNepal = listOf(
                BrandInfo("Korsuva-Dialysis", "National Dialysis Center Supply", "Vial", "50 mcg / mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Korsuva", "Vifor Fresenius Medical Care Renal Pharma / Cara", "Vial", "50 mcg / mL"),
                BrandInfo("Kapruvi", "Fresenius Medical Care India", "Vial", "50 mcg / mL")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "0.5 mcg/kg post-dialysis bolus (investigational in pediatrics)"
        ),

        // 26. Zuranolone
        Drug(
            id = "d_cut_26",
            genericName = "Zuranolone",
            system = "Central Nervous System (CNS)",
            drugClass = "Neuroactive Steroid Positive Allosteric Modulator of GABA-A Receptors",
            blackBoxWarning = "IMPAIRED ABILITY TO DRIVE AND OPERATE MACHINERY: Can cause CNS depression and somnolence. Patients should not drive a motor vehicle or engage in other potentially hazardous activities requiring complete mental alertness for at least 12 hours after taking each dose during the 14-day treatment course.",
            indications = "Postpartum Depression (PPD) in adult women.",
            doses = "50 mg PO once daily in the evening with a fat-containing meal for exactly 14 days. If somnolence occurs, reduce dose to 40 mg PO OD in the evening.",
            administration = "Take orally once daily in the evening with a fat-containing meal (e.g. 400-1000 calories with 25-50% fat) for 14 consecutive days.",
            timing = "Evening at bedtime with fat-containing dinner.",
            specialInstructions = "Rapid-acting 14-day oral course mimicking allopregnanolone that resets dysregulated synaptic and extrasynaptic GABA-A receptor tone post-childbirth, achieving clinical depression remission within 3 to 15 days.",
            pkPd = "Bioavailability enhanced ~4-fold with fatty meal. Peak plasma concentration ~5-6 hours. Terminal elimination half-life ~19-24 hours. Metabolized predominantly by CYP3A4.",
            renalAdj = "Moderate to severe renal impairment (eGFR <60 mL/min): Initial dose 30 mg PO once daily in evening for 14 days.",
            hepaticAdj = "Severe hepatic impairment (Child-Pugh C): 30 mg PO once daily in evening for 14 days. No adjustment for mild/moderate.",
            pregnancy = "Contraindicated / Teratogenic (Can cause fetal harm; effective non-hormonal or barrier contraception required during treatment and for 1 week post-treatment).",
            lactation = "Transferred into breast milk in very low amounts (relative infant dose <1%); consider benefits of breastfeeding and maternal recovery.",
            sideEffects = "Somnolence, dizziness, sedation, fatigue, nasopharyngitis, urinary tract infection, diarrhea.",
            priceNpr = "NPR 140,000.00 - 190,000.00 per complete 14-day blister pack",
            priceInr = "INR 95,000.00 - 140,000.00 per 14-day pack",
            brandsNepal = listOf(
                BrandInfo("Zurzuvae-Access", "Psychiatry Referral Pharmacy", "Cap", "20 mg / 30 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Zurzuvae", "Sage Therapeutics / Biogen India", "Cap", "20 mg / 30 mg / 50 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients"
        ),

        // 27. Lecanemab
        Drug(
            id = "d_cut_27",
            genericName = "Lecanemab",
            system = "Central Nervous System (CNS)",
            drugClass = "Humanized Anti-Amyloid Beta Protofibril Monoclonal Antibody",
            blackBoxWarning = "AMYLOID-RELATED IMAGING ABNORMALITIES (ARIA): Monoclonal antibodies targeting amyloid-beta can cause ARIA, presenting as ARIA with edema/sulcal effusion (ARIA-E) and ARIA with hemosiderin deposition (ARIA-H, including microhemorrhages and superficial siderosis). Obtain a baseline brain MRI within one year prior to initiating treatment and pre-infusion monitoring MRIs prior to the 5th, 7th, and 14th infusions. APOE epsilon 4 homozygotes have a higher incidence of ARIA; testing for APOE epsilon 4 status is recommended prior to initiation.",
            indications = "Treatment of Alzheimer's Disease in patients with Mild Cognitive Impairment (MCI) or mild dementia stage of disease with confirmed presence of amyloid-beta pathology (via CSF or amyloid PET).",
            doses = "10 mg/kg IV administered once every 2 weeks.",
            administration = "Administer by intravenous infusion over approximately 1 hour using an in-line 0.2-micron filter. Observe for infusion-related reactions for 3 hours post-infusion during initial doses.",
            timing = "Every 2 weeks.",
            specialInstructions = "Selectively binds to soluble amyloid-beta protofibrils (the most neurotoxic species) and plaques, accelerating microglial clearance and demonstrating a 27% reduction in cognitive decline over 18 months in the Clarity AD trial. Use caution with concurrent anticoagulants due to ARIA-H hemorrhage risks.",
            pkPd = "Humanized IgG1 monoclonal antibody. Steady state reached by 6 weeks. Terminal elimination half-life ~5-7 days. Catabolized into amino acids.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category C (Not applicable to intended geriatric population)",
            lactation = "Not applicable to intended population.",
            sideEffects = "Infusion-related reactions (fever, flu-like symptoms ~26%), ARIA-E (brain edema ~12.6%), ARIA-H (microhemorrhages ~17%), headache, superficial siderosis.",
            priceNpr = "NPR 350,000.00 - 480,000.00 per monthly treatment",
            priceInr = "INR 240,000.00 - 340,000.00 per monthly treatment",
            brandsNepal = listOf(
                BrandInfo("Leqembi-NamedPatient", "Neurology Tertiary Memory Clinic", "Vial", "200 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Leqembi", "Eisai Pharmaceuticals India / Biogen", "Vial", "200 mg/2 mL / 500 mg/5 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Not indicated for pediatric use"
        ),

        // 28. Donanemab
        Drug(
            id = "d_cut_28",
            genericName = "Donanemab",
            system = "Central Nervous System (CNS)",
            drugClass = "Humanized Anti-N3pG Amyloid Beta Plaque Monoclonal Antibody",
            blackBoxWarning = "AMYLOID-RELATED IMAGING ABNORMALITIES (ARIA): Causes ARIA-E (brain edema/effusion) and ARIA-H (microhemorrhages and superficial siderosis). Perform baseline brain MRI and monitoring MRIs prior to infusions 2, 3, 4, and 7. Serious, life-threatening, and fatal cases of ARIA have occurred. Increased risk in APOE epsilon 4 homozygotes.",
            indications = "Treatment of early symptomatic Alzheimer's Disease (Mild Cognitive Impairment or mild dementia stage) with confirmed amyloid pathology.",
            doses = "Initial: 700 mg IV infusion every 4 weeks for the first 3 doses (Weeks 0, 4, 8). Maintenance: 1400 mg IV infusion every 4 weeks starting at Week 12. Treatment may be stopped if amyloid plaque clearance is confirmed on follow-up amyloid PET imaging.",
            administration = "Administer as an IV infusion over 30 minutes using a dedicated line with a 0.2-micron in-line filter.",
            timing = "Every 4 weeks (monthly).",
            specialInstructions = "Specifically targets N-terminally truncated pyroglutamate amyloid-beta (N3pG-Abeta) present exclusively in established brain amyloid plaques, achieving profound plaque clearance (>80% of patients achieving complete plaque clearance, allowing treatment cessation in TRAILBLAZER-ALZ 2).",
            pkPd = "Humanized IgG1 monoclonal antibody. Steady state reached after 3 doses. Elimination half-life ~10-12 days. Cleared via general reticuloendothelial proteolysis.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category C (Not applicable to population)",
            lactation = "Not applicable to population.",
            sideEffects = "ARIA-E (brain swelling ~24%), ARIA-H (microbleeds ~31%), headache, infusion-related reactions, nausea.",
            priceNpr = "NPR 380,000.00 - 520,000.00 per monthly dose",
            priceInr = "INR 260,000.00 - 360,000.00 per monthly dose",
            brandsNepal = listOf(
                BrandInfo("Kisunla-NamedAccess", "Tertiary Neuro Center Supply", "Vial", "350 mg / 20 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Kisunla", "Eli Lilly and Company India", "Vial", "350 mg / 20 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Not indicated in pediatrics"
        ),

        // 29. Tafamidis
        Drug(
            id = "d_cut_29",
            genericName = "Tafamidis",
            system = "Cardiovascular System (CVS)",
            drugClass = "Transthyretin (TTR) Kinetic Stabilizer (Cardiomyopathy Agent)",
            blackBoxWarning = null,
            indications = "Cardiomyopathy of wild-type or hereditary Transthyretin-Mediated Amyloidosis (ATTR-CM) in adults to reduce all-cause mortality and cardiovascular-related hospitalizations.",
            doses = "Tafamidis Free Acid (Vyndamax): 61 mg PO once daily.\nTafamidis Meglumine (Vyndaqel): 80 mg PO once daily (four 20 mg capsules).",
            administration = "Take orally once daily with or without food. Swallow capsules whole; do not crush or cut.",
            timing = "Once daily morning with water.",
            specialInstructions = "Binds selectively to the two thyroxine-binding sites on the tetrameric transthyretin protein, kinetically stabilizing the tetramer and slowing dissociation into amyloidogenic monomers, preventing myocardial amyloid fibril deposition. Reduces all-cause mortality by 30% in ATTR-CM (ATTR-ACT trial).",
            pkPd = "High oral bioavailability (~100%). Peak concentration ~4 hours. Highly protein bound (>99%). Terminal elimination half-life ~49 hours. Excreted in feces (~59%) and urine (~22%).",
            renalAdj = "No dosage adjustment required for renal impairment or hemodialysis.",
            hepaticAdj = "Moderate hepatic impairment (Child-Pugh B): No adjustment. Severe hepatic impairment (Child-Pugh C): Limited data; monitor.",
            pregnancy = "Category C (Can cause fetal harm; effective contraception recommended in women of childbearing potential)",
            lactation = "Excreted into animal milk; avoid breastfeeding during treatment.",
            sideEffects = "Diarrhea, urinary tract infection, abdominal pain, asthenia, flatulence.",
            priceNpr = "NPR 160,000.00 - 240,000.00 per 30-day box",
            priceInr = "INR 110,000.00 - 170,000.00 per 30-day box",
            brandsNepal = listOf(
                BrandInfo("Vyndamax-Special", "National Cardiac Center Specialty", "Cap", "61 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Vyndamax", "Pfizer Products India", "Cap", "61 mg"),
                BrandInfo("Vyndaqel", "Pfizer Products India", "Cap", "20 mg (80mg daily)"),
                BrandInfo("Tafamist", "Sun Pharma", "Cap", "61 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients"
        ),

        // 30. Vutrisiran
        Drug(
            id = "d_cut_30",
            genericName = "Vutrisiran",
            system = "Central Nervous System (CNS)",
            drugClass = "Transthyretin (TTR)-Directed Small Interfering RNA (siRNA)",
            blackBoxWarning = null,
            indications = "Polyneuropathy of Hereditary Transthyretin-Mediated Amyloidosis (hATTR-PN) in adult patients; Transthyretin Amyloid Cardiomyopathy (ATTR-CM, HELIOS-B trial).",
            doses = "25 mg administered subcutaneously (SC) once every 3 months (quarterly). Supplement with recommended daily allowance of Vitamin A (approx 2500-3000 IU/day).",
            administration = "Administer by subcutaneous injection into the abdomen, thighs, or upper arm by a healthcare professional.",
            timing = "Once every 3 months (quarterly).",
            specialInstructions = "Chemically stabilized N-acetylgalactosamine (GalNAc)-conjugated double-stranded siRNA that targets hepatocytes via asialoglycoprotein receptors, catalytically cleaving mutant and wild-type TTR mRNA and suppressing serum TTR by >80-85%. Requires oral Vitamin A supplementation because TTR transports retinol-binding protein.",
            pkPd = "Subcutaneous bioavailability ~100%. Rapidly cleared from plasma (half-life ~5 hours) due to targeted uptake into liver parenchymal cells. Extended intracellular duration of action allowing quarterly dosing.",
            renalAdj = "Mild to moderate renal impairment: No adjustment. Severe renal impairment: Limited data; use with caution.",
            hepaticAdj = "No dosage adjustment needed for mild hepatic impairment. Not studied in moderate/severe hepatic impairment.",
            pregnancy = "Category C (Decreases maternal serum Vitamin A; excessive or deficient Vitamin A levels during pregnancy carry teratogenic risks)",
            lactation = "No data on human milk excretion; weigh clinical need against infant risk.",
            sideEffects = "Arthralgia, pain in extremity, dyspnea, injection site reactions, decrease in serum Vitamin A levels.",
            priceNpr = "NPR 380,000.00 - 550,000.00 per quarterly pre-filled syringe (25mg/0.5mL)",
            priceInr = "INR 260,000.00 - 380,000.00 per quarterly syringe (25mg/0.5mL)",
            brandsNepal = listOf(
                BrandInfo("Amvuttra-Special", "Neurology Tertiary Specialty Supply", "PFS", "25 mg / 0.5 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Amvuttra", "Alnylam Pharmaceuticals / Sanofi India", "Pre-filled Syringe", "25 mg / 0.5 mL")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "Safety not established in pediatric patients"
        )
    )
}
