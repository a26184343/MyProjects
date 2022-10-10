package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MessageCard(
    message: String,
    user: String,
    date: String
) {
    Column() {
        Text(message)
        Row() {
            Text(user)
            Text(date)
        }
    }
}