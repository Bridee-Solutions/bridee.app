
package com.example.bridee.lista_tarefas.domain

import java.time.LocalDate

class AdicionarTarefaUseCase(private val repository: TarefaRepository) {
    operator fun invoke(descricao: String, nome: String, mesesAnteriores: Int, categoria: String, status: String, dataLimite: LocalDate) = repository.adicionar(descricao, nome, mesesAnteriores, categoria, status, dataLimite)
}
