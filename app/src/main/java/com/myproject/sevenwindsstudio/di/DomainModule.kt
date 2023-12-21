package com.myproject.sevenwindsstudio.di

import com.myproject.domain.repository.authorization.AuthorizationRepository
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository
import com.myproject.domain.usecase.authorization.LogInUseCase
import com.myproject.domain.usecase.authorization.RegistrationUseCase
import com.myproject.domain.usecase.coffeeshop.PutListDrinksUseCase
import com.myproject.domain.usecase.coffeeshop.PutListEstablishmentsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
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

    @Provides
    @Singleton
    fun providePutListDrinksUseCase(coffeeShopRepository: CoffeeShopRepository) : PutListDrinksUseCase =
        PutListDrinksUseCase(coffeeShopRepository)

    @Provides
    @Singleton
    fun providePutListEstablishmentsUseCase(
        coffeeShopRepository: CoffeeShopRepository
    ) : PutListEstablishmentsUseCase =
        PutListEstablishmentsUseCase(coffeeShopRepository)
}
