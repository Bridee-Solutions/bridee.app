package com.example.bridee.convidados.presentation.convidado

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.convidados.presentation.component.ActionReport
import com.example.bridee.convidados.presentation.component.ActionSquare
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection

@Composable
fun ConvidadoScreen(navController: NavController){

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
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
            modifier = Modifier.fillMaxWidth()
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
                    .padding(start = 5.dp, top = 10.dp)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDD7B78)
                            )
                            .width(30.dp)
                            .clip(shape = RoundedCornerShape(15f)),
                    ) {
                        Text(
                            text = "10",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "Convidados"
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box (
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDD7B78)
                            )
                            .width(30.dp)
                            .clip(shape = RoundedCornerShape(15f))
                    ) {
                        Text(
                            text = "2",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "Convites"
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box (
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDD7B78)
                            )
                            .width(30.dp)
                            .clip(shape = RoundedCornerShape(15f))
                    ) {
                        Text(
                            text = "3",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "Adultos"
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box (
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDD7B78)
                            )
                            .width(30.dp)
                            .clip(shape = RoundedCornerShape(15f))
                    ) {
                        Text(
                            text = "3",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "Família da Amanda"
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box (
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDD7B78)
                            )
                            .width(30.dp)
                            .clip(shape = RoundedCornerShape(15f))
                    ) {
                        Text(
                            text = "3",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "Amigos"
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box (
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDD7B78)
                            )
                            .width(30.dp)
                            .clip(shape = RoundedCornerShape(15f))
                    ) {
                        Text(
                            text = "3",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "Colegas de trabalho"
                    )
                }
            }
        }

    }

}