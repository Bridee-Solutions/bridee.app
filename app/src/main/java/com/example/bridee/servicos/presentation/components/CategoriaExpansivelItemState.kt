package com.example.bridee.servicos.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.core.navigation.Screen
import com.example.bridee.servicos.domain.Categoria

@Composable
fun CategoriaExpansivelItem(
    categoria: Categoria,
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    state: CategoriaExpansivelItemState = rememberCategoriaExpansivelItemState(initialExpanded = categoria.nome.equals("Assessores", ignoreCase = true))
) {
    val isAssessores = categoria.nome.equals("Assessores", ignoreCase = true)
    Card(
        modifier = modifier.animateContentSize(),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { if (!isAssessores) state.toggleExpansao()  }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(
                        id = when (categoria.nome.lowercase()) {
                            "assessores" -> R.drawable.wedding_day
                            "estilo de casamento" -> R.drawable.arch
                            else -> R.drawable.fotografia
                        }
                    ),
                    contentDescription = "Ícone da categoria",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = categoria.nome,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                    modifier = Modifier.weight(1f),
                    color = Color.Black
                )

                Icon(
                    painter = painterResource(
                        id = if (isAssessores) R.drawable.ic_setaesquerda
                        else if (state.expandida) R.drawable.ic_setabaixo
                        else R.drawable.ic_setaesquerda
                    ),
                    contentDescription = if (isAssessores) "Item fixo" else "Expandir/Recolher",
                    tint = Color(0xFFB55557),
                    modifier = Modifier.size(24.dp)
                )

            }

            AnimatedVisibility(
                visible = state.expandida && categoria.subcategorias.isNotEmpty(),
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(start = 56.dp, bottom = 8.dp)) {
                    categoria.subcategorias.forEachIndexed { index, subcategoria ->
                        if (index > 0) {
                            Divider(
                                color = Color(0xFFE0E0E0),
                                thickness = 1.dp,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }

                        Text(
                            text = subcategoria.nome,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController?.navigate(
                                        Screen.ServicosSubcategoriaScreen.createRoute(subcategoria.nome, subcategoria.id.toInt()))
                                }
                                .padding(vertical = 12.dp, horizontal = 16.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.Black
                            )
                        )
                    }
                }
            }
        }
    }
}

class CategoriaExpansivelItemState(initialExpanded: Boolean) {
    var expandida by mutableStateOf(initialExpanded)
        private set

    fun toggleExpansao() {
        expandida = !expandida
    }
}

@Composable
fun rememberCategoriaExpansivelItemState(
    initialExpanded: Boolean = false
): CategoriaExpansivelItemState {
    return remember { CategoriaExpansivelItemState(initialExpanded) }
}