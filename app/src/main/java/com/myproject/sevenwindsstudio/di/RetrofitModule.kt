package com.myproject.sevenwindsstudio.di

import com.myproject.data.remote.retrofit.RetrofitModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(retrofitModule: RetrofitModule): HttpLoggingInterceptor =
        retrofitModule.httpLoggingInterceptor()

    @Provides
    @Singleton
    fun provideHttpClient(
        retrofitModule: RetrofitModule,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        retrofitModule.httpClient(httpLoggingInterceptor)

    @Provides
    @Singleton
    fun provideRetrofit(
        retrofitModule: RetrofitModule,
        okHttpClient: OkHttpClient
    ): retrofit2.Retrofit =
        retrofitModule.retrofit(okHttpClient)
}
