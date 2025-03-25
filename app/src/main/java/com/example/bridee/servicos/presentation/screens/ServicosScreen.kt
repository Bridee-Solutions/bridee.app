package com.example.bridee.servicos.presentation.screens

import SearchBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun ServicosScreen(navController: NavController) {

    var searchText by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        SearchBar(
            searchText = searchText,
            onSearchTextChanged = { newText -> searchText = newText},
            placeholderText = "Buscar serviços"
        )
    }
}
