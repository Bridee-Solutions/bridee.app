package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.domain.ItemOrcamentoResponse
import com.example.bridee.calculadora.presentation.components.CategoriaDetalhes.CustomModal

@Composable
fun CategoriaCard(
    item: ItemOrcamentoResponse,
    openModal: () -> Unit,
    viewModel: CalculadoraViewModel
) {

    var showEditModal by remember { mutableStateOf(false) }
    var showModal by remember { mutableStateOf(false) }
    var nomeCategoria by remember { mutableStateOf(item.tipo) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { openModal()

            }
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = item.defineIcon()),
                contentDescription = null,
                tint = Color(0xFFD77C8C),
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(1f)) {
                Text(
                    text = item.tipo,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFF484646)
                    )
                )
                Text(
                    text = item.totalDespesas(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF5C5757)
                    )
                )
            }
            Text(
                text = item.totalDespesas(),
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
            viewModel.deleteCategoria(item.id!!)
            showModal = false
        }
    )

    CustomModal (
        showModal = showEditModal,
        onDismissRequest = { showEditModal = false },
        title = "Editar categoria",
        content = {
            TextField(
                value = nomeCategoria,
                onValueChange = { nomeCategoria = it },
                label = { Text("Nome da categoria", style = MaterialTheme.typography.bodyMedium) },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent


                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
            )
        },
        onConfirm = {
            if (item.tipo.isNotBlank()) {
                viewModel.adicionarNovaCategoria(item, nomeCategoria)
                showEditModal = false
            }
        },
        onCancel = {
            showEditModal = false
        }
    )
}
