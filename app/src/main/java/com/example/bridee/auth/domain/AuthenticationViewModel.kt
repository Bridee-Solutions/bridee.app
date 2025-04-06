package com.example.bridee.auth.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bridee.auth.data.AuthEndpoints
import com.example.bridee.core.api.ApiInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel: ViewModel() {

    private val usuarioService = ApiInstance().createService(AuthEndpoints::class.java)
    private val _state = mutableStateOf(AuthenticationRequest())
    val loginState = _state
    var isEnabled by mutableStateOf(false)

    fun authenticate() {
        val authenticateUser = usuarioService.authenticate(_state.value)
        authenticateUser.enqueue(object : Callback<AuthenticationResponse> {
            override fun onResponse(
                call: Call<AuthenticationResponse>,
                response: Response<AuthenticationResponse>,
            ) {
                Log.i("LOGIN", """
                    Chamada realizada para o login de ${_state.value.email}, com o status ${response.code()}
                """.trimIndent())
                if(response.code() == 200){
                    isEnabled = response.body()?.enabled ?: false
                }
            }

            override fun onFailure(call: Call<AuthenticationResponse>, t: Throwable) {
                Log.i("LOGIN", "Chamada falhou com o seguinte erro: ${t.message}")
            }

        })
    }

}