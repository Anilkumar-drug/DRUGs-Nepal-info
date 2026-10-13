package com.example.ui.screens

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.DrugAlarmReminder
import com.example.data.repository.ClinicalRepository
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugAlarmReminderScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    var showAddDialog by remember { mutableStateOf(false) }
    var editingAlarm by remember { mutableStateOf<DrugAlarmReminder?>(null) }
    var selectedFilter by remember { mutableStateOf("All") }

    val todayDateStr = remember {
        SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
    }

    // Active Alarms count and Adherence Stats
    val totalAlarms = state.drugAlarms.size
    val activeAlarms = state.drugAlarms.filter { it.isEnabled }
    val dosesTakenToday = state.drugAlarms.count { it.lastTakenDate == todayDateStr }
    val compliancePct = if (totalAlarms > 0) ((dosesTakenToday.toFloat() / totalAlarms.toFloat()) * 100).toInt() else 100

    val filteredAlarms = remember(state.drugAlarms, selectedFilter) {
        when (selectedFilter) {
            "Morning" -> state.drugAlarms.filter { it.hour in 5..11 }
            "Afternoon" -> state.drugAlarms.filter { it.hour in 12..16 }
            "Evening/Night" -> state.drugAlarms.filter { it.hour >= 17 || it.hour < 5 }
            else -> state.drugAlarms
        }.sortedWith(compareBy({ it.hour }, { it.minute }))
    }

    // Next upcoming alarm
    val nextUpcomingAlarm = remember(state.drugAlarms) {
        val nowCalendar = java.util.Calendar.getInstance()
        val currentHour = nowCalendar.get(java.util.Calendar.HOUR_OF_DAY)
        val currentMinute = nowCalendar.get(java.util.Calendar.MINUTE)
        val currentTotalMinutes = currentHour * 60 + currentMinute

        activeAlarms.minByOrNull { alarm ->
            val alarmMinutes = alarm.hour * 60 + alarm.minute
            if (alarmMinutes >= currentTotalMinutes) alarmMinutes - currentTotalMinutes
            else (alarmMinutes + 24 * 60) - currentTotalMinutes
        }
    }

    Scaffold(
        topBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 2.dp,
                border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.testTag("alarm_screen_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(
                                    text = "Drug Dose Alarm & Reminder",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Emerald500.copy(alpha = 0.2f)
                                ) {
                                    Text(
                                        text = "LIVE",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Emerald400,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Text(
                                text = "औषधि खाने समय, स्मार्ट अलार्म र दैनिक खुराक अनुसूची",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Test Alarm Trigger button
                    IconButton(
                        onClick = {
                            val target = nextUpcomingAlarm ?: state.drugAlarms.firstOrNull()
                            if (target != null) {
                                viewModel.simulateTriggerAlarm(target)
                            } else {
                                Toast.makeText(context, "Please add a medication reminder first", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Rose500.copy(alpha = 0.15f))
                            .testTag("test_alarm_ring_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.NotificationsActive,
                            contentDescription = "Test Alarm Ring",
                            tint = Rose500,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = DimsTealPrimary,
                contentColor = Color.White,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(bottom = 72.dp)
                    .testTag("add_drug_alarm_fab")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.AddAlarm, contentDescription = "Add Alarm")
                    Text("Add Dose Alarm", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(top = 12.dp, bottom = 120.dp)
        ) {
            // Next Due Dose Hero Card
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                    border = BorderStroke(1.2.dp, DimsTealPrimary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("next_dose_hero_card")
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = DimsTealPrimary.copy(alpha = 0.25f),
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = Icons.Default.Alarm,
                                            contentDescription = null,
                                            tint = DimsCyanMascot,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                                Column {
                                    Text(
                                        text = "UPCOMING MEDICATION DOSE",
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = DimsCyanMascot
                                    )
                                    Text(
                                        text = if (nextUpcomingAlarm != null) "Scheduled at ${nextUpcomingAlarm.formattedTime}" else "No active reminders set",
                                        fontSize = 12.sp,
                                        color = Slate400
                                    )
                                }
                            }

                            if (nextUpcomingAlarm != null) {
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = Emerald500.copy(alpha = 0.2f),
                                    border = BorderStroke(1.dp, Emerald400)
                                ) {
                                    Text(
                                        text = nextUpcomingAlarm.formattedTime,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Emerald400,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }

                        if (nextUpcomingAlarm != null) {
                            Surface(
                                shape = RoundedCornerShape(14.dp),
                                color = Color(0xFF1E293B),
                                border = BorderStroke(1.dp, Color(0xFF334155)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                        Text(
                                            text = nextUpcomingAlarm.drugName,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = "${nextUpcomingAlarm.dosage} • ${nextUpcomingAlarm.timingTag}",
                                            fontSize = 11.5.sp,
                                            color = Emerald400
                                        )
                                        if (nextUpcomingAlarm.notes.isNotBlank()) {
                                            Text(
                                                text = nextUpcomingAlarm.notes,
                                                fontSize = 10.5.sp,
                                                color = Slate400,
                                                maxLines = 2,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                    }

                                    Button(
                                        onClick = {
                                            viewModel.markDoseTaken(nextUpcomingAlarm.id)
                                            Toast.makeText(context, "Dose recorded as taken: ${nextUpcomingAlarm.drugName}", Toast.LENGTH_SHORT).show()
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Emerald600),
                                        shape = RoundedCornerShape(12.dp),
                                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                                        modifier = Modifier.testTag("hero_take_dose_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("Take Dose", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        } else {
                            Text(
                                text = "Set an alarm for your prescription medications (e.g. Vonopran, Pantoprazole, Metformin) to receive timely alerts and keep track of daily compliance.",
                                fontSize = 12.sp,
                                color = Slate400,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }

            // Adherence & Summary Strip
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Compliance Card
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(imageVector = Icons.Default.Verified, contentDescription = null, tint = Emerald400, modifier = Modifier.size(16.dp))
                                Text("Today's Adherence", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Text("$compliancePct%", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Emerald400)
                            LinearProgressIndicator(
                                progress = { (compliancePct / 100f).coerceIn(0f, 1f) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .clip(RoundedCornerShape(3.dp)),
                                color = Emerald400,
                                trackColor = Emerald400.copy(alpha = 0.2f)
                            )
                        }
                    }

                    // Doses Taken Card
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(imageVector = Icons.Default.Medication, contentDescription = null, tint = DimsTealPrimary, modifier = Modifier.size(16.dp))
                                Text("Doses Taken", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Text("$dosesTakenToday / $totalAlarms Taken", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                            Text("Active: ${activeAlarms.size} alarms", fontSize = 10.sp, color = Slate400)
                        }
                    }
                }
            }

            // Filter Chips Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("All", "Morning", "Afternoon", "Evening/Night").forEach { filter ->
                        val isSelected = selectedFilter == filter
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedFilter = filter },
                            label = { Text(filter, fontSize = 11.5.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium) },
                            shape = RoundedCornerShape(14.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = DimsTealPrimary,
                                selectedLabelColor = Color.White,
                                containerColor = MaterialTheme.colorScheme.surface,
                                labelColor = MaterialTheme.colorScheme.onSurface
                            ),
                            border = BorderStroke(1.dp, if (isSelected) Color.Transparent else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                        )
                    }
                }
            }

            // Alarms List Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "SCHEDULED DOSE ALARMS (${filteredAlarms.size})",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Sound & Vibrate Enabled",
                        fontSize = 10.sp,
                        color = Slate400
                    )
                }
            }

            // Reminders List
            if (filteredAlarms.isEmpty()) {
                item {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AlarmOff,
                                contentDescription = null,
                                tint = Slate400,
                                modifier = Modifier.size(36.dp)
                            )
                            Text(
                                text = "No drug reminders in this category",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Tap '+ Add Dose Alarm' below to schedule a new medication reminder.",
                                fontSize = 11.5.sp,
                                color = Slate400
                            )
                        }
                    }
                }
            } else {
                items(filteredAlarms, key = { it.id }) { alarm ->
                    DrugAlarmCard(
                        alarm = alarm,
                        isTakenToday = alarm.lastTakenDate == todayDateStr,
                        onToggle = { viewModel.toggleDrugAlarm(alarm.id) },
                        onTakeDose = {
                            viewModel.markDoseTaken(alarm.id)
                            Toast.makeText(context, "Dose marked as taken!", Toast.LENGTH_SHORT).show()
                        },
                        onEdit = { editingAlarm = alarm },
                        onDelete = { viewModel.deleteDrugAlarm(alarm.id) },
                        onTrigger = { viewModel.simulateTriggerAlarm(alarm) }
                    )
                }
            }
        }
    }

    // Add Alarm Dialog
    if (showAddDialog) {
        EditOrAddAlarmDialog(
            initialAlarm = null,
            onDismiss = { showAddDialog = false },
            onSave = { newAlarm ->
                viewModel.addDrugAlarm(newAlarm)
                showAddDialog = false
                Toast.makeText(context, "Alarm created for ${newAlarm.drugName} at ${newAlarm.formattedTime}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    // Edit Alarm Dialog
    editingAlarm?.let { alarmToEdit ->
        EditOrAddAlarmDialog(
            initialAlarm = alarmToEdit,
            onDismiss = { editingAlarm = null },
            onSave = { updated ->
                viewModel.updateDrugAlarm(updated)
                editingAlarm = null
                Toast.makeText(context, "Updated alarm for ${updated.drugName}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    // Ringing Alarm Modal Alert (Shown when alarm triggers or is tested)
    if (state.isAlarmRinging && state.activeRingingAlarm != null) {
        RingingAlarmAlertDialog(
            alarm = state.activeRingingAlarm,
            onDoseTaken = {
                viewModel.markDoseTaken(state.activeRingingAlarm.id)
                Toast.makeText(context, "Great job! Dose recorded as taken.", Toast.LENGTH_SHORT).show()
            },
            onSnooze = {
                viewModel.snoozeRingingAlarm()
                Toast.makeText(context, "Alarm snoozed for 10 minutes", Toast.LENGTH_SHORT).show()
            },
            onDismiss = { viewModel.dismissRingingAlarm() }
        )
    }
}

@Composable
private fun DrugAlarmCard(
    alarm: DrugAlarmReminder,
    isTakenToday: Boolean,
    onToggle: () -> Unit,
    onTakeDose: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onTrigger: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (alarm.isEnabled) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        border = BorderStroke(
            1.dp,
            if (isTakenToday) Emerald400.copy(alpha = 0.6f)
            else if (alarm.isEnabled) DimsTealPrimary.copy(alpha = 0.35f)
            else MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("alarm_card_${alarm.id}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Time & Status Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (alarm.isEnabled) DimsTealPrimary.copy(alpha = 0.15f) else Slate500.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, if (alarm.isEnabled) DimsTealPrimary else Slate500.copy(alpha = 0.3f))
                    ) {
                        Text(
                            text = alarm.formattedTime,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (alarm.isEnabled) DimsTealPrimary else Slate400,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }

                    if (isTakenToday) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Emerald500.copy(alpha = 0.15f),
                            border = BorderStroke(0.8.dp, Emerald400)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(Icons.Default.Check, contentDescription = null, tint = Emerald400, modifier = Modifier.size(12.dp))
                                Text("Taken Today", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Emerald400)
                            }
                        }
                    }
                }

                // Switch
                Switch(
                    checked = alarm.isEnabled,
                    onCheckedChange = { onToggle() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = DimsTealPrimary
                    ),
                    modifier = Modifier.scale(0.85f)
                )
            }

            // Drug details
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = alarm.drugName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (alarm.isEnabled) MaterialTheme.colorScheme.onSurface else Slate400
                )
                Text(
                    text = "${alarm.dosage} • ${alarm.timingTag} • ${alarm.frequency}",
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                if (alarm.notes.isNotBlank()) {
                    Text(
                        text = alarm.notes,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Bottom Actions Bar
            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    // Test ring button
                    FilledTonalIconButton(
                        onClick = onTrigger,
                        modifier = Modifier.size(32.dp),
                        colors = IconButtonDefaults.filledTonalIconButtonColors(
                            containerColor = Rose500.copy(alpha = 0.12f),
                            contentColor = Rose500
                        )
                    ) {
                        Icon(imageVector = Icons.Default.RingVolume, contentDescription = "Test Ring", modifier = Modifier.size(16.dp))
                    }

                    // Edit button
                    FilledTonalIconButton(
                        onClick = onEdit,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit", modifier = Modifier.size(16.dp))
                    }

                    // Delete button
                    FilledTonalIconButton(
                        onClick = onDelete,
                        modifier = Modifier.size(32.dp),
                        colors = IconButtonDefaults.filledTonalIconButtonColors(
                            containerColor = Red500.copy(alpha = 0.12f),
                            contentColor = Red500
                        )
                    ) {
                        Icon(imageVector = Icons.Default.DeleteOutline, contentDescription = "Delete", modifier = Modifier.size(16.dp))
                    }
                }

                // Take Dose Action Button
                Button(
                    onClick = onTakeDose,
                    enabled = !isTakenToday,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isTakenToday) Slate500 else Emerald600
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = if (isTakenToday) Icons.Default.DoneAll else Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isTakenToday) "Dose Logged" else "Take Dose",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditOrAddAlarmDialog(
    initialAlarm: DrugAlarmReminder?,
    onDismiss: () -> Unit,
    onSave: (DrugAlarmReminder) -> Unit
) {
    var drugName by remember { mutableStateOf(initialAlarm?.drugName ?: "") }
    var dosage by remember { mutableStateOf(initialAlarm?.dosage ?: "1 Tablet") }
    var hour by remember { mutableIntStateOf(initialAlarm?.hour ?: 8) }
    var minute by remember { mutableIntStateOf(initialAlarm?.minute ?: 0) }
    var timingTag by remember { mutableStateOf(initialAlarm?.timingTag ?: "Before Food (खाली पेट)") }
    var frequency by remember { mutableStateOf(initialAlarm?.frequency ?: "Once Daily (OD)") }
    var notes by remember { mutableStateOf(initialAlarm?.notes ?: "") }
    var isSoundEnabled by remember { mutableStateOf(initialAlarm?.isSoundEnabled ?: true) }
    var isVibrationEnabled by remember { mutableStateOf(initialAlarm?.isVibrationEnabled ?: true) }

    // Drug Autocomplete suggestions
    val suggestions = remember(drugName) {
        val q = drugName.trim().lowercase()
        if (q.length < 2) emptyList()
        else ClinicalRepository.drugs.filter {
            it.genericName.lowercase().contains(q) ||
            it.brandsNepal.any { b -> b.name.lowercase().contains(q) }
        }.take(4)
    }

    val timingOptions = listOf(
        "Before Food (खाली पेट)",
        "After Meals (खानापछि)",
        "With Food (खानासँगै)",
        "At Bedtime (सुत्ने बेलामा)"
    )

    val frequencyOptions = listOf(
        "Once Daily (OD)",
        "Twice Daily (BD)",
        "Thrice Daily (TID)",
        "Four Times Daily (QID)",
        "As Needed (SOS)"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    imageVector = if (initialAlarm == null) Icons.Default.AddAlarm else Icons.Default.EditNotifications,
                    contentDescription = null,
                    tint = DimsTealPrimary
                )
                Text(
                    text = if (initialAlarm == null) "Schedule Drug Dose Alarm" else "Edit Dose Alarm",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Drug Name input
                OutlinedTextField(
                    value = drugName,
                    onValueChange = { drugName = it },
                    label = { Text("Drug / Brand Name") },
                    placeholder = { Text("e.g. Vonopran 20mg, Pantoprazole, Metformin") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("alarm_input_drug_name"),
                    shape = RoundedCornerShape(12.dp)
                )

                // Autocomplete suggestion chips
                if (suggestions.isNotEmpty()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        suggestions.forEach { drug ->
                            val label = drug.brandsNepal.firstOrNull()?.name ?: drug.genericName
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = DimsTealPrimary.copy(alpha = 0.15f),
                                border = BorderStroke(0.8.dp, DimsTealPrimary),
                                modifier = Modifier.clickable { drugName = label }
                            ) {
                                Text(
                                    text = label,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = DimsTealPrimary,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }

                // Dosage input
                OutlinedTextField(
                    value = dosage,
                    onValueChange = { dosage = it },
                    label = { Text("Dosage / Form") },
                    placeholder = { Text("e.g. 1 Tablet (20 mg), 5 mL, 2 Puffs") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                // Time Pickers (Hours & Minutes)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Hour picker (1-12 or 24-hr)
                    OutlinedTextField(
                        value = if (hour < 10) "0$hour" else "$hour",
                        onValueChange = { v ->
                            v.toIntOrNull()?.let { if (it in 0..23) hour = it }
                        },
                        label = { Text("Hour (0-23)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Text(":", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                    OutlinedTextField(
                        value = if (minute < 10) "0$minute" else "$minute",
                        onValueChange = { v ->
                            v.toIntOrNull()?.let { if (it in 0..59) minute = it }
                        },
                        label = { Text("Min (0-59)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                // Timing Tag
                Text("Instructions / Timing:", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    timingOptions.take(2).forEach { tag ->
                        val isSelected = timingTag == tag
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) DimsTealPrimary else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .weight(1f)
                                .clickable { timingTag = tag }
                        ) {
                            Text(
                                text = tag.substringBefore(" "),
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }

                // Notes / Instructions
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes / Doctor's Advice") },
                    placeholder = { Text("e.g. Drink 1 glass of warm water") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (drugName.isNotBlank()) {
                        onSave(
                            DrugAlarmReminder(
                                id = initialAlarm?.id ?: java.util.UUID.randomUUID().toString(),
                                drugName = drugName.trim(),
                                dosage = dosage.ifBlank { "1 Tablet" },
                                hour = hour,
                                minute = minute,
                                timingTag = timingTag,
                                frequency = frequency,
                                notes = notes.trim(),
                                isSoundEnabled = isSoundEnabled,
                                isVibrationEnabled = isVibrationEnabled,
                                isEnabled = true
                            )
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = DimsTealPrimary),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.testTag("save_drug_alarm_button")
            ) {
                Text("Save Alarm", fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Composable
private fun RingingAlarmAlertDialog(
    alarm: DrugAlarmReminder,
    onDoseTaken: () -> Unit,
    onSnooze: () -> Unit,
    onDismiss: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "alarm_ring")
    val bellScale by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 1.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 350, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bell_scale"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(24.dp),
        containerColor = Color(0xFF0F172A),
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = Rose500.copy(alpha = 0.2f),
                    border = BorderStroke(2.dp, Rose500),
                    modifier = Modifier
                        .size(70.dp)
                        .scale(bellScale)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.NotificationsActive,
                            contentDescription = "Alarm Ringing",
                            tint = Rose500,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }

                Text(
                    text = "⏰ MEDICATION ALARM DUE!",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Rose500,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Text(
                    text = "It's ${alarm.formattedTime} - Time for your scheduled dose",
                    fontSize = 11.5.sp,
                    color = Slate400
                )
            }
        },
        text = {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(1.dp, Color(0xFF334155)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = alarm.drugName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Emerald500.copy(alpha = 0.2f)
                    ) {
                        Text(
                            text = "${alarm.dosage} • ${alarm.timingTag}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Emerald400,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                    if (alarm.notes.isNotBlank()) {
                        Text(
                            text = alarm.notes,
                            fontSize = 11.sp,
                            color = Slate400,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDoseTaken,
                colors = ButtonDefaults.buttonColors(containerColor = Emerald600),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("dialog_dose_taken_button")
            ) {
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("I Took My Dose ✓", fontWeight = FontWeight.ExtraBold, fontSize = 13.5.sp)
            }
        },
        dismissButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onSnooze,
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Slate500),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Snooze 10m ⏳", fontSize = 11.5.sp, color = Slate400)
                }
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Dismiss", fontSize = 11.5.sp, color = Slate400)
                }
            }
        }
    )
}
