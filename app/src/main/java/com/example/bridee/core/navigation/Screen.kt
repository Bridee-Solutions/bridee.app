package com.example.bridee.core.navigation

import com.example.bridee.calculadora.domain.CalculadoraViewModel

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
    object CalculadoraRoutes: Screen("calculadora-graph")
    object Calculadora : Screen("calculadora")
    object CategoriaDetalhes : Screen("categoria_detalhes/{item}") {
        fun createRoute(
            item: String
        ) = "categoria_detalhes/$item"
    }
    object Home : Screen("home")
    object Servicos : Screen("servicos")
    object Inspiracao : Screen("inspiracao")
    object ListaTarefas : Screen("lista_tarefas")
    object Configuracoes : Screen("configuracoes")
}