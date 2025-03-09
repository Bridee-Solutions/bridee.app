package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
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
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        FerramentasSection()
        Spacer(modifier = Modifier.height(16.dp))
        ControleDeGastoCard()
        CategoriaScreen()
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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
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
                    text = "Resta:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "R$60.000",
                    style = MaterialTheme.typography.bodyLarge
                )
            }


            LinearProgressIndicator(
                progress = 0.66f,
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
fun CategoriaScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(1.dp))

    )  {
    Column(modifier = Modifier.padding(16.dp)) {
        // Título e botão de adicionar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categoria",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF484646),
            )

            Text(
                text = "+ CATEGORIA",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFD77C8C),
                modifier = Modifier.clickable { }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        // Lista de categorias
        val categorias = listOf(
            CategoriaItem("Fornecedores", "10 despesas", "R$2.900", R.drawable.ic_fornecedores),
            CategoriaItem("Moda e Beleza", "10 despesas", "R$1.900", R.drawable.ic_moda_beleza),
            CategoriaItem("Decoração", "5 despesas", "R$5.600", R.drawable.ic_decoracao)
        )

        categorias.forEachIndexed { index, item ->
            CategoriaCard(item)

            if (index < categorias.size - 1) {
                Divider(
                    color = Color(0xFFE8E8E8),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
    }
}

@Composable
fun CategoriaCard(item: CategoriaItem) {
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
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = Color(0xFFD77C8C),
                modifier = Modifier.size(32.dp)
            )
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
                Text(
                    text = item.despesas,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF5C5757)
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


data class CategoriaItem(val nome: String, val despesas: String, val valor: String, val icon: Int)

@Preview(showSystemUi = true)
@Composable
fun PreviewCalculadoraScreen() {
    BrideeTheme {
        CalculadoraScreen()
    }
}