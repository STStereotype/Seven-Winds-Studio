package com.myproject.data.local.cart.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myproject.data.local.cart.room.dao.CartEntity.Companion.TABLE_NAME
import com.myproject.domain.models.cart.CartDrinkItem
import com.myproject.domain.models.cart.CartItem
import java.lang.reflect.Type

@Entity(tableName = TABLE_NAME)
data class CartEntity(
    @PrimaryKey
    @ColumnInfo(name = "establishment")
    val establishment: String,

    @ColumnInfo(name = "drinks")
    val drinks: String,
) {
    companion object {
        const val TABLE_NAME = "cart_entity_table"
    }
}

fun CartEntity.mapToCartItem(gson: Gson): CartItem {
    val type: Type = object : TypeToken<ArrayList<CartDrinkItem>>() {}.type
    return CartItem(
        establishment = this.establishment,
        drinks = gson.fromJson(this.drinks, type)
    )
}
