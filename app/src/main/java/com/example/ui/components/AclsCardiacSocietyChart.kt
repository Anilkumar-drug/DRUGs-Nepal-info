package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import kotlinx.coroutines.delay

/**
 * Official Cardiac Society Adult Cardiac Arrest Algorithm Flowchart
 * & Comprehensive ACLS High-Quality CPR Instructions.
 *
 * Designed in compliance with American Heart Association (AHA) Guidelines for CPR & ECC,
 * International Liaison Committee on Resuscitation (ILCOR), and Cardiac Society Consensus.
 */
@Composable
fun AclsCardiacSocietyChartSection(
    modifier: Modifier = Modifier
) {
    var selectedChartTab by remember { mutableStateOf(0) }
    var isMetronomeActive by remember { mutableStateOf(false) }

    // Live 110 BPM CPR Visual Cadence Metronome (Rate 100-120/min target = 110 bpm -> ~545ms per cycle)
    val infiniteTransition = rememberInfiniteTransition(label = "cpr_metronome")
    val metronomeScale by if (isMetronomeActive) {
        infiniteTransition.animateFloat(
            initialValue = 1.0f,
            targetValue = 1.25f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 272, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "cpr_scale"
        )
    } else {
        remember { mutableStateOf(1.0f) }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("acls_cardiac_society_section"),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // =========================================================================
        // SECTION 1: INSTRUCT TO DO CPR AS PER ACLS (HIGH-QUALITY CPR PROTOCOL)
        // =========================================================================
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            border = BorderStroke(1.5.dp, Color(0xFFEF4444)),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("cpr_instructions_card")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Header Banner
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFEF4444).copy(alpha = 0.2f),
                            border = BorderStroke(1.dp, Color(0xFFEF4444)),
                            modifier = Modifier.size(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = Color(0xFFEF4444),
                                    modifier = Modifier
                                        .size(20.dp)
                                        .scale(metronomeScale)
                                )
                            }
                        }
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(
                                    text = "HIGH-QUALITY CPR PROTOCOL",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White,
                                    letterSpacing = 0.5.sp
                                )
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(0xFFEF4444)
                                ) {
                                    Text(
                                        text = "ACLS MANDATORY",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Strict Cardiac Society & AHA Resuscitation Quality Standards",
                                fontSize = 10.5.sp,
                                color = Slate400
                            )
                        }
                    }

                    // 110 BPM Metronome Toggle Button
                    Surface(
                        onClick = { isMetronomeActive = !isMetronomeActive },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isMetronomeActive) Color(0xFF10B981) else Color(0xFF1E293B),
                        border = BorderStroke(1.dp, if (isMetronomeActive) Color(0xFF10B981) else Color(0xFF475569)),
                        modifier = Modifier.testTag("btn_cpr_metronome")
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = if (isMetronomeActive) Icons.Default.VolumeUp else Icons.Default.Timer,
                                contentDescription = null,
                                tint = if (isMetronomeActive) Color.White else Color(0xFF38BDF8),
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = if (isMetronomeActive) "110 BPM ON" else "110 BPM Guide",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isMetronomeActive) Color.White else Color(0xFFE2E8F0)
                            )
                        }
                    }
                }

                // Visual Metronome Pulse Indicator Bar
                if (isMetronomeActive) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF064E3B).copy(alpha = 0.6f),
                        border = BorderStroke(1.dp, Color(0xFF10B981)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .scale(metronomeScale)
                                        .background(Color(0xFF34D399), CircleShape)
                                )
                                Text(
                                    text = "CADENCE BEAT: 110 Compress/Min (Target 100-120)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF6EE7B7)
                                )
                            }
                            Text(
                                text = "Push hard & fast",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFFA7F3D0)
                            )
                        }
                    }
                }

                // Core 6 ACLS CPR Rules Grid
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Rule 1: Rate
                        CprQualityItem(
                            modifier = Modifier.weight(1f),
                            title = "RATE: 100-120 / MIN",
                            desc = "Push at 100-120 bpm cadence. Avoid compressions <100 (inadequate flow) or >120 (poor ventricular filling).",
                            highlight = "100–120 bpm",
                            color = Color(0xFF38BDF8),
                            icon = Icons.Default.Speed
                        )
                        // Rule 2: Depth
                        CprQualityItem(
                            modifier = Modifier.weight(1f),
                            title = "DEPTH: 5-6 CM",
                            desc = "Compress at least 2 inches (5 cm), not exceeding 2.4 inches (6 cm). Adequate depth creates vital coronary perfusion pressure.",
                            highlight = "5 to 6 cm (2-2.4 in)",
                            color = Color(0xFFF59E0B),
                            icon = Icons.Default.VerticalAlignBottom
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Rule 3: Chest Recoil
                        CprQualityItem(
                            modifier = Modifier.weight(1f),
                            title = "FULL RECOIL (NO LEAN)",
                            desc = "Allow complete chest wall recoil between compressions. Leaning prevents negative intrathoracic pressure & coronary refilling.",
                            highlight = "100% Recoil",
                            color = Color(0xFF10B981),
                            icon = Icons.Default.Restore
                        )
                        // Rule 4: Minimize Interruptions
                        CprQualityItem(
                            modifier = Modifier.weight(1f),
                            title = "PAUSES < 10 SECONDS",
                            desc = "Chest Compression Fraction (CCF) > 80%. Never stop compressions for >10s except for mandatory rhythm check / shock delivery.",
                            highlight = "CCF > 80%",
                            color = Color(0xFFEF4444),
                            icon = Icons.Default.PauseCircleFilled
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Rule 5: Ventilations
                        CprQualityItem(
                            modifier = Modifier.weight(1f),
                            title = "VENTILATION RATIO",
                            desc = "• No Advanced Airway: 30:2 ratio (30 compressions, 2 breaths over 1s).\n• Advanced Airway: 1 breath every 6s (10 breaths/min) with continuous compressions.",
                            highlight = "30:2 or 1 q6s",
                            color = Color(0xFFA855F7),
                            icon = Icons.Default.Air
                        )
                        // Rule 6: Rotate & Capnography
                        CprQualityItem(
                            modifier = Modifier.weight(1f),
                            title = "ROTATE & CAPNOGRAPHY",
                            desc = "• Rotate compressor q2m to avoid fatigue.\n• PETCO2 < 10 mmHg: Ineffective CPR.\n• PETCO2 abrupt jump to 35-40 mmHg: ROSC achieved!",
                            highlight = "Rotate q2m • PETCO2",
                            color = Color(0xFF06B6D4),
                            icon = Icons.Default.Sync
                        )
                    }
                }

                // Warning against Hyperventilation
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFF7F1D1D).copy(alpha = 0.35f),
                    border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.6f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color(0xFFEF4444),
                            modifier = Modifier.size(20.dp)
                        )
                        Column {
                            Text(
                                text = "CRITICAL WARNING: AVOID HYPERVENTILATION",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFFFCA5A5)
                            )
                            Text(
                                text = "Excessive ventilation increases intrathoracic pressure, crushes vena caval venous return, drastically decreases cardiac output, and reduces cerebral/coronary perfusion pressure.",
                                fontSize = 10.sp,
                                color = Color(0xFFE2E8F0),
                                lineHeight = 14.sp
                            )
                        }
                    }
                }
            }
        }

        // =========================================================================
        // SECTION 2: OFFICIAL CARDIAC SOCIETY ADULT CARDIAC ARREST ALGORITHM CHART
        // =========================================================================
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            border = BorderStroke(1.5.dp, Color(0xFF38BDF8).copy(alpha = 0.8f)),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("cardiac_society_chart_card")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Section Header with Cardiac Society Branding
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF0284C7).copy(alpha = 0.25f),
                            border = BorderStroke(1.2.dp, Color(0xFF38BDF8)),
                            modifier = Modifier.size(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.AccountTree,
                                    contentDescription = null,
                                    tint = Color(0xFF38BDF8),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(
                                    text = "CARDIAC SOCIETY ACLS CHART",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White,
                                    letterSpacing = 0.5.sp
                                )
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(0xFF0284C7)
                                ) {
                                    Text(
                                        text = "AHA / ILCOR CONSENSUS",
                                        fontSize = 8.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.5.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Adult Cardiac Arrest Official Clinical Algorithm Flowchart",
                                fontSize = 10.5.sp,
                                color = Slate400
                            )
                        }
                    }
                }

                // Chart Sub-Tabs Selector
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    listOf(
                        0 to "🔀 Algorithm Flow",
                        1 to "⚡ Shock vs Non-Shock",
                        2 to "🔍 5 H's & 5 T's",
                        3 to "🩺 ROSC Care"
                    ).forEach { (idx, label) ->
                        val isSelected = selectedChartTab == idx
                        Surface(
                            onClick = { selectedChartTab = idx },
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) Color(0xFF0284C7) else Color(0xFF1E293B),
                            border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155)),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("btn_chart_tab_$idx")
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 7.dp)) {
                                Text(
                                    text = label,
                                    fontSize = 10.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSelected) Color.White else Slate400,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }

                HorizontalDivider(color = Color(0xFF334155))

                // Chart Content Body based on selected tab
                when (selectedChartTab) {
                    0 -> AlgorithmFlowchartView()
                    1 -> ShockableVsNonShockableComparisonView()
                    2 -> HsAndTsReversibleCausesMatrixView()
                    3 -> RoscPostResuscitationCareView()
                }

                // Formal Accreditation Citation Footer
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF0B132B),
                    border = BorderStroke(0.6.dp, Color(0xFF334155)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Verified,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "Reference: American Heart Association (AHA) Guidelines for CPR & ECC, International Liaison Committee on Resuscitation (ILCOR), and Cardiac Society Resuscitation Guidelines.",
                            fontSize = 9.sp,
                            color = Slate400,
                            lineHeight = 13.sp
                        )
                    }
                }
            }
        }
    }
}

// =========================================================================
// SUB-VIEW 1: ALGORITHM FLOWCHART VIEW
// =========================================================================
@Composable
private fun AlgorithmFlowchartView() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Step 1: Initial Presentation
        FlowchartNodeCard(
            stepNumber = "1",
            title = "CARDIAC ARREST RECOGNITION",
            subtitle = "Unresponsive • Absent or abnormal breathing (agonal gasps) • No carotid pulse ≤ 10s",
            badge = "STEP 1: ACTIVATE",
            badgeColor = Color(0xFFEF4444),
            borderColor = Color(0xFFEF4444),
            actionText = "Shout for help • Call CODE BLUE / Emergency Team • Retrieve Defibrillator & Bag-Mask"
        )

        FlowchartConnector(label = "Simultaneously")

        // Step 2: CPR Initiation
        FlowchartNodeCard(
            stepNumber = "2",
            title = "COMMENCE HIGH-QUALITY CPR",
            subtitle = "Push hard (5-6 cm) and fast (100-120 bpm) • Full recoil • Minimize pauses",
            badge = "STEP 2: CPR",
            badgeColor = Color(0xFF38BDF8),
            borderColor = Color(0xFF0284C7),
            actionText = "Provide Oxygen • Attach Monitor / Defibrillator Pads • Establish IV or IO access"
        )

        FlowchartConnector(label = "Attach Monitor & Analyze Rhythm")

        // Decision Diamond: Is Rhythm Shockable?
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF1E293B),
            border = BorderStroke(1.5.dp, Color(0xFFF59E0B)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(Icons.Default.HelpOutline, contentDescription = null, tint = Color(0xFFF59E0B), modifier = Modifier.size(18.dp))
                    Text(
                        text = "RHYTHM CHECK: IS RHYTHM SHOCKABLE?",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFFDE68A)
                    )
                }
                Text(
                    text = "Pause compressions <5 seconds solely to assess rhythm on monitor",
                    fontSize = 10.sp,
                    color = Slate300
                )
            }
        }

        // Two Parallel Branches: Left = Shockable, Right = Non-Shockable
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // LEFT COLUMN: SHOCKABLE (VF / pVT)
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF7F1D1D).copy(alpha = 0.5f),
                    border = BorderStroke(1.dp, Color(0xFFEF4444)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("⚡ SHOCKABLE", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Color(0xFFFCA5A5))
                        Text("VF / Pulseless VT", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }

                AlgorithmStepBox(
                    step = "1",
                    header = "DELIVER SHOCK 1",
                    detail = "Biphasic 120-200 J (or max)\nMonophasic 360 J",
                    accentColor = Color(0xFFEF4444)
                )

                AlgorithmStepBox(
                    step = "2",
                    header = "CPR 2 MINUTES",
                    detail = "Resume CPR immediately post-shock without pulse check. Establish IV/IO access.",
                    accentColor = Color(0xFF38BDF8)
                )

                AlgorithmStepBox(
                    step = "3",
                    header = "SHOCK 2 + EPINEPHRINE",
                    detail = "Deliver Shock 2 -> Resume CPR 2 min -> Give Epinephrine 1 mg IV/IO q3-5m.",
                    accentColor = Color(0xFFF59E0B)
                )

                AlgorithmStepBox(
                    step = "4",
                    header = "SHOCK 3 + AMIODARONE",
                    detail = "Deliver Shock 3 -> Resume CPR 2 min -> Give Amiodarone 300 mg IV push (or Lidocaine 1-1.5 mg/kg).",
                    accentColor = Color(0xFFA855F7)
                )

                AlgorithmStepBox(
                    step = "5",
                    header = "REFRACTORY VF CYCLES",
                    detail = "Shock 4+ -> CPR 2m -> Amiodarone 150 mg (2nd dose) -> Treat 5 H's & 5 T's.",
                    accentColor = Color(0xFFEC4899)
                )
            }

            // RIGHT COLUMN: NON-SHOCKABLE (Asystole / PEA)
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF451A03).copy(alpha = 0.5f),
                    border = BorderStroke(1.dp, Color(0xFFF59E0B)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("🛑 NON-SHOCKABLE", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Color(0xFFFDE68A))
                        Text("Asystole / PEA", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }

                AlgorithmStepBox(
                    step = "1",
                    header = "DO NOT SHOCK",
                    detail = "Defibrillation is ineffective and damaging in asystole/PEA.",
                    accentColor = Color(0xFF94A3B8)
                )

                AlgorithmStepBox(
                    step = "2",
                    header = "EPINEPHRINE ASAP",
                    detail = "Give Epinephrine 1 mg IV/IO immediately upon rhythm identification.",
                    accentColor = Color(0xFFF59E0B)
                )

                AlgorithmStepBox(
                    step = "3",
                    header = "CPR 2 MINUTES",
                    detail = "Resume continuous CPR 2 min. Consider advanced airway & capnography.",
                    accentColor = Color(0xFF38BDF8)
                )

                AlgorithmStepBox(
                    step = "4",
                    header = "RE-CHECK RHYTHM",
                    detail = "If shockable -> Switch to VF/VT branch.\nIf non-shockable -> CPR 2 min + Epinephrine q3-5m.",
                    accentColor = Color(0xFF06B6D4)
                )

                AlgorithmStepBox(
                    step = "5",
                    header = "SEARCH 5 H's & 5 T's",
                    detail = "Survival depends entirely on identifying and reversing underlying cause.",
                    accentColor = Color(0xFF10B981)
                )
            }
        }
    }
}

// =========================================================================
// SUB-VIEW 2: SHOCKABLE VS NON-SHOCKABLE COMPARISON VIEW
// =========================================================================
@Composable
private fun ShockableVsNonShockableComparisonView() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Shockable Pathway Card
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.2.dp, Color(0xFFEF4444).copy(alpha = 0.7f))
        ) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.ElectricBolt, contentDescription = null, tint = Color(0xFFEF4444), modifier = Modifier.size(18.dp))
                    Text(
                        text = "SHOCKABLE RHYTHMS: VF & PULSELESS VT",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFFCA5A5)
                    )
                }
                Text(
                    text = "• Defibrillation Energy: Biphasic initial dose 120-200 J (or manufacturer recommendation); subsequent doses equivalent or higher. Monophasic: 360 J.\n" +
                           "• Shock Delivery Protocol: Deliver shock -> IMMEDIATELY resume CPR 2 minutes without stopping for pulse check -> After 2 minutes CPR, check rhythm.\n" +
                           "• Vasopressor: Epinephrine 1 mg IV/IO every 3-5 minutes (given after 2nd shock during CPR).\n" +
                           "• Antiarrhythmic Therapy: Amiodarone 300 mg IV push after 3rd shock (diluted in 20-30 mL D5W); second dose 150 mg after 5th shock. OR Lidocaine 1-1.5 mg/kg initial bolus, then 0.5-0.75 mg/kg.\n" +
                           "• Torsades de Pointes (Polymorphic VT): Magnesium Sulfate 1 to 2 g IV/IO over 15 minutes.",
                    fontSize = 11.sp,
                    color = Color(0xFFE2E8F0),
                    lineHeight = 16.sp
                )
            }
        }

        // Non-Shockable Pathway Card
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.2.dp, Color(0xFFF59E0B).copy(alpha = 0.7f))
        ) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.Block, contentDescription = null, tint = Color(0xFFF59E0B), modifier = Modifier.size(18.dp))
                    Text(
                        text = "NON-SHOCKABLE RHYTHMS: ASYSTOLE & PEA",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFFDE68A)
                    )
                }
                Text(
                    text = "• Immediate Rule: NEVER shock asystole or PEA. Shocks deliver myocardial stun and eliminate chance of recovery.\n" +
                           "• Early Epinephrine: Give Epinephrine 1 mg IV/IO immediately upon identifying rhythm. Early epinephrine (<5 min) significantly increases ROSC and survival in non-shockable arrest.\n" +
                           "• Continuous Cycles: 2 minutes of uninterrupted CPR -> rapid rhythm check (<5s) -> if unchanged, resume CPR 2 min and repeat Epinephrine every 3-5 minutes.\n" +
                           "• Search for Reversible Etiology: PEA/Asystole is almost always caused by an underlying physiological disturbance (severe hypoxia, hypovolemia, tension pneumo, hyperkalemia, or pulmonary embolism). Actively correct them!",
                    fontSize = 11.sp,
                    color = Color(0xFFE2E8F0),
                    lineHeight = 16.sp
                )
            }
        }
    }
}

// =========================================================================
// SUB-VIEW 3: 5 H'S & 5 T'S (REVERSIBLE CAUSES MATRIX)
// =========================================================================
@Composable
private fun HsAndTsReversibleCausesMatrixView() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "REVERSIBLE CAUSES OF CARDIAC ARREST (5 H'S & 5 T'S)",
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Black,
            color = Color(0xFF38BDF8)
        )

        // 5 H's Card
        Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("THE 5 H'S (Physiological Disturbances):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                listOf(
                    "Hypovolemia" to "Rapid IV crystalloid bolus (20-30 mL/kg NS/RL), blood transfusion, control active bleeding.",
                    "Hypoxia" to "100% Oxygen, bag-valve-mask with good seal, secure advanced airway (ETT/LMA), verify bilateral breath sounds.",
                    "Hydrogen Ion (Acidosis)" to "Adequate hyperventilation to blow off CO2, Sodium Bicarbonate 1 mEq/kg IV if severe metabolic acidosis / prolonged arrest.",
                    "Hypo- / Hyperkalemia" to "HyperK: Calcium Gluconate 10% 10-20 mL IV, Regular Insulin 10U + 50% Dextrose 50 mL, Salbutamol. HypoK: Magnesium 2g + IV Potassium.",
                    "Hypothermia" to "Active internal & external rewarming (warm IV fluids, forced air blankets). Resuscitate until warm (>35°C)."
                ).forEach { (h, rx) ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("• $h:", fontWeight = FontWeight.Bold, fontSize = 10.5.sp, color = Color.White, modifier = Modifier.width(135.dp))
                        Text(rx, fontSize = 10.sp, color = Slate300, modifier = Modifier.weight(1f), lineHeight = 13.5.sp)
                    }
                }
            }
        }

        // 5 T's Card
        Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("THE 5 T'S (Mechanical & Toxic Insults):", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFCA5A5))
                listOf(
                    "Tension Pneumothorax" to "Immediate needle thoracostomy decompression (2nd ICS midclavicular or 5th ICS midaxillary), followed by chest tube.",
                    "Tamponade (Cardiac)" to "Immediate subxiphoid pericardiocentesis under ultrasound guidance or emergency thoracotomy.",
                    "Toxins (Overdose)" to "Specific antidotes: Naloxone (opioids), Calcium/Glucagon (CCB/beta-blockers), Digibind (digoxin), Sodium Bicarb (TCAs).",
                    "Thrombosis (Pulmonary PE)" to "Massive PE: Systemic thrombolysis (Alteplase/tPA 50 mg IV push; continue CPR for at least 60-90 min).",
                    "Thrombosis (Coronary MI)" to "Emergent transfer to Cath Lab for Primary Percutaneous Coronary Intervention (PCI) / E-CPR."
                ).forEach { (t, rx) ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("• $t:", fontWeight = FontWeight.Bold, fontSize = 10.5.sp, color = Color.White, modifier = Modifier.width(135.dp))
                        Text(rx, fontSize = 10.sp, color = Slate300, modifier = Modifier.weight(1f), lineHeight = 13.5.sp)
                    }
                }
            }
        }
    }
}

// =========================================================================
// SUB-VIEW 4: ROSC & POST-RESUSCITATION CARE
// =========================================================================
@Composable
private fun RoscPostResuscitationCareView() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Recognition of ROSC Card
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFF064E3B).copy(alpha = 0.5f),
            border = BorderStroke(1.2.dp, Color(0xFF10B981)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF34D399), modifier = Modifier.size(18.dp))
                    Text(
                        text = "RETURN OF SPONTANEOUS CIRCULATION (ROSC) CRITERIA",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFA7F3D0)
                    )
                }
                Text(
                    text = "1. Definite pulse and measurable arterial blood pressure.\n" +
                           "2. Abrupt sustained rise in PETCO2 (typically jumps to ≥ 35 to 40 mmHg).\n" +
                           "3. Spontaneous arterial pressure waveform on arterial line monitor.",
                    fontSize = 10.5.sp,
                    color = Color.White,
                    lineHeight = 15.sp
                )
            }
        }

        // Post-Cardiac Arrest Care Protocol
        Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF334155))
        ) {
            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("ACLS POST-CARDIAC ARREST SYSTEMATIC CARE:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                Text(
                    text = "• Airway & Ventilation: Maintain SpO2 92-98% (avoid hyperoxia); PaCO2 35-45 mmHg (avoid hyper/hypocapnia).\n" +
                           "• Hemodynamic Optimization: Target Mean Arterial Pressure (MAP) ≥ 65 mmHg and SBP ≥ 90 mmHg. Infuse Norepinephrine (0.1-0.5 mcg/kg/min) or Epinephrine.\n" +
                           "• 12-Lead ECG Immediately: If STEMI or high suspicion of acute coronary ischemia -> immediate Cath Lab for Coronary Angiography & PCI.\n" +
                           "• Targeted Temperature Management (TTM): Maintain constant temperature between 32°C and 36°C for 24 hours in all comatose patients.\n" +
                           "• Metabolic & Neuro Monitoring: Maintain normoglycemia (140-180 mg/dL); treat seizures with levetiracetam/propofol; delay neuroprognostication until at least 72 hours post-TTM.",
                    fontSize = 10.5.sp,
                    color = Color(0xFFE2E8F0),
                    lineHeight = 16.sp
                )
            }
        }
    }
}

// =========================================================================
// HELPER COMPOSABLES
// =========================================================================

@Composable
private fun CprQualityItem(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    highlight: String,
    color: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, color.copy(alpha = 0.5f)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(9.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(15.dp))
                Text(
                    text = title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Black,
                    color = color,
                    maxLines = 1
                )
            }
            Text(
                text = desc,
                fontSize = 9.5.sp,
                color = Slate300,
                lineHeight = 13.5.sp
            )
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = color.copy(alpha = 0.15f)
            ) {
                Text(
                    text = highlight,
                    fontSize = 8.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = color,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }
        }
    }
}

@Composable
private fun FlowchartNodeCard(
    stepNumber: String,
    title: String,
    subtitle: String,
    badge: String,
    badgeColor: Color,
    borderColor: Color,
    actionText: String
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(1.2.dp, borderColor),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = badgeColor,
                modifier = Modifier.size(28.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(stepNumber, fontWeight = FontWeight.Black, color = Color.White, fontSize = 12.sp)
                }
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(title, fontWeight = FontWeight.Black, fontSize = 11.5.sp, color = Color.White)
                    Surface(shape = RoundedCornerShape(4.dp), color = badgeColor.copy(alpha = 0.2f)) {
                        Text(badge, fontSize = 8.sp, fontWeight = FontWeight.Bold, color = badgeColor, modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp))
                    }
                }
                Text(subtitle, fontSize = 9.5.sp, color = Slate400)
                Text(actionText, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8), lineHeight = 13.sp)
            }
        }
    }
}

@Composable
private fun FlowchartConnector(label: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(2.dp)
                .height(10.dp)
                .background(Color(0xFF475569))
        )
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFF334155),
            modifier = Modifier.padding(vertical = 1.dp)
        ) {
            Text(
                text = "▼ $label",
                fontSize = 8.5.sp,
                fontWeight = FontWeight.Bold,
                color = Slate200,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
        Box(
            modifier = Modifier
                .width(2.dp)
                .height(10.dp)
                .background(Color(0xFF475569))
        )
    }
}

@Composable
private fun AlgorithmStepBox(
    step: String,
    header: String,
    detail: String,
    accentColor: Color
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.6f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(7.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Surface(
                    shape = CircleShape,
                    color = accentColor,
                    modifier = Modifier.size(16.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(step, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
                Text(header, fontSize = 10.sp, fontWeight = FontWeight.Black, color = accentColor)
            }
            Text(detail, fontSize = 9.sp, color = Color(0xFFCBD5E1), lineHeight = 12.5.sp)
        }
    }
}
