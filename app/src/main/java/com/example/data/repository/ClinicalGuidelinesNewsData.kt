package com.example.data.repository

import com.example.data.model.GroundingSource
import com.example.data.model.MedicalNewsItem

object ClinicalGuidelinesNewsData {

    val guidelines: List<MedicalNewsItem> = listOf(
        // 1. ESC 2023/2024 Heart Failure Guidelines (Specifically requested by user)
        MedicalNewsItem(
            id = "guideline_esc_hf_2024",
            title = "ESC Heart Failure Guidelines: SGLT2i Across All EF & The Four GDMT Pillars",
            category = "ESC (Cardiology)",
            date = "ESC Clinical Practice Guideline",
            source = "European Society of Cardiology (ESC)",
            summary = "The European Society of Cardiology updates recommendations for heart failure management, cementing SGLT2 inhibitors (Dapagliflozin 10mg or Empagliflozin 10mg) with a Class I, Level A recommendation across the entire spectrum of LVEF: HFrEF (<=40%), HFmrEF (41-49%), and HFpEF (>=50%). For HFrEF, the guideline mandates rapid upfront initiation of the 'Four Pillars' of Guideline-Directed Medical Therapy (GDMT): SGLT2i + ARNI/ACEi (Sacubitril/Valsartan) + Evidence-based Beta-blocker + MRA (Spironolactone/Eplerenone). Additionally, IV Ferric Carboxymaltose or Ferric Derisomaltose is indicated for iron deficiency to reduce hospitalizations.",
            clinicalTakeaway = "Rapid sequencing: Initiate all 4 pillars within 4-6 weeks of diagnosis rather than historical months-long titration. SGLT2 inhibitors do not require blood pressure or potassium titration. Screen all HF patients for iron deficiency (Ferritin <100 ng/mL, or 100-299 ng/mL with TSAT <20%) and treat with IV Iron. In obese HFpEF (BMI >=30), Semaglutide 2.4mg weekly significantly improves symptoms and physical mobility (STEP-HFpEF).",
            webSources = listOf(
                GroundingSource("ESC Guidelines for the Diagnosis and Treatment of Acute and Chronic Heart Failure", "https://www.escardio.org/Guidelines/Clinical-Practice-Guidelines/Acute-and-Chronic-Heart-Failure"),
                GroundingSource("European Heart Journal - Heart Failure 2023 Focused Update", "https://academic.oup.com/eurheartj")
            ),
            isUrgent = true,
            searchQueries = listOf("ESC heart failure guidelines SGLT2 inhibitors", "European Society of Cardiology heart failure 4 pillars")
        ),

        // 2. ESC 2024 Hypertension Guidelines
        MedicalNewsItem(
            id = "guideline_esc_htn_2024",
            title = "ESC 2024 Hypertension Guidelines: Strict Systolic BP Target (120-129 mmHg) & Elevated BP Category",
            category = "ESC (Cardiology)",
            date = "ESC Guidelines Update 2024",
            source = "European Society of Cardiology (ESC)",
            summary = "The 2024 ESC Hypertension Guidelines establish a new classification: 'Non-Elevated BP' (<120/70 mmHg), 'Elevated BP' (120-139 / 70-89 mmHg), and 'Hypertension' (>=140/90 mmHg). For most adult patients receiving antihypertensive therapy, a unified systolic BP target of 120-129 mmHg is recommended if well tolerated. Single-Pill Combinations (SPCs) containing dual therapy (RAS blocker + CCB or Thiazide diuretic) are reaffirmed as standard initial therapy.",
            clinicalTakeaway = "Prioritize Single-Pill Combinations (e.g. Telmisartan + Amlodipine) from day one for confirmed hypertension to maximize compliance. Do not use Beta-blockers as first-line monotherapy for primary hypertension unless coronary disease, HFrEF, or atrial fibrillation rate control is present.",
            webSources = listOf(
                GroundingSource("2024 ESC Guidelines for the Management of Elevated Blood Pressure and Hypertension", "https://www.escardio.org/Guidelines/Clinical-Practice-Guidelines/Hypertension"),
                GroundingSource("European Heart Journal - 2024 Hypertension Practice", "https://academic.oup.com/eurheartj")
            ),
            isUrgent = false,
            searchQueries = listOf("ESC 2024 hypertension guidelines target BP", "European Society of Cardiology elevated blood pressure")
        ),

        // 3. EASL-AASLD-ALEH 2024 MASLD & MASH Guidelines
        MedicalNewsItem(
            id = "guideline_easl_aasld_mash",
            title = "EASL-AASLD-ALEH Consensus: MASLD/MASH Nomenclature, FIB-4 Staging & Resmetirom",
            category = "EASL & AASLD (Hepatology)",
            date = "Multi-Society Clinical Practice Guideline",
            source = "EASL / AASLD / ALEH Multi-Society Guidelines",
            summary = "Global hepatology societies adopt MASLD (Metabolic Dysfunction-Associated Steatotic Liver Disease) and MASH (replacing NAFLD/NASH). Guidelines define a clear 2-step risk stratification: primary care screening with FIB-4 index (<1.30 rules out advanced fibrosis; 1.30-2.67 indeterminate requires transient elastography/VCTE; >2.67 prompts hepatology referral). Endorses Resmetirom (Rezdiffra 80-100mg/day, oral liver-directed THR-beta agonist) for non-cirrhotic MASH with significant fibrosis (stages F2-F3), and GLP-1 receptor agonists for cardiometabolic disease.",
            clinicalTakeaway = "Calculate FIB-4 in all patients with Type 2 Diabetes or metabolic syndrome annually. VCTE liver stiffness <8 kPa rules out advanced fibrosis; >12 kPa strongly indicates advanced fibrosis/cirrhosis. Prioritize lifestyle weight loss of >=7-10% to achieve histological MASH resolution.",
            webSources = listOf(
                GroundingSource("EASL-AASLD-ALEH Clinical Practice Guidelines on MASLD and MASH", "https://easl.eu/guidelines"),
                GroundingSource("Hepatology - AASLD Practice Guidance on MASLD", "https://journals.lww.com/hep")
            ),
            isUrgent = true,
            searchQueries = listOf("EASL AASLD MASLD guidelines 2024", "MASH Resmetirom treatment guidelines FIB-4")
        ),

        // 4. AASLD 2024 Guidance on Acute-on-Chronic Liver Failure & Variceal Bleeding
        MedicalNewsItem(
            id = "guideline_aasld_portal_htn",
            title = "AASLD Practice Guidance: Portal Hypertension, Carvedilol & Variceal Bleeding Protocol",
            category = "EASL & AASLD (Hepatology)",
            date = "AASLD Practice Guidance",
            source = "American Association for the Study of Liver Diseases (AASLD)",
            summary = "AASLD establishes Carvedilol (start 6.25mg once daily, titrate to 6.25mg BID or max 12.5mg daily) as the preferred non-selective beta-blocker over Propranolol for preventing decompensation due to its alpha-1 adrenergic vasodilatory effect lowering portal pressure. For acute variceal bleeding: immediately initiate vasoactive infusion (Terlipressin 2mg q4h or Octreotide 50mcg bolus + 50mcg/hr), short-course Ceftriaxone 1g/day x 7 days, and endoscopic band ligation within 12 hours.",
            clinicalTakeaway = "Target resting heart rate 55-60 bpm with Carvedilol, but withhold if systolic BP <90 mmHg or acute kidney injury/SBP develops. Maintain restrictive red blood cell transfusion (target hemoglobin 7-8 g/dL) to avoid rebound portal pressure spikes and rebleeding.",
            webSources = listOf(
                GroundingSource("AASLD Portal Hypertension and Variceal Bleeding Guidance", "https://www.aasld.org/practice-guidelines"),
                GroundingSource("Hepatology Practice Guidelines AASLD", "https://journals.lww.com/hep")
            ),
            isUrgent = true,
            searchQueries = listOf("AASLD portal hypertension carvedilol guidelines", "AASLD acute variceal bleeding protocol")
        ),

        // 5. APASL 2024 Consensus on Acute-on-Chronic Liver Failure (ACLF)
        MedicalNewsItem(
            id = "guideline_apasl_aclf_2024",
            title = "APASL Consensus: Acute-on-Chronic Liver Failure (ACLF) & Hepatitis B Reactivation",
            category = "APASL (Asia-Pacific)",
            date = "APASL Consensus Recommendations",
            source = "Asian Pacific Association for the Study of the Liver (APASL)",
            summary = "The Asian Pacific Association for the Study of the Liver defines ACLF as acute hepatic insult presenting as jaundice (serum bilirubin >=5 mg/dL) and coagulopathy (INR >=1.5) complicated within 4 weeks by clinical ascites and/or encephalopathy in a patient with chronic liver disease. In the Asia-Pacific region, Hepatitis B virus flare/reactivation represents the leading etiology. High genetic barrier nucleos(t)ide analogues (Tenofovir TDF/TAF or Entecavir) must be initiated immediately without awaiting HBV DNA viral load results.",
            clinicalTakeaway = "Early antiviral therapy within 24-48 hours dramatically improves 90-day survival in HBV-ACLF. Avoid high-volume paracentesis without concurrent 20% Albumin infusion (8g per liter of ascites removed). Evaluate for liver transplantation early if AARC ACLF score is >=11.",
            webSources = listOf(
                GroundingSource("APASL Consensus Recommendations on Acute-on-Chronic Liver Failure", "https://www.apasl.info"),
                GroundingSource("Hepatology International - APASL Guidelines", "https://link.springer.com/journal/12072")
            ),
            isUrgent = true,
            searchQueries = listOf("APASL ACLF consensus guidelines", "APASL hepatitis B flare acute on chronic liver failure")
        ),

        // 6. ACG 2024 Guidelines for Management of Acute Pancreatitis
        MedicalNewsItem(
            id = "guideline_acg_pancreatitis_2024",
            title = "ACG 2024 Acute Pancreatitis Guidelines: Moderately Aggressive Hydration & Early Solid Diet",
            category = "ACG & ESGE (Gastroenterology)",
            date = "ACG Clinical Guideline 2024",
            source = "American College of Gastroenterology (ACG)",
            summary = "The American College of Gastroenterology fundamentally updates acute pancreatitis management: based on the landmark WATERFALL trial, aggressive hyper-hydration is deprecated in favor of *moderately aggressive* hydration with Lactated Ringer's (10 mL/kg bolus only if hypovolemic, followed by 1.5 mL/kg/hr; adjust based on hematocrit and BUN). Recommends early oral feeding with solid, low-fat diet within 24 hours of admission as tolerated. Strongly recommends AGAINST routine prophylactic antibiotics in sterile or necrotizing pancreatitis.",
            clinicalTakeaway = "Lactated Ringer's is superior to Normal Saline (reduces SIRS and metabolic acidosis). Do not keep mild pancreatitis patients NPO; initiate oral diet as soon as ileus resolves. Routine prophylactic Carbapenems for necrotizing pancreatitis are ineffective and promote fungal superinfections; reserve antibiotics for proven infected necrosis (fever, gas on CT after 7-14 days).",
            webSources = listOf(
                GroundingSource("American College of Gastroenterology Management of Acute Pancreatitis", "https://gi.org/clinical-guidelines"),
                GroundingSource("American Journal of Gastroenterology - ACG Pancreatitis 2024", "https://journals.lww.com/ajg")
            ),
            isUrgent = false,
            searchQueries = listOf("ACG acute pancreatitis guidelines 2024", "WATERFALL trial pancreatitis hydration ACG")
        ),

        // 7. ESGE 2024 Guidelines on Non-Variceal Upper GI Bleeding
        MedicalNewsItem(
            id = "guideline_esge_nvugib",
            title = "ESGE Clinical Guideline: Non-Variceal Upper GI Bleeding, GBS Cutoff & Hemostatic Clips",
            category = "ACG & ESGE (Gastroenterology)",
            date = "ESGE Clinical Practice Guideline",
            source = "European Society of Gastrointestinal Endoscopy (ESGE)",
            summary = "ESGE recommends pre-endoscopy risk stratification using the Glasgow-Blatchford Score (GBS): patients with GBS <=1 are at very low risk of rebleeding or mortality and can be safely managed as outpatients without hospitalization. For hospitalized patients, perform endoscopy within 24 hours. For high-risk ulcer stigmata (Forrest Ia, Ib, IIa): combination endoscopic therapy (Through-The-Scope or Over-The-Scope hemoclips, thermal coagulation, or hemostatic powders) PLUS high-dose IV PPI (80mg bolus, then 8mg/hr continuous infusion for 72 hours).",
            clinicalTakeaway = "Epinephrine injection monotherapy is strictly inadequate; it must always be combined with a mechanical clip or thermal probe. Test for Helicobacter pylori in all patients and verify eradication with urea breath test or stool antigen at least 4 weeks post-treatment.",
            webSources = listOf(
                GroundingSource("ESGE Guidelines on Non-variceal Upper Gastrointestinal Bleeding", "https://www.esge.com/guidelines"),
                GroundingSource("Endoscopy Journal - ESGE Recommendations", "https://www.thieme-connect.com/products/ejournals/journal/10.1055/s-00000047")
            ),
            isUrgent = false,
            searchQueries = listOf("ESGE upper GI bleeding guidelines Glasgow Blatchford", "ESGE peptic ulcer endoscopic treatment")
        ),

        // 8. WHO 2024 Guidelines on Chronic Hepatitis B Infection
        MedicalNewsItem(
            id = "guideline_who_hbv_2024",
            title = "WHO 2024 Hepatitis B Guidelines: Universal Simplified Treatment Criteria & Tenofovir Access",
            category = "WHO & CDC",
            date = "WHO Global Hepatitis Report & Guidelines",
            source = "World Health Organization (WHO Geneva)",
            summary = "WHO releases updated global guidelines expanding treatment eligibility to combat chronic viral hepatitis: recommends oral Tenofovir Disoproxil Fumarate (TDF) 300mg daily or Entecavir for all adults and adolescents with significant liver fibrosis (APRI >0.5 or FIB-4 >1.45) OR persistently abnormal ALT with HBV DNA >2000 IU/mL, regardless of HBeAg status. Recommends universal infant Hepatitis B birth-dose vaccine within 24 hours of life. In pregnant women with HBV DNA >=200,000 IU/mL, TDF prophylaxis is recommended from 28 weeks of gestation until delivery.",
            clinicalTakeaway = "Calculate APRI or FIB-4 on baseline labs. TDF is safe during pregnancy and breastfeeding. Routine monitoring of serum creatinine and phosphorus is advised with TDF. Entecavir is preferred in patients with pre-existing CKD or osteoporosis.",
            webSources = listOf(
                GroundingSource("WHO Guidelines for the Prevention, Diagnosis and Treatment of Chronic Hepatitis B Infection", "https://www.who.int/publications/i/item/9789240090903"),
                GroundingSource("WHO Global Hepatitis Programme Updates", "https://www.who.int/teams/global-hiv-hepatitis-and-stis-programmes")
            ),
            isUrgent = false,
            searchQueries = listOf("WHO hepatitis B guidelines 2024 tenofovir", "WHO viral hepatitis elimination treatment criteria")
        ),

        // 9. CDC 2024/2025 Clinical Guidelines on Doxy-PEP & Bacterial STIs
        MedicalNewsItem(
            id = "guideline_cdc_doxy_pep",
            title = "CDC Clinical Guidelines: Doxycycline Post-Exposure Prophylaxis (Doxy-PEP) for Bacterial STIs",
            category = "WHO & CDC",
            date = "CDC MMWR Recommendations",
            source = "Centers for Disease Control and Prevention (CDC Atlanta)",
            summary = "CDC officially recommends Doxycycline Post-Exposure Prophylaxis (Doxy-PEP) for gay, bisexual, and other men who have sex with men (MSM) and transgender women who have had at least one bacterial STI (syphilis, chlamydia, or gonorrhea) in the past 12 months. The protocol consists of oral Doxycycline 200mg taken as a single dose as soon as possible, but no later than 72 hours after condomless sexual contact (maximum 200mg per 24 hours).",
            clinicalTakeaway = "Doxy-PEP reduces incident syphilis by >75% and chlamydia by >85%. Re-screen patients for bacterial STIs every 3 to 6 months. For active uncomplicated gonorrhea, treatment remains single-dose Ceftriaxone 500mg IM (1g if weight >=150kg).",
            webSources = listOf(
                GroundingSource("CDC Guidelines for the Use of Doxycycline Post-Exposure Prophylaxis", "https://www.cdc.gov/std/treatment/doxy-pep.htm"),
                GroundingSource("MMWR Morbidity and Mortality Weekly Report - CDC", "https://www.cdc.gov/mmwr")
            ),
            isUrgent = false,
            searchQueries = listOf("CDC Doxy PEP guidelines bacterial STIs", "CDC syphilis chlamydia post exposure prophylaxis")
        ),

        // 10. AHA/ASA 2024 Acute Ischemic Stroke Guidelines
        MedicalNewsItem(
            id = "guideline_aha_asa_stroke",
            title = "AHA/ASA Stroke Guidelines: Tenecteplase Over Alteplase & Extended 24h Thrombectomy",
            category = "ASA (Stroke & Anesthesia)",
            date = "AHA/ASA Scientific Statement",
            source = "American Heart Association / American Stroke Association (AHA/ASA)",
            summary = "The American Heart Association / American Stroke Association updates acute ischemic stroke protocols: Tenecteplase (0.25 mg/kg, max 25 mg IV single bolus over 5 seconds) is established as an evidence-based alternative to Alteplase 1-hour infusion within 4.5 hours of symptom onset. In addition, Mechanical Thrombectomy is recommended up to 24 hours from last known normal for patients with large vessel occlusions (ICA or M1 segment MCA) meeting DAWN or DEFUSE-3 CT/MRI perfusion mismatch criteria.",
            clinicalTakeaway = "Single-bolus Tenecteplase eliminates intravenous infusion pump complications during urgent ambulance transfers for thrombectomy. Maintain blood pressure <185/110 mmHg before thrombolysis and <180/105 mmHg for 24 hours post-thrombolysis using IV Labetalol (10-20mg) or Nicardipine infusion.",
            webSources = listOf(
                GroundingSource("AHA/ASA Guidelines for the Early Management of Acute Ischemic Stroke", "https://www.ahajournals.org/journal/str"),
                GroundingSource("Stroke - AHA/ASA Professional Practice Guidelines", "https://www.stroke.org/en/professionals")
            ),
            isUrgent = true,
            searchQueries = listOf("AHA ASA stroke guidelines tenecteplase alteplase", "Mechanical thrombectomy 24 hours DAWN DEFUSE 3")
        ),

        // 11. ASA 2024 Guidelines on Perioperative GLP-1 Receptor Agonists & Fasting
        MedicalNewsItem(
            id = "guideline_asa_glp1_fasting",
            title = "ASA Perioperative Practice Guidance: GLP-1 Receptor Agonists & Aspiration Prevention",
            category = "ASA (Stroke & Anesthesia)",
            date = "ASA Clinical Consensus Guidance",
            source = "American Society of Anesthesiologists (ASA)",
            summary = "The American Society of Anesthesiologists issues clinical guidance for patients taking GLP-1 Receptor Agonists (Semaglutide, Tirzepatide, Dulaglutide, Liraglutide) prior to elective surgery due to delayed gastric emptying causing pulmonary aspiration under anesthesia: hold daily GLP-1 RAs on the day of surgery; hold weekly GLP-1 RAs for 1 full week before the scheduled procedure. Reaffirms fasting intervals: 2 hours for clear liquids, 6 hours for light meal, and 8 hours for fatty foods.",
            clinicalTakeaway = "If GLP-1 RA was not withheld or the patient reports nausea, vomiting, or abdominal fullness, proceed with gastric point-of-care ultrasound (POCUS) to assess antral content, or treat the patient as having a 'full stomach' utilizing Rapid Sequence Induction (RSI) with endotracheal intubation.",
            webSources = listOf(
                GroundingSource("ASA Consensus-Based Guidance on Preoperative Management of GLP-1 Receptor Agonists", "https://www.asahq.org/about-asa/newsroom/news-releases/2023/06/american-society-of-anesthesiologists-consensus-based-guidance-on-preoperative"),
                GroundingSource("Anesthesiology Journal - ASA Guidelines", "https://pubs.asahq.org/anesthesiology")
            ),
            isUrgent = false,
            searchQueries = listOf("ASA guidelines GLP-1 receptor agonist surgery fasting", "American Society of Anesthesiologists semaglutide anesthesia")
        ),

        // 12. EASL 2024 Wilson Disease Clinical Practice Guidelines
        MedicalNewsItem(
            id = "guideline_easl_wilson_2024",
            title = "EASL Wilson Disease Guidelines: Leipzig Diagnostic Score & Trientine/Zinc Chelation",
            category = "EASL & AASLD (Hepatology)",
            date = "EASL Clinical Practice Guideline",
            source = "European Association for the Study of the Liver (EASL)",
            summary = "EASL issues comprehensive clinical practice guidelines for Wilson disease: diagnosis relies on the Leipzig score (>=4 establishes diagnosis; includes KF rings, neurologic symptoms, low ceruloplasmin <0.1 g/L, 24h urinary copper >2x ULN, and ATP7B biallelic mutations). First-line treatment for symptomatic patients is copper chelation with D-Penicillamine or Trientine. For presymptomatic patients or maintenance therapy after initial de-coppering, oral Zinc salts (preventing intestinal copper absorption via metallothionein induction) are recommended.",
            clinicalTakeaway = "Monitor 24-hour urinary copper excretion annually (target 3-8 umol/24h on chelators; <1.2 umol/24h on zinc). In acute liver failure due to Wilson disease, Dhawan score >=11 or King's revised index indicates urgent liver transplantation without delay; chelation alone is uniformly fatal in fulminant Wilsonian hepatic crisis.",
            webSources = listOf(
                GroundingSource("EASL Clinical Practice Guidelines on Wilson's Disease", "https://easl.eu/guideline/wilson-disease"),
                GroundingSource("Journal of Hepatology - EASL Guidelines", "https://www.journal-of-hepatology.eu")
            ),
            isUrgent = false,
            searchQueries = listOf("EASL Wilson disease guidelines Leipzig score", "Trientine penicillamine zinc Wilson disease EASL")
        ),

        // 13. ESC 2024 Atrial Fibrillation Guidelines (AF-CARE Pathway)
        MedicalNewsItem(
            id = "guideline_esc_af_2024",
            title = "ESC 2024 Atrial Fibrillation Guidelines: The AF-CARE Holistic Management Framework",
            category = "ESC (Cardiology)",
            date = "ESC Clinical Practice Guideline 2024",
            source = "European Society of Cardiology (ESC)",
            summary = "The 2024 ESC Atrial Fibrillation Guidelines introduce the comprehensive AF-CARE framework: 'C' (Comorbidity & risk factor management: aggressive BP control, weight loss >=10%, sleep apnea treatment); 'A' (Avoid stroke & thromboembolism: DOACs [Apixaban, Rivaroxaban, Edoxaban, Dabigatran] strongly preferred over VKAs for CHA2DS2-VA score >=1 in men or >=2 in women; female sex is reclassified as risk modifier); 'R' (Reduce symptoms via rate and rhythm control: early catheter ablation recommended as first-line for paroxysmal AF); 'E' (Evaluation & regular re-assessment).",
            clinicalTakeaway = "DOACs are mandatory first-line over Warfarin (except in moderate-severe mitral stenosis or mechanical prosthetic valves). Calculate CHA2DS2-VA (without female sex alone as indication). Rate control target resting heart rate <110 bpm (lenient control).",
            webSources = listOf(
                GroundingSource("2024 ESC Guidelines for the Management of Atrial Fibrillation", "https://www.escardio.org/Guidelines/Clinical-Practice-Guidelines/Atrial-Fibrillation"),
                GroundingSource("European Heart Journal - 2024 ESC AF Guidelines", "https://academic.oup.com/eurheartj")
            ),
            isUrgent = true,
            searchQueries = listOf("ESC 2024 atrial fibrillation guidelines AF CARE", "ESC DOAC anticoagulation heart failure AF")
        ),

        // 14. AASLD 2024 Practice Guidance: SBP & Hepatorenal Syndrome
        MedicalNewsItem(
            id = "guideline_aasld_cirrhosis_2024",
            title = "AASLD Practice Guidance: SBP Prophylaxis, Paracentesis Albumin & Terlipressin in HRS-AKI",
            category = "EASL & AASLD (Hepatology)",
            date = "AASLD Practice Guidance 2024",
            source = "American Association for the Study of Liver Diseases (AASLD)",
            summary = "AASLD updates inpatient cirrhosis protocols: Diagnostic paracentesis is mandatory for all hospitalized cirrhotics with ascites. SBP is confirmed if ascitic fluid absolute neutrophil count (ANC) >=250 cells/mm³. First-line therapy is IV Ceftriaxone 2g daily PLUS IV 20% Albumin (1.5 g/kg within 6 hours of diagnosis, then 1.0 g/kg on day 3) to prevent hepatorenal syndrome and reduce mortality by 67%. For Hepatorenal Syndrome (HRS-AKI): Terlipressin (IV continuous infusion 2-12 mg/day) plus 20-25% Albumin is established as the gold standard pharmacotherapy over Midodrine + Octreotide.",
            clinicalTakeaway = "In Large Volume Paracentesis (>5 Liters), Albumin infusion is mandatory at 8 grams per liter of ascites removed to prevent post-paracentesis circulatory dysfunction (PICD). Secondary prophylaxis for SBP requires Norfloxacin 400mg daily or Trimethoprim-Sulfamethoxazole 1 DS tablet daily indefinitely.",
            webSources = listOf(
                GroundingSource("AASLD Guidance on Inpatient Management of Cirrhosis and Ascites", "https://www.aasld.org/practice-guidelines"),
                GroundingSource("Hepatology Journal - AASLD SBP and HRS Guidance", "https://journals.lww.com/hep")
            ),
            isUrgent = true,
            searchQueries = listOf("AASLD SBP albumin guidelines 2024", "Terlipressin hepatorenal syndrome AASLD guidance")
        ),

        // 15. APASL 2024 Non-Invasive Liver Fibrosis Assessment
        MedicalNewsItem(
            id = "guideline_apasl_fibrosis_2024",
            title = "APASL Guidelines: Non-Invasive Staging of Liver Fibrosis in Asia-Pacific Populations",
            category = "APASL (Asia-Pacific)",
            date = "APASL Practice Guideline 2024",
            source = "Asian Pacific Association for the Study of the Liver (APASL)",
            summary = "APASL establishes clinical pathways for non-invasive liver fibrosis screening in viral hepatitis, MASLD, and alcohol-related liver disease. In primary care and resource-limited settings across South Asia, serum biomarkers (FIB-4 and APRI) serve as first-tier triage: FIB-4 <1.30 has a 90% negative predictive value to rule out advanced fibrosis (F3-F4). Patients with FIB-4 >=1.30 proceed to Vibration-Controlled Transient Elastography (FibroScan): liver stiffness measurement (LSM) <8.0 kPa excludes advanced fibrosis; LSM >=12.0-15.0 kPa confirms cirrhosis and mandates HCC ultrasound surveillance every 6 months.",
            clinicalTakeaway = "Integrate FIB-4 into routine chronic hepatitis B and diabetes reviews. All cirrhotic patients (LSM >=12.5 kPa) require screening endoscopy for esophageal varices or non-invasive stratification (platelets >150k and LSM <20 kPa can defer screening endoscopy under Baveno VII criteria).",
            webSources = listOf(
                GroundingSource("APASL Guidelines on Non-Invasive Staging of Liver Fibrosis", "https://www.apasl.info"),
                GroundingSource("Hepatology International APASL Consensus", "https://link.springer.com/journal/12072")
            ),
            isUrgent = false,
            searchQueries = listOf("APASL liver fibrosis noninvasive guidelines", "APASL transient elastography FibroScan cutoffs")
        ),

        // 16. ESGE / ESG 2024 Colorectal Polypectomy & Surveillance
        MedicalNewsItem(
            id = "guideline_esge_polyp_2024",
            title = "ESGE Clinical Guideline: Colorectal Polypectomy Techniques & Post-Polypectomy Surveillance",
            category = "ACG & ESGE (Gastroenterology)",
            date = "ESGE Clinical Guideline 2024",
            source = "European Society of Gastrointestinal Endoscopy (ESGE / ESG)",
            summary = "ESGE updates standards for colorectal lesion resection: Cold snare polypectomy (CSP) is strongly recommended as the technique of choice for diminutive (<=5mm) and small (6-9mm) polyps due to high complete resection rates and zero post-polypectomy electrocautery perforation risk. Hot snare EMR with submucosal injection is reserved for sessile polyps >=10mm. Post-polypectomy surveillance intervals: patients with 1-2 small tubular adenomas (<10mm) with low-grade dysplasia require NO repeat colonoscopy at 3 years, but return to routine screening at 10 years, avoiding colonoscopy overuse.",
            clinicalTakeaway = "Never use hot biopsy forceps for polyp removal (high risk of delayed thermal perforation and inadequate histology). High-risk adenomas (>=3 adenomas, any adenoma >=10mm, high-grade dysplasia, or villous component) require surveillance colonoscopy at 3 years.",
            webSources = listOf(
                GroundingSource("ESGE Colorectal Polypectomy and Endoscopic Mucosal Resection Guideline", "https://www.esge.com/guidelines"),
                GroundingSource("Endoscopy Journal ESGE Recommendations", "https://www.thieme-connect.com/products/ejournals/journal/10.1055/s-00000047")
            ),
            isUrgent = false,
            searchQueries = listOf("ESGE colorectal polypectomy cold snare guidelines", "European Society Gastrointestinal Endoscopy post polypectomy")
        ),

        // 17. ACG & CAG 2024 Clinical Guidelines on Helicobacter pylori Infection
        MedicalNewsItem(
            id = "guideline_acg_hpylori_2024",
            title = "ACG Clinical Guidelines: H. pylori Bismuth Quadruple First-Line Therapy & Resistance Management",
            category = "ACG & ESGE (Gastroenterology)",
            date = "ACG Practice Guideline 2024",
            source = "American College of Gastroenterology (ACG)",
            summary = "Given clarithromycin resistance exceeding 25-30% globally, the ACG guideline replaces traditional triple therapy (PPI + Clarithromycin + Amoxicillin) with Bismuth Quadruple Therapy for 14 days as the preferred initial treatment: PPI standard dose BID + Bismuth subsalicylate 524mg QID + Metronidazole 500mg TID/QID + Tetracycline 500mg QID. Alternatively, Rifabutin triple therapy (PPI + Amoxicillin 1g TID + Rifabutin 150mg BID x 14d) is recommended for refractory salvage treatment.",
            clinicalTakeaway = "Test-of-cure is mandatory for all treated patients: perform urea breath test, monoclonal fecal antigen test, or endoscopy biopsy >=4 weeks post-antibiotic completion and >=2 weeks after PPI discontinuation. Never repeat clarithromycin in a patient who previously failed a clarithromycin-based regimen.",
            webSources = listOf(
                GroundingSource("ACG Clinical Guideline: Treatment of Helicobacter pylori Infection", "https://gi.org/clinical-guidelines"),
                GroundingSource("American Journal of Gastroenterology - ACG H. Pylori 2024", "https://journals.lww.com/ajg")
            ),
            isUrgent = false,
            searchQueries = listOf("ACG Helicobacter pylori guidelines bismuth quadruple", "American College Gastroenterology H pylori resistance 2024")
        ),

        // 18. WHO 2024 Bacterial Priority Pathogens List & AWaRe Stewardship
        MedicalNewsItem(
            id = "guideline_who_bppl_aware_2024",
            title = "WHO Bacterial Priority Pathogens List (BPPL 2024) & AWaRe Antibiotic Stewardship",
            category = "WHO & CDC",
            date = "WHO Global Health Directive 2024",
            source = "World Health Organization (WHO Geneva)",
            summary = "WHO releases the updated Bacterial Priority Pathogens List (BPPL 2024) to guide antimicrobial research and clinical prescription. Critical Priority pathogens include Carbapenem-resistant Acinetobacter baumannii, Carbapenem-resistant Enterobacterales (CRE), and 3rd-generation cephalosporin-resistant Enterobacterales. Reaffirms the AWaRe antibiotic framework: hospitals must maintain >=60% of all prescriptions from the 'ACCESS' group (e.g. Amoxicillin, Cloxacillin, Gentamicin, Metronidazole), strictly restrict 'WATCH' agents (Fluoroquinolones, 3rd-gen Cephalosporins, Carbapenems), and lock 'RESERVE' drugs (Colistin, Linezolid, Ceftazidime/Avibactam) under specialist infectious disease approval.",
            clinicalTakeaway = "Avoid empirical 3rd-generation cephalosporins (Ceftriaxone) or Fluoroquinolones for simple outpatient infections. Target >=60% Access group antibiotics. In severe hospital-acquired sepsis with suspected CRE, request rapid phenotypic carbapenemase screening (KPC vs MBL/NDM) before selecting newer beta-lactamase inhibitors.",
            webSources = listOf(
                GroundingSource("WHO Bacterial Priority Pathogens List 2024", "https://www.who.int/publications/i/item/9789240093461"),
                GroundingSource("WHO AWaRe Antibiotic Classification System", "https://www.who.int/teams/surveillance-prevention-control-AMR/aware-classification")
            ),
            isUrgent = true,
            searchQueries = listOf("WHO bacterial priority pathogens list 2024", "WHO AWaRe classification antibiotic stewardship")
        ),

        // 19. CDC 2024/2025 Tuberculosis & LTBI Short-Course Regimens
        MedicalNewsItem(
            id = "guideline_cdc_tb_short_course",
            title = "CDC Clinical Guidance: 3-Month 3HP & 4-Month 4R Short-Course Regimens for Latent TB",
            category = "WHO & CDC",
            date = "CDC MMWR Clinical Guidance",
            source = "Centers for Disease Control and Prevention (CDC)",
            summary = "CDC prioritizes short-course rifamycin-based regimens over the traditional 9-month daily Isoniazid (9H) for Latent Tuberculosis Infection (LTBI) treatment due to higher completion rates (85% vs 50%) and lower hepatotoxicity: 1) 3HP (weekly high-dose Rifapentine 900mg + Isoniazid 900mg with Vitamin B6 for 12 weeks, self-administered or DOT); 2) 4R (daily Rifampin 600mg for 4 months). For drug-susceptible active pulmonary TB in patients >=12 years, CDC endorses the 4-month Rifapentine-Moxifloxacin regimen (2PHZM/2PHM) as non-inferior to standard 6-month therapy.",
            clinicalTakeaway = "Always exclude active TB disease with chest radiography and symptom screen before initiating LTBI treatment. Prescribe Pyridoxine (Vitamin B6 25-50mg daily) concurrently with Isoniazid to prevent peripheral neuropathy, especially in malnourished, diabetic, or pregnant patients.",
            webSources = listOf(
                GroundingSource("CDC Guidelines for the Treatment of Latent Tuberculosis Infection", "https://www.cdc.gov/tb/topic/treatment/ltbi.htm"),
                GroundingSource("CDC MMWR Latent TB Short-Course Regimens", "https://www.cdc.gov/mmwr")
            ),
            isUrgent = false,
            searchQueries = listOf("CDC latent TB treatment 3HP 4R guidelines", "CDC short course tuberculosis rifapentine")
        ),

        // 20. ASA 2024 Difficult Airway & Video Laryngoscopy Management
        MedicalNewsItem(
            id = "guideline_asa_difficult_airway",
            title = "ASA Difficult Airway Algorithm: Universal Video Laryngoscopy & Emergency Front-of-Neck Access",
            category = "ASA (Stroke & Anesthesia)",
            date = "ASA Practice Guidelines Update",
            source = "American Society of Anesthesiologists (ASA)",
            summary = "The American Society of Anesthesiologists practice guidelines recommend Video Laryngoscopy (VL) as the preferred primary intubation modality for all unanticipated difficult airway scenarios. Limits direct and video laryngoscopy attempts to a maximum of 3 (plus 1 attempt by an experienced senior colleague) to avoid mucosal trauma, bleeding, and complete airway obstruction. If ventilation fails via mask and supraglottic airway (SGA/LMA) in a 'Cannot Intubate, Cannot Oxygenate' (CICO) emergency, clinicians must immediately declare CICO and execute emergency Front-of-Neck Access (eFONA) via scalpel-bougie-tube cricothyroidotomy without delay.",
            clinicalTakeaway = "Always pre-oxygenate to End-Tidal O2 >=90%. Limit intubation attempts to <=3. Maintain continuous waveform capnography as mandatory confirmation of tracheal tube placement in OR, ICU, and resuscitation bays.",
            webSources = listOf(
                GroundingSource("ASA Practice Guidelines for Management of the Difficult Airway", "https://pubs.asahq.org/anesthesiology/article/136/1/31/117904/2022-American-Society-of-Anesthesiologists"),
                GroundingSource("Anesthesiology Journal - Difficult Airway Algorithms", "https://pubs.asahq.org/anesthesiology")
            ),
            isUrgent = true,
            searchQueries = listOf("ASA difficult airway guidelines algorithm video laryngoscopy", "American Society Anesthesiologists cricothyroidotomy eFONA")
        )
    )
}
