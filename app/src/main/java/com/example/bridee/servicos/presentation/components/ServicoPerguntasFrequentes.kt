package com.example.bridee.servicos.presentation.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bridee.R
import com.example.bridee.servicos.domain.PerguntaResposta

@Composable
fun ServicoPerguntasFrequentes(
    perguntas: List<PerguntaResposta>,
    servicos: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Text(
            "Perguntas frequentes",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))

        perguntas.forEach { pergunta ->
            Text(
                pergunta.pergunta,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                pergunta.resposta,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        servicos.forEach { servico ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = null,
                    tint = Color(0xFF28a745),
                    modifier = Modifier.size(16.dp)
                )
                    Spacer(modifier = Modifier.width(8.dp))
                     Text(servico, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
