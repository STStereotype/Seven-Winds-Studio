package com.myproject.data.remote.coffeeshop

import com.myproject.data.remote.coffeeshop.model.DrinkItemsResponse
import com.myproject.data.remote.coffeeshop.model.EstablishmentsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CoffeeShopApi {
    @GET("/locations")
    suspend fun putListEstablishments(
        @Header("Authorization") token: String
    ): List<EstablishmentsResponse>

    @GET("/location/{id}/menu")
    suspend fun putListDrinks(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): List<DrinkItemsResponse>
}
