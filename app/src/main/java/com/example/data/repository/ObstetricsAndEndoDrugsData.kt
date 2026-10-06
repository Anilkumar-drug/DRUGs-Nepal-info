package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object ObstetricsAndEndoDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // OBSTETRICS & GYNECOLOGY
        // ==========================================
        Drug(
            id = "d_obgyn_oxytocin",
            genericName = "Oxytocin",
            system = "Renal & Genitourinary",
            drugClass = "Uterotonic Pituitary Nonapeptide Hormone",
            blackBoxWarning = "ELECTIVE INDUCTION: Not indicated for elective induction of labor. Only indicated for medically necessary induction.",
            indications = "Induction and augmentation of labor, Active Management of Third Stage of Labor (AMTSL), prevention and treatment of Postpartum Hemorrhage (PPH).",
            doses = "PPH Prevention (AMTSL): 10 IU IM or slow IV (over 1 min) immediately after delivery of anterior shoulder. PPH Treatment: 20-40 IU in 1000 mL NS/RL at 250-500 mL/hr. Induction: 0.5-2 mU/min IV infusion, titrated by 1-2 mU/min q30-60min.",
            administration = "IV infusion via controlled pump or IM. Never administer as undiluted rapid IV bolus (causes severe hypotension and reflex tachycardia).",
            timing = "Immediately upon delivery of neonate.",
            specialInstructions = "Continuous electronic fetal monitoring required during induction. Prolonged high-dose infusion with electrolyte-free fluids causes water intoxication.",
            pkPd = "Onset: IV immediate, IM 3-5 min. Plasma half-life 1-6 minutes. Hepatic and renal clearance by oxytocinase.",
            renalAdj = "Antidiuretic effect; use with caution and avoid hypotonic IV solutions.",
            hepaticAdj = "No formal dose adjustment needed.",
            pregnancy = "Category X for non-labor indications; indicated for labor induction.",
            lactation = "Natural hormone; safe and promotes milk let-down reflex.",
            sideEffects = "Uterine hyperstimulation, fetal distress, uterine rupture, maternal hypotension, water intoxication, hyponatremia.",
            priceNpr = "NPR 18.00 - 35.00 per 10 IU ampoule",
            priceInr = "INR 12.00 - 25.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Syntocinon", "Novartis / Medisales Nepal", "Inj", "5 IU / 10 IU"),
                BrandInfo("Pitocin", "Pfizer Nepal", "Inj", "10 IU/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Syntocinon", "Novartis", "Inj", "5 / 10 IU"),
                BrandInfo("Pitocin", "Pfizer", "Inj", "10 IU")
            ),
            adultDose = "10 IU IM or 20-40 IU in 1000 mL RL IV infusion for PPH.",
            contraindications = "Significant cephalopelvic disproportion, fetal distress, placenta previa, hypertonic uterine patterns, previous classical uterine scar.",
            modeOfAction = "Acts selectively on G-protein coupled oxytocin receptors in myometrium, stimulating calcium influx and rhythmic uterine contractions.",
            therapeuticClassTag = "Uterotonics / Labor"
        ),

        Drug(
            id = "d_obgyn_methylergonovine",
            genericName = "Methylergonovine Maleate (Methylergometrine)",
            system = "Renal & Genitourinary",
            drugClass = "Ergot Alkaloid Uterotonic",
            blackBoxWarning = "DO NOT ADMINISTER BEFORE DELIVERY: High risk of uterine rupture and fetal death. Contraindicated for induction/augmentation of labor.",
            indications = "Management and treatment of uterine atony and postpartum/postabortal hemorrhage.",
            doses = "Adult: 0.2 mg IM or slow IV (over >= 1 minute) after delivery of placenta. May repeat q2-4h (max 5 doses). Oral: 0.2 mg PO TID-QID for up to 7 days.",
            administration = "Administer IM into large muscle. IV only in emergency life-threatening PPH diluted in 5 mL NS injected slowly.",
            timing = "After delivery of placenta.",
            specialInstructions = "STRICT CONTRAINDICATION in pre-eclampsia, eclampsia, chronic hypertension, and ischemic heart disease (causes acute severe vasospasm and hypertensive crisis).",
            pkPd = "Onset: IM 2-5 min, IV immediate, PO 5-10 min. Duration 3 hours. Hepatic metabolism. Half-life ~3.4 hours.",
            renalAdj = "Use with caution; clearance reduced in renal impairment.",
            hepaticAdj = "Contraindicated in severe hepatic impairment.",
            pregnancy = "Category X (strictly contraindicated during pregnancy).",
            lactation = "Suppresses prolactin; small amounts excreted in milk. Avoid prolonged postpartum use.",
            sideEffects = "Severe hypertension, headache, seizures, chest pain, palpitations, nausea, vomiting, peripheral vasospasm (ergotism).",
            priceNpr = "NPR 15.00 - 30.00 per ampoule (0.2mg/mL)",
            priceInr = "INR 10.00 - 20.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Methergine", "Novartis / Medisales Nepal", "Inj / Tab", "0.2 mg/mL / 0.125 mg"),
                BrandInfo("Metargan", "Neon Laboratories", "Inj", "0.2 mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Methergine", "Novartis India", "Inj / Tab", "0.2 mg / 0.125 mg"),
                BrandInfo("Ergomet", "Sun Pharma", "Inj", "0.2 mg")
            ),
            adultDose = "0.2 mg IM or slow IV post-placenta; 0.2 mg PO TID.",
            contraindications = "Hypertension, pre-eclampsia, eclampsia, coronary artery disease, peripheral vascular disease, sepsis.",
            modeOfAction = "Acts directly on smooth muscle of the uterus, stimulating prolonged tetanic uterine contractions and constricting open placental bed vessels.",
            therapeuticClassTag = "Uterotonics / Labor"
        ),

        Drug(
            id = "d_obgyn_carboprost",
            genericName = "Carboprost Tromethamine (15-Methyl PGF2α)",
            system = "Renal & Genitourinary",
            drugClass = "Prostaglandin F2-alpha Analogue Uterotonic",
            blackBoxWarning = "HOSPITAL USE ONLY: Administer only in healthcare facilities with experienced obstetrical staff.",
            indications = "Refractory postpartum hemorrhage due to uterine atony unresponsive to oxytocin and ergometrine, second-trimester termination of pregnancy.",
            doses = "Refractory PPH: 250 mcg (1 mL) deep IM. May repeat every 15 to 90 minutes as needed (max total cumulative dose 2 mg or 8 doses).",
            administration = "Deep IM injection using 1.5-inch needle into gluteal or thigh muscle. Do not administer IV (precipitates bronchospasm and shock).",
            timing = "Stat upon failure of first-line uterotonics.",
            specialInstructions = "STRICT CONTRAINDICATION in active bronchial asthma (potent bronchoconstrictor). Pre-treatment with antiemetics and antidiarrheals is common.",
            pkPd = "Peak plasma concentration within 15-60 minutes. Duration of uterine stimulation up to 2-3 hours. Extensive enzymatic oxidation.",
            renalAdj = "Use with caution in renal failure.",
            hepaticAdj = "Use with caution in active hepatic disease.",
            pregnancy = "Indicated for uterine atony post-delivery and therapeutic abortion.",
            lactation = "Transient excretion in milk; unlikely to affect infant.",
            sideEffects = "Severe diarrhea (>60%), vomiting, nausea, bronchospasm, transient fever/flushing, hypertension, shivering.",
            priceNpr = "NPR 350.00 - 650.00 per ampoule (250 mcg)",
            priceInr = "INR 250.00 - 450.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Hemabate", "Pfizer Nepal", "Inj", "250 mcg/mL"),
                BrandInfo("Prostodin", "AstraZeneca / Neon", "Inj", "250 mcg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Hemabate", "Pfizer", "Inj", "250 mcg"),
                BrandInfo("Prostodin", "Neon Labs", "Inj", "250 mcg")
            ),
            adultDose = "250 mcg deep IM q15-90min prn (max 2 mg).",
            contraindications = "Active bronchial asthma, acute pelvic inflammatory disease, active cardiac or pulmonary disease.",
            modeOfAction = "Stimulates prostaglandin FP receptors in myometrium, producing powerful sustained uterine contractions and hemostasis at placental site.",
            therapeuticClassTag = "Uterotonics / Labor"
        ),

        Drug(
            id = "d_obgyn_dinoprostone",
            genericName = "Dinoprostone (Prostaglandin E2 / PGE2)",
            system = "Renal & Genitourinary",
            drugClass = "Prostaglandin E2 Cervical Ripening Agent",
            blackBoxWarning = "QUALIFIED HEALTHCARE PERSONNEL: Administer only in hospital settings with fetal and uterine monitoring.",
            indications = "Cervical ripening in pregnant women at or near term with unfavorable cervix (Bishop score <= 6) prior to labor induction.",
            doses = "Intracervical Gel: 0.5 mg administered into cervical canal. May repeat after 6 hours (max 1.5 mg in 24 hr). Vaginal Insert: 10 mg timed-release insert over 24 hours.",
            administration = "Administer under aseptic conditions. Patient must remain supine for 30 minutes following gel application. Remove insert if active labor starts.",
            timing = "Evening or morning prior to planned induction.",
            specialInstructions = "Oxytocin should not be started for at least 6 hours after gel application, or 30 minutes after removal of vaginal insert.",
            pkPd = "Local absorption with slow systemic diffusion. Rapidly metabolized in maternal lungs and liver. Plasma half-life <1 minute.",
            renalAdj = "No adjustment needed for localized topical administration.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Indicated for cervical ripening at term gestation.",
            lactation = "Not applicable at time of administration.",
            sideEffects = "Uterine tachysystole, uterine hyperstimulation with fetal heart rate abnormalities, back pain, warm feeling in vagina, fever.",
            priceNpr = "NPR 450.00 - 850.00 per pre-filled syringe (0.5mg)",
            priceInr = "INR 300.00 - 600.00 per syringe",
            brandsNepal = listOf(
                BrandInfo("Cerviprime", "AstraZeneca / Neon Nepal", "Gel", "0.5 mg in 3g syringe"),
                BrandInfo("Primigyn", "Bharat Serums Nepal", "Gel", "0.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cerviprime", "Neon Labs", "Gel", "0.5 mg"),
                BrandInfo("Propess", "Ferring Pharmaceuticals", "Vaginal Insert", "10 mg")
            ),
            adultDose = "0.5 mg intracervical gel q6h (max 1.5 mg/24h).",
            contraindications = "Previous cesarean section or major uterine surgery, cephalopelvic disproportion, placenta previa, unexplained vaginal bleeding.",
            modeOfAction = "Degrades collagen network and increases hyaluronic acid and water content in cervical ground substance, softening and dilating cervix.",
            therapeuticClassTag = "Obstetrics / Cervical Ripening"
        ),

        Drug(
            id = "d_obgyn_mifepristone",
            genericName = "Mifepristone (RU-486)",
            system = "Renal & Genitourinary",
            drugClass = "Selective Progesterone Receptor Modulator (SPRM)",
            blackBoxWarning = "SERIOUS INFECTION & BLEEDING: Serious and sometimes fatal bacterial infections (Clostridium sordellii) and prolonged bleeding can occur after medical abortion.",
            indications = "Medical termination of intrauterine pregnancy up to 63-70 days gestation (in combination with Misoprostol), induction of labor in intrauterine fetal demise (IUFD).",
            doses = "Medical Abortion: 200 mg PO single dose, followed 24-48 hours later by Misoprostol 800 mcg buccally/sublingually/vaginally. IUFD: 200 mg PO daily for 2 days.",
            administration = "Take orally with water. Swallow tablet whole.",
            timing = "Single dose on Day 1.",
            specialInstructions = "Requires confirmed intrauterine gestation by ultrasound. Rule out ectopic pregnancy prior to administration. Follow-up visit at 14 days mandatory.",
            pkPd = "Rapid oral absorption; bioavailability ~69%. Protein binding 98%. Extensively metabolized by CYP3A4. Half-life 18 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution; CYP3A4 clearance reduced in cirrhosis.",
            pregnancy = "Contraindicated if patient desires pregnancy continuation.",
            lactation = "Excreted in breast milk; discard breast milk for 3-4 days after ingestion.",
            sideEffects = "Vaginal bleeding, uterine cramping, nausea, vomiting, diarrhea, headache, dizziness, pelvic pain.",
            priceNpr = "NPR 450.00 - 800.00 per combipack (MTP Kit)",
            priceInr = "INR 300.00 - 550.00 per kit",
            brandsNepal = listOf(
                BrandInfo("MTP Kit", "Cipla Nepal", "Pack", "Mifepristone 200mg + 4x Misoprostol 200mcg"),
                BrandInfo("Mifegest Kit", "Zydus Nepal", "Pack", "Combikit")
            ),
            brandsIndia = listOf(
                BrandInfo("Mifeprex", "Danco / Cipla", "Tab", "200 mg"),
                BrandInfo("MTP Kit", "Cipla", "Combikit", "1 Tab + 4 Tabs")
            ),
            adultDose = "200 mg PO once, followed by misoprostol 24-48h later.",
            contraindications = "Confirmed or suspected ectopic pregnancy, chronic adrenal failure, concurrent long-term corticosteroid therapy, bleeding disorders, IUD in place.",
            modeOfAction = "Competitively binds to intracellular progesterone receptors, antagonizing progesterone, decidualizing endometrium, softening cervix, and sensitizing myometrium to prostaglandins.",
            therapeuticClassTag = "Reproductive Health / MTP"
        ),

        Drug(
            id = "d_obgyn_norethisterone",
            genericName = "Norethisterone (Norethindrone)",
            system = "Renal & Genitourinary",
            drugClass = "19-Norsteroid Synthetic Progestin",
            blackBoxWarning = "CARDIOVASCULAR DISORDERS: Increased risk of thrombotic events when combined with estrogens.",
            indications = "Dysfunctional Uterine Bleeding (DUB), postponement of menstruation, menorrhagia, secondary amenorrhea, endometriosis, premenstrual syndrome (PMS).",
            doses = "DUB Acute Hemostasis: 5 mg PO TID for 10 days. Postponement of Menses: 5 mg PO TID starting 3 days before expected period, continued for max 14 days. Endometriosis: 5 mg PO BID for 6-9 months.",
            administration = "Take orally with a glass of water with or after meals.",
            timing = "Regularly spaced 8-hourly intervals.",
            specialInstructions = "Bleeding usually stops within 48 hours of starting treatment for DUB; withdrawal bleeding occurs 2-3 days after stopping.",
            pkPd = "Rapid absorption; bioavailability 64%. Extensively metabolized in liver. Excreted in urine and feces. Half-life 5-12 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Contraindicated in acute liver disease or hepatic tumors.",
            pregnancy = "Category X (strictly contraindicated; virilization of female fetus).",
            lactation = "Excreted in breast milk; progestin-only pills preferred in postpartum.",
            sideEffects = "Breakthrough bleeding, spotting, weight gain, fluid retention, breast tenderness, acne, hirsutism, mood swings, headache.",
            priceNpr = "NPR 70.00 - 150.00 per strip of 10 (5mg)",
            priceInr = "INR 45.00 - 100.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Primolut-N", "Bayer / Zydus Nepal", "Tab", "5 mg"),
                BrandInfo("Regestrone", "Novartis / Medisales", "Tab", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Primolut-N", "Bayer India", "Tab", "5 mg"),
                BrandInfo("Regestrone", "Novartis", "Tab", "5 mg")
            ),
            adultDose = "5 mg PO TID x 10 days for DUB or postponement.",
            contraindications = "Undiagnosed abnormal vaginal bleeding, active venous thromboembolism (DVT/PE), severe arterial disease, breast or genital malignancy, acute liver disease.",
            modeOfAction = "Transforms proliferative endometrium into secretory state, suppresses pituitary gonadotropins, and prevents endometrial breakdown.",
            therapeuticClassTag = "Gynecology / Progestins"
        ),

        Drug(
            id = "d_obgyn_levonorgestrel_emergency",
            genericName = "Levonorgestrel (1.5 mg Emergency Pill)",
            system = "Renal & Genitourinary",
            drugClass = "Synthetic Second-Generation Progestin",
            blackBoxWarning = null,
            indications = "Emergency post-coital contraception within 72 hours of unprotected intercourse or contraceptive failure.",
            doses = "1.5 mg PO as a single dose as soon as possible after intercourse (within 72 hours). Alternatively, 0.75 mg PO taken 12 hours apart.",
            administration = "Take orally with water. If vomiting occurs within 2 hours of ingestion, repeat the dose.",
            timing = "Stat within 72 hours (greatest efficacy within first 24 hours).",
            specialInstructions = "Does not terminate an established pregnancy. Not intended as routine regular contraception.",
            pkPd = "Rapid and complete absorption; peak plasma concentration at 1.6-2 hours. Protein binding >98%. Elimination half-life ~24-32 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution in severe hepatic dysfunction.",
            pregnancy = "Contraindicated if known established pregnancy (ineffective, but not teratogenic).",
            lactation = "Compatible with breastfeeding; nursing can be resumed 8 hours after single dose.",
            sideEffects = "Nausea, lower abdominal pain, fatigue, headache, dizziness, breast tenderness, menstrual irregularity/early or delayed menses.",
            priceNpr = "NPR 100.00 - 200.00 per single-tablet pack (1.5mg)",
            priceInr = "INR 70.00 - 140.00 per pack",
            brandsNepal = listOf(
                BrandInfo("i-pill", "Piramal Healthcare / Nepal", "Tab", "1.5 mg"),
                BrandInfo("E-Pill", "Nepal Pharmaceuticals Lab", "Tab", "1.5 mg"),
                BrandInfo("Unwanted-72", "Mankind Pharma Nepal", "Tab", "1.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("i-pill", "Piramal", "Tab", "1.5 mg"),
                BrandInfo("Unwanted-72", "Mankind", "Tab", "1.5 mg")
            ),
            adultDose = "1.5 mg PO single dose within 72 hours.",
            contraindications = "Known pregnancy; severe hypersensitivity.",
            modeOfAction = "Prevents ovulation by suppressing luteinizing hormone (LH) surge; thickens cervical mucus to prevent sperm penetration.",
            therapeuticClassTag = "Emergency Contraception"
        ),

        Drug(
            id = "d_obgyn_clomiphene",
            genericName = "Clomiphene Citrate",
            system = "Renal & Genitourinary",
            drugClass = "Selective Estrogen Receptor Modulator (SERM) / Ovulation Stimulant",
            blackBoxWarning = null,
            indications = "Ovulatory dysfunction and infertility in polycystic ovary syndrome (PCOS), oligo-ovulation, luteal phase defect.",
            doses = "50 mg PO once daily for 5 consecutive days starting on cycle day 2, 3, 4, or 5. If ovulation does not occur, dose may be increased to 100 mg daily for 5 days in subsequent cycles (max 150 mg/day; max 6 cycles).",
            administration = "Take orally once daily at approximately the same time.",
            timing = "Days 3 to 7 or Days 5 to 9 of menstrual cycle.",
            specialInstructions = "Monitor for Ovarian Hyperstimulation Syndrome (OHSS) and multiple gestation (twin pregnancy occurs in ~8-10%).",
            pkPd = "Well absorbed orally. Enantiomeric mixture (zuclomiphene has half-life ~30 days). Excreted in feces via biliary pathway.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Contraindicated in liver disease or history of hepatic dysfunction.",
            pregnancy = "Category X (strictly contraindicated once conception occurs).",
            lactation = "May reduce lactation; not indicated during nursing.",
            sideEffects = "Ovarian enlargement, pelvic discomfort, hot flashes, visual disturbances (scotomas, blurring), abdominal distension, multiple pregnancy.",
            priceNpr = "NPR 120.00 - 250.00 per strip of 10 (50mg)",
            priceInr = "INR 80.00 - 170.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Fertomid", "Cipla Nepal", "Tab", "25 mg / 50 mg"),
                BrandInfo("Clofert", "Maneesh Pharmaceuticals", "Tab", "50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Fertomid", "Cipla", "Tab", "50 / 100 mg"),
                BrandInfo("Clofert", "Maneesh", "Tab", "50 / 100 mg")
            ),
            adultDose = "50-100 mg PO daily x 5 days starting cycle day 3-5.",
            contraindications = "Pregnancy, ovarian cysts or enlargement not due to PCOS, abnormal uterine bleeding, liver disease, hormone-dependent tumors.",
            modeOfAction = "Competitively antagonizes hypothalamic estrogen receptors, blocking negative feedback of estrogen and stimulating pulsatile release of GnRH, FSH, and LH to trigger follicular growth.",
            therapeuticClassTag = "Fertility & Ovulation"
        ),

        // ==========================================
        // DIABETES & METABOLISM
        // ==========================================
        Drug(
            id = "d_endo_gliclazide",
            genericName = "Gliclazide (Modified Release)",
            system = "Endocrine & Metabolic System",
            drugClass = "Second-Generation Sulfonylurea Antidiabetic",
            blackBoxWarning = "HYPOGLYCEMIA & CARDIOVASCULAR MORTALITY: Sulfonylureas can produce severe, prolonged hypoglycemia.",
            indications = "Type 2 Diabetes Mellitus in adults inadequately controlled with diet, exercise, and metformin monotherapy.",
            doses = "MR Formulation: 30 to 120 mg PO once daily with morning breakfast. Immediate Release: 40 to 160 mg PO BID with meals (max 320 mg/day).",
            administration = "Take with breakfast. Swallow modified-release tablets whole; do not chew or crush.",
            timing = "Morning with first bite of breakfast.",
            specialInstructions = "Lower hypoglycemia risk compared to glibenclamide or glimepiride due to reversible binding kinetics and antioxidant properties (ADVANCE trial).",
            pkPd = "Complete oral absorption. Protein binding 95%. Hepatic metabolism via CYP2C9 and CYP2C19. Elimination half-life 12-20 hours.",
            renalAdj = "Mild-to-moderate CKD (eGFR 30-60 mL/min): Start 30 mg MR daily. eGFR <30 mL/min: Contraindicated.",
            hepaticAdj = "Severe hepatic impairment: Contraindicated (risk of severe hypoglycemia).",
            pregnancy = "Category C (Insulin preferred in pregnancy; discontinued if pregnant).",
            lactation = "Contraindicated; passes into breast milk and causes neonatal hypoglycemia.",
            sideEffects = "Hypoglycemia, weight gain, dyspepsia, nausea, mild skin rashes, elevated liver enzymes.",
            priceNpr = "NPR 70.00 - 160.00 per strip of 10 (30mg / 60mg MR)",
            priceInr = "INR 45.00 - 110.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Diamicron MR", "Servier / Medisales Nepal", "Tab", "30 mg / 60 mg"),
                BrandInfo("Reclide MR", "Alembic Nepal", "Tab", "30 mg / 60 mg"),
                BrandInfo("Glychek", "Intas Pharmaceuticals", "Tab", "40 mg / 80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Diamicron", "Servier India", "Tab", "30 / 60 mg MR"),
                BrandInfo("Reclide", "Alembic", "Tab", "30 / 60 mg MR")
            ),
            adultDose = "30-120 mg PO once daily with breakfast.",
            contraindications = "Type 1 diabetes, diabetic ketoacidosis (DKA), severe renal or hepatic failure, treatment with miconazole.",
            modeOfAction = "Selectively binds to SUR1 regulatory subunit of ATP-sensitive K+ channels on pancreatic beta cells, stimulating physiological insulin release.",
            therapeuticClassTag = "OHA / Sulfonylureas"
        ),

        Drug(
            id = "d_endo_pioglitazone",
            genericName = "Pioglitazone Hydrochloride",
            system = "Endocrine & Metabolic System",
            drugClass = "Thiazolidinedione (TZD / Insulin Sensitizer)",
            blackBoxWarning = "CONGESTIVE HEART FAILURE: Thiazolidinediones cause dose-related fluid retention which can lead to or exacerbate congestive heart failure. Contraindicated in NYHA Class III or IV heart failure.",
            indications = "Type 2 Diabetes Mellitus as dual or triple oral therapy, non-alcoholic steatohepatitis (NASH / MASH with fibrosis).",
            doses = "Adult: 15 mg PO once daily starting dose; titrate by 15 mg increments up to max 30-45 mg PO once daily.",
            administration = "Take orally once daily with or without food at any time of day.",
            timing = "Consistent time daily.",
            specialInstructions = "Check baseline LFTs. Monitor for rapid weight gain, pedal edema, dyspnea. Associated with increased fracture risk in postmenopausal women.",
            pkPd = "Bioavailability >80%. Protein binding >99%. Metabolized by CYP2C8 and CYP3A4 to active metabolites. Half-life: parent 3-7h, metabolites 16-24h.",
            renalAdj = "No dosage adjustment necessary in renal impairment or hemodialysis.",
            hepaticAdj = "Do not initiate if ALT > 2.5x ULN. Discontinue if persistent ALT elevation or jaundice.",
            pregnancy = "Category C (Insulin preferred in pregnancy).",
            lactation = "Excreted in animal milk; not recommended during breastfeeding.",
            sideEffects = "Peripheral edema, weight gain, heart failure exacerbation, macular edema, distal limb bone fractures in women, small potential association with bladder cancer.",
            priceNpr = "NPR 60.00 - 130.00 per strip of 10 (15mg / 30mg)",
            priceInr = "INR 40.00 - 85.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Pioz", "USV / Nepal Dist.", "Tab", "15 mg / 30 mg"),
                BrandInfo("Pioglit", "Sun Pharma Nepal", "Tab", "15 mg / 30 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pioz", "USV", "Tab", "15 / 30 mg"),
                BrandInfo("Actos", "Takeda / Torrent", "Tab", "15 / 30 mg")
            ),
            adultDose = "15-30 mg PO once daily (max 45 mg/day).",
            contraindications = "NYHA Class III or IV heart failure, active bladder cancer or history of bladder cancer, uninvestigated macroscopic hematuria.",
            modeOfAction = "Potent, selective agonist for peroxisome proliferator-activated receptor-gamma (PPAR-gamma), enhancing insulin sensitivity in skeletal muscle, adipose tissue, and liver.",
            therapeuticClassTag = "OHA / Insulin Sensitizers"
        ),

        Drug(
            id = "d_endo_voglibose",
            genericName = "Voglibose",
            system = "Endocrine & Metabolic System",
            drugClass = "Alpha-Glucosidase Inhibitor (AGI)",
            blackBoxWarning = null,
            indications = "Type 2 Diabetes Mellitus with prominent postprandial hyperglycemia, prevention of progression from impaired glucose tolerance (IGT) to diabetes.",
            doses = "0.2 mg PO three times daily immediately before each main meal. May titrate to 0.3 mg PO TID if needed.",
            administration = "Take immediately before (with the very first bite of) each main meal.",
            timing = "Immediately prior to meals.",
            specialInstructions = "If hypoglycemia occurs in combination with sulfonylureas or insulin, treat with pure oral glucose (dextrose), NOT household sucrose (cane sugar is not absorbed due to enzyme blockade).",
            pkPd = "Negligible systemic absorption; acts locally in the brush border of the small intestine. Excreted almost entirely in feces.",
            renalAdj = "Use with caution in severe renal impairment (CrCl <30 mL/min).",
            hepaticAdj = "Contraindicated in severe hepatic cirrhosis.",
            pregnancy = "Category B (Safety in pregnancy not established; use insulin).",
            lactation = "Safety during lactation not established.",
            sideEffects = "Flatulence, abdominal distension, diarrhea, borborygmi, abdominal cramping (caused by bacterial fermentation of unabsorbed carbohydrates in colon).",
            priceNpr = "NPR 50.00 - 110.00 per strip of 10 (0.2mg / 0.3mg)",
            priceInr = "INR 35.00 - 75.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Volibo", "Sun Pharma Nepal", "Tab", "0.2 mg / 0.3 mg"),
                BrandInfo("Vogli", "Micro Labs Nepal", "Tab", "0.2 mg / 0.3 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Volibo", "Sun Pharma", "Tab", "0.2 / 0.3 mg"),
                BrandInfo("Voglimac", "Macleods", "Tab", "0.2 / 0.3 mg")
            ),
            adultDose = "0.2-0.3 mg PO TID with first bite of meals.",
            contraindications = "Inflammatory bowel disease, intestinal obstruction, colonic ulceration, severe gastrointestinal motility disorders, diabetic ketoacidosis.",
            modeOfAction = "Competitively inhibits intestinal brush-border alpha-glucosidases (disaccharidases: maltase, sucrase), delaying breakdown of carbohydrates and blunting postprandial glucose peaks.",
            therapeuticClassTag = "OHA / Carbohydrate Inhibitors"
        ),

        Drug(
            id = "d_endo_semaglutide",
            genericName = "Semaglutide (Oral / Subcutaneous)",
            system = "Endocrine & Metabolic System",
            drugClass = "Glucagon-Like Peptide-1 (GLP-1) Receptor Agonist",
            blackBoxWarning = "THYROID C-CELL TUMORS: Causes dose-dependent thyroid C-cell tumors in rodents. Contraindicated in personal or family history of Medullary Thyroid Carcinoma (MTC) or Multiple Endocrine Neoplasia syndrome type 2 (MEN 2).",
            indications = "Type 2 Diabetes Mellitus (glycemic control and major adverse cardiovascular event MACE reduction), chronic weight management in obesity.",
            doses = "Oral (Rybelsus): Start 3 mg PO once daily x 30 days, then 7 mg OD; may increase to 14 mg OD. Subcutaneous (Ozempic): Start 0.25 mg SC once weekly x 4 weeks, then 0.5 mg weekly; may titrate to 1 mg or 2 mg weekly.",
            administration = "Oral: Take in morning upon waking with no more than 120 mL (half glass) of plain water at least 30 minutes before any food, beverage, or other oral medications. SC: Inject in abdomen, thigh, or upper arm once weekly.",
            timing = "Oral: Morning on empty stomach. SC: Once weekly any time of day.",
            specialInstructions = "Oral tablet contains SNAC (salcaprozate sodium) carrier to facilitate transcellular gastric absorption; swallowing with >120 mL water or eating within 30 min severely decreases absorption.",
            pkPd = "Oral bioavailability ~1% (facilitated by SNAC). SC bioavailability ~89%. 99% bound to albumin via fatty diacid chain. Half-life ~1 week.",
            renalAdj = "No dosage adjustment required in renal impairment including ESRD.",
            hepaticAdj = "No dosage adjustment needed.",
            pregnancy = "Discontinue at least 2 months prior to planned pregnancy due to long washout period.",
            lactation = "Safety in breastfeeding not established; avoid.",
            sideEffects = "Nausea, vomiting, diarrhea, abdominal pain, constipation, dyspepsia, risk of acute pancreatitis, gallbladder disease, diabetic retinopathy complications.",
            priceNpr = "NPR 3,200.00 - 4,500.00 per strip of 10 (Rybelsus 7mg/14mg) / NPR 12,000 per pen",
            priceInr = "INR 2,200.00 - 3,500.00 per strip of 10 / INR 8,000 per pen",
            brandsNepal = listOf(
                BrandInfo("Rybelsus", "Novo Nordisk / Medisales Nepal", "Tab", "3 mg / 7 mg / 14 mg"),
                BrandInfo("Ozempic", "Novo Nordisk / Nepal Dist.", "SC Pen", "2 mg / 4 mg Prefilled Pen")
            ),
            brandsIndia = listOf(
                BrandInfo("Rybelsus", "Novo Nordisk India", "Tab", "3 / 7 / 14 mg"),
                BrandInfo("Ozempic", "Novo Nordisk", "Pen", "0.25 / 0.5 / 1 mg")
            ),
            adultDose = "Oral: 3-14 mg PO OD. SC: 0.25-2 mg SC once weekly.",
            contraindications = "Personal or family history of medullary thyroid carcinoma, MEN 2 syndrome, history of severe hypersensitivity.",
            modeOfAction = "Selectively activates the GLP-1 receptor, augmenting glucose-dependent insulin secretion, suppressing inappropriately high glucagon, slowing gastric emptying, and reducing appetite.",
            therapeuticClassTag = "GLP-1 Agonists / Weight Loss"
        ),

        Drug(
            id = "d_endo_alendronate",
            genericName = "Alendronate Sodium",
            system = "Endocrine & Metabolic System",
            drugClass = "Nitrogen-Containing Bisphosphonate (Bone Resorption Inhibitor)",
            blackBoxWarning = null,
            indications = "Treatment and prevention of postmenopausal osteoporosis, glucocorticoid-induced osteoporosis, male osteoporosis, Paget's disease of bone.",
            doses = "Treatment: 70 mg PO once weekly (or 10 mg PO once daily). Prevention: 35 mg PO once weekly. Paget's Disease: 40 mg PO once daily for 6 months.",
            administration = "Take first thing in the morning upon waking with a full glass (200-240 mL) of plain water. Must remain strictly upright (sitting or standing) for at least 30 minutes without eating or drinking anything else.",
            timing = "Once weekly on the same day each week in the morning on empty stomach.",
            specialInstructions = "Failure to follow administration instructions causes severe chemical esophagitis and esophageal perforation. Dental exam recommended before therapy (osteonecrosis of jaw risk).",
            pkPd = "Very low oral bioavailability (~0.6-0.7%), further abolished by food, coffee, or calcium. Selectively binds to hydroxyapatite bone mineral. Bone terminal half-life >10 years.",
            renalAdj = "CrCl >= 35 mL/min: No adjustment needed. CrCl <35 mL/min: Not recommended.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Excretion in breast milk unknown; use caution.",
            sideEffects = "Severe esophagitis, esophageal ulcers, dysphagia, musculoskeletal pain, hypocalcemia, osteonecrosis of the jaw (ONJ), atypical subtrochanteric femoral fractures.",
            priceNpr = "NPR 120.00 - 240.00 per pack of 4 tablets (70mg weekly)",
            priceInr = "INR 80.00 - 160.00 per pack of 4",
            brandsNepal = listOf(
                BrandInfo("Osteofos", "Cipla Nepal", "Tab", "35 mg / 70 mg"),
                BrandInfo("Fosamax", "Organon / Medisales Nepal", "Tab", "70 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Osteofos", "Cipla", "Tab", "70 mg"),
                BrandInfo("Fosamax", "Organon", "Tab", "70 mg")
            ),
            adultDose = "70 mg PO once weekly on empty stomach.",
            contraindications = "Abnormalities of esophagus that delay emptying (stricture, achalasia), inability to stand or sit upright for at least 30 minutes, hypocalcemia, severe renal impairment (CrCl <35 mL/min).",
            modeOfAction = "Inhibits farnesyl pyrophosphate (FPP) synthase enzyme in osteoclasts, preventing prenylation of small GTPase proteins, leading to osteoclast apoptosis and reduced bone resorption.",
            therapeuticClassTag = "Bone Metabolism & Osteoporosis"
        ),

        Drug(
            id = "d_endo_cabergoline",
            genericName = "Cabergoline",
            system = "Endocrine & Metabolic System",
            drugClass = "Ergot-Derived Long-Acting Dopamine D2 Receptor Agonist",
            blackBoxWarning = null,
            indications = "Hyperprolactinemia disorders (prolactinomas, micro/macroadenomas), idiopathic hyperprolactinemia, suppression of physiological postpartum lactation.",
            doses = "Hyperprolactinemia: Start 0.25 mg PO twice weekly; titrate by 0.25 mg twice weekly every 4 weeks based on serum prolactin up to 1 mg twice weekly (usual max 2-3 mg/week). Lactation Suppression: 1 mg PO single dose within 24 hr postpartum.",
            administration = "Take orally with food to reduce nausea and dizziness.",
            timing = "Twice weekly (e.g., Monday and Thursday) with meals.",
            specialInstructions = "Check baseline echocardiogram for heart valve disease before high-dose therapy; prolonged high doses associated with cardiac valvular fibrosis (serotonin 5-HT2B agonism).",
            pkPd = "Rapid absorption. Extensively metabolized by liver. Elimination half-life 63-69 hours, allowing twice-weekly dosing.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Severe hepatic impairment: Use with caution and lower doses.",
            pregnancy = "Category B (Discontinue when pregnancy detected unless macroadenoma expansion risk).",
            lactation = "Inhibits prolactin and suppresses lactation; contraindicated if breastfeeding intended.",
            sideEffects = "Nausea, headache, dizziness, orthostatic hypotension, fatigue, constipation, cardiac valvular fibrosis, impulse control disorders.",
            priceNpr = "NPR 180.00 - 380.00 per pack of 4 tablets (0.5mg)",
            priceInr = "INR 120.00 - 250.00 per pack of 4",
            brandsNepal = listOf(
                BrandInfo("Cabgolin", "Sun Pharma Nepal", "Tab", "0.25 mg / 0.5 mg"),
                BrandInfo("Dostinex", "Pfizer Nepal", "Tab", "0.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cabgolin", "Sun Pharma", "Tab", "0.25 / 0.5 mg"),
                BrandInfo("Caberlin", "Sun Pharma", "Tab", "0.5 mg")
            ),
            adultDose = "0.25-0.5 mg PO twice weekly with meals.",
            contraindications = "Uncontrolled hypertension, pre-existing cardiac valvulopathy, history of pulmonary/pericardial/retroperitoneal fibrotic disorders, ergot alkaloid hypersensitivity.",
            modeOfAction = "Potent, selective agonist at dopamine D2 receptors on anterior pituitary lactotroph cells, directly suppressing prolactin secretion and shrinking prolactinoma tumor volume.",
            therapeuticClassTag = "Pituitary & Prolactin Disorders"
        )
    )
}
