package com.example.bridee.home.domain

data class HomeResponseDto(
    val assessorResponseDto: HomeAssessorResponse,
    val casamentoInfo: HomeCasamentoResponse,
    val orcamentoFornecedorResponse: List<HomeFornecedorResponse>,
    val assentosResumo: HomeAssentosResponse,
    val tarefas: HomeTarefasResponse,
    val orcamento: HomeOrcamentoResponse
)
