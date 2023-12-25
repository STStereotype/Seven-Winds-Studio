package com.myproject.sevenwindsstudio.navigation.tabs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.destination.CoffeeShopGraphDestination
import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopViewModel
import com.myproject.sevenwindsstudio.screens.coffeeShop.screens.ListDrinksScreen
import com.myproject.sevenwindsstudio.screens.coffeeShop.screens.ListEstablishmentsOnMapScreen
import com.myproject.sevenwindsstudio.screens.coffeeShop.screens.ListEstablishmentsScreen

fun NavGraphBuilder.coffeeShopGraph(
    navController: NavController,
    childNavController: NavController
) {
    var viewModel: CoffeeShopViewModel? = null

    navigation(
        route = NavGraphTabs.CoffeeShop.route,
        startDestination = CoffeeShopGraphDestination.ListEstablishments.destination
    ) {
        composable(
            route = CoffeeShopGraphDestination.ListEstablishments.destination
        ) {
            if (viewModel == null) viewModel = hiltViewModel()
            ListEstablishmentsScreen(
                navController = navController,
                childNavController = childNavController,
                viewModel = viewModel!!
            )
        }
        composable(
            route = CoffeeShopGraphDestination.ListDrinks.destination,
        ) {
            if (viewModel == null) viewModel = hiltViewModel()
            ListDrinksScreen(
                navController = navController,
                childNavController = childNavController,
                viewModel = viewModel!!
            )
        }
        composable(
            route = CoffeeShopGraphDestination.ListEstablishmentsOnMap.destination,
        ) {
            if (viewModel == null) viewModel = hiltViewModel()
            ListEstablishmentsOnMapScreen(
                childNavController = childNavController,
                viewModel = viewModel!!)
        }
    }
}