package com.example.bridee.servicos.presentation.screens

import SearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.bridee.core.navigation.Screen

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.servicos.domain.Subcategoria
import com.example.bridee.servicos.presentation.components.CardSubcategoria
import com.example.bridee.servicos.presentation.components.CategoriaExpansivelItem
import androidx.compose.foundation.layout.PaddingValues
import com.example.bridee.servicos.domain.getMockSubcategorias

@Composable
fun ServicosSubcategoriaScreen(
    navController: NavController,
    subcategoriaNome: String,
    paddingValues: PaddingValues
) {
    var searchText by remember { mutableStateOf("") }

    val listaSubcategorias = getMockSubcategorias()

    val listaFiltrada = listaSubcategorias.filter {
        it.nome.contains(searchText, ignoreCase = true) ||
                it.descricao.contains(searchText, ignoreCase = true)
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
                text = subcategoriaNome,
                fontSize = 22.sp,
                style = MaterialTheme.typography.titleLarge.copy(color = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                searchText = searchText,
                onSearchTextChanged = { newText -> searchText = newText },
                placeholderText = "Pesquisar",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (listaFiltrada.isEmpty()) {
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
                            text = "${listaFiltrada.size} resultado${if (listaFiltrada.size != 1) "s" else ""} encontrado${if (listaFiltrada.size != 1) "s" else ""}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    items(listaFiltrada) { subcategoria ->
                        CardSubcategoria(
                            subcategoria = subcategoria,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            onClick = {
                                navController.navigate(Screen.ServicosDetalhesScreen.route)
                            }
                        )
                    }
                }
            }
        }
    }}
