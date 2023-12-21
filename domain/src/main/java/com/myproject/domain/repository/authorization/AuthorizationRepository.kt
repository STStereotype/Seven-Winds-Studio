package com.myproject.domain.repository.authorization

import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.models.authorization.AuthResponse


interface AuthorizationRepository {
    suspend fun registration(authorization: Authorization): AuthResponse
    suspend fun logIn(authorization: Authorization): AuthResponse
}
