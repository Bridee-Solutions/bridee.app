package com.example.bridee.inspiracao.domain

import com.google.gson.annotations.SerializedName

data class PexelsPhotos (
    @SerializedName("id") val id: Long,
    @SerializedName("photographer") val photographer: String,
    @SerializedName("photographer_url") val photographerUrl: String,
    @SerializedName("photographer_id") val photographerId: Long,
    @SerializedName("src") val source: PhotoSource,
    @SerializedName("alt") val altText: String
)