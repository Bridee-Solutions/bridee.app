package com.example.bridee.configuracoes.data

import com.example.bridee.calculadora.domain.CasalResponse
import com.example.bridee.configuracoes.domain.ConfiguracaoCasal
import com.example.bridee.configuracoes.domain.ConfiguracaoCasamento
import com.example.bridee.home.domain.HomeCasamentoResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part

interface ConfiguracaoEndpoints {

    @Multipart
    @POST("casais/imagem-perfil")
    suspend fun uploadProfileImage(
        @Part file: MultipartBody.Part,
        @Part("metadata") metadata: RequestBody
    ): Response<Unit>

    @PATCH("casamentos")
    suspend fun updateCasamentoInfo(
            @Body configuracaoCasamento: ConfiguracaoCasamento
    ): Response<HomeCasamentoResponse>

    @PATCH("casais")
    suspend fun updateCasalInfo(
        @Body configuracaoCasal: ConfiguracaoCasal
    ): Response<CasalResponse>
}