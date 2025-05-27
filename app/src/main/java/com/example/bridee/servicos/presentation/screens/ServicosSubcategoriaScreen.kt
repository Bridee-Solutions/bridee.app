package com.example.bridee.servicos.presentation.screens

import SearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.core.navigation.Screen
import com.example.bridee.servicos.presentation.components.CardAssociado
import com.example.bridee.servicos.presentation.viewModel.ServicosDetalhesViewModel

@Composable
fun ServicosSubcategoriaScreen(
    navController: NavController,
    viewModel: ServicosDetalhesViewModel,
    paddingValues: PaddingValues
) {
    val associadoResponse = viewModel.associadoResponseDto
    var searchText by remember { mutableStateOf("") }
    LaunchedEffect(true) {
        viewModel.loadFornecedorDetails()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = viewModel.subcategoriaNome,
                fontSize = 22.sp,
                style = MaterialTheme.typography.titleLarge.copy(color = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                searchText = searchText,
                onSearchTextChanged = {
                    newText -> searchText = newText
                    viewModel.loadFornecedorDetails()
                },
                placeholderText = "Pesquisar",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (associadoResponse.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Nenhum serviço encontrado",
                    color = Color.Gray
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {


                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 2.dp)
                ) {
                    item {
                        Text(
                            text = "${associadoResponse.size} " +
                                    "resultado${if (associadoResponse.size != 1) "s" else ""} " +
                                    "encontrado${if (associadoResponse.size != 1) "s" else ""}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    items(associadoResponse) { associado ->
                        CardAssociado(
                            associado = associado,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            onClick = {
                                navController.navigate(Screen.ServicosDetalhesScreen.createRoute(associado.id))
                            }
                        )
                    }
                }
            }
        }
    }
}
