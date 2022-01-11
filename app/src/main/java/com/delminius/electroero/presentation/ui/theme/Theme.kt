package com.delminius.electroero.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PastelBlueColor,
    primaryVariant = PastelYellowColor,
    secondary = PastelRedColor
)

private val LightColorPalette = lightColors(
    primary = PastelBlueColor,
    primaryVariant = PastelYellowColor,
    secondary = PastelRedColor,
    background = LightBackgroundAndTextColor,
    surface = LightBackgroundAndTextColor,
    onPrimary = DarkBackgroundAndTextColor,
    onSecondary = DarkBackgroundAndTextColor,
    onBackground = DarkBackgroundAndTextColor,
    onSurface = DarkBackgroundAndTextColor
)

@Composable
fun ElectroEroTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    //TODO themes later
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}