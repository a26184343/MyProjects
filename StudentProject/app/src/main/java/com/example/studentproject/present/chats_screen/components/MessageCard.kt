package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MessageCard(
    modifier: Modifier = Modifier,
    message: String,
    user: String,
    date: String
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = message,
            fontSize = 30.sp
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(user)
            Text(date)
        }
    }
}