package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.DimsTealPrimary
import com.example.ui.theme.MedicalBlue400
import com.example.ui.theme.NavyCard
import com.example.ui.theme.NavyCardBorder
import com.example.ui.theme.NavyDeep
import com.example.ui.theme.NavyPill
import com.example.ui.theme.Slate400

@Composable
fun AppSidebarDrawer(
    isOpen: Boolean,
    isLoggedIn: Boolean,
    doctorName: String,
    doctorDegree: String,
    doctorCouncilNo: String,
    onClose: () -> Unit,
    onSignInClick: () -> Unit,
    onCompaniesClick: () -> Unit,
    onDrugsByIndicationClick: () -> Unit,
    onDrugsBySystemClick: () -> Unit,
    onCalculatorsClick: () -> Unit,
    onAiAssistantClick: () -> Unit,
    onSavedClick: () -> Unit = {},
    onPharmacologyClick: () -> Unit = {},
    onInteractionsClick: () -> Unit,
    onAntidotesClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    AnimatedVisibility(
        visible = isOpen,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        // Scrim backdrop
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.65f))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClose
                )
                .testTag("sidebar_scrim")
        ) {
            // Sliding Sidebar content
            AnimatedVisibility(
                visible = isOpen,
                enter = slideInHorizontally(initialOffsetX = { -it }),
                exit = slideOutHorizontally(targetOffsetX = { -it })
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .widthIn(max = 340.dp)
                        .fillMaxWidth(0.85f)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {} // Prevents clicks from dismissing when tapping drawer body
                        )
                        .testTag("sidebar_content"),
                    color = Color(0xFF080F1E),
                    border = BorderStroke(1.dp, Color(0xFF16253E))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 24.dp)
                    ) {
                        // Top Inset Spacer for Status Bar
                        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

                        // Header Bar with App branding and Close button (Matches screenshot 1)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = DimsTealPrimary.copy(alpha = 0.2f),
                                    border = BorderStroke(1.dp, DimsTealPrimary),
                                    modifier = Modifier.size(38.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = Icons.Default.Medication,
                                            contentDescription = null,
                                            tint = DimsTealPrimary,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }

                                Column {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Text(
                                            text = "DIMS Nepal",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Surface(
                                            shape = RoundedCornerShape(6.dp),
                                            color = Color(0xFF064E3B),
                                            border = BorderStroke(0.5.dp, Color(0xFF10B981))
                                        ) {
                                            Text(
                                                text = "B.S.",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF34D399),
                                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                                            )
                                        }
                                    }
                                    Text(
                                        text = "नेपाली क्लिनिकल गाइड र औषधि म्यानुअल",
                                        fontSize = 10.sp,
                                        color = Slate400
                                    )
                                }
                            }

                            IconButton(
                                onClick = onClose,
                                modifier = Modifier
                                    .size(32.dp)
                                    .testTag("sidebar_close_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Sidebar",
                                    tint = Slate400,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        // User Sign In / Profile Banner (Exact Magenta Theme from Screenshot 1)
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = Color(0xFF3B0B23),
                            border = BorderStroke(1.dp, Color(0xFF831843)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 6.dp)
                                .clickable { onSignInClick() }
                                .testTag("sidebar_profile_banner")
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = Color(0xFFE11D48),
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = Icons.Default.Person,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = if (isLoggedIn && doctorName.isNotBlank()) "Dr. $doctorName" else "User Sign In / Profile",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = if (isLoggedIn) {
                                            listOfNotNull(
                                                doctorDegree.ifBlank { null },
                                                if (doctorCouncilNo.isNotBlank()) "NMC: $doctorCouncilNo" else null
                                            ).joinToString(" • ").ifBlank { "Logged in Prescriber" }
                                        } else {
                                            "Sync calculations, saved drugs..."
                                        },
                                        fontSize = 10.sp,
                                        color = Color(0xFFFDA4AF),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                                ElevatedButton(
                                    onClick = onSignInClick,
                                    shape = RoundedCornerShape(20.dp),
                                    colors = ButtonDefaults.elevatedButtonColors(
                                        containerColor = Color(0xFFE11D48),
                                        contentColor = Color.White
                                    ),
                                    contentPadding = androidx.compose.foundation.layout.PaddingValues(
                                        horizontal = 12.dp,
                                        vertical = 6.dp
                                    ),
                                    modifier = Modifier.height(30.dp)
                                ) {
                                    Text(
                                        text = if (isLoggedIn) "Profile" else "Sign In",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Sidebar Menu Items (Structured exactly as in Screenshot 1)
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // 1. Pharmaceutical Companies (User explicitly requested)
                            SidebarItemCard(
                                icon = Icons.Default.Domain,
                                iconColor = MedicalBlue400,
                                iconBg = MedicalBlue400.copy(alpha = 0.15f),
                                title = "PHARMACEUTICAL COMPANIES",
                                subtitle = "औषधि उत्पादक कम्पनीहरू (Nepal & India)",
                                badge = "42 Companies",
                                badgeColor = MedicalBlue400,
                                onClick = onCompaniesClick,
                                testTag = "sidebar_companies_item"
                            )

                            // 2. Drugs by Indication (User explicitly requested)
                            SidebarItemCard(
                                icon = Icons.Default.Healing,
                                iconColor = Color(0xFF10B981),
                                iconBg = Color(0xFF10B981).copy(alpha = 0.15f),
                                title = "DRUGS BY INDICATION",
                                subtitle = "रोग र लक्षण अनुसार औषधिहरू",
                                badge = "Indication",
                                badgeColor = Color(0xFF10B981),
                                onClick = onDrugsByIndicationClick,
                                testTag = "sidebar_indication_item"
                            )

                            // 3. Drugs by System (User explicitly requested)
                            SidebarItemCard(
                                icon = Icons.Default.AccountTree,
                                iconColor = Color(0xFFA855F7),
                                iconBg = Color(0xFFA855F7).copy(alpha = 0.15f),
                                title = "DRUGS BY SYSTEM",
                                subtitle = "शारीरिक प्रणाली अनुसार औषधिहरू",
                                badge = "12 Systems",
                                badgeColor = Color(0xFFA855F7),
                                onClick = onDrugsBySystemClick,
                                testTag = "sidebar_system_item"
                            )

                            // 4. Calculators & Dating / Suite
                            SidebarItemCard(
                                icon = Icons.Default.Calculate,
                                iconColor = DimsTealPrimary,
                                iconBg = DimsTealPrimary.copy(alpha = 0.15f),
                                title = "CALCULATORS & SUITE",
                                subtitle = "LMP, POG, eGFR, BSA र क्लिनिकल क्याल्कुलेटर",
                                badge = "4 Tools",
                                badgeColor = DimsTealPrimary,
                                onClick = onCalculatorsClick,
                                testTag = "sidebar_calculators_item"
                            )

                            // 5. AI Health Assistant (Gemini Copilot)
                            SidebarItemCard(
                                icon = Icons.Default.AutoAwesome,
                                iconColor = Color(0xFF818CF8),
                                iconBg = Color(0xFF818CF8).copy(alpha = 0.15f),
                                title = "AI HEALTH ASSISTANT",
                                subtitle = "Gemini Maternal & Clinical AI सल्लाह",
                                badge = "24/7 AI",
                                badgeColor = Color(0xFF818CF8),
                                onClick = onAiAssistantClick,
                                testTag = "sidebar_ai_item"
                            )

                            // 6. Pharmacology Review & MOA
                            SidebarItemCard(
                                icon = Icons.AutoMirrored.Filled.MenuBook,
                                iconColor = Color(0xFF818CF8),
                                iconBg = Color(0xFF818CF8).copy(alpha = 0.15f),
                                title = "PHARMACOLOGY REVIEW & MOA",
                                subtitle = "इन्सुलिन, स्टेरोइड, एन्टिडोट र टेराटोजेन चार्टहरू",
                                badge = "14 Topics",
                                badgeColor = Color(0xFF818CF8),
                                onClick = onPharmacologyClick,
                                testTag = "sidebar_pharm_review_item"
                            )

                            // 7. Saved Clinical Favorites
                            SidebarItemCard(
                                icon = Icons.Default.Bookmark,
                                iconColor = Color(0xFFF59E0B),
                                iconBg = Color(0xFFF59E0B).copy(alpha = 0.15f),
                                title = "SAVED CLINICAL FAVORITES",
                                subtitle = "बुकमार्क गरिएका औषधि र प्रोटोकलहरू",
                                badge = "Favorites",
                                badgeColor = Color(0xFFF59E0B),
                                onClick = onSavedClick,
                                testTag = "sidebar_saved_item"
                            )

                            // 7. Drug Reminder & Interaction Checker
                            SidebarItemCard(
                                icon = Icons.Default.ElectricBolt,
                                iconColor = Color(0xFFF43F5E),
                                iconBg = Color(0xFFF43F5E).copy(alpha = 0.15f),
                                title = "DRUG REMINDER & ALARM",
                                subtitle = "Medicine schedule, smart alarm & alerts",
                                badge = "ALARM",
                                badgeColor = Color(0xFFF43F5E),
                                onClick = onInteractionsClick,
                                testTag = "sidebar_interactions_item"
                            )

                            // 8. Health Guides & Antidotes
                            SidebarItemCard(
                                icon = Icons.Default.Warning,
                                iconColor = Color(0xFFF59E0B),
                                iconBg = Color(0xFFF59E0B).copy(alpha = 0.15f),
                                title = "HEALTH GUIDES & PROTOCOLS",
                                subtitle = "ANC, खतराका लक्षण, सुरक्षित औषधिहरू",
                                badge = "4 Guides",
                                badgeColor = Color(0xFFF59E0B),
                                onClick = onAntidotesClick,
                                testTag = "sidebar_antidotes_item"
                            )

                            // 9. Settings & Prescriber Profile
                            SidebarItemCard(
                                icon = Icons.Default.Settings,
                                iconColor = Slate400,
                                iconBg = Slate400.copy(alpha = 0.15f),
                                title = "UTILITIES & SERVICES",
                                subtitle = "पात्रो, अस्पताल, आपतकालीन मद्दत र सेटिङ",
                                badge = "4 Services",
                                badgeColor = Slate400,
                                onClick = onSettingsClick,
                                testTag = "sidebar_settings_item"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SidebarItemCard(
    icon: ImageVector,
    iconColor: Color,
    iconBg: Color,
    title: String,
    subtitle: String,
    badge: String? = null,
    badgeColor: Color = DimsTealPrimary,
    onClick: () -> Unit,
    testTag: String
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFF101B2E),
        border = BorderStroke(1.dp, Color(0xFF1A2B47)),
        modifier = Modifier
            .fillMaxWidth()
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Icon
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = iconBg,
                border = BorderStroke(0.5.dp, iconColor.copy(alpha = 0.4f)),
                modifier = Modifier.size(34.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Title and Subtitle
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    letterSpacing = 0.3.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    fontSize = 10.sp,
                    color = Slate400,
                    lineHeight = 13.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Badge & Trailing chevron
            if (badge != null) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = badgeColor.copy(alpha = 0.12f),
                    border = BorderStroke(0.5.dp, badgeColor.copy(alpha = 0.5f))
                ) {
                    Text(
                        text = badge,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Slate400.copy(alpha = 0.6f),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
