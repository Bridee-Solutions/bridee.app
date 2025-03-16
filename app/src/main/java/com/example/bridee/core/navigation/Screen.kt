package com.example.bridee.core.navigation

sealed class Screen (val route: String){
    object Login: Screen("login")
    object Cadastro: Screen("cadastro")
    object Fase1Registration: Screen("fase1_registration")
    object Fase2Registration: Screen("fase2_registration")
    object Fase3Registration: Screen("fase3_registration")
    object Fase4Registration: Screen("fase4_registration")
    object Fase5Registration: Screen("fase5_registration")
    object Fase6Registration: Screen("fase6_registration")
    object Fase7Registration: Screen("fase7_registration")
    object EmailRegistration: Screen("email_confirmation")
    object EmailFailRegistration: Screen("email_fail_confirmation")
    object Calculadora : Screen("calculadora")
    object CategoriaDetalhes : Screen("categoria_detalhes/{nome}/{icon}") {
        fun createRoute(nome: String, icon: Int) = "categoria_detalhes/$nome/$icon"
    }
    object ListaTarefas : Screen("lista_tarefas")
}