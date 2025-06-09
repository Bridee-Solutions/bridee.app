package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.CustomModal
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.pretoMedio
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControleDeGastoCard(viewModel: CalculadoraViewModel) {

    val orcamento = viewModel.orcamentoResponse
    val orcamentoTotal = orcamento?.orcamentoTotal ?: BigDecimal(0)
    val orcamentoGasto = orcamento?.orcamentoGasto ?: BigDecimal(0)

    GastoCard(orcamentoTotal, orcamentoGasto, {
        viewModel.showEditDialog = true
    })

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