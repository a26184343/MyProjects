package com.example.studentproject.present.demands_screen

import com.example.studentproject.data.Demand

data class DemandsScreenState(
    val existDemands: List<Demand> = listOf(),
    val screenShouldShow: Int = 0, // 0 for list, 1 for add, 2 for single room

)
