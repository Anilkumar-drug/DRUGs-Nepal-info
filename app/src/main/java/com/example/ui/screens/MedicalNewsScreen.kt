package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.GroundingSource
import com.example.data.model.MedicalNewsItem
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel
import com.example.viewmodel.NavigationScreen

@Composable
fun MedicalNewsScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel,
    onBackToHome: () -> Unit
) {
    BackHandler { onBackToHome() }

    val context = LocalContext.current
    var searchFilterText by remember { mutableStateOf("") }
    val categories = remember {
        listOf("All", "Outbreak Alert", "DDA Drug Recall", "Clinical Guideline", "Vaccine & Maternal")
    }

    val filteredList = remember(state.medicalNewsList, state.newsCategoryFilter, searchFilterText) {
        state.medicalNewsList.filter { item ->
            val matchesCategory = if (state.newsCategoryFilter == "All") true
            else item.category.contains(state.newsCategoryFilter, ignoreCase = true)

            val q = searchFilterText.trim().lowercase()
            val matchesSearch = if (q.isEmpty()) true
            else {
                item.title.lowercase().contains(q) ||
                item.summary.lowercase().contains(q) ||
                item.clinicalTakeaway.lowercase().contains(q) ||
                item.source.lowercase().contains(q)
            }
            matchesCategory && matchesSearch
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top Header Banner with Live Search Grounding Badge
        Surface(
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
            modifier = Modifier.fillMaxWidth()
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
                        IconButton(
                            onClick = onBackToHome,
                            modifier = Modifier
                                .size(36.dp)
                                .testTag("medical_news_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "Nepal Clinical News",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = if (state.isNewsLiveGrounding) Emerald500.copy(alpha = 0.18f) else Cyan500.copy(alpha = 0.18f),
                                    border = BorderStroke(
                                        0.8.dp,
                                        if (state.isNewsLiveGrounding) Emerald400 else Cyan400
                                    )
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (state.isNewsLiveGrounding) Icons.Default.Public else Icons.Default.VerifiedUser,
                                            contentDescription = null,
                                            tint = if (state.isNewsLiveGrounding) Emerald400 else Cyan400,
                                            modifier = Modifier.size(11.dp)
                                        )
                                        Text(
                                            text = if (state.isNewsLiveGrounding) "Live Grounded" else "National Verified",
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (state.isNewsLiveGrounding) Emerald400 else Cyan400
                                        )
                                    }
                                }
                            }

                            Text(
                                text = "EDCD, DDA, WHO & MOHP updates with search grounding",
                                fontSize = 10.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Refresh Button with infinite rotation when loading
                    val infiniteTransition = rememberInfiniteTransition(label = "refreshRotation")
                    val rotation by infiniteTransition.animateFloat(
                        initialValue = 0f,
                        targetValue = if (state.isNewsLoading) 360f else 0f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(900, easing = LinearEasing),
                            repeatMode = RepeatMode.Restart
                        ),
                        label = "rotationAnim"
                    )

                    FilledTonalButton(
                        onClick = { viewModel.fetchMedicalNews(forceRefresh = true) },
                        enabled = !state.isNewsLoading,
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                        modifier = Modifier.height(34.dp).testTag("news_refresh_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh News",
                            modifier = Modifier
                                .size(15.dp)
                                .rotate(if (state.isNewsLoading) rotation else 0f)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (state.isNewsLoading) "Fetching..." else "Live Update",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Search Within News Input Field
                OutlinedTextField(
                    value = searchFilterText,
                    onValueChange = { searchFilterText = it },
                    placeholder = {
                        Text(
                            text = "Search outbreak, DDA recall, vaccine, dengue...",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(17.dp)
                        )
                    },
                    trailingIcon = {
                        if (searchFilterText.isNotEmpty()) {
                            IconButton(onClick = { searchFilterText = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Clear",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("news_search_field")
                )

                // Category Filter Chips Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    categories.forEach { cat ->
                        val isSelected = state.newsCategoryFilter == cat
                        FilterChip(
                            selected = isSelected,
                            onClick = { viewModel.setNewsCategoryFilter(cat) },
                            label = {
                                Text(
                                    text = cat,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier.testTag("news_filter_${cat.lowercase().replace(" ", "_")}")
                        )
                    }
                }
            }
        }

        // Active Grounding Search Queries (Search Grounding Transparency Banner)
        if (state.newsSearchQueries.isNotEmpty()) {
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ManageSearch,
                        contentDescription = null,
                        tint = Emerald400,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = "Grounding Queries:",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    state.newsSearchQueries.take(3).forEach { query ->
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.surface,
                            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                        ) {
                            Text(
                                text = query,
                                fontSize = 9.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }

        // News Content List
        if (state.isNewsLoading && state.medicalNewsList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CircularProgressIndicator(
                        color = Emerald400,
                        modifier = Modifier.size(36.dp)
                    )
                    Text(
                        text = "Searching live national medical sources...",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Grounding queries against EDCD, DDA, WHO & MOHP Nepal",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        } else if (filteredList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Feed,
                        contentDescription = null,
                        tint = Slate400,
                        modifier = Modifier.size(44.dp)
                    )
                    Text(
                        text = "No updates match your search",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Try clearing the search filter or switching to 'All' category.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredList, key = { it.id }) { newsItem ->
                    MedicalNewsCard(
                        item = newsItem,
                        onOpenUrl = { url ->
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                Toast.makeText(context, "Cannot open link: $url", Toast.LENGTH_SHORT).show()
                            }
                        },
                        onCopyAlert = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText(
                                "Nepal Medical Alert",
                                "${newsItem.title}\n\nSummary:\n${newsItem.summary}\n\nClinical Takeaway:\n${newsItem.clinicalTakeaway}\n\nSource: ${newsItem.source}"
                            )
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "Alert copied to clipboard", Toast.LENGTH_SHORT).show()
                        },
                        onAskCopilot = {
                            viewModel.askCopilotAboutNews(newsItem)
                            viewModel.navigateTo(NavigationScreen.GEMINI)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MedicalNewsCard(
    item: MedicalNewsItem,
    onOpenUrl: (String) -> Unit,
    onCopyAlert: () -> Unit,
    onAskCopilot: () -> Unit
) {
    val categoryColor = when {
        item.category.contains("outbreak", ignoreCase = true) -> Red500
        item.category.contains("recall", ignoreCase = true) || item.category.contains("dda", ignoreCase = true) -> Amber500
        item.category.contains("maternal", ignoreCase = true) || item.category.contains("vaccine", ignoreCase = true) -> Cyan500
        else -> Indigo400
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            if (item.isUrgent) 1.5.dp else 1.dp,
            if (item.isUrgent) Red500.copy(alpha = 0.8f) else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("news_card_${item.id}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row: Category Badge + Urgent Flag + Date
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = categoryColor.copy(alpha = 0.15f),
                        border = BorderStroke(0.6.dp, categoryColor.copy(alpha = 0.5f))
                    ) {
                        Text(
                            text = item.category.uppercase(),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = categoryColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    if (item.isUrgent) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Red950.copy(alpha = 0.5f),
                            border = BorderStroke(0.6.dp, Red500)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Warning,
                                    contentDescription = null,
                                    tint = Red400,
                                    modifier = Modifier.size(10.dp)
                                )
                                Text(
                                    text = "URGENT",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Red400
                                )
                            }
                        }
                    }
                }

                Text(
                    text = item.date,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Title
            Text(
                text = item.title,
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 19.sp
            )

            // Source Attribution
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBalance,
                    contentDescription = null,
                    tint = Emerald400,
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    text = item.source,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Emerald400
                )
            }

            // Summary
            Text(
                text = item.summary,
                fontSize = 12.sp,
                lineHeight = 17.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Clinical Practice Takeaway Box
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = null,
                            tint = Amber400,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "CLINICAL PRACTICE TAKEAWAY",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary,
                            letterSpacing = 0.2.sp
                        )
                    }
                    Text(
                        text = item.clinicalTakeaway,
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Grounding Web Sources (Clickable Citations)
            if (item.webSources.isNotEmpty()) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Grounding Web Sources:",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        item.webSources.forEach { source ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                                border = BorderStroke(0.6.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)),
                                modifier = Modifier.clickable { onOpenUrl(source.url) }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.OpenInNew,
                                        contentDescription = "Open Source Link",
                                        tint = Cyan400,
                                        modifier = Modifier.size(11.dp)
                                    )
                                    Text(
                                        text = source.title,
                                        fontSize = 10.sp,
                                        color = Cyan400,
                                        fontWeight = FontWeight.Medium,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f),
                modifier = Modifier.padding(top = 2.dp)
            )

            // Card Action Buttons (Copy & Ask Copilot)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = onCopyAlert,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Copy Alert", fontSize = 11.sp)
                }

                FilledTonalButton(
                    onClick = onAskCopilot,
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier.height(32.dp).testTag("ask_copilot_about_${item.id}")
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = null,
                        tint = SparkleViolet,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Ask AI Copilot",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = SparkleViolet
                    )
                }
            }
        }
    }
}
