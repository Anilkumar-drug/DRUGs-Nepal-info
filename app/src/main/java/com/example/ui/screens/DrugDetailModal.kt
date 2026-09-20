package com.example.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.BrandInfo
import com.example.data.model.Drug
import com.example.ui.theme.*

private val DimsEmeraldHeader = Color(0xFF005A4E)
private val DimsHeaderPillBg = Color(0xFFE0F2F1)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugDetailModal(
    drug: Drug,
    patientWeightKg: Double,
    isBookmarked: Boolean,
    onBookmarkToggle: () -> Unit,
    onWeightChanged: (Double) -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    // Brands list for switching
    val allBrands = remember(drug) {
        val list = mutableListOf<BrandInfo>()
        list.addAll(drug.brandsNepal)
        list.addAll(drug.brandsIndia)
        if (list.isEmpty()) {
            list.add(BrandInfo(drug.genericName, "Standard Formulation", "Tablet", "Standard"))
        }
        list
    }

    var selectedBrand by remember(drug) {
        mutableStateOf(allBrands.firstOrNull() ?: BrandInfo(drug.genericName, "Generic Pharma", "Tablet", "500 mg"))
    }

    var showOtherBrandDialog by remember { mutableStateOf(false) }
    var weightInput by remember(patientWeightKg) { mutableStateOf(patientWeightKg.toString()) }

    // Map of expanded accordion sections. Order matches user screenshot exactly.
    // 0: Indications, 1: Adult dose, 2: Child dose, 3: Renal dose, 4: Administration
    // 5: Contraindications, 6: Side effects, 7: Precautions & warnings, 8: Pregnancy & Lactation
    // 9: Therapeutic Class, 10: Mode of Action, 11: Interaction, 12: Pack size & Price
    val expandedSections = remember {
        mutableStateMapOf(
            0 to true, // Indications open initially
            1 to false,
            2 to false,
            3 to false,
            4 to false,
            5 to false,
            6 to false,
            7 to false,
            8 to false,
            9 to false,
            10 to false,
            11 to false,
            12 to false
        )
    }

    // 13 standard clinical sections in exact order from DIMS screenshot
    val sections = remember(drug) {
        listOf(
            "Indications" to drug.indications,
            "Adult dose" to drug.resolvedAdultDose,
            "Child dose" to drug.resolvedChildDose,
            "Renal dose" to drug.renalAdj,
            "Administration" to buildString {
                append(drug.administration)
                if (drug.timing.isNotBlank()) {
                    append("\n\nTiming: ${drug.timing}")
                }
                if (drug.specialInstructions.isNotBlank()) {
                    append("\n\nSpecial Instructions: ${drug.specialInstructions}")
                }
            },
            "Contraindications" to drug.resolvedContraindications,
            "Side effects" to drug.sideEffects,
            "Precautions & warnings" to drug.resolvedPrecautions,
            "Pregnancy & Lactation" to drug.resolvedPregnancyLactation,
            "Therapeutic Class" to "${drug.drugClass}\n\nOrgan System: ${drug.system}",
            "Mode of Action" to drug.resolvedModeOfAction,
            "Interaction" to drug.resolvedInteractions,
            "Pack size & Price" to drug.resolvedPackSizePrice
        )
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true
        )
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .testTag("drug_detail_modal"),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Top App Bar (Brand Details)
                Surface(
                    color = DimsEmeraldHeader,
                    shadowElevation = 4.dp
                ) {
                    Column {
                        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier.testTag("modal_back_button")
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }

                            Text(
                                text = "Brand Details",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 8.dp)
                            )

                            // Heart / Favorite Icon
                            IconButton(
                                onClick = onBookmarkToggle,
                                modifier = Modifier.testTag("modal_bookmark_button")
                            ) {
                                Icon(
                                    imageVector = if (isBookmarked) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                                    contentDescription = "Bookmark",
                                    tint = if (isBookmarked) Red500 else Color.White
                                )
                            }

                            // Home Icon
                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier.testTag("modal_home_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                }

                // Scrollable Body
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Header Card (Teal Hero Section matching Screenshot)
                    Surface(
                        color = DimsEmeraldHeader,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.dp, vertical = 14.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Brand Name + Strength + Pill Icon
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = selectedBrand.name,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                if (selectedBrand.strength.isNotBlank()) {
                                    Text(
                                        text = selectedBrand.strength,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White.copy(alpha = 0.9f)
                                    )
                                }
                                Icon(
                                    imageVector = Icons.Default.Medication,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            // Dosage Form
                            Text(
                                text = selectedBrand.form.ifBlank { "Tablet" },
                                fontSize = 14.sp,
                                color = Color.White.copy(alpha = 0.85f)
                            )

                            // Generic Name (Italicized)
                            Text(
                                text = drug.genericName,
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Italic,
                                color = Color.White.copy(alpha = 0.95f),
                                fontWeight = FontWeight.Normal
                            )

                            // Manufacturer / Company
                            Text(
                                text = selectedBrand.company.ifBlank { "Pharmaceutical Ltd." },
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )

                            // "Also Available:" formulations
                            Text(
                                text = "Also Available:",
                                fontSize = 13.sp,
                                color = Color.White.copy(alpha = 0.85f),
                                fontWeight = FontWeight.Normal
                            )

                            // Horizontal Form / Strength Chips
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                allBrands.take(6).forEach { brand ->
                                    val isSelected = brand == selectedBrand
                                    val chipLabel = "${brand.strength} | ${brand.form}".trim()

                                    Surface(
                                        onClick = { selectedBrand = brand },
                                        shape = RoundedCornerShape(20.dp),
                                        color = if (isSelected) Color.White.copy(alpha = 0.9f) else DimsHeaderPillBg.copy(alpha = 0.85f),
                                        border = if (isSelected) BorderStroke(1.5.dp, Color.White) else null,
                                        modifier = Modifier.height(34.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            if (isSelected) {
                                                Icon(
                                                    imageVector = Icons.Default.CheckCircle,
                                                    contentDescription = "Selected",
                                                    tint = DimsEmeraldHeader,
                                                    modifier = Modifier.size(16.dp)
                                                )
                                            }
                                            Text(
                                                text = chipLabel,
                                                fontSize = 12.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                                color = Color(0xFF1B3B36)
                                            )
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            // Unit Price & Action Buttons (Other Brand & WEB)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                // Unit Price
                                Text(
                                    text = "Unit Price : ${drug.priceNpr.ifBlank { "Rs. 25.00 NPR" }}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                    modifier = Modifier.weight(1f)
                                )

                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    // Other Brand Button
                                    OutlinedButton(
                                        onClick = { showOtherBrandDialog = true },
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.8f)),
                                        colors = ButtonDefaults.outlinedButtonColors(
                                            contentColor = Color.White
                                        ),
                                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                                        modifier = Modifier.height(36.dp)
                                    ) {
                                        Text("Other Brand", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                    }

                                    // WEB Button
                                    OutlinedButton(
                                        onClick = {
                                            clipboardManager.setText(AnnotatedString("${drug.genericName} dosing monograph clinical guidelines"))
                                            Toast.makeText(context, "Search term copied for ${drug.genericName}", Toast.LENGTH_SHORT).show()
                                        },
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.8f)),
                                        colors = ButtonDefaults.outlinedButtonColors(
                                            contentColor = Color.White
                                        ),
                                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                        modifier = Modifier.height(36.dp)
                                    ) {
                                        Text("WEB", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Icon(
                                            imageVector = Icons.Default.Language,
                                            contentDescription = "Web",
                                            modifier = Modifier.size(16.dp),
                                            tint = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Dose Calculation Card ("beside dose calculation")
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Calculate,
                                        contentDescription = null,
                                        tint = DimsTealPrimary,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Text(
                                        text = "Clinical Dose Calculation",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }

                                if (drug.pediatricDosePerKg != null) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = Emerald500.copy(alpha = 0.15f)
                                    ) {
                                        Text(
                                            text = "${drug.pediatricDosePerKg} mg/kg",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Emerald500,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                OutlinedTextField(
                                    value = weightInput,
                                    onValueChange = {
                                        weightInput = it
                                        it.toDoubleOrNull()?.let { w ->
                                            if (w in 1.0..300.0) onWeightChanged(w)
                                        }
                                    },
                                    label = { Text("Patient Weight (kg)") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                    singleLine = true,
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(56.dp)
                                )

                                // Quick Weight Preset Chips
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    listOf(10.0, 20.0, 50.0, 70.0).forEach { preset ->
                                        SuggestionChip(
                                            onClick = {
                                                weightInput = preset.toInt().toString()
                                                onWeightChanged(preset)
                                            },
                                            label = { Text("${preset.toInt()}kg", fontSize = 11.sp) }
                                        )
                                    }
                                }
                            }

                            // Calculated Dose Output
                            val calculatedDoseMg = remember(drug, patientWeightKg) {
                                drug.pediatricDosePerKg?.let { perKg ->
                                    (perKg * patientWeightKg).toInt()
                                }
                            }

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surface,
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.15f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    if (calculatedDoseMg != null) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "Calculated Pediatric Dose:",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                            Text(
                                                text = "$calculatedDoseMg mg/day",
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Emerald500
                                            )
                                        }
                                        if (drug.pediatricInterval != null) {
                                            Text(
                                                text = "Regimen: ${drug.pediatricInterval}",
                                                fontSize = 12.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    } else {
                                        Text(
                                            text = "Standard Adult Regimen: ${drug.resolvedAdultDose.lines().firstOrNull() ?: drug.resolvedAdultDose}",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // The 13 Collapsible Sections (exact ordering & labels from Screenshot)
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.surface
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            sections.forEachIndexed { index, (title, content) ->
                                val isExpanded = expandedSections[index] == true

                                CollapsibleSectionRow(
                                    title = title,
                                    content = content,
                                    isExpanded = isExpanded,
                                    onToggle = {
                                        expandedSections[index] = !isExpanded
                                    }
                                )

                                HorizontalDivider(
                                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f),
                                    thickness = 0.8.dp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }

    // "Other Brand" Dialog showing all Nepal & India Brands
    if (showOtherBrandDialog) {
        AlertDialog(
            onDismissRequest = { showOtherBrandDialog = false },
            title = {
                Text(
                    text = "Brands for ${drug.genericName}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 420.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    if (drug.brandsNepal.isNotEmpty()) {
                        Text(
                            text = "🇳🇵 Nepal Brands",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = DimsTealPrimary
                        )
                        drug.brandsNepal.forEach { brand ->
                            BrandSelectionItem(
                                brand = brand,
                                isSelected = brand == selectedBrand,
                                onClick = {
                                    selectedBrand = brand
                                    showOtherBrandDialog = false
                                }
                            )
                        }
                    }

                    if (drug.brandsIndia.isNotEmpty()) {
                        Text(
                            text = "🇮🇳 India Brands",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Indigo400
                        )
                        drug.brandsIndia.forEach { brand ->
                            BrandSelectionItem(
                                brand = brand,
                                isSelected = brand == selectedBrand,
                                onClick = {
                                    selectedBrand = brand
                                    showOtherBrandDialog = false
                                }
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showOtherBrandDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

@Composable
private fun CollapsibleSectionRow(
    title: String,
    content: String,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        label = "arrow_rotation"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onToggle)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Chevron arrow directly on the left (matching the DIMS screenshot)
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Collapse $title" else "Expand $title",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .size(22.dp)
                    .rotate(rotationAngle)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = if (isExpanded) FontWeight.Bold else FontWeight.Normal,
                color = if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f))
                    .padding(start = 48.dp, end = 18.dp, top = 8.dp, bottom = 16.dp)
            ) {
                Text(
                    text = content.ifBlank { "No specific clinical precautions documented for this parameter." },
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 13.5.sp,
                    lineHeight = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
private fun BrandSelectionItem(
    brand: BrandInfo,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        border = if (isSelected) BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary) else null,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${brand.name} (${brand.strength})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "${brand.company} • ${brand.form}",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
