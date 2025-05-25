package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bridee.home.presentation.viewmodel.HomeViewModel

@Composable
fun CountdownSection(
    viewModel: HomeViewModel
) {
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
            CountdownItem("${viewModel.daysToWedding()}", "DIAS")
            CountdownItem("${viewModel.hoursToWedding()}", "HORAS")
            CountdownItem("${viewModel.minutesToWedding()}", "MINUTOS")
        }
    }
}