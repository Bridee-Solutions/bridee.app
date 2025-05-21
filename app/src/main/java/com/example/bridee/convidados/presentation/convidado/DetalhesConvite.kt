@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bridee.convidados.presentation.convidado

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TopAppBarDefaults


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesConviteScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Convite de Família Forbes") },
                navigationIcon = {
                    IconButton(onClick = { /* voltar */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { /* adicionar convidado */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFA4A0C))
                ) {
                    Text("+ Adicionar convidado")
                }
                Button(
                    onClick = { /* chamar no WhatsApp */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(Color(0xFF25D366))
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "WhatsApp",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Chamar no WhatsApp")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDFDFD))
        ) {
            item {
                DadosConviteSection()
            }
            item {
                ConvidadosSection()
            }
        }
    }
}

@Composable
fun DadosConviteSection() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            "Dados do convite",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text("Nome do convite *", fontSize = 14.sp, color = Color.Gray)
                        Text("Família Rosa", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    IconButton(onClick = { /* editar nome */ }) {
                        Icon(Icons.Default.Edit, contentDescription = "Editar")
                    }
                }

                Spacer(Modifier.height(16.dp))

                Text("Telefone do titular do convite *", fontSize = 14.sp, color = Color.Gray)
                Text("(11) 98181-9900", fontWeight = FontWeight.Bold, fontSize = 16.sp)

                Spacer(Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text("PIN do convite", fontSize = 14.sp, color = Color.Gray)
                        Text("1920", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Button(
                        onClick = { /* copiar PIN */ },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Copiar")
                    }
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFF9F9F9))
                    .fillMaxWidth()
            ) {
                Text(
                    text = "O PIN pode ser usado para responder a confirmação de presença.",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun ConvidadosSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            "Convidados neste convite (n)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        ConvidadoItem(
            nome = "Caroline Forbes",
            tags = listOf("Família Amanda", "Adulto"),
            status = "Confirmado",
            statusColor = Color(0xFF4CAF50)
        )

        Spacer(Modifier.height(12.dp))

        ConvidadoItem(
            nome = "Stefan Forbes",
            tags = listOf("Família Amanda", "Adulto"),
            status = "Sem resposta",
            statusColor = Color(0xFFFFC107)
        )
    }
}

@Composable
fun ConvidadoItem(
    nome: String,
    tags: List<String>,
    status: String,
    statusColor: Color
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(nome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Row {
                    IconButton(onClick = { /* excluir convidado */ }) {
                        Icon(Icons.Default.Close, contentDescription = "Excluir")
                    }
                    IconButton(onClick = { /* editar convidado */ }) {
                        Icon(Icons.Default.Edit, contentDescription = "Editar")
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                tags.forEach { tag ->
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(tag, fontSize = 12.sp)
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(statusColor, CircleShape)
                )
                Spacer(Modifier.width(8.dp))
                Text(status, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetalhesConviteScreenPreview() {
    DetalhesConviteScreen()
}