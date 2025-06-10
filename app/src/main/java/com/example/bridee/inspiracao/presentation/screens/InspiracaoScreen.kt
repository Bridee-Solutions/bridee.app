package com.example.bridee.servicos.presentation.screens
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.bridee.inspiracao.domain.TelaInspiracaoViewModel
import com.example.bridee.inspiracao.presentation.components.Navegar

@Composable
fun InspiracaoScreen(
   viewModel: TelaInspiracaoViewModel,
   paddingValues: PaddingValues
) {

   Navegar(viewModel, paddingValues)
}

