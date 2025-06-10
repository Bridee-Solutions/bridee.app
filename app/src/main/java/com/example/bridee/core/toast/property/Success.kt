package com.example.bridee.core.toast.property

import androidx.compose.ui.graphics.Color
import com.example.bridee.R

class Success: ToastProperty {
    //TODO: adicionar icone
    override fun getResourceId(): Int = R.drawable.ic_launcher_foreground

    override fun getBackgroundColor(): Color = Color(0xFFD8F5E3)

    override fun getBorderColor(): Color = Color(0xFF3ECA74)

    override fun getTextColor(): Color = Color(0xFF3ECA74)

}