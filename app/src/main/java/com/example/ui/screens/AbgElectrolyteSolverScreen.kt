package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import java.util.Locale
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

enum class AbgTab(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    ABG_SOLVER("ABG Acid-Base", Icons.Default.Speed),
    ELECTROLYTES("Electrolytes & Deficits", Icons.Default.WaterDrop),
    PRESET_SCENARIOS("ICU Clinical Cases", Icons.Default.MedicalServices)
}

enum class ElectrolyteSubCategory(val label: String) {
    SODIUM_HYPO("Hyponatremia & Na Deficit"),
    SODIUM_HYPER("Hypernatremia & FWD"),
    POTASSIUM("Potassium (K+) Crisis"),
    CALCIUM_MAG("Calcium & Magnesium")
}

@Composable
fun AbgElectrolyteSolverScreen(
    onBackClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(AbgTab.ABG_SOLVER) }

    // --- ABG Inputs ---
    var phInput by remember { mutableStateOf("7.22") }
    var paco2Input by remember { mutableStateOf("26") }
    var hco3Input by remember { mutableStateOf("10") }
    var naInput by remember { mutableStateOf("138") }
    var clInput by remember { mutableStateOf("100") }
    var albuminInput by remember { mutableStateOf("4.0") }
    var pao2Input by remember { mutableStateOf("85") }
    var fio2Input by remember { mutableStateOf("21") } // 21% room air
    var patientWeightInput by remember { mutableStateOf("60") }
    var patientAgeInput by remember { mutableStateOf("45") }

    // --- Electrolyte Inputs ---
    var selectedElectrolyteSub by remember { mutableStateOf(ElectrolyteSubCategory.SODIUM_HYPO) }
    var measuredNaInput by remember { mutableStateOf("118") }
    var targetNaInput by remember { mutableStateOf("128") }
    var bloodGlucoseInput by remember { mutableStateOf("380") }
    var isFemaleGender by remember { mutableStateOf(false) }
    var isElderlyPatient by remember { mutableStateOf(false) }
    var measuredKInput by remember { mutableStateOf("6.8") }
    var measuredCaInput by remember { mutableStateOf("7.2") }
    var measuredMgInput by remember { mutableStateOf("1.4") }

    // Numerical conversions with defaults
    val ph = phInput.toDoubleOrNull() ?: 7.22
    val paco2 = paco2Input.toDoubleOrNull() ?: 26.0
    val hco3 = hco3Input.toDoubleOrNull() ?: 10.0
    val na = naInput.toDoubleOrNull() ?: 138.0
    val cl = clInput.toDoubleOrNull() ?: 100.0
    val albumin = albuminInput.toDoubleOrNull() ?: 4.0
    val pao2 = pao2Input.toDoubleOrNull() ?: 85.0
    val fio2 = (fio2Input.toDoubleOrNull() ?: 21.0).coerceIn(21.0, 100.0)
    val weightKg = (patientWeightInput.toDoubleOrNull() ?: 60.0).coerceAtLeast(10.0)
    val age = (patientAgeInput.toDoubleOrNull() ?: 45.0).coerceAtLeast(1.0)

    // --- Clinical Calculations for ABG ---
    // 1. Primary Status
    val acidBaseStatus = remember(ph) {
        when {
            ph < 7.35 -> "Acidemia (pH < 7.35)"
            ph > 7.45 -> "Alkalemia (pH > 7.45)"
            else -> "Normal pH (7.35 – 7.45)"
        }
    }

    // 2. Primary Disorders & Expected Compensation
    val (primaryDisorder, compensationStatus, expectedPaco2String) = remember(ph, paco2, hco3) {
        if (ph < 7.35) {
            // Acidemia
            if (hco3 < 22.0 && paco2 <= 45.0) {
                // Primary Metabolic Acidosis -> Winter's formula: Expected PaCO2 = (1.5 * HCO3) + 8 ± 2
                val expectedPaco2 = (1.5 * hco3) + 8.0
                val minExp = expectedPaco2 - 2.0
                val maxExp = expectedPaco2 + 2.0
                val comp = when {
                    paco2 < minExp -> "Concomitant Respiratory Alkalosis (Actual PaCO2 is lower than Winter's predicted: $minExp–$maxExp)"
                    paco2 > maxExp -> "Concomitant Respiratory Acidosis / Hypoventilation failure (Actual PaCO2 > Winter's expected: $minExp–$maxExp)"
                    else -> "Adequately Compensated by Hyperventilation (Winter's formula expected PaCO2: ${String.format(Locale.US, "%.1f", minExp)}–${String.format(Locale.US, "%.1f", maxExp)} mmHg)"
                }
                Triple("Metabolic Acidosis", comp, "${String.format(Locale.US, "%.1f", minExp)} – ${String.format(Locale.US, "%.1f", maxExp)} mmHg")
            } else if (paco2 > 45.0 && hco3 >= 22.0) {
                // Primary Respiratory Acidosis
                val deltaPaco2 = paco2 - 40.0
                val acuteExpHco3 = 24.0 + (deltaPaco2 / 10.0 * 1.0)
                val chronicExpHco3 = 24.0 + (deltaPaco2 / 10.0 * 3.5)
                val comp = "Acute Expected HCO3: ~${String.format(Locale.US, "%.1f", acuteExpHco3)} mEq/L; Chronic Expected: ~${String.format(Locale.US, "%.1f", chronicExpHco3)} mEq/L"
                Triple("Respiratory Acidosis", comp, "Acute: ~${String.format(Locale.US, "%.1f", acuteExpHco3)}, Chronic: ~${String.format(Locale.US, "%.1f", chronicExpHco3)} mEq/L")
            } else {
                Triple("Mixed Acidosis (Combined Metabolic & Respiratory Acidosis)", "Severe dual failure: low HCO3- AND elevated PaCO2 with profound acidemia.", "N/A")
            }
        } else if (ph > 7.45) {
            // Alkalemia
            if (hco3 > 26.0 && paco2 >= 35.0) {
                // Primary Metabolic Alkalosis -> Expected PaCO2 = (0.7 * [HCO3 - 24]) + 40 ± 2
                val expectedPaco2 = (0.7 * (hco3 - 24.0)) + 40.0
                val minExp = expectedPaco2 - 2.0
                val maxExp = expectedPaco2 + 2.0
                val comp = when {
                    paco2 < minExp -> "Concomitant Respiratory Alkalosis (Actual PaCO2 is below expected hypoventilation limit)"
                    paco2 > maxExp -> "Concomitant Respiratory Acidosis"
                    else -> "Appropriate Respiratory Compensation (Expected PaCO2: ${String.format(Locale.US, "%.1f", minExp)}–${String.format(Locale.US, "%.1f", maxExp)} mmHg)"
                }
                Triple("Metabolic Alkalosis", comp, "${String.format(Locale.US, "%.1f", minExp)} – ${String.format(Locale.US, "%.1f", maxExp)} mmHg")
            } else if (paco2 < 35.0 && hco3 <= 26.0) {
                // Primary Respiratory Alkalosis
                val deltaPaco2 = 40.0 - paco2
                val acuteExpHco3 = 24.0 - (deltaPaco2 / 10.0 * 2.0)
                val chronicExpHco3 = 24.0 - (deltaPaco2 / 10.0 * 5.0)
                val comp = "Acute Expected HCO3: ~${String.format(Locale.US, "%.1f", acuteExpHco3)} mEq/L; Chronic Expected: ~${String.format(Locale.US, "%.1f", chronicExpHco3)} mEq/L"
                Triple("Respiratory Alkalosis", comp, "Acute: ~${String.format(Locale.US, "%.1f", acuteExpHco3)}, Chronic: ~${String.format(Locale.US, "%.1f", chronicExpHco3)} mEq/L")
            } else {
                Triple("Mixed Alkalosis (Combined Metabolic & Respiratory Alkalosis)", "Simultaneous high HCO3- and hyperventilation low PaCO2.", "N/A")
            }
        } else {
            // Normal pH: could be fully compensated mixed or normal
            if (hco3 < 22.0 && paco2 < 35.0) {
                Triple("Compensated Acid-Base Disturbance (Metabolic Acidosis + Compensatory Resp Alkalosis)", "pH normalized by strong compensation or mixed primary disorders.", "Compensated")
            } else if (hco3 > 26.0 && paco2 > 45.0) {
                Triple("Compensated Acid-Base Disturbance (Metabolic Alkalosis + Compensatory Resp Acidosis)", "pH normalized by compensation.", "Compensated")
            } else {
                Triple("Normal Acid-Base Profile", "Values fall within normal arterial reference limits.", "Normal")
            }
        }
    }

    // 3. Anion Gap Calculation: AG = Na - (Cl + HCO3)
    val rawAnionGap = remember(na, cl, hco3) {
        na - (cl + hco3)
    }

    // Albumin corrected AG: AG + 2.5 * (4.0 - Albumin)
    val correctedAnionGap = remember(rawAnionGap, albumin) {
        val corr = rawAnionGap + 2.5 * (4.0 - albumin)
        String.format(Locale.US, "%.1f", corr).toDouble()
    }

    val anionGapCategory = remember(correctedAnionGap) {
        when {
            correctedAnionGap > 12.0 -> "HIGH ANION GAP (HAGMA > 12 mEq/L)"
            correctedAnionGap < 3.0 -> "Low Anion Gap (< 3 mEq/L - Multiple Myeloma, Severe Hypoalbuminemia, Bromide)"
            else -> "Normal Anion Gap (3 – 12 mEq/L)"
        }
    }

    // 4. Delta-Delta Ratio (for HAGMA): (AG - 12) / (24 - HCO3)
    val deltaRatioInfo = remember(correctedAnionGap, hco3) {
        val deltaAg = correctedAnionGap - 12.0
        val deltaHco3 = 24.0 - hco3
        if (correctedAnionGap > 12.0 && deltaHco3 > 0.0) {
            val ratio = deltaAg / deltaHco3
            val text = when {
                ratio < 0.4 -> "Ratio: ${String.format(Locale.US, "%.2f", ratio)} (< 0.4) -> Concomitant Normal Anion Gap Metabolic Acidosis (NAGMA/Hyperchloremic)."
                ratio in 0.4..0.8 -> "Ratio: ${String.format(Locale.US, "%.2f", ratio)} (0.4 – 0.8) -> Combined High AG + Normal AG Acidosis (e.g., DKA + Diarrhea)."
                ratio in 0.8..2.0 -> "Ratio: ${String.format(Locale.US, "%.2f", ratio)} (0.8 – 2.0) -> Pure High Anion Gap Metabolic Acidosis (HAGMA)."
                else -> "Ratio: ${String.format(Locale.US, "%.2f", ratio)} (> 2.0) -> High AG Acidosis + Pre-existing Metabolic Alkalosis (e.g., DKA with Vomiting or Diuretic use)."
            }
            Pair(String.format(Locale.US, "%.2f", ratio), text)
        } else {
            Pair("N/A", "Delta-delta ratio is only applicable when High Anion Gap Metabolic Acidosis is present.")
        }
    }

    // 5. Oxygenation & P/F Ratio: PaO2 / (FiO2 / 100)
    val pfRatio = remember(pao2, fio2) {
        val fraction = fio2 / 100.0
        val ratio = pao2 / fraction
        String.format(Locale.US, "%.1f", ratio).toDouble()
    }

    val ardsSeverity = remember(pfRatio) {
        when {
            pfRatio >= 300.0 -> "Normal Oxygenation / Mild Impairment (P/F ≥ 300)"
            pfRatio in 200.0..299.9 -> "Mild ARDS (Berlin Criteria: 200 ≤ P/F < 300)"
            pfRatio in 100.0..199.9 -> "Moderate ARDS (Berlin Criteria: 100 ≤ P/F < 200)"
            else -> "Severe ARDS (Berlin Criteria: P/F < 100) - High Mortality Risk"
        }
    }

    // 6. Alveolar-Arterial (A-a) Gradient
    // PAO2 = (FiO2 / 100 * (760 - 47)) - (PaCO2 / 0.8)
    val (aaGradient, expectedAaGradient) = remember(pao2, paco2, fio2, age) {
        val patm = 760.0
        val ph2o = 47.0
        val fraction = fio2 / 100.0
        val paO2Alveolar = (fraction * (patm - ph2o)) - (paco2 / 0.8)
        val grad = (paO2Alveolar - pao2).coerceAtLeast(0.0)
        val expectedGrad = (age / 4.0) + 4.0
        Pair(
            String.format(Locale.US, "%.1f", grad),
            String.format(Locale.US, "%.1f", expectedGrad)
        )
    }

    // 7. Bicarbonate Deficit (mEq) = 0.5 * Weight (kg) * (24 - HCO3)
    val hco3Deficit = remember(weightKg, hco3) {
        if (hco3 < 24.0) {
            val def = 0.5 * weightKg * (24.0 - hco3)
            String.format(Locale.US, "%.0f", def)
        } else "0"
    }

    Scaffold(
        containerColor = Color(0xFF030712),
        topBar = {
            Surface(
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF1E293B))
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.testTag("abg_solver_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "ABG & Electrolyte Solver",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(0xFFEF4444).copy(alpha = 0.25f),
                                    border = BorderStroke(0.6.dp, Color(0xFFEF4444))
                                ) {
                                    Text(
                                        text = "ICU SUITE",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFF87171),
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Winter's Formula • Delta Gap • Na/K Deficits • 3% Saline",
                                fontSize = 10.sp,
                                color = Slate400,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        // Preset Clinical Cases Quick Launch
                        Surface(
                            onClick = { selectedTab = AbgTab.PRESET_SCENARIOS },
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF1E293B),
                            border = BorderStroke(0.8.dp, Color(0xFF38BDF8).copy(alpha = 0.5f)),
                            modifier = Modifier.testTag("abg_quick_cases_button")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MedicalServices,
                                    contentDescription = null,
                                    tint = Color(0xFF38BDF8),
                                    modifier = Modifier.size(13.dp)
                                )
                                Text(
                                    text = "Cases",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF38BDF8)
                                )
                            }
                        }
                    }

                    // Main Mode Tabs
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        AbgTab.values().forEach { tab ->
                            val isSelected = selectedTab == tab
                            val activeColor = when (tab) {
                                AbgTab.ABG_SOLVER -> Color(0xFF38BDF8)
                                AbgTab.ELECTROLYTES -> Color(0xFF34D399)
                                AbgTab.PRESET_SCENARIOS -> Color(0xFFFBBF24)
                            }
                            Surface(
                                onClick = { selectedTab = tab },
                                shape = RoundedCornerShape(8.dp),
                                color = if (isSelected) activeColor.copy(alpha = 0.2f) else Color(0xFF1E293B),
                                border = BorderStroke(1.dp, if (isSelected) activeColor else Color.Transparent),
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("abg_tab_${tab.name.lowercase()}")
                            ) {
                                Row(
                                    modifier = Modifier.padding(vertical = 7.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = tab.icon,
                                        contentDescription = null,
                                        tint = if (isSelected) activeColor else Slate400,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = tab.label,
                                        fontSize = 10.5.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) Color.White else Slate400,
                                        maxLines = 1
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF030712))
        ) {
            when (selectedTab) {
                AbgTab.ABG_SOLVER -> {
                    AbgSolverTabContent(
                        phInput = phInput,
                        onPhChange = { phInput = it },
                        paco2Input = paco2Input,
                        onPaco2Change = { paco2Input = it },
                        hco3Input = hco3Input,
                        onHco3Change = { hco3Input = it },
                        naInput = naInput,
                        onNaChange = { naInput = it },
                        clInput = clInput,
                        onClChange = { clInput = it },
                        albuminInput = albuminInput,
                        onAlbuminChange = { albuminInput = it },
                        pao2Input = pao2Input,
                        onPao2Change = { pao2Input = it },
                        fio2Input = fio2Input,
                        onFio2Change = { fio2Input = it },
                        patientWeightInput = patientWeightInput,
                        onWeightChange = { patientWeightInput = it },
                        patientAgeInput = patientAgeInput,
                        onAgeChange = { patientAgeInput = it },
                        acidBaseStatus = acidBaseStatus,
                        primaryDisorder = primaryDisorder,
                        compensationStatus = compensationStatus,
                        expectedPaco2String = expectedPaco2String,
                        rawAnionGap = rawAnionGap,
                        correctedAnionGap = correctedAnionGap,
                        anionGapCategory = anionGapCategory,
                        deltaRatioInfo = deltaRatioInfo,
                        pfRatio = pfRatio,
                        ardsSeverity = ardsSeverity,
                        aaGradient = aaGradient,
                        expectedAaGradient = expectedAaGradient,
                        hco3Deficit = hco3Deficit
                    )
                }

                AbgTab.ELECTROLYTES -> {
                    ElectrolytesTabContent(
                        selectedSub = selectedElectrolyteSub,
                        onSubChange = { selectedElectrolyteSub = it },
                        measuredNaInput = measuredNaInput,
                        onMeasuredNaChange = { measuredNaInput = it },
                        targetNaInput = targetNaInput,
                        onTargetNaChange = { targetNaInput = it },
                        bloodGlucoseInput = bloodGlucoseInput,
                        onBloodGlucoseChange = { bloodGlucoseInput = it },
                        isFemaleGender = isFemaleGender,
                        onGenderChange = { isFemaleGender = it },
                        isElderlyPatient = isElderlyPatient,
                        onElderlyChange = { isElderlyPatient = it },
                        weightKgInput = patientWeightInput,
                        onWeightChange = { patientWeightInput = it },
                        measuredKInput = measuredKInput,
                        onMeasuredKChange = { measuredKInput = it },
                        measuredCaInput = measuredCaInput,
                        onMeasuredCaChange = { measuredCaInput = it },
                        measuredMgInput = measuredMgInput,
                        onMeasuredMgChange = { measuredMgInput = it },
                        albuminInput = albuminInput,
                        onAlbuminChange = { albuminInput = it }
                    )
                }

                AbgTab.PRESET_SCENARIOS -> {
                    PresetScenariosTabContent(
                        onApplyPreset = { preset ->
                            phInput = preset.ph
                            paco2Input = preset.paco2
                            hco3Input = preset.hco3
                            naInput = preset.na
                            clInput = preset.cl
                            albuminInput = preset.albumin
                            pao2Input = preset.pao2
                            fio2Input = preset.fio2
                            patientWeightInput = preset.weight
                            selectedTab = AbgTab.ABG_SOLVER
                        },
                        onApplyElectrolytePreset = { naVal, targetVal, glucVal, kVal ->
                            measuredNaInput = naVal
                            targetNaInput = targetVal
                            bloodGlucoseInput = glucVal
                            measuredKInput = kVal
                            selectedTab = AbgTab.ELECTROLYTES
                        }
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------
// TAB 1: ABG ACID-BASE INTERPRETER & STEPWISE DIAGNOSTIC ENGINE
// -------------------------------------------------------------
@Composable
private fun AbgSolverTabContent(
    phInput: String,
    onPhChange: (String) -> Unit,
    paco2Input: String,
    onPaco2Change: (String) -> Unit,
    hco3Input: String,
    onHco3Change: (String) -> Unit,
    naInput: String,
    onNaChange: (String) -> Unit,
    clInput: String,
    onClChange: (String) -> Unit,
    albuminInput: String,
    onAlbuminChange: (String) -> Unit,
    pao2Input: String,
    onPao2Change: (String) -> Unit,
    fio2Input: String,
    onFio2Change: (String) -> Unit,
    patientWeightInput: String,
    onWeightChange: (String) -> Unit,
    patientAgeInput: String,
    onAgeChange: (String) -> Unit,
    acidBaseStatus: String,
    primaryDisorder: String,
    compensationStatus: String,
    expectedPaco2String: String,
    rawAnionGap: Double,
    correctedAnionGap: Double,
    anionGapCategory: String,
    deltaRatioInfo: Pair<String, String>,
    pfRatio: Double,
    ardsSeverity: String,
    aaGradient: String,
    expectedAaGradient: String,
    hco3Deficit: String
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Quick interpretation banner card
        item {
            val isSevereAcidemia = (phInput.toDoubleOrNull() ?: 7.4) < 7.20
            val cardBorderColor = if (isSevereAcidemia) Color(0xFFEF4444) else Color(0xFF0284C7)
            val cardBg = if (isSevereAcidemia) Color(0xFF450A0A) else Color(0xFF0C2442)

            Surface(
                shape = RoundedCornerShape(14.dp),
                color = cardBg,
                border = BorderStroke(1.5.dp, cardBorderColor),
                modifier = Modifier.fillMaxWidth().testTag("abg_summary_card")
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Science,
                                contentDescription = null,
                                tint = if (isSevereAcidemia) Color(0xFFF87171) else Color(0xFF38BDF8),
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = "DIAGNOSTIC CONCLUSION",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isSevereAcidemia) Color(0xFFF87171) else Color(0xFF38BDF8)
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color.Black.copy(alpha = 0.4f),
                            border = BorderStroke(0.6.dp, Color.White.copy(alpha = 0.2f))
                        ) {
                            Text(
                                text = acidBaseStatus,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Text(
                        text = primaryDisorder,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    // Compensation & Gap Summary
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color.Black.copy(alpha = 0.35f),
                        border = BorderStroke(0.8.dp, Color.White.copy(alpha = 0.1f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Winter's Expected PaCO2:", fontSize = 10.5.sp, color = Slate400)
                                Text(expectedPaco2String, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                            Text(
                                text = "• $compensationStatus",
                                fontSize = 10.5.sp,
                                color = Color(0xFFCBD5E1)
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.White.copy(alpha = 0.1f)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Corrected Anion Gap:", fontSize = 10.5.sp, color = Slate400)
                                Text(
                                    text = "$correctedAnionGap mEq/L ($anionGapCategory)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (correctedAnionGap > 12.0) Color(0xFFF87171) else Color(0xFF34D399)
                                )
                            }

                            if (correctedAnionGap > 12.0) {
                                Text(
                                    text = "• Delta-Delta (Δ/Δ): ${deltaRatioInfo.second}",
                                    fontSize = 10.5.sp,
                                    color = Color(0xFFFCD34D)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Input Parameters Panel
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF1E293B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "1. ARTERIAL BLOOD GAS (ABG) CORE VALUES",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF38BDF8)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AbgInputField(
                            label = "pH (Arterial)",
                            value = phInput,
                            onValueChange = onPhChange,
                            unit = "7.35–7.45",
                            modifier = Modifier.weight(1f),
                            testTag = "input_ph"
                        )
                        AbgInputField(
                            label = "PaCO2",
                            value = paco2Input,
                            onValueChange = onPaco2Change,
                            unit = "mmHg (35–45)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_paco2"
                        )
                        AbgInputField(
                            label = "HCO3-",
                            value = hco3Input,
                            onValueChange = onHco3Change,
                            unit = "mEq/L (22–26)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_hco3"
                        )
                    }

                    Text(
                        text = "2. SERUM ELECTROLYTES & ALBUMIN (For Anion & Delta Gap)",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF34D399)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AbgInputField(
                            label = "Na+ (Sodium)",
                            value = naInput,
                            onValueChange = onNaChange,
                            unit = "mEq/L (135–145)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_na"
                        )
                        AbgInputField(
                            label = "Cl- (Chloride)",
                            value = clInput,
                            onValueChange = onClChange,
                            unit = "mEq/L (96–106)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_cl"
                        )
                        AbgInputField(
                            label = "Albumin",
                            value = albuminInput,
                            onValueChange = onAlbuminChange,
                            unit = "g/dL (norm: 4.0)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_alb"
                        )
                    }

                    Text(
                        text = "3. OXYGENATION & ARDS STRATIFICATION",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFFBBF24)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AbgInputField(
                            label = "PaO2",
                            value = pao2Input,
                            onValueChange = onPao2Change,
                            unit = "mmHg (80–100)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_pao2"
                        )
                        AbgInputField(
                            label = "FiO2 %",
                            value = fio2Input,
                            onValueChange = onFio2Change,
                            unit = "% (Room air: 21)",
                            modifier = Modifier.weight(1f),
                            testTag = "input_fio2"
                        )
                        AbgInputField(
                            label = "Patient Wt",
                            value = patientWeightInput,
                            onValueChange = onWeightChange,
                            unit = "kg",
                            modifier = Modifier.weight(1f),
                            testTag = "input_abg_weight"
                        )
                    }
                }
            }
        }

        // Detailed Step-by-Step Diagnostic Cards
        item {
            Text(
                text = "STEP-BY-STEP ICU ANALYSIS",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
        }

        // Step 1 & 2: Primary Acid-Base & Winter's
        item {
            ClinicalAnalysisCard(
                stepNumber = "1 & 2",
                title = "Primary Disturbance & Respiratory Compensation",
                statusText = primaryDisorder,
                details = listOf(
                    "pH Classification" to "$phInput ($acidBaseStatus)",
                    "PaCO2" to "$paco2Input mmHg (Normal: 35 – 45 mmHg)",
                    "Serum Bicarbonate (HCO3-)" to "$hco3Input mEq/L (Normal: 22 – 26 mEq/L)",
                    "Winter's Formula Rule" to "Expected PaCO2 = (1.5 × HCO3-) + 8 ± 2 mmHg",
                    "Expected PaCO2 Range" to expectedPaco2String,
                    "Interpretation" to compensationStatus
                ),
                color = Color(0xFF38BDF8)
            )
        }

        // Step 3 & 4: Anion Gap & Delta Gap
        item {
            ClinicalAnalysisCard(
                stepNumber = "3 & 4",
                title = "Serum Anion Gap & Delta Ratio (Δ/Δ)",
                statusText = anionGapCategory,
                details = listOf(
                    "Raw Anion Gap [Na - (Cl + HCO3)]" to "${String.format(Locale.US, "%.1f", rawAnionGap)} mEq/L",
                    "Albumin Correction (+2.5 per 1g/dL drop below 4)" to "$correctedAnionGap mEq/L",
                    "Delta Ratio (ΔAG / ΔHCO3)" to deltaRatioInfo.first,
                    "Delta-Delta Meaning" to deltaRatioInfo.second,
                    "HAGMA Etiologies (GOLD MARK)" to "Glycols, Oxoproline, L-lactate, D-lactate, Methanol, Aspirin/Salicylates, Renal failure/Uremia, Ketoacidosis (DKA, Starvation)",
                    "NAGMA Etiologies (HARDUP)" to "Hyperalimentation, Acetazolamide, Renal tubular acidosis (RTA 1, 2, 4), Diarrhea, Ureteral diversion, Pancreatic fistula"
                ),
                color = if (correctedAnionGap > 12.0) Color(0xFFEF4444) else Color(0xFF10B981)
            )
        }

        // Step 5: Oxygenation & P/F Ratio
        item {
            ClinicalAnalysisCard(
                stepNumber = "5",
                title = "Oxygenation Index & Alveolar-Arterial Gradient",
                statusText = ardsSeverity,
                details = listOf(
                    "PaO2 / FiO2 (P/F) Ratio" to "$pfRatio mmHg",
                    "A-a Gradient (Alveolar - Arterial)" to "$aaGradient mmHg",
                    "Expected Normal A-a for Age" to "< $expectedAaGradient mmHg [(Age / 4) + 4]",
                    "A-a Gradient Clinical Insight" to if ((aaGradient.toDoubleOrNull() ?: 0.0) > (expectedAaGradient.toDoubleOrNull() ?: 15.0)) "Elevated A-a gradient suggests V/Q mismatch, shunt, or diffusion impairment (e.g. Pneumonia, PE, ARDS, Pulmonary Edema)." else "Normal A-a gradient suggests pure hypoventilation (e.g. CNS depression, opioid toxicity, neuromuscular disease) or high altitude."
                ),
                color = Color(0xFFF59E0B)
            )
        }

        // Step 6: Bicarbonate Deficit & NaHCO3 Rules
        if (hco3Input.toDoubleOrNull() ?: 24.0 < 20.0) {
            item {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF1E1B4B),
                    border = BorderStroke(1.dp, Color(0xFF818CF8)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(Icons.Default.Healing, contentDescription = null, tint = Color(0xFFA5B4FC), modifier = Modifier.size(16.dp))
                            Text(
                                text = "BICARBONATE DEFICIT & ICU RESUSCITATION",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFA5B4FC)
                            )
                        }

                        Text(
                            text = "Calculated Bicarbonate Deficit: $hco3Deficit mEq",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Formula: 0.5 × Weight ($patientWeightInput kg) × (24 - $hco3Input mEq/L)",
                            fontSize = 10.sp,
                            color = Slate400
                        )

                        Text(
                            text = "⚠️ CLINICAL CAUTION: Routine IV NaHCO3 is controversial in DKA or lactic acidosis. Only administer if pH < 7.10, refractory severe hyperkalemia, or severe RTA. Replace half of calculated deficit over 4–8 hours and re-check arterial blood gas.",
                            fontSize = 10.5.sp,
                            color = Color(0xFFE0E7FF)
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// TAB 2: ELECTROLYTE DISTURBANCES & DEFICIT SOLVERS
// -------------------------------------------------------------
@Composable
private fun ElectrolytesTabContent(
    selectedSub: ElectrolyteSubCategory,
    onSubChange: (ElectrolyteSubCategory) -> Unit,
    measuredNaInput: String,
    onMeasuredNaChange: (String) -> Unit,
    targetNaInput: String,
    onTargetNaChange: (String) -> Unit,
    bloodGlucoseInput: String,
    onBloodGlucoseChange: (String) -> Unit,
    isFemaleGender: Boolean,
    onGenderChange: (Boolean) -> Unit,
    isElderlyPatient: Boolean,
    onElderlyChange: (Boolean) -> Unit,
    weightKgInput: String,
    onWeightChange: (String) -> Unit,
    measuredKInput: String,
    onMeasuredKChange: (String) -> Unit,
    measuredCaInput: String,
    onMeasuredCaChange: (String) -> Unit,
    measuredMgInput: String,
    onMeasuredMgChange: (String) -> Unit,
    albuminInput: String,
    onAlbuminChange: (String) -> Unit
) {
    val weightKg = (weightKgInput.toDoubleOrNull() ?: 60.0).coerceAtLeast(10.0)
    val measuredNa = measuredNaInput.toDoubleOrNull() ?: 118.0
    val targetNa = targetNaInput.toDoubleOrNull() ?: 128.0
    val glucose = bloodGlucoseInput.toDoubleOrNull() ?: 100.0
    val measuredK = measuredKInput.toDoubleOrNull() ?: 6.8
    val measuredCa = measuredCaInput.toDoubleOrNull() ?: 7.2
    val measuredMg = measuredMgInput.toDoubleOrNull() ?: 1.4
    val albumin = albuminInput.toDoubleOrNull() ?: 4.0

    // TBW Multiplier: Young male 0.6, Young female 0.5, Elderly male 0.5, Elderly female 0.45
    val tbwFraction = when {
        isElderlyPatient && isFemaleGender -> 0.45
        isElderlyPatient && !isFemaleGender -> 0.50
        !isElderlyPatient && isFemaleGender -> 0.50
        else -> 0.60
    }
    val totalBodyWaterLiters = weightKg * tbwFraction

    // 1. Glucose-corrected Sodium (Katz: Na + 0.016 * [Glu - 100]; Hillier: Na + 0.024 * [Glu - 100])
    val correctedNaKatz = if (glucose > 100.0) measuredNa + (0.016 * (glucose - 100.0)) else measuredNa
    val correctedNaHillier = if (glucose > 100.0) measuredNa + (0.024 * (glucose - 100.0)) else measuredNa

    // 2. Sodium Deficit (mEq) = TBW * (Target Na - Measured Na)
    val naDeficit = (totalBodyWaterLiters * (targetNa - measuredNa)).coerceAtLeast(0.0)

    // 3. Adrogué-Madias Formula for 3% Hypertonic Saline (513 mEq/L Na):
    // Delta Na per 1L bag = (513 - Measured Na) / (TBW + 1)
    val deltaNaPerLiter3Percent = if (totalBodyWaterLiters > 0.0) {
        (513.0 - measuredNa) / (totalBodyWaterLiters + 1.0)
    } else 10.0

    // Rate of 3% NaCl in mL/hr to raise Na by 1 mEq/L/hr (emergency) or 0.5 mEq/L/hr
    val mlOf3PercentFor1MeqChange = if (deltaNaPerLiter3Percent > 0.0) {
        1000.0 / deltaNaPerLiter3Percent
    } else 100.0

    // 4. Free Water Deficit (for Hypernatremia): FWD = TBW * ([Measured Na / 140] - 1)
    val freeWaterDeficit = (totalBodyWaterLiters * ((measuredNa / 140.0) - 1.0)).coerceAtLeast(0.0)

    // 5. Corrected Calcium for Hypoalbuminemia: Ca + 0.8 * (4.0 - Albumin)
    val correctedCalcium = measuredCa + (0.8 * (4.0 - albumin))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Sub-category selector chips
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                ElectrolyteSubCategory.values().forEach { sub ->
                    val isSel = selectedSub == sub
                    FilterChip(
                        selected = isSel,
                        onClick = { onSubChange(sub) },
                        label = {
                            Text(
                                text = sub.label,
                                fontSize = 11.sp,
                                fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF0284C7),
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }
        }

        when (selectedSub) {
            ElectrolyteSubCategory.SODIUM_HYPO -> {
                // HYPONATREMIA & SODIUM DEFICIT
                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF0F172A),
                        border = BorderStroke(1.dp, Color(0xFF1E293B)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "HYPONATREMIA SOLVER & 3% SALINE DOSING",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF38BDF8)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                AbgInputField(
                                    label = "Measured Na+",
                                    value = measuredNaInput,
                                    onValueChange = onMeasuredNaChange,
                                    unit = "mEq/L",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_measured_na"
                                )
                                AbgInputField(
                                    label = "Target Na+ (24h)",
                                    value = targetNaInput,
                                    onValueChange = onTargetNaChange,
                                    unit = "Max +8–10",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_target_na"
                                )
                                AbgInputField(
                                    label = "Blood Glucose",
                                    value = bloodGlucoseInput,
                                    onValueChange = onBloodGlucoseChange,
                                    unit = "mg/dL",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_glucose"
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AbgInputField(
                                    label = "Patient Weight",
                                    value = weightKgInput,
                                    onValueChange = onWeightChange,
                                    unit = "kg",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_elect_weight"
                                )

                                // Gender and Elderly toggles
                                Column(modifier = Modifier.weight(2f)) {
                                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                        FilterChip(
                                            selected = isFemaleGender,
                                            onClick = { onGenderChange(!isFemaleGender) },
                                            label = { Text(if (isFemaleGender) "Female (TBW 0.5)" else "Male (TBW 0.6)", fontSize = 10.sp) },
                                            modifier = Modifier.weight(1f)
                                        )
                                        FilterChip(
                                            selected = isElderlyPatient,
                                            onClick = { onElderlyChange(!isElderlyPatient) },
                                            label = { Text(if (isElderlyPatient) "Elderly (≥65y)" else "Adult (<65y)", fontSize = 10.sp) },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Results Card
                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF042F2E),
                        border = BorderStroke(1.2.dp, Color(0xFF0D9488)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "SODIUM DEFICIT & CORRECTION PLAN",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2DD4BF)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Calculated Total Body Water (TBW):", fontSize = 11.sp, color = Slate400)
                                Text("${String.format(Locale.US, "%.1f", totalBodyWaterLiters)} Liters", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }

                            if (glucose > 140.0) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Corrected Na+ for Hyperglycemia:", fontSize = 11.sp, color = Slate400)
                                    Text("${String.format(Locale.US, "%.1f", correctedNaKatz)} mEq/L (Katz)", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Total Sodium Deficit to Target:", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                                Text("${String.format(Locale.US, "%.0f", naDeficit)} mEq", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF34D399))
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("1L of 3% Saline changes Na by:", fontSize = 11.sp, color = Slate400)
                                Text("+${String.format(Locale.US, "%.1f", deltaNaPerLiter3Percent)} mEq/L", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("3% NaCl volume to raise Na by 1 mEq/L:", fontSize = 11.sp, color = Slate400)
                                Text("${String.format(Locale.US, "%.0f", mlOf3PercentFor1MeqChange)} mL", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                            }

                            HorizontalDivider(color = Color.White.copy(alpha = 0.15f))

                            // Strict Clinical Warning
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFF450A0A),
                                border = BorderStroke(1.dp, Color(0xFFEF4444)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(10.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(Icons.Default.Warning, contentDescription = null, tint = Color(0xFFF87171), modifier = Modifier.size(16.dp))
                                        Text(
                                            text = "OSMOTIC DEMYELINATION SYNDROME (CPM) SAFE LIMIT",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color(0xFFF87171)
                                        )
                                    }
                                    Text(
                                        text = "• Maximum safe correction: DO NOT exceed 8 to 10 mEq/L in 24 hours (or 18 mEq/L in 48 hours). Overly rapid correction causes irreversible Central Pontine Myelinolysis (spastic quadriparesis, pseudobulbar palsy).",
                                        fontSize = 10.sp,
                                        color = Color(0xFFFEE2E2)
                                    )
                                    Text(
                                        text = "• EMERGENCY PROTOCOL for active seizures or herniation: Give 100 mL or 150 mL of 3% Hypertonic Saline IV push over 10 minutes. Repeat up to twice if seizures persist until serum Na increases by 4–6 mEq/L.",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFFFEF08A)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            ElectrolyteSubCategory.SODIUM_HYPER -> {
                // HYPERNATREMIA & FREE WATER DEFICIT
                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF0F172A),
                        border = BorderStroke(1.dp, Color(0xFF1E293B)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "HYPERNATREMIA & FREE WATER DEFICIT (FWD)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFF59E0B)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                AbgInputField(
                                    label = "Measured Na+",
                                    value = measuredNaInput,
                                    onValueChange = onMeasuredNaChange,
                                    unit = "mEq/L (>145)",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_hyper_na"
                                )
                                AbgInputField(
                                    label = "Patient Weight",
                                    value = weightKgInput,
                                    onValueChange = onWeightChange,
                                    unit = "kg",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_hyper_wt"
                                )
                            }
                        }
                    }
                }

                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF2E1065),
                        border = BorderStroke(1.2.dp, Color(0xFF7C3AED)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "FREE WATER DEFICIT CALCULATION",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFA78BFA)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Free Water Deficit (FWD):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("${String.format(Locale.US, "%.1f", freeWaterDeficit)} Liters", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF38BDF8))
                            }

                            Text(
                                text = "Formula: TBW × ([Measured Na / 140] - 1)",
                                fontSize = 10.sp,
                                color = Slate400
                            )

                            HorizontalDivider(color = Color.White.copy(alpha = 0.15f))

                            Text(
                                text = "REPLACEMENT STRATEGY & SAFETY CEILING:",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFEF08A)
                            )
                            Text(
                                text = "• Preferred fluid: Enteral free water via NG tube or IV 5% Dextrose (D5W) / 0.45% Saline.\n• Safe lowering limit: Do NOT decrease serum Na by more than 10 to 12 mEq/L per 24 hours to prevent rapid cellular swelling and cerebral edema.\n• Target rate: Correct half the deficit over the first 24 hours, and the remainder over next 24–48 hours.",
                                fontSize = 10.5.sp,
                                color = Color(0xFFE9D5FF)
                            )
                        }
                    }
                }
            }

            ElectrolyteSubCategory.POTASSIUM -> {
                // POTASSIUM PROTOCOLS
                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF0F172A),
                        border = BorderStroke(1.dp, Color(0xFF1E293B)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "SERUM POTASSIUM (K+) EVALUATOR",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFF87171)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                AbgInputField(
                                    label = "Measured K+",
                                    value = measuredKInput,
                                    onValueChange = onMeasuredKChange,
                                    unit = "mEq/L (3.5–5.0)",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_k"
                                )
                                AbgInputField(
                                    label = "Serum Magnesium",
                                    value = measuredMgInput,
                                    onValueChange = onMeasuredMgChange,
                                    unit = "mg/dL (1.7–2.2)",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_mg"
                                )
                            }
                        }
                    }
                }

                // Hyperkalemia Emergency Cocktail Protocol Card
                item {
                    val isHyperK = measuredK >= 5.5
                    val statusHeader = if (isHyperK) "HYPERKALEMIA EMERGENCY PROTOCOL (K+ ≥ 5.5 mEq/L)" else "HYPOKALEMIA CORRECTION & DEFICIT (K+ < 3.5 mEq/L)"

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isHyperK) Color(0xFF450A0A) else Color(0xFF064E3B),
                        border = BorderStroke(1.2.dp, if (isHyperK) Color(0xFFEF4444) else Color(0xFF10B981)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = statusHeader,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isHyperK) Color(0xFFF87171) else Color(0xFF34D399)
                            )

                            if (isHyperK) {
                                Text(
                                    text = "3-PHASE HYPERKALEMIA COCKTAIL:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFEF08A)
                                )

                                Text(
                                    text = "1. MEMBRANE STABILIZATION (Immediate - within 2 min):\n• 10% Calcium Gluconate 10–20 mL IV over 2–5 minutes. (Or Calcium Chloride 10 mL via central line). Repeat in 5–10 min if ECG changes persist.",
                                    fontSize = 10.5.sp,
                                    color = Color.White
                                )

                                Text(
                                    text = "2. INTRACELLULAR POTASSIUM SHIFTERS:\n• Regular Insulin 10 Units IV + 50 mL of 50% Dextrose (D50) over 15 min. (Lowers K+ by ~0.5–1.0 mEq/L for 4–6 hrs).\n• Nebulized Salbutamol / Albuterol 10–20 mg in 4 mL normal saline over 15 min.\n• IV Sodium Bicarbonate 50 mEq IV over 5 min if concurrent metabolic acidosis.",
                                    fontSize = 10.5.sp,
                                    color = Color(0xFFFED7AA)
                                )

                                Text(
                                    text = "3. ELIMINATION FROM THE BODY:\n• Furosemide 40–80 mg IV if renal perfusion preserved.\n• Sodium Polystyrene Sulfonate (Kayexalate) 15–30 g or Patiromer (Veltassa) 8.4 g.\n• Emergency Hemodialysis if refractory, anuric, or severe tissue necrosis.",
                                    fontSize = 10.5.sp,
                                    color = Color(0xFFBBF7D0)
                                )
                            } else {
                                Text(
                                    text = "HYPOKALEMIA REPLACEMENT RULES:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF6EE7B7)
                                )
                                Text(
                                    text = "• Estimated deficit: Every 0.3 mEq/L drop below 4.0 mEq/L represents approximately 100 mEq total body potassium deficit.\n• Peripheral IV rule: Maximum concentration 40 mEq/L; maximum infusion rate 10–20 mEq/hr to prevent severe burning phlebitis.\n• Central line: Up to 40 mEq/hr ONLY under continuous cardiac telemetry in ICU.\n• MAGNESIUM CHECK: Always co-administer Magnesium Sulfate if Mg < 2.0 mg/dL. Hypomagnesemia inhibits renal ROMK channels, causing irreversible refractory urinary potassium wasting!",
                                    fontSize = 10.5.sp,
                                    color = Color(0xFFD1FAE5)
                                )
                            }
                        }
                    }
                }
            }

            ElectrolyteSubCategory.CALCIUM_MAG -> {
                // CALCIUM & MAGNESIUM
                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF0F172A),
                        border = BorderStroke(1.dp, Color(0xFF1E293B)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "CALCIUM & MAGNESIUM SOLVER",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFA78BFA)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                AbgInputField(
                                    label = "Total Calcium",
                                    value = measuredCaInput,
                                    onValueChange = onMeasuredCaChange,
                                    unit = "mg/dL (8.5–10.5)",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_ca"
                                )
                                AbgInputField(
                                    label = "Serum Albumin",
                                    value = albuminInput,
                                    onValueChange = onAlbuminChange,
                                    unit = "g/dL",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_ca_alb"
                                )
                                AbgInputField(
                                    label = "Serum Magnesium",
                                    value = measuredMgInput,
                                    onValueChange = onMeasuredMgChange,
                                    unit = "mg/dL (1.7–2.2)",
                                    modifier = Modifier.weight(1f),
                                    testTag = "input_ca_mg"
                                )
                            }
                        }
                    }
                }

                item {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF1E1B4B),
                        border = BorderStroke(1.2.dp, Color(0xFF6366F1)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "CALCIUM CORRECTION FOR HYPOALBUMINEMIA",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFA5B4FC)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Corrected Calcium:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("${String.format(Locale.US, "%.1f", correctedCalcium)} mg/dL", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF38BDF8))
                            }

                            Text(
                                text = "Formula: Measured Calcium + 0.8 × (4.0 - Albumin)",
                                fontSize = 10.sp,
                                color = Slate400
                            )

                            HorizontalDivider(color = Color.White.copy(alpha = 0.15f))

                            Text(
                                text = "EMERGENCY REPLACEMENT REGIMENS:",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFEF08A)
                            )
                            Text(
                                text = "• Symptomatic Hypocalcemia (Tetany, Chvostek / Trousseau signs, prolonged QTc): Give 1 to 2 ampoules of 10% Calcium Gluconate (1–2 g) in 50 mL D5W IV over 10–20 minutes with continuous ECG monitoring.\n• Severe Hypomagnesemia (Mg < 1.0 mg/dL or Torsades de Pointes): Give Magnesium Sulfate 2 g IV in 50 mL D5W over 15 minutes, followed by 4–8 g over the next 24 hours.",
                                fontSize = 10.5.sp,
                                color = Color(0xFFE0E7FF)
                            )
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// TAB 3: ICU CLINICAL SCENARIOS & PRESETS
// -------------------------------------------------------------
data class AbgPresetScenario(
    val title: String,
    val subtitle: String,
    val badge: String,
    val badgeColor: Color,
    val ph: String,
    val paco2: String,
    val hco3: String,
    val na: String,
    val cl: String,
    val albumin: String,
    val pao2: String,
    val fio2: String,
    val weight: String,
    val targetNa: String = "128",
    val bloodGlucose: String = "100",
    val potassium: String = "4.0",
    val clinicalTakeaway: String
)

@Composable
private fun PresetScenariosTabContent(
    onApplyPreset: (AbgPresetScenario) -> Unit,
    onApplyElectrolytePreset: (String, String, String, String) -> Unit
) {
    val presets = remember {
        listOf(
            AbgPresetScenario(
                title = "Diabetic Ketoacidosis (DKA)",
                subtitle = "Profound High Anion Gap Metabolic Acidosis with Kussmaul Breathing",
                badge = "DKA HAGMA",
                badgeColor = Color(0xFFEF4444),
                ph = "7.15",
                paco2 = "18",
                hco3 = "6",
                na = "132",
                cl = "96",
                albumin = "4.0",
                pao2 = "95",
                fio2 = "21",
                weight = "60",
                targetNa = "135",
                bloodGlucose = "450",
                potassium = "5.8",
                clinicalTakeaway = "Anion gap is elevated due to acetoacetate & beta-hydroxybutyrate. Winter's shows appropriate respiratory compensation. Do not give NaHCO3 unless pH < 6.90. Start IV regular insulin and aggressive NS/potassium hydration."
            ),
            AbgPresetScenario(
                title = "Acute-on-Chronic COPD Exacerbation",
                subtitle = "Severe Respiratory Acidosis with Renal Bicarbonate Retention",
                badge = "COPD RESP ACID",
                badgeColor = Color(0xFFF59E0B),
                ph = "7.26",
                paco2 = "68",
                hco3 = "31",
                na = "138",
                cl = "98",
                albumin = "3.8",
                pao2 = "55",
                fio2 = "28",
                weight = "65",
                potassium = "4.2",
                clinicalTakeaway = "High PaCO2 with compensatory metabolic alkalosis. Patient has acute respiratory decompensation on chronic CO2 retention. Target SpO2 88–92% to avoid blunting hypoxic respiratory drive. Consider NIV / BiPAP."
            ),
            AbgPresetScenario(
                title = "Severe Cholera / Diarrhea",
                subtitle = "Normal Anion Gap Metabolic Acidosis (NAGMA / Hyperchloremic)",
                badge = "NAGMA",
                badgeColor = Color(0xFF10B981),
                ph = "7.22",
                paco2 = "25",
                hco3 = "10",
                na = "136",
                cl = "116",
                albumin = "4.0",
                pao2 = "90",
                fio2 = "21",
                weight = "55",
                potassium = "3.1",
                clinicalTakeaway = "GI loss of HCO3- with chloride retention causes normal anion gap (< 12 mEq/L) acidosis. Resuscitate with Ringer's Lactate (contains lactate precursor) or WHO ORS."
            ),
            AbgPresetScenario(
                title = "Salicylate / Aspirin Toxicity",
                subtitle = "Mixed Respiratory Alkalosis & High Anion Gap Metabolic Acidosis",
                badge = "MIXED TOXICITY",
                badgeColor = Color(0xFFA855F7),
                ph = "7.48",
                paco2 = "18",
                hco3 = "13",
                na = "140",
                cl = "102",
                albumin = "4.0",
                pao2 = "98",
                fio2 = "21",
                weight = "60",
                potassium = "3.6",
                clinicalTakeaway = "Salicylates directly stimulate the medullary respiratory center (hyperventilation/respiratory alkalosis) and uncouple oxidative phosphorylation (lactic and keto acidosis). Urinary alkalinization with IV NaHCO3 is therapeutic."
            ),
            AbgPresetScenario(
                title = "Severe Vomiting / Pyloric Stenosis",
                subtitle = "Hypochloremic Hypokalemic Metabolic Alkalosis",
                badge = "MET ALKALOSIS",
                badgeColor = Color(0xFF06B6D4),
                ph = "7.55",
                paco2 = "48",
                hco3 = "40",
                na = "134",
                cl = "84",
                albumin = "4.0",
                pao2 = "88",
                fio2 = "21",
                weight = "60",
                potassium = "2.8",
                clinicalTakeaway = "Loss of gastric HCl causes severe metabolic alkalosis. Compensatory hypoventilation elevates PaCO2. Treatment requires IV Normal Saline and Potassium Chloride (chloride-responsive alkalosis)."
            ),
            AbgPresetScenario(
                title = "Severe ARDS in Septic Shock",
                subtitle = "Severe Hypoxemic Respiratory Failure with Low P/F Ratio (< 100)",
                badge = "SEVERE ARDS",
                badgeColor = Color(0xFFDC2626),
                ph = "7.20",
                paco2 = "55",
                hco3 = "21",
                na = "138",
                cl = "102",
                albumin = "2.8",
                pao2 = "58",
                fio2 = "80",
                weight = "70",
                potassium = "4.8",
                clinicalTakeaway = "P/F ratio is 72.5 mmHg (< 100), fulfilling Berlin Severe ARDS criteria. Elevated A-a gradient. Requires lung-protective ventilation (6 mL/kg PBW), high PEEP, prone positioning, and neuromuscular blockade if dyssynchronous."
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFF1E293B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.MedicalServices,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(22.dp)
                    )
                    Column {
                        Text(
                            text = "ICU CASE SIMULATIONS & PRESETS",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Tap any clinical scenario below to instantly populate ABG and electrolyte parameters.",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                }
            }
        }

        items(presets) { preset ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, preset.badgeColor.copy(alpha = 0.4f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onApplyPreset(preset) }
                    .testTag("preset_${preset.badge.lowercase().replace(" ", "_")}")
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = preset.title,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = preset.badgeColor.copy(alpha = 0.2f),
                            border = BorderStroke(0.6.dp, preset.badgeColor)
                        ) {
                            Text(
                                text = preset.badge,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = preset.badgeColor,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Text(
                        text = preset.subtitle,
                        fontSize = 11.sp,
                        color = Color(0xFF94A3B8)
                    )

                    // Key ABG snapshot chips
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        QuickMetricChip("pH", preset.ph)
                        QuickMetricChip("PaCO2", "${preset.paco2} mmHg")
                        QuickMetricChip("HCO3", "${preset.hco3} mEq")
                        QuickMetricChip("Na+", preset.na)
                        QuickMetricChip("Cl-", preset.cl)
                        QuickMetricChip("PaO2", preset.pao2)
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF1E293B).copy(alpha = 0.6f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "💡 Clinical Action: ${preset.clinicalTakeaway}",
                            fontSize = 10.5.sp,
                            color = Color(0xFFE2E8F0),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// REUSABLE ATOMIC COMPONENTS
// -------------------------------------------------------------
@Composable
private fun QuickMetricChip(label: String, value: String) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(0.6.dp, Color(0xFF334155))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, fontSize = 9.5.sp, color = Slate400)
            Text(value, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Composable
private fun AbgInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier,
    testTag: String = ""
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Slate400,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF1E293B),
                unfocusedContainerColor = Color(0xFF0F172A),
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = Color(0xFF334155)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
                .testTag(testTag)
        )
        Text(
            text = unit,
            fontSize = 9.sp,
            color = Color(0xFF64748B),
            maxLines = 1
        )
    }
}

@Composable
private fun ClinicalAnalysisCard(
    stepNumber: String,
    title: String,
    statusText: String,
    details: List<Pair<String, String>>,
    color: Color
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.dp, color.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = color.copy(alpha = 0.2f),
                        modifier = Modifier.size(20.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = stepNumber,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = color
                            )
                        }
                    }
                    Text(
                        text = title,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = color.copy(alpha = 0.2f),
                    border = BorderStroke(0.6.dp, color)
                ) {
                    Text(
                        text = statusText,
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = color,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            HorizontalDivider(color = Color.White.copy(alpha = 0.08f))

            details.forEach { (label, value) ->
                Column(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Text(
                        text = label,
                        fontSize = 10.sp,
                        color = Slate400
                    )
                    Text(
                        text = value,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFF1F5F9)
                    )
                }
            }
        }
    }
}
