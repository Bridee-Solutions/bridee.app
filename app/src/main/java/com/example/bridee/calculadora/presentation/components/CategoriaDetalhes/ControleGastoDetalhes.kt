package com.example.bridee.calculadora.presentation.components.CategoriaDetalhes

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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.ui.theme.rosa
import java.math.BigDecimal
import java.math.RoundingMode

@Composable
fun ControleGastoDetalhes(
    viewModel: CalculadoraViewModel,
    modifier: Modifier = Modifier
) {

    val totalGasto = viewModel.orcamentoResponse?.orcamentoGasto
    val orcamentoTotal = viewModel.orcamentoResponse?.orcamentoTotal

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(19.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
    )  {
        Column(
            modifier = Modifier.
            padding(16.dp)
        ) {
            Text(
                text = "Controle de Gasto",
                color = Color(0xFF484646),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total gasto:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R$$totalGasto",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            // Barra de progresso
            LinearProgressIndicator(
                progress = { "${totalGasto?.divide(orcamentoTotal, 2, RoundingMode.UP)}".toFloat()},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(vertical = 4.dp),
                color = rosa,
                trackColor = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

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