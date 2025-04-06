package com.example.bridee.core.toast

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bridee.core.toast.property.Error
import com.example.bridee.core.toast.property.Success
import com.example.bridee.core.toast.property.ToastProperty
import com.example.bridee.core.toast.property.Warning


object ToastUtils{

    @Composable
    fun SuccessToast(
        message: String,
        duration: Int = Toast.LENGTH_LONG,
        contentAlignment: Alignment,
        padding: PaddingValues = PaddingValues(top = 16.dp, bottom = 100.dp),
    ){
        val successToast: CustomToast = CustomToast(LocalContext.current)
        successToast.MakeToast(
            message = message,
            duration = duration,
            contentAlignment = contentAlignment,
            padding = padding,
            type = Success()
        )
        successToast.show()
    }

    @Composable
    fun ErrorToast(
        message: String,
        duration: Int = Toast.LENGTH_LONG,
        contentAlignment: Alignment,
        padding: PaddingValues = PaddingValues(top = 16.dp, bottom = 100.dp)
    ){
        val errorToast = CustomToast(LocalContext.current)
        errorToast.MakeToast(
            message = message,
            duration = duration,
            contentAlignment = contentAlignment,
            padding = padding,
            type = Error()
        )
        errorToast.show()
    }

    @Composable
    fun WarningToast(
        message: String,
        duration: Int = Toast.LENGTH_LONG,
        contentAlignment: Alignment,
        padding: PaddingValues = PaddingValues(top = 16.dp, bottom = 100.dp),
    ){
        val warningToast: CustomToast = CustomToast(LocalContext.current)
        warningToast.MakeToast(
            message = message,
            duration = duration,
            contentAlignment = contentAlignment,
            padding = padding,
            type = Warning()
        )
        warningToast.show()
    }

    @Composable
    fun SetView(
        text: String,
        toastType: ToastProperty,
        padding: PaddingValues,
        contentAlignment: Alignment
    ){

        val backgroundColor = toastType.getBackgroundColor()
        val textColor = toastType.getTextColor()
        val resourceId = toastType.getResourceId()
        val borderColor = toastType.getBorderColor()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = contentAlignment
        ){
            Surface(
                modifier = Modifier
                    .wrapContentSize(),
                color = Color.Transparent
            ) {
                Row(
                    modifier = Modifier
                        .defaultMinSize(minHeight = 44.dp)
                        .fillMaxWidth()
                        .background(
                            color = backgroundColor
                        )
                        .border(
                            color = borderColor,
                            width = 2.dp
                        )
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = text,
                        color = textColor,
                        textAlign = TextAlign.Justify
                    )
                    Icon(
                        painter = painterResource(resourceId),
                        contentDescription = "Icone do Toast",
                        modifier = Modifier.padding(4.dp, 0.dp).size(24.dp),
                        tint = textColor
                    )
                }
            }
        }

    }
}
