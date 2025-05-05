package com.example.bridee.lista_tarefas.domain

interface ListaTarefasRepository {
        suspend fun listarTarefas(): List<Tarefa>
        suspend fun adicionarTarefa(tarefa: Tarefa): Tarefa
        suspend fun atualizarTarefa(tarefa: Tarefa): Tarefa
        suspend fun deletarTarefa(id: Long)


}