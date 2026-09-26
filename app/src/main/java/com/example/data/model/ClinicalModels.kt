package com.example.data.model

data class CalculatorSummary(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val formulaSummary: String,
    val aliases: List<String> = emptyList()
)

enum class GlobalSearchTab(val label: String) {
    ALL("All Results"),
    DRUGS("Drugs"),
    PROTOCOLS("Protocols"),
    CALCULATORS("Calculators")
}

data class DiseaseProtocol(
    val id: String,
    val name: String,
    val category: String,
    val firstLine: String,
    val secondLine: String,
    val inpatient: String,
    val guidelines: String,
    val icd10: String = "",
    val diagnosticCriteria: String = "",
    val keyDrugs: List<String> = emptyList(),
    val supportiveCare: String = "",
    val redFlags: String = "",
    val references: List<String> = emptyList()
)

data class Antidote(
    val id: String,
    val poison: String,
    val antidote: String,
    val dosing: String,
    val notes: String,
    val urgency: String = "CRITICAL"
)

data class ChatMessage(
    val id: String,
    val sender: MessageSender,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)

enum class MessageSender {
    USER, AI
}

enum class AppThemeMode {
    LIGHT, DARK, PITCH_BLACK
}

enum class FontSizeScale(val scaleFactor: Float, val label: String) {
    TINY(0.85f, "Tiny"),
    SMALL(0.92f, "Small"),
    NORMAL(1.0f, "Normal"),
    LARGE(1.12f, "Large"),
    XLARGE(1.25f, "X-Large")
}

enum class InteractionSeverity(val label: String, val level: Int) {
    CONTRAINDICATED("Contraindicated", 3),
    SERIOUS("Serious / Monitor Closely", 2),
    MODERATE("Moderate Interaction", 1),
    MINOR("Minor / Informational", 0)
}

data class DrugInteraction(
    val drug1Generic: String,
    val drug2Generic: String,
    val severity: InteractionSeverity,
    val effect: String,
    val mechanism: String,
    val clinicalAction: String,
    val sourceDatabase: String = "UpToDate / Lexicomp",
    val documentationLevel: String = "Established (Class A)",
    val riskCategory: String = "Pharmacodynamic / Kinetic"
)

data class CompanyDrugBrand(
    val drug: Drug,
    val brand: BrandInfo,
    val isNepal: Boolean
)

data class CompanyProfile(
    val name: String,
    val country: String,
    val products: List<CompanyDrugBrand>
)
