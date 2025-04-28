package com.example.bridee.inspiracao.data

import com.example.bridee.inspiracao.domain.PexelsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InpiracaoEndpoints {

    @GET("pexels/images")
    suspend fun findImages(@Query("query") query: String): Response<PexelsResponseDto>
}