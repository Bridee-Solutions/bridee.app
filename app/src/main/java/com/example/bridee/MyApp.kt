package com.example.bridee

import android.app.Application
import com.example.bridee.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin() {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}