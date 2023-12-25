package com.myproject.sevenwindsstudio.screens.cart.screens

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.myproject.sevenwindsstudio.screens.cart.CartViewModel
import com.myproject.sevenwindsstudio.screens.cart.model.CartState
import com.myproject.sevenwindsstudio.screens.cart.view.CartView
import com.myproject.sevenwindsstudio.screens.coffeeShop.view.PlaceAnOrderView

@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CartViewModel
) {
    val viewState = viewModel.state.collectAsState().value
    val cart = viewModel.cart.collectAsState().value

    BackHandler(
        enabled = true
    ) {
        viewModel.navigateToCoffeeShop(navController = navController)
    }

    CartView(
        cart = cart,
        onIncrease = {
            viewModel.increase(it)
        },
        onDecrease = {
            viewModel.decrease(it)
        },
        onBack = {
            viewModel.navigateToCoffeeShop(navController = navController)
        },
        placeAnOrder = {
            viewModel.placeAnOrder()
        }
    )

    when (val state = viewState) {
        CartState.Default -> {
        }

        CartState.IncreaseDrink -> {
            Log.d("DEBUG_CHECK", "Increase")
            viewModel.resetState()
        }

        CartState.DecreaseDrink -> {
            Log.d("DEBUG_CHECK", "Decrease")
            viewModel.resetState()
        }

        is CartState.PlaceAnOrder -> {
            PlaceAnOrderView()
            viewModel.navigateToCoffeeShop(navController = navController)
            viewModel.showToast(LocalContext.current, "Спасибо за заказ")
        }
    }
}
