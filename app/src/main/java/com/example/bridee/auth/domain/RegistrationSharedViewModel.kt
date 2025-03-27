package com.example.bridee.auth.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bridee.auth.data.AuthEndpoints
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.core.api.ApiInstance

class RegistrationSharedViewModel: ViewModel() {

    private val usuarioService = ApiInstance().createService(AuthEndpoints::class.java)
    private val _state = mutableStateOf(RegistrationState())
    val sharedRegistrationObject = _state

    override fun onCleared() {
        super.onCleared()
    }

    fun salvarCasal(){
        val createdCasal = usuarioService.createCasal(this._state.value)
        if(createdCasal.code() != 201){
            //TODO: Toast
        }
    }

}