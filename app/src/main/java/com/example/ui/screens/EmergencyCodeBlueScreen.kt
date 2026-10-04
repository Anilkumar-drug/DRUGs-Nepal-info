package com.example.ui.screens

import android.os.SystemClock
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import java.util.Locale

@Composable
fun EmergencyCodeBlueScreen(
    onBackClick: () -> Unit,
    onOpenCriticalCare: (() -> Unit)? = null
) {
    var isTimerRunning by remember { mutableStateOf(false) }
    var totalSecondsElapsed by remember { mutableStateOf(0) }
    var cprCycleSeconds by remember { mutableStateOf(0) }
    var adrenalineSeconds by remember { mutableStateOf(0) }
    var adrenalineDosesGiven by remember { mutableStateOf(0) }
    var shocksDelivered by remember { mutableStateOf(0) }

    // Resuscitation clock timer
    LaunchedEffect(isTimerRunning) {
        while (isTimerRunning) {
            delay(1000L)
            totalSecondsElapsed++
            cprCycleSeconds++
            adrenalineSeconds++
        }
    }

    // Active sub-mode: "ACLS Cardiac Arrest", "Anaphylaxis Shock", "Pediatric Resuscitation", "H's & T's"
    var selectedEmergencyMode by remember { mutableStateOf("ACLS") }

    Scaffold(
        containerColor = Color(0xFF030712), // Deep pitch black for emergency contrast
        topBar = {
            Surface(
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f))
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
                                    text = "EMERGENCY RESUSCITATION",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 15.sp,
                                    color = Color(0xFFEF4444),
                                    letterSpacing = 0.5.sp
                                )
                                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFEF4444).copy(alpha = 0.2f)) {
                                    Text(
                                        text = "FAST MODE",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFFCA5A5),
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "ACLS Cycle Timers • Anaphylaxis • Pediatric Resus Tape",
                                fontSize = 10.5.sp,
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
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Top Emergency Mode Selector Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                listOf(
                    "ACLS" to "⚡ ACLS Arrest",
                    "ANAPHYLAXIS" to "🐝 Anaphylaxis",
                    "PEDIATRIC" to "👶 Peds Resus",
                    "HT" to "🔍 H's & T's"
                ).forEach { (id, label) ->
                    val isSel = selectedEmergencyMode == id
                    Surface(
                        onClick = { selectedEmergencyMode = id },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isSel) Color(0xFFEF4444) else Color(0xFF1E293B),
                        border = BorderStroke(1.dp, if (isSel) Color(0xFFEF4444) else Color(0xFF334155)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 8.dp)) {
                            Text(
                                text = label,
                                fontSize = 10.sp,
                                fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSel) Color.White else Slate400,
                                maxLines = 1
                            )
                        }
                    }
                }
            }

            when (selectedEmergencyMode) {
                "ACLS" -> AclsArrestTimerView(
                    isTimerRunning = isTimerRunning,
                    totalSeconds = totalSecondsElapsed,
                    cprSeconds = cprCycleSeconds,
                    adrenalineSeconds = adrenalineSeconds,
                    adrenalineCount = adrenalineDosesGiven,
                    shockCount = shocksDelivered,
                    onToggleTimer = { isTimerRunning = !isTimerRunning },
                    onResetCprCycle = { cprCycleSeconds = 0 },
                    onAdrenalineGiven = {
                        adrenalineDosesGiven++
                        adrenalineSeconds = 0
                    },
                    onDeliverShock = { shocksDelivered++ },
                    onResetAll = {
                        isTimerRunning = false
                        totalSecondsElapsed = 0
                        cprCycleSeconds = 0
                        adrenalineSeconds = 0
                        adrenalineDosesGiven = 0
                        shocksDelivered = 0
                    }
                )

                "ANAPHYLAXIS" -> AnaphylaxisShockView()

                "PEDIATRIC" -> PediatricResusTapeView()

                "HT" -> HsAndTsChecklistView()
            }
        }
    }
}

@Composable
private fun AclsArrestTimerView(
    isTimerRunning: Boolean,
    totalSeconds: Int,
    cprSeconds: Int,
    adrenalineSeconds: Int,
    adrenalineCount: Int,
    shockCount: Int,
    onToggleTimer: () -> Unit,
    onResetCprCycle: () -> Unit,
    onAdrenalineGiven: () -> Unit,
    onDeliverShock: () -> Unit,
    onResetAll: () -> Unit
) {
    fun formatTime(sec: Int): String {
        val m = sec / 60
        val s = sec % 60
        return String.format(Locale.US, "%02d:%02d", m, s)
    }

    val isCprDue = cprSeconds >= 120 // 2 minutes cycle
    val isAdrenalineDue = adrenalineSeconds >= 180 // 3 minutes

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 60.dp)
    ) {
        // Master Timer Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF111827)),
                border = BorderStroke(1.2.dp, if (isTimerRunning) Color(0xFF10B981) else Color(0xFF374151))
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "TOTAL CODE DURATION",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate400,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = formatTime(totalSeconds),
                        fontFamily = FontFamily.Monospace,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = onToggleTimer,
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isTimerRunning) Color(0xFFEF4444) else Color(0xFF10B981)
                            )
                        ) {
                            Icon(if (isTimerRunning) Icons.Default.Pause else Icons.Default.PlayArrow, contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (isTimerRunning) "PAUSE RESUS" else "START RESUS")
                        }

                        OutlinedButton(
                            onClick = onResetAll,
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color(0xFF4B5563))
                        ) {
                            Text("Reset", color = Color(0xFF9CA3AF))
                        }
                    }
                }
            }
        }

        // Two Cycle Alert Boxes (CPR 2-min & Adrenaline 3-min)
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // CPR 2-Minute Cycle
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isCprDue) Color(0xFF7F1D1D) else Color(0xFF1F2937),
                    border = BorderStroke(1.2.dp, if (isCprDue) Color(0xFFEF4444) else Color(0xFF374151)),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = if (isCprDue) "⚠️ RHYTHM CHECK NOW" else "CPR CYCLE (2 MIN)",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Black,
                            color = if (isCprDue) Color(0xFFFCA5A5) else Color(0xFF38BDF8)
                        )
                        Text(
                            text = formatTime(cprSeconds),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Button(
                            onClick = onResetCprCycle,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                            shape = RoundedCornerShape(6.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                            modifier = Modifier.height(28.dp)
                        ) {
                            Text("Reset Cycle", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                // Epinephrine 3-5 Min Timer
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isAdrenalineDue) Color(0xFF78350F) else Color(0xFF1F2937),
                    border = BorderStroke(1.2.dp, if (isAdrenalineDue) Color(0xFFF59E0B) else Color(0xFF374151)),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = if (isAdrenalineDue) "💉 ADRENALINE DUE" else "ADRENALINE q3-5m",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Black,
                            color = if (isAdrenalineDue) Color(0xFFFDE68A) else Color(0xFFF59E0B)
                        )
                        Text(
                            text = formatTime(adrenalineSeconds),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Button(
                            onClick = onAdrenalineGiven,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                            shape = RoundedCornerShape(6.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                            modifier = Modifier.height(28.dp)
                        ) {
                            Text("Given ($adrenalineCount)", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        // Action Buttons: Shock Delivered & Amiodarone Protocol
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                border = BorderStroke(1.dp, Color(0xFF334155))
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Defibrillation Counter: $shockCount Shocks", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White)
                        Button(
                            onClick = onDeliverShock,
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                            modifier = Modifier.height(30.dp)
                        ) {
                            Icon(Icons.Default.ElectricBolt, contentDescription = null, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Log Shock", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    HorizontalDivider(color = Color(0xFF334155))

                    Text(
                        text = "⚡ Shockable Rhythm (VF / Pulseless VT):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.5.sp,
                        color = Color(0xFF38BDF8)
                    )
                    Text(
                        text = "• Defibrillate immediately (Biphasic 150-200 J; Monophasic 360 J).\n• Immediately resume CPR for 2 minutes without rhythm re-check.\n• Shock 2: Continue CPR + Epinephrine 1 mg IV/IO.\n• Shock 3: Amiodarone 300 mg IV push (diluted in 20-30 mL D5W) or Lidocaine 1-1.5 mg/kg.\n• Shock 5: Second dose Amiodarone 150 mg IV push.",
                        fontSize = 11.sp,
                        color = Color(0xFFE2E8F0),
                        lineHeight = 16.sp
                    )

                    HorizontalDivider(color = Color(0xFF334155))

                    Text(
                        text = "🛑 Non-Shockable Rhythm (Asystole / PEA):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.5.sp,
                        color = Color(0xFFF87171)
                    )
                    Text(
                        text = "• DO NOT SHOCK. Immediate high-quality CPR.\n• Epinephrine 1 mg IV/IO as early as possible, then every 3 to 5 minutes.\n• Actively investigate and treat reversible causes (H's and T's).",
                        fontSize = 11.sp,
                        color = Color(0xFFE2E8F0),
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun AnaphylaxisShockView() {
    var patientWeightText by remember { mutableStateOf("60") }
    val weight = patientWeightText.toDoubleOrNull() ?: 60.0

    val epiImDose = remember(weight) {
        val calc = weight * 0.01
        when {
            weight >= 50.0 -> 0.50
            weight >= 30.0 -> 0.30
            weight >= 10.0 -> 0.15
            else -> String.format(Locale.US, "%.2f", calc.coerceAtMost(0.5)).toDouble()
        }
    }

    val fluidBolusMl = remember(weight) { (weight * 20).toInt() }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 60.dp)
    ) {
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                border = BorderStroke(1.2.dp, Color(0xFFEF4444).copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "ANAPHYLAXIS IMMEDIATE RESUSCITATION",
                        fontWeight = FontWeight.Black,
                        fontSize = 13.sp,
                        color = Color(0xFFEF4444)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Patient Weight (kg):", fontSize = 12.sp, color = Color.White)
                        OutlinedTextField(
                            value = patientWeightText,
                            onValueChange = { patientWeightText = it },
                            modifier = Modifier.width(100.dp),
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFF0F172A),
                                unfocusedContainerColor = Color(0xFF0F172A),
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            )
                        )
                    }

                    // Epinephrine IM Dose Card
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFF7F1D1D).copy(alpha = 0.4f),
                        border = BorderStroke(1.dp, Color(0xFFEF4444)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = "FIRST-LINE: EPINEPHRINE (1:1000) IM",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFFFCA5A5)
                            )
                            Text(
                                text = "$epiImDose mg IM (= $epiImDose mL of 1:1000 solution)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Inject into ANTEROLATERAL THIGH (Vastus lateralis). Repeat every 5-15 min if airway swelling or hypotension persists.",
                                fontSize = 10.5.sp,
                                color = Color(0xFFFCA5A5)
                            )
                        }
                    }

                    // Secondary Orders
                    Text("Secondary Resuscitation Orders:", fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = Color(0xFF38BDF8))
                    Text(
                        text = "1. Airway & High-Flow O2: 100% via non-rebreather mask (10-15 L/min).\n2. IV Fluid Bolus: $fluidBolusMl mL Normal Saline or Ringer's Lactate wide open for shock/hypotension.\n3. IV Hydrocortisone: 100 to 200 mg IV (prevents biphasic allergic recurrence).\n4. IV Pheniramine (Avil): 45.5 mg (or Chlorpheniramine 10 mg) slow IV.\n5. Nebulized Salbutamol: 2.5 to 5 mg for bronchospasm/wheezing.",
                        fontSize = 11.sp,
                        color = Color(0xFFE2E8F0),
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun PediatricResusTapeView() {
    var weightKg by remember { mutableStateOf(10f) }

    val w = weightKg.toDouble()
    val uncuffedEtt = String.format(Locale.US, "%.1f", (w / 10.0) + 3.5)
    val cuffedEtt = String.format(Locale.US, "%.1f", (w / 10.0) + 3.0)
    val defibrillationInitial = (w * 2).toInt()
    val defibrillationRepeat = (w * 4).toInt()
    val epiIvMl = String.format(Locale.US, "%.2f", w * 0.1) // 0.1 mL/kg of 1:10,000
    val fluidBolus = (w * 20).toInt()
    val midazolamIvMg = String.format(Locale.US, "%.2f", w * 0.1)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 60.dp)
    ) {
        item {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "PEDIATRIC BROSELOW TAPE CALCULATOR",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color(0xFF38BDF8)
                        )
                        Text(
                            text = "${w.toInt()} kg",
                            fontWeight = FontWeight.Black,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }

                    Slider(
                        value = weightKg,
                        onValueChange = { weightKg = it },
                        valueRange = 3f..35f,
                        steps = 31,
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFF38BDF8),
                            activeTrackColor = Color(0xFF0284C7)
                        )
                    )

                    // Resuscitation Table
                    listOf(
                        "Endotracheal Tube (ETT)" to "Cuffed: $cuffedEtt mm | Uncuffed: $uncuffedEtt mm",
                        "ETT Depth (Lip to Tip)" to "~${(w * 0.3 + 9).toInt()} cm",
                        "Defibrillation Energy" to "1st Shock: $defibrillationInitial J (2 J/kg) • 2nd Shock: $defibrillationRepeat J (4 J/kg)",
                        "Epinephrine 1:10,000 IV/IO" to "$epiIvMl mL (= ${(w * 0.01).toFloat()} mg)",
                        "Atropine (0.02 mg/kg)" to "${String.format(Locale.US, "%.2f", w * 0.02)} mg (Min 0.1 mg, Max 0.5 mg)",
                        "Fluid Bolus (20 mL/kg)" to "$fluidBolus mL Normal Saline over 10-20 min",
                        "Midazolam (Status Epilepticus)" to "$midazolamIvMg mg IV/IO (or ${(w * 0.2).toFloat()} mg buccal/intranasal)"
                    ).forEach { (param, valText) ->
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF0F172A),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(param, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Slate400)
                                Text(valText, fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HsAndTsChecklistView() {
    val hs = listOf(
        "Hypovolemia" to "Rapid fluid challenge (Normal Saline 1-2 L) or packed red cells.",
        "Hypoxia" to "Ventilate with 100% O2, verify bilateral breath sounds, confirm ETT position.",
        "Hydrogen Ion (Acidosis)" to "Adequate ventilation; consider Sodium Bicarbonate 1 mEq/kg for profound acidosis.",
        "Hypo- / Hyperkalemia" to "Hyperkalemia: Calcium Gluconate 10% 10-20 mL, D50W + Insulin, NaHCO3. Hypokalemia: Potassium + Magnesium infusion.",
        "Hypothermia" to "Active core rewarming; continue CPR until patient warmed to >32-35°C."
    )

    val ts = listOf(
        "Tension Pneumothorax" to "Immediate needle decompression (2nd ICS mid-clavicular or 5th ICS anterior axillary line), followed by chest tube.",
        "Tamponade (Cardiac)" to "Bedside ultrasound (FAST / POCUS); emergency needle pericardiocentesis.",
        "Toxins / Overdose" to "Antidote administration (Naloxone, Atropine, Bicarbonate for TCA, Lipid emulsion for LAST).",
        "Thrombosis (Pulmonary PE)" to "Massive PE: Consider thrombolytic therapy (Alteplase 50 mg IV bolus); continue CPR for 60-90 min.",
        "Thrombosis (Coronary ACS)" to "Emergent PCI transfer if ROSC achieved; mechanical circulatory support."
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 60.dp)
    ) {
        item {
            Text("Reversible Causes of Cardiac Arrest (H's and T's):", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color.White)
        }

        item {
            Text("THE 5 H's", fontWeight = FontWeight.Black, fontSize = 12.sp, color = Color(0xFF38BDF8))
        }

        items(hs) { (name, action) ->
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF1E293B),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text("• $name", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White)
                    Text("Action: $action", fontSize = 10.5.sp, color = Slate400, lineHeight = 15.sp)
                }
            }
        }

        item {
            Text("THE 5 T's", fontWeight = FontWeight.Black, fontSize = 12.sp, color = Color(0xFFEF4444))
        }

        items(ts) { (name, action) ->
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF1E293B),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text("• $name", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White)
                    Text("Action: $action", fontSize = 10.5.sp, color = Slate400, lineHeight = 15.sp)
                }
            }
        }
    }
}
