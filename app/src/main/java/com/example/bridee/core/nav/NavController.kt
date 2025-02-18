package com.example.bridee.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bridee.auth.presentation.login.LoginScreen
import com.example.bridee.auth.presentation.registration.fases.fase1.Fase1RegistrationScreen

@Composable
fun NavController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Fase1Registration.route) {
            Fase1RegistrationScreen(navController)
        }
    }
}