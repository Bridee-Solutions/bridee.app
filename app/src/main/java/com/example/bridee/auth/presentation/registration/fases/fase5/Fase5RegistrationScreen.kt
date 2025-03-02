package com.example.bridee.auth.presentation.registration.fases.fase5

import DateDefaults
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.component.MaskVisualTransformation
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase5RegistrationScreen(registrationState: RegistrationState,navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp
    var isDeletingCharacter by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Header(
            navController = navController,
            fillPercentage = windowWidthDp - 150.dp,
            previousFase = Screen.Fase4Registration.route
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .height(350.dp)
        ) {
            Text(
                text = "Você já definiu uma data para o casamento",
                textAlign = TextAlign.Center,
                fontSize = TextUnit(
                    value = 20f,
                    type = TextUnitType.Sp
                ),
                modifier = Modifier.width(250.dp)
            )
            TextField(
                value = registrationState.dataCasamento.value,
                onValueChange = {
                    if(registrationState.dataCasamento.value.length < DateDefaults.DATE_LENGTH ||
                        isDeletingCharacter){
                        registrationState.dataCasamento.value = it
                    }
                },
                visualTransformation = MaskVisualTransformation(DateDefaults.DATE_MASK),
                modifier = Modifier.onKeyEvent {
                    isDeletingCharacter = it.key.keyCode == Key.Backspace.keyCode
                    true
                }
                    .border(
                    BorderStroke(width = 2.dp, color = Color(0xFF999999)),
                    shape = RoundedCornerShape(30)
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = false,
                    onCheckedChange = {}
                )
                Text(
                    text = "Ainda não sabemos"
                )
            }
            Button(
                onClick = {
                    navController.navigate(Screen.Fase6Registration.route)
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

}