package com.myproject.sevenwindsstudio.screens.cart.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproject.domain.models.cart.CartItem
import com.myproject.sevenwindsstudio.screens.widgets.ButtonAction
import com.myproject.sevenwindsstudio.screens.widgets.Header
import com.myproject.sevenwindsstudio.screens.widgets.ListDrinksForCart
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun CartView(
    cart: CartItem,
    onBack: () -> Unit,
    onIncrease: (id: Int) -> Unit,
    onDecrease: (id: Int) -> Unit,
    placeAnOrder: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(
            title = "Ваш заказ",
            shouldUseBackButton = true,
            onBack = onBack
        )
        ListDrinksForCart(
            cart = cart,
            onDecrease = onDecrease,
            onIncrease = onIncrease
        )
        if (cart.drinks.isNotEmpty()) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    style = SevenWindsStudioTheme.typography.informationText,
                    text = "Время ожидания заказа\n" +
                            "15 минут!\n" +
                            "Спасибо, что выбрали нас!"
                )
            }
            ButtonAction(
                modifier = Modifier
                    .padding(start = 18.dp, end = 18.dp, bottom = 32.dp),
                title = "Оформить заказ",
                onClick = placeAnOrder
            )
        }
    }
}
