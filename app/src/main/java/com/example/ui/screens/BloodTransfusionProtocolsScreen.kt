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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.TransfusionReactionProtocol
import com.example.data.model.TransfusionTriggerGuideline
import com.example.data.repository.BloodTransfusionProtocolsData
import com.example.ui.theme.*
import kotlin.math.max

enum class TransfusionScreenTab(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    EMERGENCY_UNCROSSED("Uncrossed & Emergent", Icons.Default.Bloodtype),
    MTP_PROTOCOL("Massive Transfusion (MTP)", Icons.Default.Warning),
    THRESHOLDS_DOSING("Thresholds & Dosing", Icons.Default.Analytics),
    REACTIONS_ALGORITHM("Reaction Emergency", Icons.Default.MedicalServices)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BloodTransfusionProtocolsScreen(
    onBackClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(TransfusionScreenTab.EMERGENCY_UNCROSSED) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "Blood Transfusion & MTP",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFFDC2626).copy(alpha = 0.2f),
                                border = BorderStroke(1.dp, Color(0xFFDC2626))
                            ) {
                                Text(
                                    text = "1:1:1 Ratio",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFCA5A5),
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Emergency Uncrossed, MTP, Triggers & Acute Reactions",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("blood_transfusion_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0F172A)
                )
            )
        },
        containerColor = Color(0xFF080F1E)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Horizontal Tab Bar
            ScrollableTabRow(
                selectedTabIndex = selectedTab.ordinal,
                containerColor = Color(0xFF0F172A),
                contentColor = Color.White,
                edgePadding = 12.dp,
                divider = {}
            ) {
                TransfusionScreenTab.values().forEach { tab ->
                    Tab(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (selectedTab == tab) Color(0xFFEF4444) else Slate400
                                )
                                Text(
                                    text = tab.label,
                                    fontWeight = if (selectedTab == tab) FontWeight.Bold else FontWeight.Normal,
                                    color = if (selectedTab == tab) Color(0xFFEF4444) else Slate400,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    )
                }
            }

            // Screen Content
            when (selectedTab) {
                TransfusionScreenTab.EMERGENCY_UNCROSSED -> EmergencyUncrossedTabContent()
                TransfusionScreenTab.MTP_PROTOCOL -> MtpProtocolTabContent()
                TransfusionScreenTab.THRESHOLDS_DOSING -> ThresholdsAndDosingTabContent()
                TransfusionScreenTab.REACTIONS_ALGORITHM -> ReactionsAlgorithmTabContent()
            }
        }
    }
}

// ==========================================
// 1. EMERGENCY UNCROSSED TAB CONTENT
// ==========================================
@Composable
private fun EmergencyUncrossedTabContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF450A0A),
                border = BorderStroke(1.5.dp, Color(0xFFDC2626)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bloodtype,
                            contentDescription = null,
                            tint = Color(0xFFF87171),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "EMERGENCY UNCROSSED BLOOD PRINCIPLES",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }
                    Text(
                        text = "When hemorrhagic shock is immediately life-threatening (SBP <70 mmHg, severe trauma, massive PPH), DO NOT WAIT for full crossmatch. Order uncrossed red cells via emergency release protocol.",
                        fontSize = 12.sp,
                        color = Color(0xFFFECACA),
                        modifier = Modifier.padding(top = 6.dp),
                        lineHeight = 16.sp
                    )
                }
            }
        }

        items(BloodTransfusionProtocolsData.emergencyUncrossedRules) { rule ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF101B2E),
                border = BorderStroke(1.dp, Color(0xFF1E293B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = rule,
                    fontSize = 12.sp,
                    color = Color(0xFFE2E8F0),
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(14.dp)
                )
            }
        }

        item {
            // Blood compatibility quick matrix card
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F243A),
                border = BorderStroke(1.dp, Color(0xFF0284C7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "📋 Compatibility Matrix at a Glance",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("• Red Cells (PRBC): O is Universal Donor; AB is Universal Recipient.", fontSize = 12.sp, color = Color.White)
                    Text("• Plasma (FFP): AB is Universal Donor (no anti-A/B antibodies); O is Universal Recipient.", fontSize = 12.sp, color = Color.White)
                    Text("• Platelets: ABO identical preferred. RhD-negative females must receive RhD-negative platelets or Anti-D prophylaxis (RhIG) if Rh+ platelets given.", fontSize = 12.sp, color = Color.White)
                    Text("• Cryoprecipitate: Any ABO group can usually be given safely due to minimal antibody volume.", fontSize = 12.sp, color = Color.White)
                }
            }
        }
    }
}

// ==========================================
// 2. MASSIVE TRANSFUSION (MTP) TAB CONTENT
// ==========================================
@Composable
private fun MtpProtocolTabContent() {
    // ABC Score interactive checker
    var penetratingTrauma by remember { mutableStateOf(false) }
    var sbpBelow90 by remember { mutableStateOf(false) }
    var hrAbove120 by remember { mutableStateOf(false) }
    var fastPositive by remember { mutableStateOf(false) }

    val abcScore = (if (penetratingTrauma) 1 else 0) +
            (if (sbpBelow90) 1 else 0) +
            (if (hrAbove120) 1 else 0) +
            (if (fastPositive) 1 else 0)

    val mtpRecommended = abcScore >= 2

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // MTP Definition
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF131D31),
            border = BorderStroke(1.dp, Color(0xFF223555))
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "Massive Transfusion Definition",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Amber400
                )
                Text(
                    text = BloodTransfusionProtocolsData.mtpDefinition,
                    fontSize = 12.sp,
                    color = Color(0xFFCBD5E1),
                    modifier = Modifier.padding(top = 4.dp),
                    lineHeight = 16.sp
                )
            }
        }

        // ABC Score Interactive Card
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = Color(0xFF101B2E),
            border = BorderStroke(1.5.dp, if (mtpRecommended) Color(0xFFDC2626) else Color(0xFF0284C7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ABC Score for MTP Activation",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = if (mtpRecommended) Color(0xFFDC2626) else Color(0xFF0284C7)
                    ) {
                        Text(
                            text = "Score: $abcScore / 4",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }

                Text(
                    text = if (mtpRecommended) "🚨 SCORE ≥ 2: ACTIVATE MASSIVE TRANSFUSION PROTOCOL IMMEDIATELY!" else "Score < 2: MTP not triggered; monitor hemodynamics closely.",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (mtpRecommended) Color(0xFFFCA5A5) else Emerald400,
                    modifier = Modifier.padding(vertical = 6.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Checklist Items
                AbcCheckItem("Penetrating torso mechanism", penetratingTrauma) { penetratingTrauma = it }
                AbcCheckItem("Emergency SBP ≤ 90 mmHg on arrival", sbpBelow90) { sbpBelow90 = it }
                AbcCheckItem("Heart rate ≥ 120 beats/min (tachycardia)", hrAbove120) { hrAbove120 = it }
                AbcCheckItem("Positive FAST ultrasound for free peritoneal fluid", fastPositive) { fastPositive = it }
            }
        }

        // MTP Pack Breakdown (Stages 1, 2, 3)
        Text(
            text = "Balanced 1:1:1 Pack Workflow",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        BloodTransfusionProtocolsData.mtpPackStages.forEach { stage ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF131D31),
                border = BorderStroke(1.dp, Color(0xFF223555)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = stage.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // 1:1:1 Components Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        ComponentChip("PRBC", "${stage.prbcUnits} Units", Color(0xFFDC2626), Modifier.weight(1f))
                        ComponentChip("FFP", "${stage.ffpUnits} Units", Color(0xFFEAB308), Modifier.weight(1f))
                        ComponentChip("Platelets", "1 Adult Pool", Color(0xFF10B981), Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Cryoprecipitate: " + stage.cryoprecipitateUnits, fontSize = 11.sp, color = Amber400)

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("Adjunctive Resuscitation:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
                    stage.adjunctiveTherapy.forEach { adj ->
                        Text("• $adj", fontSize = 11.sp, color = Color(0xFFE2E8F0))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("Lethal Triad Resuscitation Targets:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Emerald400)
                    stage.monitoringTargets.forEach { tgt ->
                        Text("• $tgt", fontSize = 11.sp, color = Color(0xFFCBD5E1))
                    }
                }
            }
        }
    }
}

@Composable
private fun AbcCheckItem(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = 12.sp, color = Color(0xFFE2E8F0), modifier = Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFFDC2626), uncheckedColor = Slate400)
        )
    }
}

@Composable
private fun ComponentChip(label: String, amount: String, color: Color, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = color.copy(alpha = 0.15f),
        border = BorderStroke(1.dp, color),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = color)
            Text(amount, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

// ==========================================
// 3. THRESHOLDS & DOSING TAB CONTENT
// ==========================================
@Composable
private fun ThresholdsAndDosingTabContent() {
    // PRBC Calculator states
    var patientWeightText by remember { mutableStateOf("60") }
    var currentHbText by remember { mutableStateOf("5.5") }
    var targetHbText by remember { mutableStateOf("7.5") }

    val weightKg = patientWeightText.toDoubleOrNull() ?: 60.0
    val currentHb = currentHbText.toDoubleOrNull() ?: 5.5
    val targetHb = targetHbText.toDoubleOrNull() ?: 7.5

    // Standard rule: 1 unit PRBC raises Hb by ~1.0 g/dL (or Hct by 3%) in a 70kg adult.
    // Dosing: Units = (Target Hb - Current Hb) * (Weight / 70)
    val deltaHb = max(0.0, targetHb - currentHb)
    val estimatedUnits = if (deltaHb > 0) "%.1f".format(deltaHb * (weightKg / 70.0)) else "0.0"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Interactive PRBC Unit Estimator
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = Color(0xFF131D31),
            border = BorderStroke(1.dp, Color(0xFF0284C7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "🩸 PRBC Unit Deficit Calculator",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                )
                Text(
                    text = "Estimates units needed based on patient mass and target hemoglobin delta.",
                    fontSize = 11.sp,
                    color = Slate400,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Weight (kg):", fontSize = 11.sp, color = Slate400)
                        OutlinedTextField(
                            value = patientWeightText,
                            onValueChange = { patientWeightText = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 12.sp, color = Color.White),
                            modifier = Modifier.fillMaxWidth().height(48.dp)
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Current Hb (g/dL):", fontSize = 11.sp, color = Slate400)
                        OutlinedTextField(
                            value = currentHbText,
                            onValueChange = { currentHbText = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 12.sp, color = Color.White),
                            modifier = Modifier.fillMaxWidth().height(48.dp)
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Target Hb (g/dL):", fontSize = 11.sp, color = Slate400)
                        OutlinedTextField(
                            value = targetHbText,
                            onValueChange = { targetHbText = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 12.sp, color = Color.White),
                            modifier = Modifier.fillMaxWidth().height(48.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF0F243A),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Estimated PRBC Requirement:", fontSize = 12.sp, color = Slate400)
                            Text("Prescribe 1 unit at a time in non-bleeding patients", fontSize = 10.sp, color = Emerald400)
                        }
                        Text(
                            text = "$estimatedUnits Units",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFF87171)
                        )
                    }
                }
            }
        }

        // Transfusion Guidelines List
        Text(
            text = "Evidence-Based Transfusion Triggers",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        BloodTransfusionProtocolsData.transfusionTriggers.forEach { guide ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF101B2E),
                border = BorderStroke(1.dp, Color(0xFF1E293B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = guide.patientCategory,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFDC2626).copy(alpha = 0.15f),
                            border = BorderStroke(1.dp, Color(0xFFDC2626)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("Trigger Level", fontSize = 10.sp, color = Color(0xFFFCA5A5))
                                Text(guide.triggerThreshold, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Emerald400.copy(alpha = 0.15f),
                            border = BorderStroke(1.dp, Emerald400),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("Target Goal", fontSize = 10.sp, color = Emerald400)
                                Text(guide.targetLevel, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "🔬 Trial Evidence: ${guide.trialEvidence}",
                        fontSize = 11.sp,
                        color = Color(0xFF94A3B8),
                        lineHeight = 15.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "💡 Clinical Rule: ${guide.specialConsiderations}",
                        fontSize = 11.sp,
                        color = Color(0xFFBAE6FD),
                        lineHeight = 15.sp
                    )
                }
            }
        }
    }
}

// ==========================================
// 4. TRANSFUSION REACTIONS TAB CONTENT
// ==========================================
@Composable
private fun ReactionsAlgorithmTabContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Immediate 6-Step STOP Protocol Banner
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF450A0A),
                border = BorderStroke(1.5.dp, Color(0xFFDC2626)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "🚨 IMMEDIATE BEDSIDE EMERGENCY 'STOP' PROTOCOL",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    BloodTransfusionProtocolsData.immediateReactionSteps.forEach { step ->
                        Text(
                            text = step,
                            fontSize = 11.sp,
                            color = Color(0xFFFECACA),
                            lineHeight = 15.sp,
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }
                }
            }
        }

        // TRALI vs TACO High-Yield Clinical Distinction Card
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F243A),
                border = BorderStroke(1.dp, Color(0xFF0284C7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "⚖️ TRALI vs TACO Bedside Differentiation",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("• Blood Pressure: TACO = Severe Hypertension; TRALI = Hypotension.", fontSize = 11.sp, color = Color.White)
                    Text("• Jugular Venous Pressure: TACO = Elevated JVP; TRALI = Normal/Low JVP.", fontSize = 11.sp, color = Color.White)
                    Text("• Serum BNP / NT-proBNP: TACO = Significantly Elevated (>1.5x); TRALI = Normal/Mild.", fontSize = 11.sp, color = Color.White)
                    Text("• Response to Diuretics: TACO = Rapid improvement with Furosemide; TRALI = Diuretics ineffective/harmful.", fontSize = 11.sp, color = Color.White)
                    Text("• Lung Edema Mechanism: TACO = Hydrostatic volume overload; TRALI = Immune capillary alveolar leak.", fontSize = 11.sp, color = Color.White)
                }
            }
        }

        // Reaction Protocols List
        items(BloodTransfusionProtocolsData.reactionProtocols) { rxn ->
            ReactionProtocolCard(protocol = rxn)
        }
    }
}

@Composable
private fun ReactionProtocolCard(protocol: TransfusionReactionProtocol) {
    var isExpanded by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF101B2E),
        border = BorderStroke(1.dp, if (protocol.severityLevel.contains("Life-Threatening")) Color(0xFFDC2626) else Color(0xFF1E293B)),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = if (protocol.severityLevel.contains("Life-Threatening")) Color(0xFFDC2626).copy(alpha = 0.2f) else Amber400.copy(alpha = 0.2f)
                ) {
                    Text(
                        text = protocol.severityLevel,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (protocol.severityLevel.contains("Life-Threatening")) Color(0xFFFCA5A5) else Amber400,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                Text(
                    text = if (isExpanded) "Less ▲" else "Action Plan ▼",
                    fontSize = 11.sp,
                    color = Slate400
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = protocol.reactionName,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "⚡ Immediate Action: " + protocol.immediateStep1Action,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Emerald400
            )

            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 10.dp)) {
                    HorizontalDivider(color = Color(0xFF1E293B), modifier = Modifier.padding(vertical = 6.dp))

                    Text("Clinical Features:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
                    protocol.clinicalPresentation.forEach { pres ->
                        Text("• $pres", fontSize = 11.sp, color = Color(0xFFCBD5E1))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("Pharmacotherapy & Resuscitation:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                    protocol.pharmacotherapy.forEach { rx ->
                        Text("• $rx", fontSize = 11.sp, color = Color(0xFFE2E8F0))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("Laboratory Investigations to Send:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Amber400)
                    protocol.laboratoryInvestigations.forEach { lab ->
                        Text("• $lab", fontSize = 11.sp, color = Color(0xFFE2E8F0))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "🛡️ Future Transfusion Prevention: " + protocol.futurePrevention,
                        fontSize = 11.sp,
                        color = Color(0xFFBAE6FD)
                    )
                }
            }
        }
    }
}
