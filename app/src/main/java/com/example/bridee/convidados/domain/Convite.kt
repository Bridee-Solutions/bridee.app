package com.example.bridee.convidados.domain

data class Convite(
    var nome: String,
    var ano: String,
    val convidados: List<Convidado>
)
