package com.example.bridee.auth.presentation.registration.fases.fase1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase1RegistrationScreen(navController: NavController){

    val registrationState by remember{
        mutableStateOf(
            RegistrationState()
        )
    }

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row {
            Text(
                text = "Já possui uma conta? ",
                fontSize = TextUnit(
                    value = 20.0f,
                    type = TextUnitType.Sp
                )
            )
            Text(
                text = "Faça login",
                style = TextStyle(
                    color = Color(0xFFB55557),
                    fontSize = TextUnit(
                        value = 20.0f,
                        type = TextUnitType.Sp
                    )
                )
            )
        }
        Column(
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
        }
        Text(
            text = "Crie uma conta e comece a planejar seu casamento",
            fontSize = TextUnit(
                22.0f,
                TextUnitType.Sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.width(windowWidthDp - 80.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.height(230.dp)
        ){
            Input(
                state = registrationState.email.value,
                onStateChange = {
                    registrationState.email.value = it
                },
                placeholder = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email",
                        tint = Color(0xFFB55557)
                    )
                    Text(
                        text = "E-mail",
                        modifier = Modifier.offset(x = 30.dp),
                        color = Color(0xFFC2C2C2)
                    )
                }
            )
            Input(
                state = registrationState.senha.value,
                onStateChange = {
                    registrationState.senha.value = it
                },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Senha",
                        tint = Color(0xFFB55557)
                    )
                    Text(
                        text = "Senha",
                        modifier = Modifier.offset(x = 30.dp),
                        color = Color(0xFFC2C2C2)
                    )
                }
            )
            Input(
                state = registrationState.confirmarSenha.value,
                onStateChange = {
                    registrationState.confirmarSenha.value = it
                },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Senha",
                        tint = Color(0xFFB55557)
                    )
                    Text(
                        text = "Confirmar senha",
                        modifier = Modifier.offset(x = 30.dp),
                        color = Color(0xFFC2C2C2)
                    )
                }
            )
        }
        Button(
            onClick = {
                navController.navigate(route = Screen.Fase2Registration.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD86B67)
            ),
            modifier = Modifier.height(50.dp)
                .width(windowWidthDp - 120.dp),
            shape = RoundedCornerShape(25)
        ) {
            Text("Próximo")
        }
        Row {
            Text(
                text = "Você é um assessor? ",
                fontSize = TextUnit(
                    value = 20.0f,
                    type = TextUnitType.Sp
                )
            )
            Text(
                text = "Clique aqui.",
                style = TextStyle(
                    color = Color(0xFFB55557),
                    fontSize = TextUnit(
                        value = 20.0f,
                        type = TextUnitType.Sp
                    )
                )
            )
        }
    }
}