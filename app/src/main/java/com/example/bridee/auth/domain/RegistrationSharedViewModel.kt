package com.example.bridee.auth.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.auth.data.AuthEndpoints
import com.example.bridee.core.api.ApiInstance
import kotlinx.coroutines.launch

class RegistrationSharedViewModel: ViewModel() {

    private val usuarioService = ApiInstance().createService(AuthEndpoints::class.java)
    private val _state = mutableStateOf(RegistrationState())
    val sharedRegistrationObject = _state
    val guestOptions = GuestOption().createGuestOptions()
    var isTermsApproved by mutableStateOf(false)
    var isCoupleSavedSuccessfully by mutableStateOf(false)
    var isUserAlreadyRegistered by mutableStateOf(false)
    var showDialog by mutableStateOf(false)
    
    override fun onCleared() {
        super.onCleared()
    }

    fun saveCasal(){
        viewModelScope.launch {
            val createdCasal = usuarioService.createCasal(_state.value)
            val statusCode = createdCasal.code()
            if(statusCode == 201){
                isCoupleSavedSuccessfully = true
            }else{
                Log.e("CADASTRO", "Cadastro não foi realizado com sucesso com o seguinte statusCode ${statusCode}")
            }
        }
    }
    
    fun verifyEmail(){
        viewModelScope.launch {
            val email = _state.value.email
            try {
                val verifyEmail = usuarioService.validateEmail(email)
                val statusCode = verifyEmail.code();
                if(statusCode == 200){
                    isUserAlreadyRegistered = true
                    Log.w("CADASTRO", "E-mail $email já cadastrado na plataforma")
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun convertStringToLocalDate(date: String): String{
        val day: String = date.substring(0,2)
        val month: String = date.substring(2, 4)
        val year: String = date.substring(4)
        val invertedString: Array<String> = arrayOf(year, month, day)
        return invertedString.joinToString("-")
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

    fun isFase1Valid(): Boolean{
        return isEmailValid() && passwordsMatches()
    }

    fun isEmailValid(): Boolean{
        val emailRegex = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+\$")
        val email = _state.value.email
        return emailRegex.matches(email)
    }

    fun isPasswordValid(): Boolean{
        val senhaRegex = Regex("^(?=(.*[a-z]))(?=(.*[A-Z]))(?=(.*\\d))(?=(.*[!@#\\\$%\\^&\\*]))[A-Za-z\\d!@#\\\$%\\^&\\*]{8,}\$")
        val senha = _state.value.senha
        return senhaRegex.matches(senha)
    }

    fun passwordsMatches(): Boolean{
        val senhaRegex = Regex("^(?=(.*[a-z]))(?=(.*[A-Z]))(?=(.*\\d))(?=(.*[!@#\\\$%\\^&\\*]))[A-Za-z\\d!@#\\\$%\\^&\\*]{8,}\$")
        val state = _state.value
        return state.senha == state.confirmarSenha
                && senhaRegex.matches(state.confirmarSenha)
    }

    fun isFase3Valid(): Boolean{
        return isNomeValid() && isParceiroNomeValid()
    }

    fun isNomeValid(): Boolean{
        val nome = _state.value.nome
        return nome.length >= 3
    }

    fun isParceiroNomeValid(): Boolean{
        val nomeParceiro = _state.value.nomeParceiro
        return nomeParceiro.length >= 3
    }

    fun isFase4Valid(): Boolean{
        val state = _state.value
        val local = state.local
        return (state.isLocalReservado && local.isNotBlank())
                || !state.isLocalReservado
    }

    fun isLocalReservado(local: String): Boolean{
        return local.isNotBlank()
    }

}