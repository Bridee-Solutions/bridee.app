package com.example.bridee.core.navigation

import java.net.URLEncoder

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
    object Home : Screen("home")
    object Ferramentas : Screen("calculadora")
    object Servicos : Screen("servicos")
    object ServicosSubcategoriaScreen : Screen("servicos_subcategoria/{subcategoriaNome}") {
        fun createRoute(subcategoriaNome: String) = "servicos_subcategoria/${URLEncoder.encode(subcategoriaNome, "UTF-8")}"
    }
    object ServicosDetalhesScreen  : Screen("servicos_detalhes")
    object Inspiracao : Screen("inspiracao")
    object ListaTarefas : Screen("lista_tarefas")
    object Configuracoes : Screen("configuracoes")
    object GaleriaImagens : Screen("galeria_imagens")


}