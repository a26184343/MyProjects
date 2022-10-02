package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
            text = content
        )
        Text(
            text = date
        )
    }
}