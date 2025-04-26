package com.example.bridee.calculadora.data

import com.example.bridee.calculadora.domain.OrcamentoResponse
import retrofit2.Response
import retrofit2.http.GET

interface CalculadoraEndpoints {

    @GET("orcamentos/casamento")
    suspend fun findOrcamento(): Response<OrcamentoResponse>

}