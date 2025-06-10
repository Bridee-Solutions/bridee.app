package com.example.bridee.auth.presentation.registration.fases.fase4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.bridee.auth.presentation.component.CustomCheckbox
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.core.navigation.Screen
import com.example.bridee.core.toast.ToastUtils

@Composable
fun Fase4RegistrationScreen(viewModel: RegistrationSharedViewModel, navController: NavController){

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
            fillPercentage = (40*4).dp,
            previousFase = Screen.Fase3Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        ) {
            Text(
                text = "Você já reservou um local?",
                style = MaterialTheme.typography.titleMedium
            )
            Row (
                horizontalArrangement = Arrangement.Center
            ) {

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomCheckbox(
                            checked = registrationState.value.isLocalReservado,
                            onCheckedChange = {
                                registrationState.value = registrationState.value.copy(isLocalReservado = true, local = "")
                            }
                        )
                        Text(
                            text = "Sim",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                }
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomCheckbox(
                            checked = !registrationState.value.isLocalReservado,
                            onCheckedChange = {
                                registrationState.value = registrationState.value.copy(
                                    isLocalReservado = false,
                                    local = ""
                                )
                            }
                        )
                        Text(
                            text = "Não",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                        )
                    }
                }
            }

            if (registrationState.value.isLocalReservado) {
                Text(
                    text = "Ótimo! Vamos adicionar ao seu plano.",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )
            } else {
                Text(
                    text = "Em qual região você gostaria de se casar?",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )
            }


            Input(
                state = registrationState.value.local,
                onStateChange = {
                    registrationState.value = registrationState
                        .value.copy(local = it)
                },
                height = 50.dp
            )

        }

        Button(
            onClick = {
                viewModel.showDialog = true
                if(viewModel.isFase4Valid()){
                    viewModel.showDialog = false
                    navController.navigate(Screen.Fase5Registration.route)
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
    if(!viewModel.isFase4Valid() && viewModel.showDialog){
        ToastUtils.ErrorToast(
            message = "Preencha as informações do local corretamente",
            contentAlignment = Alignment.TopStart
        )
        viewModel.showDialog = false
    }
}