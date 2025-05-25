package com.example.bridee.home.domain

data class Fornecedor(
    var id: Int? = -1,
    val nome: String,
    val email: String = "",
    val nota: Int = 0,
    val subcategoriaServico: SubcategoriaServicoResponse? = null,
    var selected: Boolean
)
