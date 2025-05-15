
package com.example.bridee.lista_tarefas.domain

class DeletarTarefaUseCase(private val repository: TarefaRepository) {
    operator fun invoke(id: Int) = repository.deletar(id)
}
