package com.example.bridee.convidados.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .width(screenWidth.dp - 60.dp)
                    .height(120.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xC3C3C3C9),
                        shape = RoundedCornerShape(15)
                    )
                    .padding(start = 15.dp, top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row (
                    modifier = Modifier
                        .width(70.dp)
                ) {
                    Box(
                        modifier =  Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clip(shape = RoundedCornerShape(50))
                            .background(
                                color = Color.Green
                            )
                    )
                    Box(
                        modifier =  Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clip(shape = RoundedCornerShape(50))
                            .background(
                                color = Color.Yellow
                            )
                    )
                    Box(
                        modifier =  Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clip(shape = RoundedCornerShape(50))
                            .background(
                                color = Color.Red
                            )
                    )
                }
                Row{
                    Text("Relatório de convidados")
                }
                Row(
                    modifier = Modifier.offset(y = (-10).dp)
                ){
                    Text(
                        text = "5 convidados irão comparecer",
                        fontSize = TextUnit(
                            value = 12.0f,
                            type = TextUnitType.Sp
                        )
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .width((screenWidth * 0.75).dp)
                .offset(x = 30.dp, y = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .width((screenWidth * 0.35).dp)
                    .height(100.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xC3C3C3C9),
                        shape = RoundedCornerShape(15)
                    )
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
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
            Column(
                modifier = Modifier
                    .width((screenWidth * 0.35).dp)
                    .height(100.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xC3C3C3C9),
                        shape = RoundedCornerShape(15)
                    )
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
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

    }

}