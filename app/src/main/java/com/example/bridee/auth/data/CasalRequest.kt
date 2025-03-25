package com.example.bridee.auth.data

import java.time.LocalDate

data class CasalRequest(
    var nome: String,
    var email: String,
    var senha: String,
    var estadoCivil: String,
    var nomeParceiro: String,
    var telefoneParceiro: String,
    var local: String,
    var isLocalReservado: Boolean,
    var quantidadeConvidados: Int,
    var tamanhoCasamento: String,
    var dataCasamento: LocalDate
)
