package com.example.bridee.core.api

import android.content.Context
import com.example.bridee.core.store.TokenStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
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

        val requestUrl = chain.request().url
        if(isNotAllowedUrl(requestUrl)){
            val newRequest = createAuthorizationRequest(chain, accessToken)
            return chain.proceed(newRequest)
        }
        return chain.proceed(chain.request())
    }

    private fun createAuthorizationRequest(chain: Interceptor.Chain, accessToken: String?): Request{
        return chain.request()
            .newBuilder()
            .addHeader("Bridee-Token", "Bearer $accessToken")
            .build()
    }

    private fun isNotAllowedUrl(requestUrl: HttpUrl): Boolean {
        val path = requestUrl.toUri().path
        return !allowedUris.contains(path)
    }

}