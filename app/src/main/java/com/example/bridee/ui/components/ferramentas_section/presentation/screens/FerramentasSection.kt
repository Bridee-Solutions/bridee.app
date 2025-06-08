package com.example.bridee.ui.components.ferramentas_section.presentation.screens

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
import com.example.bridee.core.navigation.Screen
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.components.FerramentaItem
import com.example.bridee.ui.theme.cinza

@Composable
fun FerramentasSection(navController: NavController, selectedTool: Tool) {

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
            style = MaterialTheme.typography.titleLarge.copy(color = Color.Black),
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
                ativo = selectedTool == Tool.TAREFAS,
                onClick = {
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
                ativo = selectedTool == Tool.CALCULADORA,
                onClick = {
                    navController.navigate(Screen.Calculadora.route) {
                        launchSingleTop = true
                        restoreState = true
                    };
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            FerramentaItem(
                nome = "Convidados",
                iconeRes = R.drawable.ic_convidados,
                ativo = selectedTool == Tool.CONVIDADOS,
                onClick = {
                    navController.navigate(Screen.Convidado.route){
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )



        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

