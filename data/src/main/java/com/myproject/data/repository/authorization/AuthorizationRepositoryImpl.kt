package com.myproject.data.repository.authorization

import com.myproject.data.remote.authorization.AuthorizationApi
import com.myproject.data.remote.authorization.models.RequestAuthorization
import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.repository.authorization.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val authorizationApi: AuthorizationApi
) : AuthorizationRepository {
    override suspend fun registration(authorization: Authorization) =
        authorizationApi.registration(convertAuthorizationToRequestAuthorization(authorization))

    override suspend fun logIn(authorization: Authorization) =
        authorizationApi.logIn(convertAuthorizationToRequestAuthorization(authorization))

    private fun convertAuthorizationToRequestAuthorization(
        authorization: Authorization
    ) : RequestAuthorization = RequestAuthorization(
        login = authorization.login,
        password = authorization.password
    )
}
