package com.example.bridee.calculadora.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.calculadora.data.CalculadoraEndpoints
import com.example.bridee.core.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
}