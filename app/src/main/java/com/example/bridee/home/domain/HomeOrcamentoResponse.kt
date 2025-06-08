package com.example.bridee.home.domain

import java.math.BigDecimal

data class HomeOrcamentoResponse(
    val orcamentoTotal: BigDecimal,
    val orcamentoGasto: BigDecimal
)
