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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.CustomModal
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.pretoMedio
import com.example.bridee.ui.theme.rosa
import java.math.BigDecimal
import java.math.RoundingMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControleDeGastoCard(viewModel: CalculadoraViewModel) {

    val orcamento = viewModel.orcamentoResponse
    val orcamentoTotal = orcamento?.orcamentoTotal ?: BigDecimal(0)
    val orcamentoGasto = orcamento?.orcamentoGasto ?: BigDecimal(0)
    val orcamentoRestante = orcamentoTotal.minus(orcamentoGasto)

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
                    onClick = { viewModel.showEditDialog = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar orçamento",
                        tint = Color(0xFF9B9B9B)
                    )
                }
            }

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
                    text = "R$${orcamentoGasto}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            val gastoPercentage = if(orcamentoTotal > BigDecimal(0)){
                orcamentoGasto.divide(orcamentoTotal, 2, RoundingMode.UP)
            }else{
                BigDecimal(0)
            }
            LinearProgressIndicator(
                progress = "$gastoPercentage".toFloat(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(vertical = 4.dp),
                color = rosa
            )

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Resta:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R$$orcamentoRestante",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            val restantePercentage = if(orcamentoTotal > BigDecimal(0)){
                orcamentoRestante.divide(orcamentoTotal, 2, RoundingMode.UP)
            }else{
                BigDecimal(0)
            }
            LinearProgressIndicator(
                progress = "${restantePercentage}".toFloat(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(vertical = 4.dp),
                color = rosa
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


    CustomModal(
        showModal = viewModel.showEditDialog,
        onDismissRequest = { viewModel.showEditDialog = false },
        title = "Editar orçamento geral",
        content = {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Orçamento atual: $orcamentoTotal",
                    color = pretoMedio,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(bottom = 6.dp),
                )
                OutlinedTextField(
                    value = viewModel.novoOrcamento,
                    onValueChange = { novoValor ->
                        viewModel.novoOrcamento = novoValor.filter { it.isDigit() }
                    },
                    label = {
                        Text("Novo orçamento",
                            style = MaterialTheme.typography.bodySmall,
                            color = pretoMedio
                        ) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    leadingIcon = {
                        Text(
                            text = "R$",
                            style = MaterialTheme.typography.bodyLarge,
                            color = cinza
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = cinza,
                        unfocusedBorderColor = cinza
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }
        },
        onConfirm = {
            viewModel.updateCasamentoOrcamento()
            viewModel.showEditDialog = false
        },
        onCancel = {
            viewModel.novoOrcamento = ""
            viewModel.showEditDialog = false
        }
    )
}