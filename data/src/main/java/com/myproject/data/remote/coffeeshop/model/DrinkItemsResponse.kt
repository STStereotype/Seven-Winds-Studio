package com.myproject.data.remote.coffeeshop.model

import com.google.gson.annotations.SerializedName
import com.myproject.domain.models.coffeeshop.DrinkItem

data class DrinkItemsResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("price") val price: Int,
)

fun List<DrinkItemsResponse>.mapToListDrinkItems(): List<DrinkItem> = this.map {
    DrinkItem(
        id = it.id,
        name = it.name,
        imageURL = it.imageURL,
        price = it.price,
    )
}