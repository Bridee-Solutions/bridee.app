package com.example.bridee.inspiracao.domain

data class ImageMetadata(
    val id: Int? = null,
    val nome: String,
    val url: String,
    val extensao: String,
    val tipo: String = "FAVORITO"
)
