package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bridee.convidados.domain.Convite

import androidx.compose.material3.ButtonDefaults
import com.example.bridee.ui.theme.rosa

@Composable
fun ConviteComponent(
    convite: Convite
) {
    Column(
        modifier = Modifier
            .border(
                width = 0.5.dp,
                color = Color(0xFF9B9B9B)
            )
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(convite.nome)
            Text(convite.ano)
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = rosa
                )
            ) {
                Text("Ver convite ->", color = Color.White)
            }
        }
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            convite.convidados.forEach {
                ConvidadoComponent(it)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}