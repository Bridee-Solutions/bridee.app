package com.example.bridee.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.bridee.R
import com.example.bridee.home.domain.Fornecedor

@Composable
fun FornecedorItem(fornecedor: Fornecedor) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = fornecedor.drawableResId),
            contentDescription = "Ícone do fornecedor",
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))


        Column(modifier = Modifier.weight(1f)) {
            Text(text = fornecedor.nome, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = fornecedor.descricao, fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.width(12.dp))


        if (fornecedor.selecionado) {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Selecionado",
                tint = Color.Green,
                modifier = Modifier.size(37.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Selecionar fornecedor",
                tint = Color.Gray,
                modifier = Modifier.size(37.dp)
            )
        }
    }
}
