package com.example.bridee.lista_tarefas.domain

import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class YearlyTasks(
    val janeiro: MutableList<Tarefa> = mutableListOf(),
    val fevereiro: MutableList<Tarefa> = mutableListOf(),
    val marco: MutableList<Tarefa> = mutableListOf(),
    val abril: MutableList<Tarefa> = mutableListOf(),
    val maio: MutableList<Tarefa> = mutableListOf(),
    val junho: MutableList<Tarefa> = mutableListOf(),
    val julho: MutableList<Tarefa> = mutableListOf(),
    val agosto: MutableList<Tarefa> = mutableListOf(),
    val setembro: MutableList<Tarefa> = mutableListOf(),
    val outubro: MutableList<Tarefa> = mutableListOf(),
    val novembro: MutableList<Tarefa> = mutableListOf(),
    val dezembro: MutableList<Tarefa> = mutableListOf(),
    val atrasadas: MutableList<Tarefa> = mutableListOf()
){

    fun tarefasAgrupadas(): Map<String, MutableList<Tarefa>>{
        val declaredFields = this::class::memberProperties
        val agrupamento = mutableMapOf<String, MutableList<Tarefa>>()
        for (field in declaredFields.get()){
            val fieldName = field.name
            val fieldValue = (field as? KProperty1<Any, *>)?.get(this) as MutableList<Tarefa>
            if(fieldValue.isNotEmpty()){
                agrupamento.run { put(fieldName, fieldValue ) }
            }
        }
        return agrupamento
    }

    fun tarefasEmProgresso(): Int{
        return findAllTasks().filter { it.status != "CONCLUIDO" }.size
    }

    fun tarefasConcluidas(): Int {
        return findAllTasks().filter { it.status == "CONCLUIDO" }.size
    }

    fun totalTarefas(): Int {
        return (findAllTasks() + atrasadas).size
    }

    private fun findAllTasks(): List<Tarefa> {
        return (janeiro + fevereiro + marco + abril + maio
                + junho + julho + agosto + setembro + outubro
                + novembro + dezembro)
    }

    fun findTaskById(id: Long): Tarefa {
        return findAllTasks().filter { it.id == id }[0]
    }

    fun deleteTask(id: Long){
        val tarefas = tarefasAgrupadas().toMutableMap()
        tarefas.forEach{
            val tasks = it.value.filter { it.id != id }.toMutableList()
            tarefas[it.key] = tasks
        }
    }
}