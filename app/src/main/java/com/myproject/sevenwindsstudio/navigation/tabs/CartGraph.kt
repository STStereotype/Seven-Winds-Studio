package com.myproject.sevenwindsstudio.navigation.tabs

import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myproject.sevenwindsstudio.di.ViewModelFactoryProvider
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.destination.CartGraphDestination
import com.myproject.sevenwindsstudio.screens.cart.CartViewModel
import com.myproject.sevenwindsstudio.screens.cart.screens.CartScreen
import dagger.hilt.android.EntryPointAccessors

fun NavGraphBuilder.cartGraph(
    navController: NavController,
    idEstablishment: Int?
) {
    navigation(
        route = NavGraphTabs.Cart.route,
        startDestination = CartGraphDestination.Cart.destination
    ) {
        composable(
            route = CartGraphDestination.Cart.destination
        ) { backStackEntry ->
            val factory = EntryPointAccessors.fromActivity(
                LocalContext.current as Activity,
                ViewModelFactoryProvider::class.java
            ).cartViewModelFactory()

            var viewModel: CartViewModel = viewModel(
                factory = CartViewModel.provideCartViewModelFactory(factory, idEstablishment)
            )
            CartScreen(navController = navController, viewModel)
        }
    }

}
