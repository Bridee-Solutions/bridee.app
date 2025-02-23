package com.example.bridee.auth.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Header(navController: NavController, fillPercentage: Dp){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp

    ArrowBack(navController)
    Title()
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.width(windowWidthDp - 100.dp)
            .clip(
                shape = RoundedCornerShape(50)
            )
            .background(Color(0xFFE3E3E3))
    ) {
        LoadBar(fillPercentage)
    }
}