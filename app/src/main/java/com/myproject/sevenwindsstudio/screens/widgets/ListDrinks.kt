package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import coil.size.Size
import com.myproject.domain.models.coffeeshop.DrinkItem

@Composable
fun ColumnScope.ListDrinks(
    drinks: List<DrinkItem>,
    idAndCountDrinksInCart: Map<Int,Int>,
    onIncrease: (id: Int) -> Unit,
    onDecrease: (id: Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .weight(1f),
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 17.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(drinks.size) { possition ->
                val drink = drinks[possition]
                DrinkListItem(
                    title = drink.name,
                    price = drink.price,
                    imageRequest = ImageRequest.Builder(LocalContext.current)
                        .data(drink.imageURL)
                        .size(Size.ORIGINAL)
                        .build(),
                    count = idAndCountDrinksInCart[drink.id] ?: 0,
                    onIncrease = {
                        onIncrease.invoke(drink.id)
                    },
                    onDecrease = {
                        onDecrease.invoke(drink.id)
                    })
            }
        }
    )
}
