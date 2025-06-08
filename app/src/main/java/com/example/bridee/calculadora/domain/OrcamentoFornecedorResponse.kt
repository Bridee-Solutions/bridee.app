package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class OrcamentoFornecedorResponse(
    val id: Int,
    val preco: BigDecimal,
    val fornecedor: FornecedorResponse
)
