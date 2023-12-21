package com.myproject.data.remote.authorization

import com.myproject.data.remote.authorization.models.AuthorizationRequest
import com.myproject.data.remote.authorization.models.AuthorizationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {
    @POST("/auth/register")
    suspend fun registration(
        @Body request: AuthorizationRequest
    ): AuthorizationResponse

    @POST("/auth/login")
    suspend fun logIn(
        @Body request: AuthorizationRequest
    ): AuthorizationResponse
}
