package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.ui.theme.BrideeTheme

enum class Tool {
    TAREFAS,
    CALCULADORA,
    CONVIDADOS
}

@Composable
fun CalculadoraScreen() {
    Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {


        FerramentasSection()
        Spacer(modifier = Modifier.height(16.dp))
        ControleDeGastoCard()
    }


}

@Composable
fun FerramentasSection() {
    val selectedTool = remember { mutableStateOf(Tool.CALCULADORA) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF9F9F9))            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Ferramentas",
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FerramentaItem(
                nome = "Tarefas",
                iconeRes = R.drawable.ic_tarefas,
                ativo = selectedTool.value == Tool.TAREFAS,
                onClick = { selectedTool.value = Tool.TAREFAS }
            )

            Spacer(modifier = Modifier.width(16.dp))

            FerramentaItem(
                nome = "Calculadora",
                iconeRes = R.drawable.ic_calculadora,
                ativo = selectedTool.value == Tool.CALCULADORA,
                onClick = { selectedTool.value = Tool.CALCULADORA }
            )

            Spacer(modifier = Modifier.width(16.dp))

            FerramentaItem(
                nome = "Convidados",
                iconeRes = R.drawable.ic_convidados,
                ativo = selectedTool.value == Tool.CONVIDADOS,
                onClick = { selectedTool.value = Tool.CONVIDADOS }
            )



        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun FerramentaItem(nome: String, iconeRes: Int, ativo: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(70.dp)
            .clickable { onClick() }
            .background(if (ativo) Color.White else Color.LightGray.copy(alpha = 0.5f))
    ) {
        
        if (ativo) {
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color(0xFFE57373))

            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = iconeRes),
                contentDescription = nome,
                tint = if (ativo) Color(0xFFE57373) else Color.Gray,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = nome,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = if (ativo) Color.Black else Color.Gray
            )
        }
    }
}




@Composable
fun ControleDeGastoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFD9D9D9)) // Borda cinza claro
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Controle de Gasto",
                style = MaterialTheme.typography.titleMedium // Usando o estilo titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Total gasto: R$30.000")
            LinearProgressIndicator(progress = 0.33f, modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

            Text(text = "Resta: R$60.000")
            LinearProgressIndicator(progress = 0.66f, modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

            Text(
                text = "Orçamento total: R$90.000",
                fontSize = 16.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
    }
}




@Composable
fun CategoriaItem(nome: String, despesas: String, valor: String) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = nome, fontSize = 16.sp)
                Text(text = despesas, fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
            }
            Text(text = valor, fontSize = 14.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCalculadoraScreen() {
    BrideeTheme {
        CalculadoraScreen()
    }
}