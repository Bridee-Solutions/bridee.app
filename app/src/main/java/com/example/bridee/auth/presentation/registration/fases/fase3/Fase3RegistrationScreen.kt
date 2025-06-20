package com.example.bridee.auth.presentation.registration.fases.fase3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.RegistrationSharedViewModel
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.core.navigation.Screen
import com.example.bridee.core.toast.ToastUtils

@Composable
fun Fase3RegistrationScreen(viewModel: RegistrationSharedViewModel, navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp
    val registrationState = viewModel.sharedRegistrationObject

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(windowHeightDp - 150.dp)
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Header(
            navController = navController,
            fillPercentage = (40*3).dp,
            previousFase = Screen.Fase2Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .height(350.dp)
        ) {
            Text(
                text = "Qual o seu nome?",
                style = MaterialTheme.typography.titleMedium
            )
            Column {
                Text("Primeiro nome",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 19.sp))
                Spacer(modifier = Modifier.height(5.dp))

                Input(
                    state = registrationState.value.nome,
                    onStateChange = {
                        registrationState.value = registrationState.value.copy(nome = it)
                    },
                    isValid = viewModel.isNomeValid(),
                    height = 50.dp
                )
            }
            Text(
                text = "Qual o nome do seu amor?",
                style = MaterialTheme.typography.titleMedium
            )
            Column {
                Text("Primeiro nome",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 19.sp)
                )
                Spacer(modifier = Modifier.height(5.dp))

                Input(
                    state = registrationState.value.nomeParceiro,
                    onStateChange = {
                        registrationState.value = registrationState.value.copy(nomeParceiro = it)
                    },
                    isValid = viewModel.isParceiroNomeValid(),
                    height = 50.dp
                )
            }
        }

        Button(
            onClick = {
                viewModel.showDialog = true
                if(viewModel.isFase3Valid()){
                    viewModel.showDialog = false
                    navController.navigate(Screen.Fase4Registration.route)
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
        ShowToast(viewModel)
    }
}

@Composable
fun ShowToast(viewModel: RegistrationSharedViewModel){
    if(!viewModel.isFase3Valid() && viewModel.showDialog){
        ToastUtils.ErrorToast(
            message = "Os nomes devem ter no mínimo 3 caracteres",
            contentAlignment = Alignment.TopStart
        )
        viewModel.showDialog = false
    }
}


