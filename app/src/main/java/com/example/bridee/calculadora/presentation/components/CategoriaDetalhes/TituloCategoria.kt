package com.example.bridee.calculadora.presentation.components.CategoriaDetalhes

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R

@Composable
fun tituloCategoria(nomeCategoria: String, icon: Int, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 20.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.seta),
                contentDescription = "Voltar",
                tint = Color(0xFFA09F9F),
                modifier = Modifier
                    .size(39.dp)
                    .clickable {
                        Log.d("NAVIGATION", "Navegação chamadaaaaaaa")
                        navController.popBackStack()
                    }

            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = nomeCategoria,
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Ícone $nomeCategoria",
                tint = Color.Unspecified,
                modifier = Modifier.size(70.dp)
            )
        }
    }
}
