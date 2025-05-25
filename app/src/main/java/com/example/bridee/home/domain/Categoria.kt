package com.example.bridee.home.domain

data class Categoria(
    val id: Int,
    val nome: String,
    var selecionado: Boolean,
    var drawableResId: Int,
    var descricao: String?
)
