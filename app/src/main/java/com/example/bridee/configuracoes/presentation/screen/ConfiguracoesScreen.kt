package com.example.bridee.configuracoes.presentation.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bridee.configuracoes.presentation.components.AccountDetailsCard
import com.example.bridee.configuracoes.presentation.components.ProfileCard
import com.example.bridee.configuracoes.presentation.components.ProfileDetailsCard
import com.example.bridee.configuracoes.presentation.components.WeddingDetailsCard
import com.example.bridee.configuracoes.presentation.viewmodel.ConfiguracaoViewModel

@Composable
fun ConfiguracoesScreen(
    navController: NavController,
    viewModel: ConfiguracaoViewModel
) {
    var isEditing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .verticalScroll(rememberScrollState())
    ) {
        ProfileCard(
            navController = navController,
            isEditing = isEditing,
            onEditClick = { isEditing = !isEditing },
            viewModel = viewModel
        )
        WeddingDetailsCard(
            isEditing = isEditing,
            viewModel = viewModel
        )
        ProfileDetailsCard(
            isEditing = isEditing,
            viewModel = viewModel
        )
        AccountDetailsCard(
            viewModel = viewModel
        )
    }
}