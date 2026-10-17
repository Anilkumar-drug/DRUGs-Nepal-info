package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

data class EmergencyHotline(
    val id: String,
    val name: String,
    val nepaliName: String,
    val category: HotlineCategory,
    val phoneDisplay: String,
    val dialNumber: String,
    val location: String,
    val specialty: String,
    val is24Hours: Boolean = true,
    val priorityColor: Color = Red500
)

enum class HotlineCategory(val label: String, val emoji: String) {
    ALL("All", "🚨"),
    POISON("Poison & Toxins", "🧪"),
    SNAKE_RABIES("ASV & Rabies", "🐍"),
    BLOOD_BANK("Blood Bank", "🩸"),
    AMBULANCE("Ambulance & Rescue", "🚑"),
    HOSPITALS("Tertiary ER", "🏥")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NepalEmergencyHelplinesSheet(
    onDismissRequest: () -> Unit
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    var selectedCategory by remember { mutableStateOf(HotlineCategory.ALL) }
    var searchQuery by remember { mutableStateOf("") }

    val hotlines = remember {
        listOf(
            EmergencyHotline(
                id = "tuth_npic",
                name = "National Poison Information Center (NPIC) / TUTH",
                nepaliName = "राष्ट्रिय विष सूचना केन्द्र, शिक्षण अस्पताल",
                category = HotlineCategory.POISON,
                phoneDisplay = "01-4412303 / 01-4412505",
                dialNumber = "+97714412303",
                location = "Maharajgunj, Kathmandu",
                specialty = "24/7 Clinical Toxicology guidance for Organophosphates, Celphos, Wild Mushroom, Snakebite & Drug Overdose",
                is24Hours = true,
                priorityColor = Red500
            ),
            EmergencyHotline(
                id = "teku_hospital",
                name = "Sukraraj Tropical & Infectious Disease Hospital (Teku)",
                nepaliName = "शुक्रराज ट्रपिकल तथा सरुवा रोग अस्पताल (टेकु)",
                category = HotlineCategory.SNAKE_RABIES,
                phoneDisplay = "01-4253396 / 01-4253397",
                dialNumber = "+97714253396",
                location = "Teku, Kathmandu",
                specialty = "National Referral Center for Anti-Snake Venom (ASV), Rabies RIG & ARV, Dengue, Scrub Typhus & Cholera",
                is24Hours = true,
                priorityColor = Amber500
            ),
            EmergencyHotline(
                id = "red_cross_blood",
                name = "Nepal Red Cross Central Blood Transfusion Service (CBTS)",
                nepaliName = "नेपाल रेडक्रस केन्द्रीय रक्तसञ्चार सेवा",
                category = HotlineCategory.BLOOD_BANK,
                phoneDisplay = "01-4288485 / 01-4288486",
                dialNumber = "+97714288485",
                location = "Exhibition Road / Soaltee Mode, Kathmandu",
                specialty = "24/7 Emergency Blood Components: PRBC, Whole Blood, Fresh Frozen Plasma (FFP), Platelets & Cryo",
                is24Hours = true,
                priorityColor = Color(0xFFDC2626)
            ),
            EmergencyHotline(
                id = "nas_ambulance",
                name = "Nepal Ambulance Service (NAS)",
                nepaliName = "नेपाल एम्बुलेन्स सेवा (केन्द्रीय प्रेषण)",
                category = HotlineCategory.AMBULANCE,
                phoneDisplay = "102 (Toll Free National)",
                dialNumber = "102",
                location = "Nationwide (Kathmandu, Pokhara, Chitwan, Butwal)",
                specialty = "24/7 Central Medical Emergency Dispatch with trained EMTs and Advanced Cardiac Life Support (ACLS)",
                is24Hours = true,
                priorityColor = Emerald500
            ),
            EmergencyHotline(
                id = "mohp_emergency",
                name = "MoHP Health Emergency Operations Centre (HEOC)",
                nepaliName = "स्वास्थ्य आपतकालीन कार्यसञ्चालन केन्द्र",
                category = HotlineCategory.AMBULANCE,
                phoneDisplay = "1155 / 1115 (Toll Free)",
                dialNumber = "1155",
                location = "Ministry of Health, Kathmandu",
                specialty = "National Disease Outbreak surveillance, Epidemic response (Dengue, Cholera) and referral coordination",
                is24Hours = true,
                priorityColor = Color(0xFF0284C7)
            ),
            EmergencyHotline(
                id = "police_emergency",
                name = "Nepal Police Emergency Control Room",
                nepaliName = "नेपाल प्रहरी आपतकालीन नियन्त्रण कक्ष",
                category = HotlineCategory.AMBULANCE,
                phoneDisplay = "100 (Toll Free)",
                dialNumber = "100",
                location = "Nationwide",
                specialty = "Trauma rescue dispatch, Road traffic accident response & emergency corridor clearance",
                is24Hours = true,
                priorityColor = Color(0xFF3B82F6)
            ),
            EmergencyHotline(
                id = "bir_trauma",
                name = "Bir Hospital & National Trauma Center",
                nepaliName = "वीर अस्पताल तथा राष्ट्रिय ट्रमा सेन्टर",
                category = HotlineCategory.HOSPITALS,
                phoneDisplay = "01-4221119 / 01-4221988",
                dialNumber = "+97714221119",
                location = "Mahaboudha, Kathmandu",
                specialty = "Largest Tertiary Central Emergency, Level 1 Polytrauma & Neurosurgery Resuscitation Center",
                is24Hours = true,
                priorityColor = Color(0xFF8B5CF6)
            ),
            EmergencyHotline(
                id = "patan_hospital",
                name = "Patan Hospital (PAHS) Emergency",
                nepaliName = "पाटन अस्पताल आपतकालीन कक्ष",
                category = HotlineCategory.HOSPITALS,
                phoneDisplay = "01-5522278 / 01-5522295",
                dialNumber = "+97715522278",
                location = "Lagankhel, Lalitpur",
                specialty = "24/7 Emergency & ICU, Paediatric & Maternal Resuscitation, Dialysis & Snakebite Care",
                is24Hours = true,
                priorityColor = Color(0xFF0D9488)
            ),
            EmergencyHotline(
                id = "bpkihs_dharan",
                name = "BPKIHS Emergency (Eastern Nepal)",
                nepaliName = "बी.पी. कोइराला स्वास्थ्य विज्ञान प्रतिष्ठान",
                category = HotlineCategory.HOSPITALS,
                phoneDisplay = "025-525555 Ext. 2000",
                dialNumber = "+97725525555",
                location = "Dharan, Sunsari (Koshi Province)",
                specialty = "Primary Referral Emergency & Toxicology/Snakebite Intensive Care for Eastern Nepal",
                is24Hours = true,
                priorityColor = Color(0xFFD97706)
            ),
            EmergencyHotline(
                id = "bharatpur_hospital",
                name = "Bharatpur Hospital Emergency (Central Nepal)",
                nepaliName = "भरतपुर अस्पताल आपतकालीन कक्ष",
                category = HotlineCategory.HOSPITALS,
                phoneDisplay = "056-520112 / 056-524112",
                dialNumber = "+97756520112",
                location = "Bharatpur, Chitwan (Bagmati Province)",
                specialty = "Central Hub for Snakebite Envenomation, Organophosphate poisoning & Highway Trauma",
                is24Hours = true,
                priorityColor = Color(0xFFE11D48)
            ),
            EmergencyHotline(
                id = "western_regional_pokhara",
                name = "Pokhara Academy of Health Sciences (WRH)",
                nepaliName = "पोखरा स्वास्थ्य विज्ञान प्रतिष्ठान (पश्चिमाञ्चल क्षेत्रीय)",
                category = HotlineCategory.HOSPITALS,
                phoneDisplay = "061-526416 / 061-520057",
                dialNumber = "+97761526416",
                location = "Ramghat, Pokhara (Gandaki Province)",
                specialty = "Major Emergency & Trauma Center for Western Nepal & Annapurna Region",
                is24Hours = true,
                priorityColor = Color(0xFF4F46E5)
            ),
            EmergencyHotline(
                id = "dda_adr",
                name = "Department of Drug Administration (DDA) ADR Reporting",
                nepaliName = "औषधि व्यवस्था विभाग (प्रतिकूल असर रिपोर्टिङ)",
                category = HotlineCategory.POISON,
                phoneDisplay = "01-4780227 / 01-4780228",
                dialNumber = "+97714780227",
                location = "Bijulibazar, Kathmandu",
                specialty = "National Pharmacovigilance Centre, ADR Reporting, Drug Recall & Spurious Drug Complaints",
                is24Hours = false,
                priorityColor = Amber500
            )
        )
    }

    val filteredHotlines = remember(selectedCategory, searchQuery) {
        hotlines.filter { hotline ->
            val matchesCategory = selectedCategory == HotlineCategory.ALL || hotline.category == selectedCategory
            val matchesQuery = if (searchQuery.isBlank()) true else {
                val q = searchQuery.trim().lowercase()
                hotline.name.lowercase().contains(q) ||
                hotline.nepaliName.lowercase().contains(q) ||
                hotline.location.lowercase().contains(q) ||
                hotline.specialty.lowercase().contains(q) ||
                hotline.phoneDisplay.contains(q)
            }
            matchesCategory && matchesQuery
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = Red500.copy(alpha = 0.15f),
                        modifier = Modifier.size(42.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = null,
                                tint = Red500,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "Nepal Emergency Helplines",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Red500.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "24/7 DESK",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Red500,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "नेपाल आपतकालीन, विष सूचना तथा रक्तसञ्चार सम्पर्क",
                            fontSize = 11.5.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                IconButton(onClick = onDismissRequest) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                }
            }

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search hospital, poison desk, blood bank, or city...", fontSize = 12.sp) },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null, tint = DimsTealPrimary, modifier = Modifier.size(18.dp))
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear", modifier = Modifier.size(16.dp))
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = DimsTealPrimary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("emergency_search_input")
            )

            // Category Chips
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                HotlineCategory.values().forEach { cat ->
                    val isSelected = selectedCategory == cat
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedCategory = cat },
                        label = {
                            Text(
                                text = "${cat.emoji} ${cat.label}",
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = DimsTealPrimary.copy(alpha = 0.2f),
                            selectedLabelColor = DimsTealPrimary
                        ),
                        border = FilterChipDefaults.filterChipBorder(
                            enabled = true,
                            selected = isSelected,
                            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                            selectedBorderColor = DimsTealPrimary
                        )
                    )
                }
            }

            // List of Hotlines
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 480.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredHotlines, key = { it.id }) { item ->
                    HotlineItemCard(
                        hotline = item,
                        onDial = { dialNumber(context, item.dialNumber) },
                        onCopy = {
                            clipboardManager.setText(AnnotatedString(item.dialNumber))
                            Toast.makeText(context, "Copied: ${item.phoneDisplay}", Toast.LENGTH_SHORT).show()
                        }
                    )
                }

                if (filteredHotlines.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No emergency helplines match \"$searchQuery\"",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HotlineItemCard(
    hotline: EmergencyHotline,
    onDial: () -> Unit,
    onCopy: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        border = BorderStroke(1.dp, hotline.priorityColor.copy(alpha = 0.35f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = hotline.name,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = hotline.nepaliName,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (hotline.is24Hours) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Emerald500.copy(alpha = 0.15f),
                            border = BorderStroke(0.5.dp, Emerald500)
                        ) {
                            Text(
                                text = "24/7",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Emerald500,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Text(
                text = hotline.specialty,
                fontSize = 10.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 14.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = DimsTealPrimary,
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = hotline.location,
                    fontSize = 10.sp,
                    color = DimsTealPrimary,
                    fontWeight = FontWeight.Medium
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f),
                thickness = 0.8.dp,
                modifier = Modifier.padding(vertical = 2.dp)
            )

            // Action row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null,
                        tint = hotline.priorityColor,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = hotline.phoneDisplay,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onCopy,
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                        modifier = Modifier.height(28.dp),
                        border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))
                    ) {
                        Icon(Icons.Default.ContentCopy, contentDescription = "Copy", modifier = Modifier.size(12.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Copy", fontSize = 10.5.sp)
                    }

                    Button(
                        onClick = onDial,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = hotline.priorityColor),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
                        modifier = Modifier.height(28.dp)
                    ) {
                        Icon(Icons.Default.Call, contentDescription = "Dial", tint = Color.White, modifier = Modifier.size(12.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Call", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    }
}

private fun dialNumber(context: Context, number: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$number")
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Unable to launch phone dialer: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
