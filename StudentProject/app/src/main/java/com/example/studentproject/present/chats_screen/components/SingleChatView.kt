package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.studentproject.R
import com.example.studentproject.data.Chat
import com.example.studentproject.data.Message

@Composable
fun SingleChatView(
    modifier: Modifier = Modifier,
    data: Chat,
    messages: List<Message>,
    onClose: () -> Unit,
    message: String,
    onMessageChange: (String) -> Unit,
    onComment: () -> Unit,
) {
    Column() {
        SingleChatCard(
            data = data
        )
        MessagesList(messages = messages)
    }
    Button(
        modifier = modifier.padding(top = 550.dp, start = 310.dp, end = 10.dp, bottom = 120.dp),
        onClick = onClose
    ) {
        Text(stringResource(R.string.closeScreen))
    }
    MessageBar(
        message = message,
        onMessageChange = onMessageChange,
        onSend = onComment
    )
}