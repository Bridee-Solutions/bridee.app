package com.example.bridee.core.toast.property

import androidx.compose.ui.graphics.Color

interface ToastProperty {
    fun getResourceId(): Int
    fun getBackgroundColor(): Color
    fun getBorderColor(): Color
    fun getTextColor(): Color
}