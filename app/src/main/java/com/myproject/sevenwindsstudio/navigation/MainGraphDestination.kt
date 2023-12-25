package com.myproject.sevenwindsstudio.navigation

sealed class MainGraphDestination(val destination: String) {
    data object Authorization: MainGraphDestination("${NavGraphTabs.Main.route}_AuthorizationGraph")
    data object CoffeeShop: MainGraphDestination("${NavGraphTabs.Main.route}_CoffeeShopGraph/{token}")
    data object Cart: MainGraphDestination("${NavGraphTabs.Main.route}_CartGraph")
}
