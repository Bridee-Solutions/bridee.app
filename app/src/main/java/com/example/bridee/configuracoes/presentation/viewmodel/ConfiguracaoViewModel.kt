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
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

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
                configuracaoService.updateCasalInfo(configuracaoCasal)
            }catch (e: Exception){
                Log.e("Configuração", "Houve um erro ao atualizar o casal ${e.message}")
            }
        }
    }

}