package com.example.bridee.calculadora.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.R
import com.example.bridee.calculadora.data.CalculadoraEndpoints
import com.example.bridee.core.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.Objects

class CalculadoraViewModel: ViewModel() {

    private val calculadoraService = ApiInstance.createService(CalculadoraEndpoints::class.java)
    var showEditDialog by mutableStateOf(false)
    var orcamentoResponse by mutableStateOf<OrcamentoResponse?>(null);
    var novoOrcamento by mutableStateOf("")

    fun findCasamentoOrcamento(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = calculadoraService.findOrcamento()
                if(response.code() == 200){
                    orcamentoResponse = response.body()
                    Log.i("ORCAMENTO", "Orcamento encontrado com sucesso! body: ${orcamentoResponse}")
                }else{
                    Log.e("ORCAMENTO", "Houve um erro ao buscar o orcamento!")
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun updateCasamentoOrcamento(){
        val orcamento = BigDecimal(novoOrcamento)
        val request = OrcamentoTotalRequest(orcamento)
        viewModelScope.launch {
            try {
                val response = calculadoraService.updateOrcamento(request)
                if(response.code() == 200){
                    Log.i("ORCAMENTO", "Orcamento atualizado com sucesso")
                    orcamentoResponse = orcamentoResponse?.copy(orcamentoTotal = orcamento)
                }
            }catch (e: Exception){
                Log.e("ORCAMENTO", "Não foi possível atualizar o orçamento do casal")
            }

        }
    }

    fun adicionarNovaCategoria(item: ItemOrcamentoResponse?, novaCategoria: String){
        val itensRequest = orcamentoResponse?.itemOrcamentos
            ?.map { ItemOrcamentoRequest.itemOrcamentoRequest(it) }?.toMutableList()
        val custos = item?.custos?.map { CustoItemRequest.custoItemRequest(it) }?.toMutableList()
        itensRequest?.add(
            ItemOrcamentoRequest(
            id = item?.id,
            tipo = novaCategoria,
            custos = custos ?: mutableListOf()
        )
        )
        viewModelScope.launch {
            val response = calculadoraService.saveItensOrcamento(itensRequest!!)
            try {
                if(response.code() == 200){
                    orcamentoResponse = orcamentoResponse?.copy(itemOrcamentos = response.body()!!)
                    Log.i("CALCULADORA", "Categoria $novaCategoria inserida com sucesso")
                }
            }catch (e: Exception){
                Log.e("CALCULADORA", "Houve um erro ao cadastrar a categoria $novaCategoria")
            }
        }
    }

    fun defaultItens(): List<ItemOrcamentoResponse>{
        val itensList = mutableListOf(
            ItemOrcamentoResponse(null,"Fornecedores", mutableListOf()),
            ItemOrcamentoResponse(null,"Moda e Beleza", mutableListOf()),
            ItemOrcamentoResponse(null,"Decoração", mutableListOf()),
            ItemOrcamentoResponse(null,"Transporte e Acomodação", mutableListOf()),
            ItemOrcamentoResponse(null,"Entretenimento", mutableListOf())
        )
        if(orcamentoResponse?.itemOrcamentos.isNullOrEmpty()){
            orcamentoResponse?.itemOrcamentos = itensList

        }
        return itensList
    }

    fun adicionarNovoCusto(
        itemOrcamentoResponse: ItemOrcamentoResponse,
        addNewSubcategoria: String,
        newPrice: BigDecimal,
        custoId: Int?
    ) {
        val custoRequest = itemOrcamentoResponse
            ?.custos?.map { CustoItemRequest.custoItemRequest(it) }?.toMutableList()
        val oldCusto = itemOrcamentoResponse.custos.filter { custoId == it.id }[0]
        custoRequest?.add(
            CustoItemRequest(
                id = custoId,
                nome = addNewSubcategoria,
                precoAtual = newPrice
            )
        )
        val itens = orcamentoResponse?.itemOrcamentos
            ?.map { ItemOrcamentoRequest.itemOrcamentoRequest(it) }
        val itensRequest = itens?.filter {
            it.id == itemOrcamentoResponse.id
        }
        if (custoRequest != null) {
            itensRequest?.get(0)?.custos = custoRequest
        }
        viewModelScope.launch {
            val response = calculadoraService.saveItensOrcamento(itens!!)
            try {
                if(response.code() == 200){
                    orcamentoResponse = orcamentoResponse?.copy(
                        itemOrcamentos = response.body()!!,
                        orcamentoGasto = orcamentoResponse?.orcamentoGasto?.plus(newPrice)?.minus(oldCusto.precoAtual) ?: BigDecimal(0)
                    )
                    Log.i("CALCULADORA", "Categoria $addNewSubcategoria inserida com sucesso")
                }
            }catch (e: Exception){
                Log.e("CALCULADORA", "Houve um erro ao cadastrar a categoria $addNewSubcategoria")
            }
        }
    }
}