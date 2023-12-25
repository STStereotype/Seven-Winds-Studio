package com.myproject.sevenwindsstudio.screens.coffeeShop.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopViewModel
import com.myproject.sevenwindsstudio.screens.coffeeShop.model.CoffeeShopState
import com.myproject.sevenwindsstudio.screens.coffeeShop.view.ListEstablishmentsView

@Composable
fun ListEstablishmentsScreen(
    navController: NavController,
    childNavController: NavController,
    viewModel: CoffeeShopViewModel
) {
    val viewState = viewModel.state.collectAsState().value
    val listEstablishments = viewModel.listEstablishments.collectAsState().value

    ListEstablishmentsView(
        listEstablishments = listEstablishments,
        onClickEstablishment = { idEstablishment ->
            viewModel.navigateToListDrinks(childNavController, idEstablishment)
        },
        onClickMap = {
            viewModel.navigateToListEstablishmentsOnMap(childNavController)
        },
        onBack = {
            viewModel.navigateToLogIn(navController)
        }
    )

    when (val state = viewState) {
        CoffeeShopState.Default -> {}
        is CoffeeShopState.LoadEstablishments -> {
            viewModel.loadListEstablishments()
        }
        else -> {}
    }
}
