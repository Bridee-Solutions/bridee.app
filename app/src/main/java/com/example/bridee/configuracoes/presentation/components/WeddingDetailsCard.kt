package com.example.bridee.configuracoes.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
import com.example.bridee.R
import com.example.bridee.configuracoes.presentation.viewmodel.ConfiguracaoViewModel
import com.example.bridee.home.presentation.components.EditableText
import com.example.bridee.ui.theme.rosa

@Composable
fun WeddingDetailsCard(
    isEditing: Boolean,
    viewModel: ConfiguracaoViewModel
) {
    var weddingDate by remember { mutableStateOf(viewModel.information?.casamentoResponse?.dataCasamento) }
    var weddingLocation by remember { mutableStateOf(viewModel.information?.casamentoResponse?.local)}
    val numberOfGuests = viewModel.information?.casamentoResponse?.quantidadeConvidados
    val budget = viewModel.information?.orcamentoResponse?.orcamentoTotal

    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text("Detalhes do casamento",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.calendario),
                "Data",
                tint = rosa,
                modifier = Modifier.padding(start = 20.dp) )
            Spacer(modifier = Modifier.width(6.dp))
            EditableText(
                text = weddingDate ?: "",
                onTextChange = {
                    weddingDate = it
                    viewModel.information = viewModel.information?.copy(
                        casamentoResponse = viewModel.updateDataCasamentoInformation(it)
                    )
                },
                isEditing = isEditing,
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.place),
                "Local",
                tint = rosa,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            EditableText(
                text = weddingLocation ?: "",
                onTextChange = {
                    weddingLocation = it
                    viewModel.information = viewModel.information?.copy(
                        casamentoResponse = viewModel.updateLocalInformation(it)
                    )
                },
                isEditing = isEditing,
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.people),
                "Convidados", tint = rosa,
                modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            EditableText(
                text = numberOfGuests ?: "0",
                onTextChange = {},
                isEditing = false,
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.money),
                "Orçamento", tint = rosa,
                modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            EditableText(
                text = (budget ?: "0").toString(),
                onTextChange = {},
                isEditing = false,
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

    }
}
