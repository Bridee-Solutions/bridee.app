package com.example.bridee.auth.presentation.registration.fases.fase2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase2RegistrationScreen(navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column (
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Header(
            navController = navController,
            fillPercentage = (40*2).dp,
            previousFase = Screen.Fase1Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .width(windowWidthDp)
                .padding(35.dp, 0.dp)
                .height(350.dp)
        ) {

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Image(
                painter = painterResource(R.drawable.streamline_champagne_party_alcohol),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Spacer(
                modifier = Modifier.height(40.dp)
            )
            Text(text = "Vamos começar a festa...",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp)
                )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(text = "Responda a algumas perguntas rápidas e criaremos seu painel de planejamento personalizado para tornar o casamento dos seus sonhos realidade!",
                textAlign = TextAlign.Center)
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Button(
            onClick = {
                navController.navigate(Screen.Fase3Registration.route)
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
            Text("Vamos")
        }
    }

}