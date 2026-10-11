package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Drug
import com.example.data.repository.ClinicalRepository
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel

data class SystemItem(
    val id: String,
    val name: String,
    val shortName: String,
    val icon: ImageVector,
    val accentColor: Color,
    val description: String,
    val keywords: List<String>,
    val quickFilters: List<String> = emptyList()
)

val SYSTEM_CATEGORIES: List<SystemItem> = listOf(
    SystemItem(
        id = "GI",
        name = "Gastrointestinal & Hepatobiliary",
        shortName = "GI System",
        icon = Icons.Default.LocalHospital,
        accentColor = Indigo400,
        description = "PPIs, Antiemetics, Laxatives, Hepatic & Biliary, IBD",
        keywords = listOf("gastro", "git", "gis", "hepat"),
        quickFilters = listOf(
            "All",
            "Acid Peptic / PPIs",
            "Antiemetics",
            "Liver & Biliary",
            "Laxatives & Motility",
            "Antidiarrheals / IBD",
            "Antispasmodics",
            "Bookmarked"
        )
    ),
    SystemItem(
        id = "CVS",
        name = "Cardiovascular System (CVS)",
        shortName = "Cardiovascular",
        icon = Icons.Default.Favorite,
        accentColor = Red500,
        description = "Antihypertensives, Statins, Antiarrhythmics, Heart Failure",
        keywords = listOf("cardio", "cvs", "vascular", "lipid"),
        quickFilters = listOf("All", "Antihypertensives", "Statins & Lipids", "Antiarrhythmics", "Heart Failure", "Bookmarked")
    ),
    SystemItem(
        id = "CNS",
        name = "Central Nervous System (CNS)",
        shortName = "CNS & Neuro",
        icon = Icons.Default.Psychology,
        accentColor = Color(0xFFA855F7),
        description = "Analgesics, Antiepileptics, Sedatives, Antidepressants",
        keywords = listOf("central nervous", "cns", "neuro", "psych", "nervous"),
        quickFilters = listOf("All", "Analgesics & Pain", "Antiepileptics", "Psychiatry", "Sedatives", "Bookmarked")
    ),
    SystemItem(
        id = "INFECT",
        name = "Anti-Infectives & Antimicrobials",
        shortName = "Antimicrobials",
        icon = Icons.Default.Shield,
        accentColor = Emerald500,
        description = "Antibiotics, Antivirals, Antifungals, Antiparasitics",
        keywords = listOf("infect", "antimicrob", "antibiot", "antivir", "antifung"),
        quickFilters = listOf("All", "Antibiotics", "Antivirals", "Antifungals", "Antiparasitics", "Bookmarked")
    ),
    SystemItem(
        id = "RS",
        name = "Respiratory System (RS)",
        shortName = "Respiratory",
        icon = Icons.Default.Air,
        accentColor = MedicalBlue500,
        description = "Bronchodilators, Inhalers, Corticosteroids, Mucolytics",
        keywords = listOf("respirat", "pulmon", " rs"),
        quickFilters = listOf("All", "Bronchodilators & Inhalers", "Inhaled Steroids", "Cough & Cold", "Bookmarked")
    ),
    SystemItem(
        id = "ENDO",
        name = "Endocrine & Metabolic System",
        shortName = "Endocrine",
        icon = Icons.Default.WaterDrop,
        accentColor = Amber500,
        description = "Oral Hypoglycemics, Insulin, Thyroid, Corticosteroids",
        keywords = listOf("endocrin", "metabolic", "diabet", "thyroid"),
        quickFilters = listOf("All", "Diabetes (OHA / Insulin)", "Thyroid", "Steroids", "Bookmarked")
    ),
    SystemItem(
        id = "RENAL",
        name = "Renal & Genitourinary",
        shortName = "Renal / GU",
        icon = Icons.Default.Science,
        accentColor = Color(0xFF06B6D4),
        description = "Diuretics, UTI Agents, BPH Therapy, Bladder",
        keywords = listOf("renal", "nephro", "genitourinary", "uro"),
        quickFilters = listOf("All", "Diuretics", "BPH & Bladder", "Electrolytes", "Bookmarked")
    ),
    SystemItem(
        id = "MSK",
        name = "Musculoskeletal & Analgesics",
        shortName = "MSK & Joint",
        icon = Icons.Default.FitnessCenter,
        accentColor = Color(0xFFF97316),
        description = "NSAIDs, Antipyretics, Muscle Relaxants, Gout",
        keywords = listOf("musculo", "msk", "joint", "analges", "bone", "rheum"),
        quickFilters = listOf("All", "NSAIDs & Pain", "Muscle Relaxants", "Gout & Arthritis", "Bookmarked")
    ),
    SystemItem(
        id = "EMERGENCY",
        name = "Emergency & Critical Care",
        shortName = "ER / ICU",
        icon = Icons.Default.Emergency,
        accentColor = Red600,
        description = "Vasopressors, Resuscitation, Antidotes, Shock",
        keywords = listOf("emerg", "critical", "resuscit", "toxic", "acls", "poison", "antidote"),
        quickFilters = listOf("All", "Vasopressors & Inotropes", "Antidotes", "Resuscitation", "Bookmarked")
    ),
    SystemItem(
        id = "DERM",
        name = "Dermatology & Skin Disorders",
        shortName = "Dermatology",
        icon = Icons.Default.Spa,
        accentColor = Color(0xFFEC4899),
        description = "Topical Steroids, Antifungals, Retinoids, Antibacterials",
        keywords = listOf("dermat", "skin"),
        quickFilters = listOf("All", "Topical Steroids", "Antifungals", "Antibacterial Creams", "Bookmarked")
    )
)

/**
 * Filter drugs for a given system category.
 */
fun getDrugsForSystem(drugs: List<Drug>, item: SystemItem): List<Drug> {
    return drugs.filter { drug ->
        val s = drug.system.lowercase()
        item.keywords.any { k -> s.contains(k) }
    }.sortedBy { it.genericName.trim().lowercase() }
}

/**
 * Enhanced SystemBrowseScreen supporting inline drug listing when a system is clicked.
 * NEVER directs to the home/search page upon clicking a system!
 */
@Composable
fun SystemBrowseScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel,
    onDrugClick: (Drug) -> Unit = { viewModel.openDrug(it) },
    onBookmarkToggle: (String) -> Unit = { viewModel.toggleBookmark(it) },
    onSystemSelected: ((String) -> Unit)? = null
) {
    val allDrugs = remember { ClinicalRepository.drugs }

    // Selected system item state
    var selectedSystem by remember {
        mutableStateOf<SystemItem?>(
            state.selectedSystemFilter?.let { filterName ->
                SYSTEM_CATEGORIES.find { it.name.equals(filterName, ignoreCase = true) || it.keywords.any { k -> filterName.lowercase().contains(k) } }
            }
        )
    }

    var categorySearchQuery by remember { mutableStateOf("") }
    var inSystemSearchQuery by remember { mutableStateOf("") }
    var selectedSubFilter by remember { mutableStateOf("All") }
    var selectedAlphabetLetter by remember { mutableStateOf<Char?>(null) }

    // Intercept back button if currently viewing a system's drug list
    BackHandler(enabled = selectedSystem != null) {
        selectedSystem = null
        inSystemSearchQuery = ""
        selectedSubFilter = "All"
        selectedAlphabetLetter = null
    }

    if (selectedSystem == null) {
        // ==========================================
        // 1. ORGAN SYSTEMS DIRECTORY / GRID VIEW
        // ==========================================
        val filteredCategories = remember(categorySearchQuery) {
            if (categorySearchQuery.isBlank()) {
                SYSTEM_CATEGORIES
            } else {
                val q = categorySearchQuery.trim().lowercase()
                SYSTEM_CATEGORIES.filter {
                    it.name.lowercase().contains(q) ||
                    it.shortName.lowercase().contains(q) ||
                    it.description.lowercase().contains(q)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Screen Header & Explanation
            Column(modifier = Modifier.padding(top = 4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountTree,
                        contentDescription = null,
                        tint = Indigo400,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Drugs by Organ System",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Select an anatomical system to view all registered drugs, dosing, and Nepal trade brands.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Quick Category Search
            OutlinedTextField(
                value = categorySearchQuery,
                onValueChange = { categorySearchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("system_category_search"),
                placeholder = { Text("Filter systems (e.g. GI, Cardio, Respiratory)...", fontSize = 13.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                trailingIcon = {
                    if (categorySearchQuery.isNotBlank()) {
                        IconButton(onClick = { categorySearchQuery = "" }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                )
            )

            // Systems Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 88.dp)
            ) {
                items(filteredCategories, key = { it.id }) { item ->
                    val systemDrugs = remember(item.id, allDrugs) {
                        getDrugsForSystem(allDrugs, item)
                    }
                    val count = systemDrugs.size

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(152.dp)
                            .clickable {
                                selectedSystem = item
                                inSystemSearchQuery = ""
                                selectedSubFilter = "All"
                                onSystemSelected?.invoke(item.name)
                            }
                            .testTag("system_card_${item.id}"),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        border = BorderStroke(1.dp, item.accentColor.copy(alpha = 0.35f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            item.accentColor.copy(alpha = 0.09f),
                                            Color.Transparent
                                        )
                                    )
                                )
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(12.dp),
                                        color = item.accentColor.copy(alpha = 0.18f),
                                        modifier = Modifier.size(38.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Icon(
                                                imageVector = item.icon,
                                                contentDescription = null,
                                                tint = item.accentColor,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                    }

                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = item.accentColor.copy(alpha = 0.12f),
                                        border = BorderStroke(0.6.dp, item.accentColor.copy(alpha = 0.35f))
                                    ) {
                                        Text(
                                            text = "$count drugs",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = item.accentColor,
                                            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                                        )
                                    }
                                }

                                Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                    Text(
                                        text = item.name,
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        maxLines = 2,
                                        lineHeight = 16.sp
                                    )
                                    Text(
                                        text = item.description,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontSize = 10.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    } else {
        // ==========================================
        // 2. SYSTEM DRUGS LIST VIEW (E.G. GI SYSTEM 64 DRUGS)
        // ==========================================
        val activeSystem: SystemItem = selectedSystem ?: return
        val baseSystemDrugs = remember(activeSystem.id, allDrugs) {
            getDrugsForSystem(allDrugs, activeSystem)
        }

        // Sub-filter, alphabetical letter & search matching
        val displayedDrugs = remember(baseSystemDrugs, inSystemSearchQuery, selectedSubFilter, selectedAlphabetLetter, state.bookmarkedDrugIds) {
            var list = baseSystemDrugs

            // Apply sub-filter
            if (selectedSubFilter != "All") {
                list = when (selectedSubFilter) {
                    "Bookmarked" -> list.filter { state.bookmarkedDrugIds.contains(it.id) }
                    "Acid Peptic / PPIs" -> list.filter {
                        it.drugClass.contains("PPI", ignoreCase = true) ||
                        it.drugClass.contains("Proton Pump", ignoreCase = true) ||
                        it.drugClass.contains("P-CAB", ignoreCase = true) ||
                        it.genericName.contains("prazole", ignoreCase = true) ||
                        it.genericName.contains("vonoprazan", ignoreCase = true) ||
                        it.genericName.contains("vonopran", ignoreCase = true) ||
                        it.drugClass.contains("Antacid", ignoreCase = true) ||
                        it.drugClass.contains("Alginate", ignoreCase = true) ||
                        it.drugClass.contains("H2", ignoreCase = true)
                    }
                    "Antiemetics" -> list.filter {
                        it.drugClass.contains("Antiemetic", ignoreCase = true) ||
                        it.drugClass.contains("5-HT3", ignoreCase = true) ||
                        it.drugClass.contains("NK1", ignoreCase = true) ||
                        it.genericName.contains("setron", ignoreCase = true) ||
                        it.genericName.contains("Aprepitant", ignoreCase = true)
                    }
                    "Liver & Biliary" -> list.filter {
                        it.drugClass.contains("Hepato", ignoreCase = true) ||
                        it.drugClass.contains("Liver", ignoreCase = true) ||
                        it.drugClass.contains("Biliary", ignoreCase = true) ||
                        it.drugClass.contains("Chelat", ignoreCase = true) ||
                        it.genericName.contains("Silymarin", ignoreCase = true) ||
                        it.genericName.contains("Ursodeoxycholic", ignoreCase = true) ||
                        it.genericName.contains("L-Ornithine", ignoreCase = true) ||
                        it.genericName.contains("Trientine", ignoreCase = true) ||
                        it.genericName.contains("Penicillamine", ignoreCase = true)
                    }
                    "Laxatives & Motility" -> list.filter {
                        it.drugClass.contains("Laxative", ignoreCase = true) ||
                        it.drugClass.contains("Prokinetic", ignoreCase = true) ||
                        it.drugClass.contains("Motility", ignoreCase = true) ||
                        it.genericName.contains("Lactulose", ignoreCase = true) ||
                        it.genericName.contains("PEG", ignoreCase = true) ||
                        it.genericName.contains("Bisacodyl", ignoreCase = true) ||
                        it.genericName.contains("Ispaghula", ignoreCase = true) ||
                        it.genericName.contains("Domperidone", ignoreCase = true) ||
                        it.genericName.contains("Metoclopramide", ignoreCase = true) ||
                        it.genericName.contains("Itopride", ignoreCase = true) ||
                        it.genericName.contains("Tenapanor", ignoreCase = true) ||
                        it.genericName.contains("Levosulpiride", ignoreCase = true) ||
                        it.drugClass.contains("NHE3", ignoreCase = true)
                    }
                    "Antidiarrheals / IBD" -> list.filter {
                        it.drugClass.contains("Antidiarrheal", ignoreCase = true) ||
                        it.drugClass.contains("IBD", ignoreCase = true) ||
                        it.drugClass.contains("Integrin", ignoreCase = true) ||
                        it.genericName.contains("Mesalamine", ignoreCase = true) ||
                        it.genericName.contains("Sulfasalazine", ignoreCase = true) ||
                        it.genericName.contains("Racecadotril", ignoreCase = true) ||
                        it.genericName.contains("Loperamide", ignoreCase = true) ||
                        it.genericName.contains("Diphenoxylate", ignoreCase = true) ||
                        it.genericName.contains("ORS", ignoreCase = true) ||
                        it.genericName.contains("Zinc", ignoreCase = true)
                    }
                    "Antispasmodics" -> list.filter {
                        it.drugClass.contains("Antispasmodic", ignoreCase = true) ||
                        it.genericName.contains("Drotaverine", ignoreCase = true) ||
                        it.genericName.contains("Dicyclomine", ignoreCase = true) ||
                        it.genericName.contains("Hyoscine", ignoreCase = true) ||
                        it.genericName.contains("Mebeverine", ignoreCase = true)
                    }
                    else -> list.filter {
                        it.drugClass.contains(selectedSubFilter, ignoreCase = true) ||
                        it.system.contains(selectedSubFilter, ignoreCase = true)
                    }
                }
            }

            // Apply A-Z Alphabet letter filter
            if (selectedAlphabetLetter != null) {
                list = list.filter { drug ->
                    drug.genericName.trim().startsWith(selectedAlphabetLetter!!, ignoreCase = true)
                }
            }

            // Apply search query within system
            if (inSystemSearchQuery.isNotBlank()) {
                val q = inSystemSearchQuery.trim().lowercase()
                list = list.filter { drug ->
                    drug.genericName.lowercase().contains(q) ||
                    drug.drugClass.lowercase().contains(q) ||
                    drug.indications.lowercase().contains(q) ||
                    drug.brandsNepal.any {
                        it.name.lowercase().contains(q) || it.company.lowercase().contains(q)
                    } ||
                    drug.brandsIndia.any {
                        it.name.lowercase().contains(q) || it.company.lowercase().contains(q)
                    }
                }
            }

            if (inSystemSearchQuery.isBlank()) {
                list.sortedBy { it.genericName.trim().lowercase() }
            } else {
                val q = inSystemSearchQuery.trim().lowercase()
                list.sortedWith(
                    compareBy<Drug> { drug ->
                        val g = drug.genericName.trim().lowercase()
                        if (g == q) 0
                        else if (g.startsWith(q)) 1
                        else if (drug.brandsNepal.any { it.name.trim().lowercase().startsWith(q) } ||
                                 drug.brandsIndia.any { it.name.trim().lowercase().startsWith(q) }) 2
                        else 3
                    }.thenBy { it.genericName.trim().lowercase() }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // Header Bar with Back navigation to System grid
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                color = activeSystem.accentColor.copy(alpha = 0.12f),
                border = BorderStroke(1.dp, activeSystem.accentColor.copy(alpha = 0.35f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        IconButton(
                            onClick = {
                                selectedSystem = null
                                inSystemSearchQuery = ""
                                selectedSubFilter = "All"
                            },
                            modifier = Modifier
                                .size(36.dp)
                                .background(MaterialTheme.colorScheme.surface, CircleShape)
                                .testTag("btn_back_to_systems")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back to Organ Systems",
                                tint = activeSystem.accentColor,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = activeSystem.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Text(
                                text = "${baseSystemDrugs.size} registered medications • Nepal Formulary",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 11.sp
                            )
                        }
                    }

                    // Count Badge
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = activeSystem.accentColor,
                        shadowElevation = 1.dp
                    ) {
                        Text(
                            text = "${baseSystemDrugs.size} Drugs",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // In-System Search Input
            OutlinedTextField(
                value = inSystemSearchQuery,
                onValueChange = { inSystemSearchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .testTag("in_system_search_input"),
                placeholder = {
                    Text(
                        text = "Search in ${activeSystem.shortName} (e.g. ${if (activeSystem.id == "GI") "Pantoprazole, Creon, Lomotil" else "brand or generic"}...)",
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = activeSystem.accentColor
                    )
                },
                trailingIcon = {
                    if (inSystemSearchQuery.isNotBlank()) {
                        IconButton(onClick = { inSystemSearchQuery = "" }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedBorderColor = activeSystem.accentColor.copy(alpha = 0.3f),
                    focusedBorderColor = activeSystem.accentColor
                )
            )

            // Sub-category Quick Filter Chips
            if (activeSystem.quickFilters.isNotEmpty()) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(activeSystem.quickFilters) { filterLabel ->
                        val isSelected = selectedSubFilter == filterLabel
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedSubFilter = filterLabel },
                            label = {
                                Text(
                                    text = if (filterLabel == "All") "All (${baseSystemDrugs.size})" else filterLabel,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = activeSystem.accentColor.copy(alpha = 0.2f),
                                selectedLabelColor = activeSystem.accentColor
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = isSelected,
                                borderColor = if (isSelected) activeSystem.accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                    }
                }
            }

            // A to Z Alphabetical Selector Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.SortByAlpha,
                        contentDescription = "Alphabetical Order",
                        tint = activeSystem.accentColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = if (selectedAlphabetLetter != null) "Filtered by Letter '${selectedAlphabetLetter}' (A-Z)" else "A to Z Alphabetical Directory",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                if (selectedAlphabetLetter != null) {
                    Text(
                        text = "Show All A-Z",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = activeSystem.accentColor,
                        modifier = Modifier.clickable { selectedAlphabetLetter = null }
                    )
                }
            }

            // Horizontal Alphabet Selector (A to Z)
            val availableLetters = remember(baseSystemDrugs) {
                baseSystemDrugs.mapNotNull { it.genericName.trim().firstOrNull()?.uppercaseChar() }.distinct().toSet()
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.dp)
            ) {
                item {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (selectedAlphabetLetter == null) activeSystem.accentColor else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        border = BorderStroke(0.8.dp, if (selectedAlphabetLetter == null) activeSystem.accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)),
                        modifier = Modifier
                            .clickable { selectedAlphabetLetter = null }
                            .testTag("system_alpha_all")
                    ) {
                        Text(
                            text = "All",
                            fontSize = 11.sp,
                            fontWeight = if (selectedAlphabetLetter == null) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedAlphabetLetter == null) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                        )
                    }
                }

                items(('A'..'Z').toList()) { letter ->
                    val hasDrugs = availableLetters.contains(letter)
                    val isSelected = selectedAlphabetLetter == letter
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = when {
                            isSelected -> activeSystem.accentColor
                            hasDrugs -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.15f)
                        },
                        border = BorderStroke(
                            0.8.dp,
                            if (isSelected) activeSystem.accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = if (hasDrugs) 0.4f else 0.15f)
                        ),
                        modifier = Modifier
                            .clickable(enabled = hasDrugs) {
                                selectedAlphabetLetter = if (isSelected) null else letter
                            }
                            .testTag("system_alpha_$letter")
                    ) {
                        Text(
                            text = letter.toString(),
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = when {
                                isSelected -> Color.White
                                hasDrugs -> MaterialTheme.colorScheme.onSurface
                                else -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
                            },
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                        )
                    }
                }
            }

            // Results count indicator
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Showing ${displayedDrugs.size} of ${baseSystemDrugs.size} drugs • Arranged Alphabetically (A to Z)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (selectedSubFilter != "All" || inSystemSearchQuery.isNotBlank() || selectedAlphabetLetter != null) {
                    Text(
                        text = "Reset All Filters",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = activeSystem.accentColor,
                        modifier = Modifier.clickable {
                            selectedSubFilter = "All"
                            inSystemSearchQuery = ""
                            selectedAlphabetLetter = null
                        }
                    )
                }
            }

            // Drugs List
            if (displayedDrugs.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SearchOff,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = "No drugs found in ${activeSystem.shortName}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Try adjusting your search query or selecting 'All'.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Button(
                            onClick = {
                                inSystemSearchQuery = ""
                                selectedSubFilter = "All"
                                selectedAlphabetLetter = null
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = activeSystem.accentColor),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Clear Filters")
                        }
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(top = 4.dp, bottom = 96.dp)
                ) {
                    items(displayedDrugs, key = { it.id }) { drug ->
                        DrugCard(
                            drug = drug,
                            isBookmarked = state.bookmarkedDrugIds.contains(drug.id),
                            searchQuery = inSystemSearchQuery,
                            onClick = { onDrugClick(drug) },
                            onBookmarkToggle = { onBookmarkToggle(drug.id) }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Backwards-compatibility overload for SystemBrowseScreen.
 */
@Composable
fun SystemBrowseScreen(
    onSystemSelected: (String) -> Unit
) {
    // Legacy stub delegating to basic grid if called with only callback
    val allDrugs = remember { ClinicalRepository.drugs }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column {
            Text(
                text = "Browse by Organ System",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Select an anatomical system to view medications",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(SYSTEM_CATEGORIES) { item ->
                val drugCount = remember(item.id) {
                    getDrugsForSystem(allDrugs, item).size
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(142.dp)
                        .clickable { onSystemSelected(item.name) }
                        .testTag("system_card_${item.id}"),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = BorderStroke(1.dp, item.accentColor.copy(alpha = 0.35f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(item.accentColor.copy(alpha = 0.08f), Color.Transparent)
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = item.accentColor.copy(alpha = 0.18f),
                                    modifier = Modifier.size(40.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = item.icon,
                                            contentDescription = null,
                                            tint = item.accentColor,
                                            modifier = Modifier.size(22.dp)
                                        )
                                    }
                                }

                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = item.accentColor.copy(alpha = 0.12f),
                                    border = BorderStroke(0.5.dp, item.accentColor.copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = "$drugCount drugs",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = item.accentColor,
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                                    )
                                }
                            }

                            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                Text(
                                    text = item.name,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 2,
                                    lineHeight = 16.sp
                                )
                                Text(
                                    text = item.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
