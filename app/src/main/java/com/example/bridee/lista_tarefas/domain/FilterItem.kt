package com.example.bridee.lista_tarefas.domain

data class FilterItem (
    val nome: String,
    var check: Boolean = false,
    val valor: Any
)