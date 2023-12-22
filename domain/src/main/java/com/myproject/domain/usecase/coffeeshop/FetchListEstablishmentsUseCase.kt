package com.myproject.domain.usecase.coffeeshop

import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository

class FetchListEstablishmentsUseCase(
    private val coffeeShopRepository: CoffeeShopRepository
) {
    suspend fun execute(token: String): List<EstablishmentItem> =
        coffeeShopRepository.fetchListEstablishments(token)
}
