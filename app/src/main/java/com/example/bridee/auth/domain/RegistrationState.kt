package com.example.bridee.auth.domain

import java.time.LocalDate

data class RegistrationState(
    var email: String = "",
    var senha: String = "",
    var confirmarSenha: String = "",
    var nome: String = "",
    var nomeParceiro: String = "",
    var local: String = "",
    var dataCasamento: LocalDate? = null,
    var isLocalReservado: Boolean = false,
    var quantidadeConvidados: Int = 0,
    var tamanhoCasamento: Int = 0
)
