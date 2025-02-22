package com.example.bridee.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bridee.auth.presentation.login.LoginScreen
import com.example.bridee.auth.presentation.registration.fases.fase1.Fase1RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase2.Fase2RegistrationScreen
import com.example.bridee.auth.presentation.registration.fases.fase3.Fase3RegistrationScreen

@Composable
fun NavController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Fase3Registration.route){
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Fase1Registration.route) {
            Fase1RegistrationScreen(navController)
        }
        composable(route = Screen.Fase2Registration.route) {
            Fase2RegistrationScreen(navController)
        }
        composable(route = Screen.Fase3Registration.route){
            Fase3RegistrationScreen(navController)
        }
    }
}