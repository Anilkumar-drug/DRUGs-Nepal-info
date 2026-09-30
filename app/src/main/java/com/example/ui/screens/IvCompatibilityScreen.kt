package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.data.model.IvInfusionGuide
import com.example.data.repository.IvCompatibilityData
import com.example.ui.theme.*

@Composable
fun IvCompatibilityScreen(
    onBackClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredList = remember(searchQuery) {
        val q = searchQuery.trim().lowercase()
        if (q.isEmpty()) IvCompatibilityData.infusions
        else IvCompatibilityData.infusions.filter {
            it.drugName.lowercase().contains(q) ||
            it.primaryIndication.lowercase().contains(q) ||
            it.preferredDiluents.any { d -> d.lowercase().contains(q) } ||
            it.ySiteIncompatibilities.any { y -> y.lowercase().contains(q) }
        }
    }

    Scaffold(
        topBar = {
            Surface(
                color = NavyDeep,
                border = BorderStroke(1.dp, NavyCardBorder)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
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
                                    text = "IV Infusion & Compatibility",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF0284C7).copy(alpha = 0.2f)) {
                                    Text(
                                        text = "ICU GUIDE",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF38BDF8),
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Dilution fluids (NS vs D5W), concentrations & fatal Y-site alerts",
                                fontSize = 11.sp,
                                color = Slate400
                            )
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
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search IV infusion (e.g. Norepinephrine, Amiodarone, Phenytoin)...") },
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
                    .testTag("iv_search_input"),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(filteredList, key = { it.id }) { item ->
                    IvInfusionCard(item = item)
                }
            }
        }
    }
}

@Composable
private fun IvInfusionCard(item: IvInfusionGuide) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.drugName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = item.primaryIndication,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Diluent Compatibility Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Diluents:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate400)
                item.preferredDiluents.forEach { dil ->
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF047857).copy(alpha = 0.15f),
                        border = BorderStroke(0.8.dp, Color(0xFF10B981))
                    ) {
                        Text(
                            text = "✅ $dil",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF059669),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            // Forbidden diluents if any
            if (item.forbiddenDiluents.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Avoid:", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                    item.forbiddenDiluents.forEach { forb ->
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF7F1D1D).copy(alpha = 0.15f),
                            border = BorderStroke(0.8.dp, Color(0xFFEF4444).copy(alpha = 0.5f))
                        ) {
                            Text(
                                text = "❌ $forb",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFDC2626),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            // Key Info Bar
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Text(
                        text = "Standard Concentration: ${item.standardConcentration}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Max Peripheral Concentration: ${item.maxPeripheralConcentration}",
                        fontSize = 10.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (item.centralLineMandatory) {
                        Text(
                            text = "⚠️ Central Line Mandatory for continuous infusion",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Amber500
                        )
                    }
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "Infusion Rate & Titration:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = item.infusionRateGuidelines,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 15.sp
                    )

                    // Y-Site Incompatibilities Box
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF7F1D1D).copy(alpha = 0.1f),
                        border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.35f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Text(
                                text = "⛔ FATAL Y-SITE INCOMPATIBILITIES (Do NOT Co-Infuse):",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFFDC2626)
                            )
                            item.ySiteIncompatibilities.forEach { incompat ->
                                Text("• $incompat", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurface)
                            }
                        }
                    }

                    if (item.fatalWarnings != null) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFB45309).copy(alpha = 0.15f),
                            border = BorderStroke(0.8.dp, Amber500.copy(alpha = 0.5f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = item.fatalWarnings,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Amber500,
                                modifier = Modifier.padding(8.dp),
                                lineHeight = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
