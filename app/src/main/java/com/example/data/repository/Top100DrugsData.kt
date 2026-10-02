package com.example.data.repository

import com.example.data.model.IvFluidMonograph
import com.example.data.model.Top100Drug

object Top100DrugsData {

    val ivFluids: List<IvFluidMonograph> = listOf(
        IvFluidMonograph(
            id = "fluid_hartmanns",
            name = "Compound Sodium Lactate (Hartmann's Solution)",
            type = "Balanced Crystalloid",
            composition = "Na+ 131 mmol/L, Cl- 111 mmol/L, K+ 5 mmol/L, Ca2+ 2 mmol/L, Lactate 29 mmol/L (Osmolarity ~278 mOsm/L)",
            indications = listOf(
                "First-line replacement fluid for expansion of circulating volume in hypovolaemic shock and circulatory compromise.",
                "Maintenance provision of sodium, potassium and water in surgical and medical patients unable to take oral fluids.",
                "Acute pancreatitis initial fluid resuscitation (reduces systemic inflammatory response syndrome compared to 0.9% NaCl)."
            ),
            mechanismOfAction = "Balanced isotonic crystalloid mimicking serum electrolyte composition. Approximately 20-25% remains in the intravascular compartment after distribution. In the liver, lactate is metabolised to pyruvate and subsequently to bicarbonate, mitigating metabolic acidosis without causing hyperchloraemic acidosis.",
            adverseEffects = "Volume overload, pulmonary oedema, peripheral oedema with excessive administration, mild hyperkalaemia in oliguric renal failure.",
            warnings = "Avoid in severe liver disease (impaired lactate metabolism), and in patients with acute kidney injury, anuria, or severe hyperkalaemia (contains 5 mmol/L potassium).",
            prescription = "Resuscitation / Fluid Challenge: 500 mL IV stat over 10-15 minutes (repeat guided by hemodynamic response).\nMaintenance: 500 mL over 4-6 hours combined with 5% glucose.",
            administration = "Administer via standard giving set or rapid infusion pump. In emergency resuscitation, use blood-giving set or pressure infuser bag.",
            monitoring = "Continuous heart rate, blood pressure, capillary refill time, JVP, urine output (>0.5 mL/kg/hr), and serum electrolytes.",
            cost = "Inexpensive and widely available across district and tertiary hospitals in Nepal.",
            clinicalTip = "Substantially lower chloride content (111 mmol/L vs 154 mmol/L in normal saline) protects against hyperchloraemic metabolic acidosis and renal vasoconstriction during large-volume fluid resuscitation."
        ),
        IvFluidMonograph(
            id = "fluid_saline",
            name = "Sodium Chloride 0.9% (Normal Saline)",
            type = "Unbalanced Crystalloid",
            composition = "Na+ 154 mmol/L, Cl- 154 mmol/L (Osmolarity ~308 mOsm/L)",
            indications = listOf(
                "Expansion of circulating volume in hypovolaemic shock, especially when co-existing hyperkalaemia or anuria contraindicates potassium-containing fluids.",
                "Hypochloraemic metabolic alkalosis (e.g. persistent vomiting, gastric outlet obstruction).",
                "Hyponatraemic dehydration and acute volume depletion.",
                "Vehicle for reconstitution and dilution of compatible intravenous medications."
            ),
            mechanismOfAction = "Isotonic saline solution expanding the extracellular fluid (ECF) volume. Approximately 20% remains intravascularly after 30-60 minutes, while 80% equilibrates into the interstitial space.",
            adverseEffects = "Hyperchloraemic metabolic acidosis (high chloride induces renal bicarbonate wasting), interstitial tissue oedema, worsening heart failure.",
            warnings = "Reduce volume in congestive heart failure and CKD. Large volume (>2-3 L) rapid infusion causes significant hyperchloraemia and renal arteriolar vasoconstriction.",
            prescription = "Fluid Challenge: 500 mL IV bolus over 10-15 minutes.\nMaintenance: 500 mL IV over 8 hours (provides 77 mmol sodium, meeting 1 mmol/kg/day requirement in a 75 kg adult).",
            administration = "Intravenous infusion via peripheral or central cannula. Always write 'sodium chloride 0.9%' rather than 'normal saline'.",
            monitoring = "Monitor blood pressure, respiratory rate, lung bases for crackles, serum sodium and chloride, and fluid balance charts.",
            cost = "Very inexpensive generic essential hospital fluid.",
            clinicalTip = "When rapid volume expansion is required, using a blood-giving set allows much higher flow rates than a standard intravenous drip tubing."
        ),
        IvFluidMonograph(
            id = "fluid_glucose_dextrose",
            name = "Glucose (Dextrose) 5%, 10%, 20%, 50%",
            type = "Hypotonic / Carbohydrate Substrate",
            composition = "Glucose 5% (50 g/L, 278 mOsm/L); 10% (100 g/L); 20% (200 g/L); 50% (500 g/L)",
            indications = listOf(
                "Glucose 5%: Provision of free water intravenously for daily maintenance hydration (leaves free water once glucose is metabolized).",
                "Glucose 10% / 20%: Rapid emergency correction of acute severe symptomatic hypoglycaemia.",
                "Glucose 20% + Actrapid Insulin: Emergency management of severe hyperkalaemia (shifts potassium intracellularly).",
                "Dilution and infusion vehicle for compatible medications (e.g. amiodarone, amphotericin B)."
            ),
            mechanismOfAction = "Glucose is rapidly transported into hepatocytes and skeletal myocytes and metabolised, leaving behind hypotonic 'free water' that distributes throughout total body water (two-thirds intracellular, one-third extracellular). Only ~7% remains in the intravascular space.",
            adverseEffects = "Vein irritation and thrombophlebitis (severe with 50% concentration), hyponatraemia with large volumes, hyperglycemia in diabetes.",
            warnings = "NEVER use Glucose 5% for fluid resuscitation in hypovolaemic shock (only 7% stays intravascularly). Always administer parenteral thiamine (Pabrinex / Vit B1) before glucose in malnourished or alcoholic patients to prevent acute Wernicke's encephalopathy.",
            prescription = "Maintenance Water: 1 L Glucose 5% over 8-10 hours.\nHypoglycaemia: 100-200 mL of 10% Glucose IV over 5-10 minutes, or 50 mL of 20% Glucose.\nHyperkalaemia: 100 mL Glucose 20% + 10 units Actrapid insulin over 15-30 minutes.",
            administration = "Glucose 50% is extremely hypertonic and caustic to veins; administer strictly via central line or dilute to 10-20% if given peripherally.",
            monitoring = "Capillary blood glucose, serum sodium (risk of dilutional hyponatraemic encephalopathy), and fluid input/output balance.",
            cost = "Low cost essential medicine.",
            clinicalTip = "In patients requiring both red blood cell transfusion and IV glucose, never mix them in the same infusion set, as dextrose solutions cause red cell clumping and hemolysis."
        ),
        IvFluidMonograph(
            id = "fluid_potassium_iv",
            name = "Intravenous Potassium Chloride (KCl Additive)",
            type = "Electrolyte Concentrate Additive",
            composition = "Concentrate: 20 mmol (15%) in 10 mL ampoule; Pre-mixed: 20 mmol/L or 40 mmol/L in 0.9% NaCl or 5% Glucose",
            indications = listOf(
                "Treatment of severe, symptomatic, or ECG-manifesting hypokalaemia (K+ <2.5 mmol/L or associated with arrhythmias).",
                "Daily maintenance potassium replacement (approx 1 mmol/kg/day) in patients receiving prolonged intravenous fluids."
            ),
            mechanismOfAction = "Potassium is the primary intracellular cation essential for resting membrane potential, neuronal transmission, and cardiac muscle excitation-contraction coupling. Potassium chloride with sodium chloride promotes longer serum retention compared to glucose.",
            adverseEffects = "Local vein burning, phlebitis, fatal cardiac arrhythmias and asystole if infused too rapidly or overcorrected.",
            warnings = "NEVER ADMINISTER IV PUSH OR DIRECT BOLUS (causes instant fatal cardiac arrest). Peripheral infusion rate must NOT exceed 20 mmol/hour (typically 10-20 mmol/hr max) under continuous ECG monitoring.",
            prescription = "Severe Hypokalaemia: 40 mmol KCl in 1 L 0.9% NaCl infused over 2 to 4 hours (10-20 mmol/hr).\nMaintenance: 20-40 mmol per litre of maintenance fluid.",
            administration = "Must be thoroughly mixed in pre-prepared commercially packaged infusion bags. Administer through large-bore cannula into large proximal vein.",
            monitoring = "Continuous ECG rhythm strip, serum potassium every 2 to 4 hours during rapid replacement, renal function, and serum magnesium.",
            cost = "Inexpensive generic additive.",
            clinicalTip = "Hypokalaemia is frequently refractory if co-existing hypomagnesaemia is left uncorrected. Always check and replace serum magnesium alongside potassium."
        ),
        IvFluidMonograph(
            id = "fluid_colloids",
            name = "Colloids (Gelatins - Gelofusine & Human Albumin Solution)",
            type = "Colloid Plasma Volume Expander",
            composition = "Gelofusine: 4% succinylated gelatin in 154 mmol/L NaCl; HAS: 5% or 20% human albumin solution",
            indications = listOf(
                "Prevention of effective hypovolaemia and circulatory dysfunction during large-volume paracentesis (>5 L) in cirrhotic ascites (Human Albumin 20%).",
                "Spontaneous bacterial peritonitis (SBP) renal protection with Human Albumin Solution.",
                "Secondary plasma volume support in severe refractory shock."
            ),
            mechanismOfAction = "Contains large macromolecules (albumin or succinylated gelatin polypeptides) that exert oncotic pressure, retaining fluid within the intravascular compartment (approx 70-80% of gelatin volume remains in plasma under normal capillary permeability).",
            adverseEffects = "Anaphylactoid reactions with gelatin colloids, acute volume overload, coagulopathy (dilution of clotting factors and platelet dysfunction).",
            warnings = "Synthetic starch-based colloids (HES) are associated with renal failure and mortality in sepsis and are contraindicated. Use cautiously in congestive heart failure.",
            prescription = "Large-volume Paracentesis: 100 mL of 20% Albumin (HAS) for every 2 to 3 litres of ascitic fluid drained beyond 5 L.\nVolume Expansion: 250-500 mL Gelofusine IV over 15-30 minutes.",
            administration = "Administer using standard blood/solution giving set. Warm fluids to room or body temperature prior to large volume infusions.",
            monitoring = "Vital signs every 15 minutes during rapid infusion, central venous pressure, urine output, and signs of pulmonary edema.",
            cost = "Significantly higher cost than crystalloids (Human Albumin 20% is expensive).",
            clinicalTip = "Crystalloids (Hartmann's and 0.9% NaCl) remain first-line for nearly all resuscitation scenarios; Albumin has specific evidence-based mortality benefits in cirrhosis and large-volume paracentesis."
        )
    )

    val top100Drugs: List<Top100Drug> = Top100DrugsPart1.drugs +
            Top100DrugsPart2.drugs +
            Top100DrugsPart3.drugs +
            Top100DrugsPart4.drugs
}
