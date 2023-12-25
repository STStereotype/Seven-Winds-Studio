package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.myproject.sevenwindsstudio.R
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun DrinkListItemForCart(
    title: String,
    price: Int,
    count: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Card(
        shape = SevenWindsStudioTheme.shape.cardShape,
        colors = CardDefaults.cardColors(
            containerColor = SevenWindsStudioTheme.colors.cardColor
        ),
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 3.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 10.dp, end = 10.dp, bottom = 9.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column{
                Text(
                    text = title,
                    style = SevenWindsStudioTheme.typography.primary
                )
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    style = SevenWindsStudioTheme.typography.secondary,
                    text = price.toString()
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onDecrease) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.akar_icons_minus),
                        contentDescription = null,
                        tint = SevenWindsStudioTheme.colors.primaryColor
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(horizontal = 9.dp),
                    style = SevenWindsStudioTheme.typography.cartDrinkCount,
                    text = count.toString()
                )
                IconButton(onClick = onIncrease) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.akar_icons_plus),
                        contentDescription = null,
                        tint = SevenWindsStudioTheme.colors.primaryColor
                    )
                }
            }
        }
    }
}
