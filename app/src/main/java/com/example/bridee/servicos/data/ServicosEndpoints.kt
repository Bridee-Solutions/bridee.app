package com.example.bridee.servicos.data

import com.example.bridee.core.pagination.PaginationResponse
import com.example.bridee.servicos.domain.AssociadoGeralResponseDto
import com.example.bridee.servicos.domain.AssociadoResponseDto
import com.example.bridee.servicos.domain.Categoria
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServicosEndpoints {

    @GET("categorias-servicos")
    suspend fun getCategories(): Response<PaginationResponse<Categoria>>

    @GET("fornecedores/details/subcategoria/{subcategoriaId}")
    suspend fun getFornecedoresBySubcategoria(
        @Path("subcategoriaId") id: Int,
        @Query("nome") nome: String
    ): Response<PaginationResponse<AssociadoResponseDto>>

    @GET("fornecedores/information/{id}")
    suspend fun getFornecedorInformation(
        @Path("id") id: Int
    ): Response<AssociadoGeralResponseDto>
}