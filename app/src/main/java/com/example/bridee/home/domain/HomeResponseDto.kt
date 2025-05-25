package com.example.bridee.home.domain

data class HomeResponseDto(
    val assessorResponseDto: HomeAssessorResponse,
    val casamentoInfo: HomeCasamentoResponse,
    val orcamentoFornecedorResponse: List<HomeFornecedorResponse>
)
