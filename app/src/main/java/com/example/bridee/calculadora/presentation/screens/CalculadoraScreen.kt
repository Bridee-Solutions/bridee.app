package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.presentation.components.Calculadora.CategoriaScreen
import com.example.bridee.calculadora.presentation.components.Calculadora.ControleDeGastoCard
import com.example.bridee.calculadora.presentation.components.Calculadora.FerramentasSection


@Composable
fun CalculadoraScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        FerramentasSection(navController)
        Spacer(modifier = Modifier.height(10.dp))
        ControleDeGastoCard()
        Spacer(modifier = Modifier.height(10.dp))
        CategoriaScreen(navController = navController)
    }
}

