package com.example.bridee.auth.presentation.registration.fases.fase3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase3RegistrationScreen(registrationState: RegistrationState, navController: NavController){

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
                style = MaterialTheme.typography.titleMedium
            )
            Column {
                Text("Primeiro nome",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 19.sp))
                Spacer(modifier = Modifier.height(5.dp))

                Input(
                    state = registrationState.nome.value,
                    onStateChange = {
                        registrationState.nome.value = it
                    },
                    height = 50.dp
                )
            }
            Text(
                text = "Qual o nome do seu amor?",
                style = MaterialTheme.typography.titleMedium
            )
            Column {
                Text("Primeiro nome",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 19.sp)
                )
                Spacer(modifier = Modifier.height(5.dp))

                Input(
                    state = registrationState.nomeParceiro.value,
                    onStateChange = {
                        registrationState.nomeParceiro.value = it
                    },
                    height = 50.dp
                )
            }
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