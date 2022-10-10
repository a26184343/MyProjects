package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.studentproject.R

@Composable
fun AddChatButton(
    modifier: Modifier = Modifier,
    onStartChat:() -> Unit
) {
    Button(
        onClick = onStartChat,
        modifier = modifier.padding(top = 570.dp, start = 260.dp, bottom = 60.dp, end = 20.dp)
    ) {
        Text(stringResource(R.string.saySomething))
    }
}