package com.myproject.domain.models.authorization

data class AuthResponse(
    val token: String,
    val tokenLifetime: Int,
)
