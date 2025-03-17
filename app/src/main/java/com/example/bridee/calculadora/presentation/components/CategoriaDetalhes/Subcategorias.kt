package com.example.bridee.calculadora.presentation.components.CategoriaDetalhes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.domain.SubcategoriaItemData
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.pretoMedio

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Subcategorias() {
    val subcategoriasList = listOf(
        SubcategoriaItemData("Vestido de madrinha", "R$500"),
        SubcategoriaItemData("Sapato de madrinha",  "R$700"),
        SubcategoriaItemData("Vestido de noiva", "R$6.000"),
        SubcategoriaItemData("Maquiagem",  "R$1.200"),
        SubcategoriaItemData("Acessórios",  "R$950")
    )

    var showAddSubcategoriaModal by remember { mutableStateOf(false) }

    Column( //
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(1.dp))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Subcategorias",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF484646),
            )

            Text(
                text = "+ SUBCATEGORIA",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFD77C8C),
                modifier = Modifier.clickable {showAddSubcategoriaModal = true  }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(subcategoriasList) { item ->
                SubcategoriaItem(item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    CustomModal (
        showModal = showAddSubcategoriaModal,
        onDismissRequest = { showAddSubcategoriaModal = false },
        title = "Adicionar subcategoria",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                ,
                horizontalAlignment = Alignment.Start
            ) {

                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
                    label = {
                        Text(
                            text = "Nome da Subcategoria",
                            style = MaterialTheme.typography.bodyMedium,
                            color = pretoMedio
                        )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = cinza,
                        unfocusedBorderColor = cinza
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )


                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            text = "Orçamento",
                            style = MaterialTheme.typography.bodyMedium,
                            color = pretoMedio
                        )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = cinza,
                        unfocusedBorderColor = cinza
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    leadingIcon = {
                        Text(
                            text = "R$",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        onConfirm = {

            println("Subcategoria salva!")
            showAddSubcategoriaModal = false
        },
        onCancel = {

            showAddSubcategoriaModal = false
        }
    )

}