package com.example.bridee.calculadora.data

import com.example.bridee.calculadora.domain.CasalResponse
import com.example.bridee.calculadora.domain.ItemOrcamentoRequest
import com.example.bridee.calculadora.domain.ItemOrcamentoResponse
import com.example.bridee.calculadora.domain.OrcamentoResponse
import com.example.bridee.calculadora.domain.OrcamentoTotalRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CalculadoraEndpoints {

    @GET("orcamentos/casamento")
    suspend fun findOrcamento(): Response<OrcamentoResponse>

    @PUT("casais/orcamento-total")
    suspend fun updateOrcamento(@Body body: OrcamentoTotalRequest): Response<CasalResponse>

    @POST("itens-orcamento")
    suspend fun saveItensOrcamento(@Body body: List<ItemOrcamentoRequest>): Response<MutableList<ItemOrcamentoResponse>>

    @DELETE("itens-orcamento/{id}")
    suspend fun deleteById(@Path("id") id: Int): Response<Void>

    @DELETE("itens-orcamento/custo/{id}")
    suspend fun deleteCustoById(@Path("id") id: Int): Response<Void>
}