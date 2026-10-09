package com.example.data.model

import androidx.compose.ui.graphics.Color

// ==========================================
// 1. TOPICAL CORTICOSTEROID LADDER MODELS
// ==========================================

enum class SteroidPotencyClass(
    val classNumber: Int,
    val romanNumeral: String,
    val categoryName: String,
    val potencyLevel: String,
    val badgeColorHex: Long
) {
    CLASS_1(1, "Class I", "Superpotent", "Ultra-High Potency", 0xFFDC2626), // Red 600
    CLASS_2(2, "Class II", "Potent", "High Potency", 0xFFEA580C),        // Orange 600
    CLASS_3(3, "Class III", "Upper Mid-Strength", "High-Medium", 0xFFD97706), // Amber 600
    CLASS_4(4, "Class IV", "Mid-Strength", "Medium Potency", 0xFFCA8A04),   // Yellow 600
    CLASS_5(5, "Class V", "Lower Mid-Strength", "Lower-Medium", 0xFF16A34A), // Green 600
    CLASS_6(6, "Class VI", "Mild", "Low Potency", 0xFF0D9488),          // Teal 600
    CLASS_7(7, "Class VII", "Least Potent", "Ultra-Low Potency", 0xFF2563EB) // Blue 600
}

data class TopicalSteroidAgent(
    val id: String,
    val genericName: String,
    val strength: String,
    val formulation: String, // Ointment, Cream, Gel, Lotion, Scalp Solution
    val potencyClass: SteroidPotencyClass,
    val commonNepalBrands: List<String>,
    val approvedIndications: List<String>,
    val maxDurationWeeks: String,
    val permissibleBodySites: List<String>,
    val contraindicatedSites: List<String>,
    val clinicalNotes: String,
    val systemicAbsorptionRisk: String // "Very High", "Moderate", "Low", "Minimal"
)

data class BodySiteRecommendation(
    val anatomicalArea: String,
    val recommendedClasses: List<SteroidPotencyClass>,
    val prohibitedClasses: List<SteroidPotencyClass>,
    val maxTreatmentDuration: String,
    val defaultFtuAdult: Double,
    val clinicalPearls: String,
    val severeAdverseRisk: String
)

data class FtuCalculationArea(
    val id: String,
    val name: String,
    val ftuPerApplication: Double,
    val gramPerApplication: Double
)

// ==========================================
// 2. BLOOD TRANSFUSION & MTP MODELS
// ==========================================

enum class BloodProductType(val displayName: String, val unitVolume: String, val storageTemp: String) {
    PRBC("Packed Red Blood Cells (PRBC)", "250 - 350 mL", "2°C to 6°C"),
    FFP("Fresh Frozen Plasma (FFP)", "200 - 250 mL", "≤ -18°C (thawed 30-37°C)"),
    PLATELETS_RDP("Random Donor Platelets (RDP)", "50 - 70 mL / unit", "20°C to 24°C (agitation)"),
    PLATELETS_SDP("Single Donor Apheresis Platelets", "200 - 300 mL (pool of 6 RDP)", "20°C to 24°C (agitation)"),
    CRYOPRECIPITATE("Cryoprecipitate (Antihemophilic)", "15 - 20 mL / unit (Pool 5-10 u)", "≤ -18°C (thawed before use)"),
    WHOLE_BLOOD("Whole Blood (Unseparated)", "350 - 450 mL", "2°C to 6°C")
}

data class TransfusionTriggerGuideline(
    val id: String,
    val patientCategory: String,
    val triggerThreshold: String,
    val targetLevel: String,
    val recommendationLevel: String, // "Strong (Grade 1A)", etc.
    val trialEvidence: String,      // TRICC, TRISS, REALITY, MINT, etc.
    val specialConsiderations: String
)

data class MtpPackStage(
    val stageNumber: Int,
    val title: String,
    val prbcUnits: Int,
    val ffpUnits: Int,
    val plateletDose: String,
    val cryoprecipitateUnits: String,
    val adjunctiveTherapy: List<String>,
    val monitoringTargets: List<String>
)

data class TransfusionReactionProtocol(
    val id: String,
    val reactionName: String,
    val severityLevel: String, // "Life-Threatening Emergency", "Severe", "Moderate", "Mild"
    val clinicalPresentation: List<String>,
    val pathophysiology: String,
    val immediateStep1Action: String,
    val pharmacotherapy: List<String>,
    val laboratoryInvestigations: List<String>,
    val futurePrevention: String
)
