package com.example.bridee.auth.data

import com.example.bridee.auth.domain.AuthenticationRequest
import com.example.bridee.auth.domain.AuthenticationResponse
import com.example.bridee.auth.domain.RegistrationState
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthEndpoints {

    @POST("casais")
    suspend fun createCasal(@Body casalRequest: RegistrationState): Response<Void>

    @GET("usuarios/{email}")
    suspend fun validateEmail(@Path(value = "email") email: String): Response<Void>

    @POST("authentication")
    suspend fun authenticate(@Body request: AuthenticationRequest): Response<AuthenticationResponse>
}