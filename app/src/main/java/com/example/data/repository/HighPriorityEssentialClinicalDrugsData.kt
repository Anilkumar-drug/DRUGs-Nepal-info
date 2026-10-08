package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object HighPriorityEssentialClinicalDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // 1. LORAZEPAM
        // ==========================================
        Drug(
            id = "d_essential_lorazepam",
            genericName = "Lorazepam",
            system = "Central Nervous System (CNS)",
            drugClass = "Intermediate-Acting Benzodiazepine Anticonvulsant & Anxiolytic",
            blackBoxWarning = "CONCOMITANT USE WITH OPIOIDS, ABUSE, MISUSE, ADDICTION, DEPENDENCE & WITHDRAWAL: Concomitant use of benzodiazepines and opioids may result in profound sedation, respiratory depression, coma, and death. Discontinuation can precipitate life-threatening acute withdrawal reactions (seizures). Taper gradually.",
            indications = "First-line termination of Status Epilepticus (IV gold standard), acute severe anxiety and panic attacks, procedural sedation and pre-operative medication, acute alcohol withdrawal syndrome (preferred in hepatic impairment / cirrhosis).",
            doses = "Status Epilepticus: Adult: 4 mg slow IV (at rate not exceeding 2 mg/min); if seizures persist after 5-10 minutes, repeat 4 mg IV once (max 8 mg).\nPediatric Status Epilepticus: 0.1 mg/kg slow IV over 2 min (max single dose 4 mg); may repeat once at 5-10 min.\nAcute Severe Anxiety / Agitation: 1 to 2 mg PO BID to TID (or 1-2 mg IM).\nInsomnia with Anxiety: 1 to 2 mg PO once daily at bedtime.\nPre-operative Sedation: 2 to 4 mg PO or 0.05 mg/kg IM/IV 2 hours pre-procedure.",
            administration = "IV Push: Dilute 1:1 with compatible diluent (Normal Saline or D5W) to reduce venous irritation; inject slowly at rate <= 2 mg/min. Oral: Take with or without food. Sublingual: Place under tongue for rapid absorption in acute panic.",
            timing = "Divided daily doses or stat for seizures / procedural sedation.",
            specialInstructions = "NEPAL DDA SCHEDULE 'KA' (नियन्त्रित मनोद्विपक औषधि / Controlled Psychotropic Medicine) - Requires narcotic prescription register. LOT MNEMONIC: Lorazepam, Oxazepam, and Temazepam undergo direct glucuronidation without active metabolites and are preferred in elderly patients or patients with acute/chronic hepatic cirrhosis.",
            pkPd = "Oral bioavailability ~90%. Peak plasma concentration in 1.5-2 hours. Protein binding ~85%. Metabolized directly via hepatic glucuronidation to inactive lorazepam-glucuronide (NO active metabolites, NO CYP dependence). Elimination half-life: 10-20 hours. Renal excretion of inactive glucuronide.",
            renalAdj = "No initial oral dose adjustment required; avoid prolonged continuous IV infusion in renal failure due to risk of propylene glycol vehicle accumulation and metabolic acidosis.",
            hepaticAdj = "PREFERRED BENZODIAZEPINE IN LIVER DISEASE: Because it does not rely on CYP450 phase I oxidation, clearance is minimally altered in mild-to-moderate cirrhosis. Use lowest effective dose in severe hepatic failure to avoid worsening encephalopathy.",
            pregnancy = "Category D (Contraindicated in first trimester due to oral clefts; third-trimester exposure causes neonatal hypotonia, hypothermia, respiratory depression, and withdrawal).",
            lactation = "Excreted in human breast milk in low concentrations; monitor infant for drowsiness and poor suckling. Use with caution.",
            sideEffects = "Sedation, drowsiness, respiratory depression, ataxia, unsteadiness, anterograde amnesia, confusion, hypotension, paradoxical disinhibition in elderly.",
            priceNpr = "NPR 25.00 - 55.00 per strip of 10 (1 mg / 2 mg) / NPR 35.00 per 2mg/mL ampoule",
            priceInr = "INR 18.00 - 40.00 per strip of 10 / INR 25.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Ativan", "Pfizer / Medisales Nepal", "Tab / Inj", "1 mg / 2 mg / 2mg/mL"),
                BrandInfo("Trapex", "Sun Pharma Nepal", "Tab / Inj", "1 mg / 2 mg / 2mg/mL"),
                BrandInfo("Lopez", "Torrent / Medisales Nepal", "Tab", "1 mg / 2 mg"),
                BrandInfo("Calmese", "Zydus Nepal", "Tab", "1 mg / 2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ativan", "Pfizer India", "Tab / Inj", "1 mg / 2 mg / 2mg/mL"),
                BrandInfo("Trapex", "Sun Pharma", "Tab / Inj", "1 mg / 2 mg / 2mg/mL"),
                BrandInfo("Lopez", "Torrent Pharmaceuticals", "Tab", "1 mg / 2 mg"),
                BrandInfo("Lorzem", "Alkem Laboratories", "Tab", "1 mg / 2 mg")
            ),
            pediatricDosePerKg = 0.1,
            pediatricInterval = "mg/kg slow IV push over 2 min (max 4 mg) for status epilepticus",
            adultDose = "Status epilepticus: 4 mg slow IV push. Anxiety: 1-2 mg PO BID-TID.",
            childDose = "0.05-0.1 mg/kg IV push over 2 min for acute seizures.",
            contraindications = "Myasthenia gravis, severe respiratory depression or acute respiratory failure, acute narrow-angle glaucoma, severe hepatic failure, sleep apnea.",
            modeOfAction = "Allosteric modulator of GABAA receptor chloride channel macromolecular complex, increasing frequency of channel opening in response to GABA, producing generalized neuronal inhibition.",
            precautions = "BEERS CRITERIA HIGH RISK in elderly: Increases fall risk, hip fractures, and cognitive decline. If benzodiazepine is mandatory, lorazepam is preferred over long-acting agents due to shorter half-life and absence of active metabolites.",
            nemlCategory = "Nepal Essential Medicines List (Anticonvulsants & Emergency Formulary)",
            ddaSchedule = "Schedule 'Ka' (क वर्ग - Controlled Drug)",
            beersCriteriaRisk = "HIGH RISK: Avoid in older adults unless indicated for seizure disorders or alcohol withdrawal; causes prolonged sedation, ataxia, severe falls, and delirium.",
            counselingNepali = "यो औषधि छारेरोगको आक्रमण रोक्न तथा अत्याधिक डर-चिन्ता कम गर्न प्रयोग गरिन्छ। औषधि खाएपछि निन्द्रा लाग्ने र सन्तुलन गुम्न सक्ने हुनाले गाडी नचलाउनुहोस्। डाक्टरको सल्लाह बिना अचानक औषधि खान नछोड्नुहोस्। रक्सी वा अन्य नशालु औषधिसँग यो औषधि कहिल्यै नलिनुहोस्।",
            counselingEnglish = "Indicated for acute seizure termination and severe anxiety. Causes marked drowsiness and unsteadiness; avoid driving or operating hazardous machinery. Never consume alcohol while taking this medicine. Do not discontinue abruptly to prevent withdrawal seizures.",
            era = "Older / Classical (Synthesized 1963, Wyeth)",
            therapeuticClassTag = "Anticonvulsant / Anxiolytic / Benzodiazepine",
            researchNotes = "Gold standard #1 first-line drug for status epilepticus termination per Neurocritical Care Society and AES guidelines."
        ),

        // ==========================================
        // 2. MORPHINE SULFATE
        // ==========================================
        Drug(
            id = "d_essential_morphine",
            genericName = "Morphine Sulfate",
            system = "Central Nervous System (CNS)",
            drugClass = "Prototype Pure Opioid Receptor Agonist Analgesic",
            blackBoxWarning = "ADDICTION, ABUSE, MISUSE, LIFE-THREATENING RESPIRATORY DEPRESSION, ACCIDENTAL INGESTION & CONCOMITANT USE WITH BENZODIAZEPINES: Serious, life-threatening, or fatal respiratory depression may occur. Concomitant use with benzodiazepines causes profound sedation, coma, and death. Prescribe only with strict inventory control.",
            indications = "Severe acute pain (major trauma, post-operative, burns), acute pain in myocardial infarction (STEMI / NSTEMI), acute cardiogenic pulmonary edema (reduces preload and dyspneic anxiety), chronic cancer pain (WHO analgesic ladder Step 3 gold standard), palliative end-of-life dyspnea.",
            doses = "Acute Severe Pain / STEMI (IV):\n• Adult: 2 to 5 mg slow IV push every 5 to 15 minutes titrated to pain relief and respiratory rate >= 10-12/min.\n• Subcutaneous / Intramuscular: 5 to 10 mg SC/IM every 3 to 4 hours PRN.\nOral Acute Pain (Immediate-Release):\n• 10 to 30 mg PO every 4 hours PRN.\nChronic Cancer Pain (Sustained-Release / Morcontin):\n• Titrate initial dose from 24-hour immediate-release requirements; administer 15 to 60 mg PO q12h (swallow whole, never crush).\nPediatric Severe Pain:\n• 0.05 to 0.1 mg/kg slow IV push over 5 min (max single dose 2-4 mg).",
            administration = "IV Push: Dilute with sterile water or Normal Saline to 1-2 mg/mL; inject slowly over 4-5 minutes. Always maintain Naloxone (0.4 mg/mL) and bag-valve-mask ventilatory support immediately available at bedside. Never crush, chew, or split sustained-release tablets (Morcontin).",
            timing = "Every 4 hours (immediate release) or every 12 hours (sustained release).",
            specialInstructions = "NEPAL DDA SCHEDULE 'KA' (लागु तथा मनोद्विपक औषधि / Controlled Narcotic Medicine) - Strict double-locked storage, dual-signature nursing verification, and legal narcotic register entry required. Always co-prescribe a stimulating laxative (e.g. Bisacodyl or Senna) from day 1 for opioid-induced constipation. Active metabolite Morphine-6-glucuronide (M6G) accumulates in renal failure; active metabolite Morphine-3-glucuronide (M3G) causes neurotoxicity / hyperalgesia.",
            pkPd = "Oral bioavailability ~25-40% due to extensive first-pass hepatic metabolism. Onset: IV 5-10 min, oral 30 min. Peak analgesia: IV 20 min, oral 60 min. Metabolized by hepatic glucuronidation (UGT2B7) to M3G (inactive/neurotoxic) and M6G (potent analgesic). Elimination half-life ~2-3 hours. Renal excretion.",
            renalAdj = "CrCl 10-50 mL/min: Reduce dose by 25-50% and extend interval. CrCl <10 mL/min: Reduce dose by 50-75% or avoid; M6G and M3G accumulate causing profound narcosis, prolonged respiratory arrest, and myoclonus. Fentanyl preferred in severe renal failure.",
            hepaticAdj = "Mild-to-moderate impairment: Reduce dose and increase dosing interval. Severe hepatic impairment / cirrhosis: Use with extreme caution; decreased first-pass metabolism doubles bioavailability and precipitates hepatic encephalopathy.",
            pregnancy = "Category C (Category D with prolonged use or high doses near term; causes neonatal opioid withdrawal syndrome [NOWS] requiring neonatal NICU tapering).",
            lactation = "Excreted into breast milk in small amounts; monitor infant for excessive sleepiness, limpness, and respiratory pause. Use lowest effective dose.",
            sideEffects = "Respiratory depression, sedation, constipation (nearly universal), nausea, vomiting, pruritus/urticaria (histamine release), miosis (pinpoint pupils), urinary retention, biliary spasm (Sphincter of Oddi contraction), hypotension, physical dependence.",
            priceNpr = "NPR 35.00 - 80.00 per strip of 10 (10mg / 30mg) / NPR 18.00 - 30.00 per 10mg/mL ampoule",
            priceInr = "INR 25.00 - 60.00 per strip of 10 / INR 15.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Morcontin", "Modi-Mundipharma / Nepal", "CR Tablet", "10 mg / 30 mg / 60 mg"),
                BrandInfo("Vermor", "Troikaa / Medisales Nepal", "Tablet / Inj", "10 mg / 30 mg / 10mg/mL"),
                BrandInfo("Morphine Sulphate Inj", "Government Central Medical Store", "Injection", "10 mg/mL / 15 mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Morcontin", "Modi-Mundipharma India", "CR Tablet", "10 / 30 / 60 mg"),
                BrandInfo("Vermor", "Troikaa Pharmaceuticals", "Tablet / Inj", "10 / 30 mg / 10mg/mL"),
                BrandInfo("R-Morph", "Rusoma Laboratories", "Injection", "10 mg/mL / 15 mg/mL")
            ),
            pediatricDosePerKg = 0.1,
            pediatricInterval = "mg/kg slow IV push over 5 min (max 4 mg) for severe trauma/burns",
            adultDose = "2-5 mg slow IV push titrated q10-15min. Oral: 10-30 mg PO q4h.",
            childDose = "0.05-0.1 mg/kg slow IV push over 5 min.",
            contraindications = "Acute severe respiratory depression, acute or severe bronchial asthma in unmonitored settings, gastrointestinal obstruction (paralytic ileus), severe head injury with raised intracranial pressure (masks pupillary signs and causes CO2 retention), concurrent MAO inhibitor use within 14 days.",
            modeOfAction = "Selectively binds to and stimulates central and spinal mu-opioid (MOR) receptors, coupled to Gi/Go proteins, inhibiting adenylate cyclase, closing N-type voltage-gated calcium channels, and opening inwardly rectifying potassium channels, hyperpolarizing pain transmission pathways.",
            precautions = "BEERS CRITERIA HIGH RISK: Severe risk of falls, delirium, respiratory failure, and severe constipation in older adults. Naloxone is the specific competitive antagonist for overdose (0.04-0.4 mg IV repeated q2-3min).",
            nemlCategory = "Nepal Essential Medicines List (Palliative Care & Severe Analgesics)",
            ddaSchedule = "Schedule 'Ka' (क वर्ग - Narcotic Controlled Drug)",
            beersCriteriaRisk = "HIGH RISK: Severe fall, delirium, and bowel impaction risk in older adults. Always co-prescribe bowel regimen.",
            counselingNepali = "यो कडा दुखाइ कम गर्ने विशेष लागु औषधि हो। यो औषधि खाएपछि झुमझुम लाग्ने, निन्द्रा लाग्ने र दिसा कब्जियत हुने हुनाले प्रशस्त पानी पिउनुहोस् र दिसा खुकुलो बनाउने औषधि साथमा लिनुहोस्। डाक्टरले तोकेको मात्राभन्दा बढी कहिल्यै नलिनुहोस्। यो औषधि सुरक्षित स्थानमा ताल्चा लगाएर राख्नुहोस्।",
            counselingEnglish = "Potent opioid analgesic prescribed for severe pain. Causes significant drowsiness and constipation; drink plenty of fluids and use a prescribed stool softener. Never exceed the prescribed dose or chew sustained-release tablets. Keep securely locked away from children.",
            era = "Older / Classical (Isolated by Friedrich Sertürner in 1804)",
            therapeuticClassTag = "Pure Opioid Analgesic / WHO Step 3",
            researchNotes = "Gold standard against which all other opioid analgesics are benchmarked (equianalgesic conversion ratio 1.0)."
        ),

        // ==========================================
        // 3. CLOZAPINE
        // ==========================================
        Drug(
            id = "d_essential_clozapine",
            genericName = "Clozapine",
            system = "Central Nervous System (CNS)",
            drugClass = "Second-Generation (Atypical) Dibenzodiazepine Antipsychotic",
            blackBoxWarning = "SEVERE NEUTROPENIA (AGRANULOCYTOSIS), ORTHOSTATIC HYPOTENSION/SYNCOPE, SEIZURES, MYOCARDITIS/CARDIOMYOPATHY & INCREASED MORTALITY IN ELDERLY WITH DEMENTIA: Clozapine causes severe, potentially fatal agranulocytosis (ANC <500/mcL in 1-2%). Absolute Neutrophil Count (ANC) monitoring is MANDATORY prior to initiation and regularly throughout therapy. Fatal myocarditis can occur, predominantly within the first 6 weeks.",
            indications = "Treatment-resistant schizophrenia (failure of at least two adequate trials of different antipsychotics including one second-generation agent), recurrent suicidal behavior in schizophrenia or schizoaffective disorder, severe psychosis/tremor in Parkinson's disease unresponsive to other agents.",
            doses = "Adult Treatment-Resistant Schizophrenia:\n• Initial: 12.5 mg PO once or twice daily on Day 1; 25 mg once or twice on Day 2.\n• Titration: Increase daily dosage by 25 to 50 mg/day, if tolerated, to target 300 to 450 mg/day divided BID by end of Week 2 to 3.\n• Maintenance: 300 to 600 mg/day divided BID (maximum 900 mg/day).\nParkinson's Disease Psychosis:\n• Start 6.25 to 12.5 mg PO at bedtime; slow titration to 25 to 50 mg/day (rarely exceeds 100 mg/day).",
            administration = "Take orally with or without food. If therapy is interrupted for >= 48 hours, re-initiate at 12.5 mg once or twice daily and re-titrate to prevent severe hypotension and syncope.",
            timing = "Divided doses BID with larger portion at bedtime to minimize daytime sedation.",
            specialInstructions = "MANDATORY ANC MONITORING PROTOCOL: Baseline ANC must be >= 1500/mcL (>= 1000/mcL in Benign Ethnic Neutropenia [BEN]). Monitor ANC WEEKLY for the first 6 months, every 2 weeks for months 6-12, and monthly thereafter. If ANC <1000/mcL, interrupt therapy immediately and consult hematology. Check troponin and CRP weekly during first 6 weeks for myocarditis. Severe hypersalivation (sialorrhea) is common; treat with sublingual atropine drops or ipratropium spray.",
            pkPd = "Oral bioavailability 50-60%. Peak plasma concentration in 1.5-2.5 hours. Protein binding 97%. Extensively metabolized in the liver primarily by CYP1A2, and to a lesser extent CYP2D6 and CYP3A4, into active norclozapine (desmethylclozapine). Tobacco smoking induces CYP1A2, drastically reducing clozapine levels (quitting smoking causes clozapine toxicity). Half-life ~12-16 hours.",
            renalAdj = "Mild-to-moderate: No dose adjustment needed. Severe renal impairment: Use with extreme caution and initiate at lower doses.",
            hepaticAdj = "Mild-to-moderate impairment: Initiate at 12.5 mg/day and titrate slowly. Severe hepatic impairment: Contraindicated; monitor LFTs regularly.",
            pregnancy = "Category B (Safe compared to other antipsychotics; risk of maternal gestational diabetes and fetal macrosomia; monitor neonate for extrapyramidal signs).",
            lactation = "Contraindicated; excreted in breast milk; causes significant sedation, agranulocytosis, and cardiovascular instability in nursing infants.",
            sideEffects = "Hypersalivation (sialorrhea, 30-50%), extreme sedation, weight gain, metabolic syndrome, constipation (can cause fatal gastrointestinal hypomotility / bowel infarction), tachycardia, orthostatic hypotension, seizures (dose-dependent, 5% at >600 mg/day), agranulocytosis, myocarditis.",
            priceNpr = "NPR 110.00 - 280.00 per strip of 10 (25mg / 100mg)",
            priceInr = "INR 70.00 - 180.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Sizopin", "Sun Pharma Nepal", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Lozapin", "Torrent / Medisales Nepal", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Skizoril", "Intas / Nepal Pharmaceuticals", "Tablet", "25 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Sizopin", "Sun Pharma", "Tablet", "25 / 50 / 100 mg"),
                BrandInfo("Lozapin", "Torrent Pharmaceuticals", "Tablet", "25 / 50 / 100 mg"),
                BrandInfo("Skizoril", "Intas Pharmaceuticals", "Tablet", "25 / 100 mg")
            ),
            adultDose = "Start 12.5-25 mg PO daily, titrate to 300-450 mg/day divided BID (max 900 mg/day).",
            childDose = "Safety and efficacy not established in pediatric patients under 18 years.",
            contraindications = "History of clozapine-induced agranulocytosis or severe granulocytopenia, bone marrow disorders, uncontrolled epilepsy, severe CNS depression, paralytic ileus, severe cardiovascular disease / active myocarditis.",
            modeOfAction = "Weak antagonist at dopamine D2 receptors (sparing nigrostriatal pathway and causing virtually zero extrapyramidal symptoms or prolactin elevation), with potent antagonism at serotonin 5-HT2A, 5-HT2C, alpha-1 adrenergic, histamine H1, and muscarinic M1 receptors.",
            precautions = "CONSTIPATION WARNING: Clozapine-induced gastrointestinal hypomotility causes severe obstipation, ileus, and fatal bowel necrosis. Proactively prescribe laxatives and high-fiber intake.",
            nemlCategory = "Nepal Essential Medicines List (Specialist Psychiatric Formulary)",
            ddaSchedule = "Schedule 'Kha' (Specialist Prescription Only)",
            beersCriteriaRisk = "HIGH RISK: Severe anticholinergic, orthostatic, fall, and seizure risk in elderly. Reserved exclusively for severe refractory Parkinson's psychosis.",
            counselingNepali = "यो कडा मानसिक रोग (स्किजोफ्रेनिया) को लागि प्रयोग गरिने विशेष औषधि हो। यो औषधि खाँदा रगतको जाँच (CBC / Neutrophils) नियमित रूपमा गराउनु अनिवार्य हुन्छ। ज्वरो आउने, घाँटी दुख्ने, धेरै थुक आउने वा दिसा कब्जियत हुने समस्या देखिएमा तुरुन्त डाक्टरलाई सम्पर्क गर्नुहोस्। चुरोट पिउने बानी परिवर्तन गर्दा औषधिको मात्रा मिलाउनुपर्छ।",
            counselingEnglish = "Specialist antipsychotic for treatment-resistant schizophrenia. Regular complete blood count (ANC) testing is mandatory throughout treatment. Promptly report any sore throat, fever, signs of infection, or severe constipation. Never stop taking clozapine abruptly.",
            era = "Classical Second-Generation Antipsychotic (First Atypical Synthesized in 1958)",
            therapeuticClassTag = "Atypical Antipsychotic / Refractory Schizophrenia",
            researchNotes = "Single most effective antipsychotic in clinical medicine for refractory schizophrenia; reduces all-cause mortality and suicide by >60%."
        ),

        // ==========================================
        // 4. FLUOXETINE
        // ==========================================
        Drug(
            id = "d_essential_fluoxetine",
            genericName = "Fluoxetine Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Selective Serotonin Reuptake Inhibitor (SSRI) Antidepressant",
            blackBoxWarning = "SUICIDAL THOUGHTS AND BEHAVIORS: Antidepressants increased the risk of suicidal thinking and behavior in children, adolescents, and young adults (up to age 24) in short-term studies. Closely monitor for clinical worsening, agitation, and emergence of suicidality.",
            indications = "Major Depressive Disorder (MDD) in adults and pediatric patients >= 8 years, Obsessive-Compulsive Disorder (OCD), Bulimia Nervosa (FDA-approved gold standard high-dose), Panic Disorder with or without agoraphobia, Premenstrual Dysphoric Disorder (PMDD).",
            doses = "Major Depressive Disorder:\n• Adult: Start 20 mg PO once daily in the morning; if inadequate after 4-6 weeks, may increase by 10-20 mg/day (max 80 mg/day).\n• Pediatric (>= 8 yr): Start 10 mg PO once daily; may increase to 20 mg/day after 2-3 weeks.\nBulimia Nervosa (Gold Standard):\n• 60 mg PO once daily in the morning (start at 20 mg and titrate over 1-2 weeks).\nObsessive-Compulsive Disorder (OCD):\n• Start 20 mg PO daily; titrate up to 40 to 60 mg PO once daily in the morning.\nPanic Disorder:\n• Start 10 mg PO once daily for 1 week, then increase to 20 mg PO daily (max 60 mg/day).",
            administration = "Take orally once daily in the morning with or without food. Administer in the morning to prevent insomnia (activating SSRI).",
            timing = "Morning with breakfast.",
            specialInstructions = "EXTREMELY LONG HALF-LIFE: Fluoxetine elimination half-life is 2-4 days, and its active metabolite norfluoxetine has a half-life of 7 to 15 days. Consequently, fluoxetine has the LOWEST risk of SSRI discontinuation/withdrawal syndrome among all SSRIs. However, a 5-WEEK WASHOUT PERIOD is mandatory before starting an MAO inhibitor (unlike the standard 2-week washout for other SSRIs) to prevent fatal serotonin syndrome.",
            pkPd = "Oral bioavailability >90%. Peak plasma concentration in 6-8 hours. Highly protein bound (~95%). Metabolized in the liver by CYP2D6 into active norfluoxetine. Fluoxetine and norfluoxetine are potent CYP2D6 inhibitors (drastically elevates levels of Metoprolol, TCAs, Risperidone, and Codeine/Tamoxifen interactions). Excreted in urine (~60%) and feces (~15%).",
            renalAdj = "Mild-to-moderate impairment: No dose adjustment needed. Severe renal failure (CrCl <10 mL/min) or hemodialysis: Use lower dose or alternate-day dosing.",
            hepaticAdj = "Cirrhosis doubles elimination half-life of fluoxetine and norfluoxetine; use lower initial dose (e.g. 10-20 mg every other day) and titrate slowly.",
            pregnancy = "Category C (Generally avoided in 1st trimester due to small ventricular septal defect risk; persistent pulmonary hypertension of the newborn [PPHN] risk in 3rd trimester; Sertraline preferred in pregnancy).",
            lactation = "Excreted into breast milk at higher levels than sertraline; monitor infant for colic, irritability, and poor weight gain; Sertraline preferred in breastfeeding.",
            sideEffects = "Insomnia, anxiety/agitation (initial activating effect), nausea, diarrhea, anorexia, weight loss (initial), sexual dysfunction (delayed ejaculation, anorgasmia in 30-50%), tremor, dry mouth, hyponatremia (SIADH in elderly).",
            priceNpr = "NPR 35.00 - 85.00 per strip of 10 (20mg)",
            priceInr = "INR 25.00 - 60.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Flunil", "Sun Pharma Nepal", "Capsule", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Prodep", "Sun Pharma Nepal", "Capsule", "20 mg / 40 mg"),
                BrandInfo("Fludac", "Cadila Pharmaceuticals Nepal", "Capsule", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Prozac", "Eli Lilly India", "Capsule", "20 mg"),
                BrandInfo("Flunil", "Sun Pharma", "Capsule", "10 / 20 / 40 / 60 mg"),
                BrandInfo("Prodep", "Sun Pharma", "Capsule", "20 / 40 mg"),
                BrandInfo("Fludac", "Cadila Pharmaceuticals", "Capsule", "20 mg")
            ),
            pediatricDosePerKg = null,
            adultDose = "20-40 mg PO once daily in morning (max 80 mg/day; 60 mg for bulimia).",
            childDose = "Children >= 8 yr: 10-20 mg PO once daily.",
            contraindications = "Concurrent use of MAO inhibitors (requires 5-week washout post-fluoxetine), concurrent pimozide or thioridazine (causes fatal QT prolongation and ventricular arrhythmias via CYP2D6 inhibition).",
            modeOfAction = "Selectively and potently inhibits presynaptic serotonin reuptake transporter (SERT), increasing synaptic cleft serotonin (5-HT) concentrations and down-regulating inhibitory 5-HT1A autoreceptors.",
            precautions = "POTENT CYP2D6 INHIBITOR: Blocks conversion of tamoxifen into its active anti-cancer metabolite endoxifen (reduces breast cancer survival; avoid combination).",
            nemlCategory = "Nepal Essential Medicines List (Antidepressant Formulary)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "CAUTION IN ELDERLY: Risk of SIADH / hyponatremia and gastrointestinal bleeding (especially when combined with NSAIDs/Aspirin).",
            counselingNepali = "यो डिप्रेसन र अत्याधिक चिन्ता कम गर्ने औषधि हो। पूर्ण रूपमा प्रभाव देखिन २ देखि ४ हप्ता समय लाग्ने हुनाले औषधि नियमित सेवन गर्नुहोस्। निन्द्रा नलाग्ने हुनसक्ने भएकाले बिहान खानासँगै लिनुहोस्। सुरुका केही दिनहरूमा मनमा नकारात्मक वा आत्महत्याको सोच आएमा तुरुन्त डाक्टरलाई जानकारी गराउनुहोस्।",
            counselingEnglish = "SSRI antidepressant for depression, OCD, and bulimia. May take 2 to 4 weeks for full clinical benefit. Take in the morning with food to avoid insomnia. Promptly report any worsening anxiety, agitation, or emerging suicidal thoughts. Do not stop abruptly.",
            era = "Older / Classical SSRI Prototype (Synthesized by Eli Lilly in 1972)",
            therapeuticClassTag = "SSRI Antidepressant / Bulimia Gold Standard",
            researchNotes = "Longest half-life among all SSRIs; virtually self-tapering medication with the lowest discontinuation syndrome rate."
        ),

        // ==========================================
        // 5. PROPRANOLOL
        // ==========================================
        Drug(
            id = "d_essential_propranolol",
            genericName = "Propranolol Hydrochloride",
            system = "Cardiovascular System (CVS)",
            drugClass = "Non-Selective Beta-1 & Beta-2 Adrenergic Receptor Blocker",
            blackBoxWarning = "CARDIAC ISCHEMIA AFTER ABRUPT DISCONTINUATION: Abrupt cessation of beta-blockers in patients with coronary artery disease may result in severe exacerbation of angina, myocardial infarction, and ventricular arrhythmias. Taper gradually over 1 to 2 weeks.",
            indications = "Primary and secondary prophylaxis of Esophageal Variceal Bleeding in portal hypertension/cirrhosis (gold standard), Essential Tremor, Thyroid Storm / Thyrotoxic crisis (blocks peripheral T4 to T3 conversion), Migraine Prophylaxis, Performance Anxiety ('Stage Fright'), Hypertrophic Cardiomyopathy (HOCM), Supraventricular Tachyarrhythmias, Akathisia.",
            doses = "Portal Hypertension (Variceal Bleeding Prophylaxis):\n• Start 20 to 40 mg PO BID; titrate every 2-3 days to achieve a 20-25% reduction in resting heart rate or resting HR of 55-60 bpm (usual dose: 40-160 mg PO BID).\nEssential Tremor / Performance Anxiety:\n• Performance Anxiety: 10 to 40 mg PO single dose 30 to 60 minutes before speaking/performance.\n• Essential Tremor: 40 mg PO BID; titrate to 120 to 240 mg/day divided TID.\nThyroid Storm (Thyrotoxic Crisis):\n• 60 to 80 mg PO every 4 to 6 hours (or 1-3 mg slow IV q4h) until hyperadrenergic storm resolves.\nMigraine Prophylaxis:\n• Start 40 to 80 mg PO daily divided BID; maintenance 120 to 240 mg/day divided BID-TID.\nHypertension / Angina:\n• 40 to 80 mg PO BID (up to 160-320 mg/day).",
            administration = "Take orally with or immediately after meals (food enhances systemic bioavailability). Swallow sustained-release formulations whole.",
            timing = "Divided doses BID to QID (or once daily for extended-release TR formulations).",
            specialInstructions = "PORTAL HYPERTENSION GOAL: Target resting heart rate 55-60 bpm with systolic BP >= 90 mmHg. Highly lipophilic agent that easily crosses the blood-brain barrier (causes vivid dreams, nightmares, and depression). STRICTLY CONTRAINDICATED in asthma or severe COPD due to non-selective beta-2 bronchospasm.",
            pkPd = "Oral absorption >90%, but extensive first-pass hepatic metabolism results in bioavailability of ~25%. High lipophilicity with large volume of distribution and rapid CNS penetration. Metabolized by CYP2D6, CYP1A2, and glucuronidation. Elimination half-life: 3-5 hours (extended to 8-11h in chronic dosing).",
            renalAdj = "No initial dose adjustment required in renal impairment or hemodialysis; monitor for bradycardia and hypotension.",
            hepaticAdj = "Severe hepatic cirrhosis increases bioavailability by 2-3 fold due to reduced hepatic extraction; start with lower doses (10-20 mg BID) and titrate slowly.",
            pregnancy = "Category C (Crosses placenta; risk of fetal intrauterine growth restriction [IUGR], neonatal bradycardia, and hypoglycemia; Labetalol preferred in pregnancy).",
            lactation = "Excreted in human milk in low amounts; compatible with breastfeeding per AAP; monitor infant for bradycardia and lethargy.",
            sideEffects = "Bradycardia, hypotension, bronchospasm (severe in asthmatics), cold extremities (Raynaud's phenomenon), fatigue, insomnia, vivid dreams/nightmares, depression, masking of hypoglycemia symptoms (except diaphoresis) in diabetics, erectile dysfunction.",
            priceNpr = "NPR 15.00 - 45.00 per strip of 10 (10mg / 20mg / 40mg)",
            priceInr = "INR 10.00 - 30.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Ciplar", "Cipla Nepal", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Ciplar-LA", "Cipla Nepal", "Sustained Release", "40 mg / 80 mg"),
                BrandInfo("Betacap", "Sun Pharma Nepal", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Inderal", "Abbott Nepal / Piramal", "Tablet", "10 mg / 40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Ciplar", "Cipla Ltd.", "Tablet", "10 / 20 / 40 mg"),
                BrandInfo("Ciplar-LA", "Cipla Ltd.", "Capsule", "40 / 80 mg"),
                BrandInfo("Betacap", "Sun Pharma", "Tablet", "10 / 20 / 40 mg"),
                BrandInfo("Inderal", "Abbott India", "Tablet", "10 / 40 mg")
            ),
            adultDose = "Portal HTN: 20-80 mg PO BID. Tremor/Anxiety: 10-40 mg PO stat or BID.",
            childDose = "Infantile hemangioma: 1-3 mg/kg/day PO divided TID (specialist pediatric protocol).",
            contraindications = "Bronchial asthma or severe COPD with bronchospasm, sinus bradycardia (<50 bpm), second- or third-degree AV block, cardiogenic shock, decompensated heart failure, severe peripheral arterial disease, Prinzmetal's vasospastic angina.",
            modeOfAction = "Competitive non-selective beta-1 and beta-2 adrenergic receptor antagonist. Beta-1 blockade reduces heart rate and cardiac output; beta-2 blockade causes splanchnic vasoconstriction (unopposed alpha-1 action), decreasing portal venous inflow and reducing portal pressure.",
            precautions = "DIABETES PRECAUTION: Masks autonomic warning symptoms of hypoglycemia (tachycardia, tremor, anxiety), though diaphoresis (sweating) is typically preserved.",
            nemlCategory = "Nepal Essential Medicines List (Cardiovascular & Portal Hypertension)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "Use with caution in older adults; causes bradycardia, syncope, severe fatigue, and postural instability.",
            counselingNepali = "यो रक्तचाप, मुटुको धड्कन, हात काँप्ने समस्या तथा कलेजोको समस्यामा नशा फुटेर रगत बग्ने जोखिम कम गर्न प्रयोग गरिन्छ। दम (Asthma) का बिरामीले यो औषधि खानु हुँदैन। औषधि खाँदा चक्कर लाग्ने वा नाडीको गति धेरै सुस्त भएमा डाक्टरलाई खबर गर्नुहोस्। डाक्टरको सल्लाह बिना अचानक औषधि खान कहिल्यै नछोड्नुहोस्।",
            counselingEnglish = "Non-selective beta blocker for portal hypertension, tremor, and migraine prophylaxis. Contraindicated in asthma. Do not stop taking this medication abruptly, as rebound hypertension and cardiac events may occur. Inform doctor if your pulse drops below 50 bpm.",
            era = "Older / Classical Prototype Beta Blocker (Invented by Sir James Black, Nobel Prize 1988)",
            therapeuticClassTag = "Non-Selective Beta Blocker / Portal HTN Gold Standard",
            researchNotes = "Cornerstone of variceal hemorrhage prevention in cirrhosis (Baveno VII consensus guideline gold standard)."
        ),

        // ==========================================
        // 6. ATENOLOL
        // ==========================================
        Drug(
            id = "d_essential_atenolol",
            genericName = "Atenolol",
            system = "Cardiovascular System (CVS)",
            drugClass = "Cardioselective Beta-1 Adrenergic Receptor Antagonist",
            blackBoxWarning = "CARDIAC ISCHEMIA AFTER ABRUPT WITHDRAWAL: Do not discontinue therapy abruptly. Severe exacerbations of angina, myocardial infarction, and ventricular arrhythmias have been reported following sudden cessation. Taper over 1-2 weeks.",
            indications = "Essential Systemic Hypertension, Chronic Stable Angina Pectoris, Secondary Prevention Post-Myocardial Infarction, Rate control in Atrial Fibrillation / Atrial Flutter.",
            doses = "Hypertension:\n• Start 25 to 50 mg PO once daily; may increase to 100 mg PO once daily after 1-2 weeks if response is inadequate (doses >100 mg rarely confer additional benefit).\nChronic Stable Angina:\n• Start 50 mg PO once daily; may increase to 100 mg PO once daily (or 50 mg BID).\nPost-Myocardial Infarction:\n• 50 mg PO BID or 100 mg PO once daily for 1 to 3 years post-MI.\nRate Control in Atrial Fibrillation:\n• 25 to 100 mg PO once daily.",
            administration = "Take orally once daily with water. Food does not significantly affect absorption.",
            timing = "Morning at the same time each day.",
            specialInstructions = "HYDROPHILIC BETA BLOCKER: Unlike propranolol or metoprolol, atenolol is hydrophilic with minimal blood-brain barrier penetration (significantly fewer nightmares, vivid dreams, and central depressive side effects). Cleared almost entirely unchanged by the kidneys; mandatory dose adjustment in renal impairment.",
            pkPd = "Oral bioavailability ~50%. Peak plasma concentration in 2-4 hours. Minimal protein binding (6-16%). Negligible hepatic metabolism. Excreted >85% unchanged in urine via glomerular filtration and tubular secretion. Elimination half-life: 6-7 hours (extended up to 16-27 hours in severe renal failure).",
            renalAdj = "CrCl 15-35 mL/min: Maximum dose 50 mg PO daily. CrCl <15 mL/min: Maximum dose 25 mg PO daily (or 50 mg every other day). Hemodialysis: 25-50 mg after each dialysis session under hospital monitoring.",
            hepaticAdj = "No dose adjustment required (minimal hepatic metabolism).",
            pregnancy = "Category D (Contraindicated; associated with significant fetal growth restriction / low birth weight throughout all trimesters; Labetalol or Nifedipine preferred).",
            lactation = "Excreted and concentrates in breast milk (milk-to-plasma ratio ~1.5-3.0); causes infant bradycardia, hypotension, and cyanosis; Metoprolol or Propranolol preferred.",
            sideEffects = "Bradycardia, hypotension, cold extremities, fatigue, dizziness, dyspnea, heart block, elevated triglycerides, reduced HDL, exercise intolerance.",
            priceNpr = "NPR 15.00 - 40.00 per strip of 10 (25mg / 50mg / 100mg)",
            priceInr = "INR 10.00 - 28.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Tenormin", "Abbott Nepal / Piramal", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Betacard", "Torrent / Medisales Nepal", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Atecard", "Sun Pharma Nepal", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Tenolol", "IPCA / Nepal Healthcare", "Tablet", "25 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tenormin", "Abbott India", "Tablet", "25 / 50 / 100 mg"),
                BrandInfo("Betacard", "Torrent Pharmaceuticals", "Tablet", "25 / 50 mg"),
                BrandInfo("Aten", "Zydus Cadila", "Tablet", "25 / 50 / 100 mg"),
                BrandInfo("Tenolol", "IPCA Laboratories", "Tablet", "25 / 50 mg")
            ),
            adultDose = "25-50 mg PO once daily (max 100 mg/day).",
            childDose = "Pediatric HTN: 0.5-1 mg/kg PO once daily (max 2 mg/kg/day or 100 mg).",
            contraindications = "Sinus bradycardia (HR <50 bpm), cardiogenic shock, second- or third-degree AV block, overt cardiac failure, sick sinus syndrome, severe peripheral arterial disease, pheochromocytoma without prior alpha-blocker.",
            modeOfAction = "Selectively antagonizes cardiac beta-1 adrenergic receptors, reducing resting and exercise heart rate, myocardial contractility, cardiac output, and systolic blood pressure, while decreasing renal renin release.",
            precautions = "RENAL ACCUMULATION: Dose must be halved if eGFR <35 mL/min to prevent profound drug-induced bradycardia and cardiogenic shock.",
            nemlCategory = "Nepal Essential Medicines List (Antihypertensive Formulary)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "Caution in elderly; risk of profound bradycardia and orthostatic falls.",
            counselingNepali = "यो उच्च रक्तचाप र छाती दुख्ने (एंजाइना) समस्याका लागि प्रयोग गरिने मुटुको औषधि हो। यो औषधि हरेक दिन बिहान एकै समयमा लिनुहोस्। नाडीको गति प्रति मिनेट ५० भन्दा कम भएमा वा चक्कर लागेमा डाक्टरलाई जानकारी गराउनुहोस्। डाक्टरको सल्लाह बिना औषधि खान अचानक बन्द नगर्नुहोस्।",
            counselingEnglish = "Cardioselective beta-1 blocker for hypertension and angina. Take once daily in the morning. Check your pulse regularly; contact your doctor if pulse is below 50 beats per minute. Do not stop taking this medicine abruptly.",
            era = "Classical Second-Generation Beta Blocker (Synthesized in 1976)",
            therapeuticClassTag = "Cardioselective Beta-1 Blocker / Antihypertensive",
            researchNotes = "Hydrophilic beta blocker with negligible brain penetration; ideal for patients experiencing nightmares on lipophilic beta blockers."
        ),

        // ==========================================
        // 7. DOPAMINE HYDROCHLORIDE
        // ==========================================
        Drug(
            id = "d_essential_dopamine",
            genericName = "Dopamine Hydrochloride",
            system = "Emergency & Critical Care",
            drugClass = "Inotropic & Vasopressor Endogenous Catecholamine",
            blackBoxWarning = "EXTRAVASATION AND TISSUE NECROSIS: To prevent sloughing and necrosis in ischemic areas, infuse into a large vein (preferably central line). If extravasation occurs, immediately infiltrate 5 to 10 mg Phentolamine mesylate in 10-15 mL saline locally into the affected tissue.",
            indications = "Hemodynamic support in Cardiogenic Shock, Septic Shock (alternative agent when norepinephrine unavailable), symptomatic Bradycardia refractory to atropine and transcutaneous pacing, acute hypotension in severe congestive heart failure.",
            doses = "Continuous IV Infusion Titration (Dose-Dependent Receptor Affinity):\n• Low Dose (0.5 to 2 mcg/kg/min): Dopaminergic (D1/D2) vasodilation of renal, mesenteric, and coronary beds. ('Renal dose' dopamine has NO proven clinical benefit in preventing AKI and is not recommended).\n• Intermediate / Inotropic Dose (2 to 10 mcg/kg/min): Beta-1 adrenergic stimulation -> increases myocardial contractility, heart rate, and cardiac output.\n• High / Vasopressor Dose (10 to 20 mcg/kg/min): Alpha-1 adrenergic stimulation -> peripheral arterial vasoconstriction, marked systemic vascular resistance (SVR) and BP elevation.\n• Maximum Dose: 20 to 50 mcg/kg/min (switch to Norepinephrine / Epinephrine if unresponsive).",
            administration = "Continuous IV Infusion ONLY via infusion pump into large central vein. Dilute 200 mg or 400 mg in 250 mL D5W or Normal Saline (concentration: 800-1600 mcg/mL). NEVER administer by IV push. Incompatible with alkaline IV solutions (e.g., Sodium Bicarbonate rapidly inactivates catecholamines).",
            timing = "Continuous intravenous infusion with continuous arterial line / BP and ECG monitoring.",
            specialInstructions = "ICU / RESUSCITATION ONLY: In septic shock, surviving sepsis guidelines recommend Norepinephrine as first-line vasopressor over Dopamine due to significantly higher risk of tachyarrhythmias and excess mortality with dopamine. Reserve dopamine for bradycardic shock.",
            pkPd = "Onset of action within 2-5 minutes; duration of action <10 minutes. Widely distributed; does not cross intact blood-brain barrier. Rapidly metabolized by monoamine oxidase (MAO) and catechol-O-methyltransferase (COMT) in liver, kidneys, and plasma. Elimination half-life ~2 minutes. Metabolites excreted in urine.",
            renalAdj = "No dose adjustment required; titrate based on hemodynamic endpoints (MAP >= 65 mmHg, urine output >= 0.5 mL/kg/hr).",
            hepaticAdj = "No dose adjustment required; monitor closely for tachyarrhythmias.",
            pregnancy = "Category C (Use in maternal shock if indicated to preserve uteroplacental perfusion).",
            lactation = "Degraded in infant GI tract; short half-life; compatible in maternal resuscitation.",
            sideEffects = "Tachyarrhythmias (atrial fibrillation, sinus tachycardia, ventricular ectopy/tachycardia), angina pectoris, peripheral vasoconstriction / digital gangrene, extravasation tissue necrosis, nausea, vomiting, headache.",
            priceNpr = "NPR 95.00 - 180.00 per 200mg/5mL ampoule",
            priceInr = "INR 65.00 - 120.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Domin", "Neon Laboratories / Medisales Nepal", "IV Infusion", "200 mg/5mL"),
                BrandInfo("Dopagress", "Troikaa / Nepal Healthcare", "IV Infusion", "200 mg/5mL"),
                BrandInfo("Dopamine Inj", "Government Central Medical Store", "IV Infusion", "200 mg/5mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Domin", "Neon Laboratories", "IV Infusion", "200 mg/5mL"),
                BrandInfo("Dopagress", "Troikaa Pharmaceuticals", "IV Infusion", "200 mg/5mL"),
                BrandInfo("Intropin", "Abbott India", "IV Infusion", "200 mg/5mL")
            ),
            pediatricDosePerKg = 5.0,
            pediatricInterval = "mcg/kg/min continuous IV infusion titrated up to 20 mcg/kg/min",
            adultDose = "2-20 mcg/kg/min continuous IV infusion titrated to target MAP >= 65 mmHg.",
            childDose = "2-20 mcg/kg/min continuous IV infusion.",
            contraindications = "Pheochromocytoma, uncorrected ventricular tachyarrhythmias / ventricular fibrillation, concurrent MAO inhibitor use (causes fatal hypertensive crisis).",
            modeOfAction = "Dose-dependent receptor agonist: Stimulates peripheral D1 dopaminergic receptors (low dose), cardiac beta-1 adrenergic receptors (medium dose), and vascular alpha-1 adrenergic receptors (high dose), releasing stored endogenous norepinephrine.",
            precautions = "ARRHYTHMIA RISK: Significantly more arrhythmogenic than norepinephrine; monitor continuous 12-lead ECG.",
            nemlCategory = "Nepal Essential Medicines List (Emergency Vasopressors & Inotropes)",
            ddaSchedule = "Schedule 'Ka' (ICU Emergency Hospital Only)",
            beersCriteriaRisk = "Emergency inotrope; use under continuous cardiac monitoring.",
            counselingNepali = "यो आकस्मिक कक्ष (ICU/Emergency) मा रक्तचाप एकदमै घटेको, मुटुको गति ज्यादै सुस्त भएको वा शक (Shock) को अवस्थामा भेनबाट सलाईनमा मिसाएर दिइने विशेष जीवनरक्षक औषधि हो। यसको प्रयोग अस्पतालको निरन्तर निगरानीमा गरिन्छ।",
            counselingEnglish = "Critical care inotropic and vasopressor agent administered via continuous IV infusion in hospital ICU/emergency for shock and severe bradycardia. Requires continuous hemodynamic and cardiac rhythm monitoring.",
            era = "Endogenous Neurotransmitter & Classical Inotrope (Introduced 1974)",
            therapeuticClassTag = "Vasopressor / Inotrope / Emergency Resuscitation",
            researchNotes = "Dose-dependent pharmacology: 2-10 mcg/kg/min primarily beta-1 inotropic; >10 mcg/kg/min predominantly alpha-1 vasopressor."
        ),

        // ==========================================
        // 8. METHYLPREDNISOLONE
        // ==========================================
        Drug(
            id = "d_essential_methylprednisolone",
            genericName = "Methylprednisolone",
            system = "Endocrine & Metabolic System",
            drugClass = "Intermediate-Acting Synthetic Glucocorticoid",
            blackBoxWarning = null,
            indications = "High-dose pulse steroid therapy for Acute Exacerbations of Multiple Sclerosis, Lupus Nephritis / Systemic Autoimmune Crisis, Severe Acute Asthma & COPD exacerbations, Acute Spinal Cord Injury, Organ Transplant Rejection prophylaxis/treatment, Severe COVID-19 / ARDS hyperinflammatory cytokine storm.",
            doses = "High-Dose Pulse Therapy (IV Solu-Medrol):\n• MS Relapse / Autoimmune Crisis: 500 to 1000 mg IV infusion in 250 mL D5W over 60 minutes once daily for 3 to 5 consecutive days.\nAcute Severe Asthma / COPD Exacerbation:\n• 40 to 125 mg IV every 6 to 12 hours (or 1-2 mg/kg/day) until clinical improvement, then switch to oral prednisolone.\nSevere Inflammatory / Autoimmune Maintenance:\n• Oral (Medrol): 4 to 48 mg PO once daily in the morning (titrate to lowest effective dose).\nSpinal Cord Injury Protocol (Historical NASCIS):\n• 30 mg/kg IV bolus over 15 min, followed by continuous infusion of 5.4 mg/kg/hr for 23 hours (if started within 8h).",
            administration = "IV Pulse: Infuse doses >= 500 mg slowly over at least 30 to 60 minutes to prevent acute cardiac arrhythmias and cardiovascular collapse. Oral: Take with food in the morning to align with diurnal cortisol surge.",
            timing = "Morning with breakfast (single daily) or divided q6h-q12h for acute IV exacerbations.",
            specialInstructions = "GLUCOCORTICOID POTENCY: 5 times more potent than hydrocortisone with virtually ZERO mineralocorticoid (sodium/water-retaining) activity (ideal in patients with volume overload or heart failure). Rapid pulse infusion (<10 min) has caused fatal cardiac arrest and arrhythmias; always infuse >= 30-60 min. Check blood glucose and co-prescribe PPI (Pantoprazole) for gastroprotection during high-dose therapy.",
            pkPd = "Oral bioavailability 80-90%. Peak plasma concentration in 1-2 hours (oral) or immediately (IV). Protein binding ~77%. Metabolized by hepatic CYP3A4 into inactive metabolites. Elimination half-life: 2-3 hours; biologic tissue half-life: 18-36 hours. Excreted in urine.",
            renalAdj = "No dose adjustment required in renal impairment or hemodialysis.",
            hepaticAdj = "Prolonged clearance in severe cirrhosis; monitor for excessive cushingoid side effects and steroid-induced hyperglycemia.",
            pregnancy = "Category C (Benefit outweighs risk in severe maternal autoimmune flare; monitor for maternal gestational diabetes and hypertension).",
            lactation = "Excreted in small amounts in breast milk; wait 2-4 hours after dose before breastfeeding to minimize infant exposure.",
            sideEffects = "Hyperglycemia, acute hypertension, hypokalemia, peptic ulceration, insomnia, psychiatric disturbances (steroid psychosis, euphoria, mania), immunosuppression, avascular necrosis of femoral head, osteoporosis.",
            priceNpr = "NPR 180.00 - 450.00 per 40mg / 125mg / 500mg IV vial",
            priceInr = "INR 120.00 - 320.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Solu-Medrol", "Pfizer / Medisales Nepal", "IV Injection", "40 mg / 125 mg / 500 mg / 1 g"),
                BrandInfo("Medrol", "Pfizer Nepal", "Tablet", "4 mg / 8 mg / 16 mg"),
                BrandInfo("Depo-Medrol", "Pfizer Nepal", "Depot Inj", "40 mg/mL / 80 mg/mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Solu-Medrol", "Pfizer India", "IV Injection", "40 / 125 / 500 mg / 1 g"),
                BrandInfo("Medrol", "Pfizer India", "Tablet", "4 / 8 / 16 mg"),
                BrandInfo("Depo-Medrol", "Pfizer India", "Depot Inj", "40 / 80 mg/mL")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "mg/kg IV q6-12h for status asthmaticus (max 60 mg/day)",
            adultDose = "Pulse: 500-1000 mg IV daily x 3-5d. Acute asthma: 40-125 mg IV q6-8h.",
            childDose = "1-2 mg/kg/day IV divided q6-12h.",
            contraindications = "Systemic untreated fungal infections, live or live-attenuated viral vaccines during high-dose therapy, hypersensitivity to methylprednisolone.",
            modeOfAction = "Crosses cell membrane, binds to intracellular glucocorticoid receptor (GR), translocates to nucleus, and inhibits NF-kappaB and AP-1 transcription factors, suppressing pro-inflammatory cytokines, chemokines, and prostaglandins.",
            precautions = "RAPID IV COLLAPSE WARNING: Infuse doses >= 500 mg over at least 30-60 minutes to prevent lethal ventricular arrhythmias and sudden cardiac arrest.",
            nemlCategory = "Nepal Essential Medicines List (Pulse Corticosteroid Formulary)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "Caution in elderly; monitor for acute delirium, confusion, rapid osteoporotic fracture, and severe hyperglycemia.",
            counselingNepali = "यो शरीरमा कडा सुन्निने समस्या, अटोइम्युन रोग वा श्वासप्रश्वासको गम्भीर समस्या नियन्त्रण गर्ने उच्च क्षमताको स्टेरोइड औषधि हो। यसले रगतमा चिनीको मात्रा (Sugar) र रक्तचाप बढाउन सक्ने हुनाले नियमित जाँच गराउनुहोस्। औषधि सधैं बिहान खानासँगै लिनुहोस्। डाक्टरको सल्लाह बिना अचानक औषधि खान कहिल्यै नछोड्नुहोस्।",
            counselingEnglish = "Potent anti-inflammatory corticosteroid used for acute autoimmune flares and severe asthma/COPD. Take in the morning with food. Monitor blood pressure and blood glucose closely during treatment. Never stop taking this medicine abruptly.",
            era = "Classical Synthetic Glucocorticoid (Introduced by Upjohn in 1957)",
            therapeuticClassTag = "Pulse Corticosteroid / High-Potency Anti-Inflammatory",
            researchNotes = "Potency benchmark: 4 mg Methylprednisolone = 5 mg Prednisolone = 20 mg Hydrocortisone = 0.75 mg Dexamethasone."
        ),

        // ==========================================
        // 9. TIZANIDINE
        // ==========================================
        Drug(
            id = "d_essential_tizanidine",
            genericName = "Tizanidine Hydrochloride",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Central Alpha-2 Adrenergic Receptor Agonist Skeletal Muscle Relaxant",
            blackBoxWarning = null,
            indications = "Skeletal muscle spasticity associated with Multiple Sclerosis, spinal cord injury, stroke, traumatic brain injury, and acute painful musculoskeletal spasms (acute low back pain, torticollis).",
            doses = "Adult Muscle Spasticity:\n• Initial: 2 mg PO single dose at bedtime or TID; increase gradually by 2 to 4 mg every 3-4 days.\n• Maintenance: 4 to 8 mg PO TID (every 6 to 8 hours; maximum 36 mg/day in divided doses).\nAcute Musculoskeletal Spasm (Lumbago / Cervicalgia):\n• 2 to 4 mg PO TID or at bedtime.",
            administration = "Take orally with or without food, but maintain consistency (food increases Cmax by 30% and shortens Tmax).",
            timing = "Every 6 to 8 hours with largest dose at bedtime.",
            specialInstructions = "STRICT CYP1A2 CONTRAINDICATION: Tizanidine is extensively cleared by hepatic CYP1A2. Concurrent administration of potent CYP1A2 inhibitors (especially CIPROFLOXACIN and FLUVOXAMINE) causes up to a 10-fold increase in tizanidine plasma concentrations, precipitating severe life-threatening hypotension, bradycardia, and prolonged sedation. Monitor liver function tests at baseline and monthly for first 4 months.",
            pkPd = "Oral bioavailability ~40% due to extensive first-pass metabolism. Peak plasma concentration in 1-2 hours. Protein binding ~30%. Metabolized extensively by hepatic CYP1A2 into inactive metabolites. Elimination half-life ~2.5 hours. Renal excretion ~60%.",
            renalAdj = "CrCl <25 mL/min: Reduce dose by 50% and titrate slowly; monitor for excessive sedation and hypotension.",
            hepaticAdj = "Contraindicated in severe hepatic impairment; hepatic clearance is decreased by >50%. Monitor transaminases closely.",
            pregnancy = "Category C (Use only if potential benefit justifies fetal risk).",
            lactation = "Lipophilic and excreted in animal milk; not recommended during breastfeeding.",
            sideEffects = "Drowsiness, sedation, dizziness, dry mouth (xerostomia, 40%), hypotension, bradycardia, asthenia/fatigue, elevated liver enzymes (ALT/AST).",
            priceNpr = "NPR 35.00 - 75.00 per strip of 10 (2mg / 4mg)",
            priceInr = "INR 25.00 - 55.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Sirdalud", "Novartis / Medisales Nepal", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Tizalud", "Sun Pharma Nepal", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Tizan", "Torrent / Medisales Nepal", "Tablet", "2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Sirdalud", "Novartis India", "Tablet", "2 / 4 mg"),
                BrandInfo("Tizalud", "Sun Pharma", "Tablet", "2 / 4 mg"),
                BrandInfo("Tizan", "Torrent Pharmaceuticals", "Tablet", "2 mg")
            ),
            adultDose = "2-4 mg PO TID (max 36 mg/day). Start 2 mg at bedtime.",
            childDose = "Safety and efficacy not established in pediatric patients under 18 years.",
            contraindications = "Concomitant use of potent CYP1A2 inhibitors (CIPROFLOXACIN or FLUVOXAMINE is strictly contraindicated), severe hepatic impairment, hypersensitivity to tizanidine.",
            modeOfAction = "Agonist at central presynaptic alpha-2 adrenergic receptors in the spinal cord, reducing the release of excitatory amino acids (glutamate and aspartate) from interneurons, inhibiting polysynaptic spinal reflex pathways and decreasing muscle tone.",
            precautions = "DRUG INTERACTION WARNING: Never co-prescribe Ciprofloxacin with Tizanidine; causes severe shock and profound sedation.",
            nemlCategory = "Nepal Essential Medicines List (Skeletal Muscle Relaxant)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "AVOID IN ELDERLY: Strong anticholinergic/sedative and hypotensive risk; causes severe falls, syncope, and sedation in older adults.",
            counselingNepali = "यो नसा र मांसपेशी बाउँडिने, कडा हुने वा ढाड दुख्ने समस्यामा मांसपेशी खुकुलो बनाउन प्रयोग गरिने औषधि हो। यो औषधि खाएपछि धेरै निन्द्रा लाग्ने र मुख सुक्खा हुने हुनसक्छ। यो औषधिसँग 'सिप्रोफ्लोक्सासिन' (Ciprofloxacin) नामक एन्टिबायोटिक कहिल्यै पनि सेवन नगर्नुहोस्। गाडी चलाउने वा मेसिनको काम नगर्नुहोस्।",
            counselingEnglish = "Centrally acting muscle relaxant for muscle spasms and back pain. Causes marked drowsiness and dry mouth; avoid driving. STRICTLY DO NOT TAKE with the antibiotic Ciprofloxacin or Fluvoxamine, as dangerous low blood pressure will occur.",
            era = "Modern Second-Generation Muscle Relaxant (Approved FDA 1996)",
            therapeuticClassTag = "Central Muscle Relaxant / Alpha-2 Agonist",
            researchNotes = "Preserves muscle strength while reducing spasticity, unlike direct muscle relaxants (dantrolene)."
        ),

        // ==========================================
        // 10. TOLPERISONE
        // ==========================================
        Drug(
            id = "d_essential_tolperisone",
            genericName = "Tolperisone Hydrochloride",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Centrally Acting Sodium Channel Blocker Muscle Relaxant",
            blackBoxWarning = null,
            indications = "Acute painful musculoskeletal spasms, low back pain (lumbago), cervical spondylosis, post-stroke spasticity, spasticity associated with neurological disorders.",
            doses = "Adult: 50 to 150 mg PO TID (three times daily) with meals (typical starting dose: 50 mg PO TID, increasing to 150 mg PO TID based on clinical response; max 450 mg/day).",
            administration = "Take orally with meals (food increases oral bioavailability by ~100%). Swallow tablet whole with a glass of water.",
            timing = "Immediately after meals three times daily.",
            specialInstructions = "NON-SEDATING MUSCLE RELAXANT: Unlike diazepam, baclofen, or tizanidine, tolperisone does NOT cause cognitive sedation, drowsiness, or psychomotor impairment. Ideal for ambulatory, working patients who need to drive or perform cognitive tasks. Food significantly enhances bioavailability.",
            pkPd = "Rapid absorption from gastrointestinal tract; bioavailability ~20% on empty stomach, increased up to 100% when taken with high-fat meals. Peak plasma concentration within 0.5-1 hour. Metabolized extensively in liver and kidneys. Elimination half-life ~1.5-2.5 hours. Excreted >99% in urine as metabolites.",
            renalAdj = "Mild-to-moderate: Use with caution. Severe renal impairment: Not recommended.",
            hepaticAdj = "Mild-to-moderate: Titrate cautiously. Severe hepatic impairment: Not recommended.",
            pregnancy = "Contraindicated during pregnancy (especially first trimester) due to lack of adequate human clinical safety data.",
            lactation = "Contraindicated during breastfeeding; excreted in animal milk.",
            sideEffects = "Mild muscular weakness, headache, dizziness, nausea, abdominal discomfort, hypersensitivity reactions (pruritus, erythema, rare anaphylaxis).",
            priceNpr = "NPR 110.00 - 220.00 per strip of 10 (150mg)",
            priceInr = "INR 70.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Tolifast", "Sun Pharma Nepal", "Tablet", "50 mg / 150 mg"),
                BrandInfo("Myoril", "Sanofi / Medisales Nepal", "Tablet", "4 mg / 8 mg (Thiocolchicoside alternative)"),
                BrandInfo("Tolperis", "Torrent / Medisales Nepal", "Tablet", "150 mg"),
                BrandInfo("Tolkem", "Alkem Nepal", "Tablet", "150 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tolifast", "Sun Pharma", "Tablet", "50 / 150 mg"),
                BrandInfo("Tolpidol", "Abbott India", "Tablet", "150 mg"),
                BrandInfo("Tolfree", "Mankind Pharma", "Tablet", "150 mg")
            ),
            adultDose = "150 mg PO TID after meals (max 450 mg/day).",
            childDose = "Safety and efficacy not established in pediatric patients under 18 years.",
            contraindications = "Myasthenia gravis, hypersensitivity to tolperisone, severe hepatic or renal failure, breastfeeding.",
            modeOfAction = "Acts primarily on brainstem reticular formation and spinal cord; blocks voltage-gated sodium and calcium channels, suppressing spinal mono- and polysynaptic reflex arcs and membrane hyperexcitability without cortical sedation.",
            precautions = "HYPERSENSITIVITY ALERT: Inform patient to discontinue immediately if itching, rash, or breathing difficulty occurs.",
            nemlCategory = "Nepal Essential Medicines List (Ambulatory Muscle Relaxant)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "Preferred over sedating muscle relaxants in older adults when a muscle relaxant is unavoidable.",
            counselingNepali = "यो ढाड दुख्ने, घाँटी कडा हुने तथा मांसपेशी बाउँडिने समस्यामा प्रयोग गरिने मांसपेशी खुकुलो बनाउने औषधि हो। यो औषधिले अन्य औषधि जस्तो निन्द्रा वा लट्ठ्याउने समस्या गराउँदैन। सधैं खाना खाएपछि सेवन गर्नुहोस् किनभने खानाले औषधिको प्रभाव दोब्बर बनाउँछ।",
            counselingEnglish = "Non-sedating muscle relaxant for acute back pain and muscle spasms. Take with meals for maximum absorption. Unlike other muscle relaxants, it does not cause severe drowsiness.",
            era = "Modern Centrally Acting Muscle Relaxant",
            therapeuticClassTag = "Non-Sedating Muscle Relaxant / Membrane Stabilizer",
            researchNotes = "Ideal muscle relaxant for active working patients due to lack of sedation and minimal cognitive impairment."
        ),

        // ==========================================
        // 11. SUMATRIPTAN
        // ==========================================
        Drug(
            id = "d_essential_sumatriptan",
            genericName = "Sumatriptan",
            system = "Central Nervous System (CNS)",
            drugClass = "Selective Serotonin 5-HT1B / 5-HT1D Receptor Agonist (Triptan)",
            blackBoxWarning = null,
            indications = "Acute abortive treatment of Migraine attacks with or without aura in adults, acute treatment of Cluster Headache episodes (subcutaneous injection gold standard). (Not indicated for migraine prophylaxis).",
            doses = "Acute Migraine Attack (Oral):\n• Initial: 50 to 100 mg PO single dose taken as early as possible after onset of migraine headache.\n• Second Dose: If headache improves but recurs, or partial relief, a second dose may be taken after at least 2 HOURS (maximum oral dose: 200 mg in 24 hours).\n• (If patient does not respond to first dose, a second dose for the same attack is unlikely to provide benefit).\nAcute Migraine / Cluster Headache (Subcutaneous):\n• 6 mg SC single dose using auto-injector (may repeat after at least 1 hour; max 12 mg in 24 hours).\nNasal Spray:\n• 10 to 20 mg in one nostril; may repeat after 2 hours (max 40 mg/24h).",
            administration = "Take orally with water as soon as migraine pain begins. Swallow tablet whole. Subcutaneous auto-injector is administered into lateral thigh or upper arm.",
            timing = "At the earliest onset of migraine headache pain.",
            specialInstructions = "CORONARY VASOSPASM CAUTION: Can cause coronary vasospasm and myocardial ischemia. STRICTLY CONTRAINDICATED in patients with ischemic heart disease (prior MI, angina), coronary artery vasospasm (Prinzmetal), history of stroke/TIA, peripheral vascular disease, or uncontrolled hypertension. Do not use within 24 hours of another triptan or ergotamine derivative (Cafergot).",
            pkPd = "Oral bioavailability ~14% due to presynaptic first-pass metabolism; subcutaneous bioavailability ~96%. Onset of action: oral 30 min, subcutaneous 10-15 min. Protein binding 14-21%. Metabolized by monoamine oxidase-A (MAO-A) into inactive indole acetic acid. Elimination half-life ~2 hours. Excreted in urine.",
            renalAdj = "No dose adjustment required in renal impairment.",
            hepaticAdj = "Mild-to-moderate impairment: Maximum single oral dose 50 mg. Severe hepatic impairment: Contraindicated.",
            pregnancy = "Category C (Extensive Sumatriptan Pregnancy Registry data shows no increased risk of congenital malformations compared to background rate; use if clearly needed).",
            lactation = "Excreted into breast milk; withhold breastfeeding for 8 to 12 hours after dose and discard expressed milk to minimize infant exposure.",
            sideEffects = "'Triptan Sensations' (transient chest, jaw, or neck tightness/heaviness in up to 15%, usually non-cardiac), tingling/paresthesia, flushing, warm sensation, dizziness, somnolence, nausea, injection site reaction.",
            priceNpr = "NPR 90.00 - 220.00 per strip of 2 / 4 tablets (50mg / 100mg)",
            priceInr = "INR 60.00 - 150.00 per strip of 4",
            brandsNepal = listOf(
                BrandInfo("Suminat", "Sun Pharma Nepal", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Imigran", "GlaxoSmithKline / Medisales Nepal", "Tablet / Inj", "50 mg / 100 mg / 6mg/0.5mL"),
                BrandInfo("Headset", "Lupin Nepal", "Tablet", "50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Suminat", "Sun Pharma", "Tablet", "25 / 50 / 100 mg"),
                BrandInfo("Imigran", "GlaxoSmithKline India", "Tablet / Inj", "50 / 100 mg / 6mg"),
                BrandInfo("Headset", "Lupin", "Tablet", "50 / 100 mg")
            ),
            adultDose = "50-100 mg PO stat at onset of migraine; repeat after >= 2h PRN (max 200 mg/24h).",
            childDose = "Safety and efficacy not established in pediatric patients under 18 years.",
            contraindications = "Ischemic coronary artery disease (angina, history of MI), coronary artery vasospasm (Prinzmetal), Wolff-Parkinson-White syndrome, history of stroke or TIA, peripheral vascular disease, ischemic bowel disease, uncontrolled hypertension, severe hepatic impairment, use within 24h of ergotamine or other triptans.",
            modeOfAction = "Selectively binds to and stimulates 5-HT1B and 5-HT1D receptors on intracranial blood vessels and trigeminal sensory nerve terminals, causing vasoconstriction of painfully dilated meningeal dural vessels and inhibiting the release of pro-inflammatory calcitonin gene-related peptide (CGRP) and substance P.",
            precautions = "MEDICATION OVERUSE HEADACHE (MOH): Limit use to no more than 9 to 10 days per month to prevent transformed chronic daily rebound headaches.",
            nemlCategory = "Nepal Essential Medicines List (Migraine Abortive Formulary)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "Avoid in older adults with known or suspected coronary artery disease or uncontrolled vascular disease.",
            counselingNepali = "यो माइग्रेन (आधा टाउको दुख्ने रोग) को तीव्र दुखाइ सुरु हुनेबित्तिकै रोक्न खाने विशेष औषधि हो। टाउको दुखाइ सुरु भएको जति सक्दो छिटो सेवन गर्नुहोस्। मुटुको रोग (Heart attack), उच्च रक्तचाप वा पक्षघात (Stroke) भएका बिरामीले यो औषधि खानु हुँदैन। महिनामा १० दिनभन्दा बढी यो औषधि प्रयोग नगर्नुहोस्।",
            counselingEnglish = "Specific abortive medication for acute migraine attacks. Take as early as possible after headache begins. May repeat after 2 hours if headache recurs (max 200 mg/day). Strictly contraindicated if you have heart disease, prior heart attack, or high blood pressure.",
            era = "First-in-Class Triptan Prototype (Introduced by Glaxo in 1991)",
            therapeuticClassTag = "Selective 5-HT1B/1D Agonist / Acute Migraine Abortive",
            researchNotes = "Revolutionized acute migraine pharmacology by specifically targeting neurovascular 5-HT1B/1D receptors."
        ),

        // ==========================================
        // 12. DISULFIRAM
        // ==========================================
        Drug(
            id = "d_essential_disulfiram",
            genericName = "Disulfiram",
            system = "Central Nervous System (CNS)",
            drugClass = "Aldehyde Dehydrogenase (ALDH) Inhibitor / Alcohol Aversive Deterrent",
            blackBoxWarning = "NEVER ADMINISTER TO AN INTOXICATED PATIENT OR WITHOUT PATIENT'S FULL KNOWLEDGE: Never administer to a patient without their full knowledge or within 12 hours of alcohol ingestion. Ingesting alcohol while on disulfiram causes severe disulfiram-ethanol reaction: respiratory depression, cardiovascular collapse, arrhythmias, myocardial infarction, acute congestive heart failure, and death.",
            indications = "Adjunctive deterrent therapy in the comprehensive management of chronic alcohol dependence in motivated, compliant adult patients committed to maintaining abstinence.",
            doses = "Adult Alcohol Deterrent Therapy:\n• Initial: 500 mg PO once daily in the morning for 1 to 2 weeks (patient must have been strictly alcohol-free for AT LEAST 12 HOURS).\n• Maintenance: 250 mg PO once daily (range: 125 to 500 mg daily; do not exceed 500 mg/day).\n• Duration: Continue until fully established social and psychological rehabilitation (often months to years).",
            administration = "Take orally once daily in the morning. If sedative effect occurs, take at bedtime. Tablet may be crushed and mixed with liquid if necessary.",
            timing = "Morning with breakfast (or bedtime if causing drowsiness).",
            specialInstructions = "DISULFIRAM-ETHANOL REACTION (DER): Inhibits hepatic aldehyde dehydrogenase (ALDH), causing a 5- to 10-fold accumulation of toxic ACETALDEHYDE within 5-10 minutes of alcohol ingestion. Reaction features: intense facial flushing, throbbing headache, diaphoresis, dyspnea, nausea, copius vomiting, tachycardia, and severe hypotension lasting 30 minutes to several hours. Sensitivity to alcohol persists for up to 14 DAYS after the last dose of disulfiram. Warn patient against hidden alcohol in mouthwashes, cough syrups, vinegars, and aftershave lotions.",
            pkPd = "Oral absorption ~80-90%. Slow onset of full enzymatic inhibition (requires ~12 hours). Highly lipophilic. Metabolized in the liver to diethyldithiocarbamate and carbon disulfide. Irreversibly inactivates ALDH; enzyme recovery requires de novo protein synthesis taking 1 to 2 weeks. Elimination half-life ~60-120 hours.",
            renalAdj = "Use with caution in severe renal impairment.",
            hepaticAdj = "CONTRAINDICATED in severe hepatic cirrhosis or hepatitis. Can cause severe idiosyncratic drug-induced liver injury / fatal fulminant hepatitis (monitor baseline and monthly LFTs for first 3 months).",
            pregnancy = "Category C (Avoid in pregnancy; alcohol itself is a potent teratogen; disulfiram has been associated with congenital limb reductions).",
            lactation = "Unknown if excreted in human milk; avoid during breastfeeding.",
            sideEffects = "Metallic or garlic-like aftertaste (common, self-limiting), drowsiness, fatigue, headache, acneiform eruptions, peripheral neuropathy, optic neuritis, hepatotoxicity, psychiatric symptoms (paranoia, psychosis).",
            priceNpr = "NPR 45.00 - 110.00 per strip of 10 (250mg / 500mg)",
            priceInr = "INR 30.00 - 80.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Antabuse", "Sanofi / Medisales Nepal", "Tablet", "250 mg / 500 mg"),
                BrandInfo("Esperal", "Torrent / Medisales Nepal", "Tablet", "250 mg"),
                BrandInfo("Dizone", "Ozone Pharmaceuticals Nepal", "Tablet", "250 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Antabuse", "Sanofi India", "Tablet", "250 / 500 mg"),
                BrandInfo("Esperal", "Torrent Pharmaceuticals", "Tablet", "250 mg"),
                BrandInfo("Dizone", "Ozone Pharmaceuticals", "Tablet", "250 / 500 mg")
            ),
            adultDose = "Initial: 500 mg PO daily x 1-2 weeks. Maintenance: 250 mg PO daily (max 500 mg).",
            childDose = "Contraindicated in pediatric patients under 18 years.",
            contraindications = "Recent alcohol consumption (within 12h), severe myocardial disease or coronary occlusion, severe psychoses, active severe liver failure, hypersensitivity to disulfiram or thiuram derivatives used in rubber.",
            modeOfAction = "Irreversibly inhibits aldehyde dehydrogenase (ALDH), blocking the conversion of acetaldehyde to acetate in the ethanol metabolic pathway, causing rapid toxic acetaldehyde accumulation upon ethanol consumption.",
            precautions = "LIVER FUNCTION MONITORING: Perform baseline, 2-week, and monthly LFTs during the first 3 months to detect rare idiosyncratic drug-induced hepatitis.",
            nemlCategory = "Nepal Essential Medicines List (Addiction Medicine Formulary)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "Contraindicated in patients with cognitive impairment or dementia who cannot reliably understand the life-threatening alcohol reaction.",
            counselingNepali = "यो मदिरा (रक्सी) छुटाउन मद्दत गर्ने विशेष औषधि हो। यो औषधि खाएको बेला रक्सीको सानो थोपा पनि खाएमा अत्यधिक बान्ता हुने, छाती दुख्ने, मुटुको धड्कन बढ्ने, सास फेर्न गाह्रो हुने र ज्यान नै जान सक्ने कडा रियाक्सन (Reaction) हुन्छ। औषधि खान छोडेको २ हप्तासम्म पनि रक्सी, बियर वा रक्सी मिसिएको कफ सिरप कहिल्यै नपिउनुहोस्।",
            counselingEnglish = "Aversive deterrent therapy for alcohol dependence. Drinking even small amounts of alcohol while taking this medicine will cause severe, life-threatening vomiting, flushing, and chest pain. Avoid hidden alcohol in cough syrups and mouthwashes. The reaction can occur up to 14 days after stopping the drug.",
            era = "Classical Aversive Substance (Discovered by Hald and Jacobsen in 1948)",
            therapeuticClassTag = "ALDH Inhibitor / Alcohol Dependence Deterrent",
            researchNotes = "Irreversible enzyme inhibitor: Recovery of ALDH activity requires full de novo hepatic enzyme synthesis taking up to two weeks."
        ),

        // ==========================================
        // 13. CLARITHROMYCIN
        // ==========================================
        Drug(
            id = "d_essential_clarithromycin",
            genericName = "Clarithromycin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Semi-Synthetic 14-Membered Macrolide Antibacterial Agent",
            blackBoxWarning = "POTENTIAL INCREASE IN LONG-TERM ALL-CAUSE MORTALITY IN PATIENTS WITH CORONARY HEART DISEASE: An increased risk of cardiovascular mortality has been observed in patients with coronary heart disease treated with clarithromycin (CLARICOR trial). Consider alternative antibiotics in patients with established heart disease.",
            indications = "Helicobacter pylori eradication (component of triple and quadruple therapy for peptic ulcer disease), Community-Acquired Pneumonia (CAP), Acute bacterial exacerbation of chronic bronchitis (AECB), Streptococcal pharyngitis/tonsillitis in penicillin-allergic patients, Disseminated Mycobacterium avium complex (MAC) treatment and prophylaxis in advanced HIV.",
            doses = "H. pylori Eradication (Triple Therapy):\n• 500 mg PO BID combined with Amoxicillin 1000 mg BID (or Metronidazole 400 mg TID) PLUS a PPI (e.g. Pantoprazole 40 mg BID) for 14 DAYS.\nCommunity-Acquired Pneumonia / Sinusitis / Bronchitis:\n• 500 mg PO BID (or 250 mg PO BID) for 7 to 14 days.\n• Extended-Release (XL): 1000 mg (two 500 mg tabs) PO once daily with food for 7 days.\nMycobacterium avium complex (MAC):\n• Treatment: 500 mg PO BID combined with Ethambutol (15 mg/kg daily) and Rifabutin.\n• Prophylaxis in HIV (CD4 <50/mcL): 500 mg PO BID.\nPediatric (>= 6 months):\n• 7.5 mg/kg PO every 12 hours (15 mg/kg/day divided BID; max 500 mg/dose) for 10 days.",
            administration = "Immediate-release tablets and suspension may be taken with or without food. Extended-release (XL) tablets MUST be taken with food and swallowed whole (never crush or chew).",
            timing = "Every 12 hours (immediate release) or once daily with evening dinner (XL formulation).",
            specialInstructions = "POTENT CYP3A4 INHIBITOR & QT PROLONGATION: Strongly inhibits CYP3A4, causing massive toxic accumulation of Statins (Simvastatin, Atorvastatin -> severe rhabdomyolysis), Carbamazepine, Digoxin, and Warfarin. Can cause dose-dependent QT prolongation and Torsades de Pointes. Avoid co-administration with other QT-prolonging drugs.",
            pkPd = "Rapid oral absorption; bioavailability ~50% due to first-pass metabolism. Converted in liver to 14-hydroxyclarithromycin (active metabolite with synergistic antibacterial activity against H. influenzae). Excellent intracellular penetration into pulmonary tissue, alveolar macrophages, and gastric mucosa. Elimination half-life: parent compound 3-7 hours; active metabolite 5-9 hours. Excreted renally (~30-40% unchanged) and via bile.",
            renalAdj = "CrCl 30-60 mL/min: Reduce dose by 50% if duration >14 days. CrCl <30 mL/min: Reduce dose by 50% (250 mg PO once or twice daily); do not use extended-release XL formulation.",
            hepaticAdj = "No dose adjustment required in patients with hepatic impairment if renal function is normal.",
            pregnancy = "Category C (Associated with adverse embryofetal outcomes in animal studies; avoid during pregnancy unless no suitable alternative exists; Azithromycin is preferred in pregnancy).",
            lactation = "Excreted in human breast milk; monitor infant for diarrhea, candidiasis, and somnolence; Azithromycin preferred.",
            sideEffects = "Dysgeusia (bitter / metallic taste in mouth in 10-20%), nausea, diarrhea, vomiting, abdominal pain, QT prolongation, elevated transaminases, cholestatic jaundice, headache.",
            priceNpr = "NPR 180.00 - 360.00 per strip of 10 (250mg / 500mg)",
            priceInr = "INR 120.00 - 250.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Claribid", "Sun Pharma Nepal", "Tablet / Dry Syr", "250 mg / 500 mg / 125mg/5mL"),
                BrandInfo("Crixan", "Ranbaxy / Sun Pharma Nepal", "Tablet", "250 mg / 500 mg"),
                BrandInfo("Maclar", "Cipla Nepal", "Tablet", "500 mg"),
                BrandInfo("Synclar", "Deurali-Janta Pharmaceuticals", "Tablet", "250 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Claribid", "Sun Pharma", "Tablet / XL", "250 / 500 mg / 500mg XL"),
                BrandInfo("Crixan", "Sun Pharma", "Tablet", "250 / 500 mg"),
                BrandInfo("Biaxin", "Abbott India", "Tablet", "250 / 500 mg"),
                BrandInfo("Clariwin", "Mankind Pharma", "Tablet", "500 mg")
            ),
            pediatricDosePerKg = 7.5,
            pediatricInterval = "mg/kg PO q12h (max 500 mg/dose)",
            adultDose = "H. pylori: 500 mg PO BID x 14d. Respiratory: 500 mg PO BID x 7-14d.",
            childDose = "7.5 mg/kg PO BID (15 mg/kg/day divided q12h).",
            contraindications = "Hypersensitivity to macrolides, history of cholestatic jaundice with clarithromycin, concomitant administration with Pimozide, Terfenadine, Astemizole, Cisapride, Ergotamine, Lovastatin, or Simvastatin (severe rhabdomyolysis), history of QT prolongation or ventricular arrhythmias.",
            modeOfAction = "Binds reversibly to the 50S ribosomal subunit of susceptible microorganisms, inhibiting RNA-dependent protein synthesis and translocation of aminoacyl-tRNA, producing bacteriostatic (and at higher concentrations bactericidal) activity.",
            precautions = "STATIN INTERACTION WARNING: Strictly withhold Simvastatin and Atorvastatin during clarithromycin therapy to prevent severe fatal rhabdomyolysis.",
            nemlCategory = "Nepal Essential Medicines List (H. Pylori & Macrolide Antibacterial)",
            ddaSchedule = "Schedule 'Kha' (Prescription Antibiotic)",
            beersCriteriaRisk = "Caution in elderly; risk of QT prolongation, torsades de pointes, and severe drug-drug interactions via CYP3A4 inhibition.",
            counselingNepali = "यो आन्द्राको घाउ (अल्सर) गराउने कीटाणु (H. pylori) मार्न तथा छातीको संक्रमण निको पार्न प्रयोग गरिने एन्टिबायोटिक हो। यो औषधि खाँदा मुखमा तितो वा धातुको जस्तो स्वाद आउन सक्छ, जुन सामान्य हो। कोलेस्ट्रोल घटाउने औषधि (Statin) खाइरहनु भएको छ भने डाक्टरलाई तुरुन्त जानकारी गराउनुहोस्। डाक्टरले तोकेको पूरा अवधि सेवन गर्नुहोस्।",
            counselingEnglish = "Macrolide antibiotic for H. pylori ulcer eradication and respiratory infections. May cause a temporary bitter/metallic taste in your mouth. Discontinue statin cholesterol medications while taking this antibiotic to prevent severe muscle breakdown. Complete the full prescribed course.",
            era = "Second-Generation Acid-Stable Macrolide (Synthesized by Taisho in 1980)",
            therapeuticClassTag = "Macrolide Antibacterial / H. Pylori Eradication",
            researchNotes = "Active metabolite 14-hydroxyclarithromycin acts synergistically with parent drug against respiratory pathogens."
        ),

        // ==========================================
        // 14. INDOMETHACIN
        // ==========================================
        Drug(
            id = "d_essential_indomethacin",
            genericName = "Indomethacin",
            system = "Musculoskeletal & Analgesics",
            drugClass = "Potent Non-Steroidal Anti-Inflammatory Drug (Indole-Acetic Acid Derivative)",
            blackBoxWarning = "CARDIOVASCULAR THROMBOTIC EVENTS & GASTROINTESTINAL BLEEDING, ULCERATION AND PERFORATION: NSAIDs cause an increased risk of serious cardiovascular thrombotic events, myocardial infarction, and stroke. Serious gastrointestinal adverse events including bleeding, ulceration, and perforation can occur at any time.",
            indications = "Acute Gouty Arthritis (gold standard potent non-selective NSAID), closure of Patent Ductus Arteriosus (PDA) in premature neonates, Ankylosing Spondylitis, Severe Osteoarthritis and Rheumatoid Arthritis, Acute Bursitis / Tendinitis, Hemicrania Continua and Paroxysmal Hemicrania (diagnostic absolute response).",
            doses = "Acute Gouty Arthritis:\n• Adult: 50 mg PO TID immediately at onset of acute attack; after pain diminishes, reduce to 25 mg PO TID for 3 to 5 days, then discontinue.\nAnkylosing Spondylitis / Rheumatoid Arthritis:\n• 25 mg PO BID or TID with meals; may increase by 25 mg/day weekly up to 150 to 200 mg/day divided TID.\nPatent Ductus Arteriosus (PDA Closure in Neonates - IV):\n• Course of 3 IV doses given at 12 to 24-hour intervals based on postnatal age (e.g. 0.2 mg/kg IV initial dose, followed by 0.1-0.25 mg/kg for doses 2 and 3 under NICU echocardiographic monitoring).\nHemicrania Continua (Diagnostic Trial):\n• 25 mg PO TID; increase up to 50 mg TID (absolute complete abolition of headache confirms diagnosis).",
            administration = "Take orally with food, milk, or antacids to minimize gastric irritation and ulcer risk. Swallow sustained-release formulations whole.",
            timing = "Immediately with or after meals.",
            specialInstructions = "POTENT GASTROINTESTINAL TOXICITY & HEADACHE: One of the most potent non-selective COX inhibitors with exceptionally high rate of gastrointestinal ulceration, bleeding, and frontal headaches (frontal headache occurs in 20-50% of patients on chronic therapy). Co-prescribe a Proton Pump Inhibitor (e.g. Pantoprazole 40 mg daily). Monitor renal function and blood pressure.",
            pkPd = "Rapid and almost complete oral absorption; bioavailability ~90-100%. Peak plasma concentration in 1-2 hours. Protein binding ~99%. Extensively metabolized in the liver via O-demethylation and N-deacylation to inactive metabolites. Elimination half-life ~4.5 hours. Excreted in urine (~60%) and feces (~33%).",
            renalAdj = "CrCl 30-50 mL/min: Reduce dose by 50% and monitor serum creatinine. CrCl <30 mL/min: Avoid; causes acute renal failure via inhibition of renal vasodilatory prostaglandins.",
            hepaticAdj = "Severe hepatic impairment: Avoid; increased risk of bleeding and fluid retention.",
            pregnancy = "Category D in third trimester (strictly contraindicated from 20 weeks gestation onwards; causes premature closure of the fetal ductus arteriosus, oligohydramnios, and neonatal renal failure).",
            lactation = "Excreted in human breast milk in small amounts; causes potential adverse effects in infant; avoid or use alternative like Ibuprofen.",
            sideEffects = "Severe frontal headache (20-50%), dizziness, dyspepsia, peptic ulcer disease, gastrointestinal bleeding/perforation, acute kidney injury, fluid retention/edema, hypertension, tinnitus, hyperkalemia.",
            priceNpr = "NPR 35.00 - 80.00 per strip of 10 (25mg / 75mg SR)",
            priceInr = "INR 20.00 - 55.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Inmecin", "Cipla Nepal", "Capsule", "25 mg / 50 mg"),
                BrandInfo("Indocin", "Merck / Medisales Nepal", "Capsule / SR", "25 mg / 75 mg SR"),
                BrandInfo("Idicin", "Cadila Pharmaceuticals Nepal", "Capsule", "25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Inmecin", "Cipla Ltd.", "Capsule", "25 / 50 mg"),
                BrandInfo("Indocin", "Merck India", "Capsule", "25 / 75 mg SR"),
                BrandInfo("Microcid", "Micro Labs", "Capsule", "25 mg")
            ),
            pediatricDosePerKg = 0.2,
            pediatricInterval = "mg/kg IV for patent ductus arteriosus closure in premature infants",
            adultDose = "Acute Gout: 50 mg PO TID with meals x 3-5 days. AS: 25-50 mg PO TID.",
            childDose = "PDA closure in neonates: 0.1-0.25 mg/kg IV q12-24h x 3 doses.",
            contraindications = "Active peptic ulcer disease or GI bleeding, history of aspirin/NSAID-induced asthma or urticaria, third trimester of pregnancy, severe renal impairment, severe heart failure, CABG perioperative pain.",
            modeOfAction = "Potent non-selective inhibitor of cyclooxygenase enzymes (COX-1 and COX-2), suppressing the synthesis of pro-inflammatory prostaglandins and prostacyclins. Also directly inhibits leukocyte motility and phosphodiesterase.",
            precautions = "FRONTAL HEADACHE & GI WARNING: Frontal headache occurs in up to 50% of chronic users; always take with food and co-prescribe a PPI.",
            nemlCategory = "Nepal Essential Medicines List (Acute Gout & Neonatal PDA Formulary)",
            ddaSchedule = "Schedule 'Kha' (Prescription Only)",
            beersCriteriaRisk = "AVOID IN ELDERLY (Beers 2023): Most gastrotoxic and neurotoxic NSAID; causes severe ulceration, acute renal failure, and CNS delirium in older adults.",
            counselingNepali = "यो कडा दुखाइ र सुन्निने समस्या, विशेष गरी खुट्टाको बुढीऔंला सुन्निने रोग (Gout) को तीव्र दुखाइ रोक्न प्रयोग गरिने औषधि हो। यो औषधिले पेटमा घाउ (Ulcer) बनाउन सक्ने भएकाले सधैं खाना खाएपछि र ग्यास्ट्रिकको औषधिसँगै खानुपर्छ। टाउको दुख्ने, दिसा कालो हुने वा पेट धेरै दुख्ने भएमा तुरुन्त डाक्टरलाई सम्पर्क गर्नुहोस्।",
            counselingEnglish = "Potent anti-inflammatory for acute gout attacks and inflammatory arthritis. Always take with meals and a prescribed stomach acid reducer to prevent stomach ulcers. Report any severe headache, black tarry stools, or persistent stomach pain immediately.",
            era = "Classical Non-Selective NSAID Prototype (Introduced 1963)",
            therapeuticClassTag = "Potent NSAID / Acute Gout / Neonatal PDA Closure",
            researchNotes = "Pathognomonic therapeutic test: Complete response to indomethacin defines Hemicrania Continua and Paroxysmal Hemicrania."
        )
    )
}
