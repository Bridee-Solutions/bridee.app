package com.example.bridee.auth.domain

data class AuthenticationRequest(
    val email: String = "",
    val senha: String = ""
)
