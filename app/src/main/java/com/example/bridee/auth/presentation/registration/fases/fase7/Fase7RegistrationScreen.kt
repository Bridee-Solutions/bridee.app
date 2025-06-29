package com.example.bridee.auth.presentation.registration.fases.fase7

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.RegistrationSharedViewModel
import com.example.bridee.auth.presentation.component.CustomCheckbox
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.component.SmallCheckbox
import com.example.bridee.core.navigation.Screen


@Composable
fun Fase7RegistrationScreen(viewModel: RegistrationSharedViewModel,navController: NavController){

    var offset by remember {
        mutableStateOf(0f)
    }
    val termsText = """
Última atualização: 07 de junho de 2025

Seja bem-vindo(a) à bridee!

Este aplicativo foi criado para auxiliar no planejamento do seu casamento. Ao utilizar nossos serviços, você concorda com os seguintes termos:

1. Coleta de dados: Coletamos informações básicas como nome, e-mail, data do casamento e preferências para personalizar sua experiência.

2. Uso das informações: Suas informações são utilizadas exclusivamente para fornecer e melhorar nossos serviços. Não compartilhamos seus dados com terceiros sem seu consentimento.

3. Segurança: Adotamos medidas de segurança para proteger suas informações, mas lembramos que nenhum sistema é 100% seguro.

4. Responsabilidades: A bridee não se responsabiliza por compromissos criados ou não confirmados, tampouco por decisões tomadas com base em funcionalidades do app.

5. Modificações: Podemos alterar estes termos a qualquer momento. Recomendamos revisar periodicamente.

6. Contato: Em caso de dúvidas, fale conosco pelo e-mail suporte@bridee.app

Ao continuar, você declara estar ciente e de acordo com os termos acima.
""".trimIndent()
    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(windowHeightDp - 150.dp)
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Header(
            navController = navController,
            fillPercentage = windowWidthDp,
            previousFase = Screen.Fase6Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Termos de uso e política de privacidade",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 21.sp),
            )
            TextField(
                value = termsText,
                onValueChange = {}, modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(20.dp)
                    .border(
                        BorderStroke(width = 1.dp, color = Color(0x56999999)),
                        shape = RoundedCornerShape(3)
                    )
                    .scrollable(
                        orientation = Orientation.Vertical,
                        state = rememberScrollableState {
                            offset += it
                            it
                        }
                    ),
                textStyle = TextStyle(fontSize = 12.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        Row {
            SmallCheckbox(
                checked = viewModel.isTermsApproved,
                onCheckedChange = {
                    viewModel.isTermsApproved = it
                },
                modifier = Modifier.padding(end = 5.dp, top = 5.dp)
            )
            Text(
                text = "Li e concordo com os termos de uso e política de privacidade",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 15.sp),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if(viewModel.isTermsApproved){
                    viewModel.saveCasal(navController);
                }else{
                    // TODO: adicionar toast
                }
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
            Text("Próximo", color = Color.White)
        }

    }

}









