package com.myproject.sevenwindsstudio.screens.authorization.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.myproject.sevenwindsstudio.screens.authorization.AuthorizationViewModel
import com.myproject.sevenwindsstudio.screens.authorization.models.AuthorizationState
import com.myproject.sevenwindsstudio.screens.authorization.view.LogInView
import com.myproject.sevenwindsstudio.screens.authorization.view.SendingView

@Composable
fun LogInScreen(
    navController: NavController,
    viewModel: AuthorizationViewModel,
    onRegistration: () -> Unit
) {
    val viewState = viewModel.state.collectAsState().value

    LogInView(
        onClick = { email, password ->
            viewModel.logIn(email, password)
        },
        onRegistration = onRegistration
    )

    when (val state = viewState) {
        AuthorizationState.Default -> {
        }

        AuthorizationState.SendingState -> {
            SendingView()
        }

        AuthorizationState.LogInSucceededState -> {
            viewModel.navigateToCoffeeShop(navController)
            viewModel.showError(LocalContext.current, "Успешный вход")
        }

        is AuthorizationState.ErrorState<*> -> {
            viewModel.showError(LocalContext.current, state.message as String)
        }

        else -> {}
    }
}