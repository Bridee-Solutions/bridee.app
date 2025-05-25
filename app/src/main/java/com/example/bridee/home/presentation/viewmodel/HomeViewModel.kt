package com.example.bridee.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.R
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.home.data.HomeEndpoints
import com.example.bridee.home.domain.AssessorResponse
import com.example.bridee.home.domain.Categoria
import com.example.bridee.home.domain.Fornecedor
import com.example.bridee.home.domain.HomeResponseDto
import com.example.bridee.home.domain.icons
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Period
import java.util.Objects

class HomeViewModel: ViewModel() {

    private val homeService = ApiInstance.createService(HomeEndpoints::class.java)
    private val _homeResponse by mutableStateOf<HomeResponseDto?>(null)
    var homeResponse = _homeResponse
    var searchFornecedorResult by mutableStateOf<List<Fornecedor>>(mutableListOf())
    var searchAssessorResult by mutableStateOf<List<AssessorResponse>>(mutableListOf())
    var categories by mutableStateOf<List<Categoria>>(mutableListOf())
    var assessor by mutableStateOf<AssessorResponse?>(null)

    private fun updateCategoriaInfo(){
        val orcamentoResponse = this.homeResponse?.orcamentoFornecedorResponse
        this.categories.forEach {category ->
            val orcamento = orcamentoResponse?.filter {
                it.fornecedor.subcategoriaServico?.nome == category.nome
            }
            if(!orcamento.isNullOrEmpty()){
                category.selecionado = true
            }
        }
    }

    private fun updateAssessorInfo(){
        val assessor = this.homeResponse?.assessorResponseDto?.assessorResponse
        if(Objects.nonNull(assessor)){
            this.assessor = assessor
        }
    }

    fun findHomeInfo(){
        viewModelScope.launch {
            try {
                val response = homeService.fetchHomeInfo()
                if(response.code() == 200){
                    val body = response.body()
                    updateCategoriaInfo()
                    updateAssessorInfo()
                    homeResponse = body
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun fornecedorIcon(nome: String): Int?{
        return icons[nome]
    }

    fun findCategories(){
        viewModelScope.launch {
            val response = homeService.fetchCategories()
            if(response.code() == 200){
                val responseContent = response.body()?.content ?: mutableListOf()
                responseContent.forEach{
                    it.drawableResId = fornecedorIcon(it.nome) ?: R.drawable.wedding_day
                    it.descricao = "Buscar fornecedores"
                }
                categories = responseContent
            }
        }
    }

    fun weddingDate(): String?{
        val date = homeResponse?.casamentoInfo?.dataCasamento
        return date?.split("-")
            ?.reversed()?.joinToString("/")
    }

    fun daysToWedding(): Int{
        val dateInfo = weddingDate()?.split("/")
        if(Objects.isNull(dateInfo)){
            return 0
        }
        val year = dateInfo!![2].toInt()
        val month = dateInfo[1].toInt()
        val day = dateInfo[0].toInt()
        val date = LocalDate.of(year, month, day)
        return Period.between(LocalDate.now(), date).days
    }

    fun hoursToWedding(): Int{
        val daysToWedding = daysToWedding()
        return daysToWedding * 24
    }

    fun minutesToWedding(): Int{
        val hoursToWedding = hoursToWedding()
        return hoursToWedding * 60
    }

    fun searchFornecedor(categoriaId: Int, nome: String){
        viewModelScope.launch {
            try {
                val response = homeService.searchFornecedor(categoriaId, nome)
                if(response.code() == 200){
                    searchFornecedorResult = response.body()?.content ?: mutableListOf()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun selectFornecedor(id: Int){
        val fornecedor = searchFornecedorResult.filter { it.id == id }[0]
        fornecedor.selected = true
        val fornecedores = searchFornecedorResult.filter { it.id != id }.toMutableList()
        fornecedores.forEach { it.selected = false }
        searchFornecedorResult = (mutableListOf(fornecedor) + fornecedores).toMutableList()
    }

    fun searchAssessor(nome: String){
        viewModelScope.launch {
            try {
                val response = homeService.searchAssessor(nome)
                if(response.code() == 200){
                    searchAssessorResult = response.body()?.content ?: mutableListOf()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun selectAssessor(id: Int){
        val assessor = searchAssessorResult.filter { it.id == id }[0]
        assessor.selected = true
        val assessores = searchAssessorResult.filter { it.id != id }.toMutableList()
        assessores.forEach { it.selected = false }
        searchAssessorResult = (mutableListOf(assessor) + assessores).toMutableList()
    }
}