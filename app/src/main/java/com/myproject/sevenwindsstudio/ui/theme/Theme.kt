package com.myproject.sevenwindsstudio.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) BaseLightPalette else BaseLightPalette
    val typography = Typography
    val shape = Shapes

    CompositionLocalProvider (
        LocalSevenWindsStudioColors provides colors,
        LocalSevenWindsStudioTypography provides typography,
        LocalSevenWindsStudioShape provides shape,
        content = content
    )
}
