package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.studentproject.R

@Composable
fun SingleBulletinView(
    modifier: Modifier = Modifier,
    content: String,
    author: String,
    date: String,
    onClose: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
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
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = modifier.size(50.dp),
                onClick = onClose
            ) {
                Text(stringResource(R.string.closeScreen))
            }
        }
    }
}