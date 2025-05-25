package com.example.bridee.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.core.navigation.Screen
import com.example.bridee.home.domain.HomeResponseDto
import com.example.bridee.ui.theme.rosa

@Composable
fun WeddingHeader(
    homeResponse: HomeResponseDto?,
    navController: NavController
) {
    val casal = homeResponse?.casamentoInfo?.casal
    val nomeCasal =  "${casal?.nome ?: ""} & ${casal?.nomeParceiro ?: ""}"


    Box(modifier = Modifier.height(250.dp)) {
        Image(
            painter = painterResource(id = R.drawable.image_home),
            contentDescription = "Fundo do casamento",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.5f), Color.Transparent),
                        startY = 0f
                    )
                )
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Configurações",
                modifier = Modifier
                    .size(26.dp)
                    .align(Alignment.TopEnd)
                    .clickable { navController.navigate(Screen.Configuracoes.route) },
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text =  nomeCasal,
                    style = MaterialTheme.typography.titleLarge.copy(Color.White, fontSize = 35.sp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.calendario),
                        contentDescription = "Ícone de data",
                        modifier = Modifier.size(17.dp),
                        tint = rosa
                    )
                    Text(
                        text = weddingDate(homeResponse) ?: "",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.place),
                        contentDescription = "Ícone de local",
                        modifier = Modifier.size(17.dp),
                        tint = rosa
                    )
                    Text(
                        text = homeResponse?.casamentoInfo?.local ?: "",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

fun weddingDate(homeResponse: HomeResponseDto?): String?{
    val date = homeResponse?.casamentoInfo?.dataCasamento
    return date?.split("-")
        ?.reversed()?.joinToString("/")
}
