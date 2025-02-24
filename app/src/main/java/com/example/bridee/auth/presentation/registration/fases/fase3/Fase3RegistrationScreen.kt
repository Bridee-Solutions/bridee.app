package com.example.bridee.auth.presentation.registration.fases.fase3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase3RegistrationScreen(navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Header(
            navController = navController,
            fillPercentage = windowWidthDp - 150.dp,
            previousFase = Screen.Fase2Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .height(350.dp)
        ) {
            Text(
                text = "Qual o seu nome?",
                fontSize = TextUnit(
                    value = 20.0f,
                    type = TextUnitType.Sp
                )
            )
            TextField(
                value = "",
                onValueChange = {
                },
                label = {
                    Text("Primeiro nome")
                },
                modifier = Modifier.width(windowWidthDp - 45.dp)
                    .border(
                        BorderStroke(width = 2.dp, color = Color(0xFF999999)),
                        shape = RoundedCornerShape(30)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )
            Text(
                text = "Qual o nome do seu amor?",
                fontSize = TextUnit(
                    value = 20.0f,
                    type = TextUnitType.Sp
                )
            )
            TextField(
                value = "",
                onValueChange = {
                },
                label = {
                    Text("Primeiro nome")
                },
                modifier = Modifier.width(windowWidthDp - 45.dp)
                    .border(
                        BorderStroke(width = 2.dp, color = Color(0xFF999999)),
                        shape = RoundedCornerShape(30)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )
        }

        Button(
            onClick = {
                navController.navigate(Screen.Fase4Registration.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD86B67)
            ),
            modifier = Modifier
                .height(40.dp)
                .width(windowWidthDp - 200.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(25)
        ) {
            Text("Próximo")
        }
    }
}