package com.myproject.sevenwindsstudio.di.data

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.myproject.data.local.cart.base.CartDataBase
import com.myproject.data.repository.cart.CartRepositoryImpl
import com.myproject.domain.repository.cart.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CartDataModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            CartDataBase::class.java,
            name = "seven_winds_studio_database"
        )
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideCartRepository(cartDataBase: CartDataBase): CartRepository =
        CartRepositoryImpl(Gson(), cartDataBase.cartDao())
}
