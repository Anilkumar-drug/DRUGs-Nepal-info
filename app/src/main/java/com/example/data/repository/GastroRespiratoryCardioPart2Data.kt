package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object GastroRespiratoryCardioPart2Data {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // GASTROENTEROLOGY & COLORECTAL
        // ==========================================
        Drug(
            id = "d_gastro2_racecadotril",
            genericName = "Racecadotril (Acetorphan)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Peripheral Enkephalinase Inhibitor Antidiarrheal",
            blackBoxWarning = null,
            indications = "Acute watery secretory diarrhea in infants (>3 months), children, and adults; complementary to Oral Rehydration Salts (ORS).",
            doses = "Adult: 100 mg PO TID before meals for up to 7 days.\nPediatric (>3 months): 1.5 mg/kg PO TID (10 mg sachet for infants <9 kg; 30 mg sachet for 9-27 kg).",
            administration = "Take orally before meals. Pediatric granules can be mixed with water, food, or baby bottle.",
            timing = "Three times daily before meals until normal stools return (max 7 days).",
            specialInstructions = "Acts purely antisecretory in gut lumen without affecting gastrointestinal transit time (does not cause secondary constipation, bacterial overgrowth, or abdominal distension, unlike loperamide).",
            pkPd = "Oral prodrug rapidly hydrolyzed to active thiorphan. Selective peripheral action; does not cross blood-brain barrier. Half-life ~3 hours.",
            renalAdj = "Use with caution in severe renal failure.",
            hepaticAdj = "Use with caution in severe hepatic impairment.",
            pregnancy = "Category B (Safety in pregnancy not established; use ORS).",
            lactation = "Safety in breastfeeding not established.",
            sideEffects = "Headache, tonsillitis, vomiting, erythema, urticaria (extremely low side effect incidence).",
            priceNpr = "NPR 90.00 - 180.00 per strip of 10 / NPR 25.00 per sachet",
            priceInr = "INR 60.00 - 120.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Enuff", "Torrent Pharmaceuticals Nepal", "Cap / Sachet", "100 mg / 10mg / 30mg"),
                BrandInfo("Zedott", "Torrent Pharmaceuticals", "Cap / Sachet", "100 mg / 30mg"),
                BrandInfo("Redotril", "Dr. Reddy's Nepal", "Cap", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Enuff", "Torrent", "Cap / Sachet", "100 mg / 10 / 30 mg"),
                BrandInfo("Zedott", "Torrent", "Cap", "100 mg")
            ),
            pediatricDosePerKg = 1.5,
            pediatricInterval = "mg/kg PO TID x max 7 days",
            adultDose = "100 mg PO TID before meals.",
            childDose = "1.5 mg/kg PO TID mixed with water/food.",
            contraindications = "Bloody diarrhea or diarrhea with high fever (invasive bacterial dysentery), antibiotic-induced pseudomembranous colitis, infants <3 months.",
            modeOfAction = "Selectively inhibits intestinal brush-border neutral endopeptidase (enkephalinase), protecting endogenous enkephalins from degradation and reducing hypersecretion of water and electrolytes into the intestinal lumen.",
            therapeuticClassTag = "Antidiarrheals"
        ),

        Drug(
            id = "d_gastro2_peg3350",
            genericName = "Polyethylene Glycol 3350 (PEG 3350 + Electrolytes)",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Osmotic Laxative & Bowel Evacuant",
            blackBoxWarning = null,
            indications = "Complete bowel cleansing prior to colonoscopy or colorectal surgery, chronic constipation, fecal impaction in adults and children.",
            doses = "Colonoscopy Cleansing: Reconstitute sachet in 2 liters of water; drink 250 mL every 10-15 minutes until clear watery rectal effluent (split-dose regimen preferred). Chronic Constipation: 17 g (1 tablespoon powder) dissolved in 120-240 mL water once daily.",
            administration = "Dissolve completely in water, juice, or clear broth before drinking.",
            timing = "Split-dose (half the evening before, half the morning of colonoscopy).",
            specialInstructions = "Does not cause fluid or electrolyte shifts because it is iso-osmolar with bowel contents. Safest laxative for chronic constipation in elderly, renal, and cardiac patients.",
            pkPd = "Virtually unabsorbed from GI tract (<0.2%). Excreted 100% unchanged in stool. Onset: 24-48 hours for daily dosing; 1-2 hours for lavage.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Not systemically absorbed; safe and preferred for pregnancy constipation).",
            lactation = "Not absorbed systemically; safe during breastfeeding.",
            sideEffects = "Abdominal fullness, nausea, bloating, mild cramping, anal irritation.",
            priceNpr = "NPR 250.00 - 450.00 per bottle / sachet (137g / 2L pack)",
            priceInr = "INR 180.00 - 320.00 per pack",
            brandsNepal = listOf(
                BrandInfo("Peglec", "Tablets India / Nepal Dist.", "Powder", "137.15 g for 2 L"),
                BrandInfo("Movicol", "Norgine / Medisales Nepal", "Sachet", "13.8 g sachet"),
                BrandInfo("Pegmove", "Sun Pharma Nepal", "Syrup / Powder", "17 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Peglec", "Tablets India", "Powder", "2 L pack"),
                BrandInfo("Movicol", "Win-Medicare", "Sachet", "13.8 g")
            ),
            adultDose = "17 g PO daily for constipation; 2-4 L solution for colonoscopy.",
            childDose = "Fecal impaction: 1-1.5 g/kg/day PO for 3-6 days.",
            contraindications = "Gastrointestinal obstruction, bowel perforation, toxic megacolon, gastric retention, ileus.",
            modeOfAction = "Acts as an inert osmotic agent that binds water molecules via hydrogen bonding, preventing colonic water reabsorption, softening stool, and promoting peristaltic evacuation.",
            therapeuticClassTag = "Laxatives / Bowel Prep"
        ),

        Drug(
            id = "d_gastro2_bisacodyl",
            genericName = "Bisacodyl",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Diphenylmethane Stimulant Laxative",
            blackBoxWarning = null,
            indications = "Short-term treatment of acute constipation, pre-operative and pre-radiological bowel preparation, neurogenic bowel management.",
            doses = "Oral: 5 to 10 mg PO at bedtime (max 15 mg). Rectal Suppository: 10 mg PR inserted in morning for rapid evacuation.\nPediatric (6-12 yr): 5 mg PO at bedtime or 5 mg PR.",
            administration = "Swallow tablet whole with a glass of water. Do not take within 1 hour of antacids, milk, or PPIs (dissolves enteric coating prematurely, causing severe gastric irritation and vomiting).",
            timing = "Oral: Bedtime (produces bowel movement in 6-12 hours). Rectal: Morning (works in 15-60 minutes).",
            specialInstructions = "Avoid chronic daily use (>7 days) to prevent stimulant laxative dependence, colonic atony, and electrolyte disturbances (hypokalemia).",
            pkPd = "Minimally absorbed (<5%). Converted by endogenous bacterial enzymes in colon to active metabolite bis-(p-hydroxyphenyl)-pyridyl-2-methane (BHPM). Excreted in feces.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Short-term use acceptable; non-absorbable bulking agents preferred).",
            lactation = "Neither bisacodyl nor active metabolites excreted in breast milk; safe during breastfeeding.",
            sideEffects = "Abdominal cramping, griping pain, nausea, diarrhea, rectal burning/irritation (suppositories), hypokalemia.",
            priceNpr = "NPR 15.00 - 30.00 per strip of 10 (5mg) / NPR 12.00 per suppository",
            priceInr = "INR 10.00 - 20.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Dulcolax", "Sanofi Nepal / Medisales", "Tab / Supp", "5 mg Tab / 10 mg Supp"),
                BrandInfo("Conlax", "Torrent Pharmaceuticals", "Tab", "5 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Dulcolax", "Sanofi India", "Tab / Supp", "5 mg / 10 mg"),
                BrandInfo("Gerbisa", "Zydus", "Tab / Supp", "5 mg / 10 mg")
            ),
            adultDose = "5-10 mg PO at bedtime or 10 mg PR suppository.",
            childDose = "Children 6-12 yr: 5 mg PO or PR.",
            contraindications = "Acute surgical abdomen, appendicitis, intestinal obstruction, acute inflammatory bowel disease, severe dehydration, undiagnosed abdominal pain.",
            modeOfAction = "Directly stimulates mucosal sensory nerve endings in the colon (myenteric plexus), accelerating colonic peristalsis while increasing accumulation of fluid and electrolytes in lumen.",
            therapeuticClassTag = "Stimulant Laxatives"
        ),

        Drug(
            id = "d_gastro2_prucalopride",
            genericName = "Prucalopride",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Selective High-Affinity 5-HT4 Receptor Agonist Enterokinetic",
            blackBoxWarning = null,
            indications = "Chronic Idiopathic Constipation (CIC) in adults when standard laxatives fail to provide adequate relief, opioid-induced constipation.",
            doses = "Adult: 2 mg PO once daily with or without food. Elderly (>65 yr) or Renal Impairment (CrCl <50 mL/min): Start 1 mg PO once daily.",
            administration = "Take orally once daily at any time of day with or without food.",
            timing = "Morning with or without breakfast.",
            specialInstructions = "HIGH CARDIAC SAFETY: Highly selective for 5-HT4 receptors without affinity for hERG K+ channels or 5-HT1B/2B receptors (unlike older prokinetics cisapride/tegaserod which caused fatal arrhythmias).",
            pkPd = "Oral bioavailability >90%. Minimal hepatic metabolism. Excreted >60% unchanged in urine. Elimination half-life 24-30 hours, supporting once-daily dosing.",
            renalAdj = "CrCl 15-50 mL/min: 1 mg PO once daily. CrCl <15 mL/min (ESRD): Contraindicated.",
            hepaticAdj = "Severe hepatic impairment: Start 1 mg PO once daily.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Excreted in breast milk; safety not established.",
            sideEffects = "Transient headache (>25% on day 1, subsides in 2-3 days), nausea, abdominal pain, diarrhea, flatulence, fatigue.",
            priceNpr = "NPR 140.00 - 280.00 per strip of 10 (1mg / 2mg)",
            priceInr = "INR 95.00 - 190.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Resolor", "Shire / Takeda / Nepal", "Tab", "1 mg / 2 mg"),
                BrandInfo("Pruease", "Sun Pharma Nepal", "Tab", "1 mg / 2 mg"),
                BrandInfo("Pruvict", "Torrent Pharmaceuticals", "Tab", "1 mg / 2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Resolor", "Janssen / Takeda", "Tab", "1 / 2 mg"),
                BrandInfo("Pruvict", "Torrent", "Tab", "1 / 2 mg")
            ),
            adultDose = "2 mg PO once daily (1 mg in CrCl <50 or elderly).",
            childDose = "Safety and efficacy not established in pediatric patients.",
            contraindications = "Renal impairment requiring dialysis, intestinal perforation or obstruction, severe inflammatory conditions of GI tract (Crohn's, ulcerative colitis, toxic megacolon).",
            modeOfAction = "Potent, selective enterokinetic that stimulates 5-HT4 receptors in enteric neurons, triggering acetylcholine and calcitonin gene-related peptide release, promoting colonic high-amplitude propagating contractions (HAPCs).",
            therapeuticClassTag = "Prokinetics / Enterokinetics"
        ),

        // ==========================================
        // RESPIRATORY & PULMONOLOGY
        // ==========================================
        Drug(
            id = "d_resp2_ipratropium",
            genericName = "Ipratropium Bromide",
            system = "Respiratory System (RS)",
            drugClass = "Short-Acting Muscarinic Antagonist (SAMA) Bronchodilator",
            blackBoxWarning = null,
            indications = "Acute bronchospasm in COPD exacerbation, acute moderate-to-severe asthma exacerbation (combined with salbutamol / albuterol), rhinorrhea in allergic/vasomotor rhinitis (nasal spray).",
            doses = "Nebulization: 500 mcg (2 mL respule) mixed with Salbutamol 2.5 mg every 20-30 minutes for 3 doses in acute severe asthma, then q4-6h prn. Inhaler: 2 puffs (40 mcg) QID (max 12 puffs/day).",
            administration = "Via nebulizer with mouthpiece or well-fitting mask (avoid eye exposure), or MDI with spacer.",
            timing = "STAT in acute exacerbations or every 6 hours.",
            specialInstructions = "PROTECT EYES: Accidental ocular exposure (leaking face mask) can precipitate acute angle-closure glaucoma or pupillary dilation.",
            pkPd = "Quaternary ammonium compound; minimal systemic absorption (<7%). Onset: 15 minutes; peak effect: 1-2 hours; duration: 4-6 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe throughout pregnancy; preferred anticholinergic for acute bronchospasm).",
            lactation = "Minimal systemic absorption; safe during breastfeeding.",
            sideEffects = "Dry mouth, cough, bitter taste, urinary retention in elderly BPH, mydriasis/acute glaucoma if sprayed in eyes.",
            priceNpr = "NPR 35.00 - 65.00 per respule (500 mcg/2mL) / NPR 250.00 MDI",
            priceInr = "INR 20.00 - 45.00 per respule",
            brandsNepal = listOf(
                BrandInfo("Ipravent", "Cipla Nepal", "Respules / Inhaler", "500 mcg/2mL / 20 mcg MDI"),
                BrandInfo("Duolin", "Cipla Nepal", "Respules / Inhaler", "Ipratropium 500mcg + Levosalbutamol 1.25mg"),
                BrandInfo("Combivent", "Boehringer Ingelheim Nepal", "Respules", "Ipratropium + Salbutamol")
            ),
            brandsIndia = listOf(
                BrandInfo("Ipravent", "Cipla", "Respules / Inhaler", "500 mcg / 20 mcg"),
                BrandInfo("Duolin", "Cipla", "Respules / Inhaler", "Ipratropium + Levosalbutamol")
            ),
            pediatricDosePerKg = 250.0,
            pediatricInterval = "mcg per nebulization q20min x 3 doses in severe asthma",
            adultDose = "500 mcg nebulized q20min x 3 doses, then q4-6h.",
            childDose = "<12 yr: 250 mcg nebulized q20min x 3 doses; >=12 yr: 500 mcg.",
            contraindications = "Hypersensitivity to ipratropium, atropine, or derivatives.",
            modeOfAction = "Competitively blocks muscarinic cholinergic receptors (M1, M2, M3) on airway smooth muscle, inhibiting acetylcholine-induced bronchoconstriction and reducing basal bronchial secretions.",
            therapeuticClassTag = "SAMA / Bronchodilators"
        ),

        Drug(
            id = "d_resp2_beclomethasone",
            genericName = "Beclomethasone Dipropionate",
            system = "Respiratory System (RS)",
            drugClass = "Inhaled Corticosteroid (ICS)",
            blackBoxWarning = null,
            indications = "Maintenance and prophylactic treatment of persistent asthma in adults and children, maintenance therapy in COPD (combined with LABA).",
            doses = "Adult: 100 to 400 mcg inhaled twice daily (max 800 mcg BID). Extra-fine particle formulation (Qvar): 40 to 160 mcg BID.\nPediatric (>= 5 yr): 50 to 100 mcg inhaled twice daily.",
            administration = "Oral inhalation via MDI with spacer or DPI. Rinse mouth thoroughly and gargle with water and spit out after each inhalation.",
            timing = "Twice daily (morning and evening).",
            specialInstructions = "Always rinse mouth and spit after use to prevent oral candidiasis (thrush) and dysphonia. Not a rescue inhaler; must be used daily for anti-inflammatory control.",
            pkPd = "Prodrug rapidly hydrolyzed by esterases in lung tissue to active beclomethasone-17-monopropionate (17-BMP), which has 30x higher glucocorticoid receptor affinity. Systemic bioavailability ~15-20%.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Extensive clinical experience; considered safe for persistent asthma in pregnancy).",
            lactation = "Minimal systemic absorption; safe during breastfeeding.",
            sideEffects = "Oropharyngeal candidiasis, hoarseness, dysphonia, throat irritation, dry mouth, rare adrenal suppression at very high chronic doses.",
            priceNpr = "NPR 180.00 - 350.00 per 200-dose inhaler (100mcg / 200mcg)",
            priceInr = "INR 120.00 - 240.00 per inhaler",
            brandsNepal = listOf(
                BrandInfo("Beclate", "Cipla Nepal", "Inhaler / Rotacaps", "100 mcg / 200 mcg / 400 mcg"),
                BrandInfo("Aerocort", "Cipla Nepal", "Inhaler", "Beclomethasone 50mcg + Levosalbutamol 50mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Beclate", "Cipla", "Inhaler", "100 / 200 mcg"),
                BrandInfo("Qvar", "Teva", "Inhaler", "40 / 80 mcg")
            ),
            adultDose = "200-400 mcg inhaled BID.",
            childDose = "Children >= 5 yr: 50-100 mcg inhaled BID.",
            contraindications = "Status asthmaticus or acute bronchospasm requiring rapid relief; untreated fungal, bacterial, or tubercular airway infections.",
            modeOfAction = "Binds to intracellular glucocorticoid receptors, modulating nuclear transcription factors (NF-kB), suppressing airway eosinophilic inflammation, cytokines, and vascular permeability.",
            therapeuticClassTag = "ICS / Asthma Control"
        ),

        Drug(
            id = "d_resp2_roflumilast",
            genericName = "Roflumilast",
            system = "Respiratory System (RS)",
            drugClass = "Selective Phosphodiesterase-4 (PDE-4) Inhibitor",
            blackBoxWarning = null,
            indications = "Maintenance treatment to reduce risk of COPD exacerbations in patients with severe COPD (FEV1 <50% predicted) associated with chronic bronchitis and history of frequent exacerbations.",
            doses = "Adult: Start 250 mcg PO once daily for 4 weeks (to reduce gastrointestinal adverse effects and treatment discontinuation), then increase to maintenance dose 500 mcg PO once daily.",
            administration = "Take orally once daily with or without food at the same time each day.",
            timing = "Once daily in morning or evening.",
            specialInstructions = "Not a bronchodilator; specifically targeted at systemic and airway neutrophilic inflammation. Monitor body weight regularly; associated with involuntary weight loss (average 2-2.5 kg).",
            pkPd = "Rapidly converted by CYP3A4 and CYP1A2 to active metabolite roflumilast N-oxide (responsible for >90% of in vivo PDE-4 inhibition). Half-life: roflumilast ~17 hours, N-oxide ~30 hours.",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "Moderate or severe hepatic impairment (Child-Pugh B or C): CONTRAINDICATED.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Excreted in animal milk; avoid in nursing mothers.",
            sideEffects = "Diarrhea (>10%), nausea, weight loss, decreased appetite, headache, insomnia, depression, anxiety, suicidal thoughts.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (500 mcg)",
            priceInr = "INR 75.00 - 150.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Daliresp", "AstraZeneca / Nepal Dist.", "Tab", "500 mcg"),
                BrandInfo("Roflutab", "Cipla Nepal", "Tab", "500 mcg")
            ),
            brandsIndia = listOf(
                BrandInfo("Daliresp", "AstraZeneca", "Tab", "500 mcg"),
                BrandInfo("Roflutab", "Cipla", "Tab", "500 mcg")
            ),
            adultDose = "250 mcg PO OD x 4 weeks, then 500 mcg PO OD.",
            childDose = "Not indicated in children.",
            contraindications = "Moderate or severe hepatic impairment (Child-Pugh B or C), history of severe depression with suicidal ideation.",
            modeOfAction = "Selectively inhibits phosphodiesterase-4 (PDE-4), preventing cAMP breakdown in inflammatory cells (neutrophils, macrophages, CD8+ T cells), suppressing release of pro-inflammatory mediators in COPD.",
            therapeuticClassTag = "COPD / Anti-inflammatory"
        ),

        Drug(
            id = "d_resp2_acetylcysteine_oral",
            genericName = "Acetylcysteine (Oral / Effervescent)",
            system = "Respiratory System (RS)",
            drugClass = "Mucolytic Agent & Antioxidant (Glutathione Precursor)",
            blackBoxWarning = null,
            indications = "Adjuvant mucolytic therapy in bronchopulmonary disorders with excessive viscous mucus (COPD, bronchiectasis, cystic fibrosis, chronic bronchitis).",
            doses = "Adult: 600 mg PO effervescent tablet once daily in morning (or 200 mg PO TID) dissolved in half a glass of water.",
            administration = "Dissolve effervescent tablet completely in half a glass of plain water and drink immediately.",
            timing = "Morning with or after breakfast.",
            specialInstructions = "Free sulfhydryl (-SH) group cleaves disulfide bonds in mucoproteins, liquefying tenacious mucus. Long-term use in COPD reduces exacerbation frequency via antioxidant replenishment of lung glutathione.",
            pkPd = "Oral bioavailability 4-10% (extensive first-pass deacetylation in liver and gut wall). Converted to cysteine, precursor of intracellular glutathione. Half-life ~5.6 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe throughout pregnancy).",
            lactation = "Excretion in breast milk unknown; safe.",
            sideEffects = "Nausea, vomiting, stomatitis, heartburn, sulfurous odor/taste, mild diarrhea, rare bronchospasm in hyperreactive asthmatics.",
            priceNpr = "NPR 180.00 - 350.00 per tube of 10 effervescent tablets (600mg)",
            priceInr = "INR 120.00 - 240.00 per tube of 10",
            brandsNepal = listOf(
                BrandInfo("Mucomix Oral", "Samarth Life Sciences Nepal", "Effervescent Tab", "600 mg"),
                BrandInfo("Fluimucil", "Zambon / Medisales Nepal", "Effervescent Tab", "600 mg"),
                BrandInfo("Mucnac", "Zydus Nepal", "Tab", "600 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Fluimucil", "Zambon", "Tab", "600 mg"),
                BrandInfo("Mucomix", "Samarth", "Tab", "600 mg")
            ),
            adultDose = "600 mg PO effervescent tablet dissolved in water once daily.",
            childDose = "Children 2-6 yr: 100 mg PO TID; >6 yr: 200 mg PO TID.",
            contraindications = "Active peptic ulcer disease (may disrupt gastric mucosal mucus barrier), severe uncontrolled asthma.",
            modeOfAction = "Free sulfhydryl groups (-SH) chemically disrupt and reduce disulfide bonds (-S-S-) in mucin glycoproteins, reducing mucus viscosity and facilitating mucociliary expectoration.",
            therapeuticClassTag = "Mucolytics / Antioxidants"
        ),

        // ==========================================
        // CARDIOVASCULAR & LIPIDOLOGY
        // ==========================================
        Drug(
            id = "d_cardio2_prazosin",
            genericName = "Prazosin Hydrochloride",
            system = "Cardiovascular System (CVS)",
            drugClass = "Selective Peripheral Alpha-1 Adrenoceptor Antagonist",
            blackBoxWarning = null,
            indications = "Severe refractory hypertension, Benign Prostatic Hyperplasia (BPH), Post-Traumatic Stress Disorder (PTSD)-related nightmares and sleep disturbance, Raynaud's phenomenon, scorpion sting autonomic storm.",
            doses = "Hypertension / BPH: Start 0.5-1 mg PO at bedtime (first-dose phenomenon); titrate to 2-5 mg PO BID or TID (max 20 mg/day). PTSD Nightmares: Start 1 mg PO at bedtime; titrate by 1-2 mg up to 5-15 mg at bedtime.",
            administration = "Take orally with a glass of water. Give the very first dose strictly at bedtime.",
            timing = "Bedtime (first dose and titration steps) to avoid first-dose syncope.",
            specialInstructions = "FIRST-DOSE SYNCOPE: Can cause severe sudden orthostatic hypotension and syncope within 30-90 minutes of the first dose. Patient must lie down after taking the initial dose.",
            pkPd = "Oral bioavailability ~60%. 97% protein bound. Extensively metabolized by liver. Elimination half-life 2-3 hours (biological effect lasts 8-10 hours).",
            renalAdj = "No dosage adjustment needed in renal failure.",
            hepaticAdj = "Use lower starting doses in severe cirrhosis.",
            pregnancy = "Category C (Methyldopa or labetalol preferred in pregnancy).",
            lactation = "Excreted in small amounts in breast milk; monitor infant.",
            sideEffects = "First-dose postural syncope, dizziness, palpitations, headache, drowsiness, peripheral edema, nasal congestion, priapism.",
            priceNpr = "NPR 45.00 - 110.00 per strip of 10 (1mg / 2mg / 5mg XL)",
            priceInr = "INR 30.00 - 75.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Minipress XL", "Pfizer Nepal", "Tab", "2.5 mg / 5 mg XL"),
                BrandInfo("Prazopress", "Sun Pharma Nepal", "Tab", "1 mg / 2 mg / 5 mg XL")
            ),
            brandsIndia = listOf(
                BrandInfo("Minipress XL", "Pfizer India", "Tab", "2.5 / 5 mg"),
                BrandInfo("Prazopress", "Sun Pharma", "Tab", "1 / 2 / 5 mg")
            ),
            adultDose = "1-5 mg PO BID-TID (or 2.5-5 mg XL once daily at bedtime).",
            childDose = "0.05-0.1 mg/kg/day PO divided TID.",
            contraindications = "Hypersensitivity to quinazolines; concurrent phosphodiesterase-5 inhibitors (sildenafil) due to profound hypotension risk.",
            modeOfAction = "Selectively blocks postsynaptic alpha-1 adrenergic receptors on vascular smooth muscle, causing both arterial and venous vasodilation without reflex tachycardia (preserves presynaptic alpha-2 feedback).",
            therapeuticClassTag = "Anti-HTN / Alpha-blockers"
        ),

        Drug(
            id = "d_cardio2_ranolazine",
            genericName = "Ranolazine",
            system = "Cardiovascular System (CVS)",
            drugClass = "Late Inward Sodium Current (INa) Inhibitor Antianginal",
            blackBoxWarning = null,
            indications = "Chronic stable angina pectoris inadequately controlled with or intolerant to first-line agents (beta-blockers, calcium channel blockers, nitrates).",
            doses = "Adult: Start 500 mg PO twice daily; may titrate to 1000 mg PO twice daily based on clinical symptoms.",
            administration = "Swallow extended-release tablets whole with or without food. Do not chew, break, or crush tablets.",
            timing = "Twice daily with morning and evening meals.",
            specialInstructions = "HEMODYNAMICALLY NEUTRAL: Relieves myocardial ischemia without lowering heart rate or blood pressure. Causes dose-dependent QTc prolongation (average 6-15 msec); monitor baseline ECG.",
            pkPd = "Oral bioavailability 75%. Extensively metabolized in liver primarily by CYP3A4 and to a lesser extent CYP2D6. Elimination half-life ~7 hours.",
            renalAdj = "CrCl <30 mL/min: Monitor renal function and blood pressure closely.",
            hepaticAdj = "Moderate or severe hepatic impairment: CONTRAINDICATED (Child-Pugh B or C).",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Safety in breastfeeding not established.",
            sideEffects = "Dizziness, headache, constipation, nausea, asthenia, QTc interval prolongation.",
            priceNpr = "NPR 110.00 - 240.00 per strip of 10 (500mg / 1000mg)",
            priceInr = "INR 75.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Rancad", "Sun Pharma Nepal", "Tab", "500 mg / 1000 mg"),
                BrandInfo("Ranexa", "Gilead / Medisales Nepal", "Tab", "500 mg / 1000 mg"),
                BrandInfo("Ranolaz", "Torrent Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Rancad", "Sun Pharma", "Tab", "500 / 1000 mg"),
                BrandInfo("Ranexa", "Menarini", "Tab", "500 mg")
            ),
            adultDose = "500-1000 mg PO BID.",
            contraindications = "Pre-existing QTc prolongation, concurrent strong CYP3A4 inhibitors (ketoconazole, clarithromycin) or inducers (rifampin, carbamazepine), moderate-to-severe hepatic impairment.",
            modeOfAction = "Selectively inhibits the late inward sodium current (INa) in ischemic myocardial cells, preventing intracellular sodium accumulation, reducing reverse Na+/Ca2+ exchange and calcium overload, improving diastolic wall relaxation and coronary perfusion.",
            therapeuticClassTag = "Anti-anginal / Metabolic"
        ),

        Drug(
            id = "d_cardio2_fenofibrate",
            genericName = "Fenofibrate (Micronized / Nanocrystal)",
            system = "Cardiovascular System (CVS)",
            drugClass = "Fibric Acid Derivative (PPAR-alpha Agonist)",
            blackBoxWarning = null,
            indications = "Severe hypertriglyceridemia (serum triglycerides >= 500 mg/dL / 5.7 mmol/L) to prevent acute pancreatitis, mixed dyslipidemia as adjunct to statin therapy in high-risk patients.",
            doses = "Micronized: 160 mg or 200 mg PO once daily. Nanocrystal formulation (Tricor): 145 mg PO once daily.",
            administration = "Take orally once daily with food to maximize absorption (nanocrystal 145 mg formulation can be taken with or without food).",
            timing = "Once daily with evening meal.",
            specialInstructions = "DRUG OF CHOICE FOR SEVERE HYPERTRIGLYCERIDEMIA: Reduces triglycerides by 30-55% and increases HDL-C by 10-20%. Safest fibrate to combine with statins (unlike gemfibrozil, fenofibrate does NOT inhibit statin glucuronidation via UGT1A1/1A3, carrying much lower rhabdomyolysis risk).",
            pkPd = "Prodrug rapidly converted to active fenofibric acid by tissue esterases. 99% bound to plasma albumin. Excreted primarily via kidneys (60% as glucuronide). Elimination half-life ~20 hours.",
            renalAdj = "Mild-to-moderate renal impairment (CrCl 30-59 mL/min): Start 48-54 mg daily. Severe renal impairment (CrCl <30 mL/min): CONTRAINDICATED.",
            hepaticAdj = "Contraindicated in active liver disease.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Contraindicated during breastfeeding.",
            sideEffects = "Reversible rise in serum creatinine (10-15% due to inhibition of tubular creatinine secretion), cholelithiasis (gallstones), elevated transaminases, myalgia, dyspepsia.",
            priceNpr = "NPR 80.00 - 170.00 per strip of 10 (145mg / 160mg / 200mg)",
            priceInr = "INR 55.00 - 120.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Lipicard", "Sun Pharma Nepal", "Tab", "145 mg / 160 mg / 200 mg"),
                BrandInfo("Tricor", "Abbott Nepal", "Tab", "145 mg"),
                BrandInfo("Stanlip", "Ranbaxy / Sun Pharma", "Tab", "145 mg / 160 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lipicard", "Sun Pharma", "Tab", "145 / 160 / 200 mg"),
                BrandInfo("Stanlip", "Sun Pharma", "Tab", "145 mg")
            ),
            adultDose = "145 mg or 160 mg PO once daily with meals.",
            contraindications = "Severe renal impairment (CrCl <30 mL/min), active liver disease, pre-existing gallbladder disease, nursing mothers.",
            modeOfAction = "Activates peroxisome proliferator-activated receptor-alpha (PPAR-alpha), upregulating lipoprotein lipase (LPL) and apolipoprotein A-I/A-II, while downregulating apo C-III, dramatically enhancing triglyceride clearance.",
            therapeuticClassTag = "Lipid-lowering / Fibrates"
        ),

        Drug(
            id = "d_cardio2_cilostazol",
            genericName = "Cilostazol",
            system = "Cardiovascular System (CVS)",
            drugClass = "Phosphodiesterase-3 (PDE-3) Inhibitor Antiplatelet & Vasodilator",
            blackBoxWarning = "HEART FAILURE CONTRAINDICATION: Cilostazol and several other PDE-3 inhibitors have caused decreased survival in patients with congestive heart failure. CONTRAINDICATED in patients with heart failure of any severity.",
            indications = "Reduction of symptoms of intermittent claudication in peripheral arterial disease (PAD) to increase maximal pain-free walking distance, secondary prevention of non-cardioembolic ischemic stroke.",
            doses = "Adult: 100 mg PO twice daily taken at least 30 minutes before or 2 hours after breakfast and dinner (50 mg PO BID if co-administered with CYP3A4/CYP2C19 inhibitors).",
            administration = "Take on an empty stomach (at least 30 minutes before or 2 hours after meals). A high-fat meal increases absorption and peak levels, increasing adverse effects.",
            timing = "Twice daily on an empty stomach.",
            specialInstructions = "STRICT CONTRAINDICATION IN ANY STAGE OF HEART FAILURE. Therapeutic benefit takes 2 to 4 weeks to become clinically apparent, with maximum improvement achieved at 12 weeks.",
            pkPd = "Well absorbed. Highly bound to albumin (95-98%). Metabolized by CYP3A4 and CYP2C19 to active 3,4-dehydrocilostazol. Elimination half-life ~11-13 hours.",
            renalAdj = "CrCl <25 mL/min: Use with caution.",
            hepaticAdj = "Moderate-to-severe hepatic impairment: Contraindicated.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Excreted in animal milk; contraindicated during breastfeeding.",
            sideEffects = "Headache (>30%), palpitations, tachycardia, diarrhea, dizziness, peripheral edema, dyspepsia.",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (50mg / 100mg)",
            priceInr = "INR 70.00 - 150.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Pletoz", "Cipla Nepal", "Tab", "50 mg / 100 mg"),
                BrandInfo("Pletal", "Otsuka / Medisales Nepal", "Tab", "50 mg / 100 mg"),
                BrandInfo("Stiloz", "Torrent Pharmaceuticals", "Tab", "50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pletoz", "Cipla", "Tab", "50 / 100 mg"),
                BrandInfo("Stiloz", "Torrent", "Tab", "50 / 100 mg")
            ),
            adultDose = "100 mg PO BID on empty stomach.",
            contraindications = "Congestive heart failure of any severity, active pathological bleeding (peptic ulcer, intracranial hemorrhage), history of ventricular tachycardia or fibrillation, severe hepatic impairment.",
            modeOfAction = "Inhibits phosphodiesterase-3 (PDE-3), preventing breakdown of cyclic AMP (cAMP) in platelets and vascular smooth muscle, suppressing platelet aggregation and producing arterial vasodilation.",
            therapeuticClassTag = "Peripheral Vascular / Antiplatelets"
        )
    )
}
