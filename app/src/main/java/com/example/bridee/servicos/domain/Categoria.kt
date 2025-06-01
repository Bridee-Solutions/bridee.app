package com.example.bridee.servicos.domain

data class Categoria(
    val id: Int?,
    val nome: String,
    val icone: Int,
    val subcategorias: MutableList<Subcategoria> = mutableListOf()
)