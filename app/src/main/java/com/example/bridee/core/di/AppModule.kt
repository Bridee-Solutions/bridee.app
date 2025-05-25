package com.example.bridee.core.di

import com.example.bridee.auth.domain.AuthenticationViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AuthenticationViewModel(androidApplication()) }
}