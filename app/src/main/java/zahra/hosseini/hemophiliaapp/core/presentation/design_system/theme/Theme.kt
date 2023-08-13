package zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LightColorPalette = HemophiliaColors(
    material = lightColorScheme(
        // You can override default colors
    ),
)

private val DarkColorPalette = HemophiliaColors(
    material = darkColorScheme(
        // You can override default colors
    )
)

private val MainTypography = HemophiliaTypography(
    material = Typography
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        LocalColors provides colors
    ) {
        MaterialTheme(
            colorScheme = colors.material,
            typography = MainTypography.material,
            content = content,
        )
    }
}

private val LocalColors = staticCompositionLocalOf { LightColorPalette }

val MaterialTheme.hemophiliaColors: HemophiliaColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

val MaterialTheme.hemophiliaTypography: HemophiliaTypography
    @Composable
    @ReadOnlyComposable
    get() = MainTypography