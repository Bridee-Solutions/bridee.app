package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.home.domain.Fornecedor
import androidx.compose.ui.Modifier
import com.example.bridee.calculadora.presentation.components.Calculadora.ControleDeGastoCard
import com.seuapp.presentation.components.CustomModal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuppliersList() {
    var showModal by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFDF8F4))
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Complete a sua equipe de fornecedores",
                style = MaterialTheme.typography.titleSmall.copy(fontSize = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }

        val fornecedores = listOf(
            Fornecedor("Assessor", "Buscar fornecedores", false, R.drawable.wedding_day),
            Fornecedor("Local", "Buscar fornecedores", false, R.drawable.hospedagem),
            Fornecedor("Florista", "Buscar fornecedores", false, R.drawable.buqueflores),
            Fornecedor("Buffet e Gastronomia", "Buscar fornecedores", false, R.drawable.buffet),
            Fornecedor("Vestido", "Buscar fornecedores", false, R.drawable.weddingdress),
            Fornecedor("Fotógrafo", "Buscar fornecedores", false, R.drawable.fotografia),
            Fornecedor("Decoração", "Buscar fornecedores", false, R.drawable.arch),
            Fornecedor("Hospedagem", "Buscar fornecedores", false, R.drawable.honeymoon),
            Fornecedor("Confeitaria", "Buscar fornecedores", false, R.drawable.cake),
            Fornecedor("Moda e Beleza", "Buscar fornecedores", false, R.drawable.cosmetics),
            Fornecedor("Videógrafos", "Buscar fornecedores", false, R.drawable.videographer),
            Fornecedor("Papelaria", "Buscar fornecedores", false, R.drawable.letter),
            Fornecedor("Entretenimento", "Buscar fornecedores", false, R.drawable.confetti)
        )

        items(fornecedores) { fornecedor ->
            FornecedorItem(
                fornecedor = fornecedor,
                onClick = {
                    selectedCategory = fornecedor.nome
                    showModal = true
                }
            )
        }


    }
    CustomModal(
        showModal = showModal,
        onDismissRequest = { showModal = false },
        title = "$selectedCategory",
        onConfirm = {

            showModal = false
        },
        onCancel = { showModal = false },
        content = {
            var searchText by remember { mutableStateOf("") }

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                placeholder = {  Text("Pesquisar ${
                    selectedCategory.replaceFirstChar { it.lowercase() }
                }") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                ),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            )


        }
    )
}