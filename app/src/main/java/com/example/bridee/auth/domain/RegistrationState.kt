package com.example.bridee.auth.domain

data class RegistrationState(
    var email: String = "",
    var senha: String = "",
    var confirmarSenha: String = "",
    var nome: String = "",
    var nomeParceiro: String = "",
    var local: String = "",
    var dataCasamento: String = "",
    var isLocalReservado: Boolean = false,
    var quantidadeConvidados: Int = 0,
    var tamanhoCasamento: Int = 0
)
