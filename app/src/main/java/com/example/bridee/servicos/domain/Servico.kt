package com.example.bridee.servicos.domain

import com.example.bridee.R

data class Servico(
    val id: String,
    val nome: String,
    val localizacao: String,
    val descricao: String,
    val servicosOferecidos: List<String>,
    val perguntasFrequentes: List<PerguntaResposta>,
    val endereco: String,
    val imagem: Int = R.drawable.image_home
)