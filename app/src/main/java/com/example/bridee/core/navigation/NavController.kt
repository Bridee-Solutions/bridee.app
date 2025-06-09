package com.example.bridee.core.navigation

import android.content.Context
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
import com.example.bridee.calculadora.domain.CalculadoraViewModel
import com.example.bridee.calculadora.domain.ItemOrcamentoResponse
import com.example.bridee.calculadora.presentation.screens.CalculadoraScreen
import com.example.bridee.calculadora.presentation.screens.CategoriaDetalhesScreen
import com.example.bridee.configuracoes.presentation.screen.ConfiguracoesScreen
import com.example.bridee.home.presentation.viewmodel.HomeViewModel
import com.example.bridee.inspiracao.domain.TelaInpiracaoViewModel
import com.example.bridee.lista_tarefas.presentation.viewmodel.TarefasViewModel
import com.example.bridee.lista_tarefas.presentation.screens.ListaTarefasScreen
import com.example.bridee.servicos.presentation.screens.GaleriaImagensScreen
import com.example.bridee.servicos.presentation.screens.HomeScreen
import com.example.bridee.servicos.presentation.screens.InspiracaoScreen
import com.example.bridee.servicos.presentation.screens.ServicosDetalhesScreen
import com.example.bridee.servicos.presentation.screens.ServicosScreen
import com.example.bridee.servicos.presentation.screens.ServicosSubcategoriaScreen
import com.example.bridee.servicos.presentation.viewModel.CategoriasViewModel
import com.example.bridee.servicos.presentation.viewModel.ServicosDetalhesViewModel
import com.google.gson.Gson
import java.net.URLDecoder

@Composable
fun NavController(
    navController: NavHostController,
    context: Context,
    paddingValues: PaddingValues){
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route) {
            val authenticationViewModel: AuthenticationViewModel = viewModel()

            LoginScreen(authenticationViewModel, navController)
        }
        navigation(
            route = Screen.Cadastro.route,
            startDestination = Screen.Fase1Registration.route
        ) {
            composable(route = Screen.Fase1Registration.route) {
                val viewModel = it.sharedViewModel<RegistrationSharedViewModel>(navController)
                Fase1RegistrationScreen(viewModel, navController)
            }
            composable(route = Screen.Fase2Registration.route) {
                Fase2RegistrationScreen(navController)
            }
            composable(route = Screen.Fase3Registration.route) {
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
        composable(route = Screen.EmailRegistration.route) {
            EmailRegistrationScreen()
        }
        composable(route = Screen.EmailFailRegistration.route) {
            EmailFailRegistrationScreen()
        }
        composable(Screen.Configuracoes.route) {
            ConfiguracoesScreen(navController)
        }
        navigation(
            startDestination = Screen.Calculadora.route,
            route = Screen.CalculadoraRoutes.route
        ) {
            composable(route=Screen.Calculadora.route) {
                val viewModel = it.sharedViewModel<CalculadoraViewModel>(navController)
                CalculadoraScreen(viewModel, navController, paddingValues)
            }
            composable(
                route = Screen.CategoriaDetalhes.route
            ) { backStackEntry ->
                val viewModel = backStackEntry.sharedViewModel<CalculadoraViewModel>(navController)
                val itemJson = backStackEntry.arguments?.getString("item")
                val item = Gson().fromJson(URLDecoder.decode(itemJson, "UTF-8"), ItemOrcamentoResponse::class.java)
                CategoriaDetalhesScreen(
                    viewModel = viewModel,
                    item = item,
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
        }
        composable(route = Screen.Home.route) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(viewModel, navController, paddingValues)
        }
        composable(route = Screen.Servicos.route) {
            val viewModel: CategoriasViewModel = viewModel()
            ServicosScreen(viewModel, navController)
        }

        composable(
            route = Screen.ServicosSubcategoriaScreen.route,
            arguments = listOf(
                navArgument("subcategoriaNome") { type = NavType.StringType },
                navArgument("subcategoriaId") {type = NavType.IntType}
            )
        ) { backStackEntry ->
            val viewModel: ServicosDetalhesViewModel = viewModel()
            val subcategoriaNome = backStackEntry.arguments?.getString("subcategoriaNome")?.let {
                URLDecoder.decode(it, "UTF-8") } ?: ""
            val subcategoriaId = backStackEntry.arguments?.getInt("subcategoriaId")
            viewModel.subcategoriaId = subcategoriaId!!
            viewModel.subcategoriaNome = subcategoriaNome
            ServicosSubcategoriaScreen(
                navController = navController,
                viewModel = viewModel,
                paddingValues = paddingValues
            )
        }

        composable(route = Screen.ServicosDetalhesScreen.route) {
            ServicosDetalhesScreen(navController,  paddingValues)
        }
        composable(route = Screen.GaleriaImagens.route) {
            GaleriaImagensScreen(navController, paddingValues)
        }

        composable(route = Screen.Inspiracao.route) {
            val viewModel: TelaInpiracaoViewModel = viewModel()
            InspiracaoScreen(viewModel, navController, paddingValues)
        }
        composable(route = Screen.ListaTarefas.route) {
            val viewModel = TarefasViewModel()
            ListaTarefasScreen(navController,paddingValues,viewModel)
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}
