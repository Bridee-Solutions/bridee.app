package com.example.bridee.lista_tarefas.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.lista_tarefas.data.ListaTarefasEndpoints
import com.example.bridee.lista_tarefas.data.Tarefa
import com.example.bridee.lista_tarefas.data.TarefaRequestDto
import com.example.bridee.lista_tarefas.data.TarefaResponseDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class TarefasViewModel : ViewModel() {


    val tarefaService = ApiInstance.createService(ListaTarefasEndpoints::class.java)


    val tarefas = MutableStateFlow<List<TarefaResponseDto>>(emptyList())

    init {
        carregarTarefas()
    }

    fun carregarTarefas() {
        viewModelScope.launch {
            tarefas.value = tarefaService.listarTarefas()
        }
    }

    fun adicionarTarefa(request : TarefaRequestDto){
        viewModelScope.launch {
            tarefaService.adicionarTarefa(request)
        }
    }

    fun atualizarTarefa(id: Long, tarefa: TarefaRequestDto) {
        viewModelScope.launch {
            tarefaService.atualizarTarefa(id, tarefa)
        }
    }

    fun deletarTarefa(id: Long) {
        viewModelScope.launch {
            tarefaService.deletarTarefa(id)
        }
    }
}
