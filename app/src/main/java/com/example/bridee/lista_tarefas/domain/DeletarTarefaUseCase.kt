package com.example.bridee.lista_tarefas.domain

class DeletarTarefaUseCase(private val repository: ListaTarefasRepository) {
    suspend operator fun invoke(id: Long) = repository.deletarTarefa(id)
}
