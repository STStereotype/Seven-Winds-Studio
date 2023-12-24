package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail(
    modifier: Modifier = Modifier,
    email: MutableState<String>,
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            style = SevenWindsStudioTheme.typography.label,
            text = "e-mail")
        Box(contentAlignment = Alignment.Center) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(47.dp)
                .border(
                    width = 2.dp,
                    color = SevenWindsStudioTheme.colors.primaryColor,
                    shape = SevenWindsStudioTheme.shape.bigShape
                )
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = email.value,
                singleLine = true,
                textStyle = SevenWindsStudioTheme.typography.placeholderAndValue,
                onValueChange = { newText -> email.value = newText },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    cursorColor = SevenWindsStudioTheme.colors.primaryColor
                ),
                shape = SevenWindsStudioTheme.shape.bigShape
            )
        }
    }
}
