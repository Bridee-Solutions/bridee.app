package com.example.bridee.lista_tarefas.domain

class AdicionarTarefaUseCase(private val repository: ListaTarefasRepository) {
    suspend operator fun invoke(tarefa: Tarefa) = repository.adicionarTarefa(tarefa)
}
