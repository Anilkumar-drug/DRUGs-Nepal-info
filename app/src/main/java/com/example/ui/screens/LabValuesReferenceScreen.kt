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
import com.example.data.model.CriticalPanicLabValue
import com.example.data.model.DiagnosticRatioGuide
import com.example.data.model.StandardLabTest
import com.example.data.repository.LabValuesData
import com.example.ui.theme.*

private enum class LabViewTab(val label: String) {
    STANDARD_PANELS("🧪 Standard Lab Directory"),
    PANIC_VALUES("🚨 Critical Panic Values"),
    DIAGNOSTIC_RATIOS("📐 Decision Ratios & Rules")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabValuesReferenceScreen(
    onBackClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(LabViewTab.STANDARD_PANELS) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var selectedPanel by remember { mutableStateOf("All Panels") }
    var expandedLabId by remember { mutableStateOf<String?>(null) }
    var expandedRatioId by remember { mutableStateOf<String?>(null) }
    var expandedStandardId by remember { mutableStateOf<String?>(null) }

    val panicCategories = remember {
        listOf(
            "All",
            "Electrolytes & Renal",
            "Hematology",
            "Blood Gas & Acid-Base",
            "Cardiac & Biomarkers",
            "Coagulation",
            "Endocrine & Metabolic"
        )
    }

    val standardPanels = remember { LabValuesData.labPanels }

    val filteredStandardTests = remember(searchQuery, selectedPanel) {
        val q = searchQuery.trim().lowercase()
        LabValuesData.standardLabTests.filter { item ->
            val matchesPanel = selectedPanel == "All Panels" || item.panel.contains(selectedPanel, ignoreCase = true)
            val matchesQuery = q.isEmpty() ||
                    item.name.lowercase().contains(q) ||
                    item.panel.lowercase().contains(q) ||
                    item.highSignificance.lowercase().contains(q) ||
                    item.lowSignificance.lowercase().contains(q) ||
                    item.clinicalPearls.lowercase().contains(q) ||
                    item.sampleTube.lowercase().contains(q)
            matchesPanel && matchesQuery
        }
    }

    val filteredPanicValues = remember(searchQuery, selectedCategory) {
        val q = searchQuery.trim().lowercase()
        LabValuesData.panicValues.filter { item ->
            val matchesCat = selectedCategory == "All" || item.category.contains(selectedCategory, ignoreCase = true)
            val matchesQuery = q.isEmpty() ||
                    item.testName.lowercase().contains(q) ||
                    item.category.lowercase().contains(q) ||
                    item.panicThresholdDescription.lowercase().contains(q) ||
                    item.commonEtiologies.lowercase().contains(q)
            matchesCat && matchesQuery
        }
    }

    val filteredRatios = remember(searchQuery) {
        val q = searchQuery.trim().lowercase()
        LabValuesData.diagnosticRatios.filter { item ->
            q.isEmpty() ||
                    item.title.lowercase().contains(q) ||
                    item.formula.lowercase().contains(q) ||
                    item.clinicalUtility.lowercase().contains(q) ||
                    item.interpretationHigh.lowercase().contains(q) ||
                    item.interpretationLow.lowercase().contains(q)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Laboratory Reference & Decision Ratios",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Standard Reference Ranges • Panic Alerts • Ratios",
                            fontSize = 11.sp,
                            color = DimsTealPrimary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("lab_values_back_button")
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
                // Tab Switcher
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(LabViewTab.entries) { tab ->
                        val isSelected = selectedTab == tab
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) DimsTealPrimary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier
                                .clickable { selectedTab = tab }
                        ) {
                            Text(
                                text = tab.label,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier
                                    .padding(horizontal = 12.dp, vertical = 9.dp),
                                maxLines = 1
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
                    placeholder = {
                        val placeholderText = when (selectedTab) {
                            LabViewTab.STANDARD_PANELS -> "Search standard test (CBC, creatinine, LFT, TSH, tube...)"
                            LabViewTab.PANIC_VALUES -> "Search panic lab test, electrolyte, etiology..."
                            LabViewTab.DIAGNOSTIC_RATIOS -> "Search diagnostic ratio (SAAG, Light's, FeNa, FeUrea...)"
                        }
                        Text(placeholderText, fontSize = 12.5.sp)
                    },
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
                        .testTag("lab_values_search_input"),
                    singleLine = true
                )
            }

            // Tab-specific filters & lists
            when (selectedTab) {
                LabViewTab.STANDARD_PANELS -> {
                    item {
                        // Standard Panel Filter Chips
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(standardPanels) { panel ->
                                val isSelected = selectedPanel == panel
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedPanel = panel },
                                    label = { Text(panel, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = DimsTealPrimary,
                                        selectedLabelColor = Color.White
                                    )
                                )
                            }
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Standard Reference Ranges (${filteredStandardTests.size} tests)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "SI & Conventional Units",
                                fontSize = 10.5.sp,
                                color = DimsTealPrimary
                            )
                        }
                    }

                    // Standard Lab Cards
                    items(filteredStandardTests, key = { it.id }) { test ->
                        val isExpanded = expandedStandardId == test.id
                        StandardLabCard(
                            test = test,
                            isExpanded = isExpanded,
                            onToggle = { expandedStandardId = if (isExpanded) null else test.id }
                        )
                    }
                }

                LabViewTab.PANIC_VALUES -> {
                    item {
                        // Category Filter Chips
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(panicCategories) { category ->
                                val isSelected = selectedCategory == category
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedCategory = category },
                                    label = { Text(category, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = Red500,
                                        selectedLabelColor = Color.White
                                    )
                                )
                            }
                        }
                    }

                    item {
                        Text(
                            text = "Critical Panic Alert Thresholds (${filteredPanicValues.size} tests)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Red500
                        )
                    }

                    // Panic Values Cards
                    items(filteredPanicValues, key = { it.id }) { item ->
                        val isExpanded = expandedLabId == item.id
                        PanicLabCard(
                            item = item,
                            isExpanded = isExpanded,
                            onToggle = { expandedLabId = if (isExpanded) null else item.id }
                        )
                    }
                }

                LabViewTab.DIAGNOSTIC_RATIOS -> {
                    item {
                        Text(
                            text = "Diagnostic Ratios & Clinical Formulas (${filteredRatios.size} rules)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6366F1)
                        )
                    }

                    // Diagnostic Ratios Cards
                    items(filteredRatios, key = { it.id }) { ratio ->
                        val isExpanded = expandedRatioId == ratio.id
                        DiagnosticRatioCard(
                            ratio = ratio,
                            isExpanded = isExpanded,
                            onToggle = { expandedRatioId = if (isExpanded) null else ratio.id }
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun StandardLabCard(
    test: StandardLabTest,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(
            1.dp,
            if (isExpanded) DimsTealPrimary.copy(alpha = 0.6f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .testTag("std_lab_item_${test.id}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Header Row: Test Name + Panel Tag
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = test.name,
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = test.panel,
                        fontSize = 11.sp,
                        color = DimsTealPrimary,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Tube Color Badge
                if (test.sampleTube.isNotBlank()) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Text(
                            text = test.sampleTube.take(24),
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Reference Ranges Box
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = DimsTealPrimary.copy(alpha = 0.08f),
                border = BorderStroke(0.5.dp, DimsTealPrimary.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Conventional:",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = DimsTealPrimary
                        )
                        Text(
                            text = "${test.standardRange} ${test.conventionalUnits}",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    if (test.siRange.isNotBlank() && test.siUnits.isNotBlank()) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "SI Units:",
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "${test.siRange} ${test.siUnits}",
                                fontSize = 10.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // High & Low Summary Snippets
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("🔺", fontSize = 10.sp)
                    Text(
                        text = "High: ${test.highSignificance}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = if (isExpanded) 10 else 1
                    )
                }
                Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("🔻", fontSize = 10.sp)
                    Text(
                        text = "Low: ${test.lowSignificance}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = if (isExpanded) 10 else 1
                    )
                }
            }

            // Expandable Clinical Pearls
            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Amber500.copy(alpha = 0.08f),
                        border = BorderStroke(0.5.dp, Amber500.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text("💡", fontSize = 12.sp)
                            Column {
                                Text(
                                    text = "CLINICAL PEARL & WORKUP:",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Amber500
                                )
                                Text(
                                    text = test.clinicalPearls,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    lineHeight = 15.sp
                                )
                            }
                        }
                    }

                    Text(
                        text = "Sample tube: ${test.sampleTube}",
                        fontSize = 10.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (isExpanded) "Tap to collapse ▲" else "Tap for clinical pearls & collection tube details ▼",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
private fun PanicLabCard(
    item: CriticalPanicLabValue,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(
            1.dp,
            if (isExpanded) Red500.copy(alpha = 0.5f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .testTag("panic_lab_item_${item.id}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.testName,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Normal: ${item.normalRange} ${item.unit} • ${item.category}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Red500.copy(alpha = 0.12f),
                    border = BorderStroke(0.5.dp, Red500)
                ) {
                    Text(
                        text = item.criticalLowValue ?: item.criticalHighValue ?: "PANIC",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Red500,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "⚠️ ${item.panicThresholdDescription}",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Red500
            )

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    Text(
                        text = "IMMEDIATE CLINICAL INTERVENTIONS (<15-30 MIN):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = DimsTealPrimary
                    )

                    item.immediateClinicalInterventions.forEachIndexed { idx, step ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = DimsTealPrimary.copy(alpha = 0.15f),
                                modifier = Modifier.size(18.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${idx + 1}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = DimsTealPrimary
                                    )
                                }
                            }
                            Text(
                                text = step,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Column {
                        Text(
                            text = "COMMON ETIOLOGIES:",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = item.commonEtiologies,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Amber500.copy(alpha = 0.08f),
                        border = BorderStroke(0.5.dp, Amber500.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text("💡", fontSize = 11.sp)
                            Column {
                                Text(
                                    text = "DIAGNOSTIC PITFALL:",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Amber500
                                )
                                Text(
                                    text = item.diagnosticPitfalls,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (isExpanded) "Tap to collapse ▲" else "Tap for immediate emergency intervention checklist ▼",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
private fun DiagnosticRatioCard(
    ratio: DiagnosticRatioGuide,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(
            1.dp,
            if (isExpanded) Color(0xFF6366F1).copy(alpha = 0.5f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .testTag("diagnostic_ratio_item_${ratio.id}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = ratio.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Formula: ${ratio.formula}",
                        fontSize = 11.sp,
                        color = Color(0xFF6366F1),
                        fontWeight = FontWeight.Medium
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF6366F1).copy(alpha = 0.12f),
                    border = BorderStroke(0.5.dp, Color(0xFF6366F1))
                ) {
                    Text(
                        text = "Cutoff: ${ratio.cutoffThreshold}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6366F1),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Emerald500.copy(alpha = 0.06f),
                border = BorderStroke(0.5.dp, Emerald500.copy(alpha = 0.3f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = ratio.interpretationHigh,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Amber500.copy(alpha = 0.06f),
                border = BorderStroke(0.5.dp, Amber500.copy(alpha = 0.3f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = ratio.interpretationLow,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    Column {
                        Text(
                            text = "CLINICAL UTILITY:",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = DimsTealPrimary
                        )
                        Text(
                            text = ratio.clinicalUtility,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Column {
                        Text(
                            text = "RECOMMENDED NEXT DIAGNOSTIC WORKUP:",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = ratio.nextDiagnosticSteps,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (isExpanded) "Tap to collapse ▲" else "Tap for full diagnostic workup & pitfalls ▼",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            }
        }
    }
}
