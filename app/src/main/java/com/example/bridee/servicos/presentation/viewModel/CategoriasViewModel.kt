package com.example.bridee.servicos.presentation.viewModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.mutableStateListOf
import com.example.bridee.R
import com.example.bridee.servicos.domain.Categoria
import com.example.bridee.servicos.domain.Subcategoria
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.lifecycle.ViewModel

data class Categoria(
    val id: Int,
    val nome: String,
    val icone: ImageVector,
    val subcategorias: List<Subcategoria> = emptyList()
)

data class Subcategoria(
    val id: String,
    val nome: String,
    val local: String = "Local não especificado",
    val descricao: String = "Descrição não fornecida",
    val imagem: Int = R.drawable.image_home,
    val precoMedio: String? = null,
    val rating: Float? = null
)

class CategoriasViewModel : ViewModel() {
    private val privateCategorias = mutableStateListOf<Categoria>()
    val categorias: List<Categoria> = privateCategorias

    init { loadMockData() }

    private fun loadMockData() {
        privateCategorias.addAll(
            listOf(
                Categoria(
                    id = 1,
                    nome = "Assessores",
                    icone = Icons.Default.Person
                ),
                Categoria(
                    id = 2,
                    nome = "Estilo de casamento",
                    icone = Icons.Default.Home,
                    subcategorias = listOf(
                        Subcategoria(
                            id = "1",
                            nome = "Ar Livre",
                            local = "Vários locais",
                            descricao = "Casamentos ao ar livre",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "Variável",
                        ),
                        Subcategoria(
                            id = "2",
                            nome = "Igrejas",
                            local = "Várias localizações",
                            descricao = "Casamentos em igrejas",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "Doação sugerida",
                        ),
                        Subcategoria(
                            id = "3",
                            nome = "Castelos",
                            local = "Vários locais",
                            descricao = "Casamentos em castelos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 15.000,00",
                        ),
                        Subcategoria(
                            id = "4",
                            nome = "Espaço de evento",
                            local = "Várias cidades",
                            descricao = "Salões de eventos para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 8.000,00",
                        ),
                        Subcategoria(
                            id = "5",
                            nome = "Hotéis",
                            local = "Várias localizações",
                            descricao = "Casamentos em hotéis",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 12.000,00",
                        ),
                        Subcategoria(
                            id = "6",
                            nome = "Praia",
                            local = "Litoral brasileiro",
                            descricao = "Casamentos na praia",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 10.000,00",
                        ),
                        Subcategoria(
                            id = "7",
                            nome = "Sítios",
                            local = "Áreas rurais",
                            descricao = "Casamentos em sítios e fazendas",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 7.000,00",
                        )
                    )
                ),
                Categoria(
                    id = 3,
                    nome = "Fornecedores",
                    icone = Icons.Default.Home,
                    subcategorias = listOf(
                        Subcategoria(
                            id = "1",
                            nome = "Florista",
                            local = "Várias localizações",
                            descricao = "Arranjos florais para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 2.500,00",
                        ),
                        Subcategoria(
                            id = "2",
                            nome = "Buffet e Gastronomia",
                            local = "Várias cidades",
                            descricao = "Serviços de alimentação para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 100,00 por pessoa",
                        ),
                        Subcategoria(
                            id = "3",
                            nome = "Vestidos",
                            local = "Ateliês e lojas especializadas",
                            descricao = "Vestidos de noiva e trajes para casamento",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 3.000,00",
                        ),
                        Subcategoria(
                            id = "4",
                            nome = "Fotógrafo",
                            local = "Profissionais disponíveis em várias regiões",
                            descricao = "Cobertura fotográfica para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 4.000,00",
                        ),
                        Subcategoria(
                            id = "5",
                            nome = "Videógrafo",
                            local = "Profissionais disponíveis em várias regiões",
                            descricao = "Filmagem profissional de casamentos",
                            imagem = R.drawable.videographer,
                            precoMedio = "A partir de R$ 5.000,00",
                        ),
                        Subcategoria(
                            id = "6",
                            nome = "Decoração",
                            local = "Profissionais disponíveis em várias regiões",
                            descricao = "Serviços de decoração para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 6.000,00",
                        ),
                        Subcategoria(
                            id = "7",
                            nome = "Confeitaria",
                            local = "Confeitarias especializadas",
                            descricao = "Bolos e doces para casamentos",
                            imagem = R.drawable.cake,
                            precoMedio = "A partir de R$ 1.500,00",
                        ),
                        Subcategoria(
                            id = "8",
                            nome = "Moda e Beleza",
                            local = "Salões e profissionais especializados",
                            descricao = "Maquiagem, cabelo e cuidados para o casamento",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 1.200,00",
                        ),
                        Subcategoria(
                            id = "9",
                            nome = "Papelaria",
                            local = "Gráficas especializadas",
                            descricao = "Convites e papelaria para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 800,00",
                        ),
                        Subcategoria(
                            id = "10",
                            nome = "Entretenimento",
                            local = "Bandas e DJs disponíveis",
                            descricao = "Música e entretenimento para casamentos",
                            imagem = R.drawable.rancho_raveiro,
                            precoMedio = "A partir de R$ 3.000,00",
                        ),

                    )
                )
            )
        )
    }
}