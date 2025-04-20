package com.example.bridee.auth.presentation.registration.fases.fase2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bridee.R
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.core.navigation.Screen
import com.example.bridee.ui.theme.BrideeTheme

@Composable
fun Fase2RegistrationScreen(navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 20.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Header(
            navController = navController,
            fillPercentage = (40*2).dp,
            previousFase = Screen.Fase1Registration.route

        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp) // padding mais suave
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(R.drawable.streamline_champagne_party_alcohol),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = "Vamos começar a festa...",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Responda a algumas perguntas rápidas e criaremos seu painel de planejamento personalizado para tornar o casamento dos seus sonhos uma realidade!",
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = 24.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Button(
            onClick = {
                navController.navigate(Screen.Fase3Registration.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD86B67),
                contentColor = Color.White
                
            ),
            modifier = Modifier
                .height(40.dp)
                .width(windowWidthDp - 200.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(25)
        ) {
            Text("Vamos", color = Color.White)
        }
    }

}

@Preview(showBackground = false)
@Composable
fun Fase2RegistrationScreenPreview() {
    BrideeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Fase2RegistrationScreen(navController = rememberNavController())
        }
    }
}