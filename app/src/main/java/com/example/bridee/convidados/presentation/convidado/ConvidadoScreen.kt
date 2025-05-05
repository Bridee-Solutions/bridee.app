package com.example.bridee.convidados.presentation.convidado

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.convidados.domain.Convidado
import com.example.bridee.convidados.domain.Convite
import com.example.bridee.convidados.presentation.component.ActionCircle
import com.example.bridee.convidados.presentation.component.ActionReport
import com.example.bridee.convidados.presentation.component.ActionSquare
import com.example.bridee.convidados.presentation.component.CategoryBox
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection

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
                    modifier = Modifier.width(170.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(R.drawable.filter),
                        contentDescription = "Ícone que acompanha o total de convidados"
                    )
                    Text(
                        text = "Total de convidados",

                        )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    CategoryBox(
                        quantity = "10",
                        type = "Convidado(s)"
                    )
                    CategoryBox(
                        quantity = "2",
                        type = "Convites"
                    )
                    CategoryBox(
                        quantity = "3",
                        type = "Adultos"
                    )
                    CategoryBox(
                        quantity = "3",
                        type = "Familia da Amanda"
                    )
                    CategoryBox(
                        quantity = "3",
                        type = "Amigos"
                    )
                    CategoryBox(
                        quantity = "3",
                        type = "Colegas de trabalho"
                    )
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth()
                    .height(65.dp)
                    .background(
                        color = Color(0xFFF5F1DF)
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchState,
                    onValueChange = { searchState = it },
                    singleLine = true,
                    placeholder = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Pesquisa",
                            tint = Color(0xFF7E7E7E)
                        )
                        Text(
                            text = "Pesquisar",
                            modifier = Modifier.offset(x = 25.dp, y = (-2).dp),
                            color = Color(0xFF707070),
                        )
                    },
                    modifier = Modifier
                        .border(
                            BorderStroke(width = 1.dp, color = Color(0xFF999999)),
                            shape = RoundedCornerShape(30)
                        )
                        .width(240.dp)
                        .height(50.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = TextStyle(
                        lineHeight = TextUnit(
                            value = 25f,
                            type = TextUnitType.Sp
                        ),
                        fontSize = TextUnit(
                            value = 14f,
                            type = TextUnitType.Sp
                        )
                    )
                )
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White
                        )
                        .height(40.dp)
                        .width(40.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = ""
                    )
                }
            }
            Column {
                for(convite in convites) {
                    Column (
                        modifier = Modifier
                            .border(
                                width = 0.5.dp,
                                color = Color(0xFF9B9B9B)
                            )
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Row (
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(convite.nome)
                            Text(convite.ano)
                            Button(
                                onClick = {}
                            ) {
                                Text("Ver convite ->")
                            }
                        }
                        Column (
                            verticalArrangement = Arrangement.Top
                        ) {
                            convite.convidados.forEach {
                                Spacer(modifier = Modifier.height(10.dp))
                                Row (
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Row (
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.width((screenWidth * 0.5).dp)
                                            .padding(20.dp, 0.dp)
                                    ) {
                                        ActionCircle(
                                            color = Color.Green
                                        )
                                        Text(
                                            text = it.nome,
                                            modifier = Modifier.padding(start = 5.dp)
                                        )
                                    }
                                    Row (
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.width((screenWidth * 0.5).dp)
                                            .padding(end = 12.dp)
                                    ) {

                                        Text(
                                            text = it.tipo,
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(15f))
                                                .background(
                                                    color = Color(0xFFC1C1C1)
                                                )
                                                .padding(4.dp)
                                        )

                                        Text(
                                            text = it.faixaEtaria,
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(15f))
                                                .background(
                                                    color = Color(0xFFEFEAEA)
                                                )
                                                .padding(4.dp)
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}
