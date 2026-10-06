package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object CardioGastroRespiratoryDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // CARDIOVASCULAR & HEMATOLOGY
        // ==========================================
        Drug(
            id = "d_cardio_clonidine",
            genericName = "Clonidine Hydrochloride",
            system = "Cardiovascular System (CVS)",
            drugClass = "Centrally Acting Alpha-2 Adrenergic Agonist",
            blackBoxWarning = null,
            indications = "Hypertensive urgency, severe refractory hypertension, opioid withdrawal syndrome, attention deficit hyperactivity disorder (ADHD), severe chronic pain (epidural).",
            doses = "Hypertensive Urgency: 0.1-0.2 mg PO stat, then 0.1 mg hourly prn (max 0.6 mg). Maintenance: 0.1-0.3 mg PO BID (max 1.2 mg/day). Opioid Withdrawal: 0.1-0.2 mg PO TID.",
            administration = "Take orally with or without food. Never discontinue abruptly.",
            timing = "Morning and evening; larger dose at bedtime to minimize daytime sedation.",
            specialInstructions = "AVOID ABRUPT CESSATION: Can trigger severe rebound hypertensive crisis with catecholamine surge, sweating, tremors, and stroke. Taper gradually over 2 to 4 days.",
            pkPd = "Oral bioavailability 75-95%. Highly lipid soluble; rapid CNS penetration. 50% metabolized by liver; 50% excreted unchanged in urine. Half-life 12-16 hours.",
            renalAdj = "CrCl <10 mL/min: Reduce starting dose by 50-75% and titrate carefully.",
            hepaticAdj = "No formal adjustment needed; monitor for excessive sedation.",
            pregnancy = "Category C (Crosses placenta; methyldopa preferred in pregnancy).",
            lactation = "Excreted in breast milk; can cause neonatal drowsiness and hypotension.",
            sideEffects = "Dry mouth (xerostomia >40%), profound sedation/drowsiness, dizziness, constipation, bradycardia, orthostatic hypotension, rebound hypertension.",
            priceNpr = "NPR 25.00 - 55.00 per strip of 10 (100 mcg)",
            priceInr = "INR 15.00 - 35.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Catapres", "Boehringer Ingelheim / Nepal", "Tab", "150 mcg"),
                BrandInfo("Arkamin", "Torrent Pharmaceuticals Nepal", "Tab", "100 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Arkamin", "Torrent", "Tab", "100 mcg"),
                BrandInfo("Catapres", "Boehringer Ingelheim", "Tab", "150 mcg")
            ),
            adultDose = "0.1 mg PO BID; acute urgency 0.1 mg stat then hourly.",
            contraindications = "Severe bradyarrhythmias, sick sinus syndrome, 2nd or 3rd degree AV block, severe depression.",
            modeOfAction = "Stimulates presynaptic alpha-2 adrenoceptors in the brainstem (rostral ventrolateral medulla), decreasing sympathetic outflow and peripheral vascular resistance.",
            therapeuticClassTag = "Anti-HTN / Central Sympatholytics"
        ),

        Drug(
            id = "d_cardio_methyldopa",
            genericName = "Methyldopa",
            system = "Cardiovascular System (CVS)",
            drugClass = "Centrally Acting Alpha-2 Agonist Antihypertensive",
            blackBoxWarning = null,
            indications = "Chronic hypertension in pregnancy, gestational hypertension, mild-to-moderate pre-eclampsia (gold-standard first-line maintenance agent with long-term fetal safety data).",
            doses = "Adult (Pregnancy): Start 250 mg PO BID or TID; titrate every 2-3 days by 250-500 mg up to max 2000-3000 mg/day divided TID or QID (usual effective dose 500-1000 mg/day).",
            administration = "Take orally with or after food at consistent intervals.",
            timing = "Two to three times daily.",
            specialInstructions = "Check baseline CBC and LFTs. Monitor for drug-induced autoimmune hemolytic anemia (positive direct Coombs test in 10-20%) and drug-induced hepatitis.",
            pkPd = "Bioavailability ~50%. Converted centrally to active alpha-methylnorepinephrine. Elimination half-life 1.5-2 hours, but biological duration 12-24 hours due to active metabolite in synaptic vesicles.",
            renalAdj = "CrCl 10-50 mL/min: Dose q8-12h. CrCl <10 mL/min: Dose q12-24h.",
            hepaticAdj = "Contraindicated in active hepatic disease (hepatitis, cirrhosis).",
            pregnancy = "Category B (Longest safety record in obstetrics; first-line for maternal hypertension).",
            lactation = "Excreted in small amounts in breast milk; considered compatible with breastfeeding by AAP.",
            sideEffects = "Sedation, drowsiness, depression, dry mouth, nasal congestion, fluid retention, positive Coombs test, drug-induced lupus, galactorrhea (hyperprolactinemia).",
            priceNpr = "NPR 45.00 - 95.00 per strip of 10 (250mg)",
            priceInr = "INR 30.00 - 65.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Aldomet", "Aspen / Medisales Nepal", "Tab", "250 mg"),
                BrandInfo("Alphadopa", "Wockhardt Nepal", "Tab", "250 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Aldomet", "Aspen", "Tab", "250 mg"),
                BrandInfo("Alphadopa", "Wockhardt", "Tab", "250 / 500 mg")
            ),
            adultDose = "250-500 mg PO BID-TID (max 3 g/day).",
            contraindications = "Active liver disease, history of methyldopa-induced liver disorders or hemolytic anemia, concurrent MAO inhibitor therapy, pheochromocytoma.",
            modeOfAction = "Decarboxylated in central adrenergic neurons to alpha-methylnorepinephrine, which stimulates central inhibitory alpha-2 adrenoceptors, reducing central sympathetic outflow.",
            therapeuticClassTag = "Anti-HTN / Pregnancy Safe"
        ),

        Drug(
            id = "d_cardio_isosorbide_mono",
            genericName = "Isosorbide Mononitrate (Sustained Release)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Long-Acting Organic Nitrate Antianginal Vasodilator",
            blackBoxWarning = null,
            indications = "Prevention and long-term prophylactic management of chronic stable angina pectoris due to coronary artery disease.",
            doses = "Sustained Release: 30-60 mg PO once daily in morning (max 120-240 mg OD). Immediate Release: 20 mg PO BID taken 7 hours apart (e.g. 08:00 AM and 03:00 PM).",
            administration = "Take in morning with a glass of water. Swallow extended-release tablets whole; do not crush or chew.",
            timing = "Once daily in the morning upon waking.",
            specialInstructions = "STRICT NITRATE-FREE INTERVAL (10-14 hours) mandatory to prevent nitrate tolerance (tachyphylaxis). ABSOLUTE CONTRAINDICATION with PDE-5 inhibitors (Sildenafil, Tadalafil) - causes fatal refractory hypotension.",
            pkPd = "100% oral bioavailability; does not undergo first-pass hepatic metabolism (unlike isosorbide dinitrate). Half-life ~5 hours; sustained-release maintains clinical effect over 12 hours.",
            renalAdj = "No dosage adjustment necessary in renal failure or hemodialysis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safety in human pregnancy not well established; use beta-blockers or calcium blockers first).",
            lactation = "Excretion in breast milk unknown; use with caution.",
            sideEffects = "Throbbing nitrate headache (>50% at therapy initiation), postural hypotension, reflex tachycardia, facial flushing, syncope, lightheadedness.",
            priceNpr = "NPR 55.00 - 120.00 per strip of 10 (30mg / 60mg SR)",
            priceInr = "INR 35.00 - 80.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Monotrate", "Sun Pharma Nepal", "Tab", "20 mg / 40 mg / 60 mg SR"),
                BrandInfo("Ismo", "Abbott Nepal", "Tab", "20 mg / 40 mg"),
                BrandInfo("Monit", "Intas Pharmaceuticals", "Tab", "30 mg / 60 mg SR")
            ),
            brandsIndia = listOf(
                BrandInfo("Monotrate", "Sun Pharma", "Tab", "20 / 40 / 60 mg SR"),
                BrandInfo("Ismo", "Abbott", "Tab", "20 / 40 mg")
            ),
            adultDose = "30-60 mg PO once daily in morning (SR).",
            contraindications = "Concomitant PDE-5 inhibitors (Sildenafil within 24h, Tadalafil within 48h), acute myocardial infarction with low filling pressures, severe aortic stenosis, hypertrophic obstructive cardiomyopathy (HOCM), severe hypotension (SBP <90 mmHg).",
            modeOfAction = "Denitrated in vascular smooth muscle to release free nitric oxide (NO), stimulating guanylate cyclase and cGMP, producing prominent systemic venous vasodilation, reducing preload and myocardial wall tension.",
            therapeuticClassTag = "Anti-anginal / Nitrates"
        ),

        Drug(
            id = "d_cardio_ivabradine",
            genericName = "Ivabradine Hydrochloride",
            system = "Cardiovascular System (CVS)",
            drugClass = "Hyperpolarization-Activated Cyclic Nucleotide-Gated (HCN) Channel Blocker",
            blackBoxWarning = null,
            indications = "Heart Failure with reduced Ejection Fraction (HFrEF, NYHA II-IV, EF <= 35%) with resting heart rate >= 70 bpm in sinus rhythm, chronic stable angina in patients intolerant to or inadequately controlled with beta-blockers.",
            doses = "Adult: Start 5 mg PO BID with meals. After 2-4 weeks, titrate based on resting heart rate: If HR >60 bpm, increase to 7.5 mg BID; if HR 50-60 bpm, maintain 5 mg BID; if HR <50 bpm or symptomatic bradycardia, reduce to 2.5 mg BID. Elderly >=75 yr: Start 2.5 mg BID.",
            administration = "Take orally twice daily with morning and evening meals.",
            timing = "Morning and evening with food.",
            specialInstructions = "Patient MUST be in normal sinus rhythm; completely ineffective in atrial fibrillation. Reduces heart rate without affecting myocardial contractility or blood pressure.",
            pkPd = "Oral bioavailability ~40% (first-pass clearance). Metabolized by CYP3A4. Half-life ~11 hours.",
            renalAdj = "CrCl >= 15 mL/min: No adjustment needed. CrCl <15 mL/min: Use with caution.",
            hepaticAdj = "Mild-to-moderate impairment: No adjustment needed. Severe hepatic impairment: Contraindicated.",
            pregnancy = "Contraindicated (teratogenic in animal models).",
            lactation = "Contraindicated; animal studies show excretion in milk.",
            sideEffects = "Phosphenes (luminous visual phenomena / enhanced brightness in visual field 14%), bradycardia, new-onset atrial fibrillation, first-degree AV block, dizziness.",
            priceNpr = "NPR 110.00 - 240.00 per strip of 10 (5mg / 7.5mg)",
            priceInr = "INR 75.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Coralan", "Servier / Medisales Nepal", "Tab", "5 mg / 7.5 mg"),
                BrandInfo("Inapure", "Torrent Pharmaceuticals", "Tab", "5 mg / 7.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Coralan", "Servier India", "Tab", "5 / 7.5 mg"),
                BrandInfo("Ivabrad", "Lupin", "Tab", "5 / 7.5 mg")
            ),
            adultDose = "5-7.5 mg PO BID with meals.",
            contraindications = "Acute decompensated heart failure, resting HR <70 bpm prior to treatment, cardiogenic shock, pacemaker dependence, atrial fibrillation, severe hepatic impairment, CYP3A4 strong inhibitors.",
            modeOfAction = "Selectively and specifically inhibits the hyperpolarization-activated funny current (If) in the cardiac sinoatrial (SA) node, slowing diastolic depolarization and reducing heart rate without negative inotropy.",
            therapeuticClassTag = "Heart Failure & Angina"
        ),

        Drug(
            id = "d_cardio_ezetimibe",
            genericName = "Ezetimibe",
            system = "Cardiovascular System (CVS)",
            drugClass = "Niemann-Pick C1-Like 1 (NPC1L1) Cholesterol Absorption Inhibitor",
            blackBoxWarning = null,
            indications = "Primary hypercholesterolemia (monotherapy or adjunctive to statins), homozygous familial hypercholesterolemia (HoFH), prevention of major cardiovascular events in CKD (SHARP trial).",
            doses = "Adult: 10 mg PO once daily at any time of day with or without food. Co-administered with any statin (Atorvastatin, Rosuvastatin).",
            administration = "Take orally once daily with or without food.",
            timing = "Any time of day; maintain consistent timing.",
            specialInstructions = "Provides an additional 15-20% reduction in LDL-C when added to maximum tolerated statin therapy (IMPROVE-IT trial). Does not cause statin-associated myopathy.",
            pkPd = "Rapidly conjugated in small intestine to active ezetimibe-glucuronide (half-life ~22 hours). Undergoes extensive enterohepatic recirculation. 78% excreted in feces.",
            renalAdj = "No dosage adjustment necessary in any stage of renal impairment.",
            hepaticAdj = "Mild impairment: No adjustment needed. Moderate or severe hepatic impairment: Not recommended.",
            pregnancy = "Category X when combined with statins; Category C as monotherapy.",
            lactation = "Safety in breastfeeding not established; avoid.",
            sideEffects = "Diarrhea, abdominal pain, flatulence, fatigue, arthralgia, mild transaminase elevations when combined with statin.",
            priceNpr = "NPR 65.00 - 140.00 per strip of 10 (10mg)",
            priceInr = "INR 45.00 - 95.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Ezentia", "Sun Pharma Nepal", "Tab", "10 mg"),
                BrandInfo("Zetia", "MSD / Organon Nepal", "Tab", "10 mg"),
                BrandInfo("Atorva-EZ", "Zydus Nepal", "Tab", "Atorvastatin 10mg + Ezetimibe 10mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ezentia", "Sun Pharma", "Tab", "10 mg"),
                BrandInfo("Zetia", "MSD", "Tab", "10 mg"),
                BrandInfo("Rozavel-EZ", "Sun Pharma", "Tab", "Rosuvastatin 10mg + Ezetimibe 10mg")
            ),
            adultDose = "10 mg PO once daily.",
            contraindications = "Concomitant statin use in active liver disease or unexplained persistent elevations in hepatic transaminases; severe hypersensitivity.",
            modeOfAction = "Localizes at the brush border of the small intestine and selectively inhibits the sterol transporter Niemann-Pick C1-Like 1 (NPC1L1), blocking absorption of dietary and biliary cholesterol.",
            therapeuticClassTag = "Lipid-lowering / Cholesterol"
        ),

        Drug(
            id = "d_cardio_acenocoumarol",
            genericName = "Acenocoumarol (Nicoumalone)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Vitamin K Antagonist Oral Anticoagulant (Coumarin Derivative)",
            blackBoxWarning = "BLEEDING RISK: Can cause major, potentially fatal hemorrhage. Regular INR monitoring mandatory.",
            indications = "Prophylaxis and treatment of venous thromboembolism (DVT, Pulmonary Embolism), thromboembolism prevention in mechanical prosthetic heart valves, non-valvular Atrial Fibrillation.",
            doses = "Individualized according to Prothrombin Time (PT) / International Normalized Ratio (INR). Loading: 4-8 mg PO on day 1, 4 mg on day 2. Maintenance: Usually 1 to 4 mg PO once daily targeting INR 2.0-3.0 (Target INR 2.5-3.5 for mechanical mitral heart valves).",
            administration = "Take orally once daily at the same time every evening with a glass of water.",
            timing = "Evening (18:00 - 20:00) so morning INR results allow same-day dose adjustment.",
            specialInstructions = "Shorter half-life than warfarin (half-life 8-11 hours vs 36-42 hours for warfarin), allowing faster reversal and quicker onset. In case of major bleeding, reverse immediately with Vitamin K1 (Phytomenadione) and Prothrombin Complex Concentrate (PCC).",
            pkPd = "Rapid and complete absorption. >98% bound to plasma albumin. Extensively metabolized in liver by CYP2C9. Elimination half-life 8-11 hours.",
            renalAdj = "Contraindicated in severe renal impairment (increased bleeding risk).",
            hepaticAdj = "Contraindicated in severe hepatic impairment (impaired clotting factor synthesis).",
            pregnancy = "Category X (strictly contraindicated; fetal warfarin syndrome, embryopathy, microcephaly, fetal hemorrhage).",
            lactation = "Very low excretion in breast milk; compatible with breastfeeding (monitor infant INR).",
            sideEffects = "Major and minor bleeding (epistaxis, hematuria, GI hemorrhage, intracranial bleed), skin necrosis/gangrene (protein C deficiency), purple toe syndrome, alopecia.",
            priceNpr = "NPR 30.00 - 70.00 per strip of 10 (1mg / 2mg / 4mg)",
            priceInr = "INR 20.00 - 50.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Acitrom", "Abbott Nepal", "Tab", "1 mg / 2 mg / 3 mg / 4 mg"),
                BrandInfo("Niko", "Cipla Nepal", "Tab", "1 mg / 2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Acitrom", "Abbott India", "Tab", "1 / 2 / 3 / 4 mg"),
                BrandInfo("Sinthrome", "Novartis", "Tab", "1 / 2 / 4 mg")
            ),
            adultDose = "1-4 mg PO once daily titrated to target INR 2.0-3.0.",
            contraindications = "Active pathological bleeding, hemorrhagic stroke, severe liver/renal disease, pregnancy, bacterial endocarditis, malignant hypertension.",
            modeOfAction = "Competitively inhibits vitamin K epoxide reductase complex 1 (VKORC1), depleting functional reduced vitamin K and blocking post-translational gamma-carboxylation of clotting factors II, VII, IX, X, and proteins C and S.",
            therapeuticClassTag = "Anticoagulants / VKA"
        ),

        Drug(
            id = "d_cardio_dabigatran",
            genericName = "Dabigatran Etexilate",
            system = "Cardiovascular System (CVS)",
            drugClass = "Direct Thrombin (Factor IIa) Inhibitor (DOAC / NOAC)",
            blackBoxWarning = "PREMATURE DISCONTINUATION INCREASES RISK OF THROMBOTIC EVENTS & SPINAL/EPIDURAL HEMATOMA: Abrupt cessation increases stroke risk. Epidural or spinal hematomas can occur in patients receiving neuraxial anesthesia.",
            indications = "Non-valvular Atrial Fibrillation stroke prevention, treatment and secondary prevention of Deep Vein Thrombosis (DVT) and Pulmonary Embolism (PE), venous thromboprophylaxis post-hip/knee arthroplasty.",
            doses = "Non-valvular AF: 150 mg PO BID (110 mg PO BID if age >=80 yr, high bleeding risk, or CrCl 30-50 mL/min with verapamil). DVT/PE Treatment: 150 mg PO BID following 5-10 days of parenteral anticoagulation.",
            administration = "Swallow capsule whole with a full glass of water with or without food. Do not open, chew, or crush capsules (increases oral bioavailability by 75%, causing severe bleeding).",
            timing = "Twice daily approximately 12 hours apart.",
            specialInstructions = "Keep capsules in original manufacturer blister pack or desiccant-capped bottle to protect from moisture; discard 4 months after opening bottle. Specific reversal agent: Idarucizumab (Praxbind).",
            pkPd = "Oral prodrug dabigatran etexilate rapidly converted to active dabigatran. Bioavailability 3-7%. Protein binding 35%. 80% eliminated unchanged via renal excretion. Half-life 12-17 hours.",
            renalAdj = "CrCl 30-50 mL/min: 110-150 mg BID. CrCl 15-30 mL/min: 75 mg BID (FDA) or contraindicated (EMA). CrCl <30 mL/min: Contraindicated in Europe/UK.",
            hepaticAdj = "Contraindicated in hepatic impairment with coagulopathy.",
            pregnancy = "Category C (Avoid in pregnancy; LMWH preferred).",
            lactation = "Safety in breastfeeding not established; avoid.",
            sideEffects = "Dyspepsia and gastrointestinal reflux (10-15% due to tartaric acid core in capsule), major GI bleeding, epistaxis, hematuria.",
            priceNpr = "NPR 1,100.00 - 1,900.00 per strip of 10 (110mg / 150mg)",
            priceInr = "INR 700.00 - 1,200.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Pradaxa", "Boehringer Ingelheim / Nepal", "Cap", "75 mg / 110 mg / 150 mg"),
                BrandInfo("Dabigo", "Torrent Pharmaceuticals", "Cap", "110 mg / 150 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pradaxa", "Boehringer Ingelheim India", "Cap", "75 / 110 / 150 mg"),
                BrandInfo("Dabigo", "Torrent", "Cap", "110 / 150 mg")
            ),
            adultDose = "150 mg PO BID (or 110 mg PO BID in elderly/moderate renal impairment).",
            contraindications = "Mechanical prosthetic heart valves, active clinically significant bleeding, severe renal impairment (CrCl <30 mL/min), hepatic disease with coagulopathy.",
            modeOfAction = "Potent, competitive, reversible, direct inhibitor of free and clot-bound thrombin (Factor IIa), preventing conversion of fibrinogen to fibrin and thrombin-induced platelet aggregation.",
            therapeuticClassTag = "DOACs / Anticoagulants"
        ),

        Drug(
            id = "d_cardio_ticagrelor",
            genericName = "Ticagrelor",
            system = "Cardiovascular System (CVS)",
            drugClass = "Direct-Acting P2Y12 Platelet Inhibitor (Cyclopentyltriazolopyrimidine)",
            blackBoxWarning = "BLEEDING RISK & ASPIRIN DOSE LIMITATION: Can cause significant, sometimes fatal bleeding. Maintenance doses of aspirin above 100 mg/day decrease the effectiveness of ticagrelor; maintain aspirin at 75-100 mg daily.",
            indications = "Acute Coronary Syndromes (STEMI, NSTEMI, Unstable Angina) managed medically or with PCI, history of myocardial infarction (secondary prevention >1 yr).",
            doses = "ACS: 180 mg PO loading dose stat, then 90 mg PO twice daily co-administered with aspirin 75-100 mg daily for at least 12 months. Prior MI (>1 yr): 60 mg PO BID.",
            administration = "Take orally twice daily with or without food. Can be crushed and mixed in water if patient cannot swallow.",
            timing = "Twice daily 12 hours apart.",
            specialInstructions = "Direct-acting; does not require hepatic metabolic activation (unlike clopidogrel), producing faster, more potent, and more consistent platelet inhibition (PLATO trial). Dyspnea is common and typically self-limiting.",
            pkPd = "Rapid absorption; peak inhibition within 2 hours. Metabolized by CYP3A4 to active metabolite AR-C124910XX. Elimination half-life ~7 hours (active metabolite ~9 hours).",
            renalAdj = "No dosage adjustment necessary in renal failure or hemodialysis.",
            hepaticAdj = "Mild impairment: No adjustment. Moderate-to-severe hepatic impairment: Contraindicated.",
            pregnancy = "Category C (Avoid; clopidogrel or aspirin preferred).",
            lactation = "Safety during lactation not established; avoid.",
            sideEffects = "Dyspnea (14% due to adenosine reuptake inhibition, typically mild-to-moderate), major bleeding, asymptomatic ventricular pauses / bradycardia, hyperuricemia, elevated serum creatinine.",
            priceNpr = "NPR 350.00 - 650.00 per strip of 14 (90mg)",
            priceInr = "INR 220.00 - 450.00 per strip of 14",
            brandsNepal = listOf(
                BrandInfo("Brilinta", "AstraZeneca / Medisales Nepal", "Tab", "90 mg / 60 mg"),
                BrandInfo("Axcer", "Sun Pharma Nepal", "Tab", "90 mg"),
                BrandInfo("Ticaspan", "Torrent Pharmaceuticals", "Tab", "90 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Brilinta", "AstraZeneca India", "Tab", "90 / 60 mg"),
                BrandInfo("Axcer", "Sun Pharma", "Tab", "90 mg")
            ),
            adultDose = "180 mg loading stat, then 90 mg PO BID with low-dose aspirin.",
            contraindications = "History of intracranial hemorrhage, active pathological bleeding, severe hepatic impairment, concomitant strong CYP3A4 inducers or inhibitors.",
            modeOfAction = "Reversibly and allosterically binds to the platelet P2Y12 ADP receptor at a site distinct from ADP, preventing ADP-mediated G-protein activation of the GPIIb/IIIa receptor complex.",
            therapeuticClassTag = "Antiplatelets / P2Y12"
        ),

        // ==========================================
        // GASTROINTESTINAL & RESPIRATORY
        // ==========================================
        Drug(
            id = "d_gastro_mebeverine",
            genericName = "Mebeverine Hydrochloride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Musculotropic Antispasmodic",
            blackBoxWarning = null,
            indications = "Irritable Bowel Syndrome (IBS), abdominal cramps, functional bowel disorders, spastic colitis, mucous colitis.",
            doses = "Standard: 135 mg PO TID 20 minutes before meals. Modified Release: 200 mg PO BID.",
            administration = "Swallow tablets/capsules whole with a glass of water. Do not chew (unpleasant taste and potential loss of modified-release profile).",
            timing = "20 minutes before breakfast, lunch, and dinner.",
            specialInstructions = "Acts directly on gut smooth muscle without systemic anticholinergic adverse effects (no dry mouth, blurred vision, or urinary retention). Safe in elderly and patients with glaucoma/BPH.",
            pkPd = "Rapid and complete absorption. Completely metabolized by hydrolysis to mebeverine alcohol and veratric acid. Excreted in urine. Half-life ~5.8 hours.",
            renalAdj = "No dosage adjustment needed in mild-to-moderate impairment.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Avoid in 1st trimester as precaution; generally considered safe).",
            lactation = "Trace excretion; safe during breastfeeding.",
            sideEffects = "Allergic skin reactions, urticaria, angioedema, dizziness, mild nausea, headache (extremely low side effect incidence).",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (135mg / 200mg SR)",
            priceInr = "INR 70.00 - 150.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Colofac", "Abbott Nepal", "Tab", "135 mg / 200 mg MR"),
                BrandInfo("Morease", "Dr. Reddy's Nepal", "Tab", "135 mg / 200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Colofac", "Abbott India", "Tab", "135 / 200 mg"),
                BrandInfo("Meva", "Zydus", "Cap", "200 mg SR")
            ),
            adultDose = "135 mg PO TID or 200 mg SR PO BID 20 min before meals.",
            contraindications = "Paralytic ileus, known hypersensitivity to mebeverine.",
            modeOfAction = "Exerts direct spasmolytic action on gastrointestinal smooth muscle by blocking voltage-operated sodium channels and inhibiting intracellular calcium influx without muscarinic blockade.",
            therapeuticClassTag = "IBS / Antispasmodics"
        ),

        Drug(
            id = "d_gastro_mesalamine",
            genericName = "Mesalamine (5-Aminosalicylic Acid / 5-ASA)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Aminosalicylate Anti-inflammatory Agent",
            blackBoxWarning = null,
            indications = "Induction of remission and maintenance therapy in mild-to-moderate Ulcerative Colitis, proctitis, proctosigmoiditis.",
            doses = "Acute Remission Induction: 2.4 to 4.8 g PO daily divided into 2-3 doses (or single daily dose). Maintenance: 1.6 to 2.4 g PO once daily. Proctitis: 1 g PR suppository daily at bedtime. Proctosigmoiditis: 4 g PR retention enema at bedtime.",
            administration = "Swallow tablets whole. Do not crush, break, or chew enteric-coated or delayed-release tablets.",
            timing = "With or without meals.",
            specialInstructions = "Check baseline renal function (serum creatinine) and periodically (associated with idiosyncratic interstitial nephritis).",
            pkPd = "Formulations engineered for site-specific colonic release (pH-dependent coating or semipermeable ethylcellulose). Acetylated in gut mucosa and liver to N-acetyl-5-ASA. Excreted in feces and urine.",
            renalAdj = "Use with caution in renal impairment; contraindicated in severe renal failure.",
            hepaticAdj = "Use with caution in liver disease.",
            pregnancy = "Category B (Safe throughout pregnancy; preferred first-line for IBD).",
            lactation = "Compatible with breastfeeding; low amounts excreted in milk.",
            sideEffects = "Headache, nausea, abdominal pain, diarrhea, interstitial nephritis, pancreatitis, mesalamine-induced acute intolerance flare (fever, bloody diarrhea).",
            priceNpr = "NPR 180.00 - 380.00 per strip of 10 (400mg / 800mg / 1.2g)",
            priceInr = "INR 120.00 - 250.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Mesacol", "Sun Pharma Nepal", "Tab / Supp / Enema", "400 mg / 800 mg / 1.2g / 500mg Supp"),
                BrandInfo("Asacol", "Tillotts / Medisales Nepal", "Tab", "400 mg / 800 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Mesacol", "Sun Pharma", "Tab", "400 / 800 mg / 1.2 g"),
                BrandInfo("Asacol", "Zydus", "Tab", "400 / 800 mg")
            ),
            adultDose = "2.4-4.8 g/day for active flare; 1.6-2.4 g/day for maintenance.",
            contraindications = "Severe renal impairment, severe hepatic impairment, salicylate hypersensitivity.",
            modeOfAction = "Acts locally in colonic mucosa to inhibit cyclooxygenase and 5-lipoxygenase pathways, suppressing synthesis of pro-inflammatory prostaglandins and leukotriene B4 (LTB4), and activating PPAR-gamma.",
            therapeuticClassTag = "Inflammatory Bowel Disease"
        ),

        Drug(
            id = "d_resp_tiotropium",
            genericName = "Tiotropium Bromide",
            system = "Respiratory System (RS)",
            drugClass = "Long-Acting Muscarinic Antagonist (LAMA) Bronchodilator",
            blackBoxWarning = null,
            indications = "Long-term maintenance treatment of Chronic Obstructive Pulmonary Disease (COPD including chronic bronchitis and emphysema), add-on maintenance treatment in moderate-to-severe persistent asthma.",
            doses = "COPD (DPI HandiHaler): Inhale contents of one 18 mcg capsule once daily. COPD / Asthma (SMI Respimat): 2 inhalations of 2.5 mcg (total 5 mcg) once daily.",
            administration = "Oral inhalation only. Capsule must never be swallowed. Rinse mouth after inhalation.",
            timing = "Once daily at the same time every day.",
            specialInstructions = "Not for acute relief of bronchospasm. Very slow dissociation from M3 receptors provides sustained 24-hour bronchodilation and reduces COPD exacerbation frequency.",
            pkPd = "Inhaled bioavailability ~20-30%. Terminal elimination half-life 5-6 days. Cleared primarily unchanged via urinary excretion.",
            renalAdj = "CrCl <= 50 mL/min: Monitor closely for anticholinergic side effects.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Category C (Compatible when clinically indicated).",
            lactation = "Minimal systemic absorption; compatible with breastfeeding.",
            sideEffects = "Dry mouth (xerostomia >10%), pharyngitis, sinusitis, urinary retention in BPH, constipation, increased intraocular pressure in glaucoma.",
            priceNpr = "NPR 350.00 - 650.00 per pack of 30 rotacaps / DPI",
            priceInr = "INR 220.00 - 450.00 per pack of 30",
            brandsNepal = listOf(
                BrandInfo("Tiova", "Cipla Nepal", "Rotacaps / Inhaler", "18 mcg Rotacaps / 9 mcg MDI"),
                BrandInfo("Spiriva", "Boehringer Ingelheim Nepal", "DPI / Respimat", "18 mcg HandiHaler / 2.5mcg Respimat")
            ),
            brandsIndia = listOf(
                BrandInfo("Tiova", "Cipla", "Rotacaps", "18 mcg"),
                BrandInfo("Spiriva", "Boehringer Ingelheim", "HandiHaler", "18 mcg")
            ),
            adultDose = "18 mcg inhaled once daily via DPI.",
            childDose = "Asthma >= 6 yr: 2 inhalations of 1.25 mcg once daily (Respimat).",
            contraindications = "Hypersensitivity to tiotropium or ipratropium; severe hypersensitivity to milk proteins (lactose in DPI).",
            modeOfAction = "Long-acting, competitive antagonist at muscarinic M3 receptors in airway smooth muscle, inhibiting acetylcholine-induced bronchoconstriction and reducing mucus hypersecretion for >24 hours.",
            therapeuticClassTag = "COPD & Asthma / LAMA"
        ),

        Drug(
            id = "d_resp_doxofylline",
            genericName = "Doxofylline",
            system = "Respiratory System (RS)",
            drugClass = "Novel Xanthine Derivative Bronchodilator",
            blackBoxWarning = null,
            indications = "Bronchial asthma, Chronic Obstructive Pulmonary Disease (COPD), bronchospastic pulmonary disorders.",
            doses = "Adult: 400 mg PO BID or TID (or 400 mg PO once daily in evening). Severe acute flare: 100-200 mg slow IV push over 10-15 min.",
            administration = "Take orally with a glass of water after food.",
            timing = "Morning and evening after meals.",
            specialInstructions = "Unlike theophylline, doxofylline does NOT inhibit adenosine receptors and does not block calcium channels. Consequently, it possesses dramatically lower cardiac (arrhythmia) and CNS (seizure) toxicity.",
            pkPd = "Good oral bioavailability. Metabolized in liver to hydroxyethyltheophylline. Elimination half-life ~7-10 hours. Does not require routine serum drug monitoring.",
            renalAdj = "Use with caution in severe renal impairment.",
            hepaticAdj = "Use with caution in hepatic dysfunction.",
            pregnancy = "Category B (Safety in human pregnancy not fully established; use inhaled agents first).",
            lactation = "Safety in breastfeeding not established.",
            sideEffects = "Epigastric pain, nausea, headache, insomnia, mild tachycardia, palpitations (much lower frequency than theophylline).",
            priceNpr = "NPR 60.00 - 130.00 per strip of 10 (400mg)",
            priceInr = "INR 40.00 - 85.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Doxolin", "Zydus Healthcare Nepal", "Tab / Syr", "400 mg / 100mg/5mL"),
                BrandInfo("Doxoril", "Macleods Nepal", "Tab", "400 mg"),
                BrandInfo("Doxiflo", "Lupin Nepal", "Tab", "400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Doxolin", "Zydus", "Tab", "400 mg"),
                BrandInfo("Doxoril", "Macleods", "Tab", "400 mg")
            ),
            adultDose = "400 mg PO BID-TID after food.",
            childDose = "Children >= 6 yr: 6-12 mg/kg/day PO divided BID.",
            contraindications = "Acute myocardial infarction, severe hypotension, lactating women, known hypersensitivity to xanthines.",
            modeOfAction = "Selective inhibitor of phosphodiesterase (PDE) enzymes in airway smooth muscle, elevating intracellular cyclic AMP (cAMP) and producing bronchodilation and mild anti-inflammatory action.",
            therapeuticClassTag = "Bronchodilators / Xanthines"
        )
    )
}
