package com.example.bridee.inspiracao.domain

data class PexelsResponseDto(
    val totalResults: Long = 0,
    val page: Int = 0,
    val perPage: Int = 0,
    val photos: List<PexelPhotos> = mutableListOf(),
    val nextPageUrl: String = ""
)
