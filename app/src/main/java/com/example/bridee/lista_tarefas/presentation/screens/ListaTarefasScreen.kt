
package com.example.bridee.lista_tarefas.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.tooling.preview.Preview
import java.time.format.TextStyle as TextStyleDate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bridee.auth.presentation.registration.fases.fase2.Fase2RegistrationScreen
import com.example.bridee.lista_tarefas.domain.FilterItem
import com.example.bridee.lista_tarefas.domain.Tarefa
import com.example.bridee.lista_tarefas.presentation.components.AddTarefa
import com.example.bridee.lista_tarefas.presentation.components.FilterPanel
import com.example.bridee.lista_tarefas.presentation.components.TarefaCard
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection;
import com.example.bridee.ui.theme.BrideeTheme
import com.example.bridee.ui.theme.rosa
import com.seuapp.presentation.components.CustomModal
import com.seuapp.presentation.components.CustomModalCreate
import java.time.LocalDate
import java.util.Locale

@Composable
fun ListaTarefasScreen(viewModel: TarefasViewModel = viewModel()) {
    val tarefas by viewModel.tarefas.collectAsState()

    var textoNovaTarefa by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista de Tarefas", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            BasicTextField(
                value = textoNovaTarefa,
                onValueChange = { textoNovaTarefa = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
            Button(onClick = {
                if (textoNovaTarefa.isNotBlank()) {
                    viewModel.adicionarTarefa(textoNovaTarefa)
                    textoNovaTarefa = ""
                }
            }) {
                Text("Adicionar")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(tarefas) { tarefa ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = {
                        viewModel.atualizarTarefa(tarefa.copy(concluida = !tarefa.concluida))
                    }) {
                        Text(text = if (tarefa.concluida) "✅ ${tarefa.descricao}" else tarefa.descricao)
                    }
                    Row {
                        Button(onClick = {

                            viewModel.atualizarTarefa(tarefa.copy(descricao = tarefa.descricao + " (editado)"))
                        }) {
                            Text("Editar")
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Button(onClick = { viewModel.deletarTarefa(tarefa.id) }) {
                            Text("Deletar")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
