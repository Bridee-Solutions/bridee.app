package com.example.bridee.home.domain

import java.math.BigDecimal

data class OrcamentoFornecedorRequest(
    val id: Int?,
    val preco: BigDecimal,
    val fornecedorId: Int
)