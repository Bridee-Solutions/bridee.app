package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class OrcamentoResponse(
    val orcamentoTotal: BigDecimal,
    val nomeCasal: String,
    val orcamentoGasto: BigDecimal,
    var itemOrcamentos: MutableList<ItemOrcamentoResponse>,
    val orcamentoFornecedores: MutableList<OrcamentoFornecedorResponse>
){

    fun totalDespesasFornecedor(): BigDecimal{
        var despesa = BigDecimal(0)
        if(orcamentoFornecedores.isNotEmpty()){
            despesa = orcamentoFornecedores
                .map { it.preco }
                .reduce{prev, actual -> prev.plus(actual)}
        }
        return despesa
    }

}
