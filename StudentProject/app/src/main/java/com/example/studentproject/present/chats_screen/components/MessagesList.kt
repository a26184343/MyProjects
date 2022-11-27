package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.studentproject.data.Message

@Composable
fun MessagesList(
    messages: List<Message>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messages) {message ->
            MessageCard(
                message = message.message,
                user = message.user,
                date = message.date
            )
        }
    }
}