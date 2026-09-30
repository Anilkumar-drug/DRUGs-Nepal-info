package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.RenalAdjustmentEntry
import com.example.data.repository.RenalDrugAdjustmentData
import com.example.ui.theme.*
import java.util.Locale
import kotlin.math.min
import kotlin.math.max
import kotlin.math.pow

@Composable
fun RenalDoseCalculatorScreen(
    onBackClick: () -> Unit
) {
    var ageText by remember { mutableStateOf("60") }
    var weightText by remember { mutableStateOf("65") }
    var isFemale by remember { mutableStateOf(false) }
    var serumCrText by remember { mutableStateOf("1.8") }
    var searchQuery by remember { mutableStateOf("") }

    val age = ageText.toDoubleOrNull() ?: 60.0
    val weight = weightText.toDoubleOrNull() ?: 65.0
    val serumCr = serumCrText.toDoubleOrNull() ?: 1.8

    // Cockcroft-Gault Creatinine Clearance: ((140 - Age) * Weight) / (72 * Cr) * (0.85 if female)
    val crCl = remember(age, weight, isFemale, serumCr) {
        if (serumCr > 0.0) {
            val base = ((140.0 - age) * weight) / (72.0 * serumCr)
            val adjusted = if (isFemale) base * 0.85 else base
            String.format(Locale.US, "%.1f", adjusted.coerceAtLeast(1.0)).toDouble()
        } else 90.0
    }

    // CKD-EPI 2021 eGFR without race:
    // eGFR = 142 * min(Scr/kappa, 1)^alpha * max(Scr/kappa, 1)^-1.200 * 0.9938^Age * (1.012 if female)
    val egfr = remember(age, isFemale, serumCr) {
        if (serumCr > 0.0) {
            val kappa = if (isFemale) 0.7 else 0.9
            val alpha = if (isFemale) -0.241 else -0.302
            val minRatio = min(serumCr / kappa, 1.0).pow(alpha)
            val maxRatio = max(serumCr / kappa, 1.0).pow(-1.200)
            val ageFactor = 0.9938.pow(age)
            val femaleFactor = if (isFemale) 1.012 else 1.0
            val valEgfr = 142.0 * minRatio * maxRatio * ageFactor * femaleFactor
            String.format(Locale.US, "%.1f", valEgfr.coerceAtLeast(1.0)).toDouble()
        } else 90.0
    }

    val ckdStage = remember(egfr) {
        when {
            egfr >= 90.0 -> "Stage 1 (Normal / High eGFR)"
            egfr >= 60.0 -> "Stage 2 (Mildly Decreased)"
            egfr >= 45.0 -> "Stage 3a (Mild-Moderate Decrease)"
            egfr >= 30.0 -> "Stage 3b (Moderate-Severe Decrease)"
            egfr >= 15.0 -> "Stage 4 (Severely Decreased)"
            else -> "Stage 5 (Kidney Failure / ESRD)"
        }
    }

    val filteredEntries = remember(searchQuery) {
        val q = searchQuery.trim().lowercase()
        if (q.isEmpty()) RenalDrugAdjustmentData.entries
        else RenalDrugAdjustmentData.entries.filter {
            it.drugName.lowercase().contains(q) ||
            it.keyWarning.lowercase().contains(q)
        }
    }

    Scaffold(
        topBar = {
            Surface(
                color = NavyDeep,
                border = BorderStroke(1.dp, NavyCardBorder)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                        }
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(
                                    text = "Renal Dose Auto-Calculator",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                                Surface(shape = RoundedCornerShape(4.dp), color = Amber500.copy(alpha = 0.2f)) {
                                    Text(
                                        text = "CrCl & eGFR",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Amber400,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Dynamic Cockcroft-Gault adjustment for narrow-therapeutic drugs",
                                fontSize = 11.sp,
                                color = Slate400
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 14.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Patient Renal Parameters Input Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Patient Kidney Parameters",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = ageText,
                            onValueChange = { ageText = it },
                            label = { Text("Age (yr)", fontSize = 10.sp) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = weightText,
                            onValueChange = { weightText = it },
                            label = { Text("Weight (kg)", fontSize = 10.sp) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = serumCrText,
                            onValueChange = { serumCrText = it },
                            label = { Text("Serum Cr (mg/dL)", fontSize = 10.sp) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1.3f)
                        )
                    }

                    // Sex Switcher
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Biological Sex:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Surface(
                                onClick = { isFemale = false },
                                shape = RoundedCornerShape(6.dp),
                                color = if (!isFemale) MedicalBlue500 else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.height(28.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 10.dp)) {
                                    Text("Male", fontSize = 11.sp, color = if (!isFemale) Color.White else MaterialTheme.colorScheme.onSurface)
                                }
                            }
                            Surface(
                                onClick = { isFemale = true },
                                shape = RoundedCornerShape(6.dp),
                                color = if (isFemale) Color(0xFFEC4899) else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.height(28.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 10.dp)) {
                                    Text("Female (x0.85)", fontSize = 11.sp, color = if (isFemale) Color.White else MaterialTheme.colorScheme.onSurface)
                                }
                            }
                        }
                    }

                    // Results Panel
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFF0F172A),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("Cockcroft-Gault CrCl:", fontSize = 10.sp, color = Slate400)
                                Text(
                                    text = "$crCl mL/min",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (crCl < 30.0) Color(0xFFEF4444) else if (crCl < 50.0) Amber400 else Emerald400
                                )
                            }
                            Column {
                                Text("CKD-EPI 2021 eGFR:", fontSize = 10.sp, color = Slate400)
                                Text(
                                    text = "$egfr mL/min/1.73m²",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(ckdStage, fontSize = 9.sp, color = Amber400)
                            }
                        }
                    }
                }
            }

            // Search Box for Drugs
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Filter renal drug (e.g. Enoxaparin, Meropenem, Metformin)...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Slate400) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("renal_search_input"),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )

            // Adjusted Drugs List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(filteredEntries.distinctBy { it.drugName }, key = { it.drugName }) { entry ->
                    RenalDrugCard(entry = entry, patientCrCl = crCl)
                }
            }
        }
    }
}

@Composable
private fun RenalDrugCard(
    entry: RenalAdjustmentEntry,
    patientCrCl: Double
) {
    var expanded by remember { mutableStateOf(false) }
    val (statusLabel, adjustedDose) = entry.getAdjustmentForCrCl(patientCrCl)

    val badgeColor = when {
        patientCrCl >= 50.0 -> Color(0xFF10B981)
        patientCrCl >= 30.0 -> Color(0xFFF59E0B)
        patientCrCl >= 15.0 -> Color(0xFFF97316)
        else -> Color(0xFFEF4444)
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, badgeColor.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = entry.drugName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (entry.isNarrowTherapeutic) {
                        Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFEF4444).copy(alpha = 0.15f)) {
                            Text(
                                text = "NARROW THERAPEUTIC",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFEF4444),
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                        }
                    }
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = badgeColor.copy(alpha = 0.15f),
                    border = BorderStroke(0.8.dp, badgeColor)
                ) {
                    Text(
                        text = statusLabel,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            // Calculated Adjusted Dose for this patient
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = badgeColor.copy(alpha = 0.1f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "Patient-Specific Adjusted Dose (CrCl $patientCrCl mL/min):",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor
                    )
                    Text(
                        text = adjustedDose,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))

                    Text("Standard Dose: ${entry.standardDose}", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("• CrCl >50 mL/min: ${entry.normalDose}", fontSize = 10.5.sp, color = Color(0xFF10B981))
                    Text("• CrCl 30-50 mL/min: ${entry.mildDose}", fontSize = 10.5.sp, color = Color(0xFFF59E0B))
                    Text("• CrCl 15-29 mL/min: ${entry.moderateDose}", fontSize = 10.5.sp, color = Color(0xFFF97316))
                    Text("• CrCl <15 / HD: ${entry.severeDose}", fontSize = 10.5.sp, color = Color(0xFFEF4444))

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "⚠️ Caution: ${entry.keyWarning}",
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 14.sp,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }
            }
        }
    }
}
