package com.example.bridee.home.domain

data class HomeTarefasResponse(
    val totalItens: Int,
    val totalConcluidos: Int,
    val ultimasTarefas: List<TarefaResponse>,
    val totalAtrasadas: Int
)
