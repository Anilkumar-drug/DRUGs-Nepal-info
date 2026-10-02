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

// =============================================================================
// 28. MILAN CRITERIA INTERACTIVE CARD
// =========================================================================

@Composable
fun MilanCriteriaInteractiveCard() {
    var isMultipleTumors by remember { mutableStateOf(false) }
    var singleTumorSize by remember { mutableStateOf("3.2") }
    var tumorCount by remember { mutableStateOf("2") }
    var maxTumorSize by remember { mutableStateOf("2.5") }
    var macrovascularInvasion by remember { mutableStateOf(false) }
    var extrahepaticMetastasis by remember { mutableStateOf(false) }

    val res = remember(isMultipleTumors, singleTumorSize, tumorCount, maxTumorSize, macrovascularInvasion, extrahepaticMetastasis) {
        MedicalScoringEngine.evaluateMilanCriteria(
            singleTumorSizeCm = singleTumorSize.toDoubleOrNull() ?: 3.2,
            tumorCount = if (isMultipleTumors) (tumorCount.toIntOrNull() ?: 2) else 1,
            maxTumorSizeCm = if (isMultipleTumors) (maxTumorSize.toDoubleOrNull() ?: 2.5) else (singleTumorSize.toDoubleOrNull() ?: 3.2),
            macrovascularInvasion = macrovascularInvasion,
            extrahepaticMetastasis = extrahepaticMetastasis
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Tumor Presentation", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = !isMultipleTumors,
                onClick = { isMultipleTumors = false },
                label = { Text("Single Nodule (<= 5 cm)") }
            )
            FilterChip(
                selected = isMultipleTumors,
                onClick = { isMultipleTumors = true },
                label = { Text("Multiple (2-3 Nodules <= 3 cm)") }
            )
        }

        if (!isMultipleTumors) {
            OutlinedTextField(
                value = singleTumorSize,
                onValueChange = { singleTumorSize = it },
                label = { Text("Single Tumor Maximum Diameter (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedTextField(
                    value = tumorCount,
                    onValueChange = { tumorCount = it },
                    label = { Text("Number of Nodules") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = maxTumorSize,
                    onValueChange = { maxTumorSize = it },
                    label = { Text("Largest Diameter (cm)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Text("Vascular & Metastatic Criteria", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        ScoringToggleRow(
            title = "Macrovascular Invasion Present",
            checked = macrovascularInvasion,
            onCheckedChange = { macrovascularInvasion = it },
            subtitle = "Tumor thrombus in portal vein or hepatic veins"
        )
        ScoringToggleRow(
            title = "Extrahepatic Metastasis Present",
            checked = extrahepaticMetastasis,
            onCheckedChange = { extrahepaticMetastasis = it },
            subtitle = "Lymph node involvement, lung, bone, or peritoneal spread"
        )

        ResultBanner(
            title = "Milan Criteria for Liver Transplantation",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.calculatedValue == "Within Milan Criteria",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 29. ROME III FOR IBS INTERACTIVE CARD
// =========================================================================

@Composable
fun RomeIIIInteractiveCard() {
    var recurrentPain by remember { mutableStateOf(true) }
    var symptomDurationMonths by remember { mutableStateOf("8") }
    var defecationRelief by remember { mutableStateOf(true) }
    var changeFrequency by remember { mutableStateOf(true) }
    var changeForm by remember { mutableStateOf(false) }

    val res = remember(recurrentPain, symptomDurationMonths, defecationRelief, changeFrequency, changeForm) {
        MedicalScoringEngine.evaluateRomeIII(
            recurrentPain3DaysPerMonth = recurrentPain,
            relatedToDefecation = defecationRelief,
            changeInFrequency = changeFrequency,
            changeInForm = changeForm,
            symptomDurationMonths = symptomDurationMonths.toIntOrNull() ?: 8
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Primary Symptom & Chronicity", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        ScoringToggleRow(
            title = "Recurrent Abdominal Pain / Discomfort",
            checked = recurrentPain,
            onCheckedChange = { recurrentPain = it },
            subtitle = "Present at least 3 days per month over the last 3 months"
        )
        OutlinedTextField(
            value = symptomDurationMonths,
            onValueChange = { symptomDurationMonths = it },
            label = { Text("Symptom Duration (months, >= 6 required)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Defecation Association (>= 2 required for IBS)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        ScoringToggleRow(
            title = "1. Improvement with Defecation",
            checked = defecationRelief,
            onCheckedChange = { defecationRelief = it },
            subtitle = "Pain or discomfort resolves or diminishes after bowel movement"
        )
        ScoringToggleRow(
            title = "2. Onset Associated with Change in Frequency",
            checked = changeFrequency,
            onCheckedChange = { changeFrequency = it },
            subtitle = "More or fewer bowel movements than normal when pain starts"
        )
        ScoringToggleRow(
            title = "3. Onset Associated with Change in Stool Form",
            checked = changeForm,
            onCheckedChange = { changeForm = it },
            subtitle = "Stool appears looser/watery or harder/lumpy (Bristol 1-2 or 6-7)"
        )

        ResultBanner(
            title = "Rome III Diagnostic Evaluation",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Guidance:\n${res.clinicalRecommendation}",
            isSafe = res.calculatedValue.startsWith("IBS Negative"),
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 30. REVISED ORIGINAL AIH INTERACTIVE CARD
// =========================================================================

@Composable
fun RevisedAihInteractiveCard() {
    var isFemale by remember { mutableStateOf(true) }
    var apToAstIndex by remember { mutableIntStateOf(0) } // 0: <1.5 (+2), 1: 1.5-3.0 (0), 2: >3.0 (-2)
    var iggLevelTimesUln by remember { mutableStateOf("1.8") }
    var anaTiterIndex by remember { mutableIntStateOf(2) } // 0: <1:40, 1: 1:40, 2: 1:80, 3: >1:80
    var viralHepatitisNegative by remember { mutableStateOf(true) }
    var hepatotoxicDrugNegative by remember { mutableStateOf(true) }
    var alcoholLow by remember { mutableStateOf(true) }
    var histologyIndex by remember { mutableIntStateOf(3) } // 0: Atypical, 1: Compatible, 2: Typical, 3: Interface
    var otherAutoimmune by remember { mutableStateOf(false) }
    var steroidResponse by remember { mutableStateOf(false) }

    val res = remember(isFemale, apToAstIndex, iggLevelTimesUln, anaTiterIndex, viralHepatitisNegative, hepatotoxicDrugNegative, alcoholLow, histologyIndex, otherAutoimmune, steroidResponse) {
        MedicalScoringEngine.calculateRevisedOriginalAih(
            female = isFemale,
            apToAstRatio = apToAstIndex,
            iggLevelTimesUln = iggLevelTimesUln.toDoubleOrNull() ?: 1.8,
            anaSmaTiter = anaTiterIndex,
            viralHepatitisNegative = viralHepatitisNegative,
            hepatotoxicDrugNegative = hepatotoxicDrugNegative,
            alcoholLow = alcoholLow,
            histologyScore = histologyIndex,
            otherAutoimmuneDisease = otherAutoimmune,
            steroidResponse = steroidResponse
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = isFemale, onClick = { isFemale = true }, label = { Text("Female (+2)") })
            FilterChip(selected = !isFemale, onClick = { isFemale = false }, label = { Text("Male (0)") })
        }

        Text("Biochemical & Serological Markers", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Text("Alkaline Phosphatase : AST/ALT Ratio", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = apToAstIndex == 0, onClick = { apToAstIndex = 0 }, label = { Text("< 1.5 (+2)") })
            FilterChip(selected = apToAstIndex == 1, onClick = { apToAstIndex = 1 }, label = { Text("1.5 - 3.0 (0)") })
            FilterChip(selected = apToAstIndex == 2, onClick = { apToAstIndex = 2 }, label = { Text("> 3.0 (-2)") })
        }

        OutlinedTextField(
            value = iggLevelTimesUln,
            onValueChange = { iggLevelTimesUln = it },
            label = { Text("Serum IgG Level (x Upper Limit of Normal)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Autoantibodies (ANA, SMA, or anti-LKM1 Titer)", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = anaTiterIndex == 3, onClick = { anaTiterIndex = 3 }, label = { Text("> 1:80 (+3)") })
            FilterChip(selected = anaTiterIndex == 2, onClick = { anaTiterIndex = 2 }, label = { Text("1:80 (+2)") })
            FilterChip(selected = anaTiterIndex == 1, onClick = { anaTiterIndex = 1 }, label = { Text("1:40 (+1)") })
            FilterChip(selected = anaTiterIndex == 0, onClick = { anaTiterIndex = 0 }, label = { Text("< 1:40 (0)") })
        }

        Text("Liver Biopsy Histology", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = histologyIndex == 3, onClick = { histologyIndex = 3 }, label = { Text("Interface (+3)") })
            FilterChip(selected = histologyIndex == 2, onClick = { histologyIndex = 2 }, label = { Text("Typical (+2)") })
            FilterChip(selected = histologyIndex == 1, onClick = { histologyIndex = 1 }, label = { Text("Compatible (+1)") })
            FilterChip(selected = histologyIndex == 0, onClick = { histologyIndex = 0 }, label = { Text("Atypical (-5)") })
        }

        Text("Exclusions & History", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        ScoringToggleRow(title = "Viral Hepatitis Negative (+3)", checked = viralHepatitisNegative, onCheckedChange = { viralHepatitisNegative = it }, subtitle = "HBsAg, anti-HCV, and anti-HAV IgM all negative")
        ScoringToggleRow(title = "No Hepatotoxic Drug History (+1)", checked = hepatotoxicDrugNegative, onCheckedChange = { hepatotoxicDrugNegative = it }, subtitle = "No recent potentially hepatotoxic prescription or herbal medications")
        ScoringToggleRow(title = "Low Alcohol Consumption (+2)", checked = alcoholLow, onCheckedChange = { alcoholLow = it }, subtitle = "< 25 g/day in women, < 50 g/day in men")
        ScoringToggleRow(title = "Other Autoimmune Disease (+2)", checked = otherAutoimmune, onCheckedChange = { otherAutoimmune = it }, subtitle = "Thyroiditis, Type 1 Diabetes, Celiac, Vitiligo, Synovitis")

        ResultBanner(
            title = "1999 Revised IAIHG AIH Score",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Management:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 31. REVISED MAYO PSC MODEL INTERACTIVE CARD
// =========================================================================

@Composable
fun PscMayoInteractiveCard() {
    var age by remember { mutableStateOf("45") }
    var bilirubin by remember { mutableStateOf("2.4") }
    var albumin by remember { mutableStateOf("3.5") }
    var ast by remember { mutableStateOf("78") }
    var varicealBleed by remember { mutableStateOf(false) }

    val res = remember(age, bilirubin, albumin, ast, varicealBleed) {
        MedicalScoringEngine.calculatePscMayoModel(
            age = age.toIntOrNull() ?: 45,
            bilirubinMgDl = bilirubin.toDoubleOrNull() ?: 2.4,
            albuminGDl = albumin.toDoubleOrNull() ?: 3.5,
            astUPerL = ast.toDoubleOrNull() ?: 78.0,
            varicealBleed = varicealBleed
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Patient Age (yr)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = bilirubin,
                onValueChange = { bilirubin = it },
                label = { Text("Total Bilirubin (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = albumin,
                onValueChange = { albumin = it },
                label = { Text("Serum Albumin (g/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = ast,
                onValueChange = { ast = it },
                label = { Text("AST / SGOT (U/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        ScoringToggleRow(
            title = "History of Variceal Bleeding",
            checked = varicealBleed,
            onCheckedChange = { varicealBleed = it },
            subtitle = "Prior episode of upper GI bleeding from esophageal or gastric varices"
        )

        ResultBanner(
            title = "Revised Mayo PSC Prognostic Model",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Guidance:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 32. SIMPLIFIED AIH INTERACTIVE CARD
// =========================================================================

@Composable
fun SimplifiedAihInteractiveCard() {
    var anaTiterIndex by remember { mutableIntStateOf(2) } // 0: Neg, 1: >=1:40, 2: >=1:80
    var lkm1Positive by remember { mutableStateOf(false) }
    var iggIndex by remember { mutableIntStateOf(2) } // 0: Normal, 1: >ULN, 2: >1.1x ULN
    var histologyIndex by remember { mutableIntStateOf(2) } // 0: Atypical, 1: Compatible, 2: Typical
    var absenceViralHep by remember { mutableStateOf(true) }

    val res = remember(anaTiterIndex, lkm1Positive, iggIndex, histologyIndex, absenceViralHep) {
        MedicalScoringEngine.evaluateSimplifiedAih(
            anaOrSmaTiter = anaTiterIndex,
            lkm1OrSlaPositive = lkm1Positive,
            iggElevated = iggIndex,
            histology = histologyIndex,
            absenceOfViralHepatitis = absenceViralHep
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("1. Autoantibodies (Max 2 pts)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = anaTiterIndex == 2, onClick = { anaTiterIndex = 2 }, label = { Text("ANA/SMA >= 1:80 (2)") })
            FilterChip(selected = anaTiterIndex == 1, onClick = { anaTiterIndex = 1 }, label = { Text(">= 1:40 (1)") })
            FilterChip(selected = anaTiterIndex == 0, onClick = { anaTiterIndex = 0 }, label = { Text("Negative (0)") })
        }
        ScoringToggleRow(title = "Anti-LKM1 or SLA/LP Positive (+2)", checked = lkm1Positive, onCheckedChange = { lkm1Positive = it })

        Text("2. Serum IgG (Max 2 pts)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = iggIndex == 2, onClick = { iggIndex = 2 }, label = { Text("> 1.1x ULN (2)") })
            FilterChip(selected = iggIndex == 1, onClick = { iggIndex = 1 }, label = { Text("> ULN (1)") })
            FilterChip(selected = iggIndex == 0, onClick = { iggIndex = 0 }, label = { Text("Normal (0)") })
        }

        Text("3. Liver Histology (Max 2 pts)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = histologyIndex == 2, onClick = { histologyIndex = 2 }, label = { Text("Typical Interface (2)") })
            FilterChip(selected = histologyIndex == 1, onClick = { histologyIndex = 1 }, label = { Text("Compatible (1)") })
            FilterChip(selected = histologyIndex == 0, onClick = { histologyIndex = 0 }, label = { Text("Atypical (0)") })
        }

        Text("4. Viral Hepatitis Exclusion (2 pts)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        ScoringToggleRow(title = "Viral Hepatitis Excluded (+2)", checked = absenceViralHep, onCheckedChange = { absenceViralHep = it }, subtitle = "HBsAg, Anti-HCV, and Anti-HAV IgM negative")

        ResultBanner(
            title = "Simplified IAIHG Criteria (2008)",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Guidance:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 33. GALAD MODEL FOR HCC INTERACTIVE CARD
// =========================================================================

@Composable
fun GaladInteractiveCard() {
    var isMale by remember { mutableStateOf(true) }
    var age by remember { mutableStateOf("58") }
    var afp by remember { mutableStateOf("45") }
    var afpL3 by remember { mutableStateOf("12.5") }
    var dcp by remember { mutableStateOf("85") }

    val res = remember(isMale, age, afp, afpL3, dcp) {
        MedicalScoringEngine.calculateGalad(
            genderMale = isMale,
            age = age.toIntOrNull() ?: 58,
            afpL3Percent = afpL3.toDoubleOrNull() ?: 12.5,
            afpNgMl = afp.toDoubleOrNull() ?: 45.0,
            dcpNgMl = dcp.toDoubleOrNull() ?: 85.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = isMale, onClick = { isMale = true }, label = { Text("Male") })
            FilterChip(selected = !isMale, onClick = { isMale = false }, label = { Text("Female") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = afp, onValueChange = { afp = it }, label = { Text("Total AFP (ng/mL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = afpL3, onValueChange = { afpL3 = it }, label = { Text("AFP-L3 (%)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = dcp, onValueChange = { dcp = it }, label = { Text("DCP / PIVKA-II (ng/mL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }

        ResultBanner(
            title = "GALAD Model for HCC Surveillance",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nOncologic Action Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 34. MANNING CRITERIA FOR IBS INTERACTIVE CARD
// =========================================================================

@Composable
fun ManningInteractiveCard() {
    var c1 by remember { mutableStateOf(true) }
    var c2 by remember { mutableStateOf(true) }
    var c3 by remember { mutableStateOf(true) }
    var c4 by remember { mutableStateOf(false) }
    var c5 by remember { mutableStateOf(false) }
    var c6 by remember { mutableStateOf(false) }

    val res = remember(c1, c2, c3, c4, c5, c6) {
        MedicalScoringEngine.evaluateManningCriteria(c1, c2, c3, c4, c5, c6)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Manning Diagnostic Symptoms (>= 3 suggests IBS)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        ScoringToggleRow(title = "1. Relief of pain with defecation", checked = c1, onCheckedChange = { c1 = it })
        ScoringToggleRow(title = "2. Looser stools at onset of pain", checked = c2, onCheckedChange = { c2 = it })
        ScoringToggleRow(title = "3. More frequent stools at pain onset", checked = c3, onCheckedChange = { c3 = it })
        ScoringToggleRow(title = "4. Abdominal distension / visible bloating", checked = c4, onCheckedChange = { c4 = it })
        ScoringToggleRow(title = "5. Feeling of incomplete evacuation", checked = c5, onCheckedChange = { c5 = it })
        ScoringToggleRow(title = "6. Passage of mucus per rectum", checked = c6, onCheckedChange = { c6 = it })

        ResultBanner(
            title = "Manning Criteria Assessment",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 35. MONTREAL CLASSIFICATION FOR IBD INTERACTIVE CARD
// =========================================================================

@Composable
fun MontrealIbdInteractiveCard() {
    var isCrohns by remember { mutableStateOf(true) }
    var crohnsAge by remember { mutableStateOf("A2") }
    var crohnsLocation by remember { mutableStateOf("L3") }
    var crohnsBehavior by remember { mutableStateOf("B1") }
    var perianal by remember { mutableStateOf(false) }
    var ucExtent by remember { mutableStateOf("E2") }
    var ucSeverity by remember { mutableStateOf("S2") }

    val res = remember(isCrohns, crohnsAge, crohnsLocation, crohnsBehavior, perianal, ucExtent, ucSeverity) {
        MedicalScoringEngine.evaluateMontrealClassificationIbd(isCrohns, crohnsAge, crohnsLocation, crohnsBehavior, perianal, ucExtent, ucSeverity)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = isCrohns, onClick = { isCrohns = true }, label = { Text("Crohn's Disease") })
            FilterChip(selected = !isCrohns, onClick = { isCrohns = false }, label = { Text("Ulcerative Colitis") })
        }

        if (isCrohns) {
            Text("Age at Diagnosis", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("A1" to "< 17 yr", "A2" to "17 - 40 yr", "A3" to "> 40 yr").forEach { (code, label) ->
                    FilterChip(selected = crohnsAge == code, onClick = { crohnsAge = code }, label = { Text("$code ($label)") })
                }
            }
            Text("Disease Location", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("L1" to "Terminal Ileum", "L2" to "Colon", "L3" to "Ileocolon", "L4" to "Upper GI").forEach { (code, label) ->
                    FilterChip(selected = crohnsLocation == code, onClick = { crohnsLocation = code }, label = { Text("$code ($label)") })
                }
            }
            Text("Disease Behavior", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("B1" to "Inflammatory", "B2" to "Stricturing", "B3" to "Penetrating").forEach { (code, label) ->
                    FilterChip(selected = crohnsBehavior == code, onClick = { crohnsBehavior = code }, label = { Text("$code ($label)") })
                }
            }
            ScoringToggleRow(title = "Perianal Disease Modifier (+p)", checked = perianal, onCheckedChange = { perianal = it }, subtitle = "Perianal fistulas, abscesses, or anal fissures")
        } else {
            Text("Colonic Extent", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("E1" to "Proctitis", "E2" to "Left-Sided", "E3" to "Pancolitis").forEach { (code, label) ->
                    FilterChip(selected = ucExtent == code, onClick = { ucExtent = code }, label = { Text("$code ($label)") })
                }
            }
            Text("Severity at Presentation", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("S0" to "Remission", "S1" to "Mild", "S2" to "Moderate", "S3" to "Severe (ASUC)").forEach { (code, label) ->
                    FilterChip(selected = ucSeverity == code, onClick = { ucSeverity = code }, label = { Text("$code ($label)") })
                }
            }
        }

        ResultBanner(
            title = "Montreal Classification Phenotype",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Recommendations:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 36. BCLC STAGING FOR HCC INTERACTIVE CARD
// =========================================================================

@Composable
fun BclcInteractiveCard() {
    var stage by remember { mutableStateOf("A") }
    val res = remember(stage) { MedicalScoringEngine.evaluateBclcStaging(stage) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Barcelona Clinic Liver Cancer (BCLC) Stage", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("0" to "0 (Very Early)", "A" to "A (Early)", "B" to "B (Intermed)", "C" to "C (Advanced)", "D" to "D (Terminal)").forEach { (stg, label) ->
                FilterChip(selected = stage == stg, onClick = { stage = stg }, label = { Text(label) })
            }
        }

        Surface(
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = when (stage) {
                        "0" -> "Single nodule < 2 cm, Child-Pugh A, ECOG 0."
                        "A" -> "Single nodule or up to 3 nodules <= 3 cm, Child-Pugh A-B, ECOG 0."
                        "B" -> "Multinodular, preserved liver function, no vascular invasion, ECOG 0."
                        "C" -> "Portal vein invasion, extrahepatic spread, or ECOG 1-2."
                        else -> "End-stage cirrhosis (Child-Pugh C) or ECOG 3-4."
                    },
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        ResultBanner(
            title = "BCLC Staging & Treatment Strategy",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nGuideline Therapy Plan:\n${res.clinicalRecommendation}",
            isSafe = stage == "0" || stage == "A",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 37. 10-YEAR ASCVD RISK INTERACTIVE CARD
// =========================================================================

@Composable
fun AscvdInteractiveCard() {
    var age by remember { mutableStateOf("56") }
    var isMale by remember { mutableStateOf(true) }
    var totalChol by remember { mutableStateOf("210") }
    var hdlChol by remember { mutableStateOf("45") }
    var sbp by remember { mutableStateOf("138") }
    var onHtnMed by remember { mutableStateOf(true) }
    var isDiabetic by remember { mutableStateOf(false) }
    var isSmoker by remember { mutableStateOf(false) }

    val res = remember(age, isMale, totalChol, hdlChol, sbp, onHtnMed, isDiabetic, isSmoker) {
        MedicalScoringEngine.calculateAscvdRisk(
            age = age.toIntOrNull() ?: 56,
            isMale = isMale,
            totalChol = totalChol.toDoubleOrNull() ?: 210.0,
            hdlChol = hdlChol.toDoubleOrNull() ?: 45.0,
            systolicBp = sbp.toDoubleOrNull() ?: 138.0,
            onHtnMed = onHtnMed,
            isDiabetic = isDiabetic,
            isSmoker = isSmoker
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = isMale, onClick = { isMale = true }, label = { Text("Male") })
            FilterChip(selected = !isMale, onClick = { isMale = false }, label = { Text("Female") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (20-79 yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = sbp, onValueChange = { sbp = it }, label = { Text("Systolic BP (mmHg)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = totalChol, onValueChange = { totalChol = it }, label = { Text("Total Chol (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = hdlChol, onValueChange = { hdlChol = it }, label = { Text("HDL Chol (mg/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }

        ScoringToggleRow(title = "Treated for Hypertension", checked = onHtnMed, onCheckedChange = { onHtnMed = it }, subtitle = "Patient currently takes anti-hypertensive medication")
        ScoringToggleRow(title = "Diabetes Mellitus Present", checked = isDiabetic, onCheckedChange = { isDiabetic = it })
        ScoringToggleRow(title = "Current Cigarette Smoker", checked = isSmoker, onCheckedChange = { isSmoker = it })

        ResultBanner(
            title = "ACC/AHA 10-Year ASCVD Risk",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nStatin & Risk Reduction Guideline:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 38. SIRS CRITERIA INTERACTIVE CARD
// =========================================================================

@Composable
fun SirsSepsisInteractiveCard() {
    var temp by remember { mutableStateOf("38.6") }
    var hr by remember { mutableStateOf("104") }
    var rr by remember { mutableStateOf("24") }
    var wbc by remember { mutableStateOf("14.5") }
    var bands by remember { mutableStateOf(false) }

    val res = remember(temp, hr, rr, wbc, bands) {
        MedicalScoringEngine.evaluateSirsCriteria(
            tempCelsius = temp.toDoubleOrNull() ?: 38.6,
            heartRateBpm = hr.toIntOrNull() ?: 104,
            respRateBpm = rr.toIntOrNull() ?: 24,
            wbcCount = wbc.toDoubleOrNull() ?: 14.5,
            percentBands = if (bands) 12.0 else 0.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = temp, onValueChange = { temp = it }, label = { Text("Temp (°C, >38 or <36)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = hr, onValueChange = { hr = it }, label = { Text("Heart Rate (bpm, >90)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = rr, onValueChange = { rr = it }, label = { Text("Resp Rate (/min, >20)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = wbc, onValueChange = { wbc = it }, label = { Text("WBC (x10³/µL, >12 or <4)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        ScoringToggleRow(title = "Bandemia > 10% Immature Forms", checked = bands, onCheckedChange = { bands = it })

        ResultBanner(
            title = "SIRS Screening Criteria",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 39. ARISCAT SCORE INTERACTIVE CARD
// =========================================================================

@Composable
fun AriscatInteractiveCard() {
    var age by remember { mutableStateOf("64") }
    var spo2 by remember { mutableStateOf("94") }
    var respInfection by remember { mutableStateOf(false) }
    var anemia by remember { mutableStateOf(false) }
    var incision by remember { mutableStateOf("Upper Abdominal") }
    var durationHours by remember { mutableStateOf("2.5") }
    var emergency by remember { mutableStateOf(false) }

    val res = remember(age, spo2, respInfection, anemia, incision, durationHours, emergency) {
        MedicalScoringEngine.calculateAriscatScore(
            age = age.toIntOrNull() ?: 64,
            spo2Percent = spo2.toIntOrNull() ?: 94,
            respiratoryInfectionPastMonth = respInfection,
            preoperativeAnemia = anemia,
            surgicalIncision = incision,
            surgeryDurationHours = durationHours.toDoubleOrNull() ?: 2.5,
            emergencyProcedure = emergency
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Patient Age (yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = spo2, onValueChange = { spo2 = it }, label = { Text("Pre-op SpO2 (%)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
        }

        Text("Surgical Incision Site", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("Peripheral" to "Peripheral", "Upper Abdominal" to "Upper Abdomen (+15)", "Intrathoracic" to "Thorax (+24)").forEach { (code, label) ->
                FilterChip(selected = incision == code, onClick = { incision = code }, label = { Text(label) })
            }
        }

        OutlinedTextField(
            value = durationHours,
            onValueChange = { durationHours = it },
            label = { Text("Expected Surgery Duration (hours)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        ScoringToggleRow(title = "Respiratory Infection in Past Month (+17)", checked = respInfection, onCheckedChange = { respInfection = it })
        ScoringToggleRow(title = "Preoperative Anemia Hb <= 10 g/dL (+11)", checked = anemia, onCheckedChange = { anemia = it })
        ScoringToggleRow(title = "Emergency Procedure (+8)", checked = emergency, onCheckedChange = { emergency = it })

        ResultBanner(
            title = "ARISCAT Postoperative Pulmonary Risk",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nPerioperative Care Bundle:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 40. FULL SOFA SCORE INTERACTIVE CARD
// =========================================================================

@Composable
fun SofaInteractiveCard() {
    var respPoints by remember { mutableIntStateOf(1) }
    var coagPoints by remember { mutableIntStateOf(1) }
    var liverPoints by remember { mutableIntStateOf(1) }
    var cvPoints by remember { mutableIntStateOf(1) }
    var gcsPoints by remember { mutableIntStateOf(0) }
    var renalPoints by remember { mutableIntStateOf(1) }

    val totalPoints = respPoints + coagPoints + liverPoints + cvPoints + gcsPoints + renalPoints
    val res = remember(totalPoints) { MedicalScoringEngine.calculateSofaScore(totalPoints) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("1. Respiration (PaO2/FiO2 ratio)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to ">400", 1 to "<=400", 2 to "<=300", 3 to "<=200+V", 4 to "<=100+V").forEach { (pts, label) ->
                FilterChip(selected = respPoints == pts, onClick = { respPoints = pts }, label = { Text("$label ($pts)") })
            }
        }
        Text("2. Coagulation (Platelets x10³/µL)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to ">=150", 1 to "<150", 2 to "<100", 3 to "<50", 4 to "<20").forEach { (pts, label) ->
                FilterChip(selected = coagPoints == pts, onClick = { coagPoints = pts }, label = { Text("$label ($pts)") })
            }
        }
        Text("3. Liver (Bilirubin mg/dL)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "<1.2", 1 to "1.2-1.9", 2 to "2.0-5.9", 3 to "6.0-11.9", 4 to ">=12.0").forEach { (pts, label) ->
                FilterChip(selected = liverPoints == pts, onClick = { liverPoints = pts }, label = { Text("$label ($pts)") })
            }
        }
        Text("4. Cardiovascular (MAP & Vasopressors)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "MAP>=70", 1 to "MAP<70", 2 to "Dop<=5", 3 to "NA<=0.1", 4 to "NA>0.1").forEach { (pts, label) ->
                FilterChip(selected = cvPoints == pts, onClick = { cvPoints = pts }, label = { Text("$label ($pts)") })
            }
        }
        Text("5. CNS (Glasgow Coma Scale)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "15", 1 to "13-14", 2 to "10-12", 3 to "6-9", 4 to "<6").forEach { (pts, label) ->
                FilterChip(selected = gcsPoints == pts, onClick = { gcsPoints = pts }, label = { Text("$label ($pts)") })
            }
        }
        Text("6. Renal (Creatinine mg/dL or Urine)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf(0 to "<1.2", 1 to "1.2-1.9", 2 to "2.0-3.4", 3 to "3.5-4.9", 4 to ">=5.0").forEach { (pts, label) ->
                FilterChip(selected = renalPoints == pts, onClick = { renalPoints = pts }, label = { Text("$label ($pts)") })
            }
        }

        ResultBanner(
            title = "Sequential Organ Failure Assessment",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nICU Sepsis Management:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 41. AHA PREVENT CVD RISK INTERACTIVE CARD
// =========================================================================

@Composable
fun PreventRiskInteractiveCard() {
    var age by remember { mutableStateOf("54") }
    var isMale by remember { mutableStateOf(true) }
    var sbp by remember { mutableStateOf("132") }
    var totalChol by remember { mutableStateOf("195") }
    var hdlChol by remember { mutableStateOf("48") }
    var egfr by remember { mutableStateOf("75") }
    var uacr by remember { mutableStateOf("25") }
    var isDiabetic by remember { mutableStateOf(false) }
    var isSmoker by remember { mutableStateOf(false) }

    val res = remember(age, isMale, sbp, totalChol, hdlChol, egfr, uacr, isDiabetic, isSmoker) {
        MedicalScoringEngine.calculatePreventRisk(
            age = age.toIntOrNull() ?: 54,
            isMale = isMale,
            totalChol = totalChol.toDoubleOrNull() ?: 195.0,
            hdlChol = hdlChol.toDoubleOrNull() ?: 48.0,
            sbp = sbp.toDoubleOrNull() ?: 132.0,
            egfr = egfr.toDoubleOrNull() ?: 75.0,
            uacr = uacr.toDoubleOrNull() ?: 25.0,
            isDiabetic = isDiabetic,
            isSmoker = isSmoker
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = isMale, onClick = { isMale = true }, label = { Text("Male") })
            FilterChip(selected = !isMale, onClick = { isMale = false }, label = { Text("Female") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (30-79 yr)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = sbp, onValueChange = { sbp = it }, label = { Text("Systolic BP (mmHg)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = egfr, onValueChange = { egfr = it }, label = { Text("eGFR (mL/min)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = uacr, onValueChange = { uacr = it }, label = { Text("uACR (mg/g)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        ScoringToggleRow(title = "Type 2 Diabetes Mellitus", checked = isDiabetic, onCheckedChange = { isDiabetic = it })
        ScoringToggleRow(title = "Current Tobacco Smoker", checked = isSmoker, onCheckedChange = { isSmoker = it })

        ResultBanner(
            title = "AHA 2023 PREVENT Total CVD Risk",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nCardiovascular-Kidney-Metabolic Strategy:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 42. PECARN PEDIATRIC HEAD INJURY INTERACTIVE CARD
// =========================================================================

@Composable
fun PecarnInteractiveCard() {
    var ageUnder2 by remember { mutableStateOf(false) }
    var gcsLess15 by remember { mutableStateOf(false) }
    var palpableFracture by remember { mutableStateOf(false) }
    var alteredMental by remember { mutableStateOf(false) }
    var locOver5Sec by remember { mutableStateOf(false) }
    var severeMechanism by remember { mutableStateOf(false) }
    var notActingNormal by remember { mutableStateOf(false) }

    val res = remember(ageUnder2, gcsLess15, palpableFracture, alteredMental, locOver5Sec, severeMechanism, notActingNormal) {
        MedicalScoringEngine.evaluatePecarnHeadInjury(
            ageUnder2 = ageUnder2,
            gcsLess15 = gcsLess15,
            palpableFractureOrBasilarSign = palpableFracture,
            alteredMentalStatus = alteredMental,
            lossOfConsciousnessOver5Sec = locOver5Sec,
            severeMechanism = severeMechanism,
            notActingNormallyParent = notActingNormal
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = ageUnder2, onClick = { ageUnder2 = true }, label = { Text("Age < 2 Years") })
            FilterChip(selected = !ageUnder2, onClick = { ageUnder2 = false }, label = { Text("Age >= 2 Years") })
        }

        Text("High Risk Criteria (CT Head Indicated)", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.error)
        ScoringToggleRow(title = "GCS < 15 on Exam", checked = gcsLess15, onCheckedChange = { gcsLess15 = it })
        ScoringToggleRow(title = if (ageUnder2) "Palpable Skull Fracture" else "Signs of Basilar Skull Fracture", checked = palpableFracture, onCheckedChange = { palpableFracture = it }, subtitle = "Hemotympanum, raccoon eyes, Battle sign, CSF leak")
        ScoringToggleRow(title = "Altered Mental Status", checked = alteredMental, onCheckedChange = { alteredMental = it }, subtitle = "Agitation, lethargy, repetitive questions, slow response")

        Text("Intermediate Risk Criteria (Observe vs CT)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        ScoringToggleRow(title = "Loss of Consciousness > 5 Seconds", checked = locOver5Sec, onCheckedChange = { locOver5Sec = it })
        ScoringToggleRow(title = "Severe Injury Mechanism", checked = severeMechanism, onCheckedChange = { severeMechanism = it }, subtitle = "MVC with ejection/rollover, fall >3ft (<2y) or >5ft (>=2y), struck by vehicle")
        ScoringToggleRow(title = "Parent Reports Child Not Acting Normally", checked = notActingNormal, onCheckedChange = { notActingNormal = it })

        ResultBanner(
            title = "PECARN Pediatric Head Trauma Rule",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Decision:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 43. TRUELOVE & WITTS UC FLARE INTERACTIVE CARD
// =========================================================================

@Composable
fun TrueloveWittsInteractiveCard() {
    var stoolsPerDay by remember { mutableStateOf("7") }
    var bloodInStool by remember { mutableStateOf(true) }
    var temp by remember { mutableStateOf("38.1") }
    var hr by remember { mutableStateOf("96") }
    var hb by remember { mutableStateOf("10.0") }
    var esr by remember { mutableStateOf("38") }

    val res = remember(stoolsPerDay, bloodInStool, temp, hr, hb, esr) {
        MedicalScoringEngine.evaluateTrueloveWitts(
            stoolsPerDay = stoolsPerDay.toIntOrNull() ?: 7,
            grossBloodInStool = bloodInStool,
            tempC = temp.toDoubleOrNull() ?: 38.1,
            pulseRate = hr.toIntOrNull() ?: 96,
            hemoglobinGdL = hb.toDoubleOrNull() ?: 10.0,
            esrMmHr = esr.toIntOrNull() ?: 38
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = stoolsPerDay, onValueChange = { stoolsPerDay = it }, label = { Text("Stools / Day (>=6 severe)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = temp, onValueChange = { temp = it }, label = { Text("Temp (°C, >37.5 severe)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = hr, onValueChange = { hr = it }, label = { Text("Heart Rate (bpm, >90)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.weight(1f))
            OutlinedTextField(value = hb, onValueChange = { hb = it }, label = { Text("Hemoglobin (g/dL, <10.5)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        OutlinedTextField(value = esr, onValueChange = { esr = it }, label = { Text("ESR (mm/1st hr, >30 severe)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.fillMaxWidth())

        ScoringToggleRow(title = "Visible Blood in Most Stools", checked = bloodInStool, onCheckedChange = { bloodInStool = it })

        ResultBanner(
            title = "Truelove & Witts Severity Criteria",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Action Plan:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 44. ABG & ELECTROLYTE SOLVER INTERACTIVE CARD
// =========================================================================

@Composable
fun AbgSolverInteractiveCard() {
    var ph by remember { mutableStateOf("7.28") }
    var paco2 by remember { mutableStateOf("30") }
    var hco3 by remember { mutableStateOf("14") }
    var na by remember { mutableStateOf("138") }
    var cl by remember { mutableStateOf("102") }
    var albumin by remember { mutableStateOf("3.2") }

    val res = remember(ph, paco2, hco3, na, cl, albumin) {
        MedicalScoringEngine.solveAbgFull(
            ph = ph.toDoubleOrNull() ?: 7.28,
            paco2 = paco2.toDoubleOrNull() ?: 30.0,
            hco3 = hco3.toDoubleOrNull() ?: 14.0,
            na = na.toDoubleOrNull() ?: 138.0,
            cl = cl.toDoubleOrNull() ?: 102.0,
            albumin = albumin.toDoubleOrNull() ?: 3.2
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = ph, onValueChange = { ph = it }, label = { Text("Arterial pH") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = paco2, onValueChange = { paco2 = it }, label = { Text("PaCO2 (mmHg)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = hco3, onValueChange = { hco3 = it }, label = { Text("HCO3⁻ (mEq/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = na, onValueChange = { na = it }, label = { Text("Serum Na⁺ (mEq/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = cl, onValueChange = { cl = it }, label = { Text("Serum Cl⁻ (mEq/L)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
            OutlinedTextField(value = albumin, onValueChange = { albumin = it }, label = { Text("Albumin (g/dL)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), modifier = Modifier.weight(1f))
        }

        ResultBanner(
            title = "Acid-Base & Anion Gap Interpretation",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nDiagnostic & Therapeutic Guidance:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}

// =============================================================================
// 45. CLIF-C ACLF INTERACTIVE CARD
// =========================================================================

@Composable
fun ClifCAclfStandaloneCard() {
    var ofScore by remember { mutableStateOf("11") }
    var age by remember { mutableStateOf("52") }
    var wbc by remember { mutableStateOf("14.2") }

    val res = remember(ofScore, age, wbc) {
        MedicalScoringEngine.calculateClifCAclf(
            clifSofaOrganFailuresCount = ofScore.toIntOrNull() ?: 11,
            age = age.toIntOrNull() ?: 52,
            wbcK_uL = wbc.toDoubleOrNull() ?: 14.2
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = ofScore,
            onValueChange = { ofScore = it },
            label = { Text("CLIF-Organ Failure Score (OFs 6-18)") },
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
                label = { Text("WBC Count (x10³/µL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "CLIF-C Acute-on-Chronic Liver Failure",
            valueText = res.calculatedValue,
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nClinical Recommendation:\n${res.clinicalRecommendation}",
            isSafe = res.riskTier == "Low",
            jsonPayload = res.toJsonString()
        )
    }
}
