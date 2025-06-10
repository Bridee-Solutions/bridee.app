package com.example.bridee.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CountdownItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)
        Text(text = label,
            fontSize = 14.sp,
            color = Color.White)
    }
}
