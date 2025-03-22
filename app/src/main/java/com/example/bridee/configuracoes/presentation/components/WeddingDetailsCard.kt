package com.example.bridee.configuracoes.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.ui.theme.rosa

@Composable
fun WeddingDetailsCard() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text("Detalhes do casamento",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.calendario),
                "Data",
                tint = rosa,
                modifier = Modifier.padding(start = 20.dp) )
            Spacer(modifier = Modifier.width(6.dp))
            Text("11 de Fevereiro, 2026",
                style = MaterialTheme.typography.bodyLarge
                )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.place),
                "Local",
                tint = rosa,
                modifier = Modifier.padding(start = 20.dp).size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("São Paulo - SP" )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.people),
                "Convidados", tint = rosa,
                modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("100 Convidados" )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.money),
                "Orçamento", tint = rosa,
                modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("R$100.000 Orçamento", )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

    }
}
