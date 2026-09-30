package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AwareClassification
import com.example.data.model.LocalResistancePattern
import com.example.data.model.SyndromicRegimen
import com.example.data.model.WhoAwareDrug
import com.example.data.repository.AntimicrobialStewardshipData
import com.example.ui.theme.*

private enum class StewardshipTab(val label: String) {
    SYNDROMIC("📋 Syndromic Regimens"),
    AWARE("🛡️ WHO AWaRe Guide"),
    RESISTANCE("🧬 Local Antibiograms (Nepal)")
}

@Composable
fun AntimicrobialStewardshipScreen(
    onBackClick: () -> Unit,
    onConsultAi: (String) -> Unit
) {
    var selectedTab by remember { mutableStateOf(StewardshipTab.SYNDROMIC) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedSyndromeCategory by remember { mutableStateOf("All") }

    val categories = remember {
        listOf("All", "Respiratory", "CNS", "Tropical / Vector-Borne", "Gastrointestinal", "Genitourinary", "Sepsis & Critical Care", "SSTI")
    }

    val filteredSyndromes = remember(searchQuery, selectedSyndromeCategory) {
        val q = searchQuery.trim().lowercase()
        AntimicrobialStewardshipData.syndromicRegimens.filter { item ->
            val matchesCat = selectedSyndromeCategory == "All" || item.category.contains(selectedSyndromeCategory, ignoreCase = true)
            val matchesQuery = q.isEmpty() ||
                    item.syndrome.lowercase().contains(q) ||
                    item.preferredFirstLine.lowercase().contains(q) ||
                    item.commonPathogens.lowercase().contains(q)
            matchesCat && matchesQuery
        }
    }

    val filteredAwareDrugs = remember(searchQuery) {
        val q = searchQuery.trim().lowercase()
        if (q.isEmpty()) AntimicrobialStewardshipData.whoAwareDrugs
        else AntimicrobialStewardshipData.whoAwareDrugs.filter {
            it.genericName.lowercase().contains(q) ||
            it.keyIndications.lowercase().contains(q) ||
            it.stewardshipGuidance.lowercase().contains(q)
        }
    }

    Scaffold(
        topBar = {
            Surface(
                color = NavyDeep,
                border = BorderStroke(1.dp, NavyCardBorder)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            IconButton(onClick = onBackClick) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                            }
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text(
                                        text = "Antimicrobial Stewardship",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 17.sp,
                                        color = Color.White
                                    )
                                    Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF10B981).copy(alpha = 0.2f)) {
                                        Text(
                                            text = "WHO AWaRe",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(0xFF34D399),
                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = "Empiric protocols, resistance patterns & stewardship guidelines",
                                    fontSize = 11.sp,
                                    color = Slate400
                                )
                            }
                        }

                        IconButton(onClick = { onConsultAi("Explain antimicrobial stewardship guidelines for hospital-acquired vs community-acquired infections.") }) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = "AI Stewardship Consult", tint = SparkleViolet)
                        }
                    }

                    // Tabs
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        StewardshipTab.values().forEach { tab ->
                            val isSel = selectedTab == tab
                            Surface(
                                onClick = { selectedTab = tab },
                                shape = RoundedCornerShape(8.dp),
                                color = if (isSel) DimsTealPrimary.copy(alpha = 0.25f) else Color(0xFF0F172A),
                                border = BorderStroke(1.dp, if (isSel) DimsTealPrimary else Color(0xFF1E293B)),
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 8.dp)) {
                                    Text(
                                        text = tab.label,
                                        fontSize = 10.5.sp,
                                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSel) Color.White else Slate400,
                                        maxLines = 1
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 14.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Search Input
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        when (selectedTab) {
                            StewardshipTab.SYNDROMIC -> "Search syndromic regimen (e.g. CAP, Meningitis, Sepsis)..."
                            StewardshipTab.AWARE -> "Search antibiotic in AWaRe list (e.g. Meropenem, Ceftriaxone)..."
                            StewardshipTab.RESISTANCE -> "Search pathogen or resistance (e.g. ESBL, MRSA)..."
                        }
                    )
                },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Slate400) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("stewardship_search_input"),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )

            when (selectedTab) {
                StewardshipTab.SYNDROMIC -> {
                    // Category Chips
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(categories) { cat ->
                            val isSel = selectedSyndromeCategory == cat
                            Surface(
                                onClick = { selectedSyndromeCategory = cat },
                                shape = RoundedCornerShape(8.dp),
                                color = if (isSel) DimsTealPrimary else MaterialTheme.colorScheme.surface,
                                border = BorderStroke(1.dp, if (isSel) DimsTealPrimary else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                            ) {
                                Text(
                                    text = cat,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSel) Color.White else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }

                    // List of Syndromic Regimens
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(bottom = 80.dp)
                    ) {
                        items(filteredSyndromes.distinctBy { it.id }, key = { it.id }) { regimen ->
                            SyndromicRegimenCard(regimen = regimen, onAskAi = { onConsultAi("Detail empiric protocol for ${regimen.syndrome}") })
                        }
                    }
                }

                StewardshipTab.AWARE -> {
                    // AWaRe Summary Banner
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "WHO AWaRe Classification Framework",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                AwareBadge("🟢 Access: First-line, low resistance risk", Color(0xFF10B981))
                                AwareBadge("🟡 Watch: High resistance potential", Color(0xFFF59E0B))
                                AwareBadge("🔴 Reserve: Last resort only", Color(0xFFEF4444))
                            }
                        }
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(bottom = 80.dp)
                    ) {
                        items(filteredAwareDrugs.distinctBy { it.genericName }, key = { it.genericName }) { drug ->
                            WhoAwareDrugCard(drug = drug)
                        }
                    }
                }

                StewardshipTab.RESISTANCE -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(bottom = 80.dp)
                    ) {
                        items(AntimicrobialStewardshipData.localResistancePatterns.distinctBy { it.pathogen }, key = { it.pathogen }) { pat ->
                            ResistancePatternCard(pattern = pat)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AwareBadge(text: String, color: Color) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = color.copy(alpha = 0.12f),
        border = BorderStroke(0.8.dp, color.copy(alpha = 0.35f))
    ) {
        Text(
            text = text,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            color = color,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
        )
    }
}

@Composable
private fun SyndromicRegimenCard(
    regimen: SyndromicRegimen,
    onAskAi: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Surface(shape = RoundedCornerShape(4.dp), color = DimsTealPrimary.copy(alpha = 0.15f)) {
                        Text(
                            text = "${regimen.category} • ${regimen.setting}",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = DimsTealPrimary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Text(
                        text = regimen.syndrome,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Always show preferred first line
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF047857).copy(alpha = 0.1f),
                border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.35f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "Preferred First-Line Regimen:",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF059669)
                    )
                    Text(
                        text = regimen.preferredFirstLine,
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 16.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    if (regimen.alternativeRegimen.isNotBlank()) {
                        Text(
                            text = "Alternative Regimen:",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = regimen.alternativeRegimen,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 15.sp
                        )
                    }

                    Text(
                        text = "Duration: ${regimen.typicalDuration}",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Amber500
                    )

                    Text(
                        text = "Common Pathogens: ${regimen.commonPathogens}",
                        fontSize = 10.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                                text = "💡 Clinical Pearls & Stewardship Advice:",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = regimen.clinicalPearls,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                lineHeight = 15.sp,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }

                    if (regimen.nepalSpecificNotes.isNotBlank()) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF1E3A8A).copy(alpha = 0.15f),
                            border = BorderStroke(0.8.dp, Color(0xFF3B82F6).copy(alpha = 0.4f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "🇳🇵 Nepal Note: ${regimen.nepalSpecificNotes}",
                                fontSize = 10.5.sp,
                                color = Color(0xFF93C5FD),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = onAskAi) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(14.dp), tint = SparkleViolet)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Consult Copilot", fontSize = 11.sp, color = SparkleViolet)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun WhoAwareDrugCard(drug: WhoAwareDrug) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Color(drug.classification.badgeColorHex).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = drug.genericName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(drug.classification.badgeColorHex).copy(alpha = 0.15f),
                    border = BorderStroke(0.8.dp, Color(drug.classification.badgeColorHex))
                ) {
                    Text(
                        text = drug.classification.label,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(drug.classification.badgeColorHex),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Text(
                text = "Indications: ${drug.keyIndications}",
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Dosage: ${drug.commonDosage}",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Surface(
                shape = RoundedCornerShape(6.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Stewardship Guidance: ${drug.stewardshipGuidance}",
                    fontSize = 10.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
private fun ResistancePatternCard(pattern: LocalResistancePattern) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Color(0xFFDC2626).copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = pattern.pathogen,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFDC2626)
                )
                Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFDC2626).copy(alpha = 0.15f)) {
                    Text(
                        text = pattern.resistanceProfile,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFEF4444),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Text(
                text = "Estimated Prevalence in Nepal: ${pattern.prevalenceEstimate}",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Amber500
            )

            // Effective vs Discouraged
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF047857).copy(alpha = 0.1f),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("✅ Effective Agents:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF10B981))
                        Text(pattern.effectiveAgents, fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurface)
                    }
                }
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF7F1D1D).copy(alpha = 0.1f),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("❌ Discouraged Agents:", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                        Text(pattern.discouragedAgents, fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }

            Text(
                text = "Guidance: ${pattern.localGuidance}",
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 15.sp
            )
        }
    }
}
