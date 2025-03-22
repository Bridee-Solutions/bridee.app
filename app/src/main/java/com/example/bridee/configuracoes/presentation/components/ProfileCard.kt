package com.example.bridee.home.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileCard(
    imageUrl: String,
    names: String,
    daysCount: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Foto de Perfil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = names, fontSize = 20.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "$daysCount dias", fontSize = 14.sp, color = Color.Gray)
    }
}

@Composable
fun AsyncImage(model: String, contentDescription: String, modifier: Modifier, contentScale: ContentScale) {

}
