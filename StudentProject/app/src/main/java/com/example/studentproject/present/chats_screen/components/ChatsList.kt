package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studentproject.data.Chat

@Composable
fun ChatsList(
    modifier: Modifier = Modifier,
    existChats: List<Chat>,
    onOpenChat: (Chat) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 70.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(existChats) { chat ->
            ChatCard(
                date = chat.date,
                title = chat.title,
                modifier = modifier
                    .clickable(onClick = {onOpenChat(Chat(
                        date = chat.date,
                        host = chat.host,
                        title = chat.title,
                        content = chat.content,
                    ))}
                    )
            )
        }
    }
}