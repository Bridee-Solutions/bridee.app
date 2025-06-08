package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.CustomModal
import com.example.bridee.core.navigation.Screen
import com.google.gson.Gson
import java.net.URLEncoder

@Composable
fun CategoriaScreen(viewModel: CalculadoraViewModel, navController: NavController) {
    var showModal by remember { mutableStateOf(false) }
    var novaCategoria by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val categorias = viewModel.orcamentoResponse?.itemOrcamentos
    val fornecedores = viewModel.orcamentoResponse?.orcamentoFornecedores

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(1.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categoria",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFF484646)
                )

                Text(
                    text = "+ CATEGORIA",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFD77C8C),
                    modifier = Modifier.clickable {
                        showModal = true
                    }
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            if(!categorias.isNullOrEmpty() || !fornecedores.isNullOrEmpty()){
                if(!fornecedores.isNullOrEmpty()){
                    FornecedorCard(
                        totalFornecedores = viewModel.orcamentoResponse!!.orcamentoFornecedores.size,
                        totalDespesas = viewModel.orcamentoResponse!!.totalDespesasFornecedor(),
                        openModal = {
                            navController.navigate(Screen.FornecedorDetalhes.route)
                        }
                    )
                }
                categorias?.forEachIndexed { index, item ->
                    val json = URLEncoder.encode(Gson().toJson(item), "UTF-8")
                    CategoriaCard(
                        item = item,
                        openModal = {
                            navController.navigate(
                                Screen.CategoriaDetalhes.createRoute(json)
                            )
                        },
                        viewModel = viewModel
                    )

                    if (index < categorias.size - 1) {
                        Divider(
                            color = Color(0xFFE8E8E8),
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }else{
                val defaultItens = viewModel.defaultItens()
                defaultItens.forEachIndexed{ index, item ->
                    val json = URLEncoder.encode(Gson().toJson(item), "UTF-8")
                    CategoriaCard(
                        item = item,
                        openModal = {
                            navController.navigate(
                                Screen.CategoriaDetalhes.createRoute(json)
                            )
                        },
                        viewModel = viewModel
                    )

                    if (index < defaultItens.size - 1) {
                        Divider(
                            color = Color(0xFFE8E8E8),
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }


    CustomModal (
        showModal = showModal,
        onDismissRequest = { showModal = false },
        title = "Adicionar nova categoria",
        content = {
            TextField(
                value = novaCategoria,
                onValueChange = { novaCategoria = it },
                label = { Text("Nome da categoria", style = MaterialTheme.typography.bodyMedium) },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent


                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
            )
        },
        onConfirm = {
            if (novaCategoria.text.isNotBlank()) {
                viewModel.adicionarNovaCategoria(null, novaCategoria.text)
                showModal = false
                novaCategoria = TextFieldValue("")
            }
        },
        onCancel = {
            showModal = false
        }
    )
}