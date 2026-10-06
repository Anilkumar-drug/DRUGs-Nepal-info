package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object ComprehensiveHospitalClinicalDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // CRITICAL CARE & EMERGENCY INJECTIONS
        // ==========================================
        Drug(
            id = "d_hosp_mannitol",
            genericName = "Mannitol 20% IV Infusion",
            system = "Central Nervous System (CNS)",
            drugClass = "Osmotic Diuretic",
            blackBoxWarning = null,
            indications = "Acute management of cerebral edema and elevated intracranial pressure (ICP) in traumatic brain injury, stroke, or intracranial hemorrhage; Impending transtentorial herniation; Reduction of elevated intraocular pressure (IOP) in acute angle-closure glaucoma crisis.",
            doses = "Elevated ICP / Cerebral Edema: 0.25 to 1.0 g/kg (1.25 to 5 mL/kg of 20% solution) IV infused over 20-30 minutes; repeat every 6-8 hours PRN based on ICP and serum osmolality (target serum osmolality <320 mOsm/kg, osmolal gap <20).\nAcute Angle-Closure Glaucoma: 1.5 to 2.0 g/kg (7.5 to 10 mL/kg) IV infused over 30-60 minutes.",
            administration = "Administer strictly IV through an in-line intravenous filter (5 micron or smaller) to capture undissolved crystals. Inspect bottle before infusion; if crystals are present, warm container in warm water bath and shake vigorously before use.",
            timing = "Infuse over 20-30 minutes.",
            specialInstructions = "Always monitor serum sodium, potassium, renal function, and serum osmolality. Discontinue if serum osmolality exceeds 320 mOsm/kg (hyperosmolar acute tubular necrosis risk) or if oliguria/anuria develops.",
            pkPd = "Remains confined to extracellular compartment; does not penetrate intact blood-brain barrier. Onset of ICP reduction within 15-30 minutes; peak effect in 60 minutes; duration 1.5 to 6 hours. Freely filtered at the glomerulus without tubular reabsorption.",
            renalAdj = "Contraindicated in severe, established anuric acute kidney injury or chronic renal failure.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Use only if maternal emergency justifies potential fetal risk).",
            lactation = "Safety not established; use with caution in acute emergencies.",
            sideEffects = "Volume overload, congestive heart failure, acute pulmonary edema (initial intravascular expansion phase), dehydration, electrolyte derangements (hypokalemia, hypernatremia), acute renal failure.",
            priceNpr = "NPR 120.00 - 180.00 per 100 mL / 350 mL bottle",
            priceInr = "INR 80.00 - 120.00 per bottle",
            brandsNepal = listOf(
                BrandInfo("Osmitrol 20%", "Baxter / Medisales Nepal", "IV Infusion", "20% w/v (100 mL / 350 mL)"),
                BrandInfo("Manitol 20%", "Nepal Pharmaceuticals Lab (NPL)", "IV Infusion", "20% (350 mL)"),
                BrandInfo("Mannitol", "Axa Parenterals Nepal", "IV Infusion", "20% (100 mL / 350 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Osmitrol", "Baxter India", "IV Infusion", "20% (100 / 350 mL)"),
                BrandInfo("Mannitol", "Claris", "IV Infusion", "20% (100 / 350 mL)"),
                BrandInfo("Almantol", "Albert David", "IV Infusion", "20% (350 mL)")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "g/kg IV over 30 min (2.5 mL/kg of 20%)",
            adultDose = "0.25-1.0 g/kg (1.25-5 mL/kg of 20%) IV over 20-30 min.",
            childDose = "0.25-0.5 g/kg IV over 20-30 min.",
            contraindications = "Established anuria, severe dehydration, active intracranial bleeding (except during emergency craniotomy), severe congestive heart failure, pulmonary edema.",
            modeOfAction = "Raises blood osmolality, establishing an osmotic gradient that draws free water across an intact blood-brain barrier from brain parenchyma into the intravascular lumen, decreasing cerebral brain volume and lowering ICP; subsequently induces osmotic diuresis in renal tubules.",
            therapeuticClassTag = "Critical Care & ICP Reduction"
        ),

        Drug(
            id = "d_hosp_potassium_chloride",
            genericName = "Potassium Chloride (KCl)",
            system = "Endocrine & Metabolic",
            drugClass = "Essential Electrolyte Replacement",
            blackBoxWarning = "FATAL IF INJECTED UNDILUTED: Never administer Potassium Chloride IV push, bolus, or undiluted. Direct IV push of concentrated KCl causes instantaneous cardiac arrest.",
            indications = "Treatment and prevention of hypokalemia (serum potassium <3.5 mEq/L) in hospital wards, intensive care units, and outpatient care; Cardiac arrhythmia stabilization during digitalis toxicity.",
            doses = "Oral Replacement (Mild-Moderate K+ 3.0-3.5 mEq/L): 20 to 40 mEq PO daily in 2-3 divided doses after meals (e.g. 15 mL Potclor syrup TID = ~30 mEq/day).\nIntravenous Replacement (Severe K+ <3.0 mEq/L or Symptomatic): Dilute KCl concentrate into IV fluid (0.9% NaCl preferred over dextrose). Peripheral IV max concentration 40 mEq/L at rate <= 10 mEq/hr. Central venous catheter max concentration 60-80 mEq/L at rate <= 20 mEq/hr with continuous ECG monitoring.",
            administration = "Oral: Take with meals and dilute syrup in water/juice to prevent gastric ulceration. IV: Must be diluted thoroughly in large volume IV fluids. Never give IV push.",
            timing = "Divided oral doses with meals; continuous IV infusion at controlled rate.",
            specialInstructions = "Always check and correct hypomagnesemia concurrently (hypokalemia is refractory to replacement until serum magnesium is normalized, as magnesium is a cofactor for the Na+/K+ ATPase pump).",
            pkPd = "Oral potassium is well absorbed (~90%). Normal serum concentration 3.5 to 5.0 mEq/L. Excreted predominantly by the kidneys (90%) and feces (10%).",
            renalAdj = "Use extreme caution in renal insufficiency; reduce replacement doses by 50% and monitor serum potassium frequently to avoid hyperkalemic arrest.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Safe when used to correct maternal deficiency).",
            lactation = "Safe; normal constituent of breast milk.",
            sideEffects = "Hyperkalemia (peaked T waves, heart block, ventricular fibrillation), local phlebitis/pain at peripheral IV site, nausea, vomiting, abdominal cramps, GI ulceration with oral tablets.",
            priceNpr = "NPR 110.00 - 180.00 per bottle syrup (200 mL) / NPR 25.00 per ampoule (10 mL 15% KCl)",
            priceInr = "INR 70.00 - 120.00 per syrup / INR 15.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Potclor", "TC Health / Medisales Nepal", "Syrup", "20 mEq/15 mL (200 mL)"),
                BrandInfo("KCl 15%", "Axa Parenterals Nepal", "Inj Ampoule", "15% w/v (20 mEq/10 mL)"),
                BrandInfo("K-Lyte", "National Healthcare Nepal", "Syrup", "20 mEq/15 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Potclor", "Walter Bushnell", "Oral Liquid", "20 mEq/15 mL"),
                BrandInfo("Potkemi", "Alkem", "Inj Ampoule", "15% (10 mL)"),
                BrandInfo("K-Cit", "Cipla", "Syrup", "200 mL")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "mEq/kg/day PO in 2-3 divided doses",
            adultDose = "Oral: 20-40 mEq/day in divided doses. IV: 10-20 mEq/hr diluted.",
            childDose = "Oral: 1-2 mEq/kg/day. IV: 0.5-1 mEq/kg diluted at max 0.25-0.5 mEq/kg/hr.",
            contraindications = "Hyperkalemia (serum potassium >5.0 mEq/L), severe acute oliguric/anuric renal failure, untreated Addison's disease, acute dehydration, potassium-sparing diuretics concurrently without monitoring.",
            modeOfAction = "Major intracellular cation essential for maintaining the resting membrane potential of excitable tissues (cardiac myocytes, skeletal muscle, neurons), normal cardiac contractility, and acid-base regulation.",
            therapeuticClassTag = "Critical Care & Electrolytes"
        ),

        Drug(
            id = "d_hosp_phytomenadione",
            genericName = "Phytomenadione (Vitamin K1)",
            system = "Hematology & Oncology",
            drugClass = "Fat-Soluble Coagulation Factor Cofactor",
            blackBoxWarning = "IV ANAPHYLAXIS RISK: Severe reactions, including fatalities, resembling anaphylaxis/anaphylactoid shock have occurred during and immediately after IV administration of phytomenadione, even when diluted and given slowly. The subcutaneous or oral routes are preferred unless life-threatening hemorrhage is present.",
            indications = "Emergency reversal of warfarin-induced coagulopathy and major bleeding (in combination with 4-factor Prothrombin Complex Concentrate [4F-PCC] or Fresh Frozen Plasma [FFP]); Hypoprothrombinemia secondary to obstructive jaundice, prolonged broad-spectrum antibiotics, or severe malnutrition; Universal prophylaxis and treatment of Vitamin K Deficiency Bleeding (VKDB) / Hemorrhagic Disease of the Newborn.",
            doses = "Warfarin Major Bleeding Reversal: 5 to 10 mg slow IV infusion over 20-30 minutes (co-administered with PCC or FFP).\nWarfarin Asymptomatic INR >10: 2.5 to 5 mg PO (or 1-2 mg PO for INR 4.5-10).\nNeonatal Prophylaxis: 1 mg IM at birth (single dose) for all healthy neonates (or 0.5 mg IM for preterm infants <32 weeks or <1 kg).\nSevere Liver Disease / Biliary Obstruction: 10 mg slow IV or SC daily for 3 days.",
            administration = "Oral route is preferred for asymptomatic warfarin over-anticoagulation. Neonatal prophylaxis must be administered intramuscularly into the anterolateral thigh. IV must be diluted in 50 mL D5W or 0.9% NaCl and infused very slowly over 20-30 minutes.",
            timing = "Single dose stat, repeated in 12-24 hours if INR remains elevated.",
            specialInstructions = "Vitamin K1 requires 6 to 24 hours to stimulate de novo hepatic synthesis of functional clotting factors; therefore, in life-threatening bleeding, immediate replacement of preformed factors with 4F-PCC or FFP is mandatory.",
            pkPd = "Onset of INR improvement is 1-2 hours after IV and 6-12 hours after oral dosing. Peak effect at 24 hours. Metabolized in the liver and eliminated in bile and urine.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Ineffective if severe end-stage hepatocellular necrosis prevents clotting factor synthesis.",
            pregnancy = "Category C (Essential in pregnancy for coagulopathy; does not readily cross placenta).",
            lactation = "Safe; low concentrations in breast milk, which is why universal neonatal prophylaxis is critical.",
            sideEffects = "Flushing, sweating, chest tightness, anaphylactoid shock with rapid IV injection, local hematoma at IM injection site in severely anticoagulated patients, hyperbilirubinemia in premature neonates at excessive doses.",
            priceNpr = "NPR 45.00 - 85.00 per ampoule (10 mg/mL / 1 mg/0.5 mL)",
            priceInr = "INR 30.00 - 60.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Kenadion", "Samarth Life Sciences / Medisales Nepal", "Inj Ampoule", "10 mg/mL / 1 mg/0.5 mL"),
                BrandInfo("Phytonadione", "Neon Laboratories Nepal", "Inj Ampoule", "10 mg/mL"),
                BrandInfo("K-Win", "Mankind Nepal", "Inj Ampoule", "10 mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Kenadion", "Samarth", "Inj Ampoule", "10 mg/mL / 1 mg/0.5 mL"),
                BrandInfo("Phytonadione", "Neon Labs", "Inj", "10 mg/mL"),
                BrandInfo("K-Win", "Mankind", "Inj", "10 mg/mL")
            ),
            adultDose = "Warfarin major bleed: 5-10 mg slow IV. High INR without bleed: 2.5-5 mg PO.",
            childDose = "Neonatal prophylaxis: 1 mg IM stat at birth (0.5 mg for preterm <1 kg).",
            contraindications = "Hypersensitivity to phytomenadione or polyoxyethylated castor oil excipient.",
            modeOfAction = "Essential cofactor for microsomal gamma-glutamyl carboxylase, which catalyzes the post-translational carboxylation of glutamic acid residues on coagulation factors II (prothrombin), VII, IX, and X, as well as endogenous anticoagulants Protein C and Protein S.",
            therapeuticClassTag = "Critical Care & Hemostasis"
        ),

        // ==========================================
        // HOSPITAL & RESISTANT ANTIMICROBIALS
        // ==========================================
        Drug(
            id = "d_hosp_cefoperazone_sulbactam",
            genericName = "Cefoperazone Sodium + Sulbactam Sodium (1:1 / 2:1)",
            system = "Anti-Infective System",
            drugClass = "Antipseudomonal Third-Generation Cephalosporin + Beta-Lactamase Inhibitor",
            blackBoxWarning = null,
            indications = "Empiric and targeted treatment of severe hospital-acquired pneumonia (HAP), ventilator-associated pneumonia (VAP), complicated intra-abdominal sepsis, biliary tract infections, febrile neutropenia, complicated urinary tract infections, and post-operative septicemia involving Pseudomonas aeruginosa and ESBL-producing Enterobacterales.",
            doses = "Adult: 1.5 g to 3.0 g (1:1 formulation: 1000 mg cefoperazone + 1000 mg sulbactam to 2000 mg cefoperazone + 1000 mg sulbactam) IV every 12 hours (max 4 g sulbactam and 8 g cefoperazone daily in severe ICU sepsis).\nPediatric: 40 to 80 mg/kg/day (cefoperazone content) divided IV every 12 hours.",
            administration = "Reconstitute with Sterile Water for Injection, then dilute in 50-100 mL of 0.9% NaCl or D5W and infuse intravenously over 30 to 60 minutes. Deep IM injection is possible with 0.5% lidocaine.",
            timing = "Every 12 hours (or every 8 hours in severe Pseudomonal ICU infections).",
            specialInstructions = "Contains an N-methylthiotetrazole (NMTT) side chain which can inhibit hepatic Vitamin K epoxide reductase and cause hypoprothrombinemia and bleeding (give prophylactic Vitamin K1 10 mg weekly during prolonged courses). Causes severe disulfiram-like ethanol intolerance; strictly avoid alcohol.",
            pkPd = "Excreted predominantly through biliary secretion (~75% of cefoperazone) into feces; sulbactam is eliminated primarily via glomerular filtration (~75-80%) in urine. Terminal half-life ~2 hours.",
            renalAdj = "Sulbactam accumulates in renal failure: CrCl 30-50 mL/min: Max 1 g sulbactam q12h. CrCl 15-29 mL/min: Max 1 g sulbactam q12h (max 2 g/day sulbactam). CrCl <15 mL/min: Max 500 mg sulbactam q12h.",
            hepaticAdj = "Cefoperazone dose should not exceed 2 g/day in severe hepatic cirrhosis or biliary obstruction.",
            pregnancy = "Category B (Safe; crosses placenta).",
            lactation = "Compatible; low concentrations in breast milk.",
            sideEffects = "Diarrhea, pseudomembranous colitis, hypoprothrombinemia, bleeding, maculopapular rash, transient elevation of liver enzymes (ALT/AST), disulfiram-like reaction with alcohol.",
            priceNpr = "NPR 350.00 - 680.00 per vial (1.5 g / 2.0 g / 3.0 g)",
            priceInr = "INR 220.00 - 450.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Magnex", "Pfizer / Medisales Nepal", "IV Injection Vial", "1 g / 2 g (1:1 / 2:1)"),
                BrandInfo("Sulbacin", "Alkem Nepal", "IV Injection Vial", "1.5 g / 3 g"),
                BrandInfo("Sulcef", "National Healthcare Nepal", "IV Injection Vial", "1.5 g / 3 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Magnex", "Pfizer India", "IV Vial", "1 g / 2 g"),
                BrandInfo("Sulbacin", "Alkem", "IV Vial", "1.5 g / 3 g"),
                BrandInfo("Cefbact-S", "Cipla", "IV Vial", "1.5 g")
            ),
            pediatricDosePerKg = 60.0,
            pediatricInterval = "mg/kg/day IV divided q12h",
            adultDose = "1.5 g to 3 g IV q12h (infused over 30-60 min).",
            childDose = "40-80 mg/kg/day IV divided q12h.",
            contraindications = "Hypersensitivity to cephalosporins, penicillins, or beta-lactamase inhibitors.",
            modeOfAction = "Cefoperazone binds to and inactivates bacterial penicillin-binding proteins (PBPs), inhibiting bacterial cell wall peptidoglycan synthesis; Sulbactam irreversibly binds to and inactivates beta-lactamase enzymes (including class A ESBLs), restoring cefoperazone activity.",
            therapeuticClassTag = "Antimicrobials & ICU Sepsis"
        ),

        Drug(
            id = "d_hosp_teicoplanin",
            genericName = "Teicoplanin",
            system = "Anti-Infective System",
            drugClass = "Semisynthetic Glycopeptide Antibacterial",
            blackBoxWarning = null,
            indications = "Complicated skin and soft-tissue infections, bone and joint infections (osteomyelitis, septic arthritis), hospital-acquired pneumonia, complicated bacteremia and infective endocarditis caused by Methicillin-Resistant Staphylococcus aureus (MRSA), MRSE, and Enterococcus faecalis; Preferred over Vancomycin when renal-sparing therapy is required.",
            doses = "Loading Dose (Crucial for target trough levels): 400 mg (or 6 mg/kg) IV every 12 hours for the first 3 to 5 doses (for severe sepsis/endocarditis/osteomyelitis, load at 800 mg or 12 mg/kg q12h for 3-5 doses).\nMaintenance: 400 mg (6 mg/kg) or 800 mg (12 mg/kg) IV or IM once daily.",
            administration = "Reconstitute with supplied diluent; inject slowly over 5 minutes or dilute in 100 mL 0.9% NaCl and infuse over 30 minutes. Unlike vancomycin, teicoplanin can also be given as a rapid IV push or intramuscularly (IM) without causing Red Man Syndrome.",
            timing = "Once daily after completing the loading doses.",
            specialInstructions = "Significantly lower incidence of nephrotoxicity and ototoxicity compared to vancomycin. Routine therapeutic drug monitoring (TDM) is not required for standard infections, but target trough in endocarditis/osteomyelitis is >20-30 mg/L.",
            pkPd = "High plasma protein binding (90-95%). Very long terminal elimination half-life of 100 to 170 hours (enables once-daily maintenance). Excreted unchanged by the kidneys (>80%).",
            renalAdj = "Day 1-4: Normal loading doses. Day 5 onwards: CrCl 30-80 mL/min: Give 50% of maintenance dose once daily or full dose every 48 hours. CrCl <30 mL/min or hemodialysis: Give 33% of maintenance dose once daily or full dose every 72 hours.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Avoid unless benefit clearly outweighs risk).",
            lactation = "Excretion in human milk not established; use with caution.",
            sideEffects = "Erythema, rash, pruritus, transient elevation of transaminases and serum alkaline phosphatase, thrombocytosis, ototoxicity/nephrotoxicity (rare).",
            priceNpr = "NPR 1100.00 - 1800.00 per vial (200 mg / 400 mg)",
            priceInr = "INR 750.00 - 1200.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Targocid", "Sanofi / Medisales Nepal", "IV/IM Injection Vial", "200 mg / 400 mg"),
                BrandInfo("Teicoplan", "Alkem Nepal", "IV/IM Injection Vial", "400 mg"),
                BrandInfo("Ticocin", "Cipla Nepal", "IV/IM Injection Vial", "200 mg / 400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Targocid", "Sanofi India", "IV/IM Vial", "200 mg / 400 mg"),
                BrandInfo("Teicoplan", "Alkem", "IV/IM Vial", "400 mg"),
                BrandInfo("Ticocin", "Cipla", "IV/IM Vial", "400 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg/kg IV q12h x 3 doses, then 10 mg/kg once daily",
            adultDose = "Load 400-800 mg IV q12h x 3-5 doses, then 400-800 mg once daily.",
            childDose = "Load 10 mg/kg q12h x 3 doses, then 6-10 mg/kg IV once daily.",
            contraindications = "Hypersensitivity to teicoplanin or glycopeptide antibacterials.",
            modeOfAction = "Inhibits bacterial cell wall synthesis by binding with high affinity to the D-alanyl-D-alanine terminus of cell wall peptidoglycan precursors, preventing peptidoglycan polymerization and cross-linking, causing bacterial cell lysis.",
            therapeuticClassTag = "Antimicrobials & MRSA"
        ),

        Drug(
            id = "d_hosp_faropenem",
            genericName = "Faropenem Sodium",
            system = "Anti-Infective System",
            drugClass = "Oral Penem Antibacterial",
            blackBoxWarning = null,
            indications = "Complicated and uncomplicated urinary tract infections (including ESBL E. coli and Klebsiella); Acute bacterial sinusitis; Acute exacerbation of chronic bronchitis and community-acquired pneumonia; Skin and soft tissue infections resistant to standard oral beta-lactams and cephalosporins.",
            doses = "Adult: 200 mg to 300 mg PO three times daily (TID) for 7 to 10 days.\nSevere or Complicated Infections: 300 mg PO TID.",
            administration = "Take orally with or without food. Swallow whole with water.",
            timing = "Three times daily at 8-hour intervals.",
            specialInstructions = "Possesses high stability against hydrolysis by extended-spectrum beta-lactamases (ESBLs) and AmpC beta-lactamases; reserves parenteral carbapenems (meropenem/imipenem) by serving as an oral step-down agent.",
            pkPd = "Oral bioavailability ~70-80%. Bound to plasma proteins (~96%). Rapidly hydrolyzed by human renal dehydropeptidase-I (DHP-I) to a lesser extent than imipenem. Half-life ~1 hour.",
            renalAdj = "CrCl 30-50 mL/min: 200 mg PO BID. CrCl 10-29 mL/min: 150-200 mg PO once daily. CrCl <10 mL/min: 100 mg PO once daily.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safety in human pregnancy not established; use with caution).",
            lactation = "Excreted in animal milk; use with caution in nursing mothers.",
            sideEffects = "Diarrhea, loose stools, nausea, abdominal discomfort, rash, pruritus, transient elevation of AST/ALT.",
            priceNpr = "NPR 450.00 - 850.00 per strip of 6 (200 mg / 300 mg)",
            priceInr = "INR 300.00 - 580.00 per strip of 6",
            brandsNepal = listOf(
                BrandInfo("Farobact", "Cipla Nepal", "Tablet", "200 mg / 300 mg"),
                BrandInfo("Faronem", "Sun Pharma Nepal", "Tablet", "200 mg / 300 mg"),
                BrandInfo("Faropen", "Alkem Nepal", "Tablet", "200 mg / 300 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Farobact", "Cipla", "Tablet", "200 mg / 300 mg"),
                BrandInfo("Faronem", "Sun Pharma", "Tablet", "200 mg / 300 mg"),
                BrandInfo("Duonem", "Mankind", "Tablet", "200 mg / 300 mg")
            ),
            adultDose = "200-300 mg PO TID x 7-10 days.",
            childDose = "Pediatric granules: 15-30 mg/kg/day PO divided TID.",
            contraindications = "Hypersensitivity to faropenem, carbapenems, or penicillins.",
            modeOfAction = "Binds with high affinity to high-molecular-weight penicillin-binding proteins (PBPs, particularly PBP-2 and PBP-1A/1B), inhibiting bacterial cell wall peptidoglycan synthesis; resistant to class A and C beta-lactamases.",
            therapeuticClassTag = "Antimicrobials & Oral Penems"
        ),

        Drug(
            id = "d_hosp_valacyclovir",
            genericName = "Valacyclovir Hydrochloride",
            system = "Anti-Infective System",
            drugClass = "L-Valyl Ester Prodrug of Acyclovir (Antiviral)",
            blackBoxWarning = "TTP / HUS IN IMMUNOCOMPROMISED: Thrombotic Thrombocytopenic Purpura / Hemolytic Uremic Syndrome (TTP/HUS), sometimes resulting in death, has occurred in patients with advanced HIV or allogeneic bone marrow transplant receiving high doses (8 g/day).",
            indications = "Herpes Zoster (Shingles) in immunocompetent and immunocompromised adults (hastens rash healing, curtails pain duration, reduces postherpetic neuralgia incidence); Genital Herpes Simplex (initial episode, recurrence, and chronic suppressive therapy); Herpes Labialis (cold sores); Chickenpox in pediatric patients.",
            doses = "Herpes Zoster (Shingles): 1000 mg PO TID for 7 days (must initiate within 72 hours of rash onset).\nCold Sores (Herpes Labialis): 2000 mg PO BID for 1 day (taken 12 hours apart).\nGenital Herpes Initial: 1000 mg PO BID for 10 days. Recurrent: 500 mg PO BID for 3 days.\nChronic Suppression of Genital Herpes: 500 mg to 1000 mg PO once daily.",
            administration = "Take orally with or without meals. Maintain robust oral hydration to prevent acyclovir crystallization in renal tubules.",
            timing = "TID for shingles (morning, afternoon, bedtime) or BID for genital herpes.",
            specialInstructions = "Rapidly and almost completely converted to acyclovir by hepatic valacyclovir hydrolase, achieving 3- to 5-fold higher acyclovir serum bioavailability (~55%) than oral acyclovir (~15%), enabling convenient 3-times-daily dosing instead of 5-times-daily acyclovir.",
            pkPd = "Oral bioavailability 54.5%. Rapidly converted in liver and intestinal brush border to acyclovir and L-valine. Acyclovir is eliminated primarily by renal glomerular filtration and active tubular secretion. Half-life ~2.5-3 hours.",
            renalAdj = "Herpes Zoster Dosing: CrCl 30-49 mL/min: 1000 mg PO q12h. CrCl 10-29 mL/min: 1000 mg PO q24h. CrCl <10 mL/min or hemodialysis: 500 mg PO q24h (administer after hemodialysis).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe; extensively used in pregnancy for maternal genital herpes).",
            lactation = "Safe; excreted into breast milk as acyclovir in small amounts.",
            sideEffects = "Headache, nausea, abdominal pain, dizziness, fatigue, elevated liver transaminases, acute renal failure (rare, caused by tubular crystallization if dehydrated).",
            priceNpr = "NPR 180.00 - 320.00 per strip of 3 / 6 (500 mg / 1000 mg)",
            priceInr = "INR 120.00 - 220.00 per strip of 3",
            brandsNepal = listOf(
                BrandInfo("Valcivir", "Cipla Nepal", "Tablet", "500 mg / 1000 mg"),
                BrandInfo("Valamac", "Macleods Nepal", "Tablet", "500 mg / 1000 mg"),
                BrandInfo("Herpival", "Sun Pharma Nepal", "Tablet", "500 mg / 1000 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Valcivir", "Cipla", "Tablet", "500 mg / 1000 mg"),
                BrandInfo("Valamac", "Macleods", "Tablet", "1000 mg"),
                BrandInfo("Valcet", "Dr. Reddy's", "Tablet", "1000 mg")
            ),
            adultDose = "Shingles: 1000 mg PO TID x 7 days. Genital herpes: 500-1000 mg PO BID.",
            childDose = "Chickenpox (>=2 yr): 20 mg/kg PO TID x 5 days (max 1000 mg/dose).",
            contraindications = "Hypersensitivity to valacyclovir, acyclovir, or ganciclovir.",
            modeOfAction = "Rapidly converted to acyclovir, which is selectively monophosphorylated by viral thymidine kinase, then converted by host cellular kinases to acyclovir triphosphate; acyclovir triphosphate competitively inhibits viral DNA polymerase and acts as an obligate chain terminator of viral DNA replication.",
            therapeuticClassTag = "Antivirals & Herpesvirus"
        ),

        // ==========================================
        // CARDIOLOGY & VASCULAR MEDICINE
        // ==========================================
        Drug(
            id = "d_hosp_verapamil",
            genericName = "Verapamil Hydrochloride",
            system = "Cardiovascular System",
            drugClass = "Non-Dihydropyridine Phenylalkylamine Calcium Channel Blocker (Class IV Antiarrhythmic)",
            blackBoxWarning = null,
            indications = "Acute termination of paroxysmal supraventricular tachycardia (PSVT); Ventricular rate control in atrial fibrillation and atrial flutter; Chronic management of classic effort angina and vasospastic (Prinzmetal's) angina; Essential hypertension; Hypertrophic cardiomyopathy (HOCM) symptom relief; Prophylaxis of chronic cluster headache.",
            doses = "Acute PSVT (Emergency IV): 5 mg to 10 mg (0.075 to 0.15 mg/kg) slow IV push over at least 2 minutes; repeat with 10 mg after 15-30 minutes if initial response is inadequate.\nOral Maintenance (Rate Control / Angina / Hypertension): 40 mg to 80 mg PO TID or QID (or 120-240 mg PO once daily of sustained-release formulation; max 480 mg/day).\nCluster Headache Prophylaxis: 240 mg to 480 mg PO daily in divided doses (titrate slowly with baseline and follow-up ECG for PR prolongation).",
            administration = "IV: Administer slow IV push over at least 2 minutes with continuous ECG and blood pressure monitoring. Oral: Take with or without food. Swallow SR tablets whole.",
            timing = "TID-QID for immediate release or once daily for SR.",
            specialInstructions = "Strictly contraindicated in Wolff-Parkinson-White (WPW) syndrome with atrial fibrillation (blocks AV node and accelerates accessory pathway conduction, triggering fatal ventricular fibrillation). Co-administration with IV beta-blockers causes severe bradycardia and cardiogenic shock.",
            pkPd = "Oral bioavailability is only 20-35% due to profound hepatic first-pass metabolism by CYP3A4. Elimination half-life ~4-12 hours. Active metabolite norverapamil possesses 20% of parent vasodilator activity.",
            renalAdj = "No adjustment needed; monitor for fluid retention.",
            hepaticAdj = "Severe hepatic cirrhosis reduces clearance markedly; decrease oral dose to 20-30% of normal dose.",
            pregnancy = "Category C (Use only if potential benefit justifies potential risk).",
            lactation = "Excreted into human milk in small amounts; use with caution.",
            sideEffects = "Constipation (most common adverse effect ~7-10%), bradycardia, AV block (PR prolongation), hypotension, dizziness, peripheral ankle edema, worsening heart failure.",
            priceNpr = "NPR 45.00 - 85.00 per strip of 10 (40 mg / 80 mg) / NPR 35.00 per ampoule (5 mg/2 mL)",
            priceInr = "INR 25.00 - 55.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Calaptin", "Abbott / Medisales Nepal", "Tablet / Inj", "40 mg / 80 mg / 240mg SR / 5mg/2mL"),
                BrandInfo("Isoptin", "Abbott Nepal", "Tablet / Inj", "40 mg / 80 mg"),
                BrandInfo("Veramil", "National Healthcare Nepal", "Tablet", "40 mg / 80 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Calaptin", "Abbott India", "Tablet / Inj", "40 mg / 80 mg / 240 mg SR"),
                BrandInfo("Isoptin", "Abbott", "Tablet", "40 mg / 80 mg")
            ),
            adultDose = "IV: 5-10 mg slow IV push over 2 min. Oral: 80 mg TID (max 480 mg/day).",
            childDose = "Pediatric PSVT: 0.1 to 0.2 mg/kg IV over 2 min (avoid in infants <1 year due to severe hypotension).",
            contraindications = "Severe left ventricular systolic dysfunction (HFrEF EF <40%), severe hypotension or cardiogenic shock, 2nd or 3rd degree AV block, sick sinus syndrome, atrial fibrillation with an accessory pathway (WPW syndrome).",
            modeOfAction = "Inhibits transmembrane calcium influx through L-type voltage-sensitive calcium channels in cardiac myocytes, sinoatrial (SA) node, and atrioventricular (AV) nodal tissue; slows AV nodal conduction velocity and prolongs refractory period, while relaxing coronary vascular smooth muscle.",
            therapeuticClassTag = "Cardiovascular & Antiarrhythmics"
        ),

        // ==========================================
        // NEUROLOGY, DEMENTIA & PSYCHIATRY
        // ==========================================
        Drug(
            id = "d_hosp_donepezil",
            genericName = "Donepezil Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Reversible Centrally Acting Acetylcholinesterase Inhibitor",
            blackBoxWarning = null,
            indications = "Symptomatic treatment of mild, moderate, and severe dementia of the Alzheimer's type; Vascular dementia (off-label cognitive benefit).",
            doses = "Mild-to-Moderate Alzheimer's: Initial 5 mg PO once daily at bedtime; after 4 to 6 weeks, may increase to 10 mg PO once daily based on clinical response.\nModerate-to-Severe Alzheimer's: 10 mg once daily for at least 3 months, then may increase to 23 mg PO once daily.",
            administration = "Take orally once daily at bedtime with a glass of water. If patient experiences vivid disturbing dreams or night terrors, dosing may be switched to the morning.",
            timing = "Once daily at bedtime.",
            specialInstructions = "Re-evaluate cognitive response periodically. Cholinesterase inhibitors can cause vagotonic bradycardia, syncope, and QT prolongation; perform baseline ECG to exclude pre-existing heart block or sick sinus syndrome.",
            pkPd = "Well absorbed; relative bioavailability 100%. Highly bound to plasma proteins (96%). Metabolized in liver by CYP2D6 and CYP3A4. Extremely long elimination half-life (~70 hours).",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed in mild-to-moderate impairment.",
            pregnancy = "Category C (Safety in pregnancy not established).",
            lactation = "Not recommended during breastfeeding.",
            sideEffects = "Nausea, diarrhea, insomnia, muscle cramps, fatigue, anorexia, weight loss, bradycardia, syncope, peptic ulcer aggravation, vivid dreams.",
            priceNpr = "NPR 140.00 - 260.00 per strip of 10 (5 mg / 10 mg)",
            priceInr = "INR 90.00 - 180.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Aricept", "Eisai / Pfizer / Medisales Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Donecept", "Cipla Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dopezil", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Aricept", "Eisai India", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Donecept", "Cipla", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dopezil", "Sun Pharma", "Tablet", "5 mg / 10 mg")
            ),
            adultDose = "5 mg PO once daily at bedtime x 4-6 weeks, then 10 mg once daily.",
            childDose = "Not indicated in pediatric patients.",
            contraindications = "Hypersensitivity to donepezil or piperidine derivatives; severe active GI bleeding.",
            modeOfAction = "Selectively and reversibly inhibits acetylcholinesterase in the central nervous system, preventing hydrolysis of acetylcholine and enhancing cholinergic neurotransmission in surviving cerebral cortical and hippocampal neurons.",
            therapeuticClassTag = "Neurology & Dementia"
        ),

        Drug(
            id = "d_hosp_memantine",
            genericName = "Memantine Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Uncompetitive N-Methyl-D-Aspartate (NMDA) Receptor Antagonist",
            blackBoxWarning = null,
            indications = "Treatment of moderate-to-severe dementia of the Alzheimer's type (as monotherapy or in combination with donepezil to reduce clinical decline).",
            doses = "Adult: Initial 5 mg PO once daily; titrate upward in 5 mg weekly increments to target maintenance 10 mg PO twice daily (20 mg/day total).\nTitration Schedule: Week 1: 5 mg daily; Week 2: 5 mg BID; Week 3: 10 mg morning + 5 mg evening; Week 4 onwards: 10 mg BID.",
            administration = "Take orally with or without food. May be administered concurrently with acetylcholinesterase inhibitors (e.g. Donepezil).",
            timing = "Twice daily (morning and evening) once titrated.",
            specialInstructions = "Alkalinization of urine (e.g. by high vegetarian diet, renal tubular acidosis, or sodium bicarbonate) decreases memantine renal clearance and elevates serum levels; monitor closely.",
            pkPd = "Completely absorbed; bioavailability 100%. Low protein binding (45%). Crosses blood-brain barrier readily. Eliminated largely unchanged via urine (50-80%). Terminal half-life 60-80 hours.",
            renalAdj = "CrCl 30-49 mL/min: Target dose 5 mg PO BID (10 mg/day). CrCl 5-29 mL/min: Target dose 5 mg PO once daily. CrCl <5 mL/min: Not recommended.",
            hepaticAdj = "No adjustment needed in mild to moderate hepatic impairment.",
            pregnancy = "Category B (Use only if clearly needed).",
            lactation = "Safety in breastfeeding not established.",
            sideEffects = "Dizziness, headache, confusion, constipation, hypertension, coughing, somnolence, hallucination.",
            priceNpr = "NPR 160.00 - 290.00 per strip of 10 (5 mg / 10 mg)",
            priceInr = "INR 110.00 - 200.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Namenda", "Allergan / Medisales Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Admenta", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Mentis", "Torrent Nepal", "Tablet", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Admenta", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Mentis", "Torrent", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Alminda", "Torrent", "Tablet", "10 mg")
            ),
            adultDose = "Titrate weekly by 5 mg up to 10 mg PO BID (20 mg/day).",
            childDose = "Safety and efficacy not established in children.",
            contraindications = "Hypersensitivity to memantine or formulation components.",
            modeOfAction = "Low-to-moderate affinity, uncompetitive, open-channel NMDA receptor antagonist that binds to NMDA receptor-operated cation channels, blocking pathological tonic levels of glutamate neurotoxicity while preserving normal physiological synaptic transmission required for learning and memory.",
            therapeuticClassTag = "Neurology & Dementia"
        ),

        Drug(
            id = "d_hosp_lamotrigine",
            genericName = "Lamotrigine",
            system = "Central Nervous System (CNS)",
            drugClass = "Voltage-Gated Sodium Channel Blocker & Glutamate Release Inhibitor (Anticonvulsant)",
            blackBoxWarning = "SERIOUS SKIN RASHES (STEVENS-JOHNSON SYNDROME / TEN): Lamotrigine can cause severe cutaneous adverse reactions, including SJS and Toxic Epidermal Necrolysis. Risk is markedly increased by co-administration with Valproate, rapid initial dose titration, or exceeding recommended starting doses. Discontinue at the first sign of rash.",
            indications = "Monotherapy and adjunctive therapy for focal (partial) seizures, generalized tonic-clonic seizures, and Lennox-Gastaut syndrome in adults and children; Maintenance treatment of Bipolar I Disorder to delay occurrence of depressive episodes; Preferred first-line antiepileptic during pregnancy (lowest major congenital malformation rate).",
            doses = "Monotherapy / Non-Interacting Drugs: Weeks 1-2: 25 mg PO once daily; Weeks 3-4: 50 mg daily; Week 5: increase by 50 mg every 1-2 weeks to maintenance 100-200 mg daily (divided BID).\nWith Concomitant Valproate (Enzyme Inhibitor): Weeks 1-2: 25 mg PO every other day; Weeks 3-4: 25 mg daily; titrate to maintenance 100-200 mg daily.\nWith Carbamazepine/Phenytoin (Enzyme Inducers): Weeks 1-2: 50 mg daily; Weeks 3-4: 100 mg daily; titrate to maintenance 200-400 mg daily.",
            administration = "Take orally with or without food. Swallow tablets whole; dispersible/chewable forms can be chewed or dissolved in small volume of water/juice.",
            timing = "Once or twice daily.",
            specialInstructions = "Always follow strict step-wise dose titration to minimize fatal rash risk. Estrogen-containing oral contraceptives induce lamotrigine glucuronidation and lower serum levels by ~50% (may precipitate breakthrough seizures); dose adjustment is required.",
            pkPd = "Rapidly and completely absorbed (>98%). Metabolized predominantly by hepatic glucuronidation (UGT1A4) to inactive glucuronides. Elimination half-life ~25-30 hours (shortened to 14 hr with inducers; lengthened to 60-70 hr with valproate).",
            renalAdj = "Reduce maintenance dose by 50% in significant renal impairment.",
            hepaticAdj = "Severe cirrhosis without ascites: Reduce dose by 50%. With ascites: Reduce dose by 75%.",
            pregnancy = "Category C (Safest antiepileptic in pregnancy; monitor levels due to enhanced clearance in 2nd/3rd trimesters; co-prescribe high-dose folic acid 5 mg).",
            lactation = "Excreted into breast milk; monitor infant for rash, apnea, or drowsiness.",
            sideEffects = "Rash (SJS/TEN risk), dizziness, ataxia, diplopia, blurred vision, headache, nausea, insomnia, aseptic meningitis (rare), DRESS syndrome.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (25 mg / 50 mg / 100 mg)",
            priceInr = "INR 70.00 - 150.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Lamitor", "Torrent Pharmaceuticals Nepal", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Lamictal", "GSK / Medisales Nepal", "Tablet / Dispersible", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Lamez", "Intas Nepal", "Tablet", "25 mg / 50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lamitor", "Torrent", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Lamictal", "GSK India", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Lamez", "Intas", "Tablet", "25 mg / 50 mg / 100 mg")
            ),
            adultDose = "Titrate from 25 mg daily up to maintenance 100-200 mg/day divided BID.",
            childDose = "Weight-based strict titration: 0.15 mg/kg/day with valproate; 0.6 mg/kg/day without.",
            contraindications = "Hypersensitivity to lamotrigine; history of lamotrigine-induced SJS/TEN or DRESS.",
            modeOfAction = "Use- and voltage-dependent blockade of voltage-sensitive sodium channels, stabilizing presynaptic neuronal membranes and suppressing rapid firing; subsequently inhibits pathological release of excitatory neurotransmitters (primarily glutamate and aspartate).",
            therapeuticClassTag = "Neurology & Antiepileptics"
        ),

        Drug(
            id = "d_hosp_clobazam",
            genericName = "Clobazam",
            system = "Central Nervous System (CNS)",
            drugClass = "1,5-Benzodiazepine Anticonvulsant & Anxiolytic",
            blackBoxWarning = "CONCURRENT OPIOID RISK: Concomitant use of benzodiazepines and opioids may result in profound sedation, respiratory depression, coma, and death.",
            indications = "Adjunctive therapy for refractory focal and generalized epilepsy; Lennox-Gastaut syndrome; Catamenial epilepsy (peri-menstrual seizure clustering); Short-term management of acute severe anxiety.",
            doses = "Adult: Initial 5 mg to 10 mg PO once daily at bedtime; titrate every 1-2 weeks up to maintenance 20 mg to 40 mg PO daily (divided BID or taken as single bedtime dose).\nCatamenial Epilepsy: 10 mg to 20 mg PO daily for 7 to 10 days per menstrual cycle around menses.",
            administration = "Take orally with or without food. Tablets can be split along the scoreline.",
            timing = "Bedtime (or divided BID for higher doses).",
            specialInstructions = "Distinct 1,5-benzodiazepine chemical structure confers significantly less sedation, cognitive blunting, and psychomotor impairment compared to classical 1,4-benzodiazepines (diazepam, clonazepam), making it a favored add-on in school-aged children and working adults.",
            pkPd = "Rapidly and extensively absorbed (~87%). Extensively metabolized in liver by CYP3A4 and CYP2C19 to active metabolite N-desmethylclobazam (half-life 70-80 hours). Parent drug half-life 36-42 hours.",
            renalAdj = "Mild-to-moderate: No adjustment needed. Severe renal impairment: Titrate cautiously.",
            hepaticAdj = "Severe hepatic impairment: Start at 5 mg once daily; titrate slowly.",
            pregnancy = "Category D (Risks of neonatal withdrawal and hypotonia; use lowest effective dose if seizure control requires).",
            lactation = "Excreted into breast milk; monitor infant for sedation and poor feeding.",
            sideEffects = "Somnolence, sedation, fatigue, ataxia, dizziness, drooling (in children with encephalopathy), irritability, tolerance development with prolonged usage.",
            priceNpr = "NPR 70.00 - 130.00 per strip of 10 (5 mg / 10 mg / 20 mg)",
            priceInr = "INR 45.00 - 90.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Frisium", "Sanofi / Medisales Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Cloba", "Intas Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Lobazam", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Frisium", "Sanofi India", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Cloba", "Intas", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Lobazam", "Sun Pharma", "Tablet", "5 mg / 10 mg / 20 mg")
            ),
            adultDose = "10 mg to 20 mg PO once daily at bedtime (max 40 mg/day).",
            childDose = "0.2 to 0.5 mg/kg/day PO in divided doses.",
            contraindications = "Myasthenia gravis, severe respiratory insufficiency, sleep apnea syndrome, severe hepatic impairment, acute narrow-angle glaucoma.",
            modeOfAction = "Positive allosteric modulator of GABA-A receptors, increasing neuronal membrane permeability to chloride ions and hyperpolarizing postsynaptic membranes, producing enhanced inhibitory GABAergic neurotransmission.",
            therapeuticClassTag = "Neurology & Antiepileptics"
        ),

        Drug(
            id = "d_hosp_amitriptyline",
            genericName = "Amitriptyline Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Tricyclic Antidepressant (TCA) & Neuropathic Pain Modulator",
            blackBoxWarning = "SUICIDALITY RISK: Antidepressants increased the risk of suicidal thinking and behavior in children, adolescents, and young adults (under 24 years) in short-term studies.",
            indications = "Diabetic peripheral neuropathic pain, postherpetic neuralgia, and chronic radicular pain; Migraine and chronic tension-type headache prophylaxis; Fibromyalgia and chronic musculoskeletal pain; Major depressive disorder (historical indication).",
            doses = "Neuropathic Pain / Fibromyalgia / Migraine Prophylaxis: Initial 10 mg to 25 mg PO once daily at bedtime; titrate weekly by 10-25 mg up to target 25 mg to 75 mg PO once daily at bedtime (rarely up to 100 mg).\nMajor Depression: 50 mg to 150 mg PO daily in divided doses or bedtime.",
            administration = "Take orally at bedtime with water. Strongly sedating; bedtime administration aids sleep architecture in chronic pain patients.",
            timing = "Bedtime (2-3 hours before sleep).",
            specialInstructions = "Highly toxic in overdose (causes fatal wide-complex ventricular tachyarrhythmias and cardiogenic shock due to fast inward cardiac sodium channel blockade; antidote is IV Sodium Bicarbonate). Screen for cardiac arrhythmias and perform baseline ECG in elderly patients.",
            pkPd = "Well absorbed; peak plasma concentrations at 2-12 hours. Bound to plasma proteins (~95%). Demethylated in liver via CYP2C19/CYP3A4 to active metabolite nortriptyline. Elimination half-life 10-28 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution in hepatic impairment; reduce dose.",
            pregnancy = "Category C (Avoid in 1st trimester; risk of neonatal withdrawal symptoms near term).",
            lactation = "Excreted into breast milk; monitor infant.",
            sideEffects = "Anticholinergic symptoms (dry mouth, constipation, urinary retention, blurred vision, tachycardia), morning grogginess, orthostatic hypotension, weight gain, QT and QRS prolongation.",
            priceNpr = "NPR 35.00 - 70.00 per strip of 10 (10 mg / 25 mg / 50 mg)",
            priceInr = "INR 20.00 - 45.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Tryptomer", "Wockhardt / Medisales Nepal", "Tablet", "10 mg / 25 mg / 50 mg"),
                BrandInfo("Amitryn", "Torrent Nepal", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Amicon", "National Healthcare Nepal", "Tablet", "10 mg / 25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tryptomer", "Wockhardt", "Tablet", "10 mg / 25 mg / 75 mg"),
                BrandInfo("Amitryn", "Torrent", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Eliwel", "Sun Pharma", "Tablet", "10 mg / 25 mg")
            ),
            adultDose = "Neuropathic pain/Migraine: 10-25 mg PO at bedtime, titrate to 50-75 mg.",
            childDose = "Not recommended under 12 years (except specialist enuresis management).",
            contraindications = "Recent myocardial infarction, any degree of heart block or cardiac arrhythmia, severe liver disease, concurrent use of MAOIs (within 14 days), narrow-angle glaucoma.",
            modeOfAction = "Inhibits presynaptic reuptake of serotonin (5-HT) and norepinephrine (NE), enhancing descending inhibitory pain pathways in the spinal cord dorsal horn; also blocks voltage-gated sodium channels, alpha-1 adrenoceptors, and muscarinic receptors.",
            therapeuticClassTag = "Neurology & Neuropathic Pain"
        ),

        // ==========================================
        // ESSENTIAL VITAMINS, COFACTORS & ANTIDOTES
        // ==========================================
        Drug(
            id = "d_hosp_thiamine",
            genericName = "Thiamine Hydrochloride (Vitamin B1)",
            system = "Endocrine & Metabolic",
            drugClass = "Water-Soluble Vitamin & Pyruvate Dehydrogenase Cofactor",
            blackBoxWarning = null,
            indications = "Prophylaxis and emergency treatment of Wernicke-Korsakoff Encephalopathy (acute triad of ataxia, ophthalmoplegia/nystagmus, and acute confusion) in chronic alcohol dependence, severe hyperemesis gravidarum, malnutrition, and prolonged fasting; Refeeding syndrome prophylaxis; Wet beriberi (high-output congestive heart failure) and dry beriberi (polyneuropathy).",
            doses = "Suspected / Manifest Wernicke's Encephalopathy: 500 mg IV infused in 100 mL 0.9% NaCl over 30 minutes three times daily (TID) for 3 to 5 days, followed by 250 mg IV daily for 3-5 days, then oral maintenance 100 mg PO TID.\nProphylaxis in High-Risk Patients: 100 mg to 250 mg IV or IM once daily for 3-5 days.\nBeriberi: Acute wet beriberi: 100 mg IV TID. Mild dry beriberi: 50 mg to 100 mg PO daily.",
            administration = "IV or IM injection, or oral tablets. In emergency room or ward, ALWAYS administer Thiamine BEFORE or CONCURRENT WITH intravenous glucose/dextrose infusions; administering glucose without thiamine precipitates acute fatal Wernicke's encephalopathy due to sudden consumption of remaining thiamine stores by glucose metabolism.",
            timing = "Three times daily in acute encephalopathy.",
            specialInstructions = "Always administer before IV dextrose in malnourished or alcohol-dependent patients. Oral absorption is saturable and poor in active alcoholism; parenteral IV therapy is essential for treatment of acute encephalopathy.",
            pkPd = "Active form is thiamine pyrophosphate (TPP). TPP is an indispensable coenzyme for pyruvate dehydrogenase, alpha-ketoglutarate dehydrogenase, and transketolase. Half-life in body stores is only 9 to 18 days.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category A / Safe; essential in hyperemesis gravidarum to prevent maternal Wernicke's encephalopathy.",
            lactation = "Safe; normal constituent of breast milk.",
            sideEffects = "Local tenderness at IM injection site, warmth, pruritus, urticaria, rare anaphylactoid reaction with rapid IV injection.",
            priceNpr = "NPR 35.00 - 65.00 per ampoule (100 mg/2 mL) / NPR 60.00 per strip of 10 (100 mg tabs)",
            priceInr = "INR 20.00 - 45.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Berin", "GSK / Medisales Nepal", "Inj Ampoule / Tab", "100 mg/mL / 100 mg"),
                BrandInfo("Pabrinex", "Kyowa Kirin Nepal", "IV Injection", "High Potency B & C"),
                BrandInfo("Thiamine", "National Healthcare Nepal", "Inj Ampoule", "100 mg/2 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Berin", "GSK India", "Inj / Tab", "100 mg/mL"),
                BrandInfo("Beneuron", "Franco-Indian", "Tablet", "100 mg"),
                BrandInfo("Thiamine", "Neon Labs", "Inj", "100 mg/mL")
            ),
            adultDose = "Wernicke's: 500 mg IV TID x 3-5 days. Prophylaxis: 100-250 mg IV daily.",
            childDose = "Beriberi: 10-25 mg IV/IM daily.",
            contraindications = "Known hypersensitivity to thiamine formulations.",
            modeOfAction = "Essential cofactor in carbohydrate metabolism; combines with ATP to form thiamine pyrophosphate (TPP), the coenzyme required for the oxidative decarboxylation of alpha-ketoacids in the Krebs cycle and transketolase in the pentose phosphate pathway, generating ATP for cerebral and myocardial cells.",
            therapeuticClassTag = "Critical Care & Antidotes"
        ),

        Drug(
            id = "d_hosp_pyridoxine",
            genericName = "Pyridoxine Hydrochloride (Vitamin B6)",
            system = "Endocrine & Metabolic",
            drugClass = "Water-Soluble Vitamin & Transamination Cofactor",
            blackBoxWarning = null,
            indications = "Prevention and treatment of Isoniazid (INH)-induced peripheral neuropathy during tuberculosis therapy; Specific emergency antidote for acute massive Isoniazid (INH) overdose, Gyromitra (false morel) mushroom poisoning, and hydrazine toxicity; Pyridoxine-dependent infantile epilepsy; Adjunct for hyperemesis gravidarum.",
            doses = "INH Neuropathy Prophylaxis: 10 mg to 25 mg PO once daily (co-prescribed in high-risk patients: diabetics, alcoholics, malnourished, pregnant, HIV, renal failure).\nINH Neuropathy Treatment: 50 mg to 100 mg PO three times daily (150-300 mg/day).\nAcute Isoniazid Overdose (Emergency Antidote): Gram-for-gram replacement: Administer IV pyridoxine gram equivalent to ingested isoniazid (if ingested dose unknown, give 5 g IV over 5-10 minutes; repeat every 5-20 min until status epilepticus resolves).\nHyperemesis Gravidarum: 10 mg to 25 mg PO every 8 hours (with Doxylamine).",
            administration = "Oral tablets for daily prophylaxis. IV push or infusion in emergency INH toxicity.",
            timing = "Once daily with morning anti-TB medication, or stat IV in toxicity.",
            specialInstructions = "Long-term massive doses (>500 mg to 2 g/day for months) can cause paradoxical sensory peripheral neuropathy and ataxia; keep routine prophylactic doses between 10-50 mg daily.",
            pkPd = "Converted in erythrocytes and liver to pyridoxal 5'-phosphate (PLP), the active coenzyme. Tightly bound to albumin. Eliminated in urine as 4-pyridoxic acid.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category A (First-line for pregnancy nausea/vomiting; safe).",
            lactation = "Safe; normal constituent of breast milk.",
            sideEffects = "Sensory neuropathy and ataxia with prolonged megadoses (>500 mg/day for months), somnolence, headache, nausea.",
            priceNpr = "NPR 30.00 - 60.00 per strip of 10 (10 mg / 40 mg / 100 mg)",
            priceInr = "INR 18.00 - 40.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Pyridoxine", "Nepal Pharmaceuticals Lab (NPL)", "Tablet", "10 mg / 40 mg"),
                BrandInfo("Benadon", "Piramal / Medisales Nepal", "Tablet", "40 mg"),
                BrandInfo("B6-Safe", "National Healthcare Nepal", "Tablet", "10 mg / 40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Benadon", "Piramal", "Tablet", "40 mg"),
                BrandInfo("Pyridoxine", "Mankind", "Tablet", "40 mg"),
                BrandInfo("B-Six", "Alkem", "Tablet", "40 mg")
            ),
            adultDose = "INH prophylaxis: 10-25 mg PO daily. INH overdose: Gram-for-gram IV (5 g stat).",
            childDose = "INH prophylaxis: 5-10 mg PO daily. Infantile seizures: 50-100 mg IV stat.",
            contraindications = "Hypersensitivity to pyridoxine.",
            modeOfAction = "Essential cofactor for over 100 enzymes involved in protein and amino acid metabolism, including glutamate decarboxylase (which synthesizes the inhibitory neurotransmitter GABA from glutamate). Isoniazid inactivates pyridoxal 5'-phosphate, depleting GABA and triggering intractable seizures; exogenous pyridoxine bypasses the block and restores GABA.",
            therapeuticClassTag = "Critical Care & Antidotes"
        ),

        // ==========================================
        // TROPICAL MEDICINE & PARASITOLOGY
        // ==========================================
        Drug(
            id = "d_hosp_ivermectin",
            genericName = "Ivermectin",
            system = "Anti-Infective System",
            drugClass = "Avermectin Broad-Spectrum Anthelmintic & Ectoparasiticide",
            blackBoxWarning = null,
            indications = "Crusted (Norwegian) scabies and classical scabies refractory to topical permethrin; Strongyloidiasis (Strongyloides stercoralis); Cutaneous larva migrans; Lymphatic filariasis (microfilaricidal action against Wuchereria bancrofti); Onchocerciasis (river blindness).",
            doses = "Scabies (Classical): 200 mcg/kg (0.2 mg/kg) PO as a single dose with water on an empty stomach; repeat a second dose after 7 to 14 days (second dose targets newly hatched mites).\nCrusted (Norwegian) Scabies: 200 mcg/kg PO on days 1, 2, 8, 9, and 15 (plus topical permethrin and keratolytic cream).\nStrongyloidiasis: 200 mcg/kg PO once daily for 2 consecutive days.\nCutaneous Larva Migrans: 200 mcg/kg PO as a single dose.",
            administration = "Take orally with a full glass of water on an empty stomach (at least 1 hour before or 2 hours after a meal).",
            timing = "Single dose, repeated at 7-14 days for scabies.",
            specialInstructions = "Always treat all household contacts and sexual partners simultaneously to prevent ping-pong re-infection. Screen for Loa loa coinfection in patients from endemic areas before treating, as massive microfilarial lysis can trigger encephalopathy.",
            pkPd = "Well absorbed; peak plasma concentration at 4 hours. Highly lipophilic and extensively distributed. Bound to plasma proteins (~93%). Excreted almost exclusively in feces (>98%) over 12 days.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution in severe hepatic impairment.",
            pregnancy = "Category C (Avoid in first trimester; topical permethrin is preferred during pregnancy).",
            lactation = "Excreted in low concentrations into breast milk; withhold breastfeeding for 24 hours following dose.",
            sideEffects = "Pruritus, rash, Mazzotti-like reaction (fever, headache, arthralgia from dying microfilariae), dizziness, fatigue, nausea, diarrhea.",
            priceNpr = "NPR 60.00 - 110.00 per strip of 2 (6 mg / 12 mg)",
            priceInr = "INR 35.00 - 75.00 per strip of 2",
            brandsNepal = listOf(
                BrandInfo("Iverheal", "Healing Pharma Nepal", "Tablet", "6 mg / 12 mg"),
                BrandInfo("Ivermect", "Sun Pharma Nepal", "Tablet", "6 mg / 12 mg"),
                BrandInfo("Vermact", "Mankind Nepal", "Tablet", "6 mg / 12 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Iverheal", "Healing Pharma", "Tablet", "6 mg / 12 mg"),
                BrandInfo("Vermact", "Mankind", "Tablet", "6 mg / 12 mg"),
                BrandInfo("Ivecop", "Menarini", "Tablet", "6 mg / 12 mg")
            ),
            pediatricDosePerKg = 0.2,
            pediatricInterval = "mg/kg (200 mcg/kg) PO single dose (strictly >=15 kg)",
            adultDose = "200 mcg/kg PO single dose on empty stomach, repeat in 7-14 days for scabies.",
            childDose = "200 mcg/kg single dose (children >= 15 kg body weight).",
            contraindications = "Hypersensitivity; children weighing less than 15 kg; conditions with impaired blood-brain barrier (meningitis, sleeping sickness).",
            modeOfAction = "Binds selectively and with high affinity to glutamate-gated chloride ion channels in invertebrate nerve and muscle cells, increasing chloride permeability, hyperpolarizing cell membranes, and causing flaccid paralysis and death of the parasite.",
            therapeuticClassTag = "Antimicrobials & Antiparasitic"
        ),

        // ==========================================
        // OPHTHALMIC ANTI-INFECTIVES
        // ==========================================
        Drug(
            id = "d_hosp_moxifloxacin_eye",
            genericName = "Moxifloxacin Hydrochloride 0.5% Eye Drops",
            system = "Specialty & Rare",
            drugClass = "Fourth-Generation Fluoroquinolone Ophthalmic Solution",
            blackBoxWarning = null,
            indications = "Acute bacterial conjunctivitis caused by susceptible Gram-positive and Gram-negative organisms; Bacterial keratitis (corneal ulcer); Pre- and post-operative surgical prophylaxis in cataract, vitreoretinal, and refractive eye surgery to prevent endophthalmitis.",
            doses = "Bacterial Conjunctivitis: Instill 1 drop into the affected eye(s) 3 times daily for 7 days.\nBacterial Keratitis (Corneal Ulcer): Instill 1 drop every 15-30 minutes for the first 6 hours, then 1 drop hourly around the clock for 24-48 hours, then taper.\nPost-Cataract Prophylaxis: Instill 1 drop QID starting 1 day before surgery, followed by 1 drop QID for 2 weeks post-operatively.",
            administration = "Tilt head back, pull lower lid down to form a small pocket, instill 1 drop without touching dropper tip to eye or eyelid. Compress nasolacrimal duct at inner canthus for 1-2 minutes to minimize systemic absorption. Remove contact lenses prior to instillation.",
            timing = "Three times daily for conjunctivitis or hourly for corneal ulcer.",
            specialInstructions = "Formulated at near-neutral physiological pH (~6.8) without preservatives (e.g. self-preserved), resulting in significantly less stinging, corneal epitheliotoxicity, and discomfort compared to ciprofloxacin eye drops. Does not cause white corneal precipitates.",
            pkPd = "Excellent ocular penetration across intact corneal epithelium into anterior chamber aqueous humor (aqueous concentrations exceed MIC90 for typical ocular pathogens). Negligible systemic concentration.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Topical ocular absorption is minimal; safe for localized use).",
            lactation = "Safe during breastfeeding.",
            sideEffects = "Transient mild eye irritation, dry eye sensation, subconjunctival hemorrhage (rare), blurred vision, dysgeusia (bitter taste due to nasolacrimal drainage).",
            priceNpr = "NPR 180.00 - 320.00 per bottle (5 mL)",
            priceInr = "INR 120.00 - 210.00 per bottle",
            brandsNepal = listOf(
                BrandInfo("Vigamox", "Alcon / Novartis / Medisales Nepal", "Eye Drops", "0.5% w/v (5 mL)"),
                BrandInfo("Mahaflox", "Mankind Nepal", "Eye Drops", "0.5% w/v (5 mL)"),
                BrandInfo("Moxicip", "Cipla Nepal", "Eye Drops", "0.5% w/v (5 mL)")
            ),
            brandsIndia = listOf(
                BrandInfo("Vigamox", "Alcon India", "Eye Drops", "0.5%"),
                BrandInfo("Mahaflox", "Mankind", "Eye Drops", "0.5%"),
                BrandInfo("Moxicip", "Cipla", "Eye Drops", "0.5%")
            ),
            adultDose = "1 drop into affected eye(s) TID x 7 days.",
            childDose = "1 drop into affected eye(s) TID (safe in infants >1 year).",
            contraindications = "Hypersensitivity to moxifloxacin or other fluoroquinolones.",
            modeOfAction = "Dual inhibition of both topoisomerase II (DNA gyrase) and topoisomerase IV, enzymes required for bacterial DNA replication, transcription, repair, and recombination, producing rapid bactericidal action with low propensity for single-step mutation resistance.",
            therapeuticClassTag = "Ophthalmic & Anti-Infective"
        ),

        Drug(
            id = "d_hosp_tobramycin_dexamethasone_eye",
            genericName = "Tobramycin (0.3%) + Dexamethasone (0.1%) Eye Drops",
            system = "Specialty & Rare",
            drugClass = "Aminoglycoside Antibiotic + Potent Glucocorticoid Ophthalmic Suspension",
            blackBoxWarning = null,
            indications = "Post-operative ocular inflammation and prophylaxis against infection following cataract, glaucoma, or anterior segment surgery; Steroid-responsive inflammatory ocular conditions with concomitant superficial bacterial infection (anterior uveitis, blepharoconjunctivitis, episcleritis).",
            doses = "Post-Surgical / Severe Inflammation: Instill 1 to 2 drops into the conjunctival sac every 2 to 4 hours for the first 24 to 48 hours; taper frequency to 1 drop QID as inflammation subsides (usually over 2-3 weeks).\nMild to Moderate: Instill 1 to 2 drops into affected eye(s) every 4 to 6 hours.",
            administration = "Shake well before using. Apply light pressure to the lacrimal sac at the inner canthus for 1-2 minutes after instillation to reduce systemic absorption. Do not touch dropper tip to eye or eyelids.",
            timing = "Every 4-6 hours or QID, tapered over 2-3 weeks.",
            specialInstructions = "Prolonged use (>10-14 days) can cause ocular hypertension, secondary open-angle glaucoma with optic nerve damage, posterior subcapsular cataract formation, and delayed wound healing. Monitor intraocular pressure (IOP) if therapy extends beyond 10 days.",
            pkPd = "Dexamethasone penetrates cornea into anterior chamber; tobramycin achieves high bactericidal concentrations in corneal tissue and conjunctival fluid. Systemic absorption is minimal.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Use only if potential benefit justifies potential risk).",
            lactation = "Use with caution.",
            sideEffects = "Elevated intraocular pressure, delayed corneal epithelial healing, secondary fungal or viral corneal infections, local stinging/itching, blurred vision.",
            priceNpr = "NPR 190.00 - 350.00 per bottle (5 mL)",
            priceInr = "INR 130.00 - 240.00 per bottle",
            brandsNepal = listOf(
                BrandInfo("Tobradex", "Alcon / Novartis / Medisales Nepal", "Eye Drops", "0.3% / 0.1% (5 mL)"),
                BrandInfo("Tobram-D", "Sun Pharma Nepal", "Eye Drops", "5 mL"),
                BrandInfo("Toba-DM", "Cipla Nepal", "Eye Drops", "5 mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Tobradex", "Alcon India", "Eye Drops", "5 mL"),
                BrandInfo("Tobram-D", "Sun Pharma", "Eye Drops", "5 mL"),
                BrandInfo("Toba-DM", "Cipla", "Eye Drops", "5 mL")
            ),
            adultDose = "1-2 drops into affected eye(s) every 4-6 hours, tapered as inflammation resolves.",
            childDose = "Safe in children >2 years at 1 drop QID for limited duration.",
            contraindications = "Viral diseases of the cornea and conjunctiva (herpes simplex epithelial keratitis, vaccinia, varicella); fungal diseases of the eye; mycobacterial eye infections; untreated purulent infections.",
            modeOfAction = "Tobramycin irreversibly binds to the bacterial 30S ribosomal subunit, causing misreading of genetic code and inhibiting protein synthesis (bactericidal against Pseudomonas and Staphylococci); Dexamethasone suppresses inflammation by inhibiting phospholipase A2, reducing capillary dilation, leukocytic infiltration, and fibroblast proliferation.",
            therapeuticClassTag = "Ophthalmic & Anti-Inflammatory"
        )
    )
}
