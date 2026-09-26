package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.CalculatorSummary
import com.example.data.model.DiseaseProtocol
import com.example.data.model.Drug
import com.example.data.model.GlobalSearchTab
import com.example.ui.components.VoiceSearchButton
import com.example.ui.theme.*
import com.example.viewmodel.DrugFilterType
import com.example.viewmodel.SearchMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugSearchScreen(
    searchQuery: String,
    searchMode: SearchMode = SearchMode.BRAND,
    activeFilter: DrugFilterType,
    selectedSystemFilter: String?,
    filteredDrugs: List<Drug>,
    filteredProtocols: List<DiseaseProtocol> = emptyList(),
    filteredCalculators: List<CalculatorSummary> = emptyList(),
    globalSearchTab: GlobalSearchTab = GlobalSearchTab.ALL,
    bookmarkedDrugIds: Set<String>,
    recentSearches: List<String> = emptyList(),
    onSearchChange: (String) -> Unit,
    onSearchSubmit: (String) -> Unit = {},
    onSearchModeChange: (SearchMode) -> Unit = {},
    onGlobalSearchTabChange: (GlobalSearchTab) -> Unit = {},
    onFilterChange: (DrugFilterType) -> Unit,
    onClearSystemFilter: () -> Unit,
    onDrugClick: (Drug) -> Unit,
    onProtocolClick: (DiseaseProtocol) -> Unit = {},
    onCalculatorClick: (CalculatorSummary) -> Unit = {},
    onBookmarkToggle: (String) -> Unit,
    onOpenPharmacologyReview: () -> Unit = {},
    onOpenIndicationDirectory: () -> Unit = {},
    onOpenInteractionChecker: () -> Unit = {},
    onOpenMedicalNews: () -> Unit = {}
) {
    var showHistoryDialog by remember { mutableStateOf(false) }

    val defaultSearches = remember {
        listOf(
            "Moxclave 625", "Dolo-650", "Pantocid 40",
            "Amoxicillin", "Paracetamol", "Azithromycin",
            "Amlodipine", "Metformin 500", "Ciprofloxacin"
        )
    }
    val effectiveRecentSearches = if (recentSearches.isNotEmpty()) recentSearches else defaultSearches

    val keyboardController = LocalSoftwareKeyboardController.current

    val isSearchActive = searchQuery.isNotBlank()
    val totalMatches = filteredDrugs.size + filteredProtocols.size + filteredCalculators.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Spacer(modifier = Modifier.height(2.dp))

        // Global Search Scope & Capability Banner
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = DimsTealPrimary.copy(alpha = 0.08f),
            border = BorderStroke(1.dp, DimsTealPrimary.copy(alpha = 0.25f)),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("global_search_scope_indicator")
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Public,
                        contentDescription = null,
                        tint = DimsTealPrimary,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "Global Search",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = DimsTealPrimary
                    )
                    Text(
                        text = "•",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                    Text(
                        text = "Drugs • Protocols • Calculators",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                if (isSearchActive) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = DimsTealPrimary.copy(alpha = 0.2f)
                    ) {
                        Text(
                            text = "$totalMatches found",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = DimsTealPrimary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }

        // Active Indication Search Banner (if user specifically switched to INDICATION mode)
        if (searchMode == SearchMode.INDICATION && !isSearchActive) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFF0284C7).copy(alpha = 0.15f),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("indication_search_active_banner")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Hub,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Searching by Indication",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF38BDF8)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        FilledTonalButton(
                            onClick = onOpenIndicationDirectory,
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                            modifier = Modifier.height(28.dp),
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = Color(0xFF0284C7).copy(alpha = 0.35f),
                                contentColor = Color(0xFF38BDF8)
                            )
                        ) {
                            Text(
                                text = "Directory →",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        TextButton(
                            onClick = { onSearchModeChange(SearchMode.BRAND) },
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                            modifier = Modifier.height(28.dp)
                        ) {
                            Text(
                                text = "Reset",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate200
                            )
                        }
                    }
                }
            }
        }

        // System Filter Indicator (if active)
        if (selectedSystemFilter != null) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Emerald500.copy(alpha = 0.15f),
                border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FilterAlt,
                            contentDescription = null,
                            tint = Emerald500,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Filtered by: $selectedSystemFilter",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Emerald500
                        )
                    }
                    IconButton(
                        onClick = onClearSystemFilter,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear system filter",
                            tint = Emerald500,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        // WHEN USER IS ACTIVELY SEARCHING: Show Category Tabs (All / Drugs / Protocols / Calculators)
        if (isSearchActive) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(
                    Triple(GlobalSearchTab.ALL, "All", totalMatches),
                    Triple(GlobalSearchTab.DRUGS, "💊 Drugs", filteredDrugs.size),
                    Triple(GlobalSearchTab.PROTOCOLS, "📋 Protocols", filteredProtocols.size),
                    Triple(GlobalSearchTab.CALCULATORS, "🧮 Calculators", filteredCalculators.size)
                ).forEach { (tab, label, count) ->
                    val isSelected = globalSearchTab == tab
                    FilterChip(
                        selected = isSelected,
                        onClick = { onGlobalSearchTabChange(tab) },
                        label = {
                            Text(
                                text = "$label ($count)",
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = DimsTealPrimary,
                            selectedLabelColor = Color.White,
                            containerColor = MaterialTheme.colorScheme.surface,
                            labelColor = MaterialTheme.colorScheme.onSurface
                        ),
                        border = BorderStroke(
                            1.dp,
                            if (isSelected) Color.Transparent else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                        ),
                        modifier = Modifier.testTag("global_tab_${tab.name.lowercase()}")
                    )
                }
            }

            // If Drugs tab is selected during search, also display drug filters
            if (globalSearchTab == GlobalSearchTab.DRUGS) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DrugFilterType.values().forEach { filterType ->
                        val isSelected = activeFilter == filterType && selectedSystemFilter == null
                        FilterChip(
                            selected = isSelected,
                            onClick = { onFilterChange(filterType) },
                            label = {
                                Text(
                                    text = filterType.label,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    fontSize = 11.5.sp
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = if (filterType == DrugFilterType.BLACK_BOX) Red600 else DimsTealPrimary,
                                selectedLabelColor = Color.White,
                                containerColor = MaterialTheme.colorScheme.surface,
                                labelColor = MaterialTheme.colorScheme.onSurface
                            ),
                            border = BorderStroke(
                                1.dp,
                                if (isSelected) Color.Transparent else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                            )
                        )
                    }
                }
            }

            // Results summary text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val currentTabCount = when (globalSearchTab) {
                    GlobalSearchTab.ALL -> totalMatches
                    GlobalSearchTab.DRUGS -> filteredDrugs.size
                    GlobalSearchTab.PROTOCOLS -> filteredProtocols.size
                    GlobalSearchTab.CALCULATORS -> filteredCalculators.size
                }
                Text(
                    text = "$currentTabCount result${if (currentTabCount != 1) "s" else ""} for \"$searchQuery\"",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Tap to open details",
                    style = MaterialTheme.typography.labelSmall,
                    color = DimsTealPrimary,
                    fontWeight = FontWeight.Medium
                )
            }
        } else {
            // WHEN SEARCH IS BLANK: Show Instant Search Suggestions & Home Dashboard Elements

            // Instant Search Recommendation Chips
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("instant_search_suggestions_section"),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Instant Search Suggestions",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Drugs • Protocols • Calculators",
                        fontSize = 10.sp,
                        color = DimsTealPrimary
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(
                        Pair("💊 Tofacitinib", "Tofacitinib"),
                        Pair("💊 Amoxicillin", "Amoxicillin"),
                        Pair("💊 Methotrexate", "Methotrexate"),
                        Pair("📋 CAP Pneumonia", "Pneumonia"),
                        Pair("🧮 eGFR (CrCl)", "eGFR"),
                        Pair("💊 Dapagliflozin", "Dapagliflozin"),
                        Pair("📋 Asthma Protocol", "Asthma"),
                        Pair("🧮 CURB-65", "CURB-65"),
                        Pair("💊 Pantocid 40", "Pantocid"),
                        Pair("🧮 Child-Pugh", "Child-Pugh"),
                        Pair("📋 Hypertension", "Hypertension"),
                        Pair("🧮 GCS Score", "Glasgow Coma Scale"),
                        Pair("📋 Organophosphate", "Organophosphate")
                    ).forEach { (displayLabel, queryTerm) ->
                        Surface(
                            onClick = { onSearchChange(queryTerm) },
                            shape = RoundedCornerShape(14.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                            modifier = Modifier.testTag("suggestion_${queryTerm.lowercase().replace(" ", "_")}")
                        ) {
                            Text(
                                text = displayLabel,
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                            )
                        }
                    }
                }
            }

            // Nepal Medical News & Clinical Alerts Banner (Search Grounded)
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0369A1).copy(alpha = 0.15f),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.45f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable(onClick = onOpenMedicalNews)
                    .testTag("quick_nepal_medical_news_banner")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFF0284C7).copy(alpha = 0.25f),
                        modifier = Modifier.size(34.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Feed,
                                contentDescription = null,
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Nepal Medical News & Alerts",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFF0284C7).copy(alpha = 0.35f)
                            ) {
                                Text(
                                    text = "GROUNDED AI",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFF7DD3FC),
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Live updates: EDCD disease surveillance, DDA recalls & WHO directives",
                            fontSize = 10.5.sp,
                            color = Slate400,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Quick Multi-Drug Interaction Checker Banner
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFDC2626).copy(alpha = 0.12f),
                border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.4f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable(onClick = onOpenInteractionChecker)
                    .testTag("quick_interaction_checker_banner")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFDC2626).copy(alpha = 0.25f),
                        modifier = Modifier.size(34.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.ElectricBolt,
                                contentDescription = null,
                                tint = Color(0xFFF87171),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Multi-Drug Interaction Checker",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFFDC2626).copy(alpha = 0.35f)
                            ) {
                                Text(
                                    text = "SAFETY",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFFFCA5A5),
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Input multiple drugs for contraindications & adverse interactions (UpToDate / Medscape)",
                            fontSize = 10.5.sp,
                            color = Slate400,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color(0xFFF87171),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Quick Pharmacology & MOA Guides Banner
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF6366F1).copy(alpha = 0.12f),
                border = BorderStroke(1.dp, Color(0xFF818CF8).copy(alpha = 0.35f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable(onClick = onOpenPharmacologyReview)
                    .testTag("quick_pharm_review_banner")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = null,
                        tint = Color(0xFFA5B4FC),
                        modifier = Modifier.size(20.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Pharmacology Review & MOA Guide",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFF6366F1).copy(alpha = 0.3f)
                            ) {
                                Text(
                                    text = "14 CHAPTERS",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFFA5B4FC),
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Insulins, Steroids, AEDs, Anti-TB, Chelators & Teratogens",
                            fontSize = 10.5.sp,
                            color = Slate400
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color(0xFFA5B4FC),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Recent Searches section
            if (effectiveRecentSearches.isNotEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("recent_searches_section"),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.History,
                                contentDescription = null,
                                tint = DimsTealPrimary,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "Recent Searches",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = "Quick navigation",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        effectiveRecentSearches.take(5).forEachIndexed { idx, item ->
                            Surface(
                                onClick = { onSearchChange(item) },
                                shape = RoundedCornerShape(16.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
                                border = BorderStroke(1.dp, DimsTealPrimary.copy(alpha = 0.35f)),
                                modifier = Modifier.testTag("recent_search_chip_$idx")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null,
                                        tint = DimsTealPrimary,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Text(
                                        text = item,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Quick Filter Tags (Nepal, India, Black Box, Bookmarks)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DrugFilterType.values().forEach { filterType ->
                    val isSelected = activeFilter == filterType && selectedSystemFilter == null
                    val filterIcon = when (filterType) {
                        DrugFilterType.ALL -> Icons.Default.GridView
                        DrugFilterType.NEPAL -> Icons.Default.Flag
                        DrugFilterType.INDIA -> Icons.Default.LocalHospital
                        DrugFilterType.BLACK_BOX -> Icons.Default.Warning
                        DrugFilterType.BOOKMARKS -> Icons.Default.Bookmark
                    }

                    FilterChip(
                        selected = isSelected,
                        onClick = { onFilterChange(filterType) },
                        leadingIcon = {
                            Icon(
                                imageVector = filterIcon,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = if (isSelected) Color.White else if (filterType == DrugFilterType.BLACK_BOX) Red500 else DimsTealPrimary
                            )
                        },
                        label = {
                            Text(
                                text = filterType.label,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = if (filterType == DrugFilterType.BLACK_BOX) Red600 else DimsTealPrimary,
                            selectedLabelColor = Color.White,
                            containerColor = MaterialTheme.colorScheme.surface,
                            labelColor = if (filterType == DrugFilterType.BLACK_BOX) Red400 else MaterialTheme.colorScheme.onSurface
                        ),
                        border = BorderStroke(
                            1.dp,
                            if (isSelected) Color.Transparent
                            else if (filterType == DrugFilterType.BLACK_BOX) Red500.copy(alpha = 0.5f)
                            else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                        ),
                        modifier = Modifier.testTag("filter_${filterType.name.lowercase()}")
                    )
                }
            }

            // Results Header for default drug list
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${filteredDrugs.size} drugs in database",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.TouchApp,
                        contentDescription = null,
                        tint = DimsTealPrimary,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = "Tap card for full monograph",
                        style = MaterialTheme.typography.labelSmall,
                        color = DimsTealPrimary,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // RESULTS LIST (Global Search Results or Default Drug List)
        if (isSearchActive) {
            when (globalSearchTab) {
                GlobalSearchTab.ALL -> {
                    if (totalMatches == 0) {
                        SearchEmptyState(
                            query = searchQuery,
                            onReset = { onSearchChange("") }
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(bottom = 80.dp)
                        ) {
                            // Section: Clinical Calculators
                            if (filteredCalculators.isNotEmpty()) {
                                item {
                                    SearchSectionHeader(
                                        icon = Icons.Default.Calculate,
                                        iconColor = Amber400,
                                        title = "Clinical Calculators",
                                        count = filteredCalculators.size
                                    )
                                }
                                items(filteredCalculators, key = { "calc_${it.id}" }) { calc ->
                                    SearchCalculatorCard(
                                        calculator = calc,
                                        onClick = { onCalculatorClick(calc) }
                                    )
                                }
                            }

                            // Section: Disease Protocols
                            if (filteredProtocols.isNotEmpty()) {
                                item {
                                    SearchSectionHeader(
                                        icon = Icons.Default.Description,
                                        iconColor = Color(0xFF38BDF8),
                                        title = "Disease Protocols & Guidelines",
                                        count = filteredProtocols.size
                                    )
                                }
                                items(filteredProtocols, key = { "proto_${it.id}" }) { proto ->
                                    SearchProtocolCard(
                                        protocol = proto,
                                        onClick = { onProtocolClick(proto) }
                                    )
                                }
                            }

                            // Section: Drugs
                            if (filteredDrugs.isNotEmpty()) {
                                item {
                                    SearchSectionHeader(
                                        icon = Icons.Default.Medication,
                                        iconColor = Emerald400,
                                        title = "Drugs & Formulations",
                                        count = filteredDrugs.size
                                    )
                                }
                                items(filteredDrugs, key = { "drug_${it.id}" }) { drug ->
                                    DrugCard(
                                        drug = drug,
                                        isBookmarked = bookmarkedDrugIds.contains(drug.id),
                                        onClick = { onDrugClick(drug) },
                                        onBookmarkToggle = { onBookmarkToggle(drug.id) }
                                    )
                                }
                            }
                        }
                    }
                }

                GlobalSearchTab.CALCULATORS -> {
                    if (filteredCalculators.isEmpty()) {
                        SearchEmptyState(
                            query = searchQuery,
                            onReset = { onSearchChange("") },
                            customMessage = "No clinical calculators match \"$searchQuery\"."
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(bottom = 80.dp)
                        ) {
                            items(filteredCalculators, key = { "calc_${it.id}" }) { calc ->
                                SearchCalculatorCard(
                                    calculator = calc,
                                    onClick = { onCalculatorClick(calc) }
                                )
                            }
                        }
                    }
                }

                GlobalSearchTab.PROTOCOLS -> {
                    if (filteredProtocols.isEmpty()) {
                        SearchEmptyState(
                            query = searchQuery,
                            onReset = { onSearchChange("") },
                            customMessage = "No clinical disease protocols match \"$searchQuery\"."
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(bottom = 80.dp)
                        ) {
                            items(filteredProtocols, key = { "proto_${it.id}" }) { proto ->
                                SearchProtocolCard(
                                    protocol = proto,
                                    onClick = { onProtocolClick(proto) }
                                )
                            }
                        }
                    }
                }

                GlobalSearchTab.DRUGS -> {
                    if (filteredDrugs.isEmpty()) {
                        SearchEmptyState(
                            query = searchQuery,
                            onReset = { onSearchChange("") },
                            customMessage = "No drugs or molecules match \"$searchQuery\"."
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(bottom = 80.dp)
                        ) {
                            items(filteredDrugs, key = { it.id }) { drug ->
                                DrugCard(
                                    drug = drug,
                                    isBookmarked = bookmarkedDrugIds.contains(drug.id),
                                    onClick = { onDrugClick(drug) },
                                    onBookmarkToggle = { onBookmarkToggle(drug.id) }
                                )
                            }
                        }
                    }
                }
            }
        } else {
            // Default drug list when search query is empty
            if (filteredDrugs.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(24.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(56.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.SearchOff,
                                        contentDescription = null,
                                        modifier = Modifier.size(28.dp),
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            Text(
                                text = "No matching drugs found",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Search by Nepal brand (e.g. Moxclave, Dolo, Pantocid), generic name, protocol, or calculator above.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(filteredDrugs, key = { it.id }) { drug ->
                        DrugCard(
                            drug = drug,
                            isBookmarked = bookmarkedDrugIds.contains(drug.id),
                            onClick = { onDrugClick(drug) },
                            onBookmarkToggle = { onBookmarkToggle(drug.id) }
                        )
                    }
                }
            }
        }
    }

    // Recent Searches Dialog
    if (showHistoryDialog) {
        AlertDialog(
            onDismissRequest = { showHistoryDialog = false },
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = null,
                        tint = DimsTealPrimary
                    )
                    Text("Frequent Searches", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    effectiveRecentSearches.forEach { term ->
                        Surface(
                            onClick = {
                                onSearchChange(term.split(" ").first())
                                showHistoryDialog = false
                            },
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = term, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
                                Icon(
                                    imageVector = Icons.Default.NorthWest,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showHistoryDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

@Composable
private fun MascotMagnifyingGlass(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val centerOffset = Offset(size.width * 0.45f, size.height * 0.42f)
        val lensRadius = size.width * 0.32f

        // Handle
        drawLine(
            color = DimsTealPrimary,
            start = Offset(centerOffset.x + lensRadius * 0.7f, centerOffset.y + lensRadius * 0.7f),
            end = Offset(size.width * 0.92f, size.height * 0.92f),
            strokeWidth = 14.dp.toPx(),
            cap = StrokeCap.Round
        )

        // Glass Rim Background Fill
        drawCircle(
            color = DimsTealLight,
            radius = lensRadius,
            center = centerOffset
        )

        // Rim Border
        drawCircle(
            color = DimsTealPrimary,
            radius = lensRadius,
            center = centerOffset,
            style = Stroke(width = 8.dp.toPx())
        )

        // Cartoon Eyes
        val leftEye = Offset(centerOffset.x - lensRadius * 0.3f, centerOffset.y - lensRadius * 0.15f)
        val rightEye = Offset(centerOffset.x + lensRadius * 0.3f, centerOffset.y - lensRadius * 0.15f)
        drawCircle(color = DimsTealDark, radius = 4.dp.toPx(), center = leftEye)
        drawCircle(color = DimsTealDark, radius = 4.dp.toPx(), center = rightEye)

        // Cute Smile Arc
        drawArc(
            color = DimsTealDark,
            startAngle = 20f,
            sweepAngle = 140f,
            useCenter = false,
            topLeft = Offset(centerOffset.x - lensRadius * 0.25f, centerOffset.y),
            size = Size(lensRadius * 0.5f, lensRadius * 0.35f),
            style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
        )

        // Sparkle / Glare Reflection Arc
        drawArc(
            color = Color.White.copy(alpha = 0.85f),
            startAngle = 200f,
            sweepAngle = 60f,
            useCenter = false,
            topLeft = Offset(centerOffset.x - lensRadius * 0.8f, centerOffset.y - lensRadius * 0.8f),
            size = Size(lensRadius * 1.6f, lensRadius * 1.6f),
            style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}

@Composable
private fun DrugCard(
    drug: Drug,
    isBookmarked: Boolean,
    onClick: () -> Unit,
    onBookmarkToggle: () -> Unit
) {
    val systemColor = getSystemColor(drug.system)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("drug_card_${drug.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
        border = BorderStroke(1.dp, systemColor.copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Generic Name, Black Box Badge & Bookmark
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = drug.genericName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.weight(1f, fill = false)
                        )

                        if (drug.blackBoxWarning != null) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Red950,
                                border = BorderStroke(1.dp, Red500)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Warning,
                                        contentDescription = null,
                                        tint = Red400,
                                        modifier = Modifier.size(10.dp)
                                    )
                                    Text(
                                        text = "BLACK BOX",
                                        color = Red400,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                        }
                    }

                    // Drug Class & System Pill
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.padding(top = 2.dp)
                    ) {
                        Text(
                            text = drug.drugClass,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "•",
                            color = MaterialTheme.colorScheme.outline
                        )
                        Text(
                            text = drug.system,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = systemColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                IconButton(
                    onClick = onBookmarkToggle,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = "Bookmark",
                        tint = if (isBookmarked) Amber500 else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Quick Info: Indications & Dose
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = "Rx: ${drug.indications}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f),
                        maxLines = 2
                    )
                    Text(
                        text = "Standard Dose: ${drug.doses.lines().firstOrNull() ?: drug.doses}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1
                    )
                }
            }

            // Brands Strip with Nepal Flag indicator
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Emerald500.copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.3f))
                ) {
                    Text(
                        text = "🇳🇵 Nepal",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Emerald500,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                drug.brandsNepal.take(2).forEach { brand ->
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
                    ) {
                        Text(
                            text = brand.name,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                if (drug.brandsIndia.isNotEmpty()) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
                    ) {
                        Text(
                            text = "🇮🇳 ${drug.brandsIndia.first().name}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                val moreCount = (drug.brandsNepal.size - 2).coerceAtLeast(0) + (drug.brandsIndia.size - 1).coerceAtLeast(0)
                if (moreCount > 0) {
                    Text(
                        text = "+$moreCount more",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tap to view full monograph & pharmacology",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DimsTealPrimary
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = DimsTealPrimary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun SearchProtocolCard(
    protocol: DiseaseProtocol,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.35f)),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("search_protocol_card_${protocol.id}")
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF0284C7).copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Description,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = "PROTOCOL",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF38BDF8)
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = protocol.category,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    if (protocol.icd10.isNotBlank()) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Emerald500.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "ICD ${protocol.icd10}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Emerald400,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Text(
                text = protocol.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = protocol.firstLine.lines().firstOrNull() ?: protocol.firstLine.take(90),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            if (protocol.keyDrugs.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Key Drugs:",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Slate400
                    )
                    protocol.keyDrugs.take(3).forEach { drugName ->
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                        ) {
                            Text(
                                text = drugName,
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ref: ${protocol.guidelines.take(45)}...",
                    fontSize = 10.sp,
                    color = Slate400,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "View Protocol",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SearchCalculatorCard(
    calculator: CalculatorSummary,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Amber500.copy(alpha = 0.35f)),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("search_calculator_card_${calculator.id}")
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Amber500.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, Amber400.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Calculate,
                            contentDescription = null,
                            tint = Amber400,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = "CALCULATOR",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = Amber400
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = calculator.category,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Text(
                text = calculator.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = calculator.description,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Formula: ${calculator.formulaSummary}",
                    fontSize = 10.5.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                    color = Slate400,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "Open Calculator",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Amber400
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Amber400,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SearchSectionHeader(
    icon: ImageVector,
    iconColor: Color,
    title: String,
    count: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = title,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Surface(
            shape = RoundedCornerShape(6.dp),
            color = iconColor.copy(alpha = 0.15f)
        ) {
            Text(
                text = "$count",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = iconColor,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 1.dp)
            )
        }
    }
}

@Composable
fun SearchEmptyState(
    query: String,
    onReset: () -> Unit,
    customMessage: String? = null
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(24.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.size(56.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Text(
                text = "No clinical matches found",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = customMessage ?: "No drugs, protocols, or calculators found matching \"$query\". Check spelling or try a brand name, generic molecule, disease, or calculator abbreviation.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            FilledTonalButton(
                onClick = onReset,
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = DimsTealPrimary.copy(alpha = 0.2f),
                    contentColor = DimsTealPrimary
                )
            ) {
                Text("Clear Search Query", fontWeight = FontWeight.Bold)
            }
        }
    }
}
