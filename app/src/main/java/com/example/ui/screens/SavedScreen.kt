package com.example.ui.screens

import androidx.compose.animation.*
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
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.entity.SavedItemEntity
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel
import com.example.viewmodel.NavigationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    var showClearDialog by remember { mutableStateOf(false) }

    val savedItems = state.savedItems
    val searchQuery = state.savedSearchQuery
    val activeCategory = state.savedCategoryFilter

    val drugCount = remember(savedItems) { savedItems.count { it.itemType == "DRUG" } }
    val protocolCount = remember(savedItems) { savedItems.count { it.itemType == "PROTOCOL" } }
    val calcCount = remember(savedItems) { savedItems.count { it.itemType == "CALCULATOR" } }
    val guideCount = remember(savedItems) { savedItems.count { it.itemType == "GUIDE" } }

    val filteredItems = remember(savedItems, searchQuery, activeCategory) {
        savedItems.filter { item ->
            val matchesCategory = when (activeCategory) {
                "Drugs" -> item.itemType == "DRUG"
                "Protocols" -> item.itemType == "PROTOCOL"
                "Calculators" -> item.itemType == "CALCULATOR"
                "Guides" -> item.itemType == "GUIDE"
                else -> true
            }
            val matchesQuery = if (searchQuery.isBlank()) true else {
                val q = searchQuery.trim().lowercase()
                item.title.lowercase().contains(q) ||
                item.subtitle.lowercase().contains(q) ||
                item.category.lowercase().contains(q)
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
        // 1. Top Header Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
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
                    color = Amber500.copy(alpha = 0.2f),
                    border = BorderStroke(1.dp, Amber500.copy(alpha = 0.45f)),
                    modifier = Modifier.size(44.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = null,
                            tint = Amber400,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Clinical Favorites & Saved",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Instant bookmarks for drugs, emergency protocols & clinical calculators",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = Slate400
                    )
                }
                if (savedItems.isNotEmpty()) {
                    IconButton(
                        onClick = { showClearDialog = true },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.DeleteSweep,
                            contentDescription = "Clear all",
                            tint = Red400,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        // 2. Search Box for Saved Items
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.setSavedSearchQuery(it) },
            placeholder = {
                Text(
                    text = "Search saved drugs, protocols, formulas...",
                    fontSize = 12.sp
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Amber400,
                    modifier = Modifier.size(18.dp)
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { viewModel.setSavedSearchQuery("") },
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
                .testTag("saved_search_input_field")
        )

        // 3. Category Filter Chips with counts
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryFilterChip(
                label = "All (${savedItems.size})",
                selected = activeCategory == "All",
                icon = Icons.Default.Bookmarks,
                activeColor = Amber400,
                onClick = { viewModel.setSavedCategoryFilter("All") }
            )
            CategoryFilterChip(
                label = "Drugs ($drugCount)",
                selected = activeCategory == "Drugs",
                icon = Icons.Default.Medication,
                activeColor = MedicalBlue400,
                onClick = { viewModel.setSavedCategoryFilter("Drugs") }
            )
            CategoryFilterChip(
                label = "Protocols ($protocolCount)",
                selected = activeCategory == "Protocols",
                icon = Icons.Default.LocalHospital,
                activeColor = Emerald500,
                onClick = { viewModel.setSavedCategoryFilter("Protocols") }
            )
            CategoryFilterChip(
                label = "Calculators ($calcCount)",
                selected = activeCategory == "Calculators",
                icon = Icons.Default.Calculate,
                activeColor = Cyan400,
                onClick = { viewModel.setSavedCategoryFilter("Calculators") }
            )
            CategoryFilterChip(
                label = "Guides ($guideCount)",
                selected = activeCategory == "Guides",
                icon = Icons.AutoMirrored.Filled.MenuBook,
                activeColor = Color(0xFFA5B4FC),
                onClick = { viewModel.setSavedCategoryFilter("Guides") }
            )
        }

        // 4. Content List / Empty State
        if (filteredItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                    modifier = Modifier.fillMaxWidth(0.92f)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Amber500.copy(alpha = 0.15f),
                            modifier = Modifier.size(56.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.BookmarkBorder,
                                    contentDescription = null,
                                    tint = Amber400,
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                        }

                        Text(
                            text = if (searchQuery.isNotEmpty()) "No matches for \"$searchQuery\"" else "No $activeCategory saved yet",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "Tap the bookmark icon on any drug, clinical protocol, or calculator to pin it here for immediate 1-tap clinical recall.",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 18.sp
                        )

                        // Quick Navigation Shortcuts
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            OutlinedButton(
                                onClick = { viewModel.navigateTo(NavigationScreen.SEARCH) },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                modifier = Modifier.height(34.dp)
                            ) {
                                Icon(Icons.Default.Medication, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Find Drugs", fontSize = 11.sp)
                            }
                            OutlinedButton(
                                onClick = { viewModel.navigateTo(NavigationScreen.DISEASE) },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                modifier = Modifier.height(34.dp)
                            ) {
                                Icon(Icons.Default.LocalHospital, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Protocols", fontSize = 11.sp)
                            }
                            OutlinedButton(
                                onClick = { viewModel.navigateTo(NavigationScreen.CALCULATOR) },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                modifier = Modifier.height(34.dp)
                            ) {
                                Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Calculators", fontSize = 11.sp)
                            }
                        }
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
                items(filteredItems, key = { it.id }) { item ->
                    SavedItemCard(
                        item = item,
                        onClick = { viewModel.openSavedItem(item) },
                        onRemove = { viewModel.removeSavedItem(item.id) }
                    )
                }
            }
        }
    }

    // Confirmation dialog to clear all saved items
    if (showClearDialog) {
        AlertDialog(
            onDismissRequest = { showClearDialog = false },
            title = {
                Text(
                    text = "Clear All Saved Favorites?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = "This will remove all bookmarked drugs, clinical protocols, and medical calculators from your saved list.",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.clearAllSaved()
                        showClearDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Clear All")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun CategoryFilterChip(
    label: String,
    selected: Boolean,
    icon: ImageVector,
    activeColor: Color,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = if (selected) activeColor.copy(alpha = 0.18f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        border = BorderStroke(1.dp, if (selected) activeColor else Color.Transparent),
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (selected) activeColor else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                color = if (selected) activeColor else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SavedItemCard(
    item: SavedItemEntity,
    onClick: () -> Unit,
    onRemove: () -> Unit
) {
    val (typeColor, typeBg, typeIcon, typeBadge, actionLabel) = when (item.itemType) {
        "DRUG" -> Quintuple(MedicalBlue400, MedicalBlue900.copy(alpha = 0.35f), Icons.Default.Medication, "DRUG", "Open Monograph")
        "PROTOCOL" -> Quintuple(Emerald500, Emerald950.copy(alpha = 0.35f), Icons.Default.LocalHospital, "PROTOCOL", "View Protocol")
        "CALCULATOR" -> Quintuple(Cyan400, Color(0xFF0E7490).copy(alpha = 0.35f), Icons.Default.Calculate, "CALCULATOR", "Launch Calculator")
        "GUIDE" -> Quintuple(Color(0xFFA5B4FC), Color(0xFF6366F1).copy(alpha = 0.25f), Icons.AutoMirrored.Filled.MenuBook, "REVIEW", "Open Pharmacology Guide")
        else -> Quintuple(Amber400, Amber950.copy(alpha = 0.35f), Icons.Default.Bookmark, "SAVED", "View")
    }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.22f)),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .clickable(onClick = onClick)
            .testTag("saved_item_${item.id}")
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Left Icon Badge
            Surface(
                shape = CircleShape,
                color = typeBg,
                border = BorderStroke(1.dp, typeColor.copy(alpha = 0.45f)),
                modifier = Modifier.size(42.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = typeIcon,
                        contentDescription = null,
                        tint = typeColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // Central Info
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = typeColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = typeBadge,
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Black,
                            color = typeColor,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }

                    if (item.category.isNotBlank()) {
                        Text(
                            text = item.category,
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (item.subtitle.isNotBlank()) {
                    Text(
                        text = item.subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(top = 2.dp)
                ) {
                    Text(
                        text = actionLabel,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = typeColor
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = typeColor,
                        modifier = Modifier.size(11.dp)
                    )
                }
            }

            // Right Bookmark Star button (Active saved)
            IconButton(
                onClick = onRemove,
                modifier = Modifier
                    .size(34.dp)
                    .testTag("saved_item_unbookmark_${item.id}")
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = "Remove from saved",
                    tint = Amber400,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

private data class Quintuple<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
)
