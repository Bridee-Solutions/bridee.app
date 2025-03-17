package com.example.bridee.auth.presentation.component
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: Color = Color(0xFFB55557),
    unselectedColor: Color = Color(0xFF8D8D8D)
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .clickable { onClick() }
            .background(Color.Transparent, CircleShape),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(24.dp)
                .border(
                    width = 2.dp,
                    color = if (selected) selectedColor else unselectedColor,
                    shape = CircleShape
                )
        )

        if (selected) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(selectedColor, CircleShape)
            )
        }
    }
}