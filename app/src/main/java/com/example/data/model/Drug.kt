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
    val pediatricInterval: String? = null
)
