package com.example.bridee.auth.presentation.registration.fases.fase4

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.CustomCheckbox
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase4RegistrationScreen(registrationState: RegistrationState, navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    val (hasLocation, setHasLocation) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Header(
            navController = navController,
            fillPercentage = windowWidthDp - 150.dp,
            previousFase = Screen.Fase3Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        ) {
            Text(
                text = "Você já reservou um local?",
                style = MaterialTheme.typography.titleMedium
            )
            Row (
                horizontalArrangement = Arrangement.Center
            ) {

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomCheckbox(
                            checked = hasLocation,
                            onCheckedChange = { setHasLocation(true) }
                        )
                        Text(
                            text = "Sim",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                }
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        CustomCheckbox(
                            checked = !hasLocation,
                            onCheckedChange = { setHasLocation(false) }
                        )
                        Text(
                            text = "Não",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                        )
                    }
                }
            }

            if (hasLocation) {
                Text(
                    text = "Ótimo! Vamos adicionar ao seu plano.",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )
            } else {
                Text(
                    text = "Em qual região você gostaria de se casar?",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )
            }


            Input(
                state = registrationState.local.value,
                onStateChange = {
                    registrationState.local.value = it
                },
                height = 50.dp
            )

        }

        Button(
            onClick = {
                navController.navigate(Screen.Fase5Registration.route)
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