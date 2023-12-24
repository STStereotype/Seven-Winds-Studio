package com.myproject.sevenwindsstudio.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myproject.sevenwindsstudio.screens.authorization.AuthorizationScreen

fun NavGraphBuilder.mainGraph(
    navController: NavController
) {
    navigation(
        route = NavGraphTabs.Main.route,
        startDestination = MainGraphDestination.Authorization.destination
    ) {
        composable(MainGraphDestination.Authorization.destination) {
            AuthorizationScreen(navController)
        }
        composable(MainGraphDestination.CoffeeShop.destination) { }
        composable(MainGraphDestination.Cart.destination) { }
    }
}