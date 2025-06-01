package com.example.bridee.lista_tarefas.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.lista_tarefas.data.Tarefa
import com.example.bridee.lista_tarefas.data.TarefaRequestDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

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

    fun adicionarTarefa(descricao: String, nome: String, mesesAnteriores: Int, categoria: String, status: String, dataLimite: LocalDate){
        viewModelScope.launch {
            adicionar(descricao, nome, mesesAnteriores, categoria, status, dataLimite)
            carregarTarefas()
        }
    }

    fun atualizarTarefa(id: Int, tarefa: TarefaRequestDto) {
        viewModelScope.launch {
            atualizar(id, tarefa)
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
