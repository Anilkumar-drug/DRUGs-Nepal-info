package com.example

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import com.example.data.model.AppThemeMode
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
import androidx.compose.material.icons.automirrored.filled.*
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
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    var lastBackPressTime by remember { mutableLongStateOf(0L) }

    // Intercept back button: take to first page (SEARCH) if on another page or if modal/drawer is open,
    // and on first page require a second back click within 2 seconds to exit the app.
    BackHandler(enabled = true) {
        when {
            state.isSidebarOpen -> {
                viewModel.closeSidebar()
            }
            state.isDrugModalOpen -> {
                viewModel.closeDrugModal()
            }
            state.currentScreen == NavigationScreen.DISEASE && state.selectedProtocol != null -> {
                viewModel.closeProtocol()
            }
            state.currentScreen == NavigationScreen.CALCULATOR && state.selectedCalculatorId != null -> {
                viewModel.closeCalculator()
            }
            state.currentScreen != NavigationScreen.SEARCH -> {
                viewModel.navigateTo(NavigationScreen.SEARCH)
            }
            else -> {
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastBackPressTime < 2000L) {
                    (context as? Activity)?.finish()
                } else {
                    lastBackPressTime = currentTime
                    Toast.makeText(context, "Press back again to exit", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

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
                label = "Indication",
                selectedIcon = Icons.Filled.LocalHospital,
                unselectedIcon = Icons.Outlined.LocalHospital,
                activeColor = Emerald500
            ),
            NavItem(
                screen = NavigationScreen.SAVED,
                label = "Saved",
                selectedIcon = Icons.Filled.Bookmark,
                unselectedIcon = Icons.Outlined.BookmarkBorder,
                activeColor = Amber500
            ),
            NavItem(
                screen = NavigationScreen.CALCULATOR,
                label = "Cal",
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
                val topBarBg by animateColorAsState(
                    targetValue = when (state.themeMode) {
                        AppThemeMode.PITCH_BLACK -> Color.Black
                        AppThemeMode.DARK -> NavyDeep
                        AppThemeMode.LIGHT -> Color(0xFFF1F5F9)
                    },
                    label = "topBarBg"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(topBarBg)
                ) {
                    // Status Bar Inset Spacer
                    Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

                    // Top Navy Bar formatted with animated colored icons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
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
                                .size(38.dp)
                                .scale(sidebarScale)
                                .testTag("top_three_dots_button")
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Open Sidebar Navigation Menu",
                                    tint = DimsTealPrimary,
                                    modifier = Modifier.size(20.dp)
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
                            shape = RoundedCornerShape(22.dp),
                            color = NavyPill,
                            border = BorderStroke(1.2.dp, searchPillBorderColor),
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
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

                                BasicTextField(
                                    value = state.searchQuery,
                                    onValueChange = { query ->
                                        viewModel.updateSearchQuery(query)
                                        if (state.currentScreen != NavigationScreen.SEARCH) {
                                            viewModel.navigateTo(NavigationScreen.SEARCH)
                                        }
                                    },
                                    singleLine = true,
                                    textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium
                                    ),
                                    cursorBrush = SolidColor(MedicalBlue400),
                                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                                    keyboardActions = KeyboardActions(onSearch = {
                                        keyboardController?.hide()
                                        if (state.searchQuery.isNotBlank()) {
                                            viewModel.addRecentSearch(state.searchQuery)
                                        }
                                        viewModel.navigateTo(NavigationScreen.SEARCH)
                                    }),
                                    decorationBox = { innerTextField ->
                                        if (state.searchQuery.isEmpty()) {
                                            Text(
                                                text = "Search drugs, protocols, calculators...",
                                                fontSize = 12.sp,
                                                color = Slate400,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        innerTextField()
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .testTag("top_search_text_input")
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
                        val isGeneric = state.searchMode == SearchMode.GENERIC
                        val brandBtnScale by animateFloatAsState(
                            targetValue = if (isBrand || isGeneric) 1f else 0.95f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                            label = "brandBtnScale"
                        )
                        val brandBtnBgColor by animateColorAsState(
                            targetValue = when {
                                isBrand -> DimsTealPrimary.copy(alpha = 0.35f)
                                isGeneric -> Amber500.copy(alpha = 0.35f)
                                else -> NavyPill
                            },
                            label = "brandBtnBg"
                        )
                        val brandBtnBorderColor by animateColorAsState(
                            targetValue = when {
                                isBrand -> DimsTealPrimary
                                isGeneric -> Amber400
                                else -> NavyCardBorder
                            },
                            label = "brandBtnBorder"
                        )
                        Surface(
                            onClick = {
                                val nextMode = if (isGeneric) SearchMode.BRAND else SearchMode.GENERIC
                                viewModel.setSearchMode(nextMode)
                                if (state.currentScreen != NavigationScreen.SEARCH) {
                                    viewModel.navigateTo(NavigationScreen.SEARCH)
                                }
                            },
                            shape = CircleShape,
                            color = brandBtnBgColor,
                            border = BorderStroke(1.2.dp, brandBtnBorderColor),
                            modifier = Modifier
                                .size(36.dp)
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
                                        imageVector = if (isGeneric) Icons.Default.Science else Icons.Default.Medication,
                                        contentDescription = if (isGeneric) "Generic Mode Active. Tap to switch to Brand" else "Brand Mode Active. Tap to switch to Generic",
                                        tint = when {
                                            isBrand -> Emerald400
                                            isGeneric -> Amber400
                                            else -> Slate400
                                        },
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Text(
                                        text = if (isGeneric) "GENERIC" else "BRAND",
                                        fontSize = 6.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = when {
                                            isBrand -> Emerald400
                                            isGeneric -> Amber400
                                            else -> Slate400
                                        },
                                        letterSpacing = 0.1.sp,
                                        maxLines = 1
                                    )
                                }
                            }
                        }

                        // Medical News & Grounding Live Updates Button
                        val isNewsActive = state.currentScreen == NavigationScreen.MEDICAL_NEWS
                        val newsScale by animateFloatAsState(
                            targetValue = if (isNewsActive) 1.08f else 1f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                            label = "newsScale"
                        )
                        val newsBgColor by animateColorAsState(
                            targetValue = if (isNewsActive) Color(0xFF0369A1).copy(alpha = 0.35f) else NavyPill,
                            label = "newsBg"
                        )
                        Surface(
                            onClick = {
                                if (isNewsActive) {
                                    viewModel.navigateTo(NavigationScreen.SEARCH)
                                } else {
                                    viewModel.navigateTo(NavigationScreen.MEDICAL_NEWS)
                                }
                            },
                            shape = CircleShape,
                            color = newsBgColor,
                            border = BorderStroke(1.2.dp, if (isNewsActive) Color(0xFF38BDF8) else Color(0xFF38BDF8).copy(alpha = 0.5f)),
                            modifier = Modifier
                                .size(36.dp)
                                .scale(newsScale)
                                .testTag("top_medical_news_button")
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.Feed,
                                    contentDescription = "Nepal Medical News",
                                    tint = if (isNewsActive) Color(0xFF38BDF8) else Color(0xFF7DD3FC),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            },
            bottomBar = {
                val navBarBg by animateColorAsState(
                    targetValue = when (state.themeMode) {
                        AppThemeMode.PITCH_BLACK -> Color.Black
                        AppThemeMode.DARK -> Slate900
                        AppThemeMode.LIGHT -> Color.White
                    },
                    label = "navBarBg"
                )
                Surface(
                    color = navBarBg,
                    tonalElevation = 8.dp,
                    shadowElevation = 8.dp,
                    border = BorderStroke(
                        0.8.dp,
                        if (state.themeMode == AppThemeMode.PITCH_BLACK) PitchBlackBorder
                        else MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)
                    )
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
            AnimatedContent(
                targetState = state.currentScreen,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(220, easing = FastOutSlowInEasing)) +
                     scaleIn(initialScale = 0.98f, animationSpec = tween(220, easing = FastOutSlowInEasing)))
                        .togetherWith(
                            fadeOut(animationSpec = tween(150, easing = FastOutLinearInEasing))
                        )
                },
                label = "ScreenSwitchTransition"
            ) { currentScreen ->
                when (currentScreen) {
                    NavigationScreen.SEARCH -> DrugSearchScreen(
                        searchQuery = state.searchQuery,
                        searchMode = state.searchMode,
                        activeFilter = state.activeFilter,
                        selectedSystemFilter = state.selectedSystemFilter,
                        filteredDrugs = state.filteredDrugs,
                        filteredProtocols = state.filteredProtocols,
                        filteredCalculators = state.filteredCalculators,
                        globalSearchTab = state.globalSearchTab,
                        bookmarkedDrugIds = state.bookmarkedDrugIds,
                        recentSearches = state.recentSearches,
                        onSearchChange = { viewModel.updateSearchQuery(it) },
                        onSearchSubmit = { viewModel.addRecentSearch(it) },
                        onSearchModeChange = { viewModel.setSearchMode(it) },
                        onGlobalSearchTabChange = { viewModel.setGlobalSearchTab(it) },
                        onFilterChange = { viewModel.setFilter(it) },
                        onClearSystemFilter = { viewModel.filterBySystem("All Systems") },
                        onDrugClick = { viewModel.openDrug(it) },
                        onProtocolClick = { viewModel.openProtocolFromSearch(it) },
                        onCalculatorClick = { viewModel.openCalculatorFromSearch(it.id, it.title) },
                        onBookmarkToggle = { viewModel.toggleBookmark(it) },
                        onOpenPharmacologyReview = { viewModel.navigateTo(NavigationScreen.PHARMACOLOGY_GUIDE) },
                        onOpenIndicationDirectory = {
                            viewModel.closeProtocol()
                            viewModel.navigateTo(NavigationScreen.DISEASE)
                        },
                        onOpenInteractionChecker = {
                            viewModel.navigateTo(NavigationScreen.INTERACTION)
                        },
                        onOpenMedicalNews = {
                            viewModel.navigateTo(NavigationScreen.MEDICAL_NEWS)
                        }
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

                    NavigationScreen.SAVED -> SavedScreen(
                        state = state,
                        viewModel = viewModel
                    )

                    NavigationScreen.PHARMACOLOGY_GUIDE -> PharmacologyReviewScreen(
                        bookmarkedGuideIds = state.bookmarkedGuideIds,
                        onBookmarkToggle = { viewModel.toggleBookmarkGuide(it) }
                    )

                    NavigationScreen.DISEASE -> DiseaseProtocolsScreen(
                        selectedProtocol = state.selectedProtocol,
                        bookmarkedProtocolIds = state.bookmarkedProtocolIds,
                        onBookmarkToggle = { viewModel.toggleBookmarkProtocol(it) },
                        onProtocolClick = { protocol ->
                            viewModel.openProtocol(protocol)
                            viewModel.addRecentSearch(protocol.name)
                        },
                        onBackToList = { viewModel.closeProtocol() },
                        onDrugClickByName = { viewModel.openDrugByName(it) },
                        onConsultAiForIndication = { viewModel.consultAiForIndication(it) },
                        onBackToSearch = { viewModel.navigateTo(NavigationScreen.SEARCH) }
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

                    NavigationScreen.MEDICAL_NEWS -> MedicalNewsScreen(
                        state = state,
                        viewModel = viewModel,
                        onBackToHome = { viewModel.navigateTo(NavigationScreen.SEARCH) }
                    )
                }
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
                    onCheckInteractions = { selected -> viewModel.openInteractionWithDrug(selected.id) },
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
        themeMode = state.themeMode,
        onThemeChange = { viewModel.setThemeMode(it) },
        onClose = { viewModel.closeSidebar() },
        onSignInClick = {
            viewModel.closeSidebar()
            viewModel.openLoginDialog()
        },
        onCompaniesClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.COMPANIES)
        },
        onMedicalNewsClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.MEDICAL_NEWS)
        },
        onDrugsByIndicationClick = {
            viewModel.closeSidebar()
            viewModel.closeProtocol()
            viewModel.navigateTo(NavigationScreen.DISEASE)
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
        onSavedClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.SAVED)
        },
        onPharmacologyClick = {
            viewModel.closeSidebar()
            viewModel.navigateTo(NavigationScreen.PHARMACOLOGY_GUIDE)
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
