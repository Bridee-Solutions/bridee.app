package com.example.bridee.lista_tarefas.presentation.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import java.time.format.TextStyle as TextStyleDate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.ui.components.FerramentasSection;
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.pretoMedio
import com.example.bridee.ui.theme.rosa
import com.seuapp.presentation.components.CustomModal
import com.seuapp.presentation.components.CustomModalCreate
import java.time.LocalDate
import java.util.Locale

data class Tarefa(
    val id: Int,
    val titulo: String,
    val data: LocalDate,
    var concluida: Boolean = false
)

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

@Composable
fun AddTarefa(
    showCreateModal: Boolean,
    onAddClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Gray,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.Red
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onAddClick()
                }
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Adicionar Tarefa",
                tint = rosa,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Adicionar Item",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ListaTarefasScreen(navController: NavController) {
    val tarefas = listOf(
        Tarefa(1, "Experimentar bolo", LocalDate.of(2025, 3, 10), concluida = false),
        Tarefa(2, "Visitar salão", LocalDate.of(2025, 3, 12), concluida = false),
        Tarefa(3, "Experimentar vestido", LocalDate.of(2025, 3, 15), concluida = false),
        Tarefa(4, "Enviar convites", LocalDate.of(2025, 3, 18), concluida = false),
        Tarefa(5, "Ir a manicure", LocalDate.of(2025, 3, 20), concluida = true)
    )

    val total = tarefas.size
    val concluidas = tarefas.count { it.concluida }


    val progresso = if (total > 0) concluidas.toFloat() / total.toFloat() else 0f
    var searchText by remember { mutableStateOf("")}
    var nomeTaskText by remember { mutableStateOf("")}
    var descTaskText by remember { mutableStateOf("")}
    var notesTaskText by remember { mutableStateOf("")}
    var dateTaskText by remember { mutableStateOf("")}
    var categoryTaskText by remember { mutableStateOf("")}

    val hoje = LocalDate.now();
    val checkedStates = remember { mutableStateMapOf<Int, Boolean>() }
    val deleteTaskName = remember { mutableStateOf("") }

    var showCreateModal by remember { mutableStateOf(false) }
    var showDeleteModal by remember { mutableStateOf(false) }

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
                        TarefaCard(
                            tarefa = tarefa,
                            onDeleteClick = {showDeleteModal = true},
                            deleteTaskName = deleteTaskName
                        )
                    }
                    // Card para adicionar nova tarefa na seção "Atrasado"
                    item {
                        AddTarefa(showCreateModal = showCreateModal, onAddClick = {showCreateModal = true })
                    }
                }

                tarefasAgrupadas
                    .filterKeys { it != "Atrasado" }
                    .forEach { (tituloSeccao, listaTarefas) ->
                        item {
                            Text(text = tituloSeccao, modifier = Modifier.padding(8.dp))
                        }
                        items(listaTarefas) { tarefa ->
                            TarefaCard(
                                tarefa = tarefa,
                                onDeleteClick = {showDeleteModal = true},
                                deleteTaskName = deleteTaskName
                            )
                        }
                        // Card para adicionar nova tarefa em cada seção
                        item {
                            AddTarefa(showCreateModal = showCreateModal, onAddClick = {showCreateModal = true })
                        }
                    }
            }
        }
    }

    CustomModalCreate(
        showModal = showCreateModal,
        onDismissRequest = { showCreateModal = false },
        title = "Criar nova tarefa",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Adiciona um padding geral ao formulário
                horizontalAlignment = Alignment.Start // Alinha os filhos à esquerda
            ) {
                // Campo: Nome da Tarefa
                Column {
                    Text("Nome da Tarefa")
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp) // Altura maior para melhor usabilidade
                            .clip(RoundedCornerShape(8.dp)) // Bordas menos arredondadas
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = nomeTaskText,
                            onValueChange = { nomeTaskText = it },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent, // Remove a linha inferior no estado focado
                                unfocusedIndicatorColor = Color.Transparent // Remove a linha inferior no estado não focado
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre os campos

                // Campo: Descrição da Tarefa
                Column {
                    Text("Descrição da tarefa personalizada")
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = descTaskText,
                            onValueChange = { descTaskText = it },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Campo: Notas
                Column {
                    Text("Notas")
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = notesTaskText,
                            onValueChange = { notesTaskText = it },
                            placeholder = { Text("Escreva algo aqui...") },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Campo: Data
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Data")
                    Spacer(modifier = Modifier.width(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = dateTaskText,
                            onValueChange = { dateTaskText = it },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Campo: Categoria
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Categoria")
                    Spacer(modifier = Modifier.width(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = categoryTaskText,
                            onValueChange = { categoryTaskText = it },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        },
        onConfirm = {
            println("Tarefa Criada")
            showCreateModal = false
        },
        onCancel = {
            showCreateModal = false
        }
    )

    CustomModal(
        showModal = showDeleteModal,
        onDismissRequest = { showDeleteModal = false },
        title = "Deletar tarefa",
        content = {
            Icon(
                imageVector = Icons.Default.Warning, // Ícone de alerta
                contentDescription = "Ícone de alerta",
                tint = rosa, // Cor do ícone (amarelo para alerta)
                modifier = Modifier.size(104.dp) // Tamanho do ícone
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    text = "Deseja remover a tarefa \"${deleteTaskName.value}\"?"
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    text="Você não poderá recuperá-lo novamente após a exclusão."
                )
            }
        },
        onConfirm = {
            println("Deletar Tarefa")
            showDeleteModal = false
        },
        onCancel = {
            showDeleteModal = false
        },
        textConfirm = "Deletar"
    )


}


@Preview(showBackground = true)
@Composable
fun ListaTarefaPreview() {
}
