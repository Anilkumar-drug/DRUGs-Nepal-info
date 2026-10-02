package com.example.data.model

data class Top100Drug(
    val id: String,
    val name: String,
    val commonExamples: String,
    val system: String,
    val indications: List<String>,
    val mechanismOfAction: String,
    val adverseEffects: String,
    val warnings: String,
    val interactions: String,
    val prescription: String,
    val administration: String,
    val communication: String,
    val monitoring: String,
    val cost: String,
    val clinicalTip: String
)

data class ClinicalSbaQuestion(
    val id: Int,
    val system: String, // CVS, RS, NS, GIS, Renal/GU, MSK, Blood, Infection, Poisoning, Fluids
    val topic: String,  // Indications, Mechanisms, AEs, Warnings, Interactions, Prescription, Admin, Comm, Monitoring
    val vignette: String,
    val question: String,
    val options: List<String>, // Exactly 5 options: A, B, C, D, E
    val correctIndex: Int,     // 0 for A, 1 for B, 2 for C, 3 for D, 4 for E
    val correctLetter: String, // "A", "B", "C", "D", "E"
    val correctDrug: String,
    val explanation: String
)

data class IvFluidMonograph(
    val id: String,
    val name: String,
    val type: String, // Crystalloid, Colloid, Dextrose, Additive
    val composition: String,
    val indications: List<String>,
    val mechanismOfAction: String,
    val adverseEffects: String,
    val warnings: String,
    val prescription: String,
    val administration: String,
    val monitoring: String,
    val cost: String,
    val clinicalTip: String
)
