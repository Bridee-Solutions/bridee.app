
package com.example.bridee.lista_tarefas.data

import java.time.LocalDate

data class TarefaResponseDto(
    val id: Long,
    val mesesAnteriores: Int,
    val nome: String,
    var descricao: String,
    val categoria: String,
    val status: String,
    val dataLimite: LocalDate = LocalDate.now()
)
