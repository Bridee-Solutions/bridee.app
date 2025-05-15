package com.example.bridee.lista_tarefas.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class TarefasViewModel(
    private val listar: ListarTarefasUseCase,
    private val adicionar: AdicionarTarefaUseCase,
    private val atualizar: AtualizarTarefaUseCase,
    private val deletar: DeletarTarefaUseCase
) : ViewModel() {

    private val listaTarefas = MutableStateFlow<List<Tarefa>>(emptyList())
    val tarefa: StateFlow<List<Tarefa>> = listaTarefas

    init {
        carregarTarefas()
    }

    fun carregarTarefas() {
        viewModelScope.launch {
            listaTarefas.value = listar()
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


    fun deletarTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            deletarTarefa(tarefa)
            carregarTarefas()
        }
    }
}
