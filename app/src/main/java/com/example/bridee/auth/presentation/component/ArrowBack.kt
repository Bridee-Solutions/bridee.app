package com.example.bridee.auth.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bridee.core.navigation.Screen

@Composable
fun ArrowBack(navController: NavController){

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            navController.navigate(route = Screen.Fase2Registration.route)
        }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Arrow Back",
            tint = Color(0xFFAE6261)
        )
        Text("VOLTAR")
    }

}