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
import com.example.ui.theme.DrugsNepalTheme
import com.example.ui.theme.Emerald400
import com.example.ui.theme.Indigo400
import com.example.ui.theme.Red400
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
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Text(
                                text = "Rx",
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Column {
                            Text(
                                text = "DRUGs Nepal",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = when (state.currentScreen) {
                                    NavigationScreen.GEMINI -> "AI Pharmacology Copilot"
                                    NavigationScreen.SETTINGS -> "Settings & Profile"
                                    else -> state.currentScreen.title
                                },
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                actions = {
                    // Gemini AI Copilot Button
                    IconButton(
                        onClick = { viewModel.navigateTo(NavigationScreen.GEMINI) },
                        modifier = Modifier
                            .testTag("top_gemini_button")
                            .clip(CircleShape)
                            .background(if (state.currentScreen == NavigationScreen.GEMINI) Indigo400.copy(alpha = 0.2f) else Color.Transparent)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Gemini AI",
                            tint = if (state.currentScreen == NavigationScreen.GEMINI) Indigo400 else MaterialTheme.colorScheme.onSurfaceVariant
                        )
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
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp,
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
                                    if (item.screen == NavigationScreen.ANTIDOTE) Red400 else MaterialTheme.colorScheme.primary
                                } else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                fontSize = 10.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
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
