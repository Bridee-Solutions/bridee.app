package com.example.bridee.convidados.presentation.convidado

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavController
import com.example.bridee.auth.presentation.component.Input
import com.example.bridee.core.dropdown.DropdownMenu

@Composable
fun AdicionarConvidadoScreen(navController: NavController){

    val screenWidth = LocalConfiguration.current.screenWidthDp
    var windowScroll = rememberScrollState()
    var nomeConvidado by remember {
        mutableStateOf("")
    }
    var whatsapp by remember {
        mutableStateOf("")
    }
    var categoria by remember {
        mutableStateOf("")
    }

    var selectedCategoriaIndex by remember{
        mutableStateOf(0)
    }

    var selectedConfirmacaoIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(windowScroll)
    ) {
        Row (
            modifier = Modifier
                .width((screenWidth * 0.45).dp)
                .height(60.dp)
                .padding(
                    start = 10.dp,
                    bottom = 10.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = "Icone para navegar para a tela de convites",
                tint = Color(0xFFA09F9F)
            )
            Text(
                text = "Adicionar convidado"
            )
        }
        Spacer(modifier = Modifier
            .background(
                Color(0xFFA09F9F)
            )
            .height(1.dp)
            .fillMaxWidth(),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Dados do convidado",
                modifier = Modifier
                    .padding(start = 30.dp)
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
            ) {
                Text(
                    text = "Nome do Convidado"
                )
                OutlinedTextField(
                    value = nomeConvidado,
                    onValueChange = {
                        nomeConvidado = it
                    },
                    singleLine = true,
                    modifier = Modifier
                        .width((screenWidth * 0.8).dp)
                        .heightIn(max = 50.dp)
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
            ) {
                Text(
                    text = "Whatsapp"
                )
                OutlinedTextField(
                    value = whatsapp,
                    onValueChange = {
                        whatsapp = it
                    },
                    singleLine = true,
                    modifier = Modifier
                        .width((screenWidth * 0.8).dp)
                        .heightIn(max = 50.dp)
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
            ) {
                Text(
                    text = "Categoria"
                )
                DropdownMenu(
                    itemList = listOf("Familia da Noiva", "Familia do Noivo"),
                    selectedIndex = selectedCategoriaIndex,
                    onItemClick = {
                        selectedCategoriaIndex = it
                    },
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = Color(0x00000000),
                        shape = RoundedCornerShape(10f)
                    )
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Faixa Etária"
                )
                Box (){
                    Row {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                            Text(
                                text = "Adulto"
                            )
                        }
                        Row {
                            Text(
                                text = "Criança"
                            )
                        }
                    }
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Confirmação de presença"
                )
                Text(
                    text = "Status"
                )
                DropdownMenu(
                    itemList = listOf("Não irá comparecer", "Confirmado"),
                    selectedIndex = selectedConfirmacaoIndex,
                    onItemClick = {
                        selectedConfirmacaoIndex = it
                    },
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(10f)
                        )
                )
            }
        }
    }

}
