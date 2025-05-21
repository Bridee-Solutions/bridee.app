package com.example.bridee.convidados.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDePesquisa(
    textoPesquisa: String,
    aoPesquisar: (String) -> Unit,
    aoAbrirFiltro: () -> Unit
) {
    var texto by remember { mutableStateOf(textoPesquisa) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFDF8F0))
            .padding(horizontal = 25.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = texto,
            onValueChange = {
                texto = it
                aoPesquisar(it)
            },
            placeholder = {
                Text(
                    "Pesquisar",
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 55.sp
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de busca",
                    tint = Color.Gray,
                    modifier = Modifier.size(18.dp)
                )
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
        )

        Spacer(modifier = Modifier.width(15.dp))

        IconButton(
            onClick = { aoAbrirFiltro() },
            modifier = Modifier
                .size(40.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Ícone de filtro",
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarDePesquisaPreview() {
    TopBarDePesquisa(
        textoPesquisa = "",
        aoPesquisar = {},
        aoAbrirFiltro = {}
    )
}

