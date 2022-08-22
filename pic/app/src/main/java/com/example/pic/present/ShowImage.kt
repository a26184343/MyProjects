package com.example.pic.present

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pic.R


@Composable
fun image(imageCount: Int) {
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        when(imageCount) {
            1 -> {
                Image(
                    painter = painterResource(id = R.drawable.one),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
            }
            2 -> {
                Image(
                    painter = painterResource(id = R.drawable.one),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.two),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
            }
            3 -> {
                Image(
                    painter = painterResource(id = R.drawable.one),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.two),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.three),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
            }
            4 -> {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.three),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.two),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.four),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
            5 -> {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.four),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.three),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.two),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.five),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
            6 -> {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.four),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.two),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.five),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.three),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.six),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
            7 -> {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.two),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.three),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.four),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.five),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.six),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.seven),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
        }
    }
}