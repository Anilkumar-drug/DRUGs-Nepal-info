package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.SteroidPotencyClass
import com.example.data.model.TopicalSteroidAgent
import com.example.data.repository.TopicalSteroidLadderData
import com.example.ui.theme.*
import kotlin.math.ceil

enum class SteroidScreenTab(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    LADDER("7-Tier Ladder", Icons.Default.FormatListNumbered),
    BODY_SITES("Body Sites", Icons.Default.AccessibilityNew),
    FTU_CALCULATOR("FTU Calculator", Icons.Default.Calculate),
    NEPAL_ALERTS("Nepal Abuse Alerts", Icons.Default.Warning)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicalSteroidLadderScreen(
    onBackClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(SteroidScreenTab.LADDER) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedClassFilter by remember { mutableStateOf<SteroidPotencyClass?>(null) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "Topical Steroid Ladder",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFFDC2626).copy(alpha = 0.2f),
                                border = BorderStroke(1.dp, Color(0xFFDC2626))
                            ) {
                                Text(
                                    text = "Class I-VII",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFCA5A5),
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Dermatological Potency, FTU Dose & Misuse Alerts",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("topical_steroid_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0F172A)
                )
            )
        },
        containerColor = Color(0xFF080F1E)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Horizontal Tab Bar
            ScrollableTabRow(
                selectedTabIndex = selectedTab.ordinal,
                containerColor = Color(0xFF0F172A),
                contentColor = Color.White,
                edgePadding = 12.dp,
                divider = {}
            ) {
                SteroidScreenTab.values().forEach { tab ->
                    Tab(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (selectedTab == tab) Color(0xFF38BDF8) else Slate400
                                )
                                Text(
                                    text = tab.label,
                                    fontWeight = if (selectedTab == tab) FontWeight.Bold else FontWeight.Normal,
                                    color = if (selectedTab == tab) Color(0xFF38BDF8) else Slate400,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    )
                }
            }

            // Tab Content
            when (selectedTab) {
                SteroidScreenTab.LADDER -> {
                    SteroidLadderTabContent(
                        searchQuery = searchQuery,
                        onSearchChange = { searchQuery = it },
                        selectedClassFilter = selectedClassFilter,
                        onClassFilterSelect = {
                            selectedClassFilter = if (selectedClassFilter == it) null else it
                        }
                    )
                }
                SteroidScreenTab.BODY_SITES -> {
                    BodySitesTabContent()
                }
                SteroidScreenTab.FTU_CALCULATOR -> {
                    FtuCalculatorTabContent()
                }
                SteroidScreenTab.NEPAL_ALERTS -> {
                    NepalAbuseAlertsTabContent()
                }
            }
        }
    }
}

// ==========================================
// 1. STEROID LADDER TAB CONTENT
// ==========================================
@Composable
private fun SteroidLadderTabContent(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    selectedClassFilter: SteroidPotencyClass?,
    onClassFilterSelect: (SteroidPotencyClass) -> Unit
) {
    val filteredAgents = remember(searchQuery, selectedClassFilter) {
        TopicalSteroidLadderData.steroidAgents.filter { agent ->
            val matchesQuery = searchQuery.isBlank() ||
                    agent.genericName.contains(searchQuery, ignoreCase = true) ||
                    agent.formulation.contains(searchQuery, ignoreCase = true) ||
                    agent.commonNepalBrands.any { it.contains(searchQuery, ignoreCase = true) } ||
                    agent.approvedIndications.any { it.contains(searchQuery, ignoreCase = true) }
            val matchesClass = selectedClassFilter == null || agent.potencyClass == selectedClassFilter
            matchesQuery && matchesClass
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search Input Box
        Surface(
            color = Color(0xFF131D31),
            border = BorderStroke(1.dp, Color(0xFF223555)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Slate400,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                androidx.compose.foundation.text.BasicTextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    singleLine = true,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.White,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("steroid_ladder_search_input"),
                    decorationBox = { innerTextField ->
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = "Search generic, Nepal brand (Tenovate, Momate, Betnovate)...",
                                color = Slate400,
                                fontSize = 13.sp
                            )
                        }
                        innerTextField()
                    }
                )
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { onSearchChange("") },
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
            }
        }

        // Potency Filter Chips Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 14.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            FilterChip(
                selected = selectedClassFilter == null,
                onClick = { if (selectedClassFilter != null) onClassFilterSelect(selectedClassFilter) },
                label = { Text("All (19)", fontSize = 12.sp) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF0284C7),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFF1E293B),
                    labelColor = Slate400
                )
            )
            SteroidPotencyClass.values().forEach { pClass ->
                val isSelected = selectedClassFilter == pClass
                FilterChip(
                    selected = isSelected,
                    onClick = { onClassFilterSelect(pClass) },
                    label = {
                        Text(
                            text = "${pClass.romanNumeral} (${pClass.categoryName})",
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(pClass.badgeColorHex),
                        selectedLabelColor = Color.White,
                        containerColor = Color(0xFF1E293B),
                        labelColor = Slate400
                    )
                )
            }
        }

        // Agent List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Text(
                    text = "Showing ${filteredAgents.size} topical formulations sorted by potency",
                    fontSize = 12.sp,
                    color = Slate400,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
            items(filteredAgents, key = { it.id }) { agent ->
                TopicalSteroidCard(agent = agent)
            }
        }
    }
}

@Composable
private fun TopicalSteroidCard(agent: TopicalSteroidAgent) {
    var isExpanded by remember { mutableStateOf(false) }
    val classColor = Color(agent.potencyClass.badgeColorHex)

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF101B2E),
        border = BorderStroke(1.dp, classColor.copy(alpha = 0.4f)),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
            .testTag("steroid_agent_${agent.id}")
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Potency Badge & Formulation
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = classColor.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, classColor)
                ) {
                    Text(
                        text = "${agent.potencyClass.romanNumeral}: ${agent.potencyClass.categoryName.uppercase()}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = classColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFF1E293B)
                ) {
                    Text(
                        text = "${agent.formulation} (${agent.strength})",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF94A3B8),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Generic Name
            Text(
                text = agent.genericName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            // Common Nepal Brands
            Text(
                text = "Brands in Nepal: " + agent.commonNepalBrands.joinToString(", "),
                fontSize = 12.sp,
                color = Color(0xFF38BDF8),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 2.dp)
            )

            // Max Duration Tag
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Timer,
                    contentDescription = null,
                    tint = Amber400,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = agent.maxDurationWeeks,
                    fontSize = 12.sp,
                    color = Amber400,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Expanded Details
            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 10.dp)) {
                    HorizontalDivider(color = Color(0xFF1E293B), modifier = Modifier.padding(vertical = 8.dp))

                    // Permissible vs Contraindicated Sites
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "✅ Permissible Sites",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Emerald400
                            )
                            agent.permissibleBodySites.forEach { site ->
                                Text("• $site", fontSize = 11.sp, color = Color(0xFFE2E8F0))
                            }
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "❌ Strictly Prohibited",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFEF4444)
                            )
                            agent.contraindicatedSites.forEach { site ->
                                Text("• $site", fontSize = 11.sp, color = Color(0xFFFCA5A5))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Indications
                    Text(
                        text = "Approved Clinical Indications:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF94A3B8)
                    )
                    agent.approvedIndications.forEach { ind ->
                        Text("• $ind", fontSize = 11.sp, color = Color(0xFFCBD5E1))
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Clinical Pearls / Notes
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF0B1322),
                        border = BorderStroke(1.dp, Color(0xFF1E293B)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "💡 Prescribing Wisdom:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Amber400
                            )
                            Text(
                                text = agent.clinicalNotes,
                                fontSize = 11.sp,
                                color = Color(0xFFE2E8F0),
                                modifier = Modifier.padding(top = 2.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "⚡ Systemic HPA Axis Risk: " + agent.systemicAbsorptionRisk,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (agent.systemicAbsorptionRisk.contains("Very High")) Color(0xFFEF4444) else Color(0xFF38BDF8)
                            )
                        }
                    }
                }
            }

            // Expand hint indicator
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isExpanded) "Less ▲" else "Details ▼",
                    fontSize = 11.sp,
                    color = Slate400
                )
            }
        }
    }
}

// ==========================================
// 2. BODY SITES SAFETY TAB CONTENT
// ==========================================
@Composable
private fun BodySitesTabContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFF1E293B),
                border = BorderStroke(1.dp, Color(0xFF334155)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Stratified by stratum corneum thickness and absorption coefficients. Eyelids absorb 300x more than the soles of feet.",
                        fontSize = 12.sp,
                        color = Color(0xFFCBD5E1)
                    )
                }
            }
        }

        items(TopicalSteroidLadderData.bodySiteGuidelines) { siteGuide ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF101B2E),
                border = BorderStroke(1.dp, Color(0xFF223555)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = siteGuide.anatomicalArea,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Safe vs Prohibited
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Emerald400.copy(alpha = 0.12f),
                            border = BorderStroke(1.dp, Emerald400),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("✅ Recommended", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Emerald400)
                                Text(
                                    text = siteGuide.recommendedClasses.joinToString(", ") { it.romanNumeral },
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(top = 2.dp)
                                )
                            }
                        }

                        if (siteGuide.prohibitedClasses.isNotEmpty()) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFFEF4444).copy(alpha = 0.12f),
                                border = BorderStroke(1.dp, Color(0xFFEF4444)),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text("❌ Prohibited", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                                    Text(
                                        text = siteGuide.prohibitedClasses.joinToString(", ") { it.romanNumeral },
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFFCA5A5),
                                        modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "⏱️ Max Duration: ${siteGuide.maxTreatmentDuration}",
                        fontSize = 12.sp,
                        color = Amber400,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "✋ Standard Dose: ${siteGuide.defaultFtuAdult} FTU (~${siteGuide.defaultFtuAdult * 0.5}g) per application",
                        fontSize = 12.sp,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = siteGuide.clinicalPearls,
                        fontSize = 12.sp,
                        color = Color(0xFFE2E8F0),
                        lineHeight = 17.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF2D1016),
                        border = BorderStroke(1.dp, Color(0xFF831843)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "⚠️ Risk: ${siteGuide.severeAdverseRisk}",
                            fontSize = 11.sp,
                            color = Color(0xFFF472B6),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

// ==========================================
// 3. FINGERTIP UNIT (FTU) CALCULATOR TAB
// ==========================================
@Composable
private fun FtuCalculatorTabContent() {
    // Map of selected area id to count of applications per session
    val selectedAreas = remember { mutableStateMapOf<String, Int>() }
    var applicationFrequencyPerDay by remember { mutableIntStateOf(2) } // 1 = OD, 2 = BD
    var treatmentDaysText by remember { mutableStateOf("14") }

    val days = treatmentDaysText.toIntOrNull() ?: 14

    // Calculate total FTUs per single application
    val singleApplicationFtu = selectedAreas.entries.sumOf { (id, count) ->
        val area = TopicalSteroidLadderData.ftuAnatomicalAreas.firstOrNull { it.id == id }
        (area?.ftuPerApplication ?: 0.0) * count
    }

    val totalGramsSingle = singleApplicationFtu * 0.5 // 1 FTU = ~0.5g
    val totalGramsCourse = totalGramsSingle * applicationFrequencyPerDay * days

    val tubes15g = if (totalGramsCourse > 0) ceil(totalGramsCourse / 15.0).toInt() else 0
    val tubes20g = if (totalGramsCourse > 0) ceil(totalGramsCourse / 20.0).toInt() else 0
    val tubes30g = if (totalGramsCourse > 0) ceil(totalGramsCourse / 30.0).toInt() else 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Explanatory Banner
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF0F243A),
            border = BorderStroke(1.dp, Color(0xFF0284C7))
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.PanTool,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "The Finger-Tip Unit (FTU) Rule",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Text(
                    text = "1 FTU = Amount of cream or ointment squeezed from a 5mm nozzle tube from the distal skin crease to the tip of an adult index finger (~0.5 grams). 1 FTU covers two adult palm areas (~2% BSA).",
                    fontSize = 12.sp,
                    color = Color(0xFFBAE6FD),
                    modifier = Modifier.padding(top = 4.dp),
                    lineHeight = 16.sp
                )
            }
        }

        // Output Result Card
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = Color(0xFF131D31),
            border = BorderStroke(1.5.dp, if (totalGramsCourse > 50) Color(0xFFDC2626) else Color(0xFF10B981)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Prescription Quantity Calculator",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate400
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column {
                        Text(
                            text = "%.1f g".format(totalGramsCourse),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (totalGramsCourse > 50) Color(0xFFFCA5A5) else Emerald400
                        )
                        Text(
                            text = "Total cream/ointment required for $days days",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "%.1f FTUs / day".format(singleApplicationFtu * applicationFrequencyPerDay),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF38BDF8)
                        )
                        Text(
                            text = "(${applicationFrequencyPerDay}x daily application)",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                }

                if (totalGramsCourse > 50) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF450A0A),
                        border = BorderStroke(1.dp, Color(0xFFDC2626))
                    ) {
                        Text(
                            text = "⚠️ WARNING: Exceeds 50 grams/week! High risk of HPA-axis suppression if using Class I or II potent steroids.",
                            fontSize = 11.sp,
                            color = Color(0xFFFCA5A5),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Tube recommendation row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TubeEstimateChip("15g Tubes", "$tubes15g tubes", Modifier.weight(1f))
                    TubeEstimateChip("20g Tubes", "$tubes20g tubes", Modifier.weight(1f))
                    TubeEstimateChip("30g Tubes", "$tubes30g tubes", Modifier.weight(1f))
                }
            }
        }

        // Frequency & Days Inputs
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF101B2E),
            border = BorderStroke(1.dp, Color(0xFF1E293B)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "Regimen Frequency & Duration",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // OD / BD selector
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Frequency:", fontSize = 11.sp, color = Slate400)
                        Row(modifier = Modifier.padding(top = 4.dp), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            FilterChip(
                                selected = applicationFrequencyPerDay == 1,
                                onClick = { applicationFrequencyPerDay = 1 },
                                label = { Text("OD (1x/day)", fontSize = 11.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = Color(0xFF0284C7),
                                    selectedLabelColor = Color.White
                                )
                            )
                            FilterChip(
                                selected = applicationFrequencyPerDay == 2,
                                onClick = { applicationFrequencyPerDay = 2 },
                                label = { Text("BD (2x/day)", fontSize = 11.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = Color(0xFF0284C7),
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }

                    // Days input
                    Column(modifier = Modifier.weight(0.7f)) {
                        Text("Duration (Days):", fontSize = 11.sp, color = Slate400)
                        OutlinedTextField(
                            value = treatmentDaysText,
                            onValueChange = { treatmentDaysText = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                            singleLine = true,
                            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 13.sp, color = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("ftu_duration_days_input"),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF38BDF8),
                                unfocusedBorderColor = Color(0xFF334155),
                                focusedContainerColor = Color(0xFF0F172A),
                                unfocusedContainerColor = Color(0xFF0F172A)
                            )
                        )
                    }
                }
            }
        }

        // Anatomical Body Areas Selector
        Text(
            text = "Select Affected Anatomical Body Areas:",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        TopicalSteroidLadderData.ftuAnatomicalAreas.forEach { area ->
            val count = selectedAreas[area.id] ?: 0
            val isSelected = count > 0

            Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) Color(0xFF13223A) else Color(0xFF0D1524),
                border = BorderStroke(1.dp, if (isSelected) Color(0xFF0284C7) else Color(0xFF1E293B)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (isSelected) selectedAreas.remove(area.id) else selectedAreas[area.id] = 1
                    }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = area.name,
                            fontSize = 13.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Color(0xFFCBD5E1)
                        )
                        Text(
                            text = "${area.ftuPerApplication} FTU (~${area.gramPerApplication}g) per application",
                            fontSize = 11.sp,
                            color = Color(0xFF38BDF8)
                        )
                    }

                    Checkbox(
                        checked = isSelected,
                        onCheckedChange = { checked ->
                            if (checked) selectedAreas[area.id] = 1 else selectedAreas.remove(area.id)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF0284C7),
                            uncheckedColor = Slate400
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun TubeEstimateChip(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF0F172A),
        border = BorderStroke(1.dp, Color(0xFF334155)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(label, fontSize = 10.sp, color = Slate400)
            Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

// ==========================================
// 4. NEPAL ABUSE & TINEA INCOGNITO TAB
// ==========================================
@Composable
private fun NepalAbuseAlertsTabContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF450A0A),
                border = BorderStroke(1.5.dp, Color(0xFFDC2626)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color(0xFFF87171),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "NEPAL CLINICAL RED ALERT: TOPICAL STEROID MISUSE",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }
                    Text(
                        text = "Topical corticosteroid misuse is an epidemic in Nepal. Over 60% of patients attending dermatology outpatient departments in tertiary hospitals (TUTH, Bir, BPKIHS, Patan) present with complications from steroid abuse dispensed OTC by local medical halls.",
                        fontSize = 12.sp,
                        color = Color(0xFFFECACA),
                        modifier = Modifier.padding(top = 6.dp),
                        lineHeight = 16.sp
                    )
                }
            }
        }

        items(TopicalSteroidLadderData.nepalAbusePearls) { pearl ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF101B2E),
                border = BorderStroke(1.dp, Color(0xFF1E293B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pearl,
                    fontSize = 12.sp,
                    color = Color(0xFFE2E8F0),
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(14.dp)
                )
            }
        }

        item {
            // Treatment of Topical Steroid-Damaged Face Protocol
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF0F243A),
                border = BorderStroke(1.dp, Color(0xFF0284C7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "🛠️ Management of Steroid-Damaged Face (TSDF)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("1. Immediate Abrupt Withdrawal: Counsel patient that rebound flare (burning, intense erythema) will peak at days 5-10.", fontSize = 12.sp, color = Color(0xFFE2E8F0))
                    Text("2. Cold Compresses: Saline or chamomile compresses for burning sensation.", fontSize = 12.sp, color = Color(0xFFE2E8F0))
                    Text("3. Oral Doxycycline: 100 mg BD for 4 to 6 weeks for anti-inflammatory suppression of granulomas and pustules.", fontSize = 12.sp, color = Color(0xFFE2E8F0))
                    Text("4. Calcineurin Inhibitors: Topical Tacrolimus 0.03% or 0.1% ointment once daily to replace steroid action without causing atrophy.", fontSize = 12.sp, color = Color(0xFFE2E8F0))
                    Text("5. Bland Emollients & Sunscreen: Hypoallergenic barrier repair creams (Ceramides).", fontSize = 12.sp, color = Color(0xFFE2E8F0))
                }
            }
        }
    }
}
