package com.example.bridee.servicos.presentation.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import com.example.bridee.home.presentation.components.CountdownSection
import com.example.bridee.home.presentation.components.SuppliersList
import com.example.bridee.home.presentation.components.WeddingHeader
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.presentation.components.Calculadora.ControleDeGastoCard


@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        WeddingHeader(navController = navController)
        CountdownSection()
        SuppliersList()

    }}






