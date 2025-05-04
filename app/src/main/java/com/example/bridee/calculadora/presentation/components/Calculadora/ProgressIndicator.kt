package com.example.bridee.calculadora.presentation.components.Calculadora

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bridee.ui.theme.rosa
import java.math.BigDecimal

@Composable
fun ProgressIndicator(
    text: String,
    value: BigDecimal,
    percentage: BigDecimal
){

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "R$${value}",
            style = MaterialTheme.typography.bodyLarge
        )
    }

    LinearProgressIndicator(
        progress = "$percentage".toFloat(),
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(vertical = 4.dp),
        color = rosa
    )

    Spacer(modifier = Modifier.height(20.dp))
}