package com.myproject.sevenwindsstudio.screens.authorization.models

sealed class AuthorizationState {
    data object Default: AuthorizationState()
    data object SendingState: AuthorizationState()
    data object RegisterSucceededState: AuthorizationState()
    data object LogInSucceededState: AuthorizationState()
    data class  ErrorState<T>(val message: T): AuthorizationState()
}
