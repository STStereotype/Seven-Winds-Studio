package com.myproject.domain.models.coffeeshop

import com.myproject.domain.models.cart.CartDrinkItem

data class DrinkItem(
    val id: Int,
    val name: String,
    val imageURL: String,
    val price: Int,
)

fun DrinkItem.mapToCartDrinkItem(count: Int): CartDrinkItem =
    CartDrinkItem(
        id = this.id,
        name = this.name,
        price = this.price,
        count = count
    )
