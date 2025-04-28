package com.example.bridee.calculadora.domain

import java.math.BigDecimal

data class CustoItemRequest(
    val id: Int?,
    val nome: String,
    val precoAtual: BigDecimal
){

    companion object{
        fun custoItemRequest(custoItemResponse: CustoItemResponse): CustoItemRequest {
            return CustoItemRequest(
                id=custoItemResponse.id,
                nome=custoItemResponse.nome,
                precoAtual=custoItemResponse.precoAtual
            )
        }
    }
}
