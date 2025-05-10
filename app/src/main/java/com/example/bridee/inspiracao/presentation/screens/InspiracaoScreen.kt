package com.example.bridee.servicos.presentation.screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bridee.inspiracao.domain.TelaInspiracaoViewModel
import com.example.bridee.inspiracao.presentation.components.Navegar

@Composable
fun InspiracaoScreen(viewModel: TelaInspiracaoViewModel, navController: NavController) {

   Navegar(viewModel)
}

