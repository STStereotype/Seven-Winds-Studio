package com.myproject.sevenwindsstudio.screens.authorization.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.myproject.sevenwindsstudio.screens.authorization.AuthorizationViewModel
import com.myproject.sevenwindsstudio.screens.authorization.models.AuthorizationState
import com.myproject.sevenwindsstudio.screens.authorization.view.RegistrationView
import com.myproject.sevenwindsstudio.screens.authorization.view.SendingView

@Composable
fun RegistrationScreen(
    childNavController: NavController,
    viewModel: AuthorizationViewModel,
    onLogIn: () -> Unit,
) {
    val viewState = viewModel.state.collectAsState().value

    RegistrationView(
        onClick = { email, password, confirmPassword ->
            viewModel.registration(email, password, confirmPassword!!)
        },
        onLogIn = onLogIn
    )

    when (val state = viewState) {
        AuthorizationState.Default -> {
        }

        AuthorizationState.SendingState -> {
            SendingView()
        }

        AuthorizationState.RegisterSucceededState -> {
            viewModel.navigateToLogIn(childNavController)
            viewModel.showError(LocalContext.current, "Успешная регистрация")
        }

        is AuthorizationState.ErrorState<*> -> {
            viewModel.showError(LocalContext.current, state.message as String)
        }

        else -> {}
    }
}
