package com.example.bridee.inspiracao.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.inspiracao.data.InpiracaoEndpoints
import kotlinx.coroutines.launch

class TelaInpiracaoViewModel: ViewModel() {

    val pexelsService = ApiInstance().createService(InpiracaoEndpoints::class.java)
    var pexelsInfo by mutableStateOf<PexelsResponseDto?>(PexelsResponseDto())


    fun findPexelsImage(inspiracao: String){
        viewModelScope.launch {
            val response = pexelsService.findImages(inspiracao)
            if(response.code() == 200){
                Log.i("INPIRAÇÕES", "Busca realizada com sucesso para inspiração $inspiracao")
                pexelsInfo = response.body()!!
            }
        }
    }

}