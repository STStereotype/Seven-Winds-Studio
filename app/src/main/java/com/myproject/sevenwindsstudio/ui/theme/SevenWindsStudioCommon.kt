package com.myproject.sevenwindsstudio.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.myproject.sevenwindsstudio.R

data class SevenWindsStudioColors(
    val background: Color,
    val headerBackground: Color,
    val primaryColor: Color,
    val secondaryColor: Color,
    val buttonTextColor: Color,
    val buttonColor: Color,
    val cardColor: Color,
    val shadowColor: Color,
)

data class SevenWindsStudioTypography(
    val primary: TextStyle,
    val secondary: TextStyle,
    val cartSecondary: TextStyle,
    val informationText: TextStyle,
    val button: TextStyle,
    val cardDrinkName: TextStyle,
    val cardDrinkPrice: TextStyle,
    val cardDrinkCount: TextStyle,
    val cartDrinkCount: TextStyle,
    val placeholderAndValue: TextStyle,
    val label: TextStyle
)

data class SevenWindsStudioShape(
    val cardShape: RoundedCornerShape,
    val bigShape: RoundedCornerShape
)

object SevenWindsStudioTheme {
    val colors: SevenWindsStudioColors
        @Composable
        get() = LocalSevenWindsStudioColors.current

    val typography: SevenWindsStudioTypography
        @Composable
        get() = LocalSevenWindsStudioTypography.current

    val shape: SevenWindsStudioShape
        @Composable
        get() = LocalSevenWindsStudioShape.current
}

val SFUIDisplay = FontFamily(
    Font(R.font.sfuidisplayregular, FontWeight.Normal),
    Font(R.font.sfuidisplaymedium, FontWeight.Medium),
    Font(R.font.sfuidisplaybold, FontWeight.Bold),
)
val LocalSevenWindsStudioColors = staticCompositionLocalOf<SevenWindsStudioColors> {
    error("No colors provided")
}

val LocalSevenWindsStudioTypography = staticCompositionLocalOf<SevenWindsStudioTypography> {
    error("No font provided")
}

val LocalSevenWindsStudioShape = staticCompositionLocalOf<SevenWindsStudioShape> {
    error("No shapes provided")
}