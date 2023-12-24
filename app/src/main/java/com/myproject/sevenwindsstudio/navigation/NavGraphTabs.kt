package com.myproject.sevenwindsstudio.navigation

sealed class NavGraphTabs(val route: String) {
    data object Main: NavGraphTabs("mainNav")
    data object Authorization: NavGraphTabs("authorizationNav")
}
