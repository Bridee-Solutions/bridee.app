package com.example.bridee.calculadora.domain

data class CasalResponse(
    val id: Int,
    val nome: String,
    val email: String,
    val telefone: String,
    val estadoCivil: String,
    val enabled: Boolean,
    val nomeParceiro: String,
    val telefoneParceiro: String,
    val endereco: String,
    val cep: String
)
