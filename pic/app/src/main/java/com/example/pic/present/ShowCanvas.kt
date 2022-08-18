package com.example.pic.present


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.withTransform
import kotlin.random.Random

fun random():Float {
    var t = Random.nextFloat() * 20
    var n = Random.nextInt() % 10
    if(n >5) return t
    return t * -1
}

@Composable
fun canvas(imageCount: Int) {
    //Text( "$imageCount")
    Canvas(modifier = Modifier.fillMaxSize()) {
        var s = size
        var w = size.width
        var h = size.height
        when(imageCount) {
            1 -> rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 4F, y = h / 4F),
                        size = s / 3F
                    )
                }
            2 -> {
                rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 8F, y = h / 8 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(x = w / 8 * 5F, y = h / 8 * 3F),
                        size = s / 4F
                    )
                }
            }
            3 -> {
                rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 8F, y = h / 8 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(x = w / 2F, y = h / 8 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Green,
                        topLeft = Offset(x = w / 4 * 3F, y = h / 8 * 3F),
                        size = s / 4F
                    )
                }
            }
            4 -> {
                rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 8F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(x = w / 8 * 5F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Green,
                        topLeft = Offset(x = w / 8F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Yellow,
                        topLeft = Offset(x = w / 8 * 5F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
            }
            5 -> {
                rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 8F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(x = w / 8 * 5F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Green,
                        topLeft = Offset(x = w / 7 * 0.5F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Yellow,
                        topLeft = Offset(x = w / 7 * 2.8F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Cyan,
                        topLeft = Offset(x = w / 7 * 4.6F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
            }
            6 -> {
                rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 7 * 0.5F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(x = w / 7 * 2.8F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Green,
                        topLeft = Offset(x = w / 7 * 4.6F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Yellow,
                        topLeft = Offset(x = w / 7 * 0.5F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Cyan,
                        topLeft = Offset(x = w / 7 * 2.8F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Magenta,
                        topLeft = Offset(x = w / 7 * 4.6F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
            }
            7 -> {
                rotate(random()) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(x = w / 7 * 0.5F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(x = w / 7 * 2.8F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Green,
                        topLeft = Offset(x = w / 7 * 4.6F, y = h / 13 * 3F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Yellow,
                        topLeft = Offset(x = w / 7 * 0.3F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Cyan,
                        topLeft = Offset(x = w / 7 * 1.9F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.Magenta,
                        topLeft = Offset(x = w / 7 * 3.5F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
                rotate(random()) {
                    drawRect(
                        color = Color.LightGray,
                        topLeft = Offset(x = w / 7 * 5.1F, y = h / 13 * 7F),
                        size = s / 4F
                    )
                }
            }
        }
    }
}