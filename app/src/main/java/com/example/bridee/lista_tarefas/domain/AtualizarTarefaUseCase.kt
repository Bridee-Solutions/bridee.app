
package com.example.bridee.lista_tarefas.domain

import com.example.bridee.lista_tarefas.data.Tarefa

class AtualizarTarefaUseCase(private val repository: TarefaRepository) {
    operator fun invoke(tarefa: Tarefa) = repository.atualizar(tarefa)
}
