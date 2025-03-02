package com.example.bridee.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun NavController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Fase5Registration.route){
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
        composable(route = Screen.Fase4Registration.route) {
            Fase4RegistrationScreen(navController)
        }
        composable(route = Screen.Fase5Registration.route) {
            Fase5RegistrationScreen(navController)
        }
        composable(route = Screen.Fase6Registration.route) {
            Fase6RegistrationScreen(navController)
        }
        composable(route = Screen.Fase7Registration.route) {
            Fase7RegistrationScreen(navController)
        }
        composable(route = Screen.EmailRegistration.route){
            EmailRegistrationScreen()
        }
        composable(route = Screen.EmailFailRegistration.route){
            EmailFailRegistrationScreen()
        }
    }
}