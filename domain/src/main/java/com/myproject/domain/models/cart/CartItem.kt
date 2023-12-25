package com.myproject.domain.models.cart

data class CartItem(
    val establishment: Int,
    val drinks: ArrayList<CartDrinkItem>
)

