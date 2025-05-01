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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bridee.auth.presentation.component.CustomCheckbox
import com.example.bridee.lista_tarefas.domain.Tarefa
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun TarefaCard(
    tarefa: Tarefa,
    deleteTaskName: MutableState<String>,
    onDeleteClick: () -> Unit,
    onCheckClick: (Boolean) -> Unit
) {

    val isChecked = remember { mutableStateOf(tarefa.concluida) }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Gray,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.Red
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomCheckbox(
                checked = tarefa.concluida,
                onCheckedChange = { isChecked ->
                    onCheckClick(isChecked)
                },
                checkColor = Color(0xFF30C023),
                checkSize = 36.dp,
                modifier = Modifier.size(40.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = tarefa.titulo,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = "${tarefa.data.format(DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", Locale("pt", "BR")))}")
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