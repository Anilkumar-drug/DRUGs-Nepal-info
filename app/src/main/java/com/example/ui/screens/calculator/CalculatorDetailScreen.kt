package com.example.ui.screens.calculator

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.calculator.ClinicalCalculatorRegistry
import com.example.data.calculator.ClinicalCalculators
import com.example.data.calculator.ExtendedCalculators
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel

@Composable
fun CalculatorDetailScreen(
    calcId: String,
    state: ClinicalUiState,
    viewModel: ClinicalViewModel,
    onBack: () -> Unit
) {
    BackHandler(enabled = true) {
        onBack()
    }

    val calcMeta = remember(calcId) {
        ClinicalCalculatorRegistry.allCalculators.find { it.id == calcId }
    }

    val title = calcMeta?.title ?: "Clinical Calculator"
    val category = calcMeta?.category ?: "Clinical Suite"
    val formulaDesc = calcMeta?.formulaSummary ?: "Evidence-based clinical formula."
    val clinicalDesc = calcMeta?.description ?: ""

    val isBookmarked = state.bookmarkedCalculatorIds.contains(calcId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top Bar
        Surface(
            color = Color(0xFF00897B),
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("calc_detail_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = category,
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }
                }

                IconButton(
                    onClick = { viewModel.toggleBookmarkCalculator(calcId) },
                    modifier = Modifier.testTag("calc_detail_star_button")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Star else Icons.Default.StarBorder,
                        contentDescription = "Favorite",
                        tint = if (isBookmarked) Color(0xFFF59E0B) else Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        // Calculator Body
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Formula Summary Card
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color(0xFF00897B),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "CLINICAL PURPOSE & FORMULA",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00897B),
                            letterSpacing = 0.5.sp
                        )
                    }
                    if (clinicalDesc.isNotBlank()) {
                        Text(
                            text = clinicalDesc,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Text(
                        text = formulaDesc,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Interactive Calculator Form based on calcId
            when (calcId) {
                "egfr" -> EgfrInteractiveCard(state, viewModel)
                "ckd_epi" -> CkdEpiInteractiveCard()
                "fena" -> FenaInteractiveCard()
                "free_water_deficit" -> FreeWaterInteractiveCard()
                "maintenance_fluids" -> MaintenanceFluidsInteractiveCard()
                "sodium_correction" -> SodiumCorrectionInteractiveCard()
                "ca_correction" -> CalciumCorrectionInteractiveCard()
                "child_pugh" -> ChildPughInteractiveCard(state, viewModel)
                "meld_na", "meld_score" -> MeldNaInteractiveCard()
                "fib4" -> Fib4InteractiveCard()
                "apri" -> ApriInteractiveCard()
                "r_factor" -> RFactorInteractiveCard()
                "maddrey" -> MaddreyInteractiveCard()
                "ranson" -> RansonInteractiveCard()
                "bisap" -> BisapInteractiveCard()
                "rockall_complete", "rockall_pre" -> RockallInteractiveCard(isComplete = calcId == "rockall_complete")
                "oakland" -> OaklandInteractiveCard()
                "bristol_stool" -> BristolStoolInteractiveCard()
                "ganzoni" -> GanzoniInteractiveCard()
                "mentzer" -> MentzerInteractiveCard()
                "cha2ds2" -> Cha2ds2InteractiveCard(state, viewModel)
                "has_bled" -> HasBledInteractiveCard()
                "heart_score" -> HeartInteractiveCard()
                "map_calc" -> MapInteractiveCard()
                "bsa" -> BsaInteractiveCard(state, viewModel)
                "qtc_calc" -> QtcInteractiveCard()
                "curb65" -> Curb65InteractiveCard(state, viewModel)
                "wells_dvt" -> WellsDvtInteractiveCard()
                "wells_pe" -> WellsPeInteractiveCard()
                "news_score" -> NewsInteractiveCard()
                "gcs" -> GcsInteractiveCard(state, viewModel)
                "stop_bang" -> StopBangInteractiveCard()
                "centor_score" -> CentorInteractiveCard()
                "steroid_conversion" -> SteroidInteractiveCard()
                "phq9" -> Phq9InteractiveCard()
                "rumack" -> RumackInteractiveCard(state, viewModel)
                "pediatric" -> PediatricInteractiveCard(state, viewModel)
                "iv_infusion" -> IvInfusionInteractiveCard()
                "snakebite" -> SnakebiteInteractiveCard()
                "rabies_pep" -> RabiesInteractiveCard()
                // --- Medical Scoring Engine: Hepatology & GI ---
                "lille_model" -> LilleInteractiveCard()
                "abic_score" -> AbicInteractiveCard()
                "gahs_score" -> GahsInteractiveCard()
                "leipzig_score" -> LeipzigInteractiveCard()
                "dhawan_score" -> DhawanInteractiveCard()
                "hemochromatosis_eval" -> HemochromatosisInteractiveCard()
                "hbi_crohn" -> HbiInteractiveCard()
                "partial_mayo", "mayo_dai" -> PartialMayoInteractiveCard()
                "nfs_mash" -> NfsMashInteractiveCard()
                "nacseld_aclf" -> NacseldAclfInteractiveCard()
                "kings_college_alf" -> KingsCollegeInteractiveCard()
                "modified_atlanta" -> ModifiedAtlantaInteractiveCard()
                "tokyo_tg18" -> TokyoTg18InteractiveCard()
                "glasgow_blatchford" -> GlasgowBlatchfordInteractiveCard()
                "aims65" -> Aims65InteractiveCard()
                "qsofa_score" -> QsofaInteractiveCard()
                "meld_3" -> Meld3InteractiveCard()
                "cdai_score" -> CdaiInteractiveCard()
                "ses_cd" -> SesCdInteractiveCard()
                "uceis_score" -> UceisInteractiveCard()
                "nas_score" -> NasScoreInteractiveCard()
                "fast_score" -> FastScoreInteractiveCard()
                "clif_sofa" -> ClifSofaInteractiveCard()
                "alfsg_clichy" -> AlfsgClichyInteractiveCard()
                "apache_ii" -> ApacheIIInteractiveCard()
                "ctsi_balthazar" -> CtsiInteractiveCard()
                "forrest_classification" -> ForrestInteractiveCard()
                "timi_score" -> TimiInteractiveCard()
                "grace_score" -> GraceInteractiveCard()
                "psi_port" -> PsiPortInteractiveCard()
                "perc_rule" -> PercRuleInteractiveCard()
                "kdigo_aki" -> KdigoAkiInteractiveCard()
                else -> GenericScoreInteractiveCard(title, category, formulaDesc)
            }
        }
    }
}

// -------------------------------------------------------------
// Interactive Calculator Components
// -------------------------------------------------------------

@Composable
fun EgfrInteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var age by remember { mutableStateOf("60") }
    var weight by remember { mutableStateOf("70") }
    var cr by remember { mutableStateOf("1.0") }
    var isFemale by remember { mutableStateOf(false) }

    val ageVal = age.toIntOrNull() ?: 60
    val weightVal = weight.toDoubleOrNull() ?: 70.0
    val crVal = cr.toDoubleOrNull() ?: 1.0
    val res = remember(ageVal, weightVal, crVal, isFemale) {
        ClinicalCalculators.calculateEgfr(ageVal, weightVal, crVal, isFemale)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (years)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = cr,
                onValueChange = { cr = it },
                label = { Text("Serum Creatinine (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                FilterChip(
                    selected = !isFemale,
                    onClick = { isFemale = false },
                    label = { Text("Male") }
                )
                FilterChip(
                    selected = isFemale,
                    onClick = { isFemale = true },
                    label = { Text("Female") }
                )
            }
        }

        ResultBanner(
            title = "Creatinine Clearance (CrCl)",
            valueText = "${"%.1f".format(res.crcl)} mL/min",
            badgeText = res.stage,
            guidance = res.clinicalImplication,
            isSafe = res.crcl >= 60.0
        )
    }
}

@Composable
fun CkdEpiInteractiveCard() {
    var age by remember { mutableStateOf("60") }
    var cr by remember { mutableStateOf("1.1") }
    var isFemale by remember { mutableStateOf(false) }

    val ageVal = age.toIntOrNull() ?: 60
    val crVal = cr.toDoubleOrNull() ?: 1.1
    val res = remember(ageVal, crVal, isFemale) {
        ExtendedCalculators.calculateCkdEpi(ageVal, crVal, isFemale)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (years)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = cr,
                onValueChange = { cr = it },
                label = { Text("Creatinine (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = !isFemale, onClick = { isFemale = false }, label = { Text("Male") })
            FilterChip(selected = isFemale, onClick = { isFemale = true }, label = { Text("Female") })
        }
        ResultBanner(
            title = "2021 CKD-EPI eGFR",
            valueText = "${res.egfr} mL/min/1.73m²",
            badgeText = res.stage,
            guidance = res.interpretation,
            isSafe = res.egfr >= 60.0
        )
    }
}

@Composable
fun FenaInteractiveCard() {
    var uNa by remember { mutableStateOf("15") }
    var sNa by remember { mutableStateOf("140") }
    var uCr by remember { mutableStateOf("80") }
    var sCr by remember { mutableStateOf("2.0") }

    val res = remember(uNa, sNa, uCr, sCr) {
        ExtendedCalculators.calculateFena(
            uNa.toDoubleOrNull() ?: 15.0,
            sNa.toDoubleOrNull() ?: 140.0,
            uCr.toDoubleOrNull() ?: 80.0,
            sCr.toDoubleOrNull() ?: 2.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = uNa, onValueChange = { uNa = it }, label = { Text("Urine Na (mEq/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = sNa, onValueChange = { sNa = it }, label = { Text("Serum Na (mEq/L)") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = uCr, onValueChange = { uCr = it }, label = { Text("Urine Cr (mg/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = sCr, onValueChange = { sCr = it }, label = { Text("Serum Cr (mg/dL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Fractional Excretion of Sodium (FENa)",
            valueText = "${res.fenaPercent}%",
            badgeText = res.etiology,
            guidance = res.clinicalAction,
            isSafe = res.fenaPercent < 1.0
        )
    }
}

@Composable
fun FreeWaterInteractiveCard() {
    var sNa by remember { mutableStateOf("155") }
    var weight by remember { mutableStateOf("70") }
    var isFemale by remember { mutableStateOf(false) }
    var isElderly by remember { mutableStateOf(false) }

    val res = remember(sNa, weight, isFemale, isElderly) {
        ExtendedCalculators.calculateFreeWaterDeficit(
            sNa.toDoubleOrNull() ?: 155.0,
            weight.toDoubleOrNull() ?: 70.0,
            isFemale,
            isElderly
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = sNa, onValueChange = { sNa = it }, label = { Text("Serum Na (mEq/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = weight, onValueChange = { weight = it }, label = { Text("Weight (kg)") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = !isFemale, onClick = { isFemale = false }, label = { Text("Male") })
            FilterChip(selected = isFemale, onClick = { isFemale = true }, label = { Text("Female") })
            FilterChip(selected = isElderly, onClick = { isElderly = !isElderly }, label = { Text("Elderly") })
        }
        ResultBanner(
            title = "Free Water Deficit",
            valueText = "${res.deficitLiters} Liters",
            badgeText = "Hypernatremia Rehydration",
            guidance = res.correctionRateGuidance,
            isSafe = res.deficitLiters < 4.0
        )
    }
}

@Composable
fun MaintenanceFluidsInteractiveCard() {
    var weight by remember { mutableStateOf("25") }
    val res = remember(weight) {
        ExtendedCalculators.calculateMaintenanceFluids(weight.toDoubleOrNull() ?: 25.0)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(value = weight, onValueChange = { weight = it }, label = { Text("Weight (kg)") }, modifier = Modifier.fillMaxWidth())
        ResultBanner(
            title = "Maintenance Fluid Rate (4-2-1 Rule)",
            valueText = "${res.hourlyRateMl} mL/hr (${res.dailyRateMl.toInt()} mL/day)",
            badgeText = "Standard Maintenance",
            guidance = res.guidance,
            isSafe = true
        )
    }
}

@Composable
fun SodiumCorrectionInteractiveCard() {
    var mNa by remember { mutableStateOf("128") }
    var glucose by remember { mutableStateOf("450") }

    val res = remember(mNa, glucose) {
        ExtendedCalculators.calculateSodiumCorrection(
            mNa.toDoubleOrNull() ?: 128.0,
            glucose.toDoubleOrNull() ?: 450.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = mNa, onValueChange = { mNa = it }, label = { Text("Measured Na (mEq/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = glucose, onValueChange = { glucose = it }, label = { Text("Blood Glucose (mg/dL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Corrected Sodium in Hyperglycemia",
            valueText = "${res.correctedNa} mEq/L (+${res.diff})",
            badgeText = "Katz Formula",
            guidance = res.guidance,
            isSafe = res.correctedNa in 135.0..145.0
        )
    }
}

@Composable
fun CalciumCorrectionInteractiveCard() {
    var mCa by remember { mutableStateOf("7.8") }
    var alb by remember { mutableStateOf("2.5") }

    val res = remember(mCa, alb) {
        ExtendedCalculators.calculateCalciumCorrection(
            mCa.toDoubleOrNull() ?: 7.8,
            alb.toDoubleOrNull() ?: 2.5
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = mCa, onValueChange = { mCa = it }, label = { Text("Measured Total Ca (mg/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = alb, onValueChange = { alb = it }, label = { Text("Serum Albumin (g/dL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Corrected Calcium",
            valueText = "${res.correctedCa} mg/dL",
            badgeText = res.category,
            guidance = res.guidance,
            isSafe = res.correctedCa in 8.5..10.5
        )
    }
}

@Composable
fun ChildPughInteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var bili by remember { mutableStateOf("1.5") }
    var alb by remember { mutableStateOf("3.2") }
    var inr by remember { mutableStateOf("1.4") }
    var ascites by remember { mutableIntStateOf(1) } // 1, 2, 3
    var enceph by remember { mutableIntStateOf(1) } // 1, 2, 3

    val res = remember(bili, alb, inr, ascites, enceph) {
        ClinicalCalculators.calculateChildPugh(
            bili.toDoubleOrNull() ?: 1.5,
            alb.toDoubleOrNull() ?: 3.2,
            inr.toDoubleOrNull() ?: 1.4,
            ascites,
            enceph
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Bilirubin (mg/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = alb, onValueChange = { alb = it }, label = { Text("Albumin (g/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("INR") }, modifier = Modifier.weight(1f))
        }

        Text("Ascites Severity", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ascites == 1, onClick = { ascites = 1 }, label = { Text("None") })
            FilterChip(selected = ascites == 2, onClick = { ascites = 2 }, label = { Text("Mild / Controlled") })
            FilterChip(selected = ascites == 3, onClick = { ascites = 3 }, label = { Text("Moderate / Severe") })
        }

        Text("Hepatic Encephalopathy", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = enceph == 1, onClick = { enceph = 1 }, label = { Text("None") })
            FilterChip(selected = enceph == 2, onClick = { enceph = 2 }, label = { Text("Grade 1-2") })
            FilterChip(selected = enceph == 3, onClick = { enceph = 3 }, label = { Text("Grade 3-4") })
        }

        ResultBanner(
            title = "Child-Pugh Score & Class",
            valueText = "${res.totalScore} Points • ${res.childClass}",
            badgeText = res.oneYearSurvival,
            guidance = res.drugGuidance,
            isSafe = res.totalScore <= 6
        )
    }
}

@Composable
fun MeldNaInteractiveCard() {
    var bili by remember { mutableStateOf("2.0") }
    var inr by remember { mutableStateOf("1.5") }
    var cr by remember { mutableStateOf("1.2") }
    var na by remember { mutableStateOf("132") }
    var onDialysis by remember { mutableStateOf(false) }

    val res = remember(bili, inr, cr, na, onDialysis) {
        ExtendedCalculators.calculateMeldNa(
            bili.toDoubleOrNull() ?: 2.0,
            inr.toDoubleOrNull() ?: 1.5,
            cr.toDoubleOrNull() ?: 1.2,
            na.toDoubleOrNull() ?: 132.0,
            onDialysis
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Bilirubin (mg/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = inr, onValueChange = { inr = it }, label = { Text("INR") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = cr, onValueChange = { cr = it }, label = { Text("Creatinine (mg/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = na, onValueChange = { na = it }, label = { Text("Sodium (mEq/L)") }, modifier = Modifier.weight(1f))
        }
        FilterChip(selected = onDialysis, onClick = { onDialysis = !onDialysis }, label = { Text("On Hemodialysis (>= 2x in past week)") })

        ResultBanner(
            title = "MELD-Na Score",
            valueText = "${res.score} Points",
            badgeText = res.ninetyDayMortality,
            guidance = res.guidance,
            isSafe = res.score < 15
        )
    }
}

@Composable
fun Fib4InteractiveCard() {
    var age by remember { mutableStateOf("52") }
    var ast by remember { mutableStateOf("65") }
    var alt by remember { mutableStateOf("80") }
    var plt by remember { mutableStateOf("190") }

    val res = remember(age, ast, alt, plt) {
        ExtendedCalculators.calculateFib4(
            age.toIntOrNull() ?: 52,
            ast.toDoubleOrNull() ?: 65.0,
            alt.toDoubleOrNull() ?: 80.0,
            plt.toDoubleOrNull() ?: 190.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (years)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = plt, onValueChange = { plt = it }, label = { Text("Platelets (10^9/L)") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = ast, onValueChange = { ast = it }, label = { Text("AST (U/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = alt, onValueChange = { alt = it }, label = { Text("ALT (U/L)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "FIB-4 Liver Fibrosis Index",
            valueText = "${res.score}",
            badgeText = res.fibrosisStage,
            guidance = res.recommendation,
            isSafe = res.score < 1.30
        )
    }
}

@Composable
fun ApriInteractiveCard() {
    var ast by remember { mutableStateOf("70") }
    var astUln by remember { mutableStateOf("40") }
    var plt by remember { mutableStateOf("160") }

    val res = remember(ast, astUln, plt) {
        ExtendedCalculators.calculateApri(
            ast.toDoubleOrNull() ?: 70.0,
            astUln.toDoubleOrNull() ?: 40.0,
            plt.toDoubleOrNull() ?: 160.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = ast, onValueChange = { ast = it }, label = { Text("AST (U/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = astUln, onValueChange = { astUln = it }, label = { Text("AST ULN (U/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = plt, onValueChange = { plt = it }, label = { Text("Platelets (10^9/L)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "APRI Score",
            valueText = "${res.apriScore}",
            badgeText = if (res.apriScore < 0.5) "Low Cirrhosis Risk" else "Elevated Risk",
            guidance = res.interpretation,
            isSafe = res.apriScore < 0.5
        )
    }
}

@Composable
fun RFactorInteractiveCard() {
    var alt by remember { mutableStateOf("320") }
    var altUln by remember { mutableStateOf("40") }
    var alp by remember { mutableStateOf("150") }
    var alpUln by remember { mutableStateOf("120") }

    val res = remember(alt, altUln, alp, alpUln) {
        ExtendedCalculators.calculateRFactor(
            alt.toDoubleOrNull() ?: 320.0,
            altUln.toDoubleOrNull() ?: 40.0,
            alp.toDoubleOrNull() ?: 150.0,
            alpUln.toDoubleOrNull() ?: 120.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = alt, onValueChange = { alt = it }, label = { Text("ALT (U/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = altUln, onValueChange = { altUln = it }, label = { Text("ALT ULN") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = alp, onValueChange = { alp = it }, label = { Text("ALP (U/L)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = alpUln, onValueChange = { alpUln = it }, label = { Text("ALP ULN") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "R Factor Ratio",
            valueText = "R = ${res.rScore}",
            badgeText = res.pattern,
            guidance = res.typicalOffenders,
            isSafe = true
        )
    }
}

@Composable
fun MaddreyInteractiveCard() {
    var pt by remember { mutableStateOf("24") }
    var ctrlPt by remember { mutableStateOf("12") }
    var bili by remember { mutableStateOf("8.5") }

    val res = remember(pt, ctrlPt, bili) {
        ExtendedCalculators.calculateMaddrey(
            pt.toDoubleOrNull() ?: 24.0,
            ctrlPt.toDoubleOrNull() ?: 12.0,
            bili.toDoubleOrNull() ?: 8.5
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = pt, onValueChange = { pt = it }, label = { Text("Patient PT (sec)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = ctrlPt, onValueChange = { ctrlPt = it }, label = { Text("Control PT (sec)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = bili, onValueChange = { bili = it }, label = { Text("Total Bili (mg/dL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Maddrey's Discriminant Function (DF)",
            valueText = "${res.score}",
            badgeText = if (res.isSevere) "Severe (Steroids Indicated)" else "Non-Severe",
            guidance = res.therapyRecommendation,
            isSafe = !res.isSevere
        )
    }
}

@Composable
fun RansonInteractiveCard() {
    var ageOver55 by remember { mutableStateOf(false) }
    var wbcOver16 by remember { mutableStateOf(false) }
    var glucoseOver200 by remember { mutableStateOf(false) }
    var ldhOver350 by remember { mutableStateOf(false) }
    var astOver250 by remember { mutableStateOf(false) }
    var hctDrop by remember { mutableStateOf(false) }
    var bunRise by remember { mutableStateOf(false) }
    var caLow by remember { mutableStateOf(false) }

    val score = listOf(ageOver55, wbcOver16, glucoseOver200, ldhOver350, astOver250, hctDrop, bunRise, caLow).count { it }
    val mortality = when {
        score in 0..2 -> "< 1% Mortality (Mild pancreatitis)"
        score in 3..4 -> "~15% Mortality (Severe pancreatitis, ICU evaluation)"
        score in 5..6 -> "~40% Mortality (Critical pancreatitis, intensive care)"
        else -> "> 50-100% Mortality (Extreme severity)"
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Admission Criteria", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ageOver55, onClick = { ageOver55 = !ageOver55 }, label = { Text("Age > 55") })
            FilterChip(selected = wbcOver16, onClick = { wbcOver16 = !wbcOver16 }, label = { Text("WBC > 16k") })
            FilterChip(selected = glucoseOver200, onClick = { glucoseOver200 = !glucoseOver200 }, label = { Text("Glu > 200") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ldhOver350, onClick = { ldhOver350 = !ldhOver350 }, label = { Text("LDH > 350") })
            FilterChip(selected = astOver250, onClick = { astOver250 = !astOver250 }, label = { Text("AST > 250") })
        }
        Text("48-Hour Criteria", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = hctDrop, onClick = { hctDrop = !hctDrop }, label = { Text("Hct Drop > 10%") })
            FilterChip(selected = bunRise, onClick = { bunRise = !bunRise }, label = { Text("BUN Rise > 5") })
            FilterChip(selected = caLow, onClick = { caLow = !caLow }, label = { Text("Ca < 8 mg/dL") })
        }
        ResultBanner(
            title = "Ranson's Pancreatitis Criteria",
            valueText = "$score Points",
            badgeText = mortality,
            guidance = if (score < 3) "Supportive IV hydration and pain control on ward." else "Aggressive resuscitation, ICU consultation, enteral nutrition.",
            isSafe = score < 3
        )
    }
}

@Composable
fun BisapInteractiveCard() {
    var bun by remember { mutableStateOf(false) }
    var mental by remember { mutableStateOf(false) }
    var sirs by remember { mutableStateOf(false) }
    var age by remember { mutableStateOf(false) }
    var effusion by remember { mutableStateOf(false) }

    val res = remember(bun, mental, sirs, age, effusion) {
        ExtendedCalculators.calculateBisap(bun, mental, sirs, age, effusion)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        FilterChip(selected = bun, onClick = { bun = !bun }, label = { Text("BUN > 25 mg/dL") })
        FilterChip(selected = mental, onClick = { mental = !mental }, label = { Text("Impaired Mental Status (GCS < 15)") })
        FilterChip(selected = sirs, onClick = { sirs = !sirs }, label = { Text("SIRS Criteria Met (>= 2 criteria)") })
        FilterChip(selected = age, onClick = { age = !age }, label = { Text("Age > 60 years") })
        FilterChip(selected = effusion, onClick = { effusion = !effusion }, label = { Text("Pleural Effusion on X-ray/CT") })

        ResultBanner(
            title = "BISAP Score",
            valueText = "${res.score} / 5 Points",
            badgeText = "${res.mortalityPercent}% Mortality Risk",
            guidance = res.riskStratum,
            isSafe = res.score < 2
        )
    }
}

@Composable
fun RockallInteractiveCard(isComplete: Boolean) {
    var ageGroup by remember { mutableIntStateOf(0) } // 0: <60, 1: 60-79, 2: >=80
    var shock by remember { mutableIntStateOf(0) } // 0: No shock, 1: Tachycardia, 2: Hypotension
    var comorb by remember { mutableIntStateOf(0) } // 0: None, 2: Major, 3: Renal/Liver failure
    var stigmata by remember { mutableIntStateOf(0) } // 0: Clean base, 2: Active bleed / visible vessel

    val score = ageGroup + shock + comorb + (if (isComplete) stigmata else 0)

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Age Group", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ageGroup == 0, onClick = { ageGroup = 0 }, label = { Text("< 60 yr (0)") })
            FilterChip(selected = ageGroup == 1, onClick = { ageGroup = 1 }, label = { Text("60-79 yr (+1)") })
            FilterChip(selected = ageGroup == 2, onClick = { ageGroup = 2 }, label = { Text(">= 80 yr (+2)") })
        }
        Text("Hemodynamic Shock", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = shock == 0, onClick = { shock = 0 }, label = { Text("No shock (0)") })
            FilterChip(selected = shock == 1, onClick = { shock = 1 }, label = { Text("HR>100 (+1)") })
            FilterChip(selected = shock == 2, onClick = { shock = 2 }, label = { Text("SBP<100 (+2)") })
        }
        Text("Comorbidities", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = comorb == 0, onClick = { comorb = 0 }, label = { Text("None (0)") })
            FilterChip(selected = comorb == 2, onClick = { comorb = 2 }, label = { Text("IHD/HF (+2)") })
            FilterChip(selected = comorb == 3, onClick = { comorb = 3 }, label = { Text("Renal/Liver failure (+3)") })
        }
        ResultBanner(
            title = if (isComplete) "Complete Rockall Score" else "Pre-Endoscopy Rockall",
            valueText = "$score Points",
            badgeText = if (score <= 2) "Low Risk (<5% Mortality)" else "High Risk (Rebleed & Mortality >25%)",
            guidance = if (score <= 2) "Low risk: Early discharge post-endoscopy reasonable." else "High risk: Inpatient monitoring, high-dose IV PPI infusion (80mg bolus + 8mg/hr).",
            isSafe = score <= 2
        )
    }
}

@Composable
fun OaklandInteractiveCard() {
    var age by remember { mutableStateOf("65") }
    var isMale by remember { mutableStateOf(false) }
    var hr by remember { mutableStateOf("78") }
    var sbp by remember { mutableStateOf("125") }
    var hb by remember { mutableStateOf("11.5") }

    val ageVal = age.toIntOrNull() ?: 65
    val sbpVal = sbp.toIntOrNull() ?: 125
    val hbVal = hb.toDoubleOrNull() ?: 11.5

    // Oakland approximate: safe discharge threshold <= 8 points
    val score = (if (ageVal > 70) 3 else 1) + (if (isMale) 1 else 0) + (if (sbpVal < 100) 4 else 0) + (if (hbVal < 10) 6 else 1)

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = sbp, onValueChange = { sbp = it }, label = { Text("SBP (mmHg)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = hb, onValueChange = { hb = it }, label = { Text("Hb (g/dL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Oakland Score (Lower GI Bleed)",
            valueText = "$score Points",
            badgeText = if (score <= 8) "Safe Discharge (<= 8)" else "Inpatient Admission Required",
            guidance = if (score <= 8) "95% probability of safe discharge without blood transfusion, surgery, or repeat bleed." else "Admit for colonoscopy, blood grouping, and observation.",
            isSafe = score <= 8
        )
    }
}

@Composable
fun BristolStoolInteractiveCard() {
    var selectedType by remember { mutableIntStateOf(4) }
    val (name, desc, isHealthy) = when (selectedType) {
        1 -> Triple("Type 1: Separate hard lumps (nuts)", "Very hard to pass; severe constipation.", false)
        2 -> Triple("Type 2: Sausage-shaped, lumpy", "Indicates mild constipation.", false)
        3 -> Triple("Type 3: Like sausage with surface cracks", "Normal stool form.", true)
        4 -> Triple("Type 4: Smooth and soft snake", "Ideal normal stool form.", true)
        5 -> Triple("Type 5: Soft blobs with clear-cut edges", "Lacks fiber; passed easily.", false)
        6 -> Triple("Type 6: Fluffy pieces with ragged edges", "Mushy stool; mild diarrhea.", false)
        else -> Triple("Type 7: Entirely liquid, watery", "Severe diarrhea; risk of dehydration.", false)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Select Stool Form Type (1 - 7)", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            (1..7).forEach { num ->
                FilterChip(
                    selected = selectedType == num,
                    onClick = { selectedType = num },
                    label = { Text("Type $num") }
                )
            }
        }
        ResultBanner(
            title = "Bristol Stool Form",
            valueText = name,
            badgeText = if (isHealthy) "Normal Transit" else "Altered Transit",
            guidance = desc,
            isSafe = isHealthy
        )
    }
}

@Composable
fun GanzoniInteractiveCard() {
    var weight by remember { mutableStateOf("60") }
    var targetHb by remember { mutableStateOf("12.0") }
    var actualHb by remember { mutableStateOf("8.0") }

    val res = remember(weight, targetHb, actualHb) {
        ExtendedCalculators.calculateGanzoni(
            weight.toDoubleOrNull() ?: 60.0,
            targetHb.toDoubleOrNull() ?: 12.0,
            actualHb.toDoubleOrNull() ?: 8.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = weight, onValueChange = { weight = it }, label = { Text("Weight (kg)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = targetHb, onValueChange = { targetHb = it }, label = { Text("Target Hb (g/dL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = actualHb, onValueChange = { actualHb = it }, label = { Text("Actual Hb (g/dL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Total Iron Deficit (Ganzoni)",
            valueText = "${res.totalIronDeficitMg} mg",
            badgeText = "~${res.ampoulesIronSucrose} Ampoules (100mg)",
            guidance = res.guidance,
            isSafe = true
        )
    }
}

@Composable
fun MentzerInteractiveCard() {
    var mcv by remember { mutableStateOf("68") }
    var rbc by remember { mutableStateOf("5.8") }

    val res = remember(mcv, rbc) {
        ExtendedCalculators.calculateMentzer(
            mcv.toDoubleOrNull() ?: 68.0,
            rbc.toDoubleOrNull() ?: 5.8
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = mcv, onValueChange = { mcv = it }, label = { Text("MCV (fL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = rbc, onValueChange = { rbc = it }, label = { Text("RBC (million/µL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Mentzer Index (MCV / RBC)",
            valueText = "${res.index}",
            badgeText = if (res.index < 13.0) "Thalassemia Trait Likely" else "Iron Deficiency Likely",
            guidance = res.confirmatoryTest,
            isSafe = true
        )
    }
}

@Composable
fun Cha2ds2InteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var chf by remember { mutableStateOf(false) }
    var htn by remember { mutableStateOf(true) }
    var ageGroup by remember { mutableIntStateOf(1) } // 0: <65, 1: 65-74, 2: >=75
    var dm by remember { mutableStateOf(false) }
    var stroke by remember { mutableStateOf(false) }
    var vasc by remember { mutableStateOf(false) }
    var isFemale by remember { mutableStateOf(false) }

    val res = remember(chf, htn, ageGroup, dm, stroke, vasc, isFemale) {
        ClinicalCalculators.calculateCha2Ds2Vasc(chf, htn, ageGroup, dm, stroke, vasc, isFemale)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = chf, onClick = { chf = !chf }, label = { Text("CHF (+1)") })
            FilterChip(selected = htn, onClick = { htn = !htn }, label = { Text("Hypertension (+1)") })
            FilterChip(selected = dm, onClick = { dm = !dm }, label = { Text("Diabetes (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = stroke, onClick = { stroke = !stroke }, label = { Text("Prior Stroke/TIA (+2)") })
            FilterChip(selected = vasc, onClick = { vasc = !vasc }, label = { Text("Vascular Disease (+1)") })
            FilterChip(selected = isFemale, onClick = { isFemale = !isFemale }, label = { Text("Female (+1)") })
        }
        Text("Age", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ageGroup == 0, onClick = { ageGroup = 0 }, label = { Text("< 65 (0)") })
            FilterChip(selected = ageGroup == 1, onClick = { ageGroup = 1 }, label = { Text("65-74 (+1)") })
            FilterChip(selected = ageGroup == 2, onClick = { ageGroup = 2 }, label = { Text(">= 75 (+2)") })
        }
        ResultBanner(
            title = "CHA₂DS₂-VASc Score",
            valueText = "${res.totalScore} Points • ${res.strokeRiskPercentPerYear}%/yr stroke",
            badgeText = res.riskStratum,
            guidance = res.recommendation,
            isSafe = res.totalScore == 0
        )
    }
}

@Composable
fun HasBledInteractiveCard() {
    var htn by remember { mutableStateOf(true) }
    var renal by remember { mutableStateOf(false) }
    var liver by remember { mutableStateOf(false) }
    var stroke by remember { mutableStateOf(false) }
    var bleed by remember { mutableStateOf(false) }
    var labile by remember { mutableStateOf(false) }
    var elderly by remember { mutableStateOf(true) }
    var drugs by remember { mutableStateOf(false) }
    var alcohol by remember { mutableStateOf(false) }

    val res = remember(htn, renal, liver, stroke, bleed, labile, elderly, drugs, alcohol) {
        ExtendedCalculators.calculateHasBled(htn, renal, liver, stroke, bleed, labile, elderly, drugs, alcohol)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = htn, onClick = { htn = !htn }, label = { Text("Hypertension") })
            FilterChip(selected = renal, onClick = { renal = !renal }, label = { Text("Renal Disease") })
            FilterChip(selected = liver, onClick = { liver = !liver }, label = { Text("Liver Disease") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = stroke, onClick = { stroke = !stroke }, label = { Text("Prior Stroke") })
            FilterChip(selected = bleed, onClick = { bleed = !bleed }, label = { Text("Prior Bleed") })
            FilterChip(selected = labile, onClick = { labile = !labile }, label = { Text("Labile INR") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = elderly, onClick = { elderly = !elderly }, label = { Text("Age > 65") })
            FilterChip(selected = drugs, onClick = { drugs = !drugs }, label = { Text("Antiplatelet/NSAID") })
            FilterChip(selected = alcohol, onClick = { alcohol = !alcohol }, label = { Text("Alcohol excess") })
        }
        ResultBanner(
            title = "HAS-BLED Score",
            valueText = "${res.score} Points",
            badgeText = res.riskCategory,
            guidance = res.recommendation,
            isSafe = res.score < 3
        )
    }
}

@Composable
fun HeartInteractiveCard() {
    var history by remember { mutableIntStateOf(1) } // 0, 1, 2
    var ecg by remember { mutableIntStateOf(1) }
    var age by remember { mutableIntStateOf(1) }
    var risk by remember { mutableIntStateOf(1) }
    var trop by remember { mutableIntStateOf(0) }

    val res = remember(history, ecg, age, risk, trop) {
        ExtendedCalculators.calculateHeart(history, ecg, age, risk, trop)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("History: Highly susp (2) / Mod (1) / Slight (0)", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..2).forEach { num -> FilterChip(selected = history == num, onClick = { history = num }, label = { Text("H: $num") }) }
        }
        Text("ECG: ST-dep (2) / Non-spec (1) / Normal (0)", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..2).forEach { num -> FilterChip(selected = ecg == num, onClick = { ecg = num }, label = { Text("E: $num") }) }
        }
        Text("Age: >=65 (2) / 45-64 (1) / <45 (0)", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..2).forEach { num -> FilterChip(selected = age == num, onClick = { age = num }, label = { Text("A: $num") }) }
        }
        Text("Troponin: >3x (2) / 1-3x (1) / Normal (0)", fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (0..2).forEach { num -> FilterChip(selected = trop == num, onClick = { trop = num }, label = { Text("T: $num") }) }
        }
        ResultBanner(
            title = "HEART Score for Chest Pain",
            valueText = "${res.score} / 10 Points (${res.sixWeekMacePercent}% MACE)",
            badgeText = res.riskStratum,
            guidance = res.management,
            isSafe = res.score <= 3
        )
    }
}

@Composable
fun MapInteractiveCard() {
    var sbp by remember { mutableStateOf("120") }
    var dbp by remember { mutableStateOf("80") }

    val res = remember(sbp, dbp) {
        ExtendedCalculators.calculateMap(
            sbp.toDoubleOrNull() ?: 120.0,
            dbp.toDoubleOrNull() ?: 80.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = sbp, onValueChange = { sbp = it }, label = { Text("Systolic BP (mmHg)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = dbp, onValueChange = { dbp = it }, label = { Text("Diastolic BP (mmHg)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Mean Arterial Pressure (MAP)",
            valueText = "${res.map} mmHg",
            badgeText = if (res.map >= 65.0) "Adequate Perfusion" else "Hypoperfusion / Shock",
            guidance = res.interpretation,
            isSafe = res.map >= 65.0
        )
    }
}

@Composable
fun BsaInteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var ht by remember { mutableStateOf("170") }
    var wt by remember { mutableStateOf("65") }

    val htVal = ht.toDoubleOrNull() ?: 170.0
    val wtVal = wt.toDoubleOrNull() ?: 65.0
    val res = remember(htVal, wtVal) { ClinicalCalculators.calculateBsa(htVal, wtVal) }
    val bmi = remember(htVal, wtVal) {
        if (htVal > 0) wtVal / ((htVal / 100.0) * (htVal / 100.0)) else 0.0
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = ht, onValueChange = { ht = it }, label = { Text("Height (cm)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = wt, onValueChange = { wt = it }, label = { Text("Weight (kg)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Body Surface Area & BMI",
            valueText = "BSA: ${"%.2f".format(res.mostellerBsa)} m² • BMI: ${"%.1f".format(bmi)}",
            badgeText = res.normalComparison,
            guidance = "Used for chemotherapy dosing, aminoglycosides, burn resuscitation fluids, and indexing cardiac output.",
            isSafe = true
        )
    }
}

@Composable
fun QtcInteractiveCard() {
    var qt by remember { mutableStateOf("420") }
    var hr by remember { mutableStateOf("72") }

    val res = remember(qt, hr) {
        ExtendedCalculators.calculateQtc(
            qt.toDoubleOrNull() ?: 420.0,
            hr.toDoubleOrNull() ?: 72.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = qt, onValueChange = { qt = it }, label = { Text("QT Interval (msec)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = hr, onValueChange = { hr = it }, label = { Text("Heart Rate (bpm)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Corrected QT Interval",
            valueText = "Bazett: ${res.bazettMs} ms • Fridericia: ${res.fridericiaMs} ms",
            badgeText = if (res.bazettMs < 450.0) "Normal QTc" else "Prolonged QTc",
            guidance = res.riskWarning,
            isSafe = res.bazettMs < 450.0
        )
    }
}

@Composable
fun Curb65InteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var confusion by remember { mutableStateOf(false) }
    var urea by remember { mutableStateOf(false) }
    var rr by remember { mutableStateOf(false) }
    var bp by remember { mutableStateOf(false) }
    var age65 by remember { mutableStateOf(false) }

    val res = remember(confusion, urea, rr, bp, age65) {
        ClinicalCalculators.calculateCurb65(confusion, urea, rr, bp, age65)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        FilterChip(selected = confusion, onClick = { confusion = !confusion }, label = { Text("Confusion (AMTS <= 8)") })
        FilterChip(selected = urea, onClick = { urea = !urea }, label = { Text("Urea > 7 mmol/L (BUN > 19)") })
        FilterChip(selected = rr, onClick = { rr = !rr }, label = { Text("Respiratory Rate >= 30/min") })
        FilterChip(selected = bp, onClick = { bp = !bp }, label = { Text("BP Low (SBP<90 or DBP<=60)") })
        FilterChip(selected = age65, onClick = { age65 = !age65 }, label = { Text("Age >= 65 years") })

        ResultBanner(
            title = "CURB-65 Pneumonia Severity",
            valueText = "${res.totalScore} Points (${res.mortalityRiskPercent}% mortality)",
            badgeText = res.riskGroup,
            guidance = res.managementGuidance,
            isSafe = res.totalScore <= 1
        )
    }
}

@Composable
fun WellsDvtInteractiveCard() {
    var cancer by remember { mutableStateOf(false) }
    var paralysis by remember { mutableStateOf(false) }
    var bed by remember { mutableStateOf(false) }
    var tender by remember { mutableStateOf(true) }
    var wholeLeg by remember { mutableStateOf(false) }
    var calf by remember { mutableStateOf(true) }
    var edema by remember { mutableStateOf(true) }
    var veins by remember { mutableStateOf(false) }
    var alt by remember { mutableStateOf(false) }

    val res = remember(cancer, paralysis, bed, tender, wholeLeg, calf, edema, veins, alt) {
        ExtendedCalculators.calculateWellsDvt(cancer, paralysis, bed, tender, wholeLeg, calf, edema, veins, alt)
    }

    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = cancer, onClick = { cancer = !cancer }, label = { Text("Active Cancer") })
            FilterChip(selected = paralysis, onClick = { paralysis = !paralysis }, label = { Text("Paralysis/Paresis") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = tender, onClick = { tender = !tender }, label = { Text("Tenderness along deep veins") })
            FilterChip(selected = calf, onClick = { calf = !calf }, label = { Text("Calf swelling >3cm") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = edema, onClick = { edema = !edema }, label = { Text("Pitting edema") })
            FilterChip(selected = alt, onClick = { alt = !alt }, label = { Text("Alt diagnosis as likely (-2)") })
        }
        ResultBanner(
            title = "Wells' Score for DVT",
            valueText = "${res.score} Points",
            badgeText = res.probability,
            guidance = res.clinicalPathway,
            isSafe = res.score <= 0
        )
    }
}

@Composable
fun WellsPeInteractiveCard() {
    var dvtSigns by remember { mutableStateOf(false) }
    var peLikely by remember { mutableStateOf(true) }
    var hr by remember { mutableStateOf(true) }
    var surgery by remember { mutableStateOf(false) }
    var prior by remember { mutableStateOf(false) }
    var hemoptysis by remember { mutableStateOf(false) }
    var cancer by remember { mutableStateOf(false) }

    val res = remember(dvtSigns, peLikely, hr, surgery, prior, hemoptysis, cancer) {
        ExtendedCalculators.calculateWellsPe(dvtSigns, peLikely, hr, surgery, prior, hemoptysis, cancer)
    }

    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = dvtSigns, onClick = { dvtSigns = !dvtSigns }, label = { Text("Clinical DVT signs (+3)") })
            FilterChip(selected = peLikely, onClick = { peLikely = !peLikely }, label = { Text("PE #1 diagnosis (+3)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = hr, onClick = { hr = !hr }, label = { Text("Heart rate > 100 (+1.5)") })
            FilterChip(selected = surgery, onClick = { surgery = !surgery }, label = { Text("Surgery/bed 4w (+1.5)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = hemoptysis, onClick = { hemoptysis = !hemoptysis }, label = { Text("Hemoptysis (+1)") })
            FilterChip(selected = cancer, onClick = { cancer = !cancer }, label = { Text("Malignancy (+1)") })
        }
        ResultBanner(
            title = "Wells' Score for Pulmonary Embolism",
            valueText = "${res.score} Points",
            badgeText = res.probability,
            guidance = res.diagnosticAction,
            isSafe = res.score <= 1.5
        )
    }
}

@Composable
fun NewsInteractiveCard() {
    var rr by remember { mutableStateOf("18") }
    var spo2 by remember { mutableStateOf("96") }
    var onOxygen by remember { mutableStateOf(false) }
    var sbp by remember { mutableStateOf("120") }
    var hr by remember { mutableStateOf("80") }
    var isAlert by remember { mutableStateOf(true) }

    var score = 0
    val rrVal = rr.toIntOrNull() ?: 18
    if (rrVal <= 8 || rrVal >= 25) score += 3 else if (rrVal in 21..24) score += 2 else if (rrVal in 9..11) score += 1

    val spo2Val = spo2.toIntOrNull() ?: 96
    if (spo2Val <= 91) score += 3 else if (spo2Val in 92..93) score += 2 else if (spo2Val in 94..95) score += 1
    if (onOxygen) score += 2
    if (!isAlert) score += 3

    val (stratum, action) = when {
        score == 0 -> "Low Clinical Risk (0 points)" to "Ward-based routine observations every 12 hours."
        score in 1..4 -> "Low Risk (1-4 points)" to "Inform registered nurse. Frequency of monitoring minimum 4-6 hours."
        score in 5..6 -> "Medium Risk (5-6 points or single parameter 3)" to "Urgent review by attending doctor / medical emergency team. Minimum hourly monitoring."
        else -> "High Risk (Score >= 7)" to "CRITICAL EMERGENCY. Emergency assessment by critical care team / ICU transfer readiness."
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = rr, onValueChange = { rr = it }, label = { Text("Resp Rate (/min)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = spo2, onValueChange = { spo2 = it }, label = { Text("SpO2 (%)") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = onOxygen, onClick = { onOxygen = !onOxygen }, label = { Text("Supplemental Oxygen") })
            FilterChip(selected = !isAlert, onClick = { isAlert = !isAlert }, label = { Text("Altered Consciousness") })
        }
        ResultBanner(
            title = "NEWS2 Score",
            valueText = "$score Points",
            badgeText = stratum,
            guidance = action,
            isSafe = score <= 4
        )
    }
}

@Composable
fun GcsInteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var eye by remember { mutableIntStateOf(4) }
    var verbal by remember { mutableIntStateOf(5) }
    var motor by remember { mutableIntStateOf(6) }

    val res = remember(eye, verbal, motor) { ClinicalCalculators.calculateGcs(eye, verbal, motor) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Eye Opening (1 - 4)", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (1..4).forEach { FilterChip(selected = eye == it, onClick = { eye = it }, label = { Text("E$it") }) }
        }
        Text("Verbal Response (1 - 5)", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (1..5).forEach { FilterChip(selected = verbal == it, onClick = { verbal = it }, label = { Text("V$it") }) }
        }
        Text("Motor Response (1 - 6)", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (1..6).forEach { FilterChip(selected = motor == it, onClick = { motor = it }, label = { Text("M$it") }) }
        }
        ResultBanner(
            title = "Glasgow Coma Scale",
            valueText = "E${res.eyeScore} V${res.verbalScore} M${res.motorScore} = ${res.totalScore} / 15",
            badgeText = res.severity,
            guidance = res.clinicalGuidance,
            isSafe = res.totalScore >= 13
        )
    }
}

@Composable
fun StopBangInteractiveCard() {
    var snoring by remember { mutableStateOf(false) }
    var tired by remember { mutableStateOf(false) }
    var observed by remember { mutableStateOf(false) }
    var pressure by remember { mutableStateOf(true) }
    var bmi by remember { mutableStateOf(false) }
    var age by remember { mutableStateOf(true) }
    var neck by remember { mutableStateOf(false) }
    var male by remember { mutableStateOf(true) }

    val res = remember(snoring, tired, observed, pressure, bmi, age, neck, male) {
        ExtendedCalculators.calculateStopBang(snoring, tired, observed, pressure, bmi, age, neck, male)
    }

    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = snoring, onClick = { snoring = !snoring }, label = { Text("Snoring loudly") })
            FilterChip(selected = tired, onClick = { tired = !tired }, label = { Text("Tired/fatigued") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = observed, onClick = { observed = !observed }, label = { Text("Observed stopping breathing") })
            FilterChip(selected = pressure, onClick = { pressure = !pressure }, label = { Text("High Blood Pressure") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = bmi, onClick = { bmi = !bmi }, label = { Text("BMI > 35") })
            FilterChip(selected = age, onClick = { age = !age }, label = { Text("Age > 50") })
            FilterChip(selected = neck, onClick = { neck = !neck }, label = { Text("Neck > 40cm") })
        }
        ResultBanner(
            title = "STOP-BANG Sleep Apnea Score",
            valueText = "${res.score} / 8 Points",
            badgeText = res.riskCategory,
            guidance = res.management,
            isSafe = res.score <= 2
        )
    }
}

@Composable
fun CentorInteractiveCard() {
    var exudate by remember { mutableStateOf(true) }
    var nodes by remember { mutableStateOf(true) }
    var fever by remember { mutableStateOf(true) }
    var noCough by remember { mutableStateOf(true) }
    var ageGroup by remember { mutableIntStateOf(1) } // 0: 3-14, 1: 15-44, 2: >=45

    val res = remember(exudate, nodes, fever, noCough, ageGroup) {
        ExtendedCalculators.calculateCentor(exudate, nodes, fever, noCough, ageGroup)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = exudate, onClick = { exudate = !exudate }, label = { Text("Tonsillar exudate") })
            FilterChip(selected = nodes, onClick = { nodes = !nodes }, label = { Text("Tender cervical nodes") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = fever, onClick = { fever = !fever }, label = { Text("Fever history") })
            FilterChip(selected = noCough, onClick = { noCough = !noCough }, label = { Text("Absence of cough") })
        }
        ResultBanner(
            title = "Centor (McIsaac) Score",
            valueText = "${res.score} Points",
            badgeText = res.probability,
            guidance = res.treatmentGuidance,
            isSafe = res.score < 2
        )
    }
}

@Composable
fun SteroidInteractiveCard() {
    var drug by remember { mutableStateOf("Prednisolone") }
    var dose by remember { mutableStateOf("20") }

    val res = remember(drug, dose) {
        ExtendedCalculators.calculateSteroid(drug, dose.toDoubleOrNull() ?: 20.0)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("Prednisolone", "Dexamethasone", "Hydrocortisone", "Methylprednisolone").forEach { name ->
                FilterChip(selected = drug == name, onClick = { drug = name }, label = { Text(name) })
            }
        }
        OutlinedTextField(value = dose, onValueChange = { dose = it }, label = { Text("Dose (mg)") }, modifier = Modifier.fillMaxWidth())
        ResultBanner(
            title = "Equivalent Corticosteroid Dosing",
            valueText = "${res.doseMg} mg $drug equals:",
            badgeText = "Hydrocortisone: ${res.hydrocortisoneEquiv} mg",
            guidance = "Prednisolone: ${res.prednisoloneEquiv} mg • Dexamethasone: ${res.dexamethasoneEquiv} mg",
            isSafe = true
        )
    }
}

@Composable
fun Phq9InteractiveCard() {
    var score by remember { mutableIntStateOf(8) }
    val res = remember(score) { ExtendedCalculators.calculatePhq9(listOf(score)) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Total PHQ-9 Score (0 - 27): $score", fontWeight = FontWeight.Bold)
        Slider(value = score.toFloat(), onValueChange = { score = it.toInt() }, valueRange = 0f..27f, steps = 26)
        ResultBanner(
            title = "PHQ-9 Depression Severity",
            valueText = "$score / 27 Points",
            badgeText = res.severity,
            guidance = res.treatmentRecommendation,
            isSafe = score < 10
        )
    }
}

@Composable
fun RumackInteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var hours by remember { mutableStateOf("6") }
    var level by remember { mutableStateOf("120") }

    val hVal = hours.toDoubleOrNull() ?: 6.0
    val lVal = level.toDoubleOrNull() ?: 120.0
    val res = remember(hVal, lVal) { ClinicalCalculators.evaluateParacetamolOverdose(hVal, lVal) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = hours, onValueChange = { hours = it }, label = { Text("Hours post-ingestion") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = level, onValueChange = { level = it }, label = { Text("Serum APAP (µg/mL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Rumack-Matthew Nomogram",
            valueText = if (res.isToxicityProbable) "ABOVE LINE (Toxic)" else "BELOW LINE (Safe)",
            badgeText = "Cutoff: ${"%.1f".format(res.treatmentLineCutoff)} µg/mL",
            guidance = res.action,
            isSafe = !res.isToxicityProbable
        )
    }
}

@Composable
fun PediatricInteractiveCard(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var weight by remember { mutableStateOf("12") }
    var dosePerKg by remember { mutableStateOf("15") } // Paracetamol 15mg/kg
    var syrupMg by remember { mutableStateOf("125") }
    var syrupMl by remember { mutableStateOf("5") }

    val wVal = weight.toDoubleOrNull() ?: 12.0
    val dVal = dosePerKg.toDoubleOrNull() ?: 15.0
    val sMg = syrupMg.toDoubleOrNull() ?: 125.0
    val sMl = syrupMl.toDoubleOrNull() ?: 5.0
    val res = remember(wVal, dVal, sMg, sMl) {
        ClinicalCalculators.calculatePediatricLiquidDose(wVal, dVal, sMg, sMl)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = weight, onValueChange = { weight = it }, label = { Text("Weight (kg)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = dosePerKg, onValueChange = { dosePerKg = it }, label = { Text("Dose (mg/kg/dose)") }, modifier = Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = syrupMg, onValueChange = { syrupMg = it }, label = { Text("Syrup Strength (mg)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = syrupMl, onValueChange = { syrupMl = it }, label = { Text("per Volume (mL)") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Single Dose Volume",
            valueText = "${"%.1f".format(res.volumeMl)} mL (${"%.0f".format(res.totalDoseMg)} mg)",
            badgeText = "Pediatric Safe Dosing",
            guidance = "Administer using an oral calibrated measuring syringe. Always verify concentration on bottle label.",
            isSafe = true
        )
    }
}

@Composable
fun IvInfusionInteractiveCard() {
    var drug by remember { mutableStateOf("Noradrenaline") }
    var totalMg by remember { mutableStateOf("4") }
    var bagMl by remember { mutableStateOf("50") }
    var weight by remember { mutableStateOf("60") }
    var rateMcg by remember { mutableStateOf("0.1") } // 0.1 mcg/kg/min

    val res = remember(drug, totalMg, bagMl, weight, rateMcg) {
        ClinicalCalculators.calculateIvInfusion(
            drug,
            totalMg.toDoubleOrNull() ?: 4.0,
            bagMl.toDoubleOrNull() ?: 50.0,
            weight.toDoubleOrNull() ?: 60.0,
            rateMcg.toDoubleOrNull() ?: 0.1
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("Noradrenaline", "Dopamine", "Dobutamine").forEach { name ->
                FilterChip(selected = drug == name, onClick = { drug = name }, label = { Text(name) })
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = totalMg, onValueChange = { totalMg = it }, label = { Text("Drug (mg)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = bagMl, onValueChange = { bagMl = it }, label = { Text("Bag (mL)") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = rateMcg, onValueChange = { rateMcg = it }, label = { Text("Target mcg/kg/min") }, modifier = Modifier.weight(1f))
        }
        ResultBanner(
            title = "Infusion Pump Rate",
            valueText = "${"%.1f".format(res.pumpRateMlPerHour)} mL/hr (${res.microDripRateGttPerMin} gtt/min micro)",
            badgeText = res.diluentCompatibility,
            guidance = res.clinicalCaution,
            isSafe = true
        )
    }
}

@Composable
fun SnakebiteInteractiveCard() {
    var biteType by remember { mutableStateOf("Viper") }
    val res: ClinicalCalculators.SnakebiteAsvResult = remember(biteType) {
        ClinicalCalculators.calculateSnakebiteDosing(biteType)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("Viper", "Krait", "Cobra", "Dry Bite").forEach { name ->
                FilterChip(selected = biteType == name, onClick = { biteType = name }, label = { Text(name) })
            }
        }
        val guidanceText = buildString {
            append(res.diluentGuidance)
            if (!res.neostigmineTestProtocol.isNullOrBlank()) {
                append("\n\n")
                append(res.neostigmineTestProtocol)
            }
            append("\n\n")
            append(res.adrenalinePrecaution)
        }
        ResultBanner(
            title = "Anti-Snake Venom (ASV) Protocol",
            valueText = "${res.initialAsvDoseVials} Vials Polyvalent ASV",
            badgeText = res.envenomationType,
            guidance = guidanceText,
            isSafe = biteType == "Dry Bite"
        )
    }
}

@Composable
fun RabiesInteractiveCard() {
    var weight by remember { mutableStateOf("60") }
    var category by remember { mutableIntStateOf(3) } // 1, 2, 3

    val res = remember(weight, category) {
        ClinicalCalculators.calculateRabiesPep(weight.toDoubleOrNull() ?: 60.0, category)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Wound Category (WHO/EDCD Nepal)", fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = category == 1, onClick = { category = 1 }, label = { Text("Cat I (Touch)") })
            FilterChip(selected = category == 2, onClick = { category = 2 }, label = { Text("Cat II (Scratch)") })
            FilterChip(selected = category == 3, onClick = { category = 3 }, label = { Text("Cat III (Bleed)") })
        }
        OutlinedTextField(value = weight, onValueChange = { weight = it }, label = { Text("Patient Weight (kg)") }, modifier = Modifier.fillMaxWidth())

        ResultBanner(
            title = "Rabies Prophylaxis Regimen",
            valueText = if (res.rigIndication) "Vaccine + ERIG ${res.rigDoseIU.toInt()} IU" else "Vaccine Only",
            badgeText = res.categoryText,
            guidance = "${res.vaccineRegimen}\n\n${res.woundManagementGuidance}",
            isSafe = category == 1
        )
    }
}

@Composable
fun GenericScoreInteractiveCard(title: String, category: String, formula: String) {
    var val1 by remember { mutableStateOf("10") }
    var val2 by remember { mutableStateOf("20") }
    var optionSelected by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(value = val1, onValueChange = { val1 = it }, label = { Text("Parameter 1") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = val2, onValueChange = { val2 = it }, label = { Text("Parameter 2") }, modifier = Modifier.weight(1f))
        }
        FilterChip(
            selected = optionSelected,
            onClick = { optionSelected = !optionSelected },
            label = { Text("Secondary Criterion Present") }
        )
        ResultBanner(
            title = "$title Assessment",
            valueText = "Calculated Clinical Score",
            badgeText = category,
            guidance = "Formula: $formula. Evaluate in conjunction with clinical context and full institutional guidelines.",
            isSafe = true
        )
    }
}

// -------------------------------------------------------------
// Shared Result Banner Component
// -------------------------------------------------------------

@Composable
fun ResultBanner(
    title: String,
    valueText: String,
    badgeText: String,
    guidance: String,
    isSafe: Boolean,
    jsonPayload: String? = null
) {
    val borderColor = if (isSafe) Color(0xFF00897B) else Color(0xFFDC2626)
    val bgColor = if (isSafe) Color(0xFF00897B).copy(alpha = 0.08f) else Color(0xFFDC2626).copy(alpha = 0.08f)
    var showJsonView by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = bgColor,
        border = BorderStroke(1.2.dp, borderColor.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
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
                Text(
                    text = title,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = borderColor,
                    letterSpacing = 0.5.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    if (jsonPayload != null) {
                        Surface(
                            onClick = { showJsonView = !showJsonView },
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                            border = BorderStroke(0.6.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Code,
                                    contentDescription = "API JSON",
                                    modifier = Modifier.size(12.dp),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = if (showJsonView) "Clinical" else "JSON API",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = borderColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = badgeText,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = borderColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Text(
                text = valueText,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.onSurface
            )

            HorizontalDivider(color = borderColor.copy(alpha = 0.2f))

            if (showJsonView && jsonPayload != null) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Medical Scoring Engine API Output",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00897B)
                            )
                            Text(
                                text = "JSON",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = jsonPayload,
                            fontSize = 11.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            } else {
                Text(
                    text = guidance,
                    fontSize = 12.sp,
                    lineHeight = 17.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f)
                )
            }
        }
    }
}
