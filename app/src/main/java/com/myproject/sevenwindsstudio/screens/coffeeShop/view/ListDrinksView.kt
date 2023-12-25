package com.myproject.sevenwindsstudio.screens.coffeeShop.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.sevenwindsstudio.screens.widgets.ButtonAction
import com.myproject.sevenwindsstudio.screens.widgets.Header
import com.myproject.sevenwindsstudio.screens.widgets.ListDrinks

@Composable
fun ListDrinksView(
    listDrinks: List<DrinkItem>,
    idAndCountDrinksInCart: Map<Int, Int>,
    onIncrease: (id: Int) -> Unit,
    onDecrease: (id: Int) -> Unit,
    onBack: () -> Unit,
    onProceedToPayment: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(
            title = "Меню",
            shouldUseBackButton = true,
            onBack = onBack
        )
        ListDrinks(
            drinks = listDrinks,
            onIncrease = onIncrease,
            onDecrease = onDecrease,
            idAndCountDrinksInCart = idAndCountDrinksInCart
        )
        ButtonAction(
            modifier = Modifier
                .padding(start = 18.dp, end = 18.dp, bottom = 32.dp),
            title = "Перейти к оплате",
            onClick = onProceedToPayment
        )
    }
}
