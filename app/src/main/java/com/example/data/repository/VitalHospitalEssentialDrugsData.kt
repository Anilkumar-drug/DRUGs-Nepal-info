package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object VitalHospitalEssentialDrugsData {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // 1. MAGNESIUM SULFATE
        // ==========================================
        Drug(
            id = "d_vital_magnesium_sulfate",
            genericName = "Magnesium Sulfate",
            system = "Emergency & Critical Care",
            drugClass = "Parenteral Anticonvulsant, Tocolytic & Smooth Muscle Relaxant",
            blackBoxWarning = null,
            indications = "Prevention and management of eclamptic convulsions in severe pre-eclampsia and eclampsia (WHO gold standard); acute severe asthma exacerbations refractory to initial inhaled bronchodilators; Torsades de Pointes polymorphic ventricular tachycardia; severe symptomatic hypomagnesemia; fetal neuroprotection before anticipated preterm delivery (<32 weeks).",
            doses = "Severe Pre-eclampsia / Eclampsia (Pritchard Regimen):\n• Loading: 4 g IV (20% solution) slowly over 10-15 min PLUS 10 g IM (5 g deep IM into each buttock of 50% solution, mixed with 1 mL 2% lidocaine).\n• Maintenance: 5 g IM q4h in alternating buttocks (provided patellar reflex is present, RR >= 16/min, urine output >= 30 mL/h).\nAlternative (Zuspan Regimen):\n• Loading: 4 g IV over 15-20 min, followed by continuous IV infusion of 1-2 g/hour for 24 hours postpartum or after last seizure.\nAcute Severe Asthma:\n• Adult: 1.2 to 2 g IV single infusion diluted in 100 mL Normal Saline over 20 min.\n• Pediatric: 25 to 50 mg/kg IV (max 2 g) over 20 min.\nTorsades de Pointes:\n• 1 to 2 g IV push diluted in 10 mL D5W or Normal Saline given over 1 to 2 minutes, followed by 0.5-1 g/hour IV infusion.",
            administration = "Intravenous infusion or deep intramuscular injection into the upper outer quadrant of the buttock using a 20-gauge, 3-inch needle. Avoid rapid bolus to prevent cardiac arrest.",
            timing = "Immediate emergency administration; continue for 24 hours postpartum or after last seizure.",
            specialInstructions = "BEDSIDE ANTIDOTE: Always keep Calcium Gluconate 10% (10 mL / 1 g IV given slowly over 3-5 min) readily available at the patient's bedside to counteract toxicity.\nMONITORING TRIAD:\n1. Patellar / Knee-jerk reflex (loss of reflex occurs at serum magnesium 9-12 mg/dL; first sign of toxicity).\n2. Respiratory Rate (must be >= 16 breaths/min; respiratory arrest at >15-17 mg/dL).\n3. Hourly Urine Output (must be >= 30 mL/hour or >= 100 mL/4 hours; magnesium is 100% renally eliminated, oliguria leads to rapid toxicity).",
            pkPd = "Rapid onset of action: IV immediate, IM ~1 hour. Duration of action: IV ~30 minutes, IM ~3-4 hours. Widely distributed; 30% bound to albumin. Excreted almost exclusively unchanged by glomerular filtration in kidneys. Anticonvulsant effect mediated via blockade of NMDA receptor ion channels and reduction of presynaptic acetylcholine release at the neuromuscular junction.",
            renalAdj = "CrCl 20-50 mL/min: Reduce maintenance dose by 25-50%. CrCl <20 mL/min: Reduce maintenance dose by 50-75% and check serum magnesium levels every 4 hours. Oliguria / Anuria: Discontinue maintenance infusion.",
            hepaticAdj = "No dosage adjustment required (eliminated 100% renally).",
            pregnancy = "Category D / High Benefit: Drug of choice for eclampsia. Do not withhold in life-threatening eclampsia. Limit continuous maternal infusions to <=5-7 days to prevent neonatal skeletal demineralization and hypocalcemia.",
            lactation = "Excreted into breast milk in modest amounts; safe and compatible with breastfeeding.",
            sideEffects = "Flushing, feeling of warmth, diaphoresis, hypotension, nausea, loss of deep tendon reflexes, muscle weakness, hypocalcemia, respiratory depression, bradycardia, cardiac arrest.",
            priceNpr = "NPR 35.00 - 65.00 per 50% 2mL / 10mL ampoule",
            priceInr = "INR 20.00 - 45.00 per 50% 2mL / 10mL ampoule",
            brandsNepal = listOf(
                BrandInfo("Mag-Sulf", "Lomus Pharmaceuticals", "Inj", "50% w/v (5g/10mL)"),
                BrandInfo("Magnesium Sulfate", "Nepal Pharmaceuticals Lab (NPL)", "Inj", "50% w/v (1g/2mL & 5g/10mL)"),
                BrandInfo("Magsul-C", "Curex Pharmaceuticals", "Inj", "50% w/v")
            ),
            brandsIndia = listOf(
                BrandInfo("Magmin", "Neon Laboratories", "Inj", "50% w/v (1g/2mL & 5g/10mL)"),
                BrandInfo("Magnesium Sulphate", "Troikaa Pharmaceuticals", "Inj", "50% w/v"),
                BrandInfo("Magsulf", "Bharat Serums & Vaccines", "Inj", "50% w/v")
            ),
            pediatricDosePerKg = 40.0,
            pediatricInterval = "mg/kg IV single dose over 20 min for severe asthma exacerbation",
            adultDose = "Eclampsia: 4 g IV over 15 min + 10 g IM stat, then 5 g IM q4h or 1-2 g/h IV.",
            childDose = "Asthma: 25-50 mg/kg IV over 20 min (max 2 g).",
            contraindications = "Myasthenia gravis (precipitates severe myasthenic crisis), complete heart block, severe myocardial damage, anuria.",
            modeOfAction = "Blocks voltage-gated calcium channels and presynaptic acetylcholine release at motor endplates; voltage-dependent blocker of NMDA receptor channels in central nervous system; relaxes vascular and bronchial smooth muscle.",
            precautions = "NEVER administer without testing knee-jerk reflexes and measuring respiratory rate. Reduce dose in renal impairment.",
            nemlCategory = "Nepal Essential Medicines List (Priority Obstetric & Emergency Medicine)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो सुत्केरी व्यथा वा गर्भावस्थामा देखिने कडा रक्तचाप र काम्ने समस्या (एक्लाम्प्सिया) रोक्न दिइने जीवनरक्षक औषधि हो। औषधि दिँदा जिउ तातो हुने वा पसिना आउने सामान्य हुन्छ। सास फेर्न गाह्रो भए वा खुट्टा कमजोर लागे तुरुन्त स्वास्थ्यकर्मीलाई भन्नुहोस्।",
            counselingEnglish = "Life-saving anticonvulsant for prevention and management of eclamptic convulsions in pregnancy. Transient flushing and sensation of warmth are common. Inform nurse or doctor immediately if experiencing shortness of breath or extreme weakness.",
            era = "Older / Classical (Pritchard protocol established 1955)",
            therapeuticClassTag = "Anticonvulsant / Tocolytic / Emergency Resuscitation"
        ),

        // ==========================================
        // 2. CLONAZEPAM (Monotherapy)
        // ==========================================
        Drug(
            id = "d_vital_clonazepam_mono",
            genericName = "Clonazepam",
            system = "Central Nervous System (CNS)",
            drugClass = "High-Potency Long-Acting Benzodiazepine Anticonvulsant & Anxiolytic",
            blackBoxWarning = "CONCOMITANT USE WITH OPIOIDS, ABUSE, MISUSE, DEPENDENCE & WITHDRAWAL: Concomitant use with opioids may cause profound sedation, respiratory depression, coma, and death. Abrupt discontinuation can trigger life-threatening seizures and protracted withdrawal syndrome.",
            indications = "Panic disorder with or without agoraphobia; absence seizures, atypical absence, myoclonic, and atonic seizures (Lennox-Gastaut syndrome); restless legs syndrome (RLS); acute manic agitation in bipolar disorder; REM sleep behavior disorder; neuroleptic-induced akathisia.",
            doses = "Panic Disorder:\n• Initial: 0.25 mg PO BID; may increase after 3 days to 0.5 mg BID (target 1 mg/day; max 4 mg/day).\nSeizure Disorders:\n• Adult: Initial 0.5 mg PO TID; increase by 0.5 to 1 mg every 3 days until seizures are controlled (max 20 mg/day).\n• Pediatric: Initial 0.01 to 0.03 mg/kg/day PO divided in 2-3 doses; titrate by 0.25-0.5 mg every 3 days (max 0.05 mg/kg/day).\nRestless Legs Syndrome:\n• 0.5 to 2 mg PO once daily at bedtime.\nAkathisia:\n• 0.5 to 2 mg PO daily in divided doses.",
            administration = "Take orally with or without food. Tablets can be swallowed whole with water or dispersed (mouth-dissolving MD formulation placed on tongue).",
            timing = "Divided daily doses; larger portion may be taken at bedtime to mitigate daytime sedation.",
            specialInstructions = "NEPAL DDA SCHEDULE 'KA' (नियन्त्रित मनोद्विपक औषधि / Controlled Psychotropic Substance). High potency: 0.5 mg clonazepam is equivalent to approximately 10 mg diazepam. Intermediate-to-long elimination half-life (30-40 hours) provides smooth, sustained anxiolysis with less inter-dose rebound compared to alprazolam. Taper dose very slowly (e.g., reduce by 0.25 mg every 1-2 weeks) when discontinuing.",
            pkPd = "Oral bioavailability ~90%. Peak plasma concentration in 1-4 hours. Protein binding 85%. Extensively metabolized in the liver primarily via CYP3A4-mediated nitroreduction to 7-amino-clonazepam (inactive) followed by acetylation. Elimination half-life: 30 to 40 hours. Excreted mainly in urine as metabolites.",
            renalAdj = "Mild to moderate: No dosage adjustment required. Severe (CrCl <30 mL/min): Start at low dose (0.25 mg/day) and monitor for excessive sedation.",
            hepaticAdj = "Mild to moderate hepatic impairment: Use lower doses and titrate slowly. Severe hepatic impairment or acute cirrhosis: Contraindicated (risk of precipitating hepatic encephalopathy).",
            pregnancy = "Category D (Contraindicated; risk of congenital cardiovascular malformations, neonatal floppy infant syndrome, and withdrawal symptoms).",
            lactation = "Excreted in human breast milk; can cause neonatal drowsiness, feeding difficulty, and lethargy. Avoid during breastfeeding or monitor infant closely.",
            sideEffects = "Drowsiness, ataxia, impaired coordination, dizziness, fatigue, anterograde amnesia, dysarthria, behavioral disinhibition in children, depression, cognitive slowing.",
            priceNpr = "NPR 35.00 - 85.00 per strip of 10 (0.5 mg / 1 mg / 2 mg)",
            priceInr = "INR 25.00 - 65.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Clonafit", "Torrent / Medisales Nepal", "Tab / MD Tab", "0.25 mg / 0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Zapiz", "Intas / Medisales Nepal", "Tab / MD Tab", "0.25 mg / 0.5 mg / 1 mg"),
                BrandInfo("Lonazep", "Sun Pharma Nepal", "Tab", "0.25 mg / 0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Epizam", "Deurali-Janta Pharmaceuticals", "Tab", "0.5 mg / 1 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Klonopin", "Roche India", "Tab", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Clonafit", "Torrent Pharmaceuticals", "Tab", "0.25 mg / 0.5 mg / 1 mg"),
                BrandInfo("Zapiz", "Intas Pharmaceuticals", "MD Tab", "0.25 mg / 0.5 mg / 1 mg"),
                BrandInfo("Epitril", "Novartis India", "Tab", "0.5 mg / 2 mg")
            ),
            pediatricDosePerKg = 0.02,
            pediatricInterval = "mg/kg/day PO divided BID-TID for pediatric seizures",
            adultDose = "Panic: 0.25-0.5 mg PO BID (max 4 mg/d). Seizures: 0.5 mg TID, titrate up to 4-8 mg/d.",
            childDose = "0.01-0.03 mg/kg/day PO divided BID-TID (max 0.05 mg/kg/day).",
            contraindications = "Severe hepatic insufficiency, acute narrow-angle glaucoma, severe respiratory insufficiency or acute respiratory depression, myasthenia gravis, sleep apnea.",
            modeOfAction = "Potentiates central inhibitory neurotransmission by binding to the benzodiazepine site on GABAA receptors, increasing chloride ion conductance and hyperpolarizing neuronal membranes.",
            precautions = "BEERS CRITERIA HIGH RISK in elderly: Increases risks of cognitive impairment, delirium, falls, and fractures. Concomitant alcohol or opioid use can cause fatal respiratory arrest.",
            nemlCategory = "Nepal Essential Medicines List (Anticonvulsants & Controlled Formulary)",
            ddaSchedule = "Schedule 'Ka' (क वर्ग - Controlled Narcotic/Psychotropic Drug)",
            beersCriteriaRisk = "HIGH RISK: Avoid in older adults; causes profound sedation, ataxia, severe falls, and memory impairment.",
            counselingNepali = "यो कडा छारेरोग, अत्याधिक त्रास (प्यानिक अट्याक) तथा हातखुट्टा काम्ने समस्यामा दिइने औषधि हो। औषधि खाएपछि निन्द्रा लाग्ने र सन्तुलन गुम्ने हुनाले गाडी नचलाउनुहोस्। रक्सीसँग कहिल्यै नलिनुहोस्। डाक्टरको सल्लाह बिना अचानक यो औषधि खान बन्द नगर्नुहोस् किनकि यसले कडा काम्ने समस्या ल्याउन सक्छ।",
            counselingEnglish = "Indicated for panic disorder, seizure control, and restless legs. Causes significant sedation and impaired coordination; avoid driving and alcohol. Never stop taking this medicine abruptly as it may cause dangerous withdrawal seizures.",
            era = "Older / Classical (Patented 1960, Roche)",
            therapeuticClassTag = "Anticonvulsant / Anxiolytic / Benzodiazepine"
        ),

        // ==========================================
        // 3. PHENOBARBITAL (Phenobarbitone)
        // ==========================================
        Drug(
            id = "d_vital_phenobarbital",
            genericName = "Phenobarbital (Phenobarbitone)",
            system = "Central Nervous System (CNS)",
            drugClass = "Long-Acting Barbiturate Anticonvulsant & Sedative",
            blackBoxWarning = "DEPENDENCE, TOLERANCE & SEVERE CNS/RESPIRATORY DEPRESSION: Habit-forming barbiturate. High risk of tolerance and psychological/physical dependence. Rapid IV administration may produce severe respiratory depression, apnea, laryngospasm, and hypotension.",
            indications = "WHO #1 first-line drug for neonatal seizures; generalized tonic-clonic and focal seizures (especially in resource-limited primary healthcare); refractory status epilepticus; severe alcohol and sedative withdrawal detoxification; unconjugated hyperbilirubinemia in Crigler-Najjar syndrome Type II and Gilbert syndrome (via UGT1A1 hepatic enzyme induction).",
            doses = "Neonatal Seizures (WHO Gold Standard):\n• Loading Dose: 20 mg/kg IV infused slowly over 15-20 min (rate <= 1 mg/kg/min).\n• If seizures continue after 15 min: Additional 5 to 10 mg/kg doses up to cumulative max 40 mg/kg.\n• Maintenance: 3 to 5 mg/kg/day PO or IV divided in 1-2 doses (start 12-24h post-loading).\nAdult Epilepsy Maintenance:\n• 60 to 180 mg PO once daily at bedtime (or divided BID).\nPediatric Epilepsy Maintenance:\n• 3 to 6 mg/kg/day PO in 1-2 divided doses.\nRefractory Status Epilepticus:\n• 15 to 20 mg/kg IV at infusion rate not exceeding 50 to 100 mg/min (respiratory support must be immediately available).",
            administration = "Oral: Take at bedtime. Intravenous: Dilute in Normal Saline or sterile water for injection; inject slowly at rate <= 50-100 mg/min in adults, <= 1 mg/kg/min in neonates. Intramuscular: Deep IM into large muscle mass.",
            timing = "Once daily at bedtime due to long half-life and sedative properties.",
            specialInstructions = "NEPAL DDA SCHEDULE 'KA' (Controlled Drug). Therapeutic serum range: 15 to 40 mcg/mL. Potent inducer of hepatic CYP450 enzymes (CYP3A4, CYP2C9, CYP1A2, and UGT): drastically accelerates metabolism of oral contraceptives (causes contraceptive failure!), warfarin, antiretrovirals, statins, and antiepileptics. Paradoxical hyperactivity and aggression can occur in children.",
            pkPd = "Oral bioavailability 95-100%. Peak plasma concentration in 1-6 hours. Protein binding 45-50%. Hepatic metabolism (~75%) via CYP2C9/CYP2E1 hydroxylation and glucuronidation; 25% excreted unchanged in urine. Elimination half-life is extremely prolonged: 75 to 120 hours in adults, and up to 100-200 hours in neonates.",
            renalAdj = "CrCl 10-50 mL/min: Increase dosing interval to q12-18h. CrCl <10 mL/min: Increase dosing interval to q24-36h. Hemodialysis: Moderately dialyzable; give supplemental dose post-dialysis.",
            hepaticAdj = "Use with extreme caution. Reduce maintenance dose by 50% in cirrhosis; contraindicated in severe hepatic impairment or impending hepatic coma.",
            pregnancy = "Category D (Major teratogen: Fetal Hydantoin/Barbiturate Syndrome, cardiac defects, cleft lip/palate, microcephaly; causes neonatal hemorrhagic disease via Vitamin K deficiency; administer Vitamin K1 to mother in last month of pregnancy and to neonate at birth).",
            lactation = "Excreted in human milk in substantial amounts; causes neonatal sedation, poor sucking, and weight loss. Monitor closely or consider formula feeding.",
            sideEffects = "Drowsiness, cognitive impairment, paradoxical hyperactivity in children, depression in adults, megaloblastic anemia (folate deficiency), osteomalacia/rickets (accelerated vitamin D catabolism), ataxia, Dupuytren's contracture, Stevens-Johnson syndrome.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 10 (30 mg / 60 mg) / NPR 25.00 per 200mg ampoule",
            priceInr = "INR 10.00 - 25.00 per strip of 10 / INR 18.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Gardenal", "Sanofi / Medisales Nepal", "Tab / Syr / Inj", "30 mg / 60 mg / 200mg/mL"),
                BrandInfo("Luminal", "Bayer Nepal", "Tab", "30 mg / 60 mg"),
                BrandInfo("Phenobarbitone", "Nepal Aushadhi Ltd (NAL)", "Tab", "30 mg / 60 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Gardenal", "Sanofi India", "Tab", "30 mg / 60 mg"),
                BrandInfo("Luminal", "Bayer India", "Tab", "30 mg / 60 mg"),
                BrandInfo("Phenokem", "Alkem Laboratories", "Inj / Tab", "200mg Inj / 30mg / 60mg"),
                BrandInfo("Barbee", "Mankind Pharma", "Tab", "30 mg / 60 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "mg/kg IV loading dose over 20 min for neonatal seizures",
            adultDose = "Maintenance: 60-180 mg PO once daily at bedtime. Status: 15-20 mg/kg IV.",
            childDose = "Neonatal: 20 mg/kg IV load, then 3-5 mg/kg/day PO/IV. Child: 3-6 mg/kg/day PO.",
            contraindications = "Acute intermittent porphyria (induces ALA synthetase, precipitating life-threatening paralysis), severe respiratory depression, severe hepatic impairment, barbiturate hypersensitivity.",
            modeOfAction = "Binds to allosteric barbiturate sites on GABAA receptor, prolonging the duration of chloride channel openings, enhancing GABA-mediated inhibition, and reducing calcium-dependent action potentials.",
            precautions = "BEERS CRITERIA HIGH RISK in elderly: Causes severe sedation, confusion, and falls. Taper gradually over weeks/months to prevent rebound status epilepticus. Screen for osteopenia with chronic therapy.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Anticonvulsant)",
            ddaSchedule = "Schedule 'Ka' (क वर्ग - Controlled Drug)",
            beersCriteriaRisk = "HIGH RISK: Avoid in older adults; causes high rate of physical dependence, severe sedation, cognitive slowing, and fractures.",
            counselingNepali = "यो नवजात शिशु तथा बालबालिकामा देखिने कडा छारेरोग र काम्ने समस्या नियन्त्रण गर्ने प्रमुख औषधि हो। औषधि राति सुत्ने बेला खानु उपयुक्त हुन्छ। यो औषधि लिइरहेका महिलाहरूले गर्भनिरोधक चक्की खाएमा प्रभाव कम हुन सक्छ, त्यसैले अन्य साधन प्रयोग गर्नुपर्छ। औषधि अचानक खान नछोड्नुहोस्।",
            counselingEnglish = "Primary antiepileptic for neonatal seizures and seizure maintenance. Usually taken once daily at bedtime. Significantly reduces effectiveness of hormonal birth control pills; use barrier contraception. Never discontinue abruptly.",
            era = "Older / Classical (Introduced 1912 by Bayer)",
            therapeuticClassTag = "Anticonvulsant / Barbiturate / Emergency Medicine"
        ),

        // ==========================================
        // 4. CHLORPROMAZINE HYDROCHLORIDE
        // ==========================================
        Drug(
            id = "d_vital_chlorpromazine",
            genericName = "Chlorpromazine Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "First-Generation Low-Potency Aliphatic Phenothiazine Antipsychotic",
            blackBoxWarning = "INCREASED MORTALITY IN ELDERLY PATIENTS WITH DEMENTIA-RELATED PSYCHOSIS: Elderly patients with dementia-related psychosis treated with antipsychotic drugs are at an increased risk of death (mostly cardiovascular or infectious in nature).",
            indications = "Acute psychotic agitation and schizophrenia; intractable hiccups (singultus refractory to other measures); acute intermittent porphyria; adjunctive treatment of tetanus convulsions; severe acute nausea and vomiting; severe behavioral problems in children with explosive hyperexcitability.",
            doses = "Acute Psychotic Agitation:\n• Oral: 25 to 50 mg PO TID; titrate by 25-50 mg every 3-4 days up to 200 to 800 mg/day (in severe inpatient psychosis up to 1000 mg/day).\n• Intramuscular: 25 to 50 mg deep IM; if needed, repeat in 1 hour (keep patient supine); max 400 mg/24h.\nIntractable Hiccups (Singultus):\n• 25 to 50 mg PO TID to QID for 3 days.\n• If oral therapy fails: 25 to 50 mg slow IV infusion (diluted in 500-1000 mL Normal Saline) administered over several hours.\nTetanus Adjunct:\n• 25 to 50 mg IM or slow IV q6-8h alongside muscle relaxants and antitoxin.\nPediatric (>=6 months):\n• 0.5 to 1 mg/kg/dose PO q4-6h PRN (max 40 mg/day for children <5 years, 75 mg/day for 5-12 years).",
            administration = "Oral: Take with meals or a full glass of water/milk to avoid gastric irritation. Deep IM: Inject slowly deep into gluteal muscle; patient MUST remain supine for at least 30-60 minutes post-injection to prevent severe postural collapse.",
            timing = "Divided daily doses; largest dose at bedtime due to profound sedative properties.",
            specialInstructions = "POSTURAL HYPOTENSION ALERT: Potent alpha-1 adrenergic blockade causes marked orthostatic hypotension and reflex tachycardia. Monitor blood pressure closely after parenteral doses. High anticholinergic and antihistaminic potency causes marked sedation and dry mouth. Long-term use (>1 year) can cause purple/gray cutaneous pigmentation in sun-exposed areas and corneal/lenticular opacities.",
            pkPd = "Oral bioavailability ~20-30% due to extensive first-pass hepatic metabolism. Peak plasma in 2-4 hours PO, 20-30 min IM. Protein binding 92-97%. Extensively metabolized in liver (CYP2D6, CYP1A2) to over 100 metabolites (some active like 7-hydroxychlorpromazine). Elimination half-life ~30 hours. Renally excreted.",
            renalAdj = "CrCl <50 mL/min: Start with low initial dose (25-50% of standard) due to increased sensitivity to hypotensive and sedative effects.",
            hepaticAdj = "Use with extreme caution. Contraindicated in severe liver disease or acute hepatic encephalopathy.",
            pregnancy = "Category C (Third-trimester exposure carries risk of neonatal extrapyramidal and withdrawal symptoms, including tremor, hypotonia, and respiratory distress).",
            lactation = "Excreted in human breast milk; can cause neonatal drowsiness and lethargy. Not recommended during breastfeeding.",
            sideEffects = "Severe sedation, orthostatic hypotension, tachycardia, dry mouth, constipation, urinary retention, blurred vision, extrapyramidal symptoms (dystonia, parkinsonism, tardive dyskinesia), cholestatic jaundice, photosensitivity, hyperprolactinemia, Neuroleptic Malignant Syndrome (NMS).",
            priceNpr = "NPR 18.00 - 45.00 per strip of 10 (25 mg / 50 mg / 100 mg) / NPR 25.00 per 50mg/2mL ampoule",
            priceInr = "INR 12.00 - 32.00 per strip of 10 / INR 18.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Largactil", "Sanofi / Medisales Nepal", "Tab / Inj", "25 mg / 50 mg / 100 mg / 50mg/2mL"),
                BrandInfo("Chlorpromazine", "Nepal Aushadhi Ltd (NAL)", "Tab", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Megatil", "Sun Pharma Nepal", "Tab", "25 mg / 50 mg / 100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Largactil", "Abbott / Sanofi India", "Tab / Inj", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Sun Prazin", "Sun Pharma", "Tab / Inj", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Megatil", "Intas Pharmaceuticals", "Tab", "50 mg / 100 mg")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "mg/kg/dose PO q6-8h PRN for severe behavioral agitation",
            adultDose = "Psychosis: 25-50 mg TID, titrate to 200-800 mg/d. Hiccups: 25-50 mg PO TID-QID.",
            childDose = "0.55 mg/kg PO q4-6h PRN (max 40 mg/day under 5 yrs, 75 mg/day 5-12 yrs).",
            contraindications = "Comatose states or presence of large amounts of CNS depressants (alcohol, barbiturates, opioids), severe bone marrow depression, severe cardiovascular collapse, pheochromocytoma.",
            modeOfAction = "Antagonist at postsynaptic mesolimbic dopamine D2 receptors; also possesses strong alpha-1 adrenergic, muscarinic M1, and histamine H1 receptor blocking properties.",
            precautions = "BEERS CRITERIA HIGH RISK in elderly: Increases fall risk, syncope, anticholinergic toxicity, and mortality. Wear sunscreen to avoid severe phototoxic sunburn. Monitor for early signs of tardive dyskinesia.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Antipsychotic)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            beersCriteriaRisk = "HIGH RISK: Avoid in older adults; causes profound orthostatic hypotension, anticholinergic delirium, and tardive dyskinesia.",
            counselingNepali = "यो कडा मानसिक छटपटी, उत्तेजना तथा रोकिंदै नरोकिने बाडुली (हिक्का) नियन्त्रण गर्न प्रयोग गरिने औषधि हो। यो औषधि खाएपछि रिंगटा लाग्ने र आँखा धमिलो हुने हुनाले बसेर वा सुतेर बिस्तारै मात्र उठ्नुहोस्। घाममा निस्कँदा छाला डढ्न सक्ने भएकाले घामबाट बच्नुहोस्। रक्सी कहिल्यै नलिनुहोस्।",
            counselingEnglish = "Indicated for acute severe agitation, psychosis, and persistent intractable hiccups. Causes significant dizziness and low blood pressure upon standing; rise slowly from lying/sitting. Avoid sun exposure due to photosensitivity.",
            era = "Older / Classical (First antipsychotic synthesized 1950, Rhône-Poulenc)",
            therapeuticClassTag = "Typical Antipsychotic / Phenothiazine / Neuroleptic"
        ),

        // ==========================================
        // 5. TRIHEXYPHENIDYL HYDROCHLORIDE (Benzhexol)
        // ==========================================
        Drug(
            id = "d_vital_trihexyphenidyl",
            genericName = "Trihexyphenidyl Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Centrally-Acting Anticholinergic (Antimuscarinic)",
            blackBoxWarning = null,
            indications = "Prevention and management of drug-induced extrapyramidal symptoms (EPS) including acute dystonia, pseudoparkinsonism, and akathisia caused by typical and atypical antipsychotics or metoclopramide; idiopathic Parkinson's disease (most effective for reducing resting tremor and rigidity); post-encephalitic parkinsonism.",
            doses = "Antipsychotic-Induced Extrapyramidal Symptoms (EPS):\n• Prevention & Treatment: 1 to 2 mg PO once daily or BID; gradually increase by 1 mg every few days to typical effective maintenance dose of 5 to 15 mg/day in divided doses (usually 2 mg TID or QID with meals).\nIdiopathic Parkinson's Disease:\n• Initial: 1 mg PO once daily on day 1 with meals; increase by 2 mg every 3 to 5 days to target 6 to 10 mg/day divided in 3 doses (max 15 mg/day).\nAcute Dystonic Reaction (Adjunctive to IV/IM Diphenhydramine or Promethazine):\n• 2 to 5 mg PO or continue orally after acute parenteral resolution.",
            administration = "Take orally with meals or immediately after food to minimize gastrointestinal discomfort and nausea. If mouth dryness is severe, take before meals unless it causes nausea.",
            timing = "Divided in 3 to 4 doses daily with meals; avoid large evening doses to prevent insomnia and vivid nightmares.",
            specialInstructions = "ANTIDOTE TO ANTIPSYCHOTIC DYSTONIA: Very commonly co-prescribed with Haloperidol, Chlorpromazine, Fluphenazine, and Risperidone. Watch for abuse potential (causes mild euphoria and hallucinations at supratherapeutic doses). Prominent peripheral anticholinergic side effects: dry mouth, blurred vision, constipation, urinary hesitancy/retention, and anhidrosis (impaired sweating in hot climates can precipitate fatal hyperthermia/heat stroke in Terai region of Nepal).",
            pkPd = "Well absorbed orally. Peak plasma concentration in 1-2 hours. High lipid solubility allows rapid penetration across blood-brain barrier. Extensively metabolized in the liver; terminal elimination half-life ~10 to 12 hours. Excreted in urine as metabolites and unchanged drug.",
            renalAdj = "Use with caution in renal impairment; monitor closely for anticholinergic toxicity and urinary retention.",
            hepaticAdj = "Use with caution; metabolized by liver.",
            pregnancy = "Category C (Safety in human pregnancy not established; use only if potential maternal benefits clearly outweigh fetal risks).",
            lactation = "Anticholinergics can suppress maternal lactation; may be excreted in breast milk. Use with caution.",
            sideEffects = "Dry mouth (xerostomia), blurred vision, mydriasis, cycloplegia, urinary retention, constipation, tachycardia, dizziness, nausea, confusion, memory impairment, hallucinations in elderly, reduced sweating.",
            priceNpr = "NPR 22.00 - 55.00 per strip of 10 (2 mg) / NPR 35.00 per strip of 10 (5 mg)",
            priceInr = "INR 15.00 - 38.00 per strip of 10 (2 mg)",
            brandsNepal = listOf(
                BrandInfo("Pacitane", "Pfizer / Medisales Nepal", "Tab", "2 mg"),
                BrandInfo("Parkin", "Sun Pharma Nepal", "Tab", "2 mg / 5 mg"),
                BrandInfo("Trihex", "Torrent / Medisales Nepal", "Tab", "2 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pacitane", "Pfizer India", "Tab", "2 mg"),
                BrandInfo("Parkin", "Sun Pharma", "Tab", "2 mg / 5 mg"),
                BrandInfo("Bexol", "Intas Pharmaceuticals", "Tab", "2 mg"),
                BrandInfo("Triphen", "Cipla Ltd.", "Tab", "2 mg")
            ),
            adultDose = "EPS: 1-2 mg PO BID initially, titrate to 5-15 mg/day divided TID-QID with meals.",
            childDose = "Not recommended in children <3 years. Older children with dystonia: 0.5-2 mg PO daily.",
            contraindications = "Angle-closure glaucoma, urinary tract obstruction / urinary retention (e.g. severe benign prostatic hyperplasia), paralytic ileus, myasthenia gravis, tardive dyskinesia (worsens tardive dyskinesia!).",
            modeOfAction = "Competitive antagonist at central and peripheral muscarinic acetylcholine receptors (M1/M4), restoring the balance between dopaminergic and cholinergic neurotransmission in the striatum.",
            precautions = "BEERS CRITERIA HIGH RISK in older adults: Potent anticholinergic causing severe delirium, confusion, cognitive decline, constipation, and urinary retention. DO NOT USE for tardive dyskinesia.",
            nemlCategory = "Nepal Essential Medicines List (Antiparkinsonian Medicines)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            beersCriteriaRisk = "HIGH RISK: Strongly avoid in older adults; precipitates acute delirium, urinary retention, and cognitive worsening.",
            counselingNepali = "यो मानसिक रोगका कडा औषधिहरूले गर्दा शरीर अरट्ठ पर्ने, जिउ काम्ने वा घाँटी बटारिने समस्या रोक्न दिइने औषधि हो। औषधि खाएपछि मुख धेरै सुक्खा हुने हुनाले प्रशस्त पानी पिउनुहोस्। पिसाब रोकिन सक्ने वा आँखा धमिलो हुन सक्ने भएकाले त्यस्तो भएमा तुरुन्त डाक्टरलाई देखाउनुहोस्। गर्मी मौसममा धेरै तातोबाट बच्नुहोस् किनकि यसले पसिना आउन कम गर्छ।",
            counselingEnglish = "Prescribed to prevent and treat muscle stiffness, neck spasms, and tremors caused by antipsychotic medications. Causes dry mouth; sip water or chew sugar-free gum. Caution in hot weather as it decreases sweating. Report difficulty urinating immediately.",
            era = "Older / Classical (Approved 1949 by Lederle/Cyanamid)",
            therapeuticClassTag = "Anticholinergic / Antiparkinsonian / EPS Antidote"
        ),

        // ==========================================
        // 6. AMPICILLIN SODIUM
        // ==========================================
        Drug(
            id = "d_vital_ampicillin",
            genericName = "Ampicillin Sodium",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Aminopenicillin Beta-Lactam Antibiotic",
            blackBoxWarning = null,
            indications = "WHO empirical first-line therapy for neonatal sepsis and meningitis (combined with Gentamicin); Listeria monocytogenes meningitis and bacteremia in neonates, elderly, and immunocompromised patients; Enterococcus faecalis endocarditis and urinary tract infections (combined with Ceftriaxone or Gentamicin); intrapartum maternal Group B Streptococcus (GBS) prophylaxis to prevent neonatal early-onset sepsis; severe salmonellosis / enteric fever (where susceptible).",
            doses = "Neonatal Sepsis / Meningitis (with Gentamicin):\n• Age <= 7 days: 50 mg/kg IV q12h (for meningitis: 100 mg/kg IV q12h).\n• Age 8-28 days: 50 mg/kg IV q8h (for meningitis: 100 mg/kg IV q8h).\nAdult Listeria Meningitis:\n• 2 g IV q4h (total 12 g/24h) plus Gentamicin for at least 21 days.\nEnterococcal Endocarditis:\n• 2 g IV q4h plus Ceftriaxone 2 g IV q12h for 6 weeks (preferred renal-sparing synergistic regimen).\nIntrapartum GBS Prophylaxis:\n• 2 g IV loading dose at onset of labor or rupture of membranes, followed by 1 g IV q4h until delivery.\nPediatric Severe Infections:\n• 100 to 200 mg/kg/day IV divided q6h (max 12 g/day).",
            administration = "Slow intravenous injection over 3 to 5 minutes, or intermittent IV infusion over 15 to 30 minutes in Normal Saline. Deep intramuscular injection can be given if IV access is impossible.",
            timing = "Regular divided intervals (q4h, q6h, or q8h) to maintain serum concentration above minimum inhibitory concentration (time-dependent killing: %T > MIC).",
            specialInstructions = "WORKHORSE FOR LISTERIA & ENTEROCOCCUS: Cephalosporins (like ceftriaxone) have ZERO activity against Listeria monocytogenes and Enterococcus faecalis; Ampicillin is mandatory when these pathogens are suspected. High risk of non-allergic maculopapular rash (up to 90%) if given to patients with Epstein-Barr virus (Infectious Mononucleosis) or CMV; do not give in acute pharyngitis without ruling out mono.",
            pkPd = "Oral bioavailability is poor (30-40%) and decreased by food; parenteral administration is strictly preferred for serious systemic infections. Widely distributed into body fluids; crosses inflamed meninges into CSF (concentrations up to 30-50% of serum). Excreted rapidly and predominantly unchanged in urine via glomerular filtration and tubular secretion. Half-life ~1 to 1.5 hours.",
            renalAdj = "CrCl 30-50 mL/min: Increase interval to q6-8h. CrCl 10-29 mL/min: Increase interval to q8-12h. CrCl <10 mL/min: Increase interval to q12-24h. Hemodialysis: 500 mg - 1 g post-dialysis.",
            hepaticAdj = "No dosage adjustment necessary.",
            pregnancy = "Category B (Safe; extensively used in pregnancy, standard agent for intrapartum GBS prophylaxis).",
            lactation = "Excreted in low concentrations in breast milk; compatible with breastfeeding. Monitor infant for diarrhea or thrush.",
            sideEffects = "Diarrhea, nausea, maculopapular rash, urticaria, anaphylaxis (penicillin hypersensitivity), Clostridioides difficile colitis, elevated transaminases, interstitial nephritis, neurotoxicity/seizures at very high doses in renal failure.",
            priceNpr = "NPR 25.00 - 45.00 per 500mg / 1g vial",
            priceInr = "INR 18.00 - 35.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Ampicin", "Nepal Pharmaceuticals Lab (NPL)", "Inj", "500 mg / 1 g"),
                BrandInfo("Ros-Amp", "Quest Pharmaceuticals", "Inj", "500 mg / 1 g"),
                BrandInfo("Ampicillin", "Nepal Aushadhi Ltd (NAL)", "Inj", "500 mg / 1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Campicillin", "Cadila Pharmaceuticals", "Inj", "500 mg / 1 g"),
                BrandInfo("Ampisyn", "Alkem Laboratories", "Inj", "500 mg / 1 g"),
                BrandInfo("Rosillin", "Sun Pharma", "Inj", "500 mg / 1 g"),
                BrandInfo("Biocilin", "Biochem Pharmaceutical", "Inj", "500 mg / 1 g")
            ),
            pediatricDosePerKg = 50.0,
            pediatricInterval = "mg/kg IV q8-12h for neonatal and infant sepsis",
            adultDose = "Listeria: 2 g IV q4h. Endocarditis: 2 g IV q4h + Ceftriaxone 2 g q12h. GBS: 2 g stat, then 1 g q4h.",
            childDose = "Neonatal: 50-100 mg/kg/dose IV q8-12h. Pediatric: 100-200 mg/kg/day divided q6h.",
            contraindications = "History of severe immediate hypersensitivity (anaphylaxis, angioedema) to penicillins or other beta-lactams.",
            modeOfAction = "Bactericidal inhibitor of bacterial cell wall synthesis; binds to penicillin-binding proteins (PBPs), inhibiting transpeptidation and cross-linking of peptidoglycan, leading to osmotic bacterial cell lysis.",
            precautions = "Perform penicillin skin testing or allergy history before administration. Ensure dose reduction in severe renal impairment to avoid neurotoxicity.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Access Antibiotic)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो नवजात शिशुमा रगतको कडा संक्रमण, मेनिन्जाइटिस तथा मुटुको भल्भको संक्रमणमा प्रयोग गरिने जीवनरक्षक एन्टिबायोटिक सुई हो। यदि बच्चालाई वा बिरामीलाई पेनिसिलिन औषधिबाट एलर्जी भएको इतिहास छ भने तुरुन्त स्वास्थ्यकर्मीलाई जानकारी गराउनुहोस्।",
            counselingEnglish = "Essential bactericidal antibiotic for neonatal sepsis, meningitis, and severe enterococcal infections. Inform healthcare team immediately if the patient has any known allergy to penicillin.",
            era = "Older / Classical (Introduced 1961 by Beecham)",
            therapeuticClassTag = "Antibiotic / Aminopenicillin / Neonatal Formulary"
        ),

        // ==========================================
        // 7. IMIPENEM + CILASTATIN
        // ==========================================
        Drug(
            id = "d_vital_imipenem_cilastatin",
            genericName = "Imipenem + Cilastatin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Broad-Spectrum Carbapenem + Renal Dehydropeptidase-I Inhibitor",
            blackBoxWarning = null,
            indications = "Severe polymicrobial sepsis; complicated intra-abdominal infections and infected necrotizing pancreatitis; hospital-acquired and ventilator-associated pneumonia (HAP/VAP); severe complicated skin and soft tissue infections (e.g. necrotizing fasciitis); complicated urinary tract infections; febrile neutropenia; infections caused by multidrug-resistant ESBL-producing Enterobacteriaceae and Acinetobacter/Pseudomonas aeruginosa.",
            doses = "Adult Severe Sepsis / Intra-Abdominal Infection:\n• 500 mg IV q6h (infused over 20-30 min) OR 1 g IV q8h (infused over 40-60 min).\nSevere Life-Threatening Infections / Resistant Pseudomonas:\n• 1 g IV q6h (max 4 g/day) infused over 60 minutes.\nPediatric Severe Infections (>=3 months):\n• 15 to 25 mg/kg IV q6h (max 2 to 4 g/day).\nInfected Necrotizing Pancreatitis:\n• 500 mg IV q6h for 14 days (demonstrated pancreatic tissue penetration).",
            administration = "Intravenous infusion only. Doses <= 500 mg should be infused over 20 to 30 minutes; doses > 500 mg should be infused over 40 to 60 minutes in Normal Saline or D5W. Slow infusion if patient experiences nausea.",
            timing = "Strict scheduled intervals (q6h or q8h) to maximize time above MIC (%T > MIC).",
            specialInstructions = "SEIZURE RISK CAUTION: Imipenem carries a significantly higher risk of inducing seizures (1.5-2%) compared to meropenem (<0.5%), particularly in patients with underlying CNS lesions, history of seizures, or unadjusted renal impairment. If treating meningitis or patients with central nervous system disorders, MEROPENEM is strongly preferred. Cilastatin has no antibacterial activity but prevents renal enzymatic degradation of imipenem by dehydropeptidase-I in proximal tubules and protects against imipenem nephrotoxicity.",
            pkPd = "Negligible oral absorption; given exclusively IV. Peak serum concentration 30-40 mcg/mL after 500 mg IV. Protein binding ~20%. Cilastatin competitively inhibits renal dehydropeptidase-I, allowing ~70% of imipenem to be excreted unchanged in urine in active form. Elimination half-life ~1 hour for both compounds.",
            renalAdj = "MANDATORY ADJUSTMENT TO PREVENT SEIZURES:\n• CrCl 41-70 mL/min: 500 mg IV q8h.\n• CrCl 21-40 mL/min: 500 mg IV q12h.\n• CrCl 6-20 mL/min: 250 mg IV q12h.\n• CrCl <6 mL/min or Hemodialysis: 250 mg IV q12h + give dose post-dialysis.",
            hepaticAdj = "No dosage adjustment necessary.",
            pregnancy = "Category C (Use only if potential maternal benefits justify potential fetal risks; meropenem is preferred Category B carbapenem in pregnancy).",
            lactation = "Excreted into human breast milk in low concentrations; compatible with breastfeeding. Monitor infant for loose stools.",
            sideEffects = "Nausea, vomiting, diarrhea, phlebitis at infusion site, drug-induced seizures (especially in renal impairment), rash, eosinophilia, elevated transaminases, Clostridioides difficile-associated diarrhea, positive Coombs test.",
            priceNpr = "NPR 1,200.00 - 2,400.00 per 500mg vial",
            priceInr = "INR 800.00 - 1,600.00 per 500mg vial",
            brandsNepal = listOf(
                BrandInfo("Tienam", "MSD / Medisales Nepal", "Inj", "500 mg / 500 mg"),
                BrandInfo("Imicrit", "Cipla Nepal", "Inj", "500 mg / 500 mg"),
                BrandInfo("Cilanem", "Ranbaxy / Sun Pharma Nepal", "Inj", "500 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Tienam", "MSD India", "Inj", "500 mg / 500 mg"),
                BrandInfo("Cilanem", "Sun Pharma", "Inj", "500 mg / 500 mg"),
                BrandInfo("Imicrit", "Cipla Ltd.", "Inj", "500 mg / 500 mg"),
                BrandInfo("Primaxin", "Merck Specialities", "Inj", "500 mg / 500 mg")
            ),
            pediatricDosePerKg = 20.0,
            pediatricInterval = "mg/kg IV q6h for severe pediatric infections (max 2 g/d)",
            adultDose = "500 mg IV q6h or 1 g IV q8h infused over 30-60 min (max 4 g/d).",
            childDose = "15-25 mg/kg IV q6h (max 2 g/day).",
            contraindications = "Severe hypersensitivity to carbapenems, penicillins, or other beta-lactams; concomitant administration with Valproic Acid / Sodium Valproate (carbapenems cause rapid, catastrophic drop in serum valproate levels within 24 hours, precipitating breakthrough seizures).",
            modeOfAction = "Bactericidal; binds with high affinity to PBPs (especially PBP-2 and PBP-1b) in Gram-negative and Gram-positive bacteria, inhibiting cell wall peptidoglycan synthesis; resistant to hydrolysis by most beta-lactamases and ESBLs.",
            precautions = "NEVER co-administer with sodium valproate. Adjust dose precisely for creatinine clearance to prevent seizure activity. Reserve for severe hospital infections to preserve susceptibility.",
            nemlCategory = "Nepal Essential Medicines List (WHO Watch / Reserve Group Antibiotic)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो अस्पतालको अति-सघन उपचार कक्ष (आईसीयू) वा वार्डमा कडा तथा ज्यान जोखिममा पार्ने जटिल ब्याक्टेरियल संक्रमणहरूमा दिइने उच्च क्षमताको एन्टिबायोटिक सुई हो। यो सुई दिँदा बान्ता आउने जस्तो भएमा सुईको गति ढिलो गर्न सकिन्छ। छारेरोगको औषधि खाइरहेका बिरामीमा यो औषधि प्रयोग गर्दा विशेष सावधानी अपनाउनुपर्छ।",
            counselingEnglish = "Broad-spectrum carbapenem for severe hospital-acquired and multi-resistant infections. Infusion should be administered slowly over 30-60 minutes. Inform physician immediately if patient has a history of seizures or is taking valproic acid.",
            era = "Older / Classical (First carbapenem discovered 1976, Merck)",
            therapeuticClassTag = "Carbapenem / Broad-Spectrum Antibiotic / Critical Care"
        ),

        // ==========================================
        // 8. ERYTHROMYCIN
        // ==========================================
        Drug(
            id = "d_vital_erythromycin",
            genericName = "Erythromycin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "14-Membered Macrolide Antibiotic & Motilin Receptor Agonist",
            blackBoxWarning = null,
            indications = "Bordetella pertussis (whooping cough treatment and post-exposure prophylaxis); Corynebacterium diphtheriae (respiratory and cutaneous, halts toxin production); Chlamydia trachomatis urogenital infections and neonatal inclusion conjunctivitis / pneumonia; alternative for streptococcal and staphylococcal infections in severe penicillin allergy; acute diabetic gastroparesis prokinetic; acute upper gastrointestinal bleeding preparation prior to emergency endoscopy (clears blood and clots).",
            doses = "Oral Antibacterial Therapy:\n• Adults: 250 to 500 mg PO q6h (or 500 mg q12h), taken on an empty stomach.\n• Pediatrics: 30 to 50 mg/kg/day PO divided in 3 to 4 doses (max 2 g/day).\nPertussis Treatment & Prophylaxis (CDC Guideline):\n• 500 mg PO QID for 14 days (or azithromycin for 5 days).\nProkinetic for Acute Upper GI Bleeding Pre-Endoscopy:\n• 250 mg IV infusion in 100 mL Normal Saline over 20 to 30 min, administered 30 to 90 minutes before emergency endoscopy.\nDiabetic Gastroparesis (Oral):\n• 125 to 250 mg PO TID taken 30 minutes before meals (short-term <=4 weeks due to tachyphylaxis).",
            administration = "Oral: Take on an empty stomach with a full glass of water, at least 1 hour before or 2 hours after meals (food impairs absorption of base and stearate salts). Intravenous: Dilute in Normal Saline or D5W and infuse over at least 30 to 60 minutes to prevent venous burning and thrombophlebitis.",
            timing = "Evenly spaced doses (q6h or q12h).",
            specialInstructions = "STRONG CYP3A4 INHIBITOR: High risk of life-threatening drug interactions with statins (simvastatin, atorvastatin -> rhabdomyolysis), theophylline (toxicity), carbamazepine, warfarin, and colchicine. MOTILIN AGONISM: Directly stimulates GI motilin receptors, causing intense gastric antral contractions, abdominal cramps, and nausea (exploited clinically as a prokinetic!). PYLORIC STENOSIS RISK: Maternal or neonatal use in infants <1 month carries an increased risk of Infantile Hypertrophic Pyloric Stenosis (IHPS).",
            pkPd = "Oral bioavailability is variable (15-45%) due to gastric acid degradation; enteric-coated and ester formulations improve stability. Peak plasma concentration in 1-4 hours. Protein binding 70-90%. Concentrates in macrophages and lung tissue. Extensively metabolized in the liver (CYP3A4); excreted predominantly in bile/feces; only 2-5% excreted in urine. Half-life ~1.5 to 2 hours.",
            renalAdj = "No adjustment required in mild to moderate impairment. In severe renal failure (CrCl <10 mL/min), max dose 1.5 to 2 g/day to prevent ototoxicity / hearing loss.",
            hepaticAdj = "Use with caution; risk of cholestatic hepatitis (especially with erythromycin estolate). Contraindicated in patients with prior history of erythromycin-induced hepatic dysfunction.",
            pregnancy = "Category B (Safe; erythromycin base/stearate is widely used in pregnancy. AVOID erythromycin estolate in pregnancy due to risk of maternal hepatotoxicity).",
            lactation = "Excreted in breast milk in low concentrations; compatible with breastfeeding. Monitor infant for diarrhea and signs of pyloric stenosis.",
            sideEffects = "Nausea, vomiting, abdominal cramping, diarrhea (motilin-mediated), QT interval prolongation, ventricular arrhythmias (Torsades de Pointes), cholestatic jaundice, reversible sensorineural hearing loss (at high doses), allergic rash.",
            priceNpr = "NPR 35.00 - 75.00 per strip of 10 (250 mg / 500 mg)",
            priceInr = "INR 25.00 - 55.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Althrocin", "Alembic / Medisales Nepal", "Tab / Syr", "250 mg / 500 mg / 125mg/5mL"),
                BrandInfo("Erythrocin", "Abbott Nepal", "Tab", "250 mg / 500 mg"),
                BrandInfo("E-Mycin", "Torrent Nepal", "Tab", "250 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Althrocin", "Alembic Pharmaceuticals", "Tab", "250 mg / 500 mg"),
                BrandInfo("Erythrocin", "Abbott India", "Tab", "250 mg / 500 mg"),
                BrandInfo("Eltocin", "Ipca Laboratories", "Tab", "250 mg / 500 mg")
            ),
            pediatricDosePerKg = 40.0,
            pediatricInterval = "mg/kg/day PO divided q6-8h for pediatric respiratory infections",
            adultDose = "Infection: 250-500 mg PO q6h or 500 mg q12h. Pre-endoscopy bleed: 250 mg IV over 30 min.",
            childDose = "30-50 mg/kg/day PO divided q6-8h (max 2 g/day).",
            contraindications = "Concomitant administration with astemizole, terfenadine, cisapride, pimozide, or ergot alkaloids; known hypersensitivity to macrolides; history of cholestatic jaundice with prior erythromycin.",
            modeOfAction = "Reversibly binds to the 50S ribosomal subunit of susceptible microorganisms, inhibiting translocation and protein synthesis (bacteriostatic, bactericidal at high concentrations); stimulates motilin receptors in the GI tract.",
            precautions = "Avoid concomitant QT-prolonging drugs. Educate patients regarding abdominal cramping as a known pharmacologic effect on gut motility.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Antimicrobial)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो लहरे खोकी (पर्ट्युसिस), घाँटीको कडा इन्फेक्सन तथा पेनिसिलिन एलर्जी भएका बिरामीमा प्रयोग गरिने एन्टिबायोटिक हो। यो औषधि खाली पेटमा (खाना खानुभन्दा १ घण्टा अगाडि वा २ घण्टा पछाडि) एक गिलास भरि पानीसँग खानुपर्छ। औषधिले पेट बटार्ने वा हल्का पेट दुख्ने हुन सक्छ। तोकिएको पुरा दिन औषधि सेवन गर्नुहोस्।",
            counselingEnglish = "Indicated for whooping cough (pertussis), respiratory infections, and as a gut prokinetic before endoscopy. Take on an empty stomach with a full glass of water. Abdominal cramping and nausea are common due to motilin stimulation. Complete the full prescribed course.",
            era = "Older / Classical (Discovered 1952 by Eli Lilly)",
            therapeuticClassTag = "Macrolide Antibiotic / Prokinetic / Essential Medicine"
        ),

        // ==========================================
        // 9. TINIDAZOLE
        // ==========================================
        Drug(
            id = "d_vital_tinidazole",
            genericName = "Tinidazole",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Second-Generation 5-Nitroimidazole Antiprotozoal & Antibacterial",
            blackBoxWarning = "CARCINOGENICITY IN RODENTS: Carcinogenicity has been seen in mice and rats treated chronically. Avoid unnecessary or prolonged use.",
            indications = "Giardiasis (single-dose cure); intestinal amoebiasis (amoebic dysentery); extraintestinal amoebiasis (amoebic liver abscess); Trichomoniasis (single-dose cure for patient and sexual partner); Bacterial Vaginosis; Helicobacter pylori eradication triple therapy; anaerobic surgical prophylaxis and dental infections.",
            doses = "Giardiasis (WHO & CDC Single-Dose Regimen):\n• Adults: 2 g (four 500 mg tablets) PO as a SINGLE STAT DOSE taken with food.\n• Pediatrics (>3 years): 50 mg/kg (up to 2 g) PO as a single stat dose with food.\nIntestinal Amoebiasis (Amoebic Dysentery):\n• Adults: 2 g PO once daily for 3 consecutive days.\n• Pediatrics: 50 mg/kg/day PO once daily for 3 days (max 2 g/day).\nAmoebic Liver Abscess:\n• Adults: 1.5 to 2 g PO once daily for 3 to 5 days.\n• Pediatrics: 50 mg/kg/day PO once daily for 3 to 5 days.\nTrichomoniasis (Urogenital):\n• Adults: 2 g PO as a SINGLE STAT DOSE (sexual partner must be treated simultaneously).\nBacterial Vaginosis:\n• 2 g PO once daily for 2 days, OR 1 g PO once daily for 5 days.",
            administration = "Take orally with or immediately after food to reduce gastrointestinal upset and metallic taste. Swallow tablets whole.",
            timing = "Single daily dose with dinner or evening meal.",
            specialInstructions = "EXTENDED HALF-LIFE & SUPERIOR TOLERABILITY: Tinidazole has a significantly longer half-life (12-14 hours vs 6-8 hours for metronidazole), permitting single-dose or convenient once-daily therapy with lower incidence of nausea and metallic taste. STRICT ALCOHOL AVOIDANCE (DISULFIRAM-LIKE REACTION): Consuming alcohol with tinidazole or within 72 hours of completion causes severe abdominal cramps, flushing, tachycardia, vomiting, and headache.",
            pkPd = "Rapid and complete oral absorption (bioavailability ~100%). Peak plasma concentration in 2 hours. Low protein binding (12%). Penetrates well into all body tissues including bile, CSF, saliva, and reproductive secretions. Metabolized in the liver (CYP3A4) by oxidation and hydroxylation. Elimination half-life ~12 to 14 hours. Excreted in urine (~60-65%) and feces (~12%).",
            renalAdj = "Mild to moderate: No adjustment required. Hemodialysis: 50% of clearance; administer an additional 50% supplemental dose immediately after hemodialysis.",
            hepaticAdj = "Use with caution in severe hepatic impairment; increase dosing interval or monitor closely due to reduced clearance.",
            pregnancy = "Category C (Contraindicated during the FIRST TRIMESTER of pregnancy due to mutagenic potential. May be used in 2nd and 3rd trimesters if clearly needed and metronidazole is contraindicated).",
            lactation = "Excreted in breast milk in concentrations similar to maternal serum. Interrupt breastfeeding during treatment and for at least 72 hours after the last dose; pump and discard milk during this period.",
            sideEffects = "Metallic taste, nausea, anorexia, dyspepsia, headache, dizziness, fatigue, dark-colored urine (harmless reddish-brown metabolite), rare peripheral neuropathy or seizures with prolonged use.",
            priceNpr = "NPR 30.00 - 70.00 per strip of 4 (500 mg) / NPR 15.00 per tab",
            priceInr = "INR 20.00 - 50.00 per strip of 4",
            brandsNepal = listOf(
                BrandInfo("Tiniba", "Zydus / Medisales Nepal", "Tab", "300 mg / 500 mg / 1000 mg"),
                BrandInfo("Tini", "Micro Labs Nepal", "Tab", "500 mg"),
                BrandInfo("Fasigyn", "Pfizer Nepal", "Tab", "500 mg / 1000 mg"),
                BrandInfo("Tinizol", "Lomus Pharmaceuticals", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Fasigyn", "Pfizer India", "Tab", "500 mg / 1 g"),
                BrandInfo("Tiniba", "Zydus Cadila", "Tab", "300 mg / 500 mg / 1 g"),
                BrandInfo("Tini", "Micro Labs", "Tab", "500 mg"),
                BrandInfo("Zil", "Sun Pharma", "Tab", "500 mg")
            ),
            pediatricDosePerKg = 50.0,
            pediatricInterval = "mg/kg PO single stat dose with food for giardiasis (max 2 g)",
            adultDose = "Giardia/Trichomonas: 2 g PO single dose with meal. Amoebiasis: 2 g PO OD for 3 days.",
            childDose = "Giardiasis: 50 mg/kg PO single dose with food (max 2 g). Amoeba: 50 mg/kg/d x 3 days.",
            contraindications = "First trimester of pregnancy, known hypersensitivity to tinidazole or other 5-nitroimidazoles, active organic neurological disorders.",
            modeOfAction = "Diffuses into anaerobic organisms where nitro group is reduced by ferredoxin/nitroreductase into cytotoxic free radicals that bind to bacterial/protozoal DNA, causing strand breakage and cell death.",
            precautions = "Strictly avoid all alcohol and alcohol-containing cough syrups during and for 3 full days after treatment. Treat sexual partner in trichomoniasis to prevent reinfection.",
            nemlCategory = "Nepal Essential Medicines List (Antiprotozoal Medicines)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो जुका, आउँ (अमिबा), जिआर्डिया तथा गुप्ताङ्गको चिलाउने संक्रमण (ट्राइकोमोनियासिस) मा प्रयोग गरिने मुख्य औषधि हो। यो औषधि खानासँग वा खाना खाएपछि तुरुन्त खानुपर्छ। औषधि सेवन गर्दा र औषधि सकिएको ३ दिनसम्म रक्सी वा बियर पटक्कै नपिउनुहोस् किनकि यसले कडा उल्टी, टाउको दुखाई र मुटु ढुकढुक गराउँछ। पिसाबको रङ्ग गाढा रातो-खैरो हुन सक्छ जुन सामान्य हो।",
            counselingEnglish = "Primary treatment for giardiasis, amoebic dysentery, and trichomoniasis. Take with or immediately after food. Strictly avoid all alcohol during treatment and for 72 hours after completion. Urine may turn harmless reddish-brown.",
            era = "Older / Classical (Developed 1969 by Pfizer)",
            therapeuticClassTag = "Antiprotozoal / Nitroimidazole / Tropical Infectious Disease"
        ),

        // ==========================================
        // 10. MEBENDAZOLE
        // ==========================================
        Drug(
            id = "d_vital_mebendazole",
            genericName = "Mebendazole",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Synthetic Broad-Spectrum Benzimidazole Anthelmintic",
            blackBoxWarning = null,
            indications = "Enterobius vermicularis (pinworm / threadworm); Ascaris lumbricoides (giant roundworm); Ancylostoma duodenale and Necator americanus (hookworm); Trichuris trichiura (whipworm); mixed intestinal helminthic infections; public health mass deworming campaigns in school-age children.",
            doses = "Pinworm / Threadworm (Enterobiasis):\n• Adults & Children >= 1-2 years: 100 mg PO as a SINGLE DOSE.\n• MANDATORY RETREATMENT: Repeat 100 mg dose in 2 weeks to eliminate newly hatched worms and prevent reinfection. Treat entire household concurrently.\nRoundworm (Ascariasis), Hookworm, Whipworm (Trichuriasis):\n• Adults & Children >= 1-2 years: 100 mg PO BID (morning and evening) for 3 consecutive days (total 600 mg), OR 500 mg PO as a single dose.\nMixed Helminthic Infestations:\n• 100 mg PO BID for 3 days.\nPediatric Mass Deworming (WHO Guidelines):\n• Children 12-23 months: 100 mg BID for 3 days or 500 mg single dose.\n• Children >= 2 years: 500 mg single chewable tablet.",
            administration = "Chew tablet thoroughly, crush, or swallow whole with water. May be mixed with food. No fasting, laxatives, or purgatives are required before or after administration.",
            timing = "With or without food for intestinal worms. For rare systemic tissue infections (echinococcosis), take with a fatty meal to maximize systemic absorption.",
            specialInstructions = "LOW SYSTEMIC ABSORPTION IS AN ASSET: Mebendazole has very low systemic bioavailability (<5-10%), which allows high, potent concentrations within the gastrointestinal lumen where adult worms reside, with minimal systemic toxicity. HYGIENE PROTOCOL: For pinworm, wash all bed linens, underwear, and sleepwear in hot water on day of treatment, keep fingernails cut short, and wash hands before meals. AVOID CONCOMITANT METRONIDAZOLE: Rare cases of Stevens-Johnson syndrome and toxic epidermal necrolysis (TEN) have been reported when mebendazole is combined with metronidazole.",
            pkPd = "Poor oral absorption (<10% absorbed due to extensive first-pass metabolism). Peak plasma concentration of absorbed portion in 2-4 hours. Protein binding 90-95%. Absorbed drug is extensively metabolized in the liver via decarboxylation and reduction. Elimination half-life ~3 to 6 hours. Excreted primarily in feces (95% unabsorbed parent drug); only 2-5% excreted in urine.",
            renalAdj = "No dosage adjustment necessary (eliminated primarily unabsorbed in feces).",
            hepaticAdj = "No adjustment for standard short-course (1-3 days) intestinal worm treatment. In severe hepatic cirrhosis with high-dose prolonged therapy, monitor liver enzymes.",
            pregnancy = "Category C (Contraindicated in the FIRST TRIMESTER of pregnancy due to embryotoxicity and teratogenicity in animal studies. In 2nd and 3rd trimesters, WHO allows deworming after first trimester if hookworm anemia is present).",
            lactation = "Excreted in minimal amounts in breast milk due to poor oral absorption; compatible with breastfeeding.",
            sideEffects = "Transient mild abdominal pain, diarrhea (as dying worms are expelled), flatulence, nausea, headache, dizziness, rare reversible elevated transaminases, very rare leukopenia with prolonged high-dose therapy.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 6 (100 mg) / NPR 12.00 per 500mg chewable tab",
            priceInr = "INR 10.00 - 25.00 per strip of 6 / INR 8.00 per 500mg tab",
            brandsNepal = listOf(
                BrandInfo("Wormin", "Cadila / Medisales Nepal", "Tab / Susp", "100 mg / 100mg/5mL"),
                BrandInfo("Vermox", "Janssen / Medisales Nepal", "Chew Tab", "100 mg / 500 mg"),
                BrandInfo("Mebex", "Cipla Nepal", "Tab / Susp", "100 mg / 100mg/5mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Vermox", "Janssen India", "Tab", "100 mg / 500 mg"),
                BrandInfo("Wormin", "Cadila Pharmaceuticals", "Tab", "100 mg"),
                BrandInfo("Mebex", "Cipla Ltd.", "Tab / Susp", "100 mg")
            ),
            pediatricDosePerKg = 0.0,
            pediatricInterval = "100 mg PO single dose for pinworm, or 100 mg PO BID x 3 days for roundworm",
            adultDose = "Pinworm: 100 mg PO stat, repeat in 2 weeks. Roundworm/Hookworm: 100 mg BID x 3 days.",
            childDose = "Age >= 1-2 yrs: 100 mg PO stat (pinworm), or 100 mg PO BID x 3 days (ascariasis).",
            contraindications = "Known hypersensitivity to mebendazole or benzimidazoles; first trimester of pregnancy; avoid combination with metronidazole (SJS/TEN risk).",
            modeOfAction = "Selectively and irreversibly binds to parasite beta-tubulin, inhibiting microtubule polymerization and spindle assembly, blocking glucose uptake and depleting parasite glycogen stores, leading to immobilization and death of the helminth.",
            precautions = "Repeat pinworm dose after 14 days to catch newly hatched worms. Treat all household members simultaneously to prevent reinfection.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Anthelmintic)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो पेटको जुका (चुर्ना, गोलो जुका, अंकुशे जुका) मार्ने प्रमुख औषधि हो। चुर्ना (सानो सेतो जुका) को लागि यो चक्की खाएको २ हप्ता पछि फेरि एकपटक खानुपर्छ ताकि नयाँ फुलबाट निस्केका जुका पनि नष्ट हुन्। परिवारका सबै सदस्यहरूले एकैपटक यो औषधि खानु राम्रो हुन्छ। चक्की चपाएर खान सकिन्छ। नङ सधैँ सफा र छोटो राख्नुहोस्।",
            counselingEnglish = "Broad-spectrum deworming tablet for pinworms, roundworms, and hookworms. For pinworms, mandatory repeat dose in 2 weeks to eliminate newly hatched eggs. Treat all household contacts. Tablets may be chewed or swallowed.",
            era = "Older / Classical (Developed 1971 by Janssen Pharmaceutica)",
            therapeuticClassTag = "Anthelmintic / Benzimidazole / Public Health Formulary"
        ),

        // ==========================================
        // 11. ARTESUNATE (Parenteral IV / IM)
        // ==========================================
        Drug(
            id = "d_vital_artesunate",
            genericName = "Artesunate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Parenteral Artemisinin Derivative (Rapid Blood Schizonticide)",
            blackBoxWarning = null,
            indications = "WHO and Nepal National Malaria Treatment Guideline #1 GOLD STANDARD first-line treatment for Severe Plasmodium falciparum malaria in all adults, children, and pregnant women in all trimesters (cerebral malaria, severe malarial anemia, blackwater fever/hemoglobinuria, acute kidney injury, metabolic acidosis, ARDS, hyperparasitemia >10%).",
            doses = "Severe Falciparum Malaria (WHO & Nepal National Protocol):\n• Adults & Children >= 20 kg: 2.4 mg/kg IV or IM given at 0 hours, 12 hours, and 24 hours, and then ONCE DAILY every 24 hours thereafter until patient is conscious and can tolerate oral medication.\n• Children < 20 kg: 3.0 mg/kg IV or IM at 0, 12, and 24 hours, then once daily (higher clearance in small children).\nMINIMUM PARENTERAL COURSE:\n• Must give at least 3 parenteral doses (24 hours minimum) even if the patient regains consciousness earlier.\nORAL STEP-DOWN COMPLETION (MANDATORY):\n• As soon as patient can swallow, complete a full 3-day oral course of Artemisinin-based Combination Therapy (ACT: Artemether-Lumefantrine / Coartem) to eradicate residual parasites and prevent recrudescence.",
            administration = "Slow intravenous bolus over 1 to 2 minutes, or deep intramuscular injection into the anterior thigh. RECONSTITUTION PROTOCOL: Dissolve 60 mg powder vial with supplied 1 mL 5% Sodium Bicarbonate ampoule to form sodium artesunate, then dilute with 5 mL Normal Saline or D5W for IV use (concentration 10 mg/mL). For IM use, dilute with 2 mL NS (concentration 20 mg/mL). Use immediately within 1 hour.",
            timing = "Strictly at 0 hours, 12 hours, 24 hours, and then every 24 hours until oral switch.",
            specialInstructions = "LIFE-SAVING SUPERIORITY OVER QUININE: IV Artesunate reduces mortality by 35% in adults (SEAQUAMAT trial) and 22.5% in African children (AQUAMAT trial) compared to IV quinine, with far fewer adverse events and no risk of hypoglycemia or cinchonism. POST-ARTESUNATE DELAYED HEMOLYSIS (PADH): Watch for delayed hemolytic anemia occurring 1 to 3 weeks after completion of therapy (especially in travelers or patients with high initial parasitemia); monitor hemoglobin and reticulocyte count weekly for 4 weeks post-treatment.",
            pkPd = "Rapidly hydrolyzed in plasma by blood esterases to active metabolite dihydroartemisinin (DHA). Peak DHA concentrations in 15 minutes IV, 30-60 min IM. Protein binding 75%. DHA elimination half-life ~40 to 60 minutes. Clearance is mediated by hepatic glucuronidation (UGT1A9, UGT2B7). Metabolites excreted in urine and bile.",
            renalAdj = "No dosage adjustment necessary in acute kidney injury or renal replacement therapy.",
            hepaticAdj = "No dosage adjustment necessary in hepatic impairment.",
            pregnancy = "WHO GUIDELINE MANDATE: IV Artesunate is the drug of choice for severe malaria in ALL TRIMESTERS OF PREGNANCY (1st, 2nd, and 3rd). Untreated severe malaria carries extreme maternal-fetal mortality, far outweighing theoretical risks.",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding. Severe malaria requires immediate maternal treatment.",
            sideEffects = "Post-artesunate delayed hemolysis (PADH), transient reticulocytopenia, leukopenia, nausea, vomiting, dizziness, elevated transaminases, rare urticaria or anaphylaxis.",
            priceNpr = "NPR 350.00 - 650.00 per 60mg / 120mg vial with solvent",
            priceInr = "INR 220.00 - 450.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Falcigo", "Zydus / Medisales Nepal", "Inj", "60 mg / 120 mg"),
                BrandInfo("Larinate", "Ipca Laboratories Nepal", "Inj", "60 mg / 120 mg"),
                BrandInfo("Artesun", "Guilin / WHO Prequalified", "Inj", "60 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Falcigo", "Zydus Cadila", "Inj", "60 mg / 120 mg"),
                BrandInfo("Larinate", "Ipca Laboratories", "Inj", "60 mg / 120 mg"),
                BrandInfo("Falcidol", "Mankind Pharma", "Inj", "60 mg / 120 mg")
            ),
            pediatricDosePerKg = 3.0,
            pediatricInterval = "mg/kg IV at 0, 12, 24h then daily for children <20 kg with severe malaria",
            adultDose = "2.4 mg/kg IV/IM at 0, 12, 24h, then once daily until oral switch (minimum 3 doses).",
            childDose = "Weight <20 kg: 3.0 mg/kg IV/IM at 0, 12, 24h, then OD. Weight >=20 kg: 2.4 mg/kg.",
            contraindications = "Known hypersensitivity to artesunate or artemisinin derivatives. (No absolute contraindications in life-threatening severe malaria).",
            modeOfAction = "Endoperoxide bridge is cleaved by intraparasitic heme iron, generating lethal reactive carbon-centered free radicals that alkylate parasite proteins and sarcoplasmic/endoplasmic reticulum calcium ATPase (SERCA / PfATP6), producing rapid parasite clearance within hours.",
            precautions = "Must administer at least 3 parenteral doses before switching to oral ACT. Monitor hemoglobin for 4 weeks post-treatment for delayed hemolysis.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Priority Parenteral Antimalarial)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो कडा तथा मस्तिष्कमा फैलिएको मलेरिया (औलो) को उपचारमा प्रयोग गरिने संसारकै सबैभन्दा प्रभावकारी जीवनरक्षक सुई हो। यसले रगतमा भएका मलेरियाका कीटाणुहरूलाई केही घण्टाभित्रै नष्ट गर्छ। बिरामी होसमा आएपछि पनि कम्तीमा ३ मात्रा सुई पुरा गर्नुपर्छ र त्यसपछि खाने चक्की (एसीटी) ३ दिनसम्म पुरा खानुपर्छ ताकि रोग दोहोरिन नपाओस्।",
            counselingEnglish = "Gold standard parenteral medication for life-threatening severe and cerebral Falciparum malaria. Eliminates blood parasites rapidly within hours. Patient must receive at least 3 doses (24 hours) then complete a full 3-day oral ACT course.",
            era = "Older / Classical (Discovered 1972 by Tu Youyou / Project 523, Nobel Prize 2015)",
            therapeuticClassTag = "Antimalarial / Artemisinin Derivative / Critical Care"
        ),

        // ==========================================
        // 12. PAROXETINE HYDROCHLORIDE
        // ==========================================
        Drug(
            id = "d_vital_paroxetine",
            genericName = "Paroxetine Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Selective Serotonin Reuptake Inhibitor (SSRI)",
            blackBoxWarning = "SUICIDAL THOUGHTS AND BEHAVIORS: Antidepressants increase the risk of suicidal thinking and behavior in children, adolescents, and young adults (up to age 24) in short-term studies of Major Depressive Disorder (MDD) and other psychiatric conditions. Closely monitor for clinical worsening, agitation, or emergent suicidality.",
            indications = "Major Depressive Disorder (MDD); Panic Disorder with or without agoraphobia; Social Anxiety Disorder (Social Phobia); Generalized Anxiety Disorder (GAD); Obsessive-Compulsive Disorder (OCD); Post-Traumatic Stress Disorder (PTSD); Premenstrual Dysphoric Disorder (PMDD); moderate-to-severe vasomotor symptoms (hot flashes) associated with menopause.",
            doses = "Major Depressive Disorder & GAD:\n• Initial: 20 mg PO once daily in the morning with food; may increase by 10 mg/day weekly if needed (usual maintenance 20 to 40 mg/day; max 50 mg/day; CR formulation 25 to 62.5 mg/day).\nPanic Disorder:\n• Initial: 10 mg PO once daily in morning (start low to prevent early jitteriness/panic escalation); titrate weekly to target 40 mg/day (max 60 mg/day).\nOCD & Social Anxiety:\n• Initial: 20 mg PO once daily; titrate weekly to target 40 mg/day (max 60 mg/day).\nPremenstrual Dysphoric Disorder (PMDD):\n• 12.5 to 25 mg PO once daily (continuous or luteal-phase dosing only).\nVasomotor Symptoms (Hot Flashes):\n• 7.5 mg PO once daily at bedtime (Brisdelle formulation).",
            administration = "Take orally once daily in the morning with food to minimize nausea. Swallow controlled-release tablets whole; do not chew or crush.",
            timing = "Morning with breakfast; morning dosing helps prevent insomnia.",
            specialInstructions = "HIGHEST DISCONTINUATION SYNDROME RISK: Paroxetine has a short elimination half-life (~21 hours) with no active metabolites and significant muscarinic anticholinergic affinity. Abrupt discontinuation causes severe 'FINISH' syndrome: Flu-like symptoms, Insomnia, Nausea, Imbalance/dizziness, Sensory disturbances ('brain zaps' / electric shocks), and Hyperarousal. TAPER EXTREMELY SLOWLY over weeks to months. Weight gain and sexual dysfunction (delayed ejaculation, anorgasmia) are more pronounced than with other SSRIs. Potent CYP2D6 inhibitor: blocks conversion of tamoxifen to active endoxifen (contraindicated in breast cancer patients on tamoxifen!).",
            pkPd = "Oral bioavailability is increased with chronic dosing due to saturable, non-linear first-pass hepatic metabolism. Peak plasma in 5-6 hours. Protein binding 95%. Non-linear pharmacokinetics (disproportionate increase in plasma levels with dose increases). Metabolized in liver primarily by CYP2D6 (which it strongly inhibits). Elimination half-life ~21 hours. Excreted in urine (~64%) and feces (~36%).",
            renalAdj = "Severe renal impairment (CrCl <30 mL/min): Start with 10 mg/day; maximum dose 40 mg/day.",
            hepaticAdj = "Severe hepatic impairment: Start with 10 mg/day; maximum dose 40 mg/day.",
            pregnancy = "Category D (Contraindicated in early pregnancy: FDA warning for increased risk of congenital cardiovascular malformations, especially ventricular and atrial septal defects).",
            lactation = "Excreted into breast milk in low concentrations; considered one of the safer SSRIs during breastfeeding due to lower infant serum levels compared to fluoxetine.",
            sideEffects = "Nausea, somnolence or insomnia, sexual dysfunction (anorgasmia, erectile dysfunction, delayed ejaculation), weight gain, dry mouth, asthenia, sweating, tremor, constipation, hyponatremia/SIADH in elderly, serotonin syndrome.",
            priceNpr = "NPR 90.00 - 180.00 per strip of 10 (12.5 mg / 25 mg CR)",
            priceInr = "INR 65.00 - 140.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Pexep", "Intas / Medisales Nepal", "Tab / CR Tab", "10 mg / 20 mg / 12.5 mg CR / 25 mg CR"),
                BrandInfo("Pari", "Ipca Laboratories Nepal", "CR Tab", "12.5 mg / 25 mg"),
                BrandInfo("Paxil", "GSK Nepal", "Tab", "20 mg"),
                BrandInfo("Parotin", "Sun Pharma Nepal", "Tab", "20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pexep", "Intas Pharmaceuticals", "Tab / CR Tab", "10 mg / 20 mg / 12.5 mg / 25 mg"),
                BrandInfo("Pari", "Ipca Laboratories", "CR Tab", "12.5 mg / 25 mg / 37.5 mg"),
                BrandInfo("Paxide", "Torrent Pharmaceuticals", "Tab", "20 mg"),
                BrandInfo("Panex", "Cipla Ltd.", "CR Tab", "12.5 mg / 25 mg")
            ),
            adultDose = "Depression/GAD: 20 mg PO OD morning (max 50 mg). Panic: 10 mg OD, target 40 mg.",
            childDose = "Not approved for pediatric depression due to lack of efficacy and suicide risk.",
            contraindications = "Concomitant use with MAO inhibitors, linezolid, methylene blue, or thioridazine; concomitant tamoxifen; known hypersensitivity to paroxetine.",
            modeOfAction = "Potent and highly selective inhibitor of presynaptic neuronal serotonin reuptake (SERT), enhancing serotonergic neurotransmission in the central nervous system.",
            precautions = "Do not stop abruptly to avoid brain zaps and severe discontinuation syndrome. Screen for bipolar disorder before initiation to avoid manic switch. Avoid in patients taking tamoxifen.",
            nemlCategory = "Nepal Essential Medicines List (Antidepressant Formulary)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            beersCriteriaRisk = "HIGH RISK: Avoid in older adults; possesses strong anticholinergic properties, sedating effects, and triggers orthostatic falls and SIADH.",
            counselingNepali = "यो कडा डिप्रेसन, डर-त्रास (प्यानिक), सामाजिक डर र छटपटीमा प्रयोग गरिने औषधि हो। यो औषधि हरेक बिहान खानासँग खानुपर्छ। औषधिको पुरा फाइदा देखिन २ देखि ४ हप्ता लाग्न सक्छ। डाक्टरको सल्लाह बिना यो औषधि अचानक खान कहिल्यै बन्द नगर्नुहोस् किनकि यसले टाउकोमा करेन्ट लागे जस्तो हुने, रिंगटा लाग्ने र कडा छटपटी हुने समस्या ल्याउँछ।",
            counselingEnglish = "Potent SSRI for depression, panic disorder, social phobia, and PTSD. Take once daily in the morning with breakfast. Full therapeutic benefit requires 2 to 4 weeks. NEVER stop this medication abruptly to prevent severe electric-shock sensation withdrawal.",
            era = "Older / Classical (Approved 1992 by SmithKline Beecham)",
            therapeuticClassTag = "Antidepressant / SSRI / Neuropsychiatry"
        ),

        // ==========================================
        // 13. HYDROCHLOROTHIAZIDE (HCTZ)
        // ==========================================
        Drug(
            id = "d_vital_hydrochlorothiazide",
            genericName = "Hydrochlorothiazide",
            system = "Cardiovascular System (CVS)",
            drugClass = "Thiazide Diuretic & First-Line Antihypertensive",
            blackBoxWarning = null,
            indications = "Essential hypertension (first-line agent in ACC/AHA, JNC8, and ESC guidelines, either as monotherapy or in fixed-dose combination with ARBs, ACE inhibitors, or CCBs); edema associated with congestive heart failure, hepatic cirrhosis, and nephrotic syndrome; recurrent calcium nephrolithiasis (reduces urinary calcium excretion); nephrogenic diabetes insipidus.",
            doses = "Essential Hypertension:\n• 12.5 to 25 mg PO once daily in the morning (max 50 mg/day, but doses >25 mg offer minimal additional BP reduction while significantly increasing hypokalemia and metabolic side effects).\nEdema (Heart Failure / Cirrhosis / Nephrotic Syndrome):\n• 25 to 50 mg PO once daily or divided BID (max 100 mg/day).\nCalcium Nephrolithiasis Prevention:\n• 25 to 50 mg PO once daily in morning.\nNephrogenic Diabetes Insipidus:\n• 25 to 50 mg PO once to twice daily.",
            administration = "Take orally once daily in the morning with or without food. Taking in the morning prevents nocturnal diuresis and sleep disruption.",
            timing = "Morning with breakfast.",
            specialInstructions = "METABOLIC PROFILE MONITORING:\n• 'Hypo' Triad: Hypokalemia, Hyponatremia, Hypomagnesemia.\n• 'Hyper' Triad: Hyperuricemia (can trigger acute gout flares!), Hyperglycemia (impairs glucose tolerance), Hypercalcemia (increases renal tubular calcium reabsorption).\nINEFFECTIVE AT LOW GFR: Loses diuretic efficacy when eGFR falls below 30 mL/min (switch to loop diuretic like Furosemide or Torsemide in severe CKD). Ubiquitous component of fixed-dose combination antihypertensive pills (e.g. Telmisartan + HCTZ, Losartan + HCTZ, Ramipril + HCTZ).",
            pkPd = "Oral bioavailability 65-75%. Peak plasma concentration in 1-2.5 hours. Protein binding 40-68%. Does not undergo significant hepatic metabolism. Excreted almost entirely unchanged in urine via glomerular filtration and active proximal tubular secretion. Elimination half-life ~6 to 15 hours. Antihypertensive effect persists for 16-24 hours.",
            renalAdj = "CrCl >= 30 mL/min: No adjustment required. CrCl < 30 mL/min: Ineffective; thiazides fail to achieve adequate tubular concentrations in severe CKD (use loop diuretics).",
            hepaticAdj = "Use with caution; electrolyte disturbances (especially hypokalemic alkalosis) can precipitate acute hepatic encephalopathy in cirrhotic patients.",
            pregnancy = "Category B (Avoid as first-line in pregnancy; can reduce maternal intravascular plasma volume and placental perfusion. Thiazides are not recommended for gestational hypertension or pre-eclampsia).",
            lactation = "Excreted in human breast milk; high doses can suppress maternal lactation. Compatible in low doses, but monitor infant.",
            sideEffects = "Hypokalemia, hyponatremia, hypomagnesemia, hyperuricemia (gout), hyperglycemia, dyslipidemia, orthostatic hypotension, dizziness, photosensitivity, erectile dysfunction, rare acute angle-closure glaucoma and choroidal effusion.",
            priceNpr = "NPR 15.00 - 35.00 per strip of 10 (12.5 mg / 25 mg)",
            priceInr = "INR 10.00 - 25.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Aquazide", "Sun Pharma Nepal", "Tab", "12.5 mg / 25 mg"),
                BrandInfo("Esidrix", "Novartis Nepal", "Tab", "25 mg"),
                BrandInfo("Hydrozide", "Torrent Nepal", "Tab", "12.5 mg / 25 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Aquazide", "Sun Pharma", "Tab", "12.5 mg / 25 mg"),
                BrandInfo("Esidrix", "Novartis India", "Tab", "25 mg"),
                BrandInfo("Hydrazide", "Cipla Ltd.", "Tab", "12.5 mg / 25 mg")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "mg/kg/day PO divided in 1-2 doses for pediatric edema (max 50 mg/d)",
            adultDose = "HTN: 12.5-25 mg PO once daily in morning (max 50 mg/d). Edema: 25-50 mg OD.",
            childDose = "1-2 mg/kg/day PO in 1-2 divided doses (max 37.5 mg/day in infants, 50-100 mg in older children).",
            contraindications = "Anuria, severe renal impairment (CrCl <30 mL/min), refractory hypokalemia or hyponatremia, hypercalcemia, symptomatic hyperuricemia/gout, hypersensitivity to sulfonamide-derived drugs.",
            modeOfAction = "Inhibits Na+/Cl- cotransporters in the luminal membrane of the early distal convoluted tubule, increasing urinary excretion of sodium, chloride, and water; long-term antihypertensive effect is mediated by peripheral arteriolar vasodilation.",
            precautions = "Monitor serum electrolytes (sodium, potassium) and uric acid periodically. Encourage potassium-rich diet or combine with potassium-sparing agents / ARBs.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Antihypertensive & Diuretic)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो उच्च रक्तचाप नियन्त्रण गर्न तथा शरीर सुन्निएको (पानी जमेको) कम गर्न प्रयोग गरिने पिसाब खुलाउने औषधि हो। यो औषधि हरेक बिहान नास्तासँग खानुपर्छ ताकि राति पिसाब फेर्न बारम्बार उठ्नु नपरोस्। औषधिले शरीरमा पोटासियम र नुनको मात्रा कम गर्न सक्ने हुनाले रगतको जाँच नियमित गर्नुहोस्। युरिक एसिड बढेर जोर्नी दुख्ने समस्या भएमा डाक्टरलाई जानकारी दिनुहोस्।",
            counselingEnglish = "First-line diuretic for high blood pressure and edema. Take once daily in the morning with breakfast to avoid nighttime urination. Periodically check serum potassium and electrolytes. Report joint pain or gout flares to your physician.",
            era = "Older / Classical (Approved 1959 by Merck)",
            therapeuticClassTag = "Thiazide Diuretic / Antihypertensive / Cardiovascular"
        ),

        // ==========================================
        // 14. FAMOTIDINE
        // ==========================================
        Drug(
            id = "d_vital_famotidine",
            genericName = "Famotidine",
            system = "Gastrointestinal & Hepatobiliary",
            drugClass = "Histamine H2-Receptor Antagonist (H2RA)",
            blackBoxWarning = null,
            indications = "Short-term treatment and maintenance of active duodenal ulcer and benign gastric ulcer; Gastroesophageal Reflux Disease (GERD) and erosive esophagitis; ICU stress ulcer prophylaxis; Zollinger-Ellison syndrome; emergency secondary adjunct in acute anaphylaxis and severe acute urticaria (combined H1 + H2 receptor blockade with epinephrine and antihistamines); preferred H2RA following global withdrawal of ranitidine.",
            doses = "Active Duodenal / Gastric Ulcer:\n• 40 mg PO once daily at bedtime (or 20 mg PO BID) for 4 to 8 weeks.\nMaintenance of Healed Ulcer:\n• 20 mg PO once daily at bedtime.\nGERD / Reflux Symptoms:\n• 20 to 40 mg PO BID for 6 to 12 weeks.\nHospital IV Administration / ICU Stress Ulcer Prophylaxis:\n• 20 mg slow IV push (diluted in NS over >= 2 minutes) or intermittent IV infusion q12h.\nAcute Anaphylaxis / Severe Urticaria Adjunct:\n• 20 mg slow IV over 2-5 minutes in combination with IM Epinephrine and IV Promethazine/Diphenhydramine.\nPediatric Ulcer / GERD:\n• 0.5 mg/kg/dose PO or IV BID (max 40 mg/day).",
            administration = "Take orally with or without food, ideally at bedtime for ulcer healing or 15-60 minutes before meals for reflux prophylaxis. IV formulation should be injected slowly over at least 2 minutes to avoid bradycardia.",
            timing = "Bedtime for nocturnal acid suppression, or BID before morning and evening meals.",
            specialInstructions = "CLEAN SAFETY PROFILE WITHOUT DRUG INTERACTIONS: Unlike cimetidine, famotidine has NO inhibitory effect on hepatic CYP450 enzymes and does not cause gynecomastia or anti-androgenic effects. Unlike ranitidine, famotidine has NO chemical risk of NDMA nitrosamine degradation. RENAL ENCEPHALOPATHY RISK: In elderly patients with impaired renal function, famotidine accumulates and crosses the blood-brain barrier, causing acute delirium, hallucinations, and confusion; reduce dose by 50% in renal impairment.",
            pkPd = "Oral bioavailability 40-45%. Peak plasma concentration in 1-3 hours. Protein binding 15-20%. Hepatic metabolism (25-30%) via S-oxidation; eliminated predominantly (65-70%) unchanged in urine via filtration and tubular secretion. Elimination half-life ~2.5 to 3.5 hours, prolonged up to 12-20 hours in severe renal failure. Duration of acid suppression: 10-12 hours.",
            renalAdj = "CrCl 30-50 mL/min: Reduce dose to 20 mg once daily at bedtime or extend interval to q36-48h. CrCl <30 mL/min: 20 mg once daily every other day (q48h) or 10 mg once daily to prevent central anticholinergic-like delirium.",
            hepaticAdj = "No dosage adjustment necessary.",
            pregnancy = "Category B (Safe; extensively used in pregnancy for heartburn and GERD when dietary modification and antacids fail).",
            lactation = "Excreted in human breast milk in low concentrations; compatible with breastfeeding.",
            sideEffects = "Headache, dizziness, constipation, diarrhea, fatigue, dry mouth, rare delirium and confusion in elderly patients with renal failure, transient bradycardia with rapid IV bolus.",
            priceNpr = "NPR 18.00 - 45.00 per strip of 10 (20 mg / 40 mg) / NPR 25.00 per 20mg/2mL vial",
            priceInr = "INR 12.00 - 32.00 per strip of 10 / INR 18.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Famocid", "Sun Pharma Nepal", "Tab / Inj", "20 mg / 40 mg / 20mg/2mL"),
                BrandInfo("Facid", "Quest Pharmaceuticals", "Tab", "20 mg / 40 mg"),
                BrandInfo("Famtac", "Torrent / Medisales Nepal", "Tab", "20 mg / 40 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Famocid", "Sun Pharma", "Tab / Inj", "20 mg / 40 mg / 20mg/2mL"),
                BrandInfo("Pepcid", "Johnson & Johnson India", "Tab", "20 mg / 40 mg"),
                BrandInfo("Topcid", "Torrent Pharmaceuticals", "Tab", "20 mg / 40 mg"),
                BrandInfo("Facid", "Intas Pharmaceuticals", "Tab", "20 mg / 40 mg")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "mg/kg/dose PO or IV BID for pediatric GERD and peptic ulcer",
            adultDose = "Ulcer: 40 mg PO at bedtime. GERD: 20-40 mg PO BID. IV hospital: 20 mg IV q12h.",
            childDose = "0.5 mg/kg/dose PO/IV BID (max 40 mg/day).",
            contraindications = "Known hypersensitivity to famotidine or other H2-receptor antagonists.",
            modeOfAction = "Competitive, reversible antagonist of histamine at H2-receptors on gastric parietal cells, potently suppressing basal, nocturnal, and food-stimulated gastric acid and pepsin secretion.",
            precautions = "Adjust dose in renal impairment to avoid confusion and delirium. Response does not preclude presence of gastric malignancy.",
            nemlCategory = "Nepal Essential Medicines List (Anti-Ulcerative Medicines)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो ग्यास्ट्रिक, पेट तथा आन्द्राको अल्सर र छाती पोल्ने समस्यामा पेटको अम्ल (एसिड) कम गर्ने औषधि हो। रानिटिडिन औषधि बन्द भएपछिको यो सुरक्षित विकल्प हो। अल्सरको उपचारको लागि यो औषधि राति सुत्ने बेलामा खानु सबैभन्दा राम्रो हुन्छ। बुढापाका तथा मिर्गौलाका बिरामीमा यो औषधिको मात्रा मिलाएर मात्र दिनुपर्छ।",
            counselingEnglish = "H2-receptor blocker for peptic ulcers, GERD, and hospital acid suppression. Take at bedtime for optimal nocturnal acid control. Reduce dose in elderly patients with kidney disease to avoid confusion.",
            era = "Older / Classical (Approved 1986 by Yamanouchi/Merck)",
            therapeuticClassTag = "H2-Receptor Blocker / Anti-Ulcer / Gastroenterology"
        ),

        // ==========================================
        // 15. MEDROXYPROGESTERONE ACETATE (MPA / Depo-Provera)
        // ==========================================
        Drug(
            id = "d_vital_medroxyprogesterone",
            genericName = "Medroxyprogesterone Acetate",
            system = "Endocrine & Metabolic System",
            drugClass = "Synthetic Progestin (17-alpha-hydroxyprogesterone derivative)",
            blackBoxWarning = "LOSS OF BONE MINERAL DENSITY (BMD): Prolonged use of depot medroxyprogesterone acetate (Depo-Provera) causes significant reduction in bone mineral density. Bone loss is greatest during the first two years and may not be completely reversible. Depo-Provera should not be used as a long-term contraceptive (>2 years) unless other birth control methods are considered inadequate.",
            indications = "Long-acting injectable contraception (Depo-Provera / Sangini in Nepal Family Planning); abnormal uterine bleeding (AUB / dysfunctional uterine bleeding); secondary amenorrhea; prevention of endometrial hyperplasia in postmenopausal women receiving estrogen therapy; endometriosis pain management; palliative treatment of advanced endometrial and renal carcinoma.",
            doses = "Injectable Contraception (Depo-Provera / Sangini):\n• 150 mg deep IM injection into gluteus maximus or deltoid muscle ONCE EVERY 3 MONTHS (every 12 to 13 weeks).\n• Initial injection MUST be given during the first 5 days of normal menses (ensures non-pregnant status); if given >7 days postpartum (non-breastfeeding) or >6 weeks postpartum (breastfeeding).\nAbnormal Uterine Bleeding (AUB) & Secondary Amenorrhea (Oral):\n• 5 to 10 mg PO once daily for 5 to 10 days starting on day 16 or 21 of anticipated cycle. Withdrawal bleeding typically occurs within 3 to 7 days after stopping.\nEndometrial Hyperplasia Prevention:\n• 5 to 10 mg PO once daily for 12 to 14 consecutive days per month in sequential hormone replacement therapy.\nEndometriosis:\n• 10 mg PO TID for 90 consecutive days (or Depo-Provera 150 mg IM q3m).",
            administration = "Intramuscular: Shake vial vigorously immediately before use to ensure complete suspension; inject deeply into gluteal or deltoid muscle; DO NOT MASSAGE injection site to avoid shortening duration of action. Oral: Take with or without food.",
            timing = "IM injection strictly every 12 to 13 weeks. Oral taken at the same time each day.",
            specialInstructions = "NEPAL FAMILY PLANNING CORNERSTONE: Sangini (150 mg MPA IM) is one of the most widely used methods of family planning in Nepal. COUNSELING MANDATE: Educate patients regarding predictable bleeding pattern changes: irregular spotting and prolonged bleeding during first 3-6 months, transitioning to AMENORRHEA in 50-70% of women by 12 months (reassure that absence of menses is normal and expected). DELAYED RETURN OF FERTILITY: Reversible contraception, but ovulation may take an average of 9 to 10 months (up to 18 months) to return after the last injection.",
            pkPd = "Oral bioavailability is enhanced by food. IM depot injection provides slow, prolonged release over 3 months; peak plasma levels in 1-3 weeks. Protein binding 86-90%. Metabolized extensively in the liver primarily via CYP3A4 hydroxylation and conjugation. Elimination half-life of oral is 12-17 hours; depot IM elimination half-life is ~50 days. Excreted mainly in feces via biliary system and in urine as metabolites.",
            renalAdj = "No dosage adjustment necessary.",
            hepaticAdj = "Contraindicated in severe hepatic impairment or acute active liver disease.",
            pregnancy = "Category X (Contraindicated in pregnancy; rule out pregnancy prior to initiating injectable contraception).",
            lactation = "WHO Medical Eligibility Criteria (MEC) Category 1 (>6 weeks postpartum): Does not impair milk volume or quality; standard postpartum contraceptive. If non-breastfeeding, can start immediately postpartum.",
            sideEffects = "Menstrual irregularities (spotting, breakthrough bleeding, amenorrhea), weight gain (average 2-4 kg over 1-2 years), decreased bone mineral density, mood changes, depression, headache, breast tenderness, abdominal bloating, delayed return of fertility.",
            priceNpr = "NPR 80.00 - 150.00 per 150mg/mL vial (Sangini / Depo) / NPR 45.00 per strip of 10 (10mg tab)",
            priceInr = "INR 50.00 - 110.00 per vial / INR 32.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Sangini", "Nepal CRS Society (Government FP Program)", "Inj", "150 mg/mL"),
                BrandInfo("Depo-Provera", "Pfizer / Medisales Nepal", "Inj", "150 mg/mL"),
                BrandInfo("Deviry", "Torrent / Medisales Nepal", "Tab", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Meprate", "Serum Institute Nepal", "Tab", "10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Depo-Provera", "Pfizer India", "Inj", "150 mg/mL"),
                BrandInfo("Deviry", "Torrent Pharmaceuticals", "Tab", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Meprate", "Serum Institute of India", "Tab", "10 mg"),
                BrandInfo("Modus", "Cadila Pharmaceuticals", "Tab", "5 mg / 10 mg")
            ),
            adultDose = "Contraception: 150 mg deep IM q3 months. AUB/Amenorrhea: 5-10 mg PO OD for 5-10 days.",
            childDose = "Not indicated before menarche.",
            contraindications = "Known or suspected pregnancy, undiagnosed abnormal vaginal bleeding, known or suspected breast malignancy or estrogen/progestin-dependent neoplasia, active deep vein thrombosis (DVT) or pulmonary embolism, severe active liver disease.",
            modeOfAction = "Inhibits secretion of pituitary gonadotropins (LH and FSH), preventing follicular maturation and ovulation; thickens cervical mucus to prevent sperm penetration; renders endometrium atrophic and unreceptive to implantation.",
            precautions = "Advise adequate calcium (1000-1200 mg/d) and Vitamin D supplementation to protect bone mineral density. Counsel regarding expected spotting and eventual amenorrhea.",
            nemlCategory = "Nepal Essential Medicines List (Priority Family Planning & Reproductive Health)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो ३ महिनाको लागि गर्भ रोक्न दिइने सुई (संगिनी सुई) तथा महिनावारी गडबडी नियन्त्रण गर्ने औषधि हो। सुई लगाएपछि सुरुका केही महिना रगत अलिअलि देखिने वा थोपा-थोपा आउने हुन सक्छ र १ वर्षपछि महिनावारी सुक्न (बन्द हुन) सक्छ, यो सामान्य हो र डराउनु पर्दैन। सुई लगाउन छाडेपछि फेरि बच्चा बस्न ९ देखि १२ महिना लाग्न सक्छ। हड्डी कमजोर हुन नदिन क्याल्सियमयुक्त खानेकुरा खानुहोस्।",
            counselingEnglish = "Cornerstone 3-month injectable contraceptive (Sangini) and cycle regulator. Irregular spotting is normal initially, followed by amenorrhea in most women. Fertility may take 9 to 12 months to return after stopping. Ensure adequate dietary calcium.",
            era = "Older / Classical (Depo-Provera approved 1992 by Upjohn)",
            therapeuticClassTag = "Progestin / Contraceptive / Reproductive Endocrinology"
        ),

        // ==========================================
        // 16. NORFLOXACIN
        // ==========================================
        Drug(
            id = "d_vital_norfloxacin",
            genericName = "Norfloxacin",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Broad-Spectrum Fluoroquinolone (Urological & Gut Antiseptic)",
            blackBoxWarning = "TENDINITIS, TENDON RUPTURE, PERIPHERAL NEUROPATHY & CNS EFFECTS: Fluoroquinolones are associated with disabling and potentially irreversible serious adverse reactions including tendinitis and Achilles tendon rupture, peripheral neuropathy, and CNS toxicities. Discontinue immediately at first sign of tendon pain.",
            indications = "Acute uncomplicated urinary tract infections (cystitis); complicated UTIs; acute bacterial gastroenteritis and traveler's diarrhea; Primary and secondary prophylaxis of Spontaneous Bacterial Peritonitis (SBP) in cirrhotic patients with ascites and low total protein (<1.5 g/dL); acute gonococcal urethritis.",
            doses = "Uncomplicated UTI (Acute Cystitis):\n• 400 mg PO BID for 3 days.\nComplicated UTI / Catheter-Associated UTI:\n• 400 mg PO BID for 10 to 21 days.\nAcute Infectious Diarrhea / Gastroenteritis:\n• 400 mg PO BID for 3 to 5 days.\nSpontaneous Bacterial Peritonitis (SBP) Prophylaxis in Cirrhosis:\n• 400 mg PO once daily indefinitely (or during acute upper GI bleeding episodes, 400 mg PO BID for 7 days to prevent SBP and bacteremia).",
            administration = "Take orally on an empty stomach with a full glass of water, at least 1 hour before or 2 hours after meals. Do not take with dairy products (milk, yogurt) or multivalent cations.",
            timing = "Morning and evening on empty stomach.",
            specialInstructions = "HIGH URINARY AND INTESTINAL CONCENTRATIONS: Norfloxacin achieves exceptionally high concentrations in the intestinal lumen and urinary tract, but relatively low systemic serum and tissue concentrations compared to ciprofloxacin or levofloxacin; this makes it ideal for local gut and urinary infections with lower risk of broader systemic resistance. CHELATION INTERACTION: Polyvalent cations (antacids containing aluminum/magnesium, iron supplements, calcium, zinc) bind norfloxacin in the GI tract, reducing absorption by up to 90%; space by at least 2 hours before or 4 hours after cations.",
            pkPd = "Oral absorption ~30-40%. Peak plasma concentration in 1-2 hours. Protein binding 14%. Low volume of distribution compared to other fluoroquinolones. Hepatic metabolism ~30%. Excreted rapidly in urine (30% unchanged) via glomerular filtration and tubular secretion, and in feces (30% unabsorbed). Elimination half-life ~3 to 4.5 hours.",
            renalAdj = "CrCl <= 30 mL/min: Reduce dose to 400 mg PO once daily (OD). Hemodialysis: 400 mg PO once daily.",
            hepaticAdj = "No dosage adjustment necessary.",
            pregnancy = "Category C (Avoid during pregnancy; fluoroquinolones cause arthropathy and cartilage damage in weight-bearing joints of juvenile animals).",
            lactation = "Excreted in human milk; alternative safe antibiotics (e.g. nitrofurantoin, cephalosporins) are preferred during breastfeeding.",
            sideEffects = "Nausea, dyspepsia, headache, dizziness, abdominal cramps, diarrhea, tendinitis and Achilles tendon rupture, photosensitivity, QT interval prolongation, peripheral neuropathy, Clostridioides difficile colitis.",
            priceNpr = "NPR 35.00 - 85.00 per strip of 10 (400 mg)",
            priceInr = "INR 25.00 - 60.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Norflox", "Cipla Nepal", "Tab", "400 mg"),
                BrandInfo("Uriflox", "Quest Pharmaceuticals", "Tab", "400 mg"),
                BrandInfo("Norbactin", "Sun Pharma Nepal", "Tab", "400 mg"),
                BrandInfo("Floxip", "Lomus Pharmaceuticals", "Tab", "400 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Norflox", "Cipla Ltd.", "Tab", "400 mg"),
                BrandInfo("Norbactin", "Sun Pharma", "Tab", "400 mg"),
                BrandInfo("Bacigyl", "Zydus Cadila", "Tab", "400 mg"),
                BrandInfo("Uriflox", "Torrent Pharmaceuticals", "Tab", "400 mg")
            ),
            adultDose = "UTI: 400 mg PO BID x 3-7 days. Diarrhea: 400 mg PO BID x 3 days. SBP prophylaxis: 400 mg PO OD.",
            childDose = "Not recommended in children <18 years due to risk of cartilage toxicity.",
            contraindications = "Known hypersensitivity to norfloxacin or other fluoroquinolones; history of fluoroquinolone-associated tendon rupture or tendinitis; myasthenia gravis (causes life-threatening exacerbation of muscle weakness).",
            modeOfAction = "Bactericidal; inhibits bacterial DNA gyrase (topoisomerase II) and topoisomerase IV, preventing DNA replication, transcription, repair, and recombination.",
            precautions = "Discontinue immediately if patient develops tendon pain or swelling. Avoid direct sunlight due to phototoxicity. Ensure adequate hydration to prevent crystalluria.",
            nemlCategory = "Nepal Essential Medicines List (Urinary Anti-Infective)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो पिसाब नलीको इन्फेक्सन (पिसाब पोल्ने) तथा झाडापखालामा प्रयोग गरिने एन्टिबायोटिक चक्की हो। यो औषधि खाली पेटमा (खाना खानुभन्दा १ घण्टा अगाडि वा २ घण्टा पछाडि) धेरै पानीसँग खानुपर्छ। औषधि खाँदा दूध, दही, क्याल्सियम वा आइरनको चक्कीसँगै नलिनुहोस्। कुर्कुच्चाको नशा (टेन्डन) दुखेमा तुरुन्त डाक्टरलाई देखाउनुहोस्।",
            counselingEnglish = "Fluoroquinolone for urinary tract infections, infectious diarrhea, and cirrhosis SBP prophylaxis. Take on an empty stomach with a full glass of water. Do not take with milk, antacids, or iron tablets. Stop immediately if heel/tendon pain occurs.",
            era = "Older / Classical (Patented 1977 by Kyorin)",
            therapeuticClassTag = "Fluoroquinolone / Urinary Tract Infection / Gastroenterology"
        ),

        // ==========================================
        // 17. ACTIVATED CHARCOAL (Medicinal Charcoal)
        // ==========================================
        Drug(
            id = "d_vital_activated_charcoal",
            genericName = "Activated Charcoal",
            system = "Emergency & Critical Care",
            drugClass = "Emergency Gastrointestinal Adsorbent Antidote",
            blackBoxWarning = null,
            indications = "Emergency gastrointestinal decontamination in acute toxic ingestions and poisonings presenting within 1 to 2 hours of ingestion (e.g. paracetamol, carbamazepine, dapsone, phenobarbital, quinine, theophylline, salicylates/aspirin, cyclic antidepressants); multiple-dose activated charcoal (MDAC) for life-threatening ingestions undergoing enterohepatic or enterogastric recirculation.",
            doses = "Single-Dose Activated Charcoal (SDAC):\n• Adults & Adolescents: 50 to 100 g (or 1 g/kg) PO or via nasogastric/orogastric tube as a slurry in water.\n• Children (1 to 12 years): 25 to 50 g (or 1 g/kg) PO or via NG tube.\n• Infants (<1 year): 10 to 25 g (or 0.5 to 1 g/kg).\nMultiple-Dose Activated Charcoal (MDAC) / 'Gastrointestinal Dialysis':\n• Initial Dose: 50 to 100 g (1 g/kg) PO or via NG tube.\n• Maintenance: 25 to 50 g (0.5 g/kg) q2-4h for 4 to 6 doses (indicated for severe poisoning with Carbamazepine, Dapsone, Phenobarbital, Quinine, and Theophylline).",
            administration = "Oral slurry mixed with drinking water (1 part charcoal to 4-8 parts water) or instilled via nasogastric / orogastric tube. Airway protection is mandatory prior to administration if mental status is depressed.",
            timing = "Immediate emergency administration, ideally within 60 minutes of toxic ingestion.",
            specialInstructions = "CRITICAL CONTRAINDICATION & ASPIRATION HAZARD:\n• AIRWAY INTEGRITY: NEVER administer to a patient with depressed consciousness or absent gag reflex unless the airway is secured with a cuffed endotracheal tube (massive pulmonary aspiration can cause fatal chemical pneumonitis and asphyxiation).\n• 'PHAILS' MNEMONIC (NOT ADSORBED BY CHARCOAL):\n1. P: Pesticides (organophosphates - charcoal efficacy is minimal; focus on Atropine/2-PAM)\n2. H: Hydrocarbons (kerosene, petrol - extreme aspiration chemical pneumonitis risk; ABSOLUTELY CONTRAINDICATED)\n3. A: Alcohols (ethanol, methanol, ethylene glycol - not adsorbed; use Fomepizole / Ethanol)\n4. I: Iron and heavy metals (lead, mercury, arsenic - not adsorbed)\n5. L: Lithium (not adsorbed; use hemodialysis)\n6. S: Strong acids and caustics/alkalis (bleach, drain cleaner - causes severe esophageal burns and perforation risk; ABSOLUTELY CONTRAINDICATED).",
            pkPd = "Not absorbed from the gastrointestinal tract (0% bioavailability). Remains entirely within the gut lumen. Surface area is enormous (1,000 to 2,000 square meters per gram) due to specialized activation processing with steam and oxygen. Binds poison molecules by weak van der Waals forces and hydrophobic interactions, preventing systemic absorption. Excreted entirely in feces, imparting a black coloration.",
            renalAdj = "No dosage adjustment necessary (non-absorbable).",
            hepaticAdj = "No dosage adjustment necessary (non-absorbable).",
            pregnancy = "Category A (Safe; non-absorbable inert substance that does not cross the placenta or enter fetal circulation).",
            lactation = "Not absorbed systemically; entirely safe and compatible with breastfeeding.",
            sideEffects = "Black stools (harmless), vomiting, constipation, abdominal fullness, intestinal obstruction / bezoar formation (with multiple doses), fatal pulmonary aspiration pneumonitis if inhaled into lungs.",
            priceNpr = "NPR 85.00 - 200.00 per bottle / sachet (50 g)",
            priceInr = "INR 60.00 - 150.00 per bottle / sachet",
            brandsNepal = listOf(
                BrandInfo("Actidose", "Emergency Hospital Supply", "Powder / Slurry", "25 g / 50 g"),
                BrandInfo("Charcocaps", "Medisales Nepal", "Sachet / Cap", "50 g"),
                BrandInfo("Carbomix", "Emergency Toxicology Import", "Susp", "50 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Actidose", "Healthline India", "Powder", "50 g"),
                BrandInfo("Charcocaps", "Medisales India", "Powder", "50 g"),
                BrandInfo("Medicoal", "Universal Medicaments", "Powder", "50 g"),
                BrandInfo("P-Coal", "Pharma Fabrikon", "Powder", "50 g")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "g/kg PO or via NG tube as a single dose for acute toxic ingestion",
            adultDose = "50-100 g PO/NG stat slurry within 1-2h of ingestion. MDAC: 25-50 g q2-4h.",
            childDose = "1 g/kg PO/NG stat (max 50 g). MDAC: 0.5 g/kg q2-4h.",
            contraindications = "Unprotected airway with depressed level of consciousness; ingestion of caustics/corrosives (strong acids, alkalis); ingestion of hydrocarbons (kerosene, petroleum products); intestinal obstruction, ileus, or perforation.",
            modeOfAction = "Physical adsorption of ingested toxins onto the vast porous carbon surface area within the stomach and small intestine, preventing systemic absorption and facilitating fecal elimination.",
            precautions = "Protect airway before administration. Ineffective for alcohols, lithium, iron, and caustics. Reassure patient that black stool is completely normal.",
            nemlCategory = "Nepal Essential Medicines List (WHO Essential Antidote & Poisoning Formulary)",
            ddaSchedule = "Emergency Over-The-Counter / Hospital Formulary",
            counselingNepali = "यो कुनै विष, विषाक्त औषधि वा रासायनिक पदार्थ खाएको १ देखि २ घण्टाभित्र पेटबाट रगतमा सोसिन नदिन खुवाइने आपतकालीन जीवनरक्षक कोइला (चारकोल) हो। यसले विषलाई आफ्ना कणहरूमा टाँसेर दिसाबाट बाहिर निकाल्छ। बिरामी बेहोस छ भने यो खुवाउनु हुँदैन। यो खाएपछि दिसा कालो आउँछ जुन सामान्य हो। मट्टीतेल वा एसिड खाएको अवस्थामा यो कहिल्यै दिनु हुँदैन।",
            counselingEnglish = "First-line gastrointestinal decontamination antidote for acute toxic ingestions within 1-2 hours. Binds toxins in the gut to prevent absorption. Never administer in patients with depressed consciousness unless intubated. Ineffective for kerosene, acids, lithium, and alcohol.",
            era = "Older / Classical (Used in clinical medicine since 1830s)",
            therapeuticClassTag = "Toxicology / Antidote / Emergency Resuscitation"
        ),

        // ==========================================
        // 18. DIPHENHYDRAMINE HYDROCHLORIDE
        // ==========================================
        Drug(
            id = "d_vital_diphenhydramine",
            genericName = "Diphenhydramine Hydrochloride",
            system = "Emergency & Critical Care",
            drugClass = "First-Generation Ethanolamine H1-Antihistamine & Anticholinergic",
            blackBoxWarning = null,
            indications = "Emergency management of acute drug-induced extrapyramidal reactions (acute dystonia, torticollis, oculogyric crisis from metoclopramide or antipsychotics); secondary adjunct in severe acute anaphylaxis and angioedema (after Epinephrine); acute urticaria, pruritus, and allergic reactions; motion sickness; short-term management of insomnia.",
            doses = "Acute Drug-Induced Dystonia / Extrapyramidal Crisis:\n• Adults: 25 to 50 mg IV (slow push over 2-3 min) or deep IM; symptoms typically resolve within 15-30 minutes; may repeat in 2-4 hours PRN (max 400 mg/24h).\n• Pediatrics: 1 to 1.25 mg/kg IV or IM (max 25 to 50 mg/dose).\nAnaphylaxis Secondary Adjunct (After IM Epinephrine):\n• Adults: 25 to 50 mg slow IV or IM.\n• Pediatrics: 1 mg/kg IV or IM (max 50 mg).\nAllergic Symptoms / Urticaria (Oral):\n• Adults: 25 to 50 mg PO q6-8h PRN (max 300 mg/day).\n• Pediatrics (6-12 years): 12.5 to 25 mg PO q6-8h (max 150 mg/day).\nInsomnia (Short-term):\n• 25 to 50 mg PO at bedtime.",
            administration = "Oral: Take with water or milk. Intramuscular: Deep IM into large muscle mass. Intravenous: Inject slowly at rate not exceeding 25 mg/min to avoid acute hypotension.",
            timing = "As needed or at bedtime for sedation.",
            specialInstructions = "FIRST-LINE ANTIDOTE FOR METOCLOPRAMIDE DYSTONIA: Rapid, definitive reversal agent for frightening drug-induced dystonias (jaw clenching, tongue protrusion, painful neck torticollis). PROFOUND CNS SEDATION & ANTICHOLINERGIC EFFECTS: Highly lipophilic, readily crosses blood-brain barrier. BEERS CRITERIA HIGH RISK in elderly: Causes severe anticholinergic delirium, confusion, urinary retention, blurred vision, and fall injuries.",
            pkPd = "Oral bioavailability 40-60% due to first-pass metabolism. Peak plasma in 2-3 hours. High volume of distribution. Crosses blood-brain barrier efficiently. Extensively metabolized in liver (CYP2D6, CYP1A2). Elimination half-life ~4 to 9 hours (prolonged up to 13 hours in elderly). Excreted in urine as metabolites.",
            renalAdj = "CrCl 10-50 mL/min: Increase interval to q6-12h. CrCl <10 mL/min: Increase interval to q12-18h.",
            hepaticAdj = "Use with caution; prolonged half-life in cirrhosis.",
            pregnancy = "Category B (Safe; widely used for allergic symptoms and hyperemesis gravidarum in pregnancy).",
            lactation = "Excreted in human milk; causes infant drowsiness and irritability; can decrease maternal lactation. Avoid prolonged use while nursing.",
            sideEffects = "Severe drowsiness, impaired coordination, dry mouth, blurred vision, urinary retention, constipation, tachycardia, paradoxical excitation in young children, orthostatic hypotension.",
            priceNpr = "NPR 35.00 - 75.00 per 100mL cough syrup / NPR 25.00 per 50mg/mL ampoule",
            priceInr = "INR 25.00 - 55.00 per syrup / INR 18.00 per ampoule",
            brandsNepal = listOf(
                BrandInfo("Benadryl", "Johnson & Johnson / Kenvue Nepal", "Syr", "12.5 mg/5mL"),
                BrandInfo("Diphen", "Medisales Nepal", "Inj", "50 mg/mL"),
                BrandInfo("Diprox", "Lomus Pharmaceuticals", "Syr", "14 mg/5mL")
            ),
            brandsIndia = listOf(
                BrandInfo("Benadryl", "Kenvue / J&J India", "Syr", "12.5 mg/5mL"),
                BrandInfo("Difenhidram", "Cadila Pharmaceuticals", "Inj", "50 mg/mL"),
                BrandInfo("D-Amine", "Cipla Ltd.", "Inj", "50 mg/mL")
            ),
            pediatricDosePerKg = 1.0,
            pediatricInterval = "mg/kg IV/IM for acute dystonic crisis or allergic emergency (max 50 mg)",
            adultDose = "Acute dystonia: 25-50 mg IV/IM stat. Allergy: 25-50 mg PO q6-8h. Sleep: 50 mg HS.",
            childDose = "1-1.25 mg/kg IV/IM/PO q6h (max 25-50 mg/dose, 150-300 mg/day).",
            contraindications = "Acute narrow-angle glaucoma, prostatic hypertrophy with urinary retention, stenosing peptic ulcer, pyloroduodenal obstruction, bladder neck obstruction, neonates and premature infants.",
            modeOfAction = "Competitive antagonist at peripheral and central histamine H1 receptors; possesses potent central and peripheral anticholinergic (muscarinic M1) blocking properties, suppressing extrapyramidal symptoms and histaminic allergy.",
            precautions = "BEERS CRITERIA HIGH RISK in elderly: Strong anticholinergic causing acute confusion, delirium, urinary retention, and falls. Warn patient against driving or combining with alcohol.",
            nemlCategory = "Nepal Essential Medicines List (Antiallergic & Emergency Medicine)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            beersCriteriaRisk = "HIGH RISK: Avoid in older adults; causes severe cognitive impairment, anticholinergic delirium, urinary retention, and fractures.",
            counselingNepali = "यो बान्ता रोक्ने औषधि (जस्तै मेटोक्लोप्रामिड) वा मानसिक रोगका औषधिले गर्दा घाँटी बटारिने, जिउ अरट्ठ पर्ने कडा समस्या तुरुन्त ठीक गर्ने सुई तथा कडा एलर्जीको औषधि हो। औषधिले धेरै निन्द्रा र झुम लाग्ने हुनाले गाडी नचलाउनुहोस्। मुख धेरै सुक्खा हुने र पिसाब रोकिन सक्ने भएकाले त्यस्तो भएमा डाक्टरलाई भन्नुहोस्।",
            counselingEnglish = "First-line antidote for acute neck spasms, jaw clenching, and dystonia caused by metoclopramide or antipsychotics, and allergy adjunct. Causes heavy drowsiness and dry mouth. Avoid driving and alcohol.",
            era = "Older / Classical (Synthesized 1943 by George Rieveschl)",
            therapeuticClassTag = "Antihistamine / Anticholinergic / Emergency Medicine"
        ),

        // ==========================================
        // 19. ISOSORBIDE DINITRATE (Sublingual & Oral)
        // ==========================================
        Drug(
            id = "d_vital_isosorbide_dinitrate",
            genericName = "Isosorbide Dinitrate",
            system = "Cardiovascular System (CVS)",
            drugClass = "Organic Nitrate Vasodilator & Antianginal Agent",
            blackBoxWarning = null,
            indications = "Acute relief of angina pectoris (sublingual formulation); chronic long-term prophylaxis of angina pectoris; Heart Failure with Reduced Ejection Fraction (HFrEF) in combination with Hydralazine (BiDil regimen, guideline-directed therapy for African-Americans or patients intolerant to ACE inhibitors / ARBs).",
            doses = "Acute Angina Attack (Sublingual):\n• 2.5 to 5 mg SUBLINGUALLY under tongue dissolved at first sign of chest pain; may repeat every 5 minutes PRN up to a maximum of 3 doses in 15 minutes.\nChronic Angina Prophylaxis (Oral):\n• 10 to 40 mg PO BID to TID.\n• MANDATORY NITRATE-FREE INTERVAL: Dose at 8:00 AM and 2:00 PM (14-hour nitrate-free interval overnight) to prevent hemodynamic nitrate tolerance.\nHeart Failure (HFrEF) with Hydralazine (BiDil Regimen):\n• Initial: 20 mg PO TID + Hydralazine 37.5 mg TID; titrate to target 40 mg PO TID + Hydralazine 75 mg TID.",
            administration = "Sublingual: Place tablet under tongue and allow to dissolve completely; do not chew or swallow. Oral: Take with water on an empty stomach (1 hour before or 2 hours after meals).",
            timing = "Sublingual stat at chest pain onset; oral with eccentric dosing (e.g. 8 AM, 2 PM) to preserve nocturnal nitrate clearance.",
            specialInstructions = "FATAL PDE-5 INHIBITOR INTERACTION (ABSOLUTELY CONTRAINDICATED):\n• NEVER co-administer with Phosphodiesterase-5 (PDE-5) inhibitors (Sildenafil/Viagra within 24 hours, Tadalafil/Cialis within 48 hours). Simultaneous use precipitates catastrophic, refractory life-threatening hypotension and cardiovascular collapse!\nNITRATE HEADACHE: Throbbing headache occurs in up to 50% of patients during early therapy due to meningeal arterial dilation; treat with paracetamol; headache typically diminishes with continued therapy. DO NOT DISCONTINUE ABRUPTLY (can precipitate rebound severe coronary vasospasm).",
            pkPd = "Sublingual bioavailability ~40-50% (rapid systemic absorption bypassing liver); oral bioavailability ~20-30% due to massive first-pass hepatic metabolism. Sublingual onset of action: 2 to 5 minutes; duration ~1 to 2 hours. Oral onset: 20 to 40 minutes; duration ~4 to 6 hours. Metabolized in the liver to active metabolites: Isosorbide-2-mononitrate (half-life 2h) and Isosorbide-5-mononitrate (half-life 5h). Excreted in urine as glucuronides.",
            renalAdj = "No dosage adjustment necessary.",
            hepaticAdj = "Use with caution in severe hepatic impairment (metabolism is decreased).",
            pregnancy = "Category C (Use only if maternal benefit clearly outweighs fetal risk).",
            lactation = "Unknown if excreted in human milk; use with caution.",
            sideEffects = "Severe throbbing headache, postural hypotension, syncope, reflex tachycardia, flushing, weakness, dizziness, peripheral edema, rare methemoglobinemia.",
            priceNpr = "NPR 18.00 - 45.00 per strip of 10 (5 mg sublingual / 10 mg oral)",
            priceInr = "INR 12.00 - 32.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Sorbitrate", "Abbott / Medisales Nepal", "SL Tab / Tab", "5 mg / 10 mg"),
                BrandInfo("Isordil", "Sanofi Nepal", "Tab", "5 mg / 10 mg"),
                BrandInfo("Dilatrate", "Torrent Nepal", "Tab", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Sorbitrate", "Abbott India", "SL Tab / Tab", "5 mg / 10 mg"),
                BrandInfo("Isordil", "Sanofi India", "Tab", "5 mg / 10 mg"),
                BrandInfo("Cardisorb", "Sun Pharma", "Tab", "10 mg / 20 mg")
            ),
            adultDose = "Acute Angina: 2.5-5 mg SL q5min x max 3 doses. Prophylaxis: 10-40 mg PO BID (8am, 2pm).",
            childDose = "Not recommended in pediatric patients.",
            contraindications = "Concomitant use with PDE-5 inhibitors (sildenafil, tadalafil, vardenafil) or riociguat; severe anemia; acute angle-closure glaucoma; elevated intracranial pressure / head trauma; hypertrophic obstructive cardiomyopathy (HOCM); severe aortic stenosis; right ventricular myocardial infarction.",
            modeOfAction = "Denitrated in vascular smooth muscle to produce nitric oxide (NO), stimulating guanylyl cyclase to increase cyclic GMP, leading to dephosphorylation of myosin light chains and marked venodilation, reducing cardiac preload, left ventricular end-diastolic pressure, and myocardial oxygen demand.",
            precautions = "Do not take with sildenafil or tadalafil. Maintain daily nitrate-free interval to avoid tolerance. Sit down before taking sublingual tablet to prevent syncopal falls.",
            nemlCategory = "Nepal Essential Medicines List (Antianginal Medicines)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            counselingNepali = "यो मुटुको नसा साँघुरिएर छाती दुख्ने (एन्जाइना / हृदयघातको दुखाई) समस्यामा जिब्रो मुनि राख्ने औषधि (सोरबिट्रेट) हो। छाती दुख्ने बित्तिकै बसेर एउटा चक्की जिब्रो मुनि राख्नुहोस्। ५ मिनेटमा दुखाई कम नभए अर्को चक्की राख्न सकिन्छ (बढीमा ३ चक्की)। १५ मिनेटमा पनि दुखाई कम नभए तुरुन्त अस्पताल जानुहोस्। भियाग्रा वा यौन शक्ति बढाउने औषधिसँग यो कहिल्यै नलिनुहोस् किनकि यसले रक्तचाप शून्य बनाएर ज्यान जान सक्छ।",
            counselingEnglish = "Sublingual emergency nitrate for acute chest pain (angina). Place under tongue while sitting down at onset of pain; may repeat every 5 min up to 3 doses. Seek emergency care if pain persists after 15 min. NEVER take with Viagra or Cialis.",
            era = "Older / Classical (Synthesized 1939)",
            therapeuticClassTag = "Nitrate / Vasodilator / Antianginal / Heart Failure"
        ),

        // ==========================================
        // 20. METHYLPHENIDATE HYDROCHLORIDE
        // ==========================================
        Drug(
            id = "d_vital_methylphenidate",
            genericName = "Methylphenidate Hydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Central Nervous System Psychostimulant (Dopamine-Norepinephrine Reuptake Inhibitor)",
            blackBoxWarning = "ABUSE, MISUSE, AND ADDICTION: Methylphenidate has a high potential for abuse and misuse, which can lead to substance use disorder including addiction. Misuse can cause overdose or death. Carefully evaluate each patient's risk of abuse before prescribing.",
            indications = "Attention-Deficit/Hyperactivity Disorder (ADHD) in pediatric patients (>=6 years) and adults; Narcolepsy with or without cataplexy; refractory depression in palliative, geriatric, or post-stroke rehabilitation settings.",
            doses = "Pediatric ADHD (>=6 years):\n• Immediate Release (IR): Initial 5 mg PO BID (before breakfast and lunch); increase by 5 to 10 mg weekly as needed (max 60 mg/day).\n• Extended Release (SR / Osmotic-Release OROS / Concerta): Initial 18 mg PO once daily in the morning; may titrate by 18 mg weekly to optimal response (max 54 to 72 mg/day).\nAdult ADHD / Narcolepsy:\n• Immediate Release: 20 to 30 mg PO daily in divided doses (10 mg BID-TID taken 30-45 minutes before meals; max 60 mg/day).\n• Extended Release: 18 to 36 mg PO once daily in morning (max 72 mg/day).",
            administration = "Take orally 30 to 45 minutes before meals. Extended-release tablets (OROS / Concerta / Inspiral SR) MUST be swallowed whole with water; never crush, chew, or divide.",
            timing = "Morning with breakfast and midday with lunch; avoid afternoon or evening doses (after 4:00 PM) to prevent severe insomnia.",
            specialInstructions = "NEPAL DDA SCHEDULE 'KA' (STRICTLY CONTROLLED PSYCHOTROPIC MEDICINE): Requires specialized triplicate controlled prescription register. PEDIATRIC GROWTH MONITORING: Routinely monitor height and weight percentiles in children; psychostimulants can cause appetite suppression, weight loss, and slight temporary attenuation of growth velocity (drug holidays during school breaks may be considered). CARDIOVASCULAR SCREENING: Assess baseline blood pressure, heart rate, and family history of sudden cardiac death before initiation.",
            pkPd = "Rapid and extensive oral absorption. Bioavailability ~30% (IR) due to extensive first-pass de-esterification. Peak plasma in 1.5-2 hours (IR), 6-8 hours (OROS). Protein binding 15%. Extensively metabolized in liver by carboxylesterase-1 (CES1) to inactive ritalinic acid (alpha-phenyl-2-piperidine acetic acid). Elimination half-life ~2 to 3.5 hours. Excreted almost entirely in urine (90%) as ritalinic acid.",
            renalAdj = "No dosage adjustment necessary (metabolite is inactive).",
            hepaticAdj = "Use with caution in severe hepatic impairment.",
            pregnancy = "Category C (Potential risk of fetal cardiovascular malformations; use only if clearly indicated).",
            lactation = "Excreted in human breast milk in low concentrations; monitor infant for insomnia, agitation, and poor feeding.",
            sideEffects = "Anorexia, weight loss, insomnia, headache, tachycardia, palpitations, hypertension, dry mouth, abdominal pain, irritability, anxiety, tics (Tourette-like), Raynaud's phenomenon, priapism (rare).",
            priceNpr = "NPR 120.00 - 280.00 per strip of 10 (10 mg / 20 mg SR)",
            priceInr = "INR 85.00 - 210.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Inspiral", "Ipca Laboratories Nepal", "Tab / SR Tab", "10 mg / 20 mg / 10mg SR / 20mg SR"),
                BrandInfo("Ritalin", "Novartis Nepal", "Tab", "10 mg / 20 mg"),
                BrandInfo("Addwize", "Sun Pharma Nepal", "Tab", "10 mg / 20 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Inspiral", "Ipca Laboratories", "Tab / SR Tab", "10 mg / 20 mg / 10mg SR / 20mg SR"),
                BrandInfo("Ritalin", "Novartis India", "Tab", "10 mg"),
                BrandInfo("Concerta", "Janssen India", "OROS Tab", "18 mg / 36 mg / 54 mg"),
                BrandInfo("Addwize", "Sun Pharma", "Tab", "10 mg / 20 mg")
            ),
            pediatricDosePerKg = 0.3,
            pediatricInterval = "mg/kg/day PO divided BID for ADHD (titrate up to max 1-2 mg/kg/day or 60 mg/d)",
            adultDose = "ADHD/Narcolepsy: 10-20 mg PO BID-TID before meals (max 60 mg/d) or 18-54 mg OROS OD.",
            childDose = "Age >=6 yrs: 5 mg PO BID, titrate by 5-10 mg weekly (max 60 mg/day).",
            contraindications = "Marked anxiety, tension, and agitation; glaucoma; history of motor tics or family history of Tourette syndrome; severe cardiovascular disease (uncontrolled hypertension, severe arrhythmias, structural heart defects); concomitant MAO inhibitors (within 14 days).",
            modeOfAction = "Blocks the dopamine transporter (DAT) and norepinephrine transporter (NET), inhibiting reuptake and increasing synaptic dopamine and norepinephrine concentrations in the prefrontal cortex.",
            precautions = "NEPAL DDA SCHEDULE 'KA' controlled substance. Monitor height, weight, BP, and heart rate every 3-6 months. Avoid evening doses to prevent insomnia.",
            nemlCategory = "Nepal Essential Medicines List (Controlled Psychostimulant)",
            ddaSchedule = "Schedule 'Ka' (क वर्ग - Controlled Narcotic/Psychotropic Drug)",
            counselingNepali = "यो बालबालिका तथा वयस्कहरूमा ध्यान केन्द्रित गर्न नसक्ने, अत्याधिक चञ्चल हुने (एडीएचडी) तथा दिनभर निन्द्रा लाग्ने समस्या (नार्कोलेप्सी) मा दिइने कडा औषधि हो। यो औषधि बिहान र दिउँसो खाना खानुभन्दा आधा घण्टा अगाडि लिनुपर्छ। राति निन्द्रा नलाग्ने हुनाले साँझ ४ बजेपछि यो औषधि खानु हुँदैन। बच्चाको उचाइ र तौल नियमित नाप्नुहोस्।",
            counselingEnglish = "Controlled psychostimulant for ADHD and narcolepsy. Take in the morning and midday before meals; avoid doses after 4 PM to prevent insomnia. Regularly monitor child's height, weight, and blood pressure.",
            era = "Older / Classical (Synthesized 1944 by Leandro Panizzon at Ciba)",
            therapeuticClassTag = "Psychostimulant / ADHD / Schedule 'Ka' Controlled Drug"
        ),

        // ==========================================
        // 21. AMISULPRIDE
        // ==========================================
        Drug(
            id = "d_vital_amisulpride",
            genericName = "Amisulpride",
            system = "Central Nervous System (CNS)",
            drugClass = "Second-Generation Atypical Antipsychotic (Substituted Benzamide)",
            blackBoxWarning = "INCREASED MORTALITY IN ELDERLY PATIENTS WITH DEMENTIA-RELATED PSYCHOSIS: Elderly patients with dementia-related psychosis treated with antipsychotic drugs are at an increased risk of death (mainly cardiovascular or infectious).",
            indications = "Acute and chronic schizophrenia and schizoaffective disorder with prominent positive symptoms (delusions, hallucinations) and/or prominent primary negative symptoms (blunted affect, emotional and social withdrawal, avolition, poverty of speech); dysthymia and chronic refractory depression (at low doses); prevention and treatment of postoperative nausea and vomiting (PONV).",
            doses = "Predominantly Negative Symptoms (Low-Dose Regimen):\n• 50 to 300 mg PO once daily in the morning (doses <= 300 mg should be given as a single daily dose; preferentially blocks presynaptic dopamine autoreceptors, increasing frontal dopaminergic outflow).\nAcute Psychosis / Positive Symptoms Predominant:\n• 400 to 800 mg PO daily in two divided doses (BID); in severe treatment-resistant psychosis may titrate up to maximum 1200 mg/day.\nMixed Positive and Negative Symptoms:\n• 400 to 600 mg PO daily divided BID.\nDysthymia (Low-Dose Off-Label):\n• 50 mg PO once daily in morning.",
            administration = "Take orally with or without food. Doses <= 300 mg should be taken once daily in the morning; doses > 300 mg should be divided BID.",
            timing = "Morning for once-daily doses; morning and evening for divided doses.",
            specialInstructions = "UNIQUE PHARMACOLOGICAL PROFILE:\n• Minimal Metabolic Syndrome Risk: Does not cause significant weight gain, insulin resistance, or dyslipidemia (unlike olanzapine or clozapine).\n• No Sedation or Anticholinergic Effects: Pure selective D2/D3 limbic antagonist with ZERO affinity for serotonin (5-HT2), histamine (H1), or muscarinic (M1) receptors.\n• MARKED HYPERPROLACTINEMIA: Produces significant, dose-independent prolactin elevation due to pituitary D2 blockade outside the blood-brain barrier (causes amenorrhea, galactorrhea, gynecomastia, loss of libido, and bone demineralization).\n• RENAL ELIMINATION: Unlike almost all other antipsychotics, amisulpride is NOT metabolized by hepatic CYP450 enzymes; it is excreted 70-80% UNCHANGED by the kidneys; mandatory dose reduction in renal failure.",
            pkPd = "Oral bioavailability ~48%. Biphasic absorption with two plasma peaks (at 1 hour and 3-4 hours post-dose). Low protein binding (~16%). Negligible hepatic metabolism (<10%); does not inhibit or induce CYP450 enzymes. Elimination half-life ~12 hours. Excreted predominantly (70-80%) unchanged in urine via glomerular filtration.",
            renalAdj = "MANDATORY ADJUSTMENT (Renal Elimination):\n• CrCl 30-60 mL/min: Reduce dose by 50% (half standard dose).\n• CrCl 10-30 mL/min: Reduce dose by 67% (one-third standard dose).\n• CrCl <10 mL/min: Contraindicated.",
            hepaticAdj = "No dosage adjustment necessary (eliminated renally).",
            pregnancy = "Category C (Limited human data; third-trimester exposure carries risk of neonatal extrapyramidal symptoms and withdrawal).",
            lactation = "Excreted into human breast milk in significant amounts; breastfeeding is not recommended.",
            sideEffects = "Hyperprolactinemia (galactorrhea, amenorrhea, breast swelling, sexual dysfunction), insomnia, anxiety, agitation, mild extrapyramidal symptoms (tremor, akathisia at high doses >800 mg/d), QTc interval prolongation, weight gain (mild), orthostatic hypotension.",
            priceNpr = "NPR 120.00 - 260.00 per strip of 10 (50 mg / 100 mg / 200 mg)",
            priceInr = "INR 85.00 - 190.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Solian", "Sanofi / Medisales Nepal", "Tab", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Sulpitac", "Sun Pharma Nepal", "Tab", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Amisant", "Torrent / Medisales Nepal", "Tab", "50 mg / 100 mg / 200 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Solian", "Sanofi India", "Tab", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Sulpitac", "Sun Pharma", "Tab", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Amazeo", "Torrent Pharmaceuticals", "Tab", "50 mg / 100 mg / 200 mg"),
                BrandInfo("Joykem", "Alkem Laboratories", "Tab", "50 mg / 100 mg")
            ),
            adultDose = "Negative symptoms: 50-300 mg PO OD morning. Acute psychosis: 400-800 mg/day divided BID.",
            childDose = "Not recommended in children <18 years.",
            contraindications = "Prolactin-dependent tumors (e.g. pituitary prolactinoma, breast cancer); pheochromocytoma; severe renal failure (CrCl <10 mL/min); concomitant prolactin-elevating or QT-prolonging drugs; lactation.",
            modeOfAction = "Selectively binds with high affinity to D2 and D3 dopamine receptors in the mesolimbic system without striatal predominance. At low doses, preferentially blocks presynaptic autoreceptors, enhancing dopaminergic release and improving negative symptoms; at higher doses, blocks postsynaptic D2 receptors, suppressing positive psychotic symptoms.",
            precautions = "Monitor prolactin levels and bone density on long-term therapy. Check baseline ECG for QTc prolongation. Adjust dose strictly for renal impairment.",
            nemlCategory = "Nepal Essential Medicines List (Atypical Antipsychotic)",
            ddaSchedule = "Prescription Only (Schedule 'Kha')",
            beersCriteriaRisk = "Moderate Risk: Lower risk of metabolic syndrome and sedation than other atypical antipsychotics, but causes QTc prolongation and hyperprolactinemia.",
            counselingNepali = "यो मानसिक रोग (स्किजोफ्रेनिया), भ्रम देखिने वा सुनिने समस्या तथा समाजबाट एक्लिने र मनमा उत्साह नहुने समस्यामा प्रयोग गरिने आधुनिक औषधि हो। थोरै मात्रामा लिँदा यसले मानिसलाई फुर्तिलो बनाउँछ भने धेरै मात्रामा लिँदा उत्तेजना कम गर्छ। यो औषधिले तौल धेरै बढाउँदैन तर महिलाहरूमा महिनावारी गडबड हुने वा स्तनबाट दुध आउने हुन सक्छ। मिर्गौलाका बिरामीमा औषधिको मात्रा घटाउनुपर्छ।",
            counselingEnglish = "Second-generation atypical antipsychotic with low metabolic and sedation risk. Effective for both positive symptoms and negative apathy. May cause high prolactin levels leading to breast enlargement or missed periods. Dose must be adjusted in kidney disease.",
            era = "Newer / Modern (Approved in Europe 1990s, Sanofi)",
            therapeuticClassTag = "Atypical Antipsychotic / Substituted Benzamide / Neuropsychiatry"
        )
    )
}
