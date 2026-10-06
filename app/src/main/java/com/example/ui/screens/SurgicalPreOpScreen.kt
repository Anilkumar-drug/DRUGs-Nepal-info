package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.SurgicalPreOpDrug
import com.example.data.repository.SurgicalPreOpData
import com.example.ui.theme.*

private enum class BleedRiskLevel(val label: String, val badgeColor: Color) {
    ALL("All Risk Levels", DimsTealPrimary),
    LOW("Low Bleed Risk (Minor / Dental / Cataract)", Emerald500),
    HIGH("High Bleed Risk (Major Abdominal / Neuro / Ortho)", Red500)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurgicalPreOpScreen(
    onBackClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedClass by remember { mutableStateOf("All") }
    var selectedRiskLevel by remember { mutableStateOf(BleedRiskLevel.ALL) }
    var expandedDrugId by remember { mutableStateOf<String?>(null) }

    val drugClasses = remember {
        listOf(
            "All",
            "Antiplatelet",
            "Anticoagulant (DOAC)",
            "Anticoagulant (VKA)",
            "Diabetes / Metabolic",
            "Cardiovascular / Antihypertensive",
            "Immunosuppressant",
            "Herbal / Supplement"
        )
    }

    val filteredDrugs = remember(searchQuery, selectedClass) {
        val q = searchQuery.trim().lowercase()
        SurgicalPreOpData.preOpDrugs.filter { item ->
            val matchesClass = selectedClass == "All" || item.drugClass.contains(selectedClass, ignoreCase = true)
            val matchesQuery = q.isEmpty() ||
                    item.drugName.lowercase().contains(q) ||
                    item.drugClass.lowercase().contains(q) ||
                    item.cessationWindow.lowercase().contains(q) ||
                    item.clinicalRationale.lowercase().contains(q)
            matchesClass && matchesQuery
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Surgical Pre-Op Clearance",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Drug Clearance & Bridging Matrix",
                            fontSize = 11.sp,
                            color = DimsTealPrimary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("surgical_preop_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                // Header Banner
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF6366F1).copy(alpha = 0.08f),
                    border = BorderStroke(1.dp, Color(0xFF6366F1).copy(alpha = 0.25f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.MedicalServices,
                            contentDescription = null,
                            tint = Color(0xFF6366F1),
                            modifier = Modifier.size(28.dp)
                        )
                        Column {
                            Text(
                                text = "Perioperative Drug Management Matrix",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Evidence-based guidelines for stopping, continuing, and bridging blood thinners, antidiabetics, and cardiovascular agents prior to surgery.",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                // Search Field
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search medication, class, or guideline...", fontSize = 13.sp) },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null, tint = DimsTealPrimary)
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("surgical_preop_search_input"),
                    singleLine = true
                )
            }

            item {
                // Category Filter Chips
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(drugClasses) { drugClass ->
                        val isSelected = selectedClass == drugClass
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedClass = drugClass },
                            label = { Text(drugClass, fontSize = 11.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF6366F1),
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }

            item {
                // Procedure Risk Level Selector Tabs
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    BleedRiskLevel.entries.forEach { risk ->
                        val isSelected = selectedRiskLevel == risk
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) risk.badgeColor.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                            border = BorderStroke(
                                1.dp,
                                if (isSelected) risk.badgeColor else Color.Transparent
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedRiskLevel = risk }
                        ) {
                            Text(
                                text = when (risk) {
                                    BleedRiskLevel.ALL -> "All Procedures"
                                    BleedRiskLevel.LOW -> "Minor / Low Bleed"
                                    BleedRiskLevel.HIGH -> "Major / High Bleed"
                                },
                                fontSize = 10.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) risk.badgeColor else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                                maxLines = 1
                            )
                        }
                    }
                }
            }

            // Drug List
            items(filteredDrugs, key = { it.id }) { drug ->
                val isExpanded = expandedDrugId == drug.id

                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    border = BorderStroke(
                        1.dp,
                        if (isExpanded) Color(0xFF6366F1).copy(alpha = 0.4f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            expandedDrugId = if (isExpanded) null else drug.id
                        }
                        .testTag("surgical_preop_item_${drug.id}")
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        // Title & Class
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = drug.drugName,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = drug.drugClass,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            // Cessation Window Badge
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (drug.cessationWindow.contains("CONTINUE", ignoreCase = true)) Emerald500.copy(alpha = 0.12f) else Red500.copy(alpha = 0.12f),
                                border = BorderStroke(
                                    0.5.dp,
                                    if (drug.cessationWindow.contains("CONTINUE", ignoreCase = true)) Emerald500 else Red500
                                )
                            ) {
                                Text(
                                    text = drug.cessationWindow,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (drug.cessationWindow.contains("CONTINUE", ignoreCase = true)) Emerald500 else Red500,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Selected Risk Action Highlight
                        if (selectedRiskLevel == BleedRiskLevel.LOW || selectedRiskLevel == BleedRiskLevel.ALL) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Emerald500.copy(alpha = 0.06f),
                                border = BorderStroke(0.5.dp, Emerald500.copy(alpha = 0.3f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(8.dp),
                                    verticalAlignment = Alignment.Top,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text("🟢", fontSize = 11.sp)
                                    Column {
                                        Text(
                                            text = "Low Bleeding Risk (Dental, Cataract, Skin Biopsy):",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Emerald500
                                        )
                                        Text(
                                            text = drug.lowBleedRiskAction,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                        }

                        if (selectedRiskLevel == BleedRiskLevel.HIGH || selectedRiskLevel == BleedRiskLevel.ALL) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Red500.copy(alpha = 0.06f),
                                border = BorderStroke(0.5.dp, Red500.copy(alpha = 0.3f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(8.dp),
                                    verticalAlignment = Alignment.Top,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text("🔴", fontSize = 11.sp)
                                    Column {
                                        Text(
                                            text = "High Bleeding Risk (Major Abdominal, Neuro, Ortho):",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Red500
                                        )
                                        Text(
                                            text = drug.highBleedRiskAction,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }

                        // Expandable Full Details
                        AnimatedVisibility(visible = isExpanded) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                                // Bridging Protocol
                                if (drug.bridgingProtocol != null) {
                                    Column {
                                        Text(
                                            text = "BRIDGING PROTOCOL:",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Amber500
                                        )
                                        Text(
                                            text = drug.bridgingProtocol,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }

                                // Resumption
                                Column {
                                    Text(
                                        text = "POST-OPERATIVE RESUMPTION:",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = DimsTealPrimary
                                    )
                                    Text(
                                        text = drug.resumptionTimeline,
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }

                                // Emergency Reversal
                                if (drug.emergencyReversalAgent != null) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = Amber500.copy(alpha = 0.08f),
                                        border = BorderStroke(0.5.dp, Amber500.copy(alpha = 0.3f)),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(8.dp)) {
                                            Text(
                                                text = "EMERGENCY REVERSAL / ANTIDOTE:",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Amber500
                                            )
                                            Text(
                                                text = drug.emergencyReversalAgent,
                                                fontSize = 11.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                }

                                // Clinical Rationale
                                Column {
                                    Text(
                                        text = "CLINICAL RATIONALE & PHARMACOKINETICS:",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = drug.clinicalRationale,
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                // Precautions
                                Text(
                                    text = "⚠️ ${drug.specialPrecautions}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Amber500
                                )
                            }
                        }

                        // Tap indicator
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 6.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = if (isExpanded) "Tap to collapse ▲" else "Tap for bridging, reversal & full protocol ▼",
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
