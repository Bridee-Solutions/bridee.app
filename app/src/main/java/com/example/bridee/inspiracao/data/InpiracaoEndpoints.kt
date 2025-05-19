package com.example.bridee.inspiracao.data

import com.example.bridee.core.pagination.PaginationResponse
import com.example.bridee.inspiracao.domain.FavoriteImageResponse
import com.example.bridee.inspiracao.domain.ImageMetadata
import com.example.bridee.inspiracao.domain.PexelsResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface InpiracaoEndpoints {

    @GET("pexels/images")
    suspend fun findImages(
        @Query("query") query: String,
        @Query("page") page: String,
        @Query("perPage") perPage: String
    ): Response<PexelsResponseDto>

    @GET("pexels/favoritos")
    suspend fun findFavoritesImages(): Response<PaginationResponse<FavoriteImageResponse>>

    @POST("pexels/favoritos")
    suspend fun favoriteImage(@Body body: ImageMetadata): Response<FavoriteImageResponse>

    @POST("pexels/desfavoritar/{id}")
    suspend fun desfavoriteImage(@Path("id") id: Int): Response<Void>
}