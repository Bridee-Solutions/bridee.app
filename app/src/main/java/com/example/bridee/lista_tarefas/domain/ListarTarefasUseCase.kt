package com.example.bridee.lista_tarefas.domain


class ListarTarefasUseCase(private val repository: ListaTarefasRepository) {
    suspend operator fun invoke() = repository.listarTarefas()
}
