package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.studentproject.data.Chat

@Composable
fun SingleChatCard(
    modifier: Modifier = Modifier,
    data: Chat
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = data.title,
            fontSize = 45.sp
        )
        Text(data.content)
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(data.host)
            Text(data.date)
        }
    }
}