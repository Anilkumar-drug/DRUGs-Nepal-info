package com.example.ui.screens

import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.DiseaseProtocol
import com.example.data.repository.ClinicalRepository
import com.example.ui.components.VoiceSearchButton
import com.example.ui.theme.*

@Composable
fun DiseaseProtocolsScreen(
    selectedProtocol: DiseaseProtocol? = null,
    bookmarkedProtocolIds: Set<String> = emptySet(),
    onBookmarkToggle: ((String) -> Unit)? = null,
    onProtocolClick: ((DiseaseProtocol) -> Unit)? = null,
    onBackToList: (() -> Unit)? = null,
    onDrugClickByName: ((String) -> Unit)? = null,
    onConsultAiForIndication: ((String) -> Unit)? = null,
    onBackToSearch: (() -> Unit)? = null
) {
    var activeTab by remember { mutableIntStateOf(0) } // 0 = A-Z Indications (Incepta), 1 = Protocols

    if (selectedProtocol != null) {
        ProtocolDetailScreen(
            protocol = selectedProtocol,
            isBookmarked = bookmarkedProtocolIds.contains(selectedProtocol.id),
            onBookmarkToggle = { onBookmarkToggle?.invoke(selectedProtocol.id) },
            onBackClick = { onBackToList?.invoke() },
            onDrugClickByName = onDrugClickByName
        )
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            // Mode Switcher Tabs
            Surface(
                color = DimsTealDark,
                modifier = Modifier.fillMaxWidth()
            ) {
                TabRow(
                    selectedTabIndex = activeTab,
                    containerColor = DimsTealDark,
                    contentColor = Color.White,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[activeTab]),
                            color = DimsYellowMascot,
                            height = 3.dp
                        )
                    }
                ) {
                    Tab(
                        selected = activeTab == 0,
                        onClick = { activeTab = 0 },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Hub,
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp),
                                    tint = if (activeTab == 0) DimsYellowMascot else Color.White.copy(alpha = 0.7f)
                                )
                                Text(
                                    text = "A-Z Indications",
                                    fontWeight = if (activeTab == 0) FontWeight.Bold else FontWeight.Medium,
                                    color = if (activeTab == 0) DimsYellowMascot else Color.White.copy(alpha = 0.7f),
                                    fontSize = 12.5.sp
                                )
                            }
                        }
                    )
                    Tab(
                        selected = activeTab == 1,
                        onClick = { activeTab = 1 },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.MenuBook,
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp),
                                    tint = if (activeTab == 1) DimsYellowMascot else Color.White.copy(alpha = 0.7f)
                                )
                                Text(
                                    text = "Clinical Protocols",
                                    fontWeight = if (activeTab == 1) FontWeight.Bold else FontWeight.Medium,
                                    color = if (activeTab == 1) DimsYellowMascot else Color.White.copy(alpha = 0.7f),
                                    fontSize = 12.5.sp
                                )
                            }
                        }
                    )
                }
            }

            if (activeTab == 0) {
                DrugByIndicationView(
                    onDrugClickByName = onDrugClickByName,
                    onProtocolClick = onProtocolClick,
                    onConsultAiForIndication = onConsultAiForIndication,
                    onBackClick = onBackToSearch
                )
            } else {
                ProtocolListScreen(
                    bookmarkedProtocolIds = bookmarkedProtocolIds,
                    onBookmarkToggle = onBookmarkToggle,
                    onProtocolClick = onProtocolClick
                )
            }
        }
    }
}

@Composable
private fun ProtocolListScreen(
    bookmarkedProtocolIds: Set<String>,
    onBookmarkToggle: ((String) -> Unit)?,
    onProtocolClick: ((DiseaseProtocol) -> Unit)?
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All Indications") }

    val categories = remember {
        listOf(
            "All Indications",
            "Respiratory",
            "Infectious Diseases",
            "Cardiovascular",
            "Gastrointestinal",
            "Endocrine & Metabolic",
            "Neurology",
            "Renal & Genitourinary",
            "Emergency & Toxicology",
            "Dermatology",
            "Musculoskeletal"
        )
    }

    val protocols = remember(searchQuery, selectedCategory) {
        val q = searchQuery.trim().lowercase()
        ClinicalRepository.diseaseProtocols.filter { protocol ->
            val matchesCategory = when (selectedCategory) {
                "All Indications" -> true
                "Respiratory" -> protocol.category.contains("Respiratory", ignoreCase = true) || protocol.category.contains("Pulmonary", ignoreCase = true)
                "Infectious Diseases" -> protocol.category.contains("Infectious", ignoreCase = true) || protocol.category.contains("Tuberculosis", ignoreCase = true)
                "Cardiovascular" -> protocol.category.contains("Cardio", ignoreCase = true) || protocol.category.contains("CVS", ignoreCase = true)
                "Gastrointestinal" -> protocol.category.contains("Gastro", ignoreCase = true) || protocol.category.contains("GI", ignoreCase = true)
                "Endocrine & Metabolic" -> protocol.category.contains("Endocrine", ignoreCase = true) || protocol.category.contains("Diabetes", ignoreCase = true)
                "Neurology" -> protocol.category.contains("Neurology", ignoreCase = true) || protocol.category.contains("Nervous", ignoreCase = true)
                "Renal & Genitourinary" -> protocol.category.contains("Renal", ignoreCase = true) || protocol.category.contains("Genitourinary", ignoreCase = true)
                "Emergency & Toxicology" -> protocol.category.contains("Toxicology", ignoreCase = true) || protocol.category.contains("Emergency", ignoreCase = true) || protocol.category.contains("Poison", ignoreCase = true)
                "Dermatology" -> protocol.category.contains("Dermatology", ignoreCase = true) || protocol.category.contains("Skin", ignoreCase = true)
                "Musculoskeletal" -> protocol.category.contains("Musculoskeletal", ignoreCase = true) || protocol.category.contains("Rheum", ignoreCase = true)
                else -> true
            }
            val matchesQuery = if (q.isEmpty()) true else {
                protocol.name.lowercase().contains(q) ||
                protocol.icd10.lowercase().contains(q) ||
                protocol.category.lowercase().contains(q) ||
                protocol.diagnosticCriteria.lowercase().contains(q) ||
                protocol.firstLine.lowercase().contains(q) ||
                protocol.secondLine.lowercase().contains(q) ||
                protocol.guidelines.lowercase().contains(q) ||
                protocol.keyDrugs.any { it.lowercase().contains(q) }
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
        // Banner: 100% Verified Evidence Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF0F2A3F),
            border = BorderStroke(1.2.dp, Color(0xFF0284C7).copy(alpha = 0.45f))
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color(0xFF0284C7).copy(alpha = 0.25f),
                    modifier = Modifier.size(44.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Hub,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Drugs by Indication / Disease",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF38BDF8)
                        )
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Emerald500.copy(alpha = 0.2f),
                            border = BorderStroke(0.8.dp, Emerald400.copy(alpha = 0.5f))
                        ) {
                            Text(
                                text = "100% Verified",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Emerald400,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                        }
                    }
                    Text(
                        text = "Treatment guidelines referenced from Medscape, UpToDate, WHO, CDC & Harrison's Principles of Internal Medicine 21st Ed. Tap any disease to view full treatment protocol.",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 15.sp
                    )
                }
            }
        }

        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search disease, ICD-10, symptom or drug...", fontSize = 13.sp) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            },
            trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = { searchQuery = "" },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Clear", modifier = Modifier.size(18.dp))
                        }
                    }
                    VoiceSearchButton(
                        onSpokenText = { spoken -> searchQuery = spoken },
                        size = 32.dp,
                        idleColor = Color(0xFF38BDF8),
                        activeColor = Red500,
                        testTag = "disease_voice_search_button"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("disease_search_input"),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
            ),
            singleLine = true
        )

        // Specialty Filter Chips Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = cat },
                    label = {
                        Text(
                            text = cat,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    shape = RoundedCornerShape(18.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFF0284C7),
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

        // Protocol Count & Evidence Notice
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${protocols.size} Clinical Indication${if (protocols.size == 1) "" else "s"}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Tap disease card to view details",
                fontSize = 11.sp,
                color = Color(0xFF38BDF8)
            )
        }

        // Protocol List (Clean summary cards)
        if (protocols.isEmpty()) {
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
                            tint = Amber500,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = "No clinical indications found",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Try clearing the search or category filter above.",
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
                items(protocols, key = { it.id }) { item ->
                    val isBookmarked = bookmarkedProtocolIds.contains(item.id)
                    ProtocolSummaryCard(
                        protocol = item,
                        isBookmarked = isBookmarked,
                        onBookmarkToggle = { onBookmarkToggle?.invoke(item.id) },
                        onClick = { onProtocolClick?.invoke(item) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ProtocolSummaryCard(
    protocol: DiseaseProtocol,
    isBookmarked: Boolean,
    onBookmarkToggle: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("protocol_card_${protocol.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
        border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Title, Category & Bookmark
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = protocol.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF0F2A3F),
                            border = BorderStroke(0.8.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
                        ) {
                            Text(
                                text = protocol.category,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF7DD3FC),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        if (protocol.icd10.isNotBlank()) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                            ) {
                                Text(
                                    text = "ICD: ${protocol.icd10}",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }

                IconButton(
                    onClick = onBookmarkToggle,
                    modifier = Modifier
                        .size(36.dp)
                        .testTag("bookmark_protocol_${protocol.id}")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Unbookmark protocol" else "Bookmark protocol",
                        tint = if (isBookmarked) Amber400 else Slate400,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Diagnostic / Clinical Criteria excerpt
            if (protocol.diagnosticCriteria.isNotBlank()) {
                Text(
                    text = protocol.diagnosticCriteria,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Quick summary excerpt (1st line)
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Emerald950.copy(alpha = 0.35f),
                border = BorderStroke(0.8.dp, Emerald500.copy(alpha = 0.3f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "1st Line: ${protocol.firstLine.replace("\n", " ").take(140)}...",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.5.sp,
                        color = Emerald400,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Key drugs chips preview
            if (protocol.keyDrugs.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    protocol.keyDrugs.take(4).forEach { drugName ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                            border = BorderStroke(0.6.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                        ) {
                            Text(
                                text = "💊 $drugName",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            // Guideline tag & Click for details affordance
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Verified,
                        contentDescription = null,
                        tint = Emerald400,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = "Medscape • UpToDate • WHO • Harrison's",
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "View Details",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProtocolDetailScreen(
    protocol: DiseaseProtocol,
    isBookmarked: Boolean,
    onBookmarkToggle: () -> Unit,
    onBackClick: () -> Unit,
    onDrugClickByName: ((String) -> Unit)? = null
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    BackHandler(enabled = true) {
        onBackClick()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Top Navigation Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.testTag("back_to_protocols_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back to list",
                        tint = Color(0xFF38BDF8)
                    )
                }
                Column {
                    Text(
                        text = "Disease Treatment Protocol",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Harrison's • UpToDate • Medscape • WHO",
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                // Copy button
                IconButton(
                    onClick = {
                        val fullSummary = """
                            DISEASE: ${protocol.name} (${protocol.icd10})
                            CATEGORY: ${protocol.category}
                            DIAGNOSIS: ${protocol.diagnosticCriteria}
                            FIRST-LINE: ${protocol.firstLine}
                            SECOND-LINE: ${protocol.secondLine}
                            INPATIENT / ICU: ${protocol.inpatient}
                            SUPPORTIVE CARE: ${protocol.supportiveCare}
                            RED FLAGS: ${protocol.redFlags}
                            GUIDELINES: ${protocol.guidelines}
                        """.trimIndent()
                        clipboardManager.setText(AnnotatedString(fullSummary))
                        Toast.makeText(context, "Treatment protocol copied to clipboard", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(38.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ContentCopy,
                        contentDescription = "Copy Protocol",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Bookmark button
                IconButton(
                    onClick = onBookmarkToggle,
                    modifier = Modifier.size(38.dp)
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Unbookmark" else "Bookmark",
                        tint = if (isBookmarked) Amber400 else Slate400,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }

        // Scrollable Protocol Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header Card
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = NavyCard,
                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF0F2A3F),
                            border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
                        ) {
                            Text(
                                text = protocol.category,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF7DD3FC),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }

                        if (protocol.icd10.isNotBlank()) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Emerald950.copy(alpha = 0.4f),
                                border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.3f))
                            ) {
                                Text(
                                    text = "ICD-10: ${protocol.icd10}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Emerald400,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }

                    Text(
                        text = protocol.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF38BDF8)
                    )

                    // Evidence Trust Badge
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Emerald500.copy(alpha = 0.12f),
                        border = BorderStroke(0.8.dp, Emerald400.copy(alpha = 0.35f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Verified,
                                contentDescription = null,
                                tint = Emerald400,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "100% Evidence-Based Protocol • Medscape, UpToDate, WHO, CDC, Harrison's 21st Ed",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Emerald400
                            )
                        }
                    }
                }
            }

            // 1. Overview & Diagnostic Criteria
            if (protocol.diagnosticCriteria.isNotBlank()) {
                DetailSectionCard(
                    icon = Icons.Default.Biotech,
                    title = "Clinical Overview & Diagnostic Criteria",
                    content = protocol.diagnosticCriteria,
                    titleColor = Color(0xFF38BDF8),
                    bgColor = Color(0xFF0F2A3F).copy(alpha = 0.4f),
                    borderColor = Color(0xFF0284C7).copy(alpha = 0.35f)
                )
            }

            // 2. First-line Regimen
            DetailSectionCard(
                icon = Icons.Default.Medication,
                title = "First-line Medical Regimen (Recommended Initial Therapy)",
                content = protocol.firstLine,
                titleColor = Emerald400,
                bgColor = Emerald950.copy(alpha = 0.3f),
                borderColor = Emerald500.copy(alpha = 0.35f)
            )

            // 3. Second-line Alternative
            DetailSectionCard(
                icon = Icons.Default.SyncAlt,
                title = "Second-line Alternative (Penicillin Allergy / Comorbidities)",
                content = protocol.secondLine,
                titleColor = Amber400,
                bgColor = Amber950.copy(alpha = 0.25f),
                borderColor = Amber500.copy(alpha = 0.3f)
            )

            // 4. Inpatient / Hospital & ICU Management
            DetailSectionCard(
                icon = Icons.Default.LocalHospital,
                title = "Inpatient / Hospital & ICU Escalation Protocols",
                content = protocol.inpatient,
                titleColor = Color(0xFFA855F7),
                bgColor = Color(0xFF3B0764).copy(alpha = 0.3f),
                borderColor = Color(0xFFA855F7).copy(alpha = 0.35f)
            )

            // 5. Key Recommended Drugs (Interactive Monograph Links)
            if (protocol.keyDrugs.isNotEmpty()) {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = NavyCard,
                    border = BorderStroke(1.2.dp, Color(0xFF0284C7).copy(alpha = 0.35f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Medication,
                                contentDescription = null,
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(20.dp)
                            )
                            Column {
                                Text(
                                    text = "Key Medications in this Protocol",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF38BDF8)
                                )
                                Text(
                                    text = "Tap any drug to open complete clinical monograph & brand list",
                                    fontSize = 10.5.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        HorizontalDivider(color = Color(0xFF0284C7).copy(alpha = 0.25f))

                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            protocol.keyDrugs.forEach { drugName ->
                                Surface(
                                    onClick = { onDrugClickByName?.invoke(drugName) },
                                    shape = RoundedCornerShape(10.dp),
                                    color = Color(0xFF0F2A3F),
                                    border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.35f)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Science,
                                                contentDescription = null,
                                                tint = Color(0xFF38BDF8),
                                                modifier = Modifier.size(16.dp)
                                            )
                                            Text(
                                                text = drugName,
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White
                                            )
                                        }
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text(
                                                text = "View Monograph",
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF38BDF8)
                                            )
                                            Icon(
                                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                                contentDescription = null,
                                                tint = Color(0xFF38BDF8),
                                                modifier = Modifier.size(12.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 6. Supportive Care & Non-Pharmacological Management
            if (protocol.supportiveCare.isNotBlank()) {
                DetailSectionCard(
                    icon = Icons.Default.Favorite,
                    title = "Supportive Care & Patient Management",
                    content = protocol.supportiveCare,
                    titleColor = Color(0xFFF43F5E),
                    bgColor = Color(0xFF4C0519).copy(alpha = 0.25f),
                    borderColor = Color(0xFFF43F5E).copy(alpha = 0.35f)
                )
            }

            // 7. Red Flags & Urgent Hospital Admission Criteria
            if (protocol.redFlags.isNotBlank()) {
                DetailSectionCard(
                    icon = Icons.Default.Warning,
                    title = "Red Flags & Urgent Referral Criteria",
                    content = protocol.redFlags,
                    titleColor = Red500,
                    bgColor = Red900.copy(alpha = 0.25f),
                    borderColor = Red500.copy(alpha = 0.35f)
                )
            }

            // 8. Clinical Evidence & References
            DetailSectionCard(
                icon = Icons.AutoMirrored.Filled.MenuBook,
                title = "Evidence-Based References & Guideline Authorities",
                content = if (protocol.references.isNotEmpty()) {
                    protocol.references.joinToString("\n• ", prefix = "• ")
                } else {
                    protocol.guidelines
                },
                titleColor = Amber400,
                bgColor = Amber950.copy(alpha = 0.25f),
                borderColor = Amber500.copy(alpha = 0.3f)
            )

            // Bottom return button
            OutlinedButton(
                onClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xFF38BDF8),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Back to All Indications",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                )
            }
        }
    }
}

@Composable
private fun DetailSectionCard(
    icon: ImageVector,
    title: String,
    content: String,
    titleColor: Color,
    bgColor: Color,
    borderColor: Color
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = bgColor,
        border = BorderStroke(1.2.dp, borderColor),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = titleColor,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )
            }

            HorizontalDivider(color = borderColor.copy(alpha = 0.3f))

            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 21.sp
            )
        }
    }
}
