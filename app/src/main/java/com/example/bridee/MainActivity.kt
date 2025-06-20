package com.example.bridee

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bridee.core.api.ApiInstance
import com.example.bridee.core.navigation.MainScreen
import com.example.bridee.ui.theme.BrideeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Bridee)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        ApiInstance.init(applicationContext)
        enableEdgeToEdge()
        setContent {
            BrideeTheme {
                MainScreen(applicationContext);
            }
        }
    }
}