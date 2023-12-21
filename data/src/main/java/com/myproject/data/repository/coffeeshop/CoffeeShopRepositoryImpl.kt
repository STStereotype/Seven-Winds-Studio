package com.myproject.data.repository.coffeeshop

import com.myproject.data.remote.coffeeshop.CoffeeShopApi
import com.myproject.data.remote.coffeeshop.model.DrinkItemsResponse
import com.myproject.data.remote.coffeeshop.model.EstablishmentsResponse
import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.domain.models.coffeeshop.PointLocation
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository

class CoffeeShopRepositoryImpl(
    private val coffeeShopApi: CoffeeShopApi
): CoffeeShopRepository {
    override suspend fun putListEstablishments(token: String): List<EstablishmentItem> =
        convertEstablishmentsResponseToListEstablishmentItems(
            coffeeShopApi.putListEstablishments(token)
        )

    override suspend fun putListDrinks(token: String, id: Int): List<DrinkItem> =
        convertDrinkItemsResponseToListDrinkItems(
            coffeeShopApi.putListDrinks(token, id)
        )

    private fun convertEstablishmentsResponseToListEstablishmentItems(
        establishmentsResponses: List<EstablishmentsResponse>
    ): List<EstablishmentItem> = establishmentsResponses.map {
        EstablishmentItem(
            id = it.id,
            name = it.name,
            point = PointLocation(
                latitude = it.point.latitude,
                longitude = it.point.longitude,
            )
        )
    }

    private fun convertDrinkItemsResponseToListDrinkItems(
        drinkItemsResponses: List<DrinkItemsResponse>
    ): List<DrinkItem> = drinkItemsResponses.map {
        DrinkItem(
            id = it.id,
            name = it.name,
            imageURL = it.imageURL,
            price = it.price,
        )
    }
}
