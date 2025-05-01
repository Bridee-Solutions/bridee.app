package com.example.bridee.servicos.presentation.screens

import SearchBar
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bridee.servicos.presentation.components.CategoriaExpansivelItem
import com.example.bridee.servicos.presentation.components.CategoriaExpansivelItemState
import com.example.bridee.servicos.presentation.viewModel.CategoriasViewModel


@Composable
fun ServicosScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    val viewModel: CategoriasViewModel = viewModel()
    val categorias = viewModel.categorias

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Serviços",
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleLarge.copy(color = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                searchText = searchText,
                onSearchTextChanged = { newText -> searchText = newText },
                placeholderText = "Buscar serviços",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                showMenuIcon = false
            )
            Spacer(modifier = Modifier.height(16.dp))
        }


        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "Todas as categorias",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 19.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp),
                    color = Color.Black
                )
            }

            items(categorias) { categoria ->
                CategoriaExpansivelItem(
                    categoria = categoria,
                    navController = navController,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                )
            }
        }
    }
}