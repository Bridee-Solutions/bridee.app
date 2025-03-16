package com.example.bridee.servicos.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.ui.theme.rosa

@Composable
fun HomeScreen(navController: NavController) {
    WeddingCountdownScreen()
}

@Composable
fun WeddingCountdownScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.height(250.dp)
        ) {

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
                        .clickable {

                        },
                    tint = Color.White
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Amanda & Enzo",
                    style = MaterialTheme.typography.titleLarge.copy(Color.White, fontSize = 35.sp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.calendario),
                        contentDescription = "Ícone de data",
                        modifier = Modifier.size(20.dp),
                        tint = rosa
                    )
                    Text(
                        text = "11 de Fevereiro, 2026",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))


                    Icon(
                        painter = painterResource(id = R.drawable.localizacao),
                        contentDescription = "Ícone de local",
                        modifier = Modifier.size(20.dp),
                        tint = rosa
                    )
                    Text(
                        text = "São Paulo",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }



        }

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

        // Lista de fornecedores
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF8F4))
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Complete a sua equipe de fornecedores",
                    style = MaterialTheme.typography.titleSmall.copy(fontSize = 18.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                                )
            }

            // Lista de fornecedores
            val fornecedores = listOf(
                Fornecedor("Assessor", "Buscar fornecedores", true, R.drawable.assessor),
                Fornecedor("Local", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Florista", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Buffet e Gastronomia", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Vestido", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Fotógrafo", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Decoração", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Hospedagem", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Confeitaria", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Moda e Beleza", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Videógrafos", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Papelaria", "Buscar fornecedores", false, R.drawable.assessor),
                Fornecedor("Entretenimento", "Buscar fornecedores", false, R.drawable.assessor)
            )


            items(fornecedores) { fornecedor ->
                FornecedorItem(fornecedor = fornecedor)
            }
        }
    }
}



data class Fornecedor(
    val nome: String,
    val descricao: String,
    val selecionado: Boolean,
    val drawableResId: Int )

@Composable
fun FornecedorItem(fornecedor: Fornecedor) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = fornecedor.drawableResId),
            contentDescription = "Ícone do fornecedor",
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))


        Column(modifier = Modifier.weight(1f)) {
            Text(text = fornecedor.nome, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = fornecedor.descricao, fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.width(12.dp))


        if (fornecedor.selecionado) {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Selecionado",
                tint = Color.Green,
                modifier = Modifier.size(37.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Selecionar fornecedor",
                tint = Color.Gray,
                modifier = Modifier.size(37.dp)
            )
        }
    }
}


// Componente do contador
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

@Preview(showBackground = true)
@Composable
fun PreviewWeddingCountdownScreen() {
    WeddingCountdownScreen()
}
