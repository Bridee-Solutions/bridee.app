package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.math.BigDecimal
import java.math.RoundingMode

@Composable
fun GastoCard(
    orcamentoTotal: BigDecimal,
    orcamentoGasto: BigDecimal,
    onEditDialogOpen: () -> Unit
){

    val orcamentoRestante = orcamentoTotal.minus(orcamentoGasto).setScale(2, RoundingMode.DOWN)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(19.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
    )  {
        Column(
            modifier = Modifier.
            padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Controle de Gasto",
                    color = Color(0xFF484646),
                    style = MaterialTheme.typography.titleSmall
                )
                IconButton(
                    onClick = onEditDialogOpen
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar orçamento",
                        tint = Color(0xFF9B9B9B)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            val gastoPercentage = if(orcamentoTotal > BigDecimal(0)){
                orcamentoGasto.divide(orcamentoTotal, 2, RoundingMode.UP)
            }else{
                BigDecimal(0)
            }

            ProgressIndicator(
                text = "Total gasto:",
                value = orcamentoTotal,
                percentage = gastoPercentage
            )

            val restantePercentage = if(orcamentoTotal > BigDecimal(0)){
                orcamentoRestante.divide(orcamentoTotal, 2, RoundingMode.UP)
            }else{
                BigDecimal(0)
            }

            ProgressIndicator(
                text = "Resta:",
                value = orcamentoRestante,
                percentage = restantePercentage
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Orçamento total:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R$$orcamentoTotal",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

}