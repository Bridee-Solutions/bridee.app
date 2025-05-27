package com.example.bridee.servicos.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.servicos.domain.AssociadoResponseDto
import com.example.bridee.ui.theme.rosa


@Composable
fun CardAssociado(
    associado: AssociadoResponseDto,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(8.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF000000).copy(alpha = 0.06f),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(40f)
                )
            }
    ) {
        Card(
            modifier = Modifier
                .graphicsLayer {
                    shadowElevation = 3.dp.toPx()
                    shape = RoundedCornerShape(16.dp)
                    clip = true
                }
                .clickable { onClick() },
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column {
//                Image(
//                    painter = painterResource(id = subcategoria.imagemPrincipal),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(180.dp)
//                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
//                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = associado.nome,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = associado.cidade + associado.bairro,
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = associado.visaoGeral,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = onClick,
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(containerColor = rosa)
                    ) {
                        Text("Ver mais", color = Color.White)
                    }
                }
            }
        }
    }
}
