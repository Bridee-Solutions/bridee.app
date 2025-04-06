package com.example.bridee.auth.domain

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String,
    val enabled: Boolean
)