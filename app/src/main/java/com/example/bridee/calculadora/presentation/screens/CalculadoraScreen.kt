package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.presentation.components.Calculadora.CategoriaScreen
import com.example.bridee.calculadora.presentation.components.Calculadora.ControleDeGastoCard
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection


@Composable
fun CalculadoraScreen(viewModel: CalculadoraViewModel, navController: NavController) {
    val scrollState = rememberScrollState()
    LaunchedEffect(true) {
        viewModel.findCasamentoOrcamento()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        FerramentasSection(navController, Tool.CALCULADORA);
        Spacer(modifier = Modifier.height(10.dp))
        ControleDeGastoCard(viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        CategoriaScreen(viewModel, navController = navController)
    }
}

