package com.example.data.model

data class DiseaseProtocol(
    val id: String,
    val name: String,
    val category: String,
    val firstLine: String,
    val secondLine: String,
    val inpatient: String,
    val guidelines: String
)

data class Antidote(
    val id: String,
    val poison: String,
    val antidote: String,
    val dosing: String,
    val notes: String,
    val urgency: String = "CRITICAL"
)

data class ChatMessage(
    val id: String,
    val sender: MessageSender,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)

enum class MessageSender {
    USER, AI
}

enum class AppThemeMode {
    LIGHT, DARK, PITCH_BLACK
}

enum class FontSizeScale(val scaleFactor: Float, val label: String) {
    TINY(0.85f, "Tiny"),
    SMALL(0.92f, "Small"),
    NORMAL(1.0f, "Normal"),
    LARGE(1.12f, "Large"),
    XLARGE(1.25f, "X-Large")
}
