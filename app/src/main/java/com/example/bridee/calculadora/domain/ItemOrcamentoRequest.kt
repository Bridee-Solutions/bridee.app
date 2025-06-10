package com.example.bridee.calculadora.domain

data class ItemOrcamentoRequest(
    val id: Int?,
    var tipo: String,
    var custos: MutableList<CustoItemRequest>
){

    companion object{
        fun itemOrcamentoRequest(itemOrcamento: ItemOrcamentoResponse): ItemOrcamentoRequest{
            return ItemOrcamentoRequest(
                tipo = itemOrcamento.tipo,
                id = itemOrcamento.id,
                custos = itemOrcamento.custos.map {
                    CustoItemRequest(
                        id = it.id,
                        nome = it.nome,
                        precoAtual = it.precoAtual
                    )
                }.toMutableList()
            )
        }
    }

}
