package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

object NeuroPsychAntimicrobialPart2Data {

    val drugs: List<Drug> = listOf(
        // ==========================================
        // NEUROLOGY & PSYCHIATRY
        // ==========================================
        Drug(
            id = "d_neuro2_oxcarbazepine",
            genericName = "Oxcarbazepine",
            system = "Central Nervous System (CNS)",
            drugClass = "10-Keto Voltage-Gated Sodium Channel Anticonvulsant",
            blackBoxWarning = "SERIOUS DERMATOLOGIC REACTIONS: Risk of SJS and TEN, particularly in patients carrying HLA-B*1502 allele.",
            indications = "Monotherapy or adjunctive therapy for focal (partial) seizures with or without secondary generalization in adults and children >= 2 years, trigeminal neuralgia second-line.",
            doses = "Adult: Start 300 mg PO BID; titrate weekly by 300 mg/day up to maintenance 1200-2400 mg/day divided BID.\nPediatric (>= 2 yr): Start 8-10 mg/kg/day divided BID; titrate to target 30-45 mg/kg/day.",
            administration = "Take orally twice daily with or without food.",
            timing = "Morning and evening.",
            specialInstructions = "Prodrug for active 10-monohydroxy derivative (MHD). Does not undergo hepatic auto-induction (unlike carbamazepine). Check serum sodium (hyponatremia occurs in ~2.5-3%, higher than carbamazepine).",
            pkPd = "Rapidly and completely absorbed. Converted in liver by cytosolic arylketone reductase to active licarbazepine (MHD). MHD half-life 8-10 hours.",
            renalAdj = "CrCl <30 mL/min: Initiate at 300 mg once daily and titrate slowly.",
            hepaticAdj = "No adjustment in mild-to-moderate impairment. Not studied in severe impairment.",
            pregnancy = "Category C (Less teratogenic than carbamazepine or valproate; co-administer high-dose folic acid).",
            lactation = "Excreted in breast milk; monitor infant for drowsiness.",
            sideEffects = "Dizziness, somnolence, diplopia, ataxia, nausea, vomiting, hyponatremia (SIADH-like effect), rash.",
            priceNpr = "NPR 80.00 - 170.00 per strip of 10 (150mg / 300mg / 600mg)",
            priceInr = "INR 50.00 - 120.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Trileptal", "Novartis / Medisales Nepal", "Tab / Susp", "150 mg / 300 mg / 600 mg / 60mg/mL"),
                BrandInfo("Oleptal", "Sun Pharma Nepal", "Tab", "150 mg / 300 mg / 600 mg"),
                BrandInfo("Oxetol", "Sun Pharma Nepal", "Tab", "300 mg / 600 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Trileptal", "Novartis India", "Tab", "150 / 300 / 600 mg"),
                BrandInfo("Oleptal", "Sun Pharma", "Tab", "300 / 600 mg")
            ),
            adultDose = "300-600 mg PO BID (max 2400 mg/day).",
            childDose = "Children >= 2 yr: 8-10 mg/kg/day PO divided BID.",
            contraindications = "Hypersensitivity to oxcarbazepine or carbamazepine (cross-reactivity occurs in 25-30%).",
            modeOfAction = "Blocks voltage-sensitive sodium channels, preventing repetitive neuronal discharges and stabilizing hyperexcitable cell membranes.",
            therapeuticClassTag = "Antiepileptic"
        ),

        Drug(
            id = "d_neuro2_topiramate",
            genericName = "Topiramate",
            system = "Central Nervous System (CNS)",
            drugClass = "Sulfamate-Substituted Monosaccharide Anticonvulsant",
            blackBoxWarning = null,
            indications = "Focal seizures, generalized tonic-clonic seizures, Lennox-Gastaut syndrome, chronic migraine prophylaxis in adults, weight loss (adjunctive).",
            doses = "Migraine Prophylaxis: Start 25 mg PO once daily at bedtime; titrate weekly by 25 mg up to target 50 mg PO BID (100 mg/day). Epilepsy: Start 25-50 mg PO daily; titrate to 200-400 mg/day divided BID.",
            administration = "Take with or without food with plenty of water. Swallow tablet whole (bitter taste if crushed).",
            timing = "Bedtime (initially) or divided BID.",
            specialInstructions = "COGNITIVE SLOWING & NEPHROLITHIASIS: Can cause language/word-finding difficulty ('Dopamax'), cognitive dulling, and secondary angle-closure glaucoma. Ensure high fluid intake (2-3 L/day) to prevent kidney stones (carbonic anhydrase inhibition).",
            pkPd = "Rapid absorption; bioavailability ~80%. Minimal hepatic metabolism. Excreted 70% unchanged in urine. Elimination half-life ~21 hours.",
            renalAdj = "CrCl <70 mL/min: Reduce dose by 50% and titrate slowly. Hemodialysis: Administer supplemental dose post-dialysis.",
            hepaticAdj = "Use with caution in moderate-to-severe hepatic impairment.",
            pregnancy = "Category D (Increases risk of oral clefts - cleft lip/palate by 2-5 fold in 1st trimester; teratogenic).",
            lactation = "Excreted in breast milk; monitor infant for sedation and diarrhea.",
            sideEffects = "Paresthesias (tingling in fingers/toes >50%), cognitive slowing/word-finding difficulty, weight loss, anorexia, kidney stones (nephrolithiasis 1.5%), oligohidrosis (reduced sweating with hyperthermia in children), acute myopia with secondary angle-closure glaucoma.",
            priceNpr = "NPR 70.00 - 150.00 per strip of 10 (25mg / 50mg / 100mg)",
            priceInr = "INR 45.00 - 110.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Topamac", "Janssen / Johnson & Johnson Nepal", "Tab", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Topirol", "Sun Pharma Nepal", "Tab", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Nextop", "Torrent Pharmaceuticals", "Tab", "25 mg / 50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Topamac", "Janssen", "Tab", "25 / 50 / 100 mg"),
                BrandInfo("Topirol", "Sun Pharma", "Tab", "25 / 50 / 100 mg")
            ),
            adultDose = "Migraine: 50 mg PO BID; Epilepsy: 100-200 mg PO BID.",
            childDose = "Epilepsy >= 2 yr: 1-3 mg/kg/day PO divided BID; titrate to 5-9 mg/kg/day.",
            contraindications = "Hypersensitivity to topiramate; metabolic acidosis with concurrent metformin.",
            modeOfAction = "Multi-target mechanism: Blocks voltage-dependent sodium channels, potentiates GABA-A receptor inhibitory activity, antagonizes AMPA/kainate glutamate receptors, and weakly inhibits carbonic anhydrase (CA-II and CA-IV).",
            therapeuticClassTag = "Antiepileptic / Migraine"
        ),

        Drug(
            id = "d_neuro2_pramipexole",
            genericName = "Pramipexole Dihydrochloride",
            system = "Central Nervous System (CNS)",
            drugClass = "Non-Ergot Dopamine D2/D3 Receptor Agonist",
            blackBoxWarning = null,
            indications = "Idiopathic Parkinson's disease (monotherapy in early disease or adjunctive to Levodopa in advanced disease), moderate-to-severe primary Restless Legs Syndrome (RLS).",
            doses = "Parkinson's Disease (Immediate Release): Start 0.125 mg PO TID; titrate weekly to 0.25 mg TID, then 0.5 mg TID, up to max 1.5 mg PO TID (4.5 mg/day). Extended Release (ER): Start 0.375 mg PO once daily; titrate to 1.5-4.5 mg OD. Restless Legs: 0.125 mg PO once daily 2-3 hours before bedtime.",
            administration = "Take orally with food to reduce nausea.",
            timing = "TID with meals (IR) or once daily in morning (ER). RLS: 2-3 hours before bedtime.",
            specialInstructions = "IMPULSE CONTROL DISORDERS: Can trigger pathological gambling, compulsive shopping, hypersexuality, and binge eating. Warn family members. Risk of sudden sleep attacks while driving.",
            pkPd = "Rapid absorption; bioavailability >90%. Excreted >90% unchanged via renal tubular secretion. Elimination half-life 8 hours (12 hours in elderly).",
            renalAdj = "CrCl 30-50 mL/min: 0.125 mg BID (max 1.5 mg/day). CrCl 15-30 mL/min: 0.125 mg OD (max 0.75 mg/day). CrCl <15 mL/min: Not recommended.",
            hepaticAdj = "No adjustment needed; not metabolized by liver.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Inhibits prolactin secretion and suppresses lactation; avoid in nursing mothers.",
            sideEffects = "Nausea, orthostatic hypotension, somnolence, sudden sleep attacks, impulse control disorders, visual hallucinations, peripheral edema.",
            priceNpr = "NPR 60.00 - 140.00 per strip of 10 (0.125mg / 0.25mg / 0.5mg / 1mg)",
            priceInr = "INR 40.00 - 95.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Pramipex", "Sun Pharma Nepal", "Tab / ER", "0.25 mg / 0.5 mg / 1 mg / 1.5 mg ER"),
                BrandInfo("Mirapex", "Boehringer Ingelheim Nepal", "Tab", "0.25 mg / 0.5 mg / 1 mg"),
                BrandInfo("Pramirol", "Intas Pharmaceuticals", "Tab", "0.25 mg / 0.5 mg / 1 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Pramipex", "Sun Pharma", "Tab", "0.25 / 0.5 / 1 mg"),
                BrandInfo("Pramirol", "Intas", "Tab", "0.25 / 0.5 / 1 mg")
            ),
            adultDose = "0.25-1 mg PO TID (Parkinson's); 0.125-0.5 mg OD (RLS).",
            childDose = "Safety and efficacy not established in pediatric patients.",
            contraindications = "Hypersensitivity to pramipexole; severe renal impairment without dose adjustment.",
            modeOfAction = "High-affinity agonist at dopamine D2 and D3 receptors (preferential affinity for D3 receptors in limbic system), directly stimulating striatal dopamine receptors.",
            therapeuticClassTag = "Parkinson's Disease"
        ),

        Drug(
            id = "d_psych2_venlafaxine",
            genericName = "Venlafaxine Hydrochloride (Extended Release)",
            system = "Central Nervous System (CNS)",
            drugClass = "Serotonin-Norepinephrine Reuptake Inhibitor (SNRI)",
            blackBoxWarning = "SUICIDAL THOUGHTS AND BEHAVIORS: Antidepressants increase the risk of suicidal thoughts and behaviors in children and young adults <= 24 years.",
            indications = "Major Depressive Disorder (MDD), Generalized Anxiety Disorder (GAD), Social Anxiety Disorder, Panic Disorder, neuropathic pain, vasomotor hot flashes.",
            doses = "Adult (Extended Release): Start 37.5 to 75 mg PO once daily in morning with food; may titrate by 75 mg/day every 1-2 weeks up to target 150-225 mg PO once daily (max 375 mg/day in severe inpatient depression).",
            administration = "Take with food at approximately the same time each day (morning). Swallow capsule whole with water; do not divide, crush, or chew.",
            timing = "Once daily in the morning with breakfast.",
            specialInstructions = "DOSE-DEPENDENT BLOOD PRESSURE ELEVATION: At doses >150-225 mg/day, noradrenergic reuptake inhibition produces sustained dose-dependent hypertension; monitor blood pressure regularly. Discontinuation syndrome is severe (electric shock 'brain zaps'); taper very slowly.",
            pkPd = "Oral bioavailability ~45%. Extensively metabolized by CYP2D6 to active metabolite O-desmethylvenlafaxine (ODV / Desvenlafaxine). Half-life: venlafaxine ~5 hours, ODV ~11 hours.",
            renalAdj = "CrCl 30-80 mL/min: Reduce daily dose by 25-50%. CrCl <30 mL/min: Reduce daily dose by 50%.",
            hepaticAdj = "Mild-to-moderate impairment: Reduce dose by 50%. Severe impairment: Reduce by >=50% or avoid.",
            pregnancy = "Category C (Risk of neonatal withdrawal / poor neonatal adaptation syndrome).",
            lactation = "Excreted in breast milk; monitor infant for poor feeding and sleep disturbances.",
            sideEffects = "Nausea, insomnia, dry mouth, dizziness, diaphoresis, sexual dysfunction, dose-dependent hypertension, sustained tachycardia, severe discontinuation syndrome.",
            priceNpr = "NPR 80.00 - 170.00 per strip of 10 (37.5mg / 75mg / 150mg ER)",
            priceInr = "INR 50.00 - 110.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Venlor XR", "Cipla Nepal", "Cap", "37.5 mg / 75 mg / 150 mg"),
                BrandInfo("Effexor XR", "Pfizer Nepal", "Cap", "75 mg / 150 mg"),
                BrandInfo("Veniz XR", "Sun Pharma Nepal", "Cap", "75 mg / 150 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Venlor", "Cipla", "Cap", "37.5 / 75 / 150 mg XR"),
                BrandInfo("Effexor", "Pfizer", "Cap", "75 / 150 mg")
            ),
            adultDose = "75-150 mg PO once daily ER with breakfast (max 225-375 mg/day).",
            childDose = "Not approved for pediatric patients.",
            contraindications = "Concomitant use of MAO inhibitors (within 14 days), uncontrolled severe hypertension.",
            modeOfAction = "Potently inhibits neuronal serotonin reuptake at low doses (<150 mg/day) and both serotonin and norepinephrine reuptake at higher doses (>=150 mg/day), with weak dopamine reuptake inhibition at very high doses.",
            therapeuticClassTag = "Antidepressants / SNRI"
        ),

        Drug(
            id = "d_psych2_mirtazapine",
            genericName = "Mirtazapine",
            system = "Central Nervous System (CNS)",
            drugClass = "Noradrenergic and Specific Serotonergic Antidepressant (NaSSA)",
            blackBoxWarning = "SUICIDAL THOUGHTS AND BEHAVIORS: Antidepressants increase the risk of suicidal ideation and behaviors in young adults <= 24 years.",
            indications = "Major Depressive Disorder (MDD), particularly in patients suffering from prominent insomnia, severe anxiety, and marked anorexia/weight loss.",
            doses = "Adult: Start 15 mg PO once daily at bedtime; may titrate every 1-2 weeks up to maintenance 30 to 45 mg PO once daily at bedtime (max 45 mg/day).",
            administration = "Take orally once daily at bedtime with or without water. Orally disintegrating tablets (ODT) dissolve rapidly on tongue.",
            timing = "Strictly at bedtime (potent H1-antihistaminic somnolence).",
            specialInstructions = "PARADOXICAL SEDATION PROFILE: Highly sedating at low doses (7.5-15 mg) due to potent H1-receptor blockade; at higher doses (30-45 mg), increased noradrenergic neurotransmission offsets sedation. Excellent choice for elderly depressed patients with failure to thrive and insomnia.",
            pkPd = "Rapid and complete absorption; bioavailability ~50%. 85% protein bound. Extensively metabolized by CYP1A2, CYP2D6, and CYP3A4. Elimination half-life 20-40 hours.",
            renalAdj = "CrCl <40 mL/min: Clearance decreased by 30-50%; titrate with caution.",
            hepaticAdj = "Clearance reduced by ~30% in hepatic impairment; use with caution.",
            pregnancy = "Category C (Compatible when benefits outweigh risks).",
            lactation = "Excreted in low levels in breast milk; monitor infant.",
            sideEffects = "Somnolence (>50%), marked increase in appetite and weight gain (>15-20%), dry mouth, constipation, dizziness, peripheral edema, rare agranulocytosis.",
            priceNpr = "NPR 70.00 - 150.00 per strip of 10 (7.5mg / 15mg / 30mg)",
            priceInr = "INR 45.00 - 110.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Mirnite", "Intas Pharmaceuticals Nepal", "Tab / Melt", "7.5 mg / 15 mg / 30 mg"),
                BrandInfo("Mirtaz", "Sun Pharma Nepal", "Tab", "15 mg / 30 mg"),
                BrandInfo("Remeron", "Organon / Medisales Nepal", "Tab", "15 mg / 30 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Mirnite", "Intas", "Tab", "15 / 30 mg"),
                BrandInfo("Mirtaz", "Sun Pharma", "Tab", "15 / 30 mg")
            ),
            adultDose = "15-30 mg PO once daily at bedtime (max 45 mg/day).",
            childDose = "Not approved for pediatric patients.",
            contraindications = "Concomitant use of MAO inhibitors within 14 days, severe hypersensitivity.",
            modeOfAction = "Antagonizes central presynaptic alpha-2 adrenergic autoreceptors and heteroreceptors, increasing central noradrenergic and serotonergic activity; selectively blocks 5-HT2 and 5-HT3 receptors while potently blocking histamine H1 receptors.",
            therapeuticClassTag = "Antidepressants / NaSSA"
        ),

        Drug(
            id = "d_psych2_bupropion",
            genericName = "Bupropion Hydrochloride (Sustained / Extended Release)",
            system = "Central Nervous System (CNS)",
            drugClass = "Norepinephrine-Dopamine Reuptake Inhibitor (NDRI)",
            blackBoxWarning = "SUICIDALITY & NEUROPSYCHIATRIC REACTIONS IN SMOKING CESSATION: Increased suicidality in young adults. Monitor for depression, agitation, and hostility during smoking cessation treatment.",
            indications = "Major Depressive Disorder (MDD), Seasonal Affective Disorder (SAD), smoking cessation aid (Zyban), ADHD (off-label), antidepressant-induced sexual dysfunction reversal.",
            doses = "Depression (XL): Start 150 mg PO once daily in morning; titrate after 4-7 days to target 300 mg PO once daily in morning (max 450 mg/day). Smoking Cessation (SR): 150 mg PO OD x 3 days, then 150 mg PO BID for 7-12 weeks.",
            administration = "Take in the morning. Swallow extended-release tablets whole; never crush, chew, or split (rapid release causes seizures).",
            timing = "Morning (avoids insomnia). For BID dosing, take second dose before 17:00 PM.",
            specialInstructions = "DOSE-DEPENDENT SEIZURE RISK: Lowers seizure threshold. Absolutely contraindicated in patients with epilepsy, bulimia, or anorexia nervosa (electrolyte shifts drastically elevate seizure risk). Zero sexual dysfunction and causes mild weight loss (unlike SSRIs).",
            pkPd = "Rapid absorption. Extensively metabolized by CYP2B6 to active hydroxybupropion. Elimination half-life: bupropion ~14-21 hours, hydroxybupropion ~20 hours.",
            renalAdj = "Reduce dose and/or frequency in moderate-to-severe renal impairment.",
            hepaticAdj = "Moderate-to-severe hepatic impairment: Max 150 mg every other day.",
            pregnancy = "Category C (Safety profile favorable; alternative to SSRIs when indicated).",
            lactation = "Excreted in breast milk; compatible, monitor infant for seizures.",
            sideEffects = "Insomnia, agitation, dry mouth, headache, tremor, tachycardia, hypertension, weight loss, nausea, seizures (0.1-0.4%).",
            priceNpr = "NPR 110.00 - 240.00 per strip of 10 (150mg / 300mg XL)",
            priceInr = "INR 75.00 - 160.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Wellbutrin XL", "GSK Nepal", "Tab", "150 mg / 300 mg"),
                BrandInfo("Bupron XL", "Sun Pharma Nepal", "Tab", "150 mg / 300 mg"),
                BrandInfo("Zyban", "GSK Nepal", "Tab", "150 mg SR")
            ),
            brandsIndia = listOf(
                BrandInfo("Bupron XL", "Sun Pharma", "Tab", "150 / 300 mg"),
                BrandInfo("Wellbutrin", "GSK", "Tab", "150 / 300 mg")
            ),
            adultDose = "150-300 mg PO once daily in morning (XL).",
            childDose = "Not approved for pediatric patients.",
            contraindications = "Seizure disorder, history of anorexia nervosa or bulimia, abrupt withdrawal from alcohol, benzodiazepines, or sedatives, concurrent MAO inhibitors.",
            modeOfAction = "Relatively weak inhibitor of neuronal reuptake of dopamine and norepinephrine (DAT and NET), with no serotonergic activity and no anticholinergic or antihistaminic effects.",
            therapeuticClassTag = "Antidepressants / NDRI"
        ),

        Drug(
            id = "d_psych2_risperidone",
            genericName = "Risperidone",
            system = "Central Nervous System (CNS)",
            drugClass = "Second-Generation Atypical Benzisoxazole Antipsychotic",
            blackBoxWarning = "INCREASED MORTALITY IN ELDERLY DEMENTIA-RELATED PSYCHOSIS: Antipsychotics are associated with an increased risk of death in elderly patients with dementia.",
            indications = "Schizophrenia, acute manic or mixed episodes of Bipolar I Disorder, irritability and severe aggression associated with autistic disorder in children (>= 5 years).",
            doses = "Schizophrenia / Bipolar Mania: Start 1-2 mg PO daily (at bedtime or divided BID); titrate by 1 mg/day up to target 4-6 mg/day (max 8-16 mg/day). Autism (>=5 yr): 0.25-0.5 mg PO at bedtime.",
            administration = "Take orally with or without food. Orally disintegrating tablets dissolve rapidly on tongue.",
            timing = "Bedtime or divided BID.",
            specialInstructions = "HIGHEST HYPERPROLACTINEMIA AMONG ATYPICALS: Potent D2 blockade in tuberoinfundibular pathway causes significant prolactin elevation (galactorrhea, amenorrhea, gynecomastia). Doses >6 mg/day increase extrapyramidal symptoms.",
            pkPd = "Extensively metabolized by CYP2D6 to active metabolite 9-hydroxyrisperidone (Paliperidone). Half-life of active moiety ~20-24 hours.",
            renalAdj = "CrCl <50 mL/min: Start 0.5 mg BID; titrate slowly by 0.5 mg increments (max 2-3 mg/day).",
            hepaticAdj = "Start 0.5 mg BID; titrate carefully in hepatic impairment.",
            pregnancy = "Category C (Extrapyramidal and withdrawal symptoms in neonates exposed during 3rd trimester).",
            lactation = "Excreted in breast milk; monitor infant.",
            sideEffects = "Hyperprolactinemia (galactorrhea, amenorrhea), weight gain, somnolence, extrapyramidal symptoms (at doses >6 mg), orthostatic hypotension, tachycardia, metabolic disturbances.",
            priceNpr = "NPR 35.00 - 85.00 per strip of 10 (1mg / 2mg / 3mg / 4mg)",
            priceInr = "INR 20.00 - 60.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Risdone", "Intas Pharmaceuticals Nepal", "Tab / Liquid", "1 mg / 2 mg / 3 mg / 4 mg / 1mg/mL"),
                BrandInfo("Risperdal", "Janssen / Medisales Nepal", "Tab", "1 mg / 2 mg / 3 mg"),
                BrandInfo("Sizodon", "Sun Pharma Nepal", "Tab", "1 mg / 2 mg / 3 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Risdone", "Intas", "Tab", "1 / 2 / 3 / 4 mg"),
                BrandInfo("Sizodon", "Sun Pharma", "Tab", "1 / 2 / 3 / 4 mg")
            ),
            adultDose = "2-6 mg PO daily (bedtime or divided BID).",
            childDose = "Autism (>=5 yr, weight <20kg): 0.25-0.5 mg PO daily at bedtime.",
            contraindications = "Hypersensitivity to risperidone or paliperidone.",
            modeOfAction = "Potent antagonist at serotonin 5-HT2A receptors and dopamine D2 receptors, along with alpha-1 and alpha-2 adrenergic and histamine H1 receptor blockade.",
            therapeuticClassTag = "Atypical Antipsychotics"
        ),

        Drug(
            id = "d_psych2_zolpidem",
            genericName = "Zolpidem Tartrate",
            system = "Central Nervous System (CNS)",
            drugClass = "Non-Benzodiazepine Imidazopyridine Hypnotic (Z-Drug)",
            blackBoxWarning = "COMPLEX SLEEP BEHAVIORS: Can cause complex sleep behaviors including sleep-walking, sleep-driving, and engaging in other activities while not fully awake. Discontinue immediately if patient experiences complex sleep behavior.",
            indications = "Short-term treatment of insomnia characterized by difficulties with sleep initiation.",
            doses = "Women: 5 mg PO once daily immediately before bedtime. Men: 5 to 10 mg PO once daily immediately before bedtime (max 10 mg/day). Elderly / Hepatic Impairment: 5 mg PO at bedtime.",
            administration = "Take on an empty stomach immediately before getting into bed (at least 7-8 hours remaining before planned time of awakening). Food delays absorption and onset.",
            timing = "Strictly at bedtime immediately before lying down.",
            specialInstructions = "GENDER-SPECIFIC DOSING: Women clear zolpidem significantly slower than men; initial recommended dose for women is 5 mg (FDA requirement to prevent next-morning driving impairment). Limit therapy to 1 to 2 weeks.",
            pkPd = "Rapid oral absorption; onset 15-30 minutes. 92% protein bound. Rapidly metabolized by CYP3A4. Short elimination half-life ~2.5 hours (leaves no next-morning hangover).",
            renalAdj = "No dosage adjustment needed.",
            hepaticAdj = "Severe hepatic impairment: Contraindicated (causes hepatic encephalopathy). Mild-to-moderate: Start 5 mg.",
            pregnancy = "Category C (Avoid in pregnancy).",
            lactation = "Small amounts excreted in breast milk; compatible with caution.",
            sideEffects = "Drowsiness, dizziness, headache, complex sleep behaviors (sleep-eating, sleep-driving with retrograde amnesia), falls in elderly, rebound insomnia upon withdrawal.",
            priceNpr = "NPR 45.00 - 95.00 per strip of 10 (5mg / 10mg)",
            priceInr = "INR 30.00 - 65.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Nitrest", "Torrent Pharmaceuticals Nepal", "Tab", "5 mg / 10 mg"),
                BrandInfo("Ambien", "Sanofi Nepal / Medisales", "Tab", "5 mg / 10 mg"),
                BrandInfo("Zolfresh", "Abbott Nepal", "Tab", "5 mg / 10 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Nitrest", "Torrent", "Tab", "5 / 10 mg"),
                BrandInfo("Zolfresh", "Abbott", "Tab", "5 / 10 mg")
            ),
            adultDose = "5 mg (women) or 5-10 mg (men) PO immediately before bedtime.",
            childDose = "Contraindicated in children <18 years.",
            contraindications = "History of complex sleep behaviors after taking zolpidem, severe respiratory depression, myasthenia gravis, severe hepatic impairment, sleep apnea.",
            modeOfAction = "Selectively binds to the alpha-1 subunit of the GABAA receptor chloride channel complex in the brain, selectively producing hypnotic and sedative effects without significant anxiolytic or muscle-relaxant activity.",
            therapeuticClassTag = "Hypnotics / Insomnia"
        ),

        // ==========================================
        // ANTIMICROBIALS & ANTIPARASITICS
        // ==========================================
        Drug(
            id = "d_anti2_cephalexin",
            genericName = "Cephalexin (Cefalexin)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "First-Generation Oral Cephalosporin",
            blackBoxWarning = null,
            indications = "Skin and soft tissue infections (impetigo, cellulitis, folliculitis caused by MSSA and Streptococcus pyogenes), acute pharyngitis/tonsillitis, uncomplicated cystitis, bone infections.",
            doses = "Adult: 250-500 mg PO every 6 hours (or 500 mg PO BID) with or without food (max 4 g/day).\nPediatric: 25-50 mg/kg/day PO divided into 2 to 4 doses (max 100 mg/kg/day in severe infections).",
            administration = "Take orally with or without food. Complete the full prescribed course.",
            timing = "Every 6 hours or every 12 hours.",
            specialInstructions = "Workhorse oral antibiotic for uncomplicated non-MRSA skin infections. Safe in pregnancy and children. Safe in patients with non-severe, delayed penicillin allergy.",
            pkPd = "Rapid and near-complete oral absorption (90-100%). Low protein binding (10-15%). Excreted >90% unchanged in urine via glomerular filtration and tubular secretion. Half-life ~1 hour.",
            renalAdj = "CrCl 40-50 mL/min: Max 500 mg q8h. CrCl 10-40 mL/min: Max 500 mg q12h. CrCl <10 mL/min: 250-500 mg q24h. Hemodialysis: Administer dose post-dialysis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe throughout pregnancy; first-line oral antibiotic for asymptomatic bacteriuria and skin infections in pregnancy).",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding.",
            sideEffects = "Diarrhea, nausea, dyspepsia, maculopapular rash, urticaria, genital candidiasis.",
            priceNpr = "NPR 45.00 - 95.00 per strip of 10 (250mg / 500mg)",
            priceInr = "INR 30.00 - 65.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Sporidex", "Sun Pharma Nepal", "Cap / Syr / Drops", "250 mg / 500 mg / 125mg/5mL"),
                BrandInfo("Phexin", "GSK Nepal", "Cap / Syr", "250 mg / 500 mg / 125mg/5mL"),
                BrandInfo("Ceff", "Lupin Nepal", "Cap", "250 mg / 500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Sporidex", "Sun Pharma", "Cap / Syr", "250 / 500 mg / 125mg/5mL"),
                BrandInfo("Phexin", "GSK", "Cap / Syr", "250 / 500 mg")
            ),
            pediatricDosePerKg = 40.0,
            pediatricInterval = "mg/kg/day PO divided q6-8h",
            adultDose = "500 mg PO q6-12h x 7-10 days.",
            childDose = "25-50 mg/kg/day PO divided q6-8h.",
            contraindications = "Severe immediate hypersensitivity (anaphylaxis) to cephalosporin antibiotics.",
            modeOfAction = "Inhibits bacterial cell wall synthesis by binding to penicillin-binding proteins (PBPs), inhibiting peptidoglycan cross-linking and activating autolytic enzymes, producing rapid bactericidal cell lysis.",
            therapeuticClassTag = "Cephalosporins / Oral"
        ),

        Drug(
            id = "d_anti2_cefotaxime",
            genericName = "Cefotaxime Sodium",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Third-Generation Broad-Spectrum Cephalosporin",
            blackBoxWarning = null,
            indications = "Neonatal sepsis and meningitis (preferred over ceftriaxone; does not displace bilirubin from albumin), pediatric bacterial meningitis, spontaneous bacterial peritonitis (SBP), pneumonia, gonorrhea.",
            doses = "Adult: 1 to 2 g IV q8h (up to 2 g IV q4-6h in severe meningitis; max 12 g/day).\nNeonates (0-28 days): 50 mg/kg/dose IV q8-12h.\nInfants & Children: 100-200 mg/kg/day IV divided q6-8h.",
            administration = "Slow IV bolus over 3-5 minutes or IV infusion in 50-100 mL NS/D5W over 20-30 minutes.",
            timing = "Every 6 to 8 hours.",
            specialInstructions = "PREFERRED CEPHALOSPORIN IN NEONATES: Unlike Ceftriaxone, Cefotaxime does NOT displace bilirubin from albumin (zero kernicterus risk) and does NOT precipitate with intravenous calcium.",
            pkPd = "Rapidly and widely distributed into tissues and CSF (inflamed meninges). Metabolized in liver to active metabolite desacetylcefotaxime (acts synergistically with parent drug). Half-life ~1-1.5 hours.",
            renalAdj = "CrCl <= 20 mL/min: Reduce dose by 50% (give standard dose q12h). Hemodialysis: Supplemental dose post-dialysis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe throughout pregnancy).",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding.",
            sideEffects = "Phlebitis, diarrhea, rash, eosinophilia, elevated transaminases, positive Coombs test.",
            priceNpr = "NPR 55.00 - 120.00 per 1 g vial",
            priceInr = "INR 35.00 - 80.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Taxim", "Alkem Laboratories Nepal", "Inj", "250 mg / 500 mg / 1 g"),
                BrandInfo("Claforan", "Sanofi Nepal / Medisales", "Inj", "500 mg / 1 g"),
                BrandInfo("Omnatax", "Abbott Nepal", "Inj", "1 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Taxim", "Alkem", "Inj", "250 / 500 mg / 1 g"),
                BrandInfo("Claforan", "Sanofi", "Inj", "1 g")
            ),
            pediatricDosePerKg = 150.0,
            pediatricInterval = "mg/kg/day IV divided q6-8h (meningitis: 200-300 mg/kg/day)",
            adultDose = "1-2 g IV q8h (meningitis: 2 g IV q4-6h).",
            childDose = "100-200 mg/kg/day IV divided q6-8h; Neonates: 50 mg/kg/dose q8-12h.",
            contraindications = "Severe immediate hypersensitivity to cephalosporins or beta-lactam antibiotics.",
            modeOfAction = "Binds to penicillin-binding proteins (PBPs), inhibiting the final transpeptidation step of peptidoglycan synthesis in bacterial cell walls, causing cell wall lysis and death.",
            therapeuticClassTag = "Cephalosporins / Neonatal Sepsis"
        ),

        Drug(
            id = "d_anti2_cefepime",
            genericName = "Cefepime Hydrochloride",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Fourth-Generation Broad-Spectrum Cephalosporin",
            blackBoxWarning = "NEUROTOXICITY IN RENAL IMPAIRMENT: Can cause life-threatening encephalopathy, myoclonus, seizures, and nonconvulsive status epilepticus if doses are not adjusted in renal failure.",
            indications = "Empiric monotherapy for Febrile Neutropenia, hospital-acquired and ventilator-associated pneumonia (HAP/VAP), complicated intra-abdominal infections (combined with metronidazole), severe complicated UTI/pyelonephritis.",
            doses = "Febrile Neutropenia: 2 g IV infusion over 30 min (or extended infusion over 3-4 hours) q8h. Moderate-to-Severe Pneumonia / UTI: 1 to 2 g IV q8-12h.",
            administration = "IV infusion in 100 mL NS or D5W over 30 minutes (or extended 3-hour infusion for critically ill patients).",
            timing = "Every 8 to 12 hours.",
            specialInstructions = "ZWITTERIONIC STRUCTURE: Zwitterion structure allows rapid penetration through Gram-negative bacterial outer membrane porins (OmpF/OmpC) and high stability against AmpC beta-lactamases and OXA enzymes.",
            pkPd = "Low protein binding (~20%). Excellent CSF and lung tissue penetration. Excreted >85% unchanged via kidneys. Half-life ~2 hours.",
            renalAdj = "CrCl 30-50 mL/min: 2 g IV q12h. CrCl 11-29 mL/min: 2 g IV q24h. CrCl <11 mL/min: 1 g IV q24h. Hemodialysis: 1 g post-dialysis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe when indicated).",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding.",
            sideEffects = "Phlebitis, diarrhea, rash, positive Coombs test, neurotoxicity (confusion, hallucinations, myoclonus, seizures in unadjusted renal impairment).",
            priceNpr = "NPR 350.00 - 650.00 per 1 g vial",
            priceInr = "INR 220.00 - 450.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Maxipime", "BMS / Medisales Nepal", "Inj", "500 mg / 1 g / 2 g"),
                BrandInfo("Kefpime", "Alkem Laboratories Nepal", "Inj", "1 g / 2 g"),
                BrandInfo("Novapime", "Cipla Nepal", "Inj", "1 g / 2 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Maxipime", "BMS India", "Inj", "1 / 2 g"),
                BrandInfo("Kefpime", "Alkem", "Inj", "1 g")
            ),
            adultDose = "2 g IV q8h (febrile neutropenia) or 1-2 g IV q12h.",
            childDose = "50 mg/kg IV q8h (max 2 g/dose).",
            contraindications = "Severe immediate hypersensitivity to cephalosporins, penicillins, or other beta-lactams.",
            modeOfAction = "Inhibits bacterial cell wall synthesis by binding to PBPs; zwitterionic structure confers enhanced resistance to AmpC chromosomal beta-lactamases and excellent activity against Pseudomonas aeruginosa and Enterobacteriaceae.",
            therapeuticClassTag = "Cephalosporins / 4th Generation"
        ),

        Drug(
            id = "d_anti2_colistin",
            genericName = "Colistin (Colistimethate Sodium / CMS)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Polymyxin Cyclic Polypeptide Antibiotic",
            blackBoxWarning = "NEPHROTOXICITY & NEUROTOXICITY: High incidence of acute kidney injury and dose-dependent neuromuscular blockade and respiratory paralysis. Monitor renal function closely.",
            indications = "Life-threatening infections caused by multidrug-resistant and carbapenem-resistant Gram-negative bacteria (CR-Acinetobacter baumannii, Carbapenem-Resistant Enterobacteriaceae / CRE, MDR-Pseudomonas aeruginosa).",
            doses = "IV Loading Dose: 9 million international units (MIU) or 300 mg Colistin Base Activity (CBA) infused over 1-2 hours. Maintenance: 4.5 MIU (150 mg CBA) IV q12h. Inhaled (VAP): 1-2 MIU nebulized BID.",
            administration = "IV infusion diluted in 100 mL Normal Saline infused over 1 hour. Never give rapid IV push.",
            timing = "Every 12 hours.",
            specialInstructions = "LAST-RESORT ANTIBIOTIC: Inactive prodrug CMS is slowly hydrolyzed in vivo to active colistin. Loading dose is mandatory to achieve therapeutic concentrations within the first 24 hours. Co-administer with a second active agent (meropenem or tigecycline).",
            pkPd = "CMS converted to colistin in vivo; wide inter-individual variability. Renal clearance dominates CMS; colistin is cleared non-renally. Half-life: CMS ~2-3 hours; active colistin ~9-14 hours.",
            renalAdj = "CrCl 50-80 mL/min: 3 MIU q8h. CrCl 30-49 mL/min: 2.5-3.5 MIU q12h. CrCl 10-29 mL/min: 2-3 MIU q24h. CrCl <10 mL/min: 2 MIU q48h. Hemodialysis: 2 MIU daily with 1 MIU booster post-dialysis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (Crosses placenta; use only if no alternative in life-threatening MDR sepsis).",
            lactation = "Excreted in low levels in breast milk; monitor infant.",
            sideEffects = "Nephrotoxicity (acute tubular necrosis, elevated creatinine in 30-50%), neurotoxicity (paresthesias, circumoral numbness, dizziness, ataxia, neuromuscular blockade/apnea).",
            priceNpr = "NPR 1,200.00 - 2,200.00 per vial (1 MIU / 3 MIU)",
            priceInr = "INR 800.00 - 1,500.00 per vial",
            brandsNepal = listOf(
                BrandInfo("Xylistin", "Cipla Nepal", "Inj", "1 MIU / 2 MIU / 3 MIU / 4.5 MIU"),
                BrandInfo("Coly-Mon", "Neon Laboratories Nepal", "Inj", "1 MIU / 2 MIU / 3 MIU")
            ),
            brandsIndia = listOf(
                BrandInfo("Xylistin", "Cipla", "Inj", "1 / 2 / 3 MIU"),
                BrandInfo("Coly-Mycin", "Pfizer", "Inj", "150 mg CBA")
            ),
            adultDose = "Loading 9 MIU IV, then 4.5 MIU IV q12h.",
            childDose = "75,000-150,000 IU/kg/day IV divided into 3 doses.",
            contraindications = "Known hypersensitivity to polymyxins.",
            modeOfAction = "Acts as a cationic detergent that binds to negatively charged lipopolysaccharide (LPS) and phospholipids in the outer membrane of Gram-negative bacteria, displacing Mg2+ and Ca2+, disrupting cell membrane integrity, causing cytoplasmic leakage and death.",
            therapeuticClassTag = "Polymyxins / Reserve"
        ),

        Drug(
            id = "d_anti2_fosfomycin",
            genericName = "Fosfomycin Trometamol (Oral)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Phosphonic Acid Derivative Bactericidal Antibiotic",
            blackBoxWarning = null,
            indications = "Acute uncomplicated lower urinary tract infection (acute cystitis) in females caused by susceptible Escherichia coli and Enterococcus faecalis.",
            doses = "Adult Female: 3 g sachet PO as a single one-time dose dissolved in water.",
            administration = "Empty entire contents of one 3 g sachet into 90-120 mL (half glass) of cold water; stir to dissolve and drink immediately on an empty stomach or at bedtime after emptying bladder.",
            timing = "Single dose at bedtime after emptying bladder.",
            specialInstructions = "HIGH URINARY CONCENTRATION: Very high concentrations (>2000 mcg/mL) maintained in urine for 24-48 hours after a single dose, well above the MIC of common uropathogens including ESBL-producing E. coli. Not indicated for pyelonephritis.",
            pkPd = "Oral bioavailability 35-40%. Does not bind to plasma proteins. Excreted unchanged in urine via glomerular filtration (high urinary levels for 48 hours). Elimination half-life ~4-5 hours.",
            renalAdj = "No adjustment needed for single-dose acute cystitis. CrCl <10 mL/min: Not recommended.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Safe in pregnancy; first-line single-dose agent for asymptomatic bacteriuria and acute cystitis).",
            lactation = "Excreted in low levels in breast milk; compatible with breastfeeding.",
            sideEffects = "Diarrhea (most common, mild and self-limiting), nausea, headache, dizziness, vaginitis, dyspepsia.",
            priceNpr = "NPR 350.00 - 650.00 per single 3 g sachet",
            priceInr = "INR 220.00 - 450.00 per sachet",
            brandsNepal = listOf(
                BrandInfo("Monurol", "Pierre Fabre / Medisales Nepal", "Sachet", "3 g"),
                BrandInfo("Fosirol", "Cipla Nepal", "Sachet", "3 g"),
                BrandInfo("Fosfocil", "Sun Pharma Nepal", "Sachet", "3 g")
            ),
            brandsIndia = listOf(
                BrandInfo("Monurol", "Pierre Fabre", "Sachet", "3 g"),
                BrandInfo("Fosirol", "Cipla", "Sachet", "3 g")
            ),
            adultDose = "3 g PO single dose dissolved in cold water at bedtime.",
            childDose = "Children >= 12 yr: 3 g PO single dose.",
            contraindications = "Known hypersensitivity to fosfomycin; severe renal impairment (CrCl <10 mL/min).",
            modeOfAction = "Inactivates the bacterial enzyme phosphoenolpyruvate synthetase (MurA), blocking the first committed step in bacterial peptidoglycan cell wall biosynthesis, with no cross-resistance to other antibiotic classes.",
            therapeuticClassTag = "UTI Antimicrobials"
        ),

        Drug(
            id = "d_anti2_amphotericin_liposomal",
            genericName = "Amphotericin B (Liposomal Formulation - L-AmB)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Liposomal Polyene Antifungal Agent",
            blackBoxWarning = "MEDICATION ERRORS & HOSPITAL VERIFICATION: Verify drug name and dosage carefully. Liposomal Amphotericin B doses (3-5 mg/kg) are much higher than conventional Amphotericin B deoxycholate (0.7-1 mg/kg); substituting formulations can result in fatal overdose.",
            indications = "Invasive Mucormycosis (Zygomycosis - first-line drug of choice), Visceral Leishmaniasis (Kala-Azar - single high-dose cure), Cryptococcal Meningitis (induction phase with flucytosine), invasive Aspergillosis, severe systemic Candidiasis.",
            doses = "Mucormycosis: 5 to 10 mg/kg IV daily infusion in D5W. Visceral Leishmaniasis (Kala-Azar): 10 mg/kg IV as a single infusion (or 3-5 mg/kg daily for 3-5 days). Cryptococcal Meningitis: 3-5 mg/kg IV daily.",
            administration = "Infuse ONLY in 5% Dextrose in Water (D5W) using an in-line 0.22-micron filter over 2 hours. Precipitates immediately if mixed with saline or electrolyte solutions. Pre-hydrate with 500-1000 mL Normal Saline to reduce nephrotoxicity.",
            timing = "Once daily slow IV infusion.",
            specialInstructions = "SIGNIFICANTLY LOWER NEPHROTOXICITY: Liposomal encapsulation delivers drug directly to fungal ergosterol membranes while shielding mammalian renal tubular cholesterol, allowing 5-10x higher dosing with far lower nephrotoxicity than conventional deoxycholate.",
            pkPd = "Extensively distributed to liver, spleen, and lungs. Low CSF penetration, but achieves high clinical efficacy in cryptococcal meningitis. Elimination half-life 100-153 hours.",
            renalAdj = "No formal dose reduction needed; if renal function deteriorates, maintain dose if life-threatening mucormycosis.",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category B (Antifungal of choice for life-threatening systemic fungal infections in pregnancy).",
            lactation = "Safety in breastfeeding not established; monitor infant.",
            sideEffects = "Hypokalemia, hypomagnesemia, elevated creatinine (nephrotoxicity), infusion-related reactions (fever, chills, rigors), nausea, anemia.",
            priceNpr = "NPR 4,500.00 - 8,500.00 per 50 mg vial",
            priceInr = "INR 3,000.00 - 6,000.00 per vial",
            brandsNepal = listOf(
                BrandInfo("AmBisome", "Gilead / Medisales Nepal", "Inj", "50 mg vial"),
                BrandInfo("Amphotret", "Bharat Serums Nepal", "Inj", "50 mg"),
                BrandInfo("Phosome", "Cipla Nepal", "Inj", "50 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("AmBisome", "Gilead", "Inj", "50 mg"),
                BrandInfo("Phosome", "Cipla", "Inj", "50 mg")
            ),
            adultDose = "3-5 mg/kg/day IV (up to 10 mg/kg/day for mucormycosis).",
            childDose = "3-5 mg/kg/day IV infusion in D5W.",
            contraindications = "Severe hypersensitivity to amphotericin B or liposomal components.",
            modeOfAction = "Binds irreversibly to ergosterol in fungal cell membranes, forming transmembrane ion channels and aqueous pores that cause rapid leakage of intracellular potassium, magnesium, and essential metabolites, resulting in fungal cell death.",
            therapeuticClassTag = "Antifungals / Polyenes"
        ),

        Drug(
            id = "d_anti2_chloroquine",
            genericName = "Chloroquine Phosphate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "4-Aminoquinoline Antimalarial & Amoebicide",
            blackBoxWarning = null,
            indications = "Treatment of uncomplicated chloroquine-sensitive Plasmodium vivax, P. malariae, and P. ovale malaria; extraintestinal amoebiasis (amoebic liver abscess after metronidazole failure).",
            doses = "Acute Malaria: Initial dose 600 mg base (1000 mg phosphate) PO stat, then 300 mg base at 6 hours, then 300 mg base once daily on Day 2 and Day 3 (total 1500 mg base over 3 days). Hepatic Amoebiasis: 600 mg base daily x 2 days, then 300 mg base daily x 2-3 weeks.",
            administration = "Take orally with food or milk to minimize nausea and vomiting.",
            timing = "Day 1 (0h and 6h), Day 2 (24h), Day 3 (48h).",
            specialInstructions = "Always co-prescribe Primaquine (0.25-0.5 mg/kg/day x 14 days) after chloroquine to eradicate dormant liver hypnozoites and achieve radical cure of P. vivax.",
            pkPd = "Rapid and near-complete oral absorption. Huge volume of distribution (binds heavily to tissues, liver, spleen, eyes). Half-life 1-2 months.",
            renalAdj = "CrCl 10-50 mL/min: Reduce dose by 50%. CrCl <10 mL/min: Reduce dose by 50-75%.",
            hepaticAdj = "Use with caution in severe hepatic disease.",
            pregnancy = "Category C (CDC considers safe for chloroquine-sensitive malaria in pregnancy).",
            lactation = "Excreted in breast milk; compatible, but inadequate for infant malaria prophylaxis.",
            sideEffects = "Pruritus (severe in dark-skinned individuals), nausea, vomiting, headache, dizziness, visual blurring, QTc prolongation, irreversible retinal toxicity (long-term use).",
            priceNpr = "NPR 20.00 - 45.00 per strip of 10 (250mg phosphate / 150mg base)",
            priceInr = "INR 12.00 - 30.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Lariago", "IPCA Laboratories Nepal", "Tab / Inj / Syr", "250 mg / 64.5mg/mL Inj / 50mg/5mL"),
                BrandInfo("Nivaquine", "Sanofi Nepal", "Tab", "250 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Lariago", "IPCA", "Tab / Inj / Syr", "250 mg / 64.5mg/mL"),
                BrandInfo("Resochin", "Bayer", "Tab", "250 mg")
            ),
            pediatricDosePerKg = 10.0,
            pediatricInterval = "mg base/kg stat, then 5 mg/kg at 6h, 24h, 48h",
            adultDose = "600 mg base stat, 300 mg at 6h, 24h, 48h.",
            childDose = "10 mg base/kg stat, then 5 mg/kg at 6h, 24h, 48h.",
            contraindications = "Pre-existing retinal disease or visual field changes, known hypersensitivity to 4-aminoquinolines, myasthenia gravis, concurrent use with amiodarone.",
            modeOfAction = "Concentrates in the acidic food vacuole of intra-erythrocytic Plasmodium parasites, inhibiting the polymerization of toxic free heme into inert hemozoin, causing toxic heme buildup and parasite lysis.",
            therapeuticClassTag = "Antimalarials"
        ),

        Drug(
            id = "d_anti2_primaquine",
            genericName = "Primaquine Phosphate",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "8-Aminoquinoline Radical Cure Antimalarial",
            blackBoxWarning = "HEMOLYTIC ANEMIA IN G6PD DEFICIENCY: Can cause life-threatening intravascular hemolysis in patients with glucose-6-phosphate dehydrogenase (G6PD) deficiency. Screen for G6PD deficiency prior to initiating therapy.",
            indications = "Radical cure (anti-relapse therapy) of Plasmodium vivax and Plasmodium ovale malaria (eradication of hypnozoites), gametocytocidal therapy for P. falciparum to interrupt transmission.",
            doses = "Radical Cure (P. vivax): 0.25 to 0.5 mg/kg/day PO (usual adult dose 15-30 mg base once daily) for 14 consecutive days taken with food. P. falciparum Gametocytocidal: 0.25 mg base/kg single dose on Day 1.",
            administration = "Take orally once daily with food or milk to minimize gastrointestinal cramps.",
            timing = "Once daily with meals for 14 days.",
            specialInstructions = "MANDATORY G6PD SCREENING: Test for G6PD deficiency before prescribing 14-day regimen. If patient has mild-to-moderate G6PD deficiency, WHO recommends an alternative regimen of 0.75 mg base/kg once weekly for 8 weeks under close medical supervision.",
            pkPd = "Rapid and complete absorption. Rapidly metabolized in liver to carboxyprimaquine. Elimination half-life 4-7 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Use with caution in hepatic dysfunction.",
            pregnancy = "Category X (STRICTLY CONTRAINDICATED in pregnancy; fetus is G6PD-untested and at risk of fatal intrauterine intravascular hemolysis).",
            lactation = "Contraindicated unless infant is confirmed G6PD-normal.",
            sideEffects = "Acute hemolytic anemia (in G6PD deficiency), methemoglobinemia (cyanosis), abdominal cramps, nausea, vomiting, headache.",
            priceNpr = "NPR 35.00 - 75.00 per strip of 14 (7.5mg / 15mg base)",
            priceInr = "INR 22.00 - 50.00 per strip of 14",
            brandsNepal = listOf(
                BrandInfo("Primaquine", "IPCA Laboratories Nepal", "Tab", "7.5 mg / 15 mg base"),
                BrandInfo("Malirid", "IPCA Laboratories", "Tab", "7.5 mg / 15 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Malirid", "IPCA", "Tab", "7.5 / 15 mg"),
                BrandInfo("Primacip", "Cipla", "Tab", "15 mg")
            ),
            pediatricDosePerKg = 0.5,
            pediatricInterval = "mg base/kg/day PO x 14 days (G6PD-normal)",
            adultDose = "15-30 mg base PO once daily with food x 14 days.",
            childDose = "0.25-0.5 mg base/kg/day PO x 14 days (after G6PD test).",
            contraindications = "G6PD deficiency, pregnancy, infants <6 months of age, concurrent use with bone marrow depressants or quinacrine.",
            modeOfAction = "Generates reactive oxygen species and disrupts electron transport in the parasite mitochondria, destroying intra-hepatic exo-erythrocytic hypnozoites and sexual gametocytes.",
            therapeuticClassTag = "Antimalarials / Radical Cure"
        ),

        Drug(
            id = "d_anti2_diethylcarbamazine",
            genericName = "Diethylcarbamazine Citrate (DEC)",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Piperazine Derivative Antifilarial Agent",
            blackBoxWarning = "SEVERE MAZZOTTI REACTION IN ONCHOCERCIASIS: In patients with Onchocerca volvulus (river blindness), causes severe, life-threatening inflammatory reactions (Mazzotti reaction) and permanent blindness. Contraindicated in onchocerciasis.",
            indications = "Lymphatic Filariasis (Wuchereria bancrofti, Brugia malayi - endemic in plains/Terai of Nepal), Tropical Pulmonary Eosinophilia (TPE), Loiasis (Loa loa).",
            doses = "Lymphatic Filariasis (Treatment): 6 mg/kg/day PO divided TID with meals for 12 consecutive days (often combined with Albendazole 400 mg single dose). Tropical Pulmonary Eosinophilia: 6 mg/kg/day PO divided TID for 14-21 days.",
            administration = "Take orally with or immediately after meals.",
            timing = "Three times daily after meals for 12-21 days.",
            specialInstructions = "MASS DRUG ADMINISTRATION (MDA) in Nepal: Annual single-dose triple-drug therapy (IDA: Ivermectin 200 mcg/kg + DEC 6 mg/kg + Albendazole 400 mg) for elimination of lymphatic filariasis.",
            pkPd = "Rapid and near-complete oral absorption. Widely distributed to tissues. 50% excreted unchanged in urine. Elimination half-life 6-12 hours.",
            renalAdj = "CrCl <50 mL/min: Reduce dose by 50% (excreted via kidneys).",
            hepaticAdj = "No adjustment needed.",
            pregnancy = "Category C (WHO recommends deferring treatment until after delivery in endemic MDA campaigns).",
            lactation = "Excreted in breast milk; compatible with breastfeeding in therapeutic treatment.",
            sideEffects = "Mazzotti-type allergic reaction (fever, headache, pruritus, localized lymphangitis, urticaria, facial edema due to rapid microfilarial destruction), anorexia, nausea, dizziness.",
            priceNpr = "NPR 25.00 - 55.00 per strip of 10 (50mg / 100mg)",
            priceInr = "INR 15.00 - 35.00 per strip of 10",
            brandsNepal = listOf(
                BrandInfo("Hetrazan", "Pfizer Nepal", "Tab", "50 mg / 100 mg"),
                BrandInfo("Banocide Forte", "GSK Nepal", "Tab / Syr", "100 mg / 120mg/5mL"),
                BrandInfo("Filazine", "Nepal Pharmaceuticals Lab", "Tab", "100 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Hetrazan", "Pfizer India", "Tab", "50 / 100 mg"),
                BrandInfo("Banocide Forte", "GSK", "Tab / Syr", "100 mg / 120mg/5mL")
            ),
            pediatricDosePerKg = 6.0,
            pediatricInterval = "mg/kg/day PO divided TID x 12-21 days",
            adultDose = "6 mg/kg/day PO divided TID x 12 days (Filariasis) or x 21 days (TPE).",
            childDose = "6 mg/kg/day PO divided TID x 12-21 days.",
            contraindications = "Onchocerca volvulus co-infection, hypersensitivity to diethylcarbamazine.",
            modeOfAction = "Immobilizes microfilariae and alters their surface membrane structure, exposing them to host phagocytosis by granulocytes and macrophages; also kills adult filarial worms.",
            therapeuticClassTag = "Antiparasitics / Filariasis"
        ),

        Drug(
            id = "d_anti2_praziquantel",
            genericName = "Praziquantel",
            system = "Anti-Infectives & Antimicrobials",
            drugClass = "Pyrazinoisoquinoline Broad-Spectrum Anthelmintic",
            blackBoxWarning = "OCULAR CYSTICERCOSIS CONTRAINDICATION: Examination to rule out intraocular cysticercosis is mandatory before treating neurocysticercosis (parasite destruction within the eye causes irreversible retinal blindness).",
            indications = "Neurocysticercosis (Taenia solium larval infection in brain parenchymal cysts), intestinal tapeworm infections (Taenia saginata, T. solium, Diphyllobothrium latum, Hymenolepis nana), Schistosomiasis, liver fluke infections (Clonorchis, Opisthorchis).",
            doses = "Neurocysticercosis: 50 mg/kg/day PO divided into 3 doses (every 8 hours) with meals for 10 to 14 days (co-administered with Dexamethasone and Albendazole). Intestinal Taeniasis: 5-10 mg/kg PO as a single dose.",
            administration = "Swallow tablets whole with water during meals. Tablets have an extremely bitter taste; do not chew.",
            timing = "Every 8 hours with meals.",
            specialInstructions = "CO-ADMINISTER CORTICOSTEROIDS: In neurocysticercosis, parasite death releases foreign antigens triggering intense brain inflammation, intracranial hypertension, and seizures. Pre-treat and co-administer with Dexamethasone (0.1 mg/kg/day) and an antiepileptic.",
            pkPd = "Rapid oral absorption (~80%). Extensive first-pass hepatic metabolism by CYP3A4. Metabolites excreted primarily in urine. Half-life 1-1.5 hours.",
            renalAdj = "No adjustment needed.",
            hepaticAdj = "Severe hepatic impairment or schistosomiasis with hepatosplenomegaly: Metabolism reduced; use caution.",
            pregnancy = "Category B (Safe when indicated; WHO recommends treatment of schistosomiasis in pregnant women).",
            lactation = "Excreted in breast milk; women should avoid nursing on day of treatment and for 72 hours thereafter.",
            sideEffects = "Headache, dizziness, drowsiness, nausea, abdominal pain, fever, urticaria, seizures (inflammatory response to dying cysticerci in brain).",
            priceNpr = "NPR 180.00 - 350.00 per strip of 4 tablets (600mg)",
            priceInr = "INR 120.00 - 240.00 per strip of 4",
            brandsNepal = listOf(
                BrandInfo("Distocide", "Shin Poong / Medisales Nepal", "Tab", "600 mg"),
                BrandInfo("Biltricide", "Bayer Nepal", "Tab", "600 mg"),
                BrandInfo("Cysticide", "Merck Nepal", "Tab", "500 mg")
            ),
            brandsIndia = listOf(
                BrandInfo("Biltricide", "Bayer", "Tab", "600 mg"),
                BrandInfo("Distocide", "Chandra Bhagat Pharma", "Tab", "600 mg")
            ),
            pediatricDosePerKg = 50.0,
            pediatricInterval = "mg/kg/day PO divided TID with meals x 10-14 days",
            adultDose = "50 mg/kg/day PO divided TID x 10-14 days for neurocysticercosis; 10 mg/kg stat for tapeworms.",
            childDose = "Children >= 2 yr: 50 mg/kg/day PO divided TID x 10-14 days.",
            contraindications = "Ocular cysticercosis, spinal cysticercosis, concurrent use with potent CYP3A4 inducers (rifampin).",
            modeOfAction = "Increases cell membrane permeability to calcium ions in susceptible schistosomes and cestodes, causing rapid calcium influx, massive spastic muscular contraction, tegumental vacuolization, paralysis, and host immune destruction.",
            therapeuticClassTag = "Antiparasitics / Anthelmintics"
        )
    )
}
