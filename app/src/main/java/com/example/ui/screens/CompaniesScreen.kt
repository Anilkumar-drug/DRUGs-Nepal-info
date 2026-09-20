package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.CompanyDrugBrand
import com.example.data.model.CompanyProfile
import com.example.data.model.Drug
import com.example.data.repository.ClinicalRepository
import com.example.ui.theme.DimsTealPrimary
import com.example.ui.theme.MedicalBlue400
import com.example.ui.theme.NavyCard
import com.example.ui.theme.NavyCardBorder
import com.example.ui.theme.NavyDeep
import com.example.ui.theme.NavyPill
import com.example.ui.theme.Slate400

@Composable
fun CompaniesScreen(
    onDrugClick: (Drug) -> Unit,
    onBackClick: () -> Unit
) {
    val allCompanies = remember { ClinicalRepository.getAllCompanies() }
    var searchQuery by remember { mutableStateOf("") }
    var selectedCountryFilter by remember { mutableStateOf("All") } // "All", "Nepal", "India"
    var expandedCompanyName by remember { mutableStateOf<String?>(null) }

    val filteredCompanies = remember(allCompanies, searchQuery, selectedCountryFilter) {
        allCompanies.filter { company ->
            val matchesCountry = when (selectedCountryFilter) {
                "Nepal" -> company.country.contains("Nepal")
                "India" -> company.country.contains("India")
                else -> true
            }
            val matchesSearch = if (searchQuery.isBlank()) true else {
                company.name.contains(searchQuery, ignoreCase = true) ||
                        company.products.any {
                            it.brand.name.contains(searchQuery, ignoreCase = true) ||
                                    it.drug.genericName.contains(searchQuery, ignoreCase = true)
                        }
            }
            matchesCountry && matchesSearch
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("companies_screen")
    ) {
        // Top Header
        Surface(
            color = NavyDeep,
            border = BorderStroke(0.5.dp, NavyCardBorder)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Pharmaceutical Companies",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "औषधि उत्पादक कम्पनीहरू (Nepal & India)",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = DimsTealPrimary.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, DimsTealPrimary)
                    ) {
                        Text(
                            text = "${filteredCompanies.size} Companies",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = DimsTealPrimary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(
                            text = "Search company or brand name...",
                            fontSize = 13.sp,
                            color = Slate400
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Slate400,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear",
                                    tint = Slate400,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = NavyPill,
                        unfocusedContainerColor = NavyPill,
                        focusedBorderColor = DimsTealPrimary,
                        unfocusedBorderColor = NavyCardBorder,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Country Filter Chips
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val filters = listOf("All", "Nepal", "India")
                    items(filters) { filter ->
                        val isSelected = selectedCountryFilter == filter
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedCountryFilter = filter },
                            label = {
                                Text(
                                    text = when (filter) {
                                        "Nepal" -> "Nepal 🇳🇵"
                                        "India" -> "India 🇮🇳"
                                        else -> "All Manufacturers"
                                    },
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            leadingIcon = if (isSelected) {
                                {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            } else null,
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = DimsTealPrimary,
                                selectedLabelColor = Color.Black,
                                containerColor = NavyPill,
                                labelColor = Color.White
                            ),
                            border = BorderStroke(
                                1.dp,
                                if (isSelected) DimsTealPrimary else NavyCardBorder
                            )
                        )
                    }
                }
            }
        }

        // Companies List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filteredCompanies, key = { it.name }) { company ->
                CompanyCard(
                    company = company,
                    isExpanded = expandedCompanyName == company.name,
                    onToggleExpand = {
                        expandedCompanyName = if (expandedCompanyName == company.name) null else company.name
                    },
                    onDrugClick = onDrugClick
                )
            }
        }
    }
}

@Composable
fun CompanyCard(
    company: CompanyProfile,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onDrugClick: (Drug) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = NavyCard,
        border = BorderStroke(1.dp, if (isExpanded) DimsTealPrimary.copy(alpha = 0.6f) else NavyCardBorder),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleExpand() }
            .testTag("company_${company.name}")
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Icon
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MedicalBlue400.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, MedicalBlue400.copy(alpha = 0.3f)),
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Domain,
                            contentDescription = null,
                            tint = MedicalBlue400,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = company.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (company.country.contains("Nepal")) Color(0xFF1B4332) else Color(0xFF2C194D),
                            border = BorderStroke(0.5.dp, if (company.country.contains("Nepal")) Color(0xFF40916C) else Color(0xFF7B2CBF))
                        ) {
                            Text(
                                text = company.country,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (company.country.contains("Nepal")) Color(0xFF74C69D) else Color(0xFFC77DFF),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }

                        Text(
                            text = "• ${company.products.size} listed products",
                            fontSize = 11.sp,
                            color = Slate400
                        )
                    }
                }

                IconButton(
                    onClick = onToggleExpand,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand",
                        tint = Slate400
                    )
                }
            }

            // Products Expanded List
            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        text = "MANUFACTURED BRANDS & MOLECULES",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = DimsTealPrimary,
                        letterSpacing = 0.5.sp,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )

                    company.products.forEach { product ->
                        ProductItemRow(
                            product = product,
                            onClick = { onDrugClick(product.drug) }
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ProductItemRow(
    product: CompanyDrugBrand,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = NavyPill,
        border = BorderStroke(0.5.dp, NavyCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Medication,
                contentDescription = null,
                tint = DimsTealPrimary,
                modifier = Modifier.size(16.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = product.brand.name,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "(${product.brand.strength})",
                        fontSize = 11.sp,
                        color = DimsTealPrimary
                    )
                }
                Text(
                    text = "${product.drug.genericName} • ${product.brand.form}",
                    fontSize = 11.sp,
                    color = Slate400,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Surface(
                shape = RoundedCornerShape(6.dp),
                color = DimsTealPrimary.copy(alpha = 0.12f),
                border = BorderStroke(0.5.dp, DimsTealPrimary.copy(alpha = 0.5f))
            ) {
                Text(
                    text = "VIEW",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = DimsTealPrimary,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
        }
    }
}
