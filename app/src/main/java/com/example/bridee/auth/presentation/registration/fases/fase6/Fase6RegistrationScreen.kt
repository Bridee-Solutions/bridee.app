package com.example.bridee.auth.presentation.registration.fases.fase6

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.registration.loadbar.LoadBar
import com.example.bridee.core.nav.Screen

@Composable
fun Fase6RegistrationScreen(navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
                .offset(x = 15.dp)
                .clickable {
                    navController.navigate(route = Screen.Fase5Registration.route)
                }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                tint = Color(0xFFAE6261)
            )
            Text("VOLTAR")
        }

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
            Row(
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
        Column {
            Text(
                text = "Quantos convidados você acha que terá?"
            )
            Row (
                modifier = Modifier.width(windowWidthDp - 100.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "0-50"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "51-100"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "101-150"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "151-200"
                        )
                    }
                }
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "201-300"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "300"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = true,
                            onClick = {}
                        )
                        Text(
                            text = "Ainda não temos certeza"
                        )
                    }
                }
            }
        }
        Button(
            onClick = {},
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