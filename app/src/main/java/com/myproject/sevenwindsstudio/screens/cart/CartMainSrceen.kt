package com.myproject.sevenwindsstudio.screens.cart

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.tabs.cartGraph

@Composable
fun CartMainScreen(
    navController: NavController,
    idEstablishment: Int?
) {
    val childNavController = rememberNavController()
    NavHost(
        navController = childNavController,
        startDestination = NavGraphTabs.Cart.route
    ) {
        cartGraph(
            navController = navController,
            idEstablishment = idEstablishment
        )
    }
}
