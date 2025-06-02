package com.example.bridee.configuracoes.data

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ConfiguracaoEndpoints {

    @Multipart
    @POST("casais/imagem-perfil")
    suspend fun uploadProfileImage(
        @Part file: MultipartBody.Part,
        @Part("metadata") metadata: String
    ): Response<Unit>
}