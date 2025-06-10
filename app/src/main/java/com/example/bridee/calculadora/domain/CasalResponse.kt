package com.example.bridee.calculadora.domain

data class CasalResponse(
    val id: Int,
    var nome: String,
    var email: String,
    var telefone: String,
    val estadoCivil: String,
    val enabled: Boolean,
    var nomeParceiro: String,
    val telefoneParceiro: String,
    val endereco: String,
    val cep: String
)
