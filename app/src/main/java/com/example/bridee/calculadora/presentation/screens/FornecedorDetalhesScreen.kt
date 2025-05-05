package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.presentation.components.Calculadora.ProgressIndicator
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.SubcategoriaItem
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.tituloCategoria
import java.math.BigDecimal
import java.math.RoundingMode

@Composable
fun FornecedorDetalhesScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculadoraViewModel,
    navController: NavController
){

    val totalGasto = viewModel.orcamentoResponse?.orcamentoGasto ?: BigDecimal(0)
    val orcamentoTotal = viewModel.orcamentoResponse?.orcamentoTotal ?: BigDecimal(0)
    val fornecedores = viewModel.orcamentoResponse?.orcamentoFornecedores ?: mutableListOf()

    Column (
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth()
    ) {
        tituloCategoria(
            nomeCategoria = "Fornecedores",
            icon = R.drawable.ic_fornecedores,
            navController = navController
        )
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

                val gastoPercentage = if(orcamentoTotal > BigDecimal(0)){
                    totalGasto.divide(orcamentoTotal, 2, RoundingMode.UP)
                }else{
                    BigDecimal(0)
                }
                ProgressIndicator(
                    text = "Total Gasto",
                    value = totalGasto,
                    percentage = gastoPercentage
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
                        text = "R$${orcamentoTotal.setScale(2, RoundingMode.DOWN)}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(1.dp))
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Fornecedores",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF484646),
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(fornecedores) { custo ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .padding(vertical = 8.dp, horizontal = 12.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Text(
                                    text = custo.fornecedor.nome,
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        color = Color(0xFF484646)
                                    )
                                )

                            }
                            Text(
                                text = "${custo.preco}",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = Color(0xFF484646)
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}