package com.myproject.data.remote.authorization.models

import com.google.gson.annotations.SerializedName

data class AuthorizationRequest(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
)
