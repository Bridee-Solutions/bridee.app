package com.example.bridee.auth.presentation.registration

import androidx.compose.runtime.MutableState

data class RegistrationState(var email: MutableState<String>,
    var senha: MutableState<String>,
    var confirmarSenha: MutableState<String>)
