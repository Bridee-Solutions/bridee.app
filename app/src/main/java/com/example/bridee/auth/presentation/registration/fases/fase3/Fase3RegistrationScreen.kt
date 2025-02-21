package com.example.bridee.auth.presentation.registration.fases.fase3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.auth.presentation.registration.loadbar.LoadBar

@Preview(showBackground = true)
@Composable
fun Fase3RegistrationScreen(){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    val registrationState by remember {
        RegistrationState(nome = )
    }

    Column (
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.offset(x = 10.dp,y = 20.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                tint = Color(0xFFAE6261)
            )
            Text("VOLTAR")
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 100.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "bridee.",
                fontSize = TextUnit(
                    value = 48.0f,
                    type = TextUnitType.Sp
                )
            )
            Text(
                text = "O match perfeito para o dia dos seus sonhos",
                fontSize = TextUnit(
                    value = 16.0f,
                    type = TextUnitType.Sp
                )
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.width(windowWidthDp - 100.dp)
                    .clip(
                        shape = RoundedCornerShape(50)
                    )
                    .background(Color(0xFFE3E3E3))
            ) {
                LoadBar(windowWidthDp - 150.dp)
            }
        }
        
        Column () {
            Text("Qual o seu nome")
            TextField()
        }

    }
}