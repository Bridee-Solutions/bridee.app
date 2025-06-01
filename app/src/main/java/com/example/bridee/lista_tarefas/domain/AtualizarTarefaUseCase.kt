
package com.example.bridee.lista_tarefas.domain

import com.example.bridee.lista_tarefas.data.Tarefa
import com.example.bridee.lista_tarefas.data.TarefaRequestDto

class AtualizarTarefaUseCase(private val repository: TarefaRepository) {
    operator fun invoke(id: Int, tarefa: TarefaRequestDto) = repository.atualizar(id, tarefa)
}
