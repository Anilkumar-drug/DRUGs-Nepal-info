package com.example.ui.screens

import androidx.compose.animation.*
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Drug
import com.example.data.model.DrugInteraction
import com.example.data.model.InteractionSeverity
import com.example.data.repository.ClinicalRepository
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel
import com.example.viewmodel.NavigationScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun InteractionCheckerScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    var inlineSearchQuery by remember { mutableStateOf("") }
    var isPickerOpen by remember { mutableStateOf(false) }
    var selectedSeverityFilter by remember { mutableStateOf<InteractionSeverity?>(null) }

    val allDrugs = remember { ClinicalRepository.drugs }
    val selectedDrugs = remember(state.selectedInteractionDrugIds) {
        allDrugs.filter { state.selectedInteractionDrugIds.contains(it.id) }
    }

    val interactions = remember(state.selectedInteractionDrugIds) {
        ClinicalRepository.findInteractions(state.selectedInteractionDrugIds)
    }

    // Filter suggestions as user types in the inline box
    val inlineSuggestions = remember(inlineSearchQuery, state.selectedInteractionDrugIds) {
        val q = inlineSearchQuery.trim().lowercase()
        if (q.length < 2) emptyList()
        else allDrugs.filter { drug ->
            !state.selectedInteractionDrugIds.contains(drug.id) &&
            (drug.genericName.lowercase().contains(q) ||
             drug.brandsNepal.any { b -> b.name.lowercase().contains(q) } ||
             drug.brandsIndia.any { b -> b.name.lowercase().contains(q) })
        }.take(5)
    }

    // Filtered interaction results by severity filter if selected
    val displayedInteractions = remember(interactions, selectedSeverityFilter) {
        if (selectedSeverityFilter == null) interactions
        else interactions.filter { it.severity == selectedSeverityFilter }
    }

    val contraindicatedCount = remember(interactions) {
        interactions.count { it.severity == InteractionSeverity.CONTRAINDICATED }
    }
    val seriousCount = remember(interactions) {
        interactions.count { it.severity == InteractionSeverity.SERIOUS }
    }
    val moderateCount = remember(interactions) {
        interactions.count { it.severity == InteractionSeverity.MODERATE }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 96.dp)
    ) {
        // 1. Header Banner
        item {
            Surface(
                shape = RoundedCornerShape(18.dp),
                color = NavyCard,
                border = BorderStroke(1.dp, NavyCardBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = Red500.copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, Red500.copy(alpha = 0.45f)),
                        modifier = Modifier.size(44.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.ElectricBolt,
                                contentDescription = null,
                                tint = Red400,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Drug Interaction Checker",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Multi-drug contraindications & adverse reactions (UpToDate / Medscape / DIMS)",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                }
            }
        }

        // 2. Direct Search Input & Autocomplete
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
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
                        Text(
                            text = "Add Drug to Regimen",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        OutlinedButton(
                            onClick = { isPickerOpen = true },
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.List,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Browse All (${allDrugs.size})", fontSize = 11.sp)
                        }
                    }

                    OutlinedTextField(
                        value = inlineSearchQuery,
                        onValueChange = { inlineSearchQuery = it },
                        placeholder = {
                            Text(
                                text = "Type generic or brand (e.g. Warfarin, Moxclave, Metformin)...",
                                fontSize = 12.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = MedicalBlue400,
                                modifier = Modifier.size(18.dp)
                            )
                        },
                        trailingIcon = {
                            if (inlineSearchQuery.isNotEmpty()) {
                                IconButton(
                                    onClick = { inlineSearchQuery = "" },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Clear",
                                        tint = Slate400,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("interaction_drug_input_field")
                    )

                    // Autocomplete Suggestions Dropdown
                    AnimatedVisibility(visible = inlineSuggestions.isNotEmpty()) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(6.dp)) {
                                inlineSuggestions.forEach { drug ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(8.dp))
                                            .clickable {
                                                viewModel.toggleInteractionDrug(drug.id)
                                                inlineSearchQuery = ""
                                            }
                                            .padding(horizontal = 8.dp, vertical = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = drug.genericName,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            val brand = drug.brandsNepal.firstOrNull()?.name ?: drug.brandsIndia.firstOrNull()?.name ?: ""
                                            Text(
                                                text = "$brand • ${drug.drugClass}",
                                                fontSize = 10.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        FilledTonalButton(
                                            onClick = {
                                                viewModel.toggleInteractionDrug(drug.id)
                                                inlineSearchQuery = ""
                                            },
                                            shape = RoundedCornerShape(8.dp),
                                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                            modifier = Modifier.height(28.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                modifier = Modifier.size(14.dp)
                                            )
                                            Spacer(modifier = Modifier.width(2.dp))
                                            Text("Add", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 3. Medication Regimen Shelf
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
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
                            Text(
                                text = "Active Regimen",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                shape = CircleShape,
                                color = if (selectedDrugs.size >= 2) MedicalBlue400.copy(alpha = 0.2f) else Slate400.copy(alpha = 0.2f)
                            ) {
                                Text(
                                    text = "${selectedDrugs.size} drugs",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (selectedDrugs.size >= 2) MedicalBlue400 else Slate400,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        if (selectedDrugs.isNotEmpty()) {
                            TextButton(
                                onClick = { viewModel.clearInteractionDrugs() },
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                modifier = Modifier.height(30.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.DeleteSweep,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = MaterialTheme.colorScheme.error
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Clear All",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }

                    if (selectedDrugs.isEmpty()) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(14.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Medication,
                                    contentDescription = null,
                                    tint = Slate400,
                                    modifier = Modifier.size(28.dp)
                                )
                                Text(
                                    text = "No medications selected yet",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = "Type a medication above or select a preset below to check interactions.",
                                    fontSize = 10.sp,
                                    color = Slate400
                                )
                            }
                        }
                    } else {
                        // Selected drug chips (FlowRow style)
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            selectedDrugs.forEach { drug ->
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        modifier = Modifier.padding(start = 10.dp, end = 4.dp, top = 4.dp, bottom = 4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Medication,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.size(15.dp)
                                        )
                                        Column {
                                            Text(
                                                text = drug.genericName.split("+").first().trim(),
                                                style = MaterialTheme.typography.labelMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            val brand = drug.brandsNepal.firstOrNull()?.name ?: drug.brandsIndia.firstOrNull()?.name ?: drug.drugClass
                                            Text(
                                                text = brand,
                                                fontSize = 9.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        IconButton(
                                            onClick = { viewModel.toggleInteractionDrug(drug.id) },
                                            modifier = Modifier.size(22.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Close,
                                                contentDescription = "Remove ${drug.genericName}",
                                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                                modifier = Modifier.size(14.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Clinical Presets
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Clinical Presets:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        // 1. Warfarin + Diclofenac (Hemorrhage)
                        SuggestionChip(
                            onClick = {
                                viewModel.clearInteractionDrugs()
                                viewModel.toggleInteractionDrug("d36") // Warfarin
                                viewModel.toggleInteractionDrug("d55") // Diclofenac
                            },
                            label = { Text("Warfarin + Diclofenac (Bleed)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 2. Meropenem + Valproate (Status Epilepticus)
                        SuggestionChip(
                            onClick = {
                                viewModel.clearInteractionDrugs()
                                viewModel.toggleInteractionDrug("d32") // Meropenem
                                viewModel.toggleInteractionDrug("d52") // Sodium Valproate
                            },
                            label = { Text("Meropenem + Valproate (Seizure)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 3. Ramipril + Spironolactone (Hyperkalemia)
                        SuggestionChip(
                            onClick = {
                                viewModel.clearInteractionDrugs()
                                viewModel.toggleInteractionDrug("d39") // Ramipril
                                viewModel.toggleInteractionDrug("d40") // Spironolactone
                            },
                            label = { Text("Ramipril + Spironolactone (K+)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 4. Clopidogrel + Omeprazole
                        SuggestionChip(
                            onClick = {
                                viewModel.clearInteractionDrugs()
                                viewModel.toggleInteractionDrug("d23") // Clopidogrel
                                viewModel.toggleInteractionDrug("d8")  // Omeprazole
                            },
                            label = { Text("Clopidogrel + Omeprazole", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 5. Vancomycin + Piperacillin-Tazobactam
                        SuggestionChip(
                            onClick = {
                                viewModel.clearInteractionDrugs()
                                viewModel.toggleInteractionDrug("d33") // Vancomycin
                                viewModel.toggleInteractionDrug("d31") // Pip-Tazo
                            },
                            label = { Text("Vanc + Pip-Tazo (AKI)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 6. Cipro + Amlodipine
                        SuggestionChip(
                            onClick = {
                                viewModel.clearInteractionDrugs()
                                viewModel.toggleInteractionDrug("d7") // Ciprofloxacin
                                viewModel.toggleInteractionDrug("d6") // Amlodipine
                            },
                            label = { Text("Cipro + Amlodipine", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )
                    }
                }
            }
        }

        // 4. Analysis Summary Alert & Severity Filters
        if (selectedDrugs.size >= 2) {
            item {
                when {
                    contraindicatedCount > 0 -> {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Red950.copy(alpha = 0.45f),
                            border = BorderStroke(1.5.dp, Red500),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Cancel,
                                        contentDescription = null,
                                        tint = Red400,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(
                                        text = "CONTRAINDICATION DETECTED",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Black,
                                        color = Red400
                                    )
                                }
                                Text(
                                    text = "$contraindicatedCount combination(s) carry severe, life-threatening risks. Concurrent administration is strictly contraindicated under clinical guidelines.",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    seriousCount > 0 -> {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Amber950.copy(alpha = 0.45f),
                            border = BorderStroke(1.5.dp, Amber500),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.WarningAmber,
                                        contentDescription = null,
                                        tint = Amber400,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(
                                        text = "MAJOR ADVERSE EFFECT RISK",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Amber400
                                    )
                                }
                                Text(
                                    text = "$seriousCount major interaction(s) identified. Intensive laboratory or clinical monitoring and dosage adjustment are mandated.",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    moderateCount > 0 -> {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Indigo950.copy(alpha = 0.45f),
                            border = BorderStroke(1.5.dp, Indigo400),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = null,
                                        tint = Indigo400,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(
                                        text = "MODERATE INTERACTION IDENTIFIED",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Indigo400
                                    )
                                }
                                Text(
                                    text = "$moderateCount interaction(s) found. Dose timing separation or routine therapeutic observation recommended.",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    else -> {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Emerald500.copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.4f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = Emerald500,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(
                                        text = "No Documented Adverse Interactions",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Emerald500
                                    )
                                }
                                Text(
                                    text = "No known contraindications, high-risk CYP conflict, or adverse interactions detected between the selected medications in the clinical registry.",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            // Severity Filter Row
            if (interactions.isNotEmpty()) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FilterChip(
                            selected = selectedSeverityFilter == null,
                            onClick = { selectedSeverityFilter = null },
                            label = { Text("All (${interactions.size})", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp)
                        )
                        if (contraindicatedCount > 0) {
                            FilterChip(
                                selected = selectedSeverityFilter == InteractionSeverity.CONTRAINDICATED,
                                onClick = {
                                    selectedSeverityFilter = if (selectedSeverityFilter == InteractionSeverity.CONTRAINDICATED) null else InteractionSeverity.CONTRAINDICATED
                                },
                                label = { Text("Contraindicated ($contraindicatedCount)", fontSize = 11.sp, color = Red400) },
                                shape = RoundedCornerShape(10.dp)
                            )
                        }
                        if (seriousCount > 0) {
                            FilterChip(
                                selected = selectedSeverityFilter == InteractionSeverity.SERIOUS,
                                onClick = {
                                    selectedSeverityFilter = if (selectedSeverityFilter == InteractionSeverity.SERIOUS) null else InteractionSeverity.SERIOUS
                                },
                                label = { Text("Serious ($seriousCount)", fontSize = 11.sp, color = Amber400) },
                                shape = RoundedCornerShape(10.dp)
                            )
                        }
                        if (moderateCount > 0) {
                            FilterChip(
                                selected = selectedSeverityFilter == InteractionSeverity.MODERATE,
                                onClick = {
                                    selectedSeverityFilter = if (selectedSeverityFilter == InteractionSeverity.MODERATE) null else InteractionSeverity.MODERATE
                                },
                                label = { Text("Moderate ($moderateCount)", fontSize = 11.sp, color = Indigo400) },
                                shape = RoundedCornerShape(10.dp)
                            )
                        }
                    }
                }
            }

            // Gemini AI Clinical Copilot Action
            item {
                Surface(
                    onClick = {
                        val drugNames = selectedDrugs.joinToString(", ") { it.genericName }
                        val prompt = "Please clinically analyze the polypharmacy drug regimen: $drugNames. Check CYP450 enzyme conflicts, QT prolongation synergy, renal/hepatic clearance issues, potential adverse effects, and advise on dose adjustments and lab monitoring parameters."
                        viewModel.sendAiMessage(prompt)
                        viewModel.navigateTo(NavigationScreen.GEMINI)
                    },
                    shape = RoundedCornerShape(14.dp),
                    color = NavyDeep,
                    border = BorderStroke(1.dp, SparkleViolet.copy(alpha = 0.6f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = SparkleViolet,
                                modifier = Modifier.size(20.dp)
                            )
                            Column {
                                Text(
                                    text = "Ask Gemini AI Clinical Copilot",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    text = "Deep pharmacokinetic synergy, lab intervals & titration advice",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 10.sp,
                                    color = Slate400
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = SparkleViolet,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        // 5. Interaction Results Header & List
        if (selectedDrugs.size < 2) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CompareArrows,
                            contentDescription = null,
                            modifier = Modifier.size(54.dp),
                            tint = Slate400.copy(alpha = 0.6f)
                        )
                        Text(
                            text = "Add at least 2 medications to check interactions",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "Supports checking pairs, triplets, or complex multi-drug polypharmacy regimens.",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                }
            }
        } else {
            items(displayedInteractions) { item ->
                DetailedInteractionCard(item)
            }
        }
    }

    // Full Drug Selection Dialog / Bottom Sheet
    if (isPickerOpen) {
        AlertDialog(
            onDismissRequest = { isPickerOpen = false },
            title = {
                Text(
                    text = "Select Medication to Add",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                var modalQuery by remember { mutableStateOf("") }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = modalQuery,
                        onValueChange = { modalQuery = it },
                        placeholder = { Text("Search generic, Nepal or Indian brand...", fontSize = 12.sp) },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    val filteredDrugs = remember(modalQuery) {
                        val q = modalQuery.trim().lowercase()
                        if (q.isEmpty()) allDrugs
                        else allDrugs.filter {
                            it.genericName.lowercase().contains(q) ||
                            it.brandsNepal.any { b -> b.name.lowercase().contains(q) } ||
                            it.brandsIndia.any { b -> b.name.lowercase().contains(q) }
                        }
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(filteredDrugs) { drug ->
                            val isSelected = state.selectedInteractionDrugIds.contains(drug.id)
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                                border = BorderStroke(1.dp, if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { viewModel.toggleInteractionDrug(drug.id) }
                            ) {
                                Row(
                                    modifier = Modifier.padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = drug.genericName,
                                            style = MaterialTheme.typography.labelMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        val brand = drug.brandsNepal.firstOrNull()?.name ?: drug.brandsIndia.firstOrNull()?.name ?: ""
                                        Text(
                                            text = "$brand • ${drug.drugClass}",
                                            style = MaterialTheme.typography.bodySmall,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                    Checkbox(
                                        checked = isSelected,
                                        onCheckedChange = { viewModel.toggleInteractionDrug(drug.id) }
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = { isPickerOpen = false },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Done (${selectedDrugs.size} selected)")
                }
            }
        )
    }
}

@Composable
private fun DetailedInteractionCard(item: DrugInteraction) {
    val (badgeBg, badgeBorder, badgeText, badgeTitle) = when (item.severity) {
        InteractionSeverity.CONTRAINDICATED -> Quadruple(Red950, Red500, Red400, "CONTRAINDICATED / AVOID COMBINATION")
        InteractionSeverity.SERIOUS -> Quadruple(Amber950, Amber500, Amber400, "MAJOR / SERIOUS ADVERSE EFFECT")
        InteractionSeverity.MODERATE -> Quadruple(Indigo950, Indigo400, Indigo400, "MODERATE / MONITOR CLOSELY")
        InteractionSeverity.MINOR -> Quadruple(NavyPill, MedicalBlue400, MedicalBlue400, "MINOR / INFORMATIONAL")
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.2.dp, badgeBorder.copy(alpha = 0.6f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row: Drugs & Severity Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${item.drug1Generic} ↔ ${item.drug2Generic}",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = badgeBg,
                    border = BorderStroke(1.dp, badgeBorder)
                ) {
                    Text(
                        text = badgeTitle,
                        color = badgeText,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            // Potential Contraindications & Adverse Effect Box
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = when (item.severity) {
                    InteractionSeverity.CONTRAINDICATED -> Red500.copy(alpha = 0.12f)
                    InteractionSeverity.SERIOUS -> Amber500.copy(alpha = 0.12f)
                    else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                },
                border = BorderStroke(
                    1.dp,
                    when (item.severity) {
                        InteractionSeverity.CONTRAINDICATED -> Red500.copy(alpha = 0.35f)
                        InteractionSeverity.SERIOUS -> Amber500.copy(alpha = 0.35f)
                        else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = when (item.severity) {
                                InteractionSeverity.CONTRAINDICATED -> Icons.Default.Cancel
                                InteractionSeverity.SERIOUS -> Icons.Outlined.WarningAmber
                                else -> Icons.Default.Info
                            },
                            contentDescription = null,
                            tint = when (item.severity) {
                                InteractionSeverity.CONTRAINDICATED -> Red500
                                InteractionSeverity.SERIOUS -> Amber500
                                else -> Indigo400
                            },
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Potential Adverse Effects & Contraindications:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = when (item.severity) {
                                InteractionSeverity.CONTRAINDICATED -> Red500
                                InteractionSeverity.SERIOUS -> Amber500
                                else -> Indigo400
                            }
                        )
                    }
                    Text(
                        text = item.effect,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Mechanism
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Pharmacological Mechanism:",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = item.mechanism,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Evidence-Based Clinical Management
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Emerald500.copy(alpha = 0.08f),
                border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.MedicalInformation,
                        contentDescription = null,
                        tint = Emerald500,
                        modifier = Modifier.size(18.dp)
                    )
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = "Clinical Management & Action:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Emerald500
                        )
                        Text(
                            text = item.clinicalAction,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
