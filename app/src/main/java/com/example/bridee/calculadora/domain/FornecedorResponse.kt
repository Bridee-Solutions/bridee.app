package com.example.bridee.calculadora.domain

data class FornecedorResponse(
    val id: Int,
    val nome: String,
    val subcategoriaServico: SubcategoriaResponse
)
