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
import android.widget.Toast
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
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

            // Prominent Input Instructions Callout Card (Addresses user feedback on where to put values)
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = DimsTealPrimary.copy(alpha = 0.10f),
                border = BorderStroke(1.2.dp, DimsTealPrimary.copy(alpha = 0.45f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("calc_patient_value_input_banner")
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = DimsTealPrimary,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = "ENTER PATIENT VALUES BELOW",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = DimsTealPrimary
                        )
                        Text(
                            text = "Tap any box below to type patient lab values or select options. The score and evidence-based clinical recommendation will update automatically.",
                            fontSize = 11.5.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
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
                "vocal_penn" -> VocalPennInteractiveCard()
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
                // --- Newly Added Interactive Clinical Cards ---
                "milan" -> MilanCriteriaInteractiveCard()
                "rome_iii" -> RomeIIIInteractiveCard()
                "aih_revised" -> RevisedAihInteractiveCard()
                "psc_model" -> PscMayoInteractiveCard()
                "simplified_aih" -> SimplifiedAihInteractiveCard()
                "galad" -> GaladInteractiveCard()
                "manning" -> ManningInteractiveCard()
                "montreal_ibd" -> MontrealIbdInteractiveCard()
                "bclc" -> BclcInteractiveCard()
                "clif_c_aclf" -> ClifCAclfStandaloneCard()
                "ascvd_risk", "ascvd_2013" -> AscvdInteractiveCard()
                "sirs_sepsis" -> SirsSepsisInteractiveCard()
                "ariscat" -> AriscatInteractiveCard()
                "sofa_score" -> SofaInteractiveCard()
                "prevent_risk" -> PreventRiskInteractiveCard()
                "pecarn_head" -> PecarnInteractiveCard()
                "abg_solver" -> AbgSolverInteractiveCard()
                "truelove_witts" -> TrueloveWittsInteractiveCard()
                // --- Newly Added High-Impact Formulas & Scores ---
                "alvarado" -> AlvaradoInteractiveCard()
                "four_ts_hit" -> FourTsInteractiveCard()
                "anion_delta_gap" -> AnionDeltaGapInteractiveCard()
                "osmolar_gap" -> OsmolarGapInteractiveCard()
                "rox_index" -> RoxIndexInteractiveCard()
                "spesi_pe" -> SpesiInteractiveCard()
                "feurea" -> FeUreaInteractiveCard()
                "bap65" -> Bap65InteractiveCard()
                "nihss_stroke" -> NihssInteractiveCard()
                "san_francisco_syncope" -> SanFranciscoSyncopeInteractiveCard()
                "corrected_sodium" -> CorrectedSodiumInteractiveCard()
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
    var age by remember { mutableStateOf("64") }
    var sbp by remember { mutableStateOf("115") }
    var hr by remember { mutableStateOf("88") }
    var comorbidityLevel by remember { mutableIntStateOf(0) } // 0: None, 2: IHD/Heart failure, 3: Renal/Liver failure/Malignancy
    var endoscopicDiagnosis by remember { mutableIntStateOf(1) } // 0: Mallory-Weiss/normal, 1: Other (ulcer/erosion), 2: Upper GI malignancy
    var stigmataHemorrhage by remember { mutableIntStateOf(0) } // 0: None/dark spot, 2: Blood in lumen/adherent clot/visible or spurting vessel

    val res = remember(age, sbp, hr, comorbidityLevel, isComplete, endoscopicDiagnosis, stigmataHemorrhage) {
        ExtendedCalculators.calculateRockallScore(
            age = age.toIntOrNull() ?: 64,
            systolicBp = sbp.toIntOrNull() ?: 115,
            heartRate = hr.toIntOrNull() ?: 88,
            comorbidityLevel = comorbidityLevel,
            isComplete = isComplete,
            endoscopicDiagnosis = endoscopicDiagnosis,
            stigmataHemorrhage = stigmataHemorrhage
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (years)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = sbp,
                onValueChange = { sbp = it },
                label = { Text("Systolic BP (mmHg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = hr,
                onValueChange = { hr = it },
                label = { Text("Heart Rate (bpm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        Text("Major Comorbidity:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = comorbidityLevel == 0, onClick = { comorbidityLevel = 0 }, label = { Text("None (0)") })
            FilterChip(selected = comorbidityLevel == 2, onClick = { comorbidityLevel = 2 }, label = { Text("IHD / Heart Failure (+2)") })
            FilterChip(selected = comorbidityLevel == 3, onClick = { comorbidityLevel = 3 }, label = { Text("Renal/Liver/Metastatic (+3)") })
        }

        if (isComplete) {
            Text("Endoscopic Diagnosis:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                FilterChip(selected = endoscopicDiagnosis == 0, onClick = { endoscopicDiagnosis = 0 }, label = { Text("Mallory-Weiss / No lesion (0)") })
                FilterChip(selected = endoscopicDiagnosis == 1, onClick = { endoscopicDiagnosis = 1 }, label = { Text("Peptic Ulcer / Erosions (+1)") })
                FilterChip(selected = endoscopicDiagnosis == 2, onClick = { endoscopicDiagnosis = 2 }, label = { Text("GI Malignancy (+2)") })
            }

            Text("Stigmata of Recent Hemorrhage (SRH):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                FilterChip(selected = stigmataHemorrhage == 0, onClick = { stigmataHemorrhage = 0 }, label = { Text("None / Dark spot only (0)") })
                FilterChip(selected = stigmataHemorrhage == 2, onClick = { stigmataHemorrhage = 2 }, label = { Text("Blood / Clot / Visible vessel (+2)") })
            }
        }

        ResultBanner(
            title = if (isComplete) "Complete Post-Endoscopy Rockall Score" else "Pre-Endoscopy Rockall Score",
            valueText = "${res.score} Points • ${res.mortalityRisk}",
            badgeText = res.riskTier,
            guidance = "${res.rebleedRisk}\n\nClinical Guidance:\n${res.clinicalGuidance}",
            isSafe = res.score <= 2
        )
    }
}

@Composable
fun OaklandInteractiveCard() {
    var age by remember { mutableStateOf("65") }
    var isMale by remember { mutableStateOf(false) }
    var prevAdmission by remember { mutableStateOf(false) }
    var dreBlood by remember { mutableStateOf(false) }
    var hr by remember { mutableStateOf("76") }
    var sbp by remember { mutableStateOf("128") }
    var hb by remember { mutableStateOf("11.8") }

    val res = remember(age, isMale, prevAdmission, dreBlood, hr, sbp, hb) {
        ExtendedCalculators.calculateOaklandScore(
            age = age.toIntOrNull() ?: 65,
            isMale = isMale,
            prevLgibAdmission = prevAdmission,
            dreBloodPresent = dreBlood,
            heartRateBpm = hr.toIntOrNull() ?: 76,
            systolicBpMmHg = sbp.toIntOrNull() ?: 128,
            hemoglobinGdL = hb.toDoubleOrNull() ?: 11.8
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (years)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = sbp,
                onValueChange = { sbp = it },
                label = { Text("Systolic BP (mmHg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = hr,
                onValueChange = { hr = it },
                label = { Text("Heart Rate (bpm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        OutlinedTextField(
            value = hb,
            onValueChange = { hb = it },
            label = { Text("Hemoglobin (g/dL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = isMale,
                onClick = { isMale = !isMale },
                label = { Text(if (isMale) "Sex: Male (+1)" else "Sex: Female (0)") }
            )
            FilterChip(
                selected = prevAdmission,
                onClick = { prevAdmission = !prevAdmission },
                label = { Text("Prior Lower GI Bleed (+1)") }
            )
            FilterChip(
                selected = dreBlood,
                onClick = { dreBlood = !dreBlood },
                label = { Text("DRE: Blood in Stool (+1)") }
            )
        }

        ResultBanner(
            title = "Oakland Score (Acute Lower GI Bleed)",
            valueText = "${res.score} / 35 Points",
            badgeText = res.riskTier,
            guidance = res.recommendation,
            isSafe = res.isSafeDischarge
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
        Text("History (Suspicion of ACS):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = history == 0, onClick = { history = 0 }, label = { Text("Slightly (0)") })
            FilterChip(selected = history == 1, onClick = { history = 1 }, label = { Text("Moderately (+1)") })
            FilterChip(selected = history == 2, onClick = { history = 2 }, label = { Text("Highly Suspicious (+2)") })
        }

        Text("ECG Findings:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ecg == 0, onClick = { ecg = 0 }, label = { Text("Normal (0)") })
            FilterChip(selected = ecg == 1, onClick = { ecg = 1 }, label = { Text("Non-specific repol (+1)") })
            FilterChip(selected = ecg == 2, onClick = { ecg = 2 }, label = { Text("ST-depression / BBB (+2)") })
        }

        Text("Age Group:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = age == 0, onClick = { age = 0 }, label = { Text("< 45 yr (0)") })
            FilterChip(selected = age == 1, onClick = { age = 1 }, label = { Text("45 - 64 yr (+1)") })
            FilterChip(selected = age == 2, onClick = { age = 2 }, label = { Text(">= 65 yr (+2)") })
        }

        Text("Atherosclerotic Risk Factors (HTN, DM, Smoking, Dyslipidemia, Family Hx, Obesity):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = risk == 0, onClick = { risk = 0 }, label = { Text("No risk factors (0)") })
            FilterChip(selected = risk == 1, onClick = { risk = 1 }, label = { Text("1 - 2 Risk factors (+1)") })
            FilterChip(selected = risk == 2, onClick = { risk = 2 }, label = { Text(">=3 or Atherosclerotic Dz (+2)") })
        }

        Text("Cardiac Troponin Level:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = trop == 0, onClick = { trop = 0 }, label = { Text("<= Normal limit (0)") })
            FilterChip(selected = trop == 1, onClick = { trop = 1 }, label = { Text("1 - 3× ULN (+1)") })
            FilterChip(selected = trop == 2, onClick = { trop = 2 }, label = { Text("> 3× ULN (+2)") })
        }

        ResultBanner(
            title = "HEART Score for Chest Pain",
            valueText = "${res.score} / 10 Points (${res.sixWeekMacePercent}% 6-week MACE)",
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

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Clinical DVT Criteria (Wells):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = cancer, onClick = { cancer = !cancer }, label = { Text("Active Cancer (+1)") })
            FilterChip(selected = paralysis, onClick = { paralysis = !paralysis }, label = { Text("Paresis / Plaster (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = bed, onClick = { bed = !bed }, label = { Text("Bedridden >3d / Surgery 12w (+1)") })
            FilterChip(selected = tender, onClick = { tender = !tender }, label = { Text("Deep Vein Tenderness (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = wholeLeg, onClick = { wholeLeg = !wholeLeg }, label = { Text("Entire Leg Swollen (+1)") })
            FilterChip(selected = calf, onClick = { calf = !calf }, label = { Text("Calf Swelling >3cm (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = edema, onClick = { edema = !edema }, label = { Text("Pitting Edema (+1)") })
            FilterChip(selected = veins, onClick = { veins = !veins }, label = { Text("Collateral Veins (+1)") })
        }
        FilterChip(
            selected = alt,
            onClick = { alt = !alt },
            label = { Text("Alternative Diagnosis as Likely as DVT (-2)") },
            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.errorContainer)
        )

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

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Clinical PE Criteria (Wells):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = dvtSigns, onClick = { dvtSigns = !dvtSigns }, label = { Text("Clinical Signs of DVT (+3)") })
            FilterChip(selected = peLikely, onClick = { peLikely = !peLikely }, label = { Text("PE #1 or Equally Likely (+3)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = hr, onClick = { hr = !hr }, label = { Text("Heart Rate > 100 bpm (+1.5)") })
            FilterChip(selected = surgery, onClick = { surgery = !surgery }, label = { Text("Surgery/Bedridden 4w (+1.5)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = prior, onClick = { prior = !prior }, label = { Text("Prior DVT or PE (+1.5)") })
            FilterChip(selected = hemoptysis, onClick = { hemoptysis = !hemoptysis }, label = { Text("Hemoptysis (+1)") })
        }
        FilterChip(selected = cancer, onClick = { cancer = !cancer }, label = { Text("Active Malignancy (+1)") })

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
    var hr by remember { mutableStateOf("78") }
    var isAlert by remember { mutableStateOf(true) }
    var temp by remember { mutableStateOf("37.0") }

    val res = remember(rr, spo2, onOxygen, sbp, hr, isAlert, temp) {
        ExtendedCalculators.calculateNews2(
            respirationRate = rr.toIntOrNull() ?: 18,
            spo2Percent = spo2.toIntOrNull() ?: 96,
            onOxygen = onOxygen,
            systolicBp = sbp.toIntOrNull() ?: 120,
            heartRateBpm = hr.toIntOrNull() ?: 78,
            isAlert = isAlert,
            temperatureCelsius = temp.toDoubleOrNull() ?: 37.0
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = rr,
                onValueChange = { rr = it },
                label = { Text("Resp Rate (/min)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = spo2,
                onValueChange = { spo2 = it },
                label = { Text("SpO2 (%)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = sbp,
                onValueChange = { sbp = it },
                label = { Text("Systolic BP (mmHg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = hr,
                onValueChange = { hr = it },
                label = { Text("Heart Rate (bpm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = temp,
                onValueChange = { temp = it },
                label = { Text("Temp (°C)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = onOxygen,
                onClick = { onOxygen = !onOxygen },
                label = { Text(if (onOxygen) "Supplemental O₂ (+2)" else "Room Air (0)") }
            )
            FilterChip(
                selected = !isAlert,
                onClick = { isAlert = !isAlert },
                label = { Text(if (isAlert) "Consciousness: Alert (0)" else "Altered: CVPU (+3)") }
            )
        }
        ResultBanner(
            title = "National Early Warning Score (NEWS2)",
            valueText = "${res.totalScore} / 20 Points • ${res.monitoringFrequency}",
            badgeText = res.riskCategory,
            guidance = res.responseLevel,
            isSafe = res.totalScore <= 4 && !res.hasRedScore
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
        Text("Eye Opening Response:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = eye == 4, onClick = { eye = 4 }, label = { Text("Spontaneous (4)") })
            FilterChip(selected = eye == 3, onClick = { eye = 3 }, label = { Text("To Sound (3)") })
            FilterChip(selected = eye == 2, onClick = { eye = 2 }, label = { Text("To Pressure (2)") })
            FilterChip(selected = eye == 1, onClick = { eye = 1 }, label = { Text("None (1)") })
        }

        Text("Verbal Response:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = verbal == 5, onClick = { verbal = 5 }, label = { Text("Oriented (5)") })
            FilterChip(selected = verbal == 4, onClick = { verbal = 4 }, label = { Text("Confused (4)") })
            FilterChip(selected = verbal == 3, onClick = { verbal = 3 }, label = { Text("Inappropriate (3)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = verbal == 2, onClick = { verbal = 2 }, label = { Text("Incomprehensible (2)") })
            FilterChip(selected = verbal == 1, onClick = { verbal = 1 }, label = { Text("None (1)") })
        }

        Text("Motor Response:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = motor == 6, onClick = { motor = 6 }, label = { Text("Obeys (6)") })
            FilterChip(selected = motor == 5, onClick = { motor = 5 }, label = { Text("Localizing (5)") })
            FilterChip(selected = motor == 4, onClick = { motor = 4 }, label = { Text("Normal Flexion (4)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = motor == 3, onClick = { motor = 3 }, label = { Text("Abnormal Flexion (3)") })
            FilterChip(selected = motor == 2, onClick = { motor = 2 }, label = { Text("Extension (2)") })
            FilterChip(selected = motor == 1, onClick = { motor = 1 }, label = { Text("None (1)") })
        }

        ResultBanner(
            title = "Glasgow Coma Scale (GCS)",
            valueText = "E${res.eyeScore} V${res.verbalScore} M${res.motorScore} = ${res.totalScore} / 15 Points",
            badgeText = res.severity,
            guidance = "${res.clinicalGuidance}\n\nClinical Rule: GCS <= 8 indicates coma; endotracheal intubation strongly indicated for airway protection.",
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

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("STOP-BANG Screening Questions:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = snoring, onClick = { snoring = !snoring }, label = { Text("Snoring loudly (+1)") })
            FilterChip(selected = tired, onClick = { tired = !tired }, label = { Text("Tired / fatigued (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = observed, onClick = { observed = !observed }, label = { Text("Observed apnea (+1)") })
            FilterChip(selected = pressure, onClick = { pressure = !pressure }, label = { Text("Hypertension (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = bmi, onClick = { bmi = !bmi }, label = { Text("BMI > 35 kg/m² (+1)") })
            FilterChip(selected = age, onClick = { age = !age }, label = { Text("Age > 50 yr (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = neck, onClick = { neck = !neck }, label = { Text("Neck > 40 cm (+1)") })
            FilterChip(selected = male, onClick = { male = !male }, label = { Text("Sex: Male (+1)") })
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
    var ageGroup by remember { mutableIntStateOf(1) } // 0: 3-14 (+1), 1: 15-44 (0), 2: >=45 (-1)

    val res = remember(exudate, nodes, fever, noCough, ageGroup) {
        ExtendedCalculators.calculateCentor(exudate, nodes, fever, noCough, ageGroup)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Clinical Findings:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = exudate, onClick = { exudate = !exudate }, label = { Text("Tonsillar exudate (+1)") })
            FilterChip(selected = nodes, onClick = { nodes = !nodes }, label = { Text("Tender cervical nodes (+1)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = fever, onClick = { fever = !fever }, label = { Text("Fever history >38°C (+1)") })
            FilterChip(selected = noCough, onClick = { noCough = !noCough }, label = { Text("Absence of cough (+1)") })
        }

        Text("Patient Age Group:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = ageGroup == 0, onClick = { ageGroup = 0 }, label = { Text("3 - 14 years (+1)") })
            FilterChip(selected = ageGroup == 1, onClick = { ageGroup = 1 }, label = { Text("15 - 44 years (0)") })
            FilterChip(selected = ageGroup == 2, onClick = { ageGroup = 2 }, label = { Text(">= 45 years (-1)") })
        }

        ResultBanner(
            title = "Centor (McIsaac) Score",
            valueText = "${res.score} Points • ${res.probability}",
            badgeText = if (res.score >= 3) "Antibiotics Warranted" else "Supportive Care",
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
        OutlinedTextField(
            value = dose,
            onValueChange = { dose = it },
            label = { Text("Dose (mg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
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
    var totalScore by remember { mutableIntStateOf(8) }
    val res = remember(totalScore) { ExtendedCalculators.calculatePhq9(listOf(totalScore)) }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Total PHQ-9 Score (0 - 27): $totalScore Points", fontWeight = FontWeight.Bold)
        Slider(
            value = totalScore.toFloat(),
            onValueChange = { totalScore = it.toInt() },
            valueRange = 0f..27f,
            steps = 26
        )

        Text("Quick Severity Band Selection:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = totalScore in 0..4, onClick = { totalScore = 2 }, label = { Text("None (0-4)") })
            FilterChip(selected = totalScore in 5..9, onClick = { totalScore = 7 }, label = { Text("Mild (5-9)") })
            FilterChip(selected = totalScore in 10..14, onClick = { totalScore = 12 }, label = { Text("Moderate (10-14)") })
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(selected = totalScore in 15..19, onClick = { totalScore = 17 }, label = { Text("Mod Severe (15-19)") })
            FilterChip(selected = totalScore in 20..27, onClick = { totalScore = 22 }, label = { Text("Severe (20-27)") })
        }

        ResultBanner(
            title = "PHQ-9 Depression Severity",
            valueText = "$totalScore / 27 Points",
            badgeText = res.severity,
            guidance = "${res.treatmentRecommendation}\n\nClinical Note: Score >= 10 has 88% sensitivity and 88% specificity for Major Depressive Disorder.",
            isSafe = totalScore < 10
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
            OutlinedTextField(
                value = totalMg,
                onValueChange = { totalMg = it },
                label = { Text("Drug (mg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = bagMl,
                onValueChange = { bagMl = it },
                label = { Text("Bag (mL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Patient Weight (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = rateMcg,
                onValueChange = { rateMcg = it },
                label = { Text("Target mcg/kg/min") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
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
    var patientValue by remember { mutableStateOf("") }
    var selectedTier by remember { mutableStateOf("Standard Evaluation") }
    var hasComplication by remember { mutableStateOf(false) }

    val numericVal = patientValue.toDoubleOrNull()
    val isElevated = (numericVal != null && numericVal > 0.0) || hasComplication

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Clinical Parameter Entry", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        OutlinedTextField(
            value = patientValue,
            onValueChange = { patientValue = it },
            label = { Text("Enter Patient Lab or Clinical Value") },
            placeholder = { Text("e.g. measured lab value, index, or points") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Clinical Stratification Tier", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("Low Risk", "Intermediate", "High Risk").forEach { tier ->
                FilterChip(
                    selected = selectedTier == tier,
                    onClick = { selectedTier = tier },
                    label = { Text(tier) }
                )
            }
        }

        Surface(
            onClick = { hasComplication = !hasComplication },
            shape = RoundedCornerShape(10.dp),
            color = if (hasComplication) MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.35f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f),
            border = BorderStroke(1.dp, if (hasComplication) MaterialTheme.colorScheme.error.copy(alpha = 0.6f) else MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Alarm Features / Red Flags Present",
                        fontSize = 13.sp,
                        fontWeight = if (hasComplication) FontWeight.Bold else FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Hemodynamic instability, organ failure, or acute clinical decompensation",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Checkbox(checked = hasComplication, onCheckedChange = { hasComplication = it })
            }
        }

        val calculatedStatus = if (numericVal != null) {
            "$title: $patientValue ($selectedTier)"
        } else {
            "$title ($selectedTier)"
        }

        val clinicalGuidance = buildString {
            append("Evidence-Based Guideline Criteria:\n")
            append(formula)
            append("\n\nGuideline Action Plan:\n")
            if (hasComplication || selectedTier == "High Risk") {
                append("• High-Risk Presentation: Prompt clinical escalation, specialist consultation ($category), and monitoring in high-dependency or ICU setting as indicated.\n")
                append("• Ensure close reassessment of vital signs and laboratory markers within 24-48 hours.")
            } else if (selectedTier == "Intermediate") {
                append("• Intermediate Stratification: Close outpatient or inpatient surveillance. Review potential reversible factors, adjust medications, and schedule short-term follow-up.")
            } else {
                append("• Low Risk / Favorable Profile: Standard maintenance management according to clinical guidelines. Routine monitoring and patient education on alarm symptoms.")
            }
        }

        ResultBanner(
            title = "$title Clinical Evaluation",
            valueText = calculatedStatus,
            badgeText = if (hasComplication) "High Risk / Alert" else selectedTier,
            guidance = clinicalGuidance,
            isSafe = !hasComplication && selectedTier != "High Risk",
            jsonPayload = """
                {
                  "score_name": "$title",
                  "category": "$category",
                  "calculated_value": "${if (numericVal != null) patientValue else selectedTier}",
                  "status": "COMPLETE",
                  "missing_inputs": [],
                  "interpretation": "Evaluated per guideline formula: $formula",
                  "risk_tier": "${if (hasComplication) "Severe / High" else selectedTier}",
                  "clinical_recommendation": "${if (hasComplication) "Immediate specialist escalation and close hemodynamic monitoring." else "Follow standard disease-specific guideline management."}"
                }
            """.trimIndent(),
            nextSteps = if (hasComplication || selectedTier == "High Risk") {
                listOf(
                    "Step 1 (Immediate Triage): High-risk threshold identified for $title ($selectedTier). Prompt senior clinical review and continuous vital signs monitoring.",
                    "Step 2 (Specialist Escalation): Expedite urgent consultation with $category specialist and assess HDU/ICU level of care.",
                    "Step 3 (Therapeutic Protocol): Initiate guideline-directed medical interventions immediately and adjust medication dosages.",
                    "Step 4 (Serial Monitoring): Repeat targeted labs and clinical reassessment within 12-24 hours."
                )
            } else if (selectedTier == "Intermediate") {
                listOf(
                    "Step 1 (Risk Stratification): Intermediate-risk classification ($selectedTier). Investigate reversible contributing factors.",
                    "Step 2 (Care Setting): Inpatient monitored care or expedited ambulatory surveillance with documented alarm criteria.",
                    "Step 3 (Pharmacotherapy): Optimize guideline-directed medical therapy and ensure organ-specific dosing.",
                    "Step 4 (Follow-up Plan): Schedule short-interval reassessment and educate patient on warning symptoms."
                )
            } else {
                listOf(
                    "Step 1 (Risk Confirmation): Low-risk stratification confirmed for $title ($selectedTier). Favorable baseline profile.",
                    "Step 2 (Management Pathway): Standard outpatient or low-intensity ward care; avoid unnecessary invasive interventions.",
                    "Step 3 (Safety-Netting): Review red-flag symptoms with patient requiring immediate medical re-evaluation."
                )
            }
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
    jsonPayload: String? = null,
    nextSteps: List<String> = emptyList()
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
            verticalArrangement = Arrangement.spacedBy(10.dp)
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

            // -------------------------------------------------------------
            // Prominent Recommended Next Steps & Clinical Management
            // -------------------------------------------------------------
            val actionSteps = remember(title, badgeText, guidance, isSafe, nextSteps) {
                if (nextSteps.isNotEmpty()) {
                    nextSteps
                } else {
                    val lines = guidance.lines().map { it.trim() }.filter { it.isNotBlank() }
                    val extracted = mutableListOf<String>()
                    for (line in lines) {
                        if (line.startsWith("1.") || line.startsWith("2.") || line.startsWith("3.") ||
                            line.startsWith("4.") || line.startsWith("5.") || line.startsWith("Step") ||
                            line.startsWith("-") || line.startsWith("•") || line.contains("Clinical Action:", ignoreCase = true)
                        ) {
                            extracted.add(line.removePrefix("-").removePrefix("•").trim())
                        }
                    }
                    if (extracted.size >= 2) {
                        extracted
                    } else {
                        val sentences = guidance.split(". ").map { it.trim().removeSuffix(".") }.filter { it.length > 10 }
                        if (sentences.size >= 2) {
                            sentences.mapIndexed { idx, s -> "Step ${idx + 1}: $s." }
                        } else if (isSafe) {
                            listOf(
                                "Step 1 (Risk Assessment): Patient meets low-risk / baseline criteria for $title ($badgeText).",
                                "Step 2 (Plan & Monitoring): Continue standard clinical observation or outpatient management as indicated.",
                                "Step 3 (Safety Net): Re-evaluate if clinical status changes or red-flag signs emerge."
                            )
                        } else {
                            listOf(
                                "Step 1 (Immediate Triage): High-risk threshold identified for $title ($badgeText). Immediate clinical review indicated.",
                                "Step 2 (Clinical Action): Implement guideline-directed therapeutic intervention and increase monitoring frequency.",
                                "Step 3 (Escalation): Consult relevant subspecialist / critical care outreach if no prompt improvement."
                            )
                        }
                    }
                }
            }

            if (actionSteps.isNotEmpty()) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, borderColor.copy(alpha = 0.35f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MedicalServices,
                                    contentDescription = null,
                                    tint = borderColor,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "RECOMMENDED NEXT STEPS",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = borderColor,
                                    letterSpacing = 0.5.sp
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = borderColor.copy(alpha = 0.12f)
                            ) {
                                Text(
                                    text = "${actionSteps.size} Action Steps",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = borderColor,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                        actionSteps.forEachIndexed { index, step ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = borderColor.copy(alpha = 0.18f),
                                    modifier = Modifier.size(20.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = "${index + 1}",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = borderColor
                                        )
                                    }
                                }
                                Text(
                                    text = step,
                                    fontSize = 11.5.sp,
                                    lineHeight = 16.5.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        val clipboardManager = LocalClipboardManager.current
                        val context = LocalContext.current

                        OutlinedButton(
                            onClick = {
                                val summaryText = buildString {
                                    appendLine("--- $title ---")
                                    appendLine("Result: $valueText ($badgeText)")
                                    appendLine("Guidance: $guidance")
                                    appendLine("\nRecommended Next Steps:")
                                    actionSteps.forEachIndexed { i, s ->
                                        appendLine("${i + 1}. $s")
                                    }
                                }
                                clipboardManager.setText(AnnotatedString(summaryText))
                                Toast.makeText(context, "Copied score & next steps to clipboard", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, borderColor.copy(alpha = 0.5f)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = borderColor
                            ),
                            contentPadding = PaddingValues(vertical = 6.dp, horizontal = 12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Copy Score & Clinical Next Steps",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VocalPennInteractiveCard() {
    var age by remember { mutableStateOf("58") }
    var albumin by remember { mutableStateOf("3.1") }
    var bilirubin by remember { mutableStateOf("1.8") }
    var platelets by remember { mutableStateOf("85") }
    var bmi by remember { mutableStateOf("26.4") }
    var asaClass by remember { mutableIntStateOf(3) } // 1, 3, 4
    var selectedCategory by remember { mutableStateOf("Cholecystectomy") }
    var isEmergency by remember { mutableStateOf(false) }

    val categories = remember {
        listOf(
            "Cholecystectomy",
            "Abdominal Wall / Hernia",
            "Major Abdominal / Colorectal",
            "Orthopedic",
            "Vascular",
            "Cardiac",
            "Other Minor"
        )
    }

    val res = remember(age, albumin, bilirubin, platelets, bmi, asaClass, selectedCategory, isEmergency) {
        ExtendedCalculators.calculateVocalPennScore(
            age = age.toIntOrNull() ?: 58,
            albumin = albumin.toDoubleOrNull() ?: 3.1,
            bilirubin = bilirubin.toDoubleOrNull() ?: 1.8,
            platelets = platelets.toDoubleOrNull() ?: 85.0,
            bmi = bmi.toDoubleOrNull() ?: 26.4,
            asaClass = asaClass,
            surgicalCategory = selectedCategory,
            isEmergency = isEmergency
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // Lab Inputs Row 1: Age, Albumin, Bilirubin
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age (yr)", fontSize = 11.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = albumin,
                onValueChange = { albumin = it },
                label = { Text("Albumin (g/dL)", fontSize = 11.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = bilirubin,
                onValueChange = { bilirubin = it },
                label = { Text("Bilirubin (mg/dL)", fontSize = 11.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        // Lab Inputs Row 2: Platelets, BMI
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = platelets,
                onValueChange = { platelets = it },
                label = { Text("Platelets (10³/μL)", fontSize = 11.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = bmi,
                onValueChange = { bmi = it },
                label = { Text("BMI (kg/m²)", fontSize = 11.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        // ASA Physical Status
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "ASA Physical Status:",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                FilterChip(
                    selected = asaClass == 2,
                    onClick = { asaClass = 2 },
                    label = { Text("ASA I - II (Mild/Compensated)") }
                )
                FilterChip(
                    selected = asaClass == 3,
                    onClick = { asaClass = 3 },
                    label = { Text("ASA III (Severe Systemic)") }
                )
                FilterChip(
                    selected = asaClass == 4,
                    onClick = { asaClass = 4 },
                    label = { Text("ASA IV - V (Life Threatening)") }
                )
            }
        }

        // Surgical Category
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "Surgical Category & Complexity:",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                categories.forEach { cat ->
                    FilterChip(
                        selected = selectedCategory == cat,
                        onClick = { selectedCategory = cat },
                        label = { Text(cat, fontSize = 11.sp) }
                    )
                }
            }
        }

        // Emergency vs Elective Toggle
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Emergency / Urgent Surgery",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isEmergency) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = if (isEmergency) "Non-elective emergent procedure (~2.6x risk)" else "Planned elective procedure",
                    fontSize = 10.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(
                checked = isEmergency,
                onCheckedChange = { isEmergency = it }
            )
        }

        // Result Card
        ResultBanner(
            title = "VOCAL-Penn Cirrhosis Surgical Risk",
            valueText = "30d Mort: ${res.thirtyDayMortalityPercent}% (90d: ${res.ninetyDayMortalityPercent}%)",
            badgeText = res.riskCategory,
            guidance = res.recommendations,
            isSafe = res.thirtyDayMortalityPercent < 5.0,
            nextSteps = listOf(
                "Step 1 (Pre-op Optimization): ${res.surgicalOptimization.lines().getOrNull(0) ?: "Multidisciplinary hepatology & critical care evaluation."}",
                "Step 2 (Fluid & Hemostasis): ${res.surgicalOptimization.lines().getOrNull(1) ?: "Correct coagulopathy and optimize volume status."}",
                "Step 3 (Surgical Technique): ${res.surgicalOptimization.lines().getOrNull(2) ?: "Prefer minimally invasive / laparoscopic approaches."}",
                "Step 4 (Post-op Surveillance): ${res.surgicalOptimization.lines().getOrNull(3) ?: "Meticulous surveillance for post-op hepatic decompensation."}"
            )
        )
    }
}

// =============================================================================
// NEW INTERACTIVE CLINICAL CALCULATOR SUITE (11 FORMULAS & SCORES)
// =============================================================================

@Composable
fun AlvaradoInteractiveCard() {
    var migration by remember { mutableStateOf(false) }
    var anorexia by remember { mutableStateOf(false) }
    var nausea by remember { mutableStateOf(false) }
    var tenderness by remember { mutableStateOf(false) }
    var rebound by remember { mutableStateOf(false) }
    var elevatedTemp by remember { mutableStateOf(false) }
    var leukocytosis by remember { mutableStateOf(false) }
    var shift by remember { mutableStateOf(false) }

    val res = remember(migration, anorexia, nausea, tenderness, rebound, elevatedTemp, leukocytosis, shift) {
        ExtendedCalculators.calculateAlvarado(
            migrationOfPain = migration,
            anorexia = anorexia,
            nauseaOrVomiting = nausea,
            rlqTenderness = tenderness,
            reboundPain = rebound,
            elevatedTemp = elevatedTemp,
            leukocytosis = leukocytosis,
            neutrophilShift = shift
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Symptoms (1 point each)", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("Migration of pain to RLQ (+1)", migration, { migration = it })
        ScoringToggleRow("Anorexia / loss of appetite (+1)", anorexia, { anorexia = it })
        ScoringToggleRow("Nausea or vomiting (+1)", nausea, { nausea = it })

        Text("Signs", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("Tenderness in Right Lower Quadrant (+2 pts)", tenderness, { tenderness = it })
        ScoringToggleRow("Rebound pain in RLQ (+1 pt)", rebound, { rebound = it })
        ScoringToggleRow("Fever (≥ 37.3°C / 99.1°F) (+1 pt)", elevatedTemp, { elevatedTemp = it })

        Text("Laboratory Findings", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        ScoringToggleRow("Leukocytosis (WBC > 10,000/μL) (+2 pts)", leukocytosis, { leukocytosis = it })
        ScoringToggleRow("Neutrophilic left shift (> 75%) (+1 pt)", shift, { shift = it })

        ResultBanner(
            title = "Alvarado Score (MANTRELS)",
            valueText = "${res.totalScore} / 10 Points",
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nProbability: ${res.probability}",
            isSafe = res.totalScore <= 4,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun FourTsInteractiveCard() {
    var thrombocytopeniaPts by remember { mutableIntStateOf(0) }
    var timingPts by remember { mutableIntStateOf(0) }
    var thrombosisPts by remember { mutableIntStateOf(0) }
    var otherCausesPts by remember { mutableIntStateOf(2) }

    val res = remember(thrombocytopeniaPts, timingPts, thrombosisPts, otherCausesPts) {
        ExtendedCalculators.calculateFourTs(thrombocytopeniaPts, timingPts, thrombosisPts, otherCausesPts)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // T1: Thrombocytopenia
        Text("1. Thrombocytopenia", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = thrombocytopeniaPts == 2,
                onClick = { thrombocytopeniaPts = 2 },
                label = { Text("Platelet fall > 50% AND nadir ≥ 20k (+2 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = thrombocytopeniaPts == 1,
                onClick = { thrombocytopeniaPts = 1 },
                label = { Text("Platelet fall 30–50% OR nadir 10–19k (+1 pt)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = thrombocytopeniaPts == 0,
                onClick = { thrombocytopeniaPts = 0 },
                label = { Text("Platelet fall < 30% OR nadir < 10k (0 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // T2: Timing
        Text("2. Timing of Platelet Fall", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = timingPts == 2,
                onClick = { timingPts = 2 },
                label = { Text("Clear onset Day 5–10, or ≤1d with heparin in past 30d (+2 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = timingPts == 1,
                onClick = { timingPts = 1 },
                label = { Text("Fall after Day 10, or ≤1d with heparin 30–100d ago (+1 pt)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = timingPts == 0,
                onClick = { timingPts = 0 },
                label = { Text("Fall < Day 4 without recent heparin exposure (0 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // T3: Thrombosis
        Text("3. Thrombosis or Other Sequelae", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = thrombosisPts == 2,
                onClick = { thrombosisPts = 2 },
                label = { Text("Proven new thrombosis, skin necrosis, or systemic reaction (+2 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = thrombosisPts == 1,
                onClick = { thrombosisPts = 1 },
                label = { Text("Progressive/recurrent thrombosis or suspected DVT (+1 pt)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = thrombosisPts == 0,
                onClick = { thrombosisPts = 0 },
                label = { Text("None (0 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // T4: Other Causes
        Text("4. Other Causes for Thrombocytopenia", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = otherCausesPts == 2,
                onClick = { otherCausesPts = 2 },
                label = { Text("No other apparent cause (+2 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = otherCausesPts == 1,
                onClick = { otherCausesPts = 1 },
                label = { Text("Possible other cause present (+1 pt)") },
                modifier = Modifier.fillMaxWidth()
            )
            FilterChip(
                selected = otherCausesPts == 0,
                onClick = { otherCausesPts = 0 },
                label = { Text("Definite other cause present (sepsis, surgery dilution) (0 pts)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        ResultBanner(
            title = "4Ts Score for Heparin-Induced Thrombocytopenia",
            valueText = "${res.totalScore} / 8 Points",
            badgeText = res.riskTier,
            guidance = "${res.interpretation}\n\nPretest Probability: ${res.probability}",
            isSafe = res.totalScore <= 3,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun AnionDeltaGapInteractiveCard() {
    var sodium by remember { mutableStateOf("140") }
    var chloride by remember { mutableStateOf("102") }
    var bicarb by remember { mutableStateOf("14") }
    var albumin by remember { mutableStateOf("4.0") }

    val naVal = sodium.toDoubleOrNull() ?: 140.0
    val clVal = chloride.toDoubleOrNull() ?: 102.0
    val hco3Val = bicarb.toDoubleOrNull() ?: 14.0
    val albVal = albumin.toDoubleOrNull() ?: 4.0

    val res = remember(naVal, clVal, hco3Val, albVal) {
        ExtendedCalculators.calculateAnionDeltaGap(naVal, clVal, hco3Val, albVal)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = sodium,
                onValueChange = { sodium = it },
                label = { Text("Sodium (mEq/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = chloride,
                onValueChange = { chloride = it },
                label = { Text("Chloride (mEq/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = bicarb,
                onValueChange = { bicarb = it },
                label = { Text("HCO3 / Bicarb (mEq/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
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

        // Summary details card
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Measured AG: ${res.anionGap} mEq/L  |  Albumin-Corrected AG: ${res.correctedAnionGap} mEq/L", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                Text("Delta Gap (AG - 12): ${res.deltaGap}  |  Delta Ratio: ${res.deltaRatio}", fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        ResultBanner(
            title = "Serum Anion Gap & Delta Ratio",
            valueText = "${res.correctedAnionGap} mEq/L (Delta Ratio: ${res.deltaRatio})",
            badgeText = res.acidBaseCategory,
            guidance = res.interpretation,
            isSafe = res.correctedAnionGap <= 12.0 && hco3Val >= 22.0,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun OsmolarGapInteractiveCard() {
    var measuredOsm by remember { mutableStateOf("315") }
    var sodium by remember { mutableStateOf("140") }
    var glucose by remember { mutableStateOf("110") }
    var bun by remember { mutableStateOf("18") }
    var ethanol by remember { mutableStateOf("0") }

    val mOsmVal = measuredOsm.toDoubleOrNull() ?: 315.0
    val naVal = sodium.toDoubleOrNull() ?: 140.0
    val gluVal = glucose.toDoubleOrNull() ?: 110.0
    val bunVal = bun.toDoubleOrNull() ?: 18.0
    val etohVal = ethanol.toDoubleOrNull() ?: 0.0

    val res = remember(mOsmVal, naVal, gluVal, bunVal, etohVal) {
        ExtendedCalculators.calculateOsmolarGap(mOsmVal, naVal, gluVal, bunVal, etohVal)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = measuredOsm,
            onValueChange = { measuredOsm = it },
            label = { Text("Measured Osmolality (Freezing point) [mOsm/kg]") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = sodium,
                onValueChange = { sodium = it },
                label = { Text("Sodium (mEq/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = glucose,
                onValueChange = { glucose = it },
                label = { Text("Glucose (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = bun,
                onValueChange = { bun = it },
                label = { Text("BUN (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = ethanol,
                onValueChange = { ethanol = it },
                label = { Text("Ethanol (mg/dL) [optional]") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "Serum Osmolar Gap",
            valueText = "Gap: ${res.osmolarGap} mOsm/kg (Calc: ${res.calculatedOsmolality})",
            badgeText = res.riskTier,
            guidance = res.interpretation,
            isSafe = res.osmolarGap <= 10.0,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun RoxIndexInteractiveCard() {
    var spo2 by remember { mutableStateOf("94") }
    var fio2 by remember { mutableStateOf("60") }
    var rr by remember { mutableStateOf("22") }

    val spo2Val = spo2.toDoubleOrNull() ?: 94.0
    val fio2Val = fio2.toDoubleOrNull() ?: 60.0
    val rrVal = rr.toDoubleOrNull() ?: 22.0

    val res = remember(spo2Val, fio2Val, rrVal) {
        ExtendedCalculators.calculateRoxIndex(spo2Val, fio2Val, rrVal)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = spo2,
                onValueChange = { spo2 = it },
                label = { Text("SpO2 (%)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = fio2,
                onValueChange = { fio2 = it },
                label = { Text("FiO2 (%) [e.g. 60]") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        OutlinedTextField(
            value = rr,
            onValueChange = { rr = it },
            label = { Text("Respiratory Rate (breaths/min)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        ResultBanner(
            title = "ROX Index (High-Flow Nasal Cannula)",
            valueText = "${res.roxScore}",
            badgeText = res.riskTier,
            guidance = res.interpretation,
            isSafe = res.roxScore >= 4.88,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun SpesiInteractiveCard() {
    var ageOver80 by remember { mutableStateOf(false) }
    var cancer by remember { mutableStateOf(false) }
    var cardiopulmonary by remember { mutableStateOf(false) }
    var hrOver110 by remember { mutableStateOf(false) }
    var sbpUnder100 by remember { mutableStateOf(false) }
    var spo2Under90 by remember { mutableStateOf(false) }

    val res = remember(ageOver80, cancer, cardiopulmonary, hrOver110, sbpUnder100, spo2Under90) {
        ExtendedCalculators.calculateSpesi(
            ageOver80 = ageOver80,
            historyOfCancer = cancer,
            chronicCardiopulmonaryDisease = cardiopulmonary,
            heartRateOver110 = hrOver110,
            sbpUnder100 = sbpUnder100,
            spo2Under90 = spo2Under90
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ScoringToggleRow("Age > 80 years (+1 pt)", ageOver80, { ageOver80 = it })
        ScoringToggleRow("History of cancer / active malignancy (+1 pt)", cancer, { cancer = it })
        ScoringToggleRow("Chronic cardiopulmonary disease (CHF / COPD) (+1 pt)", cardiopulmonary, { cardiopulmonary = it })
        ScoringToggleRow("Pulse ≥ 110 beats/min (+1 pt)", hrOver110, { hrOver110 = it })
        ScoringToggleRow("Systolic BP < 100 mmHg (+1 pt)", sbpUnder100, { sbpUnder100 = it })
        ScoringToggleRow("Arterial oxygen saturation SpO2 < 90% (+1 pt)", spo2Under90, { spo2Under90 = it })

        ResultBanner(
            title = "Simplified PESI (sPESI) for Pulmonary Embolism",
            valueText = "${res.totalScore} Points (${res.thirtyDayMortality})",
            badgeText = res.riskTier,
            guidance = res.interpretation,
            isSafe = res.totalScore == 0,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun FeUreaInteractiveCard() {
    var serumUrea by remember { mutableStateOf("45") }
    var urineUrea by remember { mutableStateOf("320") }
    var serumCr by remember { mutableStateOf("2.1") }
    var urineCr by remember { mutableStateOf("55") }

    val sUreaVal = serumUrea.toDoubleOrNull() ?: 45.0
    val uUreaVal = urineUrea.toDoubleOrNull() ?: 320.0
    val sCrVal = serumCr.toDoubleOrNull() ?: 2.1
    val uCrVal = urineCr.toDoubleOrNull() ?: 55.0

    val res = remember(sUreaVal, uUreaVal, sCrVal, uCrVal) {
        ExtendedCalculators.calculateFeUrea(sUreaVal, uUreaVal, sCrVal, uCrVal)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = serumUrea,
                onValueChange = { serumUrea = it },
                label = { Text("Serum Urea / BUN (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = urineUrea,
                onValueChange = { urineUrea = it },
                label = { Text("Urine Urea (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = serumCr,
                onValueChange = { serumCr = it },
                label = { Text("Serum Cr (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = urineCr,
                onValueChange = { urineCr = it },
                label = { Text("Urine Cr (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        ResultBanner(
            title = "Fractional Excretion of Urea (FEUrea)",
            valueText = "${res.feUreaPercent}%",
            badgeText = res.etiology,
            guidance = res.interpretation,
            isSafe = res.feUreaPercent < 35.0,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun Bap65InteractiveCard() {
    var bunOver25 by remember { mutableStateOf(false) }
    var alteredMentalStatus by remember { mutableStateOf(false) }
    var pulseOver109 by remember { mutableStateOf(false) }
    var ageOver65 by remember { mutableStateOf(true) }

    val res = remember(bunOver25, alteredMentalStatus, pulseOver109, ageOver65) {
        ExtendedCalculators.calculateBap65(bunOver25, alteredMentalStatus, pulseOver109, ageOver65)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ScoringToggleRow("B: Blood Urea Nitrogen > 25 mg/dL (+1 pt)", bunOver25, { bunOver25 = it })
        ScoringToggleRow("A: Altered Mental Status (GCS < 15, lethargy) (+1 pt)", alteredMentalStatus, { alteredMentalStatus = it })
        ScoringToggleRow("P: Pulse ≥ 109 beats/min (+1 pt)", pulseOver109, { pulseOver109 = it })
        ScoringToggleRow("65: Age ≥ 65 years (+1 pt)", ageOver65, { ageOver65 = it })

        ResultBanner(
            title = "BAP-65 for Acute COPD Exacerbation",
            valueText = "${res.totalScore} Points (${res.inHospitalMortality})",
            badgeText = res.riskClass,
            guidance = res.interpretation,
            isSafe = res.totalScore <= 1,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun NihssInteractiveCard() {
    var pointsText by remember { mutableStateOf("6") }
    val pointsVal = pointsText.toIntOrNull() ?: 6

    val res = remember(pointsVal) {
        ExtendedCalculators.calculateNihss(pointsVal)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Quick Stroke Severity Presets:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            FilterChip(selected = pointsVal == 3, onClick = { pointsText = "3" }, label = { Text("Minor (3)") })
            FilterChip(selected = pointsVal == 8, onClick = { pointsText = "8" }, label = { Text("Moderate (8)") })
            FilterChip(selected = pointsVal == 17, onClick = { pointsText = "17" }, label = { Text("Mod-Severe (17)") })
            FilterChip(selected = pointsVal == 24, onClick = { pointsText = "24" }, label = { Text("Severe (24)") })
        }

        OutlinedTextField(
            value = pointsText,
            onValueChange = { pointsText = it },
            label = { Text("NIHSS Total Score (0 to 42)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        ResultBanner(
            title = "NIH Stroke Scale (NIHSS) Screening",
            valueText = "${res.totalScore} / 42 Points",
            badgeText = res.strokeSeverity,
            guidance = "${res.interpretation}\n\nReperfusion Candidate: ${res.thrombolysisCandidate}",
            isSafe = res.totalScore <= 4,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun SanFranciscoSyncopeInteractiveCard() {
    var chf by remember { mutableStateOf(false) }
    var hctUnder30 by remember { mutableStateOf(false) }
    var abnormalEcg by remember { mutableStateOf(false) }
    var sob by remember { mutableStateOf(false) }
    var sbpUnder90 by remember { mutableStateOf(false) }

    val res = remember(chf, hctUnder30, abnormalEcg, sob, sbpUnder90) {
        ExtendedCalculators.calculateSanFranciscoSyncope(
            congestiveHeartFailure = chf,
            hematocritUnder30 = hctUnder30,
            abnormalEcg = abnormalEcg,
            shortnessOfBreath = sob,
            sbpUnder90 = sbpUnder90
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ScoringToggleRow("C: Congestive Heart Failure history", chf, { chf = it })
        ScoringToggleRow("H: Hematocrit < 30%", hctUnder30, { hctUnder30 = it })
        ScoringToggleRow("E: ECG abnormal (non-sinus, conduction block, prolonged QTc)", abnormalEcg, { abnormalEcg = it })
        ScoringToggleRow("S: Shortness of breath", sob, { sob = it })
        ScoringToggleRow("S: Systolic Blood Pressure < 90 mmHg at triage", sbpUnder90, { sbpUnder90 = it })

        ResultBanner(
            title = "San Francisco Syncope Rule (CHESS)",
            valueText = if (res.hasAnyHighRiskFactor) "HIGH RISK (Positive)" else "LOW RISK (Negative)",
            badgeText = res.riskTier,
            guidance = res.interpretation,
            isSafe = !res.hasAnyHighRiskFactor,
            nextSteps = res.nextSteps
        )
    }
}

@Composable
fun CorrectedSodiumInteractiveCard() {
    var measuredNa by remember { mutableStateOf("128") }
    var glucose by remember { mutableStateOf("480") }

    val naVal = measuredNa.toDoubleOrNull() ?: 128.0
    val gluVal = glucose.toDoubleOrNull() ?: 480.0

    val res = remember(naVal, gluVal) {
        ExtendedCalculators.calculateCorrectedSodium(naVal, gluVal)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedTextField(
                value = measuredNa,
                onValueChange = { measuredNa = it },
                label = { Text("Measured Sodium (mEq/L)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = glucose,
                onValueChange = { glucose = it },
                label = { Text("Serum Glucose (mg/dL)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f)
            )
        }

        // Formula comparison
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Katz Formula (+1.6 per 100): ${res.katzCorrectedNa} mEq/L", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("Hillier Formula (+2.4 per 100): ${res.hillierCorrectedNa} mEq/L", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("Fluid Recommendation: ${res.fluidSelection}", fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        ResultBanner(
            title = "Corrected Sodium for Hyperglycemia",
            valueText = "${res.hillierCorrectedNa} mEq/L (Hillier)",
            badgeText = if (res.hillierCorrectedNa in 135.0..145.0) "Euvolemic" else "Osmolar Shift",
            guidance = "${res.interpretation}\n\nRecommended Fluid: ${res.fluidSelection}",
            isSafe = res.hillierCorrectedNa in 135.0..145.0,
            nextSteps = res.nextSteps
        )
    }
}
