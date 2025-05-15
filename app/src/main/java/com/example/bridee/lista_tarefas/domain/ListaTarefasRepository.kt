package com.example.bridee.lista_tarefas.domain

import com.example.bridee.lista_tarefas.data.Tarefa


class TarefaRepository {
        private val tarefas = mutableListOf<Tarefa>()
        private var nextId = 1

        fun listar(): List<Tarefa> = tarefas

        fun adicionar(descricao: String) {
                tarefas.add(Tarefa(id = nextId++, descricao = descricao))
        }

        fun atualizar(tarefa: Tarefa) {
                tarefas.find { it.id == tarefa.id }?.apply {
                        descricao = tarefa.descricao
                        concluida = tarefa.concluida
                }
        }

        fun deletar(id: Int) {
                tarefas.removeIf { it.id == id }
        }
}
