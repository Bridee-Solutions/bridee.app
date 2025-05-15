
package com.example.bridee.lista_tarefas.domain

class AdicionarTarefaUseCase(private val repository: TarefaRepository) {
    operator fun invoke(descricao: String) = repository.adicionar(descricao)
}
