package com.example.bridee.servicos.presentation.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.bridee.R

@Composable
fun ServicosDetalhesScreen(
    navController: NavController,
    paddingValues: PaddingValues
){
    Box(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(paddingValues)

    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.image_home),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text("Veiga Estúdios", style = MaterialTheme.typography.headlineSmall)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Place, contentDescription = "Localização", tint = Color.Gray)
                Spacer(modifier = Modifier.width(4.dp))
                Text("São Bernardo do Campo, São Paulo", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_whatsapp), // ícone do WhatsApp
                    contentDescription = "WhatsApp",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF25D366)
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
        ) {
            Text("Website", modifier = Modifier.padding(end = 16.dp), fontWeight = FontWeight.Bold)
            Text("Imagens", fontWeight = FontWeight.Normal)
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Informações gerais", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Seu casamento será um dia cheio de momentos que irá querer guardar e relembrar...",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Perguntas frequentes", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(12.dp))

            Text("Quais são os serviços que realiza?", fontWeight = FontWeight.Bold)
            Text("Mínimo 1 semana e máximo 2 anos antes")

            Spacer(modifier = Modifier.height(12.dp))
            Text("Com que antecedência devo entrar em contato?", fontWeight = FontWeight.Bold)

            val servicos = listOf(
                "Fotografias em alta resolução",
                "Pós-wedding",
                "Álbum digital",
                "Blu-ray ou DVD com todas as fotografias",
                "Entrega digital do material",
                "Usb/pen drive com o material",
                "Outros (Serviços de fotografia e videografia no exterior)",
                "Pré-wedding",
                "Drones",
                "Vídeo",
                "Mini álbuns",
                "Fotografia",
                "Mini álbuns"
            )

            servicos.forEach { servico ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = null,
                        tint = Color(0xFF28a745),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(servico, style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text("O que inclui o pack de casamento?", fontWeight = FontWeight.Bold)
            Text("Tem diversos pacotes, entre em contato para receber mais detalhes")

            Spacer(modifier = Modifier.height(12.dp))
            Text("Cobre mais de um casamento por dia?", fontWeight = FontWeight.Bold)
            Text("Sim")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Localização", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Rua Hall, 101 - Jardim América, São José dos Campos - SP, 12345-070")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
        Button(
            onClick = { /* Ação ao clicar no botão */ },
            modifier = Modifier
                .fillMaxWidth() // O botão ocupa toda a largura da tela
                .align(Alignment.BottomStart) // Alinha o botão na parte inferior
                .padding(16.dp) // Adiciona o padding para o botão não colidir com a borda
        ) {
            Text("Solicitar orçamento")
        }
    }
}