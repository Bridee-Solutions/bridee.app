package com.example.bridee.calculadora.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bridee.R
import com.example.bridee.calculadora.presentation.components.Calculadora.CategoriaScreen
import com.example.bridee.calculadora.presentation.components.Calculadora.ControleDeGastoCard
import com.example.bridee.calculadora.presentation.components.Calculadora.FerramentasSection
import com.example.bridee.core.navigation.Screen
import com.example.bridee.ui.theme.BrideeTheme
import com.example.bridee.ui.theme.cinza
import com.example.bridee.ui.theme.pretoMedio
import com.example.bridee.ui.theme.rosa
import com.seuapp.presentation.components.CustomModal

enum class Tool {
    TAREFAS,
    CALCULADORA,
    CONVIDADOS
}



@Composable
fun CalculadoraScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        FerramentasSection()
        Spacer(modifier = Modifier.height(10.dp))
        ControleDeGastoCard()
        Spacer(modifier = Modifier.height(10.dp))
        CategoriaScreen(navController = navController)
    }
}

