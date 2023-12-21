package com.myproject.domain.repository.coffeeshop

import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.domain.models.coffeeshop.EstablishmentItem

interface CoffeeShopRepository {
    suspend fun putListEstablishments(token: String): List<EstablishmentItem>
    suspend fun putListDrinks(token: String, id: Int): List<DrinkItem>
}
