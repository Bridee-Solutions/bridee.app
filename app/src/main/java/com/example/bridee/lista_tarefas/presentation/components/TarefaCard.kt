package com.example.bridee.lista_tarefas.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bridee.lista_tarefas.domain.Tarefa

@Composable
fun TarefaCard(
    tarefa: Tarefa,
    deleteTaskName: MutableState<String>,
    onDeleteClick: () -> Unit,
) {

    val isChecked = remember { mutableStateOf(tarefa.concluida) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp)),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Gray,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.Red
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { newValue ->
                    isChecked.value = newValue
                }
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = tarefa.titulo)
                Text(text = "Data: ${tarefa.data}")
            }

            IconButton(
                onClick = {
                    onDeleteClick()
                    deleteTaskName.value = tarefa.titulo
                },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Deletar",
                    tint = Color.Gray
                )
            }
        }
    }
}