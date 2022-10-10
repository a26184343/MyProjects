package com.example.studentproject.present.chats_screen

import com.example.studentproject.data.Chat
import com.example.studentproject.data.Message

data class ChatsScreenState(
    val screenShouldShow: Int = 0,
    val existChats: List<Chat> = listOf(),
    val titleError: Boolean = false,
    val contentError: Boolean = false,
    val messages: List<Message> = listOf()
)