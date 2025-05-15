
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.example.bridee.lista_tarefas.domain.TarefasViewModel

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
