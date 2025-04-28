package com.example.bridee.auth.presentation.login

import BrideeLogo
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.AuthenticationViewModel
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.core.navigation.Screen
import com.example.bridee.core.toast.ToastUtils

@Composable
fun LoginScreen(authenticationViewModel: AuthenticationViewModel,navController: NavController){

    val loginState = authenticationViewModel.loginState

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.height(5.dp))

        Row {
            Text(
                text = "Não tem uma conta? ",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Cadastre-se",
                style = MaterialTheme.typography.titleSmall.copy(color = Color(0xFFB55557),
                    fontWeight = FontWeight.Bold),
                modifier = Modifier.clickable(enabled = true){
                    navController.navigate(route = Screen.Cadastro.route)
                }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BrideeLogo(fontSize = 50.sp)
            Text(
                text = "O match perfeito para o dia dos seus sonhos",
                fontSize = TextUnit(
                    value = 16.0f,
                    type = TextUnitType.Sp
                )
            )
        }
        Text(
            text = "Bem vindo de volta!",
            style = MaterialTheme.typography.titleMedium
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.height(200.dp)
        ){
            Input(
                state = loginState.value.email,
                onStateChange = {
                    loginState.value = loginState.value.copy(email = it)
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
                },
            )
            Input(
                state = loginState.value.senha,
                onStateChange = {
                    loginState.value = loginState.value.copy(senha = it)
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
                },
            )
            Text(
                text = "Esqueceu sua senha?",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Button(
            onClick = {
                authenticationViewModel.authenticate(navController)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD86B67)
            ),
            modifier = Modifier.height(50.dp)
                .width(windowWidthDp - 120.dp),
            shape = RoundedCornerShape(25)
        ) {
            Text("Entrar")
        }
        Row {
            Text(
                text = "Você é um assessor? ",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Clique aqui.",
                style = MaterialTheme.typography.titleSmall.copy(color = Color(0xFFB55557),
                    fontWeight = FontWeight.Bold),
            )
        }
        ShowToast(authenticationViewModel)
    }
}

@Composable
fun ShowToast(viewModel: AuthenticationViewModel){
    if(viewModel.showDialog && !viewModel.isEnabled){
        ToastUtils.ErrorToast(
            message = "Usuário e/ou senha inválido(s)",
            contentAlignment = Alignment.TopStart
        )
        viewModel.showDialog = false
    }
}