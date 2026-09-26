package com.example.ui.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.DiseaseProtocol
import com.example.data.model.Drug
import com.example.data.repository.ClinicalRepository
import com.example.data.repository.IndicationDirectoryData
import com.example.data.repository.IndicationItem
import com.example.ui.components.VoiceSearchButton
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugByIndicationView(
    onDrugClickByName: ((String) -> Unit)? = null,
    onProtocolClick: ((DiseaseProtocol) -> Unit)? = null,
    onConsultAiForIndication: ((String) -> Unit)? = null,
    onBackClick: (() -> Unit)? = null
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedLetter by remember { mutableStateOf<Char?>('A') }
    var selectedCategory by remember { mutableStateOf("All Categories") }
    var selectedIndication by remember { mutableStateOf<IndicationItem?>(null) }

    val alphabet = remember { ('A'..'Z').toList() }

    val categories = remember {
        listOf(
            "All Categories",
            "Infectious Diseases",
            "Cardiovascular",
            "Respiratory",
            "Gastrointestinal",
            "Neurology",
            "Endocrine",
            "Dermatology",
            "Emergency",
            "Ophthalmology",
            "ENT",
            "Musculoskeletal",
            "Oncology",
            "Obstetrics & Gynaecology"
        )
    }

    val filteredIndications = remember(searchQuery, selectedLetter, selectedCategory) {
        val q = searchQuery.trim().lowercase()
        IndicationDirectoryData.allIndications.filter { item ->
            val matchesSearch = if (q.isEmpty()) {
                if (selectedLetter != null) item.letter == selectedLetter else true
            } else {
                item.name.lowercase().contains(q) ||
                item.recommendedDrugs.any { it.lowercase().contains(q) } ||
                item.category.lowercase().contains(q)
            }

            val matchesCategory = if (selectedCategory == "All Categories") true else {
                item.category.contains(selectedCategory, ignoreCase = true)
            }

            matchesSearch && matchesCategory
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Incepta Styled Header Bar (Matching PDF: "Drug by Indication | Sponsor: Incepta")
        Surface(
            color = DimsTealPrimary,
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (onBackClick != null) {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Drug by Indication",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "| Sponsor: Incepta",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = DimsYellowMascot
                            )
                        }
                        Text(
                            text = "A to Z Clinical Diagnostic & Medication Directory",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.82f)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color.White.copy(alpha = 0.18f),
                        border = BorderStroke(0.8.dp, Color.White.copy(alpha = 0.35f))
                    ) {
                        Text(
                            text = "${IndicationDirectoryData.allIndications.size} A-Z",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }
        }

        // Search Bar (Matching PDF: "search by indication...")
        Surface(
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 2.dp,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            shape = RoundedCornerShape(14.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                    if (it.isNotEmpty()) selectedLetter = null
                },
                placeholder = {
                    Text(
                        text = "search by indication...",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.65f)
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
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(end = 4.dp)
                    ) {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(
                                onClick = { searchQuery = "" },
                                modifier = Modifier.size(30.dp)
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Clear",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        VoiceSearchButton(
                            onSpokenText = { spoken ->
                                searchQuery = spoken
                                selectedLetter = null
                            },
                            size = 30.dp,
                            idleColor = DimsTealPrimary,
                            activeColor = Red500,
                            testTag = "indication_voice_search_button"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("search_by_indication_input"),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )
        }

        // Alphabet Quick Jump Row (A to Z)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 2.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val isAllSelected = selectedLetter == null && searchQuery.isEmpty()
            Surface(
                onClick = {
                    selectedLetter = null
                    searchQuery = ""
                },
                shape = RoundedCornerShape(8.dp),
                color = if (isAllSelected) DimsTealPrimary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                border = BorderStroke(0.8.dp, if (isAllSelected) DimsTealPrimary else Color.Transparent),
                modifier = Modifier.height(28.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 8.dp)) {
                    Text(
                        text = "ALL",
                        fontSize = 11.sp,
                        fontWeight = if (isAllSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isAllSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            alphabet.forEach { char ->
                val isSelected = selectedLetter == char
                Surface(
                    onClick = {
                        selectedLetter = char
                        searchQuery = ""
                    },
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelected) DimsTealPrimary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    border = BorderStroke(0.8.dp, if (isSelected) DimsTealPrimary else Color.Transparent),
                    modifier = Modifier.size(28.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = char.toString(),
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Category Filter Chips Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 4.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = cat },
                    label = {
                        Text(
                            text = cat,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    shape = RoundedCornerShape(14.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = DimsTealPrimary,
                        selectedLabelColor = Color.White,
                        containerColor = MaterialTheme.colorScheme.surface,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                        enabled = true,
                        selected = isSelected
                    )
                )
            }
        }

        // Result Count Banner
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (selectedLetter != null) "Showing '${selectedLetter}' Indications (${filteredIndications.size})"
                       else if (searchQuery.isNotEmpty()) "Found ${filteredIndications.size} for '$searchQuery'"
                       else "All Indications (${filteredIndications.size})",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Tap any condition for drugs",
                fontSize = 10.5.sp,
                color = DimsTealPrimary,
                fontWeight = FontWeight.Medium
            )
        }

        // Main Indication Cards List (Exact Incepta card style from PDF)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(top = 4.dp, bottom = 80.dp)
        ) {
            if (filteredIndications.isEmpty()) {
                item {
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.SearchOff,
                                contentDescription = null,
                                tint = Slate400,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = "No indications found for '$searchQuery'",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Try searching by disease name, symptom, or select a letter above.",
                                fontSize = 12.sp,
                                color = Slate400
                            )
                        }
                    }
                }
            }

            items(filteredIndications, key = { it.id }) { item ->
                IndicationCard(
                    item = item,
                    onClick = { selectedIndication = item }
                )
            }
        }
    }

    // Modal Sheet for Selected Indication
    if (selectedIndication != null) {
        val indication = selectedIndication!!
        IndicationDetailBottomSheet(
            indication = indication,
            onDismiss = { selectedIndication = null },
            onDrugClickByName = onDrugClickByName,
            onProtocolClick = onProtocolClick,
            onConsultAi = { onConsultAiForIndication?.invoke(indication.name) }
        )
    }
}

@Composable
private fun IndicationCard(
    item: IndicationItem,
    onClick: () -> Unit
) {
    // Incepta card: White surface with green/teal molecule node icon
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
        shadowElevation = 0.8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("indication_item_${item.id}")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Molecule Node Icon (Exact Incepta visual motif from PDF)
            Surface(
                shape = CircleShape,
                color = DimsTealPrimary.copy(alpha = 0.12f),
                modifier = Modifier.size(34.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Hub,
                        contentDescription = null,
                        tint = DimsTealPrimary,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }

            // Indication Details
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.name,
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                    ) {
                        Text(
                            text = item.category,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                        )
                    }

                    if (item.recommendedDrugs.isNotEmpty()) {
                        Text(
                            text = "${item.recommendedDrugs.size} drugs",
                            fontSize = 10.5.sp,
                            color = DimsTealPrimary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "View Indicated Drugs",
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun IndicationDetailBottomSheet(
    indication: IndicationItem,
    onDismiss: () -> Unit,
    onDrugClickByName: ((String) -> Unit)?,
    onProtocolClick: ((DiseaseProtocol) -> Unit)?,
    onConsultAi: () -> Unit
) {
    // Check if there is a matching disease protocol in ClinicalRepository
    val matchingProtocol = remember(indication.name) {
        val q = indication.name.lowercase()
        ClinicalRepository.diseaseProtocols.find { proto ->
            proto.name.lowercase().contains(q) ||
            q.contains(proto.name.lowercase()) ||
            proto.keyDrugs.any { drug -> indication.recommendedDrugs.any { it.contains(drug, ignoreCase = true) } }
        }
    }

    // Match indicated drugs with actual Drug objects in ClinicalRepository
    val formularyMatches = remember(indication.recommendedDrugs) {
        indication.recommendedDrugs.map { drugName ->
            val cleanName = drugName.split(" ").first().lowercase()
            val matchedDrug = ClinicalRepository.drugs.find { drug ->
                drug.genericName.lowercase().contains(cleanName) ||
                cleanName.contains(drug.genericName.lowercase().split(" ").first())
            }
            Pair(drugName, matchedDrug)
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = indication.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Category: ${indication.category}",
                        fontSize = 12.sp,
                        color = DimsTealPrimary,
                        fontWeight = FontWeight.Medium
                    )
                }

                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }

            // Clinical Note / Pearl
            if (indication.clinicalNote.isNotEmpty()) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = DimsTealLight,
                    border = BorderStroke(1.dp, DimsTealBorder)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = DimsTealPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                        Column {
                            Text(
                                text = "Clinical Pearl & Guidance",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = DimsTealDark
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = indication.clinicalNote,
                                fontSize = 12.sp,
                                color = DimsTealDark,
                                lineHeight = 17.sp
                            )
                        }
                    }
                }
            }

            // Indicated Drugs Section
            Text(
                text = "Indicated Medications & Formulations",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                formularyMatches.forEach { (drugName, matchedDrug) ->
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = drugName,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                if (matchedDrug != null) {
                                    Text(
                                        text = "${matchedDrug.drugClass} • ${matchedDrug.system}",
                                        fontSize = 10.5.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    val nepBrands = matchedDrug.brandsNepal.take(2).joinToString(", ") { it.name }
                                    if (nepBrands.isNotEmpty()) {
                                        Text(
                                            text = "Nepal Brands: $nepBrands",
                                            fontSize = 10.sp,
                                            color = DimsTealPrimary,
                                            fontWeight = FontWeight.Medium
                                        )
                                    }
                                } else {
                                    Text(
                                        text = "Guideline recommended agent",
                                        fontSize = 10.5.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                                    )
                                }
                            }

                            if (matchedDrug != null) {
                                Button(
                                    onClick = {
                                        onDismiss()
                                        onDrugClickByName?.invoke(matchedDrug.genericName)
                                    },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = DimsTealPrimary),
                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                    modifier = Modifier.height(32.dp)
                                ) {
                                    Text("Monograph", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            // Action Buttons (Treatment Protocol & Gemini AI Consult)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (matchingProtocol != null) {
                    OutlinedButton(
                        onClick = {
                            onDismiss()
                            onProtocolClick?.invoke(matchingProtocol)
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f),
                        border = BorderStroke(1.2.dp, DimsTealPrimary)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = null, tint = DimsTealPrimary, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Full Protocol", fontSize = 11.5.sp, color = DimsTealPrimary, fontWeight = FontWeight.Bold)
                    }
                }

                Button(
                    onClick = {
                        onDismiss()
                        onConsultAi()
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SparkleViolet),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = Color.Black, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("AI Guidelines", fontSize = 11.5.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
