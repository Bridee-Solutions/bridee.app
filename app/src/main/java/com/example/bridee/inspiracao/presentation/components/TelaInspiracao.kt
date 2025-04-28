package com.example.bridee.inspiracao.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bridee.R
import com.example.bridee.auth.domain.InspiracoesViewModel
import com.example.bridee.ui.theme.rosa
import coil.compose.AsyncImage

@Composable
fun TelaInspiracao(viewModel: InspiracoesViewModel = viewModel()) {
    val imagens by viewModel.images.collectAsState()

    var showFilterDialog by remember { mutableStateOf(false) }
    var selectedFilter by remember { mutableStateOf("Todos os estilos") }


    val filtros = listOf(
        "Todos os estilos",
        "Ar livre",
        "Igrejas",
        "Castelos",
        "Espaços de eventos",
        "Praias",
        "Espaços Industriais",
        "Hotéis",
        "Sítios"
    )


    LaunchedEffect(selectedFilter) {
        viewModel.searchImages(selectedFilter.toQuery())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filtrar",
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Filtrar por ",
                color = Color(0xFF3C3939),
                fontSize = 14.sp
            )

            Box(
                modifier = Modifier
                    .clickable { showFilterDialog = true }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedFilter,
                        color = rosa,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "Expandir filtros",
                        tint = rosa,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            imagens?.photos?.let { photos ->
                items(photos) { photo ->
                    AsyncImage(
                        model = photo.source.medium,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        }


        if (showFilterDialog) {
            Dialog(
                onDismissRequest = { showFilterDialog = false }
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column {
                        Text(
                            text = "Filtrar por estilo",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        )

                        Divider()

                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            filtros.forEach { estilo ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            selectedFilter = estilo
                                            showFilterDialog = false
                                        }
                                        .padding(vertical = 12.dp, horizontal = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = estilo,
                                        modifier = Modifier.weight(1f)
                                    )
                                    if (estilo == selectedFilter) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Selecionado",
                                            tint = rosa,
                                        )
                                    }
                                }
                            }
                        }

                        Divider()

                        TextButton(
                            onClick = { showFilterDialog = false },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("OK", color = rosa)
                        }
                    }
                }
            }
        }
    }
}

fun String.toQuery(): String {
    return when (this) {
        "Todos os estilos" -> "wedding styles"
        "Ar livre" -> "outdoor wedding"
        "Igrejas" -> "church wedding"
        "Castelos" -> "castle wedding"
        "Espaços de eventos" -> "event space wedding"
        "Praias" -> "beach wedding"
        "Espaços Industriais" -> "industrial wedding"
        "Hotéis" -> "hotel wedding"
        "Sítios" -> "country wedding"
        else -> "wedding styles"
    }
}
