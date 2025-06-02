package com.example.bridee.configuracoes.presentation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.configuracoes.data.ConfiguracaoEndpoints
import com.example.bridee.configuracoes.domain.ConfiguracaoInformation
import com.example.bridee.configuracoes.domain.ImageMetadata
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.home.domain.HomeCasamentoResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@SuppressLint("StaticFieldLeak")
class ConfiguracaoViewModel(
    application: Application
): AndroidViewModel(application) {

    private val context: Context = getApplication<Application>().applicationContext

    val configuracaoService = ApiInstance.createService(ConfiguracaoEndpoints::class.java)
    var information by mutableStateOf<ConfiguracaoInformation?>(null)
    var selectedImageUri by  mutableStateOf<Uri?>(null)

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

                try {
                    val response = configuracaoService.uploadProfileImage(
                        metadata = metadataJson,
                        file = imagePart
                    )
                    if(response.code() == 200){

                    }
                }catch (e: Exception){
                    Log.e("Configuração", "${e.message}")
                }
            }
        }
    }

}