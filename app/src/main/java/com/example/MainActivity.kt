package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.model.Drug
import com.example.ui.components.AppSidebarDrawer
import com.example.ui.screens.*
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalViewModel
import com.example.viewmodel.DrugFilterType
import com.example.viewmodel.NavigationScreen
import com.example.viewmodel.SearchMode

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

    val navItems = remember {
        listOf(
            NavItem(
                screen = NavigationScreen.SEARCH,
                label = "Drugs",
                selectedIcon = Icons.Filled.Medication,
                unselectedIcon = Icons.Outlined.Medication
            ),
            NavItem(
                screen = NavigationScreen.DISEASE,
                label = "Conditions",
                selectedIcon = Icons.Filled.LocalHospital,
                unselectedIcon = Icons.Outlined.LocalHospital
            ),
            NavItem(
                screen = NavigationScreen.INTERACTION,
                label = "Interactions",
                selectedIcon = Icons.Filled.ElectricBolt,
                unselectedIcon = Icons.Outlined.ElectricBolt
            ),
            NavItem(
                screen = NavigationScreen.CALCULATOR,
                label = "Calculators",
                selectedIcon = Icons.Filled.Calculate,
                unselectedIcon = Icons.Outlined.Calculate
            ),
            NavItem(
                screen = NavigationScreen.GEMINI,
                label = "AI Copilot",
                selectedIcon = Icons.Filled.AutoAwesome,
                unselectedIcon = Icons.Outlined.AutoAwesome
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .testTag("drugs_nepal_scaffold"),
            topBar = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(NavyDeep)
                ) {
                    // Status Bar Inset Spacer
                    Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

                    // Top Navy Bar formatted exactly as Screenshot 2 & 3
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Three-Dot Sidebar Button (Left) - Exactly as circled in Screenshot 2
                        Surface(
                            onClick = { viewModel.openSidebar() },
                            shape = RoundedCornerShape(12.dp),
                            color = NavyPill,
                            border = BorderStroke(1.dp, NavyCardBorder),
                            modifier = Modifier
                                .size(42.dp)
                                .testTag("top_three_dots_button")
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Open Sidebar Navigation Menu",
                                    tint = DimsTealPrimary,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }

                        // Rounded Search Pill (Center)
                        Surface(
                            onClick = { viewModel.navigateTo(NavigationScreen.SEARCH) },
                            shape = RoundedCornerShape(22.dp),
                            color = NavyPill,
                            border = BorderStroke(1.dp, NavyCardBorder),
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp)
                                .testTag("top_search_pill")
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = Slate400,
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = if (state.searchQuery.isNotBlank()) state.searchQuery 
                                    else "औषधि, खतराका लक्षण, क्याल्कुलेटर खोज्नुहोस्... (Search drugs, conditions...)",
                                    fontSize = 12.sp,
                                    color = if (state.searchQuery.isNotBlank()) Color.White else Slate400,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                    // Brand vs Generic Switch Button (Before AI icon)
                    val isBrand = state.searchMode == SearchMode.BRAND
                    Surface(
                        onClick = {
                            val nextMode = if (isBrand) SearchMode.GENERIC else SearchMode.BRAND
                            viewModel.setSearchMode(nextMode)
                            if (state.currentScreen != NavigationScreen.SEARCH) {
                                viewModel.navigateTo(NavigationScreen.SEARCH)
                            }
                        },
                        shape = CircleShape,
                        color = if (isBrand) DimsTealPrimary.copy(alpha = 0.2f) else Amber500.copy(alpha = 0.2f),
                        border = BorderStroke(1.2.dp, if (isBrand) DimsTealPrimary else Amber400),
                        modifier = Modifier
                            .size(38.dp)
                            .testTag("top_brand_generic_switch_button")
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(1.dp)
                            ) {
                                Icon(
                                    imageVector = if (isBrand) Icons.Default.Medication else Icons.Default.Science,
                                    contentDescription = if (isBrand) "Current: Brand Mode. Tap to switch to Generic" else "Current: Generic Mode. Tap to switch to Brand",
                                    tint = if (isBrand) DimsTealPrimary else Amber400,
                                    modifier = Modifier.size(17.dp)
                                )
                                Text(
                                    text = if (isBrand) "BRAND" else "GENERIC",
                                    fontSize = 7.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isBrand) DimsTealPrimary else Amber400,
                                    letterSpacing = 0.2.sp,
                                    maxLines = 1
                                )
                            }
                        }
                    }

                    // Sparkle Gemini AI Button (Right 1)
                    Surface(
                        onClick = { viewModel.navigateTo(NavigationScreen.GEMINI) },
                        shape = CircleShape,
                        color = NavyPill,
                        border = BorderStroke(1.dp, SparkleViolet.copy(alpha = 0.5f)),
                        modifier = Modifier
                            .size(38.dp)
                            .testTag("top_sparkle_gemini_button")
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = "Gemini AI Copilot",
                                tint = SparkleViolet,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    // Bookmarks / Saved Button (Right 2)
                    val isBookmarkFiltered = state.activeFilter == DrugFilterType.BOOKMARKS
                    Surface(
                        onClick = {
                            viewModel.navigateTo(NavigationScreen.SEARCH)
                            if (isBookmarkFiltered) {
                                viewModel.setFilter(DrugFilterType.ALL)
                            } else {
                                viewModel.setFilter(DrugFilterType.BOOKMARKS)
                            }
                        },
                        shape = CircleShape,
                        color = if (isBookmarkFiltered) Amber500 else NavyPill,
                        border = BorderStroke(1.dp, if (isBookmarkFiltered) Amber400 else NavyCardBorder),
                        modifier = Modifier
                            .size(38.dp)
                            .testTag("top_bookmarks_button")
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = if (isBookmarkFiltered) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                                contentDescription = "Bookmarks",
                                tint = if (isBookmarkFiltered) Color.Black else Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))
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
                                        if (item.screen == NavigationScreen.INTERACTION) Red500
                                        else if (item.screen == NavigationScreen.GEMINI) SparkleViolet
                                        else MaterialTheme.colorScheme.primary
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
                    searchMode = state.searchMode,
                    activeFilter = state.activeFilter,
                    selectedSystemFilter = state.selectedSystemFilter,
                    filteredDrugs = state.filteredDrugs,
                    bookmarkedDrugIds = state.bookmarkedDrugIds,
                    onSearchChange = { viewModel.updateSearchQuery(it) },
                    onSearchModeChange = { viewModel.setSearchMode(it) },
                    onFilterChange = { viewModel.setFilter(it) },
                    onClearSystemFilter = { viewModel.filterBySystem("All Systems") },
                    onDrugClick = { viewModel.openDrug(it) },
                    onBookmarkToggle = { viewModel.toggleBookmark(it) }
                )

                NavigationScreen.INTERACTION -> InteractionCheckerScreen(
                    state = state,
                    viewModel = viewModel
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

                NavigationScreen.COMPANIES -> CompaniesScreen(
                    onDrugClick = { viewModel.openDrug(it) },
                    onBackClick = { viewModel.navigateTo(NavigationScreen.SEARCH) }
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

            // Practitioner Login / Credentials Dialog
            if (state.isLoginDialogOpen) {
                com.example.ui.components.PractitionerLoginDialog(
                    isLoggedIn = state.isLoggedIn,
                    initialName = state.doctorName,
                    initialDegree = state.doctorDegree,
                    initialCouncilNo = state.doctorCouncilNo,
                    onDismissRequest = { viewModel.closeLoginDialog() },
                    onSave = { name, degree, councilNo ->
                        viewModel.loginOrUpdateProfile(name, degree, councilNo)
                    },
                    onLogout = {
                        viewModel.logout()
                    }
                )
            }
        }
    }

    // Three-Dot Sidebar Drawer (Exactly as shown in Screenshot 1)
    AppSidebarDrawer(
        isOpen = state.isSidebarOpen,
        isLoggedIn = state.isLoggedIn,
        doctorName = state.doctorName,
        doctorDegree = state.doctorDegree,
        doctorCouncilNo = state.doctorCouncilNo,
        onClose = { viewModel.closeSidebar() },
        onSignInClick = {
            viewModel.closeSidebar()
            viewModel.openLoginDialog()
        },
        onCompaniesClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.COMPANIES)
        },
        onDrugsByIndicationClick = {
            viewModel.closeSidebar()
            viewModel.setSearchMode(SearchMode.INDICATION)
            viewModel.navigateTo(NavigationScreen.SEARCH)
        },
        onDrugsBySystemClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.SYSTEM)
        },
        onCalculatorsClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.CALCULATOR)
        },
        onAiAssistantClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.GEMINI)
        },
        onInteractionsClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.INTERACTION)
        },
        onAntidotesClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.ANTIDOTE)
        },
        onSettingsClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.SETTINGS)
        }
    )
}
}
