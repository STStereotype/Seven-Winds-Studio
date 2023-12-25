package com.myproject.domain.models.cart

data class CartDrinkItem (
    val id: Int,
    val name: String,
    val price: Int,
    var count: Int,
)
