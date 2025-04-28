package com.example.bridee.core.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.tokenStore by preferencesDataStore(name = "tokenStore")

object TokenStore {

    private val ACCESS_TOKEN = stringPreferencesKey(
        name = "ACCESS_TOKEN"
    )

    suspend fun saveAccessToken(context: Context, token: String){
        context.tokenStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = token
        }
    }

    fun getAccessToken(context: Context): Flow<String?> {
        return context.tokenStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }
    }
}