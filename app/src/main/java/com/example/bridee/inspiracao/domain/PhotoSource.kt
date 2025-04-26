package com.example.bridee.inspiracao.domain

import com.google.gson.annotations.SerializedName

data class PhotoSource (
    @SerializedName("original") val original: String,
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("small") val small: String
)