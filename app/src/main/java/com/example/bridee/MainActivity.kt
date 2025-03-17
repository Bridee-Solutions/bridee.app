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
import com.example.bridee.core.navigation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Bridee)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        enableEdgeToEdge()
        setContent {
            BrideeTheme {
                MainScreen()

            }
        }
    }
}