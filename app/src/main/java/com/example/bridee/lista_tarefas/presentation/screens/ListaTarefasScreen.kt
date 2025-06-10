package com.example.bridee.lista_tarefas.presentation.screens

import DateDefaults
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.MaskVisualTransformation
import com.example.bridee.lista_tarefas.domain.FilterItem
import com.example.bridee.lista_tarefas.presentation.components.AddTarefa
import com.example.bridee.lista_tarefas.presentation.components.FilterPanel
import com.example.bridee.lista_tarefas.presentation.components.SimpleDropDown
import com.example.bridee.lista_tarefas.presentation.components.TarefaCard
import com.example.bridee.lista_tarefas.presentation.viewmodel.TarefasViewModel
import com.example.bridee.ui.components.CustomModal
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection
import com.example.bridee.ui.theme.rosa
import com.seuapp.presentation.components.CustomModalCreate

@Composable
fun ListaTarefasScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: TarefasViewModel
) {
    val tarefas = viewModel.tarefas
    val concluidas = tarefas.sumOf { it?.tarefas!!.tarefasConcluidas() }
    val progresso = tarefas.sumOf { it?.tarefas!!.tarefasEmProgresso() }
    var total = tarefas.sumOf { it?.tarefas!!.totalTarefas() }

    LaunchedEffect(true) {
        viewModel.carregarTarefas()
    }

    var statusFilter by remember {
        mutableStateOf(
            listOf(
                FilterItem("Concluída", false, "CONCLUIDO"),
                FilterItem("Em andamento", false, "EM_ANDAMENTO")
            )
        )
    }


    var mesFilter by remember {
        mutableStateOf(
            listOf(
                FilterItem("Janeiro", false, 1),
                FilterItem("Fevereiro", false, 2),
                FilterItem("Março", false, 3),
                FilterItem("Abril", false, 4),
                FilterItem("Maio", false, 5),
                FilterItem("Junho", false, 6),
                FilterItem("Julho", false, 7),
                FilterItem("Agosto", false, 8),
                FilterItem("Setembro", false, 9),
                FilterItem("Outubro", false, 10),
                FilterItem("Novembro", false, 11),
                FilterItem("Dezembro", false, 12)
            )
        )
    }


    val deleteTaskName = remember { mutableStateOf("") }

    var showDatePicker by remember { mutableStateOf(false) }
    var isDeletingCharacter by remember {
        mutableStateOf(false)
    }

    var isDateNotDefined by remember {
        mutableStateOf(false)
    }

    var showCreateModal by remember { mutableStateOf(false) }
    var showDeleteModal by remember { mutableStateOf(false) }
    var showFilterPanel by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
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
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .padding(1.dp)
            ) {
                if(total == 0){
                    total = 1
                }
                LinearProgressIndicator(
                    progress = (concluidas.toFloat()/total),
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
                    value = viewModel.searchText,
                    onValueChange = {
                        viewModel.searchText = it
                        viewModel.carregarTarefas()
                    },
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
                tarefas.forEach {tarefas ->
                    tarefas!!.tarefasDoAno().forEach{
                        item {
                            Text(
                                style = MaterialTheme.typography.titleMedium,
                                text = "${it.key} ${tarefas.ano}",
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            ) {

                                Column{
                                    it.value.forEachIndexed { index, task ->
                                        TarefaCard(
                                            tarefa = task,
                                            onDeleteClick = {
                                                viewModel.selectedTarefa = task
                                                showDeleteModal = true
                                            },
                                            deleteTaskName = deleteTaskName,
                                            onCheckClick = { isChecked ->
                                                val novoStatus = if (task.status == "CONCLUIDO") "EM_ANDAMENTO" else "CONCLUIDO"
                                                viewModel.selectedTarefa = task
                                                viewModel.selectedTarefa.status = novoStatus
                                                viewModel.atualizarTarefa(task.id!!)
                                            },
                                            onUpdateClick = {
                                                viewModel.selectedTarefa = task
                                                showCreateModal = true
                                            }
                                        )

                                        if (index < it.value.size - 1) {
                                            Divider(
                                                color = Color.LightGray,
                                                thickness = 1.dp,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item {
                        AddTarefa(onAddClick = {showCreateModal = true })
                    }
                }
                if(tarefas.isEmpty()){
                    item {
                        AddTarefa(onAddClick = {showCreateModal = true })
                    }
                }
            }
        }
    }

    CustomModalCreate(
        showModal = showCreateModal,
        onDismissRequest = { showCreateModal = false },
        title = "Criar tarefa",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Column {
                    Text(
                        text ="Nome da Tarefa",
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
                            value = viewModel.selectedTarefa.nome,
                            onValueChange = { viewModel.selectedTarefa = viewModel.selectedTarefa.copy(
                                nome = it
                            ) },
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

                Column {
                    Text(
                        text = "Descrição da tarefa personalizada",
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
                            value = viewModel.selectedTarefa.descricao,
                            onValueChange = { viewModel.selectedTarefa = viewModel.selectedTarefa.copy(
                                descricao = it
                            ) },
                            placeholder = { Text("Escreva algo aqui...") },
                            textStyle = MaterialTheme.typography.bodySmall,
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
                            value = viewModel.selectedTarefa.dataLimite ?: "",
                            onValueChange = {
                                if(viewModel.selectedTarefa.dataLimite.length < DateDefaults.DATE_LENGTH){
                                    isDeletingCharacter = false
                                }
                                if((viewModel.selectedTarefa.dataLimite.length < DateDefaults.DATE_LENGTH && it.isDigitsOnly()) ||
                                    isDeletingCharacter){
                                    viewModel.selectedTarefa = viewModel.selectedTarefa.copy(
                                        dataLimite = it
                                    )
                                    isDateNotDefined = false
                                }
                            },
                            visualTransformation = MaskVisualTransformation(DateDefaults.DATE_MASK),
                            textStyle = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { showDatePicker = true }
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
                    SimpleDropDown(
                        modifier = Modifier.fillMaxWidth(0.8f)
                            .height(60.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        options = listOf(
                            "Fotografia",
                            "Cabelo e Maquiagem",
                            "Vestidos",
                            "Locais",
                            "Musica",
                            "Planejador"
                        ),
                        selectedOption = viewModel.selectedTarefa.categoria,
                        onOptionSelected = {viewModel.selectedTarefa = viewModel.selectedTarefa.copy(
                            categoria = it.uppercase()
                        )}
                    )
                }
            }

        },
        onConfirm = {
            viewModel.adicionarTarefa()
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
            Column(modifier = Modifier.fillMaxSize()) {
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
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                // Conteúdo scrollável (Status + Mês)
                Column(
                    modifier = Modifier
                        .weight(1f) // Ocupa todo o espaço disponível
                        .verticalScroll(rememberScrollState())
                ) {
                    // Filtros de Status
                    Column {
                        Text(
                            text = "Status",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        statusFilter.forEachIndexed { index, status ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = status.check,
                                    onCheckedChange = { isChecked ->
                                        statusFilter = statusFilter.toMutableList().apply {
                                            this.forEachIndexed() {indice, valor ->
                                                if(indice != index){
                                                    valor.check = false
                                                }
                                            }
                                            this[index] =
                                                this[index].copy(check = !this[index].check)
                                            if(!this[index].check){
                                                viewModel.status = null
                                            }else{
                                                viewModel.status = this[index].valor as String
                                            }
                                        }
                                    },
                                    modifier = Modifier.size(24.dp),
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFFDD7B78), // Cor do botão de filtrar
                                        uncheckedColor = Color.LightGray, // Cor da borda quando não marcado
                                        checkmarkColor = Color.White // Cor do "check" (tic)
                                    )
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
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        Text(
                            text = "Mês",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                        )

                        mesFilter.forEachIndexed { index, mes ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = mes.check,
                                    onCheckedChange = { isChecked ->
                                        mesFilter = mesFilter.toMutableList().apply {
                                            this[index] =
                                                this[index].copy(check = !this[index].check)
                                            if(viewModel.mes.isEmpty()){
                                                viewModel.mes.add(this[index].valor.toString())
                                            }else if(!this[index].check){
                                                viewModel.mes.remove(this[index].valor.toString())
                                            } else{
                                                viewModel.mes.add("${this[index].valor}")
                                            }
                                        }
                                    },
                                    modifier = Modifier.size(24.dp),
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFFDD7B78),
                                        uncheckedColor = Color.LightGray,
                                        checkmarkColor = Color.White
                                    )
                                )
                                Text(
                                    text = mes.nome,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }


                Column(modifier = Modifier.padding(top = 8.dp)) {
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                showFilterPanel = false
                                statusFilter = statusFilter.map { it.copy(check = false) }
                                mesFilter = mesFilter.map { it.copy(check = false) }
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
                            Text("Limpar filtros", color = Color(0xFF766F6F))
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                showFilterPanel = false
                                viewModel.carregarTarefas()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFDD7B78),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp)
                        ) {
                            Text("Filtrar", color = Color.White)
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
                imageVector = Icons.Default.Warning,
                contentDescription = "Ícone de alerta",
                tint = Color(0xFFFF5154),
                modifier = Modifier.size(90.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center,
                    text = "Deseja remover a tarefa \"${deleteTaskName.value}\"?"
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF6B6565)),
                    textAlign = TextAlign.Center,
                    text="Você não poderá recuperá-lo novamente após a exclusão."
                )
                Spacer(Modifier.height(18.dp))

            }
        },
        onConfirm = {
            viewModel.deletarTarefa()
            showDeleteModal = false
        },
        onCancel = {
            showDeleteModal = false
        },
        textConfirm = "Deletar"

    )
}