package com.example.bridee.home.data

import com.example.bridee.home.domain.HomeResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface HomeEndpoints {
    @GET("dashboards")
    suspend fun fetchHomeInfo(): Response<HomeResponseDto>
}