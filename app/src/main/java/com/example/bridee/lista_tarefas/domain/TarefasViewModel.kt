package com.example.bridee.lista_tarefas.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TarefasViewModel (

        private val listar: ListarTarefasUseCase,
        private val adicionar: AdicionarTarefaUseCase,
        private val atualizar: AtualizarTarefaUseCase,
        private val deletar: DeletarTarefaUseCase
    ) : ViewModel() {

        private val tarefas = MutableStateFlow<List<Tarefa>>(emptyList())
        val tarefas: StateFlow<List<Tarefa>> = tarefas

        fun carregarTarefas() {
            viewModelScope.launch {
                tarefas.value = listar()
            }
        }

        fun adicionarTarefa(tarefa: Tarefa) {
            viewModelScope.launch {
                adicionar(tarefa)
                carregarTarefas()
            }
        }

        fun atualizarTarefa(tarefa: Tarefa) {
            viewModelScope.launch {
                atualizar(tarefa)
                carregarTarefas()
            }
        }

        fun deletarTarefa(id: Long) {
            viewModelScope.launch {
                deletar(id)
                carregarTarefas()
            }
        }
    }

