
package com.example.bridee.lista_tarefas.domain

class ListarTarefasUseCase(private val repository: TarefaRepository) {
    operator fun invoke() = repository.listar()
}
