package com.example.bridee.home.domain

import java.math.BigDecimal

data class HomeAssessorResponse(
    val assessorResponse: AssessorResponse,
    val preco: BigDecimal
)
