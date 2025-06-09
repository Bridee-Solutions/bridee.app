
package com.example.bridee.lista_tarefas.domain

data class TarefaRequestDto(
    val mesesAnteriores: Int,
    val nome: String,
    var descricao: String,
    var categoria: String,
    var status: String,
    var dataLimite: String
){
    companion object{
        fun createFromTarefa(tarefa: Tarefa): TarefaRequestDto{
            return TarefaRequestDto(
                mesesAnteriores = tarefa.mesesAnteriores,
                nome = tarefa.nome,
                descricao = tarefa.descricao,
                categoria = tarefa.categoria,
                status = tarefa.status,
                dataLimite = tarefa.dataLimite
            )
        }
    }

}
