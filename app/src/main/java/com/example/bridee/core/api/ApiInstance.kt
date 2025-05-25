package com.example.bridee.core.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiInstance {

    private const val BASE_URL = "http://172.18.32.1:8080/api/"
    private lateinit var retrofit: Retrofit

    fun init(context: Context){
        if(!::retrofit.isInitialized){
            val httpClient: OkHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(RequestInterceptor(context))
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
        }
    }

    fun <T> createService(serviceClass: Class<T>): T{
        check(::retrofit.isInitialized){"ApiInstance não foi inicializado"}
        return retrofit.create(serviceClass)
    }
}