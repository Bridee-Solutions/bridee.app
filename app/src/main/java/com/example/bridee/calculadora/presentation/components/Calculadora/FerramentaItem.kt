package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.ui.theme.cinza

@Composable
fun FerramentaItem(nome: String, iconeRes: Int, ativo: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(70.dp)
            .clickable { onClick() }
            .background(if (ativo) Color.White else cinza.copy(alpha = 0.5f))
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