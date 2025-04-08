package com.example.bridee.servicos.presentation.viewModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.bridee.servicos.domain.Categoria
import com.example.bridee.servicos.domain.Subcategoria

class CategoriasViewModel : ViewModel() {
    private val privateCategorias = mutableStateListOf<Categoria>()
    val categorias: List<Categoria> =  privateCategorias

    init { loadMockData() }

    private fun loadMockData(){
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
                        Subcategoria(1, "Ar Livre"),
                        Subcategoria(2, "Igrejas"),
                        Subcategoria(3, "Castelos"),
                        Subcategoria(4, "espaço de evento"),
                        Subcategoria(5, "Hotéis"),
                        Subcategoria(6, "Praia"),
                        Subcategoria(7, "Sítios")
                    )
                ),
                Categoria(
                    id = 3,
                    nome = "Fornecedores",
                    icone = Icons.Default.Home,
                    subcategorias = listOf(
                        Subcategoria(1, "Florista"),
                        Subcategoria(2, "Buffet e Gastronomia"),
                        Subcategoria(3, "Vestidos"),
                        Subcategoria(4, "Fotógrafo"),
                        Subcategoria(5, "Videógrafo"),
                        Subcategoria(6, "Decoração"),
                        Subcategoria(7, "Confeitaria"),
                        Subcategoria(8, "Moda e Beleza"),
                        Subcategoria(9, "Papelaria"),
                        Subcategoria(10, "Entenimento")
                    )
                )
            )
        )
    }

}