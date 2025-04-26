package com.example.bridee.core.api

import android.content.Context
import com.example.bridee.core.store.TokenStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor(private val context: Context): Interceptor {

    private val allowedUris = mutableListOf(
        "/api/authentication",
        "/api/casais"
    )

    override fun intercept(chain: Interceptor.Chain): Response {

        val accessToken = runBlocking {
            TokenStore.getAccessToken(context).first()
        }
        val requestUrl = chain.request().url()
        if(!accessToken.isNullOrBlank() && isNotAllowedUrl(requestUrl)){
            val newRequest = chain.request()
                .newBuilder()
                .addHeader("Bridee-Token", "Bearer $accessToken")
                .build()
            return chain.proceed(newRequest)
        }
        return chain.proceed(chain.request())
    }

    private fun isNotAllowedUrl(requestUrl: HttpUrl): Boolean {
        val path = requestUrl.uri().path
        return !allowedUris.contains(path)
    }

}