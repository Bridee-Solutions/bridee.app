package com.example.bridee.lista_tarefas.domain

class AtualizarTarefaUseCase(private val repository: ListaTarefasRepository) {
    suspend operator fun invoke(tarefa: Tarefa) = repository.atualizarTarefa(tarefa)
}
