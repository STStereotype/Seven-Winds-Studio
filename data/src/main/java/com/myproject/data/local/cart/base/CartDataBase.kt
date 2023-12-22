package com.myproject.data.local.cart.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myproject.data.local.cart.room.dao.CartDao
import com.myproject.data.local.cart.room.dao.CartEntity

@Database(
    entities = [
    CartEntity::class
], version = 1, exportSchema = true
)
abstract class CartDataBase: RoomDatabase() {
    abstract fun cartDao(): CartDao
}
