package com.myproject.domain.usecase.cart

import com.myproject.domain.models.cart.CartItem
import com.myproject.domain.repository.cart.CartRepository

class AddCartItemUseCase(
    private val cartRepository: CartRepository
) {
    suspend fun execute(cartItem: CartItem) =
        cartRepository.addCartItem(cartItem)
}
