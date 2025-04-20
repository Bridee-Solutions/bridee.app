package com.example.bridee.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.bridee.auth.domain.AuthenticationViewModel
import com.example.bridee.auth.domain.RegistrationSharedViewModel
import com.example.bridee.auth.presentation.login.LoginScreen
import com.example.bridee.auth.presentation.registration.email.EmailFailRegistrationScreen
import com.example.bridee.auth.presentation.registration.email.EmailRegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase1.Fase1RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase2.Fase2RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase3.Fase3RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase4.Fase4RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase5.Fase5RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase6.Fase6RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase7.Fase7RegistrationScreen
import com.example.bridee.calculadora.presentation.screens.CalculadoraScreen
import com.example.bridee.calculadora.presentation.screens.CategoriaDetalhesScreen
import com.example.bridee.configuracoes.presentation.screen.ConfiguracoesScreen
import com.example.bridee.esqueceusenha.presentation.screens.EsqueceuSenhaScreen
import com.example.bridee.lista_tarefas.presentation.screens.ListaTarefasScreen
import com.example.bridee.servicos.presentation.screens.HomeScreen
import com.example.bridee.servicos.presentation.screens.InspiracaoScreen
import com.example.bridee.servicos.presentation.screens.ServicosScreen

@Composable
fun NavController(navController: NavHostController, paddingValues: PaddingValues){
//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route) {
            val authenticationViewModel: AuthenticationViewModel = AuthenticationViewModel()
            LoginScreen(authenticationViewModel, navController)
        }
        navigation(
            route = Screen.Cadastro.route,
            startDestination = Screen.Fase1Registration.route
        ){
            composable(route = Screen.Fase1Registration.route) {
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase1RegistrationScreen(viewModel, navController)
            }
            composable(route = Screen.Fase2Registration.route) {
                Fase2RegistrationScreen(navController)
            }
            composable(route = Screen.Fase3Registration.route){
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase3RegistrationScreen(viewModel, navController)
            }
            composable(route = Screen.Fase4Registration.route) {
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase4RegistrationScreen(viewModel, navController)
            }
            composable(route = Screen.Fase5Registration.route) {
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase5RegistrationScreen(viewModel, navController)
            }
            composable(route = Screen.Fase6Registration.route) {
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase6RegistrationScreen(viewModel, navController)
            }
            composable(route = Screen.Fase7Registration.route) {
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase7RegistrationScreen(viewModel, navController)
            }
        }
        composable(route = Screen.EmailRegistration.route){
            EmailRegistrationScreen()
        }
        composable(route = Screen.EmailFailRegistration.route){
            EmailFailRegistrationScreen()
        }

        composable(Screen.Configuracoes.route) {
            ConfiguracoesScreen(navController)
        }
        composable(Screen.EsqueceuSenha.route) {
            EsqueceuSenhaScreen()
        }

        composable(route = Screen.Calculadora.route) {
            CalculadoraScreen(navController)
        }
        composable(
            route = Screen.CategoriaDetalhes.route,
            arguments = listOf(
                navArgument("nome") { type = NavType.StringType },
                navArgument("icon") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nome") ?: ""
            val icon = backStackEntry.arguments?.getInt("icon") ?: 0
            CategoriaDetalhesScreen(nome, icon, navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.Ferramentas.route) {
            CalculadoraScreen(navController)
        }
        composable(route = Screen.Servicos.route) {
            ServicosScreen(navController)
        }
        composable(route = Screen.Inspiracao.route) {
            InspiracaoScreen(navController)
        }

        composable(route = Screen.ListaTarefas.route) {
            ListaTarefasScreen(navController);
        }
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController
): T{
    val navGraphRoute = destination.parent?.route ?: viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}