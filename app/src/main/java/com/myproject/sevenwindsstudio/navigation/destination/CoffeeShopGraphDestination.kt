package com.myproject.sevenwindsstudio.navigation.destination

import com.myproject.sevenwindsstudio.navigation.NavGraphTabs

sealed class CoffeeShopGraphDestination(val destination: String) {
    data object ListEstablishments: CoffeeShopGraphDestination(
        "${NavGraphTabs.CoffeeShop.route}_listEstablishments"
    )
    data object ListEstablishmentsOnMap: CoffeeShopGraphDestination(
        "${NavGraphTabs.CoffeeShop.route}_listEstablishmentsOnMap"
    )
    data object ListDrinks: CoffeeShopGraphDestination(
        "${NavGraphTabs.CoffeeShop.route}_listDrinks"
    )
}
