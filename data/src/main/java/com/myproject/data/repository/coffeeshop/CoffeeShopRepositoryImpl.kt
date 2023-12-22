package com.myproject.data.repository.coffeeshop

import com.myproject.data.remote.coffeeshop.CoffeeShopApi
import com.myproject.data.remote.coffeeshop.model.mapToListDrinkItems
import com.myproject.data.remote.coffeeshop.model.mapToListEstablishmentItem
import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository

class CoffeeShopRepositoryImpl(
    private val coffeeShopApi: CoffeeShopApi
): CoffeeShopRepository {
    override suspend fun fetchListEstablishments(token: String): List<EstablishmentItem> =
        coffeeShopApi.putListEstablishments(token).mapToListEstablishmentItem()

    override suspend fun fetchListDrinks(token: String, id: Int): List<DrinkItem> =
        coffeeShopApi.putListDrinks(token, id).mapToListDrinkItems()
}
