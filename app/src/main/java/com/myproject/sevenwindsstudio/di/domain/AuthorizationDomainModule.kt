package com.myproject.sevenwindsstudio.di.domain

import com.myproject.domain.repository.authorization.AuthorizationRepository
import com.myproject.domain.usecase.authorization.LogInUseCase
import com.myproject.domain.usecase.authorization.RegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthorizationDomainModule {
    @Provides
    @Singleton
    fun provideLogInUseCase(authorizationRepository: AuthorizationRepository) : LogInUseCase =
        LogInUseCase(authorizationRepository)

    @Provides
    @Singleton
    fun provideRegistrationUseCase(
        authorizationRepository: AuthorizationRepository
    ) : RegistrationUseCase =
        RegistrationUseCase(authorizationRepository)
}