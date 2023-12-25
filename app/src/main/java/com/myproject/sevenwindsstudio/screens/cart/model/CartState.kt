package com.myproject.sevenwindsstudio.screens.cart.model

sealed class CartState {
    data object Default: CartState()
    data object PlaceAnOrder: CartState()
    data object IncreaseDrink: CartState()
    data object DecreaseDrink: CartState()
}
