package com.example.data.repository

import com.example.data.model.SurgicalPreOpDrug

object SurgicalPreOpData {

    val preOpDrugs: List<SurgicalPreOpDrug> = listOf(
        // ==========================================
        // ANTIPLATELETS
        // ==========================================
        SurgicalPreOpDrug(
            id = "preop_aspirin",
            drugName = "Aspirin (Acetylsalicylic Acid - 75-150 mg)",
            drugClass = "Antiplatelet",
            cessationWindow = "Continue for most procedures OR hold 5-7 days for closed-space surgery",
            lowBleedRiskAction = "Continue without interruption for minor procedures (dental, cataract, skin biopsy, endoscopy without polypectomy). Secondary prevention benefits in cardiovascular disease outweigh minor bleeding.",
            highBleedRiskAction = "Hold 5 to 7 days prior ONLY for closed-space surgeries with catastrophic bleeding consequence: Neurosurgery (intracranial/spinal canal), posterior chamber ophthalmic surgery, and major transurethral prostatectomy.",
            bridgingProtocol = "Do NOT bridge aspirin with heparin or LMWH; bridging increases bleeding without reducing thrombotic risk.",
            resumptionTimeline = "Resume 24 hours post-operatively once surgical hemostasis is verified (or as soon as oral intake is established).",
            emergencyReversalAgent = "Platelet transfusion (Aspirin causes irreversible COX-1 inhibition for the 7-10 day lifespan of the platelet).",
            clinicalRationale = "Irreversibly acetylates platelet cyclooxygenase-1 (COX-1), blocking thromboxane A2 synthesis. Platelet turnover replaces ~10-15% of circulating platelets daily.",
            specialPrecautions = "In patients with recent drug-eluting coronary stents (<6 months) or bare metal stents (<1 month), elective non-cardiac surgery should be deferred. If urgent, continue aspirin throughout perioperative period."
        ),

        SurgicalPreOpDrug(
            id = "preop_clopidogrel",
            drugName = "Clopidogrel (Plavix, Clopilet - 75 mg)",
            drugClass = "Antiplatelet",
            cessationWindow = "Hold 5 days prior to elective surgery",
            lowBleedRiskAction = "May continue for low-bleeding-risk minor procedures if high stent thrombosis risk; discuss with interventional cardiologist.",
            highBleedRiskAction = "Discontinue 5 full days prior to elective surgery with moderate-to-high bleeding risk.",
            bridgingProtocol = "Bridging is generally not recommended. If coronary stent is very recent (<3 months) and surgery cannot be delayed, consider bridging with short-acting IV glycoprotein IIb/IIIa inhibitors (tirofiban/eptifibatide) in ICU, stopped 4-6 hours pre-op.",
            resumptionTimeline = "Resume 24-48 hours post-operatively (loading dose 300 mg can be considered if rapid platelet inhibition needed and hemostasis is complete).",
            emergencyReversalAgent = "Platelet transfusion (pool of 1-2 adult doses) + IV Desmopressin (DDAVP 0.3 mcg/kg).",
            clinicalRationale = "Irreversible antagonist of platelet P2Y12 adenosine diphosphate (ADP) receptors. Requires 5 days for sufficient newly formed uninhibited platelets to normalize hemostasis.",
            specialPrecautions = "Avoid premature discontinuation in patients with recent acute coronary syndrome or coronary stenting (stent thrombosis carries 20-40% mortality)."
        ),

        SurgicalPreOpDrug(
            id = "preop_ticagrelor",
            drugName = "Ticagrelor (Brilinta - 90 mg BID)",
            drugClass = "Antiplatelet",
            cessationWindow = "Hold 3 to 5 days prior to surgery",
            lowBleedRiskAction = "Can be continued in minor procedures if ischemic risk is very high.",
            highBleedRiskAction = "Hold for 3 to 5 days prior to elective surgery (3 days per 2022 ESC guidelines; 5 days per FDA labeling).",
            bridgingProtocol = "Routine bridging not advised.",
            resumptionTimeline = "Resume 24 to 48 hours postoperatively once adequate hemostasis is established (90 mg PO BID; no loading dose needed).",
            emergencyReversalAgent = "Platelet transfusion has limited efficacy because circulating free drug inhibits transfused platelets. Reversal monoclonal antibody PB2452 (Bentracimab) where available; otherwise consider Desmopressin + TXA.",
            clinicalRationale = "Direct-acting, reversible P2Y12 inhibitor. Off-rate is faster than clopidogrel/prasugrel, allowing a shorter 3-5 day clearance window.",
            specialPrecautions = "Faster offset than clopidogrel, but higher bleeding potency if surgery occurs before 3 days."
        ),

        // ==========================================
        // ANTICOAGULANTS (DOACs & WARFARIN)
        // ==========================================
        SurgicalPreOpDrug(
            id = "preop_apixaban",
            drugName = "Apixaban (Eliquis - 2.5 mg / 5 mg BID)",
            drugClass = "Anticoagulant (DOAC)",
            cessationWindow = "Hold 24-48 hours based on renal function & bleeding risk",
            lowBleedRiskAction = "Hold 24 hours prior (skip 2 doses: evening before and morning of surgery).",
            highBleedRiskAction = "Hold 48 hours prior (skip 4 doses) if CrCl ≥30 mL/min. If CrCl <30 mL/min, hold 72 hours prior.",
            bridgingProtocol = "DO NOT BRIDGE: Bridging DOACs with heparin/LMWH is strictly contraindicated because rapid onset/offset of DOACs makes bridging unnecessary and substantially increases major bleeding (BRIDGE and PAUSE trials).",
            resumptionTimeline = "Low bleed risk: Resume 24 hours post-op. High bleed risk: Resume 48-72 hours post-op (consider prophylactic low-dose LMWH 40 mg daily in interim if high VTE risk).",
            emergencyReversalAgent = "Andexanet alfa (specific factor Xa decoy) or 4-factor Prothrombin Complex Concentrate (4F-PCC 50 IU/kg IV) + Tranexamic acid 1 g IV.",
            clinicalRationale = "Direct competitive factor Xa inhibitor. Plasma half-life ~12 hours. 48 hours corresponds to 4 half-lives, leaving <6% residual anticoagulant effect.",
            specialPrecautions = "For neuraxial anesthesia (spinal/epidural), wait at least 72 hours after last dose before needle placement, and remove catheter at least 6 hours before next dose."
        ),

        SurgicalPreOpDrug(
            id = "preop_rivaroxaban",
            drugName = "Rivaroxaban (Xarelto - 10 mg / 15 mg / 20 mg OD)",
            drugClass = "Anticoagulant (DOAC)",
            cessationWindow = "Hold 24-48 hours based on renal function & bleed risk",
            lowBleedRiskAction = "Hold 24 hours prior (skip morning/evening dose the day before surgery).",
            highBleedRiskAction = "Hold 48 hours prior (skip 2 daily doses). If CrCl 30-50 mL/min, hold 72 hours prior (increased renal accumulation).",
            bridgingProtocol = "DO NOT BRIDGE: Bridging DOACs is unnecessary and markedly increases surgical site hematomas.",
            resumptionTimeline = "Low bleed risk: Resume 24 hours post-op. High bleed risk: Resume 48-72 hours post-op once surgical hemostasis is secure.",
            emergencyReversalAgent = "Andexanet alfa or 4-Factor PCC (50 IU/kg IV stat) + IV Tranexamic acid.",
            clinicalRationale = "Direct factor Xa inhibitor with 33% renal elimination of active drug. Half-life ~5-9 hours in young; 11-13 hours in elderly.",
            specialPrecautions = "Neuraxial anesthesia requires minimum 72-hour delay. Assess renal function (CrCl) before scheduling surgery."
        ),

        SurgicalPreOpDrug(
            id = "preop_dabigatran",
            drugName = "Dabigatran Etexilate (Pradaxa - 110 mg / 150 mg BID)",
            drugClass = "Anticoagulant (DOAC)",
            cessationWindow = "Hold 24 to 96 hours strictly based on eGFR / CrCl",
            lowBleedRiskAction = "CrCl ≥50 mL/min: Hold 24 hours. CrCl 30-49 mL/min: Hold 48 hours.",
            highBleedRiskAction = "CrCl ≥50 mL/min: Hold 48 hours. CrCl 30-49 mL/min: Hold 72 to 96 hours (80% renal clearance causes marked accumulation in renal impairment).",
            bridgingProtocol = "Do NOT bridge with heparin/LMWH.",
            resumptionTimeline = "Low bleed risk: Resume 24 hours post-op. High bleed risk: Resume 48-72 hours post-op.",
            emergencyReversalAgent = "Idarucizumab (Praxbind 5 g IV: two 2.5 g vials given IV push within 15 minutes; immediately neutralizes 100% of dabigatran activity within minutes).",
            clinicalRationale = "Direct thrombin (Factor IIa) inhibitor. 80% cleared unchanged by the kidneys; half-life extends from 12 hours up to 28 hours in renal impairment.",
            specialPrecautions = "Idarucizumab is available and uniquely provides immediate total reversal for emergency life-threatening trauma/surgery within 15 minutes."
        ),

        SurgicalPreOpDrug(
            id = "preop_warfarin",
            drugName = "Warfarin Sodium / Acenocoumarol (Coumadin / Acitrom)",
            drugClass = "Anticoagulant (VKA)",
            cessationWindow = "Hold 5 days prior (Target INR <1.5 on day of surgery)",
            lowBleedRiskAction = "Minor procedures (dental extraction, cataract, joint injection): Continue warfarin if INR is in therapeutic range (2.0-2.5) with local hemostatic agents (tranexamic acid mouthwash).",
            highBleedRiskAction = "Discontinue 5 days prior to surgery. Check INR on the day before and morning of surgery; if INR >1.5, administer oral Vitamin K1 (1-2 mg PO).",
            bridgingProtocol = "BRIDGE ONLY HIGH THROMBOEMBOLIC RISK PATIENTS: Mechanical mitral valve, mechanical aortic valve with risk factors, AF with CHA2DS2-VASc ≥7, stroke/TIA within 3 months, or VTE within 3 months. Protocol: Stop warfarin Day -5; start therapeutic LMWH (Enoxaparin 1 mg/kg BID or 1.5 mg/kg OD) on Day -3; stop LMWH 24 hours before surgery (Day -1 morning dose). Low/moderate risk: Do NOT bridge (PERIOP trial).",
            resumptionTimeline = "Resume warfarin evening of surgery or next day (Day +1) at normal maintenance dose. If bridging was used, restart LMWH 24-72 hrs post-op until INR ≥2.0.",
            emergencyReversalAgent = "4-Factor PCC (25-50 IU/kg IV based on INR) + IV Phytomenadione (Vitamin K1 5-10 mg slow IV) -> normalizes INR in 10-15 minutes.",
            clinicalRationale = "Vitamin K antagonist inhibiting factors II, VII, IX, and X. Factor II (prothrombin) has a half-life of 60 hours, requiring 5 days for INR to drop <1.5.",
            specialPrecautions = "Acenocoumarol (Acitrom) has a shorter half-life (8-11 hrs); holding 3-4 days is generally sufficient compared to 5 days for warfarin."
        ),

        // ==========================================
        // DIABETES & METABOLIC MEDICATIONS
        // ==========================================
        SurgicalPreOpDrug(
            id = "preop_sglt2i",
            drugName = "SGLT2 Inhibitors (Dapagliflozin, Empagliflozin, Canagliflozin)",
            drugClass = "Diabetes / Metabolic",
            cessationWindow = "Hold 3 to 4 days prior to surgery",
            lowBleedRiskAction = "Hold 3 days prior (Dapagliflozin/Empagliflozin) or 4 days prior (Canagliflozin) for ALL surgical procedures requiring sedation or general anesthesia.",
            highBleedRiskAction = "Hold 3-4 days prior. Ensure perioperative blood glucose and serum beta-hydroxybutyrate / ketones are monitored.",
            bridgingProtocol = "Transition to insulin if blood glucose >180 mg/dL while off SGLT2i.",
            resumptionTimeline = "Resume ONLY once patient is fully recovered, tolerating normal oral diet and hydration, and risk of post-op surgical stress/dehydration has resolved.",
            emergencyReversalAgent = "IV Dextrose + IV Regular Insulin infusion (to suppress lipolysis and ketogenesis) + IV fluids for euglycemic DKA.",
            clinicalRationale = "CRITICAL: Surgical stress, fasting, and volume depletion combined with SGLT2i trigger life-threatening Euglycemic Diabetic Ketoacidosis (euDKA, normal/mildly elevated blood sugar <250 mg/dL with severe metabolic acidosis and positive ketones).",
            specialPrecautions = "Educate surgical team that normal blood glucose does NOT rule out DKA in patients taking SGLT2 inhibitors; check blood gas pH, anion gap, and ketones."
        ),

        SurgicalPreOpDrug(
            id = "preop_metformin",
            drugName = "Metformin Hydrochloride",
            drugClass = "Diabetes / Metabolic",
            cessationWindow = "Hold morning of surgery (or 48 hrs prior if IV contrast / renal risk)",
            lowBleedRiskAction = "Omit dose on morning of procedure.",
            highBleedRiskAction = "Hold 24-48 hours prior if major surgery with hemodynamic instability, potential for acute kidney injury, or intraoperative IV iodinated radiocontrast.",
            bridgingProtocol = "Subcutaneous regular or rapid-acting insulin sliding scale for blood glucose >180 mg/dL.",
            resumptionTimeline = "Resume 48 hours postoperatively ONLY after checking serum creatinine and confirming normal renal function and hemodynamic stability.",
            emergencyReversalAgent = "Hemodialysis removes metformin and corrects lactic acidosis in acute toxicity.",
            clinicalRationale = "Risk of Metformin-Associated Lactic Acidosis (MALA) if perioperative hypoperfusion, sepsis, acute kidney injury, or contrast-induced nephropathy develops.",
            specialPrecautions = "Never restart until oral intake is established and serum creatinine is documented to be baseline."
        ),

        SurgicalPreOpDrug(
            id = "preop_sulfonylureas",
            drugName = "Sulfonylureas (Glimepiride, Gliclazide, Glibenclamide)",
            drugClass = "Diabetes / Metabolic",
            cessationWindow = "Hold morning of surgery",
            lowBleedRiskAction = "Omit dose on morning of surgery while fasting.",
            highBleedRiskAction = "Omit morning of surgery (for long-acting glibenclamide, omit evening dose before surgery as well).",
            bridgingProtocol = "Intravenous dextrose 5% infusion + short-acting insulin sliding scale.",
            resumptionTimeline = "Resume once patient is tolerating regular oral meals postoperatively.",
            emergencyReversalAgent = "IV 25% or 50% Dextrose bolus + Octreotide (50-100 mcg SC/IV q8h to suppress sulfonylurea-stimulated insulin secretion in refractory hypoglycemia).",
            clinicalRationale = "Stimulate endogenous pancreatic insulin release independent of ambient blood glucose; taking while nil-per-os (NPO) produces severe intra-operative hypoglycemia under anesthesia.",
            specialPrecautions = "Hypoglycemia under general anesthesia is masked (loss of adrenergic sweating, tachycardia, tremors) and causes irreversible brain damage."
        ),

        SurgicalPreOpDrug(
            id = "preop_glp1",
            drugName = "GLP-1 Receptor Agonists (Semaglutide, Liraglutide, Dulaglutide)",
            drugClass = "Diabetes / Metabolic",
            cessationWindow = "Hold 1 week prior for weekly formulations; hold day-of for daily",
            lowBleedRiskAction = "ASA Guideline: Hold weekly injections (Ozempic/Wegovy) for 1 week prior; hold daily injections (Victoza) on morning of surgery.",
            highBleedRiskAction = "Hold 1 week prior to elective surgery under general anesthesia or deep sedation.",
            bridgingProtocol = "Insulin therapy as needed for glycemic targets.",
            resumptionTimeline = "Resume postoperatively once oral intake is normal.",
            emergencyReversalAgent = "Preoperative gastric ultrasound to assess residual gastric contents; rapid sequence intubation (RSI) with cricoid pressure if stomach is full.",
            clinicalRationale = "Markedly delay gastric emptying; patients presenting for elective surgery after standard 8-hour fasting still have large residual solid gastric volumes, creating catastrophic pulmonary aspiration risk during anesthetic induction.",
            specialPrecautions = "If GLP-1 was NOT held before surgery, treat the patient as having a 'full stomach' (proceed with gastric ultrasound or awake fiberoptic intubation/RSI)."
        ),

        // ==========================================
        // CARDIOVASCULAR & ANTIHYPERTENSIVES
        // ==========================================
        SurgicalPreOpDrug(
            id = "preop_acei_arb",
            drugName = "ACE Inhibitors & ARBs (Enalapril, Ramipril, Losartan, Telmisartan)",
            drugClass = "Cardiovascular / Antihypertensive",
            cessationWindow = "Hold morning of surgery (Hold 24 hours prior)",
            lowBleedRiskAction = "Omit on morning of surgery.",
            highBleedRiskAction = "Withhold dose for 24 hours prior to general anesthesia.",
            bridgingProtocol = "Not needed. Treat severe perioperative hypertension with short-acting IV agents (labetalol, nicardipine, hydralazine).",
            resumptionTimeline = "Resume 24 to 48 hours postoperatively once patient is hemodynamically stable, euvolemic, and serum creatinine is stable.",
            emergencyReversalAgent = "IV Vasopressin (0.01-0.04 units/min) or Terlipressin / Norepinephrine (ACEi-induced refractory vasoplegia is resistant to standard phenylephrine/ephedrine).",
            clinicalRationale = "Blunts the renin-angiotensin-aldosterone compensatory response during anesthesia induction and blood loss, precipitating refractory intraoperative hypotension (vasoplegic shock).",
            specialPrecautions = "If patient accidentally took their morning ACEi/ARB, warn the anesthesiologist to have IV vasopressin or norepinephrine immediately drawn up and ready."
        ),

        SurgicalPreOpDrug(
            id = "preop_beta_blockers",
            drugName = "Beta-Blockers (Atenolol, Metoprolol, Bisoprolol, Carvedilol)",
            drugClass = "Cardiovascular / Antihypertensive",
            cessationWindow = "CONTINUE without interruption on morning of surgery",
            lowBleedRiskAction = "Take usual morning dose with a sip of water.",
            highBleedRiskAction = "Continue through morning of surgery.",
            bridgingProtocol = "If patient cannot take oral medications post-op, switch to IV equivalent (IV Metoprolol 2.5-5 mg q6h or IV Labetalol).",
            resumptionTimeline = "Continue immediately post-op.",
            emergencyReversalAgent = "IV Glucagon (3-5 mg bolus followed by infusion) or IV High-Dose Insulin Euglycemia Therapy (HIET) for beta-blocker overdose/toxicity.",
            clinicalRationale = "CRITICAL: Abrupt cessation of chronic beta-blocker therapy causes severe rebound sympathetic hyperactivity, tachycardia, malignant arrhythmias, myocardial ischemia, and death.",
            specialPrecautions = "Never discontinue chronic beta-blockers perioperatively. Conversely, do NOT initiate high-dose beta-blockers on the day of surgery in beta-blocker-naive patients (POISE trial: increases stroke and mortality)."
        ),

        // ==========================================
        // IMMUNOSUPPRESSANTS & RHEUMATOLOGY
        // ==========================================
        SurgicalPreOpDrug(
            id = "preop_steroids",
            drugName = "Systemic Corticosteroids (Prednisolone, Dexamethasone, Hydrocortisone)",
            drugClass = "Immunosuppressant / Endocrine",
            cessationWindow = "CONTINUE + Administer Stress-Dose Steroids for major surgery",
            lowBleedRiskAction = "Take usual morning dose with sip of water. Minor surgery (dental/local): No stress dose required.",
            highBleedRiskAction = "Moderate Surgery (cholecystectomy, hernia, total joint): Usual morning dose + IV Hydrocortisone 50 mg at induction, then 25 mg q8h for 24 hours. Major Surgery (coronary bypass, Whipple, esophagectomy): Usual morning dose + IV Hydrocortisone 100 mg at induction, then 50 mg q8h for 48-72 hours, then taper.",
            bridgingProtocol = "Intravenous Hydrocortisone replaces oral prednisolone (5 mg oral prednisolone = 20 mg IV hydrocortisone).",
            resumptionTimeline = "Taper back to baseline home dose over 48-72 hours as surgical stress abates.",
            emergencyReversalAgent = "Stat IV Hydrocortisone 100 mg bolus + 0.9% Normal Saline fluid resuscitation for acute Addisonian / adrenal crisis (hypotension, hyperkalemia, hypoglycemia).",
            clinicalRationale = "Patients receiving ≥5 mg prednisolone equivalent daily for >3 weeks have suppressed Hypothalamic-Pituitary-Adrenal (HPA) axis and cannot mount an endogenous cortisol surge, triggering fatal Addisonian collapse under surgical stress.",
            specialPrecautions = "Always document chronic steroid use and clearly prescribe the stress-dose protocol on the pre-anesthetic chart."
        ),

        SurgicalPreOpDrug(
            id = "preop_biologics",
            drugName = "Biologic DMARDs & Anti-TNF (Infliximab, Adalimumab, Etanercept, Rituximab)",
            drugClass = "Immunosuppressant / Biologic",
            cessationWindow = "Schedule surgery at the end of the dosing cycle",
            lowBleedRiskAction = "Schedule surgery at the trough level (just before next scheduled injection/infusion).",
            highBleedRiskAction = "Stop 1 dosing interval prior to surgery (e.g. Adalimumab: stop 2 weeks prior; Infliximab: stop 6-8 weeks prior; Etanercept: stop 1-2 weeks prior).",
            bridgingProtocol = "Can use low-dose oral corticosteroids or non-biologics to control disease flare.",
            resumptionTimeline = "Restart 14 days post-operatively ONLY after surgical wound is completely healed, sutures/staples removed, and no evidence of active infection.",
            emergencyReversalAgent = "No direct reversal agent. Treat infections aggressively with broad-spectrum antimicrobials.",
            clinicalRationale = "Significantly impair wound healing and increase risk of catastrophic prosthetic joint infections, deep surgical site infections, and sepsis.",
            specialPrecautions = "Screen for surgical site erythema and wound dehiscence before resuming therapy."
        ),

        // ==========================================
        // HERBAL SUPPLEMENTS & OTCs
        // ==========================================
        SurgicalPreOpDrug(
            id = "preop_herbals",
            drugName = "Herbal Supplements (Ginkgo Biloba, Ginseng, Garlic, Vitamin E, St. John's Wort)",
            drugClass = "Herbal / Supplement",
            cessationWindow = "Hold 7 to 14 days prior to elective surgery",
            lowBleedRiskAction = "Discontinue 1 to 2 weeks prior to any surgical procedure.",
            highBleedRiskAction = "Discontinue 2 full weeks prior to surgery.",
            bridgingProtocol = "None required.",
            resumptionTimeline = "Resume once fully recovered post-operatively.",
            emergencyReversalAgent = "Protamine/TXA/platelets depending on bleeding presentation.",
            clinicalRationale = "The '4 G's' (Ginkgo, Ginseng, Garlic, Ginger) inhibit platelet aggregation and promote spontaneous bleeding. St. John's Wort induces CYP3A4, accelerating metabolism of anesthetics, opioids, and immunosuppressants.",
            specialPrecautions = "Always take a thorough dedicated herbal history during pre-anesthetic checkup, as patients rarely volunteer supplement use."
        )
    )
}
