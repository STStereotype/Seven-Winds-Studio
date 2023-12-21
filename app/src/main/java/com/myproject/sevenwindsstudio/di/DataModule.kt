package com.myproject.sevenwindsstudio.di

import com.myproject.data.remote.authorization.AuthorizationApi
import com.myproject.data.remote.retrofit.RetrofitModule
import com.myproject.data.repository.authorization.AuthorizationRepositoryImpl
import com.myproject.domain.repository.authorization.AuthorizationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofitModule() : RetrofitModule =
        RetrofitModule()
    
    @Provides
    @Singleton
    fun provideAuthorizationApi(retrofit: Retrofit) : AuthorizationApi =
        retrofit.create(AuthorizationApi::class.java)

    @Provides
    @Singleton
    fun provideAuthorizationRepository(
        authorizationApi: AuthorizationApi
    ): AuthorizationRepository = AuthorizationRepositoryImpl(authorizationApi)
}
