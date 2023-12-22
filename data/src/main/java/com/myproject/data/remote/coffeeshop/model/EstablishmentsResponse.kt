package com.myproject.data.remote.coffeeshop.model

import com.google.gson.annotations.SerializedName
import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.domain.models.coffeeshop.PointLocation

data class EstablishmentsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("point") val point: Point,
)

data class Point(
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String,
)

fun List<EstablishmentsResponse>.mapToListEstablishmentItem(): List<EstablishmentItem> = this.map {
    EstablishmentItem(
        id = it.id,
        name = it.name,
        point = PointLocation(
            latitude = it.point.latitude,
            longitude = it.point.longitude,
        )
    )
}