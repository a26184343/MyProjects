package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.studentproject.R

@Composable
fun SingleBulletinView(
    content: String,
    author: String,
    date: String,
    onClose: () -> Unit
) {
    Column(

    ) {
        Text(
            text = content
        )
        Text(
            text = author
        )
        Text(
            text = date
        )
    }
    Button(
        onClick = onClose
    ) {
        Text(stringResource(R.string.closeScreen))
    }
}