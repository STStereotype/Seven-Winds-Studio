package com.myproject.domain.repository.authorization

import com.myproject.domain.models.authorization.Authorization


interface AuthorizationRepository {
    suspend fun registration(authorization: Authorization)
    suspend fun logIn(authorization: Authorization)
}
