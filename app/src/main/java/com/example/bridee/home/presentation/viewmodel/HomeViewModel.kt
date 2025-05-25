package com.example.bridee.home.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.home.data.HomeEndpoints
import com.example.bridee.home.domain.HomeResponseDto
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters
import java.util.Objects

class HomeViewModel: ViewModel() {

    private val homeService = ApiInstance.createService(HomeEndpoints::class.java)
    private val _homeResponse by mutableStateOf<HomeResponseDto?>(null)
    var homeResponse = _homeResponse

    fun findHomeInfo(){
        viewModelScope.launch {
            try {
                val response = homeService.fetchHomeInfo()
                if(response.code() == 200){
                    homeResponse = response.body()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun coupleName(): String{
        val casal = homeResponse?.casamentoInfo?.casal
        return "${casal?.nome} & ${casal?.nomeParceiro}"
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
}