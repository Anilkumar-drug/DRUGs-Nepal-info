package com.example.ui.theme

import androidx.compose.ui.graphics.Color

val MedicalBlue50 = Color(0xFFF0F9FF)
val MedicalBlue100 = Color(0xFFE0F2FE)
val MedicalBlue200 = Color(0xFFBAE6FD)
val MedicalBlue400 = Color(0xFF38BDF8)
val MedicalBlue500 = Color(0xFF0284C7)
val MedicalBlue600 = Color(0xFF0369A1)
val MedicalBlue700 = Color(0xFF075985)
val MedicalBlue900 = Color(0xFF0C4A6E)

val Emerald400 = Color(0xFF34D399)
val Emerald500 = Color(0xFF10B981)
val Emerald600 = Color(0xFF059669)
val Emerald950 = Color(0xFF022C22)

val Amber400 = Color(0xFFFBBF24)
val Amber500 = Color(0xFFF59E0B)
val Amber950 = Color(0xFF451A03)

val Red400 = Color(0xFFF87171)
val Red500 = Color(0xFFEF4444)
val Red600 = Color(0xFFDC2626)
val Red900 = Color(0xFF7F1D1D)
val Red950 = Color(0xFF450A0A)

val Indigo400 = Color(0xFF818CF8)
val Indigo500 = Color(0xFF6366F1)
val Indigo600 = Color(0xFF4F46E5)
val Indigo950 = Color(0xFF1E1B4B)

val Slate50 = Color(0xFFF8FAFC)
val Slate100 = Color(0xFFF1F5F9)
val Slate200 = Color(0xFFE2E8F0)
val Slate400 = Color(0xFF94A3B8)
val Slate600 = Color(0xFF475569)
val Slate700 = Color(0xFF334155)
val Slate800 = Color(0xFF1E293B)
val Slate900 = Color(0xFF0F172A)

// OLED Pitch Black Colors
val PitchBlackBg = Color(0xFF000000)
val PitchBlackCard = Color(0xFF0D0D0D)
val PitchBlackNav = Color(0xFF050505)
val PitchBlackBorder = Color(0xFF262626)

// Organ System Accents
val Cyan400 = Color(0xFF22D3EE)
val Cyan500 = Color(0xFF06B6D4)
val Violet400 = Color(0xFFA78BFA)
val Violet500 = Color(0xFF8B5CF6)
val Orange400 = Color(0xFFFB923C)
val Orange500 = Color(0xFFF97316)
val Rose400 = Color(0xFFFB7185)
val Rose500 = Color(0xFFF43F5E)

fun getSystemColor(system: String): Color {
    val s = system.lowercase()
    return when {
        s.contains("infect") || s.contains("anti") -> Emerald500
        s.contains("cardio") || s.contains("cvs") -> Red500
        s.contains("respir") || s.contains("pulm") -> Cyan500
        s.contains("endo") || s.contains("diabet") -> Amber500
        s.contains("neuro") || s.contains("psych") || s.contains("cns") -> Violet500
        s.contains("gastro") || s.contains("gi") -> Orange500
        s.contains("musculo") || s.contains("rheum") -> Indigo500
        s.contains("nephro") || s.contains("renal") -> MedicalBlue500
        else -> MedicalBlue600
    }
}
