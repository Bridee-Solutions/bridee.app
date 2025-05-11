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

class TelaInspiracaoViewModel: ViewModel() {

    val pexelsService = ApiInstance().createService(InpiracaoEndpoints::class.java)
    var pexelsInfo by mutableStateOf<PexelsResponseDto?>(PexelsResponseDto())
    var pexelsFavoriteImages by mutableStateOf<List<FavoriteImageResponse>>(mutableListOf())

    fun findPexelsImage(inspiracao: String){
        viewModelScope.launch {
            try{
                val response = pexelsService.findImages(inspiracao)
                if(response.code() == 200){
                    pexelsInfo = response.body()!!
                    Log.i("INSPIRAÇÕES", "Busca realizada com sucesso para inspiração $inspiracao")
                }
            }catch (e: Exception){
                Log.e("INSPIRAÇÕES", "Aconteceu um erro ao buscar as imagens, erro: ${e.message}")
            }
        }
    }

    fun favoriteImage(image: PexelPhotos){
        viewModelScope.launch {
            try {
                val response = pexelsService.favoriteImage(image.toImageMetadata())
                if(response.code() == 204){
                    Log.i("INSPIRAÇÕES", "Imagem favoritada com sucesso!")
                }
            }catch (e: Exception){
                Log.e("INSPIRAÇÕES", "Houve um erro ao favoritar a imagem")
            }
        }
    }

    fun findFavoritesImages(){
        viewModelScope.launch {
            try {
                val response = pexelsService.findFavoritesImages();
                if(response.code() == 200){
                    pexelsFavoriteImages = response.body()!!.content
                    Log.i("INSPIRAÇÕES", "Busca pelas imagens favoritadas realizadas com sucesso!")
                }
            }catch (e: Exception){
                Log.e("INSPIRAÇÕES", "Busca pelas imagens favoritas retornou o seguinte erro ${e.message}")
            }
        }
    }

}