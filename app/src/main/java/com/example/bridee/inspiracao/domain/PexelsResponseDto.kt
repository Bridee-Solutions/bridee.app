package com.example.bridee.inspiracao.domain

data class PexelsResponseDto(
    val totalResults: Long,
    val page: Int,
    val perPage: Int,
    val photos: List<PexelPhotos>,
    val nextPageUrl: String
)
