package com.myproject.data.repository.authorization

import com.myproject.data.remote.authorization.AuthorizationApi
import com.myproject.data.remote.authorization.models.AuthorizationRequest
import com.myproject.data.remote.authorization.models.mapToAuthResponse
import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.models.authorization.AuthResponse
import com.myproject.domain.repository.authorization.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val authorizationApi: AuthorizationApi
) : AuthorizationRepository {
    override suspend fun registration(authorization: Authorization): AuthResponse =
        authorizationApi.registration(authorization.mapToRequestAuthorization()).mapToAuthResponse()

    override suspend fun logIn(authorization: Authorization): AuthResponse =
        authorizationApi.logIn(authorization.mapToRequestAuthorization()).mapToAuthResponse()

    private fun Authorization.mapToRequestAuthorization(): AuthorizationRequest =
        AuthorizationRequest(
            login = this.login,
            password = this.password,
        )
}
