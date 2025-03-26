package com.example.bridee.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bridee.R


val playfairDisplay = FontFamily(Font(R.font.playfair_display))
val productSans = FontFamily(Font(R.font.product_sans))

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge  = TextStyle(
        fontFamily = playfairDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        color = Color.Black
    ),
    titleMedium  = TextStyle(
        fontFamily = playfairDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 23.sp,
        color = Color.Black
    ),
    titleSmall  = TextStyle(
        fontFamily = playfairDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color.Black
    ),
    bodyLarge = TextStyle(
        fontFamily = productSans,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = Color.Black
    ),
    bodyMedium = TextStyle(
        fontFamily = productSans,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.Black
    ),
    bodySmall= TextStyle(
        fontFamily = productSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black
    )



)