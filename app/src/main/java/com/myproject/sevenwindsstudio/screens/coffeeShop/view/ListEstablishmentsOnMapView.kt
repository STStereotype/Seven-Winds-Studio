package com.myproject.sevenwindsstudio.screens.coffeeShop.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.sevenwindsstudio.screens.widgets.Header

@Composable
fun ListEstablishmentsOnMapView(
    listEstablishments: List<EstablishmentItem>,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(
            title = "Карта",
            shouldUseBackButton = true,
            onBack = onBack
        )
    }
}
