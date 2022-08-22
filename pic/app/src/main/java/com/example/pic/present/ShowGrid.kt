package com.example.pic.present

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pic.present.theme.PicTheme

@Composable
fun drawGrid() {
    //Text("Grid")
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        //app's size
        drawLine(
            start = Offset(x = 0f, y = h / 13 * 2.5f),
            end = Offset(x = w, y = h / 13 * 2.5f),
            color = Color.Red
        )
        drawLine(
            start = Offset(x = 0f, y = h / 13 * 10.5f),
            end = Offset(x = w, y = h / 13 * 10.5f),
            color = Color.Red
        )
        //row
        drawLine(
            start = Offset(x = 0f, y = h / 4f),
            end = Offset(x = w, y = h / 4f),
            color = Color.Gray
        )

        drawLine(
            start = Offset(x = 0f, y = h / 2f),
            end = Offset(x = w, y = h / 2f),
            color = Color.Gray
        )

        drawLine(
            start = Offset(x = 0f, y = h * 3 / 4f),
            end = Offset(x = w, y = h * 3 / 4f),
            color = Color.Gray
        )

        drawLine(
            start = Offset(x = w / 4f, y = 0f),
            end = Offset(x = w / 4f, y = h),
            color = Color.Gray
        )


        drawLine(
            start = Offset(x = w / 2f, y = 0f),
            end = Offset(x = w / 2f, y = h),
            color = Color.Gray
        )


        drawLine(
            start = Offset(x = w * 3 / 4f, y = 0f),
            end = Offset(x = w * 3 / 4f, y = h),
            color = Color.Gray
        )

    }
}

@Preview
@Composable
fun prev() {
    PicTheme {
        drawGrid()
    }
}