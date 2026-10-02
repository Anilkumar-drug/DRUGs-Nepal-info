package com.example.ui.screens.calculator

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.data.calculator.MedicalScoringEngine

// =============================================================================
// Reusable Helper Composables
// =============================================================================

@Composable
fun ScoringToggleRow(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    subtitle: String? = null
) {
    Surface(
        onClick = { onCheckedChange(!checked) },
        shape = RoundedCornerShape(10.dp),
        color = if (checked) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f),
        border = BorderStroke(1.dp, if (checked) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 13.sp,
                    fontWeight = if (checked) FontWeight.Bold else FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

// =============================================================================
// 1. ALCOHOL-ASSOCIATED HEPATITIS: LILLE MODEL & ABIC & GAHS
// =============================================================================

@Composable
fun LilleInteractiveCard() {
    var age by remember { mutableStateOf("48") }
    var albumin by remember { mutableStateOf("2.8") }
    var cr by remember { mutableStateOf("1.2") }
    var bili0 by remember { mutableStateOf("14.5") }
    var bili7 by remember { mutableStateOf("18.2") }
    var pt by remember { mutableStateOf("22") }

    val res = remember(age, albumin, cr, bili0, bili7, pt) {
        MedicalScoringEngine.calculateLille(
            age.toIntOrNull() ?: 48,
            albumin.toDoubleOrNull() ?: 2.8,
            cr.toDoubleOrNull() ?: 1.2,
            bili0.toDoubleOrNull() ?: 14.5,
            bili7.toDoubleOrNull() ?: 18.2,
            pt.toDoubleOrNull() ?: 22.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (yr)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = albumin,
                onValueChange = { albumin = it },
                label = { Text("Albumin (g/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = cr,
                onValueChange = { cr = it },
                label = { Text("Serum Cr (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = pt,
                onValueChange = { pt = it },
                label = { Text("Prothrombin Time (s)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = bili0,
                onValueChange = { bili0 = it },
                label = { Text("Day 0 Bilirubin (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = bili7,
                onValueChange = { bili7 = it },
                label = { Text("Day 7 Bilirubin (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "Lille Model Score (Day 7)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

@Composable
fun AbicInteractiveCard() {
    var age by remember { mutableStateOf("52") }
    var bili by remember { mutableStateOf("12.0") }
    var inr by remember { mutableStateOf("2.1") }
    var cr by remember { mutableStateOf("1.4") }

    val res = remember(age, bili, inr, cr) {
        MedicalScoringEngine.calculateAbic(
            age.toIntOrNull() ?: 52,
            bili.toDoubleOrNull() ?: 12.0,
            inr.toDoubleOrNull() ?: 2.1,
            cr.toDoubleOrNull() ?: 1.4
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Bilirubin (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("INR") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = cr, onValueChange = { cr = it }, label = { Text("Creatinine (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "ABIC Score",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

@Composable
fun GahsInteractiveCard() {
    var age by remember { mutableStateOf("54") }
    var wbc by remember { mutableStateOf("16.5") }
    var urea by remember { mutableStateOf("6.2") }
    var inr by remember { mutableStateOf("1.8") }
    var bili by remember { mutableStateOf("14.0") }

    val res = remember(age, wbc, urea, inr, bili) {
        MedicalScoringEngine.calculateGahs(
            age.toIntOrNull() ?: 54,
            wbc.toDoubleOrNull() ?: 16.5,
            urea.toDoubleOrNull() ?: 6.2,
            inr.toDoubleOrNull() ?: 1.8,
            bili.toDoubleOrNull() ?: 14.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = wbc, onValueChange = { wbc = it }, label = { Text("WBC (×10⁹/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = urea, onValueChange = { urea = it }, label = { Text("Urea (mmol/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("PT ratio / INR") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Total Bilirubin (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.fillMaxWidth())

        ResultBanner(
            title = "Glasgow Alcoholic Hepatitis Score (GAHS)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 2. WILSON DISEASE: LEIPZIG & DHAWAN
// =============================================================================

@Composable
fun LeipzigInteractiveCard() {
    var kfRings by remember { mutableStateOf(true) }
    var neuroSeverity by remember { mutableIntStateOf(1) } // 0, 1, 2
    var coombsNegHemolysis by remember { mutableStateOf(false) }
    var ceruloplasmin by remember { mutableIntStateOf(2) } // 0 = normal, 1 = 0.1-0.2, 2 = <0.1
    var urineCu by remember { mutableIntStateOf(2) } // 0 = normal, 1 = 1-2x, 2 = >2x
    var liverCu by remember { mutableIntStateOf(0) } // 0, 1, 2
    var atp7b by remember { mutableIntStateOf(1) } // 0, 1, 4

    val res = remember(kfRings, neuroSeverity, coombsNegHemolysis, ceruloplasmin, urineCu, liverCu, atp7b) {
        MedicalScoringEngine.calculateLeipzigScore(
            kfRings,
            neuroSeverity,
            coombsNegHemolysis,
            ceruloplasmin,
            urineCu,
            liverCu,
            atp7b
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ScoringToggleRow("Kayser-Fleischer (KF) Rings Present (+2 pts)", kfRings, { kfRings = it }, "Slit-lamp examination by ophthalmologist")
        ScoringToggleRow("Coombs-Negative Hemolytic Anemia (+1 pt)", coombsNegHemolysis, { coombsNegHemolysis = it })

        Text("Neurologic Symptoms:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = neuroSeverity == 0, onClick = { neuroSeverity = 0 }, label = { Text("None (0)") })
            FilterChip(selected = neuroSeverity == 1, onClick = { neuroSeverity = 1 }, label = { Text("Mild (+1)") })
            FilterChip(selected = neuroSeverity == 2, onClick = { neuroSeverity = 2 }, label = { Text("Severe (+2)") })
        }

        Text("Serum Ceruloplasmin Level:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ceruloplasmin == 0, onClick = { ceruloplasmin = 0 }, label = { Text(">0.2 g/L (0)") })
            FilterChip(selected = ceruloplasmin == 1, onClick = { ceruloplasmin = 1 }, label = { Text("0.1-0.2 (+1)") })
            FilterChip(selected = ceruloplasmin == 2, onClick = { ceruloplasmin = 2 }, label = { Text("<0.1 (+2)") })
        }

        Text("24h Urinary Copper Excretion:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = urineCu == 0, onClick = { urineCu = 0 }, label = { Text("Normal (0)") })
            FilterChip(selected = urineCu == 1, onClick = { urineCu = 1 }, label = { Text("1-2× ULN (+1)") })
            FilterChip(selected = urineCu == 2, onClick = { urineCu = 2 }, label = { Text(">2× ULN (+2)") })
        }

        Text("ATP7B Gene Mutation Analysis:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = atp7b == 0, onClick = { atp7b = 0 }, label = { Text("None (0)") })
            FilterChip(selected = atp7b == 1, onClick = { atp7b = 1 }, label = { Text("1 Allele (+1)") })
            FilterChip(selected = atp7b == 4, onClick = { atp7b = 4 }, label = { Text("Both Alleles (+4)") })
        }

        ResultBanner(
            title = "Leipzig Score for Wilson Disease",
            valueText = "${res.calculatedValue} Points",
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier != "Severe / High"
        )
    }
}

@Composable
fun DhawanInteractiveCard() {
    var bili by remember { mutableStateOf("15.0") }
    var ast by remember { mutableStateOf("220") }
    var wbc by remember { mutableStateOf("12.5") }
    var inr by remember { mutableStateOf("2.6") }
    var albumin by remember { mutableStateOf("2.8") }

    val res = remember(bili, ast, wbc, inr, albumin) {
        MedicalScoringEngine.calculateDhawan(
            bili.toDoubleOrNull() ?: 15.0,
            ast.toDoubleOrNull() ?: 220.0,
            wbc.toDoubleOrNull() ?: 12.5,
            inr.toDoubleOrNull() ?: 2.6,
            albumin.toDoubleOrNull() ?: 2.8
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Bilirubin (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = ast, onValueChange = { ast = it }, label = { Text("AST (U/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("INR") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = wbc, onValueChange = { wbc = it }, label = { Text("WBC (×10⁹/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        OutlinedTextField(value = albumin, onValueChange = { albumin = it }, label = { Text("Serum Albumin (g/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.fillMaxWidth())

        ResultBanner(
            title = "Dhawan Score (Revised King's Wilson)",
            valueText = "${res.calculatedValue} Points",
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier != "Severe / High"
        )
    }
}

// =============================================================================
// 3. HEMOCHROMATOSIS EVALUATION
// =============================================================================

@Composable
fun HemochromatosisInteractiveCard() {
    var tsat by remember { mutableStateOf("58") }
    var ferritin by remember { mutableStateOf("680") }
    var isFemale by remember { mutableStateOf(false) }
    var hfeMutation by remember { mutableStateOf("C282Y_HOMOZYGOTE") }

    val res = remember(tsat, ferritin, isFemale, hfeMutation) {
        MedicalScoringEngine.evaluateHemochromatosis(
            tsat.toDoubleOrNull() ?: 58.0,
            ferritin.toDoubleOrNull() ?: 680.0,
            isFemale,
            hfeMutation
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            FilterChip(selected = !isFemale, onClick = { isFemale = false }, label = { Text("Male (>50% TSAT)") })
            FilterChip(selected = isFemale, onClick = { isFemale = true }, label = { Text("Female (>45% TSAT)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = tsat, onValueChange = { tsat = it }, label = { Text("Transferrin Saturation (%)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = ferritin, onValueChange = { ferritin = it }, label = { Text("Serum Ferritin (ng/mL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }

        Text("HFE Genotype:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = hfeMutation == "C282Y_HOMOZYGOTE", onClick = { hfeMutation = "C282Y_HOMOZYGOTE" }, label = { Text("C282Y / C282Y") })
            FilterChip(selected = hfeMutation == "C282Y_H63D", onClick = { hfeMutation = "C282Y_H63D" }, label = { Text("C282Y / H63D") })
            FilterChip(selected = hfeMutation == "WILD_TYPE", onClick = { hfeMutation = "WILD_TYPE" }, label = { Text("Wild-Type / Other") })
        }

        ResultBanner(
            title = "Hemochromatosis Risk Stratification",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nManagement:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 4. CROHN'S DISEASE: HARVEY-BRADSHAW INDEX (HBI)
// =============================================================================

@Composable
fun HbiInteractiveCard() {
    var wellbeing by remember { mutableIntStateOf(1) }
    var pain by remember { mutableIntStateOf(1) }
    var liquidStools by remember { mutableStateOf("4") }
    var mass by remember { mutableIntStateOf(0) }
    var hasArthralgia by remember { mutableStateOf(false) }
    var hasUveitis by remember { mutableStateOf(false) }
    var hasErythema by remember { mutableStateOf(false) }
    var hasFistula by remember { mutableStateOf(false) }

    val complicationsCount = (if (hasArthralgia) 1 else 0) + (if (hasUveitis) 1 else 0) + (if (hasErythema) 1 else 0) + (if (hasFistula) 1 else 0)

    val res = remember(wellbeing, pain, liquidStools, mass, complicationsCount) {
        MedicalScoringEngine.calculateHbi(
            wellbeing,
            pain,
            liquidStools.toIntOrNull() ?: 4,
            mass,
            complicationsCount
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("General Well-being (Previous day):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "Very Well", 1 to "Slightly Below", 2 to "Poor", 3 to "Very Poor").forEach { (v, l) ->
                FilterChip(selected = wellbeing == v, onClick = { wellbeing = v }, label = { Text("$l ($v)", fontSize = 11.sp) })
            }
        }

        Text("Abdominal Pain:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "None", 1 to "Mild", 2 to "Moderate", 3 to "Severe").forEach { (v, l) ->
                FilterChip(selected = pain == v, onClick = { pain = v }, label = { Text("$l ($v)", fontSize = 11.sp) })
            }
        }

        OutlinedTextField(
            value = liquidStools,
            onValueChange = { liquidStools = it },
            label = { Text("Number of Liquid/Soft Stools Today (+1 per stool)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Abdominal Mass:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "None (0)", 1 to "Dubious (1)", 2 to "Definite (2)", 3 to "Tender (3)").forEach { (v, l) ->
                FilterChip(selected = mass == v, onClick = { mass = v }, label = { Text(l, fontSize = 11.sp) })
            }
        }

        Text("Complications (+1 pt each):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("Arthralgia / Arthritis", hasArthralgia, { hasArthralgia = it })
        ScoringToggleRow("Uveitis / Iritis", hasUveitis, { hasUveitis = it })
        ScoringToggleRow("Erythema Nodosum / Pyoderma Gangrenosum", hasErythema, { hasErythema = it })
        ScoringToggleRow("Anal Fissure / Fistula / Perianal Abscess", hasFistula, { hasFistula = it })

        ResultBanner(
            title = "Harvey-Bradshaw Index (HBI)",
            valueText = "${res.calculatedValue} Points",
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nNext Steps:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 5. ULCERATIVE COLITIS: PARTIAL MAYO SCORE
// =============================================================================

@Composable
fun PartialMayoInteractiveCard() {
    var stoolFreq by remember { mutableIntStateOf(1) }
    var bleeding by remember { mutableIntStateOf(1) }
    var pga by remember { mutableIntStateOf(1) }

    val res = remember(stoolFreq, bleeding, pga) {
        MedicalScoringEngine.calculatePartialMayo(stoolFreq, bleeding, pga)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Stool Frequency (above baseline):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "Normal (0)", 1 to "1-2 > N (1)", 2 to "3-4 > N (2)", 3 to ">=5 > N (3)").forEach { (v, l) ->
                FilterChip(selected = stoolFreq == v, onClick = { stoolFreq = v }, label = { Text(l, fontSize = 11.sp) })
            }
        }

        Text("Rectal Bleeding:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "None (0)", 1 to "Streaks (1)", 2 to "Obvious (2)", 3 to "Mostly (3)").forEach { (v, l) ->
                FilterChip(selected = bleeding == v, onClick = { bleeding = v }, label = { Text(l, fontSize = 11.sp) })
            }
        }

        Text("Physician's Global Assessment (PGA):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "Normal (0)", 1 to "Mild (1)", 2 to "Moderate (2)", 3 to "Severe (3)").forEach { (v, l) ->
                FilterChip(selected = pga == v, onClick = { pga = v }, label = { Text(l, fontSize = 11.sp) })
            }
        }

        ResultBanner(
            title = "Partial Mayo Score (UC Activity)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nAction Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 6. MASLD / MASH: NAFLD FIBROSIS SCORE (NFS)
// =============================================================================

@Composable
fun NfsMashInteractiveCard() {
    var age by remember { mutableStateOf("56") }
    var bmi by remember { mutableStateOf("31.2") }
    var hasDiabetes by remember { mutableStateOf(true) }
    var ast by remember { mutableStateOf("48") }
    var alt by remember { mutableStateOf("52") }
    var platelets by remember { mutableStateOf("185") }
    var albumin by remember { mutableStateOf("4.1") }

    val res = remember(age, bmi, hasDiabetes, ast, alt, platelets, albumin) {
        MedicalScoringEngine.calculateNafldFibrosisScore(
            age.toIntOrNull() ?: 56,
            bmi.toDoubleOrNull() ?: 31.2,
            hasDiabetes,
            ast.toDoubleOrNull() ?: 48.0,
            alt.toDoubleOrNull() ?: 52.0,
            platelets.toDoubleOrNull() ?: 185.0,
            albumin.toDoubleOrNull() ?: 4.1
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = bmi, onValueChange = { bmi = it }, label = { Text("BMI (kg/m²)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        ScoringToggleRow("Impaired Fasting Glucose or Diabetes Mellitus", hasDiabetes, { hasDiabetes = it })

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = ast, onValueChange = { ast = it }, label = { Text("AST (U/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = alt, onValueChange = { alt = it }, label = { Text("ALT (U/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = platelets, onValueChange = { platelets = it }, label = { Text("Platelets (×10⁹/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = albumin, onValueChange = { albumin = it }, label = { Text("Albumin (g/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }

        ResultBanner(
            title = "NAFLD Fibrosis Score (NFS)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 7. ACLF & ALF: NACSELD-ACLF & KING'S COLLEGE
// =============================================================================

@Composable
fun NacseldAclfInteractiveCard() {
    var shock by remember { mutableStateOf(false) }
    var he34 by remember { mutableStateOf(false) }
    var rrt by remember { mutableStateOf(false) }
    var vent by remember { mutableStateOf(false) }

    val res = remember(shock, he34, rrt, vent) {
        MedicalScoringEngine.evaluateNacseldAclf(shock, he34, rrt, vent)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Evaluate Presence of Organ Failures:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("Shock (Requiring vasopressors/inotropes)", shock, { shock = it })
        ScoringToggleRow("Hepatic Encephalopathy Grade III or IV", he34, { he34 = it }, "Somnolence, stupor, or coma")
        ScoringToggleRow("Renal Replacement Therapy (Dialysis/CRRT)", rrt, { rrt = it })
        ScoringToggleRow("Mechanical Ventilation", vent, { vent = it })

        ResultBanner(
            title = "NACSELD-ACLF Criteria",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nTransplant Triage:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

@Composable
fun KingsCollegeInteractiveCard() {
    var isParacetamol by remember { mutableStateOf(true) }
    var ph by remember { mutableStateOf("7.28") }
    var inr by remember { mutableStateOf("6.8") }
    var cr by remember { mutableStateOf("3.8") }
    var heGrade by remember { mutableIntStateOf(3) }
    var age by remember { mutableStateOf("28") }
    var jaundiceDays by remember { mutableStateOf("8") }
    var bili by remember { mutableStateOf("18.5") }

    val res = remember(isParacetamol, ph, inr, cr, heGrade, age, jaundiceDays, bili) {
        MedicalScoringEngine.evaluateKingsCollege(
            isParacetamol,
            ph.toDoubleOrNull() ?: 7.28,
            inr.toDoubleOrNull() ?: 6.8,
            cr.toDoubleOrNull() ?: 3.8,
            heGrade,
            age.toIntOrNull() ?: 28,
            jaundiceDays.toIntOrNull() ?: 8,
            bili.toDoubleOrNull() ?: 18.5
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = isParacetamol, onClick = { isParacetamol = true }, label = { Text("Paracetamol Induced") })
            FilterChip(selected = !isParacetamol, onClick = { isParacetamol = false }, label = { Text("Non-Paracetamol (Viral/DILI)") })
        }

        if (isParacetamol) {
            OutlinedTextField(value = ph, onValueChange = { ph = it }, label = { Text("Arterial pH (after fluid resuscitation)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.fillMaxWidth())
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("INR (PT >100s if >6.5)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = cr, onValueChange = { cr = it }, label = { Text("Creatinine (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }

        Text("Hepatic Encephalopathy Grade:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf(1 to "Grade I", 2 to "Grade II", 3 to "Grade III", 4 to "Grade IV (Coma)").forEach { (g, l) ->
                FilterChip(selected = heGrade == g, onClick = { heGrade = g }, label = { Text(l) })
            }
        }

        if (!isParacetamol) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (<10 or >40)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
                OutlinedTextField(value = jaundiceDays, onValueChange = { jaundiceDays = it }, label = { Text("Jaundice to Coma (days)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            }
            OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Total Bilirubin (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.fillMaxWidth())
        }

        ResultBanner(
            title = "King's College Criteria for Emergency Transplant",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Urgency:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier != "Severe / High"
        )
    }
}

// =============================================================================
// 8. PANCREATITIS & CHOLANGITIS: ATLANTA & TOKYO TG18
// =============================================================================

@Composable
fun ModifiedAtlantaInteractiveCard() {
    var transientFail by remember { mutableStateOf(false) }
    var persistentFail by remember { mutableStateOf(false) }
    var localComp by remember { mutableStateOf(false) }

    val res = remember(transientFail, persistentFail, localComp) {
        MedicalScoringEngine.evaluateModifiedAtlanta(transientFail, persistentFail, localComp)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ScoringToggleRow("Persistent Organ Failure (> 48 hours)", persistentFail, { persistentFail = it }, "Marshall score >=2 for respiratory, renal, or cardiovascular failure")
        ScoringToggleRow("Transient Organ Failure (< 48 hours)", transientFail, { transientFail = it }, "Resolves within 48 hours with fluid resuscitation")
        ScoringToggleRow("Local or Systemic Complications", localComp, { localComp = it }, "Acute peripancreatic fluid collection, necrotic collection, or pseudocyst")

        ResultBanner(
            title = "Modified Atlanta Classification",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nManagement Strategy:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

@Composable
fun TokyoTg18InteractiveCard() {
    var inflammation by remember { mutableStateOf(true) }
    var cholestasis by remember { mutableStateOf(true) }
    var imaging by remember { mutableStateOf(true) }
    var organDysfunction by remember { mutableStateOf(false) }
    var moderateCriteria by remember { mutableStateOf(false) }

    val res = remember(inflammation, cholestasis, imaging, organDysfunction, moderateCriteria) {
        MedicalScoringEngine.evaluateTokyoTg18(inflammation, cholestasis, imaging, organDysfunction, moderateCriteria)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Diagnostic Criteria (TG18):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("A. Systemic Inflammation", inflammation, { inflammation = it }, "Fever/chills, WBC <4k or >10k, CRP >=1 mg/dL")
        ScoringToggleRow("B. Cholestasis", cholestasis, { cholestasis = it }, "Jaundice (Total Bilirubin >=2 mg/dL) or abnormal ALP/GGT/AST/ALT")
        ScoringToggleRow("C. Imaging Evidence", imaging, { imaging = it }, "Biliary dilatation, gallstone, stricture, stent")

        Text("Severity Assessment (Grade II vs III):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("Grade III (Severe): Organ Dysfunction Present", organDysfunction, { organDysfunction = it }, "Hypotension (dopamine/norepi), GCS decrease, PaO2/FiO2 <300, Cr >2.0, INR >1.5, Plt <100k")
        ScoringToggleRow("Grade II (Moderate Criteria)", moderateCriteria, { moderateCriteria = it }, "WBC >12k or <4k, Temp >=39°C, Age >=75, Bilirubin >=5 mg/dL")

        ResultBanner(
            title = "Tokyo Guidelines 2018 (TG18)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nIntervention:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 9. UPPER GI BLEEDING: GLASGOW-BLATCHFORD (GBS) & AIMS65
// =============================================================================

@Composable
fun GlasgowBlatchfordInteractiveCard() {
    var bun by remember { mutableStateOf("24.0") }
    var hb by remember { mutableStateOf("9.8") }
    var isFemale by remember { mutableStateOf(false) }
    var sbp by remember { mutableStateOf("95") }
    var pulse by remember { mutableStateOf("108") }
    var hasMelena by remember { mutableStateOf(true) }
    var hasSyncope by remember { mutableStateOf(false) }
    var hasLiverDisease by remember { mutableStateOf(false) }
    var hasHeartFailure by remember { mutableStateOf(false) }

    val res = remember(bun, hb, isFemale, sbp, pulse, hasMelena, hasSyncope, hasLiverDisease, hasHeartFailure) {
        MedicalScoringEngine.calculateGlasgowBlatchford(
            bun.toDoubleOrNull() ?: 24.0,
            hb.toDoubleOrNull() ?: 9.8,
            isFemale,
            sbp.toIntOrNull() ?: 95,
            pulse.toIntOrNull() ?: 108,
            hasMelena,
            hasSyncope,
            hasLiverDisease,
            hasHeartFailure
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = !isFemale, onClick = { isFemale = false }, label = { Text("Male") })
            FilterChip(selected = isFemale, onClick = { isFemale = true }, label = { Text("Female") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = bun, onValueChange = { bun = it }, label = { Text("BUN (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = hb, onValueChange = { hb = it }, label = { Text("Hemoglobin (g/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = sbp, onValueChange = { sbp = it }, label = { Text("Systolic BP (mmHg)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = pulse, onValueChange = { pulse = it }, label = { Text("Pulse (bpm)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
        }

        ScoringToggleRow("Presentation with Melena (+1 pt)", hasMelena, { hasMelena = it })
        ScoringToggleRow("Syncope at presentation (+2 pts)", hasSyncope, { hasSyncope = it })
        ScoringToggleRow("Known Hepatic Disease (+2 pts)", hasLiverDisease, { hasLiverDisease = it }, "History or clinical signs of cirrhosis")
        ScoringToggleRow("Heart Failure (+2 pts)", hasHeartFailure, { hasHeartFailure = it })

        ResultBanner(
            title = "Glasgow-Blatchford Score (GBS)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

@Composable
fun Aims65InteractiveCard() {
    var alb by remember { mutableStateOf("2.6") }
    var inr by remember { mutableStateOf("1.8") }
    var gcsLess15 by remember { mutableStateOf(false) }
    var sbp by remember { mutableStateOf("88") }
    var age by remember { mutableStateOf("70") }

    val res = remember(alb, inr, gcsLess15, sbp, age) {
        MedicalScoringEngine.calculateAims65(
            alb.toDoubleOrNull() ?: 2.6,
            inr.toDoubleOrNull() ?: 1.8,
            gcsLess15,
            sbp.toIntOrNull() ?: 88,
            age.toIntOrNull() ?: 70
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = alb, onValueChange = { alb = it }, label = { Text("Albumin (g/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("INR") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = sbp, onValueChange = { sbp = it }, label = { Text("Systolic BP (mmHg)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
        }
        ScoringToggleRow("Altered Mental Status (GCS < 15)", gcsLess15, { gcsLess15 = it })

        ResultBanner(
            title = "AIMS65 Score (Upper GI Bleed)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low"
        )
    }
}

// =============================================================================
// 10. CRITICAL CARE: qSOFA
// =============================================================================

@Composable
fun QsofaInteractiveCard() {
    var rr22 by remember { mutableStateOf(true) }
    var alteredMentation by remember { mutableStateOf(false) }
    var sbp100 by remember { mutableStateOf(true) }

    val res = remember(rr22, alteredMentation, sbp100) {
        MedicalScoringEngine.calculateQsofa(rr22, alteredMentation, sbp100)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ScoringToggleRow("Respiratory Rate >= 22 breaths/min (+1 pt)", rr22, { rr22 = it })
        ScoringToggleRow("Altered Mental Status / GCS < 15 (+1 pt)", alteredMentation, { alteredMentation = it })
        ScoringToggleRow("Systolic Blood Pressure <= 100 mmHg (+1 pt)", sbp100, { sbp100 = it })

        ResultBanner(
            title = "qSOFA Sepsis Screening Score",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nImmediate Sepsis Bundle:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 11. HEPATOLOGY: MELD 3.0
// =============================================================================

@Composable
fun Meld3InteractiveCard() {
    var isFemale by remember { mutableStateOf(false) }
    var bilirubin by remember { mutableStateOf("2.5") }
    var inr by remember { mutableStateOf("1.8") }
    var creatinine by remember { mutableStateOf("1.4") }
    var sodium by remember { mutableStateOf("132") }
    var albumin by remember { mutableStateOf("2.9") }

    val res = remember(isFemale, bilirubin, inr, creatinine, sodium, albumin) {
        MedicalScoringEngine.calculateMeld30(
            isFemale = isFemale,
            bilirubinMgDl = bilirubin.toDoubleOrNull() ?: 2.5,
            inr = inr.toDoubleOrNull() ?: 1.8,
            creatinineMgDl = creatinine.toDoubleOrNull() ?: 1.4,
            sodiumMeqL = sodium.toDoubleOrNull() ?: 132.0,
            albuminGdL = albumin.toDoubleOrNull() ?: 2.9
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Biological Sex", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(
                    selected = !isFemale,
                    onClick = { isFemale = false },
                    label = { Text("Male") }
                )
                FilterChip(
                    selected = isFemale,
                    onClick = { isFemale = true },
                    label = { Text("Female (+1.33 risk)") }
                )
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = bilirubin,
                onValueChange = { bilirubin = it },
                label = { Text("Bilirubin (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = inr,
                onValueChange = { inr = it },
                label = { Text("INR") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = creatinine,
                onValueChange = { creatinine = it },
                label = { Text("Creatinine (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = sodium,
                onValueChange = { sodium = it },
                label = { Text("Serum Na (mEq/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }
        OutlinedTextField(
            value = albumin,
            onValueChange = { albumin = it },
            label = { Text("Serum Albumin (g/dL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        ResultBanner(
            title = "MELD 3.0 Score (UNOS Organ Allocation)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 12. GASTROENTEROLOGY: CDAI & SES-CD & UCEIS
// =============================================================================

@Composable
fun CdaiInteractiveCard() {
    var stoolCount by remember { mutableStateOf("14") }
    var painScore by remember { mutableStateOf("7") }
    var wellbeingScore by remember { mutableStateOf("8") }
    var complicationsCount by remember { mutableStateOf("1") }
    var hct by remember { mutableStateOf("34") }
    var isFemale by remember { mutableStateOf(false) }

    val res = remember(stoolCount, painScore, wellbeingScore, complicationsCount, hct, isFemale) {
        MedicalScoringEngine.calculateCdai(
            liquidStoolsSum7Days = stoolCount.toIntOrNull() ?: 14,
            abdominalPainSum7Days = painScore.toIntOrNull() ?: 7,
            generalWellbeingSum7Days = wellbeingScore.toIntOrNull() ?: 8,
            extraintestinalSymptomsCount = complicationsCount.toIntOrNull() ?: 1,
            takingOpiatesForDiarrhea = false,
            abdominalMassScore = 0,
            actualHematocrit = hct.toDoubleOrNull() ?: 34.0,
            isFemale = isFemale,
            weightKg = 65.0,
            standardWeightKg = 70.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = stoolCount,
            onValueChange = { stoolCount = it },
            label = { Text("Sum of Very Soft/Liquid Stools (7 Days)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = painScore,
                onValueChange = { painScore = it },
                label = { Text("Pain Score (0-21, 7d)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = wellbeingScore,
                onValueChange = { wellbeingScore = it },
                label = { Text("Wellbeing (0-28, 7d)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = complicationsCount,
                onValueChange = { complicationsCount = it },
                label = { Text("Complications Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = hct,
                onValueChange = { hct = it },
                label = { Text("Hematocrit (%)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "Crohn's Disease Activity Index (CDAI)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nEvidence-based Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun SesCdInteractiveCard() {
    var ulcerSize by remember { mutableStateOf(2) }
    var ulceratedSurface by remember { mutableStateOf(2) }
    var affectedSurface by remember { mutableStateOf(3) }
    var stenosis by remember { mutableStateOf(1) }

    val res = remember(ulcerSize, ulceratedSurface, affectedSurface, stenosis) {
        MedicalScoringEngine.calculateSesCd(ulcerSize, ulceratedSurface, affectedSurface, stenosis)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Endoscopic Parameters (5 Segments)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        OutlinedTextField(
            value = ulcerSize.toString(),
            onValueChange = { ulcerSize = it.toIntOrNull() ?: 0 },
            label = { Text("Ulcer Size Points (0-15)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = ulceratedSurface.toString(),
            onValueChange = { ulceratedSurface = it.toIntOrNull() ?: 0 },
            label = { Text("Ulcerated Surface Points (0-15)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = affectedSurface.toString(),
            onValueChange = { affectedSurface = it.toIntOrNull() ?: 0 },
            label = { Text("Affected Surface Points (0-15)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = stenosis.toString(),
            onValueChange = { stenosis = it.toIntOrNull() ?: 0 },
            label = { Text("Stenosis / Stricture Points (0-15)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        ResultBanner(
            title = "SES-CD Endoscopic Score",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nActionable Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun UceisInteractiveCard() {
    var vascularPattern by remember { mutableStateOf(1) }
    var bleeding by remember { mutableStateOf(2) }
    var erosions by remember { mutableStateOf(2) }

    val res = remember(vascularPattern, bleeding, erosions) {
        MedicalScoringEngine.calculateUceis(vascularPattern, bleeding, erosions)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Endoscopic Findings in Ulcerative Colitis", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Text("Vascular Pattern: ${if (vascularPattern == 0) "Normal" else if (vascularPattern == 1) "Patchy loss" else "Complete loss"}", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            (0..2).forEach { level ->
                FilterChip(
                    selected = vascularPattern == level,
                    onClick = { vascularPattern = level },
                    label = { Text("Vasc $level") }
                )
            }
        }

        Text("Mucosal Bleeding: ${if (bleeding == 0) "None" else if (bleeding == 1) "Mucosal" else if (bleeding == 2) "Luminal fluid" else "Clots"}", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            (0..3).forEach { level ->
                FilterChip(
                    selected = bleeding == level,
                    onClick = { bleeding = level },
                    label = { Text("Bleed $level") }
                )
            }
        }

        Text("Erosions & Ulcers: ${if (erosions == 0) "None" else if (erosions == 1) "Erosions" else if (erosions == 2) "Superficial" else "Deep"}", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            (0..3).forEach { level ->
                FilterChip(
                    selected = erosions == level,
                    onClick = { erosions = level },
                    label = { Text("Ulcer $level") }
                )
            }
        }

        ResultBanner(
            title = "UCEIS Endoscopic Severity Index",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Guidance:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 13. MASLD / MASH: NAS & FAST
// =============================================================================

@Composable
fun NasScoreInteractiveCard() {
    var steatosis by remember { mutableStateOf(2) }
    var inflammation by remember { mutableStateOf(2) }
    var ballooning by remember { mutableStateOf(1) }

    val res = remember(steatosis, inflammation, ballooning) {
        MedicalScoringEngine.calculateNasScore(steatosis, inflammation, ballooning)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Histological Activity Scoring", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Text("Steatosis: ${if (steatosis == 0) "<5%" else if (steatosis == 1) "5-33%" else if (steatosis == 2) "34-66%" else ">66%"}", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..3).forEach { lvl ->
                FilterChip(selected = steatosis == lvl, onClick = { steatosis = lvl }, label = { Text("Grade $lvl") })
            }
        }

        Text("Lobular Inflammation: ${if (inflammation == 0) "None" else if (inflammation == 1) "<2 foci" else if (inflammation == 2) "2-4 foci" else ">4 foci"}", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..3).forEach { lvl ->
                FilterChip(selected = inflammation == lvl, onClick = { inflammation = lvl }, label = { Text("Inflam $lvl") })
            }
        }

        Text("Hepatocyte Ballooning: ${if (ballooning == 0) "None" else if (ballooning == 1) "Few" else "Prominent/Many"}", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..2).forEach { lvl ->
                FilterChip(selected = ballooning == lvl, onClick = { ballooning = lvl }, label = { Text("Balloon $lvl") })
            }
        }

        ResultBanner(
            title = "NAS (NAFLD Activity Score)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun FastScoreInteractiveCard() {
    var lsm by remember { mutableStateOf("11.5") }
    var cap by remember { mutableStateOf("315") }
    var ast by remember { mutableStateOf("54") }

    val res = remember(lsm, cap, ast) {
        MedicalScoringEngine.calculateFastScore(
            lsm.toDoubleOrNull() ?: 11.5,
            cap.toDoubleOrNull() ?: 315.0,
            ast.toDoubleOrNull() ?: 54.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = lsm,
            onValueChange = { lsm = it },
            label = { Text("FibroScan LSM (kPa)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = cap,
                onValueChange = { cap = it },
                label = { Text("FibroScan CAP (dB/m)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = ast,
                onValueChange = { ast = it },
                label = { Text("Serum AST (U/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "FAST Score (FibroScan-AST for at-risk MASH)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Next Step:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 14. ACLF & ALF: CLIF-SOFA & CLICHY
// =============================================================================

@Composable
fun ClifSofaInteractiveCard() {
    var organFailures by remember { mutableStateOf("2") }
    var age by remember { mutableStateOf("52") }
    var wbc by remember { mutableStateOf("14.5") }

    val res = remember(organFailures, age, wbc) {
        MedicalScoringEngine.calculateClifCAclf(
            organFailures.toIntOrNull() ?: 2,
            age.toIntOrNull() ?: 52,
            wbc.toDoubleOrNull() ?: 14.5
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = organFailures,
            onValueChange = { organFailures = it },
            label = { Text("CLIF-SOFA Organ Failures Count (0-6)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Patient Age (yr)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = wbc,
                onValueChange = { wbc = it },
                label = { Text("WBC Count (x10^9/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "CLIF-C ACLF Score",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Management:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun AlfsgClichyInteractiveCard() {
    var factorV by remember { mutableStateOf("18.0") }
    var age by remember { mutableStateOf("26") }
    var comaGrade by remember { mutableStateOf("3") }

    val res = remember(factorV, age, comaGrade) {
        MedicalScoringEngine.evaluateAlfsgClichy(
            factorV.toDoubleOrNull() ?: 18.0,
            age.toIntOrNull() ?: 26,
            comaGrade.toIntOrNull() ?: 3
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = factorV,
            onValueChange = { factorV = it },
            label = { Text("Factor V Level (%)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (years)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = comaGrade,
                onValueChange = { comaGrade = it },
                label = { Text("Encephalopathy Grade (1-4)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "Clichy Criteria for Acute Liver Failure",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nActionable Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 15. PANCREATITIS & GI BLEED: APACHE II, CTSI & FORREST
// =============================================================================

@Composable
fun ApacheIIInteractiveCard() {
    var acutePts by remember { mutableStateOf("12") }
    var agePts by remember { mutableStateOf("3") }
    var chronicPts by remember { mutableStateOf("2") }

    val res = remember(acutePts, agePts, chronicPts) {
        MedicalScoringEngine.calculateApacheII(
            acutePts.toIntOrNull() ?: 12,
            agePts.toIntOrNull() ?: 3,
            chronicPts.toIntOrNull() ?: 2
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = acutePts,
            onValueChange = { acutePts = it },
            label = { Text("Acute Physiology Points (0-44)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = agePts,
                onValueChange = { agePts = it },
                label = { Text("Age Points (0-6)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = chronicPts,
                onValueChange = { chronicPts = it },
                label = { Text("Chronic Health Points (0-5)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "APACHE II ICU Severity Score",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nRecommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun CtsiInteractiveCard() {
    var balthazarGrade by remember { mutableStateOf(3) } // D
    var necrosisGrade by remember { mutableStateOf(4) } // 30-50%

    val res = remember(balthazarGrade, necrosisGrade) {
        MedicalScoringEngine.calculateCtsiBalthazar(balthazarGrade, necrosisGrade)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Balthazar CT Grade:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("A (0)" to 0, "B (1)" to 1, "C (2)" to 2, "D (3)" to 3, "E (4)" to 4).forEach { (lbl, pts) ->
                FilterChip(selected = balthazarGrade == pts, onClick = { balthazarGrade = pts }, label = { Text(lbl) })
            }
        }

        Text("Pancreatic Necrosis:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("None (0)" to 0, "<30% (2)" to 2, "30-50% (4)" to 4, ">50% (6)" to 6).forEach { (lbl, pts) ->
                FilterChip(selected = necrosisGrade == pts, onClick = { necrosisGrade = pts }, label = { Text(lbl) })
            }
        }

        ResultBanner(
            title = "CTSI Balthazar CT Severity Index",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nIntervention Guideline:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun ForrestInteractiveCard() {
    var selectedGrade by remember { mutableStateOf("IIa") }

    val res = remember(selectedGrade) {
        MedicalScoringEngine.evaluateForrest(selectedGrade)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Endoscopic Bleeding Stigmata:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("Ia", "Ib", "IIa", "IIb", "IIc", "III").forEach { grade ->
                FilterChip(selected = selectedGrade == grade, onClick = { selectedGrade = grade }, label = { Text(grade) })
            }
        }

        ResultBanner(
            title = "Forrest Classification",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nEndoscopic Management:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 16. CARDIOLOGY, PULMONOLOGY & NEPHROLOGY: TIMI, GRACE, PSI, PERC, KDIGO
// =============================================================================

@Composable
fun TimiInteractiveCard() {
    var criteriaCount by remember { mutableStateOf(4) }

    val res = remember(criteriaCount) {
        MedicalScoringEngine.calculateTimiScore(criteriaCount)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Select number of TIMI criteria met (0-7):", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Text("• Age >= 65\n• >=3 CAD Risk Factors\n• Known CAD (Stenosis >= 50%)\n• Aspirin use in last 7 days\n• Severe angina (>=2 episodes in 24h)\n• ST-segment deviation >= 0.5 mm\n• Positive cardiac biomarkers", fontSize = 11.sp, lineHeight = 16.sp)

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..7).forEach { num ->
                FilterChip(selected = criteriaCount == num, onClick = { criteriaCount = num }, label = { Text("$num") })
            }
        }

        ResultBanner(
            title = "TIMI Risk Score (UA / NSTEMI)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Pathway:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun GraceInteractiveCard() {
    var scoreValue by remember { mutableStateOf("148") }

    val res = remember(scoreValue) {
        MedicalScoringEngine.calculateGraceScore(scoreValue.toIntOrNull() ?: 148)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = scoreValue,
            onValueChange = { scoreValue = it },
            label = { Text("Calculated GRACE Score Points") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        ResultBanner(
            title = "GRACE Acute Coronary Syndrome Risk",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nCoronary Strategy:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun PsiPortInteractiveCard() {
    var points by remember { mutableStateOf("95") }

    val res = remember(points) {
        MedicalScoringEngine.calculatePsiPort(points.toIntOrNull() ?: 95)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = points,
            onValueChange = { points = it },
            label = { Text("Total PSI / PORT Points") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        ResultBanner(
            title = "PSI / PORT Pneumonia Severity Index",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nDisposition Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun PercRuleInteractiveCard() {
    var criteriaMet by remember { mutableStateOf(0) }

    val res = remember(criteriaMet) {
        MedicalScoringEngine.evaluatePercRule(criteriaMet)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("PERC Rule Criteria (Check if any are present):", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Text("1. Age >= 50\n2. HR >= 100 bpm\n3. SpO2 < 95% on room air\n4. Unilateral leg swelling\n5. Hemoptysis\n6. Recent surgery or trauma in 4 weeks\n7. Prior PE or DVT\n8. Hormone / Estrogen use", fontSize = 11.5.sp, lineHeight = 16.sp)

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("0 (Rule Out)" to 0, "1" to 1, "2+" to 2).forEach { (lbl, count) ->
                FilterChip(selected = criteriaMet == count, onClick = { criteriaMet = count }, label = { Text(lbl) })
            }
        }

        ResultBanner(
            title = "PERC Rule for Pulmonary Embolism",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nDiagnostic Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

@Composable
fun KdigoAkiInteractiveCard() {
    var baselineCr by remember { mutableStateOf("1.0") }
    var currentCr by remember { mutableStateOf("2.3") }
    var urineOutput by remember { mutableStateOf("0.4") }
    var urineHours by remember { mutableStateOf("12") }

    val res = remember(baselineCr, currentCr, urineOutput, urineHours) {
        MedicalScoringEngine.evaluateKdigoAki(
            baselineCr.toDoubleOrNull() ?: 1.0,
            currentCr.toDoubleOrNull() ?: 2.3,
            urineOutput.toDoubleOrNull() ?: 0.4,
            urineHours.toDoubleOrNull() ?: 12.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = baselineCr,
                onValueChange = { baselineCr = it },
                label = { Text("Baseline Cr (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = currentCr,
                onValueChange = { currentCr = it },
                label = { Text("Current Cr (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = urineOutput,
                onValueChange = { urineOutput = it },
                label = { Text("Urine Output (mL/kg/h)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = urineHours,
                onValueChange = { urineHours = it },
                label = { Text("Oliguria Hours") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "KDIGO Acute Kidney Injury Staging",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}
