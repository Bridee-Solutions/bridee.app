package com.example.bridee.inspiracao.domain

data class ImageMetadata(
    val id: Int,
    val nome: String,
    val url: String,
    val extensao: String,
    val tipo: String = "Favorito"
)
