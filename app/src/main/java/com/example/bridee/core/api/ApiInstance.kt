package com.example.bridee.core.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiInstance {

    companion object{
        private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl("http://localhost:8080/api")
            .addConverterFactory(GsonConverterFactory.create())
    }

    private val retrofit: Retrofit = retrofitBuilder.build()
    private val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

    fun <T> createService(serviceClass: Class<T>): T{
        return retrofit.create(serviceClass)
    }
}