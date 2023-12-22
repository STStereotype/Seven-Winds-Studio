package com.myproject.domain.usecase.cart

import com.myproject.domain.repository.cart.CartRepository

class DeleteCartItemUseCase(
    private val cartRepository: CartRepository
) {
    suspend fun execute(establishment: String) =
        cartRepository.deleteCartItem(establishment = establishment)
}
