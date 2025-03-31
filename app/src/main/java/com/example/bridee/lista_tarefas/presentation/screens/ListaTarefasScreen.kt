package com.example.bridee.lista_tarefas.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import java.time.format.TextStyle as TextStyleDate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.lista_tarefas.domain.FilterItem
import com.example.bridee.lista_tarefas.domain.Tarefa
import com.example.bridee.lista_tarefas.presentation.components.AddTarefa
import com.example.bridee.lista_tarefas.presentation.components.FilterPanel
import com.example.bridee.lista_tarefas.presentation.components.TarefaCard
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection;
import com.example.bridee.ui.theme.rosa
import com.seuapp.presentation.components.CustomModal
import com.seuapp.presentation.components.CustomModalCreate
import java.time.LocalDate
import java.util.Locale

@Composable
fun ListaTarefasScreen(navController: NavController) {
    var tarefas by remember {
        mutableStateOf(
            listOf(
                Tarefa(1, "Experimentar bolo", LocalDate.of(2025, 3, 10), concluida = false),
                Tarefa(2, "Visitar salão", LocalDate.of(2026, 3, 12), concluida = false),
                Tarefa(3, "Experimentar vestido", LocalDate.of(2026, 3, 15), concluida = false),
                Tarefa(4, "Enviar convites", LocalDate.of(2026, 3, 18), concluida = false),
                Tarefa(5, "Ir a manicure", LocalDate.of(2025, 3, 20), concluida = true)
            )
        )
    }

    var statusFilter by remember {
        mutableStateOf(
            listOf(
                FilterItem("Concluída", false),
                FilterItem("Em andamento", false)
                )
        )
    }


    var mesFilter by remember {
        mutableStateOf(
            listOf(
                FilterItem("Janeiro", false),
                FilterItem("Fevereiro", false),
                FilterItem("Março", false),
                FilterItem("Abril", false),
                FilterItem("Maio", false),
                FilterItem("Junho", false),
                FilterItem("Julho", false),
                FilterItem("Agosto", false),
                FilterItem("Setembro", false),
                FilterItem("Outubro", false),
                FilterItem("Novembro", false),
                FilterItem("Dezembro", false)
            )
        )
    }

    // Cálculos derivados
    val total = tarefas.size
    val concluidas = tarefas.count { it.concluida }
    val progresso = remember(tarefas) { concluidas.toFloat() / total }


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
    var showFilterPanel by remember { mutableStateOf(false) }

    val tarefasAgrupadas = tarefas.groupBy {
        if (it.data.isBefore(hoje)) "Atrasado"
        else "${it.data.month.getDisplayName(TextStyleDate.FULL, Locale.getDefault())
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} ${it.data.year}"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        FerramentasSection(navController, Tool.TAREFAS);

        Column(
            modifier = Modifier
                .padding(horizontal = 22.dp, vertical = 16.dp)
        ) {
            Text(
                text ="$concluidas de $total tarefas concluídas",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(23.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .padding(1.dp)
            ) {
                LinearProgressIndicator(
                    progress = progresso,
                    modifier = Modifier
                        .fillMaxSize(),
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
                    textStyle = MaterialTheme.typography.bodyMedium,
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
                    onClick = {showFilterPanel = true},
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
                        Text(
                            style = MaterialTheme.typography.titleMedium,
                            text = "Atrasado",
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        ) {

                            Column () {
                                listaTarefas.forEachIndexed { index, tarefa ->
                                    TarefaCard(
                                        tarefa = tarefa,
                                        onDeleteClick = { showDeleteModal = true },
                                        deleteTaskName = deleteTaskName,
                                        onCheckClick = { isChecked ->
                                            tarefas = tarefas.map {
                                                if (it.id == tarefa.id) it.copy(concluida = isChecked)
                                                else it
                                            }
                                        }
                                    )

                                    if (index < listaTarefas.size - 1) {
                                        Divider(
                                            color = Color.LightGray,
                                            thickness = 2.dp,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }
                            }
                        }
                    }

                    item {
                        AddTarefa(showCreateModal = showCreateModal, onAddClick = {showCreateModal = true })
                    }
                }

                var sectionIndex = 0

                // Outras seções (exceto "Atrasado")
                tarefasAgrupadas
                    .filterKeys { it != "Atrasado" }
                    .forEach { (tituloSeccao, listaTarefas) ->
                        item {
                            Text(
                                text = tituloSeccao,
                                modifier = Modifier.padding(8.dp),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            ) {
                                Column {
                                    listaTarefas.forEachIndexed { index, tarefa ->
                                        TarefaCard(
                                            tarefa = tarefa,
                                            onDeleteClick = { showDeleteModal = true },
                                            deleteTaskName = deleteTaskName,
                                            onCheckClick = { isChecked ->
                                                tarefas = tarefas.map {
                                                    if (it.id == tarefa.id) it.copy(concluida = isChecked)
                                                    else it
                                                }
                                            }
                                        )
                                        // Adiciona um Divider apenas se não for o último item da seção
                                        if (index < listaTarefas.size - 1) {
                                            Divider(
                                                color = Color.LightGray,
                                                thickness = 2.dp,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Card para adicionar nova tarefa em cada seção
                        item {
                            AddTarefa(
                                showCreateModal = showCreateModal,
                                onAddClick = { showCreateModal = true }
                            )
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
                    Text(
                        text ="Nome da Tarefa",
                        style = MaterialTheme.typography.bodyMedium
                    )
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
                            textStyle = MaterialTheme.typography.bodyMedium,
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
                    Text(
                        text ="Descrição da tarefa personalizada",
                        style = MaterialTheme.typography.bodyMedium
                    )
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
                            textStyle = MaterialTheme.typography.bodyMedium,
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
                    Text(
                        text = "Notas",
                        style = MaterialTheme.typography.bodyMedium
                    )
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
                            textStyle = MaterialTheme.typography.bodyMedium,
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
                    Text(
                        text ="Data",
                        style = MaterialTheme.typography.bodyMedium
                        )
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
                            textStyle = MaterialTheme.typography.bodyMedium,
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
                    Text(
                        text ="Categoria",
                        style = MaterialTheme.typography.bodyMedium
                        )
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
                            textStyle = MaterialTheme.typography.bodyMedium,
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

    FilterPanel(
        isVisible = showFilterPanel,
        onDismiss = { showFilterPanel = false },
        content = {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Filtros",
                        style = MaterialTheme.typography.titleMedium
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.LightGray,
                    thickness = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight() // Altura fixa
                        .verticalScroll(rememberScrollState()) // Habilita rolagem
                )
                {
                    Column {
                        Text(
                            text = "Status",
                            style = MaterialTheme.typography.titleSmall
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        statusFilter.forEachIndexed { index, status ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 4.dp)
                                    .clickable {
                                        // Atualiza o estado quando clicado
                                        statusFilter = statusFilter.toMutableList().apply {
                                            this[index] =
                                                this[index].copy(check = !this[index].check)
                                        }
                                    }
                            ) {
                                Checkbox(
                                    checked = status.check,
                                    onCheckedChange = { isChecked ->
                                        statusFilter = statusFilter.map {
                                            if (it.nome == status.nome) it.copy(check = isChecked)
                                            else it
                                        }
                                    },
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = status.nome,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(
                        color = Color.LightGray,
                        thickness = 2.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        Text(
                            text = "Mês",
                            style = MaterialTheme.typography.titleSmall
                        )

                        mesFilter.forEachIndexed { index, mes ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 4.dp)
                                    .clickable {
                                        mesFilter = mesFilter.toMutableList().apply {
                                            this[index] =
                                                this[index].copy(check = !this[index].check)
                                        }
                                    }
                            ) {
                                Checkbox(
                                    checked = mes.check,
                                    onCheckedChange = { isChecked ->
                                        mesFilter = mesFilter.map {
                                            if (it.nome == mes.nome) it.copy(check = isChecked)
                                            else it
                                        }
                                    },
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = mes.nome,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(
                        color = Color.LightGray,
                        thickness = 2.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                showFilterPanel = false;
                                statusFilter = statusFilter.map { it.copy(check = false) };
                                mesFilter = mesFilter.map { it.copy(check = false) };
                                      },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFEAEAEA),
                                contentColor = Color(0xFF766F6F)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp)
                        ) {
                            Text("Limpar filtros")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = { showFilterPanel = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFD77C8C),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp)
                        ) {
                            Text("Filtrar")
                        }
                    }

                }
            }
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
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    text = "Deseja remover a tarefa \"${deleteTaskName.value}\"?"
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
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
