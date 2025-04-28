package com.example.bridee.calculadora.presentation.components.CategoriaDetalhes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.domain.CustoItemResponse
import com.example.bridee.calculadora.domain.ItemOrcamentoResponse
import com.example.bridee.calculadora.domain.SubcategoriaItemData
import com.example.bridee.calculadora.presentation.components.Calculadora.OpcaoModal
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.pretoMedio
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubcategoriaItem(
    viewModel: CalculadoraViewModel,
    custo: CustoItemResponse,
    item: ItemOrcamentoResponse
) {

    var nomeCusto by remember { mutableStateOf(custo.nome) }
    var preco by remember { mutableStateOf(custo.precoAtual.toString()) }
    var showEditModal by remember { mutableStateOf(false) }
    var showModal by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = custo.nome,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFF484646)
                    )
                )

            }
            Text(
                text = "${custo.precoAtual}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFF484646)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = {showModal = true}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Opções"
                )
            }
        }
    }

    OpcaoModal(
        showModal = showModal,
        onDismissRequest = {showModal = false},
        openEditModal = {
            showEditModal = true
            showModal = false
        },
        cancel = {showModal = false},
        delete = {
            viewModel.deleteCusto(item.id!!, custo.id)
            showModal = false
        }
    )

    CustomModal (
        showModal = showEditModal,
        onDismissRequest = { showEditModal = false },
        title = "Editar subcategoria",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                ,
                horizontalAlignment = Alignment.Start
            ) {

                OutlinedTextField(
                    value = nomeCusto,
                    onValueChange = { nomeCusto = it },
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
                    value = preco,
                    onValueChange = { preco = it},
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
            if(nomeCusto.isNotBlank()){
                viewModel.adicionarNovoCusto(
                    item,
                    nomeCusto,
                    BigDecimal(preco),
                    custo.id
                )
            }
            showEditModal = false
        },
        onCancel = {
            showEditModal = false
        }
    )
}