package com.example.bridee.configuracoes.presentation.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bridee.configuracoes.presentation.components.AccountDetailsCard
import com.example.bridee.configuracoes.presentation.components.ProfileCard
import com.example.bridee.configuracoes.presentation.components.ProfileDetailsCard
import com.example.bridee.configuracoes.presentation.components.WeddingDetailsCard
import androidx.navigation.NavController

@Composable
fun ConfiguracoesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .verticalScroll(rememberScrollState())
    ) {
        ProfileCard(navController = navController)
        WeddingDetailsCard()
        ProfileDetailsCard()
        AccountDetailsCard()
    }
}