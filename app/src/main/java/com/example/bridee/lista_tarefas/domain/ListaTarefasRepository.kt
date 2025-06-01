package com.example.bridee.lista_tarefas.domain

import com.example.bridee.lista_tarefas.data.Tarefa
import com.example.bridee.lista_tarefas.data.TarefaRequestDto
import java.time.LocalDate


class TarefaRepository {
        private val tarefas = mutableListOf<Tarefa>()
        private var nextId = 1

        fun listar(): List<Tarefa> = tarefas

        fun adicionar(descricao: String, nome: String, mesesAnteriores: Int, categoria: String, status: String, dataLimite: LocalDate) {
                tarefas.add(Tarefa(id = nextId++, nome = nome, descricao = descricao, mesesAnteriores = mesesAnteriores, categoria = categoria, dataLimite = dataLimite, status = status))
        }

        fun atualizar(id: Int, tarefa: TarefaRequestDto) {
                tarefas.find { it.id == id }?.apply {
                        descricao = tarefa.descricao
                        status = tarefa.status
                }
        }

        fun deletar(id: Int) {
                tarefas.removeIf { it.id == id }
        }
}
