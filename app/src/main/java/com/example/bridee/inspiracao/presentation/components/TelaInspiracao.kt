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
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.bridee.R
import com.example.bridee.inspiracao.domain.PexelsResponseDto
import com.example.bridee.inspiracao.domain.TelaInspiracaoViewModel
import com.example.bridee.ui.theme.rosa

@Composable
fun TelaInspiracao(viewModel: TelaInspiracaoViewModel) {
    val pexelsInfo = viewModel.pexelsInfo ?: PexelsResponseDto()
    var showFilterDialog by remember { mutableStateOf(false) }
    var inspiracao by remember { mutableStateOf("Casamento") }
    val lazyState = rememberLazyGridState()
    val reachedBottom by remember {
        derivedStateOf {
            lazyState.reachedBottom()
        }
    }

    LaunchedEffect(true) {
        viewModel.findPexelsImage(inspiracao);
    }

    LaunchedEffect(reachedBottom) {
        if(reachedBottom && (pexelsInfo?.photos?.isNotEmpty() == true)){
            viewModel.lastPageFetched++
            viewModel.findPexelsImage(inspiracao);
        }
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
                        text = "Todos os estilos",
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
            state = lazyState,
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(pexelsInfo.photos) { item ->
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .background(Color(0xFFE0E0E0))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFE0E0E0))
                        ) {
                            AsyncImage(
                                model = item.source.small,
                                contentDescription = item.altText,
                                modifier = Modifier.size(200.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        val favoritarColor = if (item.favorite){
                            ColorFilter.tint(rosa)
                        }else {
                            ColorFilter.tint(Color(0xFFE0E0E0))
                        }
                        Image(
                            painter = painterResource(id = R.drawable.bookmark),
                            contentDescription = "Favoritar",
                            colorFilter = favoritarColor,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp)
                                .size(24.dp)
                                .clickable {
                                    if(item.favorite){
                                        viewModel.desfavoriteImage(item.id.toInt())
                                        viewModel.toggleFavoriteImage(item.id)
                                    }else{
                                        viewModel.favoriteImage(item)
                                        viewModel.toggleFavoriteImage(item.id)
                                    }
                                }
                        )
                    }
                }
            }
        )
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
                        listOf(
                            "Todos os estilos",
                            "Ar livre",
                            "Igrejas",
                            "Castelos",
                            "Espaços de eventos",
                            "Praias",
                            "Espaços Industriais",
                            "Hotéis",
                            "Sítios"
                        ).forEach { estilo ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.lastPageFetched = 1
                                        inspiracao = "Casamento em $estilo"
                                        viewModel.findPexelsImage(inspiracao)
                                        showFilterDialog = false
                                    }
                                    .padding(vertical = 12.dp, horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = estilo,
                                    modifier = Modifier.weight(1f)
                                )
                                if (estilo == "Todos os estilos") {
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

fun LazyGridState.reachedBottom(): Boolean {
    val visibleItemsInfo = layoutInfo.visibleItemsInfo
    return if (layoutInfo.totalItemsCount == 0 || visibleItemsInfo.isEmpty()) {
        false
    } else {
        val lastVisibleItem = visibleItemsInfo.last()
        lastVisibleItem.index >= layoutInfo.totalItemsCount - 1
    }
}