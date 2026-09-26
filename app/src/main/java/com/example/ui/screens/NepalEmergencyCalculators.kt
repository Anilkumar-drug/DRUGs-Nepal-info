package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.calculator.ClinicalCalculators
import com.example.ui.theme.*

@Composable
fun IvInfusionCalculatorView() {
    var drugName by remember { mutableStateOf("Noradrenaline (Norepinephrine)") }
    var drugDoseMg by remember { mutableStateOf("4") } // 4 mg
    var bagVolumeMl by remember { mutableStateOf("50") } // 50 mL syringe pump
    var patientWeightKg by remember { mutableStateOf("60") } // 60 kg
    var doseRateMcgKgMin by remember { mutableStateOf("0.1") } // 0.1 mcg/kg/min

    val result = remember(drugName, drugDoseMg, bagVolumeMl, patientWeightKg, doseRateMcgKgMin) {
        val doseMg = drugDoseMg.toDoubleOrNull() ?: 0.0
        val volMl = bagVolumeMl.toDoubleOrNull() ?: 0.0
        val wtKg = patientWeightKg.toDoubleOrNull() ?: 0.0
        val rateMcg = doseRateMcgKgMin.toDoubleOrNull() ?: 0.0
        ClinicalCalculators.calculateIvInfusion(drugName, doseMg, volMl, wtKg, rateMcg)
    }

    Text(
        text = "IV Infusion & Drop Rate Counter",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "Calculates exact syringe pump rate (mL/hr) and gravity drip rate (gtt/min) for vasoactive and emergency infusions.",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    // Preset High-Alert Drugs
    Text("Select High-Alert Drug Preset:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        listOf(
            Triple("Noradrenaline", "4", "50"),
            Triple("Dopamine", "200", "50"),
            Triple("Dobutamine", "250", "50"),
            Triple("Nitroglycerin", "25", "50")
        ).forEach { (name, defDose, defVol) ->
            val isSelected = drugName.contains(name, ignoreCase = true)
            FilterChip(
                selected = isSelected,
                onClick = {
                    drugName = name
                    drugDoseMg = defDose
                    bagVolumeMl = defVol
                },
                label = { Text(name, fontSize = 11.5.sp) }
            )
        }
    }

    // Inputs: Drug Amount (mg) & Bag Volume (mL)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            value = drugDoseMg,
            onValueChange = { drugDoseMg = it },
            label = { Text("Total Drug (mg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.weight(1f)
        )
        OutlinedTextField(
            value = bagVolumeMl,
            onValueChange = { bagVolumeMl = it },
            label = { Text("Diluent Volume (mL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.weight(1f)
        )
    }

    // Inputs: Weight (kg) & Target Rate (mcg/kg/min)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            value = patientWeightKg,
            onValueChange = { patientWeightKg = it },
            label = { Text("Patient Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.weight(1f)
        )
        OutlinedTextField(
            value = doseRateMcgKgMin,
            onValueChange = { doseRateMcgKgMin = it },
            label = { Text("Rate (mcg/kg/min)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.weight(1f)
        )
    }

    // Results Card
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = Cyan500.copy(alpha = 0.12f),
        border = BorderStroke(1.2.dp, Cyan500.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Infusion Pump Rate", fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(
                        text = "${String.format("%.2f", result.pumpRateMlPerHour)} mL/hr",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Cyan500.copy(alpha = 0.25f)
                ) {
                    Text(
                        text = "${String.format("%.1f", result.concentrationMcgPerMl)} mcg/mL",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            HorizontalDivider(color = Cyan500.copy(alpha = 0.2f))

            // Gravity Drip Rates
            Text("Gravity Drip Rates (Drops/min):", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("Standard Macro (20 gtt/mL)", fontSize = 10.sp, color = Slate400)
                        Text("${result.standardDripRateGttPerMin} drops/min", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    }
                }
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("Micro Drip (60 gtt/mL)", fontSize = 10.sp, color = Slate400)
                        Text("${result.microDripRateGttPerMin} micro-gtt/min", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Emerald500)
                    }
                }
            }

            // Diluent Compatibility & Safeguard
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Diluent Compatibility: ${result.diluentCompatibility}", fontSize = 11.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface)
                    Text("⚠️ Caution: ${result.clinicalCaution}", fontSize = 10.5.sp, color = Red500)
                }
            }
        }
    }
}

@Composable
fun SnakebiteCalculatorView() {
    var isNeurotoxic by remember { mutableStateOf(true) }
    var isHemotoxic by remember { mutableStateOf(false) }
    var wbctUnclotted by remember { mutableStateOf(false) }
    var hasSystemicSigns by remember { mutableStateOf(true) }

    val result = remember(isNeurotoxic, isHemotoxic, wbctUnclotted, hasSystemicSigns) {
        ClinicalCalculators.calculateSnakebiteAsv(isNeurotoxic, isHemotoxic, wbctUnclotted, hasSystemicSigns)
    }

    Text(
        text = "Nepal National Snakebite Protocol & ASV",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "National Guideline for Snakebite Management in Nepal (EDCD / Ministry of Health).",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    // Checkbox Syndromes
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Clinical Envenomation Presentation:", fontSize = 12.sp, fontWeight = FontWeight.Bold)

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isNeurotoxic, onCheckedChange = { isNeurotoxic = it })
            Column {
                Text("Neurotoxic Signs (Krait / Cobra)", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Text("Bilateral ptosis, diplopia, broken-neck sign, respiratory muscle weakness", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isHemotoxic, onCheckedChange = { isHemotoxic = it })
            Column {
                Text("Hemotoxic Signs (Russell's / Pit Viper)", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Text("Spontaneous bleeding (gums, hematuria, hemoptysis), rapid local swelling", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = wbctUnclotted, onCheckedChange = { wbctUnclotted = it })
            Column {
                Text("20-Minute Whole Blood Clotting Test (20WBCT) Unclotted", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = if (wbctUnclotted) Red500 else MaterialTheme.colorScheme.onSurface)
                Text("Blood remains completely liquid after 20 minutes in clean dry glass tube", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }

    // Results Card
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = if (result.initialAsvDoseVials > 0) Red500.copy(alpha = 0.12f) else Emerald500.copy(alpha = 0.12f),
        border = BorderStroke(1.2.dp, if (result.initialAsvDoseVials > 0) Red500.copy(alpha = 0.45f) else Emerald500.copy(alpha = 0.45f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Polyvalent ASV Indication", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(
                        text = if (result.initialAsvDoseVials > 0) "${result.initialAsvDoseVials} Vials Stat" else "No ASV Indicated",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = if (result.initialAsvDoseVials > 0) Red500 else Emerald500
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = result.envenomationType,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Text(result.diluentGuidance, fontSize = 11.5.sp, lineHeight = 16.sp, color = MaterialTheme.colorScheme.onSurface)

            if (result.neostigmineTestProtocol != null) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF0F2A3F),
                    border = BorderStroke(0.8.dp, Color(0xFF0284C7))
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text("Neostigmine Atropine-First Test Protocol", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(result.neostigmineTestProtocol!!, fontSize = 11.sp, color = Color.White, lineHeight = 15.sp)
                    }
                }
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Red950.copy(alpha = 0.35f),
                border = BorderStroke(0.8.dp, Red500)
            ) {
                Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.Warning, contentDescription = null, tint = Red400, modifier = Modifier.size(16.dp))
                    Text(result.adrenalinePrecaution, fontSize = 10.5.sp, color = Color.White, lineHeight = 14.sp)
                }
            }
        }
    }
}

@Composable
fun RabiesPepCalculatorView() {
    var patientWeightKg by remember { mutableStateOf("50") }
    var selectedCategory by remember { mutableIntStateOf(3) } // Category III bite standard
    var isIntradermal by remember { mutableStateOf(true) } // 2-site ID standard in Nepal

    val result = remember(patientWeightKg, selectedCategory, isIntradermal) {
        val wt = patientWeightKg.toDoubleOrNull() ?: 0.0
        ClinicalCalculators.calculateRabiesPep(wt, selectedCategory, isIntradermal)
    }

    Text(
        text = "Rabies Post-Exposure Prophylaxis (PEP)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "WHO / EDCD Nepal National Rabies Guidelines: Wound washing, Vaccine, and Immunoglobulin (RIG).",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    // Patient Weight
    OutlinedTextField(
        value = patientWeightKg,
        onValueChange = { patientWeightKg = it },
        label = { Text("Patient Weight (kg)") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )

    // WHO Category Selection
    Text("WHO Exposure Category:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        listOf(
            1 to "Category I (No Break)",
            2 to "Category II (Minor Scratch)",
            3 to "Category III (Bite / Bleeding)"
        ).forEach { (cat, label) ->
            val isSel = selectedCategory == cat
            FilterChip(
                selected = isSel,
                onClick = { selectedCategory = cat },
                label = { Text(label, fontSize = 11.sp) },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            )
        }
    }

    // Regimen Switcher: Intradermal (Thai Red Cross) vs Intramuscular (Essen)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = isIntradermal,
            onClick = { isIntradermal = true },
            label = { Text("Intradermal 2-site ID (Nepal Govt)", fontSize = 11.5.sp) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f)
        )
        FilterChip(
            selected = !isIntradermal,
            onClick = { isIntradermal = false },
            label = { Text("Intramuscular Essen IM", fontSize = 11.5.sp) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f)
        )
    }

    // Results Card
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        border = BorderStroke(1.2.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(result.categoryText, fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)

            Surface(shape = RoundedCornerShape(8.dp), color = MaterialTheme.colorScheme.surface) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Vaccine Schedule & Dose:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = DimsTealPrimary)
                    Text(result.vaccineRegimen, fontSize = 11.5.sp, lineHeight = 16.sp, color = MaterialTheme.colorScheme.onSurface)
                }
            }

            if (result.rigIndication) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Red500.copy(alpha = 0.12f),
                    border = BorderStroke(0.8.dp, Red500.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Rabies Immunoglobulin (RIG):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Red500)
                            Text("${result.rigDoseIU.toInt()} IU (${String.format("%.1f", result.rigVolumeMl)} mL ERIG)", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = Red500)
                        }
                        Text("Equine RIG 40 IU/kg (300 IU/mL). Infiltrate locally into and around all bite wounds. Give remainder IM at distant site.", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = DimsTealLight,
                border = BorderStroke(0.8.dp, DimsTealBorder)
            ) {
                Text(result.woundManagementGuidance, modifier = Modifier.padding(10.dp), fontSize = 11.sp, lineHeight = 15.sp, color = DimsTealDark)
            }
        }
    }
}
