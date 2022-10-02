package com.example.studentproject.present.bulletins_screen

import com.example.studentproject.data.Bulletin

data class BulletinsScreenState(
    val screenShouldShow: Int = 0,
    val existBulletins: List<Bulletin> = listOf(),
    val isAdmin: Boolean = false
)