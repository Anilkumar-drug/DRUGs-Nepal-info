package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.ChatMessage
import com.example.data.model.MessageSender
import com.example.ui.theme.*
import com.example.viewmodel.ClinicalUiState
import com.example.viewmodel.ClinicalViewModel
import kotlinx.coroutines.launch

@Composable
fun GeminiChatScreen(
    state: ClinicalUiState,
    viewModel: ClinicalViewModel
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedCategory by remember { mutableStateOf("⚡ Emergency") }

    LaunchedEffect(state.chatMessages.size, state.isAiThinking) {
        if (state.chatMessages.isNotEmpty()) {
            listState.animateScrollToItem(state.chatMessages.size - 1)
        }
    }

    val categories = remember {
        listOf("⚡ Emergency", "🐍 Toxicology", "📋 Guidelines", "🔍 Interactions", "⚖️ Renal/Dosing")
    }

    val categoryPrompts = remember {
        mapOf(
            "⚡ Emergency" to listOf(
                "Anaphylaxis Epinephrine Dosing (WAO/EAACI)",
                "ACLS Pulseless VT/VF Algorithm & Amiodarone",
                "PSVT Adenosine Protocol & Modified Valsalva",
                "Status Epilepticus AES Protocol (Lorazepam + Levetiracetam)"
            ),
            "🐍 Toxicology" to listOf(
                "Snakebite Polyvalent ASV Protocol (WHO & Nepal)",
                "Emergency Organophosphate Atropinization & 2-PAM",
                "Paracetamol NAC 3-Bag Infusion Protocol",
                "Cyanide Hydroxocobalamin Dosing",
                "Local Anesthetic Toxicity (LAST) 20% Lipid Rescue"
            ),
            "📋 Guidelines" to listOf(
                "Asthma GINA 2024 Track 1 SMART Regimen",
                "Acute MI AHA/ACC STEMI & DAPT Protocol",
                "Acute Ischemic Stroke ASA Alteplase & BP Targets",
                "TB WHO 2HRZE / 4HR Regimen & BPaLM",
                "Acute Pancreatitis ACG Fluid Resuscitation",
                "Ulcerative Colitis ACG 5-ASA & ASUC Flare",
                "H. Pylori ACG 2024 Bismuth Quadruple Therapy"
            ),
            "🔍 Interactions" to listOf(
                "Check interaction: Telmisartan + Spironolactone",
                "Aspirin + Ticagrelor safety limits in ACS",
                "Amiodarone + Digoxin / Warfarin interaction"
            ),
            "⚖️ Renal/Dosing" to listOf(
                "Metformin renal dosing & contrast guidelines",
                "Levetiracetam renal clearance adjustment",
                "Amox-Clav pediatric otitis media dose"
            )
        )
    }

    val currentPrompts = categoryPrompts[selectedCategory] ?: emptyList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // AI Banner with Controls
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Indigo950.copy(alpha = 0.5f),
            border = androidx.compose.foundation.BorderStroke(1.dp, Indigo500.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = Indigo600,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "Gemini Clinical AI",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Indigo400
                            )
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Emerald600.copy(alpha = 0.2f),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Emerald400.copy(alpha = 0.3f))
                            ) {
                                Text(
                                    text = "3.5 Flash",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Emerald400,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "AHA, GINA, ASA, ACG, AES, WHO & Nepal Protocols",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                IconButton(
                    onClick = { viewModel.clearChat() },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Reset Chat",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        // Clinical Category Selector Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = cat },
                    label = { Text(cat, fontSize = 11.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Indigo600,
                        selectedLabelColor = Color.White,
                        containerColor = MaterialTheme.colorScheme.surface,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        borderColor = if (isSelected) Indigo400 else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                        enabled = true,
                        selected = isSelected
                    )
                )
            }
        }

        // Quick Clinical Prompt Chips for Selected Category
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            currentPrompts.forEach { query ->
                SuggestionChip(
                    onClick = { viewModel.sendAiMessage(query) },
                    label = { Text(query, fontSize = 11.sp) },
                    shape = RoundedCornerShape(14.dp),
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                        labelColor = MaterialTheme.colorScheme.onSurface
                    ),
                    border = SuggestionChipDefaults.suggestionChipBorder(
                        borderColor = Indigo500.copy(alpha = 0.35f),
                        enabled = true
                    )
                )
            }
        }

        // Chat Message History
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(state.chatMessages, key = { it.id }) { msg ->
                ChatBubble(msg)
            }

            if (state.isAiThinking) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Indigo600,
                            modifier = Modifier.size(28.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("AI", fontSize = 10.sp, fontWeight = FontWeight.Black, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Indigo950.copy(alpha = 0.4f),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Indigo500.copy(alpha = 0.3f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(14.dp),
                                    strokeWidth = 2.dp,
                                    color = Indigo400
                                )
                                Text(
                                    text = "Analyzing clinical pharmacology database...",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 12.sp,
                                    color = Indigo400
                                )
                            }
                        }
                    }
                }
            }
        }

        // Input Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = state.aiInputText,
                onValueChange = { viewModel.updateAiInput(it) },
                placeholder = { Text("Ask clinical pharmacology query...", fontSize = 13.sp) },
                modifier = Modifier
                    .weight(1f)
                    .testTag("gemini_chat_input"),
                shape = RoundedCornerShape(18.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedBorderColor = Indigo500,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
                ),
                maxLines = 3,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = {
                    if (state.aiInputText.isNotBlank() && !state.isAiThinking) {
                        viewModel.sendAiMessage()
                    }
                })
            )

            IconButton(
                onClick = { viewModel.sendAiMessage() },
                enabled = state.aiInputText.isNotBlank() && !state.isAiThinking,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(if (state.aiInputText.isNotBlank()) Indigo600 else MaterialTheme.colorScheme.surfaceVariant)
                    .testTag("gemini_send_button")
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send Query",
                    tint = if (state.aiInputText.isNotBlank()) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ChatBubble(message: ChatMessage) {
    val isUser = message.sender == MessageSender.USER
    val clipboardManager = LocalClipboardManager.current
    var copied by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        if (!isUser) {
            Surface(
                shape = CircleShape,
                color = Indigo600,
                modifier = Modifier.size(28.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("AI", fontSize = 10.sp, fontWeight = FontWeight.Black, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

        Surface(
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = if (isUser) 16.dp else 4.dp,
                bottomEnd = if (isUser) 4.dp else 16.dp
            ),
            color = if (isUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
            border = if (!isUser) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)) else null,
            modifier = Modifier.widthIn(max = 320.dp)
        ) {
            Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)) {
                Text(
                    text = message.text,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 13.sp,
                    color = if (isUser) Color.White else MaterialTheme.colorScheme.onSurface,
                    lineHeight = 19.sp
                )

                if (!isUser) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                clipboardManager.setText(AnnotatedString(message.text))
                                copied = true
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = if (copied) Icons.Default.Check else Icons.Default.ContentCopy,
                                contentDescription = "Copy Response",
                                tint = if (copied) Emerald400 else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }

        if (isUser) {
            Spacer(modifier = Modifier.width(8.dp))
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(28.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
