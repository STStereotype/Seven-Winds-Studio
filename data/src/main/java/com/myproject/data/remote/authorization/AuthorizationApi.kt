package com.myproject.data.remote.authorization

import com.myproject.data.remote.authorization.models.RequestAuthorization
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {
    @POST("/auth/register")
    suspend fun registration(@Body elementBody: RequestAuthorization)

    @POST("/auth/login")
    suspend fun logIn(@Body elementBody: RequestAuthorization)
}
