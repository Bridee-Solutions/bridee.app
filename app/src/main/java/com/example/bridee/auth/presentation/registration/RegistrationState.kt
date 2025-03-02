package com.example.bridee.auth.presentation.registration

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class RegistrationState(
    var email: MutableState<String> = mutableStateOf(""),
    var senha: MutableState<String> = mutableStateOf(""),
    var confirmarSenha: MutableState<String> = mutableStateOf(""),
    var nome: MutableState<String> = mutableStateOf(""),
    var nomeParceiro: MutableState<String> = mutableStateOf(""),
    var local: MutableState<String> = mutableStateOf(""),
    var dataCasamento: MutableState<String> = mutableStateOf("")
)
