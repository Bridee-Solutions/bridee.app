import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.bridee.R
import com.example.bridee.ui.theme.rosa

val qlassy = FontFamily(Font(R.font.qlassy))

@Composable
fun BrideeLogo(
    fontSize: TextUnit = 48.sp
) {
    val annotatedString = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontSize = fontSize,
                fontFamily = qlassy
            )
        ) {
            append("bridee")
        }


        withStyle(
            style = SpanStyle(
                color = rosa,
                fontSize = fontSize,
                fontFamily = qlassy
            )
        ) {
            append(".")
        }
    }

    Text(text = annotatedString)
}