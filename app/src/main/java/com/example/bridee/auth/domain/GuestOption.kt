package com.example.bridee.auth.domain

import androidx.compose.runtime.mutableStateListOf

data class GuestOption(
    var selected: Boolean = false,
    val value: String = ""
){
    fun createGuestOptions(): MutableList<GuestOption>{
        val option1 = GuestOption(value = "0-50")
        val option2 = GuestOption(value = "51-100")
        val option3 = GuestOption(value = "101-150")
        val option4 = GuestOption(value = "151-200")
        val option5 = GuestOption(value = "201-250")
        val option6 = GuestOption(value = "300")
        val option7 = GuestOption(value = "Ainda não \ntemos certeza")
        return mutableStateListOf(
            option1,
            option2,
            option3,
            option4,
            option5,
            option6,
            option7
        )
    }

    fun getQuantity(): Int{
        return when(value){
            "0-50" -> 50
            "51-100" -> 100
            "101-150" -> 150
            "151-200" -> 200
            "201-250" -> 250
            "300" -> 300
            else -> 0
        }
    }
}
