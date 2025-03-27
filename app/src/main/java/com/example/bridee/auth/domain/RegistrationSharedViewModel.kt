package com.example.bridee.auth.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bridee.auth.presentation.registration.RegistrationState

class RegistrationSharedViewModel: ViewModel() {

    private val _state = mutableStateOf(RegistrationState())
    val sharedRegistrationObject = _state

    override fun onCleared() {
        super.onCleared()
    }

    fun salvarCasal(){

    }

}