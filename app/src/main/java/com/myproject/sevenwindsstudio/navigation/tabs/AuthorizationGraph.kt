package com.myproject.sevenwindsstudio.navigation.tabs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.destination.AuthorizationGraphDestination
import com.myproject.sevenwindsstudio.screens.authorization.AuthorizationViewModel
import com.myproject.sevenwindsstudio.screens.authorization.screens.LogInScreen
import com.myproject.sevenwindsstudio.screens.authorization.screens.RegistrationScreen

fun NavGraphBuilder.authorizationGraph(
    startDestination: AuthorizationGraphDestination = AuthorizationGraphDestination.Registration,
    navController: NavController,
    childNavController: NavController
) {
    var viewModel: AuthorizationViewModel? = null

    navigation(
        route = NavGraphTabs.Authorization.route,
        startDestination = startDestination.destination
    ) {
        composable(AuthorizationGraphDestination.Registration.destination) {
            if (viewModel == null) viewModel = hiltViewModel()

            RegistrationScreen(
                childNavController = childNavController,
                viewModel = viewModel!!,
                onLogIn = {
                    viewModel!!.navigateToLogIn(childNavController)
                }
            )
        }
        composable(AuthorizationGraphDestination.LogIn.destination) {
            if (viewModel == null) viewModel = hiltViewModel()
            LogInScreen(
                navController = navController,
                viewModel = viewModel!!,
                onRegistration = {
                    viewModel!!.navigateToRegistration(childNavController)
                }
            )
        }
    }
}
