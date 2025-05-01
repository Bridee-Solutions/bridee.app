package com.example.bridee.servicos.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bridee.servicos.domain.PerguntaResposta
import com.example.bridee.servicos.domain.Servico
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ServicosDetalhesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ServicosDetalhesUiState())
    val uiState: StateFlow<ServicosDetalhesUiState> = _uiState.asStateFlow()

    fun toggleDialog(show: Boolean) {
        _uiState.value = _uiState.value.copy(showDialog = show)
    }

    // Carregar dados do serviço (simulado)
    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                servico = Servico(
                    id = "1",
                    nome = "Veiga Estúdios",
                    localizacao = "São Bernardo do Campo, São Paulo",
                    descricao = "Seu casamento será um dia cheio de momentos que irá querer guardar e relembrar...",
                    servicosOferecidos = listOf(
                        "Fotografias em alta resolução",
                        "Pós-wedding",
                        "Álbum digital",
                        "Blu-ray ou DVD com todas as fotografias",
                        "Entrega digital do material",
                        "Usb/pen drive com o material",
                        "Outros (Serviços de fotografia e videografia no exterior)",
                        "Pré-wedding",
                        "Drones",
                        "Vídeo",
                        "Mini álbuns",
                        "Fotografia"
                    ),
                    perguntasFrequentes = listOf(
                        PerguntaResposta(
                            "Quais são os serviços que realiza?",
                            "Mínimo 1 semana e máximo 2 anos antes"
                        ),
                        PerguntaResposta(
                            "Com que antecedência devo entrar em contato?",
                            "Pelo menos 3 meses antes"
                        ),
                        PerguntaResposta(
                            "O que inclui o pack de casamento?",
                            "Tem diversos pacotes, entre em contato para receber mais detalhes"
                        ),
                        PerguntaResposta(
                            "Cobre mais de um casamento por dia?",
                            "Sim"
                        )
                    ),
                    endereco = "Rua Hall, 101 - Jardim América, São José dos Campos - SP, 12345-070"
                )
            )
        }
    }
}

data class ServicosDetalhesUiState(
    val showDialog: Boolean = false,
    val servico: Servico? = null
)