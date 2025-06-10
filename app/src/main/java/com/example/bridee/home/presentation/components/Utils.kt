package com.example.bridee.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun EditableText(
    text: String,
    onTextChange: (String) -> Unit,
    isEditing: Boolean,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    if (isEditing) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            textStyle = textStyle.copy(color = Color.Black),
            modifier = modifier
                .width(280.dp)
                .background(Color(0xFFF4F4F4), RoundedCornerShape(8.dp))
                .border(0.5.dp, Color(0xFFC9C8C8), RoundedCornerShape(8.dp))
                .padding(2.dp),
            placeholder = {
                Text("Digite aqui", style = textStyle.copy(color = Color.Gray))
                          },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF4F4F4),
                unfocusedContainerColor = Color(0xFFF4F4F4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            shape = RoundedCornerShape(1.dp)
        )
    } else {
        Text(
            text = text,
            style = textStyle,
            modifier = modifier
        )
    }
}
