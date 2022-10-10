package com.example.studentproject.present.demands_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.studentproject.R

@Composable
fun SingleDemandView(
    title: String,
    content: String,
    author: String,
    createDate: String,
    solved: Boolean,
    onClose: () -> Unit
) {
    Column(

    ) {
        Text(
            text = solved.toString()
        )
        Text(
            text = title
        )
        Text(
            text = content
        )
        Row(

        ) {
            Text(
                text = author
            )
            Text(
                text = createDate
            )
        }
        Button(
            onClick = onClose
        ) {
                Text(stringResource(R.string.closeScreen))
        }
    }
}