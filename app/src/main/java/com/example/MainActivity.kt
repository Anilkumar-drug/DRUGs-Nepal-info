package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.screens.*
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalViewModel
import com.example.viewmodel.NavigationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: ClinicalViewModel = viewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()

            DrugsNepalTheme(
                themeMode = state.themeMode,
                fontSizeScale = state.fontSizeScale
            ) {
                DrugsNepalMainApp(viewModel = viewModel)
            }
        }
    }
}

data class NavItem(
    val screen: NavigationScreen,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugsNepalMainApp(viewModel: ClinicalViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val navItems = listOf(
        NavItem(
            screen = NavigationScreen.SEARCH,
            label = "Drugs",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search
        ),
        NavItem(
            screen = NavigationScreen.SYSTEM,
            label = "Systems",
            selectedIcon = Icons.Filled.GridView,
            unselectedIcon = Icons.Outlined.GridView
        ),
        NavItem(
            screen = NavigationScreen.DISEASE,
            label = "Protocols",
            selectedIcon = Icons.AutoMirrored.Filled.MenuBook,
            unselectedIcon = Icons.AutoMirrored.Outlined.MenuBook
        ),
        NavItem(
            screen = NavigationScreen.ANTIDOTE,
            label = "Toxicology",
            selectedIcon = Icons.Filled.Warning,
            unselectedIcon = Icons.Outlined.WarningAmber
        ),
        NavItem(
            screen = NavigationScreen.CALCULATOR,
            label = "MDCalc",
            selectedIcon = Icons.Filled.Calculate,
            unselectedIcon = Icons.Outlined.Calculate
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .testTag("drugs_nepal_scaffold"),
        topBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 3.dp,
                shadowElevation = 2.dp
            ) {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.primary,
                                shadowElevation = 2.dp
                            ) {
                                Text(
                                    text = "Rx",
                                    color = Color.White,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(
                                        text = "DRUGs Nepal",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Black,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
                                    ) {
                                        Text(
                                            text = "EML",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = when (state.currentScreen) {
                                        NavigationScreen.GEMINI -> "AI Pharmacology Copilot"
                                        NavigationScreen.SETTINGS -> "Settings & Prescriber Profile"
                                        else -> state.currentScreen.title
                                    },
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    },
                    actions = {
                        // Gemini AI Copilot Quick Pill Button
                        Surface(
                            onClick = { viewModel.navigateTo(NavigationScreen.GEMINI) },
                            shape = RoundedCornerShape(16.dp),
                            color = if (state.currentScreen == NavigationScreen.GEMINI) {
                                Indigo500
                            } else {
                                Indigo500.copy(alpha = 0.12f)
                            },
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (state.currentScreen == NavigationScreen.GEMINI) Indigo500 else Indigo400.copy(alpha = 0.4f)
                            ),
                            modifier = Modifier
                                .testTag("top_gemini_button")
                                .padding(end = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AutoAwesome,
                                    contentDescription = "Gemini AI",
                                    tint = if (state.currentScreen == NavigationScreen.GEMINI) Color.White else Indigo400,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "AI Copilot",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (state.currentScreen == NavigationScreen.GEMINI) Color.White else Indigo400
                                )
                            }
                        }

                        // Settings Button
                        IconButton(
                            onClick = { viewModel.navigateTo(NavigationScreen.SETTINGS) },
                            modifier = Modifier
                                .testTag("top_settings_button")
                                .clip(CircleShape)
                                .background(if (state.currentScreen == NavigationScreen.SETTINGS) MaterialTheme.colorScheme.primaryContainer else Color.Transparent)
                        ) {
                            Icon(
                                imageVector = if (state.currentScreen == NavigationScreen.SETTINGS) Icons.Filled.Settings else Icons.Outlined.Settings,
                                contentDescription = "Settings",
                                tint = if (state.currentScreen == NavigationScreen.SETTINGS) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                border = androidx.compose.foundation.BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))
            ) {
                NavigationBar(
                    containerColor = Color.Transparent,
                    tonalElevation = 0.dp,
                    windowInsets = WindowInsets.navigationBars,
                    modifier = Modifier.testTag("bottom_navigation_bar")
                ) {
                    navItems.forEach { item ->
                        val isSelected = state.currentScreen == item.screen
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { viewModel.navigateTo(item.screen) },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.label,
                                    tint = if (isSelected) {
                                        if (item.screen == NavigationScreen.ANTIDOTE) Red500 else MaterialTheme.colorScheme.primary
                                    } else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            label = {
                                Text(
                                    text = item.label,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                            ),
                            modifier = Modifier.testTag("nav_${item.screen.name.lowercase()}")
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (state.currentScreen) {
                NavigationScreen.SEARCH -> DrugSearchScreen(
                    searchQuery = state.searchQuery,
                    activeFilter = state.activeFilter,
                    selectedSystemFilter = state.selectedSystemFilter,
                    filteredDrugs = viewModel.getFilteredDrugs(),
                    bookmarkedDrugIds = state.bookmarkedDrugIds,
                    onSearchChange = { viewModel.updateSearchQuery(it) },
                    onFilterChange = { viewModel.setFilter(it) },
                    onClearSystemFilter = { viewModel.filterBySystem("All Systems") },
                    onDrugClick = { viewModel.openDrug(it) },
                    onBookmarkToggle = { viewModel.toggleBookmark(it) }
                )

                NavigationScreen.SYSTEM -> SystemBrowseScreen(
                    onSystemSelected = { systemName ->
                        viewModel.filterBySystem(systemName)
                    }
                )

                NavigationScreen.DISEASE -> DiseaseProtocolsScreen()

                NavigationScreen.ANTIDOTE -> AntidoteToxicologyScreen()

                NavigationScreen.CALCULATOR -> CalculatorsScreen(
                    state = state,
                    viewModel = viewModel
                )

                NavigationScreen.GEMINI -> GeminiChatScreen(
                    state = state,
                    viewModel = viewModel
                )

                NavigationScreen.SETTINGS -> SettingsScreen(
                    state = state,
                    viewModel = viewModel
                )
            }

            // Drug Detail Modal
            if (state.isDrugModalOpen && state.selectedDrug != null) {
                val drug = state.selectedDrug!!
                DrugDetailModal(
                    drug = drug,
                    patientWeightKg = state.patientWeightKg,
                    isBookmarked = state.bookmarkedDrugIds.contains(drug.id),
                    onBookmarkToggle = { viewModel.toggleBookmark(drug.id) },
                    onWeightChanged = { viewModel.updatePatientWeight(it) },
                    onDismiss = { viewModel.closeDrugModal() }
                )
            }
        }
    }
}
