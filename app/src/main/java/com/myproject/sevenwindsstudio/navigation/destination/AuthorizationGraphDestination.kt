package com.myproject.sevenwindsstudio.navigation.destination

import androidx.navigation.NavGraphBuilder
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs

sealed class AuthorizationGraphDestination(val destination: String) {
    data object Registration: AuthorizationGraphDestination(
        "${NavGraphTabs.Authorization.route}_registrationScreen"
    )
    data object LogIn: AuthorizationGraphDestination(
        "${NavGraphTabs.Authorization.route}_logInScreen"
    )
}

