package com.example.data.repository

import com.example.data.model.DiseaseProtocol

object AnesthesiologyProtocolsData {

    val protocols: List<DiseaseProtocol> = listOf(
        // 1. Malignant Hyperthermia (MH) Emergency Rescue Protocol
        DiseaseProtocol(
            id = "anes_mh",
            name = "Malignant Hyperthermia (MH) Emergency Protocol",
            category = "Anesthesiology & Perioperative",
            icd10 = "T88.3",
            diagnosticCriteria = "Hypermetabolic crisis triggered by volatile anesthetics (Sevoflurane, Isoflurane, Desflurane) or Succinylcholine. Hallmark early signs: Unexplained rapid rise in End-Tidal CO2 (EtCO2 >60-70 mmHg refractory to doubling minute ventilation), sinus tachycardia, masseter muscle rigidity (jaw cannot be opened after succinylcholine), generalized muscle rigidity. Late signs: Rapidly soaring core body temperature (>40°C-42°C rising 1°C every 5-10 min), mottled skin/cyanosis, profound combined metabolic and respiratory acidosis (arterial pH <7.15, base excess <-10), hyperkalemia (K+ >6.0 mEq/L), dark brown cola-colored urine (rhabdomyolysis / myoglobinuria), disseminated intravascular coagulation (DIC).",
            firstLine = "MHAUS & AAGBI RESUSCITATION ALGORITHM (IMMEDIATE SIMULTANEOUS ACTIONS):\n" +
                    "1. CALL FOR HELP & GET MH CART: State clearly 'This is a Malignant Hyperthermia Emergency'. Designate roles (medication prep, cooling, arterial line/labs, documentation).\n" +
                    "2. STOP TRIGGERING AGENTS: Immediately discontinue all volatile anesthetics and succinylcholine. Vaporizers off. DO NOT waste time changing the anesthesia machine in the crisis—switch to 100% Oxygen at MAXIMUM fresh gas flow (≥10 L/min). Place activated charcoal filters (Vapor-Clean) on inspiratory and expiratory limbs if available.\n" +
                    "3. DANTROLENE SODIUM (MANDATORY LIFE-SAVING ANTIDOTE):\n" +
                    "   • Initial Dose: 2.5 mg/kg IV rapid bolus immediately.\n" +
                    "   • Repeat Dosing: Give 1.0 to 2.5 mg/kg IV every 5 to 10 minutes until hypercapnia resolves, heart rate stabilizes, and rigidity subsides.\n" +
                    "   • Cumulative Dose: May require up to 10 mg/kg (or more in fulminant cases).\n" +
                    "   • Reconstitution: 20 mg vial requires 60 mL sterile water without preservatives; shake vigorously until clear (70 kg adult needs ~9 vials for first bolus). Modern formulation (Ryanodex): 250 mg in 5 mL.\n" +
                    "4. MAINTAIN ANESTHESIA: If surgery must continue, switch to clean intravenous anesthesia (Propofol infusion 100-200 mcg/kg/min + Fentanyl).",
            secondLine = "MANAGEMENT OF HYPERKALEMIA & ACIDOSIS:\n" +
                    "• Hyperkalemia (K+ >5.5 mEq/L): 10% Calcium Chloride 10 mL (or 10% Calcium Gluconate 30 mL) IV over 2-5 min (stabilizes cardiac membrane) PLUS Regular Insulin 10 units in 50 mL 50% Dextrose (D50W) IV bolus.\n" +
                    "• Severe Acidosis: Sodium Bicarbonate 1 to 2 mEq/kg IV titrated to arterial blood gas base deficit.\n" +
                    "• STRICT CONTRAINDICATION: NEVER administer Calcium Channel Blockers (Verapamil, Diltiazem) with Dantrolene (precipitates lethal myocardial depression, refractory hyperkalemia, and cardiovascular collapse).",
            inpatient = "ACTIVE COOLING & POST-CRISIS ICU CARE:\n" +
                    "• Active Cooling: Cold IV Normal Saline (4°C) up to 20-30 mL/kg; surface cooling with ice packs to axillae, groin, and neck; cold water orogastric/bladder lavage. STOP active cooling when core temperature reaches 38.5°C to avoid hypothermic overshoot.\n" +
                    "• Renal Protection: Maintain urine output >2 mL/kg/hour with IV fluids, Mannitol (0.25 g/kg), and Furosemide (0.5-1 mg/kg) to prevent acute tubular necrosis from myoglobinuria; alkalinize urine with bicarbonate.\n" +
                    "• ICU Monitoring (At least 36-48 Hours): Continuous arterial line, Foley with temperature sensor, serial ABG, serum potassium, CK (peaks at 12-24 hours), coagulation profile. Continue maintenance Dantrolene: 1.0 mg/kg IV every 4-6 hours (or 0.25 mg/kg/hr infusion) for at least 24 hours to prevent MH recrudescence (relapse occurs in 20-25%).",
            guidelines = "Malignant Hyperthermia Association of the United States (MHAUS 2024 Guidelines) & Association of Anaesthetists of Great Britain and Ireland (AAGBI).",
            keyDrugs = listOf("Dantrolene Sodium", "Sodium Bicarbonate", "Calcium Chloride", "Regular Insulin", "Propofol"),
            supportiveCare = "Continuous core temperature monitoring (esophageal or nasopharyngeal). Notify MHAUS Hotline (1-800-MH-HYPER). Refer patient and all first-degree relatives to a specialized malignant hyperthermia center for genetic testing (RYR1/CACNA1S gene mutation sequencing) and in vitro contracture test (IVCT / CHCT). Provide patient with a MedicAlert bracelet.",
            redFlags = "Sudden unexplained doubling of EtCO2, masseter spasm preventing laryngoscopy, ventricular tachycardia / fibrillation, core temp >41°C, dark port-wine urine.",
            references = listOf(
                "MHAUS Emergency Therapy for Malignant Hyperthermia (2024 Clinical Update)",
                "Hopkins PM, et al. European Malignant Hyperthermia Group guidelines for the management of malignant hyperthermia. Br J Anaesth. 2021;126(6):1208-1215",
                "Miller's Anesthesia, 9th Edition, Chapter 85: Malignant Hyperthermia",
                "AAGBI Safety Guideline: Management of a malignant hyperthermia crisis (2020 Update)"
            )
        ),

        // 2. Local Anesthetic Systemic Toxicity (LAST) Resuscitation Protocol
        DiseaseProtocol(
            id = "anes_last",
            name = "Local Anesthetic Systemic Toxicity (LAST) Protocol",
            category = "Anesthesiology & Perioperative",
            icd10 = "T88.59",
            diagnosticCriteria = "Life-threatening toxicity resulting from accidental intravascular injection, systemic absorption of excessive doses, or repeated local/regional anesthetic injections (Bupivacaine, Ropivacaine, Lidocaine). Initial CNS Excitation: Circumoral numbness, metallic taste, lightheadedness, auditory ringing (tinnitus), visual disturbances, dysarthria, facial twitching, progressing rapidly to tonic-clonic seizures. CNS Depression: Coma, apnea. Cardiovascular Collapse: Conduction delay, prolonged PR, wide QRS, severe bradycardia, ventricular arrhythmias (VT/VF), refractory arterial hypotension, and asystole (bupivacaine toxicity characteristically presents with sudden cardiovascular collapse without preceding seizures).",
            firstLine = "ASRA 2024 RESUSCITATION & 20% LIPID EMULSION ALGORITHM:\n" +
                    "1. STOP INJECTION IMMEDIATELY & CALL FOR HELP (State: 'LAST Emergency - Bring LAST Kit & 20% Lipid Emulsion').\n" +
                    "2. AIRWAY & OXYGENATION: 100% Oxygen immediately via bag-valve-mask or endotracheal intubation. Hyperventilate to prevent hypoxia, hypercapnia, and acidosis (acidosis drastically increases free toxic local anesthetic fraction and worsens myocardial toxicity).\n" +
                    "3. SEIZURE CONTROL: Benzodiazepines first-line: Midazolam 1 to 2 mg IV boluses (or Lorazepam 2-4 mg). AVOID large doses of Propofol (propofol causes severe cardiodepression in LAST; use only small doses 0.5 mg/kg if benzodiazepines unavailable).\n" +
                    "4. INTRALIPID 20% RESUSCITATION PROTOCOL (START IMMEDIATELY):\n" +
                    "   • Initial Bolus: 1.5 mL/kg IV of 20% Lipid Emulsion over 1 minute (~100 mL for a 70 kg adult).\n" +
                    "   • Continuous Infusion: 0.25 mL/kg/min IV immediately (~18 mL/min = ~1000 mL/hr for a 70 kg adult).\n" +
                    "   • Persistent Instability: Repeat 1.5 mL/kg IV bolus every 3-5 minutes (up to 2 repeat boluses; total 3 boluses) AND increase infusion to 0.5 mL/kg/min.\n" +
                    "   • Maximum Cumulative Dose: 12 mL/kg over the first hour.\n" +
                    "   • Continue infusion for at least 15 minutes after hemodynamic stability and sinus rhythm are fully restored.",
            secondLine = "MODIFIED ACLS CARDIAC LIFE SUPPORT (CRITICAL RESCUE ADJUSTMENTS):\n" +
                    "• REDUCED ADRENALINE (EPINEPHRINE) DOSES: Administer low-dose epinephrine (<1 mcg/kg IV, e.g. 10 to 50 mcg boluses in adults) instead of standard 1 mg ACLS boluses. High-dose epinephrine impairs lipid emulsion clearance, causes severe arrhythmias, and worsens myocardial ischemia.\n" +
                    "• DRUGS TO AVOID:\n" +
                    "  - AVOID Vasopressin (causes pulmonary edema and increases mortality).\n" +
                    "  - AVOID Calcium Channel Blockers and Beta-Blockers (amplify myocardial depression).\n" +
                    "  - AVOID Lidocaine or other local anesthetics (additive sodium-channel blockade).\n" +
                    "• Amiodarone: 300 mg IV first-line for ventricular arrhythmias.",
            inpatient = "PROLONGED CPR & EXTRACORPOREAL LIFE SUPPORT (ECLS / ECMO):\n" +
                    "• Continue chest compressions and CPR vigorously for 60 to 90 minutes or longer; lipid emulsion slowly extracts bupivacaine from cardiac myocytes ('Lipid Sink') and recovery with full neurological intactness is well documented even after >60 minutes of CPR.\n" +
                    "• Veno-Arterial ECMO / Cardiopulmonary Bypass: Early notification of perfusion team if patient does not respond to initial lipid boluses and low-dose epinephrine.\n" +
                    "• Post-Resuscitation ICU Monitoring: Minimum 4 to 6 hours for CNS symptoms; minimum 12 to 24 hours if cardiovascular collapse occurred (risk of delayed recurrent toxicity as lipid emulsion is metabolized).",
            guidelines = "American Society of Regional Anesthesia and Pain Medicine (ASRA 2024 Practice Advisory on Local Anesthetic Systemic Toxicity) & Association of Anaesthetists (AAGBI).",
            keyDrugs = listOf("Intralipid 20% (Lipid Emulsion)", "Midazolam", "Adrenaline (Low Dose)", "Amiodarone"),
            supportiveCare = "Prevention: Always aspirate before every local anesthetic injection; use ultrasound guidance; use test doses with epinephrine 1:200,000 (heart rate increase ≥10 bpm or SBP increase ≥15 mmHg within 30-45s indicates intravascular needle tip); adhere strictly to maximum weight-based limits (Bupivacaine 2 mg/kg, Lidocaine 4.5 mg/kg plain, 7 mg/kg with adrenaline).",
            redFlags = "Perioral numbness during injection, sudden grand mal seizure post-block, wide complex ventricular tachycardia, sudden unheralded cardiovascular collapse.",
            references = listOf(
                "Neal JM, et al. The American Society of Regional Anesthesia and Pain Medicine Practice Advisory on Local Anesthetic Systemic Toxicity. Reg Anesth Pain Med. 2024 Update",
                "AAGBI Safety Guideline: Management of Severe Local Anaesthetic Toxicity (2020)",
                "Miller's Anesthesia, 9th Edition, Chapter 32: Local Anesthetics",
                "LipidRescue.org Resuscitation Guidelines"
            )
        ),

        // 3. Rapid Sequence Intubation (RSI) Protocol
        DiseaseProtocol(
            id = "anes_rsi",
            name = "Rapid Sequence Intubation (RSI) & Aspiration Prophylaxis",
            category = "Anesthesiology & Perioperative",
            icd10 = "Z96.0",
            diagnosticCriteria = "Indicated for emergency endotracheal intubation in patients at high risk of regurgitation and pulmonary aspiration of gastric contents: Full stomach (unfasted emergency surgery, trauma, labor), delayed gastric emptying (bowel obstruction, severe pain, opioids, diabetes gastroparesis), increased intra-abdominal pressure (pregnancy >20 weeks, morbid obesity, acute abdomen, bowel distension), or active upper gastrointestinal bleeding / hematemesis.",
            firstLine = "THE 7 Ps OF RAPID SEQUENCE INTUBATION (STEPWISE PROTOCOL):\n" +
                    "1. PREPARATION (Zero-Minute - 10 min prior):\n" +
                    "   • SOAP-ME: Suction working (rigid Yankauer under pillow), Oxygen source verified, Airway equipment (laryngoscope handles, Macintosh 3/4, video-laryngoscope, ETT 7.0/7.5/8.0 with stylet bent like a hockey stick, 10mL syringe, bougie), Pharmaceuticals (induction + NMBA + vasopressor ready), Monitoring (ECG, NIBP q1min, SpO2, EtCO2).\n" +
                    "2. PRE-OXYGENATION (3 minutes prior):\n" +
                    "   • 100% FiO2 via tight-fitting mask with reservoir bag at 15 L/min for 3 minutes of tidal volume breathing OR 8 vital capacity breaths over 60 seconds (target End-Tidal O2 >85-90% to denitrogenate functional residual capacity and allow 5-8 minutes safe apnea time).\n" +
                    "   • Apneic Oxygenation: Apply nasal cannula at 15 L/min 100% O2 throughout intubation attempt.\n" +
                    "3. PRE-TREATMENT / PRE-MEDICATION (3 minutes prior - optional):\n" +
                    "   • Fentanyl 1.5 to 2 mcg/kg IV (blunts sympathetic surge in elevated ICP or aortic dissection).\n" +
                    "   • Atropine 0.02 mg/kg IV in infants <1 year (prevents succinylcholine bradycardia).\n" +
                    "4. PARALYSIS WITH INDUCTION (Time Zero - Rapid Sequential IV Push):\n" +
                    "   • Induction Agent Choice:\n" +
                    "     - Standard / Stable: Propofol 2.0 to 2.5 mg/kg IV.\n" +
                    "     - Shock / Sepsis / Trauma / Tamponade: Ketamine 1.5 to 2.0 mg/kg IV OR Etomidate 0.3 mg/kg IV.\n" +
                    "     - Status Epilepticus: Propofol 2 mg/kg IV or Thiopental 4 mg/kg IV.\n" +
                    "   • Paralytic Agent Choice:\n" +
                    "     - Succinylcholine: 1.0 to 1.5 mg/kg IV push (fastest onset 30-45s, duration 5-10 min) OR\n" +
                    "     - Rocuronium: 1.0 to 1.2 mg/kg IV push (high-dose RSI gives intubating conditions in 45-60s; duration 60-90 min; reversible immediately by Sugammadex 16 mg/kg).",
            secondLine = "AIRWAY PROTECTION & LARYNGOSCOPY:\n" +
                    "5. POSITIONING & CRICOID PRESSURE (Sellick Maneuver):\n" +
                    "   • Sniffing position (elevation of occiput with head extension) aligns oral, pharyngeal, and laryngeal axes (ramp position for morbidly obese).\n" +
                    "   • Cricoid Pressure: 10 Newtons upward force awake, increased to 30 Newtons upon loss of consciousness (presses cricoid cartilage against C6 vertebral body to occlude upper esophagus; release if intubation is impeded or if active vomiting occurs to prevent esophageal rupture).\n" +
                    "6. PLACEMENT WITH PROOF (45-60 seconds post-injection):\n" +
                    "   • Direct laryngoscopy or video-laryngoscopy without preceding positive pressure mask ventilation (avoids gastric insufflation). Pass ETT under direct visualization between vocal cords.\n" +
                    "   • CONFIRMATION (GOLD STANDARD): Continuous 4-phase End-Tidal CO2 waveform (EtCO2 >30 mmHg for ≥5 consecutive breaths) + bilateral equal breath sounds, absent epigastric sounds, chest rise, tube fogging.",
            inpatient = "POST-INTUBATION MANAGEMENT & VENTILATOR INITIATION:\n" +
                    "7. POST-INTUBATION CARE:\n" +
                    "   • Inflate cuff to 20-30 cmH2O (prevents mucosal ischemia and aspiration).\n" +
                    "   • Secure tube firmly; document centimeter depth at corner of lips (typically 21 cm in ♀, 23 cm in ♂).\n" +
                    "   • Initiate mechanical ventilation: Lung-protective tidal volume 6 to 8 mL/kg of predicted body weight, PEEP 5 cmH2O, RR 12-16/min to target EtCO2 35-40 mmHg.\n" +
                    "   • Initiate continuous maintenance sedation/analgesia immediately (Propofol or Midazolam + Opioid) so the patient does not regain consciousness while paralyzed.",
            guidelines = "Difficult Airway Society (DAS), American Society of Anesthesiologists (ASA) Practice Guidelines for Rapid Sequence Intubation.",
            keyDrugs = listOf("Succinylcholine", "Rocuronium", "Propofol", "Ketamine", "Etomidate", "Fentanyl", "Sugammadex"),
            supportiveCare = "In patients with anticipated difficult airway: DO NOT perform standard RSI with deep paralysis; prefer Awake Fiberoptic Intubation under topicalization with Dexmedetomidine, or Video-laryngoscopy with spontaneous breathing preserved.",
            redFlags = "Oxygen desaturation (SpO2 <90%) during intubation, esophageal intubation (flat-line EtCO2), regurgitation / active gastric contents in pharynx, cannot intubate cannot oxygenate crisis.",
            references = listOf(
                "Higgs A, et al. Guidelines for the management of tracheal intubation in critically ill adults. Br J Anaesth. 2018;120(2):323-352",
                "Wall R, et al. Manual of Emergency Airway Management, 6th Edition (2023)",
                "Miller's Anesthesia, 9th Edition, Chapter 44: Airway Management",
                "Difficult Airway Society (DAS) 2015 Guidelines"
            )
        ),

        // 4. Difficult Airway & Cannot Intubate, Cannot Oxygenate (CICO)
        DiseaseProtocol(
            id = "anes_cico",
            name = "Difficult Airway & CICO Rescue Protocol",
            category = "Anesthesiology & Perioperative",
            icd10 = "Z96.01",
            diagnosticCriteria = "Unanticipated difficult tracheal intubation or failed ventilation following induction of general anesthesia. Screened pre-op via LEMON criteria (Look externally, Evaluate 3-3-2 rule, Mallampati score III/IV, Obstruction/Obesity, Neck mobility <35°). CANNOT INTUBATE, CANNOT OXYGENATE (CICO) EMERGENCY: Defined as failed endotracheal intubation AND failed face mask ventilation AND failed supraglottic airway ventilation, leading to rapidly falling SpO2 (<80%), severe bradycardia, brain death, and impending cardiac arrest.",
            firstLine = "DIFFICULT AIRWAY SOCIETY (DAS) 4-STEP ALGORITHM:\n" +
                    "PLAN A: Facemask Ventilation & Tracheal Intubation:\n" +
                    "• Optimize positioning (head elevation / sniffing / ramped).\n" +
                    "• Maximize 100% O2 and maintain apneic oxygenation (nasal cannula 15 L/min).\n" +
                    "• Use Video-Laryngoscope (McGrath, GlideScope, C-MAC) with appropriate hyperangulated blade.\n" +
                    "• Use flexible tracheal introducer (Bougie).\n" +
                    "• STRICT LIMIT: MAXIMUM 3 ATTEMPTS at intubation (each attempt must incorporate an optimization step; 4th attempt only by senior expert). Excessive attempts cause pharyngeal trauma, bleeding, and airway edema.",
            secondLine = "PLAN B & PLAN C: Supraglottic Airway & Facemask Rescue:\n" +
                    "PLAN B: Supraglottic Airway Device (SAD / LMA) Insertion:\n" +
                    "• Insert Second-Generation Supraglottic Airway (e.g. i-gel, ProSeal LMA, Ambu AuraGain) immediately upon failed Plan A.\n" +
                    "• 2nd-gen SAD provides superior seal (>30 cmH2O) and gastric drainage port to vent stomach.\n" +
                    "• Confirm ventilation via EtCO2 waveform. If successful: STOP and oxygenate; consider intubation through LMA with Aintree catheter/fiberscope, or wake the patient up.\n" +
                    "• Maximum 3 SAD insertion attempts (change size or device if failed).\n\n" +
                    "PLAN C: Facemask Ventilation Rescue:\n" +
                    "• If SAD fails: Final attempt at facemask ventilation.\n" +
                    "• Two-Person Technique: Four-hand 'V-E' grip with oral Guedel airway and bilateral nasopharyngeal airways.\n" +
                    "• Declare CICO Crisis immediately if SpO2 continues to fall and face mask ventilation fails.",
            inpatient = "PLAN D: EMERGENCY FRONT OF NECK AIRWAY (eFONA / SURGICAL CRICOTHYROIDOTOMY):\n" +
                    "• DECLARE CICO LOUDLY: 'This is a CICO emergency. Call for surgical help and prepare for front-of-neck airway'.\n" +
                    "• Reverse rocuronium immediately with SUGAMMADEX 16 mg/kg IV push (may restore spontaneous breathing within 2-3 minutes).\n" +
                    "• SCALPEL - BOUGIE - TUBE TECHNIQUE (DAS GOLD STANDARD):\n" +
                    "  1. Extend neck fully (laryngeal handshake to identify thyroid cartilage, cricoid, and cricothyroid membrane).\n" +
                    "  2. Transverse stab incision through skin and cricothyroid membrane with No. 10 or 15 scalpel blade.\n" +
                    "  3. Rotate scalpel blade 90° so cutting edge faces caudally (feet), creating a patent opening.\n" +
                    "  4. Slide angled tip of coude-tip tracheal Bougie along scalpel flat into the trachea (confirm 'clicks' on tracheal rings or hold-up at carina).\n" +
                    "  5. Railroad cuffed Endotracheal Tube (Size 5.0 or 6.0 mm ID) over the bougie into trachea.\n" +
                    "  6. Inflate cuff, verify EtCO2, and secure tube.",
            guidelines = "Difficult Airway Society (DAS 2015 / 2022 Guidelines) & ASA Practice Guidelines for Management of the Difficult Airway.",
            keyDrugs = listOf("Sugammadex (16 mg/kg)", "Propofol", "Rocuronium", "Adrenaline"),
            supportiveCare = "All operating theaters, recovery areas, and ICUs must maintain a standardized Difficult Airway Trolley with clearly labeled Plan A, B, C, and D equipment including scalpel, bougie, size 5.0/6.0 cuffed tubes, and i-gel sizes 3, 4, 5.",
            redFlags = "Inability to maintain SpO2 >90%, vanishing capnography trace, blood/vomitus obscuring glottic visualization, declining heart rate indicating severe hypoxic bradycardia.",
            references = listOf(
                "Frerk C, et al. Difficult Airway Society 2015 guidelines for management of unanticipated difficult intubation in adults. Br J Anaesth. 2015;115(6):827-848",
                "Apfelbaum JL, et al. 2022 American Society of Anesthesiologists Practice Guidelines for Management of the Difficult Airway. Anesthesiology 2022;136:31-81",
                "Miller's Anesthesia, 9th Edition, Chapter 44: Airway Management",
                "DAS Scalpel-Bougie-Tube Cricothyroidotomy Protocol"
            )
        ),

        // 5. Spinal Anesthesia & Post-Dural Puncture Headache (PDPH)
        DiseaseProtocol(
            id = "anes_spinal_pdph",
            name = "Spinal Anesthesia & Post-Dural Puncture Headache (PDPH)",
            category = "Anesthesiology & Perioperative",
            icd10 = "G97.1",
            diagnosticCriteria = "Post-Dural Puncture Headache (PDPH): Severe, throbbing, postural bilateral frontal or occipital headache radiating to neck and shoulders, developing within 1 to 5 days following lumbar puncture, spinal anesthesia, or accidental dural puncture during epidural insertion. Hallmark Diagnostic Feature: Markedly WORSENS when sitting or standing upright; RAPIDLY RELIEVED or completely resolves when lying flat (supine). Associated symptoms: Neck stiffness, nausea, photophobia, tinnitus, muffled hearing, hyperacusis, or diplopia (due to 6th cranial nerve abducens traction).",
            firstLine = "SPINAL ANESTHESIA TECHNIQUE & HYPOTENSION MANAGEMENT:\n" +
                    "• Technique: L3-L4 or L4-L5 interspace identified via Tuffier's line (iliac crests). Use atraumatic pencil-point needles (Whitacre or Sprotte 25G or 27G) which separate rather than cut dural fibers, reducing PDPH incidence from 10-30% (with cutting Quincke needles) down to <1-2%.\n" +
                    "• DRUG DOSING (0.5% Heavy Bupivacaine in 8% Dextrose):\n" +
                    "  - Cesarean Delivery: 1.8 to 2.2 mL (9-11 mg) + Fentanyl 15-20 mcg.\n" +
                    "  - Lower Abdominal / Orthopedic: 2.5 to 3.0 mL (12.5-15 mg).\n" +
                    "• SPINAL HYPOTENSION PROTOCOL (Mandatory Proactive Management):\n" +
                    "  - Intravenous Co-loading: Rapid infusion of 1000 mL warm Ringer's Lactate simultaneously with spinal injection.\n" +
                    "  - Vasopressors of Choice:\n" +
                    "    1. Phenylephrine: 50 to 100 mcg IV bolus (or continuous infusion 25-50 mcg/min) - preferred in cesarean delivery to prevent fetal acidosis.\n" +
                    "    2. Ephedrine: 6 to 12 mg IV bolus (if maternal heart rate <60 bpm, acts via beta-1 and alpha-1 stimulation).\n" +
                    "    3. Left Uterine Displacement (LUD): 15° wedge under right hip in pregnant women to relieve aortocaval compression by the gravid uterus.",
            secondLine = "CONSERVATIVE MANAGEMENT OF PDPH:\n" +
                    "• Bed rest in horizontal supine position as tolerated.\n" +
                    "• Aggressive Oral & IV Hydration: 2.5 to 3.5 Liters/day (stimulates CSF production by choroid plexus).\n" +
                    "• Multimodal Analgesia: Paracetamol 1000 mg PO QID + Ibuprofen 400 mg PO TID + Tramadol/Codeine for breakthrough pain.\n" +
                    "• Oral Caffeine: Caffeine 300 to 500 mg PO daily (or IV Caffeine Benzoate 500 mg) - causes cerebral vasoconstriction, providing temporary symptom relief in ~70%.\n" +
                    "• Sphenopalatine Ganglion Block (SPGB): Non-invasive transnasal application of 2% or 4% Lidocaine-soaked long cotton swabs applied into the posterior nasopharynx for 10-15 minutes (rapidly relieves headache in up to 80% without procedural risks).",
            inpatient = "EPIDURAL BLOOD PATCH (EBP - DEFINITIVE GOLD STANDARD):\n" +
                    "• Indications: Severe, incapacitating PDPH unresponsive to conservative therapy for >24-48 hours, or restricting activities of daily living/neonatal care.\n" +
                    "• Technique (Strict Aseptic 2-Operator Protocol):\n" +
                    "  1. Operator 1 identifies the epidural space at the level of prior dural puncture (or one interspace lower) using loss-of-resistance to saline.\n" +
                    "  2. Operator 2 simultaneously draws 15 to 20 mL of AUTOLOGOUS BLOOD from patient's antecubital vein under strict sterile conditions.\n" +
                    "  3. Inject autologous blood slowly through the epidural needle over 2-3 minutes. STOP injection immediately if patient reports significant back, leg, or neck pressure.\n" +
                    "  4. Keep patient in flat supine position for 1 to 2 hours post-procedure.\n" +
                    "• Efficacy: >85-90% immediate complete resolution after first patch (second patch succeeds in >95% of initial failures).",
            guidelines = "American Society of Regional Anesthesia and Pain Medicine (ASRA Practice Advisory on Regional Anesthesia) & International Headache Society (ICHD-3).",
            keyDrugs = listOf("Bupivacaine Heavy", "Phenylephrine", "Ephedrine", "Paracetamol", "Caffeine", "Lignocaine (Lidocaine)"),
            supportiveCare = "Counsel patient that PDPH is caused by CSF leakage reducing intracranial CSF volume, causing downward brain traction on pain-sensitive meninges and cranial nerves. Advise avoidance of strenuous lifting and straining for 7 days post-EBP.",
            redFlags = "Fever, localized severe back pain with progressive neurological deficits (leg weakness, numbness, bowel/bladder incontinence) suggesting Epidural Abscess or Epidural Hematoma (requires emergent STAT MRI and neurosurgical decompression within 6 hours to prevent permanent paralysis).",
            references = listOf(
                "Russell R, et al. Post-dural puncture headache: a code of practice. Int J Obstet Anesth. 2019;37:4-16",
                "Kwak KH. Post-dural puncture headache. Korean J Anesthesiol. 2017;70(2):136-143",
                "Miller's Anesthesia, 9th Edition, Chapter 75: Obstetric Anesthesia",
                "ASRA Guidelines on Obstetric and Neuraxial Anesthesia"
            )
        ),

        // 6. ASA Preoperative Fasting (NPO 2-4-6-8 Guidelines)
        DiseaseProtocol(
            id = "anes_npo",
            name = "ASA Preoperative Fasting Guidelines (NPO 2-4-6-8 Rule)",
            category = "Anesthesiology & Perioperative",
            icd10 = "Z91.89",
            diagnosticCriteria = "Standardized evidence-based preoperative fasting guidelines established by the American Society of Anesthesiologists (ASA) and European Society of Anaesthesiology and Intensive Care (ESAIC) to balance the prevention of pulmonary aspiration of gastric contents (Mendelson Syndrome) against the adverse effects of prolonged dehydration, hypoglycemia, ketoacidosis, and patient distress.",
            firstLine = "THE ASA EVIDENCE-BASED 2-4-6-8 FASTING SCHEDULE:\n" +
                    "1. CLEAR LIQUIDS: Minimum Fasting Time = 2 HOURS:\n" +
                    "   • Permitted: Plain water, clear apple juice (pulp-free), clear grape juice, black coffee or plain tea WITHOUT MILK, carbohydrate-rich clear preoperative drinks (reduces insulin resistance and thirst).\n" +
                    "   • NOT Permitted: Any liquid with milk, creamer, alcoholic beverages, particulate fruit juice (orange juice with pulp).\n" +
                    "2. BREAST MILK: Minimum Fasting Time = 4 HOURS:\n" +
                    "   • Applies to infants and neonates receiving unfortified human breast milk (empties faster than formula).\n" +
                    "3. INFANT FORMULA: Minimum Fasting Time = 6 HOURS:\n" +
                    "   • Applies to commercial infant formula.\n" +
                    "4. NON-HUMAN MILK (Cow's / Buffalo / Soy Milk): Minimum Fasting Time = 6 HOURS:\n" +
                    "   • Milk protein curdles in the gastric acid, forming curds that empty at the rate of solid food.\n" +
                    "5. LIGHT MEAL: Minimum Fasting Time = 6 HOURS:\n" +
                    "   • Defined as plain toast, plain crackers, and clear liquids.\n" +
                    "6. FRIED, FATTY MEALS OR MEAT: Minimum Fasting Time = 8 HOURS (OR MORE):\n" +
                    "   • Meals containing significant fat, oil, fried items, or meat markedly delay gastric emptying. Fasting of 8 hours or longer is required.",
            secondLine = "SPECIAL CLINICAL POPULATIONS & DELAYED GASTRIC EMPTYING:\n" +
                    "• Patients with Delayed Gastric Emptying regardless of fasting duration:\n" +
                    "  - Laboring women in active labor (stomach remains full throughout labor; manage as full stomach).\n" +
                    "  - Major trauma, severe pain, or opioid administration (trauma halts gastric motility).\n" +
                    "  - Bowel obstruction, ileus, acute peritonitis, acute pancreatitis.\n" +
                    "  - Diabetic gastroparesis, severe morbid obesity, advanced gastroesophageal reflux disease (GERD).\n" +
                    "• Management in Delayed Gastric Emptying: MUST perform Rapid Sequence Intubation (RSI) with cricoid pressure and cuffed endotracheal tube, or Gastric Ultrasound assessment of antral cross-sectional area (CSA) to assess gastric volume.",
            inpatient = "PHARMACOLOGICAL ASPIRATION PROPHYLAXIS (PRE-MEDICATION):\n" +
                    "• Indicated for high-risk patients (pregnant women, hiatus hernia, morbid obesity, emergency surgery):\n" +
                    "  1. Non-Particulate Antacid: 30 mL of 0.3 M Sodium Citrate PO given 15-30 minutes prior to induction (instantly raises gastric fluid pH >2.5 without particulate lung damage).\n" +
                    "  2. H2 Receptor Antagonist: Ranitidine 50 mg IV or Famotidine 20 mg IV given at least 60-90 minutes prior to induction (suppresses gastric acid secretion).\n" +
                    "  3. Proton Pump Inhibitor (PPI): Pantoprazole 40 mg IV or Omeprazole 40 mg IV given 2 hours prior.\n" +
                    "  4. Prokinetic: Metoclopramide 10 mg IV given 30-60 minutes prior (increases lower esophageal sphincter tone and accelerates gastric emptying; contraindicated in mechanical bowel obstruction).",
            guidelines = "American Society of Anesthesiologists (ASA 2023 Practice Guidelines for Preoperative Fasting) & ESAIC Guidelines.",
            keyDrugs = listOf("Sodium Citrate", "Pantoprazole", "Metoclopramide", "Famotidine"),
            supportiveCare = "Encourage clear fluids up to 2 hours before elective surgery to prevent hypovolemia, particularly in children and elderly patients. Avoid arbitrary prolonged overnight fasting (e.g. 'NPO after midnight' for an afternoon case causes unnecessary hypovolemia, difficult venous cannulation, and post-op nausea).",
            redFlags = "Active regurgitation during induction, particulate food aspirated into tracheobronchial tree (bronchospasm, severe hypoxemia, atelectasis, Mendelson chemical pneumonitis).",
            references = listOf(
                "Joshi GP, et al. 2023 American Society of Anesthesiologists Practice Guidelines for Preoperative Fasting. Anesthesiology 2023;138:132-151",
                "Practice Guidelines for Preoperative Fasting. Anesthesiology 2017;126:376-393",
                "Miller's Anesthesia, 9th Edition, Chapter 34: Preoperative Evaluation",
                "ESAIC Pre-operative fasting in adults and children guideline"
            )
        )
    )
}
