package com.example.data.model

data class SyndromicRegimen(
    val id: String,
    val syndrome: String,
    val category: String, // Respiratory, CNS, Genitourinary, Tropical/Vector, Sepsis, SSTI
    val setting: String, // Outpatient, Inpatient Ward, ICU
    val preferredFirstLine: String,
    val alternativeRegimen: String,
    val typicalDuration: String,
    val commonPathogens: String,
    val clinicalPearls: String,
    val redFlags: String,
    val nepalSpecificNotes: String = ""
)

enum class AwareClassification(val label: String, val badgeColorHex: Long) {
    ACCESS("Access (🟢 First / Second Line)", 0xFF10B981),
    WATCH("Watch (🟡 High Resistance Potential)", 0xFFF59E0B),
    RESERVE("Reserve (🔴 Last Resort Only)", 0xFFEF4444)
}

data class WhoAwareDrug(
    val genericName: String,
    val classification: AwareClassification,
    val keyIndications: String,
    val stewardshipGuidance: String,
    val commonDosage: String
)

data class LocalResistancePattern(
    val pathogen: String,
    val resistanceProfile: String,
    val prevalenceEstimate: String,
    val effectiveAgents: String,
    val discouragedAgents: String,
    val localGuidance: String
)
