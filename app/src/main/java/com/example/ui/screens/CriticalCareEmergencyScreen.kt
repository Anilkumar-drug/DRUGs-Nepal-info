package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import java.util.Locale
import kotlin.math.roundToInt

private enum class CriticalCareTab(val label: String, val icon: ImageVector) {
    OVERVIEW("⚡ Rapid Cockpit", Icons.Default.Dashboard),
    ANTIDOTES("💊 Antidote Dosages", Icons.Default.Medication),
    RESUSCITATION("🫀 Resuscitation Protocols", Icons.Default.Bolt),
    VASOPRESSORS("💉 Inotrope & Drip Station", Icons.Default.WaterDrop),
    RED_FLAGS("🚨 High-Lethality Toxins", Icons.Default.WarningAmber)
}

data class EmergencyAntidoteDose(
    val poisonName: String,
    val antidoteName: String,
    val category: String,
    val baseLoadingFormula: (weightKg: Double) -> String,
    val baseMaintenanceFormula: (weightKg: Double) -> String,
    val preparation: String,
    val clinicalEndpoint: String,
    val criticalPearls: String,
    val urgencyLevel: String // "IMMEDIATE (STAT)", "CRITICAL (<1 hr)", "HIGH"
)

data class ResuscitationProtocol(
    val title: String,
    val condition: String,
    val badge: String,
    val accentColor: Color,
    val primarySteps: List<String>,
    val drugRegimens: List<Pair<String, String>>,
    val monitoringTargets: String,
    val commonPitfalls: String
)

@Composable
fun CriticalCareEmergencyScreen(
    onBackClick: () -> Unit,
    onNavigateToToxicology: () -> Unit,
    onNavigateToCodeBlue: () -> Unit,
    onNavigateToAbg: () -> Unit,
    onNavigateToAnesthesia: () -> Unit,
    onNavigateToIvCompat: () -> Unit,
    onNavigateToInteractions: () -> Unit
) {
    BackHandler { onBackClick() }

    var selectedTab by remember { mutableStateOf(CriticalCareTab.OVERVIEW) }
    var patientWeightKg by remember { mutableDoubleStateOf(70.0) }
    var weightInputText by remember { mutableStateOf("70") }
    var antidoteSearchQuery by remember { mutableStateOf("") }
    var selectedResusProtocolIndex by remember { mutableIntStateOf(0) }

    // Pre-calculated emergency antidote database
    val emergencyAntidotes = remember {
        listOf(
            EmergencyAntidoteDose(
                poisonName = "Organophosphates & Carbamates (Insecticides)",
                antidoteName = "Atropine Sulfate + Pralidoxime (2-PAM)",
                category = "Cholinergic Toxidrome / Agriculture",
                baseLoadingFormula = { weight ->
                    val adultBolus = "2 to 5 mg IV push stat"
                    val pedsBolus = "${String.format(Locale.US, "%.2f", weight * 0.05)} mg IV (0.05 mg/kg)"
                    if (weight < 35) pedsBolus else adultBolus
                },
                baseMaintenanceFormula = { weight ->
                    "Double dose every 5-10 minutes until lungs are clear. Then Pralidoxime (2-PAM): ${if (weight < 40) "${String.format(Locale.US, "%.0f", weight * 25)} mg (25-50 mg/kg)" else "1 to 2 g"} IV in 100 mL NS over 30 min, followed by continuous infusion ${if (weight < 40) "${String.format(Locale.US, "%.1f", weight * 10)} mg/hr (10-20 mg/kg/hr)" else "8 mg/kg/hr (500 mg/hr)"}."
                },
                preparation = "Atropine: 0.6 mg/mL ampoules (keep 50-100 ampoules bedside). 2-PAM: 1 g vial reconstituted with 20 mL sterile water.",
                clinicalEndpoint = "ATROPINIZATION ENDPOINTS: Clear chest auscultation (no rales/bronchorrhea), dry tracheobronchial secretions, HR >80 bpm, SBP >90 mmHg. (NOTE: Dilated pupils are NOT an endpoint!).",
                criticalPearls = "Never withhold Atropine due to tachycardia if patient is hypoxic. Hypoxia + Atropine can trigger VF; pre-oxygenate aggressively. Carbamates usually do not require 2-PAM due to spontaneous reversal.",
                urgencyLevel = "IMMEDIATE (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Paracetamol (Acetaminophen) Overdose",
                antidoteName = "N-Acetylcysteine (NAC) IV 21-Hour Protocol",
                category = "Hepatotoxicity",
                baseLoadingFormula = { weight ->
                    val totalMg = weight * 150.0
                    val totalMl = totalMg / 200.0 // 20% solution = 200 mg/mL
                    "Bag 1: ${String.format(Locale.US, "%.0f", totalMg)} mg (${String.format(Locale.US, "%.1f", totalMl)} mL of 20% NAC) in 200 mL D5W over 60 minutes."
                },
                baseMaintenanceFormula = { weight ->
                    val bag2Mg = weight * 50.0
                    val bag3Mg = weight * 100.0
                    "• Bag 2 (4 hours): ${String.format(Locale.US, "%.0f", bag2Mg)} mg in 500 mL D5W\n• Bag 3 (16 hours): ${String.format(Locale.US, "%.0f", bag3Mg)} mg in 1000 mL D5W.\nTotal 21-hr dose = ${String.format(Locale.US, "%.0f", weight * 300.0)} mg (300 mg/kg)."
                },
                preparation = "NAC 20% ampoule (200 mg/mL, 10 mL vial = 2000 mg). Infuse in 5% Dextrose.",
                clinicalEndpoint = "Continue IV NAC beyond 21 hours if ALT/AST remain elevated or Paracetamol level >10 mcg/mL or INR >1.5.",
                criticalPearls = "Maximum efficacy when started within 8 hours of ingestion. Non-IgE anaphylactoid reactions (flushing, hives) occur in 10-15%; do NOT stop NAC permanently—slow infusion rate, give Chlorpheniramine/Hydrocortisone, and resume.",
                urgencyLevel = "CRITICAL (<8 hr)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Opioids (Morphine, Tramadol, Heroin, Fentanyl, Codeine)",
                antidoteName = "Naloxone Hydrochloride",
                category = "Opioid Toxidrome / Respiratory Depression",
                baseLoadingFormula = { weight ->
                    if (weight < 20) "${String.format(Locale.US, "%.2f", weight * 0.1)} mg IV/IM (0.1 mg/kg)"
                    else "0.4 mg to 2.0 mg IV / IM / SC / Intranasal"
                },
                baseMaintenanceFormula = { weight ->
                    "Repeat 0.4 - 2.0 mg every 2-3 minutes. If no response after 10 mg, question diagnosis. If responsive but wears off (half-life 30-90 min), start continuous infusion at 2/3 of successful waking bolus per hour."
                },
                preparation = "Naloxone 0.4 mg/mL or 1.0 mg/mL ampoule.",
                clinicalEndpoint = "PRIMARY ENDPOINT: Adequate spontaneous respiratory ventilation (>10-12 breaths/min) and SpO2 >92%, NOT full alert consciousness (to avoid severe violent opioid withdrawal).",
                criticalPearls = "Tramadol toxicity causes seizures; Naloxone reverses respiratory depression but may LOWER seizure threshold! Half-life of Naloxone is shorter than most opioids; monitor for renarcotization for ≥6-12 hours.",
                urgencyLevel = "IMMEDIATE (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Benzodiazepines (Diazepam, Alprazolam, Clonazepam)",
                antidoteName = "Flumazenil",
                category = "Sedative-Hypnotic Toxidrome",
                baseLoadingFormula = { _ ->
                    "0.2 mg IV over 30 seconds"
                },
                baseMaintenanceFormula = { _ ->
                    "Wait 60 seconds. If no response, give 0.3 mg IV over 30s. Subsequent doses: 0.5 mg IV every 60 seconds to a cumulative max of 3.0 mg (5 mg in ICU)."
                },
                preparation = "Flumazenil 0.1 mg/mL (5 mL vial = 0.5 mg).",
                clinicalEndpoint = "Return of protective airway reflexes and adequate ventilation.",
                criticalPearls = "BLACK BOX CONTRAINDICATION: Strictly contraindicated in chronic benzodiazepine tolerance or co-ingestion of Tricyclic Antidepressants (TCA); precipitates refractory status epilepticus and fatal arrhythmias. Routine use in mixed overdose is discouraged.",
                urgencyLevel = "HIGH (Caution)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Calcium Channel Blocker (Amlodipine, Diltiazem, Verapamil)",
                antidoteName = "Calcium Gluconate 10% + High-Dose Insulin (HIET)",
                category = "Cardiovascular Shock",
                baseLoadingFormula = { weight ->
                    val insulinUnits = weight * 1.0
                    val d25ml = weight * 1.0
                    "• 10% Calcium Gluconate: 20-30 mL IV over 5-10 min\n• Regular Insulin Bolus: ${String.format(Locale.US, "%.0f", insulinUnits)} units IV (1 unit/kg) + D25W ${String.format(Locale.US, "%.0f", d25ml)} mL."
                },
                baseMaintenanceFormula = { weight ->
                    val insulinRate = weight * 0.5
                    val maxInsulinRate = weight * 1.0
                    "• High-Dose Insulin Infusion: ${String.format(Locale.US, "%.0f", insulinRate)} to ${String.format(Locale.US, "%.0f", maxInsulinRate)} units/hr (0.5 - 1.0 unit/kg/hr) with continuous 10% or 25% Dextrose to maintain euglycemia (100-200 mg/dL).\n• Calcium Gluconate infusion: 0.6-1.5 mL/kg/hr."
                },
                preparation = "Regular Insulin (100 units/mL). 10% Calcium Gluconate (10 mL = 1 g). 25% or 10% Dextrose infusion.",
                clinicalEndpoint = "Target MAP >65 mmHg, heart rate >50 bpm, reversal of cardiogenic shock.",
                criticalPearls = "HIET (High-Dose Insulin Euglycemia Therapy) is the gold-standard inotrope of choice in severe CCB and Beta-blocker shock. Inotrope effect takes 30-45 minutes. Check glucose every 30 min and Potassium every 1 hr.",
                urgencyLevel = "CRITICAL (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Beta-Blockers (Propranolol, Atenolol, Metoprolol)",
                antidoteName = "Glucagon + High-Dose Insulin (HIET)",
                category = "Cardiovascular Shock / Bradycardia",
                baseLoadingFormula = { weight ->
                    val glucagonDose = if (weight < 40) "${String.format(Locale.US, "%.1f", weight * 0.05)} mg" else "5 to 10 mg"
                    "Glucagon $glucagonDose IV slow bolus over 2-3 minutes. If responsive, start infusion."
                },
                baseMaintenanceFormula = { _ ->
                    "Glucagon continuous infusion at 2 to 5 mg/hr (titrated to HR >50). Also initiate HIET (Regular Insulin 1 unit/kg bolus then 0.5-1.0 unit/kg/hr with Dextrose)."
                },
                preparation = "Glucagon 1 mg vial with diluent. Reconstitute in 5% Dextrose for continuous infusion.",
                clinicalEndpoint = "Resolution of refractory bradycardia and hypotension.",
                criticalPearls = "Glucagon activates adenylate cyclase directly via non-adrenergic receptors, boosting intracellular cAMP. Pre-medicate with Ondansetron 4-8 mg IV as high-dose glucagon causes severe nausea/vomiting.",
                urgencyLevel = "CRITICAL (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Local Anesthetic Systemic Toxicity (LAST - Bupivacaine, Lignocaine)",
                antidoteName = "Intralipid 20% (Lipid Emulsion Therapy)",
                category = "Anesthesia Crisis / Cardiac Arrest",
                baseLoadingFormula = { weight ->
                    val bolusMl = weight * 1.5
                    "${String.format(Locale.US, "%.0f", bolusMl)} mL IV bolus (1.5 mL/kg 20% Lipid Emulsion) over 2-3 minutes."
                },
                baseMaintenanceFormula = { weight ->
                    val infusionRate = weight * 0.25 * 60 // mL/hr
                    "Continuous infusion: ${String.format(Locale.US, "%.0f", infusionRate)} mL/hr (0.25 mL/kg/min). If cardiovascular instability persists, repeat bolus 1-2 times and double infusion to 0.5 mL/kg/min. Max total dose: 12 mL/kg (${String.format(Locale.US, "%.0f", weight * 12)} mL)."
                },
                preparation = "20% Lipid Emulsion (Intralipid / Lipoven 500 mL bag). Must be immediately accessible in all Operating Rooms & Emergency Departments.",
                clinicalEndpoint = "Recovery of cardiac contractility, cessation of ventricular dysrhythmias.",
                criticalPearls = "Acts as a 'lipid sink' absorbing lipophilic bupivacaine and directly restores myocardial fatty acid oxidation. In LAST cardiac arrest: avoid Vasopressin, high-dose Epinephrine (keep doses <1 mcg/kg), CCBs, and Beta-blockers.",
                urgencyLevel = "IMMEDIATE (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Snakebite Envenomation (Nepal Cobra, Krait, Viper)",
                antidoteName = "Polyvalent Anti-Snake Venom (ASV)",
                category = "Toxin / Envenomation (WHO & Nepal Guidelines)",
                baseLoadingFormula = { _ ->
                    "10 Vials ASV reconstituted in 200-500 mL Normal Saline, infused IV over 1 hour."
                },
                baseMaintenanceFormula = { _ ->
                    "Neurotoxic (Krait/Cobra): If ptosis/respiratory paralysis does not improve in 1-2 hours, repeat 10 vials. Perform Neostigmine test (0.5-2 mg IV with Atropine 0.6 mg). Vasculotoxic (Viper): Check 20-Minute Whole Blood Clotting Test (20WBCT) at 6 hours; if still unclotted, repeat 10 vials."
                },
                preparation = "Lyophilized Polyvalent Anti-Snake Venom (effective against Naja naja, Bungarus caeruleus, Daboia russelii, Echis carinatus).",
                clinicalEndpoint = "Clearance of systemic neurotoxicity (ptosis, bulbar weakness) or normalization of 20WBCT (<20 min clot formation).",
                criticalPearls = "Never inject ASV locally at bite site! Keep Adrenaline 1:1000 drawn up bedside in case of early anaphylactic reaction to horse serum proteins (occurs in 10-30%). Intubate early for respiratory failure before transfer.",
                urgencyLevel = "IMMEDIATE (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Severe Hyperkalemia (K+ >6.5 or ECG Peaked T / Sine Wave)",
                antidoteName = "Calcium Gluconate + Insulin-Dextrose + Salbutamol (C-BIG-K-DROP)",
                category = "Electrolyte Emergency / Arrhythmia",
                baseLoadingFormula = { weight ->
                    val calciumMl = if (weight < 35) "${String.format(Locale.US, "%.1f", weight * 0.5)} mL" else "10 to 20 mL"
                    "• 10% Calcium Gluconate: $calciumMl IV slow push over 5 minutes (ECG stabilization)\n• 10 Units Regular Insulin IV push + 50 mL 50% Dextrose (D50W)."
                },
                baseMaintenanceFormula = { _ ->
                    "• Salbutamol (Albuterol) 10 to 20 mg nebulized over 15 minutes.\n• 8.4% Sodium Bicarbonate 50-100 mL IV (if concurrent severe metabolic acidosis).\n• Elimination: Furosemide 40-80 mg IV or Emergency Hemodialysis."
                },
                preparation = "10% Calcium Gluconate (10 mL = 90 mg elemental Ca2+). Regular Insulin + 50% Dextrose.",
                clinicalEndpoint = "Normalization of ECG (disappearance of peaked T waves, narrowing of QRS, return of P waves). Repeat Calcium if ECG still abnormal after 5 min.",
                criticalPearls = "CALCIUM DOES NOT LOWER SERUM POTASSIUM! It purely stabilizes the cardiac myocyte membrane against fatal dysrhythmias (onset 1-3 min, duration 30-60 min). Insulin-dextrose and Salbutamol drive K+ into cells.",
                urgencyLevel = "IMMEDIATE (STAT)"
            ),
            EmergencyAntidoteDose(
                poisonName = "Cyanide & Smoke Inhalation Toxicity",
                antidoteName = "Hydroxocobalamin (Cyanokit) OR Sodium Nitrite + Sodium Thiosulfate",
                category = "Cellular Hypoxia / Metabolic Acidosis",
                baseLoadingFormula = { weight ->
                    if (weight < 40) "${String.format(Locale.US, "%.0f", weight * 70)} mg Hydroxocobalamin IV (70 mg/kg)"
                    else "5.0 g Hydroxocobalamin IV infusion over 15 minutes"
                },
                baseMaintenanceFormula = { _ ->
                    "Second dose of 5.0 g IV over 15 min to 2 hours if severe lactic acidosis or cardiovascular collapse persists. Alternatively: 3% Sodium Nitrite 300 mg (10 mL) IV over 5 min, followed by 25% Sodium Thiosulfate 12.5 g (50 mL) IV over 10 min."
                },
                preparation = "Cyanokit 5 g vial reconstituted with 200 mL Normal Saline.",
                clinicalEndpoint = "Rapid clearance of refractory lactic acidosis (>8-10 mmol/L) and return of spontaneous cardiac output.",
                criticalPearls = "In fire victims with smoke inhalation, Hydroxocobalamin is safe because it does NOT cause methemoglobinemia (unlike Sodium Nitrite, which worsens carboxyhemoglobinemia from Carbon Monoxide).",
                urgencyLevel = "IMMEDIATE (STAT)"
            )
        )
    }

    // Common Resuscitation Protocols
    val resuscitationProtocols = remember {
        listOf(
            ResuscitationProtocol(
                title = "ACLS Adult Cardiac Arrest",
                condition = "VF, Pulseless VT, Asystole, PEA",
                badge = "ACLS 2024-26",
                accentColor = Red500,
                primarySteps = listOf(
                    "START HIGH-QUALITY CPR: 100-120 compressions/min, 5-6 cm depth, complete chest recoil, minimize interruptions (<10s). Ratio 30:2 or continuous if advanced airway.",
                    "ATTACH MONITOR / DEFIBRILLATOR: Rapidly identify rhythm.",
                    "SHOCKABLE (VF / pVT): Deliver 200 J Biphasic shock immediately. Resume CPR 2 minutes instantly without pulse check!",
                    "NON-SHOCKABLE (Asystole / PEA): Resume CPR 2 minutes. Give Epinephrine 1 mg IV/IO immediately and repeat every 3-5 minutes.",
                    "REVERSIBLE CAUSES (5 H's & 5 T's): Hypovolemia, Hypoxia, Hydrogen ion (acidosis), Hypo/Hyperkalemia, Hypothermia; Tension pneumo, Tamponade, Toxins, Thrombosis PE, Thrombosis MI."
                ),
                drugRegimens = listOf(
                    "Epinephrine (Adrenaline)" to "1 mg IV/IO (1:10,000, 10 mL) every 3 to 5 minutes.",
                    "Amiodarone (Shockable VF/pVT)" to "1st dose: 300 mg IV/IO bolus after 3rd shock. 2nd dose: 150 mg IV/IO after 5th shock.",
                    "Lidocaine (Alternative to Amiodarone)" to "1st dose: 1.0 to 1.5 mg/kg IV/IO. 2nd dose: 0.5 to 0.75 mg/kg.",
                    "Magnesium Sulfate (Torsades de Pointes)" to "1 to 2 g IV/IO diluted in 10 mL D5W over 5-20 min."
                ),
                monitoringTargets = "Continuous waveform capnography: PETCO2 target >10-20 mmHg (PETCO2 abrupt rise to >40 indicates ROSC). Pulse check only at 2-minute cycle pause (<10s).",
                commonPitfalls = "Do NOT pause CPR to give drugs or check rhythm early. Do NOT hyperventilate (target 1 breath every 6 seconds = 10 bpm)."
            ),
            ResuscitationProtocol(
                title = "Anaphylactic Shock Protocol",
                condition = "Severe Allergic Reaction with Airway / Hemodynamic Collapse",
                badge = "CRITICAL STAT",
                accentColor = Color(0xFFF97316),
                primarySteps = listOf(
                    "STEP 1: INTRAMUSCULAR ADRENALINE (1:1000) STAT into mid-anterolateral thigh. DO NOT DELAY FOR IV ACCESS!",
                    "STEP 2: Position patient recumbent/supine with legs elevated (unless severe stridor/dyspnea where sitting is preferred). Never let patient stand or walk.",
                    "STEP 3: High-flow Oxygen (10-15 L/min NRB mask) to maintain SpO2 >95%.",
                    "STEP 4: Aggressive IV fluid resuscitation: 20 mL/kg Normal Saline or Ringer's Lactate under pressure.",
                    "STEP 5: Repeat IM Adrenaline every 5 minutes if respiratory distress or hypotension persists."
                ),
                drugRegimens = listOf(
                    "Adrenaline (1:1000, 1 mg/mL) IM" to "Adult: 0.5 mg (0.5 mL) IM mid-thigh. Child >12y: 0.5 mg; 6-12y: 0.3 mg; <6y: 0.15 mg IM.",
                    "Refractory Shock Adrenaline IV Infusion" to "0.05 to 0.1 mcg/kg/min IV infusion (1 mg in 100 mL NS at 1-2 mL/min titrated).",
                    "Hydrocortisone IV (Adjunct)" to "Adult: 200 mg IV. Pediatric: 4 mg/kg IV (prevents biphasic relapse).",
                    "Chlorpheniramine IV (H1 Antihistamine)" to "Adult: 10 mg IV slow push. Pediatric: 2.5 - 5 mg IV.",
                    "Glucagon (If on Beta-Blocker therapy)" to "1 to 5 mg IV slow bolus over 5 min, then 5-15 mcg/min infusion."
                ),
                monitoringTargets = "Blood pressure every 2-5 min, continuous pulse oximetry, monitor for biphasic anaphylaxis (observe minimum 6-12 hours).",
                commonPitfalls = "Giving Epinephrine subcutaneous or IV bolus instead of IM thigh. Withholding Epinephrine due to fear of tachycardia. Giving antihistamines before Epinephrine."
            ),
            ResuscitationProtocol(
                title = "Surviving Sepsis Hour-1 Bundle",
                condition = "Septic Shock / Severe Sepsis with Hypotension or Lactate ≥4",
                badge = "SSC 2024",
                accentColor = Color(0xFF38BDF8),
                primarySteps = listOf(
                    "1. Measure serum lactate level immediately. Remeasure within 2-4 hours if initial lactate >2 mmol/L.",
                    "2. Obtain blood cultures (2 sets: aerobic & anaerobic) PRIOR to initiating antimicrobials.",
                    "3. Administer broad-spectrum empiric IV antimicrobials within 1 hour of recognition.",
                    "4. Rapid fluid resuscitation: 30 mL/kg IV balanced crystalloid (Ringer's Lactate / Plasmalyte) for hypotension or lactate ≥4 mmol/L.",
                    "5. Apply Vasopressors during or immediately after fluid resuscitation to maintain MAP ≥65 mmHg."
                ),
                drugRegimens = listOf(
                    "Noradrenaline (Norepinephrine) IV" to "1st choice vasopressor: 0.05 to 1.0 mcg/kg/min titrated to MAP ≥65 mmHg.",
                    "Vasopressin (Adjunct Vasopressor)" to "Fixed dose 0.03 units/min (do not titrate) to reduce Noradrenaline requirements.",
                    "Hydrocortisone IV (Refractory Shock)" to "200 mg/day IV (50 mg IV q6h or continuous infusion) if MAP unresponsive to Norad + Vaso.",
                    "Broad Spectrum Empiric Antibiotics" to "Piperacillin-Tazobactam 4.5g IV + Vancomycin 25-30 mg/kg IV OR Meropenem 1g IV."
                ),
                monitoringTargets = "Target MAP ≥65 mmHg, urine output >0.5 mL/kg/hr, normalization of capillary refill time (<2 sec), down-trending serum lactate.",
                commonPitfalls = "Delaying vasopressor until all 30 mL/kg fluid has run in. Waiting for blood culture results before starting empiric antibiotics. Using Normal Saline (causes hyperchloremic metabolic acidosis)."
            ),
            ResuscitationProtocol(
                title = "Status Epilepticus Rapid Escalation",
                condition = "Continuous Seizure ≥5 Minutes or Cluster without Recovery",
                badge = "NEURO STAT",
                accentColor = Color(0xFFA855F7),
                primarySteps = listOf(
                    "PHASE 1 (0-5 MIN): ABCs, high-flow O2, fingerstick glucose stat (give 50 mL D50W if <70 mg/dL), establish IV/IO access.",
                    "PHASE 2 (5-10 MIN) - FIRST-LINE: Benzodiazepine IV/IM. If seizure continues at 10 min, repeat full dose once.",
                    "PHASE 3 (10-20 MIN) - SECOND-LINE: Non-sedating IV Antiepileptic Drug (Levetiracetam, Valproate, or Fosphenytoin) over 10-15 min.",
                    "PHASE 4 (>20-30 MIN) - REFRACTORY STATUS: Endotracheal intubation, continuous anesthetic IV infusion (Propofol or Midazolam) with continuous EEG monitoring."
                ),
                drugRegimens = listOf(
                    "Lorazepam IV (1st Line Preferred)" to "Adult: 4 mg IV push over 2 min. Pediatric: 0.1 mg/kg IV (max 4 mg).",
                    "Midazolam IM (If NO IV Access)" to "Adult: 10 mg IM (>40 kg). Pediatric: 0.2 mg/kg IM (max 10 mg).",
                    "Levetiracetam (Keppra) IV (2nd Line)" to "60 mg/kg IV in 100 mL NS over 10 min (max 4500 mg).",
                    "Sodium Valproate IV (2nd Line Alt)" to "40 mg/kg IV over 10 min (max 3000 mg). Avoid in acute liver disease.",
                    "Propofol (Refractory 3rd Line)" to "Loading: 2 mg/kg IV bolus, then continuous infusion 2 to 10 mg/kg/hr."
                ),
                monitoringTargets = "Cessation of clinical and electrographic convulsive movements. Continuous SpO2, blood pressure, end-tidal CO2.",
                commonPitfalls = "Underdosing benzodiazepines (giving 1-2 mg Lorazepam instead of 4 mg). Waiting >20 minutes to escalate to second-line antiepileptic therapy."
            ),
            ResuscitationProtocol(
                title = "Massive Transfusion Protocol (MTP)",
                condition = "Exsanguinating Hemorrhage / Shock Index >1.0",
                badge = "TRAUMA STAT",
                accentColor = Color(0xFFE11D48),
                primarySteps = listOf(
                    "CRITERIA: SBP <90 mmHg, HR >120 bpm, base deficit >-6, shock index >1.0, or massive bleeding unlikely to cease.",
                    "ACTIVATE BLOOD BANK MTP: Release 1:1:1 balanced blood components in coolers.",
                    "TRANEXAMIC ACID (TXA): 1 g IV bolus over 10 minutes within 3 hours of trauma, followed by 1 g IV infusion over 8 hours (CRASH-2 trial).",
                    "PREVENT THE LETHAL TRIAD: Hypothermia (use rapid fluid warmer), Acidosis (restore perfusion), Coagulopathy (early FFP/platelets).",
                    "CALCIUM REPLACEMENT: 1 g Calcium Gluconate IV for every 4 units of PRBCs transfused (counters citrate binding)."
                ),
                drugRegimens = listOf(
                    "Tranexamic Acid (TXA) IV" to "Loading: 1 g in 100 mL NS over 10 min. Maintenance: 1 g in 500 mL NS over 8 hours.",
                    "Balanced 1:1:1 Components" to "4 Units Packed RBCs : 4 Units Fresh Frozen Plasma : 1 Single-Donor Apheresis Platelet pack.",
                    "Calcium Gluconate 10% IV" to "10 to 20 mL IV slow push every 4 units PRBC or if ionized Ca2+ <1.1 mmol/L.",
                    "Fibrinogen / Cryoprecipitate" to "10 units Cryoprecipitate (or Fibrinogen Concentrate 2-4g) if Fibrinogen <1.5 g/L."
                ),
                monitoringTargets = "Target MAP 50-65 mmHg (permissive hypotension until surgical control), SBP 80-90 (unless severe TBI where SBP >100-110 required). Temperature >36°C.",
                commonPitfalls = "Giving large volumes of cold crystalloid (dilutes clotting factors and induces severe hypothermia). Administering TXA >3 hours after injury (increases mortality)."
            )
        )
    }

    // Filtered antidotes based on query
    val filteredAntidotes = remember(antidoteSearchQuery) {
        val q = antidoteSearchQuery.trim().lowercase()
        if (q.isBlank()) emergencyAntidotes
        else emergencyAntidotes.filter {
            it.poisonName.lowercase().contains(q) ||
            it.antidoteName.lowercase().contains(q) ||
            it.category.lowercase().contains(q)
        }
    }

    Scaffold(
        containerColor = Color(0xFF030712), // Deep pitch black for emergency contrast
        topBar = {
            Surface(
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.testTag("emergency_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(
                                    text = "CRITICAL CARE & EMERGENCY",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 15.sp,
                                    color = Color(0xFFEF4444),
                                    letterSpacing = 0.5.sp
                                )
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(0xFFEF4444).copy(alpha = 0.25f),
                                    border = BorderStroke(0.8.dp, Color(0xFFEF4444))
                                ) {
                                    Text(
                                        text = "STAT ICU/ER",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFFCA5A5),
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Instant Toxicology • Antidotes • Resuscitation • Vasopressors",
                                fontSize = 10.sp,
                                color = Slate400
                            )
                        }
                    }

                    // Direct jump to Code Blue Resuscitation Clock
                    Surface(
                        onClick = onNavigateToCodeBlue,
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFDC2626),
                        modifier = Modifier.testTag("top_quick_code_blue_button")
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Bolt,
                                contentDescription = "Code Blue Clock",
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = "CPR Clock",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF030712))
        ) {
            // Patient Weight Fast-Selector Ribbon (Crucial for Resuscitation & Antidotes)
            Surface(
                color = Color(0xFF1E293B),
                border = BorderStroke(0.8.dp, Color(0xFF334155)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Icon(
                            imageVector = Icons.Default.Scale,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Patient Weight:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE2E8F0)
                        )
                        Text(
                            text = "${patientWeightKg.roundToInt()} kg",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF38BDF8),
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    // Quick weight presets: 15kg (child), 50kg, 70kg (adult std), 90kg
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        listOf(15.0, 50.0, 70.0, 90.0).forEach { presetKg ->
                            val isSelected = (patientWeightKg - presetKg).toInt() == 0
                            Surface(
                                onClick = {
                                    patientWeightKg = presetKg
                                    weightInputText = presetKg.roundToInt().toString()
                                },
                                shape = RoundedCornerShape(6.dp),
                                color = if (isSelected) Color(0xFF0284C7) else Color(0xFF0F172A),
                                border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155))
                            ) {
                                Text(
                                    text = "${presetKg.roundToInt()}kg",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Slate300,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Quick Nav Category Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CriticalCareTab.values().forEach { tab ->
                    val isSelected = selectedTab == tab
                    Surface(
                        onClick = { selectedTab = tab },
                        shape = RoundedCornerShape(10.dp),
                        color = if (isSelected) Color(0xFFEF4444) else Color(0xFF1E293B),
                        border = BorderStroke(1.dp, if (isSelected) Color(0xFFFCA5A5) else Color(0xFF334155)),
                        modifier = Modifier.testTag("tab_${tab.name.lowercase()}")
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                                tint = if (isSelected) Color.White else Slate400,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = tab.label,
                                fontSize = 11.5.sp,
                                fontWeight = if (isSelected) FontWeight.Black else FontWeight.Medium,
                                color = if (isSelected) Color.White else Slate200
                            )
                        }
                    }
                }
            }

            // Main Content Area
            Box(modifier = Modifier.weight(1f)) {
                when (selectedTab) {
                    CriticalCareTab.OVERVIEW -> CriticalCareOverviewDeck(
                        patientWeightKg = patientWeightKg,
                        onNavigateToToxicology = onNavigateToToxicology,
                        onNavigateToCodeBlue = onNavigateToCodeBlue,
                        onNavigateToAbg = onNavigateToAbg,
                        onNavigateToAnesthesia = onNavigateToAnesthesia,
                        onNavigateToIvCompat = onNavigateToIvCompat,
                        onNavigateToInteractions = onNavigateToInteractions,
                        onSwitchToAntidotes = { selectedTab = CriticalCareTab.ANTIDOTES },
                        onSwitchToResuscitation = { selectedTab = CriticalCareTab.RESUSCITATION },
                        onSwitchToVasopressors = { selectedTab = CriticalCareTab.VASOPRESSORS },
                        onSwitchToRedFlags = { selectedTab = CriticalCareTab.RED_FLAGS }
                    )

                    CriticalCareTab.ANTIDOTES -> AntidoteDosagesSection(
                        patientWeightKg = patientWeightKg,
                        searchQuery = antidoteSearchQuery,
                        onSearchChange = { antidoteSearchQuery = it },
                        antidotes = filteredAntidotes,
                        onOpenFullToxicology = onNavigateToToxicology
                    )

                    CriticalCareTab.RESUSCITATION -> ResuscitationProtocolsSection(
                        protocols = resuscitationProtocols,
                        selectedIndex = selectedResusProtocolIndex,
                        onSelectIndex = { selectedResusProtocolIndex = it },
                        onOpenCodeBlue = onNavigateToCodeBlue
                    )

                    CriticalCareTab.VASOPRESSORS -> InotropeVasopressorStation(
                        patientWeightKg = patientWeightKg
                    )

                    CriticalCareTab.RED_FLAGS -> HighLethalityToxinsNepalSection(
                        onOpenFullToxicology = onNavigateToToxicology
                    )
                }
            }
        }
    }
}

@Composable
private fun CriticalCareOverviewDeck(
    patientWeightKg: Double,
    onNavigateToToxicology: () -> Unit,
    onNavigateToCodeBlue: () -> Unit,
    onNavigateToAbg: () -> Unit,
    onNavigateToAnesthesia: () -> Unit,
    onNavigateToIvCompat: () -> Unit,
    onNavigateToInteractions: () -> Unit,
    onSwitchToAntidotes: () -> Unit,
    onSwitchToResuscitation: () -> Unit,
    onSwitchToVasopressors: () -> Unit,
    onSwitchToRedFlags: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 10.dp)
    ) {
        // Red Emergency Triage Deck
        item {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFF450A0A),
                border = BorderStroke(1.5.dp, Color(0xFFEF4444)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFFEF4444),
                                modifier = Modifier.size(28.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(Icons.Default.Bolt, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                                }
                            }
                            Column {
                                Text(
                                    text = "IMMEDIATE EMERGENCY ACTIONS",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFFFCA5A5),
                                    letterSpacing = 0.5.sp
                                )
                                Text(
                                    text = "Target patient: ${patientWeightKg.roundToInt()} kg • Zero-delay clinical protocols",
                                    fontSize = 11.sp,
                                    color = Color(0xFFFECACA)
                                )
                            }
                        }
                    }

                    // 4 STAT Action Cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OverviewStatCard(
                            title = "ACLS ARREST",
                            subtitle = "CPR & Shock",
                            color = Color(0xFFDC2626),
                            icon = Icons.Default.Favorite,
                            modifier = Modifier.weight(1f),
                            onClick = onNavigateToCodeBlue
                        )
                        OverviewStatCard(
                            title = "ANAPHYLAXIS",
                            subtitle = "0.5mg IM Epi",
                            color = Color(0xFFEA580C),
                            icon = Icons.Default.MedicalServices,
                            modifier = Modifier.weight(1f),
                            onClick = onSwitchToResuscitation
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OverviewStatCard(
                            title = "ANTIDOTE DOSES",
                            subtitle = "OP, Paracetamol, Opioid",
                            color = Color(0xFF7C3AED),
                            icon = Icons.Default.Medication,
                            modifier = Modifier.weight(1f),
                            onClick = onSwitchToAntidotes
                        )
                        OverviewStatCard(
                            title = "NORADRENALINE",
                            subtitle = "MAP ≥65 mmHg",
                            color = Color(0xFF0284C7),
                            icon = Icons.Default.WaterDrop,
                            modifier = Modifier.weight(1f),
                            onClick = onSwitchToVasopressors
                        )
                    }
                }
            }
        }

        // Direct Clinical Suite High-Priority Links
        item {
            Text(
                text = "SPECIALIZED CRITICAL CARE SUITES",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Slate400,
                letterSpacing = 0.8.sp
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                EmergencySuiteTile(
                    title = "TOXICOLOGY & POISONS",
                    detail = "Celphos, OPs, Dhatura, Snakebite",
                    badge = "WHO / DDA",
                    accentColor = Color(0xFFF59E0B),
                    icon = Icons.Default.Science,
                    modifier = Modifier.weight(1f),
                    onClick = onNavigateToToxicology
                )

                EmergencySuiteTile(
                    title = "ABG & OSMOLAL GAP",
                    detail = "Winter's Formula & Anion Gap",
                    badge = "ICU LABS",
                    accentColor = Color(0xFF38BDF8),
                    icon = Icons.Default.Biotech,
                    modifier = Modifier.weight(1f),
                    onClick = onNavigateToAbg
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                EmergencySuiteTile(
                    title = "RSI & ANESTHESIA",
                    detail = "Rapid Sequence Intubation Doses",
                    badge = "OT / ER",
                    accentColor = Color(0xFFA855F7),
                    icon = Icons.Default.AirlineSeatFlat,
                    modifier = Modifier.weight(1f),
                    onClick = onNavigateToAnesthesia
                )

                EmergencySuiteTile(
                    title = "Y-SITE & IV DILUTION",
                    detail = "Vasopressor Line Compatibility",
                    badge = "INFUSION",
                    accentColor = Color(0xFF10B981),
                    icon = Icons.Default.LocalHospital,
                    modifier = Modifier.weight(1f),
                    onClick = onNavigateToIvCompat
                )
            }
        }

        // High-Lethality Ingestions Alert Banner (Nepal Specific)
        item {
            Surface(
                onClick = onSwitchToRedFlags,
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF1F1D0B),
                border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.6f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = null,
                            tint = Color(0xFFFBBF24),
                            modifier = Modifier.size(24.dp)
                        )
                        Column {
                            Text(
                                text = "Nepal Agriculture & High-Lethality Ingestions",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFBBF24)
                            )
                            Text(
                                text = "Celphos (AlP) protocol, Dhatura anticholinergic, Snakebite ASV guidelines",
                                fontSize = 11.sp,
                                color = Color(0xFFFDE68A)
                            )
                        }
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xFFFBBF24),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun OverviewStatCard(
    title: String,
    subtitle: String,
    color: Color,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = color.copy(alpha = 0.2f),
        border = BorderStroke(1.dp, color.copy(alpha = 0.8f)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(18.dp)
            )
            Column {
                Text(
                    text = title,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
                Text(
                    text = subtitle,
                    fontSize = 9.5.sp,
                    color = color.copy(alpha = 0.9f)
                )
            }
        }
    }
}

@Composable
private fun EmergencySuiteTile(
    title: String,
    detail: String,
    badge: String,
    accentColor: Color,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.4f)),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = accentColor.copy(alpha = 0.15f),
                    modifier = Modifier.size(28.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(icon, contentDescription = null, tint = accentColor, modifier = Modifier.size(16.dp))
                    }
                }
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = accentColor.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = badge,
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }
            }

            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = detail,
                fontSize = 10.sp,
                color = Slate400,
                lineHeight = 14.sp
            )
        }
    }
}

@Composable
private fun AntidoteDosagesSection(
    patientWeightKg: Double,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    antidotes: List<EmergencyAntidoteDose>,
    onOpenFullToxicology: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            placeholder = { Text("Search poison, drug, or antidote...", fontSize = 12.5.sp, color = Slate500) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFFEF4444)) },
            trailingIcon = {
                if (searchQuery.isNotBlank()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Slate400)
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF0F172A),
                unfocusedContainerColor = Color(0xFF0F172A),
                focusedBorderColor = Color(0xFFEF4444),
                unfocusedBorderColor = Color(0xFF334155),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("antidote_search_field")
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ANTIDOTE DOSAGES (CALCULATED FOR ${patientWeightKg.roundToInt()} KG)",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Black,
                color = Slate400,
                letterSpacing = 0.5.sp
            )

            TextButton(
                onClick = onOpenFullToxicology,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Full Index ↗",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                )
            }
        }

        // List of Antidotes with Calculated Doses
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            items(antidotes, key = { it.poisonName }) { antidote ->
                AntidoteDoseCard(
                    antidote = antidote,
                    patientWeightKg = patientWeightKg
                )
            }
        }
    }
}

@Composable
private fun AntidoteDoseCard(
    antidote: EmergencyAntidoteDose,
    patientWeightKg: Double
) {
    val clipboardManager = LocalClipboardManager.current
    var copied by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.2.dp, Color(0xFF334155)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = when (antidote.urgencyLevel) {
                            "IMMEDIATE (STAT)" -> Color(0xFFDC2626)
                            "CRITICAL (<1 hr)", "CRITICAL (<8 hr)" -> Color(0xFFEA580C)
                            else -> Color(0xFF6366F1)
                        }
                    ) {
                        Text(
                            text = antidote.urgencyLevel,
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = antidote.poisonName,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                    Text(
                        text = "Antidote: ${antidote.antidoteName}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                }

                IconButton(
                    onClick = {
                        val text = "${antidote.poisonName}\nAntidote: ${antidote.antidoteName}\nLoading: ${antidote.baseLoadingFormula(patientWeightKg)}\nMaintenance: ${antidote.baseMaintenanceFormula(patientWeightKg)}"
                        clipboardManager.setText(AnnotatedString(text))
                        copied = true
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = if (copied) Icons.Default.Check else Icons.Default.ContentCopy,
                        contentDescription = "Copy Dose",
                        tint = if (copied) Emerald400 else Slate400,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Calculated Loading Dose Box
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Icon(Icons.Default.Bolt, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(14.dp))
                        Text(
                            text = "CALCULATED STAT LOADING DOSE (${patientWeightKg.roundToInt()} KG):",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF38BDF8)
                        )
                    }
                    Text(
                        text = antidote.baseLoadingFormula(patientWeightKg),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        lineHeight = 17.sp
                    )
                }
            }

            // Maintenance / Repeated Regimen
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0B132B),
                border = BorderStroke(0.8.dp, Color(0xFF1E293B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Text(
                        text = "MAINTENANCE & INFUSION REGIMEN:",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate400
                    )
                    Text(
                        text = antidote.baseMaintenanceFormula(patientWeightKg),
                        fontSize = 11.sp,
                        color = Slate200,
                        lineHeight = 16.sp
                    )
                }
            }

            // Endpoints & Critical Pearls
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "🎯 Endpoint: ${antidote.clinicalEndpoint}",
                    fontSize = 10.5.sp,
                    color = Emerald400,
                    lineHeight = 14.sp
                )
                Text(
                    text = "⚠️ Pearl: ${antidote.criticalPearls}",
                    fontSize = 10.sp,
                    color = Color(0xFFFCA5A5),
                    lineHeight = 14.sp
                )
            }
        }
    }
}

@Composable
private fun ResuscitationProtocolsSection(
    protocols: List<ResuscitationProtocol>,
    selectedIndex: Int,
    onSelectIndex: (Int) -> Unit,
    onOpenCodeBlue: () -> Unit
) {
    val activeProtocol = protocols.getOrNull(selectedIndex) ?: protocols.first()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Protocol Selector Chips
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(protocols.size) { idx ->
                val proto = protocols[idx]
                val isSelected = selectedIndex == idx
                Surface(
                    onClick = { onSelectIndex(idx) },
                    shape = RoundedCornerShape(10.dp),
                    color = if (isSelected) proto.accentColor else Color(0xFF1E293B),
                    border = BorderStroke(1.dp, if (isSelected) Color.White else Color(0xFF334155))
                ) {
                    Text(
                        text = proto.title,
                        fontSize = 11.5.sp,
                        fontWeight = if (isSelected) FontWeight.Black else FontWeight.Bold,
                        color = if (isSelected) Color.White else Slate300,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // Active Protocol Detail Card
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            item {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFF0F172A),
                    border = BorderStroke(1.5.dp, activeProtocol.accentColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = activeProtocol.accentColor.copy(alpha = 0.2f),
                                    border = BorderStroke(0.8.dp, activeProtocol.accentColor)
                                ) {
                                    Text(
                                        text = activeProtocol.badge,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = activeProtocol.accentColor,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = activeProtocol.title.uppercase(),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White
                                )
                                Text(
                                    text = activeProtocol.condition,
                                    fontSize = 11.sp,
                                    color = Slate400
                                )
                            }

                            if (activeProtocol.title.contains("ACLS", ignoreCase = true)) {
                                Button(
                                    onClick = onOpenCodeBlue,
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                                    modifier = Modifier.height(32.dp)
                                ) {
                                    Icon(Icons.Default.Timer, contentDescription = null, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Timer", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        Divider(color = Color(0xFF334155))

                        // Step-by-Step Priority Actions
                        Text(
                            text = "PRIORITY ACTION STEPS:",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Black,
                            color = activeProtocol.accentColor
                        )

                        activeProtocol.primarySteps.forEachIndexed { idx, step ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = activeProtocol.accentColor.copy(alpha = 0.2f),
                                    modifier = Modifier.size(20.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = "${idx + 1}",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = activeProtocol.accentColor
                                        )
                                    }
                                }
                                Text(
                                    text = step,
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    lineHeight = 17.sp,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        Divider(color = Color(0xFF334155))

                        // Essential Resuscitation Drugs
                        Text(
                            text = "DRUGS & DOSING SCHEDULE:",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Black,
                            color = activeProtocol.accentColor
                        )

                        activeProtocol.drugRegimens.forEach { (drugName, doseSchedule) ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFF1E293B),
                                border = BorderStroke(0.8.dp, Color(0xFF334155)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        text = drugName,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF38BDF8)
                                    )
                                    Text(
                                        text = doseSchedule,
                                        fontSize = 11.sp,
                                        color = Color.White,
                                        lineHeight = 15.sp
                                    )
                                }
                            }
                        }

                        Divider(color = Color(0xFF334155))

                        // Monitoring targets & Pitfalls
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "🎯 Clinical Targets: ${activeProtocol.monitoringTargets}",
                                fontSize = 11.sp,
                                color = Emerald400,
                                lineHeight = 15.sp
                            )
                            Text(
                                text = "⚠️ Common Pitfalls: ${activeProtocol.commonPitfalls}",
                                fontSize = 10.5.sp,
                                color = Color(0xFFFCA5A5),
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun InotropeVasopressorStation(
    patientWeightKg: Double
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 20.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.WaterDrop,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(24.dp)
                    )
                    Column {
                        Text(
                            text = "VASOPRESSOR & INOTROPE STATION",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF38BDF8)
                        )
                        Text(
                            text = "Syringe pump recipes & weight-scaled rates for ${patientWeightKg.roundToInt()} kg",
                            fontSize = 11.sp,
                            color = Slate300
                        )
                    }
                }
            }
        }

        // Noradrenaline Card
        item {
            VasopressorDripCard(
                name = "Noradrenaline (Norepinephrine)",
                role = "First-Line Vasopressor (Septic, Cardiogenic, Neurogenic Shock)",
                target = "MAP ≥65 mmHg",
                recipe = "4 mg in 50 mL 5% Dextrose (Concentration: 80 mcg/mL)",
                doseRange = "0.05 to 1.0 mcg/kg/min",
                rateCalculation = { weight ->
                    val minRate = (0.05 * weight * 60) / 80.0
                    val stdRate = (0.2 * weight * 60) / 80.0
                    val highRate = (0.5 * weight * 60) / 80.0
                    "• Starting (0.05 mcg/kg/min): ${String.format(Locale.US, "%.1f", minRate)} mL/hr\n• Standard Titration (0.2 mcg/kg/min): ${String.format(Locale.US, "%.1f", stdRate)} mL/hr\n• High Refractory (0.5 mcg/kg/min): ${String.format(Locale.US, "%.1f", highRate)} mL/hr"
                },
                accentColor = Color(0xFF0284C7),
                patientWeightKg = patientWeightKg
            )
        }

        // Adrenaline Card
        item {
            VasopressorDripCard(
                name = "Adrenaline (Epinephrine)",
                role = "Refractory Shock, Anaphylaxis, Post-Arrest Bradycardia",
                target = "MAP ≥65 mmHg and Inotropic Support",
                recipe = "4 mg in 50 mL 5% Dextrose (Concentration: 80 mcg/mL)",
                doseRange = "0.05 to 0.5 mcg/kg/min",
                rateCalculation = { weight ->
                    val lowRate = (0.05 * weight * 60) / 80.0
                    val midRate = (0.15 * weight * 60) / 80.0
                    val highRate = (0.3 * weight * 60) / 80.0
                    "• Low Inotropic (0.05 mcg/kg/min): ${String.format(Locale.US, "%.1f", lowRate)} mL/hr\n• Moderate (0.15 mcg/kg/min): ${String.format(Locale.US, "%.1f", midRate)} mL/hr\n• Severe Shock (0.3 mcg/kg/min): ${String.format(Locale.US, "%.1f", highRate)} mL/hr"
                },
                accentColor = Color(0xFFEA580C),
                patientWeightKg = patientWeightKg
            )
        }

        // Vasopressin Card
        item {
            VasopressorDripCard(
                name = "Vasopressin",
                role = "Second-Line Non-Adrenergic Vasopressor in Sepsis",
                target = "Restore vascular tone / Sparing Noradrenaline",
                recipe = "20 Units in 50 mL Normal Saline (Concentration: 0.4 Units/mL)",
                doseRange = "Fixed 0.03 Units/min (DO NOT TITRATE)",
                rateCalculation = { _ ->
                    val rate = (0.03 * 60) / 0.4
                    "• Fixed Infusion: ${String.format(Locale.US, "%.1f", rate)} mL/hr (4.5 mL/hr = 0.03 units/min).\n*Note: Do not titrate up and down; keep at fixed rate to avoid mesenteric ischemia.*"
                },
                accentColor = Color(0xFF7C3AED),
                patientWeightKg = patientWeightKg
            )
        }

        // Dobutamine Card
        item {
            VasopressorDripCard(
                name = "Dobutamine",
                role = "Pure Inotrope (Beta-1 Agonist) for Cardiogenic Shock & Low Cardiac Output",
                target = "Cardiac Index >2.2 L/min/m2, ScvO2 >70%",
                recipe = "250 mg in 50 mL 5% Dextrose (Concentration: 5000 mcg/mL = 5 mg/mL)",
                doseRange = "2.5 to 20 mcg/kg/min",
                rateCalculation = { weight ->
                    val minRate = (2.5 * weight * 60) / 5000.0
                    val midRate = (5.0 * weight * 60) / 5000.0
                    val maxRate = (10.0 * weight * 60) / 5000.0
                    "• Low (2.5 mcg/kg/min): ${String.format(Locale.US, "%.1f", minRate)} mL/hr\n• Mid (5.0 mcg/kg/min): ${String.format(Locale.US, "%.1f", midRate)} mL/hr\n• Standard Inotrope (10 mcg/kg/min): ${String.format(Locale.US, "%.1f", maxRate)} mL/hr"
                },
                accentColor = Color(0xFF10B981),
                patientWeightKg = patientWeightKg
            )
        }
    }
}

@Composable
private fun VasopressorDripCard(
    name: String,
    role: String,
    target: String,
    recipe: String,
    doseRange: String,
    rateCalculation: (Double) -> String,
    accentColor: Color,
    patientWeightKg: Double
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.2.dp, accentColor.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = name, fontSize = 13.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                    Text(text = role, fontSize = 10.5.sp, color = Slate400)
                }
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = accentColor.copy(alpha = 0.2f)
                ) {
                    Text(
                        text = doseRange,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(6.dp),
                color = Color(0xFF1E293B),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(text = "🧪 Syringe Recipe: $recipe", fontSize = 11.sp, color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)
                    Text(text = "🎯 Target: $target", fontSize = 10.5.sp, color = Slate300)
                }
            }

            Surface(
                shape = RoundedCornerShape(6.dp),
                color = accentColor.copy(alpha = 0.1f),
                border = BorderStroke(0.8.dp, accentColor.copy(alpha = 0.3f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "CALCULATED PUMP FLOW RATES FOR ${patientWeightKg.roundToInt()} KG:",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Black,
                        color = accentColor
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = rateCalculation(patientWeightKg),
                        fontSize = 11.sp,
                        color = Color.White,
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun HighLethalityToxinsNepalSection(
    onOpenFullToxicology: () -> Unit
) {
    val toxicItems = remember {
        listOf(
            Triple(
                "Aluminum Phosphide (Celphos / QuickPhos)",
                "Rodenticide / Grain Fumigant (MORTALITY 60-90%)",
                "• PATHOLOGY: Reacts with moisture/HCl in stomach to release lethal Phosphine Gas (PH3), halting mitochondrial cytochrome c oxidase.\n• CRITICAL PROTOCOL: No specific antidote exists!\n• DO NOT PERFORM WATER GASTRIC LAVAGE (accelerates PH3 release). Use Sweet Almond / Coconut Oil (50-100 mL) to inhibit gas formation, or 1:10,000 Potassium Permanganate (KMnO4) to oxidize phosphine.\n• Resuscitation: High-dose Magnesium Sulfate (3g IV infusion, counters arrhythmias/myocardial necrosis). Rapid hemodialysis / ECMO if cardiogenic shock."
            ),
            Triple(
                "Organophosphates (Chlorpyrifos, Dichlorvos, Malathion)",
                "Pesticide Poisoning (Nepal Agricultural Belt)",
                "• PATHOLOGY: Irreversible inhibition of acetylcholinesterase leading to massive acetylcholine storm (Killer B's: Bronchorrhea, Bronchospasm, Bradycardia).\n• STAT PROTOCOL: Atropine 2 to 5 mg IV push immediately; double dose every 5-10 minutes until lungs are dry. 2-PAM 1-2g in 100 mL NS over 30 min.\n• Decontamination: Strip all clothes immediately and wash skin with soap/water (skin absorption continues indefinitely)."
            ),
            Triple(
                "Snakebite Envenomation (Elapidae: Krait & Cobra; Viperidae)",
                "Terai & Mid-Hills Envenomation Protocol (Nepal National Guidelines)",
                "• KRAIT BITES (Bungarus): Often nocturnal, painless bite with NO local swelling; presents in early morning with abdominal pain followed by progressive ptosis, bulbar palsy, and respiratory arrest.\n• PROTOCOL: Polyvalent ASV 10 vials in 200 mL NS over 1 hr. Intubate early for mechanical ventilation.\n• VIPER BITES: 20-Minute Whole Blood Clotting Test (20WBCT). If blood fails to clot at 20 min in clean glass tube, give 10 vials ASV."
            ),
            Triple(
                "Dhatura (Datura stramonium) & Belladonna",
                "Wild Anticholinergic Poisoning",
                "• TOXIDROME: 'Blind as a bat, mad as a hatter, red as a beet, hot as a hare, dry as a bone.' Mydriasis, delirium, hyperthermia, absent bowel sounds, urinary retention.\n• ANTIDOTE: Physostigmine 1 to 2 mg IV slow push over 5 minutes (reverses central delirium and peripheral anticholinergic crisis). Ensure ECG does not show wide QRS or prolonged QTc."
            ),
            Triple(
                "Methanol (Illicit Toxic Alcohol / Kacchi Raksi)",
                "Severe High Anion Gap Metabolic Acidosis & Blindness",
                "• PATHOLOGY: Formic acid accumulation causes severe optic nerve necrosis (snowstorm vision) and putaminal hemorrhage.\n• PROTOCOL: High-dose Sodium Bicarbonate 8.4% IV to maintain arterial pH >7.3. Fomepizole 15 mg/kg IV OR 10% Ethanol IV (loading 10 mL/kg). Folinic acid 50 mg IV q4h (accelerates formic acid elimination). Emergency Hemodialysis if methanol >50 mg/dL or severe acidosis."
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 20.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF261005),
                border = BorderStroke(1.2.dp, Color(0xFFF59E0B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "NEPAL HIGH-LETHALITY TOXICOLOGY",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFFBBF24)
                        )
                        Text(
                            text = "Immediate management of common rural ingestions & envenomations",
                            fontSize = 10.5.sp,
                            color = Color(0xFFFDE68A)
                        )
                    }

                    TextButton(onClick = onOpenFullToxicology) {
                        Text("All Antidotes ↗", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                    }
                }
            }
        }

        items(toxicItems) { (name, subtitle, text) ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF334155)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = name, fontSize = 13.5.sp, fontWeight = FontWeight.Black, color = Color.White)
                    Text(text = subtitle, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
                    Divider(color = Color(0xFF334155))
                    Text(text = text, fontSize = 11.sp, color = Slate200, lineHeight = 16.sp)
                }
            }
        }
    }
}
