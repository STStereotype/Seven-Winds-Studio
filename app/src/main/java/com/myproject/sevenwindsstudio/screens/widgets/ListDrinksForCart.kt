package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproject.domain.models.cart.CartItem

@Composable
fun ColumnScope.ListDrinksForCart(
    cart: CartItem,
    onIncrease: (id: Int) -> Unit,
    onDecrease: (id: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 12.dp)
    ) {
        items(cart.drinks.size) { position ->
            DrinkListItemForCart(
                title = cart.drinks[position].name,
                price = cart.drinks[position].price,
                count = cart.drinks[position].count,
                onIncrease = {
                    onIncrease.invoke(cart.drinks[position].id)
                },
                onDecrease = {
                    onDecrease.invoke(cart.drinks[position].id)
                })
        }
    }
}
