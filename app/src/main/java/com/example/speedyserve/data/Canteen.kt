package com.example.speedyserve.data

import android.media.Image
import com.example.speedyserve.R

data class Canteen(
    val name: String,
    val openingTime: String,
    val closingTime: String,
    val isOpen: Boolean
)

data class Dish(
    val image : Int,
    val name: String,
    val rating : Int,
    val price : Int,
)

val canteenList = listOf(
    Canteen("Viit Canteen", "9:30 am", "9:30 pm", true),
    Canteen("Library Canteen", "10:00 am", "8:00 pm", false),
    Canteen("Sports Complex Cafe", "8:00 am", "6:00 pm", true),
    Canteen("Admin Block Cafeteria", "9:00 am", "5:30 pm", false)
)

val dishesList = listOf(
    Dish(image = R.drawable.paneer_image,"Shevbhaji" , 4 , 40),
    Dish(image = R.drawable.paneer_image,"Paneer Bhaji" , 4 , 40),
    Dish(image = R.drawable.paneer_image,"Masala Rice" , 4 , 40),
)