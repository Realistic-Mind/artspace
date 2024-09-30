package com.example.artspace.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

//  comic book-style
private val ComicBookColors = lightColorScheme(
    primary = Color(0xFFED1C24),  // Bright red
    onPrimary = Color(0xFF000000),  // Black text on primary buttons
    secondary = Color(0xFF00A2E8),  // Bright blue
    onSecondary = Color(0xFFFFFFFF),  // White on blue
    background = Color(0xFFFFF200),  // Vivid yellow background
    surface = Color(0xFF000000),  // Black surface for contrast
    onSurface = Color(0xFFFFFFFF),  // White text on black surface
    error = Color(0xFFF44336),  // Red for errors
    onError = Color.White,  // White text on error background
)

// Bold and dynamic typography for comic book feel
private val ComicTypography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,  // Large, bold font for titles
        color = Color(0xFF000000),  // Black text for titles
        letterSpacing = 2.sp       // Wide letter spacing for comic effect
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color(0xFFFF9800),  // Black text for body
        letterSpacing = 1.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color(0xFFFFFFFF),  // White text for buttons
        letterSpacing = 1.sp
    )
)

@Composable
fun ArtSpaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFED1C24),
            onPrimary = Color(0xFF000000),
            secondary = Color(0xFF00A2E8),
            background = Color(0xFF9C27B0),
            surface = Color(0xFF000000),
            onSurface = Color(0xFFFFFFFF)
        )
    } else {
        ComicBookColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = ComicTypography,
        content = content
    )
}
