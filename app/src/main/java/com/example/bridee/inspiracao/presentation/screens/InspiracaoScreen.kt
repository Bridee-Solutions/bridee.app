package com.example.bridee.servicos.presentation.screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.bridee.inspiracao.domain.TelaInpiracaoViewModel
import com.example.bridee.inspiracao.presentation.components.Navegar

@Composable
fun InspiracaoScreen(viewModel: TelaInpiracaoViewModel, navController: NavController) {

   Navegar(viewModel)
}

