package com.example.bridee.configuracoes.presentation.components


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResultLauncher

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.EditableText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bridee.R
import com.example.bridee.core.navigation.Screen
import com.example.bridee.home.presentation.components.EditableText
import com.example.bridee.ui.theme.rosa
import coil.compose.rememberAsyncImagePainter

fun getFirstName(fullName: String): String {
    return fullName.split(" ").firstOrNull()?.replaceFirstChar { it.uppercase() } ?: fullName
}

@Composable
fun ProfileCard(
    navController: NavController,
    isEditing: Boolean,
    onEditClick: () -> Unit,
    name: String,
    loveName: String
) {
    var selectedImageUri by remember { mutableStateOf<String?>(null) }

    val imagePickerLauncher: ActivityResultLauncher<String> =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
            onResult = { uri ->
                selectedImageUri = uri.toString()
            }
        )

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Voltar",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.navigate(Screen.Home.route) },
                    tint = rosa
                )

                if (isEditing) {
                    Text(
                        text = "Salvar",
                        style = MaterialTheme.typography.bodyLarge.copy(color = rosa),
                        modifier = Modifier
                            .clickable { onEditClick() }
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = "Editar",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { onEditClick() },
                        tint = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .size(180.dp)
                    .background(Color.Gray, CircleShape)
                    .clickable(enabled = isEditing) {
                        if (isEditing) {
                            imagePickerLauncher.launch("image/*")
                        }
                    }
            ) {
                if (selectedImageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(model = selectedImageUri)
                        ,
                        contentDescription = "Imagem do perfil",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.defauult)
                        ,
                        contentDescription = "Imagem do perfil",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Text(
                text = "${getFirstName(name)} & ${getFirstName(loveName)}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 12.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(bottom = 30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.hour),
                    contentDescription = "Relógio",
                    tint = Color.LightGray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "350 dias",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.LightGray
                )
            }
        }
    }
}

