package com.myproject.sevenwindsstudio.di.data

import com.myproject.data.remote.coffeeshop.CoffeeShopApi
import com.myproject.data.repository.coffeeshop.CoffeeShopRepositoryImpl
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoffeeShopDataModule {
    @Provides
    @Singleton
    fun provideCoffeeShopApi(retrofit: Retrofit): CoffeeShopApi =
        retrofit.create(CoffeeShopApi::class.java)

    @Provides
    @Singleton
    fun provideCoffeeShopRepository(coffeeShopApi: CoffeeShopApi): CoffeeShopRepository =
        CoffeeShopRepositoryImpl(coffeeShopApi)
}
