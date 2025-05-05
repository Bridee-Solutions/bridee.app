package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CategoryBox(
    quantity: String,
    type: String
){

    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFDD7B78),
                    shape = RoundedCornerShape(10f)
                )
                .width(30.dp),
        ) {
            Text(
                text = quantity,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        VerticalDivider(
            modifier = Modifier.width(5.dp)
        )
        Text(
            text = type
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
}