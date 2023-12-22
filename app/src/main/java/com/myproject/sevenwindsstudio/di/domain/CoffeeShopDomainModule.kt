package com.myproject.sevenwindsstudio.di.domain

import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository
import com.myproject.domain.usecase.coffeeshop.FetchListDrinksUseCase
import com.myproject.domain.usecase.coffeeshop.FetchListEstablishmentsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoffeeShopDomainModule {
    @Provides
    @Singleton
    fun providePutListDrinksUseCase(coffeeShopRepository: CoffeeShopRepository) : FetchListDrinksUseCase =
        FetchListDrinksUseCase(coffeeShopRepository)

    @Provides
    @Singleton
    fun providePutListEstablishmentsUseCase(
        coffeeShopRepository: CoffeeShopRepository
    ) : FetchListEstablishmentsUseCase =
        FetchListEstablishmentsUseCase(coffeeShopRepository)
}
