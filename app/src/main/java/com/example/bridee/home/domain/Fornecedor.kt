package com.example.bridee.home.domain

data class Fornecedor(
    val id: Int,
    val nome: String,
    val email: String,
    val nota: Int,
    val selecionado: Boolean,
    val drawableResId: Int
)
