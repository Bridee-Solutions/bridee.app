package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class CustoItemResponse(
    val id: Int,
    val nome: String,
    val precoAtual: BigDecimal
)
