package com.myproject.sevenwindsstudio.screens.authorization.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun SendingView() {
    Box(
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) { }
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.2f))
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = SevenWindsStudioTheme.colors.background
        )
    }
}
