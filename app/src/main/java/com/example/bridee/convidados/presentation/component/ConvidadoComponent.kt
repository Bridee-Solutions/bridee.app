package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.bridee.convidados.domain.Convidado

@Composable
fun ConvidadoComponent(
    convidado: Convidado
){

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Spacer(modifier = Modifier.height(10.dp))
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row (
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width((screenWidth * 0.5).dp)
                .padding(20.dp, 0.dp)
        ) {
            ActionCircle(
                color = Color.Green
            )
            Text(
                text = convidado.nome,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width((screenWidth * 0.5).dp)
                .padding(end = 12.dp)
        ) {

            Text(
                text = convidado.tipo,
                modifier = Modifier
                    .clip(RoundedCornerShape(15f))
                    .background(
                        color = Color(0xFFC1C1C1)
                    )
                    .padding(4.dp)
            )

            Text(
                text = convidado.faixaEtaria,
                modifier = Modifier
                    .clip(RoundedCornerShape(15f))
                    .background(
                        color = Color(0xFFEFEAEA)
                    )
                    .padding(4.dp)
            )
        }
    }
}