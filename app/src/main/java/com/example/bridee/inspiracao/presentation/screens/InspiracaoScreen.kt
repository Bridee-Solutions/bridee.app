package com.example.bridee.servicos.presentation.screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bridee.auth.data.PexelsApi
import com.example.bridee.inspiracao.presentation.components.Navegar
import com.example.bridee.inspiracao.presentation.components.TelaInspiracao

@Composable
fun InspiracaoScreen(navController: NavController, pexelsApi: PexelsApi) {
   Navegar(pexelsApi)
}