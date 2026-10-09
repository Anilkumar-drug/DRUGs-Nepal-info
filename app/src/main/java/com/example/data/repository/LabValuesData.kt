package com.example.data.repository

import com.example.data.model.CriticalPanicLabValue
import com.example.data.model.DiagnosticRatioGuide
import com.example.data.model.StandardLabTest

object LabValuesData {

    val panicValues: List<CriticalPanicLabValue> = EmergencyPanicLabValuesData.panicValues

    val diagnosticRatios: List<DiagnosticRatioGuide> = ClinicalDiagnosticRatiosData.diagnosticRatios

    val standardLabTests: List<StandardLabTest> = ComprehensiveStandardLabPanelsData.standardLabTests

    val labPanels: List<String> = listOf(
        "All Panels",
        "Complete Blood Count (CBC)",
        "Renal & Electrolytes (RFT)",
        "Liver Function Tests (LFT)",
        "Cardiac & Coagulation",
        "Diabetes & Endocrine",
        "Inflammatory & Sepsis Markers",
        "Arterial Blood Gas (ABG)",
        "CSF & Fluid Analysis",
        "Urinalysis",
        "Therapeutic Drug Monitoring (TDM)"
    )
}
