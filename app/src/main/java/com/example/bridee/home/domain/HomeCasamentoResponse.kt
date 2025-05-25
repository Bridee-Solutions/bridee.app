package com.example.bridee.home.domain

import com.example.bridee.calculadora.domain.CasalResponse
import java.time.LocalDate

data class HomeCasamentoResponse(
    val quantidadeConvidados: String,
    val dataCasamento: String,
    val local: String,
    val casal: CasalResponse
)
