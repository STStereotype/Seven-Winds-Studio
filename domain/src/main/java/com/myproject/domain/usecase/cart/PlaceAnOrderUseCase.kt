package com.myproject.domain.usecase.cart

import com.myproject.domain.models.cart.CartItem
import com.myproject.domain.repository.cart.CartRepository

class PlaceAnOrderUseCase(
    private val cartRepository: CartRepository
) {
    suspend fun execute(cartItem: CartItem): Boolean =
        cartRepository.placeAnOrder(cartItem)
}
