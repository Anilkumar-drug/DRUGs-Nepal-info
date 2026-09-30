package com.example.data.repository

import com.example.data.model.AwareClassification
import com.example.data.model.LocalResistancePattern
import com.example.data.model.SyndromicRegimen
import com.example.data.model.WhoAwareDrug

object AntimicrobialStewardshipData {

    val syndromicRegimens: List<SyndromicRegimen> = listOf(
        SyndromicRegimen(
            id = "syn_cap_out",
            syndrome = "Community-Acquired Pneumonia (CAP) - Outpatient",
            category = "Respiratory",
            setting = "Outpatient (CURB-65 = 0-1)",
            preferredFirstLine = "Amoxicillin 1 g PO TID x 5 days (High dose overcomes PRSP). If atypical suspected: add Azithromycin 500 mg Day 1, then 250 mg daily x 4 days.",
            alternativeRegimen = "Doxycycline 100 mg PO BID x 5-7 days OR Amoxicillin-Clavulanate 875/125 mg PO BID + Azithromycin.",
            typicalDuration = "5 days (Extend if afebrile for <48h or clinically unstable)",
            commonPathogens = "Streptococcus pneumoniae, Mycoplasma pneumoniae, Haemophilus influenzae, Chlamydia pneumoniae",
            clinicalPearls = "Routine chest X-ray infiltrate clears slower than clinical symptoms (takes 4-8 weeks). Do NOT prolong antibiotic course purely based on residual radiological opacity.",
            redFlags = "Respiratory rate ≥30/min, SpO2 <90%, Confusion, Systolic BP <90 mmHg -> Immediate admission.",
            nepalSpecificNotes = "Amoxicillin is freely available at all Government Health Posts & Primary Health Centers under NEML."
        ),
        SyndromicRegimen(
            id = "syn_cap_ward",
            syndrome = "Community-Acquired Pneumonia (CAP) - Inpatient Ward",
            category = "Respiratory",
            setting = "Inpatient Ward (CURB-65 ≥ 2)",
            preferredFirstLine = "Ceftriaxone 1-2 g IV OD + Azithromycin 500 mg PO/IV OD x 5-7 days.",
            alternativeRegimen = "Levofloxacin 750 mg IV/PO OD monotherapy (or Moxifloxacin 400 mg OD).",
            typicalDuration = "5 to 7 days",
            commonPathogens = "S. pneumoniae, Legionella pneumophila, H. influenzae, enteric Gram-negative bacilli",
            clinicalPearls = "Switch from IV Ceftriaxone to oral Cefpodoxime or Amoxicillin-Clavulanate once patient is afebrile for 24 hours, tolerating oral diet, and hemodynamically stable.",
            redFlags = "Requirement for vasopressors or invasive mechanical ventilation -> Transfer to ICU immediately."
        ),
        SyndromicRegimen(
            id = "syn_hap_vap",
            syndrome = "Hospital-Acquired (HAP) & Ventilator-Associated Pneumonia (VAP)",
            category = "Respiratory",
            setting = "ICU / Inpatient (>48 hours post-admission)",
            preferredFirstLine = "Piperacillin-Tazobactam 4.5 g IV q6h (extended 4-hour infusion) OR Cefepime 2 g IV q8h + Vancomycin 15-20 mg/kg IV q8-12h (or Linezolid 600 mg IV q12h).",
            alternativeRegimen = "Meropenem 1 g IV q8h (if high ESBL/Acinetobacter risk) + Colistin if Carbapenem-resistant.",
            typicalDuration = "7 days (Procalcitonin-guided de-escalation strongly advised)",
            commonPathogens = "Pseudomonas aeruginosa, Klebsiella pneumoniae (ESBL/CRE), Acinetobacter baumannii, MRSA",
            clinicalPearls = "Obtain endotracheal aspirate or sputum culture BEFORE initiating or switching broad-spectrum coverage. De-escalate promptly based on sensitivities.",
            redFlags = "Deteriorating PaO2/FiO2 ratio, refractory shock, oliguria."
        ),
        SyndromicRegimen(
            id = "syn_meningitis",
            syndrome = "Acute Bacterial Meningitis (Adult)",
            category = "CNS",
            setting = "Emergency / ICU Admission",
            preferredFirstLine = "Ceftriaxone 2 g IV q12h + Vancomycin 15-20 mg/kg IV q8-12h + Dexamethasone 10 mg IV (give 15-20 min BEFORE or with 1st dose, q6h x 4 days).",
            alternativeRegimen = "Add Ampicillin 2 g IV q4h if age >50 years or immunocompromised (covers Listeria monocytogenes). Chloramphenicol 1 g IV q6h if severe penicillin allergy.",
            typicalDuration = "S. pneumoniae: 10-14 days; N. meningitidis: 7 days; Listeria: 21 days",
            commonPathogens = "Streptococcus pneumoniae, Neisseria meningitidis, Listeria monocytogenes, Haemophilus influenzae",
            clinicalPearls = "Never delay antibiotic administration for Lumbar Puncture or CT brain if intracranial mass/herniation is suspected. Take blood cultures and give antibiotics immediately.",
            redFlags = "GCS <10, unequal pupils, new onset focal neurological deficits, Cushing's triad (bradycardia, hypertension, irregular breathing)."
        ),
        SyndromicRegimen(
            id = "syn_scrub_typhus",
            syndrome = "Scrub Typhus & Leptospirosis (Acute Undifferentiated Febrile Illness)",
            category = "Tropical / Vector-Borne",
            setting = "Primary & Secondary Hospitals in Nepal",
            preferredFirstLine = "Doxycycline 100 mg PO/IV BID x 7 days (Drug of Choice). Rapid defervescence within 24-48 hours confirms clinical diagnosis.",
            alternativeRegimen = "Azithromycin 500 mg PO OD x 5 days (Preferred in pregnancy, lactating mothers, and children <8 years).",
            typicalDuration = "5 to 7 days",
            commonPathogens = "Orientia tsutsugamushi (trombiculid mite chigger vector), Leptospira interrogans",
            clinicalPearls = "Look thoroughly for the pathognomonic painless 'cigarette-burn' necrotic ESCHAR in warm flexural skin folds (groin, axilla, perineum, sub-mammary).",
            redFlags = "ARDS, Acute Kidney Injury (creatinine surge), thrombocytopenia <50k, altered sensorium (scrub encephalitis).",
            nepalSpecificNotes = "High seasonal surge post-monsoon (July to November) across Terai, inner Terai, and Kathmandu Valley."
        ),
        SyndromicRegimen(
            id = "syn_enteric_fever",
            syndrome = "Enteric Fever (Typhoid & Paratyphoid Fever)",
            category = "Gastrointestinal",
            setting = "Outpatient or Inpatient",
            preferredFirstLine = "Uncomplicated / Outpatient: Azithromycin 1 g PO Day 1, then 500 mg PO OD x 6 days OR Cefixime 200 mg PO BID x 10-14 days. Severe / Inpatient: Ceftriaxone 2 g IV OD x 10-14 days.",
            alternativeRegimen = "Meropenem 1 g IV q8h (if extensively drug-resistant XDR strain suspected).",
            typicalDuration = "10 to 14 days",
            commonPathogens = "Salmonella enterica serovar Typhi, Salmonella Paratyphi A",
            clinicalPearls = "Fluoroquinolones (Ciprofloxacin/Ofloxacin) now have >80% non-susceptibility/treatment failure in Nepal and South Asia; avoid as empiric first-line despite older textbook listings.",
            redFlags = "Sudden severe abdominal pain with guarding/rigidity (ileal perforation), melena/hematochezia, typhoid encephalopathy."
        ),
        SyndromicRegimen(
            id = "syn_pyelonephritis",
            syndrome = "Complicated UTI & Acute Pyelonephritis / Urosepsis",
            category = "Genitourinary",
            setting = "Emergency / Inpatient",
            preferredFirstLine = "Ceftriaxone 1 g IV OD (or Amikacin 15 mg/kg IV OD if high ESBL risk) x 10-14 days. Oral stepdown: Cefpodoxime 200 mg BID or Ciprofloxacin (only if culture confirmed sensitive).",
            alternativeRegimen = "Piperacillin-Tazobactam 4.5 g IV q8h or Meropenem 1 g IV q8h for uroseptic shock.",
            typicalDuration = "7 to 14 days",
            commonPathogens = "Escherichia coli, Klebsiella pneumoniae, Proteus mirabilis, Enterococcus faecalis",
            clinicalPearls = "Nitrofurantoin and Fosfomycin are STRICTLY for uncomplicated lower cystitis; they do NOT achieve therapeutic renal parenchymal concentrations and MUST NOT be used for pyelonephritis.",
            redFlags = "Septic shock, costovertebral angle exquisite tenderness with rigors, persistent fever >72 hours on appropriate antibiotics (check ultrasound for renal abscess/calculus obstruction)."
        ),
        SyndromicRegimen(
            id = "syn_sepsis_bundle",
            syndrome = "Sepsis & Septic Shock (Surviving Sepsis Campaign 1-Hour Bundle)",
            category = "Sepsis & Critical Care",
            setting = "Emergency & ICU",
            preferredFirstLine = "1. Measure blood lactate level immediately.\n2. Obtain 2 sets of blood cultures BEFORE starting antibiotics.\n3. Administer broad-spectrum empiric IV antimicrobials within 1 hour: Piperacillin-Tazobactam 4.5g IV + Vancomycin 15-20 mg/kg IV.\n4. Rapid infusion of 30 mL/kg crystalloid (Normal Saline or Plasmalyte) for hypotension or lactate ≥4 mmol/L.\n5. Apply vasopressors (Norepinephrine first-line) during or after fluid resuscitation to maintain MAP ≥65 mmHg.",
            alternativeRegimen = "Meropenem 1 g IV + Vancomycin 15-20 mg/kg IV (if history of ESBL colonization or previous ICU stay).",
            typicalDuration = "De-escalate within 48-72 hours once culture results return; total 7 days.",
            commonPathogens = "Broad spectrum: Gram-negative bacilli, Staphylococcus aureus, Streptococcus, anaerobes",
            clinicalPearls = "Every 1 hour delay in initiating effective antimicrobial therapy in septic shock increases mortality by approximately 7.6%.",
            redFlags = "Serum lactate >4 mmol/L, refractory hypotension requiring increasing Norepinephrine (>0.25 mcg/kg/min), anuria."
        ),
        SyndromicRegimen(
            id = "syn_ssti_necrotizing",
            syndrome = "Skin & Soft Tissue Infections (Cellulitis to Necrotizing Fasciitis)",
            category = "SSTI",
            setting = "Emergency / Inpatient",
            preferredFirstLine = "Non-purulent Cellulitis: Cloxacillin 500 mg PO QID x 5-7 days OR Cefazolin 1-2 g IV q8h. Necrotizing Fasciitis: Meropenem 1 g IV q8h + Vancomycin 15-20 mg/kg IV q12h + Clindamycin 900 mg IV q8h (Clindamycin suppresses bacterial toxin synthesis via ribosome inhibition).",
            alternativeRegimen = "Vancomycin + Piperacillin-Tazobactam + Clindamycin.",
            typicalDuration = "Cellulitis: 5-7 days; Necrotizing: Until surgical control + 7-14 days.",
            commonPathogens = "Streptococcus pyogenes (Group A Strep), Staphylococcus aureus (MSSA/MRSA), mixed anaerobes",
            clinicalPearls = "In necrotizing fasciitis, antibiotics are secondary to IMMEDIATE radical surgical debridement. Pain out of proportion to physical exam findings is the earliest hallmark.",
            redFlags = "Crepitus, skin anesthesia, bullae with dishwater fluid, rapid margin progression, systemic toxicity."
        )
    )

    val whoAwareDrugs: List<WhoAwareDrug> = listOf(
        WhoAwareDrug(
            genericName = "Amoxicillin",
            classification = AwareClassification.ACCESS,
            keyIndications = "First-line for outpatient CAP, acute otitis media, bacterial sinusitis, dental infections",
            stewardshipGuidance = "Widely available, narrow-spectrum relative to cephalosporins. Minimal collateral damage to gut microbiome.",
            commonDosage = "500 mg to 1 g PO TID"
        ),
        WhoAwareDrug(
            genericName = "Amoxicillin + Clavulanate",
            classification = AwareClassification.ACCESS,
            keyIndications = "Bite wounds, refractory otitis media, aspiration pneumonia, diabetic foot infections",
            stewardshipGuidance = "Contains clavulanic acid to inhibit beta-lactamases; preserves amoxicillin efficacy against Moraxella and H. influenzae.",
            commonDosage = "625 mg to 1 g PO BID or 1.2 g IV q8h"
        ),
        WhoAwareDrug(
            genericName = "Doxycycline",
            classification = AwareClassification.ACCESS,
            keyIndications = "Scrub typhus, leptospirosis, atypical pneumonia, cholera, acne vulgaris, malaria prophylaxis",
            stewardshipGuidance = "Excellent oral bioavailability (>95%). No renal dose adjustment required. Highly valuable empirical choice in Nepal.",
            commonDosage = "100 mg PO BID"
        ),
        WhoAwareDrug(
            genericName = "Cloxacillin",
            classification = AwareClassification.ACCESS,
            keyIndications = "MSSA skin and soft tissue infections, osteomyelitis, staphylococcal septic arthritis",
            stewardshipGuidance = "Penicillinase-resistant penicillin. High hepatic metabolism; take on empty stomach 1 hour before meals.",
            commonDosage = "500 mg PO QID or 1-2 g IV q6h"
        ),
        WhoAwareDrug(
            genericName = "Gentamicin",
            classification = AwareClassification.ACCESS,
            keyIndications = "Neonatal sepsis, severe Gram-negative bacteremia, enterococcal endocarditis synergy",
            stewardshipGuidance = "Use once-daily extended interval dosing (5-7 mg/kg) to maximize peak:MIC ratio and minimize renal cortical accumulation.",
            commonDosage = "5-7 mg/kg IV once daily (monitor trough <1 mcg/mL)"
        ),
        WhoAwareDrug(
            genericName = "Metronidazole",
            classification = AwareClassification.ACCESS,
            keyIndications = "Amoebiasis, giardiasis, trichomoniasis, intra-abdominal anaerobic infections, C. difficile (mild)",
            stewardshipGuidance = "Strict anaerobic bactericidal coverage. Disulfiram-like reaction with alcohol; instruct patient to abstain during and 48h after therapy.",
            commonDosage = "400-500 mg PO/IV TID"
        ),
        WhoAwareDrug(
            genericName = "Ceftriaxone",
            classification = AwareClassification.WATCH,
            keyIndications = "Severe CAP, acute bacterial meningitis, pyelonephritis, enteric fever, gonorrhea",
            stewardshipGuidance = "HIGH WATCH PRIORITY. Overuse drives ESBL (Extended-Spectrum Beta-Lactamase) emergence and Clostridioides difficile colitis. Restrict use to hospitalized or severe infections.",
            commonDosage = "1 to 2 g IV once daily (meningitis: 2 g q12h)"
        ),
        WhoAwareDrug(
            genericName = "Ciprofloxacin & Levofloxacin",
            classification = AwareClassification.WATCH,
            keyIndications = "Complicated UTI, infectious diarrhea with dysentery, bone and joint infections",
            stewardshipGuidance = "HIGH RESISTANCE CONCERN in South Asia. Black Box Warning: Tendonitis/tendon rupture, peripheral neuropathy, aortic aneurysm rupture. Never use for uncomplicated cystitis if access agents available.",
            commonDosage = "Cipro: 500 mg BID; Levo: 500-750 mg OD"
        ),
        WhoAwareDrug(
            genericName = "Azithromycin",
            classification = AwareClassification.WATCH,
            keyIndications = "Atypical pneumonia, enteric fever, scrub typhus in pregnancy, trachoma, genital chlamydia",
            stewardshipGuidance = "Long tissue half-life (68 hours). Restrict indiscriminate use for viral upper respiratory tract infections.",
            commonDosage = "500 mg OD x 3-5 days"
        ),
        WhoAwareDrug(
            genericName = "Piperacillin + Tazobactam",
            classification = AwareClassification.WATCH,
            keyIndications = "Hospital-acquired pneumonia, severe intra-abdominal sepsis, febrile neutropenia",
            stewardshipGuidance = "Broad spectrum antipseudomonal agent. Reserve for hospitalized patients with documented sepsis or Pseudomonas risk.",
            commonDosage = "4.5 g IV q6h or q8h (extended 4-hour infusion)"
        ),
        WhoAwareDrug(
            genericName = "Meropenem",
            classification = AwareClassification.WATCH,
            keyIndications = "Severe ESBL bacteremia, intra-abdominal perforation, febrile neutropenia with shock",
            stewardshipGuidance = "Watch antibiotic of high critical importance. Indiscriminate use is generating Carbapenem-Resistant Enterobacterales (CRE). Requires specialist approval in strict stewardship programs.",
            commonDosage = "1 g IV q8h (meningitis: 2 g q8h)"
        ),
        WhoAwareDrug(
            genericName = "Colistin (Polymyxin E)",
            classification = AwareClassification.RESERVE,
            keyIndications = "Confirmed Carbapenem-resistant (CRE) Klebsiella, Pseudomonas, or Acinetobacter bacteremia/VAP",
            stewardshipGuidance = "LAST RESORT ONLY. Significant nephrotoxicity and neurotoxicity. Must be saved for salvage therapy when no other antibiotic option exists.",
            commonDosage = "Loading: 9 million IU (300 mg CBA) IV over 1h, then 4.5 million IU q12h (adjusted for CrCl)"
        ),
        WhoAwareDrug(
            genericName = "Linezolid",
            classification = AwareClassification.RESERVE,
            keyIndications = "Vancomycin-resistant enterococci (VRE), MRSA pneumonia where vancomycin failed or cannot be used",
            stewardshipGuidance = "Oxazolidinone. Weak reversible MAO inhibitor (caution with SSRIs). Monitor weekly CBC for bone marrow suppression if course >14 days.",
            commonDosage = "600 mg PO/IV q12h"
        ),
        WhoAwareDrug(
            genericName = "Tigecycline",
            classification = AwareClassification.RESERVE,
            keyIndications = "Complicated intra-abdominal infections and SSTI caused by multidrug-resistant pathogens",
            stewardshipGuidance = "Glycylcycline. Does NOT achieve therapeutic levels in bloodstream or urine; do NOT use for bacteremia or UTI. Increased all-cause mortality warning.",
            commonDosage = "100 mg IV loading, then 50 mg IV q12h"
        )
    )

    val localResistancePatterns: List<LocalResistancePattern> = listOf(
        LocalResistancePattern(
            pathogen = "Escherichia coli & Klebsiella pneumoniae",
            resistanceProfile = "ESBL Producers (Extended-Spectrum Beta-Lactamase)",
            prevalenceEstimate = "45% - 70% in hospital urine and blood isolates in Nepal",
            effectiveAgents = "Meropenem, Amikacin, Nitrofurantoin (urine only), Fosfomycin (urine only), Colistin",
            discouragedAgents = "Ceftriaxone, Cefotaxime, Ciprofloxacin, Amoxicillin-Clavulanate (for severe systemic infections)",
            localGuidance = "For inpatient urosepsis with high ESBL suspicion, prefer Amikacin or Carbapenem over 3rd-generation cephalosporins. Step down to oral Nitrofurantoin once systemic signs resolve if organism is sensitive."
        ),
        LocalResistancePattern(
            pathogen = "Salmonella enterica serovar Typhi & Paratyphi",
            resistanceProfile = "Fluoroquinolone Non-Susceptibility & Azithromycin Tolerance",
            prevalenceEstimate = ">80% non-susceptible to Ciprofloxacin/Ofloxacin in Nepal",
            effectiveAgents = "Ceftriaxone IV, Azithromycin PO (high dose), Cefixime PO",
            discouragedAgents = "Ciprofloxacin, Ofloxacin, Nalidixic Acid",
            localGuidance = "Never prescribe oral Ciprofloxacin empirically for suspected typhoid in Nepal despite older clinical habits; treatment failure and protracted carrier state frequently result."
        ),
        LocalResistancePattern(
            pathogen = "Staphylococcus aureus",
            resistanceProfile = "MRSA (Methicillin-Resistant S. aureus)",
            prevalenceEstimate = "25% - 40% in tertiary hospital wound and blood cultures",
            effectiveAgents = "Vancomycin, Linezolid, Daptomycin, Cotrimoxazole (for community CA-MRSA), Doxycycline",
            discouragedAgents = "Cloxacillin, Cefazolin, Amoxicillin-Clavulanate",
            localGuidance = "Empiric Vancomycin or Linezolid indicated for ICU pneumonia, severe surgical site sepsis, or central line infections until blood culture clears."
        ),
        LocalResistancePattern(
            pathogen = "Acinetobacter baumannii & Pseudomonas aeruginosa",
            resistanceProfile = "MDR / Carbapenem-Resistant (CRAB / CRPA)",
            prevalenceEstimate = "35% - 60% in tertiary ICU ventilator-associated pneumonia",
            effectiveAgents = "Colistin, Polymyxin B, High-dose Sulbactam combinations, Ceftazidime-Avibactam",
            discouragedAgents = "Standard Carbapenems, Ceftriaxone, Piperacillin-Tazobactam (if carbapenem-resistant)",
            localGuidance = "Strict contact precautions and hand hygiene bundles are vital. Initiate salvage Colistin only after culture confirmation and infectious disease consultation."
        )
    )
}
