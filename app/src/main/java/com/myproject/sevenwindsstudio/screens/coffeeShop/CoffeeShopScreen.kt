package com.myproject.sevenwindsstudio.screens.coffeeShop

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.tabs.coffeeShopGraph

@Composable
fun CoffeeShopScreen(
    navController: NavController,
    token: String?
) {
    val childNavController = rememberNavController()
    NavHost(
        navController = childNavController,
        startDestination = NavGraphTabs.CoffeeShop.route
    ) {
        coffeeShopGraph(
            navController = navController,
            childNavController = childNavController,
            token
        )
    }
}
