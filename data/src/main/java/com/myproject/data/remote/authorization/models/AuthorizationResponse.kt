package com.myproject.data.remote.authorization.models

import com.google.gson.annotations.SerializedName

data class AuthorizationResponse(
    @SerializedName("token") val token: String,
    @SerializedName("tokenLifetime") val tokenLifetime: Int,
)