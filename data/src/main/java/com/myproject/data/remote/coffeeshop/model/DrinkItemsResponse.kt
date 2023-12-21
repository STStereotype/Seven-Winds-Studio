package com.myproject.data.remote.coffeeshop.model

import com.google.gson.annotations.SerializedName

data class DrinkItemsResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("price") val price: Int,
)
