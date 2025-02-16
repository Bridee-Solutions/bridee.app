package com.example.bridee.auth.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(){

    val loginState by remember {
        mutableStateOf(
            LoginState(
                email = mutableStateOf(""),
                senha = mutableStateOf("")
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row {
            Text("Não tem uma conta? ")
            Text("Cadastre-se")
        }
        Text("Bridee.")
        Text("O match perfeito para o dia dos seus sonhos")
        Text("Bem vindo de volta!")
        TextField(
            value = loginState.email.value,
            onValueChange = {
                loginState.email.value = it
            },
            placeholder = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )
                Text("E-mail")
            }
        )
        TextField(
            value = loginState.senha.value,
            onValueChange = {
                loginState.senha.value = it
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Senha"
                )
                Text("Senha")
            }
        )
        Text("Esqueceu sua senha?")
        Button(
            onClick = {}
        ) {
            Text("Entrar")
        }
        Text("Você é um assessor?")
    }
}