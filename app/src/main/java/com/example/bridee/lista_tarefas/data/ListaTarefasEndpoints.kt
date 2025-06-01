package com.example.bridee.lista_tarefas.data

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ListaTarefasEndpoints {
    @GET("tarefas")
    suspend fun listarTarefas(): List<Tarefa>

    @POST("tarefas")
    suspend fun adicionarTarefa(@Body tarefa: Tarefa): Tarefa

    @PUT("tarefas/{id}")
    suspend fun atualizarTarefa(@Path("id") id: Long, @Body tarefa: Tarefa): Tarefa

    @DELETE("tarefas/{id}")
    suspend fun deletarTarefa(@Path("id") id: Long)
}
