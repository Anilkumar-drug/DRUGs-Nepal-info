package com.example.data.repository

import com.example.data.model.BloodProductType
import com.example.data.model.MtpPackStage
import com.example.data.model.TransfusionReactionProtocol
import com.example.data.model.TransfusionTriggerGuideline

object BloodTransfusionProtocolsData {

    // ==========================================
    // 1. EMERGENCY UNCROSSED TRANSFUSION RULES
    // ==========================================
    val emergencyUncrossedRules: List<String> = listOf(
        "🩸 EMERGENCY O-NEGATIVE (O RhD-) PRIORITY: Women of childbearing potential (<50 years of age) and female pediatric patients MUST receive O RhD-Negative packed red cells in extreme life-threatening exsanguination to prevent RhD isoimmunization and future hemolytic disease of the fetus/newborn (HDFN).",
        "🩸 EMERGENCY O-POSITIVE (O RhD+) ALLOCATION: Adult males and post-menopausal females (≥50 years of age) should receive O RhD-Positive blood during emergency uncrossed resuscitation. This preserves scarce O-negative reserves for obstetric emergencies.",
        "🧪 UNIVERSAL EMERGENCY PLASMA: Group AB plasma contains neither Anti-A nor Anti-B antibodies and is the universal plasma product. If AB plasma is in short supply, low-titer uncrossed Group A plasma may be used under emergency medical director authorization.",
        "⏱️ SWITCH TO TYPE-SPECIFIC BLOOD: Draw pre-transfusion crossmatch and type-and-screen tubes BEFORE hanging uncrossed units. Transition to ABO/Rh group-specific blood as soon as basic typing is completed (usually 15-20 minutes). Full Coombs crossmatch takes 45-60 minutes.",
        "🛑 NEVER DELAY EXSANGUINATION RESUSCITATION: In profound hemorrhagic shock (SBP <70 mmHg, undetectable pulse), do not wait for crossmatched blood. Administer uncrossed red cells via rapid infuser with fluid warmer immediately."
    )

    // ==========================================
    // 2. MASSIVE TRANSFUSION PROTOCOL (MTP)
    // ==========================================
    val mtpDefinition: String = "Transfusion of ≥10 units PRBCs within 24 hours, or >4 units PRBCs within 1 hour with anticipation of continued ongoing blood loss, or replacement of >50% total circulating blood volume within 3 hours."

    val mtpTriggers: List<String> = listOf(
        "Shock Index (SI = Heart Rate / Systolic BP) > 1.0 (e.g. HR 120 / SBP 80 = 1.5 indicates critical under-perfusion and occult hemorrhage).",
        "ABC Score ≥ 2 points (Penetrating torso injury = 1, SBP ≤90 mmHg = 1, HR ≥120 bpm = 1, Positive FAST ultrasound = 1). Sensitivity 85%, specificity 88% for massive transfusion.",
        "Severe obstetrical postpartum hemorrhage (PPH) refractory to primary uterotonics and bimanual compression with blood loss >1500 mL.",
        "Trauma exsanguination with dynamic base deficit >6 mmol/L, lactate >4.0 mmol/L, or INR >1.5 on arrival."
    )

    val mtpPackStages: List<MtpPackStage> = listOf(
        MtpPackStage(
            stageNumber = 1,
            title = "MTP Pack 1 (Immediate Activation - Balanced 1:1:1)",
            prbcUnits = 4,
            ffpUnits = 4,
            plateletDose = "1 Adult Apheresis Unit (or 4-6 Random Donor Platelet units)",
            cryoprecipitateUnits = "Consider early 10 units if Obstetric PPH or known hypofibrinogenemia",
            adjunctiveTherapy = listOf(
                "Tranexamic Acid (TXA): 1 g IV over 10 minutes, followed by 1 g IV infusion over 8 hours (CRASH-2 / WOMAN Trial: must start within 3 hours of injury/delivery).",
                "Calcium Gluconate: 10 mL of 10% IV over 5-10 min (or Calcium Chloride 1g via central line) every 4 units of PRBC to prevent citrate toxicity and hypocalcemic myocardial depression.",
                "Active Warming: Warm blood through rapid blood warmer (37°C–40°C); use forced-air warming blanket to keep core temp >36°C."
            ),
            monitoringTargets = listOf(
                "Temperature > 36.0°C (Hypothermia poisons coagulation cascade enzymes)",
                "pH > 7.20 and Base Deficit < 6 mmol/L",
                "Ionized Calcium > 1.10 mmol/L",
                "Platelet count > 50,000 / μL (> 100,000 in neurotrauma)",
                "INR < 1.5, Fibrinogen > 1.5 - 2.0 g/L"
            )
        ),
        MtpPackStage(
            stageNumber = 2,
            title = "MTP Pack 2 (Continued Hemorrhage - Ongoing 1:1:1)",
            prbcUnits = 4,
            ffpUnits = 4,
            plateletDose = "1 Adult Apheresis Unit",
            cryoprecipitateUnits = "10 Units (2 pools) if Fibrinogen < 1.5 g/L (or < 2.0 g/L in obstetric PPH)",
            adjunctiveTherapy = listOf(
                "Recheck Calcium: give additional 10% Calcium Gluconate 10-20 mL IV.",
                "Check ABG, Potassium, Lactate, and Coagulation profile every 30-45 minutes.",
                "Surgical Hemostasis / Interventional Radiology: Blood transfusion is only a bridge to mechanical or surgical bleeding control."
            ),
            monitoringTargets = listOf(
                "Urine output > 0.5 mL/kg/hr",
                "Mean Arterial Pressure (MAP) 55-65 mmHg (Permissive hypotension prior to surgical vascular control in penetrating trauma; avoid in TBI where MAP target is ≥80 mmHg)."
            )
        ),
        MtpPackStage(
            stageNumber = 3,
            title = "MTP Pack 3 (Refractory Bleeding / Consumptive Coagulopathy)",
            prbcUnits = 4,
            ffpUnits = 4,
            plateletDose = "1 Adult Apheresis Unit",
            cryoprecipitateUnits = "10 Units Cryoprecipitate",
            adjunctiveTherapy = listOf(
                "ROTEM / TEG (Thromboelastometry) guided component therapy if available.",
                "Consider Recombinant Factor VIIa (rFVIIa) 90 μg/kg ONLY as a desperate last resort after surgical hemostasis, severe hypothermia, acidosis, and hypofibrinogenemia have been corrected.",
                "Watch for severe Hyperkalemia from rapid massive transfusion of older PRBC units (check ECG for peaked T waves)."
            ),
            monitoringTargets = listOf(
                "Fibrinogen target > 2.0 g/L",
                "Serum Potassium < 5.5 mEq/L"
            )
        )
    )

    // ==========================================
    // 3. TRANSFUSION THRESHOLDS & TARGETS
    // ==========================================
    val transfusionTriggers: List<TransfusionTriggerGuideline> = listOf(
        TransfusionTriggerGuideline(
            id = "trigger_icu_general",
            patientCategory = "ICU & Hospitalized Medical Inpatients (Hemodynamically Stable)",
            triggerThreshold = "Hb < 7.0 g/dL",
            targetLevel = "Maintain Hb 7.0 - 8.0 g/dL (Single unit transfusion strategy)",
            recommendationLevel = "Strong (Grade 1A)",
            trialEvidence = "TRICC Trial (NEJM 1999) & TRISS Trial (NEJM 2014): Restrictive strategy (Hb <7 g/dL) resulted in equal or lower 30-day mortality, lower pulmonary edema (TACO), and lower nosocomial infections compared to liberal strategy (Hb <10 g/dL).",
            specialConsiderations = "Transfuse 1 unit at a time in non-bleeding patients, then recheck post-transfusion Hb. Avoid routine 2-unit orders."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_acs_cardiac",
            patientCategory = "Acute Coronary Syndrome (ACS / STEMI / NSTEMI / Active Ischemia)",
            triggerThreshold = "Hb < 8.0 g/dL (or < 8.5 g/dL if active angina/ischemia)",
            targetLevel = "Maintain Hb 8.0 - 10.0 g/dL",
            recommendationLevel = "Moderate (Grade 1B)",
            trialEvidence = "REALITY Trial (JAMA 2021) & MINT Trial (NEJM 2023): Moderate restrictive threshold of 8.0 g/dL is safe in acute myocardial infarction. Avoid severe anemia (Hb <8) due to myocardial oxygen delivery mismatch, but avoid over-transfusion (Hb >10) due to blood viscosity and volume strain.",
            specialConsiderations = "Monitor carefully for volume overload (TACO); administer slow infusion (over 3-4 hours) with preemptive furosemide 20mg IV if ejection fraction is reduced."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_post_op",
            patientCategory = "Post-Operative Orthopedic & Non-Cardiac Surgery",
            triggerThreshold = "Hb < 8.0 g/dL (or symptomatic at <8.5 g/dL)",
            targetLevel = "Maintain Hb 8.0 - 9.0 g/dL",
            recommendationLevel = "Strong (Grade 1A)",
            trialEvidence = "FOCUS Trial (NEJM 2011): In elderly patients with cardiovascular risk undergoing hip fracture surgery, restrictive threshold of 8.0 g/dL showed no difference in mortality or inability to walk compared to liberal 10 g/dL.",
            specialConsiderations = "Symptoms of anemia (tachycardia, lightheadedness, chest pain, orthostatic syncope) warrant transfusion even if Hb is 7.5-8.0 g/dL."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_septic_shock",
            patientCategory = "Severe Sepsis & Septic Shock (Resuscitated Phase)",
            triggerThreshold = "Hb < 7.0 g/dL",
            targetLevel = "Maintain Hb 7.0 - 8.0 g/dL",
            recommendationLevel = "Strong (Grade 1B)",
            trialEvidence = "Surviving Sepsis Campaign Guidelines 2021 & TRISS Trial: Once acute tissue hypoperfusion has resolved, transfuse PRBCs only if Hb drops below 7.0 g/dL in the absence of acute MI, severe hypoxemia, or active hemorrhage.",
            specialConsiderations = "Blood transfusions increase immunomodulation and acute lung injury risk in severe sepsis."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_platelets_stable",
            patientCategory = "Platelet Prophylaxis: Stable Bone Marrow Failure (Chemotherapy / Aplastic)",
            triggerThreshold = "Platelet count < 10,000 / μL (< 10 × 10⁹/L)",
            targetLevel = "Keep ≥ 10,000 - 20,000 / μL",
            recommendationLevel = "Strong (Grade 1A)",
            trialEvidence = "PLADO Trial (NEJM 2010): 10,000/μL threshold is as safe as 20,000/μL for preventing major spontaneous bleeding in non-febrile bone marrow suppression.",
            specialConsiderations = "1 Adult Apheresis Unit (or pool of 4-6 RDPs) typically raises platelet count by 30,000 to 50,000 / μL in a 70 kg patient."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_platelets_fever_sepsis",
            patientCategory = "Platelet Prophylaxis: Sepsis, High Fever, Coagulopathy, Rapid Drop",
            triggerThreshold = "Platelet count < 20,000 / μL (< 20 × 10⁹/L)",
            targetLevel = "Keep ≥ 20,000 - 30,000 / μL",
            recommendationLevel = "Moderate (Grade 1C)",
            trialEvidence = "Increased platelet consumption and microvascular fragility in severe systemic inflammation elevate spontaneous bleeding risk.",
            specialConsiderations = "Address underlying infection; platelets consume rapidly if sepsis is uncontrolled."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_platelets_invasive",
            patientCategory = "Platelets: Lumbar Puncture, Central Venous Line, Major Endoscopy, General Surgery",
            triggerThreshold = "Platelet count < 50,000 / μL (< 50 × 10⁹/L)",
            targetLevel = "Keep ≥ 50,000 / μL immediately prior to procedure",
            recommendationLevel = "Strong (Grade 1B)",
            trialEvidence = "British Committee for Standards in Haematology (BCSH) Guidelines: 50,000/μL is the recognized safe threshold for major surgical incisions and percutaneous procedures without excess bleeding.",
            specialConsiderations = "Give platelet transfusion immediately before incision or needle puncture, as platelet half-life in circulation is short."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_platelets_neurosurg",
            patientCategory = "Platelets: Neurosurgery, Intracranial Hemorrhage, Ocular Surgery",
            triggerThreshold = "Platelet count < 100,000 / μL (< 100 × 10⁹/L)",
            targetLevel = "Keep ≥ 100,000 / μL",
            recommendationLevel = "Strong (Grade 1B)",
            trialEvidence = "Non-expandable intracranial cavity: even minimal micro-bleeding causes fatal brainstem herniation or permanent blindness.",
            specialConsiderations = "Maintain strict platelet count ≥100,000 for at least 48-72 hours post-craniotomy."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_ffp",
            patientCategory = "Fresh Frozen Plasma (FFP): Active Bleeding or Pre-Op with Coagulopathy",
            triggerThreshold = "INR > 1.5 - 1.7 (or PT/aPTT > 1.5x normal control) with active bleeding or prior to surgery",
            targetLevel = "Dose: 10 - 15 mL/kg (e.g. 3 to 4 units in a 70 kg adult)",
            recommendationLevel = "Strong (Grade 1B)",
            trialEvidence = "Do NOT transfuse FFP for simple volume expansion or for mild asymptomatic INR elevation (INR 1.3-1.6), as FFP cannot correct INR <1.7 due to its own intrinsic INR of ~1.3.",
            specialConsiderations = "For rapid Warfarin reversal in life-threatening bleeding, Prothrombin Complex Concentrate (PCC 4-factor) is vastly superior to FFP and avoids massive volume overload."
        ),
        TransfusionTriggerGuideline(
            id = "trigger_cryoprecipitate",
            patientCategory = "Cryoprecipitate: Severe Hypofibrinogenemia & Obstetric PPH",
            triggerThreshold = "Fibrinogen < 1.5 g/L (< 150 mg/dL) in general; Fibrinogen < 2.0 g/L in Obstetric PPH",
            targetLevel = "Maintain Fibrinogen > 1.5 - 2.0 g/L (1 Adult Pool = 10 units)",
            recommendationLevel = "Strong (Grade 1A)",
            trialEvidence = "Fibrinogen is the first coagulation factor to drop to critically low levels in acute hemorrhage. In postpartum hemorrhage, fibrinogen <2.0 g/L has a positive predictive value of 100% for progression to severe PPH.",
            specialConsiderations = "1 adult pool of 10 units contains ~2.0 to 2.5 g of fibrinogen and elevates plasma fibrinogen by 0.5 to 1.0 g/L."
        )
    )

    // ==========================================
    // 4. ACUTE TRANSFUSION REACTION EMERGENCY ALGORITHM
    // ==========================================
    val immediateReactionSteps: List<String> = listOf(
        "1️⃣ STOP THE TRANSFUSION IMMEDIATELY: Do not slow down or hesitate. Every milliliter of incompatible blood worsens mortality.",
        "2️⃣ DISCONNECT INFUSION TUBING: Do NOT flush the blood-filled tubing into the patient. Disconnect at the cannula hub.",
        "3️⃣ MAINTAIN IV ACCESS WITH FRESH NORMAL SALINE: Attach a brand-new IV infusion set and hang 0.9% Normal Saline to keep the vein open and maintain perfusion.",
        "4️⃣ IMMEDIATE BEDSIDE CLERICAL CHECK: Verify patient wristband identification against the donor blood bag label, compatibility form, and medical record. Clerical error is the #1 cause of fatal ABO mismatch.",
        "5️⃣ NOTIFY ATTENDING DOCTOR AND BLOOD BANK IMMEDIATELY: Alert the blood bank so they can quarantine other units from the same donation or hold other mismatched crossmatches.",
        "6️⃣ SEND INVESTIGATION SAMPLES: Return the intact blood bag and administration set to the blood bank. Send fresh patient EDTA blood (direct antiglobulin test / repeat crossmatch), serum (free hemoglobin, LDH, haptoglobin, bilirubin, repeat coagulation profile), and first post-reaction urine (for free hemoglobinuria)."
    )

    val reactionProtocols: List<TransfusionReactionProtocol> = listOf(
        TransfusionReactionProtocol(
            id = "reaction_ahtr",
            reactionName = "Acute Hemolytic Transfusion Reaction (AHTR - ABO Incompatibility)",
            severityLevel = "Life-Threatening Emergency (Mortality up to 40%)",
            clinicalPresentation = listOf(
                "Triad: Fever, flank/lumbar pain, and red-to-brown urine (hemoglobinuria).",
                "Severe burning pain along the infusion vein.",
                "Rigors, profound hypotension, tachycardia, dyspnea, nausea.",
                "In anesthetized surgical patients: sudden unexplained hypotension, diffuse oozing from surgical wound, and dark wine-colored urine in Foley catheter bag (heralds acute DIC)."
            ),
            pathophysiology = "Preformed recipient IgM or IgG isohemagglutinins (Anti-A, Anti-B) bind to donor red cell antigens, triggering rapid complement activation (C5b-C9 MAC), intravascular lysis of donor RBCs, release of free hemoglobin, massive cytokine storm, and acute renal tubular necrosis.",
            immediateStep1Action = "STOP TRANSFUSION IMMEDIATELY. Aggressive IV fluid resuscitation with Normal Saline (bolus 20-30 mL/kg, then 200-300 mL/hr) targeting urine output > 100 mL/hr (> 1.5 mL/kg/hr) to wash free toxic stroma and hemoglobin out of renal tubules.",
            pharmacotherapy = listOf(
                "IV Normal Saline 0.9%: maintain high-volume diuresis.",
                "Furosemide 20 - 40 mg IV: if urine output remains <100 mL/hr despite adequate intravascular filling.",
                "Sodium Bicarbonate: consider urinary alkalinization (urine pH >7.0) to prevent acidic ferrihemate cast precipitation in tubules.",
                "Noradrenaline / Vasopressors: if hypotensive shock persists despite fluid loading.",
                "Cryoprecipitate and Platelets: if consumptive DIC develops."
            ),
            laboratoryInvestigations = listOf(
                "Immediate visual check: spin EDTA tube to check for pink/red serum (free hemoglobinemia).",
                "Direct Antiglobulin Test (DAT / Coombs Test) - strongly positive.",
                "Urine test for free hemoglobin (positive dipstick for blood with microscopic absence of intact RBCs).",
                "Serum LDH, Unconjugated Bilirubin, and low/undetectable Haptoglobin.",
                "Repeat ABO and Rh typing on pre- and post-transfusion samples."
            ),
            futurePrevention = "Strict two-person bedside independent verification of patient identity, blood group, and bag unit number before hanging every single blood product."
        ),
        TransfusionReactionProtocol(
            id = "reaction_anaphylaxis",
            reactionName = "Anaphylactic / Severe Allergic Transfusion Reaction",
            severityLevel = "Life-Threatening Emergency",
            clinicalPresentation = listOf(
                "Rapid onset (within seconds to minutes of starting transfusion):",
                "Laryngeal edema, stridor, hoarseness, severe bronchospasm with wheezing.",
                "Profound cardiovascular collapse, hypotension, tachycardia.",
                "Generalized urticaria, pruritus, periorbital and facial angioedema."
            ),
            pathophysiology = "IgE-mediated mast cell degranulation, classic in patients with congenital IgA deficiency who possess preformed anti-IgA antibodies reacting to donor plasma IgA.",
            immediateStep1Action = "STOP TRANSFUSION IMMEDIATELY. Call for code blue / airway team. Administer IM Adrenaline without delay.",
            pharmacotherapy = listOf(
                "Adrenaline (Epinephrine) 1:1,000 (1 mg/mL): 0.5 mg IM (0.01 mg/kg in children) into the anterolateral mid-thigh immediately. Repeat every 5 minutes if shock or bronchospasm persists.",
                "High-flow 100% Oxygen via non-rebreather mask; prepare for endotracheal intubation.",
                "IV Crystalloid bolus (1-2 Litres Normal Saline) for distributive anaphylactic shock.",
                "Chlorpheniramine 10 mg IV (or Diphenhydramine 50 mg IV) slowly.",
                "Hydrocortisone 100 - 200 mg IV."
            ),
            laboratoryInvestigations = listOf(
                "Serum Tryptase level within 1 to 2 hours of reaction.",
                "Post-recovery test for Quantitative IgA levels and Anti-IgA antibodies."
            ),
            futurePrevention = "Patients with confirmed Anti-IgA antibodies must receive only thoroughly washed red blood cells (saline-washed to remove all plasma) or blood products from identified IgA-deficient donors."
        ),
        TransfusionReactionProtocol(
            id = "reaction_trali",
            reactionName = "TRALI (Transfusion-Related Acute Lung Injury)",
            severityLevel = "Life-Threatening Emergency (#1 cause of transfusion-related fatality)",
            clinicalPresentation = listOf(
                "Acute onset of hypoxemia and respiratory distress within 6 hours of transfusion (usually within 1-2 hours).",
                "Bilateral fluffy pulmonary infiltrates on chest X-ray / CT (whiteout lungs).",
                "Hypotension, fever, frothy pink/white endotracheal secretions.",
                "Normal Jugular Venous Pressure (JVP), absence of S3 gallop, absence of left atrial hypertension, normal ejection fraction, normal or low BNP (distinguishes TRALI from TACO!)."
            ),
            pathophysiology = "Two-hit neutrophil-mediated capillary leak: Recipient pulmonary vascular bed is primed by underlying inflammation/sepsis (Hit 1); donor plasma contains anti-HLA class I/II or anti-HNA (neutrophil-specific) antibodies (Hit 2, commonly from multiparous female donors) which activate recipient pulmonary neutrophils, causing catastrophic alveolar capillary membrane disruption and non-cardiogenic pulmonary edema.",
            immediateStep1Action = "STOP TRANSFUSION IMMEDIATELY. Provide aggressive oxygenation and ventilatory support. Avoid aggressive diuretics (patient is often intravascularly volume-depleted from capillary leak!).",
            pharmacotherapy = listOf(
                "Supplemental Oxygen, High-Flow Nasal Cannula (HFNC), or non-invasive/invasive mechanical ventilation with low tidal volume (6 mL/kg PBW) and PEEP (ARDS lung-protective ventilation protocol).",
                "Cautious IV fluids / Vasopressors (Noradrenaline) if hypotensive.",
                "Diuretics are NOT indicated and may worsen hypotension (unlike TACO). Corticosteroids have no proven clinical benefit."
            ),
            laboratoryInvestigations = listOf(
                "Arterial Blood Gas (ABG): PaO2/FiO2 ratio ≤ 300 mmHg.",
                "Chest Radiography: Bilateral non-cardiogenic pulmonary edema.",
                "Echocardiogram: Normal LV function and normal filling pressures.",
                "Serum BNP / NT-proBNP: Typically normal or mildly elevated.",
                "Blood bank HLA/HNA antibody screening on donor plasma."
            ),
            futurePrevention = "Notify blood bank to permanently defer the offending donor (especially multiparous female plasma donors) from donating plasma or platelets."
        ),
        TransfusionReactionProtocol(
            id = "reaction_taco",
            reactionName = "TACO (Transfusion-Associated Circulatory Overload)",
            severityLevel = "Severe (Very common in elderly, cardiac, or renal patients)",
            clinicalPresentation = listOf(
                "Acute respiratory distress, tachypnea, orthopnea within 6 hours of transfusion.",
                "Marked Hypertension (SBP often rises >160-180 mmHg) and widened pulse pressure.",
                "Elevated Jugular Venous Pressure (JVP), peripheral edema, bilateral basal crackles on lung auscultation, S3 gallop.",
                "Markedly elevated post-transfusion BNP or NT-proBNP (>1.5x pre-transfusion)."
            ),
            pathophysiology = "Hydrostatic cardiogenic pulmonary edema caused by rapid or excessive volume of transfusion exceeding recipient left ventricular compliance. Frequent in elderly patients with baseline diastolic dysfunction or severe chronic anemia.",
            immediateStep1Action = "STOP TRANSFUSION IMMEDIATELY. Sit patient completely upright (90° posture) with legs dependent. High-flow oxygen.",
            pharmacotherapy = listOf(
                "Furosemide 20 to 80 mg IV bolus (rapid loop diuresis relieves pulmonary capillary wedge pressure).",
                "Nitroglycerin sublingual spray or IV infusion (if SBP >140 mmHg) for venodilation and preload reduction.",
                "Non-invasive positive pressure ventilation (CPAP / BiPAP) to decrease work of breathing and push fluid out of alveoli."
            ),
            laboratoryInvestigations = listOf(
                "Serum BNP / NT-proBNP: typically > 4x baseline.",
                "Bedside Echocardiography / Lung POCUS: multiple bilateral B-lines with elevated E/e' ratio and dilated IVC."
            ),
            futurePrevention = "Limit transfusion rate to 1 mL/kg/hr (over 3-4 hours per unit), transfuse single units only, and administer prophylactic IV Furosemide (20mg) prior to or between units in patients with heart failure or CKD."
        ),
        TransfusionReactionProtocol(
            id = "reaction_fnhtr",
            reactionName = "FNHTR (Febrile Non-Hemolytic Transfusion Reaction)",
            severityLevel = "Mild to Moderate (Most common transfusion reaction: 1-2% of all transfusions)",
            clinicalPresentation = listOf(
                "Temperature rise ≥ 1.0°C (or ≥ 2°F) from baseline, or fever > 38.0°C during or within 2 hours of transfusion.",
                "Rigors, chills, mild malaise, headache.",
                "ABSENCE of hypotension, chest/flank pain, dyspnea, hemoglobinuria, or wheezing."
            ),
            pathophysiology = "Recipient antibodies reacting against donor white blood cell (leukocyte) HLA antigens, or infusion of accumulated pyrogenic cytokines (IL-1, IL-6, TNF-alpha) released from leukocytes during storage.",
            immediateStep1Action = "STOP TRANSFUSION temporarily. Rule out AHTR (check clerical details, inspect urine color). Once AHTR and sepsis are excluded, treat symptomatically.",
            pharmacotherapy = listOf(
                "Paracetamol (Acetaminophen) 1 g PO or IV.",
                "Meperidine (Pethidine) 25 - 50 mg IV if severe shaking rigors.",
                "Avoid routine Aspirin in thrombocytopenic patients."
            ),
            laboratoryInvestigations = listOf(
                "Clerical check confirmation.",
                "Visual inspection of post-reaction serum and urine (must be clear, non-hemolyzed).",
                "Direct Antiglobulin Test (DAT) is negative."
            ),
            futurePrevention = "Universal prestorage leukoreduction of cellular blood products virtually eliminates FNHTR. Use leukoreduced blood for future transfusions."
        ),
        TransfusionReactionProtocol(
            id = "reaction_bacterial_sepsis",
            reactionName = "Transfusion-Transmitted Bacterial Sepsis / Contamination",
            severityLevel = "Life-Threatening Emergency (High mortality, most common with Platelets)",
            clinicalPresentation = listOf(
                "Sudden explosive high-grade fever (>39°C), violent shaking rigors, nausea, vomiting, diarrhea.",
                "Profound refractory septic shock (SBP <70 mmHg), mottling, acute DIC within minutes of infusion.",
                "Platelet units are at highest risk because they are stored at room temperature (20°C–24°C)."
            ),
            pathophysiology = "Infusion of high bacterial inoculum or endotoxin from donor skin flora (Staphylococcus aureus, S. epidermidis) or asymptomatic donor bacteremia (Yersinia enterocolitica, Pseudomonas, Klebsiella, Serratia) multiplying during room temperature platelet storage.",
            immediateStep1Action = "STOP TRANSFUSION IMMEDIATELY. Clamp line, save the blood bag for Gram stain and blood culture. Aggressive sepsis resuscitation.",
            pharmacotherapy = listOf(
                "Immediate empiric broad-spectrum IV Antibiotics: Meropenem 1g IV + Vancomycin 15-20 mg/kg IV.",
                "Fluid resuscitation with Normal Saline (30 mL/kg bolus).",
                "Noradrenaline vasopressor infusion for refractory distributive shock."
            ),
            laboratoryInvestigations = listOf(
                "Send blood bag remnant and IV set immediately for urgent Gram stain and aerobic/anaerobic blood cultures.",
                "Draw separate peripheral blood cultures from patient (at least 2 sets from different venipuncture sites)."
            ),
            futurePrevention = "Adhere to strict platelet shelf life (max 5 days), automated bacterial screening of donor units, and donor arm skin disinfection protocols."
        )
    )
}
