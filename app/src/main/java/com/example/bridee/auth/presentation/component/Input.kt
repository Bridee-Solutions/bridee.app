package com.example.bridee.auth.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Input(
    state: String,
    onStateChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: @Composable () -> Unit = {},
    singleLine: Boolean = true,
    height: Dp? = null,
    isValid: Boolean = true
){

    val windowWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val color = if(isValid || state.isBlank()) Color.LightGray else Color.Red

    TextField(
        value = state,
        onValueChange = onStateChange,
        visualTransformation = visualTransformation,
        placeholder = placeholder,
        modifier = Modifier
            .width(windowWidthDp - 45.dp)
            .then(height?.let {
                Modifier.height(it) } ?: Modifier)
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(30)
            )
            .border(
                BorderStroke(width = 2.dp, color = color),
                shape = RoundedCornerShape(30)
            ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = singleLine
    )
}