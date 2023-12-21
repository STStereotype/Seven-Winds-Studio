package com.myproject.data.remote.coffeeshop.model

import com.google.gson.annotations.SerializedName

data class EstablishmentsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("point") val point: Point,
)

data class Point(
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String,
)