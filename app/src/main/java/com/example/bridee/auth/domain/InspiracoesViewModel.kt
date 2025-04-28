package com.example.bridee.auth.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.auth.data.PexelsApi
import com.example.bridee.inspiracao.domain.PexelsImageResponseDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InspiracoesViewModel(private val pexelsApi: PexelsApi) : ViewModel() {
    private val _images = MutableStateFlow<PexelsImageResponseDto?>(null)
    val images: StateFlow<PexelsImageResponseDto?> = _images

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading


    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage


    fun searchImages(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = pexelsApi.getImages(query)
                if (response.isSuccessful) {
                    _images.value = response.body()
                } else {
                    _errorMessage.value = "Erro na API: ${response.code()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erro de rede: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}