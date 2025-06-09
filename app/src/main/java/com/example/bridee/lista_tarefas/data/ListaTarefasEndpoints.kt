package com.example.bridee.lista_tarefas.data

import com.example.bridee.lista_tarefas.domain.Tarefa
import com.example.bridee.lista_tarefas.domain.TarefaRequestDto
import com.example.bridee.lista_tarefas.domain.TarefaResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ListaTarefasEndpoints {
    @GET("tarefas")
    suspend fun listarTarefas(): Response<List<TarefaResponseDto>>

    @POST("tarefas")
    suspend fun adicionarTarefa(@Body tarefa: TarefaRequestDto): Response<Tarefa>

    @PUT("tarefas/{id}")
    suspend fun atualizarTarefa(
        @Path("id") id: Long,
        @Body tarefa: TarefaRequestDto
    ): Response<Tarefa>

    @DELETE("tarefas/{id}")
    suspend fun deletarTarefa(@Path("id") id: Long): Response<Unit>
}
