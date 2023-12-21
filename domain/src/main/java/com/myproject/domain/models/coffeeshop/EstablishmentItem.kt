package com.myproject.domain.models.coffeeshop

data class EstablishmentItem(
    val id: Int,
    val name: String,
    val point: PointLocation,
)

data class PointLocation(
    val latitude: String,
    val longitude: String,
)
