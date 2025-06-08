package com.example.bridee.configuracoes.presentation.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
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
import com.example.bridee.configuracoes.presentation.viewmodel.ConfiguracaoViewModel
import com.example.bridee.home.presentation.components.EditableText
import com.example.bridee.ui.theme.rosa


@Composable
fun AccountDetailsCard(
    isEditing: Boolean,
    viewModel: ConfiguracaoViewModel
) {

    var email = viewModel.information?.casamentoResponse?.casal?.email

    Column(
        modifier = Modifier
            .fillMaxWidth()

            .background(Color(0xFFFCFAF2))
    ) {
        Text(
            "Detalhes da conta",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp) )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Endereço de e-mail",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 20.dp) )
        EditableText(
            text = email ?: "",
            onTextChange = {
                email = it
                viewModel.information = viewModel.information?.copy(
                    casamentoResponse = viewModel.updateEmailCasal(it)
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
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .clickable { /* Logout */ }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.deslogar),
                contentDescription = "Deslogar",
                tint = rosa,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 20.dp, bottom = 20.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Deslogar da conta", color = Color.Black,
                modifier = Modifier.padding(start = 5.dp, bottom = 20.dp) )
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}