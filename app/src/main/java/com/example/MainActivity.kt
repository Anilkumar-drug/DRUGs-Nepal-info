package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.model.Drug
import com.example.ui.components.AppSidebarDrawer
import com.example.ui.components.VoiceSearchButton
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
    val unselectedIcon: ImageVector,
    val activeColor: Color
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
                unselectedIcon = Icons.Outlined.Medication,
                activeColor = MedicalBlue500
            ),
            NavItem(
                screen = NavigationScreen.DISEASE,
                label = "Conditions",
                selectedIcon = Icons.Filled.LocalHospital,
                unselectedIcon = Icons.Outlined.LocalHospital,
                activeColor = Emerald500
            ),
            NavItem(
                screen = NavigationScreen.INTERACTION,
                label = "Interactions",
                selectedIcon = Icons.Filled.ElectricBolt,
                unselectedIcon = Icons.Outlined.ElectricBolt,
                activeColor = Red500
            ),
            NavItem(
                screen = NavigationScreen.CALCULATOR,
                label = "Calculators",
                selectedIcon = Icons.Filled.Calculate,
                unselectedIcon = Icons.Outlined.Calculate,
                activeColor = Amber500
            ),
            NavItem(
                screen = NavigationScreen.GEMINI,
                label = "AI Copilot",
                selectedIcon = Icons.Filled.AutoAwesome,
                unselectedIcon = Icons.Outlined.AutoAwesome,
                activeColor = SparkleViolet
            )
        )
    }

    val keyboardController = LocalSoftwareKeyboardController.current

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

                    // Top Navy Bar formatted with animated colored icons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Three-Dot Sidebar Button (Left) - Animated teal pulse
                        val sidebarScale by animateFloatAsState(
                            targetValue = if (state.isSidebarOpen) 0.88f else 1f,
                            animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                            label = "sidebarScale"
                        )
                        Surface(
                            onClick = { viewModel.openSidebar() },
                            shape = RoundedCornerShape(12.dp),
                            color = NavyPill,
                            border = BorderStroke(1.2.dp, DimsTealPrimary.copy(alpha = 0.8f)),
                            modifier = Modifier
                                .size(42.dp)
                                .scale(sidebarScale)
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

                        // Rounded Search Pill (Center) with Voice-to-Text Microphone
                        val isSearchActive = state.currentScreen == NavigationScreen.SEARCH
                        val searchPillBorderColor by animateColorAsState(
                            targetValue = if (isSearchActive) MedicalBlue400 else NavyCardBorder,
                            label = "searchPillBorder"
                        )
                        Surface(
                            onClick = {
                                if (state.currentScreen != NavigationScreen.SEARCH) {
                                    viewModel.navigateTo(NavigationScreen.SEARCH)
                                }
                            },
                            shape = RoundedCornerShape(22.dp),
                            color = NavyPill,
                            border = BorderStroke(1.2.dp, searchPillBorderColor),
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp)
                                .testTag("top_search_pill")
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 12.dp, end = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = if (isSearchActive) MedicalBlue400 else Slate400,
                                    modifier = Modifier.size(18.dp)
                                )

                                Text(
                                    text = if (state.searchQuery.isNotBlank()) state.searchQuery else "Search drug or protocol...",
                                    fontSize = 12.sp,
                                    color = if (state.searchQuery.isNotBlank()) Color.White else Slate400,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f)
                                )

                                if (state.searchQuery.isNotBlank()) {
                                    IconButton(
                                        onClick = { viewModel.updateSearchQuery("") },
                                        modifier = Modifier.size(26.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Clear Search",
                                            tint = Slate400,
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }

                                VoiceSearchButton(
                                    onSpokenText = { spoken ->
                                        viewModel.updateSearchQuery(spoken)
                                        viewModel.navigateTo(NavigationScreen.SEARCH)
                                    },
                                    size = 32.dp,
                                    idleColor = MedicalBlue400,
                                    activeColor = Red500,
                                    testTag = "top_bar_voice_search_button"
                                )
                            }
                        }

                        // Brand vs Generic Switch Button (With animated bounce and color transitions)
                        val isBrand = state.searchMode == SearchMode.BRAND
                        val brandBtnScale by animateFloatAsState(
                            targetValue = if (isBrand) 1f else 1.05f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                            label = "brandBtnScale"
                        )
                        val brandBtnBgColor by animateColorAsState(
                            targetValue = if (isBrand) DimsTealPrimary.copy(alpha = 0.35f) else Amber500.copy(alpha = 0.35f),
                            label = "brandBtnBg"
                        )
                        val brandBtnBorderColor by animateColorAsState(
                            targetValue = if (isBrand) DimsTealPrimary else Amber400,
                            label = "brandBtnBorder"
                        )
                        Surface(
                            onClick = {
                                val nextMode = if (isBrand) SearchMode.GENERIC else SearchMode.BRAND
                                viewModel.setSearchMode(nextMode)
                                if (state.currentScreen != NavigationScreen.SEARCH) {
                                    viewModel.navigateTo(NavigationScreen.SEARCH)
                                }
                            },
                            shape = CircleShape,
                            color = brandBtnBgColor,
                            border = BorderStroke(1.4.dp, brandBtnBorderColor),
                            modifier = Modifier
                                .size(38.dp)
                                .scale(brandBtnScale)
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
                                        tint = if (isBrand) Emerald400 else Amber400,
                                        modifier = Modifier.size(17.dp)
                                    )
                                    Text(
                                        text = if (isBrand) "BRAND" else "GENERIC",
                                        fontSize = 7.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isBrand) Emerald400 else Amber400,
                                        letterSpacing = 0.2.sp,
                                        maxLines = 1
                                    )
                                }
                            }
                        }

                        // Sparkle Gemini AI Button (Right 1) - Glowing violet animation
                        val isGeminiActive = state.currentScreen == NavigationScreen.GEMINI
                        val geminiScale by animateFloatAsState(
                            targetValue = if (isGeminiActive) 1.12f else 1f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                            label = "geminiScale"
                        )
                        val geminiBgColor by animateColorAsState(
                            targetValue = if (isGeminiActive) SparkleViolet.copy(alpha = 0.35f) else NavyPill,
                            label = "geminiBg"
                        )
                        Surface(
                            onClick = { viewModel.navigateTo(NavigationScreen.GEMINI) },
                            shape = CircleShape,
                            color = geminiBgColor,
                            border = BorderStroke(1.4.dp, if (isGeminiActive) SparkleViolet else SparkleViolet.copy(alpha = 0.6f)),
                            modifier = Modifier
                                .size(38.dp)
                                .scale(geminiScale)
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

                        // Bookmarks / Saved Button (Right 2) - Animated golden bookmark
                        val isBookmarkFiltered = state.activeFilter == DrugFilterType.BOOKMARKS
                        val bookmarkScale by animateFloatAsState(
                            targetValue = if (isBookmarkFiltered) 1.12f else 1f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                            label = "bookmarkScale"
                        )
                        val bookmarkBgColor by animateColorAsState(
                            targetValue = if (isBookmarkFiltered) Amber500 else NavyPill,
                            label = "bookmarkBg"
                        )
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
                            color = bookmarkBgColor,
                            border = BorderStroke(1.4.dp, if (isBookmarkFiltered) Amber400 else NavyCardBorder),
                            modifier = Modifier
                                .size(38.dp)
                                .scale(bookmarkScale)
                                .testTag("top_bookmarks_button")
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = if (isBookmarkFiltered) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                                    contentDescription = "Bookmarks",
                                    tint = if (isBookmarkFiltered) Color.Black else Amber400,
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
                            val iconScale by animateFloatAsState(
                                targetValue = if (isSelected) 1.18f else 1f,
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessMediumLow
                                ),
                                label = "navIconScale"
                            )
                            val iconColor by animateColorAsState(
                                targetValue = if (isSelected) item.activeColor else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.65f),
                                animationSpec = tween(durationMillis = 200),
                                label = "navIconColor"
                            )

                            NavigationBarItem(
                                selected = isSelected,
                                onClick = { viewModel.navigateTo(item.screen) },
                                icon = {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier.scale(iconScale)
                                    ) {
                                        Icon(
                                            imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                            contentDescription = item.label,
                                            tint = iconColor,
                                            modifier = Modifier.size(23.dp)
                                        )
                                    }
                                },
                                label = {
                                    Text(
                                        text = item.label,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) item.activeColor else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = item.activeColor,
                                    selectedTextColor = item.activeColor,
                                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    indicatorColor = item.activeColor.copy(alpha = 0.16f)
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
                    recentSearches = state.recentSearches,
                    onSearchChange = { viewModel.updateSearchQuery(it) },
                    onSearchSubmit = { viewModel.addRecentSearch(it) },
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

                NavigationScreen.DISEASE -> DiseaseProtocolsScreen(
                    onProtocolClick = { protocol ->
                        viewModel.addRecentSearch(protocol.name)
                    }
                )

                NavigationScreen.ANTIDOTE -> AntidoteToxicologyScreen(
                    onAntidoteClick = { antidote ->
                        viewModel.addRecentSearch(antidote.poison)
                    }
                )

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
