package com.example.bridee.servicos.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bridee.home.presentation.components.CountdownSection
import com.example.bridee.home.presentation.components.SuppliersList
import com.example.bridee.home.presentation.components.WeddingHeader
import com.example.bridee.home.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController,
    paddingValues: PaddingValues
) {
    val homeResponse by viewModel.homeResponse
    LaunchedEffect(true) {
        viewModel.findHomeInfo()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)

    ) {
        WeddingHeader(
            homeResponseDto = homeResponse,
            navController = navController)
        CountdownSection()
        SuppliersList()
    }}






