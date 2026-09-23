package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
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
import com.example.data.model.DiseaseProtocol
import com.example.data.repository.ClinicalRepository
import com.example.ui.components.VoiceSearchButton
import com.example.ui.theme.*

@Composable
fun DiseaseProtocolsScreen(
    onProtocolClick: ((DiseaseProtocol) -> Unit)? = null
) {
    var searchQuery by remember { mutableStateOf("") }

    val protocols = remember(searchQuery) {
        val q = searchQuery.trim().lowercase()
        if (q.isEmpty()) ClinicalRepository.diseaseProtocols
        else ClinicalRepository.diseaseProtocols.filter {
            it.name.lowercase().contains(q) ||
            it.category.lowercase().contains(q) ||
            it.firstLine.lowercase().contains(q) ||
            it.secondLine.lowercase().contains(q)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Amber500.copy(alpha = 0.12f),
            border = androidx.compose.foundation.BorderStroke(1.dp, Amber500.copy(alpha = 0.35f))
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.MenuBook,
                    contentDescription = null,
                    tint = Amber500,
                    modifier = Modifier.size(24.dp)
                )
                Column {
                    Text(
                        text = "Evidence-Based Clinical Protocols",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Amber500
                    )
                    Text(
                        text = "Referenced from WHO Essential Medicines, Harrison's 21st Ed, and ATS/IDSA Guidelines.",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search disease or clinical condition...") },
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
                        onSpokenText = { spoken ->
                            searchQuery = spoken
                        },
                        size = 32.dp,
                        idleColor = Amber500,
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
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            singleLine = true
        )

        // Protocol List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(protocols, key = { it.id }) { item ->
                ProtocolCard(
                    protocol = item,
                    onClick = { onProtocolClick?.invoke(item) }
                )
            }
        }
    }
}

@Composable
private fun ProtocolCard(
    protocol: DiseaseProtocol,
    onClick: (() -> Unit)? = null
) {
    Card(
        onClick = { onClick?.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .testTag("protocol_card_${protocol.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = protocol.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Amber400,
                    modifier = Modifier.weight(1f)
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Amber950.copy(alpha = 0.5f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Amber500.copy(alpha = 0.4f))
                ) {
                    Text(
                        text = protocol.category,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Amber400,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))

            // First-line Regimen
            SectionBlock(
                label = "First-line Regimen:",
                text = protocol.firstLine,
                labelColor = Emerald400,
                bgColor = Emerald950.copy(alpha = 0.3f),
                borderColor = Emerald600.copy(alpha = 0.3f)
            )

            // Second-line Alternative
            SectionBlock(
                label = "Second-line Alternative:",
                text = protocol.secondLine,
                labelColor = MedicalBlue400,
                bgColor = MedicalBlue900.copy(alpha = 0.3f),
                borderColor = MedicalBlue600.copy(alpha = 0.3f)
            )

            // Inpatient / ICU Management
            SectionBlock(
                label = "Inpatient / Hospital Management:",
                text = protocol.inpatient,
                labelColor = Color(0xFFA855F7),
                bgColor = Color(0xFF3B0764).copy(alpha = 0.3f),
                borderColor = Color(0xFFA855F7).copy(alpha = 0.3f)
            )

            // Reference footer
            Text(
                text = "Ref: ${protocol.guidelines}",
                style = MaterialTheme.typography.bodySmall,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun SectionBlock(
    label: String,
    text: String,
    labelColor: Color,
    bgColor: Color,
    borderColor: Color
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = bgColor,
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = labelColor
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 17.sp
            )
        }
    }
}
