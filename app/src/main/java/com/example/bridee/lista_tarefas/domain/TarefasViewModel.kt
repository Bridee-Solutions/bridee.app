package com.example.bridee.lista_tarefas.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.lista_tarefas.data.Tarefa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TarefasViewModel : ViewModel() {

    private val repository = TarefaRepository()

    private val listar = ListarTarefasUseCase(repository)
    private val adicionar = AdicionarTarefaUseCase(repository)
    private val atualizar = AtualizarTarefaUseCase(repository)
    private val deletar = DeletarTarefaUseCase(repository)

    private val _tarefas = MutableStateFlow(listOf<Tarefa>())
    val tarefas: StateFlow<List<Tarefa>> = _tarefas

    init {
        carregarTarefas()
    }

    fun carregarTarefas() {
        viewModelScope.launch {
            _tarefas.value = listar()
        }
    }

    fun adicionarTarefa(descricao: String) {
        viewModelScope.launch {
            adicionar(descricao)
            carregarTarefas()
        }
    }

    fun atualizarTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            atualizar(tarefa)
            carregarTarefas()
        }
    }

    fun deletarTarefa(id: Int) {
        viewModelScope.launch {
            deletar(id)
            carregarTarefas()
        }
    }
}
