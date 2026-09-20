package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.ClinicalRepository
import com.example.ui.theme.*

data class SystemItem(
    val name: String,
    val icon: ImageVector,
    val accentColor: Color,
    val description: String
)

@Composable
fun SystemBrowseScreen(
    onSystemSelected: (String) -> Unit
) {
    val systemItems = listOf(
        SystemItem(
            name = "Anti-Infectives & Antimicrobials",
            icon = Icons.Default.Shield,
            accentColor = Emerald500,
            description = "Antibiotics, Antivirals, Antifungals"
        ),
        SystemItem(
            name = "Cardiovascular System (CVS)",
            icon = Icons.Default.Favorite,
            accentColor = Red500,
            description = "Antihypertensives, Statins, Antiarrhythmics"
        ),
        SystemItem(
            name = "Endocrine & Metabolic System",
            icon = Icons.Default.WaterDrop,
            accentColor = Amber500,
            description = "Oral Hypoglycemics, Insulin, Thyroid"
        ),
        SystemItem(
            name = "Respiratory System (RS)",
            icon = Icons.Default.Air,
            accentColor = MedicalBlue500,
            description = "Bronchodilators, Inhalers, Mucolytics"
        ),
        SystemItem(
            name = "Gastrointestinal & Hepatobiliary",
            icon = Icons.Default.LocalHospital,
            accentColor = Indigo400,
            description = "PPIs, Antiemetics, Laxatives, Hepatic"
        ),
        SystemItem(
            name = "Central Nervous System (CNS)",
            icon = Icons.Default.Psychology,
            accentColor = Color(0xFFA855F7),
            description = "Analgesics, Antiepileptics, Sedatives"
        ),
        SystemItem(
            name = "Musculoskeletal & Analgesics",
            icon = Icons.Default.FitnessCenter,
            accentColor = Color(0xFFF97316),
            description = "NSAIDs, Antipyretics, Muscle Relaxants"
        ),
        SystemItem(
            name = "Renal & Genitourinary",
            icon = Icons.Default.Science,
            accentColor = Color(0xFF06B6D4),
            description = "Diuretics, UTI Agents, BPH Therapy"
        ),
        SystemItem(
            name = "Emergency & Critical Care",
            icon = Icons.Default.Emergency,
            accentColor = Red600,
            description = "Vasopressors, Resuscitation, Antidotes"
        ),
        SystemItem(
            name = "Dermatology",
            icon = Icons.Default.Spa,
            accentColor = Color(0xFFEC4899),
            description = "Topical Steroids, Antifungals, Retinoids"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column {
            Text(
                text = "Browse by Organ System",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Select a anatomical or functional system to filter medications",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(systemItems) { item ->
                val drugCount = ClinicalRepository.drugs.count {
                    it.system.contains(item.name.split(" ").first(), ignoreCase = true)
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(135.dp)
                        .clickable { onSystemSelected(item.name) }
                        .testTag("system_card_${item.name.replace(" ", "_")}"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = item.accentColor.copy(alpha = 0.15f),
                                modifier = Modifier.size(36.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = null,
                                        tint = item.accentColor,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                Text(
                                    text = "$drugCount drugs",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 2,
                                lineHeight = 16.sp
                            )
                            Text(
                                text = item.description,
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    }
}
