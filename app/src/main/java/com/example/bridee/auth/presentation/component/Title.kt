package com.example.bridee.auth.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun Title(fillPercentage: Dp){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "bridee.",
            fontSize = TextUnit(
                value = 48.0f,
                type = TextUnitType.Sp
            )
        )
        Text(
            text = "O match perfeito para o dia dos seus sonhos",
            fontSize = TextUnit(
                value = 16.0f,
                type = TextUnitType.Sp
            )
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.width(windowWidthDp - 100.dp)
                .clip(
                    shape = RoundedCornerShape(50)
                )
                .background(Color(0xFFE3E3E3))
        ) {
            LoadBar(fillPercentage)
        }
    }
}