package com.example.bridee.core.nav

sealed class Screen (val route: String){
    object Login: Screen("login")
    object Fase1Registration: Screen("fase1_registration")
}