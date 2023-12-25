package com.myproject.sevenwindsstudio.screens.coffeeShop.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopViewModel
import com.myproject.sevenwindsstudio.screens.coffeeShop.view.ListEstablishmentsOnMapView

@Composable
fun ListEstablishmentsOnMapScreen(
    childNavController: NavController,
    viewModel: CoffeeShopViewModel
) {
    val viewState = viewModel.state.collectAsState().value
    val listEstablishments = viewModel.listEstablishments.collectAsState().value

    ListEstablishmentsOnMapView(
        listEstablishments = listEstablishments,
        onBack = {
            viewModel.navigateToListEstablishments(childNavController)
        }
    )
}
