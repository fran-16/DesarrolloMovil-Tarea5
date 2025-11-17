package com.example.bookshelf.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val EsquemaColoresOscuro = darkColorScheme(
    primary = md_theme_dark_primary,
    secondary = md_theme_dark_secondary,
    tertiary = md_theme_dark_tertiary
)

private val EsquemaColoresClaro = lightColorScheme(
    primary = md_theme_light_primary,
    secondary = md_theme_light_secondary,
    tertiary = md_theme_light_tertiary
)

@Composable
fun BookshelfTheme(
    usarTemaOscuro: Boolean = isSystemInDarkTheme(),
    contenido: @Composable () -> Unit
) {
    val esquemaColores = if (usarTemaOscuro) EsquemaColoresOscuro else EsquemaColoresClaro

    MaterialTheme(
        colorScheme = esquemaColores,
        typography = Typography,
        content = contenido
    )
}
