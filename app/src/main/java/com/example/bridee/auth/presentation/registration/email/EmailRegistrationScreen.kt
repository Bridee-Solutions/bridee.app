package com.example.bridee.auth.presentation.registration.email

import BrideeLogo
import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.bridee.ui.theme.BrideeTheme

@Composable
fun EmailRegistrationScreen(){

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
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Confirmação de e-mail",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 26.sp),

                    )
                Spacer(
                    modifier = Modifier.height(25.dp)
                )
                Image(
                    painter = painterResource(R.drawable.certo),
                    contentDescription = "E-mail image",
                    modifier = Modifier.size(150.dp)

                )
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.height(200.dp)
            ) {
                Text(
                    text = "Enviamos um e-mail para [e-mail] para confirmar a validade do seu endereço de e-mail. Após receber o e-mail, siga o link fornecido para completar o seu registro.",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 17.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Row (
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Se você não recebeu o e-mail,",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 17.sp),

                        )
                    Spacer(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "clique aqui",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 17.sp),

                        color = Color(0xFFF38986),
                        modifier = Modifier.clickable {}
                    )
                }
            }
        }
    }


}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun EmailRegistrationScreenPreview() {
    BrideeTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            EmailRegistrationScreen()
        }
    }
}