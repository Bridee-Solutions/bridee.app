package com.example.bridee.auth.domain

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.auth.data.AuthEndpoints
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.core.store.TokenStore
import kotlinx.coroutines.launch

class AuthenticationViewModel(val context: Context): ViewModel() {

    private val usuarioService = ApiInstance.createService(AuthEndpoints::class.java)
    private val _state = mutableStateOf(AuthenticationRequest())
    val loginState = _state
    var isEnabled by mutableStateOf(false)
    var showDialog by mutableStateOf(false)

    fun authenticate() {
        viewModelScope.launch {
            val email = _state.value.email
            try {
                val authenticateUser = usuarioService.authenticate(_state.value)
                isEnabled = authenticateUser.body()?.enabled ?: false
                if(authenticateUser.code() == 200){
                    TokenStore.saveAccessToken(context, authenticateUser.body()!!.accessToken)
                    Log.i("LOGIN", "Usuário $email autenticado com sucesso")
                }else{
                    Log.e("LOGIN", "Credenciais inválidas para o usuário $email")
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
            showDialog = !isEnabled
        }

    }

}