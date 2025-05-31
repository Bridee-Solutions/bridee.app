package com.example.bridee.core.image_bitmap

import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

object ImageUtils {
    fun convertImageBase64ToBitMap(image: String): ImageBitmap{
        val byteArray = Base64.decode(image, Base64.DEFAULT)
        Log.d("Base64Decode", "Bytes: ${byteArray.size}")
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size).asImageBitmap()
    }
}


