package com.example.bridee.servicos.domain

import com.example.bridee.R

fun getMockSubcategorias(): List<Subcategoria> {
    return listOf(
        Subcategoria(
            id = "1",
            nome = "Buffet Premium",
            local = "São Paulo",
            descricao = "Talismã é uma empresa planejadora, organizadora e executora de mais belas e emocionantes cerimônias de casamento. Com profissionais altamente especializados na arte de ser cerimonialista, essa equipe vai realizar seu sonho de uma forma única, especial e inesquecível.",
            imagem = R.drawable.fotomocada,
            precoMedio = "R$ 150,00 por pessoa"
        ),
        Subcategoria(
            id = "2",
            nome = "Decoração Clássica",
            local = "Rio de Janeiro",
            descricao = "Talismã é uma empresa planejadora, organizadora e executora de mais belas e emocionantes cerimônias de casamento. Com profissionais altamente especializados na arte de ser cerimonialista, essa equipe vai realizar seu sonho de uma forma única, especial e inesquecível.",
            imagem = R.drawable.fotomocada,
            precoMedio = "R$ 5.000,00"
        )
    )
}