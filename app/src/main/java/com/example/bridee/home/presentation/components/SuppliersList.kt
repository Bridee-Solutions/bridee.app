package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.home.domain.Fornecedor
import androidx.compose.ui.Modifier

@Composable
fun SuppliersList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
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
            Fornecedor("Assessor", "Buscar fornecedores", true, R.drawable.novoassessor),
            Fornecedor("Local", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Florista", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Buffet e Gastronomia", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Vestido", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Fotógrafo", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Decoração", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Hospedagem", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Confeitaria", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Moda e Beleza", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Videógrafos", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Papelaria", "Buscar fornecedores", false, R.drawable.novoassessor),
            Fornecedor("Entretenimento", "Buscar fornecedores", false, R.drawable.novoassessor)
        )

        items(fornecedores) { fornecedor ->
            FornecedorItem(fornecedor = fornecedor)
        }
    }
}