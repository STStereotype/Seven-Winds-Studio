package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.myproject.sevenwindsstudio.R
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun DrinkListItem(
    title: String,
    price: Int,
    imageRequest: ImageRequest,
    count: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Card(
        shape = SevenWindsStudioTheme.shape.cardShape,
        colors = CardDefaults.cardColors(
            containerColor = SevenWindsStudioTheme.colors.background
        ),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp),
            painter = rememberAsyncImagePainter(
                model = imageRequest),
            contentScale = ContentScale.FillWidth,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(start = 11.dp, end = 5.dp, top = 11.dp, bottom = 11.dp)
        ) {
            Text(
                style = SevenWindsStudioTheme.typography.cardDrinkName,
                text = title,
                maxLines = 1
            )
            Row(
                modifier = Modifier
                    .padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    style = SevenWindsStudioTheme.typography.cardDrinkPrice,
                    text = price.toString()
                )
                if (count > 0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onDecrease) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                painter = painterResource(id = R.drawable.akar_icons_minus),
                                contentDescription = null,
                                tint = SevenWindsStudioTheme.colors.cardColor
                            )
                        }
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 9.dp),
                            style = SevenWindsStudioTheme.typography.cardDrinkCount,
                            text = count.toString()
                        )
                        IconButton(onClick = onIncrease) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                painter = painterResource(id = R.drawable.akar_icons_plus),
                                contentDescription = null,
                                tint = SevenWindsStudioTheme.colors.cardColor
                            )
                        }
                    }
                } else {
                    Button(
                        contentPadding = PaddingValues(vertical = 5.dp, horizontal = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = SevenWindsStudioTheme.colors.buttonColor
                        ),
                        onClick = onIncrease
                    ) {
                        Text(
                            style = SevenWindsStudioTheme.typography.cardDrinkPrice.copy(
                                color = SevenWindsStudioTheme.colors.buttonTextColor
                            ),
                            text = "Добавить"
                        )
                    }
                }
            }
        }
    }
}