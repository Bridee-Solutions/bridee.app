
package com.example.bridee.lista_tarefas.data

data class Tarefa(
    val id: Int,
    var descricao: String,
    var concluida: Boolean = false
)
