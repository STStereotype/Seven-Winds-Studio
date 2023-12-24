package com.myproject.sevenwindsstudio.screens.authorization

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.myproject.domain.models.authorization.AuthResponse
import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.usecase.authorization.LogInUseCase
import com.myproject.domain.usecase.authorization.RegistrationUseCase
import com.myproject.sevenwindsstudio.navigation.MainGraphDestination
import com.myproject.sevenwindsstudio.navigation.destination.AuthorizationGraphDestination
import com.myproject.sevenwindsstudio.screens.authorization.models.AuthorizationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase,
    private val logInUseCase: LogInUseCase,
): ViewModel() {

    private var toast: Toast? = null
    val state: MutableStateFlow<AuthorizationState> = MutableStateFlow(AuthorizationState.Default)

    fun registration(email: String, password: String, confirmPassword: String) {
        if (!validateEmail(email = email)) {
            state.value = AuthorizationState.ErrorState(message = "e-mail введен некорректно")
            return
        }
        if (!validatePassword(password = password)) {
            state.value =
                AuthorizationState.ErrorState(message = "Пароль должен быть не менее 8 символов")
            return
        }
        if (!validateConfirmPassword(password = password, confirmPassword = confirmPassword)) {
            state.value = AuthorizationState.ErrorState(message = "Пароли не совпадают")
            return
        }

        state.value = AuthorizationState.SendingState
        CoroutineScope(Dispatchers.IO).launch {
            var errorMessage = ""
            val response: AuthResponse
            try {
                response = registrationUseCase.execute(
                    Authorization(
                        login = email,
                        password = password
                    )
                )
            } catch (e: Exception) {
                errorMessage = e.message!!
            }

            if (errorMessage.isEmpty()) {
                launch(Dispatchers.Main) {
                    state.value = AuthorizationState.RegisterSucceededState
                }
            } else {
                launch(Dispatchers.Main) {
                    state.value =
                        if (errorMessage == "HTTP 406 Not Acceptable")
                            AuthorizationState.ErrorState("Данный пользователь уже зарегестрирован")
                        else
                            AuthorizationState.ErrorState("Ошибка соединения")
                }
            }
        }
    }

    fun logIn(email: String, password: String) {
        if (!validateEmail(email = email)) {
            state.value = AuthorizationState.ErrorState(message = "e-mail введен некорректно")
            return
        }
        if (!validatePassword(password = password)) {
            state.value =
                AuthorizationState.ErrorState(message = "Пароль должен быть не менее 8 символов")
            return
        }

        state.value = AuthorizationState.SendingState
        CoroutineScope(Dispatchers.IO).launch {
            var errorMessage = ""
            val response: AuthResponse
            try {
                response = logInUseCase.execute(
                    Authorization(
                        login = email,
                        password = password
                    )
                )
            } catch (e: Exception) {
                errorMessage = e.message!!
            }

            if (errorMessage.isEmpty()) {
                launch(Dispatchers.Main) {
                    state.value = AuthorizationState.LogInSucceededState
                }
            } else {
                launch(Dispatchers.Main) {
                    state.value =
                        if (errorMessage == "HTTP 401 Unauthorized")
                            AuthorizationState.ErrorState("Неверный логин или пароль")
                        else
                            AuthorizationState.ErrorState("Ошибка соединения")
                }
            }
        }
    }

    fun showError(context: Context, message: String) {
        toast?.cancel()
        toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast?.show()
        state.value = AuthorizationState.Default
    }

    fun navigateToCoffeeShop(navController: NavController) {
        state.value = AuthorizationState.Default
        navigateTo(navController, MainGraphDestination.CoffeeShop.destination)
    }

    fun navigateToRegistration(childNavController: NavController) {
        state.value = AuthorizationState.Default
        navigateTo(childNavController, AuthorizationGraphDestination.Registration.destination)
    }

    fun navigateToLogIn(childNavController: NavController) {
        state.value = AuthorizationState.Default
        navigateTo(childNavController, AuthorizationGraphDestination.LogIn.destination)
    }

    private fun navigateTo(navController: NavController, root: String) {
        navController.navigate(root) {
            popUpTo(navController.currentDestination?.route.toString()) {
                inclusive = true
            }
        }
    }

    private fun validateEmail(email: String): Boolean =
        email.contains("@") && email.contains('.')

    private fun validatePassword(password: String): Boolean = password.length >= 8

    private fun validateConfirmPassword(password: String, confirmPassword: String): Boolean =
        password == confirmPassword
}
