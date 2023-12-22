package com.myproject.domain.usecase.cart

import com.myproject.domain.models.cart.Cart
import com.myproject.domain.repository.cart.CartRepository

class FetchCartUseCase(
    private val cartRepository: CartRepository
) {
    suspend fun execute(): Cart = cartRepository.fetchCart()
}
