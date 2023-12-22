package com.myproject.domain.models.cart

data class CartItem(
    val establishment: String,
    val drinks: ArrayList<CartDrinkItem>
)
