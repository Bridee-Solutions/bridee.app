package com.example.bridee

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bridee.core.navigation.NavController
import com.example.bridee.ui.theme.BrideeTheme
import com.example.bridee.calculadora.presentation.screens.CalculadoraScreen
import com.example.bridee.calculadora.presentation.screens.CategoriaDetalhesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Bridee)


        enableEdgeToEdge()
        setContent {
            BrideeTheme {
                NavController()

            }
        }
    }
}