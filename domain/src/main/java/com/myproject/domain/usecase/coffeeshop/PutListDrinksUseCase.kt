package com.myproject.domain.usecase.coffeeshop

import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository

class PutListDrinksUseCase(
    private val coffeeShopRepository: CoffeeShopRepository
) {
    suspend fun execute(token: String, id: Int): List<DrinkItem> =
        coffeeShopRepository.putListDrinks(token, id)
}
