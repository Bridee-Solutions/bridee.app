package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun OpcaoModal(
    showModal: Boolean,
    onDismissRequest: () -> Unit,
    openEditModal: () -> Unit,
    delete: () -> Unit,
    cancel: () -> Unit
){

    if(showModal){
        Dialog(
            onDismissRequest = onDismissRequest
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1.5f/10)
                    .clip(RoundedCornerShape(12.dp)),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .height(100.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título
                    Text(
                        text = "Editar orçamento da subcategoria",
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = TextUnit(
                            value = 14f,
                            type = TextUnitType.Sp
                        ),
                        modifier = Modifier.clickable(
                            onClick = openEditModal
                        )
                    )
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    HorizontalDivider(modifier = Modifier
                        .border(
                            width = 0.5.dp,
                            color = Color(0xFF595656)
                        )
                        .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    Text(
                        text = "Remover subcategoria",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Red,
                        fontSize = TextUnit(
                            value = 14f,
                            type = TextUnitType.Sp
                        ),
                        modifier = Modifier.clickable(
                            onClick = delete
                        )
                    )
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    HorizontalDivider(modifier = Modifier
                        .border(
                            width = 0.5.dp,
                            color = Color(0xFF595656)
                        )
                    )
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    Text(
                        text = "Cancelar",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF595656),
                        fontSize = TextUnit(
                            value = 14f,
                            type = TextUnitType.Sp
                        ),
                        modifier = Modifier.clickable(
                            onClick = cancel
                        )
                    )
                }
            }
        }
    }
}
