package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class SavedItemType(val label: String) {
    DRUG("Drug"),
    PROTOCOL("Protocol"),
    CALCULATOR("Calculator")
}

@Entity(tableName = "saved_items")
data class SavedItemEntity(
    @PrimaryKey val id: String, // e.g. "drug_d1", "protocol_dp1", "calc_egfr"
    val itemType: String,       // "DRUG", "PROTOCOL", "CALCULATOR"
    val targetId: String,       // "d1", "dp1", "egfr"
    val title: String,          // e.g. "Amoxicillin + Potassium Clavulanate", "Acute Asthma Exacerbation"
    val subtitle: String,       // e.g. "Moxclave 625 • Antibiotic", "Respiratory Emergency"
    val category: String,       // e.g. "Anti-Infectives", "Respiratory", "Nephrology"
    val extraInfo: String = "", // extra payload or tags
    val timestamp: Long = System.currentTimeMillis()
)
