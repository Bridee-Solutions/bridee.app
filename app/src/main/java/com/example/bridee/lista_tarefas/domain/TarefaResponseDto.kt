package com.example.bridee.lista_tarefas.domain

import java.time.LocalDate

data class TarefaResponseDto(
    val ano: Int,
    val tarefas: YearlyTasks
){
    fun tarefasDoAno(): Map<String, MutableList<Tarefa>>{
        return tarefas.tarefasAgrupadas()
    }

    fun findTaskById(id: Long): Tarefa{
        return tarefas.findTaskById(id)
    }

    fun updateTask(id: Long, tarefa: Tarefa): TarefaResponseDto{
        var task = findTaskById(id)
        task = tarefa
        return this
    }

    fun deletarTarefa(id: Long): TarefaResponseDto{
        tarefas.deleteTask(id)
        return this
    }

    fun adicionarTarefa(tarefa: Tarefa): TarefaResponseDto{
        tarefas.tarefasAgrupadas().map{
            val tarefasMes = it.value
                .filter {isSameDate(it, tarefa)}
                .toMutableList()
            tarefasMes.add(tarefa)
        }
        return this
    }

    private fun isSameDate(tarefa: Tarefa, novaTarefa: Tarefa): Boolean{
        return (LocalDate.parse(tarefa.dataLimite).month == LocalDate.parse(novaTarefa.dataLimite).month)
                && (LocalDate.parse(tarefa.dataLimite).year == LocalDate.parse(novaTarefa.dataLimite).year)
    }
}
