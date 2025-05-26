package com.example.bridee.servicos.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.servicos.data.ServicosEndpoints
import com.example.bridee.servicos.domain.Categoria
import com.example.bridee.servicos.domain.Subcategoria
import kotlinx.coroutines.launch

class CategoriasViewModel : ViewModel() {
    private val servicosService = ApiInstance.createService(ServicosEndpoints::class.java)
    private var _categorias by mutableStateOf<List<Categoria>>(mutableListOf())
    var categorias = mutableStateMapOf<String, List<Subcategoria>>()

    fun loadServicos(){
        viewModelScope.launch {
            try {
                val response = servicosService.getCategories()
                if(response.code() == 200){
                    _categorias = response.body()?.content ?: mutableListOf()
                    transformCategories()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun transformCategories(){
        val locaisSubcategory = this._categorias.filter { it.nome == "Locais" }
            .flatMap { it.subcategorias }
        val othersSubcategories = this._categorias.filter { it.nome != "Locais" }
            .flatMap { it.subcategorias }
        categorias["Estilo de casamento"] = locaisSubcategory
        categorias["Fornecedores"] = othersSubcategories
    }


}