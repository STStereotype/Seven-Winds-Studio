package com.myproject.sevenwindsstudio.di

import com.myproject.data.remote.authorization.AuthorizationApi
import com.myproject.data.remote.coffeeshop.CoffeeShopApi
import com.myproject.data.remote.retrofit.RetrofitModule
import com.myproject.data.repository.authorization.AuthorizationRepositoryImpl
import com.myproject.data.repository.coffeeshop.CoffeeShopRepositoryImpl
import com.myproject.domain.repository.authorization.AuthorizationRepository
import com.myproject.domain.repository.coffeeshop.CoffeeShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofitModule(): RetrofitModule =
        RetrofitModule()

    @Provides
    @Singleton
    fun provideAuthorizationApi(retrofit: Retrofit): AuthorizationApi =
        retrofit.create(AuthorizationApi::class.java)

    @Provides
    @Singleton
    fun provideAuthorizationRepository(
        authorizationApi: AuthorizationApi
    ): AuthorizationRepository = AuthorizationRepositoryImpl(authorizationApi)

    @Provides
    @Singleton
    fun provideCoffeeShopApi(retrofit: Retrofit): CoffeeShopApi =
        retrofit.create(CoffeeShopApi::class.java)

    @Provides
    @Singleton
    fun provideCoffeeShopRepository(coffeeShopApi: CoffeeShopApi): CoffeeShopRepository =
        CoffeeShopRepositoryImpl(coffeeShopApi)
}
