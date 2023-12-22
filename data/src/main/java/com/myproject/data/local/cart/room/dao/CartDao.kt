package com.myproject.data.local.cart.room.dao

import androidx.room.Dao
import androidx.room.Ignore
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {
    @Query("SELECT * FROM ${CartEntity.TABLE_NAME}")
    fun loadCart(): List<CartEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCartItem(entities: CartEntity)

    @Query("UPDATE ${CartEntity.TABLE_NAME} SET drinks = :drinks WHERE establishment = :establishment")
    fun updateDrinks(establishment: String, drinks: String)

    @Query("DELETE FROM ${CartEntity.TABLE_NAME} WHERE establishment = :establishment")
    fun deleteItem(establishment: String)
}
