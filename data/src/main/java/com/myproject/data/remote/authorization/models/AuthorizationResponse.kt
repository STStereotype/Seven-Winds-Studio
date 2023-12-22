package com.myproject.data.remote.authorization.models

import com.google.gson.annotations.SerializedName
import com.myproject.domain.models.authorization.AuthResponse

data class AuthorizationResponse(
    @SerializedName("token") val token: String,
    @SerializedName("tokenLifetime") val tokenLifetime: Int,
)

fun AuthorizationResponse.mapToAuthResponse(): AuthResponse = AuthResponse(
    token = this.token,
    tokenLifetime = this.tokenLifetime
)
