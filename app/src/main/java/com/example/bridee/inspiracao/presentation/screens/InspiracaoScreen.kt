package com.example.bridee.servicos.presentation.screens
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bridee.inspiracao.domain.TelaInpiracaoViewModel
import com.example.bridee.inspiracao.presentation.components.Navegar

@Composable
fun InspiracaoScreen(
   viewModel: TelaInpiracaoViewModel,
   navController: NavController,
   paddingValues: PaddingValues) {

   Navegar(viewModel, paddingValues)
}

