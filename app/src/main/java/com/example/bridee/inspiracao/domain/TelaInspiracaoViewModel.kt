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
import java.util.Objects

class TelaInspiracaoViewModel: ViewModel() {

    val pexelsService = ApiInstance.createService(InpiracaoEndpoints::class.java)
    var pexelsInfo by mutableStateOf<PexelsResponseDto?>(null)
    var pexelsFavoriteImages by mutableStateOf<List<FavoriteImageResponse>>(mutableListOf())
    var lastPageFetched by mutableStateOf(1)

    fun findPexelsImage(inspiracao: String){
        if(Objects.isNull(pexelsInfo)){
            prepareForPexelsResponse()
        }
        viewModelScope.launch {
            try{
                val response = pexelsService.findImages(
                    inspiracao,
                    lastPageFetched.toString(),
                    "9"
                )
                if(response.code() == 200){
                    response.body()?.let { body ->
                        val current = pexelsInfo!!.photos.toMutableList()
                        val photosToBeAdded = body.photos.filter {!pexelsInfo!!.photos.contains(it)}
                        current.addAll(photosToBeAdded)

                        pexelsInfo = pexelsInfo!!.copy(
                            photos = current,
                            page = body.page,
                            perPage = body.perPage,
                            totalResults = body.totalResults,
                            nextPageUrl = body.nextPageUrl
                        )
                    }
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
                if(response.code() == 200){
                    val updatedPhotos = updateFavoriteImage(response.body(), image)
                    pexelsInfo = pexelsInfo!!.copy(photos = updatedPhotos)
                    Log.i("INSPIRAÇÕES", "Imagem favoritada com sucesso!")
                }
            }catch (e: Exception){
                Log.e("INSPIRAÇÕES", "Houve um erro ao favoritar a imagem")
            }
        }
    }

    private fun updateFavoriteImage(
        response: FavoriteImageResponse?,
        image: PexelPhotos
    ): List<PexelPhotos>{
        val responseId = response!!.id
        val updatedPhotos = pexelsInfo!!.photos.map {
            if(it.id == image.id){
                it.copy(id = responseId.toLong())
            }else{
                it
            }
        }
        return updatedPhotos
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

    fun desfavoriteImage(id: Int) {
        viewModelScope.launch {
            try {
                val response = pexelsService.desfavoriteImage(id)
                if(response.code() == 204){
                    val newItems = pexelsFavoriteImages.toMutableList().filter { it.id != id }
                    pexelsFavoriteImages = newItems.toMutableList()
                    Log.i("INSPIRAÇÕES", "Imagem desfavoritada com sucesso!")
                }
            }catch (e: Exception){
                Log.e("INSPIRAÇÕES", "Houve um erro ao desfavoritar a imagem")
            }
        }
    }

    fun toggleFavoriteImage(photoId: Long){
        val updatedPhotos = pexelsInfo!!.photos.map { photo ->
            if (photo.id == photoId) photo.copy(favorite = !photo.favorite) else photo
        }
        pexelsInfo = pexelsInfo!!.copy(photos = updatedPhotos)
    }


    fun prepareForPexelsResponse(){
        pexelsInfo = PexelsResponseDto()
    }

}