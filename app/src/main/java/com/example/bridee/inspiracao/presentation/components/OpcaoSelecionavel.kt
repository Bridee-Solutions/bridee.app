package com.example.bridee.inspiracao.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OpcaoSelecionavel(
    texto: String,
    selecionado: String,
    onClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onClick(texto) }
            .background(
                if (selecionado == texto) Color.White else Color(0xFFE9E9E9),
                RoundedCornerShape(5.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = texto,
            color = if (selecionado == texto) Color.Black else Color.Gray
        )
    }
}
