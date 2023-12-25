package com.myproject.sevenwindsstudio.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val Typography = SevenWindsStudioTypography(
    primary = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        color = BaseLightPalette.primaryColor
    ),
    secondary = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = BaseLightPalette.secondaryColor
    ),
    cartSecondary = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = BaseLightPalette.secondaryColor
    ),
    informationText = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = BaseLightPalette.primaryColor
    ),
    button = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        color = BaseLightPalette.buttonTextColor
    ),
    cardDrinkName = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        color = BaseLightPalette.secondaryColor
    ),
    cardDrinkPrice = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = BaseLightPalette.primaryColor
    ),
    cartDrinkCount = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = BaseLightPalette.primaryColor
    ),
    cardDrinkCount = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = BaseLightPalette.primaryColor
    ),
    placeholderAndValue = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = BaseLightPalette.secondaryColor
    ),
    label = TextStyle(
        fontFamily = SFUIDisplay,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = BaseLightPalette.primaryColor
    )
)