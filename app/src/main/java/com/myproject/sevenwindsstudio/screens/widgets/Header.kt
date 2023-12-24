package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.myproject.sevenwindsstudio.R
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun Header(
    title: String,
    shouldUseBackButton: Boolean = false,
    onBack: () -> Unit = {},
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = SevenWindsStudioTheme.colors.headerBackground)
                .padding(vertical = 12.dp, horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (shouldUseBackButton)
                IconButton(onClick = onBack,
                    modifier = Modifier
                        .size(24.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        tint = SevenWindsStudioTheme.colors.primaryColor,
                    )
                }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = title,
                style = SevenWindsStudioTheme.typography.primary
            )
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .border(1.dp, SevenWindsStudioTheme.colors.shadowColor)
        )
    }
}
