package com.example.bridee.servicos.domain



data class Subcategoria(
    val id: String,
    val nome: String,
    val local: String,
    val descricao: String,
    val imagem: Int,
    val precoMedio: String? = null,
)