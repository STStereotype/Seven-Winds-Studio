package com.myproject.sevenwindsstudio.navigation.destination

import com.myproject.sevenwindsstudio.navigation.NavGraphTabs

sealed class CartGraphDestination(val destination: String) {
    data object Cart: CartGraphDestination("${NavGraphTabs.Cart}_cartScreen")
}