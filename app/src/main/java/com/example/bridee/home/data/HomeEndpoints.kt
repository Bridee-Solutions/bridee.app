package com.example.bridee.home.data

import com.example.bridee.core.pagination.PaginationResponse
import com.example.bridee.home.domain.AssessorResponse
import com.example.bridee.home.domain.Categoria
import com.example.bridee.home.domain.Fornecedor
import com.example.bridee.home.domain.HomeResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeEndpoints {
    @GET("dashboards")
    suspend fun fetchHomeInfo(): Response<HomeResponseDto>

    @GET("assessores")
    suspend fun searchAssessor(@Query("nome") nome: String): Response<AssessorResponse>

    @GET("fornecedores/details/categoria/{categoriaId}")
    suspend fun searchFornecedor(
        @Path("categoriaId") categoriaId: Int,
        @Query("nome") nome: String
    ): Response<PaginationResponse<Fornecedor>>

    @GET("categorias-servicos")
    suspend fun fetchCategories(): Response<PaginationResponse<Categoria>>
}