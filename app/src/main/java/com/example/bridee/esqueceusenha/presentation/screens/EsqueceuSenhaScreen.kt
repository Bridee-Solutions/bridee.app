package com.example.bridee.esqueceusenha.presentation.screens

import BrideeLogo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.bridee.auth.presentation.component.Input
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle


@Composable
fun EsqueceuSenhaScreen() {
    var email by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BrideeLogo(fontSize = 50.sp)
            Text(
                text = "O match perfeito para o dia dos seus sonhos",
                fontSize = 16.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp)
                .weight(1f, fill = false),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(95.dp))
            Text(
                text = "Esqueceu sua senha?",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Digite o e-mail associado à sua conta e enviaremos um link para redefinir sua senha.",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Input(
                state = email,
                onStateChange = { email = it },
                placeholder = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "E-mail",
                        tint = Color(0xFFB55557)
                    )
                    Text(
                        text = "Digite seu e-mail",
                        modifier = Modifier.offset(x = 30.dp),
                        color = Color(0xFFC2C2C2))
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD86B67),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(25)
            ) {
                Text("Enviar", color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFD86B67))) {
                            append("Não recebeu o e-mail? ")
                        }
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("Clique aqui para reenviar o token")
                        }
                    }
                )
            }
        }
    }
}
