package com.example.bridee.servicos.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    LaunchedEffect(true) {
        viewModel.findHomeInfo()
        viewModel.findCategories()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)

    ) {
        WeddingHeader(
            viewModel = viewModel,
            navController = navController)
        CountdownSection(viewModel)
        SuppliersList(viewModel)
    }}






