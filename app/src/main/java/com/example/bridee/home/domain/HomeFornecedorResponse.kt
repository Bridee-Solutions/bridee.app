package com.example.bridee.home.domain

import java.math.BigDecimal

data class HomeFornecedorResponse(
    val id: Int,
    val preco: BigDecimal,
    val fornecedor: Fornecedor
)
