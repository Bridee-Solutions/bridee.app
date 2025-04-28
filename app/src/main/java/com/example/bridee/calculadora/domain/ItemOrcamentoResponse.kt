package com.example.bridee.calculadora.domain

import com.example.bridee.R

data class ItemOrcamentoResponse(
    val id: Int?,
    var tipo: String,
    var custos: MutableList<CustoItemResponse>
){
    fun defineIcon(): Int{
        return when(tipo){
            "Moda e Beleza" -> R.drawable.ic_moda_beleza
            "Decoração" -> R.drawable.ic_decoracao
            "Fornecedores" -> R.drawable.ic_fornecedores
            else -> R.drawable.ic_fornecedores
        }
    }

    fun totalDespesas(): String{
        if(custos.isEmpty()){
            return "0 despesas"
        }

        return "${custos.size} despesas"
    }
}

