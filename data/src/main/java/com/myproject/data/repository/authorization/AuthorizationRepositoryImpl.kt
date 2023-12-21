package com.myproject.data.repository.authorization

import com.myproject.data.remote.authorization.AuthorizationApi
import com.myproject.data.remote.authorization.models.AuthorizationRequest
import com.myproject.data.remote.authorization.models.AuthorizationResponse
import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.models.authorization.AuthResponse
import com.myproject.domain.repository.authorization.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val authorizationApi: AuthorizationApi
) : AuthorizationRepository {
    override suspend fun registration(authorization: Authorization): AuthResponse =
        convertAuthResponseToAuthorizationResponse(
            authorizationApi.registration(
                convertAuthorizationToRequestToAuthorization(authorization)
            )
        )

    override suspend fun logIn(authorization: Authorization): AuthResponse =
        convertAuthResponseToAuthorizationResponse(
            authorizationApi.logIn(
                convertAuthorizationToRequestToAuthorization(authorization)
            )
        )

    private fun convertAuthorizationToRequestToAuthorization(
        authorization: Authorization
    ): AuthorizationRequest = AuthorizationRequest(
        login = authorization.login,
        password = authorization.password,
    )

    private fun convertAuthResponseToAuthorizationResponse(
        authorizationResponse: AuthorizationResponse
    ): AuthResponse = AuthResponse(
        token = authorizationResponse.token,
        tokenLifetime = authorizationResponse.tokenLifetime,
    )
}
