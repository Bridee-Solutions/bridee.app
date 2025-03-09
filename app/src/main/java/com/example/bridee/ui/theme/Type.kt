package com.example.bridee.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bridee.R


val playfairDisplay = FontFamily(Font(R.font.playfair_display))
val productSans = FontFamily(Font(R.font.product_sans))
val qlassy = FontFamily(Font(R.font.qlassy))

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge  = TextStyle(
        fontFamily = playfairDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    titleMedium  = TextStyle(
        fontFamily = playfairDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    titleSmall  = TextStyle(
        fontFamily = playfairDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = productSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = productSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall  = TextStyle(
        fontFamily = qlassy,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelLarge  = TextStyle(
        fontFamily = qlassy,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

)