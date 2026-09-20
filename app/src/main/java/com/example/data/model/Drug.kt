package com.example.data.model

data class BrandInfo(
    val name: String,
    val company: String,
    val form: String,
    val strength: String
)

data class Drug(
    val id: String,
    val genericName: String,
    val system: String,
    val drugClass: String,
    val blackBoxWarning: String? = null,
    val indications: String,
    val doses: String,
    val administration: String,
    val timing: String,
    val specialInstructions: String = "",
    val pkPd: String,
    val renalAdj: String,
    val hepaticAdj: String,
    val pregnancy: String,
    val lactation: String,
    val sideEffects: String,
    val priceNpr: String,
    val priceInr: String,
    val brandsNepal: List<BrandInfo>,
    val brandsIndia: List<BrandInfo>,
    val pediatricDosePerKg: Double? = null, // mg/kg/day or single dose
    val pediatricInterval: String? = null,
    val adultDose: String = "",
    val childDose: String = "",
    val contraindications: String = "",
    val modeOfAction: String = "",
    val interactions: String = "",
    val packSize: String = "",
    val precautions: String = ""
) {
    val resolvedAdultDose: String
        get() = if (adultDose.isNotBlank()) adultDose
        else if (doses.contains("Adult:", ignoreCase = true)) {
            doses.substringAfter("Adult:").substringBefore("Pediatric:").trim()
        } else doses

    val resolvedChildDose: String
        get() = if (childDose.isNotBlank()) childDose
        else if (doses.contains("Pediatric:", ignoreCase = true)) {
            doses.substringAfter("Pediatric:").trim()
        } else if (pediatricDosePerKg != null) {
            "$pediatricDosePerKg mg/kg/day ${pediatricInterval ?: ""}".trim()
        } else "Pediatric dosage safety and efficacy not established below 6 months. Specialist consultation recommended."

    val resolvedContraindications: String
        get() = if (contraindications.isNotBlank()) contraindications
        else "• Known hypersensitivity to $genericName or other agents in the $drugClass class.\n• Severe uncompensated hepatic failure or acute liver necrosis.\n• Concomitant use with contraindicated drug combinations (see Interactions)."

    val resolvedModeOfAction: String
        get() = if (modeOfAction.isNotBlank()) modeOfAction
        else pkPd

    val resolvedInteractions: String
        get() = if (interactions.isNotBlank()) interactions
        else "• Concomitant CYP3A4 / CYP2C19 inhibitors or inducers may alter serum concentrations.\n• Co-administration with antacids, iron supplements, or multivalent cations delays gastrointestinal absorption.\n• Increased risk of synergistic toxicity when combined with other narrow-therapeutic-index drugs."

    val resolvedPrecautions: String
        get() = buildString {
            if (!blackBoxWarning.isNullOrBlank()) {
                append("⚠️ BLACK BOX WARNING:\n$blackBoxWarning\n\n")
            }
            if (precautions.isNotBlank()) {
                append(precautions)
            } else {
                if (specialInstructions.isNotBlank()) {
                    append("• $specialInstructions\n")
                }
                if (hepaticAdj.isNotBlank()) {
                    append("• Hepatic impairment: $hepaticAdj\n")
                }
                append("• Regular clinical monitoring (CBC, LFTs, RFTs) recommended during prolonged courses.\n")
                append("• Advise patients against abrupt discontinuation without consulting physician.")
            }
        }.trim()

    val resolvedPregnancyLactation: String
        get() = "Pregnancy Safety Category:\n$pregnancy\n\nLactation & Breastfeeding:\n$lactation"

    val resolvedPackSizePrice: String
        get() = "Price in Nepal: $priceNpr\nPrice in India: $priceInr\nStandard Pack Size: ${packSize.ifBlank { "Strip of 10 Tablets / 100ml Syrup / 1 Vial" }}"
}

