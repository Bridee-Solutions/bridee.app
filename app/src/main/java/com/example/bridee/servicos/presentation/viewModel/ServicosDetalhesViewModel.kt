package com.example.bridee.servicos.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.servicos.data.ServicosEndpoints
import com.example.bridee.servicos.domain.AssociadoResponseDto
import kotlinx.coroutines.launch

class ServicosDetalhesViewModel : ViewModel() {
    private val servicosService = ApiInstance.createService(ServicosEndpoints::class.java)
    var subcategoriaNome: String = ""
    var subcategoriaId: Int = 0
    var associadoResponseDto by mutableStateOf<List<AssociadoResponseDto>>(mutableListOf())

    fun loadFornecedorDetails() {
        viewModelScope.launch {
            val response = servicosService.getFornecedoresBySubcategoria(subcategoriaId, subcategoriaNome)
            if (response.code() == 200) {
                associadoResponseDto = response.body()?.content ?: mutableListOf()
            }
        }
    }
}