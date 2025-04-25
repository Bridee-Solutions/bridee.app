package com.example.bridee.inspiracao.domain

data class PexelPhotos(
    val id: Long,
    val photographer: String,
    val photographerUrl: String,
    val photographerId: String,
    val source: PhotoSource,
    val altText: String
)
