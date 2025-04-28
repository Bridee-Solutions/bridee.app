package com.example.bridee.auth.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.auth.data.PexelsApi
import com.example.bridee.inspiracao.domain.PexelsImageResponseDto
import com.example.bridee.inspiracao.domain.PexelsPhotos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InspiracoesViewModel(private val pexelsApi: PexelsApi) : ViewModel() {
    // Estado para imagens da API Pexels (Inspirações)
    private val _images = MutableStateFlow<PexelsImageResponseDto?>(null)
    val images: StateFlow<PexelsImageResponseDto?> = _images

    // Estado para imagens favoritadas (Quadro de Inspirações)
    private val _favorites = MutableStateFlow<List<PexelsPhotos>?>(null)
    val favorites: StateFlow<List<PexelsPhotos>?> = _favorites

    // Estado de carregamento
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Estado de erro
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    // Busca imagens da API Pexels (para a tela "Inspirações")
    fun searchImages(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null // Reseta mensagens de erro

            try {
                val response = pexelsApi.getImages(query)
                if (response.isSuccessful) {
                    _images.value = response.body() // Atualiza o StateFlow com as imagens
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

    // Busca imagens favoritadas (para o "Quadro de Inspirações")
    fun loadFavorites() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = pexelsApi.getFavorites() // Supondo que este endpoint existe
                if (response.isSuccessful) {
                    _favorites.value = response.body()?.photos // Atualiza o StateFlow de favoritos
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao carregar favoritos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}