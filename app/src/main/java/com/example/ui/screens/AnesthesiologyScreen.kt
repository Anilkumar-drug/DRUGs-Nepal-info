package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
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
import com.example.data.model.DiseaseProtocol
import com.example.data.model.Drug
import com.example.data.repository.AnesthesiologyDrugsData
import com.example.data.repository.AnesthesiologyProtocolsData
import com.example.ui.theme.*
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnesthesiologyScreen(
    onBackClick: () -> Unit,
    onDrugClick: (Drug) -> Unit,
    onProtocolClick: ((DiseaseProtocol) -> Unit)? = null
) {
    BackHandler { onBackClick() }

    var selectedTab by remember { mutableIntStateOf(0) } // 0: Agents & Dosing, 1: Crisis Protocols, 2: Dose Calculator
    var searchQuery by remember { mutableStateOf("") }
    var selectedClassFilter by remember { mutableStateOf("All Agents") }
    var patientWeightKg by remember { mutableFloatStateOf(70f) }

    val classFilters = listOf(
        "All Agents",
        "IV Induction",
        "Inhalation Gases",
        "NMBAs & Relaxants",
        "Reversal Agents",
        "Local & Neuraxial",
        "Opioids & Sedatives",
        "Vasopressors & Pressors",
        "Crisis Antidotes"
    )

    val allDrugs = remember { AnesthesiologyDrugsData.anesthesiaDrugs }
    val allProtocols = remember { AnesthesiologyProtocolsData.protocols }

    val filteredDrugs = remember(searchQuery, selectedClassFilter) {
        val q = searchQuery.trim().lowercase(Locale.ROOT)
        allDrugs.filter { drug ->
            val matchesFilter = when (selectedClassFilter) {
                "All Agents" -> true
                "IV Induction" -> drug.therapeuticClassTag?.contains("IV Anesthetic", ignoreCase = true) == true ||
                        drug.drugClass.contains("Intravenous General Anesthetic", ignoreCase = true) ||
                        drug.genericName.contains("Propofol", ignoreCase = true) ||
                        drug.genericName.contains("Ketamine", ignoreCase = true) ||
                        drug.genericName.contains("Etomidate", ignoreCase = true) ||
                        drug.genericName.contains("Thiopental", ignoreCase = true)
                "Inhalation Gases" -> drug.drugClass.contains("Inhalation", ignoreCase = true) ||
                        drug.genericName.contains("Sevoflurane", ignoreCase = true) ||
                        drug.genericName.contains("Isoflurane", ignoreCase = true)
                "NMBAs & Relaxants" -> drug.drugClass.contains("Neuromuscular", ignoreCase = true) ||
                        drug.drugClass.contains("Depolarizing", ignoreCase = true) ||
                        drug.genericName.contains("Succinylcholine", ignoreCase = true) ||
                        drug.genericName.contains("Rocuronium", ignoreCase = true) ||
                        drug.genericName.contains("Vecuronium", ignoreCase = true) ||
                        drug.genericName.contains("Atracurium", ignoreCase = true) ||
                        drug.genericName.contains("Cisatracurium", ignoreCase = true)
                "Reversal Agents" -> drug.therapeuticClassTag?.contains("Reversal", ignoreCase = true) == true ||
                        drug.genericName.contains("Sugammadex", ignoreCase = true) ||
                        drug.genericName.contains("Neostigmine", ignoreCase = true) ||
                        drug.genericName.contains("Glycopyrrolate", ignoreCase = true)
                "Local & Neuraxial" -> drug.drugClass.contains("Local Anesthetic", ignoreCase = true) ||
                        drug.genericName.contains("Bupivacaine", ignoreCase = true) ||
                        drug.genericName.contains("Lignocaine", ignoreCase = true) ||
                        drug.genericName.contains("Ropivacaine", ignoreCase = true)
                "Opioids & Sedatives" -> drug.genericName.contains("Fentanyl", ignoreCase = true) ||
                        drug.genericName.contains("Midazolam", ignoreCase = true) ||
                        drug.genericName.contains("Dexmedetomidine", ignoreCase = true)
                "Vasopressors & Pressors" -> drug.genericName.contains("Ephedrine", ignoreCase = true) ||
                        drug.genericName.contains("Phenylephrine", ignoreCase = true)
                "Crisis Antidotes" -> drug.genericName.contains("Dantrolene", ignoreCase = true) ||
                        drug.genericName.contains("Intralipid", ignoreCase = true)
                else -> true
            }

            val matchesQuery = if (q.isEmpty()) true else {
                drug.genericName.lowercase(Locale.ROOT).contains(q) ||
                        drug.drugClass.lowercase(Locale.ROOT).contains(q) ||
                        drug.indications.lowercase(Locale.ROOT).contains(q) ||
                        drug.brandsNepal.any { it.name.lowercase(Locale.ROOT).contains(q) } ||
                        drug.brandsIndia.any { it.name.lowercase(Locale.ROOT).contains(q) }
            }
            matchesFilter && matchesQuery
        }
    }

    Scaffold(
        containerColor = Color(0xFF090D16),
        topBar = {
            Surface(
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color(0xFFA855F7).copy(alpha = 0.4f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.testTag("anesthesiology_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .background(Color(0xFFA855F7).copy(alpha = 0.2f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.MedicalServices,
                                contentDescription = null,
                                tint = Color(0xFFA855F7),
                                modifier = Modifier.size(22.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "ANESTHESIOLOGY & OT",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    letterSpacing = 0.5.sp
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(0xFFA855F7).copy(alpha = 0.25f)
                                ) {
                                    Text(
                                        text = "24 DRUGS",
                                        color = Color(0xFFC084FC),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Induction, NMBAs, Inhalational, LAST, MH & Neuraxial",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.65f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Tab Navigation
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        TabButton(
                            title = "Agents & Dosing",
                            icon = Icons.Default.Medication,
                            isSelected = selectedTab == 0,
                            modifier = Modifier.weight(1f),
                            onClick = { selectedTab = 0 }
                        )
                        TabButton(
                            title = "Crisis Protocols",
                            icon = Icons.Default.WarningAmber,
                            isSelected = selectedTab == 1,
                            modifier = Modifier.weight(1f),
                            onClick = { selectedTab = 1 }
                        )
                        TabButton(
                            title = "Dose Calc",
                            icon = Icons.Default.Calculate,
                            isSelected = selectedTab == 2,
                            modifier = Modifier.weight(1f),
                            onClick = { selectedTab = 2 }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                0 -> AnestheticAgentsTab(
                    drugs = filteredDrugs,
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it },
                    classFilters = classFilters,
                    selectedClassFilter = selectedClassFilter,
                    onFilterSelect = { selectedClassFilter = it },
                    onDrugClick = onDrugClick
                )
                1 -> AnestheticCrisisProtocolsTab(
                    protocols = allProtocols,
                    onProtocolClick = onProtocolClick
                )
                2 -> AnestheticDoseCalculatorTab(
                    weightKg = patientWeightKg,
                    onWeightChange = { patientWeightKg = it },
                    onDrugClick = { drugName ->
                        allDrugs.find { it.genericName.contains(drugName, ignoreCase = true) }?.let { onDrugClick(it) }
                    }
                )
            }
        }
    }
}

@Composable
private fun TabButton(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = if (isSelected) Color(0xFFA855F7) else Color(0xFF1E293B),
        border = BorderStroke(
            1.dp,
            if (isSelected) Color(0xFFC084FC) else Color.White.copy(alpha = 0.1f)
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f),
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun AnestheticAgentsTab(
    drugs: List<Drug>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    classFilters: List<String>,
    selectedClassFilter: String,
    onFilterSelect: (String) -> Unit,
    onDrugClick: (Drug) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("anesthesia_search_field"),
            placeholder = { Text("Search anesthesia drug, brand, class...", color = Color.White.copy(alpha = 0.5f), fontSize = 13.sp) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color(0xFFA855F7))
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchQueryChange("") }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear", tint = Color.White.copy(alpha = 0.7f))
                    }
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF131B2E),
                unfocusedContainerColor = Color(0xFF131B2E),
                focusedBorderColor = Color(0xFFA855F7),
                unfocusedBorderColor = Color.White.copy(alpha = 0.15f),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Horizontal filter chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            classFilters.forEach { filter ->
                val isSelected = filter == selectedClassFilter
                FilterChip(
                    selected = isSelected,
                    onClick = { onFilterSelect(filter) },
                    label = {
                        Text(
                            text = filter,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFA855F7).copy(alpha = 0.3f),
                        selectedLabelColor = Color(0xFFE9D5FF),
                        containerColor = Color(0xFF1E293B).copy(alpha = 0.6f),
                        labelColor = Color.White.copy(alpha = 0.75f)
                    ),
                    border = BorderStroke(
                        1.dp,
                        if (isSelected) Color(0xFFA855F7) else Color.White.copy(alpha = 0.1f)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Showing ${drugs.size} Anesthetic Agent${if (drugs.size != 1) "s" else ""}",
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.6f),
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Drug List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(drugs.distinctBy { it.id }, key = { it.id }) { drug ->
                AnestheticDrugCard(
                    drug = drug,
                    onClick = { onDrugClick(drug) }
                )
            }
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
private fun AnestheticDrugCard(
    drug: Drug,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("anesthesia_drug_card_${drug.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF131B2E)),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.08f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = drug.genericName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = drug.drugClass,
                        fontSize = 11.5.sp,
                        color = Color(0xFFC084FC),
                        fontWeight = FontWeight.Medium
                    )
                }

                // DDA / Emergency Badge
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = when {
                        drug.genericName.contains("Dantrolene", ignoreCase = true) ||
                                drug.genericName.contains("Intralipid", ignoreCase = true) -> Color(0xFFEF4444).copy(alpha = 0.25f)
                        drug.ddaSchedule.contains("Schedule Ka", ignoreCase = true) -> Color(0xFFF59E0B).copy(alpha = 0.25f)
                        else -> Color(0xFFA855F7).copy(alpha = 0.2f)
                    }
                ) {
                    Text(
                        text = when {
                            drug.genericName.contains("Dantrolene", ignoreCase = true) -> "MH ANTIDOTE"
                            drug.genericName.contains("Intralipid", ignoreCase = true) -> "LAST RESCUE"
                            drug.ddaSchedule.contains("Schedule Ka", ignoreCase = true) -> "RESTRICTED KA"
                            else -> "OR POM"
                        },
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = when {
                            drug.genericName.contains("Dantrolene", ignoreCase = true) ||
                                    drug.genericName.contains("Intralipid", ignoreCase = true) -> Color(0xFFF87171)
                            drug.ddaSchedule.contains("Schedule Ka", ignoreCase = true) -> Color(0xFFFBBF24)
                            else -> Color(0xFFC084FC)
                        },
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            // Black box warning banner if present
            if (!drug.blackBoxWarning.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF7F1D1D).copy(alpha = 0.4f),
                    border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color(0xFFEF4444),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = drug.blackBoxWarning,
                            fontSize = 11.sp,
                            color = Color(0xFFFCA5A5),
                            fontWeight = FontWeight.Medium,
                            maxLines = if (expanded) Int.MAX_VALUE else 2
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Standard Dose Quick Summary
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Scale,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Standard Anesthesia Dosage:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF38BDF8)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = drug.adultDose ?: drug.doses.lines().take(2).joinToString("\n"),
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        lineHeight = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Available Brands Nepal / India
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nepal: ",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE2E8F0)
                )
                Text(
                    text = if (drug.brandsNepal.isNotEmpty()) {
                        drug.brandsNepal.take(3).joinToString(", ") { it.name }
                    } else "Imported Hospital Supply",
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8),
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Action Row: Expand / Full Monograph
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = { expanded = !expanded },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = if (expanded) "Show Less" else "Clinical Pearls & Details",
                        fontSize = 11.sp,
                        color = Color(0xFFA855F7),
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                        tint = Color(0xFFA855F7),
                        modifier = Modifier.size(16.dp)
                    )
                }

                Button(
                    onClick = onClick,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA855F7).copy(alpha = 0.2f)),
                    border = BorderStroke(1.dp, Color(0xFFA855F7).copy(alpha = 0.4f)),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier.height(30.dp)
                ) {
                    Text("Full Monograph", fontSize = 10.5.sp, color = Color(0xFFE9D5FF), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(imageVector = Icons.Default.OpenInNew, contentDescription = null, tint = Color(0xFFE9D5FF), modifier = Modifier.size(12.dp))
                }
            }

            // Expanded view
            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    HorizontalDivider(color = Color.White.copy(alpha = 0.1f))
                    Spacer(modifier = Modifier.height(8.dp))

                    DetailItem(label = "Mode of Action:", content = drug.modeOfAction)
                    Spacer(modifier = Modifier.height(6.dp))
                    DetailItem(label = "Administration & Precautions:", content = drug.administration)
                    Spacer(modifier = Modifier.height(6.dp))
                    DetailItem(label = "Key Precautions / Resuscitation:", content = drug.precautions)

                    if (!drug.counselingNepali.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF1E293B),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(
                                    text = "बिरामी / कन्सल्टिङ (Nepali):",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFBBF24)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = drug.counselingNepali,
                                    fontSize = 11.sp,
                                    color = Color.White.copy(alpha = 0.85f),
                                    lineHeight = 15.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailItem(label: String, content: String) {
    Column {
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFA855F7)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = content,
            fontSize = 11.sp,
            color = Color.White.copy(alpha = 0.8f),
            lineHeight = 15.sp
        )
    }
}

@Composable
private fun AnestheticCrisisProtocolsTab(
    protocols: List<DiseaseProtocol>,
    onProtocolClick: ((DiseaseProtocol) -> Unit)?
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF7F1D1D).copy(alpha = 0.35f),
                border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.6f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ReportProblem,
                        contentDescription = null,
                        tint = Color(0xFFEF4444),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "CRITICAL OR & PACU RESUSCITATION",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFCA5A5)
                        )
                        Text(
                            text = "Step-by-step consensus algorithms for malignant hyperthermia, LAST rescue, CICO and spinal emergencies.",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.75f)
                        )
                    }
                }
            }
        }

        items(protocols.distinctBy { it.id }, key = { it.id }) { protocol ->
            CrisisProtocolCard(
                protocol = protocol,
                onClick = { onProtocolClick?.invoke(protocol) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
private fun CrisisProtocolCard(
    protocol: DiseaseProtocol,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("crisis_protocol_card_${protocol.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF131B2E)),
        border = BorderStroke(
            1.dp,
            when {
                protocol.name.contains("Malignant Hyperthermia", ignoreCase = true) -> Color(0xFFEF4444).copy(alpha = 0.6f)
                protocol.name.contains("LAST", ignoreCase = true) -> Color(0xFFF59E0B).copy(alpha = 0.6f)
                else -> Color(0xFFA855F7).copy(alpha = 0.4f)
            }
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            when {
                                protocol.name.contains("Malignant Hyperthermia", ignoreCase = true) -> Color(0xFFEF4444).copy(alpha = 0.2f)
                                protocol.name.contains("LAST", ignoreCase = true) -> Color(0xFFF59E0B).copy(alpha = 0.2f)
                                else -> Color(0xFFA855F7).copy(alpha = 0.2f)
                            },
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = when {
                            protocol.name.contains("Malignant Hyperthermia", ignoreCase = true) -> Icons.Default.LocalFireDepartment
                            protocol.name.contains("LAST", ignoreCase = true) -> Icons.Default.Science
                            protocol.name.contains("Airway", ignoreCase = true) || protocol.name.contains("RSI", ignoreCase = true) -> Icons.Default.Air
                            else -> Icons.Default.HealthAndSafety
                        },
                        contentDescription = null,
                        tint = when {
                            protocol.name.contains("Malignant Hyperthermia", ignoreCase = true) -> Color(0xFFEF4444)
                            protocol.name.contains("LAST", ignoreCase = true) -> Color(0xFFF59E0B)
                            else -> Color(0xFFA855F7)
                        },
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = protocol.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = protocol.guidelines,
                        fontSize = 11.sp,
                        color = Color(0xFF38BDF8),
                        maxLines = 1
                    )
                }

                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.7f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Diagnostic Criteria
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Clinical Presentation / Diagnostic Triggers:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF59E0B)
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = protocol.diagnosticCriteria,
                        fontSize = 11.5.sp,
                        color = Color.White.copy(alpha = 0.85f),
                        lineHeight = 16.sp,
                        maxLines = if (expanded) Int.MAX_VALUE else 3
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // First Line Immediate Actions Summary
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF1E293B).copy(alpha = 0.7f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Immediate Resuscitation Algorithm (Step 1):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF10B981)
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = protocol.firstLine,
                        fontSize = 11.5.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        lineHeight = 16.sp,
                        maxLines = if (expanded) Int.MAX_VALUE else 4
                    )
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 10.dp)) {
                    // Second Line Actions
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF0F172A),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "Second-Line / Refractory Resuscitation:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF38BDF8)
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = protocol.secondLine,
                                fontSize = 11.5.sp,
                                color = Color.White.copy(alpha = 0.85f),
                                lineHeight = 16.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Inpatient / Post-Crisis Care
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF0F172A),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "Post-Resuscitation ICU Monitoring & Care:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFC084FC)
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = protocol.inpatient,
                                fontSize = 11.5.sp,
                                color = Color.White.copy(alpha = 0.85f),
                                lineHeight = 16.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Key Drugs
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Key Emergency Drugs: ",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                        Text(
                            text = protocol.keyDrugs.joinToString(", "),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFFBBF24)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AnestheticDoseCalculatorTab(
    weightKg: Float,
    onWeightChange: (Float) -> Unit,
    onDrugClick: (String) -> Unit
) {
    val roundedWeight = String.format(Locale.ROOT, "%.0f", weightKg).toFloatOrNull() ?: 70f

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            // Patient Weight Input Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF131B2E)),
                border = BorderStroke(1.dp, Color(0xFFA855F7).copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "PATIENT WEIGHT ESTIMATION",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFC084FC),
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = "Dynamic instant calculations for induction, paralysis & crisis rescue",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFA855F7).copy(alpha = 0.2f),
                            border = BorderStroke(1.dp, Color(0xFFA855F7))
                        ) {
                            Text(
                                text = "${roundedWeight.toInt()} kg",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Slider(
                        value = weightKg,
                        onValueChange = onWeightChange,
                        valueRange = 10f..140f,
                        steps = 129,
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFFA855F7),
                            activeTrackColor = Color(0xFFA855F7),
                            inactiveTrackColor = Color(0xFF1E293B)
                        ),
                        modifier = Modifier.testTag("weight_slider")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Child (10 kg)", fontSize = 10.sp, color = Color.White.copy(alpha = 0.5f))
                        Text("Ideal Adult (70 kg)", fontSize = 10.sp, color = Color.White.copy(alpha = 0.5f))
                        Text("Bariatric (140 kg)", fontSize = 10.sp, color = Color.White.copy(alpha = 0.5f))
                    }
                }
            }
        }

        item {
            SectionHeader(title = "INTRAVENOUS INDUCTION AGENTS", icon = Icons.Default.LocalHospital)
        }

        item {
            DoseCalcCard(
                drugName = "Propofol (1% / 10 mg/mL)",
                doseFormula = "2.0 - 2.5 mg/kg IV push",
                calculatedDose = "${(roundedWeight * 2.0).toInt()} - ${(roundedWeight * 2.5).toInt()} mg",
                calculatedVolume = "${String.format(Locale.ROOT, "%.1f", roundedWeight * 2.0 / 10.0)} - ${String.format(Locale.ROOT, "%.1f", roundedWeight * 2.5 / 10.0)} mL (1% emulsion)",
                clinicalTip = "Reduce to 1.0-1.5 mg/kg in elderly, frail or shock. Pre-treat with 20-40 mg IV lidocaine for injection pain.",
                accentColor = Color(0xFFA855F7),
                onClick = { onDrugClick("Propofol") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Ketamine HCl (50 mg/mL)",
                doseFormula = "1.5 - 2.0 mg/kg IV (or 4-6 mg/kg IM)",
                calculatedDose = "${(roundedWeight * 1.5).toInt()} - ${(roundedWeight * 2.0).toInt()} mg IV",
                calculatedVolume = "${String.format(Locale.ROOT, "%.1f", roundedWeight * 1.5 / 50.0)} - ${String.format(Locale.ROOT, "%.1f", roundedWeight * 2.0 / 50.0)} mL",
                clinicalTip = "Agent of choice in shock, sepsis & asthma. Co-administer Midazolam 1-2 mg IV to prevent emergence delirium.",
                accentColor = Color(0xFF10B981),
                onClick = { onDrugClick("Ketamine") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Etomidate (2 mg/mL)",
                doseFormula = "0.2 - 0.3 mg/kg IV slow push",
                calculatedDose = "${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.2)} - ${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.3)} mg",
                calculatedVolume = "${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.2 / 2.0)} - ${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.3 / 2.0)} mL",
                clinicalTip = "Cardiovascular stability; zero myocardial depression. Inhibits 11-beta-hydroxylase (adrenal suppression for 24h).",
                accentColor = Color(0xFF38BDF8),
                onClick = { onDrugClick("Etomidate") }
            )
        }

        item {
            SectionHeader(title = "NEUROMUSCULAR BLOCKERS & REVERSAL", icon = Icons.Default.Bolt)
        }

        item {
            DoseCalcCard(
                drugName = "Succinylcholine (50 mg/mL)",
                doseFormula = "1.0 - 1.5 mg/kg IV (RSI Gold Standard)",
                calculatedDose = "${(roundedWeight * 1.0).toInt()} - ${(roundedWeight * 1.5).toInt()} mg",
                calculatedVolume = "${String.format(Locale.ROOT, "%.1f", roundedWeight * 1.0 / 50.0)} - ${String.format(Locale.ROOT, "%.1f", roundedWeight * 1.5 / 50.0)} mL",
                clinicalTip = "Onset 30-60s, duration 5-10m. Contraindicated in burns >24h, denervation/paraplegia, hyperkalemia & MH history.",
                accentColor = Color(0xFFF59E0B),
                onClick = { onDrugClick("Succinylcholine") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Rocuronium Bromide (10 mg/mL)",
                doseFormula = "0.6 mg/kg standard OR 1.2 mg/kg RSI",
                calculatedDose = "Standard: ${(roundedWeight * 0.6).toInt()} mg | RSI: ${(roundedWeight * 1.2).toInt()} mg",
                calculatedVolume = "Standard: ${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.6 / 10.0)} mL | RSI: ${String.format(Locale.ROOT, "%.1f", roundedWeight * 1.2 / 10.0)} mL",
                clinicalTip = "RSI dose gives intubating conditions in 60s (equivalent to succinylcholine). Reversible instantly with Sugammadex.",
                accentColor = Color(0xFF38BDF8),
                onClick = { onDrugClick("Rocuronium") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Sugammadex Sodium (100 mg/mL)",
                doseFormula = "2 mg/kg (routine) / 4 mg/kg (deep) / 16 mg/kg (RSI rescue)",
                calculatedDose = "Moderate: ${(roundedWeight * 2.0).toInt()} mg | Deep: ${(roundedWeight * 4.0).toInt()} mg | Immediate: ${(roundedWeight * 16.0).toInt()} mg",
                calculatedVolume = "Mod: ${String.format(Locale.ROOT, "%.1f", roundedWeight * 2.0 / 100.0)} mL | Deep: ${String.format(Locale.ROOT, "%.1f", roundedWeight * 4.0 / 100.0)} mL | Rescue: ${String.format(Locale.ROOT, "%.1f", roundedWeight * 16.0 / 100.0)} mL",
                clinicalTip = "Encapsulates rocuronium molecules 1:1. Immediate reversal at 16 mg/kg produces complete recovery in ~3 minutes.",
                accentColor = Color(0xFF10B981),
                onClick = { onDrugClick("Sugammadex") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Neostigmine + Glycopyrrolate",
                doseFormula = "Neostigmine 0.05 mg/kg + Glycopyrrolate 0.01 mg/kg IV",
                calculatedDose = "Neostigmine: ${String.format(Locale.ROOT, "%.2f", roundedWeight * 0.05)} mg (max 5 mg) + Glyco: ${String.format(Locale.ROOT, "%.2f", roundedWeight * 0.01)} mg",
                calculatedVolume = "Neostigmine (0.5mg/mL): ${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.05 / 0.5)} mL + Glyco (0.2mg/mL): ${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.01 / 0.2)} mL",
                clinicalTip = "Administer slowly over 1 minute. Must have at least 2 twitches on Train-of-Four before giving neostigmine.",
                accentColor = Color(0xFFC084FC),
                onClick = { onDrugClick("Neostigmine") }
            )
        }

        item {
            SectionHeader(title = "CRISIS RESUSCITATION ANTIDOTES", icon = Icons.Default.Warning)
        }

        item {
            DoseCalcCard(
                drugName = "Dantrolene Sodium (Malignant Hyperthermia)",
                doseFormula = "2.5 mg/kg IV rapid bolus, repeat q5-10m prn (up to 10 mg/kg)",
                calculatedDose = "Initial Bolus: ${(roundedWeight * 2.5).toInt()} mg (Cumulative: up to ${(roundedWeight * 10.0).toInt()} mg)",
                calculatedVolume = "~${(roundedWeight * 2.5 / 20.0).toInt() + 1} Vials of 20 mg (each reconstituted in 60 mL sterile water)",
                clinicalTip = "MHAUS protocol: Call for help, stop inhalational gases & sux, give 100% O2, cool patient. Never give Ca-channel blockers!",
                accentColor = Color(0xFFEF4444),
                onClick = { onDrugClick("Dantrolene") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Intralipid 20% (LAST Resuscitation)",
                doseFormula = "Initial Bolus: 1.5 mL/kg IV over 1 min, then 0.25 mL/kg/min",
                calculatedDose = "Bolus: ${(roundedWeight * 1.5).toInt()} mL of 20% emulsion over 60s",
                calculatedVolume = "Continuous Infusion: ${String.format(Locale.ROOT, "%.1f", roundedWeight * 0.25)} mL/min (~${(roundedWeight * 0.25 * 60).toInt()} mL/hr)",
                clinicalTip = "ASRA 2024: Repeat bolus up to 2x if unstable. Max 12 mL/kg in 1 hour. Use low-dose epinephrine (<1 mcg/kg); avoid vasopressin.",
                accentColor = Color(0xFFF59E0B),
                onClick = { onDrugClick("Intralipid") }
            )
        }

        item {
            SectionHeader(title = "OBSTETRIC & POST-SPINAL VASOPRESSORS", icon = Icons.Default.Favorite)
        }

        item {
            DoseCalcCard(
                drugName = "Phenylephrine (Post-Spinal Hypotension)",
                doseFormula = "50 - 100 mcg IV bolus OR 25 - 50 mcg/min infusion",
                calculatedDose = "Bolus: 50 - 100 mcg IV | Infusion: 25 - 50 mcg/min",
                calculatedVolume = "Bolus: 1 - 2 mL of 50 mcg/mL solution (Dilute 10 mg in 200 mL NS)",
                clinicalTip = "First-line in Cesarean delivery (maintains maternal BP without causing fetal acidosis). Watch for reflex bradycardia.",
                accentColor = Color(0xFF38BDF8),
                onClick = { onDrugClick("Phenylephrine") }
            )
        }

        item {
            DoseCalcCard(
                drugName = "Ephedrine HCl (Post-Spinal Hypotension)",
                doseFormula = "5 - 10 mg IV bolus q3-5m prn (max 50 mg)",
                calculatedDose = "Bolus: 5 - 10 mg IV push",
                calculatedVolume = "1 - 2 mL of 5 mg/mL diluted solution (Dilute 30mg/1mL to 6mL with NS)",
                clinicalTip = "Preferred if hypotension is accompanied by bradycardia. Tachyphylaxis occurs with repeated doses.",
                accentColor = Color(0xFF10B981),
                onClick = { onDrugClick("Ephedrine") }
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
private fun SectionHeader(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp, bottom = 2.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color(0xFFA855F7), modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = title,
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC084FC),
            letterSpacing = 0.5.sp
        )
    }
}

@Composable
private fun DoseCalcCard(
    drugName: String,
    doseFormula: String,
    calculatedDose: String,
    calculatedVolume: String,
    clinicalTip: String,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF131B2E)),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.35f)),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = drugName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(18.dp)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Formula: $doseFormula",
                fontSize = 11.sp,
                color = Color.White.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                border = BorderStroke(1.dp, accentColor.copy(alpha = 0.2f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("TARGET DOSE", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = accentColor)
                        Text(calculatedDose, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                    }

                    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                        Text("VOLUME TO DRAW", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                        Text(calculatedVolume, fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.Top) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = Color(0xFFFBBF24),
                    modifier = Modifier
                        .size(13.dp)
                        .padding(top = 1.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = clinicalTip,
                    fontSize = 10.5.sp,
                    color = Color.White.copy(alpha = 0.75f),
                    lineHeight = 14.sp
                )
            }
        }
    }
}
