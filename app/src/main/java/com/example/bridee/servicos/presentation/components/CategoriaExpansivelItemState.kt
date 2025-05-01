package com.example.bridee.servicos.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.bridee.servicos.domain.Categoria


class CategoriaExpansivelItemState (
    controleExpansao: Boolean = false
){
    var expandida by mutableStateOf(controleExpansao)
        private set

    fun toggleExpansao() {
        expandida = !expandida
    }
}

@Composable
fun rememberCategoriaExpansivelItemState(
    controleExpansao: Boolean = false
): CategoriaExpansivelItemState {
    return remember {
        CategoriaExpansivelItemState(controleExpansao)
    }
}

@Composable
fun CategoriaExpansivelItem(
    categoria: Categoria,
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    state: CategoriaExpansivelItemState = rememberCategoriaExpansivelItemState()

) {
    Card(
        modifier = modifier.animateContentSize(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { state.toggleExpansao() }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = categoria.icone,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = categoria.nome,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
            }

            AnimatedVisibility(visible = state.expandida && categoria.subcategorias.isNotEmpty()
            ) {
                Column(modifier = Modifier.padding(start = 56.dp, bottom = 8.dp)) {
                    categoria.subcategorias.forEach { subcategoria ->
                        Text(
                            text = "${subcategoria.nome}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController?.navigate("subcategoria/${subcategoria.id}")
                                }
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}