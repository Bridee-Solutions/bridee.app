package com.example.bridee.home.domain

data class TarefaResponse(
    val id: Int,
    val nome: String,
    val descricao: String,
    val status: String,
    val categoria: String,
    val dataLimite: String,
    val mesesAnteriores: String
)
