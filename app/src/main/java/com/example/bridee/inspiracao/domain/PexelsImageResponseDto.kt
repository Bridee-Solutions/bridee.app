package com.example.bridee.inspiracao.domain

import com.google.gson.annotations.SerializedName

data class PexelsImageResponseDto (
    @SerializedName("total_results") val totalResults: Long,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("photos") val photos: List<PexelsPhotos>,
    @SerializedName("next_page") val nextPageUrl: String
)