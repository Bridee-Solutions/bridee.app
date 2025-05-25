package com.example.bridee.home.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.home.data.HomeEndpoints
import com.example.bridee.home.domain.HomeResponseDto
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val homeService = ApiInstance.createService(HomeEndpoints::class.java)
    private val _homeResponse = mutableStateOf<HomeResponseDto?>(null)
    var homeResponse = _homeResponse
    init {
        Log.i("VIEWMODEL","HOME VIEW MODEL CREATED")
    }
    fun findHomeInfo(){

        viewModelScope.launch {
            try {
                val response = homeService.fetchHomeInfo()
                if(response.code() == 200){
                    homeResponse.value = response.body()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}