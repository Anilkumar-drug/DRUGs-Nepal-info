package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object RemainingEssentialClinicalDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // UROLOGY & MEN'S HEALTH
        // ==========================================
        Drug(
            id = "d_rem_finasteride",
            genericName = "Finasteride",
            system = "Urogenital & Renal",
            drugClass = "Type II 5-Alpha Reductase Inhibitor",
            blackBoxWarning = null,
            indications = "Benign Prostatic Hyperplasia (BPH) with prostate enlargement (reduces prostate size, improves urinary flow, lowers risk of acute urinary retention and need for surgery); Androgenetic alopecia (male pattern hair loss).",
            doses = "BPH: 5 mg PO once daily (monotherapy or in combination with tamsulosin).\nMale Pattern Hair Loss: 1 mg PO once daily.",
            administration = "Take orally once daily with or without food. May take 6-12 months of therapy to assess maximum clinical response in BPH.",
            timing = "Once daily at the same time each day.",
            specialInstructions = "Suppresses serum Prostate-Specific Antigen (PSA) by approximately 50% after 6 months; double the measured PSA concentration when screening for prostate cancer. Pregnant women must NOT touch broken or crushed tablets due to teratogenicity risk to male fetus.",
            pkPd = "Bioavailability ~65-80%. Highly protein bound (~90%). Extensively metabolized in the liver via CYP3A4 to inactive metabolites; terminal elimination half-life is 6-8 hours.",
            renalAdj = "No dosage adjustment necessary in renal impairment or hemodialysis.",
            hepaticAdj = "Use with caution in liver disease (extensively metabolized by hepatic CYP3A4).",
            pregnancy = "Category X (Strictly contraindicated; causes feminization and hypospadias in male fetuses).",
            lactation = "Contraindicated in women.",
            sideEffects = "Erectile dysfunction, decreased libido, ejaculation disorder, gynecomastia, breast tenderness, depressive symptoms.",
            priceNpr = "NPR 180.00 - 320.00 per strip of 10 (5 mg) / NPR 120.00 (1 mg)",
            priceInr = "INR 110.00 - 220.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Finpecia", "Cipla Nepal", "Tablet", "1 mg"),
                BrandInfo("Finax", "Dr. Reddy's Nepal", "Tablet", "1 mg"),
                BrandInfo("Proscar", "MSD / Medisales Nepal", "Tablet", "5 mg"),
                BrandInfo("Fincar", "Cipla Nepal", "Tablet", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Finpecia", "Cipla", "Tablet", "1 mg"),
                BrandInfo("Fincar", "Cipla", "Tablet", "5 mg"),
                BrandInfo("Finax", "Dr. Reddy's", "Tablet", "1 mg")
            ),
            adultDose = "BPH: 5 mg PO once daily. Alopecia: 1 mg PO once daily.",
            childDose = "Contraindicated in pediatric population.",
            contraindications = "Hypersensitivity; women who are or may become pregnant; children.",
            modeOfAction = "Competitively and specifically inhibits the intracellular enzyme steroid 5-alpha-reductase (predominantly type II isozyme), preventing conversion of testosterone to 5-alpha-dihydrotestosterone (DHT) in the prostate gland and hair follicles.",
            therapeuticClassTag = "Urology & BPH"
        ),

        Drug(
            id = "d_rem_tadalafil",
            genericName = "Tadalafil",
            system = "Urogenital & Renal",
            drugClass = "Phosphodiesterase-5 (PDE5) Inhibitor",
            blackBoxWarning = "CONCURRENT NITRATE CONTRAINDICATION: Co-administration with organic nitrates (e.g. nitroglycerin, isosorbide mononitrate/dinitrate) or riociguat causes severe, potentially fatal hypotension.",
            indications = "Erectile dysfunction (ED); Benign Prostatic Hyperplasia (BPH) signs and symptoms; Concurrent ED and BPH; Pulmonary Arterial Hypertension (PAH - WHO Group 1).",
            doses = "ED On-Demand: 10 mg PO at least 30 minutes before sexual activity; may increase to 20 mg or decrease to 5 mg based on efficacy and tolerance.\nED / BPH Daily Dosing: 5 mg PO once daily at approximately the same time.\nPAH: 40 mg PO once daily.",
            administration = "Take orally with or without water. Onset is 30-60 minutes; prolonged duration of action up to 36 hours ('the weekend pill').",
            timing = "On-demand at least 30 min before intercourse, or once daily for continuous symptom relief in BPH/ED.",
            specialInstructions = "Never administer within 48 hours of nitrate intake (due to long half-life of 17.5 hours). Sexual stimulation is required for therapeutic efficacy in ED.",
            pkPd = "Bioavailability unaffected by food. Peak plasma concentration achieved at 2 hours. Elimination half-life ~17.5 hours. Excreted mainly as inactive metabolites in feces (61%) and urine (36%).",
            renalAdj = "CrCl 30-50 mL/min: Starting dose 5 mg on-demand (max 10 mg every 48 hours). CrCl <30 mL/min or hemodialysis: Max 5 mg on-demand every 72 hours; daily dosing not recommended.",
            hepaticAdj = "Mild-to-moderate: Max 10 mg on-demand. Severe hepatic impairment (Child-Pugh C): Avoid use.",
            pregnancy = "Category B (No indication in pregnancy except PAH where benefits outweigh risks).",
            lactation = "Safety in breastfeeding not established.",
            sideEffects = "Headache, dyspepsia, back pain, myalgia, nasal congestion, facial flushing, limb pain, non-arteritic anterior ischemic optic neuropathy (NAION - rare).",
            priceNpr = "NPR 150.00 - 300.00 per strip of 4 (10 mg / 20 mg)",
            priceInr = "INR 90.00 - 180.00 per strip of 4",
            brandsNepal = listOf(
                BrandInfo("Megalis", "Macleods Nepal", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Modula", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Cialis", "Eli Lilly / Nepal", "Tablet", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Megalis", "Macleods", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Modula", "Sun Pharma", "Tablet", "5 mg / 20 mg"),
                BrandInfo("Tazzle", "Dr. Reddy's", "Tablet", "10 mg / 20 mg")
            ),
            adultDose = "ED: 10-20 mg PO on-demand or 5 mg PO once daily. BPH: 5 mg PO once daily.",
            childDose = "Not approved in pediatric patients.",
            contraindications = "Any organic nitrate therapy (isosorbide, nitroglycerin), guanylate cyclase stimulators (riociguat), severe cardiovascular disease where sexual activity is inadvisable, NAION.",
            modeOfAction = "Selectively and reversibly inhibits PDE5, preventing the degradation of cyclic GMP (cGMP) in vascular smooth muscle and corpus cavernosum, leading to prolonged smooth muscle relaxation, vasodilation, and penile erection.",
            therapeuticClassTag = "Urology & Men's Health"
        ),

        Drug(
            id = "d_rem_solifenacin",
            genericName = "Solifenacin Succinate",
            system = "Urogenital & Renal",
            drugClass = "Selective M3 Muscarinic Receptor Antagonist (Urological Antispasmodic)",
            blackBoxWarning = null,
            indications = "Overactive Bladder (OAB) syndrome characterized by urinary urge incontinence, urgency, and increased urinary frequency.",
            doses = "Adult: 5 mg PO once daily; may increase to 10 mg PO once daily if well tolerated and further efficacy is required.",
            administration = "Swallow whole with liquids; do not crush or chew. Take with or without meals.",
            timing = "Once daily.",
            specialInstructions = "Assess post-void residual urine volume before initiating to avoid precipitating acute urinary retention, particularly in men with concomitant BPH.",
            pkPd = "Oral bioavailability ~90%. High plasma protein binding (~98%). Extensively metabolized in liver by CYP3A4. Long elimination half-life (45-68 hours).",
            renalAdj = "CrCl <30 mL/min: Dose should not exceed 5 mg once daily.",
            hepaticAdj = "Moderate impairment (Child-Pugh B): Dose should not exceed 5 mg once daily. Severe impairment (Child-Pugh C): Contraindicated.",
            pregnancy = "Category C (Use only if potential benefit justifies potential fetal risk).",
            lactation = "Excreted in human milk; avoid or discontinue breastfeeding.",
            sideEffects = "Dry mouth (most common), constipation, blurred vision, dyspepsia, urinary tract infection, urinary retention, QT interval prolongation (at 10 mg).",
            priceNpr = "NPR 180.00 - 320.00 per strip of 10 (5 mg / 10 mg)",
            priceInr = "INR 120.00 - 210.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Soliten", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Vesicare", "Astellas / Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Floslo", "Torrent Nepal", "Tablet", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Soliten", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Floslo", "Torrent", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Vesicare", "Astellas", "Tablet", "5 mg / 10 mg")
            ),
            adultDose = "5 mg PO once daily; increase to 10 mg once daily if needed.",
            childDose = "Safety and efficacy not established in children.",
            contraindications = "Urinary retention, gastric retention, uncontrolled narrow-angle glaucoma, severe hepatic impairment, myasthenia gravis.",
            modeOfAction = "Competitively antagonizes muscarinic M3 receptors on the bladder detrusor muscle, reducing involuntary detrusor contractions and increasing bladder capacity during storage.",
            therapeuticClassTag = "Urology & OAB"
        ),

        Drug(
            id = "d_rem_mirabegron",
            genericName = "Mirabegron",
            system = "Urogenital & Renal",
            drugClass = "Beta-3 Adrenergic Receptor Agonist",
            blackBoxWarning = null,
            indications = "Overactive Bladder (OAB) with symptoms of urge urinary incontinence, urgency, and frequency; Alternative to antimuscarinics in patients experiencing dry mouth, constipation, or cognitive concerns in the elderly.",
            doses = "Adult: 25 mg PO once daily; may increase to 50 mg PO once daily after 4-8 weeks based on efficacy and blood pressure response.\nCombination with Solifenacin 5 mg: Mirabegron 25-50 mg once daily.",
            administration = "Take orally with or without food. Swallow whole with water; do not chew, divide, or crush.",
            timing = "Once daily at the same time each day.",
            specialInstructions = "Monitor blood pressure periodically, especially in hypertensive patients. Can increase systolic and diastolic BP by 1-3 mmHg on average.",
            pkPd = "Absolute bioavailability ~35% (50 mg). Extensively distributed. Elimination half-life ~50 hours. Elimination via urine (55%) and feces (34%).",
            renalAdj = "CrCl 15-29 mL/min: Max 25 mg daily. CrCl <15 mL/min or ESRD: Not recommended.",
            hepaticAdj = "Moderate impairment (Child-Pugh B): Max 25 mg daily. Severe impairment (Child-Pugh C): Not recommended.",
            pregnancy = "Category C (Limited human data; use only if benefit outweighs risk).",
            lactation = "Present in animal milk; not recommended during breastfeeding.",
            sideEffects = "Hypertension, nasopharyngitis, urinary tract infection, headache, tachycardia, palpitations, constipation.",
            priceNpr = "NPR 300.00 - 550.00 per strip of 10 (25 mg / 50 mg)",
            priceInr = "INR 200.00 - 380.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Betmiga", "Astellas / Nepal", "Extended-Release Tab", "25 mg / 50 mg"),
                BrandInfo("Mirago", "Sun Pharma Nepal", "Extended-Release Tab", "25 mg / 50 mg"),
                BrandInfo("Bladmir", "Cipla Nepal", "Extended-Release Tab", "25 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Betmiga", "Astellas India", "ER Tablet", "25 mg / 50 mg"),
                BrandInfo("Mirago", "Sun Pharma", "ER Tablet", "25 mg / 50 mg"),
                BrandInfo("Bladmir", "Cipla", "ER Tablet", "25 mg / 50 mg")
            ),
            adultDose = "25 mg PO once daily; may titrate to 50 mg once daily.",
            childDose = "Not established in pediatric patients.",
            contraindications = "Severe uncontrolled hypertension (systolic BP >= 180 mmHg or diastolic BP >= 110 mmHg); hypersensitivity.",
            modeOfAction = "Selectively stimulates beta-3 adrenergic receptors on the detrusor smooth muscle, inducing detrusor relaxation during the bladder storage phase and increasing bladder volume capacity without inhibiting bladder voiding contractions.",
            therapeuticClassTag = "Urology & OAB"
        ),

        // ==========================================
        // CARDIOMETABOLIC & ENDOCRINOLOGY
        // ==========================================
        Drug(
            id = "d_rem_empagliflozin",
            genericName = "Empagliflozin",
            system = "Endocrine & Metabolic",
            drugClass = "Sodium-Glucose Cotransporter 2 (SGLT2) Inhibitor",
            blackBoxWarning = null,
            indications = "Type 2 Diabetes Mellitus glycemic control; Heart Failure with reduced ejection fraction (HFrEF) or preserved ejection fraction (HFpEF) to reduce cardiovascular death and hospitalization; Chronic Kidney Disease (CKD) to reduce disease progression.",
            doses = "T2DM / Heart Failure / CKD: 10 mg PO once daily in the morning; may increase to 25 mg PO once daily for additional glycemic reduction in T2DM.",
            administration = "Take orally once daily in the morning with or without food.",
            timing = "Morning with water.",
            specialInstructions = "Withhold 3 days prior to major elective surgery to minimize risk of euglycemic diabetic ketoacidosis (euDKA). Educate patients on genital hygiene to prevent candidal balanitis/vulvovaginitis.",
            pkPd = "Rapid absorption, bioavailability ~75%. Minimal metabolism; excreted unchanged in feces (41%) and urine (54%). Terminal half-life ~12.4 hours.",
            renalAdj = "eGFR >= 20 mL/min/1.73m2: 10 mg once daily for HF / CKD benefit. eGFR < 20: Glycemic efficacy diminishes, but may continue for CV/renal protection until dialysis initiation.",
            hepaticAdj = "No adjustment in mild to moderate hepatic impairment. Not recommended in severe impairment.",
            pregnancy = "Contraindicated in 2nd and 3rd trimesters (risk of fetal renal impairment).",
            lactation = "Contraindicated during breastfeeding.",
            sideEffects = "Mycotic genital infections (candidiasis), urinary tract infections, polyuria, volume depletion, postural hypotension, euglycemic ketoacidosis (rare).",
            priceNpr = "NPR 250.00 - 450.00 per strip of 10 (10 mg / 25 mg)",
            priceInr = "INR 180.00 - 320.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Jardiance", "Boehringer Ingelheim Nepal", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Gibtulio", "Lupin Nepal", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Empaone", "Macleods Nepal", "Tablet", "10 mg / 25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Jardiance", "Boehringer Ingelheim", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Gibtulio", "Lupin", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Empaone", "Macleods", "Tablet", "10 mg / 25 mg")
            ),
            adultDose = "10 mg PO once daily; max 25 mg PO once daily.",
            childDose = "Approved for pediatric T2DM >= 10 years at 10 mg once daily.",
            contraindications = "Dialysis or end-stage kidney disease; history of serious hypersensitivity or SGLT2 inhibitor ketoacidosis.",
            modeOfAction = "Inhibits SGLT2 in the renal proximal convoluted tubules, reducing renal reabsorption of filtered glucose and lowering the renal threshold for glucose, producing marked glucosuria, natriuresis, and osmotic diuresis.",
            therapeuticClassTag = "Endocrinology & SGLT2i"
        ),

        Drug(
            id = "d_rem_nebivolol",
            genericName = "Nebivolol Hydrochloride",
            system = "Cardiovascular System",
            drugClass = "Third-Generation Vasodilating Beta-1 Selective Adrenoceptor Blocker (Nitric Oxide Enhancer)",
            blackBoxWarning = "ABRUPT CESSATION: Do not stop beta-blockers abruptly in coronary artery disease; taper over 1-2 weeks to avoid rebound myocardial ischemia, angina, or ventricular arrhythmias.",
            indications = "Essential hypertension; Chronic stable heart failure (HFrEF/HFmrEF) in elderly patients (SENIORS trial) as add-on therapy.",
            doses = "Hypertension: Initial 5 mg PO once daily; may titrate up to 10 mg daily (or 2.5 mg once daily in elderly or renal impairment).\nHeart Failure: Initial 1.25 mg PO once daily; double dose every 1-2 weeks up to target 10 mg once daily.",
            administration = "Take orally once daily at approximately the same time, with or without meals.",
            timing = "Morning or evening consistently.",
            specialInstructions = "Possesses highest beta-1 selectivity among beta-blockers and promotes endothelial nitric oxide (NO) synthesis, producing peripheral vasodilation with significantly lower incidence of erectile dysfunction, fatigue, and bronchospasm.",
            pkPd = "Bioavailability ~12% in extensive metabolizers (CYP2D6) and ~96% in poor metabolizers. Half-life is 10 hours in extensive metabolizers and 30-50 hours in poor metabolizers.",
            renalAdj = "Moderate-to-severe renal impairment (CrCl <30 mL/min): Initial dose 2.5 mg once daily; titrate cautiously.",
            hepaticAdj = "Moderate hepatic impairment: Initial dose 2.5 mg once daily. Severe hepatic impairment: Contraindicated.",
            pregnancy = "Category C / D in later trimesters (Can reduce placental perfusion, fetal bradycardia, and IUGR).",
            lactation = "Contraindicated; excreted in breast milk.",
            sideEffects = "Headache, dizziness, fatigue, paresthesias, bradycardia, dyspnea, nausea, edema.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (2.5 mg / 5 mg)",
            priceInr = "INR 70.00 - 140.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Nebicard", "Torrent Pharmaceuticals Nepal", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Nebilong", "Micro Labs Nepal", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Nebistar", "Lupin Nepal", "Tablet", "2.5 mg / 5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Nebicard", "Torrent", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Nebilong", "Micro Labs", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Nebistar", "Lupin", "Tablet", "2.5 mg / 5 mg")
            ),
            adultDose = "Hypertension: 5 mg PO once daily (range 2.5-10 mg). Heart failure: 1.25 mg daily titrated to 10 mg daily.",
            childDose = "Safety and efficacy not established in pediatric patients.",
            contraindications = "Severe bradycardia (<50 bpm), cardiogenic shock, decompensated heart failure requiring IV inotropes, 2nd or 3rd degree heart block, sick sinus syndrome, severe hepatic impairment.",
            modeOfAction = "Highly selective competitive antagonist of cardiac beta-1 adrenergic receptors; additionally causes peripheral vasodilation via stimulation of endothelial beta-3 adrenoceptors and release of endothelial nitric oxide (NO).",
            therapeuticClassTag = "Antihypertensives"
        ),

        // ==========================================
        // NEUROLOGY, VERTIGO & NOOTROPICS
        // ==========================================
        Drug(
            id = "d_rem_cinnarizine",
            genericName = "Cinnarizine",
            system = "Central Nervous System (CNS)",
            drugClass = "Piperazine Antihistamine & L-type Calcium Channel Antagonist",
            blackBoxWarning = null,
            indications = "Vestibular symptoms including peripheral vertigo, dizziness, tinnitus, and nystagmus (Meniere's disease, labyrinthitis); Prophylaxis and treatment of motion sickness.",
            doses = "Vestibular Vertigo: 25 mg to 75 mg PO twice to thrice daily (max 225 mg/day).\nMotion Sickness: 25 mg PO taken 2 hours before travel, repeated as 25 mg every 8 hours during journey if needed.",
            administration = "Take orally after meals to minimize gastric irritation.",
            timing = "After meals.",
            specialInstructions = "Long-term usage in elderly patients (>3-6 months) can induce drug-induced parkinsonism, tremor, or extrapyramidal symptoms; monitor motor function carefully and discontinue if motor symptoms arise.",
            pkPd = "Well absorbed from gut; peak levels in 1-3 hours. Bound to plasma proteins (~91%). Extensively metabolized in liver. Half-life ~4 hours.",
            renalAdj = "No specific adjustment, use with caution.",
            hepaticAdj = "Use with caution in hepatic impairment.",
            pregnancy = "Category C (Avoid use in pregnancy; safety not established).",
            lactation = "Contraindicated during breastfeeding.",
            sideEffects = "Somnolence, sedation, weight gain, dyspepsia, dry mouth, drug-induced parkinsonism or tremor in elderly with prolonged use.",
            priceNpr = "NPR 45.00 - 90.00 per strip of 10 (25 mg / 75 mg)",
            priceInr = "INR 30.00 - 60.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Stugeron", "Johnson & Johnson / Medisales Nepal", "Tablet", "25 mg / 75 mg"),
                BrandInfo("Cinarin", "Deurali-Janta (DJPL) Nepal", "Tablet", "25 mg / 75 mg"),
                BrandInfo("Vertigon", "Torrent Nepal", "Tablet", "25 mg / 75 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Stugeron", "Janssen India", "Tablet", "25 mg / 75 mg"),
                BrandInfo("Vertigon", "Torrent", "Tablet", "25 mg / 75 mg"),
                BrandInfo("Cinarin", "RPG", "Tablet", "25 mg / 75 mg")
            ),
            adultDose = "25 mg PO TID or 75 mg PO once to twice daily after meals.",
            childDose = "Children 5-12 yr: Half adult dose (12.5 mg PO TID).",
            contraindications = "Parkinson's disease, extrapyramidal disorders, porphyria, severe depressive illness.",
            modeOfAction = "Inhibits influx of calcium ions into vestibular sensory cells, suppressing vestibular end-organ overstimulation; simultaneously acts as an H1 receptor antagonist, inhibiting the emetic and labyrinthine reflex centers.",
            therapeuticClassTag = "Vestibular & Vertigo"
        ),

        Drug(
            id = "d_rem_flunarizine",
            genericName = "Flunarizine Dihydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Selective T- and L-type Calcium Channel Blocker (Difluorinated Derivative of Cinnarizine)",
            blackBoxWarning = null,
            indications = "Prophylaxis of frequent or severe migraine headaches (reduces frequency and severity, not for acute attack termination); Vestibular vertigo prophylaxis.",
            doses = "Adult (<65 years): 10 mg PO once daily at bedtime.\nElderly (>=65 years): 5 mg PO once daily at bedtime.\nMaintenance: If clinical improvement occurs after 2 months, treatment may be paused or reduced to 5 days per week to minimize depression/parkinsonism risk.",
            administration = "Take orally at bedtime with a glass of water. Sedation is common initially.",
            timing = "Bedtime.",
            specialInstructions = "High lipophilicity leads to extensive accumulation and very long terminal elimination half-life (~18-19 days). Screen for depressive history and extrapyramidal symptoms before and during treatment.",
            pkPd = "Well absorbed (>80%). Peak plasma concentration at 2-4 hours. Highly bound to plasma proteins (99%). Extensively metabolized in liver by CYP2D6.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution in hepatic dysfunction.",
            pregnancy = "Category C (Avoid use in pregnancy).",
            lactation = "Contraindicated in nursing mothers.",
            sideEffects = "Drowsiness, weight gain, increased appetite, depression, apathy, extrapyramidal symptoms (tremor, rigidity, akathisia) particularly in older individuals.",
            priceNpr = "NPR 60.00 - 120.00 per strip of 10 (5 mg / 10 mg)",
            priceInr = "INR 40.00 - 80.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Sibelium", "Janssen / Medisales Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Flunarin", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Migrid", "National Healthcare Nepal", "Tablet", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Sibelium", "Janssen India", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Flunarin", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Migon", "Cadila", "Tablet", "5 mg / 10 mg")
            ),
            adultDose = "5-10 mg PO once daily at bedtime.",
            childDose = "Children >12 yr: 5 mg PO at bedtime.",
            contraindications = "Pre-existing depressive disorders, history of recurrent depression, Parkinson's disease, other extrapyramidal disorders.",
            modeOfAction = "Prevents cellular calcium overload by selectively blocking voltage-gated calcium channels in vascular smooth muscle and cerebral neuronal membranes, suppressing cortical spreading depression and cerebral vasospasm.",
            therapeuticClassTag = "Migraine Prophylaxis"
        ),

        Drug(
            id = "d_rem_citicoline",
            genericName = "Citicoline Sodium (CDP-Choline)",
            system = "Central Nervous System (CNS)",
            drugClass = "Neuroprotective Phospholipid Intermediate (Cytidine 5'-Diphosphocholine)",
            blackBoxWarning = null,
            indications = "Acute ischemic stroke neuroprotection and post-stroke cognitive/motor rehabilitation; Traumatic Brain Injury (TBI); Vascular cognitive impairment and senile dementia; Glaucoma neuroprotection.",
            doses = "Acute Ischemic Stroke / TBI: 500 mg to 1000 mg IV or IM twice daily, or 500-1000 mg PO twice daily for 2 to 12 weeks.\nChronic Cognitive Rehabilitation: 500 mg PO once to twice daily.",
            administration = "Oral: Take with or between meals. IV/IM: Administer as slow IV push (over 3-5 min) or IV infusion in 0.9% NaCl or D5W.",
            timing = "Twice daily with breakfast and lunch (avoid late evening due to mild stimulant effects).",
            specialInstructions = "Acts as an essential intermediate in the biosynthesis of structural membrane phospholipids (phosphatidylcholine). May be combined with Piracetam in acute neuro-recovery protocols.",
            pkPd = "Oral bioavailability >90%. Hydrolyzed in gut and liver to choline and cytidine; crosses blood-brain barrier and resynthesizes into citicoline in neuronal tissue. Excreted via CO2 expiration and urine.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B / Safe practice: Use only when strictly indicated.",
            lactation = "Safety in breastfeeding not established.",
            sideEffects = "Insomnia, headache, diarrhea, nausea, transient hypotension, restlessness, flushing.",
            priceNpr = "NPR 350.00 - 650.00 per strip of 10 (500 mg) / NPR 180.00 per ampoule (1000 mg/4 mL)",
            priceInr = "INR 220.00 - 450.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Citistar", "Lupin Nepal", "Tablet / Inj", "500 mg / 1000 mg"),
                BrandInfo("Stoline", "Sun Pharma Nepal", "Tablet / Syrup", "500 mg / 500mg/5mL"),
                BrandInfo("Ceham", "Alkem Nepal", "Tablet / Inj", "500 mg / 1000 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Citistar", "Lupin", "Tablet / Inj", "500 mg / 1000 mg"),
                BrandInfo("Stoline", "Sun Pharma", "Tablet", "500 mg"),
                BrandInfo("Ceham", "Alkem", "Tablet / Inj", "500 mg / 1000 mg")
            ),
            adultDose = "500 mg to 1000 mg PO/IV BID.",
            childDose = "Safety and dosage not established in children.",
            contraindications = "Severe parasympathetic hypertonia (persistent parasympathetic overactivity); hypersensitivity.",
            modeOfAction = "Restores neuronal membrane phosphatidylcholine biosynthesis, accelerates reabsorption of cerebral edema, inhibits free fatty acid accumulation, and enhances acetylcholine and dopamine synthesis in brain tissue.",
            therapeuticClassTag = "Neuroprotective & Nootropics"
        ),

        Drug(
            id = "d_rem_piracetam",
            genericName = "Piracetam",
            system = "Central Nervous System (CNS)",
            drugClass = "GABA Cyclic Derivative Nootropic (Racetam)",
            blackBoxWarning = null,
            indications = "Cortical myoclonus (adjunctive therapy with valproate/clonazepam); Cognitive impairment and memory loss in cerebrovascular insufficiency; Vertigo of central origin; Breath-holding spells in pediatric patients.",
            doses = "Cortical Myoclonus: Initial 7.2 g/day PO divided TID (2.4 g TID); titrate by 4.8 g/day every 3-4 days to max 24 g/day.\nCognitive / Stroke Rehabilitation: 800 mg to 1200 mg PO TID (or 1-3 g IV slow infusion).",
            administration = "Take orally before or with meals. Swallow whole with water; tablets have a bitter taste.",
            timing = "Divided in 2 to 3 doses daily (avoid late night dosing to prevent insomnia).",
            specialInstructions = "Do not discontinue abruptly in myoclonus as this can precipitate sudden relapse or generalized status epilepticus seizures.",
            pkPd = "Rapid and almost complete absorption. Very low protein binding. Crosses blood-brain barrier. Completely eliminated unchanged by the kidneys (renal excretion >90%). Elimination half-life ~5 hours.",
            renalAdj = "CrCl 50-79 mL/min: 2/3 of normal dose. CrCl 30-49 mL/min: 1/3 of normal dose. CrCl 20-29 mL/min: 1/6 of normal dose. CrCl <20 mL/min: Contraindicated.",
            hepaticAdj = "No adjustment required in isolated hepatic impairment.",
            pregnancy = "Category C (Crosses placenta; contraindicated in pregnancy).",
            lactation = "Contraindicated; excreted into breast milk.",
            sideEffects = "Hyperkinesia, nervousness, agitation, insomnia, weight gain, depression, diarrhea, bleeding risk at high doses due to antiplatelet effect.",
            priceNpr = "NPR 120.00 - 240.00 per strip of 10 (800 mg / 1200 mg)",
            priceInr = "INR 80.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Nootropil", "UCB / Medisales Nepal", "Tablet / Syrup / Inj", "800 mg / 1200 mg / 200mg/mL"),
                BrandInfo("Piratam", "Torrent Nepal", "Tablet", "800 mg / 1200 mg"),
                BrandInfo("Neurocetam", "Micro Labs Nepal", "Tablet / Inj", "800 mg / 1200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Nootropil", "Dr. Reddy's", "Tablet", "800 mg / 1200 mg"),
                BrandInfo("Neurocetam", "Micro Labs", "Tablet", "800 mg / 1200 mg"),
                BrandInfo("Piratam", "Torrent", "Tablet", "800 mg")
            ),
            adultDose = "800-1200 mg PO TID for cognitive recovery; up to 7.2-24 g/day for myoclonus.",
            childDose = "Breath-holding spells: 40-50 mg/kg/day divided in 2 doses.",
            contraindications = "Severe renal impairment (CrCl <20 mL/min), cerebral hemorrhage, Huntington's chorea.",
            modeOfAction = "Allosterically modulates AMPA receptors and improves membrane fluidity of neuronal and vascular cell walls; enhances microcirculation by reducing erythrocyte aggregation and blood viscosity without vasodilation.",
            therapeuticClassTag = "Neuroprotective & Nootropics"
        ),

        // ==========================================
        // ALLERGY, PRURITUS & ANTIHISTAMINES
        // ==========================================
        Drug(
            id = "d_rem_hydroxyzine",
            genericName = "Hydroxyzine Hydrochloride",
            system = "Immunology & Allergy",
            drugClass = "First-Generation Piperazine Histamine H1 Receptor Antagonist & Anxiolytic",
            blackBoxWarning = "QT PROLONGATION: Hydroxyzine is associated with dose-dependent prolongation of QT interval and torsades de pointes, particularly in patients with pre-existing cardiac disease or electrolyte derangements.",
            indications = "Severe pruritus associated with chronic urticaria, atopic dermatitis, contact eczema; Short-term symptomatic relief of anxiety and generalized tension in adults; Pre- and postoperative sedation.",
            doses = "Pruritus / Urticaria: 25 mg PO at bedtime; may increase to 25 mg PO TID or QID (max 100 mg/day in adults, max 50 mg/day in elderly).\nAnxiety: 50 mg to 100 mg PO daily in divided doses (e.g. 25 mg TID or 50 mg BID).\nPediatric (>6 months): 1 to 2 mg/kg/day PO divided into 3-4 doses.",
            administration = "Take orally with or without food. Bedtime dosing is ideal for night-time pruritus and sleep induction.",
            timing = "Bedtime or 2-3 times daily.",
            specialInstructions = "Rapidly and extensively metabolized to its active carboxylated metabolite cetirizine. Max recommended daily dose in adults is 100 mg, and in the elderly 50 mg.",
            pkPd = "Rapidly absorbed; onset of action 15-30 minutes. Extensively metabolized in the liver to cetirizine. Half-life ~20 hours in adults (prolonged to ~29 hours in elderly).",
            renalAdj = "CrCl <50 mL/min: Reduce dose by 50%.",
            hepaticAdj = "Moderate-to-severe hepatic impairment: Reduce daily dose by 33% to 50%.",
            pregnancy = "Category X in first trimester; Category C in later trimesters (Avoid; embryotoxic in animals).",
            lactation = "Contraindicated; excreted into breast milk.",
            sideEffects = "Drowsiness, sedation, dry mouth, headache, dizziness, anticholinergic effects (urinary retention, blurred vision), QT prolongation.",
            priceNpr = "NPR 45.00 - 85.00 per strip of 10 (10 mg / 25 mg)",
            priceInr = "INR 30.00 - 60.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Atarax", "Dr. Reddy's Nepal", "Tablet / Syrup", "10 mg / 25 mg / 10mg/5mL"),
                BrandInfo("Hicope", "Mankind Nepal", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Hyzox", "National Healthcare Nepal", "Tablet", "10 mg / 25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Atarax", "Dr. Reddy's", "Tablet / Syrup", "10 mg / 25 mg"),
                BrandInfo("Hicope", "Mankind", "Tablet", "25 mg"),
                BrandInfo("Hyzox", "Cadila", "Tablet", "25 mg")
            ),
            pediatricDosePerKg = 1.5,
            pediatricInterval = "mg/kg/day PO divided TID-QID",
            adultDose = "25 mg PO at night; up to 25 mg TID or QID (max 100 mg/day).",
            childDose = "1-2 mg/kg/day PO divided TID.",
            contraindications = "Prolonged QT interval (congenital or acquired), known history of ventricular arrhythmias, early pregnancy, porphyria.",
            modeOfAction = "Competitively antagonizes peripheral and central H1 receptors; also exhibits central subcortical sedative, anticholinergic, and mild antiemetic activity via suppression of subcortical CNS areas.",
            therapeuticClassTag = "Antihistamines & Pruritus"
        ),

        Drug(
            id = "d_rem_promethazine",
            genericName = "Promethazine Hydrochloride",
            system = "Immunology & Allergy",
            drugClass = "Phenothiazine First-Generation H1 Antagonist & Antiemetic",
            blackBoxWarning = "FATAL RESPIRATORY DEPRESSION IN CHILDREN: Contraindicated in children <2 years due to potential for fatal respiratory depression. SEVERE TISSUE INJURY: IV injection carries risk of severe chemical gangrene; administer deep IM only or very dilute slow IV.",
            indications = "Symptomatic treatment of acute allergic conditions (anaphylaxis adjunct, urticaria, angioedema); Prevention and treatment of motion sickness; Postoperative nausea and vomiting; Pre-op and obstetric sedation.",
            doses = "Allergic conditions: 25 mg PO at bedtime or 12.5 mg PO TID before meals.\nMotion Sickness: 25 mg PO taken 30-60 min before travel, repeat after 8-12 hours.\nEmergency / Nausea: 25 mg deep IM or slow IV infusion over 20-30 min.",
            administration = "Take orally with food or milk. If given parenterally, deep intramuscular injection is strongly preferred. Subcutaneous or intra-arterial injection is strictly contraindicated.",
            timing = "Bedtime or 30 min before departure.",
            specialInstructions = "Never administer intra-arterially (causes severe arteriospasm, thrombosis, and limb gangrene). Avoid co-administration with alcohol or CNS depressants.",
            pkPd = "Well absorbed orally. Bioavailability ~25% due to extensive first-pass hepatic metabolism. Half-life ~10-14 hours. Excreted in urine and feces.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution in hepatic impairment.",
            pregnancy = "Category C (Avoid near term due to risk of neonatal platelet aggregation inhibition and CNS depression).",
            lactation = "Contraindicated; excreted in breast milk and risks infant apnea.",
            sideEffects = "Severe sedation, dry mouth, blurred vision, urinary retention, hypotension, extrapyramidal symptoms, photosensitivity.",
            priceNpr = "NPR 35.00 - 70.00 per strip of 10 (10 mg / 25 mg) / NPR 25.00 per ampoule",
            priceInr = "INR 20.00 - 45.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Phenergan", "Sanofi Nepal", "Tablet / Elixir / Inj", "10 mg / 25 mg / 25mg/mL"),
                BrandInfo("Avomine", "Piramal / Nepal", "Tablet", "25 mg"),
                BrandInfo("Prometh", "National Healthcare Nepal", "Tablet / Inj", "25 mg / 25mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Phenergan", "Abbott India", "Tablet / Inj", "10 mg / 25 mg"),
                BrandInfo("Avomine", "Piramal", "Tablet", "25 mg")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "mg/kg PO/IM BID-TID (strictly >2 years)",
            adultDose = "25 mg PO/IM at night or 12.5-25 mg TID.",
            childDose = "0.5-1 mg/kg PO at bedtime (strictly >2 years).",
            contraindications = "Children under 2 years of age, comatose states, CNS depression, intra-arterial or subcutaneous injection.",
            modeOfAction = "Competitive antagonist at central and peripheral histamine H1 receptors with potent anticholinergic (muscarinic), antiemetic (chemoreceptor trigger zone suppression), and central alpha-adrenergic blocking properties.",
            therapeuticClassTag = "Antihistamines & Motion Sickness"
        ),

        // ==========================================
        // DERMATOLOGY & TOPICAL CARE
        // ==========================================
        Drug(
            id = "d_rem_silver_sulfadiazine",
            genericName = "Silver Sulfadiazine (1% w/w)",
            system = "Dermatology",
            drugClass = "Topical Broad-Spectrum Sulfonamide Antimicrobial",
            blackBoxWarning = null,
            indications = "Prevention and treatment of wound sepsis in second- and third-degree burn wounds; Infected leg ulcers and pressure sores.",
            doses = "Apply a sterile layer approximately 1.5 to 3 mm thick to the cleansed and debrided burn surface once to twice daily.",
            administration = "Apply under aseptic conditions using sterile gloved hand. Burn areas must be continuously covered with cream. Re-apply immediately if cream rubs off.",
            timing = "Once to twice daily after cleansing and debriding.",
            specialInstructions = "Causes transient leukopenia (nadir at 2-4 days) which typically rebounds spontaneously. Monitor CBC if large burn surface areas (>20% TBSA) are treated. May cause silver staining of skin.",
            pkPd = "Silver is minimally absorbed. Sulfadiazine is absorbed up to 10% through extensive denuded burn surfaces and excreted in urine.",
            renalAdj = "Use with caution in extensive burns with renal failure (sulfadiazine accumulation).",
            hepaticAdj = "Use with caution in severe hepatic impairment.",
            pregnancy = "Category B / Contraindicated near term (causes kernicterus in the newborn).",
            lactation = "Contraindicated in mothers of neonates <2 months or G6PD-deficient infants.",
            sideEffects = "Transient leukopenia, burning sensation on application, skin rash, pruritus, argyria (skin discoloration), hemolytic anemia in G6PD deficiency.",
            priceNpr = "NPR 90.00 - 160.00 per tube (50 g / 100 g)",
            priceInr = "INR 60.00 - 110.00 per tube",
            brandsNepal = listOf(
                BrandInfo("Silverex", "Sun Pharma Nepal", "Cream", "1% w/w (20g / 50g)"),
                BrandInfo("Burnheal", "Cipla Nepal", "Cream", "1% w/w (30g / 50g)"),
                BrandInfo("Silversulf", "National Healthcare Nepal", "Cream", "1% w/w (50g)")
            ),
            brandsIndia = listOf(
                BrandInfo("Silverex", "Sun Pharma", "Cream", "1% w/w"),
                BrandInfo("Burnheal", "Cipla", "Cream", "1% w/w"),
                BrandInfo("Silvazine", "Smith & Nephew", "Cream", "1% w/w")
            ),
            adultDose = "Apply 2-3 mm layer to burn wound 1-2 times daily.",
            childDose = "Apply 2-3 mm layer 1-2 times daily (contraindicated in neonates <2 months).",
            contraindications = "Hypersensitivity to sulfonamides; premature infants and full-term neonates <2 months; pregnant women near term (risk of kernicterus).",
            modeOfAction = "Acts continuously on bacterial cell membranes and cell walls; slowly releases silver ions which bind to bacterial DNA, inhibiting replication and transcription, while sulfadiazine inhibits folic acid synthesis.",
            therapeuticClassTag = "Dermatology & Burn Care"
        ),

        Drug(
            id = "d_rem_calamine",
            genericName = "Calamine Lotion",
            system = "Dermatology",
            drugClass = "Topical Antipruritic, Astringent & Skin Protectant",
            blackBoxWarning = null,
            indications = "Symptomatic relief of mild itching, pruritus, and pain associated with chickenpox (varicella), measles, insect bites and stings, sunburn, contact dermatitis (poison ivy/oak), and heat rash (miliaria).",
            doses = "Apply liberally to the affected skin areas three to four times daily as needed.",
            administration = "Shake bottle vigorously before each application. Apply to clean, dry skin using a sterile cotton wool swab or clean fingertips. Allow to air-dry to leave a soothing pink protective film.",
            timing = "Three to four times daily as needed.",
            specialInstructions = "For external use only. Do not apply to open, weeping blisters or deep puncture wounds. Avoid contact with eyes and mucous membranes.",
            pkPd = "No significant systemic absorption. Formulated with basic zinc carbonate colored with iron oxide (calamine) and zinc oxide, which evaporate water to produce localized cooling and mild vasoconstriction.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Safe during pregnancy (Category A equivalent topical).",
            lactation = "Safe during breastfeeding (avoid applying directly to nipple/areola area before nursing).",
            sideEffects = "Mild localized skin dryness, transient irritation or hypersensitivity (rare).",
            priceNpr = "NPR 110.00 - 190.00 per bottle (100 mL)",
            priceInr = "INR 70.00 - 130.00 per bottle (100 mL)",
            brandsNepal = listOf(
                BrandInfo("Caladryl", "Piramal / Medisales Nepal", "Lotion", "100 mL"),
                BrandInfo("Calak", "Cipla Nepal", "Lotion", "100 mL"),
                BrandInfo("Calamine", "Nepal Pharmaceuticals Lab (NPL)", "Lotion", "100 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Caladryl", "Piramal", "Lotion", "100 mL"),
                BrandInfo("Calak", "Cipla", "Lotion", "100 mL"),
                BrandInfo("Lacto Calamine", "Piramal", "Lotion", "120 mL")
            ),
            adultDose = "Apply topically 3-4 times daily as needed.",
            childDose = "Apply topically 3-4 times daily as needed.",
            contraindications = "Hypersensitivity to calamine, zinc oxide, or lotion vehicle ingredients; open, actively oozing or denuded skin wounds.",
            modeOfAction = "Exerts mild astringent, antiseptic, and antipruritic actions; zinc oxide coagulates surface proteins and forms a physical protective barrier, while evaporation of the water phase produces a soothing cooling sensation.",
            therapeuticClassTag = "Dermatology & Antipruritics"
        ),

        Drug(
            id = "d_rem_hydrocortisone_topical",
            genericName = "Hydrocortisone 1% Topical Cream",
            system = "Dermatology",
            drugClass = "Low-Potency Topical Corticosteroid (Class VII)",
            blackBoxWarning = null,
            indications = "Mild inflammatory and pruritic dermatoses: facial eczema, intertrigo, mild atopic dermatitis in infants and children, sebhorrheic dermatitis of face, insect bite reactions, anogenital pruritus.",
            doses = "Apply a thin film to the affected skin area once to twice daily for up to 7-14 days.",
            administration = "Cleanse skin before application. Rub in gently until absorbed. Do not apply under occlusive dressings unless directed.",
            timing = "Once to twice daily.",
            specialInstructions = "Preferred topical steroid for sensitive thin skin areas (face, flexures, groin, scrotum) and pediatric patients due to low potency and minimal risk of skin atrophy and HPA axis suppression.",
            pkPd = "Systemic absorption is minimal (<1-2%) from intact skin, but increases up to 10-fold on inflamed skin or with occlusion. Metabolized in the liver.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Preferred topical steroid in pregnancy when needed; use sparingly).",
            lactation = "Safe; do not apply directly to breasts before feeding.",
            sideEffects = "Local burning, erythema, dryness, secondary infection, mild skin thinning with prolonged continuous use.",
            priceNpr = "NPR 60.00 - 110.00 per tube (15 g / 20 g)",
            priceInr = "INR 40.00 - 75.00 per tube",
            brandsNepal = listOf(
                BrandInfo("Wycort", "Sun Pharma Nepal", "Cream / Ointment", "1% w/w (15g)"),
                BrandInfo("Cort-S", "Deurali-Janta (DJPL) Nepal", "Cream", "1% w/w (15g)"),
                BrandInfo("Hysone", "National Healthcare Nepal", "Cream", "1% w/w (15g)")
            ),
            brandsIndia = listOf(
                BrandInfo("Wycort", "Sun Pharma", "Cream", "1% w/w"),
                BrandInfo("Cort-S", "DJPL", "Cream", "1% w/w"),
                BrandInfo("Lycor", "Cadila", "Cream", "1% w/w")
            ),
            adultDose = "Apply thin layer to affected area 1-2 times daily.",
            childDose = "Apply thin layer 1-2 times daily (safe in infants >3 months).",
            contraindications = "Untreated viral (herpes simplex, varicella), fungal (tinea, candida), or bacterial skin infections; rosacea; perioral dermatitis.",
            modeOfAction = "Diffuses across cell membranes to bind glucocorticoid receptors, inhibiting transcription of inflammatory cytokines (IL-1, IL-6, TNF-alpha) and phospholipase A2, reducing erythema, edema, and pruritus.",
            therapeuticClassTag = "Dermatology & Corticosteroids"
        ),

        Drug(
            id = "d_rem_ketoconazole_topical",
            genericName = "Ketoconazole (2% w/w Cream / 2% w/v Shampoo)",
            system = "Dermatology",
            drugClass = "Topical Imidazole Broad-Spectrum Antifungal",
            blackBoxWarning = null,
            indications = "Pityriasis (tinea) versicolor; Seborrheic dermatitis of the scalp and face (dandruff); Tinea corporis, tinea cruris, tinea pedis; Cutaneous candidiasis.",
            doses = "Cream: Apply to affected skin and surrounding area once to twice daily for 2 to 4 weeks.\nShampoo (Dandruff / Seborrheic Dermatitis): Apply to wet scalp twice weekly for 2 to 4 weeks; leave on for 3-5 minutes before rinsing. Prophylaxis: Use once weekly or every 2 weeks.\nTinea Versicolor: Shampoo applied once daily for up to 5 days.",
            administration = "Cream: Rub gently into affected area. Shampoo: Lather on scalp and hair, leave for 3-5 minutes, then rinse thoroughly.",
            timing = "Twice weekly for scalp shampoo; once to twice daily for cream.",
            specialInstructions = "Continue treatment for several days after symptoms disappear to prevent relapse. Shampoo does not cause the severe hepatotoxicity associated with oral ketoconazole.",
            pkPd = "Topical absorption into systemic circulation is negligible through intact skin. Persists in the stratum corneum and hair follicles.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Topical absorption negligible; safe for limited areas).",
            lactation = "Safe during breastfeeding (do not apply to chest/nipple).",
            sideEffects = "Local skin burning, erythema, dryness, pruritus, mild hair discoloration or changes in hair texture (shampoo).",
            priceNpr = "NPR 140.00 - 260.00 per tube (30 g) / NPR 220.00 - 380.00 per bottle shampoo (60 mL / 100 mL)",
            priceInr = "INR 90.00 - 180.00 per tube / INR 150.00 - 250.00 per shampoo",
            brandsNepal = listOf(
                BrandInfo("Nizral", "Johnson & Johnson / Medisales Nepal", "Cream / Shampoo 2%", "30g / 60mL"),
                BrandInfo("Phytoral", "Micro Labs Nepal", "Cream / Shampoo 2%", "30g / 60mL"),
                BrandInfo("Dandnil", "Deurali-Janta (DJPL) Nepal", "Shampoo 2%", "60 mL / 100 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Nizral", "Janssen India", "Cream / Shampoo 2%", "30g / 60mL"),
                BrandInfo("Phytoral", "Micro Labs", "Cream / Shampoo 2%", "30g / 60mL"),
                BrandInfo("Scalpe Plus", "Glenmark", "Shampoo", "60 mL")
            ),
            adultDose = "Cream: Apply 1-2 times daily x 2-4 weeks. Shampoo: Wash hair twice weekly x 2-4 weeks.",
            childDose = "Safe in children >12 years for dandruff/tinea.",
            contraindications = "Hypersensitivity to ketoconazole or imidazole antifungals.",
            modeOfAction = "Inhibits fungal cytochrome P450 14-alpha-demethylase, blocking conversion of lanosterol to ergosterol in the fungal cell membrane, resulting in toxic methylated sterol accumulation, membrane permeability loss, and fungal lysis.",
            therapeuticClassTag = "Dermatology & Antifungals"
        ),

        Drug(
            id = "d_rem_clotrimazole_topical",
            genericName = "Clotrimazole (1% w/w Cream / 1% w/v Mouth Paint)",
            system = "Dermatology",
            drugClass = "Topical Imidazole Broad-Spectrum Antifungal",
            blackBoxWarning = null,
            indications = "Tinea pedis (athlete's foot), tinea cruris (jock itch), tinea corporis (ringworm); Cutaneous candidiasis, candidal intertrigo, napkin (diaper) candidiasis; Oral candidiasis (thrush - mouth paint).",
            doses = "Cream: Apply to affected skin twice daily for 2 to 4 weeks.\nMouth Paint: Apply 10 to 20 drops (1 mL) to the oral cavity 3 to 4 times daily after meals, spreading over lesions with a clean cotton swab; retain in mouth as long as possible before swallowing.",
            administration = "Cream: Clean and thoroughly dry the affected area before applying. Rub in gently. Mouth Paint: Apply after meals; avoid eating or drinking for 30 minutes after application.",
            timing = "Twice to thrice daily.",
            specialInstructions = "In diaper candidiasis, apply a thin layer at each diaper change after cleansing and drying. Unlike nystatin, clotrimazole also possesses activity against dermatophytes.",
            pkPd = "Negligible systemic absorption (<0.5%) following topical application; concentrates in epidermal stratum corneum.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe for topical and oral thrush use in pregnancy).",
            lactation = "Safe during breastfeeding.",
            sideEffects = "Erythema, stinging, blistering, peeling, pruritus, localized urticaria.",
            priceNpr = "NPR 60.00 - 110.00 per tube (20 g / 30 g) / NPR 75.00 per mouth paint (15 mL)",
            priceInr = "INR 40.00 - 75.00 per tube / INR 50.00 per bottle",
            brandsNepal = listOf(
                BrandInfo("Candid", "Glenmark Nepal", "Cream 1% / Mouth Paint 1%", "30g / 15mL"),
                BrandInfo("Canesten", "Bayer / Nepal", "Cream 1%", "20g / 30g"),
                BrandInfo("Cloderm", "National Healthcare Nepal", "Cream 1%", "20g")
            ),
            brandsIndia = listOf(
                BrandInfo("Candid", "Glenmark", "Cream / Mouth Paint", "30g / 15mL"),
                BrandInfo("Canesten", "Bayer India", "Cream", "30g"),
                BrandInfo("Surfaderm", "Franco-Indian", "Cream", "30g")
            ),
            adultDose = "Cream: Apply BID x 2-4 weeks. Mouth Paint: 10-20 drops TID-QID.",
            childDose = "Safe in neonates and infants for diaper candidiasis and oral thrush.",
            contraindications = "Hypersensitivity to clotrimazole or imidazole antifungals.",
            modeOfAction = "Inhibits fungal biosynthesis of ergosterol by inhibiting cytochrome P450-dependent enzyme 14-alpha-demethylase, impairing fungal cell membrane integrity and causing leakage of intracellular phosphorus compounds and potassium.",
            therapeuticClassTag = "Dermatology & Antifungals"
        ),

        // ==========================================
        // OPHTHALMIC MEDICATIONS
        // ==========================================
        Drug(
            id = "d_rem_carboxymethylcellulose",
            genericName = "Carboxymethylcellulose Sodium (0.5% / 1.0% Eye Drops)",
            system = "Specialty & Rare",
            drugClass = "Ocular Lubricant & Tear Substitute (Artificial Tears)",
            blackBoxWarning = null,
            indications = "Dry Eye Disease (keratoconjunctivitis sicca); Computer vision syndrome, eye strain, burning, irritation, and foreign-body sensation due to environmental dryness, wind, or air conditioning; Post-LASIK ocular lubrication.",
            doses = "Instill 1 to 2 drops into the affected eye(s) 3 to 4 times daily, or as frequently as needed for comfort.",
            administration = "Wash hands before use. Tilt head back, pull down lower eyelid, and instill 1 drop without touching the dropper tip to the eye or skin. Blink several times to spread across cornea.",
            timing = "3 to 4 times daily or as needed.",
            specialInstructions = "Preservative-free single-dose units or vanishing preservative formulas (e.g. Purite) are safe for contact lens wearers. Wait 5 minutes between different ophthalmic medications.",
            pkPd = "Topical ocular surface retention only; binds to corneal epithelial cells to prolong tear film breakup time (TBUT) and protect the glycocalyx. No systemic absorption.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category A (Completely safe; no systemic absorption).",
            lactation = "Safe in lactation.",
            sideEffects = "Transient mild blurring of vision immediately upon instillation, minor sticky sensation, eye discharge.",
            priceNpr = "NPR 160.00 - 320.00 per bottle (10 mL)",
            priceInr = "INR 110.00 - 220.00 per bottle",
            brandsNepal = listOf(
                BrandInfo("Refresh Tears", "Allergan / Medisales Nepal", "Eye Drops", "0.5% (10 mL)"),
                BrandInfo("Lubistar", "Mankind Nepal", "Eye Drops", "0.5% / 1% (10 mL)"),
                BrandInfo("Add Tears", "Sun Pharma Nepal", "Eye Drops", "0.5% (10 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Refresh Tears", "Allergan India", "Eye Drops", "0.5%"),
                BrandInfo("Lubistar", "Mankind", "Eye Drops", "0.5%"),
                BrandInfo("Add Tears", "Sun Pharma", "Eye Drops", "0.5%")
            ),
            adultDose = "1-2 drops in affected eye(s) 3-4 times daily as needed.",
            childDose = "1-2 drops in affected eye(s) as needed.",
            contraindications = "Hypersensitivity to carboxymethylcellulose or formulation excipients.",
            modeOfAction = "High-molecular-weight hydrophilic polymer that mimics the mucin layer of human tears, creating a viscoelastic lubricating coating over the corneal and conjunctival epithelium, reducing tear evaporation and promoting epithelial healing.",
            therapeuticClassTag = "Ophthalmic & Dry Eye"
        ),

        Drug(
            id = "d_rem_bimatoprost",
            genericName = "Bimatoprost (0.03% w/v Eye Drops)",
            system = "Specialty & Rare",
            drugClass = "Prostamide F2-alpha Analog (Ocular Hypotensive Agent)",
            blackBoxWarning = null,
            indications = "Reduction of elevated intraocular pressure (IOP) in adult patients with open-angle glaucoma or ocular hypertension (first-line therapy or in combination with beta-blockers/carbonic anhydrase inhibitors).",
            doses = "Instill 1 drop into the affected eye(s) once daily in the evening.",
            administration = "Instill 1 drop into conjunctival sac in the evening. Perform nasolacrimal occlusion (press inner canthus for 1-2 minutes) to minimize systemic absorption. Remove contact lenses prior to instillation; reinsert after 15 minutes.",
            timing = "Once daily in the evening.",
            specialInstructions = "Counsel patient that bimatoprost causes permanent increased brown pigmentation of the iris, darkening of eyelid skin, and increased growth/thickness/darkening of eyelashes (hypertrichosis). Dosing more than once daily decreases IOP-lowering efficacy.",
            pkPd = "Penetrates cornea into anterior chamber. Peak ocular hypotensive effect at 8-12 hours. Systemic elimination half-life is ~45 minutes after absorption.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Potential to cause uterine contractions; use only if benefit justifies fetal risk).",
            lactation = "Caution advised; safety not established.",
            sideEffects = "Conjunctival hyperemia (redness), iris color change, eyelash growth and darkening, periorbital fat atrophy (prostaglandin-associated periorbitopathy), eye pruritus.",
            priceNpr = "NPR 350.00 - 650.00 per bottle (3 mL)",
            priceInr = "INR 220.00 - 450.00 per bottle (3 mL)",
            brandsNepal = listOf(
                BrandInfo("Lumigan", "Allergan / Medisales Nepal", "Eye Drops", "0.01% / 0.03% (3 mL)"),
                BrandInfo("Careprost", "Sun Pharma Nepal", "Eye Drops", "0.03% (3 mL)"),
                BrandInfo("Bimaprost", "Micro Labs Nepal", "Eye Drops", "0.03% (3 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Lumigan", "Allergan India", "Eye Drops", "0.01% / 0.03%"),
                BrandInfo("Careprost", "Sun Pharma", "Eye Drops", "0.03%"),
                BrandInfo("Bimat", "Ajanta Pharma", "Eye Drops", "0.03%")
            ),
            adultDose = "1 drop into affected eye(s) once daily in the evening.",
            childDose = "Safety and efficacy not established in pediatric patients.",
            contraindications = "Hypersensitivity to bimatoprost; active intraocular inflammation (uveitis, iritis); history of macular edema.",
            modeOfAction = "Synthetic prostamide analog that lowers IOP by mimicking endogenous prostamides to increase aqueous humor outflow through both the trabecular meshwork and uveoscleral outflow pathways.",
            therapeuticClassTag = "Ophthalmic & Glaucoma"
        ),

        Drug(
            id = "d_rem_tropicamide_phenylephrine",
            genericName = "Tropicamide (0.8%) + Phenylephrine Hydrochloride (5.0%) Eye Drops",
            system = "Specialty & Rare",
            drugClass = "Anticholinergic Mydriatic + Alpha-1 Adrenergic Sympathomimetic",
            blackBoxWarning = null,
            indications = "Production of rapid, short-acting mydriasis (pupil dilation) and cycloplegia for diagnostic fundus examination, refraction, and pre-operative ophthalmic surgical procedures.",
            doses = "Instill 1 to 2 drops into the eye(s) 15 to 20 minutes prior to examination or surgery; may repeat once after 10-15 minutes if needed for adequate dilation.",
            administration = "Apply finger pressure to the lacrimal sac at the inner canthus for 1-2 minutes following instillation to minimize systemic cardiovascular and central absorption.",
            timing = "15-20 minutes before diagnostic fundoscopy or procedure.",
            specialInstructions = "Always evaluate anterior chamber depth and intraocular pressure before instillation; strictly contraindicated in patients with shallow anterior chamber angles to prevent precipitating acute angle-closure glaucoma crisis. Warn patients not to drive while pupils are dilated (photophobia and blurred near vision last 4-6 hours).",
            pkPd = "Maximal mydriasis occurs within 20-30 minutes. Complete recovery of pupillary and ciliary function occurs within 4 to 6 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Use only if essential).",
            lactation = "Use with caution.",
            sideEffects = "Photophobia, stinging on instillation, transient blurred vision, elevated intraocular pressure, tachycardia, hypertension, palpitations (from phenylephrine absorption).",
            priceNpr = "NPR 110.00 - 190.00 per bottle (5 mL)",
            priceInr = "INR 70.00 - 130.00 per bottle",
            brandsNepal = listOf(
                BrandInfo("Tropicacyl Plus", "Sun Pharma Nepal", "Eye Drops", "5 mL"),
                BrandInfo("Itrop Plus", "Entod / Medisales Nepal", "Eye Drops", "5 mL"),
                BrandInfo("Tropac-P", "Micro Labs Nepal", "Eye Drops", "5 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Tropicacyl Plus", "Sun Pharma", "Eye Drops", "5 mL"),
                BrandInfo("Itrop Plus", "Entod", "Eye Drops", "5 mL"),
                BrandInfo("Tropac-P", "Micro Labs", "Eye Drops", "5 mL")
            ),
            adultDose = "1-2 drops 15-20 min before ophthalmic examination.",
            childDose = "1 drop in eye; monitor closely for systemic anticholinergic/adrenergic reactions.",
            contraindications = "Narrow-angle or shallow-chamber angle glaucoma; untreated anatomically narrow angles; hypersensitivity; severe coronary artery disease or uncontrolled malignant hypertension.",
            modeOfAction = "Tropicamide competitively blocks muscarinic receptors in the pupillary sphincter muscle and ciliary muscle (causing mydriasis and cycloplegia), while phenylephrine directly stimulates alpha-1 adrenergic receptors in the pupillary dilator muscle (producing synergistic rapid pupil dilation without paralyzing accommodation further).",
            therapeuticClassTag = "Ophthalmic & Diagnostic"
        ),

        // ==========================================
        // ENT & RESPIRATORY PHARMACOTHERAPY
        // ==========================================
        Drug(
            id = "d_rem_fluticasone_nasal",
            genericName = "Fluticasone Furoate / Propionate (Nasal Spray 50 mcg/actuation)",
            system = "Respiratory System",
            drugClass = "Potent Intranasal Glucocorticoid",
            blackBoxWarning = null,
            indications = "Seasonal and perennial allergic rhinitis; Vasomotor non-allergic rhinitis; Management of nasal polyposis.",
            doses = "Adult & Adolescents (>=12 yr): 2 sprays in each nostril once daily (total 200 mcg); once symptoms are controlled, reduce to 1 spray in each nostril once daily (100 mcg).\nChildren (2-11 yr): 1 spray in each nostril once daily (total 100 mcg).",
            administration = "Blow nose gently before use. Shake well. Tilt head slightly forward. Direct spray nozzle slightly outward towards the outer wall of the nostril (away from the central nasal septum) to prevent septal mucosal thinning and epistaxis. Breathe in gently.",
            timing = "Once daily in the morning.",
            specialInstructions = "Full therapeutic effect may take several days (3-7 days) of regular daily use to develop; emphasize that this is a controller medication, not an immediate on-demand decongestant.",
            pkPd = "Negligible systemic bioavailability (<1-2%) due to poor mucosal absorption and extensive first-pass hepatic metabolism by CYP3A4 to inactive carboxylic acid.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Severe hepatic impairment may increase systemic exposure; monitor.",
            pregnancy = "Category C (Considered first-line intranasal steroid in pregnancy alongside budesonide; negligible systemic absorption).",
            lactation = "Safe during breastfeeding.",
            sideEffects = "Epistaxis (nasal bleeding), nasal dryness, burning or stinging, headache, pharyngitis, unpleasant taste, nasal septal perforation (rare with incorrect septal angling).",
            priceNpr = "NPR 350.00 - 580.00 per spray (120 actuations)",
            priceInr = "INR 240.00 - 420.00 per spray",
            brandsNepal = listOf(
                BrandInfo("Flomist", "Cipla Nepal", "Aqueous Nasal Spray", "50 mcg (120 doses)"),
                BrandInfo("Furamist", "Cipla Nepal", "Aqueous Nasal Spray", "27.5 mcg (120 doses)"),
                BrandInfo("Fluticone", "Sun Pharma Nepal", "Aqueous Nasal Spray", "50 mcg (120 doses)")
            ),
            brandsIndia = listOf(
                BrandInfo("Flomist", "Cipla", "Nasal Spray", "50 mcg"),
                BrandInfo("Furamist", "Cipla", "Nasal Spray", "27.5 mcg"),
                BrandInfo("Avamys", "GSK India", "Nasal Spray", "27.5 mcg")
            ),
            adultDose = "2 sprays per nostril once daily, titrate to 1 spray per nostril maintenance.",
            childDose = "Children 2-11 yr: 1 spray per nostril once daily.",
            contraindications = "Hypersensitivity; recent nasal ulcers, nasal surgery, or untreated nasal trauma until healed.",
            modeOfAction = "Potently binds glucocorticoid receptors with high lipophilicity, repressing transcription of pro-inflammatory cytokines, chemokines, and adhesion molecules, while inhibiting mast cell, eosinophil, and basophil mediator release in the nasal mucosa.",
            therapeuticClassTag = "Respiratory & Allergic Rhinitis"
        ),

        Drug(
            id = "d_rem_budesonide_respules",
            genericName = "Budesonide Respules (0.5 mg / 1.0 mg Nebulizer Suspension)",
            system = "Respiratory System",
            drugClass = "Inhaled Corticosteroid (ICS) Nebulizer Suspension",
            blackBoxWarning = null,
            indications = "Acute exacerbation of bronchial asthma in adults and children; Maintenance treatment of persistent asthma; Acute laryngotracheobronchitis (Viral Croup) in infants and young children; Acute exacerbation of COPD.",
            doses = "Acute Asthma Exacerbation / Maintenance: Adult: 1 mg to 2 mg nebulized twice daily. Pediatric (>=6 months): 0.25 mg to 0.5 mg nebulized twice daily (or 1 mg once daily).\nViral Croup (Pediatric 6 mo - 6 yr): 2 mg stat single dose via jet nebulizer (or 1 mg every 12 hours).",
            administration = "Administer via a jet nebulizer connected to an air compressor with a face mask or mouthpiece. Do not use ultrasonic nebulizers. Rinse patient's mouth with water and wash face after treatment to prevent oral thrush and facial steroid dermatitis.",
            timing = "Twice daily in asthma or stat in croup.",
            specialInstructions = "In acute viral croup, nebulized budesonide 2 mg produces clinical improvement within 1-2 hours and reduces emergency admission rates comparable to oral dexamethasone 0.6 mg/kg.",
            pkPd = "Oral bioavailability is only 10% due to 90% first-pass hepatic metabolism. Systemic half-life ~2-3 hours. Undergoes reversible intracellular fatty acid conjugation in airway tissues, providing prolonged local pulmonary anti-inflammatory action.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Severe hepatic impairment increases systemic bioavailability; monitor.",
            pregnancy = "Category B (Most studied and safest inhaled steroid during pregnancy).",
            lactation = "Safe during breastfeeding.",
            sideEffects = "Oropharyngeal candidiasis (thrush), hoarseness, cough, dysphonia, facial skin irritation if mask not washed, paradoxical bronchospasm.",
            priceNpr = "NPR 35.00 - 65.00 per respule (2 mL) / NPR 180.00 - 300.00 per pack of 5",
            priceInr = "INR 22.00 - 45.00 per respule",
            brandsNepal = listOf(
                BrandInfo("Budecort Respules", "Cipla Nepal", "Nebulizer Suspension", "0.5 mg / 1.0 mg (2 mL)"),
                BrandInfo("Pulmicort Respules", "AstraZeneca / Medisales Nepal", "Nebulizer Suspension", "0.5 mg / 1.0 mg (2 mL)"),
                BrandInfo("Budate Respules", "Zydus Nepal", "Nebulizer Suspension", "0.5 mg / 1.0 mg (2 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Budecort Respules", "Cipla", "Respules", "0.5 mg / 1.0 mg"),
                BrandInfo("Pulmicort Respules", "AstraZeneca", "Respules", "0.5 mg / 1.0 mg"),
                BrandInfo("Budate Respules", "Zydus", "Respules", "0.5 mg / 1.0 mg")
            ),
            adultDose = "1 mg to 2 mg nebulized BID.",
            childDose = "0.25-0.5 mg nebulized BID. Croup: 2 mg single dose.",
            contraindications = "Status asthmaticus as sole monotherapy without bronchodilators; hypersensitivity.",
            modeOfAction = "Potent anti-inflammatory glucocorticoid that diffuses into respiratory epithelial and mucosal cells, inhibiting NF-kappa-B, decreasing airway hyperresponsiveness, reducing mucosal edema, and suppressing inflammatory exudation.",
            therapeuticClassTag = "Respiratory & Inhaled Steroids"
        ),

        Drug(
            id = "d_rem_duolin_respules",
            genericName = "Levosalbutamol (1.25 mg) + Ipratropium Bromide (500 mcg) Respules / Inhaler",
            system = "Respiratory System",
            drugClass = "Short-Acting Beta-2 Agonist (SABA) + Short-Acting Muscarinic Antagonist (SAMA)",
            blackBoxWarning = null,
            indications = "Acute management of severe bronchospasm in Chronic Obstructive Pulmonary Disease (COPD) and Bronchial Asthma; Emergency room bronchodilation protocol.",
            doses = "Nebulization: One respule (containing Levosalbutamol 1.25 mg + Ipratropium 500 mcg in 2.5 mL) nebulized via jet nebulizer every 6 to 8 hours (or every 20-30 min for up to 3 doses in acute severe asthma/COPD exacerbation).\nMetered Dose Inhaler: 1 to 2 puffs QID via spacer.",
            administration = "Administer via jet nebulizer using a mouthpiece or tightly fitting face mask. Protect eyes from nebulized mist to avoid pupillary dilation and precipitating acute narrow-angle glaucoma.",
            timing = "Every 6-8 hours or PRN for acute respiratory distress.",
            specialInstructions = "Levosalbutamol is the active (R)-enantiomer of racemic salbutamol, possessing 100-fold higher affinity for beta-2 receptors without the pro-inflammatory and pro-arrhythmic adverse effects associated with (S)-salbutamol. Dual action provides greater and more prolonged bronchodilation than either agent alone.",
            pkPd = "Onset of bronchodilation within 3-5 minutes. Peak effect at 1-2 hours. Duration of action 4-6 hours. Minimal systemic absorption of ipratropium (<2%).",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Benefit strongly outweighs risk in acute maternal bronchospasm).",
            lactation = "Use with caution.",
            sideEffects = "Tremor, tachycardia, palpitations, dry mouth, headache, nervousness, nausea, urinary hesitancy, blurred vision if mist enters eyes.",
            priceNpr = "NPR 35.00 - 65.00 per respule (2.5 mL) / NPR 170.00 - 280.00 per pack of 5",
            priceInr = "INR 25.00 - 45.00 per respule",
            brandsNepal = listOf(
                BrandInfo("Duolin Respules", "Cipla Nepal", "Nebulizer Solution", "1.25mg Levo + 500mcg Ipra (2.5mL)"),
                BrandInfo("Combimist-L", "Sun Pharma Nepal", "Respules", "1.25mg Levo + 500mcg Ipra"),
                BrandInfo("Duolin Inhaler", "Cipla Nepal", "MDI", "50mcg Levo + 20mcg Ipra (200 doses)")
            ),
            brandsIndia = listOf(
                BrandInfo("Duolin Respules", "Cipla", "Respules", "2.5 mL"),
                BrandInfo("Combimist-L", "Sun Pharma", "Respules", "2.5 mL"),
                BrandInfo("Duolin Inhaler", "Cipla", "Inhaler", "200 doses")
            ),
            adultDose = "1 respule nebulized every 6-8 hours PRN.",
            childDose = "Children >6 yr: 1 respule nebulized every 6-8 hours. Children <6 yr: Half respule (1.25 mL) nebulized.",
            contraindications = "Known hypersensitivity to levosalbutamol, ipratropium, or atropine derivatives; hypertrophic obstructive cardiomyopathy; severe tachyarrhythmias.",
            modeOfAction = "Dual complementary bronchodilation: Levosalbutamol selectively stimulates beta-2 adrenoceptors, increasing intracellular cAMP and relaxing bronchial smooth muscle from large airways to terminal bronchioles; Ipratropium competitively blocks acetylcholine at muscarinic M3 receptors in large central airways, preventing cholinergic bronchoconstriction.",
            therapeuticClassTag = "Respiratory & Bronchodilators"
        ),

        Drug(
            id = "d_rem_dextromethorphan_cpm",
            genericName = "Dextromethorphan Hydrobromide (10 mg) + Chlorpheniramine Maleate (2 mg) Syrup",
            system = "Respiratory System",
            drugClass = "Centrally Acting Non-Opioid Antitussive + First-Generation Alkylamine Antihistamine",
            blackBoxWarning = "SEROTONIN SYNDROME RISK: Do not use concurrently with or within 14 days of Monoamine Oxidase Inhibitors (MAOIs) or potent serotonergic medications due to risk of fatal serotonin syndrome.",
            indications = "Temporary symptomatic relief of dry, hacking, non-productive cough associated with acute viral upper respiratory tract infections, pharyngitis, tracheitis, and allergic rhinitis.",
            doses = "Adult & Adolescents (>=12 yr): 10 mL (Dextromethorphan 20 mg + CPM 4 mg) PO every 6 to 8 hours as needed (max 40 mL/day).\nChildren (6-11 yr): 5 mL (Dextromethorphan 10 mg + CPM 2 mg) PO every 6 to 8 hours (max 20 mL/day).",
            administration = "Take orally with a measuring cup or spoon. May be taken with or without food. Bedtime dosing helps suppress cough-induced insomnia.",
            timing = "Every 6-8 hours as needed.",
            specialInstructions = "Do NOT use for productive, phlegmy cough (suppressing a productive cough impairs mucociliary clearance and can cause retained secretions and bronchopneumonia). Avoid in children <6 years.",
            pkPd = "Well absorbed orally. Dextromethorphan is extensively metabolized in the liver via CYP2D6 to its active antitussive metabolite dextrorphan. Half-life is 2-4 hours. Chlorpheniramine half-life is 14-25 hours.",
            renalAdj = "Use with caution in moderate to severe renal impairment.",
            hepaticAdj = "Use with caution; reduce dose or extend dosing interval.",
            pregnancy = "Category C (Avoid in 1st trimester; use non-pharmacological remedies where possible).",
            lactation = "Avoid during breastfeeding (antihistamines can suppress lactation and cause infant drowsiness).",
            sideEffects = "Drowsiness, sedation, dizziness, dry mouth, nausea, constipation, mild blurred vision, psychomotor impairment.",
            priceNpr = "NPR 110.00 - 180.00 per bottle (100 mL)",
            priceInr = "INR 75.00 - 130.00 per bottle (100 mL)",
            brandsNepal = listOf(
                BrandInfo("Ascoril D Plus", "Glenmark Nepal", "Syrup", "100 mL (10mg DM + 2mg CPM/5mL)"),
                BrandInfo("Zedex", "Wockhardt / Nepal", "Syrup", "100 mL"),
                BrandInfo("Benylin Dry", "Johnson & Johnson / Medisales Nepal", "Syrup", "100 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Ascoril D Plus", "Glenmark", "Syrup", "100 mL"),
                BrandInfo("Zedex", "Wockhardt", "Syrup", "100 mL"),
                BrandInfo("TusQ-D", "Blue Cross", "Syrup", "100 mL")
            ),
            adultDose = "10 mL PO every 6-8 hours PRN (max 40 mL/day).",
            childDose = "Children 6-11 yr: 5 mL PO every 6-8 hours PRN.",
            contraindications = "Concurrent MAOI therapy (or within 14 days); productive cough with copious secretions; severe asthma or respiratory failure; children under 6 years.",
            modeOfAction = "Dextromethorphan acts centrally on the medullary cough center to elevate the cough reflex threshold (via sigma-1 receptor agonism and NMDA receptor antagonism), while chlorpheniramine competitively blocks peripheral H1 receptors, reducing post-nasal drip, sneezing, and histamine-mediated airway irritation.",
            therapeuticClassTag = "Respiratory & Cough Syrups"
        )
    )
}
