package com.myproject.sevenwindsstudio.di.domain

import com.myproject.domain.repository.cart.CartRepository
import com.myproject.domain.usecase.cart.AddCartItemUseCase
import com.myproject.domain.usecase.cart.FetchCartUseCase
import com.myproject.domain.usecase.cart.PlaceAnOrderUseCase
import com.myproject.domain.usecase.cart.DeleteCartItemUseCase
import com.myproject.domain.usecase.cart.UpdateCartItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CartDomainModule {
    @Provides
    @Singleton
    fun provideAddCartItemUseCase(cartRepository: CartRepository): AddCartItemUseCase =
        AddCartItemUseCase(cartRepository)

    @Provides
    @Singleton
    fun provideFetchCartUseCase(cartRepository: CartRepository): FetchCartUseCase =
        FetchCartUseCase(cartRepository)

    @Provides
    @Singleton
    fun providePlaceAnOrderUseCase(cartRepository: CartRepository): PlaceAnOrderUseCase =
        PlaceAnOrderUseCase(cartRepository)

    @Provides
    @Singleton
    fun provideRemoveCartItemUseCase(cartRepository: CartRepository): DeleteCartItemUseCase =
        DeleteCartItemUseCase(cartRepository)

    @Provides
    @Singleton
    fun provideUpdateCartItemUseCase(cartRepository: CartRepository): UpdateCartItemUseCase =
        UpdateCartItemUseCase(cartRepository)
}
