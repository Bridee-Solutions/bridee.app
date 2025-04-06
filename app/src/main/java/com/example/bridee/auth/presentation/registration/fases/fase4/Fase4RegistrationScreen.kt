package com.example.bridee.auth.presentation.registration.fases.fase4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.RegistrationSharedViewModel
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
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
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
                text = "Você já reservou um local?"
            )
            Row (
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = registrationState.value.isLocalReservado,
                            onCheckedChange = {
                                registrationState.value = registrationState.value.copy(isLocalReservado = true)
                            }
                        )
                        Text(
                            text = "Sim"
                        )
                    }
                }
                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = !registrationState.value.isLocalReservado,
                            onCheckedChange = {
                                registrationState.value = registrationState.value.copy(
                                    isLocalReservado = false,
                                    local = ""
                                )
                            }
                        )
                        Text(
                            text = "Não"
                        )
                    }
                }
            }
            Text(
                text = "Ótimo! vamos adicionar ao seu plano."
            )
            Input(
                state = registrationState.value.local,
                onStateChange = {
                    registrationState.value = registrationState
                        .value.copy(local = it, isLocalReservado = viewModel.isLocalReservado(it))
                },
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
            Text("Próximo")
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