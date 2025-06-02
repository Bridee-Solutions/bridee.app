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
import com.example.bridee.configuracoes.presentation.components.AccountDetailsCard
import com.example.bridee.configuracoes.presentation.components.ProfileCard
import com.example.bridee.configuracoes.presentation.components.ProfileDetailsCard
import com.example.bridee.configuracoes.presentation.components.WeddingDetailsCard
import androidx.navigation.NavController
import com.example.bridee.configuracoes.domain.ConfiguracaoInformation
import com.example.bridee.configuracoes.presentation.viewmodel.ConfiguracaoViewModel

@Composable
fun ConfiguracoesScreen(
    navController: NavController,
    viewModel: ConfiguracaoViewModel
) {
    var isEditing by remember { mutableStateOf(false) }

    var weddingDate by remember { mutableStateOf("11 de Fevereiro, 2026") }
    var weddingLocation by remember { mutableStateOf("São Paulo - SP") }
    var numberOfGuests by remember { mutableStateOf("100 Convidados") }
    var budget by remember { mutableStateOf("R$100.000 Orçamento") }

    var name by remember { mutableStateOf("Amanda Sousa") }
    var loveName by remember { mutableStateOf("Enzo Martins") }
    var phone by remember { mutableStateOf("11981819900") }

    var email by remember { mutableStateOf("amanda.sousa@sptech.school") }
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
            weddingDate = weddingDate,
            onWeddingDateChange = { weddingDate = it },
            weddingLocation = weddingLocation,
            onWeddingLocationChange = { weddingLocation = it },
            numberOfGuests = numberOfGuests,
            onNumberOfGuestsChange = { numberOfGuests = it },
            budget = budget,
            onBudgetChange = { budget = it }
        )
        ProfileDetailsCard(
            isEditing = isEditing,
            name = name,
            onNameChange = {name = it },
            loveName = loveName,
            onLoveNameChange = { loveName = it },
            phone = phone,
            onPhoneChange = {phone = it }
        )
        AccountDetailsCard(
            isEditing = isEditing,
            email = email,
            onEmailChange = {email = it}
        )
    }
}