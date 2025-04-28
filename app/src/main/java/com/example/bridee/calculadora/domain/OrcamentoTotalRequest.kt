package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class OrcamentoTotalRequest(
    var orcamentoTotal: BigDecimal = BigDecimal(0)
)
