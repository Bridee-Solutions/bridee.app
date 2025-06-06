package com.example.bridee.lista_tarefas.data

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ListaTarefasEndpoints {
    @GET("tarefas")
    suspend fun listarTarefas(): List<TarefaResponseDto>

    @POST("tarefas")
    suspend fun adicionarTarefa(@Body tarefa: TarefaRequestDto): TarefaResponseDto

    @PUT("tarefas/{id}")
    suspend fun atualizarTarefa(@Path("id") id: Long, @Body tarefa: TarefaRequestDto): TarefaResponseDto

    @DELETE("tarefas/{id}")
    suspend fun deletarTarefa(@Path("id") id: Long)
}
