package com.example.bridee.core.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar

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



@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    fun obterCorDeSelecao(route: String?, selectedRoute: String): Color {
        return if (route == selectedRoute) Color(0xFFDD7B78) else Color(0xFF808080)
    }

    fun navigateTo(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        }
    }

    @Composable
    fun NavigationItem(iconRes: Int, label: String, route: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .clickable { navigateTo(route) }
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                tint = obterCorDeSelecao(currentRoute, route)
            )
            Text(
                text = label,
                fontSize = 12.sp,
                color = obterCorDeSelecao(currentRoute, route)
            )
        }
    }

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.height(60.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            NavigationItem(R.drawable.ic_home, "Home", Screen.Home.route, Modifier.weight(1f))
            NavigationItem(R.drawable.ic_tools, "Ferramentas", Screen.Ferramentas.route, Modifier.weight(1f))
            NavigationItem(R.drawable.ic_services, "Serviços", Screen.Servicos.route, Modifier.weight(1f))
            NavigationItem(R.drawable.ic_inspiration, "Inspiração", Screen.Inspiracao.route, Modifier.weight(1f))
        }
    }
}
