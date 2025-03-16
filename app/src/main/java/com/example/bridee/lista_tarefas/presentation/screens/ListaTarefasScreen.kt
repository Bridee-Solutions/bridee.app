package com.example.bridee.lista_tarefas.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import java.time.format.TextStyle as TextStyleDate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.ui.components.FerramentasSection;
import com.example.bridee.ui.theme.rosa
import java.time.LocalDate
import java.util.Locale

data class Tarefa(
    val id: Int,
    val titulo: String,
    val data: LocalDate
)

@Composable
fun ListaTarefasScreen(navController: NavController) {
    val concluidas = 25;
    val total = 100;
    val tarefas = listOf(
        Tarefa(1, "Estudar Kotlin", LocalDate.of(2025, 3, 10)),
        Tarefa(2, "Revisar padrões de projeto", LocalDate.of(2025, 3, 12)),
        Tarefa(3, "Implementar API em Spring Boot", LocalDate.of(2025, 3, 15)),
        Tarefa(4, "Escrever documentação", LocalDate.of(2025, 3, 18)),
        Tarefa(5, "Refatorar código legado", LocalDate.of(2025, 3, 20))
    )

    val progresso = if (total > 0) concluidas.toFloat() / total.toFloat() else 0f
    var searchText by remember { mutableStateOf("")}
    val hoje = LocalDate.now();
    val checkedStates = remember { mutableStateMapOf<Int, Boolean>() }

    val tarefasAgrupadas = tarefas.groupBy {
        if (it.data.isBefore(hoje)) "Atrasado"
        else "${it.data.month.getDisplayName(TextStyleDate.FULL, Locale.getDefault())
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} ${it.data.year}"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FerramentasSection(navController);

        Column(
            modifier = Modifier
                .padding(horizontal = 6.dp)
        ) {
            Text("$concluidas de $total tarefas concluídas")

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(23.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .padding(1.dp)
            ) {
                LinearProgressIndicator(
                    progress = { progresso },
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    color = rosa,
                    trackColor = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Pesquisar tarefas...") },
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.Transparent),

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Filtrar",
                        tint = Color.Gray
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                tarefasAgrupadas["Atrasado"]?.let { listaTarefas ->
                    item {
                        Text(text = "Atrasado", modifier = Modifier.padding(8.dp))
                    }
                    items(listaTarefas) { tarefa ->
                        val isChecked = checkedStates[tarefa.id] ?: false

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 0
                                    .dp, horizontal = 8.dp)
                                .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp)),
                            colors = CardColors(containerColor = Color.Transparent, contentColor = Color.Gray, disabledContentColor = Color.Black, disabledContainerColor = Color.Red)
                        ) {
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Checkbox(
                                    checked = isChecked,
                                    onCheckedChange = { checked ->
                                        checkedStates[tarefa.id] = checked
                                    }
                                )
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(text = tarefa.titulo)
                                    Text(text = "Data: ${tarefa.data}")
                                }

                                IconButton(
                                    onClick = {},
                                    modifier = Modifier.size(40.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Filtrar",
                                        tint = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                }

                tarefasAgrupadas
                    .filterKeys { it != "Atrasado" }
                    .forEach { (tituloSeccao, listaTarefas) ->
                        item {
                            Text(text = tituloSeccao, modifier = Modifier.padding(8.dp))
                        }
                        items(listaTarefas) { tarefa ->
                            val isChecked = checkedStates[tarefa.id] ?: false

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 14.dp, horizontal = 8.dp)
                                    .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp)),
                                colors = CardColors(containerColor = Color.Transparent, contentColor = Color.Gray, disabledContentColor = Color.Black, disabledContainerColor = Color.Red)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Checkbox(
                                        checked = isChecked,
                                        onCheckedChange = { checked ->
                                            checkedStates[tarefa.id] = checked
                                        }
                                    )
                                    Column(modifier = Modifier.padding(16.dp)) {
                                        Text(text = tarefa.titulo)
                                        Text(text = "Data: ${tarefa.data}")
                                    }

                                    IconButton(
                                        onClick = {},
                                        modifier = Modifier.size(40.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Filtrar",
                                            tint = Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListaTarefaPreview() {
}
