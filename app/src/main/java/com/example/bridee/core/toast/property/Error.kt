package com.example.bridee.core.toast.property

import androidx.compose.ui.graphics.Color
import com.example.bridee.R

class Error: ToastProperty {
    //TODO: adicionar icon
    override fun getResourceId(): Int = R.drawable.ic_launcher_foreground

    override fun getBackgroundColor(): Color = Color(0xFFFFDCDC)

    override fun getBorderColor(): Color = Color(0xFFFD504F)

    override fun getTextColor(): Color = Color(0xFFFD504F)

}