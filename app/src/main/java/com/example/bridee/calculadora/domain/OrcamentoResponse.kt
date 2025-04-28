package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class OrcamentoResponse(
    val orcamentoTotal: BigDecimal,
    val nomeCasal: String,
    val orcamentoGasto: BigDecimal,
    var itemOrcamentos: MutableList<ItemOrcamentoResponse>,
    val orcamentoFornecedores: MutableList<OrcamentoFornecedorResponse>
)
