package com.myproject.domain.repository.cart

import com.myproject.domain.models.cart.Cart
import com.myproject.domain.models.cart.CartItem

interface CartRepository {
    suspend fun fetchCart(): Cart
    suspend fun addCartItem(cartItem: CartItem)
    suspend fun updateCartItem(cartItem: CartItem)
    suspend fun deleteCartItem(establishment: Int)
    suspend fun placeAnOrder(cartItem: CartItem): Boolean
}
