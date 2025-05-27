package com.example.bridee.servicos.domain

data class AssociadoGeralResponseDto(
    val id: Int,
    val nome: String,
    val visaoGeral: String,
    val cidade: String,
    val bairro: String,
    val notaMedia: Double,
    val totalAvaliacoes: Double,
    val siteUrl: String,
    val servicosFornecidos: String,
    val formaDeTrabalho: String,
    val qtdConvidados: String,
    val imagens: List<String>,
    val formasPagamento: List<String>,
    val tiposCasamento: List<String>
)