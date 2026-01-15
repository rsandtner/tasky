package dev.rsandtner.sandbox.cmp.tasky.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val BrandSecondary = Color(0xFF279F70)
val BrandSecondaryVariant = BrandSecondary.copy(alpha = 0.8f)
val BrandTertiary = Color(0xFFCAEF45)
val BrandTertiaryVariant = BrandTertiary.copy(alpha = 0.8f)
val BrandSupplementary = Color(0xFFFDEFA8)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF16161C),
    onPrimary = Color(0xFFFFFFFF),
    background = Color(0xFF16161C),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    surfaceContainerHigh = Color(0xFFF2F3F7),
    onSurface = Color(0xFF3A4045),
    onSurfaceVariant = Color(0xFF76808F),
    outline = Color(0xFFB7C6DE),
    secondary = BrandSecondary,
    tertiary = BrandTertiary,
)

val LightExtendedColors = ExtendedColors(
    surfaceContainerHighVariant = LightColorScheme.surfaceContainerHigh.copy(alpha = 0.6f),
    onSurfaceVariantOpacity = LightColorScheme.onSurfaceVariant.copy(alpha = 0.7f),
    backgroundVariant = LightColorScheme.background.copy(alpha = 0.5f),
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFFFFF),
    onPrimary = Color(0xFF16161C),
    background = Color(0xFF16161C),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF1B1B20),
    surfaceContainerHigh = Color(0xFF242428),
    onSurface = Color(0xFFF2F3F7),
    onSurfaceVariant = Color(0xFF808B9B),
    outline = Color(0xFF3B3B42),
    secondary = BrandSecondary,
    tertiary = BrandTertiary,
)

val DarkExtendedColors = ExtendedColors(
    surfaceContainerHighVariant = DarkColorScheme.surfaceContainerHigh.copy(alpha = 0.6f),
    onSurfaceVariantOpacity = DarkColorScheme.onSurfaceVariant.copy(alpha = 0.7f),
    backgroundVariant = DarkColorScheme.background.copy(alpha = 0.5f),
)

@Immutable
data class ExtendedColors(
    val surfaceContainerHighVariant: Color,
    val onSurfaceVariantOpacity: Color,
    val backgroundVariant: Color,
    val secondaryVariant: Color = BrandSecondaryVariant,
    val tertiaryVariant: Color = BrandTertiaryVariant,
    val supplementary: Color = BrandSupplementary,
    val link: Color = Color(0xFF8E97FD)
)

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

val ColorScheme.extended: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current
