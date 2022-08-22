package com.example.pic.present

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun switchPage() {
    var grid by remember {mutableStateOf(0)}
    var canvasOrImages by remember {mutableStateOf(true)}
    var imageCount by remember {mutableStateOf(0)}
    switchButtons(
        showGrid = {grid = (grid + 1) % 2},
        showCanvasAndRects = {canvasOrImages = true},
        showImages = {canvasOrImages = false},
        onePiece = {imageCount = 1},
        twoPieces = {imageCount = 2},
        threePieces = {imageCount = 3},
        fourPieces = {imageCount = 4},
        fivePieces = {imageCount = 5},
        sixPieces = {imageCount = 6},
        sevenPieces = {imageCount = 7}
    )
    if(grid % 2 == 1)
        drawGrid()
    else

    if(canvasOrImages)
        canvas(imageCount)
    else
        image(imageCount)
}

@Composable
fun switchButtons(
    showGrid:() -> Unit,
    showCanvasAndRects:() -> Unit,
    showImages:() -> Unit,
    onePiece:() -> Unit,
    twoPieces:() -> Unit,
    threePieces:() -> Unit,
    fourPieces:() -> Unit,
    fivePieces:() -> Unit,
    sixPieces:() -> Unit,
    sevenPieces:() -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = showGrid
            ) {
                Text("Show Grid")
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onePiece) {
                Text("1")
            }
            Button(onClick = twoPieces) {
                Text("2")
            }
            Button(onClick = threePieces) {
                Text("3")
            }
            Button(onClick = fourPieces) {
                Text("4")
            }
            Button(onClick = fivePieces) {
                Text("5")
            }
            Button(onClick = sixPieces) {
                Text("6")
            }
            Button(onClick = sevenPieces) {
                Text("7")
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = showCanvasAndRects) {
                Text("Show Canvas & rectangles")
            }
            Button(onClick = showImages) {
                Text("Show Images")
            }
        }
    }
}