package com.example.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import com.example.data.model.AppThemeMode
import com.example.data.model.FontSizeScale

private val LightColorScheme = lightColorScheme(
    primary = MedicalBlue600,
    onPrimary = Color.White,
    primaryContainer = MedicalBlue100,
    onPrimaryContainer = MedicalBlue900,
    secondary = Emerald600,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFDCFCE7),
    onSecondaryContainer = Color(0xFF14532D),
    tertiary = Indigo600,
    onTertiary = Color.White,
    background = Slate50,
    onBackground = Slate900,
    surface = Color.White,
    onSurface = Slate900,
    surfaceVariant = Slate100,
    onSurfaceVariant = Slate700,
    outline = Slate200,
    error = Red600,
    onError = Color.White,
    errorContainer = Color(0xFFFEE2E2),
    onErrorContainer = Red950
)

private val DarkColorScheme = darkColorScheme(
    primary = MedicalBlue400,
    onPrimary = MedicalBlue900,
    primaryContainer = MedicalBlue900,
    onPrimaryContainer = MedicalBlue100,
    secondary = Emerald400,
    onSecondary = Emerald950,
    secondaryContainer = Emerald950,
    onSecondaryContainer = Emerald400,
    tertiary = Indigo400,
    onTertiary = Indigo950,
    background = Slate900,
    onBackground = Slate50,
    surface = Slate800,
    onSurface = Slate50,
    surfaceVariant = Slate700,
    onSurfaceVariant = Slate200,
    outline = Slate700,
    error = Red400,
    onError = Red950,
    errorContainer = Red950,
    onErrorContainer = Red400
)

private val PitchBlackColorScheme = darkColorScheme(
    primary = Emerald400,
    onPrimary = Color.Black,
    primaryContainer = PitchBlackCard,
    onPrimaryContainer = Emerald400,
    secondary = MedicalBlue400,
    onSecondary = Color.Black,
    secondaryContainer = PitchBlackCard,
    onSecondaryContainer = MedicalBlue400,
    tertiary = Indigo400,
    onTertiary = Color.Black,
    background = PitchBlackBg,
    onBackground = Color(0xFFF3F4F6),
    surface = PitchBlackCard,
    onSurface = Color(0xFFF3F4F6),
    surfaceVariant = PitchBlackNav,
    onSurfaceVariant = Color(0xFF9CA3AF),
    outline = PitchBlackBorder,
    error = Red400,
    onError = Color.Black,
    errorContainer = Red950,
    onErrorContainer = Red400
)

@Composable
fun DrugsNepalTheme(
    themeMode: AppThemeMode = AppThemeMode.PITCH_BLACK,
    fontSizeScale: FontSizeScale = FontSizeScale.NORMAL,
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = when (themeMode) {
        AppThemeMode.LIGHT -> LightColorScheme
        AppThemeMode.DARK -> DarkColorScheme
        AppThemeMode.PITCH_BLACK -> PitchBlackColorScheme
    }

    if (fontSizeScale == FontSizeScale.NORMAL) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    } else {
        val currentDensity = LocalDensity.current
        val customDensity = androidx.compose.runtime.remember(currentDensity.density, currentDensity.fontScale, fontSizeScale) {
            Density(
                density = currentDensity.density,
                fontScale = currentDensity.fontScale * fontSizeScale.scaleFactor
            )
        }

        CompositionLocalProvider(LocalDensity provides customDensity) {
            MaterialTheme(
                colorScheme = colorScheme,
                typography = Typography,
                content = content
            )
        }
    }
}
