package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class OrcamentoResponse(
    val orcamentoTotal: BigDecimal,
    val nomeCasal: String,
    val orcamentoGasto: BigDecimal,
    val itemOrcamentos: List<ItemOrcamentoResponse>,
    val orcamentoFornecedores: List<OrcamentoFornecedorResponse>
)
