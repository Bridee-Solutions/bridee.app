package com.example.bridee.home.domain

import java.math.BigDecimal

data class HomeAssessorResponse(
    val assessor: AssessorResponse,
    val preco: BigDecimal
)
