package com.example.bridee.calculadora.domain

data class ItemOrcamentoResponse(
    val id: Int,
    val tipo: String,
    val custos: List<CustoItemResponse>
)
