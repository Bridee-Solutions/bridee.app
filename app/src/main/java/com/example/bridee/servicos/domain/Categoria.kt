package com.example.bridee.servicos.domain

import androidx.compose.ui.graphics.vector.ImageVector

data class Categoria(
    val id: Int,
    val nome: String,
    val icone: ImageVector,
    val subcategorias: List<Subcategoria> = emptyList()
)