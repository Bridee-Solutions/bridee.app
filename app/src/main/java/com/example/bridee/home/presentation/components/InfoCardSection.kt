package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InfoCardSection(
    title: String,
    totalInfo: String,
    cards: List<Triple<String, String, Int>>,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFBF8F5))
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFFEAEAEA), RoundedCornerShape(12.dp))
                .padding(20.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = totalInfo,
                    fontSize = 14.sp,
                    color = Color(0xFF666666)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                cards.forEach { (valor, label, _) ->
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFFDF7F3), RoundedCornerShape(8.dp))
                            .border(1.dp, Color(0xFFEAEAEA), RoundedCornerShape(8.dp))
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = valor,
                            fontSize = 28.sp,
                            color = Color(0xFF333333)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = label,
                            fontSize = 14.sp,
                            color = Color(0xFF666666)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onClick,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(40.dp)
                    .fillMaxWidth(0.5f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE87A7A))
            ) {
                Text(
                    text = "Ver tudo",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoCardSectionPreview() {
    val exemploCards = listOf(
        Triple("20", "Concluídas", 0),
        Triple("78", "A fazer", 0),
        Triple("2", "Atrasadas", 0)
    )

    InfoCardSection(
        title = "Lista de tarefas",
        totalInfo = "100 tarefas",
        cards = exemploCards,
        onClick = { }
    )
}
