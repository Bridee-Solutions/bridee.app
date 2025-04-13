package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun ActionReport(){

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .width(screenWidth.dp - 60.dp)
                .height(120.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xC3C3C3C9),
                    shape = RoundedCornerShape(15)
                )
                .padding(start = 15.dp, top = 10.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ActionCircle()
            Row{
                Text("Relatório de convidados")
            }
            Row(
                modifier = Modifier.offset(y = (-10).dp)
            ){
                Text(
                    text = "5 convidados irão comparecer",
                    fontSize = TextUnit(
                        value = 12.0f,
                        type = TextUnitType.Sp
                    )
                )
            }
        }
    }

}