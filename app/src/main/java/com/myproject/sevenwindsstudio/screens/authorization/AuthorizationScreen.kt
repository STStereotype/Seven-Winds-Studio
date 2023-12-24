package com.myproject.sevenwindsstudio.screens.authorization

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.destination.AuthorizationGraphDestination
import com.myproject.sevenwindsstudio.navigation.tabs.authorizationGraph

@Composable
fun AuthorizationScreen(
    navController: NavController
) {
    val childNavController = rememberNavController()
    NavHost(
        navController = childNavController,
        startDestination = NavGraphTabs.Authorization.route
    ) {
        authorizationGraph(
            navController = navController,
            childNavController = childNavController,
            startDestination = AuthorizationGraphDestination.LogIn
        )
    }
}
