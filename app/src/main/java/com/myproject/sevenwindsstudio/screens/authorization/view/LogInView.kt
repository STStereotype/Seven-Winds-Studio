package com.myproject.sevenwindsstudio.screens.authorization.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproject.sevenwindsstudio.screens.widgets.AuthButton
import com.myproject.sevenwindsstudio.screens.widgets.Header
import com.myproject.sevenwindsstudio.screens.widgets.TextFieldEmail
import com.myproject.sevenwindsstudio.screens.widgets.TextFieldPassword
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun LogInView(
    onClick: (email: String, password: String) -> Unit,
    onRegistration: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val email = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }

        Header(title = "Вход")
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            TextFieldEmail(modifier = Modifier.padding(horizontal = 18.dp), email)
            TextFieldPassword(
                modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 24.dp),
                password = password
            )
            AuthButton(
                modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 43.dp),
                title = "Вход",
                onClick = {
                    onClick.invoke(email.value, password.value)
                }
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .clickable { onRegistration.invoke() },
                    style = SevenWindsStudioTheme.typography.secondary,
                    text = "Зарегестрироваться"
                )
            }
        }
    }
}
