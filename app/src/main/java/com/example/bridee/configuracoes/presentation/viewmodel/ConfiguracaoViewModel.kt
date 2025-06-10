package com.example.bridee.configuracoes.presentation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.configuracoes.data.ConfiguracaoEndpoints
import com.example.bridee.configuracoes.domain.ConfiguracaoCasal
import com.example.bridee.configuracoes.domain.ConfiguracaoCasamento
import com.example.bridee.configuracoes.domain.ConfiguracaoInformation
import com.example.bridee.configuracoes.domain.ImageMetadata
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.home.domain.HomeCasamentoResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.time.LocalDate
import java.time.Period
import java.util.Objects

@SuppressLint("StaticFieldLeak")
class ConfiguracaoViewModel(
    application: Application
): AndroidViewModel(application) {

    private val context: Context = getApplication<Application>().applicationContext

    val configuracaoService = ApiInstance.createService(ConfiguracaoEndpoints::class.java)
    var information by mutableStateOf<ConfiguracaoInformation?>(null)
    var selectedImageUri by  mutableStateOf<Uri?>(null)

    fun updateConfiguracoes(){
        uploadFile()
        updateCasalInfo()
        updateCasamentoInfo()
    }

    fun uploadFile(){
        viewModelScope.launch {
            val casal = information?.casamentoResponse?.casal
            val imageMetadata = ImageMetadata(
                id = null,
                nome = "${casal?.nome ?: ""}&${casal?.nomeParceiro ?: ""}",
                url = "",
                extensao = "png"
            )
            selectedImageUri?.let {
                val inputStream = context.contentResolver.openInputStream(it) ?: return@launch
                val tempFile = File.createTempFile("upload", ".png", context.cacheDir)
                tempFile.outputStream().use { fileOut ->
                    inputStream.copyTo(fileOut)
                }
                val requestBody = tempFile.asRequestBody("image/*".toMediaTypeOrNull())
                val imagePart = MultipartBody.Part.createFormData("file", tempFile.name, requestBody)
                val metadataJson = Gson().toJson(imageMetadata)
                val metadataRequestBody = metadataJson
                    .toRequestBody("application/json".toMediaTypeOrNull())

                try {
                    val response = configuracaoService.uploadProfileImage(
                        metadata = metadataRequestBody,
                        file = imagePart
                    )
                    if(response.code() == 200){
                        Log.i("Configuração", "Upload realizado com sucesso!")
                    }
                }catch (e: Exception){
                    Log.e("Configuração", "${e.message}")
                }
            }
        }
    }

    fun updateCasamentoInfo(){
        viewModelScope.launch {
            val dataCasamento = information!!.casamentoResponse.dataCasamento
            val local = information!!.casamentoResponse.local
            val configuracaoCasamento = ConfiguracaoCasamento(dataCasamento, local)
            try {
                val response = configuracaoService.updateCasamentoInfo(configuracaoCasamento)
                if(response.code() == 200){
                    Log.i("Configuração", "Casal info atualizado com sucesso")
                }
            }catch (e: Exception){
                Log.e("Configuração", "Houve um erro ao atualizar o casamento ${e.message}")
            }
        }
    }

    fun updateCasalInfo(){
        viewModelScope.launch {
            val casal = information!!.casamentoResponse.casal
            val configuracaoCasal = ConfiguracaoCasal(
                casal.nome,
                casal.nomeParceiro,
                casal.telefone
            )
            try {
                val response = configuracaoService.updateCasalInfo(configuracaoCasal)
                if(response.code() == 200){
                    Log.i("Configuração", "Casal atualizado com sucesso.")
                }
            }catch (e: Exception){
                Log.e("Configuração", "Houve um erro ao atualizar o casal ${e.message}")
            }
        }
    }

    fun updateDataCasamentoInformation(dataCasamento: String): HomeCasamentoResponse {
        val casamentoInfo = information!!.casamentoResponse
        casamentoInfo.dataCasamento = dataCasamento
        return casamentoInfo
    }

    fun updateLocalInformation(local: String): HomeCasamentoResponse {
        val casamentoInfo = information!!.casamentoResponse
        casamentoInfo.local = local
        return casamentoInfo
    }

    fun updateNomeCasal(nome: String): HomeCasamentoResponse{
        val casamento = information!!.casamentoResponse
        val casal = casamento.casal
        casal.nome = nome
        return casamento
    }

    fun updateNomeParceiroCasal(nome: String): HomeCasamentoResponse{
        val casamento = information!!.casamentoResponse
        val casal = casamento.casal
        casal.nomeParceiro = nome
        return casamento
    }

    fun updateTelefoneCasal(telefone: String): HomeCasamentoResponse{
        val casamento = information!!.casamentoResponse
        val casal = casamento.casal
        casal.telefone = telefone
        return casamento
    }

    fun updateEmailCasal(email: String): HomeCasamentoResponse{
        val casamento = information!!.casamentoResponse
        val casal = casamento.casal
        casal.email = email
        return casamento
    }

    fun daysToWedding(): Int{
        var dateInfo = information?.casamentoResponse?.dataCasamento?.split("-")
        dateInfo = dateInfo?.reversed()
        if(Objects.isNull(dateInfo)){
            return 0
        }
        val year = dateInfo!![2].toInt()
        val month = dateInfo[1].toInt()
        val day = dateInfo[0].toInt()
        val date = LocalDate.of(year, month, day)
        return Period.between(LocalDate.now(), date).days
    }
}