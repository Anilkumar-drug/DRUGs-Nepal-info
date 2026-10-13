package com.example.data.model

import java.util.UUID

/**
 * Medication dose reminder and smart clinical alarm model.
 */
data class DrugAlarmReminder(
    val id: String = UUID.randomUUID().toString(),
    val drugName: String,
    val dosage: String = "1 Tablet",
    val hour: Int = 8, // 0-23
    val minute: Int = 0, // 0-59
    val timingTag: String = "Before Food (खाली पेट)", // "Before Food (खाली पेट)", "After Meals (खानापछि)", "With Food", "At Bedtime (सुत्ने बेलामा)"
    val frequency: String = "Once Daily (OD)", // "Once Daily (OD)", "Twice Daily (BD)", "Thrice Daily (TID)", "Four Times Daily (QID)", "As Needed (SOS)"
    val daysOfWeek: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7), // 1=Mon .. 7=Sun
    val isEnabled: Boolean = true,
    val isSoundEnabled: Boolean = true,
    val isVibrationEnabled: Boolean = true,
    val notes: String = "",
    val lastTakenDate: String? = null // e.g. "2026-10-13"
) {
    val formattedTime: String
        get() {
            val h = if (hour == 0) 12 else if (hour > 12) hour - 12 else hour
            val m = if (minute < 10) "0$minute" else "$minute"
            val amPm = if (hour < 12) "AM" else "PM"
            return "$h:$m $amPm"
        }

    val displaySummary: String
        get() = "$dosage • $timingTag • $frequency"
}
