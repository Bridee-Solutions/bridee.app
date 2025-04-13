package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionCircle(){

    Row (
        modifier = Modifier
            .width(70.dp)
    ) {
        Box(
            modifier =  Modifier
                .width(15.dp)
                .height(15.dp)
                .clip(shape = RoundedCornerShape(50))
                .background(
                    color = Color.Green
                )
        )
        Box(
            modifier =  Modifier
                .width(15.dp)
                .height(15.dp)
                .clip(shape = RoundedCornerShape(50))
                .background(
                    color = Color.Yellow
                )
        )
        Box(
            modifier =  Modifier
                .width(15.dp)
                .height(15.dp)
                .clip(shape = RoundedCornerShape(50))
                .background(
                    color = Color.Red
                )
        )
    }
}
