package com.example.bridee.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bridee.home.presentation.viewmodel.HomeViewModel

@Composable
fun associates(viewModel: HomeViewModel){
    val fornecedorResult = viewModel.searchFornecedorResult
    val assessorResult = viewModel.searchAssessorResult
    if(assessorResult.isNotEmpty()){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .offset(y = 5.dp)
        ) {
            items(assessorResult){
                AssociadoRow(
                    nome = it.nome,
                    isSelected = it.selected,
                    clickableEvent = {
                        viewModel.selectAssessor(it.id)
                    })
            }
        }
    }
    if(fornecedorResult.isNotEmpty()){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .offset(y = 5.dp)
        ) {
            items(fornecedorResult){
                AssociadoRow(
                    nome = it.nome,
                    isSelected = it.selected,
                    clickableEvent = {
                        viewModel.selectFornecedor(it.id!!)
                    })
            }
        }
    }
}