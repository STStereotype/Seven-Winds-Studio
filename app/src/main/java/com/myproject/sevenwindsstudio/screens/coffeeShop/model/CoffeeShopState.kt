package com.myproject.sevenwindsstudio.screens.coffeeShop.model

sealed class CoffeeShopState {
    data object Default: CoffeeShopState()
    data object LoadEstablishments: CoffeeShopState()
    data class LoadDrinksOfEstablishment(val idEstablishment: Int): CoffeeShopState()
    data object LoadEstablishmentsOnMap: CoffeeShopState()
    data object IncreaseCountDrink: CoffeeShopState()
    data object DecreaseCountDrink: CoffeeShopState()
    data object ProceedToPayment: CoffeeShopState()
}
