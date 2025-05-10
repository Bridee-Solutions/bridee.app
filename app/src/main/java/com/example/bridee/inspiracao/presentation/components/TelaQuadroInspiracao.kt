package com.example.bridee.inspiracao.presentation.components

import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bridee.R
import com.example.bridee.inspiracao.domain.TelaInspiracaoViewModel
import com.example.bridee.ui.theme.rosa

@Composable
fun TelaQuadroInspiracao(viewModel: TelaInspiracaoViewModel) {

    val items = viewModel.pexelsFavoriteImages
    LaunchedEffect(true) {
        viewModel.findFavoritesImages()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFE0E0E0))
                    ) {
                        AsyncImage(
                            model = item?.data,
                            contentDescription = "Imagem favoritada",
                            modifier = Modifier.size(200.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = "Favoritar",
                        colorFilter = ColorFilter.tint(rosa),
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                            .size(24.dp)
                    )
                }
            }
        }
    }
}