package com.example.bridee.auth.presentation.registration.fases.fase6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.GuestOption
import com.example.bridee.auth.domain.RegistrationSharedViewModel
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.core.navigation.Screen
import com.example.bridee.core.toast.ToastUtils

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Fase6RegistrationScreen(viewModel: RegistrationSharedViewModel, navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp
    val guestOption = viewModel.guestOptions.filter { it.selected }

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Header(
            navController = navController,
            fillPercentage = (40*6).dp,
            previousFase = Screen.Fase5Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .height(250.dp)
        ) {
            Text(
                text = "Quantos convidados você acha que terá?"
            )
            Row (
                modifier = Modifier.width(windowWidthDp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FlowColumn(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    viewModel.guestOptions.forEach {guestOption ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = guestOption.selected,
                                onClick = {
                                    viewModel.updateGuestQuantity(guestOption)
                                }
                            )
                            Text(
                                text = guestOption.value
                            )
                        }
                    }
                }
            }
        }
        Button(
            onClick = {
                viewModel.showDialog = true
                if(guestOption.isNotEmpty()){
                    navController.navigate(route = Screen.Fase7Registration.route)
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
        ShowToast(viewModel, guestOption)
    }
}

@Composable
fun ShowToast(
    viewModel: RegistrationSharedViewModel,
    guestOption: List<GuestOption>
){
    if(guestOption.isEmpty() && viewModel.showDialog){
        ToastUtils.ErrorToast(
            message = "Selecione uma opção",
            contentAlignment = Alignment.TopStart
        )
        viewModel.showDialog = false
    }
}