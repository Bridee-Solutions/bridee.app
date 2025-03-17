package com.example.bridee.auth.presentation.registration.fases.fase6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.CustomCheckbox
import com.example.bridee.auth.presentation.component.CustomRadioButton
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.auth.presentation.registration.RegistrationState
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase6RegistrationScreen(registrationState: RegistrationState ,navController: NavController){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    val (selectedOption, setSelectedOption) = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Header(
            navController = navController,
            fillPercentage = windowWidthDp - 150.dp,
            previousFase = Screen.Fase5Registration.route
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)

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
            Row (
                modifier = Modifier.width(windowWidthDp - 100.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "0-50",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("0-50") else setSelectedOption(null)
                            } )
                        Text(
                            text = "0-50",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "51-100",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("51-100") else setSelectedOption(null)
                            }
                        )
                        Text(
                            text = "51-100",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "101-150",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("101-150") else setSelectedOption(null)
                            }
                        )
                        Text(
                            text = "101-150",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "151-200",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("151-200") else setSelectedOption(null)
                            }
                        )
                        Text(
                            text = "151-200",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                }
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "201-300",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("201-300") else setSelectedOption(null)
                            }
                        )
                        Text(
                            text = "0-50",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "300+",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("300+") else setSelectedOption(null)
                            }
                        )
                        Text(
                            text = "300",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        CustomCheckbox(
                            checked = selectedOption == "Decidir depois",
                            onCheckedChange = { isChecked ->
                                if (isChecked) setSelectedOption("Decidir depois") else setSelectedOption(null)
                            }
                        )
                        Text(
                            text = "Decidir depois",
                            modifier = Modifier.padding(end = 15.dp, start = 8.dp),
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                navController.navigate(route = Screen.Fase7Registration.route)
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
    }
}