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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.ui.components.ferramentas_section.domain.Tool
import com.example.bridee.ui.components.ferramentas_section.presentation.screens.FerramentasSection

@Composable
fun ConvidadoScreen(navController: NavController){

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
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
                    .width(screenWidth - 60.dp)
                    .height(120.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xC3C3C3C9),
                        shape = RoundedCornerShape(15)
                    )
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
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
                Row{
                    Text("5 convidados irão comparecer")
                }
            }
        }

    }

}