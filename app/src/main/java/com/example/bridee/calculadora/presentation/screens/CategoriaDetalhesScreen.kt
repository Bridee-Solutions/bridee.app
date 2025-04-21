package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.ControleGastoDetalhes
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.Subcategorias
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.tituloCategoria




@Composable
fun CategoriaDetalhesScreen(nomeCategoria: String, icon: Int, navController: NavController, paddingValues: PaddingValues) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)

    ) {
        tituloCategoria(nomeCategoria, icon, navController)
        ControleGastoDetalhes()
        Subcategorias()
    }
}



