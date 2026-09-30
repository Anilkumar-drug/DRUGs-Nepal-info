package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object SpecialtyDrugsCardioMetabolic {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // 1. ANTI-HTN (ANTIHYPERTENSIVE AGENTS)
        // ==========================================

        // --- OLDER / CLASSICAL ANTI-HTN ---
        Drug(
            id = "d_htn_reserpine",
            genericName = "Reserpine",
            system = "Cardiovascular System (CVS)",
            drugClass = "Antihypertensive (Vesicular Monoamine Transporter / VMAT Inhibitor - Rauwolfia Alkaloid)",
            era = "Older / Classical",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Classical 1st-generation Rauwolfia serpentina alkaloid (1950s). Historic cornerstone of early VA Cooperative studies; largely replaced by modern ARBs/CCBs due to central depressive and cholinergic side effects.",
            blackBoxWarning = "SEVERE DEPRESSION & SUICIDALITY: Reserpine can induce severe psychiatric depression and suicidal ideation, which may persist for months after drug withdrawal. Contraindicated in active depression or peptic ulcer disease.",
            indications = "Essential hypertension (refractory cases / historical regimens), agitated psychotic states (historical).",
            doses = "Adult: 0.1 mg to 0.25 mg PO once daily with or after meals. Maximum dose 0.5 mg daily.",
            adultDose = "0.1 - 0.25 mg PO once daily",
            childDose = "Not recommended in pediatric practice.",
            administration = "Take orally with food or milk to reduce gastric irritation.",
            timing = "Morning or bedtime with food.",
            specialInstructions = "Monitor for depressive symptoms, nightmares, and bradycardia. Discontinue at least 2 weeks prior to elective surgery due to altered hemodynamic response to anesthesia.",
            pkPd = "Irreversibly inhibits VMAT-1 and VMAT-2, depleting norepinephrine, dopamine, and serotonin from central and peripheral sympathetic nerve terminals. Onset of action: slow (takes days to weeks). Half-life: 33-168 hours.",
            renalAdj = "CrCl <50 mL/min: Reduce dose by 50% or avoid. Cumulative toxicity risk.",
            hepaticAdj = "Use with extreme caution. Severe impairment contraindicated.",
            pregnancy = "Category D (Fetal respiratory depression, hypothermia, nasal congestion reported).",
            lactation = "Contraindicated; excreted in breast milk causing infant nasal obstruction and bradycardia.",
            sideEffects = "Severe mental depression, nasal stuffiness, drowsiness, bradycardia, peptic ulcer activation, diarrhea, erectile dysfunction.",
            priceNpr = "NPR 4.00 - 8.00 per tab (0.25mg)",
            priceInr = "INR 3.00 - 6.00 per tab (0.25mg)",
            brandsNepal = listOf(
                BrandInfo("Serpasil", "Novartis / Regional", "Tablet", "0.25 mg"),
                BrandInfo("Reserpine-Gen", "Himalaya Drug / Classical", "Tablet", "0.1 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Serpasil", "Novartis India", "Tablet", "0.25 mg"),
                BrandInfo("Adelphane-Esidrex (Comb)", "Novartis India", "Tablet", "0.1 mg Reserpine + 10mg Dihydralazine")
            ),
            contraindications = "Active clinical depression, history of suicide attempts, active peptic ulcer disease, ulcerative colitis, concurrent MAO inhibitors.",
            modeOfAction = "Vesicular monoamine transporter (VMAT-2) blocker preventing vesicle storage of catecholamines, leading to cytosolic degradation and depletion of peripheral vascular tone.",
            interactions = "MAO inhibitors (hypertensive crisis), Digoxin (severe bradycardia/arrhythmias), CNS depressants/alcohol (potentiated sedation).",
            packSize = "Strip of 10 tablets",
            counselingNepali = "यो उच्च रक्तचापको पुरानो औषधि हो। यसले उदासी (डिप्रेशन) वा नाक बन्द हुने समस्या गराउन सक्छ। मन निराश भएमा तुरुन्त डाक्टरलाई देखाउनुहोस्।",
            counselingEnglish = "Take with meals once daily. Report any mood changes, persistent sadness, or severe drowsiness immediately."
        ),

        Drug(
            id = "d_htn_methyldopa",
            genericName = "Methyldopa",
            system = "Cardiovascular System (CVS)",
            drugClass = "Antihypertensive (Centrally Acting Alpha-2 Adrenergic Agonist)",
            era = "Older / Classical",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Classical anti-HTN agent introduced in 1960. Global gold standard for chronic and gestational hypertension in pregnancy with over 50 years of proven fetal safety data.",
            indications = "Chronic hypertension in pregnancy, gestational hypertension, pre-eclampsia management; refractory essential hypertension.",
            doses = "Adult: Initial 250 mg PO BID or TID; maintenance 500 mg - 2000 mg/day in 2 to 4 divided doses. Maximum: 3000 mg/day.",
            adultDose = "250 - 500 mg PO BID or TID (Max 3 g/day)",
            childDose = "Initial 10 mg/kg/day in 2-4 divided doses; maximum 65 mg/kg/day.",
            administration = "Take orally with or without food. Increase evening dose first to minimize daytime sedation.",
            timing = "Evenly spaced throughout the day.",
            specialInstructions = "Perform baseline and periodic Direct Coombs Test (positive in 10-20% of patients) and liver function tests (LFTs) at 6-10 weeks.",
            pkPd = "Metabolized to alpha-methylnorepinephrine in brain, stimulating central alpha-2 adrenergic receptors and reducing sympathetic outflow to heart and peripheral vasculature. Half-life ~2h, biological effect ~24h.",
            renalAdj = "CrCl 10-50 mL/min: Administer q8-12h. CrCl <10 mL/min: Administer q12-24h. Post-hemodialysis supplemental dose.",
            hepaticAdj = "CONTRAINDICATED in active hepatic disease (acute hepatitis, active cirrhosis).",
            pregnancy = "Category B (Standard first-line drug of choice in pregnancy).",
            lactation = "Compatible with breastfeeding; present in low concentrations in breast milk (AAP approved).",
            sideEffects = "Sedation, dry mouth, positive Coombs test, drug-induced autoimmune hemolytic anemia, drug fever, drug-induced hepatitis, orthostatic hypotension.",
            priceNpr = "NPR 12.00 - 18.00 per tab (250mg)",
            priceInr = "INR 8.00 - 14.00 per tab (250mg)",
            brandsNepal = listOf(
                BrandInfo("Dopagyt", "Egis Pharmaceuticals / Nepal", "Tablet", "250 mg"),
                BrandInfo("Alphadopa", "Wockhardt / Medisales", "Tablet", "250 mg / 500 mg"),
                BrandInfo("M-Dopa", "Deurali-Janta Pharmaceuticals", "Tablet", "250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Alphadopa", "Wockhardt Ltd.", "Tablet", "250 mg / 500 mg"),
                BrandInfo("Dopagyt", "Egis India", "Tablet", "250 mg"),
                BrandInfo("Medopa", "Micro Labs", "Tablet", "250 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg/kg/day in 2-4 divided doses",
            contraindications = "Active liver disease, history of methyldopa-induced liver injury or hemolytic anemia, pheochromocytoma, co-administration with MAOIs.",
            modeOfAction = "Centrally acting alpha-2 agonist: prodrug metabolized to alpha-methylnorepinephrine, dampening sympathetic vasoconstrictor tone.",
            interactions = "Iron supplements (significantly chelate and reduce methyldopa absorption by 50-70%; separate by 3 hours), Levodopa (worsens Parkinsonism), MAOIs.",
            packSize = "Strip of 10 tablets",
            counselingNepali = "यो गर्भवती महिलाहरूमा उच्च रक्तचाप नियन्त्रण गर्ने सबैभन्दा सुरक्षित औषधि हो। यसले सुरुका दिनमा अलि झुम गराउन सक्छ। आइरन चक्की र यो सँगै नखानुहोस्।",
            counselingEnglish = "Gold standard for pregnancy hypertension. Take consistently. Avoid taking iron tablets at the exact same time as methyldopa."
        ),

        Drug(
            id = "d_htn_clonidine",
            genericName = "Clonidine Hydrochloride",
            system = "Cardiovascular System (CVS)",
            drugClass = "Centrally Acting Alpha-2 Adrenergic Agonist & Imidazoline Receptor Agonist",
            era = "Older / Classical",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Classical central imidazoline/alpha-2 agonist. Potent oral agent for hypertensive urgency and opioid withdrawal; requires strict caution regarding rebound hypertensive crisis if abruptly withdrawn.",
            blackBoxWarning = "REBOUND HYPERTENSIVE CRISIS: Abrupt discontinuation can trigger life-threatening sympathetic overactivity, severe rebound hypertension, tremors, and tachycardia. Taper gradually over 2 to 4 days.",
            indications = "Hypertensive urgency (oral loading protocol), resistant hypertension, opioid withdrawal syndrome, Tourette syndrome, ADHD (adjunct).",
            doses = "Urgency: 0.1 mg to 0.2 mg PO stat, then 0.1 mg hourly until BP controlled (max 0.6 mg). Maintenance: 0.1 to 0.3 mg PO BID (max 2.4 mg/day).",
            adultDose = "0.1 - 0.3 mg PO BID (Urgency loading: 0.1-0.2 mg stat)",
            childDose = "5 - 10 mcg/kg/day divided q8-12h (max 0.9 mg/day).",
            administration = "Oral tablet taken with or without food. Never stop abruptly.",
            timing = "Twice daily, taking the larger dose at bedtime to lessen daytime somnolence.",
            specialInstructions = "Always maintain an emergency refill. If patient is on concurrent beta-blocker, discontinue beta-blocker first several days BEFORE stopping clonidine.",
            pkPd = "Selectively stimulates post-synaptic alpha-2 adrenergic receptors and I1 imidazoline receptors in medulla. Bioavailability 75-95%. Peak effect 1-3h. Elimination half-life 12-16 hours.",
            renalAdj = "CrCl <10 mL/min: Initial 0.1 mg daily, titrate carefully. Minimally removed by hemodialysis.",
            hepaticAdj = "No specific dose adjustments provided; monitor sedation.",
            pregnancy = "Category C (Crosses placenta; reserve for when other agents fail).",
            lactation = "Excreted into breast milk; monitor infant for lethargy, hypotension, and bradycardia.",
            sideEffects = "Marked sedation, severe dry mouth, constipation, orthostatic hypotension, bradycardia, rebound hypertension upon sudden cessation.",
            priceNpr = "NPR 3.50 - 6.50 per tab (100mcg)",
            priceInr = "INR 2.50 - 4.50 per tab (100mcg)",
            brandsNepal = listOf(
                BrandInfo("Arkamin", "Torrent Pharmaceuticals Nepal", "Tablet", "100 mcg"),
                BrandInfo("Catapres", "Boehringer / Regional", "Tablet", "150 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Arkamin", "Torrent Pharmaceuticals", "Tablet", "100 mcg"),
                BrandInfo("Cloneon", "Neon Laboratories", "Tablet / Inj", "100 mcg / 150 mcg/mL"),
                BrandInfo("Catapres", "Zydus Healthcare", "Tablet", "150 mcg")
            ),
            contraindications = "Severe bradyarrhythmias, second- or third-degree AV block, sinus node disease.",
            modeOfAction = "Centrally reduces sympathetic vasomotor tone by agonism at alpha-2 and imidazoline-1 receptors in the nucleus tractus solitarius.",
            interactions = "Beta-blockers (paradoxical severe hypertension upon withdrawal), Tricyclic antidepressants (blunts hypotensive effect), CNS depressants.",
            packSize = "Strip of 10 or 30 tablets",
            counselingNepali = "यो रक्तचाप अचानक बढेको बेला चाँडो घटाउने औषधि हो। यो औषधि कहिल्यै पनि आफै अचानक बन्द नगर्नुहोस्, नत्र रक्तचाप खतरा हुने गरी बढ्न सक्छ।",
            counselingEnglish = "Never stop this medication abruptly due to dangerous rebound hypertension risk. May cause dry mouth and drowsiness."
        ),

        Drug(
            id = "d_htn_hydralazine",
            genericName = "Hydralazine Hydrochloride",
            system = "Cardiovascular System (CVS)",
            drugClass = "Antihypertensive (Direct-Acting Arteriolar Vasodilator)",
            era = "Older / Classical",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Classical direct arteriolar vasodilator (1950s). Landmark combination with isosorbide dinitrate (BiDil) demonstrated mortality benefit in African American heart failure trials (A-HeFT).",
            indications = "Severe refractory hypertension, acute hypertensive emergency in pregnancy (preeclampsia/eclampsia), heart failure with reduced ejection fraction (in combination with nitrates).",
            doses = "Oral: Initial 10 mg PO QID for 2-4 days, increased to 25 mg QID and then 50 mg QID (max 300 mg/day). IV (Preeclampsia): 5-10 mg IV slow bolus over 2 min, repeat q20-30m prn.",
            adultDose = "25 - 50 mg PO QID (or 5-10 mg IV slow push for severe preeclampsia)",
            childDose = "0.75 mg/kg/day divided in 4 doses; increase up to 7.5 mg/kg/day.",
            administration = "Take consistently with food to enhance systemic bioavailability.",
            timing = "Four times daily with meals and bedtime snack.",
            specialInstructions = "Co-prescribe with a beta-blocker to prevent compensatory reflex tachycardia, and a loop diuretic to mitigate fluid retention. Slow acetylators are at high risk of drug-induced lupus.",
            pkPd = "Directly relaxes vascular smooth muscle primarily in arterial precapillary resistance vessels with minimal effect on venous capacitance. Bioavailability 30-50% (higher in slow acetylators). Half-life 2-8h.",
            renalAdj = "CrCl 10-50 mL/min: Administer q8h. CrCl <10 mL/min: Administer q8-16h.",
            hepaticAdj = "Reduce dose by 50% in cirrhosis or severe dysfunction (extensive first-pass hepatic metabolism).",
            pregnancy = "Category C (Extensively utilized for acute preeclampsia crisis with decades of clinical experience).",
            lactation = "Excreted into breast milk in tiny amounts; compatible with breastfeeding.",
            sideEffects = "Drug-induced Systemic Lupus Erythematosus (DILE) with antinuclear antibodies (ANA+), reflex tachycardia, palpitations, headache, fluid retention, angina pectoris.",
            priceNpr = "NPR 8.00 - 15.00 per tab (25mg)",
            priceInr = "INR 6.00 - 11.00 per tab (25mg)",
            brandsNepal = listOf(
                BrandInfo("Aprez", "Sun Pharma Nepal", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Hydral", "Nepal Pharmaceuticals", "Tablet", "25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Aprez", "Sun Pharmaceutical Industries", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Hydral", "Cadila Pharmaceuticals", "Tablet", "25 mg"),
                BrandInfo("Nepresol", "Novartis India", "Inj / Tab", "20 mg/mL Inj / 25 mg")
            ),
            contraindications = "Coronary artery disease, mitral valvular rheumatic heart disease, dissecting aortic aneurysm, active systemic lupus erythematosus.",
            modeOfAction = "Opens potassium channels and inhibits inositol trisphosphate (IP3)-induced calcium release from sarcoplasmic reticulum in arteriolar smooth muscle.",
            interactions = "Other vasodilators/nitrates (profound hypotension), MAOIs, NSAIDs (blunt antihypertensive response).",
            packSize = "Strip of 10 tablets",
            counselingNepali = "यो नसालाई फुलाएर रक्तचाप घटाउने औषधि हो। मुटुको धड्कन बढ्न सक्छ। जोर्नी दुख्ने वा छालामा रातो दाग देखिएमा तुरुन्त डाक्टरलाई देखाउनुहोस्।",
            counselingEnglish = "Take with meals. Report persistent fever, joint pains, chest palpitations, or facial rash promptly."
        ),

        // --- NEWER / MODERN FIRST-LINE ANTI-HTN ---
        Drug(
            id = "d_htn_telmisartan",
            genericName = "Telmisartan",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin II Receptor Blocker (ARB) & Partial PPAR-gamma Agonist",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Modern high-affinity ARB with the longest half-life (~24 hours) in class and unique partial PPAR-gamma agonism providing metabolic benefits (ONTARGET trial proven cardiovascular protection).",
            blackBoxWarning = "FETAL TOXICITY: Drugs that act directly on the renin-angiotensin system can cause serious fetal harm, oligohydramnios, neonatal renal failure, skull hypoplasia, and death. Discontinue immediately upon pregnancy confirmation.",
            indications = "Essential hypertension (first-line), cardiovascular risk reduction in patients unable to take ACE inhibitors, diabetic nephropathy.",
            doses = "Hypertension: 40 mg to 80 mg PO once daily. Cardiovascular risk reduction: 80 mg PO once daily.",
            adultDose = "40 - 80 mg PO once daily",
            childDose = "Safety and efficacy not established in children <18 years.",
            administration = "Oral tablet taken once daily with or without food.",
            timing = "Morning or evening, at the same time each day.",
            specialInstructions = "Keep tablets in original blister pack until immediately before ingestion due to hygroscopic nature.",
            pkPd = "Potent selective AT1 receptor antagonist with dissociation half-life of 24h. Highly lipophilic with 99.5% protein binding. Virtually 100% biliary/fecal elimination with zero renal dependence.",
            renalAdj = "No initial dose adjustment required in mild to severe renal impairment or hemodialysis.",
            hepaticAdj = "Mild to moderate hepatic impairment: Do not exceed 40 mg once daily. Severe cirrhosis: Contraindicated.",
            pregnancy = "Category D (Contraindicated in 2nd and 3rd trimesters; stop immediately when pregnant).",
            lactation = "Contraindicated; potential for adverse effects on nursing infant.",
            sideEffects = "Dizziness, hyperkalemia, back pain, sinusitis, orthostasis; very low incidence of dry cough compared to ACE inhibitors.",
            priceNpr = "NPR 14.00 - 24.00 per tab (40mg)",
            priceInr = "INR 9.00 - 18.00 per tab (40mg)",
            brandsNepal = listOf(
                BrandInfo("Telma", "Glenmark Nepal", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Telsar", "Unichem / Nepal", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Telpres", "Abbott Nepal", "Tablet", "40 mg"),
                BrandInfo("Telmikaa", "Mankind Nepal", "Tablet", "40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Telma", "Glenmark Pharmaceuticals", "Tablet", "20 mg / 40 mg / 80 mg"),
                BrandInfo("Telmikind", "Mankind Pharma", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Telsar", "Unichem Laboratories", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Micardis", "Boehringer Ingelheim India", "Tablet", "40 mg / 80 mg")
            ),
            contraindications = "Pregnancy, biliary obstructive disorders, severe hepatic impairment, concurrent aliskiren in patients with diabetes.",
            modeOfAction = "Selectively blocks angiotensin II from binding to the AT1 receptor subtype in vascular smooth muscle and adrenal cortex; partial PPAR-gamma agonist enhancing insulin sensitivity.",
            interactions = "Potassium supplements and potassium-sparing diuretics (hyperkalemia risk), Lithium (increased serum lithium concentrations), NSAIDs (worsens renal function).",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो रक्तचाप नियन्त्रण गर्ने आधुनिक र लामो समय काम गर्ने औषधि हो। दिनको एक पटक नियमित खानुहोस्। गर्भवती महिलाले यो औषधि कदापि खानुहुँदैन।",
            counselingEnglish = "Take once daily with or without food. Do not use during pregnancy. Keep tablets in blister until ingestion."
        ),

        Drug(
            id = "d_htn_cilnidipine",
            genericName = "Cilnidipine",
            system = "Cardiovascular System (CVS)",
            drugClass = "4th-Generation Dihydropyridine Calcium Channel Blocker (Dual L-type and N-type Blocker)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Novel dual L/N-type calcium channel blocker widely adopted across Asia. Unlike pure L-type CCBs (amlodipine), N-type blockade inhibits sympathetic renal nerves, dilating both afferent and efferent arterioles to significantly reduce pedal edema and proteinuria.",
            indications = "Essential hypertension, hypertension with microalbuminuria or diabetic kidney disease, hypertension with sympathetic overdrive / tachycardia.",
            doses = "Initial: 5 mg to 10 mg PO once daily after breakfast; can be increased to 20 mg PO once daily.",
            adultDose = "5 - 20 mg PO once daily after breakfast",
            childDose = "Safety and efficacy not established in pediatric population.",
            administration = "Take orally once daily in the morning after breakfast.",
            timing = "Morning with or after breakfast.",
            specialInstructions = "Ideal for patients who developed intractable ankle edema on amlodipine. Does not cause reflex tachycardia.",
            pkPd = "Dual blockade of voltage-dependent L-type and neuronal N-type calcium channels. Blocks norepinephrine release from sympathetic nerve endings. Bioavailability ~13%. Highly lipophilic.",
            renalAdj = "No dose adjustment required in mild to severe renal impairment. Renoprotective.",
            hepaticAdj = "Use with caution in severe hepatic dysfunction; titrate slowly.",
            pregnancy = "Contraindicated / Category C. Insufficient human data; avoid in pregnancy.",
            lactation = "Avoid; animal studies show excretion in breast milk.",
            sideEffects = "Dizziness, flushing, headache, mild gingival hyperplasia, nausea; dramatically lower incidence of pedal edema than amlodipine.",
            priceNpr = "NPR 12.00 - 22.00 per tab (10mg)",
            priceInr = "INR 8.00 - 16.00 per tab (10mg)",
            brandsNepal = listOf(
                BrandInfo("Cilacar", "J.B. Chemicals Nepal", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Nexovas", "Macleods Nepal", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Cilny", "Intas Nepal", "Tablet", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Cilacar", "J.B. Chemicals & Pharmaceuticals", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Nexovas", "Macleods Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Cilny", "Intas Pharmaceuticals", "Tablet", "10 mg"),
                BrandInfo("Twincal", "Zydus Healthcare", "Tablet", "10 mg")
            ),
            contraindications = "Severe cardiogenic shock, severe aortic stenosis, unstable angina.",
            modeOfAction = "Blocks L-type Ca2+ channels on vascular smooth muscle and N-type Ca2+ channels at sympathetic nerve terminals, attenuating reflex tachycardia and efferent arteriolar constriction.",
            interactions = "CYP3A4 inhibitors (Ketoconazole, Clarithromycin) increase levels; Digoxin (minor increase in levels).",
            packSize = "Strip of 10 or 15 tablets",
            counselingNepali = "यो नयाँ पुस्ताको क्याल्सियम ब्लकर हो। यसले एम्लोडिपिन जस्तो खुट्टा सुन्निने समस्या निकै कम गराउँछ र मृगौलालाई बचाउँछ। बिहान खाजा खाएपछि खानुहोस्।",
            counselingEnglish = "Take once daily after breakfast. Superior protection against ankle swelling and kidney protein leakage compared to older CCBs."
        ),

        Drug(
            id = "d_htn_sacubitril_valsartan",
            genericName = "Sacubitril + Valsartan (ARNI)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Angiotensin Receptor-Neprilysin Inhibitor (ARNI)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Breakthrough ARNI molecule (PARADIGM-HF and PARAMOUNT trials). Superior to enalapril in reducing cardiovascular death and heart failure hospitalizations by 20%; now standard first-line guideline therapy for HFrEF and resistant HTN with HF.",
            blackBoxWarning = "FETAL TOXICITY: Causes severe fetal harm, oligohydramnios, and neonatal renal failure during pregnancy. Contraindicated with ACE inhibitors (mandatory 36-hour washout to prevent life-threatening angioedema).",
            indications = "Heart failure with reduced ejection fraction (NYHA II-IV), heart failure with preserved ejection fraction (HFpEF), essential hypertension with left ventricular remodeling.",
            doses = "Initial: 24/26 mg (50mg) or 49/51 mg (100mg) PO BID. Titrate every 2-4 weeks to target maintenance dose of 97/103 mg (200mg) PO BID.",
            adultDose = "49/51 mg PO BID, titrated to 97/103 mg PO BID",
            childDose = "Pediatric HF (≥1 year): Weight-tiered dosing from 1.6 mg/kg BID to 3.1 mg/kg BID.",
            administration = "Oral tablet taken twice daily with or without food.",
            timing = "Morning and evening, approximately 12 hours apart.",
            specialInstructions = "MANDATORY 36-HOUR WASHOUT: Allow at least 36 hours between switching from an ACE inhibitor to prevent angioedema.",
            pkPd = "Sacubitril is a prodrug metabolized to LBQ657, which inhibits neprilysin (increasing natriuretic peptides ANP/BNP, bradykinin, and adrenomedullin). Valsartan selectively blocks AT1 receptors.",
            renalAdj = "eGFR ≥30: No initial change. eGFR <30 mL/min/1.73m²: Start at 24/26 mg PO BID. Monitor potassium and creatinine.",
            hepaticAdj = "Moderate impairment (Child-Pugh B): Start at 24/26 mg PO BID. Severe impairment (Child-Pugh C): Contraindicated.",
            pregnancy = "Category D / Contraindicated in pregnancy.",
            lactation = "Contraindicated; discontinue drug or nursing.",
            sideEffects = "Hypotension, hyperkalemia, cough, elevated serum creatinine, angioedema (higher in African Americans).",
            priceNpr = "NPR 45.00 - 85.00 per tab (100mg)",
            priceInr = "INR 28.00 - 55.00 per tab (100mg)",
            brandsNepal = listOf(
                BrandInfo("Vymada", "Novartis Nepal", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Azmarda", "Cipla Nepal", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Cidmus", "Lupin Nepal", "Tablet", "50 mg / 100 mg / 200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Vymada", "Novartis India", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Azmarda", "Cipla Ltd.", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Cidmus", "Lupin Ltd.", "Tablet", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Valazest", "Sun Pharma", "Tablet", "50 mg / 100 mg / 200 mg")
            ),
            contraindications = "Concurrent use with ACE inhibitors (must wait 36 hours); history of angioedema related to ACEI/ARB therapy; aliskiren in diabetes; pregnancy.",
            modeOfAction = "Dual inhibition: Neprilysin inhibition augments endogenous vasoactive peptides; AT1 receptor blockade prevents angiotensin II-mediated vasoconstriction and aldosterone release.",
            interactions = "ACE inhibitors (high risk of fatal angioedema), Potassium-sparing diuretics (spironolactone), NSAIDs, Lithium.",
            packSize = "Blister pack of 14 or 28 tablets",
            counselingNepali = "यो मुटु कमजोर भएको र उच्च रक्तचाप भएका बिरामीहरूका लागि आधुनिक वरदान जस्तै औषधि हो। दिनको २ पटक खानुहोस्। यो सुरु गर्नुअघि पुराना प्रेसरका औषधि बन्द गरेको ३६ घण्टा हुनुपर्छ।",
            counselingEnglish = "Take twice daily. Must maintain 36-hour gap if switching from ACE inhibitors. Periodic potassium and kidney tests required."
        ),

        Drug(
            id = "d_htn_finerenone",
            genericName = "Finerenone",
            system = "Cardiovascular System (CVS)",
            drugClass = "Non-Steroidal Selective Mineralocorticoid Receptor Antagonist (MRA)",
            era = "Newer / Modern",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "Novel non-steroidal selective MRA approved based on landmark FIDELIO-DKD and FIGARO-DKD trials. Exhibits far greater selectivity for mineralocorticoid receptors than spironolactone without endocrine side effects (zero gynecomastia), and lower hyperkalemia risk than eplerenone.",
            indications = "Chronic Kidney Disease (CKD stage 3-4 with albuminuria) associated with Type 2 Diabetes; resistant hypertension with albuminuria; heart failure (FINEARTS-HF).",
            doses = "Initial dose based on eGFR: eGFR ≥60 mL/min/1.73m²: 20 mg PO once daily. eGFR 25 to <60 mL/min/1.73m²: 10 mg PO once daily. Titrate to 20 mg after 4 weeks if serum K+ ≤4.8 mEq/L.",
            adultDose = "10 - 20 mg PO once daily based on eGFR and potassium",
            childDose = "Not established in pediatric patients.",
            administration = "Take orally once daily with or without food. Can be crushed and mixed with water or soft food.",
            timing = "Once daily, morning or evening.",
            specialInstructions = "Check baseline serum potassium and eGFR. Do not initiate if serum potassium >5.0 mEq/L. Recheck K+ at 4 weeks and periodically.",
            pkPd = "Non-steroidal antagonist that binds bulky mineralocorticoid receptors with high selectivity, blocking inflammation and fibrosis. Rapidly absorbed with tmax 0.5-1.25h. Half-life 2-3 hours. Hepatically metabolized by CYP3A4.",
            renalAdj = "eGFR <25 mL/min/1.73m²: Do not initiate. If already on drug, continue unless potassium >5.5 mEq/L.",
            hepaticAdj = "Moderate impairment (Child-Pugh B): Monitor potassium closely. Severe impairment (Child-Pugh C): Avoid use.",
            pregnancy = "Avoid; animal data shows reproductive toxicity.",
            lactation = "Breastfeeding not recommended during treatment and for 1 day after final dose.",
            sideEffects = "Hyperkalemia (8-18%), hypotension, hyponatremia; does NOT cause gynecomastia, breast tenderness, or impotence.",
            priceNpr = "NPR 65.00 - 110.00 per tab (10mg)",
            priceInr = "INR 38.00 - 68.00 per tab (10mg)",
            brandsNepal = listOf(
                BrandInfo("Kerendia", "Bayer Nepal / Regional", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Finerone", "Glenmark Nepal", "Tablet", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Kerendia", "Bayer India", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Fineron", "Sun Pharma", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Finenta", "Dr. Reddy's Laboratories", "Tablet", "10 mg / 20 mg")
            ),
            contraindications = "Concomitant treatment with strong CYP3A4 inhibitors (Itraconazole, Clarithromycin), adrenal insufficiency, baseline serum potassium >5.0 mEq/L.",
            modeOfAction = "Selectively blocks mineralocorticoid receptor overactivation, inhibiting sodium reabsorption, cardiac and renal inflammation, endothelial dysfunction, and interstitial fibrosis.",
            interactions = "Strong CYP3A4 inhibitors (contraindicated), Grapefruit juice, Potassium-sparing diuretics and supplements (hyperkalemia risk).",
            packSize = "Strip of 14 or 28 tablets",
            counselingNepali = "यो चिनी रोग र मृगौलाको समस्या भएका बिरामीहरूमा मुटु र मृगौला बचाउने आधुनिक औषधि हो। यसले स्तन सुन्निने समस्या गराउँदैन। रगतमा पोटासियम नियमित जचाउनुहोस्।",
            counselingEnglish = "Take once daily. Renoprotective without male hormonal side effects. Routine blood potassium monitoring is necessary."
        ),

        // --- UNDER RESEARCH / PIPELINE ANTI-HTN ---
        Drug(
            id = "d_htn_zilebesiran",
            genericName = "Zilebesiran (ALN-AGT)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Investigational RNA Interference (siRNA) Therapeutic Targeting Hepatic Angiotensinogen",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "INVESTIGATIONAL BREAKTHROUGH: Subcutaneously administered N-acetylgalactosamine (GalNAc)-conjugated small interfering RNA (siRNA) that selectively degrades hepatic angiotensinogen mRNA. Phase II KARDIA-1 and KARDIA-2 clinical trials demonstrate sustained, dose-dependent >90% reduction in circulating AGT and sustained 24-hour ambulatory blood pressure reduction lasting 6 full months after a single injection!",
            indications = "Under investigation for mild-to-moderate and treatment-resistant hypertension with biannual or quarterly subcutaneous dosing.",
            doses = "Clinical Trial Protocols: 150 mg, 300 mg, or 600 mg administered by subcutaneous (SC) injection once every 3 months or once every 6 months.",
            adultDose = "Investigational: 300 mg - 600 mg Subcutaneous every 6 months",
            childDose = "Not evaluated in pediatric populations.",
            administration = "Subcutaneous injection in abdomen or upper thigh administered by a healthcare professional.",
            timing = "Single injection every 6 months (biannual).",
            specialInstructions = "Investigational pipeline agent. In clinical trials, blood pressure reductions persisted continuously through 24 weeks with preserved diurnal rhythm.",
            pkPd = "Targeted delivery to hepatocytes via asialoglycoprotein receptor (ASGPR) mediated by GalNAc moiety. Cleaves angiotensinogen mRNA via RNA-induced silencing complex (RISC), shutting down the top of the RAAS cascade. Long tissue half-life in liver.",
            renalAdj = "Under evaluation in CKD trials; no hepatic/renal clearance restrictions observed in Phase II.",
            hepaticAdj = "Under study. Liver function transaminases monitored in KARDIA trials.",
            pregnancy = "Contraindicated; interference with embryonic RAAS causes severe teratogenicity.",
            lactation = "Not studied; avoid.",
            sideEffects = "Mild injection site reactions, transient orthostatic lightheadedness, hyperkalemia (low incidence in Phase II), mild transient ALT elevations.",
            priceNpr = "Under Research / Pipeline (Clinical Trial Access)",
            priceInr = "Under Research / Pipeline (Phase II/III Trial)",
            brandsNepal = listOf(
                BrandInfo("Zilebesiran (Investigational)", "Alnylam / Roche Pipeline", "SC Solution", "300 mg / mL")
            ),
            brandsIndia = listOf(
                BrandInfo("ALN-AGT (Trial)", "Alnylam / Roche Clinical Studies", "Prefilled Syringe", "300 mg")
            ),
            contraindications = "Pregnancy, known hypersensitivity to GalNAc-siRNA conjugates.",
            modeOfAction = "Catalytic degradation of angiotensinogen mRNA in hepatocytes using RNA interference, suppressing production of angiotensin I and II at the source for up to 6 months.",
            interactions = "Can be safely co-administered with amlodipine, olmesartan, or indapamide based on KARDIA-2 trial data.",
            packSize = "Investigational prefilled vial / syringe (300 mg / 600 mg)",
            counselingNepali = "यो अनुसन्धानको अन्तिम चरणमा रहेको नयाँ प्रविधिको औषधि (siRNA) हो। ६ महिनामा एक पटक सुई लगाएपछि ६ महिनासम्म नै रक्तचाप नियन्त्रणमा रहन्छ।",
            counselingEnglish = "Breakthrough 6-month investigational siRNA injection currently in Phase II/III clinical trials for durable 24-hour blood pressure control."
        ),

        Drug(
            id = "d_htn_aprocitentan",
            genericName = "Aprocitentan",
            system = "Cardiovascular System (CVS)",
            drugClass = "Oral Dual Endothelin Receptor Antagonist (ETA / ETB Antagonist)",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "RECENTLY APPROVED / NOVEL BREAKTHROUGH: First-in-class dual endothelin receptor antagonist approved by US FDA in March 2024 (brand name Tryvio) for treatment-resistant hypertension. PRECISION Phase III trial demonstrated sustained blood pressure reduction in patients uncontrolled on ≥3 standard antihypertensive agents.",
            blackBoxWarning = "EMBRYO-FETAL TOXICITY: Causes major birth defects. Pregnancy testing is required prior to initiation, monthly during treatment, and 1 month after discontinuation. Restricted access via REMS program.",
            indications = "Resistant hypertension: Treatment of hypertension in combination with other antihypertensive drugs to lower blood pressure in adult patients who are not adequately controlled on other drugs.",
            doses = "12.5 mg orally once daily with or without food.",
            adultDose = "12.5 mg PO once daily",
            childDose = "Safety and efficacy not established in pediatric patients.",
            administration = "Take orally once daily with or without food.",
            timing = "Once daily morning.",
            specialInstructions = "Monitor for fluid retention, peripheral edema, and hemoglobin/hematocrit reduction (dilutional). Check monthly pregnancy test in females of childbearing potential.",
            pkPd = "Potent orally active dual inhibitor of endothelin receptors A and B. Inhibits binding of ET-1 to ETA and ETB receptors on vascular smooth muscle. Terminal elimination half-life ~44 hours, permitting true once-daily dosing.",
            renalAdj = "No dose adjustment required in mild, moderate, or severe renal impairment (eGFR down to 15 mL/min/1.73m²). Not studied in ESRD on dialysis.",
            hepaticAdj = "Moderate to severe hepatic impairment (Child-Pugh B or C): Not recommended.",
            pregnancy = "Contraindicated (Black Box REMS: teratogenic).",
            lactation = "Breastfeeding not recommended during treatment.",
            sideEffects = "Peripheral edema / fluid retention (9-18%), nasal congestion, anemia / decreased hemoglobin, headache.",
            priceNpr = "Under Global Launch / Pipeline",
            priceInr = "Under Global Launch / Pipeline",
            brandsNepal = listOf(
                BrandInfo("Tryvio (Aprocitentan)", "Idorsia / Global Pipeline", "Film-coated Tab", "12.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tryvio", "Idorsia Pharmaceuticals", "Tablet", "12.5 mg")
            ),
            contraindications = "Pregnancy, severe hepatic impairment, hypersensitivity to aprocitentan.",
            modeOfAction = "Prevents endothelin-1 from binding to ETA and ETB receptors, blocking ET-1-mediated vasoconstriction, vascular hypertrophy, and sympathetic activation.",
            interactions = "CYP3A4 inducers decrease levels; monitor concurrent diuretics to manage fluid retention.",
            packSize = "Bottle or blister of 30 tablets (12.5 mg)",
            counselingNepali = "यो ३ वा सोभन्दा बढी औषधिले पनि नघटेको कडा रक्तचाप (रेजिस्टेन्ट हाइपरटेन्सन) का लागि २०२४ मा प्रमाणित भएको आधुनिक औषधि हो। खुट्टा सुन्निन सक्छ। गर्भवती महिलाले खानुहुँदैन।",
            counselingEnglish = "Approved 2024 for treatment-resistant hypertension. Monitor weight and check for lower leg swelling. Monthly pregnancy test required for women."
        ),

        Drug(
            id = "d_htn_baxdrostat",
            genericName = "Baxdrostat (CIN-107)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Investigational Selective Aldosterone Synthase Inhibitor (ASI)",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "Anti-HTN",
            researchNotes = "INVESTIGATIONAL BREAKTHROUGH: Highly selective small-molecule inhibitor of aldosterone synthase (CYP11B2) that has >100:1 selectivity over 11-beta-hydroxylase (CYP11B1), thereby selectively suppressing aldosterone production without causing cortisol deficiency! Phase II BrigHTN trial published in NEJM showed statistically significant placebo-corrected systolic BP reductions of up to 11 mmHg in resistant hypertension.",
            indications = "Investigational: Treatment-resistant hypertension, uncontrolled hypertension, primary aldosteronism.",
            doses = "Clinical Trial Dosing: 0.5 mg, 1 mg, or 2 mg PO once daily.",
            adultDose = "Investigational: 1 - 2 mg PO once daily (Phase III Trials)",
            childDose = "Not studied in children.",
            administration = "Oral tablet taken once daily in the morning.",
            timing = "Morning with water.",
            specialInstructions = "Clinical pipeline agent (AstraZeneca / CinCor). Selective inhibition avoids adrenocortical insufficiency while directly shutting down excess aldosterone-driven vascular stiffness and sodium retention.",
            pkPd = "Selectively inhibits aldosterone synthase enzyme (CYP11B2) in the adrenal zona glomerulosa. Lowers plasma and urinary aldosterone concentrations dose-dependently without altering ACTH-stimulated cortisol levels.",
            renalAdj = "Under evaluation in Phase III trials (including CKD cohorts).",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated during pregnancy.",
            lactation = "Avoid; safety not established.",
            sideEffects = "Hyperkalemia (dose-dependent, usually mild), headache, dizziness, fatigue; no episodes of adrenocortical insufficiency.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Baxdrostat (Investigational)", "AstraZeneca Pipeline", "Tablet", "1 mg / 2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("CIN-107 (Trial)", "CinCor / AstraZeneca Studies", "Tablet", "1 mg / 2 mg")
            ),
            contraindications = "Severe hyperkalemia, known adrenal insufficiency.",
            modeOfAction = "Selectively blocks CYP11B2 (aldosterone synthase), inhibiting conversion of 11-deoxycorticosterone to aldosterone in adrenal cortex.",
            interactions = "Potassium-sparing drugs, ACEIs, ARBs (monitor potassium).",
            packSize = "Investigational blister of 28 tablets",
            counselingNepali = "यो औषधिको अनुसन्धान अन्तिम चरणमा छ। यसले एड्रेनल ग्रन्थीबाट बन्ने हानिकारक एल्डोस्टेरोन हर्मोनलाई रोकेर जटिल प्रेसर घटाउँछ।",
            counselingEnglish = "Phase III investigational aldosterone synthase inhibitor providing targeted hormonal control for resistant hypertension without cortisol blockade."
        ),

        // ==========================================
        // 2. OHA (ORAL HYPOGLYCEMIC AGENTS / ANTIDIABETIC)
        // ==========================================

        // --- OLDER / CLASSICAL OHA ---
        Drug(
            id = "d_oha_chlorpropamide",
            genericName = "Chlorpropamide",
            system = "Endocrine & Metabolic System",
            drugClass = "1st-Generation Sulfonylurea Antidiabetic Agent",
            era = "Older / Classical",
            therapeuticClassTag = "OHA",
            researchNotes = "Classical 1st-generation sulfonylurea (1950s). Possesses an exceptionally prolonged elimination half-life (~36 hours) and high propensity for severe, protracted hypoglycemia and disulfiram-like ethanol flushing; virtually superseded by modern SGLT2i and DPP-4i.",
            blackBoxWarning = "INCREASED CARDIOVASCULAR MORTALITY: Based on the historical UGDP study, first-generation sulfonylureas were linked to increased cardiovascular mortality compared to diet alone.",
            indications = "Type 2 Diabetes Mellitus (historical), neurogenic diabetes insipidus (potentiates ADH action on collecting duct).",
            doses = "Initial: 100 mg to 250 mg PO once daily with breakfast. Maximum dose 500 mg daily.",
            adultDose = "100 - 250 mg PO once daily (Max 500 mg)",
            childDose = "Contraindicated in pediatric practice.",
            administration = "Take orally once daily in the morning with breakfast.",
            timing = "Morning with first meal.",
            specialInstructions = "AVOID IN ELDERLY (Beers Criteria high risk). Strict avoidance of alcohol (causes intense facial flushing, throbbing headache, and nausea).",
            pkPd = "Stimulates pancreatic beta-cell insulin secretion by closing ATP-sensitive potassium channels. Hepatically metabolized (80%) and renally excreted unchanged (20%). Elimination half-life: 36-48 hours.",
            renalAdj = "CrCl <50 mL/min: CONTRAINDICATED (causes refractory, prolonged hypoglycemia).",
            hepaticAdj = "CONTRAINDICATED in hepatic impairment.",
            pregnancy = "Category C (Prolonged severe neonatal hypoglycemia; switch to insulin).",
            lactation = "Contraindicated; excreted in breast milk.",
            sideEffects = "Severe prolonged hypoglycemia (can persist for days), SIADH / dilutional hyponatremia, disulfiram-like alcohol reaction, cholestatic jaundice, hematologic cytopenias.",
            priceNpr = "NPR 3.00 - 5.50 per tab (250mg)",
            priceInr = "INR 2.00 - 4.00 per tab (250mg)",
            brandsNepal = listOf(
                BrandInfo("Diabinese", "Pfizer / Historical", "Tablet", "250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Diabinese", "Pfizer India", "Tablet", "100 mg / 250 mg")
            ),
            contraindications = "Type 1 diabetes, diabetic ketoacidosis, severe renal or hepatic disease, elderly patients, pregnancy.",
            modeOfAction = "Binds to SUR1 subunit of ATP-sensitive K+ channels in pancreatic beta-cell membranes, causing depolarization, calcium influx, and sustained insulin exocytosis.",
            interactions = "Alcohol (disulfiram flush & severe hypoglycemia), Salicylates, Sulfonamides, Warfarin (displaces protein binding, increasing toxicity).",
            packSize = "Strip of 10 tablets",
            counselingNepali = "यो चिनी रोगको धेरै पुरानो औषधि हो। यसले रगतमा सुगर धेरै कम गराउन सक्छ र रक्सी खाएमा अनुहार एकदम रातो भएर बान्ता आउँछ। अचेल यो खासै प्रयोग गरिँदैन।",
            counselingEnglish = "Historical sulfonylurea. Severe risk of prolonged low blood sugar. Strict alcohol avoidance mandatory."
        ),

        Drug(
            id = "d_oha_glibenclamide",
            genericName = "Glibenclamide (Glyburide)",
            system = "Endocrine & Metabolic System",
            drugClass = "2nd-Generation Sulfonylurea",
            era = "Older / Classical",
            therapeuticClassTag = "OHA",
            researchNotes = "Classical 2nd-generation sulfonylurea introduced in 1969. High potency but carries active renal metabolites (M1 and M2) with elevated risk of hypoglycemia, particularly in older adults and renal insufficiency (Beers 2023 Criteria: AVOID).",
            indications = "Type 2 Diabetes Mellitus as monotherapy or in combination with metformin.",
            doses = "Initial: 2.5 mg to 5 mg PO once daily with breakfast. Maintenance: 5 mg to 10 mg daily (max 20 mg/day in divided doses). Micronized formulation: 1.5 - 3 mg daily.",
            adultDose = "2.5 - 10 mg PO once daily (Max 20 mg/day)",
            childDose = "Not recommended in children.",
            administration = "Take orally with breakfast or the first main meal of the day.",
            timing = "Immediately before or with breakfast.",
            specialInstructions = "Always advise patient to carry quick-acting glucose sweets. Re-evaluate and switch to gliclazide or glimepiride if renal function declines.",
            pkPd = "High-affinity binding to SUR1 on beta cells. Metabolized in liver to active metabolites excreted equally in urine and bile. Half-life ~10h, biological effect lasts 24h.",
            renalAdj = "CrCl <50 mL/min: AVOID or switch to glipizide/linagliptin. CrCl <30: Contraindicated.",
            hepaticAdj = "Use with extreme caution. Severe impairment contraindicated.",
            pregnancy = "Category C (Switch to insulin during pregnancy).",
            lactation = "Contraindicated in nursing mothers.",
            sideEffects = "Hypoglycemia, weight gain (2-4 kg), epigastric fullness, allergic skin rashes, photosensitivity, elevated transaminases.",
            priceNpr = "NPR 3.50 - 7.00 per tab (5mg)",
            priceInr = "INR 2.50 - 5.00 per tab (5mg)",
            brandsNepal = listOf(
                BrandInfo("Daonil", "Sanofi Nepal", "Tablet", "5 mg"),
                BrandInfo("Euglucon", "Roche / Regional", "Tablet", "5 mg"),
                BrandInfo("Semi-Daonil", "Sanofi Nepal", "Tablet", "2.5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Daonil", "Sanofi India", "Tablet", "5 mg"),
                BrandInfo("Semi-Daonil", "Sanofi India", "Tablet", "2.5 mg"),
                BrandInfo("Glynase", "USV Ltd.", "Tablet", "2.5 mg / 5 mg")
            ),
            contraindications = "Type 1 diabetes, diabetic ketoacidosis, moderate-to-severe renal impairment (CrCl <50), elderly patients >65 years, sulfa allergy.",
            modeOfAction = "Closes K-ATP channels on pancreatic beta cells, triggering Ca2+ influx and insulin granule exocytosis.",
            interactions = "NSAIDs, Ciprofloxacin, Fluconazole (increase glibenclamide levels and cause severe hypoglycemia); Beta-blockers (mask hypoglycemic warning signs).",
            packSize = "Strip of 10 or 20 tablets",
            counselingNepali = "यो सुगर घटाउने पुरानो औषधि हो। खाना खानु ठिक अगाडि खानुपर्छ। खाना छाडेमा सुगर निकै घट्न सक्छ, त्यसैले गुलियो चकलेट सधैं साथमा राख्नुहोस्।",
            counselingEnglish = "Take with breakfast. Never skip meals while taking glibenclamide. Always carry fast-acting glucose sweets."
        ),

        Drug(
            id = "d_oha_metformin",
            genericName = "Metformin Hydrochloride",
            system = "Endocrine & Metabolic System",
            drugClass = "Biguanide Antihyperglycemic Agent (AMPK Activator)",
            era = "Older / Classical",
            therapeuticClassTag = "OHA",
            researchNotes = "Foundational first-line agent for Type 2 Diabetes worldwide (derived from Galega officinalis / French lilac in 1957). UKPDS landmark study confirmed reduction in macrovascular events; weight-neutral with zero intrinsic hypoglycemia risk.",
            blackBoxWarning = "LACTIC ACIDOSIS: Rare but life-threatening accumulation can occur in severe renal impairment (eGFR <30 mL/min/1.73m²), hypoxemic states, sepsis, dehydration, or acute heart failure. Discontinue prior to iodinated radiocontrast procedures.",
            indications = "Type 2 Diabetes Mellitus (first-line therapy), Prediabetes, Polycystic Ovary Syndrome (PCOS), gestational diabetes (alternative).",
            doses = "Initial: 500 mg PO BID or 850 mg PO OD with meals. Titrate weekly by 500 mg to target 1000 mg PO BID (or 2000 mg XR once daily with dinner). Max: 2550 mg/day.",
            adultDose = "500 - 1000 mg PO BID with meals (or 1000-2000 mg XR with dinner)",
            childDose = "Pediatric (≥10 years): Initial 500 mg PO BID, max 2000 mg/day.",
            administration = "Take orally with meals to reduce gastrointestinal adverse effects (nausea, metallic taste, diarrhea).",
            timing = "Immediately after meals (or with dinner for extended-release).",
            specialInstructions = "Withhold for 48 hours after iodinated radiocontrast imaging. Check annual Vitamin B12 levels (can cause B12 malabsorption and peripheral neuropathy).",
            pkPd = "Activates AMP-activated protein kinase (AMPK) in hepatocytes, reducing hepatic gluconeogenesis and glycogenolysis; increases peripheral glucose uptake in skeletal muscle. Bioavailability 50-60%. Excreted 100% unchanged in urine. Half-life ~6.2h.",
            renalAdj = "eGFR 45-59 mL/min: Max dose 1000 mg/day. eGFR 30-44 mL/min: Max dose 500-1000 mg/day. eGFR <30 mL/min/1.73m²: CONTRAINDICATED.",
            hepaticAdj = "Avoid in severe liver dysfunction or active alcoholism (increased lactic acidosis risk).",
            pregnancy = "Category B (Safe, extensively utilized in gestational diabetes and PCOS).",
            lactation = "Compatible with breastfeeding; excreted in low concentrations in breast milk.",
            sideEffects = "Diarrhea, abdominal cramps, nausea, flatulence, metallic taste, vitamin B12 deficiency (long-term), lactic acidosis (rare: ~3-5 cases per 100,000 patient-years).",
            priceNpr = "NPR 4.00 - 9.00 per tab (500mg)",
            priceInr = "INR 2.50 - 6.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Glyciphage", "Franco-Indian / Nepal", "Tablet", "500 mg / 850 mg / 1g"),
                BrandInfo("Cetapin", "Sanofi Nepal", "Tablet / XR", "500 mg / 1000 mg XR"),
                BrandInfo("Metfogamma", "Woerwag Nepal", "Tablet", "500 mg / 850 mg"),
                BrandInfo("Bigomet", "Aristo Nepal", "Tablet", "500 mg / 1000 mg SR")
            ),
            brandsIndia = listOf(
                BrandInfo("Glyciphage", "Franco-Indian Pharmaceuticals", "Tablet / SR", "500 mg / 850 mg / 1000 mg"),
                BrandInfo("Cetapin XR", "Sanofi India", "Extended-Release Tab", "500 mg / 1000 mg"),
                BrandInfo("Glycomet", "USV Ltd.", "Tablet / SR", "500 mg / 850 mg / 1g"),
                BrandInfo("Glucophage", "Merck Serono India", "Tablet", "500 mg / 850 mg / 1g")
            ),
            pediatricDosePerKg = 15.0,
            pediatricInterval = "mg/kg/day divided BID in children ≥10 years",
            contraindications = "Severe renal impairment (eGFR <30 mL/min), acute or chronic metabolic acidosis, shock, severe hypoxemia, acute heart failure, excessive alcohol intake.",
            modeOfAction = "Inhibits mitochondrial complex I, leading to activation of AMPK, downregulating hepatic gluconeogenic genes and improving peripheral insulin sensitivity.",
            interactions = "Iodinated radiocontrast agents (acute renal failure / lactic acidosis), Cimetidine (increases metformin exposure), Alcohol (potentiates lactic acidosis).",
            packSize = "Strip of 10, 15, or 20 tablets",
            counselingNepali = "यो सुगरको पहिलो र मुख्य औषधि हो। यसले तौल बढाउँदैन। पेट गडबड नहोस् भन्नका लागि सधैं खाना खाइसकेपछि मात्र खानुहोस्। लामो समय खाँदा भिटामिन बी१२ जचाउनुहोस्।",
            counselingEnglish = "Take with or right after meals to minimize stomach upset. Essential baseline therapy. Does not cause weight gain or hypoglycemia."
        ),

        // --- NEWER / MODERN STANDARDS OHA ---
        Drug(
            id = "d_oha_dapagliflozin",
            genericName = "Dapagliflozin",
            system = "Endocrine & Metabolic System",
            drugClass = "Sodium-Glucose Cotransporter-2 (SGLT2) Inhibitor",
            era = "Newer / Modern",
            therapeuticClassTag = "OHA",
            researchNotes = "Modern breakthrough SGLT2 inhibitor. Landmark DAPA-HF, DAPA-CKD, and DECLARE-TIMI 58 trials revolutionized cardiovascular-renal medicine, demonstrating profound reduction in cardiovascular death, heart failure hospitalization, and CKD progression regardless of diabetes status.",
            indications = "Type 2 Diabetes Mellitus, Heart Failure with reduced or preserved ejection fraction (HFrEF/HFpEF), Chronic Kidney Disease (CKD) at risk of progression.",
            doses = "10 mg PO once daily in the morning with or without food. (Starting dose 5 mg in severe hepatic impairment).",
            adultDose = "10 mg PO once daily in the morning",
            childDose = "Pediatric T2DM (≥10 years): 5 mg PO once daily, increase to 10 mg once daily.",
            administration = "Take orally once daily in the morning with or without food.",
            timing = "Morning with water.",
            specialInstructions = "Advise patient to drink adequate fluids throughout the day. Maintain meticulous perineal and genital hygiene to prevent mycotic infections. Withhold at least 3 days before major elective surgery to prevent euglycemic DKA.",
            pkPd = "Selectively and reversibly inhibits SGLT2 in renal proximal convoluted tubule, preventing glucose and sodium reabsorption, causing urinary excretion of ~70-80 g glucose/day (~280 kcal/day). Half-life 12.9 hours.",
            renalAdj = "eGFR ≥20 mL/min/1.73m²: 10 mg once daily (indicated for CKD and HF down to eGFR 20). eGFR <20: Initiation not recommended, but may be continued to reduce HF/CKD risk.",
            hepaticAdj = "Mild to moderate impairment: No adjustment. Severe impairment: Initial dose 5 mg daily.",
            pregnancy = "Avoid; animal data shows renal pelvic dilatation during 2nd and 3rd trimesters.",
            lactation = "Contraindicated; potential for serious adverse reactions in nursing infant.",
            sideEffects = "Genital mycotic infections (vulvovaginitis, balanitis), urinary tract infections, volume depletion / dehydration, euglycemic diabetic ketoacidosis (rare), Fournier gangrene (extremely rare).",
            priceNpr = "NPR 25.00 - 45.00 per tab (10mg)",
            priceInr = "INR 14.00 - 28.00 per tab (10mg)",
            brandsNepal = listOf(
                BrandInfo("Forxiga", "AstraZeneca Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapadoc", "Sun Pharma Nepal", "Tablet", "10 mg"),
                BrandInfo("Oxra", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapavel", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Forxiga", "AstraZeneca India", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Oxra", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapavel", "Lupin Ltd.", "Tablet", "10 mg"),
                BrandInfo("Justo", "Glenmark Pharmaceuticals", "Tablet", "10 mg")
            ),
            contraindications = "History of serious hypersensitivity to dapagliflozin, patients on hemodialysis.",
            modeOfAction = "Inhibits SGLT2 transporter in the S1 segment of the proximal renal tubule, promoting glucosuria, natriuresis, reducing cardiac preload/afterload, and lowering intraglomerular pressure.",
            interactions = "Loop diuretics (additive volume depletion and hypotension), Insulin / Sulfonylureas (reduce dose to avert hypoglycemia).",
            packSize = "Strip of 10 or 14 tablets",
            counselingNepali = "यो पिसाबबाट बढी भएको सुगर फ्याँक्ने नयाँ पुस्ताको औषधि हो। यसले मुटु र मृगौलालाई बलियो बनाउँछ र तौल घटाउँछ। दिनभर प्रशस्त पानी पिउनुहोस् र गुप्ताङ्ग सफा राख्नुहोस्।",
            counselingEnglish = "Take once daily in morning. Excretes excess sugar in urine. Protects heart and kidneys. Maintain good hydration and personal hygiene."
        ),

        Drug(
            id = "d_oha_oral_semaglutide",
            genericName = "Oral Semaglutide (Rybelsus)",
            system = "Endocrine & Metabolic System",
            drugClass = "Oral Glucagon-Like Peptide-1 (GLP-1) Receptor Agonist",
            era = "Newer / Modern",
            therapeuticClassTag = "OHA",
            researchNotes = "Groundbreaking first-ever oral peptide GLP-1 receptor agonist formulated with SNAC (sodium N-[8-(2-hydroxybenzoyl) amino] caprylate) carrier that enables transcellular gastric mucosal absorption. PIONEER clinical trials demonstrated robust HbA1c lowering (1.4-1.8%) and substantial weight loss (4-6 kg).",
            blackBoxWarning = "RISK OF THYROID C-CELL TUMORS: Causes dose-dependent thyroid C-cell tumors in rodents. Contraindicated in patients with a personal or family history of Medullary Thyroid Carcinoma (MTC) or Multiple Endocrine Neoplasia syndrome type 2 (MEN 2).",
            indications = "Type 2 Diabetes Mellitus in adults to improve glycemic control and reduce body weight; cardiovascular risk reduction.",
            doses = "Initiation: 3 mg PO once daily for 30 days. Maintenance: Increase to 7 mg PO once daily. If needed for additional glycemic control, increase to 14 mg PO once daily after at least 30 days on 7 mg.",
            adultDose = "Start 3 mg OD for 30 days -> 7 mg OD -> 14 mg OD (Max)",
            childDose = "Safety and efficacy not established in pediatric patients <18 years.",
            administration = "STRICT ADMINISTRATION PROTOCOL: Take upon waking on an empty stomach with a sip of plain water (no more than 120 mL / 4 oz). Wait at least 30 minutes before eating, drinking, or taking other oral medications.",
            timing = "First thing in the morning in fasting state.",
            specialInstructions = "Swallow tablet whole. Do not cut, crush, or chew, as this destroys the SNAC absorption barrier.",
            pkPd = "Synthetic peptide analogue of human GLP-1 (94% homology) bound to albumin via fatty acid side chain, resisting DPP-4 degradation. Half-life ~1 week. Steady state reached in 4-5 weeks.",
            renalAdj = "No dose adjustment required in mild, moderate, or severe renal impairment, including ESRD.",
            hepaticAdj = "No dose adjustment required across any stage of hepatic impairment.",
            pregnancy = "Discontinue at least 2 months before planned pregnancy due to long washout period.",
            lactation = "Contraindicated; potential for accumulation in breast milk.",
            sideEffects = "Nausea, vomiting, diarrhea, abdominal pain, constipation, decreased appetite, dyspepsia, cholelithiasis, pancreatitis (rare).",
            priceNpr = "NPR 350.00 - 480.00 per tab (7mg)",
            priceInr = "INR 220.00 - 320.00 per tab (7mg)",
            brandsNepal = listOf(
                BrandInfo("Rybelsus", "Novo Nordisk Nepal", "Tablet", "3 mg / 7 mg / 14 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Rybelsus", "Novo Nordisk India", "Tablet", "3 mg / 7 mg / 14 mg")
            ),
            contraindications = "Personal or family history of medullary thyroid carcinoma (MTC), Multiple Endocrine Neoplasia syndrome type 2 (MEN 2), history of severe pancreatitis.",
            modeOfAction = "Selectively binds and activates GLP-1 receptors, stimulating glucose-dependent insulin secretion, suppressing glucagon release, slowing gastric emptying, and promoting satiety.",
            interactions = "Oral levothyroxine (separate by at least 30 minutes; monitor TSH), Sulfonylureas / Insulin (reduce dose to prevent hypoglycemia).",
            packSize = "Pack of 10 or 30 tablets in protective aluminum blister",
            counselingNepali = "यो सुगर र तौल दुवै घटाउने पहिलो खाने GLP-1 चक्की हो। बिहान उठ्ने बित्तिकै खाली पेटमा आधा गिलास पानीसँग चक्की नटुक्र्याई निल्नुहोस् र कम्तीमा ३० मिनेटसम्म केही नखानुहोस्।",
            counselingEnglish = "Take upon waking with plain water only (max 120ml). Wait at least 30 minutes before food, drinks, or other pills. Do not chew or crush."
        ),

        Drug(
            id = "d_oha_imeglimin",
            genericName = "Imeglimin Hydrochloride",
            system = "Endocrine & Metabolic System",
            drugClass = "Novel Glimin Class Antidiabetic (Mitochondrial Bioenergetics Modulator)",
            era = "Newer / Modern",
            therapeuticClassTag = "OHA",
            researchNotes = "First-in-class 'Glimin' molecule approved in Japan and expanding globally (TIMES clinical trial program). Distinct dual mechanism targeting mitochondrial bioenergetics to simultaneously enhance glucose-stimulated insulin secretion in beta cells AND reverse insulin resistance in liver and muscle.",
            indications = "Type 2 Diabetes Mellitus as monotherapy or combination therapy with metformin, DPP-4 inhibitors, or SGLT2 inhibitors.",
            doses = "1000 mg orally twice daily with meals (morning and evening).",
            adultDose = "1000 mg PO BID with morning and evening meals",
            childDose = "Not established in pediatric populations.",
            administration = "Take orally twice daily with breakfast and dinner.",
            timing = "Twice daily with meals.",
            specialInstructions = "Well tolerated with minimal GI distress compared to high-dose metformin. Excellent synergistic partner with DPP-4 inhibitors.",
            pkPd = "Dual mitochondrial mechanism: inhibits complex I and preserves complex III activity, normalizing reactive oxygen species (ROS), improving mitochondrial membrane potential, and promoting ATP generation in pancreatic islets.",
            renalAdj = "eGFR ≥45 mL/min/1.73m²: 1000 mg BID. eGFR 15-44 mL/min: Reduce dose to 500 mg BID. eGFR <15: Not recommended.",
            hepaticAdj = "Use with caution in moderate to severe hepatic impairment.",
            pregnancy = "Avoid; animal reproduction studies show embryo-fetal toxicity.",
            lactation = "Avoid; safety in human lactation not established.",
            sideEffects = "Mild nausea, abdominal discomfort, diarrhea, decreased appetite; very low hypoglycemia risk.",
            priceNpr = "NPR 18.00 - 32.00 per tab (500mg)",
            priceInr = "INR 12.00 - 22.00 per tab (500mg)",
            brandsNepal = listOf(
                BrandInfo("Twymeeg", "Sumitomo Pharma / Regional", "Tablet", "500 mg / 1000 mg"),
                BrandInfo("Imegli", "Sun Pharma Nepal", "Tablet", "500 mg / 1000 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Twymeeg", "Sumitomo / Torrent Pharma", "Tablet", "500 mg / 1000 mg"),
                BrandInfo("Glimin", "Zydus Lifesciences", "Tablet", "500 mg / 1000 mg"),
                BrandInfo("Imeglip", "Cipla Ltd.", "Tablet", "500 mg / 1000 mg")
            ),
            contraindications = "Severe renal impairment (eGFR <15 mL/min), severe ketosis, diabetic coma.",
            modeOfAction = "Modulates mitochondrial respiratory chain complex I and III, reducing oxidative stress, restoring beta-cell insulin secretion, and enhancing peripheral glucose uptake.",
            interactions = "No clinically significant CYP450 interactions reported.",
            packSize = "Strip of 10 or 14 tablets",
            counselingNepali = "यो माइटोकोन्ड्रियल ऊर्जा सुधारेर सुगर नियन्त्रण गर्ने नयाँ वर्ग (Glimin) को औषधि हो। बिहान र बेलुका खानासँग एक-एक चक्की खानुहोस्।",
            counselingEnglish = "Take 1000 mg twice daily with meals. Novel mitochondrial mechanism improving both insulin secretion and sensitivity."
        ),

        // --- UNDER RESEARCH / PIPELINE OHA ---
        Drug(
            id = "d_oha_orforglipron",
            genericName = "Orforglipron (LY3502970)",
            system = "Endocrine & Metabolic System",
            drugClass = "Investigational Oral Non-Peptide GLP-1 Receptor Agonist",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "OHA",
            researchNotes = "INVESTIGATIONAL BREAKTHROUGH: First oral, non-peptide, small-molecule GLP-1 receptor agonist in Phase III clinical development (ACHIEVE and ATTAIN trials by Eli Lilly). Unlike oral semaglutide (which is a peptide requiring a fasting stomach and water volume restrictions), Orforglipron is a small molecule that can be taken ANY TIME of day WITH OR WITHOUT FOOD AND WATER with high, reliable oral bioavailability!",
            indications = "Under Phase III investigation for Type 2 Diabetes Mellitus, chronic weight management (obesity), and cardiovascular risk reduction.",
            doses = "Phase III Clinical Trial Dosing: Once-daily oral doses ranging from 12 mg, 24 mg, 36 mg, to 45 mg once daily.",
            adultDose = "Investigational: 12 - 45 mg PO once daily (Phase III Trials)",
            childDose = "Not evaluated in children.",
            administration = "Take orally once daily at any time of day, completely independent of meals and beverages.",
            timing = "Once daily, any convenient time.",
            specialInstructions = "Phase II NEJM data demonstrated up to 2.1% HbA1c reduction and up to 14.7% weight loss at 26 weeks, matching injectable GLP-1 agonists without injections or food restrictions.",
            pkPd = "Small molecule that selectively binds human GLP-1 receptor with full agonism. High oral bioavailability (~30-40%). Half-life ~29-39 hours, ideal for consistent once-daily dosing.",
            renalAdj = "Under study in Phase III; small-molecule clearance without reliance on renal peptide degradation.",
            hepaticAdj = "Under clinical evaluation.",
            pregnancy = "Contraindicated; preclinical reproductive toxicity.",
            lactation = "Contraindicated.",
            sideEffects = "Nausea, constipation, vomiting, diarrhea, decreased appetite (consistent with GLP-1 class, mostly mild-to-moderate and transient during dose titration).",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Orforglipron (Investigational)", "Eli Lilly Pipeline", "Oral Capsule", "12 mg / 36 mg / 45 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("LY3502970 (Trial)", "Eli Lilly Clinical Studies", "Capsule", "12 mg / 36 mg / 45 mg")
            ),
            contraindications = "Medullary thyroid carcinoma history, MEN 2 syndrome.",
            modeOfAction = "Binds to extracellular and transmembrane domains of the GLP-1 receptor as a small-molecule agonist, triggering cAMP signaling, glucose-dependent insulin secretion, and hypothalamic satiety.",
            interactions = "Delayed gastric emptying may modestly alter absorption kinetics of narrow therapeutic index oral drugs.",
            packSize = "Investigational blister of 30 capsules",
            counselingNepali = "यो अनुसन्धानको अन्तिम चरणमा रहेको पहिलो सानो-अणु (Non-peptide) GLP-1 चक्की हो। यसलाई खाना खानुअघि वा पछि जुनसुकै बेला पानीको बन्देज बिना खान मिल्छ।",
            counselingEnglish = "Breakthrough Phase III once-daily oral GLP-1 pill. No food, beverage, or morning fasting restrictions required."
        ),

        Drug(
            id = "d_oha_retatrutide",
            genericName = "Retatrutide (LY3437943)",
            system = "Endocrine & Metabolic System",
            drugClass = "Investigational Triple Hormone Receptor Agonist (GIP / GLP-1 / Glucagon Tri-Agonist - 'Triple G')",
            era = "Under Research / Pipeline",
            therapeuticClassTag = "OHA",
            researchNotes = "UNPRECEDENTED PIPELINE INNOVATION: Single peptide agonist targeting three metabolic hormone receptors: GIP, GLP-1, and Glucagon ('Triple G'). Phase II NEJM trials demonstrated the greatest weight loss ever recorded in medical history—up to 24.2% (mean 58 lbs) at 48 weeks—along with near-complete normalization of HbA1c and up to 86% resolution of hepatic steatosis (fatty liver)! Phase III TRIUMPH program currently ongoing.",
            indications = "Under Phase III investigation for Type 2 Diabetes, Severe Obesity, Metabolic Dysfunction-Associated Steatohepatitis (MASH / NASH), and Heart Failure.",
            doses = "Phase III Trial Regimen: Initiated at 2 mg or 4 mg subcutaneously once weekly, titrated up to 8 mg or 12 mg once weekly.",
            adultDose = "Investigational: 2 mg - 12 mg Subcutaneous once weekly",
            childDose = "Not studied in children.",
            administration = "Subcutaneous injection once weekly in abdomen, thigh, or upper arm.",
            timing = "Once weekly on the same day each week, any time of day.",
            specialInstructions = "Phase III TRIUMPH trials. Glucagon agonism specifically accelerates hepatic lipid clearance and energy expenditure, synergizing with GIP and GLP-1.",
            pkPd = "Engineered peptide backbone with an alpha-methyl-functionalized residue and a C20 diacid fatty chain that binds all three receptors (potent at GIPR, balanced at GLP-1R and GCGR). Half-life ~6 days.",
            renalAdj = "Under evaluation in Phase III trials.",
            hepaticAdj = "Demonstrated profound 80%+ resolution of liver fat in MASH trials; clinical pharmacology under final study.",
            pregnancy = "Contraindicated.",
            lactation = "Contraindicated.",
            sideEffects = "Gastrointestinal symptoms (nausea, diarrhea, vomiting), transient increase in resting heart rate (due to glucagon receptor activation), mild cutaneous hyperesthesia.",
            priceNpr = "Under Research / Phase III Trial",
            priceInr = "Under Research / Phase III Trial",
            brandsNepal = listOf(
                BrandInfo("Retatrutide (Investigational)", "Eli Lilly Pipeline", "Prefilled Pen", "4 mg / 8 mg / 12 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("LY3437943 (Trial)", "Eli Lilly Clinical Studies", "Prefilled Pen", "4 mg / 8 mg / 12 mg")
            ),
            contraindications = "Medullary thyroid cancer history, Multiple Endocrine Neoplasia type 2.",
            modeOfAction = "Triple agonism: GIP and GLP-1 stimulate glucose-dependent insulin secretion and central satiety, while glucagon receptor activation increases basal metabolic rate and hepatic fatty acid beta-oxidation.",
            interactions = "Delayed gastric emptying may transiently slow absorption of oral medications.",
            packSize = "Investigational prefilled autoinjector pens",
            counselingNepali = "यो चिकित्सा इतिहासकै सबैभन्दा शक्तिशाली मानिएको तीनवटा हर्मोन (GIP, GLP-1, Glucagon) एकैसाथ सक्रिय पार्ने नयाँ औषधि हो। यसले सुगर पूरै सामान्य बनाउनुका साथै २५% सम्म तौल घटाएको छ।",
            counselingEnglish = "Phase III 'Triple-G' tri-agonist delivering unprecedented 24% weight loss and complete HbA1c normalization in clinical trials."
        )
    )
}
