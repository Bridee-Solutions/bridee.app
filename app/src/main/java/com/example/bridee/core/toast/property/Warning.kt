package com.example.bridee.core.toast.property

import androidx.compose.ui.graphics.Color
import com.example.bridee.R

class Warning: ToastProperty {
    //TODO: adicionar icone
    override fun getResourceId(): Int = R.drawable.ic_launcher_foreground

    override fun getBackgroundColor(): Color = Color(0xFFFFF3E5)

    override fun getBorderColor(): Color = Color(0xFFF4900C)

    override fun getTextColor(): Color = Color(0xFFF4900C)

}