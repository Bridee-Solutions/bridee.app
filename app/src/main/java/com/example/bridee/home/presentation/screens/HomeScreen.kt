package com.example.bridee.servicos.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import com.example.bridee.home.presentation.components.CountdownSection
import com.example.bridee.home.presentation.components.SuppliersList
import com.example.bridee.home.presentation.components.WeddingHeader
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        WeddingHeader(navController = navController)
        CountdownSection()
        SuppliersList()
    }}






