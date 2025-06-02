package com.example.bridee.configuracoes.domain

data class ImageMetadata(
    val id: Int? = null,
    val nome: String,
    val url: String? = null,
    val tipo: ImagemCasalEnum = ImagemCasalEnum.PERFIL,
    val extensao: String
)
