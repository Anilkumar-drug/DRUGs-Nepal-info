package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Antidote
import com.example.data.repository.ClinicalRepository
import com.example.ui.theme.*

private enum class ToxicologyTab(val label: String) {
    ANTIDOTES("💊 Antidote Index"),
    RURAL_PROTOCOLS("🚨 Rural Ingestions (Nepal)")
}

@Composable
fun AntidoteToxicologyScreen(
    onAntidoteClick: ((Antidote) -> Unit)? = null,
    onOpenCriticalCare: (() -> Unit)? = null
) {
    var selectedTab by remember { mutableStateOf(ToxicologyTab.ANTIDOTES) }
    var searchQuery by remember { mutableStateOf("") }

    val antidotes = remember(searchQuery) {
        val q = searchQuery.trim().lowercase()
        if (q.isEmpty()) ClinicalRepository.antidotes
        else ClinicalRepository.antidotes.filter {
            it.poison.lowercase().contains(q) ||
            it.antidote.lowercase().contains(q) ||
            it.dosing.lowercase().contains(q)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Red Emergency Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Red950.copy(alpha = 0.5f),
            border = BorderStroke(1.5.dp, Red500.copy(alpha = 0.6f))
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = null,
                    tint = Red400,
                    modifier = Modifier.size(28.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Emergency Toxicology & Rural Ingestions",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black,
                        color = Red400
                    )
                    Text(
                        text = "Point-of-care resuscitation, Atropinization endpoints, Celphos & OP protocols per WHO & Nepal National Guidelines.",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = Color(0xFFFCA5A5)
                    )
                }

                if (onOpenCriticalCare != null) {
                    FilledTonalButton(
                        onClick = onOpenCriticalCare,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = Red600,
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                        modifier = Modifier.height(30.dp)
                    ) {
                        Icon(Icons.Default.Bolt, contentDescription = null, modifier = Modifier.size(13.dp))
                        Spacer(modifier = Modifier.width(3.dp))
                        Text("ER/ICU", fontSize = 11.sp, fontWeight = FontWeight.Black)
                    }
                }
            }
        }

        // Tabs Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ToxicologyTab.values().forEach { tab ->
                val isSelected = selectedTab == tab
                Surface(
                    onClick = { selectedTab = tab },
                    shape = RoundedCornerShape(10.dp),
                    color = if (isSelected) Red500.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.2.dp, if (isSelected) Red400 else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(vertical = 10.dp)
                    ) {
                        Text(
                            text = tab.label,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Red400 else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        if (selectedTab == ToxicologyTab.ANTIDOTES) {
            // Search
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search poison, toxin, or antidote...") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("antidote_search_input"),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )

            // Antidote List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(antidotes, key = { it.id }) { antidote ->
                    AntidoteCard(
                        item = antidote,
                        onClick = { onAntidoteClick?.invoke(antidote) }
                    )
                }
            }
        } else {
            // Rural Ingestions Protocols (Nepal Focus)
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(bottom = 88.dp)
            ) {
                item {
                    OrganophosphateProtocolCard()
                }
                item {
                    AluminumPhosphideProtocolCard()
                }
                item {
                    ZincPhosphideProtocolCard()
                }
                item {
                    AmatoxinMushroomProtocolCard()
                }
            }
        }
    }
}

@Composable
private fun OrganophosphateProtocolCard() {
    var expanded by remember { mutableStateOf(true) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.2.dp, Color(0xFFEF4444).copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(shape = CircleShape, color = Color(0xFFEF4444).copy(alpha = 0.2f), modifier = Modifier.size(32.dp)) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("1", fontWeight = FontWeight.Black, color = Color(0xFFEF4444))
                        }
                    }
                    Column {
                        Text(
                            text = "Organophosphate & Carbamate Protocol",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFFEF4444)
                        )
                        Text(
                            text = "Objective Atropinization Checklist & Pralidoxime (PAM)",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))

                    // Step 1: Decontamination & Airway
                    Text(
                        text = "1. Immediate Decontamination & Airway",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Strip all contaminated clothing immediately into sealed biohazard bag.\n• Wash skin, hair, and eyes copiously with soap and water (prevent dermal absorption).\n• High-flow oxygen; clear copious airway secretions before atropine.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    // Step 2: Atropinization Protocol
                    Text(
                        text = "2. Atropine Loading & Titration Protocol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Initial Dose: 2 to 5 mg IV bolus (Pediatric: 0.05 mg/kg).\n• If no response within 5 minutes, DOUBLE THE DOSE (e.g., 2mg -> 4mg -> 8mg -> 16mg) every 5-10 minutes until ALL 5 Atropinization Endpoints are achieved.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    // Objective Checklist Box
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFF047857).copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "🎯 OBJECTIVE ATROPINIZATION ENDPOINTS (Must Meet All 5):",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF059669)
                            )
                            listOf(
                                "1. Chest clear of bronchospasm & rhonchi (SpO2 > 90% without wet crackles)",
                                "2. Heart rate > 80 bpm",
                                "3. Systolic blood pressure > 80 mmHg",
                                "4. Axillae dry (absence of diaphoresis / sweating)",
                                "5. Pupils dilated or normal (Pupils are the LEAST reliable sign!)"
                            ).forEach { item ->
                                Text("✅ $item", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurface)
                            }
                        }
                    }

                    // Step 3: Maintenance & PAM
                    Text(
                        text = "3. Maintenance Infusion & Pralidoxime (2-PAM)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Atropine Maintenance: Infuse 10% to 20% of the total cumulative dose required to achieve atropinization per hour in Normal Saline.\n• Pralidoxime (PAM): 1-2 g IV in 100 mL NS over 30 min, then 8 mg/kg/hr continuous infusion x 24-48 hours. Reactivates nicotinic receptors, reversing skeletal muscle paralysis.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun AluminumPhosphideProtocolCard() {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.2.dp, Color(0xFFD97706).copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(shape = CircleShape, color = Color(0xFFD97706).copy(alpha = 0.2f), modifier = Modifier.size(32.dp)) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("2", fontWeight = FontWeight.Black, color = Color(0xFFD97706))
                        }
                    }
                    Column {
                        Text(
                            text = "Aluminum Phosphide (Celphos / Rice Tablet)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFFD97706)
                        )
                        Text(
                            text = "Phosphine gas toxicity, Coconut oil lavage, MgSO4 infusion",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))

                    // Red Alert
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF7F1D1D).copy(alpha = 0.35f),
                        border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "⚠️ CRITICAL WARNING: NEVER perform gastric lavage with plain water or normal saline! Water and stomach acid accelerate toxic phosphine (PH3) gas liberation, causing rapid cardiogenic shock and fatal cardiac arrhythmias.",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFCA5A5),
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    Text(
                        text = "1. Immediate Gastric Lavage with Vegetable / Coconut Oil",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Instill 100 to 150 mL of pure Coconut Oil or liquid paraffin via NG tube immediately upon arrival.\n• Oil coats the stomach mucosa, dissolves non-toxic phosphide remnants, and retards phosphine gas liberation.\n• Aspirate and re-instill 50 mL oil to leave in stomach.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "2. Membrane Stabilization & Acidosis Correction",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• IV Magnesium Sulfate (antiarrhythmic and free-radical scavenger): 3 g in 100 mL D5W over 30 minutes loading, followed by 1 g/hour continuous infusion for 24-48 hours.\n• Sodium Bicarbonate (8.4%): 1-2 mEq/kg IV push for severe metabolic acidosis.\n• N-Acetylcysteine (NAC) Infusion: 150 mg/kg loading over 1h, then 50 mg/kg over 4h, then 100 mg/kg over 16h to combat severe oxidative myocardial injury.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun ZincPhosphideProtocolCard() {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.2.dp, Color(0xFF6B7280).copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(shape = CircleShape, color = Color(0xFF6B7280).copy(alpha = 0.2f), modifier = Modifier.size(32.dp)) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("3", fontWeight = FontWeight.Black, color = Color(0xFF6B7280))
                        }
                    }
                    Column {
                        Text(
                            text = "Zinc Phosphide (Black Rat Poison)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Garlic odor, KMnO4 1:5000 lavage, PPI gastric acid suppression",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))

                    Text(
                        text = "1. Clinical Presentation & Odor",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Characteristic rotten fish / pungent garlic breath.\n• Severe epigastric burn, intractable vomiting, and hematemesis within 1-2 hours of ingestion.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "2. Specific Gastric Lavage & Oxidation",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Gastric Lavage with Potassium Permanganate (KMnO4 1:5000 solution) or 2-3% Sodium Bicarbonate: Oxidizes phosphide to harmless phosphate salts.\n• High-Dose IV Pantoprazole 80 mg bolus + 8 mg/hr infusion to suppress gastric HCl acid secretion and decrease phosphine gas evolution.\n• Oral Activated Charcoal (1 g/kg) and mineral oil.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun AmatoxinMushroomProtocolCard() {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.2.dp, Color(0xFF8B5CF6).copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(shape = CircleShape, color = Color(0xFF8B5CF6).copy(alpha = 0.2f), modifier = Modifier.size(32.dp)) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("4", fontWeight = FontWeight.Black, color = Color(0xFF8B5CF6))
                        }
                    }
                    Column {
                        Text(
                            text = "Amatoxin / Wild Mushroom Poisoning",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFF8B5CF6)
                        )
                        Text(
                            text = "Delayed hepatic necrosis (Amanita), IV NAC & Silibinin",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))

                    Text(
                        text = "1. Diagnostic Timeline (The Deadly Delay)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• Early symptoms (<6 hours) usually indicate benign GI upset.\n• DELAYED symptoms (6 to 24 hours post-ingestion) of severe cholera-like watery diarrhea and vomiting herald Amatoxin ingestion (Amanita phalloides / bisporigera).\n• Followed by deceptive 'quiescent phase' (Day 2) before massive hepatic necrosis and fulminant liver failure (Day 3-5).",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "2. Specific Hepatoprotective Protocol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "• High-Dose IV N-Acetylcysteine (NAC): Follow full 21-hour Paracetamol protocol (150 mg/kg, 50 mg/kg, 100 mg/kg) and continue until AST/ALT and INR normalize.\n• IV Silibinin (Legalon SIL) 20-50 mg/kg/day or IV Penicillin G (300,000 to 1,000,000 units/kg/day): Competitively blocks amatoxin penetration into hepatocytes via OATP1B3 transporters.\n• Multiple-Dose Activated Charcoal (50g q4h) to interrupt enterohepatic recirculation of amatoxins.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun AntidoteCard(
    item: Antidote,
    onClick: (() -> Unit)? = null
) {
    Card(
        onClick = { onClick?.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .testTag("antidote_card_${item.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Poison Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Red500.copy(alpha = 0.2f)
                    ) {
                        Text(
                            text = "TOXIN",
                            color = Red400,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Text(
                        text = item.poison,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Red400
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Red950.copy(alpha = 0.6f),
                    border = BorderStroke(1.dp, Red500.copy(alpha = 0.4f))
                ) {
                    Text(
                        text = item.urgency,
                        color = Color(0xFFFCA5A5),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))

            // Specific Antidote
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Emerald950.copy(alpha = 0.35f),
                border = BorderStroke(1.dp, Emerald500.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Emerald400,
                        modifier = Modifier.size(18.dp)
                    )
                    Column {
                        Text(
                            text = "Specific Antidote:",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = item.antidote,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Emerald400
                        )
                    }
                }
            }

            // Dosing Protocol
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "Dosing & Administration Protocol:",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = item.dosing,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 18.sp
                )
            }

            // Clinical Pearls & Cautions
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Amber400,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = item.notes,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}
