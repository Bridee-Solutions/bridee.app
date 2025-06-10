package com.example.bridee.auth.presentation.registration.email

import BrideeLogo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.auth.presentation.component.Title
import com.example.bridee.ui.theme.BrideeTheme

@Composable
fun EmailFailRegistrationScreen() {
    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BrideeLogo(fontSize = 50.sp)
            Text(
                text = "O match perfeito para o dia dos seus sonhos",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(15.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Confirmação de e-mail",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 26.sp),

                )
                Spacer(modifier = Modifier.height(25.dp))
                Image(
                    painter = painterResource(R.drawable.errado),
                    contentDescription = "E-mail image",
                    modifier = Modifier.size(120.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.height(250.dp)
            ) {
                Text(
                    text = "O link de confirmação enviado para [email] expirou. Por favor, solicite um novo e-mail de confirmação para validar seu endereço de e-mail e concluir o seu registro",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 17.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
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
                    Text("Enviar email", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun EmailFailRegistrationScreenPreview() {
    BrideeTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            EmailFailRegistrationScreen()
        }
    }
}