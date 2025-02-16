package com.example.bridee.auth.presentation.login

import androidx.compose.runtime.MutableState

data class LoginState(var email: MutableState<String>,
                      var senha: MutableState<String>)