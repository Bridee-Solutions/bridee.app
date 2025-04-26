package com.example.bridee.auth.data

import com.example.bridee.inspiracao.domain.PexelsImageResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PexelsApi {
    @GET("pexels/images")
    suspend fun getImages(@Query("query") query: String): Response<PexelsImageResponseDto>
}