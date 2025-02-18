package com.example.bridee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bridee.auth.presentation.login.LoginScreen
import com.example.bridee.core.nav.NavController
import com.example.bridee.core.topbar.presentation.NavigationDrawer
import com.example.bridee.ui.theme.BrideeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrideeTheme {
                NavController()
            }
        }
    }
}