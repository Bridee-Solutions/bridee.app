package com.example.bridee.auth.domain

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bridee.auth.data.AuthEndpoints
import com.example.bridee.core.api.ApiInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.DateTimeException
import java.time.LocalDate

class RegistrationSharedViewModel: ViewModel() {

    private val usuarioService = ApiInstance().createService(AuthEndpoints::class.java)
    private val _state = mutableStateOf(RegistrationState())
    val sharedRegistrationObject = _state
    val guestOptions = GuestOption().createGuestOptions()

    override fun onCleared() {
        super.onCleared()
    }

    fun salvarCasal(){
        val createdCasal = usuarioService.createCasal(_state.value)
        createdCasal.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                print("Chamada realizada com sucesso, status code ${response.code()}")
                if(call.isExecuted && response.code() == 201){
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                print("Operação falhou")
            }

        })
    }

    private fun convertStringToLocalDate(date: String): LocalDate?{
        val day: Int = date.substring(0,2).toInt()
        val month: Int = date.substring(2, 4).toInt()
        val year: Int = date.substring(4).toInt()
        return createLocalDate(year, month, day)
    }

    private fun createLocalDate(year: Int, month: Int, day: Int): LocalDate?{
        var localDate: LocalDate? = null

        try {
            localDate = LocalDate.of(year, month, day)
        }catch (e: DateTimeException){
            Log.e("DATE", "Data inválida")
        }

        return localDate
    }

    fun updateDataCasamento(dateString: String){
       sharedRegistrationObject.value = sharedRegistrationObject.value
            .copy(dataCasamento = convertStringToLocalDate(dateString))
    }

    fun updateGuestQuantity(guestOption: GuestOption){
        guestOptions.forEachIndexed {index, guest ->
            if(guestOption == guest){
                guestOptions[index] = guestOption.copy(selected = true)
                updateGuestQuantity(guestOption.getQuantity())
            }else{
                guestOptions[index].selected = false
            }
        }
    }

    private fun updateGuestQuantity(quantity: Int){
        _state.value.quantidadeConvidados = quantity
        _state.value.tamanhoCasamento = quantity
    }

}