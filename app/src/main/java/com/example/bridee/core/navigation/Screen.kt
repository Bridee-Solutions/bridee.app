package com.example.bridee.core.navigation

import java.net.URLEncoder

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
    object ServicosSubcategoriaScreen : Screen("servicos_subcategoria/{subcategoriaNome}/{subcategoriaId}") {
        fun createRoute(
            subcategoriaNome: String,
            subcategoriaId: Int
        ) = "servicos_subcategoria/${URLEncoder.encode(subcategoriaNome, "UTF-8")}/$subcategoriaId"
    }
    object ServicosDetalhesScreen  : Screen("servicos_detalhes/{associadoId}"){
        fun createRoute(
            associadoId: Int
        ) = "servicos_detalhes/${associadoId}"
    }
    object Inspiracao : Screen("inspiracao")
    object ListaTarefas : Screen("lista_tarefas")
    object Configuracoes : Screen("configuracoes")
    object EsqueceuSenha : Screen("esqueceu_senha")
    object GaleriaImagens : Screen("galeria_imagens")


}