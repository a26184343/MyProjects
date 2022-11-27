package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatCard(
    modifier: Modifier = Modifier,
    title: String,
    date: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 25.sp
        )
        Text(
            text = date
        )
    }
}