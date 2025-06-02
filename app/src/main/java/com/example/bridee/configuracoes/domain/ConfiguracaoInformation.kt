package com.example.bridee.configuracoes.domain

import com.example.bridee.home.domain.HomeCasamentoResponse

data class ConfiguracaoInformation(
    val imageUrl: String?,
    val casamentoResponse: HomeCasamentoResponse
)