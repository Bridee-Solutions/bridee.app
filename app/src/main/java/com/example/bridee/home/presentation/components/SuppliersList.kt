package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.home.presentation.viewmodel.HomeViewModel
import com.example.bridee.ui.components.CustomModal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuppliersList(
    viewModel: HomeViewModel
) {
    var showModal by remember { mutableStateOf(false) }
    var selectedCategoryId by remember { mutableIntStateOf(0) }
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

        items(viewModel.categories) { category ->
            FornecedorItem(
                category = category,
                onClick = {
                    selectedCategoryId = category.id
                    selectedCategory = category.nome
                    showModal = true
                }
            )
        }
    }

    CustomModal(
        showModal = showModal,
        onDismissRequest = { showModal = false },
        title = selectedCategory,
        onConfirm = {
            showModal = false
        },
        onCancel = { showModal = false },
        content = {
            var searchText by remember { mutableStateOf("") }
            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    viewModel.searchFornecedor(selectedCategoryId, it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(horizontal = 2.dp),
                placeholder = {  Text("Pesquisar ") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray,

                ),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            )

            val fornecedorResult = viewModel.searchFornecedorResult
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
    )
}