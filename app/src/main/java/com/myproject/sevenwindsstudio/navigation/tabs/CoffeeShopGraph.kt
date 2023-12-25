package com.myproject.sevenwindsstudio.navigation.tabs

import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.myproject.sevenwindsstudio.di.ViewModelFactoryProvider
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.destination.CoffeeShopGraphDestination
import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopViewModel
import com.myproject.sevenwindsstudio.screens.coffeeShop.screens.ListDrinksScreen
import com.myproject.sevenwindsstudio.screens.coffeeShop.screens.ListEstablishmentsOnMapScreen
import com.myproject.sevenwindsstudio.screens.coffeeShop.screens.ListEstablishmentsScreen
import dagger.hilt.android.EntryPointAccessors

fun NavGraphBuilder.coffeeShopGraph(
    navController: NavController,
    childNavController: NavController,
    token: String?
) {
    var viewModel: CoffeeShopViewModel? = null

    navigation(
        route = NavGraphTabs.CoffeeShop.route,
        startDestination = CoffeeShopGraphDestination.ListEstablishments.destination
    ) {
        composable(
            route = CoffeeShopGraphDestination.ListEstablishments.destination
        ) { backStackEntry ->
            val factory = EntryPointAccessors.fromActivity(
                LocalContext.current as Activity,
                ViewModelFactoryProvider::class.java
            ).coffeeShopViewModelFactory()

            if (viewModel == null) viewModel = viewModel(
                factory = CoffeeShopViewModel.provideDetailsViewModelFactory(factory, token)
            )
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