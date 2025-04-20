package com.example.bridee.core.navigation

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Log.d("NAVIGATION", "Current backstack: ${navController.currentBackStackEntry?.destination?.route}")
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    fun shouldShowBottomBar(currentRoute: String?): Boolean {
        val routesWithoutBottomBar = listOf(
            Screen.Login.route,
            Screen.Cadastro.route,
            Screen.Fase1Registration.route,
            Screen.Fase2Registration.route,
            Screen.Fase3Registration.route,
            Screen.Fase4Registration.route,
            Screen.Fase5Registration.route,
            Screen.Fase6Registration.route,
            Screen.Fase7Registration.route,
            Screen.EmailRegistration.route,
            Screen.EmailFailRegistration.route,
            Screen.EsqueceuSenha.route
        )

        return currentRoute !in routesWithoutBottomBar
    }


    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar(currentRoute)) {
                BottomNavigationBar(navController)
            }
        }
    ) { paddingValues ->
        NavController(navController, paddingValues)
    }
}