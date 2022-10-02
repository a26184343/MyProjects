package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.studentproject.R

@Composable
fun AddBulletinButton(
    modifier: Modifier = Modifier,
    onAddBulletin: () -> Unit
) {
    Button(
        onClick = onAddBulletin,
        modifier = modifier
            .padding(top = 570.dp, start = 290.dp, bottom = 60.dp, end = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.plusItem)
        )
    }
}