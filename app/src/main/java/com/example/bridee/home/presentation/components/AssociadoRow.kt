package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AssociadoRow(
    nome: String,
    isSelected: Boolean,
    clickableEvent: () -> Unit
){
    val selectedBackgroundColor = Color(0XFFDD7B78)

    Row(
        modifier = Modifier.fillMaxWidth()
            .height(60.dp)
            .padding(5.dp)
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(10f),
                color = Color(0XFFEAEAEA)
            )
            .background(color = if(isSelected) selectedBackgroundColor else Color.White)
            .clickable(true){
                clickableEvent()
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = nome,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}