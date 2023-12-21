package com.myproject.domain.usecase.authorization

import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.repository.authorization.AuthorizationRepository

class LogInUseCase(
    private val authorizationRepository: AuthorizationRepository
) {
    suspend fun execute(authorization: Authorization) = authorizationRepository.logIn(authorization)
}