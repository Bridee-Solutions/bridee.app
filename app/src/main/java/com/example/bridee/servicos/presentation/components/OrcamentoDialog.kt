package com.example.bridee.servicos.presentation.components
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*


import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.bridee.R
import com.example.bridee.ui.theme.rosa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrcamentoDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,
        title = {
            Text(
                "Solicitar orçamento e disponibilidade",
                style = MaterialTheme.typography.titleMedium
            )
        },
        text = {
            Column {
                Text("Nome do estabelecimento", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9))
                ) {
                    Column(Modifier.padding(12.dp)) {
                        InfoRow(
                            icon = painterResource(id = R.drawable.place),
                            text = "Amanda Geovanna")
                        InfoRow(
                            icon = painterResource(id = R.drawable.calendario),
                            text = "11 de Fevereiro, 2026")
                        InfoRow(
                            icon = painterResource(id = R.drawable.people),
                            text = "100 Convidados")
                        InfoRow(
                            icon = painterResource(id = R.drawable.money),
                            text = "R$100.000 Orçamento")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Mensagem")
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = "Olá! Encontramos seu anúncio no bridee e gostaríamos de ter mais informação sobre seus serviços!",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFFB1B1B1),
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color(0xFFF06292),
                        cursorColor = Color(0xFFF06292)
                    )
                )
            }
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = rosa,
                    contentColor = Color.White
                )
            ) {
                Text("Enviar", color = Color.White)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        },
        containerColor = Color.White
    )
}

