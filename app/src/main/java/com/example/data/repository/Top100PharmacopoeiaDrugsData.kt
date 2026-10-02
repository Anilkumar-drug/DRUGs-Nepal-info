package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug
import com.example.data.model.Top100Drug

object Top100PharmacopoeiaDrugsData {

    private fun mapToAppDrug(t: Top100Drug): Drug {
        val rawExamples = t.commonExamples.split(",", ";").map { it.trim() }.filter { it.isNotEmpty() }
        
        val brandsNepalList = rawExamples.map { ex ->
            val cleanBrand = ex.replace(Regex("\\(.*?\\)"), "").trim()
            val finalName = if (cleanBrand.length in 3..25) cleanBrand else t.name.substringBefore("(").trim()
            BrandInfo(
                name = finalName,
                company = "Nepal National Formulary / DDA",
                form = if (t.prescription.contains("IV", ignoreCase = true) || t.administration.contains("IV", ignoreCase = true)) "Oral / Injection" else "Oral Formulations",
                strength = "Standard Clinical Strengths"
            )
        }.distinctBy { it.name }.take(4)

        val brandsIndiaList = rawExamples.map { ex ->
            val cleanBrand = ex.replace(Regex("\\(.*?\\)"), "").trim()
            val finalName = if (cleanBrand.length in 3..25) cleanBrand else t.name.substringBefore("(").trim()
            BrandInfo(
                name = finalName,
                company = "Multinational / Indian Pharmacopoeia",
                form = "Oral / IV / Topical",
                strength = "Standard Formulations"
            )
        }.distinctBy { it.name }.take(4)

        val cleanGeneric = t.name.replace(Regex("\\(.*?\\)"), "").trim()
        val hasSevereWarning = t.warnings.contains("CONTRAINDICATED", ignoreCase = true) ||
                t.warnings.contains("WARNING", ignoreCase = true) ||
                t.warnings.contains("FATAL", ignoreCase = true) ||
                t.warnings.contains("NEVER", ignoreCase = true)

        return Drug(
            id = "t100_core_${t.id.removePrefix("t100_")}",
            genericName = cleanGeneric,
            system = t.system,
            drugClass = t.name,
            blackBoxWarning = if (hasSevereWarning) t.warnings else null,
            indications = t.indications.joinToString(". "),
            doses = t.prescription,
            administration = t.administration,
            timing = "Refer to specific clinical indication and prescriber directions.",
            specialInstructions = t.clinicalTip,
            pkPd = t.mechanismOfAction,
            renalAdj = if (t.warnings.contains("renal", ignoreCase = true) || t.prescription.contains("CKD", ignoreCase = true)) t.warnings else "Adjust dose per clinical assessment; monitor eGFR / CrCl.",
            hepaticAdj = if (t.warnings.contains("liver", ignoreCase = true) || t.warnings.contains("hepatic", ignoreCase = true)) t.warnings else "Use with caution in severe hepatic impairment.",
            pregnancy = if (t.warnings.contains("pregnancy", ignoreCase = true) || t.warnings.contains("teratogen", ignoreCase = true)) "Caution / Review warnings: ${t.warnings.take(120)}" else "Evaluate maternal-fetal benefit/risk profile prior to initiation.",
            lactation = if (t.warnings.contains("lactat", ignoreCase = true) || t.warnings.contains("breastfeeding", ignoreCase = true)) "Assess benefit/risk during lactation." else "Compatible with routine clinical precautions.",
            sideEffects = t.adverseEffects,
            priceNpr = t.cost,
            priceInr = t.cost,
            brandsNepal = if (brandsNepalList.isNotEmpty()) brandsNepalList else listOf(BrandInfo(cleanGeneric, "National Essential List", "Oral/Inj", "Standard")),
            brandsIndia = if (brandsIndiaList.isNotEmpty()) brandsIndiaList else listOf(BrandInfo(cleanGeneric, "Generic Formulary", "Oral/Inj", "Standard")),
            pediatricDosePerKg = null,
            pediatricInterval = null,
            adultDose = t.prescription,
            childDose = t.prescription,
            contraindications = t.warnings,
            modeOfAction = t.mechanismOfAction,
            interactions = t.interactions,
            precautions = t.communication,
            nemlCategory = "National Essential Medicines List (Nepal DDA / Core Clinical)",
            ddaSchedule = "Schedule Kha / Ga (Prescription Medicine)",
            beersCriteriaRisk = if (t.warnings.contains("elderly", ignoreCase = true) || t.adverseEffects.contains("confusion", ignoreCase = true)) "Use with caution in elderly patients" else null,
            pregTrimester1 = "Evaluate benefit/risk",
            pregTrimester2 = "Evaluate benefit/risk",
            pregTrimester3 = "Evaluate benefit/risk",
            counselingNepali = t.communication,
            counselingEnglish = t.communication,
            suspensionOptions = emptyList(),
            era = "Essential Pharmacopoeia",
            therapeuticClassTag = t.system,
            researchNotes = t.clinicalTip
        )
    }

    val drugs: List<Drug> = Top100DrugsData.top100Drugs.map { mapToAppDrug(it) }
}
