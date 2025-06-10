
package com.example.bridee.lista_tarefas.domain

data class Tarefa(
    val id: Long? = null,
    val mesesAnteriores: Int = 0,
    var nome: String = "",
    var descricao: String = "",
    val categoria: String = "Fotografia",
    var status: String = "EM_ANDAMENTO",
    val dataLimite: String = ""
)
