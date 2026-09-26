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
    val precautions: String = "",
    val nemlCategory: String = "",
    val ddaSchedule: String = "",
    val beersCriteriaRisk: String? = null,
    val pregTrimester1: String = "",
    val pregTrimester2: String = "",
    val pregTrimester3: String = "",
    val counselingNepali: String = "",
    val counselingEnglish: String = "",
    val suspensionOptions: List<String> = emptyList()
) {
    val resolvedNeml: String
        get() = if (nemlCategory.isNotBlank()) nemlCategory
        else if (isFreeHealthPostDrug) "NEML: Free Essential Drug (Health Post & PHC Level)"
        else "NEML: Secondary / Tertiary Hospital Formulary"

    val resolvedDdaSchedule: String
        get() = if (ddaSchedule.isNotBlank()) ddaSchedule
        else when {
            system.contains("CNS", ignoreCase = true) && (genericName.contains("Alprazolam", ignoreCase = true) || genericName.contains("Tramadol", ignoreCase = true) || genericName.contains("Diazepam", ignoreCase = true)) -> "Schedule Ka (Narcotic / Psychotropic - Record Register Mandatory)"
            genericName.contains("Paracetamol", ignoreCase = true) || genericName.contains("ORS", ignoreCase = true) || genericName.contains("Cetirizine", ignoreCase = true) -> "Schedule Ga (Over-The-Counter / General Sales)"
            else -> "Schedule Kha (Prescription Only Medicine - POM)"
        }

    val isFreeHealthPostDrug: Boolean
        get() = genericName.contains("Paracetamol", ignoreCase = true) ||
                genericName.contains("Amoxicillin", ignoreCase = true) ||
                genericName.contains("ORS", ignoreCase = true) ||
                genericName.contains("Albendazole", ignoreCase = true) ||
                genericName.contains("Metronidazole", ignoreCase = true) ||
                genericName.contains("Ciprofloxacin", ignoreCase = true) ||
                genericName.contains("Cotrimoxazole", ignoreCase = true) ||
                genericName.contains("Iron", ignoreCase = true) ||
                genericName.contains("Salbutamol", ignoreCase = true)

    val resolvedBeersRisk: String?
        get() = beersCriteriaRisk ?: when {
            genericName.contains("Alprazolam", ignoreCase = true) || genericName.contains("Diazepam", ignoreCase = true) ->
                "Beers 2023 Criteria: AVOID in older adults (≥65y). High risk of cognitive impairment, delirium, falls, fractures, and motor vehicle accidents."
            genericName.contains("Amitriptyline", ignoreCase = true) ->
                "Beers 2023 Criteria: AVOID. Highly anticholinergic, sedating; causes orthostatic hypotension, urinary retention, and cardiac arrhythmias."
            genericName.contains("Tramadol", ignoreCase = true) ->
                "Beers 2023 Criteria: CAUTION. High risk of SIADH/hyponatremia, CNS depression, seizures, and serotonin syndrome."
            genericName.contains("Diclofenac", ignoreCase = true) || genericName.contains("Ketorolac", ignoreCase = true) || genericName.contains("Ibuprofen", ignoreCase = true) ->
                "Beers 2023 Criteria: AVOID chronic use. Induces GI ulceration, bleeding, acute renal failure, and exacerbates heart failure/hypertension."
            genericName.contains("Digoxin", ignoreCase = true) ->
                "Beers 2023 Criteria: AVOID as first-line for AF or heart failure. Doses >0.125 mg/day offer no additional benefit and increase toxicity risk."
            genericName.contains("Domperidone", ignoreCase = true) || genericName.contains("Metoclopramide", ignoreCase = true) ->
                "Beers 2023 Criteria: AVOID. Can cause extrapyramidal symptoms, including tardive dyskinesia."
            else -> null
        }

    val resolvedT1Safety: String
        get() = if (pregTrimester1.isNotBlank()) pregTrimester1
        else if (pregnancy.contains("Category X", ignoreCase = true) || pregnancy.contains("Contraindicated", ignoreCase = true)) "Contraindicated"
        else if (pregnancy.contains("Category D", ignoreCase = true)) "High Risk"
        else if (pregnancy.contains("Category B", ignoreCase = true) || pregnancy.contains("Safe", ignoreCase = true)) "Safe"
        else "Caution"

    val resolvedT2Safety: String
        get() = if (pregTrimester2.isNotBlank()) pregTrimester2
        else if (pregnancy.contains("Category X", ignoreCase = true) || pregnancy.contains("Contraindicated", ignoreCase = true)) "Contraindicated"
        else if (genericName.contains("Telmisartan", ignoreCase = true) || genericName.contains("Ramipril", ignoreCase = true) || genericName.contains("Losartan", ignoreCase = true)) "Contraindicated (Fetotoxic)"
        else if (pregnancy.contains("Category D", ignoreCase = true)) "High Risk"
        else if (pregnancy.contains("Category B", ignoreCase = true) || pregnancy.contains("Safe", ignoreCase = true)) "Safe"
        else "Caution"

    val resolvedT3Safety: String
        get() = if (pregTrimester3.isNotBlank()) pregTrimester3
        else if (pregnancy.contains("Category X", ignoreCase = true) || pregnancy.contains("Contraindicated", ignoreCase = true)) "Contraindicated"
        else if (genericName.contains("Telmisartan", ignoreCase = true) || genericName.contains("Ramipril", ignoreCase = true)) "Contraindicated (Oligohydramnios / Anuria)"
        else if (genericName.contains("Diclofenac", ignoreCase = true) || genericName.contains("Ketorolac", ignoreCase = true) || genericName.contains("Ibuprofen", ignoreCase = true)) "Contraindicated (Premature Ductus Closure)"
        else if (pregnancy.contains("Category D", ignoreCase = true)) "High Risk"
        else if (pregnancy.contains("Category B", ignoreCase = true) || pregnancy.contains("Safe", ignoreCase = true)) "Safe"
        else "Caution"

    val resolvedNepaliCounseling: String
        get() = if (counselingNepali.isNotBlank()) counselingNepali
        else when {
            genericName.contains("Pantoprazole", ignoreCase = true) || genericName.contains("Omeprazole", ignoreCase = true) ->
                "बिहानको खाना खानु भन्दा ३० देखि ६० मिनेट अगाडि खाली पेटमा पानीसँग खानुहोस्।"
            genericName.contains("Paracetamol", ignoreCase = true) ->
                "ज्वरो वा दुखाइ हुँदा मात्र खानुहोस्। कम्तिमा ४ देखि ६ घण्टाको फरकमा लिनुहोस्। दिनमा ४ ग्राम (८ चक्की) भन्दा बढी नलिनुहोस्।"
            genericName.contains("Metformin", ignoreCase = true) ->
                "खानासँगै वा खाना खाएपछि तुरुन्तै खानुहोस् जसले गर्दा पेट गडबड हुने सम्भावना कम हुन्छ।"
            genericName.contains("Amoxicillin", ignoreCase = true) || genericName.contains("Azithromycin", ignoreCase = true) || genericName.contains("Cefixime", ignoreCase = true) ->
                "डाक्टरले तोकेको दिनसम्म पूरा मात्रा खानुहोस्। सन्चो भए पनि बीचमै औषधि नछोड्नुहोस्।"
            genericName.contains("Telmisartan", ignoreCase = true) || genericName.contains("Amlodipine", ignoreCase = true) ->
                "प्रत्येक दिन एउटै निश्चित समयमा खानुहोस्। प्रेसर नियन्त्रण भए पनि औषधि निरन्तर खानुपर्छ।"
            genericName.contains("Salbutamol", ignoreCase = true) ->
                "दम बढेको बेला इनहेलर राम्ररी हल्लाएर २ पफ लिनुहोस् र १० सेकेन्ड सास रोक्नुहोस्।"
            genericName.contains("Atorvastatin", ignoreCase = true) ->
                "राति सुत्ने समयमा खाना खाइसकेपछि १ चक्की खानुहोस्।"
            genericName.contains("Diclofenac", ignoreCase = true) || genericName.contains("Ibuprofen", ignoreCase = true) ->
                "सधैं खाना खाएपछि मात्र खानुहोस्। पेटमा ग्यास्ट्रिक वा दुखाइ भए तुरुन्तै रोक्नुहोस्।"
            else -> "डाक्टर वा फार्मासिस्टको सल्लाह अनुसार नियमित रूपमा समयमै सेवन गर्नुहोस्।"
        }

    val resolvedEnglishCounseling: String
        get() = if (counselingEnglish.isNotBlank()) counselingEnglish
        else when {
            genericName.contains("Pantoprazole", ignoreCase = true) || genericName.contains("Omeprazole", ignoreCase = true) ->
                "Take once daily on an empty stomach, 30 to 60 minutes before morning breakfast."
            genericName.contains("Paracetamol", ignoreCase = true) ->
                "Take strictly PRN for fever or pain with at least 4 to 6 hours between doses. Do not exceed 4g (8 tablets) in 24 hours."
            genericName.contains("Metformin", ignoreCase = true) ->
                "Take with or immediately after meals to reduce stomach upset and nausea."
            genericName.contains("Amoxicillin", ignoreCase = true) || genericName.contains("Azithromycin", ignoreCase = true) ->
                "Complete the full prescribed antimicrobial course even if symptoms resolve earlier to prevent bacterial resistance."
            genericName.contains("Telmisartan", ignoreCase = true) || genericName.contains("Amlodipine", ignoreCase = true) ->
                "Take daily at the same time. Do not discontinue without physician consultation even if blood pressure normalizes."
            genericName.contains("Atorvastatin", ignoreCase = true) ->
                "Take once daily in the evening or at bedtime with or without food."
            else -> "Take exactly as directed by your physician or pharmacist. Keep out of reach of children."
        }
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

