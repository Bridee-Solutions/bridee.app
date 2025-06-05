package com.example.bridee.configuracoes.presentation.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.EditableText

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.configuracoes.presentation.viewmodel.ConfiguracaoViewModel
import com.example.bridee.home.presentation.components.EditableText


@Composable
fun ProfileDetailsCard(
    isEditing: Boolean,
    viewModel: ConfiguracaoViewModel
) {
    var nome = viewModel.information?.casamentoResponse?.casal?.nome
    var nomeParceiro = viewModel.information?.casamentoResponse?.casal?.nomeParceiro
    var telefone = viewModel.information?.casamentoResponse?.casal?.telefone

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFFCFAF2))) {
        Text(
            "Detalhes do perfil",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Seu nome",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 20.dp)
        )

        EditableText(
            text = nome ?: "",
            onTextChange = {
                nome = it
                viewModel.information = viewModel.information?.copy(
                    casamentoResponse = viewModel.updateNomeCasal(it)
                )
            },
            isEditing = isEditing,
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "Nome do seu amor",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 20.dp)
        )


        EditableText(
            text = nomeParceiro ?: "",
            onTextChange = {
                nomeParceiro = it
                viewModel.information = viewModel.information?.copy(
                    casamentoResponse = viewModel.updateNomeParceiroCasal(it)
                )
            },
            isEditing = isEditing,
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Telefone",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 20.dp))

        EditableText(
            text = telefone ?: "",
            onTextChange = {
                telefone = it
                viewModel.information = viewModel.information?.copy(
                    casamentoResponse = viewModel.updateTelefoneCasal(it)
                )
            },
            isEditing = isEditing,
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

    }
}
