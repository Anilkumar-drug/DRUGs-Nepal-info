package com.example.data.model

data class GroundingSource(
    val title: String,
    val url: String
)

data class MedicalNewsItem(
    val id: String,
    val title: String,
    val category: String, // "Outbreak Alert", "DDA Drug Recall", "Clinical Guideline", "Vaccine & Maternal", "Public Health"
    val date: String,
    val source: String, // e.g. "EDCD Nepal", "DDA Nepal", "WHO Nepal", "MOHP Nepal", "Kathmandu Post Health"
    val summary: String,
    val clinicalTakeaway: String,
    val webSources: List<GroundingSource> = emptyList(),
    val isUrgent: Boolean = false,
    val searchQueries: List<String> = emptyList()
)

data class MedicalNewsFetchResult(
    val items: List<MedicalNewsItem>,
    val rawText: String,
    val searchQueries: List<String>,
    val sources: List<GroundingSource>,
    val isLiveGrounding: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
