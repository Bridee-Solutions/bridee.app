package com.example.bridee.auth.presentation.registration.fases.fase6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.GuestOption
import com.example.bridee.auth.domain.RegistrationSharedViewModel
import com.example.bridee.auth.presentation.component.CustomCheckbox
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.core.navigation.Screen
import com.example.bridee.core.toast.ToastUtils

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Fase6RegistrationScreen(viewModel: RegistrationSharedViewModel, navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp
    val guestOption = viewModel.guestOptions.filter { it.selected }
    val col1 = viewModel.guestOptions.take(viewModel.guestOptions.size / 2 + viewModel.guestOptions.size % 2)
    val col2 = viewModel.guestOptions.takeLast(viewModel.guestOptions.size / 2)
    Column(
        modifier = Modifier
            .fillMaxWidth()

            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Header(
            navController = navController,
            fillPercentage = (40*6).dp,
            previousFase = Screen.Fase5Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .height(400.dp)

        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Quantas pessoas você espera receber?",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 21.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    viewModel.guestOptions.take(4).forEach { guestOption ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            CustomCheckbox(
                                checked = guestOption.selected,
                                onCheckedChange = { viewModel.updateGuestQuantity(guestOption) },
                                modifier = Modifier.padding(end = 12.dp)
                            )
                            Text(text = guestOption.value)
                        }
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    viewModel.guestOptions.drop(4).forEach { guestOption ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            CustomCheckbox(
                                checked = guestOption.selected,
                                onCheckedChange = { viewModel.updateGuestQuantity(guestOption) },
                                modifier = Modifier.padding(end = 12.dp)
                            )
                            Text(text = guestOption.value)
                        }
                    }
                }
            }



    }
        Button(
            onClick = {
                viewModel.showDialog = true
                if(guestOption.isNotEmpty()){
                    viewModel.showDialog = false
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
            Text("Próximo", color = Color.White)
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