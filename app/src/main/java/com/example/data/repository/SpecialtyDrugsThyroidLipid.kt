package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object SpecialtyDrugsThyroidLipid {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // 3. THYROID DISORDERS (HYPO / HYPERTHYROIDISM)
        // ==========================================

        // --- OLDER / CLASSICAL THYROID ---
        Drug(
            id = "d_thy_desiccated",
            genericName = "Desiccated Thyroid Extract (Armour Thyroid)",
            system = "Endocrine & Metabolic System",
            drugClass = "Thyroid Hormone Replacement (Natural Porcine Thyroid Extract)",
            era = "Older / Classical",
            therapeuticClassTag = "Thyroid disorders",
            researchNotes = "Classical animal-derived thyroid extract utilized since the late 19th century. Contains natural porcine T4 and T3 in a fixed ~4.2:1 ratio; largely superseded by synthetic crystalline levothyroxine due to lot-to-lot bioequivalence variations and supraphysiologic T3 peaks.",
            blackBoxWarning = "NOT FOR WEIGHT REDUCTION: Thyroid hormones are ineffective and life-threatening when used for obesity or weight loss, especially when combined with sympathomimetics.",
            indications = "Hypothyroidism (alternative for patients dissatisfied with synthetic T4 monotherapy), euthyroid goiter, thyroid cancer suppression.",
            doses = "Initial: 15 mg to 30 mg (1/4 to 1/2 grain) PO once daily; titrate every 2-3 weeks by 15 mg. Typical maintenance: 60 mg to 120 mg (1 to 2 grains) PO once daily.",
            adultDose = "30 - 120 mg (1/2 to 2 grains) PO once daily morning fasting",
            childDose = "Weight-based: 15-30 mg daily; titrate according to clinical response and serum TSH.",
            administration = "Take on an empty stomach in the morning with a full glass of water, at least 30-60 minutes before breakfast.",
            timing = "Morning, at least 30-60 minutes before food.",
            specialInstructions = "1 grain (60 mg) contains approximately 38 mcg of T4 and 9 mcg of T3. Higher peak T3 levels can cause transient palpitations.",
            pkPd = "Contains both thyroxine (T4) and triiodothyronine (T3). T3 is rapidly absorbed and exerts fast metabolic action, while T4 provides a longer metabolic reservoir.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No specific adjustment needed.",
            pregnancy = "Category A (Synthetic levothyroxine preferred due to predictable serum T4 levels).",
            lactation = "Compatible with breastfeeding; present in minimal amounts.",
            sideEffects = "Palpitations, tachycardia, tremors, heat intolerance, nervousness, insomnia, weight loss (symptoms of hyperthyroidism from supraphysiologic T3 peaks).",
            priceNpr = "NPR 18.00 - 30.00 per tab (60mg)",
            priceInr = "INR 12.00 - 22.00 per tab (60mg)",
            brandsNepal = listOf(
                BrandInfo("Armour Thyroid", "Forest / Allergan", "Tablet", "30 mg / 60 mg / 120 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Armour Thyroid", "Allergan India", "Tablet", "30 mg / 60 mg / 120 mg"),
                BrandInfo("Nature-Throid", "RLC Labs / Import", "Tablet", "65 mg")
            ),
            contraindications = "Untreated subclinical or overt thyrotoxicosis, uncorrected acute adrenal cortical insufficiency, acute myocardial infarction.",
            modeOfAction = "Exogenous thyroid hormone replacement activating nuclear thyroid receptors (TR-alpha and TR-beta) to regulate basal metabolic rate and gene expression.",
            interactions = "Calcium, Iron, Antacids (chelate and decrease absorption; separate by 4 hours), Warfarin (potentiates anticoagulant effect).",
            packSize = "Bottle of 100 tablets",
            counselingNepali = "यो सुँगुरको ग्रन्थीबाट बनेको पुरानो थाइरोइडको औषधि हो। बिहान खाली पेटमा चिया/खाजा खानुभन्दा १ घण्टा अगाडि खानुपर्छ। धड्कन बढेमा तुरुन्त जचाउनुहोस्।",
            counselingEnglish = "Natural desiccated extract. Take upon waking 30-60 minutes before breakfast. Report rapid heartbeats or shaking hands."
        ),

        Drug(
            id = "d_thy_propylthiouracil",
            genericName = "Propylthiouracil (PTU)",
            system = "Endocrine & Metabolic System",
            drugClass = "Antithyroid Thionamide & Peripheral 5'-Deiodinase Inhibitor",
            era = "Older / Classical",
            therapeuticClassTag = "Thyroid disorders",
            researchNotes = "Classical antithyroid drug synthesized in the 1940s. Retains a critical, indispensable niche: drug of choice in the FIRST TRIMESTER of pregnancy (avoids methimazole-associated embryopathy) and in acute THYROID STORM (due to unique dual action inhibiting peripheral T4-to-T3 conversion).",
            blackBoxWarning = "SEVERE LIVER INJURY & ACUTE HEPATIC FAILURE: Severe cases of liver failure, liver transplantation, or death reported. Reserved for patients unable to tolerate methimazole, first trimester of pregnancy, or thyroid storm.",
            indications = "Hyperthyroidism / Graves' disease during the first trimester of pregnancy; thyroid storm / thyrotoxic crisis; patients intolerant of methimazole.",
            doses = "Hyperthyroidism: Initial 300 mg to 400 mg/day PO divided q8h (100-150 mg TID); maintenance 100 mg to 150 mg/day. Thyroid Storm: 500 mg - 1000 mg loading dose via NG tube, then 200 mg q4h.",
            adultDose = "100 - 150 mg PO TID (Thyroid storm loading: 500-1000 mg stat, then 200 mg q4h)",
            childDose = "Pediatric (6-10 years): 50-150 mg/day divided q8h. (>10 years): 150-300 mg/day divided q8h.",
            administration = "Take orally with or without meals at regularly spaced intervals (q8h) around the clock.",
            timing = "Every 8 hours around the clock.",
            specialInstructions = "Switch to methimazole at the start of the second trimester of pregnancy to avoid maternal hepatotoxicity. Warn patients to report fever, sore throat (agranulocytosis), or jaundice immediately.",
            pkPd = "Inhibits thyroid peroxidase (TPO) to block iodination of tyrosine residues and coupling of iodotyrosines; also blocks peripheral 5'-deiodinase (converting T4 to active T3). Short half-life: 1-2 hours.",
            renalAdj = "CrCl 10-50 mL/min: Administer 75% of normal dose. CrCl <10 mL/min: Administer 50% of normal dose.",
            hepaticAdj = "CONTRAINDICATED in active liver disease or drug-induced hepatitis.",
            pregnancy = "Category D (Drug of choice in 1st trimester; switch to methimazole in 2nd/3rd trimester).",
            lactation = "Compatible with breastfeeding; binds heavily to plasma protein with minimal milk transmission (AAP preferred).",
            sideEffects = "Fulminant hepatic necrosis (Black Box), agranulocytosis (0.2-0.5%), ANCA-positive vasculitis, drug fever, arthralgias, pruritic maculopapular rash.",
            priceNpr = "NPR 14.00 - 24.00 per tab (50mg)",
            priceInr = "INR 9.00 - 16.00 per tab (50mg)",
            brandsNepal = listOf(
                BrandInfo("PTU", "Macsen Labs / Regional", "Tablet", "50 mg"),
                BrandInfo("Propyl-Thio", "Sun Pharma Nepal", "Tablet", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("PTU", "Macsen Laboratories", "Tablet", "50 mg"),
                BrandInfo("Propycil", "Adcock Ingram", "Tablet", "50 mg")
            ),
            contraindications = "Hypersensitivity to PTU, history of severe hepatotoxicity or agranulocytosis with prior thionamide therapy.",
            modeOfAction = "Inhibits thyroid peroxidase (TPO) preventing organification of iodide, and uniquely inhibits peripheral conversion of thyroxine (T4) to active triiodothyronine (T3).",
            interactions = "Warfarin (alterations in thyroid state alter clotting factor turnover), Digoxin (clearance increases as hyperthyroidism resolves).",
            packSize = "Strip of 10 or bottle of 100 tablets",
            counselingNepali = "यो थाइरोइड धेरै बढेको (हाइपरथाइरोइडिजम) र गर्भावस्थाको पहिलो ३ महिनामा चलाइने विशेष औषधि हो। ज्वरो आएमा वा घाँटी दुखेमा रगतको सेतो रक्तकोष (Agranulocytosis) जचाउन तुरुन्त अस्पताल जानुहोस्।",
            counselingEnglish = "Primary agent for hyperthyroidism in 1st trimester of pregnancy and thyroid storm. Report sore throat, fever, or yellowing of eyes immediately."
        ),

        // --- NEWER / MODERN STANDARDS THYROID ---
        Drug(
            id = "d_thy_levothyroxine",
            genericName = "Levothyroxine Sodium",
            system = "Endocrine & Metabolic System",
            drugClass = "Synthetic Thyroid Hormone (Pure L-Thyroxine / T4)",
            era = "Newer / Modern",
            therapeuticClassTag = "Thyroid disorders",
            researchNotes = "Global gold standard for hypothyroidism. Crystalline synthetic pure L-isomer of thyroxine providing uniform potency, 7-day half-life, and physiological peripheral deiodination into active T3 without hormone spikes.",
            blackBoxWarning = "NOT FOR OBESITY OR WEIGHT LOSS: Ineffective and potentially cardiotoxic when prescribed for weight reduction in euthyroid individuals.",
            indications = "Primary, secondary, and tertiary hypothyroidism; pituitary TSH suppression in differentiated thyroid cancer; myxedema coma (IV).",
            doses = "Full replacement dose in young/healthy: ~1.6 mcg/kg/day PO (e.g., 75-125 mcg/day). In elderly or CAD: Start low at 12.5 - 25 mcg/day and titrate slowly every 4-6 weeks based on serum TSH.",
            adultDose = "1.6 mcg/kg/day PO morning fasting (Typical: 50 - 150 mcg once daily)",
            childDose = "Neonates: 10-15 mcg/kg/day. Children: 4-6 mcg/kg/day. Adolescents: 2-3 mcg/kg/day.",
            administration = "Take on an empty stomach with a full glass of plain water at least 30 to 60 minutes before breakfast (or at bedtime at least 3-4 hours after the last meal).",
            timing = "Early morning fasting, 30-60 min before breakfast.",
            specialInstructions = "STRICT BRAND CONSISTENCY: Maintain the exact same brand formulation to prevent TSH fluctuations. Separate by at least 4 hours from calcium, iron, antacids, or multivitamins.",
            pkPd = "Synthetic L-T4 identical to endogenous hormone. Deiodinated in peripheral tissues (liver and kidney) to active T3. Oral bioavailability 70-80%. High protein binding (99.97% to TBG/transthyretin). Half-life: 6-7 days.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No dosage change needed; monitor TSH.",
            pregnancy = "Category A (Safe and mandatory; thyroid hormone requirements typically increase by 25-50% during pregnancy; check TSH every 4 weeks).",
            lactation = "Compatible with breastfeeding; essential for normal infant neurodevelopment.",
            sideEffects = "Arrhythmias, angina, palpitations, osteoporosis / accelerated bone loss (with overtreatment/TSH suppression), tremors, insomnia, heat intolerance.",
            priceNpr = "NPR 3.00 - 6.00 per tab (100mcg)",
            priceInr = "INR 2.00 - 4.50 per tab (100mcg)",
            brandsNepal = listOf(
                BrandInfo("Thyronorm", "Abbott Nepal", "Tablet", "25 / 50 / 75 / 88 / 100 / 125 mcg"),
                BrandInfo("Eltroxin", "GlaxoSmithKline Nepal", "Tablet", "25 / 50 / 75 / 100 mcg"),
                BrandInfo("Thyrox", "Macleods Nepal", "Tablet", "25 / 50 / 75 / 100 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Thyronorm", "Abbott Healthcare", "Tablet", "12.5 / 25 / 50 / 62.5 / 75 / 88 / 100 / 112 / 125 / 137 / 150 mcg"),
                BrandInfo("Eltroxin", "GSK India", "Tablet", "25 / 50 / 75 / 100 mcg"),
                BrandInfo("Thyrox", "Macleods Pharmaceuticals", "Tablet", "25 / 50 / 75 / 100 mcg"),
                BrandInfo("Synthroid", "Abbott India", "Tablet", "50 / 100 mcg")
            ),
            pediatricDosePerKg = 5.0,
            pediatricInterval = "mcg/kg/day single morning dose",
            contraindications = "Untreated subclinical or overt thyrotoxicosis, uncorrected acute adrenal cortical insufficiency, acute myocardial infarction.",
            modeOfAction = "Synthetic crystalline T4 entering cell nuclei to bind thyroid hormone receptors, stimulating RNA and protein synthesis involved in thermogenesis, metabolism, and cardiac output.",
            interactions = "Calcium carbonate, Ferrous sulfate, PPIs, Bile acid sequestrants (impair absorption; separate by 4 hours), Carbamazepine, Rifampin (induce clearance).",
            packSize = "Bottle of 100 or 120 tablets with desiccant",
            counselingNepali = "यो थाइरोइडको प्रमुख र अनिवार्य औषधि हो। बिहान उठ्ने बित्तिकै खाली पेटमा पानीसँग खानुहोस् र कम्तीमा आधा घण्टासम्म चिया/खाजा केही नखानुहोस्। क्याल्सियम र आइरनको चक्कीसँग ४ घण्टाको फरक राख्नुहोस्।",
            counselingEnglish = "Take first thing in morning with plain water 30-60 min before breakfast. Strict brand consistency recommended. Maintain 4-hour gap from iron or calcium."
        ),

        Drug(
            id = "d_thy_methimazole",
            genericName = "Methimazole (Thiamazole)",
            system = "Endocrine & Metabolic System",
            drugClass = "Antithyroid Thionamide (First-Line Graves' Disease Therapy)",
            era = "Newer / Modern",
            therapeuticClassTag = "Thyroid disorders",
            researchNotes = "Modern first-line antithyroid drug of choice worldwide for hyperthyroidism and Graves' disease. Far safer hepatic profile than propylthiouracil with convenient once-daily dosing and rapid euthyroid restoration.",
            blackBoxWarning = "EMBRYOPATHY WARNING: Avoid in the first trimester of pregnancy due to risk of congenital malformations (aplasia cutis, choanal atresia). Use PTU in first trimester, then switch to methimazole in 2nd and 3rd trimesters.",
            indications = "Hyperthyroidism, Graves' disease, toxic multinodular goiter, toxic adenoma, preparation for radioactive iodine or thyroidectomy.",
            doses = "Initial: Mild: 15 mg PO once daily; Moderate: 30 mg PO once daily; Severe: 60 mg/day in divided doses. Maintenance: 5 mg to 15 mg PO once daily.",
            adultDose = "15 - 30 mg PO once daily (Maintenance: 5-15 mg OD)",
            childDose = "Initial 0.4 mg/kg/day divided in 1-2 doses; maintenance ~0.2 mg/kg/day.",
            administration = "Take orally once daily with or without food. Take consistently at the same time each day.",
            timing = "Once daily morning.",
            specialInstructions = "Check baseline CBC and liver function. Warn patient: if fever, chills, sore throat, or mouth sores develop, STOP MEDICATION IMMEDIATELY and check WBC count (agranulocytosis).",
            pkPd = "Inhibits thyroid peroxidase, preventing the synthesis of thyroid hormones T4 and T3. Does not inhibit peripheral T4-to-T3 deiodination. Long intrathyroidal half-life (~24 hours), enabling once-daily dosing.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "Use lower doses; clearance is prolonged in hepatic disease.",
            pregnancy = "Category D (Contraindicated in 1st trimester; preferred in 2nd and 3rd trimesters).",
            lactation = "Compatible with breastfeeding up to 20 mg/day (AAP approved; administer after nursing).",
            sideEffects = "Agranulocytosis (0.2-0.5%), cholestatic jaundice, maculopapular rash, arthralgias, drug-induced lupus, metallic taste.",
            priceNpr = "NPR 8.00 - 15.00 per tab (10mg)",
            priceInr = "INR 5.00 - 11.00 per tab (10mg)",
            brandsNepal = listOf(
                BrandInfo("Thyrozole", "Merck Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Methimez", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Thyrozole", "Merck India", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Methimez", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Neo-Mercazole (Carbimazole prodrug)", "Abbott India", "Tablet", "5 mg / 10 mg / 20 mg")
            ),
            pediatricDosePerKg = 0.4,
            pediatricInterval = "mg/kg/day divided q12-24h",
            contraindications = "History of severe hypersensitivity, prior agranulocytosis or severe liver injury with thionamides, first trimester of pregnancy.",
            modeOfAction = "Inhibits the enzyme thyroid peroxidase (TPO), blocking iodination of tyrosine residues and oxidative coupling of MIT and DIT into T4 and T3.",
            interactions = "Warfarin (adjust anticoagulation as hyperthyroid state normalizes), Beta-blockers (clearance decreases as patient becomes euthyroid).",
            packSize = "Strip of 10 or 30 tablets",
            counselingNepali = "यो थाइरोइडको काम धेरै बढेको (हाइपरथाइरोइडिजम) घटाउने मुख्य औषधि हो। दिनको एक पटक खानुहोस्। घाँटी दुखेमा, ज्वरो आएमा वा मुखमा घाउ भएमा तुरुन्त डाक्टरलाई खबर गर्नुहोस्।",
            counselingEnglish = "Primary therapy for overactive thyroid. Take once daily. Stop drug and get an immediate blood count if you develop fever or sore throat."
        ),

        // --- UNDER RESEARCH / PIPELINE THYROID ---
        Drug(
            id = "d_thy_teprotumumab",
            genericName = "Teprotumumab",
            system = "Endocrine & Metabolic System",
            drugClass = "Monoclonal Antibody Targeting Insulin-Like Growth Factor-1 Receptor (IGF-1R)",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Thyroid disorders",
            researchNotes = "BREAKTHROUGH BIOLOGIC: First FDA-approved targeted biologic therapy (Tepezza) for active Thyroid Eye Disease (Graves' Orbitopathy). Binds IGF-1R, disrupting the pathognomonic IGF-1R/TSHR autoimmune complex on orbital fibroblasts, producing unprecedented clinical reversal of proptosis (eye bulging) and diplopia without orbital decompression surgery!",
            indications = "Active moderate-to-severe Thyroid Eye Disease (Graves' ophthalmopathy / orbitopathy) and chronic inactive thyroid eye disease.",
            doses = "IV Infusion every 3 weeks for a total of 8 infusions. Initial dose: 10 mg/kg IV over 90 minutes. Subsequent doses (2-8): 20 mg/kg IV over 90 minutes every 3 weeks.",
            adultDose = "10 mg/kg IV initial dose, then 20 mg/kg IV every 3 weeks for 8 doses",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Intravenous infusion in normal saline administered over 90 minutes by experienced infusion staff.",
            timing = "Every 3 weeks for 8 total cycles (24-week treatment course).",
            specialInstructions = "Perform baseline audiometry (risk of sensorineural hearing loss). Monitor blood glucose in patients with pre-existing diabetes. Verify non-pregnant status.",
            pkPd = "Humanized IgG1 monoclonal antibody targeting the extracellular alpha-subunit of IGF-1R, causing receptor internalization and degradation, blocking downstream Akt and hyaluronan synthesis in orbital tissues. Half-life ~20 days.",
            renalAdj = "No dose adjustment required.",
            hepaticAdj = "No dosage adjustments specified.",
            pregnancy = "Contraindicated; causes fetal harm and skeletal malformations in animal studies.",
            lactation = "Discontinue nursing during treatment.",
            sideEffects = "Muscle spasms (25%), hearing impairment / tinnitus / sensorineural deafness (10-15%), alopecia, diarrhea, fatigue, hyperglycemia (especially in diabetics), dry skin.",
            priceNpr = "Under Global Specialty Access (~$15,000 per vial)",
            priceInr = "Under Global Specialty Access (Specialty Import)",
            brandsNepal = listOf(
                BrandInfo("Tepezza (Specialty)", "Horizon / Amgen Global", "IV Vial", "500 mg lyophilized powder")
            ),
            brandsIndia = listOf(
                BrandInfo("Tepezza", "Amgen India / Named Patient Import", "IV Vial", "500 mg")
            ),
            contraindications = "Pregnancy, severe unmonitored pre-existing sensorineural hearing loss.",
            modeOfAction = "Inhibits IGF-1R signaling on orbital fibroblasts, shutting down antigen-driven cytokine release, glycosaminoglycan/hyaluronan secretion, and retro-orbital adipogenesis.",
            interactions = "No CYP450 interactions; monitor concurrent anti-hyperglycemic agents for blood glucose elevation.",
            packSize = "Vial of 500 mg lyophilized cake with sterile reconstitution diluent",
            counselingNepali = "यो थाइरोइड रोगका कारण आँखा बाहिर निस्कने (Graves' Orbitopathy) समस्याको लागि प्रमाणित भएको आधुनिक जैविक सुई (Biologic) हो। यसले आँखाको अप्रेशन नगरी समस्या निको पार्छ।",
            counselingEnglish = "Groundbreaking targeted biologic for Thyroid Eye Disease. Administered IV every 3 weeks for 8 cycles. Baseline hearing tests required."
        ),

        Drug(
            id = "d_thy_resmetirom",
            genericName = "Resmetirom (MGL-3196)",
            system = "Endocrine & Metabolic System",
            drugClass = "Selective Liver-Directed Thyroid Hormone Receptor-Beta (THR-beta) Agonist",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Thyroid disorders",
            researchNotes = "HISTORIC FDA APPROVAL (March 2024): First-ever medication approved for non-cirrhotic metabolic dysfunction-associated steatohepatitis (MASH / NASH) with moderate to advanced liver fibrosis. Selectively targets hepatic THR-beta receptors (responsible for hepatic fat metabolism and lipid clearance) while sparing systemic THR-alpha receptors (avoiding cardiac arrhythmias, bone mineral loss, or thyroid axis suppression)! Landmark MAESTRO-NASH Phase III trial published in NEJM.",
            indications = "Treatment of adults with non-cirrhotic metabolic dysfunction-associated steatohepatitis (MASH/NASH) with moderate to advanced liver fibrosis (consistent with stages F2 to F3 fibrosis); dyslipidemia with elevated atherogenic lipoproteins.",
            doses = "Weight-based oral dosing: Body weight <100 kg: 80 mg PO once daily. Body weight ≥100 kg: 100 mg PO once daily.",
            adultDose = "80 mg (<100kg) or 100 mg (≥100kg) PO once daily",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Take orally once daily with or without food.",
            timing = "Once daily at the same time each day.",
            specialInstructions = "Check baseline liver panel and lipid panel. Avoid concomitant use with moderate to strong CYP2C8 inhibitors (e.g., gemfibrozil). Reduce statin doses when co-administered.",
            pkPd = "Liver-directed partial agonist of THR-beta with >28-fold selectivity for THR-beta over THR-alpha. Promotes hepatic mitochondrial fatty acid beta-oxidation and lowers LDL-C, ApoB, triglycerides, and hepatic fat content. Half-life ~4.5h.",
            renalAdj = "No dose adjustment required in mild, moderate, or severe renal impairment.",
            hepaticAdj = "Mild impairment (Child-Pugh A): No adjustment. Moderate to severe impairment (Child-Pugh B or C): Avoid use (unpredictable exposure in decompensated cirrhosis).",
            pregnancy = "Avoid; insufficient human pregnancy data.",
            lactation = "Breastfeeding not recommended during treatment.",
            sideEffects = "Diarrhea (usually mild and early), nausea, pruritus, abdominal pain, dizziness, elevated transaminases (transient). Zero cardiac thyrotoxic symptoms.",
            priceNpr = "Under Global Launch / Pipeline",
            priceInr = "Under Global Launch / Pipeline",
            brandsNepal = listOf(
                BrandInfo("Rezdiffra (Resmetirom)", "Madrigal Pharmaceuticals Pipeline", "Tablet", "60 mg / 80 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Rezdiffra", "Madrigal / Specialty Import", "Tablet", "80 mg / 100 mg")
            ),
            contraindications = "Decompensated cirrhosis, co-administration with gemfibrozil.",
            modeOfAction = "Selectively binds and activates thyroid hormone receptor-beta (THR-beta) in hepatocytes, accelerating lipolysis, mitochondrial beta-oxidation, and clearance of toxic lipid intermediates without activating cardiac THR-alpha.",
            interactions = "Gemfibrozil (contraindicated; marked increase in resmetirom levels), Statins (increases statin exposure; limit rosuvastatin to 20mg and atorvastatin to 40mg).",
            packSize = "Bottle of 30 tablets (80 mg or 100 mg)",
            counselingNepali = "यो कलेजोमा बोसो जमेर बिग्रेको (NASH/फैटी लिभर) रोगका लागि २०२४ मा प्रमाणित भएको पहिलो विशेष औषधि हो। यसले मुटुलाई असर नगरी कलेजोको बोसो सफा गर्छ।",
            counselingEnglish = "Approved 2024 for NASH/MASH liver fibrosis. Selectively activates liver thyroid receptors without heart palpitations or bone loss."
        ),

        // ==========================================
        // 4. STATINS & ADVANCED LIPID-LOWERING
        // ==========================================

        // --- OLDER / CLASSICAL STATINS ---
        Drug(
            id = "d_statin_simvastatin",
            genericName = "Simvastatin",
            system = "Cardiovascular System (CVS)",
            drugClass = "HMG-CoA Reductase Inhibitor (Lipophilic Statin Prodrug)",
            era = "Older / Classical",
            therapeuticClassTag = "Statins",
            researchNotes = "Classical 1st-generation fungal-derived statin prodrug (1991). Landmark 4S study proved statin mortality reduction; however, extensive CYP3A4 metabolism creates substantial drug interaction and myopathy/rhabdomyolysis risks (FDA restriction on 80 mg dose).",
            blackBoxWarning = "RHABDOMYOLYSIS RISK: High doses (80 mg) or co-administration with strong CYP3A4 inhibitors carries serious risk of myopathy and rhabdomyolysis with acute kidney failure.",
            indications = "Primary hyperlipidemia, mixed dyslipidemia, secondary prevention of cardiovascular events in atherosclerotic vascular disease.",
            doses = "Initial: 20 mg to 40 mg PO once daily in the evening. Maximum dose: 40 mg daily (80 mg dose restricted due to myopathy risk).",
            adultDose = "20 - 40 mg PO once daily in the evening",
            childDose = "Adolescents (10-17 years): 10 mg PO once daily evening, max 40 mg.",
            administration = "Take orally in the evening with or without food (hepatic cholesterol synthesis peaks at night).",
            timing = "Evening with water.",
            specialInstructions = "AVOID GRAPEFRUIT JUICE (markedly increases simvastatin levels). Restrict dose to maximum 20 mg daily when combined with amlodipine or ranolazine.",
            pkPd = "Inactive lactone prodrug hydrolyzed in vivo to active beta-hydroxy acid. Extensively metabolized by CYP3A4 with high first-pass extraction (~85%). Half-life ~2-3 hours.",
            renalAdj = "Severe renal impairment (CrCl <30 mL/min): Start at 5 mg once daily with close clinical monitoring.",
            hepaticAdj = "CONTRAINDICATED in active liver disease or unexplained persistent transaminase elevations.",
            pregnancy = "Contraindicated (Traditional Category X; statins block essential cholesterol synthesis required for embryogenesis).",
            lactation = "Contraindicated in nursing mothers.",
            sideEffects = "Myalgias, myopathy, rhabdomyolysis (rare), elevated ALT/AST, headache, dyspepsia, mild elevation of fasting blood glucose.",
            priceNpr = "NPR 8.00 - 15.00 per tab (20mg)",
            priceInr = "INR 5.00 - 10.00 per tab (20mg)",
            brandsNepal = listOf(
                BrandInfo("Zocor", "Merck Sharp & Dohme", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Simvas", "Micro Labs Nepal", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Simcard", "Cipla Nepal", "Tablet", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Zocor", "MSD India", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Simvotin", "Sun Pharma", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Simcard", "Cipla Ltd.", "Tablet", "10 mg / 20 mg")
            ),
            contraindications = "Active liver disease, pregnancy, lactation, concomitant strong CYP3A4 inhibitors (Itraconazole, Ketoconazole, Clarithromycin, Erythromycin, HIV protease inhibitors).",
            modeOfAction = "Competitive inhibition of 3-hydroxy-3-methylglutaryl-coenzyme A (HMG-CoA) reductase, upregulating hepatic LDL receptors and accelerating LDL-C clearance from circulation.",
            interactions = "Amlodipine (max simvastatin 20mg), Diltiazem/Verapamil (max 10mg), Cyclosporine, Gemfibrozil, Grapefruit juice (>1 quart/day increases AUC by 7-fold).",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो कोलेस्ट्रोल घटाउने पुरानो औषधि हो। बेलुकाको खाना खाएपछि खानुपर्छ। अंगुरको रस नपिउनुहोस्। मांसपेशी असाध्यै दुखेमा वा पिसाब चिया जस्तो कालो भएमा तुरुन्त डाक्टरलाई देखाउनुहोस्।",
            counselingEnglish = "Take in the evening. Avoid grapefruit juice. Promptly report unexplained muscle soreness, tenderness, or dark brown urine."
        ),

        // --- NEWER / MODERN HIGH-POTENCY STATINS ---
        Drug(
            id = "d_statin_atorvastatin",
            genericName = "Atorvastatin Calcium",
            system = "Cardiovascular System (CVS)",
            drugClass = "High-Intensity Synthetic HMG-CoA Reductase Inhibitor",
            era = "Newer / Modern",
            therapeuticClassTag = "Statins",
            researchNotes = "Modern high-intensity synthetic statin. Landmark SPARCL, ASCOT, and CARDS trials cemented 40-80 mg atorvastatin as the global standard for ACS, post-PCI, and secondary stroke prevention; 24-hour half-life allows dosing at any time of day.",
            indications = "Prevention of cardiovascular events in coronary artery disease, stroke/TIA, peripheral vascular disease; primary hypercholesterolemia, familial hypercholesterolemia.",
            doses = "Moderate-intensity: 10 mg to 20 mg PO once daily. High-intensity: 40 mg to 80 mg PO once daily.",
            adultDose = "10 - 80 mg PO once daily (High-intensity: 40-80 mg daily)",
            childDose = "Pediatric HeFH (≥10 years): Initial 10 mg once daily, titrate up to 20 mg daily.",
            administration = "Take orally once daily at any time of day, with or without food.",
            timing = "Any time of day (morning or evening) consistently.",
            specialInstructions = "Does not require evening dosing due to long active metabolite half-life (14-30 hours). High-intensity 80 mg statin indicated in acute coronary syndromes regardless of baseline LDL.",
            pkPd = "Synthetic statin metabolized by CYP3A4 to active ortho- and parahydroxylated metabolites that account for ~70% of circulating inhibitory activity. Half-life ~14 hours, inhibitory half-life 20-30 hours.",
            renalAdj = "No dose adjustment required in renal impairment or hemodialysis.",
            hepaticAdj = "CONTRAINDICATED in active liver disease.",
            pregnancy = "Contraindicated (Category X / Pregnancy Risk: teratogenic).",
            lactation = "Contraindicated in nursing mothers.",
            sideEffects = "Myalgias (5-10%), mild asymptomatic transaminitis, nasopharyngitis, arthralgias, dyspepsia, modest dose-dependent increase in new-onset diabetes risk.",
            priceNpr = "NPR 12.00 - 32.00 per tab (20mg/40mg)",
            priceInr = "INR 8.00 - 24.00 per tab (20mg/40mg)",
            brandsNepal = listOf(
                BrandInfo("Atorlip", "Cipla Nepal", "Tablet", "10 mg / 20 mg / 40 mg / 80 mg"),
                BrandInfo("Atocor", "Dr. Reddy's Nepal", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Lipicure", "Intas Nepal", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Storvas", "Sun Pharma Nepal", "Tablet", "10 mg / 20 mg / 40 mg / 80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lipitor", "Pfizer India", "Tablet", "10 mg / 20 mg / 40 mg / 80 mg"),
                BrandInfo("Atorva", "Zydus Healthcare", "Tablet", "10 mg / 20 mg / 40 mg / 80 mg"),
                BrandInfo("Storvas", "Sun Pharma", "Tablet", "10 mg / 20 mg / 40 mg / 80 mg"),
                BrandInfo("Lipicure", "Intas Pharmaceuticals", "Tablet", "10 mg / 20 mg / 40 mg / 80 mg")
            ),
            contraindications = "Active liver disease, unexplained persistent elevation of serum transaminases, pregnancy, lactation.",
            modeOfAction = "Selectively and competitively inhibits HMG-CoA reductase, accelerating hepatic clearance of LDL particles and decreasing ApoB, VLDL, and triglycerides.",
            interactions = "Strong CYP3A4 inhibitors (Clarithromycin, Ketoconazole - do not exceed 20mg atorvastatin), Cyclosporine, Protease inhibitors, Grapefruit juice.",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो नराम्रो कोलेस्ट्रोल घटाउने र मुटुको अट्याक हुनबाट बचाउने प्रमुख औषधि हो। दिनको एक पटक जुनसुकै बेला खान मिल्छ। मांसपेशी अस्वाभाविक दुखेमा डाक्टरलाई खबर गर्नुहोस्।",
            counselingEnglish = "Take once daily with or without food at any consistent time. Standard high-intensity therapy post-stent/MI. Report severe muscle pain."
        ),

        Drug(
            id = "d_statin_rosuvastatin",
            genericName = "Rosuvastatin Calcium",
            system = "Cardiovascular System (CVS)",
            drugClass = "High-Intensity Hydrophilic HMG-CoA Reductase Inhibitor",
            era = "Newer / Modern",
            therapeuticClassTag = "Statins",
            researchNotes = "Modern hydrophilic statin with the highest mg-for-mg potency in class (JUPITER trial proved primary prevention mortality reduction). Minimal CYP3A4 metabolism (primarily CYP2C9) provides lower risk of drug-drug interactions compared to atorvastatin and simvastatin.",
            indications = "Hypercholesterolemia, mixed dyslipidemia, hypertriglyceridemia, primary prevention of cardiovascular disease in patients with high-sensitivity CRP >2 mg/L.",
            doses = "Moderate-intensity: 5 mg to 10 mg PO once daily. High-intensity: 20 mg to 40 mg PO once daily.",
            adultDose = "5 - 40 mg PO once daily (High-intensity: 20-40 mg daily)",
            childDose = "Pediatric HeFH (6-17 years): 5-20 mg PO once daily depending on age and response.",
            administration = "Take orally once daily at any time of day, with or without food.",
            timing = "Any time of day, consistently.",
            specialInstructions = "In Asian patients, start at 5 mg once daily due to genetic differences in SLCO1B1/ABCG2 transport resulting in 2-fold higher median plasma concentrations.",
            pkPd = "Hydrophilic methane sulfonamide statin with selective hepatic uptake via OATP1B1. Minimal hepatic metabolism (~10% via CYP2C9). 90% eliminated unchanged in feces. Half-life ~19 hours.",
            renalAdj = "Mild to moderate: No adjustment. Severe (CrCl <30 mL/min not on dialysis): Start at 5 mg once daily; max 10 mg daily.",
            hepaticAdj = "CONTRAINDICATED in active liver disease or unexplained persistent ALT/AST elevations.",
            pregnancy = "Contraindicated (Pregnancy Risk).",
            lactation = "Contraindicated in nursing mothers.",
            sideEffects = "Myalgias, headache, dizziness, nausea, transient proteinuria/hematuria (at 40mg dose), mild elevation in HbA1c/blood sugar.",
            priceNpr = "NPR 16.00 - 38.00 per tab (10mg/20mg)",
            priceInr = "INR 10.00 - 28.00 per tab (10mg/20mg)",
            brandsNepal = listOf(
                BrandInfo("Rozavel", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg / 20 mg / 40 mg"),
                BrandInfo("Rosuvas", "Ranbaxy / Sun Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Roseday", "USV Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Novastat", "Lupin Nepal", "Tablet", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Crestor", "AstraZeneca India", "Tablet", "5 mg / 10 mg / 20 mg / 40 mg"),
                BrandInfo("Rozavel", "Sun Pharma", "Tablet", "5 mg / 10 mg / 20 mg / 40 mg"),
                BrandInfo("Rosuvas", "Sun Pharma", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Roseday", "USV Ltd.", "Tablet", "5 mg / 10 mg / 20 mg / 40 mg")
            ),
            contraindications = "Active liver disease, severe renal impairment (CrCl <30 not on dialysis), pregnancy, nursing, concomitant cyclosporine.",
            modeOfAction = "Potent competitive inhibition of HMG-CoA reductase, increasing cell-surface LDL receptors on hepatocytes and markedly clearing atherogenic ApoB/LDL particles.",
            interactions = "Cyclosporine (increases rosuvastatin AUC 7-fold; avoid), Gemfibrozil (max 10mg rosuvastatin), Antacids (take antacid 2 hours after rosuvastatin).",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो सबैभन्दा शक्तिशाली र सुरक्षित कोलेस्ट्रोल घटाउने औषधिहरूमध्ये एक हो। यसले अन्य औषधिसँग असर कम गर्छ। दिनको एक पटक नियमित खानुहोस्।",
            counselingEnglish = "Highest potency statin with minimal CYP3A4 interactions. Take once daily at any time. In Asian individuals, lower starting doses (5-10 mg) are standard."
        ),

        Drug(
            id = "d_statin_bempedoic_acid",
            genericName = "Bempedoic Acid",
            system = "Cardiovascular System (CVS)",
            drugClass = "ATP-Citrate Lyase (ACL) Inhibitor",
            era = "Newer / Modern",
            therapeuticClassTag = "Statins",
            researchNotes = "Novel non-statin lipid-lowering oral agent (CLEAR Outcomes trial published in NEJM). Acts upstream of HMG-CoA reductase in the same cholesterol synthesis pathway. CRITICAL DISTINCTION: It is a prodrug activated exclusively by very long-chain acyl-CoA synthetase-1 (ACSVL1), an enzyme present in the LIVER but ABSENT IN SKELETAL MUSCLE—thus achieving potent LDL reduction WITHOUT statin-associated muscle pain or myopathy!",
            indications = "Primary hyperlipidemia, heterozygous familial hypercholesterolemia (HeFH), or patients with established atherosclerotic cardiovascular disease who are statin-intolerant or require additional LDL-C lowering.",
            doses = "180 mg orally once daily with or without food. Also available as fixed-dose combination with Ezetimibe (180 mg / 10 mg).",
            adultDose = "180 mg PO once daily",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Take orally once daily with or without food.",
            timing = "Once daily, any time.",
            specialInstructions = "Check baseline serum uric acid (can cause hyperuricemia and acute gout attacks). Monitor for tendon rupture risk (especially Achilles tendon).",
            pkPd = "Hydrolyzed in liver by ACSVL1 to active bempedoyl-CoA, which inhibits ATP-citrate lyase (ACL), halting cytosolic acetyl-CoA generation. High oral bioavailability. Half-life ~21 hours.",
            renalAdj = "Mild to moderate: No adjustment. Severe (eGFR <30): Limited data; monitor.",
            hepaticAdj = "Mild to moderate: No adjustment. Severe (Child-Pugh C): Not studied.",
            pregnancy = "Avoid; animal studies show decreased fetal body weight.",
            lactation = "Contraindicated.",
            sideEffects = "Hyperuricemia (10-15%), acute gout flares (1.5-3%), tendon rupture / tendinopathy (0.5%), elevated liver transaminases; ZERO excess muscle pain vs. placebo.",
            priceNpr = "NPR 35.00 - 65.00 per tab (180mg)",
            priceInr = "INR 22.00 - 42.00 per tab (180mg)",
            brandsNepal = listOf(
                BrandInfo("Nexletol", "Daiichi Sankyo / Regional", "Tablet", "180 mg"),
                BrandInfo("Bempe", "Sun Pharma Nepal", "Tablet", "180 mg"),
                BrandInfo("Brillo", "Zydus Nepal", "Tablet", "180 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Nexletol", "Daiichi Sankyo India", "Tablet", "180 mg"),
                BrandInfo("Brillo", "Zydus Lifesciences", "Tablet", "180 mg"),
                BrandInfo("Bempeda", "Sun Pharma", "Tablet", "180 mg"),
                BrandInfo("Bempidoc", "Glenmark Pharmaceuticals", "Tablet", "180 mg")
            ),
            contraindications = "Hypersensitivity to bempedoic acid, history of severe tendon rupture.",
            modeOfAction = "Inhibits ATP-citrate lyase (ACL), blocking cholesterol synthesis upstream of HMG-CoA reductase in hepatocytes without affecting skeletal muscle tissue.",
            interactions = "Simvastatin (do not exceed 20mg simvastatin), Pravastatin (do not exceed 40mg pravastatin).",
            packSize = "Strip of 10 or 14 tablets",
            counselingNepali = "यो कोलेस्ट्रोलको औषधि खाँदा जीउ/मांसपेशी दुख्ने समस्या भएका बिरामीहरूका लागि बनेको विशेष नयाँ औषधि हो। यसले मांसपेशी दुखाउँदैन। युरिक एसिड भने अलि बढाउन सक्छ।",
            counselingEnglish = "Targeted liver-specific cholesterol drug for statin-intolerant patients. Does not cause muscle aches. Monitor uric acid levels."
        ),

        // --- UNDER RESEARCH / PIPELINE STATINS & LIPID-LOWERING ---
        Drug(
            id = "d_statin_inclisiran",
            genericName = "Inclisiran",
            system = "Cardiovascular System (CVS)",
            drugClass = "Small Interfering RNA (siRNA) Targeting Hepatic PCSK9 Synthesis",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Statins",
            researchNotes = "FIRST-IN-CLASS siRNA THERAPEUTIC (Leqvio): Groundbreaking cholesterol-lowering RNA interference agent. Administered by subcutaneous injection just TWICE A YEAR (biannual dosing after day 0 and month 3 initial doses)! ORION clinical trials demonstrated durable, sustained ~50-55% LDL-C reduction with virtually 100% adherence compliance.",
            indications = "Primary hyperlipidemia (including heterozygous familial hypercholesterolemia) and established ASCVD requiring additional LDL-C lowering on maximally tolerated statin therapy.",
            doses = "284 mg administered as a single subcutaneous injection initially, again at 3 months, and then EVERY 6 MONTHS thereafter.",
            adultDose = "284 mg Subcutaneous: Day 0, Month 3, then every 6 months",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Subcutaneous injection administered by a healthcare professional in abdomen, thigh, or upper arm.",
            timing = "Single injection every 6 months.",
            specialInstructions = "Ensure adherence to the 6-month injection schedule. Does not require dose adjustment in renal impairment or mild-to-moderate hepatic impairment.",
            pkPd = "GalNAc-conjugated siRNA targeted directly to asialoglycoprotein receptors (ASGPR) on hepatocytes. Incorporates into the RNA-induced silencing complex (RISC), catalytically cleaving PCSK9 mRNA, preventing PCSK9 protein translation for over 6 months.",
            renalAdj = "No dose adjustment required across mild, moderate, or severe renal impairment, or ESRD.",
            hepaticAdj = "Mild to moderate: No adjustment. Severe (Child-Pugh C): Not studied.",
            pregnancy = "Discontinue when pregnancy is recognized.",
            lactation = "Contraindicated.",
            sideEffects = "Mild injection site reactions (pain, erythema, rash: 8%), arthralgias, urinary tract infections, diarrhea.",
            priceNpr = "Under Global Launch / Specialty Access",
            priceInr = "Under Global Launch / Specialty Access",
            brandsNepal = listOf(
                BrandInfo("Leqvio (Inclisiran)", "Novartis Nepal", "Prefilled Syringe", "284 mg / 1.5 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Leqvio", "Novartis India", "Prefilled Syringe", "284 mg / 1.5 mL")
            ),
            contraindications = "Hypersensitivity to inclisiran or any excipient.",
            modeOfAction = "Directly silences PCSK9 mRNA translation in hepatocytes via RNA interference, preventing PCSK9-mediated LDL receptor lysosomal degradation and maximizing LDL-C recycling.",
            interactions = "No clinically significant drug interactions (not a substrate, inhibitor, or inducer of CYP450 or drug transporters).",
            packSize = "Single-dose prefilled glass syringe (284 mg in 1.5 mL)",
            counselingNepali = "यो वर्षमा जम्मा २ पटक सुई लगाएर नराम्रो कोलेस्ट्रोल आधाभन्दा धेरै घटाउने नयाँ प्रविधिको (siRNA) क्रान्तिकारी औषधि हो। यसले दिनदिनै चक्की खाइरहनुपर्ने झन्झट हटाउँछ।",
            counselingEnglish = "Twice-yearly subcutaneous siRNA injection for durable 50%+ LDL cholesterol reduction. Administered by healthcare professional every 6 months."
        ),

        Drug(
            id = "d_statin_pelacarsen",
            genericName = "Pelacarsen (TQJ230)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Investigational Antisense Oligonucleotide (ASO) Targeting Apolipoprotein(a)",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Statins",
            researchNotes = "INVESTIGATIONAL BREAKTHROUGH: First targeted therapy designed to selectively lower Lipoprotein(a) / Lp(a), an independent, genetically determined, causal cardiovascular risk factor for which NO approved pharmacological therapy currently exists. Phase III HORIZON cardiovascular outcomes trial (Novartis/Ionis) is testing whether monthly 80 mg subcutaneous injection reduces major adverse cardiovascular events (MACE) by reducing Lp(a) by up to 80%!",
            indications = "Under Phase III investigation for the reduction of cardiovascular events in patients with established ASCVD and elevated Lipoprotein(a) (Lp(a) ≥70 mg/dL or ≥175 nmol/L).",
            doses = "Phase III Clinical Trial Regimen: 80 mg administered by subcutaneous injection once monthly.",
            adultDose = "Investigational: 80 mg Subcutaneous once monthly (HORIZON Phase III)",
            childDose = "Not evaluated in children.",
            administration = "Subcutaneous injection once monthly via prefilled autoinjector.",
            timing = "Once monthly.",
            specialInstructions = "Phase III HORIZON trial. Lipoprotein(a) levels are >90% genetically determined and refractory to diet, exercise, and standard statins.",
            pkPd = "GalNAc-conjugated antisense oligonucleotide that specifically hybridizes with human LPA mRNA in hepatocytes, recruiting RNase H1 to degrade the transcript and prevent synthesis of apolipoprotein(a).",
            renalAdj = "Under evaluation in Phase III trials.",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated.",
            lactation = "Contraindicated.",
            sideEffects = "Mild injection site reactions, transient thrombocytopenia (rare with modern GalNAc ASOs), flu-like symptoms.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Pelacarsen (Investigational)", "Novartis Pipeline", "Prefilled Syringe", "80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("TQJ230 (Trial)", "Novartis / Ionis Clinical Studies", "Autoinjector", "80 mg")
            ),
            contraindications = "Hypersensitivity to antisense oligonucleotides, severe active bleeding.",
            modeOfAction = "Selectively degrades apolipoprotein(a) mRNA in hepatocytes via RNase H1, shutting down hepatic assembly of atherogenic and thrombogenic Lipoprotein(a) particles.",
            interactions = "No CYP450 interactions reported.",
            packSize = "Investigational prefilled autoinjector (80 mg)",
            counselingNepali = "यो वंशाणुगत रुपमा रगतमा बढ्ने खतरनाक कोलेस्ट्रोल 'लाइपोप्रोटिन-ए' (Lp(a)) लाई ८०% सम्म घटाउने पहिलो विशेष सुई हो। यसको अन्तिम अनुसन्धान चलिरहेको छ।",
            counselingEnglish = "Phase III targeted antisense therapy specifically lowering genetically elevated Lipoprotein(a) by up to 80% with monthly subcutaneous dosing."
        )
    )
}
