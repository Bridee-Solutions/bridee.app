package com.example.bridee.core.nav

sealed class Screen (val route: String){
    object Login: Screen("login")
    object Fase1Registration: Screen("fase1_registration")
    object Fase2Registration: Screen("fase2_registration")
    object Fase3Registration: Screen("fase3_registration")
    object Fase4Registration: Screen("fase4_registration")
    object Fase5Registration: Screen("fase5_registration")
    object Fase6Registration: Screen("fase6_registration")
    object Fase7Registration: Screen("fase7_registration")
}