package com.example.bridee.servicos.presentation.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.core.navigation.Screen
import com.example.bridee.servicos.presentation.components.OrcamentoDialog
import com.example.bridee.servicos.presentation.components.ServicoHeader
import com.example.bridee.servicos.presentation.components.ServicoInformacoes
import com.example.bridee.servicos.presentation.components.ServicoPerguntasFrequentes
import com.example.bridee.servicos.presentation.components.SolicitarOrcamentoButton
import com.example.bridee.servicos.presentation.viewModel.ServicosDetalhesViewModel


@Composable
fun ServicosDetalhesScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: ServicosDetalhesViewModel
) {
    val associadoInfo = viewModel.associadoInformationResponseDto
    var showDialog by remember { mutableStateOf(false) }
    LaunchedEffect (true){
        viewModel.loadScreenInformation()
    }

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
            associadoInfo?.let { servico ->
                ServicoHeader(
                    nome = servico.nome,
                    localizacao = servico.cidade + servico.bairro,
                    imagem = servico.imagens[0],
                    onBackClick = { navController.popBackStack() },
                    onImageClick = {
                        val imagesString = servico.imagens.joinToString(separator = ",")
                        navController.currentBackStackEntry?.savedStateHandle?.set("images", imagesString)
                        navController.navigate(Screen.GaleriaImagens.route)
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        "Website",
                        modifier = Modifier.padding(end = 16.dp),
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        "Imagens",
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.GaleriaImagens.route)
                        },
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                ServicoInformacoes(descricao = servico.visaoGeral)
                Spacer(modifier = Modifier.height(16.dp))

                ServicoPerguntasFrequentes(
                    perguntas = mutableListOf(),
                    servicos = servico.tiposCasamento
                )
                Spacer(modifier = Modifier.height(16.dp))

//                ServicoLocalizacao(endereco = servico.)
//                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        SolicitarOrcamentoButton(
            onClick = {showDialog = true}
        )
    }

    if (showDialog) {
        OrcamentoDialog(
            onDismiss = { showDialog = false },
            onConfirm = { showDialog = false }
        )
    }
}