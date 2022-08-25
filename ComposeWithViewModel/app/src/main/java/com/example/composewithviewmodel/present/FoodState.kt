package com.example.composewithviewmodel.present

data class FoodState(
    val currentFood: String = "",
    val currentPrice: Int? = 0,
    val noSuchFood: Boolean = false
)