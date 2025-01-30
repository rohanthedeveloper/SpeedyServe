package com.example.speedyserve.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
val WarmOrange = Color(0xFFFF9800)   // Primary (Appetizing, friendly)
val DeepRed = Color(0xFFD32F2F)       // Secondary (Spicy, bold)
val SoftGreen = Color(0xFF81C784)     // Tertiary (Freshness)
val Beige = Color(0xFFF5E1C0)         // Background (Warm, café feel)
val DarkBrown = Color(0xFF5D4037)     // Dark Mode Background
private val DarkColorScheme = darkColorScheme(
    primary = WarmOrange,
    secondary = DeepRed,
    tertiary = SoftGreen,
    background = DarkBrown,
    surface = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = WarmOrange,
    secondary = DeepRed,
    tertiary = SoftGreen,
    background = Beige,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black
)

@Composable
fun SpeedyServeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}