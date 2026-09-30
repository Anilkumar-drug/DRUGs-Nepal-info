package com.example.data.model

data class IvInfusionGuide(
    val id: String,
    val drugName: String,
    val primaryIndication: String,
    val preferredDiluents: List<String>, // "D5W", "0.9% NS", "Ringer's Lactate"
    val forbiddenDiluents: List<String>, // e.g. "Dextrose (precipitates)", "Saline"
    val standardConcentration: String,
    val maxPeripheralConcentration: String,
    val centralLineMandatory: Boolean,
    val infusionRateGuidelines: String,
    val filterRequired: String = "Standard",
    val lightProtection: Boolean = false,
    val ySiteIncompatibilities: List<String>,
    val fatalWarnings: String? = null
)
