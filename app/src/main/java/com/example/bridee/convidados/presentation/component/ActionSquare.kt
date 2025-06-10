package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun ActionSquare(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Column(
        modifier = modifier
            .width((screenWidth * 0.40).dp)
            .height(100.dp)
            .border(
                width = 1.dp,
                color = Color(0xC3C3C3C9),
                shape = RoundedCornerShape(15)
            )
            .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        content()
    }
}