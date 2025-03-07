package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R


enum class Tool {
    TAREFAS,
    CALCULADORA,
    CONVIDADOS
}

@Composable
fun CalculadoraScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        // Barra de navegação superior
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ferramentas",
            fontFamily = FontFamily(Font(R.font.playfair_display)),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))

        // Passar o estado de seleção para a TopBar
        TopBar()

        Spacer(modifier = Modifier.height(16.dp))

        ControleDeGastoCard()

        Spacer(modifier = Modifier.height(16.dp))

        CategoriaItem(nome = "Fornecedores", despesas = "10 despesas", valor = "R$2.900")
        CategoriaItem(nome = "Moda e Beleza", despesas = "10 despesas", valor = "R$1.900")
        CategoriaItem(nome = "Decoração", despesas = "5 despesas", valor = "R$5.600")
    }
}

@Composable
fun TopBar() {
    val selectedTool = remember { mutableStateOf(Tool.CALCULADORA) }

    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Tarefas
        MenuItem(
            iconRes = R.drawable.ic_tarefas,
            text = "Tarefas",
            isSelected = selectedTool.value == Tool.TAREFAS,
            onClick = { selectedTool.value = Tool.TAREFAS }
        )

        // Calculadora
        MenuItem(
            iconRes = R.drawable.ic_calculadora,
            text = "Calculadora",
            isSelected = selectedTool.value == Tool.CALCULADORA,
            onClick = { selectedTool.value = Tool.CALCULADORA }
        )

        // Convidados
        MenuItem(
            iconRes = R.drawable.ic_convidados,
            text = "Convidados",
            isSelected = selectedTool.value == Tool.CONVIDADOS,
            onClick = { selectedTool.value = Tool.CONVIDADOS }
        )
    }
}

@Composable
fun MenuItem(iconRes: Int, text: String, isSelected: Boolean, onClick: () -> Unit) {
    val rosaSelecionado = Color(0xFFDD7B78)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .background(
                if (isSelected) Color.White else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 8.dp, horizontal = 16.dp)

    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            modifier = Modifier.size(40.dp),
            tint = if (isSelected) rosaSelecionado  else Color.Black // Rosa se selecionado, preto caso contrário
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            fontSize = 13.sp,
            color = if (isSelected) rosaSelecionado  else Color.Black // Rosa se selecionado, preto caso contrário
        )
        if (isSelected) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(40.dp)
                    .background(rosaSelecionado)
            )
        }
    }
}



@Composable
fun ControleDeGastoCard() {
    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Controle de Gasto", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Total gasto: R$30.000")
            LinearProgressIndicator(progress = 0.33f, modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

            Text(text = "Resta: R$60.000")
            LinearProgressIndicator(progress = 0.66f, modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

            Text(text = "Orçamento total: R$90.000", fontSize = 16.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
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
