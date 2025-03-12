package com.example.bridee.calculadora.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bridee.R
import com.example.bridee.core.navigation.Screen
import com.example.bridee.ui.theme.BrideeTheme

data class SubcategoriaItemData(
    val nome: String,
    val valor: String
)


@Composable
fun CategoriaDetalhesScreen(nomeCategoria: String, icon: Int, navController: NavController) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        tituloCategoria(nomeCategoria, icon, navController)
        ControleGastoDetalhes()
        Subcategorias()
    }
}



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



@Composable
fun ControleGastoDetalhes() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(19.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
    )  {
        Column(
            modifier = Modifier.
            padding(16.dp)
        ) {
            Text(
                text = "Controle de Gasto",
                color = Color(0xFF484646),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total gasto:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R$30.000",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            // Barra de progresso
            LinearProgressIndicator(
                progress = 0.33f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(vertical = 4.dp),
                color = Color(0xFFDD7B78)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Orçamento total:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R\$90.000",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        }
    }
}

@Composable
fun Subcategorias() {
    val subcategoriasList = listOf(
        SubcategoriaItemData("Vestido de madrinha", "R$500"),
        SubcategoriaItemData("Sapato de madrinha",  "R$700"),
        SubcategoriaItemData("Vestido de noiva", "R$6.000"),
        SubcategoriaItemData("Maquiagem",  "R$1.200"),
        SubcategoriaItemData("Acessórios",  "R$950")
    )

    Column( //
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(1.dp))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Subcategorias",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF484646),
            )

            Text(
                text = "+ SUBCATEGORIA",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFD77C8C),
                modifier = Modifier.clickable { }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(subcategoriasList) { item ->
                SubcategoriaItem(item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@Composable
fun SubcategoriaItem(item: SubcategoriaItemData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(1f)) {
                Text(
                    text = item.nome,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFF484646)
                    )
                )

            }
            Text(
                text = item.valor,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFF484646)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Opções"
                )
            }
        }
    }
}
