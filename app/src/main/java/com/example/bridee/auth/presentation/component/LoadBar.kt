package com.example.bridee.auth.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadBar(fillPercentage: Dp){

    Row (
        modifier = Modifier.height(10.dp)
            .width(fillPercentage)
            .clip(
                shape = RoundedCornerShape(30)
            )
            .background(Color(0xFFD86B67))
    ) {

    }
}