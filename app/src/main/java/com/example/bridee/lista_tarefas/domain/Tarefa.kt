
package com.example.bridee.lista_tarefas.data

import java.time.LocalDate

data class Tarefa(
    val id: Long,
    val mesesAnteriores: Int,
    val nome: String,
    var descricao: String,
    val categoria: String,
    var status: String,
    val dataLimite: LocalDate
)
