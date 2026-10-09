package com.example.data.model

data class SurgicalPreOpDrug(
    val id: String,
    val drugName: String,
    val drugClass: String, // Antiplatelet, Anticoagulant (DOAC/Warfarin), Diabetes / Endocrine, Cardiovascular / Antihypertensive, Immunosuppressant, Herbal / OTC
    val cessationWindow: String, // e.g. "Hold 5 to 7 days prior", "Hold 24-48 hrs", "Hold morning of surgery", "Continue without interruption"
    val lowBleedRiskAction: String, // For minor procedures: dental, cataract, minor dermatologic
    val highBleedRiskAction: String, // For major abdominal, cardiothoracic, orthopedic, neurosurgery
    val bridgingProtocol: String?, // When and how to bridge with LMWH or Heparin (if applicable)
    val resumptionTimeline: String, // When to restart postoperatively
    val emergencyReversalAgent: String?, // Antidote if urgent/emergency surgery required (e.g. Idarucizumab, Andexanet, Vitamin K + PCC, Protamine)
    val clinicalRationale: String,
    val specialPrecautions: String
)

data class CriticalPanicLabValue(
    val id: String,
    val testName: String,
    val category: String, // Hematology, Electrolytes & Renal, Cardiac & Biomarkers, Blood Gas & Acid-Base, Coagulation, Endocrine & Metabolic
    val normalRange: String,
    val criticalLowValue: String?,
    val criticalHighValue: String?,
    val unit: String,
    val panicThresholdDescription: String,
    val immediateClinicalInterventions: List<String>,
    val commonEtiologies: String,
    val diagnosticPitfalls: String
)

data class DiagnosticRatioGuide(
    val id: String,
    val title: String,
    val formula: String,
    val cutoffThreshold: String,
    val interpretationHigh: String,
    val interpretationLow: String,
    val clinicalUtility: String,
    val nextDiagnosticSteps: String
)

data class StandardLabTest(
    val id: String,
    val name: String,
    val panel: String,
    val standardRange: String,
    val conventionalUnits: String,
    val siUnits: String = "",
    val siRange: String = "",
    val highSignificance: String,
    val lowSignificance: String,
    val clinicalPearls: String,
    val sampleTube: String = ""
)
