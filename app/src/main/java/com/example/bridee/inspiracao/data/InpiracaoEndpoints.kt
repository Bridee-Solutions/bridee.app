package com.example.bridee.inspiracao.data

import com.example.bridee.inspiracao.domain.PexelsResponseDto
import retrofit2.http.Query

interface InpiracaoEndpoints {

    suspend fun findImages(@Query("query") query: String): PexelsResponseDto
}