package com.example.bridee.servicos.presentation.components
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*


import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

import com.example.bridee.ui.theme.rosa
@Composable
fun SolicitarOrcamentoButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = rosa,
            contentColor = Color.White
        )
    ) {
        Text("Solicitar orçamento", color = Color.White)
    }
}
