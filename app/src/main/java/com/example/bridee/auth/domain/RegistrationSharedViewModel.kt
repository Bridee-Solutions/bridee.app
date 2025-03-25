package com.example.bridee.auth.domain

import androidx.lifecycle.ViewModel
import com.example.bridee.auth.presentation.registration.RegistrationState

class RegistrationSharedViewModel: ViewModel() {

    val sharedRegistrationObject = RegistrationState()

    override fun onCleared() {
        super.onCleared()
    }

    fun salvarCasal(){

    }

}