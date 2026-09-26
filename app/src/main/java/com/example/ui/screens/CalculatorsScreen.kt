package com.example.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.calculator.ClinicalCalculators
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel

private data class CalculatorMeta(
    val id: String,
    val title: String,
    val category: String,
    val icon: ImageVector,
    val description: String,
    val formulaSummary: String,
    val iconColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorsScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    if (state.selectedCalculatorId != null) {
        CalculatorDetailView(state, viewModel)
    } else {
        CalculatorsListView(state, viewModel)
    }
}

@Composable
private fun CalculatorsListView(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = remember {
        listOf("All", "Renal & Dosing", "Critical Care", "Cardiology", "Hepatology", "Toxicology", "Pediatrics", "Emergency & Nepal")
    }

    val allCalculators = remember {
        listOf(
            CalculatorMeta(
                id = "egfr",
                title = "eGFR (Cockcroft-Gault)",
                category = "Renal & Dosing",
                icon = Icons.Default.WaterDrop,
                description = "Estimates Creatinine Clearance (CrCl) for kidney function evaluation and antibiotic / renal dose adjustment.",
                formulaSummary = "CrCl = [(140 - Age) × Wt] / (72 × SCr) [× 0.85 if female]",
                iconColor = MedicalBlue400
            ),
            CalculatorMeta(
                id = "bsa",
                title = "BSA (Mosteller Formula)",
                category = "Renal & Dosing",
                icon = Icons.Default.Straighten,
                description = "Calculates Body Surface Area in m² for narrow-therapeutic-index dosing, chemotherapy & burn estimation.",
                formulaSummary = "BSA (m²) = √[(Height in cm × Weight in kg) / 3600]",
                iconColor = Emerald400
            ),
            CalculatorMeta(
                id = "child_pugh",
                title = "Child-Pugh Score",
                category = "Hepatology",
                icon = Icons.Default.LocalHospital,
                description = "Assesses prognosis and 1- to 2-year mortality in cirrhosis / chronic liver disease. Guides hepatic drug dosing.",
                formulaSummary = "Class A (5-6) • Class B (7-9) • Class C (10-15)",
                iconColor = Amber400
            ),
            CalculatorMeta(
                id = "cha2ds2",
                title = "CHA₂DS₂-VASc AFib Score",
                category = "Cardiology",
                icon = Icons.Default.Favorite,
                description = "Calculates 1-year thromboembolic stroke risk in non-valvular Atrial Fibrillation. Guides oral anticoagulation.",
                formulaSummary = "Score 0 (Low) • 1 (Intermediate) • ≥2 (Anticoagulation Indicated)",
                iconColor = Red400
            ),
            CalculatorMeta(
                id = "curb65",
                title = "CURB-65 Pneumonia Score",
                category = "Critical Care",
                icon = Icons.Default.Air,
                description = "Predicts 30-day mortality in Community-Acquired Pneumonia. Directs Outpatient vs Inpatient Ward vs ICU admission.",
                formulaSummary = "Score 0-1 Outpatient • 2 Inpatient Ward • 3-5 ICU Care",
                iconColor = Color(0xFF38BDF8)
            ),
            CalculatorMeta(
                id = "gcs",
                title = "Glasgow Coma Scale (GCS)",
                category = "Critical Care",
                icon = Icons.Default.Psychology,
                description = "Gold-standard objective neurological scoring for acute level of consciousness in trauma and critical care.",
                formulaSummary = "Eye Response (1-4) + Verbal (1-5) + Motor (1-6)",
                iconColor = Color(0xFFA855F7)
            ),
            CalculatorMeta(
                id = "rumack",
                title = "Paracetamol Nomogram",
                category = "Toxicology",
                icon = Icons.Default.Timeline,
                description = "Rumack-Matthew Nomogram evaluating single acute acetaminophen overdose hepatotoxicity vs time.",
                formulaSummary = "Treatment Line: 150 mcg/mL at 4h post-ingestion for NAC therapy",
                iconColor = Amber500
            ),
            CalculatorMeta(
                id = "pediatric",
                title = "Pediatric Liquid Dose",
                category = "Pediatrics",
                icon = Icons.Default.ChildCare,
                description = "Calculates precise liquid syrup/suspension volume (mL) from weight-based mg/kg to prevent 10-fold errors.",
                formulaSummary = "Dose Volume (mL) = [Weight (kg) × Dose (mg/kg)] / Concentration",
                iconColor = Emerald400
            ),
            CalculatorMeta(
                id = "iv_infusion",
                title = "IV Infusion & Drop Rate",
                category = "Critical Care",
                icon = Icons.Default.Opacity,
                description = "Calculates pump rate (mL/hr) and gravity drip rate (gtt/min) for Noradrenaline, Dopamine, and critical infusions.",
                formulaSummary = "Drop Rate (gtt/min) = (mL/hr × Drop Factor) / 60",
                iconColor = Cyan500
            ),
            CalculatorMeta(
                id = "snakebite",
                title = "Nepal Snakebite & ASV",
                category = "Emergency & Nepal",
                icon = Icons.Default.Healing,
                description = "National Snakebite Protocol (EDCD Nepal): ASV dosing, 20WBCT assessment, and Neostigmine challenge protocol.",
                formulaSummary = "Initial 10 Vials Polyvalent ASV in 500 mL NS over 1h + Atropine/Neostigmine",
                iconColor = Red500
            ),
            CalculatorMeta(
                id = "rabies_pep",
                title = "Rabies PEP & Immunoglobulin",
                category = "Emergency & Nepal",
                icon = Icons.Default.Shield,
                description = "WHO / EDCD Nepal Rabies Prophylaxis: Category I-III wound care, Intradermal (2-site) vs IM vaccine, and RIG dosing.",
                formulaSummary = "Thai Red Cross 2-site ID (0.1 mL) D0,3,7,28 + ERIG 40 IU/kg",
                iconColor = Emerald500
            )
        )
    }

    val filteredCalculators = remember(searchQuery, selectedCategory) {
        val q = searchQuery.trim().lowercase()
        allCalculators.filter { calc ->
            val matchesCategory = when (selectedCategory) {
                "All" -> true
                else -> calc.category.equals(selectedCategory, ignoreCase = true)
            }
            val matchesQuery = if (q.isEmpty()) true else {
                calc.title.lowercase().contains(q) ||
                calc.category.lowercase().contains(q) ||
                calc.description.lowercase().contains(q) ||
                calc.formulaSummary.lowercase().contains(q)
            }
            matchesCategory && matchesQuery
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MedicalBlue900.copy(alpha = 0.35f),
            border = BorderStroke(1.dp, MedicalBlue500.copy(alpha = 0.35f))
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = MedicalBlue500.copy(alpha = 0.2f),
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Calculate,
                            contentDescription = null,
                            tint = MedicalBlue400,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Clinical Cal Suite",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Select any clinical formula or score below to view details and calculate.",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Search Field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search calculator (e.g. eGFR, CURB, GCS, Liver)...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { searchQuery = "" },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Clear", modifier = Modifier.size(18.dp))
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("calculator_search_input"),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            singleLine = true
        )

        // Specialty Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = cat },
                    label = {
                        Text(
                            text = cat,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    shape = RoundedCornerShape(18.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = Color.White,
                        containerColor = MaterialTheme.colorScheme.surface,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                        enabled = true,
                        selected = isSelected
                    )
                )
            }
        }

        // Calculators List (Cards)
        if (filteredCalculators.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth(0.85f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SearchOff,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = "No calculators found",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Try clearing the search or category filter above.",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(filteredCalculators, key = { it.id }) { item ->
                    val isBookmarked = state.bookmarkedCalculatorIds.contains(item.id)
                    CalculatorSummaryCard(
                        meta = item,
                        isBookmarked = isBookmarked,
                        onBookmarkToggle = { viewModel.toggleBookmarkCalculator(item.id) },
                        onClick = { viewModel.openCalculator(item.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun CalculatorSummaryCard(
    meta: CalculatorMeta,
    isBookmarked: Boolean,
    onBookmarkToggle: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("calc_card_${meta.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
        border = BorderStroke(1.dp, meta.iconColor.copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header Row: Icon, Title, Category Badge, Bookmark Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        color = meta.iconColor.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, meta.iconColor.copy(alpha = 0.4f)),
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = meta.icon,
                                contentDescription = null,
                                tint = meta.iconColor,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Column {
                        Text(
                            text = meta.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = meta.iconColor.copy(alpha = 0.12f),
                            border = BorderStroke(0.8.dp, meta.iconColor.copy(alpha = 0.3f)),
                            modifier = Modifier.padding(top = 2.dp)
                        ) {
                            Text(
                                text = meta.category,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = meta.iconColor,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onBookmarkToggle,
                    modifier = Modifier
                        .size(36.dp)
                        .testTag("bookmark_calc_${meta.id}")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Unbookmark" else "Bookmark",
                        tint = if (isBookmarked) Amber400 else Slate400,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Description
            Text(
                text = meta.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Formula chip & Action Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Text(
                        text = meta.formulaSummary,
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Calculate",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun CalculatorDetailView(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    val tabs = remember {
        listOf(
            "egfr" to "eGFR",
            "bsa" to "BSA",
            "child_pugh" to "Child-Pugh",
            "cha2ds2" to "CHA₂DS₂-VASc",
            "curb65" to "CURB-65",
            "gcs" to "GCS",
            "rumack" to "Paracetamol",
            "pediatric" to "Pediatric",
            "iv_infusion" to "IV Infusion",
            "snakebite" to "Snakebite ASV",
            "rabies_pep" to "Rabies PEP"
        )
    }

    val activeCalcName = remember(state.activeCalcTab) {
        when (state.activeCalcTab) {
            "egfr" -> "eGFR (Cockcroft-Gault)"
            "bsa" -> "BSA (Mosteller)"
            "child_pugh" -> "Child-Pugh Score"
            "cha2ds2" -> "CHA₂DS₂-VASc AFib"
            "curb65" -> "CURB-65 Pneumonia"
            "gcs" -> "GCS Score & Coma"
            "rumack" -> "Paracetamol Nomogram"
            "pediatric" -> "Pediatric Liquid Dose"
            "iv_infusion" -> "IV Infusion & Drop Rate"
            "snakebite" -> "Nepal Snakebite ASV Protocol"
            "rabies_pep" -> "Rabies Post-Exposure Prophylaxis"
            else -> "Clinical Calculator"
        }
    }

    BackHandler(enabled = true) {
        viewModel.closeCalculator()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Top Navigation Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = { viewModel.closeCalculator() },
                    modifier = Modifier
                        .size(38.dp)
                        .testTag("back_to_calculators_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back to Calculators",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Column {
                    Text(
                        text = activeCalcName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Interactive Clinical Calculator",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            val isCalcBookmarked = state.bookmarkedCalculatorIds.contains(state.activeCalcTab)
            IconButton(
                onClick = { viewModel.toggleBookmarkCalculator(state.activeCalcTab) },
                modifier = Modifier
                    .size(38.dp)
                    .testTag("bookmark_calc_${state.activeCalcTab}")
            ) {
                Icon(
                    imageVector = if (isCalcBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                    contentDescription = if (isCalcBookmarked) "Unbookmark calculator" else "Bookmark calculator",
                    tint = if (isCalcBookmarked) Amber400 else Slate400,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        // Quick Switch Tabs Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            tabs.forEach { (tabKey, tabTitle) ->
                val isSelected = state.activeCalcTab == tabKey
                val tabIcon = when (tabKey) {
                    "egfr" -> Icons.Default.WaterDrop
                    "bsa" -> Icons.Default.Straighten
                    "child_pugh" -> Icons.Default.LocalHospital
                    "cha2ds2" -> Icons.Default.Favorite
                    "curb65" -> Icons.Default.Air
                    "gcs" -> Icons.Default.Psychology
                    "rumack" -> Icons.Default.Timeline
                    else -> Icons.Default.ChildCare
                }

                FilterChip(
                    selected = isSelected,
                    onClick = { viewModel.setCalcTab(tabKey) },
                    leadingIcon = {
                        Icon(
                            imageVector = tabIcon,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp),
                            tint = if (isSelected) Color.White else MaterialTheme.colorScheme.primary
                        )
                    },
                    label = {
                        Text(
                            text = tabTitle,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    },
                    shape = RoundedCornerShape(18.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = Color.White,
                        containerColor = MaterialTheme.colorScheme.surface,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                        enabled = true,
                        selected = isSelected
                    ),
                    modifier = Modifier.testTag("calc_tab_$tabKey")
                )
            }
        }

        // Calculator Body
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .testTag("calculator_container"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                when (state.activeCalcTab) {
                    "egfr" -> EgfrCalculatorView(state, viewModel)
                    "bsa" -> BsaCalculatorView(state, viewModel)
                    "child_pugh" -> ChildPughCalculatorView(state, viewModel)
                    "cha2ds2" -> Cha2Ds2VascCalculatorView(state, viewModel)
                    "curb65" -> Curb65CalculatorView(state, viewModel)
                    "gcs" -> GcsCalculatorView(state, viewModel)
                    "rumack" -> ParacetamolCalculatorView(state, viewModel)
                    "pediatric" -> PediatricCalculatorView(state, viewModel)
                    "iv_infusion" -> IvInfusionCalculatorView()
                    "snakebite" -> SnakebiteCalculatorView()
                    "rabies_pep" -> RabiesPepCalculatorView()
                }

                // Back to list button at bottom
                OutlinedButton(
                    onClick = { viewModel.closeCalculator() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 40.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Back to All Calculators",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

// 1. eGFR Cockcroft-Gault
@Composable
private fun EgfrCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var ageStr by remember(state.egfrAge) { mutableStateOf(state.egfrAge.toString()) }
    var weightStr by remember(state.egfrWeight) { mutableStateOf(state.egfrWeight.toString()) }
    var scrStr by remember(state.egfrScr) { mutableStateOf(state.egfrScr.toString()) }
    var isFemale by remember(state.egfrIsFemale) { mutableStateOf(state.egfrIsFemale) }

    fun triggerCalc() {
        val a = ageStr.toIntOrNull() ?: 55
        val w = weightStr.toDoubleOrNull() ?: 65.0
        val s = scrStr.toDoubleOrNull() ?: 1.2
        viewModel.updateEgfrInputs(a, w, s, isFemale)
    }

    Text(
        text = "Creatinine Clearance / eGFR (Cockcroft-Gault)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = ageStr,
            onValueChange = { ageStr = it; triggerCalc() },
            label = { Text("Age (yrs)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f).testTag("egfr_age_input"),
            singleLine = true
        )
        OutlinedTextField(
            value = weightStr,
            onValueChange = { weightStr = it; triggerCalc() },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f).testTag("egfr_weight_input"),
            singleLine = true
        )
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = scrStr,
            onValueChange = { scrStr = it; triggerCalc() },
            label = { Text("Serum Cr (mg/dL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.weight(1f).testTag("egfr_scr_input"),
            singleLine = true
        )
        Column(modifier = Modifier.weight(1f)) {
            Text("Biological Sex", style = MaterialTheme.typography.labelSmall)
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = !isFemale,
                    onClick = { isFemale = false; triggerCalc() }
                )
                Text("Male", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.width(8.dp))
                RadioButton(
                    selected = isFemale,
                    onClick = { isFemale = true; triggerCalc() }
                )
                Text("Female", style = MaterialTheme.typography.bodySmall)
            }
        }
    }

    // Result Card
    val result = state.egfrResult
    if (result != null) {
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Estimated CrCl: ${String.format("%.1f", result.crcl)} mL/min",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Black,
                    color = Emerald400
                )
                Text(
                    text = result.stage,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = result.clinicalImplication,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// 2. BSA Mosteller
@Composable
private fun BsaCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var htStr by remember(state.bsaHeight) { mutableStateOf(state.bsaHeight.toString()) }
    var wtStr by remember(state.bsaWeight) { mutableStateOf(state.bsaWeight.toString()) }

    fun triggerCalc() {
        val h = htStr.toDoubleOrNull() ?: 165.0
        val w = wtStr.toDoubleOrNull() ?: 60.0
        viewModel.updateBsaInputs(h, w)
    }

    Text(
        text = "Body Surface Area (BSA) Calculator",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = htStr,
            onValueChange = { htStr = it; triggerCalc() },
            label = { Text("Height (cm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f).testTag("bsa_height_input"),
            singleLine = true
        )
        OutlinedTextField(
            value = wtStr,
            onValueChange = { wtStr = it; triggerCalc() },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f).testTag("bsa_weight_input"),
            singleLine = true
        )
    }

    val res = state.bsaResult
    if (res != null) {
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Mosteller BSA: ${String.format("%.2f", res.mostellerBsa)} m²",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Black,
                    color = Emerald400
                )
                Text(
                    text = "DuBois Formula: ${String.format("%.2f", res.duboisBsa)} m²",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = res.normalComparison,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// 3. Child-Pugh Score
@Composable
private fun ChildPughCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var biliStr by remember(state.cpBilirubin) { mutableStateOf(state.cpBilirubin.toString()) }
    var albStr by remember(state.cpAlbumin) { mutableStateOf(state.cpAlbumin.toString()) }
    var inrStr by remember(state.cpInr) { mutableStateOf(state.cpInr.toString()) }
    var ascites by remember(state.cpAscitesScore) { mutableStateOf(state.cpAscitesScore) }
    var enceph by remember(state.cpEncephScore) { mutableStateOf(state.cpEncephScore) }

    fun triggerCalc() {
        val b = biliStr.toDoubleOrNull() ?: 1.5
        val a = albStr.toDoubleOrNull() ?: 3.5
        val i = inrStr.toDoubleOrNull() ?: 1.2
        viewModel.updateChildPughInputs(b, a, i, ascites, enceph)
    }

    Text(
        text = "Child-Pugh Score for Cirrhosis & Drug Metabolism",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = biliStr,
            onValueChange = { biliStr = it; triggerCalc() },
            label = { Text("Bilirubin (mg/dL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        OutlinedTextField(
            value = albStr,
            onValueChange = { albStr = it; triggerCalc() },
            label = { Text("Albumin (g/dL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        OutlinedTextField(
            value = inrStr,
            onValueChange = { inrStr = it; triggerCalc() },
            label = { Text("INR") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
    }

    // Ascites
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Ascites:", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(1 to "None", 2 to "Slight/Controlled", 3 to "Moderate/Severe").forEach { (score, label) ->
                FilterChip(
                    selected = ascites == score,
                    onClick = { ascites = score; triggerCalc() },
                    label = { Text(label, fontSize = 11.sp) }
                )
            }
        }
    }

    // Encephalopathy
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Hepatic Encephalopathy:", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(1 to "None", 2 to "Grade 1-2", 3 to "Grade 3-4").forEach { (score, label) ->
                FilterChip(
                    selected = enceph == score,
                    onClick = { enceph = score; triggerCalc() },
                    label = { Text(label, fontSize = 11.sp) }
                )
            }
        }
    }

    val res = state.cpResult
    if (res != null) {
        val color = when (res.totalScore) {
            in 5..6 -> Emerald400
            in 7..9 -> Amber400
            else -> Red400
        }
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = color.copy(alpha = 0.15f),
            border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Total Score: ${res.totalScore} points — ${res.childClass}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black,
                    color = color
                )
                Text(text = "Survival Estimate: ${res.oneYearSurvival}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
                Text(text = "Pharmacology Impact: ${res.drugGuidance}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

// 4. Paracetamol Overdose Rumack-Matthew
@Composable
private fun ParacetamolCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var hoursStr by remember(state.apapHours) { mutableStateOf(state.apapHours.toString()) }
    var levelStr by remember(state.apapLevel) { mutableStateOf(state.apapLevel.toString()) }

    fun triggerCalc() {
        val h = hoursStr.toDoubleOrNull() ?: 4.0
        val l = levelStr.toDoubleOrNull() ?: 160.0
        viewModel.updateParacetamolInputs(h, l)
    }

    Text(
        text = "Acute Paracetamol Overdose (Rumack-Matthew Nomogram)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = Red400
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = hoursStr,
            onValueChange = { hoursStr = it; triggerCalc() },
            label = { Text("Hours Post-Ingestion") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        OutlinedTextField(
            value = levelStr,
            onValueChange = { levelStr = it; triggerCalc() },
            label = { Text("Serum APAP (µg/mL)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
    }

    val res = state.apapResult
    if (res != null) {
        val boxColor = if (res.isToxicityProbable) Red950 else Emerald950
        val borderColor = if (res.isToxicityProbable) Red500 else Emerald500
        val textColor = if (res.isToxicityProbable) Red400 else Emerald400

        Surface(
            shape = RoundedCornerShape(14.dp),
            color = boxColor.copy(alpha = 0.5f),
            border = androidx.compose.foundation.BorderStroke(1.dp, borderColor),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = if (res.isToxicityProbable) "TOXICITY PROBABLE (Above Treatment Line)" else "BELOW TREATMENT LINE (Non-toxic)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black,
                    color = textColor
                )
                Text(
                    text = "Treatment threshold at this timepoint: ${String.format("%.1f", res.treatmentLineCutoff)} µg/mL",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = res.action,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 18.sp
                )
            }
        }
    }
}

// 5. Pediatric Liquid Dose
@Composable
private fun PediatricCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var wtStr by remember(state.pedWeight) { mutableStateOf(state.pedWeight.toString()) }
    var doseStr by remember(state.pedDoseMgKg) { mutableStateOf(state.pedDoseMgKg.toString()) }
    var sMgStr by remember(state.pedSyrupMg) { mutableStateOf(state.pedSyrupMg.toString()) }
    var sMlStr by remember(state.pedSyrupMl) { mutableStateOf(state.pedSyrupMl.toString()) }

    fun triggerCalc() {
        val w = wtStr.toDoubleOrNull() ?: 14.0
        val d = doseStr.toDoubleOrNull() ?: 15.0
        val smg = sMgStr.toDoubleOrNull() ?: 125.0
        val sml = sMlStr.toDoubleOrNull() ?: 5.0
        viewModel.updatePediatricInputs(w, d, smg, sml)
    }

    Text(
        text = "Pediatric Weight-Based Liquid Dose Converter",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = Emerald400
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = wtStr,
            onValueChange = { wtStr = it; triggerCalc() },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        OutlinedTextField(
            value = doseStr,
            onValueChange = { doseStr = it; triggerCalc() },
            label = { Text("Dose (mg/kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = sMgStr,
            onValueChange = { sMgStr = it; triggerCalc() },
            label = { Text("Syrup mg") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        OutlinedTextField(
            value = sMlStr,
            onValueChange = { sMlStr = it; triggerCalc() },
            label = { Text("Per mL volume") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f),
            singleLine = true
        )
    }

    val res = state.pedResult
    if (res != null) {
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = Emerald950.copy(alpha = 0.4f),
            border = androidx.compose.foundation.BorderStroke(1.dp, Emerald500.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Total Dose: ${String.format("%.0f", res.totalDoseMg)} mg",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Emerald400
                )
                Text(
                    text = "Measure: ${String.format("%.1f", res.volumeMl)} mL of oral suspension",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Black,
                    color = Emerald400
                )
            }
        }
    }
}

// 6. CHA2DS2-VASc Atrial Fibrillation Stroke Risk View
@Composable
private fun Cha2Ds2VascCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var chf by remember(state.chadsChf) { mutableStateOf(state.chadsChf) }
    var htn by remember(state.chadsHypertension) { mutableStateOf(state.chadsHypertension) }
    var ageGroup by remember(state.chadsAgeGroup) { mutableStateOf(state.chadsAgeGroup) }
    var dm by remember(state.chadsDiabetes) { mutableStateOf(state.chadsDiabetes) }
    var stroke by remember(state.chadsStrokeTia) { mutableStateOf(state.chadsStrokeTia) }
    var vasc by remember(state.chadsVascular) { mutableStateOf(state.chadsVascular) }
    var female by remember(state.chadsIsFemale) { mutableStateOf(state.chadsIsFemale) }

    fun triggerCalc() {
        viewModel.updateCha2Ds2VascInputs(chf, htn, ageGroup, dm, stroke, vasc, female)
    }

    Text(
        text = "CHA₂DS₂-VASc Score for AFib Stroke Risk",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "Risk stratification determining indication for oral anticoagulation (OAC / DOACs).",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    // Age Category Chips
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Age Category:", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(0 to "< 65 yrs (0 pt)", 1 to "65–74 yrs (+1)", 2 to "≥ 75 yrs (+2)").forEach { (idx, label) ->
                FilterChip(
                    selected = ageGroup == idx,
                    onClick = { ageGroup = idx; triggerCalc() },
                    label = { Text(label, fontSize = 11.sp) }
                )
            }
        }
    }

    // Sex Category Chips
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Sex Category:", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = !female,
                onClick = { female = false; triggerCalc() },
                label = { Text("Male (0 pt)", fontSize = 11.sp) }
            )
            FilterChip(
                selected = female,
                onClick = { female = true; triggerCalc() },
                label = { Text("Female (+1 pt)", fontSize = 11.sp) }
            )
        }
    }

    // Risk factors switches / chips
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text("Clinical Risk Factors:", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = chf,
                onClick = { chf = !chf; triggerCalc() },
                label = { Text("Congestive Heart Failure (+1)", fontSize = 11.sp) },
                modifier = Modifier.weight(1f)
            )
            FilterChip(
                selected = htn,
                onClick = { htn = !htn; triggerCalc() },
                label = { Text("Hypertension (+1)", fontSize = 11.sp) },
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = dm,
                onClick = { dm = !dm; triggerCalc() },
                label = { Text("Diabetes Mellitus (+1)", fontSize = 11.sp) },
                modifier = Modifier.weight(1f)
            )
            FilterChip(
                selected = stroke,
                onClick = { stroke = !stroke; triggerCalc() },
                label = { Text("Prior Stroke / TIA (+2)", fontSize = 11.sp) },
                modifier = Modifier.weight(1f)
            )
        }

        FilterChip(
            selected = vasc,
            onClick = { vasc = !vasc; triggerCalc() },
            label = { Text("Vascular Disease (Prior MI, PAD, Aortic Plaque) (+1)", fontSize = 11.sp) }
        )
    }

    val res = state.chadsResult
    if (res != null) {
        val badgeColor = when {
            res.totalScore == 0 -> Emerald400
            res.totalScore == 1 && female -> Emerald400
            res.totalScore == 1 -> Amber400
            else -> Red400
        }
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = badgeColor.copy(alpha = 0.15f),
            border = androidx.compose.foundation.BorderStroke(1.dp, badgeColor.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "CHA₂DS₂-VASc: ${res.totalScore} pts",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black,
                        color = badgeColor
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = badgeColor.copy(alpha = 0.25f)
                    ) {
                        Text(
                            text = "${res.strokeRiskPercentPerYear}% / yr stroke rate",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = badgeColor
                        )
                    }
                }
                Text(
                    text = "Stratum: ${res.riskStratum}",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = res.recommendation,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

// 7. CURB-65 Pneumonia Severity Score View
@Composable
private fun Curb65CalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var conf by remember(state.curbConfusion) { mutableStateOf(state.curbConfusion) }
    var urea by remember(state.curbUrea) { mutableStateOf(state.curbUrea) }
    var rr by remember(state.curbRespRate) { mutableStateOf(state.curbRespRate) }
    var bp by remember(state.curbBpLow) { mutableStateOf(state.curbBpLow) }
    var age65 by remember(state.curbAge65) { mutableStateOf(state.curbAge65) }

    fun triggerCalc() {
        viewModel.updateCurb65Inputs(conf, urea, rr, bp, age65)
    }

    Text(
        text = "CURB-65 Pneumonia Severity Score",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "Calculates 30-day mortality risk in Community-Acquired Pneumonia (CAP) to guide site of care (Outpatient vs Hospital vs ICU).",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        FilterChip(
            selected = conf,
            onClick = { conf = !conf; triggerCalc() },
            label = { Text("C — Confusion (New disorientation or AMTS ≤ 8) (+1)", fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth()
        )
        FilterChip(
            selected = urea,
            onClick = { urea = !urea; triggerCalc() },
            label = { Text("U — Urea > 7 mmol/L (or BUN > 19 mg/dL) (+1)", fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth()
        )
        FilterChip(
            selected = rr,
            onClick = { rr = !rr; triggerCalc() },
            label = { Text("R — Respiratory rate ≥ 30 breaths / min (+1)", fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth()
        )
        FilterChip(
            selected = bp,
            onClick = { bp = !bp; triggerCalc() },
            label = { Text("B — Blood pressure (SBP < 90 or DBP ≤ 60 mmHg) (+1)", fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth()
        )
        FilterChip(
            selected = age65,
            onClick = { age65 = !age65; triggerCalc() },
            label = { Text("65 — Age ≥ 65 years (+1)", fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth()
        )
    }

    val res = state.curbResult
    if (res != null) {
        val color = when (res.totalScore) {
            0, 1 -> Emerald400
            2 -> Amber400
            else -> Red400
        }
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = color.copy(alpha = 0.15f),
            border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Score: ${res.totalScore} / 5 points",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black,
                        color = color
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = color.copy(alpha = 0.25f)
                    ) {
                        Text(
                            text = "${res.mortalityRiskPercent}% 30-day mortality",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = color
                        )
                    }
                }
                Text(text = res.riskGroup, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                Text(text = "Guidance: ${res.managementGuidance}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

// 8. Glasgow Coma Scale (GCS) View
@Composable
private fun GcsCalculatorView(state: ClinicalUiState, viewModel: ClinicalViewModel) {
    var eye by remember(state.gcsEye) { mutableStateOf(state.gcsEye) }
    var verbal by remember(state.gcsVerbal) { mutableStateOf(state.gcsVerbal) }
    var motor by remember(state.gcsMotor) { mutableStateOf(state.gcsMotor) }

    fun triggerCalc() {
        viewModel.updateGcsInputs(eye, verbal, motor)
    }

    Text(
        text = "Glasgow Coma Scale (GCS)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "Rapid objective assessment of level of consciousness in trauma, stroke, or poisoning.",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    // Eye Response (1 to 4)
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Eye Opening (E 1-4):", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf(
                4 to "4 - Spontaneous",
                3 to "3 - To Speech",
                2 to "2 - To Pain",
                1 to "1 - None"
            ).forEach { (score, label) ->
                FilterChip(
                    selected = eye == score,
                    onClick = { eye = score; triggerCalc() },
                    label = { Text(label, fontSize = 11.sp) }
                )
            }
        }
    }

    // Verbal Response (1 to 5)
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Verbal Response (V 1-5):", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf(
                5 to "5 - Oriented",
                4 to "4 - Confused",
                3 to "3 - Inappropriate",
                2 to "2 - Incomprehensible",
                1 to "1 - None"
            ).forEach { (score, label) ->
                FilterChip(
                    selected = verbal == score,
                    onClick = { verbal = score; triggerCalc() },
                    label = { Text(label, fontSize = 11.sp) }
                )
            }
        }
    }

    // Motor Response (1 to 6)
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("Motor Response (M 1-6):", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf(
                6 to "6 - Obeys Commands",
                5 to "5 - Localizes Pain",
                4 to "4 - Withdraws (Flexion)",
                3 to "3 - Decorticate (Abnormal Flexion)",
                2 to "2 - Decerebrate (Extension)",
                1 to "1 - None"
            ).forEach { (score, label) ->
                FilterChip(
                    selected = motor == score,
                    onClick = { motor = score; triggerCalc() },
                    label = { Text(label, fontSize = 11.sp) }
                )
            }
        }
    }

    val res = state.gcsResult
    if (res != null) {
        val color = when {
            res.totalScore <= 8 -> Red400
            res.totalScore in 9..12 -> Amber400
            else -> Emerald400
        }
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = color.copy(alpha = 0.15f),
            border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total GCS: ${res.totalScore} / 15",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Black,
                        color = color
                    )
                    Text(
                        text = "E${res.eyeScore} V${res.verbalScore} M${res.motorScore}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Text(
                    text = res.severity,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                Text(
                    text = res.clinicalGuidance,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
