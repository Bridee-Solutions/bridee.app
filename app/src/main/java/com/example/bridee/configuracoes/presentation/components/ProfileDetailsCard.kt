package com.example.bridee.configuracoes.presentation.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProfileDetailsCard() {
    Column(modifier = Modifier.fillMaxWidth().background(Color(0xFFFCFAF2))) {


        Text("Detalhes do perfil", style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text("Seu nome", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(start = 20.dp))
        Text("Amanda Sousa", modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text("Nome do seu amor", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(start = 20.dp))
        Text("Enzo Martins", modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text("Telefone", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(start = 20.dp))
        Text("11981819900", modifier = Modifier.padding(start = 20.dp, bottom = 12.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

    }
}
