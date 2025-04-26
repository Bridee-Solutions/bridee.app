package com.example.bridee.auth.domain

import androidx.lifecycle.ViewModel
import com.example.bridee.auth.data.AuthEndpoints
import com.example.bridee.core.api.ApiInstance
import androidx.compose.runtime.mutableStateOf

class InspiracoesViewModel : ViewModel(){
    private val inspiracoesService = ApiInstance().createService(AuthEndpoints::class.java)
    private val _listpexels = mutableStateOf(RegistrationState())
}