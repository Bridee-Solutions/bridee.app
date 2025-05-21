package com.example.bridee.convidados.presentation.convidado

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.convidados.domain.Convidado
import com.example.bridee.convidados.domain.Convite
import com.example.bridee.convidados.presentation.component.ActionReport
import com.example.bridee.convidados.presentation.component.ActionSquare
import com.example.bridee.convidados.presentation.component.CategoryBox
import com.example.bridee.convidados.presentation.component.ConviteComponent
import com.example.bridee.convidados.presentation.component.TopBarDePesquisa
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConvidadoScreen(navController: NavController){

    val screenWidth = LocalConfiguration.current.screenWidthDp
    var searchState by remember {
        mutableStateOf("")
    }
    val convidados = mutableListOf(
        Convidado(
            nome = "Ian",
            tipo = "Familia Noivo",
            status = "Pendente",
            faixaEtaria = "Adulto"
        ),
        Convidado(
            nome = "Ian",
            tipo = "Familia Noivo",
            status = "Pendente",
            faixaEtaria = "Adulto",
        ),
        Convidado(
            nome = "Ian",
            tipo = "Familia Noivo",
            status = "Pendente",
            faixaEtaria = "Adulto",
        ),
        Convidado(
            nome = "Ian",
            tipo = "Familia Noivo",
            status = "Pendente",
            faixaEtaria = "Adulto",
        )
    )
    val convites by remember {
        mutableStateOf(
            listOf(
                Convite(
                    nome = "Familia Martings",
                    ano = "1920",
                    convidados = convidados
                ),
                Convite(
                    nome = "Familia Martings",
                    ano = "1920",
                    convidados = convidados
                ),
                Convite(
                    nome = "Familia Martings",
                    ano = "1920",
                    convidados = convidados
                )
            )
        )
    }
    Text(text = "Valor da busca: '$searchState'")

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            FerramentasSection(navController, Tool.CONVIDADOS)

            ActionReport()
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ActionSquare {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Ícone para adição de novo convite"
                    )
                    Text(
                        text = "Adicionar convite",
                        fontSize = TextUnit(
                            type = TextUnitType.Sp,
                            value = 16.0F
                        )
                    )
                }
                VerticalDivider(modifier = Modifier.width(25.dp))
                ActionSquare {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "Ícone para adição de novo convite"
                    )
                    Text(
                        text = "Divulgar por WhatsApp",
                        fontSize = TextUnit(
                            type = TextUnitType.Sp,
                            value = 16.0F
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 35.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(R.drawable.filter),
                        contentDescription = "Ícone que acompanha o total de convidados",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Total de convidados",
                        style = MaterialTheme.typography.titleMedium,
                        )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Spacer(modifier = Modifier.height(10.dp))

                    CategoryBox(
                        quantity = "10",
                        type = "Convidado(s)"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CategoryBox(
                        quantity = "2",
                        type = "Convites"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CategoryBox(
                        quantity = "3",
                        type = "Adultos"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CategoryBox(
                        quantity = "3",
                        type = "Familia da Amanda"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CategoryBox(
                        quantity = "3",
                        type = "Amigos"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CategoryBox(
                        quantity = "3",
                        type = "Colegas de trabalho"
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                }
            }
            Spacer(modifier = Modifier.width(20.dp))

            TopBarDePesquisa(
                textoPesquisa = searchState,
                aoPesquisar = { newText ->
                    searchState = newText
                },
                aoAbrirFiltro = {
                   //
                }
            )



            Column {
                for(convite in convites) {
                    ConviteComponent(convite)
                }
            }
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}

