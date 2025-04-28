package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.domain.ItemOrcamentoResponse
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.ControleGastoDetalhes
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.Subcategorias
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.tituloCategoria
import java.math.BigDecimal


@Composable
fun CategoriaDetalhesScreen(
    viewModel: CalculadoraViewModel,
    item: ItemOrcamentoResponse,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        tituloCategoria(item.tipo, item.defineIcon(), navController)
        ControleGastoDetalhes(viewModel)
        Subcategorias(viewModel, item)
    }
}



