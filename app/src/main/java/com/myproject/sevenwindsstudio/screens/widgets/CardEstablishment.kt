package com.myproject.sevenwindsstudio.screens.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproject.sevenwindsstudio.ui.theme.SevenWindsStudioTheme

@Composable
fun CardEstablishment(
    titleCard: String,
    distanceToMe: String? = null,
    onClick: () -> Unit
) {
   Card(
       shape = SevenWindsStudioTheme.shape.cardShape,
       colors = CardDefaults.cardColors(
           containerColor = SevenWindsStudioTheme.colors.background
       ),
       modifier = Modifier
           .padding(horizontal = 15.dp, vertical = 3.dp)
           .fillMaxWidth(),
       elevation = CardDefaults.cardElevation(
           defaultElevation = 3.dp
       ),
   ) {
       Button(
           modifier = Modifier
               .fillMaxWidth(),
           onClick = onClick,
           colors = ButtonDefaults.buttonColors(
               containerColor = SevenWindsStudioTheme.colors.cardColor,
           ),
           shape = SevenWindsStudioTheme.shape.cardShape,
           contentPadding = PaddingValues(horizontal = 18.dp, vertical = 15.dp)
       ) {
           Column(
               modifier = Modifier
                   .fillMaxWidth(),
           ){
               Text(
                   text = titleCard,
                   style = SevenWindsStudioTheme.typography.primary
               )
               if (distanceToMe != null)
                   Text(
                       modifier = Modifier
                           .padding(top = 5.dp),
                       style = SevenWindsStudioTheme.typography.secondary,
                       text = distanceToMe
                   )
           }
       }
   }
}
