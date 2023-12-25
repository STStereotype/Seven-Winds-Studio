package com.myproject.sevenwindsstudio.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.myproject.sevenwindsstudio.screens.authorization.AuthorizationScreen
import com.myproject.sevenwindsstudio.screens.cart.CartMainScreen
import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopScreen

fun NavGraphBuilder.mainGraph(
    navController: NavController
) {
    navigation(
        route = NavGraphTabs.Main.route,
        startDestination = MainGraphDestination.Authorization.destination
    ) {
        composable(MainGraphDestination.Authorization.destination) {
            AuthorizationScreen(navController = navController)
        }
        composable(
            route = MainGraphDestination.CoffeeShop.destination,
        ) {
            CoffeeShopScreen(navController = navController)
        }
        composable(
            route = MainGraphDestination.Cart.destination,
            arguments = listOf(navArgument("idEstablishment") {
                type = NavType.IntType
            })) { backStackEntry ->
            val idEstablishment = backStackEntry.arguments?.getInt("idEstablishment")
            CartMainScreen(navController = navController, idEstablishment!!)
        }
    }
}
