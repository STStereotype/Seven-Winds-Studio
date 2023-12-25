package com.myproject.sevenwindsstudio.di

import com.myproject.sevenwindsstudio.screens.cart.CartViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ViewModelFactoryProvider {
    fun cartViewModelFactory(): CartViewModel.Factory
}
