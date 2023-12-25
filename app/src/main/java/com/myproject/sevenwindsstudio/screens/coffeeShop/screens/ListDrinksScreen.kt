package com.myproject.sevenwindsstudio.screens.coffeeShop.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopViewModel
import com.myproject.sevenwindsstudio.screens.coffeeShop.model.CoffeeShopState
import com.myproject.sevenwindsstudio.screens.coffeeShop.view.ListDrinksView

@Composable
fun ListDrinksScreen(
    navController: NavController,
    childNavController: NavController,
    viewModel: CoffeeShopViewModel
) {
    val viewState = viewModel.state.collectAsState().value
    val listDrinks = viewModel.listDrinks.collectAsState().value
    val idAndCountDrinksInCart = viewModel.idAndCountDishesInCart.collectAsState().value

    ListDrinksView(
        listDrinks = listDrinks,
        onIncrease = { id ->
            viewModel.increase(id)
        },
        onDecrease = { id ->
            viewModel.decrease(id)
        },
        onBack = {
            viewModel.navigateToListEstablishments(
                childNavController
            )
        },
        idAndCountDrinksInCart = idAndCountDrinksInCart,
        onProceedToPayment = {
            viewModel.navigateToCart(navController = navController)
        }
    )

    when (val state = viewState) {
        CoffeeShopState.Default -> {}
        is CoffeeShopState.LoadDrinksOfEstablishment -> {
            viewModel.loadListDrinks(state.idEstablishment)
        }

        CoffeeShopState.IncreaseCountDrink -> {
            viewModel.updateCart()
        }

        CoffeeShopState.DecreaseCountDrink -> {
            viewModel.updateCart()
        }

        else -> {}
    }
}