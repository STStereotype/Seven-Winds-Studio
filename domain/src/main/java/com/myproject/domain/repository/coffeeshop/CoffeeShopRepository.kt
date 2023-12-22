package com.myproject.domain.repository.coffeeshop

import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.domain.models.coffeeshop.EstablishmentItem

interface CoffeeShopRepository {
    suspend fun fetchListEstablishments(token: String): List<EstablishmentItem>
    suspend fun fetchListDrinks(token: String, id: Int): List<DrinkItem>
}
