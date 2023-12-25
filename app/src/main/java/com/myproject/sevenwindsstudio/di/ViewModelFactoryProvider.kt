package com.myproject.sevenwindsstudio.di

import com.myproject.sevenwindsstudio.screens.coffeeShop.CoffeeShopViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ViewModelFactoryProvider {
    fun coffeeShopViewModelFactory(): CoffeeShopViewModel.Factory
}
