package com.myproject.sevenwindsstudio.screens.coffeeShop.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.sevenwindsstudio.screens.widgets.ButtonAction
import com.myproject.sevenwindsstudio.screens.widgets.CardEstablishment
import com.myproject.sevenwindsstudio.screens.widgets.Header

@Composable
fun ListEstablishmentsView(
    listEstablishments: List<EstablishmentItem>,
    onClickEstablishment: (idEstablishment: Int) -> Unit,
    onClickMap: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(
            title = "Ближайшие кофейни",
            shouldUseBackButton = true,
            onBack = onBack
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(top = 12.dp)
        ) {
            items(listEstablishments.size) { index ->
                CardEstablishment(
                    titleCard = listEstablishments[index].name,
                    onClick = {
                        onClickEstablishment.invoke(listEstablishments[index].id)
                    }
                )
            }
        }
        ButtonAction(
            modifier = Modifier
                .padding(start = 18.dp, end = 18.dp, bottom = 32.dp),
            title = "На карте",
            onClick = onClickMap
        )
    }
}
