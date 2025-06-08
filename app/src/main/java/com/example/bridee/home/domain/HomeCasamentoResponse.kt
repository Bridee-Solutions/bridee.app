package com.example.bridee.home.domain

import com.example.bridee.calculadora.domain.CasalResponse

data class HomeCasamentoResponse(
    val quantidadeConvidados: String,
    var dataCasamento: String,
    var local: String,
    val casal: CasalResponse,
    val image: String
)