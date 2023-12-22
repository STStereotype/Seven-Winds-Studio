package com.myproject.data.repository.cart

import com.google.gson.Gson
import com.myproject.data.local.cart.room.dao.CartDao
import com.myproject.data.local.cart.room.dao.CartEntity
import com.myproject.data.local.cart.room.dao.mapToCartItem
import com.myproject.domain.models.cart.Cart
import com.myproject.domain.models.cart.CartItem
import com.myproject.domain.repository.cart.CartRepository

class CartRepositoryImpl(
    private val gson: Gson,
    private val cartDao: CartDao
): CartRepository {
    override suspend fun fetchCart(): Cart = Cart(items = arrayListOf()).apply {
        cartDao.loadCart().map {
            this.items.add(it.mapToCartItem(gson))
        }
    }

    override suspend fun addCartItem(cartItem: CartItem) =
        cartDao.addCartItem(cartItem.mapToCartEntity())

    override suspend fun updateCartItem(cartItem: CartItem) =
        cartDao.updateDrinks(
            establishment = cartItem.establishment,
            drinks = gson.toJson(cartItem.drinks)
        )

    override suspend fun deleteCartItem(establishment: String) = cartDao.deleteItem(establishment)

    override suspend fun placeAnOrder(cartItem: CartItem): Boolean = true

    private fun CartItem.mapToCartEntity() = CartEntity(
        establishment = this.establishment,
        drinks = gson.toJson(this.drinks)
    )
}
