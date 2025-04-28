package com.example.bridee.auth.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bridee.auth.data.PexelsApi

class InspiracoesViewModelFactory (private val pexelsApi: PexelsApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InspiracoesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InspiracoesViewModel(pexelsApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}