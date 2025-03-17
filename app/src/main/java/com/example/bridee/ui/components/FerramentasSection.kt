package com.example.bridee.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.calculadora.presentation.screens.CategoriaScreen
import com.example.bridee.calculadora.presentation.screens.ControleDeGastoCard
import com.example.bridee.core.navigation.Screen
import com.example.bridee.ui.theme.cinza


enum class Tool {
    TAREFAS,
    CALCULADORA,
    CONVIDADOS
}


data class CategoriaItem(val nome: String, val despesas: String, val valor: String, val icon: Int)

@Composable
fun FerramentasSection(navController: NavController) {
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
                onClick = {
                    selectedTool.value = Tool.TAREFAS;
                    navController.navigate(Screen.ListaTarefas.route) {
                        launchSingleTop = true
                        restoreState = true
                    };
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            FerramentaItem(
                nome = "Calculadora",
                iconeRes = R.drawable.ic_calculadora,
                ativo = selectedTool.value == Tool.CALCULADORA,
                onClick = {
                    selectedTool.value = Tool.CALCULADORA
                }
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
            .background(if (ativo) Color.White else cinza.copy(alpha = 0.5f))
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
