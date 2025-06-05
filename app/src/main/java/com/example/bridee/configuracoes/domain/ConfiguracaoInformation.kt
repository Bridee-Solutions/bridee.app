package com.example.bridee.configuracoes.domain

import com.example.bridee.home.domain.HomeCasamentoResponse
import com.example.bridee.home.domain.HomeOrcamentoResponse

data class ConfiguracaoInformation(
    val imageUrl: String?,
    val casamentoResponse: HomeCasamentoResponse,
    val orcamentoResponse: HomeOrcamentoResponse
)