package com.example.bridee.lista_tarefas.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.lista_tarefas.data.ListaTarefasEndpoints
import com.example.bridee.lista_tarefas.domain.Tarefa
import com.example.bridee.lista_tarefas.domain.TarefaRequestDto
import com.example.bridee.lista_tarefas.domain.TarefaResponseDto
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Objects

class TarefasViewModel : ViewModel() {

    val tarefaService = ApiInstance.createService(ListaTarefasEndpoints::class.java)
    var tarefas by mutableStateOf<List<TarefaResponseDto?>>(emptyList())
    var selectedTarefa by mutableStateOf(Tarefa())
    var searchText by mutableStateOf("")
    var status: String? = null
    var mes: MutableList<String> = mutableListOf()

    init {
        carregarTarefas()
    }

    fun carregarTarefas() {
        viewModelScope.launch {
            var meses: String? = null
            if(mes.isNotEmpty()){
                meses = mes.joinToString(",")
            }
            try {
                val response = tarefaService.listarTarefas(
                    searchText,
                    meses,
                    status
                )
                if(response.isSuccessful){
                    tarefas = response.body()!!
                    Log.i("TAREFAS", "Busca pelas tarefas realizadas com sucesso.")
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun adicionarTarefa(){
        viewModelScope.launch {
                try {
                    val request = TarefaRequestDto.createFromTarefa(selectedTarefa)
                    request.dataLimite = date(request.dataLimite)
                    val response = tarefaService.adicionarTarefa(request)
                    if(response.isSuccessful){
                        carregarTarefas()
//                        if(tarefas.isEmpty()){
//                            carregarTarefas()
//                        }else{
//                            val tarefasAtualizadas = tarefas.map {
//                                val novaTarefaAno = request.dataLimite.split("-")[0].toInt()
//                                if(it!!.ano == novaTarefaAno){
//                                    it.adicionarTarefa(response.body()!!)
//                                }
//                                it
//                            }
//                            tarefas = tarefasAtualizadas
//                        }
                    }
                }catch (e: Exception){
                    Log.e("TAREFAS", "Tarefa adicionada com sucesso ${e.message}")
                    e.printStackTrace()
                }
        }
    }

    private fun date(date: String): String{
        val day = date.substring(0, 2).toInt()
        val month = date.substring(2, 4).toInt()
        val year = date.substring(4).toInt()
        return LocalDate.of(year, month, day).toString()
    }

    fun atualizarTarefa(id: Long) {
        viewModelScope.launch {
            val request = TarefaRequestDto.createFromTarefa(selectedTarefa)
            try {
                val response = tarefaService.atualizarTarefa(id, request)
                if(response.isSuccessful){
                    carregarTarefas()
//                    val tarefasAtualizadas = tarefas.map {
//                        val tarefaEncontrada = it!!.findTaskById(id)
//                        if(tarefaEncontrada.id == id){
//                            it.updateTask(id, response.body()!!)
//                        }else{
//                            it
//                        }
//                    }
//                    tarefas = tarefasAtualizadas
                }
            }catch (e: Exception){
                Log.e("TAREFAS", "Houve um erro ao atualizar as tarefas ${e.message}")
            }
        }
    }

    fun deletarTarefa() {
        viewModelScope.launch {
            val id = selectedTarefa.id!!
            try {
                val response = tarefaService.deletarTarefa(id)
                if(response.isSuccessful){
                    val updatedTasks = tarefas.map{
                        val tarefa = it!!.tarefas.findTaskById(id)
                        if(Objects.nonNull(tarefa)){
                            it.deletarTarefa(id)
                            return@map null
                        }
                        it
                    }.filterNotNull()
                    tarefas = updatedTasks
                }
            }catch (e: Exception){
                Log.e("TAREFAS", "Houve um erro ao deletar as tarefas ${e.message}")
            }
        }
    }
}
