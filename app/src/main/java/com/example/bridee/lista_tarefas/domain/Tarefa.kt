package com.example.bridee.lista_tarefas.domain

import java.time.LocalDate

data class Tarefa(
    val id: Int,
    val titulo: String,
    val data: LocalDate,
    var concluida: Boolean = false
)
