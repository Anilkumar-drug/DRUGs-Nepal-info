package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun AntidoteToxicologyScreen(
    onAntidoteClick: ((Antidote) -> Unit)? = null
) {
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
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Red Emergency Banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Red950.copy(alpha = 0.5f),
            border = androidx.compose.foundation.BorderStroke(1.5.dp, Red500.copy(alpha = 0.6f))
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
                Column {
                    Text(
                        text = "Emergency Toxicology & Antidotes",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black,
                        color = Red400
                    )
                    Text(
                        text = "Immediate resuscitation, targeted antidote dosing, and toxicodynamic reversal per WHO Critical Care Guidelines.",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = Color(0xFFFCA5A5)
                    )
                }
            }
        }

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
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
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
                    border = androidx.compose.foundation.BorderStroke(1.dp, Red500.copy(alpha = 0.4f))
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
                border = androidx.compose.foundation.BorderStroke(1.dp, Emerald500.copy(alpha = 0.4f)),
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
