package com.example.data.model

data class PharmacologyGuide(
    val id: String,
    val title: String,
    val category: String,
    val subtitle: String,
    val tags: List<String>,
    val mnemonic: String? = null,
    val clinicalPearls: List<String> = emptyList(),
    val sections: List<PharmacologySection> = emptyList()
)

data class PharmacologySection(
    val heading: String,
    val text: String = "",
    val tableHeaders: List<String> = emptyList(),
    val tableRows: List<List<String>> = emptyList()
)
