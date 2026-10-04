package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.calculator.ClinicalCalculatorRegistry
import com.example.data.model.CalculatorSummary
import com.example.ui.screens.calculator.CalculatorDetailScreen
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel

@Composable
fun CalculatorsScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    if (state.selectedCalculatorId != null) {
        CalculatorDetailScreen(
            calcId = state.selectedCalculatorId,
            state = state,
            viewModel = viewModel,
            onBack = { viewModel.closeCalculator() }
        )
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
        listOf(
            "All",
            "Favorites",
            "Critical Care",
            "Gastroenterology",
            "Hepatology",
            "Cardiology",
            "Nephrology & Dosing",
            "Pulmonology",
            "Hematology",
            "Endocrinology",
            "Neurology",
            "Pediatrics",
            "Toxicology",
            "Emergency & Nepal"
        )
    }

    val allCalculators = remember { ClinicalCalculatorRegistry.allCalculators }

    val quickScoringPills = remember {
        listOf(
            "VOCAL-Penn",
            "MELD",
            "Child-Turcotte-Pugh",
            "CURB-65",
            "Wells Criteria",
            "Lille Model",
            "FIB-4",
            "Glasgow-Blatchford",
            "CHA2DS2-VASc",
            "GCS",
            "Tokyo TG18",
            "King's College",
            "qSOFA",
            "APACHE II",
            "KDIGO AKI"
        )
    }

    val filteredCalculators = remember(searchQuery, selectedCategory, state.bookmarkedCalculatorIds) {
        val rawQ = searchQuery.trim()
        val qNormalized = rawQ.lowercase().replace(Regex("[^a-z0-9]"), " ").trim()
        val queryTokens = qNormalized.split("\\s+".toRegex()).filter { it.isNotBlank() }

        val baseList = if (selectedCategory == "Favorites") {
            allCalculators.filter { state.bookmarkedCalculatorIds.contains(it.id) }
        } else if (selectedCategory != "All" && rawQ.isEmpty()) {
            allCalculators.filter { it.category.contains(selectedCategory, ignoreCase = true) }
        } else {
            allCalculators
        }

        if (queryTokens.isEmpty()) {
            if (selectedCategory != "All" && selectedCategory != "Favorites") {
                allCalculators.filter { it.category.contains(selectedCategory, ignoreCase = true) }
            } else {
                baseList
            }
        } else {
            baseList.mapNotNull { calc ->
                val titleNorm = calc.title.lowercase().replace(Regex("[^a-z0-9]"), " ")
                val aliasesNorm = calc.aliases.map { it.lowercase().replace(Regex("[^a-z0-9]"), " ") }
                val descNorm = calc.description.lowercase().replace(Regex("[^a-z0-9]"), " ")
                val formulaNorm = calc.formulaSummary.lowercase().replace(Regex("[^a-z0-9]"), " ")
                val catNorm = calc.category.lowercase().replace(Regex("[^a-z0-9]"), " ")

                // Check exact matches
                val exactAliasMatch = aliasesNorm.any { it.trim() == qNormalized }
                val exactTitleMatch = titleNorm.trim() == qNormalized
                val prefixMatch = titleNorm.trim().startsWith(qNormalized) || aliasesNorm.any { it.trim().startsWith(qNormalized) }

                // Token matching
                val fullText = "$titleNorm $catNorm $descNorm $formulaNorm ${aliasesNorm.joinToString(" ")}"
                val allTokensMatch = queryTokens.all { token -> fullText.contains(token) }

                if (exactTitleMatch || exactAliasMatch) {
                    calc to 100
                } else if (prefixMatch) {
                    calc to 80
                } else if (aliasesNorm.any { queryTokens.all { t -> it.contains(t) } }) {
                    calc to 60
                } else if (titleNorm.contains(qNormalized) || queryTokens.all { t -> titleNorm.contains(t) }) {
                    calc to 40
                } else if (allTokensMatch) {
                    calc to 20
                } else {
                    null
                }
            }
            .sortedWith(compareByDescending<Pair<CalculatorSummary, Int>> { it.second }.thenBy { it.first.title })
            .map { it.first }
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Clinical Cal Suite",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xFF00897B).copy(alpha = 0.2f),
                            border = BorderStroke(0.8.dp, Color(0xFF00897B))
                        ) {
                            Text(
                                text = "${allCalculators.size} Calculators",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00897B),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                    Text(
                        text = "Evidence-based clinical decision rules, risk scores & emergency dosing calculators.",
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
            placeholder = { Text("Search scoring system (e.g. MELD, Child-Turcotte-Pugh, CURB-65)...") },
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

        // Quick Find Scoring Pills
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Bolt,
                        contentDescription = null,
                        tint = Color(0xFFF59E0B),
                        modifier = Modifier.size(13.dp)
                    )
                    Text("Quick:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            quickScoringPills.forEach { pill ->
                val isActive = searchQuery.trim().equals(pill, ignoreCase = true)
                Surface(
                    onClick = {
                        if (isActive) {
                            searchQuery = ""
                        } else {
                            searchQuery = pill
                            if (selectedCategory != "All") selectedCategory = "All"
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isActive) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                ) {
                    Text(
                        text = pill,
                        fontSize = 11.sp,
                        fontWeight = if (isActive) FontWeight.Bold else FontWeight.Medium,
                        color = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.dp)
                    )
                }
            }
        }

        // Specialty Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                val isFav = cat == "Favorites"
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = cat },
                    leadingIcon = if (isFav) {
                        {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = if (isSelected) Color.White else Color(0xFFF59E0B)
                            )
                        }
                    } else null,
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

        // Fast Action Buttons: Renal Dose Auto-Calculator & Emergency Code Blue
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Surface(
                onClick = { viewModel.navigateTo(com.example.viewmodel.NavigationScreen.ABG_ELECTROLYTE_SOLVER) },
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0284C7).copy(alpha = 0.15f),
                border = BorderStroke(1.2.dp, Color(0xFF38BDF8).copy(alpha = 0.6f)),
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(Icons.Default.Science, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(18.dp))
                    Column {
                        Text("ABG & Electrolytes", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                        Text("Acid-Base & Deficits", fontSize = 9.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            Surface(
                onClick = { viewModel.navigateTo(com.example.viewmodel.NavigationScreen.RENAL_ADJUSTER) },
                shape = RoundedCornerShape(12.dp),
                color = Amber500.copy(alpha = 0.12f),
                border = BorderStroke(1.2.dp, Amber500.copy(alpha = 0.5f)),
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(Icons.Default.Calculate, contentDescription = null, tint = Amber400, modifier = Modifier.size(18.dp))
                    Column {
                        Text("Renal Dose Adjuster", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Amber400)
                        Text("CrCl & eGFR Dosing", fontSize = 9.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            Surface(
                onClick = { viewModel.navigateTo(com.example.viewmodel.NavigationScreen.CRITICAL_CARE) },
                shape = RoundedCornerShape(12.dp),
                color = Red500.copy(alpha = 0.16f),
                border = BorderStroke(1.2.dp, Red500),
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(Icons.Default.Bolt, contentDescription = null, tint = Red400, modifier = Modifier.size(18.dp))
                    Column {
                        Text("Critical Care / ER", fontSize = 11.sp, fontWeight = FontWeight.Black, color = Red400)
                        Text("Tox, Antidotes, ACLS", fontSize = 9.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }

        // Search Results Header & Filter Reset
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
                    text = "${filteredCalculators.size} Scoring System${if (filteredCalculators.size == 1) "" else "s"}",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (searchQuery.isNotBlank()) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = "\"$searchQuery\"",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            if (searchQuery.isNotEmpty() || selectedCategory != "All") {
                TextButton(
                    onClick = {
                        searchQuery = ""
                        selectedCategory = "All"
                    },
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
                    modifier = Modifier.testTag("calculator_search_clear")
                ) {
                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(13.dp))
                    Spacer(Modifier.width(3.dp))
                    Text("Clear Filter", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
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
                            text = if (selectedCategory == "Favorites") "No favorite calculators saved" else "No matching scoring systems found",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = if (selectedCategory == "Favorites") "Tap the star icon on any calculator to bookmark it here." else "Try searching by initials (e.g. MELD, CTP, CURB, GCS) or tap a Quick Find chip above.",
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
                items(filteredCalculators.distinctBy { it.id }, key = { it.id }) { item ->
                    val isBookmarked = state.bookmarkedCalculatorIds.contains(item.id)
                    CalculatorSummaryCard(
                        summary = item,
                        searchQuery = searchQuery,
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
    summary: CalculatorSummary,
    searchQuery: String,
    isBookmarked: Boolean,
    onBookmarkToggle: () -> Unit,
    onClick: () -> Unit
) {
    val (icon, tintColor) = remember(summary.category) {
        getCategoryVisuals(summary.category)
    }

    val matchedAlias = remember(summary, searchQuery) {
        val qNorm = searchQuery.trim().lowercase().replace(Regex("[^a-z0-9]"), " ")
        if (qNorm.isNotBlank()) {
            summary.aliases.find { alias ->
                val aNorm = alias.lowercase().replace(Regex("[^a-z0-9]"), " ")
                aNorm.contains(qNorm) && !summary.title.lowercase().contains(aNorm)
            }
        } else null
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("calc_card_${summary.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
        border = BorderStroke(1.dp, tintColor.copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header Row: Icon, Title, Badges (NEW / POPULAR), Bookmark Star Button
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
                        color = tintColor.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, tintColor.copy(alpha = 0.4f)),
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = tintColor,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = summary.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            if (summary.isNew) {
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Emerald500.copy(alpha = 0.18f),
                                    border = BorderStroke(0.6.dp, Emerald500)
                                ) {
                                    Text(
                                        text = "NEW",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Emerald500,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            if (summary.isPopular) {
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = Color(0xFFF59E0B).copy(alpha = 0.18f),
                                    border = BorderStroke(0.6.dp, Color(0xFFF59E0B))
                                ) {
                                    Text(
                                        text = "POPULAR",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFF59E0B),
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                        }

                        Text(
                            text = summary.category,
                            style = MaterialTheme.typography.labelSmall,
                            color = tintColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                IconButton(
                    onClick = onBookmarkToggle,
                    modifier = Modifier
                        .size(36.dp)
                        .testTag("calc_bookmark_${summary.id}")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Star else Icons.Default.StarBorder,
                        contentDescription = "Bookmark",
                        tint = if (isBookmarked) Color(0xFFF59E0B) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Description
            Text(
                text = summary.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            if (matchedAlias != null) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = tintColor.copy(alpha = 0.12f),
                    border = BorderStroke(0.8.dp, tintColor.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = tintColor,
                            modifier = Modifier.size(11.dp)
                        )
                        Text(
                            text = "Matched: \"$matchedAlias\"",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = tintColor
                        )
                    }
                }
            }

            // Bottom Row: Formula badge & Calculate Button
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
                        text = summary.formulaSummary,
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

private fun getCategoryVisuals(category: String): Pair<ImageVector, Color> {
    return when {
        category.contains("Critical", ignoreCase = true) -> Icons.Default.MedicalServices to Color(0xFFEF4444)
        category.contains("Gastro", ignoreCase = true) -> Icons.Default.Restaurant to Color(0xFFEA580C)
        category.contains("Hepat", ignoreCase = true) -> Icons.Default.LocalHospital to Color(0xFFD97706)
        category.contains("Cardio", ignoreCase = true) -> Icons.Default.Favorite to Color(0xFFE11D48)
        category.contains("Nephro", ignoreCase = true) || category.contains("Renal", ignoreCase = true) -> Icons.Default.WaterDrop to Color(0xFF0284C7)
        category.contains("Pulm", ignoreCase = true) -> Icons.Default.Air to Color(0xFF0891B2)
        category.contains("Hema", ignoreCase = true) -> Icons.Default.Bloodtype to Color(0xFFDC2626)
        category.contains("Endo", ignoreCase = true) -> Icons.Default.Science to Color(0xFF7C3AED)
        category.contains("Neuro", ignoreCase = true) -> Icons.Default.Psychology to Color(0xFF9333EA)
        category.contains("Pediatr", ignoreCase = true) -> Icons.Default.ChildCare to Color(0xFF059669)
        category.contains("Toxico", ignoreCase = true) -> Icons.Default.Warning to Color(0xFFD97706)
        category.contains("Emergency", ignoreCase = true) || category.contains("Nepal", ignoreCase = true) -> Icons.Default.Emergency to Color(0xFFE11D48)
        else -> Icons.Default.Calculate to Color(0xFF00897B)
    }
}
