package com.example.bridee.configuracoes.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import com.example.bridee.home.presentation.components.ProfileCard
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfiguracoesScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ProfileCard(
            imageUrl = "https://avatars.githubusercontent.com/u/142369084?v=4",
            names = "Amanda & Enzo",
            daysCount = 350
        )
    }
}
