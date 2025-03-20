package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
@Composable
fun CountdownSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFED9C9B))
            .padding(vertical = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            CountdownItem("519", "DIAS")
            CountdownItem("6", "HORAS")
            CountdownItem("10", "MINUTOS")
        }
    }
}