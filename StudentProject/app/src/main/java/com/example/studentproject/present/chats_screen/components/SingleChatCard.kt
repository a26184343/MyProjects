package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.studentproject.data.Chat

@Composable
fun SingleChatCard(
    modifier: Modifier = Modifier,
    data: Chat
) {
    Column() {
        Text(data.title)
        Text(data.content)
        Row() {
            Text(data.host)
            Text(data.date)
        }
    }
}