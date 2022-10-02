package com.example.studentproject.present.demands_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DemandCard(
    modifier: Modifier = Modifier,
    title: String,
    date: String,
    solved: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column() {
            Text(
                text = title
            )
            Text(
                text = date
            )
        }
        Text(solved.toString())
    }
}