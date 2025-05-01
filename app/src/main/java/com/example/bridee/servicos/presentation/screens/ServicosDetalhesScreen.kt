package com.example.bridee.servicos.presentation.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.servicos.presentation.components.OrcamentoDialog
import com.example.bridee.servicos.presentation.components.ServicoHeader
import com.example.bridee.servicos.presentation.components.ServicoInformacoes
import com.example.bridee.servicos.presentation.components.ServicoLocalizacao
import com.example.bridee.servicos.presentation.components.ServicoPerguntasFrequentes
import com.example.bridee.servicos.presentation.components.SolicitarOrcamentoButton
import com.example.bridee.servicos.presentation.viewModel.ServicosDetalhesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ServicosDetalhesScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: ServicosDetalhesViewModel = viewModel() //
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            uiState.servico?.let { servico ->
                ServicoHeader(
                    nome = servico.nome,
                    localizacao = servico.localizacao,
                    imagem = servico.imagem,
                    onBackClick = { navController.popBackStack() }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text("Website", modifier = Modifier.padding(end = 16.dp), fontWeight = FontWeight.Bold)
                    Text("Imagens", fontWeight = FontWeight.Normal)
                }

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                ServicoInformacoes(descricao = servico.descricao)
                Spacer(modifier = Modifier.height(16.dp))

                ServicoPerguntasFrequentes(
                    perguntas = servico.perguntasFrequentes,
                    servicos = servico.servicosOferecidos
                )
                Spacer(modifier = Modifier.height(16.dp))

                ServicoLocalizacao(endereco = servico.endereco)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        SolicitarOrcamentoButton(
            onClick = { viewModel.toggleDialog(true) }
        )
    }

    if (uiState.showDialog) {
        OrcamentoDialog(
            onDismiss = { viewModel.toggleDialog(false) },
            onConfirm = { viewModel.toggleDialog(false) }
        )
    }
}