package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun BulletinCard(
    modifier: Modifier = Modifier,
    content: String,
    date: String
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = content,
            fontSize = 30.sp
        )
        Text(
            text = date
        )
    }
}