package com.example.bridee.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Period
import java.util.Objects

class HomeViewModel: ViewModel() {

    private val homeService = ApiInstance.createService(HomeEndpoints::class.java)
    private val _homeResponse by mutableStateOf<HomeResponseDto?>(null)
    var homeResponse = _homeResponse
    var searchFornecedorResult: MutableList<Fornecedor> = mutableListOf()
    val searchAssessorResult:  MutableList<AssessorResponse> = mutableListOf()
    var categories by mutableStateOf<List<Categoria>>(mutableListOf())

    private fun updateSubcategoriaInfo(){
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

    fun findHomeInfo(){
        viewModelScope.launch {
            try {
                val response = homeService.fetchHomeInfo()
                if(response.code() == 200){
                    homeResponse = response.body()
                    updateSubcategoriaInfo()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private val icons: MutableMap<String, Int> = mutableMapOf(
        Pair("Local", R.drawable.hospedagem),
        Pair("Florista", R.drawable.buqueflores),
        Pair("Buffet e Gastronomia", R.drawable.buffet),
        Pair("Vestido", R.drawable.weddingdress),
        Pair("Fotógrafo", R.drawable.fotografia),
        Pair("Decoração", R.drawable.arch),
        Pair("Hospedagem", R.drawable.honeymoon),
        Pair("Confeitaria", R.drawable.cake),
        Pair("Moda e Beleza", R.drawable.cosmetics),
        Pair("Videógrafos", R.drawable.videographer),
        Pair("Papelaria", R.drawable.letter),
        Pair("Entretenimento", R.drawable.confetti)
    )

    fun fornecedorIcon(nome: String): Int?{
        return icons[nome]
    }

    fun findCategories(){
        viewModelScope.launch {
            val response = homeService.fetchCategories()
            if(response.code() == 200){
                val responseContent = response.body()!!.content
                responseContent.forEach{
                    it.drawableResId = fornecedorIcon(it.nome) ?: R.drawable.wedding_day
                    it.descricao = "Buscar fornecedores"
                }
                categories = responseContent
            }
        }
    }

    fun coupleName(): String{
        val casal = homeResponse?.casamentoInfo?.casal
        val casalNome = casal?.nome ?: ""
        val parceiroNome = casal?.nomeParceiro ?: ""
        return "$casalNome & $parceiroNome"
    }

    fun weddingDate(): String?{
        val date = homeResponse?.casamentoInfo?.dataCasamento
        return date?.split("-")
            ?.reversed()?.joinToString("/")
    }

    fun location(): String{
        return homeResponse?.casamentoInfo?.local ?: ""
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

    fun searchFornecedor(nome: String, categoriaId: Int){
        viewModelScope.launch {
            try {
                val response = homeService.searchFornecedor(nome, categoriaId)
                if(response.code() == 200){
                    searchFornecedorResult = response.body()!!.content
                }
            }catch (e: Exception){

            }
        }
    }
}