package com.example.bridee.auth.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController

@Composable
fun Header(
    navController: NavController,
    fillPercentage: Dp,
    previousFase: String
){
    ArrowBack(navController, previousFase)
    Title(fillPercentage)
}