package com.example.studentproject.present

import com.example.studentproject.data.Bulletin
import com.example.studentproject.data.Chat
import com.example.studentproject.data.NewUser

data class MainScreenState(
    val whichPageShouldShow: Int = 0,
    val showAddBulletinScreen: Boolean = false,
    val user: String = "",
    val password: String = "",
    val invalidUser: Boolean = false,
    val isLogin: Boolean = false,
    val existUser: List<NewUser> = listOf(),
    val existBulletin: List<Bulletin> = listOf(),
    val existChat: List<Chat> = listOf()
)