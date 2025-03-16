package com.example.bridee.core.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bridee.R
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.rosa


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // função para verificar as telas da ferramenta, ou seja, quando tarefas e convidados ficar pronto, adiciona aqui
    fun isFerramentasSelected(currentRoute: String?): Boolean {
        return currentRoute in listOf(
            Screen.Calculadora.route,
            Screen.CategoriaDetalhes.route
        )
    }

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.height(60.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == Screen.Home.route) Color(0xFFDD7B78) else Color(0xFF808080)
                )
                Text(
                    text = "Home",
                    fontSize = 12.sp,
                    color = if (currentRoute == Screen.Home.route) Color(0xFFDD7B78) else Color(0xFF808080)
                )
            }
        }

        // Item Ferramentas
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screen.Ferramentas.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tools),
                    contentDescription = "Ferramentas",
                    modifier = Modifier.size(24.dp),
                    tint = if (isFerramentasSelected(currentRoute)) Color(0xFFDD7B78) else Color(0xFF808080)
                )
                Text(
                    text = "Ferramentas",
                    fontSize = 12.sp,
                    color = if (isFerramentasSelected(currentRoute)) Color(0xFFDD7B78) else Color(0xFF808080)
                )
            }
        }
        // Item Serviços
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screen.Servicos.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_services),
                    contentDescription = "Serviços",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == Screen.Servicos.route) Color(0xFFDD7B78) else Color(0xFF808080)
                )
                Text(
                    text = "Serviços",
                    fontSize = 12.sp,
                    color = if (currentRoute == Screen.Servicos.route) Color(0xFFDD7B78) else Color(0xFF808080)
                )
            }
        }

        // Item Inspiração
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screen.Inspiracao.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_inspiration),
                    contentDescription = "Inspiração",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == Screen.Inspiracao.route) Color(0xFFDD7B78) else Color(0xFF808080)
                )
                Text(
                    text = "Inspiração",
                    fontSize = 12.sp,
                    color = if (currentRoute == Screen.Inspiracao.route) Color(0xFFDD7B78) else Color(0xFF808080)
                )
            }
        }
    }
}
