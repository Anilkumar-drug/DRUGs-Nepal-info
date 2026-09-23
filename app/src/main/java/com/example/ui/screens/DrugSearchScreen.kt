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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Drug
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
    bookmarkedDrugIds: Set<String>,
    recentSearches: List<String> = emptyList(),
    onSearchChange: (String) -> Unit,
    onSearchSubmit: (String) -> Unit = {},
    onSearchModeChange: (SearchMode) -> Unit = {},
    onFilterChange: (DrugFilterType) -> Unit,
    onClearSystemFilter: () -> Unit,
    onDrugClick: (Drug) -> Unit,
    onBookmarkToggle: (String) -> Unit
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

    val tabs = remember {
        listOf(
            Triple(SearchMode.BRAND, "Brand", Icons.Default.Medication),
            Triple(SearchMode.GENERIC, "Generic", Icons.Default.Science),
            Triple(SearchMode.INDICATION, "Indication", Icons.Default.Hub),
            Triple(SearchMode.HERBAL, "Herbal", Icons.Default.Spa)
        )
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Spacer(modifier = Modifier.height(2.dp))

        // Direct Interactive Search Field with Keyboard Activation & Mic
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            placeholder = {
                Text(
                    when (searchMode) {
                        SearchMode.BRAND -> "Search brand name (e.g., Moxclave, Pantocid)..."
                        SearchMode.GENERIC -> "Search generic molecule (e.g., Amoxicillin)..."
                        SearchMode.INDICATION -> "Search indication (e.g., Pneumonia, UTI)..."
                        SearchMode.HERBAL -> "Search herbal / Ayurvedic formulation..."
                    },
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = DimsTealPrimary,
                    modifier = Modifier.size(20.dp)
                )
            },
            trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = { onSearchChange("") },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    VoiceSearchButton(
                        onSpokenText = { text ->
                            onSearchChange(text)
                        },
                        size = 32.dp,
                        idleColor = DimsTealPrimary,
                        activeColor = Red500,
                        testTag = "drug_search_voice_btn"
                    )
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
                if (searchQuery.isNotBlank()) {
                    onSearchSubmit(searchQuery)
                }
            }),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedBorderColor = DimsTealPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("drug_search_active_textfield")
        )

        // 4 Mode Selector Tabs (Brand, Generic, Indication, Herbal) exactly formatted as Screenshot 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            tabs.forEach { (mode, label, icon) ->
                val isSelected = searchMode == mode
                Surface(
                    onClick = { onSearchModeChange(mode) },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) DimsTealPrimary else MaterialTheme.colorScheme.surface,
                    border = BorderStroke(
                        1.dp,
                        if (isSelected) DimsTealPrimary else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp)
                        .testTag("search_tab_${label.lowercase()}")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = label,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                        )
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

        // Recent Searches section for quick navigation (Last 5 drugs or protocols searched)
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

        // Empty Search Prompt with Friendly Mascot / Magnifier as in Screenshot 1
        if (searchQuery.isEmpty() && selectedSystemFilter == null && activeFilter == DrugFilterType.ALL) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Custom Magnifying Glass Character Illustration (Screenshot 1 Style)
                    MascotMagnifyingGlass(modifier = Modifier.size(110.dp))

                    Text(
                        text = when (searchMode) {
                            SearchMode.BRAND -> "Search by Brand name"
                            SearchMode.GENERIC -> "Search by Generic name"
                            SearchMode.INDICATION -> "Search by Indication"
                            SearchMode.HERBAL -> "Search Herbal Formulations"
                        },
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "Instant access to 10,000+ Nepal DDA registered drugs, prices, and international equivalents.",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )

                    // Quick Suggested Tap Chips
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Red500.copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, Red500.copy(alpha = 0.35f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                VoiceSearchButton(
                                    onSpokenText = { spoken -> onSearchChange(spoken) },
                                    size = 26.dp,
                                    idleColor = Red500,
                                    activeColor = Red600,
                                    testTag = "empty_state_voice_search_button"
                                )
                                Text(
                                    text = "Tap to speak",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Red500
                                )
                            }
                        }

                        effectiveRecentSearches.take(6).forEach { chip ->
                            Surface(
                                onClick = { onSearchChange(chip.split(" ").first()) },
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
                            ) {
                                Text(
                                    text = chip,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Results Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${filteredDrugs.size} drugs found",
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

        // Drug Cards List
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
                            text = "Search by Nepal brand (e.g. Moxclave, Dolo, Pantocid), generic name, or change tab above.",
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
        }
    }
}
