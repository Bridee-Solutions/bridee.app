package com.example.bridee.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
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

@Composable
@Preview(showBackground = true)
fun NavController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
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