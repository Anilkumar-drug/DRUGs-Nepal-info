package com.example.ui.screens

import android.widget.Toast
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
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
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    var inlineSearchQuery by remember { mutableStateOf("") }
    var isPickerOpen by remember { mutableStateOf(false) }
    var selectedSeverityFilter by remember { mutableStateOf<InteractionSeverity?>(null) }
    var selectedDatabaseFilter by remember { mutableStateOf("All Databases") }

    // Patient Vulnerability Condition Modifiers
    var isElderly by remember { mutableStateOf(false) }
    var isRenalImpaired by remember { mutableStateOf(false) }
    var isHepaticImpaired by remember { mutableStateOf(false) }
    var isPregnant by remember { mutableStateOf(false) }

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
             drug.brandsIndia.any { b -> b.name.lowercase().contains(q) } ||
             drug.drugClass.lowercase().contains(q))
        }.take(5)
    }

    // Filtered interaction results by severity and medical database
    val displayedInteractions = remember(interactions, selectedSeverityFilter, selectedDatabaseFilter) {
        var list = interactions
        if (selectedSeverityFilter != null) {
            list = list.filter { it.severity == selectedSeverityFilter }
        }
        if (selectedDatabaseFilter != "All Databases") {
            list = list.filter {
                it.sourceDatabase.contains(selectedDatabaseFilter, ignoreCase = true) ||
                (selectedDatabaseFilter == "UpToDate" && it.sourceDatabase.contains("UpToDate", ignoreCase = true)) ||
                (selectedDatabaseFilter == "Medscape" && it.sourceDatabase.contains("Medscape", ignoreCase = true)) ||
                (selectedDatabaseFilter == "BNF" && it.sourceDatabase.contains("BNF", ignoreCase = true)) ||
                (selectedDatabaseFilter == "FDA" && it.sourceDatabase.contains("FDA", ignoreCase = true))
            }
        }
        list
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
    val totalPairsChecked = remember(selectedDrugs.size) {
        if (selectedDrugs.size < 2) 0 else (selectedDrugs.size * (selectedDrugs.size - 1)) / 2
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 96.dp)
    ) {
        // 1. Header Banner with Medical Databases attribution
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
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Drug Interaction Checker",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Emerald500.copy(alpha = 0.2f)
                            ) {
                                Text(
                                    text = "EVIDENCE-BASED",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Emerald400,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Multi-drug contraindications & adverse reactions backed by UpToDate, Medscape, Lexicomp & BNF databases.",
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
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddCircle,
                                contentDescription = null,
                                tint = DimsTealPrimary,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "Input Medication to Check",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
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
                                text = "Type drug (e.g. Warfarin, Meropenem, Ramipril, Moxclave)...",
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

        // 3. Medication Regimen Shelf & Presets
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
                                text = "Active Patient Regimen",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                shape = CircleShape,
                                color = if (selectedDrugs.size >= 2) MedicalBlue400.copy(alpha = 0.2f) else Slate400.copy(alpha = 0.2f)
                            ) {
                                Text(
                                    text = "${selectedDrugs.size} drugs • $totalPairsChecked pair(s)",
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
                                    text = "Add multiple medications above or tap a clinical polypharmacy preset below.",
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

                    // Polypharmacy Clinical Presets
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Medical Presets:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        // 1. Warfarin + Diclofenac
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d36", "d55"))
                            },
                            label = { Text("🔴 Warfarin + Diclofenac (Bleed)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 2. Meropenem + Valproate
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d32", "d52"))
                            },
                            label = { Text("🔴 Meropenem + Valproate (Seizure)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 3. Tramadol + Alprazolam
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d19", "d20"))
                            },
                            label = { Text("🔴 Tramadol + Alprazolam (Coma)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 4. Ramipril + Telmisartan
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d39", "d2"))
                            },
                            label = { Text("🔴 Ramipril + Telmisartan (Dual RAAS)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 5. Warfarin + Fluconazole
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d36", "d28"))
                            },
                            label = { Text("🔴 Warfarin + Fluconazole (INR Surge)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 6. Vancomycin + Gentamicin
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d33", "d34"))
                            },
                            label = { Text("🔴 Vanc + Gent (Nephro/Oto)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 7. Ramipril + Spironolactone
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d39", "d40"))
                            },
                            label = { Text("🟠 Ramipril + Spironolactone (K+)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 8. Digoxin + Furosemide
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d38", "d26"))
                            },
                            label = { Text("🟠 Digoxin + Furosemide (Arrhythmia)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 9. Clopidogrel + Omeprazole
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d23", "d8"))
                            },
                            label = { Text("🟠 Clopidogrel + Omeprazole", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 10. Triple QT Regimen
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d7", "d9", "d17"))
                            },
                            label = { Text("🟠 Cipro + Azithro + Ondansetron (TdP)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 11. Atorvastatin + Fluconazole
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d10", "d28"))
                            },
                            label = { Text("🟠 Atorvastatin + Fluconazole", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )

                        // 12. Levothyroxine + Calcium
                        SuggestionChip(
                            onClick = {
                                viewModel.setInteractionDrugs(listOf("d22", "d30"))
                            },
                            label = { Text("🟡 Levothyroxine + Calcium", fontSize = 11.sp) },
                            shape = RoundedCornerShape(12.dp)
                        )
                    }
                }
            }
        }

        // 4. Analysis Summary Alert & Vulnerability Modifiers
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
                                        text = "CONTRAINDICATION DETECTED ($contraindicatedCount)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Black,
                                        color = Red400
                                    )
                                }
                                Text(
                                    text = "$contraindicatedCount combination(s) carry severe, life-threatening clinical risks according to medical compendia (UpToDate, Medscape, BNF). Concurrent administration is strictly contraindicated.",
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
                                        text = "MAJOR / SERIOUS ADVERSE EFFECT RISK ($seriousCount)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Amber400
                                    )
                                }
                                Text(
                                    text = "$seriousCount major interaction(s) identified. Intensive laboratory or clinical monitoring, dosage titration, or therapeutic substitution is mandated under international guidelines.",
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
                                        text = "MODERATE INTERACTION IDENTIFIED ($moderateCount)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Indigo400
                                    )
                                }
                                Text(
                                    text = "$moderateCount interaction(s) found. Dose timing separation (2-4 hours) or routine therapeutic observation recommended.",
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
                                    text = "All $totalPairsChecked pairwise combinations checked across UpToDate, Medscape, and BNF databases. No known contraindications or high-risk CYP conflicts detected.",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            // Patient Vulnerability Condition Modifiers Card
            item {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Patient Clinical Vulnerability Modifiers:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            FilterChip(
                                selected = isElderly,
                                onClick = { isElderly = !isElderly },
                                label = { Text("Elderly (Age ≥65)", fontSize = 11.sp) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = if (isElderly) Icons.Default.Check else Icons.Outlined.Elderly,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            )
                            FilterChip(
                                selected = isRenalImpaired,
                                onClick = { isRenalImpaired = !isRenalImpaired },
                                label = { Text("Renal Impairment (CrCl <50)", fontSize = 11.sp) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = if (isRenalImpaired) Icons.Default.Check else Icons.Outlined.WaterDamage,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            )
                            FilterChip(
                                selected = isHepaticImpaired,
                                onClick = { isHepaticImpaired = !isHepaticImpaired },
                                label = { Text("Hepatic Disease", fontSize = 11.sp) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = if (isHepaticImpaired) Icons.Default.Check else Icons.Outlined.MedicalServices,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            )
                            FilterChip(
                                selected = isPregnant,
                                onClick = { isPregnant = !isPregnant },
                                label = { Text("Pregnancy / Lactation", fontSize = 11.sp) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = if (isPregnant) Icons.Default.Check else Icons.Outlined.PregnantWoman,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            )
                        }

                        if (isElderly || isRenalImpaired || isHepaticImpaired || isPregnant) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Amber500.copy(alpha = 0.1f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Warning,
                                        contentDescription = null,
                                        tint = Amber400,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        text = buildString {
                                            append("Heightened clinical risk: ")
                                            if (isElderly) append("Increased sedative and anticholinergic sensitivity (Beers criteria). ")
                                            if (isRenalImpaired) append("Decreased clearance of active metabolites; calculate eGFR. ")
                                            if (isHepaticImpaired) append("Impaired CYP clearance; caution with hepatotoxic drugs. ")
                                            if (isPregnant) append("Verify FDA pregnancy categories.")
                                        },
                                        fontSize = 10.sp,
                                        color = Amber300
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Severity & Medical Database Filter Row
            item {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    // Medical Database Source Filter
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Database:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        listOf("All Databases", "UpToDate", "Medscape", "BNF", "FDA").forEach { db ->
                            FilterChip(
                                selected = selectedDatabaseFilter == db,
                                onClick = { selectedDatabaseFilter = db },
                                label = { Text(db, fontSize = 11.sp) },
                                shape = RoundedCornerShape(10.dp)
                            )
                        }
                    }

                    // Severity Filter Row
                    if (interactions.isNotEmpty()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Severity:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
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
            }

            // Report Export & AI Copilot Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Copy Regimen Safety Report
                    OutlinedButton(
                        onClick = {
                            val report = buildString {
                                appendLine("=== DRUGS NEPAL: MULTI-DRUG INTERACTION REPORT ===")
                                appendLine("Regimen: ${selectedDrugs.joinToString(", ") { it.genericName }}")
                                appendLine("Total Combinations Analyzed: $totalPairsChecked")
                                appendLine("Contraindications: $contraindicatedCount | Serious: $seriousCount | Moderate: $moderateCount")
                                appendLine("--------------------------------------------------")
                                if (displayedInteractions.isEmpty()) {
                                    appendLine("No documented adverse interactions found in clinical databases.")
                                } else {
                                    displayedInteractions.forEachIndexed { index, inter ->
                                        appendLine("${index + 1}. [${inter.severity.label.uppercase()}] ${inter.drug1Generic} <-> ${inter.drug2Generic}")
                                        appendLine("   Source: ${inter.sourceDatabase} (${inter.documentationLevel})")
                                        appendLine("   Adverse Effect: ${inter.effect}")
                                        appendLine("   Mechanism: ${inter.mechanism}")
                                        appendLine("   Action: ${inter.clinicalAction}")
                                        appendLine()
                                    }
                                }
                            }
                            clipboardManager.setText(AnnotatedString(report))
                            Toast.makeText(context, "Clinical Regimen Report copied to clipboard", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Copy Report", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                    // Gemini AI Clinical Copilot Action
                    Button(
                        onClick = {
                            val drugNames = selectedDrugs.joinToString(", ") { it.genericName }
                            val prompt = "Please clinically analyze the polypharmacy drug regimen: $drugNames. Check CYP450 enzyme conflicts, QT prolongation synergy, renal/hepatic clearance issues, potential adverse effects, and advise on dose adjustments and lab monitoring parameters."
                            viewModel.sendAiMessage(prompt)
                            viewModel.navigateTo(NavigationScreen.GEMINI)
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = SparkleViolet),
                        modifier = Modifier
                            .weight(1.3f)
                            .height(44.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Ask AI Copilot", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
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
                            text = "Supports checking pairs, triplets, or complex multi-drug polypharmacy regimens across medical databases.",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                }
            }
        } else {
            items(displayedInteractions) { item ->
                DetailedInteractionCard(
                    item = item,
                    onConsultAi = {
                        val prompt = "Clinically analyze the interaction between ${item.drug1Generic} and ${item.drug2Generic}. What are the precise clinical risks, dosage modifications, and safer alternatives?"
                        viewModel.sendAiMessage(prompt)
                        viewModel.navigateTo(NavigationScreen.GEMINI)
                    }
                )
            }
        }
    }

    // Full Multi-Select Drug Picker Dialog
    if (isPickerOpen) {
        DrugPickerModal(
            allDrugs = allDrugs,
            selectedDrugIds = state.selectedInteractionDrugIds,
            onToggleDrug = { viewModel.toggleInteractionDrug(it) },
            onDismiss = { isPickerOpen = false }
        )
    }
}

@Composable
private fun DetailedInteractionCard(
    item: DrugInteraction,
    onConsultAi: () -> Unit
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

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

            // Medical Database Attribution & Evidence Badges
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MedicalBlue500.copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, MedicalBlue400.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = MedicalBlue400,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = item.sourceDatabase,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MedicalBlue400
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Emerald500.copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.35f))
                ) {
                    Text(
                        text = item.documentationLevel,
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Emerald400,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Slate700.copy(alpha = 0.4f)
                ) {
                    Text(
                        text = item.riskCategory,
                        fontSize = 9.5.sp,
                        color = Slate300,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            // Potential Adverse Effects & Contraindications Box
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

            // Pharmacological Mechanism
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
                            text = "Evidence-Based Clinical Management:",
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

            // Action Buttons Footer
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = {
                        val text = "${item.drug1Generic} ↔ ${item.drug2Generic} [${item.severity.label}]\nAdverse Effect: ${item.effect}\nMechanism: ${item.mechanism}\nAction: ${item.clinicalAction}\nSource: ${item.sourceDatabase}"
                        clipboardManager.setText(AnnotatedString(text))
                        Toast.makeText(context, "Interaction summary copied", Toast.LENGTH_SHORT).show()
                    },
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier.height(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Copy", fontSize = 11.sp)
                }

                Spacer(modifier = Modifier.width(6.dp))

                FilledTonalButton(
                    onClick = onConsultAi,
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
                    modifier = Modifier.height(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = SparkleViolet
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Consult AI", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun DrugPickerModal(
    allDrugs: List<Drug>,
    selectedDrugIds: Set<String>,
    onToggleDrug: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var modalQuery by remember { mutableStateOf("") }
    var selectedSystemFilter by remember { mutableStateOf("All Systems") }

    val systemCategories = remember(allDrugs) {
        listOf("All Systems") + allDrugs.map { it.system }.distinct().sorted()
    }

    val filteredDrugs = remember(modalQuery, selectedSystemFilter) {
        val q = modalQuery.trim().lowercase()
        allDrugs.filter { drug ->
            val matchSystem = selectedSystemFilter == "All Systems" || drug.system == selectedSystemFilter
            val matchQuery = q.isEmpty() ||
                drug.genericName.lowercase().contains(q) ||
                drug.brandsNepal.any { b -> b.name.lowercase().contains(q) } ||
                drug.brandsIndia.any { b -> b.name.lowercase().contains(q) } ||
                drug.drugClass.lowercase().contains(q)
            matchSystem && matchQuery
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Select Regimen Medications",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "${selectedDrugIds.size} selected",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(460.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = modalQuery,
                    onValueChange = { modalQuery = it },
                    placeholder = { Text("Search generic, brand, or class...", fontSize = 12.sp) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = {
                        if (modalQuery.isNotEmpty()) {
                            IconButton(onClick = { modalQuery = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // Category system filter chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    systemCategories.forEach { sys ->
                        FilterChip(
                            selected = selectedSystemFilter == sys,
                            onClick = { selectedSystemFilter = sys },
                            label = { Text(sys.split(" ").first(), fontSize = 11.sp) }
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(filteredDrugs) { drug ->
                        val isSelected = selectedDrugIds.contains(drug.id)
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                            border = BorderStroke(1.dp, if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onToggleDrug(drug.id) }
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
                                    onCheckedChange = { onToggleDrug(drug.id) }
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Done (${selectedDrugIds.size} selected)")
            }
        }
    )
}

private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
