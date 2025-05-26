package com.example.bridee.servicos.domain

data class AssociadoResponseDto(
    val id: Int,
    val informacaoAssociadoId: Int,
    val nome: String,
    val visaoGeral: String,
    val cidade: String,
    val bairro: String,
    val notaMedia: Double,
    val totalAvaliacoes: Double,
    val imagemPrincipal: String
)
