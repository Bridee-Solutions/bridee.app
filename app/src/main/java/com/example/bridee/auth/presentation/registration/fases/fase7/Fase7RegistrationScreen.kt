package com.example.bridee.auth.presentation.registration.fases.fase7

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.auth.domain.RegistrationSharedViewModel
import com.example.bridee.auth.presentation.component.Header
import com.example.bridee.core.navigation.Screen

@Composable
fun Fase7RegistrationScreen(viewModel: RegistrationSharedViewModel,navController: NavController){

    var offset by remember {
        mutableStateOf(0f)
    }

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val windowHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(windowHeightDp - 150.dp),
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
                .height(300.dp)
        ) {
            Text(
                text = "Termos de uso e política de privacidade",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 21.sp),
            )
            TextField(
                value = "",
                onValueChange = {}, modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
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
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        Row {
            Checkbox(
                checked = viewModel.isTermsApproved,
                onCheckedChange = {
                    viewModel.isTermsApproved = it
                }
            )
            Text(
                text = "Li e concordo com os termos de uso e política de privacidade",
                textAlign = TextAlign.Start
            )
        }
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
            Text("Próximo")
        }
    }

}